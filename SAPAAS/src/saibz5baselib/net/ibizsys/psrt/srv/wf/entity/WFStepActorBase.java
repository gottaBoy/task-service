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
 * 实体[WFStepActor] 数据对象基类
 */
public abstract class WFStepActorBase extends net.ibizsys.paas.entity.EntityBase implements Serializable {

    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepActorBase.class);
    /**
     * 属性[工作流用户]
     */
    public final static String FIELD_ACTORID = "ACTORID";
    /**
     * 属性[用户类型]
     */
    public final static String FIELD_ACTORTYPE = "ACTORTYPE";
    /**
     * 属性[建立时间]
     */
    public final static String FIELD_CREATEDATE = "CREATEDATE";
    /**
     * 属性[建立人]
     */
    public final static String FIELD_CREATEMAN = "CREATEMAN";
    /**
     * 属性[完成时间]
     */
    public final static String FIELD_FINISHDATE = "FINISHDATE";
    /**
     * 属性[查看时间]
     */
    public final static String FIELD_FIRSTREADTIME = "FIRSTREADTIME";
    /**
     * 属性[允许交互操作]
     */
    public final static String FIELD_IAACTIONS = "IAACTIONS";
    /**
     * 属性[是否完成]
     */
    public final static String FIELD_ISFINISH = "ISFINISH";
    /**
     * 属性[是否只读]
     */
    public final static String FIELD_ISREADONLY = "ISREADONLY";
    /**
     * 属性[备注]
     */
    public final static String FIELD_MEMO = "MEMO";
    /**
     * 属性[源流程用户]
     */
    public final static String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
    /**
     * 属性[源流程用户]
     */
    public final static String FIELD_ORIGINALWFUSERNAME = "ORIGINALWFUSERNAME";
    /**
     * 属性[是否已读]
     */
    public final static String FIELD_READFLAG = "READFLAG";
    /**
     * 属性[督促次数]
     */
    public final static String FIELD_REMINDERCOUNT = "REMINDERCOUNT";
    /**
     * 属性[角色用户]
     */
    public final static String FIELD_ROLEID = "ROLEID";
    /**
     * 属性[更新时间]
     */
    public final static String FIELD_UPDATEDATE = "UPDATEDATE";
    /**
     * 属性[更新人]
     */
    public final static String FIELD_UPDATEMAN = "UPDATEMAN";
    /**
     * 属性[流程实例]
     */
    public final static String FIELD_WFINSTANCEID = "WFINSTANCEID";
    /**
     * 属性[工作流步骤操作者标识]
     */
    public final static String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    /**
     * 属性[工作流步骤操作者名称]
     */
    public final static String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    /**
     * 属性[步骤角色_步骤]
     */
    public final static String FIELD_WFSTEPID = "WFSTEPID";
    /**
     * 属性[流程步骤]
     */
    public final static String FIELD_WFSTEPNAME = "WFSTEPNAME";

    private final static int INDEX_ACTORID = 0;
    private final static int INDEX_ACTORTYPE = 1;
    private final static int INDEX_CREATEDATE = 2;
    private final static int INDEX_CREATEMAN = 3;
    private final static int INDEX_FINISHDATE = 4;
    private final static int INDEX_FIRSTREADTIME = 5;
    private final static int INDEX_IAACTIONS = 6;
    private final static int INDEX_ISFINISH = 7;
    private final static int INDEX_ISREADONLY = 8;
    private final static int INDEX_MEMO = 9;
    private final static int INDEX_ORIGINALWFUSERID = 10;
    private final static int INDEX_ORIGINALWFUSERNAME = 11;
    private final static int INDEX_READFLAG = 12;
    private final static int INDEX_REMINDERCOUNT = 13;
    private final static int INDEX_ROLEID = 14;
    private final static int INDEX_UPDATEDATE = 15;
    private final static int INDEX_UPDATEMAN = 16;
    private final static int INDEX_WFINSTANCEID = 17;
    private final static int INDEX_WFSTEPACTORID = 18;
    private final static int INDEX_WFSTEPACTORNAME = 19;
    private final static int INDEX_WFSTEPID = 20;
    private final static int INDEX_WFSTEPNAME = 21;

    private final static HashMap<String, Integer> fieldIndexMap = new HashMap<String, Integer>();
    static {
        fieldIndexMap.put( FIELD_ACTORID, INDEX_ACTORID);
        fieldIndexMap.put( FIELD_ACTORTYPE, INDEX_ACTORTYPE);
        fieldIndexMap.put( FIELD_CREATEDATE, INDEX_CREATEDATE);
        fieldIndexMap.put( FIELD_CREATEMAN, INDEX_CREATEMAN);
        fieldIndexMap.put( FIELD_FINISHDATE, INDEX_FINISHDATE);
        fieldIndexMap.put( FIELD_FIRSTREADTIME, INDEX_FIRSTREADTIME);
        fieldIndexMap.put( FIELD_IAACTIONS, INDEX_IAACTIONS);
        fieldIndexMap.put( FIELD_ISFINISH, INDEX_ISFINISH);
        fieldIndexMap.put( FIELD_ISREADONLY, INDEX_ISREADONLY);
        fieldIndexMap.put( FIELD_MEMO, INDEX_MEMO);
        fieldIndexMap.put( FIELD_ORIGINALWFUSERID, INDEX_ORIGINALWFUSERID);
        fieldIndexMap.put( FIELD_ORIGINALWFUSERNAME, INDEX_ORIGINALWFUSERNAME);
        fieldIndexMap.put( FIELD_READFLAG, INDEX_READFLAG);
        fieldIndexMap.put( FIELD_REMINDERCOUNT, INDEX_REMINDERCOUNT);
        fieldIndexMap.put( FIELD_ROLEID, INDEX_ROLEID);
        fieldIndexMap.put( FIELD_UPDATEDATE, INDEX_UPDATEDATE);
        fieldIndexMap.put( FIELD_UPDATEMAN, INDEX_UPDATEMAN);
        fieldIndexMap.put( FIELD_WFINSTANCEID, INDEX_WFINSTANCEID);
        fieldIndexMap.put( FIELD_WFSTEPACTORID, INDEX_WFSTEPACTORID);
        fieldIndexMap.put( FIELD_WFSTEPACTORNAME, INDEX_WFSTEPACTORNAME);
        fieldIndexMap.put( FIELD_WFSTEPID, INDEX_WFSTEPID);
        fieldIndexMap.put( FIELD_WFSTEPNAME, INDEX_WFSTEPNAME);
    }

    private WFStepActorBase proxyWFStepActorBase = null;
    public WFStepActorBase() {
        super();
    }
    private boolean actoridDirtyFlag = false;
    private boolean actortypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean finishdateDirtyFlag = false;
    private boolean firstreadtimeDirtyFlag = false;
    private boolean iaactionsDirtyFlag = false;
    private boolean isfinishDirtyFlag = false;
    private boolean isreadonlyDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean originalwfuseridDirtyFlag = false;
    private boolean originalwfusernameDirtyFlag = false;
    private boolean readflagDirtyFlag = false;
    private boolean remindercountDirtyFlag = false;
    private boolean roleidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfstepactoridDirtyFlag = false;
    private boolean wfstepactornameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfstepnameDirtyFlag = false;

    @Column(name="actorid")
    private String actorid;
    @Column(name="actortype")
    private Integer actortype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="finishdate")
    private Timestamp finishdate;
    @Column(name="firstreadtime")
    private Timestamp firstreadtime;
    @Column(name="iaactions")
    private String iaactions;
    @Column(name="isfinish")
    private Integer isfinish;
    @Column(name="isreadonly")
    private Integer isreadonly;
    @Column(name="memo")
    private String memo;
    @Column(name="originalwfuserid")
    private String originalwfuserid;
    @Column(name="originalwfusername")
    private String originalwfusername;
    @Column(name="readflag")
    private Integer readflag;
    @Column(name="remindercount")
    private Integer remindercount;
    @Column(name="roleid")
    private String roleid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfstepactorid")
    private String wfstepactorid;
    @Column(name="wfstepactorname")
    private String wfstepactorname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfstepname")
    private String wfstepname;


    /**
     *  设置属性值[工作流用户]
     *  @param actorid
     */
    public void setActorId(String actorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActorId(actorid);
            return;
        }
        if(actorid!=null) {
            actorid = StringHelper.trimRight(actorid);
            if(actorid.length()==0) {
                actorid = null;
            }
        }
        this.actorid = actorid;
        this.actoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流用户]
     */
    public String getActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorId();
        }
        return this.actorid;
    }

    /**
     *  获取属性值[工作流用户]是否修改
     */
    public boolean isActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorIdDirty();
        }
        return this.actoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流用户]
     */
    public void resetActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActorId();
            return;
        }

        this.actoridDirtyFlag = false;
        this.actorid = null;
    }
    /**
     *  设置属性值[用户类型]
     *  @param actortype
     */
    public void setActorType(Integer actortype) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setActorType(actortype);
            return;
        }
        this.actortype = actortype;
        this.actortypeDirtyFlag  = true;
    }

    /**
     *  获取属性值[用户类型]
     */
    public Integer getActorType() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getActorType();
        }
        return this.actortype;
    }

    /**
     *  获取属性值[用户类型]是否修改
     */
    public boolean isActorTypeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isActorTypeDirty();
        }
        return this.actortypeDirtyFlag;
    }

    /**
     *  重置属性值[用户类型]
     */
    public void resetActorType() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetActorType();
            return;
        }

        this.actortypeDirtyFlag = false;
        this.actortype = null;
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
     *  设置属性值[完成时间]
     *  @param finishdate
     */
    public void setFinishDate(Timestamp finishdate) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFinishDate(finishdate);
            return;
        }
        this.finishdate = finishdate;
        this.finishdateDirtyFlag  = true;
    }

    /**
     *  获取属性值[完成时间]
     */
    public Timestamp getFinishDate() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFinishDate();
        }
        return this.finishdate;
    }

    /**
     *  获取属性值[完成时间]是否修改
     */
    public boolean isFinishDateDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFinishDateDirty();
        }
        return this.finishdateDirtyFlag;
    }

    /**
     *  重置属性值[完成时间]
     */
    public void resetFinishDate() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFinishDate();
            return;
        }

        this.finishdateDirtyFlag = false;
        this.finishdate = null;
    }
    /**
     *  设置属性值[查看时间]
     *  @param firstreadtime
     */
    public void setFirstReadTime(Timestamp firstreadtime) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setFirstReadTime(firstreadtime);
            return;
        }
        this.firstreadtime = firstreadtime;
        this.firstreadtimeDirtyFlag  = true;
    }

    /**
     *  获取属性值[查看时间]
     */
    public Timestamp getFirstReadTime() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getFirstReadTime();
        }
        return this.firstreadtime;
    }

    /**
     *  获取属性值[查看时间]是否修改
     */
    public boolean isFirstReadTimeDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isFirstReadTimeDirty();
        }
        return this.firstreadtimeDirtyFlag;
    }

    /**
     *  重置属性值[查看时间]
     */
    public void resetFirstReadTime() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetFirstReadTime();
            return;
        }

        this.firstreadtimeDirtyFlag = false;
        this.firstreadtime = null;
    }
    /**
     *  设置属性值[允许交互操作]
     *  @param iaactions
     */
    public void setIAActions(String iaactions) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIAActions(iaactions);
            return;
        }
        if(iaactions!=null) {
            iaactions = StringHelper.trimRight(iaactions);
            if(iaactions.length()==0) {
                iaactions = null;
            }
        }
        this.iaactions = iaactions;
        this.iaactionsDirtyFlag  = true;
    }

    /**
     *  获取属性值[允许交互操作]
     */
    public String getIAActions() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIAActions();
        }
        return this.iaactions;
    }

    /**
     *  获取属性值[允许交互操作]是否修改
     */
    public boolean isIAActionsDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIAActionsDirty();
        }
        return this.iaactionsDirtyFlag;
    }

    /**
     *  重置属性值[允许交互操作]
     */
    public void resetIAActions() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIAActions();
            return;
        }

        this.iaactionsDirtyFlag = false;
        this.iaactions = null;
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
     *  设置属性值[是否只读]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param isreadonly
     */
    public void setIsReadOnly(Integer isreadonly) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setIsReadOnly(isreadonly);
            return;
        }
        this.isreadonly = isreadonly;
        this.isreadonlyDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否只读]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getIsReadOnly() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getIsReadOnly();
        }
        return this.isreadonly;
    }

    /**
     *  获取属性值[是否只读]是否修改
     */
    public boolean isIsReadOnlyDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isIsReadOnlyDirty();
        }
        return this.isreadonlyDirtyFlag;
    }

    /**
     *  重置属性值[是否只读]
     */
    public void resetIsReadOnly() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetIsReadOnly();
            return;
        }

        this.isreadonlyDirtyFlag = false;
        this.isreadonly = null;
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
     *  设置属性值[源流程用户]
     *  @param originalwfuserid
     */
    public void setOriginalWFUserId(String originalwfuserid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOriginalWFUserId(originalwfuserid);
            return;
        }
        if(originalwfuserid!=null) {
            originalwfuserid = StringHelper.trimRight(originalwfuserid);
            if(originalwfuserid.length()==0) {
                originalwfuserid = null;
            }
        }
        this.originalwfuserid = originalwfuserid;
        this.originalwfuseridDirtyFlag  = true;
    }

    /**
     *  获取属性值[源流程用户]
     */
    public String getOriginalWFUserId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUserId();
        }
        return this.originalwfuserid;
    }

    /**
     *  获取属性值[源流程用户]是否修改
     */
    public boolean isOriginalWFUserIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOriginalWFUserIdDirty();
        }
        return this.originalwfuseridDirtyFlag;
    }

    /**
     *  重置属性值[源流程用户]
     */
    public void resetOriginalWFUserId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOriginalWFUserId();
            return;
        }

        this.originalwfuseridDirtyFlag = false;
        this.originalwfuserid = null;
    }
    /**
     *  设置属性值[源流程用户]
     *  @param originalwfusername
     */
    public void setOriginalWFUserName(String originalwfusername) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setOriginalWFUserName(originalwfusername);
            return;
        }
        if(originalwfusername!=null) {
            originalwfusername = StringHelper.trimRight(originalwfusername);
            if(originalwfusername.length()==0) {
                originalwfusername = null;
            }
        }
        this.originalwfusername = originalwfusername;
        this.originalwfusernameDirtyFlag  = true;
    }

    /**
     *  获取属性值[源流程用户]
     */
    public String getOriginalWFUserName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUserName();
        }
        return this.originalwfusername;
    }

    /**
     *  获取属性值[源流程用户]是否修改
     */
    public boolean isOriginalWFUserNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isOriginalWFUserNameDirty();
        }
        return this.originalwfusernameDirtyFlag;
    }

    /**
     *  重置属性值[源流程用户]
     */
    public void resetOriginalWFUserName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetOriginalWFUserName();
            return;
        }

        this.originalwfusernameDirtyFlag = false;
        this.originalwfusername = null;
    }
    /**
     *  设置属性值[是否已读]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     *  @param readflag
     */
    public void setReadFlag(Integer readflag) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReadFlag(readflag);
            return;
        }
        this.readflag = readflag;
        this.readflagDirtyFlag  = true;
    }

    /**
     *  获取属性值[是否已读]代码表：net.ibizsys.psrt.srv.codelist.YesNoCodeListModel
     */
    public Integer getReadFlag() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReadFlag();
        }
        return this.readflag;
    }

    /**
     *  获取属性值[是否已读]是否修改
     */
    public boolean isReadFlagDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReadFlagDirty();
        }
        return this.readflagDirtyFlag;
    }

    /**
     *  重置属性值[是否已读]
     */
    public void resetReadFlag() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReadFlag();
            return;
        }

        this.readflagDirtyFlag = false;
        this.readflag = null;
    }
    /**
     *  设置属性值[督促次数]
     *  @param remindercount
     */
    public void setReminderCount(Integer remindercount) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setReminderCount(remindercount);
            return;
        }
        this.remindercount = remindercount;
        this.remindercountDirtyFlag  = true;
    }

    /**
     *  获取属性值[督促次数]
     */
    public Integer getReminderCount() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getReminderCount();
        }
        return this.remindercount;
    }

    /**
     *  获取属性值[督促次数]是否修改
     */
    public boolean isReminderCountDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isReminderCountDirty();
        }
        return this.remindercountDirtyFlag;
    }

    /**
     *  重置属性值[督促次数]
     */
    public void resetReminderCount() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetReminderCount();
            return;
        }

        this.remindercountDirtyFlag = false;
        this.remindercount = null;
    }
    /**
     *  设置属性值[角色用户]
     *  @param roleid
     */
    public void setRoleId(String roleid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setRoleId(roleid);
            return;
        }
        if(roleid!=null) {
            roleid = StringHelper.trimRight(roleid);
            if(roleid.length()==0) {
                roleid = null;
            }
        }
        this.roleid = roleid;
        this.roleidDirtyFlag  = true;
    }

    /**
     *  获取属性值[角色用户]
     */
    public String getRoleId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getRoleId();
        }
        return this.roleid;
    }

    /**
     *  获取属性值[角色用户]是否修改
     */
    public boolean isRoleIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isRoleIdDirty();
        }
        return this.roleidDirtyFlag;
    }

    /**
     *  重置属性值[角色用户]
     */
    public void resetRoleId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetRoleId();
            return;
        }

        this.roleidDirtyFlag = false;
        this.roleid = null;
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
     *  设置属性值[流程实例]
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
     *  获取属性值[流程实例]
     */
    public String getWFInstanceId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFInstanceId();
        }
        return this.wfinstanceid;
    }

    /**
     *  获取属性值[流程实例]是否修改
     */
    public boolean isWFInstanceIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFInstanceIdDirty();
        }
        return this.wfinstanceidDirtyFlag;
    }

    /**
     *  重置属性值[流程实例]
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
     *  设置属性值[工作流步骤操作者标识]
     *  @param wfstepactorid
     */
    public void setWFStepActorId(String wfstepactorid) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorId(wfstepactorid);
            return;
        }
        if(wfstepactorid!=null) {
            wfstepactorid = StringHelper.trimRight(wfstepactorid);
            if(wfstepactorid.length()==0) {
                wfstepactorid = null;
            }
        }
        this.wfstepactorid = wfstepactorid;
        this.wfstepactoridDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤操作者标识]
     */
    public String getWFStepActorId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorId();
        }
        return this.wfstepactorid;
    }

    /**
     *  获取属性值[工作流步骤操作者标识]是否修改
     */
    public boolean isWFStepActorIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorIdDirty();
        }
        return this.wfstepactoridDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤操作者标识]
     */
    public void resetWFStepActorId() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorId();
            return;
        }

        this.wfstepactoridDirtyFlag = false;
        this.wfstepactorid = null;
    }
    /**
     *  设置属性值[工作流步骤操作者名称]
     *  @param wfstepactorname
     */
    public void setWFStepActorName(String wfstepactorname) {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().setWFStepActorName(wfstepactorname);
            return;
        }
        if(wfstepactorname!=null) {
            wfstepactorname = StringHelper.trimRight(wfstepactorname);
            if(wfstepactorname.length()==0) {
                wfstepactorname = null;
            }
        }
        this.wfstepactorname = wfstepactorname;
        this.wfstepactornameDirtyFlag  = true;
    }

    /**
     *  获取属性值[工作流步骤操作者名称]
     */
    public String getWFStepActorName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepActorName();
        }
        return this.wfstepactorname;
    }

    /**
     *  获取属性值[工作流步骤操作者名称]是否修改
     */
    public boolean isWFStepActorNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepActorNameDirty();
        }
        return this.wfstepactornameDirtyFlag;
    }

    /**
     *  重置属性值[工作流步骤操作者名称]
     */
    public void resetWFStepActorName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepActorName();
            return;
        }

        this.wfstepactornameDirtyFlag = false;
        this.wfstepactorname = null;
    }
    /**
     *  设置属性值[步骤角色_步骤]
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
     *  获取属性值[步骤角色_步骤]
     */
    public String getWFStepId() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepId();
        }
        return this.wfstepid;
    }

    /**
     *  获取属性值[步骤角色_步骤]是否修改
     */
    public boolean isWFStepIdDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepIdDirty();
        }
        return this.wfstepidDirtyFlag;
    }

    /**
     *  重置属性值[步骤角色_步骤]
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
     *  设置属性值[流程步骤]
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
     *  获取属性值[流程步骤]
     */
    public String getWFStepName() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStepName();
        }
        return this.wfstepname;
    }

    /**
     *  获取属性值[流程步骤]是否修改
     */
    public boolean isWFStepNameDirty() {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().isWFStepNameDirty();
        }
        return this.wfstepnameDirtyFlag;
    }

    /**
     *  重置属性值[流程步骤]
     */
    public void resetWFStepName() {

        if(this.getProxyEntity()!=null) {
            this.getProxyEntity().resetWFStepName();
            return;
        }

        this.wfstepnameDirtyFlag = false;
        this.wfstepname = null;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onReset()
     */
    @Override
    protected void onReset() {
        WFStepActorBase.resetAll(this);
        super.onReset();
    }

    /**
     * 重置当前数据对象属性值
     * @param entity
     */
    private static void resetAll(WFStepActorBase et) {
        et.resetActorId();
        et.resetActorType();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetFinishDate();
        et.resetFirstReadTime();
        et.resetIAActions();
        et.resetIsFinish();
        et.resetIsReadOnly();
        et.resetMemo();
        et.resetOriginalWFUserId();
        et.resetOriginalWFUserName();
        et.resetReadFlag();
        et.resetReminderCount();
        et.resetRoleId();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFInstanceId();
        et.resetWFStepActorId();
        et.resetWFStepActorName();
        et.resetWFStepId();
        et.resetWFStepName();
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onFillMap(java.util.HashMap, boolean)
     */
    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if(!bDirtyOnly || isActorIdDirty()) {
            params.put(FIELD_ACTORID,getActorId());
        }
        if(!bDirtyOnly || isActorTypeDirty()) {
            params.put(FIELD_ACTORTYPE,getActorType());
        }
        if(!bDirtyOnly || isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE,getCreateDate());
        }
        if(!bDirtyOnly || isCreateManDirty()) {
            params.put(FIELD_CREATEMAN,getCreateMan());
        }
        if(!bDirtyOnly || isFinishDateDirty()) {
            params.put(FIELD_FINISHDATE,getFinishDate());
        }
        if(!bDirtyOnly || isFirstReadTimeDirty()) {
            params.put(FIELD_FIRSTREADTIME,getFirstReadTime());
        }
        if(!bDirtyOnly || isIAActionsDirty()) {
            params.put(FIELD_IAACTIONS,getIAActions());
        }
        if(!bDirtyOnly || isIsFinishDirty()) {
            params.put(FIELD_ISFINISH,getIsFinish());
        }
        if(!bDirtyOnly || isIsReadOnlyDirty()) {
            params.put(FIELD_ISREADONLY,getIsReadOnly());
        }
        if(!bDirtyOnly || isMemoDirty()) {
            params.put(FIELD_MEMO,getMemo());
        }
        if(!bDirtyOnly || isOriginalWFUserIdDirty()) {
            params.put(FIELD_ORIGINALWFUSERID,getOriginalWFUserId());
        }
        if(!bDirtyOnly || isOriginalWFUserNameDirty()) {
            params.put(FIELD_ORIGINALWFUSERNAME,getOriginalWFUserName());
        }
        if(!bDirtyOnly || isReadFlagDirty()) {
            params.put(FIELD_READFLAG,getReadFlag());
        }
        if(!bDirtyOnly || isReminderCountDirty()) {
            params.put(FIELD_REMINDERCOUNT,getReminderCount());
        }
        if(!bDirtyOnly || isRoleIdDirty()) {
            params.put(FIELD_ROLEID,getRoleId());
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
        if(!bDirtyOnly || isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID,getWFStepActorId());
        }
        if(!bDirtyOnly || isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME,getWFStepActorName());
        }
        if(!bDirtyOnly || isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID,getWFStepId());
        }
        if(!bDirtyOnly || isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME,getWFStepName());
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

        return  WFStepActorBase.get(this, index);
    }

    /**
     * 通过属性标识获取属性值
     * @param et 数据对象
     * @param index 属性标识
     * @return
     * @throws Exception
     */
    private static Object get(WFStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.getActorId();
        case INDEX_ACTORTYPE:
            return et.getActorType();
        case INDEX_CREATEDATE:
            return et.getCreateDate();
        case INDEX_CREATEMAN:
            return et.getCreateMan();
        case INDEX_FINISHDATE:
            return et.getFinishDate();
        case INDEX_FIRSTREADTIME:
            return et.getFirstReadTime();
        case INDEX_IAACTIONS:
            return et.getIAActions();
        case INDEX_ISFINISH:
            return et.getIsFinish();
        case INDEX_ISREADONLY:
            return et.getIsReadOnly();
        case INDEX_MEMO:
            return et.getMemo();
        case INDEX_ORIGINALWFUSERID:
            return et.getOriginalWFUserId();
        case INDEX_ORIGINALWFUSERNAME:
            return et.getOriginalWFUserName();
        case INDEX_READFLAG:
            return et.getReadFlag();
        case INDEX_REMINDERCOUNT:
            return et.getReminderCount();
        case INDEX_ROLEID:
            return et.getRoleId();
        case INDEX_UPDATEDATE:
            return et.getUpdateDate();
        case INDEX_UPDATEMAN:
            return et.getUpdateMan();
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId();
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId();
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName();
        case INDEX_WFSTEPID:
            return et.getWFStepId();
        case INDEX_WFSTEPNAME:
            return et.getWFStepName();
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

        WFStepActorBase.set(this,index,objValue);
    }

    /**
     * 通过属性标识设定属性值
     * @param et 数据对象
     * @param index 属性标识
     * @param obj 值
     * @throws Exception
     */
    private static void set(WFStepActorBase et,int index,Object obj) throws Exception {
        switch(index) {
        case INDEX_ACTORID:
            et.setActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ACTORTYPE:
            et.setActorType(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_CREATEDATE:
            et.setCreateDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_CREATEMAN:
            et.setCreateMan(DataObject.getStringValue(obj));
            return ;
        case INDEX_FINISHDATE:
            et.setFinishDate(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_FIRSTREADTIME:
            et.setFirstReadTime(DataObject.getTimestampValue(obj));
            return ;
        case INDEX_IAACTIONS:
            et.setIAActions(DataObject.getStringValue(obj));
            return ;
        case INDEX_ISFINISH:
            et.setIsFinish(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ISREADONLY:
            et.setIsReadOnly(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_MEMO:
            et.setMemo(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORIGINALWFUSERID:
            et.setOriginalWFUserId(DataObject.getStringValue(obj));
            return ;
        case INDEX_ORIGINALWFUSERNAME:
            et.setOriginalWFUserName(DataObject.getStringValue(obj));
            return ;
        case INDEX_READFLAG:
            et.setReadFlag(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_REMINDERCOUNT:
            et.setReminderCount(DataObject.getIntegerValue(obj));
            return ;
        case INDEX_ROLEID:
            et.setRoleId(DataObject.getStringValue(obj));
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
        case INDEX_WFSTEPACTORID:
            et.setWFStepActorId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPACTORNAME:
            et.setWFStepActorName(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPID:
            et.setWFStepId(DataObject.getStringValue(obj));
            return ;
        case INDEX_WFSTEPNAME:
            et.setWFStepName(DataObject.getStringValue(obj));
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

        return  WFStepActorBase.isNull(this, index);
    }

    /**
     * 判断指定属性值是否为空值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean isNull(WFStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.getActorId()==null;
        case INDEX_ACTORTYPE:
            return et.getActorType()==null;
        case INDEX_CREATEDATE:
            return et.getCreateDate()==null;
        case INDEX_CREATEMAN:
            return et.getCreateMan()==null;
        case INDEX_FINISHDATE:
            return et.getFinishDate()==null;
        case INDEX_FIRSTREADTIME:
            return et.getFirstReadTime()==null;
        case INDEX_IAACTIONS:
            return et.getIAActions()==null;
        case INDEX_ISFINISH:
            return et.getIsFinish()==null;
        case INDEX_ISREADONLY:
            return et.getIsReadOnly()==null;
        case INDEX_MEMO:
            return et.getMemo()==null;
        case INDEX_ORIGINALWFUSERID:
            return et.getOriginalWFUserId()==null;
        case INDEX_ORIGINALWFUSERNAME:
            return et.getOriginalWFUserName()==null;
        case INDEX_READFLAG:
            return et.getReadFlag()==null;
        case INDEX_REMINDERCOUNT:
            return et.getReminderCount()==null;
        case INDEX_ROLEID:
            return et.getRoleId()==null;
        case INDEX_UPDATEDATE:
            return et.getUpdateDate()==null;
        case INDEX_UPDATEMAN:
            return et.getUpdateMan()==null;
        case INDEX_WFINSTANCEID:
            return et.getWFInstanceId()==null;
        case INDEX_WFSTEPACTORID:
            return et.getWFStepActorId()==null;
        case INDEX_WFSTEPACTORNAME:
            return et.getWFStepActorName()==null;
        case INDEX_WFSTEPID:
            return et.getWFStepId()==null;
        case INDEX_WFSTEPNAME:
            return et.getWFStepName()==null;
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
        return  WFStepActorBase.contains(this, index);
    }

    /**
     * 获取判断对象是否存在指定属性值
     * @param et
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean contains(WFStepActorBase et,int index) throws Exception {

        switch(index) {
        case INDEX_ACTORID:
            return et.isActorIdDirty();
        case INDEX_ACTORTYPE:
            return et.isActorTypeDirty();
        case INDEX_CREATEDATE:
            return et.isCreateDateDirty();
        case INDEX_CREATEMAN:
            return et.isCreateManDirty();
        case INDEX_FINISHDATE:
            return et.isFinishDateDirty();
        case INDEX_FIRSTREADTIME:
            return et.isFirstReadTimeDirty();
        case INDEX_IAACTIONS:
            return et.isIAActionsDirty();
        case INDEX_ISFINISH:
            return et.isIsFinishDirty();
        case INDEX_ISREADONLY:
            return et.isIsReadOnlyDirty();
        case INDEX_MEMO:
            return et.isMemoDirty();
        case INDEX_ORIGINALWFUSERID:
            return et.isOriginalWFUserIdDirty();
        case INDEX_ORIGINALWFUSERNAME:
            return et.isOriginalWFUserNameDirty();
        case INDEX_READFLAG:
            return et.isReadFlagDirty();
        case INDEX_REMINDERCOUNT:
            return et.isReminderCountDirty();
        case INDEX_ROLEID:
            return et.isRoleIdDirty();
        case INDEX_UPDATEDATE:
            return et.isUpdateDateDirty();
        case INDEX_UPDATEMAN:
            return et.isUpdateManDirty();
        case INDEX_WFINSTANCEID:
            return et.isWFInstanceIdDirty();
        case INDEX_WFSTEPACTORID:
            return et.isWFStepActorIdDirty();
        case INDEX_WFSTEPACTORNAME:
            return et.isWFStepActorNameDirty();
        case INDEX_WFSTEPID:
            return et.isWFStepIdDirty();
        case INDEX_WFSTEPNAME:
            return et.isWFStepNameDirty();
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
    private static  void fillJSONObject(WFStepActorBase et,JSONObject json, boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActorId()!=null) {
            JSONObjectHelper.put(json,"actorid",getJSONValue(et.getActorId()),false);
        }
        if(bIncEmpty||et.getActorType()!=null) {
            JSONObjectHelper.put(json,"actortype",getJSONValue(et.getActorType()),false);
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            JSONObjectHelper.put(json,"createdate",getJSONValue(et.getCreateDate()),false);
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            JSONObjectHelper.put(json,"createman",getJSONValue(et.getCreateMan()),false);
        }
        if(bIncEmpty||et.getFinishDate()!=null) {
            JSONObjectHelper.put(json,"finishdate",getJSONValue(et.getFinishDate()),false);
        }
        if(bIncEmpty||et.getFirstReadTime()!=null) {
            JSONObjectHelper.put(json,"firstreadtime",getJSONValue(et.getFirstReadTime()),false);
        }
        if(bIncEmpty||et.getIAActions()!=null) {
            JSONObjectHelper.put(json,"iaactions",getJSONValue(et.getIAActions()),false);
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            JSONObjectHelper.put(json,"isfinish",getJSONValue(et.getIsFinish()),false);
        }
        if(bIncEmpty||et.getIsReadOnly()!=null) {
            JSONObjectHelper.put(json,"isreadonly",getJSONValue(et.getIsReadOnly()),false);
        }
        if(bIncEmpty||et.getMemo()!=null) {
            JSONObjectHelper.put(json,"memo",getJSONValue(et.getMemo()),false);
        }
        if(bIncEmpty||et.getOriginalWFUserId()!=null) {
            JSONObjectHelper.put(json,"originalwfuserid",getJSONValue(et.getOriginalWFUserId()),false);
        }
        if(bIncEmpty||et.getOriginalWFUserName()!=null) {
            JSONObjectHelper.put(json,"originalwfusername",getJSONValue(et.getOriginalWFUserName()),false);
        }
        if(bIncEmpty||et.getReadFlag()!=null) {
            JSONObjectHelper.put(json,"readflag",getJSONValue(et.getReadFlag()),false);
        }
        if(bIncEmpty||et.getReminderCount()!=null) {
            JSONObjectHelper.put(json,"remindercount",getJSONValue(et.getReminderCount()),false);
        }
        if(bIncEmpty||et.getRoleId()!=null) {
            JSONObjectHelper.put(json,"roleid",getJSONValue(et.getRoleId()),false);
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
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            JSONObjectHelper.put(json,"wfstepactorid",getJSONValue(et.getWFStepActorId()),false);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            JSONObjectHelper.put(json,"wfstepactorname",getJSONValue(et.getWFStepActorName()),false);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            JSONObjectHelper.put(json,"wfstepid",getJSONValue(et.getWFStepId()),false);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            JSONObjectHelper.put(json,"wfstepname",getJSONValue(et.getWFStepName()),false);
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
    private static void fillXmlNode(WFStepActorBase et,XmlNode node,boolean bIncEmpty) throws Exception {
        if(bIncEmpty||et.getActorId()!=null) {
            Object obj = et.getActorId();
            node.setAttribute("ACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getActorType()!=null) {
            Object obj = et.getActorType();
            node.setAttribute("ACTORTYPE",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getCreateDate()!=null) {
            Object obj = et.getCreateDate();
            node.setAttribute("CREATEDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getCreateMan()!=null) {
            Object obj = et.getCreateMan();
            node.setAttribute("CREATEMAN",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getFinishDate()!=null) {
            Object obj = et.getFinishDate();
            node.setAttribute("FINISHDATE",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getFirstReadTime()!=null) {
            Object obj = et.getFirstReadTime();
            node.setAttribute("FIRSTREADTIME",(obj==null)?"":StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS",obj));
        }
        if(bIncEmpty||et.getIAActions()!=null) {
            Object obj = et.getIAActions();
            node.setAttribute("IAACTIONS",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getIsFinish()!=null) {
            Object obj = et.getIsFinish();
            node.setAttribute("ISFINISH",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getIsReadOnly()!=null) {
            Object obj = et.getIsReadOnly();
            node.setAttribute("ISREADONLY",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getMemo()!=null) {
            Object obj = et.getMemo();
            node.setAttribute("MEMO",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOriginalWFUserId()!=null) {
            Object obj = et.getOriginalWFUserId();
            node.setAttribute("ORIGINALWFUSERID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getOriginalWFUserName()!=null) {
            Object obj = et.getOriginalWFUserName();
            node.setAttribute("ORIGINALWFUSERNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getReadFlag()!=null) {
            Object obj = et.getReadFlag();
            node.setAttribute("READFLAG",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getReminderCount()!=null) {
            Object obj = et.getReminderCount();
            node.setAttribute("REMINDERCOUNT",(obj==null)?"":StringHelper.format("%1$s",obj));
        }
        if(bIncEmpty||et.getRoleId()!=null) {
            Object obj = et.getRoleId();
            node.setAttribute("ROLEID",(obj==null)?"":(String)obj);
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
        if(bIncEmpty||et.getWFStepActorId()!=null) {
            Object obj = et.getWFStepActorId();
            node.setAttribute("WFSTEPACTORID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepActorName()!=null) {
            Object obj = et.getWFStepActorName();
            node.setAttribute("WFSTEPACTORNAME",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepId()!=null) {
            Object obj = et.getWFStepId();
            node.setAttribute("WFSTEPID",(obj==null)?"":(String)obj);
        }
        if(bIncEmpty||et.getWFStepName()!=null) {
            Object obj = et.getWFStepName();
            node.setAttribute("WFSTEPNAME",(obj==null)?"":(String)obj);
        }


    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.entity.EntityBase#onCopyTo(net.ibizsys.paas.data.IDataObject, boolean)
     */
    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepActorBase.copyTo(this,dataEntity,bIncludeEmtpy);
        super.onCopyTo(dataEntity,bIncludeEmtpy);
    }

    /**
     * 复制当前对象数据到目标对象
     * @param et 当前数据对象
     * @param dst 目标数据对象
     * @param bIncEmpty 是否包括空值
     * @throws Exception
     */
    private static void copyTo(WFStepActorBase et,IDataObject dst,boolean bIncEmpty) throws Exception {
        if(et.isActorIdDirty() && (bIncEmpty||et.getActorId()!=null)) {
            dst.set(FIELD_ACTORID,et.getActorId());
        }
        if(et.isActorTypeDirty() && (bIncEmpty||et.getActorType()!=null)) {
            dst.set(FIELD_ACTORTYPE,et.getActorType());
        }
        if(et.isCreateDateDirty() && (bIncEmpty||et.getCreateDate()!=null)) {
            dst.set(FIELD_CREATEDATE,et.getCreateDate());
        }
        if(et.isCreateManDirty() && (bIncEmpty||et.getCreateMan()!=null)) {
            dst.set(FIELD_CREATEMAN,et.getCreateMan());
        }
        if(et.isFinishDateDirty() && (bIncEmpty||et.getFinishDate()!=null)) {
            dst.set(FIELD_FINISHDATE,et.getFinishDate());
        }
        if(et.isFirstReadTimeDirty() && (bIncEmpty||et.getFirstReadTime()!=null)) {
            dst.set(FIELD_FIRSTREADTIME,et.getFirstReadTime());
        }
        if(et.isIAActionsDirty() && (bIncEmpty||et.getIAActions()!=null)) {
            dst.set(FIELD_IAACTIONS,et.getIAActions());
        }
        if(et.isIsFinishDirty() && (bIncEmpty||et.getIsFinish()!=null)) {
            dst.set(FIELD_ISFINISH,et.getIsFinish());
        }
        if(et.isIsReadOnlyDirty() && (bIncEmpty||et.getIsReadOnly()!=null)) {
            dst.set(FIELD_ISREADONLY,et.getIsReadOnly());
        }
        if(et.isMemoDirty() && (bIncEmpty||et.getMemo()!=null)) {
            dst.set(FIELD_MEMO,et.getMemo());
        }
        if(et.isOriginalWFUserIdDirty() && (bIncEmpty||et.getOriginalWFUserId()!=null)) {
            dst.set(FIELD_ORIGINALWFUSERID,et.getOriginalWFUserId());
        }
        if(et.isOriginalWFUserNameDirty() && (bIncEmpty||et.getOriginalWFUserName()!=null)) {
            dst.set(FIELD_ORIGINALWFUSERNAME,et.getOriginalWFUserName());
        }
        if(et.isReadFlagDirty() && (bIncEmpty||et.getReadFlag()!=null)) {
            dst.set(FIELD_READFLAG,et.getReadFlag());
        }
        if(et.isReminderCountDirty() && (bIncEmpty||et.getReminderCount()!=null)) {
            dst.set(FIELD_REMINDERCOUNT,et.getReminderCount());
        }
        if(et.isRoleIdDirty() && (bIncEmpty||et.getRoleId()!=null)) {
            dst.set(FIELD_ROLEID,et.getRoleId());
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
        if(et.isWFStepActorIdDirty() && (bIncEmpty||et.getWFStepActorId()!=null)) {
            dst.set(FIELD_WFSTEPACTORID,et.getWFStepActorId());
        }
        if(et.isWFStepActorNameDirty() && (bIncEmpty||et.getWFStepActorName()!=null)) {
            dst.set(FIELD_WFSTEPACTORNAME,et.getWFStepActorName());
        }
        if(et.isWFStepIdDirty() && (bIncEmpty||et.getWFStepId()!=null)) {
            dst.set(FIELD_WFSTEPID,et.getWFStepId());
        }
        if(et.isWFStepNameDirty() && (bIncEmpty||et.getWFStepName()!=null)) {
            dst.set(FIELD_WFSTEPNAME,et.getWFStepName());
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
        return  WFStepActorBase.remove(this, index);
    }

    /**
     * 通过属性标识删除属性值
     * @param entity
     * @param index
     * @return
     * @throws Exception
     */
    private static boolean remove(WFStepActorBase et,int index) throws Exception {
        switch(index) {
        case INDEX_ACTORID:
            et.resetActorId();
            return true;
        case INDEX_ACTORTYPE:
            et.resetActorType();
            return true;
        case INDEX_CREATEDATE:
            et.resetCreateDate();
            return true;
        case INDEX_CREATEMAN:
            et.resetCreateMan();
            return true;
        case INDEX_FINISHDATE:
            et.resetFinishDate();
            return true;
        case INDEX_FIRSTREADTIME:
            et.resetFirstReadTime();
            return true;
        case INDEX_IAACTIONS:
            et.resetIAActions();
            return true;
        case INDEX_ISFINISH:
            et.resetIsFinish();
            return true;
        case INDEX_ISREADONLY:
            et.resetIsReadOnly();
            return true;
        case INDEX_MEMO:
            et.resetMemo();
            return true;
        case INDEX_ORIGINALWFUSERID:
            et.resetOriginalWFUserId();
            return true;
        case INDEX_ORIGINALWFUSERNAME:
            et.resetOriginalWFUserName();
            return true;
        case INDEX_READFLAG:
            et.resetReadFlag();
            return true;
        case INDEX_REMINDERCOUNT:
            et.resetReminderCount();
            return true;
        case INDEX_ROLEID:
            et.resetRoleId();
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
        case INDEX_WFSTEPACTORID:
            et.resetWFStepActorId();
            return true;
        case INDEX_WFSTEPACTORNAME:
            et.resetWFStepActorName();
            return true;
        case INDEX_WFSTEPID:
            et.resetWFStepId();
            return true;
        case INDEX_WFSTEPNAME:
            et.resetWFStepName();
            return true;
        default:
            throw new Exception("不明属性标识");
        }
    }


    private Integer objWFStepLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = null;
    /**
    * 获取父数据 工作流步骤
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFStep getWFStep() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getWFStep();
        }

        if(this.getWFStepId()==null)
            return null;
        synchronized(this.objWFStepLock) {
            if(this.wfstep!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getWFStepId(),wfstep.getWFStepId())!=0) {
                    this.wfstep = null;
                }
            }


            if(this.wfstep==null) {
                net.ibizsys.psrt.srv.wf.entity.WFStep wfstep = new net.ibizsys.psrt.srv.wf.entity.WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                net.ibizsys.psrt.srv.wf.service.WFStepService service = (net.ibizsys.psrt.srv.wf.service.WFStepService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFStepService.class,this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    private Integer objOriginalWFUserLock = new Integer(1);
    private net.ibizsys.psrt.srv.wf.entity.WFUser originalwfuser = null;
    /**
    * 获取父数据 工作流用户
     * @throws Exception
    */
    public net.ibizsys.psrt.srv.wf.entity.WFUser getOriginalWFUser() throws Exception {
        if(this.getProxyEntity()!=null) {
            return this.getProxyEntity().getOriginalWFUser();
        }

        if(this.getOriginalWFUserId()==null)
            return null;
        synchronized(this.objOriginalWFUserLock) {
            if(this.originalwfuser!=null) {
                if(net.ibizsys.paas.util.DataTypeHelper.compare(25,this.getOriginalWFUserId(),originalwfuser.getWFUserId())!=0) {
                    this.originalwfuser = null;
                }
            }


            if(this.originalwfuser==null) {
                net.ibizsys.psrt.srv.wf.entity.WFUser originalwfuser = new net.ibizsys.psrt.srv.wf.entity.WFUser();
                originalwfuser.setWFUserId(this.getOriginalWFUserId());
                net.ibizsys.psrt.srv.wf.service.WFUserService service = (net.ibizsys.psrt.srv.wf.service.WFUserService)ServiceGlobal.getService(net.ibizsys.psrt.srv.wf.service.WFUserService.class,this.getSessionFactory());
                service.autoGet(originalwfuser);
                this.originalwfuser = originalwfuser;
            }
            return this.originalwfuser;
        }
    }



    /**
     *  获取代理的数据对象
     */
    private WFStepActorBase getProxyEntity() {
        return this.proxyWFStepActorBase;
    }

    /* (non-Javadoc)
     * @see net.ibizsys.paas.data.DataObject#onProxy(net.ibizsys.paas.data.IDataObject)
     */
    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepActorBase = null;
        if(proxyDataObject!=null && proxyDataObject instanceof WFStepActorBase) {
            this.proxyWFStepActorBase = (WFStepActorBase)proxyDataObject;
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
        iEntityActionHelper = net.ibizsys.paas.service.ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

}