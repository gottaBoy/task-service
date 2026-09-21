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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCRobot;
import net.ibizsys.pscore.srv.devcenter.service.PSDCRobotService;
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSSysDevBKTask;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDevBKTaskBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDevBKTaskBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FULLRESULTINFO = "FULLRESULTINFO";
    public static final String FIELD_LINKINFO = "LINKINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELLEVEL = "MODELLEVEL";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLANPSDCROBOTID = "PLANPSDCROBOTID";
    public static final String FIELD_PLANPSDCROBOTNAME = "PLANPSDCROBOTNAME";
    public static final String FIELD_PPSSYSDEVBKTASKID = "PPSSYSDEVBKTASKID";
    public static final String FIELD_PPSSYSDEVBKTASKNAME = "PPSSYSDEVBKTASKNAME";
    public static final String FIELD_PSDCROBOTID = "PSDCROBOTID";
    public static final String FIELD_PSDCROBOTNAME = "PSDCROBOTNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDSCONSOLEID = "PSDSCONSOLEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSDEVBKTASKID = "PSSYSDEVBKTASKID";
    public static final String FIELD_PSSYSDEVBKTASKNAME = "PSSYSDEVBKTASKNAME";
    public static final String FIELD_PSSYSMODELINSTID = "PSSYSMODELINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_QUEUEINFO = "QUEUEINFO";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_RESULTINFO = "RESULTINFO";
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
    private static final int INDEX_FULLRESULTINFO = 4;
    private static final int INDEX_LINKINFO = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELLEVEL = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PLANPSDCROBOTID = 9;
    private static final int INDEX_PLANPSDCROBOTNAME = 10;
    private static final int INDEX_PPSSYSDEVBKTASKID = 11;
    private static final int INDEX_PPSSYSDEVBKTASKNAME = 12;
    private static final int INDEX_PSDCROBOTID = 13;
    private static final int INDEX_PSDCROBOTNAME = 14;
    private static final int INDEX_PSDEVSLNID = 15;
    private static final int INDEX_PSDEVSLNSYSID = 16;
    private static final int INDEX_PSDSCONSOLEID = 17;
    private static final int INDEX_PSDYNAINSTID = 18;
    private static final int INDEX_PSSYSDEVBKTASKID = 19;
    private static final int INDEX_PSSYSDEVBKTASKNAME = 20;
    private static final int INDEX_PSSYSMODELINSTID = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_PSSYSTEMNAME = 23;
    private static final int INDEX_PSTASKSERVERID = 24;
    private static final int INDEX_PSTASKSERVERNAME = 25;
    private static final int INDEX_QUEUEINFO = 26;
    private static final int INDEX_REMOTEADDR = 27;
    private static final int INDEX_RESULTINFO = 28;
    private static final int INDEX_TASKPARAM = 29;
    private static final int INDEX_TASKPARAM2 = 30;
    private static final int INDEX_TASKPARAM3 = 31;
    private static final int INDEX_TASKPARAM4 = 32;
    private static final int INDEX_TASKSTATE = 33;
    private static final int INDEX_TASKTYPE = 34;
    private static final int INDEX_UPDATEDATE = 35;
    private static final int INDEX_UPDATEMAN = 36;
    private static final int INDEX_USEROBOTFLAG = 37;
    private static final int INDEX_USERTAG = 38;
    private static final int INDEX_USERTAG2 = 39;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDevBKTaskBase proxyPSSysDevBKTaskBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fullresultinfoDirtyFlag = false;
    private boolean linkinfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modellevelDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean planpsdcrobotidDirtyFlag = false;
    private boolean planpsdcrobotnameDirtyFlag = false;
    private boolean ppssysdevbktaskidDirtyFlag = false;
    private boolean ppssysdevbktasknameDirtyFlag = false;
    private boolean psdcrobotidDirtyFlag = false;
    private boolean psdcrobotnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdsconsoleidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssysdevbktaskidDirtyFlag = false;
    private boolean pssysdevbktasknameDirtyFlag = false;
    private boolean pssysmodelinstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean queueinfoDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean resultinfoDirtyFlag = false;
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
    @Column(name="fullresultinfo")
    private String fullresultinfo;
    @Column(name="linkinfo")
    private String linkinfo;
    @Column(name="memo")
    private String memo;
    @Column(name="modellevel")
    private Integer modellevel;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="planpsdcrobotid")
    private String planpsdcrobotid;
    @Column(name="planpsdcrobotname")
    private String planpsdcrobotname;
    @Column(name="ppssysdevbktaskid")
    private String ppssysdevbktaskid;
    @Column(name="ppssysdevbktaskname")
    private String ppssysdevbktaskname;
    @Column(name="psdcrobotid")
    private String psdcrobotid;
    @Column(name="psdcrobotname")
    private String psdcrobotname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdsconsoleid")
    private String psdsconsoleid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssysdevbktaskid")
    private String pssysdevbktaskid;
    @Column(name="pssysdevbktaskname")
    private String pssysdevbktaskname;
    @Column(name="pssysmodelinstid")
    private String pssysmodelinstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="queueinfo")
    private String queueinfo;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="resultinfo")
    private String resultinfo;
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
    private Integer objPlanPSDCRobotLock = new Integer(1);
    private PSDCRobot planpsdcrobot = null;
    private Integer objPSDCRobotLock = new Integer(1);
    private PSDCRobot psdcrobot = null;
    private Integer objPPSysDevBKTaskLock = new Integer(1);
    private PSSysDevBKTask ppsysdevbktask = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
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

    public void setLinkInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkinfo = string;
        this.linkinfoDirtyFlag = true;
    }

    public String getLinkInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkInfo();
        }
        return this.linkinfo;
    }

    public boolean isLinkInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkInfoDirty();
        }
        return this.linkinfoDirtyFlag;
    }

    public void resetLinkInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkInfo();
            return;
        }
        this.linkinfoDirtyFlag = false;
        this.linkinfo = null;
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

    public void setModelLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelLevel(n);
            return;
        }
        this.modellevel = n;
        this.modellevelDirtyFlag = true;
    }

    public Integer getModelLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelLevel();
        }
        return this.modellevel;
    }

    public boolean isModelLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelLevelDirty();
        }
        return this.modellevelDirtyFlag;
    }

    public void resetModelLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelLevel();
            return;
        }
        this.modellevelDirtyFlag = false;
        this.modellevel = null;
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

    public void setPPSSysDevBKTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDevBKTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdevbktaskid = string;
        this.ppssysdevbktaskidDirtyFlag = true;
    }

    public String getPPSSysDevBKTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDevBKTaskId();
        }
        return this.ppssysdevbktaskid;
    }

    public boolean isPPSSysDevBKTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDevBKTaskIdDirty();
        }
        return this.ppssysdevbktaskidDirtyFlag;
    }

    public void resetPPSSysDevBKTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDevBKTaskId();
            return;
        }
        this.ppssysdevbktaskidDirtyFlag = false;
        this.ppssysdevbktaskid = null;
    }

    public void setPPSSysDevBKTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDevBKTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdevbktaskname = string;
        this.ppssysdevbktasknameDirtyFlag = true;
    }

    public String getPPSSysDevBKTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDevBKTaskName();
        }
        return this.ppssysdevbktaskname;
    }

    public boolean isPPSSysDevBKTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDevBKTaskNameDirty();
        }
        return this.ppssysdevbktasknameDirtyFlag;
    }

    public void resetPPSSysDevBKTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDevBKTaskName();
            return;
        }
        this.ppssysdevbktasknameDirtyFlag = false;
        this.ppssysdevbktaskname = null;
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

    public void setPSSysDevBKTaskId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevBKTaskId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevbktaskid = string;
        this.pssysdevbktaskidDirtyFlag = true;
    }

    public String getPSSysDevBKTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBKTaskId();
        }
        return this.pssysdevbktaskid;
    }

    public boolean isPSSysDevBKTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevBKTaskIdDirty();
        }
        return this.pssysdevbktaskidDirtyFlag;
    }

    public void resetPSSysDevBKTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevBKTaskId();
            return;
        }
        this.pssysdevbktaskidDirtyFlag = false;
        this.pssysdevbktaskid = null;
    }

    public void setPSSysDevBKTaskName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDevBKTaskName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdevbktaskname = string;
        this.pssysdevbktasknameDirtyFlag = true;
    }

    public String getPSSysDevBKTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDevBKTaskName();
        }
        return this.pssysdevbktaskname;
    }

    public boolean isPSSysDevBKTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDevBKTaskNameDirty();
        }
        return this.pssysdevbktasknameDirtyFlag;
    }

    public void resetPSSysDevBKTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDevBKTaskName();
            return;
        }
        this.pssysdevbktasknameDirtyFlag = false;
        this.pssysdevbktaskname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSSysDevBKTaskBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDevBKTaskBase pSSysDevBKTaskBase) {
        pSSysDevBKTaskBase.resetBeginTime();
        pSSysDevBKTaskBase.resetCreateDate();
        pSSysDevBKTaskBase.resetCreateMan();
        pSSysDevBKTaskBase.resetEndTime();
        pSSysDevBKTaskBase.resetFullResultInfo();
        pSSysDevBKTaskBase.resetLinkInfo();
        pSSysDevBKTaskBase.resetMemo();
        pSSysDevBKTaskBase.resetModelLevel();
        pSSysDevBKTaskBase.resetOrderValue();
        pSSysDevBKTaskBase.resetPlanPSDCRobotId();
        pSSysDevBKTaskBase.resetPlanPSDCRobotName();
        pSSysDevBKTaskBase.resetPPSSysDevBKTaskId();
        pSSysDevBKTaskBase.resetPPSSysDevBKTaskName();
        pSSysDevBKTaskBase.resetPSDCRobotId();
        pSSysDevBKTaskBase.resetPSDCRobotName();
        pSSysDevBKTaskBase.resetPSDevSlnId();
        pSSysDevBKTaskBase.resetPSDevSlnSysId();
        pSSysDevBKTaskBase.resetPSDSConsoleId();
        pSSysDevBKTaskBase.resetPSDynaInstId();
        pSSysDevBKTaskBase.resetPSSysDevBKTaskId();
        pSSysDevBKTaskBase.resetPSSysDevBKTaskName();
        pSSysDevBKTaskBase.resetPSSysModelInstId();
        pSSysDevBKTaskBase.resetPSSystemId();
        pSSysDevBKTaskBase.resetPSSystemName();
        pSSysDevBKTaskBase.resetPSTaskServerId();
        pSSysDevBKTaskBase.resetPSTaskServerName();
        pSSysDevBKTaskBase.resetQueueInfo();
        pSSysDevBKTaskBase.resetRemoteAddr();
        pSSysDevBKTaskBase.resetResultInfo();
        pSSysDevBKTaskBase.resetTaskParam();
        pSSysDevBKTaskBase.resetTaskParam2();
        pSSysDevBKTaskBase.resetTaskParam3();
        pSSysDevBKTaskBase.resetTaskParam4();
        pSSysDevBKTaskBase.resetTaskState();
        pSSysDevBKTaskBase.resetTaskType();
        pSSysDevBKTaskBase.resetUpdateDate();
        pSSysDevBKTaskBase.resetUpdateMan();
        pSSysDevBKTaskBase.resetUseRobotFlag();
        pSSysDevBKTaskBase.resetUserTag();
        pSSysDevBKTaskBase.resetUserTag2();
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
        if (!bl || this.isLinkInfoDirty()) {
            hashMap.put(FIELD_LINKINFO, this.getLinkInfo());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelLevelDirty()) {
            hashMap.put(FIELD_MODELLEVEL, this.getModelLevel());
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
        if (!bl || this.isPPSSysDevBKTaskIdDirty()) {
            hashMap.put(FIELD_PPSSYSDEVBKTASKID, this.getPPSSysDevBKTaskId());
        }
        if (!bl || this.isPPSSysDevBKTaskNameDirty()) {
            hashMap.put(FIELD_PPSSYSDEVBKTASKNAME, this.getPPSSysDevBKTaskName());
        }
        if (!bl || this.isPSDCRobotIdDirty()) {
            hashMap.put(FIELD_PSDCROBOTID, this.getPSDCRobotId());
        }
        if (!bl || this.isPSDCRobotNameDirty()) {
            hashMap.put(FIELD_PSDCROBOTNAME, this.getPSDCRobotName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDSConsoleIdDirty()) {
            hashMap.put(FIELD_PSDSCONSOLEID, this.getPSDSConsoleId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysDevBKTaskIdDirty()) {
            hashMap.put(FIELD_PSSYSDEVBKTASKID, this.getPSSysDevBKTaskId());
        }
        if (!bl || this.isPSSysDevBKTaskNameDirty()) {
            hashMap.put(FIELD_PSSYSDEVBKTASKNAME, this.getPSSysDevBKTaskName());
        }
        if (!bl || this.isPSSysModelInstIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELINSTID, this.getPSSysModelInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        if (!bl || this.isRemoteAddrDirty()) {
            hashMap.put(FIELD_REMOTEADDR, this.getRemoteAddr());
        }
        if (!bl || this.isResultInfoDirty()) {
            hashMap.put(FIELD_RESULTINFO, this.getResultInfo());
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
        return PSSysDevBKTaskBase.get(this, n);
    }

    private static Object get(PSSysDevBKTaskBase pSSysDevBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBKTaskBase.getBeginTime();
            }
            case 1: {
                return pSSysDevBKTaskBase.getCreateDate();
            }
            case 2: {
                return pSSysDevBKTaskBase.getCreateMan();
            }
            case 3: {
                return pSSysDevBKTaskBase.getEndTime();
            }
            case 4: {
                return pSSysDevBKTaskBase.getFullResultInfo();
            }
            case 5: {
                return pSSysDevBKTaskBase.getLinkInfo();
            }
            case 6: {
                return pSSysDevBKTaskBase.getMemo();
            }
            case 7: {
                return pSSysDevBKTaskBase.getModelLevel();
            }
            case 8: {
                return pSSysDevBKTaskBase.getOrderValue();
            }
            case 9: {
                return pSSysDevBKTaskBase.getPlanPSDCRobotId();
            }
            case 10: {
                return pSSysDevBKTaskBase.getPlanPSDCRobotName();
            }
            case 11: {
                return pSSysDevBKTaskBase.getPPSSysDevBKTaskId();
            }
            case 12: {
                return pSSysDevBKTaskBase.getPPSSysDevBKTaskName();
            }
            case 13: {
                return pSSysDevBKTaskBase.getPSDCRobotId();
            }
            case 14: {
                return pSSysDevBKTaskBase.getPSDCRobotName();
            }
            case 15: {
                return pSSysDevBKTaskBase.getPSDevSlnId();
            }
            case 16: {
                return pSSysDevBKTaskBase.getPSDevSlnSysId();
            }
            case 17: {
                return pSSysDevBKTaskBase.getPSDSConsoleId();
            }
            case 18: {
                return pSSysDevBKTaskBase.getPSDynaInstId();
            }
            case 19: {
                return pSSysDevBKTaskBase.getPSSysDevBKTaskId();
            }
            case 20: {
                return pSSysDevBKTaskBase.getPSSysDevBKTaskName();
            }
            case 21: {
                return pSSysDevBKTaskBase.getPSSysModelInstId();
            }
            case 22: {
                return pSSysDevBKTaskBase.getPSSystemId();
            }
            case 23: {
                return pSSysDevBKTaskBase.getPSSystemName();
            }
            case 24: {
                return pSSysDevBKTaskBase.getPSTaskServerId();
            }
            case 25: {
                return pSSysDevBKTaskBase.getPSTaskServerName();
            }
            case 26: {
                return pSSysDevBKTaskBase.getQueueInfo();
            }
            case 27: {
                return pSSysDevBKTaskBase.getRemoteAddr();
            }
            case 28: {
                return pSSysDevBKTaskBase.getResultInfo();
            }
            case 29: {
                return pSSysDevBKTaskBase.getTaskParam();
            }
            case 30: {
                return pSSysDevBKTaskBase.getTaskParam2();
            }
            case 31: {
                return pSSysDevBKTaskBase.getTaskParam3();
            }
            case 32: {
                return pSSysDevBKTaskBase.getTaskParam4();
            }
            case 33: {
                return pSSysDevBKTaskBase.getTaskState();
            }
            case 34: {
                return pSSysDevBKTaskBase.getTaskType();
            }
            case 35: {
                return pSSysDevBKTaskBase.getUpdateDate();
            }
            case 36: {
                return pSSysDevBKTaskBase.getUpdateMan();
            }
            case 37: {
                return pSSysDevBKTaskBase.getUseRobotFlag();
            }
            case 38: {
                return pSSysDevBKTaskBase.getUserTag();
            }
            case 39: {
                return pSSysDevBKTaskBase.getUserTag2();
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
        PSSysDevBKTaskBase.set(this, n, object);
    }

    private static void set(PSSysDevBKTaskBase pSSysDevBKTaskBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevBKTaskBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDevBKTaskBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysDevBKTaskBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDevBKTaskBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysDevBKTaskBase.setFullResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDevBKTaskBase.setLinkInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDevBKTaskBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDevBKTaskBase.setModelLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysDevBKTaskBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDevBKTaskBase.setPlanPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDevBKTaskBase.setPlanPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDevBKTaskBase.setPPSSysDevBKTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDevBKTaskBase.setPPSSysDevBKTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysDevBKTaskBase.setPSDCRobotId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDevBKTaskBase.setPSDCRobotName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDevBKTaskBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDevBKTaskBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysDevBKTaskBase.setPSDSConsoleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDevBKTaskBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysDevBKTaskBase.setPSSysDevBKTaskId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDevBKTaskBase.setPSSysDevBKTaskName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysDevBKTaskBase.setPSSysModelInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysDevBKTaskBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDevBKTaskBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDevBKTaskBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysDevBKTaskBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDevBKTaskBase.setQueueInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDevBKTaskBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDevBKTaskBase.setResultInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysDevBKTaskBase.setTaskParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysDevBKTaskBase.setTaskParam2(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDevBKTaskBase.setTaskParam3(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDevBKTaskBase.setTaskParam4(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDevBKTaskBase.setTaskState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSSysDevBKTaskBase.setTaskType(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDevBKTaskBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 36: {
                pSSysDevBKTaskBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDevBKTaskBase.setUseRobotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 38: {
                pSSysDevBKTaskBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDevBKTaskBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSSysDevBKTaskBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDevBKTaskBase pSSysDevBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBKTaskBase.getBeginTime() == null;
            }
            case 1: {
                return pSSysDevBKTaskBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysDevBKTaskBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysDevBKTaskBase.getEndTime() == null;
            }
            case 4: {
                return pSSysDevBKTaskBase.getFullResultInfo() == null;
            }
            case 5: {
                return pSSysDevBKTaskBase.getLinkInfo() == null;
            }
            case 6: {
                return pSSysDevBKTaskBase.getMemo() == null;
            }
            case 7: {
                return pSSysDevBKTaskBase.getModelLevel() == null;
            }
            case 8: {
                return pSSysDevBKTaskBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysDevBKTaskBase.getPlanPSDCRobotId() == null;
            }
            case 10: {
                return pSSysDevBKTaskBase.getPlanPSDCRobotName() == null;
            }
            case 11: {
                return pSSysDevBKTaskBase.getPPSSysDevBKTaskId() == null;
            }
            case 12: {
                return pSSysDevBKTaskBase.getPPSSysDevBKTaskName() == null;
            }
            case 13: {
                return pSSysDevBKTaskBase.getPSDCRobotId() == null;
            }
            case 14: {
                return pSSysDevBKTaskBase.getPSDCRobotName() == null;
            }
            case 15: {
                return pSSysDevBKTaskBase.getPSDevSlnId() == null;
            }
            case 16: {
                return pSSysDevBKTaskBase.getPSDevSlnSysId() == null;
            }
            case 17: {
                return pSSysDevBKTaskBase.getPSDSConsoleId() == null;
            }
            case 18: {
                return pSSysDevBKTaskBase.getPSDynaInstId() == null;
            }
            case 19: {
                return pSSysDevBKTaskBase.getPSSysDevBKTaskId() == null;
            }
            case 20: {
                return pSSysDevBKTaskBase.getPSSysDevBKTaskName() == null;
            }
            case 21: {
                return pSSysDevBKTaskBase.getPSSysModelInstId() == null;
            }
            case 22: {
                return pSSysDevBKTaskBase.getPSSystemId() == null;
            }
            case 23: {
                return pSSysDevBKTaskBase.getPSSystemName() == null;
            }
            case 24: {
                return pSSysDevBKTaskBase.getPSTaskServerId() == null;
            }
            case 25: {
                return pSSysDevBKTaskBase.getPSTaskServerName() == null;
            }
            case 26: {
                return pSSysDevBKTaskBase.getQueueInfo() == null;
            }
            case 27: {
                return pSSysDevBKTaskBase.getRemoteAddr() == null;
            }
            case 28: {
                return pSSysDevBKTaskBase.getResultInfo() == null;
            }
            case 29: {
                return pSSysDevBKTaskBase.getTaskParam() == null;
            }
            case 30: {
                return pSSysDevBKTaskBase.getTaskParam2() == null;
            }
            case 31: {
                return pSSysDevBKTaskBase.getTaskParam3() == null;
            }
            case 32: {
                return pSSysDevBKTaskBase.getTaskParam4() == null;
            }
            case 33: {
                return pSSysDevBKTaskBase.getTaskState() == null;
            }
            case 34: {
                return pSSysDevBKTaskBase.getTaskType() == null;
            }
            case 35: {
                return pSSysDevBKTaskBase.getUpdateDate() == null;
            }
            case 36: {
                return pSSysDevBKTaskBase.getUpdateMan() == null;
            }
            case 37: {
                return pSSysDevBKTaskBase.getUseRobotFlag() == null;
            }
            case 38: {
                return pSSysDevBKTaskBase.getUserTag() == null;
            }
            case 39: {
                return pSSysDevBKTaskBase.getUserTag2() == null;
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
        return PSSysDevBKTaskBase.contains(this, n);
    }

    private static boolean contains(PSSysDevBKTaskBase pSSysDevBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDevBKTaskBase.isBeginTimeDirty();
            }
            case 1: {
                return pSSysDevBKTaskBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysDevBKTaskBase.isCreateManDirty();
            }
            case 3: {
                return pSSysDevBKTaskBase.isEndTimeDirty();
            }
            case 4: {
                return pSSysDevBKTaskBase.isFullResultInfoDirty();
            }
            case 5: {
                return pSSysDevBKTaskBase.isLinkInfoDirty();
            }
            case 6: {
                return pSSysDevBKTaskBase.isMemoDirty();
            }
            case 7: {
                return pSSysDevBKTaskBase.isModelLevelDirty();
            }
            case 8: {
                return pSSysDevBKTaskBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysDevBKTaskBase.isPlanPSDCRobotIdDirty();
            }
            case 10: {
                return pSSysDevBKTaskBase.isPlanPSDCRobotNameDirty();
            }
            case 11: {
                return pSSysDevBKTaskBase.isPPSSysDevBKTaskIdDirty();
            }
            case 12: {
                return pSSysDevBKTaskBase.isPPSSysDevBKTaskNameDirty();
            }
            case 13: {
                return pSSysDevBKTaskBase.isPSDCRobotIdDirty();
            }
            case 14: {
                return pSSysDevBKTaskBase.isPSDCRobotNameDirty();
            }
            case 15: {
                return pSSysDevBKTaskBase.isPSDevSlnIdDirty();
            }
            case 16: {
                return pSSysDevBKTaskBase.isPSDevSlnSysIdDirty();
            }
            case 17: {
                return pSSysDevBKTaskBase.isPSDSConsoleIdDirty();
            }
            case 18: {
                return pSSysDevBKTaskBase.isPSDynaInstIdDirty();
            }
            case 19: {
                return pSSysDevBKTaskBase.isPSSysDevBKTaskIdDirty();
            }
            case 20: {
                return pSSysDevBKTaskBase.isPSSysDevBKTaskNameDirty();
            }
            case 21: {
                return pSSysDevBKTaskBase.isPSSysModelInstIdDirty();
            }
            case 22: {
                return pSSysDevBKTaskBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSSysDevBKTaskBase.isPSSystemNameDirty();
            }
            case 24: {
                return pSSysDevBKTaskBase.isPSTaskServerIdDirty();
            }
            case 25: {
                return pSSysDevBKTaskBase.isPSTaskServerNameDirty();
            }
            case 26: {
                return pSSysDevBKTaskBase.isQueueInfoDirty();
            }
            case 27: {
                return pSSysDevBKTaskBase.isRemoteAddrDirty();
            }
            case 28: {
                return pSSysDevBKTaskBase.isResultInfoDirty();
            }
            case 29: {
                return pSSysDevBKTaskBase.isTaskParamDirty();
            }
            case 30: {
                return pSSysDevBKTaskBase.isTaskParam2Dirty();
            }
            case 31: {
                return pSSysDevBKTaskBase.isTaskParam3Dirty();
            }
            case 32: {
                return pSSysDevBKTaskBase.isTaskParam4Dirty();
            }
            case 33: {
                return pSSysDevBKTaskBase.isTaskStateDirty();
            }
            case 34: {
                return pSSysDevBKTaskBase.isTaskTypeDirty();
            }
            case 35: {
                return pSSysDevBKTaskBase.isUpdateDateDirty();
            }
            case 36: {
                return pSSysDevBKTaskBase.isUpdateManDirty();
            }
            case 37: {
                return pSSysDevBKTaskBase.isUseRobotFlagDirty();
            }
            case 38: {
                return pSSysDevBKTaskBase.isUserTagDirty();
            }
            case 39: {
                return pSSysDevBKTaskBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDevBKTaskBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDevBKTaskBase pSSysDevBKTaskBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDevBKTaskBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getEndTime()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getFullResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullresultinfo", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getFullResultInfo()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getLinkInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getLinkInfo()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getModelLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modellevel", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getModelLevel()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPlanPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planpsdcrobotid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPlanPSDCRobotId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPlanPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"planpsdcrobotname", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPlanPSDCRobotName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdevbktaskid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPPSSysDevBKTaskId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdevbktaskname", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPPSSysDevBKTaskName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDCRobotId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDCRobotId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDCRobotName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcrobotname", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDCRobotName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDSConsoleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdsconsoleid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDSConsoleId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevbktaskid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSSysDevBKTaskId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdevbktaskname", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSSysDevBKTaskName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysModelInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelinstid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSSysModelInstId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getQueueInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"queueinfo", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getQueueInfo()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getResultInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"resultinfo", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getResultInfo()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskParam()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam2", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskParam2()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam3", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskParam3()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskparam4", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskParam4()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"taskstate", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskState()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getTaskType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tasktype", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getTaskType()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getUseRobotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userobotflag", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getUseRobotFlag()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDevBKTaskBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDevBKTaskBase.getJSONValue((Object)pSSysDevBKTaskBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDevBKTaskBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDevBKTaskBase pSSysDevBKTaskBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDevBKTaskBase.getBeginTime() != null) {
            object = pSSysDevBKTaskBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getCreateDate() != null) {
            object = pSSysDevBKTaskBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getCreateMan() != null) {
            object = pSSysDevBKTaskBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getEndTime() != null) {
            object = pSSysDevBKTaskBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getFullResultInfo() != null) {
            object = pSSysDevBKTaskBase.getFullResultInfo();
            xmlNode.setAttribute(FIELD_FULLRESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getLinkInfo() != null) {
            object = pSSysDevBKTaskBase.getLinkInfo();
            xmlNode.setAttribute(FIELD_LINKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getMemo() != null) {
            object = pSSysDevBKTaskBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getModelLevel() != null) {
            object = pSSysDevBKTaskBase.getModelLevel();
            xmlNode.setAttribute(FIELD_MODELLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getOrderValue() != null) {
            object = pSSysDevBKTaskBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getPlanPSDCRobotId() != null) {
            object = pSSysDevBKTaskBase.getPlanPSDCRobotId();
            xmlNode.setAttribute(FIELD_PLANPSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPlanPSDCRobotName() != null) {
            object = pSSysDevBKTaskBase.getPlanPSDCRobotName();
            xmlNode.setAttribute(FIELD_PLANPSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskId() != null) {
            object = pSSysDevBKTaskBase.getPPSSysDevBKTaskId();
            xmlNode.setAttribute(FIELD_PPSSYSDEVBKTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskName() != null) {
            object = pSSysDevBKTaskBase.getPPSSysDevBKTaskName();
            xmlNode.setAttribute(FIELD_PPSSYSDEVBKTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDCRobotId() != null) {
            object = pSSysDevBKTaskBase.getPSDCRobotId();
            xmlNode.setAttribute(FIELD_PSDCROBOTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDCRobotName() != null) {
            object = pSSysDevBKTaskBase.getPSDCRobotName();
            xmlNode.setAttribute(FIELD_PSDCROBOTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDevSlnId() != null) {
            object = pSSysDevBKTaskBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDevSlnSysId() != null) {
            object = pSSysDevBKTaskBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDSConsoleId() != null) {
            object = pSSysDevBKTaskBase.getPSDSConsoleId();
            xmlNode.setAttribute(FIELD_PSDSCONSOLEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSDynaInstId() != null) {
            object = pSSysDevBKTaskBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskId() != null) {
            object = pSSysDevBKTaskBase.getPSSysDevBKTaskId();
            xmlNode.setAttribute(FIELD_PSSYSDEVBKTASKID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskName() != null) {
            object = pSSysDevBKTaskBase.getPSSysDevBKTaskName();
            xmlNode.setAttribute(FIELD_PSSYSDEVBKTASKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSSysModelInstId() != null) {
            object = pSSysDevBKTaskBase.getPSSysModelInstId();
            xmlNode.setAttribute(FIELD_PSSYSMODELINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSSystemId() != null) {
            object = pSSysDevBKTaskBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSSystemName() != null) {
            object = pSSysDevBKTaskBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSTaskServerId() != null) {
            object = pSSysDevBKTaskBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getPSTaskServerName() != null) {
            object = pSSysDevBKTaskBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getQueueInfo() != null) {
            object = pSSysDevBKTaskBase.getQueueInfo();
            xmlNode.setAttribute(FIELD_QUEUEINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getRemoteAddr() != null) {
            object = pSSysDevBKTaskBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getResultInfo() != null) {
            object = pSSysDevBKTaskBase.getResultInfo();
            xmlNode.setAttribute(FIELD_RESULTINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam() != null) {
            object = pSSysDevBKTaskBase.getTaskParam();
            xmlNode.setAttribute(FIELD_TASKPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam2() != null) {
            object = pSSysDevBKTaskBase.getTaskParam2();
            xmlNode.setAttribute(FIELD_TASKPARAM2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam3() != null) {
            object = pSSysDevBKTaskBase.getTaskParam3();
            xmlNode.setAttribute(FIELD_TASKPARAM3, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getTaskParam4() != null) {
            object = pSSysDevBKTaskBase.getTaskParam4();
            xmlNode.setAttribute(FIELD_TASKPARAM4, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getTaskState() != null) {
            object = pSSysDevBKTaskBase.getTaskState();
            xmlNode.setAttribute(FIELD_TASKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getTaskType() != null) {
            object = pSSysDevBKTaskBase.getTaskType();
            xmlNode.setAttribute(FIELD_TASKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getUpdateDate() != null) {
            object = pSSysDevBKTaskBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getUpdateMan() != null) {
            object = pSSysDevBKTaskBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getUseRobotFlag() != null) {
            object = pSSysDevBKTaskBase.getUseRobotFlag();
            xmlNode.setAttribute(FIELD_USEROBOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDevBKTaskBase.getUserTag() != null) {
            object = pSSysDevBKTaskBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDevBKTaskBase.getUserTag2() != null) {
            object = pSSysDevBKTaskBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDevBKTaskBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDevBKTaskBase pSSysDevBKTaskBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDevBKTaskBase.isBeginTimeDirty() && (bl || pSSysDevBKTaskBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSSysDevBKTaskBase.getBeginTime());
        }
        if (pSSysDevBKTaskBase.isCreateDateDirty() && (bl || pSSysDevBKTaskBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDevBKTaskBase.getCreateDate());
        }
        if (pSSysDevBKTaskBase.isCreateManDirty() && (bl || pSSysDevBKTaskBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDevBKTaskBase.getCreateMan());
        }
        if (pSSysDevBKTaskBase.isEndTimeDirty() && (bl || pSSysDevBKTaskBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSSysDevBKTaskBase.getEndTime());
        }
        if (pSSysDevBKTaskBase.isFullResultInfoDirty() && (bl || pSSysDevBKTaskBase.getFullResultInfo() != null)) {
            iDataObject.set(FIELD_FULLRESULTINFO, (Object)pSSysDevBKTaskBase.getFullResultInfo());
        }
        if (pSSysDevBKTaskBase.isLinkInfoDirty() && (bl || pSSysDevBKTaskBase.getLinkInfo() != null)) {
            iDataObject.set(FIELD_LINKINFO, (Object)pSSysDevBKTaskBase.getLinkInfo());
        }
        if (pSSysDevBKTaskBase.isMemoDirty() && (bl || pSSysDevBKTaskBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDevBKTaskBase.getMemo());
        }
        if (pSSysDevBKTaskBase.isModelLevelDirty() && (bl || pSSysDevBKTaskBase.getModelLevel() != null)) {
            iDataObject.set(FIELD_MODELLEVEL, (Object)pSSysDevBKTaskBase.getModelLevel());
        }
        if (pSSysDevBKTaskBase.isOrderValueDirty() && (bl || pSSysDevBKTaskBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDevBKTaskBase.getOrderValue());
        }
        if (pSSysDevBKTaskBase.isPlanPSDCRobotIdDirty() && (bl || pSSysDevBKTaskBase.getPlanPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PLANPSDCROBOTID, (Object)pSSysDevBKTaskBase.getPlanPSDCRobotId());
        }
        if (pSSysDevBKTaskBase.isPlanPSDCRobotNameDirty() && (bl || pSSysDevBKTaskBase.getPlanPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PLANPSDCROBOTNAME, (Object)pSSysDevBKTaskBase.getPlanPSDCRobotName());
        }
        if (pSSysDevBKTaskBase.isPPSSysDevBKTaskIdDirty() && (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskId() != null)) {
            iDataObject.set(FIELD_PPSSYSDEVBKTASKID, (Object)pSSysDevBKTaskBase.getPPSSysDevBKTaskId());
        }
        if (pSSysDevBKTaskBase.isPPSSysDevBKTaskNameDirty() && (bl || pSSysDevBKTaskBase.getPPSSysDevBKTaskName() != null)) {
            iDataObject.set(FIELD_PPSSYSDEVBKTASKNAME, (Object)pSSysDevBKTaskBase.getPPSSysDevBKTaskName());
        }
        if (pSSysDevBKTaskBase.isPSDCRobotIdDirty() && (bl || pSSysDevBKTaskBase.getPSDCRobotId() != null)) {
            iDataObject.set(FIELD_PSDCROBOTID, (Object)pSSysDevBKTaskBase.getPSDCRobotId());
        }
        if (pSSysDevBKTaskBase.isPSDCRobotNameDirty() && (bl || pSSysDevBKTaskBase.getPSDCRobotName() != null)) {
            iDataObject.set(FIELD_PSDCROBOTNAME, (Object)pSSysDevBKTaskBase.getPSDCRobotName());
        }
        if (pSSysDevBKTaskBase.isPSDevSlnIdDirty() && (bl || pSSysDevBKTaskBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSSysDevBKTaskBase.getPSDevSlnId());
        }
        if (pSSysDevBKTaskBase.isPSDevSlnSysIdDirty() && (bl || pSSysDevBKTaskBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSSysDevBKTaskBase.getPSDevSlnSysId());
        }
        if (pSSysDevBKTaskBase.isPSDSConsoleIdDirty() && (bl || pSSysDevBKTaskBase.getPSDSConsoleId() != null)) {
            iDataObject.set(FIELD_PSDSCONSOLEID, (Object)pSSysDevBKTaskBase.getPSDSConsoleId());
        }
        if (pSSysDevBKTaskBase.isPSDynaInstIdDirty() && (bl || pSSysDevBKTaskBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSSysDevBKTaskBase.getPSDynaInstId());
        }
        if (pSSysDevBKTaskBase.isPSSysDevBKTaskIdDirty() && (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskId() != null)) {
            iDataObject.set(FIELD_PSSYSDEVBKTASKID, (Object)pSSysDevBKTaskBase.getPSSysDevBKTaskId());
        }
        if (pSSysDevBKTaskBase.isPSSysDevBKTaskNameDirty() && (bl || pSSysDevBKTaskBase.getPSSysDevBKTaskName() != null)) {
            iDataObject.set(FIELD_PSSYSDEVBKTASKNAME, (Object)pSSysDevBKTaskBase.getPSSysDevBKTaskName());
        }
        if (pSSysDevBKTaskBase.isPSSysModelInstIdDirty() && (bl || pSSysDevBKTaskBase.getPSSysModelInstId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELINSTID, (Object)pSSysDevBKTaskBase.getPSSysModelInstId());
        }
        if (pSSysDevBKTaskBase.isPSSystemIdDirty() && (bl || pSSysDevBKTaskBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysDevBKTaskBase.getPSSystemId());
        }
        if (pSSysDevBKTaskBase.isPSSystemNameDirty() && (bl || pSSysDevBKTaskBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysDevBKTaskBase.getPSSystemName());
        }
        if (pSSysDevBKTaskBase.isPSTaskServerIdDirty() && (bl || pSSysDevBKTaskBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSSysDevBKTaskBase.getPSTaskServerId());
        }
        if (pSSysDevBKTaskBase.isPSTaskServerNameDirty() && (bl || pSSysDevBKTaskBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSSysDevBKTaskBase.getPSTaskServerName());
        }
        if (pSSysDevBKTaskBase.isQueueInfoDirty() && (bl || pSSysDevBKTaskBase.getQueueInfo() != null)) {
            iDataObject.set(FIELD_QUEUEINFO, (Object)pSSysDevBKTaskBase.getQueueInfo());
        }
        if (pSSysDevBKTaskBase.isRemoteAddrDirty() && (bl || pSSysDevBKTaskBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSSysDevBKTaskBase.getRemoteAddr());
        }
        if (pSSysDevBKTaskBase.isResultInfoDirty() && (bl || pSSysDevBKTaskBase.getResultInfo() != null)) {
            iDataObject.set(FIELD_RESULTINFO, (Object)pSSysDevBKTaskBase.getResultInfo());
        }
        if (pSSysDevBKTaskBase.isTaskParamDirty() && (bl || pSSysDevBKTaskBase.getTaskParam() != null)) {
            iDataObject.set(FIELD_TASKPARAM, (Object)pSSysDevBKTaskBase.getTaskParam());
        }
        if (pSSysDevBKTaskBase.isTaskParam2Dirty() && (bl || pSSysDevBKTaskBase.getTaskParam2() != null)) {
            iDataObject.set(FIELD_TASKPARAM2, (Object)pSSysDevBKTaskBase.getTaskParam2());
        }
        if (pSSysDevBKTaskBase.isTaskParam3Dirty() && (bl || pSSysDevBKTaskBase.getTaskParam3() != null)) {
            iDataObject.set(FIELD_TASKPARAM3, (Object)pSSysDevBKTaskBase.getTaskParam3());
        }
        if (pSSysDevBKTaskBase.isTaskParam4Dirty() && (bl || pSSysDevBKTaskBase.getTaskParam4() != null)) {
            iDataObject.set(FIELD_TASKPARAM4, (Object)pSSysDevBKTaskBase.getTaskParam4());
        }
        if (pSSysDevBKTaskBase.isTaskStateDirty() && (bl || pSSysDevBKTaskBase.getTaskState() != null)) {
            iDataObject.set(FIELD_TASKSTATE, (Object)pSSysDevBKTaskBase.getTaskState());
        }
        if (pSSysDevBKTaskBase.isTaskTypeDirty() && (bl || pSSysDevBKTaskBase.getTaskType() != null)) {
            iDataObject.set(FIELD_TASKTYPE, (Object)pSSysDevBKTaskBase.getTaskType());
        }
        if (pSSysDevBKTaskBase.isUpdateDateDirty() && (bl || pSSysDevBKTaskBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDevBKTaskBase.getUpdateDate());
        }
        if (pSSysDevBKTaskBase.isUpdateManDirty() && (bl || pSSysDevBKTaskBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDevBKTaskBase.getUpdateMan());
        }
        if (pSSysDevBKTaskBase.isUseRobotFlagDirty() && (bl || pSSysDevBKTaskBase.getUseRobotFlag() != null)) {
            iDataObject.set(FIELD_USEROBOTFLAG, (Object)pSSysDevBKTaskBase.getUseRobotFlag());
        }
        if (pSSysDevBKTaskBase.isUserTagDirty() && (bl || pSSysDevBKTaskBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDevBKTaskBase.getUserTag());
        }
        if (pSSysDevBKTaskBase.isUserTag2Dirty() && (bl || pSSysDevBKTaskBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDevBKTaskBase.getUserTag2());
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
        return PSSysDevBKTaskBase.remove(this, n);
    }

    private static boolean remove(PSSysDevBKTaskBase pSSysDevBKTaskBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDevBKTaskBase.resetBeginTime();
                return true;
            }
            case 1: {
                pSSysDevBKTaskBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysDevBKTaskBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysDevBKTaskBase.resetEndTime();
                return true;
            }
            case 4: {
                pSSysDevBKTaskBase.resetFullResultInfo();
                return true;
            }
            case 5: {
                pSSysDevBKTaskBase.resetLinkInfo();
                return true;
            }
            case 6: {
                pSSysDevBKTaskBase.resetMemo();
                return true;
            }
            case 7: {
                pSSysDevBKTaskBase.resetModelLevel();
                return true;
            }
            case 8: {
                pSSysDevBKTaskBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysDevBKTaskBase.resetPlanPSDCRobotId();
                return true;
            }
            case 10: {
                pSSysDevBKTaskBase.resetPlanPSDCRobotName();
                return true;
            }
            case 11: {
                pSSysDevBKTaskBase.resetPPSSysDevBKTaskId();
                return true;
            }
            case 12: {
                pSSysDevBKTaskBase.resetPPSSysDevBKTaskName();
                return true;
            }
            case 13: {
                pSSysDevBKTaskBase.resetPSDCRobotId();
                return true;
            }
            case 14: {
                pSSysDevBKTaskBase.resetPSDCRobotName();
                return true;
            }
            case 15: {
                pSSysDevBKTaskBase.resetPSDevSlnId();
                return true;
            }
            case 16: {
                pSSysDevBKTaskBase.resetPSDevSlnSysId();
                return true;
            }
            case 17: {
                pSSysDevBKTaskBase.resetPSDSConsoleId();
                return true;
            }
            case 18: {
                pSSysDevBKTaskBase.resetPSDynaInstId();
                return true;
            }
            case 19: {
                pSSysDevBKTaskBase.resetPSSysDevBKTaskId();
                return true;
            }
            case 20: {
                pSSysDevBKTaskBase.resetPSSysDevBKTaskName();
                return true;
            }
            case 21: {
                pSSysDevBKTaskBase.resetPSSysModelInstId();
                return true;
            }
            case 22: {
                pSSysDevBKTaskBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSSysDevBKTaskBase.resetPSSystemName();
                return true;
            }
            case 24: {
                pSSysDevBKTaskBase.resetPSTaskServerId();
                return true;
            }
            case 25: {
                pSSysDevBKTaskBase.resetPSTaskServerName();
                return true;
            }
            case 26: {
                pSSysDevBKTaskBase.resetQueueInfo();
                return true;
            }
            case 27: {
                pSSysDevBKTaskBase.resetRemoteAddr();
                return true;
            }
            case 28: {
                pSSysDevBKTaskBase.resetResultInfo();
                return true;
            }
            case 29: {
                pSSysDevBKTaskBase.resetTaskParam();
                return true;
            }
            case 30: {
                pSSysDevBKTaskBase.resetTaskParam2();
                return true;
            }
            case 31: {
                pSSysDevBKTaskBase.resetTaskParam3();
                return true;
            }
            case 32: {
                pSSysDevBKTaskBase.resetTaskParam4();
                return true;
            }
            case 33: {
                pSSysDevBKTaskBase.resetTaskState();
                return true;
            }
            case 34: {
                pSSysDevBKTaskBase.resetTaskType();
                return true;
            }
            case 35: {
                pSSysDevBKTaskBase.resetUpdateDate();
                return true;
            }
            case 36: {
                pSSysDevBKTaskBase.resetUpdateMan();
                return true;
            }
            case 37: {
                pSSysDevBKTaskBase.resetUseRobotFlag();
                return true;
            }
            case 38: {
                pSSysDevBKTaskBase.resetUserTag();
                return true;
            }
            case 39: {
                pSSysDevBKTaskBase.resetUserTag2();
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
    public PSSysDevBKTask getPPSysDevBKTask() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSysDevBKTask();
        }
        if (this.getPPSSysDevBKTaskId() == null) {
            return null;
        }
        Integer n = this.objPPSysDevBKTaskLock;
        synchronized (n) {
            if (this.ppsysdevbktask != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysDevBKTaskId(), (Object)this.ppsysdevbktask.getPSSysDevBKTaskId()) != 0L) {
                this.ppsysdevbktask = null;
            }
            if (this.ppsysdevbktask == null) {
                PSSysDevBKTask pSSysDevBKTask = new PSSysDevBKTask();
                pSSysDevBKTask.setPSSysDevBKTaskId(this.getPPSSysDevBKTaskId());
                PSSysDevBKTaskService pSSysDevBKTaskService = (PSSysDevBKTaskService)ServiceGlobal.getService(PSSysDevBKTaskService.class, (SessionFactory)this.getSessionFactory());
                pSSysDevBKTaskService.autoGet((IEntity)pSSysDevBKTask);
                this.ppsysdevbktask = pSSysDevBKTask;
            }
            return this.ppsysdevbktask;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
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

    private PSSysDevBKTaskBase getProxyEntity() {
        return this.proxyPSSysDevBKTaskBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDevBKTaskBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDevBKTaskBase) {
            this.proxyPSSysDevBKTaskBase = (PSSysDevBKTaskBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSSysDevBKTaskService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_FULLRESULTINFO, 4);
        fieldIndexMap.put(FIELD_LINKINFO, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELLEVEL, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PLANPSDCROBOTID, 9);
        fieldIndexMap.put(FIELD_PLANPSDCROBOTNAME, 10);
        fieldIndexMap.put(FIELD_PPSSYSDEVBKTASKID, 11);
        fieldIndexMap.put(FIELD_PPSSYSDEVBKTASKNAME, 12);
        fieldIndexMap.put(FIELD_PSDCROBOTID, 13);
        fieldIndexMap.put(FIELD_PSDCROBOTNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 16);
        fieldIndexMap.put(FIELD_PSDSCONSOLEID, 17);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 18);
        fieldIndexMap.put(FIELD_PSSYSDEVBKTASKID, 19);
        fieldIndexMap.put(FIELD_PSSYSDEVBKTASKNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSMODELINSTID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 23);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 24);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 25);
        fieldIndexMap.put(FIELD_QUEUEINFO, 26);
        fieldIndexMap.put(FIELD_REMOTEADDR, 27);
        fieldIndexMap.put(FIELD_RESULTINFO, 28);
        fieldIndexMap.put(FIELD_TASKPARAM, 29);
        fieldIndexMap.put(FIELD_TASKPARAM2, 30);
        fieldIndexMap.put(FIELD_TASKPARAM3, 31);
        fieldIndexMap.put(FIELD_TASKPARAM4, 32);
        fieldIndexMap.put(FIELD_TASKSTATE, 33);
        fieldIndexMap.put(FIELD_TASKTYPE, 34);
        fieldIndexMap.put(FIELD_UPDATEDATE, 35);
        fieldIndexMap.put(FIELD_UPDATEMAN, 36);
        fieldIndexMap.put(FIELD_USEROBOTFLAG, 37);
        fieldIndexMap.put(FIELD_USERTAG, 38);
        fieldIndexMap.put(FIELD_USERTAG2, 39);
    }
}

