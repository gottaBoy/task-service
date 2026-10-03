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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCCluster;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCContainerSpec;
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCClusterService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCContainerSpecService;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSMQInst;
import net.ibizsys.pscore.srv.paasmgr.service.PSMQInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterMQBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterMQBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_LOCKMODE = "LOCKMODE";
    public static final String FIELD_LOCKOBJID = "LOCKOBJID";
    public static final String FIELD_LOCKOBJTYPE = "LOCKOBJTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MQTYPE = "MQTYPE";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERMQID = "PSDEVCENTERMQID";
    public static final String FIELD_PSDEVCENTERMQNAME = "PSDEVCENTERMQNAME";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSMQINSTID = "PSMQINSTID";
    public static final String FIELD_PSMQINSTNAME = "PSMQINSTNAME";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_EXPRIEDTIME = 2;
    private static final int INDEX_LOCKMODE = 3;
    private static final int INDEX_LOCKOBJID = 4;
    private static final int INDEX_LOCKOBJTYPE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MQTYPE = 7;
    private static final int INDEX_PSDCCLUSTERID = 8;
    private static final int INDEX_PSDCCLUSTERNAME = 9;
    private static final int INDEX_PSDCCONTAINERSPECID = 10;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 11;
    private static final int INDEX_PSDCFILEID = 12;
    private static final int INDEX_PSDCFILENAME = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERMQID = 15;
    private static final int INDEX_PSDEVCENTERMQNAME = 16;
    private static final int INDEX_PSDEVCENTERNAME = 17;
    private static final int INDEX_PSMQINSTID = 18;
    private static final int INDEX_PSMQINSTNAME = 19;
    private static final int INDEX_RESPOS = 20;
    private static final int INDEX_RESREADYTIME = 21;
    private static final int INDEX_RESSTATE = 22;
    private static final int INDEX_RESVER = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final int INDEX_USAGEMODE = 26;
    private static final int INDEX_USERPARAMS = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterMQBase proxyPSDevCenterMQBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean lockmodeDirtyFlag = false;
    private boolean lockobjidDirtyFlag = false;
    private boolean lockobjtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mqtypeDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcentermqidDirtyFlag = false;
    private boolean psdevcentermqnameDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psmqinstidDirtyFlag = false;
    private boolean psmqinstnameDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="lockmode")
    private Integer lockmode;
    @Column(name="lockobjid")
    private String lockobjid;
    @Column(name="lockobjtype")
    private String lockobjtype;
    @Column(name="memo")
    private String memo;
    @Column(name="mqtype")
    private String mqtype;
    @Column(name="psdcclusterid")
    private String psdcclusterid;
    @Column(name="psdcclustername")
    private String psdcclustername;
    @Column(name="psdccontainerspecid")
    private String psdccontainerspecid;
    @Column(name="psdccontainerspecname")
    private String psdccontainerspecname;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentermqid")
    private String psdevcentermqid;
    @Column(name="psdevcentermqname")
    private String psdevcentermqname;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psmqinstid")
    private String psmqinstid;
    @Column(name="psmqinstname")
    private String psmqinstname;
    @Column(name="respos")
    private Integer respos;
    @Column(name="resreadytime")
    private Timestamp resreadytime;
    @Column(name="resstate")
    private Integer resstate;
    @Column(name="resver")
    private Integer resver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="userparams")
    private String userparams;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSMQInstLock = new Integer(1);
    private PSMQInst psmqinst = null;

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

    public void setLockMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockMode(n);
            return;
        }
        this.lockmode = n;
        this.lockmodeDirtyFlag = true;
    }

    public Integer getLockMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockMode();
        }
        return this.lockmode;
    }

    public boolean isLockModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockModeDirty();
        }
        return this.lockmodeDirtyFlag;
    }

    public void resetLockMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockMode();
            return;
        }
        this.lockmodeDirtyFlag = false;
        this.lockmode = null;
    }

    public void setLockObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjid = string;
        this.lockobjidDirtyFlag = true;
    }

    public String getLockObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjId();
        }
        return this.lockobjid;
    }

    public boolean isLockObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjIdDirty();
        }
        return this.lockobjidDirtyFlag;
    }

    public void resetLockObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjId();
            return;
        }
        this.lockobjidDirtyFlag = false;
        this.lockobjid = null;
    }

    public void setLockObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lockobjtype = string;
        this.lockobjtypeDirtyFlag = true;
    }

    public String getLockObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockObjType();
        }
        return this.lockobjtype;
    }

    public boolean isLockObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockObjTypeDirty();
        }
        return this.lockobjtypeDirtyFlag;
    }

    public void resetLockObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockObjType();
            return;
        }
        this.lockobjtypeDirtyFlag = false;
        this.lockobjtype = null;
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

    public void setMQType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMQType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mqtype = string;
        this.mqtypeDirtyFlag = true;
    }

    public String getMQType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMQType();
        }
        return this.mqtype;
    }

    public boolean isMQTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMQTypeDirty();
        }
        return this.mqtypeDirtyFlag;
    }

    public void resetMQType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMQType();
            return;
        }
        this.mqtypeDirtyFlag = false;
        this.mqtype = null;
    }

    public void setPSDCClusterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclusterid = string;
        this.psdcclusteridDirtyFlag = true;
    }

    public String getPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterId();
        }
        return this.psdcclusterid;
    }

    public boolean isPSDCClusterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterIdDirty();
        }
        return this.psdcclusteridDirtyFlag;
    }

    public void resetPSDCClusterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterId();
            return;
        }
        this.psdcclusteridDirtyFlag = false;
        this.psdcclusterid = null;
    }

    public void setPSDCClusterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCClusterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcclustername = string;
        this.psdcclusternameDirtyFlag = true;
    }

    public String getPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCClusterName();
        }
        return this.psdcclustername;
    }

    public boolean isPSDCClusterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCClusterNameDirty();
        }
        return this.psdcclusternameDirtyFlag;
    }

    public void resetPSDCClusterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCClusterName();
            return;
        }
        this.psdcclusternameDirtyFlag = false;
        this.psdcclustername = null;
    }

    public void setPSDCContainerSpecId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecid = string;
        this.psdccontainerspecidDirtyFlag = true;
    }

    public String getPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecId();
        }
        return this.psdccontainerspecid;
    }

    public boolean isPSDCContainerSpecIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecIdDirty();
        }
        return this.psdccontainerspecidDirtyFlag;
    }

    public void resetPSDCContainerSpecId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecId();
            return;
        }
        this.psdccontainerspecidDirtyFlag = false;
        this.psdccontainerspecid = null;
    }

    public void setPSDCContainerSpecName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCContainerSpecName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdccontainerspecname = string;
        this.psdccontainerspecnameDirtyFlag = true;
    }

    public String getPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpecName();
        }
        return this.psdccontainerspecname;
    }

    public boolean isPSDCContainerSpecNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCContainerSpecNameDirty();
        }
        return this.psdccontainerspecnameDirtyFlag;
    }

    public void resetPSDCContainerSpecName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCContainerSpecName();
            return;
        }
        this.psdccontainerspecnameDirtyFlag = false;
        this.psdccontainerspecname = null;
    }

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
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

    public void setPSDevCenterMQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqid = string;
        this.psdevcentermqidDirtyFlag = true;
    }

    public String getPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQId();
        }
        return this.psdevcentermqid;
    }

    public boolean isPSDevCenterMQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQIdDirty();
        }
        return this.psdevcentermqidDirtyFlag;
    }

    public void resetPSDevCenterMQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQId();
            return;
        }
        this.psdevcentermqidDirtyFlag = false;
        this.psdevcentermqid = null;
    }

    public void setPSDevCenterMQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterMQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentermqname = string;
        this.psdevcentermqnameDirtyFlag = true;
    }

    public String getPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterMQName();
        }
        return this.psdevcentermqname;
    }

    public boolean isPSDevCenterMQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterMQNameDirty();
        }
        return this.psdevcentermqnameDirtyFlag;
    }

    public void resetPSDevCenterMQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterMQName();
            return;
        }
        this.psdevcentermqnameDirtyFlag = false;
        this.psdevcentermqname = null;
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

    public void setPSMQInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqinstid = string;
        this.psmqinstidDirtyFlag = true;
    }

    public String getPSMQInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQInstId();
        }
        return this.psmqinstid;
    }

    public boolean isPSMQInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQInstIdDirty();
        }
        return this.psmqinstidDirtyFlag;
    }

    public void resetPSMQInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQInstId();
            return;
        }
        this.psmqinstidDirtyFlag = false;
        this.psmqinstid = null;
    }

    public void setPSMQInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqinstname = string;
        this.psmqinstnameDirtyFlag = true;
    }

    public String getPSMQInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQInstName();
        }
        return this.psmqinstname;
    }

    public boolean isPSMQInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQInstNameDirty();
        }
        return this.psmqinstnameDirtyFlag;
    }

    public void resetPSMQInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQInstName();
            return;
        }
        this.psmqinstnameDirtyFlag = false;
        this.psmqinstname = null;
    }

    public void setResPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResPos(n);
            return;
        }
        this.respos = n;
        this.resposDirtyFlag = true;
    }

    public Integer getResPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResPos();
        }
        return this.respos;
    }

    public boolean isResPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResPosDirty();
        }
        return this.resposDirtyFlag;
    }

    public void resetResPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResPos();
            return;
        }
        this.resposDirtyFlag = false;
        this.respos = null;
    }

    public void setResReadyTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResReadyTime(timestamp);
            return;
        }
        this.resreadytime = timestamp;
        this.resreadytimeDirtyFlag = true;
    }

    public Timestamp getResReadyTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResReadyTime();
        }
        return this.resreadytime;
    }

    public boolean isResReadyTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResReadyTimeDirty();
        }
        return this.resreadytimeDirtyFlag;
    }

    public void resetResReadyTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResReadyTime();
            return;
        }
        this.resreadytimeDirtyFlag = false;
        this.resreadytime = null;
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

    public void setResVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResVer(n);
            return;
        }
        this.resver = n;
        this.resverDirtyFlag = true;
    }

    public Integer getResVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResVer();
        }
        return this.resver;
    }

    public boolean isResVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResVerDirty();
        }
        return this.resverDirtyFlag;
    }

    public void resetResVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResVer();
            return;
        }
        this.resverDirtyFlag = false;
        this.resver = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSDevCenterMQBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterMQBase pSDevCenterMQBase) {
        pSDevCenterMQBase.resetCreateDate();
        pSDevCenterMQBase.resetCreateMan();
        pSDevCenterMQBase.resetExpriedTime();
        pSDevCenterMQBase.resetLockMode();
        pSDevCenterMQBase.resetLockObjId();
        pSDevCenterMQBase.resetLockObjType();
        pSDevCenterMQBase.resetMemo();
        pSDevCenterMQBase.resetMQType();
        pSDevCenterMQBase.resetPSDCClusterId();
        pSDevCenterMQBase.resetPSDCClusterName();
        pSDevCenterMQBase.resetPSDCContainerSpecId();
        pSDevCenterMQBase.resetPSDCContainerSpecName();
        pSDevCenterMQBase.resetPSDCFileId();
        pSDevCenterMQBase.resetPSDCFileName();
        pSDevCenterMQBase.resetPSDevCenterId();
        pSDevCenterMQBase.resetPSDevCenterMQId();
        pSDevCenterMQBase.resetPSDevCenterMQName();
        pSDevCenterMQBase.resetPSDevCenterName();
        pSDevCenterMQBase.resetPSMQInstId();
        pSDevCenterMQBase.resetPSMQInstName();
        pSDevCenterMQBase.resetResPos();
        pSDevCenterMQBase.resetResReadyTime();
        pSDevCenterMQBase.resetResState();
        pSDevCenterMQBase.resetResVer();
        pSDevCenterMQBase.resetUpdateDate();
        pSDevCenterMQBase.resetUpdateMan();
        pSDevCenterMQBase.resetUsageMode();
        pSDevCenterMQBase.resetUserParams();
        pSDevCenterMQBase.resetUserTag();
        pSDevCenterMQBase.resetUserTag2();
        pSDevCenterMQBase.resetUserTag3();
        pSDevCenterMQBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isLockModeDirty()) {
            hashMap.put(FIELD_LOCKMODE, this.getLockMode());
        }
        if (!bl || this.isLockObjIdDirty()) {
            hashMap.put(FIELD_LOCKOBJID, this.getLockObjId());
        }
        if (!bl || this.isLockObjTypeDirty()) {
            hashMap.put(FIELD_LOCKOBJTYPE, this.getLockObjType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMQTypeDirty()) {
            hashMap.put(FIELD_MQTYPE, this.getMQType());
        }
        if (!bl || this.isPSDCClusterIdDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERID, this.getPSDCClusterId());
        }
        if (!bl || this.isPSDCClusterNameDirty()) {
            hashMap.put(FIELD_PSDCCLUSTERNAME, this.getPSDCClusterName());
        }
        if (!bl || this.isPSDCContainerSpecIdDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECID, this.getPSDCContainerSpecId());
        }
        if (!bl || this.isPSDCContainerSpecNameDirty()) {
            hashMap.put(FIELD_PSDCCONTAINERSPECNAME, this.getPSDCContainerSpecName());
        }
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterMQIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQID, this.getPSDevCenterMQId());
        }
        if (!bl || this.isPSDevCenterMQNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERMQNAME, this.getPSDevCenterMQName());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSMQInstIdDirty()) {
            hashMap.put(FIELD_PSMQINSTID, this.getPSMQInstId());
        }
        if (!bl || this.isPSMQInstNameDirty()) {
            hashMap.put(FIELD_PSMQINSTNAME, this.getPSMQInstName());
        }
        if (!bl || this.isResPosDirty()) {
            hashMap.put(FIELD_RESPOS, this.getResPos());
        }
        if (!bl || this.isResReadyTimeDirty()) {
            hashMap.put(FIELD_RESREADYTIME, this.getResReadyTime());
        }
        if (!bl || this.isResStateDirty()) {
            hashMap.put(FIELD_RESSTATE, this.getResState());
        }
        if (!bl || this.isResVerDirty()) {
            hashMap.put(FIELD_RESVER, this.getResVer());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSDevCenterMQBase.get(this, n);
    }

    private static Object get(PSDevCenterMQBase pSDevCenterMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterMQBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterMQBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterMQBase.getExpriedTime();
            }
            case 3: {
                return pSDevCenterMQBase.getLockMode();
            }
            case 4: {
                return pSDevCenterMQBase.getLockObjId();
            }
            case 5: {
                return pSDevCenterMQBase.getLockObjType();
            }
            case 6: {
                return pSDevCenterMQBase.getMemo();
            }
            case 7: {
                return pSDevCenterMQBase.getMQType();
            }
            case 8: {
                return pSDevCenterMQBase.getPSDCClusterId();
            }
            case 9: {
                return pSDevCenterMQBase.getPSDCClusterName();
            }
            case 10: {
                return pSDevCenterMQBase.getPSDCContainerSpecId();
            }
            case 11: {
                return pSDevCenterMQBase.getPSDCContainerSpecName();
            }
            case 12: {
                return pSDevCenterMQBase.getPSDCFileId();
            }
            case 13: {
                return pSDevCenterMQBase.getPSDCFileName();
            }
            case 14: {
                return pSDevCenterMQBase.getPSDevCenterId();
            }
            case 15: {
                return pSDevCenterMQBase.getPSDevCenterMQId();
            }
            case 16: {
                return pSDevCenterMQBase.getPSDevCenterMQName();
            }
            case 17: {
                return pSDevCenterMQBase.getPSDevCenterName();
            }
            case 18: {
                return pSDevCenterMQBase.getPSMQInstId();
            }
            case 19: {
                return pSDevCenterMQBase.getPSMQInstName();
            }
            case 20: {
                return pSDevCenterMQBase.getResPos();
            }
            case 21: {
                return pSDevCenterMQBase.getResReadyTime();
            }
            case 22: {
                return pSDevCenterMQBase.getResState();
            }
            case 23: {
                return pSDevCenterMQBase.getResVer();
            }
            case 24: {
                return pSDevCenterMQBase.getUpdateDate();
            }
            case 25: {
                return pSDevCenterMQBase.getUpdateMan();
            }
            case 26: {
                return pSDevCenterMQBase.getUsageMode();
            }
            case 27: {
                return pSDevCenterMQBase.getUserParams();
            }
            case 28: {
                return pSDevCenterMQBase.getUserTag();
            }
            case 29: {
                return pSDevCenterMQBase.getUserTag2();
            }
            case 30: {
                return pSDevCenterMQBase.getUserTag3();
            }
            case 31: {
                return pSDevCenterMQBase.getUserTag4();
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
        PSDevCenterMQBase.set(this, n, object);
    }

    private static void set(PSDevCenterMQBase pSDevCenterMQBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterMQBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterMQBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterMQBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterMQBase.setLockMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterMQBase.setLockObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterMQBase.setLockObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterMQBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterMQBase.setMQType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterMQBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterMQBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterMQBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterMQBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterMQBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterMQBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterMQBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterMQBase.setPSDevCenterMQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterMQBase.setPSDevCenterMQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterMQBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterMQBase.setPSMQInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterMQBase.setPSMQInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterMQBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterMQBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterMQBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterMQBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterMQBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterMQBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterMQBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevCenterMQBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevCenterMQBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevCenterMQBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevCenterMQBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevCenterMQBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevCenterMQBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterMQBase pSDevCenterMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterMQBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterMQBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterMQBase.getExpriedTime() == null;
            }
            case 3: {
                return pSDevCenterMQBase.getLockMode() == null;
            }
            case 4: {
                return pSDevCenterMQBase.getLockObjId() == null;
            }
            case 5: {
                return pSDevCenterMQBase.getLockObjType() == null;
            }
            case 6: {
                return pSDevCenterMQBase.getMemo() == null;
            }
            case 7: {
                return pSDevCenterMQBase.getMQType() == null;
            }
            case 8: {
                return pSDevCenterMQBase.getPSDCClusterId() == null;
            }
            case 9: {
                return pSDevCenterMQBase.getPSDCClusterName() == null;
            }
            case 10: {
                return pSDevCenterMQBase.getPSDCContainerSpecId() == null;
            }
            case 11: {
                return pSDevCenterMQBase.getPSDCContainerSpecName() == null;
            }
            case 12: {
                return pSDevCenterMQBase.getPSDCFileId() == null;
            }
            case 13: {
                return pSDevCenterMQBase.getPSDCFileName() == null;
            }
            case 14: {
                return pSDevCenterMQBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDevCenterMQBase.getPSDevCenterMQId() == null;
            }
            case 16: {
                return pSDevCenterMQBase.getPSDevCenterMQName() == null;
            }
            case 17: {
                return pSDevCenterMQBase.getPSDevCenterName() == null;
            }
            case 18: {
                return pSDevCenterMQBase.getPSMQInstId() == null;
            }
            case 19: {
                return pSDevCenterMQBase.getPSMQInstName() == null;
            }
            case 20: {
                return pSDevCenterMQBase.getResPos() == null;
            }
            case 21: {
                return pSDevCenterMQBase.getResReadyTime() == null;
            }
            case 22: {
                return pSDevCenterMQBase.getResState() == null;
            }
            case 23: {
                return pSDevCenterMQBase.getResVer() == null;
            }
            case 24: {
                return pSDevCenterMQBase.getUpdateDate() == null;
            }
            case 25: {
                return pSDevCenterMQBase.getUpdateMan() == null;
            }
            case 26: {
                return pSDevCenterMQBase.getUsageMode() == null;
            }
            case 27: {
                return pSDevCenterMQBase.getUserParams() == null;
            }
            case 28: {
                return pSDevCenterMQBase.getUserTag() == null;
            }
            case 29: {
                return pSDevCenterMQBase.getUserTag2() == null;
            }
            case 30: {
                return pSDevCenterMQBase.getUserTag3() == null;
            }
            case 31: {
                return pSDevCenterMQBase.getUserTag4() == null;
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
        return PSDevCenterMQBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterMQBase pSDevCenterMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterMQBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterMQBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterMQBase.isExpriedTimeDirty();
            }
            case 3: {
                return pSDevCenterMQBase.isLockModeDirty();
            }
            case 4: {
                return pSDevCenterMQBase.isLockObjIdDirty();
            }
            case 5: {
                return pSDevCenterMQBase.isLockObjTypeDirty();
            }
            case 6: {
                return pSDevCenterMQBase.isMemoDirty();
            }
            case 7: {
                return pSDevCenterMQBase.isMQTypeDirty();
            }
            case 8: {
                return pSDevCenterMQBase.isPSDCClusterIdDirty();
            }
            case 9: {
                return pSDevCenterMQBase.isPSDCClusterNameDirty();
            }
            case 10: {
                return pSDevCenterMQBase.isPSDCContainerSpecIdDirty();
            }
            case 11: {
                return pSDevCenterMQBase.isPSDCContainerSpecNameDirty();
            }
            case 12: {
                return pSDevCenterMQBase.isPSDCFileIdDirty();
            }
            case 13: {
                return pSDevCenterMQBase.isPSDCFileNameDirty();
            }
            case 14: {
                return pSDevCenterMQBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDevCenterMQBase.isPSDevCenterMQIdDirty();
            }
            case 16: {
                return pSDevCenterMQBase.isPSDevCenterMQNameDirty();
            }
            case 17: {
                return pSDevCenterMQBase.isPSDevCenterNameDirty();
            }
            case 18: {
                return pSDevCenterMQBase.isPSMQInstIdDirty();
            }
            case 19: {
                return pSDevCenterMQBase.isPSMQInstNameDirty();
            }
            case 20: {
                return pSDevCenterMQBase.isResPosDirty();
            }
            case 21: {
                return pSDevCenterMQBase.isResReadyTimeDirty();
            }
            case 22: {
                return pSDevCenterMQBase.isResStateDirty();
            }
            case 23: {
                return pSDevCenterMQBase.isResVerDirty();
            }
            case 24: {
                return pSDevCenterMQBase.isUpdateDateDirty();
            }
            case 25: {
                return pSDevCenterMQBase.isUpdateManDirty();
            }
            case 26: {
                return pSDevCenterMQBase.isUsageModeDirty();
            }
            case 27: {
                return pSDevCenterMQBase.isUserParamsDirty();
            }
            case 28: {
                return pSDevCenterMQBase.isUserTagDirty();
            }
            case 29: {
                return pSDevCenterMQBase.isUserTag2Dirty();
            }
            case 30: {
                return pSDevCenterMQBase.isUserTag3Dirty();
            }
            case 31: {
                return pSDevCenterMQBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterMQBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterMQBase pSDevCenterMQBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterMQBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getLockMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockmode", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getLockMode()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getLockObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getLockObjId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getLockObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockobjtype", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getLockObjType()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getMQType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mqtype", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getMQType()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterMQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDevCenterMQId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterMQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentermqname", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDevCenterMQName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSMQInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqinstid", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSMQInstId()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getPSMQInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqinstname", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getPSMQInstName()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getResState()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getResVer()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUserParams()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevCenterMQBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevCenterMQBase.getJSONValue((Object)pSDevCenterMQBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterMQBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterMQBase pSDevCenterMQBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterMQBase.getCreateDate() != null) {
            object = pSDevCenterMQBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getCreateMan() != null) {
            object = pSDevCenterMQBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getExpriedTime() != null) {
            object = pSDevCenterMQBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getLockMode() != null) {
            object = pSDevCenterMQBase.getLockMode();
            xmlNode.setAttribute(FIELD_LOCKMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getLockObjId() != null) {
            object = pSDevCenterMQBase.getLockObjId();
            xmlNode.setAttribute(FIELD_LOCKOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getLockObjType() != null) {
            object = pSDevCenterMQBase.getLockObjType();
            xmlNode.setAttribute(FIELD_LOCKOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getMemo() != null) {
            object = pSDevCenterMQBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getMQType() != null) {
            object = pSDevCenterMQBase.getMQType();
            xmlNode.setAttribute(FIELD_MQTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCClusterId() != null) {
            object = pSDevCenterMQBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCClusterName() != null) {
            object = pSDevCenterMQBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCContainerSpecId() != null) {
            object = pSDevCenterMQBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCContainerSpecName() != null) {
            object = pSDevCenterMQBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCFileId() != null) {
            object = pSDevCenterMQBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDCFileName() != null) {
            object = pSDevCenterMQBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterId() != null) {
            object = pSDevCenterMQBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterMQId() != null) {
            object = pSDevCenterMQBase.getPSDevCenterMQId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterMQName() != null) {
            object = pSDevCenterMQBase.getPSDevCenterMQName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERMQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSDevCenterName() != null) {
            object = pSDevCenterMQBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSMQInstId() != null) {
            object = pSDevCenterMQBase.getPSMQInstId();
            xmlNode.setAttribute(FIELD_PSMQINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getPSMQInstName() != null) {
            object = pSDevCenterMQBase.getPSMQInstName();
            xmlNode.setAttribute(FIELD_PSMQINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getResPos() != null) {
            object = pSDevCenterMQBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getResReadyTime() != null) {
            object = pSDevCenterMQBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getResState() != null) {
            object = pSDevCenterMQBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getResVer() != null) {
            object = pSDevCenterMQBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getUpdateDate() != null) {
            object = pSDevCenterMQBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterMQBase.getUpdateMan() != null) {
            object = pSDevCenterMQBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUsageMode() != null) {
            object = pSDevCenterMQBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUserParams() != null) {
            object = pSDevCenterMQBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUserTag() != null) {
            object = pSDevCenterMQBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUserTag2() != null) {
            object = pSDevCenterMQBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUserTag3() != null) {
            object = pSDevCenterMQBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterMQBase.getUserTag4() != null) {
            object = pSDevCenterMQBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterMQBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterMQBase pSDevCenterMQBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterMQBase.isCreateDateDirty() && (bl || pSDevCenterMQBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterMQBase.getCreateDate());
        }
        if (pSDevCenterMQBase.isCreateManDirty() && (bl || pSDevCenterMQBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterMQBase.getCreateMan());
        }
        if (pSDevCenterMQBase.isExpriedTimeDirty() && (bl || pSDevCenterMQBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevCenterMQBase.getExpriedTime());
        }
        if (pSDevCenterMQBase.isLockModeDirty() && (bl || pSDevCenterMQBase.getLockMode() != null)) {
            iDataObject.set(FIELD_LOCKMODE, (Object)pSDevCenterMQBase.getLockMode());
        }
        if (pSDevCenterMQBase.isLockObjIdDirty() && (bl || pSDevCenterMQBase.getLockObjId() != null)) {
            iDataObject.set(FIELD_LOCKOBJID, (Object)pSDevCenterMQBase.getLockObjId());
        }
        if (pSDevCenterMQBase.isLockObjTypeDirty() && (bl || pSDevCenterMQBase.getLockObjType() != null)) {
            iDataObject.set(FIELD_LOCKOBJTYPE, (Object)pSDevCenterMQBase.getLockObjType());
        }
        if (pSDevCenterMQBase.isMemoDirty() && (bl || pSDevCenterMQBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterMQBase.getMemo());
        }
        if (pSDevCenterMQBase.isMQTypeDirty() && (bl || pSDevCenterMQBase.getMQType() != null)) {
            iDataObject.set(FIELD_MQTYPE, (Object)pSDevCenterMQBase.getMQType());
        }
        if (pSDevCenterMQBase.isPSDCClusterIdDirty() && (bl || pSDevCenterMQBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDevCenterMQBase.getPSDCClusterId());
        }
        if (pSDevCenterMQBase.isPSDCClusterNameDirty() && (bl || pSDevCenterMQBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDevCenterMQBase.getPSDCClusterName());
        }
        if (pSDevCenterMQBase.isPSDCContainerSpecIdDirty() && (bl || pSDevCenterMQBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDevCenterMQBase.getPSDCContainerSpecId());
        }
        if (pSDevCenterMQBase.isPSDCContainerSpecNameDirty() && (bl || pSDevCenterMQBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDevCenterMQBase.getPSDCContainerSpecName());
        }
        if (pSDevCenterMQBase.isPSDCFileIdDirty() && (bl || pSDevCenterMQBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevCenterMQBase.getPSDCFileId());
        }
        if (pSDevCenterMQBase.isPSDCFileNameDirty() && (bl || pSDevCenterMQBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevCenterMQBase.getPSDCFileName());
        }
        if (pSDevCenterMQBase.isPSDevCenterIdDirty() && (bl || pSDevCenterMQBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterMQBase.getPSDevCenterId());
        }
        if (pSDevCenterMQBase.isPSDevCenterMQIdDirty() && (bl || pSDevCenterMQBase.getPSDevCenterMQId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQID, (Object)pSDevCenterMQBase.getPSDevCenterMQId());
        }
        if (pSDevCenterMQBase.isPSDevCenterMQNameDirty() && (bl || pSDevCenterMQBase.getPSDevCenterMQName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERMQNAME, (Object)pSDevCenterMQBase.getPSDevCenterMQName());
        }
        if (pSDevCenterMQBase.isPSDevCenterNameDirty() && (bl || pSDevCenterMQBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterMQBase.getPSDevCenterName());
        }
        if (pSDevCenterMQBase.isPSMQInstIdDirty() && (bl || pSDevCenterMQBase.getPSMQInstId() != null)) {
            iDataObject.set(FIELD_PSMQINSTID, (Object)pSDevCenterMQBase.getPSMQInstId());
        }
        if (pSDevCenterMQBase.isPSMQInstNameDirty() && (bl || pSDevCenterMQBase.getPSMQInstName() != null)) {
            iDataObject.set(FIELD_PSMQINSTNAME, (Object)pSDevCenterMQBase.getPSMQInstName());
        }
        if (pSDevCenterMQBase.isResPosDirty() && (bl || pSDevCenterMQBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevCenterMQBase.getResPos());
        }
        if (pSDevCenterMQBase.isResReadyTimeDirty() && (bl || pSDevCenterMQBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevCenterMQBase.getResReadyTime());
        }
        if (pSDevCenterMQBase.isResStateDirty() && (bl || pSDevCenterMQBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevCenterMQBase.getResState());
        }
        if (pSDevCenterMQBase.isResVerDirty() && (bl || pSDevCenterMQBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDevCenterMQBase.getResVer());
        }
        if (pSDevCenterMQBase.isUpdateDateDirty() && (bl || pSDevCenterMQBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterMQBase.getUpdateDate());
        }
        if (pSDevCenterMQBase.isUpdateManDirty() && (bl || pSDevCenterMQBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterMQBase.getUpdateMan());
        }
        if (pSDevCenterMQBase.isUsageModeDirty() && (bl || pSDevCenterMQBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSDevCenterMQBase.getUsageMode());
        }
        if (pSDevCenterMQBase.isUserParamsDirty() && (bl || pSDevCenterMQBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSDevCenterMQBase.getUserParams());
        }
        if (pSDevCenterMQBase.isUserTagDirty() && (bl || pSDevCenterMQBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevCenterMQBase.getUserTag());
        }
        if (pSDevCenterMQBase.isUserTag2Dirty() && (bl || pSDevCenterMQBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevCenterMQBase.getUserTag2());
        }
        if (pSDevCenterMQBase.isUserTag3Dirty() && (bl || pSDevCenterMQBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevCenterMQBase.getUserTag3());
        }
        if (pSDevCenterMQBase.isUserTag4Dirty() && (bl || pSDevCenterMQBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevCenterMQBase.getUserTag4());
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
        return PSDevCenterMQBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterMQBase pSDevCenterMQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterMQBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterMQBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterMQBase.resetExpriedTime();
                return true;
            }
            case 3: {
                pSDevCenterMQBase.resetLockMode();
                return true;
            }
            case 4: {
                pSDevCenterMQBase.resetLockObjId();
                return true;
            }
            case 5: {
                pSDevCenterMQBase.resetLockObjType();
                return true;
            }
            case 6: {
                pSDevCenterMQBase.resetMemo();
                return true;
            }
            case 7: {
                pSDevCenterMQBase.resetMQType();
                return true;
            }
            case 8: {
                pSDevCenterMQBase.resetPSDCClusterId();
                return true;
            }
            case 9: {
                pSDevCenterMQBase.resetPSDCClusterName();
                return true;
            }
            case 10: {
                pSDevCenterMQBase.resetPSDCContainerSpecId();
                return true;
            }
            case 11: {
                pSDevCenterMQBase.resetPSDCContainerSpecName();
                return true;
            }
            case 12: {
                pSDevCenterMQBase.resetPSDCFileId();
                return true;
            }
            case 13: {
                pSDevCenterMQBase.resetPSDCFileName();
                return true;
            }
            case 14: {
                pSDevCenterMQBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDevCenterMQBase.resetPSDevCenterMQId();
                return true;
            }
            case 16: {
                pSDevCenterMQBase.resetPSDevCenterMQName();
                return true;
            }
            case 17: {
                pSDevCenterMQBase.resetPSDevCenterName();
                return true;
            }
            case 18: {
                pSDevCenterMQBase.resetPSMQInstId();
                return true;
            }
            case 19: {
                pSDevCenterMQBase.resetPSMQInstName();
                return true;
            }
            case 20: {
                pSDevCenterMQBase.resetResPos();
                return true;
            }
            case 21: {
                pSDevCenterMQBase.resetResReadyTime();
                return true;
            }
            case 22: {
                pSDevCenterMQBase.resetResState();
                return true;
            }
            case 23: {
                pSDevCenterMQBase.resetResVer();
                return true;
            }
            case 24: {
                pSDevCenterMQBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSDevCenterMQBase.resetUpdateMan();
                return true;
            }
            case 26: {
                pSDevCenterMQBase.resetUsageMode();
                return true;
            }
            case 27: {
                pSDevCenterMQBase.resetUserParams();
                return true;
            }
            case 28: {
                pSDevCenterMQBase.resetUserTag();
                return true;
            }
            case 29: {
                pSDevCenterMQBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSDevCenterMQBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSDevCenterMQBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCCluster getPSDCCluster() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCCluster();
        }
        if (this.getPSDCClusterId() == null) {
            return null;
        }
        Integer n = this.objPSDCClusterLock;
        synchronized (n) {
            if (this.psdccluster != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCClusterId(), (Object)this.psdccluster.getPSDCClusterId()) != 0L) {
                this.psdccluster = null;
            }
            if (this.psdccluster == null) {
                PSDCCluster pSDCCluster = new PSDCCluster();
                pSDCCluster.setPSDCClusterId(this.getPSDCClusterId());
                PSDCClusterService pSDCClusterService = (PSDCClusterService)ServiceGlobal.getService(PSDCClusterService.class, (SessionFactory)this.getSessionFactory());
                pSDCClusterService.autoGet(pSDCCluster);
                this.psdccluster = pSDCCluster;
            }
            return this.psdccluster;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCContainerSpec getPSDCContainerSpec() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCContainerSpec();
        }
        if (this.getPSDCContainerSpecId() == null) {
            return null;
        }
        Integer n = this.objPSDCContainerSpecLock;
        synchronized (n) {
            if (this.psdccontainerspec != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCContainerSpecId(), (Object)this.psdccontainerspec.getPSDCContainerSpecId()) != 0L) {
                this.psdccontainerspec = null;
            }
            if (this.psdccontainerspec == null) {
                PSDCContainerSpec pSDCContainerSpec = new PSDCContainerSpec();
                pSDCContainerSpec.setPSDCContainerSpecId(this.getPSDCContainerSpecId());
                PSDCContainerSpecService pSDCContainerSpecService = (PSDCContainerSpecService)ServiceGlobal.getService(PSDCContainerSpecService.class, (SessionFactory)this.getSessionFactory());
                pSDCContainerSpecService.autoGet(pSDCContainerSpec);
                this.psdccontainerspec = pSDCContainerSpec;
            }
            return this.psdccontainerspec;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet(pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
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
    public PSMQInst getPSMQInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQInst();
        }
        if (this.getPSMQInstId() == null) {
            return null;
        }
        Integer n = this.objPSMQInstLock;
        synchronized (n) {
            if (this.psmqinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSMQInstId(), (Object)this.psmqinst.getPSMQInstId()) != 0L) {
                this.psmqinst = null;
            }
            if (this.psmqinst == null) {
                PSMQInst pSMQInst = new PSMQInst();
                pSMQInst.setPSMQInstId(this.getPSMQInstId());
                PSMQInstService pSMQInstService = (PSMQInstService)ServiceGlobal.getService(PSMQInstService.class, (SessionFactory)this.getSessionFactory());
                pSMQInstService.autoGet(pSMQInst);
                this.psmqinst = pSMQInst;
            }
            return this.psmqinst;
        }
    }

    private PSDevCenterMQBase getProxyEntity() {
        return this.proxyPSDevCenterMQBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterMQBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterMQBase) {
            this.proxyPSDevCenterMQBase = (PSDevCenterMQBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterMQService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 2);
        fieldIndexMap.put(FIELD_LOCKMODE, 3);
        fieldIndexMap.put(FIELD_LOCKOBJID, 4);
        fieldIndexMap.put(FIELD_LOCKOBJTYPE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MQTYPE, 7);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 8);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 9);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 10);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 11);
        fieldIndexMap.put(FIELD_PSDCFILEID, 12);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQID, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERMQNAME, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 17);
        fieldIndexMap.put(FIELD_PSMQINSTID, 18);
        fieldIndexMap.put(FIELD_PSMQINSTNAME, 19);
        fieldIndexMap.put(FIELD_RESPOS, 20);
        fieldIndexMap.put(FIELD_RESREADYTIME, 21);
        fieldIndexMap.put(FIELD_RESSTATE, 22);
        fieldIndexMap.put(FIELD_RESVER, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
        fieldIndexMap.put(FIELD_USAGEMODE, 26);
        fieldIndexMap.put(FIELD_USERPARAMS, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
    }
}

