/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFStepBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEADLINE = "DEADLINE";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_FROMWFSTEPID = "FROMWFSTEPID";
    public static final String FIELD_ISFINISH = "ISFINISH";
    public static final String FIELD_ISINTERACTIVE = "ISINTERACTIVE";
    public static final String FIELD_LASTACTORID = "LASTACTORID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_STARTTIME = "STARTTIME";
    public static final String FIELD_TRACESTEP = "TRACESTEP";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    public static final String FIELD_WFPMODEL = "WFPMODEL";
    public static final String FIELD_WFPNAME = "WFPNAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    public static final String FIELD_WFVERSION = "WFVERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEADLINE = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_FROMWFSTEPID = 4;
    private static final int INDEX_ISFINISH = 5;
    private static final int INDEX_ISINTERACTIVE = 6;
    private static final int INDEX_LASTACTORID = 7;
    private static final int INDEX_MEMO = 8;
    private static final int INDEX_STARTTIME = 9;
    private static final int INDEX_TRACESTEP = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_WFINSTANCEID = 13;
    private static final int INDEX_WFINSTANCENAME = 14;
    private static final int INDEX_WFPLOGICNAME = 15;
    private static final int INDEX_WFPMODEL = 16;
    private static final int INDEX_WFPNAME = 17;
    private static final int INDEX_WFSTEPID = 18;
    private static final int INDEX_WFSTEPLANRESTAG = 19;
    private static final int INDEX_WFSTEPNAME = 20;
    private static final int INDEX_WFVERSION = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFStepBase proxyWFStepBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deadlineDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean fromwfstepidDirtyFlag = false;
    private boolean isfinishDirtyFlag = false;
    private boolean isinteractiveDirtyFlag = false;
    private boolean lastactoridDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean starttimeDirtyFlag = false;
    private boolean tracestepDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfplogicnameDirtyFlag = false;
    private boolean wfpmodelDirtyFlag = false;
    private boolean wfpnameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfsteplanrestagDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deadline")
    private Timestamp deadline;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="fromwfstepid")
    private String fromwfstepid;
    @Column(name="isfinish")
    private Integer isfinish;
    @Column(name="isinteractive")
    private Integer isinteractive;
    @Column(name="lastactorid")
    private String lastactorid;
    @Column(name="memo")
    private String memo;
    @Column(name="starttime")
    private Timestamp starttime;
    @Column(name="tracestep")
    private Integer tracestep;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfplogicname")
    private String wfplogicname;
    @Column(name="wfpmodel")
    private String wfpmodel;
    @Column(name="wfpname")
    private String wfpname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfsteplanrestag")
    private String wfsteplanrestag;
    @Column(name="wfstepname")
    private String wfstepname;
    @Column(name="wfversion")
    private Integer wfversion;
    private Integer objWFInstanceLock = new Integer(1);
    private WFInstance wfinstance = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEADLINE, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_FROMWFSTEPID, 4);
        fieldIndexMap.put(FIELD_ISFINISH, 5);
        fieldIndexMap.put(FIELD_ISINTERACTIVE, 6);
        fieldIndexMap.put(FIELD_LASTACTORID, 7);
        fieldIndexMap.put(FIELD_MEMO, 8);
        fieldIndexMap.put(FIELD_STARTTIME, 9);
        fieldIndexMap.put(FIELD_TRACESTEP, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 13);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 14);
        fieldIndexMap.put(FIELD_WFPLOGICNAME, 15);
        fieldIndexMap.put(FIELD_WFPMODEL, 16);
        fieldIndexMap.put(FIELD_WFPNAME, 17);
        fieldIndexMap.put(FIELD_WFSTEPID, 18);
        fieldIndexMap.put(FIELD_WFSTEPLANRESTAG, 19);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 20);
        fieldIndexMap.put(FIELD_WFVERSION, 21);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setDeadLine(Timestamp deadline) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeadLine(deadline);
            return;
        }
        this.deadline = deadline;
        this.deadlineDirtyFlag = true;
    }

    public Timestamp getDeadLine() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeadLine();
        }
        return this.deadline;
    }

    public boolean isDeadLineDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeadLineDirty();
        }
        return this.deadlineDirtyFlag;
    }

    public void resetDeadLine() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeadLine();
            return;
        }
        this.deadlineDirtyFlag = false;
        this.deadline = null;
    }

    public void setEndTime(Timestamp endtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(endtime);
            return;
        }
        this.endtime = endtime;
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

    public void setFromWFStepId(String fromwfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromWFStepId(fromwfstepid);
            return;
        }
        if (fromwfstepid != null && (fromwfstepid = StringHelper.trimRight(fromwfstepid)).length() == 0) {
            fromwfstepid = null;
        }
        this.fromwfstepid = fromwfstepid;
        this.fromwfstepidDirtyFlag = true;
    }

    public String getFromWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromWFStepId();
        }
        return this.fromwfstepid;
    }

    public boolean isFromWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromWFStepIdDirty();
        }
        return this.fromwfstepidDirtyFlag;
    }

    public void resetFromWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromWFStepId();
            return;
        }
        this.fromwfstepidDirtyFlag = false;
        this.fromwfstepid = null;
    }

    public void setIsFinish(Integer isfinish) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsFinish(isfinish);
            return;
        }
        this.isfinish = isfinish;
        this.isfinishDirtyFlag = true;
    }

    public Integer getIsFinish() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsFinish();
        }
        return this.isfinish;
    }

    public boolean isIsFinishDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsFinishDirty();
        }
        return this.isfinishDirtyFlag;
    }

    public void resetIsFinish() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsFinish();
            return;
        }
        this.isfinishDirtyFlag = false;
        this.isfinish = null;
    }

    public void setIsInteractive(Integer isinteractive) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsInteractive(isinteractive);
            return;
        }
        this.isinteractive = isinteractive;
        this.isinteractiveDirtyFlag = true;
    }

    public Integer getIsInteractive() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsInteractive();
        }
        return this.isinteractive;
    }

    public boolean isIsInteractiveDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsInteractiveDirty();
        }
        return this.isinteractiveDirtyFlag;
    }

    public void resetIsInteractive() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsInteractive();
            return;
        }
        this.isinteractiveDirtyFlag = false;
        this.isinteractive = null;
    }

    public void setLastActorId(String lastactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastActorId(lastactorid);
            return;
        }
        if (lastactorid != null && (lastactorid = StringHelper.trimRight(lastactorid)).length() == 0) {
            lastactorid = null;
        }
        this.lastactorid = lastactorid;
        this.lastactoridDirtyFlag = true;
    }

    public String getLastActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastActorId();
        }
        return this.lastactorid;
    }

    public boolean isLastActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastActorIdDirty();
        }
        return this.lastactoridDirtyFlag;
    }

    public void resetLastActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastActorId();
            return;
        }
        this.lastactoridDirtyFlag = false;
        this.lastactorid = null;
    }

    public void setMemo(String memo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if (memo != null && (memo = StringHelper.trimRight(memo)).length() == 0) {
            memo = null;
        }
        this.memo = memo;
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

    public void setStartTime(Timestamp starttime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartTime(starttime);
            return;
        }
        this.starttime = starttime;
        this.starttimeDirtyFlag = true;
    }

    public Timestamp getStartTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartTime();
        }
        return this.starttime;
    }

    public boolean isStartTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartTimeDirty();
        }
        return this.starttimeDirtyFlag;
    }

    public void resetStartTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartTime();
            return;
        }
        this.starttimeDirtyFlag = false;
        this.starttime = null;
    }

    public void setTraceStep(Integer tracestep) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTraceStep(tracestep);
            return;
        }
        this.tracestep = tracestep;
        this.tracestepDirtyFlag = true;
    }

    public Integer getTraceStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTraceStep();
        }
        return this.tracestep;
    }

    public boolean isTraceStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTraceStepDirty();
        }
        return this.tracestepDirtyFlag;
    }

    public void resetTraceStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTraceStep();
            return;
        }
        this.tracestepDirtyFlag = false;
        this.tracestep = null;
    }

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setWFInstanceId(String wfinstanceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if (wfinstanceid != null && (wfinstanceid = StringHelper.trimRight(wfinstanceid)).length() == 0) {
            wfinstanceid = null;
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag = true;
    }

    public String getWFInstanceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    public boolean isWFInstanceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    public void resetWFInstanceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }
        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }

    public void setWFInstanceName(String wfinstancename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if (wfinstancename != null && (wfinstancename = StringHelper.trimRight(wfinstancename)).length() == 0) {
            wfinstancename = null;
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag = true;
    }

    public String getWFInstanceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    public boolean isWFInstanceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    public void resetWFInstanceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }
        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }

    public void setWFPLogicName(String wfplogicname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFPLogicName(wfplogicname);
            return;
        }
        if (wfplogicname != null && (wfplogicname = StringHelper.trimRight(wfplogicname)).length() == 0) {
            wfplogicname = null;
        }
        this.wfplogicname = wfplogicname;
        this.wfplogicnameDirtyFlag = true;
    }

    public String getWFPLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFPLogicName();
        }
        return this.wfplogicname;
    }

    public boolean isWFPLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFPLogicNameDirty();
        }
        return this.wfplogicnameDirtyFlag;
    }

    public void resetWFPLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFPLogicName();
            return;
        }
        this.wfplogicnameDirtyFlag = false;
        this.wfplogicname = null;
    }

    public void setWFPModel(String wfpmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFPModel(wfpmodel);
            return;
        }
        if (wfpmodel != null && (wfpmodel = StringHelper.trimRight(wfpmodel)).length() == 0) {
            wfpmodel = null;
        }
        this.wfpmodel = wfpmodel;
        this.wfpmodelDirtyFlag = true;
    }

    public String getWFPModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFPModel();
        }
        return this.wfpmodel;
    }

    public boolean isWFPModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFPModelDirty();
        }
        return this.wfpmodelDirtyFlag;
    }

    public void resetWFPModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFPModel();
            return;
        }
        this.wfpmodelDirtyFlag = false;
        this.wfpmodel = null;
    }

    public void setWFPName(String wfpname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFPName(wfpname);
            return;
        }
        if (wfpname != null && (wfpname = StringHelper.trimRight(wfpname)).length() == 0) {
            wfpname = null;
        }
        this.wfpname = wfpname;
        this.wfpnameDirtyFlag = true;
    }

    public String getWFPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFPName();
        }
        return this.wfpname;
    }

    public boolean isWFPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFPNameDirty();
        }
        return this.wfpnameDirtyFlag;
    }

    public void resetWFPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFPName();
            return;
        }
        this.wfpnameDirtyFlag = false;
        this.wfpname = null;
    }

    public void setWFStepId(String wfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if (wfstepid != null && (wfstepid = StringHelper.trimRight(wfstepid)).length() == 0) {
            wfstepid = null;
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag = true;
    }

    public String getWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    public boolean isWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    public void resetWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }
        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }

    public void setWFStepLanResTag(String wfsteplanrestag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if (wfsteplanrestag != null && (wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag)).length() == 0) {
            wfsteplanrestag = null;
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag = true;
    }

    public String getWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    public boolean isWFStepLanResTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    public void resetWFStepLanResTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }
        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }

    public void setWFStepName(String wfstepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if (wfstepname != null && (wfstepname = StringHelper.trimRight(wfstepname)).length() == 0) {
            wfstepname = null;
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag = true;
    }

    public String getWFStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    public boolean isWFStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    public void resetWFStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }
        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    public void setWFVersion(Integer wfversion) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag = true;
    }

    public Integer getWFVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    public boolean isWFVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    public void resetWFVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }
        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    @Override
    protected void onReset() {
        WFStepBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFStepBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDeadLine();
        et.resetEndTime();
        et.resetFromWFStepId();
        et.resetIsFinish();
        et.resetIsInteractive();
        et.resetLastActorId();
        et.resetMemo();
        et.resetStartTime();
        et.resetTraceStep();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFPLogicName();
        et.resetWFPModel();
        et.resetWFPName();
        et.resetWFStepId();
        et.resetWFStepLanResTag();
        et.resetWFStepName();
        et.resetWFVersion();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDeadLineDirty()) {
            params.put(FIELD_DEADLINE, this.getDeadLine());
        }
        if (!bDirtyOnly || this.isEndTimeDirty()) {
            params.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bDirtyOnly || this.isFromWFStepIdDirty()) {
            params.put(FIELD_FROMWFSTEPID, this.getFromWFStepId());
        }
        if (!bDirtyOnly || this.isIsFinishDirty()) {
            params.put(FIELD_ISFINISH, this.getIsFinish());
        }
        if (!bDirtyOnly || this.isIsInteractiveDirty()) {
            params.put(FIELD_ISINTERACTIVE, this.getIsInteractive());
        }
        if (!bDirtyOnly || this.isLastActorIdDirty()) {
            params.put(FIELD_LASTACTORID, this.getLastActorId());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isStartTimeDirty()) {
            params.put(FIELD_STARTTIME, this.getStartTime());
        }
        if (!bDirtyOnly || this.isTraceStepDirty()) {
            params.put(FIELD_TRACESTEP, this.getTraceStep());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID, this.getWFInstanceId());
        }
        if (!bDirtyOnly || this.isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME, this.getWFInstanceName());
        }
        if (!bDirtyOnly || this.isWFPLogicNameDirty()) {
            params.put(FIELD_WFPLOGICNAME, this.getWFPLogicName());
        }
        if (!bDirtyOnly || this.isWFPModelDirty()) {
            params.put(FIELD_WFPMODEL, this.getWFPModel());
        }
        if (!bDirtyOnly || this.isWFPNameDirty()) {
            params.put(FIELD_WFPNAME, this.getWFPName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
        }
        if (!bDirtyOnly || this.isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG, this.getWFStepLanResTag());
        }
        if (!bDirtyOnly || this.isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME, this.getWFStepName());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFStepBase.get(this, index);
    }

    private static Object get(WFStepBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDeadLine();
            }
            case 3: {
                return et.getEndTime();
            }
            case 4: {
                return et.getFromWFStepId();
            }
            case 5: {
                return et.getIsFinish();
            }
            case 6: {
                return et.getIsInteractive();
            }
            case 7: {
                return et.getLastActorId();
            }
            case 8: {
                return et.getMemo();
            }
            case 9: {
                return et.getStartTime();
            }
            case 10: {
                return et.getTraceStep();
            }
            case 11: {
                return et.getUpdateDate();
            }
            case 12: {
                return et.getUpdateMan();
            }
            case 13: {
                return et.getWFInstanceId();
            }
            case 14: {
                return et.getWFInstanceName();
            }
            case 15: {
                return et.getWFPLogicName();
            }
            case 16: {
                return et.getWFPModel();
            }
            case 17: {
                return et.getWFPName();
            }
            case 18: {
                return et.getWFStepId();
            }
            case 19: {
                return et.getWFStepLanResTag();
            }
            case 20: {
                return et.getWFStepName();
            }
            case 21: {
                return et.getWFVersion();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFStepBase.set(this, index, objValue);
    }

    private static void set(WFStepBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setDeadLine(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setEndTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setFromWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setIsFinish(DataObject.getIntegerValue(obj));
                return;
            }
            case 6: {
                et.setIsInteractive(DataObject.getIntegerValue(obj));
                return;
            }
            case 7: {
                et.setLastActorId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setStartTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 10: {
                et.setTraceStep(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 12: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setWFPLogicName(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setWFPModel(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWFPName(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setWFStepLanResTag(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWFStepName(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWFVersion(DataObject.getIntegerValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFStepBase.isNull(this, index);
    }

    private static boolean isNull(WFStepBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDeadLine() == null;
            }
            case 3: {
                return et.getEndTime() == null;
            }
            case 4: {
                return et.getFromWFStepId() == null;
            }
            case 5: {
                return et.getIsFinish() == null;
            }
            case 6: {
                return et.getIsInteractive() == null;
            }
            case 7: {
                return et.getLastActorId() == null;
            }
            case 8: {
                return et.getMemo() == null;
            }
            case 9: {
                return et.getStartTime() == null;
            }
            case 10: {
                return et.getTraceStep() == null;
            }
            case 11: {
                return et.getUpdateDate() == null;
            }
            case 12: {
                return et.getUpdateMan() == null;
            }
            case 13: {
                return et.getWFInstanceId() == null;
            }
            case 14: {
                return et.getWFInstanceName() == null;
            }
            case 15: {
                return et.getWFPLogicName() == null;
            }
            case 16: {
                return et.getWFPModel() == null;
            }
            case 17: {
                return et.getWFPName() == null;
            }
            case 18: {
                return et.getWFStepId() == null;
            }
            case 19: {
                return et.getWFStepLanResTag() == null;
            }
            case 20: {
                return et.getWFStepName() == null;
            }
            case 21: {
                return et.getWFVersion() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFStepBase.contains(this, index);
    }

    private static boolean contains(WFStepBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDeadLineDirty();
            }
            case 3: {
                return et.isEndTimeDirty();
            }
            case 4: {
                return et.isFromWFStepIdDirty();
            }
            case 5: {
                return et.isIsFinishDirty();
            }
            case 6: {
                return et.isIsInteractiveDirty();
            }
            case 7: {
                return et.isLastActorIdDirty();
            }
            case 8: {
                return et.isMemoDirty();
            }
            case 9: {
                return et.isStartTimeDirty();
            }
            case 10: {
                return et.isTraceStepDirty();
            }
            case 11: {
                return et.isUpdateDateDirty();
            }
            case 12: {
                return et.isUpdateManDirty();
            }
            case 13: {
                return et.isWFInstanceIdDirty();
            }
            case 14: {
                return et.isWFInstanceNameDirty();
            }
            case 15: {
                return et.isWFPLogicNameDirty();
            }
            case 16: {
                return et.isWFPModelDirty();
            }
            case 17: {
                return et.isWFPNameDirty();
            }
            case 18: {
                return et.isWFStepIdDirty();
            }
            case 19: {
                return et.isWFStepLanResTagDirty();
            }
            case 20: {
                return et.isWFStepNameDirty();
            }
            case 21: {
                return et.isWFVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFStepBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFStepBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFStepBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFStepBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDeadLine() != null) {
            JSONObjectHelper.put(json, "deadline", WFStepBase.getJSONValue(et.getDeadLine()), false);
        }
        if (bIncEmpty || et.getEndTime() != null) {
            JSONObjectHelper.put(json, "endtime", WFStepBase.getJSONValue(et.getEndTime()), false);
        }
        if (bIncEmpty || et.getFromWFStepId() != null) {
            JSONObjectHelper.put(json, "fromwfstepid", WFStepBase.getJSONValue(et.getFromWFStepId()), false);
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            JSONObjectHelper.put(json, "isfinish", WFStepBase.getJSONValue(et.getIsFinish()), false);
        }
        if (bIncEmpty || et.getIsInteractive() != null) {
            JSONObjectHelper.put(json, "isinteractive", WFStepBase.getJSONValue(et.getIsInteractive()), false);
        }
        if (bIncEmpty || et.getLastActorId() != null) {
            JSONObjectHelper.put(json, "lastactorid", WFStepBase.getJSONValue(et.getLastActorId()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFStepBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            JSONObjectHelper.put(json, "starttime", WFStepBase.getJSONValue(et.getStartTime()), false);
        }
        if (bIncEmpty || et.getTraceStep() != null) {
            JSONObjectHelper.put(json, "tracestep", WFStepBase.getJSONValue(et.getTraceStep()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFStepBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFStepBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFStepBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFStepBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFPLogicName() != null) {
            JSONObjectHelper.put(json, "wfplogicname", WFStepBase.getJSONValue(et.getWFPLogicName()), false);
        }
        if (bIncEmpty || et.getWFPModel() != null) {
            JSONObjectHelper.put(json, "wfpmodel", WFStepBase.getJSONValue(et.getWFPModel()), false);
        }
        if (bIncEmpty || et.getWFPName() != null) {
            JSONObjectHelper.put(json, "wfpname", WFStepBase.getJSONValue(et.getWFPName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFStepBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            JSONObjectHelper.put(json, "wfsteplanrestag", WFStepBase.getJSONValue(et.getWFStepLanResTag()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFStepBase.getJSONValue(et.getWFStepName()), false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put(json, "wfversion", WFStepBase.getJSONValue(et.getWFVersion()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFStepBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFStepBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDeadLine() != null) {
            obj = et.getDeadLine();
            node.setAttribute(FIELD_DEADLINE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getEndTime() != null) {
            obj = et.getEndTime();
            node.setAttribute(FIELD_ENDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getFromWFStepId() != null) {
            obj = et.getFromWFStepId();
            node.setAttribute(FIELD_FROMWFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            obj = et.getIsFinish();
            node.setAttribute(FIELD_ISFINISH, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsInteractive() != null) {
            obj = et.getIsInteractive();
            node.setAttribute(FIELD_ISINTERACTIVE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLastActorId() != null) {
            obj = et.getLastActorId();
            node.setAttribute(FIELD_LASTACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            obj = et.getStartTime();
            node.setAttribute(FIELD_STARTTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getTraceStep() != null) {
            obj = et.getTraceStep();
            node.setAttribute(FIELD_TRACESTEP, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            obj = et.getWFInstanceId();
            node.setAttribute(FIELD_WFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            obj = et.getWFInstanceName();
            node.setAttribute(FIELD_WFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFPLogicName() != null) {
            obj = et.getWFPLogicName();
            node.setAttribute(FIELD_WFPLOGICNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFPModel() != null) {
            obj = et.getWFPModel();
            node.setAttribute(FIELD_WFPMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFPName() != null) {
            obj = et.getWFPName();
            node.setAttribute(FIELD_WFPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            obj = et.getWFStepId();
            node.setAttribute(FIELD_WFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepLanResTag() != null) {
            obj = et.getWFStepLanResTag();
            node.setAttribute(FIELD_WFSTEPLANRESTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            obj = et.getWFStepName();
            node.setAttribute(FIELD_WFSTEPNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFStepBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDeadLineDirty() && (bIncEmpty || et.getDeadLine() != null)) {
            dst.set(FIELD_DEADLINE, et.getDeadLine());
        }
        if (et.isEndTimeDirty() && (bIncEmpty || et.getEndTime() != null)) {
            dst.set(FIELD_ENDTIME, et.getEndTime());
        }
        if (et.isFromWFStepIdDirty() && (bIncEmpty || et.getFromWFStepId() != null)) {
            dst.set(FIELD_FROMWFSTEPID, et.getFromWFStepId());
        }
        if (et.isIsFinishDirty() && (bIncEmpty || et.getIsFinish() != null)) {
            dst.set(FIELD_ISFINISH, et.getIsFinish());
        }
        if (et.isIsInteractiveDirty() && (bIncEmpty || et.getIsInteractive() != null)) {
            dst.set(FIELD_ISINTERACTIVE, et.getIsInteractive());
        }
        if (et.isLastActorIdDirty() && (bIncEmpty || et.getLastActorId() != null)) {
            dst.set(FIELD_LASTACTORID, et.getLastActorId());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isStartTimeDirty() && (bIncEmpty || et.getStartTime() != null)) {
            dst.set(FIELD_STARTTIME, et.getStartTime());
        }
        if (et.isTraceStepDirty() && (bIncEmpty || et.getTraceStep() != null)) {
            dst.set(FIELD_TRACESTEP, et.getTraceStep());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFInstanceIdDirty() && (bIncEmpty || et.getWFInstanceId() != null)) {
            dst.set(FIELD_WFINSTANCEID, et.getWFInstanceId());
        }
        if (et.isWFInstanceNameDirty() && (bIncEmpty || et.getWFInstanceName() != null)) {
            dst.set(FIELD_WFINSTANCENAME, et.getWFInstanceName());
        }
        if (et.isWFPLogicNameDirty() && (bIncEmpty || et.getWFPLogicName() != null)) {
            dst.set(FIELD_WFPLOGICNAME, et.getWFPLogicName());
        }
        if (et.isWFPModelDirty() && (bIncEmpty || et.getWFPModel() != null)) {
            dst.set(FIELD_WFPMODEL, et.getWFPModel());
        }
        if (et.isWFPNameDirty() && (bIncEmpty || et.getWFPName() != null)) {
            dst.set(FIELD_WFPNAME, et.getWFPName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
        }
        if (et.isWFStepLanResTagDirty() && (bIncEmpty || et.getWFStepLanResTag() != null)) {
            dst.set(FIELD_WFSTEPLANRESTAG, et.getWFStepLanResTag());
        }
        if (et.isWFStepNameDirty() && (bIncEmpty || et.getWFStepName() != null)) {
            dst.set(FIELD_WFSTEPNAME, et.getWFStepName());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, et.getWFVersion());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFStepBase.remove(this, index);
    }

    private static boolean remove(WFStepBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetDeadLine();
                return true;
            }
            case 3: {
                et.resetEndTime();
                return true;
            }
            case 4: {
                et.resetFromWFStepId();
                return true;
            }
            case 5: {
                et.resetIsFinish();
                return true;
            }
            case 6: {
                et.resetIsInteractive();
                return true;
            }
            case 7: {
                et.resetLastActorId();
                return true;
            }
            case 8: {
                et.resetMemo();
                return true;
            }
            case 9: {
                et.resetStartTime();
                return true;
            }
            case 10: {
                et.resetTraceStep();
                return true;
            }
            case 11: {
                et.resetUpdateDate();
                return true;
            }
            case 12: {
                et.resetUpdateMan();
                return true;
            }
            case 13: {
                et.resetWFInstanceId();
                return true;
            }
            case 14: {
                et.resetWFInstanceName();
                return true;
            }
            case 15: {
                et.resetWFPLogicName();
                return true;
            }
            case 16: {
                et.resetWFPModel();
                return true;
            }
            case 17: {
                et.resetWFPName();
                return true;
            }
            case 18: {
                et.resetWFStepId();
                return true;
            }
            case 19: {
                et.resetWFStepLanResTag();
                return true;
            }
            case 20: {
                et.resetWFStepName();
                return true;
            }
            case 21: {
                et.resetWFVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFInstance getWFInstance() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFInstance();
        }
        if (this.getWFInstanceId() == null) {
            return null;
        }
        Integer n = this.objWFInstanceLock;
        synchronized (n) {
            if (this.wfinstance != null && DataTypeHelper.compare(25, (Object)this.getWFInstanceId(), (Object)this.wfinstance.getWFInstanceId()) != 0L) {
                this.wfinstance = null;
            }
            if (this.wfinstance == null) {
                WFInstance wfinstance = new WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                WFInstanceService service = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }

    private WFStepBase getProxyEntity() {
        return this.proxyWFStepBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFStepBase) {
            this.proxyWFStepBase = (WFStepBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

