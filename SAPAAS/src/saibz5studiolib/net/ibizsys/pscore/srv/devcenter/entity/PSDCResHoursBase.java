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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCResHoursBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCResHoursBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_HOURS = "HOURS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCRESHOURSID = "PSDCRESHOURSID";
    public static final String FIELD_PSDCRESHOURSNAME = "PSDCRESHOURSNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_RESHOURSINFO = "RESHOURSINFO";
    public static final String FIELD_RESSPEC = "RESSPEC";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESTYPE = "RESTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_HOURS = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDCRESHOURSID = 6;
    private static final int INDEX_PSDCRESHOURSNAME = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_RESHOURSINFO = 10;
    private static final int INDEX_RESSPEC = 11;
    private static final int INDEX_RESSTATE = 12;
    private static final int INDEX_RESTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERTAG = 16;
    private static final int INDEX_USERTAG2 = 17;
    private static final int INDEX_USERTAG3 = 18;
    private static final int INDEX_USERTAG4 = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCResHoursBase proxyPSDCResHoursBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean hoursDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcreshoursidDirtyFlag = false;
    private boolean psdcreshoursnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean reshoursinfoDirtyFlag = false;
    private boolean resspecDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean restypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="hours")
    private Integer hours;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcreshoursid")
    private String psdcreshoursid;
    @Column(name="psdcreshoursname")
    private String psdcreshoursname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="reshoursinfo")
    private String reshoursinfo;
    @Column(name="resspec")
    private String resspec;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="restype")
    private String restype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
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

    public void setResHoursInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResHoursInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.reshoursinfo = string;
        this.reshoursinfoDirtyFlag = true;
    }

    public String getResHoursInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResHoursInfo();
        }
        return this.reshoursinfo;
    }

    public boolean isResHoursInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResHoursInfoDirty();
        }
        return this.reshoursinfoDirtyFlag;
    }

    public void resetResHoursInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResHoursInfo();
            return;
        }
        this.reshoursinfoDirtyFlag = false;
        this.reshoursinfo = null;
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

    public void setResState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResState(n);
            return;
        }
        this.resstate = n;
        this.resstateDirtyFlag = true;
    }

    public Integer getResState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResState();
        }
        return this.resstate;
    }

    public boolean isResStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResStateDirty();
        }
        return this.resstateDirtyFlag;
    }

    public void resetResState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResState();
            return;
        }
        this.resstateDirtyFlag = false;
        this.resstate = null;
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

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
    }

    protected void onReset() {
        PSDCResHoursBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCResHoursBase pSDCResHoursBase) {
        pSDCResHoursBase.resetBeginTime();
        pSDCResHoursBase.resetCreateDate();
        pSDCResHoursBase.resetCreateMan();
        pSDCResHoursBase.resetEndTime();
        pSDCResHoursBase.resetHours();
        pSDCResHoursBase.resetMemo();
        pSDCResHoursBase.resetPSDCResHoursId();
        pSDCResHoursBase.resetPSDCResHoursName();
        pSDCResHoursBase.resetPSDevCenterId();
        pSDCResHoursBase.resetPSDevCenterName();
        pSDCResHoursBase.resetResHoursInfo();
        pSDCResHoursBase.resetResSpec();
        pSDCResHoursBase.resetResState();
        pSDCResHoursBase.resetResType();
        pSDCResHoursBase.resetUpdateDate();
        pSDCResHoursBase.resetUpdateMan();
        pSDCResHoursBase.resetUserTag();
        pSDCResHoursBase.resetUserTag2();
        pSDCResHoursBase.resetUserTag3();
        pSDCResHoursBase.resetUserTag4();
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
        if (!bl || this.isHoursDirty()) {
            hashMap.put(FIELD_HOURS, this.getHours());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCResHoursIdDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSID, this.getPSDCResHoursId());
        }
        if (!bl || this.isPSDCResHoursNameDirty()) {
            hashMap.put(FIELD_PSDCRESHOURSNAME, this.getPSDCResHoursName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isResHoursInfoDirty()) {
            hashMap.put(FIELD_RESHOURSINFO, this.getResHoursInfo());
        }
        if (!bl || this.isResSpecDirty()) {
            hashMap.put(FIELD_RESSPEC, this.getResSpec());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSDCResHoursBase.get(this, n);
    }

    private static Object get(PSDCResHoursBase pSDCResHoursBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursBase.getBeginTime();
            }
            case 1: {
                return pSDCResHoursBase.getCreateDate();
            }
            case 2: {
                return pSDCResHoursBase.getCreateMan();
            }
            case 3: {
                return pSDCResHoursBase.getEndTime();
            }
            case 4: {
                return pSDCResHoursBase.getHours();
            }
            case 5: {
                return pSDCResHoursBase.getMemo();
            }
            case 6: {
                return pSDCResHoursBase.getPSDCResHoursId();
            }
            case 7: {
                return pSDCResHoursBase.getPSDCResHoursName();
            }
            case 8: {
                return pSDCResHoursBase.getPSDevCenterId();
            }
            case 9: {
                return pSDCResHoursBase.getPSDevCenterName();
            }
            case 10: {
                return pSDCResHoursBase.getResHoursInfo();
            }
            case 11: {
                return pSDCResHoursBase.getResSpec();
            }
            case 12: {
                return pSDCResHoursBase.getResState();
            }
            case 13: {
                return pSDCResHoursBase.getResType();
            }
            case 14: {
                return pSDCResHoursBase.getUpdateDate();
            }
            case 15: {
                return pSDCResHoursBase.getUpdateMan();
            }
            case 16: {
                return pSDCResHoursBase.getUserTag();
            }
            case 17: {
                return pSDCResHoursBase.getUserTag2();
            }
            case 18: {
                return pSDCResHoursBase.getUserTag3();
            }
            case 19: {
                return pSDCResHoursBase.getUserTag4();
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
        PSDCResHoursBase.set(this, n, object);
    }

    private static void set(PSDCResHoursBase pSDCResHoursBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCResHoursBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCResHoursBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCResHoursBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCResHoursBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCResHoursBase.setHours(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCResHoursBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCResHoursBase.setPSDCResHoursId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCResHoursBase.setPSDCResHoursName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCResHoursBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCResHoursBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCResHoursBase.setResHoursInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCResHoursBase.setResSpec(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCResHoursBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDCResHoursBase.setResType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCResHoursBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSDCResHoursBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCResHoursBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCResHoursBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCResHoursBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCResHoursBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCResHoursBase.isNull(this, n);
    }

    private static boolean isNull(PSDCResHoursBase pSDCResHoursBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCResHoursBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCResHoursBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCResHoursBase.getEndTime() == null;
            }
            case 4: {
                return pSDCResHoursBase.getHours() == null;
            }
            case 5: {
                return pSDCResHoursBase.getMemo() == null;
            }
            case 6: {
                return pSDCResHoursBase.getPSDCResHoursId() == null;
            }
            case 7: {
                return pSDCResHoursBase.getPSDCResHoursName() == null;
            }
            case 8: {
                return pSDCResHoursBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCResHoursBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCResHoursBase.getResHoursInfo() == null;
            }
            case 11: {
                return pSDCResHoursBase.getResSpec() == null;
            }
            case 12: {
                return pSDCResHoursBase.getResState() == null;
            }
            case 13: {
                return pSDCResHoursBase.getResType() == null;
            }
            case 14: {
                return pSDCResHoursBase.getUpdateDate() == null;
            }
            case 15: {
                return pSDCResHoursBase.getUpdateMan() == null;
            }
            case 16: {
                return pSDCResHoursBase.getUserTag() == null;
            }
            case 17: {
                return pSDCResHoursBase.getUserTag2() == null;
            }
            case 18: {
                return pSDCResHoursBase.getUserTag3() == null;
            }
            case 19: {
                return pSDCResHoursBase.getUserTag4() == null;
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
        return PSDCResHoursBase.contains(this, n);
    }

    private static boolean contains(PSDCResHoursBase pSDCResHoursBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCResHoursBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCResHoursBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCResHoursBase.isCreateManDirty();
            }
            case 3: {
                return pSDCResHoursBase.isEndTimeDirty();
            }
            case 4: {
                return pSDCResHoursBase.isHoursDirty();
            }
            case 5: {
                return pSDCResHoursBase.isMemoDirty();
            }
            case 6: {
                return pSDCResHoursBase.isPSDCResHoursIdDirty();
            }
            case 7: {
                return pSDCResHoursBase.isPSDCResHoursNameDirty();
            }
            case 8: {
                return pSDCResHoursBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCResHoursBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCResHoursBase.isResHoursInfoDirty();
            }
            case 11: {
                return pSDCResHoursBase.isResSpecDirty();
            }
            case 12: {
                return pSDCResHoursBase.isResStateDirty();
            }
            case 13: {
                return pSDCResHoursBase.isResTypeDirty();
            }
            case 14: {
                return pSDCResHoursBase.isUpdateDateDirty();
            }
            case 15: {
                return pSDCResHoursBase.isUpdateManDirty();
            }
            case 16: {
                return pSDCResHoursBase.isUserTagDirty();
            }
            case 17: {
                return pSDCResHoursBase.isUserTag2Dirty();
            }
            case 18: {
                return pSDCResHoursBase.isUserTag3Dirty();
            }
            case 19: {
                return pSDCResHoursBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCResHoursBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCResHoursBase pSDCResHoursBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCResHoursBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getHours() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hours", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getHours()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getPSDCResHoursId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshoursid", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getPSDCResHoursId()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getPSDCResHoursName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcreshoursname", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getPSDCResHoursName()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getResHoursInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"reshoursinfo", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getResHoursInfo()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getResSpec() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resspec", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getResSpec()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getResState()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getResType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"restype", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getResType()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCResHoursBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCResHoursBase.getJSONValue((Object)pSDCResHoursBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCResHoursBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCResHoursBase pSDCResHoursBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCResHoursBase.getBeginTime() != null) {
            object = pSDCResHoursBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursBase.getCreateDate() != null) {
            object = pSDCResHoursBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursBase.getCreateMan() != null) {
            object = pSDCResHoursBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getEndTime() != null) {
            object = pSDCResHoursBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursBase.getHours() != null) {
            object = pSDCResHoursBase.getHours();
            xmlNode.setAttribute(FIELD_HOURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResHoursBase.getMemo() != null) {
            object = pSDCResHoursBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getPSDCResHoursId() != null) {
            object = pSDCResHoursBase.getPSDCResHoursId();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getPSDCResHoursName() != null) {
            object = pSDCResHoursBase.getPSDCResHoursName();
            xmlNode.setAttribute(FIELD_PSDCRESHOURSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getPSDevCenterId() != null) {
            object = pSDCResHoursBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getPSDevCenterName() != null) {
            object = pSDCResHoursBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getResHoursInfo() != null) {
            object = pSDCResHoursBase.getResHoursInfo();
            xmlNode.setAttribute(FIELD_RESHOURSINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getResSpec() != null) {
            object = pSDCResHoursBase.getResSpec();
            xmlNode.setAttribute(FIELD_RESSPEC, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getResState() != null) {
            object = pSDCResHoursBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCResHoursBase.getResType() != null) {
            object = pSDCResHoursBase.getResType();
            xmlNode.setAttribute(FIELD_RESTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getUpdateDate() != null) {
            object = pSDCResHoursBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCResHoursBase.getUpdateMan() != null) {
            object = pSDCResHoursBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getUserTag() != null) {
            object = pSDCResHoursBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getUserTag2() != null) {
            object = pSDCResHoursBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getUserTag3() != null) {
            object = pSDCResHoursBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCResHoursBase.getUserTag4() != null) {
            object = pSDCResHoursBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCResHoursBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCResHoursBase pSDCResHoursBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCResHoursBase.isBeginTimeDirty() && (bl || pSDCResHoursBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCResHoursBase.getBeginTime());
        }
        if (pSDCResHoursBase.isCreateDateDirty() && (bl || pSDCResHoursBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCResHoursBase.getCreateDate());
        }
        if (pSDCResHoursBase.isCreateManDirty() && (bl || pSDCResHoursBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCResHoursBase.getCreateMan());
        }
        if (pSDCResHoursBase.isEndTimeDirty() && (bl || pSDCResHoursBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCResHoursBase.getEndTime());
        }
        if (pSDCResHoursBase.isHoursDirty() && (bl || pSDCResHoursBase.getHours() != null)) {
            iDataObject.set(FIELD_HOURS, (Object)pSDCResHoursBase.getHours());
        }
        if (pSDCResHoursBase.isMemoDirty() && (bl || pSDCResHoursBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCResHoursBase.getMemo());
        }
        if (pSDCResHoursBase.isPSDCResHoursIdDirty() && (bl || pSDCResHoursBase.getPSDCResHoursId() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSID, (Object)pSDCResHoursBase.getPSDCResHoursId());
        }
        if (pSDCResHoursBase.isPSDCResHoursNameDirty() && (bl || pSDCResHoursBase.getPSDCResHoursName() != null)) {
            iDataObject.set(FIELD_PSDCRESHOURSNAME, (Object)pSDCResHoursBase.getPSDCResHoursName());
        }
        if (pSDCResHoursBase.isPSDevCenterIdDirty() && (bl || pSDCResHoursBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCResHoursBase.getPSDevCenterId());
        }
        if (pSDCResHoursBase.isPSDevCenterNameDirty() && (bl || pSDCResHoursBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCResHoursBase.getPSDevCenterName());
        }
        if (pSDCResHoursBase.isResHoursInfoDirty() && (bl || pSDCResHoursBase.getResHoursInfo() != null)) {
            iDataObject.set(FIELD_RESHOURSINFO, (Object)pSDCResHoursBase.getResHoursInfo());
        }
        if (pSDCResHoursBase.isResSpecDirty() && (bl || pSDCResHoursBase.getResSpec() != null)) {
            iDataObject.set(FIELD_RESSPEC, (Object)pSDCResHoursBase.getResSpec());
        }
        if (pSDCResHoursBase.isResStateDirty() && (bl || pSDCResHoursBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDCResHoursBase.getResState());
        }
        if (pSDCResHoursBase.isResTypeDirty() && (bl || pSDCResHoursBase.getResType() != null)) {
            iDataObject.set(FIELD_RESTYPE, (Object)pSDCResHoursBase.getResType());
        }
        if (pSDCResHoursBase.isUpdateDateDirty() && (bl || pSDCResHoursBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCResHoursBase.getUpdateDate());
        }
        if (pSDCResHoursBase.isUpdateManDirty() && (bl || pSDCResHoursBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCResHoursBase.getUpdateMan());
        }
        if (pSDCResHoursBase.isUserTagDirty() && (bl || pSDCResHoursBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCResHoursBase.getUserTag());
        }
        if (pSDCResHoursBase.isUserTag2Dirty() && (bl || pSDCResHoursBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCResHoursBase.getUserTag2());
        }
        if (pSDCResHoursBase.isUserTag3Dirty() && (bl || pSDCResHoursBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCResHoursBase.getUserTag3());
        }
        if (pSDCResHoursBase.isUserTag4Dirty() && (bl || pSDCResHoursBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCResHoursBase.getUserTag4());
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
        return PSDCResHoursBase.remove(this, n);
    }

    private static boolean remove(PSDCResHoursBase pSDCResHoursBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCResHoursBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCResHoursBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCResHoursBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCResHoursBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDCResHoursBase.resetHours();
                return true;
            }
            case 5: {
                pSDCResHoursBase.resetMemo();
                return true;
            }
            case 6: {
                pSDCResHoursBase.resetPSDCResHoursId();
                return true;
            }
            case 7: {
                pSDCResHoursBase.resetPSDCResHoursName();
                return true;
            }
            case 8: {
                pSDCResHoursBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCResHoursBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCResHoursBase.resetResHoursInfo();
                return true;
            }
            case 11: {
                pSDCResHoursBase.resetResSpec();
                return true;
            }
            case 12: {
                pSDCResHoursBase.resetResState();
                return true;
            }
            case 13: {
                pSDCResHoursBase.resetResType();
                return true;
            }
            case 14: {
                pSDCResHoursBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSDCResHoursBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSDCResHoursBase.resetUserTag();
                return true;
            }
            case 17: {
                pSDCResHoursBase.resetUserTag2();
                return true;
            }
            case 18: {
                pSDCResHoursBase.resetUserTag3();
                return true;
            }
            case 19: {
                pSDCResHoursBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    private PSDCResHoursBase getProxyEntity() {
        return this.proxyPSDCResHoursBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCResHoursBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCResHoursBase) {
            this.proxyPSDCResHoursBase = (PSDCResHoursBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCResHoursService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_HOURS, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDCRESHOURSID, 6);
        fieldIndexMap.put(FIELD_PSDCRESHOURSNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_RESHOURSINFO, 10);
        fieldIndexMap.put(FIELD_RESSPEC, 11);
        fieldIndexMap.put(FIELD_RESSTATE, 12);
        fieldIndexMap.put(FIELD_RESTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERTAG, 16);
        fieldIndexMap.put(FIELD_USERTAG2, 17);
        fieldIndexMap.put(FIELD_USERTAG3, 18);
        fieldIndexMap.put(FIELD_USERTAG4, 19);
    }
}

