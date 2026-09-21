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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDCFileService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnFileBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnFileBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCFILEID = "PSDCFILEID";
    public static final String FIELD_PSDCFILENAME = "PSDCFILENAME";
    public static final String FIELD_PSDEPSLNFILEID = "PSDEPSLNFILEID";
    public static final String FIELD_PSDEPSLNFILENAME = "PSDEPSLNFILENAME";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCFILEID = 3;
    private static final int INDEX_PSDCFILENAME = 4;
    private static final int INDEX_PSDEPSLNFILEID = 5;
    private static final int INDEX_PSDEPSLNFILENAME = 6;
    private static final int INDEX_PSDEPSLNID = 7;
    private static final int INDEX_PSDEPSLNNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnFileBase proxyPSDepSlnFileBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcfileidDirtyFlag = false;
    private boolean psdcfilenameDirtyFlag = false;
    private boolean psdepslnfileidDirtyFlag = false;
    private boolean psdepslnfilenameDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcfileid")
    private String psdcfileid;
    @Column(name="psdcfilename")
    private String psdcfilename;
    @Column(name="psdepslnfileid")
    private String psdepslnfileid;
    @Column(name="psdepslnfilename")
    private String psdepslnfilename;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCFileLock = new Integer(1);
    private PSDCFile psdcfile = null;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;

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

    public void setPSDCFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfileid = string;
        this.psdcfileidDirtyFlag = true;
    }

    public String getPSDCFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileId();
        }
        return this.psdcfileid;
    }

    public boolean isPSDCFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileIdDirty();
        }
        return this.psdcfileidDirtyFlag;
    }

    public void resetPSDCFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileId();
            return;
        }
        this.psdcfileidDirtyFlag = false;
        this.psdcfileid = null;
    }

    public void setPSDCFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcfilename = string;
        this.psdcfilenameDirtyFlag = true;
    }

    public String getPSDCFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFileName();
        }
        return this.psdcfilename;
    }

    public boolean isPSDCFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCFileNameDirty();
        }
        return this.psdcfilenameDirtyFlag;
    }

    public void resetPSDCFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCFileName();
            return;
        }
        this.psdcfilenameDirtyFlag = false;
        this.psdcfilename = null;
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

    public void setPSDepSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnid = string;
        this.psdepslnidDirtyFlag = true;
    }

    public String getPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnId();
        }
        return this.psdepslnid;
    }

    public boolean isPSDepSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnIdDirty();
        }
        return this.psdepslnidDirtyFlag;
    }

    public void resetPSDepSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnId();
            return;
        }
        this.psdepslnidDirtyFlag = false;
        this.psdepslnid = null;
    }

    public void setPSDepSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnname = string;
        this.psdepslnnameDirtyFlag = true;
    }

    public String getPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnName();
        }
        return this.psdepslnname;
    }

    public boolean isPSDepSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnNameDirty();
        }
        return this.psdepslnnameDirtyFlag;
    }

    public void resetPSDepSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnName();
            return;
        }
        this.psdepslnnameDirtyFlag = false;
        this.psdepslnname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDepSlnFileBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnFileBase pSDepSlnFileBase) {
        pSDepSlnFileBase.resetCreateDate();
        pSDepSlnFileBase.resetCreateMan();
        pSDepSlnFileBase.resetMemo();
        pSDepSlnFileBase.resetPSDCFileId();
        pSDepSlnFileBase.resetPSDCFileName();
        pSDepSlnFileBase.resetPSDepSlnFileId();
        pSDepSlnFileBase.resetPSDepSlnFileName();
        pSDepSlnFileBase.resetPSDepSlnId();
        pSDepSlnFileBase.resetPSDepSlnName();
        pSDepSlnFileBase.resetUpdateDate();
        pSDepSlnFileBase.resetUpdateMan();
        pSDepSlnFileBase.resetValidFlag();
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
        if (!bl || this.isPSDCFileIdDirty()) {
            hashMap.put(FIELD_PSDCFILEID, this.getPSDCFileId());
        }
        if (!bl || this.isPSDCFileNameDirty()) {
            hashMap.put(FIELD_PSDCFILENAME, this.getPSDCFileName());
        }
        if (!bl || this.isPSDepSlnFileIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNFILEID, this.getPSDepSlnFileId());
        }
        if (!bl || this.isPSDepSlnFileNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNFILENAME, this.getPSDepSlnFileName());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDepSlnFileBase.get(this, n);
    }

    private static Object get(PSDepSlnFileBase pSDepSlnFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnFileBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnFileBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnFileBase.getMemo();
            }
            case 3: {
                return pSDepSlnFileBase.getPSDCFileId();
            }
            case 4: {
                return pSDepSlnFileBase.getPSDCFileName();
            }
            case 5: {
                return pSDepSlnFileBase.getPSDepSlnFileId();
            }
            case 6: {
                return pSDepSlnFileBase.getPSDepSlnFileName();
            }
            case 7: {
                return pSDepSlnFileBase.getPSDepSlnId();
            }
            case 8: {
                return pSDepSlnFileBase.getPSDepSlnName();
            }
            case 9: {
                return pSDepSlnFileBase.getUpdateDate();
            }
            case 10: {
                return pSDepSlnFileBase.getUpdateMan();
            }
            case 11: {
                return pSDepSlnFileBase.getValidFlag();
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
        PSDepSlnFileBase.set(this, n, object);
    }

    private static void set(PSDepSlnFileBase pSDepSlnFileBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnFileBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnFileBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnFileBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnFileBase.setPSDCFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnFileBase.setPSDCFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnFileBase.setPSDepSlnFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnFileBase.setPSDepSlnFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnFileBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnFileBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnFileBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnFileBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnFileBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnFileBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnFileBase pSDepSlnFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnFileBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnFileBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnFileBase.getMemo() == null;
            }
            case 3: {
                return pSDepSlnFileBase.getPSDCFileId() == null;
            }
            case 4: {
                return pSDepSlnFileBase.getPSDCFileName() == null;
            }
            case 5: {
                return pSDepSlnFileBase.getPSDepSlnFileId() == null;
            }
            case 6: {
                return pSDepSlnFileBase.getPSDepSlnFileName() == null;
            }
            case 7: {
                return pSDepSlnFileBase.getPSDepSlnId() == null;
            }
            case 8: {
                return pSDepSlnFileBase.getPSDepSlnName() == null;
            }
            case 9: {
                return pSDepSlnFileBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSlnFileBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDepSlnFileBase.getValidFlag() == null;
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
        return PSDepSlnFileBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnFileBase pSDepSlnFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnFileBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnFileBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnFileBase.isMemoDirty();
            }
            case 3: {
                return pSDepSlnFileBase.isPSDCFileIdDirty();
            }
            case 4: {
                return pSDepSlnFileBase.isPSDCFileNameDirty();
            }
            case 5: {
                return pSDepSlnFileBase.isPSDepSlnFileIdDirty();
            }
            case 6: {
                return pSDepSlnFileBase.isPSDepSlnFileNameDirty();
            }
            case 7: {
                return pSDepSlnFileBase.isPSDepSlnIdDirty();
            }
            case 8: {
                return pSDepSlnFileBase.isPSDepSlnNameDirty();
            }
            case 9: {
                return pSDepSlnFileBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSlnFileBase.isUpdateManDirty();
            }
            case 11: {
                return pSDepSlnFileBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnFileBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnFileBase pSDepSlnFileBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnFileBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDCFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfileid", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDCFileId()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDCFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcfilename", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDCFileName()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnfileid", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDepSlnFileId()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnfilename", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDepSlnFileName()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnFileBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnFileBase.getJSONValue((Object)pSDepSlnFileBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnFileBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnFileBase pSDepSlnFileBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnFileBase.getCreateDate() != null) {
            object = pSDepSlnFileBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnFileBase.getCreateMan() != null) {
            object = pSDepSlnFileBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getMemo() != null) {
            object = pSDepSlnFileBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDCFileId() != null) {
            object = pSDepSlnFileBase.getPSDCFileId();
            xmlNode.setAttribute(FIELD_PSDCFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDCFileName() != null) {
            object = pSDepSlnFileBase.getPSDCFileName();
            xmlNode.setAttribute(FIELD_PSDCFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnFileId() != null) {
            object = pSDepSlnFileBase.getPSDepSlnFileId();
            xmlNode.setAttribute(FIELD_PSDEPSLNFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnFileName() != null) {
            object = pSDepSlnFileBase.getPSDepSlnFileName();
            xmlNode.setAttribute(FIELD_PSDEPSLNFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnId() != null) {
            object = pSDepSlnFileBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getPSDepSlnName() != null) {
            object = pSDepSlnFileBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getUpdateDate() != null) {
            object = pSDepSlnFileBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnFileBase.getUpdateMan() != null) {
            object = pSDepSlnFileBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnFileBase.getValidFlag() != null) {
            object = pSDepSlnFileBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnFileBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnFileBase pSDepSlnFileBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnFileBase.isCreateDateDirty() && (bl || pSDepSlnFileBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnFileBase.getCreateDate());
        }
        if (pSDepSlnFileBase.isCreateManDirty() && (bl || pSDepSlnFileBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnFileBase.getCreateMan());
        }
        if (pSDepSlnFileBase.isMemoDirty() && (bl || pSDepSlnFileBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnFileBase.getMemo());
        }
        if (pSDepSlnFileBase.isPSDCFileIdDirty() && (bl || pSDepSlnFileBase.getPSDCFileId() != null)) {
            iDataObject.set(FIELD_PSDCFILEID, (Object)pSDepSlnFileBase.getPSDCFileId());
        }
        if (pSDepSlnFileBase.isPSDCFileNameDirty() && (bl || pSDepSlnFileBase.getPSDCFileName() != null)) {
            iDataObject.set(FIELD_PSDCFILENAME, (Object)pSDepSlnFileBase.getPSDCFileName());
        }
        if (pSDepSlnFileBase.isPSDepSlnFileIdDirty() && (bl || pSDepSlnFileBase.getPSDepSlnFileId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNFILEID, (Object)pSDepSlnFileBase.getPSDepSlnFileId());
        }
        if (pSDepSlnFileBase.isPSDepSlnFileNameDirty() && (bl || pSDepSlnFileBase.getPSDepSlnFileName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNFILENAME, (Object)pSDepSlnFileBase.getPSDepSlnFileName());
        }
        if (pSDepSlnFileBase.isPSDepSlnIdDirty() && (bl || pSDepSlnFileBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnFileBase.getPSDepSlnId());
        }
        if (pSDepSlnFileBase.isPSDepSlnNameDirty() && (bl || pSDepSlnFileBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnFileBase.getPSDepSlnName());
        }
        if (pSDepSlnFileBase.isUpdateDateDirty() && (bl || pSDepSlnFileBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnFileBase.getUpdateDate());
        }
        if (pSDepSlnFileBase.isUpdateManDirty() && (bl || pSDepSlnFileBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnFileBase.getUpdateMan());
        }
        if (pSDepSlnFileBase.isValidFlagDirty() && (bl || pSDepSlnFileBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnFileBase.getValidFlag());
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
        return PSDepSlnFileBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnFileBase pSDepSlnFileBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnFileBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnFileBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnFileBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSlnFileBase.resetPSDCFileId();
                return true;
            }
            case 4: {
                pSDepSlnFileBase.resetPSDCFileName();
                return true;
            }
            case 5: {
                pSDepSlnFileBase.resetPSDepSlnFileId();
                return true;
            }
            case 6: {
                pSDepSlnFileBase.resetPSDepSlnFileName();
                return true;
            }
            case 7: {
                pSDepSlnFileBase.resetPSDepSlnId();
                return true;
            }
            case 8: {
                pSDepSlnFileBase.resetPSDepSlnName();
                return true;
            }
            case 9: {
                pSDepSlnFileBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSlnFileBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDepSlnFileBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCFile getPSDCFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCFile();
        }
        if (this.getPSDCFileId() == null) {
            return null;
        }
        Integer n = this.objPSDCFileLock;
        synchronized (n) {
            if (this.psdcfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCFileId(), (Object)this.psdcfile.getPSDCFileId()) != 0L) {
                this.psdcfile = null;
            }
            if (this.psdcfile == null) {
                PSDCFile pSDCFile = new PSDCFile();
                pSDCFile.setPSDCFileId(this.getPSDCFileId());
                PSDCFileService pSDCFileService = (PSDCFileService)ServiceGlobal.getService(PSDCFileService.class, (SessionFactory)this.getSessionFactory());
                pSDCFileService.autoGet((IEntity)pSDCFile);
                this.psdcfile = pSDCFile;
            }
            return this.psdcfile;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDepSln getPSDepSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSln();
        }
        if (this.getPSDepSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDepSlnLock;
        synchronized (n) {
            if (this.psdepsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDepSlnId(), (Object)this.psdepsln.getPSDepSlnId()) != 0L) {
                this.psdepsln = null;
            }
            if (this.psdepsln == null) {
                PSDepSln pSDepSln = new PSDepSln();
                pSDepSln.setPSDepSlnId(this.getPSDepSlnId());
                PSDepSlnService pSDepSlnService = (PSDepSlnService)ServiceGlobal.getService(PSDepSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDepSlnService.autoGet((IEntity)pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    private PSDepSlnFileBase getProxyEntity() {
        return this.proxyPSDepSlnFileBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnFileBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnFileBase) {
            this.proxyPSDepSlnFileBase = (PSDepSlnFileBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnFileService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCFILEID, 3);
        fieldIndexMap.put(FIELD_PSDCFILENAME, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNFILEID, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNFILENAME, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

