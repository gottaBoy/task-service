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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelErrorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelErrorBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ERRORCODE = "ERRORCODE";
    public static final String FIELD_ERRORDESC = "ERRORDESC";
    public static final String FIELD_FULLERRORCODE = "FULLERRORCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODELERRORID = "PSMODELERRORID";
    public static final String FIELD_PSMODELERRORNAME = "PSMODELERRORNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ERRORCODE = 2;
    private static final int INDEX_ERRORDESC = 3;
    private static final int INDEX_FULLERRORCODE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSMODELERRORID = 6;
    private static final int INDEX_PSMODELERRORNAME = 7;
    private static final int INDEX_PSMODELID = 8;
    private static final int INDEX_PSMODELNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelErrorBase proxyPSModelErrorBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean errorcodeDirtyFlag = false;
    private boolean errordescDirtyFlag = false;
    private boolean fullerrorcodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmodelerroridDirtyFlag = false;
    private boolean psmodelerrornameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="errorcode")
    private Integer errorcode;
    @Column(name="errordesc")
    private String errordesc;
    @Column(name="fullerrorcode")
    private Integer fullerrorcode;
    @Column(name="memo")
    private String memo;
    @Column(name="psmodelerrorid")
    private String psmodelerrorid;
    @Column(name="psmodelerrorname")
    private String psmodelerrorname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setErrorCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorCode(n);
            return;
        }
        this.errorcode = n;
        this.errorcodeDirtyFlag = true;
    }

    public Integer getErrorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorCode();
        }
        return this.errorcode;
    }

    public boolean isErrorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorCodeDirty();
        }
        return this.errorcodeDirtyFlag;
    }

    public void resetErrorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorCode();
            return;
        }
        this.errorcodeDirtyFlag = false;
        this.errorcode = null;
    }

    public void setErrorDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setErrorDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.errordesc = string;
        this.errordescDirtyFlag = true;
    }

    public String getErrorDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getErrorDesc();
        }
        return this.errordesc;
    }

    public boolean isErrorDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isErrorDescDirty();
        }
        return this.errordescDirtyFlag;
    }

    public void resetErrorDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetErrorDesc();
            return;
        }
        this.errordescDirtyFlag = false;
        this.errordesc = null;
    }

    public void setFullErrorCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullErrorCode(n);
            return;
        }
        this.fullerrorcode = n;
        this.fullerrorcodeDirtyFlag = true;
    }

    public Integer getFullErrorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullErrorCode();
        }
        return this.fullerrorcode;
    }

    public boolean isFullErrorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullErrorCodeDirty();
        }
        return this.fullerrorcodeDirtyFlag;
    }

    public void resetFullErrorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullErrorCode();
            return;
        }
        this.fullerrorcodeDirtyFlag = false;
        this.fullerrorcode = null;
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

    public void setPSModelErrorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelErrorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelerrorid = string;
        this.psmodelerroridDirtyFlag = true;
    }

    public String getPSModelErrorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelErrorId();
        }
        return this.psmodelerrorid;
    }

    public boolean isPSModelErrorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelErrorIdDirty();
        }
        return this.psmodelerroridDirtyFlag;
    }

    public void resetPSModelErrorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelErrorId();
            return;
        }
        this.psmodelerroridDirtyFlag = false;
        this.psmodelerrorid = null;
    }

    public void setPSModelErrorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelErrorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelerrorname = string;
        this.psmodelerrornameDirtyFlag = true;
    }

    public String getPSModelErrorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelErrorName();
        }
        return this.psmodelerrorname;
    }

    public boolean isPSModelErrorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelErrorNameDirty();
        }
        return this.psmodelerrornameDirtyFlag;
    }

    public void resetPSModelErrorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelErrorName();
            return;
        }
        this.psmodelerrornameDirtyFlag = false;
        this.psmodelerrorname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
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
        PSModelErrorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelErrorBase pSModelErrorBase) {
        pSModelErrorBase.resetCreateDate();
        pSModelErrorBase.resetCreateMan();
        pSModelErrorBase.resetErrorCode();
        pSModelErrorBase.resetErrorDesc();
        pSModelErrorBase.resetFullErrorCode();
        pSModelErrorBase.resetMemo();
        pSModelErrorBase.resetPSModelErrorId();
        pSModelErrorBase.resetPSModelErrorName();
        pSModelErrorBase.resetPSModelId();
        pSModelErrorBase.resetPSModelName();
        pSModelErrorBase.resetUpdateDate();
        pSModelErrorBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isErrorCodeDirty()) {
            hashMap.put(FIELD_ERRORCODE, this.getErrorCode());
        }
        if (!bl || this.isErrorDescDirty()) {
            hashMap.put(FIELD_ERRORDESC, this.getErrorDesc());
        }
        if (!bl || this.isFullErrorCodeDirty()) {
            hashMap.put(FIELD_FULLERRORCODE, this.getFullErrorCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModelErrorIdDirty()) {
            hashMap.put(FIELD_PSMODELERRORID, this.getPSModelErrorId());
        }
        if (!bl || this.isPSModelErrorNameDirty()) {
            hashMap.put(FIELD_PSMODELERRORNAME, this.getPSModelErrorName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
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
        return PSModelErrorBase.get(this, n);
    }

    private static Object get(PSModelErrorBase pSModelErrorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelErrorBase.getCreateDate();
            }
            case 1: {
                return pSModelErrorBase.getCreateMan();
            }
            case 2: {
                return pSModelErrorBase.getErrorCode();
            }
            case 3: {
                return pSModelErrorBase.getErrorDesc();
            }
            case 4: {
                return pSModelErrorBase.getFullErrorCode();
            }
            case 5: {
                return pSModelErrorBase.getMemo();
            }
            case 6: {
                return pSModelErrorBase.getPSModelErrorId();
            }
            case 7: {
                return pSModelErrorBase.getPSModelErrorName();
            }
            case 8: {
                return pSModelErrorBase.getPSModelId();
            }
            case 9: {
                return pSModelErrorBase.getPSModelName();
            }
            case 10: {
                return pSModelErrorBase.getUpdateDate();
            }
            case 11: {
                return pSModelErrorBase.getUpdateMan();
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
        PSModelErrorBase.set(this, n, object);
    }

    private static void set(PSModelErrorBase pSModelErrorBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelErrorBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelErrorBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelErrorBase.setErrorCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelErrorBase.setErrorDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelErrorBase.setFullErrorCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelErrorBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelErrorBase.setPSModelErrorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelErrorBase.setPSModelErrorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelErrorBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelErrorBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelErrorBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSModelErrorBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelErrorBase.isNull(this, n);
    }

    private static boolean isNull(PSModelErrorBase pSModelErrorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelErrorBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelErrorBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelErrorBase.getErrorCode() == null;
            }
            case 3: {
                return pSModelErrorBase.getErrorDesc() == null;
            }
            case 4: {
                return pSModelErrorBase.getFullErrorCode() == null;
            }
            case 5: {
                return pSModelErrorBase.getMemo() == null;
            }
            case 6: {
                return pSModelErrorBase.getPSModelErrorId() == null;
            }
            case 7: {
                return pSModelErrorBase.getPSModelErrorName() == null;
            }
            case 8: {
                return pSModelErrorBase.getPSModelId() == null;
            }
            case 9: {
                return pSModelErrorBase.getPSModelName() == null;
            }
            case 10: {
                return pSModelErrorBase.getUpdateDate() == null;
            }
            case 11: {
                return pSModelErrorBase.getUpdateMan() == null;
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
        return PSModelErrorBase.contains(this, n);
    }

    private static boolean contains(PSModelErrorBase pSModelErrorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelErrorBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelErrorBase.isCreateManDirty();
            }
            case 2: {
                return pSModelErrorBase.isErrorCodeDirty();
            }
            case 3: {
                return pSModelErrorBase.isErrorDescDirty();
            }
            case 4: {
                return pSModelErrorBase.isFullErrorCodeDirty();
            }
            case 5: {
                return pSModelErrorBase.isMemoDirty();
            }
            case 6: {
                return pSModelErrorBase.isPSModelErrorIdDirty();
            }
            case 7: {
                return pSModelErrorBase.isPSModelErrorNameDirty();
            }
            case 8: {
                return pSModelErrorBase.isPSModelIdDirty();
            }
            case 9: {
                return pSModelErrorBase.isPSModelNameDirty();
            }
            case 10: {
                return pSModelErrorBase.isUpdateDateDirty();
            }
            case 11: {
                return pSModelErrorBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelErrorBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelErrorBase pSModelErrorBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelErrorBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getErrorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errorcode", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getErrorCode()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getErrorDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"errordesc", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getErrorDesc()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getFullErrorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullerrorcode", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getFullErrorCode()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getPSModelErrorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelerrorid", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getPSModelErrorId()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getPSModelErrorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelerrorname", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getPSModelErrorName()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelErrorBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelErrorBase.getJSONValue((Object)pSModelErrorBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelErrorBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelErrorBase pSModelErrorBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelErrorBase.getCreateDate() != null) {
            object = pSModelErrorBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelErrorBase.getCreateMan() != null) {
            object = pSModelErrorBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getErrorCode() != null) {
            object = pSModelErrorBase.getErrorCode();
            xmlNode.setAttribute(FIELD_ERRORCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelErrorBase.getErrorDesc() != null) {
            object = pSModelErrorBase.getErrorDesc();
            xmlNode.setAttribute(FIELD_ERRORDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getFullErrorCode() != null) {
            object = pSModelErrorBase.getFullErrorCode();
            xmlNode.setAttribute(FIELD_FULLERRORCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelErrorBase.getMemo() != null) {
            object = pSModelErrorBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getPSModelErrorId() != null) {
            object = pSModelErrorBase.getPSModelErrorId();
            xmlNode.setAttribute(FIELD_PSMODELERRORID, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getPSModelErrorName() != null) {
            object = pSModelErrorBase.getPSModelErrorName();
            xmlNode.setAttribute(FIELD_PSMODELERRORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getPSModelId() != null) {
            object = pSModelErrorBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getPSModelName() != null) {
            object = pSModelErrorBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelErrorBase.getUpdateDate() != null) {
            object = pSModelErrorBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelErrorBase.getUpdateMan() != null) {
            object = pSModelErrorBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelErrorBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelErrorBase pSModelErrorBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelErrorBase.isCreateDateDirty() && (bl || pSModelErrorBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelErrorBase.getCreateDate());
        }
        if (pSModelErrorBase.isCreateManDirty() && (bl || pSModelErrorBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelErrorBase.getCreateMan());
        }
        if (pSModelErrorBase.isErrorCodeDirty() && (bl || pSModelErrorBase.getErrorCode() != null)) {
            iDataObject.set(FIELD_ERRORCODE, (Object)pSModelErrorBase.getErrorCode());
        }
        if (pSModelErrorBase.isErrorDescDirty() && (bl || pSModelErrorBase.getErrorDesc() != null)) {
            iDataObject.set(FIELD_ERRORDESC, (Object)pSModelErrorBase.getErrorDesc());
        }
        if (pSModelErrorBase.isFullErrorCodeDirty() && (bl || pSModelErrorBase.getFullErrorCode() != null)) {
            iDataObject.set(FIELD_FULLERRORCODE, (Object)pSModelErrorBase.getFullErrorCode());
        }
        if (pSModelErrorBase.isMemoDirty() && (bl || pSModelErrorBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelErrorBase.getMemo());
        }
        if (pSModelErrorBase.isPSModelErrorIdDirty() && (bl || pSModelErrorBase.getPSModelErrorId() != null)) {
            iDataObject.set(FIELD_PSMODELERRORID, (Object)pSModelErrorBase.getPSModelErrorId());
        }
        if (pSModelErrorBase.isPSModelErrorNameDirty() && (bl || pSModelErrorBase.getPSModelErrorName() != null)) {
            iDataObject.set(FIELD_PSMODELERRORNAME, (Object)pSModelErrorBase.getPSModelErrorName());
        }
        if (pSModelErrorBase.isPSModelIdDirty() && (bl || pSModelErrorBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelErrorBase.getPSModelId());
        }
        if (pSModelErrorBase.isPSModelNameDirty() && (bl || pSModelErrorBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelErrorBase.getPSModelName());
        }
        if (pSModelErrorBase.isUpdateDateDirty() && (bl || pSModelErrorBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelErrorBase.getUpdateDate());
        }
        if (pSModelErrorBase.isUpdateManDirty() && (bl || pSModelErrorBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelErrorBase.getUpdateMan());
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
        return PSModelErrorBase.remove(this, n);
    }

    private static boolean remove(PSModelErrorBase pSModelErrorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelErrorBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelErrorBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelErrorBase.resetErrorCode();
                return true;
            }
            case 3: {
                pSModelErrorBase.resetErrorDesc();
                return true;
            }
            case 4: {
                pSModelErrorBase.resetFullErrorCode();
                return true;
            }
            case 5: {
                pSModelErrorBase.resetMemo();
                return true;
            }
            case 6: {
                pSModelErrorBase.resetPSModelErrorId();
                return true;
            }
            case 7: {
                pSModelErrorBase.resetPSModelErrorName();
                return true;
            }
            case 8: {
                pSModelErrorBase.resetPSModelId();
                return true;
            }
            case 9: {
                pSModelErrorBase.resetPSModelName();
                return true;
            }
            case 10: {
                pSModelErrorBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSModelErrorBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelErrorBase getProxyEntity() {
        return this.proxyPSModelErrorBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelErrorBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelErrorBase) {
            this.proxyPSModelErrorBase = (PSModelErrorBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelErrorService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ERRORCODE, 2);
        fieldIndexMap.put(FIELD_ERRORDESC, 3);
        fieldIndexMap.put(FIELD_FULLERRORCODE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSMODELERRORID, 6);
        fieldIndexMap.put(FIELD_PSMODELERRORNAME, 7);
        fieldIndexMap.put(FIELD_PSMODELID, 8);
        fieldIndexMap.put(FIELD_PSMODELNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

