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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.def.entity.PSV3Migrate;
import net.ibizsys.pscore.srv.def.service.PSV3MigrateService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MigrateDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSV3MigrateDEBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEID = "DEID";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSV3MIGRATEDEID = "PSV3MIGRATEDEID";
    public static final String FIELD_PSV3MIGRATEDENAME = "PSV3MIGRATEDENAME";
    public static final String FIELD_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String FIELD_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEID = 2;
    private static final int INDEX_PSDEID = 3;
    private static final int INDEX_PSDENAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_PSV3MIGRATEDEID = 6;
    private static final int INDEX_PSV3MIGRATEDENAME = 7;
    private static final int INDEX_PSV3MIGRATEID = 8;
    private static final int INDEX_PSV3MIGRATENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSV3MigrateDEBase proxyPSV3MigrateDEBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean psv3migratedeidDirtyFlag = false;
    private boolean psv3migratedenameDirtyFlag = false;
    private boolean psv3migrateidDirtyFlag = false;
    private boolean psv3migratenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deid")
    private String deid;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="psv3migratedeid")
    private String psv3migratedeid;
    @Column(name="psv3migratedename")
    private String psv3migratedename;
    @Column(name="psv3migrateid")
    private String psv3migrateid;
    @Column(name="psv3migratename")
    private String psv3migratename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsdeLock = new Integer(1);
    private PSDataEntity psde = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setPSV3MigrateDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migratedeid = string;
        this.psv3migratedeidDirtyFlag = true;
    }

    public String getPSV3MigrateDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateDEId();
        }
        return this.psv3migratedeid;
    }

    public boolean isPSV3MigrateDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateDEIdDirty();
        }
        return this.psv3migratedeidDirtyFlag;
    }

    public void resetPSV3MigrateDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateDEId();
            return;
        }
        this.psv3migratedeidDirtyFlag = false;
        this.psv3migratedeid = null;
    }

    public void setPSV3MigrateDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSV3MigrateDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psv3migratedename = string;
        this.psv3migratedenameDirtyFlag = true;
    }

    public String getPSV3MigrateDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSV3MigrateDEName();
        }
        return this.psv3migratedename;
    }

    public boolean isPSV3MigrateDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSV3MigrateDENameDirty();
        }
        return this.psv3migratedenameDirtyFlag;
    }

    public void resetPSV3MigrateDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSV3MigrateDEName();
            return;
        }
        this.psv3migratedenameDirtyFlag = false;
        this.psv3migratedename = null;
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
        PSV3MigrateDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSV3MigrateDEBase pSV3MigrateDEBase) {
        pSV3MigrateDEBase.resetCreateDate();
        pSV3MigrateDEBase.resetCreateMan();
        pSV3MigrateDEBase.resetDEID();
        pSV3MigrateDEBase.resetPSDEId();
        pSV3MigrateDEBase.resetPSDEName();
        pSV3MigrateDEBase.resetPSSystemId();
        pSV3MigrateDEBase.resetPSV3MigrateDEId();
        pSV3MigrateDEBase.resetPSV3MigrateDEName();
        pSV3MigrateDEBase.resetPSV3MigrateId();
        pSV3MigrateDEBase.resetPSV3MigrateName();
        pSV3MigrateDEBase.resetUpdateDate();
        pSV3MigrateDEBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEIDDirty()) {
            hashMap.put(FIELD_DEID, this.getDEID());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSV3MigrateDEIdDirty()) {
            hashMap.put(FIELD_PSV3MIGRATEDEID, this.getPSV3MigrateDEId());
        }
        if (!bl || this.isPSV3MigrateDENameDirty()) {
            hashMap.put(FIELD_PSV3MIGRATEDENAME, this.getPSV3MigrateDEName());
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
        return PSV3MigrateDEBase.get(this, n);
    }

    private static Object get(PSV3MigrateDEBase pSV3MigrateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateDEBase.getCreateDate();
            }
            case 1: {
                return pSV3MigrateDEBase.getCreateMan();
            }
            case 2: {
                return pSV3MigrateDEBase.getDEID();
            }
            case 3: {
                return pSV3MigrateDEBase.getPSDEId();
            }
            case 4: {
                return pSV3MigrateDEBase.getPSDEName();
            }
            case 5: {
                return pSV3MigrateDEBase.getPSSystemId();
            }
            case 6: {
                return pSV3MigrateDEBase.getPSV3MigrateDEId();
            }
            case 7: {
                return pSV3MigrateDEBase.getPSV3MigrateDEName();
            }
            case 8: {
                return pSV3MigrateDEBase.getPSV3MigrateId();
            }
            case 9: {
                return pSV3MigrateDEBase.getPSV3MigrateName();
            }
            case 10: {
                return pSV3MigrateDEBase.getUpdateDate();
            }
            case 11: {
                return pSV3MigrateDEBase.getUpdateMan();
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
        PSV3MigrateDEBase.set(this, n, object);
    }

    private static void set(PSV3MigrateDEBase pSV3MigrateDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSV3MigrateDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSV3MigrateDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSV3MigrateDEBase.setDEID(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSV3MigrateDEBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSV3MigrateDEBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSV3MigrateDEBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSV3MigrateDEBase.setPSV3MigrateDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSV3MigrateDEBase.setPSV3MigrateDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSV3MigrateDEBase.setPSV3MigrateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSV3MigrateDEBase.setPSV3MigrateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSV3MigrateDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSV3MigrateDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSV3MigrateDEBase.isNull(this, n);
    }

    private static boolean isNull(PSV3MigrateDEBase pSV3MigrateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateDEBase.getCreateDate() == null;
            }
            case 1: {
                return pSV3MigrateDEBase.getCreateMan() == null;
            }
            case 2: {
                return pSV3MigrateDEBase.getDEID() == null;
            }
            case 3: {
                return pSV3MigrateDEBase.getPSDEId() == null;
            }
            case 4: {
                return pSV3MigrateDEBase.getPSDEName() == null;
            }
            case 5: {
                return pSV3MigrateDEBase.getPSSystemId() == null;
            }
            case 6: {
                return pSV3MigrateDEBase.getPSV3MigrateDEId() == null;
            }
            case 7: {
                return pSV3MigrateDEBase.getPSV3MigrateDEName() == null;
            }
            case 8: {
                return pSV3MigrateDEBase.getPSV3MigrateId() == null;
            }
            case 9: {
                return pSV3MigrateDEBase.getPSV3MigrateName() == null;
            }
            case 10: {
                return pSV3MigrateDEBase.getUpdateDate() == null;
            }
            case 11: {
                return pSV3MigrateDEBase.getUpdateMan() == null;
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
        return PSV3MigrateDEBase.contains(this, n);
    }

    private static boolean contains(PSV3MigrateDEBase pSV3MigrateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateDEBase.isCreateDateDirty();
            }
            case 1: {
                return pSV3MigrateDEBase.isCreateManDirty();
            }
            case 2: {
                return pSV3MigrateDEBase.isDEIDDirty();
            }
            case 3: {
                return pSV3MigrateDEBase.isPSDEIdDirty();
            }
            case 4: {
                return pSV3MigrateDEBase.isPSDENameDirty();
            }
            case 5: {
                return pSV3MigrateDEBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSV3MigrateDEBase.isPSV3MigrateDEIdDirty();
            }
            case 7: {
                return pSV3MigrateDEBase.isPSV3MigrateDENameDirty();
            }
            case 8: {
                return pSV3MigrateDEBase.isPSV3MigrateIdDirty();
            }
            case 9: {
                return pSV3MigrateDEBase.isPSV3MigrateNameDirty();
            }
            case 10: {
                return pSV3MigrateDEBase.isUpdateDateDirty();
            }
            case 11: {
                return pSV3MigrateDEBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSV3MigrateDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSV3MigrateDEBase pSV3MigrateDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSV3MigrateDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getDEID() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deid", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getDEID()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratedeid", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSV3MigrateDEId()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratedename", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSV3MigrateDEName()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migrateid", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSV3MigrateId()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratename", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getPSV3MigrateName()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSV3MigrateDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSV3MigrateDEBase.getJSONValue((Object)pSV3MigrateDEBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSV3MigrateDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSV3MigrateDEBase pSV3MigrateDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSV3MigrateDEBase.getCreateDate() != null) {
            object = pSV3MigrateDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MigrateDEBase.getCreateMan() != null) {
            object = pSV3MigrateDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getDEID() != null) {
            object = pSV3MigrateDEBase.getDEID();
            xmlNode.setAttribute(FIELD_DEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSDEId() != null) {
            object = pSV3MigrateDEBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSDEName() != null) {
            object = pSV3MigrateDEBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSSystemId() != null) {
            object = pSV3MigrateDEBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateDEId() != null) {
            object = pSV3MigrateDEBase.getPSV3MigrateDEId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEDEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateDEName() != null) {
            object = pSV3MigrateDEBase.getPSV3MigrateDEName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateId() != null) {
            object = pSV3MigrateDEBase.getPSV3MigrateId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getPSV3MigrateName() != null) {
            object = pSV3MigrateDEBase.getPSV3MigrateName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateDEBase.getUpdateDate() != null) {
            object = pSV3MigrateDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MigrateDEBase.getUpdateMan() != null) {
            object = pSV3MigrateDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSV3MigrateDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSV3MigrateDEBase pSV3MigrateDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSV3MigrateDEBase.isCreateDateDirty() && (bl || pSV3MigrateDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSV3MigrateDEBase.getCreateDate());
        }
        if (pSV3MigrateDEBase.isCreateManDirty() && (bl || pSV3MigrateDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSV3MigrateDEBase.getCreateMan());
        }
        if (pSV3MigrateDEBase.isDEIDDirty() && (bl || pSV3MigrateDEBase.getDEID() != null)) {
            iDataObject.set(FIELD_DEID, (Object)pSV3MigrateDEBase.getDEID());
        }
        if (pSV3MigrateDEBase.isPSDEIdDirty() && (bl || pSV3MigrateDEBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSV3MigrateDEBase.getPSDEId());
        }
        if (pSV3MigrateDEBase.isPSDENameDirty() && (bl || pSV3MigrateDEBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSV3MigrateDEBase.getPSDEName());
        }
        if (pSV3MigrateDEBase.isPSSystemIdDirty() && (bl || pSV3MigrateDEBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSV3MigrateDEBase.getPSSystemId());
        }
        if (pSV3MigrateDEBase.isPSV3MigrateDEIdDirty() && (bl || pSV3MigrateDEBase.getPSV3MigrateDEId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEDEID, (Object)pSV3MigrateDEBase.getPSV3MigrateDEId());
        }
        if (pSV3MigrateDEBase.isPSV3MigrateDENameDirty() && (bl || pSV3MigrateDEBase.getPSV3MigrateDEName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEDENAME, (Object)pSV3MigrateDEBase.getPSV3MigrateDEName());
        }
        if (pSV3MigrateDEBase.isPSV3MigrateIdDirty() && (bl || pSV3MigrateDEBase.getPSV3MigrateId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEID, (Object)pSV3MigrateDEBase.getPSV3MigrateId());
        }
        if (pSV3MigrateDEBase.isPSV3MigrateNameDirty() && (bl || pSV3MigrateDEBase.getPSV3MigrateName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATENAME, (Object)pSV3MigrateDEBase.getPSV3MigrateName());
        }
        if (pSV3MigrateDEBase.isUpdateDateDirty() && (bl || pSV3MigrateDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSV3MigrateDEBase.getUpdateDate());
        }
        if (pSV3MigrateDEBase.isUpdateManDirty() && (bl || pSV3MigrateDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSV3MigrateDEBase.getUpdateMan());
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
        return PSV3MigrateDEBase.remove(this, n);
    }

    private static boolean remove(PSV3MigrateDEBase pSV3MigrateDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSV3MigrateDEBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSV3MigrateDEBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSV3MigrateDEBase.resetDEID();
                return true;
            }
            case 3: {
                pSV3MigrateDEBase.resetPSDEId();
                return true;
            }
            case 4: {
                pSV3MigrateDEBase.resetPSDEName();
                return true;
            }
            case 5: {
                pSV3MigrateDEBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSV3MigrateDEBase.resetPSV3MigrateDEId();
                return true;
            }
            case 7: {
                pSV3MigrateDEBase.resetPSV3MigrateDEName();
                return true;
            }
            case 8: {
                pSV3MigrateDEBase.resetPSV3MigrateId();
                return true;
            }
            case 9: {
                pSV3MigrateDEBase.resetPSV3MigrateName();
                return true;
            }
            case 10: {
                pSV3MigrateDEBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSV3MigrateDEBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPsde() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsde();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPsdeLock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
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

    private PSV3MigrateDEBase getProxyEntity() {
        return this.proxyPSV3MigrateDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSV3MigrateDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSV3MigrateDEBase) {
            this.proxyPSV3MigrateDEBase = (PSV3MigrateDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MigrateDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEID, 2);
        fieldIndexMap.put(FIELD_PSDEID, 3);
        fieldIndexMap.put(FIELD_PSDENAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_PSV3MIGRATEDEID, 6);
        fieldIndexMap.put(FIELD_PSV3MIGRATEDENAME, 7);
        fieldIndexMap.put(FIELD_PSV3MIGRATEID, 8);
        fieldIndexMap.put(FIELD_PSV3MIGRATENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

