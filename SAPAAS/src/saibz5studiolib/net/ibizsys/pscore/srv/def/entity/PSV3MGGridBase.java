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

public abstract class PSV3MGGridBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSV3MGGridBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEGRIDID = "DEGRIDID";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_DENAME = "DENAME";
    public static final String FIELD_IGNOREFLAG = "IGNOREFLAG";
    public static final String FIELD_PSV3MGGRIDID = "PSV3MGGRIDID";
    public static final String FIELD_PSV3MGGRIDNAME = "PSV3MGGRIDNAME";
    public static final String FIELD_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String FIELD_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEGRIDID = 2;
    private static final int INDEX_DEID = 3;
    private static final int INDEX_DENAME = 4;
    private static final int INDEX_IGNOREFLAG = 5;
    private static final int INDEX_PSV3MGGRIDID = 6;
    private static final int INDEX_PSV3MGGRIDNAME = 7;
    private static final int INDEX_PSV3MIGRATEID = 8;
    private static final int INDEX_PSV3MIGRATENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSV3MGGridBase proxyPSV3MGGridBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean degrididDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean denameDirtyFlag = false;
    private boolean ignoreflagDirtyFlag = false;
    private boolean psv3mggrididDirtyFlag = false;
    private boolean psv3mggridnameDirtyFlag = false;
    private boolean psv3migrateidDirtyFlag = false;
    private boolean psv3migratenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="degridid")
    private String degridid;
    @Column(name="deid")
    private String deid;
    @Column(name="dename")
    private String dename;
    @Column(name="ignoreflag")
    private Integer ignoreflag;
    @Column(name="psv3mggridid")
    private String psv3mggridid;
    @Column(name="psv3mggridname")
    private String psv3mggridname;
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

    public void setDEGRIDID(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEGRIDID(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.degridid = string;
        this.degrididDirtyFlag = true;
    }

    public String getDEGRIDID() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEGRIDID();
        }
        return this.degridid;
    }

    public boolean isDEGRIDIDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEGRIDIDDirty();
        }
        return this.degrididDirtyFlag;
    }

    public void resetDEGRIDID() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEGRIDID();
            return;
        }
        this.degrididDirtyFlag = false;
        this.degridid = null;
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

    public void setPSV3MGGridId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGGridId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mggridid = string;
        this.psv3mggrididDirtyFlag = true;
    }

    public String getPSV3MGGridId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGGridId();
        }
        return this.psv3mggridid;
    }

    public boolean isPSV3MGGridIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGGridIdDirty();
        }
        return this.psv3mggrididDirtyFlag;
    }

    public void resetPSV3MGGridId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGGridId();
            return;
        }
        this.psv3mggrididDirtyFlag = false;
        this.psv3mggridid = null;
    }

    public void setPSV3MGGridName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MGGridName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3mggridname = string;
        this.psv3mggridnameDirtyFlag = true;
    }

    public String getPSV3MGGridName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MGGridName();
        }
        return this.psv3mggridname;
    }

    public boolean isPSV3MGGridNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MGGridNameDirty();
        }
        return this.psv3mggridnameDirtyFlag;
    }

    public void resetPSV3MGGridName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MGGridName();
            return;
        }
        this.psv3mggridnameDirtyFlag = false;
        this.psv3mggridname = null;
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
        PSV3MGGridBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSV3MGGridBase pSV3MGGridBase) {
        pSV3MGGridBase.resetCreateDate();
        pSV3MGGridBase.resetCreateMan();
        pSV3MGGridBase.resetDEGRIDID();
        pSV3MGGridBase.resetDEID();
        pSV3MGGridBase.resetDEName();
        pSV3MGGridBase.resetIgnoreFlag();
        pSV3MGGridBase.resetPSV3MGGridId();
        pSV3MGGridBase.resetPSV3MGGridName();
        pSV3MGGridBase.resetPSV3MigrateId();
        pSV3MGGridBase.resetPSV3MigrateName();
        pSV3MGGridBase.resetUpdateDate();
        pSV3MGGridBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEGRIDIDDirty()) {
            hashMap.put(FIELD_DEGRIDID, this.getDEGRIDID());
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
        if (!bl || this.isPSV3MGGridIdDirty()) {
            hashMap.put(FIELD_PSV3MGGRIDID, this.getPSV3MGGridId());
        }
        if (!bl || this.isPSV3MGGridNameDirty()) {
            hashMap.put(FIELD_PSV3MGGRIDNAME, this.getPSV3MGGridName());
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
        return PSV3MGGridBase.get(this, n);
    }

    private static Object get(PSV3MGGridBase pSV3MGGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGGridBase.getCreateDate();
            }
            case 1: {
                return pSV3MGGridBase.getCreateMan();
            }
            case 2: {
                return pSV3MGGridBase.getDEGRIDID();
            }
            case 3: {
                return pSV3MGGridBase.getDEID();
            }
            case 4: {
                return pSV3MGGridBase.getDEName();
            }
            case 5: {
                return pSV3MGGridBase.getIgnoreFlag();
            }
            case 6: {
                return pSV3MGGridBase.getPSV3MGGridId();
            }
            case 7: {
                return pSV3MGGridBase.getPSV3MGGridName();
            }
            case 8: {
                return pSV3MGGridBase.getPSV3MigrateId();
            }
            case 9: {
                return pSV3MGGridBase.getPSV3MigrateName();
            }
            case 10: {
                return pSV3MGGridBase.getUpdateDate();
            }
            case 11: {
                return pSV3MGGridBase.getUpdateMan();
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
        PSV3MGGridBase.set(this, n, object);
    }

    private static void set(PSV3MGGridBase pSV3MGGridBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGGridBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSV3MGGridBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSV3MGGridBase.setDEGRIDID(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSV3MGGridBase.setDEID(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSV3MGGridBase.setDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSV3MGGridBase.setIgnoreFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSV3MGGridBase.setPSV3MGGridId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSV3MGGridBase.setPSV3MGGridName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSV3MGGridBase.setPSV3MigrateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSV3MGGridBase.setPSV3MigrateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSV3MGGridBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSV3MGGridBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSV3MGGridBase.isNull(this, n);
    }

    private static boolean isNull(PSV3MGGridBase pSV3MGGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGGridBase.getCreateDate() == null;
            }
            case 1: {
                return pSV3MGGridBase.getCreateMan() == null;
            }
            case 2: {
                return pSV3MGGridBase.getDEGRIDID() == null;
            }
            case 3: {
                return pSV3MGGridBase.getDEID() == null;
            }
            case 4: {
                return pSV3MGGridBase.getDEName() == null;
            }
            case 5: {
                return pSV3MGGridBase.getIgnoreFlag() == null;
            }
            case 6: {
                return pSV3MGGridBase.getPSV3MGGridId() == null;
            }
            case 7: {
                return pSV3MGGridBase.getPSV3MGGridName() == null;
            }
            case 8: {
                return pSV3MGGridBase.getPSV3MigrateId() == null;
            }
            case 9: {
                return pSV3MGGridBase.getPSV3MigrateName() == null;
            }
            case 10: {
                return pSV3MGGridBase.getUpdateDate() == null;
            }
            case 11: {
                return pSV3MGGridBase.getUpdateMan() == null;
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
        return PSV3MGGridBase.contains(this, n);
    }

    private static boolean contains(PSV3MGGridBase pSV3MGGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MGGridBase.isCreateDateDirty();
            }
            case 1: {
                return pSV3MGGridBase.isCreateManDirty();
            }
            case 2: {
                return pSV3MGGridBase.isDEGRIDIDDirty();
            }
            case 3: {
                return pSV3MGGridBase.isDEIDDirty();
            }
            case 4: {
                return pSV3MGGridBase.isDENameDirty();
            }
            case 5: {
                return pSV3MGGridBase.isIgnoreFlagDirty();
            }
            case 6: {
                return pSV3MGGridBase.isPSV3MGGridIdDirty();
            }
            case 7: {
                return pSV3MGGridBase.isPSV3MGGridNameDirty();
            }
            case 8: {
                return pSV3MGGridBase.isPSV3MigrateIdDirty();
            }
            case 9: {
                return pSV3MGGridBase.isPSV3MigrateNameDirty();
            }
            case 10: {
                return pSV3MGGridBase.isUpdateDateDirty();
            }
            case 11: {
                return pSV3MGGridBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSV3MGGridBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSV3MGGridBase pSV3MGGridBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSV3MGGridBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getDEGRIDID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"degridid", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getDEGRIDID()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getDEID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deid", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getDEID()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dename", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getDEName()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getIgnoreFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ignoreflag", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getIgnoreFlag()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getPSV3MGGridId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mggridid", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getPSV3MGGridId()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getPSV3MGGridName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3mggridname", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getPSV3MGGridName()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getPSV3MigrateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migrateid", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getPSV3MigrateId()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getPSV3MigrateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratename", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getPSV3MigrateName()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSV3MGGridBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSV3MGGridBase.getJSONValue((Object)pSV3MGGridBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSV3MGGridBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSV3MGGridBase pSV3MGGridBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSV3MGGridBase.getCreateDate() != null) {
            object = pSV3MGGridBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGGridBase.getCreateMan() != null) {
            object = pSV3MGGridBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getDEGRIDID() != null) {
            object = pSV3MGGridBase.getDEGRIDID();
            xmlNode.setAttribute(FIELD_DEGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getDEID() != null) {
            object = pSV3MGGridBase.getDEID();
            xmlNode.setAttribute(FIELD_DEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getDEName() != null) {
            object = pSV3MGGridBase.getDEName();
            xmlNode.setAttribute(FIELD_DENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getIgnoreFlag() != null) {
            object = pSV3MGGridBase.getIgnoreFlag();
            xmlNode.setAttribute(FIELD_IGNOREFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSV3MGGridBase.getPSV3MGGridId() != null) {
            object = pSV3MGGridBase.getPSV3MGGridId();
            xmlNode.setAttribute(FIELD_PSV3MGGRIDID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getPSV3MGGridName() != null) {
            object = pSV3MGGridBase.getPSV3MGGridName();
            xmlNode.setAttribute(FIELD_PSV3MGGRIDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getPSV3MigrateId() != null) {
            object = pSV3MGGridBase.getPSV3MigrateId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getPSV3MigrateName() != null) {
            object = pSV3MGGridBase.getPSV3MigrateName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MGGridBase.getUpdateDate() != null) {
            object = pSV3MGGridBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MGGridBase.getUpdateMan() != null) {
            object = pSV3MGGridBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSV3MGGridBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSV3MGGridBase pSV3MGGridBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSV3MGGridBase.isCreateDateDirty() && (bl || pSV3MGGridBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSV3MGGridBase.getCreateDate());
        }
        if (pSV3MGGridBase.isCreateManDirty() && (bl || pSV3MGGridBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSV3MGGridBase.getCreateMan());
        }
        if (pSV3MGGridBase.isDEGRIDIDDirty() && (bl || pSV3MGGridBase.getDEGRIDID() != null)) {
            iDataObject.set(FIELD_DEGRIDID, (Object)pSV3MGGridBase.getDEGRIDID());
        }
        if (pSV3MGGridBase.isDEIDDirty() && (bl || pSV3MGGridBase.getDEID() != null)) {
            iDataObject.set(FIELD_DEID, (Object)pSV3MGGridBase.getDEID());
        }
        if (pSV3MGGridBase.isDENameDirty() && (bl || pSV3MGGridBase.getDEName() != null)) {
            iDataObject.set(FIELD_DENAME, (Object)pSV3MGGridBase.getDEName());
        }
        if (pSV3MGGridBase.isIgnoreFlagDirty() && (bl || pSV3MGGridBase.getIgnoreFlag() != null)) {
            iDataObject.set(FIELD_IGNOREFLAG, (Object)pSV3MGGridBase.getIgnoreFlag());
        }
        if (pSV3MGGridBase.isPSV3MGGridIdDirty() && (bl || pSV3MGGridBase.getPSV3MGGridId() != null)) {
            iDataObject.set(FIELD_PSV3MGGRIDID, (Object)pSV3MGGridBase.getPSV3MGGridId());
        }
        if (pSV3MGGridBase.isPSV3MGGridNameDirty() && (bl || pSV3MGGridBase.getPSV3MGGridName() != null)) {
            iDataObject.set(FIELD_PSV3MGGRIDNAME, (Object)pSV3MGGridBase.getPSV3MGGridName());
        }
        if (pSV3MGGridBase.isPSV3MigrateIdDirty() && (bl || pSV3MGGridBase.getPSV3MigrateId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEID, (Object)pSV3MGGridBase.getPSV3MigrateId());
        }
        if (pSV3MGGridBase.isPSV3MigrateNameDirty() && (bl || pSV3MGGridBase.getPSV3MigrateName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATENAME, (Object)pSV3MGGridBase.getPSV3MigrateName());
        }
        if (pSV3MGGridBase.isUpdateDateDirty() && (bl || pSV3MGGridBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSV3MGGridBase.getUpdateDate());
        }
        if (pSV3MGGridBase.isUpdateManDirty() && (bl || pSV3MGGridBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSV3MGGridBase.getUpdateMan());
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
        return PSV3MGGridBase.remove(this, n);
    }

    private static boolean remove(PSV3MGGridBase pSV3MGGridBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSV3MGGridBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSV3MGGridBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSV3MGGridBase.resetDEGRIDID();
                return true;
            }
            case 3: {
                pSV3MGGridBase.resetDEID();
                return true;
            }
            case 4: {
                pSV3MGGridBase.resetDEName();
                return true;
            }
            case 5: {
                pSV3MGGridBase.resetIgnoreFlag();
                return true;
            }
            case 6: {
                pSV3MGGridBase.resetPSV3MGGridId();
                return true;
            }
            case 7: {
                pSV3MGGridBase.resetPSV3MGGridName();
                return true;
            }
            case 8: {
                pSV3MGGridBase.resetPSV3MigrateId();
                return true;
            }
            case 9: {
                pSV3MGGridBase.resetPSV3MigrateName();
                return true;
            }
            case 10: {
                pSV3MGGridBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSV3MGGridBase.resetUpdateMan();
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

    private PSV3MGGridBase getProxyEntity() {
        return this.proxyPSV3MGGridBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSV3MGGridBase = null;
        if (iDataObject != null && iDataObject instanceof PSV3MGGridBase) {
            this.proxyPSV3MGGridBase = (PSV3MGGridBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MGGridService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEGRIDID, 2);
        fieldIndexMap.put(FIELD_DEID, 3);
        fieldIndexMap.put(FIELD_DENAME, 4);
        fieldIndexMap.put(FIELD_IGNOREFLAG, 5);
        fieldIndexMap.put(FIELD_PSV3MGGRIDID, 6);
        fieldIndexMap.put(FIELD_PSV3MGGRIDNAME, 7);
        fieldIndexMap.put(FIELD_PSV3MIGRATEID, 8);
        fieldIndexMap.put(FIELD_PSV3MIGRATENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

