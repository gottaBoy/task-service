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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelStorageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelStorageBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELSTORAGEID = "PSMODELSTORAGEID";
    public static final String FIELD_PSMODELSTORAGENAME = "PSMODELSTORAGENAME";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_STORAGETYPE = "STORAGETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_PSMODELID = 3;
    private static final int INDEX_PSMODELNAME = 4;
    private static final int INDEX_PSMODELSTORAGEID = 5;
    private static final int INDEX_PSMODELSTORAGENAME = 6;
    private static final int INDEX_PSMODELTYPE = 7;
    private static final int INDEX_PSSYSTEMID = 8;
    private static final int INDEX_PSSYSTEMNAME = 9;
    private static final int INDEX_STORAGETYPE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelStorageBase proxyPSModelStorageBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelstorageidDirtyFlag = false;
    private boolean psmodelstoragenameDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean storagetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelstorageid")
    private String psmodelstorageid;
    @Column(name="psmodelstoragename")
    private String psmodelstoragename;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="storagetype")
    private String storagetype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPssystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setPSModelStorageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelStorageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelstorageid = string;
        this.psmodelstorageidDirtyFlag = true;
    }

    public String getPSModelStorageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelStorageId();
        }
        return this.psmodelstorageid;
    }

    public boolean isPSModelStorageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelStorageIdDirty();
        }
        return this.psmodelstorageidDirtyFlag;
    }

    public void resetPSModelStorageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelStorageId();
            return;
        }
        this.psmodelstorageidDirtyFlag = false;
        this.psmodelstorageid = null;
    }

    public void setPSModelStorageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelStorageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelstoragename = string;
        this.psmodelstoragenameDirtyFlag = true;
    }

    public String getPSModelStorageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelStorageName();
        }
        return this.psmodelstoragename;
    }

    public boolean isPSModelStorageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelStorageNameDirty();
        }
        return this.psmodelstoragenameDirtyFlag;
    }

    public void resetPSModelStorageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelStorageName();
            return;
        }
        this.psmodelstoragenameDirtyFlag = false;
        this.psmodelstoragename = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setStorageType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStorageType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.storagetype = string;
        this.storagetypeDirtyFlag = true;
    }

    public String getStorageType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStorageType();
        }
        return this.storagetype;
    }

    public boolean isStorageTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStorageTypeDirty();
        }
        return this.storagetypeDirtyFlag;
    }

    public void resetStorageType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStorageType();
            return;
        }
        this.storagetypeDirtyFlag = false;
        this.storagetype = null;
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
        PSModelStorageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelStorageBase pSModelStorageBase) {
        pSModelStorageBase.resetContent();
        pSModelStorageBase.resetCreateDate();
        pSModelStorageBase.resetCreateMan();
        pSModelStorageBase.resetPSModelId();
        pSModelStorageBase.resetPSModelName();
        pSModelStorageBase.resetPSModelStorageId();
        pSModelStorageBase.resetPSModelStorageName();
        pSModelStorageBase.resetPSModelType();
        pSModelStorageBase.resetPSSystemId();
        pSModelStorageBase.resetPSSystemName();
        pSModelStorageBase.resetStorageType();
        pSModelStorageBase.resetUpdateDate();
        pSModelStorageBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelStorageIdDirty()) {
            hashMap.put(FIELD_PSMODELSTORAGEID, this.getPSModelStorageId());
        }
        if (!bl || this.isPSModelStorageNameDirty()) {
            hashMap.put(FIELD_PSMODELSTORAGENAME, this.getPSModelStorageName());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isStorageTypeDirty()) {
            hashMap.put(FIELD_STORAGETYPE, this.getStorageType());
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
        return PSModelStorageBase.get(this, n);
    }

    private static Object get(PSModelStorageBase pSModelStorageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStorageBase.getContent();
            }
            case 1: {
                return pSModelStorageBase.getCreateDate();
            }
            case 2: {
                return pSModelStorageBase.getCreateMan();
            }
            case 3: {
                return pSModelStorageBase.getPSModelId();
            }
            case 4: {
                return pSModelStorageBase.getPSModelName();
            }
            case 5: {
                return pSModelStorageBase.getPSModelStorageId();
            }
            case 6: {
                return pSModelStorageBase.getPSModelStorageName();
            }
            case 7: {
                return pSModelStorageBase.getPSModelType();
            }
            case 8: {
                return pSModelStorageBase.getPSSystemId();
            }
            case 9: {
                return pSModelStorageBase.getPSSystemName();
            }
            case 10: {
                return pSModelStorageBase.getStorageType();
            }
            case 11: {
                return pSModelStorageBase.getUpdateDate();
            }
            case 12: {
                return pSModelStorageBase.getUpdateMan();
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
        PSModelStorageBase.set(this, n, object);
    }

    private static void set(PSModelStorageBase pSModelStorageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelStorageBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelStorageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSModelStorageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelStorageBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelStorageBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelStorageBase.setPSModelStorageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelStorageBase.setPSModelStorageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelStorageBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelStorageBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelStorageBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelStorageBase.setStorageType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelStorageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSModelStorageBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSModelStorageBase.isNull(this, n);
    }

    private static boolean isNull(PSModelStorageBase pSModelStorageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStorageBase.getContent() == null;
            }
            case 1: {
                return pSModelStorageBase.getCreateDate() == null;
            }
            case 2: {
                return pSModelStorageBase.getCreateMan() == null;
            }
            case 3: {
                return pSModelStorageBase.getPSModelId() == null;
            }
            case 4: {
                return pSModelStorageBase.getPSModelName() == null;
            }
            case 5: {
                return pSModelStorageBase.getPSModelStorageId() == null;
            }
            case 6: {
                return pSModelStorageBase.getPSModelStorageName() == null;
            }
            case 7: {
                return pSModelStorageBase.getPSModelType() == null;
            }
            case 8: {
                return pSModelStorageBase.getPSSystemId() == null;
            }
            case 9: {
                return pSModelStorageBase.getPSSystemName() == null;
            }
            case 10: {
                return pSModelStorageBase.getStorageType() == null;
            }
            case 11: {
                return pSModelStorageBase.getUpdateDate() == null;
            }
            case 12: {
                return pSModelStorageBase.getUpdateMan() == null;
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
        return PSModelStorageBase.contains(this, n);
    }

    private static boolean contains(PSModelStorageBase pSModelStorageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelStorageBase.isContentDirty();
            }
            case 1: {
                return pSModelStorageBase.isCreateDateDirty();
            }
            case 2: {
                return pSModelStorageBase.isCreateManDirty();
            }
            case 3: {
                return pSModelStorageBase.isPSModelIdDirty();
            }
            case 4: {
                return pSModelStorageBase.isPSModelNameDirty();
            }
            case 5: {
                return pSModelStorageBase.isPSModelStorageIdDirty();
            }
            case 6: {
                return pSModelStorageBase.isPSModelStorageNameDirty();
            }
            case 7: {
                return pSModelStorageBase.isPSModelTypeDirty();
            }
            case 8: {
                return pSModelStorageBase.isPSSystemIdDirty();
            }
            case 9: {
                return pSModelStorageBase.isPSSystemNameDirty();
            }
            case 10: {
                return pSModelStorageBase.isStorageTypeDirty();
            }
            case 11: {
                return pSModelStorageBase.isUpdateDateDirty();
            }
            case 12: {
                return pSModelStorageBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelStorageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelStorageBase pSModelStorageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelStorageBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getContent()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSModelStorageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelstorageid", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSModelStorageId()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSModelStorageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelstoragename", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSModelStorageName()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getStorageType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"storagetype", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getStorageType()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelStorageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelStorageBase.getJSONValue((Object)pSModelStorageBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelStorageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelStorageBase pSModelStorageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelStorageBase.getContent() != null) {
            object = pSModelStorageBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getCreateDate() != null) {
            object = pSModelStorageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelStorageBase.getCreateMan() != null) {
            object = pSModelStorageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSModelId() != null) {
            object = pSModelStorageBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSModelName() != null) {
            object = pSModelStorageBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSModelStorageId() != null) {
            object = pSModelStorageBase.getPSModelStorageId();
            xmlNode.setAttribute(FIELD_PSMODELSTORAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSModelStorageName() != null) {
            object = pSModelStorageBase.getPSModelStorageName();
            xmlNode.setAttribute(FIELD_PSMODELSTORAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSModelType() != null) {
            object = pSModelStorageBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSSystemId() != null) {
            object = pSModelStorageBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getPSSystemName() != null) {
            object = pSModelStorageBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getStorageType() != null) {
            object = pSModelStorageBase.getStorageType();
            xmlNode.setAttribute(FIELD_STORAGETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelStorageBase.getUpdateDate() != null) {
            object = pSModelStorageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelStorageBase.getUpdateMan() != null) {
            object = pSModelStorageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelStorageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelStorageBase pSModelStorageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelStorageBase.isContentDirty() && (bl || pSModelStorageBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelStorageBase.getContent());
        }
        if (pSModelStorageBase.isCreateDateDirty() && (bl || pSModelStorageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelStorageBase.getCreateDate());
        }
        if (pSModelStorageBase.isCreateManDirty() && (bl || pSModelStorageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelStorageBase.getCreateMan());
        }
        if (pSModelStorageBase.isPSModelIdDirty() && (bl || pSModelStorageBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelStorageBase.getPSModelId());
        }
        if (pSModelStorageBase.isPSModelNameDirty() && (bl || pSModelStorageBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelStorageBase.getPSModelName());
        }
        if (pSModelStorageBase.isPSModelStorageIdDirty() && (bl || pSModelStorageBase.getPSModelStorageId() != null)) {
            iDataObject.set(FIELD_PSMODELSTORAGEID, (Object)pSModelStorageBase.getPSModelStorageId());
        }
        if (pSModelStorageBase.isPSModelStorageNameDirty() && (bl || pSModelStorageBase.getPSModelStorageName() != null)) {
            iDataObject.set(FIELD_PSMODELSTORAGENAME, (Object)pSModelStorageBase.getPSModelStorageName());
        }
        if (pSModelStorageBase.isPSModelTypeDirty() && (bl || pSModelStorageBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSModelStorageBase.getPSModelType());
        }
        if (pSModelStorageBase.isPSSystemIdDirty() && (bl || pSModelStorageBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelStorageBase.getPSSystemId());
        }
        if (pSModelStorageBase.isPSSystemNameDirty() && (bl || pSModelStorageBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSModelStorageBase.getPSSystemName());
        }
        if (pSModelStorageBase.isStorageTypeDirty() && (bl || pSModelStorageBase.getStorageType() != null)) {
            iDataObject.set(FIELD_STORAGETYPE, (Object)pSModelStorageBase.getStorageType());
        }
        if (pSModelStorageBase.isUpdateDateDirty() && (bl || pSModelStorageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelStorageBase.getUpdateDate());
        }
        if (pSModelStorageBase.isUpdateManDirty() && (bl || pSModelStorageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelStorageBase.getUpdateMan());
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
        return PSModelStorageBase.remove(this, n);
    }

    private static boolean remove(PSModelStorageBase pSModelStorageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelStorageBase.resetContent();
                return true;
            }
            case 1: {
                pSModelStorageBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSModelStorageBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSModelStorageBase.resetPSModelId();
                return true;
            }
            case 4: {
                pSModelStorageBase.resetPSModelName();
                return true;
            }
            case 5: {
                pSModelStorageBase.resetPSModelStorageId();
                return true;
            }
            case 6: {
                pSModelStorageBase.resetPSModelStorageName();
                return true;
            }
            case 7: {
                pSModelStorageBase.resetPSModelType();
                return true;
            }
            case 8: {
                pSModelStorageBase.resetPSSystemId();
                return true;
            }
            case 9: {
                pSModelStorageBase.resetPSSystemName();
                return true;
            }
            case 10: {
                pSModelStorageBase.resetStorageType();
                return true;
            }
            case 11: {
                pSModelStorageBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSModelStorageBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPssystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPssystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSModelStorageBase getProxyEntity() {
        return this.proxyPSModelStorageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelStorageBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelStorageBase) {
            this.proxyPSModelStorageBase = (PSModelStorageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelStorageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_PSMODELID, 3);
        fieldIndexMap.put(FIELD_PSMODELNAME, 4);
        fieldIndexMap.put(FIELD_PSMODELSTORAGEID, 5);
        fieldIndexMap.put(FIELD_PSMODELSTORAGENAME, 6);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 9);
        fieldIndexMap.put(FIELD_STORAGETYPE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

