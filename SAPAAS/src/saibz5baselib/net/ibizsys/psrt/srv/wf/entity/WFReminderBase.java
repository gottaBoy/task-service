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
import net.ibizsys.psrt.srv.wf.entity.WFStepActor;
import net.ibizsys.psrt.srv.wf.entity.WFUser;
import net.ibizsys.psrt.srv.wf.service.WFStepActorService;
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFReminderBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFReminderBase.class);
    public static final String FIELD_ACTORID = "ACTORID";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_REMINDERCOUNT = "REMINDERCOUNT";
    public static final String FIELD_REMINDERTIME = "REMINDERTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFCREATEDATE = "WFCREATEDATE";
    public static final String FIELD_WFREMINDERID = "WFREMINDERID";
    public static final String FIELD_WFREMINDERNAME = "WFREMINDERNAME";
    public static final String FIELD_WFSTEPACTORID = "WFSTEPACTORID";
    public static final String FIELD_WFSTEPACTORNAME = "WFSTEPACTORNAME";
    public static final String FIELD_WFUSERID = "WFUSERID";
    public static final String FIELD_WFUSERNAME = "WFUSERNAME";
    private static final int INDEX_ACTORID = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_REMINDERCOUNT = 4;
    private static final int INDEX_REMINDERTIME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_WFCREATEDATE = 8;
    private static final int INDEX_WFREMINDERID = 9;
    private static final int INDEX_WFREMINDERNAME = 10;
    private static final int INDEX_WFSTEPACTORID = 11;
    private static final int INDEX_WFSTEPACTORNAME = 12;
    private static final int INDEX_WFUSERID = 13;
    private static final int INDEX_WFUSERNAME = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFReminderBase proxyWFReminderBase = null;
    private boolean actoridDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean remindercountDirtyFlag = false;
    private boolean remindertimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfcreatedateDirtyFlag = false;
    private boolean wfreminderidDirtyFlag = false;
    private boolean wfremindernameDirtyFlag = false;
    private boolean wfstepactoridDirtyFlag = false;
    private boolean wfstepactornameDirtyFlag = false;
    private boolean wfuseridDirtyFlag = false;
    private boolean wfusernameDirtyFlag = false;
    @Column(name="actorid")
    private String actorid;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="remindercount")
    private Integer remindercount;
    @Column(name="remindertime")
    private Timestamp remindertime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfcreatedate")
    private Timestamp wfcreatedate;
    @Column(name="wfreminderid")
    private String wfreminderid;
    @Column(name="wfremindername")
    private String wfremindername;
    @Column(name="wfstepactorid")
    private String wfstepactorid;
    @Column(name="wfstepactorname")
    private String wfstepactorname;
    @Column(name="wfuserid")
    private String wfuserid;
    @Column(name="wfusername")
    private String wfusername;
    private Integer objWFStepActorLock = new Integer(1);
    private WFStepActor wfstepactor = null;
    private Integer objWFUserLock = new Integer(1);
    private WFUser wfuser = null;

    static {
        fieldIndexMap.put(FIELD_ACTORID, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_REMINDERCOUNT, 4);
        fieldIndexMap.put(FIELD_REMINDERTIME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_WFCREATEDATE, 8);
        fieldIndexMap.put(FIELD_WFREMINDERID, 9);
        fieldIndexMap.put(FIELD_WFREMINDERNAME, 10);
        fieldIndexMap.put(FIELD_WFSTEPACTORID, 11);
        fieldIndexMap.put(FIELD_WFSTEPACTORNAME, 12);
        fieldIndexMap.put(FIELD_WFUSERID, 13);
        fieldIndexMap.put(FIELD_WFUSERNAME, 14);
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

    public void setReminderTime(Timestamp remindertime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReminderTime(remindertime);
            return;
        }
        this.remindertime = remindertime;
        this.remindertimeDirtyFlag = true;
    }

    public Timestamp getReminderTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReminderTime();
        }
        return this.remindertime;
    }

    public boolean isReminderTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReminderTimeDirty();
        }
        return this.remindertimeDirtyFlag;
    }

    public void resetReminderTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReminderTime();
            return;
        }
        this.remindertimeDirtyFlag = false;
        this.remindertime = null;
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

    public void setWFCreateDate(Timestamp wfcreatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFCreateDate(wfcreatedate);
            return;
        }
        this.wfcreatedate = wfcreatedate;
        this.wfcreatedateDirtyFlag = true;
    }

    public Timestamp getWFCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFCreateDate();
        }
        return this.wfcreatedate;
    }

    public boolean isWFCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFCreateDateDirty();
        }
        return this.wfcreatedateDirtyFlag;
    }

    public void resetWFCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFCreateDate();
            return;
        }
        this.wfcreatedateDirtyFlag = false;
        this.wfcreatedate = null;
    }

    public void setWFReminderId(String wfreminderid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFReminderId(wfreminderid);
            return;
        }
        if (wfreminderid != null && (wfreminderid = StringHelper.trimRight(wfreminderid)).length() == 0) {
            wfreminderid = null;
        }
        this.wfreminderid = wfreminderid;
        this.wfreminderidDirtyFlag = true;
    }

    public String getWFReminderId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFReminderId();
        }
        return this.wfreminderid;
    }

    public boolean isWFReminderIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFReminderIdDirty();
        }
        return this.wfreminderidDirtyFlag;
    }

    public void resetWFReminderId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFReminderId();
            return;
        }
        this.wfreminderidDirtyFlag = false;
        this.wfreminderid = null;
    }

    public void setWFReminderName(String wfremindername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFReminderName(wfremindername);
            return;
        }
        if (wfremindername != null && (wfremindername = StringHelper.trimRight(wfremindername)).length() == 0) {
            wfremindername = null;
        }
        this.wfremindername = wfremindername;
        this.wfremindernameDirtyFlag = true;
    }

    public String getWFReminderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFReminderName();
        }
        return this.wfremindername;
    }

    public boolean isWFReminderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFReminderNameDirty();
        }
        return this.wfremindernameDirtyFlag;
    }

    public void resetWFReminderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFReminderName();
            return;
        }
        this.wfremindernameDirtyFlag = false;
        this.wfremindername = null;
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

    public void setWFUserId(String wfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserId(wfuserid);
            return;
        }
        if (wfuserid != null && (wfuserid = StringHelper.trimRight(wfuserid)).length() == 0) {
            wfuserid = null;
        }
        this.wfuserid = wfuserid;
        this.wfuseridDirtyFlag = true;
    }

    public String getWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserId();
        }
        return this.wfuserid;
    }

    public boolean isWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserIdDirty();
        }
        return this.wfuseridDirtyFlag;
    }

    public void resetWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserId();
            return;
        }
        this.wfuseridDirtyFlag = false;
        this.wfuserid = null;
    }

    public void setWFUserName(String wfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUserName(wfusername);
            return;
        }
        if (wfusername != null && (wfusername = StringHelper.trimRight(wfusername)).length() == 0) {
            wfusername = null;
        }
        this.wfusername = wfusername;
        this.wfusernameDirtyFlag = true;
    }

    public String getWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUserName();
        }
        return this.wfusername;
    }

    public boolean isWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUserNameDirty();
        }
        return this.wfusernameDirtyFlag;
    }

    public void resetWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUserName();
            return;
        }
        this.wfusernameDirtyFlag = false;
        this.wfusername = null;
    }

    @Override
    protected void onReset() {
        WFReminderBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFReminderBase et) {
        et.resetActorId();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMemo();
        et.resetReminderCount();
        et.resetReminderTime();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFCreateDate();
        et.resetWFReminderId();
        et.resetWFReminderName();
        et.resetWFStepActorId();
        et.resetWFStepActorName();
        et.resetWFUserId();
        et.resetWFUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isActorIdDirty()) {
            params.put(FIELD_ACTORID, this.getActorId());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isReminderCountDirty()) {
            params.put(FIELD_REMINDERCOUNT, this.getReminderCount());
        }
        if (!bDirtyOnly || this.isReminderTimeDirty()) {
            params.put(FIELD_REMINDERTIME, this.getReminderTime());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFCreateDateDirty()) {
            params.put(FIELD_WFCREATEDATE, this.getWFCreateDate());
        }
        if (!bDirtyOnly || this.isWFReminderIdDirty()) {
            params.put(FIELD_WFREMINDERID, this.getWFReminderId());
        }
        if (!bDirtyOnly || this.isWFReminderNameDirty()) {
            params.put(FIELD_WFREMINDERNAME, this.getWFReminderName());
        }
        if (!bDirtyOnly || this.isWFStepActorIdDirty()) {
            params.put(FIELD_WFSTEPACTORID, this.getWFStepActorId());
        }
        if (!bDirtyOnly || this.isWFStepActorNameDirty()) {
            params.put(FIELD_WFSTEPACTORNAME, this.getWFStepActorName());
        }
        if (!bDirtyOnly || this.isWFUserIdDirty()) {
            params.put(FIELD_WFUSERID, this.getWFUserId());
        }
        if (!bDirtyOnly || this.isWFUserNameDirty()) {
            params.put(FIELD_WFUSERNAME, this.getWFUserName());
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
        return WFReminderBase.get(this, index);
    }

    private static Object get(WFReminderBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActorId();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getMemo();
            }
            case 4: {
                return et.getReminderCount();
            }
            case 5: {
                return et.getReminderTime();
            }
            case 6: {
                return et.getUpdateDate();
            }
            case 7: {
                return et.getUpdateMan();
            }
            case 8: {
                return et.getWFCreateDate();
            }
            case 9: {
                return et.getWFReminderId();
            }
            case 10: {
                return et.getWFReminderName();
            }
            case 11: {
                return et.getWFStepActorId();
            }
            case 12: {
                return et.getWFStepActorName();
            }
            case 13: {
                return et.getWFUserId();
            }
            case 14: {
                return et.getWFUserName();
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
        WFReminderBase.set(this, index, objValue);
    }

    private static void set(WFReminderBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setActorId(DataObject.getStringValue(obj));
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
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReminderCount(DataObject.getIntegerValue(obj));
                return;
            }
            case 5: {
                et.setReminderTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 6: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setWFReminderId(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setWFReminderName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setWFStepActorId(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setWFStepActorName(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setWFUserName(DataObject.getStringValue(obj));
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
        return WFReminderBase.isNull(this, index);
    }

    private static boolean isNull(WFReminderBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getActorId() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getMemo() == null;
            }
            case 4: {
                return et.getReminderCount() == null;
            }
            case 5: {
                return et.getReminderTime() == null;
            }
            case 6: {
                return et.getUpdateDate() == null;
            }
            case 7: {
                return et.getUpdateMan() == null;
            }
            case 8: {
                return et.getWFCreateDate() == null;
            }
            case 9: {
                return et.getWFReminderId() == null;
            }
            case 10: {
                return et.getWFReminderName() == null;
            }
            case 11: {
                return et.getWFStepActorId() == null;
            }
            case 12: {
                return et.getWFStepActorName() == null;
            }
            case 13: {
                return et.getWFUserId() == null;
            }
            case 14: {
                return et.getWFUserName() == null;
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
        return WFReminderBase.contains(this, index);
    }

    private static boolean contains(WFReminderBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isActorIdDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isMemoDirty();
            }
            case 4: {
                return et.isReminderCountDirty();
            }
            case 5: {
                return et.isReminderTimeDirty();
            }
            case 6: {
                return et.isUpdateDateDirty();
            }
            case 7: {
                return et.isUpdateManDirty();
            }
            case 8: {
                return et.isWFCreateDateDirty();
            }
            case 9: {
                return et.isWFReminderIdDirty();
            }
            case 10: {
                return et.isWFReminderNameDirty();
            }
            case 11: {
                return et.isWFStepActorIdDirty();
            }
            case 12: {
                return et.isWFStepActorNameDirty();
            }
            case 13: {
                return et.isWFUserIdDirty();
            }
            case 14: {
                return et.isWFUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFReminderBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFReminderBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getActorId() != null) {
            JSONObjectHelper.put(json, "actorid", WFReminderBase.getJSONValue(et.getActorId()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFReminderBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFReminderBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFReminderBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getReminderCount() != null) {
            JSONObjectHelper.put(json, "remindercount", WFReminderBase.getJSONValue(et.getReminderCount()), false);
        }
        if (bIncEmpty || et.getReminderTime() != null) {
            JSONObjectHelper.put(json, "remindertime", WFReminderBase.getJSONValue(et.getReminderTime()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFReminderBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFReminderBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFCreateDate() != null) {
            JSONObjectHelper.put(json, "wfcreatedate", WFReminderBase.getJSONValue(et.getWFCreateDate()), false);
        }
        if (bIncEmpty || et.getWFReminderId() != null) {
            JSONObjectHelper.put(json, "wfreminderid", WFReminderBase.getJSONValue(et.getWFReminderId()), false);
        }
        if (bIncEmpty || et.getWFReminderName() != null) {
            JSONObjectHelper.put(json, "wfremindername", WFReminderBase.getJSONValue(et.getWFReminderName()), false);
        }
        if (bIncEmpty || et.getWFStepActorId() != null) {
            JSONObjectHelper.put(json, "wfstepactorid", WFReminderBase.getJSONValue(et.getWFStepActorId()), false);
        }
        if (bIncEmpty || et.getWFStepActorName() != null) {
            JSONObjectHelper.put(json, "wfstepactorname", WFReminderBase.getJSONValue(et.getWFStepActorName()), false);
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            JSONObjectHelper.put(json, "wfuserid", WFReminderBase.getJSONValue(et.getWFUserId()), false);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            JSONObjectHelper.put(json, "wfusername", WFReminderBase.getJSONValue(et.getWFUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFReminderBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFReminderBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getActorId() != null) {
            obj = et.getActorId();
            node.setAttribute(FIELD_ACTORID, obj == null ? "" : (String)obj);
        }
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
        if (bIncEmpty || et.getReminderCount() != null) {
            obj = et.getReminderCount();
            node.setAttribute(FIELD_REMINDERCOUNT, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getReminderTime() != null) {
            obj = et.getReminderTime();
            node.setAttribute(FIELD_REMINDERTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFCreateDate() != null) {
            obj = et.getWFCreateDate();
            node.setAttribute(FIELD_WFCREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getWFReminderId() != null) {
            obj = et.getWFReminderId();
            node.setAttribute(FIELD_WFREMINDERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFReminderName() != null) {
            obj = et.getWFReminderName();
            node.setAttribute(FIELD_WFREMINDERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepActorId() != null) {
            obj = et.getWFStepActorId();
            node.setAttribute(FIELD_WFSTEPACTORID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFStepActorName() != null) {
            obj = et.getWFStepActorName();
            node.setAttribute(FIELD_WFSTEPACTORNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserId() != null) {
            obj = et.getWFUserId();
            node.setAttribute(FIELD_WFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUserName() != null) {
            obj = et.getWFUserName();
            node.setAttribute(FIELD_WFUSERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFReminderBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFReminderBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isActorIdDirty() && (bIncEmpty || et.getActorId() != null)) {
            dst.set(FIELD_ACTORID, et.getActorId());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isReminderCountDirty() && (bIncEmpty || et.getReminderCount() != null)) {
            dst.set(FIELD_REMINDERCOUNT, et.getReminderCount());
        }
        if (et.isReminderTimeDirty() && (bIncEmpty || et.getReminderTime() != null)) {
            dst.set(FIELD_REMINDERTIME, et.getReminderTime());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFCreateDateDirty() && (bIncEmpty || et.getWFCreateDate() != null)) {
            dst.set(FIELD_WFCREATEDATE, et.getWFCreateDate());
        }
        if (et.isWFReminderIdDirty() && (bIncEmpty || et.getWFReminderId() != null)) {
            dst.set(FIELD_WFREMINDERID, et.getWFReminderId());
        }
        if (et.isWFReminderNameDirty() && (bIncEmpty || et.getWFReminderName() != null)) {
            dst.set(FIELD_WFREMINDERNAME, et.getWFReminderName());
        }
        if (et.isWFStepActorIdDirty() && (bIncEmpty || et.getWFStepActorId() != null)) {
            dst.set(FIELD_WFSTEPACTORID, et.getWFStepActorId());
        }
        if (et.isWFStepActorNameDirty() && (bIncEmpty || et.getWFStepActorName() != null)) {
            dst.set(FIELD_WFSTEPACTORNAME, et.getWFStepActorName());
        }
        if (et.isWFUserIdDirty() && (bIncEmpty || et.getWFUserId() != null)) {
            dst.set(FIELD_WFUSERID, et.getWFUserId());
        }
        if (et.isWFUserNameDirty() && (bIncEmpty || et.getWFUserName() != null)) {
            dst.set(FIELD_WFUSERNAME, et.getWFUserName());
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
        return WFReminderBase.remove(this, index);
    }

    private static boolean remove(WFReminderBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetActorId();
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
                et.resetMemo();
                return true;
            }
            case 4: {
                et.resetReminderCount();
                return true;
            }
            case 5: {
                et.resetReminderTime();
                return true;
            }
            case 6: {
                et.resetUpdateDate();
                return true;
            }
            case 7: {
                et.resetUpdateMan();
                return true;
            }
            case 8: {
                et.resetWFCreateDate();
                return true;
            }
            case 9: {
                et.resetWFReminderId();
                return true;
            }
            case 10: {
                et.resetWFReminderName();
                return true;
            }
            case 11: {
                et.resetWFStepActorId();
                return true;
            }
            case 12: {
                et.resetWFStepActorName();
                return true;
            }
            case 13: {
                et.resetWFUserId();
                return true;
            }
            case 14: {
                et.resetWFUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public WFUser getWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUser();
        }
        if (this.getWFUserId() == null) {
            return null;
        }
        Integer n = this.objWFUserLock;
        synchronized (n) {
            if (this.wfuser != null && DataTypeHelper.compare(25, (Object)this.getWFUserId(), (Object)this.wfuser.getWFUserId()) != 0L) {
                this.wfuser = null;
            }
            if (this.wfuser == null) {
                WFUser wfuser = new WFUser();
                wfuser.setWFUserId(this.getWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(wfuser);
                this.wfuser = wfuser;
            }
            return this.wfuser;
        }
    }

    private WFReminderBase getProxyEntity() {
        return this.proxyWFReminderBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFReminderBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFReminderBase) {
            this.proxyWFReminderBase = (WFReminderBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFReminderService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

