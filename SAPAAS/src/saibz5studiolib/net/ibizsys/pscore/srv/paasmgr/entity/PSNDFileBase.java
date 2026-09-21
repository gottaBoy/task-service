/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import org.hibernate.SessionFactory;

public abstract class PSNDFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSNDFileBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILEHASHCODE = "FILEHASHCODE";
    public static final String FIELD_FILEOBJSIZE = "FILEOBJSIZE";
    public static final String FIELD_FILEPATH = "FILEPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSNDFILEID = "PSNDFILEID";
    public static final String FIELD_PSNDFILENAME = "PSNDFILENAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FILEHASHCODE = 2;
    private static final int INDEX_FILEOBJSIZE = 3;
    private static final int INDEX_FILEPATH = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSNDFILEID = 6;
    private static final int INDEX_PSNDFILENAME = 7;
    private static final int INDEX_REFCOUNT = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSNDFileBase proxyPSNDFileBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean filehashcodeDirtyFlag = false;
    private boolean fileobjsizeDirtyFlag = false;
    private boolean filepathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psndfileidDirtyFlag = false;
    private boolean psndfilenameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="filehashcode")
    private String filehashcode;
    @Column(name="fileobjsize")
    private Double fileobjsize;
    @Column(name="filepath")
    private String filepath;
    @Column(name="memo")
    private String memo;
    @Column(name="psndfileid")
    private String psndfileid;
    @Column(name="psndfilename")
    private String psndfilename;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setFileHashCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileHashCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filehashcode = string;
        this.filehashcodeDirtyFlag = true;
    }

    public String getFileHashCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileHashCode();
        }
        return this.filehashcode;
    }

    public boolean isFileHashCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileHashCodeDirty();
        }
        return this.filehashcodeDirtyFlag;
    }

    public void resetFileHashCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileHashCode();
            return;
        }
        this.filehashcodeDirtyFlag = false;
        this.filehashcode = null;
    }

    public void setFileObjSize(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileObjSize(d);
            return;
        }
        this.fileobjsize = d;
        this.fileobjsizeDirtyFlag = true;
    }

    public Double getFileObjSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileObjSize();
        }
        return this.fileobjsize;
    }

    public boolean isFileObjSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileObjSizeDirty();
        }
        return this.fileobjsizeDirtyFlag;
    }

    public void resetFileObjSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileObjSize();
            return;
        }
        this.fileobjsizeDirtyFlag = false;
        this.fileobjsize = null;
    }

    public void setFilePath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFilePath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filepath = string;
        this.filepathDirtyFlag = true;
    }

    public String getFilePath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFilePath();
        }
        return this.filepath;
    }

    public boolean isFilePathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFilePathDirty();
        }
        return this.filepathDirtyFlag;
    }

    public void resetFilePath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFilePath();
            return;
        }
        this.filepathDirtyFlag = false;
        this.filepath = null;
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

    public void setPSNDFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfileid = string;
        this.psndfileidDirtyFlag = true;
    }

    public String getPSNDFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileId();
        }
        return this.psndfileid;
    }

    public boolean isPSNDFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileIdDirty();
        }
        return this.psndfileidDirtyFlag;
    }

    public void resetPSNDFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileId();
            return;
        }
        this.psndfileidDirtyFlag = false;
        this.psndfileid = null;
    }

    public void setPSNDFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSNDFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psndfilename = string;
        this.psndfilenameDirtyFlag = true;
    }

    public String getPSNDFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSNDFileName();
        }
        return this.psndfilename;
    }

    public boolean isPSNDFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSNDFileNameDirty();
        }
        return this.psndfilenameDirtyFlag;
    }

    public void resetPSNDFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSNDFileName();
            return;
        }
        this.psndfilenameDirtyFlag = false;
        this.psndfilename = null;
    }

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
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
        PSNDFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSNDFileBase pSNDFileBase) {
        pSNDFileBase.resetCreateDate();
        pSNDFileBase.resetCreateMan();
        pSNDFileBase.resetFileHashCode();
        pSNDFileBase.resetFileObjSize();
        pSNDFileBase.resetFilePath();
        pSNDFileBase.resetMemo();
        pSNDFileBase.resetPSNDFileId();
        pSNDFileBase.resetPSNDFileName();
        pSNDFileBase.resetRefCount();
        pSNDFileBase.resetUpdateDate();
        pSNDFileBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFileHashCodeDirty()) {
            hashMap.put(FIELD_FILEHASHCODE, this.getFileHashCode());
        }
        if (!bl || this.isFileObjSizeDirty()) {
            hashMap.put(FIELD_FILEOBJSIZE, this.getFileObjSize());
        }
        if (!bl || this.isFilePathDirty()) {
            hashMap.put(FIELD_FILEPATH, this.getFilePath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSNDFileIdDirty()) {
            hashMap.put(FIELD_PSNDFILEID, this.getPSNDFileId());
        }
        if (!bl || this.isPSNDFileNameDirty()) {
            hashMap.put(FIELD_PSNDFILENAME, this.getPSNDFileName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
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
        return PSNDFileBase.get(this, n);
    }

    private static Object get(PSNDFileBase pSNDFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileBase.getCreateDate();
            }
            case 1: {
                return pSNDFileBase.getCreateMan();
            }
            case 2: {
                return pSNDFileBase.getFileHashCode();
            }
            case 3: {
                return pSNDFileBase.getFileObjSize();
            }
            case 4: {
                return pSNDFileBase.getFilePath();
            }
            case 5: {
                return pSNDFileBase.getMemo();
            }
            case 6: {
                return pSNDFileBase.getPSNDFileId();
            }
            case 7: {
                return pSNDFileBase.getPSNDFileName();
            }
            case 8: {
                return pSNDFileBase.getRefCount();
            }
            case 9: {
                return pSNDFileBase.getUpdateDate();
            }
            case 10: {
                return pSNDFileBase.getUpdateMan();
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
        PSNDFileBase.set(this, n, object);
    }

    private static void set(PSNDFileBase pSNDFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSNDFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSNDFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSNDFileBase.setFileHashCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSNDFileBase.setFileObjSize(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSNDFileBase.setFilePath(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSNDFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSNDFileBase.setPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSNDFileBase.setPSNDFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSNDFileBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSNDFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSNDFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSNDFileBase.isNull(this, n);
    }

    private static boolean isNull(PSNDFileBase pSNDFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileBase.getCreateDate() == null;
            }
            case 1: {
                return pSNDFileBase.getCreateMan() == null;
            }
            case 2: {
                return pSNDFileBase.getFileHashCode() == null;
            }
            case 3: {
                return pSNDFileBase.getFileObjSize() == null;
            }
            case 4: {
                return pSNDFileBase.getFilePath() == null;
            }
            case 5: {
                return pSNDFileBase.getMemo() == null;
            }
            case 6: {
                return pSNDFileBase.getPSNDFileId() == null;
            }
            case 7: {
                return pSNDFileBase.getPSNDFileName() == null;
            }
            case 8: {
                return pSNDFileBase.getRefCount() == null;
            }
            case 9: {
                return pSNDFileBase.getUpdateDate() == null;
            }
            case 10: {
                return pSNDFileBase.getUpdateMan() == null;
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
        return PSNDFileBase.contains(this, n);
    }

    private static boolean contains(PSNDFileBase pSNDFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSNDFileBase.isCreateDateDirty();
            }
            case 1: {
                return pSNDFileBase.isCreateManDirty();
            }
            case 2: {
                return pSNDFileBase.isFileHashCodeDirty();
            }
            case 3: {
                return pSNDFileBase.isFileObjSizeDirty();
            }
            case 4: {
                return pSNDFileBase.isFilePathDirty();
            }
            case 5: {
                return pSNDFileBase.isMemoDirty();
            }
            case 6: {
                return pSNDFileBase.isPSNDFileIdDirty();
            }
            case 7: {
                return pSNDFileBase.isPSNDFileNameDirty();
            }
            case 8: {
                return pSNDFileBase.isRefCountDirty();
            }
            case 9: {
                return pSNDFileBase.isUpdateDateDirty();
            }
            case 10: {
                return pSNDFileBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSNDFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSNDFileBase pSNDFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSNDFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSNDFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSNDFileBase.getFileHashCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filehashcode", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getFileHashCode()), (boolean)false);
        }
        if (bl || pSNDFileBase.getFileObjSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileobjsize", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getFileObjSize()), (boolean)false);
        }
        if (bl || pSNDFileBase.getFilePath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filepath", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getFilePath()), (boolean)false);
        }
        if (bl || pSNDFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSNDFileBase.getPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfileid", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getPSNDFileId()), (boolean)false);
        }
        if (bl || pSNDFileBase.getPSNDFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfilename", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getPSNDFileName()), (boolean)false);
        }
        if (bl || pSNDFileBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getRefCount()), (boolean)false);
        }
        if (bl || pSNDFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSNDFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSNDFileBase.getJSONValue((Object)pSNDFileBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSNDFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSNDFileBase pSNDFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSNDFileBase.getCreateDate() != null) {
            object = pSNDFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSNDFileBase.getCreateMan() != null) {
            object = pSNDFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getFileHashCode() != null) {
            object = pSNDFileBase.getFileHashCode();
            xmlNode.setAttribute(FIELD_FILEHASHCODE, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getFileObjSize() != null) {
            object = pSNDFileBase.getFileObjSize();
            xmlNode.setAttribute(FIELD_FILEOBJSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSNDFileBase.getFilePath() != null) {
            object = pSNDFileBase.getFilePath();
            xmlNode.setAttribute(FIELD_FILEPATH, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getMemo() != null) {
            object = pSNDFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getPSNDFileId() != null) {
            object = pSNDFileBase.getPSNDFileId();
            xmlNode.setAttribute(FIELD_PSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getPSNDFileName() != null) {
            object = pSNDFileBase.getPSNDFileName();
            xmlNode.setAttribute(FIELD_PSNDFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSNDFileBase.getRefCount() != null) {
            object = pSNDFileBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSNDFileBase.getUpdateDate() != null) {
            object = pSNDFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSNDFileBase.getUpdateMan() != null) {
            object = pSNDFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSNDFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSNDFileBase pSNDFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSNDFileBase.isCreateDateDirty() && (bl || pSNDFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSNDFileBase.getCreateDate());
        }
        if (pSNDFileBase.isCreateManDirty() && (bl || pSNDFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSNDFileBase.getCreateMan());
        }
        if (pSNDFileBase.isFileHashCodeDirty() && (bl || pSNDFileBase.getFileHashCode() != null)) {
            iDataObject.set(FIELD_FILEHASHCODE, (Object)pSNDFileBase.getFileHashCode());
        }
        if (pSNDFileBase.isFileObjSizeDirty() && (bl || pSNDFileBase.getFileObjSize() != null)) {
            iDataObject.set(FIELD_FILEOBJSIZE, (Object)pSNDFileBase.getFileObjSize());
        }
        if (pSNDFileBase.isFilePathDirty() && (bl || pSNDFileBase.getFilePath() != null)) {
            iDataObject.set(FIELD_FILEPATH, (Object)pSNDFileBase.getFilePath());
        }
        if (pSNDFileBase.isMemoDirty() && (bl || pSNDFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSNDFileBase.getMemo());
        }
        if (pSNDFileBase.isPSNDFileIdDirty() && (bl || pSNDFileBase.getPSNDFileId() != null)) {
            iDataObject.set(FIELD_PSNDFILEID, (Object)pSNDFileBase.getPSNDFileId());
        }
        if (pSNDFileBase.isPSNDFileNameDirty() && (bl || pSNDFileBase.getPSNDFileName() != null)) {
            iDataObject.set(FIELD_PSNDFILENAME, (Object)pSNDFileBase.getPSNDFileName());
        }
        if (pSNDFileBase.isRefCountDirty() && (bl || pSNDFileBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSNDFileBase.getRefCount());
        }
        if (pSNDFileBase.isUpdateDateDirty() && (bl || pSNDFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSNDFileBase.getUpdateDate());
        }
        if (pSNDFileBase.isUpdateManDirty() && (bl || pSNDFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSNDFileBase.getUpdateMan());
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
        return PSNDFileBase.remove(this, n);
    }

    private static boolean remove(PSNDFileBase pSNDFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSNDFileBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSNDFileBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSNDFileBase.resetFileHashCode();
                return true;
            }
            case 3: {
                pSNDFileBase.resetFileObjSize();
                return true;
            }
            case 4: {
                pSNDFileBase.resetFilePath();
                return true;
            }
            case 5: {
                pSNDFileBase.resetMemo();
                return true;
            }
            case 6: {
                pSNDFileBase.resetPSNDFileId();
                return true;
            }
            case 7: {
                pSNDFileBase.resetPSNDFileName();
                return true;
            }
            case 8: {
                pSNDFileBase.resetRefCount();
                return true;
            }
            case 9: {
                pSNDFileBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSNDFileBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSNDFileBase getProxyEntity() {
        return this.proxyPSNDFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSNDFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSNDFileBase) {
            this.proxyPSNDFileBase = (PSNDFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSNDFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FILEHASHCODE, 2);
        fieldIndexMap.put(FIELD_FILEOBJSIZE, 3);
        fieldIndexMap.put(FIELD_FILEPATH, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSNDFILEID, 6);
        fieldIndexMap.put(FIELD_PSNDFILENAME, 7);
        fieldIndexMap.put(FIELD_REFCOUNT, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

