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
import net.ibizsys.pscore.srv.paasmgr.service.PSAppServerService;
import net.ibizsys.pscore.srv.paasmgr.service.PSSvrDomainService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSASBookingBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSASBookingBase.class);
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
    public static final String FIELD_PSAPPSERVERID = "PSAPPSERVERID";
    public static final String FIELD_PSAPPSERVERNAME = "PSAPPSERVERNAME";
    public static final String FIELD_PSASBOOKINGID = "PSASBOOKINGID";
    public static final String FIELD_PSASBOOKINGNAME = "PSASBOOKINGNAME";
    public static final String FIELD_PSDEVCENTERASID = "PSDEVCENTERASID";
    public static final String FIELD_PSDEVCENTERASNAME = "PSDEVCENTERASNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
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
    private static final int INDEX_PSAPPSERVERID = 14;
    private static final int INDEX_PSAPPSERVERNAME = 15;
    private static final int INDEX_PSASBOOKINGID = 16;
    private static final int INDEX_PSASBOOKINGNAME = 17;
    private static final int INDEX_PSDEVCENTERASID = 18;
    private static final int INDEX_PSDEVCENTERASNAME = 19;
    private static final int INDEX_PSDEVCENTERID = 20;
    private static final int INDEX_PSDEVCENTERNAME = 21;
    private static final int INDEX_PSSVRDOMAINID = 22;
    private static final int INDEX_PSSVRDOMAINNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSASBookingBase proxyPSASBookingBase = null;
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
    private boolean psappserveridDirtyFlag = false;
    private boolean psappservernameDirtyFlag = false;
    private boolean psasbookingidDirtyFlag = false;
    private boolean psasbookingnameDirtyFlag = false;
    private boolean psdevcenterasidDirtyFlag = false;
    private boolean psdevcenterasnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
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
    @Column(name="psappserverid")
    private String psappserverid;
    @Column(name="psappservername")
    private String psappservername;
    @Column(name="psasbookingid")
    private String psasbookingid;
    @Column(name="psasbookingname")
    private String psasbookingname;
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
    private Integer objPSSvrDomainLock = new Integer(1);
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

    public void setPSASBookingId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASBookingId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasbookingid = string;
        this.psasbookingidDirtyFlag = true;
    }

    public String getPSASBookingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBookingId();
        }
        return this.psasbookingid;
    }

    public boolean isPSASBookingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASBookingIdDirty();
        }
        return this.psasbookingidDirtyFlag;
    }

    public void resetPSASBookingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASBookingId();
            return;
        }
        this.psasbookingidDirtyFlag = false;
        this.psasbookingid = null;
    }

    public void setPSASBookingName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSASBookingName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psasbookingname = string;
        this.psasbookingnameDirtyFlag = true;
    }

    public String getPSASBookingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSASBookingName();
        }
        return this.psasbookingname;
    }

    public boolean isPSASBookingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSASBookingNameDirty();
        }
        return this.psasbookingnameDirtyFlag;
    }

    public void resetPSASBookingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSASBookingName();
            return;
        }
        this.psasbookingnameDirtyFlag = false;
        this.psasbookingname = null;
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
        PSASBookingBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSASBookingBase pSASBookingBase) {
        pSASBookingBase.resetBeginTime();
        pSASBookingBase.resetBookingInfo();
        pSASBookingBase.resetBookingParam();
        pSASBookingBase.resetBookingParam2();
        pSASBookingBase.resetBookingParam3();
        pSASBookingBase.resetBookingParam4();
        pSASBookingBase.resetBookingState();
        pSASBookingBase.resetBookingType();
        pSASBookingBase.resetCreateDate();
        pSASBookingBase.resetCreateMan();
        pSASBookingBase.resetDuration();
        pSASBookingBase.resetEndTime();
        pSASBookingBase.resetHours();
        pSASBookingBase.resetMemo();
        pSASBookingBase.resetPSAppServerId();
        pSASBookingBase.resetPSAppServerName();
        pSASBookingBase.resetPSASBookingId();
        pSASBookingBase.resetPSASBookingName();
        pSASBookingBase.resetPSDevCenterASId();
        pSASBookingBase.resetPSDevCenterASName();
        pSASBookingBase.resetPSDevCenterId();
        pSASBookingBase.resetPSDevCenterName();
        pSASBookingBase.resetPSSvrDomainId();
        pSASBookingBase.resetPSSvrDomainName();
        pSASBookingBase.resetUpdateDate();
        pSASBookingBase.resetUpdateMan();
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
        if (!bl || this.isPSAppServerIdDirty()) {
            hashMap.put(FIELD_PSAPPSERVERID, this.getPSAppServerId());
        }
        if (!bl || this.isPSAppServerNameDirty()) {
            hashMap.put(FIELD_PSAPPSERVERNAME, this.getPSAppServerName());
        }
        if (!bl || this.isPSASBookingIdDirty()) {
            hashMap.put(FIELD_PSASBOOKINGID, this.getPSASBookingId());
        }
        if (!bl || this.isPSASBookingNameDirty()) {
            hashMap.put(FIELD_PSASBOOKINGNAME, this.getPSASBookingName());
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
        return PSASBookingBase.get(this, n);
    }

    private static Object get(PSASBookingBase pSASBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingBase.getBeginTime();
            }
            case 1: {
                return pSASBookingBase.getBookingInfo();
            }
            case 2: {
                return pSASBookingBase.getBookingParam();
            }
            case 3: {
                return pSASBookingBase.getBookingParam2();
            }
            case 4: {
                return pSASBookingBase.getBookingParam3();
            }
            case 5: {
                return pSASBookingBase.getBookingParam4();
            }
            case 6: {
                return pSASBookingBase.getBookingState();
            }
            case 7: {
                return pSASBookingBase.getBookingType();
            }
            case 8: {
                return pSASBookingBase.getCreateDate();
            }
            case 9: {
                return pSASBookingBase.getCreateMan();
            }
            case 10: {
                return pSASBookingBase.getDuration();
            }
            case 11: {
                return pSASBookingBase.getEndTime();
            }
            case 12: {
                return pSASBookingBase.getHours();
            }
            case 13: {
                return pSASBookingBase.getMemo();
            }
            case 14: {
                return pSASBookingBase.getPSAppServerId();
            }
            case 15: {
                return pSASBookingBase.getPSAppServerName();
            }
            case 16: {
                return pSASBookingBase.getPSASBookingId();
            }
            case 17: {
                return pSASBookingBase.getPSASBookingName();
            }
            case 18: {
                return pSASBookingBase.getPSDevCenterASId();
            }
            case 19: {
                return pSASBookingBase.getPSDevCenterASName();
            }
            case 20: {
                return pSASBookingBase.getPSDevCenterId();
            }
            case 21: {
                return pSASBookingBase.getPSDevCenterName();
            }
            case 22: {
                return pSASBookingBase.getPSSvrDomainId();
            }
            case 23: {
                return pSASBookingBase.getPSSvrDomainName();
            }
            case 24: {
                return pSASBookingBase.getUpdateDate();
            }
            case 25: {
                return pSASBookingBase.getUpdateMan();
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
        PSASBookingBase.set(this, n, object);
    }

    private static void set(PSASBookingBase pSASBookingBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSASBookingBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSASBookingBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSASBookingBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSASBookingBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSASBookingBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSASBookingBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSASBookingBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSASBookingBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSASBookingBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSASBookingBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSASBookingBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSASBookingBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSASBookingBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSASBookingBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSASBookingBase.setPSAppServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSASBookingBase.setPSAppServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSASBookingBase.setPSASBookingId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSASBookingBase.setPSASBookingName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSASBookingBase.setPSDevCenterASId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSASBookingBase.setPSDevCenterASName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSASBookingBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSASBookingBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSASBookingBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSASBookingBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSASBookingBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSASBookingBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSASBookingBase.isNull(this, n);
    }

    private static boolean isNull(PSASBookingBase pSASBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingBase.getBeginTime() == null;
            }
            case 1: {
                return pSASBookingBase.getBookingInfo() == null;
            }
            case 2: {
                return pSASBookingBase.getBookingParam() == null;
            }
            case 3: {
                return pSASBookingBase.getBookingParam2() == null;
            }
            case 4: {
                return pSASBookingBase.getBookingParam3() == null;
            }
            case 5: {
                return pSASBookingBase.getBookingParam4() == null;
            }
            case 6: {
                return pSASBookingBase.getBookingState() == null;
            }
            case 7: {
                return pSASBookingBase.getBookingType() == null;
            }
            case 8: {
                return pSASBookingBase.getCreateDate() == null;
            }
            case 9: {
                return pSASBookingBase.getCreateMan() == null;
            }
            case 10: {
                return pSASBookingBase.getDuration() == null;
            }
            case 11: {
                return pSASBookingBase.getEndTime() == null;
            }
            case 12: {
                return pSASBookingBase.getHours() == null;
            }
            case 13: {
                return pSASBookingBase.getMemo() == null;
            }
            case 14: {
                return pSASBookingBase.getPSAppServerId() == null;
            }
            case 15: {
                return pSASBookingBase.getPSAppServerName() == null;
            }
            case 16: {
                return pSASBookingBase.getPSASBookingId() == null;
            }
            case 17: {
                return pSASBookingBase.getPSASBookingName() == null;
            }
            case 18: {
                return pSASBookingBase.getPSDevCenterASId() == null;
            }
            case 19: {
                return pSASBookingBase.getPSDevCenterASName() == null;
            }
            case 20: {
                return pSASBookingBase.getPSDevCenterId() == null;
            }
            case 21: {
                return pSASBookingBase.getPSDevCenterName() == null;
            }
            case 22: {
                return pSASBookingBase.getPSSvrDomainId() == null;
            }
            case 23: {
                return pSASBookingBase.getPSSvrDomainName() == null;
            }
            case 24: {
                return pSASBookingBase.getUpdateDate() == null;
            }
            case 25: {
                return pSASBookingBase.getUpdateMan() == null;
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
        return PSASBookingBase.contains(this, n);
    }

    private static boolean contains(PSASBookingBase pSASBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSASBookingBase.isBeginTimeDirty();
            }
            case 1: {
                return pSASBookingBase.isBookingInfoDirty();
            }
            case 2: {
                return pSASBookingBase.isBookingParamDirty();
            }
            case 3: {
                return pSASBookingBase.isBookingParam2Dirty();
            }
            case 4: {
                return pSASBookingBase.isBookingParam3Dirty();
            }
            case 5: {
                return pSASBookingBase.isBookingParam4Dirty();
            }
            case 6: {
                return pSASBookingBase.isBookingStateDirty();
            }
            case 7: {
                return pSASBookingBase.isBookingTypeDirty();
            }
            case 8: {
                return pSASBookingBase.isCreateDateDirty();
            }
            case 9: {
                return pSASBookingBase.isCreateManDirty();
            }
            case 10: {
                return pSASBookingBase.isDurationDirty();
            }
            case 11: {
                return pSASBookingBase.isEndTimeDirty();
            }
            case 12: {
                return pSASBookingBase.isHoursDirty();
            }
            case 13: {
                return pSASBookingBase.isMemoDirty();
            }
            case 14: {
                return pSASBookingBase.isPSAppServerIdDirty();
            }
            case 15: {
                return pSASBookingBase.isPSAppServerNameDirty();
            }
            case 16: {
                return pSASBookingBase.isPSASBookingIdDirty();
            }
            case 17: {
                return pSASBookingBase.isPSASBookingNameDirty();
            }
            case 18: {
                return pSASBookingBase.isPSDevCenterASIdDirty();
            }
            case 19: {
                return pSASBookingBase.isPSDevCenterASNameDirty();
            }
            case 20: {
                return pSASBookingBase.isPSDevCenterIdDirty();
            }
            case 21: {
                return pSASBookingBase.isPSDevCenterNameDirty();
            }
            case 22: {
                return pSASBookingBase.isPSSvrDomainIdDirty();
            }
            case 23: {
                return pSASBookingBase.isPSSvrDomainNameDirty();
            }
            case 24: {
                return pSASBookingBase.isUpdateDateDirty();
            }
            case 25: {
                return pSASBookingBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSASBookingBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSASBookingBase pSASBookingBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSASBookingBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingState()), (boolean)false);
        }
        if (bl || pSASBookingBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getBookingType()), (boolean)false);
        }
        if (bl || pSASBookingBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSASBookingBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSASBookingBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getDuration()), (boolean)false);
        }
        if (bl || pSASBookingBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getEndTime()), (boolean)false);
        }
        if (bl || pSASBookingBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getHours()), (boolean)false);
        }
        if (bl || pSASBookingBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getMemo()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSAppServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappserverid", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSAppServerId()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSAppServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappservername", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSAppServerName()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSASBookingId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasbookingid", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSASBookingId()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSASBookingName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psasbookingname", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSASBookingName()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSDevCenterASId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasid", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSDevCenterASId()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSDevCenterASName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterasname", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSDevCenterASName()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSASBookingBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSASBookingBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSASBookingBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSASBookingBase.getJSONValue((Object)pSASBookingBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSASBookingBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSASBookingBase pSASBookingBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSASBookingBase.getBeginTime() != null) {
            object = pSASBookingBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingBase.getBookingInfo() != null) {
            object = pSASBookingBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getBookingParam() != null) {
            object = pSASBookingBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getBookingParam2() != null) {
            object = pSASBookingBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getBookingParam3() != null) {
            object = pSASBookingBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getBookingParam4() != null) {
            object = pSASBookingBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getBookingState() != null) {
            object = pSASBookingBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingBase.getBookingType() != null) {
            object = pSASBookingBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getCreateDate() != null) {
            object = pSASBookingBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingBase.getCreateMan() != null) {
            object = pSASBookingBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getDuration() != null) {
            object = pSASBookingBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingBase.getEndTime() != null) {
            object = pSASBookingBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingBase.getHours() != null) {
            object = pSASBookingBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSASBookingBase.getMemo() != null) {
            object = pSASBookingBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSAppServerId() != null) {
            object = pSASBookingBase.getPSAppServerId();
            xmlNode.setAttribute(FIELD_PSAPPSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSAppServerName() != null) {
            object = pSASBookingBase.getPSAppServerName();
            xmlNode.setAttribute(FIELD_PSAPPSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSASBookingId() != null) {
            object = pSASBookingBase.getPSASBookingId();
            xmlNode.setAttribute(FIELD_PSASBOOKINGID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSASBookingName() != null) {
            object = pSASBookingBase.getPSASBookingName();
            xmlNode.setAttribute(FIELD_PSASBOOKINGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSDevCenterASId() != null) {
            object = pSASBookingBase.getPSDevCenterASId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSDevCenterASName() != null) {
            object = pSASBookingBase.getPSDevCenterASName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSDevCenterId() != null) {
            object = pSASBookingBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSDevCenterName() != null) {
            object = pSASBookingBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSSvrDomainId() != null) {
            object = pSASBookingBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getPSSvrDomainName() != null) {
            object = pSASBookingBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSASBookingBase.getUpdateDate() != null) {
            object = pSASBookingBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSASBookingBase.getUpdateMan() != null) {
            object = pSASBookingBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSASBookingBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSASBookingBase pSASBookingBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSASBookingBase.isBeginTimeDirty() && (bl || pSASBookingBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSASBookingBase.getBeginTime());
        }
        if (pSASBookingBase.isBookingInfoDirty() && (bl || pSASBookingBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSASBookingBase.getBookingInfo());
        }
        if (pSASBookingBase.isBookingParamDirty() && (bl || pSASBookingBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSASBookingBase.getBookingParam());
        }
        if (pSASBookingBase.isBookingParam2Dirty() && (bl || pSASBookingBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSASBookingBase.getBookingParam2());
        }
        if (pSASBookingBase.isBookingParam3Dirty() && (bl || pSASBookingBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSASBookingBase.getBookingParam3());
        }
        if (pSASBookingBase.isBookingParam4Dirty() && (bl || pSASBookingBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSASBookingBase.getBookingParam4());
        }
        if (pSASBookingBase.isBookingStateDirty() && (bl || pSASBookingBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSASBookingBase.getBookingState());
        }
        if (pSASBookingBase.isBookingTypeDirty() && (bl || pSASBookingBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSASBookingBase.getBookingType());
        }
        if (pSASBookingBase.isCreateDateDirty() && (bl || pSASBookingBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSASBookingBase.getCreateDate());
        }
        if (pSASBookingBase.isCreateManDirty() && (bl || pSASBookingBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSASBookingBase.getCreateMan());
        }
        if (pSASBookingBase.isDurationDirty() && (bl || pSASBookingBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSASBookingBase.getDuration());
        }
        if (pSASBookingBase.isEndTimeDirty() && (bl || pSASBookingBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSASBookingBase.getEndTime());
        }
        if (pSASBookingBase.isHoursDirty() && (bl || pSASBookingBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSASBookingBase.getHours());
        }
        if (pSASBookingBase.isMemoDirty() && (bl || pSASBookingBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSASBookingBase.getMemo());
        }
        if (pSASBookingBase.isPSAppServerIdDirty() && (bl || pSASBookingBase.getPSAppServerId() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERID, (Object)pSASBookingBase.getPSAppServerId());
        }
        if (pSASBookingBase.isPSAppServerNameDirty() && (bl || pSASBookingBase.getPSAppServerName() != null)) {
            iDataObject.set(FIELD_PSAPPSERVERNAME, (Object)pSASBookingBase.getPSAppServerName());
        }
        if (pSASBookingBase.isPSASBookingIdDirty() && (bl || pSASBookingBase.getPSASBookingId() != null)) {
            iDataObject.set(FIELD_PSASBOOKINGID, (Object)pSASBookingBase.getPSASBookingId());
        }
        if (pSASBookingBase.isPSASBookingNameDirty() && (bl || pSASBookingBase.getPSASBookingName() != null)) {
            iDataObject.set(FIELD_PSASBOOKINGNAME, (Object)pSASBookingBase.getPSASBookingName());
        }
        if (pSASBookingBase.isPSDevCenterASIdDirty() && (bl || pSASBookingBase.getPSDevCenterASId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASID, (Object)pSASBookingBase.getPSDevCenterASId());
        }
        if (pSASBookingBase.isPSDevCenterASNameDirty() && (bl || pSASBookingBase.getPSDevCenterASName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERASNAME, (Object)pSASBookingBase.getPSDevCenterASName());
        }
        if (pSASBookingBase.isPSDevCenterIdDirty() && (bl || pSASBookingBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSASBookingBase.getPSDevCenterId());
        }
        if (pSASBookingBase.isPSDevCenterNameDirty() && (bl || pSASBookingBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSASBookingBase.getPSDevCenterName());
        }
        if (pSASBookingBase.isPSSvrDomainIdDirty() && (bl || pSASBookingBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSASBookingBase.getPSSvrDomainId());
        }
        if (pSASBookingBase.isPSSvrDomainNameDirty() && (bl || pSASBookingBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSASBookingBase.getPSSvrDomainName());
        }
        if (pSASBookingBase.isUpdateDateDirty() && (bl || pSASBookingBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSASBookingBase.getUpdateDate());
        }
        if (pSASBookingBase.isUpdateManDirty() && (bl || pSASBookingBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSASBookingBase.getUpdateMan());
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
        return PSASBookingBase.remove(this, n);
    }

    private static boolean remove(PSASBookingBase pSASBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSASBookingBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSASBookingBase.resetBookingInfo();
                return true;
            }
            case 2: {
                pSASBookingBase.resetBookingParam();
                return true;
            }
            case 3: {
                pSASBookingBase.resetBookingParam2();
                return true;
            }
            case 4: {
                pSASBookingBase.resetBookingParam3();
                return true;
            }
            case 5: {
                pSASBookingBase.resetBookingParam4();
                return true;
            }
            case 6: {
                pSASBookingBase.resetBookingState();
                return true;
            }
            case 7: {
                pSASBookingBase.resetBookingType();
                return true;
            }
            case 8: {
                pSASBookingBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSASBookingBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSASBookingBase.resetDuration();
                return true;
            }
            case 11: {
                pSASBookingBase.resetEndTime();
                return true;
            }
            case 12: {
                pSASBookingBase.resetHours();
                return true;
            }
            case 13: {
                pSASBookingBase.resetMemo();
                return true;
            }
            case 14: {
                pSASBookingBase.resetPSAppServerId();
                return true;
            }
            case 15: {
                pSASBookingBase.resetPSAppServerName();
                return true;
            }
            case 16: {
                pSASBookingBase.resetPSASBookingId();
                return true;
            }
            case 17: {
                pSASBookingBase.resetPSASBookingName();
                return true;
            }
            case 18: {
                pSASBookingBase.resetPSDevCenterASId();
                return true;
            }
            case 19: {
                pSASBookingBase.resetPSDevCenterASName();
                return true;
            }
            case 20: {
                pSASBookingBase.resetPSDevCenterId();
                return true;
            }
            case 21: {
                pSASBookingBase.resetPSDevCenterName();
                return true;
            }
            case 22: {
                pSASBookingBase.resetPSSvrDomainId();
                return true;
            }
            case 23: {
                pSASBookingBase.resetPSSvrDomainName();
                return true;
            }
            case 24: {
                pSASBookingBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSASBookingBase.resetUpdateMan();
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

    private PSASBookingBase getProxyEntity() {
        return this.proxyPSASBookingBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSASBookingBase = null;
        if (iDataObject != null && iDataObject instanceof PSASBookingBase) {
            this.proxyPSASBookingBase = (PSASBookingBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSASBookingService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSAPPSERVERID, 14);
        fieldIndexMap.put(FIELD_PSAPPSERVERNAME, 15);
        fieldIndexMap.put(FIELD_PSASBOOKINGID, 16);
        fieldIndexMap.put(FIELD_PSASBOOKINGNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERASID, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERASNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 21);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 22);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

