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
import net.ibizsys.pscore.srv.paasmgr.entity.PSDevServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSDevServerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterServerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterServerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTYPE = "DSTYPE";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_HOSTADDRESS = "HOSTADDRESS";
    public static final String FIELD_HOSTPASSWD = "HOSTPASSWD";
    public static final String FIELD_HOSTUSERNAME = "HOSTUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCCLUSTERID = "PSDCCLUSTERID";
    public static final String FIELD_PSDCCLUSTERNAME = "PSDCCLUSTERNAME";
    public static final String FIELD_PSDCCONTAINERSPECID = "PSDCCONTAINERSPECID";
    public static final String FIELD_PSDCCONTAINERSPECNAME = "PSDCCONTAINERSPECNAME";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERSERVERID = "PSDEVCENTERSERVERID";
    public static final String FIELD_PSDEVCENTERSERVERNAME = "PSDEVCENTERSERVERNAME";
    public static final String FIELD_PSDEVSERVERID = "PSDEVSERVERID";
    public static final String FIELD_PSDEVSERVERNAME = "PSDEVSERVERNAME";
    public static final String FIELD_PSDSBKLISTS = "PSDSBKLISTS";
    public static final String FIELD_RESPOS = "RESPOS";
    public static final String FIELD_RESREADYTIME = "RESREADYTIME";
    public static final String FIELD_RESSTATE = "RESSTATE";
    public static final String FIELD_RESVER = "RESVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSTYPE = 2;
    private static final int INDEX_EXPRIEDTIME = 3;
    private static final int INDEX_HOSTADDRESS = 4;
    private static final int INDEX_HOSTPASSWD = 5;
    private static final int INDEX_HOSTUSERNAME = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PSDCCLUSTERID = 8;
    private static final int INDEX_PSDCCLUSTERNAME = 9;
    private static final int INDEX_PSDCCONTAINERSPECID = 10;
    private static final int INDEX_PSDCCONTAINERSPECNAME = 11;
    private static final int INDEX_PSDCFILEID = 12;
    private static final int INDEX_PSDCFILENAME = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_PSDEVCENTERSERVERID = 16;
    private static final int INDEX_PSDEVCENTERSERVERNAME = 17;
    private static final int INDEX_PSDEVSERVERID = 18;
    private static final int INDEX_PSDEVSERVERNAME = 19;
    private static final int INDEX_PSDSBKLISTS = 20;
    private static final int INDEX_RESPOS = 21;
    private static final int INDEX_RESREADYTIME = 22;
    private static final int INDEX_RESSTATE = 23;
    private static final int INDEX_RESVER = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterServerBase proxyPSDevCenterServerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstypeDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean hostaddressDirtyFlag = false;
    private boolean hostpasswdDirtyFlag = false;
    private boolean hostusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcclusteridDirtyFlag = false;
    private boolean psdcclusternameDirtyFlag = false;
    private boolean psdccontainerspecidDirtyFlag = false;
    private boolean psdccontainerspecnameDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterserveridDirtyFlag = false;
    private boolean psdevcenterservernameDirtyFlag = false;
    private boolean psdevserveridDirtyFlag = false;
    private boolean psdevservernameDirtyFlag = false;
    private boolean psdsbklistsDirtyFlag = false;
    private boolean resposDirtyFlag = false;
    private boolean resreadytimeDirtyFlag = false;
    private boolean resstateDirtyFlag = false;
    private boolean resverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstype")
    private String dstype;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="hostaddress")
    private String hostaddress;
    @Column(name="hostpasswd")
    private String hostpasswd;
    @Column(name="hostusername")
    private String hostusername;
    @Column(name="memo")
    private String memo;
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
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcenterserverid")
    private String psdevcenterserverid;
    @Column(name="psdevcenterservername")
    private String psdevcenterservername;
    @Column(name="psdevserverid")
    private String psdevserverid;
    @Column(name="psdevservername")
    private String psdevservername;
    @Column(name="psdsbklists")
    private String psdsbklists;
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
    private Integer objPSDCClusterLock = new Integer(1);
    private PSDCCluster psdccluster = null;
    private Integer objPSDCContainerSpecLock = new Integer(1);
    private PSDCContainerSpec psdccontainerspec = null;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevServerLock = new Integer(1);
    private PSDevServer psdevserver = null;

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

    public void setDSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstype = string;
        this.dstypeDirtyFlag = true;
    }

    public String getDSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSType();
        }
        return this.dstype;
    }

    public boolean isDSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTypeDirty();
        }
        return this.dstypeDirtyFlag;
    }

    public void resetDSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSType();
            return;
        }
        this.dstypeDirtyFlag = false;
        this.dstype = null;
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

    public void setHostAddress(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostAddress(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostaddress = string;
        this.hostaddressDirtyFlag = true;
    }

    public String getHostAddress() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostAddress();
        }
        return this.hostaddress;
    }

    public boolean isHostAddressDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostAddressDirty();
        }
        return this.hostaddressDirtyFlag;
    }

    public void resetHostAddress() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostAddress();
            return;
        }
        this.hostaddressDirtyFlag = false;
        this.hostaddress = null;
    }

    public void setHostPasswd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostPasswd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostpasswd = string;
        this.hostpasswdDirtyFlag = true;
    }

    public String getHostPasswd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostPasswd();
        }
        return this.hostpasswd;
    }

    public boolean isHostPasswdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostPasswdDirty();
        }
        return this.hostpasswdDirtyFlag;
    }

    public void resetHostPasswd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostPasswd();
            return;
        }
        this.hostpasswdDirtyFlag = false;
        this.hostpasswd = null;
    }

    public void setHostUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHostUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hostusername = string;
        this.hostusernameDirtyFlag = true;
    }

    public String getHostUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHostUserName();
        }
        return this.hostusername;
    }

    public boolean isHostUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHostUserNameDirty();
        }
        return this.hostusernameDirtyFlag;
    }

    public void resetHostUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHostUserName();
            return;
        }
        this.hostusernameDirtyFlag = false;
        this.hostusername = null;
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

    public void setPSDevCenterServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterserverid = string;
        this.psdevcenterserveridDirtyFlag = true;
    }

    public String getPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerId();
        }
        return this.psdevcenterserverid;
    }

    public boolean isPSDevCenterServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerIdDirty();
        }
        return this.psdevcenterserveridDirtyFlag;
    }

    public void resetPSDevCenterServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerId();
            return;
        }
        this.psdevcenterserveridDirtyFlag = false;
        this.psdevcenterserverid = null;
    }

    public void setPSDevCenterServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterservername = string;
        this.psdevcenterservernameDirtyFlag = true;
    }

    public String getPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterServerName();
        }
        return this.psdevcenterservername;
    }

    public boolean isPSDevCenterServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterServerNameDirty();
        }
        return this.psdevcenterservernameDirtyFlag;
    }

    public void resetPSDevCenterServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterServerName();
            return;
        }
        this.psdevcenterservernameDirtyFlag = false;
        this.psdevcenterservername = null;
    }

    public void setPSDevServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevserverid = string;
        this.psdevserveridDirtyFlag = true;
    }

    public String getPSDevServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerId();
        }
        return this.psdevserverid;
    }

    public boolean isPSDevServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerIdDirty();
        }
        return this.psdevserveridDirtyFlag;
    }

    public void resetPSDevServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerId();
            return;
        }
        this.psdevserveridDirtyFlag = false;
        this.psdevserverid = null;
    }

    public void setPSDevServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevservername = string;
        this.psdevservernameDirtyFlag = true;
    }

    public String getPSDevServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServerName();
        }
        return this.psdevservername;
    }

    public boolean isPSDevServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevServerNameDirty();
        }
        return this.psdevservernameDirtyFlag;
    }

    public void resetPSDevServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevServerName();
            return;
        }
        this.psdevservernameDirtyFlag = false;
        this.psdevservername = null;
    }

    public void setPSDSBKLists(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSBKLists(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsbklists = string;
        this.psdsbklistsDirtyFlag = true;
    }

    public String getPSDSBKLists() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSBKLists();
        }
        return this.psdsbklists;
    }

    public boolean isPSDSBKListsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSBKListsDirty();
        }
        return this.psdsbklistsDirtyFlag;
    }

    public void resetPSDSBKLists() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSBKLists();
            return;
        }
        this.psdsbklistsDirtyFlag = false;
        this.psdsbklists = null;
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

    protected void onReset() {
        PSDevCenterServerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterServerBase pSDevCenterServerBase) {
        pSDevCenterServerBase.resetCreateDate();
        pSDevCenterServerBase.resetCreateMan();
        pSDevCenterServerBase.resetDSType();
        pSDevCenterServerBase.resetExpriedTime();
        pSDevCenterServerBase.resetHostAddress();
        pSDevCenterServerBase.resetHostPasswd();
        pSDevCenterServerBase.resetHostUserName();
        pSDevCenterServerBase.resetMemo();
        pSDevCenterServerBase.resetPSDCClusterId();
        pSDevCenterServerBase.resetPSDCClusterName();
        pSDevCenterServerBase.resetPSDCContainerSpecId();
        pSDevCenterServerBase.resetPSDCContainerSpecName();
        pSDevCenterServerBase.resetPSDCFileId();
        pSDevCenterServerBase.resetPSDCFileName();
        pSDevCenterServerBase.resetPSDevCenterId();
        pSDevCenterServerBase.resetPSDevCenterName();
        pSDevCenterServerBase.resetPSDevCenterServerId();
        pSDevCenterServerBase.resetPSDevCenterServerName();
        pSDevCenterServerBase.resetPSDevServerId();
        pSDevCenterServerBase.resetPSDevServerName();
        pSDevCenterServerBase.resetPSDSBKLists();
        pSDevCenterServerBase.resetResPos();
        pSDevCenterServerBase.resetResReadyTime();
        pSDevCenterServerBase.resetResState();
        pSDevCenterServerBase.resetResVer();
        pSDevCenterServerBase.resetUpdateDate();
        pSDevCenterServerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDSTypeDirty()) {
            hashMap.put(FIELD_DSTYPE, this.getDSType());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isHostAddressDirty()) {
            hashMap.put(FIELD_HOSTADDRESS, this.getHostAddress());
        }
        if (!bl || this.isHostPasswdDirty()) {
            hashMap.put(FIELD_HOSTPASSWD, this.getHostPasswd());
        }
        if (!bl || this.isHostUserNameDirty()) {
            hashMap.put(FIELD_HOSTUSERNAME, this.getHostUserName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
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
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevCenterServerIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERID, this.getPSDevCenterServerId());
        }
        if (!bl || this.isPSDevCenterServerNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERSERVERNAME, this.getPSDevCenterServerName());
        }
        if (!bl || this.isPSDevServerIdDirty()) {
            hashMap.put(FIELD_PSDEVSERVERID, this.getPSDevServerId());
        }
        if (!bl || this.isPSDevServerNameDirty()) {
            hashMap.put(FIELD_PSDEVSERVERNAME, this.getPSDevServerName());
        }
        if (!bl || this.isPSDSBKListsDirty()) {
            hashMap.put(FIELD_PSDSBKLISTS, this.getPSDSBKLists());
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
        return PSDevCenterServerBase.get(this, n);
    }

    private static Object get(PSDevCenterServerBase pSDevCenterServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterServerBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterServerBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterServerBase.getDSType();
            }
            case 3: {
                return pSDevCenterServerBase.getExpriedTime();
            }
            case 4: {
                return pSDevCenterServerBase.getHostAddress();
            }
            case 5: {
                return pSDevCenterServerBase.getHostPasswd();
            }
            case 6: {
                return pSDevCenterServerBase.getHostUserName();
            }
            case 7: {
                return pSDevCenterServerBase.getMemo();
            }
            case 8: {
                return pSDevCenterServerBase.getPSDCClusterId();
            }
            case 9: {
                return pSDevCenterServerBase.getPSDCClusterName();
            }
            case 10: {
                return pSDevCenterServerBase.getPSDCContainerSpecId();
            }
            case 11: {
                return pSDevCenterServerBase.getPSDCContainerSpecName();
            }
            case 12: {
                return pSDevCenterServerBase.getPSDCFileId();
            }
            case 13: {
                return pSDevCenterServerBase.getPSDCFileName();
            }
            case 14: {
                return pSDevCenterServerBase.getPSDevCenterId();
            }
            case 15: {
                return pSDevCenterServerBase.getPSDevCenterName();
            }
            case 16: {
                return pSDevCenterServerBase.getPSDevCenterServerId();
            }
            case 17: {
                return pSDevCenterServerBase.getPSDevCenterServerName();
            }
            case 18: {
                return pSDevCenterServerBase.getPSDevServerId();
            }
            case 19: {
                return pSDevCenterServerBase.getPSDevServerName();
            }
            case 20: {
                return pSDevCenterServerBase.getPSDSBKLists();
            }
            case 21: {
                return pSDevCenterServerBase.getResPos();
            }
            case 22: {
                return pSDevCenterServerBase.getResReadyTime();
            }
            case 23: {
                return pSDevCenterServerBase.getResState();
            }
            case 24: {
                return pSDevCenterServerBase.getResVer();
            }
            case 25: {
                return pSDevCenterServerBase.getUpdateDate();
            }
            case 26: {
                return pSDevCenterServerBase.getUpdateMan();
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
        PSDevCenterServerBase.set(this, n, object);
    }

    private static void set(PSDevCenterServerBase pSDevCenterServerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterServerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterServerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterServerBase.setDSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterServerBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterServerBase.setHostAddress(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterServerBase.setHostPasswd(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterServerBase.setHostUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterServerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterServerBase.setPSDCClusterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterServerBase.setPSDCClusterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterServerBase.setPSDCContainerSpecId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterServerBase.setPSDCContainerSpecName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterServerBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterServerBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevCenterServerBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevCenterServerBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevCenterServerBase.setPSDevCenterServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevCenterServerBase.setPSDevCenterServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDevCenterServerBase.setPSDevServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevCenterServerBase.setPSDevServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevCenterServerBase.setPSDSBKLists(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevCenterServerBase.setResPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDevCenterServerBase.setResReadyTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDevCenterServerBase.setResState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDevCenterServerBase.setResVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDevCenterServerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSDevCenterServerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevCenterServerBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterServerBase pSDevCenterServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterServerBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterServerBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterServerBase.getDSType() == null;
            }
            case 3: {
                return pSDevCenterServerBase.getExpriedTime() == null;
            }
            case 4: {
                return pSDevCenterServerBase.getHostAddress() == null;
            }
            case 5: {
                return pSDevCenterServerBase.getHostPasswd() == null;
            }
            case 6: {
                return pSDevCenterServerBase.getHostUserName() == null;
            }
            case 7: {
                return pSDevCenterServerBase.getMemo() == null;
            }
            case 8: {
                return pSDevCenterServerBase.getPSDCClusterId() == null;
            }
            case 9: {
                return pSDevCenterServerBase.getPSDCClusterName() == null;
            }
            case 10: {
                return pSDevCenterServerBase.getPSDCContainerSpecId() == null;
            }
            case 11: {
                return pSDevCenterServerBase.getPSDCContainerSpecName() == null;
            }
            case 12: {
                return pSDevCenterServerBase.getPSDCFileId() == null;
            }
            case 13: {
                return pSDevCenterServerBase.getPSDCFileName() == null;
            }
            case 14: {
                return pSDevCenterServerBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDevCenterServerBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSDevCenterServerBase.getPSDevCenterServerId() == null;
            }
            case 17: {
                return pSDevCenterServerBase.getPSDevCenterServerName() == null;
            }
            case 18: {
                return pSDevCenterServerBase.getPSDevServerId() == null;
            }
            case 19: {
                return pSDevCenterServerBase.getPSDevServerName() == null;
            }
            case 20: {
                return pSDevCenterServerBase.getPSDSBKLists() == null;
            }
            case 21: {
                return pSDevCenterServerBase.getResPos() == null;
            }
            case 22: {
                return pSDevCenterServerBase.getResReadyTime() == null;
            }
            case 23: {
                return pSDevCenterServerBase.getResState() == null;
            }
            case 24: {
                return pSDevCenterServerBase.getResVer() == null;
            }
            case 25: {
                return pSDevCenterServerBase.getUpdateDate() == null;
            }
            case 26: {
                return pSDevCenterServerBase.getUpdateMan() == null;
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
        return PSDevCenterServerBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterServerBase pSDevCenterServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterServerBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterServerBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterServerBase.isDSTypeDirty();
            }
            case 3: {
                return pSDevCenterServerBase.isExpriedTimeDirty();
            }
            case 4: {
                return pSDevCenterServerBase.isHostAddressDirty();
            }
            case 5: {
                return pSDevCenterServerBase.isHostPasswdDirty();
            }
            case 6: {
                return pSDevCenterServerBase.isHostUserNameDirty();
            }
            case 7: {
                return pSDevCenterServerBase.isMemoDirty();
            }
            case 8: {
                return pSDevCenterServerBase.isPSDCClusterIdDirty();
            }
            case 9: {
                return pSDevCenterServerBase.isPSDCClusterNameDirty();
            }
            case 10: {
                return pSDevCenterServerBase.isPSDCContainerSpecIdDirty();
            }
            case 11: {
                return pSDevCenterServerBase.isPSDCContainerSpecNameDirty();
            }
            case 12: {
                return pSDevCenterServerBase.isPSDCFileIdDirty();
            }
            case 13: {
                return pSDevCenterServerBase.isPSDCFileNameDirty();
            }
            case 14: {
                return pSDevCenterServerBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDevCenterServerBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSDevCenterServerBase.isPSDevCenterServerIdDirty();
            }
            case 17: {
                return pSDevCenterServerBase.isPSDevCenterServerNameDirty();
            }
            case 18: {
                return pSDevCenterServerBase.isPSDevServerIdDirty();
            }
            case 19: {
                return pSDevCenterServerBase.isPSDevServerNameDirty();
            }
            case 20: {
                return pSDevCenterServerBase.isPSDSBKListsDirty();
            }
            case 21: {
                return pSDevCenterServerBase.isResPosDirty();
            }
            case 22: {
                return pSDevCenterServerBase.isResReadyTimeDirty();
            }
            case 23: {
                return pSDevCenterServerBase.isResStateDirty();
            }
            case 24: {
                return pSDevCenterServerBase.isResVerDirty();
            }
            case 25: {
                return pSDevCenterServerBase.isUpdateDateDirty();
            }
            case 26: {
                return pSDevCenterServerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterServerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterServerBase pSDevCenterServerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterServerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getDSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstype", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getDSType()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getHostAddress() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostaddress", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getHostAddress()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getHostPasswd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostpasswd", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getHostPasswd()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getHostUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hostusername", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getHostUserName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCClusterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclusterid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCClusterId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCClusterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcclustername", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCClusterName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCContainerSpecId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCContainerSpecId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCContainerSpecName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdccontainerspecname", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCContainerSpecName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterserverid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevCenterServerId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterservername", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevCenterServerName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevserverid", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevServerId()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDevServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevservername", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDevServerName()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getPSDSBKLists() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsbklists", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getPSDSBKLists()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getResPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"respos", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getResPos()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getResReadyTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resreadytime", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getResReadyTime()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getResState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resstate", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getResState()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getResVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resver", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getResVer()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterServerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterServerBase.getJSONValue((Object)pSDevCenterServerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterServerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterServerBase pSDevCenterServerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterServerBase.getCreateDate() != null) {
            object = pSDevCenterServerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getCreateMan() != null) {
            object = pSDevCenterServerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getDSType() != null) {
            object = pSDevCenterServerBase.getDSType();
            xmlNode.setAttribute(FIELD_DSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getExpriedTime() != null) {
            object = pSDevCenterServerBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getHostAddress() != null) {
            object = pSDevCenterServerBase.getHostAddress();
            xmlNode.setAttribute(FIELD_HOSTADDRESS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getHostPasswd() != null) {
            object = pSDevCenterServerBase.getHostPasswd();
            xmlNode.setAttribute(FIELD_HOSTPASSWD, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getHostUserName() != null) {
            object = pSDevCenterServerBase.getHostUserName();
            xmlNode.setAttribute(FIELD_HOSTUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getMemo() != null) {
            object = pSDevCenterServerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCClusterId() != null) {
            object = pSDevCenterServerBase.getPSDCClusterId();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCClusterName() != null) {
            object = pSDevCenterServerBase.getPSDCClusterName();
            xmlNode.setAttribute(FIELD_PSDCCLUSTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCContainerSpecId() != null) {
            object = pSDevCenterServerBase.getPSDCContainerSpecId();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCContainerSpecName() != null) {
            object = pSDevCenterServerBase.getPSDCContainerSpecName();
            xmlNode.setAttribute(FIELD_PSDCCONTAINERSPECNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCFileId() != null) {
            object = pSDevCenterServerBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDCFileName() != null) {
            object = pSDevCenterServerBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterId() != null) {
            object = pSDevCenterServerBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterName() != null) {
            object = pSDevCenterServerBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterServerId() != null) {
            object = pSDevCenterServerBase.getPSDevCenterServerId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevCenterServerName() != null) {
            object = pSDevCenterServerBase.getPSDevCenterServerName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevServerId() != null) {
            object = pSDevCenterServerBase.getPSDevServerId();
            xmlNode.setAttribute(FIELD_PSDEVSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDevServerName() != null) {
            object = pSDevCenterServerBase.getPSDevServerName();
            xmlNode.setAttribute(FIELD_PSDEVSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getPSDSBKLists() != null) {
            object = pSDevCenterServerBase.getPSDSBKLists();
            xmlNode.setAttribute(FIELD_PSDSBKLISTS, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterServerBase.getResPos() != null) {
            object = pSDevCenterServerBase.getResPos();
            xmlNode.setAttribute(FIELD_RESPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getResReadyTime() != null) {
            object = pSDevCenterServerBase.getResReadyTime();
            xmlNode.setAttribute(FIELD_RESREADYTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getResState() != null) {
            object = pSDevCenterServerBase.getResState();
            xmlNode.setAttribute(FIELD_RESSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getResVer() != null) {
            object = pSDevCenterServerBase.getResVer();
            xmlNode.setAttribute(FIELD_RESVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getUpdateDate() != null) {
            object = pSDevCenterServerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterServerBase.getUpdateMan() != null) {
            object = pSDevCenterServerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterServerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterServerBase pSDevCenterServerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterServerBase.isCreateDateDirty() && (bl || pSDevCenterServerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterServerBase.getCreateDate());
        }
        if (pSDevCenterServerBase.isCreateManDirty() && (bl || pSDevCenterServerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterServerBase.getCreateMan());
        }
        if (pSDevCenterServerBase.isDSTypeDirty() && (bl || pSDevCenterServerBase.getDSType() != null)) {
            iDataObject.set(FIELD_DSTYPE, (Object)pSDevCenterServerBase.getDSType());
        }
        if (pSDevCenterServerBase.isExpriedTimeDirty() && (bl || pSDevCenterServerBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevCenterServerBase.getExpriedTime());
        }
        if (pSDevCenterServerBase.isHostAddressDirty() && (bl || pSDevCenterServerBase.getHostAddress() != null)) {
            iDataObject.set(FIELD_HOSTADDRESS, (Object)pSDevCenterServerBase.getHostAddress());
        }
        if (pSDevCenterServerBase.isHostPasswdDirty() && (bl || pSDevCenterServerBase.getHostPasswd() != null)) {
            iDataObject.set(FIELD_HOSTPASSWD, (Object)pSDevCenterServerBase.getHostPasswd());
        }
        if (pSDevCenterServerBase.isHostUserNameDirty() && (bl || pSDevCenterServerBase.getHostUserName() != null)) {
            iDataObject.set(FIELD_HOSTUSERNAME, (Object)pSDevCenterServerBase.getHostUserName());
        }
        if (pSDevCenterServerBase.isMemoDirty() && (bl || pSDevCenterServerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevCenterServerBase.getMemo());
        }
        if (pSDevCenterServerBase.isPSDCClusterIdDirty() && (bl || pSDevCenterServerBase.getPSDCClusterId() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERID, (Object)pSDevCenterServerBase.getPSDCClusterId());
        }
        if (pSDevCenterServerBase.isPSDCClusterNameDirty() && (bl || pSDevCenterServerBase.getPSDCClusterName() != null)) {
            iDataObject.set(FIELD_PSDCCLUSTERNAME, (Object)pSDevCenterServerBase.getPSDCClusterName());
        }
        if (pSDevCenterServerBase.isPSDCContainerSpecIdDirty() && (bl || pSDevCenterServerBase.getPSDCContainerSpecId() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECID, (Object)pSDevCenterServerBase.getPSDCContainerSpecId());
        }
        if (pSDevCenterServerBase.isPSDCContainerSpecNameDirty() && (bl || pSDevCenterServerBase.getPSDCContainerSpecName() != null)) {
            iDataObject.set(FIELD_PSDCCONTAINERSPECNAME, (Object)pSDevCenterServerBase.getPSDCContainerSpecName());
        }
        if (pSDevCenterServerBase.isPSDCFileIdDirty() && (bl || pSDevCenterServerBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDevCenterServerBase.getPSDCFileId());
        }
        if (pSDevCenterServerBase.isPSDCFileNameDirty() && (bl || pSDevCenterServerBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDevCenterServerBase.getPSDCFileName());
        }
        if (pSDevCenterServerBase.isPSDevCenterIdDirty() && (bl || pSDevCenterServerBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterServerBase.getPSDevCenterId());
        }
        if (pSDevCenterServerBase.isPSDevCenterNameDirty() && (bl || pSDevCenterServerBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterServerBase.getPSDevCenterName());
        }
        if (pSDevCenterServerBase.isPSDevCenterServerIdDirty() && (bl || pSDevCenterServerBase.getPSDevCenterServerId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERID, (Object)pSDevCenterServerBase.getPSDevCenterServerId());
        }
        if (pSDevCenterServerBase.isPSDevCenterServerNameDirty() && (bl || pSDevCenterServerBase.getPSDevCenterServerName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERSERVERNAME, (Object)pSDevCenterServerBase.getPSDevCenterServerName());
        }
        if (pSDevCenterServerBase.isPSDevServerIdDirty() && (bl || pSDevCenterServerBase.getPSDevServerId() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERID, (Object)pSDevCenterServerBase.getPSDevServerId());
        }
        if (pSDevCenterServerBase.isPSDevServerNameDirty() && (bl || pSDevCenterServerBase.getPSDevServerName() != null)) {
            iDataObject.set(FIELD_PSDEVSERVERNAME, (Object)pSDevCenterServerBase.getPSDevServerName());
        }
        if (pSDevCenterServerBase.isPSDSBKListsDirty() && (bl || pSDevCenterServerBase.getPSDSBKLists() != null)) {
            iDataObject.set(FIELD_PSDSBKLISTS, (Object)pSDevCenterServerBase.getPSDSBKLists());
        }
        if (pSDevCenterServerBase.isResPosDirty() && (bl || pSDevCenterServerBase.getResPos() != null)) {
            iDataObject.set(FIELD_RESPOS, (Object)pSDevCenterServerBase.getResPos());
        }
        if (pSDevCenterServerBase.isResReadyTimeDirty() && (bl || pSDevCenterServerBase.getResReadyTime() != null)) {
            iDataObject.set(FIELD_RESREADYTIME, (Object)pSDevCenterServerBase.getResReadyTime());
        }
        if (pSDevCenterServerBase.isResStateDirty() && (bl || pSDevCenterServerBase.getResState() != null)) {
            iDataObject.set(FIELD_RESSTATE, (Object)pSDevCenterServerBase.getResState());
        }
        if (pSDevCenterServerBase.isResVerDirty() && (bl || pSDevCenterServerBase.getResVer() != null)) {
            iDataObject.set(FIELD_RESVER, (Object)pSDevCenterServerBase.getResVer());
        }
        if (pSDevCenterServerBase.isUpdateDateDirty() && (bl || pSDevCenterServerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterServerBase.getUpdateDate());
        }
        if (pSDevCenterServerBase.isUpdateManDirty() && (bl || pSDevCenterServerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterServerBase.getUpdateMan());
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
        return PSDevCenterServerBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterServerBase pSDevCenterServerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterServerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterServerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterServerBase.resetDSType();
                return true;
            }
            case 3: {
                pSDevCenterServerBase.resetExpriedTime();
                return true;
            }
            case 4: {
                pSDevCenterServerBase.resetHostAddress();
                return true;
            }
            case 5: {
                pSDevCenterServerBase.resetHostPasswd();
                return true;
            }
            case 6: {
                pSDevCenterServerBase.resetHostUserName();
                return true;
            }
            case 7: {
                pSDevCenterServerBase.resetMemo();
                return true;
            }
            case 8: {
                pSDevCenterServerBase.resetPSDCClusterId();
                return true;
            }
            case 9: {
                pSDevCenterServerBase.resetPSDCClusterName();
                return true;
            }
            case 10: {
                pSDevCenterServerBase.resetPSDCContainerSpecId();
                return true;
            }
            case 11: {
                pSDevCenterServerBase.resetPSDCContainerSpecName();
                return true;
            }
            case 12: {
                pSDevCenterServerBase.resetPSDCFileId();
                return true;
            }
            case 13: {
                pSDevCenterServerBase.resetPSDCFileName();
                return true;
            }
            case 14: {
                pSDevCenterServerBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDevCenterServerBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSDevCenterServerBase.resetPSDevCenterServerId();
                return true;
            }
            case 17: {
                pSDevCenterServerBase.resetPSDevCenterServerName();
                return true;
            }
            case 18: {
                pSDevCenterServerBase.resetPSDevServerId();
                return true;
            }
            case 19: {
                pSDevCenterServerBase.resetPSDevServerName();
                return true;
            }
            case 20: {
                pSDevCenterServerBase.resetPSDSBKLists();
                return true;
            }
            case 21: {
                pSDevCenterServerBase.resetResPos();
                return true;
            }
            case 22: {
                pSDevCenterServerBase.resetResReadyTime();
                return true;
            }
            case 23: {
                pSDevCenterServerBase.resetResState();
                return true;
            }
            case 24: {
                pSDevCenterServerBase.resetResVer();
                return true;
            }
            case 25: {
                pSDevCenterServerBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSDevCenterServerBase.resetUpdateMan();
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
                pSDCClusterService.autoGet((IEntity)pSDCCluster);
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
                pSDCContainerSpecService.autoGet((IEntity)pSDCContainerSpec);
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
                pSDCFileService.autoGet((IEntity)pSDCFile);
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevServer getPSDevServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevServer();
        }
        if (this.getPSDevServerId() == null) {
            return null;
        }
        Integer n = this.objPSDevServerLock;
        synchronized (n) {
            if (this.psdevserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevServerId(), (Object)this.psdevserver.getPSDevServerId()) != 0L) {
                this.psdevserver = null;
            }
            if (this.psdevserver == null) {
                PSDevServer pSDevServer = new PSDevServer();
                pSDevServer.setPSDevServerId(this.getPSDevServerId());
                PSDevServerService pSDevServerService = (PSDevServerService)ServiceGlobal.getService(PSDevServerService.class, (SessionFactory)this.getSessionFactory());
                pSDevServerService.autoGet((IEntity)pSDevServer);
                this.psdevserver = pSDevServer;
            }
            return this.psdevserver;
        }
    }

    private PSDevCenterServerBase getProxyEntity() {
        return this.proxyPSDevCenterServerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterServerBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterServerBase) {
            this.proxyPSDevCenterServerBase = (PSDevCenterServerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterServerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTYPE, 2);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 3);
        fieldIndexMap.put(FIELD_HOSTADDRESS, 4);
        fieldIndexMap.put(FIELD_HOSTPASSWD, 5);
        fieldIndexMap.put(FIELD_HOSTUSERNAME, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PSDCCLUSTERID, 8);
        fieldIndexMap.put(FIELD_PSDCCLUSTERNAME, 9);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECID, 10);
        fieldIndexMap.put(FIELD_PSDCCONTAINERSPECNAME, 11);
        fieldIndexMap.put(FIELD_PSDCFILEID, 12);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERID, 16);
        fieldIndexMap.put(FIELD_PSDEVCENTERSERVERNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSERVERID, 18);
        fieldIndexMap.put(FIELD_PSDEVSERVERNAME, 19);
        fieldIndexMap.put(FIELD_PSDSBKLISTS, 20);
        fieldIndexMap.put(FIELD_RESPOS, 21);
        fieldIndexMap.put(FIELD_RESREADYTIME, 22);
        fieldIndexMap.put(FIELD_RESSTATE, 23);
        fieldIndexMap.put(FIELD_RESVER, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
    }
}

