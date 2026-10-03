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
 * 实体[WFInstance] 数据对象基类
 */
public abstract class WFInstanceBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFInstanceBase.class);
    /**
     * 属性[ACTIVESTEPID]
     */
    public final static String FIELD_ACTIVESTEPID = "ACTIVESTEPID";
    /**
     * 属性[当前步骤名称]
     */
    public final static String FIELD_ACTIVESTEPNAME = "ACTIVESTEPNAME";
    /**
     * 属性[取消原因]
     */
    public final static String FIELD_CANCELREASON = "CANCELREASON";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[逻辑有效标志]
     */
    public final static String FIELD_ENABLE = "ENABLE";
    /**
     * 属性[结束时间]
     */
    public final static String FIELD_ENDTIME = "ENDTIME";
    /**
     * 属性[错误信息]
     */
    public final static String FIELD_ERRORINFO = "ERRORINFO";
    /**
     * 属性[重要程度]
     */
    public final static String FIELD_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    /**
     * 属性[是否取消]
     */
    public final static String FIELD_ISCANCEL = "ISCANCEL";
    /**
     * 属性[是否关闭]
     */
    public final static String FIELD_ISCLOSE = "ISCLOSE";
    /**
     * 属性[是否错误]
     */
    public final static String FIELD_ISERROR = "ISERROR";
    /**
     * 属性[是否完成]
     */
    public final static String FIELD_ISFINISH = "ISFINISH";
    /**
     * 属性[上一个操作]
     */
    public final static String FIELD_LASTACTION = "LASTACTION";
    /**
     * 属性[上一个操作者]
     */
    public final static String FIELD_LASTACTORID = "LASTACTORID";
    /**
     * 属性[上一个操作步骤]
     */
    public final static String FIELD_LASTWFSTEPID = "LASTWFSTEPID";
    /**
     * 属性[工作流说明]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[组织标识]
     */
    public final static String FIELD_ORGID = "ORGID";
    /**
     * 属性[组织名称]
     */
    public final static String FIELD_ORGNAME = "ORGNAME";
    /**
     * 属性[OWNER]
     */
    public final static String FIELD_OWNER = "OWNER";
    /**
     * 属性[并行实例]
     */
    public final static String FIELD_PARALLELINST = "PARALLELINST";
    /**
     * 属性[父步骤编号]
     */
    public final static String FIELD_PSTEPID = "PSTEPID";
    /**
     * 属性[父实例]
     */
    public final static String FIELD_PWFINSTANCEID = "PWFINSTANCEID";
    /**
     * 属性[父实例]
     */
    public final static String FIELD_PWFINSTANCENAME = "PWFINSTANCENAME";
    /**
     * 属性[结果信息]
     */
    public final static String FIELD_RESULT = "RESULT";
    /**
     * 属性[开始时间]
     */
    public final static String FIELD_STARTTIME = "STARTTIME";
    /**
     * 属性[流程挂起]
     */
    public final static String FIELD_SUSPENDFLAG = "SUSPENDFLAG";
    /**
     * 属性[跟踪步骤]
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
     * 属性[用户数据]
     */
    public final static String FIELD_USERDATA = "USERDATA";
    /**
     * 属性[用户数据2]
     */
    public final static String FIELD_USERDATA2 = "USERDATA2";
    /**
     * 属性[用户数据3]
     */
    public final static String FIELD_USERDATA3 = "USERDATA3";
    /**
     * 属性[用户数据4]
     */
    public final static String FIELD_USERDATA4 = "USERDATA4";
    /**
     * 属性[用户数据信息]
     */
    public final static String FIELD_USERDATAINFO = "USERDATAINFO";
    /**
     * 属性[自定义数据]
     */
    public final static String FIELD_USERTAG = "USERTAG";
    /**
     * 属性[自定义数据]
     */
    public final static String FIELD_USERTAG2 = "USERTAG2";
    /**
     * 属性[工作流实例标识]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[工作流实例名称]
     */
    public final static String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    /**
     * 属性[流程配置]
     */
    public final static String FIELD_WFMODEL = "WFMODEL";
    /**
     * 属性[工作流版本]
     */
    public final static String FIELD_WFVERSION = "WFVERSION";
    /**
     * 属性[工作流名称]
     */
    public final static String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    /**
     * 属性[工作流名称]
     */
    public final static String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";

    private final static int INDEX_ACTIVESTEPID = 0;
    private final static int INDEX_ACTIVESTEPNAME = 1;
    private final static int INDEX_CANCELREASON = 2;
    private final static int INDEX_CREATEDATE = 3;
    private final static int INDEX_CREATEMAN = 4;
    private final static int INDEX_ENABLE = 5;
    private final static int INDEX_ENDTIME = 6;
    private final static int INDEX_ERRORINFO = 7;
    private final static int INDEX_IMPORTANCEFLAG = 8;
    private final static int INDEX_ISCANCEL = 9;
    private final static int INDEX_ISCLOSE = 10;
    private final static int INDEX_ISERROR = 11;
    private final static int INDEX_ISFINISH = 12;
    private final static int INDEX_LASTACTION = 13;
    private final static int INDEX_LASTACTORID = 14;
    private final static int INDEX_LASTWFSTEPID = 15;
    private final static int INDEX_MEMO = 16;
    private final static int INDEX_ORGID = 17;
    private final static int INDEX_ORGNAME = 18;
    private final static int INDEX_OWNER = 19;
    private final static int INDEX_PARALLELINST = 20;
    private final static int INDEX_PSTEPID = 21;
    private final static int INDEX_PWFINSTANCEID = 22;
    private final static int INDEX_PWFINSTANCENAME = 23;
    private final static int INDEX_RESULT = 24;
    private final static int INDEX_STARTTIME = 25;
    private final static int INDEX_SUSPENDFLAG = 26;
    private final static int INDEX_TRACESTEP = 27;
    private final static int INDEX_UPDATEDATE = 28;
    private final static int INDEX_UPDATEMAN = 29;
    private final static int INDEX_USERDATA = 30;
    private final static int INDEX_USERDATA2 = 31;
    private final static int INDEX_USERDATA3 = 32;
    private final static int INDEX_USERDATA4 = 33;
    private final static int INDEX_USERDATAINFO = 34;
    private final static int INDEX_USERTAG = 35;
    private final static int INDEX_USERTAG2 = 36;
    private final static int INDEX_WFINSTANCEID = 37;
    private final static int INDEX_WFINSTANCENAME = 38;
    private final static int INDEX_WFMODEL = 39;
    private final static int INDEX_WFVERSION = 40;
    private final static int INDEX_WFWORKFLOWID = 41;
    private final static int INDEX_WFWORKFLOWNAME = 42;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTIVESTEPID, INDEX_ACTIVESTEPID);
        fieldIndexMap.put( FIELD_ACTIVESTEPNAME, INDEX_ACTIVESTEPNAME);
        fieldIndexMap.put( FIELD_CANCELREASON, INDEX_CANCELREASON);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_ENABLE, INDEX_ENABLE);
        fieldIndexMap.put( FIELD_ENDTIME, INDEX_ENDTIME);
        fieldIndexMap.put( FIELD_ERRORINFO, INDEX_ERRORINFO);
        fieldIndexMap.put( FIELD_IMPORTANCEFLAG, INDEX_IMPORTANCEFLAG);
        fieldIndexMap.put( FIELD_ISCANCEL, INDEX_ISCANCEL);
        fieldIndexMap.put( FIELD_ISCLOSE, INDEX_ISCLOSE);
        fieldIndexMap.put( FIELD_ISERROR, INDEX_ISERROR);
        fieldIndexMap.put( FIELD_ISFINISH, INDEX_ISFINISH);
        fieldIndexMap.put( FIELD_LASTACTION, INDEX_LASTACTION);
        fieldIndexMap.put( FIELD_LASTACTORID, INDEX_LASTACTORID);
        fieldIndexMap.put( FIELD_LASTWFSTEPID, INDEX_LASTWFSTEPID);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_ORGID, INDEX_ORGID);
        fieldIndexMap.put( FIELD_ORGNAME, INDEX_ORGNAME);
        fieldIndexMap.put( FIELD_OWNER, INDEX_OWNER);
        fieldIndexMap.put( FIELD_PARALLELINST, INDEX_PARALLELINST);
        fieldIndexMap.put( FIELD_PSTEPID, INDEX_PSTEPID);
        fieldIndexMap.put( FIELD_PWFINSTANCEID, INDEX_PWFINSTANCEID);
        fieldIndexMap.put( FIELD_PWFINSTANCENAME, INDEX_PWFINSTANCENAME);
        fieldIndexMap.put( FIELD_RESULT, INDEX_RESULT);
        fieldIndexMap.put( FIELD_STARTTIME, INDEX_STARTTIME);
        fieldIndexMap.put( FIELD_SUSPENDFLAG, INDEX_SUSPENDFLAG);
        fieldIndexMap.put( FIELD_TRACESTEP, INDEX_TRACESTEP);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_USERDATA, INDEX_USERDATA);
        fieldIndexMap.put( FIELD_USERDATA2, INDEX_USERDATA2);
        fieldIndexMap.put( FIELD_USERDATA3, INDEX_USERDATA3);
        fieldIndexMap.put( FIELD_USERDATA4, INDEX_USERDATA4);
        fieldIndexMap.put( FIELD_USERDATAINFO, INDEX_USERDATAINFO);
        fieldIndexMap.put( FIELD_USERTAG, INDEX_USERTAG);
        fieldIndexMap.put( FIELD_USERTAG2, INDEX_USERTAG2);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFINSTANCENAME, INDEX_WFINSTANCENAME);
        fieldIndexMap.put( FIELD_WFMODEL, INDEX_WFMODEL);
        fieldIndexMap.put( FIELD_WFVERSION, INDEX_WFVERSION);
        fieldIndexMap.put( FIELD_WFWORKFLOWID, INDEX_WFWORKFLOWID);
        fieldIndexMap.put( FIELD_WFWORKFLOWNAME, INDEX_WFWORKFLOWNAME);
    }

    private WFInstanceBase proxyWFInstanceBase = null;
    public WFInstanceBase() {
        super();
    }
    private boolean activestepidDirtyFlag = false;
    private boolean activestepnameDirtyFlag = false;
    private boolean cancelreasonDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean errorinfoDirtyFlag = false;
    private boolean importanceflagDirtyFlag = false;
    private boolean iscancelDirtyFlag = false;
    private boolean iscloseDirtyFlag = false;
    private boolean iserrorDirtyFlag = false;
    private boolean isfinishDirtyFlag = false;
    private boolean lastactionDirtyFlag = false;
    private boolean lastactoridDirtyFlag = false;
    private boolean lastwfstepidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean orgidDirtyFlag = false;
    private boolean orgnameDirtyFlag = false;
    private boolean ownerDirtyFlag = false;
    private boolean parallelinstDirtyFlag = false;
    private boolean pstepidDirtyFlag = false;
    private boolean pwfinstanceidDirtyFlag = false;
    private boolean pwfinstancenameDirtyFlag = false;
    private boolean resultDirtyFlag = false;
    private boolean starttimeDirtyFlag = false;
    private boolean suspendflagDirtyFlag = false;
    private boolean tracestepDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean userdatainfoDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfmodelDirtyFlag = false;
    private boolean wfversionDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;

    @Column(name="activestepid")
    private String activestepid;
    @Column(name="activestepname")
    private String activestepname;
    @Column(name="cancelreason")
    private String cancelreason;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="errorinfo")
    private String errorinfo;
    @Column(name="importanceflag")
    private Integer importanceflag;
    @Column(name="iscancel")
    private Integer iscancel;
    @Column(name="isclose")
    private Integer isclose;
    @Column(name="iserror")
    private Integer iserror;
    @Column(name="isfinish")
    private Integer isfinish;
    @Column(name="lastaction")
    private String lastaction;
    @Column(name="lastactorid")
    private String lastactorid;
    @Column(name="lastwfstepid")
    private String lastwfstepid;
    @Column(name="memo")
    private String memo;
    @Column(name="orgid")
    private String orgid;
    @Column(name="orgname")
    private String orgname;
    @Column(name="owner")
    private String owner;
    @Column(name="parallelinst")
    private Integer parallelinst;
    @Column(name="pstepid")
    private String pstepid;
    @Column(name="pwfinstanceid")
    private String pwfinstanceid;
    @Column(name="pwfinstancename")
    private String pwfinstancename;
    @Column(name="result")
    private String result;
    @Column(name="starttime")
    private Timestamp starttime;
    @Column(name="suspendflag")
    private Integer suspendflag;
    @Column(name="tracestep")
    private Integer tracestep;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userdata3")
    private String userdata3;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="userdatainfo")
    private String userdatainfo;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfmodel")
    private String wfmodel;
    @Column(name="wfversion")
    private Integer wfversion;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;


    /**
     *  设置属性值[ACTIVESTEPID]
     *  @param activestepid
     */
    public void setActiveStepId(String activestepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActiveStepId(activestepid);
            return;
        }
        if(activestepid!=null) {
            activestepid = StringHelper.trimRight(activestepid);
            if(activestepid.length()==0) {
                activestepid = null;
            }
        }
        this.activestepid = activestepid;
        this.activestepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[ACTIVESTEPID]
     */
    public String getActiveStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActiveStepId();
        }
        return this.activestepid;
    }

    /**
     *  获取属性值[ACTIVESTEPID]是否修改
     */
    public boolean isActiveStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActiveStepIdDirty();
        }
        return this.activestepidDirtyFlag;
    }

    /**
     *  重置属性值[ACTIVESTEPID]
     */
    public void resetActiveStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActiveStepId();
            return;
        }

        this.activestepidDirtyFlag = false;
        this.activestepid = null;
    }
    /**
     *  设置属性值[当前步骤名称]
     *  @param activestepname
     */
    public void setActiveStepName(String activestepname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActiveStepName(activestepname);
            return;
        }
        if(activestepname!=null) {
            activestepname = StringHelper.trimRight(activestepname);
            if(activestepname.length()==0) {
                activestepname = null;
            }
        }
        this.activestepname = activestepname;
        this.activestepnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[当前步骤名称]
     */
    public String getActiveStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActiveStepName();
        }
        return this.activestepname;
    }

    /**
     *  获取属性值[当前步骤名称]是否修改
     */
    public boolean isActiveStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActiveStepNameDirty();
        }
        return this.activestepnameDirtyFlag;
    }

    /**
     *  重置属性值[当前步骤名称]
     */
    public void resetActiveStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActiveStepName();
            return;
        }

        this.activestepnameDirtyFlag = false;
        this.activestepname = null;
    }
    /**
     *  设置属性值[取消原因]
     *  @param cancelreason
     */
    public void setCancelReason(String cancelreason) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setCancelReason(cancelreason);
            return;
        }
        if(cancelreason!=null) {
            cancelreason = StringHelper.trimRight(cancelreason);
            if(cancelreason.length()==0) {
                cancelreason = null;
            }
        }
        this.cancelreason = cancelreason;
        this.cancelreasonDirtyFlag  = true;
    }

    /**
     *  获取属性值[取消原因]
     */
    public String getCancelReason() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getCancelReason();
        }
        return this.cancelreason;
    }

    /**
     *  获取属性值[取消原因]是否修改
     */
    public boolean isCancelReasonDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isCancelReasonDirty();
        }
        return this.cancelreasonDirtyFlag;
    }

    /**
     *  重置属性值[取消原因]
     */
    public void resetCancelReason() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetCancelReason();
            return;
        }

        this.cancelreasonDirtyFlag = false;
        this.cancelreason = null;
    }
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
     *  设置属性值[逻辑有效标志]
     *  @param enable
     */
    public void setEnable(Integer enable) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag  = true;
    }

    /**
     *  获取属性值[逻辑有效标志]
     */
    public Integer getEnable() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    /**
     *  获取属性值[逻辑有效标志]是否修改
     */
    public boolean isEnableDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    /**
     *  重置属性值[逻辑有效标志]
     */
    public void resetEnable() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetEnable();
            return;
        }

        this.enableDirtyFlag = false;
        this.enable = null;
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
     *  设置属性值[错误信息]
     *  @param errorinfo
     */
    public void setErrorInfo(String errorinfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setErrorInfo(errorinfo);
            return;
        }
        if(errorinfo!=null) {
            errorinfo = StringHelper.trimRight(errorinfo);
            if(errorinfo.length()==0) {
                errorinfo = null;
            }
        }
        this.errorinfo = errorinfo;
        this.errorinfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[错误信息]
     */
    public String getErrorInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    /**
     *  获取属性值[错误信息]是否修改
     */
    public boolean isErrorInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    /**
     *  重置属性值[错误信息]
     */
    public void resetErrorInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }

        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }
    /**
     *  设置属性值[重要程度]
     *  @param importanceflag
     */
    public void setImportanceFlag(Integer importanceflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setImportanceFlag(importanceflag);
            return;
        }
        this.importanceflag = importanceflag;
        this.importanceflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[重要程度]
     */
    public Integer getImportanceFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getImportanceFlag();
        }
        return this.importanceflag;
    }

    /**
     *  获取属性值[重要程度]是否修改
     */
    public boolean isImportanceFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isImportanceFlagDirty();
        }
        return this.importanceflagDirtyFlag;
    }

    /**
     *  重置属性值[重要程度]
     */
    public void resetImportanceFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetImportanceFlag();
            return;
        }

        this.importanceflagDirtyFlag = false;
        this.importanceflag = null;
    }
    /**
     *  设置属性值[是否取消]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param iscancel
     */
    public void setIsCancel(Integer iscancel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsCancel(iscancel);
            return;
        }
        this.iscancel = iscancel;
        this.iscancelDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否取消]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsCancel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsCancel();
        }
        return this.iscancel;
    }

    /**
     *  获取属性值[是否取消]是否修改
     */
    public boolean isIsCancelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsCancelDirty();
        }
        return this.iscancelDirtyFlag;
    }

    /**
     *  重置属性值[是否取消]
     */
    public void resetIsCancel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsCancel();
            return;
        }

        this.iscancelDirtyFlag = false;
        this.iscancel = null;
    }
    /**
     *  设置属性值[是否关闭]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isclose
     */
    public void setIsClose(Integer isclose) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsClose(isclose);
            return;
        }
        this.isclose = isclose;
        this.iscloseDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否关闭]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsClose() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsClose();
        }
        return this.isclose;
    }

    /**
     *  获取属性值[是否关闭]是否修改
     */
    public boolean isIsCloseDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsCloseDirty();
        }
        return this.iscloseDirtyFlag;
    }

    /**
     *  重置属性值[是否关闭]
     */
    public void resetIsClose() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsClose();
            return;
        }

        this.iscloseDirtyFlag = false;
        this.isclose = null;
    }
    /**
     *  设置属性值[是否错误]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param iserror
     */
    public void setIsError(Integer iserror) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsError(iserror);
            return;
        }
        this.iserror = iserror;
        this.iserrorDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否错误]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsError() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsError();
        }
        return this.iserror;
    }

    /**
     *  获取属性值[是否错误]是否修改
     */
    public boolean isIsErrorDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsErrorDirty();
        }
        return this.iserrorDirtyFlag;
    }

    /**
     *  重置属性值[是否错误]
     */
    public void resetIsError() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsError();
            return;
        }

        this.iserrorDirtyFlag = false;
        this.iserror = null;
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
     *  设置属性值[上一个操作]
     *  @param lastaction
     */
    public void setLastAction(String lastaction) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLastAction(lastaction);
            return;
        }
        if(lastaction!=null) {
            lastaction = StringHelper.trimRight(lastaction);
            if(lastaction.length()==0) {
                lastaction = null;
            }
        }
        this.lastaction = lastaction;
        this.lastactionDirtyFlag  = true;
    }

    /**
     *  获取属性值[上一个操作]
     */
    public String getLastAction() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastAction();
        }
        return this.lastaction;
    }

    /**
     *  获取属性值[上一个操作]是否修改
     */
    public boolean isLastActionDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastActionDirty();
        }
        return this.lastactionDirtyFlag;
    }

    /**
     *  重置属性值[上一个操作]
     */
    public void resetLastAction() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLastAction();
            return;
        }

        this.lastactionDirtyFlag = false;
        this.lastaction = null;
    }
    /**
     *  设置属性值[上一个操作者]
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
     *  获取属性值[上一个操作者]
     */
    public String getLastActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastActorId();
        }
        return this.lastactorid;
    }

    /**
     *  获取属性值[上一个操作者]是否修改
     */
    public boolean isLastActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastActorIdDirty();
        }
        return this.lastactoridDirtyFlag;
    }

    /**
     *  重置属性值[上一个操作者]
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
     *  设置属性值[上一个操作步骤]
     *  @param lastwfstepid
     */
    public void setLastWFStepId(String lastwfstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setLastWFStepId(lastwfstepid);
            return;
        }
        if(lastwfstepid!=null) {
            lastwfstepid = StringHelper.trimRight(lastwfstepid);
            if(lastwfstepid.length()==0) {
                lastwfstepid = null;
            }
        }
        this.lastwfstepid = lastwfstepid;
        this.lastwfstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[上一个操作步骤]
     */
    public String getLastWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getLastWFStepId();
        }
        return this.lastwfstepid;
    }

    /**
     *  获取属性值[上一个操作步骤]是否修改
     */
    public boolean isLastWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isLastWFStepIdDirty();
        }
        return this.lastwfstepidDirtyFlag;
    }

    /**
     *  重置属性值[上一个操作步骤]
     */
    public void resetLastWFStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetLastWFStepId();
            return;
        }

        this.lastwfstepidDirtyFlag = false;
        this.lastwfstepid = null;
    }
    /**
     *  设置属性值[工作流说明]
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
     *  获取属性值[工作流说明]
     */
    public String getMemo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getMemo();
        }
        return this.memo;
    }

    /**
     *  获取属性值[工作流说明]是否修改
     */
    public boolean isMemoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isMemoDirty();
        }
        return this.memoDirtyFlag;
    }

    /**
     *  重置属性值[工作流说明]
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
     *  设置属性值[组织标识]
     *  @param orgid
     */
    public void setOrgId(String orgid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgId(orgid);
            return;
        }
        if(orgid!=null) {
            orgid = StringHelper.trimRight(orgid);
            if(orgid.length()==0) {
                orgid = null;
            }
        }
        this.orgid = orgid;
        this.orgidDirtyFlag  = true;
    }

    /**
     *  获取属性值[组织标识]
     */
    public String getOrgId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgId();
        }
        return this.orgid;
    }

    /**
     *  获取属性值[组织标识]是否修改
     */
    public boolean isOrgIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgIdDirty();
        }
        return this.orgidDirtyFlag;
    }

    /**
     *  重置属性值[组织标识]
     */
    public void resetOrgId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgId();
            return;
        }

        this.orgidDirtyFlag = false;
        this.orgid = null;
    }
    /**
     *  设置属性值[组织名称]
     *  @param orgname
     */
    public void setOrgName(String orgname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOrgName(orgname);
            return;
        }
        if(orgname!=null) {
            orgname = StringHelper.trimRight(orgname);
            if(orgname.length()==0) {
                orgname = null;
            }
        }
        this.orgname = orgname;
        this.orgnameDirtyFlag  = true;
    }

    /**
     *  获取属性值[组织名称]
     */
    public String getOrgName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrgName();
        }
        return this.orgname;
    }

    /**
     *  获取属性值[组织名称]是否修改
     */
    public boolean isOrgNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOrgNameDirty();
        }
        return this.orgnameDirtyFlag;
    }

    /**
     *  重置属性值[组织名称]
     */
    public void resetOrgName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOrgName();
            return;
        }

        this.orgnameDirtyFlag = false;
        this.orgname = null;
    }
    /**
     *  设置属性值[OWNER]
     *  @param owner
     */
    public void setOwner(String owner) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOwner(owner);
            return;
        }
        if(owner!=null) {
            owner = StringHelper.trimRight(owner);
            if(owner.length()==0) {
                owner = null;
            }
        }
        this.owner = owner;
        this.ownerDirtyFlag  = true;
    }

    /**
     *  获取属性值[OWNER]
     */
    public String getOwner() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOwner();
        }
        return this.owner;
    }

    /**
     *  获取属性值[OWNER]是否修改
     */
    public boolean isOwnerDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOwnerDirty();
        }
        return this.ownerDirtyFlag;
    }

    /**
     *  重置属性值[OWNER]
     */
    public void resetOwner() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOwner();
            return;
        }

        this.ownerDirtyFlag = false;
        this.owner = null;
    }
    /**
     *  设置属性值[并行实例]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param parallelinst
     */
    public void setParallelInst(Integer parallelinst) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setParallelInst(parallelinst);
            return;
        }
        this.parallelinst = parallelinst;
        this.parallelinstDirtyFlag  = true;
    }

    /**
     *  获取属性值[并行实例]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getParallelInst() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getParallelInst();
        }
        return this.parallelinst;
    }

    /**
     *  获取属性值[并行实例]是否修改
     */
    public boolean isParallelInstDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isParallelInstDirty();
        }
        return this.parallelinstDirtyFlag;
    }

    /**
     *  重置属性值[并行实例]
     */
    public void resetParallelInst() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetParallelInst();
            return;
        }

        this.parallelinstDirtyFlag = false;
        this.parallelinst = null;
    }
    /**
     *  设置属性值[父步骤编号]
     *  @param pstepid
     */
    public void setPStepId(String pstepid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPStepId(pstepid);
            return;
        }
        if(pstepid!=null) {
            pstepid = StringHelper.trimRight(pstepid);
            if(pstepid.length()==0) {
                pstepid = null;
            }
        }
        this.pstepid = pstepid;
        this.pstepidDirtyFlag  = true;
    }

    /**
     *  获取属性值[父步骤编号]
     */
    public String getPStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPStepId();
        }
        return this.pstepid;
    }

    /**
     *  获取属性值[父步骤编号]是否修改
     */
    public boolean isPStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPStepIdDirty();
        }
        return this.pstepidDirtyFlag;
    }

    /**
     *  重置属性值[父步骤编号]
     */
    public void resetPStepId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPStepId();
            return;
        }

        this.pstepidDirtyFlag = false;
        this.pstepid = null;
    }
    /**
     *  设置属性值[父实例]
     *  @param pwfinstanceid
     */
    public void setPWFInstanceId(String pwfinstanceid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPWFInstanceId(pwfinstanceid);
            return;
        }
        if(pwfinstanceid!=null) {
            pwfinstanceid = StringHelper.trimRight(pwfinstanceid);
            if(pwfinstanceid.length()==0) {
                pwfinstanceid = null;
            }
        }
        this.pwfinstanceid = pwfinstanceid;
        this.pwfinstanceidDirtyFlag  = true;
    }

    /**
     *  获取属性值[父实例]
     */
    public String getPWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPWFInstanceId();
        }
        return this.pwfinstanceid;
    }

    /**
     *  获取属性值[父实例]是否修改
     */
    public boolean isPWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPWFInstanceIdDirty();
        }
        return this.pwfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[父实例]
     */
    public void resetPWFInstanceId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPWFInstanceId();
            return;
        }

        this.pwfinstanceidDirtyFlag = false;
        this.pwfinstanceid = null;
    }
    /**
     *  设置属性值[父实例]
     *  @param pwfinstancename
     */
    public void setPWFInstanceName(String pwfinstancename) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setPWFInstanceName(pwfinstancename);
            return;
        }
        if(pwfinstancename!=null) {
            pwfinstancename = StringHelper.trimRight(pwfinstancename);
            if(pwfinstancename.length()==0) {
                pwfinstancename = null;
            }
        }
        this.pwfinstancename = pwfinstancename;
        this.pwfinstancenameDirtyFlag  = true;
    }

    /**
     *  获取属性值[父实例]
     */
    public String getPWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPWFInstanceName();
        }
        return this.pwfinstancename;
    }

    /**
     *  获取属性值[父实例]是否修改
     */
    public boolean isPWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isPWFInstanceNameDirty();
        }
        return this.pwfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[父实例]
     */
    public void resetPWFInstanceName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetPWFInstanceName();
            return;
        }

        this.pwfinstancenameDirtyFlag = false;
        this.pwfinstancename = null;
    }
    /**
     *  设置属性值[结果信息]
     *  @param result
     */
    public void setResult(String result) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setResult(result);
            return;
        }
        if(result!=null) {
            result = StringHelper.trimRight(result);
            if(result.length()==0) {
                result = null;
            }
        }
        this.result = result;
        this.resultDirtyFlag  = true;
    }

    /**
     *  获取属性值[结果信息]
     */
    public String getResult() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getResult();
        }
        return this.result;
    }

    /**
     *  获取属性值[结果信息]是否修改
     */
    public boolean isResultDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isResultDirty();
        }
        return this.resultDirtyFlag;
    }

    /**
     *  重置属性值[结果信息]
     */
    public void resetResult() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetResult();
            return;
        }

        this.resultDirtyFlag = false;
        this.result = null;
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
     *  设置属性值[流程挂起]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param suspendflag
     */
    public void setSuspendFlag(Integer suspendflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setSuspendFlag(suspendflag);
            return;
        }
        this.suspendflag = suspendflag;
        this.suspendflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程挂起]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getSuspendFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getSuspendFlag();
        }
        return this.suspendflag;
    }

    /**
     *  获取属性值[流程挂起]是否修改
     */
    public boolean isSuspendFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isSuspendFlagDirty();
        }
        return this.suspendflagDirtyFlag;
    }

    /**
     *  重置属性值[流程挂起]
     */
    public void resetSuspendFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetSuspendFlag();
            return;
        }

        this.suspendflagDirtyFlag = false;
        this.suspendflag = null;
    }
    /**
     *  设置属性值[跟踪步骤]
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
     *  获取属性值[跟踪步骤]
     */
    public Integer getTraceStep() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getTraceStep();
        }
        return this.tracestep;
    }

    /**
     *  获取属性值[跟踪步骤]是否修改
     */
    public boolean isTraceStepDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isTraceStepDirty();
        }
        return this.tracestepDirtyFlag;
    }

    /**
     *  重置属性值[跟踪步骤]
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
     *  设置属性值[用户数据]
     *  @param userdata
     */
    public void setUserData(String userdata) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if(userdata!=null) {
            userdata = StringHelper.trimRight(userdata);
            if(userdata.length()==0) {
                userdata = null;
            }
        }
        this.userdata = userdata;
        this.userdataDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据]
     */
    public String getUserData() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    /**
     *  获取属性值[用户数据]是否修改
     */
    public boolean isUserDataDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    /**
     *  重置属性值[用户数据]
     */
    public void resetUserData() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData();
            return;
        }

        this.userdataDirtyFlag = false;
        this.userdata = null;
    }
    /**
     *  设置属性值[用户数据2]
     *  @param userdata2
     */
    public void setUserData2(String userdata2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if(userdata2!=null) {
            userdata2 = StringHelper.trimRight(userdata2);
            if(userdata2.length()==0) {
                userdata2 = null;
            }
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据2]
     */
    public String getUserData2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    /**
     *  获取属性值[用户数据2]是否修改
     */
    public boolean isUserData2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    /**
     *  重置属性值[用户数据2]
     */
    public void resetUserData2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData2();
            return;
        }

        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }
    /**
     *  设置属性值[用户数据3]
     *  @param userdata3
     */
    public void setUserData3(String userdata3) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if(userdata3!=null) {
            userdata3 = StringHelper.trimRight(userdata3);
            if(userdata3.length()==0) {
                userdata3 = null;
            }
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据3]
     */
    public String getUserData3() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    /**
     *  获取属性值[用户数据3]是否修改
     */
    public boolean isUserData3Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    /**
     *  重置属性值[用户数据3]
     */
    public void resetUserData3() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData3();
            return;
        }

        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }
    /**
     *  设置属性值[用户数据4]
     *  @param userdata4
     */
    public void setUserData4(String userdata4) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if(userdata4!=null) {
            userdata4 = StringHelper.trimRight(userdata4);
            if(userdata4.length()==0) {
                userdata4 = null;
            }
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据4]
     */
    public String getUserData4() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    /**
     *  获取属性值[用户数据4]是否修改
     */
    public boolean isUserData4Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    /**
     *  重置属性值[用户数据4]
     */
    public void resetUserData4() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserData4();
            return;
        }

        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }
    /**
     *  设置属性值[用户数据信息]
     *  @param userdatainfo
     */
    public void setUserDataInfo(String userdatainfo) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserDataInfo(userdatainfo);
            return;
        }
        if(userdatainfo!=null) {
            userdatainfo = StringHelper.trimRight(userdatainfo);
            if(userdatainfo.length()==0) {
                userdatainfo = null;
            }
        }
        this.userdatainfo = userdatainfo;
        this.userdatainfoDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户数据信息]
     */
    public String getUserDataInfo() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserDataInfo();
        }
        return this.userdatainfo;
    }

    /**
     *  获取属性值[用户数据信息]是否修改
     */
    public boolean isUserDataInfoDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserDataInfoDirty();
        }
        return this.userdatainfoDirtyFlag;
    }

    /**
     *  重置属性值[用户数据信息]
     */
    public void resetUserDataInfo() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserDataInfo();
            return;
        }

        this.userdatainfoDirtyFlag = false;
        this.userdatainfo = null;
    }
    /**
     *  设置属性值[自定义数据]
     *  @param usertag
     */
    public void setUserTag(String usertag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserTag(usertag);
            return;
        }
        if(usertag!=null) {
            usertag = StringHelper.trimRight(usertag);
            if(usertag.length()==0) {
                usertag = null;
            }
        }
        this.usertag = usertag;
        this.usertagDirtyFlag  = true;
    }

    /**
     *  获取属性值[自定义数据]
     */
    public String getUserTag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    /**
     *  获取属性值[自定义数据]是否修改
     */
    public boolean isUserTagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    /**
     *  重置属性值[自定义数据]
     */
    public void resetUserTag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserTag();
            return;
        }

        this.usertagDirtyFlag = false;
        this.usertag = null;
    }
    /**
     *  设置属性值[自定义数据]
     *  @param usertag2
     */
    public void setUserTag2(String usertag2) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setUserTag2(usertag2);
            return;
        }
        if(usertag2!=null) {
            usertag2 = StringHelper.trimRight(usertag2);
            if(usertag2.length()==0) {
                usertag2 = null;
            }
        }
        this.usertag2 = usertag2;
        this.usertag2DirtyFlag  = true;
    }

    /**
     *  获取属性值[自定义数据]
     */
    public String getUserTag2() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    /**
     *  获取属性值[自定义数据]是否修改
     */
    public boolean isUserTag2Dirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    /**
     *  重置属性值[自定义数据]
     */
    public void resetUserTag2() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }

        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }
    /**
     *  设置属性值[工作流实例标识]
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
     *  获取属性值[工作流实例标识]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[工作流实例标识]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[工作流实例标识]
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
     *  设置属性值[工作流实例名称]
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
     *  获取属性值[工作流实例名称]
     */
    public String getWFInstanceName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceName();
        }
        return this.wfinstancename;
    }

    /**
     *  获取属性值[工作流实例名称]是否修改
     */
    public boolean isWFInstanceNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceNameDirty();
        }
        return this.wfinstancenameDirtyFlag;
    }

    /**
     *  重置属性值[工作流实例名称]
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
     *  设置属性值[流程配置]
     *  @param wfmodel
     */
    public void setWFModel(String wfmodel) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFModel(wfmodel);
            return;
        }
        if(wfmodel!=null) {
            wfmodel = StringHelper.trimRight(wfmodel);
            if(wfmodel.length()==0) {
                wfmodel = null;
            }
        }
        this.wfmodel = wfmodel;
        this.wfmodelDirtyFlag  = true;
    }

    /**
     *  获取属性值[流程配置]
     */
    public String getWFModel() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    /**
     *  获取属性值[流程配置]是否修改
     */
    public boolean isWFModelDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    /**
     *  重置属性值[流程配置]
     */
    public void resetWFModel() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFModel();
            return;
        }

        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
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
    /**
     *  设置属性值[工作流名称]
     *  @param wfworkflowid
     */
    public void setWFWorkflowId(String wfworkflowid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if(wfworkflowid!=null) {
            wfworkflowid = StringHelper.trimRight(wfworkflowid);
            if(wfworkflowid.length()==0) {
                wfworkflowid = null;
            }
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流名称]
     */
    public String getWFWorkflowId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    /**
     *  获取属性值[工作流名称]是否修改
     */
    public boolean isWFWorkflowIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    /**
     *  重置属性值[工作流名称]
     */
    public void resetWFWorkflowId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }

        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }
    /**
     *  设置属性值[工作流名称]
     *  @param wfworkflowname
     */
    public void setWFWorkflowName(String wfworkflowname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if(wfworkflowname!=null) {
            wfworkflowname = StringHelper.trimRight(wfworkflowname);
            if(wfworkflowname.length()==0) {
                wfworkflowname = null;
            }
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流名称]
     */
    public String getWFWorkflowName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    /**
     *  获取属性值[工作流名称]是否修改
     */
    public boolean isWFWorkflowNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    /**
     *  重置属性值[工作流名称]
     */
    public void resetWFWorkflowName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }

        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFInstanceBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFInstanceBase et) {
        et.resetActiveStepId();
        et.resetActiveStepName();
        et.resetCancelReason();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnable();
        et.resetEndTime();
        et.resetErrorInfo();
        et.resetImportanceFlag();
        et.resetIsCancel();
        et.resetIsClose();
        et.resetIsError();
        et.resetIsFinish();
        et.resetLastAction();
        et.resetLastActorId();
        et.resetLastWFStepId();
        et.resetMemo();
        et.resetOrgId();
        et.resetOrgName();
        et.resetOwner();
        et.resetParallelInst();
        et.resetPStepId();
        et.resetPWFInstanceId();
        et.resetPWFInstanceName();
        et.resetResult();
        et.resetStartTime();
        et.resetSuspendFlag();
        et.resetTraceStep();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
        et.resetUserDataInfo();
        et.resetUserTag();
        et.resetUserTag2();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFModel();
        et.resetWFVersion();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActiveStepIdDirty()) {
            params.put(FIELD_ACTIVESTEPID,getActiveStepId());
        }
        if(!bDirtyOnly || isActiveStepNameDirty()) {
            params.put(FIELD_ACTIVESTEPNAME,getActiveStepName());
        }
        if(!bDirtyOnly || isCancelReasonDirty()) {
            params.put(FIELD_CANCELREASON,getCancelReason());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isEnableDirty()) {
            params.put(FIELD_ENABLE,getEnable());
        }
        if(!bDirtyOnly || isEndTimeDirty()) {
            params.put(FIELD_ENDTIME,getEndTime());
        }
        if(!bDirtyOnly || isErrorInfoDirty()) {
            params.put(FIELD_ERRORINFO,getErrorInfo());
        }
        if(!bDirtyOnly || isImportanceFlagDirty()) {
            params.put(FIELD_IMPORTANCEFLAG,getImportanceFlag());
        }
        if(!bDirtyOnly || isIsCancelDirty()) {
            params.put(FIELD_ISCANCEL,getIsCancel());
        }
        if(!bDirtyOnly || isIsCloseDirty()) {
            params.put(FIELD_ISCLOSE,getIsClose());
        }
        if(!bDirtyOnly || isIsErrorDirty()) {
            params.put(FIELD_ISERROR,getIsError());
        }
        if(!bDirtyOnly || isIsFinishDirty()) {
            params.put(FIELD_ISFINISH,getIsFinish());
        }
        if(!bDirtyOnly || isLastActionDirty()) {
            params.put(FIELD_LASTACTION,getLastAction());
        }
        if(!bDirtyOnly || isLastActorIdDirty()) {
            params.put(FIELD_LASTACTORID,getLastActorId());
        }
        if(!bDirtyOnly || isLastWFStepIdDirty()) {
            params.put(FIELD_LASTWFSTEPID,getLastWFStepId());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOrgIdDirty()) {
            params.put(FIELD_ORGID,getOrgId());
        }
        if(!bDirtyOnly || isOrgNameDirty()) {
            params.put(FIELD_ORGNAME,getOrgName());
        }
        if(!bDirtyOnly || isOwnerDirty()) {
            params.put(FIELD_OWNER,getOwner());
        }
        if(!bDirtyOnly || isParallelInstDirty()) {
            params.put(FIELD_PARALLELINST,getParallelInst());
        }
        if(!bDirtyOnly || isPStepIdDirty()) {
            params.put(FIELD_PSTEPID,getPStepId());
        }
        if(!bDirtyOnly || isPWFInstanceIdDirty()) {
            params.put(FIELD_PWFINSTANCEID,getPWFInstanceId());
        }
        if(!bDirtyOnly || isPWFInstanceNameDirty()) {
            params.put(FIELD_PWFINSTANCENAME,getPWFInstanceName());
        }
        if(!bDirtyOnly || isResultDirty()) {
            params.put(FIELD_RESULT,getResult());
        }
        if(!bDirtyOnly || isStartTimeDirty()) {
            params.put(FIELD_STARTTIME,getStartTime());
        }
        if(!bDirtyOnly || isSuspendFlagDirty()) {
            params.put(FIELD_SUSPENDFLAG,getSuspendFlag());
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
        if(!bDirtyOnly || isUserDataDirty()) {
            params.put(FIELD_USERDATA,getUserData());
        }
        if(!bDirtyOnly || isUserData2Dirty()) {
            params.put(FIELD_USERDATA2,getUserData2());
        }
        if(!bDirtyOnly || isUserData3Dirty()) {
            params.put(FIELD_USERDATA3,getUserData3());
        }
        if(!bDirtyOnly || isUserData4Dirty()) {
            params.put(FIELD_USERDATA4,getUserData4());
        }
        if(!bDirtyOnly || isUserDataInfoDirty()) {
            params.put(FIELD_USERDATAINFO,getUserDataInfo());
        }
        if(!bDirtyOnly || isUserTagDirty()) {
            params.put(FIELD_USERTAG,getUserTag());
        }
        if(!bDirtyOnly || isUserTag2Dirty()) {
            params.put(FIELD_USERTAG2,getUserTag2());
        }
        if(!bDirtyOnly || isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID,getWFInstanceId());
        }
        if(!bDirtyOnly || isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME,getWFInstanceName());
        }
        if(!bDirtyOnly || isWFModelDirty()) {
            params.put(FIELD_WFMODEL,getWFModel());
        }
        if(!bDirtyOnly || isWFVersionDirty()) {
            params.put(FIELD_WFVERSION,getWFVersion());
        }
        if(!bDirtyOnly || isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID,getWFWorkflowId());
        }
        if(!bDirtyOnly || isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME,getWFWorkflowName());
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

        return  WFInstanceBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFInstanceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.getActiveStepId();
        case INDEX_ACTIVESTEPNAME:
            return et.getActiveStepName();
        case INDEX_CANCELREASON:
            return et.getCancelReason();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_ENABLE:
            return et.getEnable();
        case INDEX_ENDTIME:
            return et.getEndTime();
        case INDEX_ERRORINFO:
            return et.getErrorInfo();
        case INDEX_IMPORTANCEFLAG:
            return et.getImportanceFlag();
        case INDEX_ISCANCEL:
            return et.getIsCancel();
        case INDEX_ISCLOSE:
            return et.getIsClose();
        case INDEX_ISERROR:
            return et.getIsError();
        case INDEX_ISFINISH:
            return et.getIsFinish();
        case INDEX_LASTACTION:
            return et.getLastAction();
        case INDEX_LASTACTORID:
            return et.getLastActorId();
        case INDEX_LASTWFSTEPID:
            return et.getLastWFStepId();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_ORGID:
            return et.getOrgId();
        case INDEX_ORGNAME:
            return et.getOrgName();
        case INDEX_OWNER:
            return et.getOwner();
        case INDEX_PARALLELINST:
            return et.getParallelInst();
        case INDEX_PSTEPID:
            return et.getPStepId();
        case INDEX_PWFINSTANCEID:
            return et.getPWFInstanceId();
        case INDEX_PWFINSTANCENAME:
            return et.getPWFInstanceName();
        case INDEX_RESULT:
            return et.getResult();
        case INDEX_STARTTIME:
            return et.getStartTime();
        case INDEX_SUSPENDFLAG:
            return et.getSuspendFlag();
        case INDEX_TRACESTEP:
            return et.getTraceStep();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_USERDATA:
            return et.getUserData();
        case INDEX_USERDATA2:
            return et.getUserData2();
        case INDEX_USERDATA3:
            return et.getUserData3();
        case INDEX_USERDATA4:
            return et.getUserData4();
        case INDEX_USERDATAINFO:
            return et.getUserDataInfo();
        case INDEX_USERTAG:
            return et.getUserTag();
        case INDEX_USERTAG2:
            return et.getUserTag2();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName();
        case INDEX_WFMODEL:
            return et.getWFModel();
        case INDEX_WFVERSION:
            return et.getWFVersion();
        case INDEX_WFWORKFLOWID:
            return et.getWFWorkflowId();
        case INDEX_WFWORKFLOWNAME:
            return et.getWFWorkflowName();
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

        WFInstanceBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFInstanceBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTIVESTEPID:
            et.setActiveStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTIVESTEPNAME:
            et.setActiveStepName(DataObject.getStringValue(obj));
            return ;
        case INDEX_CANCELREASON:
            et.setCancelReason(DataObject.getStringValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_ENABLE:
            et.setEnable(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ENDTIME:
            et.setEndTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_ERRORINFO:
            et.setErrorInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_IMPORTANCEFLAG:
            et.setImportanceFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISCANCEL:
            et.setIsCancel(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISCLOSE:
            et.setIsClose(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISERROR:
            et.setIsError(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISFINISH:
            et.setIsFinish(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_LASTACTION:
            et.setLastAction(DataObject.getStringValue(obj));
            return ;
        case INDEX_LASTACTORID:
            et.setLastActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_LASTWFSTEPID:
            et.setLastWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGID:
            et.setOrgId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORGNAME:
            et.setOrgName(DataObject.getStringValue(obj));
            return ;
        case INDEX_OWNER:
            et.setOwner(DataObject.getStringValue(obj));
            return ;
        case INDEX_PARALLELINST:
            et.setParallelInst(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_PSTEPID:
            et.setPStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PWFINSTANCEID:
            et.setPWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_PWFINSTANCENAME:
            et.setPWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_RESULT:
            et.setResult(DataObject.getStringValue(obj));
            return ;
        case INDEX_STARTTIME:
            et.setStartTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_SUSPENDFLAG:
            et.setSuspendFlag(DataObject.getIntegerValue(obj));
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
        case INDEX_USERDATA:
            et.setUserData(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA2:
            et.setUserData2(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA3:
            et.setUserData3(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATA4:
            et.setUserData4(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERDATAINFO:
            et.setUserDataInfo(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERTAG:
            et.setUserTag(DataObject.getStringValue(obj));
            return ;
        case INDEX_USERTAG2:
            et.setUserTag2(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCEID:
            et.setWFInstanceId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFINSTANCENAME:
            et.setWFInstanceName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFMODEL:
            et.setWFModel(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFVERSION:
            et.setWFVersion(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_WFWORKFLOWID:
            et.setWFWorkflowId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFWORKFLOWNAME:
            et.setWFWorkflowName(DataObject.getStringValue(obj));
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

        return  WFInstanceBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFInstanceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.getActiveStepId()==null;
        case INDEX_ACTIVESTEPNAME:
            return et.getActiveStepName()==null;
        case INDEX_CANCELREASON:
            return et.getCancelReason()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_ENABLE:
            return et.getEnable()==null;
        case INDEX_ENDTIME:
            return et.getEndTime()==null;
        case INDEX_ERRORINFO:
            return et.getErrorInfo()==null;
        case INDEX_IMPORTANCEFLAG:
            return et.getImportanceFlag()==null;
        case INDEX_ISCANCEL:
            return et.getIsCancel()==null;
        case INDEX_ISCLOSE:
            return et.getIsClose()==null;
        case INDEX_ISERROR:
            return et.getIsError()==null;
        case INDEX_ISFINISH:
            return et.getIsFinish()==null;
        case INDEX_LASTACTION:
            return et.getLastAction()==null;
        case INDEX_LASTACTORID:
            return et.getLastActorId()==null;
        case INDEX_LASTWFSTEPID:
            return et.getLastWFStepId()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_ORGID:
            return et.getOrgId()==null;
        case INDEX_ORGNAME:
            return et.getOrgName()==null;
        case INDEX_OWNER:
            return et.getOwner()==null;
        case INDEX_PARALLELINST:
            return et.getParallelInst()==null;
        case INDEX_PSTEPID:
            return et.getPStepId()==null;
        case INDEX_PWFINSTANCEID:
            return et.getPWFInstanceId()==null;
        case INDEX_PWFINSTANCENAME:
            return et.getPWFInstanceName()==null;
        case INDEX_RESULT:
            return et.getResult()==null;
        case INDEX_STARTTIME:
            return et.getStartTime()==null;
        case INDEX_SUSPENDFLAG:
            return et.getSuspendFlag()==null;
        case INDEX_TRACESTEP:
            return et.getTraceStep()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_USERDATA:
            return et.getUserData()==null;
        case INDEX_USERDATA2:
            return et.getUserData2()==null;
        case INDEX_USERDATA3:
            return et.getUserData3()==null;
        case INDEX_USERDATA4:
            return et.getUserData4()==null;
        case INDEX_USERDATAINFO:
            return et.getUserDataInfo()==null;
        case INDEX_USERTAG:
            return et.getUserTag()==null;
        case INDEX_USERTAG2:
            return et.getUserTag2()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFINSTANCENAME:
            return et.getWFInstanceName()==null;
        case INDEX_WFMODEL:
            return et.getWFModel()==null;
        case INDEX_WFVERSION:
            return et.getWFVersion()==null;
        case INDEX_WFWORKFLOWID:
            return et.getWFWorkflowId()==null;
        case INDEX_WFWORKFLOWNAME:
            return et.getWFWorkflowName()==null;
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
        return  WFInstanceBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFInstanceBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTIVESTEPID:
            return et.isActiveStepIdDirty();
        case INDEX_ACTIVESTEPNAME:
            return et.isActiveStepNameDirty();
        case INDEX_CANCELREASON:
            return et.isCancelReasonDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_ENABLE:
            return et.isEnableDirty();
        case INDEX_ENDTIME:
            return et.isEndTimeDirty();
        case INDEX_ERRORINFO:
            return et.isErrorInfoDirty();
        case INDEX_IMPORTANCEFLAG:
            return et.isImportanceFlagDirty();
        case INDEX_ISCANCEL:
            return et.isIsCancelDirty();
        case INDEX_ISCLOSE:
            return et.isIsCloseDirty();
        case INDEX_ISERROR:
            return et.isIsErrorDirty();
        case INDEX_ISFINISH:
            return et.isIsFinishDirty();
        case INDEX_LASTACTION:
            return et.isLastActionDirty();
        case INDEX_LASTACTORID:
            return et.isLastActorIdDirty();
        case INDEX_LASTWFSTEPID:
            return et.isLastWFStepIdDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_ORGID:
            return et.isOrgIdDirty();
        case INDEX_ORGNAME:
            return et.isOrgNameDirty();
        case INDEX_OWNER:
            return et.isOwnerDirty();
        case INDEX_PARALLELINST:
            return et.isParallelInstDirty();
        case INDEX_PSTEPID:
            return et.isPStepIdDirty();
        case INDEX_PWFINSTANCEID:
            return et.isPWFInstanceIdDirty();
        case INDEX_PWFINSTANCENAME:
            return et.isPWFInstanceNameDirty();
        case INDEX_RESULT:
            return et.isResultDirty();
        case INDEX_STARTTIME:
            return et.isStartTimeDirty();
        case INDEX_SUSPENDFLAG:
            return et.isSuspendFlagDirty();
        case INDEX_TRACESTEP:
            return et.isTraceStepDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_USERDATA:
            return et.isUserDataDirty();
        case INDEX_USERDATA2:
            return et.isUserData2Dirty();
        case INDEX_USERDATA3:
            return et.isUserData3Dirty();
        case INDEX_USERDATA4:
            return et.isUserData4Dirty();
        case INDEX_USERDATAINFO:
            return et.isUserDataInfoDirty();
        case INDEX_USERTAG:
            return et.isUserTagDirty();
        case INDEX_USERTAG2:
            return et.isUserTag2Dirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFINSTANCENAME:
            return et.isWFInstanceNameDirty();
        case INDEX_WFMODEL:
            return et.isWFModelDirty();
        case INDEX_WFVERSION:
            return et.isWFVersionDirty();
        case INDEX_WFWORKFLOWID:
            return et.isWFWorkflowIdDirty();
        case INDEX_WFWORKFLOWNAME:
            return et.isWFWorkflowNameDirty();
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
    private static  void fillJSONObject(WFInstanceBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActiveStepId()!=null) {
            JSONObjectHelper.put(json,"activestepid",getJSONValue(et.getActiveStepId()),false);
        }
        if(bIncEmpty||et.getActiveStepName()!=null) {
            JSONObjectHelper.put(json,"activestepname",getJSONValue(et.getActiveStepName()),false);
        }
        if(bIncEmpty||et.getCancelReason()!=null) {
            JSONObjectHelper.put(json,"cancelreason",getJSONValue(et.getCancelReason()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            JSONObjectHelper.put(json,"enable",getJSONValue(et.getEnable()),false);
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            JSONObjectHelper.put(json,"endtime",getJSONValue(et.getEndTime()),false);
        }
        if(bIncEmpty||et.getErrorInfo()!=null) {
            JSONObjectHelper.put(json,"errorinfo",getJSONValue(et.getErrorInfo()),false);
        }
        if(bIncEmpty||et.getImportanceFlag()!=null) {
            JSONObjectHelper.put(json,"importanceflag",getJSONValue(et.getImportanceFlag()),false);
        }
        if(bIncEmpty||et.getIsCancel()!=null) {
            JSONObjectHelper.put(json,"iscancel",getJSONValue(et.getIsCancel()),false);
        }
        if(bIncEmpty||et.getIsClose()!=null) {
            JSONObjectHelper.put(json,"isclose",getJSONValue(et.getIsClose()),false);
        }
        if(bIncEmpty||et.getIsError()!=null) {
            JSONObjectHelper.put(json,"iserror",getJSONValue(et.getIsError()),false);
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            JSONObjectHelper.put(json,"isfinish",getJSONValue(et.getIsFinish()),false);
        }
        if(bIncEmpty||et.getLastAction()!=null) {
            JSONObjectHelper.put(json,"lastaction",getJSONValue(et.getLastAction()),false);
        }
        if(bIncEmpty||et.getLastActorId()!=null) {
            JSONObjectHelper.put(json,"lastactorid",getJSONValue(et.getLastActorId()),false);
        }
        if(bIncEmpty||et.getLastWFStepId()!=null) {
            JSONObjectHelper.put(json,"lastwfstepid",getJSONValue(et.getLastWFStepId()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOrgId()!=null) {
            JSONObjectHelper.put(json,"orgid",getJSONValue(et.getOrgId()),false);
        }
        if(bIncEmpty||et.getOrgName()!=null) {
            JSONObjectHelper.put(json,"orgname",getJSONValue(et.getOrgName()),false);
        }
        if(bIncEmpty||et.getOwner()!=null) {
            JSONObjectHelper.put(json,"owner",getJSONValue(et.getOwner()),false);
        }
        if(bIncEmpty||et.getParallelInst()!=null) {
            JSONObjectHelper.put(json,"parallelinst",getJSONValue(et.getParallelInst()),false);
        }
        if(bIncEmpty||et.getPStepId()!=null) {
            JSONObjectHelper.put(json,"pstepid",getJSONValue(et.getPStepId()),false);
        }
        if(bIncEmpty||et.getPWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"pwfinstanceid",getJSONValue(et.getPWFInstanceId()),false);
        }
        if(bIncEmpty||et.getPWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"pwfinstancename",getJSONValue(et.getPWFInstanceName()),false);
        }
        if(bIncEmpty||et.getResult()!=null) {
            JSONObjectHelper.put(json,"result",getJSONValue(et.getResult()),false);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            JSONObjectHelper.put(json,"starttime",getJSONValue(et.getStartTime()),false);
        }
        if(bIncEmpty||et.getSuspendFlag()!=null) {
            JSONObjectHelper.put(json,"suspendflag",getJSONValue(et.getSuspendFlag()),false);
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
        if(bIncEmpty||et.getUserData()!=null) {
            JSONObjectHelper.put(json,"userdata",getJSONValue(et.getUserData()),false);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            JSONObjectHelper.put(json,"userdata2",getJSONValue(et.getUserData2()),false);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            JSONObjectHelper.put(json,"userdata3",getJSONValue(et.getUserData3()),false);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            JSONObjectHelper.put(json,"userdata4",getJSONValue(et.getUserData4()),false);
        }
        if(bIncEmpty||et.getUserDataInfo()!=null) {
            JSONObjectHelper.put(json,"userdatainfo",getJSONValue(et.getUserDataInfo()),false);
        }
        if(bIncEmpty||et.getUserTag()!=null) {
            JSONObjectHelper.put(json,"usertag",getJSONValue(et.getUserTag()),false);
        }
        if(bIncEmpty||et.getUserTag2()!=null) {
            JSONObjectHelper.put(json,"usertag2",getJSONValue(et.getUserTag2()),false);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            JSONObjectHelper.put(json,"wfinstanceid",getJSONValue(et.getWFInstanceId()),false);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            JSONObjectHelper.put(json,"wfinstancename",getJSONValue(et.getWFInstanceName()),false);
        }
        if(bIncEmpty||et.getWFModel()!=null) {
            JSONObjectHelper.put(json,"wfmodel",getJSONValue(et.getWFModel()),false);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            JSONObjectHelper.put(json,"wfversion",getJSONValue(et.getWFVersion()),false);
        }
        if(bIncEmpty||et.getWFWorkflowId()!=null) {
            JSONObjectHelper.put(json,"wfworkflowid",getJSONValue(et.getWFWorkflowId()),false);
        }
        if(bIncEmpty||et.getWFWorkflowName()!=null) {
            JSONObjectHelper.put(json,"wfworkflowname",getJSONValue(et.getWFWorkflowName()),false);
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
    private static void fillXmlNode(WFInstanceBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActiveStepId()!=null) {
            Object obj = et.getActiveStepId();
            node.setAttribute("ACTIVESTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActiveStepName()!=null) {
            Object obj = et.getActiveStepName();
            node.setAttribute("ACTIVESTEPNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCancelReason()!=null) {
            Object obj = et.getCancelReason();
            node.setAttribute("CANCELREASON",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getEnable()!=null) {
            Object obj = et.getEnable();
            node.setAttribute("ENABLE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getEndTime()!=null) {
            Object obj = et.getEndTime();
            node.setAttribute("ENDTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getErrorInfo()!=null) {
            Object obj = et.getErrorInfo();
            node.setAttribute("ERRORINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getImportanceFlag()!=null) {
            Object obj = et.getImportanceFlag();
            node.setAttribute("IMPORTANCEFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsCancel()!=null) {
            Object obj = et.getIsCancel();
            node.setAttribute("ISCANCEL",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsClose()!=null) {
            Object obj = et.getIsClose();
            node.setAttribute("ISCLOSE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsError()!=null) {
            Object obj = et.getIsError();
            node.setAttribute("ISERROR",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            Object obj = et.getIsFinish();
            node.setAttribute("ISFINISH",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getLastAction()!=null) {
            Object obj = et.getLastAction();
            node.setAttribute("LASTACTION",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLastActorId()!=null) {
            Object obj = et.getLastActorId();
            node.setAttribute("LASTACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getLastWFStepId()!=null) {
            Object obj = et.getLastWFStepId();
            node.setAttribute("LASTWFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgId()!=null) {
            Object obj = et.getOrgId();
            node.setAttribute("ORGID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOrgName()!=null) {
            Object obj = et.getOrgName();
            node.setAttribute("ORGNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOwner()!=null) {
            Object obj = et.getOwner();
            node.setAttribute("OWNER",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getParallelInst()!=null) {
            Object obj = et.getParallelInst();
            node.setAttribute("PARALLELINST",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getPStepId()!=null) {
            Object obj = et.getPStepId();
            node.setAttribute("PSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPWFInstanceId()!=null) {
            Object obj = et.getPWFInstanceId();
            node.setAttribute("PWFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getPWFInstanceName()!=null) {
            Object obj = et.getPWFInstanceName();
            node.setAttribute("PWFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getResult()!=null) {
            Object obj = et.getResult();
            node.setAttribute("RESULT",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getStartTime()!=null) {
            Object obj = et.getStartTime();
            node.setAttribute("STARTTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getSuspendFlag()!=null) {
            Object obj = et.getSuspendFlag();
            node.setAttribute("SUSPENDFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
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
        if(bIncEmpty||et.getUserData()!=null) {
            Object obj = et.getUserData();
            node.setAttribute("USERDATA",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData2()!=null) {
            Object obj = et.getUserData2();
            node.setAttribute("USERDATA2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData3()!=null) {
            Object obj = et.getUserData3();
            node.setAttribute("USERDATA3",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserData4()!=null) {
            Object obj = et.getUserData4();
            node.setAttribute("USERDATA4",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserDataInfo()!=null) {
            Object obj = et.getUserDataInfo();
            node.setAttribute("USERDATAINFO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserTag()!=null) {
            Object obj = et.getUserTag();
            node.setAttribute("USERTAG",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getUserTag2()!=null) {
            Object obj = et.getUserTag2();
            node.setAttribute("USERTAG2",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceId()!=null) {
            Object obj = et.getWFInstanceId();
            node.setAttribute("WFINSTANCEID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFInstanceName()!=null) {
            Object obj = et.getWFInstanceName();
            node.setAttribute("WFINSTANCENAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFModel()!=null) {
            Object obj = et.getWFModel();
            node.setAttribute("WFMODEL",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFVersion()!=null) {
            Object obj = et.getWFVersion();
            node.setAttribute("WFVERSION",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getWFWorkflowId()!=null) {
            Object obj = et.getWFWorkflowId();
            node.setAttribute("WFWORKFLOWID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFWorkflowName()!=null) {
            Object obj = et.getWFWorkflowName();
            node.setAttribute("WFWORKFLOWNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFInstanceBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFInstanceBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActiveStepIdDirty() && (bIncEmpty||et.getActiveStepId()!=null)) {
            dst.set(FIELD_ACTIVESTEPID,et.getActiveStepId());
        }
        if(et.isActiveStepNameDirty() && (bIncEmpty||et.getActiveStepName()!=null)) {
            dst.set(FIELD_ACTIVESTEPNAME,et.getActiveStepName());
        }
        if(et.isCancelReasonDirty() && (bIncEmpty||et.getCancelReason()!=null)) {
            dst.set(FIELD_CANCELREASON,et.getCancelReason());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isEnableDirty() && (bIncEmpty||et.getEnable()!=null)) {
            dst.set(FIELD_ENABLE,et.getEnable());
        }
        if(et.isEndTimeDirty() && (bIncEmpty||et.getEndTime()!=null)) {
            dst.set(FIELD_ENDTIME,et.getEndTime());
        }
        if(et.isErrorInfoDirty() && (bIncEmpty||et.getErrorInfo()!=null)) {
            dst.set(FIELD_ERRORINFO,et.getErrorInfo());
        }
        if(et.isImportanceFlagDirty() && (bIncEmpty||et.getImportanceFlag()!=null)) {
            dst.set(FIELD_IMPORTANCEFLAG,et.getImportanceFlag());
        }
        if(et.isIsCancelDirty() && (bIncEmpty||et.getIsCancel()!=null)) {
            dst.set(FIELD_ISCANCEL,et.getIsCancel());
        }
        if(et.isIsCloseDirty() && (bIncEmpty||et.getIsClose()!=null)) {
            dst.set(FIELD_ISCLOSE,et.getIsClose());
        }
        if(et.isIsErrorDirty() && (bIncEmpty||et.getIsError()!=null)) {
            dst.set(FIELD_ISERROR,et.getIsError());
        }
        if(et.isIsFinishDirty() && (bIncEmpty||et.getIsFinish()!=null)) {
            dst.set(FIELD_ISFINISH,et.getIsFinish());
        }
        if(et.isLastActionDirty() && (bIncEmpty||et.getLastAction()!=null)) {
            dst.set(FIELD_LASTACTION,et.getLastAction());
        }
        if(et.isLastActorIdDirty() && (bIncEmpty||et.getLastActorId()!=null)) {
            dst.set(FIELD_LASTACTORID,et.getLastActorId());
        }
        if(et.isLastWFStepIdDirty() && (bIncEmpty||et.getLastWFStepId()!=null)) {
            dst.set(FIELD_LASTWFSTEPID,et.getLastWFStepId());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOrgIdDirty() && (bIncEmpty||et.getOrgId()!=null)) {
            dst.set(FIELD_ORGID,et.getOrgId());
        }
        if(et.isOrgNameDirty() && (bIncEmpty||et.getOrgName()!=null)) {
            dst.set(FIELD_ORGNAME,et.getOrgName());
        }
        if(et.isOwnerDirty() && (bIncEmpty||et.getOwner()!=null)) {
            dst.set(FIELD_OWNER,et.getOwner());
        }
        if(et.isParallelInstDirty() && (bIncEmpty||et.getParallelInst()!=null)) {
            dst.set(FIELD_PARALLELINST,et.getParallelInst());
        }
        if(et.isPStepIdDirty() && (bIncEmpty||et.getPStepId()!=null)) {
            dst.set(FIELD_PSTEPID,et.getPStepId());
        }
        if(et.isPWFInstanceIdDirty() && (bIncEmpty||et.getPWFInstanceId()!=null)) {
            dst.set(FIELD_PWFINSTANCEID,et.getPWFInstanceId());
        }
        if(et.isPWFInstanceNameDirty() && (bIncEmpty||et.getPWFInstanceName()!=null)) {
            dst.set(FIELD_PWFINSTANCENAME,et.getPWFInstanceName());
        }
        if(et.isResultDirty() && (bIncEmpty||et.getResult()!=null)) {
            dst.set(FIELD_RESULT,et.getResult());
        }
        if(et.isStartTimeDirty() && (bIncEmpty||et.getStartTime()!=null)) {
            dst.set(FIELD_STARTTIME,et.getStartTime());
        }
        if(et.isSuspendFlagDirty() && (bIncEmpty||et.getSuspendFlag()!=null)) {
            dst.set(FIELD_SUSPENDFLAG,et.getSuspendFlag());
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
        if(et.isUserDataDirty() && (bIncEmpty||et.getUserData()!=null)) {
            dst.set(FIELD_USERDATA,et.getUserData());
        }
        if(et.isUserData2Dirty() && (bIncEmpty||et.getUserData2()!=null)) {
            dst.set(FIELD_USERDATA2,et.getUserData2());
        }
        if(et.isUserData3Dirty() && (bIncEmpty||et.getUserData3()!=null)) {
            dst.set(FIELD_USERDATA3,et.getUserData3());
        }
        if(et.isUserData4Dirty() && (bIncEmpty||et.getUserData4()!=null)) {
            dst.set(FIELD_USERDATA4,et.getUserData4());
        }
        if(et.isUserDataInfoDirty() && (bIncEmpty||et.getUserDataInfo()!=null)) {
            dst.set(FIELD_USERDATAINFO,et.getUserDataInfo());
        }
        if(et.isUserTagDirty() && (bIncEmpty||et.getUserTag()!=null)) {
            dst.set(FIELD_USERTAG,et.getUserTag());
        }
        if(et.isUserTag2Dirty() && (bIncEmpty||et.getUserTag2()!=null)) {
            dst.set(FIELD_USERTAG2,et.getUserTag2());
        }
        if(et.isWFInstanceIdDirty() && (bIncEmpty||et.getWFInstanceId()!=null)) {
            dst.set(FIELD_WFINSTANCEID,et.getWFInstanceId());
        }
        if(et.isWFInstanceNameDirty() && (bIncEmpty||et.getWFInstanceName()!=null)) {
            dst.set(FIELD_WFINSTANCENAME,et.getWFInstanceName());
        }
        if(et.isWFModelDirty() && (bIncEmpty||et.getWFModel()!=null)) {
            dst.set(FIELD_WFMODEL,et.getWFModel());
        }
        if(et.isWFVersionDirty() && (bIncEmpty||et.getWFVersion()!=null)) {
            dst.set(FIELD_WFVERSION,et.getWFVersion());
        }
        if(et.isWFWorkflowIdDirty() && (bIncEmpty||et.getWFWorkflowId()!=null)) {
            dst.set(FIELD_WFWORKFLOWID,et.getWFWorkflowId());
        }
        if(et.isWFWorkflowNameDirty() && (bIncEmpty||et.getWFWorkflowName()!=null)) {
            dst.set(FIELD_WFWORKFLOWNAME,et.getWFWorkflowName());
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
        return  WFInstanceBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFInstanceBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTIVESTEPID:
            et.resetActiveStepId();
            return true;
        case INDEX_ACTIVESTEPNAME:
            et.resetActiveStepName();
            return true;
        case INDEX_CANCELREASON:
            et.resetCancelReason();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_ENABLE:
            et.resetEnable();
            return true;
        case INDEX_ENDTIME:
            et.resetEndTime();
            return true;
        case INDEX_ERRORINFO:
            et.resetErrorInfo();
            return true;
        case INDEX_IMPORTANCEFLAG:
            et.resetImportanceFlag();
            return true;
        case INDEX_ISCANCEL:
            et.resetIsCancel();
            return true;
        case INDEX_ISCLOSE:
            et.resetIsClose();
            return true;
        case INDEX_ISERROR:
            et.resetIsError();
            return true;
        case INDEX_ISFINISH:
            et.resetIsFinish();
            return true;
        case INDEX_LASTACTION:
            et.resetLastAction();
            return true;
        case INDEX_LASTACTORID:
            et.resetLastActorId();
            return true;
        case INDEX_LASTWFSTEPID:
            et.resetLastWFStepId();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_ORGID:
            et.resetOrgId();
            return true;
        case INDEX_ORGNAME:
            et.resetOrgName();
            return true;
        case INDEX_OWNER:
            et.resetOwner();
            return true;
        case INDEX_PARALLELINST:
            et.resetParallelInst();
            return true;
        case INDEX_PSTEPID:
            et.resetPStepId();
            return true;
        case INDEX_PWFINSTANCEID:
            et.resetPWFInstanceId();
            return true;
        case INDEX_PWFINSTANCENAME:
            et.resetPWFInstanceName();
            return true;
        case INDEX_RESULT:
            et.resetResult();
            return true;
        case INDEX_STARTTIME:
            et.resetStartTime();
            return true;
        case INDEX_SUSPENDFLAG:
            et.resetSuspendFlag();
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
        case INDEX_USERDATA:
            et.resetUserData();
            return true;
        case INDEX_USERDATA2:
            et.resetUserData2();
            return true;
        case INDEX_USERDATA3:
            et.resetUserData3();
            return true;
        case INDEX_USERDATA4:
            et.resetUserData4();
            return true;
        case INDEX_USERDATAINFO:
            et.resetUserDataInfo();
            return true;
        case INDEX_USERTAG:
            et.resetUserTag();
            return true;
        case INDEX_USERTAG2:
            et.resetUserTag2();
            return true;
        case INDEX_WFINSTANCEID:
            et.resetWFInstanceId();
            return true;
        case INDEX_WFINSTANCENAME:
            et.resetWFInstanceName();
            return true;
        case INDEX_WFMODEL:
            et.resetWFModel();
            return true;
        case INDEX_WFVERSION:
            et.resetWFVersion();
            return true;
        case INDEX_WFWORKFLOWID:
            et.resetWFWorkflowId();
            return true;
        case INDEX_WFWORKFLOWNAME:
            et.resetWFWorkflowName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objOrgLock = new Integer(1);
    private net.ibizsys.psrt.srv.common.entity.Org org = null;
    /**
    * 获取父数据 组织机构
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.common.entity.Org getOrg() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOrg();
        }

        if(this.getOrgId()==null)
            return null;
        synchronized(this.objOrgLock) {
            if(this.org!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getOrgId(),org.getOrgId())!=0) {
                    this.org = null;
                }
            }


            if(this.org==null) {
                net.ibizsys.psrt.srv.common.entity.Org org = new net.ibizsys.psrt.srv.common.entity.Org();
                org.setOrgId(this.getOrgId());
                net.ibizsys.psrt.srv.common.service.OrgService service = (net.ibizsys.psrt.srv.common.service.OrgService)ServiceGlobal.getService(net.ibizsys.psrt.srv.common.service.OrgService.class,this.getSessionFactory());
                service.autoGet(org);
                this.org = org;
            }
            return this.org;
        }
    }

    private Integer objPWFInstanceLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFInstance pwfinstance = null;
    /**
    * 获取父数据 工作流实例
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFInstance getPWFInstance() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getPWFInstance();
        }

        if(this.getPWFInstanceId()==null)
            return null;
        synchronized(this.objPWFInstanceLock) {
            if(this.pwfinstance!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getPWFInstanceId(),pwfinstance.getWFInstanceId())!=0) {
                    this.pwfinstance = null;
                }
            }


            if(this.pwfinstance==null) {
                net.ibizsys.psrt.srv.wf.entity.WFInstance pwfinstance = new net.ibizsys.psrt.srv.wf.entity.WFInstance();
                pwfinstance.setWFInstanceId(this.getPWFInstanceId());
                net.ibizsys.psrt.srv.wf.service.WFInstanceService service = (net.ibizsys.psrt.srv.wf.service.WFInstanceService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFInstanceService.class,this.getSessionFactory());
                service.autoGet(pwfinstance);
                this.pwfinstance = pwfinstance;
            }
            return this.pwfinstance;
        }
    }

    private Integer objWFWorkflowLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFWorkflow wfworkflow = null;
    /**
    * 获取父数据 工作流配置
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFWorkflow getWFWorkflow() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFWorkflow();
        }

        if(this.getWFWorkflowId()==null)
            return null;
        synchronized(this.objWFWorkflowLock) {
            if(this.wfworkflow!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFWorkflowId(),wfworkflow.getWFWorkflowId())!=0) {
                    this.wfworkflow = null;
                }
            }


            if(this.wfworkflow==null) {
                net.ibizsys.psrt.srv.wf.entity.WFWorkflow wfworkflow = new net.ibizsys.psrt.srv.wf.entity.WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWorkflowId());
                net.ibizsys.psrt.srv.wf.service.WFWorkflowService service = (net.ibizsys.psrt.srv.wf.service.WFWorkflowService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFWorkflowService.class,this.getSessionFactory());
                service.autoGet(wfworkflow);
                this.wfworkflow = wfworkflow;
            }
            return this.wfworkflow;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFInstanceBase getProxyEntity() {
        return this.proxyWFInstanceBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFInstanceBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFInstanceBase) {
            this.proxyWFInstanceBase = (WFInstanceBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFInstanceService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}