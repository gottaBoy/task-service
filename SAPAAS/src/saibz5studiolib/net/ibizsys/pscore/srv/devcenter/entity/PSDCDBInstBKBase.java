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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCDBInstBK;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInstBK;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstBKService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBInstBKBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBInstBKBase.class);
    public static final String FIELD_BACKUPSIZE = "BACKUPSIZE";
    public static final String FIELD_BKFILEPATH = "BKFILEPATH";
    public static final String FIELD_BKINFO = "BKINFO";
    public static final String FIELD_BACKUPMODE = "BKMODE";
    public static final String FIELD_BKSTATE = "BKSTATE";
    public static final String FIELD_BKTIME = "BKTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_FULLBKFILEPATH = "FULLBKFILEPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PPSDCDBINSTBKID = "PPSDCDBINSTBKID";
    public static final String FIELD_PPSDCDBINSTBKNAME = "PPSDCDBINSTBKNAME";
    public static final String FIELD_PSDBDEVINSTBKID = "PSDBDEVINSTBKID";
    public static final String FIELD_PSDBDEVINSTBKNAME = "PSDBDEVINSTBKNAME";
    public static final String FIELD_PSDCDBINSTBKID = "PSDCDBINSTBKID";
    public static final String FIELD_PSDCDBINSTBKNAME = "PSDCDBINSTBKNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKUPSIZE = 0;
    private static final int INDEX_BKFILEPATH = 1;
    private static final int INDEX_BKINFO = 2;
    private static final int INDEX_BACKUPMODE = 3;
    private static final int INDEX_BKSTATE = 4;
    private static final int INDEX_BKTIME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_DBTYPE = 8;
    private static final int INDEX_FULLBKFILEPATH = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PASSWD = 11;
    private static final int INDEX_PPSDCDBINSTBKID = 12;
    private static final int INDEX_PPSDCDBINSTBKNAME = 13;
    private static final int INDEX_PSDBDEVINSTBKID = 14;
    private static final int INDEX_PSDBDEVINSTBKNAME = 15;
    private static final int INDEX_PSDCDBINSTBKID = 16;
    private static final int INDEX_PSDCDBINSTBKNAME = 17;
    private static final int INDEX_PSDEVCENTERDBINSTID = 18;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 19;
    private static final int INDEX_PSDEVCENTERID = 20;
    private static final int INDEX_PSDEVCENTERNAME = 21;
    private static final int INDEX_PSTASKSERVERID = 22;
    private static final int INDEX_PSTASKSERVERNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBInstBKBase proxyPSDCDBInstBKBase = null;
    private boolean backupsizeDirtyFlag = false;
    private boolean bkfilepathDirtyFlag = false;
    private boolean bkinfoDirtyFlag = false;
    private boolean backupmodeDirtyFlag = false;
    private boolean bkstateDirtyFlag = false;
    private boolean bktimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean fullbkfilepathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean ppsdcdbinstbkidDirtyFlag = false;
    private boolean ppsdcdbinstbknameDirtyFlag = false;
    private boolean psdbdevinstbkidDirtyFlag = false;
    private boolean psdbdevinstbknameDirtyFlag = false;
    private boolean psdcdbinstbkidDirtyFlag = false;
    private boolean psdcdbinstbknameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backupsize")
    private Integer backupsize;
    @Column(name="bkfilepath")
    private String bkfilepath;
    @Column(name="bkinfo")
    private String bkinfo;
    @Column(name="backupmode")
    private Integer backupmode;
    @Column(name="bkstate")
    private Integer bkstate;
    @Column(name="bktime")
    private Timestamp bktime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="fullbkfilepath")
    private String fullbkfilepath;
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="ppsdcdbinstbkid")
    private String ppsdcdbinstbkid;
    @Column(name="ppsdcdbinstbkname")
    private String ppsdcdbinstbkname;
    @Column(name="psdbdevinstbkid")
    private String psdbdevinstbkid;
    @Column(name="psdbdevinstbkname")
    private String psdbdevinstbkname;
    @Column(name="psdcdbinstbkid")
    private String psdcdbinstbkid;
    @Column(name="psdcdbinstbkname")
    private String psdcdbinstbkname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBDevInstBKLock = new Integer(1);
    private PSDBDevInstBK psdbdevinstbk = null;
    private Integer objPPSDCDBInstBKLock = new Integer(1);
    private PSDCDBInstBK ppsdcdbinstbk = null;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;
    private Integer objPSDCDBInstBKsLock = new Integer(1);
    private ArrayList<PSDCDBInstBK> psdcdbinstbks = null;

    public void setBackupSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupSize(n);
            return;
        }
        this.backupsize = n;
        this.backupsizeDirtyFlag = true;
    }

    public Integer getBackupSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupSize();
        }
        return this.backupsize;
    }

    public boolean isBackupSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupSizeDirty();
        }
        return this.backupsizeDirtyFlag;
    }

    public void resetBackupSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupSize();
            return;
        }
        this.backupsizeDirtyFlag = false;
        this.backupsize = null;
    }

    public void setBKFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkfilepath = string;
        this.bkfilepathDirtyFlag = true;
    }

    public String getBKFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKFilePath();
        }
        return this.bkfilepath;
    }

    public boolean isBKFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKFilePathDirty();
        }
        return this.bkfilepathDirtyFlag;
    }

    public void resetBKFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKFilePath();
            return;
        }
        this.bkfilepathDirtyFlag = false;
        this.bkfilepath = null;
    }

    public void setBKInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkinfo = string;
        this.bkinfoDirtyFlag = true;
    }

    public String getBKInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKInfo();
        }
        return this.bkinfo;
    }

    public boolean isBKInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKInfoDirty();
        }
        return this.bkinfoDirtyFlag;
    }

    public void resetBKInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKInfo();
            return;
        }
        this.bkinfoDirtyFlag = false;
        this.bkinfo = null;
    }

    public void setBackupMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupMode(n);
            return;
        }
        this.backupmode = n;
        this.backupmodeDirtyFlag = true;
    }

    public Integer getBackupMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupMode();
        }
        return this.backupmode;
    }

    public boolean isBackupModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupModeDirty();
        }
        return this.backupmodeDirtyFlag;
    }

    public void resetBackupMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupMode();
            return;
        }
        this.backupmodeDirtyFlag = false;
        this.backupmode = null;
    }

    public void setBKState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKState(n);
            return;
        }
        this.bkstate = n;
        this.bkstateDirtyFlag = true;
    }

    public Integer getBKState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKState();
        }
        return this.bkstate;
    }

    public boolean isBKStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKStateDirty();
        }
        return this.bkstateDirtyFlag;
    }

    public void resetBKState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKState();
            return;
        }
        this.bkstateDirtyFlag = false;
        this.bkstate = null;
    }

    public void setBKTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKTime(timestamp);
            return;
        }
        this.bktime = timestamp;
        this.bktimeDirtyFlag = true;
    }

    public Timestamp getBKTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKTime();
        }
        return this.bktime;
    }

    public boolean isBKTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKTimeDirty();
        }
        return this.bktimeDirtyFlag;
    }

    public void resetBKTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKTime();
            return;
        }
        this.bktimeDirtyFlag = false;
        this.bktime = null;
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

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
    }

    public void setFullBKFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullBKFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullbkfilepath = string;
        this.fullbkfilepathDirtyFlag = true;
    }

    public String getFullBKFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullBKFilePath();
        }
        return this.fullbkfilepath;
    }

    public boolean isFullBKFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullBKFilePathDirty();
        }
        return this.fullbkfilepathDirtyFlag;
    }

    public void resetFullBKFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullBKFilePath();
            return;
        }
        this.fullbkfilepathDirtyFlag = false;
        this.fullbkfilepath = null;
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

    public void setPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.passwd = string;
        this.passwdDirtyFlag = true;
    }

    public String getPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPasswd();
        }
        return this.passwd;
    }

    public boolean isPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPasswdDirty();
        }
        return this.passwdDirtyFlag;
    }

    public void resetPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPasswd();
            return;
        }
        this.passwdDirtyFlag = false;
        this.passwd = null;
    }

    public void setPPSDCDBInstBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDCDBInstBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdcdbinstbkid = string;
        this.ppsdcdbinstbkidDirtyFlag = true;
    }

    public String getPPSDCDBInstBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCDBInstBKId();
        }
        return this.ppsdcdbinstbkid;
    }

    public boolean isPPSDCDBInstBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDCDBInstBKIdDirty();
        }
        return this.ppsdcdbinstbkidDirtyFlag;
    }

    public void resetPPSDCDBInstBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDCDBInstBKId();
            return;
        }
        this.ppsdcdbinstbkidDirtyFlag = false;
        this.ppsdcdbinstbkid = null;
    }

    public void setPPSDCDBInstBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDCDBInstBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdcdbinstbkname = string;
        this.ppsdcdbinstbknameDirtyFlag = true;
    }

    public String getPPSDCDBInstBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCDBInstBKName();
        }
        return this.ppsdcdbinstbkname;
    }

    public boolean isPPSDCDBInstBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDCDBInstBKNameDirty();
        }
        return this.ppsdcdbinstbknameDirtyFlag;
    }

    public void resetPPSDCDBInstBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDCDBInstBKName();
            return;
        }
        this.ppsdcdbinstbknameDirtyFlag = false;
        this.ppsdcdbinstbkname = null;
    }

    public void setPSDBDevInstBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstbkid = string;
        this.psdbdevinstbkidDirtyFlag = true;
    }

    public String getPSDBDevInstBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstBKId();
        }
        return this.psdbdevinstbkid;
    }

    public boolean isPSDBDevInstBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstBKIdDirty();
        }
        return this.psdbdevinstbkidDirtyFlag;
    }

    public void resetPSDBDevInstBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstBKId();
            return;
        }
        this.psdbdevinstbkidDirtyFlag = false;
        this.psdbdevinstbkid = null;
    }

    public void setPSDBDevInstBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstbkname = string;
        this.psdbdevinstbknameDirtyFlag = true;
    }

    public String getPSDBDevInstBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstBKName();
        }
        return this.psdbdevinstbkname;
    }

    public boolean isPSDBDevInstBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstBKNameDirty();
        }
        return this.psdbdevinstbknameDirtyFlag;
    }

    public void resetPSDBDevInstBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstBKName();
            return;
        }
        this.psdbdevinstbknameDirtyFlag = false;
        this.psdbdevinstbkname = null;
    }

    public void setPSDCDBInstBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstbkid = string;
        this.psdcdbinstbkidDirtyFlag = true;
    }

    public String getPSDCDBInstBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstBKId();
        }
        return this.psdcdbinstbkid;
    }

    public boolean isPSDCDBInstBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstBKIdDirty();
        }
        return this.psdcdbinstbkidDirtyFlag;
    }

    public void resetPSDCDBInstBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstBKId();
            return;
        }
        this.psdcdbinstbkidDirtyFlag = false;
        this.psdcdbinstbkid = null;
    }

    public void setPSDCDBInstBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstbkname = string;
        this.psdcdbinstbknameDirtyFlag = true;
    }

    public String getPSDCDBInstBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstBKName();
        }
        return this.psdcdbinstbkname;
    }

    public boolean isPSDCDBInstBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstBKNameDirty();
        }
        return this.psdcdbinstbknameDirtyFlag;
    }

    public void resetPSDCDBInstBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstBKName();
            return;
        }
        this.psdcdbinstbknameDirtyFlag = false;
        this.psdcdbinstbkname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
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
        PSDCDBInstBKBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBInstBKBase pSDCDBInstBKBase) {
        pSDCDBInstBKBase.resetBackupSize();
        pSDCDBInstBKBase.resetBKFilePath();
        pSDCDBInstBKBase.resetBKInfo();
        pSDCDBInstBKBase.resetBackupMode();
        pSDCDBInstBKBase.resetBKState();
        pSDCDBInstBKBase.resetBKTime();
        pSDCDBInstBKBase.resetCreateDate();
        pSDCDBInstBKBase.resetCreateMan();
        pSDCDBInstBKBase.resetDBType();
        pSDCDBInstBKBase.resetFullBKFilePath();
        pSDCDBInstBKBase.resetMemo();
        pSDCDBInstBKBase.resetPasswd();
        pSDCDBInstBKBase.resetPPSDCDBInstBKId();
        pSDCDBInstBKBase.resetPPSDCDBInstBKName();
        pSDCDBInstBKBase.resetPSDBDevInstBKId();
        pSDCDBInstBKBase.resetPSDBDevInstBKName();
        pSDCDBInstBKBase.resetPSDCDBInstBKId();
        pSDCDBInstBKBase.resetPSDCDBInstBKName();
        pSDCDBInstBKBase.resetPSDevCenterDBInstId();
        pSDCDBInstBKBase.resetPSDevCenterDBInstName();
        pSDCDBInstBKBase.resetPSDevCenterId();
        pSDCDBInstBKBase.resetPSDevCenterName();
        pSDCDBInstBKBase.resetPSTaskServerId();
        pSDCDBInstBKBase.resetPSTaskServerName();
        pSDCDBInstBKBase.resetUpdateDate();
        pSDCDBInstBKBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupSizeDirty()) {
            hashMap.put(FIELD_BACKUPSIZE, this.getBackupSize());
        }
        if (!bl || this.isBKFilePathDirty()) {
            hashMap.put(FIELD_BKFILEPATH, this.getBKFilePath());
        }
        if (!bl || this.isBKInfoDirty()) {
            hashMap.put(FIELD_BKINFO, this.getBKInfo());
        }
        if (!bl || this.isBackupModeDirty()) {
            hashMap.put(FIELD_BACKUPMODE, this.getBackupMode());
        }
        if (!bl || this.isBKStateDirty()) {
            hashMap.put(FIELD_BKSTATE, this.getBKState());
        }
        if (!bl || this.isBKTimeDirty()) {
            hashMap.put(FIELD_BKTIME, this.getBKTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isFullBKFilePathDirty()) {
            hashMap.put(FIELD_FULLBKFILEPATH, this.getFullBKFilePath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPPSDCDBInstBKIdDirty()) {
            hashMap.put(FIELD_PPSDCDBINSTBKID, this.getPPSDCDBInstBKId());
        }
        if (!bl || this.isPPSDCDBInstBKNameDirty()) {
            hashMap.put(FIELD_PPSDCDBINSTBKNAME, this.getPPSDCDBInstBKName());
        }
        if (!bl || this.isPSDBDevInstBKIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTBKID, this.getPSDBDevInstBKId());
        }
        if (!bl || this.isPSDBDevInstBKNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTBKNAME, this.getPSDBDevInstBKName());
        }
        if (!bl || this.isPSDCDBInstBKIdDirty()) {
            hashMap.put(FIELD_PSDCDBINSTBKID, this.getPSDCDBInstBKId());
        }
        if (!bl || this.isPSDCDBInstBKNameDirty()) {
            hashMap.put(FIELD_PSDCDBINSTBKNAME, this.getPSDCDBInstBKName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
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
        return PSDCDBInstBKBase.get(this, n);
    }

    private static Object get(PSDCDBInstBKBase pSDCDBInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstBKBase.getBackupSize();
            }
            case 1: {
                return pSDCDBInstBKBase.getBKFilePath();
            }
            case 2: {
                return pSDCDBInstBKBase.getBKInfo();
            }
            case 3: {
                return pSDCDBInstBKBase.getBackupMode();
            }
            case 4: {
                return pSDCDBInstBKBase.getBKState();
            }
            case 5: {
                return pSDCDBInstBKBase.getBKTime();
            }
            case 6: {
                return pSDCDBInstBKBase.getCreateDate();
            }
            case 7: {
                return pSDCDBInstBKBase.getCreateMan();
            }
            case 8: {
                return pSDCDBInstBKBase.getDBType();
            }
            case 9: {
                return pSDCDBInstBKBase.getFullBKFilePath();
            }
            case 10: {
                return pSDCDBInstBKBase.getMemo();
            }
            case 11: {
                return pSDCDBInstBKBase.getPasswd();
            }
            case 12: {
                return pSDCDBInstBKBase.getPPSDCDBInstBKId();
            }
            case 13: {
                return pSDCDBInstBKBase.getPPSDCDBInstBKName();
            }
            case 14: {
                return pSDCDBInstBKBase.getPSDBDevInstBKId();
            }
            case 15: {
                return pSDCDBInstBKBase.getPSDBDevInstBKName();
            }
            case 16: {
                return pSDCDBInstBKBase.getPSDCDBInstBKId();
            }
            case 17: {
                return pSDCDBInstBKBase.getPSDCDBInstBKName();
            }
            case 18: {
                return pSDCDBInstBKBase.getPSDevCenterDBInstId();
            }
            case 19: {
                return pSDCDBInstBKBase.getPSDevCenterDBInstName();
            }
            case 20: {
                return pSDCDBInstBKBase.getPSDevCenterId();
            }
            case 21: {
                return pSDCDBInstBKBase.getPSDevCenterName();
            }
            case 22: {
                return pSDCDBInstBKBase.getPSTaskServerId();
            }
            case 23: {
                return pSDCDBInstBKBase.getPSTaskServerName();
            }
            case 24: {
                return pSDCDBInstBKBase.getUpdateDate();
            }
            case 25: {
                return pSDCDBInstBKBase.getUpdateMan();
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
        PSDCDBInstBKBase.set(this, n, object);
    }

    private static void set(PSDCDBInstBKBase pSDCDBInstBKBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBInstBKBase.setBackupSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBInstBKBase.setBKFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBInstBKBase.setBKInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBInstBKBase.setBackupMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBInstBKBase.setBKState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBInstBKBase.setBKTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBInstBKBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBInstBKBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBInstBKBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBInstBKBase.setFullBKFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDBInstBKBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDBInstBKBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCDBInstBKBase.setPPSDCDBInstBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCDBInstBKBase.setPPSDCDBInstBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCDBInstBKBase.setPSDBDevInstBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCDBInstBKBase.setPSDBDevInstBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCDBInstBKBase.setPSDCDBInstBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCDBInstBKBase.setPSDCDBInstBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCDBInstBKBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCDBInstBKBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCDBInstBKBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCDBInstBKBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCDBInstBKBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCDBInstBKBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCDBInstBKBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDCDBInstBKBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBInstBKBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBInstBKBase pSDCDBInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstBKBase.getBackupSize() == null;
            }
            case 1: {
                return pSDCDBInstBKBase.getBKFilePath() == null;
            }
            case 2: {
                return pSDCDBInstBKBase.getBKInfo() == null;
            }
            case 3: {
                return pSDCDBInstBKBase.getBackupMode() == null;
            }
            case 4: {
                return pSDCDBInstBKBase.getBKState() == null;
            }
            case 5: {
                return pSDCDBInstBKBase.getBKTime() == null;
            }
            case 6: {
                return pSDCDBInstBKBase.getCreateDate() == null;
            }
            case 7: {
                return pSDCDBInstBKBase.getCreateMan() == null;
            }
            case 8: {
                return pSDCDBInstBKBase.getDBType() == null;
            }
            case 9: {
                return pSDCDBInstBKBase.getFullBKFilePath() == null;
            }
            case 10: {
                return pSDCDBInstBKBase.getMemo() == null;
            }
            case 11: {
                return pSDCDBInstBKBase.getPasswd() == null;
            }
            case 12: {
                return pSDCDBInstBKBase.getPPSDCDBInstBKId() == null;
            }
            case 13: {
                return pSDCDBInstBKBase.getPPSDCDBInstBKName() == null;
            }
            case 14: {
                return pSDCDBInstBKBase.getPSDBDevInstBKId() == null;
            }
            case 15: {
                return pSDCDBInstBKBase.getPSDBDevInstBKName() == null;
            }
            case 16: {
                return pSDCDBInstBKBase.getPSDCDBInstBKId() == null;
            }
            case 17: {
                return pSDCDBInstBKBase.getPSDCDBInstBKName() == null;
            }
            case 18: {
                return pSDCDBInstBKBase.getPSDevCenterDBInstId() == null;
            }
            case 19: {
                return pSDCDBInstBKBase.getPSDevCenterDBInstName() == null;
            }
            case 20: {
                return pSDCDBInstBKBase.getPSDevCenterId() == null;
            }
            case 21: {
                return pSDCDBInstBKBase.getPSDevCenterName() == null;
            }
            case 22: {
                return pSDCDBInstBKBase.getPSTaskServerId() == null;
            }
            case 23: {
                return pSDCDBInstBKBase.getPSTaskServerName() == null;
            }
            case 24: {
                return pSDCDBInstBKBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDCDBInstBKBase.getUpdateMan() == null;
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
        return PSDCDBInstBKBase.contains(this, n);
    }

    private static boolean contains(PSDCDBInstBKBase pSDCDBInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstBKBase.isBackupSizeDirty();
            }
            case 1: {
                return pSDCDBInstBKBase.isBKFilePathDirty();
            }
            case 2: {
                return pSDCDBInstBKBase.isBKInfoDirty();
            }
            case 3: {
                return pSDCDBInstBKBase.isBackupModeDirty();
            }
            case 4: {
                return pSDCDBInstBKBase.isBKStateDirty();
            }
            case 5: {
                return pSDCDBInstBKBase.isBKTimeDirty();
            }
            case 6: {
                return pSDCDBInstBKBase.isCreateDateDirty();
            }
            case 7: {
                return pSDCDBInstBKBase.isCreateManDirty();
            }
            case 8: {
                return pSDCDBInstBKBase.isDBTypeDirty();
            }
            case 9: {
                return pSDCDBInstBKBase.isFullBKFilePathDirty();
            }
            case 10: {
                return pSDCDBInstBKBase.isMemoDirty();
            }
            case 11: {
                return pSDCDBInstBKBase.isPasswdDirty();
            }
            case 12: {
                return pSDCDBInstBKBase.isPPSDCDBInstBKIdDirty();
            }
            case 13: {
                return pSDCDBInstBKBase.isPPSDCDBInstBKNameDirty();
            }
            case 14: {
                return pSDCDBInstBKBase.isPSDBDevInstBKIdDirty();
            }
            case 15: {
                return pSDCDBInstBKBase.isPSDBDevInstBKNameDirty();
            }
            case 16: {
                return pSDCDBInstBKBase.isPSDCDBInstBKIdDirty();
            }
            case 17: {
                return pSDCDBInstBKBase.isPSDCDBInstBKNameDirty();
            }
            case 18: {
                return pSDCDBInstBKBase.isPSDevCenterDBInstIdDirty();
            }
            case 19: {
                return pSDCDBInstBKBase.isPSDevCenterDBInstNameDirty();
            }
            case 20: {
                return pSDCDBInstBKBase.isPSDevCenterIdDirty();
            }
            case 21: {
                return pSDCDBInstBKBase.isPSDevCenterNameDirty();
            }
            case 22: {
                return pSDCDBInstBKBase.isPSTaskServerIdDirty();
            }
            case 23: {
                return pSDCDBInstBKBase.isPSTaskServerNameDirty();
            }
            case 24: {
                return pSDCDBInstBKBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDCDBInstBKBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBInstBKBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBInstBKBase pSDCDBInstBKBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBInstBKBase.getBackupSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupsize", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBackupSize()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getBKFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkfilepath", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBKFilePath()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getBKInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkinfo", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBKInfo()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkmode", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getBKState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkstate", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBKState()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getBKTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bktime", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getBKTime()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getDBType()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getFullBKFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullbkfilepath", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getFullBKFilePath()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPPSDCDBInstBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdcdbinstbkid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPPSDCDBInstBKId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPPSDCDBInstBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdcdbinstbkname", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPPSDCDBInstBKName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDBDevInstBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstbkid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDBDevInstBKId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDBDevInstBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstbkname", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDBDevInstBKName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDCDBInstBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstbkid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDCDBInstBKId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDCDBInstBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstbkname", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDCDBInstBKName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBInstBKBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBInstBKBase.getJSONValue((Object)pSDCDBInstBKBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBInstBKBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBInstBKBase pSDCDBInstBKBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBInstBKBase.getBackupSize() != null) {
            object = pSDCDBInstBKBase.getBackupSize();
            xmlNode.setAttribute(FIELD_BACKUPSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getBKFilePath() != null) {
            object = pSDCDBInstBKBase.getBKFilePath();
            xmlNode.setAttribute(FIELD_BKFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getBKInfo() != null) {
            object = pSDCDBInstBKBase.getBKInfo();
            xmlNode.setAttribute(FIELD_BKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getBackupMode() != null) {
            object = pSDCDBInstBKBase.getBackupMode();
            xmlNode.setAttribute("BACKUPMODE", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getBKState() != null) {
            object = pSDCDBInstBKBase.getBKState();
            xmlNode.setAttribute(FIELD_BKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getBKTime() != null) {
            object = pSDCDBInstBKBase.getBKTime();
            xmlNode.setAttribute(FIELD_BKTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getCreateDate() != null) {
            object = pSDCDBInstBKBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getCreateMan() != null) {
            object = pSDCDBInstBKBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getDBType() != null) {
            object = pSDCDBInstBKBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getFullBKFilePath() != null) {
            object = pSDCDBInstBKBase.getFullBKFilePath();
            xmlNode.setAttribute(FIELD_FULLBKFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getMemo() != null) {
            object = pSDCDBInstBKBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPasswd() != null) {
            object = pSDCDBInstBKBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPPSDCDBInstBKId() != null) {
            object = pSDCDBInstBKBase.getPPSDCDBInstBKId();
            xmlNode.setAttribute(FIELD_PPSDCDBINSTBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPPSDCDBInstBKName() != null) {
            object = pSDCDBInstBKBase.getPPSDCDBInstBKName();
            xmlNode.setAttribute(FIELD_PPSDCDBINSTBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDBDevInstBKId() != null) {
            object = pSDCDBInstBKBase.getPSDBDevInstBKId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDBDevInstBKName() != null) {
            object = pSDCDBInstBKBase.getPSDBDevInstBKName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDCDBInstBKId() != null) {
            object = pSDCDBInstBKBase.getPSDCDBInstBKId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDCDBInstBKName() != null) {
            object = pSDCDBInstBKBase.getPSDCDBInstBKName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterDBInstId() != null) {
            object = pSDCDBInstBKBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterDBInstName() != null) {
            object = pSDCDBInstBKBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterId() != null) {
            object = pSDCDBInstBKBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSDevCenterName() != null) {
            object = pSDCDBInstBKBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSTaskServerId() != null) {
            object = pSDCDBInstBKBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getPSTaskServerName() != null) {
            object = pSDCDBInstBKBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstBKBase.getUpdateDate() != null) {
            object = pSDCDBInstBKBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBInstBKBase.getUpdateMan() != null) {
            object = pSDCDBInstBKBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBInstBKBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBInstBKBase pSDCDBInstBKBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBInstBKBase.isBackupSizeDirty() && (bl || pSDCDBInstBKBase.getBackupSize() != null)) {
            iDataObject.set(FIELD_BACKUPSIZE, (Object)pSDCDBInstBKBase.getBackupSize());
        }
        if (pSDCDBInstBKBase.isBKFilePathDirty() && (bl || pSDCDBInstBKBase.getBKFilePath() != null)) {
            iDataObject.set(FIELD_BKFILEPATH, (Object)pSDCDBInstBKBase.getBKFilePath());
        }
        if (pSDCDBInstBKBase.isBKInfoDirty() && (bl || pSDCDBInstBKBase.getBKInfo() != null)) {
            iDataObject.set(FIELD_BKINFO, (Object)pSDCDBInstBKBase.getBKInfo());
        }
        if (pSDCDBInstBKBase.isBackupModeDirty() && (bl || pSDCDBInstBKBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDCDBInstBKBase.getBackupMode());
        }
        if (pSDCDBInstBKBase.isBKStateDirty() && (bl || pSDCDBInstBKBase.getBKState() != null)) {
            iDataObject.set(FIELD_BKSTATE, (Object)pSDCDBInstBKBase.getBKState());
        }
        if (pSDCDBInstBKBase.isBKTimeDirty() && (bl || pSDCDBInstBKBase.getBKTime() != null)) {
            iDataObject.set(FIELD_BKTIME, (Object)pSDCDBInstBKBase.getBKTime());
        }
        if (pSDCDBInstBKBase.isCreateDateDirty() && (bl || pSDCDBInstBKBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBInstBKBase.getCreateDate());
        }
        if (pSDCDBInstBKBase.isCreateManDirty() && (bl || pSDCDBInstBKBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBInstBKBase.getCreateMan());
        }
        if (pSDCDBInstBKBase.isDBTypeDirty() && (bl || pSDCDBInstBKBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDCDBInstBKBase.getDBType());
        }
        if (pSDCDBInstBKBase.isFullBKFilePathDirty() && (bl || pSDCDBInstBKBase.getFullBKFilePath() != null)) {
            iDataObject.set(FIELD_FULLBKFILEPATH, (Object)pSDCDBInstBKBase.getFullBKFilePath());
        }
        if (pSDCDBInstBKBase.isMemoDirty() && (bl || pSDCDBInstBKBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBInstBKBase.getMemo());
        }
        if (pSDCDBInstBKBase.isPasswdDirty() && (bl || pSDCDBInstBKBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDCDBInstBKBase.getPasswd());
        }
        if (pSDCDBInstBKBase.isPPSDCDBInstBKIdDirty() && (bl || pSDCDBInstBKBase.getPPSDCDBInstBKId() != null)) {
            iDataObject.set(FIELD_PPSDCDBINSTBKID, (Object)pSDCDBInstBKBase.getPPSDCDBInstBKId());
        }
        if (pSDCDBInstBKBase.isPPSDCDBInstBKNameDirty() && (bl || pSDCDBInstBKBase.getPPSDCDBInstBKName() != null)) {
            iDataObject.set(FIELD_PPSDCDBINSTBKNAME, (Object)pSDCDBInstBKBase.getPPSDCDBInstBKName());
        }
        if (pSDCDBInstBKBase.isPSDBDevInstBKIdDirty() && (bl || pSDCDBInstBKBase.getPSDBDevInstBKId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTBKID, (Object)pSDCDBInstBKBase.getPSDBDevInstBKId());
        }
        if (pSDCDBInstBKBase.isPSDBDevInstBKNameDirty() && (bl || pSDCDBInstBKBase.getPSDBDevInstBKName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTBKNAME, (Object)pSDCDBInstBKBase.getPSDBDevInstBKName());
        }
        if (pSDCDBInstBKBase.isPSDCDBInstBKIdDirty() && (bl || pSDCDBInstBKBase.getPSDCDBInstBKId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTBKID, (Object)pSDCDBInstBKBase.getPSDCDBInstBKId());
        }
        if (pSDCDBInstBKBase.isPSDCDBInstBKNameDirty() && (bl || pSDCDBInstBKBase.getPSDCDBInstBKName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTBKNAME, (Object)pSDCDBInstBKBase.getPSDCDBInstBKName());
        }
        if (pSDCDBInstBKBase.isPSDevCenterDBInstIdDirty() && (bl || pSDCDBInstBKBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDCDBInstBKBase.getPSDevCenterDBInstId());
        }
        if (pSDCDBInstBKBase.isPSDevCenterDBInstNameDirty() && (bl || pSDCDBInstBKBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDCDBInstBKBase.getPSDevCenterDBInstName());
        }
        if (pSDCDBInstBKBase.isPSDevCenterIdDirty() && (bl || pSDCDBInstBKBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCDBInstBKBase.getPSDevCenterId());
        }
        if (pSDCDBInstBKBase.isPSDevCenterNameDirty() && (bl || pSDCDBInstBKBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCDBInstBKBase.getPSDevCenterName());
        }
        if (pSDCDBInstBKBase.isPSTaskServerIdDirty() && (bl || pSDCDBInstBKBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDCDBInstBKBase.getPSTaskServerId());
        }
        if (pSDCDBInstBKBase.isPSTaskServerNameDirty() && (bl || pSDCDBInstBKBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDCDBInstBKBase.getPSTaskServerName());
        }
        if (pSDCDBInstBKBase.isUpdateDateDirty() && (bl || pSDCDBInstBKBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBInstBKBase.getUpdateDate());
        }
        if (pSDCDBInstBKBase.isUpdateManDirty() && (bl || pSDCDBInstBKBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBInstBKBase.getUpdateMan());
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
        return PSDCDBInstBKBase.remove(this, n);
    }

    private static boolean remove(PSDCDBInstBKBase pSDCDBInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBInstBKBase.resetBackupSize();
                return true;
            }
            case 1: {
                pSDCDBInstBKBase.resetBKFilePath();
                return true;
            }
            case 2: {
                pSDCDBInstBKBase.resetBKInfo();
                return true;
            }
            case 3: {
                pSDCDBInstBKBase.resetBackupMode();
                return true;
            }
            case 4: {
                pSDCDBInstBKBase.resetBKState();
                return true;
            }
            case 5: {
                pSDCDBInstBKBase.resetBKTime();
                return true;
            }
            case 6: {
                pSDCDBInstBKBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDCDBInstBKBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDCDBInstBKBase.resetDBType();
                return true;
            }
            case 9: {
                pSDCDBInstBKBase.resetFullBKFilePath();
                return true;
            }
            case 10: {
                pSDCDBInstBKBase.resetMemo();
                return true;
            }
            case 11: {
                pSDCDBInstBKBase.resetPasswd();
                return true;
            }
            case 12: {
                pSDCDBInstBKBase.resetPPSDCDBInstBKId();
                return true;
            }
            case 13: {
                pSDCDBInstBKBase.resetPPSDCDBInstBKName();
                return true;
            }
            case 14: {
                pSDCDBInstBKBase.resetPSDBDevInstBKId();
                return true;
            }
            case 15: {
                pSDCDBInstBKBase.resetPSDBDevInstBKName();
                return true;
            }
            case 16: {
                pSDCDBInstBKBase.resetPSDCDBInstBKId();
                return true;
            }
            case 17: {
                pSDCDBInstBKBase.resetPSDCDBInstBKName();
                return true;
            }
            case 18: {
                pSDCDBInstBKBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 19: {
                pSDCDBInstBKBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 20: {
                pSDCDBInstBKBase.resetPSDevCenterId();
                return true;
            }
            case 21: {
                pSDCDBInstBKBase.resetPSDevCenterName();
                return true;
            }
            case 22: {
                pSDCDBInstBKBase.resetPSTaskServerId();
                return true;
            }
            case 23: {
                pSDCDBInstBKBase.resetPSTaskServerName();
                return true;
            }
            case 24: {
                pSDCDBInstBKBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDCDBInstBKBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInstBK getPSDBDevInstBK() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstBK();
        }
        if (this.getPSDBDevInstBKId() == null) {
            return null;
        }
        Integer n = this.objPSDBDevInstBKLock;
        synchronized (n) {
            if (this.psdbdevinstbk != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBDevInstBKId(), (Object)this.psdbdevinstbk.getPSDBDevInstBKId()) != 0L) {
                this.psdbdevinstbk = null;
            }
            if (this.psdbdevinstbk == null) {
                PSDBDevInstBK pSDBDevInstBK = new PSDBDevInstBK();
                pSDBDevInstBK.setPSDBDevInstBKId(this.getPSDBDevInstBKId());
                PSDBDevInstBKService pSDBDevInstBKService = (PSDBDevInstBKService)ServiceGlobal.getService(PSDBDevInstBKService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstBKService.autoGet((IEntity)pSDBDevInstBK);
                this.psdbdevinstbk = pSDBDevInstBK;
            }
            return this.psdbdevinstbk;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCDBInstBK getPPSDCDBInstBK() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDCDBInstBK();
        }
        if (this.getPPSDCDBInstBKId() == null) {
            return null;
        }
        Integer n = this.objPPSDCDBInstBKLock;
        synchronized (n) {
            if (this.ppsdcdbinstbk != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDCDBInstBKId(), (Object)this.ppsdcdbinstbk.getPSDCDBInstBKId()) != 0L) {
                this.ppsdcdbinstbk = null;
            }
            if (this.ppsdcdbinstbk == null) {
                PSDCDBInstBK pSDCDBInstBK = new PSDCDBInstBK();
                pSDCDBInstBK.setPSDCDBInstBKId(this.getPPSDCDBInstBKId());
                PSDCDBInstBKService pSDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)this.getSessionFactory());
                pSDCDBInstBKService.autoGet((IEntity)pSDCDBInstBK);
                this.ppsdcdbinstbk = pSDCDBInstBK;
            }
            return this.ppsdcdbinstbk;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
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
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCDBInstBK> getPSDCDBInstBKs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstBKs();
        }
        if (this.getPSDCDBInstBKId() == null) {
            return null;
        }
        PSDCDBInstBKService pSDCDBInstBKService = (PSDCDBInstBKService)ServiceGlobal.getService(PSDCDBInstBKService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCDBInstBKsLock;
        synchronized (n) {
            if (this.psdcdbinstbks == null) {
                this.psdcdbinstbks = pSDCDBInstBKService.selectByPPSDCDBInstBK(this);
            }
            return this.psdcdbinstbks;
        }
    }

    private PSDCDBInstBKBase getProxyEntity() {
        return this.proxyPSDCDBInstBKBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBInstBKBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBInstBKBase) {
            this.proxyPSDCDBInstBKBase = (PSDCDBInstBKBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstBKService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPSIZE, 0);
        fieldIndexMap.put(FIELD_BKFILEPATH, 1);
        fieldIndexMap.put(FIELD_BKINFO, 2);
        fieldIndexMap.put(FIELD_BACKUPMODE, 3);
        fieldIndexMap.put(FIELD_BKSTATE, 4);
        fieldIndexMap.put(FIELD_BKTIME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_DBTYPE, 8);
        fieldIndexMap.put(FIELD_FULLBKFILEPATH, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PASSWD, 11);
        fieldIndexMap.put(FIELD_PPSDCDBINSTBKID, 12);
        fieldIndexMap.put(FIELD_PPSDCDBINSTBKNAME, 13);
        fieldIndexMap.put(FIELD_PSDBDEVINSTBKID, 14);
        fieldIndexMap.put(FIELD_PSDBDEVINSTBKNAME, 15);
        fieldIndexMap.put(FIELD_PSDCDBINSTBKID, 16);
        fieldIndexMap.put(FIELD_PSDCDBINSTBKNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 18);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 19);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 20);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 21);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 22);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

