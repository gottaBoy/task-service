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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSBKTaskLog;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSBKTaskLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBKTaskLogBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSBKTASKLOGID = "PPSBKTASKLOGID";
    public static final String FIELD_PPSBKTASKLOGNAME = "PPSBKTASKLOGNAME";
    public static final String FIELD_PSBKTASKLOGID = "PSBKTASKLOGID";
    public static final String FIELD_PSBKTASKLOGNAME = "PSBKTASKLOGNAME";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_RESULTINFO = "RESULTINFO";
    public static final String FIELD_TASKCAT = "TASKCAT";
    public static final String FIELD_TASKPARAM = "TASKPARAM";
    public static final String FIELD_TASKPARAM2 = "TASKPARAM2";
    public static final String FIELD_TASKPARAM3 = "TASKPARAM3";
    public static final String FIELD_TASKPARAM4 = "TASKPARAM4";
    public static final String FIELD_TASKSTATE = "TASKSTATE";
    public static final String FIELD_TASKTYPE = "TASKTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEROBOTFLAG = "USEROBOTFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PPSBKTASKLOGID = 5;
    private static final int INDEX_PPSBKTASKLOGNAME = 6;
    private static final int INDEX_PSBKTASKLOGID = 7;
    private static final int INDEX_PSBKTASKLOGNAME = 8;
    private static final int INDEX_PSDCROBOTID = 9;
    private static final int INDEX_PSDCROBOTNAME = 10;
    private static final int INDEX_PSDEVCENTERID = 11;
    private static final int INDEX_PSDEVCENTERNAME = 12;
    private static final int INDEX_PSDEVSLNSYSID = 13;
    private static final int INDEX_PSDEVSLNSYSNAME = 14;
    private static final int INDEX_PSDSCONSOLEID = 15;
    private static final int INDEX_PSDYNAINSTID = 16;
    private static final int INDEX_PSTASKSERVERID = 17;
    private static final int INDEX_PSTASKSERVERNAME = 18;
    private static final int INDEX_REMOTEADDR = 19;
    private static final int INDEX_RESULTINFO = 20;
    private static final int INDEX_TASKCAT = 21;
    private static final int INDEX_TASKPARAM = 22;
    private static final int INDEX_TASKPARAM2 = 23;
    private static final int INDEX_TASKPARAM3 = 24;
    private static final int INDEX_TASKPARAM4 = 25;
    private static final int INDEX_TASKSTATE = 26;
    private static final int INDEX_TASKTYPE = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USEROBOTFLAG = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBKTaskLogBase proxyPSBKTaskLogBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsbktasklogidDirtyFlag = false;
    private boolean ppsbktasklognameDirtyFlag = false;
    private boolean psbktasklogidDirtyFlag = false;
    private boolean psbktasklognameDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean resultinfoDirtyFlag = false;
    private boolean taskcatDirtyFlag = false;
    private boolean taskparamDirtyFlag = false;
    private boolean taskparam2DirtyFlag = false;
    private boolean taskparam3DirtyFlag = false;
    private boolean taskparam4DirtyFlag = false;
    private boolean taskstateDirtyFlag = false;
    private boolean tasktypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userobotflagDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsbktasklogid")
    private String ppsbktasklogid;
    @Column(name="ppsbktasklogname")
    private String ppsbktasklogname;
    @Column(name="psbktasklogid")
    private String psbktasklogid;
    @Column(name="psbktasklogname")
    private String psbktasklogname;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="resultinfo")
    private String resultinfo;
    @Column(name="taskcat")
    private String taskcat;
    @Column(name="taskparam")
    private String taskparam;
    @Column(name="taskparam2")
    private String taskparam2;
    @Column(name="taskparam3")
    private String taskparam3;
    @Column(name="taskparam4")
    private String taskparam4;
    @Column(name="taskstate")
    private Integer taskstate;
    @Column(name="tasktype")
    private String tasktype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userobotflag")
    private Integer userobotflag;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    private Integer objPPSBKTaskLogLock = new Integer(1);
    private PSBKTaskLog ppsbktasklog = null;
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPPSBKTaskLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSBKTaskLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsbktasklogid = string;
        this.ppsbktasklogidDirtyFlag = true;
    }

    public String getPPSBKTaskLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSBKTaskLogId();
        }
        return this.ppsbktasklogid;
    }

    public boolean isPPSBKTaskLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSBKTaskLogIdDirty();
        }
        return this.ppsbktasklogidDirtyFlag;
    }

    public void resetPPSBKTaskLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSBKTaskLogId();
            return;
        }
        this.ppsbktasklogidDirtyFlag = false;
        this.ppsbktasklogid = null;
    }

    public void setPPSBKTaskLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSBKTaskLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsbktasklogname = string;
        this.ppsbktasklognameDirtyFlag = true;
    }

    public String getPPSBKTaskLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSBKTaskLogName();
        }
        return this.ppsbktasklogname;
    }

    public boolean isPPSBKTaskLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSBKTaskLogNameDirty();
        }
        return this.ppsbktasklognameDirtyFlag;
    }

    public void resetPPSBKTaskLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSBKTaskLogName();
            return;
        }
        this.ppsbktasklognameDirtyFlag = false;
        this.ppsbktasklogname = null;
    }

    public void setPSBKTaskLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBKTaskLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbktasklogid = string;
        this.psbktasklogidDirtyFlag = true;
    }

    public String getPSBKTaskLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBKTaskLogId();
        }
        return this.psbktasklogid;
    }

    public boolean isPSBKTaskLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBKTaskLogIdDirty();
        }
        return this.psbktasklogidDirtyFlag;
    }

    public void resetPSBKTaskLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBKTaskLogId();
            return;
        }
        this.psbktasklogidDirtyFlag = false;
        this.psbktasklogid = null;
    }

    public void setPSBKTaskLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBKTaskLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbktasklogname = string;
        this.psbktasklognameDirtyFlag = true;
    }

    public String getPSBKTaskLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBKTaskLogName();
        }
        return this.psbktasklogname;
    }

    public boolean isPSBKTaskLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBKTaskLogNameDirty();
        }
        return this.psbktasklognameDirtyFlag;
    }

    public void resetPSBKTaskLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBKTaskLogName();
            return;
        }
        this.psbktasklognameDirtyFlag = false;
        this.psbktasklogname = null;
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

    public void setPSDSConsoleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDSConsoleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdsconsoleid = string;
        this.psdsconsoleidDirtyFlag = true;
    }

    public String getPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDSConsoleId();
        }
        return this.psdsconsoleid;
    }

    public boolean isPSDSConsoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDSConsoleIdDirty();
        }
        return this.psdsconsoleidDirtyFlag;
    }

    public void resetPSDSConsoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDSConsoleId();
            return;
        }
        this.psdsconsoleidDirtyFlag = false;
        this.psdsconsoleid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
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

    public void setRemoteAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoteAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.remoteaddr = string;
        this.remoteaddrDirtyFlag = true;
    }

    public String getRemoteAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoteAddr();
        }
        return this.remoteaddr;
    }

    public boolean isRemoteAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoteAddrDirty();
        }
        return this.remoteaddrDirtyFlag;
    }

    public void resetRemoteAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoteAddr();
            return;
        }
        this.remoteaddrDirtyFlag = false;
        this.remoteaddr = null;
    }

    public void setResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.resultinfo = string;
        this.resultinfoDirtyFlag = true;
    }

    public String getResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getResultInfo();
        }
        return this.resultinfo;
    }

    public boolean isResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isResultInfoDirty();
        }
        return this.resultinfoDirtyFlag;
    }

    public void resetResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetResultInfo();
            return;
        }
        this.resultinfoDirtyFlag = false;
        this.resultinfo = null;
    }

    public void setTaskCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskcat = string;
        this.taskcatDirtyFlag = true;
    }

    public String getTaskCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskCat();
        }
        return this.taskcat;
    }

    public boolean isTaskCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskCatDirty();
        }
        return this.taskcatDirtyFlag;
    }

    public void resetTaskCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskCat();
            return;
        }
        this.taskcatDirtyFlag = false;
        this.taskcat = null;
    }

    public void setTaskParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskparam = string;
        this.taskparamDirtyFlag = true;
    }

    public String getTaskParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParam();
        }
        return this.taskparam;
    }

    public boolean isTaskParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParamDirty();
        }
        return this.taskparamDirtyFlag;
    }

    public void resetTaskParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParam();
            return;
        }
        this.taskparamDirtyFlag = false;
        this.taskparam = null;
    }

    public void setTaskParam2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParam2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskparam2 = string;
        this.taskparam2DirtyFlag = true;
    }

    public String getTaskParam2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParam2();
        }
        return this.taskparam2;
    }

    public boolean isTaskParam2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParam2Dirty();
        }
        return this.taskparam2DirtyFlag;
    }

    public void resetTaskParam2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParam2();
            return;
        }
        this.taskparam2DirtyFlag = false;
        this.taskparam2 = null;
    }

    public void setTaskParam3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParam3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskparam3 = string;
        this.taskparam3DirtyFlag = true;
    }

    public String getTaskParam3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParam3();
        }
        return this.taskparam3;
    }

    public boolean isTaskParam3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParam3Dirty();
        }
        return this.taskparam3DirtyFlag;
    }

    public void resetTaskParam3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParam3();
            return;
        }
        this.taskparam3DirtyFlag = false;
        this.taskparam3 = null;
    }

    public void setTaskParam4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParam4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskparam4 = string;
        this.taskparam4DirtyFlag = true;
    }

    public String getTaskParam4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParam4();
        }
        return this.taskparam4;
    }

    public boolean isTaskParam4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParam4Dirty();
        }
        return this.taskparam4DirtyFlag;
    }

    public void resetTaskParam4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParam4();
            return;
        }
        this.taskparam4DirtyFlag = false;
        this.taskparam4 = null;
    }

    public void setTaskState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskState(n);
            return;
        }
        this.taskstate = n;
        this.taskstateDirtyFlag = true;
    }

    public Integer getTaskState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskState();
        }
        return this.taskstate;
    }

    public boolean isTaskStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskStateDirty();
        }
        return this.taskstateDirtyFlag;
    }

    public void resetTaskState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskState();
            return;
        }
        this.taskstateDirtyFlag = false;
        this.taskstate = null;
    }

    public void setTaskType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tasktype = string;
        this.tasktypeDirtyFlag = true;
    }

    public String getTaskType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskType();
        }
        return this.tasktype;
    }

    public boolean isTaskTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskTypeDirty();
        }
        return this.tasktypeDirtyFlag;
    }

    public void resetTaskType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskType();
            return;
        }
        this.tasktypeDirtyFlag = false;
        this.tasktype = null;
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

    public void setUseRobotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUseRobotFlag(n);
            return;
        }
        this.userobotflag = n;
        this.userobotflagDirtyFlag = true;
    }

    public Integer getUseRobotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUseRobotFlag();
        }
        return this.userobotflag;
    }

    public boolean isUseRobotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUseRobotFlagDirty();
        }
        return this.userobotflagDirtyFlag;
    }

    public void resetUseRobotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUseRobotFlag();
            return;
        }
        this.userobotflagDirtyFlag = false;
        this.userobotflag = null;
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

    protected void onReset() {
        PSBKTaskLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBKTaskLogBase pSBKTaskLogBase) {
        pSBKTaskLogBase.resetBeginTime();
        pSBKTaskLogBase.resetCreateDate();
        pSBKTaskLogBase.resetCreateMan();
        pSBKTaskLogBase.resetEndTime();
        pSBKTaskLogBase.resetOrderValue();
        pSBKTaskLogBase.resetPPSBKTaskLogId();
        pSBKTaskLogBase.resetPPSBKTaskLogName();
        pSBKTaskLogBase.resetPSBKTaskLogId();
        pSBKTaskLogBase.resetPSBKTaskLogName();
        pSBKTaskLogBase.resetPSDCRobotId();
        pSBKTaskLogBase.resetPSDCRobotName();
        pSBKTaskLogBase.resetPSDevCenterId();
        pSBKTaskLogBase.resetPSDevCenterName();
        pSBKTaskLogBase.resetPSDevSlnSysId();
        pSBKTaskLogBase.resetPSDevSlnSysName();
        pSBKTaskLogBase.resetPSDSConsoleId();
        pSBKTaskLogBase.resetPSDynaInstId();
        pSBKTaskLogBase.resetPSTaskServerId();
        pSBKTaskLogBase.resetPSTaskServerName();
        pSBKTaskLogBase.resetRemoteAddr();
        pSBKTaskLogBase.resetResultInfo();
        pSBKTaskLogBase.resetTaskCat();
        pSBKTaskLogBase.resetTaskParam();
        pSBKTaskLogBase.resetTaskParam2();
        pSBKTaskLogBase.resetTaskParam3();
        pSBKTaskLogBase.resetTaskParam4();
        pSBKTaskLogBase.resetTaskState();
        pSBKTaskLogBase.resetTaskType();
        pSBKTaskLogBase.resetUpdateDate();
        pSBKTaskLogBase.resetUpdateMan();
        pSBKTaskLogBase.resetUseRobotFlag();
        pSBKTaskLogBase.resetUserTag();
        pSBKTaskLogBase.resetUserTag2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSBKTaskLogIdDirty()) {
            hashMap.put(FIELD_PPSBKTASKLOGID, this.getPPSBKTaskLogId());
        }
        if (!bl || this.isPPSBKTaskLogNameDirty()) {
            hashMap.put(FIELD_PPSBKTASKLOGNAME, this.getPPSBKTaskLogName());
        }
        if (!bl || this.isPSBKTaskLogIdDirty()) {
            hashMap.put(FIELD_PSBKTASKLOGID, this.getPSBKTaskLogId());
        }
        if (!bl || this.isPSBKTaskLogNameDirty()) {
            hashMap.put(FIELD_PSBKTASKLOGNAME, this.getPSBKTaskLogName());
        }
        if (!bl || this.isPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTID, this.getPSDCRobotId());
        }
        if (!bl || this.isPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTNAME, this.getPSDCRobotName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isRemoteAddrDirty()) {
            hashMap.put(FIELD_REMOTEADDR, this.getRemoteAddr());
        }
        if (!bl || this.isResultInfoDirty()) {
            hashMap.put(FIELD_RESULTINFO, this.getResultInfo());
        }
        if (!bl || this.isTaskCatDirty()) {
            hashMap.put(FIELD_TASKCAT, this.getTaskCat());
        }
        if (!bl || this.isTaskParamDirty()) {
            hashMap.put(FIELD_TASKPARAM, this.getTaskParam());
        }
        if (!bl || this.isTaskParam2Dirty()) {
            hashMap.put(FIELD_TASKPARAM2, this.getTaskParam2());
        }
        if (!bl || this.isTaskParam3Dirty()) {
            hashMap.put(FIELD_TASKPARAM3, this.getTaskParam3());
        }
        if (!bl || this.isTaskParam4Dirty()) {
            hashMap.put(FIELD_TASKPARAM4, this.getTaskParam4());
        }
        if (!bl || this.isTaskStateDirty()) {
            hashMap.put(FIELD_TASKSTATE, this.getTaskState());
        }
        if (!bl || this.isTaskTypeDirty()) {
            hashMap.put(FIELD_TASKTYPE, this.getTaskType());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUseRobotFlagDirty()) {
            hashMap.put(FIELD_USEROBOTFLAG, this.getUseRobotFlag());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSBKTaskLogBase.get(this, n);
    }

    private static Object get(PSBKTaskLogBase pSBKTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBKTaskLogBase.getBeginTime();
            }
            case 1: {
                return pSBKTaskLogBase.getCreateDate();
            }
            case 2: {
                return pSBKTaskLogBase.getCreateMan();
            }
            case 3: {
                return pSBKTaskLogBase.getEndTime();
            }
            case 4: {
                return pSBKTaskLogBase.getOrderValue();
            }
            case 5: {
                return pSBKTaskLogBase.getPPSBKTaskLogId();
            }
            case 6: {
                return pSBKTaskLogBase.getPPSBKTaskLogName();
            }
            case 7: {
                return pSBKTaskLogBase.getPSBKTaskLogId();
            }
            case 8: {
                return pSBKTaskLogBase.getPSBKTaskLogName();
            }
            case 9: {
                return pSBKTaskLogBase.getPSDCRobotId();
            }
            case 10: {
                return pSBKTaskLogBase.getPSDCRobotName();
            }
            case 11: {
                return pSBKTaskLogBase.getPSDevCenterId();
            }
            case 12: {
                return pSBKTaskLogBase.getPSDevCenterName();
            }
            case 13: {
                return pSBKTaskLogBase.getPSDevSlnSysId();
            }
            case 14: {
                return pSBKTaskLogBase.getPSDevSlnSysName();
            }
            case 15: {
                return pSBKTaskLogBase.getPSDSConsoleId();
            }
            case 16: {
                return pSBKTaskLogBase.getPSDynaInstId();
            }
            case 17: {
                return pSBKTaskLogBase.getPSTaskServerId();
            }
            case 18: {
                return pSBKTaskLogBase.getPSTaskServerName();
            }
            case 19: {
                return pSBKTaskLogBase.getRemoteAddr();
            }
            case 20: {
                return pSBKTaskLogBase.getResultInfo();
            }
            case 21: {
                return pSBKTaskLogBase.getTaskCat();
            }
            case 22: {
                return pSBKTaskLogBase.getTaskParam();
            }
            case 23: {
                return pSBKTaskLogBase.getTaskParam2();
            }
            case 24: {
                return pSBKTaskLogBase.getTaskParam3();
            }
            case 25: {
                return pSBKTaskLogBase.getTaskParam4();
            }
            case 26: {
                return pSBKTaskLogBase.getTaskState();
            }
            case 27: {
                return pSBKTaskLogBase.getTaskType();
            }
            case 28: {
                return pSBKTaskLogBase.getUpdateDate();
            }
            case 29: {
                return pSBKTaskLogBase.getUpdateMan();
            }
            case 30: {
                return pSBKTaskLogBase.getUseRobotFlag();
            }
            case 31: {
                return pSBKTaskLogBase.getUserTag();
            }
            case 32: {
                return pSBKTaskLogBase.getUserTag2();
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
        PSBKTaskLogBase.set(this, n, object);
    }

    private static void set(PSBKTaskLogBase pSBKTaskLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBKTaskLogBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSBKTaskLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSBKTaskLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBKTaskLogBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSBKTaskLogBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSBKTaskLogBase.setPPSBKTaskLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBKTaskLogBase.setPPSBKTaskLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSBKTaskLogBase.setPSBKTaskLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSBKTaskLogBase.setPSBKTaskLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSBKTaskLogBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSBKTaskLogBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSBKTaskLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSBKTaskLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSBKTaskLogBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSBKTaskLogBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSBKTaskLogBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSBKTaskLogBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSBKTaskLogBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSBKTaskLogBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSBKTaskLogBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSBKTaskLogBase.setResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSBKTaskLogBase.setTaskCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSBKTaskLogBase.setTaskParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSBKTaskLogBase.setTaskParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSBKTaskLogBase.setTaskParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSBKTaskLogBase.setTaskParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSBKTaskLogBase.setTaskState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSBKTaskLogBase.setTaskType(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSBKTaskLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSBKTaskLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSBKTaskLogBase.setUseRobotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 31: {
                pSBKTaskLogBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSBKTaskLogBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSBKTaskLogBase.isNull(this, n);
    }

    private static boolean isNull(PSBKTaskLogBase pSBKTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBKTaskLogBase.getBeginTime() == null;
            }
            case 1: {
                return pSBKTaskLogBase.getCreateDate() == null;
            }
            case 2: {
                return pSBKTaskLogBase.getCreateMan() == null;
            }
            case 3: {
                return pSBKTaskLogBase.getEndTime() == null;
            }
            case 4: {
                return pSBKTaskLogBase.getOrderValue() == null;
            }
            case 5: {
                return pSBKTaskLogBase.getPPSBKTaskLogId() == null;
            }
            case 6: {
                return pSBKTaskLogBase.getPPSBKTaskLogName() == null;
            }
            case 7: {
                return pSBKTaskLogBase.getPSBKTaskLogId() == null;
            }
            case 8: {
                return pSBKTaskLogBase.getPSBKTaskLogName() == null;
            }
            case 9: {
                return pSBKTaskLogBase.getPSDCRobotId() == null;
            }
            case 10: {
                return pSBKTaskLogBase.getPSDCRobotName() == null;
            }
            case 11: {
                return pSBKTaskLogBase.getPSDevCenterId() == null;
            }
            case 12: {
                return pSBKTaskLogBase.getPSDevCenterName() == null;
            }
            case 13: {
                return pSBKTaskLogBase.getPSDevSlnSysId() == null;
            }
            case 14: {
                return pSBKTaskLogBase.getPSDevSlnSysName() == null;
            }
            case 15: {
                return pSBKTaskLogBase.getPSDSConsoleId() == null;
            }
            case 16: {
                return pSBKTaskLogBase.getPSDynaInstId() == null;
            }
            case 17: {
                return pSBKTaskLogBase.getPSTaskServerId() == null;
            }
            case 18: {
                return pSBKTaskLogBase.getPSTaskServerName() == null;
            }
            case 19: {
                return pSBKTaskLogBase.getRemoteAddr() == null;
            }
            case 20: {
                return pSBKTaskLogBase.getResultInfo() == null;
            }
            case 21: {
                return pSBKTaskLogBase.getTaskCat() == null;
            }
            case 22: {
                return pSBKTaskLogBase.getTaskParam() == null;
            }
            case 23: {
                return pSBKTaskLogBase.getTaskParam2() == null;
            }
            case 24: {
                return pSBKTaskLogBase.getTaskParam3() == null;
            }
            case 25: {
                return pSBKTaskLogBase.getTaskParam4() == null;
            }
            case 26: {
                return pSBKTaskLogBase.getTaskState() == null;
            }
            case 27: {
                return pSBKTaskLogBase.getTaskType() == null;
            }
            case 28: {
                return pSBKTaskLogBase.getUpdateDate() == null;
            }
            case 29: {
                return pSBKTaskLogBase.getUpdateMan() == null;
            }
            case 30: {
                return pSBKTaskLogBase.getUseRobotFlag() == null;
            }
            case 31: {
                return pSBKTaskLogBase.getUserTag() == null;
            }
            case 32: {
                return pSBKTaskLogBase.getUserTag2() == null;
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
        return PSBKTaskLogBase.contains(this, n);
    }

    private static boolean contains(PSBKTaskLogBase pSBKTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBKTaskLogBase.isBeginTimeDirty();
            }
            case 1: {
                return pSBKTaskLogBase.isCreateDateDirty();
            }
            case 2: {
                return pSBKTaskLogBase.isCreateManDirty();
            }
            case 3: {
                return pSBKTaskLogBase.isEndTimeDirty();
            }
            case 4: {
                return pSBKTaskLogBase.isOrderValueDirty();
            }
            case 5: {
                return pSBKTaskLogBase.isPPSBKTaskLogIdDirty();
            }
            case 6: {
                return pSBKTaskLogBase.isPPSBKTaskLogNameDirty();
            }
            case 7: {
                return pSBKTaskLogBase.isPSBKTaskLogIdDirty();
            }
            case 8: {
                return pSBKTaskLogBase.isPSBKTaskLogNameDirty();
            }
            case 9: {
                return pSBKTaskLogBase.isPSDCRobotIdDirty();
            }
            case 10: {
                return pSBKTaskLogBase.isPSDCRobotNameDirty();
            }
            case 11: {
                return pSBKTaskLogBase.isPSDevCenterIdDirty();
            }
            case 12: {
                return pSBKTaskLogBase.isPSDevCenterNameDirty();
            }
            case 13: {
                return pSBKTaskLogBase.isPSDevSlnSysIdDirty();
            }
            case 14: {
                return pSBKTaskLogBase.isPSDevSlnSysNameDirty();
            }
            case 15: {
                return pSBKTaskLogBase.isPSDSConsoleIdDirty();
            }
            case 16: {
                return pSBKTaskLogBase.isPSDynaInstIdDirty();
            }
            case 17: {
                return pSBKTaskLogBase.isPSTaskServerIdDirty();
            }
            case 18: {
                return pSBKTaskLogBase.isPSTaskServerNameDirty();
            }
            case 19: {
                return pSBKTaskLogBase.isRemoteAddrDirty();
            }
            case 20: {
                return pSBKTaskLogBase.isResultInfoDirty();
            }
            case 21: {
                return pSBKTaskLogBase.isTaskCatDirty();
            }
            case 22: {
                return pSBKTaskLogBase.isTaskParamDirty();
            }
            case 23: {
                return pSBKTaskLogBase.isTaskParam2Dirty();
            }
            case 24: {
                return pSBKTaskLogBase.isTaskParam3Dirty();
            }
            case 25: {
                return pSBKTaskLogBase.isTaskParam4Dirty();
            }
            case 26: {
                return pSBKTaskLogBase.isTaskStateDirty();
            }
            case 27: {
                return pSBKTaskLogBase.isTaskTypeDirty();
            }
            case 28: {
                return pSBKTaskLogBase.isUpdateDateDirty();
            }
            case 29: {
                return pSBKTaskLogBase.isUpdateManDirty();
            }
            case 30: {
                return pSBKTaskLogBase.isUseRobotFlagDirty();
            }
            case 31: {
                return pSBKTaskLogBase.isUserTagDirty();
            }
            case 32: {
                return pSBKTaskLogBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBKTaskLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBKTaskLogBase pSBKTaskLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBKTaskLogBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getEndTime()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPPSBKTaskLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsbktasklogid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPPSBKTaskLogId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPPSBKTaskLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsbktasklogname", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPPSBKTaskLogName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSBKTaskLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbktasklogid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSBKTaskLogId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSBKTaskLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbktasklogname", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSBKTaskLogName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getResultInfo()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskcat", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskCat()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskParam()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam2", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskParam2()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam3", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskParam3()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam4", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskParam4()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskstate", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskState()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getTaskType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tasktype", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getTaskType()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getUseRobotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userobotflag", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getUseRobotFlag()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getUserTag()), (boolean)false);
        }
        if (bl || pSBKTaskLogBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSBKTaskLogBase.getJSONValue((Object)pSBKTaskLogBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBKTaskLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBKTaskLogBase pSBKTaskLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBKTaskLogBase.getBeginTime() != null) {
            object = pSBKTaskLogBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getCreateDate() != null) {
            object = pSBKTaskLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getCreateMan() != null) {
            object = pSBKTaskLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getEndTime() != null) {
            object = pSBKTaskLogBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getOrderValue() != null) {
            object = pSBKTaskLogBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getPPSBKTaskLogId() != null) {
            object = pSBKTaskLogBase.getPPSBKTaskLogId();
            xmlNode.setAttribute(FIELD_PPSBKTASKLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPPSBKTaskLogName() != null) {
            object = pSBKTaskLogBase.getPPSBKTaskLogName();
            xmlNode.setAttribute(FIELD_PPSBKTASKLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSBKTaskLogId() != null) {
            object = pSBKTaskLogBase.getPSBKTaskLogId();
            xmlNode.setAttribute(FIELD_PSBKTASKLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSBKTaskLogName() != null) {
            object = pSBKTaskLogBase.getPSBKTaskLogName();
            xmlNode.setAttribute(FIELD_PSBKTASKLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDCRobotId() != null) {
            object = pSBKTaskLogBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDCRobotName() != null) {
            object = pSBKTaskLogBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDevCenterId() != null) {
            object = pSBKTaskLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDevCenterName() != null) {
            object = pSBKTaskLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDevSlnSysId() != null) {
            object = pSBKTaskLogBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDevSlnSysName() != null) {
            object = pSBKTaskLogBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDSConsoleId() != null) {
            object = pSBKTaskLogBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSDynaInstId() != null) {
            object = pSBKTaskLogBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSTaskServerId() != null) {
            object = pSBKTaskLogBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getPSTaskServerName() != null) {
            object = pSBKTaskLogBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getRemoteAddr() != null) {
            object = pSBKTaskLogBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getResultInfo() != null) {
            object = pSBKTaskLogBase.getResultInfo();
            xmlNode.setAttribute(FIELD_RESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskCat() != null) {
            object = pSBKTaskLogBase.getTaskCat();
            xmlNode.setAttribute(FIELD_TASKCAT, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskParam() != null) {
            object = pSBKTaskLogBase.getTaskParam();
            xmlNode.setAttribute(FIELD_TASKPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskParam2() != null) {
            object = pSBKTaskLogBase.getTaskParam2();
            xmlNode.setAttribute(FIELD_TASKPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskParam3() != null) {
            object = pSBKTaskLogBase.getTaskParam3();
            xmlNode.setAttribute(FIELD_TASKPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskParam4() != null) {
            object = pSBKTaskLogBase.getTaskParam4();
            xmlNode.setAttribute(FIELD_TASKPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getTaskState() != null) {
            object = pSBKTaskLogBase.getTaskState();
            xmlNode.setAttribute(FIELD_TASKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getTaskType() != null) {
            object = pSBKTaskLogBase.getTaskType();
            xmlNode.setAttribute(FIELD_TASKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getUpdateDate() != null) {
            object = pSBKTaskLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getUpdateMan() != null) {
            object = pSBKTaskLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getUseRobotFlag() != null) {
            object = pSBKTaskLogBase.getUseRobotFlag();
            xmlNode.setAttribute(FIELD_USEROBOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBKTaskLogBase.getUserTag() != null) {
            object = pSBKTaskLogBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSBKTaskLogBase.getUserTag2() != null) {
            object = pSBKTaskLogBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBKTaskLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBKTaskLogBase pSBKTaskLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBKTaskLogBase.isBeginTimeDirty() && (bl || pSBKTaskLogBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSBKTaskLogBase.getBeginTime());
        }
        if (pSBKTaskLogBase.isCreateDateDirty() && (bl || pSBKTaskLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBKTaskLogBase.getCreateDate());
        }
        if (pSBKTaskLogBase.isCreateManDirty() && (bl || pSBKTaskLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBKTaskLogBase.getCreateMan());
        }
        if (pSBKTaskLogBase.isEndTimeDirty() && (bl || pSBKTaskLogBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSBKTaskLogBase.getEndTime());
        }
        if (pSBKTaskLogBase.isOrderValueDirty() && (bl || pSBKTaskLogBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSBKTaskLogBase.getOrderValue());
        }
        if (pSBKTaskLogBase.isPPSBKTaskLogIdDirty() && (bl || pSBKTaskLogBase.getPPSBKTaskLogId() != null)) {
            iDataObject.set(FIELD_PPSBKTASKLOGID, (Object)pSBKTaskLogBase.getPPSBKTaskLogId());
        }
        if (pSBKTaskLogBase.isPPSBKTaskLogNameDirty() && (bl || pSBKTaskLogBase.getPPSBKTaskLogName() != null)) {
            iDataObject.set(FIELD_PPSBKTASKLOGNAME, (Object)pSBKTaskLogBase.getPPSBKTaskLogName());
        }
        if (pSBKTaskLogBase.isPSBKTaskLogIdDirty() && (bl || pSBKTaskLogBase.getPSBKTaskLogId() != null)) {
            iDataObject.set(FIELD_PSBKTASKLOGID, (Object)pSBKTaskLogBase.getPSBKTaskLogId());
        }
        if (pSBKTaskLogBase.isPSBKTaskLogNameDirty() && (bl || pSBKTaskLogBase.getPSBKTaskLogName() != null)) {
            iDataObject.set(FIELD_PSBKTASKLOGNAME, (Object)pSBKTaskLogBase.getPSBKTaskLogName());
        }
        if (pSBKTaskLogBase.isPSDCRobotIdDirty() && (bl || pSBKTaskLogBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSBKTaskLogBase.getPSDCRobotId());
        }
        if (pSBKTaskLogBase.isPSDCRobotNameDirty() && (bl || pSBKTaskLogBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSBKTaskLogBase.getPSDCRobotName());
        }
        if (pSBKTaskLogBase.isPSDevCenterIdDirty() && (bl || pSBKTaskLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSBKTaskLogBase.getPSDevCenterId());
        }
        if (pSBKTaskLogBase.isPSDevCenterNameDirty() && (bl || pSBKTaskLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSBKTaskLogBase.getPSDevCenterName());
        }
        if (pSBKTaskLogBase.isPSDevSlnSysIdDirty() && (bl || pSBKTaskLogBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSBKTaskLogBase.getPSDevSlnSysId());
        }
        if (pSBKTaskLogBase.isPSDevSlnSysNameDirty() && (bl || pSBKTaskLogBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSBKTaskLogBase.getPSDevSlnSysName());
        }
        if (pSBKTaskLogBase.isPSDSConsoleIdDirty() && (bl || pSBKTaskLogBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSBKTaskLogBase.getPSDSConsoleId());
        }
        if (pSBKTaskLogBase.isPSDynaInstIdDirty() && (bl || pSBKTaskLogBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSBKTaskLogBase.getPSDynaInstId());
        }
        if (pSBKTaskLogBase.isPSTaskServerIdDirty() && (bl || pSBKTaskLogBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSBKTaskLogBase.getPSTaskServerId());
        }
        if (pSBKTaskLogBase.isPSTaskServerNameDirty() && (bl || pSBKTaskLogBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSBKTaskLogBase.getPSTaskServerName());
        }
        if (pSBKTaskLogBase.isRemoteAddrDirty() && (bl || pSBKTaskLogBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSBKTaskLogBase.getRemoteAddr());
        }
        if (pSBKTaskLogBase.isResultInfoDirty() && (bl || pSBKTaskLogBase.getResultInfo() != null)) {
            iDataObject.set(FIELD_RESULTINFO, (Object)pSBKTaskLogBase.getResultInfo());
        }
        if (pSBKTaskLogBase.isTaskCatDirty() && (bl || pSBKTaskLogBase.getTaskCat() != null)) {
            iDataObject.set(FIELD_TASKCAT, (Object)pSBKTaskLogBase.getTaskCat());
        }
        if (pSBKTaskLogBase.isTaskParamDirty() && (bl || pSBKTaskLogBase.getTaskParam() != null)) {
            iDataObject.set(FIELD_TASKPARAM, (Object)pSBKTaskLogBase.getTaskParam());
        }
        if (pSBKTaskLogBase.isTaskParam2Dirty() && (bl || pSBKTaskLogBase.getTaskParam2() != null)) {
            iDataObject.set(FIELD_TASKPARAM2, (Object)pSBKTaskLogBase.getTaskParam2());
        }
        if (pSBKTaskLogBase.isTaskParam3Dirty() && (bl || pSBKTaskLogBase.getTaskParam3() != null)) {
            iDataObject.set(FIELD_TASKPARAM3, (Object)pSBKTaskLogBase.getTaskParam3());
        }
        if (pSBKTaskLogBase.isTaskParam4Dirty() && (bl || pSBKTaskLogBase.getTaskParam4() != null)) {
            iDataObject.set(FIELD_TASKPARAM4, (Object)pSBKTaskLogBase.getTaskParam4());
        }
        if (pSBKTaskLogBase.isTaskStateDirty() && (bl || pSBKTaskLogBase.getTaskState() != null)) {
            iDataObject.set(FIELD_TASKSTATE, (Object)pSBKTaskLogBase.getTaskState());
        }
        if (pSBKTaskLogBase.isTaskTypeDirty() && (bl || pSBKTaskLogBase.getTaskType() != null)) {
            iDataObject.set(FIELD_TASKTYPE, (Object)pSBKTaskLogBase.getTaskType());
        }
        if (pSBKTaskLogBase.isUpdateDateDirty() && (bl || pSBKTaskLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBKTaskLogBase.getUpdateDate());
        }
        if (pSBKTaskLogBase.isUpdateManDirty() && (bl || pSBKTaskLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBKTaskLogBase.getUpdateMan());
        }
        if (pSBKTaskLogBase.isUseRobotFlagDirty() && (bl || pSBKTaskLogBase.getUseRobotFlag() != null)) {
            iDataObject.set(FIELD_USEROBOTFLAG, (Object)pSBKTaskLogBase.getUseRobotFlag());
        }
        if (pSBKTaskLogBase.isUserTagDirty() && (bl || pSBKTaskLogBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSBKTaskLogBase.getUserTag());
        }
        if (pSBKTaskLogBase.isUserTag2Dirty() && (bl || pSBKTaskLogBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSBKTaskLogBase.getUserTag2());
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
        return PSBKTaskLogBase.remove(this, n);
    }

    private static boolean remove(PSBKTaskLogBase pSBKTaskLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBKTaskLogBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSBKTaskLogBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSBKTaskLogBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSBKTaskLogBase.resetEndTime();
                return true;
            }
            case 4: {
                pSBKTaskLogBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSBKTaskLogBase.resetPPSBKTaskLogId();
                return true;
            }
            case 6: {
                pSBKTaskLogBase.resetPPSBKTaskLogName();
                return true;
            }
            case 7: {
                pSBKTaskLogBase.resetPSBKTaskLogId();
                return true;
            }
            case 8: {
                pSBKTaskLogBase.resetPSBKTaskLogName();
                return true;
            }
            case 9: {
                pSBKTaskLogBase.resetPSDCRobotId();
                return true;
            }
            case 10: {
                pSBKTaskLogBase.resetPSDCRobotName();
                return true;
            }
            case 11: {
                pSBKTaskLogBase.resetPSDevCenterId();
                return true;
            }
            case 12: {
                pSBKTaskLogBase.resetPSDevCenterName();
                return true;
            }
            case 13: {
                pSBKTaskLogBase.resetPSDevSlnSysId();
                return true;
            }
            case 14: {
                pSBKTaskLogBase.resetPSDevSlnSysName();
                return true;
            }
            case 15: {
                pSBKTaskLogBase.resetPSDSConsoleId();
                return true;
            }
            case 16: {
                pSBKTaskLogBase.resetPSDynaInstId();
                return true;
            }
            case 17: {
                pSBKTaskLogBase.resetPSTaskServerId();
                return true;
            }
            case 18: {
                pSBKTaskLogBase.resetPSTaskServerName();
                return true;
            }
            case 19: {
                pSBKTaskLogBase.resetRemoteAddr();
                return true;
            }
            case 20: {
                pSBKTaskLogBase.resetResultInfo();
                return true;
            }
            case 21: {
                pSBKTaskLogBase.resetTaskCat();
                return true;
            }
            case 22: {
                pSBKTaskLogBase.resetTaskParam();
                return true;
            }
            case 23: {
                pSBKTaskLogBase.resetTaskParam2();
                return true;
            }
            case 24: {
                pSBKTaskLogBase.resetTaskParam3();
                return true;
            }
            case 25: {
                pSBKTaskLogBase.resetTaskParam4();
                return true;
            }
            case 26: {
                pSBKTaskLogBase.resetTaskState();
                return true;
            }
            case 27: {
                pSBKTaskLogBase.resetTaskType();
                return true;
            }
            case 28: {
                pSBKTaskLogBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSBKTaskLogBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSBKTaskLogBase.resetUseRobotFlag();
                return true;
            }
            case 31: {
                pSBKTaskLogBase.resetUserTag();
                return true;
            }
            case 32: {
                pSBKTaskLogBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSBKTaskLog getPPSBKTaskLog() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSBKTaskLog();
        }
        if (this.getPPSBKTaskLogId() == null) {
            return null;
        }
        Integer n = this.objPPSBKTaskLogLock;
        synchronized (n) {
            if (this.ppsbktasklog != null && DataTypeHelper.compare((int)25, (Object)this.getPPSBKTaskLogId(), (Object)this.ppsbktasklog.getPSBKTaskLogId()) != 0L) {
                this.ppsbktasklog = null;
            }
            if (this.ppsbktasklog == null) {
                PSBKTaskLog pSBKTaskLog = new PSBKTaskLog();
                pSBKTaskLog.setPSBKTaskLogId(this.getPPSBKTaskLogId());
                PSBKTaskLogService pSBKTaskLogService = (PSBKTaskLogService)ServiceGlobal.getService(PSBKTaskLogService.class, (SessionFactory)this.getSessionFactory());
                pSBKTaskLogService.autoGet(pSBKTaskLog);
                this.ppsbktasklog = pSBKTaskLog;
            }
            return this.ppsbktasklog;
        }
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
                pSDCRobotService.autoGet(pSDCRobot);
                this.psdcrobot = pSDCRobot;
            }
            return this.psdcrobot;
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

    private PSBKTaskLogBase getProxyEntity() {
        return this.proxyPSBKTaskLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBKTaskLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSBKTaskLogBase) {
            this.proxyPSBKTaskLogBase = (PSBKTaskLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSBKTaskLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PPSBKTASKLOGID, 5);
        fieldIndexMap.put(FIELD_PPSBKTASKLOGNAME, 6);
        fieldIndexMap.put(FIELD_PSBKTASKLOGID, 7);
        fieldIndexMap.put(FIELD_PSBKTASKLOGNAME, 8);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 9);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 11);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 14);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 15);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 16);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 17);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 18);
        fieldIndexMap.put(FIELD_REMOTEADDR, 19);
        fieldIndexMap.put(FIELD_RESULTINFO, 20);
        fieldIndexMap.put(FIELD_TASKCAT, 21);
        fieldIndexMap.put(FIELD_TASKPARAM, 22);
        fieldIndexMap.put(FIELD_TASKPARAM2, 23);
        fieldIndexMap.put(FIELD_TASKPARAM3, 24);
        fieldIndexMap.put(FIELD_TASKPARAM4, 25);
        fieldIndexMap.put(FIELD_TASKSTATE, 26);
        fieldIndexMap.put(FIELD_TASKTYPE, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USEROBOTFLAG, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
    }
}

