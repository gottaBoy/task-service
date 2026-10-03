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

public abstract class PSWSBookingBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWSBookingBase.class);
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
    public static final String FIELD_PSWSBOOKINGID = "PSWSBOOKINGID";
    public static final String FIELD_PSWSBOOKINGNAME = "PSWSBOOKINGNAME";
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
    private static final int INDEX_PSDCWORKSPACEID = 14;
    private static final int INDEX_PSDCWORKSPACENAME = 15;
    private static final int INDEX_PSDEVCENTERID = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSSVRDOMAINID = 18;
    private static final int INDEX_PSSVRDOMAINNAME = 19;
    private static final int INDEX_PSTASKSERVERID = 20;
    private static final int INDEX_PSTASKSERVERNAME = 21;
    private static final int INDEX_PSWORKSPACEID = 22;
    private static final int INDEX_PSWORKSPACENAME = 23;
    private static final int INDEX_PSWSBOOKINGID = 24;
    private static final int INDEX_PSWSBOOKINGNAME = 25;
    private static final int INDEX_UPDATEDATE = 26;
    private static final int INDEX_UPDATEMAN = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWSBookingBase proxyPSWSBookingBase = null;
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
    private boolean pswsbookingidDirtyFlag = false;
    private boolean pswsbookingnameDirtyFlag = false;
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
    @Column(name="pswsbookingid")
    private String pswsbookingid;
    @Column(name="pswsbookingname")
    private String pswsbookingname;
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

    public void setPSWSBookingId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWSBookingId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswsbookingid = string;
        this.pswsbookingidDirtyFlag = true;
    }

    public String getPSWSBookingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWSBookingId();
        }
        return this.pswsbookingid;
    }

    public boolean isPSWSBookingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWSBookingIdDirty();
        }
        return this.pswsbookingidDirtyFlag;
    }

    public void resetPSWSBookingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWSBookingId();
            return;
        }
        this.pswsbookingidDirtyFlag = false;
        this.pswsbookingid = null;
    }

    public void setPSWSBookingName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWSBookingName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswsbookingname = string;
        this.pswsbookingnameDirtyFlag = true;
    }

    public String getPSWSBookingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWSBookingName();
        }
        return this.pswsbookingname;
    }

    public boolean isPSWSBookingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWSBookingNameDirty();
        }
        return this.pswsbookingnameDirtyFlag;
    }

    public void resetPSWSBookingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWSBookingName();
            return;
        }
        this.pswsbookingnameDirtyFlag = false;
        this.pswsbookingname = null;
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
        PSWSBookingBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWSBookingBase pSWSBookingBase) {
        pSWSBookingBase.resetBeginTime();
        pSWSBookingBase.resetBookingInfo();
        pSWSBookingBase.resetBookingParam();
        pSWSBookingBase.resetBookingParam2();
        pSWSBookingBase.resetBookingParam3();
        pSWSBookingBase.resetBookingParam4();
        pSWSBookingBase.resetBookingState();
        pSWSBookingBase.resetBookingType();
        pSWSBookingBase.resetCreateDate();
        pSWSBookingBase.resetCreateMan();
        pSWSBookingBase.resetDuration();
        pSWSBookingBase.resetEndTime();
        pSWSBookingBase.resetHours();
        pSWSBookingBase.resetMemo();
        pSWSBookingBase.resetPSDCWorkspaceId();
        pSWSBookingBase.resetPSDCWorkspaceName();
        pSWSBookingBase.resetPSDevCenterId();
        pSWSBookingBase.resetPSDevCenterName();
        pSWSBookingBase.resetPSSvrDomainId();
        pSWSBookingBase.resetPSSvrDomainName();
        pSWSBookingBase.resetPSTaskServerId();
        pSWSBookingBase.resetPSTaskServerName();
        pSWSBookingBase.resetPSWorkspaceId();
        pSWSBookingBase.resetPSWorkspaceName();
        pSWSBookingBase.resetPSWSBookingId();
        pSWSBookingBase.resetPSWSBookingName();
        pSWSBookingBase.resetUpdateDate();
        pSWSBookingBase.resetUpdateMan();
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
        if (!bl || this.isPSWSBookingIdDirty()) {
            hashMap.put(FIELD_PSWSBOOKINGID, this.getPSWSBookingId());
        }
        if (!bl || this.isPSWSBookingNameDirty()) {
            hashMap.put(FIELD_PSWSBOOKINGNAME, this.getPSWSBookingName());
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
        return PSWSBookingBase.get(this, n);
    }

    private static Object get(PSWSBookingBase pSWSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingBase.getBeginTime();
            }
            case 1: {
                return pSWSBookingBase.getBookingInfo();
            }
            case 2: {
                return pSWSBookingBase.getBookingParam();
            }
            case 3: {
                return pSWSBookingBase.getBookingParam2();
            }
            case 4: {
                return pSWSBookingBase.getBookingParam3();
            }
            case 5: {
                return pSWSBookingBase.getBookingParam4();
            }
            case 6: {
                return pSWSBookingBase.getBookingState();
            }
            case 7: {
                return pSWSBookingBase.getBookingType();
            }
            case 8: {
                return pSWSBookingBase.getCreateDate();
            }
            case 9: {
                return pSWSBookingBase.getCreateMan();
            }
            case 10: {
                return pSWSBookingBase.getDuration();
            }
            case 11: {
                return pSWSBookingBase.getEndTime();
            }
            case 12: {
                return pSWSBookingBase.getHours();
            }
            case 13: {
                return pSWSBookingBase.getMemo();
            }
            case 14: {
                return pSWSBookingBase.getPSDCWorkspaceId();
            }
            case 15: {
                return pSWSBookingBase.getPSDCWorkspaceName();
            }
            case 16: {
                return pSWSBookingBase.getPSDevCenterId();
            }
            case 17: {
                return pSWSBookingBase.getPSDevCenterName();
            }
            case 18: {
                return pSWSBookingBase.getPSSvrDomainId();
            }
            case 19: {
                return pSWSBookingBase.getPSSvrDomainName();
            }
            case 20: {
                return pSWSBookingBase.getPSTaskServerId();
            }
            case 21: {
                return pSWSBookingBase.getPSTaskServerName();
            }
            case 22: {
                return pSWSBookingBase.getPSWorkspaceId();
            }
            case 23: {
                return pSWSBookingBase.getPSWorkspaceName();
            }
            case 24: {
                return pSWSBookingBase.getPSWSBookingId();
            }
            case 25: {
                return pSWSBookingBase.getPSWSBookingName();
            }
            case 26: {
                return pSWSBookingBase.getUpdateDate();
            }
            case 27: {
                return pSWSBookingBase.getUpdateMan();
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
        PSWSBookingBase.set(this, n, object);
    }

    private static void set(PSWSBookingBase pSWSBookingBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWSBookingBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWSBookingBase.setBookingInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWSBookingBase.setBookingParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWSBookingBase.setBookingParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWSBookingBase.setBookingParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWSBookingBase.setBookingParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWSBookingBase.setBookingState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSWSBookingBase.setBookingType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWSBookingBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSWSBookingBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWSBookingBase.setDuration(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSWSBookingBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSWSBookingBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSWSBookingBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWSBookingBase.setPSDCWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWSBookingBase.setPSDCWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWSBookingBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWSBookingBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWSBookingBase.setPSSvrDomainId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWSBookingBase.setPSSvrDomainName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWSBookingBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWSBookingBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWSBookingBase.setPSWorkspaceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWSBookingBase.setPSWorkspaceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWSBookingBase.setPSWSBookingId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSWSBookingBase.setPSWSBookingName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSWSBookingBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 27: {
                pSWSBookingBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWSBookingBase.isNull(this, n);
    }

    private static boolean isNull(PSWSBookingBase pSWSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingBase.getBeginTime() == null;
            }
            case 1: {
                return pSWSBookingBase.getBookingInfo() == null;
            }
            case 2: {
                return pSWSBookingBase.getBookingParam() == null;
            }
            case 3: {
                return pSWSBookingBase.getBookingParam2() == null;
            }
            case 4: {
                return pSWSBookingBase.getBookingParam3() == null;
            }
            case 5: {
                return pSWSBookingBase.getBookingParam4() == null;
            }
            case 6: {
                return pSWSBookingBase.getBookingState() == null;
            }
            case 7: {
                return pSWSBookingBase.getBookingType() == null;
            }
            case 8: {
                return pSWSBookingBase.getCreateDate() == null;
            }
            case 9: {
                return pSWSBookingBase.getCreateMan() == null;
            }
            case 10: {
                return pSWSBookingBase.getDuration() == null;
            }
            case 11: {
                return pSWSBookingBase.getEndTime() == null;
            }
            case 12: {
                return pSWSBookingBase.getHours() == null;
            }
            case 13: {
                return pSWSBookingBase.getMemo() == null;
            }
            case 14: {
                return pSWSBookingBase.getPSDCWorkspaceId() == null;
            }
            case 15: {
                return pSWSBookingBase.getPSDCWorkspaceName() == null;
            }
            case 16: {
                return pSWSBookingBase.getPSDevCenterId() == null;
            }
            case 17: {
                return pSWSBookingBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSWSBookingBase.getPSSvrDomainId() == null;
            }
            case 19: {
                return pSWSBookingBase.getPSSvrDomainName() == null;
            }
            case 20: {
                return pSWSBookingBase.getPSTaskServerId() == null;
            }
            case 21: {
                return pSWSBookingBase.getPSTaskServerName() == null;
            }
            case 22: {
                return pSWSBookingBase.getPSWorkspaceId() == null;
            }
            case 23: {
                return pSWSBookingBase.getPSWorkspaceName() == null;
            }
            case 24: {
                return pSWSBookingBase.getPSWSBookingId() == null;
            }
            case 25: {
                return pSWSBookingBase.getPSWSBookingName() == null;
            }
            case 26: {
                return pSWSBookingBase.getUpdateDate() == null;
            }
            case 27: {
                return pSWSBookingBase.getUpdateMan() == null;
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
        return PSWSBookingBase.contains(this, n);
    }

    private static boolean contains(PSWSBookingBase pSWSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWSBookingBase.isBeginTimeDirty();
            }
            case 1: {
                return pSWSBookingBase.isBookingInfoDirty();
            }
            case 2: {
                return pSWSBookingBase.isBookingParamDirty();
            }
            case 3: {
                return pSWSBookingBase.isBookingParam2Dirty();
            }
            case 4: {
                return pSWSBookingBase.isBookingParam3Dirty();
            }
            case 5: {
                return pSWSBookingBase.isBookingParam4Dirty();
            }
            case 6: {
                return pSWSBookingBase.isBookingStateDirty();
            }
            case 7: {
                return pSWSBookingBase.isBookingTypeDirty();
            }
            case 8: {
                return pSWSBookingBase.isCreateDateDirty();
            }
            case 9: {
                return pSWSBookingBase.isCreateManDirty();
            }
            case 10: {
                return pSWSBookingBase.isDurationDirty();
            }
            case 11: {
                return pSWSBookingBase.isEndTimeDirty();
            }
            case 12: {
                return pSWSBookingBase.isHoursDirty();
            }
            case 13: {
                return pSWSBookingBase.isMemoDirty();
            }
            case 14: {
                return pSWSBookingBase.isPSDCWorkspaceIdDirty();
            }
            case 15: {
                return pSWSBookingBase.isPSDCWorkspaceNameDirty();
            }
            case 16: {
                return pSWSBookingBase.isPSDevCenterIdDirty();
            }
            case 17: {
                return pSWSBookingBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSWSBookingBase.isPSSvrDomainIdDirty();
            }
            case 19: {
                return pSWSBookingBase.isPSSvrDomainNameDirty();
            }
            case 20: {
                return pSWSBookingBase.isPSTaskServerIdDirty();
            }
            case 21: {
                return pSWSBookingBase.isPSTaskServerNameDirty();
            }
            case 22: {
                return pSWSBookingBase.isPSWorkspaceIdDirty();
            }
            case 23: {
                return pSWSBookingBase.isPSWorkspaceNameDirty();
            }
            case 24: {
                return pSWSBookingBase.isPSWSBookingIdDirty();
            }
            case 25: {
                return pSWSBookingBase.isPSWSBookingNameDirty();
            }
            case 26: {
                return pSWSBookingBase.isUpdateDateDirty();
            }
            case 27: {
                return pSWSBookingBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWSBookingBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWSBookingBase pSWSBookingBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWSBookingBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookinginfo", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingInfo()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingParam()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam2", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingParam2()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam3", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingParam3()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingparam4", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingParam4()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingstate", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingState()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getBookingType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bookingtype", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getBookingType()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getDuration() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"duration", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getDuration()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getEndTime()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getHours()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getMemo()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSDCWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspaceid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSDCWorkspaceId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSDCWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcworkspacename", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSDCWorkspaceName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSSvrDomainId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSSvrDomainId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSSvrDomainName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssvrdomainname", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSSvrDomainName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSWorkspaceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspaceid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSWorkspaceId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSWorkspaceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psworkspacename", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSWorkspaceName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSWSBookingId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswsbookingid", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSWSBookingId()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getPSWSBookingName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswsbookingname", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getPSWSBookingName()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWSBookingBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWSBookingBase.getJSONValue((Object)pSWSBookingBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWSBookingBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWSBookingBase pSWSBookingBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWSBookingBase.getBeginTime() != null) {
            object = pSWSBookingBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingBase.getBookingInfo() != null) {
            object = pSWSBookingBase.getBookingInfo();
            xmlNode.setAttribute(FIELD_BOOKINGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getBookingParam() != null) {
            object = pSWSBookingBase.getBookingParam();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getBookingParam2() != null) {
            object = pSWSBookingBase.getBookingParam2();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getBookingParam3() != null) {
            object = pSWSBookingBase.getBookingParam3();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getBookingParam4() != null) {
            object = pSWSBookingBase.getBookingParam4();
            xmlNode.setAttribute(FIELD_BOOKINGPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getBookingState() != null) {
            object = pSWSBookingBase.getBookingState();
            xmlNode.setAttribute(FIELD_BOOKINGSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingBase.getBookingType() != null) {
            object = pSWSBookingBase.getBookingType();
            xmlNode.setAttribute(FIELD_BOOKINGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getCreateDate() != null) {
            object = pSWSBookingBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingBase.getCreateMan() != null) {
            object = pSWSBookingBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getDuration() != null) {
            object = pSWSBookingBase.getDuration();
            xmlNode.setAttribute(FIELD_DURATION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingBase.getEndTime() != null) {
            object = pSWSBookingBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingBase.getHours() != null) {
            object = pSWSBookingBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWSBookingBase.getMemo() != null) {
            object = pSWSBookingBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSDCWorkspaceId() != null) {
            object = pSWSBookingBase.getPSDCWorkspaceId();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSDCWorkspaceName() != null) {
            object = pSWSBookingBase.getPSDCWorkspaceName();
            xmlNode.setAttribute(FIELD_PSDCWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSDevCenterId() != null) {
            object = pSWSBookingBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSDevCenterName() != null) {
            object = pSWSBookingBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSSvrDomainId() != null) {
            object = pSWSBookingBase.getPSSvrDomainId();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSSvrDomainName() != null) {
            object = pSWSBookingBase.getPSSvrDomainName();
            xmlNode.setAttribute(FIELD_PSSVRDOMAINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSTaskServerId() != null) {
            object = pSWSBookingBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSTaskServerName() != null) {
            object = pSWSBookingBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSWorkspaceId() != null) {
            object = pSWSBookingBase.getPSWorkspaceId();
            xmlNode.setAttribute(FIELD_PSWORKSPACEID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSWorkspaceName() != null) {
            object = pSWSBookingBase.getPSWorkspaceName();
            xmlNode.setAttribute(FIELD_PSWORKSPACENAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSWSBookingId() != null) {
            object = pSWSBookingBase.getPSWSBookingId();
            xmlNode.setAttribute(FIELD_PSWSBOOKINGID, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getPSWSBookingName() != null) {
            object = pSWSBookingBase.getPSWSBookingName();
            xmlNode.setAttribute(FIELD_PSWSBOOKINGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWSBookingBase.getUpdateDate() != null) {
            object = pSWSBookingBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWSBookingBase.getUpdateMan() != null) {
            object = pSWSBookingBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWSBookingBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWSBookingBase pSWSBookingBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWSBookingBase.isBeginTimeDirty() && (bl || pSWSBookingBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSWSBookingBase.getBeginTime());
        }
        if (pSWSBookingBase.isBookingInfoDirty() && (bl || pSWSBookingBase.getBookingInfo() != null)) {
            iDataObject.set(FIELD_BOOKINGINFO, (Object)pSWSBookingBase.getBookingInfo());
        }
        if (pSWSBookingBase.isBookingParamDirty() && (bl || pSWSBookingBase.getBookingParam() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM, (Object)pSWSBookingBase.getBookingParam());
        }
        if (pSWSBookingBase.isBookingParam2Dirty() && (bl || pSWSBookingBase.getBookingParam2() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM2, (Object)pSWSBookingBase.getBookingParam2());
        }
        if (pSWSBookingBase.isBookingParam3Dirty() && (bl || pSWSBookingBase.getBookingParam3() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM3, (Object)pSWSBookingBase.getBookingParam3());
        }
        if (pSWSBookingBase.isBookingParam4Dirty() && (bl || pSWSBookingBase.getBookingParam4() != null)) {
            iDataObject.set(FIELD_BOOKINGPARAM4, (Object)pSWSBookingBase.getBookingParam4());
        }
        if (pSWSBookingBase.isBookingStateDirty() && (bl || pSWSBookingBase.getBookingState() != null)) {
            iDataObject.set(FIELD_BOOKINGSTATE, (Object)pSWSBookingBase.getBookingState());
        }
        if (pSWSBookingBase.isBookingTypeDirty() && (bl || pSWSBookingBase.getBookingType() != null)) {
            iDataObject.set(FIELD_BOOKINGTYPE, (Object)pSWSBookingBase.getBookingType());
        }
        if (pSWSBookingBase.isCreateDateDirty() && (bl || pSWSBookingBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWSBookingBase.getCreateDate());
        }
        if (pSWSBookingBase.isCreateManDirty() && (bl || pSWSBookingBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWSBookingBase.getCreateMan());
        }
        if (pSWSBookingBase.isDurationDirty() && (bl || pSWSBookingBase.getDuration() != null)) {
            iDataObject.set(FIELD_DURATION, (Object)pSWSBookingBase.getDuration());
        }
        if (pSWSBookingBase.isEndTimeDirty() && (bl || pSWSBookingBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSWSBookingBase.getEndTime());
        }
        if (pSWSBookingBase.isHoursDirty() && (bl || pSWSBookingBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSWSBookingBase.getHours());
        }
        if (pSWSBookingBase.isMemoDirty() && (bl || pSWSBookingBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWSBookingBase.getMemo());
        }
        if (pSWSBookingBase.isPSDCWorkspaceIdDirty() && (bl || pSWSBookingBase.getPSDCWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACEID, (Object)pSWSBookingBase.getPSDCWorkspaceId());
        }
        if (pSWSBookingBase.isPSDCWorkspaceNameDirty() && (bl || pSWSBookingBase.getPSDCWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSDCWORKSPACENAME, (Object)pSWSBookingBase.getPSDCWorkspaceName());
        }
        if (pSWSBookingBase.isPSDevCenterIdDirty() && (bl || pSWSBookingBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWSBookingBase.getPSDevCenterId());
        }
        if (pSWSBookingBase.isPSDevCenterNameDirty() && (bl || pSWSBookingBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWSBookingBase.getPSDevCenterName());
        }
        if (pSWSBookingBase.isPSSvrDomainIdDirty() && (bl || pSWSBookingBase.getPSSvrDomainId() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINID, (Object)pSWSBookingBase.getPSSvrDomainId());
        }
        if (pSWSBookingBase.isPSSvrDomainNameDirty() && (bl || pSWSBookingBase.getPSSvrDomainName() != null)) {
            iDataObject.set(FIELD_PSSVRDOMAINNAME, (Object)pSWSBookingBase.getPSSvrDomainName());
        }
        if (pSWSBookingBase.isPSTaskServerIdDirty() && (bl || pSWSBookingBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSWSBookingBase.getPSTaskServerId());
        }
        if (pSWSBookingBase.isPSTaskServerNameDirty() && (bl || pSWSBookingBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSWSBookingBase.getPSTaskServerName());
        }
        if (pSWSBookingBase.isPSWorkspaceIdDirty() && (bl || pSWSBookingBase.getPSWorkspaceId() != null)) {
            iDataObject.set(FIELD_PSWORKSPACEID, (Object)pSWSBookingBase.getPSWorkspaceId());
        }
        if (pSWSBookingBase.isPSWorkspaceNameDirty() && (bl || pSWSBookingBase.getPSWorkspaceName() != null)) {
            iDataObject.set(FIELD_PSWORKSPACENAME, (Object)pSWSBookingBase.getPSWorkspaceName());
        }
        if (pSWSBookingBase.isPSWSBookingIdDirty() && (bl || pSWSBookingBase.getPSWSBookingId() != null)) {
            iDataObject.set(FIELD_PSWSBOOKINGID, (Object)pSWSBookingBase.getPSWSBookingId());
        }
        if (pSWSBookingBase.isPSWSBookingNameDirty() && (bl || pSWSBookingBase.getPSWSBookingName() != null)) {
            iDataObject.set(FIELD_PSWSBOOKINGNAME, (Object)pSWSBookingBase.getPSWSBookingName());
        }
        if (pSWSBookingBase.isUpdateDateDirty() && (bl || pSWSBookingBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWSBookingBase.getUpdateDate());
        }
        if (pSWSBookingBase.isUpdateManDirty() && (bl || pSWSBookingBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWSBookingBase.getUpdateMan());
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
        return PSWSBookingBase.remove(this, n);
    }

    private static boolean remove(PSWSBookingBase pSWSBookingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWSBookingBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSWSBookingBase.resetBookingInfo();
                return true;
            }
            case 2: {
                pSWSBookingBase.resetBookingParam();
                return true;
            }
            case 3: {
                pSWSBookingBase.resetBookingParam2();
                return true;
            }
            case 4: {
                pSWSBookingBase.resetBookingParam3();
                return true;
            }
            case 5: {
                pSWSBookingBase.resetBookingParam4();
                return true;
            }
            case 6: {
                pSWSBookingBase.resetBookingState();
                return true;
            }
            case 7: {
                pSWSBookingBase.resetBookingType();
                return true;
            }
            case 8: {
                pSWSBookingBase.resetCreateDate();
                return true;
            }
            case 9: {
                pSWSBookingBase.resetCreateMan();
                return true;
            }
            case 10: {
                pSWSBookingBase.resetDuration();
                return true;
            }
            case 11: {
                pSWSBookingBase.resetEndTime();
                return true;
            }
            case 12: {
                pSWSBookingBase.resetHours();
                return true;
            }
            case 13: {
                pSWSBookingBase.resetMemo();
                return true;
            }
            case 14: {
                pSWSBookingBase.resetPSDCWorkspaceId();
                return true;
            }
            case 15: {
                pSWSBookingBase.resetPSDCWorkspaceName();
                return true;
            }
            case 16: {
                pSWSBookingBase.resetPSDevCenterId();
                return true;
            }
            case 17: {
                pSWSBookingBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSWSBookingBase.resetPSSvrDomainId();
                return true;
            }
            case 19: {
                pSWSBookingBase.resetPSSvrDomainName();
                return true;
            }
            case 20: {
                pSWSBookingBase.resetPSTaskServerId();
                return true;
            }
            case 21: {
                pSWSBookingBase.resetPSTaskServerName();
                return true;
            }
            case 22: {
                pSWSBookingBase.resetPSWorkspaceId();
                return true;
            }
            case 23: {
                pSWSBookingBase.resetPSWorkspaceName();
                return true;
            }
            case 24: {
                pSWSBookingBase.resetPSWSBookingId();
                return true;
            }
            case 25: {
                pSWSBookingBase.resetPSWSBookingName();
                return true;
            }
            case 26: {
                pSWSBookingBase.resetUpdateDate();
                return true;
            }
            case 27: {
                pSWSBookingBase.resetUpdateMan();
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

    private PSWSBookingBase getProxyEntity() {
        return this.proxyPSWSBookingBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWSBookingBase = null;
        if (iDataObject != null && iDataObject instanceof PSWSBookingBase) {
            this.proxyPSWSBookingBase = (PSWSBookingBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSWSBookingService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSDCWORKSPACEID, 14);
        fieldIndexMap.put(FIELD_PSDCWORKSPACENAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSSVRDOMAINID, 18);
        fieldIndexMap.put(FIELD_PSSVRDOMAINNAME, 19);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 20);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 21);
        fieldIndexMap.put(FIELD_PSWORKSPACEID, 22);
        fieldIndexMap.put(FIELD_PSWORKSPACENAME, 23);
        fieldIndexMap.put(FIELD_PSWSBOOKINGID, 24);
        fieldIndexMap.put(FIELD_PSWSBOOKINGNAME, 25);
        fieldIndexMap.put(FIELD_UPDATEDATE, 26);
        fieldIndexMap.put(FIELD_UPDATEMAN, 27);
    }
}

