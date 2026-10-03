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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysSrc;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysModelSync;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysSrcService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysModelSyncService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysModelSyncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelSyncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURVER = "CURVER";
    public static final String FIELD_EXPANDFLAG = "EXPANDFLAG";
    public static final String FIELD_GROUPFLAG = "GROUPFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_PPSSYSMODELSYNCID = "PPSSYSMODELSYNCID";
    public static final String FIELD_PPSSYSMODELSYNCNAME = "PPSSYSMODELSYNCNAME";
    public static final String FIELD_PSDEVSLNSYSSRCID = "PSDEVSLNSYSSRCID";
    public static final String FIELD_PSDEVSLNSYSSRCNAME = "PSDEVSLNSYSSRCNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSYSMODELSYNCID = "PSSYSMODELSYNCID";
    public static final String FIELD_PSSYSMODELSYNCNAME = "PSSYSMODELSYNCNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SRCVER = "SRCVER";
    public static final String FIELD_SYNCFLAG = "SYNCFLAG";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURVER = 2;
    private static final int INDEX_EXPANDFLAG = 3;
    private static final int INDEX_GROUPFLAG = 4;
    private static final int INDEX_LOGICNAME = 5;
    private static final int INDEX_PPSSYSMODELSYNCID = 6;
    private static final int INDEX_PPSSYSMODELSYNCNAME = 7;
    private static final int INDEX_PSDEVSLNSYSSRCID = 8;
    private static final int INDEX_PSDEVSLNSYSSRCNAME = 9;
    private static final int INDEX_PSMODELID = 10;
    private static final int INDEX_PSMODELNAME = 11;
    private static final int INDEX_PSMODELTYPE = 12;
    private static final int INDEX_PSSYSMODELSYNCID = 13;
    private static final int INDEX_PSSYSMODELSYNCNAME = 14;
    private static final int INDEX_PSSYSTEMID = 15;
    private static final int INDEX_SRCVER = 16;
    private static final int INDEX_SYNCFLAG = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelSyncBase proxyPSSysModelSyncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curverDirtyFlag = false;
    private boolean expandflagDirtyFlag = false;
    private boolean groupflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean ppssysmodelsyncidDirtyFlag = false;
    private boolean ppssysmodelsyncnameDirtyFlag = false;
    private boolean psdevslnsyssrcidDirtyFlag = false;
    private boolean psdevslnsyssrcnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssysmodelsyncidDirtyFlag = false;
    private boolean pssysmodelsyncnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean srcverDirtyFlag = false;
    private boolean syncflagDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curver")
    private Integer curver;
    @Column(name="expandflag")
    private Integer expandflag;
    @Column(name="groupflag")
    private Integer groupflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="ppssysmodelsyncid")
    private String ppssysmodelsyncid;
    @Column(name="ppssysmodelsyncname")
    private String ppssysmodelsyncname;
    @Column(name="psdevslnsyssrcid")
    private String psdevslnsyssrcid;
    @Column(name="psdevslnsyssrcname")
    private String psdevslnsyssrcname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssysmodelsyncid")
    private String pssysmodelsyncid;
    @Column(name="pssysmodelsyncname")
    private String pssysmodelsyncname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="srcver")
    private Integer srcver;
    @Column(name="syncflag")
    private Integer syncflag;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnSysSrcLock = new Integer(1);
    private PSDevSlnSysSrc psdevslnsyssrc = null;
    private Integer objPPSysModelSyncLock = new Integer(1);
    private PSSysModelSync ppsysmodelsync = null;

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

    public void setCurVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurVer(n);
            return;
        }
        this.curver = n;
        this.curverDirtyFlag = true;
    }

    public Integer getCurVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurVer();
        }
        return this.curver;
    }

    public boolean isCurVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurVerDirty();
        }
        return this.curverDirtyFlag;
    }

    public void resetCurVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurVer();
            return;
        }
        this.curverDirtyFlag = false;
        this.curver = null;
    }

    public void setExpandFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpandFlag(n);
            return;
        }
        this.expandflag = n;
        this.expandflagDirtyFlag = true;
    }

    public Integer getExpandFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpandFlag();
        }
        return this.expandflag;
    }

    public boolean isExpandFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpandFlagDirty();
        }
        return this.expandflagDirtyFlag;
    }

    public void resetExpandFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpandFlag();
            return;
        }
        this.expandflagDirtyFlag = false;
        this.expandflag = null;
    }

    public void setGroupFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupFlag(n);
            return;
        }
        this.groupflag = n;
        this.groupflagDirtyFlag = true;
    }

    public Integer getGroupFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupFlag();
        }
        return this.groupflag;
    }

    public boolean isGroupFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupFlagDirty();
        }
        return this.groupflagDirtyFlag;
    }

    public void resetGroupFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupFlag();
            return;
        }
        this.groupflagDirtyFlag = false;
        this.groupflag = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setPPSSysModelSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysModelSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysmodelsyncid = string;
        this.ppssysmodelsyncidDirtyFlag = true;
    }

    public String getPPSSysModelSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysModelSyncId();
        }
        return this.ppssysmodelsyncid;
    }

    public boolean isPPSSysModelSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysModelSyncIdDirty();
        }
        return this.ppssysmodelsyncidDirtyFlag;
    }

    public void resetPPSSysModelSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysModelSyncId();
            return;
        }
        this.ppssysmodelsyncidDirtyFlag = false;
        this.ppssysmodelsyncid = null;
    }

    public void setPPSSysModelSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysModelSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysmodelsyncname = string;
        this.ppssysmodelsyncnameDirtyFlag = true;
    }

    public String getPPSSysModelSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysModelSyncName();
        }
        return this.ppssysmodelsyncname;
    }

    public boolean isPPSSysModelSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysModelSyncNameDirty();
        }
        return this.ppssysmodelsyncnameDirtyFlag;
    }

    public void resetPPSSysModelSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysModelSyncName();
            return;
        }
        this.ppssysmodelsyncnameDirtyFlag = false;
        this.ppssysmodelsyncname = null;
    }

    public void setPSDevSlnSysSrcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrcid = string;
        this.psdevslnsyssrcidDirtyFlag = true;
    }

    public String getPSDevSlnSysSrcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrcId();
        }
        return this.psdevslnsyssrcid;
    }

    public boolean isPSDevSlnSysSrcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrcIdDirty();
        }
        return this.psdevslnsyssrcidDirtyFlag;
    }

    public void resetPSDevSlnSysSrcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrcId();
            return;
        }
        this.psdevslnsyssrcidDirtyFlag = false;
        this.psdevslnsyssrcid = null;
    }

    public void setPSDevSlnSysSrcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysSrcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyssrcname = string;
        this.psdevslnsyssrcnameDirtyFlag = true;
    }

    public String getPSDevSlnSysSrcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrcName();
        }
        return this.psdevslnsyssrcname;
    }

    public boolean isPSDevSlnSysSrcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysSrcNameDirty();
        }
        return this.psdevslnsyssrcnameDirtyFlag;
    }

    public void resetPSDevSlnSysSrcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysSrcName();
            return;
        }
        this.psdevslnsyssrcnameDirtyFlag = false;
        this.psdevslnsyssrcname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSSysModelSyncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelSyncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelsyncid = string;
        this.pssysmodelsyncidDirtyFlag = true;
    }

    public String getPSSysModelSyncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelSyncId();
        }
        return this.pssysmodelsyncid;
    }

    public boolean isPSSysModelSyncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelSyncIdDirty();
        }
        return this.pssysmodelsyncidDirtyFlag;
    }

    public void resetPSSysModelSyncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelSyncId();
            return;
        }
        this.pssysmodelsyncidDirtyFlag = false;
        this.pssysmodelsyncid = null;
    }

    public void setPSSysModelSyncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelSyncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelsyncname = string;
        this.pssysmodelsyncnameDirtyFlag = true;
    }

    public String getPSSysModelSyncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelSyncName();
        }
        return this.pssysmodelsyncname;
    }

    public boolean isPSSysModelSyncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelSyncNameDirty();
        }
        return this.pssysmodelsyncnameDirtyFlag;
    }

    public void resetPSSysModelSyncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelSyncName();
            return;
        }
        this.pssysmodelsyncnameDirtyFlag = false;
        this.pssysmodelsyncname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setSrcVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcVer(n);
            return;
        }
        this.srcver = n;
        this.srcverDirtyFlag = true;
    }

    public Integer getSrcVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcVer();
        }
        return this.srcver;
    }

    public boolean isSrcVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcVerDirty();
        }
        return this.srcverDirtyFlag;
    }

    public void resetSrcVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcVer();
            return;
        }
        this.srcverDirtyFlag = false;
        this.srcver = null;
    }

    public void setSyncFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSyncFlag(n);
            return;
        }
        this.syncflag = n;
        this.syncflagDirtyFlag = true;
    }

    public Integer getSyncFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSyncFlag();
        }
        return this.syncflag;
    }

    public boolean isSyncFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSyncFlagDirty();
        }
        return this.syncflagDirtyFlag;
    }

    public void resetSyncFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSyncFlag();
            return;
        }
        this.syncflagDirtyFlag = false;
        this.syncflag = null;
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
        PSSysModelSyncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelSyncBase pSSysModelSyncBase) {
        pSSysModelSyncBase.resetCreateDate();
        pSSysModelSyncBase.resetCreateMan();
        pSSysModelSyncBase.resetCurVer();
        pSSysModelSyncBase.resetExpandFlag();
        pSSysModelSyncBase.resetGroupFlag();
        pSSysModelSyncBase.resetLogicName();
        pSSysModelSyncBase.resetPPSSysModelSyncId();
        pSSysModelSyncBase.resetPPSSysModelSyncName();
        pSSysModelSyncBase.resetPSDevSlnSysSrcId();
        pSSysModelSyncBase.resetPSDevSlnSysSrcName();
        pSSysModelSyncBase.resetPSModelId();
        pSSysModelSyncBase.resetPSModelName();
        pSSysModelSyncBase.resetPSModelType();
        pSSysModelSyncBase.resetPSSysModelSyncId();
        pSSysModelSyncBase.resetPSSysModelSyncName();
        pSSysModelSyncBase.resetPSSystemId();
        pSSysModelSyncBase.resetSrcVer();
        pSSysModelSyncBase.resetSyncFlag();
        pSSysModelSyncBase.resetUpdateDate();
        pSSysModelSyncBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurVerDirty()) {
            hashMap.put(FIELD_CURVER, this.getCurVer());
        }
        if (!bl || this.isExpandFlagDirty()) {
            hashMap.put(FIELD_EXPANDFLAG, this.getExpandFlag());
        }
        if (!bl || this.isGroupFlagDirty()) {
            hashMap.put(FIELD_GROUPFLAG, this.getGroupFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isPPSSysModelSyncIdDirty()) {
            hashMap.put(FIELD_PPSSYSMODELSYNCID, this.getPPSSysModelSyncId());
        }
        if (!bl || this.isPPSSysModelSyncNameDirty()) {
            hashMap.put(FIELD_PPSSYSMODELSYNCNAME, this.getPPSSysModelSyncName());
        }
        if (!bl || this.isPSDevSlnSysSrcIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRCID, this.getPSDevSlnSysSrcId());
        }
        if (!bl || this.isPSDevSlnSysSrcNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSSRCNAME, this.getPSDevSlnSysSrcName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSysModelSyncIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELSYNCID, this.getPSSysModelSyncId());
        }
        if (!bl || this.isPSSysModelSyncNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELSYNCNAME, this.getPSSysModelSyncName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isSrcVerDirty()) {
            hashMap.put(FIELD_SRCVER, this.getSrcVer());
        }
        if (!bl || this.isSyncFlagDirty()) {
            hashMap.put(FIELD_SYNCFLAG, this.getSyncFlag());
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
        return PSSysModelSyncBase.get(this, n);
    }

    private static Object get(PSSysModelSyncBase pSSysModelSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelSyncBase.getCreateDate();
            }
            case 1: {
                return pSSysModelSyncBase.getCreateMan();
            }
            case 2: {
                return pSSysModelSyncBase.getCurVer();
            }
            case 3: {
                return pSSysModelSyncBase.getExpandFlag();
            }
            case 4: {
                return pSSysModelSyncBase.getGroupFlag();
            }
            case 5: {
                return pSSysModelSyncBase.getLogicName();
            }
            case 6: {
                return pSSysModelSyncBase.getPPSSysModelSyncId();
            }
            case 7: {
                return pSSysModelSyncBase.getPPSSysModelSyncName();
            }
            case 8: {
                return pSSysModelSyncBase.getPSDevSlnSysSrcId();
            }
            case 9: {
                return pSSysModelSyncBase.getPSDevSlnSysSrcName();
            }
            case 10: {
                return pSSysModelSyncBase.getPSModelId();
            }
            case 11: {
                return pSSysModelSyncBase.getPSModelName();
            }
            case 12: {
                return pSSysModelSyncBase.getPSModelType();
            }
            case 13: {
                return pSSysModelSyncBase.getPSSysModelSyncId();
            }
            case 14: {
                return pSSysModelSyncBase.getPSSysModelSyncName();
            }
            case 15: {
                return pSSysModelSyncBase.getPSSystemId();
            }
            case 16: {
                return pSSysModelSyncBase.getSrcVer();
            }
            case 17: {
                return pSSysModelSyncBase.getSyncFlag();
            }
            case 18: {
                return pSSysModelSyncBase.getUpdateDate();
            }
            case 19: {
                return pSSysModelSyncBase.getUpdateMan();
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
        PSSysModelSyncBase.set(this, n, object);
    }

    private static void set(PSSysModelSyncBase pSSysModelSyncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelSyncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelSyncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelSyncBase.setCurVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelSyncBase.setExpandFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelSyncBase.setGroupFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelSyncBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelSyncBase.setPPSSysModelSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelSyncBase.setPPSSysModelSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelSyncBase.setPSDevSlnSysSrcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelSyncBase.setPSDevSlnSysSrcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelSyncBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelSyncBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelSyncBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelSyncBase.setPSSysModelSyncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelSyncBase.setPSSysModelSyncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelSyncBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysModelSyncBase.setSrcVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysModelSyncBase.setSyncFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysModelSyncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSSysModelSyncBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelSyncBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelSyncBase pSSysModelSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelSyncBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysModelSyncBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysModelSyncBase.getCurVer() == null;
            }
            case 3: {
                return pSSysModelSyncBase.getExpandFlag() == null;
            }
            case 4: {
                return pSSysModelSyncBase.getGroupFlag() == null;
            }
            case 5: {
                return pSSysModelSyncBase.getLogicName() == null;
            }
            case 6: {
                return pSSysModelSyncBase.getPPSSysModelSyncId() == null;
            }
            case 7: {
                return pSSysModelSyncBase.getPPSSysModelSyncName() == null;
            }
            case 8: {
                return pSSysModelSyncBase.getPSDevSlnSysSrcId() == null;
            }
            case 9: {
                return pSSysModelSyncBase.getPSDevSlnSysSrcName() == null;
            }
            case 10: {
                return pSSysModelSyncBase.getPSModelId() == null;
            }
            case 11: {
                return pSSysModelSyncBase.getPSModelName() == null;
            }
            case 12: {
                return pSSysModelSyncBase.getPSModelType() == null;
            }
            case 13: {
                return pSSysModelSyncBase.getPSSysModelSyncId() == null;
            }
            case 14: {
                return pSSysModelSyncBase.getPSSysModelSyncName() == null;
            }
            case 15: {
                return pSSysModelSyncBase.getPSSystemId() == null;
            }
            case 16: {
                return pSSysModelSyncBase.getSrcVer() == null;
            }
            case 17: {
                return pSSysModelSyncBase.getSyncFlag() == null;
            }
            case 18: {
                return pSSysModelSyncBase.getUpdateDate() == null;
            }
            case 19: {
                return pSSysModelSyncBase.getUpdateMan() == null;
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
        return PSSysModelSyncBase.contains(this, n);
    }

    private static boolean contains(PSSysModelSyncBase pSSysModelSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelSyncBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysModelSyncBase.isCreateManDirty();
            }
            case 2: {
                return pSSysModelSyncBase.isCurVerDirty();
            }
            case 3: {
                return pSSysModelSyncBase.isExpandFlagDirty();
            }
            case 4: {
                return pSSysModelSyncBase.isGroupFlagDirty();
            }
            case 5: {
                return pSSysModelSyncBase.isLogicNameDirty();
            }
            case 6: {
                return pSSysModelSyncBase.isPPSSysModelSyncIdDirty();
            }
            case 7: {
                return pSSysModelSyncBase.isPPSSysModelSyncNameDirty();
            }
            case 8: {
                return pSSysModelSyncBase.isPSDevSlnSysSrcIdDirty();
            }
            case 9: {
                return pSSysModelSyncBase.isPSDevSlnSysSrcNameDirty();
            }
            case 10: {
                return pSSysModelSyncBase.isPSModelIdDirty();
            }
            case 11: {
                return pSSysModelSyncBase.isPSModelNameDirty();
            }
            case 12: {
                return pSSysModelSyncBase.isPSModelTypeDirty();
            }
            case 13: {
                return pSSysModelSyncBase.isPSSysModelSyncIdDirty();
            }
            case 14: {
                return pSSysModelSyncBase.isPSSysModelSyncNameDirty();
            }
            case 15: {
                return pSSysModelSyncBase.isPSSystemIdDirty();
            }
            case 16: {
                return pSSysModelSyncBase.isSrcVerDirty();
            }
            case 17: {
                return pSSysModelSyncBase.isSyncFlagDirty();
            }
            case 18: {
                return pSSysModelSyncBase.isUpdateDateDirty();
            }
            case 19: {
                return pSSysModelSyncBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelSyncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelSyncBase pSSysModelSyncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelSyncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getCurVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curver", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getCurVer()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getExpandFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expandflag", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getExpandFlag()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getGroupFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupflag", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getGroupFlag()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPPSSysModelSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysmodelsyncid", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPPSSysModelSyncId()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPPSSysModelSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysmodelsyncname", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPPSSysModelSyncName()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSDevSlnSysSrcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrcid", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSDevSlnSysSrcId()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSDevSlnSysSrcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyssrcname", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSDevSlnSysSrcName()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSSysModelSyncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelsyncid", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSSysModelSyncId()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSSysModelSyncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelsyncname", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSSysModelSyncName()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getSrcVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcver", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getSrcVer()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getSyncFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"syncflag", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getSyncFlag()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelSyncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelSyncBase.getJSONValue((Object)pSSysModelSyncBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelSyncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelSyncBase pSSysModelSyncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelSyncBase.getCreateDate() != null) {
            object = pSSysModelSyncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getCreateMan() != null) {
            object = pSSysModelSyncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getCurVer() != null) {
            object = pSSysModelSyncBase.getCurVer();
            xmlNode.setAttribute(FIELD_CURVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getExpandFlag() != null) {
            object = pSSysModelSyncBase.getExpandFlag();
            xmlNode.setAttribute(FIELD_EXPANDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getGroupFlag() != null) {
            object = pSSysModelSyncBase.getGroupFlag();
            xmlNode.setAttribute(FIELD_GROUPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getLogicName() != null) {
            object = pSSysModelSyncBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPPSSysModelSyncId() != null) {
            object = pSSysModelSyncBase.getPPSSysModelSyncId();
            xmlNode.setAttribute(FIELD_PPSSYSMODELSYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPPSSysModelSyncName() != null) {
            object = pSSysModelSyncBase.getPPSSysModelSyncName();
            xmlNode.setAttribute(FIELD_PPSSYSMODELSYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSDevSlnSysSrcId() != null) {
            object = pSSysModelSyncBase.getPSDevSlnSysSrcId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSDevSlnSysSrcName() != null) {
            object = pSSysModelSyncBase.getPSDevSlnSysSrcName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSSRCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSModelId() != null) {
            object = pSSysModelSyncBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSModelName() != null) {
            object = pSSysModelSyncBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSModelType() != null) {
            object = pSSysModelSyncBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSSysModelSyncId() != null) {
            object = pSSysModelSyncBase.getPSSysModelSyncId();
            xmlNode.setAttribute(FIELD_PSSYSMODELSYNCID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSSysModelSyncName() != null) {
            object = pSSysModelSyncBase.getPSSysModelSyncName();
            xmlNode.setAttribute(FIELD_PSSYSMODELSYNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getPSSystemId() != null) {
            object = pSSysModelSyncBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelSyncBase.getSrcVer() != null) {
            object = pSSysModelSyncBase.getSrcVer();
            xmlNode.setAttribute(FIELD_SRCVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getSyncFlag() != null) {
            object = pSSysModelSyncBase.getSyncFlag();
            xmlNode.setAttribute(FIELD_SYNCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getUpdateDate() != null) {
            object = pSSysModelSyncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelSyncBase.getUpdateMan() != null) {
            object = pSSysModelSyncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelSyncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelSyncBase pSSysModelSyncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelSyncBase.isCreateDateDirty() && (bl || pSSysModelSyncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelSyncBase.getCreateDate());
        }
        if (pSSysModelSyncBase.isCreateManDirty() && (bl || pSSysModelSyncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelSyncBase.getCreateMan());
        }
        if (pSSysModelSyncBase.isCurVerDirty() && (bl || pSSysModelSyncBase.getCurVer() != null)) {
            iDataObject.set(FIELD_CURVER, (Object)pSSysModelSyncBase.getCurVer());
        }
        if (pSSysModelSyncBase.isExpandFlagDirty() && (bl || pSSysModelSyncBase.getExpandFlag() != null)) {
            iDataObject.set(FIELD_EXPANDFLAG, (Object)pSSysModelSyncBase.getExpandFlag());
        }
        if (pSSysModelSyncBase.isGroupFlagDirty() && (bl || pSSysModelSyncBase.getGroupFlag() != null)) {
            iDataObject.set(FIELD_GROUPFLAG, (Object)pSSysModelSyncBase.getGroupFlag());
        }
        if (pSSysModelSyncBase.isLogicNameDirty() && (bl || pSSysModelSyncBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSysModelSyncBase.getLogicName());
        }
        if (pSSysModelSyncBase.isPPSSysModelSyncIdDirty() && (bl || pSSysModelSyncBase.getPPSSysModelSyncId() != null)) {
            iDataObject.set(FIELD_PPSSYSMODELSYNCID, (Object)pSSysModelSyncBase.getPPSSysModelSyncId());
        }
        if (pSSysModelSyncBase.isPPSSysModelSyncNameDirty() && (bl || pSSysModelSyncBase.getPPSSysModelSyncName() != null)) {
            iDataObject.set(FIELD_PPSSYSMODELSYNCNAME, (Object)pSSysModelSyncBase.getPPSSysModelSyncName());
        }
        if (pSSysModelSyncBase.isPSDevSlnSysSrcIdDirty() && (bl || pSSysModelSyncBase.getPSDevSlnSysSrcId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRCID, (Object)pSSysModelSyncBase.getPSDevSlnSysSrcId());
        }
        if (pSSysModelSyncBase.isPSDevSlnSysSrcNameDirty() && (bl || pSSysModelSyncBase.getPSDevSlnSysSrcName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSSRCNAME, (Object)pSSysModelSyncBase.getPSDevSlnSysSrcName());
        }
        if (pSSysModelSyncBase.isPSModelIdDirty() && (bl || pSSysModelSyncBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSSysModelSyncBase.getPSModelId());
        }
        if (pSSysModelSyncBase.isPSModelNameDirty() && (bl || pSSysModelSyncBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSSysModelSyncBase.getPSModelName());
        }
        if (pSSysModelSyncBase.isPSModelTypeDirty() && (bl || pSSysModelSyncBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSSysModelSyncBase.getPSModelType());
        }
        if (pSSysModelSyncBase.isPSSysModelSyncIdDirty() && (bl || pSSysModelSyncBase.getPSSysModelSyncId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELSYNCID, (Object)pSSysModelSyncBase.getPSSysModelSyncId());
        }
        if (pSSysModelSyncBase.isPSSysModelSyncNameDirty() && (bl || pSSysModelSyncBase.getPSSysModelSyncName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELSYNCNAME, (Object)pSSysModelSyncBase.getPSSysModelSyncName());
        }
        if (pSSysModelSyncBase.isPSSystemIdDirty() && (bl || pSSysModelSyncBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysModelSyncBase.getPSSystemId());
        }
        if (pSSysModelSyncBase.isSrcVerDirty() && (bl || pSSysModelSyncBase.getSrcVer() != null)) {
            iDataObject.set(FIELD_SRCVER, (Object)pSSysModelSyncBase.getSrcVer());
        }
        if (pSSysModelSyncBase.isSyncFlagDirty() && (bl || pSSysModelSyncBase.getSyncFlag() != null)) {
            iDataObject.set(FIELD_SYNCFLAG, (Object)pSSysModelSyncBase.getSyncFlag());
        }
        if (pSSysModelSyncBase.isUpdateDateDirty() && (bl || pSSysModelSyncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelSyncBase.getUpdateDate());
        }
        if (pSSysModelSyncBase.isUpdateManDirty() && (bl || pSSysModelSyncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelSyncBase.getUpdateMan());
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
        return PSSysModelSyncBase.remove(this, n);
    }

    private static boolean remove(PSSysModelSyncBase pSSysModelSyncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelSyncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysModelSyncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysModelSyncBase.resetCurVer();
                return true;
            }
            case 3: {
                pSSysModelSyncBase.resetExpandFlag();
                return true;
            }
            case 4: {
                pSSysModelSyncBase.resetGroupFlag();
                return true;
            }
            case 5: {
                pSSysModelSyncBase.resetLogicName();
                return true;
            }
            case 6: {
                pSSysModelSyncBase.resetPPSSysModelSyncId();
                return true;
            }
            case 7: {
                pSSysModelSyncBase.resetPPSSysModelSyncName();
                return true;
            }
            case 8: {
                pSSysModelSyncBase.resetPSDevSlnSysSrcId();
                return true;
            }
            case 9: {
                pSSysModelSyncBase.resetPSDevSlnSysSrcName();
                return true;
            }
            case 10: {
                pSSysModelSyncBase.resetPSModelId();
                return true;
            }
            case 11: {
                pSSysModelSyncBase.resetPSModelName();
                return true;
            }
            case 12: {
                pSSysModelSyncBase.resetPSModelType();
                return true;
            }
            case 13: {
                pSSysModelSyncBase.resetPSSysModelSyncId();
                return true;
            }
            case 14: {
                pSSysModelSyncBase.resetPSSysModelSyncName();
                return true;
            }
            case 15: {
                pSSysModelSyncBase.resetPSSystemId();
                return true;
            }
            case 16: {
                pSSysModelSyncBase.resetSrcVer();
                return true;
            }
            case 17: {
                pSSysModelSyncBase.resetSyncFlag();
                return true;
            }
            case 18: {
                pSSysModelSyncBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSSysModelSyncBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysSrc getPSDevSlnSysSrc() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysSrc();
        }
        if (this.getPSDevSlnSysSrcId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysSrcLock;
        synchronized (n) {
            if (this.psdevslnsyssrc != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysSrcId(), (Object)this.psdevslnsyssrc.getPSDevSlnSysSrcId()) != 0L) {
                this.psdevslnsyssrc = null;
            }
            if (this.psdevslnsyssrc == null) {
                PSDevSlnSysSrc pSDevSlnSysSrc = new PSDevSlnSysSrc();
                pSDevSlnSysSrc.setPSDevSlnSysSrcId(this.getPSDevSlnSysSrcId());
                PSDevSlnSysSrcService pSDevSlnSysSrcService = (PSDevSlnSysSrcService)ServiceGlobal.getService(PSDevSlnSysSrcService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysSrcService.autoGet(pSDevSlnSysSrc);
                this.psdevslnsyssrc = pSDevSlnSysSrc;
            }
            return this.psdevslnsyssrc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysModelSync getPPSysModelSync() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSysModelSync();
        }
        if (this.getPPSSysModelSyncId() == null) {
            return null;
        }
        Integer n = this.objPPSysModelSyncLock;
        synchronized (n) {
            if (this.ppsysmodelsync != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysModelSyncId(), (Object)this.ppsysmodelsync.getPSSysModelSyncId()) != 0L) {
                this.ppsysmodelsync = null;
            }
            if (this.ppsysmodelsync == null) {
                PSSysModelSync pSSysModelSync = new PSSysModelSync();
                pSSysModelSync.setPSSysModelSyncId(this.getPPSSysModelSyncId());
                PSSysModelSyncService pSSysModelSyncService = (PSSysModelSyncService)ServiceGlobal.getService(PSSysModelSyncService.class, (SessionFactory)this.getSessionFactory());
                pSSysModelSyncService.autoGet(pSSysModelSync);
                this.ppsysmodelsync = pSSysModelSync;
            }
            return this.ppsysmodelsync;
        }
    }

    private PSSysModelSyncBase getProxyEntity() {
        return this.proxyPSSysModelSyncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelSyncBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelSyncBase) {
            this.proxyPSSysModelSyncBase = (PSSysModelSyncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysModelSyncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURVER, 2);
        fieldIndexMap.put(FIELD_EXPANDFLAG, 3);
        fieldIndexMap.put(FIELD_GROUPFLAG, 4);
        fieldIndexMap.put(FIELD_LOGICNAME, 5);
        fieldIndexMap.put(FIELD_PPSSYSMODELSYNCID, 6);
        fieldIndexMap.put(FIELD_PPSSYSMODELSYNCNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRCID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSSRCNAME, 9);
        fieldIndexMap.put(FIELD_PSMODELID, 10);
        fieldIndexMap.put(FIELD_PSMODELNAME, 11);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 12);
        fieldIndexMap.put(FIELD_PSSYSMODELSYNCID, 13);
        fieldIndexMap.put(FIELD_PSSYSMODELSYNCNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 15);
        fieldIndexMap.put(FIELD_SRCVER, 16);
        fieldIndexMap.put(FIELD_SYNCFLAG, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

