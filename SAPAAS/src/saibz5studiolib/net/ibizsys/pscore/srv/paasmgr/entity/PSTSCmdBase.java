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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnTempl;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnTemplService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSTSCmdBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSTSCmdBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNTEMPLID = "PSDEVSLNTEMPLID";
    public static final String FIELD_PSDEVSLNTEMPLNAME = "PSDEVSLNTEMPLNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_PSTSCMDID = "PSTSCMDID";
    public static final String FIELD_PSTSCMDNAME = "PSTSCMDNAME";
    public static final String FIELD_RESULT = "RESULT";
    public static final String FIELD_RUNCMD = "RUNCMD";
    public static final String FIELD_TASKNAME = "TASKNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATA = 2;
    private static final int INDEX_PSDEVCENTERID = 3;
    private static final int INDEX_PSDEVCENTERNAME = 4;
    private static final int INDEX_PSDEVSLNID = 5;
    private static final int INDEX_PSDEVSLNNAME = 6;
    private static final int INDEX_PSDEVSLNSYSID = 7;
    private static final int INDEX_PSDEVSLNSYSNAME = 8;
    private static final int INDEX_PSDEVSLNTEMPLID = 9;
    private static final int INDEX_PSDEVSLNTEMPLNAME = 10;
    private static final int INDEX_PSTASKSERVERID = 11;
    private static final int INDEX_PSTASKSERVERNAME = 12;
    private static final int INDEX_PSTSCMDID = 13;
    private static final int INDEX_PSTSCMDNAME = 14;
    private static final int INDEX_RESULT = 15;
    private static final int INDEX_RUNCMD = 16;
    private static final int INDEX_TASKNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSTSCmdBase proxyPSTSCmdBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslntemplidDirtyFlag = false;
    private boolean psdevslntemplnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean pstscmdidDirtyFlag = false;
    private boolean pstscmdnameDirtyFlag = false;
    private boolean resultDirtyFlag = false;
    private boolean runcmdDirtyFlag = false;
    private boolean tasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="data")
    private String data;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslntemplid")
    private String psdevslntemplid;
    @Column(name="psdevslntemplname")
    private String psdevslntemplname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="pstscmdid")
    private String pstscmdid;
    @Column(name="pstscmdname")
    private String pstscmdname;
    @Column(name="result")
    private String result;
    @Column(name="runcmd")
    private String runcmd;
    @Column(name="taskname")
    private String taskname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnTemplLock = new Integer(1);
    private PSDevSlnTempl psdevslntempl = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
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

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
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

    public void setPSDevSlnTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplid = string;
        this.psdevslntemplidDirtyFlag = true;
    }

    public String getPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplId();
        }
        return this.psdevslntemplid;
    }

    public boolean isPSDevSlnTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplIdDirty();
        }
        return this.psdevslntemplidDirtyFlag;
    }

    public void resetPSDevSlnTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplId();
            return;
        }
        this.psdevslntemplidDirtyFlag = false;
        this.psdevslntemplid = null;
    }

    public void setPSDevSlnTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslntemplname = string;
        this.psdevslntemplnameDirtyFlag = true;
    }

    public String getPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTemplName();
        }
        return this.psdevslntemplname;
    }

    public boolean isPSDevSlnTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnTemplNameDirty();
        }
        return this.psdevslntemplnameDirtyFlag;
    }

    public void resetPSDevSlnTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnTemplName();
            return;
        }
        this.psdevslntemplnameDirtyFlag = false;
        this.psdevslntemplname = null;
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

    public void setPSTSCmdId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTSCmdId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstscmdid = string;
        this.pstscmdidDirtyFlag = true;
    }

    public String getPSTSCmdId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTSCmdId();
        }
        return this.pstscmdid;
    }

    public boolean isPSTSCmdIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTSCmdIdDirty();
        }
        return this.pstscmdidDirtyFlag;
    }

    public void resetPSTSCmdId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTSCmdId();
            return;
        }
        this.pstscmdidDirtyFlag = false;
        this.pstscmdid = null;
    }

    public void setPSTSCmdName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTSCmdName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstscmdname = string;
        this.pstscmdnameDirtyFlag = true;
    }

    public String getPSTSCmdName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTSCmdName();
        }
        return this.pstscmdname;
    }

    public boolean isPSTSCmdNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTSCmdNameDirty();
        }
        return this.pstscmdnameDirtyFlag;
    }

    public void resetPSTSCmdName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTSCmdName();
            return;
        }
        this.pstscmdnameDirtyFlag = false;
        this.pstscmdname = null;
    }

    public void setResult(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResult(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.result = string;
        this.resultDirtyFlag = true;
    }

    public String getResult() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResult();
        }
        return this.result;
    }

    public boolean isResultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultDirty();
        }
        return this.resultDirtyFlag;
    }

    public void resetResult() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResult();
            return;
        }
        this.resultDirtyFlag = false;
        this.result = null;
    }

    public void setRunCmd(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRunCmd(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.runcmd = string;
        this.runcmdDirtyFlag = true;
    }

    public String getRunCmd() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRunCmd();
        }
        return this.runcmd;
    }

    public boolean isRunCmdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRunCmdDirty();
        }
        return this.runcmdDirtyFlag;
    }

    public void resetRunCmd() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRunCmd();
            return;
        }
        this.runcmdDirtyFlag = false;
        this.runcmd = null;
    }

    public void setTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskname = string;
        this.tasknameDirtyFlag = true;
    }

    public String getTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskName();
        }
        return this.taskname;
    }

    public boolean isTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskNameDirty();
        }
        return this.tasknameDirtyFlag;
    }

    public void resetTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskName();
            return;
        }
        this.tasknameDirtyFlag = false;
        this.taskname = null;
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
        PSTSCmdBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSTSCmdBase pSTSCmdBase) {
        pSTSCmdBase.resetCreateDate();
        pSTSCmdBase.resetCreateMan();
        pSTSCmdBase.resetData();
        pSTSCmdBase.resetPSDevCenterId();
        pSTSCmdBase.resetPSDevCenterName();
        pSTSCmdBase.resetPSDevSlnId();
        pSTSCmdBase.resetPSDevSlnName();
        pSTSCmdBase.resetPSDevSlnSysId();
        pSTSCmdBase.resetPSDevSlnSysName();
        pSTSCmdBase.resetPSDevSlnTemplId();
        pSTSCmdBase.resetPSDevSlnTemplName();
        pSTSCmdBase.resetPSTaskServerId();
        pSTSCmdBase.resetPSTaskServerName();
        pSTSCmdBase.resetPSTSCmdId();
        pSTSCmdBase.resetPSTSCmdName();
        pSTSCmdBase.resetResult();
        pSTSCmdBase.resetRunCmd();
        pSTSCmdBase.resetTaskName();
        pSTSCmdBase.resetUpdateDate();
        pSTSCmdBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
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
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnTemplIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLID, this.getPSDevSlnTemplId());
        }
        if (!bl || this.isPSDevSlnTemplNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNTEMPLNAME, this.getPSDevSlnTemplName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isPSTSCmdIdDirty()) {
            hashMap.put(FIELD_PSTSCMDID, this.getPSTSCmdId());
        }
        if (!bl || this.isPSTSCmdNameDirty()) {
            hashMap.put(FIELD_PSTSCMDNAME, this.getPSTSCmdName());
        }
        if (!bl || this.isResultDirty()) {
            hashMap.put(FIELD_RESULT, this.getResult());
        }
        if (!bl || this.isRunCmdDirty()) {
            hashMap.put(FIELD_RUNCMD, this.getRunCmd());
        }
        if (!bl || this.isTaskNameDirty()) {
            hashMap.put(FIELD_TASKNAME, this.getTaskName());
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
        return PSTSCmdBase.get(this, n);
    }

    private static Object get(PSTSCmdBase pSTSCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTSCmdBase.getCreateDate();
            }
            case 1: {
                return pSTSCmdBase.getCreateMan();
            }
            case 2: {
                return pSTSCmdBase.getData();
            }
            case 3: {
                return pSTSCmdBase.getPSDevCenterId();
            }
            case 4: {
                return pSTSCmdBase.getPSDevCenterName();
            }
            case 5: {
                return pSTSCmdBase.getPSDevSlnId();
            }
            case 6: {
                return pSTSCmdBase.getPSDevSlnName();
            }
            case 7: {
                return pSTSCmdBase.getPSDevSlnSysId();
            }
            case 8: {
                return pSTSCmdBase.getPSDevSlnSysName();
            }
            case 9: {
                return pSTSCmdBase.getPSDevSlnTemplId();
            }
            case 10: {
                return pSTSCmdBase.getPSDevSlnTemplName();
            }
            case 11: {
                return pSTSCmdBase.getPSTaskServerId();
            }
            case 12: {
                return pSTSCmdBase.getPSTaskServerName();
            }
            case 13: {
                return pSTSCmdBase.getPSTSCmdId();
            }
            case 14: {
                return pSTSCmdBase.getPSTSCmdName();
            }
            case 15: {
                return pSTSCmdBase.getResult();
            }
            case 16: {
                return pSTSCmdBase.getRunCmd();
            }
            case 17: {
                return pSTSCmdBase.getTaskName();
            }
            case 18: {
                return pSTSCmdBase.getUpdateDate();
            }
            case 19: {
                return pSTSCmdBase.getUpdateMan();
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
        PSTSCmdBase.set(this, n, object);
    }

    private static void set(PSTSCmdBase pSTSCmdBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSTSCmdBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSTSCmdBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSTSCmdBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSTSCmdBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSTSCmdBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSTSCmdBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSTSCmdBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSTSCmdBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSTSCmdBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSTSCmdBase.setPSDevSlnTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSTSCmdBase.setPSDevSlnTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSTSCmdBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSTSCmdBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSTSCmdBase.setPSTSCmdId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSTSCmdBase.setPSTSCmdName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSTSCmdBase.setResult(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSTSCmdBase.setRunCmd(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSTSCmdBase.setTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSTSCmdBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSTSCmdBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSTSCmdBase.isNull(this, n);
    }

    private static boolean isNull(PSTSCmdBase pSTSCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTSCmdBase.getCreateDate() == null;
            }
            case 1: {
                return pSTSCmdBase.getCreateMan() == null;
            }
            case 2: {
                return pSTSCmdBase.getData() == null;
            }
            case 3: {
                return pSTSCmdBase.getPSDevCenterId() == null;
            }
            case 4: {
                return pSTSCmdBase.getPSDevCenterName() == null;
            }
            case 5: {
                return pSTSCmdBase.getPSDevSlnId() == null;
            }
            case 6: {
                return pSTSCmdBase.getPSDevSlnName() == null;
            }
            case 7: {
                return pSTSCmdBase.getPSDevSlnSysId() == null;
            }
            case 8: {
                return pSTSCmdBase.getPSDevSlnSysName() == null;
            }
            case 9: {
                return pSTSCmdBase.getPSDevSlnTemplId() == null;
            }
            case 10: {
                return pSTSCmdBase.getPSDevSlnTemplName() == null;
            }
            case 11: {
                return pSTSCmdBase.getPSTaskServerId() == null;
            }
            case 12: {
                return pSTSCmdBase.getPSTaskServerName() == null;
            }
            case 13: {
                return pSTSCmdBase.getPSTSCmdId() == null;
            }
            case 14: {
                return pSTSCmdBase.getPSTSCmdName() == null;
            }
            case 15: {
                return pSTSCmdBase.getResult() == null;
            }
            case 16: {
                return pSTSCmdBase.getRunCmd() == null;
            }
            case 17: {
                return pSTSCmdBase.getTaskName() == null;
            }
            case 18: {
                return pSTSCmdBase.getUpdateDate() == null;
            }
            case 19: {
                return pSTSCmdBase.getUpdateMan() == null;
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
        return PSTSCmdBase.contains(this, n);
    }

    private static boolean contains(PSTSCmdBase pSTSCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSTSCmdBase.isCreateDateDirty();
            }
            case 1: {
                return pSTSCmdBase.isCreateManDirty();
            }
            case 2: {
                return pSTSCmdBase.isDataDirty();
            }
            case 3: {
                return pSTSCmdBase.isPSDevCenterIdDirty();
            }
            case 4: {
                return pSTSCmdBase.isPSDevCenterNameDirty();
            }
            case 5: {
                return pSTSCmdBase.isPSDevSlnIdDirty();
            }
            case 6: {
                return pSTSCmdBase.isPSDevSlnNameDirty();
            }
            case 7: {
                return pSTSCmdBase.isPSDevSlnSysIdDirty();
            }
            case 8: {
                return pSTSCmdBase.isPSDevSlnSysNameDirty();
            }
            case 9: {
                return pSTSCmdBase.isPSDevSlnTemplIdDirty();
            }
            case 10: {
                return pSTSCmdBase.isPSDevSlnTemplNameDirty();
            }
            case 11: {
                return pSTSCmdBase.isPSTaskServerIdDirty();
            }
            case 12: {
                return pSTSCmdBase.isPSTaskServerNameDirty();
            }
            case 13: {
                return pSTSCmdBase.isPSTSCmdIdDirty();
            }
            case 14: {
                return pSTSCmdBase.isPSTSCmdNameDirty();
            }
            case 15: {
                return pSTSCmdBase.isResultDirty();
            }
            case 16: {
                return pSTSCmdBase.isRunCmdDirty();
            }
            case 17: {
                return pSTSCmdBase.isTaskNameDirty();
            }
            case 18: {
                return pSTSCmdBase.isUpdateDateDirty();
            }
            case 19: {
                return pSTSCmdBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSTSCmdBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSTSCmdBase pSTSCmdBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSTSCmdBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getData()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnTemplId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSDevSlnTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslntemplname", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSDevSlnTemplName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSTSCmdId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstscmdid", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSTSCmdId()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getPSTSCmdName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstscmdname", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getPSTSCmdName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getResult() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"result", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getResult()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getRunCmd() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"runcmd", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getRunCmd()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskname", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getTaskName()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSTSCmdBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSTSCmdBase.getJSONValue((Object)pSTSCmdBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSTSCmdBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSTSCmdBase pSTSCmdBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSTSCmdBase.getCreateDate() != null) {
            object = pSTSCmdBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTSCmdBase.getCreateMan() != null) {
            object = pSTSCmdBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getData() != null) {
            object = pSTSCmdBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevCenterId() != null) {
            object = pSTSCmdBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevCenterName() != null) {
            object = pSTSCmdBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnId() != null) {
            object = pSTSCmdBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnName() != null) {
            object = pSTSCmdBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnSysId() != null) {
            object = pSTSCmdBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnSysName() != null) {
            object = pSTSCmdBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnTemplId() != null) {
            object = pSTSCmdBase.getPSDevSlnTemplId();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSDevSlnTemplName() != null) {
            object = pSTSCmdBase.getPSDevSlnTemplName();
            xmlNode.setAttribute(FIELD_PSDEVSLNTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSTaskServerId() != null) {
            object = pSTSCmdBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSTaskServerName() != null) {
            object = pSTSCmdBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSTSCmdId() != null) {
            object = pSTSCmdBase.getPSTSCmdId();
            xmlNode.setAttribute(FIELD_PSTSCMDID, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getPSTSCmdName() != null) {
            object = pSTSCmdBase.getPSTSCmdName();
            xmlNode.setAttribute(FIELD_PSTSCMDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getResult() != null) {
            object = pSTSCmdBase.getResult();
            xmlNode.setAttribute(FIELD_RESULT, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getRunCmd() != null) {
            object = pSTSCmdBase.getRunCmd();
            xmlNode.setAttribute(FIELD_RUNCMD, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getTaskName() != null) {
            object = pSTSCmdBase.getTaskName();
            xmlNode.setAttribute(FIELD_TASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSTSCmdBase.getUpdateDate() != null) {
            object = pSTSCmdBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSTSCmdBase.getUpdateMan() != null) {
            object = pSTSCmdBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSTSCmdBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSTSCmdBase pSTSCmdBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSTSCmdBase.isCreateDateDirty() && (bl || pSTSCmdBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSTSCmdBase.getCreateDate());
        }
        if (pSTSCmdBase.isCreateManDirty() && (bl || pSTSCmdBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSTSCmdBase.getCreateMan());
        }
        if (pSTSCmdBase.isDataDirty() && (bl || pSTSCmdBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSTSCmdBase.getData());
        }
        if (pSTSCmdBase.isPSDevCenterIdDirty() && (bl || pSTSCmdBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSTSCmdBase.getPSDevCenterId());
        }
        if (pSTSCmdBase.isPSDevCenterNameDirty() && (bl || pSTSCmdBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSTSCmdBase.getPSDevCenterName());
        }
        if (pSTSCmdBase.isPSDevSlnIdDirty() && (bl || pSTSCmdBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSTSCmdBase.getPSDevSlnId());
        }
        if (pSTSCmdBase.isPSDevSlnNameDirty() && (bl || pSTSCmdBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSTSCmdBase.getPSDevSlnName());
        }
        if (pSTSCmdBase.isPSDevSlnSysIdDirty() && (bl || pSTSCmdBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSTSCmdBase.getPSDevSlnSysId());
        }
        if (pSTSCmdBase.isPSDevSlnSysNameDirty() && (bl || pSTSCmdBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSTSCmdBase.getPSDevSlnSysName());
        }
        if (pSTSCmdBase.isPSDevSlnTemplIdDirty() && (bl || pSTSCmdBase.getPSDevSlnTemplId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLID, (Object)pSTSCmdBase.getPSDevSlnTemplId());
        }
        if (pSTSCmdBase.isPSDevSlnTemplNameDirty() && (bl || pSTSCmdBase.getPSDevSlnTemplName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNTEMPLNAME, (Object)pSTSCmdBase.getPSDevSlnTemplName());
        }
        if (pSTSCmdBase.isPSTaskServerIdDirty() && (bl || pSTSCmdBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSTSCmdBase.getPSTaskServerId());
        }
        if (pSTSCmdBase.isPSTaskServerNameDirty() && (bl || pSTSCmdBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSTSCmdBase.getPSTaskServerName());
        }
        if (pSTSCmdBase.isPSTSCmdIdDirty() && (bl || pSTSCmdBase.getPSTSCmdId() != null)) {
            iDataObject.set(FIELD_PSTSCMDID, (Object)pSTSCmdBase.getPSTSCmdId());
        }
        if (pSTSCmdBase.isPSTSCmdNameDirty() && (bl || pSTSCmdBase.getPSTSCmdName() != null)) {
            iDataObject.set(FIELD_PSTSCMDNAME, (Object)pSTSCmdBase.getPSTSCmdName());
        }
        if (pSTSCmdBase.isResultDirty() && (bl || pSTSCmdBase.getResult() != null)) {
            iDataObject.set(FIELD_RESULT, (Object)pSTSCmdBase.getResult());
        }
        if (pSTSCmdBase.isRunCmdDirty() && (bl || pSTSCmdBase.getRunCmd() != null)) {
            iDataObject.set(FIELD_RUNCMD, (Object)pSTSCmdBase.getRunCmd());
        }
        if (pSTSCmdBase.isTaskNameDirty() && (bl || pSTSCmdBase.getTaskName() != null)) {
            iDataObject.set(FIELD_TASKNAME, (Object)pSTSCmdBase.getTaskName());
        }
        if (pSTSCmdBase.isUpdateDateDirty() && (bl || pSTSCmdBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSTSCmdBase.getUpdateDate());
        }
        if (pSTSCmdBase.isUpdateManDirty() && (bl || pSTSCmdBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSTSCmdBase.getUpdateMan());
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
        return PSTSCmdBase.remove(this, n);
    }

    private static boolean remove(PSTSCmdBase pSTSCmdBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSTSCmdBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSTSCmdBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSTSCmdBase.resetData();
                return true;
            }
            case 3: {
                pSTSCmdBase.resetPSDevCenterId();
                return true;
            }
            case 4: {
                pSTSCmdBase.resetPSDevCenterName();
                return true;
            }
            case 5: {
                pSTSCmdBase.resetPSDevSlnId();
                return true;
            }
            case 6: {
                pSTSCmdBase.resetPSDevSlnName();
                return true;
            }
            case 7: {
                pSTSCmdBase.resetPSDevSlnSysId();
                return true;
            }
            case 8: {
                pSTSCmdBase.resetPSDevSlnSysName();
                return true;
            }
            case 9: {
                pSTSCmdBase.resetPSDevSlnTemplId();
                return true;
            }
            case 10: {
                pSTSCmdBase.resetPSDevSlnTemplName();
                return true;
            }
            case 11: {
                pSTSCmdBase.resetPSTaskServerId();
                return true;
            }
            case 12: {
                pSTSCmdBase.resetPSTaskServerName();
                return true;
            }
            case 13: {
                pSTSCmdBase.resetPSTSCmdId();
                return true;
            }
            case 14: {
                pSTSCmdBase.resetPSTSCmdName();
                return true;
            }
            case 15: {
                pSTSCmdBase.resetResult();
                return true;
            }
            case 16: {
                pSTSCmdBase.resetRunCmd();
                return true;
            }
            case 17: {
                pSTSCmdBase.resetTaskName();
                return true;
            }
            case 18: {
                pSTSCmdBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSTSCmdBase.resetUpdateMan();
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
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnTempl getPSDevSlnTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnTempl();
        }
        if (this.getPSDevSlnTemplId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnTemplLock;
        synchronized (n) {
            if (this.psdevslntempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnTemplId(), (Object)this.psdevslntempl.getPSDevSlnTemplId()) != 0L) {
                this.psdevslntempl = null;
            }
            if (this.psdevslntempl == null) {
                PSDevSlnTempl pSDevSlnTempl = new PSDevSlnTempl();
                pSDevSlnTempl.setPSDevSlnTemplId(this.getPSDevSlnTemplId());
                PSDevSlnTemplService pSDevSlnTemplService = (PSDevSlnTemplService)ServiceGlobal.getService(PSDevSlnTemplService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnTemplService.autoGet(pSDevSlnTempl);
                this.psdevslntempl = pSDevSlnTempl;
            }
            return this.psdevslntempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
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

    private PSTSCmdBase getProxyEntity() {
        return this.proxyPSTSCmdBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSTSCmdBase = null;
        if (iDataObject != null && iDataObject instanceof PSTSCmdBase) {
            this.proxyPSTSCmdBase = (PSTSCmdBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSTSCmdService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATA, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNTEMPLNAME, 10);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 11);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 12);
        fieldIndexMap.put(FIELD_PSTSCMDID, 13);
        fieldIndexMap.put(FIELD_PSTSCMDNAME, 14);
        fieldIndexMap.put(FIELD_RESULT, 15);
        fieldIndexMap.put(FIELD_RUNCMD, 16);
        fieldIndexMap.put(FIELD_TASKNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
    }
}

