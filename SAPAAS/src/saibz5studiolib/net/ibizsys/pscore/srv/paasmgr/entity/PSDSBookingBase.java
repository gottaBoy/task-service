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
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDSBookingBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDSBookingBase.class);
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
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String FIELD_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_PSDSBOOKINGID = "PSDSBOOKINGID";
    public static final String FIELD_PSDSBOOKINGNAME = "PSDSBOOKINGNAME";
    public static final String FIELD_PSSVRDOMAINID = "PSSVRDOMAINID";
    public static final String FIELD_PSSVRDOMAINNAME = "PSSVRDOMAINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_BOOKINGINFO = 1;
    private static final int INDEX_BOOKINGPARAM = 2;
    private static final int INDEX_BOOKINGPARAM2 = 3;
    private static final int INDEX_BOOKINGPARAM3 = 4;
    private static final int INDEX_BOOKINGPARAM4 = 5;
    private static final int INDEX_BOOKINGSTATE = 6;
    private static final int INDEX_BOOKINGTYPE = 7;
    private static final int INDEX_CREATEDATE = 8;
    private static final int INDEX_CREATEMAN = 9;
    private static final int INDEX_DURATION = 10;
    private static final int INDEX_ENDTIME = 11;
    private static final int INDEX_HOURS = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_PSDEVCENTERSERVERID = 16;
    private static final int INDEX_PSDEVCENTERSERVERNAME = 17;
    private static final int INDEX_PSDEVSERVERID = 18;
    private static final int INDEX_PSDEVSERVERNAME = 19;
    private static final int INDEX_PSDSBOOKINGID = 20;
    private static final int INDEX_PSDSBOOKINGNAME = 21;
    private static final int INDEX_PSSVRDOMAINID = 22;
    private static final int INDEX_PSSVRDOMAINNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDSBookingBase proxyPSDSBookingBase = null;
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
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterserveridDirtyFlag = false;
    private boolean psdevcenterservernameDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean psdsbookingidDirtyFlag = false;
    private boolean psdsbookingnameDirtyFlag = false;
    private boolean pssvrdomainidDirtyFlag = false;
    private boolean pssvrdomainnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
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
    @Column(name="psdsbookingid")
    private String psdsbookingid;
    @Column(name="psdsbookingname")
    private String psdsbookingname;
    @Column(name="pssvrdomainid")
    private String pssvrdomainid;
    @Column(name="pssvrdomainname")
    private String pssvrdomainname;
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

    public void setPSDSBookingId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSBookingId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsbookingid = string;
        this.psdsbookingidDirtyFlag = true;
    }

    public String getPSDSBookingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSBookingId();
        }
        return this.psdsbookingid;
    }

    public boolean isPSDSBookingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSBookingIdDirty();
        }
        return this.psdsbookingidDirtyFlag;
    }

    public void resetPSDSBookingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSBookingId();
            return;
        }
        this.psdsbookingidDirtyFlag = false;
        this.psdsbookingid = null;
    }

    public void setPSDSBookingName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSBookingName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsbookingname = string;
        this.psdsbookingnameDirtyFlag = true;
    }

    public String getPSDSBookingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSBookingName();
        }
        return this.psdsbookingname;
    }

    public boolean isPSDSBookingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSBookingNameDirty();
        }
        return this.psdsbookingnameDirtyFlag;
    }

    public void resetPSDSBookingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSBookingName();
            return;
        }
        this.psdsbookingnameDirtyFlag = false;
        this.psdsbookingname = null;
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
        PSDSBookingBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDSBookingBase pSDSBookingBase) {
        pSDSBookingBase.resetBeginTime();
        pSDSBookingBase.resetBookingInfo();
        pSDSBookingBase.resetBookingParam();
        pSDSBookingBase.resetBookingParam2();
        pSDSBookingBase.resetBookingParam3();
        pSDSBookingBase.resetBookingParam4();
        pSDSBookingBase.resetBookingState();
        pSDSBookingBase.resetBookingType();
        pSDSBookingBase.resetCreateDate();
        pSDSBookingBase.resetCreateMan();
        pSDSBookingBase.resetDuration();
        pSDSBookingBase.resetEndTime();
        pSDSBookingBase.resetHours();
        pSDSBookingBase.resetMemo();
        pSDSBookingBase.resetPSDevCenterId();
        pSDSBookingBase.resetPSDevCenterName();
        pSDSBookingBase.resetPSDevCenterServerId();
        pSDSBookingBase.resetPSDevCenterServerName();
        pSDSBookingBase.resetPSDevServerId();
        pSDSBookingBase.resetPSDevServerName();
        pSDSBookingBase.resetPSDSBookingId();
        pSDSBookingBase.resetPSDSBookingName();
        pSDSBookingBase.resetPSSvrDomainId();
        pSDSBookingBase.resetPSSvrDomainName();
        pSDSBookingBase.resetUpdateDate();
        pSDSBookingBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isPSDSBookingIdDirty()) {
            hashMap.put(FIELD_PSDSBOOKINGID, this.getPSDSBookingId());
        }
        if (!bl || this.isPSDSBookingNameDirty()) {
            hashMap.put(FIELD_PSDSBOOKINGNAME, this.getPSDSBookingName());
        }
        if (!bl || this.isPSSvrDomainIdDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINID, this.getPSSvrDomainId());
        }
        if (!bl || this.isPSSvrDomainNameDirty()) {
            hashMap.put(FIELD_PSSVRDOMAINNAME, this.getPSSvrDomainName());
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
        return PSDSBookingBase.get(this, n);
    }

    private static Object get(PSDSBookingBase pSDSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingBase.getBeginTime();
            }
            case 1: {
                return pSDSBookingBase.getBookingInfo();
            }
            case 2: {
                return pSDSBookingBase.getBookingParam();
            }
            case 3: {
                return pSDSBookingBase.getBookingParam2();
            }
            case 4: {
                return pSDSBookingBase.getBookingParam3();
            }
            case 5: {
                return pSDSBookingBase.getBookingParam4();
            }
            case 6: {
                return pSDSBookingBase.getBookingState();
            }
            case 7: {
                return pSDSBookingBase.getBookingType();
            }
            case 8: {
                return pSDSBookingBase.getCreateDate();
            }
            case 9: {
                return pSDSBookingBase.getCreateMan();
            }
            case 10: {
                return pSDSBookingBase.getDuration();
            }
            case 11: {
                return pSDSBookingBase.getEndTime();
            }
            case 12: {
                return pSDSBookingBase.getHours();
            }
            case 13: {
                return pSDSBookingBase.getMemo();
            }
            case 14: {
                return pSDSBookingBase.getPSDevCenterId();
            }
            case 15: {
                return pSDSBookingBase.getPSDevCenterName();
            }
            case 16: {
                return pSDSBookingBase.getPSDevCenterServerId();
            }
            case 17: {
                return pSDSBookingBase.getPSDevCenterServerName();
            }
            case 18: {
                return pSDSBookingBase.getPSDevServerId();
            }
            case 19: {
                return pSDSBookingBase.getPSDevServerName();
            }
            case 20: {
                return pSDSBookingBase.getPSDSBookingId();
            }
            case 21: {
                return pSDSBookingBase.getPSDSBookingName();
            }
            case 22: {
                return pSDSBookingBase.getPSSvrDomainId();
            }
            case 23: {
                return pSDSBookingBase.getPSSvrDomainName();
            }
            case 24: {
                return pSDSBookingBase.getUpdateDate();
            }
            case 25: {
                return pSDSBookingBase.getUpdateMan();
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
        PSDSBookingBase.set(this, n, object);
    }

    private static void set(PSDSBookingBase pSDSBookingBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDSBookingBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDSBookingBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDSBookingBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDSBookingBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDSBookingBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDSBookingBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDSBookingBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDSBookingBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDSBookingBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDSBookingBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDSBookingBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDSBookingBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDSBookingBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDSBookingBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDSBookingBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDSBookingBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDSBookingBase.setPSDevCenterServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDSBookingBase.setPSDevCenterServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDSBookingBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDSBookingBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDSBookingBase.setPSDSBookingId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDSBookingBase.setPSDSBookingName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDSBookingBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDSBookingBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDSBookingBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDSBookingBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDSBookingBase.isNull(this, n);
    }

    private static boolean isNull(PSDSBookingBase pSDSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingBase.getBeginTime() == null;
            }
            case 1: {
                return pSDSBookingBase.getBookingInfo() == null;
            }
            case 2: {
                return pSDSBookingBase.getBookingParam() == null;
            }
            case 3: {
                return pSDSBookingBase.getBookingParam2() == null;
            }
            case 4: {
                return pSDSBookingBase.getBookingParam3() == null;
            }
            case 5: {
                return pSDSBookingBase.getBookingParam4() == null;
            }
            case 6: {
                return pSDSBookingBase.getBookingState() == null;
            }
            case 7: {
                return pSDSBookingBase.getBookingType() == null;
            }
            case 8: {
                return pSDSBookingBase.getCreateDate() == null;
            }
            case 9: {
                return pSDSBookingBase.getCreateMan() == null;
            }
            case 10: {
                return pSDSBookingBase.getDuration() == null;
            }
            case 11: {
                return pSDSBookingBase.getEndTime() == null;
            }
            case 12: {
                return pSDSBookingBase.getHours() == null;
            }
            case 13: {
                return pSDSBookingBase.getMemo() == null;
            }
            case 14: {
                return pSDSBookingBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDSBookingBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSDSBookingBase.getPSDevCenterServerId() == null;
            }
            case 17: {
                return pSDSBookingBase.getPSDevCenterServerName() == null;
            }
            case 18: {
                return pSDSBookingBase.getPSDevServerId() == null;
            }
            case 19: {
                return pSDSBookingBase.getPSDevServerName() == null;
            }
            case 20: {
                return pSDSBookingBase.getPSDSBookingId() == null;
            }
            case 21: {
                return pSDSBookingBase.getPSDSBookingName() == null;
            }
            case 22: {
                return pSDSBookingBase.getPSSvrDomainId() == null;
            }
            case 23: {
                return pSDSBookingBase.getPSSvrDomainName() == null;
            }
            case 24: {
                return pSDSBookingBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDSBookingBase.getUpdateMan() == null;
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
        return PSDSBookingBase.contains(this, n);
    }

    private static boolean contains(PSDSBookingBase pSDSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDSBookingBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDSBookingBase.isBookingInfoDirty();
            }
            case 2: {
                return pSDSBookingBase.isBookingParamDirty();
            }
            case 3: {
                return pSDSBookingBase.isBookingParam2Dirty();
            }
            case 4: {
                return pSDSBookingBase.isBookingParam3Dirty();
            }
            case 5: {
                return pSDSBookingBase.isBookingParam4Dirty();
            }
            case 6: {
                return pSDSBookingBase.isBookingStateDirty();
            }
            case 7: {
                return pSDSBookingBase.isBookingTypeDirty();
            }
            case 8: {
                return pSDSBookingBase.isCreateDateDirty();
            }
            case 9: {
                return pSDSBookingBase.isCreateManDirty();
            }
            case 10: {
                return pSDSBookingBase.isDurationDirty();
            }
            case 11: {
                return pSDSBookingBase.isEndTimeDirty();
            }
            case 12: {
                return pSDSBookingBase.isHoursDirty();
            }
            case 13: {
                return pSDSBookingBase.isMemoDirty();
            }
            case 14: {
                return pSDSBookingBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDSBookingBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSDSBookingBase.isPSDevCenterServerIdDirty();
            }
            case 17: {
                return pSDSBookingBase.isPSDevCenterServerNameDirty();
            }
            case 18: {
                return pSDSBookingBase.isPSDevServerIdDirty();
            }
            case 19: {
                return pSDSBookingBase.isPSDevServerNameDirty();
            }
            case 20: {
                return pSDSBookingBase.isPSDSBookingIdDirty();
            }
            case 21: {
                return pSDSBookingBase.isPSDSBookingNameDirty();
            }
            case 22: {
                return pSDSBookingBase.isPSSvrDomainIdDirty();
            }
            case 23: {
                return pSDSBookingBase.isPSSvrDomainNameDirty();
            }
            case 24: {
                return pSDSBookingBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDSBookingBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDSBookingBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDSBookingBase pSDSBookingBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDSBookingBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingState()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getBookingType()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getDuration()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getHours()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getMemo()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevCenterServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterserverid", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevCenterServerId()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevCenterServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterservername", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevCenterServerName()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDSBookingId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsbookingid", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDSBookingId()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSDSBookingName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsbookingname", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSDSBookingName()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDSBookingBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDSBookingBase.getJSONValue((Object)pSDSBookingBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDSBookingBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDSBookingBase pSDSBookingBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDSBookingBase.getBeginTime() != null) {
            object = pSDSBookingBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingBase.getBookingInfo() != null) {
            object = pSDSBookingBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getBookingParam() != null) {
            object = pSDSBookingBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getBookingParam2() != null) {
            object = pSDSBookingBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getBookingParam3() != null) {
            object = pSDSBookingBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getBookingParam4() != null) {
            object = pSDSBookingBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getBookingState() != null) {
            object = pSDSBookingBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingBase.getBookingType() != null) {
            object = pSDSBookingBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getCreateDate() != null) {
            object = pSDSBookingBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingBase.getCreateMan() != null) {
            object = pSDSBookingBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getDuration() != null) {
            object = pSDSBookingBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingBase.getEndTime() != null) {
            object = pSDSBookingBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingBase.getHours() != null) {
            object = pSDSBookingBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDSBookingBase.getMemo() != null) {
            object = pSDSBookingBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevCenterId() != null) {
            object = pSDSBookingBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevCenterName() != null) {
            object = pSDSBookingBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevCenterServerId() != null) {
            object = pSDSBookingBase.getPSDevCenterServerId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevCenterServerName() != null) {
            object = pSDSBookingBase.getPSDevCenterServerName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevServerId() != null) {
            object = pSDSBookingBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDevServerName() != null) {
            object = pSDSBookingBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDSBookingId() != null) {
            object = pSDSBookingBase.getPSDSBookingId();
            xmlNode.setAttribute(FIELD_PSDSBOOKINGID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSDSBookingName() != null) {
            object = pSDSBookingBase.getPSDSBookingName();
            xmlNode.setAttribute(FIELD_PSDSBOOKINGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSSvrDomainId() != null) {
            object = pSDSBookingBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getPSSvrDomainName() != null) {
            object = pSDSBookingBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDSBookingBase.getUpdateDate() != null) {
            object = pSDSBookingBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDSBookingBase.getUpdateMan() != null) {
            object = pSDSBookingBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDSBookingBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDSBookingBase pSDSBookingBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDSBookingBase.isBeginTimeDirty() && (bl || pSDSBookingBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDSBookingBase.getBeginTime());
        }
        if (pSDSBookingBase.isBookingInfoDirty() && (bl || pSDSBookingBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSDSBookingBase.getBookingInfo());
        }
        if (pSDSBookingBase.isBookingParamDirty() && (bl || pSDSBookingBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSDSBookingBase.getBookingParam());
        }
        if (pSDSBookingBase.isBookingParam2Dirty() && (bl || pSDSBookingBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSDSBookingBase.getBookingParam2());
        }
        if (pSDSBookingBase.isBookingParam3Dirty() && (bl || pSDSBookingBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSDSBookingBase.getBookingParam3());
        }
        if (pSDSBookingBase.isBookingParam4Dirty() && (bl || pSDSBookingBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSDSBookingBase.getBookingParam4());
        }
        if (pSDSBookingBase.isBookingStateDirty() && (bl || pSDSBookingBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSDSBookingBase.getBookingState());
        }
        if (pSDSBookingBase.isBookingTypeDirty() && (bl || pSDSBookingBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSDSBookingBase.getBookingType());
        }
        if (pSDSBookingBase.isCreateDateDirty() && (bl || pSDSBookingBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDSBookingBase.getCreateDate());
        }
        if (pSDSBookingBase.isCreateManDirty() && (bl || pSDSBookingBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDSBookingBase.getCreateMan());
        }
        if (pSDSBookingBase.isDurationDirty() && (bl || pSDSBookingBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSDSBookingBase.getDuration());
        }
        if (pSDSBookingBase.isEndTimeDirty() && (bl || pSDSBookingBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDSBookingBase.getEndTime());
        }
        if (pSDSBookingBase.isHoursDirty() && (bl || pSDSBookingBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSDSBookingBase.getHours());
        }
        if (pSDSBookingBase.isMemoDirty() && (bl || pSDSBookingBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDSBookingBase.getMemo());
        }
        if (pSDSBookingBase.isPSDevCenterIdDirty() && (bl || pSDSBookingBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDSBookingBase.getPSDevCenterId());
        }
        if (pSDSBookingBase.isPSDevCenterNameDirty() && (bl || pSDSBookingBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDSBookingBase.getPSDevCenterName());
        }
        if (pSDSBookingBase.isPSDevCenterServerIdDirty() && (bl || pSDSBookingBase.getPSDevCenterServerId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERID, (Object)pSDSBookingBase.getPSDevCenterServerId());
        }
        if (pSDSBookingBase.isPSDevCenterServerNameDirty() && (bl || pSDSBookingBase.getPSDevCenterServerName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERNAME, (Object)pSDSBookingBase.getPSDevCenterServerName());
        }
        if (pSDSBookingBase.isPSDevServerIdDirty() && (bl || pSDSBookingBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDSBookingBase.getPSDevServerId());
        }
        if (pSDSBookingBase.isPSDevServerNameDirty() && (bl || pSDSBookingBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDSBookingBase.getPSDevServerName());
        }
        if (pSDSBookingBase.isPSDSBookingIdDirty() && (bl || pSDSBookingBase.getPSDSBookingId() != null)) {
            iDataObject.set(FIELD_PSDSBOOKINGID, (Object)pSDSBookingBase.getPSDSBookingId());
        }
        if (pSDSBookingBase.isPSDSBookingNameDirty() && (bl || pSDSBookingBase.getPSDSBookingName() != null)) {
            iDataObject.set(FIELD_PSDSBOOKINGNAME, (Object)pSDSBookingBase.getPSDSBookingName());
        }
        if (pSDSBookingBase.isPSSvrDomainIdDirty() && (bl || pSDSBookingBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSDSBookingBase.getPSSvrDomainId());
        }
        if (pSDSBookingBase.isPSSvrDomainNameDirty() && (bl || pSDSBookingBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSDSBookingBase.getPSSvrDomainName());
        }
        if (pSDSBookingBase.isUpdateDateDirty() && (bl || pSDSBookingBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDSBookingBase.getUpdateDate());
        }
        if (pSDSBookingBase.isUpdateManDirty() && (bl || pSDSBookingBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDSBookingBase.getUpdateMan());
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
        return PSDSBookingBase.remove(this, n);
    }

    private static boolean remove(PSDSBookingBase pSDSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDSBookingBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDSBookingBase.resetBookingInfo();
                return true;
            }
            case 2: {
                pSDSBookingBase.resetBookingParam();
                return true;
            }
            case 3: {
                pSDSBookingBase.resetBookingParam2();
                return true;
            }
            case 4: {
                pSDSBookingBase.resetBookingParam3();
                return true;
            }
            case 5: {
                pSDSBookingBase.resetBookingParam4();
                return true;
            }
            case 6: {
                pSDSBookingBase.resetBookingState();
                return true;
            }
            case 7: {
                pSDSBookingBase.resetBookingType();
                return true;
            }
            case 8: {
                pSDSBookingBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSDSBookingBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSDSBookingBase.resetDuration();
                return true;
            }
            case 11: {
                pSDSBookingBase.resetEndTime();
                return true;
            }
            case 12: {
                pSDSBookingBase.resetHours();
                return true;
            }
            case 13: {
                pSDSBookingBase.resetMemo();
                return true;
            }
            case 14: {
                pSDSBookingBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDSBookingBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSDSBookingBase.resetPSDevCenterServerId();
                return true;
            }
            case 17: {
                pSDSBookingBase.resetPSDevCenterServerName();
                return true;
            }
            case 18: {
                pSDSBookingBase.resetPSDevServerId();
                return true;
            }
            case 19: {
                pSDSBookingBase.resetPSDevServerName();
                return true;
            }
            case 20: {
                pSDSBookingBase.resetPSDSBookingId();
                return true;
            }
            case 21: {
                pSDSBookingBase.resetPSDSBookingName();
                return true;
            }
            case 22: {
                pSDSBookingBase.resetPSSvrDomainId();
                return true;
            }
            case 23: {
                pSDSBookingBase.resetPSSvrDomainName();
                return true;
            }
            case 24: {
                pSDSBookingBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDSBookingBase.resetUpdateMan();
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

    private PSDSBookingBase getProxyEntity() {
        return this.proxyPSDSBookingBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDSBookingBase = null;
        if (iDataObject != null && iDataObject instanceof PSDSBookingBase) {
            this.proxyPSDSBookingBase = (PSDSBookingBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDSBookingService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_BOOKINGINFO, 1);
        fieldIndexMap.put(FIELD_BOOKINGPARAM, 2);
        fieldIndexMap.put(FIELD_BOOKINGPARAM2, 3);
        fieldIndexMap.put(FIELD_BOOKINGPARAM3, 4);
        fieldIndexMap.put(FIELD_BOOKINGPARAM4, 5);
        fieldIndexMap.put(FIELD_BOOKINGSTATE, 6);
        fieldIndexMap.put(FIELD_BOOKINGTYPE, 7);
        fieldIndexMap.put(FIELD_CREATEDATE, 8);
        fieldIndexMap.put(FIELD_CREATEMAN, 9);
        fieldIndexMap.put(FIELD_DURATION, 10);
        fieldIndexMap.put(FIELD_ENDTIME, 11);
        fieldIndexMap.put(FIELD_HOURS, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 18);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 19);
        fieldIndexMap.put(FIELD_PSDSBOOKINGID, 20);
        fieldIndexMap.put(FIELD_PSDSBOOKINGNAME, 21);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 22);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

