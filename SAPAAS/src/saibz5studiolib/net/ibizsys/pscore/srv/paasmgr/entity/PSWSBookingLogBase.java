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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCWorkspace;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCWorkspaceService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSWorkspace;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSWorkspaceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWSBookingLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWSBookingLogBase.class);
    public static final String FIELD_BACKUPINFO = "BACKUPINFO";
    public static final String FIELD_BACKUPSTATE = "BACKUPSTATE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_BOOKINGINFO = "BOOKINGINFO";
    public static final String FIELD_BOOKINGPARAM = "BOOKINGPARAM";
    public static final String FIELD_BOOKINGPARAM2 = "BOOKINGPARAM2";
    public static final String FIELD_BOOKINGPARAM3 = "BOOKINGPARAM3";
    public static final String FIELD_BOOKINGPARAM4 = "BOOKINGPARAM4";
    public static final String FIELD_BOOKINGSTATE = "BOOKINGSTATE";
    public static final String FIELD_BOOKINGTYPE = "BOOKINGTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DURATION = "DURATION";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_HOURS = "HOURS";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCWORKSPACEID = "PSDCWORKSPACEID";
    public static final String FIELD_PSDCWORKSPACENAME = "PSDCWORKSPACENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_PSWORKSPACEID = "PSWORKSPACEID";
    public static final String FIELD_PSWORKSPACENAME = "PSWORKSPACENAME";
    public static final String FIELD_PSWSBOOKINGLOGID = "PSWSBOOKINGLOGID";
    public static final String FIELD_PSWSBOOKINGLOGNAME = "PSWSBOOKINGLOGNAME";
    public static final String FIELD_RESTOREINFO = "RESTOREINFO";
    public static final String FIELD_RESTORESTATE = "RESTORESTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKUPINFO = 0;
    private static final int INDEX_BACKUPSTATE = 1;
    private static final int INDEX_BEGINTIME = 2;
    private static final int INDEX_BOOKINGINFO = 3;
    private static final int INDEX_BOOKINGPARAM = 4;
    private static final int INDEX_BOOKINGPARAM2 = 5;
    private static final int INDEX_BOOKINGPARAM3 = 6;
    private static final int INDEX_BOOKINGPARAM4 = 7;
    private static final int INDEX_BOOKINGSTATE = 8;
    private static final int INDEX_BOOKINGTYPE = 9;
    private static final int INDEX_CREATEDATE = 10;
    private static final int INDEX_CREATEMAN = 11;
    private static final int INDEX_DURATION = 12;
    private static final int INDEX_ENDTIME = 13;
    private static final int INDEX_HOURS = 14;
    private static final int INDEX_LOGINFO = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_PSDCWORKSPACEID = 17;
    private static final int INDEX_PSDCWORKSPACENAME = 18;
    private static final int INDEX_PSDEVCENTERID = 19;
    private static final int INDEX_PSDEVCENTERNAME = 20;
    private static final int INDEX_PSSVRDOMAINID = 21;
    private static final int INDEX_PSSVRDOMAINNAME = 22;
    private static final int INDEX_PSTASKSERVERID = 23;
    private static final int INDEX_PSTASKSERVERNAME = 24;
    private static final int INDEX_PSWORKSPACEID = 25;
    private static final int INDEX_PSWORKSPACENAME = 26;
    private static final int INDEX_PSWSBOOKINGLOGID = 27;
    private static final int INDEX_PSWSBOOKINGLOGNAME = 28;
    private static final int INDEX_RESTOREINFO = 29;
    private static final int INDEX_RESTORESTATE = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWSBookingLogBase proxyPSWSBookingLogBase = null;
    private boolean backupinfoDirtyFlag = false;
    private boolean backupstateDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean bookinginfoDirtyFlag = false;
    private boolean bookingparamDirtyFlag = false;
    private boolean bookingparam2DirtyFlag = false;
    private boolean bookingparam3DirtyFlag = false;
    private boolean bookingparam4DirtyFlag = false;
    private boolean bookingstateDirtyFlag = false;
    private boolean bookingtypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean durationDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean hoursDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcworkspaceidDirtyFlag = false;
    private boolean psdcworkspacenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean psworkspaceidDirtyFlag = false;
    private boolean psworkspacenameDirtyFlag = false;
    private boolean pswsbookinglogidDirtyFlag = false;
    private boolean pswsbookinglognameDirtyFlag = false;
    private boolean restoreinfoDirtyFlag = false;
    private boolean restorestateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backupinfo")
    private String backupinfo;
    @Column(name="backupstate")
    private Integer backupstate;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="bookinginfo")
    private String bookinginfo;
    @Column(name="bookingparam")
    private String bookingparam;
    @Column(name="bookingparam2")
    private String bookingparam2;
    @Column(name="bookingparam3")
    private String bookingparam3;
    @Column(name="bookingparam4")
    private String bookingparam4;
    @Column(name="bookingstate")
    private Integer bookingstate;
    @Column(name="bookingtype")
    private String bookingtype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="duration")
    private Integer duration;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="hours")
    private Integer hours;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcworkspaceid")
    private String psdcworkspaceid;
    @Column(name="psdcworkspacename")
    private String psdcworkspacename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="psworkspaceid")
    private String psworkspaceid;
    @Column(name="psworkspacename")
    private String psworkspacename;
    @Column(name="pswsbookinglogid")
    private String pswsbookinglogid;
    @Column(name="pswsbookinglogname")
    private String pswsbookinglogname;
    @Column(name="restoreinfo")
    private String restoreinfo;
    @Column(name="restorestate")
    private Integer restorestate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCWorkspaceLock = new Integer(1);
    private PSDCWorkspace psdcworkspace = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSSvrDomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSWorkspaceLock = new Integer(1);
    private PSWorkspace psworkspace = null;

    public void setBackupInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backupinfo = string;
        this.backupinfoDirtyFlag = true;
    }

    public String getBackupInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupInfo();
        }
        return this.backupinfo;
    }

    public boolean isBackupInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupInfoDirty();
        }
        return this.backupinfoDirtyFlag;
    }

    public void resetBackupInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupInfo();
            return;
        }
        this.backupinfoDirtyFlag = false;
        this.backupinfo = null;
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

    public void setBookingInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookinginfo = string;
        this.bookinginfoDirtyFlag = true;
    }

    public String getBookingInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingInfo();
        }
        return this.bookinginfo;
    }

    public boolean isBookingInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingInfoDirty();
        }
        return this.bookinginfoDirtyFlag;
    }

    public void resetBookingInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingInfo();
            return;
        }
        this.bookinginfoDirtyFlag = false;
        this.bookinginfo = null;
    }

    public void setBookingParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookingparam = string;
        this.bookingparamDirtyFlag = true;
    }

    public String getBookingParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingParam();
        }
        return this.bookingparam;
    }

    public boolean isBookingParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingParamDirty();
        }
        return this.bookingparamDirtyFlag;
    }

    public void resetBookingParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingParam();
            return;
        }
        this.bookingparamDirtyFlag = false;
        this.bookingparam = null;
    }

    public void setBookingParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookingparam2 = string;
        this.bookingparam2DirtyFlag = true;
    }

    public String getBookingParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingParam2();
        }
        return this.bookingparam2;
    }

    public boolean isBookingParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingParam2Dirty();
        }
        return this.bookingparam2DirtyFlag;
    }

    public void resetBookingParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingParam2();
            return;
        }
        this.bookingparam2DirtyFlag = false;
        this.bookingparam2 = null;
    }

    public void setBookingParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookingparam3 = string;
        this.bookingparam3DirtyFlag = true;
    }

    public String getBookingParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingParam3();
        }
        return this.bookingparam3;
    }

    public boolean isBookingParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingParam3Dirty();
        }
        return this.bookingparam3DirtyFlag;
    }

    public void resetBookingParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingParam3();
            return;
        }
        this.bookingparam3DirtyFlag = false;
        this.bookingparam3 = null;
    }

    public void setBookingParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookingparam4 = string;
        this.bookingparam4DirtyFlag = true;
    }

    public String getBookingParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingParam4();
        }
        return this.bookingparam4;
    }

    public boolean isBookingParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingParam4Dirty();
        }
        return this.bookingparam4DirtyFlag;
    }

    public void resetBookingParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingParam4();
            return;
        }
        this.bookingparam4DirtyFlag = false;
        this.bookingparam4 = null;
    }

    public void setBookingState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingState(n);
            return;
        }
        this.bookingstate = n;
        this.bookingstateDirtyFlag = true;
    }

    public Integer getBookingState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingState();
        }
        return this.bookingstate;
    }

    public boolean isBookingStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingStateDirty();
        }
        return this.bookingstateDirtyFlag;
    }

    public void resetBookingState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingState();
            return;
        }
        this.bookingstateDirtyFlag = false;
        this.bookingstate = null;
    }

    public void setBookingType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBookingType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bookingtype = string;
        this.bookingtypeDirtyFlag = true;
    }

    public String getBookingType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBookingType();
        }
        return this.bookingtype;
    }

    public boolean isBookingTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBookingTypeDirty();
        }
        return this.bookingtypeDirtyFlag;
    }

    public void resetBookingType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBookingType();
            return;
        }
        this.bookingtypeDirtyFlag = false;
        this.bookingtype = null;
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

    public void setDuration(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDuration(n);
            return;
        }
        this.duration = n;
        this.durationDirtyFlag = true;
    }

    public Integer getDuration() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDuration();
        }
        return this.duration;
    }

    public boolean isDurationDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDurationDirty();
        }
        return this.durationDirtyFlag;
    }

    public void resetDuration() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDuration();
            return;
        }
        this.durationDirtyFlag = false;
        this.duration = null;
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

    public void setPSDCWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspaceid = string;
        this.psdcworkspaceidDirtyFlag = true;
    }

    public String getPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceId();
        }
        return this.psdcworkspaceid;
    }

    public boolean isPSDCWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceIdDirty();
        }
        return this.psdcworkspaceidDirtyFlag;
    }

    public void resetPSDCWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceId();
            return;
        }
        this.psdcworkspaceidDirtyFlag = false;
        this.psdcworkspaceid = null;
    }

    public void setPSDCWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcworkspacename = string;
        this.psdcworkspacenameDirtyFlag = true;
    }

    public String getPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspaceName();
        }
        return this.psdcworkspacename;
    }

    public boolean isPSDCWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCWorkspaceNameDirty();
        }
        return this.psdcworkspacenameDirtyFlag;
    }

    public void resetPSDCWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCWorkspaceName();
            return;
        }
        this.psdcworkspacenameDirtyFlag = false;
        this.psdcworkspacename = null;
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

    public void setPSSvrDomainId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainid = string;
        this.pssvrdomainidDirtyFlag = true;
    }

    public String getPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainId();
        }
        return this.pssvrdomainid;
    }

    public boolean isPSSvrDomainIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainIdDirty();
        }
        return this.pssvrdomainidDirtyFlag;
    }

    public void resetPSSvrDomainId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainId();
            return;
        }
        this.pssvrdomainidDirtyFlag = false;
        this.pssvrdomainid = null;
    }

    public void setPSSvrDomainName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSvrDomainName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssvrdomainname = string;
        this.pssvrdomainnameDirtyFlag = true;
    }

    public String getPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomainName();
        }
        return this.pssvrdomainname;
    }

    public boolean isPSSvrDomainNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSvrDomainNameDirty();
        }
        return this.pssvrdomainnameDirtyFlag;
    }

    public void resetPSSvrDomainName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSvrDomainName();
            return;
        }
        this.pssvrdomainnameDirtyFlag = false;
        this.pssvrdomainname = null;
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

    public void setPSWorkspaceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspaceid = string;
        this.psworkspaceidDirtyFlag = true;
    }

    public String getPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceId();
        }
        return this.psworkspaceid;
    }

    public boolean isPSWorkspaceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceIdDirty();
        }
        return this.psworkspaceidDirtyFlag;
    }

    public void resetPSWorkspaceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceId();
            return;
        }
        this.psworkspaceidDirtyFlag = false;
        this.psworkspaceid = null;
    }

    public void setPSWorkspaceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWorkspaceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psworkspacename = string;
        this.psworkspacenameDirtyFlag = true;
    }

    public String getPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspaceName();
        }
        return this.psworkspacename;
    }

    public boolean isPSWorkspaceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWorkspaceNameDirty();
        }
        return this.psworkspacenameDirtyFlag;
    }

    public void resetPSWorkspaceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWorkspaceName();
            return;
        }
        this.psworkspacenameDirtyFlag = false;
        this.psworkspacename = null;
    }

    public void setPSWSBookingLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWSBookingLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswsbookinglogid = string;
        this.pswsbookinglogidDirtyFlag = true;
    }

    public String getPSWSBookingLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWSBookingLogId();
        }
        return this.pswsbookinglogid;
    }

    public boolean isPSWSBookingLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWSBookingLogIdDirty();
        }
        return this.pswsbookinglogidDirtyFlag;
    }

    public void resetPSWSBookingLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWSBookingLogId();
            return;
        }
        this.pswsbookinglogidDirtyFlag = false;
        this.pswsbookinglogid = null;
    }

    public void setPSWSBookingLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWSBookingLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswsbookinglogname = string;
        this.pswsbookinglognameDirtyFlag = true;
    }

    public String getPSWSBookingLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWSBookingLogName();
        }
        return this.pswsbookinglogname;
    }

    public boolean isPSWSBookingLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWSBookingLogNameDirty();
        }
        return this.pswsbookinglognameDirtyFlag;
    }

    public void resetPSWSBookingLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWSBookingLogName();
            return;
        }
        this.pswsbookinglognameDirtyFlag = false;
        this.pswsbookinglogname = null;
    }

    public void setRestoreInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRestoreInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.restoreinfo = string;
        this.restoreinfoDirtyFlag = true;
    }

    public String getRestoreInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRestoreInfo();
        }
        return this.restoreinfo;
    }

    public boolean isRestoreInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRestoreInfoDirty();
        }
        return this.restoreinfoDirtyFlag;
    }

    public void resetRestoreInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRestoreInfo();
            return;
        }
        this.restoreinfoDirtyFlag = false;
        this.restoreinfo = null;
    }

    public void setRestoreState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRestoreState(n);
            return;
        }
        this.restorestate = n;
        this.restorestateDirtyFlag = true;
    }

    public Integer getRestoreState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRestoreState();
        }
        return this.restorestate;
    }

    public boolean isRestoreStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRestoreStateDirty();
        }
        return this.restorestateDirtyFlag;
    }

    public void resetRestoreState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRestoreState();
            return;
        }
        this.restorestateDirtyFlag = false;
        this.restorestate = null;
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
        PSWSBookingLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWSBookingLogBase pSWSBookingLogBase) {
        pSWSBookingLogBase.resetBackupInfo();
        pSWSBookingLogBase.resetBackupState();
        pSWSBookingLogBase.resetBeginTime();
        pSWSBookingLogBase.resetBookingInfo();
        pSWSBookingLogBase.resetBookingParam();
        pSWSBookingLogBase.resetBookingParam2();
        pSWSBookingLogBase.resetBookingParam3();
        pSWSBookingLogBase.resetBookingParam4();
        pSWSBookingLogBase.resetBookingState();
        pSWSBookingLogBase.resetBookingType();
        pSWSBookingLogBase.resetCreateDate();
        pSWSBookingLogBase.resetCreateMan();
        pSWSBookingLogBase.resetDuration();
        pSWSBookingLogBase.resetEndTime();
        pSWSBookingLogBase.resetHours();
        pSWSBookingLogBase.resetLogInfo();
        pSWSBookingLogBase.resetMemo();
        pSWSBookingLogBase.resetPSDCWorkspaceId();
        pSWSBookingLogBase.resetPSDCWorkspaceName();
        pSWSBookingLogBase.resetPSDevCenterId();
        pSWSBookingLogBase.resetPSDevCenterName();
        pSWSBookingLogBase.resetPSSvrDomainId();
        pSWSBookingLogBase.resetPSSvrDomainName();
        pSWSBookingLogBase.resetPSTaskServerId();
        pSWSBookingLogBase.resetPSTaskServerName();
        pSWSBookingLogBase.resetPSWorkspaceId();
        pSWSBookingLogBase.resetPSWorkspaceName();
        pSWSBookingLogBase.resetPSWSBookingLogId();
        pSWSBookingLogBase.resetPSWSBookingLogName();
        pSWSBookingLogBase.resetRestoreInfo();
        pSWSBookingLogBase.resetRestoreState();
        pSWSBookingLogBase.resetUpdateDate();
        pSWSBookingLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupInfoDirty()) {
            hashMap.put(FIELD_BACKUPINFO, this.getBackupInfo());
        }
        if (!bl || this.isBackupStateDirty()) {
            hashMap.put(FIELD_BACKUPSTATE, this.getBackupState());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isBookingInfoDirty()) {
            hashMap.put(FIELD_BOOKINGINFO, this.getBookingInfo());
        }
        if (!bl || this.isBookingParamDirty()) {
            hashMap.put(FIELD_BOOKINGPARAM, this.getBookingParam());
        }
        if (!bl || this.isBookingParam2Dirty()) {
            hashMap.put(FIELD_BOOKINGPARAM2, this.getBookingParam2());
        }
        if (!bl || this.isBookingParam3Dirty()) {
            hashMap.put(FIELD_BOOKINGPARAM3, this.getBookingParam3());
        }
        if (!bl || this.isBookingParam4Dirty()) {
            hashMap.put(FIELD_BOOKINGPARAM4, this.getBookingParam4());
        }
        if (!bl || this.isBookingStateDirty()) {
            hashMap.put(FIELD_BOOKINGSTATE, this.getBookingState());
        }
        if (!bl || this.isBookingTypeDirty()) {
            hashMap.put(FIELD_BOOKINGTYPE, this.getBookingType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDurationDirty()) {
            hashMap.put(FIELD_DURATION, this.getDuration());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACEID, this.getPSDCWorkspaceId());
        }
        if (!bl || this.isPSDCWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSDCWORKSPACENAME, this.getPSDCWorkspaceName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isPSWorkspaceIdDirty()) {
            hashMap.put(FIELD_PSWORKSPACEID, this.getPSWorkspaceId());
        }
        if (!bl || this.isPSWorkspaceNameDirty()) {
            hashMap.put(FIELD_PSWORKSPACENAME, this.getPSWorkspaceName());
        }
        if (!bl || this.isPSWSBookingLogIdDirty()) {
            hashMap.put(FIELD_PSWSBOOKINGLOGID, this.getPSWSBookingLogId());
        }
        if (!bl || this.isPSWSBookingLogNameDirty()) {
            hashMap.put(FIELD_PSWSBOOKINGLOGNAME, this.getPSWSBookingLogName());
        }
        if (!bl || this.isRestoreInfoDirty()) {
            hashMap.put(FIELD_RESTOREINFO, this.getRestoreInfo());
        }
        if (!bl || this.isRestoreStateDirty()) {
            hashMap.put(FIELD_RESTORESTATE, this.getRestoreState());
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
        return PSWSBookingLogBase.get(this, n);
    }

    private static Object get(PSWSBookingLogBase pSWSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingLogBase.getBackupInfo();
            }
            case 1: {
                return pSWSBookingLogBase.getBackupState();
            }
            case 2: {
                return pSWSBookingLogBase.getBeginTime();
            }
            case 3: {
                return pSWSBookingLogBase.getBookingInfo();
            }
            case 4: {
                return pSWSBookingLogBase.getBookingParam();
            }
            case 5: {
                return pSWSBookingLogBase.getBookingParam2();
            }
            case 6: {
                return pSWSBookingLogBase.getBookingParam3();
            }
            case 7: {
                return pSWSBookingLogBase.getBookingParam4();
            }
            case 8: {
                return pSWSBookingLogBase.getBookingState();
            }
            case 9: {
                return pSWSBookingLogBase.getBookingType();
            }
            case 10: {
                return pSWSBookingLogBase.getCreateDate();
            }
            case 11: {
                return pSWSBookingLogBase.getCreateMan();
            }
            case 12: {
                return pSWSBookingLogBase.getDuration();
            }
            case 13: {
                return pSWSBookingLogBase.getEndTime();
            }
            case 14: {
                return pSWSBookingLogBase.getHours();
            }
            case 15: {
                return pSWSBookingLogBase.getLogInfo();
            }
            case 16: {
                return pSWSBookingLogBase.getMemo();
            }
            case 17: {
                return pSWSBookingLogBase.getPSDCWorkspaceId();
            }
            case 18: {
                return pSWSBookingLogBase.getPSDCWorkspaceName();
            }
            case 19: {
                return pSWSBookingLogBase.getPSDevCenterId();
            }
            case 20: {
                return pSWSBookingLogBase.getPSDevCenterName();
            }
            case 21: {
                return pSWSBookingLogBase.getPSSvrDomainId();
            }
            case 22: {
                return pSWSBookingLogBase.getPSSvrDomainName();
            }
            case 23: {
                return pSWSBookingLogBase.getPSTaskServerId();
            }
            case 24: {
                return pSWSBookingLogBase.getPSTaskServerName();
            }
            case 25: {
                return pSWSBookingLogBase.getPSWorkspaceId();
            }
            case 26: {
                return pSWSBookingLogBase.getPSWorkspaceName();
            }
            case 27: {
                return pSWSBookingLogBase.getPSWSBookingLogId();
            }
            case 28: {
                return pSWSBookingLogBase.getPSWSBookingLogName();
            }
            case 29: {
                return pSWSBookingLogBase.getRestoreInfo();
            }
            case 30: {
                return pSWSBookingLogBase.getRestoreState();
            }
            case 31: {
                return pSWSBookingLogBase.getUpdateDate();
            }
            case 32: {
                return pSWSBookingLogBase.getUpdateMan();
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
        PSWSBookingLogBase.set(this, n, object);
    }

    private static void set(PSWSBookingLogBase pSWSBookingLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWSBookingLogBase.setBackupInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWSBookingLogBase.setBackupState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSWSBookingLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSWSBookingLogBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWSBookingLogBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWSBookingLogBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWSBookingLogBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWSBookingLogBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWSBookingLogBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSWSBookingLogBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWSBookingLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSWSBookingLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSWSBookingLogBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWSBookingLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSWSBookingLogBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSWSBookingLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWSBookingLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWSBookingLogBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWSBookingLogBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWSBookingLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWSBookingLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWSBookingLogBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWSBookingLogBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWSBookingLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWSBookingLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWSBookingLogBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWSBookingLogBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSWSBookingLogBase.setPSWSBookingLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSWSBookingLogBase.setPSWSBookingLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSWSBookingLogBase.setRestoreInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSWSBookingLogBase.setRestoreState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSWSBookingLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSWSBookingLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWSBookingLogBase.isNull(this, n);
    }

    private static boolean isNull(PSWSBookingLogBase pSWSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingLogBase.getBackupInfo() == null;
            }
            case 1: {
                return pSWSBookingLogBase.getBackupState() == null;
            }
            case 2: {
                return pSWSBookingLogBase.getBeginTime() == null;
            }
            case 3: {
                return pSWSBookingLogBase.getBookingInfo() == null;
            }
            case 4: {
                return pSWSBookingLogBase.getBookingParam() == null;
            }
            case 5: {
                return pSWSBookingLogBase.getBookingParam2() == null;
            }
            case 6: {
                return pSWSBookingLogBase.getBookingParam3() == null;
            }
            case 7: {
                return pSWSBookingLogBase.getBookingParam4() == null;
            }
            case 8: {
                return pSWSBookingLogBase.getBookingState() == null;
            }
            case 9: {
                return pSWSBookingLogBase.getBookingType() == null;
            }
            case 10: {
                return pSWSBookingLogBase.getCreateDate() == null;
            }
            case 11: {
                return pSWSBookingLogBase.getCreateMan() == null;
            }
            case 12: {
                return pSWSBookingLogBase.getDuration() == null;
            }
            case 13: {
                return pSWSBookingLogBase.getEndTime() == null;
            }
            case 14: {
                return pSWSBookingLogBase.getHours() == null;
            }
            case 15: {
                return pSWSBookingLogBase.getLogInfo() == null;
            }
            case 16: {
                return pSWSBookingLogBase.getMemo() == null;
            }
            case 17: {
                return pSWSBookingLogBase.getPSDCWorkspaceId() == null;
            }
            case 18: {
                return pSWSBookingLogBase.getPSDCWorkspaceName() == null;
            }
            case 19: {
                return pSWSBookingLogBase.getPSDevCenterId() == null;
            }
            case 20: {
                return pSWSBookingLogBase.getPSDevCenterName() == null;
            }
            case 21: {
                return pSWSBookingLogBase.getPSSvrDomainId() == null;
            }
            case 22: {
                return pSWSBookingLogBase.getPSSvrDomainName() == null;
            }
            case 23: {
                return pSWSBookingLogBase.getPSTaskServerId() == null;
            }
            case 24: {
                return pSWSBookingLogBase.getPSTaskServerName() == null;
            }
            case 25: {
                return pSWSBookingLogBase.getPSWorkspaceId() == null;
            }
            case 26: {
                return pSWSBookingLogBase.getPSWorkspaceName() == null;
            }
            case 27: {
                return pSWSBookingLogBase.getPSWSBookingLogId() == null;
            }
            case 28: {
                return pSWSBookingLogBase.getPSWSBookingLogName() == null;
            }
            case 29: {
                return pSWSBookingLogBase.getRestoreInfo() == null;
            }
            case 30: {
                return pSWSBookingLogBase.getRestoreState() == null;
            }
            case 31: {
                return pSWSBookingLogBase.getUpdateDate() == null;
            }
            case 32: {
                return pSWSBookingLogBase.getUpdateMan() == null;
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
        return PSWSBookingLogBase.contains(this, n);
    }

    private static boolean contains(PSWSBookingLogBase pSWSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingLogBase.isBackupInfoDirty();
            }
            case 1: {
                return pSWSBookingLogBase.isBackupStateDirty();
            }
            case 2: {
                return pSWSBookingLogBase.isBeginTimeDirty();
            }
            case 3: {
                return pSWSBookingLogBase.isBookingInfoDirty();
            }
            case 4: {
                return pSWSBookingLogBase.isBookingParamDirty();
            }
            case 5: {
                return pSWSBookingLogBase.isBookingParam2Dirty();
            }
            case 6: {
                return pSWSBookingLogBase.isBookingParam3Dirty();
            }
            case 7: {
                return pSWSBookingLogBase.isBookingParam4Dirty();
            }
            case 8: {
                return pSWSBookingLogBase.isBookingStateDirty();
            }
            case 9: {
                return pSWSBookingLogBase.isBookingTypeDirty();
            }
            case 10: {
                return pSWSBookingLogBase.isCreateDateDirty();
            }
            case 11: {
                return pSWSBookingLogBase.isCreateManDirty();
            }
            case 12: {
                return pSWSBookingLogBase.isDurationDirty();
            }
            case 13: {
                return pSWSBookingLogBase.isEndTimeDirty();
            }
            case 14: {
                return pSWSBookingLogBase.isHoursDirty();
            }
            case 15: {
                return pSWSBookingLogBase.isLogInfoDirty();
            }
            case 16: {
                return pSWSBookingLogBase.isMemoDirty();
            }
            case 17: {
                return pSWSBookingLogBase.isPSDCWorkspaceIdDirty();
            }
            case 18: {
                return pSWSBookingLogBase.isPSDCWorkspaceNameDirty();
            }
            case 19: {
                return pSWSBookingLogBase.isPSDevCenterIdDirty();
            }
            case 20: {
                return pSWSBookingLogBase.isPSDevCenterNameDirty();
            }
            case 21: {
                return pSWSBookingLogBase.isPSSvrDomainIdDirty();
            }
            case 22: {
                return pSWSBookingLogBase.isPSSvrDomainNameDirty();
            }
            case 23: {
                return pSWSBookingLogBase.isPSTaskServerIdDirty();
            }
            case 24: {
                return pSWSBookingLogBase.isPSTaskServerNameDirty();
            }
            case 25: {
                return pSWSBookingLogBase.isPSWorkspaceIdDirty();
            }
            case 26: {
                return pSWSBookingLogBase.isPSWorkspaceNameDirty();
            }
            case 27: {
                return pSWSBookingLogBase.isPSWSBookingLogIdDirty();
            }
            case 28: {
                return pSWSBookingLogBase.isPSWSBookingLogNameDirty();
            }
            case 29: {
                return pSWSBookingLogBase.isRestoreInfoDirty();
            }
            case 30: {
                return pSWSBookingLogBase.isRestoreStateDirty();
            }
            case 31: {
                return pSWSBookingLogBase.isUpdateDateDirty();
            }
            case 32: {
                return pSWSBookingLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWSBookingLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWSBookingLogBase pSWSBookingLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWSBookingLogBase.getBackupInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupinfo", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBackupInfo()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBackupState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupstate", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBackupState()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingState()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getBookingType()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getDuration()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getHours()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSWSBookingLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswsbookinglogid", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSWSBookingLogId()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getPSWSBookingLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswsbookinglogname", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getPSWSBookingLogName()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getRestoreInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restoreinfo", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getRestoreInfo()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getRestoreState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restorestate", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getRestoreState()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWSBookingLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWSBookingLogBase.getJSONValue((Object)pSWSBookingLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWSBookingLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWSBookingLogBase pSWSBookingLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWSBookingLogBase.getBackupInfo() != null) {
            object = pSWSBookingLogBase.getBackupInfo();
            xmlNode.setAttribute(FIELD_BACKUPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBackupState() != null) {
            object = pSWSBookingLogBase.getBackupState();
            xmlNode.setAttribute(FIELD_BACKUPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getBeginTime() != null) {
            object = pSWSBookingLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getBookingInfo() != null) {
            object = pSWSBookingLogBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBookingParam() != null) {
            object = pSWSBookingLogBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBookingParam2() != null) {
            object = pSWSBookingLogBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBookingParam3() != null) {
            object = pSWSBookingLogBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBookingParam4() != null) {
            object = pSWSBookingLogBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getBookingState() != null) {
            object = pSWSBookingLogBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getBookingType() != null) {
            object = pSWSBookingLogBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getCreateDate() != null) {
            object = pSWSBookingLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getCreateMan() != null) {
            object = pSWSBookingLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getDuration() != null) {
            object = pSWSBookingLogBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getEndTime() != null) {
            object = pSWSBookingLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getHours() != null) {
            object = pSWSBookingLogBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getLogInfo() != null) {
            object = pSWSBookingLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getMemo() != null) {
            object = pSWSBookingLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSDCWorkspaceId() != null) {
            object = pSWSBookingLogBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSDCWorkspaceName() != null) {
            object = pSWSBookingLogBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSDevCenterId() != null) {
            object = pSWSBookingLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSDevCenterName() != null) {
            object = pSWSBookingLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSSvrDomainId() != null) {
            object = pSWSBookingLogBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSSvrDomainName() != null) {
            object = pSWSBookingLogBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSTaskServerId() != null) {
            object = pSWSBookingLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSTaskServerName() != null) {
            object = pSWSBookingLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSWorkspaceId() != null) {
            object = pSWSBookingLogBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSWorkspaceName() != null) {
            object = pSWSBookingLogBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSWSBookingLogId() != null) {
            object = pSWSBookingLogBase.getPSWSBookingLogId();
            xmlNode.setAttribute(FIELD_PSWSBOOKINGLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getPSWSBookingLogName() != null) {
            object = pSWSBookingLogBase.getPSWSBookingLogName();
            xmlNode.setAttribute(FIELD_PSWSBOOKINGLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getRestoreInfo() != null) {
            object = pSWSBookingLogBase.getRestoreInfo();
            xmlNode.setAttribute(FIELD_RESTOREINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingLogBase.getRestoreState() != null) {
            object = pSWSBookingLogBase.getRestoreState();
            xmlNode.setAttribute(FIELD_RESTORESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getUpdateDate() != null) {
            object = pSWSBookingLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingLogBase.getUpdateMan() != null) {
            object = pSWSBookingLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWSBookingLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWSBookingLogBase pSWSBookingLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWSBookingLogBase.isBackupInfoDirty() && (bl || pSWSBookingLogBase.getBackupInfo() != null)) {
            iDataObject.set(FIELD_BACKUPINFO, (Object)pSWSBookingLogBase.getBackupInfo());
        }
        if (pSWSBookingLogBase.isBackupStateDirty() && (bl || pSWSBookingLogBase.getBackupState() != null)) {
            iDataObject.set(FIELD_BACKUPSTATE, (Object)pSWSBookingLogBase.getBackupState());
        }
        if (pSWSBookingLogBase.isBeginTimeDirty() && (bl || pSWSBookingLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSWSBookingLogBase.getBeginTime());
        }
        if (pSWSBookingLogBase.isBookingInfoDirty() && (bl || pSWSBookingLogBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSWSBookingLogBase.getBookingInfo());
        }
        if (pSWSBookingLogBase.isBookingParamDirty() && (bl || pSWSBookingLogBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSWSBookingLogBase.getBookingParam());
        }
        if (pSWSBookingLogBase.isBookingParam2Dirty() && (bl || pSWSBookingLogBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSWSBookingLogBase.getBookingParam2());
        }
        if (pSWSBookingLogBase.isBookingParam3Dirty() && (bl || pSWSBookingLogBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSWSBookingLogBase.getBookingParam3());
        }
        if (pSWSBookingLogBase.isBookingParam4Dirty() && (bl || pSWSBookingLogBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSWSBookingLogBase.getBookingParam4());
        }
        if (pSWSBookingLogBase.isBookingStateDirty() && (bl || pSWSBookingLogBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSWSBookingLogBase.getBookingState());
        }
        if (pSWSBookingLogBase.isBookingTypeDirty() && (bl || pSWSBookingLogBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSWSBookingLogBase.getBookingType());
        }
        if (pSWSBookingLogBase.isCreateDateDirty() && (bl || pSWSBookingLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWSBookingLogBase.getCreateDate());
        }
        if (pSWSBookingLogBase.isCreateManDirty() && (bl || pSWSBookingLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWSBookingLogBase.getCreateMan());
        }
        if (pSWSBookingLogBase.isDurationDirty() && (bl || pSWSBookingLogBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSWSBookingLogBase.getDuration());
        }
        if (pSWSBookingLogBase.isEndTimeDirty() && (bl || pSWSBookingLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSWSBookingLogBase.getEndTime());
        }
        if (pSWSBookingLogBase.isHoursDirty() && (bl || pSWSBookingLogBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSWSBookingLogBase.getHours());
        }
        if (pSWSBookingLogBase.isLogInfoDirty() && (bl || pSWSBookingLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSWSBookingLogBase.getLogInfo());
        }
        if (pSWSBookingLogBase.isMemoDirty() && (bl || pSWSBookingLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWSBookingLogBase.getMemo());
        }
        if (pSWSBookingLogBase.isPSDCWorkspaceIdDirty() && (bl || pSWSBookingLogBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSWSBookingLogBase.getPSDCWorkspaceId());
        }
        if (pSWSBookingLogBase.isPSDCWorkspaceNameDirty() && (bl || pSWSBookingLogBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSWSBookingLogBase.getPSDCWorkspaceName());
        }
        if (pSWSBookingLogBase.isPSDevCenterIdDirty() && (bl || pSWSBookingLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWSBookingLogBase.getPSDevCenterId());
        }
        if (pSWSBookingLogBase.isPSDevCenterNameDirty() && (bl || pSWSBookingLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWSBookingLogBase.getPSDevCenterName());
        }
        if (pSWSBookingLogBase.isPSSvrDomainIdDirty() && (bl || pSWSBookingLogBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSWSBookingLogBase.getPSSvrDomainId());
        }
        if (pSWSBookingLogBase.isPSSvrDomainNameDirty() && (bl || pSWSBookingLogBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSWSBookingLogBase.getPSSvrDomainName());
        }
        if (pSWSBookingLogBase.isPSTaskServerIdDirty() && (bl || pSWSBookingLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSWSBookingLogBase.getPSTaskServerId());
        }
        if (pSWSBookingLogBase.isPSTaskServerNameDirty() && (bl || pSWSBookingLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSWSBookingLogBase.getPSTaskServerName());
        }
        if (pSWSBookingLogBase.isPSWorkspaceIdDirty() && (bl || pSWSBookingLogBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWSBookingLogBase.getPSWorkspaceId());
        }
        if (pSWSBookingLogBase.isPSWorkspaceNameDirty() && (bl || pSWSBookingLogBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWSBookingLogBase.getPSWorkspaceName());
        }
        if (pSWSBookingLogBase.isPSWSBookingLogIdDirty() && (bl || pSWSBookingLogBase.getPSWSBookingLogId() != null)) {
            iDataObject.set(FIELD_PSWSBOOKINGLOGID, (Object)pSWSBookingLogBase.getPSWSBookingLogId());
        }
        if (pSWSBookingLogBase.isPSWSBookingLogNameDirty() && (bl || pSWSBookingLogBase.getPSWSBookingLogName() != null)) {
            iDataObject.set(FIELD_PSWSBOOKINGLOGNAME, (Object)pSWSBookingLogBase.getPSWSBookingLogName());
        }
        if (pSWSBookingLogBase.isRestoreInfoDirty() && (bl || pSWSBookingLogBase.getRestoreInfo() != null)) {
            iDataObject.set(FIELD_RESTOREINFO, (Object)pSWSBookingLogBase.getRestoreInfo());
        }
        if (pSWSBookingLogBase.isRestoreStateDirty() && (bl || pSWSBookingLogBase.getRestoreState() != null)) {
            iDataObject.set(FIELD_RESTORESTATE, (Object)pSWSBookingLogBase.getRestoreState());
        }
        if (pSWSBookingLogBase.isUpdateDateDirty() && (bl || pSWSBookingLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWSBookingLogBase.getUpdateDate());
        }
        if (pSWSBookingLogBase.isUpdateManDirty() && (bl || pSWSBookingLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWSBookingLogBase.getUpdateMan());
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
        return PSWSBookingLogBase.remove(this, n);
    }

    private static boolean remove(PSWSBookingLogBase pSWSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWSBookingLogBase.resetBackupInfo();
                return true;
            }
            case 1: {
                pSWSBookingLogBase.resetBackupState();
                return true;
            }
            case 2: {
                pSWSBookingLogBase.resetBeginTime();
                return true;
            }
            case 3: {
                pSWSBookingLogBase.resetBookingInfo();
                return true;
            }
            case 4: {
                pSWSBookingLogBase.resetBookingParam();
                return true;
            }
            case 5: {
                pSWSBookingLogBase.resetBookingParam2();
                return true;
            }
            case 6: {
                pSWSBookingLogBase.resetBookingParam3();
                return true;
            }
            case 7: {
                pSWSBookingLogBase.resetBookingParam4();
                return true;
            }
            case 8: {
                pSWSBookingLogBase.resetBookingState();
                return true;
            }
            case 9: {
                pSWSBookingLogBase.resetBookingType();
                return true;
            }
            case 10: {
                pSWSBookingLogBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSWSBookingLogBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSWSBookingLogBase.resetDuration();
                return true;
            }
            case 13: {
                pSWSBookingLogBase.resetEndTime();
                return true;
            }
            case 14: {
                pSWSBookingLogBase.resetHours();
                return true;
            }
            case 15: {
                pSWSBookingLogBase.resetLogInfo();
                return true;
            }
            case 16: {
                pSWSBookingLogBase.resetMemo();
                return true;
            }
            case 17: {
                pSWSBookingLogBase.resetPSDCWorkspaceId();
                return true;
            }
            case 18: {
                pSWSBookingLogBase.resetPSDCWorkspaceName();
                return true;
            }
            case 19: {
                pSWSBookingLogBase.resetPSDevCenterId();
                return true;
            }
            case 20: {
                pSWSBookingLogBase.resetPSDevCenterName();
                return true;
            }
            case 21: {
                pSWSBookingLogBase.resetPSSvrDomainId();
                return true;
            }
            case 22: {
                pSWSBookingLogBase.resetPSSvrDomainName();
                return true;
            }
            case 23: {
                pSWSBookingLogBase.resetPSTaskServerId();
                return true;
            }
            case 24: {
                pSWSBookingLogBase.resetPSTaskServerName();
                return true;
            }
            case 25: {
                pSWSBookingLogBase.resetPSWorkspaceId();
                return true;
            }
            case 26: {
                pSWSBookingLogBase.resetPSWorkspaceName();
                return true;
            }
            case 27: {
                pSWSBookingLogBase.resetPSWSBookingLogId();
                return true;
            }
            case 28: {
                pSWSBookingLogBase.resetPSWSBookingLogName();
                return true;
            }
            case 29: {
                pSWSBookingLogBase.resetRestoreInfo();
                return true;
            }
            case 30: {
                pSWSBookingLogBase.resetRestoreState();
                return true;
            }
            case 31: {
                pSWSBookingLogBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSWSBookingLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCWorkspace getPSDCWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCWorkspace();
        }
        if (this.getPSDCWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSDCWorkspaceLock;
        synchronized (n) {
            if (this.psdcworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCWorkspaceId(), (Object)this.psdcworkspace.getPSDCWorkspaceId()) != 0L) {
                this.psdcworkspace = null;
            }
            if (this.psdcworkspace == null) {
                PSDCWorkspace pSDCWorkspace = new PSDCWorkspace();
                pSDCWorkspace.setPSDCWorkspaceId(this.getPSDCWorkspaceId());
                PSDCWorkspaceService pSDCWorkspaceService = (PSDCWorkspaceService)ServiceGlobal.getService(PSDCWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSDCWorkspaceService.autoGet(pSDCWorkspace);
                this.psdcworkspace = pSDCWorkspace;
            }
            return this.psdcworkspace;
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPSSvrDomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSvrDomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPSSvrDomainLock;
        synchronized (n) {
            if (this.pssvrdomain != null && DataTypeHelper.compare((int)25, (Object)this.getPSSvrDomainId(), (Object)this.pssvrdomain.getPSSvrDomainId()) != 0L) {
                this.pssvrdomain = null;
            }
            if (this.pssvrdomain == null) {
                PSSvrDomain pSSvrDomain = new PSSvrDomain();
                pSSvrDomain.setPSSvrDomainId(this.getPSSvrDomainId());
                PSSvrDomainService pSSvrDomainService = (PSSvrDomainService)ServiceGlobal.getService(PSSvrDomainService.class, (SessionFactory)this.getSessionFactory());
                pSSvrDomainService.autoGet(pSSvrDomain);
                this.pssvrdomain = pSSvrDomain;
            }
            return this.pssvrdomain;
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
    public PSWorkspace getPSWorkspace() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWorkspace();
        }
        if (this.getPSWorkspaceId() == null) {
            return null;
        }
        Integer n = this.objPSWorkspaceLock;
        synchronized (n) {
            if (this.psworkspace != null && DataTypeHelper.compare((int)25, (Object)this.getPSWorkspaceId(), (Object)this.psworkspace.getPSWorkspaceId()) != 0L) {
                this.psworkspace = null;
            }
            if (this.psworkspace == null) {
                PSWorkspace pSWorkspace = new PSWorkspace();
                pSWorkspace.setPSWorkspaceId(this.getPSWorkspaceId());
                PSWorkspaceService pSWorkspaceService = (PSWorkspaceService)ServiceGlobal.getService(PSWorkspaceService.class, (SessionFactory)this.getSessionFactory());
                pSWorkspaceService.autoGet(pSWorkspace);
                this.psworkspace = pSWorkspace;
            }
            return this.psworkspace;
        }
    }

    private PSWSBookingLogBase getProxyEntity() {
        return this.proxyPSWSBookingLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWSBookingLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSWSBookingLogBase) {
            this.proxyPSWSBookingLogBase = (PSWSBookingLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPINFO, 0);
        fieldIndexMap.put(FIELD_BACKUPSTATE, 1);
        fieldIndexMap.put(FIELD_BEGINTIME, 2);
        fieldIndexMap.put(FIELD_BOOKINGINFO, 3);
        fieldIndexMap.put(FIELD_BOOKINGPARAM, 4);
        fieldIndexMap.put(FIELD_BOOKINGPARAM2, 5);
        fieldIndexMap.put(FIELD_BOOKINGPARAM3, 6);
        fieldIndexMap.put(FIELD_BOOKINGPARAM4, 7);
        fieldIndexMap.put(FIELD_BOOKINGSTATE, 8);
        fieldIndexMap.put(FIELD_BOOKINGTYPE, 9);
        fieldIndexMap.put(FIELD_CREATEDATE, 10);
        fieldIndexMap.put(FIELD_CREATEMAN, 11);
        fieldIndexMap.put(FIELD_DURATION, 12);
        fieldIndexMap.put(FIELD_ENDTIME, 13);
        fieldIndexMap.put(FIELD_HOURS, 14);
        fieldIndexMap.put(FIELD_LOGINFO, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 17);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 20);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 21);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 22);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 23);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 24);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 25);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 26);
        fieldIndexMap.put(FIELD_PSWSBOOKINGLOGID, 27);
        fieldIndexMap.put(FIELD_PSWSBOOKINGLOGNAME, 28);
        fieldIndexMap.put(FIELD_RESTOREINFO, 29);
        fieldIndexMap.put(FIELD_RESTORESTATE, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
    }
}

