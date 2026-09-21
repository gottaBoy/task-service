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
import net.ibizsys.psrt.srv.wf.entity.WFStep;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFStepService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFStepActorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFStepActorBase.class);
    public static final String FIELD_ACTORID = "ACTORID";
    public static final String FIELD_ACTORTYPE = "ACTORTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FINISHDATE = "FINISHDATE";
    public static final String FIELD_FIRSTREADTIME = "FIRSTREADTIME";
    public static final String FIELD_IAACTIONS = "IAACTIONS";
    public static final String FIELD_ISFINISH = "ISFINISH";
    public static final String FIELD_ISREADONLY = "ISREADONLY";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORIGINALWFUSERID = "ORIGINALWFUSERID";
    public static final String FIELD_ORIGINALWFUSERNAME = "ORIGINALWFUSERNAME";
    public static final String FIELD_READFLAG = "READFLAG";
    public static final String FIELD_REMINDERCOUNT = "REMINDERCOUNT";
    public static final String FIELD_ROLEID = "ROLEID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    public static final String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFSTEPNAME = "WFSTEPNAME";
    private static final int INDEX_ACTORID = 0;
    private static final int INDEX_ACTORTYPE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_FINISHDATE = 4;
    private static final int INDEX_FIRSTREADTIME = 5;
    private static final int INDEX_IAACTIONS = 6;
    private static final int INDEX_ISFINISH = 7;
    private static final int INDEX_ISREADONLY = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORIGINALWFUSERID = 10;
    private static final int INDEX_ORIGINALWFUSERNAME = 11;
    private static final int INDEX_READFLAG = 12;
    private static final int INDEX_REMINDERCOUNT = 13;
    private static final int INDEX_ROLEID = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_WFINSTANCEID = 17;
    private static final int INDEX_WFSTEPACTORID = 18;
    private static final int INDEX_WFSTEPACTORNAME = 19;
    private static final int INDEX_WFSTEPID = 20;
    private static final int INDEX_WFSTEPNAME = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFStepActorBase proxyWFStepActorBase = null;
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
    private Integer objWFStepLock = new Integer(1);
    private WFStep wfstep = null;
    private Integer objOriginalWFUserLock = new Integer(1);
    private WFUser originalwfuser = null;

    static {
        fieldIndexMap.put(FIELD_ACTORID, 0);
        fieldIndexMap.put(FIELD_ACTORTYPE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_FINISHDATE, 4);
        fieldIndexMap.put(FIELD_FIRSTREADTIME, 5);
        fieldIndexMap.put(FIELD_IAACTIONS, 6);
        fieldIndexMap.put(FIELD_ISFINISH, 7);
        fieldIndexMap.put(FIELD_ISREADONLY, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERID, 10);
        fieldIndexMap.put(FIELD_ORIGINALWFUSERNAME, 11);
        fieldIndexMap.put(FIELD_READFLAG, 12);
        fieldIndexMap.put(FIELD_REMINDERCOUNT, 13);
        fieldIndexMap.put(FIELD_ROLEID, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 17);
        fieldIndexMap.put(FIELD_WFSTEPACTORID, 18);
        fieldIndexMap.put(FIELD_WFSTEPACTORNAME, 19);
        fieldIndexMap.put(FIELD_WFSTEPID, 20);
        fieldIndexMap.put(FIELD_WFSTEPNAME, 21);
    }

    public void setActorId(String actorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorId(actorid);
            return;
        }
        if (actorid != null && (actorid = StringHelper.trimRight(actorid)).length() == 0) {
            actorid = null;
        }
        this.actorid = actorid;
        this.actoridDirtyFlag = true;
    }

    public String getActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorId();
        }
        return this.actorid;
    }

    public boolean isActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorIdDirty();
        }
        return this.actoridDirtyFlag;
    }

    public void resetActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorId();
            return;
        }
        this.actoridDirtyFlag = false;
        this.actorid = null;
    }

    public void setActorType(Integer actortype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActorType(actortype);
            return;
        }
        this.actortype = actortype;
        this.actortypeDirtyFlag = true;
    }

    public Integer getActorType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActorType();
        }
        return this.actortype;
    }

    public boolean isActorTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActorTypeDirty();
        }
        return this.actortypeDirtyFlag;
    }

    public void resetActorType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActorType();
            return;
        }
        this.actortypeDirtyFlag = false;
        this.actortype = null;
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

    public void setFinishDate(Timestamp finishdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFinishDate(finishdate);
            return;
        }
        this.finishdate = finishdate;
        this.finishdateDirtyFlag = true;
    }

    public Timestamp getFinishDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFinishDate();
        }
        return this.finishdate;
    }

    public boolean isFinishDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFinishDateDirty();
        }
        return this.finishdateDirtyFlag;
    }

    public void resetFinishDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFinishDate();
            return;
        }
        this.finishdateDirtyFlag = false;
        this.finishdate = null;
    }

    public void setFirstReadTime(Timestamp firstreadtime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFirstReadTime(firstreadtime);
            return;
        }
        this.firstreadtime = firstreadtime;
        this.firstreadtimeDirtyFlag = true;
    }

    public Timestamp getFirstReadTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFirstReadTime();
        }
        return this.firstreadtime;
    }

    public boolean isFirstReadTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFirstReadTimeDirty();
        }
        return this.firstreadtimeDirtyFlag;
    }

    public void resetFirstReadTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFirstReadTime();
            return;
        }
        this.firstreadtimeDirtyFlag = false;
        this.firstreadtime = null;
    }

    public void setIAActions(String iaactions) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIAActions(iaactions);
            return;
        }
        if (iaactions != null && (iaactions = StringHelper.trimRight(iaactions)).length() == 0) {
            iaactions = null;
        }
        this.iaactions = iaactions;
        this.iaactionsDirtyFlag = true;
    }

    public String getIAActions() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIAActions();
        }
        return this.iaactions;
    }

    public boolean isIAActionsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIAActionsDirty();
        }
        return this.iaactionsDirtyFlag;
    }

    public void resetIAActions() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIAActions();
            return;
        }
        this.iaactionsDirtyFlag = false;
        this.iaactions = null;
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

    public void setIsReadOnly(Integer isreadonly) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsReadOnly(isreadonly);
            return;
        }
        this.isreadonly = isreadonly;
        this.isreadonlyDirtyFlag = true;
    }

    public Integer getIsReadOnly() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsReadOnly();
        }
        return this.isreadonly;
    }

    public boolean isIsReadOnlyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsReadOnlyDirty();
        }
        return this.isreadonlyDirtyFlag;
    }

    public void resetIsReadOnly() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsReadOnly();
            return;
        }
        this.isreadonlyDirtyFlag = false;
        this.isreadonly = null;
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

    public void setOriginalWFUserId(String originalwfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriginalWFUserId(originalwfuserid);
            return;
        }
        if (originalwfuserid != null && (originalwfuserid = StringHelper.trimRight(originalwfuserid)).length() == 0) {
            originalwfuserid = null;
        }
        this.originalwfuserid = originalwfuserid;
        this.originalwfuseridDirtyFlag = true;
    }

    public String getOriginalWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUserId();
        }
        return this.originalwfuserid;
    }

    public boolean isOriginalWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriginalWFUserIdDirty();
        }
        return this.originalwfuseridDirtyFlag;
    }

    public void resetOriginalWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriginalWFUserId();
            return;
        }
        this.originalwfuseridDirtyFlag = false;
        this.originalwfuserid = null;
    }

    public void setOriginalWFUserName(String originalwfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOriginalWFUserName(originalwfusername);
            return;
        }
        if (originalwfusername != null && (originalwfusername = StringHelper.trimRight(originalwfusername)).length() == 0) {
            originalwfusername = null;
        }
        this.originalwfusername = originalwfusername;
        this.originalwfusernameDirtyFlag = true;
    }

    public String getOriginalWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUserName();
        }
        return this.originalwfusername;
    }

    public boolean isOriginalWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOriginalWFUserNameDirty();
        }
        return this.originalwfusernameDirtyFlag;
    }

    public void resetOriginalWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOriginalWFUserName();
            return;
        }
        this.originalwfusernameDirtyFlag = false;
        this.originalwfusername = null;
    }

    public void setReadFlag(Integer readflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReadFlag(readflag);
            return;
        }
        this.readflag = readflag;
        this.readflagDirtyFlag = true;
    }

    public Integer getReadFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReadFlag();
        }
        return this.readflag;
    }

    public boolean isReadFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReadFlagDirty();
        }
        return this.readflagDirtyFlag;
    }

    public void resetReadFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReadFlag();
            return;
        }
        this.readflagDirtyFlag = false;
        this.readflag = null;
    }

    public void setReminderCount(Integer remindercount) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReminderCount(remindercount);
            return;
        }
        this.remindercount = remindercount;
        this.remindercountDirtyFlag = true;
    }

    public Integer getReminderCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReminderCount();
        }
        return this.remindercount;
    }

    public boolean isReminderCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReminderCountDirty();
        }
        return this.remindercountDirtyFlag;
    }

    public void resetReminderCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReminderCount();
            return;
        }
        this.remindercountDirtyFlag = false;
        this.remindercount = null;
    }

    public void setRoleId(String roleid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRoleId(roleid);
            return;
        }
        if (roleid != null && (roleid = StringHelper.trimRight(roleid)).length() == 0) {
            roleid = null;
        }
        this.roleid = roleid;
        this.roleidDirtyFlag = true;
    }

    public String getRoleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRoleId();
        }
        return this.roleid;
    }

    public boolean isRoleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRoleIdDirty();
        }
        return this.roleidDirtyFlag;
    }

    public void resetRoleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRoleId();
            return;
        }
        this.roleidDirtyFlag = false;
        this.roleid = null;
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

    public void setWFStepActorId(String wfstepactorid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepActorId(wfstepactorid);
            return;
        }
        if (wfstepactorid != null && (wfstepactorid = StringHelper.trimRight(wfstepactorid)).length() == 0) {
            wfstepactorid = null;
        }
        this.wfstepactorid = wfstepactorid;
        this.wfstepactoridDirtyFlag = true;
    }

    public String getWFStepActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepActorId();
        }
        return this.wfstepactorid;
    }

    public boolean isWFStepActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepActorIdDirty();
        }
        return this.wfstepactoridDirtyFlag;
    }

    public void resetWFStepActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepActorId();
            return;
        }
        this.wfstepactoridDirtyFlag = false;
        this.wfstepactorid = null;
    }

    public void setWFStepActorName(String wfstepactorname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStepActorName(wfstepactorname);
            return;
        }
        if (wfstepactorname != null && (wfstepactorname = StringHelper.trimRight(wfstepactorname)).length() == 0) {
            wfstepactorname = null;
        }
        this.wfstepactorname = wfstepactorname;
        this.wfstepactornameDirtyFlag = true;
    }

    public String getWFStepActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepActorName();
        }
        return this.wfstepactorname;
    }

    public boolean isWFStepActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepActorNameDirty();
        }
        return this.wfstepactornameDirtyFlag;
    }

    public void resetWFStepActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStepActorName();
            return;
        }
        this.wfstepactornameDirtyFlag = false;
        this.wfstepactorname = null;
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

    @Override
    protected void onReset() {
        WFStepActorBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActorIdDirty()) {
            params.put(FIELD_ACTORID, this.getActorId());
        }
        if (!bDirtyOnly || this.isActorTypeDirty()) {
            params.put(FIELD_ACTORTYPE, this.getActorType());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isFinishDateDirty()) {
            params.put(FIELD_FINISHDATE, this.getFinishDate());
        }
        if (!bDirtyOnly || this.isFirstReadTimeDirty()) {
            params.put(FIELD_FIRSTREADTIME, this.getFirstReadTime());
        }
        if (!bDirtyOnly || this.isIAActionsDirty()) {
            params.put(FIELD_IAACTIONS, this.getIAActions());
        }
        if (!bDirtyOnly || this.isIsFinishDirty()) {
            params.put(FIELD_ISFINISH, this.getIsFinish());
        }
        if (!bDirtyOnly || this.isIsReadOnlyDirty()) {
            params.put(FIELD_ISREADONLY, this.getIsReadOnly());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOriginalWFUserIdDirty()) {
            params.put(FIELD_ORIGINALWFUSERID, this.getOriginalWFUserId());
        }
        if (!bDirtyOnly || this.isOriginalWFUserNameDirty()) {
            params.put(FIELD_ORIGINALWFUSERNAME, this.getOriginalWFUserName());
        }
        if (!bDirtyOnly || this.isReadFlagDirty()) {
            params.put(FIELD_READFLAG, this.getReadFlag());
        }
        if (!bDirtyOnly || this.isReminderCountDirty()) {
            params.put(FIELD_REMINDERCOUNT, this.getReminderCount());
        }
        if (!bDirtyOnly || this.isRoleIdDirty()) {
            params.put(FIELD_ROLEID, this.getRoleId());
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
        if (!bDirtyOnly || this.isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID, this.getWFStepActorId());
        }
        if (!bDirtyOnly || this.isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME, this.getWFStepActorName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
        }
        if (!bDirtyOnly || this.isWFStepNameDirty()) {
            params.put(FIELD_WFSTEPNAME, this.getWFStepName());
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
        return WFStepActorBase.get(this, index);
    }

    private static Object get(WFStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActorId();
            }
            case 1: {
                return et.getActorType();
            }
            case 2: {
                return et.getCreateDate();
            }
            case 3: {
                return et.getCreateMan();
            }
            case 4: {
                return et.getFinishDate();
            }
            case 5: {
                return et.getFirstReadTime();
            }
            case 6: {
                return et.getIAActions();
            }
            case 7: {
                return et.getIsFinish();
            }
            case 8: {
                return et.getIsReadOnly();
            }
            case 9: {
                return et.getMemo();
            }
            case 10: {
                return et.getOriginalWFUserId();
            }
            case 11: {
                return et.getOriginalWFUserName();
            }
            case 12: {
                return et.getReadFlag();
            }
            case 13: {
                return et.getReminderCount();
            }
            case 14: {
                return et.getRoleId();
            }
            case 15: {
                return et.getUpdateDate();
            }
            case 16: {
                return et.getUpdateMan();
            }
            case 17: {
                return et.getWFInstanceId();
            }
            case 18: {
                return et.getWFStepActorId();
            }
            case 19: {
                return et.getWFStepActorName();
            }
            case 20: {
                return et.getWFStepId();
            }
            case 21: {
                return et.getWFStepName();
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
        WFStepActorBase.set(this, index, objValue);
    }

    private static void set(WFStepActorBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActorId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setActorType(DataObject.getIntegerValue(obj));
                return;
            }
            case 2: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setFinishDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 5: {
                et.setFirstReadTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setIAActions(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setIsFinish(DataObject.getIntegerValue(obj));
                return;
            }
            case 8: {
                et.setIsReadOnly(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setOriginalWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setOriginalWFUserName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setReadFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setReminderCount(DataObject.getIntegerValue(obj));
                return;
            }
            case 14: {
                et.setRoleId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 16: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setWFStepActorId(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setWFStepActorName(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 21: {
                et.setWFStepName(DataObject.getStringValue(obj));
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
        return WFStepActorBase.isNull(this, index);
    }

    private static boolean isNull(WFStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActorId() == null;
            }
            case 1: {
                return et.getActorType() == null;
            }
            case 2: {
                return et.getCreateDate() == null;
            }
            case 3: {
                return et.getCreateMan() == null;
            }
            case 4: {
                return et.getFinishDate() == null;
            }
            case 5: {
                return et.getFirstReadTime() == null;
            }
            case 6: {
                return et.getIAActions() == null;
            }
            case 7: {
                return et.getIsFinish() == null;
            }
            case 8: {
                return et.getIsReadOnly() == null;
            }
            case 9: {
                return et.getMemo() == null;
            }
            case 10: {
                return et.getOriginalWFUserId() == null;
            }
            case 11: {
                return et.getOriginalWFUserName() == null;
            }
            case 12: {
                return et.getReadFlag() == null;
            }
            case 13: {
                return et.getReminderCount() == null;
            }
            case 14: {
                return et.getRoleId() == null;
            }
            case 15: {
                return et.getUpdateDate() == null;
            }
            case 16: {
                return et.getUpdateMan() == null;
            }
            case 17: {
                return et.getWFInstanceId() == null;
            }
            case 18: {
                return et.getWFStepActorId() == null;
            }
            case 19: {
                return et.getWFStepActorName() == null;
            }
            case 20: {
                return et.getWFStepId() == null;
            }
            case 21: {
                return et.getWFStepName() == null;
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
        return WFStepActorBase.contains(this, index);
    }

    private static boolean contains(WFStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActorIdDirty();
            }
            case 1: {
                return et.isActorTypeDirty();
            }
            case 2: {
                return et.isCreateDateDirty();
            }
            case 3: {
                return et.isCreateManDirty();
            }
            case 4: {
                return et.isFinishDateDirty();
            }
            case 5: {
                return et.isFirstReadTimeDirty();
            }
            case 6: {
                return et.isIAActionsDirty();
            }
            case 7: {
                return et.isIsFinishDirty();
            }
            case 8: {
                return et.isIsReadOnlyDirty();
            }
            case 9: {
                return et.isMemoDirty();
            }
            case 10: {
                return et.isOriginalWFUserIdDirty();
            }
            case 11: {
                return et.isOriginalWFUserNameDirty();
            }
            case 12: {
                return et.isReadFlagDirty();
            }
            case 13: {
                return et.isReminderCountDirty();
            }
            case 14: {
                return et.isRoleIdDirty();
            }
            case 15: {
                return et.isUpdateDateDirty();
            }
            case 16: {
                return et.isUpdateManDirty();
            }
            case 17: {
                return et.isWFInstanceIdDirty();
            }
            case 18: {
                return et.isWFStepActorIdDirty();
            }
            case 19: {
                return et.isWFStepActorNameDirty();
            }
            case 20: {
                return et.isWFStepIdDirty();
            }
            case 21: {
                return et.isWFStepNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFStepActorBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFStepActorBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActorId() != null) {
            JSONObjectHelper.put(json, "actorid", WFStepActorBase.getJSONValue(et.getActorId()), false);
        }
        if (bIncEmpty || et.getActorType() != null) {
            JSONObjectHelper.put(json, "actortype", WFStepActorBase.getJSONValue(et.getActorType()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFStepActorBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFStepActorBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getFinishDate() != null) {
            JSONObjectHelper.put(json, "finishdate", WFStepActorBase.getJSONValue(et.getFinishDate()), false);
        }
        if (bIncEmpty || et.getFirstReadTime() != null) {
            JSONObjectHelper.put(json, "firstreadtime", WFStepActorBase.getJSONValue(et.getFirstReadTime()), false);
        }
        if (bIncEmpty || et.getIAActions() != null) {
            JSONObjectHelper.put(json, "iaactions", WFStepActorBase.getJSONValue(et.getIAActions()), false);
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            JSONObjectHelper.put(json, "isfinish", WFStepActorBase.getJSONValue(et.getIsFinish()), false);
        }
        if (bIncEmpty || et.getIsReadOnly() != null) {
            JSONObjectHelper.put(json, "isreadonly", WFStepActorBase.getJSONValue(et.getIsReadOnly()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFStepActorBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            JSONObjectHelper.put(json, "originalwfuserid", WFStepActorBase.getJSONValue(et.getOriginalWFUserId()), false);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            JSONObjectHelper.put(json, "originalwfusername", WFStepActorBase.getJSONValue(et.getOriginalWFUserName()), false);
        }
        if (bIncEmpty || et.getReadFlag() != null) {
            JSONObjectHelper.put(json, "readflag", WFStepActorBase.getJSONValue(et.getReadFlag()), false);
        }
        if (bIncEmpty || et.getReminderCount() != null) {
            JSONObjectHelper.put(json, "remindercount", WFStepActorBase.getJSONValue(et.getReminderCount()), false);
        }
        if (bIncEmpty || et.getRoleId() != null) {
            JSONObjectHelper.put(json, "roleid", WFStepActorBase.getJSONValue(et.getRoleId()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFStepActorBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFStepActorBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFStepActorBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFStepActorId() != null) {
            JSONObjectHelper.put(json, "wfstepactorid", WFStepActorBase.getJSONValue(et.getWFStepActorId()), false);
        }
        if (bIncEmpty || et.getWFStepActorName() != null) {
            JSONObjectHelper.put(json, "wfstepactorname", WFStepActorBase.getJSONValue(et.getWFStepActorName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFStepActorBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            JSONObjectHelper.put(json, "wfstepname", WFStepActorBase.getJSONValue(et.getWFStepName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFStepActorBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFStepActorBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActorId() != null) {
            obj = et.getActorId();
            node.setAttribute(FIELD_ACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getActorType() != null) {
            obj = et.getActorType();
            node.setAttribute(FIELD_ACTORTYPE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getFinishDate() != null) {
            obj = et.getFinishDate();
            node.setAttribute(FIELD_FINISHDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getFirstReadTime() != null) {
            obj = et.getFirstReadTime();
            node.setAttribute(FIELD_FIRSTREADTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getIAActions() != null) {
            obj = et.getIAActions();
            node.setAttribute(FIELD_IAACTIONS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            obj = et.getIsFinish();
            node.setAttribute(FIELD_ISFINISH, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsReadOnly() != null) {
            obj = et.getIsReadOnly();
            node.setAttribute(FIELD_ISREADONLY, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserId() != null) {
            obj = et.getOriginalWFUserId();
            node.setAttribute(FIELD_ORIGINALWFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOriginalWFUserName() != null) {
            obj = et.getOriginalWFUserName();
            node.setAttribute(FIELD_ORIGINALWFUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReadFlag() != null) {
            obj = et.getReadFlag();
            node.setAttribute(FIELD_READFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReminderCount() != null) {
            obj = et.getReminderCount();
            node.setAttribute(FIELD_REMINDERCOUNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getRoleId() != null) {
            obj = et.getRoleId();
            node.setAttribute(FIELD_ROLEID, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getWFStepActorId() != null) {
            obj = et.getWFStepActorId();
            node.setAttribute(FIELD_WFSTEPACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepActorName() != null) {
            obj = et.getWFStepActorName();
            node.setAttribute(FIELD_WFSTEPACTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            obj = et.getWFStepId();
            node.setAttribute(FIELD_WFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepName() != null) {
            obj = et.getWFStepName();
            node.setAttribute(FIELD_WFSTEPNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFStepActorBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFStepActorBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActorIdDirty() && (bIncEmpty || et.getActorId() != null)) {
            dst.set(FIELD_ACTORID, et.getActorId());
        }
        if (et.isActorTypeDirty() && (bIncEmpty || et.getActorType() != null)) {
            dst.set(FIELD_ACTORTYPE, et.getActorType());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isFinishDateDirty() && (bIncEmpty || et.getFinishDate() != null)) {
            dst.set(FIELD_FINISHDATE, et.getFinishDate());
        }
        if (et.isFirstReadTimeDirty() && (bIncEmpty || et.getFirstReadTime() != null)) {
            dst.set(FIELD_FIRSTREADTIME, et.getFirstReadTime());
        }
        if (et.isIAActionsDirty() && (bIncEmpty || et.getIAActions() != null)) {
            dst.set(FIELD_IAACTIONS, et.getIAActions());
        }
        if (et.isIsFinishDirty() && (bIncEmpty || et.getIsFinish() != null)) {
            dst.set(FIELD_ISFINISH, et.getIsFinish());
        }
        if (et.isIsReadOnlyDirty() && (bIncEmpty || et.getIsReadOnly() != null)) {
            dst.set(FIELD_ISREADONLY, et.getIsReadOnly());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOriginalWFUserIdDirty() && (bIncEmpty || et.getOriginalWFUserId() != null)) {
            dst.set(FIELD_ORIGINALWFUSERID, et.getOriginalWFUserId());
        }
        if (et.isOriginalWFUserNameDirty() && (bIncEmpty || et.getOriginalWFUserName() != null)) {
            dst.set(FIELD_ORIGINALWFUSERNAME, et.getOriginalWFUserName());
        }
        if (et.isReadFlagDirty() && (bIncEmpty || et.getReadFlag() != null)) {
            dst.set(FIELD_READFLAG, et.getReadFlag());
        }
        if (et.isReminderCountDirty() && (bIncEmpty || et.getReminderCount() != null)) {
            dst.set(FIELD_REMINDERCOUNT, et.getReminderCount());
        }
        if (et.isRoleIdDirty() && (bIncEmpty || et.getRoleId() != null)) {
            dst.set(FIELD_ROLEID, et.getRoleId());
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
        if (et.isWFStepActorIdDirty() && (bIncEmpty || et.getWFStepActorId() != null)) {
            dst.set(FIELD_WFSTEPACTORID, et.getWFStepActorId());
        }
        if (et.isWFStepActorNameDirty() && (bIncEmpty || et.getWFStepActorName() != null)) {
            dst.set(FIELD_WFSTEPACTORNAME, et.getWFStepActorName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
        }
        if (et.isWFStepNameDirty() && (bIncEmpty || et.getWFStepName() != null)) {
            dst.set(FIELD_WFSTEPNAME, et.getWFStepName());
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
        return WFStepActorBase.remove(this, index);
    }

    private static boolean remove(WFStepActorBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActorId();
                return true;
            }
            case 1: {
                et.resetActorType();
                return true;
            }
            case 2: {
                et.resetCreateDate();
                return true;
            }
            case 3: {
                et.resetCreateMan();
                return true;
            }
            case 4: {
                et.resetFinishDate();
                return true;
            }
            case 5: {
                et.resetFirstReadTime();
                return true;
            }
            case 6: {
                et.resetIAActions();
                return true;
            }
            case 7: {
                et.resetIsFinish();
                return true;
            }
            case 8: {
                et.resetIsReadOnly();
                return true;
            }
            case 9: {
                et.resetMemo();
                return true;
            }
            case 10: {
                et.resetOriginalWFUserId();
                return true;
            }
            case 11: {
                et.resetOriginalWFUserName();
                return true;
            }
            case 12: {
                et.resetReadFlag();
                return true;
            }
            case 13: {
                et.resetReminderCount();
                return true;
            }
            case 14: {
                et.resetRoleId();
                return true;
            }
            case 15: {
                et.resetUpdateDate();
                return true;
            }
            case 16: {
                et.resetUpdateMan();
                return true;
            }
            case 17: {
                et.resetWFInstanceId();
                return true;
            }
            case 18: {
                et.resetWFStepActorId();
                return true;
            }
            case 19: {
                et.resetWFStepActorName();
                return true;
            }
            case 20: {
                et.resetWFStepId();
                return true;
            }
            case 21: {
                et.resetWFStepName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStep getWFStep() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStep();
        }
        if (this.getWFStepId() == null) {
            return null;
        }
        Integer n = this.objWFStepLock;
        synchronized (n) {
            if (this.wfstep != null && DataTypeHelper.compare(25, (Object)this.getWFStepId(), (Object)this.wfstep.getWFStepId()) != 0L) {
                this.wfstep = null;
            }
            if (this.wfstep == null) {
                WFStep wfstep = new WFStep();
                wfstep.setWFStepId(this.getWFStepId());
                WFStepService service = (WFStepService)ServiceGlobal.getService(WFStepService.class, this.getSessionFactory());
                service.autoGet(wfstep);
                this.wfstep = wfstep;
            }
            return this.wfstep;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getOriginalWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOriginalWFUser();
        }
        if (this.getOriginalWFUserId() == null) {
            return null;
        }
        Integer n = this.objOriginalWFUserLock;
        synchronized (n) {
            if (this.originalwfuser != null && DataTypeHelper.compare(25, (Object)this.getOriginalWFUserId(), (Object)this.originalwfuser.getWFUserId()) != 0L) {
                this.originalwfuser = null;
            }
            if (this.originalwfuser == null) {
                WFUser originalwfuser = new WFUser();
                originalwfuser.setWFUserId(this.getOriginalWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(originalwfuser);
                this.originalwfuser = originalwfuser;
            }
            return this.originalwfuser;
        }
    }

    private WFStepActorBase getProxyEntity() {
        return this.proxyWFStepActorBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFStepActorBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFStepActorBase) {
            this.proxyWFStepActorBase = (WFStepActorBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFStepActorService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

