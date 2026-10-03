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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSV3MigrateBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSV3MigrateBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEIDPREFIX = "DEIDPREFIX";
    public static final String FIELD_DENAMEPREFIX = "DENAMEPREFIX";
    public static final String FIELD_EXCLUDEIDS = "EXCLUDEIDS";
    public static final String FIELD_EXCLUDENAMES = "EXCLUDENAMES";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSV3MIGRATEID = "PSV3MIGRATEID";
    public static final String FIELD_PSV3MIGRATENAME = "PSV3MIGRATENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEIDPREFIX = 2;
    private static final int INDEX_DENAMEPREFIX = 3;
    private static final int INDEX_EXCLUDEIDS = 4;
    private static final int INDEX_EXCLUDENAMES = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSMODULEID = 7;
    private static final int INDEX_PSMODULENAME = 8;
    private static final int INDEX_PSSYSTEMID = 9;
    private static final int INDEX_PSSYSTEMNAME = 10;
    private static final int INDEX_PSV3MIGRATEID = 11;
    private static final int INDEX_PSV3MIGRATENAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSV3MigrateBase proxyPSV3MigrateBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deidprefixDirtyFlag = false;
    private boolean denameprefixDirtyFlag = false;
    private boolean excludeidsDirtyFlag = false;
    private boolean excludenamesDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean psv3migrateidDirtyFlag = false;
    private boolean psv3migratenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deidprefix")
    private String deidprefix;
    @Column(name="denameprefix")
    private String denameprefix;
    @Column(name="excludeids")
    private String excludeids;
    @Column(name="excludenames")
    private String excludenames;
    @Column(name="memo")
    private String memo;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="psv3migrateid")
    private String psv3migrateid;
    @Column(name="psv3migratename")
    private String psv3migratename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsmoduleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPssystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setDEIDPREFIX(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEIDPREFIX(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deidprefix = string;
        this.deidprefixDirtyFlag = true;
    }

    public String getDEIDPREFIX() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEIDPREFIX();
        }
        return this.deidprefix;
    }

    public boolean isDEIDPREFIXDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEIDPREFIXDirty();
        }
        return this.deidprefixDirtyFlag;
    }

    public void resetDEIDPREFIX() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEIDPREFIX();
            return;
        }
        this.deidprefixDirtyFlag = false;
        this.deidprefix = null;
    }

    public void setDENamePREFIX(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDENamePREFIX(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.denameprefix = string;
        this.denameprefixDirtyFlag = true;
    }

    public String getDENamePREFIX() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDENamePREFIX();
        }
        return this.denameprefix;
    }

    public boolean isDENamePREFIXDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDENamePREFIXDirty();
        }
        return this.denameprefixDirtyFlag;
    }

    public void resetDENamePREFIX() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDENamePREFIX();
            return;
        }
        this.denameprefixDirtyFlag = false;
        this.denameprefix = null;
    }

    public void setExcludeIDS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExcludeIDS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.excludeids = string;
        this.excludeidsDirtyFlag = true;
    }

    public String getExcludeIDS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExcludeIDS();
        }
        return this.excludeids;
    }

    public boolean isExcludeIDSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExcludeIDSDirty();
        }
        return this.excludeidsDirtyFlag;
    }

    public void resetExcludeIDS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExcludeIDS();
            return;
        }
        this.excludeidsDirtyFlag = false;
        this.excludeids = null;
    }

    public void setExcludeNameS(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExcludeNameS(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.excludenames = string;
        this.excludenamesDirtyFlag = true;
    }

    public String getExcludeNameS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExcludeNameS();
        }
        return this.excludenames;
    }

    public boolean isExcludeNameSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExcludeNameSDirty();
        }
        return this.excludenamesDirtyFlag;
    }

    public void resetExcludeNameS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExcludeNameS();
            return;
        }
        this.excludenamesDirtyFlag = false;
        this.excludenames = null;
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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
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
        PSV3MigrateBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSV3MigrateBase pSV3MigrateBase) {
        pSV3MigrateBase.resetCreateDate();
        pSV3MigrateBase.resetCreateMan();
        pSV3MigrateBase.resetDEIDPREFIX();
        pSV3MigrateBase.resetDENamePREFIX();
        pSV3MigrateBase.resetExcludeIDS();
        pSV3MigrateBase.resetExcludeNameS();
        pSV3MigrateBase.resetMemo();
        pSV3MigrateBase.resetPSModuleId();
        pSV3MigrateBase.resetPSModuleName();
        pSV3MigrateBase.resetPSSystemId();
        pSV3MigrateBase.resetPSSystemName();
        pSV3MigrateBase.resetPSV3MigrateId();
        pSV3MigrateBase.resetPSV3MigrateName();
        pSV3MigrateBase.resetUpdateDate();
        pSV3MigrateBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEIDPREFIXDirty()) {
            hashMap.put(FIELD_DEIDPREFIX, this.getDEIDPREFIX());
        }
        if (!bl || this.isDENamePREFIXDirty()) {
            hashMap.put(FIELD_DENAMEPREFIX, this.getDENamePREFIX());
        }
        if (!bl || this.isExcludeIDSDirty()) {
            hashMap.put(FIELD_EXCLUDEIDS, this.getExcludeIDS());
        }
        if (!bl || this.isExcludeNameSDirty()) {
            hashMap.put(FIELD_EXCLUDENAMES, this.getExcludeNameS());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSV3MigrateBase.get(this, n);
    }

    private static Object get(PSV3MigrateBase pSV3MigrateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateBase.getCreateDate();
            }
            case 1: {
                return pSV3MigrateBase.getCreateMan();
            }
            case 2: {
                return pSV3MigrateBase.getDEIDPREFIX();
            }
            case 3: {
                return pSV3MigrateBase.getDENamePREFIX();
            }
            case 4: {
                return pSV3MigrateBase.getExcludeIDS();
            }
            case 5: {
                return pSV3MigrateBase.getExcludeNameS();
            }
            case 6: {
                return pSV3MigrateBase.getMemo();
            }
            case 7: {
                return pSV3MigrateBase.getPSModuleId();
            }
            case 8: {
                return pSV3MigrateBase.getPSModuleName();
            }
            case 9: {
                return pSV3MigrateBase.getPSSystemId();
            }
            case 10: {
                return pSV3MigrateBase.getPSSystemName();
            }
            case 11: {
                return pSV3MigrateBase.getPSV3MigrateId();
            }
            case 12: {
                return pSV3MigrateBase.getPSV3MigrateName();
            }
            case 13: {
                return pSV3MigrateBase.getUpdateDate();
            }
            case 14: {
                return pSV3MigrateBase.getUpdateMan();
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
        PSV3MigrateBase.set(this, n, object);
    }

    private static void set(PSV3MigrateBase pSV3MigrateBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSV3MigrateBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSV3MigrateBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSV3MigrateBase.setDEIDPREFIX(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSV3MigrateBase.setDENamePREFIX(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSV3MigrateBase.setExcludeIDS(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSV3MigrateBase.setExcludeNameS(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSV3MigrateBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSV3MigrateBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSV3MigrateBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSV3MigrateBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSV3MigrateBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSV3MigrateBase.setPSV3MigrateId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSV3MigrateBase.setPSV3MigrateName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSV3MigrateBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSV3MigrateBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSV3MigrateBase.isNull(this, n);
    }

    private static boolean isNull(PSV3MigrateBase pSV3MigrateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateBase.getCreateDate() == null;
            }
            case 1: {
                return pSV3MigrateBase.getCreateMan() == null;
            }
            case 2: {
                return pSV3MigrateBase.getDEIDPREFIX() == null;
            }
            case 3: {
                return pSV3MigrateBase.getDENamePREFIX() == null;
            }
            case 4: {
                return pSV3MigrateBase.getExcludeIDS() == null;
            }
            case 5: {
                return pSV3MigrateBase.getExcludeNameS() == null;
            }
            case 6: {
                return pSV3MigrateBase.getMemo() == null;
            }
            case 7: {
                return pSV3MigrateBase.getPSModuleId() == null;
            }
            case 8: {
                return pSV3MigrateBase.getPSModuleName() == null;
            }
            case 9: {
                return pSV3MigrateBase.getPSSystemId() == null;
            }
            case 10: {
                return pSV3MigrateBase.getPSSystemName() == null;
            }
            case 11: {
                return pSV3MigrateBase.getPSV3MigrateId() == null;
            }
            case 12: {
                return pSV3MigrateBase.getPSV3MigrateName() == null;
            }
            case 13: {
                return pSV3MigrateBase.getUpdateDate() == null;
            }
            case 14: {
                return pSV3MigrateBase.getUpdateMan() == null;
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
        return PSV3MigrateBase.contains(this, n);
    }

    private static boolean contains(PSV3MigrateBase pSV3MigrateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSV3MigrateBase.isCreateDateDirty();
            }
            case 1: {
                return pSV3MigrateBase.isCreateManDirty();
            }
            case 2: {
                return pSV3MigrateBase.isDEIDPREFIXDirty();
            }
            case 3: {
                return pSV3MigrateBase.isDENamePREFIXDirty();
            }
            case 4: {
                return pSV3MigrateBase.isExcludeIDSDirty();
            }
            case 5: {
                return pSV3MigrateBase.isExcludeNameSDirty();
            }
            case 6: {
                return pSV3MigrateBase.isMemoDirty();
            }
            case 7: {
                return pSV3MigrateBase.isPSModuleIdDirty();
            }
            case 8: {
                return pSV3MigrateBase.isPSModuleNameDirty();
            }
            case 9: {
                return pSV3MigrateBase.isPSSystemIdDirty();
            }
            case 10: {
                return pSV3MigrateBase.isPSSystemNameDirty();
            }
            case 11: {
                return pSV3MigrateBase.isPSV3MigrateIdDirty();
            }
            case 12: {
                return pSV3MigrateBase.isPSV3MigrateNameDirty();
            }
            case 13: {
                return pSV3MigrateBase.isUpdateDateDirty();
            }
            case 14: {
                return pSV3MigrateBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSV3MigrateBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSV3MigrateBase pSV3MigrateBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSV3MigrateBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getDEIDPREFIX() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deidprefix", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getDEIDPREFIX()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getDENamePREFIX() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"denameprefix", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getDENamePREFIX()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getExcludeIDS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"excludeids", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getExcludeIDS()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getExcludeNameS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"excludenames", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getExcludeNameS()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getMemo()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSV3MigrateId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migrateid", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSV3MigrateId()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getPSV3MigrateName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psv3migratename", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getPSV3MigrateName()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSV3MigrateBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSV3MigrateBase.getJSONValue((Object)pSV3MigrateBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSV3MigrateBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSV3MigrateBase pSV3MigrateBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSV3MigrateBase.getCreateDate() != null) {
            object = pSV3MigrateBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MigrateBase.getCreateMan() != null) {
            object = pSV3MigrateBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getDEIDPREFIX() != null) {
            object = pSV3MigrateBase.getDEIDPREFIX();
            xmlNode.setAttribute(FIELD_DEIDPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getDENamePREFIX() != null) {
            object = pSV3MigrateBase.getDENamePREFIX();
            xmlNode.setAttribute(FIELD_DENAMEPREFIX, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getExcludeIDS() != null) {
            object = pSV3MigrateBase.getExcludeIDS();
            xmlNode.setAttribute(FIELD_EXCLUDEIDS, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getExcludeNameS() != null) {
            object = pSV3MigrateBase.getExcludeNameS();
            xmlNode.setAttribute(FIELD_EXCLUDENAMES, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getMemo() != null) {
            object = pSV3MigrateBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSModuleId() != null) {
            object = pSV3MigrateBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSModuleName() != null) {
            object = pSV3MigrateBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSSystemId() != null) {
            object = pSV3MigrateBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSSystemName() != null) {
            object = pSV3MigrateBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSV3MigrateId() != null) {
            object = pSV3MigrateBase.getPSV3MigrateId();
            xmlNode.setAttribute(FIELD_PSV3MIGRATEID, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getPSV3MigrateName() != null) {
            object = pSV3MigrateBase.getPSV3MigrateName();
            xmlNode.setAttribute(FIELD_PSV3MIGRATENAME, object == null ? "" : (String)object);
        }
        if (bl || pSV3MigrateBase.getUpdateDate() != null) {
            object = pSV3MigrateBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSV3MigrateBase.getUpdateMan() != null) {
            object = pSV3MigrateBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSV3MigrateBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSV3MigrateBase pSV3MigrateBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSV3MigrateBase.isCreateDateDirty() && (bl || pSV3MigrateBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSV3MigrateBase.getCreateDate());
        }
        if (pSV3MigrateBase.isCreateManDirty() && (bl || pSV3MigrateBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSV3MigrateBase.getCreateMan());
        }
        if (pSV3MigrateBase.isDEIDPREFIXDirty() && (bl || pSV3MigrateBase.getDEIDPREFIX() != null)) {
            iDataObject.set(FIELD_DEIDPREFIX, (Object)pSV3MigrateBase.getDEIDPREFIX());
        }
        if (pSV3MigrateBase.isDENamePREFIXDirty() && (bl || pSV3MigrateBase.getDENamePREFIX() != null)) {
            iDataObject.set(FIELD_DENAMEPREFIX, (Object)pSV3MigrateBase.getDENamePREFIX());
        }
        if (pSV3MigrateBase.isExcludeIDSDirty() && (bl || pSV3MigrateBase.getExcludeIDS() != null)) {
            iDataObject.set(FIELD_EXCLUDEIDS, (Object)pSV3MigrateBase.getExcludeIDS());
        }
        if (pSV3MigrateBase.isExcludeNameSDirty() && (bl || pSV3MigrateBase.getExcludeNameS() != null)) {
            iDataObject.set(FIELD_EXCLUDENAMES, (Object)pSV3MigrateBase.getExcludeNameS());
        }
        if (pSV3MigrateBase.isMemoDirty() && (bl || pSV3MigrateBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSV3MigrateBase.getMemo());
        }
        if (pSV3MigrateBase.isPSModuleIdDirty() && (bl || pSV3MigrateBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSV3MigrateBase.getPSModuleId());
        }
        if (pSV3MigrateBase.isPSModuleNameDirty() && (bl || pSV3MigrateBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSV3MigrateBase.getPSModuleName());
        }
        if (pSV3MigrateBase.isPSSystemIdDirty() && (bl || pSV3MigrateBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSV3MigrateBase.getPSSystemId());
        }
        if (pSV3MigrateBase.isPSSystemNameDirty() && (bl || pSV3MigrateBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSV3MigrateBase.getPSSystemName());
        }
        if (pSV3MigrateBase.isPSV3MigrateIdDirty() && (bl || pSV3MigrateBase.getPSV3MigrateId() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATEID, (Object)pSV3MigrateBase.getPSV3MigrateId());
        }
        if (pSV3MigrateBase.isPSV3MigrateNameDirty() && (bl || pSV3MigrateBase.getPSV3MigrateName() != null)) {
            iDataObject.set(FIELD_PSV3MIGRATENAME, (Object)pSV3MigrateBase.getPSV3MigrateName());
        }
        if (pSV3MigrateBase.isUpdateDateDirty() && (bl || pSV3MigrateBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSV3MigrateBase.getUpdateDate());
        }
        if (pSV3MigrateBase.isUpdateManDirty() && (bl || pSV3MigrateBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSV3MigrateBase.getUpdateMan());
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
        return PSV3MigrateBase.remove(this, n);
    }

    private static boolean remove(PSV3MigrateBase pSV3MigrateBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSV3MigrateBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSV3MigrateBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSV3MigrateBase.resetDEIDPREFIX();
                return true;
            }
            case 3: {
                pSV3MigrateBase.resetDENamePREFIX();
                return true;
            }
            case 4: {
                pSV3MigrateBase.resetExcludeIDS();
                return true;
            }
            case 5: {
                pSV3MigrateBase.resetExcludeNameS();
                return true;
            }
            case 6: {
                pSV3MigrateBase.resetMemo();
                return true;
            }
            case 7: {
                pSV3MigrateBase.resetPSModuleId();
                return true;
            }
            case 8: {
                pSV3MigrateBase.resetPSModuleName();
                return true;
            }
            case 9: {
                pSV3MigrateBase.resetPSSystemId();
                return true;
            }
            case 10: {
                pSV3MigrateBase.resetPSSystemName();
                return true;
            }
            case 11: {
                pSV3MigrateBase.resetPSV3MigrateId();
                return true;
            }
            case 12: {
                pSV3MigrateBase.resetPSV3MigrateName();
                return true;
            }
            case 13: {
                pSV3MigrateBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSV3MigrateBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPsmodule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPsmoduleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
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

    private PSV3MigrateBase getProxyEntity() {
        return this.proxyPSV3MigrateBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSV3MigrateBase = null;
        if (iDataObject != null && iDataObject instanceof PSV3MigrateBase) {
            this.proxyPSV3MigrateBase = (PSV3MigrateBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSV3MigrateService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEIDPREFIX, 2);
        fieldIndexMap.put(FIELD_DENAMEPREFIX, 3);
        fieldIndexMap.put(FIELD_EXCLUDEIDS, 4);
        fieldIndexMap.put(FIELD_EXCLUDENAMES, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSMODULEID, 7);
        fieldIndexMap.put(FIELD_PSMODULENAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 10);
        fieldIndexMap.put(FIELD_PSV3MIGRATEID, 11);
        fieldIndexMap.put(FIELD_PSV3MIGRATENAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

