/**
 *  iBizSys 5.0 机器人生产代码（不要直接修改当前代码）
 *  http://www.ibizsys.net
 */
package net.ibizsys.psrt.srv.wf.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;

import java.sql.Timestamp;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.util.StringHelper;
import net.sf.json.JSONObject;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.paas.service.ServiceGlobal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 实体[WFStep] 数据对象基类
 */
public abstract class WFStepBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepBase.class);
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[步骤限时]
     */
    public final static String FIELD_DEADLINE = "DEADLINE";
    /**
     * 属性[结束时间]
     */
    public final static String FIELD_ENDTIME = "ENDTIME";
    /**
     * 属性[FROMWFSTEPID]
     */
    public final static String FIELD_FROMWFSTEPID = "FROMWFSTEPID";
    /**
     * 属性[是否完成]
     */
    public final static String FIELD_ISFINISH = "ISFINISH";
    /**
     * 属性[ISINTERACTIVE]
     */
    public final static String FIELD_ISINTERACTIVE = "ISINTERACTIVE";
    /**
     * 属性[LASTACTORID]
     */
    public final static String FIELD_LASTACTORID = "LASTACTORID";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[开始时间]
     */
    public final static String FIELD_STARTTIME = "STARTTIME";
    /**
     * 属性[步骤次序]
     */
    public final static String FIELD_TRACESTEP = "TRACESTEP";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[处理步骤相关实例]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[流程实例]
     */
    public final static String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    /**
     * 属性[步骤名称]
     */
    public final static String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    /**
     * 属性[WFPMODEL]
     */
    public final static String FIELD_WFPMODEL = "WFPMODEL";
    /**
     * 属性[WFPNAME]
     */
    public final static String FIELD_WFPNAME = "WFPNAME";
    /**
     * 属性[工作流步骤标识]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[步骤语言资源]
     */
    public final static String FIELD_WFSTEPLANRESTAG = "WFSTEPLANRESTAG";
    /**
     * 属性[工作流步骤名称]
     */
    public final static String FIELD_WFSTEPNAME = "WFSTEPNAME";
    /**
     * 属性[工作流版本]
     */
    public final static String FIELD_WFVERSION = "WFVERSION";

    private final static int INDEX_CREATEDATE = 0;
    private final static int INDEX_CREATEMAN = 1;
    private final static int INDEX_DEADLINE = 2;
    private final static int INDEX_ENDTIME = 3;
    private final static int INDEX_FROMWFSTEPID = 4;
    private final static int INDEX_ISFINISH = 5;
    private final static int INDEX_ISINTERACTIVE = 6;
    private final static int INDEX_LASTACTORID = 7;
    private final static int INDEX_MEMO = 8;
    private final static int INDEX_STARTTIME = 9;
    private final static int INDEX_TRACESTEP = 10;
    private final static int INDEX_UPDATEDATE = 11;
    private final static int INDEX_UPDATEMAN = 12;
    private final static int INDEX_WFINSTANCEID = 13;
    private final static int INDEX_WFINSTANCENAME = 14;
    private final static int INDEX_WFPLOGICNAME = 15;
    private final static int INDEX_WFPMODEL = 16;
    private final static int INDEX_WFPNAME = 17;
    private final static int INDEX_WFSTEPID = 18;
    private final static int INDEX_WFSTEPLANRESTAG = 19;
    private final static int INDEX_WFSTEPNAME = 20;
    private final static int INDEX_WFVERSION = 21;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_DEADLINE, INDEX_DEADLINE);
        fieldIndexMap.put( FIELD_ENDTIME, INDEX_ENDTIME);
        fieldIndexMap.put( FIELD_FROMWFSTEPID, INDEX_FROMWFSTEPID);
        fieldIndexMap.put( FIELD_ISFINISH, INDEX_ISFINISH);
        fieldIndexMap.put( FIELD_ISINTERACTIVE, INDEX_ISINTERACTIVE);
        fieldIndexMap.put( FIELD_LASTACTORID, INDEX_LASTACTORID);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_STARTTIME, INDEX_STARTTIME);
        fieldIndexMap.put( FIELD_TRACESTEP, INDEX_TRACESTEP);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFINSTANCENAME, INDEX_WFINSTANCENAME);
        fieldIndexMap.put( FIELD_WFPLOGICNAME, INDEX_WFPLOGICNAME);
        fieldIndexMap.put( FIELD_WFPMODEL, INDEX_WFPMODEL);
        fieldIndexMap.put( FIELD_WFPNAME, INDEX_WFPNAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFSTEPLANRESTAG, INDEX_WFSTEPLANRESTAG);
        fieldIndexMap.put( FIELD_WFSTEPNAME, INDEX_WFSTEPNAME);
        fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
    }

    private WFStepBase proxyWFStepBase = null;
    public WFStepBase() {
        super();
    }
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


    /**
     *  设置属性值[建立时间]
     *  @param createdate
     */
    public void setCreateDate(Timestamp createdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
        this.createdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立时间]
     */
    public Timestamp getCreateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    /**
     *  获取属性值[建立时间]是否修改
     */
    public boolean isCreateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    /**
     *  重置属性值[建立时间]
     */
    public void resetCreateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }

        this.createdateDirtyFlag = false;
        this.createdate = null;
    }
    /**
     *  设置属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param createman
     */
    public void setCreateMan(String createman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if(createman!=null) {
            createman = StringHelper.trimRight(createman);
            if(createman.length()==0) {
                createman = null;
            }
        }
        this.createman = createman;
        this.createmanDirtyFlag  = true;
    }

    /**
     *  获取属性值[建立人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getCreateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    /**
     *  获取属性值[建立人]是否修改
     */
    public boolean isCreateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    /**
     *  重置属性值[建立人]
     */
    public void resetCreateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }

        this.createmanDirtyFlag = false;
        this.createman = null;
    }
    /**
     *  设置属性值[步骤限时]
     *  @param deadline
     */
    public void setDeadLine(Timestamp deadline) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setDeadLine(deadline);
            return;
        }
        this.deadline = deadline;
        this.deadlineDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤限时]
     */
    public Timestamp getDeadLine() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getDeadLine();
        }
        return this.deadline;
    }

    /**
     *  获取属性值[步骤限时]是否修改
     */
    public boolean isDeadLineDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isDeadLineDirty();
        }
        return this.deadlineDirtyFlag;
    }

    /**
     *  重置属性值[步骤限时]
     */
    public void resetDeadLine() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetDeadLine();
            return;
        }

        this.deadlineDirtyFlag = false;
        this.deadline = null;
    }
    /**
     *  设置属性值[结束时间]
     *  @param endtime
     */
    public void setEndTime(Timestamp endtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEndTime(endtime);
            return;
        }
        this.endtime = endtime;
        this.endtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[结束时间]
     */
    public Timestamp getEndTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    /**
     *  获取属性值[结束时间]是否修改
     */
    public boolean isEndTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    /**
     *  重置属性值[结束时间]
     */
    public void resetEndTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEndTime();
            return;
        }

        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }
    /**
     *  设置属性值[FROMWFSTEPID]
     *  @param fromwfstepid
     */
    public void setFromWFStepId(String fromwfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFromWFStepId(fromwfstepid);
            return;
        }
        if(fromwfstepid!=null) {
            fromwfstepid = StringHelper.trimRight(fromwfstepid);
            if(fromwfstepid.length()==0) {
                fromwfstepid = null;
            }
        }
        this.fromwfstepid = fromwfstepid;
        this.fromwfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[FROMWFSTEPID]
     */
    public String getFromWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFromWFStepId();
        }
        return this.fromwfstepid;
    }

    /**
     *  获取属性值[FROMWFSTEPID]是否修改
     */
    public boolean isFromWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFromWFStepIdDirty();
        }
        return this.fromwfstepidDirtyFlag;
    }

    /**
     *  重置属性值[FROMWFSTEPID]
     */
    public void resetFromWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFromWFStepId();
            return;
        }

        this.fromwfstepidDirtyFlag = false;
        this.fromwfstepid = null;
    }
    /**
     *  设置属性值[是否完成]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isfinish
     */
    public void setIsFinish(Integer isfinish) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsFinish(isfinish);
            return;
        }
        this.isfinish = isfinish;
        this.isfinishDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否完成]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsFinish() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsFinish();
        }
        return this.isfinish;
    }

    /**
     *  获取属性值[是否完成]是否修改
     */
    public boolean isIsFinishDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsFinishDirty();
        }
        return this.isfinishDirtyFlag;
    }

    /**
     *  重置属性值[是否完成]
     */
    public void resetIsFinish() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsFinish();
            return;
        }

        this.isfinishDirtyFlag = false;
        this.isfinish = null;
    }
    /**
     *  设置属性值[ISINTERACTIVE]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isinteractive
     */
    public void setIsInteractive(Integer isinteractive) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsInteractive(isinteractive);
            return;
        }
        this.isinteractive = isinteractive;
        this.isinteractiveDirtyFlag  = true;
    }

    /**
     *  获取属性值[ISINTERACTIVE]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsInteractive() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsInteractive();
        }
        return this.isinteractive;
    }

    /**
     *  获取属性值[ISINTERACTIVE]是否修改
     */
    public boolean isIsInteractiveDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsInteractiveDirty();
        }
        return this.isinteractiveDirtyFlag;
    }

    /**
     *  重置属性值[ISINTERACTIVE]
     */
    public void resetIsInteractive() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsInteractive();
            return;
        }

        this.isinteractiveDirtyFlag = false;
        this.isinteractive = null;
    }
    /**
     *  设置属性值[LASTACTORID]
     *  @param lastactorid
     */
    public void setLastActorId(String lastactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLastActorId(lastactorid);
            return;
        }
        if(lastactorid!=null) {
            lastactorid = StringHelper.trimRight(lastactorid);
            if(lastactorid.length()==0) {
                lastactorid = null;
            }
        }
        this.lastactorid = lastactorid;
        this.lastactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[LASTACTORID]
     */
    public String getLastActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastActorId();
        }
        return this.lastactorid;
    }

    /**
     *  获取属性值[LASTACTORID]是否修改
     */
    public boolean isLastActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastActorIdDirty();
        }
        return this.lastactoridDirtyFlag;
    }

    /**
     *  重置属性值[LASTACTORID]
     */
    public void resetLastActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLastActorId();
            return;
        }

        this.lastactoridDirtyFlag = false;
        this.lastactorid = null;
    }
    /**
     *  设置属性值[备注]
     *  @param memo
     */
    public void setMemo(String memo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setMemo(memo);
            return;
        }
        if(memo!=null) {
            memo = StringHelper.trimRight(memo);
            if(memo.length()==0) {
                memo = null;
            }
        }
        this.memo = memo;
        this.memoDirtyFlag  = true;
    }

    /**
     *  获取属性值[备注]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[备注]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[备注]
     */
    public void resetMemo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetMemo();
            return;
        }

        this.memoDirtyFlag = false;
        this.memo = null;
    }
    /**
     *  设置属性值[开始时间]
     *  @param starttime
     */
    public void setStartTime(Timestamp starttime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setStartTime(starttime);
            return;
        }
        this.starttime = starttime;
        this.starttimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[开始时间]
     */
    public Timestamp getStartTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getStartTime();
        }
        return this.starttime;
    }

    /**
     *  获取属性值[开始时间]是否修改
     */
    public boolean isStartTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isStartTimeDirty();
        }
        return this.starttimeDirtyFlag;
    }

    /**
     *  重置属性值[开始时间]
     */
    public void resetStartTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetStartTime();
            return;
        }

        this.starttimeDirtyFlag = false;
        this.starttime = null;
    }
    /**
     *  设置属性值[步骤次序]
     *  @param tracestep
     */
    public void setTraceStep(Integer tracestep) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setTraceStep(tracestep);
            return;
        }
        this.tracestep = tracestep;
        this.tracestepDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤次序]
     */
    public Integer getTraceStep() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTraceStep();
        }
        return this.tracestep;
    }

    /**
     *  获取属性值[步骤次序]是否修改
     */
    public boolean isTraceStepDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTraceStepDirty();
        }
        return this.tracestepDirtyFlag;
    }

    /**
     *  重置属性值[步骤次序]
     */
    public void resetTraceStep() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetTraceStep();
            return;
        }

        this.tracestepDirtyFlag = false;
        this.tracestep = null;
    }
    /**
     *  设置属性值[更新时间]
     *  @param updatedate
     */
    public void setUpdateDate(Timestamp updatedate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
        this.updatedateDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新时间]
     */
    public Timestamp getUpdateDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    /**
     *  获取属性值[更新时间]是否修改
     */
    public boolean isUpdateDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    /**
     *  重置属性值[更新时间]
     */
    public void resetUpdateDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }

        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }
    /**
     *  设置属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     *  @param updateman
     */
    public void setUpdateMan(String updateman) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if(updateman!=null) {
            updateman = StringHelper.trimRight(updateman);
            if(updateman.length()==0) {
                updateman = null;
            }
        }
        this.updateman = updateman;
        this.updatemanDirtyFlag  = true;
    }

    /**
     *  获取属性值[更新人]代码表：net.ibizsys.psrt.srv.codelist.SysOperatorCodeListModel
     */
    public String getUpdateMan() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    /**
     *  获取属性值[更新人]是否修改
     */
    public boolean isUpdateManDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    /**
     *  重置属性值[更新人]
     */
    public void resetUpdateMan() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }

        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }
    /**
     *  设置属性值[处理步骤相关实例]
     *  @param wfinstanceid
     */
    public void setWFInstanceId(String wfinstanceid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceId(wfinstanceid);
            return;
        }
        if(wfinstanceid!=null) {
            wfinstanceid = StringHelper.trimRight(wfinstanceid);
            if(wfinstanceid.length()==0) {
                wfinstanceid = null;
            }
        }
        this.wfinstanceid = wfinstanceid;
        this.wfinstanceidDirtyFlag  = true;
    }

    /**
     *  获取属性值[处理步骤相关实例]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[处理步骤相关实例]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[处理步骤相关实例]
     */
    public void resetWFInstanceId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceId();
            return;
        }

        this.wfinstanceidDirtyFlag = false;
        this.wfinstanceid = null;
    }
    /**
     *  设置属性值[流程实例]
     *  @param wfinstancename
     */
    public void setWFInstanceName(String wfinstancename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFInstanceName(wfinstancename);
            return;
        }
        if(wfinstancename!=null) {
            wfinstancename = StringHelper.trimRight(wfinstancename);
            if(wfinstancename.length()==0) {
                wfinstancename = null;
            }
        }
        this.wfinstancename = wfinstancename;
        this.wfinstancenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程实例]
     */
    public String getWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    /**
     *  获取属性值[流程实例]是否修改
     */
    public boolean isWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[流程实例]
     */
    public void resetWFInstanceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFInstanceName();
            return;
        }

        this.wfinstancenameDirtyFlag = false;
        this.wfinstancename = null;
    }
    /**
     *  设置属性值[步骤名称]
     *  @param wfplogicname
     */
    public void setWFPLogicName(String wfplogicname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFPLogicName(wfplogicname);
            return;
        }
        if(wfplogicname!=null) {
            wfplogicname = StringHelper.trimRight(wfplogicname);
            if(wfplogicname.length()==0) {
                wfplogicname = null;
            }
        }
        this.wfplogicname = wfplogicname;
        this.wfplogicnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤名称]
     */
    public String getWFPLogicName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFPLogicName();
        }
        return this.wfplogicname;
    }

    /**
     *  获取属性值[步骤名称]是否修改
     */
    public boolean isWFPLogicNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFPLogicNameDirty();
        }
        return this.wfplogicnameDirtyFlag;
    }

    /**
     *  重置属性值[步骤名称]
     */
    public void resetWFPLogicName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFPLogicName();
            return;
        }

        this.wfplogicnameDirtyFlag = false;
        this.wfplogicname = null;
    }
    /**
     *  设置属性值[WFPMODEL]
     *  @param wfpmodel
     */
    public void setWFPModel(String wfpmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFPModel(wfpmodel);
            return;
        }
        if(wfpmodel!=null) {
            wfpmodel = StringHelper.trimRight(wfpmodel);
            if(wfpmodel.length()==0) {
                wfpmodel = null;
            }
        }
        this.wfpmodel = wfpmodel;
        this.wfpmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[WFPMODEL]
     */
    public String getWFPModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFPModel();
        }
        return this.wfpmodel;
    }

    /**
     *  获取属性值[WFPMODEL]是否修改
     */
    public boolean isWFPModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFPModelDirty();
        }
        return this.wfpmodelDirtyFlag;
    }

    /**
     *  重置属性值[WFPMODEL]
     */
    public void resetWFPModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFPModel();
            return;
        }

        this.wfpmodelDirtyFlag = false;
        this.wfpmodel = null;
    }
    /**
     *  设置属性值[WFPNAME]
     *  @param wfpname
     */
    public void setWFPName(String wfpname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFPName(wfpname);
            return;
        }
        if(wfpname!=null) {
            wfpname = StringHelper.trimRight(wfpname);
            if(wfpname.length()==0) {
                wfpname = null;
            }
        }
        this.wfpname = wfpname;
        this.wfpnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[WFPNAME]
     */
    public String getWFPName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFPName();
        }
        return this.wfpname;
    }

    /**
     *  获取属性值[WFPNAME]是否修改
     */
    public boolean isWFPNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFPNameDirty();
        }
        return this.wfpnameDirtyFlag;
    }

    /**
     *  重置属性值[WFPNAME]
     */
    public void resetWFPName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFPName();
            return;
        }

        this.wfpnameDirtyFlag = false;
        this.wfpname = null;
    }
    /**
     *  设置属性值[工作流步骤标识]
     *  @param wfstepid
     */
    public void setWFStepId(String wfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepId(wfstepid);
            return;
        }
        if(wfstepid!=null) {
            wfstepid = StringHelper.trimRight(wfstepid);
            if(wfstepid.length()==0) {
                wfstepid = null;
            }
        }
        this.wfstepid = wfstepid;
        this.wfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤标识]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[工作流步骤标识]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤标识]
     */
    public void resetWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepId();
            return;
        }

        this.wfstepidDirtyFlag = false;
        this.wfstepid = null;
    }
    /**
     *  设置属性值[步骤语言资源]
     *  @param wfsteplanrestag
     */
    public void setWFStepLanResTag(String wfsteplanrestag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepLanResTag(wfsteplanrestag);
            return;
        }
        if(wfsteplanrestag!=null) {
            wfsteplanrestag = StringHelper.trimRight(wfsteplanrestag);
            if(wfsteplanrestag.length()==0) {
                wfsteplanrestag = null;
            }
        }
        this.wfsteplanrestag = wfsteplanrestag;
        this.wfsteplanrestagDirtyFlag  = true;
    }

    /**
     *  获取属性值[步骤语言资源]
     */
    public String getWFStepLanResTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepLanResTag();
        }
        return this.wfsteplanrestag;
    }

    /**
     *  获取属性值[步骤语言资源]是否修改
     */
    public boolean isWFStepLanResTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepLanResTagDirty();
        }
        return this.wfsteplanrestagDirtyFlag;
    }

    /**
     *  重置属性值[步骤语言资源]
     */
    public void resetWFStepLanResTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepLanResTag();
            return;
        }

        this.wfsteplanrestagDirtyFlag = false;
        this.wfsteplanrestag = null;
    }
    /**
     *  设置属性值[工作流步骤名称]
     *  @param wfstepname
     */
    public void setWFStepName(String wfstepname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepName(wfstepname);
            return;
        }
        if(wfstepname!=null) {
            wfstepname = StringHelper.trimRight(wfstepname);
            if(wfstepname.length()==0) {
                wfstepname = null;
            }
        }
        this.wfstepname = wfstepname;
        this.wfstepnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤名称]
     */
    public String getWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    /**
     *  获取属性值[工作流步骤名称]是否修改
     */
    public boolean isWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤名称]
     */
    public void resetWFStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }

        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }
    /**
     *  设置属性值[工作流版本]
     *  @param wfversion
     */
    public void setWFVersion(Integer wfversion) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFVersion(wfversion);
            return;
        }
        this.wfversion = wfversion;
        this.wfversionDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流版本]
     */
    public Integer getWFVersion() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFVersion();
        }
        return this.wfversion;
    }

    /**
     *  获取属性值[工作流版本]是否修改
     */
    public boolean isWFVersionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFVersionDirty();
        }
        return this.wfversionDirtyFlag;
    }

    /**
     *  重置属性值[工作流版本]
     */
    public void resetWFVersion() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFVersion();
            return;
        }

        this.wfversionDirtyFlag = false;
        this.wfversion = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFStepBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
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

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isDeadLineDirty()) {
            params.put(FIELD_DEADLINE,getDeadLine());
        }
        if(!bDirtyOnly || isEndTimeDirty()) {
            params.put(FIELD_ENDTIME,getEndTime());
        }
        if(!bDirtyOnly || isFromWFStepIdDirty()) {
            params.put(FIELD_FROMWFSTEPID,getFromWFStepId());
        }
        if(!bDirtyOnly || isIsFinishDirty()) {
            params.put(FIELD_ISFINISH,getIsFinish());
        }
        if(!bDirtyOnly || isIsInteractiveDirty()) {
            params.put(FIELD_ISINTERACTIVE,getIsInteractive());
        }
        if(!bDirtyOnly || isLastActorIdDirty()) {
            params.put(FIELD_LASTACTORID,getLastActorId());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isStartTimeDirty()) {
            params.put(FIELD_STARTTIME,getStartTime());
        }
        if(!bDirtyOnly || isTraceStepDirty()) {
            params.put(FIELD_TRACESTEP,getTraceStep());
        }
        if(!bDirtyOnly || isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE,getUpdateDate());
        }
        if(!bDirtyOnly || isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN,getUpdateMan());
        }
        if(!bDirtyOnly || isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID,getWFInstanceId());
        }
        if(!bDirtyOnly || isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME,getWFInstanceName());
        }
        if(!bDirtyOnly || isWFPLogicNameDirty()) {
            params.put(FIELD_WFPLOGICNAME,getWFPLogicName());
        }
        if(!bDirtyOnly || isWFPModelDirty()) {
            params.put(FIELD_WFPMODEL,getWFPModel());
        }
        if(!bDirtyOnly || isWFPNameDirty()) {
            params.put(FIELD_WFPNAME,getWFPName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
        }
        if(!bDirtyOnly || isWFStepLanResTagDirty()) {
            params.put(FIELD_WFSTEPLANRESTAG,getWFStepLanResTag());
        }
        if(!bDirtyOnly || isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME,getWFStepName());
        }
        if(!bDirtyOnly || isWFVersionDirty()) {
            params.put(FIELD_WFVERSION,getWFVersion());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#get(java.lang.String)
     */
    @Override
    public Object get(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().get(strParamName);
        }

        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.get(strParamName);

        return  WFStepBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFStepBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_DEADLINE:
            return et.getDeadLine();
        case INDEX_ENDTIME:
            return et.getEndTime();
        case INDEX_FROMWFSTEPID:
            return et.getFromWFStepId();
        case INDEX_ISFINISH:
            return et.getIsFinish();
        case INDEX_ISINTERACTIVE:
            return et.getIsInteractive();
        case INDEX_LASTACTORID:
            return et.getLastActorId();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_STARTTIME:
            return et.getStartTime();
        case INDEX_TRACESTEP:
            return et.getTraceStep();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName();
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName();
        case INDEX_WFPMODEL:
            return et.getWFPModel();
        case INDEX_WFPNAME:
            return et.getWFPName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag();
        case INDEX_WFSTEPNAME:
            return et.getWFStepName();
        case INDEX_WFVERSION:
            return et.getWFVersion();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#set(java.lang.String, java.lang.Object)
     */
    @Override
    public void set(String strParamName,Object objValue) throws Exception {
        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().set(strParamName,objValue);
            return;
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null) {
            super.set(strParamName,objValue);
            return;
        }

        WFStepBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFStepBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_DEADLINE:
            et.setDeadLine(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_ENDTIME:
            et.setEndTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_FROMWFSTEPID:
            et.setFromWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISFINISH:
            et.setIsFinish(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISINTERACTIVE:
            et.setIsInteractive(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_LASTACTORID:
            et.setLastActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_STARTTIME:
            et.setStartTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_TRACESTEP:
            et.setTraceStep(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_UPDATEDATE:
            et.setUpdateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_UPDATEMAN:
            et.setUpdateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCEID:
            et.setWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCENAME:
            et.setWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFPLOGICNAME:
            et.setWFPLogicName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFPMODEL:
            et.setWFPModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFPNAME:
            et.setWFPName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPLANRESTAG:
            et.setWFStepLanResTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPNAME:
            et.setWFStepName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSION:
            et.setWFVersion(DataObject.getIntegerValue(obj));
            return ;
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#isNull(java.lang.String)
     */
    @Override
    public boolean isNull(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");

        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.isNull(strParamName);

        return  WFStepBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFStepBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_DEADLINE:
            return et.getDeadLine()==null;
        case INDEX_ENDTIME:
            return et.getEndTime()==null;
        case INDEX_FROMWFSTEPID:
            return et.getFromWFStepId()==null;
        case INDEX_ISFINISH:
            return et.getIsFinish()==null;
        case INDEX_ISINTERACTIVE:
            return et.getIsInteractive()==null;
        case INDEX_LASTACTORID:
            return et.getLastActorId()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_STARTTIME:
            return et.getStartTime()==null;
        case INDEX_TRACESTEP:
            return et.getTraceStep()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName()==null;
        case INDEX_WFPLOGICNAME:
            return et.getWFPLogicName()==null;
        case INDEX_WFPMODEL:
            return et.getWFPModel()==null;
        case INDEX_WFPNAME:
            return et.getWFPName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
        case INDEX_WFSTEPLANRESTAG:
            return et.getWFStepLanResTag()==null;
        case INDEX_WFSTEPNAME:
            return et.getWFStepName()==null;
        case INDEX_WFVERSION:
            return et.getWFVersion()==null;
        default:
            throw new Exception("不明属性标识");
        }
    }


    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#contains(java.lang.String)
     */
    @Override
    public boolean contains(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.contains(strParamName);
        return  WFStepBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFStepBase et,int index) throws Exception {

        switch(index) {
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_DEADLINE:
            return et.isDeadLineDirty();
        case INDEX_ENDTIME:
            return et.isEndTimeDirty();
        case INDEX_FROMWFSTEPID:
            return et.isFromWFStepIdDirty();
        case INDEX_ISFINISH:
            return et.isIsFinishDirty();
        case INDEX_ISINTERACTIVE:
            return et.isIsInteractiveDirty();
        case INDEX_LASTACTORID:
            return et.isLastActorIdDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_STARTTIME:
            return et.isStartTimeDirty();
        case INDEX_TRACESTEP:
            return et.isTraceStepDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFINSTANCENAME:
            return et.isWFInstanceNameDirty();
        case INDEX_WFPLOGICNAME:
            return et.isWFPLogicNameDirty();
        case INDEX_WFPMODEL:
            return et.isWFPModelDirty();
        case INDEX_WFPNAME:
            return et.isWFPNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
        case INDEX_WFSTEPLANRESTAG:
            return et.isWFStepLanResTagDirty();
        case INDEX_WFSTEPNAME:
            return et.isWFStepNameDirty();
        case INDEX_WFVERSION:
            return et.isWFVersionDirty();
        default:
            throw new Exception("不明属性标识");
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillJSONObject(net.sf.json.JSONObject, boolean)
     */
    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        fillJSONObject(this,objJSON,bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    /**
     * 填充当前对象到JSON
     * @param et 当前数据对象
     * @param json JSON对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static  void fillJSONObject(WFStepBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getDeadLine()!=null) {
            JSONObjectHelper.put(json,"deadline",getJSONValue(et.getDeadLine()),false);
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            JSONObjectHelper.put(json,"endtime",getJSONValue(et.getEndTime()),false);
        }
        if(bIncEmpty||et.getFromWFStepId()!=null) {
            JSONObjectHelper.put(json,"fromwfstepid",getJSONValue(et.getFromWFStepId()),false);
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            JSONObjectHelper.put(json,"isfinish",getJSONValue(et.getIsFinish()),false);
        }
        if(bIncEmpty||et.getIsInteractive()!=null) {
            JSONObjectHelper.put(json,"isinteractive",getJSONValue(et.getIsInteractive()),false);
        }
        if(bIncEmpty||et.getLastActorId()!=null) {
            JSONObjectHelper.put(json,"lastactorid",getJSONValue(et.getLastActorId()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            JSONObjectHelper.put(json,"starttime",getJSONValue(et.getStartTime()),false);
        }
        if(bIncEmpty||et.getTraceStep()!=null) {
            JSONObjectHelper.put(json,"tracestep",getJSONValue(et.getTraceStep()),false);
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            JSONObjectHelper.put(json,"updatedate",getJSONValue(et.getUpdateDate()),false);
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            JSONObjectHelper.put(json,"updateman",getJSONValue(et.getUpdateMan()),false);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"wfinstanceid",getJSONValue(et.getWFInstanceId()),false);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"wfinstancename",getJSONValue(et.getWFInstanceName()),false);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            JSONObjectHelper.put(json,"wfplogicname",getJSONValue(et.getWFPLogicName()),false);
        }
        if(bIncEmpty||et.getWFPModel()!=null) {
            JSONObjectHelper.put(json,"wfpmodel",getJSONValue(et.getWFPModel()),false);
        }
        if(bIncEmpty||et.getWFPName()!=null) {
            JSONObjectHelper.put(json,"wfpname",getJSONValue(et.getWFPName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            JSONObjectHelper.put(json,"wfsteplanrestag",getJSONValue(et.getWFStepLanResTag()),false);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            JSONObjectHelper.put(json,"wfstepname",getJSONValue(et.getWFStepName()),false);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onFillXmlNode(net.ibizsys.paas.xml.XmlNode, boolean)
     */
    @Override
    protected void onFillXmlNode(XmlNode xmlNode,boolean bIncludeEmpty) throws Exception {
        fillXmlNode(this,xmlNode,bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    /**
     * 填充当前对象到Xml节点中
     * @param et 当前数据对象
     * @param node Xml节点
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void fillXmlNode(WFStepBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getDeadLine()!=null) {
            Object obj = et.getDeadLine();
            node.setAttribute("DEADLINE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            Object obj = et.getEndTime();
            node.setAttribute("ENDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getFromWFStepId()!=null) {
            Object obj = et.getFromWFStepId();
            node.setAttribute("FROMWFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            Object obj = et.getIsFinish();
            node.setAttribute("ISFINISH",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsInteractive()!=null) {
            Object obj = et.getIsInteractive();
            node.setAttribute("ISINTERACTIVE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLastActorId()!=null) {
            Object obj = et.getLastActorId();
            node.setAttribute("LASTACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            Object obj = et.getStartTime();
            node.setAttribute("STARTTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getTraceStep()!=null) {
            Object obj = et.getTraceStep();
            node.setAttribute("TRACESTEP",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getUpdateDate()!=null) {
            Object obj = et.getUpdateDate();
            node.setAttribute("UPDATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getUpdateMan()!=null) {
            Object obj = et.getUpdateMan();
            node.setAttribute("UPDATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            Object obj = et.getWFInstanceId();
            node.setAttribute("WFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            Object obj = et.getWFInstanceName();
            node.setAttribute("WFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFPLogicName()!=null) {
            Object obj = et.getWFPLogicName();
            node.setAttribute("WFPLOGICNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFPModel()!=null) {
            Object obj = et.getWFPModel();
            node.setAttribute("WFPMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFPName()!=null) {
            Object obj = et.getWFPName();
            node.setAttribute("WFPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepLanResTag()!=null) {
            Object obj = et.getWFStepLanResTag();
            node.setAttribute("WFSTEPLANRESTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            Object obj = et.getWFStepName();
            node.setAttribute("WFSTEPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            Object obj = et.getWFVersion();
            node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFStepBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isDeadLineDirty() && (bIncEmpty||et.getDeadLine()!=null)) {
            dst.set(FIELD_DEADLINE,et.getDeadLine());
        }
        if(et.isEndTimeDirty() && (bIncEmpty||et.getEndTime()!=null)) {
            dst.set(FIELD_ENDTIME,et.getEndTime());
        }
        if(et.isFromWFStepIdDirty() && (bIncEmpty||et.getFromWFStepId()!=null)) {
            dst.set(FIELD_FROMWFSTEPID,et.getFromWFStepId());
        }
        if(et.isIsFinishDirty() && (bIncEmpty||et.getIsFinish()!=null)) {
            dst.set(FIELD_ISFINISH,et.getIsFinish());
        }
        if(et.isIsInteractiveDirty() && (bIncEmpty||et.getIsInteractive()!=null)) {
            dst.set(FIELD_ISINTERACTIVE,et.getIsInteractive());
        }
        if(et.isLastActorIdDirty() && (bIncEmpty||et.getLastActorId()!=null)) {
            dst.set(FIELD_LASTACTORID,et.getLastActorId());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isStartTimeDirty() && (bIncEmpty||et.getStartTime()!=null)) {
            dst.set(FIELD_STARTTIME,et.getStartTime());
        }
        if(et.isTraceStepDirty() && (bIncEmpty||et.getTraceStep()!=null)) {
            dst.set(FIELD_TRACESTEP,et.getTraceStep());
        }
        if(et.isUpdateDateDirty() && (bIncEmpty||et.getUpdateDate()!=null)) {
            dst.set(FIELD_UPDATEDATE,et.getUpdateDate());
        }
        if(et.isUpdateManDirty() && (bIncEmpty||et.getUpdateMan()!=null)) {
            dst.set(FIELD_UPDATEMAN,et.getUpdateMan());
        }
        if(et.isWFInstanceIdDirty() && (bIncEmpty||et.getWFInstanceId()!=null)) {
            dst.set(FIELD_WFINSTANCEID,et.getWFInstanceId());
        }
        if(et.isWFInstanceNameDirty() && (bIncEmpty||et.getWFInstanceName()!=null)) {
            dst.set(FIELD_WFINSTANCENAME,et.getWFInstanceName());
        }
        if(et.isWFPLogicNameDirty() && (bIncEmpty||et.getWFPLogicName()!=null)) {
            dst.set(FIELD_WFPLOGICNAME,et.getWFPLogicName());
        }
        if(et.isWFPModelDirty() && (bIncEmpty||et.getWFPModel()!=null)) {
            dst.set(FIELD_WFPMODEL,et.getWFPModel());
        }
        if(et.isWFPNameDirty() && (bIncEmpty||et.getWFPName()!=null)) {
            dst.set(FIELD_WFPNAME,et.getWFPName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
        }
        if(et.isWFStepLanResTagDirty() && (bIncEmpty||et.getWFStepLanResTag()!=null)) {
            dst.set(FIELD_WFSTEPLANRESTAG,et.getWFStepLanResTag());
        }
        if(et.isWFStepNameDirty() && (bIncEmpty||et.getWFStepName()!=null)) {
            dst.set(FIELD_WFSTEPNAME,et.getWFStepName());
        }
        if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null)) {
            dst.set(FIELD_WFVERSION,et.getWFVersion());
        }
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#remove(java.lang.String)
     */
    @Override
    public boolean remove(String strParamName) throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if(StringHelper.isNullOrEmpty(strParamName))
            throw new Exception("没有指定属性");
        Integer index=fieldIndexMap.get(strParamName.toUpperCase());
        if(index==null)
            return super.remove(strParamName);
        return  WFStepBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFStepBase et,int index) throws Exception {
        switch(index) {
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_DEADLINE:
            et.resetDeadLine();
            return true;
        case INDEX_ENDTIME:
            et.resetEndTime();
            return true;
        case INDEX_FROMWFSTEPID:
            et.resetFromWFStepId();
            return true;
        case INDEX_ISFINISH:
            et.resetIsFinish();
            return true;
        case INDEX_ISINTERACTIVE:
            et.resetIsInteractive();
            return true;
        case INDEX_LASTACTORID:
            et.resetLastActorId();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_STARTTIME:
            et.resetStartTime();
            return true;
        case INDEX_TRACESTEP:
            et.resetTraceStep();
            return true;
        case INDEX_UPDATEDATE:
            et.resetUpdateDate();
            return true;
        case INDEX_UPDATEMAN:
            et.resetUpdateMan();
            return true;
        case INDEX_WFINSTANCEID:
            et.resetWFInstanceId();
            return true;
        case INDEX_WFINSTANCENAME:
            et.resetWFInstanceName();
            return true;
        case INDEX_WFPLOGICNAME:
            et.resetWFPLogicName();
            return true;
        case INDEX_WFPMODEL:
            et.resetWFPModel();
            return true;
        case INDEX_WFPNAME:
            et.resetWFPName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
            return true;
        case INDEX_WFSTEPLANRESTAG:
            et.resetWFStepLanResTag();
            return true;
        case INDEX_WFSTEPNAME:
            et.resetWFStepName();
            return true;
        case INDEX_WFVERSION:
            et.resetWFVersion();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFInstanceLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = null;
    /**
    * 获取父数据 工作流实例
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFInstance getWFInstance() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstance();
        }

        if(this.getWFInstanceId()==null)
            return null;
        synchronized(this.objWFInstanceLock) {
            if(this.wfinstance!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFInstanceId(),wfinstance.getWFInstanceId())!=0) {
                    this.wfinstance = null;
                }
            }


            if(this.wfinstance==null) {
                net.ibizsys.psrt.srv.wf.entity.WFInstance wfinstance = new net.ibizsys.psrt.srv.wf.entity.WFInstance();
                wfinstance.setWFInstanceId(this.getWFInstanceId());
                net.ibizsys.psrt.srv.wf.service.WFInstanceService service = (net.ibizsys.psrt.srv.wf.service.WFInstanceService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFInstanceService.class,this.getSessionFactory());
                service.autoGet(wfinstance);
                this.wfinstance = wfinstance;
            }
            return this.wfinstance;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFStepBase getProxyEntity() {
        return this.proxyWFStepBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFStepBase) {
            this.proxyWFStepBase = (WFStepBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }


    /**
    * 重写获取行为操作辅助对象
    */
    protected net.ibizsys.paas.entity.IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        net.ibizsys.paas.entity.IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if(!bMust || iEntityActionHelper!=null)
            return iEntityActionHelper;
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}