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
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelInstBKBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelInstBKBase.class);
    public static final String FIELD_BKFILEPATH = "BKFILEPATH";
    public static final String FIELD_BKFILESIZE = "BKFILESIZE";
    public static final String FIELD_BKINFO = "BKINFO";
    public static final String FIELD_BKSTATE = "BKSTATE";
    public static final String FIELD_BKTIME = "BKTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PASSWD = "PASSWD";
    public static final String FIELD_PSSYSMODELINSTBKID = "PSSYSMODELINSTBKID";
    public static final String FIELD_PSSYSMODELINSTBKNAME = "PSSYSMODELINSTBKNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BKFILEPATH = 0;
    private static final int INDEX_BKFILESIZE = 1;
    private static final int INDEX_BKINFO = 2;
    private static final int INDEX_BKSTATE = 3;
    private static final int INDEX_BKTIME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PASSWD = 8;
    private static final int INDEX_PSSYSMODELINSTBKID = 9;
    private static final int INDEX_PSSYSMODELINSTBKNAME = 10;
    private static final int INDEX_PSSYSMODELINSTID = 11;
    private static final int INDEX_PSSYSMODELINSTNAME = 12;
    private static final int INDEX_PSTASKSERVERID = 13;
    private static final int INDEX_PSTASKSERVERNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelInstBKBase proxyPSSysModelInstBKBase = null;
    private boolean bkfilepathDirtyFlag = false;
    private boolean bkfilesizeDirtyFlag = false;
    private boolean bkinfoDirtyFlag = false;
    private boolean bkstateDirtyFlag = false;
    private boolean bktimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean passwdDirtyFlag = false;
    private boolean pssysmodelinstbkidDirtyFlag = false;
    private boolean pssysmodelinstbknameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
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
    @Column(name="pssysmodelinstbkid")
    private String pssysmodelinstbkid;
    @Column(name="pssysmodelinstbkname")
    private String pssysmodelinstbkname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
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
    private Integer objPssysmodelinstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
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

    public void setPSSysModelInstBKId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstBKId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstbkid = string;
        this.pssysmodelinstbkidDirtyFlag = true;
    }

    public String getPSSysModelInstBKId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstBKId();
        }
        return this.pssysmodelinstbkid;
    }

    public boolean isPSSysModelInstBKIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstBKIdDirty();
        }
        return this.pssysmodelinstbkidDirtyFlag;
    }

    public void resetPSSysModelInstBKId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstBKId();
            return;
        }
        this.pssysmodelinstbkidDirtyFlag = false;
        this.pssysmodelinstbkid = null;
    }

    public void setPSSysModelInstBKName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstBKName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstbkname = string;
        this.pssysmodelinstbknameDirtyFlag = true;
    }

    public String getPSSysModelInstBKName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstBKName();
        }
        return this.pssysmodelinstbkname;
    }

    public boolean isPSSysModelInstBKNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstBKNameDirty();
        }
        return this.pssysmodelinstbknameDirtyFlag;
    }

    public void resetPSSysModelInstBKName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstBKName();
            return;
        }
        this.pssysmodelinstbknameDirtyFlag = false;
        this.pssysmodelinstbkname = null;
    }

    public void setPSSysModelInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstid = string;
        this.pssysmodelinstidDirtyFlag = true;
    }

    public String getPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstId();
        }
        return this.pssysmodelinstid;
    }

    public boolean isPSSysModelInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstIdDirty();
        }
        return this.pssysmodelinstidDirtyFlag;
    }

    public void resetPSSysModelInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstId();
            return;
        }
        this.pssysmodelinstidDirtyFlag = false;
        this.pssysmodelinstid = null;
    }

    public void setPSSysModelInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelinstname = string;
        this.pssysmodelinstnameDirtyFlag = true;
    }

    public String getPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInstName();
        }
        return this.pssysmodelinstname;
    }

    public boolean isPSSysModelInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelInstNameDirty();
        }
        return this.pssysmodelinstnameDirtyFlag;
    }

    public void resetPSSysModelInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelInstName();
            return;
        }
        this.pssysmodelinstnameDirtyFlag = false;
        this.pssysmodelinstname = null;
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
        PSSysModelInstBKBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelInstBKBase pSSysModelInstBKBase) {
        pSSysModelInstBKBase.resetBKFilePath();
        pSSysModelInstBKBase.resetBKFileSize();
        pSSysModelInstBKBase.resetBKInfo();
        pSSysModelInstBKBase.resetBKState();
        pSSysModelInstBKBase.resetBKTime();
        pSSysModelInstBKBase.resetCreateDate();
        pSSysModelInstBKBase.resetCreateMan();
        pSSysModelInstBKBase.resetMemo();
        pSSysModelInstBKBase.resetPasswd();
        pSSysModelInstBKBase.resetPSSysModelInstBKId();
        pSSysModelInstBKBase.resetPSSysModelInstBKName();
        pSSysModelInstBKBase.resetPSSysModelInstId();
        pSSysModelInstBKBase.resetPSSysModelInstName();
        pSSysModelInstBKBase.resetPSTaskServerId();
        pSSysModelInstBKBase.resetPSTaskServerName();
        pSSysModelInstBKBase.resetUpdateDate();
        pSSysModelInstBKBase.resetUpdateMan();
        pSSysModelInstBKBase.resetValidFlag();
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
        if (!bl || this.isPSSysModelInstBKIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTBKID, this.getPSSysModelInstBKId());
        }
        if (!bl || this.isPSSysModelInstBKNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTBKNAME, this.getPSSysModelInstBKName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSysModelInstNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTNAME, this.getPSSysModelInstName());
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
        return PSSysModelInstBKBase.get(this, n);
    }

    private static Object get(PSSysModelInstBKBase pSSysModelInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBKBase.getBKFilePath();
            }
            case 1: {
                return pSSysModelInstBKBase.getBKFileSize();
            }
            case 2: {
                return pSSysModelInstBKBase.getBKInfo();
            }
            case 3: {
                return pSSysModelInstBKBase.getBKState();
            }
            case 4: {
                return pSSysModelInstBKBase.getBKTime();
            }
            case 5: {
                return pSSysModelInstBKBase.getCreateDate();
            }
            case 6: {
                return pSSysModelInstBKBase.getCreateMan();
            }
            case 7: {
                return pSSysModelInstBKBase.getMemo();
            }
            case 8: {
                return pSSysModelInstBKBase.getPasswd();
            }
            case 9: {
                return pSSysModelInstBKBase.getPSSysModelInstBKId();
            }
            case 10: {
                return pSSysModelInstBKBase.getPSSysModelInstBKName();
            }
            case 11: {
                return pSSysModelInstBKBase.getPSSysModelInstId();
            }
            case 12: {
                return pSSysModelInstBKBase.getPSSysModelInstName();
            }
            case 13: {
                return pSSysModelInstBKBase.getPSTaskServerId();
            }
            case 14: {
                return pSSysModelInstBKBase.getPSTaskServerName();
            }
            case 15: {
                return pSSysModelInstBKBase.getUpdateDate();
            }
            case 16: {
                return pSSysModelInstBKBase.getUpdateMan();
            }
            case 17: {
                return pSSysModelInstBKBase.getValidFlag();
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
        PSSysModelInstBKBase.set(this, n, object);
    }

    private static void set(PSSysModelInstBKBase pSSysModelInstBKBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstBKBase.setBKFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelInstBKBase.setBKFileSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelInstBKBase.setBKInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelInstBKBase.setBKState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelInstBKBase.setBKTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelInstBKBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelInstBKBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelInstBKBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelInstBKBase.setPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelInstBKBase.setPSSysModelInstBKId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelInstBKBase.setPSSysModelInstBKName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelInstBKBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelInstBKBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelInstBKBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelInstBKBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelInstBKBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelInstBKBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelInstBKBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysModelInstBKBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelInstBKBase pSSysModelInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBKBase.getBKFilePath() == null;
            }
            case 1: {
                return pSSysModelInstBKBase.getBKFileSize() == null;
            }
            case 2: {
                return pSSysModelInstBKBase.getBKInfo() == null;
            }
            case 3: {
                return pSSysModelInstBKBase.getBKState() == null;
            }
            case 4: {
                return pSSysModelInstBKBase.getBKTime() == null;
            }
            case 5: {
                return pSSysModelInstBKBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysModelInstBKBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysModelInstBKBase.getMemo() == null;
            }
            case 8: {
                return pSSysModelInstBKBase.getPasswd() == null;
            }
            case 9: {
                return pSSysModelInstBKBase.getPSSysModelInstBKId() == null;
            }
            case 10: {
                return pSSysModelInstBKBase.getPSSysModelInstBKName() == null;
            }
            case 11: {
                return pSSysModelInstBKBase.getPSSysModelInstId() == null;
            }
            case 12: {
                return pSSysModelInstBKBase.getPSSysModelInstName() == null;
            }
            case 13: {
                return pSSysModelInstBKBase.getPSTaskServerId() == null;
            }
            case 14: {
                return pSSysModelInstBKBase.getPSTaskServerName() == null;
            }
            case 15: {
                return pSSysModelInstBKBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSysModelInstBKBase.getUpdateMan() == null;
            }
            case 17: {
                return pSSysModelInstBKBase.getValidFlag() == null;
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
        return PSSysModelInstBKBase.contains(this, n);
    }

    private static boolean contains(PSSysModelInstBKBase pSSysModelInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelInstBKBase.isBKFilePathDirty();
            }
            case 1: {
                return pSSysModelInstBKBase.isBKFileSizeDirty();
            }
            case 2: {
                return pSSysModelInstBKBase.isBKInfoDirty();
            }
            case 3: {
                return pSSysModelInstBKBase.isBKStateDirty();
            }
            case 4: {
                return pSSysModelInstBKBase.isBKTimeDirty();
            }
            case 5: {
                return pSSysModelInstBKBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysModelInstBKBase.isCreateManDirty();
            }
            case 7: {
                return pSSysModelInstBKBase.isMemoDirty();
            }
            case 8: {
                return pSSysModelInstBKBase.isPasswdDirty();
            }
            case 9: {
                return pSSysModelInstBKBase.isPSSysModelInstBKIdDirty();
            }
            case 10: {
                return pSSysModelInstBKBase.isPSSysModelInstBKNameDirty();
            }
            case 11: {
                return pSSysModelInstBKBase.isPSSysModelInstIdDirty();
            }
            case 12: {
                return pSSysModelInstBKBase.isPSSysModelInstNameDirty();
            }
            case 13: {
                return pSSysModelInstBKBase.isPSTaskServerIdDirty();
            }
            case 14: {
                return pSSysModelInstBKBase.isPSTaskServerNameDirty();
            }
            case 15: {
                return pSSysModelInstBKBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSysModelInstBKBase.isUpdateManDirty();
            }
            case 17: {
                return pSSysModelInstBKBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelInstBKBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelInstBKBase pSSysModelInstBKBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelInstBKBase.getBKFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkfilepath", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getBKFilePath()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getBKFileSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkfilesize", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getBKFileSize()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getBKInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkinfo", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getBKInfo()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getBKState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkstate", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getBKState()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getBKTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bktime", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getBKTime()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"passwd", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPasswd()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstBKId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstbkid", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSSysModelInstBKId()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstBKName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstbkname", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSSysModelInstBKName()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysModelInstBKBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysModelInstBKBase.getJSONValue((Object)pSSysModelInstBKBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelInstBKBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelInstBKBase pSSysModelInstBKBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelInstBKBase.getBKFilePath() != null) {
            object = pSSysModelInstBKBase.getBKFilePath();
            xmlNode.setAttribute(FIELD_BKFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getBKFileSize() != null) {
            object = pSSysModelInstBKBase.getBKFileSize();
            xmlNode.setAttribute(FIELD_BKFILESIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBKBase.getBKInfo() != null) {
            object = pSSysModelInstBKBase.getBKInfo();
            xmlNode.setAttribute(FIELD_BKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getBKState() != null) {
            object = pSSysModelInstBKBase.getBKState();
            xmlNode.setAttribute(FIELD_BKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelInstBKBase.getBKTime() != null) {
            object = pSSysModelInstBKBase.getBKTime();
            xmlNode.setAttribute(FIELD_BKTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBKBase.getCreateDate() != null) {
            object = pSSysModelInstBKBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBKBase.getCreateMan() != null) {
            object = pSSysModelInstBKBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getMemo() != null) {
            object = pSSysModelInstBKBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPasswd() != null) {
            object = pSSysModelInstBKBase.getPasswd();
            xmlNode.setAttribute(FIELD_PASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstBKId() != null) {
            object = pSSysModelInstBKBase.getPSSysModelInstBKId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTBKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstBKName() != null) {
            object = pSSysModelInstBKBase.getPSSysModelInstBKName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTBKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstId() != null) {
            object = pSSysModelInstBKBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSSysModelInstName() != null) {
            object = pSSysModelInstBKBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSTaskServerId() != null) {
            object = pSSysModelInstBKBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getPSTaskServerName() != null) {
            object = pSSysModelInstBKBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getUpdateDate() != null) {
            object = pSSysModelInstBKBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelInstBKBase.getUpdateMan() != null) {
            object = pSSysModelInstBKBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelInstBKBase.getValidFlag() != null) {
            object = pSSysModelInstBKBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelInstBKBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelInstBKBase pSSysModelInstBKBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelInstBKBase.isBKFilePathDirty() && (bl || pSSysModelInstBKBase.getBKFilePath() != null)) {
            iDataObject.set(FIELD_BKFILEPATH, (Object)pSSysModelInstBKBase.getBKFilePath());
        }
        if (pSSysModelInstBKBase.isBKFileSizeDirty() && (bl || pSSysModelInstBKBase.getBKFileSize() != null)) {
            iDataObject.set(FIELD_BKFILESIZE, (Object)pSSysModelInstBKBase.getBKFileSize());
        }
        if (pSSysModelInstBKBase.isBKInfoDirty() && (bl || pSSysModelInstBKBase.getBKInfo() != null)) {
            iDataObject.set(FIELD_BKINFO, (Object)pSSysModelInstBKBase.getBKInfo());
        }
        if (pSSysModelInstBKBase.isBKStateDirty() && (bl || pSSysModelInstBKBase.getBKState() != null)) {
            iDataObject.set(FIELD_BKSTATE, (Object)pSSysModelInstBKBase.getBKState());
        }
        if (pSSysModelInstBKBase.isBKTimeDirty() && (bl || pSSysModelInstBKBase.getBKTime() != null)) {
            iDataObject.set(FIELD_BKTIME, (Object)pSSysModelInstBKBase.getBKTime());
        }
        if (pSSysModelInstBKBase.isCreateDateDirty() && (bl || pSSysModelInstBKBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelInstBKBase.getCreateDate());
        }
        if (pSSysModelInstBKBase.isCreateManDirty() && (bl || pSSysModelInstBKBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelInstBKBase.getCreateMan());
        }
        if (pSSysModelInstBKBase.isMemoDirty() && (bl || pSSysModelInstBKBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelInstBKBase.getMemo());
        }
        if (pSSysModelInstBKBase.isPasswdDirty() && (bl || pSSysModelInstBKBase.getPasswd() != null)) {
            iDataObject.set(FIELD_PASSWD, (Object)pSSysModelInstBKBase.getPasswd());
        }
        if (pSSysModelInstBKBase.isPSSysModelInstBKIdDirty() && (bl || pSSysModelInstBKBase.getPSSysModelInstBKId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTBKID, (Object)pSSysModelInstBKBase.getPSSysModelInstBKId());
        }
        if (pSSysModelInstBKBase.isPSSysModelInstBKNameDirty() && (bl || pSSysModelInstBKBase.getPSSysModelInstBKName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTBKNAME, (Object)pSSysModelInstBKBase.getPSSysModelInstBKName());
        }
        if (pSSysModelInstBKBase.isPSSysModelInstIdDirty() && (bl || pSSysModelInstBKBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSysModelInstBKBase.getPSSysModelInstId());
        }
        if (pSSysModelInstBKBase.isPSSysModelInstNameDirty() && (bl || pSSysModelInstBKBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSSysModelInstBKBase.getPSSysModelInstName());
        }
        if (pSSysModelInstBKBase.isPSTaskServerIdDirty() && (bl || pSSysModelInstBKBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSSysModelInstBKBase.getPSTaskServerId());
        }
        if (pSSysModelInstBKBase.isPSTaskServerNameDirty() && (bl || pSSysModelInstBKBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSSysModelInstBKBase.getPSTaskServerName());
        }
        if (pSSysModelInstBKBase.isUpdateDateDirty() && (bl || pSSysModelInstBKBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelInstBKBase.getUpdateDate());
        }
        if (pSSysModelInstBKBase.isUpdateManDirty() && (bl || pSSysModelInstBKBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelInstBKBase.getUpdateMan());
        }
        if (pSSysModelInstBKBase.isValidFlagDirty() && (bl || pSSysModelInstBKBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysModelInstBKBase.getValidFlag());
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
        return PSSysModelInstBKBase.remove(this, n);
    }

    private static boolean remove(PSSysModelInstBKBase pSSysModelInstBKBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelInstBKBase.resetBKFilePath();
                return true;
            }
            case 1: {
                pSSysModelInstBKBase.resetBKFileSize();
                return true;
            }
            case 2: {
                pSSysModelInstBKBase.resetBKInfo();
                return true;
            }
            case 3: {
                pSSysModelInstBKBase.resetBKState();
                return true;
            }
            case 4: {
                pSSysModelInstBKBase.resetBKTime();
                return true;
            }
            case 5: {
                pSSysModelInstBKBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysModelInstBKBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysModelInstBKBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysModelInstBKBase.resetPasswd();
                return true;
            }
            case 9: {
                pSSysModelInstBKBase.resetPSSysModelInstBKId();
                return true;
            }
            case 10: {
                pSSysModelInstBKBase.resetPSSysModelInstBKName();
                return true;
            }
            case 11: {
                pSSysModelInstBKBase.resetPSSysModelInstId();
                return true;
            }
            case 12: {
                pSSysModelInstBKBase.resetPSSysModelInstName();
                return true;
            }
            case 13: {
                pSSysModelInstBKBase.resetPSTaskServerId();
                return true;
            }
            case 14: {
                pSSysModelInstBKBase.resetPSTaskServerName();
                return true;
            }
            case 15: {
                pSSysModelInstBKBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSysModelInstBKBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSSysModelInstBKBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPssysmodelinst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysmodelinst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPssysmodelinstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet(pSSysModelInst);
                this.pssysmodelinst = pSSysModelInst;
            }
            return this.pssysmodelinst;
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

    private PSSysModelInstBKBase getProxyEntity() {
        return this.proxyPSSysModelInstBKBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelInstBKBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelInstBKBase) {
            this.proxyPSSysModelInstBKBase = (PSSysModelInstBKBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstBKService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BKFILEPATH, 0);
        fieldIndexMap.put(FIELD_BKFILESIZE, 1);
        fieldIndexMap.put(FIELD_BKINFO, 2);
        fieldIndexMap.put(FIELD_BKSTATE, 3);
        fieldIndexMap.put(FIELD_BKTIME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PASSWD, 8);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTBKID, 9);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTBKNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 12);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 13);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

