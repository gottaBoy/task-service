/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

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
import net.ibizsys.psrt.srv.common.entity.TSSDEngine;
import net.ibizsys.psrt.srv.common.service.TSSDEngineService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class TSSDTaskBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEFLAG = "ENABLEFLAG";
    public static final String FIELD_TASKPARAM = "TASKPARAM";
    public static final String FIELD_TSSDENGINEID = "TSSDENGINEID";
    public static final String FIELD_TSSDENGINENAME = "TSSDENGINENAME";
    public static final String FIELD_TSSDTASKID = "TSSDTASKID";
    public static final String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERDATA3 = "USERDATA3";
    public static final String FIELD_USERDATA4 = "USERDATA4";
    public static final String FIELD_VERSION = "VERSION";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLEFLAG = 2;
    private static final int INDEX_TASKPARAM = 3;
    private static final int INDEX_TSSDENGINEID = 4;
    private static final int INDEX_TSSDENGINENAME = 5;
    private static final int INDEX_TSSDTASKID = 6;
    private static final int INDEX_TSSDTASKNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_USERDATA = 10;
    private static final int INDEX_USERDATA2 = 11;
    private static final int INDEX_USERDATA3 = 12;
    private static final int INDEX_USERDATA4 = 13;
    private static final int INDEX_VERSION = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDTaskBase proxyTSSDTaskBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableflagDirtyFlag = false;
    private boolean taskparamDirtyFlag = false;
    private boolean tssdengineidDirtyFlag = false;
    private boolean tssdenginenameDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userdata3DirtyFlag = false;
    private boolean userdata4DirtyFlag = false;
    private boolean versionDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableflag")
    private Integer enableflag;
    @Column(name="taskparam")
    private String taskparam;
    @Column(name="tssdengineid")
    private String tssdengineid;
    @Column(name="tssdenginename")
    private String tssdenginename;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
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
    @Column(name="version")
    private Integer version;
    private Integer objTSSDEngineLock = new Integer(1);
    private TSSDEngine tssdengine = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLEFLAG, 2);
        fieldIndexMap.put(FIELD_TASKPARAM, 3);
        fieldIndexMap.put(FIELD_TSSDENGINEID, 4);
        fieldIndexMap.put(FIELD_TSSDENGINENAME, 5);
        fieldIndexMap.put(FIELD_TSSDTASKID, 6);
        fieldIndexMap.put(FIELD_TSSDTASKNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_USERDATA, 10);
        fieldIndexMap.put(FIELD_USERDATA2, 11);
        fieldIndexMap.put(FIELD_USERDATA3, 12);
        fieldIndexMap.put(FIELD_USERDATA4, 13);
        fieldIndexMap.put(FIELD_VERSION, 14);
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

    public void setEnableFlag(Integer enableflag) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableFlag(enableflag);
            return;
        }
        this.enableflag = enableflag;
        this.enableflagDirtyFlag = true;
    }

    public Integer getEnableFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableFlag();
        }
        return this.enableflag;
    }

    public boolean isEnableFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableFlagDirty();
        }
        return this.enableflagDirtyFlag;
    }

    public void resetEnableFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableFlag();
            return;
        }
        this.enableflagDirtyFlag = false;
        this.enableflag = null;
    }

    public void setTaskParam(String taskparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskParam(taskparam);
            return;
        }
        if (taskparam != null && (taskparam = StringHelper.trimRight(taskparam)).length() == 0) {
            taskparam = null;
        }
        this.taskparam = taskparam;
        this.taskparamDirtyFlag = true;
    }

    public String getTaskParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskParam();
        }
        return this.taskparam;
    }

    public boolean isTaskParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskParamDirty();
        }
        return this.taskparamDirtyFlag;
    }

    public void resetTaskParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskParam();
            return;
        }
        this.taskparamDirtyFlag = false;
        this.taskparam = null;
    }

    public void setTSSDEngineId(String tssdengineid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDEngineId(tssdengineid);
            return;
        }
        if (tssdengineid != null && (tssdengineid = StringHelper.trimRight(tssdengineid)).length() == 0) {
            tssdengineid = null;
        }
        this.tssdengineid = tssdengineid;
        this.tssdengineidDirtyFlag = true;
    }

    public String getTSSDEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDEngineId();
        }
        return this.tssdengineid;
    }

    public boolean isTSSDEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDEngineIdDirty();
        }
        return this.tssdengineidDirtyFlag;
    }

    public void resetTSSDEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDEngineId();
            return;
        }
        this.tssdengineidDirtyFlag = false;
        this.tssdengineid = null;
    }

    public void setTSSDEngineName(String tssdenginename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDEngineName(tssdenginename);
            return;
        }
        if (tssdenginename != null && (tssdenginename = StringHelper.trimRight(tssdenginename)).length() == 0) {
            tssdenginename = null;
        }
        this.tssdenginename = tssdenginename;
        this.tssdenginenameDirtyFlag = true;
    }

    public String getTSSDEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDEngineName();
        }
        return this.tssdenginename;
    }

    public boolean isTSSDEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDEngineNameDirty();
        }
        return this.tssdenginenameDirtyFlag;
    }

    public void resetTSSDEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDEngineName();
            return;
        }
        this.tssdenginenameDirtyFlag = false;
        this.tssdenginename = null;
    }

    public void setTSSDTaskId(String tssdtaskid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskId(tssdtaskid);
            return;
        }
        if (tssdtaskid != null && (tssdtaskid = StringHelper.trimRight(tssdtaskid)).length() == 0) {
            tssdtaskid = null;
        }
        this.tssdtaskid = tssdtaskid;
        this.tssdtaskidDirtyFlag = true;
    }

    public String getTSSDTaskId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskId();
        }
        return this.tssdtaskid;
    }

    public boolean isTSSDTaskIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskIdDirty();
        }
        return this.tssdtaskidDirtyFlag;
    }

    public void resetTSSDTaskId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskId();
            return;
        }
        this.tssdtaskidDirtyFlag = false;
        this.tssdtaskid = null;
    }

    public void setTSSDTaskName(String tssdtaskname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskName(tssdtaskname);
            return;
        }
        if (tssdtaskname != null && (tssdtaskname = StringHelper.trimRight(tssdtaskname)).length() == 0) {
            tssdtaskname = null;
        }
        this.tssdtaskname = tssdtaskname;
        this.tssdtasknameDirtyFlag = true;
    }

    public String getTSSDTaskName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskName();
        }
        return this.tssdtaskname;
    }

    public boolean isTSSDTaskNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskNameDirty();
        }
        return this.tssdtasknameDirtyFlag;
    }

    public void resetTSSDTaskName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskName();
            return;
        }
        this.tssdtasknameDirtyFlag = false;
        this.tssdtaskname = null;
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

    public void setVersion(Integer version) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVersion(version);
            return;
        }
        this.version = version;
        this.versionDirtyFlag = true;
    }

    public Integer getVersion() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVersion();
        }
        return this.version;
    }

    public boolean isVersionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVersionDirty();
        }
        return this.versionDirtyFlag;
    }

    public void resetVersion() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVersion();
            return;
        }
        this.versionDirtyFlag = false;
        this.version = null;
    }

    @Override
    protected void onReset() {
        TSSDTaskBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDTaskBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetEnableFlag();
        et.resetTaskParam();
        et.resetTSSDEngineId();
        et.resetTSSDEngineName();
        et.resetTSSDTaskId();
        et.resetTSSDTaskName();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserData();
        et.resetUserData2();
        et.resetUserData3();
        et.resetUserData4();
        et.resetVersion();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isEnableFlagDirty()) {
            params.put(FIELD_ENABLEFLAG, this.getEnableFlag());
        }
        if (!bDirtyOnly || this.isTaskParamDirty()) {
            params.put(FIELD_TASKPARAM, this.getTaskParam());
        }
        if (!bDirtyOnly || this.isTSSDEngineIdDirty()) {
            params.put(FIELD_TSSDENGINEID, this.getTSSDEngineId());
        }
        if (!bDirtyOnly || this.isTSSDEngineNameDirty()) {
            params.put(FIELD_TSSDENGINENAME, this.getTSSDEngineName());
        }
        if (!bDirtyOnly || this.isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID, this.getTSSDTaskId());
        }
        if (!bDirtyOnly || this.isTSSDTaskNameDirty()) {
            params.put(FIELD_TSSDTASKNAME, this.getTSSDTaskName());
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
        if (!bDirtyOnly || this.isVersionDirty()) {
            params.put(FIELD_VERSION, this.getVersion());
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
        return TSSDTaskBase.get(this, index);
    }

    private static Object get(TSSDTaskBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getEnableFlag();
            }
            case 3: {
                return et.getTaskParam();
            }
            case 4: {
                return et.getTSSDEngineId();
            }
            case 5: {
                return et.getTSSDEngineName();
            }
            case 6: {
                return et.getTSSDTaskId();
            }
            case 7: {
                return et.getTSSDTaskName();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
                return et.getUpdateMan();
            }
            case 10: {
                return et.getUserData();
            }
            case 11: {
                return et.getUserData2();
            }
            case 12: {
                return et.getUserData3();
            }
            case 13: {
                return et.getUserData4();
            }
            case 14: {
                return et.getVersion();
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
        TSSDTaskBase.set(this, index, objValue);
    }

    private static void set(TSSDTaskBase et, int index, Object obj) throws Exception {
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
                et.setEnableFlag(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setTaskParam(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setTSSDEngineId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setTSSDEngineName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setTSSDTaskId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setTSSDTaskName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setUserData(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUserData2(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUserData3(DataObject.getStringValue(obj));
                return;
            }
            case 13: {
                et.setUserData4(DataObject.getStringValue(obj));
                return;
            }
            case 14: {
                et.setVersion(DataObject.getIntegerValue(obj));
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
        return TSSDTaskBase.isNull(this, index);
    }

    private static boolean isNull(TSSDTaskBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getEnableFlag() == null;
            }
            case 3: {
                return et.getTaskParam() == null;
            }
            case 4: {
                return et.getTSSDEngineId() == null;
            }
            case 5: {
                return et.getTSSDEngineName() == null;
            }
            case 6: {
                return et.getTSSDTaskId() == null;
            }
            case 7: {
                return et.getTSSDTaskName() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
                return et.getUpdateMan() == null;
            }
            case 10: {
                return et.getUserData() == null;
            }
            case 11: {
                return et.getUserData2() == null;
            }
            case 12: {
                return et.getUserData3() == null;
            }
            case 13: {
                return et.getUserData4() == null;
            }
            case 14: {
                return et.getVersion() == null;
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
        return TSSDTaskBase.contains(this, index);
    }

    private static boolean contains(TSSDTaskBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isEnableFlagDirty();
            }
            case 3: {
                return et.isTaskParamDirty();
            }
            case 4: {
                return et.isTSSDEngineIdDirty();
            }
            case 5: {
                return et.isTSSDEngineNameDirty();
            }
            case 6: {
                return et.isTSSDTaskIdDirty();
            }
            case 7: {
                return et.isTSSDTaskNameDirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
            case 10: {
                return et.isUserDataDirty();
            }
            case 11: {
                return et.isUserData2Dirty();
            }
            case 12: {
                return et.isUserData3Dirty();
            }
            case 13: {
                return et.isUserData4Dirty();
            }
            case 14: {
                return et.isVersionDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDTaskBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDTaskBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDTaskBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDTaskBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getEnableFlag() != null) {
            JSONObjectHelper.put(json, "enableflag", TSSDTaskBase.getJSONValue(et.getEnableFlag()), false);
        }
        if (bIncEmpty || et.getTaskParam() != null) {
            JSONObjectHelper.put(json, "taskparam", TSSDTaskBase.getJSONValue(et.getTaskParam()), false);
        }
        if (bIncEmpty || et.getTSSDEngineId() != null) {
            JSONObjectHelper.put(json, "tssdengineid", TSSDTaskBase.getJSONValue(et.getTSSDEngineId()), false);
        }
        if (bIncEmpty || et.getTSSDEngineName() != null) {
            JSONObjectHelper.put(json, "tssdenginename", TSSDTaskBase.getJSONValue(et.getTSSDEngineName()), false);
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            JSONObjectHelper.put(json, "tssdtaskid", TSSDTaskBase.getJSONValue(et.getTSSDTaskId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskName() != null) {
            JSONObjectHelper.put(json, "tssdtaskname", TSSDTaskBase.getJSONValue(et.getTSSDTaskName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDTaskBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDTaskBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserData() != null) {
            JSONObjectHelper.put(json, "userdata", TSSDTaskBase.getJSONValue(et.getUserData()), false);
        }
        if (bIncEmpty || et.getUserData2() != null) {
            JSONObjectHelper.put(json, "userdata2", TSSDTaskBase.getJSONValue(et.getUserData2()), false);
        }
        if (bIncEmpty || et.getUserData3() != null) {
            JSONObjectHelper.put(json, "userdata3", TSSDTaskBase.getJSONValue(et.getUserData3()), false);
        }
        if (bIncEmpty || et.getUserData4() != null) {
            JSONObjectHelper.put(json, "userdata4", TSSDTaskBase.getJSONValue(et.getUserData4()), false);
        }
        if (bIncEmpty || et.getVersion() != null) {
            JSONObjectHelper.put(json, "version", TSSDTaskBase.getJSONValue(et.getVersion()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDTaskBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDTaskBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getEnableFlag() != null) {
            obj = et.getEnableFlag();
            node.setAttribute(FIELD_ENABLEFLAG, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getTaskParam() != null) {
            obj = et.getTaskParam();
            node.setAttribute(FIELD_TASKPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDEngineId() != null) {
            obj = et.getTSSDEngineId();
            node.setAttribute(FIELD_TSSDENGINEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDEngineName() != null) {
            obj = et.getTSSDEngineName();
            node.setAttribute(FIELD_TSSDENGINENAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            obj = et.getTSSDTaskId();
            node.setAttribute(FIELD_TSSDTASKID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskName() != null) {
            obj = et.getTSSDTaskName();
            node.setAttribute(FIELD_TSSDTASKNAME, obj == null ? "" : (String)obj);
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
        if (bIncEmpty || et.getVersion() != null) {
            obj = et.getVersion();
            node.setAttribute(FIELD_VERSION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDTaskBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDTaskBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isEnableFlagDirty() && (bIncEmpty || et.getEnableFlag() != null)) {
            dst.set(FIELD_ENABLEFLAG, et.getEnableFlag());
        }
        if (et.isTaskParamDirty() && (bIncEmpty || et.getTaskParam() != null)) {
            dst.set(FIELD_TASKPARAM, et.getTaskParam());
        }
        if (et.isTSSDEngineIdDirty() && (bIncEmpty || et.getTSSDEngineId() != null)) {
            dst.set(FIELD_TSSDENGINEID, et.getTSSDEngineId());
        }
        if (et.isTSSDEngineNameDirty() && (bIncEmpty || et.getTSSDEngineName() != null)) {
            dst.set(FIELD_TSSDENGINENAME, et.getTSSDEngineName());
        }
        if (et.isTSSDTaskIdDirty() && (bIncEmpty || et.getTSSDTaskId() != null)) {
            dst.set(FIELD_TSSDTASKID, et.getTSSDTaskId());
        }
        if (et.isTSSDTaskNameDirty() && (bIncEmpty || et.getTSSDTaskName() != null)) {
            dst.set(FIELD_TSSDTASKNAME, et.getTSSDTaskName());
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
        if (et.isVersionDirty() && (bIncEmpty || et.getVersion() != null)) {
            dst.set(FIELD_VERSION, et.getVersion());
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
        return TSSDTaskBase.remove(this, index);
    }

    private static boolean remove(TSSDTaskBase et, int index) throws Exception {
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
                et.resetEnableFlag();
                return true;
            }
            case 3: {
                et.resetTaskParam();
                return true;
            }
            case 4: {
                et.resetTSSDEngineId();
                return true;
            }
            case 5: {
                et.resetTSSDEngineName();
                return true;
            }
            case 6: {
                et.resetTSSDTaskId();
                return true;
            }
            case 7: {
                et.resetTSSDTaskName();
                return true;
            }
            case 8: {
                et.resetUpdateDate();
                return true;
            }
            case 9: {
                et.resetUpdateMan();
                return true;
            }
            case 10: {
                et.resetUserData();
                return true;
            }
            case 11: {
                et.resetUserData2();
                return true;
            }
            case 12: {
                et.resetUserData3();
                return true;
            }
            case 13: {
                et.resetUserData4();
                return true;
            }
            case 14: {
                et.resetVersion();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TSSDEngine getTSSDEngine() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDEngine();
        }
        if (this.getTSSDEngineId() == null) {
            return null;
        }
        Integer n = this.objTSSDEngineLock;
        synchronized (n) {
            if (this.tssdengine != null && DataTypeHelper.compare(25, (Object)this.getTSSDEngineId(), (Object)this.tssdengine.getTSSDEngineId()) != 0L) {
                this.tssdengine = null;
            }
            if (this.tssdengine == null) {
                TSSDEngine tssdengine = new TSSDEngine();
                tssdengine.setTSSDEngineId(this.getTSSDEngineId());
                TSSDEngineService service = (TSSDEngineService)ServiceGlobal.getService(TSSDEngineService.class, this.getSessionFactory());
                service.autoGet(tssdengine);
                this.tssdengine = tssdengine;
            }
            return this.tssdengine;
        }
    }

    private TSSDTaskBase getProxyEntity() {
        return this.proxyTSSDTaskBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDTaskBase) {
            this.proxyTSSDTaskBase = (TSSDTaskBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

