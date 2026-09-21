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
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFInstanceService;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFAssistWorkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFAssistWorkBase.class);
    public static final String FIELD_ACTIVESTEPID = "ACTIVESTEPID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_WFASSISTWORKID = "WFASSISTWORKID";
    public static final String FIELD_WFASSISTWORKNAME = "WFASSISTWORKNAME";
    public static final String FIELD_WFINSTANCEID = "WFINSTANCEID";
    public static final String FIELD_WFINSTANCENAME = "WFINSTANCENAME";
    public static final String FIELD_WFPLOGICNAME = "WFPLOGICNAME";
    public static final String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    public static final String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    public static final String FIELD_WFSTEPID = "WFSTEPID";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_ACTIVESTEPID = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_USERDATA = 5;
    private static final int INDEX_USERDATA4 = 6;
    private static final int INDEX_WFASSISTWORKID = 7;
    private static final int INDEX_WFASSISTWORKNAME = 8;
    private static final int INDEX_WFINSTANCEID = 9;
    private static final int INDEX_WFINSTANCENAME = 10;
    private static final int INDEX_WFPLOGICNAME = 11;
    private static final int INDEX_WFSTEPACTORID = 12;
    private static final int INDEX_WFSTEPACTORNAME = 13;
    private static final int INDEX_WFSTEPID = 14;
    private static final int INDEX_WFWORKFLOWID = 15;
    private static final int INDEX_WFWORKFLOWNAME = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFAssistWorkBase proxyWFAssistWorkBase = null;
    private boolean activestepidDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean wfassistworkidDirtyFlag = false;
    private boolean wfassistworknameDirtyFlag = false;
    private boolean wfinstanceidDirtyFlag = false;
    private boolean wfinstancenameDirtyFlag = false;
    private boolean wfplogicnameDirtyFlag = false;
    private boolean wfstepactoridDirtyFlag = false;
    private boolean wfstepactornameDirtyFlag = false;
    private boolean wfstepidDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    @Column(name="activestepid")
    private String activestepid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata4")
    private String userdata4;
    @Column(name="wfassistworkid")
    private String wfassistworkid;
    @Column(name="wfassistworkname")
    private String wfassistworkname;
    @Column(name="wfinstanceid")
    private String wfinstanceid;
    @Column(name="wfinstancename")
    private String wfinstancename;
    @Column(name="wfplogicname")
    private String wfplogicname;
    @Column(name="wfstepactorid")
    private String wfstepactorid;
    @Column(name="wfstepactorname")
    private String wfstepactorname;
    @Column(name="wfstepid")
    private String wfstepid;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    private Integer objWFInstanceLock = new Integer(1);
    private WFInstance wfinstance = null;
    private Integer objWFStepActorLock = new Integer(1);
    private WFStepActor wfstepactor = null;
    private Integer objWFWorkflowLock = new Integer(1);
    private WFWorkflow wfworkflow = null;

    static {
        fieldIndexMap.put(FIELD_ACTIVESTEPID, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_USERDATA, 5);
        fieldIndexMap.put(FIELD_USERDATA4, 6);
        fieldIndexMap.put(FIELD_WFASSISTWORKID, 7);
        fieldIndexMap.put(FIELD_WFASSISTWORKNAME, 8);
        fieldIndexMap.put(FIELD_WFINSTANCEID, 9);
        fieldIndexMap.put(FIELD_WFINSTANCENAME, 10);
        fieldIndexMap.put(FIELD_WFPLOGICNAME, 11);
        fieldIndexMap.put(FIELD_WFSTEPACTORID, 12);
        fieldIndexMap.put(FIELD_WFSTEPACTORNAME, 13);
        fieldIndexMap.put(FIELD_WFSTEPID, 14);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 15);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 16);
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

    public void setWFAssistWorkId(String wfassistworkid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFAssistWorkId(wfassistworkid);
            return;
        }
        if (wfassistworkid != null && (wfassistworkid = StringHelper.trimRight(wfassistworkid)).length() == 0) {
            wfassistworkid = null;
        }
        this.wfassistworkid = wfassistworkid;
        this.wfassistworkidDirtyFlag = true;
    }

    public String getWFAssistWorkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFAssistWorkId();
        }
        return this.wfassistworkid;
    }

    public boolean isWFAssistWorkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFAssistWorkIdDirty();
        }
        return this.wfassistworkidDirtyFlag;
    }

    public void resetWFAssistWorkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFAssistWorkId();
            return;
        }
        this.wfassistworkidDirtyFlag = false;
        this.wfassistworkid = null;
    }

    public void setWFAssistWorkName(String wfassistworkname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFAssistWorkName(wfassistworkname);
            return;
        }
        if (wfassistworkname != null && (wfassistworkname = StringHelper.trimRight(wfassistworkname)).length() == 0) {
            wfassistworkname = null;
        }
        this.wfassistworkname = wfassistworkname;
        this.wfassistworknameDirtyFlag = true;
    }

    public String getWFAssistWorkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFAssistWorkName();
        }
        return this.wfassistworkname;
    }

    public boolean isWFAssistWorkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFAssistWorkNameDirty();
        }
        return this.wfassistworknameDirtyFlag;
    }

    public void resetWFAssistWorkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFAssistWorkName();
            return;
        }
        this.wfassistworknameDirtyFlag = false;
        this.wfassistworkname = null;
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
        WFAssistWorkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFAssistWorkBase et) {
        et.resetActiveStepId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData4();
        et.resetWFAssistWorkId();
        et.resetWFAssistWorkName();
        et.resetWFInstanceId();
        et.resetWFInstanceName();
        et.resetWFPLogicName();
        et.resetWFStepActorId();
        et.resetWFStepActorName();
        et.resetWFStepId();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActiveStepIdDirty()) {
            params.put(FIELD_ACTIVESTEPID, this.getActiveStepId());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
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
        if (!bDirtyOnly || this.isUserData4Dirty()) {
            params.put(FIELD_USERDATA4, this.getUserData4());
        }
        if (!bDirtyOnly || this.isWFAssistWorkIdDirty()) {
            params.put(FIELD_WFASSISTWORKID, this.getWFAssistWorkId());
        }
        if (!bDirtyOnly || this.isWFAssistWorkNameDirty()) {
            params.put(FIELD_WFASSISTWORKNAME, this.getWFAssistWorkName());
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
        if (!bDirtyOnly || this.isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID, this.getWFStepActorId());
        }
        if (!bDirtyOnly || this.isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME, this.getWFStepActorName());
        }
        if (!bDirtyOnly || this.isWFStepIdDirty()) {
            params.put(FIELD_WFSTEPID, this.getWFStepId());
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
        return WFAssistWorkBase.get(this, index);
    }

    private static Object get(WFAssistWorkBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActiveStepId();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getUpdateDate();
            }
            case 4: {
                return et.getUpdateMan();
            }
            case 5: {
                return et.getUserData();
            }
            case 6: {
                return et.getUserData4();
            }
            case 7: {
                return et.getWFAssistWorkId();
            }
            case 8: {
                return et.getWFAssistWorkName();
            }
            case 9: {
                return et.getWFInstanceId();
            }
            case 10: {
                return et.getWFInstanceName();
            }
            case 11: {
                return et.getWFPLogicName();
            }
            case 12: {
                return et.getWFStepActorId();
            }
            case 13: {
                return et.getWFStepActorName();
            }
            case 14: {
                return et.getWFStepId();
            }
            case 15: {
                return et.getWFWorkflowId();
            }
            case 16: {
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
        WFAssistWorkBase.set(this, index, objValue);
    }

    private static void set(WFAssistWorkBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActiveStepId(DataObject.getStringValue(obj));
                return;
            }
            case 1: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 2: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUserData4(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFAssistWorkId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFAssistWorkName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFInstanceId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFInstanceName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFPLogicName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFStepActorId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWFStepActorName(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWFStepId(DataObject.getStringValue(obj));
                return;
            }
            case 15: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
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
        return WFAssistWorkBase.isNull(this, index);
    }

    private static boolean isNull(WFAssistWorkBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActiveStepId() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getUpdateDate() == null;
            }
            case 4: {
                return et.getUpdateMan() == null;
            }
            case 5: {
                return et.getUserData() == null;
            }
            case 6: {
                return et.getUserData4() == null;
            }
            case 7: {
                return et.getWFAssistWorkId() == null;
            }
            case 8: {
                return et.getWFAssistWorkName() == null;
            }
            case 9: {
                return et.getWFInstanceId() == null;
            }
            case 10: {
                return et.getWFInstanceName() == null;
            }
            case 11: {
                return et.getWFPLogicName() == null;
            }
            case 12: {
                return et.getWFStepActorId() == null;
            }
            case 13: {
                return et.getWFStepActorName() == null;
            }
            case 14: {
                return et.getWFStepId() == null;
            }
            case 15: {
                return et.getWFWorkflowId() == null;
            }
            case 16: {
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
        return WFAssistWorkBase.contains(this, index);
    }

    private static boolean contains(WFAssistWorkBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActiveStepIdDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isUpdateDateDirty();
            }
            case 4: {
                return et.isUpdateManDirty();
            }
            case 5: {
                return et.isUserDataDirty();
            }
            case 6: {
                return et.isUserData4Dirty();
            }
            case 7: {
                return et.isWFAssistWorkIdDirty();
            }
            case 8: {
                return et.isWFAssistWorkNameDirty();
            }
            case 9: {
                return et.isWFInstanceIdDirty();
            }
            case 10: {
                return et.isWFInstanceNameDirty();
            }
            case 11: {
                return et.isWFPLogicNameDirty();
            }
            case 12: {
                return et.isWFStepActorIdDirty();
            }
            case 13: {
                return et.isWFStepActorNameDirty();
            }
            case 14: {
                return et.isWFStepIdDirty();
            }
            case 15: {
                return et.isWFWorkflowIdDirty();
            }
            case 16: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFAssistWorkBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFAssistWorkBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActiveStepId() != null) {
            JSONObjectHelper.put(json, "activestepid", WFAssistWorkBase.getJSONValue(et.getActiveStepId()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFAssistWorkBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFAssistWorkBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFAssistWorkBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFAssistWorkBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFAssistWorkBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", WFAssistWorkBase.getJSONValue(et.getUserData4()), false);
        }
        if (bIncEmpty || et.getWFAssistWorkId() != null) {
            JSONObjectHelper.put(json, "wfassistworkid", WFAssistWorkBase.getJSONValue(et.getWFAssistWorkId()), false);
        }
        if (bIncEmpty || et.getWFAssistWorkName() != null) {
            JSONObjectHelper.put(json, "wfassistworkname", WFAssistWorkBase.getJSONValue(et.getWFAssistWorkName()), false);
        }
        if (bIncEmpty || et.getWFInstanceId() != null) {
            JSONObjectHelper.put(json, "wfinstanceid", WFAssistWorkBase.getJSONValue(et.getWFInstanceId()), false);
        }
        if (bIncEmpty || et.getWFInstanceName() != null) {
            JSONObjectHelper.put(json, "wfinstancename", WFAssistWorkBase.getJSONValue(et.getWFInstanceName()), false);
        }
        if (bIncEmpty || et.getWFPLogicName() != null) {
            JSONObjectHelper.put(json, "wfplogicname", WFAssistWorkBase.getJSONValue(et.getWFPLogicName()), false);
        }
        if (bIncEmpty || et.getWFStepActorId() != null) {
            JSONObjectHelper.put(json, "wfstepactorid", WFAssistWorkBase.getJSONValue(et.getWFStepActorId()), false);
        }
        if (bIncEmpty || et.getWFStepActorName() != null) {
            JSONObjectHelper.put(json, "wfstepactorname", WFAssistWorkBase.getJSONValue(et.getWFStepActorName()), false);
        }
        if (bIncEmpty || et.getWFStepId() != null) {
            JSONObjectHelper.put(json, "wfstepid", WFAssistWorkBase.getJSONValue(et.getWFStepId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFAssistWorkBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFAssistWorkBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFAssistWorkBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFAssistWorkBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActiveStepId() != null) {
            obj = et.getActiveStepId();
            node.setAttribute(FIELD_ACTIVESTEPID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getUserData4() != null) {
            obj = et.getUserData4();
            node.setAttribute(FIELD_USERDATA4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFAssistWorkId() != null) {
            obj = et.getWFAssistWorkId();
            node.setAttribute(FIELD_WFASSISTWORKID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFAssistWorkName() != null) {
            obj = et.getWFAssistWorkName();
            node.setAttribute(FIELD_WFASSISTWORKNAME, obj == null ? "" : (String)obj);
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
        WFAssistWorkBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFAssistWorkBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActiveStepIdDirty() && (bIncEmpty || et.getActiveStepId() != null)) {
            dst.set(FIELD_ACTIVESTEPID, et.getActiveStepId());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
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
        if (et.isUserData4Dirty() && (bIncEmpty || et.getUserData4() != null)) {
            dst.set(FIELD_USERDATA4, et.getUserData4());
        }
        if (et.isWFAssistWorkIdDirty() && (bIncEmpty || et.getWFAssistWorkId() != null)) {
            dst.set(FIELD_WFASSISTWORKID, et.getWFAssistWorkId());
        }
        if (et.isWFAssistWorkNameDirty() && (bIncEmpty || et.getWFAssistWorkName() != null)) {
            dst.set(FIELD_WFASSISTWORKNAME, et.getWFAssistWorkName());
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
        if (et.isWFStepActorIdDirty() && (bIncEmpty || et.getWFStepActorId() != null)) {
            dst.set(FIELD_WFSTEPACTORID, et.getWFStepActorId());
        }
        if (et.isWFStepActorNameDirty() && (bIncEmpty || et.getWFStepActorName() != null)) {
            dst.set(FIELD_WFSTEPACTORNAME, et.getWFStepActorName());
        }
        if (et.isWFStepIdDirty() && (bIncEmpty || et.getWFStepId() != null)) {
            dst.set(FIELD_WFSTEPID, et.getWFStepId());
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
        return WFAssistWorkBase.remove(this, index);
    }

    private static boolean remove(WFAssistWorkBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActiveStepId();
                return true;
            }
            case 1: {
                et.resetCreateDate();
                return true;
            }
            case 2: {
                et.resetCreateMan();
                return true;
            }
            case 3: {
                et.resetUpdateDate();
                return true;
            }
            case 4: {
                et.resetUpdateMan();
                return true;
            }
            case 5: {
                et.resetUserData();
                return true;
            }
            case 6: {
                et.resetUserData4();
                return true;
            }
            case 7: {
                et.resetWFAssistWorkId();
                return true;
            }
            case 8: {
                et.resetWFAssistWorkName();
                return true;
            }
            case 9: {
                et.resetWFInstanceId();
                return true;
            }
            case 10: {
                et.resetWFInstanceName();
                return true;
            }
            case 11: {
                et.resetWFPLogicName();
                return true;
            }
            case 12: {
                et.resetWFStepActorId();
                return true;
            }
            case 13: {
                et.resetWFStepActorName();
                return true;
            }
            case 14: {
                et.resetWFStepId();
                return true;
            }
            case 15: {
                et.resetWFWorkflowId();
                return true;
            }
            case 16: {
                et.resetWFWorkflowName();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFStepActor getWFStepActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStepActor();
        }
        if (this.getWFStepActorId() == null) {
            return null;
        }
        Integer n = this.objWFStepActorLock;
        synchronized (n) {
            if (this.wfstepactor != null && DataTypeHelper.compare(25, (Object)this.getWFStepActorId(), (Object)this.wfstepactor.getWFStepActorId()) != 0L) {
                this.wfstepactor = null;
            }
            if (this.wfstepactor == null) {
                WFStepActor wfstepactor = new WFStepActor();
                wfstepactor.setWFStepActorId(this.getWFStepActorId());
                WFStepActorService service = (WFStepActorService)ServiceGlobal.getService(WFStepActorService.class, this.getSessionFactory());
                service.autoGet(wfstepactor);
                this.wfstepactor = wfstepactor;
            }
            return this.wfstepactor;
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

    private WFAssistWorkBase getProxyEntity() {
        return this.proxyWFAssistWorkBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFAssistWorkBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFAssistWorkBase) {
            this.proxyWFAssistWorkBase = (WFAssistWorkBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFAssistWorkService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

