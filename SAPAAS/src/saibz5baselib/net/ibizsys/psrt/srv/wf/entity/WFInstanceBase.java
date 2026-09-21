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
import net.ibizsys.psrt.srv.common.entity.Org;
import net.ibizsys.psrt.srv.common.service.OrgService;
import net.ibizsys.psrt.srv.wf.entity.WFInstance;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFInstanceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFInstanceBase.class);
    public static final String FIELD_ACTIVESTEPID = "ACTIVESTEPID";
    public static final String FIELD_ACTIVESTEPNAME = "ACTIVESTEPNAME";
    public static final String FIELD_CANCELREASON = "CANCELREASON";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_ERRORINFO = "ERRORINFO";
    public static final String FIELD_IMPORTANCEFLAG = "IMPORTANCEFLAG";
    public static final String FIELD_ISCANCEL = "ISCANCEL";
    public static final String FIELD_ISCLOSE = "ISCLOSE";
    public static final String FIELD_ISERROR = "ISERROR";
    public static final String FIELD_ISFINISH = "ISFINISH";
    public static final String FIELD_LASTACTION = "LASTACTION";
    public static final String FIELD_LASTACTORID = "LASTACTORID";
    public static final String FIELD_LASTWFSTEPID = "LASTWFSTEPID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORGID = "ORGID";
    public static final String FIELD_ORGNAME = "ORGNAME";
    public static final String FIELD_OWNER = "OWNER";
    public static final String FIELD_PARALLELINST = "PARALLELINST";
    public static final String FIELD_PSTEPID = "PSTEPID";
    public static final String FIELD_PWFINSTANCEID = "PWFINSTANCEID";
    public static final String FIELD_PWFINSTANCENAME = "PWFINSTANCENAME";
    public static final String FIELD_RESULT = "RESULT";
    public static final String FIELD_STARTTIME = "STARTTIME";
    public static final String FIELD_SUSPENDFLAG = "SUSPENDFLAG";
    public static final String FIELD_TRACESTEP = "TRACESTEP";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_USERDATAINFO = "USERDATAINFO";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFMODEL = "WFMODEL";
    public static final String FIELD_WFVERSION = "WFVERSION";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_ACTIVESTEPID = 0;
    private static final int INDEX_ACTIVESTEPNAME = 1;
    private static final int INDEX_CANCELREASON = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_ENABLE = 5;
    private static final int INDEX_ENDTIME = 6;
    private static final int INDEX_ERRORINFO = 7;
    private static final int INDEX_IMPORTANCEFLAG = 8;
    private static final int INDEX_ISCANCEL = 9;
    private static final int INDEX_ISCLOSE = 10;
    private static final int INDEX_ISERROR = 11;
    private static final int INDEX_ISFINISH = 12;
    private static final int INDEX_LASTACTION = 13;
    private static final int INDEX_LASTACTORID = 14;
    private static final int INDEX_LASTWFSTEPID = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_ORGID = 17;
    private static final int INDEX_ORGNAME = 18;
    private static final int INDEX_OWNER = 19;
    private static final int INDEX_PARALLELINST = 20;
    private static final int INDEX_PSTEPID = 21;
    private static final int INDEX_PWFINSTANCEID = 22;
    private static final int INDEX_PWFINSTANCENAME = 23;
    private static final int INDEX_RESULT = 24;
    private static final int INDEX_STARTTIME = 25;
    private static final int INDEX_SUSPENDFLAG = 26;
    private static final int INDEX_TRACESTEP = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERDATA = 30;
    private static final int INDEX_USERDATA2 = 31;
    private static final int INDEX_USERDATA3 = 32;
    private static final int INDEX_USERDATA4 = 33;
    private static final int INDEX_USERDATAINFO = 34;
    private static final int INDEX_USERTAG = 35;
    private static final int INDEX_USERTAG2 = 36;
    private static final int INDEX_WFINSTANCEID = 37;
    private static final int INDEX_WFINSTANCENAME = 38;
    private static final int INDEX_WFMODEL = 39;
    private static final int INDEX_WFVERSION = 40;
    private static final int INDEX_WFWORKFLOWID = 41;
    private static final int INDEX_WFWORKFLOWNAME = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFInstanceBase proxyWFInstanceBase = null;
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
    private Integer objOrgLock = new Integer(1);
    private Org org = null;
    private Integer objPWFInstanceLock = new Integer(1);
    private WFInstance pwfinstance = null;
    private Integer objWFWorkflowLock = new Integer(1);
    private WFWorkflow wfworkflow = null;

    static {
        fieldIndexMap.put(FIELD_ACTIVESTEPID, 0);
        fieldIndexMap.put(FIELD_ACTIVESTEPNAME, 1);
        fieldIndexMap.put(FIELD_CANCELREASON, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_ENABLE, 5);
        fieldIndexMap.put(FIELD_ENDTIME, 6);
        fieldIndexMap.put(FIELD_ERRORINFO, 7);
        fieldIndexMap.put(FIELD_IMPORTANCEFLAG, 8);
        fieldIndexMap.put(FIELD_ISCANCEL, 9);
        fieldIndexMap.put(FIELD_ISCLOSE, 10);
        fieldIndexMap.put(FIELD_ISERROR, 11);
        fieldIndexMap.put(FIELD_ISFINISH, 12);
        fieldIndexMap.put(FIELD_LASTACTION, 13);
        fieldIndexMap.put(FIELD_LASTACTORID, 14);
        fieldIndexMap.put(FIELD_LASTWFSTEPID, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_ORGID, 17);
        fieldIndexMap.put(FIELD_ORGNAME, 18);
        fieldIndexMap.put(FIELD_OWNER, 19);
        fieldIndexMap.put(FIELD_PARALLELINST, 20);
        fieldIndexMap.put(FIELD_PSTEPID, 21);
        fieldIndexMap.put(FIELD_PWFINSTANCEID, 22);
        fieldIndexMap.put(FIELD_PWFINSTANCENAME, 23);
        fieldIndexMap.put(FIELD_RESULT, 24);
        fieldIndexMap.put(FIELD_STARTTIME, 25);
        fieldIndexMap.put(FIELD_SUSPENDFLAG, 26);
        fieldIndexMap.put(FIELD_TRACESTEP, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERDATA, 30);
        fieldIndexMap.put(FIELD_USERDATA2, 31);
        fieldIndexMap.put(FIELD_USERDATA3, 32);
        fieldIndexMap.put(FIELD_USERDATA4, 33);
        fieldIndexMap.put(FIELD_USERDATAINFO, 34);
        fieldIndexMap.put(FIELD_USERTAG, 35);
        fieldIndexMap.put(FIELD_USERTAG2, 36);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 37);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 38);
        fieldIndexMap.put(FIELD_WFMODEL, 39);
        fieldIndexMap.put(FIELD_WFVERSION, 40);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 41);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 42);
    }

    public void setActiveStepId(String activestepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActiveStepId(activestepid);
            return;
        }
        if (activestepid != null && (activestepid = StringHelper.trimRight(activestepid)).length() == 0) {
            activestepid = null;
        }
        this.activestepid = activestepid;
        this.activestepidDirtyFlag = true;
    }

    public String getActiveStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActiveStepId();
        }
        return this.activestepid;
    }

    public boolean isActiveStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActiveStepIdDirty();
        }
        return this.activestepidDirtyFlag;
    }

    public void resetActiveStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActiveStepId();
            return;
        }
        this.activestepidDirtyFlag = false;
        this.activestepid = null;
    }

    public void setActiveStepName(String activestepname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActiveStepName(activestepname);
            return;
        }
        if (activestepname != null && (activestepname = StringHelper.trimRight(activestepname)).length() == 0) {
            activestepname = null;
        }
        this.activestepname = activestepname;
        this.activestepnameDirtyFlag = true;
    }

    public String getActiveStepName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActiveStepName();
        }
        return this.activestepname;
    }

    public boolean isActiveStepNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActiveStepNameDirty();
        }
        return this.activestepnameDirtyFlag;
    }

    public void resetActiveStepName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActiveStepName();
            return;
        }
        this.activestepnameDirtyFlag = false;
        this.activestepname = null;
    }

    public void setCancelReason(String cancelreason) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCancelReason(cancelreason);
            return;
        }
        if (cancelreason != null && (cancelreason = StringHelper.trimRight(cancelreason)).length() == 0) {
            cancelreason = null;
        }
        this.cancelreason = cancelreason;
        this.cancelreasonDirtyFlag = true;
    }

    public String getCancelReason() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCancelReason();
        }
        return this.cancelreason;
    }

    public boolean isCancelReasonDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCancelReasonDirty();
        }
        return this.cancelreasonDirtyFlag;
    }

    public void resetCancelReason() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCancelReason();
            return;
        }
        this.cancelreasonDirtyFlag = false;
        this.cancelreason = null;
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

    public void setEnable(Integer enable) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(enable);
            return;
        }
        this.enable = enable;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
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

    public void setErrorInfo(String errorinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorInfo(errorinfo);
            return;
        }
        if (errorinfo != null && (errorinfo = StringHelper.trimRight(errorinfo)).length() == 0) {
            errorinfo = null;
        }
        this.errorinfo = errorinfo;
        this.errorinfoDirtyFlag = true;
    }

    public String getErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorInfo();
        }
        return this.errorinfo;
    }

    public boolean isErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorInfoDirty();
        }
        return this.errorinfoDirtyFlag;
    }

    public void resetErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorInfo();
            return;
        }
        this.errorinfoDirtyFlag = false;
        this.errorinfo = null;
    }

    public void setImportanceFlag(Integer importanceflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImportanceFlag(importanceflag);
            return;
        }
        this.importanceflag = importanceflag;
        this.importanceflagDirtyFlag = true;
    }

    public Integer getImportanceFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImportanceFlag();
        }
        return this.importanceflag;
    }

    public boolean isImportanceFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImportanceFlagDirty();
        }
        return this.importanceflagDirtyFlag;
    }

    public void resetImportanceFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImportanceFlag();
            return;
        }
        this.importanceflagDirtyFlag = false;
        this.importanceflag = null;
    }

    public void setIsCancel(Integer iscancel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsCancel(iscancel);
            return;
        }
        this.iscancel = iscancel;
        this.iscancelDirtyFlag = true;
    }

    public Integer getIsCancel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsCancel();
        }
        return this.iscancel;
    }

    public boolean isIsCancelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsCancelDirty();
        }
        return this.iscancelDirtyFlag;
    }

    public void resetIsCancel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsCancel();
            return;
        }
        this.iscancelDirtyFlag = false;
        this.iscancel = null;
    }

    public void setIsClose(Integer isclose) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsClose(isclose);
            return;
        }
        this.isclose = isclose;
        this.iscloseDirtyFlag = true;
    }

    public Integer getIsClose() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsClose();
        }
        return this.isclose;
    }

    public boolean isIsCloseDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsCloseDirty();
        }
        return this.iscloseDirtyFlag;
    }

    public void resetIsClose() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsClose();
            return;
        }
        this.iscloseDirtyFlag = false;
        this.isclose = null;
    }

    public void setIsError(Integer iserror) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIsError(iserror);
            return;
        }
        this.iserror = iserror;
        this.iserrorDirtyFlag = true;
    }

    public Integer getIsError() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIsError();
        }
        return this.iserror;
    }

    public boolean isIsErrorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIsErrorDirty();
        }
        return this.iserrorDirtyFlag;
    }

    public void resetIsError() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIsError();
            return;
        }
        this.iserrorDirtyFlag = false;
        this.iserror = null;
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

    public void setLastAction(String lastaction) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastAction(lastaction);
            return;
        }
        if (lastaction != null && (lastaction = StringHelper.trimRight(lastaction)).length() == 0) {
            lastaction = null;
        }
        this.lastaction = lastaction;
        this.lastactionDirtyFlag = true;
    }

    public String getLastAction() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastAction();
        }
        return this.lastaction;
    }

    public boolean isLastActionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastActionDirty();
        }
        return this.lastactionDirtyFlag;
    }

    public void resetLastAction() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastAction();
            return;
        }
        this.lastactionDirtyFlag = false;
        this.lastaction = null;
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

    public void setLastWFStepId(String lastwfstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastWFStepId(lastwfstepid);
            return;
        }
        if (lastwfstepid != null && (lastwfstepid = StringHelper.trimRight(lastwfstepid)).length() == 0) {
            lastwfstepid = null;
        }
        this.lastwfstepid = lastwfstepid;
        this.lastwfstepidDirtyFlag = true;
    }

    public String getLastWFStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastWFStepId();
        }
        return this.lastwfstepid;
    }

    public boolean isLastWFStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastWFStepIdDirty();
        }
        return this.lastwfstepidDirtyFlag;
    }

    public void resetLastWFStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastWFStepId();
            return;
        }
        this.lastwfstepidDirtyFlag = false;
        this.lastwfstepid = null;
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

    public void setOrgId(String orgid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgId(orgid);
            return;
        }
        if (orgid != null && (orgid = StringHelper.trimRight(orgid)).length() == 0) {
            orgid = null;
        }
        this.orgid = orgid;
        this.orgidDirtyFlag = true;
    }

    public String getOrgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgId();
        }
        return this.orgid;
    }

    public boolean isOrgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgIdDirty();
        }
        return this.orgidDirtyFlag;
    }

    public void resetOrgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgId();
            return;
        }
        this.orgidDirtyFlag = false;
        this.orgid = null;
    }

    public void setOrgName(String orgname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrgName(orgname);
            return;
        }
        if (orgname != null && (orgname = StringHelper.trimRight(orgname)).length() == 0) {
            orgname = null;
        }
        this.orgname = orgname;
        this.orgnameDirtyFlag = true;
    }

    public String getOrgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrgName();
        }
        return this.orgname;
    }

    public boolean isOrgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrgNameDirty();
        }
        return this.orgnameDirtyFlag;
    }

    public void resetOrgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrgName();
            return;
        }
        this.orgnameDirtyFlag = false;
        this.orgname = null;
    }

    public void setOwner(String owner) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwner(owner);
            return;
        }
        if (owner != null && (owner = StringHelper.trimRight(owner)).length() == 0) {
            owner = null;
        }
        this.owner = owner;
        this.ownerDirtyFlag = true;
    }

    public String getOwner() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwner();
        }
        return this.owner;
    }

    public boolean isOwnerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerDirty();
        }
        return this.ownerDirtyFlag;
    }

    public void resetOwner() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwner();
            return;
        }
        this.ownerDirtyFlag = false;
        this.owner = null;
    }

    public void setParallelInst(Integer parallelinst) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParallelInst(parallelinst);
            return;
        }
        this.parallelinst = parallelinst;
        this.parallelinstDirtyFlag = true;
    }

    public Integer getParallelInst() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParallelInst();
        }
        return this.parallelinst;
    }

    public boolean isParallelInstDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParallelInstDirty();
        }
        return this.parallelinstDirtyFlag;
    }

    public void resetParallelInst() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParallelInst();
            return;
        }
        this.parallelinstDirtyFlag = false;
        this.parallelinst = null;
    }

    public void setPStepId(String pstepid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPStepId(pstepid);
            return;
        }
        if (pstepid != null && (pstepid = StringHelper.trimRight(pstepid)).length() == 0) {
            pstepid = null;
        }
        this.pstepid = pstepid;
        this.pstepidDirtyFlag = true;
    }

    public String getPStepId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPStepId();
        }
        return this.pstepid;
    }

    public boolean isPStepIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPStepIdDirty();
        }
        return this.pstepidDirtyFlag;
    }

    public void resetPStepId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPStepId();
            return;
        }
        this.pstepidDirtyFlag = false;
        this.pstepid = null;
    }

    public void setPWFInstanceId(String pwfinstanceid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPWFInstanceId(pwfinstanceid);
            return;
        }
        if (pwfinstanceid != null && (pwfinstanceid = StringHelper.trimRight(pwfinstanceid)).length() == 0) {
            pwfinstanceid = null;
        }
        this.pwfinstanceid = pwfinstanceid;
        this.pwfinstanceidDirtyFlag = true;
    }

    public String getPWFInstanceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstanceId();
        }
        return this.pwfinstanceid;
    }

    public boolean isPWFInstanceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPWFInstanceIdDirty();
        }
        return this.pwfinstanceidDirtyFlag;
    }

    public void resetPWFInstanceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPWFInstanceId();
            return;
        }
        this.pwfinstanceidDirtyFlag = false;
        this.pwfinstanceid = null;
    }

    public void setPWFInstanceName(String pwfinstancename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPWFInstanceName(pwfinstancename);
            return;
        }
        if (pwfinstancename != null && (pwfinstancename = StringHelper.trimRight(pwfinstancename)).length() == 0) {
            pwfinstancename = null;
        }
        this.pwfinstancename = pwfinstancename;
        this.pwfinstancenameDirtyFlag = true;
    }

    public String getPWFInstanceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstanceName();
        }
        return this.pwfinstancename;
    }

    public boolean isPWFInstanceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPWFInstanceNameDirty();
        }
        return this.pwfinstancenameDirtyFlag;
    }

    public void resetPWFInstanceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPWFInstanceName();
            return;
        }
        this.pwfinstancenameDirtyFlag = false;
        this.pwfinstancename = null;
    }

    public void setResult(String result) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setResult(result);
            return;
        }
        if (result != null && (result = StringHelper.trimRight(result)).length() == 0) {
            result = null;
        }
        this.result = result;
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

    public void setSuspendFlag(Integer suspendflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSuspendFlag(suspendflag);
            return;
        }
        this.suspendflag = suspendflag;
        this.suspendflagDirtyFlag = true;
    }

    public Integer getSuspendFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSuspendFlag();
        }
        return this.suspendflag;
    }

    public boolean isSuspendFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSuspendFlagDirty();
        }
        return this.suspendflagDirtyFlag;
    }

    public void resetSuspendFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSuspendFlag();
            return;
        }
        this.suspendflagDirtyFlag = false;
        this.suspendflag = null;
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

    public void setUserData(String userdata) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(userdata);
            return;
        }
        if (userdata != null && (userdata = StringHelper.trimRight(userdata)).length() == 0) {
            userdata = null;
        }
        this.userdata = userdata;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String userdata2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(userdata2);
            return;
        }
        if (userdata2 != null && (userdata2 = StringHelper.trimRight(userdata2)).length() == 0) {
            userdata2 = null;
        }
        this.userdata2 = userdata2;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserData3(String userdata3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData3(userdata3);
            return;
        }
        if (userdata3 != null && (userdata3 = StringHelper.trimRight(userdata3)).length() == 0) {
            userdata3 = null;
        }
        this.userdata3 = userdata3;
        this.userdata3DirtyFlag = true;
    }

    public String getUserData3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData3();
        }
        return this.userdata3;
    }

    public boolean isUserData3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData3Dirty();
        }
        return this.userdata3DirtyFlag;
    }

    public void resetUserData3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData3();
            return;
        }
        this.userdata3DirtyFlag = false;
        this.userdata3 = null;
    }

    public void setUserData4(String userdata4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData4(userdata4);
            return;
        }
        if (userdata4 != null && (userdata4 = StringHelper.trimRight(userdata4)).length() == 0) {
            userdata4 = null;
        }
        this.userdata4 = userdata4;
        this.userdata4DirtyFlag = true;
    }

    public String getUserData4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData4();
        }
        return this.userdata4;
    }

    public boolean isUserData4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData4Dirty();
        }
        return this.userdata4DirtyFlag;
    }

    public void resetUserData4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData4();
            return;
        }
        this.userdata4DirtyFlag = false;
        this.userdata4 = null;
    }

    public void setUserDataInfo(String userdatainfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserDataInfo(userdatainfo);
            return;
        }
        if (userdatainfo != null && (userdatainfo = StringHelper.trimRight(userdatainfo)).length() == 0) {
            userdatainfo = null;
        }
        this.userdatainfo = userdatainfo;
        this.userdatainfoDirtyFlag = true;
    }

    public String getUserDataInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserDataInfo();
        }
        return this.userdatainfo;
    }

    public boolean isUserDataInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataInfoDirty();
        }
        return this.userdatainfoDirtyFlag;
    }

    public void resetUserDataInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserDataInfo();
            return;
        }
        this.userdatainfoDirtyFlag = false;
        this.userdatainfo = null;
    }

    public void setUserTag(String usertag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(usertag);
            return;
        }
        if (usertag != null && (usertag = StringHelper.trimRight(usertag)).length() == 0) {
            usertag = null;
        }
        this.usertag = usertag;
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

    public void setUserTag2(String usertag2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(usertag2);
            return;
        }
        if (usertag2 != null && (usertag2 = StringHelper.trimRight(usertag2)).length() == 0) {
            usertag2 = null;
        }
        this.usertag2 = usertag2;
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

    public void setWFModel(String wfmodel) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFModel(wfmodel);
            return;
        }
        if (wfmodel != null && (wfmodel = StringHelper.trimRight(wfmodel)).length() == 0) {
            wfmodel = null;
        }
        this.wfmodel = wfmodel;
        this.wfmodelDirtyFlag = true;
    }

    public String getWFModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFModel();
        }
        return this.wfmodel;
    }

    public boolean isWFModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFModelDirty();
        }
        return this.wfmodelDirtyFlag;
    }

    public void resetWFModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFModel();
            return;
        }
        this.wfmodelDirtyFlag = false;
        this.wfmodel = null;
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

    public void setWFWorkflowId(String wfworkflowid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowId(wfworkflowid);
            return;
        }
        if (wfworkflowid != null && (wfworkflowid = StringHelper.trimRight(wfworkflowid)).length() == 0) {
            wfworkflowid = null;
        }
        this.wfworkflowid = wfworkflowid;
        this.wfworkflowidDirtyFlag = true;
    }

    public String getWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowId();
        }
        return this.wfworkflowid;
    }

    public boolean isWFWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowIdDirty();
        }
        return this.wfworkflowidDirtyFlag;
    }

    public void resetWFWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowId();
            return;
        }
        this.wfworkflowidDirtyFlag = false;
        this.wfworkflowid = null;
    }

    public void setWFWorkflowName(String wfworkflowname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFWorkflowName(wfworkflowname);
            return;
        }
        if (wfworkflowname != null && (wfworkflowname = StringHelper.trimRight(wfworkflowname)).length() == 0) {
            wfworkflowname = null;
        }
        this.wfworkflowname = wfworkflowname;
        this.wfworkflownameDirtyFlag = true;
    }

    public String getWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflowName();
        }
        return this.wfworkflowname;
    }

    public boolean isWFWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFWorkflowNameDirty();
        }
        return this.wfworkflownameDirtyFlag;
    }

    public void resetWFWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFWorkflowName();
            return;
        }
        this.wfworkflownameDirtyFlag = false;
        this.wfworkflowname = null;
    }

    @Override
    protected void onReset() {
        WFInstanceBase.resetAll(this);
        super.onReset();
    }

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

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActiveStepIdDirty()) {
            params.put(FIELD_ACTIVESTEPID, this.getActiveStepId());
        }
        if (!bDirtyOnly || this.isActiveStepNameDirty()) {
            params.put(FIELD_ACTIVESTEPNAME, this.getActiveStepName());
        }
        if (!bDirtyOnly || this.isCancelReasonDirty()) {
            params.put(FIELD_CANCELREASON, this.getCancelReason());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableDirty()) {
            params.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bDirtyOnly || this.isEndTimeDirty()) {
            params.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bDirtyOnly || this.isErrorInfoDirty()) {
            params.put(FIELD_ERRORINFO, this.getErrorInfo());
        }
        if (!bDirtyOnly || this.isImportanceFlagDirty()) {
            params.put(FIELD_IMPORTANCEFLAG, this.getImportanceFlag());
        }
        if (!bDirtyOnly || this.isIsCancelDirty()) {
            params.put(FIELD_ISCANCEL, this.getIsCancel());
        }
        if (!bDirtyOnly || this.isIsCloseDirty()) {
            params.put(FIELD_ISCLOSE, this.getIsClose());
        }
        if (!bDirtyOnly || this.isIsErrorDirty()) {
            params.put(FIELD_ISERROR, this.getIsError());
        }
        if (!bDirtyOnly || this.isIsFinishDirty()) {
            params.put(FIELD_ISFINISH, this.getIsFinish());
        }
        if (!bDirtyOnly || this.isLastActionDirty()) {
            params.put(FIELD_LASTACTION, this.getLastAction());
        }
        if (!bDirtyOnly || this.isLastActorIdDirty()) {
            params.put(FIELD_LASTACTORID, this.getLastActorId());
        }
        if (!bDirtyOnly || this.isLastWFStepIdDirty()) {
            params.put(FIELD_LASTWFSTEPID, this.getLastWFStepId());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isOrgIdDirty()) {
            params.put(FIELD_ORGID, this.getOrgId());
        }
        if (!bDirtyOnly || this.isOrgNameDirty()) {
            params.put(FIELD_ORGNAME, this.getOrgName());
        }
        if (!bDirtyOnly || this.isOwnerDirty()) {
            params.put(FIELD_OWNER, this.getOwner());
        }
        if (!bDirtyOnly || this.isParallelInstDirty()) {
            params.put(FIELD_PARALLELINST, this.getParallelInst());
        }
        if (!bDirtyOnly || this.isPStepIdDirty()) {
            params.put(FIELD_PSTEPID, this.getPStepId());
        }
        if (!bDirtyOnly || this.isPWFInstanceIdDirty()) {
            params.put(FIELD_PWFINSTANCEID, this.getPWFInstanceId());
        }
        if (!bDirtyOnly || this.isPWFInstanceNameDirty()) {
            params.put(FIELD_PWFINSTANCENAME, this.getPWFInstanceName());
        }
        if (!bDirtyOnly || this.isResultDirty()) {
            params.put(FIELD_RESULT, this.getResult());
        }
        if (!bDirtyOnly || this.isStartTimeDirty()) {
            params.put(FIELD_STARTTIME, this.getStartTime());
        }
        if (!bDirtyOnly || this.isSuspendFlagDirty()) {
            params.put(FIELD_SUSPENDFLAG, this.getSuspendFlag());
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
        if (!bDirtyOnly || this.isUserDataDirty()) {
            params.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bDirtyOnly || this.isUserData2Dirty()) {
            params.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bDirtyOnly || this.isUserData3Dirty()) {
            params.put(FIELD_USERDATA3, this.getUserData3());
        }
        if (!bDirtyOnly || this.isUserData4Dirty()) {
            params.put(FIELD_USERDATA4, this.getUserData4());
        }
        if (!bDirtyOnly || this.isUserDataInfoDirty()) {
            params.put(FIELD_USERDATAINFO, this.getUserDataInfo());
        }
        if (!bDirtyOnly || this.isUserTagDirty()) {
            params.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bDirtyOnly || this.isUserTag2Dirty()) {
            params.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bDirtyOnly || this.isWFInstanceIdDirty()) {
            params.put(FIELD_WFINSTANCEID, this.getWFInstanceId());
        }
        if (!bDirtyOnly || this.isWFInstanceNameDirty()) {
            params.put(FIELD_WFINSTANCENAME, this.getWFInstanceName());
        }
        if (!bDirtyOnly || this.isWFModelDirty()) {
            params.put(FIELD_WFMODEL, this.getWFModel());
        }
        if (!bDirtyOnly || this.isWFVersionDirty()) {
            params.put(FIELD_WFVERSION, this.getWFVersion());
        }
        if (!bDirtyOnly || this.isWFWorkflowIdDirty()) {
            params.put(FIELD_WFWORKFLOWID, this.getWFWorkflowId());
        }
        if (!bDirtyOnly || this.isWFWorkflowNameDirty()) {
            params.put(FIELD_WFWORKFLOWNAME, this.getWFWorkflowName());
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
        return WFInstanceBase.get(this, index);
    }

    private static Object get(WFInstanceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActiveStepId();
            }
            case 1: {
                return et.getActiveStepName();
            }
            case 2: {
                return et.getCancelReason();
            }
            case 3: {
                return et.getCreateDate();
            }
            case 4: {
                return et.getCreateMan();
            }
            case 5: {
                return et.getEnable();
            }
            case 6: {
                return et.getEndTime();
            }
            case 7: {
                return et.getErrorInfo();
            }
            case 8: {
                return et.getImportanceFlag();
            }
            case 9: {
                return et.getIsCancel();
            }
            case 10: {
                return et.getIsClose();
            }
            case 11: {
                return et.getIsError();
            }
            case 12: {
                return et.getIsFinish();
            }
            case 13: {
                return et.getLastAction();
            }
            case 14: {
                return et.getLastActorId();
            }
            case 15: {
                return et.getLastWFStepId();
            }
            case 16: {
                return et.getMemo();
            }
            case 17: {
                return et.getOrgId();
            }
            case 18: {
                return et.getOrgName();
            }
            case 19: {
                return et.getOwner();
            }
            case 20: {
                return et.getParallelInst();
            }
            case 21: {
                return et.getPStepId();
            }
            case 22: {
                return et.getPWFInstanceId();
            }
            case 23: {
                return et.getPWFInstanceName();
            }
            case 24: {
                return et.getResult();
            }
            case 25: {
                return et.getStartTime();
            }
            case 26: {
                return et.getSuspendFlag();
            }
            case 27: {
                return et.getTraceStep();
            }
            case 28: {
                return et.getUpdateDate();
            }
            case 29: {
                return et.getUpdateMan();
            }
            case 30: {
                return et.getUserData();
            }
            case 31: {
                return et.getUserData2();
            }
            case 32: {
                return et.getUserData3();
            }
            case 33: {
                return et.getUserData4();
            }
            case 34: {
                return et.getUserDataInfo();
            }
            case 35: {
                return et.getUserTag();
            }
            case 36: {
                return et.getUserTag2();
            }
            case 37: {
                return et.getWFInstanceId();
            }
            case 38: {
                return et.getWFInstanceName();
            }
            case 39: {
                return et.getWFModel();
            }
            case 40: {
                return et.getWFVersion();
            }
            case 41: {
                return et.getWFWorkflowId();
            }
            case 42: {
                return et.getWFWorkflowName();
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
        WFInstanceBase.set(this, index, objValue);
    }

    private static void set(WFInstanceBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActiveStepId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setActiveStepName(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setCancelReason(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setEnable(DataObject.getIntegerValue(obj));
                return;
            }
            case 6: {
                et.setEndTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setErrorInfo(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setImportanceFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 9: {
                et.setIsCancel(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setIsClose(DataObject.getIntegerValue(obj));
                return;
            }
            case 11: {
                et.setIsError(DataObject.getIntegerValue(obj));
                return;
            }
            case 12: {
                et.setIsFinish(DataObject.getIntegerValue(obj));
                return;
            }
            case 13: {
                et.setLastAction(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setLastActorId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setLastWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 17: {
                et.setOrgId(DataObject.getStringValue(obj));
                return;
            }
            case 18: {
                et.setOrgName(DataObject.getStringValue(obj));
                return;
            }
            case 19: {
                et.setOwner(DataObject.getStringValue(obj));
                return;
            }
            case 20: {
                et.setParallelInst(DataObject.getIntegerValue(obj));
                return;
            }
            case 21: {
                et.setPStepId(DataObject.getStringValue(obj));
                return;
            }
            case 22: {
                et.setPWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 23: {
                et.setPWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 24: {
                et.setResult(DataObject.getStringValue(obj));
                return;
            }
            case 25: {
                et.setStartTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 26: {
                et.setSuspendFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 27: {
                et.setTraceStep(DataObject.getIntegerValue(obj));
                return;
            }
            case 28: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 29: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 30: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 31: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 32: {
                et.setUserData3(DataObject.getStringValue(obj));
                return;
            }
            case 33: {
                et.setUserData4(DataObject.getStringValue(obj));
                return;
            }
            case 34: {
                et.setUserDataInfo(DataObject.getStringValue(obj));
                return;
            }
            case 35: {
                et.setUserTag(DataObject.getStringValue(obj));
                return;
            }
            case 36: {
                et.setUserTag2(DataObject.getStringValue(obj));
                return;
            }
            case 37: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 38: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 39: {
                et.setWFModel(DataObject.getStringValue(obj));
                return;
            }
            case 40: {
                et.setWFVersion(DataObject.getIntegerValue(obj));
                return;
            }
            case 41: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 42: {
                et.setWFWorkflowName(DataObject.getStringValue(obj));
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
        return WFInstanceBase.isNull(this, index);
    }

    private static boolean isNull(WFInstanceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActiveStepId() == null;
            }
            case 1: {
                return et.getActiveStepName() == null;
            }
            case 2: {
                return et.getCancelReason() == null;
            }
            case 3: {
                return et.getCreateDate() == null;
            }
            case 4: {
                return et.getCreateMan() == null;
            }
            case 5: {
                return et.getEnable() == null;
            }
            case 6: {
                return et.getEndTime() == null;
            }
            case 7: {
                return et.getErrorInfo() == null;
            }
            case 8: {
                return et.getImportanceFlag() == null;
            }
            case 9: {
                return et.getIsCancel() == null;
            }
            case 10: {
                return et.getIsClose() == null;
            }
            case 11: {
                return et.getIsError() == null;
            }
            case 12: {
                return et.getIsFinish() == null;
            }
            case 13: {
                return et.getLastAction() == null;
            }
            case 14: {
                return et.getLastActorId() == null;
            }
            case 15: {
                return et.getLastWFStepId() == null;
            }
            case 16: {
                return et.getMemo() == null;
            }
            case 17: {
                return et.getOrgId() == null;
            }
            case 18: {
                return et.getOrgName() == null;
            }
            case 19: {
                return et.getOwner() == null;
            }
            case 20: {
                return et.getParallelInst() == null;
            }
            case 21: {
                return et.getPStepId() == null;
            }
            case 22: {
                return et.getPWFInstanceId() == null;
            }
            case 23: {
                return et.getPWFInstanceName() == null;
            }
            case 24: {
                return et.getResult() == null;
            }
            case 25: {
                return et.getStartTime() == null;
            }
            case 26: {
                return et.getSuspendFlag() == null;
            }
            case 27: {
                return et.getTraceStep() == null;
            }
            case 28: {
                return et.getUpdateDate() == null;
            }
            case 29: {
                return et.getUpdateMan() == null;
            }
            case 30: {
                return et.getUserData() == null;
            }
            case 31: {
                return et.getUserData2() == null;
            }
            case 32: {
                return et.getUserData3() == null;
            }
            case 33: {
                return et.getUserData4() == null;
            }
            case 34: {
                return et.getUserDataInfo() == null;
            }
            case 35: {
                return et.getUserTag() == null;
            }
            case 36: {
                return et.getUserTag2() == null;
            }
            case 37: {
                return et.getWFInstanceId() == null;
            }
            case 38: {
                return et.getWFInstanceName() == null;
            }
            case 39: {
                return et.getWFModel() == null;
            }
            case 40: {
                return et.getWFVersion() == null;
            }
            case 41: {
                return et.getWFWorkflowId() == null;
            }
            case 42: {
                return et.getWFWorkflowName() == null;
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
        return WFInstanceBase.contains(this, index);
    }

    private static boolean contains(WFInstanceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActiveStepIdDirty();
            }
            case 1: {
                return et.isActiveStepNameDirty();
            }
            case 2: {
                return et.isCancelReasonDirty();
            }
            case 3: {
                return et.isCreateDateDirty();
            }
            case 4: {
                return et.isCreateManDirty();
            }
            case 5: {
                return et.isEnableDirty();
            }
            case 6: {
                return et.isEndTimeDirty();
            }
            case 7: {
                return et.isErrorInfoDirty();
            }
            case 8: {
                return et.isImportanceFlagDirty();
            }
            case 9: {
                return et.isIsCancelDirty();
            }
            case 10: {
                return et.isIsCloseDirty();
            }
            case 11: {
                return et.isIsErrorDirty();
            }
            case 12: {
                return et.isIsFinishDirty();
            }
            case 13: {
                return et.isLastActionDirty();
            }
            case 14: {
                return et.isLastActorIdDirty();
            }
            case 15: {
                return et.isLastWFStepIdDirty();
            }
            case 16: {
                return et.isMemoDirty();
            }
            case 17: {
                return et.isOrgIdDirty();
            }
            case 18: {
                return et.isOrgNameDirty();
            }
            case 19: {
                return et.isOwnerDirty();
            }
            case 20: {
                return et.isParallelInstDirty();
            }
            case 21: {
                return et.isPStepIdDirty();
            }
            case 22: {
                return et.isPWFInstanceIdDirty();
            }
            case 23: {
                return et.isPWFInstanceNameDirty();
            }
            case 24: {
                return et.isResultDirty();
            }
            case 25: {
                return et.isStartTimeDirty();
            }
            case 26: {
                return et.isSuspendFlagDirty();
            }
            case 27: {
                return et.isTraceStepDirty();
            }
            case 28: {
                return et.isUpdateDateDirty();
            }
            case 29: {
                return et.isUpdateManDirty();
            }
            case 30: {
                return et.isUserDataDirty();
            }
            case 31: {
                return et.isUserData2Dirty();
            }
            case 32: {
                return et.isUserData3Dirty();
            }
            case 33: {
                return et.isUserData4Dirty();
            }
            case 34: {
                return et.isUserDataInfoDirty();
            }
            case 35: {
                return et.isUserTagDirty();
            }
            case 36: {
                return et.isUserTag2Dirty();
            }
            case 37: {
                return et.isWFInstanceIdDirty();
            }
            case 38: {
                return et.isWFInstanceNameDirty();
            }
            case 39: {
                return et.isWFModelDirty();
            }
            case 40: {
                return et.isWFVersionDirty();
            }
            case 41: {
                return et.isWFWorkflowIdDirty();
            }
            case 42: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFInstanceBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFInstanceBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActiveStepId() != null) {
            JSONObjectHelper.put(json, "activestepid", WFInstanceBase.getJSONValue(et.getActiveStepId()), false);
        }
        if (bIncEmpty || et.getActiveStepName() != null) {
            JSONObjectHelper.put(json, "activestepname", WFInstanceBase.getJSONValue(et.getActiveStepName()), false);
        }
        if (bIncEmpty || et.getCancelReason() != null) {
            JSONObjectHelper.put(json, "cancelreason", WFInstanceBase.getJSONValue(et.getCancelReason()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFInstanceBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFInstanceBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnable() != null) {
            JSONObjectHelper.put(json, "enable", WFInstanceBase.getJSONValue(et.getEnable()), false);
        }
        if (bIncEmpty || et.getEndTime() != null) {
            JSONObjectHelper.put(json, "endtime", WFInstanceBase.getJSONValue(et.getEndTime()), false);
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            JSONObjectHelper.put(json, "errorinfo", WFInstanceBase.getJSONValue(et.getErrorInfo()), false);
        }
        if (bIncEmpty || et.getImportanceFlag() != null) {
            JSONObjectHelper.put(json, "importanceflag", WFInstanceBase.getJSONValue(et.getImportanceFlag()), false);
        }
        if (bIncEmpty || et.getIsCancel() != null) {
            JSONObjectHelper.put(json, "iscancel", WFInstanceBase.getJSONValue(et.getIsCancel()), false);
        }
        if (bIncEmpty || et.getIsClose() != null) {
            JSONObjectHelper.put(json, "isclose", WFInstanceBase.getJSONValue(et.getIsClose()), false);
        }
        if (bIncEmpty || et.getIsError() != null) {
            JSONObjectHelper.put(json, "iserror", WFInstanceBase.getJSONValue(et.getIsError()), false);
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            JSONObjectHelper.put(json, "isfinish", WFInstanceBase.getJSONValue(et.getIsFinish()), false);
        }
        if (bIncEmpty || et.getLastAction() != null) {
            JSONObjectHelper.put(json, "lastaction", WFInstanceBase.getJSONValue(et.getLastAction()), false);
        }
        if (bIncEmpty || et.getLastActorId() != null) {
            JSONObjectHelper.put(json, "lastactorid", WFInstanceBase.getJSONValue(et.getLastActorId()), false);
        }
        if (bIncEmpty || et.getLastWFStepId() != null) {
            JSONObjectHelper.put(json, "lastwfstepid", WFInstanceBase.getJSONValue(et.getLastWFStepId()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFInstanceBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getOrgId() != null) {
            JSONObjectHelper.put(json, "orgid", WFInstanceBase.getJSONValue(et.getOrgId()), false);
        }
        if (bIncEmpty || et.getOrgName() != null) {
            JSONObjectHelper.put(json, "orgname", WFInstanceBase.getJSONValue(et.getOrgName()), false);
        }
        if (bIncEmpty || et.getOwner() != null) {
            JSONObjectHelper.put(json, "owner", WFInstanceBase.getJSONValue(et.getOwner()), false);
        }
        if (bIncEmpty || et.getParallelInst() != null) {
            JSONObjectHelper.put(json, "parallelinst", WFInstanceBase.getJSONValue(et.getParallelInst()), false);
        }
        if (bIncEmpty || et.getPStepId() != null) {
            JSONObjectHelper.put(json, "pstepid", WFInstanceBase.getJSONValue(et.getPStepId()), false);
        }
        if (bIncEmpty || et.getPWFInstanceId() != null) {
            JSONObjectHelper.put(json, "pwfinstanceid", WFInstanceBase.getJSONValue(et.getPWFInstanceId()), false);
        }
        if (bIncEmpty || et.getPWFInstanceName() != null) {
            JSONObjectHelper.put(json, "pwfinstancename", WFInstanceBase.getJSONValue(et.getPWFInstanceName()), false);
        }
        if (bIncEmpty || et.getResult() != null) {
            JSONObjectHelper.put(json, "result", WFInstanceBase.getJSONValue(et.getResult()), false);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            JSONObjectHelper.put(json, "starttime", WFInstanceBase.getJSONValue(et.getStartTime()), false);
        }
        if (bIncEmpty || et.getSuspendFlag() != null) {
            JSONObjectHelper.put(json, "suspendflag", WFInstanceBase.getJSONValue(et.getSuspendFlag()), false);
        }
        if (bIncEmpty || et.getTraceStep() != null) {
            JSONObjectHelper.put(json, "tracestep", WFInstanceBase.getJSONValue(et.getTraceStep()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFInstanceBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFInstanceBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFInstanceBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", WFInstanceBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            JSONObjectHelper.put(json, "userdata3", WFInstanceBase.getJSONValue(et.getUserData3()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", WFInstanceBase.getJSONValue(et.getUserData4()), false);
        }
        if (bIncEmpty || et.getUserDataInfo() != null) {
            JSONObjectHelper.put(json, "userdatainfo", WFInstanceBase.getJSONValue(et.getUserDataInfo()), false);
        }
        if (bIncEmpty || et.getUserTag() != null) {
            JSONObjectHelper.put(json, "usertag", WFInstanceBase.getJSONValue(et.getUserTag()), false);
        }
        if (bIncEmpty || et.getUserTag2() != null) {
            JSONObjectHelper.put(json, "usertag2", WFInstanceBase.getJSONValue(et.getUserTag2()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFInstanceBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFInstanceBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            JSONObjectHelper.put(json, "wfmodel", WFInstanceBase.getJSONValue(et.getWFModel()), false);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            JSONObjectHelper.put(json, "wfversion", WFInstanceBase.getJSONValue(et.getWFVersion()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFInstanceBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFInstanceBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFInstanceBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFInstanceBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActiveStepId() != null) {
            obj = et.getActiveStepId();
            node.setAttribute(FIELD_ACTIVESTEPID, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getActiveStepName() != null) {
            obj = et.getActiveStepName();
            node.setAttribute(FIELD_ACTIVESTEPNAME, (String)(obj == null ? "" : obj));
        }
        if (bIncEmpty || et.getCancelReason() != null) {
            obj = et.getCancelReason();
            node.setAttribute(FIELD_CANCELREASON, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnable() != null) {
            obj = et.getEnable();
            node.setAttribute(FIELD_ENABLE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getEndTime() != null) {
            obj = et.getEndTime();
            node.setAttribute(FIELD_ENDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getErrorInfo() != null) {
            obj = et.getErrorInfo();
            node.setAttribute(FIELD_ERRORINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getImportanceFlag() != null) {
            obj = et.getImportanceFlag();
            node.setAttribute(FIELD_IMPORTANCEFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsCancel() != null) {
            obj = et.getIsCancel();
            node.setAttribute(FIELD_ISCANCEL, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsClose() != null) {
            obj = et.getIsClose();
            node.setAttribute(FIELD_ISCLOSE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsError() != null) {
            obj = et.getIsError();
            node.setAttribute(FIELD_ISERROR, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getIsFinish() != null) {
            obj = et.getIsFinish();
            node.setAttribute(FIELD_ISFINISH, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getLastAction() != null) {
            obj = et.getLastAction();
            node.setAttribute(FIELD_LASTACTION, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLastActorId() != null) {
            obj = et.getLastActorId();
            node.setAttribute(FIELD_LASTACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getLastWFStepId() != null) {
            obj = et.getLastWFStepId();
            node.setAttribute(FIELD_LASTWFSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgId() != null) {
            obj = et.getOrgId();
            node.setAttribute(FIELD_ORGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOrgName() != null) {
            obj = et.getOrgName();
            node.setAttribute(FIELD_ORGNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getOwner() != null) {
            obj = et.getOwner();
            node.setAttribute(FIELD_OWNER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParallelInst() != null) {
            obj = et.getParallelInst();
            node.setAttribute(FIELD_PARALLELINST, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getPStepId() != null) {
            obj = et.getPStepId();
            node.setAttribute(FIELD_PSTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPWFInstanceId() != null) {
            obj = et.getPWFInstanceId();
            node.setAttribute(FIELD_PWFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPWFInstanceName() != null) {
            obj = et.getPWFInstanceName();
            node.setAttribute(FIELD_PWFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getResult() != null) {
            obj = et.getResult();
            node.setAttribute(FIELD_RESULT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            obj = et.getStartTime();
            node.setAttribute(FIELD_STARTTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getSuspendFlag() != null) {
            obj = et.getSuspendFlag();
            node.setAttribute(FIELD_SUSPENDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
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
        if (bIncEmpty || et.getUserData() != null) {
            obj = et.getUserData();
            node.setAttribute(FIELD_USERDATA, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            obj = et.getUserData2();
            node.setAttribute(FIELD_USERDATA2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            obj = et.getUserData3();
            node.setAttribute(FIELD_USERDATA3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            obj = et.getUserData4();
            node.setAttribute(FIELD_USERDATA4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserDataInfo() != null) {
            obj = et.getUserDataInfo();
            node.setAttribute(FIELD_USERDATAINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserTag() != null) {
            obj = et.getUserTag();
            node.setAttribute(FIELD_USERTAG, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserTag2() != null) {
            obj = et.getUserTag2();
            node.setAttribute(FIELD_USERTAG2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            obj = et.getWFInstanceId();
            node.setAttribute(FIELD_WFINSTANCEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            obj = et.getWFInstanceName();
            node.setAttribute(FIELD_WFINSTANCENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFModel() != null) {
            obj = et.getWFModel();
            node.setAttribute(FIELD_WFMODEL, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFVersion() != null) {
            obj = et.getWFVersion();
            node.setAttribute(FIELD_WFVERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            obj = et.getWFWorkflowId();
            node.setAttribute(FIELD_WFWORKFLOWID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            obj = et.getWFWorkflowName();
            node.setAttribute(FIELD_WFWORKFLOWNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFInstanceBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFInstanceBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActiveStepIdDirty() && (bIncEmpty || et.getActiveStepId() != null)) {
            dst.set(FIELD_ACTIVESTEPID, et.getActiveStepId());
        }
        if (et.isActiveStepNameDirty() && (bIncEmpty || et.getActiveStepName() != null)) {
            dst.set(FIELD_ACTIVESTEPNAME, et.getActiveStepName());
        }
        if (et.isCancelReasonDirty() && (bIncEmpty || et.getCancelReason() != null)) {
            dst.set(FIELD_CANCELREASON, et.getCancelReason());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableDirty() && (bIncEmpty || et.getEnable() != null)) {
            dst.set(FIELD_ENABLE, et.getEnable());
        }
        if (et.isEndTimeDirty() && (bIncEmpty || et.getEndTime() != null)) {
            dst.set(FIELD_ENDTIME, et.getEndTime());
        }
        if (et.isErrorInfoDirty() && (bIncEmpty || et.getErrorInfo() != null)) {
            dst.set(FIELD_ERRORINFO, et.getErrorInfo());
        }
        if (et.isImportanceFlagDirty() && (bIncEmpty || et.getImportanceFlag() != null)) {
            dst.set(FIELD_IMPORTANCEFLAG, et.getImportanceFlag());
        }
        if (et.isIsCancelDirty() && (bIncEmpty || et.getIsCancel() != null)) {
            dst.set(FIELD_ISCANCEL, et.getIsCancel());
        }
        if (et.isIsCloseDirty() && (bIncEmpty || et.getIsClose() != null)) {
            dst.set(FIELD_ISCLOSE, et.getIsClose());
        }
        if (et.isIsErrorDirty() && (bIncEmpty || et.getIsError() != null)) {
            dst.set(FIELD_ISERROR, et.getIsError());
        }
        if (et.isIsFinishDirty() && (bIncEmpty || et.getIsFinish() != null)) {
            dst.set(FIELD_ISFINISH, et.getIsFinish());
        }
        if (et.isLastActionDirty() && (bIncEmpty || et.getLastAction() != null)) {
            dst.set(FIELD_LASTACTION, et.getLastAction());
        }
        if (et.isLastActorIdDirty() && (bIncEmpty || et.getLastActorId() != null)) {
            dst.set(FIELD_LASTACTORID, et.getLastActorId());
        }
        if (et.isLastWFStepIdDirty() && (bIncEmpty || et.getLastWFStepId() != null)) {
            dst.set(FIELD_LASTWFSTEPID, et.getLastWFStepId());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isOrgIdDirty() && (bIncEmpty || et.getOrgId() != null)) {
            dst.set(FIELD_ORGID, et.getOrgId());
        }
        if (et.isOrgNameDirty() && (bIncEmpty || et.getOrgName() != null)) {
            dst.set(FIELD_ORGNAME, et.getOrgName());
        }
        if (et.isOwnerDirty() && (bIncEmpty || et.getOwner() != null)) {
            dst.set(FIELD_OWNER, et.getOwner());
        }
        if (et.isParallelInstDirty() && (bIncEmpty || et.getParallelInst() != null)) {
            dst.set(FIELD_PARALLELINST, et.getParallelInst());
        }
        if (et.isPStepIdDirty() && (bIncEmpty || et.getPStepId() != null)) {
            dst.set(FIELD_PSTEPID, et.getPStepId());
        }
        if (et.isPWFInstanceIdDirty() && (bIncEmpty || et.getPWFInstanceId() != null)) {
            dst.set(FIELD_PWFINSTANCEID, et.getPWFInstanceId());
        }
        if (et.isPWFInstanceNameDirty() && (bIncEmpty || et.getPWFInstanceName() != null)) {
            dst.set(FIELD_PWFINSTANCENAME, et.getPWFInstanceName());
        }
        if (et.isResultDirty() && (bIncEmpty || et.getResult() != null)) {
            dst.set(FIELD_RESULT, et.getResult());
        }
        if (et.isStartTimeDirty() && (bIncEmpty || et.getStartTime() != null)) {
            dst.set(FIELD_STARTTIME, et.getStartTime());
        }
        if (et.isSuspendFlagDirty() && (bIncEmpty || et.getSuspendFlag() != null)) {
            dst.set(FIELD_SUSPENDFLAG, et.getSuspendFlag());
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
        if (et.isUserDataDirty() && (bIncEmpty || et.getUserData() != null)) {
            dst.set(FIELD_USERDATA, et.getUserData());
        }
        if (et.isUserData2Dirty() && (bIncEmpty || et.getUserData2() != null)) {
            dst.set(FIELD_USERDATA2, et.getUserData2());
        }
        if (et.isUserData3Dirty() && (bIncEmpty || et.getUserData3() != null)) {
            dst.set(FIELD_USERDATA3, et.getUserData3());
        }
        if (et.isUserData4Dirty() && (bIncEmpty || et.getUserData4() != null)) {
            dst.set(FIELD_USERDATA4, et.getUserData4());
        }
        if (et.isUserDataInfoDirty() && (bIncEmpty || et.getUserDataInfo() != null)) {
            dst.set(FIELD_USERDATAINFO, et.getUserDataInfo());
        }
        if (et.isUserTagDirty() && (bIncEmpty || et.getUserTag() != null)) {
            dst.set(FIELD_USERTAG, et.getUserTag());
        }
        if (et.isUserTag2Dirty() && (bIncEmpty || et.getUserTag2() != null)) {
            dst.set(FIELD_USERTAG2, et.getUserTag2());
        }
        if (et.isWFInstanceIdDirty() && (bIncEmpty || et.getWFInstanceId() != null)) {
            dst.set(FIELD_WFINSTANCEID, et.getWFInstanceId());
        }
        if (et.isWFInstanceNameDirty() && (bIncEmpty || et.getWFInstanceName() != null)) {
            dst.set(FIELD_WFINSTANCENAME, et.getWFInstanceName());
        }
        if (et.isWFModelDirty() && (bIncEmpty || et.getWFModel() != null)) {
            dst.set(FIELD_WFMODEL, et.getWFModel());
        }
        if (et.isWFVersionDirty() && (bIncEmpty || et.getWFVersion() != null)) {
            dst.set(FIELD_WFVERSION, et.getWFVersion());
        }
        if (et.isWFWorkflowIdDirty() && (bIncEmpty || et.getWFWorkflowId() != null)) {
            dst.set(FIELD_WFWORKFLOWID, et.getWFWorkflowId());
        }
        if (et.isWFWorkflowNameDirty() && (bIncEmpty || et.getWFWorkflowName() != null)) {
            dst.set(FIELD_WFWORKFLOWNAME, et.getWFWorkflowName());
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
        return WFInstanceBase.remove(this, index);
    }

    private static boolean remove(WFInstanceBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActiveStepId();
                return true;
            }
            case 1: {
                et.resetActiveStepName();
                return true;
            }
            case 2: {
                et.resetCancelReason();
                return true;
            }
            case 3: {
                et.resetCreateDate();
                return true;
            }
            case 4: {
                et.resetCreateMan();
                return true;
            }
            case 5: {
                et.resetEnable();
                return true;
            }
            case 6: {
                et.resetEndTime();
                return true;
            }
            case 7: {
                et.resetErrorInfo();
                return true;
            }
            case 8: {
                et.resetImportanceFlag();
                return true;
            }
            case 9: {
                et.resetIsCancel();
                return true;
            }
            case 10: {
                et.resetIsClose();
                return true;
            }
            case 11: {
                et.resetIsError();
                return true;
            }
            case 12: {
                et.resetIsFinish();
                return true;
            }
            case 13: {
                et.resetLastAction();
                return true;
            }
            case 14: {
                et.resetLastActorId();
                return true;
            }
            case 15: {
                et.resetLastWFStepId();
                return true;
            }
            case 16: {
                et.resetMemo();
                return true;
            }
            case 17: {
                et.resetOrgId();
                return true;
            }
            case 18: {
                et.resetOrgName();
                return true;
            }
            case 19: {
                et.resetOwner();
                return true;
            }
            case 20: {
                et.resetParallelInst();
                return true;
            }
            case 21: {
                et.resetPStepId();
                return true;
            }
            case 22: {
                et.resetPWFInstanceId();
                return true;
            }
            case 23: {
                et.resetPWFInstanceName();
                return true;
            }
            case 24: {
                et.resetResult();
                return true;
            }
            case 25: {
                et.resetStartTime();
                return true;
            }
            case 26: {
                et.resetSuspendFlag();
                return true;
            }
            case 27: {
                et.resetTraceStep();
                return true;
            }
            case 28: {
                et.resetUpdateDate();
                return true;
            }
            case 29: {
                et.resetUpdateMan();
                return true;
            }
            case 30: {
                et.resetUserData();
                return true;
            }
            case 31: {
                et.resetUserData2();
                return true;
            }
            case 32: {
                et.resetUserData3();
                return true;
            }
            case 33: {
                et.resetUserData4();
                return true;
            }
            case 34: {
                et.resetUserDataInfo();
                return true;
            }
            case 35: {
                et.resetUserTag();
                return true;
            }
            case 36: {
                et.resetUserTag2();
                return true;
            }
            case 37: {
                et.resetWFInstanceId();
                return true;
            }
            case 38: {
                et.resetWFInstanceName();
                return true;
            }
            case 39: {
                et.resetWFModel();
                return true;
            }
            case 40: {
                et.resetWFVersion();
                return true;
            }
            case 41: {
                et.resetWFWorkflowId();
                return true;
            }
            case 42: {
                et.resetWFWorkflowName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Org getOrg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrg();
        }
        if (this.getOrgId() == null) {
            return null;
        }
        Integer n = this.objOrgLock;
        synchronized (n) {
            if (this.org != null && DataTypeHelper.compare(25, (Object)this.getOrgId(), (Object)this.org.getOrgId()) != 0L) {
                this.org = null;
            }
            if (this.org == null) {
                Org org = new Org();
                org.setOrgId(this.getOrgId());
                OrgService service = (OrgService)ServiceGlobal.getService(OrgService.class, this.getSessionFactory());
                service.autoGet(org);
                this.org = org;
            }
            return this.org;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFInstance getPWFInstance() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPWFInstance();
        }
        if (this.getPWFInstanceId() == null) {
            return null;
        }
        Integer n = this.objPWFInstanceLock;
        synchronized (n) {
            if (this.pwfinstance != null && DataTypeHelper.compare(25, (Object)this.getPWFInstanceId(), (Object)this.pwfinstance.getWFInstanceId()) != 0L) {
                this.pwfinstance = null;
            }
            if (this.pwfinstance == null) {
                WFInstance pwfinstance = new WFInstance();
                pwfinstance.setWFInstanceId(this.getPWFInstanceId());
                WFInstanceService service = (WFInstanceService)ServiceGlobal.getService(WFInstanceService.class, this.getSessionFactory());
                service.autoGet(pwfinstance);
                this.pwfinstance = pwfinstance;
            }
            return this.pwfinstance;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFWorkflow getWFWorkflow() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFWorkflow();
        }
        if (this.getWFWorkflowId() == null) {
            return null;
        }
        Integer n = this.objWFWorkflowLock;
        synchronized (n) {
            if (this.wfworkflow != null && DataTypeHelper.compare(25, (Object)this.getWFWorkflowId(), (Object)this.wfworkflow.getWFWorkflowId()) != 0L) {
                this.wfworkflow = null;
            }
            if (this.wfworkflow == null) {
                WFWorkflow wfworkflow = new WFWorkflow();
                wfworkflow.setWFWorkflowId(this.getWFWorkflowId());
                WFWorkflowService service = (WFWorkflowService)ServiceGlobal.getService(WFWorkflowService.class, this.getSessionFactory());
                service.autoGet(wfworkflow);
                this.wfworkflow = wfworkflow;
            }
            return this.wfworkflow;
        }
    }

    private WFInstanceBase getProxyEntity() {
        return this.proxyWFInstanceBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFInstanceBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFInstanceBase) {
            this.proxyWFInstanceBase = (WFInstanceBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFInstanceService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

