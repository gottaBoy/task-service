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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysFileBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILEOBJSIZE = "FILEOBJSIZE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERNAME = "OWNERNAME";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSNDFILEID = "PSNDFILEID";
    public static final String FIELD_PSSYSFILEID = "PSSYSFILEID";
    public static final String FIELD_PSSYSFILENAME = "PSSYSFILENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FILEOBJSIZE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_OWNERID = 5;
    private static final int INDEX_OWNERNAME = 6;
    private static final int INDEX_OWNERTYPE = 7;
    private static final int INDEX_PSMODULEID = 8;
    private static final int INDEX_PSMODULENAME = 9;
    private static final int INDEX_PSNDFILEID = 10;
    private static final int INDEX_PSSYSFILEID = 11;
    private static final int INDEX_PSSYSFILENAME = 12;
    private static final int INDEX_PSSYSTEMID = 13;
    private static final int INDEX_PSSYSTEMNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysFileBase proxyPSSysFileBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fileobjsizeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownernameDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean psndfileidDirtyFlag = false;
    private boolean pssysfileidDirtyFlag = false;
    private boolean pssysfilenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fileobjsize")
    private Double fileobjsize;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownername")
    private String ownername;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="psndfileid")
    private String psndfileid;
    @Column(name="pssysfileid")
    private String pssysfileid;
    @Column(name="pssysfilename")
    private String pssysfilename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownername = string;
        this.ownernameDirtyFlag = true;
    }

    public String getOwnerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerName();
        }
        return this.ownername;
    }

    public boolean isOwnerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerNameDirty();
        }
        return this.ownernameDirtyFlag;
    }

    public void resetOwnerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerName();
            return;
        }
        this.ownernameDirtyFlag = false;
        this.ownername = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
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

    public void setPSSysFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysfileid = string;
        this.pssysfileidDirtyFlag = true;
    }

    public String getPSSysFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFileId();
        }
        return this.pssysfileid;
    }

    public boolean isPSSysFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysFileIdDirty();
        }
        return this.pssysfileidDirtyFlag;
    }

    public void resetPSSysFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysFileId();
            return;
        }
        this.pssysfileidDirtyFlag = false;
        this.pssysfileid = null;
    }

    public void setPSSysFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysfilename = string;
        this.pssysfilenameDirtyFlag = true;
    }

    public String getPSSysFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysFileName();
        }
        return this.pssysfilename;
    }

    public boolean isPSSysFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysFileNameDirty();
        }
        return this.pssysfilenameDirtyFlag;
    }

    public void resetPSSysFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysFileName();
            return;
        }
        this.pssysfilenameDirtyFlag = false;
        this.pssysfilename = null;
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
        PSSysFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysFileBase pSSysFileBase) {
        pSSysFileBase.resetCodeName();
        pSSysFileBase.resetCreateDate();
        pSSysFileBase.resetCreateMan();
        pSSysFileBase.resetFileObjSize();
        pSSysFileBase.resetMemo();
        pSSysFileBase.resetOwnerId();
        pSSysFileBase.resetOwnerName();
        pSSysFileBase.resetOwnerType();
        pSSysFileBase.resetPSModuleId();
        pSSysFileBase.resetPSModuleName();
        pSSysFileBase.resetPSNDFileId();
        pSSysFileBase.resetPSSysFileId();
        pSSysFileBase.resetPSSysFileName();
        pSSysFileBase.resetPSSystemId();
        pSSysFileBase.resetPSSystemName();
        pSSysFileBase.resetUpdateDate();
        pSSysFileBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFileObjSizeDirty()) {
            hashMap.put(FIELD_FILEOBJSIZE, this.getFileObjSize());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerNameDirty()) {
            hashMap.put(FIELD_OWNERNAME, this.getOwnerName());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSNDFileIdDirty()) {
            hashMap.put(FIELD_PSNDFILEID, this.getPSNDFileId());
        }
        if (!bl || this.isPSSysFileIdDirty()) {
            hashMap.put(FIELD_PSSYSFILEID, this.getPSSysFileId());
        }
        if (!bl || this.isPSSysFileNameDirty()) {
            hashMap.put(FIELD_PSSYSFILENAME, this.getPSSysFileName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysFileBase.get(this, n);
    }

    private static Object get(PSSysFileBase pSSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysFileBase.getCodeName();
            }
            case 1: {
                return pSSysFileBase.getCreateDate();
            }
            case 2: {
                return pSSysFileBase.getCreateMan();
            }
            case 3: {
                return pSSysFileBase.getFileObjSize();
            }
            case 4: {
                return pSSysFileBase.getMemo();
            }
            case 5: {
                return pSSysFileBase.getOwnerId();
            }
            case 6: {
                return pSSysFileBase.getOwnerName();
            }
            case 7: {
                return pSSysFileBase.getOwnerType();
            }
            case 8: {
                return pSSysFileBase.getPSModuleId();
            }
            case 9: {
                return pSSysFileBase.getPSModuleName();
            }
            case 10: {
                return pSSysFileBase.getPSNDFileId();
            }
            case 11: {
                return pSSysFileBase.getPSSysFileId();
            }
            case 12: {
                return pSSysFileBase.getPSSysFileName();
            }
            case 13: {
                return pSSysFileBase.getPSSystemId();
            }
            case 14: {
                return pSSysFileBase.getPSSystemName();
            }
            case 15: {
                return pSSysFileBase.getUpdateDate();
            }
            case 16: {
                return pSSysFileBase.getUpdateMan();
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
        PSSysFileBase.set(this, n, object);
    }

    private static void set(PSSysFileBase pSSysFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysFileBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysFileBase.setFileObjSize(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 4: {
                pSSysFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysFileBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysFileBase.setOwnerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysFileBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysFileBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysFileBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysFileBase.setPSNDFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysFileBase.setPSSysFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysFileBase.setPSSysFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysFileBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysFileBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSSysFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysFileBase.isNull(this, n);
    }

    private static boolean isNull(PSSysFileBase pSSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysFileBase.getCodeName() == null;
            }
            case 1: {
                return pSSysFileBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysFileBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysFileBase.getFileObjSize() == null;
            }
            case 4: {
                return pSSysFileBase.getMemo() == null;
            }
            case 5: {
                return pSSysFileBase.getOwnerId() == null;
            }
            case 6: {
                return pSSysFileBase.getOwnerName() == null;
            }
            case 7: {
                return pSSysFileBase.getOwnerType() == null;
            }
            case 8: {
                return pSSysFileBase.getPSModuleId() == null;
            }
            case 9: {
                return pSSysFileBase.getPSModuleName() == null;
            }
            case 10: {
                return pSSysFileBase.getPSNDFileId() == null;
            }
            case 11: {
                return pSSysFileBase.getPSSysFileId() == null;
            }
            case 12: {
                return pSSysFileBase.getPSSysFileName() == null;
            }
            case 13: {
                return pSSysFileBase.getPSSystemId() == null;
            }
            case 14: {
                return pSSysFileBase.getPSSystemName() == null;
            }
            case 15: {
                return pSSysFileBase.getUpdateDate() == null;
            }
            case 16: {
                return pSSysFileBase.getUpdateMan() == null;
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
        return PSSysFileBase.contains(this, n);
    }

    private static boolean contains(PSSysFileBase pSSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysFileBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysFileBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysFileBase.isCreateManDirty();
            }
            case 3: {
                return pSSysFileBase.isFileObjSizeDirty();
            }
            case 4: {
                return pSSysFileBase.isMemoDirty();
            }
            case 5: {
                return pSSysFileBase.isOwnerIdDirty();
            }
            case 6: {
                return pSSysFileBase.isOwnerNameDirty();
            }
            case 7: {
                return pSSysFileBase.isOwnerTypeDirty();
            }
            case 8: {
                return pSSysFileBase.isPSModuleIdDirty();
            }
            case 9: {
                return pSSysFileBase.isPSModuleNameDirty();
            }
            case 10: {
                return pSSysFileBase.isPSNDFileIdDirty();
            }
            case 11: {
                return pSSysFileBase.isPSSysFileIdDirty();
            }
            case 12: {
                return pSSysFileBase.isPSSysFileNameDirty();
            }
            case 13: {
                return pSSysFileBase.isPSSystemIdDirty();
            }
            case 14: {
                return pSSysFileBase.isPSSystemNameDirty();
            }
            case 15: {
                return pSSysFileBase.isUpdateDateDirty();
            }
            case 16: {
                return pSSysFileBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysFileBase pSSysFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysFileBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysFileBase.getFileObjSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fileobjsize", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getFileObjSize()), (boolean)false);
        }
        if (bl || pSSysFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysFileBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSSysFileBase.getOwnerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownername", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getOwnerName()), (boolean)false);
        }
        if (bl || pSSysFileBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSNDFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psndfileid", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSNDFileId()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSSysFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysfileid", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSSysFileId()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSSysFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysfilename", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSSysFileName()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysFileBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysFileBase.getJSONValue((Object)pSSysFileBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysFileBase pSSysFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysFileBase.getCodeName() != null) {
            object = pSSysFileBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getCreateDate() != null) {
            object = pSSysFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysFileBase.getCreateMan() != null) {
            object = pSSysFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getFileObjSize() != null) {
            object = pSSysFileBase.getFileObjSize();
            xmlNode.setAttribute(FIELD_FILEOBJSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysFileBase.getMemo() != null) {
            object = pSSysFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getOwnerId() != null) {
            object = pSSysFileBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getOwnerName() != null) {
            object = pSSysFileBase.getOwnerName();
            xmlNode.setAttribute(FIELD_OWNERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getOwnerType() != null) {
            object = pSSysFileBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSModuleId() != null) {
            object = pSSysFileBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSModuleName() != null) {
            object = pSSysFileBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSNDFileId() != null) {
            object = pSSysFileBase.getPSNDFileId();
            xmlNode.setAttribute(FIELD_PSNDFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSSysFileId() != null) {
            object = pSSysFileBase.getPSSysFileId();
            xmlNode.setAttribute(FIELD_PSSYSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSSysFileName() != null) {
            object = pSSysFileBase.getPSSysFileName();
            xmlNode.setAttribute(FIELD_PSSYSFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSSystemId() != null) {
            object = pSSysFileBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getPSSystemName() != null) {
            object = pSSysFileBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysFileBase.getUpdateDate() != null) {
            object = pSSysFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysFileBase.getUpdateMan() != null) {
            object = pSSysFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysFileBase pSSysFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysFileBase.isCodeNameDirty() && (bl || pSSysFileBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysFileBase.getCodeName());
        }
        if (pSSysFileBase.isCreateDateDirty() && (bl || pSSysFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysFileBase.getCreateDate());
        }
        if (pSSysFileBase.isCreateManDirty() && (bl || pSSysFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysFileBase.getCreateMan());
        }
        if (pSSysFileBase.isFileObjSizeDirty() && (bl || pSSysFileBase.getFileObjSize() != null)) {
            iDataObject.set(FIELD_FILEOBJSIZE, (Object)pSSysFileBase.getFileObjSize());
        }
        if (pSSysFileBase.isMemoDirty() && (bl || pSSysFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysFileBase.getMemo());
        }
        if (pSSysFileBase.isOwnerIdDirty() && (bl || pSSysFileBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSSysFileBase.getOwnerId());
        }
        if (pSSysFileBase.isOwnerNameDirty() && (bl || pSSysFileBase.getOwnerName() != null)) {
            iDataObject.set(FIELD_OWNERNAME, (Object)pSSysFileBase.getOwnerName());
        }
        if (pSSysFileBase.isOwnerTypeDirty() && (bl || pSSysFileBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSSysFileBase.getOwnerType());
        }
        if (pSSysFileBase.isPSModuleIdDirty() && (bl || pSSysFileBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysFileBase.getPSModuleId());
        }
        if (pSSysFileBase.isPSModuleNameDirty() && (bl || pSSysFileBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysFileBase.getPSModuleName());
        }
        if (pSSysFileBase.isPSNDFileIdDirty() && (bl || pSSysFileBase.getPSNDFileId() != null)) {
            iDataObject.set(FIELD_PSNDFILEID, (Object)pSSysFileBase.getPSNDFileId());
        }
        if (pSSysFileBase.isPSSysFileIdDirty() && (bl || pSSysFileBase.getPSSysFileId() != null)) {
            iDataObject.set(FIELD_PSSYSFILEID, (Object)pSSysFileBase.getPSSysFileId());
        }
        if (pSSysFileBase.isPSSysFileNameDirty() && (bl || pSSysFileBase.getPSSysFileName() != null)) {
            iDataObject.set(FIELD_PSSYSFILENAME, (Object)pSSysFileBase.getPSSysFileName());
        }
        if (pSSysFileBase.isPSSystemIdDirty() && (bl || pSSysFileBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysFileBase.getPSSystemId());
        }
        if (pSSysFileBase.isPSSystemNameDirty() && (bl || pSSysFileBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysFileBase.getPSSystemName());
        }
        if (pSSysFileBase.isUpdateDateDirty() && (bl || pSSysFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysFileBase.getUpdateDate());
        }
        if (pSSysFileBase.isUpdateManDirty() && (bl || pSSysFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysFileBase.getUpdateMan());
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
        return PSSysFileBase.remove(this, n);
    }

    private static boolean remove(PSSysFileBase pSSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysFileBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysFileBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysFileBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysFileBase.resetFileObjSize();
                return true;
            }
            case 4: {
                pSSysFileBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysFileBase.resetOwnerId();
                return true;
            }
            case 6: {
                pSSysFileBase.resetOwnerName();
                return true;
            }
            case 7: {
                pSSysFileBase.resetOwnerType();
                return true;
            }
            case 8: {
                pSSysFileBase.resetPSModuleId();
                return true;
            }
            case 9: {
                pSSysFileBase.resetPSModuleName();
                return true;
            }
            case 10: {
                pSSysFileBase.resetPSNDFileId();
                return true;
            }
            case 11: {
                pSSysFileBase.resetPSSysFileId();
                return true;
            }
            case 12: {
                pSSysFileBase.resetPSSysFileName();
                return true;
            }
            case 13: {
                pSSysFileBase.resetPSSystemId();
                return true;
            }
            case 14: {
                pSSysFileBase.resetPSSystemName();
                return true;
            }
            case 15: {
                pSSysFileBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSSysFileBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
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
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
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

    private PSSysFileBase getProxyEntity() {
        return this.proxyPSSysFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysFileBase) {
            this.proxyPSSysFileBase = (PSSysFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FILEOBJSIZE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_OWNERID, 5);
        fieldIndexMap.put(FIELD_OWNERNAME, 6);
        fieldIndexMap.put(FIELD_OWNERTYPE, 7);
        fieldIndexMap.put(FIELD_PSMODULEID, 8);
        fieldIndexMap.put(FIELD_PSMODULENAME, 9);
        fieldIndexMap.put(FIELD_PSNDFILEID, 10);
        fieldIndexMap.put(FIELD_PSSYSFILEID, 11);
        fieldIndexMap.put(FIELD_PSSYSFILENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
    }
}

