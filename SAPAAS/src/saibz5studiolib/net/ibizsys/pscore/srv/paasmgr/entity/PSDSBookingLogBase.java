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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterServer;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSBookingLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSBookingLogBase.class);
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
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String FIELD_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_PSDSBOOKINGLOGID = "PSDSBOOKINGLOGID";
    public static final String FIELD_PSDSBOOKINGLOGNAME = "PSDSBOOKINGLOGNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
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
    private static final int INDEX_PSDEVCENTERID = 17;
    private static final int INDEX_PSDEVCENTERNAME = 18;
    private static final int INDEX_PSDEVCENTERSERVERID = 19;
    private static final int INDEX_PSDEVCENTERSERVERNAME = 20;
    private static final int INDEX_PSDEVSERVERID = 21;
    private static final int INDEX_PSDEVSERVERNAME = 22;
    private static final int INDEX_PSDSBOOKINGLOGID = 23;
    private static final int INDEX_PSDSBOOKINGLOGNAME = 24;
    private static final int INDEX_PSSVRDOMAINID = 25;
    private static final int INDEX_PSSVRDOMAINNAME = 26;
    private static final int INDEX_PSTASKSERVERID = 27;
    private static final int INDEX_PSTASKSERVERNAME = 28;
    private static final int INDEX_RESTOREINFO = 29;
    private static final int INDEX_RESTORESTATE = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSBookingLogBase proxyPSDSBookingLogBase = null;
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
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterserveridDirtyFlag = false;
    private boolean psdevcenterservernameDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean psdsbookinglogidDirtyFlag = false;
    private boolean psdsbookinglognameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
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
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcenterserverid")
    private String psdevcenterserverid;
    @Column(name="psdevcenterservername")
    private String psdevcenterservername;
    @Column(name="psdevserverid")
    private String psdevserverid;
    @Column(name="psdevservername")
    private String psdevservername;
    @Column(name="psdsbookinglogid")
    private String psdsbookinglogid;
    @Column(name="psdsbookinglogname")
    private String psdsbookinglogname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="restoreinfo")
    private String restoreinfo;
    @Column(name="restorestate")
    private Integer restorestate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterServerLock = new Integer(1);
    private PSDevCenterServer psdevcenterserver = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevServerLock = new Integer(1);
    private PSDevServer psdevserver = null;
    private Integer objPssvrdomainLock = new Integer(1);
    private PSSvrDomain pssvrdomain = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setPSDevCenterServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterserverid = string;
        this.psdevcenterserveridDirtyFlag = true;
    }

    public String getPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerId();
        }
        return this.psdevcenterserverid;
    }

    public boolean isPSDevCenterServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerIdDirty();
        }
        return this.psdevcenterserveridDirtyFlag;
    }

    public void resetPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerId();
            return;
        }
        this.psdevcenterserveridDirtyFlag = false;
        this.psdevcenterserverid = null;
    }

    public void setPSDevCenterServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterservername = string;
        this.psdevcenterservernameDirtyFlag = true;
    }

    public String getPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerName();
        }
        return this.psdevcenterservername;
    }

    public boolean isPSDevCenterServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerNameDirty();
        }
        return this.psdevcenterservernameDirtyFlag;
    }

    public void resetPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerName();
            return;
        }
        this.psdevcenterservernameDirtyFlag = false;
        this.psdevcenterservername = null;
    }

    public void setPSDevServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverid = string;
        this.psdevserveridDirtyFlag = true;
    }

    public String getPSDevServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerId();
        }
        return this.psdevserverid;
    }

    public boolean isPSDevServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerIdDirty();
        }
        return this.psdevserveridDirtyFlag;
    }

    public void resetPSDevServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerId();
            return;
        }
        this.psdevserveridDirtyFlag = false;
        this.psdevserverid = null;
    }

    public void setPSDevServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservername = string;
        this.psdevservernameDirtyFlag = true;
    }

    public String getPSDevServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerName();
        }
        return this.psdevservername;
    }

    public boolean isPSDevServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerNameDirty();
        }
        return this.psdevservernameDirtyFlag;
    }

    public void resetPSDevServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerName();
            return;
        }
        this.psdevservernameDirtyFlag = false;
        this.psdevservername = null;
    }

    public void setPSDSBookingLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSBookingLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsbookinglogid = string;
        this.psdsbookinglogidDirtyFlag = true;
    }

    public String getPSDSBookingLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSBookingLogId();
        }
        return this.psdsbookinglogid;
    }

    public boolean isPSDSBookingLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSBookingLogIdDirty();
        }
        return this.psdsbookinglogidDirtyFlag;
    }

    public void resetPSDSBookingLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSBookingLogId();
            return;
        }
        this.psdsbookinglogidDirtyFlag = false;
        this.psdsbookinglogid = null;
    }

    public void setPSDSBookingLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSBookingLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsbookinglogname = string;
        this.psdsbookinglognameDirtyFlag = true;
    }

    public String getPSDSBookingLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSBookingLogName();
        }
        return this.psdsbookinglogname;
    }

    public boolean isPSDSBookingLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSBookingLogNameDirty();
        }
        return this.psdsbookinglognameDirtyFlag;
    }

    public void resetPSDSBookingLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSBookingLogName();
            return;
        }
        this.psdsbookinglognameDirtyFlag = false;
        this.psdsbookinglogname = null;
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
        PSDSBookingLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSBookingLogBase pSDSBookingLogBase) {
        pSDSBookingLogBase.resetBackupInfo();
        pSDSBookingLogBase.resetBackupState();
        pSDSBookingLogBase.resetBeginTime();
        pSDSBookingLogBase.resetBookingInfo();
        pSDSBookingLogBase.resetBookingParam();
        pSDSBookingLogBase.resetBookingParam2();
        pSDSBookingLogBase.resetBookingParam3();
        pSDSBookingLogBase.resetBookingParam4();
        pSDSBookingLogBase.resetBookingState();
        pSDSBookingLogBase.resetBookingType();
        pSDSBookingLogBase.resetCreateDate();
        pSDSBookingLogBase.resetCreateMan();
        pSDSBookingLogBase.resetDuration();
        pSDSBookingLogBase.resetEndTime();
        pSDSBookingLogBase.resetHours();
        pSDSBookingLogBase.resetLogInfo();
        pSDSBookingLogBase.resetMemo();
        pSDSBookingLogBase.resetPSDevCenterId();
        pSDSBookingLogBase.resetPSDevCenterName();
        pSDSBookingLogBase.resetPSDevCenterServerId();
        pSDSBookingLogBase.resetPSDevCenterServerName();
        pSDSBookingLogBase.resetPSDevServerId();
        pSDSBookingLogBase.resetPSDevServerName();
        pSDSBookingLogBase.resetPSDSBookingLogId();
        pSDSBookingLogBase.resetPSDSBookingLogName();
        pSDSBookingLogBase.resetPSSvrDomainId();
        pSDSBookingLogBase.resetPSSvrDomainName();
        pSDSBookingLogBase.resetPSTaskServerId();
        pSDSBookingLogBase.resetPSTaskServerName();
        pSDSBookingLogBase.resetRestoreInfo();
        pSDSBookingLogBase.resetRestoreState();
        pSDSBookingLogBase.resetUpdateDate();
        pSDSBookingLogBase.resetUpdateMan();
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
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterServerIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERID, this.getPSDevCenterServerId());
        }
        if (!bl || this.isPSDevCenterServerNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERNAME, this.getPSDevCenterServerName());
        }
        if (!bl || this.isPSDevServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERID, this.getPSDevServerId());
        }
        if (!bl || this.isPSDevServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERNAME, this.getPSDevServerName());
        }
        if (!bl || this.isPSDSBookingLogIdDirty()) {
            hashMap.put(FIELD_PSDSBOOKINGLOGID, this.getPSDSBookingLogId());
        }
        if (!bl || this.isPSDSBookingLogNameDirty()) {
            hashMap.put(FIELD_PSDSBOOKINGLOGNAME, this.getPSDSBookingLogName());
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
        return PSDSBookingLogBase.get(this, n);
    }

    private static Object get(PSDSBookingLogBase pSDSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingLogBase.getBackupInfo();
            }
            case 1: {
                return pSDSBookingLogBase.getBackupState();
            }
            case 2: {
                return pSDSBookingLogBase.getBeginTime();
            }
            case 3: {
                return pSDSBookingLogBase.getBookingInfo();
            }
            case 4: {
                return pSDSBookingLogBase.getBookingParam();
            }
            case 5: {
                return pSDSBookingLogBase.getBookingParam2();
            }
            case 6: {
                return pSDSBookingLogBase.getBookingParam3();
            }
            case 7: {
                return pSDSBookingLogBase.getBookingParam4();
            }
            case 8: {
                return pSDSBookingLogBase.getBookingState();
            }
            case 9: {
                return pSDSBookingLogBase.getBookingType();
            }
            case 10: {
                return pSDSBookingLogBase.getCreateDate();
            }
            case 11: {
                return pSDSBookingLogBase.getCreateMan();
            }
            case 12: {
                return pSDSBookingLogBase.getDuration();
            }
            case 13: {
                return pSDSBookingLogBase.getEndTime();
            }
            case 14: {
                return pSDSBookingLogBase.getHours();
            }
            case 15: {
                return pSDSBookingLogBase.getLogInfo();
            }
            case 16: {
                return pSDSBookingLogBase.getMemo();
            }
            case 17: {
                return pSDSBookingLogBase.getPSDevCenterId();
            }
            case 18: {
                return pSDSBookingLogBase.getPSDevCenterName();
            }
            case 19: {
                return pSDSBookingLogBase.getPSDevCenterServerId();
            }
            case 20: {
                return pSDSBookingLogBase.getPSDevCenterServerName();
            }
            case 21: {
                return pSDSBookingLogBase.getPSDevServerId();
            }
            case 22: {
                return pSDSBookingLogBase.getPSDevServerName();
            }
            case 23: {
                return pSDSBookingLogBase.getPSDSBookingLogId();
            }
            case 24: {
                return pSDSBookingLogBase.getPSDSBookingLogName();
            }
            case 25: {
                return pSDSBookingLogBase.getPSSvrDomainId();
            }
            case 26: {
                return pSDSBookingLogBase.getPSSvrDomainName();
            }
            case 27: {
                return pSDSBookingLogBase.getPSTaskServerId();
            }
            case 28: {
                return pSDSBookingLogBase.getPSTaskServerName();
            }
            case 29: {
                return pSDSBookingLogBase.getRestoreInfo();
            }
            case 30: {
                return pSDSBookingLogBase.getRestoreState();
            }
            case 31: {
                return pSDSBookingLogBase.getUpdateDate();
            }
            case 32: {
                return pSDSBookingLogBase.getUpdateMan();
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
        PSDSBookingLogBase.set(this, n, object);
    }

    private static void set(PSDSBookingLogBase pSDSBookingLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSBookingLogBase.setBackupInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDSBookingLogBase.setBackupState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDSBookingLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDSBookingLogBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSBookingLogBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSBookingLogBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDSBookingLogBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDSBookingLogBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDSBookingLogBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDSBookingLogBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDSBookingLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDSBookingLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDSBookingLogBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDSBookingLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDSBookingLogBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDSBookingLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDSBookingLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDSBookingLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDSBookingLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDSBookingLogBase.setPSDevCenterServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDSBookingLogBase.setPSDevCenterServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDSBookingLogBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDSBookingLogBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDSBookingLogBase.setPSDSBookingLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDSBookingLogBase.setPSDSBookingLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDSBookingLogBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDSBookingLogBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDSBookingLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDSBookingLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDSBookingLogBase.setRestoreInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDSBookingLogBase.setRestoreState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSDSBookingLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSDSBookingLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDSBookingLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDSBookingLogBase pSDSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingLogBase.getBackupInfo() == null;
            }
            case 1: {
                return pSDSBookingLogBase.getBackupState() == null;
            }
            case 2: {
                return pSDSBookingLogBase.getBeginTime() == null;
            }
            case 3: {
                return pSDSBookingLogBase.getBookingInfo() == null;
            }
            case 4: {
                return pSDSBookingLogBase.getBookingParam() == null;
            }
            case 5: {
                return pSDSBookingLogBase.getBookingParam2() == null;
            }
            case 6: {
                return pSDSBookingLogBase.getBookingParam3() == null;
            }
            case 7: {
                return pSDSBookingLogBase.getBookingParam4() == null;
            }
            case 8: {
                return pSDSBookingLogBase.getBookingState() == null;
            }
            case 9: {
                return pSDSBookingLogBase.getBookingType() == null;
            }
            case 10: {
                return pSDSBookingLogBase.getCreateDate() == null;
            }
            case 11: {
                return pSDSBookingLogBase.getCreateMan() == null;
            }
            case 12: {
                return pSDSBookingLogBase.getDuration() == null;
            }
            case 13: {
                return pSDSBookingLogBase.getEndTime() == null;
            }
            case 14: {
                return pSDSBookingLogBase.getHours() == null;
            }
            case 15: {
                return pSDSBookingLogBase.getLogInfo() == null;
            }
            case 16: {
                return pSDSBookingLogBase.getMemo() == null;
            }
            case 17: {
                return pSDSBookingLogBase.getPSDevCenterId() == null;
            }
            case 18: {
                return pSDSBookingLogBase.getPSDevCenterName() == null;
            }
            case 19: {
                return pSDSBookingLogBase.getPSDevCenterServerId() == null;
            }
            case 20: {
                return pSDSBookingLogBase.getPSDevCenterServerName() == null;
            }
            case 21: {
                return pSDSBookingLogBase.getPSDevServerId() == null;
            }
            case 22: {
                return pSDSBookingLogBase.getPSDevServerName() == null;
            }
            case 23: {
                return pSDSBookingLogBase.getPSDSBookingLogId() == null;
            }
            case 24: {
                return pSDSBookingLogBase.getPSDSBookingLogName() == null;
            }
            case 25: {
                return pSDSBookingLogBase.getPSSvrDomainId() == null;
            }
            case 26: {
                return pSDSBookingLogBase.getPSSvrDomainName() == null;
            }
            case 27: {
                return pSDSBookingLogBase.getPSTaskServerId() == null;
            }
            case 28: {
                return pSDSBookingLogBase.getPSTaskServerName() == null;
            }
            case 29: {
                return pSDSBookingLogBase.getRestoreInfo() == null;
            }
            case 30: {
                return pSDSBookingLogBase.getRestoreState() == null;
            }
            case 31: {
                return pSDSBookingLogBase.getUpdateDate() == null;
            }
            case 32: {
                return pSDSBookingLogBase.getUpdateMan() == null;
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
        return PSDSBookingLogBase.contains(this, n);
    }

    private static boolean contains(PSDSBookingLogBase pSDSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingLogBase.isBackupInfoDirty();
            }
            case 1: {
                return pSDSBookingLogBase.isBackupStateDirty();
            }
            case 2: {
                return pSDSBookingLogBase.isBeginTimeDirty();
            }
            case 3: {
                return pSDSBookingLogBase.isBookingInfoDirty();
            }
            case 4: {
                return pSDSBookingLogBase.isBookingParamDirty();
            }
            case 5: {
                return pSDSBookingLogBase.isBookingParam2Dirty();
            }
            case 6: {
                return pSDSBookingLogBase.isBookingParam3Dirty();
            }
            case 7: {
                return pSDSBookingLogBase.isBookingParam4Dirty();
            }
            case 8: {
                return pSDSBookingLogBase.isBookingStateDirty();
            }
            case 9: {
                return pSDSBookingLogBase.isBookingTypeDirty();
            }
            case 10: {
                return pSDSBookingLogBase.isCreateDateDirty();
            }
            case 11: {
                return pSDSBookingLogBase.isCreateManDirty();
            }
            case 12: {
                return pSDSBookingLogBase.isDurationDirty();
            }
            case 13: {
                return pSDSBookingLogBase.isEndTimeDirty();
            }
            case 14: {
                return pSDSBookingLogBase.isHoursDirty();
            }
            case 15: {
                return pSDSBookingLogBase.isLogInfoDirty();
            }
            case 16: {
                return pSDSBookingLogBase.isMemoDirty();
            }
            case 17: {
                return pSDSBookingLogBase.isPSDevCenterIdDirty();
            }
            case 18: {
                return pSDSBookingLogBase.isPSDevCenterNameDirty();
            }
            case 19: {
                return pSDSBookingLogBase.isPSDevCenterServerIdDirty();
            }
            case 20: {
                return pSDSBookingLogBase.isPSDevCenterServerNameDirty();
            }
            case 21: {
                return pSDSBookingLogBase.isPSDevServerIdDirty();
            }
            case 22: {
                return pSDSBookingLogBase.isPSDevServerNameDirty();
            }
            case 23: {
                return pSDSBookingLogBase.isPSDSBookingLogIdDirty();
            }
            case 24: {
                return pSDSBookingLogBase.isPSDSBookingLogNameDirty();
            }
            case 25: {
                return pSDSBookingLogBase.isPSSvrDomainIdDirty();
            }
            case 26: {
                return pSDSBookingLogBase.isPSSvrDomainNameDirty();
            }
            case 27: {
                return pSDSBookingLogBase.isPSTaskServerIdDirty();
            }
            case 28: {
                return pSDSBookingLogBase.isPSTaskServerNameDirty();
            }
            case 29: {
                return pSDSBookingLogBase.isRestoreInfoDirty();
            }
            case 30: {
                return pSDSBookingLogBase.isRestoreStateDirty();
            }
            case 31: {
                return pSDSBookingLogBase.isUpdateDateDirty();
            }
            case 32: {
                return pSDSBookingLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSBookingLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSBookingLogBase pSDSBookingLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSBookingLogBase.getBackupInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupinfo", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBackupInfo()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBackupState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupstate", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBackupState()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingState()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getBookingType()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getDuration()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getHours()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterserverid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevCenterServerId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterservername", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevCenterServerName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDSBookingLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsbookinglogid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDSBookingLogId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSDSBookingLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsbookinglogname", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSDSBookingLogName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getRestoreInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restoreinfo", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getRestoreInfo()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getRestoreState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restorestate", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getRestoreState()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSBookingLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSBookingLogBase.getJSONValue((Object)pSDSBookingLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSBookingLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSBookingLogBase pSDSBookingLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSBookingLogBase.getBackupInfo() != null) {
            object = pSDSBookingLogBase.getBackupInfo();
            xmlNode.setAttribute(FIELD_BACKUPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBackupState() != null) {
            object = pSDSBookingLogBase.getBackupState();
            xmlNode.setAttribute(FIELD_BACKUPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getBeginTime() != null) {
            object = pSDSBookingLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getBookingInfo() != null) {
            object = pSDSBookingLogBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBookingParam() != null) {
            object = pSDSBookingLogBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBookingParam2() != null) {
            object = pSDSBookingLogBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBookingParam3() != null) {
            object = pSDSBookingLogBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBookingParam4() != null) {
            object = pSDSBookingLogBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getBookingState() != null) {
            object = pSDSBookingLogBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getBookingType() != null) {
            object = pSDSBookingLogBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getCreateDate() != null) {
            object = pSDSBookingLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getCreateMan() != null) {
            object = pSDSBookingLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getDuration() != null) {
            object = pSDSBookingLogBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getEndTime() != null) {
            object = pSDSBookingLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getHours() != null) {
            object = pSDSBookingLogBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getLogInfo() != null) {
            object = pSDSBookingLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getMemo() != null) {
            object = pSDSBookingLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterId() != null) {
            object = pSDSBookingLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterName() != null) {
            object = pSDSBookingLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterServerId() != null) {
            object = pSDSBookingLogBase.getPSDevCenterServerId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevCenterServerName() != null) {
            object = pSDSBookingLogBase.getPSDevCenterServerName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevServerId() != null) {
            object = pSDSBookingLogBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDevServerName() != null) {
            object = pSDSBookingLogBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDSBookingLogId() != null) {
            object = pSDSBookingLogBase.getPSDSBookingLogId();
            xmlNode.setAttribute(FIELD_PSDSBOOKINGLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSDSBookingLogName() != null) {
            object = pSDSBookingLogBase.getPSDSBookingLogName();
            xmlNode.setAttribute(FIELD_PSDSBOOKINGLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSSvrDomainId() != null) {
            object = pSDSBookingLogBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSSvrDomainName() != null) {
            object = pSDSBookingLogBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSTaskServerId() != null) {
            object = pSDSBookingLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getPSTaskServerName() != null) {
            object = pSDSBookingLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getRestoreInfo() != null) {
            object = pSDSBookingLogBase.getRestoreInfo();
            xmlNode.setAttribute(FIELD_RESTOREINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingLogBase.getRestoreState() != null) {
            object = pSDSBookingLogBase.getRestoreState();
            xmlNode.setAttribute(FIELD_RESTORESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getUpdateDate() != null) {
            object = pSDSBookingLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingLogBase.getUpdateMan() != null) {
            object = pSDSBookingLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSBookingLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSBookingLogBase pSDSBookingLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSBookingLogBase.isBackupInfoDirty() && (bl || pSDSBookingLogBase.getBackupInfo() != null)) {
            iDataObject.set(FIELD_BACKUPINFO, (Object)pSDSBookingLogBase.getBackupInfo());
        }
        if (pSDSBookingLogBase.isBackupStateDirty() && (bl || pSDSBookingLogBase.getBackupState() != null)) {
            iDataObject.set(FIELD_BACKUPSTATE, (Object)pSDSBookingLogBase.getBackupState());
        }
        if (pSDSBookingLogBase.isBeginTimeDirty() && (bl || pSDSBookingLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDSBookingLogBase.getBeginTime());
        }
        if (pSDSBookingLogBase.isBookingInfoDirty() && (bl || pSDSBookingLogBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSDSBookingLogBase.getBookingInfo());
        }
        if (pSDSBookingLogBase.isBookingParamDirty() && (bl || pSDSBookingLogBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSDSBookingLogBase.getBookingParam());
        }
        if (pSDSBookingLogBase.isBookingParam2Dirty() && (bl || pSDSBookingLogBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSDSBookingLogBase.getBookingParam2());
        }
        if (pSDSBookingLogBase.isBookingParam3Dirty() && (bl || pSDSBookingLogBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSDSBookingLogBase.getBookingParam3());
        }
        if (pSDSBookingLogBase.isBookingParam4Dirty() && (bl || pSDSBookingLogBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSDSBookingLogBase.getBookingParam4());
        }
        if (pSDSBookingLogBase.isBookingStateDirty() && (bl || pSDSBookingLogBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSDSBookingLogBase.getBookingState());
        }
        if (pSDSBookingLogBase.isBookingTypeDirty() && (bl || pSDSBookingLogBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSDSBookingLogBase.getBookingType());
        }
        if (pSDSBookingLogBase.isCreateDateDirty() && (bl || pSDSBookingLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSBookingLogBase.getCreateDate());
        }
        if (pSDSBookingLogBase.isCreateManDirty() && (bl || pSDSBookingLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSBookingLogBase.getCreateMan());
        }
        if (pSDSBookingLogBase.isDurationDirty() && (bl || pSDSBookingLogBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSDSBookingLogBase.getDuration());
        }
        if (pSDSBookingLogBase.isEndTimeDirty() && (bl || pSDSBookingLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDSBookingLogBase.getEndTime());
        }
        if (pSDSBookingLogBase.isHoursDirty() && (bl || pSDSBookingLogBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSDSBookingLogBase.getHours());
        }
        if (pSDSBookingLogBase.isLogInfoDirty() && (bl || pSDSBookingLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDSBookingLogBase.getLogInfo());
        }
        if (pSDSBookingLogBase.isMemoDirty() && (bl || pSDSBookingLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDSBookingLogBase.getMemo());
        }
        if (pSDSBookingLogBase.isPSDevCenterIdDirty() && (bl || pSDSBookingLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDSBookingLogBase.getPSDevCenterId());
        }
        if (pSDSBookingLogBase.isPSDevCenterNameDirty() && (bl || pSDSBookingLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDSBookingLogBase.getPSDevCenterName());
        }
        if (pSDSBookingLogBase.isPSDevCenterServerIdDirty() && (bl || pSDSBookingLogBase.getPSDevCenterServerId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERID, (Object)pSDSBookingLogBase.getPSDevCenterServerId());
        }
        if (pSDSBookingLogBase.isPSDevCenterServerNameDirty() && (bl || pSDSBookingLogBase.getPSDevCenterServerName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERNAME, (Object)pSDSBookingLogBase.getPSDevCenterServerName());
        }
        if (pSDSBookingLogBase.isPSDevServerIdDirty() && (bl || pSDSBookingLogBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDSBookingLogBase.getPSDevServerId());
        }
        if (pSDSBookingLogBase.isPSDevServerNameDirty() && (bl || pSDSBookingLogBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDSBookingLogBase.getPSDevServerName());
        }
        if (pSDSBookingLogBase.isPSDSBookingLogIdDirty() && (bl || pSDSBookingLogBase.getPSDSBookingLogId() != null)) {
            iDataObject.set(FIELD_PSDSBOOKINGLOGID, (Object)pSDSBookingLogBase.getPSDSBookingLogId());
        }
        if (pSDSBookingLogBase.isPSDSBookingLogNameDirty() && (bl || pSDSBookingLogBase.getPSDSBookingLogName() != null)) {
            iDataObject.set(FIELD_PSDSBOOKINGLOGNAME, (Object)pSDSBookingLogBase.getPSDSBookingLogName());
        }
        if (pSDSBookingLogBase.isPSSvrDomainIdDirty() && (bl || pSDSBookingLogBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDSBookingLogBase.getPSSvrDomainId());
        }
        if (pSDSBookingLogBase.isPSSvrDomainNameDirty() && (bl || pSDSBookingLogBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDSBookingLogBase.getPSSvrDomainName());
        }
        if (pSDSBookingLogBase.isPSTaskServerIdDirty() && (bl || pSDSBookingLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDSBookingLogBase.getPSTaskServerId());
        }
        if (pSDSBookingLogBase.isPSTaskServerNameDirty() && (bl || pSDSBookingLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDSBookingLogBase.getPSTaskServerName());
        }
        if (pSDSBookingLogBase.isRestoreInfoDirty() && (bl || pSDSBookingLogBase.getRestoreInfo() != null)) {
            iDataObject.set(FIELD_RESTOREINFO, (Object)pSDSBookingLogBase.getRestoreInfo());
        }
        if (pSDSBookingLogBase.isRestoreStateDirty() && (bl || pSDSBookingLogBase.getRestoreState() != null)) {
            iDataObject.set(FIELD_RESTORESTATE, (Object)pSDSBookingLogBase.getRestoreState());
        }
        if (pSDSBookingLogBase.isUpdateDateDirty() && (bl || pSDSBookingLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSBookingLogBase.getUpdateDate());
        }
        if (pSDSBookingLogBase.isUpdateManDirty() && (bl || pSDSBookingLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSBookingLogBase.getUpdateMan());
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
        return PSDSBookingLogBase.remove(this, n);
    }

    private static boolean remove(PSDSBookingLogBase pSDSBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSBookingLogBase.resetBackupInfo();
                return true;
            }
            case 1: {
                pSDSBookingLogBase.resetBackupState();
                return true;
            }
            case 2: {
                pSDSBookingLogBase.resetBeginTime();
                return true;
            }
            case 3: {
                pSDSBookingLogBase.resetBookingInfo();
                return true;
            }
            case 4: {
                pSDSBookingLogBase.resetBookingParam();
                return true;
            }
            case 5: {
                pSDSBookingLogBase.resetBookingParam2();
                return true;
            }
            case 6: {
                pSDSBookingLogBase.resetBookingParam3();
                return true;
            }
            case 7: {
                pSDSBookingLogBase.resetBookingParam4();
                return true;
            }
            case 8: {
                pSDSBookingLogBase.resetBookingState();
                return true;
            }
            case 9: {
                pSDSBookingLogBase.resetBookingType();
                return true;
            }
            case 10: {
                pSDSBookingLogBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSDSBookingLogBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSDSBookingLogBase.resetDuration();
                return true;
            }
            case 13: {
                pSDSBookingLogBase.resetEndTime();
                return true;
            }
            case 14: {
                pSDSBookingLogBase.resetHours();
                return true;
            }
            case 15: {
                pSDSBookingLogBase.resetLogInfo();
                return true;
            }
            case 16: {
                pSDSBookingLogBase.resetMemo();
                return true;
            }
            case 17: {
                pSDSBookingLogBase.resetPSDevCenterId();
                return true;
            }
            case 18: {
                pSDSBookingLogBase.resetPSDevCenterName();
                return true;
            }
            case 19: {
                pSDSBookingLogBase.resetPSDevCenterServerId();
                return true;
            }
            case 20: {
                pSDSBookingLogBase.resetPSDevCenterServerName();
                return true;
            }
            case 21: {
                pSDSBookingLogBase.resetPSDevServerId();
                return true;
            }
            case 22: {
                pSDSBookingLogBase.resetPSDevServerName();
                return true;
            }
            case 23: {
                pSDSBookingLogBase.resetPSDSBookingLogId();
                return true;
            }
            case 24: {
                pSDSBookingLogBase.resetPSDSBookingLogName();
                return true;
            }
            case 25: {
                pSDSBookingLogBase.resetPSSvrDomainId();
                return true;
            }
            case 26: {
                pSDSBookingLogBase.resetPSSvrDomainName();
                return true;
            }
            case 27: {
                pSDSBookingLogBase.resetPSTaskServerId();
                return true;
            }
            case 28: {
                pSDSBookingLogBase.resetPSTaskServerName();
                return true;
            }
            case 29: {
                pSDSBookingLogBase.resetRestoreInfo();
                return true;
            }
            case 30: {
                pSDSBookingLogBase.resetRestoreState();
                return true;
            }
            case 31: {
                pSDSBookingLogBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSDSBookingLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterServer getPSDevCenterServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServer();
        }
        if (this.getPSDevCenterServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterServerLock;
        synchronized (n) {
            if (this.psdevcenterserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterServerId(), (Object)this.psdevcenterserver.getPSDevCenterServerId()) != 0L) {
                this.psdevcenterserver = null;
            }
            if (this.psdevcenterserver == null) {
                PSDevCenterServer pSDevCenterServer = new PSDevCenterServer();
                pSDevCenterServer.setPSDevCenterServerId(this.getPSDevCenterServerId());
                PSDevCenterServerService pSDevCenterServerService = (PSDevCenterServerService)ServiceGlobal.getService(PSDevCenterServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterServerService.autoGet(pSDevCenterServer);
                this.psdevcenterserver = pSDevCenterServer;
            }
            return this.psdevcenterserver;
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
    public PSDevServer getPSDevServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServer();
        }
        if (this.getPSDevServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevServerLock;
        synchronized (n) {
            if (this.psdevserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevServerId(), (Object)this.psdevserver.getPSDevServerId()) != 0L) {
                this.psdevserver = null;
            }
            if (this.psdevserver == null) {
                PSDevServer pSDevServer = new PSDevServer();
                pSDevServer.setPSDevServerId(this.getPSDevServerId());
                PSDevServerService pSDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevServerService.autoGet(pSDevServer);
                this.psdevserver = pSDevServer;
            }
            return this.psdevserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSvrDomain getPssvrdomain() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssvrdomain();
        }
        if (this.getPSSvrDomainId() == null) {
            return null;
        }
        Integer n = this.objPssvrdomainLock;
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

    private PSDSBookingLogBase getProxyEntity() {
        return this.proxyPSDSBookingLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSBookingLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSBookingLogBase) {
            this.proxyPSDSBookingLogBase = (PSDSBookingLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERID, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 21);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 22);
        fieldIndexMap.put(FIELD_PSDSBOOKINGLOGID, 23);
        fieldIndexMap.put(FIELD_PSDSBOOKINGLOGNAME, 24);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 25);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 26);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 27);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 28);
        fieldIndexMap.put(FIELD_RESTOREINFO, 29);
        fieldIndexMap.put(FIELD_RESTORESTATE, 30);
        fieldIndexMap.put(FIELD_UPDATEDATE, 31);
        fieldIndexMap.put(FIELD_UPDATEMAN, 32);
    }
}

