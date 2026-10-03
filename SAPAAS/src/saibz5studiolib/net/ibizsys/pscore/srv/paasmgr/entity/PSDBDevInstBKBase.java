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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDBDevInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDBDevInstBKBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDBDevInstBKBase.class);
    public static final String FIELD_BKFILEPATH = "BKFILEPATH";
    public static final String FIELD_BKFILESIZE = "BKFILESIZE";
    public static final String FIELD_BKINFO = "BKINFO";
    public static final String FIELD_BACKUPMODE = "BKMODE";
    public static final String FIELD_BKSTATE = "BKSTATE";
    public static final String FIELD_BKTIME = "BKTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSDBDEVINSTBKID = "PSDBDEVINSTBKID";
    public static final String FIELD_PSDBDEVINSTBKNAME = "PSDBDEVINSTBKNAME";
    public static final String FIELD_PSDBDEVINSTID = "PSDBDEVINSTID";
    public static final String FIELD_PSDBDEVINSTNAME = "PSDBDEVINSTNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BKFILEPATH = 0;
    private static final int INDEX_BKFILESIZE = 1;
    private static final int INDEX_BKINFO = 2;
    private static final int INDEX_BACKUPMODE = 3;
    private static final int INDEX_BKSTATE = 4;
    private static final int INDEX_BKTIME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_PASSWD = 9;
    private static final int INDEX_PSDBDEVINSTBKID = 10;
    private static final int INDEX_PSDBDEVINSTBKNAME = 11;
    private static final int INDEX_PSDBDEVINSTID = 12;
    private static final int INDEX_PSDBDEVINSTNAME = 13;
    private static final int INDEX_PSTASKSERVERID = 14;
    private static final int INDEX_PSTASKSERVERNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_VALIDFLAG = 18;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDBDevInstBKBase proxyPSDBDevInstBKBase = null;
    private boolean bkfilepathDirtyFlag = false;
    private boolean bkfilesizeDirtyFlag = false;
    private boolean bkinfoDirtyFlag = false;
    private boolean backupmodeDirtyFlag = false;
    private boolean bkstateDirtyFlag = false;
    private boolean bktimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean psdbdevinstbkidDirtyFlag = false;
    private boolean psdbdevinstbknameDirtyFlag = false;
    private boolean psdbdevinstidDirtyFlag = false;
    private boolean psdbdevinstnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bkfilepath")
    private String bkfilepath;
    @Column(name="bkfilesize")
    private Integer bkfilesize;
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
    @Column(name="memo")
    private String memo;
    @Column(name="passwd")
    private String passwd;
    @Column(name="psdbdevinstbkid")
    private String psdbdevinstbkid;
    @Column(name="psdbdevinstbkname")
    private String psdbdevinstbkname;
    @Column(name="psdbdevinstid")
    private String psdbdevinstid;
    @Column(name="psdbdevinstname")
    private String psdbdevinstname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDBDevInstLock = new Integer(1);
    private PSDBDevInst psdbdevinst = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setBKFileSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKFileSize(n);
            return;
        }
        this.bkfilesize = n;
        this.bkfilesizeDirtyFlag = true;
    }

    public Integer getBKFileSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKFileSize();
        }
        return this.bkfilesize;
    }

    public boolean isBKFileSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKFileSizeDirty();
        }
        return this.bkfilesizeDirtyFlag;
    }

    public void resetBKFileSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKFileSize();
            return;
        }
        this.bkfilesizeDirtyFlag = false;
        this.bkfilesize = null;
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

    public void setPSDBDevInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstid = string;
        this.psdbdevinstidDirtyFlag = true;
    }

    public String getPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstId();
        }
        return this.psdbdevinstid;
    }

    public boolean isPSDBDevInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstIdDirty();
        }
        return this.psdbdevinstidDirtyFlag;
    }

    public void resetPSDBDevInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstId();
            return;
        }
        this.psdbdevinstidDirtyFlag = false;
        this.psdbdevinstid = null;
    }

    public void setPSDBDevInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBDevInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbdevinstname = string;
        this.psdbdevinstnameDirtyFlag = true;
    }

    public String getPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInstName();
        }
        return this.psdbdevinstname;
    }

    public boolean isPSDBDevInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBDevInstNameDirty();
        }
        return this.psdbdevinstnameDirtyFlag;
    }

    public void resetPSDBDevInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBDevInstName();
            return;
        }
        this.psdbdevinstnameDirtyFlag = false;
        this.psdbdevinstname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDBDevInstBKBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDBDevInstBKBase pSDBDevInstBKBase) {
        pSDBDevInstBKBase.resetBKFilePath();
        pSDBDevInstBKBase.resetBKFileSize();
        pSDBDevInstBKBase.resetBKInfo();
        pSDBDevInstBKBase.resetBackupMode();
        pSDBDevInstBKBase.resetBKState();
        pSDBDevInstBKBase.resetBKTime();
        pSDBDevInstBKBase.resetCreateDate();
        pSDBDevInstBKBase.resetCreateMan();
        pSDBDevInstBKBase.resetMemo();
        pSDBDevInstBKBase.resetPasswd();
        pSDBDevInstBKBase.resetPSDBDevInstBKId();
        pSDBDevInstBKBase.resetPSDBDevInstBKName();
        pSDBDevInstBKBase.resetPSDBDevInstId();
        pSDBDevInstBKBase.resetPSDBDevInstName();
        pSDBDevInstBKBase.resetPSTaskServerId();
        pSDBDevInstBKBase.resetPSTaskServerName();
        pSDBDevInstBKBase.resetUpdateDate();
        pSDBDevInstBKBase.resetUpdateMan();
        pSDBDevInstBKBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBKFilePathDirty()) {
            hashMap.put(FIELD_BKFILEPATH, this.getBKFilePath());
        }
        if (!bl || this.isBKFileSizeDirty()) {
            hashMap.put(FIELD_BKFILESIZE, this.getBKFileSize());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPasswdDirty()) {
            hashMap.put(FIELD_PASSWD, this.getPasswd());
        }
        if (!bl || this.isPSDBDevInstBKIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTBKID, this.getPSDBDevInstBKId());
        }
        if (!bl || this.isPSDBDevInstBKNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTBKNAME, this.getPSDBDevInstBKName());
        }
        if (!bl || this.isPSDBDevInstIdDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTID, this.getPSDBDevInstId());
        }
        if (!bl || this.isPSDBDevInstNameDirty()) {
            hashMap.put(FIELD_PSDBDEVINSTNAME, this.getPSDBDevInstName());
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
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDBDevInstBKBase.get(this, n);
    }

    private static Object get(PSDBDevInstBKBase pSDBDevInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBKBase.getBKFilePath();
            }
            case 1: {
                return pSDBDevInstBKBase.getBKFileSize();
            }
            case 2: {
                return pSDBDevInstBKBase.getBKInfo();
            }
            case 3: {
                return pSDBDevInstBKBase.getBackupMode();
            }
            case 4: {
                return pSDBDevInstBKBase.getBKState();
            }
            case 5: {
                return pSDBDevInstBKBase.getBKTime();
            }
            case 6: {
                return pSDBDevInstBKBase.getCreateDate();
            }
            case 7: {
                return pSDBDevInstBKBase.getCreateMan();
            }
            case 8: {
                return pSDBDevInstBKBase.getMemo();
            }
            case 9: {
                return pSDBDevInstBKBase.getPasswd();
            }
            case 10: {
                return pSDBDevInstBKBase.getPSDBDevInstBKId();
            }
            case 11: {
                return pSDBDevInstBKBase.getPSDBDevInstBKName();
            }
            case 12: {
                return pSDBDevInstBKBase.getPSDBDevInstId();
            }
            case 13: {
                return pSDBDevInstBKBase.getPSDBDevInstName();
            }
            case 14: {
                return pSDBDevInstBKBase.getPSTaskServerId();
            }
            case 15: {
                return pSDBDevInstBKBase.getPSTaskServerName();
            }
            case 16: {
                return pSDBDevInstBKBase.getUpdateDate();
            }
            case 17: {
                return pSDBDevInstBKBase.getUpdateMan();
            }
            case 18: {
                return pSDBDevInstBKBase.getValidFlag();
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
        PSDBDevInstBKBase.set(this, n, object);
    }

    private static void set(PSDBDevInstBKBase pSDBDevInstBKBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDBDevInstBKBase.setBKFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDBDevInstBKBase.setBKFileSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDBDevInstBKBase.setBKInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDBDevInstBKBase.setBackupMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDBDevInstBKBase.setBKState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDBDevInstBKBase.setBKTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDBDevInstBKBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDBDevInstBKBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDBDevInstBKBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDBDevInstBKBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDBDevInstBKBase.setPSDBDevInstBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDBDevInstBKBase.setPSDBDevInstBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDBDevInstBKBase.setPSDBDevInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDBDevInstBKBase.setPSDBDevInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDBDevInstBKBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDBDevInstBKBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDBDevInstBKBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDBDevInstBKBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDBDevInstBKBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDBDevInstBKBase.isNull(this, n);
    }

    private static boolean isNull(PSDBDevInstBKBase pSDBDevInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBKBase.getBKFilePath() == null;
            }
            case 1: {
                return pSDBDevInstBKBase.getBKFileSize() == null;
            }
            case 2: {
                return pSDBDevInstBKBase.getBKInfo() == null;
            }
            case 3: {
                return pSDBDevInstBKBase.getBackupMode() == null;
            }
            case 4: {
                return pSDBDevInstBKBase.getBKState() == null;
            }
            case 5: {
                return pSDBDevInstBKBase.getBKTime() == null;
            }
            case 6: {
                return pSDBDevInstBKBase.getCreateDate() == null;
            }
            case 7: {
                return pSDBDevInstBKBase.getCreateMan() == null;
            }
            case 8: {
                return pSDBDevInstBKBase.getMemo() == null;
            }
            case 9: {
                return pSDBDevInstBKBase.getPasswd() == null;
            }
            case 10: {
                return pSDBDevInstBKBase.getPSDBDevInstBKId() == null;
            }
            case 11: {
                return pSDBDevInstBKBase.getPSDBDevInstBKName() == null;
            }
            case 12: {
                return pSDBDevInstBKBase.getPSDBDevInstId() == null;
            }
            case 13: {
                return pSDBDevInstBKBase.getPSDBDevInstName() == null;
            }
            case 14: {
                return pSDBDevInstBKBase.getPSTaskServerId() == null;
            }
            case 15: {
                return pSDBDevInstBKBase.getPSTaskServerName() == null;
            }
            case 16: {
                return pSDBDevInstBKBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDBDevInstBKBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDBDevInstBKBase.getValidFlag() == null;
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
        return PSDBDevInstBKBase.contains(this, n);
    }

    private static boolean contains(PSDBDevInstBKBase pSDBDevInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDBDevInstBKBase.isBKFilePathDirty();
            }
            case 1: {
                return pSDBDevInstBKBase.isBKFileSizeDirty();
            }
            case 2: {
                return pSDBDevInstBKBase.isBKInfoDirty();
            }
            case 3: {
                return pSDBDevInstBKBase.isBackupModeDirty();
            }
            case 4: {
                return pSDBDevInstBKBase.isBKStateDirty();
            }
            case 5: {
                return pSDBDevInstBKBase.isBKTimeDirty();
            }
            case 6: {
                return pSDBDevInstBKBase.isCreateDateDirty();
            }
            case 7: {
                return pSDBDevInstBKBase.isCreateManDirty();
            }
            case 8: {
                return pSDBDevInstBKBase.isMemoDirty();
            }
            case 9: {
                return pSDBDevInstBKBase.isPasswdDirty();
            }
            case 10: {
                return pSDBDevInstBKBase.isPSDBDevInstBKIdDirty();
            }
            case 11: {
                return pSDBDevInstBKBase.isPSDBDevInstBKNameDirty();
            }
            case 12: {
                return pSDBDevInstBKBase.isPSDBDevInstIdDirty();
            }
            case 13: {
                return pSDBDevInstBKBase.isPSDBDevInstNameDirty();
            }
            case 14: {
                return pSDBDevInstBKBase.isPSTaskServerIdDirty();
            }
            case 15: {
                return pSDBDevInstBKBase.isPSTaskServerNameDirty();
            }
            case 16: {
                return pSDBDevInstBKBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDBDevInstBKBase.isUpdateManDirty();
            }
            case 18: {
                return pSDBDevInstBKBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDBDevInstBKBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDBDevInstBKBase pSDBDevInstBKBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDBDevInstBKBase.getBKFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkfilepath", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBKFilePath()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getBKFileSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkfilesize", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBKFileSize()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getBKInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkinfo", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBKInfo()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getBackupMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkmode", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBackupMode()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getBKState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkstate", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBKState()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getBKTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bktime", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getBKTime()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getMemo()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPasswd()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstbkid", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSDBDevInstBKId()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstbkname", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSDBDevInstBKName()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstid", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSDBDevInstId()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbdevinstname", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSDBDevInstName()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDBDevInstBKBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDBDevInstBKBase.getJSONValue((Object)pSDBDevInstBKBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDBDevInstBKBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDBDevInstBKBase pSDBDevInstBKBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDBDevInstBKBase.getBKFilePath() != null) {
            object = pSDBDevInstBKBase.getBKFilePath();
            xmlNode.setAttribute(FIELD_BKFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getBKFileSize() != null) {
            object = pSDBDevInstBKBase.getBKFileSize();
            xmlNode.setAttribute(FIELD_BKFILESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getBKInfo() != null) {
            object = pSDBDevInstBKBase.getBKInfo();
            xmlNode.setAttribute(FIELD_BKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getBackupMode() != null) {
            object = pSDBDevInstBKBase.getBackupMode();
            xmlNode.setAttribute("BACKUPMODE", object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getBKState() != null) {
            object = pSDBDevInstBKBase.getBKState();
            xmlNode.setAttribute(FIELD_BKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getBKTime() != null) {
            object = pSDBDevInstBKBase.getBKTime();
            xmlNode.setAttribute(FIELD_BKTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getCreateDate() != null) {
            object = pSDBDevInstBKBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getCreateMan() != null) {
            object = pSDBDevInstBKBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getMemo() != null) {
            object = pSDBDevInstBKBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPasswd() != null) {
            object = pSDBDevInstBKBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstBKId() != null) {
            object = pSDBDevInstBKBase.getPSDBDevInstBKId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTBKID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstBKName() != null) {
            object = pSDBDevInstBKBase.getPSDBDevInstBKName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstId() != null) {
            object = pSDBDevInstBKBase.getPSDBDevInstId();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSDBDevInstName() != null) {
            object = pSDBDevInstBKBase.getPSDBDevInstName();
            xmlNode.setAttribute(FIELD_PSDBDEVINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSTaskServerId() != null) {
            object = pSDBDevInstBKBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getPSTaskServerName() != null) {
            object = pSDBDevInstBKBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getUpdateDate() != null) {
            object = pSDBDevInstBKBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDBDevInstBKBase.getUpdateMan() != null) {
            object = pSDBDevInstBKBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDBDevInstBKBase.getValidFlag() != null) {
            object = pSDBDevInstBKBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDBDevInstBKBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDBDevInstBKBase pSDBDevInstBKBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDBDevInstBKBase.isBKFilePathDirty() && (bl || pSDBDevInstBKBase.getBKFilePath() != null)) {
            iDataObject.set(FIELD_BKFILEPATH, (Object)pSDBDevInstBKBase.getBKFilePath());
        }
        if (pSDBDevInstBKBase.isBKFileSizeDirty() && (bl || pSDBDevInstBKBase.getBKFileSize() != null)) {
            iDataObject.set(FIELD_BKFILESIZE, (Object)pSDBDevInstBKBase.getBKFileSize());
        }
        if (pSDBDevInstBKBase.isBKInfoDirty() && (bl || pSDBDevInstBKBase.getBKInfo() != null)) {
            iDataObject.set(FIELD_BKINFO, (Object)pSDBDevInstBKBase.getBKInfo());
        }
        if (pSDBDevInstBKBase.isBackupModeDirty() && (bl || pSDBDevInstBKBase.getBackupMode() != null)) {
            iDataObject.set(FIELD_BACKUPMODE, (Object)pSDBDevInstBKBase.getBackupMode());
        }
        if (pSDBDevInstBKBase.isBKStateDirty() && (bl || pSDBDevInstBKBase.getBKState() != null)) {
            iDataObject.set(FIELD_BKSTATE, (Object)pSDBDevInstBKBase.getBKState());
        }
        if (pSDBDevInstBKBase.isBKTimeDirty() && (bl || pSDBDevInstBKBase.getBKTime() != null)) {
            iDataObject.set(FIELD_BKTIME, (Object)pSDBDevInstBKBase.getBKTime());
        }
        if (pSDBDevInstBKBase.isCreateDateDirty() && (bl || pSDBDevInstBKBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDBDevInstBKBase.getCreateDate());
        }
        if (pSDBDevInstBKBase.isCreateManDirty() && (bl || pSDBDevInstBKBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDBDevInstBKBase.getCreateMan());
        }
        if (pSDBDevInstBKBase.isMemoDirty() && (bl || pSDBDevInstBKBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDBDevInstBKBase.getMemo());
        }
        if (pSDBDevInstBKBase.isPasswdDirty() && (bl || pSDBDevInstBKBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSDBDevInstBKBase.getPasswd());
        }
        if (pSDBDevInstBKBase.isPSDBDevInstBKIdDirty() && (bl || pSDBDevInstBKBase.getPSDBDevInstBKId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTBKID, (Object)pSDBDevInstBKBase.getPSDBDevInstBKId());
        }
        if (pSDBDevInstBKBase.isPSDBDevInstBKNameDirty() && (bl || pSDBDevInstBKBase.getPSDBDevInstBKName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTBKNAME, (Object)pSDBDevInstBKBase.getPSDBDevInstBKName());
        }
        if (pSDBDevInstBKBase.isPSDBDevInstIdDirty() && (bl || pSDBDevInstBKBase.getPSDBDevInstId() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTID, (Object)pSDBDevInstBKBase.getPSDBDevInstId());
        }
        if (pSDBDevInstBKBase.isPSDBDevInstNameDirty() && (bl || pSDBDevInstBKBase.getPSDBDevInstName() != null)) {
            iDataObject.set(FIELD_PSDBDEVINSTNAME, (Object)pSDBDevInstBKBase.getPSDBDevInstName());
        }
        if (pSDBDevInstBKBase.isPSTaskServerIdDirty() && (bl || pSDBDevInstBKBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDBDevInstBKBase.getPSTaskServerId());
        }
        if (pSDBDevInstBKBase.isPSTaskServerNameDirty() && (bl || pSDBDevInstBKBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDBDevInstBKBase.getPSTaskServerName());
        }
        if (pSDBDevInstBKBase.isUpdateDateDirty() && (bl || pSDBDevInstBKBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDBDevInstBKBase.getUpdateDate());
        }
        if (pSDBDevInstBKBase.isUpdateManDirty() && (bl || pSDBDevInstBKBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDBDevInstBKBase.getUpdateMan());
        }
        if (pSDBDevInstBKBase.isValidFlagDirty() && (bl || pSDBDevInstBKBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDBDevInstBKBase.getValidFlag());
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
        return PSDBDevInstBKBase.remove(this, n);
    }

    private static boolean remove(PSDBDevInstBKBase pSDBDevInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDBDevInstBKBase.resetBKFilePath();
                return true;
            }
            case 1: {
                pSDBDevInstBKBase.resetBKFileSize();
                return true;
            }
            case 2: {
                pSDBDevInstBKBase.resetBKInfo();
                return true;
            }
            case 3: {
                pSDBDevInstBKBase.resetBackupMode();
                return true;
            }
            case 4: {
                pSDBDevInstBKBase.resetBKState();
                return true;
            }
            case 5: {
                pSDBDevInstBKBase.resetBKTime();
                return true;
            }
            case 6: {
                pSDBDevInstBKBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSDBDevInstBKBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSDBDevInstBKBase.resetMemo();
                return true;
            }
            case 9: {
                pSDBDevInstBKBase.resetPasswd();
                return true;
            }
            case 10: {
                pSDBDevInstBKBase.resetPSDBDevInstBKId();
                return true;
            }
            case 11: {
                pSDBDevInstBKBase.resetPSDBDevInstBKName();
                return true;
            }
            case 12: {
                pSDBDevInstBKBase.resetPSDBDevInstId();
                return true;
            }
            case 13: {
                pSDBDevInstBKBase.resetPSDBDevInstName();
                return true;
            }
            case 14: {
                pSDBDevInstBKBase.resetPSTaskServerId();
                return true;
            }
            case 15: {
                pSDBDevInstBKBase.resetPSTaskServerName();
                return true;
            }
            case 16: {
                pSDBDevInstBKBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDBDevInstBKBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDBDevInstBKBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBDevInst getPSDBDevInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBDevInst();
        }
        if (this.getPSDBDevInstId() == null) {
            return null;
        }
        Integer n = this.objPSDBDevInstLock;
        synchronized (n) {
            if (this.psdbdevinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBDevInstId(), (Object)this.psdbdevinst.getPSDBDevInstId()) != 0L) {
                this.psdbdevinst = null;
            }
            if (this.psdbdevinst == null) {
                PSDBDevInst pSDBDevInst = new PSDBDevInst();
                pSDBDevInst.setPSDBDevInstId(this.getPSDBDevInstId());
                PSDBDevInstService pSDBDevInstService = (PSDBDevInstService)ServiceGlobal.getService(PSDBDevInstService.class, (SessionFactory)this.getSessionFactory());
                pSDBDevInstService.autoGet(pSDBDevInst);
                this.psdbdevinst = pSDBDevInst;
            }
            return this.psdbdevinst;
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

    private PSDBDevInstBKBase getProxyEntity() {
        return this.proxyPSDBDevInstBKBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDBDevInstBKBase = null;
        if (iDataObject != null && iDataObject instanceof PSDBDevInstBKBase) {
            this.proxyPSDBDevInstBKBase = (PSDBDevInstBKBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDBDevInstBKService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BKFILEPATH, 0);
        fieldIndexMap.put(FIELD_BKFILESIZE, 1);
        fieldIndexMap.put(FIELD_BKINFO, 2);
        fieldIndexMap.put(FIELD_BACKUPMODE, 3);
        fieldIndexMap.put(FIELD_BKSTATE, 4);
        fieldIndexMap.put(FIELD_BKTIME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_PASSWD, 9);
        fieldIndexMap.put(FIELD_PSDBDEVINSTBKID, 10);
        fieldIndexMap.put(FIELD_PSDBDEVINSTBKNAME, 11);
        fieldIndexMap.put(FIELD_PSDBDEVINSTID, 12);
        fieldIndexMap.put(FIELD_PSDBDEVINSTNAME, 13);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 14);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_VALIDFLAG, 18);
    }
}

