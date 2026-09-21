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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCRobotLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCRobotLogBase.class);
    public static final String FIELD_CANCELFLAG = "CANCELFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENERGY = "ENERGY";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTYPE = "LOGTYPE";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTLOGID = "PSDCROBOTLOGID";
    public static final String FIELD_PSDCROBOTLOGNAME = "PSDCROBOTLOGNAME";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CANCELFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENERGY = 3;
    private static final int INDEX_LOGINFO = 4;
    private static final int INDEX_LOGLEVEL = 5;
    private static final int INDEX_LOGLEVEL2 = 6;
    private static final int INDEX_LOGTYPE = 7;
    private static final int INDEX_PSDCROBOTID = 8;
    private static final int INDEX_PSDCROBOTLOGID = 9;
    private static final int INDEX_PSDCROBOTLOGNAME = 10;
    private static final int INDEX_PSDCROBOTNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERTAG = 14;
    private static final int INDEX_USERTAG2 = 15;
    private static final int INDEX_USERTAG3 = 16;
    private static final int INDEX_USERTAG4 = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCRobotLogBase proxyPSDCRobotLogBase = null;
    private boolean cancelflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean energyDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtypeDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotlogidDirtyFlag = false;
    private boolean psdcrobotlognameDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="cancelflag")
    private Integer cancelflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="energy")
    private Integer energy;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtype")
    private String logtype;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotlogid")
    private String psdcrobotlogid;
    @Column(name="psdcrobotlogname")
    private String psdcrobotlogname;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
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
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;

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

    public void setEnergy(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnergy(n);
            return;
        }
        this.energy = n;
        this.energyDirtyFlag = true;
    }

    public Integer getEnergy() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnergy();
        }
        return this.energy;
    }

    public boolean isEnergyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnergyDirty();
        }
        return this.energyDirtyFlag;
    }

    public void resetEnergy() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnergy();
            return;
        }
        this.energyDirtyFlag = false;
        this.energy = null;
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

    public void setLogLevel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loglevel = string;
        this.loglevelDirtyFlag = true;
    }

    public String getLogLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel();
        }
        return this.loglevel;
    }

    public boolean isLogLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevelDirty();
        }
        return this.loglevelDirtyFlag;
    }

    public void resetLogLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel();
            return;
        }
        this.loglevelDirtyFlag = false;
        this.loglevel = null;
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

    public void setLogType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logtype = string;
        this.logtypeDirtyFlag = true;
    }

    public String getLogType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogType();
        }
        return this.logtype;
    }

    public boolean isLogTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogTypeDirty();
        }
        return this.logtypeDirtyFlag;
    }

    public void resetLogType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogType();
            return;
        }
        this.logtypeDirtyFlag = false;
        this.logtype = null;
    }

    public void setPSDCRobotId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotid = string;
        this.psdcrobotidDirtyFlag = true;
    }

    public String getPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotId();
        }
        return this.psdcrobotid;
    }

    public boolean isPSDCRobotIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotIdDirty();
        }
        return this.psdcrobotidDirtyFlag;
    }

    public void resetPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotId();
            return;
        }
        this.psdcrobotidDirtyFlag = false;
        this.psdcrobotid = null;
    }

    public void setPSDCRobotLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotlogid = string;
        this.psdcrobotlogidDirtyFlag = true;
    }

    public String getPSDCRobotLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotLogId();
        }
        return this.psdcrobotlogid;
    }

    public boolean isPSDCRobotLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotLogIdDirty();
        }
        return this.psdcrobotlogidDirtyFlag;
    }

    public void resetPSDCRobotLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotLogId();
            return;
        }
        this.psdcrobotlogidDirtyFlag = false;
        this.psdcrobotlogid = null;
    }

    public void setPSDCRobotLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotlogname = string;
        this.psdcrobotlognameDirtyFlag = true;
    }

    public String getPSDCRobotLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotLogName();
        }
        return this.psdcrobotlogname;
    }

    public boolean isPSDCRobotLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotLogNameDirty();
        }
        return this.psdcrobotlognameDirtyFlag;
    }

    public void resetPSDCRobotLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotLogName();
            return;
        }
        this.psdcrobotlognameDirtyFlag = false;
        this.psdcrobotlogname = null;
    }

    public void setPSDCRobotName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCRobotName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcrobotname = string;
        this.psdcrobotnameDirtyFlag = true;
    }

    public String getPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobotName();
        }
        return this.psdcrobotname;
    }

    public boolean isPSDCRobotNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCRobotNameDirty();
        }
        return this.psdcrobotnameDirtyFlag;
    }

    public void resetPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCRobotName();
            return;
        }
        this.psdcrobotnameDirtyFlag = false;
        this.psdcrobotname = null;
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
        PSDCRobotLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCRobotLogBase pSDCRobotLogBase) {
        pSDCRobotLogBase.resetCancelFlag();
        pSDCRobotLogBase.resetCreateDate();
        pSDCRobotLogBase.resetCreateMan();
        pSDCRobotLogBase.resetEnergy();
        pSDCRobotLogBase.resetLogInfo();
        pSDCRobotLogBase.resetLogLevel();
        pSDCRobotLogBase.resetLogLevel2();
        pSDCRobotLogBase.resetLogType();
        pSDCRobotLogBase.resetPSDCRobotId();
        pSDCRobotLogBase.resetPSDCRobotLogId();
        pSDCRobotLogBase.resetPSDCRobotLogName();
        pSDCRobotLogBase.resetPSDCRobotName();
        pSDCRobotLogBase.resetUpdateDate();
        pSDCRobotLogBase.resetUpdateMan();
        pSDCRobotLogBase.resetUserTag();
        pSDCRobotLogBase.resetUserTag2();
        pSDCRobotLogBase.resetUserTag3();
        pSDCRobotLogBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCancelFlagDirty()) {
            hashMap.put(FIELD_CANCELFLAG, this.getCancelFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnergyDirty()) {
            hashMap.put(FIELD_ENERGY, this.getEnergy());
        }
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bl || this.isLogLevelDirty()) {
            hashMap.put(FIELD_LOGLEVEL, this.getLogLevel());
        }
        if (!bl || this.isLogLevel2Dirty()) {
            hashMap.put(FIELD_LOGLEVEL2, this.getLogLevel2());
        }
        if (!bl || this.isLogTypeDirty()) {
            hashMap.put(FIELD_LOGTYPE, this.getLogType());
        }
        if (!bl || this.isPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTID, this.getPSDCRobotId());
        }
        if (!bl || this.isPSDCRobotLogIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTLOGID, this.getPSDCRobotLogId());
        }
        if (!bl || this.isPSDCRobotLogNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTLOGNAME, this.getPSDCRobotLogName());
        }
        if (!bl || this.isPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTNAME, this.getPSDCRobotName());
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
        return PSDCRobotLogBase.get(this, n);
    }

    private static Object get(PSDCRobotLogBase pSDCRobotLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotLogBase.getCancelFlag();
            }
            case 1: {
                return pSDCRobotLogBase.getCreateDate();
            }
            case 2: {
                return pSDCRobotLogBase.getCreateMan();
            }
            case 3: {
                return pSDCRobotLogBase.getEnergy();
            }
            case 4: {
                return pSDCRobotLogBase.getLogInfo();
            }
            case 5: {
                return pSDCRobotLogBase.getLogLevel();
            }
            case 6: {
                return pSDCRobotLogBase.getLogLevel2();
            }
            case 7: {
                return pSDCRobotLogBase.getLogType();
            }
            case 8: {
                return pSDCRobotLogBase.getPSDCRobotId();
            }
            case 9: {
                return pSDCRobotLogBase.getPSDCRobotLogId();
            }
            case 10: {
                return pSDCRobotLogBase.getPSDCRobotLogName();
            }
            case 11: {
                return pSDCRobotLogBase.getPSDCRobotName();
            }
            case 12: {
                return pSDCRobotLogBase.getUpdateDate();
            }
            case 13: {
                return pSDCRobotLogBase.getUpdateMan();
            }
            case 14: {
                return pSDCRobotLogBase.getUserTag();
            }
            case 15: {
                return pSDCRobotLogBase.getUserTag2();
            }
            case 16: {
                return pSDCRobotLogBase.getUserTag3();
            }
            case 17: {
                return pSDCRobotLogBase.getUserTag4();
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
        PSDCRobotLogBase.set(this, n, object);
    }

    private static void set(PSDCRobotLogBase pSDCRobotLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotLogBase.setCancelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCRobotLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCRobotLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCRobotLogBase.setEnergy(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCRobotLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCRobotLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCRobotLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDCRobotLogBase.setLogType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCRobotLogBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCRobotLogBase.setPSDCRobotLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCRobotLogBase.setPSDCRobotLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCRobotLogBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCRobotLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDCRobotLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCRobotLogBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCRobotLogBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCRobotLogBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCRobotLogBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDCRobotLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDCRobotLogBase pSDCRobotLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotLogBase.getCancelFlag() == null;
            }
            case 1: {
                return pSDCRobotLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCRobotLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCRobotLogBase.getEnergy() == null;
            }
            case 4: {
                return pSDCRobotLogBase.getLogInfo() == null;
            }
            case 5: {
                return pSDCRobotLogBase.getLogLevel() == null;
            }
            case 6: {
                return pSDCRobotLogBase.getLogLevel2() == null;
            }
            case 7: {
                return pSDCRobotLogBase.getLogType() == null;
            }
            case 8: {
                return pSDCRobotLogBase.getPSDCRobotId() == null;
            }
            case 9: {
                return pSDCRobotLogBase.getPSDCRobotLogId() == null;
            }
            case 10: {
                return pSDCRobotLogBase.getPSDCRobotLogName() == null;
            }
            case 11: {
                return pSDCRobotLogBase.getPSDCRobotName() == null;
            }
            case 12: {
                return pSDCRobotLogBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDCRobotLogBase.getUpdateMan() == null;
            }
            case 14: {
                return pSDCRobotLogBase.getUserTag() == null;
            }
            case 15: {
                return pSDCRobotLogBase.getUserTag2() == null;
            }
            case 16: {
                return pSDCRobotLogBase.getUserTag3() == null;
            }
            case 17: {
                return pSDCRobotLogBase.getUserTag4() == null;
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
        return PSDCRobotLogBase.contains(this, n);
    }

    private static boolean contains(PSDCRobotLogBase pSDCRobotLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCRobotLogBase.isCancelFlagDirty();
            }
            case 1: {
                return pSDCRobotLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCRobotLogBase.isCreateManDirty();
            }
            case 3: {
                return pSDCRobotLogBase.isEnergyDirty();
            }
            case 4: {
                return pSDCRobotLogBase.isLogInfoDirty();
            }
            case 5: {
                return pSDCRobotLogBase.isLogLevelDirty();
            }
            case 6: {
                return pSDCRobotLogBase.isLogLevel2Dirty();
            }
            case 7: {
                return pSDCRobotLogBase.isLogTypeDirty();
            }
            case 8: {
                return pSDCRobotLogBase.isPSDCRobotIdDirty();
            }
            case 9: {
                return pSDCRobotLogBase.isPSDCRobotLogIdDirty();
            }
            case 10: {
                return pSDCRobotLogBase.isPSDCRobotLogNameDirty();
            }
            case 11: {
                return pSDCRobotLogBase.isPSDCRobotNameDirty();
            }
            case 12: {
                return pSDCRobotLogBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDCRobotLogBase.isUpdateManDirty();
            }
            case 14: {
                return pSDCRobotLogBase.isUserTagDirty();
            }
            case 15: {
                return pSDCRobotLogBase.isUserTag2Dirty();
            }
            case 16: {
                return pSDCRobotLogBase.isUserTag3Dirty();
            }
            case 17: {
                return pSDCRobotLogBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCRobotLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCRobotLogBase pSDCRobotLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCRobotLogBase.getCancelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cancelflag", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getCancelFlag()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getEnergy() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"energy", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getEnergy()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getLogType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtype", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getLogType()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotlogid", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getPSDCRobotLogId()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotlogname", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getPSDCRobotLogName()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDCRobotLogBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDCRobotLogBase.getJSONValue((Object)pSDCRobotLogBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCRobotLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCRobotLogBase pSDCRobotLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCRobotLogBase.getCancelFlag() != null) {
            object = pSDCRobotLogBase.getCancelFlag();
            xmlNode.setAttribute(FIELD_CANCELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotLogBase.getCreateDate() != null) {
            object = pSDCRobotLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotLogBase.getCreateMan() != null) {
            object = pSDCRobotLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getEnergy() != null) {
            object = pSDCRobotLogBase.getEnergy();
            xmlNode.setAttribute(FIELD_ENERGY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotLogBase.getLogInfo() != null) {
            object = pSDCRobotLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getLogLevel() != null) {
            object = pSDCRobotLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getLogLevel2() != null) {
            object = pSDCRobotLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCRobotLogBase.getLogType() != null) {
            object = pSDCRobotLogBase.getLogType();
            xmlNode.setAttribute(FIELD_LOGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotId() != null) {
            object = pSDCRobotLogBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotLogId() != null) {
            object = pSDCRobotLogBase.getPSDCRobotLogId();
            xmlNode.setAttribute(FIELD_PSDCROBOTLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotLogName() != null) {
            object = pSDCRobotLogBase.getPSDCRobotLogName();
            xmlNode.setAttribute(FIELD_PSDCROBOTLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getPSDCRobotName() != null) {
            object = pSDCRobotLogBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getUpdateDate() != null) {
            object = pSDCRobotLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCRobotLogBase.getUpdateMan() != null) {
            object = pSDCRobotLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getUserTag() != null) {
            object = pSDCRobotLogBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getUserTag2() != null) {
            object = pSDCRobotLogBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getUserTag3() != null) {
            object = pSDCRobotLogBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDCRobotLogBase.getUserTag4() != null) {
            object = pSDCRobotLogBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCRobotLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCRobotLogBase pSDCRobotLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCRobotLogBase.isCancelFlagDirty() && (bl || pSDCRobotLogBase.getCancelFlag() != null)) {
            iDataObject.set(FIELD_CANCELFLAG, (Object)pSDCRobotLogBase.getCancelFlag());
        }
        if (pSDCRobotLogBase.isCreateDateDirty() && (bl || pSDCRobotLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCRobotLogBase.getCreateDate());
        }
        if (pSDCRobotLogBase.isCreateManDirty() && (bl || pSDCRobotLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCRobotLogBase.getCreateMan());
        }
        if (pSDCRobotLogBase.isEnergyDirty() && (bl || pSDCRobotLogBase.getEnergy() != null)) {
            iDataObject.set(FIELD_ENERGY, (Object)pSDCRobotLogBase.getEnergy());
        }
        if (pSDCRobotLogBase.isLogInfoDirty() && (bl || pSDCRobotLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDCRobotLogBase.getLogInfo());
        }
        if (pSDCRobotLogBase.isLogLevelDirty() && (bl || pSDCRobotLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSDCRobotLogBase.getLogLevel());
        }
        if (pSDCRobotLogBase.isLogLevel2Dirty() && (bl || pSDCRobotLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSDCRobotLogBase.getLogLevel2());
        }
        if (pSDCRobotLogBase.isLogTypeDirty() && (bl || pSDCRobotLogBase.getLogType() != null)) {
            iDataObject.set(FIELD_LOGTYPE, (Object)pSDCRobotLogBase.getLogType());
        }
        if (pSDCRobotLogBase.isPSDCRobotIdDirty() && (bl || pSDCRobotLogBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSDCRobotLogBase.getPSDCRobotId());
        }
        if (pSDCRobotLogBase.isPSDCRobotLogIdDirty() && (bl || pSDCRobotLogBase.getPSDCRobotLogId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTLOGID, (Object)pSDCRobotLogBase.getPSDCRobotLogId());
        }
        if (pSDCRobotLogBase.isPSDCRobotLogNameDirty() && (bl || pSDCRobotLogBase.getPSDCRobotLogName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTLOGNAME, (Object)pSDCRobotLogBase.getPSDCRobotLogName());
        }
        if (pSDCRobotLogBase.isPSDCRobotNameDirty() && (bl || pSDCRobotLogBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSDCRobotLogBase.getPSDCRobotName());
        }
        if (pSDCRobotLogBase.isUpdateDateDirty() && (bl || pSDCRobotLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCRobotLogBase.getUpdateDate());
        }
        if (pSDCRobotLogBase.isUpdateManDirty() && (bl || pSDCRobotLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCRobotLogBase.getUpdateMan());
        }
        if (pSDCRobotLogBase.isUserTagDirty() && (bl || pSDCRobotLogBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCRobotLogBase.getUserTag());
        }
        if (pSDCRobotLogBase.isUserTag2Dirty() && (bl || pSDCRobotLogBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCRobotLogBase.getUserTag2());
        }
        if (pSDCRobotLogBase.isUserTag3Dirty() && (bl || pSDCRobotLogBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDCRobotLogBase.getUserTag3());
        }
        if (pSDCRobotLogBase.isUserTag4Dirty() && (bl || pSDCRobotLogBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDCRobotLogBase.getUserTag4());
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
        return PSDCRobotLogBase.remove(this, n);
    }

    private static boolean remove(PSDCRobotLogBase pSDCRobotLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCRobotLogBase.resetCancelFlag();
                return true;
            }
            case 1: {
                pSDCRobotLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCRobotLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCRobotLogBase.resetEnergy();
                return true;
            }
            case 4: {
                pSDCRobotLogBase.resetLogInfo();
                return true;
            }
            case 5: {
                pSDCRobotLogBase.resetLogLevel();
                return true;
            }
            case 6: {
                pSDCRobotLogBase.resetLogLevel2();
                return true;
            }
            case 7: {
                pSDCRobotLogBase.resetLogType();
                return true;
            }
            case 8: {
                pSDCRobotLogBase.resetPSDCRobotId();
                return true;
            }
            case 9: {
                pSDCRobotLogBase.resetPSDCRobotLogId();
                return true;
            }
            case 10: {
                pSDCRobotLogBase.resetPSDCRobotLogName();
                return true;
            }
            case 11: {
                pSDCRobotLogBase.resetPSDCRobotName();
                return true;
            }
            case 12: {
                pSDCRobotLogBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDCRobotLogBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSDCRobotLogBase.resetUserTag();
                return true;
            }
            case 15: {
                pSDCRobotLogBase.resetUserTag2();
                return true;
            }
            case 16: {
                pSDCRobotLogBase.resetUserTag3();
                return true;
            }
            case 17: {
                pSDCRobotLogBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRobot getPSDCRobot() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCRobot();
        }
        if (this.getPSDCRobotId() == null) {
            return null;
        }
        Integer n = this.objPSDCRobotLock;
        synchronized (n) {
            if (this.psdcrobot != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCRobotId(), (Object)this.psdcrobot.getPSDCRobotId()) != 0L) {
                this.psdcrobot = null;
            }
            if (this.psdcrobot == null) {
                PSDCRobot pSDCRobot = new PSDCRobot();
                pSDCRobot.setPSDCRobotId(this.getPSDCRobotId());
                PSDCRobotService pSDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
                pSDCRobotService.autoGet((IEntity)pSDCRobot);
                this.psdcrobot = pSDCRobot;
            }
            return this.psdcrobot;
        }
    }

    private PSDCRobotLogBase getProxyEntity() {
        return this.proxyPSDCRobotLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCRobotLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCRobotLogBase) {
            this.proxyPSDCRobotLogBase = (PSDCRobotLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCRobotLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CANCELFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENERGY, 3);
        fieldIndexMap.put(FIELD_LOGINFO, 4);
        fieldIndexMap.put(FIELD_LOGLEVEL, 5);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 6);
        fieldIndexMap.put(FIELD_LOGTYPE, 7);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 8);
        fieldIndexMap.put(FIELD_PSDCROBOTLOGID, 9);
        fieldIndexMap.put(FIELD_PSDCROBOTLOGNAME, 10);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERTAG, 14);
        fieldIndexMap.put(FIELD_USERTAG2, 15);
        fieldIndexMap.put(FIELD_USERTAG3, 16);
        fieldIndexMap.put(FIELD_USERTAG4, 17);
    }
}

