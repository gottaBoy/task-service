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
import net.ibizsys.psrt.srv.wf.service.WFUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class WFUCPolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFUCPolicyBase.class);
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_MAJORWFUSERID = "MAJORWFUSERID";
    public static final String FIELD_MAJORWFUSERNAME = "MAJORWFUSERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINORWFUSERID = "MINORWFUSERID";
    public static final String FIELD_MINORWFUSERNAME = "MINORWFUSERNAME";
    public static final String FIELD_POLICYSTATE = "POLICYSTATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_WFUCPOLICYID = "WFUCPOLICYID";
    public static final String FIELD_WFUCPOLICYNAME = "WFUCPOLICYNAME";
    private static final int INDEX_BEGINTIME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_MAJORWFUSERID = 4;
    private static final int INDEX_MAJORWFUSERNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MINORWFUSERID = 7;
    private static final int INDEX_MINORWFUSERNAME = 8;
    private static final int INDEX_POLICYSTATE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERDATA = 12;
    private static final int INDEX_USERDATA2 = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final int INDEX_WFUCPOLICYID = 15;
    private static final int INDEX_WFUCPOLICYNAME = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFUCPolicyBase proxyWFUCPolicyBase = null;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean majorwfuseridDirtyFlag = false;
    private boolean majorwfusernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minorwfuseridDirtyFlag = false;
    private boolean minorwfusernameDirtyFlag = false;
    private boolean policystateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean wfucpolicyidDirtyFlag = false;
    private boolean wfucpolicynameDirtyFlag = false;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="majorwfuserid")
    private String majorwfuserid;
    @Column(name="majorwfusername")
    private String majorwfusername;
    @Column(name="memo")
    private String memo;
    @Column(name="minorwfuserid")
    private String minorwfuserid;
    @Column(name="minorwfusername")
    private String minorwfusername;
    @Column(name="policystate")
    private Integer policystate;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="wfucpolicyid")
    private String wfucpolicyid;
    @Column(name="wfucpolicyname")
    private String wfucpolicyname;
    private Integer objMajorWFUserLock = new Integer(1);
    private WFUser majorwfuser = null;
    private Integer objMinorWFUserLock = new Integer(1);
    private WFUser minorwfuser = null;

    static {
        fieldIndexMap.put(FIELD_BEGINTIME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_MAJORWFUSERID, 4);
        fieldIndexMap.put(FIELD_MAJORWFUSERNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MINORWFUSERID, 7);
        fieldIndexMap.put(FIELD_MINORWFUSERNAME, 8);
        fieldIndexMap.put(FIELD_POLICYSTATE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERDATA, 12);
        fieldIndexMap.put(FIELD_USERDATA2, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
        fieldIndexMap.put(FIELD_WFUCPOLICYID, 15);
        fieldIndexMap.put(FIELD_WFUCPOLICYNAME, 16);
    }

    public void setBeginTime(Timestamp begintime) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(begintime);
            return;
        }
        this.begintime = begintime;
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

    public void setMajorWFUserId(String majorwfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorWFUserId(majorwfuserid);
            return;
        }
        if (majorwfuserid != null && (majorwfuserid = StringHelper.trimRight(majorwfuserid)).length() == 0) {
            majorwfuserid = null;
        }
        this.majorwfuserid = majorwfuserid;
        this.majorwfuseridDirtyFlag = true;
    }

    public String getMajorWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorWFUserId();
        }
        return this.majorwfuserid;
    }

    public boolean isMajorWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorWFUserIdDirty();
        }
        return this.majorwfuseridDirtyFlag;
    }

    public void resetMajorWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorWFUserId();
            return;
        }
        this.majorwfuseridDirtyFlag = false;
        this.majorwfuserid = null;
    }

    public void setMajorWFUserName(String majorwfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorWFUserName(majorwfusername);
            return;
        }
        if (majorwfusername != null && (majorwfusername = StringHelper.trimRight(majorwfusername)).length() == 0) {
            majorwfusername = null;
        }
        this.majorwfusername = majorwfusername;
        this.majorwfusernameDirtyFlag = true;
    }

    public String getMajorWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorWFUserName();
        }
        return this.majorwfusername;
    }

    public boolean isMajorWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorWFUserNameDirty();
        }
        return this.majorwfusernameDirtyFlag;
    }

    public void resetMajorWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorWFUserName();
            return;
        }
        this.majorwfusernameDirtyFlag = false;
        this.majorwfusername = null;
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

    public void setMinorWFUserId(String minorwfuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorWFUserId(minorwfuserid);
            return;
        }
        if (minorwfuserid != null && (minorwfuserid = StringHelper.trimRight(minorwfuserid)).length() == 0) {
            minorwfuserid = null;
        }
        this.minorwfuserid = minorwfuserid;
        this.minorwfuseridDirtyFlag = true;
    }

    public String getMinorWFUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorWFUserId();
        }
        return this.minorwfuserid;
    }

    public boolean isMinorWFUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorWFUserIdDirty();
        }
        return this.minorwfuseridDirtyFlag;
    }

    public void resetMinorWFUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorWFUserId();
            return;
        }
        this.minorwfuseridDirtyFlag = false;
        this.minorwfuserid = null;
    }

    public void setMinorWFUserName(String minorwfusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorWFUserName(minorwfusername);
            return;
        }
        if (minorwfusername != null && (minorwfusername = StringHelper.trimRight(minorwfusername)).length() == 0) {
            minorwfusername = null;
        }
        this.minorwfusername = minorwfusername;
        this.minorwfusernameDirtyFlag = true;
    }

    public String getMinorWFUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorWFUserName();
        }
        return this.minorwfusername;
    }

    public boolean isMinorWFUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorWFUserNameDirty();
        }
        return this.minorwfusernameDirtyFlag;
    }

    public void resetMinorWFUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorWFUserName();
            return;
        }
        this.minorwfusernameDirtyFlag = false;
        this.minorwfusername = null;
    }

    public void setPolicyState(Integer policystate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyState(policystate);
            return;
        }
        this.policystate = policystate;
        this.policystateDirtyFlag = true;
    }

    public Integer getPolicyState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyState();
        }
        return this.policystate;
    }

    public boolean isPolicyStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyStateDirty();
        }
        return this.policystateDirtyFlag;
    }

    public void resetPolicyState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyState();
            return;
        }
        this.policystateDirtyFlag = false;
        this.policystate = null;
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

    public void setValidFlag(Integer validflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(validflag);
            return;
        }
        this.validflag = validflag;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    public void setWFUCPolicyId(String wfucpolicyid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUCPolicyId(wfucpolicyid);
            return;
        }
        if (wfucpolicyid != null && (wfucpolicyid = StringHelper.trimRight(wfucpolicyid)).length() == 0) {
            wfucpolicyid = null;
        }
        this.wfucpolicyid = wfucpolicyid;
        this.wfucpolicyidDirtyFlag = true;
    }

    public String getWFUCPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUCPolicyId();
        }
        return this.wfucpolicyid;
    }

    public boolean isWFUCPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUCPolicyIdDirty();
        }
        return this.wfucpolicyidDirtyFlag;
    }

    public void resetWFUCPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUCPolicyId();
            return;
        }
        this.wfucpolicyidDirtyFlag = false;
        this.wfucpolicyid = null;
    }

    public void setWFUCPolicyName(String wfucpolicyname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFUCPolicyName(wfucpolicyname);
            return;
        }
        if (wfucpolicyname != null && (wfucpolicyname = StringHelper.trimRight(wfucpolicyname)).length() == 0) {
            wfucpolicyname = null;
        }
        this.wfucpolicyname = wfucpolicyname;
        this.wfucpolicynameDirtyFlag = true;
    }

    public String getWFUCPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFUCPolicyName();
        }
        return this.wfucpolicyname;
    }

    public boolean isWFUCPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFUCPolicyNameDirty();
        }
        return this.wfucpolicynameDirtyFlag;
    }

    public void resetWFUCPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFUCPolicyName();
            return;
        }
        this.wfucpolicynameDirtyFlag = false;
        this.wfucpolicyname = null;
    }

    @Override
    protected void onReset() {
        WFUCPolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFUCPolicyBase et) {
        et.resetBeginTime();
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEndTime();
        et.resetMajorWFUserId();
        et.resetMajorWFUserName();
        et.resetMemo();
        et.resetMinorWFUserId();
        et.resetMinorWFUserName();
        et.resetPolicyState();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetValidFlag();
        et.resetWFUCPolicyId();
        et.resetWFUCPolicyName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isBeginTimeDirty()) {
            params.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEndTimeDirty()) {
            params.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bDirtyOnly || this.isMajorWFUserIdDirty()) {
            params.put(FIELD_MAJORWFUSERID, this.getMajorWFUserId());
        }
        if (!bDirtyOnly || this.isMajorWFUserNameDirty()) {
            params.put(FIELD_MAJORWFUSERNAME, this.getMajorWFUserName());
        }
        if (!bDirtyOnly || this.isMemoDirty()) {
            params.put(FIELD_MEMO, this.getMemo());
        }
        if (!bDirtyOnly || this.isMinorWFUserIdDirty()) {
            params.put(FIELD_MINORWFUSERID, this.getMinorWFUserId());
        }
        if (!bDirtyOnly || this.isMinorWFUserNameDirty()) {
            params.put(FIELD_MINORWFUSERNAME, this.getMinorWFUserName());
        }
        if (!bDirtyOnly || this.isPolicyStateDirty()) {
            params.put(FIELD_POLICYSTATE, this.getPolicyState());
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
        if (!bDirtyOnly || this.isValidFlagDirty()) {
            params.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bDirtyOnly || this.isWFUCPolicyIdDirty()) {
            params.put(FIELD_WFUCPOLICYID, this.getWFUCPolicyId());
        }
        if (!bDirtyOnly || this.isWFUCPolicyNameDirty()) {
            params.put(FIELD_WFUCPOLICYNAME, this.getWFUCPolicyName());
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
        return WFUCPolicyBase.get(this, index);
    }

    private static Object get(WFUCPolicyBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getBeginTime();
            }
            case 1: {
                return et.getCreateDate();
            }
            case 2: {
                return et.getCreateMan();
            }
            case 3: {
                return et.getEndTime();
            }
            case 4: {
                return et.getMajorWFUserId();
            }
            case 5: {
                return et.getMajorWFUserName();
            }
            case 6: {
                return et.getMemo();
            }
            case 7: {
                return et.getMinorWFUserId();
            }
            case 8: {
                return et.getMinorWFUserName();
            }
            case 9: {
                return et.getPolicyState();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
                return et.getUpdateMan();
            }
            case 12: {
                return et.getUserData();
            }
            case 13: {
                return et.getUserData2();
            }
            case 14: {
                return et.getValidFlag();
            }
            case 15: {
                return et.getWFUCPolicyId();
            }
            case 16: {
                return et.getWFUCPolicyName();
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
        WFUCPolicyBase.set(this, index, objValue);
    }

    private static void set(WFUCPolicyBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setBeginTime(DataObject.getTimestampValue(obj));
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
                et.setEndTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setMajorWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setMajorWFUserName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMemo(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMinorWFUserId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setMinorWFUserName(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setPolicyState(DataObject.getIntegerValue(obj));
                return;
            }
            case 10: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 11: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setValidFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 15: {
                et.setWFUCPolicyId(DataObject.getStringValue(obj));
                return;
            }
            case 16: {
                et.setWFUCPolicyName(DataObject.getStringValue(obj));
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
        return WFUCPolicyBase.isNull(this, index);
    }

    private static boolean isNull(WFUCPolicyBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getBeginTime() == null;
            }
            case 1: {
                return et.getCreateDate() == null;
            }
            case 2: {
                return et.getCreateMan() == null;
            }
            case 3: {
                return et.getEndTime() == null;
            }
            case 4: {
                return et.getMajorWFUserId() == null;
            }
            case 5: {
                return et.getMajorWFUserName() == null;
            }
            case 6: {
                return et.getMemo() == null;
            }
            case 7: {
                return et.getMinorWFUserId() == null;
            }
            case 8: {
                return et.getMinorWFUserName() == null;
            }
            case 9: {
                return et.getPolicyState() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
                return et.getUpdateMan() == null;
            }
            case 12: {
                return et.getUserData() == null;
            }
            case 13: {
                return et.getUserData2() == null;
            }
            case 14: {
                return et.getValidFlag() == null;
            }
            case 15: {
                return et.getWFUCPolicyId() == null;
            }
            case 16: {
                return et.getWFUCPolicyName() == null;
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
        return WFUCPolicyBase.contains(this, index);
    }

    private static boolean contains(WFUCPolicyBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isBeginTimeDirty();
            }
            case 1: {
                return et.isCreateDateDirty();
            }
            case 2: {
                return et.isCreateManDirty();
            }
            case 3: {
                return et.isEndTimeDirty();
            }
            case 4: {
                return et.isMajorWFUserIdDirty();
            }
            case 5: {
                return et.isMajorWFUserNameDirty();
            }
            case 6: {
                return et.isMemoDirty();
            }
            case 7: {
                return et.isMinorWFUserIdDirty();
            }
            case 8: {
                return et.isMinorWFUserNameDirty();
            }
            case 9: {
                return et.isPolicyStateDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
            case 12: {
                return et.isUserDataDirty();
            }
            case 13: {
                return et.isUserData2Dirty();
            }
            case 14: {
                return et.isValidFlagDirty();
            }
            case 15: {
                return et.isWFUCPolicyIdDirty();
            }
            case 16: {
                return et.isWFUCPolicyNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFUCPolicyBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFUCPolicyBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getBeginTime() != null) {
            JSONObjectHelper.put(json, "begintime", WFUCPolicyBase.getJSONValue(et.getBeginTime()), false);
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFUCPolicyBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFUCPolicyBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEndTime() != null) {
            JSONObjectHelper.put(json, "endtime", WFUCPolicyBase.getJSONValue(et.getEndTime()), false);
        }
        if (bIncEmpty || et.getMajorWFUserId() != null) {
            JSONObjectHelper.put(json, "majorwfuserid", WFUCPolicyBase.getJSONValue(et.getMajorWFUserId()), false);
        }
        if (bIncEmpty || et.getMajorWFUserName() != null) {
            JSONObjectHelper.put(json, "majorwfusername", WFUCPolicyBase.getJSONValue(et.getMajorWFUserName()), false);
        }
        if (bIncEmpty || et.getMemo() != null) {
            JSONObjectHelper.put(json, "memo", WFUCPolicyBase.getJSONValue(et.getMemo()), false);
        }
        if (bIncEmpty || et.getMinorWFUserId() != null) {
            JSONObjectHelper.put(json, "minorwfuserid", WFUCPolicyBase.getJSONValue(et.getMinorWFUserId()), false);
        }
        if (bIncEmpty || et.getMinorWFUserName() != null) {
            JSONObjectHelper.put(json, "minorwfusername", WFUCPolicyBase.getJSONValue(et.getMinorWFUserName()), false);
        }
        if (bIncEmpty || et.getPolicyState() != null) {
            JSONObjectHelper.put(json, "policystate", WFUCPolicyBase.getJSONValue(et.getPolicyState()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFUCPolicyBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFUCPolicyBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", WFUCPolicyBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", WFUCPolicyBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getValidFlag() != null) {
            JSONObjectHelper.put(json, "validflag", WFUCPolicyBase.getJSONValue(et.getValidFlag()), false);
        }
        if (bIncEmpty || et.getWFUCPolicyId() != null) {
            JSONObjectHelper.put(json, "wfucpolicyid", WFUCPolicyBase.getJSONValue(et.getWFUCPolicyId()), false);
        }
        if (bIncEmpty || et.getWFUCPolicyName() != null) {
            JSONObjectHelper.put(json, "wfucpolicyname", WFUCPolicyBase.getJSONValue(et.getWFUCPolicyName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFUCPolicyBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFUCPolicyBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getBeginTime() != null) {
            obj = et.getBeginTime();
            node.setAttribute(FIELD_BEGINTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEndTime() != null) {
            obj = et.getEndTime();
            node.setAttribute(FIELD_ENDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getMajorWFUserId() != null) {
            obj = et.getMajorWFUserId();
            node.setAttribute(FIELD_MAJORWFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMajorWFUserName() != null) {
            obj = et.getMajorWFUserName();
            node.setAttribute(FIELD_MAJORWFUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMemo() != null) {
            obj = et.getMemo();
            node.setAttribute(FIELD_MEMO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorWFUserId() != null) {
            obj = et.getMinorWFUserId();
            node.setAttribute(FIELD_MINORWFUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorWFUserName() != null) {
            obj = et.getMinorWFUserName();
            node.setAttribute(FIELD_MINORWFUSERNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getPolicyState() != null) {
            obj = et.getPolicyState();
            node.setAttribute(FIELD_POLICYSTATE, obj == null ? "" : StringHelper.format("%1$s", obj));
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
        if (bIncEmpty || et.getValidFlag() != null) {
            obj = et.getValidFlag();
            node.setAttribute(FIELD_VALIDFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getWFUCPolicyId() != null) {
            obj = et.getWFUCPolicyId();
            node.setAttribute(FIELD_WFUCPOLICYID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFUCPolicyName() != null) {
            obj = et.getWFUCPolicyName();
            node.setAttribute(FIELD_WFUCPOLICYNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFUCPolicyBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFUCPolicyBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isBeginTimeDirty() && (bIncEmpty || et.getBeginTime() != null)) {
            dst.set(FIELD_BEGINTIME, et.getBeginTime());
        }
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEndTimeDirty() && (bIncEmpty || et.getEndTime() != null)) {
            dst.set(FIELD_ENDTIME, et.getEndTime());
        }
        if (et.isMajorWFUserIdDirty() && (bIncEmpty || et.getMajorWFUserId() != null)) {
            dst.set(FIELD_MAJORWFUSERID, et.getMajorWFUserId());
        }
        if (et.isMajorWFUserNameDirty() && (bIncEmpty || et.getMajorWFUserName() != null)) {
            dst.set(FIELD_MAJORWFUSERNAME, et.getMajorWFUserName());
        }
        if (et.isMemoDirty() && (bIncEmpty || et.getMemo() != null)) {
            dst.set(FIELD_MEMO, et.getMemo());
        }
        if (et.isMinorWFUserIdDirty() && (bIncEmpty || et.getMinorWFUserId() != null)) {
            dst.set(FIELD_MINORWFUSERID, et.getMinorWFUserId());
        }
        if (et.isMinorWFUserNameDirty() && (bIncEmpty || et.getMinorWFUserName() != null)) {
            dst.set(FIELD_MINORWFUSERNAME, et.getMinorWFUserName());
        }
        if (et.isPolicyStateDirty() && (bIncEmpty || et.getPolicyState() != null)) {
            dst.set(FIELD_POLICYSTATE, et.getPolicyState());
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
        if (et.isValidFlagDirty() && (bIncEmpty || et.getValidFlag() != null)) {
            dst.set(FIELD_VALIDFLAG, et.getValidFlag());
        }
        if (et.isWFUCPolicyIdDirty() && (bIncEmpty || et.getWFUCPolicyId() != null)) {
            dst.set(FIELD_WFUCPOLICYID, et.getWFUCPolicyId());
        }
        if (et.isWFUCPolicyNameDirty() && (bIncEmpty || et.getWFUCPolicyName() != null)) {
            dst.set(FIELD_WFUCPOLICYNAME, et.getWFUCPolicyName());
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
        return WFUCPolicyBase.remove(this, index);
    }

    private static boolean remove(WFUCPolicyBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetBeginTime();
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
                et.resetEndTime();
                return true;
            }
            case 4: {
                et.resetMajorWFUserId();
                return true;
            }
            case 5: {
                et.resetMajorWFUserName();
                return true;
            }
            case 6: {
                et.resetMemo();
                return true;
            }
            case 7: {
                et.resetMinorWFUserId();
                return true;
            }
            case 8: {
                et.resetMinorWFUserName();
                return true;
            }
            case 9: {
                et.resetPolicyState();
                return true;
            }
            case 10: {
                et.resetUpdateDate();
                return true;
            }
            case 11: {
                et.resetUpdateMan();
                return true;
            }
            case 12: {
                et.resetUserData();
                return true;
            }
            case 13: {
                et.resetUserData2();
                return true;
            }
            case 14: {
                et.resetValidFlag();
                return true;
            }
            case 15: {
                et.resetWFUCPolicyId();
                return true;
            }
            case 16: {
                et.resetWFUCPolicyName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getMajorWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorWFUser();
        }
        if (this.getMajorWFUserId() == null) {
            return null;
        }
        Integer n = this.objMajorWFUserLock;
        synchronized (n) {
            if (this.majorwfuser != null && DataTypeHelper.compare(25, (Object)this.getMajorWFUserId(), (Object)this.majorwfuser.getWFUserId()) != 0L) {
                this.majorwfuser = null;
            }
            if (this.majorwfuser == null) {
                WFUser majorwfuser = new WFUser();
                majorwfuser.setWFUserId(this.getMajorWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(majorwfuser);
                this.majorwfuser = majorwfuser;
            }
            return this.majorwfuser;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public WFUser getMinorWFUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorWFUser();
        }
        if (this.getMinorWFUserId() == null) {
            return null;
        }
        Integer n = this.objMinorWFUserLock;
        synchronized (n) {
            if (this.minorwfuser != null && DataTypeHelper.compare(25, (Object)this.getMinorWFUserId(), (Object)this.minorwfuser.getWFUserId()) != 0L) {
                this.minorwfuser = null;
            }
            if (this.minorwfuser == null) {
                WFUser minorwfuser = new WFUser();
                minorwfuser.setWFUserId(this.getMinorWFUserId());
                WFUserService service = (WFUserService)ServiceGlobal.getService(WFUserService.class, this.getSessionFactory());
                service.autoGet(minorwfuser);
                this.minorwfuser = minorwfuser;
            }
            return this.minorwfuser;
        }
    }

    private WFUCPolicyBase getProxyEntity() {
        return this.proxyWFUCPolicyBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFUCPolicyBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFUCPolicyBase) {
            this.proxyWFUCPolicyBase = (WFUCPolicyBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFUCPolicyService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

