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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
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

public abstract class PSDCBKTaskBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCBKTaskBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FULLRESULTINFO = "FULLRESULTINFO";
    public static final String FIELD_LASTCALCTIME = "LASTCALCTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLANPSDCROBOTID = "PLANPSDCROBOTID";
    public static final String FIELD_PLANPSDCROBOTNAME = "PLANPSDCROBOTNAME";
    public static final String FIELD_PSDCBKTASKID = "PSDCBKTASKID";
    public static final String FIELD_PSDCBKTASKNAME = "PSDCBKTASKNAME";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_QUEUEINFO = "QUEUEINFO";
    public static final String FIELD_REMAININGTIME = "REMAININGTIME";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_RESULTINFO = "RESULTINFO";
    public static final String FIELD_STEPINFO = "STEPINFO";
    public static final String FIELD_TASKPARAM = "TASKPARAM";
    public static final String FIELD_TASKPARAM2 = "TASKPARAM2";
    public static final String FIELD_TASKPARAM3 = "TASKPARAM3";
    public static final String FIELD_TASKPARAM4 = "TASKPARAM4";
    public static final String FIELD_TASKPARAMS = "TASKPARAMS";
    public static final String FIELD_TASKSTATE = "TASKSTATE";
    public static final String FIELD_TASKTYPE = "TASKTYPE";
    public static final String FIELD_TOTALTIME = "TOTALTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEROBOTFLAG = "USEROBOTFLAG";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_FULLRESULTINFO = 4;
    private static final int INDEX_LASTCALCTIME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_ORDERVALUE = 7;
    private static final int INDEX_PLANPSDCROBOTID = 8;
    private static final int INDEX_PLANPSDCROBOTNAME = 9;
    private static final int INDEX_PSDCBKTASKID = 10;
    private static final int INDEX_PSDCBKTASKNAME = 11;
    private static final int INDEX_PSDCROBOTID = 12;
    private static final int INDEX_PSDCROBOTNAME = 13;
    private static final int INDEX_PSDEVCENTERID = 14;
    private static final int INDEX_PSDEVCENTERNAME = 15;
    private static final int INDEX_PSDEVSLNID = 16;
    private static final int INDEX_PSDEVSLNNAME = 17;
    private static final int INDEX_PSDEVSLNSYSID = 18;
    private static final int INDEX_PSDEVSLNSYSNAME = 19;
    private static final int INDEX_PSDSCONSOLEID = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_PSTASKSERVERID = 22;
    private static final int INDEX_PSTASKSERVERNAME = 23;
    private static final int INDEX_QUEUEINFO = 24;
    private static final int INDEX_REMAININGTIME = 25;
    private static final int INDEX_REMOTEADDR = 26;
    private static final int INDEX_RESULTINFO = 27;
    private static final int INDEX_STEPINFO = 28;
    private static final int INDEX_TASKPARAM = 29;
    private static final int INDEX_TASKPARAM2 = 30;
    private static final int INDEX_TASKPARAM3 = 31;
    private static final int INDEX_TASKPARAM4 = 32;
    private static final int INDEX_TASKPARAMS = 33;
    private static final int INDEX_TASKSTATE = 34;
    private static final int INDEX_TASKTYPE = 35;
    private static final int INDEX_TOTALTIME = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USEROBOTFLAG = 39;
    private static final int INDEX_USERTAG = 40;
    private static final int INDEX_USERTAG2 = 41;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCBKTaskBase proxyPSDCBKTaskBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fullresultinfoDirtyFlag = false;
    private boolean lastcalctimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean planpsdcrobotidDirtyFlag = false;
    private boolean planpsdcrobotnameDirtyFlag = false;
    private boolean psdcbktaskidDirtyFlag = false;
    private boolean psdcbktasknameDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean queueinfoDirtyFlag = false;
    private boolean remainingtimeDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean resultinfoDirtyFlag = false;
    private boolean stepinfoDirtyFlag = false;
    private boolean taskparamDirtyFlag = false;
    private boolean taskparam2DirtyFlag = false;
    private boolean taskparam3DirtyFlag = false;
    private boolean taskparam4DirtyFlag = false;
    private boolean taskparamsDirtyFlag = false;
    private boolean taskstateDirtyFlag = false;
    private boolean tasktypeDirtyFlag = false;
    private boolean totaltimeDirtyFlag = false;
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
    @Column(name="fullresultinfo")
    private String fullresultinfo;
    @Column(name="lastcalctime")
    private Timestamp lastcalctime;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="planpsdcrobotid")
    private String planpsdcrobotid;
    @Column(name="planpsdcrobotname")
    private String planpsdcrobotname;
    @Column(name="psdcbktaskid")
    private String psdcbktaskid;
    @Column(name="psdcbktaskname")
    private String psdcbktaskname;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
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
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="queueinfo")
    private String queueinfo;
    @Column(name="remainingtime")
    private Integer remainingtime;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="resultinfo")
    private String resultinfo;
    @Column(name="stepinfo")
    private String stepinfo;
    @Column(name="taskparam")
    private String taskparam;
    @Column(name="taskparam2")
    private String taskparam2;
    @Column(name="taskparam3")
    private String taskparam3;
    @Column(name="taskparam4")
    private String taskparam4;
    @Column(name="taskparams")
    private String taskparams;
    @Column(name="taskstate")
    private Integer taskstate;
    @Column(name="tasktype")
    private String tasktype;
    @Column(name="totaltime")
    private Integer totaltime;
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
    private Integer objPlanPSDCRobotLock = new Integer(1);
    private PSDCRobot planpsdcrobot = null;
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;
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

    public void setFullResultInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullResultInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullresultinfo = string;
        this.fullresultinfoDirtyFlag = true;
    }

    public String getFullResultInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullResultInfo();
        }
        return this.fullresultinfo;
    }

    public boolean isFullResultInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullResultInfoDirty();
        }
        return this.fullresultinfoDirtyFlag;
    }

    public void resetFullResultInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullResultInfo();
            return;
        }
        this.fullresultinfoDirtyFlag = false;
        this.fullresultinfo = null;
    }

    public void setLastCalcTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastCalcTime(timestamp);
            return;
        }
        this.lastcalctime = timestamp;
        this.lastcalctimeDirtyFlag = true;
    }

    public Timestamp getLastCalcTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastCalcTime();
        }
        return this.lastcalctime;
    }

    public boolean isLastCalcTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastCalcTimeDirty();
        }
        return this.lastcalctimeDirtyFlag;
    }

    public void resetLastCalcTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastCalcTime();
            return;
        }
        this.lastcalctimeDirtyFlag = false;
        this.lastcalctime = null;
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

    public void setPlanPSDCRobotId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanPSDCRobotId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.planpsdcrobotid = string;
        this.planpsdcrobotidDirtyFlag = true;
    }

    public String getPlanPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanPSDCRobotId();
        }
        return this.planpsdcrobotid;
    }

    public boolean isPlanPSDCRobotIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanPSDCRobotIdDirty();
        }
        return this.planpsdcrobotidDirtyFlag;
    }

    public void resetPlanPSDCRobotId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanPSDCRobotId();
            return;
        }
        this.planpsdcrobotidDirtyFlag = false;
        this.planpsdcrobotid = null;
    }

    public void setPlanPSDCRobotName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPlanPSDCRobotName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.planpsdcrobotname = string;
        this.planpsdcrobotnameDirtyFlag = true;
    }

    public String getPlanPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanPSDCRobotName();
        }
        return this.planpsdcrobotname;
    }

    public boolean isPlanPSDCRobotNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPlanPSDCRobotNameDirty();
        }
        return this.planpsdcrobotnameDirtyFlag;
    }

    public void resetPlanPSDCRobotName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPlanPSDCRobotName();
            return;
        }
        this.planpsdcrobotnameDirtyFlag = false;
        this.planpsdcrobotname = null;
    }

    public void setPSDCBKTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBKTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbktaskid = string;
        this.psdcbktaskidDirtyFlag = true;
    }

    public String getPSDCBKTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBKTaskId();
        }
        return this.psdcbktaskid;
    }

    public boolean isPSDCBKTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBKTaskIdDirty();
        }
        return this.psdcbktaskidDirtyFlag;
    }

    public void resetPSDCBKTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBKTaskId();
            return;
        }
        this.psdcbktaskidDirtyFlag = false;
        this.psdcbktaskid = null;
    }

    public void setPSDCBKTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCBKTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcbktaskname = string;
        this.psdcbktasknameDirtyFlag = true;
    }

    public String getPSDCBKTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCBKTaskName();
        }
        return this.psdcbktaskname;
    }

    public boolean isPSDCBKTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCBKTaskNameDirty();
        }
        return this.psdcbktasknameDirtyFlag;
    }

    public void resetPSDCBKTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCBKTaskName();
            return;
        }
        this.psdcbktasknameDirtyFlag = false;
        this.psdcbktaskname = null;
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

    public void setQueueInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueueInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.queueinfo = string;
        this.queueinfoDirtyFlag = true;
    }

    public String getQueueInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueueInfo();
        }
        return this.queueinfo;
    }

    public boolean isQueueInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueueInfoDirty();
        }
        return this.queueinfoDirtyFlag;
    }

    public void resetQueueInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueueInfo();
            return;
        }
        this.queueinfoDirtyFlag = false;
        this.queueinfo = null;
    }

    public void setRemainingTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemainingTime(n);
            return;
        }
        this.remainingtime = n;
        this.remainingtimeDirtyFlag = true;
    }

    public Integer getRemainingTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemainingTime();
        }
        return this.remainingtime;
    }

    public boolean isRemainingTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemainingTimeDirty();
        }
        return this.remainingtimeDirtyFlag;
    }

    public void resetRemainingTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemainingTime();
            return;
        }
        this.remainingtimeDirtyFlag = false;
        this.remainingtime = null;
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

    public void setStepInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStepInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.stepinfo = string;
        this.stepinfoDirtyFlag = true;
    }

    public String getStepInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStepInfo();
        }
        return this.stepinfo;
    }

    public boolean isStepInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStepInfoDirty();
        }
        return this.stepinfoDirtyFlag;
    }

    public void resetStepInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStepInfo();
            return;
        }
        this.stepinfoDirtyFlag = false;
        this.stepinfo = null;
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

    public void setTaskParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.taskparams = string;
        this.taskparamsDirtyFlag = true;
    }

    public String getTaskParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParams();
        }
        return this.taskparams;
    }

    public boolean isTaskParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParamsDirty();
        }
        return this.taskparamsDirtyFlag;
    }

    public void resetTaskParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParams();
            return;
        }
        this.taskparamsDirtyFlag = false;
        this.taskparams = null;
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

    public void setTotalTime(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTotalTime(n);
            return;
        }
        this.totaltime = n;
        this.totaltimeDirtyFlag = true;
    }

    public Integer getTotalTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTotalTime();
        }
        return this.totaltime;
    }

    public boolean isTotalTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTotalTimeDirty();
        }
        return this.totaltimeDirtyFlag;
    }

    public void resetTotalTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTotalTime();
            return;
        }
        this.totaltimeDirtyFlag = false;
        this.totaltime = null;
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
        PSDCBKTaskBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCBKTaskBase pSDCBKTaskBase) {
        pSDCBKTaskBase.resetBeginTime();
        pSDCBKTaskBase.resetCreateDate();
        pSDCBKTaskBase.resetCreateMan();
        pSDCBKTaskBase.resetEndTime();
        pSDCBKTaskBase.resetFullResultInfo();
        pSDCBKTaskBase.resetLastCalcTime();
        pSDCBKTaskBase.resetMemo();
        pSDCBKTaskBase.resetOrderValue();
        pSDCBKTaskBase.resetPlanPSDCRobotId();
        pSDCBKTaskBase.resetPlanPSDCRobotName();
        pSDCBKTaskBase.resetPSDCBKTaskId();
        pSDCBKTaskBase.resetPSDCBKTaskName();
        pSDCBKTaskBase.resetPSDCRobotId();
        pSDCBKTaskBase.resetPSDCRobotName();
        pSDCBKTaskBase.resetPSDevCenterId();
        pSDCBKTaskBase.resetPSDevCenterName();
        pSDCBKTaskBase.resetPSDevSlnId();
        pSDCBKTaskBase.resetPSDevSlnName();
        pSDCBKTaskBase.resetPSDevSlnSysId();
        pSDCBKTaskBase.resetPSDevSlnSysName();
        pSDCBKTaskBase.resetPSDSConsoleId();
        pSDCBKTaskBase.resetPSDynaInstId();
        pSDCBKTaskBase.resetPSTaskServerId();
        pSDCBKTaskBase.resetPSTaskServerName();
        pSDCBKTaskBase.resetQueueInfo();
        pSDCBKTaskBase.resetRemainingTime();
        pSDCBKTaskBase.resetRemoteAddr();
        pSDCBKTaskBase.resetResultInfo();
        pSDCBKTaskBase.resetStepInfo();
        pSDCBKTaskBase.resetTaskParam();
        pSDCBKTaskBase.resetTaskParam2();
        pSDCBKTaskBase.resetTaskParam3();
        pSDCBKTaskBase.resetTaskParam4();
        pSDCBKTaskBase.resetTaskParams();
        pSDCBKTaskBase.resetTaskState();
        pSDCBKTaskBase.resetTaskType();
        pSDCBKTaskBase.resetTotalTime();
        pSDCBKTaskBase.resetUpdateDate();
        pSDCBKTaskBase.resetUpdateMan();
        pSDCBKTaskBase.resetUseRobotFlag();
        pSDCBKTaskBase.resetUserTag();
        pSDCBKTaskBase.resetUserTag2();
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
        if (!bl || this.isFullResultInfoDirty()) {
            hashMap.put(FIELD_FULLRESULTINFO, this.getFullResultInfo());
        }
        if (!bl || this.isLastCalcTimeDirty()) {
            hashMap.put(FIELD_LASTCALCTIME, this.getLastCalcTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPlanPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PLANPSDCROBOTID, this.getPlanPSDCRobotId());
        }
        if (!bl || this.isPlanPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PLANPSDCROBOTNAME, this.getPlanPSDCRobotName());
        }
        if (!bl || this.isPSDCBKTaskIdDirty()) {
            hashMap.put(FIELD_PSDCBKTASKID, this.getPSDCBKTaskId());
        }
        if (!bl || this.isPSDCBKTaskNameDirty()) {
            hashMap.put(FIELD_PSDCBKTASKNAME, this.getPSDCBKTaskName());
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
        if (!bl || this.isQueueInfoDirty()) {
            hashMap.put(FIELD_QUEUEINFO, this.getQueueInfo());
        }
        if (!bl || this.isRemainingTimeDirty()) {
            hashMap.put(FIELD_REMAININGTIME, this.getRemainingTime());
        }
        if (!bl || this.isRemoteAddrDirty()) {
            hashMap.put(FIELD_REMOTEADDR, this.getRemoteAddr());
        }
        if (!bl || this.isResultInfoDirty()) {
            hashMap.put(FIELD_RESULTINFO, this.getResultInfo());
        }
        if (!bl || this.isStepInfoDirty()) {
            hashMap.put(FIELD_STEPINFO, this.getStepInfo());
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
        if (!bl || this.isTaskParamsDirty()) {
            hashMap.put(FIELD_TASKPARAMS, this.getTaskParams());
        }
        if (!bl || this.isTaskStateDirty()) {
            hashMap.put(FIELD_TASKSTATE, this.getTaskState());
        }
        if (!bl || this.isTaskTypeDirty()) {
            hashMap.put(FIELD_TASKTYPE, this.getTaskType());
        }
        if (!bl || this.isTotalTimeDirty()) {
            hashMap.put(FIELD_TOTALTIME, this.getTotalTime());
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
        return PSDCBKTaskBase.get(this, n);
    }

    private static Object get(PSDCBKTaskBase pSDCBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTaskBase.getBeginTime();
            }
            case 1: {
                return pSDCBKTaskBase.getCreateDate();
            }
            case 2: {
                return pSDCBKTaskBase.getCreateMan();
            }
            case 3: {
                return pSDCBKTaskBase.getEndTime();
            }
            case 4: {
                return pSDCBKTaskBase.getFullResultInfo();
            }
            case 5: {
                return pSDCBKTaskBase.getLastCalcTime();
            }
            case 6: {
                return pSDCBKTaskBase.getMemo();
            }
            case 7: {
                return pSDCBKTaskBase.getOrderValue();
            }
            case 8: {
                return pSDCBKTaskBase.getPlanPSDCRobotId();
            }
            case 9: {
                return pSDCBKTaskBase.getPlanPSDCRobotName();
            }
            case 10: {
                return pSDCBKTaskBase.getPSDCBKTaskId();
            }
            case 11: {
                return pSDCBKTaskBase.getPSDCBKTaskName();
            }
            case 12: {
                return pSDCBKTaskBase.getPSDCRobotId();
            }
            case 13: {
                return pSDCBKTaskBase.getPSDCRobotName();
            }
            case 14: {
                return pSDCBKTaskBase.getPSDevCenterId();
            }
            case 15: {
                return pSDCBKTaskBase.getPSDevCenterName();
            }
            case 16: {
                return pSDCBKTaskBase.getPSDevSlnId();
            }
            case 17: {
                return pSDCBKTaskBase.getPSDevSlnName();
            }
            case 18: {
                return pSDCBKTaskBase.getPSDevSlnSysId();
            }
            case 19: {
                return pSDCBKTaskBase.getPSDevSlnSysName();
            }
            case 20: {
                return pSDCBKTaskBase.getPSDSConsoleId();
            }
            case 21: {
                return pSDCBKTaskBase.getPSDynaInstId();
            }
            case 22: {
                return pSDCBKTaskBase.getPSTaskServerId();
            }
            case 23: {
                return pSDCBKTaskBase.getPSTaskServerName();
            }
            case 24: {
                return pSDCBKTaskBase.getQueueInfo();
            }
            case 25: {
                return pSDCBKTaskBase.getRemainingTime();
            }
            case 26: {
                return pSDCBKTaskBase.getRemoteAddr();
            }
            case 27: {
                return pSDCBKTaskBase.getResultInfo();
            }
            case 28: {
                return pSDCBKTaskBase.getStepInfo();
            }
            case 29: {
                return pSDCBKTaskBase.getTaskParam();
            }
            case 30: {
                return pSDCBKTaskBase.getTaskParam2();
            }
            case 31: {
                return pSDCBKTaskBase.getTaskParam3();
            }
            case 32: {
                return pSDCBKTaskBase.getTaskParam4();
            }
            case 33: {
                return pSDCBKTaskBase.getTaskParams();
            }
            case 34: {
                return pSDCBKTaskBase.getTaskState();
            }
            case 35: {
                return pSDCBKTaskBase.getTaskType();
            }
            case 36: {
                return pSDCBKTaskBase.getTotalTime();
            }
            case 37: {
                return pSDCBKTaskBase.getUpdateDate();
            }
            case 38: {
                return pSDCBKTaskBase.getUpdateMan();
            }
            case 39: {
                return pSDCBKTaskBase.getUseRobotFlag();
            }
            case 40: {
                return pSDCBKTaskBase.getUserTag();
            }
            case 41: {
                return pSDCBKTaskBase.getUserTag2();
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
        PSDCBKTaskBase.set(this, n, object);
    }

    private static void set(PSDCBKTaskBase pSDCBKTaskBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCBKTaskBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCBKTaskBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDCBKTaskBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCBKTaskBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDCBKTaskBase.setFullResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCBKTaskBase.setLastCalcTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDCBKTaskBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCBKTaskBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDCBKTaskBase.setPlanPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCBKTaskBase.setPlanPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCBKTaskBase.setPSDCBKTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCBKTaskBase.setPSDCBKTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDCBKTaskBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCBKTaskBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDCBKTaskBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDCBKTaskBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDCBKTaskBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDCBKTaskBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDCBKTaskBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDCBKTaskBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDCBKTaskBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDCBKTaskBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDCBKTaskBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDCBKTaskBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDCBKTaskBase.setQueueInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDCBKTaskBase.setRemainingTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 26: {
                pSDCBKTaskBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDCBKTaskBase.setResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDCBKTaskBase.setStepInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDCBKTaskBase.setTaskParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDCBKTaskBase.setTaskParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDCBKTaskBase.setTaskParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDCBKTaskBase.setTaskParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDCBKTaskBase.setTaskParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDCBKTaskBase.setTaskState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSDCBKTaskBase.setTaskType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDCBKTaskBase.setTotalTime(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSDCBKTaskBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDCBKTaskBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDCBKTaskBase.setUseRobotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 40: {
                pSDCBKTaskBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDCBKTaskBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSDCBKTaskBase.isNull(this, n);
    }

    private static boolean isNull(PSDCBKTaskBase pSDCBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTaskBase.getBeginTime() == null;
            }
            case 1: {
                return pSDCBKTaskBase.getCreateDate() == null;
            }
            case 2: {
                return pSDCBKTaskBase.getCreateMan() == null;
            }
            case 3: {
                return pSDCBKTaskBase.getEndTime() == null;
            }
            case 4: {
                return pSDCBKTaskBase.getFullResultInfo() == null;
            }
            case 5: {
                return pSDCBKTaskBase.getLastCalcTime() == null;
            }
            case 6: {
                return pSDCBKTaskBase.getMemo() == null;
            }
            case 7: {
                return pSDCBKTaskBase.getOrderValue() == null;
            }
            case 8: {
                return pSDCBKTaskBase.getPlanPSDCRobotId() == null;
            }
            case 9: {
                return pSDCBKTaskBase.getPlanPSDCRobotName() == null;
            }
            case 10: {
                return pSDCBKTaskBase.getPSDCBKTaskId() == null;
            }
            case 11: {
                return pSDCBKTaskBase.getPSDCBKTaskName() == null;
            }
            case 12: {
                return pSDCBKTaskBase.getPSDCRobotId() == null;
            }
            case 13: {
                return pSDCBKTaskBase.getPSDCRobotName() == null;
            }
            case 14: {
                return pSDCBKTaskBase.getPSDevCenterId() == null;
            }
            case 15: {
                return pSDCBKTaskBase.getPSDevCenterName() == null;
            }
            case 16: {
                return pSDCBKTaskBase.getPSDevSlnId() == null;
            }
            case 17: {
                return pSDCBKTaskBase.getPSDevSlnName() == null;
            }
            case 18: {
                return pSDCBKTaskBase.getPSDevSlnSysId() == null;
            }
            case 19: {
                return pSDCBKTaskBase.getPSDevSlnSysName() == null;
            }
            case 20: {
                return pSDCBKTaskBase.getPSDSConsoleId() == null;
            }
            case 21: {
                return pSDCBKTaskBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSDCBKTaskBase.getPSTaskServerId() == null;
            }
            case 23: {
                return pSDCBKTaskBase.getPSTaskServerName() == null;
            }
            case 24: {
                return pSDCBKTaskBase.getQueueInfo() == null;
            }
            case 25: {
                return pSDCBKTaskBase.getRemainingTime() == null;
            }
            case 26: {
                return pSDCBKTaskBase.getRemoteAddr() == null;
            }
            case 27: {
                return pSDCBKTaskBase.getResultInfo() == null;
            }
            case 28: {
                return pSDCBKTaskBase.getStepInfo() == null;
            }
            case 29: {
                return pSDCBKTaskBase.getTaskParam() == null;
            }
            case 30: {
                return pSDCBKTaskBase.getTaskParam2() == null;
            }
            case 31: {
                return pSDCBKTaskBase.getTaskParam3() == null;
            }
            case 32: {
                return pSDCBKTaskBase.getTaskParam4() == null;
            }
            case 33: {
                return pSDCBKTaskBase.getTaskParams() == null;
            }
            case 34: {
                return pSDCBKTaskBase.getTaskState() == null;
            }
            case 35: {
                return pSDCBKTaskBase.getTaskType() == null;
            }
            case 36: {
                return pSDCBKTaskBase.getTotalTime() == null;
            }
            case 37: {
                return pSDCBKTaskBase.getUpdateDate() == null;
            }
            case 38: {
                return pSDCBKTaskBase.getUpdateMan() == null;
            }
            case 39: {
                return pSDCBKTaskBase.getUseRobotFlag() == null;
            }
            case 40: {
                return pSDCBKTaskBase.getUserTag() == null;
            }
            case 41: {
                return pSDCBKTaskBase.getUserTag2() == null;
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
        return PSDCBKTaskBase.contains(this, n);
    }

    private static boolean contains(PSDCBKTaskBase pSDCBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCBKTaskBase.isBeginTimeDirty();
            }
            case 1: {
                return pSDCBKTaskBase.isCreateDateDirty();
            }
            case 2: {
                return pSDCBKTaskBase.isCreateManDirty();
            }
            case 3: {
                return pSDCBKTaskBase.isEndTimeDirty();
            }
            case 4: {
                return pSDCBKTaskBase.isFullResultInfoDirty();
            }
            case 5: {
                return pSDCBKTaskBase.isLastCalcTimeDirty();
            }
            case 6: {
                return pSDCBKTaskBase.isMemoDirty();
            }
            case 7: {
                return pSDCBKTaskBase.isOrderValueDirty();
            }
            case 8: {
                return pSDCBKTaskBase.isPlanPSDCRobotIdDirty();
            }
            case 9: {
                return pSDCBKTaskBase.isPlanPSDCRobotNameDirty();
            }
            case 10: {
                return pSDCBKTaskBase.isPSDCBKTaskIdDirty();
            }
            case 11: {
                return pSDCBKTaskBase.isPSDCBKTaskNameDirty();
            }
            case 12: {
                return pSDCBKTaskBase.isPSDCRobotIdDirty();
            }
            case 13: {
                return pSDCBKTaskBase.isPSDCRobotNameDirty();
            }
            case 14: {
                return pSDCBKTaskBase.isPSDevCenterIdDirty();
            }
            case 15: {
                return pSDCBKTaskBase.isPSDevCenterNameDirty();
            }
            case 16: {
                return pSDCBKTaskBase.isPSDevSlnIdDirty();
            }
            case 17: {
                return pSDCBKTaskBase.isPSDevSlnNameDirty();
            }
            case 18: {
                return pSDCBKTaskBase.isPSDevSlnSysIdDirty();
            }
            case 19: {
                return pSDCBKTaskBase.isPSDevSlnSysNameDirty();
            }
            case 20: {
                return pSDCBKTaskBase.isPSDSConsoleIdDirty();
            }
            case 21: {
                return pSDCBKTaskBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSDCBKTaskBase.isPSTaskServerIdDirty();
            }
            case 23: {
                return pSDCBKTaskBase.isPSTaskServerNameDirty();
            }
            case 24: {
                return pSDCBKTaskBase.isQueueInfoDirty();
            }
            case 25: {
                return pSDCBKTaskBase.isRemainingTimeDirty();
            }
            case 26: {
                return pSDCBKTaskBase.isRemoteAddrDirty();
            }
            case 27: {
                return pSDCBKTaskBase.isResultInfoDirty();
            }
            case 28: {
                return pSDCBKTaskBase.isStepInfoDirty();
            }
            case 29: {
                return pSDCBKTaskBase.isTaskParamDirty();
            }
            case 30: {
                return pSDCBKTaskBase.isTaskParam2Dirty();
            }
            case 31: {
                return pSDCBKTaskBase.isTaskParam3Dirty();
            }
            case 32: {
                return pSDCBKTaskBase.isTaskParam4Dirty();
            }
            case 33: {
                return pSDCBKTaskBase.isTaskParamsDirty();
            }
            case 34: {
                return pSDCBKTaskBase.isTaskStateDirty();
            }
            case 35: {
                return pSDCBKTaskBase.isTaskTypeDirty();
            }
            case 36: {
                return pSDCBKTaskBase.isTotalTimeDirty();
            }
            case 37: {
                return pSDCBKTaskBase.isUpdateDateDirty();
            }
            case 38: {
                return pSDCBKTaskBase.isUpdateManDirty();
            }
            case 39: {
                return pSDCBKTaskBase.isUseRobotFlagDirty();
            }
            case 40: {
                return pSDCBKTaskBase.isUserTagDirty();
            }
            case 41: {
                return pSDCBKTaskBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCBKTaskBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCBKTaskBase pSDCBKTaskBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCBKTaskBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getFullResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullresultinfo", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getFullResultInfo()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getLastCalcTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcalctime", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getLastCalcTime()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPlanPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planpsdcrobotid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPlanPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPlanPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planpsdcrobotname", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPlanPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDCBKTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbktaskid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDCBKTaskId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDCBKTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcbktaskname", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDCBKTaskName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getQueueInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueinfo", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getQueueInfo()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getRemainingTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remainingtime", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getRemainingTime()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getResultInfo()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getStepInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stepinfo", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getStepInfo()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskParam()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam2", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskParam2()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam3", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskParam3()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam4", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskParam4()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparams", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskParams()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskstate", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskState()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTaskType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tasktype", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTaskType()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getTotalTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"totaltime", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getTotalTime()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getUseRobotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userobotflag", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getUseRobotFlag()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDCBKTaskBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDCBKTaskBase.getJSONValue((Object)pSDCBKTaskBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCBKTaskBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCBKTaskBase pSDCBKTaskBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCBKTaskBase.getBeginTime() != null) {
            object = pSDCBKTaskBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getCreateDate() != null) {
            object = pSDCBKTaskBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getCreateMan() != null) {
            object = pSDCBKTaskBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getEndTime() != null) {
            object = pSDCBKTaskBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getFullResultInfo() != null) {
            object = pSDCBKTaskBase.getFullResultInfo();
            xmlNode.setAttribute(FIELD_FULLRESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getLastCalcTime() != null) {
            object = pSDCBKTaskBase.getLastCalcTime();
            xmlNode.setAttribute(FIELD_LASTCALCTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getMemo() != null) {
            object = pSDCBKTaskBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getOrderValue() != null) {
            object = pSDCBKTaskBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getPlanPSDCRobotId() != null) {
            object = pSDCBKTaskBase.getPlanPSDCRobotId();
            xmlNode.setAttribute(FIELD_PLANPSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPlanPSDCRobotName() != null) {
            object = pSDCBKTaskBase.getPlanPSDCRobotName();
            xmlNode.setAttribute(FIELD_PLANPSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDCBKTaskId() != null) {
            object = pSDCBKTaskBase.getPSDCBKTaskId();
            xmlNode.setAttribute(FIELD_PSDCBKTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDCBKTaskName() != null) {
            object = pSDCBKTaskBase.getPSDCBKTaskName();
            xmlNode.setAttribute(FIELD_PSDCBKTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDCRobotId() != null) {
            object = pSDCBKTaskBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDCRobotName() != null) {
            object = pSDCBKTaskBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevCenterId() != null) {
            object = pSDCBKTaskBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevCenterName() != null) {
            object = pSDCBKTaskBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnId() != null) {
            object = pSDCBKTaskBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnName() != null) {
            object = pSDCBKTaskBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnSysId() != null) {
            object = pSDCBKTaskBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDevSlnSysName() != null) {
            object = pSDCBKTaskBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDSConsoleId() != null) {
            object = pSDCBKTaskBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSDynaInstId() != null) {
            object = pSDCBKTaskBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSTaskServerId() != null) {
            object = pSDCBKTaskBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getPSTaskServerName() != null) {
            object = pSDCBKTaskBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getQueueInfo() != null) {
            object = pSDCBKTaskBase.getQueueInfo();
            xmlNode.setAttribute(FIELD_QUEUEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getRemainingTime() != null) {
            object = pSDCBKTaskBase.getRemainingTime();
            xmlNode.setAttribute(FIELD_REMAININGTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getRemoteAddr() != null) {
            object = pSDCBKTaskBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getResultInfo() != null) {
            object = pSDCBKTaskBase.getResultInfo();
            xmlNode.setAttribute(FIELD_RESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getStepInfo() != null) {
            object = pSDCBKTaskBase.getStepInfo();
            xmlNode.setAttribute(FIELD_STEPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskParam() != null) {
            object = pSDCBKTaskBase.getTaskParam();
            xmlNode.setAttribute(FIELD_TASKPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskParam2() != null) {
            object = pSDCBKTaskBase.getTaskParam2();
            xmlNode.setAttribute(FIELD_TASKPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskParam3() != null) {
            object = pSDCBKTaskBase.getTaskParam3();
            xmlNode.setAttribute(FIELD_TASKPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskParam4() != null) {
            object = pSDCBKTaskBase.getTaskParam4();
            xmlNode.setAttribute(FIELD_TASKPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskParams() != null) {
            object = pSDCBKTaskBase.getTaskParams();
            xmlNode.setAttribute(FIELD_TASKPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTaskState() != null) {
            object = pSDCBKTaskBase.getTaskState();
            xmlNode.setAttribute(FIELD_TASKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getTaskType() != null) {
            object = pSDCBKTaskBase.getTaskType();
            xmlNode.setAttribute(FIELD_TASKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getTotalTime() != null) {
            object = pSDCBKTaskBase.getTotalTime();
            xmlNode.setAttribute(FIELD_TOTALTIME, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getUpdateDate() != null) {
            object = pSDCBKTaskBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getUpdateMan() != null) {
            object = pSDCBKTaskBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getUseRobotFlag() != null) {
            object = pSDCBKTaskBase.getUseRobotFlag();
            xmlNode.setAttribute(FIELD_USEROBOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCBKTaskBase.getUserTag() != null) {
            object = pSDCBKTaskBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDCBKTaskBase.getUserTag2() != null) {
            object = pSDCBKTaskBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCBKTaskBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCBKTaskBase pSDCBKTaskBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCBKTaskBase.isBeginTimeDirty() && (bl || pSDCBKTaskBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDCBKTaskBase.getBeginTime());
        }
        if (pSDCBKTaskBase.isCreateDateDirty() && (bl || pSDCBKTaskBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCBKTaskBase.getCreateDate());
        }
        if (pSDCBKTaskBase.isCreateManDirty() && (bl || pSDCBKTaskBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCBKTaskBase.getCreateMan());
        }
        if (pSDCBKTaskBase.isEndTimeDirty() && (bl || pSDCBKTaskBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDCBKTaskBase.getEndTime());
        }
        if (pSDCBKTaskBase.isFullResultInfoDirty() && (bl || pSDCBKTaskBase.getFullResultInfo() != null)) {
            iDataObject.set(FIELD_FULLRESULTINFO, (Object)pSDCBKTaskBase.getFullResultInfo());
        }
        if (pSDCBKTaskBase.isLastCalcTimeDirty() && (bl || pSDCBKTaskBase.getLastCalcTime() != null)) {
            iDataObject.set(FIELD_LASTCALCTIME, (Object)pSDCBKTaskBase.getLastCalcTime());
        }
        if (pSDCBKTaskBase.isMemoDirty() && (bl || pSDCBKTaskBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCBKTaskBase.getMemo());
        }
        if (pSDCBKTaskBase.isOrderValueDirty() && (bl || pSDCBKTaskBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDCBKTaskBase.getOrderValue());
        }
        if (pSDCBKTaskBase.isPlanPSDCRobotIdDirty() && (bl || pSDCBKTaskBase.getPlanPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PLANPSDCROBOTID, (Object)pSDCBKTaskBase.getPlanPSDCRobotId());
        }
        if (pSDCBKTaskBase.isPlanPSDCRobotNameDirty() && (bl || pSDCBKTaskBase.getPlanPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PLANPSDCROBOTNAME, (Object)pSDCBKTaskBase.getPlanPSDCRobotName());
        }
        if (pSDCBKTaskBase.isPSDCBKTaskIdDirty() && (bl || pSDCBKTaskBase.getPSDCBKTaskId() != null)) {
            iDataObject.set(FIELD_PSDCBKTASKID, (Object)pSDCBKTaskBase.getPSDCBKTaskId());
        }
        if (pSDCBKTaskBase.isPSDCBKTaskNameDirty() && (bl || pSDCBKTaskBase.getPSDCBKTaskName() != null)) {
            iDataObject.set(FIELD_PSDCBKTASKNAME, (Object)pSDCBKTaskBase.getPSDCBKTaskName());
        }
        if (pSDCBKTaskBase.isPSDCRobotIdDirty() && (bl || pSDCBKTaskBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSDCBKTaskBase.getPSDCRobotId());
        }
        if (pSDCBKTaskBase.isPSDCRobotNameDirty() && (bl || pSDCBKTaskBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSDCBKTaskBase.getPSDCRobotName());
        }
        if (pSDCBKTaskBase.isPSDevCenterIdDirty() && (bl || pSDCBKTaskBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCBKTaskBase.getPSDevCenterId());
        }
        if (pSDCBKTaskBase.isPSDevCenterNameDirty() && (bl || pSDCBKTaskBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCBKTaskBase.getPSDevCenterName());
        }
        if (pSDCBKTaskBase.isPSDevSlnIdDirty() && (bl || pSDCBKTaskBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDCBKTaskBase.getPSDevSlnId());
        }
        if (pSDCBKTaskBase.isPSDevSlnNameDirty() && (bl || pSDCBKTaskBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDCBKTaskBase.getPSDevSlnName());
        }
        if (pSDCBKTaskBase.isPSDevSlnSysIdDirty() && (bl || pSDCBKTaskBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDCBKTaskBase.getPSDevSlnSysId());
        }
        if (pSDCBKTaskBase.isPSDevSlnSysNameDirty() && (bl || pSDCBKTaskBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDCBKTaskBase.getPSDevSlnSysName());
        }
        if (pSDCBKTaskBase.isPSDSConsoleIdDirty() && (bl || pSDCBKTaskBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSDCBKTaskBase.getPSDSConsoleId());
        }
        if (pSDCBKTaskBase.isPSDynaInstIdDirty() && (bl || pSDCBKTaskBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDCBKTaskBase.getPSDynaInstId());
        }
        if (pSDCBKTaskBase.isPSTaskServerIdDirty() && (bl || pSDCBKTaskBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDCBKTaskBase.getPSTaskServerId());
        }
        if (pSDCBKTaskBase.isPSTaskServerNameDirty() && (bl || pSDCBKTaskBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDCBKTaskBase.getPSTaskServerName());
        }
        if (pSDCBKTaskBase.isQueueInfoDirty() && (bl || pSDCBKTaskBase.getQueueInfo() != null)) {
            iDataObject.set(FIELD_QUEUEINFO, (Object)pSDCBKTaskBase.getQueueInfo());
        }
        if (pSDCBKTaskBase.isRemainingTimeDirty() && (bl || pSDCBKTaskBase.getRemainingTime() != null)) {
            iDataObject.set(FIELD_REMAININGTIME, (Object)pSDCBKTaskBase.getRemainingTime());
        }
        if (pSDCBKTaskBase.isRemoteAddrDirty() && (bl || pSDCBKTaskBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSDCBKTaskBase.getRemoteAddr());
        }
        if (pSDCBKTaskBase.isResultInfoDirty() && (bl || pSDCBKTaskBase.getResultInfo() != null)) {
            iDataObject.set(FIELD_RESULTINFO, (Object)pSDCBKTaskBase.getResultInfo());
        }
        if (pSDCBKTaskBase.isStepInfoDirty() && (bl || pSDCBKTaskBase.getStepInfo() != null)) {
            iDataObject.set(FIELD_STEPINFO, (Object)pSDCBKTaskBase.getStepInfo());
        }
        if (pSDCBKTaskBase.isTaskParamDirty() && (bl || pSDCBKTaskBase.getTaskParam() != null)) {
            iDataObject.set(FIELD_TASKPARAM, (Object)pSDCBKTaskBase.getTaskParam());
        }
        if (pSDCBKTaskBase.isTaskParam2Dirty() && (bl || pSDCBKTaskBase.getTaskParam2() != null)) {
            iDataObject.set(FIELD_TASKPARAM2, (Object)pSDCBKTaskBase.getTaskParam2());
        }
        if (pSDCBKTaskBase.isTaskParam3Dirty() && (bl || pSDCBKTaskBase.getTaskParam3() != null)) {
            iDataObject.set(FIELD_TASKPARAM3, (Object)pSDCBKTaskBase.getTaskParam3());
        }
        if (pSDCBKTaskBase.isTaskParam4Dirty() && (bl || pSDCBKTaskBase.getTaskParam4() != null)) {
            iDataObject.set(FIELD_TASKPARAM4, (Object)pSDCBKTaskBase.getTaskParam4());
        }
        if (pSDCBKTaskBase.isTaskParamsDirty() && (bl || pSDCBKTaskBase.getTaskParams() != null)) {
            iDataObject.set(FIELD_TASKPARAMS, (Object)pSDCBKTaskBase.getTaskParams());
        }
        if (pSDCBKTaskBase.isTaskStateDirty() && (bl || pSDCBKTaskBase.getTaskState() != null)) {
            iDataObject.set(FIELD_TASKSTATE, (Object)pSDCBKTaskBase.getTaskState());
        }
        if (pSDCBKTaskBase.isTaskTypeDirty() && (bl || pSDCBKTaskBase.getTaskType() != null)) {
            iDataObject.set(FIELD_TASKTYPE, (Object)pSDCBKTaskBase.getTaskType());
        }
        if (pSDCBKTaskBase.isTotalTimeDirty() && (bl || pSDCBKTaskBase.getTotalTime() != null)) {
            iDataObject.set(FIELD_TOTALTIME, (Object)pSDCBKTaskBase.getTotalTime());
        }
        if (pSDCBKTaskBase.isUpdateDateDirty() && (bl || pSDCBKTaskBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCBKTaskBase.getUpdateDate());
        }
        if (pSDCBKTaskBase.isUpdateManDirty() && (bl || pSDCBKTaskBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCBKTaskBase.getUpdateMan());
        }
        if (pSDCBKTaskBase.isUseRobotFlagDirty() && (bl || pSDCBKTaskBase.getUseRobotFlag() != null)) {
            iDataObject.set(FIELD_USEROBOTFLAG, (Object)pSDCBKTaskBase.getUseRobotFlag());
        }
        if (pSDCBKTaskBase.isUserTagDirty() && (bl || pSDCBKTaskBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDCBKTaskBase.getUserTag());
        }
        if (pSDCBKTaskBase.isUserTag2Dirty() && (bl || pSDCBKTaskBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDCBKTaskBase.getUserTag2());
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
        return PSDCBKTaskBase.remove(this, n);
    }

    private static boolean remove(PSDCBKTaskBase pSDCBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCBKTaskBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSDCBKTaskBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDCBKTaskBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDCBKTaskBase.resetEndTime();
                return true;
            }
            case 4: {
                pSDCBKTaskBase.resetFullResultInfo();
                return true;
            }
            case 5: {
                pSDCBKTaskBase.resetLastCalcTime();
                return true;
            }
            case 6: {
                pSDCBKTaskBase.resetMemo();
                return true;
            }
            case 7: {
                pSDCBKTaskBase.resetOrderValue();
                return true;
            }
            case 8: {
                pSDCBKTaskBase.resetPlanPSDCRobotId();
                return true;
            }
            case 9: {
                pSDCBKTaskBase.resetPlanPSDCRobotName();
                return true;
            }
            case 10: {
                pSDCBKTaskBase.resetPSDCBKTaskId();
                return true;
            }
            case 11: {
                pSDCBKTaskBase.resetPSDCBKTaskName();
                return true;
            }
            case 12: {
                pSDCBKTaskBase.resetPSDCRobotId();
                return true;
            }
            case 13: {
                pSDCBKTaskBase.resetPSDCRobotName();
                return true;
            }
            case 14: {
                pSDCBKTaskBase.resetPSDevCenterId();
                return true;
            }
            case 15: {
                pSDCBKTaskBase.resetPSDevCenterName();
                return true;
            }
            case 16: {
                pSDCBKTaskBase.resetPSDevSlnId();
                return true;
            }
            case 17: {
                pSDCBKTaskBase.resetPSDevSlnName();
                return true;
            }
            case 18: {
                pSDCBKTaskBase.resetPSDevSlnSysId();
                return true;
            }
            case 19: {
                pSDCBKTaskBase.resetPSDevSlnSysName();
                return true;
            }
            case 20: {
                pSDCBKTaskBase.resetPSDSConsoleId();
                return true;
            }
            case 21: {
                pSDCBKTaskBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSDCBKTaskBase.resetPSTaskServerId();
                return true;
            }
            case 23: {
                pSDCBKTaskBase.resetPSTaskServerName();
                return true;
            }
            case 24: {
                pSDCBKTaskBase.resetQueueInfo();
                return true;
            }
            case 25: {
                pSDCBKTaskBase.resetRemainingTime();
                return true;
            }
            case 26: {
                pSDCBKTaskBase.resetRemoteAddr();
                return true;
            }
            case 27: {
                pSDCBKTaskBase.resetResultInfo();
                return true;
            }
            case 28: {
                pSDCBKTaskBase.resetStepInfo();
                return true;
            }
            case 29: {
                pSDCBKTaskBase.resetTaskParam();
                return true;
            }
            case 30: {
                pSDCBKTaskBase.resetTaskParam2();
                return true;
            }
            case 31: {
                pSDCBKTaskBase.resetTaskParam3();
                return true;
            }
            case 32: {
                pSDCBKTaskBase.resetTaskParam4();
                return true;
            }
            case 33: {
                pSDCBKTaskBase.resetTaskParams();
                return true;
            }
            case 34: {
                pSDCBKTaskBase.resetTaskState();
                return true;
            }
            case 35: {
                pSDCBKTaskBase.resetTaskType();
                return true;
            }
            case 36: {
                pSDCBKTaskBase.resetTotalTime();
                return true;
            }
            case 37: {
                pSDCBKTaskBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSDCBKTaskBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSDCBKTaskBase.resetUseRobotFlag();
                return true;
            }
            case 40: {
                pSDCBKTaskBase.resetUserTag();
                return true;
            }
            case 41: {
                pSDCBKTaskBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCRobot getPlanPSDCRobot() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPlanPSDCRobot();
        }
        if (this.getPlanPSDCRobotId() == null) {
            return null;
        }
        Integer n = this.objPlanPSDCRobotLock;
        synchronized (n) {
            if (this.planpsdcrobot != null && DataTypeHelper.compare((int)25, (Object)this.getPlanPSDCRobotId(), (Object)this.planpsdcrobot.getPSDCRobotId()) != 0L) {
                this.planpsdcrobot = null;
            }
            if (this.planpsdcrobot == null) {
                PSDCRobot pSDCRobot = new PSDCRobot();
                pSDCRobot.setPSDCRobotId(this.getPlanPSDCRobotId());
                PSDCRobotService pSDCRobotService = (PSDCRobotService)ServiceGlobal.getService(PSDCRobotService.class, (SessionFactory)this.getSessionFactory());
                pSDCRobotService.autoGet((IEntity)pSDCRobot);
                this.planpsdcrobot = pSDCRobot;
            }
            return this.planpsdcrobot;
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
                pSDCRobotService.autoGet((IEntity)pSDCRobot);
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

    private PSDCBKTaskBase getProxyEntity() {
        return this.proxyPSDCBKTaskBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCBKTaskBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCBKTaskBase) {
            this.proxyPSDCBKTaskBase = (PSDCBKTaskBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCBKTaskService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_FULLRESULTINFO, 4);
        fieldIndexMap.put(FIELD_LASTCALCTIME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_ORDERVALUE, 7);
        fieldIndexMap.put(FIELD_PLANPSDCROBOTID, 8);
        fieldIndexMap.put(FIELD_PLANPSDCROBOTNAME, 9);
        fieldIndexMap.put(FIELD_PSDCBKTASKID, 10);
        fieldIndexMap.put(FIELD_PSDCBKTASKNAME, 11);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 12);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 13);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 14);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 16);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 17);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 18);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 19);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 22);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 23);
        fieldIndexMap.put(FIELD_QUEUEINFO, 24);
        fieldIndexMap.put(FIELD_REMAININGTIME, 25);
        fieldIndexMap.put(FIELD_REMOTEADDR, 26);
        fieldIndexMap.put(FIELD_RESULTINFO, 27);
        fieldIndexMap.put(FIELD_STEPINFO, 28);
        fieldIndexMap.put(FIELD_TASKPARAM, 29);
        fieldIndexMap.put(FIELD_TASKPARAM2, 30);
        fieldIndexMap.put(FIELD_TASKPARAM3, 31);
        fieldIndexMap.put(FIELD_TASKPARAM4, 32);
        fieldIndexMap.put(FIELD_TASKPARAMS, 33);
        fieldIndexMap.put(FIELD_TASKSTATE, 34);
        fieldIndexMap.put(FIELD_TASKTYPE, 35);
        fieldIndexMap.put(FIELD_TOTALTIME, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USEROBOTFLAG, 39);
        fieldIndexMap.put(FIELD_USERTAG, 40);
        fieldIndexMap.put(FIELD_USERTAG2, 41);
    }
}

