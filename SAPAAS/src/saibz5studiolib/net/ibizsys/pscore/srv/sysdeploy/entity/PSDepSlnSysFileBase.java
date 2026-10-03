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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnFile;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSlnSys;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnSysFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnSysFileBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNFILEID = "PSDEPSLNFILEID";
    public static final String FIELD_PSDEPSLNFILENAME = "PSDEPSLNFILENAME";
    public static final String FIELD_PSDEPSLNSYSFILEID = "PSDEPSLNSYSFILEID";
    public static final String FIELD_PSDEPSLNSYSFILENAME = "PSDEPSLNSYSFILENAME";
    public static final String FIELD_PSDEPSLNSYSID = "PSDEPSLNSYSID";
    public static final String FIELD_PSDEPSLNSYSNAME = "PSDEPSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSLNFILEID = 3;
    private static final int INDEX_PSDEPSLNFILENAME = 4;
    private static final int INDEX_PSDEPSLNSYSFILEID = 5;
    private static final int INDEX_PSDEPSLNSYSFILENAME = 6;
    private static final int INDEX_PSDEPSLNSYSID = 7;
    private static final int INDEX_PSDEPSLNSYSNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnSysFileBase proxyPSDepSlnSysFileBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslnfileidDirtyFlag = false;
    private boolean psdepslnfilenameDirtyFlag = false;
    private boolean psdepslnsysfileidDirtyFlag = false;
    private boolean psdepslnsysfilenameDirtyFlag = false;
    private boolean psdepslnsysidDirtyFlag = false;
    private boolean psdepslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslnfileid")
    private String psdepslnfileid;
    @Column(name="psdepslnfilename")
    private String psdepslnfilename;
    @Column(name="psdepslnsysfileid")
    private String psdepslnsysfileid;
    @Column(name="psdepslnsysfilename")
    private String psdepslnsysfilename;
    @Column(name="psdepslnsysid")
    private String psdepslnsysid;
    @Column(name="psdepslnsysname")
    private String psdepslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnFileLock = new Integer(1);
    private PSDepSlnFile psdepslnfile = null;
    private Integer objPSDepSlnSysLock = new Integer(1);
    private PSDepSlnSys psdepslnsys = null;

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

    public void setPSDepSlnFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnfileid = string;
        this.psdepslnfileidDirtyFlag = true;
    }

    public String getPSDepSlnFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnFileId();
        }
        return this.psdepslnfileid;
    }

    public boolean isPSDepSlnFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnFileIdDirty();
        }
        return this.psdepslnfileidDirtyFlag;
    }

    public void resetPSDepSlnFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnFileId();
            return;
        }
        this.psdepslnfileidDirtyFlag = false;
        this.psdepslnfileid = null;
    }

    public void setPSDepSlnFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnfilename = string;
        this.psdepslnfilenameDirtyFlag = true;
    }

    public String getPSDepSlnFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnFileName();
        }
        return this.psdepslnfilename;
    }

    public boolean isPSDepSlnFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnFileNameDirty();
        }
        return this.psdepslnfilenameDirtyFlag;
    }

    public void resetPSDepSlnFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnFileName();
            return;
        }
        this.psdepslnfilenameDirtyFlag = false;
        this.psdepslnfilename = null;
    }

    public void setPSDepSlnSysFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysfileid = string;
        this.psdepslnsysfileidDirtyFlag = true;
    }

    public String getPSDepSlnSysFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysFileId();
        }
        return this.psdepslnsysfileid;
    }

    public boolean isPSDepSlnSysFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysFileIdDirty();
        }
        return this.psdepslnsysfileidDirtyFlag;
    }

    public void resetPSDepSlnSysFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysFileId();
            return;
        }
        this.psdepslnsysfileidDirtyFlag = false;
        this.psdepslnsysfileid = null;
    }

    public void setPSDepSlnSysFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysfilename = string;
        this.psdepslnsysfilenameDirtyFlag = true;
    }

    public String getPSDepSlnSysFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysFileName();
        }
        return this.psdepslnsysfilename;
    }

    public boolean isPSDepSlnSysFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysFileNameDirty();
        }
        return this.psdepslnsysfilenameDirtyFlag;
    }

    public void resetPSDepSlnSysFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysFileName();
            return;
        }
        this.psdepslnsysfilenameDirtyFlag = false;
        this.psdepslnsysfilename = null;
    }

    public void setPSDepSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysid = string;
        this.psdepslnsysidDirtyFlag = true;
    }

    public String getPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysId();
        }
        return this.psdepslnsysid;
    }

    public boolean isPSDepSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysIdDirty();
        }
        return this.psdepslnsysidDirtyFlag;
    }

    public void resetPSDepSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysId();
            return;
        }
        this.psdepslnsysidDirtyFlag = false;
        this.psdepslnsysid = null;
    }

    public void setPSDepSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnsysname = string;
        this.psdepslnsysnameDirtyFlag = true;
    }

    public String getPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSysName();
        }
        return this.psdepslnsysname;
    }

    public boolean isPSDepSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnSysNameDirty();
        }
        return this.psdepslnsysnameDirtyFlag;
    }

    public void resetPSDepSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnSysName();
            return;
        }
        this.psdepslnsysnameDirtyFlag = false;
        this.psdepslnsysname = null;
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
        PSDepSlnSysFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnSysFileBase pSDepSlnSysFileBase) {
        pSDepSlnSysFileBase.resetCreateDate();
        pSDepSlnSysFileBase.resetCreateMan();
        pSDepSlnSysFileBase.resetMemo();
        pSDepSlnSysFileBase.resetPSDepSlnFileId();
        pSDepSlnSysFileBase.resetPSDepSlnFileName();
        pSDepSlnSysFileBase.resetPSDepSlnSysFileId();
        pSDepSlnSysFileBase.resetPSDepSlnSysFileName();
        pSDepSlnSysFileBase.resetPSDepSlnSysId();
        pSDepSlnSysFileBase.resetPSDepSlnSysName();
        pSDepSlnSysFileBase.resetUpdateDate();
        pSDepSlnSysFileBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnFileIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNFILEID, this.getPSDepSlnFileId());
        }
        if (!bl || this.isPSDepSlnFileNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNFILENAME, this.getPSDepSlnFileName());
        }
        if (!bl || this.isPSDepSlnSysFileIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSFILEID, this.getPSDepSlnSysFileId());
        }
        if (!bl || this.isPSDepSlnSysFileNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSFILENAME, this.getPSDepSlnSysFileName());
        }
        if (!bl || this.isPSDepSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSID, this.getPSDepSlnSysId());
        }
        if (!bl || this.isPSDepSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNSYSNAME, this.getPSDepSlnSysName());
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
        return PSDepSlnSysFileBase.get(this, n);
    }

    private static Object get(PSDepSlnSysFileBase pSDepSlnSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysFileBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnSysFileBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnSysFileBase.getMemo();
            }
            case 3: {
                return pSDepSlnSysFileBase.getPSDepSlnFileId();
            }
            case 4: {
                return pSDepSlnSysFileBase.getPSDepSlnFileName();
            }
            case 5: {
                return pSDepSlnSysFileBase.getPSDepSlnSysFileId();
            }
            case 6: {
                return pSDepSlnSysFileBase.getPSDepSlnSysFileName();
            }
            case 7: {
                return pSDepSlnSysFileBase.getPSDepSlnSysId();
            }
            case 8: {
                return pSDepSlnSysFileBase.getPSDepSlnSysName();
            }
            case 9: {
                return pSDepSlnSysFileBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnSysFileBase.getUpdateMan();
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
        PSDepSlnSysFileBase.set(this, n, object);
    }

    private static void set(PSDepSlnSysFileBase pSDepSlnSysFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnSysFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnSysFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnSysFileBase.setPSDepSlnFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnSysFileBase.setPSDepSlnFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnSysFileBase.setPSDepSlnSysFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnSysFileBase.setPSDepSlnSysFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnSysFileBase.setPSDepSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnSysFileBase.setPSDepSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnSysFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnSysFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnSysFileBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnSysFileBase pSDepSlnSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysFileBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnSysFileBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnSysFileBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnSysFileBase.getPSDepSlnFileId() == null;
            }
            case 4: {
                return pSDepSlnSysFileBase.getPSDepSlnFileName() == null;
            }
            case 5: {
                return pSDepSlnSysFileBase.getPSDepSlnSysFileId() == null;
            }
            case 6: {
                return pSDepSlnSysFileBase.getPSDepSlnSysFileName() == null;
            }
            case 7: {
                return pSDepSlnSysFileBase.getPSDepSlnSysId() == null;
            }
            case 8: {
                return pSDepSlnSysFileBase.getPSDepSlnSysName() == null;
            }
            case 9: {
                return pSDepSlnSysFileBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnSysFileBase.getUpdateMan() == null;
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
        return PSDepSlnSysFileBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnSysFileBase pSDepSlnSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnSysFileBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnSysFileBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnSysFileBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnSysFileBase.isPSDepSlnFileIdDirty();
            }
            case 4: {
                return pSDepSlnSysFileBase.isPSDepSlnFileNameDirty();
            }
            case 5: {
                return pSDepSlnSysFileBase.isPSDepSlnSysFileIdDirty();
            }
            case 6: {
                return pSDepSlnSysFileBase.isPSDepSlnSysFileNameDirty();
            }
            case 7: {
                return pSDepSlnSysFileBase.isPSDepSlnSysIdDirty();
            }
            case 8: {
                return pSDepSlnSysFileBase.isPSDepSlnSysNameDirty();
            }
            case 9: {
                return pSDepSlnSysFileBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnSysFileBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnSysFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnSysFileBase pSDepSlnSysFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnSysFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnfileid", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnFileId()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnfilename", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnFileName()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysfileid", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnSysFileId()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysfilename", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnSysFileName()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysid", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnSysId()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnsysname", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getPSDepSlnSysName()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnSysFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnSysFileBase.getJSONValue((Object)pSDepSlnSysFileBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnSysFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnSysFileBase pSDepSlnSysFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnSysFileBase.getCreateDate() != null) {
            object = pSDepSlnSysFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysFileBase.getCreateMan() != null) {
            object = pSDepSlnSysFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getMemo() != null) {
            object = pSDepSlnSysFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnFileId() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnFileId();
            xmlNode.setAttribute(FIELD_PSDEPSLNFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnFileName() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnFileName();
            xmlNode.setAttribute(FIELD_PSDEPSLNFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileId() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnSysFileId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileName() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnSysFileName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysId() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getPSDepSlnSysName() != null) {
            object = pSDepSlnSysFileBase.getPSDepSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEPSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnSysFileBase.getUpdateDate() != null) {
            object = pSDepSlnSysFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnSysFileBase.getUpdateMan() != null) {
            object = pSDepSlnSysFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnSysFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnSysFileBase pSDepSlnSysFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnSysFileBase.isCreateDateDirty() && (bl || pSDepSlnSysFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnSysFileBase.getCreateDate());
        }
        if (pSDepSlnSysFileBase.isCreateManDirty() && (bl || pSDepSlnSysFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnSysFileBase.getCreateMan());
        }
        if (pSDepSlnSysFileBase.isMemoDirty() && (bl || pSDepSlnSysFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnSysFileBase.getMemo());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnFileIdDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnFileId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNFILEID, (Object)pSDepSlnSysFileBase.getPSDepSlnFileId());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnFileNameDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnFileName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNFILENAME, (Object)pSDepSlnSysFileBase.getPSDepSlnFileName());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnSysFileIdDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSFILEID, (Object)pSDepSlnSysFileBase.getPSDepSlnSysFileId());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnSysFileNameDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnSysFileName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSFILENAME, (Object)pSDepSlnSysFileBase.getPSDepSlnSysFileName());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnSysIdDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSID, (Object)pSDepSlnSysFileBase.getPSDepSlnSysId());
        }
        if (pSDepSlnSysFileBase.isPSDepSlnSysNameDirty() && (bl || pSDepSlnSysFileBase.getPSDepSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNSYSNAME, (Object)pSDepSlnSysFileBase.getPSDepSlnSysName());
        }
        if (pSDepSlnSysFileBase.isUpdateDateDirty() && (bl || pSDepSlnSysFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnSysFileBase.getUpdateDate());
        }
        if (pSDepSlnSysFileBase.isUpdateManDirty() && (bl || pSDepSlnSysFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnSysFileBase.getUpdateMan());
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
        return PSDepSlnSysFileBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnSysFileBase pSDepSlnSysFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnSysFileBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnSysFileBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnSysFileBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnSysFileBase.resetPSDepSlnFileId();
                return true;
            }
            case 4: {
                pSDepSlnSysFileBase.resetPSDepSlnFileName();
                return true;
            }
            case 5: {
                pSDepSlnSysFileBase.resetPSDepSlnSysFileId();
                return true;
            }
            case 6: {
                pSDepSlnSysFileBase.resetPSDepSlnSysFileName();
                return true;
            }
            case 7: {
                pSDepSlnSysFileBase.resetPSDepSlnSysId();
                return true;
            }
            case 8: {
                pSDepSlnSysFileBase.resetPSDepSlnSysName();
                return true;
            }
            case 9: {
                pSDepSlnSysFileBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnSysFileBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnFile getPSDepSlnFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnFile();
        }
        if (this.getPSDepSlnFileId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnFileLock;
        synchronized (n) {
            if (this.psdepslnfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnFileId(), (Object)this.psdepslnfile.getPSDepSlnFileId()) != 0L) {
                this.psdepslnfile = null;
            }
            if (this.psdepslnfile == null) {
                PSDepSlnFile pSDepSlnFile = new PSDepSlnFile();
                pSDepSlnFile.setPSDepSlnFileId(this.getPSDepSlnFileId());
                PSDepSlnFileService pSDepSlnFileService = (PSDepSlnFileService)ServiceGlobal.getService(PSDepSlnFileService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnFileService.autoGet(pSDepSlnFile);
                this.psdepslnfile = pSDepSlnFile;
            }
            return this.psdepslnfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSlnSys getPSDepSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnSys();
        }
        if (this.getPSDepSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnSysLock;
        synchronized (n) {
            if (this.psdepslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnSysId(), (Object)this.psdepslnsys.getPSDepSlnSysId()) != 0L) {
                this.psdepslnsys = null;
            }
            if (this.psdepslnsys == null) {
                PSDepSlnSys pSDepSlnSys = new PSDepSlnSys();
                pSDepSlnSys.setPSDepSlnSysId(this.getPSDepSlnSysId());
                PSDepSlnSysService pSDepSlnSysService = (PSDepSlnSysService)ServiceGlobal.getService(PSDepSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnSysService.autoGet(pSDepSlnSys);
                this.psdepslnsys = pSDepSlnSys;
            }
            return this.psdepslnsys;
        }
    }

    private PSDepSlnSysFileBase getProxyEntity() {
        return this.proxyPSDepSlnSysFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnSysFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnSysFileBase) {
            this.proxyPSDepSlnSysFileBase = (PSDepSlnSysFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnSysFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSLNFILEID, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNFILENAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSFILEID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSFILENAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNSYSNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

