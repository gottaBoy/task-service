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
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.entity.WFWorkflow;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.ibizsys.psrt.srv.wf.service.WFWorkflowService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFUserAssistBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUserAssistBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFMAJORUSERID = "WFMAJORUSERID";
    public static final String FIELD_WFMAJORUSERNAME = "WFMAJORUSERNAME";
    public static final String FIELD_WFMINORUSERID = "WFMINORUSERID";
    public static final String FIELD_WFMINORUSERNAME = "WFMINORUSERNAME";
    public static final String FIELD_WFSTEP = "WFSTEP";
    public static final String FIELD_WFUSERASSISTID = "WFUSERASSISTID";
    public static final String FIELD_WFUSERASSISTNAME = "WFUSERASSISTNAME";
    public static final String FIELD_WFWORKFLOWID = "WFWORKFLOWID";
    public static final String FIELD_WFWORKFLOWNAME = "WFWORKFLOWNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_WFMAJORUSERID = 5;
    private static final int INDEX_WFMAJORUSERNAME = 6;
    private static final int INDEX_WFMINORUSERID = 7;
    private static final int INDEX_WFMINORUSERNAME = 8;
    private static final int INDEX_WFSTEP = 9;
    private static final int INDEX_WFUSERASSISTID = 10;
    private static final int INDEX_WFUSERASSISTNAME = 11;
    private static final int INDEX_WFWORKFLOWID = 12;
    private static final int INDEX_WFWORKFLOWNAME = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUserAssistBase proxyWFUserAssistBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfmajoruseridDirtyFlag = false;
    private boolean wfmajorusernameDirtyFlag = false;
    private boolean wfminoruseridDirtyFlag = false;
    private boolean wfminorusernameDirtyFlag = false;
    private boolean wfstepDirtyFlag = false;
    private boolean wfuserassistidDirtyFlag = false;
    private boolean wfuserassistnameDirtyFlag = false;
    private boolean wfworkflowidDirtyFlag = false;
    private boolean wfworkflownameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfmajoruserid")
    private String wfmajoruserid;
    @Column(name="wfmajorusername")
    private String wfmajorusername;
    @Column(name="wfminoruserid")
    private String wfminoruserid;
    @Column(name="wfminorusername")
    private String wfminorusername;
    @Column(name="wfstep")
    private String wfstep;
    @Column(name="wfuserassistid")
    private String wfuserassistid;
    @Column(name="wfuserassistname")
    private String wfuserassistname;
    @Column(name="wfworkflowid")
    private String wfworkflowid;
    @Column(name="wfworkflowname")
    private String wfworkflowname;
    private Integer objWFMajorUserLock = new Integer(1);
    private WFUser wfmajoruser = null;
    private Integer objWFMinorUserLock = new Integer(1);
    private WFUser wfminoruser = null;
    private Integer objWFWorkflowLock = new Integer(1);
    private WFWorkflow wfworkflow = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_WFMAJORUSERID, 5);
        fieldIndexMap.put(FIELD_WFMAJORUSERNAME, 6);
        fieldIndexMap.put(FIELD_WFMINORUSERID, 7);
        fieldIndexMap.put(FIELD_WFMINORUSERNAME, 8);
        fieldIndexMap.put(FIELD_WFSTEP, 9);
        fieldIndexMap.put(FIELD_WFUSERASSISTID, 10);
        fieldIndexMap.put(FIELD_WFUSERASSISTNAME, 11);
        fieldIndexMap.put(FIELD_WFWORKFLOWID, 12);
        fieldIndexMap.put(FIELD_WFWORKFLOWNAME, 13);
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

    public void setWFMajorUserId(String wfmajoruserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMajorUserId(wfmajoruserid);
            return;
        }
        if (wfmajoruserid != null && (wfmajoruserid = StringHelper.trimRight(wfmajoruserid)).length() == 0) {
            wfmajoruserid = null;
        }
        this.wfmajoruserid = wfmajoruserid;
        this.wfmajoruseridDirtyFlag = true;
    }

    public String getWFMajorUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUserId();
        }
        return this.wfmajoruserid;
    }

    public boolean isWFMajorUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMajorUserIdDirty();
        }
        return this.wfmajoruseridDirtyFlag;
    }

    public void resetWFMajorUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMajorUserId();
            return;
        }
        this.wfmajoruseridDirtyFlag = false;
        this.wfmajoruserid = null;
    }

    public void setWFMajorUserName(String wfmajorusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMajorUserName(wfmajorusername);
            return;
        }
        if (wfmajorusername != null && (wfmajorusername = StringHelper.trimRight(wfmajorusername)).length() == 0) {
            wfmajorusername = null;
        }
        this.wfmajorusername = wfmajorusername;
        this.wfmajorusernameDirtyFlag = true;
    }

    public String getWFMajorUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUserName();
        }
        return this.wfmajorusername;
    }

    public boolean isWFMajorUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMajorUserNameDirty();
        }
        return this.wfmajorusernameDirtyFlag;
    }

    public void resetWFMajorUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMajorUserName();
            return;
        }
        this.wfmajorusernameDirtyFlag = false;
        this.wfmajorusername = null;
    }

    public void setWFMinorUserId(String wfminoruserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMinorUserId(wfminoruserid);
            return;
        }
        if (wfminoruserid != null && (wfminoruserid = StringHelper.trimRight(wfminoruserid)).length() == 0) {
            wfminoruserid = null;
        }
        this.wfminoruserid = wfminoruserid;
        this.wfminoruseridDirtyFlag = true;
    }

    public String getWFMinorUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUserId();
        }
        return this.wfminoruserid;
    }

    public boolean isWFMinorUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMinorUserIdDirty();
        }
        return this.wfminoruseridDirtyFlag;
    }

    public void resetWFMinorUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMinorUserId();
            return;
        }
        this.wfminoruseridDirtyFlag = false;
        this.wfminoruserid = null;
    }

    public void setWFMinorUserName(String wfminorusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFMinorUserName(wfminorusername);
            return;
        }
        if (wfminorusername != null && (wfminorusername = StringHelper.trimRight(wfminorusername)).length() == 0) {
            wfminorusername = null;
        }
        this.wfminorusername = wfminorusername;
        this.wfminorusernameDirtyFlag = true;
    }

    public String getWFMinorUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUserName();
        }
        return this.wfminorusername;
    }

    public boolean isWFMinorUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFMinorUserNameDirty();
        }
        return this.wfminorusernameDirtyFlag;
    }

    public void resetWFMinorUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFMinorUserName();
            return;
        }
        this.wfminorusernameDirtyFlag = false;
        this.wfminorusername = null;
    }

    public void setWFStep(String wfstep) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFStep(wfstep);
            return;
        }
        if (wfstep != null && (wfstep = StringHelper.trimRight(wfstep)).length() == 0) {
            wfstep = null;
        }
        this.wfstep = wfstep;
        this.wfstepDirtyFlag = true;
    }

    public String getWFStep() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFStep();
        }
        return this.wfstep;
    }

    public boolean isWFStepDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFStepDirty();
        }
        return this.wfstepDirtyFlag;
    }

    public void resetWFStep() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFStep();
            return;
        }
        this.wfstepDirtyFlag = false;
        this.wfstep = null;
    }

    public void setWFUserAssistId(String wfuserassistid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserAssistId(wfuserassistid);
            return;
        }
        if (wfuserassistid != null && (wfuserassistid = StringHelper.trimRight(wfuserassistid)).length() == 0) {
            wfuserassistid = null;
        }
        this.wfuserassistid = wfuserassistid;
        this.wfuserassistidDirtyFlag = true;
    }

    public String getWFUserAssistId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserAssistId();
        }
        return this.wfuserassistid;
    }

    public boolean isWFUserAssistIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserAssistIdDirty();
        }
        return this.wfuserassistidDirtyFlag;
    }

    public void resetWFUserAssistId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserAssistId();
            return;
        }
        this.wfuserassistidDirtyFlag = false;
        this.wfuserassistid = null;
    }

    public void setWFUserAssistName(String wfuserassistname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserAssistName(wfuserassistname);
            return;
        }
        if (wfuserassistname != null && (wfuserassistname = StringHelper.trimRight(wfuserassistname)).length() == 0) {
            wfuserassistname = null;
        }
        this.wfuserassistname = wfuserassistname;
        this.wfuserassistnameDirtyFlag = true;
    }

    public String getWFUserAssistName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserAssistName();
        }
        return this.wfuserassistname;
    }

    public boolean isWFUserAssistNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserAssistNameDirty();
        }
        return this.wfuserassistnameDirtyFlag;
    }

    public void resetWFUserAssistName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserAssistName();
            return;
        }
        this.wfuserassistnameDirtyFlag = false;
        this.wfuserassistname = null;
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
        WFUserAssistBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUserAssistBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFMajorUserId();
        et.resetWFMajorUserName();
        et.resetWFMinorUserId();
        et.resetWFMinorUserName();
        et.resetWFStep();
        et.resetWFUserAssistId();
        et.resetWFUserAssistName();
        et.resetWFWorkflowId();
        et.resetWFWorkflowName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFMajorUserIdDirty()) {
            params.put(FIELD_WFMAJORUSERID, this.getWFMajorUserId());
        }
        if (!bDirtyOnly || this.isWFMajorUserNameDirty()) {
            params.put(FIELD_WFMAJORUSERNAME, this.getWFMajorUserName());
        }
        if (!bDirtyOnly || this.isWFMinorUserIdDirty()) {
            params.put(FIELD_WFMINORUSERID, this.getWFMinorUserId());
        }
        if (!bDirtyOnly || this.isWFMinorUserNameDirty()) {
            params.put(FIELD_WFMINORUSERNAME, this.getWFMinorUserName());
        }
        if (!bDirtyOnly || this.isWFStepDirty()) {
            params.put(FIELD_WFSTEP, this.getWFStep());
        }
        if (!bDirtyOnly || this.isWFUserAssistIdDirty()) {
            params.put(FIELD_WFUSERASSISTID, this.getWFUserAssistId());
        }
        if (!bDirtyOnly || this.isWFUserAssistNameDirty()) {
            params.put(FIELD_WFUSERASSISTNAME, this.getWFUserAssistName());
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
        return WFUserAssistBase.get(this, index);
    }

    private static Object get(WFUserAssistBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMemo();
            }
            case 3: {
                return et.getUpdateDate();
            }
            case 4: {
                return et.getUpdateMan();
            }
            case 5: {
                return et.getWFMajorUserId();
            }
            case 6: {
                return et.getWFMajorUserName();
            }
            case 7: {
                return et.getWFMinorUserId();
            }
            case 8: {
                return et.getWFMinorUserName();
            }
            case 9: {
                return et.getWFStep();
            }
            case 10: {
                return et.getWFUserAssistId();
            }
            case 11: {
                return et.getWFUserAssistName();
            }
            case 12: {
                return et.getWFWorkflowId();
            }
            case 13: {
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
        WFUserAssistBase.set(this, index, objValue);
    }

    private static void set(WFUserAssistBase et, int index, Object obj) throws Exception {
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
                et.setMemo(DataObject.getStringValue(obj));
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
                et.setWFMajorUserId(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setWFMajorUserName(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFMinorUserId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFMinorUserName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setWFStep(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFUserAssistId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFUserAssistName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFWorkflowId(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
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
        return WFUserAssistBase.isNull(this, index);
    }

    private static boolean isNull(WFUserAssistBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMemo() == null;
            }
            case 3: {
                return et.getUpdateDate() == null;
            }
            case 4: {
                return et.getUpdateMan() == null;
            }
            case 5: {
                return et.getWFMajorUserId() == null;
            }
            case 6: {
                return et.getWFMajorUserName() == null;
            }
            case 7: {
                return et.getWFMinorUserId() == null;
            }
            case 8: {
                return et.getWFMinorUserName() == null;
            }
            case 9: {
                return et.getWFStep() == null;
            }
            case 10: {
                return et.getWFUserAssistId() == null;
            }
            case 11: {
                return et.getWFUserAssistName() == null;
            }
            case 12: {
                return et.getWFWorkflowId() == null;
            }
            case 13: {
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
        return WFUserAssistBase.contains(this, index);
    }

    private static boolean contains(WFUserAssistBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMemoDirty();
            }
            case 3: {
                return et.isUpdateDateDirty();
            }
            case 4: {
                return et.isUpdateManDirty();
            }
            case 5: {
                return et.isWFMajorUserIdDirty();
            }
            case 6: {
                return et.isWFMajorUserNameDirty();
            }
            case 7: {
                return et.isWFMinorUserIdDirty();
            }
            case 8: {
                return et.isWFMinorUserNameDirty();
            }
            case 9: {
                return et.isWFStepDirty();
            }
            case 10: {
                return et.isWFUserAssistIdDirty();
            }
            case 11: {
                return et.isWFUserAssistNameDirty();
            }
            case 12: {
                return et.isWFWorkflowIdDirty();
            }
            case 13: {
                return et.isWFWorkflowNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUserAssistBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUserAssistBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUserAssistBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUserAssistBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFUserAssistBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUserAssistBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUserAssistBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFMajorUserId() != null) {
            JSONObjectHelper.put(json, "wfmajoruserid", WFUserAssistBase.getJSONValue(et.getWFMajorUserId()), false);
        }
        if (bIncEmpty || et.getWFMajorUserName() != null) {
            JSONObjectHelper.put(json, "wfmajorusername", WFUserAssistBase.getJSONValue(et.getWFMajorUserName()), false);
        }
        if (bIncEmpty || et.getWFMinorUserId() != null) {
            JSONObjectHelper.put(json, "wfminoruserid", WFUserAssistBase.getJSONValue(et.getWFMinorUserId()), false);
        }
        if (bIncEmpty || et.getWFMinorUserName() != null) {
            JSONObjectHelper.put(json, "wfminorusername", WFUserAssistBase.getJSONValue(et.getWFMinorUserName()), false);
        }
        if (bIncEmpty || et.getWFStep() != null) {
            JSONObjectHelper.put(json, "wfstep", WFUserAssistBase.getJSONValue(et.getWFStep()), false);
        }
        if (bIncEmpty || et.getWFUserAssistId() != null) {
            JSONObjectHelper.put(json, "wfuserassistid", WFUserAssistBase.getJSONValue(et.getWFUserAssistId()), false);
        }
        if (bIncEmpty || et.getWFUserAssistName() != null) {
            JSONObjectHelper.put(json, "wfuserassistname", WFUserAssistBase.getJSONValue(et.getWFUserAssistName()), false);
        }
        if (bIncEmpty || et.getWFWorkflowId() != null) {
            JSONObjectHelper.put(json, "wfworkflowid", WFUserAssistBase.getJSONValue(et.getWFWorkflowId()), false);
        }
        if (bIncEmpty || et.getWFWorkflowName() != null) {
            JSONObjectHelper.put(json, "wfworkflowname", WFUserAssistBase.getJSONValue(et.getWFWorkflowName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUserAssistBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUserAssistBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMajorUserId() != null) {
            obj = et.getWFMajorUserId();
            node.setAttribute(FIELD_WFMAJORUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMajorUserName() != null) {
            obj = et.getWFMajorUserName();
            node.setAttribute(FIELD_WFMAJORUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMinorUserId() != null) {
            obj = et.getWFMinorUserId();
            node.setAttribute(FIELD_WFMINORUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFMinorUserName() != null) {
            obj = et.getWFMinorUserName();
            node.setAttribute(FIELD_WFMINORUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStep() != null) {
            obj = et.getWFStep();
            node.setAttribute(FIELD_WFSTEP, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserAssistId() != null) {
            obj = et.getWFUserAssistId();
            node.setAttribute(FIELD_WFUSERASSISTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserAssistName() != null) {
            obj = et.getWFUserAssistName();
            node.setAttribute(FIELD_WFUSERASSISTNAME, obj == null ? "" : (String)obj);
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
        WFUserAssistBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUserAssistBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFMajorUserIdDirty() && (bIncEmpty || et.getWFMajorUserId() != null)) {
            dst.set(FIELD_WFMAJORUSERID, et.getWFMajorUserId());
        }
        if (et.isWFMajorUserNameDirty() && (bIncEmpty || et.getWFMajorUserName() != null)) {
            dst.set(FIELD_WFMAJORUSERNAME, et.getWFMajorUserName());
        }
        if (et.isWFMinorUserIdDirty() && (bIncEmpty || et.getWFMinorUserId() != null)) {
            dst.set(FIELD_WFMINORUSERID, et.getWFMinorUserId());
        }
        if (et.isWFMinorUserNameDirty() && (bIncEmpty || et.getWFMinorUserName() != null)) {
            dst.set(FIELD_WFMINORUSERNAME, et.getWFMinorUserName());
        }
        if (et.isWFStepDirty() && (bIncEmpty || et.getWFStep() != null)) {
            dst.set(FIELD_WFSTEP, et.getWFStep());
        }
        if (et.isWFUserAssistIdDirty() && (bIncEmpty || et.getWFUserAssistId() != null)) {
            dst.set(FIELD_WFUSERASSISTID, et.getWFUserAssistId());
        }
        if (et.isWFUserAssistNameDirty() && (bIncEmpty || et.getWFUserAssistName() != null)) {
            dst.set(FIELD_WFUSERASSISTNAME, et.getWFUserAssistName());
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
        return WFUserAssistBase.remove(this, index);
    }

    private static boolean remove(WFUserAssistBase et, int index) throws Exception {
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
                et.resetMemo();
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
                et.resetWFMajorUserId();
                return true;
            }
            case 6: {
                et.resetWFMajorUserName();
                return true;
            }
            case 7: {
                et.resetWFMinorUserId();
                return true;
            }
            case 8: {
                et.resetWFMinorUserName();
                return true;
            }
            case 9: {
                et.resetWFStep();
                return true;
            }
            case 10: {
                et.resetWFUserAssistId();
                return true;
            }
            case 11: {
                et.resetWFUserAssistName();
                return true;
            }
            case 12: {
                et.resetWFWorkflowId();
                return true;
            }
            case 13: {
                et.resetWFWorkflowName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getWFMajorUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMajorUser();
        }
        if (this.getWFMajorUserId() == null) {
            return null;
        }
        Integer n = this.objWFMajorUserLock;
        synchronized (n) {
            if (this.wfmajoruser != null && DataTypeHelper.compare(25, (Object)this.getWFMajorUserId(), (Object)this.wfmajoruser.getWFUserId()) != 0L) {
                this.wfmajoruser = null;
            }
            if (this.wfmajoruser == null) {
                WFUser wfmajoruser = new WFUser();
                wfmajoruser.setWFUserId(this.getWFMajorUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfmajoruser);
                this.wfmajoruser = wfmajoruser;
            }
            return this.wfmajoruser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getWFMinorUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFMinorUser();
        }
        if (this.getWFMinorUserId() == null) {
            return null;
        }
        Integer n = this.objWFMinorUserLock;
        synchronized (n) {
            if (this.wfminoruser != null && DataTypeHelper.compare(25, (Object)this.getWFMinorUserId(), (Object)this.wfminoruser.getWFUserId()) != 0L) {
                this.wfminoruser = null;
            }
            if (this.wfminoruser == null) {
                WFUser wfminoruser = new WFUser();
                wfminoruser.setWFUserId(this.getWFMinorUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfminoruser);
                this.wfminoruser = wfminoruser;
            }
            return this.wfminoruser;
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

    private WFUserAssistBase getProxyEntity() {
        return this.proxyWFUserAssistBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUserAssistBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUserAssistBase) {
            this.proxyWFUserAssistBase = (WFUserAssistBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUserAssistService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

