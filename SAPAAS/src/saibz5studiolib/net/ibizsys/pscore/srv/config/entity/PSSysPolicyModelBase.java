/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntity
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.DataTypeHelper
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntity;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.config.entity.PSSysPolicy;
import net.ibizsys.pscore.srv.config.service.PSSysPolicyService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPolicyModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPolicyModelBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CURCNT = "CURCNT";
    public static final String FIELD_FIELDS = "FIELDS";
    public static final String FIELD_MAXCNT = "MAXCNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELTAG = "MODELTAG";
    public static final String FIELD_POLICYINFO = "POLICYINFO";
    public static final String FIELD_PSSYSPOLICYID = "PSSYSPOLICYID";
    public static final String FIELD_PSSYSPOLICYMODELID = "PSSYSPOLICYMODELID";
    public static final String FIELD_PSSYSPOLICYMODELNAME = "PSSYSPOLICYMODELNAME";
    public static final String FIELD_PSSYSPOLICYNAME = "PSSYSPOLICYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_CURCNT = 2;
    private static final int INDEX_FIELDS = 3;
    private static final int INDEX_MAXCNT = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MODELTAG = 6;
    private static final int INDEX_POLICYINFO = 7;
    private static final int INDEX_PSSYSPOLICYID = 8;
    private static final int INDEX_PSSYSPOLICYMODELID = 9;
    private static final int INDEX_PSSYSPOLICYMODELNAME = 10;
    private static final int INDEX_PSSYSPOLICYNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPolicyModelBase proxyPSSysPolicyModelBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean curcntDirtyFlag = false;
    private boolean fieldsDirtyFlag = false;
    private boolean maxcntDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeltagDirtyFlag = false;
    private boolean policyinfoDirtyFlag = false;
    private boolean pssyspolicyidDirtyFlag = false;
    private boolean pssyspolicymodelidDirtyFlag = false;
    private boolean pssyspolicymodelnameDirtyFlag = false;
    private boolean pssyspolicynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="curcnt")
    private Integer curcnt;
    @Column(name="fields")
    private String fields;
    @Column(name="maxcnt")
    private Integer maxcnt;
    @Column(name="memo")
    private String memo;
    @Column(name="modeltag")
    private String modeltag;
    @Column(name="policyinfo")
    private String policyinfo;
    @Column(name="pssyspolicyid")
    private String pssyspolicyid;
    @Column(name="pssyspolicymodelid")
    private String pssyspolicymodelid;
    @Column(name="pssyspolicymodelname")
    private String pssyspolicymodelname;
    @Column(name="pssyspolicyname")
    private String pssyspolicyname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysPolicyLock = new Integer(1);
    private PSSysPolicy pssyspolicy = null;

    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
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

    public void setCreateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.createman = string;
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

    public void setCurCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCurCnt(n);
            return;
        }
        this.curcnt = n;
        this.curcntDirtyFlag = true;
    }

    public Integer getCurCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCurCnt();
        }
        return this.curcnt;
    }

    public boolean isCurCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCurCntDirty();
        }
        return this.curcntDirtyFlag;
    }

    public void resetCurCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCurCnt();
            return;
        }
        this.curcntDirtyFlag = false;
        this.curcnt = null;
    }

    public void setFields(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFields(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fields = string;
        this.fieldsDirtyFlag = true;
    }

    public String getFields() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFields();
        }
        return this.fields;
    }

    public boolean isFieldsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldsDirty();
        }
        return this.fieldsDirtyFlag;
    }

    public void resetFields() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFields();
            return;
        }
        this.fieldsDirtyFlag = false;
        this.fields = null;
    }

    public void setMaxCnt(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCnt(n);
            return;
        }
        this.maxcnt = n;
        this.maxcntDirtyFlag = true;
    }

    public Integer getMaxCnt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCnt();
        }
        return this.maxcnt;
    }

    public boolean isMaxCntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCntDirty();
        }
        return this.maxcntDirtyFlag;
    }

    public void resetMaxCnt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCnt();
            return;
        }
        this.maxcntDirtyFlag = false;
        this.maxcnt = null;
    }

    public void setMemo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMemo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.memo = string;
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

    public void setModelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag = string;
        this.modeltagDirtyFlag = true;
    }

    public String getModelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag();
        }
        return this.modeltag;
    }

    public boolean isModelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTagDirty();
        }
        return this.modeltagDirtyFlag;
    }

    public void resetModelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag();
            return;
        }
        this.modeltagDirtyFlag = false;
        this.modeltag = null;
    }

    public void setPolicyInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPolicyInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.policyinfo = string;
        this.policyinfoDirtyFlag = true;
    }

    public String getPolicyInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPolicyInfo();
        }
        return this.policyinfo;
    }

    public boolean isPolicyInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPolicyInfoDirty();
        }
        return this.policyinfoDirtyFlag;
    }

    public void resetPolicyInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPolicyInfo();
            return;
        }
        this.policyinfoDirtyFlag = false;
        this.policyinfo = null;
    }

    public void setPSSysPolicyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyid = string;
        this.pssyspolicyidDirtyFlag = true;
    }

    public String getPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyId();
        }
        return this.pssyspolicyid;
    }

    public boolean isPSSysPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyIdDirty();
        }
        return this.pssyspolicyidDirtyFlag;
    }

    public void resetPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyId();
            return;
        }
        this.pssyspolicyidDirtyFlag = false;
        this.pssyspolicyid = null;
    }

    public void setPSSysPolicyModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicymodelid = string;
        this.pssyspolicymodelidDirtyFlag = true;
    }

    public String getPSSysPolicyModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyModelId();
        }
        return this.pssyspolicymodelid;
    }

    public boolean isPSSysPolicyModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyModelIdDirty();
        }
        return this.pssyspolicymodelidDirtyFlag;
    }

    public void resetPSSysPolicyModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyModelId();
            return;
        }
        this.pssyspolicymodelidDirtyFlag = false;
        this.pssyspolicymodelid = null;
    }

    public void setPSSysPolicyModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicymodelname = string;
        this.pssyspolicymodelnameDirtyFlag = true;
    }

    public String getPSSysPolicyModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyModelName();
        }
        return this.pssyspolicymodelname;
    }

    public boolean isPSSysPolicyModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyModelNameDirty();
        }
        return this.pssyspolicymodelnameDirtyFlag;
    }

    public void resetPSSysPolicyModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyModelName();
            return;
        }
        this.pssyspolicymodelnameDirtyFlag = false;
        this.pssyspolicymodelname = null;
    }

    public void setPSSysPolicyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyname = string;
        this.pssyspolicynameDirtyFlag = true;
    }

    public String getPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyName();
        }
        return this.pssyspolicyname;
    }

    public boolean isPSSysPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyNameDirty();
        }
        return this.pssyspolicynameDirtyFlag;
    }

    public void resetPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyName();
            return;
        }
        this.pssyspolicynameDirtyFlag = false;
        this.pssyspolicyname = null;
    }

    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
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

    public void setUpdateMan(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.updateman = string;
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

    protected void onReset() {
        PSSysPolicyModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPolicyModelBase pSSysPolicyModelBase) {
        pSSysPolicyModelBase.resetCreateDate();
        pSSysPolicyModelBase.resetCreateMan();
        pSSysPolicyModelBase.resetCurCnt();
        pSSysPolicyModelBase.resetFields();
        pSSysPolicyModelBase.resetMaxCnt();
        pSSysPolicyModelBase.resetMemo();
        pSSysPolicyModelBase.resetModelTag();
        pSSysPolicyModelBase.resetPolicyInfo();
        pSSysPolicyModelBase.resetPSSysPolicyId();
        pSSysPolicyModelBase.resetPSSysPolicyModelId();
        pSSysPolicyModelBase.resetPSSysPolicyModelName();
        pSSysPolicyModelBase.resetPSSysPolicyName();
        pSSysPolicyModelBase.resetUpdateDate();
        pSSysPolicyModelBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCurCntDirty()) {
            hashMap.put(FIELD_CURCNT, this.getCurCnt());
        }
        if (!bl || this.isFieldsDirty()) {
            hashMap.put(FIELD_FIELDS, this.getFields());
        }
        if (!bl || this.isMaxCntDirty()) {
            hashMap.put(FIELD_MAXCNT, this.getMaxCnt());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelTagDirty()) {
            hashMap.put(FIELD_MODELTAG, this.getModelTag());
        }
        if (!bl || this.isPolicyInfoDirty()) {
            hashMap.put(FIELD_POLICYINFO, this.getPolicyInfo());
        }
        if (!bl || this.isPSSysPolicyIdDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYID, this.getPSSysPolicyId());
        }
        if (!bl || this.isPSSysPolicyModelIdDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYMODELID, this.getPSSysPolicyModelId());
        }
        if (!bl || this.isPSSysPolicyModelNameDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYMODELNAME, this.getPSSysPolicyModelName());
        }
        if (!bl || this.isPSSysPolicyNameDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYNAME, this.getPSSysPolicyName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    public Object get(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.get(string);
        }
        return PSSysPolicyModelBase.get(this, n);
    }

    private static Object get(PSSysPolicyModelBase pSSysPolicyModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyModelBase.getCreateDate();
            }
            case 1: {
                return pSSysPolicyModelBase.getCreateMan();
            }
            case 2: {
                return pSSysPolicyModelBase.getCurCnt();
            }
            case 3: {
                return pSSysPolicyModelBase.getFields();
            }
            case 4: {
                return pSSysPolicyModelBase.getMaxCnt();
            }
            case 5: {
                return pSSysPolicyModelBase.getMemo();
            }
            case 6: {
                return pSSysPolicyModelBase.getModelTag();
            }
            case 7: {
                return pSSysPolicyModelBase.getPolicyInfo();
            }
            case 8: {
                return pSSysPolicyModelBase.getPSSysPolicyId();
            }
            case 9: {
                return pSSysPolicyModelBase.getPSSysPolicyModelId();
            }
            case 10: {
                return pSSysPolicyModelBase.getPSSysPolicyModelName();
            }
            case 11: {
                return pSSysPolicyModelBase.getPSSysPolicyName();
            }
            case 12: {
                return pSSysPolicyModelBase.getUpdateDate();
            }
            case 13: {
                return pSSysPolicyModelBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public void set(String string, Object object) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(string, object);
            return;
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            super.set(string, object);
            return;
        }
        PSSysPolicyModelBase.set(this, n, object);
    }

    private static void set(PSSysPolicyModelBase pSSysPolicyModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPolicyModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysPolicyModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysPolicyModelBase.setCurCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysPolicyModelBase.setFields(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysPolicyModelBase.setMaxCnt(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysPolicyModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysPolicyModelBase.setModelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysPolicyModelBase.setPolicyInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysPolicyModelBase.setPSSysPolicyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysPolicyModelBase.setPSSysPolicyModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysPolicyModelBase.setPSSysPolicyModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysPolicyModelBase.setPSSysPolicyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysPolicyModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysPolicyModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean isNull(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.isNull(string);
        }
        return PSSysPolicyModelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPolicyModelBase pSSysPolicyModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyModelBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysPolicyModelBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysPolicyModelBase.getCurCnt() == null;
            }
            case 3: {
                return pSSysPolicyModelBase.getFields() == null;
            }
            case 4: {
                return pSSysPolicyModelBase.getMaxCnt() == null;
            }
            case 5: {
                return pSSysPolicyModelBase.getMemo() == null;
            }
            case 6: {
                return pSSysPolicyModelBase.getModelTag() == null;
            }
            case 7: {
                return pSSysPolicyModelBase.getPolicyInfo() == null;
            }
            case 8: {
                return pSSysPolicyModelBase.getPSSysPolicyId() == null;
            }
            case 9: {
                return pSSysPolicyModelBase.getPSSysPolicyModelId() == null;
            }
            case 10: {
                return pSSysPolicyModelBase.getPSSysPolicyModelName() == null;
            }
            case 11: {
                return pSSysPolicyModelBase.getPSSysPolicyName() == null;
            }
            case 12: {
                return pSSysPolicyModelBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysPolicyModelBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    public boolean contains(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.contains(string);
        }
        return PSSysPolicyModelBase.contains(this, n);
    }

    private static boolean contains(PSSysPolicyModelBase pSSysPolicyModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyModelBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysPolicyModelBase.isCreateManDirty();
            }
            case 2: {
                return pSSysPolicyModelBase.isCurCntDirty();
            }
            case 3: {
                return pSSysPolicyModelBase.isFieldsDirty();
            }
            case 4: {
                return pSSysPolicyModelBase.isMaxCntDirty();
            }
            case 5: {
                return pSSysPolicyModelBase.isMemoDirty();
            }
            case 6: {
                return pSSysPolicyModelBase.isModelTagDirty();
            }
            case 7: {
                return pSSysPolicyModelBase.isPolicyInfoDirty();
            }
            case 8: {
                return pSSysPolicyModelBase.isPSSysPolicyIdDirty();
            }
            case 9: {
                return pSSysPolicyModelBase.isPSSysPolicyModelIdDirty();
            }
            case 10: {
                return pSSysPolicyModelBase.isPSSysPolicyModelNameDirty();
            }
            case 11: {
                return pSSysPolicyModelBase.isPSSysPolicyNameDirty();
            }
            case 12: {
                return pSSysPolicyModelBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysPolicyModelBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPolicyModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPolicyModelBase pSSysPolicyModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPolicyModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getCurCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"curcnt", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getCurCnt()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getFields() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fields", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getFields()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getMaxCnt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcnt", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getMaxCnt()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getModelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getModelTag()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getPolicyInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"policyinfo", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getPolicyInfo()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyid", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getPSSysPolicyId()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicymodelid", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getPSSysPolicyModelId()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicymodelname", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getPSSysPolicyModelName()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyname", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getPSSysPolicyName()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPolicyModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPolicyModelBase.getJSONValue((Object)pSSysPolicyModelBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPolicyModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPolicyModelBase pSSysPolicyModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPolicyModelBase.getCreateDate() != null) {
            object = pSSysPolicyModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPolicyModelBase.getCreateMan() != null) {
            object = pSSysPolicyModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getCurCnt() != null) {
            object = pSSysPolicyModelBase.getCurCnt();
            xmlNode.setAttribute(FIELD_CURCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPolicyModelBase.getFields() != null) {
            object = pSSysPolicyModelBase.getFields();
            xmlNode.setAttribute(FIELD_FIELDS, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getMaxCnt() != null) {
            object = pSSysPolicyModelBase.getMaxCnt();
            xmlNode.setAttribute(FIELD_MAXCNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysPolicyModelBase.getMemo() != null) {
            object = pSSysPolicyModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getModelTag() != null) {
            object = pSSysPolicyModelBase.getModelTag();
            xmlNode.setAttribute(FIELD_MODELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getPolicyInfo() != null) {
            object = pSSysPolicyModelBase.getPolicyInfo();
            xmlNode.setAttribute(FIELD_POLICYINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyId() != null) {
            object = pSSysPolicyModelBase.getPSSysPolicyId();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyModelId() != null) {
            object = pSSysPolicyModelBase.getPSSysPolicyModelId();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyModelName() != null) {
            object = pSSysPolicyModelBase.getPSSysPolicyModelName();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getPSSysPolicyName() != null) {
            object = pSSysPolicyModelBase.getPSSysPolicyName();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyModelBase.getUpdateDate() != null) {
            object = pSSysPolicyModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPolicyModelBase.getUpdateMan() != null) {
            object = pSSysPolicyModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPolicyModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPolicyModelBase pSSysPolicyModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPolicyModelBase.isCreateDateDirty() && (bl || pSSysPolicyModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPolicyModelBase.getCreateDate());
        }
        if (pSSysPolicyModelBase.isCreateManDirty() && (bl || pSSysPolicyModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPolicyModelBase.getCreateMan());
        }
        if (pSSysPolicyModelBase.isCurCntDirty() && (bl || pSSysPolicyModelBase.getCurCnt() != null)) {
            iDataObject.set(FIELD_CURCNT, (Object)pSSysPolicyModelBase.getCurCnt());
        }
        if (pSSysPolicyModelBase.isFieldsDirty() && (bl || pSSysPolicyModelBase.getFields() != null)) {
            iDataObject.set(FIELD_FIELDS, (Object)pSSysPolicyModelBase.getFields());
        }
        if (pSSysPolicyModelBase.isMaxCntDirty() && (bl || pSSysPolicyModelBase.getMaxCnt() != null)) {
            iDataObject.set(FIELD_MAXCNT, (Object)pSSysPolicyModelBase.getMaxCnt());
        }
        if (pSSysPolicyModelBase.isMemoDirty() && (bl || pSSysPolicyModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPolicyModelBase.getMemo());
        }
        if (pSSysPolicyModelBase.isModelTagDirty() && (bl || pSSysPolicyModelBase.getModelTag() != null)) {
            iDataObject.set(FIELD_MODELTAG, (Object)pSSysPolicyModelBase.getModelTag());
        }
        if (pSSysPolicyModelBase.isPolicyInfoDirty() && (bl || pSSysPolicyModelBase.getPolicyInfo() != null)) {
            iDataObject.set(FIELD_POLICYINFO, (Object)pSSysPolicyModelBase.getPolicyInfo());
        }
        if (pSSysPolicyModelBase.isPSSysPolicyIdDirty() && (bl || pSSysPolicyModelBase.getPSSysPolicyId() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYID, (Object)pSSysPolicyModelBase.getPSSysPolicyId());
        }
        if (pSSysPolicyModelBase.isPSSysPolicyModelIdDirty() && (bl || pSSysPolicyModelBase.getPSSysPolicyModelId() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYMODELID, (Object)pSSysPolicyModelBase.getPSSysPolicyModelId());
        }
        if (pSSysPolicyModelBase.isPSSysPolicyModelNameDirty() && (bl || pSSysPolicyModelBase.getPSSysPolicyModelName() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYMODELNAME, (Object)pSSysPolicyModelBase.getPSSysPolicyModelName());
        }
        if (pSSysPolicyModelBase.isPSSysPolicyNameDirty() && (bl || pSSysPolicyModelBase.getPSSysPolicyName() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYNAME, (Object)pSSysPolicyModelBase.getPSSysPolicyName());
        }
        if (pSSysPolicyModelBase.isUpdateDateDirty() && (bl || pSSysPolicyModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPolicyModelBase.getUpdateDate());
        }
        if (pSSysPolicyModelBase.isUpdateManDirty() && (bl || pSSysPolicyModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPolicyModelBase.getUpdateMan());
        }
    }

    public boolean remove(String string) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(string);
        }
        if (StringHelper.isNullOrEmpty((String)string)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer n = fieldIndexMap.get(string.toUpperCase());
        if (n == null) {
            return super.remove(string);
        }
        return PSSysPolicyModelBase.remove(this, n);
    }

    private static boolean remove(PSSysPolicyModelBase pSSysPolicyModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPolicyModelBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysPolicyModelBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysPolicyModelBase.resetCurCnt();
                return true;
            }
            case 3: {
                pSSysPolicyModelBase.resetFields();
                return true;
            }
            case 4: {
                pSSysPolicyModelBase.resetMaxCnt();
                return true;
            }
            case 5: {
                pSSysPolicyModelBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysPolicyModelBase.resetModelTag();
                return true;
            }
            case 7: {
                pSSysPolicyModelBase.resetPolicyInfo();
                return true;
            }
            case 8: {
                pSSysPolicyModelBase.resetPSSysPolicyId();
                return true;
            }
            case 9: {
                pSSysPolicyModelBase.resetPSSysPolicyModelId();
                return true;
            }
            case 10: {
                pSSysPolicyModelBase.resetPSSysPolicyModelName();
                return true;
            }
            case 11: {
                pSSysPolicyModelBase.resetPSSysPolicyName();
                return true;
            }
            case 12: {
                pSSysPolicyModelBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysPolicyModelBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPolicy getPSSysPolicy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicy();
        }
        if (this.getPSSysPolicyId() == null) {
            return null;
        }
        Integer n = this.objPSSysPolicyLock;
        synchronized (n) {
            if (this.pssyspolicy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPolicyId(), (Object)this.pssyspolicy.getPSSysPolicyId()) != 0L) {
                this.pssyspolicy = null;
            }
            if (this.pssyspolicy == null) {
                PSSysPolicy pSSysPolicy = new PSSysPolicy();
                pSSysPolicy.setPSSysPolicyId(this.getPSSysPolicyId());
                PSSysPolicyService pSSysPolicyService = (PSSysPolicyService)ServiceGlobal.getService(PSSysPolicyService.class, (SessionFactory)this.getSessionFactory());
                pSSysPolicyService.autoGet((IEntity)pSSysPolicy);
                this.pssyspolicy = pSSysPolicy;
            }
            return this.pssyspolicy;
        }
    }

    private PSSysPolicyModelBase getProxyEntity() {
        return this.proxyPSSysPolicyModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPolicyModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPolicyModelBase) {
            this.proxyPSSysPolicyModelBase = (PSSysPolicyModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPolicyModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_CURCNT, 2);
        fieldIndexMap.put(FIELD_FIELDS, 3);
        fieldIndexMap.put(FIELD_MAXCNT, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MODELTAG, 6);
        fieldIndexMap.put(FIELD_POLICYINFO, 7);
        fieldIndexMap.put(FIELD_PSSYSPOLICYID, 8);
        fieldIndexMap.put(FIELD_PSSYSPOLICYMODELID, 9);
        fieldIndexMap.put(FIELD_PSSYSPOLICYMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSSYSPOLICYNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

