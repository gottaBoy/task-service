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
package net.ibizsys.pscore.srv.def.entity;

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
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.service.PSV3MigrateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MGFormBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSV3MGFormBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFORMID = "DEFORMID";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_IGNOREFLAG = "IGNOREFLAG";
    public static final String FIELD_PSV3MGFORMID = "PSV3MGFORMID";
    public static final String FIELD_PSV3MGFORMNAME = "PSV3MGFORMNAME";
    public static final String FIELD_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String FIELD_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEFORMID = 2;
    private static final int INDEX_DEID = 3;
    private static final int INDEX_DENAME = 4;
    private static final int INDEX_IGNOREFLAG = 5;
    private static final int INDEX_PSV3MGFORMID = 6;
    private static final int INDEX_PSV3MGFORMNAME = 7;
    private static final int INDEX_PSV3MIGRATEID = 8;
    private static final int INDEX_PSV3MIGRATENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSV3MGFormBase proxyPSV3MGFormBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deformidDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean ignoreflagDirtyFlag = false;
    private boolean psv3mgformidDirtyFlag = false;
    private boolean psv3mgformnameDirtyFlag = false;
    private boolean psv3migrateidDirtyFlag = false;
    private boolean psv3migratenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deformid")
    private String deformid;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="ignoreflag")
    private Integer ignoreflag;
    @Column(name="psv3mgformid")
    private String psv3mgformid;
    @Column(name="psv3mgformname")
    private String psv3mgformname;
    @Column(name="psv3migrateid")
    private String psv3migrateid;
    @Column(name="psv3migratename")
    private String psv3migratename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsv3migrateLock = new Integer(1);
    private PSV3Migrate psv3migrate = null;

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

    public void setDEFORMID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEFORMID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deformid = string;
        this.deformidDirtyFlag = true;
    }

    public String getDEFORMID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEFORMID();
        }
        return this.deformid;
    }

    public boolean isDEFORMIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEFORMIDDirty();
        }
        return this.deformidDirtyFlag;
    }

    public void resetDEFORMID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEFORMID();
            return;
        }
        this.deformidDirtyFlag = false;
        this.deformid = null;
    }

    public void setDEID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deid = string;
        this.deidDirtyFlag = true;
    }

    public String getDEID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEID();
        }
        return this.deid;
    }

    public boolean isDEIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIDDirty();
        }
        return this.deidDirtyFlag;
    }

    public void resetDEID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEID();
            return;
        }
        this.deidDirtyFlag = false;
        this.deid = null;
    }

    public void setDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dename = string;
        this.denameDirtyFlag = true;
    }

    public String getDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEName();
        }
        return this.dename;
    }

    public boolean isDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENameDirty();
        }
        return this.denameDirtyFlag;
    }

    public void resetDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEName();
            return;
        }
        this.denameDirtyFlag = false;
        this.dename = null;
    }

    public void setIgnoreFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIgnoreFlag(n);
            return;
        }
        this.ignoreflag = n;
        this.ignoreflagDirtyFlag = true;
    }

    public Integer getIgnoreFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIgnoreFlag();
        }
        return this.ignoreflag;
    }

    public boolean isIgnoreFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIgnoreFlagDirty();
        }
        return this.ignoreflagDirtyFlag;
    }

    public void resetIgnoreFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIgnoreFlag();
            return;
        }
        this.ignoreflagDirtyFlag = false;
        this.ignoreflag = null;
    }

    public void setPSV3MGFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mgformid = string;
        this.psv3mgformidDirtyFlag = true;
    }

    public String getPSV3MGFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGFormId();
        }
        return this.psv3mgformid;
    }

    public boolean isPSV3MGFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGFormIdDirty();
        }
        return this.psv3mgformidDirtyFlag;
    }

    public void resetPSV3MGFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGFormId();
            return;
        }
        this.psv3mgformidDirtyFlag = false;
        this.psv3mgformid = null;
    }

    public void setPSV3MGFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mgformname = string;
        this.psv3mgformnameDirtyFlag = true;
    }

    public String getPSV3MGFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGFormName();
        }
        return this.psv3mgformname;
    }

    public boolean isPSV3MGFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGFormNameDirty();
        }
        return this.psv3mgformnameDirtyFlag;
    }

    public void resetPSV3MGFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGFormName();
            return;
        }
        this.psv3mgformnameDirtyFlag = false;
        this.psv3mgformname = null;
    }

    public void setPSV3MigrateId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migrateid = string;
        this.psv3migrateidDirtyFlag = true;
    }

    public String getPSV3MigrateId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateId();
        }
        return this.psv3migrateid;
    }

    public boolean isPSV3MigrateIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateIdDirty();
        }
        return this.psv3migrateidDirtyFlag;
    }

    public void resetPSV3MigrateId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateId();
            return;
        }
        this.psv3migrateidDirtyFlag = false;
        this.psv3migrateid = null;
    }

    public void setPSV3MigrateName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migratename = string;
        this.psv3migratenameDirtyFlag = true;
    }

    public String getPSV3MigrateName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateName();
        }
        return this.psv3migratename;
    }

    public boolean isPSV3MigrateNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateNameDirty();
        }
        return this.psv3migratenameDirtyFlag;
    }

    public void resetPSV3MigrateName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateName();
            return;
        }
        this.psv3migratenameDirtyFlag = false;
        this.psv3migratename = null;
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
        PSV3MGFormBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSV3MGFormBase pSV3MGFormBase) {
        pSV3MGFormBase.resetCreateDate();
        pSV3MGFormBase.resetCreateMan();
        pSV3MGFormBase.resetDEFORMID();
        pSV3MGFormBase.resetDEID();
        pSV3MGFormBase.resetDEName();
        pSV3MGFormBase.resetIgnoreFlag();
        pSV3MGFormBase.resetPSV3MGFormId();
        pSV3MGFormBase.resetPSV3MGFormName();
        pSV3MGFormBase.resetPSV3MigrateId();
        pSV3MGFormBase.resetPSV3MigrateName();
        pSV3MGFormBase.resetUpdateDate();
        pSV3MGFormBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEFORMIDDirty()) {
            hashMap.put(FIELD_DEFORMID, this.getDEFORMID());
        }
        if (!bl || this.isDEIDDirty()) {
            hashMap.put(FIELD_DEID, this.getDEID());
        }
        if (!bl || this.isDENameDirty()) {
            hashMap.put(FIELD_DENAME, this.getDEName());
        }
        if (!bl || this.isIgnoreFlagDirty()) {
            hashMap.put(FIELD_IGNOREFLAG, this.getIgnoreFlag());
        }
        if (!bl || this.isPSV3MGFormIdDirty()) {
            hashMap.put(FIELD_PSV3MGFORMID, this.getPSV3MGFormId());
        }
        if (!bl || this.isPSV3MGFormNameDirty()) {
            hashMap.put(FIELD_PSV3MGFORMNAME, this.getPSV3MGFormName());
        }
        if (!bl || this.isPSV3MigrateIdDirty()) {
            hashMap.put(FIELD_PSV3MIGRATEID, this.getPSV3MigrateId());
        }
        if (!bl || this.isPSV3MigrateNameDirty()) {
            hashMap.put(FIELD_PSV3MIGRATENAME, this.getPSV3MigrateName());
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
        return PSV3MGFormBase.get(this, n);
    }

    private static Object get(PSV3MGFormBase pSV3MGFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGFormBase.getCreateDate();
            }
            case 1: {
                return pSV3MGFormBase.getCreateMan();
            }
            case 2: {
                return pSV3MGFormBase.getDEFORMID();
            }
            case 3: {
                return pSV3MGFormBase.getDEID();
            }
            case 4: {
                return pSV3MGFormBase.getDEName();
            }
            case 5: {
                return pSV3MGFormBase.getIgnoreFlag();
            }
            case 6: {
                return pSV3MGFormBase.getPSV3MGFormId();
            }
            case 7: {
                return pSV3MGFormBase.getPSV3MGFormName();
            }
            case 8: {
                return pSV3MGFormBase.getPSV3MigrateId();
            }
            case 9: {
                return pSV3MGFormBase.getPSV3MigrateName();
            }
            case 10: {
                return pSV3MGFormBase.getUpdateDate();
            }
            case 11: {
                return pSV3MGFormBase.getUpdateMan();
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
        PSV3MGFormBase.set(this, n, object);
    }

    private static void set(PSV3MGFormBase pSV3MGFormBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGFormBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSV3MGFormBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSV3MGFormBase.setDEFORMID(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSV3MGFormBase.setDEID(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSV3MGFormBase.setDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSV3MGFormBase.setIgnoreFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSV3MGFormBase.setPSV3MGFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSV3MGFormBase.setPSV3MGFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSV3MGFormBase.setPSV3MigrateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSV3MGFormBase.setPSV3MigrateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSV3MGFormBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSV3MGFormBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSV3MGFormBase.isNull(this, n);
    }

    private static boolean isNull(PSV3MGFormBase pSV3MGFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGFormBase.getCreateDate() == null;
            }
            case 1: {
                return pSV3MGFormBase.getCreateMan() == null;
            }
            case 2: {
                return pSV3MGFormBase.getDEFORMID() == null;
            }
            case 3: {
                return pSV3MGFormBase.getDEID() == null;
            }
            case 4: {
                return pSV3MGFormBase.getDEName() == null;
            }
            case 5: {
                return pSV3MGFormBase.getIgnoreFlag() == null;
            }
            case 6: {
                return pSV3MGFormBase.getPSV3MGFormId() == null;
            }
            case 7: {
                return pSV3MGFormBase.getPSV3MGFormName() == null;
            }
            case 8: {
                return pSV3MGFormBase.getPSV3MigrateId() == null;
            }
            case 9: {
                return pSV3MGFormBase.getPSV3MigrateName() == null;
            }
            case 10: {
                return pSV3MGFormBase.getUpdateDate() == null;
            }
            case 11: {
                return pSV3MGFormBase.getUpdateMan() == null;
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
        return PSV3MGFormBase.contains(this, n);
    }

    private static boolean contains(PSV3MGFormBase pSV3MGFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGFormBase.isCreateDateDirty();
            }
            case 1: {
                return pSV3MGFormBase.isCreateManDirty();
            }
            case 2: {
                return pSV3MGFormBase.isDEFORMIDDirty();
            }
            case 3: {
                return pSV3MGFormBase.isDEIDDirty();
            }
            case 4: {
                return pSV3MGFormBase.isDENameDirty();
            }
            case 5: {
                return pSV3MGFormBase.isIgnoreFlagDirty();
            }
            case 6: {
                return pSV3MGFormBase.isPSV3MGFormIdDirty();
            }
            case 7: {
                return pSV3MGFormBase.isPSV3MGFormNameDirty();
            }
            case 8: {
                return pSV3MGFormBase.isPSV3MigrateIdDirty();
            }
            case 9: {
                return pSV3MGFormBase.isPSV3MigrateNameDirty();
            }
            case 10: {
                return pSV3MGFormBase.isUpdateDateDirty();
            }
            case 11: {
                return pSV3MGFormBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSV3MGFormBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSV3MGFormBase pSV3MGFormBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSV3MGFormBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getDEFORMID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deformid", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getDEFORMID()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getDEID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deid", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getDEID()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dename", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getDEName()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getIgnoreFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreflag", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getIgnoreFlag()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getPSV3MGFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mgformid", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getPSV3MGFormId()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getPSV3MGFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mgformname", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getPSV3MGFormName()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getPSV3MigrateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migrateid", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getPSV3MigrateId()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getPSV3MigrateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratename", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getPSV3MigrateName()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSV3MGFormBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSV3MGFormBase.getJSONValue((Object)pSV3MGFormBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSV3MGFormBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSV3MGFormBase pSV3MGFormBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSV3MGFormBase.getCreateDate() != null) {
            object = pSV3MGFormBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGFormBase.getCreateMan() != null) {
            object = pSV3MGFormBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getDEFORMID() != null) {
            object = pSV3MGFormBase.getDEFORMID();
            xmlNode.setAttribute(FIELD_DEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getDEID() != null) {
            object = pSV3MGFormBase.getDEID();
            xmlNode.setAttribute(FIELD_DEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getDEName() != null) {
            object = pSV3MGFormBase.getDEName();
            xmlNode.setAttribute(FIELD_DENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getIgnoreFlag() != null) {
            object = pSV3MGFormBase.getIgnoreFlag();
            xmlNode.setAttribute(FIELD_IGNOREFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSV3MGFormBase.getPSV3MGFormId() != null) {
            object = pSV3MGFormBase.getPSV3MGFormId();
            xmlNode.setAttribute(FIELD_PSV3MGFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getPSV3MGFormName() != null) {
            object = pSV3MGFormBase.getPSV3MGFormName();
            xmlNode.setAttribute(FIELD_PSV3MGFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getPSV3MigrateId() != null) {
            object = pSV3MGFormBase.getPSV3MigrateId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getPSV3MigrateName() != null) {
            object = pSV3MGFormBase.getPSV3MigrateName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGFormBase.getUpdateDate() != null) {
            object = pSV3MGFormBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGFormBase.getUpdateMan() != null) {
            object = pSV3MGFormBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSV3MGFormBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSV3MGFormBase pSV3MGFormBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSV3MGFormBase.isCreateDateDirty() && (bl || pSV3MGFormBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSV3MGFormBase.getCreateDate());
        }
        if (pSV3MGFormBase.isCreateManDirty() && (bl || pSV3MGFormBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSV3MGFormBase.getCreateMan());
        }
        if (pSV3MGFormBase.isDEFORMIDDirty() && (bl || pSV3MGFormBase.getDEFORMID() != null)) {
            iDataObject.set(FIELD_DEFORMID, (Object)pSV3MGFormBase.getDEFORMID());
        }
        if (pSV3MGFormBase.isDEIDDirty() && (bl || pSV3MGFormBase.getDEID() != null)) {
            iDataObject.set(FIELD_DEID, (Object)pSV3MGFormBase.getDEID());
        }
        if (pSV3MGFormBase.isDENameDirty() && (bl || pSV3MGFormBase.getDEName() != null)) {
            iDataObject.set(FIELD_DENAME, (Object)pSV3MGFormBase.getDEName());
        }
        if (pSV3MGFormBase.isIgnoreFlagDirty() && (bl || pSV3MGFormBase.getIgnoreFlag() != null)) {
            iDataObject.set(FIELD_IGNOREFLAG, (Object)pSV3MGFormBase.getIgnoreFlag());
        }
        if (pSV3MGFormBase.isPSV3MGFormIdDirty() && (bl || pSV3MGFormBase.getPSV3MGFormId() != null)) {
            iDataObject.set(FIELD_PSV3MGFORMID, (Object)pSV3MGFormBase.getPSV3MGFormId());
        }
        if (pSV3MGFormBase.isPSV3MGFormNameDirty() && (bl || pSV3MGFormBase.getPSV3MGFormName() != null)) {
            iDataObject.set(FIELD_PSV3MGFORMNAME, (Object)pSV3MGFormBase.getPSV3MGFormName());
        }
        if (pSV3MGFormBase.isPSV3MigrateIdDirty() && (bl || pSV3MGFormBase.getPSV3MigrateId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEID, (Object)pSV3MGFormBase.getPSV3MigrateId());
        }
        if (pSV3MGFormBase.isPSV3MigrateNameDirty() && (bl || pSV3MGFormBase.getPSV3MigrateName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATENAME, (Object)pSV3MGFormBase.getPSV3MigrateName());
        }
        if (pSV3MGFormBase.isUpdateDateDirty() && (bl || pSV3MGFormBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSV3MGFormBase.getUpdateDate());
        }
        if (pSV3MGFormBase.isUpdateManDirty() && (bl || pSV3MGFormBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSV3MGFormBase.getUpdateMan());
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
        return PSV3MGFormBase.remove(this, n);
    }

    private static boolean remove(PSV3MGFormBase pSV3MGFormBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGFormBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSV3MGFormBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSV3MGFormBase.resetDEFORMID();
                return true;
            }
            case 3: {
                pSV3MGFormBase.resetDEID();
                return true;
            }
            case 4: {
                pSV3MGFormBase.resetDEName();
                return true;
            }
            case 5: {
                pSV3MGFormBase.resetIgnoreFlag();
                return true;
            }
            case 6: {
                pSV3MGFormBase.resetPSV3MGFormId();
                return true;
            }
            case 7: {
                pSV3MGFormBase.resetPSV3MGFormName();
                return true;
            }
            case 8: {
                pSV3MGFormBase.resetPSV3MigrateId();
                return true;
            }
            case 9: {
                pSV3MGFormBase.resetPSV3MigrateName();
                return true;
            }
            case 10: {
                pSV3MGFormBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSV3MGFormBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSV3Migrate getPsv3migrate() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsv3migrate();
        }
        if (this.getPSV3MigrateId() == null) {
            return null;
        }
        Integer n = this.objPsv3migrateLock;
        synchronized (n) {
            if (this.psv3migrate != null && DataTypeHelper.compare((int)25, (Object)this.getPSV3MigrateId(), (Object)this.psv3migrate.getPSV3MigrateId()) != 0L) {
                this.psv3migrate = null;
            }
            if (this.psv3migrate == null) {
                PSV3Migrate pSV3Migrate = new PSV3Migrate();
                pSV3Migrate.setPSV3MigrateId(this.getPSV3MigrateId());
                PSV3MigrateService pSV3MigrateService = (PSV3MigrateService)ServiceGlobal.getService(PSV3MigrateService.class, (SessionFactory)this.getSessionFactory());
                pSV3MigrateService.autoGet((IEntity)pSV3Migrate);
                this.psv3migrate = pSV3Migrate;
            }
            return this.psv3migrate;
        }
    }

    private PSV3MGFormBase getProxyEntity() {
        return this.proxyPSV3MGFormBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSV3MGFormBase = null;
        if (iDataObject != null && iDataObject instanceof PSV3MGFormBase) {
            this.proxyPSV3MGFormBase = (PSV3MGFormBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MGFormService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEFORMID, 2);
        fieldIndexMap.put(FIELD_DEID, 3);
        fieldIndexMap.put(FIELD_DENAME, 4);
        fieldIndexMap.put(FIELD_IGNOREFLAG, 5);
        fieldIndexMap.put(FIELD_PSV3MGFORMID, 6);
        fieldIndexMap.put(FIELD_PSV3MGFORMNAME, 7);
        fieldIndexMap.put(FIELD_PSV3MIGRATEID, 8);
        fieldIndexMap.put(FIELD_PSV3MIGRATENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

