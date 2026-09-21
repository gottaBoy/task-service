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
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCTaskLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCTaskLogBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_COST = "COST";
    public static final String FIELD_COSTLEVEL = "COSTLEVEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_PSDCTASKLOGID = "PSDCTASKLOGID";
    public static final String FIELD_PSDCTASKLOGNAME = "PSDCTASKLOGNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_COST = 1;
    private static final int INDEX_COSTLEVEL = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENDTIME = 5;
    private static final int INDEX_PSDCTASKLOGID = 6;
    private static final int INDEX_PSDCTASKLOGNAME = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_PSDEVSLNID = 10;
    private static final int INDEX_PSDEVSLNNAME = 11;
    private static final int INDEX_PSDEVSLNSYSID = 12;
    private static final int INDEX_PSDEVSLNSYSNAME = 13;
    private static final int INDEX_PSTASKSERVERID = 14;
    private static final int INDEX_PSTASKSERVERNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCTaskLogBase proxyPSDCTaskLogBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean costDirtyFlag = false;
    private boolean costlevelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean psdctasklogidDirtyFlag = false;
    private boolean psdctasklognameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="cost")
    private Integer cost;
    @Column(name="costlevel")
    private Integer costlevel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="psdctasklogid")
    private String psdctasklogid;
    @Column(name="psdctasklogname")
    private String psdctasklogname;
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
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setCost(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCost(n);
            return;
        }
        this.cost = n;
        this.costDirtyFlag = true;
    }

    public Integer getCost() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCost();
        }
        return this.cost;
    }

    public boolean isCostDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCostDirty();
        }
        return this.costDirtyFlag;
    }

    public void resetCost() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCost();
            return;
        }
        this.costDirtyFlag = false;
        this.cost = null;
    }

    public void setCostLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCostLevel(n);
            return;
        }
        this.costlevel = n;
        this.costlevelDirtyFlag = true;
    }

    public Integer getCostLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCostLevel();
        }
        return this.costlevel;
    }

    public boolean isCostLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCostLevelDirty();
        }
        return this.costlevelDirtyFlag;
    }

    public void resetCostLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCostLevel();
            return;
        }
        this.costlevelDirtyFlag = false;
        this.costlevel = null;
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

    public void setPSDCTaskLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCTaskLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdctasklogid = string;
        this.psdctasklogidDirtyFlag = true;
    }

    public String getPSDCTaskLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCTaskLogId();
        }
        return this.psdctasklogid;
    }

    public boolean isPSDCTaskLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCTaskLogIdDirty();
        }
        return this.psdctasklogidDirtyFlag;
    }

    public void resetPSDCTaskLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCTaskLogId();
            return;
        }
        this.psdctasklogidDirtyFlag = false;
        this.psdctasklogid = null;
    }

    public void setPSDCTaskLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCTaskLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdctasklogname = string;
        this.psdctasklognameDirtyFlag = true;
    }

    public String getPSDCTaskLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCTaskLogName();
        }
        return this.psdctasklogname;
    }

    public boolean isPSDCTaskLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCTaskLogNameDirty();
        }
        return this.psdctasklognameDirtyFlag;
    }

    public void resetPSDCTaskLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCTaskLogName();
            return;
        }
        this.psdctasklognameDirtyFlag = false;
        this.psdctasklogname = null;
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
        PSDCTaskLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCTaskLogBase pSDCTaskLogBase) {
        pSDCTaskLogBase.resetBeginTime();
        pSDCTaskLogBase.resetCost();
        pSDCTaskLogBase.resetCostLevel();
        pSDCTaskLogBase.resetCreateDate();
        pSDCTaskLogBase.resetCreateMan();
        pSDCTaskLogBase.resetEndTime();
        pSDCTaskLogBase.resetPSDCTaskLogId();
        pSDCTaskLogBase.resetPSDCTaskLogName();
        pSDCTaskLogBase.resetPSDevCenterId();
        pSDCTaskLogBase.resetPSDevCenterName();
        pSDCTaskLogBase.resetPSDevSlnId();
        pSDCTaskLogBase.resetPSDevSlnName();
        pSDCTaskLogBase.resetPSDevSlnSysId();
        pSDCTaskLogBase.resetPSDevSlnSysName();
        pSDCTaskLogBase.resetPSTaskServerId();
        pSDCTaskLogBase.resetPSTaskServerName();
        pSDCTaskLogBase.resetUpdateDate();
        pSDCTaskLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCostDirty()) {
            hashMap.put(FIELD_COST, this.getCost());
        }
        if (!bl || this.isCostLevelDirty()) {
            hashMap.put(FIELD_COSTLEVEL, this.getCostLevel());
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
        if (!bl || this.isPSDCTaskLogIdDirty()) {
            hashMap.put(FIELD_PSDCTASKLOGID, this.getPSDCTaskLogId());
        }
        if (!bl || this.isPSDCTaskLogNameDirty()) {
            hashMap.put(FIELD_PSDCTASKLOGNAME, this.getPSDCTaskLogName());
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
        return PSDCTaskLogBase.get(this, n);
    }

    private static Object get(PSDCTaskLogBase pSDCTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCTaskLogBase.getBeginTime();
            }
            case 1: {
                return pSDCTaskLogBase.getCost();
            }
            case 2: {
                return pSDCTaskLogBase.getCostLevel();
            }
            case 3: {
                return pSDCTaskLogBase.getCreateDate();
            }
            case 4: {
                return pSDCTaskLogBase.getCreateMan();
            }
            case 5: {
                return pSDCTaskLogBase.getEndTime();
            }
            case 6: {
                return pSDCTaskLogBase.getPSDCTaskLogId();
            }
            case 7: {
                return pSDCTaskLogBase.getPSDCTaskLogName();
            }
            case 8: {
                return pSDCTaskLogBase.getPSDevCenterId();
            }
            case 9: {
                return pSDCTaskLogBase.getPSDevCenterName();
            }
            case 10: {
                return pSDCTaskLogBase.getPSDevSlnId();
            }
            case 11: {
                return pSDCTaskLogBase.getPSDevSlnName();
            }
            case 12: {
                return pSDCTaskLogBase.getPSDevSlnSysId();
            }
            case 13: {
                return pSDCTaskLogBase.getPSDevSlnSysName();
            }
            case 14: {
                return pSDCTaskLogBase.getPSTaskServerId();
            }
            case 15: {
                return pSDCTaskLogBase.getPSTaskServerName();
            }
            case 16: {
                return pSDCTaskLogBase.getUpdateDate();
            }
            case 17: {
                return pSDCTaskLogBase.getUpdateMan();
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
        PSDCTaskLogBase.set(this, n, object);
    }

    private static void set(PSDCTaskLogBase pSDCTaskLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCTaskLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCTaskLogBase.setCost(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDCTaskLogBase.setCostLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDCTaskLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCTaskLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCTaskLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCTaskLogBase.setPSDCTaskLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCTaskLogBase.setPSDCTaskLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCTaskLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCTaskLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCTaskLogBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCTaskLogBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCTaskLogBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCTaskLogBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCTaskLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCTaskLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCTaskLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDCTaskLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCTaskLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDCTaskLogBase pSDCTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCTaskLogBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCTaskLogBase.getCost() == null;
            }
            case 2: {
                return pSDCTaskLogBase.getCostLevel() == null;
            }
            case 3: {
                return pSDCTaskLogBase.getCreateDate() == null;
            }
            case 4: {
                return pSDCTaskLogBase.getCreateMan() == null;
            }
            case 5: {
                return pSDCTaskLogBase.getEndTime() == null;
            }
            case 6: {
                return pSDCTaskLogBase.getPSDCTaskLogId() == null;
            }
            case 7: {
                return pSDCTaskLogBase.getPSDCTaskLogName() == null;
            }
            case 8: {
                return pSDCTaskLogBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCTaskLogBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCTaskLogBase.getPSDevSlnId() == null;
            }
            case 11: {
                return pSDCTaskLogBase.getPSDevSlnName() == null;
            }
            case 12: {
                return pSDCTaskLogBase.getPSDevSlnSysId() == null;
            }
            case 13: {
                return pSDCTaskLogBase.getPSDevSlnSysName() == null;
            }
            case 14: {
                return pSDCTaskLogBase.getPSTaskServerId() == null;
            }
            case 15: {
                return pSDCTaskLogBase.getPSTaskServerName() == null;
            }
            case 16: {
                return pSDCTaskLogBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDCTaskLogBase.getUpdateMan() == null;
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
        return PSDCTaskLogBase.contains(this, n);
    }

    private static boolean contains(PSDCTaskLogBase pSDCTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCTaskLogBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCTaskLogBase.isCostDirty();
            }
            case 2: {
                return pSDCTaskLogBase.isCostLevelDirty();
            }
            case 3: {
                return pSDCTaskLogBase.isCreateDateDirty();
            }
            case 4: {
                return pSDCTaskLogBase.isCreateManDirty();
            }
            case 5: {
                return pSDCTaskLogBase.isEndTimeDirty();
            }
            case 6: {
                return pSDCTaskLogBase.isPSDCTaskLogIdDirty();
            }
            case 7: {
                return pSDCTaskLogBase.isPSDCTaskLogNameDirty();
            }
            case 8: {
                return pSDCTaskLogBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCTaskLogBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCTaskLogBase.isPSDevSlnIdDirty();
            }
            case 11: {
                return pSDCTaskLogBase.isPSDevSlnNameDirty();
            }
            case 12: {
                return pSDCTaskLogBase.isPSDevSlnSysIdDirty();
            }
            case 13: {
                return pSDCTaskLogBase.isPSDevSlnSysNameDirty();
            }
            case 14: {
                return pSDCTaskLogBase.isPSTaskServerIdDirty();
            }
            case 15: {
                return pSDCTaskLogBase.isPSTaskServerNameDirty();
            }
            case 16: {
                return pSDCTaskLogBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDCTaskLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCTaskLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCTaskLogBase pSDCTaskLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCTaskLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getCost() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cost", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getCost()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getCostLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"costlevel", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getCostLevel()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDCTaskLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdctasklogid", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDCTaskLogId()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDCTaskLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdctasklogname", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDCTaskLogName()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCTaskLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCTaskLogBase.getJSONValue((Object)pSDCTaskLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCTaskLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCTaskLogBase pSDCTaskLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCTaskLogBase.getBeginTime() != null) {
            object = pSDCTaskLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getCost() != null) {
            object = pSDCTaskLogBase.getCost();
            xmlNode.setAttribute(FIELD_COST, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getCostLevel() != null) {
            object = pSDCTaskLogBase.getCostLevel();
            xmlNode.setAttribute(FIELD_COSTLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getCreateDate() != null) {
            object = pSDCTaskLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getCreateMan() != null) {
            object = pSDCTaskLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getEndTime() != null) {
            object = pSDCTaskLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getPSDCTaskLogId() != null) {
            object = pSDCTaskLogBase.getPSDCTaskLogId();
            xmlNode.setAttribute(FIELD_PSDCTASKLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDCTaskLogName() != null) {
            object = pSDCTaskLogBase.getPSDCTaskLogName();
            xmlNode.setAttribute(FIELD_PSDCTASKLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevCenterId() != null) {
            object = pSDCTaskLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevCenterName() != null) {
            object = pSDCTaskLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnId() != null) {
            object = pSDCTaskLogBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnName() != null) {
            object = pSDCTaskLogBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnSysId() != null) {
            object = pSDCTaskLogBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSDevSlnSysName() != null) {
            object = pSDCTaskLogBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSTaskServerId() != null) {
            object = pSDCTaskLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getPSTaskServerName() != null) {
            object = pSDCTaskLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCTaskLogBase.getUpdateDate() != null) {
            object = pSDCTaskLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCTaskLogBase.getUpdateMan() != null) {
            object = pSDCTaskLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCTaskLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCTaskLogBase pSDCTaskLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCTaskLogBase.isBeginTimeDirty() && (bl || pSDCTaskLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCTaskLogBase.getBeginTime());
        }
        if (pSDCTaskLogBase.isCostDirty() && (bl || pSDCTaskLogBase.getCost() != null)) {
            iDataObject.set(FIELD_COST, (Object)pSDCTaskLogBase.getCost());
        }
        if (pSDCTaskLogBase.isCostLevelDirty() && (bl || pSDCTaskLogBase.getCostLevel() != null)) {
            iDataObject.set(FIELD_COSTLEVEL, (Object)pSDCTaskLogBase.getCostLevel());
        }
        if (pSDCTaskLogBase.isCreateDateDirty() && (bl || pSDCTaskLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCTaskLogBase.getCreateDate());
        }
        if (pSDCTaskLogBase.isCreateManDirty() && (bl || pSDCTaskLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCTaskLogBase.getCreateMan());
        }
        if (pSDCTaskLogBase.isEndTimeDirty() && (bl || pSDCTaskLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCTaskLogBase.getEndTime());
        }
        if (pSDCTaskLogBase.isPSDCTaskLogIdDirty() && (bl || pSDCTaskLogBase.getPSDCTaskLogId() != null)) {
            iDataObject.set(FIELD_PSDCTASKLOGID, (Object)pSDCTaskLogBase.getPSDCTaskLogId());
        }
        if (pSDCTaskLogBase.isPSDCTaskLogNameDirty() && (bl || pSDCTaskLogBase.getPSDCTaskLogName() != null)) {
            iDataObject.set(FIELD_PSDCTASKLOGNAME, (Object)pSDCTaskLogBase.getPSDCTaskLogName());
        }
        if (pSDCTaskLogBase.isPSDevCenterIdDirty() && (bl || pSDCTaskLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCTaskLogBase.getPSDevCenterId());
        }
        if (pSDCTaskLogBase.isPSDevCenterNameDirty() && (bl || pSDCTaskLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCTaskLogBase.getPSDevCenterName());
        }
        if (pSDCTaskLogBase.isPSDevSlnIdDirty() && (bl || pSDCTaskLogBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCTaskLogBase.getPSDevSlnId());
        }
        if (pSDCTaskLogBase.isPSDevSlnNameDirty() && (bl || pSDCTaskLogBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCTaskLogBase.getPSDevSlnName());
        }
        if (pSDCTaskLogBase.isPSDevSlnSysIdDirty() && (bl || pSDCTaskLogBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCTaskLogBase.getPSDevSlnSysId());
        }
        if (pSDCTaskLogBase.isPSDevSlnSysNameDirty() && (bl || pSDCTaskLogBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCTaskLogBase.getPSDevSlnSysName());
        }
        if (pSDCTaskLogBase.isPSTaskServerIdDirty() && (bl || pSDCTaskLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDCTaskLogBase.getPSTaskServerId());
        }
        if (pSDCTaskLogBase.isPSTaskServerNameDirty() && (bl || pSDCTaskLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDCTaskLogBase.getPSTaskServerName());
        }
        if (pSDCTaskLogBase.isUpdateDateDirty() && (bl || pSDCTaskLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCTaskLogBase.getUpdateDate());
        }
        if (pSDCTaskLogBase.isUpdateManDirty() && (bl || pSDCTaskLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCTaskLogBase.getUpdateMan());
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
        return PSDCTaskLogBase.remove(this, n);
    }

    private static boolean remove(PSDCTaskLogBase pSDCTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCTaskLogBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCTaskLogBase.resetCost();
                return true;
            }
            case 2: {
                pSDCTaskLogBase.resetCostLevel();
                return true;
            }
            case 3: {
                pSDCTaskLogBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDCTaskLogBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDCTaskLogBase.resetEndTime();
                return true;
            }
            case 6: {
                pSDCTaskLogBase.resetPSDCTaskLogId();
                return true;
            }
            case 7: {
                pSDCTaskLogBase.resetPSDCTaskLogName();
                return true;
            }
            case 8: {
                pSDCTaskLogBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCTaskLogBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCTaskLogBase.resetPSDevSlnId();
                return true;
            }
            case 11: {
                pSDCTaskLogBase.resetPSDevSlnName();
                return true;
            }
            case 12: {
                pSDCTaskLogBase.resetPSDevSlnSysId();
                return true;
            }
            case 13: {
                pSDCTaskLogBase.resetPSDevSlnSysName();
                return true;
            }
            case 14: {
                pSDCTaskLogBase.resetPSTaskServerId();
                return true;
            }
            case 15: {
                pSDCTaskLogBase.resetPSTaskServerName();
                return true;
            }
            case 16: {
                pSDCTaskLogBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDCTaskLogBase.resetUpdateMan();
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
                pSDevSlnService.autoGet((IEntity)pSDevSln);
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
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDCTaskLogBase getProxyEntity() {
        return this.proxyPSDCTaskLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCTaskLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCTaskLogBase) {
            this.proxyPSDCTaskLogBase = (PSDCTaskLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCTaskLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_COST, 1);
        fieldIndexMap.put(FIELD_COSTLEVEL, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENDTIME, 5);
        fieldIndexMap.put(FIELD_PSDCTASKLOGID, 6);
        fieldIndexMap.put(FIELD_PSDCTASKLOGNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 13);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 14);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

