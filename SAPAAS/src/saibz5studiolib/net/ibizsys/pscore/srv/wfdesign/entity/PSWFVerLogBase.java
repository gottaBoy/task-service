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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFVerLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFVerLogBase.class);
    public static final String FIELD_BACKDATATAG = "BACKDATATAG";
    public static final String FIELD_BACKUPDATA = "BACKUPDATA";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSWFVERLOGID = "PSWFVERLOGID";
    public static final String FIELD_PSWFVERLOGNAME = "PSWFVERLOGNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BACKDATATAG = 0;
    private static final int INDEX_BACKUPDATA = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSDYNAINSTID = 6;
    private static final int INDEX_PSWFVERLOGID = 7;
    private static final int INDEX_PSWFVERLOGNAME = 8;
    private static final int INDEX_PSWFVERSIONID = 9;
    private static final int INDEX_PSWFVERSIONNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFVerLogBase proxyPSWFVerLogBase = null;
    private boolean backdatatagDirtyFlag = false;
    private boolean backupdataDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pswfverlogidDirtyFlag = false;
    private boolean pswfverlognameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="backdatatag")
    private String backdatatag;
    @Column(name="backupdata")
    private String backupdata;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pswfverlogid")
    private String pswfverlogid;
    @Column(name="pswfverlogname")
    private String pswfverlogname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;

    public void setBackDataTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackDataTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backdatatag = string;
        this.backdatatagDirtyFlag = true;
    }

    public String getBackDataTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackDataTag();
        }
        return this.backdatatag;
    }

    public boolean isBackDataTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackDataTagDirty();
        }
        return this.backdatatagDirtyFlag;
    }

    public void resetBackDataTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackDataTag();
            return;
        }
        this.backdatatagDirtyFlag = false;
        this.backdatatag = null;
    }

    public void setBackupData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBackupData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.backupdata = string;
        this.backupdataDirtyFlag = true;
    }

    public String getBackupData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBackupData();
        }
        return this.backupdata;
    }

    public boolean isBackupDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBackupDataDirty();
        }
        return this.backupdataDirtyFlag;
    }

    public void resetBackupData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBackupData();
            return;
        }
        this.backupdataDirtyFlag = false;
        this.backupdata = null;
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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSWFVerLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVerLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfverlogid = string;
        this.pswfverlogidDirtyFlag = true;
    }

    public String getPSWFVerLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVerLogId();
        }
        return this.pswfverlogid;
    }

    public boolean isPSWFVerLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVerLogIdDirty();
        }
        return this.pswfverlogidDirtyFlag;
    }

    public void resetPSWFVerLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVerLogId();
            return;
        }
        this.pswfverlogidDirtyFlag = false;
        this.pswfverlogid = null;
    }

    public void setPSWFVerLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVerLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfverlogname = string;
        this.pswfverlognameDirtyFlag = true;
    }

    public String getPSWFVerLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVerLogName();
        }
        return this.pswfverlogname;
    }

    public boolean isPSWFVerLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVerLogNameDirty();
        }
        return this.pswfverlognameDirtyFlag;
    }

    public void resetPSWFVerLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVerLogName();
            return;
        }
        this.pswfverlognameDirtyFlag = false;
        this.pswfverlogname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
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
        PSWFVerLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFVerLogBase pSWFVerLogBase) {
        pSWFVerLogBase.resetBackDataTag();
        pSWFVerLogBase.resetBackupData();
        pSWFVerLogBase.resetCreateDate();
        pSWFVerLogBase.resetCreateMan();
        pSWFVerLogBase.resetDynaModelFlag();
        pSWFVerLogBase.resetMemo();
        pSWFVerLogBase.resetPSDynaInstId();
        pSWFVerLogBase.resetPSWFVerLogId();
        pSWFVerLogBase.resetPSWFVerLogName();
        pSWFVerLogBase.resetPSWFVersionId();
        pSWFVerLogBase.resetPSWFVersionName();
        pSWFVerLogBase.resetUpdateDate();
        pSWFVerLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBackDataTagDirty()) {
            hashMap.put(FIELD_BACKDATATAG, this.getBackDataTag());
        }
        if (!bl || this.isBackupDataDirty()) {
            hashMap.put(FIELD_BACKUPDATA, this.getBackupData());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSWFVerLogIdDirty()) {
            hashMap.put(FIELD_PSWFVERLOGID, this.getPSWFVerLogId());
        }
        if (!bl || this.isPSWFVerLogNameDirty()) {
            hashMap.put(FIELD_PSWFVERLOGNAME, this.getPSWFVerLogName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
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
        return PSWFVerLogBase.get(this, n);
    }

    private static Object get(PSWFVerLogBase pSWFVerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVerLogBase.getBackDataTag();
            }
            case 1: {
                return pSWFVerLogBase.getBackupData();
            }
            case 2: {
                return pSWFVerLogBase.getCreateDate();
            }
            case 3: {
                return pSWFVerLogBase.getCreateMan();
            }
            case 4: {
                return pSWFVerLogBase.getDynaModelFlag();
            }
            case 5: {
                return pSWFVerLogBase.getMemo();
            }
            case 6: {
                return pSWFVerLogBase.getPSDynaInstId();
            }
            case 7: {
                return pSWFVerLogBase.getPSWFVerLogId();
            }
            case 8: {
                return pSWFVerLogBase.getPSWFVerLogName();
            }
            case 9: {
                return pSWFVerLogBase.getPSWFVersionId();
            }
            case 10: {
                return pSWFVerLogBase.getPSWFVersionName();
            }
            case 11: {
                return pSWFVerLogBase.getUpdateDate();
            }
            case 12: {
                return pSWFVerLogBase.getUpdateMan();
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
        PSWFVerLogBase.set(this, n, object);
    }

    private static void set(PSWFVerLogBase pSWFVerLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFVerLogBase.setBackDataTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFVerLogBase.setBackupData(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWFVerLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSWFVerLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFVerLogBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSWFVerLogBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFVerLogBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWFVerLogBase.setPSWFVerLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWFVerLogBase.setPSWFVerLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFVerLogBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFVerLogBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFVerLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSWFVerLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFVerLogBase.isNull(this, n);
    }

    private static boolean isNull(PSWFVerLogBase pSWFVerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVerLogBase.getBackDataTag() == null;
            }
            case 1: {
                return pSWFVerLogBase.getBackupData() == null;
            }
            case 2: {
                return pSWFVerLogBase.getCreateDate() == null;
            }
            case 3: {
                return pSWFVerLogBase.getCreateMan() == null;
            }
            case 4: {
                return pSWFVerLogBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSWFVerLogBase.getMemo() == null;
            }
            case 6: {
                return pSWFVerLogBase.getPSDynaInstId() == null;
            }
            case 7: {
                return pSWFVerLogBase.getPSWFVerLogId() == null;
            }
            case 8: {
                return pSWFVerLogBase.getPSWFVerLogName() == null;
            }
            case 9: {
                return pSWFVerLogBase.getPSWFVersionId() == null;
            }
            case 10: {
                return pSWFVerLogBase.getPSWFVersionName() == null;
            }
            case 11: {
                return pSWFVerLogBase.getUpdateDate() == null;
            }
            case 12: {
                return pSWFVerLogBase.getUpdateMan() == null;
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
        return PSWFVerLogBase.contains(this, n);
    }

    private static boolean contains(PSWFVerLogBase pSWFVerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFVerLogBase.isBackDataTagDirty();
            }
            case 1: {
                return pSWFVerLogBase.isBackupDataDirty();
            }
            case 2: {
                return pSWFVerLogBase.isCreateDateDirty();
            }
            case 3: {
                return pSWFVerLogBase.isCreateManDirty();
            }
            case 4: {
                return pSWFVerLogBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSWFVerLogBase.isMemoDirty();
            }
            case 6: {
                return pSWFVerLogBase.isPSDynaInstIdDirty();
            }
            case 7: {
                return pSWFVerLogBase.isPSWFVerLogIdDirty();
            }
            case 8: {
                return pSWFVerLogBase.isPSWFVerLogNameDirty();
            }
            case 9: {
                return pSWFVerLogBase.isPSWFVersionIdDirty();
            }
            case 10: {
                return pSWFVerLogBase.isPSWFVersionNameDirty();
            }
            case 11: {
                return pSWFVerLogBase.isUpdateDateDirty();
            }
            case 12: {
                return pSWFVerLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFVerLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFVerLogBase pSWFVerLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFVerLogBase.getBackDataTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backdatatag", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getBackDataTag()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getBackupData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"backupdata", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getBackupData()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getPSWFVerLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfverlogid", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getPSWFVerLogId()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getPSWFVerLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfverlogname", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getPSWFVerLogName()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFVerLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFVerLogBase.getJSONValue((Object)pSWFVerLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFVerLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFVerLogBase pSWFVerLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFVerLogBase.getBackDataTag() != null) {
            object = pSWFVerLogBase.getBackDataTag();
            xmlNode.setAttribute(FIELD_BACKDATATAG, (String)(object == null ? "" : object));
        }
        if (bl || pSWFVerLogBase.getBackupData() != null) {
            object = pSWFVerLogBase.getBackupData();
            xmlNode.setAttribute(FIELD_BACKUPDATA, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getCreateDate() != null) {
            object = pSWFVerLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFVerLogBase.getCreateMan() != null) {
            object = pSWFVerLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getDynaModelFlag() != null) {
            object = pSWFVerLogBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFVerLogBase.getMemo() != null) {
            object = pSWFVerLogBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getPSDynaInstId() != null) {
            object = pSWFVerLogBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getPSWFVerLogId() != null) {
            object = pSWFVerLogBase.getPSWFVerLogId();
            xmlNode.setAttribute(FIELD_PSWFVERLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getPSWFVerLogName() != null) {
            object = pSWFVerLogBase.getPSWFVerLogName();
            xmlNode.setAttribute(FIELD_PSWFVERLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getPSWFVersionId() != null) {
            object = pSWFVerLogBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getPSWFVersionName() != null) {
            object = pSWFVerLogBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFVerLogBase.getUpdateDate() != null) {
            object = pSWFVerLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFVerLogBase.getUpdateMan() != null) {
            object = pSWFVerLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFVerLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFVerLogBase pSWFVerLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFVerLogBase.isBackDataTagDirty() && (bl || pSWFVerLogBase.getBackDataTag() != null)) {
            iDataObject.set(FIELD_BACKDATATAG, (Object)pSWFVerLogBase.getBackDataTag());
        }
        if (pSWFVerLogBase.isBackupDataDirty() && (bl || pSWFVerLogBase.getBackupData() != null)) {
            iDataObject.set(FIELD_BACKUPDATA, (Object)pSWFVerLogBase.getBackupData());
        }
        if (pSWFVerLogBase.isCreateDateDirty() && (bl || pSWFVerLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFVerLogBase.getCreateDate());
        }
        if (pSWFVerLogBase.isCreateManDirty() && (bl || pSWFVerLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFVerLogBase.getCreateMan());
        }
        if (pSWFVerLogBase.isDynaModelFlagDirty() && (bl || pSWFVerLogBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFVerLogBase.getDynaModelFlag());
        }
        if (pSWFVerLogBase.isMemoDirty() && (bl || pSWFVerLogBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFVerLogBase.getMemo());
        }
        if (pSWFVerLogBase.isPSDynaInstIdDirty() && (bl || pSWFVerLogBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFVerLogBase.getPSDynaInstId());
        }
        if (pSWFVerLogBase.isPSWFVerLogIdDirty() && (bl || pSWFVerLogBase.getPSWFVerLogId() != null)) {
            iDataObject.set(FIELD_PSWFVERLOGID, (Object)pSWFVerLogBase.getPSWFVerLogId());
        }
        if (pSWFVerLogBase.isPSWFVerLogNameDirty() && (bl || pSWFVerLogBase.getPSWFVerLogName() != null)) {
            iDataObject.set(FIELD_PSWFVERLOGNAME, (Object)pSWFVerLogBase.getPSWFVerLogName());
        }
        if (pSWFVerLogBase.isPSWFVersionIdDirty() && (bl || pSWFVerLogBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFVerLogBase.getPSWFVersionId());
        }
        if (pSWFVerLogBase.isPSWFVersionNameDirty() && (bl || pSWFVerLogBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFVerLogBase.getPSWFVersionName());
        }
        if (pSWFVerLogBase.isUpdateDateDirty() && (bl || pSWFVerLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFVerLogBase.getUpdateDate());
        }
        if (pSWFVerLogBase.isUpdateManDirty() && (bl || pSWFVerLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFVerLogBase.getUpdateMan());
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
        return PSWFVerLogBase.remove(this, n);
    }

    private static boolean remove(PSWFVerLogBase pSWFVerLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFVerLogBase.resetBackDataTag();
                return true;
            }
            case 1: {
                pSWFVerLogBase.resetBackupData();
                return true;
            }
            case 2: {
                pSWFVerLogBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSWFVerLogBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSWFVerLogBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSWFVerLogBase.resetMemo();
                return true;
            }
            case 6: {
                pSWFVerLogBase.resetPSDynaInstId();
                return true;
            }
            case 7: {
                pSWFVerLogBase.resetPSWFVerLogId();
                return true;
            }
            case 8: {
                pSWFVerLogBase.resetPSWFVerLogName();
                return true;
            }
            case 9: {
                pSWFVerLogBase.resetPSWFVersionId();
                return true;
            }
            case 10: {
                pSWFVerLogBase.resetPSWFVersionName();
                return true;
            }
            case 11: {
                pSWFVerLogBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSWFVerLogBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet((IEntity)pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    private PSWFVerLogBase getProxyEntity() {
        return this.proxyPSWFVerLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFVerLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFVerLogBase) {
            this.proxyPSWFVerLogBase = (PSWFVerLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFVerLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BACKDATATAG, 0);
        fieldIndexMap.put(FIELD_BACKUPDATA, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 6);
        fieldIndexMap.put(FIELD_PSWFVERLOGID, 7);
        fieldIndexMap.put(FIELD_PSWFVERLOGNAME, 8);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 9);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

