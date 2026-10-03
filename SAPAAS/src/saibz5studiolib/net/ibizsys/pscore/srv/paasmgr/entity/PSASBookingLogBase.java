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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterAS;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterASService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSAppServer;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSvrDomain;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSASBookingLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSASBookingLogBase.class);
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
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSASBOOKINGLOGID = "PSASBOOKINGLOGID";
    public static final String FIELD_PSASBOOKINGLOGNAME = "PSASBOOKINGLOGNAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
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
    private static final int INDEX_PSAPPSERVERID = 17;
    private static final int INDEX_PSAPPSERVERNAME = 18;
    private static final int INDEX_PSASBOOKINGLOGID = 19;
    private static final int INDEX_PSASBOOKINGLOGNAME = 20;
    private static final int INDEX_PSDEVCENTERASID = 21;
    private static final int INDEX_PSDEVCENTERASNAME = 22;
    private static final int INDEX_PSDEVCENTERID = 23;
    private static final int INDEX_PSDEVCENTERNAME = 24;
    private static final int INDEX_PSSVRDOMAINID = 25;
    private static final int INDEX_PSSVRDOMAINNAME = 26;
    private static final int INDEX_PSTASKSERVERID = 27;
    private static final int INDEX_PSTASKSERVERNAME = 28;
    private static final int INDEX_RESTOREINFO = 29;
    private static final int INDEX_RESTORESTATE = 30;
    private static final int INDEX_UPDATEDATE = 31;
    private static final int INDEX_UPDATEMAN = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSASBookingLogBase proxyPSASBookingLogBase = null;
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
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psasbookinglogidDirtyFlag = false;
    private boolean psasbookinglognameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
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
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psasbookinglogid")
    private String psasbookinglogid;
    @Column(name="psasbookinglogname")
    private String psasbookinglogname;
    @Column(name="psdevcenterasid")
    private String psdevcenterasid;
    @Column(name="psdevcenterasname")
    private String psdevcenterasname;
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
    @Column(name="restoreinfo")
    private String restoreinfo;
    @Column(name="restorestate")
    private Integer restorestate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSAppServerLock = new Integer(1);
    private PSAppServer psappserver = null;
    private Integer objPSDevCenterASLock = new Integer(1);
    private PSDevCenterAS psdevcenteras = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
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

    public void setPSAppServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappserverid = string;
        this.psappserveridDirtyFlag = true;
    }

    public String getPSAppServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerId();
        }
        return this.psappserverid;
    }

    public boolean isPSAppServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerIdDirty();
        }
        return this.psappserveridDirtyFlag;
    }

    public void resetPSAppServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerId();
            return;
        }
        this.psappserveridDirtyFlag = false;
        this.psappserverid = null;
    }

    public void setPSAppServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappservername = string;
        this.psappservernameDirtyFlag = true;
    }

    public String getPSAppServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServerName();
        }
        return this.psappservername;
    }

    public boolean isPSAppServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppServerNameDirty();
        }
        return this.psappservernameDirtyFlag;
    }

    public void resetPSAppServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppServerName();
            return;
        }
        this.psappservernameDirtyFlag = false;
        this.psappservername = null;
    }

    public void setPSASBookingLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASBookingLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasbookinglogid = string;
        this.psasbookinglogidDirtyFlag = true;
    }

    public String getPSASBookingLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBookingLogId();
        }
        return this.psasbookinglogid;
    }

    public boolean isPSASBookingLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASBookingLogIdDirty();
        }
        return this.psasbookinglogidDirtyFlag;
    }

    public void resetPSASBookingLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASBookingLogId();
            return;
        }
        this.psasbookinglogidDirtyFlag = false;
        this.psasbookinglogid = null;
    }

    public void setPSASBookingLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASBookingLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasbookinglogname = string;
        this.psasbookinglognameDirtyFlag = true;
    }

    public String getPSASBookingLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBookingLogName();
        }
        return this.psasbookinglogname;
    }

    public boolean isPSASBookingLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASBookingLogNameDirty();
        }
        return this.psasbookinglognameDirtyFlag;
    }

    public void resetPSASBookingLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASBookingLogName();
            return;
        }
        this.psasbookinglognameDirtyFlag = false;
        this.psasbookinglogname = null;
    }

    public void setPSDevCenterASId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasid = string;
        this.psdevcenterasidDirtyFlag = true;
    }

    public String getPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASId();
        }
        return this.psdevcenterasid;
    }

    public boolean isPSDevCenterASIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASIdDirty();
        }
        return this.psdevcenterasidDirtyFlag;
    }

    public void resetPSDevCenterASId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASId();
            return;
        }
        this.psdevcenterasidDirtyFlag = false;
        this.psdevcenterasid = null;
    }

    public void setPSDevCenterASName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterASName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterasname = string;
        this.psdevcenterasnameDirtyFlag = true;
    }

    public String getPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterASName();
        }
        return this.psdevcenterasname;
    }

    public boolean isPSDevCenterASNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterASNameDirty();
        }
        return this.psdevcenterasnameDirtyFlag;
    }

    public void resetPSDevCenterASName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterASName();
            return;
        }
        this.psdevcenterasnameDirtyFlag = false;
        this.psdevcenterasname = null;
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
        PSASBookingLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSASBookingLogBase pSASBookingLogBase) {
        pSASBookingLogBase.resetBackupInfo();
        pSASBookingLogBase.resetBackupState();
        pSASBookingLogBase.resetBeginTime();
        pSASBookingLogBase.resetBookingInfo();
        pSASBookingLogBase.resetBookingParam();
        pSASBookingLogBase.resetBookingParam2();
        pSASBookingLogBase.resetBookingParam3();
        pSASBookingLogBase.resetBookingParam4();
        pSASBookingLogBase.resetBookingState();
        pSASBookingLogBase.resetBookingType();
        pSASBookingLogBase.resetCreateDate();
        pSASBookingLogBase.resetCreateMan();
        pSASBookingLogBase.resetDuration();
        pSASBookingLogBase.resetEndTime();
        pSASBookingLogBase.resetHours();
        pSASBookingLogBase.resetLogInfo();
        pSASBookingLogBase.resetMemo();
        pSASBookingLogBase.resetPSAppServerId();
        pSASBookingLogBase.resetPSAppServerName();
        pSASBookingLogBase.resetPSASBookingLogId();
        pSASBookingLogBase.resetPSASBookingLogName();
        pSASBookingLogBase.resetPSDevCenterASId();
        pSASBookingLogBase.resetPSDevCenterASName();
        pSASBookingLogBase.resetPSDevCenterId();
        pSASBookingLogBase.resetPSDevCenterName();
        pSASBookingLogBase.resetPSSvrDomainId();
        pSASBookingLogBase.resetPSSvrDomainName();
        pSASBookingLogBase.resetPSTaskServerId();
        pSASBookingLogBase.resetPSTaskServerName();
        pSASBookingLogBase.resetRestoreInfo();
        pSASBookingLogBase.resetRestoreState();
        pSASBookingLogBase.resetUpdateDate();
        pSASBookingLogBase.resetUpdateMan();
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
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSASBookingLogIdDirty()) {
            hashMap.put(FIELD_PSASBOOKINGLOGID, this.getPSASBookingLogId());
        }
        if (!bl || this.isPSASBookingLogNameDirty()) {
            hashMap.put(FIELD_PSASBOOKINGLOGNAME, this.getPSASBookingLogName());
        }
        if (!bl || this.isPSDevCenterASIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASID, this.getPSDevCenterASId());
        }
        if (!bl || this.isPSDevCenterASNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERASNAME, this.getPSDevCenterASName());
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
        return PSASBookingLogBase.get(this, n);
    }

    private static Object get(PSASBookingLogBase pSASBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingLogBase.getBackupInfo();
            }
            case 1: {
                return pSASBookingLogBase.getBackupState();
            }
            case 2: {
                return pSASBookingLogBase.getBeginTime();
            }
            case 3: {
                return pSASBookingLogBase.getBookingInfo();
            }
            case 4: {
                return pSASBookingLogBase.getBookingParam();
            }
            case 5: {
                return pSASBookingLogBase.getBookingParam2();
            }
            case 6: {
                return pSASBookingLogBase.getBookingParam3();
            }
            case 7: {
                return pSASBookingLogBase.getBookingParam4();
            }
            case 8: {
                return pSASBookingLogBase.getBookingState();
            }
            case 9: {
                return pSASBookingLogBase.getBookingType();
            }
            case 10: {
                return pSASBookingLogBase.getCreateDate();
            }
            case 11: {
                return pSASBookingLogBase.getCreateMan();
            }
            case 12: {
                return pSASBookingLogBase.getDuration();
            }
            case 13: {
                return pSASBookingLogBase.getEndTime();
            }
            case 14: {
                return pSASBookingLogBase.getHours();
            }
            case 15: {
                return pSASBookingLogBase.getLogInfo();
            }
            case 16: {
                return pSASBookingLogBase.getMemo();
            }
            case 17: {
                return pSASBookingLogBase.getPSAppServerId();
            }
            case 18: {
                return pSASBookingLogBase.getPSAppServerName();
            }
            case 19: {
                return pSASBookingLogBase.getPSASBookingLogId();
            }
            case 20: {
                return pSASBookingLogBase.getPSASBookingLogName();
            }
            case 21: {
                return pSASBookingLogBase.getPSDevCenterASId();
            }
            case 22: {
                return pSASBookingLogBase.getPSDevCenterASName();
            }
            case 23: {
                return pSASBookingLogBase.getPSDevCenterId();
            }
            case 24: {
                return pSASBookingLogBase.getPSDevCenterName();
            }
            case 25: {
                return pSASBookingLogBase.getPSSvrDomainId();
            }
            case 26: {
                return pSASBookingLogBase.getPSSvrDomainName();
            }
            case 27: {
                return pSASBookingLogBase.getPSTaskServerId();
            }
            case 28: {
                return pSASBookingLogBase.getPSTaskServerName();
            }
            case 29: {
                return pSASBookingLogBase.getRestoreInfo();
            }
            case 30: {
                return pSASBookingLogBase.getRestoreState();
            }
            case 31: {
                return pSASBookingLogBase.getUpdateDate();
            }
            case 32: {
                return pSASBookingLogBase.getUpdateMan();
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
        PSASBookingLogBase.set(this, n, object);
    }

    private static void set(PSASBookingLogBase pSASBookingLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSASBookingLogBase.setBackupInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSASBookingLogBase.setBackupState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSASBookingLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSASBookingLogBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSASBookingLogBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSASBookingLogBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSASBookingLogBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSASBookingLogBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSASBookingLogBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSASBookingLogBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSASBookingLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSASBookingLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSASBookingLogBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSASBookingLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSASBookingLogBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSASBookingLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSASBookingLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSASBookingLogBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSASBookingLogBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSASBookingLogBase.setPSASBookingLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSASBookingLogBase.setPSASBookingLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSASBookingLogBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSASBookingLogBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSASBookingLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSASBookingLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSASBookingLogBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSASBookingLogBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSASBookingLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSASBookingLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSASBookingLogBase.setRestoreInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSASBookingLogBase.setRestoreState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSASBookingLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 32: {
                pSASBookingLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSASBookingLogBase.isNull(this, n);
    }

    private static boolean isNull(PSASBookingLogBase pSASBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingLogBase.getBackupInfo() == null;
            }
            case 1: {
                return pSASBookingLogBase.getBackupState() == null;
            }
            case 2: {
                return pSASBookingLogBase.getBeginTime() == null;
            }
            case 3: {
                return pSASBookingLogBase.getBookingInfo() == null;
            }
            case 4: {
                return pSASBookingLogBase.getBookingParam() == null;
            }
            case 5: {
                return pSASBookingLogBase.getBookingParam2() == null;
            }
            case 6: {
                return pSASBookingLogBase.getBookingParam3() == null;
            }
            case 7: {
                return pSASBookingLogBase.getBookingParam4() == null;
            }
            case 8: {
                return pSASBookingLogBase.getBookingState() == null;
            }
            case 9: {
                return pSASBookingLogBase.getBookingType() == null;
            }
            case 10: {
                return pSASBookingLogBase.getCreateDate() == null;
            }
            case 11: {
                return pSASBookingLogBase.getCreateMan() == null;
            }
            case 12: {
                return pSASBookingLogBase.getDuration() == null;
            }
            case 13: {
                return pSASBookingLogBase.getEndTime() == null;
            }
            case 14: {
                return pSASBookingLogBase.getHours() == null;
            }
            case 15: {
                return pSASBookingLogBase.getLogInfo() == null;
            }
            case 16: {
                return pSASBookingLogBase.getMemo() == null;
            }
            case 17: {
                return pSASBookingLogBase.getPSAppServerId() == null;
            }
            case 18: {
                return pSASBookingLogBase.getPSAppServerName() == null;
            }
            case 19: {
                return pSASBookingLogBase.getPSASBookingLogId() == null;
            }
            case 20: {
                return pSASBookingLogBase.getPSASBookingLogName() == null;
            }
            case 21: {
                return pSASBookingLogBase.getPSDevCenterASId() == null;
            }
            case 22: {
                return pSASBookingLogBase.getPSDevCenterASName() == null;
            }
            case 23: {
                return pSASBookingLogBase.getPSDevCenterId() == null;
            }
            case 24: {
                return pSASBookingLogBase.getPSDevCenterName() == null;
            }
            case 25: {
                return pSASBookingLogBase.getPSSvrDomainId() == null;
            }
            case 26: {
                return pSASBookingLogBase.getPSSvrDomainName() == null;
            }
            case 27: {
                return pSASBookingLogBase.getPSTaskServerId() == null;
            }
            case 28: {
                return pSASBookingLogBase.getPSTaskServerName() == null;
            }
            case 29: {
                return pSASBookingLogBase.getRestoreInfo() == null;
            }
            case 30: {
                return pSASBookingLogBase.getRestoreState() == null;
            }
            case 31: {
                return pSASBookingLogBase.getUpdateDate() == null;
            }
            case 32: {
                return pSASBookingLogBase.getUpdateMan() == null;
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
        return PSASBookingLogBase.contains(this, n);
    }

    private static boolean contains(PSASBookingLogBase pSASBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingLogBase.isBackupInfoDirty();
            }
            case 1: {
                return pSASBookingLogBase.isBackupStateDirty();
            }
            case 2: {
                return pSASBookingLogBase.isBeginTimeDirty();
            }
            case 3: {
                return pSASBookingLogBase.isBookingInfoDirty();
            }
            case 4: {
                return pSASBookingLogBase.isBookingParamDirty();
            }
            case 5: {
                return pSASBookingLogBase.isBookingParam2Dirty();
            }
            case 6: {
                return pSASBookingLogBase.isBookingParam3Dirty();
            }
            case 7: {
                return pSASBookingLogBase.isBookingParam4Dirty();
            }
            case 8: {
                return pSASBookingLogBase.isBookingStateDirty();
            }
            case 9: {
                return pSASBookingLogBase.isBookingTypeDirty();
            }
            case 10: {
                return pSASBookingLogBase.isCreateDateDirty();
            }
            case 11: {
                return pSASBookingLogBase.isCreateManDirty();
            }
            case 12: {
                return pSASBookingLogBase.isDurationDirty();
            }
            case 13: {
                return pSASBookingLogBase.isEndTimeDirty();
            }
            case 14: {
                return pSASBookingLogBase.isHoursDirty();
            }
            case 15: {
                return pSASBookingLogBase.isLogInfoDirty();
            }
            case 16: {
                return pSASBookingLogBase.isMemoDirty();
            }
            case 17: {
                return pSASBookingLogBase.isPSAppServerIdDirty();
            }
            case 18: {
                return pSASBookingLogBase.isPSAppServerNameDirty();
            }
            case 19: {
                return pSASBookingLogBase.isPSASBookingLogIdDirty();
            }
            case 20: {
                return pSASBookingLogBase.isPSASBookingLogNameDirty();
            }
            case 21: {
                return pSASBookingLogBase.isPSDevCenterASIdDirty();
            }
            case 22: {
                return pSASBookingLogBase.isPSDevCenterASNameDirty();
            }
            case 23: {
                return pSASBookingLogBase.isPSDevCenterIdDirty();
            }
            case 24: {
                return pSASBookingLogBase.isPSDevCenterNameDirty();
            }
            case 25: {
                return pSASBookingLogBase.isPSSvrDomainIdDirty();
            }
            case 26: {
                return pSASBookingLogBase.isPSSvrDomainNameDirty();
            }
            case 27: {
                return pSASBookingLogBase.isPSTaskServerIdDirty();
            }
            case 28: {
                return pSASBookingLogBase.isPSTaskServerNameDirty();
            }
            case 29: {
                return pSASBookingLogBase.isRestoreInfoDirty();
            }
            case 30: {
                return pSASBookingLogBase.isRestoreStateDirty();
            }
            case 31: {
                return pSASBookingLogBase.isUpdateDateDirty();
            }
            case 32: {
                return pSASBookingLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSASBookingLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSASBookingLogBase pSASBookingLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSASBookingLogBase.getBackupInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupinfo", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBackupInfo()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBackupState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupstate", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBackupState()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingState()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getBookingType()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getDuration()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getHours()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSASBookingLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasbookinglogid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSASBookingLogId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSASBookingLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasbookinglogname", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSASBookingLogName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getRestoreInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restoreinfo", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getRestoreInfo()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getRestoreState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restorestate", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getRestoreState()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSASBookingLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSASBookingLogBase.getJSONValue((Object)pSASBookingLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSASBookingLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSASBookingLogBase pSASBookingLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSASBookingLogBase.getBackupInfo() != null) {
            object = pSASBookingLogBase.getBackupInfo();
            xmlNode.setAttribute(FIELD_BACKUPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBackupState() != null) {
            object = pSASBookingLogBase.getBackupState();
            xmlNode.setAttribute(FIELD_BACKUPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingLogBase.getBeginTime() != null) {
            object = pSASBookingLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingLogBase.getBookingInfo() != null) {
            object = pSASBookingLogBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBookingParam() != null) {
            object = pSASBookingLogBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBookingParam2() != null) {
            object = pSASBookingLogBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBookingParam3() != null) {
            object = pSASBookingLogBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBookingParam4() != null) {
            object = pSASBookingLogBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getBookingState() != null) {
            object = pSASBookingLogBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingLogBase.getBookingType() != null) {
            object = pSASBookingLogBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getCreateDate() != null) {
            object = pSASBookingLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingLogBase.getCreateMan() != null) {
            object = pSASBookingLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getDuration() != null) {
            object = pSASBookingLogBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingLogBase.getEndTime() != null) {
            object = pSASBookingLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingLogBase.getHours() != null) {
            object = pSASBookingLogBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingLogBase.getLogInfo() != null) {
            object = pSASBookingLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getMemo() != null) {
            object = pSASBookingLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSAppServerId() != null) {
            object = pSASBookingLogBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSAppServerName() != null) {
            object = pSASBookingLogBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSASBookingLogId() != null) {
            object = pSASBookingLogBase.getPSASBookingLogId();
            xmlNode.setAttribute(FIELD_PSASBOOKINGLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSASBookingLogName() != null) {
            object = pSASBookingLogBase.getPSASBookingLogName();
            xmlNode.setAttribute(FIELD_PSASBOOKINGLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterASId() != null) {
            object = pSASBookingLogBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterASName() != null) {
            object = pSASBookingLogBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterId() != null) {
            object = pSASBookingLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSDevCenterName() != null) {
            object = pSASBookingLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSSvrDomainId() != null) {
            object = pSASBookingLogBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSSvrDomainName() != null) {
            object = pSASBookingLogBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSTaskServerId() != null) {
            object = pSASBookingLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getPSTaskServerName() != null) {
            object = pSASBookingLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getRestoreInfo() != null) {
            object = pSASBookingLogBase.getRestoreInfo();
            xmlNode.setAttribute(FIELD_RESTOREINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingLogBase.getRestoreState() != null) {
            object = pSASBookingLogBase.getRestoreState();
            xmlNode.setAttribute(FIELD_RESTORESTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingLogBase.getUpdateDate() != null) {
            object = pSASBookingLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingLogBase.getUpdateMan() != null) {
            object = pSASBookingLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSASBookingLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSASBookingLogBase pSASBookingLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSASBookingLogBase.isBackupInfoDirty() && (bl || pSASBookingLogBase.getBackupInfo() != null)) {
            iDataObject.set(FIELD_BACKUPINFO, (Object)pSASBookingLogBase.getBackupInfo());
        }
        if (pSASBookingLogBase.isBackupStateDirty() && (bl || pSASBookingLogBase.getBackupState() != null)) {
            iDataObject.set(FIELD_BACKUPSTATE, (Object)pSASBookingLogBase.getBackupState());
        }
        if (pSASBookingLogBase.isBeginTimeDirty() && (bl || pSASBookingLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSASBookingLogBase.getBeginTime());
        }
        if (pSASBookingLogBase.isBookingInfoDirty() && (bl || pSASBookingLogBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSASBookingLogBase.getBookingInfo());
        }
        if (pSASBookingLogBase.isBookingParamDirty() && (bl || pSASBookingLogBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSASBookingLogBase.getBookingParam());
        }
        if (pSASBookingLogBase.isBookingParam2Dirty() && (bl || pSASBookingLogBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSASBookingLogBase.getBookingParam2());
        }
        if (pSASBookingLogBase.isBookingParam3Dirty() && (bl || pSASBookingLogBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSASBookingLogBase.getBookingParam3());
        }
        if (pSASBookingLogBase.isBookingParam4Dirty() && (bl || pSASBookingLogBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSASBookingLogBase.getBookingParam4());
        }
        if (pSASBookingLogBase.isBookingStateDirty() && (bl || pSASBookingLogBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSASBookingLogBase.getBookingState());
        }
        if (pSASBookingLogBase.isBookingTypeDirty() && (bl || pSASBookingLogBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSASBookingLogBase.getBookingType());
        }
        if (pSASBookingLogBase.isCreateDateDirty() && (bl || pSASBookingLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSASBookingLogBase.getCreateDate());
        }
        if (pSASBookingLogBase.isCreateManDirty() && (bl || pSASBookingLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSASBookingLogBase.getCreateMan());
        }
        if (pSASBookingLogBase.isDurationDirty() && (bl || pSASBookingLogBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSASBookingLogBase.getDuration());
        }
        if (pSASBookingLogBase.isEndTimeDirty() && (bl || pSASBookingLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSASBookingLogBase.getEndTime());
        }
        if (pSASBookingLogBase.isHoursDirty() && (bl || pSASBookingLogBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSASBookingLogBase.getHours());
        }
        if (pSASBookingLogBase.isLogInfoDirty() && (bl || pSASBookingLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSASBookingLogBase.getLogInfo());
        }
        if (pSASBookingLogBase.isMemoDirty() && (bl || pSASBookingLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSASBookingLogBase.getMemo());
        }
        if (pSASBookingLogBase.isPSAppServerIdDirty() && (bl || pSASBookingLogBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSASBookingLogBase.getPSAppServerId());
        }
        if (pSASBookingLogBase.isPSAppServerNameDirty() && (bl || pSASBookingLogBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSASBookingLogBase.getPSAppServerName());
        }
        if (pSASBookingLogBase.isPSASBookingLogIdDirty() && (bl || pSASBookingLogBase.getPSASBookingLogId() != null)) {
            iDataObject.set(FIELD_PSASBOOKINGLOGID, (Object)pSASBookingLogBase.getPSASBookingLogId());
        }
        if (pSASBookingLogBase.isPSASBookingLogNameDirty() && (bl || pSASBookingLogBase.getPSASBookingLogName() != null)) {
            iDataObject.set(FIELD_PSASBOOKINGLOGNAME, (Object)pSASBookingLogBase.getPSASBookingLogName());
        }
        if (pSASBookingLogBase.isPSDevCenterASIdDirty() && (bl || pSASBookingLogBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSASBookingLogBase.getPSDevCenterASId());
        }
        if (pSASBookingLogBase.isPSDevCenterASNameDirty() && (bl || pSASBookingLogBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSASBookingLogBase.getPSDevCenterASName());
        }
        if (pSASBookingLogBase.isPSDevCenterIdDirty() && (bl || pSASBookingLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSASBookingLogBase.getPSDevCenterId());
        }
        if (pSASBookingLogBase.isPSDevCenterNameDirty() && (bl || pSASBookingLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSASBookingLogBase.getPSDevCenterName());
        }
        if (pSASBookingLogBase.isPSSvrDomainIdDirty() && (bl || pSASBookingLogBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSASBookingLogBase.getPSSvrDomainId());
        }
        if (pSASBookingLogBase.isPSSvrDomainNameDirty() && (bl || pSASBookingLogBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSASBookingLogBase.getPSSvrDomainName());
        }
        if (pSASBookingLogBase.isPSTaskServerIdDirty() && (bl || pSASBookingLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSASBookingLogBase.getPSTaskServerId());
        }
        if (pSASBookingLogBase.isPSTaskServerNameDirty() && (bl || pSASBookingLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSASBookingLogBase.getPSTaskServerName());
        }
        if (pSASBookingLogBase.isRestoreInfoDirty() && (bl || pSASBookingLogBase.getRestoreInfo() != null)) {
            iDataObject.set(FIELD_RESTOREINFO, (Object)pSASBookingLogBase.getRestoreInfo());
        }
        if (pSASBookingLogBase.isRestoreStateDirty() && (bl || pSASBookingLogBase.getRestoreState() != null)) {
            iDataObject.set(FIELD_RESTORESTATE, (Object)pSASBookingLogBase.getRestoreState());
        }
        if (pSASBookingLogBase.isUpdateDateDirty() && (bl || pSASBookingLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSASBookingLogBase.getUpdateDate());
        }
        if (pSASBookingLogBase.isUpdateManDirty() && (bl || pSASBookingLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSASBookingLogBase.getUpdateMan());
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
        return PSASBookingLogBase.remove(this, n);
    }

    private static boolean remove(PSASBookingLogBase pSASBookingLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSASBookingLogBase.resetBackupInfo();
                return true;
            }
            case 1: {
                pSASBookingLogBase.resetBackupState();
                return true;
            }
            case 2: {
                pSASBookingLogBase.resetBeginTime();
                return true;
            }
            case 3: {
                pSASBookingLogBase.resetBookingInfo();
                return true;
            }
            case 4: {
                pSASBookingLogBase.resetBookingParam();
                return true;
            }
            case 5: {
                pSASBookingLogBase.resetBookingParam2();
                return true;
            }
            case 6: {
                pSASBookingLogBase.resetBookingParam3();
                return true;
            }
            case 7: {
                pSASBookingLogBase.resetBookingParam4();
                return true;
            }
            case 8: {
                pSASBookingLogBase.resetBookingState();
                return true;
            }
            case 9: {
                pSASBookingLogBase.resetBookingType();
                return true;
            }
            case 10: {
                pSASBookingLogBase.resetCreateDate();
                return true;
            }
            case 11: {
                pSASBookingLogBase.resetCreateMan();
                return true;
            }
            case 12: {
                pSASBookingLogBase.resetDuration();
                return true;
            }
            case 13: {
                pSASBookingLogBase.resetEndTime();
                return true;
            }
            case 14: {
                pSASBookingLogBase.resetHours();
                return true;
            }
            case 15: {
                pSASBookingLogBase.resetLogInfo();
                return true;
            }
            case 16: {
                pSASBookingLogBase.resetMemo();
                return true;
            }
            case 17: {
                pSASBookingLogBase.resetPSAppServerId();
                return true;
            }
            case 18: {
                pSASBookingLogBase.resetPSAppServerName();
                return true;
            }
            case 19: {
                pSASBookingLogBase.resetPSASBookingLogId();
                return true;
            }
            case 20: {
                pSASBookingLogBase.resetPSASBookingLogName();
                return true;
            }
            case 21: {
                pSASBookingLogBase.resetPSDevCenterASId();
                return true;
            }
            case 22: {
                pSASBookingLogBase.resetPSDevCenterASName();
                return true;
            }
            case 23: {
                pSASBookingLogBase.resetPSDevCenterId();
                return true;
            }
            case 24: {
                pSASBookingLogBase.resetPSDevCenterName();
                return true;
            }
            case 25: {
                pSASBookingLogBase.resetPSSvrDomainId();
                return true;
            }
            case 26: {
                pSASBookingLogBase.resetPSSvrDomainName();
                return true;
            }
            case 27: {
                pSASBookingLogBase.resetPSTaskServerId();
                return true;
            }
            case 28: {
                pSASBookingLogBase.resetPSTaskServerName();
                return true;
            }
            case 29: {
                pSASBookingLogBase.resetRestoreInfo();
                return true;
            }
            case 30: {
                pSASBookingLogBase.resetRestoreState();
                return true;
            }
            case 31: {
                pSASBookingLogBase.resetUpdateDate();
                return true;
            }
            case 32: {
                pSASBookingLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppServer getPSAppServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppServer();
        }
        if (this.getPSAppServerId() == null) {
            return null;
        }
        Integer n = this.objPSAppServerLock;
        synchronized (n) {
            if (this.psappserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppServerId(), (Object)this.psappserver.getPSAppServerId()) != 0L) {
                this.psappserver = null;
            }
            if (this.psappserver == null) {
                PSAppServer pSAppServer = new PSAppServer();
                pSAppServer.setPSAppServerId(this.getPSAppServerId());
                PSAppServerService pSAppServerService = (PSAppServerService)ServiceGlobal.getService(PSAppServerService.class, (SessionFactory)this.getSessionFactory());
                pSAppServerService.autoGet(pSAppServer);
                this.psappserver = pSAppServer;
            }
            return this.psappserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterAS getPSDevCenterAS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterAS();
        }
        if (this.getPSDevCenterASId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterASLock;
        synchronized (n) {
            if (this.psdevcenteras != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterASId(), (Object)this.psdevcenteras.getPSDevCenterASId()) != 0L) {
                this.psdevcenteras = null;
            }
            if (this.psdevcenteras == null) {
                PSDevCenterAS pSDevCenterAS = new PSDevCenterAS();
                pSDevCenterAS.setPSDevCenterASId(this.getPSDevCenterASId());
                PSDevCenterASService pSDevCenterASService = (PSDevCenterASService)ServiceGlobal.getService(PSDevCenterASService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterASService.autoGet(pSDevCenterAS);
                this.psdevcenteras = pSDevCenterAS;
            }
            return this.psdevcenteras;
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

    private PSASBookingLogBase getProxyEntity() {
        return this.proxyPSASBookingLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSASBookingLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSASBookingLogBase) {
            this.proxyPSASBookingLogBase = (PSASBookingLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSASBookingLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 17);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 18);
        fieldIndexMap.put(FIELD_PSASBOOKINGLOGID, 19);
        fieldIndexMap.put(FIELD_PSASBOOKINGLOGNAME, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 23);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 24);
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

