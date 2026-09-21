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
import net.ibizsys.psrt.srv.common.entity.TSSDPolicy;
import net.ibizsys.psrt.srv.common.entity.TSSDTask;
import net.ibizsys.psrt.srv.common.service.TSSDPolicyService;
import net.ibizsys.psrt.srv.common.service.TSSDTaskService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class TSSDTaskPolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(TSSDTaskPolicyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_RESERVER = "RESERVER";
    public static final String FIELD_RESERVER2 = "RESERVER2";
    public static final String FIELD_RESERVER3 = "RESERVER3";
    public static final String FIELD_RESERVER4 = "RESERVER4";
    public static final String FIELD_TSSDPOLICYID = "TSSDPOLICYID";
    public static final String FIELD_TSSDPOLICYNAME = "TSSDPOLICYNAME";
    public static final String FIELD_TSSDTASKID = "TSSDTASKID";
    public static final String FIELD_TSSDTASKNAME = "TSSDTASKNAME";
    public static final String FIELD_TSSDTASKPOLICYID = "TSSDTASKPOLICYID";
    public static final String FIELD_TSSDTASKPOLICYNAME = "TSSDTASKPOLICYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_RESERVER = 2;
    private static final int INDEX_RESERVER2 = 3;
    private static final int INDEX_RESERVER3 = 4;
    private static final int INDEX_RESERVER4 = 5;
    private static final int INDEX_TSSDPOLICYID = 6;
    private static final int INDEX_TSSDPOLICYNAME = 7;
    private static final int INDEX_TSSDTASKID = 8;
    private static final int INDEX_TSSDTASKNAME = 9;
    private static final int INDEX_TSSDTASKPOLICYID = 10;
    private static final int INDEX_TSSDTASKPOLICYNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private TSSDTaskPolicyBase proxyTSSDTaskPolicyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean reserverDirtyFlag = false;
    private boolean reserver2DirtyFlag = false;
    private boolean reserver3DirtyFlag = false;
    private boolean reserver4DirtyFlag = false;
    private boolean tssdpolicyidDirtyFlag = false;
    private boolean tssdpolicynameDirtyFlag = false;
    private boolean tssdtaskidDirtyFlag = false;
    private boolean tssdtasknameDirtyFlag = false;
    private boolean tssdtaskpolicyidDirtyFlag = false;
    private boolean tssdtaskpolicynameDirtyFlag = false;
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
    @Column(name="tssdpolicyid")
    private String tssdpolicyid;
    @Column(name="tssdpolicyname")
    private String tssdpolicyname;
    @Column(name="tssdtaskid")
    private String tssdtaskid;
    @Column(name="tssdtaskname")
    private String tssdtaskname;
    @Column(name="tssdtaskpolicyid")
    private String tssdtaskpolicyid;
    @Column(name="tssdtaskpolicyname")
    private String tssdtaskpolicyname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objTSSDPolicyLock = new Integer(1);
    private TSSDPolicy tssdpolicy = null;
    private Integer objTSSDTaskLock = new Integer(1);
    private TSSDTask tssdtask = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_RESERVER, 2);
        fieldIndexMap.put(FIELD_RESERVER2, 3);
        fieldIndexMap.put(FIELD_RESERVER3, 4);
        fieldIndexMap.put(FIELD_RESERVER4, 5);
        fieldIndexMap.put(FIELD_TSSDPOLICYID, 6);
        fieldIndexMap.put(FIELD_TSSDPOLICYNAME, 7);
        fieldIndexMap.put(FIELD_TSSDTASKID, 8);
        fieldIndexMap.put(FIELD_TSSDTASKNAME, 9);
        fieldIndexMap.put(FIELD_TSSDTASKPOLICYID, 10);
        fieldIndexMap.put(FIELD_TSSDTASKPOLICYNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
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

    public void setTSSDPolicyId(String tssdpolicyid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyId(tssdpolicyid);
            return;
        }
        if (tssdpolicyid != null && (tssdpolicyid = StringHelper.trimRight(tssdpolicyid)).length() == 0) {
            tssdpolicyid = null;
        }
        this.tssdpolicyid = tssdpolicyid;
        this.tssdpolicyidDirtyFlag = true;
    }

    public String getTSSDPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyId();
        }
        return this.tssdpolicyid;
    }

    public boolean isTSSDPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyIdDirty();
        }
        return this.tssdpolicyidDirtyFlag;
    }

    public void resetTSSDPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyId();
            return;
        }
        this.tssdpolicyidDirtyFlag = false;
        this.tssdpolicyid = null;
    }

    public void setTSSDPolicyName(String tssdpolicyname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDPolicyName(tssdpolicyname);
            return;
        }
        if (tssdpolicyname != null && (tssdpolicyname = StringHelper.trimRight(tssdpolicyname)).length() == 0) {
            tssdpolicyname = null;
        }
        this.tssdpolicyname = tssdpolicyname;
        this.tssdpolicynameDirtyFlag = true;
    }

    public String getTSSDPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicyName();
        }
        return this.tssdpolicyname;
    }

    public boolean isTSSDPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDPolicyNameDirty();
        }
        return this.tssdpolicynameDirtyFlag;
    }

    public void resetTSSDPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDPolicyName();
            return;
        }
        this.tssdpolicynameDirtyFlag = false;
        this.tssdpolicyname = null;
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

    public void setTSSDTaskPolicyId(String tssdtaskpolicyid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskPolicyId(tssdtaskpolicyid);
            return;
        }
        if (tssdtaskpolicyid != null && (tssdtaskpolicyid = StringHelper.trimRight(tssdtaskpolicyid)).length() == 0) {
            tssdtaskpolicyid = null;
        }
        this.tssdtaskpolicyid = tssdtaskpolicyid;
        this.tssdtaskpolicyidDirtyFlag = true;
    }

    public String getTSSDTaskPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskPolicyId();
        }
        return this.tssdtaskpolicyid;
    }

    public boolean isTSSDTaskPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskPolicyIdDirty();
        }
        return this.tssdtaskpolicyidDirtyFlag;
    }

    public void resetTSSDTaskPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskPolicyId();
            return;
        }
        this.tssdtaskpolicyidDirtyFlag = false;
        this.tssdtaskpolicyid = null;
    }

    public void setTSSDTaskPolicyName(String tssdtaskpolicyname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTSSDTaskPolicyName(tssdtaskpolicyname);
            return;
        }
        if (tssdtaskpolicyname != null && (tssdtaskpolicyname = StringHelper.trimRight(tssdtaskpolicyname)).length() == 0) {
            tssdtaskpolicyname = null;
        }
        this.tssdtaskpolicyname = tssdtaskpolicyname;
        this.tssdtaskpolicynameDirtyFlag = true;
    }

    public String getTSSDTaskPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDTaskPolicyName();
        }
        return this.tssdtaskpolicyname;
    }

    public boolean isTSSDTaskPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTSSDTaskPolicyNameDirty();
        }
        return this.tssdtaskpolicynameDirtyFlag;
    }

    public void resetTSSDTaskPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTSSDTaskPolicyName();
            return;
        }
        this.tssdtaskpolicynameDirtyFlag = false;
        this.tssdtaskpolicyname = null;
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
        TSSDTaskPolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(TSSDTaskPolicyBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetReserver();
        et.resetReserver2();
        et.resetReserver3();
        et.resetReserver4();
        et.resetTSSDPolicyId();
        et.resetTSSDPolicyName();
        et.resetTSSDTaskId();
        et.resetTSSDTaskName();
        et.resetTSSDTaskPolicyId();
        et.resetTSSDTaskPolicyName();
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
        if (!bDirtyOnly || this.isTSSDPolicyIdDirty()) {
            params.put(FIELD_TSSDPOLICYID, this.getTSSDPolicyId());
        }
        if (!bDirtyOnly || this.isTSSDPolicyNameDirty()) {
            params.put(FIELD_TSSDPOLICYNAME, this.getTSSDPolicyName());
        }
        if (!bDirtyOnly || this.isTSSDTaskIdDirty()) {
            params.put(FIELD_TSSDTASKID, this.getTSSDTaskId());
        }
        if (!bDirtyOnly || this.isTSSDTaskNameDirty()) {
            params.put(FIELD_TSSDTASKNAME, this.getTSSDTaskName());
        }
        if (!bDirtyOnly || this.isTSSDTaskPolicyIdDirty()) {
            params.put(FIELD_TSSDTASKPOLICYID, this.getTSSDTaskPolicyId());
        }
        if (!bDirtyOnly || this.isTSSDTaskPolicyNameDirty()) {
            params.put(FIELD_TSSDTASKPOLICYNAME, this.getTSSDTaskPolicyName());
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
        return TSSDTaskPolicyBase.get(this, index);
    }

    private static Object get(TSSDTaskPolicyBase et, int index) throws Exception {
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
                return et.getTSSDPolicyId();
            }
            case 7: {
                return et.getTSSDPolicyName();
            }
            case 8: {
                return et.getTSSDTaskId();
            }
            case 9: {
                return et.getTSSDTaskName();
            }
            case 10: {
                return et.getTSSDTaskPolicyId();
            }
            case 11: {
                return et.getTSSDTaskPolicyName();
            }
            case 12: {
                return et.getUpdateDate();
            }
            case 13: {
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
        TSSDTaskPolicyBase.set(this, index, objValue);
    }

    private static void set(TSSDTaskPolicyBase et, int index, Object obj) throws Exception {
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
                et.setTSSDPolicyId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setTSSDPolicyName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setTSSDTaskId(DataObject.getStringValue(obj));
                return;
            }
            case 9: {
                et.setTSSDTaskName(DataObject.getStringValue(obj));
                return;
            }
            case 10: {
                et.setTSSDTaskPolicyId(DataObject.getStringValue(obj));
                return;
            }
            case 11: {
                et.setTSSDTaskPolicyName(DataObject.getStringValue(obj));
                return;
            }
            case 12: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 13: {
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
        return TSSDTaskPolicyBase.isNull(this, index);
    }

    private static boolean isNull(TSSDTaskPolicyBase et, int index) throws Exception {
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
                return et.getTSSDPolicyId() == null;
            }
            case 7: {
                return et.getTSSDPolicyName() == null;
            }
            case 8: {
                return et.getTSSDTaskId() == null;
            }
            case 9: {
                return et.getTSSDTaskName() == null;
            }
            case 10: {
                return et.getTSSDTaskPolicyId() == null;
            }
            case 11: {
                return et.getTSSDTaskPolicyName() == null;
            }
            case 12: {
                return et.getUpdateDate() == null;
            }
            case 13: {
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
        return TSSDTaskPolicyBase.contains(this, index);
    }

    private static boolean contains(TSSDTaskPolicyBase et, int index) throws Exception {
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
                return et.isTSSDPolicyIdDirty();
            }
            case 7: {
                return et.isTSSDPolicyNameDirty();
            }
            case 8: {
                return et.isTSSDTaskIdDirty();
            }
            case 9: {
                return et.isTSSDTaskNameDirty();
            }
            case 10: {
                return et.isTSSDTaskPolicyIdDirty();
            }
            case 11: {
                return et.isTSSDTaskPolicyNameDirty();
            }
            case 12: {
                return et.isUpdateDateDirty();
            }
            case 13: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        TSSDTaskPolicyBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(TSSDTaskPolicyBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", TSSDTaskPolicyBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", TSSDTaskPolicyBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getReserver() != null) {
            JSONObjectHelper.put(json, "reserver", TSSDTaskPolicyBase.getJSONValue(et.getReserver()), false);
        }
        if (bIncEmpty || et.getReserver2() != null) {
            JSONObjectHelper.put(json, "reserver2", TSSDTaskPolicyBase.getJSONValue(et.getReserver2()), false);
        }
        if (bIncEmpty || et.getReserver3() != null) {
            JSONObjectHelper.put(json, "reserver3", TSSDTaskPolicyBase.getJSONValue(et.getReserver3()), false);
        }
        if (bIncEmpty || et.getReserver4() != null) {
            JSONObjectHelper.put(json, "reserver4", TSSDTaskPolicyBase.getJSONValue(et.getReserver4()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyId() != null) {
            JSONObjectHelper.put(json, "tssdpolicyid", TSSDTaskPolicyBase.getJSONValue(et.getTSSDPolicyId()), false);
        }
        if (bIncEmpty || et.getTSSDPolicyName() != null) {
            JSONObjectHelper.put(json, "tssdpolicyname", TSSDTaskPolicyBase.getJSONValue(et.getTSSDPolicyName()), false);
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            JSONObjectHelper.put(json, "tssdtaskid", TSSDTaskPolicyBase.getJSONValue(et.getTSSDTaskId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskName() != null) {
            JSONObjectHelper.put(json, "tssdtaskname", TSSDTaskPolicyBase.getJSONValue(et.getTSSDTaskName()), false);
        }
        if (bIncEmpty || et.getTSSDTaskPolicyId() != null) {
            JSONObjectHelper.put(json, "tssdtaskpolicyid", TSSDTaskPolicyBase.getJSONValue(et.getTSSDTaskPolicyId()), false);
        }
        if (bIncEmpty || et.getTSSDTaskPolicyName() != null) {
            JSONObjectHelper.put(json, "tssdtaskpolicyname", TSSDTaskPolicyBase.getJSONValue(et.getTSSDTaskPolicyName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", TSSDTaskPolicyBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", TSSDTaskPolicyBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        TSSDTaskPolicyBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(TSSDTaskPolicyBase et, XmlNode node, boolean bIncEmpty) throws Exception {
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
        if (bIncEmpty || et.getTSSDPolicyId() != null) {
            obj = et.getTSSDPolicyId();
            node.setAttribute(FIELD_TSSDPOLICYID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDPolicyName() != null) {
            obj = et.getTSSDPolicyName();
            node.setAttribute(FIELD_TSSDPOLICYNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskId() != null) {
            obj = et.getTSSDTaskId();
            node.setAttribute(FIELD_TSSDTASKID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskName() != null) {
            obj = et.getTSSDTaskName();
            node.setAttribute(FIELD_TSSDTASKNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskPolicyId() != null) {
            obj = et.getTSSDTaskPolicyId();
            node.setAttribute(FIELD_TSSDTASKPOLICYID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getTSSDTaskPolicyName() != null) {
            obj = et.getTSSDTaskPolicyName();
            node.setAttribute(FIELD_TSSDTASKPOLICYNAME, obj == null ? "" : (String)obj);
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
        TSSDTaskPolicyBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(TSSDTaskPolicyBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
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
        if (et.isTSSDPolicyIdDirty() && (bIncEmpty || et.getTSSDPolicyId() != null)) {
            dst.set(FIELD_TSSDPOLICYID, et.getTSSDPolicyId());
        }
        if (et.isTSSDPolicyNameDirty() && (bIncEmpty || et.getTSSDPolicyName() != null)) {
            dst.set(FIELD_TSSDPOLICYNAME, et.getTSSDPolicyName());
        }
        if (et.isTSSDTaskIdDirty() && (bIncEmpty || et.getTSSDTaskId() != null)) {
            dst.set(FIELD_TSSDTASKID, et.getTSSDTaskId());
        }
        if (et.isTSSDTaskNameDirty() && (bIncEmpty || et.getTSSDTaskName() != null)) {
            dst.set(FIELD_TSSDTASKNAME, et.getTSSDTaskName());
        }
        if (et.isTSSDTaskPolicyIdDirty() && (bIncEmpty || et.getTSSDTaskPolicyId() != null)) {
            dst.set(FIELD_TSSDTASKPOLICYID, et.getTSSDTaskPolicyId());
        }
        if (et.isTSSDTaskPolicyNameDirty() && (bIncEmpty || et.getTSSDTaskPolicyName() != null)) {
            dst.set(FIELD_TSSDTASKPOLICYNAME, et.getTSSDTaskPolicyName());
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
        return TSSDTaskPolicyBase.remove(this, index);
    }

    private static boolean remove(TSSDTaskPolicyBase et, int index) throws Exception {
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
                et.resetTSSDPolicyId();
                return true;
            }
            case 7: {
                et.resetTSSDPolicyName();
                return true;
            }
            case 8: {
                et.resetTSSDTaskId();
                return true;
            }
            case 9: {
                et.resetTSSDTaskName();
                return true;
            }
            case 10: {
                et.resetTSSDTaskPolicyId();
                return true;
            }
            case 11: {
                et.resetTSSDTaskPolicyName();
                return true;
            }
            case 12: {
                et.resetUpdateDate();
                return true;
            }
            case 13: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TSSDPolicy getTSSDPolicy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTSSDPolicy();
        }
        if (this.getTSSDPolicyId() == null) {
            return null;
        }
        Integer n = this.objTSSDPolicyLock;
        synchronized (n) {
            if (this.tssdpolicy != null && DataTypeHelper.compare(25, (Object)this.getTSSDPolicyId(), (Object)this.tssdpolicy.getTSSDPolicyId()) != 0L) {
                this.tssdpolicy = null;
            }
            if (this.tssdpolicy == null) {
                TSSDPolicy tssdpolicy = new TSSDPolicy();
                tssdpolicy.setTSSDPolicyId(this.getTSSDPolicyId());
                TSSDPolicyService service = (TSSDPolicyService)ServiceGlobal.getService(TSSDPolicyService.class, this.getSessionFactory());
                service.autoGet(tssdpolicy);
                this.tssdpolicy = tssdpolicy;
            }
            return this.tssdpolicy;
        }
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

    private TSSDTaskPolicyBase getProxyEntity() {
        return this.proxyTSSDTaskPolicyBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyTSSDTaskPolicyBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof TSSDTaskPolicyBase) {
            this.proxyTSSDTaskPolicyBase = (TSSDTaskPolicyBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.TSSDTaskPolicyService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

