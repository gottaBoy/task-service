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
package net.ibizsys.pscore.srv.sysdevstudio.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSSysModelInst;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSSysModelInstService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDepInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysDepInstBase.class);
    public static final String FIELD_BACKUPFILEPATH = "BACKUPFILEPATH";
    public static final String FIELD_BACKUPSIZE = "BACKUPSIZE";
    public static final String FIELD_BACKUPSTATE = "BACKUPSTATE";
    public static final String FIELD_BACKUPTIME = "BACKUPTIME";
    public static final String FIELD_BEGINBACKUPTIME = "BEGINBACKUPTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPINSTSTATE = "DEPINSTSTATE";
    public static final String FIELD_ENDBACKUPTIME = "ENDBACKUPTIME";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_INSTPSDEVCENTERSVNID = "INSTPSDEVCENTERSVNID";
    public static final String FIELD_INSTPSDEVCENTERSVNNAME = "INSTPSDEVCENTERSVNNAME";
    public static final String FIELD_INSTTAG = "INSTTAG";
    public static final String FIELD_INSTTAG2 = "INSTTAG2";
    public static final String FIELD_INSTTAG3 = "INSTTAG3";
    public static final String FIELD_INSTTAG4 = "INSTTAG4";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_LASTCHECKINTIME = "LASTCHECKINTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String FIELD_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";
    public static final String FIELD_PSDEVSLNSYSDEPINSTNAME = "PSDEVSLNSYSDEPINSTNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSMODELINSTNAME = "PSSYSMODELINSTNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_SINGLEINSTMODE = "SINGLEINSTMODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKUPFILEPATH = 0;
    private static final int INDEX_BACKUPSIZE = 1;
    private static final int INDEX_BACKUPSTATE = 2;
    private static final int INDEX_BACKUPTIME = 3;
    private static final int INDEX_BEGINBACKUPTIME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEPINSTSTATE = 7;
    private static final int INDEX_ENDBACKUPTIME = 8;
    private static final int INDEX_EXPRIEDTIME = 9;
    private static final int INDEX_INSTPSDEVCENTERSVNID = 10;
    private static final int INDEX_INSTPSDEVCENTERSVNNAME = 11;
    private static final int INDEX_INSTTAG = 12;
    private static final int INDEX_INSTTAG2 = 13;
    private static final int INDEX_INSTTAG3 = 14;
    private static final int INDEX_INSTTAG4 = 15;
    private static final int INDEX_INSTVER = 16;
    private static final int INDEX_LASTCHECKINTIME = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_MODELPSDEVCENTERSVNID = 19;
    private static final int INDEX_MODELPSDEVCENTERSVNNAME = 20;
    private static final int INDEX_MODELVER = 21;
    private static final int INDEX_PSDEVCENTERID = 22;
    private static final int INDEX_PSDEVCENTERNAME = 23;
    private static final int INDEX_PSDEVSLNID = 24;
    private static final int INDEX_PSDEVSLNSYSDEPINSTID = 25;
    private static final int INDEX_PSDEVSLNSYSDEPINSTNAME = 26;
    private static final int INDEX_PSDEVSLNSYSID = 27;
    private static final int INDEX_PSDEVSLNSYSNAME = 28;
    private static final int INDEX_PSSYSMODELINSTID = 29;
    private static final int INDEX_PSSYSMODELINSTNAME = 30;
    private static final int INDEX_PSTASKSERVERID = 31;
    private static final int INDEX_PSTASKSERVERNAME = 32;
    private static final int INDEX_SINGLEINSTMODE = 33;
    private static final int INDEX_UPDATEDATE = 34;
    private static final int INDEX_UPDATEMAN = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysDepInstBase proxyPSDevSlnSysDepInstBase = null;
    private boolean backupfilepathDirtyFlag = false;
    private boolean backupsizeDirtyFlag = false;
    private boolean backupstateDirtyFlag = false;
    private boolean backuptimeDirtyFlag = false;
    private boolean beginbackuptimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean depinststateDirtyFlag = false;
    private boolean endbackuptimeDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean instpsdevcentersvnidDirtyFlag = false;
    private boolean instpsdevcentersvnnameDirtyFlag = false;
    private boolean insttagDirtyFlag = false;
    private boolean insttag2DirtyFlag = false;
    private boolean insttag3DirtyFlag = false;
    private boolean insttag4DirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean lastcheckintimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelpsdevcentersvnidDirtyFlag = false;
    private boolean modelpsdevcentersvnnameDirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysdepinstidDirtyFlag = false;
    private boolean psdevslnsysdepinstnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssysmodelinstnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean singleinstmodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backupfilepath")
    private String backupfilepath;
    @Column(name="backupsize")
    private Integer backupsize;
    @Column(name="backupstate")
    private Integer backupstate;
    @Column(name="backuptime")
    private Timestamp backuptime;
    @Column(name="beginbackuptime")
    private Timestamp beginbackuptime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="depinststate")
    private Integer depinststate;
    @Column(name="endbackuptime")
    private Timestamp endbackuptime;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="instpsdevcentersvnid")
    private String instpsdevcentersvnid;
    @Column(name="instpsdevcentersvnname")
    private String instpsdevcentersvnname;
    @Column(name="insttag")
    private String insttag;
    @Column(name="insttag2")
    private String insttag2;
    @Column(name="insttag3")
    private String insttag3;
    @Column(name="insttag4")
    private String insttag4;
    @Column(name="instver")
    private Integer instver;
    @Column(name="lastcheckintime")
    private Timestamp lastcheckintime;
    @Column(name="memo")
    private String memo;
    @Column(name="modelpsdevcentersvnid")
    private String modelpsdevcentersvnid;
    @Column(name="modelpsdevcentersvnname")
    private String modelpsdevcentersvnname;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysdepinstid")
    private String psdevslnsysdepinstid;
    @Column(name="psdevslnsysdepinstname")
    private String psdevslnsysdepinstname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssysmodelinstname")
    private String pssysmodelinstname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="singleinstmode")
    private Integer singleinstmode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objInstPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN instpsdevcentersvn = null;
    private Integer objModelPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN modelpsdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSSysModelInstLock = new Integer(1);
    private PSSysModelInst pssysmodelinst = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

    public void setBackupFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backupfilepath = string;
        this.backupfilepathDirtyFlag = true;
    }

    public String getBackupFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupFilePath();
        }
        return this.backupfilepath;
    }

    public boolean isBackupFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupFilePathDirty();
        }
        return this.backupfilepathDirtyFlag;
    }

    public void resetBackupFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupFilePath();
            return;
        }
        this.backupfilepathDirtyFlag = false;
        this.backupfilepath = null;
    }

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

    public void setBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupTime(timestamp);
            return;
        }
        this.backuptime = timestamp;
        this.backuptimeDirtyFlag = true;
    }

    public Timestamp getBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupTime();
        }
        return this.backuptime;
    }

    public boolean isBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupTimeDirty();
        }
        return this.backuptimeDirtyFlag;
    }

    public void resetBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupTime();
            return;
        }
        this.backuptimeDirtyFlag = false;
        this.backuptime = null;
    }

    public void setBeginBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginBackupTime(timestamp);
            return;
        }
        this.beginbackuptime = timestamp;
        this.beginbackuptimeDirtyFlag = true;
    }

    public Timestamp getBeginBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginBackupTime();
        }
        return this.beginbackuptime;
    }

    public boolean isBeginBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginBackupTimeDirty();
        }
        return this.beginbackuptimeDirtyFlag;
    }

    public void resetBeginBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginBackupTime();
            return;
        }
        this.beginbackuptimeDirtyFlag = false;
        this.beginbackuptime = null;
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

    public void setDepInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepInstState(n);
            return;
        }
        this.depinststate = n;
        this.depinststateDirtyFlag = true;
    }

    public Integer getDepInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepInstState();
        }
        return this.depinststate;
    }

    public boolean isDepInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepInstStateDirty();
        }
        return this.depinststateDirtyFlag;
    }

    public void resetDepInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepInstState();
            return;
        }
        this.depinststateDirtyFlag = false;
        this.depinststate = null;
    }

    public void setEndBackupTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndBackupTime(timestamp);
            return;
        }
        this.endbackuptime = timestamp;
        this.endbackuptimeDirtyFlag = true;
    }

    public Timestamp getEndBackupTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndBackupTime();
        }
        return this.endbackuptime;
    }

    public boolean isEndBackupTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndBackupTimeDirty();
        }
        return this.endbackuptimeDirtyFlag;
    }

    public void resetEndBackupTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndBackupTime();
            return;
        }
        this.endbackuptimeDirtyFlag = false;
        this.endbackuptime = null;
    }

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setInstPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instpsdevcentersvnid = string;
        this.instpsdevcentersvnidDirtyFlag = true;
    }

    public String getInstPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstPSDevCenterSVNId();
        }
        return this.instpsdevcentersvnid;
    }

    public boolean isInstPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstPSDevCenterSVNIdDirty();
        }
        return this.instpsdevcentersvnidDirtyFlag;
    }

    public void resetInstPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstPSDevCenterSVNId();
            return;
        }
        this.instpsdevcentersvnidDirtyFlag = false;
        this.instpsdevcentersvnid = null;
    }

    public void setInstPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instpsdevcentersvnname = string;
        this.instpsdevcentersvnnameDirtyFlag = true;
    }

    public String getInstPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstPSDevCenterSVNName();
        }
        return this.instpsdevcentersvnname;
    }

    public boolean isInstPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstPSDevCenterSVNNameDirty();
        }
        return this.instpsdevcentersvnnameDirtyFlag;
    }

    public void resetInstPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstPSDevCenterSVNName();
            return;
        }
        this.instpsdevcentersvnnameDirtyFlag = false;
        this.instpsdevcentersvnname = null;
    }

    public void setInstTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag = string;
        this.insttagDirtyFlag = true;
    }

    public String getInstTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag();
        }
        return this.insttag;
    }

    public boolean isInstTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTagDirty();
        }
        return this.insttagDirtyFlag;
    }

    public void resetInstTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag();
            return;
        }
        this.insttagDirtyFlag = false;
        this.insttag = null;
    }

    public void setInstTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag2 = string;
        this.insttag2DirtyFlag = true;
    }

    public String getInstTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag2();
        }
        return this.insttag2;
    }

    public boolean isInstTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag2Dirty();
        }
        return this.insttag2DirtyFlag;
    }

    public void resetInstTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag2();
            return;
        }
        this.insttag2DirtyFlag = false;
        this.insttag2 = null;
    }

    public void setInstTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag3 = string;
        this.insttag3DirtyFlag = true;
    }

    public String getInstTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag3();
        }
        return this.insttag3;
    }

    public boolean isInstTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag3Dirty();
        }
        return this.insttag3DirtyFlag;
    }

    public void resetInstTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag3();
            return;
        }
        this.insttag3DirtyFlag = false;
        this.insttag3 = null;
    }

    public void setInstTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag4 = string;
        this.insttag4DirtyFlag = true;
    }

    public String getInstTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag4();
        }
        return this.insttag4;
    }

    public boolean isInstTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag4Dirty();
        }
        return this.insttag4DirtyFlag;
    }

    public void resetInstTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag4();
            return;
        }
        this.insttag4DirtyFlag = false;
        this.insttag4 = null;
    }

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
    }

    public void setLastCheckinTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastCheckinTime(timestamp);
            return;
        }
        this.lastcheckintime = timestamp;
        this.lastcheckintimeDirtyFlag = true;
    }

    public Timestamp getLastCheckinTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastCheckinTime();
        }
        return this.lastcheckintime;
    }

    public boolean isLastCheckinTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastCheckinTimeDirty();
        }
        return this.lastcheckintimeDirtyFlag;
    }

    public void resetLastCheckinTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastCheckinTime();
            return;
        }
        this.lastcheckintimeDirtyFlag = false;
        this.lastcheckintime = null;
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

    public void setModelPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnid = string;
        this.modelpsdevcentersvnidDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNId();
        }
        return this.modelpsdevcentersvnid;
    }

    public boolean isModelPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNIdDirty();
        }
        return this.modelpsdevcentersvnidDirtyFlag;
    }

    public void resetModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNId();
            return;
        }
        this.modelpsdevcentersvnidDirtyFlag = false;
        this.modelpsdevcentersvnid = null;
    }

    public void setModelPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnname = string;
        this.modelpsdevcentersvnnameDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNName();
        }
        return this.modelpsdevcentersvnname;
    }

    public boolean isModelPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNNameDirty();
        }
        return this.modelpsdevcentersvnnameDirtyFlag;
    }

    public void resetModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNName();
            return;
        }
        this.modelpsdevcentersvnnameDirtyFlag = false;
        this.modelpsdevcentersvnname = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
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

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnSysDepInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDepInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdepinstid = string;
        this.psdevslnsysdepinstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInstId();
        }
        return this.psdevslnsysdepinstid;
    }

    public boolean isPSDevSlnSysDepInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDepInstIdDirty();
        }
        return this.psdevslnsysdepinstidDirtyFlag;
    }

    public void resetPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDepInstId();
            return;
        }
        this.psdevslnsysdepinstidDirtyFlag = false;
        this.psdevslnsysdepinstid = null;
    }

    public void setPSDevSlnSysDepInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDepInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdepinstname = string;
        this.psdevslnsysdepinstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDepInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInstName();
        }
        return this.psdevslnsysdepinstname;
    }

    public boolean isPSDevSlnSysDepInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDepInstNameDirty();
        }
        return this.psdevslnsysdepinstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDepInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDepInstName();
            return;
        }
        this.psdevslnsysdepinstnameDirtyFlag = false;
        this.psdevslnsysdepinstname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
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

    public void setSingleInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSingleInstMode(n);
            return;
        }
        this.singleinstmode = n;
        this.singleinstmodeDirtyFlag = true;
    }

    public Integer getSingleInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSingleInstMode();
        }
        return this.singleinstmode;
    }

    public boolean isSingleInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSingleInstModeDirty();
        }
        return this.singleinstmodeDirtyFlag;
    }

    public void resetSingleInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSingleInstMode();
            return;
        }
        this.singleinstmodeDirtyFlag = false;
        this.singleinstmode = null;
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
        PSDevSlnSysDepInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase) {
        pSDevSlnSysDepInstBase.resetBackupFilePath();
        pSDevSlnSysDepInstBase.resetBackupSize();
        pSDevSlnSysDepInstBase.resetBackupState();
        pSDevSlnSysDepInstBase.resetBackupTime();
        pSDevSlnSysDepInstBase.resetBeginBackupTime();
        pSDevSlnSysDepInstBase.resetCreateDate();
        pSDevSlnSysDepInstBase.resetCreateMan();
        pSDevSlnSysDepInstBase.resetDepInstState();
        pSDevSlnSysDepInstBase.resetEndBackupTime();
        pSDevSlnSysDepInstBase.resetExpriedTime();
        pSDevSlnSysDepInstBase.resetInstPSDevCenterSVNId();
        pSDevSlnSysDepInstBase.resetInstPSDevCenterSVNName();
        pSDevSlnSysDepInstBase.resetInstTag();
        pSDevSlnSysDepInstBase.resetInstTag2();
        pSDevSlnSysDepInstBase.resetInstTag3();
        pSDevSlnSysDepInstBase.resetInstTag4();
        pSDevSlnSysDepInstBase.resetInstVer();
        pSDevSlnSysDepInstBase.resetLastCheckinTime();
        pSDevSlnSysDepInstBase.resetMemo();
        pSDevSlnSysDepInstBase.resetModelPSDevCenterSVNId();
        pSDevSlnSysDepInstBase.resetModelPSDevCenterSVNName();
        pSDevSlnSysDepInstBase.resetModelVer();
        pSDevSlnSysDepInstBase.resetPSDevCenterId();
        pSDevSlnSysDepInstBase.resetPSDevCenterName();
        pSDevSlnSysDepInstBase.resetPSDevSlnId();
        pSDevSlnSysDepInstBase.resetPSDevSlnSysDepInstId();
        pSDevSlnSysDepInstBase.resetPSDevSlnSysDepInstName();
        pSDevSlnSysDepInstBase.resetPSDevSlnSysId();
        pSDevSlnSysDepInstBase.resetPSDevSlnSysName();
        pSDevSlnSysDepInstBase.resetPSSysModelInstId();
        pSDevSlnSysDepInstBase.resetPSSysModelInstName();
        pSDevSlnSysDepInstBase.resetPSTaskServerId();
        pSDevSlnSysDepInstBase.resetPSTaskServerName();
        pSDevSlnSysDepInstBase.resetSingleInstMode();
        pSDevSlnSysDepInstBase.resetUpdateDate();
        pSDevSlnSysDepInstBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackupFilePathDirty()) {
            hashMap.put(FIELD_BACKUPFILEPATH, this.getBackupFilePath());
        }
        if (!bl || this.isBackupSizeDirty()) {
            hashMap.put(FIELD_BACKUPSIZE, this.getBackupSize());
        }
        if (!bl || this.isBackupStateDirty()) {
            hashMap.put(FIELD_BACKUPSTATE, this.getBackupState());
        }
        if (!bl || this.isBackupTimeDirty()) {
            hashMap.put(FIELD_BACKUPTIME, this.getBackupTime());
        }
        if (!bl || this.isBeginBackupTimeDirty()) {
            hashMap.put(FIELD_BEGINBACKUPTIME, this.getBeginBackupTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDepInstStateDirty()) {
            hashMap.put(FIELD_DEPINSTSTATE, this.getDepInstState());
        }
        if (!bl || this.isEndBackupTimeDirty()) {
            hashMap.put(FIELD_ENDBACKUPTIME, this.getEndBackupTime());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isInstPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_INSTPSDEVCENTERSVNID, this.getInstPSDevCenterSVNId());
        }
        if (!bl || this.isInstPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_INSTPSDEVCENTERSVNNAME, this.getInstPSDevCenterSVNName());
        }
        if (!bl || this.isInstTagDirty()) {
            hashMap.put(FIELD_INSTTAG, this.getInstTag());
        }
        if (!bl || this.isInstTag2Dirty()) {
            hashMap.put(FIELD_INSTTAG2, this.getInstTag2());
        }
        if (!bl || this.isInstTag3Dirty()) {
            hashMap.put(FIELD_INSTTAG3, this.getInstTag3());
        }
        if (!bl || this.isInstTag4Dirty()) {
            hashMap.put(FIELD_INSTTAG4, this.getInstTag4());
        }
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isLastCheckinTimeDirty()) {
            hashMap.put(FIELD_LASTCHECKINTIME, this.getLastCheckinTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNID, this.getModelPSDevCenterSVNId());
        }
        if (!bl || this.isModelPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNNAME, this.getModelPSDevCenterSVNName());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysDepInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDEPINSTID, this.getPSDevSlnSysDepInstId());
        }
        if (!bl || this.isPSDevSlnSysDepInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDEPINSTNAME, this.getPSDevSlnSysDepInstName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
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
        if (!bl || this.isSingleInstModeDirty()) {
            hashMap.put(FIELD_SINGLEINSTMODE, this.getSingleInstMode());
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
        return PSDevSlnSysDepInstBase.get(this, n);
    }

    private static Object get(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDepInstBase.getBackupFilePath();
            }
            case 1: {
                return pSDevSlnSysDepInstBase.getBackupSize();
            }
            case 2: {
                return pSDevSlnSysDepInstBase.getBackupState();
            }
            case 3: {
                return pSDevSlnSysDepInstBase.getBackupTime();
            }
            case 4: {
                return pSDevSlnSysDepInstBase.getBeginBackupTime();
            }
            case 5: {
                return pSDevSlnSysDepInstBase.getCreateDate();
            }
            case 6: {
                return pSDevSlnSysDepInstBase.getCreateMan();
            }
            case 7: {
                return pSDevSlnSysDepInstBase.getDepInstState();
            }
            case 8: {
                return pSDevSlnSysDepInstBase.getEndBackupTime();
            }
            case 9: {
                return pSDevSlnSysDepInstBase.getExpriedTime();
            }
            case 10: {
                return pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId();
            }
            case 11: {
                return pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName();
            }
            case 12: {
                return pSDevSlnSysDepInstBase.getInstTag();
            }
            case 13: {
                return pSDevSlnSysDepInstBase.getInstTag2();
            }
            case 14: {
                return pSDevSlnSysDepInstBase.getInstTag3();
            }
            case 15: {
                return pSDevSlnSysDepInstBase.getInstTag4();
            }
            case 16: {
                return pSDevSlnSysDepInstBase.getInstVer();
            }
            case 17: {
                return pSDevSlnSysDepInstBase.getLastCheckinTime();
            }
            case 18: {
                return pSDevSlnSysDepInstBase.getMemo();
            }
            case 19: {
                return pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId();
            }
            case 20: {
                return pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName();
            }
            case 21: {
                return pSDevSlnSysDepInstBase.getModelVer();
            }
            case 22: {
                return pSDevSlnSysDepInstBase.getPSDevCenterId();
            }
            case 23: {
                return pSDevSlnSysDepInstBase.getPSDevCenterName();
            }
            case 24: {
                return pSDevSlnSysDepInstBase.getPSDevSlnId();
            }
            case 25: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId();
            }
            case 26: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName();
            }
            case 27: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysId();
            }
            case 28: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysName();
            }
            case 29: {
                return pSDevSlnSysDepInstBase.getPSSysModelInstId();
            }
            case 30: {
                return pSDevSlnSysDepInstBase.getPSSysModelInstName();
            }
            case 31: {
                return pSDevSlnSysDepInstBase.getPSTaskServerId();
            }
            case 32: {
                return pSDevSlnSysDepInstBase.getPSTaskServerName();
            }
            case 33: {
                return pSDevSlnSysDepInstBase.getSingleInstMode();
            }
            case 34: {
                return pSDevSlnSysDepInstBase.getUpdateDate();
            }
            case 35: {
                return pSDevSlnSysDepInstBase.getUpdateMan();
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
        PSDevSlnSysDepInstBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDepInstBase.setBackupFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysDepInstBase.setBackupSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysDepInstBase.setBackupState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysDepInstBase.setBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysDepInstBase.setBeginBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysDepInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysDepInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysDepInstBase.setDepInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysDepInstBase.setEndBackupTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysDepInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysDepInstBase.setInstPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysDepInstBase.setInstPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysDepInstBase.setInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysDepInstBase.setInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysDepInstBase.setInstTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysDepInstBase.setInstTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysDepInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysDepInstBase.setLastCheckinTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysDepInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysDepInstBase.setModelPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysDepInstBase.setModelPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysDepInstBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysDepInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysDepInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysDepInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysDepInstBase.setPSDevSlnSysDepInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysDepInstBase.setPSDevSlnSysDepInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysDepInstBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysDepInstBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysDepInstBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysDepInstBase.setPSSysModelInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysDepInstBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysDepInstBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysDepInstBase.setSingleInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysDepInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysDepInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysDepInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDepInstBase.getBackupFilePath() == null;
            }
            case 1: {
                return pSDevSlnSysDepInstBase.getBackupSize() == null;
            }
            case 2: {
                return pSDevSlnSysDepInstBase.getBackupState() == null;
            }
            case 3: {
                return pSDevSlnSysDepInstBase.getBackupTime() == null;
            }
            case 4: {
                return pSDevSlnSysDepInstBase.getBeginBackupTime() == null;
            }
            case 5: {
                return pSDevSlnSysDepInstBase.getCreateDate() == null;
            }
            case 6: {
                return pSDevSlnSysDepInstBase.getCreateMan() == null;
            }
            case 7: {
                return pSDevSlnSysDepInstBase.getDepInstState() == null;
            }
            case 8: {
                return pSDevSlnSysDepInstBase.getEndBackupTime() == null;
            }
            case 9: {
                return pSDevSlnSysDepInstBase.getExpriedTime() == null;
            }
            case 10: {
                return pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId() == null;
            }
            case 11: {
                return pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName() == null;
            }
            case 12: {
                return pSDevSlnSysDepInstBase.getInstTag() == null;
            }
            case 13: {
                return pSDevSlnSysDepInstBase.getInstTag2() == null;
            }
            case 14: {
                return pSDevSlnSysDepInstBase.getInstTag3() == null;
            }
            case 15: {
                return pSDevSlnSysDepInstBase.getInstTag4() == null;
            }
            case 16: {
                return pSDevSlnSysDepInstBase.getInstVer() == null;
            }
            case 17: {
                return pSDevSlnSysDepInstBase.getLastCheckinTime() == null;
            }
            case 18: {
                return pSDevSlnSysDepInstBase.getMemo() == null;
            }
            case 19: {
                return pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId() == null;
            }
            case 20: {
                return pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName() == null;
            }
            case 21: {
                return pSDevSlnSysDepInstBase.getModelVer() == null;
            }
            case 22: {
                return pSDevSlnSysDepInstBase.getPSDevCenterId() == null;
            }
            case 23: {
                return pSDevSlnSysDepInstBase.getPSDevCenterName() == null;
            }
            case 24: {
                return pSDevSlnSysDepInstBase.getPSDevSlnId() == null;
            }
            case 25: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId() == null;
            }
            case 26: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName() == null;
            }
            case 27: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysId() == null;
            }
            case 28: {
                return pSDevSlnSysDepInstBase.getPSDevSlnSysName() == null;
            }
            case 29: {
                return pSDevSlnSysDepInstBase.getPSSysModelInstId() == null;
            }
            case 30: {
                return pSDevSlnSysDepInstBase.getPSSysModelInstName() == null;
            }
            case 31: {
                return pSDevSlnSysDepInstBase.getPSTaskServerId() == null;
            }
            case 32: {
                return pSDevSlnSysDepInstBase.getPSTaskServerName() == null;
            }
            case 33: {
                return pSDevSlnSysDepInstBase.getSingleInstMode() == null;
            }
            case 34: {
                return pSDevSlnSysDepInstBase.getUpdateDate() == null;
            }
            case 35: {
                return pSDevSlnSysDepInstBase.getUpdateMan() == null;
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
        return PSDevSlnSysDepInstBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDepInstBase.isBackupFilePathDirty();
            }
            case 1: {
                return pSDevSlnSysDepInstBase.isBackupSizeDirty();
            }
            case 2: {
                return pSDevSlnSysDepInstBase.isBackupStateDirty();
            }
            case 3: {
                return pSDevSlnSysDepInstBase.isBackupTimeDirty();
            }
            case 4: {
                return pSDevSlnSysDepInstBase.isBeginBackupTimeDirty();
            }
            case 5: {
                return pSDevSlnSysDepInstBase.isCreateDateDirty();
            }
            case 6: {
                return pSDevSlnSysDepInstBase.isCreateManDirty();
            }
            case 7: {
                return pSDevSlnSysDepInstBase.isDepInstStateDirty();
            }
            case 8: {
                return pSDevSlnSysDepInstBase.isEndBackupTimeDirty();
            }
            case 9: {
                return pSDevSlnSysDepInstBase.isExpriedTimeDirty();
            }
            case 10: {
                return pSDevSlnSysDepInstBase.isInstPSDevCenterSVNIdDirty();
            }
            case 11: {
                return pSDevSlnSysDepInstBase.isInstPSDevCenterSVNNameDirty();
            }
            case 12: {
                return pSDevSlnSysDepInstBase.isInstTagDirty();
            }
            case 13: {
                return pSDevSlnSysDepInstBase.isInstTag2Dirty();
            }
            case 14: {
                return pSDevSlnSysDepInstBase.isInstTag3Dirty();
            }
            case 15: {
                return pSDevSlnSysDepInstBase.isInstTag4Dirty();
            }
            case 16: {
                return pSDevSlnSysDepInstBase.isInstVerDirty();
            }
            case 17: {
                return pSDevSlnSysDepInstBase.isLastCheckinTimeDirty();
            }
            case 18: {
                return pSDevSlnSysDepInstBase.isMemoDirty();
            }
            case 19: {
                return pSDevSlnSysDepInstBase.isModelPSDevCenterSVNIdDirty();
            }
            case 20: {
                return pSDevSlnSysDepInstBase.isModelPSDevCenterSVNNameDirty();
            }
            case 21: {
                return pSDevSlnSysDepInstBase.isModelVerDirty();
            }
            case 22: {
                return pSDevSlnSysDepInstBase.isPSDevCenterIdDirty();
            }
            case 23: {
                return pSDevSlnSysDepInstBase.isPSDevCenterNameDirty();
            }
            case 24: {
                return pSDevSlnSysDepInstBase.isPSDevSlnIdDirty();
            }
            case 25: {
                return pSDevSlnSysDepInstBase.isPSDevSlnSysDepInstIdDirty();
            }
            case 26: {
                return pSDevSlnSysDepInstBase.isPSDevSlnSysDepInstNameDirty();
            }
            case 27: {
                return pSDevSlnSysDepInstBase.isPSDevSlnSysIdDirty();
            }
            case 28: {
                return pSDevSlnSysDepInstBase.isPSDevSlnSysNameDirty();
            }
            case 29: {
                return pSDevSlnSysDepInstBase.isPSSysModelInstIdDirty();
            }
            case 30: {
                return pSDevSlnSysDepInstBase.isPSSysModelInstNameDirty();
            }
            case 31: {
                return pSDevSlnSysDepInstBase.isPSTaskServerIdDirty();
            }
            case 32: {
                return pSDevSlnSysDepInstBase.isPSTaskServerNameDirty();
            }
            case 33: {
                return pSDevSlnSysDepInstBase.isSingleInstModeDirty();
            }
            case 34: {
                return pSDevSlnSysDepInstBase.isUpdateDateDirty();
            }
            case 35: {
                return pSDevSlnSysDepInstBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysDepInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysDepInstBase.getBackupFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupfilepath", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getBackupFilePath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupsize", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getBackupSize()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupstate", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getBackupState()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backuptime", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getBeginBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginbackuptime", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getBeginBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getDepInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depinststate", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getDepInstState()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getEndBackupTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endbackuptime", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getEndBackupTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instpsdevcentersvnid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instpsdevcentersvnname", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag2", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag3", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag4", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getLastCheckinTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcheckintime", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getLastCheckinTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnname", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getModelVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdepinstid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdepinstname", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSSysModelInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstname", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSSysModelInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getSingleInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"singleinstmode", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getSingleInstMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDepInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysDepInstBase.getJSONValue((Object)pSDevSlnSysDepInstBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysDepInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysDepInstBase.getBackupFilePath() != null) {
            object = pSDevSlnSysDepInstBase.getBackupFilePath();
            xmlNode.setAttribute(FIELD_BACKUPFILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupSize() != null) {
            object = pSDevSlnSysDepInstBase.getBackupSize();
            xmlNode.setAttribute(FIELD_BACKUPSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupState() != null) {
            object = pSDevSlnSysDepInstBase.getBackupState();
            xmlNode.setAttribute(FIELD_BACKUPSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getBackupTime() != null) {
            object = pSDevSlnSysDepInstBase.getBackupTime();
            xmlNode.setAttribute(FIELD_BACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getBeginBackupTime() != null) {
            object = pSDevSlnSysDepInstBase.getBeginBackupTime();
            xmlNode.setAttribute(FIELD_BEGINBACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getCreateDate() != null) {
            object = pSDevSlnSysDepInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getCreateMan() != null) {
            object = pSDevSlnSysDepInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getDepInstState() != null) {
            object = pSDevSlnSysDepInstBase.getDepInstState();
            xmlNode.setAttribute(FIELD_DEPINSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getEndBackupTime() != null) {
            object = pSDevSlnSysDepInstBase.getEndBackupTime();
            xmlNode.setAttribute(FIELD_ENDBACKUPTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getExpriedTime() != null) {
            object = pSDevSlnSysDepInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId() != null) {
            object = pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_INSTPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName() != null) {
            object = pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_INSTPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag() != null) {
            object = pSDevSlnSysDepInstBase.getInstTag();
            xmlNode.setAttribute(FIELD_INSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag2() != null) {
            object = pSDevSlnSysDepInstBase.getInstTag2();
            xmlNode.setAttribute(FIELD_INSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag3() != null) {
            object = pSDevSlnSysDepInstBase.getInstTag3();
            xmlNode.setAttribute(FIELD_INSTTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstTag4() != null) {
            object = pSDevSlnSysDepInstBase.getInstTag4();
            xmlNode.setAttribute(FIELD_INSTTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getInstVer() != null) {
            object = pSDevSlnSysDepInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getLastCheckinTime() != null) {
            object = pSDevSlnSysDepInstBase.getLastCheckinTime();
            xmlNode.setAttribute(FIELD_LASTCHECKINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getMemo() != null) {
            object = pSDevSlnSysDepInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId() != null) {
            object = pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName() != null) {
            object = pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getModelVer() != null) {
            object = pSDevSlnSysDepInstBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDEPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDEPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysDepInstBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSSysModelInstId() != null) {
            object = pSDevSlnSysDepInstBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSSysModelInstName() != null) {
            object = pSDevSlnSysDepInstBase.getPSSysModelInstName();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSTaskServerId() != null) {
            object = pSDevSlnSysDepInstBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getPSTaskServerName() != null) {
            object = pSDevSlnSysDepInstBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDepInstBase.getSingleInstMode() != null) {
            object = pSDevSlnSysDepInstBase.getSingleInstMode();
            xmlNode.setAttribute(FIELD_SINGLEINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getUpdateDate() != null) {
            object = pSDevSlnSysDepInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDepInstBase.getUpdateMan() != null) {
            object = pSDevSlnSysDepInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysDepInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysDepInstBase.isBackupFilePathDirty() && (bl || pSDevSlnSysDepInstBase.getBackupFilePath() != null)) {
            iDataObject.set(FIELD_BACKUPFILEPATH, (Object)pSDevSlnSysDepInstBase.getBackupFilePath());
        }
        if (pSDevSlnSysDepInstBase.isBackupSizeDirty() && (bl || pSDevSlnSysDepInstBase.getBackupSize() != null)) {
            iDataObject.set(FIELD_BACKUPSIZE, (Object)pSDevSlnSysDepInstBase.getBackupSize());
        }
        if (pSDevSlnSysDepInstBase.isBackupStateDirty() && (bl || pSDevSlnSysDepInstBase.getBackupState() != null)) {
            iDataObject.set(FIELD_BACKUPSTATE, (Object)pSDevSlnSysDepInstBase.getBackupState());
        }
        if (pSDevSlnSysDepInstBase.isBackupTimeDirty() && (bl || pSDevSlnSysDepInstBase.getBackupTime() != null)) {
            iDataObject.set(FIELD_BACKUPTIME, (Object)pSDevSlnSysDepInstBase.getBackupTime());
        }
        if (pSDevSlnSysDepInstBase.isBeginBackupTimeDirty() && (bl || pSDevSlnSysDepInstBase.getBeginBackupTime() != null)) {
            iDataObject.set(FIELD_BEGINBACKUPTIME, (Object)pSDevSlnSysDepInstBase.getBeginBackupTime());
        }
        if (pSDevSlnSysDepInstBase.isCreateDateDirty() && (bl || pSDevSlnSysDepInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysDepInstBase.getCreateDate());
        }
        if (pSDevSlnSysDepInstBase.isCreateManDirty() && (bl || pSDevSlnSysDepInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysDepInstBase.getCreateMan());
        }
        if (pSDevSlnSysDepInstBase.isDepInstStateDirty() && (bl || pSDevSlnSysDepInstBase.getDepInstState() != null)) {
            iDataObject.set(FIELD_DEPINSTSTATE, (Object)pSDevSlnSysDepInstBase.getDepInstState());
        }
        if (pSDevSlnSysDepInstBase.isEndBackupTimeDirty() && (bl || pSDevSlnSysDepInstBase.getEndBackupTime() != null)) {
            iDataObject.set(FIELD_ENDBACKUPTIME, (Object)pSDevSlnSysDepInstBase.getEndBackupTime());
        }
        if (pSDevSlnSysDepInstBase.isExpriedTimeDirty() && (bl || pSDevSlnSysDepInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnSysDepInstBase.getExpriedTime());
        }
        if (pSDevSlnSysDepInstBase.isInstPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_INSTPSDEVCENTERSVNID, (Object)pSDevSlnSysDepInstBase.getInstPSDevCenterSVNId());
        }
        if (pSDevSlnSysDepInstBase.isInstPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_INSTPSDEVCENTERSVNNAME, (Object)pSDevSlnSysDepInstBase.getInstPSDevCenterSVNName());
        }
        if (pSDevSlnSysDepInstBase.isInstTagDirty() && (bl || pSDevSlnSysDepInstBase.getInstTag() != null)) {
            iDataObject.set(FIELD_INSTTAG, (Object)pSDevSlnSysDepInstBase.getInstTag());
        }
        if (pSDevSlnSysDepInstBase.isInstTag2Dirty() && (bl || pSDevSlnSysDepInstBase.getInstTag2() != null)) {
            iDataObject.set(FIELD_INSTTAG2, (Object)pSDevSlnSysDepInstBase.getInstTag2());
        }
        if (pSDevSlnSysDepInstBase.isInstTag3Dirty() && (bl || pSDevSlnSysDepInstBase.getInstTag3() != null)) {
            iDataObject.set(FIELD_INSTTAG3, (Object)pSDevSlnSysDepInstBase.getInstTag3());
        }
        if (pSDevSlnSysDepInstBase.isInstTag4Dirty() && (bl || pSDevSlnSysDepInstBase.getInstTag4() != null)) {
            iDataObject.set(FIELD_INSTTAG4, (Object)pSDevSlnSysDepInstBase.getInstTag4());
        }
        if (pSDevSlnSysDepInstBase.isInstVerDirty() && (bl || pSDevSlnSysDepInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDevSlnSysDepInstBase.getInstVer());
        }
        if (pSDevSlnSysDepInstBase.isLastCheckinTimeDirty() && (bl || pSDevSlnSysDepInstBase.getLastCheckinTime() != null)) {
            iDataObject.set(FIELD_LASTCHECKINTIME, (Object)pSDevSlnSysDepInstBase.getLastCheckinTime());
        }
        if (pSDevSlnSysDepInstBase.isMemoDirty() && (bl || pSDevSlnSysDepInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysDepInstBase.getMemo());
        }
        if (pSDevSlnSysDepInstBase.isModelPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNID, (Object)pSDevSlnSysDepInstBase.getModelPSDevCenterSVNId());
        }
        if (pSDevSlnSysDepInstBase.isModelPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNNAME, (Object)pSDevSlnSysDepInstBase.getModelPSDevCenterSVNName());
        }
        if (pSDevSlnSysDepInstBase.isModelVerDirty() && (bl || pSDevSlnSysDepInstBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSDevSlnSysDepInstBase.getModelVer());
        }
        if (pSDevSlnSysDepInstBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysDepInstBase.getPSDevCenterId());
        }
        if (pSDevSlnSysDepInstBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysDepInstBase.getPSDevCenterName());
        }
        if (pSDevSlnSysDepInstBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysDepInstBase.getPSDevSlnId());
        }
        if (pSDevSlnSysDepInstBase.isPSDevSlnSysDepInstIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDEPINSTID, (Object)pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstId());
        }
        if (pSDevSlnSysDepInstBase.isPSDevSlnSysDepInstNameDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDEPINSTNAME, (Object)pSDevSlnSysDepInstBase.getPSDevSlnSysDepInstName());
        }
        if (pSDevSlnSysDepInstBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysDepInstBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysDepInstBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysDepInstBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysDepInstBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysDepInstBase.isPSSysModelInstIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSDevSlnSysDepInstBase.getPSSysModelInstId());
        }
        if (pSDevSlnSysDepInstBase.isPSSysModelInstNameDirty() && (bl || pSDevSlnSysDepInstBase.getPSSysModelInstName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTNAME, (Object)pSDevSlnSysDepInstBase.getPSSysModelInstName());
        }
        if (pSDevSlnSysDepInstBase.isPSTaskServerIdDirty() && (bl || pSDevSlnSysDepInstBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevSlnSysDepInstBase.getPSTaskServerId());
        }
        if (pSDevSlnSysDepInstBase.isPSTaskServerNameDirty() && (bl || pSDevSlnSysDepInstBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevSlnSysDepInstBase.getPSTaskServerName());
        }
        if (pSDevSlnSysDepInstBase.isSingleInstModeDirty() && (bl || pSDevSlnSysDepInstBase.getSingleInstMode() != null)) {
            iDataObject.set(FIELD_SINGLEINSTMODE, (Object)pSDevSlnSysDepInstBase.getSingleInstMode());
        }
        if (pSDevSlnSysDepInstBase.isUpdateDateDirty() && (bl || pSDevSlnSysDepInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysDepInstBase.getUpdateDate());
        }
        if (pSDevSlnSysDepInstBase.isUpdateManDirty() && (bl || pSDevSlnSysDepInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysDepInstBase.getUpdateMan());
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
        return PSDevSlnSysDepInstBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysDepInstBase pSDevSlnSysDepInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDepInstBase.resetBackupFilePath();
                return true;
            }
            case 1: {
                pSDevSlnSysDepInstBase.resetBackupSize();
                return true;
            }
            case 2: {
                pSDevSlnSysDepInstBase.resetBackupState();
                return true;
            }
            case 3: {
                pSDevSlnSysDepInstBase.resetBackupTime();
                return true;
            }
            case 4: {
                pSDevSlnSysDepInstBase.resetBeginBackupTime();
                return true;
            }
            case 5: {
                pSDevSlnSysDepInstBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDevSlnSysDepInstBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDevSlnSysDepInstBase.resetDepInstState();
                return true;
            }
            case 8: {
                pSDevSlnSysDepInstBase.resetEndBackupTime();
                return true;
            }
            case 9: {
                pSDevSlnSysDepInstBase.resetExpriedTime();
                return true;
            }
            case 10: {
                pSDevSlnSysDepInstBase.resetInstPSDevCenterSVNId();
                return true;
            }
            case 11: {
                pSDevSlnSysDepInstBase.resetInstPSDevCenterSVNName();
                return true;
            }
            case 12: {
                pSDevSlnSysDepInstBase.resetInstTag();
                return true;
            }
            case 13: {
                pSDevSlnSysDepInstBase.resetInstTag2();
                return true;
            }
            case 14: {
                pSDevSlnSysDepInstBase.resetInstTag3();
                return true;
            }
            case 15: {
                pSDevSlnSysDepInstBase.resetInstTag4();
                return true;
            }
            case 16: {
                pSDevSlnSysDepInstBase.resetInstVer();
                return true;
            }
            case 17: {
                pSDevSlnSysDepInstBase.resetLastCheckinTime();
                return true;
            }
            case 18: {
                pSDevSlnSysDepInstBase.resetMemo();
                return true;
            }
            case 19: {
                pSDevSlnSysDepInstBase.resetModelPSDevCenterSVNId();
                return true;
            }
            case 20: {
                pSDevSlnSysDepInstBase.resetModelPSDevCenterSVNName();
                return true;
            }
            case 21: {
                pSDevSlnSysDepInstBase.resetModelVer();
                return true;
            }
            case 22: {
                pSDevSlnSysDepInstBase.resetPSDevCenterId();
                return true;
            }
            case 23: {
                pSDevSlnSysDepInstBase.resetPSDevCenterName();
                return true;
            }
            case 24: {
                pSDevSlnSysDepInstBase.resetPSDevSlnId();
                return true;
            }
            case 25: {
                pSDevSlnSysDepInstBase.resetPSDevSlnSysDepInstId();
                return true;
            }
            case 26: {
                pSDevSlnSysDepInstBase.resetPSDevSlnSysDepInstName();
                return true;
            }
            case 27: {
                pSDevSlnSysDepInstBase.resetPSDevSlnSysId();
                return true;
            }
            case 28: {
                pSDevSlnSysDepInstBase.resetPSDevSlnSysName();
                return true;
            }
            case 29: {
                pSDevSlnSysDepInstBase.resetPSSysModelInstId();
                return true;
            }
            case 30: {
                pSDevSlnSysDepInstBase.resetPSSysModelInstName();
                return true;
            }
            case 31: {
                pSDevSlnSysDepInstBase.resetPSTaskServerId();
                return true;
            }
            case 32: {
                pSDevSlnSysDepInstBase.resetPSTaskServerName();
                return true;
            }
            case 33: {
                pSDevSlnSysDepInstBase.resetSingleInstMode();
                return true;
            }
            case 34: {
                pSDevSlnSysDepInstBase.resetUpdateDate();
                return true;
            }
            case 35: {
                pSDevSlnSysDepInstBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getInstPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstPSDevCenterSVN();
        }
        if (this.getInstPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objInstPSDevCenterSVNLock;
        synchronized (n) {
            if (this.instpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getInstPSDevCenterSVNId(), (Object)this.instpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.instpsdevcentersvn = null;
            }
            if (this.instpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getInstPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.instpsdevcentersvn = pSDevCenterSVN;
            }
            return this.instpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getModelPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVN();
        }
        if (this.getModelPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objModelPSDevCenterSVNLock;
        synchronized (n) {
            if (this.modelpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getModelPSDevCenterSVNId(), (Object)this.modelpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.modelpsdevcentersvn = null;
            }
            if (this.modelpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getModelPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.modelpsdevcentersvn = pSDevCenterSVN;
            }
            return this.modelpsdevcentersvn;
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
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelInst getPSSysModelInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelInst();
        }
        if (this.getPSSysModelInstId() == null) {
            return null;
        }
        Integer n = this.objPSSysModelInstLock;
        synchronized (n) {
            if (this.pssysmodelinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysModelInstId(), (Object)this.pssysmodelinst.getPSSysModelInstId()) != 0L) {
                this.pssysmodelinst = null;
            }
            if (this.pssysmodelinst == null) {
                PSSysModelInst pSSysModelInst = new PSSysModelInst();
                pSSysModelInst.setPSSysModelInstId(this.getPSSysModelInstId());
                PSSysModelInstService pSSysModelInstService = (PSSysModelInstService)ServiceGlobal.getService(PSSysModelInstService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelInstService.autoGet((IEntity)pSSysModelInst);
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
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDevSlnSysDepInstBase getProxyEntity() {
        return this.proxyPSDevSlnSysDepInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysDepInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysDepInstBase) {
            this.proxyPSDevSlnSysDepInstBase = (PSDevSlnSysDepInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKUPFILEPATH, 0);
        fieldIndexMap.put(FIELD_BACKUPSIZE, 1);
        fieldIndexMap.put(FIELD_BACKUPSTATE, 2);
        fieldIndexMap.put(FIELD_BACKUPTIME, 3);
        fieldIndexMap.put(FIELD_BEGINBACKUPTIME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEPINSTSTATE, 7);
        fieldIndexMap.put(FIELD_ENDBACKUPTIME, 8);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 9);
        fieldIndexMap.put(FIELD_INSTPSDEVCENTERSVNID, 10);
        fieldIndexMap.put(FIELD_INSTPSDEVCENTERSVNNAME, 11);
        fieldIndexMap.put(FIELD_INSTTAG, 12);
        fieldIndexMap.put(FIELD_INSTTAG2, 13);
        fieldIndexMap.put(FIELD_INSTTAG3, 14);
        fieldIndexMap.put(FIELD_INSTTAG4, 15);
        fieldIndexMap.put(FIELD_INSTVER, 16);
        fieldIndexMap.put(FIELD_LASTCHECKINTIME, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNID, 19);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNNAME, 20);
        fieldIndexMap.put(FIELD_MODELVER, 21);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 22);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 23);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 24);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDEPINSTID, 25);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDEPINSTNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 27);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 29);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTNAME, 30);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 31);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 32);
        fieldIndexMap.put(FIELD_SINGLEINSTMODE, 33);
        fieldIndexMap.put(FIELD_UPDATEDATE, 34);
        fieldIndexMap.put(FIELD_UPDATEMAN, 35);
    }
}

