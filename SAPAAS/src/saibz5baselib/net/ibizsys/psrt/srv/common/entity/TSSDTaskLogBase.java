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
import net.ibizsys.psrt.srv.common.entity.TSSDTask;
import net.ibizsys.psrt.srv.common.service.TSSDTaskService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class TSSDTaskLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DURATION = "DURATION";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_RETCODE = "RETCODE";
    public static final String FIELD_RETINFO = "RETINFO";
    public static final String FIELD_STARTTIME = "STARTTIME";
    public static final String FIELD_TSSDTASKID = "TSSDTASKID";
    public static final String FIELD_TSSDTASKLOGID = "TSSDTASKLOGID";
    public static final String FIELD_TSSDTASKLOGNAME = "TSSDTASKLOGNAME";
    public static final String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DURATION = 2;
    private static final int INDEX_ENDTIME = 3;
    private static final int INDEX_RETCODE = 4;
    private static final int INDEX_RETINFO = 5;
    private static final int INDEX_STARTTIME = 6;
    private static final int INDEX_TSSDTASKID = 7;
    private static final int INDEX_TSSDTASKLOGID = 8;
    private static final int INDEX_TSSDTASKLOGNAME = 9;
    private static final int INDEX_TSSDTASKNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDTaskLogBase proxyTSSDTaskLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean durationDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean retcodeDirtyFlag = false;
    private boolean retinfoDirtyFlag = false;
    private boolean starttimeDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasklogidDirtyFlag = false;
    private boolean tssdtasklognameDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="duration")
    private Integer duration;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="retcode")
    private Integer retcode;
    @Column(name="retinfo")
    private String retinfo;
    @Column(name="starttime")
    private Timestamp starttime;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtasklogid")
    private String tssdtasklogid;
    @Column(name="tssdtasklogname")
    private String tssdtasklogname;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objTSSDTaskLock = new Integer(1);
    private TSSDTask tssdtask = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DURATION, 2);
        fieldIndexMap.put(FIELD_ENDTIME, 3);
        fieldIndexMap.put(FIELD_RETCODE, 4);
        fieldIndexMap.put(FIELD_RETINFO, 5);
        fieldIndexMap.put(FIELD_STARTTIME, 6);
        fieldIndexMap.put(FIELD_TSSDTASKID, 7);
        fieldIndexMap.put(FIELD_TSSDTASKLOGID, 8);
        fieldIndexMap.put(FIELD_TSSDTASKLOGNAME, 9);
        fieldIndexMap.put(FIELD_TSSDTASKNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
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

    public void setDuration(Integer duration) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDuration(duration);
            return;
        }
        this.duration = duration;
        this.durationDirtyFlag = true;
    }

    public Integer getDuration() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDuration();
        }
        return this.duration;
    }

    public boolean isDurationDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDurationDirty();
        }
        return this.durationDirtyFlag;
    }

    public void resetDuration() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDuration();
            return;
        }
        this.durationDirtyFlag = false;
        this.duration = null;
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

    public void setRetCode(Integer retcode) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetCode(retcode);
            return;
        }
        this.retcode = retcode;
        this.retcodeDirtyFlag = true;
    }

    public Integer getRetCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetCode();
        }
        return this.retcode;
    }

    public boolean isRetCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetCodeDirty();
        }
        return this.retcodeDirtyFlag;
    }

    public void resetRetCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetCode();
            return;
        }
        this.retcodeDirtyFlag = false;
        this.retcode = null;
    }

    public void setRetInfo(String retinfo) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRetInfo(retinfo);
            return;
        }
        if (retinfo != null && (retinfo = StringHelper.trimRight(retinfo)).length() == 0) {
            retinfo = null;
        }
        this.retinfo = retinfo;
        this.retinfoDirtyFlag = true;
    }

    public String getRetInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRetInfo();
        }
        return this.retinfo;
    }

    public boolean isRetInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRetInfoDirty();
        }
        return this.retinfoDirtyFlag;
    }

    public void resetRetInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRetInfo();
            return;
        }
        this.retinfoDirtyFlag = false;
        this.retinfo = null;
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

    public void setTSSDTaskLogId(String tssdtasklogid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskLogId(tssdtasklogid);
            return;
        }
        if (tssdtasklogid != null && (tssdtasklogid = StringHelper.trimRight(tssdtasklogid)).length() == 0) {
            tssdtasklogid = null;
        }
        this.tssdtasklogid = tssdtasklogid;
        this.tssdtasklogidDirtyFlag = true;
    }

    public String getTSSDTaskLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskLogId();
        }
        return this.tssdtasklogid;
    }

    public boolean isTSSDTaskLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskLogIdDirty();
        }
        return this.tssdtasklogidDirtyFlag;
    }

    public void resetTSSDTaskLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskLogId();
            return;
        }
        this.tssdtasklogidDirtyFlag = false;
        this.tssdtasklogid = null;
    }

    public void setTSSDTaskLogName(String tssdtasklogname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskLogName(tssdtasklogname);
            return;
        }
        if (tssdtasklogname != null && (tssdtasklogname = StringHelper.trimRight(tssdtasklogname)).length() == 0) {
            tssdtasklogname = null;
        }
        this.tssdtasklogname = tssdtasklogname;
        this.tssdtasklognameDirtyFlag = true;
    }

    public String getTSSDTaskLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskLogName();
        }
        return this.tssdtasklogname;
    }

    public boolean isTSSDTaskLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskLogNameDirty();
        }
        return this.tssdtasklognameDirtyFlag;
    }

    public void resetTSSDTaskLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskLogName();
            return;
        }
        this.tssdtasklognameDirtyFlag = false;
        this.tssdtasklogname = null;
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

    @Override
    protected void onReset() {
        TSSDTaskLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDTaskLogBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetDuration();
        et.resetEndTime();
        et.resetRetCode();
        et.resetRetInfo();
        et.resetStartTime();
        et.resetTSSDTaskId();
        et.resetTSSDTaskLogId();
        et.resetTSSDTaskLogName();
        et.resetTSSDTaskName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isDurationDirty()) {
            params.put(FIELD_DURATION, this.getDuration());
        }
        if (!bDirtyOnly || this.isEndTimeDirty()) {
            params.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bDirtyOnly || this.isRetCodeDirty()) {
            params.put(FIELD_RETCODE, this.getRetCode());
        }
        if (!bDirtyOnly || this.isRetInfoDirty()) {
            params.put(FIELD_RETINFO, this.getRetInfo());
        }
        if (!bDirtyOnly || this.isStartTimeDirty()) {
            params.put(FIELD_STARTTIME, this.getStartTime());
        }
        if (!bDirtyOnly || this.isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID, this.getTSSDTaskId());
        }
        if (!bDirtyOnly || this.isTSSDTaskLogIdDirty()) {
            params.put(FIELD_TSSDTASKLOGID, this.getTSSDTaskLogId());
        }
        if (!bDirtyOnly || this.isTSSDTaskLogNameDirty()) {
            params.put(FIELD_TSSDTASKLOGNAME, this.getTSSDTaskLogName());
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
        return TSSDTaskLogBase.get(this, index);
    }

    private static Object get(TSSDTaskLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getDuration();
            }
            case 3: {
                return et.getEndTime();
            }
            case 4: {
                return et.getRetCode();
            }
            case 5: {
                return et.getRetInfo();
            }
            case 6: {
                return et.getStartTime();
            }
            case 7: {
                return et.getTSSDTaskId();
            }
            case 8: {
                return et.getTSSDTaskLogId();
            }
            case 9: {
                return et.getTSSDTaskLogName();
            }
            case 10: {
                return et.getTSSDTaskName();
            }
            case 11: {
                return et.getUpdateDate();
            }
            case 12: {
                return et.getUpdateMan();
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
        TSSDTaskLogBase.set(this, index, objValue);
    }

    private static void set(TSSDTaskLogBase et, int index, Object obj) throws Exception {
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
                et.setDuration(DataObject.getIntegerValue(obj));
                return;
            }
            case 3: {
                et.setEndTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setRetCode(DataObject.getIntegerValue(obj));
                return;
            }
            case 5: {
                et.setRetInfo(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setStartTime(DataObject.getTimestampValue(obj));
                return;
            }
            case 7: {
                et.setTSSDTaskId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDTaskLogId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDTaskLogName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setTSSDTaskName(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 12: {
                et.setUpdateMan(DataObject.getStringValue(obj));
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
        return TSSDTaskLogBase.isNull(this, index);
    }

    private static boolean isNull(TSSDTaskLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getDuration() == null;
            }
            case 3: {
                return et.getEndTime() == null;
            }
            case 4: {
                return et.getRetCode() == null;
            }
            case 5: {
                return et.getRetInfo() == null;
            }
            case 6: {
                return et.getStartTime() == null;
            }
            case 7: {
                return et.getTSSDTaskId() == null;
            }
            case 8: {
                return et.getTSSDTaskLogId() == null;
            }
            case 9: {
                return et.getTSSDTaskLogName() == null;
            }
            case 10: {
                return et.getTSSDTaskName() == null;
            }
            case 11: {
                return et.getUpdateDate() == null;
            }
            case 12: {
                return et.getUpdateMan() == null;
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
        return TSSDTaskLogBase.contains(this, index);
    }

    private static boolean contains(TSSDTaskLogBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isDurationDirty();
            }
            case 3: {
                return et.isEndTimeDirty();
            }
            case 4: {
                return et.isRetCodeDirty();
            }
            case 5: {
                return et.isRetInfoDirty();
            }
            case 6: {
                return et.isStartTimeDirty();
            }
            case 7: {
                return et.isTSSDTaskIdDirty();
            }
            case 8: {
                return et.isTSSDTaskLogIdDirty();
            }
            case 9: {
                return et.isTSSDTaskLogNameDirty();
            }
            case 10: {
                return et.isTSSDTaskNameDirty();
            }
            case 11: {
                return et.isUpdateDateDirty();
            }
            case 12: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDTaskLogBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDTaskLogBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDTaskLogBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDTaskLogBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getDuration() != null) {
            JSONObjectHelper.put(json, "duration", TSSDTaskLogBase.getJSONValue(et.getDuration()), false);
        }
        if (bIncEmpty || et.getEndTime() != null) {
            JSONObjectHelper.put(json, "endtime", TSSDTaskLogBase.getJSONValue(et.getEndTime()), false);
        }
        if (bIncEmpty || et.getRetCode() != null) {
            JSONObjectHelper.put(json, "retcode", TSSDTaskLogBase.getJSONValue(et.getRetCode()), false);
        }
        if (bIncEmpty || et.getRetInfo() != null) {
            JSONObjectHelper.put(json, "retinfo", TSSDTaskLogBase.getJSONValue(et.getRetInfo()), false);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            JSONObjectHelper.put(json, "starttime", TSSDTaskLogBase.getJSONValue(et.getStartTime()), false);
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            JSONObjectHelper.put(json, "tssdtaskid", TSSDTaskLogBase.getJSONValue(et.getTSSDTaskId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskLogId() != null) {
            JSONObjectHelper.put(json, "tssdtasklogid", TSSDTaskLogBase.getJSONValue(et.getTSSDTaskLogId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskLogName() != null) {
            JSONObjectHelper.put(json, "tssdtasklogname", TSSDTaskLogBase.getJSONValue(et.getTSSDTaskLogName()), false);
        }
        if (bIncEmpty || et.getTSSDTaskName() != null) {
            JSONObjectHelper.put(json, "tssdtaskname", TSSDTaskLogBase.getJSONValue(et.getTSSDTaskName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDTaskLogBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDTaskLogBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDTaskLogBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDTaskLogBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getDuration() != null) {
            obj = et.getDuration();
            node.setAttribute(FIELD_DURATION, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getEndTime() != null) {
            obj = et.getEndTime();
            node.setAttribute(FIELD_ENDTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getRetCode() != null) {
            obj = et.getRetCode();
            node.setAttribute(FIELD_RETCODE, obj == null ? "" : StringHelper.format("%1$s", obj));
        }
        if (bIncEmpty || et.getRetInfo() != null) {
            obj = et.getRetInfo();
            node.setAttribute(FIELD_RETINFO, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getStartTime() != null) {
            obj = et.getStartTime();
            node.setAttribute(FIELD_STARTTIME, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            obj = et.getTSSDTaskId();
            node.setAttribute(FIELD_TSSDTASKID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskLogId() != null) {
            obj = et.getTSSDTaskLogId();
            node.setAttribute(FIELD_TSSDTASKLOGID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskLogName() != null) {
            obj = et.getTSSDTaskLogName();
            node.setAttribute(FIELD_TSSDTASKLOGNAME, obj == null ? "" : (String)obj);
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
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        TSSDTaskLogBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDTaskLogBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isDurationDirty() && (bIncEmpty || et.getDuration() != null)) {
            dst.set(FIELD_DURATION, et.getDuration());
        }
        if (et.isEndTimeDirty() && (bIncEmpty || et.getEndTime() != null)) {
            dst.set(FIELD_ENDTIME, et.getEndTime());
        }
        if (et.isRetCodeDirty() && (bIncEmpty || et.getRetCode() != null)) {
            dst.set(FIELD_RETCODE, et.getRetCode());
        }
        if (et.isRetInfoDirty() && (bIncEmpty || et.getRetInfo() != null)) {
            dst.set(FIELD_RETINFO, et.getRetInfo());
        }
        if (et.isStartTimeDirty() && (bIncEmpty || et.getStartTime() != null)) {
            dst.set(FIELD_STARTTIME, et.getStartTime());
        }
        if (et.isTSSDTaskIdDirty() && (bIncEmpty || et.getTSSDTaskId() != null)) {
            dst.set(FIELD_TSSDTASKID, et.getTSSDTaskId());
        }
        if (et.isTSSDTaskLogIdDirty() && (bIncEmpty || et.getTSSDTaskLogId() != null)) {
            dst.set(FIELD_TSSDTASKLOGID, et.getTSSDTaskLogId());
        }
        if (et.isTSSDTaskLogNameDirty() && (bIncEmpty || et.getTSSDTaskLogName() != null)) {
            dst.set(FIELD_TSSDTASKLOGNAME, et.getTSSDTaskLogName());
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
        return TSSDTaskLogBase.remove(this, index);
    }

    private static boolean remove(TSSDTaskLogBase et, int index) throws Exception {
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
                et.resetDuration();
                return true;
            }
            case 3: {
                et.resetEndTime();
                return true;
            }
            case 4: {
                et.resetRetCode();
                return true;
            }
            case 5: {
                et.resetRetInfo();
                return true;
            }
            case 6: {
                et.resetStartTime();
                return true;
            }
            case 7: {
                et.resetTSSDTaskId();
                return true;
            }
            case 8: {
                et.resetTSSDTaskLogId();
                return true;
            }
            case 9: {
                et.resetTSSDTaskLogName();
                return true;
            }
            case 10: {
                et.resetTSSDTaskName();
                return true;
            }
            case 11: {
                et.resetUpdateDate();
                return true;
            }
            case 12: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TSSDTask getTSSDTask() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTask();
        }
        if (this.getTSSDTaskId() == null) {
            return null;
        }
        Integer n = this.objTSSDTaskLock;
        synchronized (n) {
            if (this.tssdtask != null && DataTypeHelper.compare(25, (Object)this.getTSSDTaskId(), (Object)this.tssdtask.getTSSDTaskId()) != 0L) {
                this.tssdtask = null;
            }
            if (this.tssdtask == null) {
                TSSDTask tssdtask = new TSSDTask();
                tssdtask.setTSSDTaskId(this.getTSSDTaskId());
                TSSDTaskService service = (TSSDTaskService)ServiceGlobal.getService(TSSDTaskService.class, this.getSessionFactory());
                service.autoGet(tssdtask);
                this.tssdtask = tssdtask;
            }
            return this.tssdtask;
        }
    }

    private TSSDTaskLogBase getProxyEntity() {
        return this.proxyTSSDTaskLogBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskLogBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDTaskLogBase) {
            this.proxyTSSDTaskLogBase = (TSSDTaskLogBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskLogService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

