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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewEngineBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewEngineBase.class);
    public static final String FIELD_ALLDCFLAG = "ALLDCFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENGINEOBJ = "ENGINEOBJ";
    public static final String FIELD_ENGINETYPE = "ENGINETYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String FIELD_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLDCFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENGINEOBJ = 3;
    private static final int INDEX_ENGINETYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_PSVIEWENGINEID = 8;
    private static final int INDEX_PSVIEWENGINENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewEngineBase proxyPSViewEngineBase = null;
    private boolean alldcflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean engineobjDirtyFlag = false;
    private boolean enginetypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psviewengineidDirtyFlag = false;
    private boolean psviewenginenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="alldcflag")
    private Integer alldcflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="engineobj")
    private String engineobj;
    @Column(name="enginetype")
    private String enginetype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psviewengineid")
    private String psviewengineid;
    @Column(name="psviewenginename")
    private String psviewenginename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setAllDCFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllDCFlag(n);
            return;
        }
        this.alldcflag = n;
        this.alldcflagDirtyFlag = true;
    }

    public Integer getAllDCFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllDCFlag();
        }
        return this.alldcflag;
    }

    public boolean isAllDCFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllDCFlagDirty();
        }
        return this.alldcflagDirtyFlag;
    }

    public void resetAllDCFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllDCFlag();
            return;
        }
        this.alldcflagDirtyFlag = false;
        this.alldcflag = null;
    }

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

    public void setEngineObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.engineobj = string;
        this.engineobjDirtyFlag = true;
    }

    public String getEngineObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineObj();
        }
        return this.engineobj;
    }

    public boolean isEngineObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineObjDirty();
        }
        return this.engineobjDirtyFlag;
    }

    public void resetEngineObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineObj();
            return;
        }
        this.engineobjDirtyFlag = false;
        this.engineobj = null;
    }

    public void setEngineType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEngineType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enginetype = string;
        this.enginetypeDirtyFlag = true;
    }

    public String getEngineType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEngineType();
        }
        return this.enginetype;
    }

    public boolean isEngineTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEngineTypeDirty();
        }
        return this.enginetypeDirtyFlag;
    }

    public void resetEngineType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEngineType();
            return;
        }
        this.enginetypeDirtyFlag = false;
        this.enginetype = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSViewEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewengineid = string;
        this.psviewengineidDirtyFlag = true;
    }

    public String getPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineId();
        }
        return this.psviewengineid;
    }

    public boolean isPSViewEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineIdDirty();
        }
        return this.psviewengineidDirtyFlag;
    }

    public void resetPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineId();
            return;
        }
        this.psviewengineidDirtyFlag = false;
        this.psviewengineid = null;
    }

    public void setPSViewEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewenginename = string;
        this.psviewenginenameDirtyFlag = true;
    }

    public String getPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineName();
        }
        return this.psviewenginename;
    }

    public boolean isPSViewEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineNameDirty();
        }
        return this.psviewenginenameDirtyFlag;
    }

    public void resetPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineName();
            return;
        }
        this.psviewenginenameDirtyFlag = false;
        this.psviewenginename = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
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

    protected void onReset() {
        PSViewEngineBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewEngineBase pSViewEngineBase) {
        pSViewEngineBase.resetAllDCFlag();
        pSViewEngineBase.resetCreateDate();
        pSViewEngineBase.resetCreateMan();
        pSViewEngineBase.resetEngineObj();
        pSViewEngineBase.resetEngineType();
        pSViewEngineBase.resetMemo();
        pSViewEngineBase.resetPSDevCenterId();
        pSViewEngineBase.resetPSDevCenterName();
        pSViewEngineBase.resetPSViewEngineId();
        pSViewEngineBase.resetPSViewEngineName();
        pSViewEngineBase.resetUpdateDate();
        pSViewEngineBase.resetUpdateMan();
        pSViewEngineBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllDCFlagDirty()) {
            hashMap.put(FIELD_ALLDCFLAG, this.getAllDCFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEngineObjDirty()) {
            hashMap.put(FIELD_ENGINEOBJ, this.getEngineObj());
        }
        if (!bl || this.isEngineTypeDirty()) {
            hashMap.put(FIELD_ENGINETYPE, this.getEngineType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSViewEngineIdDirty()) {
            hashMap.put(FIELD_PSVIEWENGINEID, this.getPSViewEngineId());
        }
        if (!bl || this.isPSViewEngineNameDirty()) {
            hashMap.put(FIELD_PSVIEWENGINENAME, this.getPSViewEngineName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSViewEngineBase.get(this, n);
    }

    private static Object get(PSViewEngineBase pSViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewEngineBase.getAllDCFlag();
            }
            case 1: {
                return pSViewEngineBase.getCreateDate();
            }
            case 2: {
                return pSViewEngineBase.getCreateMan();
            }
            case 3: {
                return pSViewEngineBase.getEngineObj();
            }
            case 4: {
                return pSViewEngineBase.getEngineType();
            }
            case 5: {
                return pSViewEngineBase.getMemo();
            }
            case 6: {
                return pSViewEngineBase.getPSDevCenterId();
            }
            case 7: {
                return pSViewEngineBase.getPSDevCenterName();
            }
            case 8: {
                return pSViewEngineBase.getPSViewEngineId();
            }
            case 9: {
                return pSViewEngineBase.getPSViewEngineName();
            }
            case 10: {
                return pSViewEngineBase.getUpdateDate();
            }
            case 11: {
                return pSViewEngineBase.getUpdateMan();
            }
            case 12: {
                return pSViewEngineBase.getValidFlag();
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
        PSViewEngineBase.set(this, n, object);
    }

    private static void set(PSViewEngineBase pSViewEngineBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewEngineBase.setAllDCFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSViewEngineBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSViewEngineBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewEngineBase.setEngineObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewEngineBase.setEngineType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewEngineBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewEngineBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewEngineBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewEngineBase.setPSViewEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewEngineBase.setPSViewEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewEngineBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSViewEngineBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewEngineBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSViewEngineBase.isNull(this, n);
    }

    private static boolean isNull(PSViewEngineBase pSViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewEngineBase.getAllDCFlag() == null;
            }
            case 1: {
                return pSViewEngineBase.getCreateDate() == null;
            }
            case 2: {
                return pSViewEngineBase.getCreateMan() == null;
            }
            case 3: {
                return pSViewEngineBase.getEngineObj() == null;
            }
            case 4: {
                return pSViewEngineBase.getEngineType() == null;
            }
            case 5: {
                return pSViewEngineBase.getMemo() == null;
            }
            case 6: {
                return pSViewEngineBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSViewEngineBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSViewEngineBase.getPSViewEngineId() == null;
            }
            case 9: {
                return pSViewEngineBase.getPSViewEngineName() == null;
            }
            case 10: {
                return pSViewEngineBase.getUpdateDate() == null;
            }
            case 11: {
                return pSViewEngineBase.getUpdateMan() == null;
            }
            case 12: {
                return pSViewEngineBase.getValidFlag() == null;
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
        return PSViewEngineBase.contains(this, n);
    }

    private static boolean contains(PSViewEngineBase pSViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewEngineBase.isAllDCFlagDirty();
            }
            case 1: {
                return pSViewEngineBase.isCreateDateDirty();
            }
            case 2: {
                return pSViewEngineBase.isCreateManDirty();
            }
            case 3: {
                return pSViewEngineBase.isEngineObjDirty();
            }
            case 4: {
                return pSViewEngineBase.isEngineTypeDirty();
            }
            case 5: {
                return pSViewEngineBase.isMemoDirty();
            }
            case 6: {
                return pSViewEngineBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSViewEngineBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSViewEngineBase.isPSViewEngineIdDirty();
            }
            case 9: {
                return pSViewEngineBase.isPSViewEngineNameDirty();
            }
            case 10: {
                return pSViewEngineBase.isUpdateDateDirty();
            }
            case 11: {
                return pSViewEngineBase.isUpdateManDirty();
            }
            case 12: {
                return pSViewEngineBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewEngineBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewEngineBase pSViewEngineBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewEngineBase.getAllDCFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"alldcflag", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getAllDCFlag()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getEngineObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"engineobj", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getEngineObj()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getEngineType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enginetype", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getEngineType()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getPSViewEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewengineid", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getPSViewEngineId()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getPSViewEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewenginename", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getPSViewEngineName()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewEngineBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewEngineBase.getJSONValue((Object)pSViewEngineBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewEngineBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewEngineBase pSViewEngineBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewEngineBase.getAllDCFlag() != null) {
            object = pSViewEngineBase.getAllDCFlag();
            xmlNode.setAttribute(FIELD_ALLDCFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewEngineBase.getCreateDate() != null) {
            object = pSViewEngineBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewEngineBase.getCreateMan() != null) {
            object = pSViewEngineBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getEngineObj() != null) {
            object = pSViewEngineBase.getEngineObj();
            xmlNode.setAttribute(FIELD_ENGINEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getEngineType() != null) {
            object = pSViewEngineBase.getEngineType();
            xmlNode.setAttribute(FIELD_ENGINETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getMemo() != null) {
            object = pSViewEngineBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getPSDevCenterId() != null) {
            object = pSViewEngineBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getPSDevCenterName() != null) {
            object = pSViewEngineBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getPSViewEngineId() != null) {
            object = pSViewEngineBase.getPSViewEngineId();
            xmlNode.setAttribute(FIELD_PSVIEWENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getPSViewEngineName() != null) {
            object = pSViewEngineBase.getPSViewEngineName();
            xmlNode.setAttribute(FIELD_PSVIEWENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getUpdateDate() != null) {
            object = pSViewEngineBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewEngineBase.getUpdateMan() != null) {
            object = pSViewEngineBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewEngineBase.getValidFlag() != null) {
            object = pSViewEngineBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewEngineBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewEngineBase pSViewEngineBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewEngineBase.isAllDCFlagDirty() && (bl || pSViewEngineBase.getAllDCFlag() != null)) {
            iDataObject.set(FIELD_ALLDCFLAG, (Object)pSViewEngineBase.getAllDCFlag());
        }
        if (pSViewEngineBase.isCreateDateDirty() && (bl || pSViewEngineBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewEngineBase.getCreateDate());
        }
        if (pSViewEngineBase.isCreateManDirty() && (bl || pSViewEngineBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewEngineBase.getCreateMan());
        }
        if (pSViewEngineBase.isEngineObjDirty() && (bl || pSViewEngineBase.getEngineObj() != null)) {
            iDataObject.set(FIELD_ENGINEOBJ, (Object)pSViewEngineBase.getEngineObj());
        }
        if (pSViewEngineBase.isEngineTypeDirty() && (bl || pSViewEngineBase.getEngineType() != null)) {
            iDataObject.set(FIELD_ENGINETYPE, (Object)pSViewEngineBase.getEngineType());
        }
        if (pSViewEngineBase.isMemoDirty() && (bl || pSViewEngineBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewEngineBase.getMemo());
        }
        if (pSViewEngineBase.isPSDevCenterIdDirty() && (bl || pSViewEngineBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSViewEngineBase.getPSDevCenterId());
        }
        if (pSViewEngineBase.isPSDevCenterNameDirty() && (bl || pSViewEngineBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSViewEngineBase.getPSDevCenterName());
        }
        if (pSViewEngineBase.isPSViewEngineIdDirty() && (bl || pSViewEngineBase.getPSViewEngineId() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINEID, (Object)pSViewEngineBase.getPSViewEngineId());
        }
        if (pSViewEngineBase.isPSViewEngineNameDirty() && (bl || pSViewEngineBase.getPSViewEngineName() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINENAME, (Object)pSViewEngineBase.getPSViewEngineName());
        }
        if (pSViewEngineBase.isUpdateDateDirty() && (bl || pSViewEngineBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewEngineBase.getUpdateDate());
        }
        if (pSViewEngineBase.isUpdateManDirty() && (bl || pSViewEngineBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewEngineBase.getUpdateMan());
        }
        if (pSViewEngineBase.isValidFlagDirty() && (bl || pSViewEngineBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewEngineBase.getValidFlag());
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
        return PSViewEngineBase.remove(this, n);
    }

    private static boolean remove(PSViewEngineBase pSViewEngineBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewEngineBase.resetAllDCFlag();
                return true;
            }
            case 1: {
                pSViewEngineBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSViewEngineBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSViewEngineBase.resetEngineObj();
                return true;
            }
            case 4: {
                pSViewEngineBase.resetEngineType();
                return true;
            }
            case 5: {
                pSViewEngineBase.resetMemo();
                return true;
            }
            case 6: {
                pSViewEngineBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSViewEngineBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSViewEngineBase.resetPSViewEngineId();
                return true;
            }
            case 9: {
                pSViewEngineBase.resetPSViewEngineName();
                return true;
            }
            case 10: {
                pSViewEngineBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSViewEngineBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSViewEngineBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSViewEngineBase getProxyEntity() {
        return this.proxyPSViewEngineBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewEngineBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewEngineBase) {
            this.proxyPSViewEngineBase = (PSViewEngineBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewEngineService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLDCFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENGINEOBJ, 3);
        fieldIndexMap.put(FIELD_ENGINETYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_PSVIEWENGINEID, 8);
        fieldIndexMap.put(FIELD_PSVIEWENGINENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

