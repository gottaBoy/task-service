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
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class TSSDTaskTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_TASKOBJECT = "TASKOBJECT";
    public static final String FIELD_TASKTYPEPARAM = "TASKTYPEPARAM";
    public static final String FIELD_TSSDTASKTYPEID = "TSSDTASKTYPEID";
    public static final String FIELD_TSSDTASKTYPENAME = "TSSDTASKTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_RESERVER = 2;
    private static final int INDEX_RESERVER2 = 3;
    private static final int INDEX_RESERVER3 = 4;
    private static final int INDEX_RESERVER4 = 5;
    private static final int INDEX_TASKOBJECT = 6;
    private static final int INDEX_TASKTYPEPARAM = 7;
    private static final int INDEX_TSSDTASKTYPEID = 8;
    private static final int INDEX_TSSDTASKTYPENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDTaskTypeBase proxyTSSDTaskTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean taskobjectDirtyFlag = false;
    private boolean tasktypeparamDirtyFlag = false;
    private boolean tssdtasktypeidDirtyFlag = false;
    private boolean tssdtasktypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="reserver")
    private String reserver;
    @Column(name="reserver2")
    private String reserver2;
    @Column(name="reserver3")
    private String reserver3;
    @Column(name="reserver4")
    private String reserver4;
    @Column(name="taskobject")
    private String taskobject;
    @Column(name="tasktypeparam")
    private String tasktypeparam;
    @Column(name="tssdtasktypeid")
    private String tssdtasktypeid;
    @Column(name="tssdtasktypename")
    private String tssdtasktypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_RESERVER, 2);
        fieldIndexMap.put(FIELD_RESERVER2, 3);
        fieldIndexMap.put(FIELD_RESERVER3, 4);
        fieldIndexMap.put(FIELD_RESERVER4, 5);
        fieldIndexMap.put(FIELD_TASKOBJECT, 6);
        fieldIndexMap.put(FIELD_TASKTYPEPARAM, 7);
        fieldIndexMap.put(FIELD_TSSDTASKTYPEID, 8);
        fieldIndexMap.put(FIELD_TSSDTASKTYPENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
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

    public void setReserver(String reserver) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver(reserver);
            return;
        }
        if (reserver != null && (reserver = StringHelper.trimRight(reserver)).length() == 0) {
            reserver = null;
        }
        this.reserver = reserver;
        this.reserverDirtyFlag = true;
    }

    public String getReserver() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver();
        }
        return this.reserver;
    }

    public boolean isReserverDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserverDirty();
        }
        return this.reserverDirtyFlag;
    }

    public void resetReserver() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver();
            return;
        }
        this.reserverDirtyFlag = false;
        this.reserver = null;
    }

    public void setReserver2(String reserver2) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver2(reserver2);
            return;
        }
        if (reserver2 != null && (reserver2 = StringHelper.trimRight(reserver2)).length() == 0) {
            reserver2 = null;
        }
        this.reserver2 = reserver2;
        this.reserver2DirtyFlag = true;
    }

    public String getReserver2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver2();
        }
        return this.reserver2;
    }

    public boolean isReserver2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver2Dirty();
        }
        return this.reserver2DirtyFlag;
    }

    public void resetReserver2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver2();
            return;
        }
        this.reserver2DirtyFlag = false;
        this.reserver2 = null;
    }

    public void setReserver3(String reserver3) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver3(reserver3);
            return;
        }
        if (reserver3 != null && (reserver3 = StringHelper.trimRight(reserver3)).length() == 0) {
            reserver3 = null;
        }
        this.reserver3 = reserver3;
        this.reserver3DirtyFlag = true;
    }

    public String getReserver3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver3();
        }
        return this.reserver3;
    }

    public boolean isReserver3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver3Dirty();
        }
        return this.reserver3DirtyFlag;
    }

    public void resetReserver3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver3();
            return;
        }
        this.reserver3DirtyFlag = false;
        this.reserver3 = null;
    }

    public void setReserver4(String reserver4) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setReserver4(reserver4);
            return;
        }
        if (reserver4 != null && (reserver4 = StringHelper.trimRight(reserver4)).length() == 0) {
            reserver4 = null;
        }
        this.reserver4 = reserver4;
        this.reserver4DirtyFlag = true;
    }

    public String getReserver4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getReserver4();
        }
        return this.reserver4;
    }

    public boolean isReserver4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isReserver4Dirty();
        }
        return this.reserver4DirtyFlag;
    }

    public void resetReserver4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetReserver4();
            return;
        }
        this.reserver4DirtyFlag = false;
        this.reserver4 = null;
    }

    public void setTaskObject(String taskobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskObject(taskobject);
            return;
        }
        if (taskobject != null && (taskobject = StringHelper.trimRight(taskobject)).length() == 0) {
            taskobject = null;
        }
        this.taskobject = taskobject;
        this.taskobjectDirtyFlag = true;
    }

    public String getTaskObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskObject();
        }
        return this.taskobject;
    }

    public boolean isTaskObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskObjectDirty();
        }
        return this.taskobjectDirtyFlag;
    }

    public void resetTaskObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskObject();
            return;
        }
        this.taskobjectDirtyFlag = false;
        this.taskobject = null;
    }

    public void setTaskTypeParam(String tasktypeparam) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTaskTypeParam(tasktypeparam);
            return;
        }
        if (tasktypeparam != null && (tasktypeparam = StringHelper.trimRight(tasktypeparam)).length() == 0) {
            tasktypeparam = null;
        }
        this.tasktypeparam = tasktypeparam;
        this.tasktypeparamDirtyFlag = true;
    }

    public String getTaskTypeParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTaskTypeParam();
        }
        return this.tasktypeparam;
    }

    public boolean isTaskTypeParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTaskTypeParamDirty();
        }
        return this.tasktypeparamDirtyFlag;
    }

    public void resetTaskTypeParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTaskTypeParam();
            return;
        }
        this.tasktypeparamDirtyFlag = false;
        this.tasktypeparam = null;
    }

    public void setTSSDTaskTypeId(String tssdtasktypeid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskTypeId(tssdtasktypeid);
            return;
        }
        if (tssdtasktypeid != null && (tssdtasktypeid = StringHelper.trimRight(tssdtasktypeid)).length() == 0) {
            tssdtasktypeid = null;
        }
        this.tssdtasktypeid = tssdtasktypeid;
        this.tssdtasktypeidDirtyFlag = true;
    }

    public String getTSSDTaskTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskTypeId();
        }
        return this.tssdtasktypeid;
    }

    public boolean isTSSDTaskTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskTypeIdDirty();
        }
        return this.tssdtasktypeidDirtyFlag;
    }

    public void resetTSSDTaskTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskTypeId();
            return;
        }
        this.tssdtasktypeidDirtyFlag = false;
        this.tssdtasktypeid = null;
    }

    public void setTSSDTaskTypeName(String tssdtasktypename) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskTypeName(tssdtasktypename);
            return;
        }
        if (tssdtasktypename != null && (tssdtasktypename = StringHelper.trimRight(tssdtasktypename)).length() == 0) {
            tssdtasktypename = null;
        }
        this.tssdtasktypename = tssdtasktypename;
        this.tssdtasktypenameDirtyFlag = true;
    }

    public String getTSSDTaskTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskTypeName();
        }
        return this.tssdtasktypename;
    }

    public boolean isTSSDTaskTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskTypeNameDirty();
        }
        return this.tssdtasktypenameDirtyFlag;
    }

    public void resetTSSDTaskTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskTypeName();
            return;
        }
        this.tssdtasktypenameDirtyFlag = false;
        this.tssdtasktypename = null;
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
        TSSDTaskTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDTaskTypeBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTaskObject();
        et.resetTaskTypeParam();
        et.resetTSSDTaskTypeId();
        et.resetTSSDTaskTypeName();
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
        if (!bDirtyOnly || this.isReserverDirty()) {
            params.put(FIELD_RESERVER, this.getReserver());
        }
        if (!bDirtyOnly || this.isReserver2Dirty()) {
            params.put(FIELD_RESERVER2, this.getReserver2());
        }
        if (!bDirtyOnly || this.isReserver3Dirty()) {
            params.put(FIELD_RESERVER3, this.getReserver3());
        }
        if (!bDirtyOnly || this.isReserver4Dirty()) {
            params.put(FIELD_RESERVER4, this.getReserver4());
        }
        if (!bDirtyOnly || this.isTaskObjectDirty()) {
            params.put(FIELD_TASKOBJECT, this.getTaskObject());
        }
        if (!bDirtyOnly || this.isTaskTypeParamDirty()) {
            params.put(FIELD_TASKTYPEPARAM, this.getTaskTypeParam());
        }
        if (!bDirtyOnly || this.isTSSDTaskTypeIdDirty()) {
            params.put(FIELD_TSSDTASKTYPEID, this.getTSSDTaskTypeId());
        }
        if (!bDirtyOnly || this.isTSSDTaskTypeNameDirty()) {
            params.put(FIELD_TSSDTASKTYPENAME, this.getTSSDTaskTypeName());
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
        return TSSDTaskTypeBase.get(this, index);
    }

    private static Object get(TSSDTaskTypeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getReserver();
            }
            case 3: {
                return et.getReserver2();
            }
            case 4: {
                return et.getReserver3();
            }
            case 5: {
                return et.getReserver4();
            }
            case 6: {
                return et.getTaskObject();
            }
            case 7: {
                return et.getTaskTypeParam();
            }
            case 8: {
                return et.getTSSDTaskTypeId();
            }
            case 9: {
                return et.getTSSDTaskTypeName();
            }
            case 10: {
                return et.getUpdateDate();
            }
            case 11: {
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
        TSSDTaskTypeBase.set(this, index, objValue);
    }

    private static void set(TSSDTaskTypeBase et, int index, Object obj) throws Exception {
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
                et.setReserver(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setReserver2(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setReserver3(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setReserver4(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setTaskObject(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setTaskTypeParam(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDTaskTypeId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDTaskTypeName(DataObject.getStringValue(obj));
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
        return TSSDTaskTypeBase.isNull(this, index);
    }

    private static boolean isNull(TSSDTaskTypeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getReserver() == null;
            }
            case 3: {
                return et.getReserver2() == null;
            }
            case 4: {
                return et.getReserver3() == null;
            }
            case 5: {
                return et.getReserver4() == null;
            }
            case 6: {
                return et.getTaskObject() == null;
            }
            case 7: {
                return et.getTaskTypeParam() == null;
            }
            case 8: {
                return et.getTSSDTaskTypeId() == null;
            }
            case 9: {
                return et.getTSSDTaskTypeName() == null;
            }
            case 10: {
                return et.getUpdateDate() == null;
            }
            case 11: {
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
        return TSSDTaskTypeBase.contains(this, index);
    }

    private static boolean contains(TSSDTaskTypeBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isReserverDirty();
            }
            case 3: {
                return et.isReserver2Dirty();
            }
            case 4: {
                return et.isReserver3Dirty();
            }
            case 5: {
                return et.isReserver4Dirty();
            }
            case 6: {
                return et.isTaskObjectDirty();
            }
            case 7: {
                return et.isTaskTypeParamDirty();
            }
            case 8: {
                return et.isTSSDTaskTypeIdDirty();
            }
            case 9: {
                return et.isTSSDTaskTypeNameDirty();
            }
            case 10: {
                return et.isUpdateDateDirty();
            }
            case 11: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDTaskTypeBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDTaskTypeBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDTaskTypeBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDTaskTypeBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", TSSDTaskTypeBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", TSSDTaskTypeBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", TSSDTaskTypeBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", TSSDTaskTypeBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getTaskObject() != null) {
            JSONObjectHelper.put(json, "taskobject", TSSDTaskTypeBase.getJSONValue(et.getTaskObject()), false);
        }
        if (bIncEmpty || et.getTaskTypeParam() != null) {
            JSONObjectHelper.put(json, "tasktypeparam", TSSDTaskTypeBase.getJSONValue(et.getTaskTypeParam()), false);
        }
        if (bIncEmpty || et.getTSSDTaskTypeId() != null) {
            JSONObjectHelper.put(json, "tssdtasktypeid", TSSDTaskTypeBase.getJSONValue(et.getTSSDTaskTypeId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskTypeName() != null) {
            JSONObjectHelper.put(json, "tssdtasktypename", TSSDTaskTypeBase.getJSONValue(et.getTSSDTaskTypeName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDTaskTypeBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDTaskTypeBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDTaskTypeBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDTaskTypeBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver() != null) {
            obj = et.getReserver();
            node.setAttribute(FIELD_RESERVER, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            obj = et.getReserver2();
            node.setAttribute(FIELD_RESERVER2, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            obj = et.getReserver3();
            node.setAttribute(FIELD_RESERVER3, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            obj = et.getReserver4();
            node.setAttribute(FIELD_RESERVER4, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTaskObject() != null) {
            obj = et.getTaskObject();
            node.setAttribute(FIELD_TASKOBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTaskTypeParam() != null) {
            obj = et.getTaskTypeParam();
            node.setAttribute(FIELD_TASKTYPEPARAM, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskTypeId() != null) {
            obj = et.getTSSDTaskTypeId();
            node.setAttribute(FIELD_TSSDTASKTYPEID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskTypeName() != null) {
            obj = et.getTSSDTaskTypeName();
            node.setAttribute(FIELD_TSSDTASKTYPENAME, obj == null ? "" : (String)obj);
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
        TSSDTaskTypeBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDTaskTypeBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isReserverDirty() && (bIncEmpty || et.getReserver() != null)) {
            dst.set(FIELD_RESERVER, et.getReserver());
        }
        if (et.isReserver2Dirty() && (bIncEmpty || et.getReserver2() != null)) {
            dst.set(FIELD_RESERVER2, et.getReserver2());
        }
        if (et.isReserver3Dirty() && (bIncEmpty || et.getReserver3() != null)) {
            dst.set(FIELD_RESERVER3, et.getReserver3());
        }
        if (et.isReserver4Dirty() && (bIncEmpty || et.getReserver4() != null)) {
            dst.set(FIELD_RESERVER4, et.getReserver4());
        }
        if (et.isTaskObjectDirty() && (bIncEmpty || et.getTaskObject() != null)) {
            dst.set(FIELD_TASKOBJECT, et.getTaskObject());
        }
        if (et.isTaskTypeParamDirty() && (bIncEmpty || et.getTaskTypeParam() != null)) {
            dst.set(FIELD_TASKTYPEPARAM, et.getTaskTypeParam());
        }
        if (et.isTSSDTaskTypeIdDirty() && (bIncEmpty || et.getTSSDTaskTypeId() != null)) {
            dst.set(FIELD_TSSDTASKTYPEID, et.getTSSDTaskTypeId());
        }
        if (et.isTSSDTaskTypeNameDirty() && (bIncEmpty || et.getTSSDTaskTypeName() != null)) {
            dst.set(FIELD_TSSDTASKTYPENAME, et.getTSSDTaskTypeName());
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
        return TSSDTaskTypeBase.remove(this, index);
    }

    private static boolean remove(TSSDTaskTypeBase et, int index) throws Exception {
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
                et.resetReserver();
                return true;
            }
            case 3: {
                et.resetReserver2();
                return true;
            }
            case 4: {
                et.resetReserver3();
                return true;
            }
            case 5: {
                et.resetReserver4();
                return true;
            }
            case 6: {
                et.resetTaskObject();
                return true;
            }
            case 7: {
                et.resetTaskTypeParam();
                return true;
            }
            case 8: {
                et.resetTSSDTaskTypeId();
                return true;
            }
            case 9: {
                et.resetTSSDTaskTypeName();
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
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private TSSDTaskTypeBase getProxyEntity() {
        return this.proxyTSSDTaskTypeBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskTypeBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDTaskTypeBase) {
            this.proxyTSSDTaskTypeBase = (TSSDTaskTypeBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskTypeService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

