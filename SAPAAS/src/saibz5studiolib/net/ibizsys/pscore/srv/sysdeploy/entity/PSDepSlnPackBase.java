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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterFile;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterFileService;
import net.ibizsys.pscore.srv.sysdeploy.entity.PSDepSln;
import net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnPackBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnPackBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPTOOLTYPE = "DEPTOOLTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PACKERRORINFO = "PACKERRORINFO";
    public static final String FIELD_PACKSTATE = "PACKSTATE";
    public static final String FIELD_PSDEPSLNID = "PSDEPSLNID";
    public static final String FIELD_PSDEPSLNNAME = "PSDEPSLNNAME";
    public static final String FIELD_PSDEPSLNPACKID = "PSDEPSLNPACKID";
    public static final String FIELD_PSDEPSLNPACKNAME = "PSDEPSLNPACKNAME";
    public static final String FIELD_PSDEVCENTERFILEID = "PSDEVCENTERFILEID";
    public static final String FIELD_PSDEVCENTERFILENAME = "PSDEVCENTERFILENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEPTOOLTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PACKERRORINFO = 4;
    private static final int INDEX_PACKSTATE = 5;
    private static final int INDEX_PSDEPSLNID = 6;
    private static final int INDEX_PSDEPSLNNAME = 7;
    private static final int INDEX_PSDEPSLNPACKID = 8;
    private static final int INDEX_PSDEPSLNPACKNAME = 9;
    private static final int INDEX_PSDEVCENTERFILEID = 10;
    private static final int INDEX_PSDEVCENTERFILENAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnPackBase proxyPSDepSlnPackBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deptooltypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean packerrorinfoDirtyFlag = false;
    private boolean packstateDirtyFlag = false;
    private boolean psdepslnidDirtyFlag = false;
    private boolean psdepslnnameDirtyFlag = false;
    private boolean psdepslnpackidDirtyFlag = false;
    private boolean psdepslnpacknameDirtyFlag = false;
    private boolean psdevcenterfileidDirtyFlag = false;
    private boolean psdevcenterfilenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deptooltype")
    private String deptooltype;
    @Column(name="memo")
    private String memo;
    @Column(name="packerrorinfo")
    private String packerrorinfo;
    @Column(name="packstate")
    private Integer packstate;
    @Column(name="psdepslnid")
    private String psdepslnid;
    @Column(name="psdepslnname")
    private String psdepslnname;
    @Column(name="psdepslnpackid")
    private String psdepslnpackid;
    @Column(name="psdepslnpackname")
    private String psdepslnpackname;
    @Column(name="psdevcenterfileid")
    private String psdevcenterfileid;
    @Column(name="psdevcenterfilename")
    private String psdevcenterfilename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDepSlnLock = new Integer(1);
    private PSDepSln psdepsln = null;
    private Integer objPSDevCenterFileLock = new Integer(1);
    private PSDevCenterFile psdevcenterfile = null;

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

    public void setDepToolType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepToolType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deptooltype = string;
        this.deptooltypeDirtyFlag = true;
    }

    public String getDepToolType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepToolType();
        }
        return this.deptooltype;
    }

    public boolean isDepToolTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepToolTypeDirty();
        }
        return this.deptooltypeDirtyFlag;
    }

    public void resetDepToolType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepToolType();
            return;
        }
        this.deptooltypeDirtyFlag = false;
        this.deptooltype = null;
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

    public void setPackErrorInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackErrorInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.packerrorinfo = string;
        this.packerrorinfoDirtyFlag = true;
    }

    public String getPackErrorInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackErrorInfo();
        }
        return this.packerrorinfo;
    }

    public boolean isPackErrorInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackErrorInfoDirty();
        }
        return this.packerrorinfoDirtyFlag;
    }

    public void resetPackErrorInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackErrorInfo();
            return;
        }
        this.packerrorinfoDirtyFlag = false;
        this.packerrorinfo = null;
    }

    public void setPackState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackState(n);
            return;
        }
        this.packstate = n;
        this.packstateDirtyFlag = true;
    }

    public Integer getPackState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackState();
        }
        return this.packstate;
    }

    public boolean isPackStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackStateDirty();
        }
        return this.packstateDirtyFlag;
    }

    public void resetPackState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackState();
            return;
        }
        this.packstateDirtyFlag = false;
        this.packstate = null;
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

    public void setPSDepSlnPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnpackid = string;
        this.psdepslnpackidDirtyFlag = true;
    }

    public String getPSDepSlnPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPackId();
        }
        return this.psdepslnpackid;
    }

    public boolean isPSDepSlnPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPackIdDirty();
        }
        return this.psdepslnpackidDirtyFlag;
    }

    public void resetPSDepSlnPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPackId();
            return;
        }
        this.psdepslnpackidDirtyFlag = false;
        this.psdepslnpackid = null;
    }

    public void setPSDepSlnPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslnpackname = string;
        this.psdepslnpacknameDirtyFlag = true;
    }

    public String getPSDepSlnPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnPackName();
        }
        return this.psdepslnpackname;
    }

    public boolean isPSDepSlnPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnPackNameDirty();
        }
        return this.psdepslnpacknameDirtyFlag;
    }

    public void resetPSDepSlnPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnPackName();
            return;
        }
        this.psdepslnpacknameDirtyFlag = false;
        this.psdepslnpackname = null;
    }

    public void setPSDevCenterFileId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfileid = string;
        this.psdevcenterfileidDirtyFlag = true;
    }

    public String getPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileId();
        }
        return this.psdevcenterfileid;
    }

    public boolean isPSDevCenterFileIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileIdDirty();
        }
        return this.psdevcenterfileidDirtyFlag;
    }

    public void resetPSDevCenterFileId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileId();
            return;
        }
        this.psdevcenterfileidDirtyFlag = false;
        this.psdevcenterfileid = null;
    }

    public void setPSDevCenterFileName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterFileName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterfilename = string;
        this.psdevcenterfilenameDirtyFlag = true;
    }

    public String getPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFileName();
        }
        return this.psdevcenterfilename;
    }

    public boolean isPSDevCenterFileNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterFileNameDirty();
        }
        return this.psdevcenterfilenameDirtyFlag;
    }

    public void resetPSDevCenterFileName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterFileName();
            return;
        }
        this.psdevcenterfilenameDirtyFlag = false;
        this.psdevcenterfilename = null;
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
        PSDepSlnPackBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnPackBase pSDepSlnPackBase) {
        pSDepSlnPackBase.resetCreateDate();
        pSDepSlnPackBase.resetCreateMan();
        pSDepSlnPackBase.resetDepToolType();
        pSDepSlnPackBase.resetMemo();
        pSDepSlnPackBase.resetPackErrorInfo();
        pSDepSlnPackBase.resetPackState();
        pSDepSlnPackBase.resetPSDepSlnId();
        pSDepSlnPackBase.resetPSDepSlnName();
        pSDepSlnPackBase.resetPSDepSlnPackId();
        pSDepSlnPackBase.resetPSDepSlnPackName();
        pSDepSlnPackBase.resetPSDevCenterFileId();
        pSDepSlnPackBase.resetPSDevCenterFileName();
        pSDepSlnPackBase.resetUpdateDate();
        pSDepSlnPackBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDepToolTypeDirty()) {
            hashMap.put(FIELD_DEPTOOLTYPE, this.getDepToolType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPackErrorInfoDirty()) {
            hashMap.put(FIELD_PACKERRORINFO, this.getPackErrorInfo());
        }
        if (!bl || this.isPackStateDirty()) {
            hashMap.put(FIELD_PACKSTATE, this.getPackState());
        }
        if (!bl || this.isPSDepSlnIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNID, this.getPSDepSlnId());
        }
        if (!bl || this.isPSDepSlnNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNNAME, this.getPSDepSlnName());
        }
        if (!bl || this.isPSDepSlnPackIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNPACKID, this.getPSDepSlnPackId());
        }
        if (!bl || this.isPSDepSlnPackNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNPACKNAME, this.getPSDepSlnPackName());
        }
        if (!bl || this.isPSDevCenterFileIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILEID, this.getPSDevCenterFileId());
        }
        if (!bl || this.isPSDevCenterFileNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERFILENAME, this.getPSDevCenterFileName());
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
        return PSDepSlnPackBase.get(this, n);
    }

    private static Object get(PSDepSlnPackBase pSDepSlnPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPackBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnPackBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnPackBase.getDepToolType();
            }
            case 3: {
                return pSDepSlnPackBase.getMemo();
            }
            case 4: {
                return pSDepSlnPackBase.getPackErrorInfo();
            }
            case 5: {
                return pSDepSlnPackBase.getPackState();
            }
            case 6: {
                return pSDepSlnPackBase.getPSDepSlnId();
            }
            case 7: {
                return pSDepSlnPackBase.getPSDepSlnName();
            }
            case 8: {
                return pSDepSlnPackBase.getPSDepSlnPackId();
            }
            case 9: {
                return pSDepSlnPackBase.getPSDepSlnPackName();
            }
            case 10: {
                return pSDepSlnPackBase.getPSDevCenterFileId();
            }
            case 11: {
                return pSDepSlnPackBase.getPSDevCenterFileName();
            }
            case 12: {
                return pSDepSlnPackBase.getUpdateDate();
            }
            case 13: {
                return pSDepSlnPackBase.getUpdateMan();
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
        PSDepSlnPackBase.set(this, n, object);
    }

    private static void set(PSDepSlnPackBase pSDepSlnPackBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnPackBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnPackBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnPackBase.setDepToolType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnPackBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnPackBase.setPackErrorInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnPackBase.setPackState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnPackBase.setPSDepSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnPackBase.setPSDepSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnPackBase.setPSDepSlnPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnPackBase.setPSDepSlnPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnPackBase.setPSDevCenterFileId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSlnPackBase.setPSDevCenterFileName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDepSlnPackBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDepSlnPackBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSlnPackBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnPackBase pSDepSlnPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPackBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnPackBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnPackBase.getDepToolType() == null;
            }
            case 3: {
                return pSDepSlnPackBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnPackBase.getPackErrorInfo() == null;
            }
            case 5: {
                return pSDepSlnPackBase.getPackState() == null;
            }
            case 6: {
                return pSDepSlnPackBase.getPSDepSlnId() == null;
            }
            case 7: {
                return pSDepSlnPackBase.getPSDepSlnName() == null;
            }
            case 8: {
                return pSDepSlnPackBase.getPSDepSlnPackId() == null;
            }
            case 9: {
                return pSDepSlnPackBase.getPSDepSlnPackName() == null;
            }
            case 10: {
                return pSDepSlnPackBase.getPSDevCenterFileId() == null;
            }
            case 11: {
                return pSDepSlnPackBase.getPSDevCenterFileName() == null;
            }
            case 12: {
                return pSDepSlnPackBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDepSlnPackBase.getUpdateMan() == null;
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
        return PSDepSlnPackBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnPackBase pSDepSlnPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnPackBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnPackBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnPackBase.isDepToolTypeDirty();
            }
            case 3: {
                return pSDepSlnPackBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnPackBase.isPackErrorInfoDirty();
            }
            case 5: {
                return pSDepSlnPackBase.isPackStateDirty();
            }
            case 6: {
                return pSDepSlnPackBase.isPSDepSlnIdDirty();
            }
            case 7: {
                return pSDepSlnPackBase.isPSDepSlnNameDirty();
            }
            case 8: {
                return pSDepSlnPackBase.isPSDepSlnPackIdDirty();
            }
            case 9: {
                return pSDepSlnPackBase.isPSDepSlnPackNameDirty();
            }
            case 10: {
                return pSDepSlnPackBase.isPSDevCenterFileIdDirty();
            }
            case 11: {
                return pSDepSlnPackBase.isPSDevCenterFileNameDirty();
            }
            case 12: {
                return pSDepSlnPackBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDepSlnPackBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnPackBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnPackBase pSDepSlnPackBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnPackBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getDepToolType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deptooltype", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getDepToolType()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPackErrorInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packerrorinfo", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPackErrorInfo()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPackState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packstate", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPackState()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnid", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDepSlnId()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnname", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDepSlnName()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnpackid", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDepSlnPackId()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslnpackname", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDepSlnPackName()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDevCenterFileId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfileid", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDevCenterFileId()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getPSDevCenterFileName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterfilename", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getPSDevCenterFileName()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnPackBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnPackBase.getJSONValue((Object)pSDepSlnPackBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnPackBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnPackBase pSDepSlnPackBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnPackBase.getCreateDate() != null) {
            object = pSDepSlnPackBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnPackBase.getCreateMan() != null) {
            object = pSDepSlnPackBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getDepToolType() != null) {
            object = pSDepSlnPackBase.getDepToolType();
            xmlNode.setAttribute(FIELD_DEPTOOLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getMemo() != null) {
            object = pSDepSlnPackBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPackErrorInfo() != null) {
            object = pSDepSlnPackBase.getPackErrorInfo();
            xmlNode.setAttribute(FIELD_PACKERRORINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPackState() != null) {
            object = pSDepSlnPackBase.getPackState();
            xmlNode.setAttribute(FIELD_PACKSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnId() != null) {
            object = pSDepSlnPackBase.getPSDepSlnId();
            xmlNode.setAttribute(FIELD_PSDEPSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnName() != null) {
            object = pSDepSlnPackBase.getPSDepSlnName();
            xmlNode.setAttribute(FIELD_PSDEPSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnPackId() != null) {
            object = pSDepSlnPackBase.getPSDepSlnPackId();
            xmlNode.setAttribute(FIELD_PSDEPSLNPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPSDepSlnPackName() != null) {
            object = pSDepSlnPackBase.getPSDepSlnPackName();
            xmlNode.setAttribute(FIELD_PSDEPSLNPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPSDevCenterFileId() != null) {
            object = pSDepSlnPackBase.getPSDevCenterFileId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getPSDevCenterFileName() != null) {
            object = pSDepSlnPackBase.getPSDevCenterFileName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERFILENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnPackBase.getUpdateDate() != null) {
            object = pSDepSlnPackBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnPackBase.getUpdateMan() != null) {
            object = pSDepSlnPackBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnPackBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnPackBase pSDepSlnPackBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnPackBase.isCreateDateDirty() && (bl || pSDepSlnPackBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnPackBase.getCreateDate());
        }
        if (pSDepSlnPackBase.isCreateManDirty() && (bl || pSDepSlnPackBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnPackBase.getCreateMan());
        }
        if (pSDepSlnPackBase.isDepToolTypeDirty() && (bl || pSDepSlnPackBase.getDepToolType() != null)) {
            iDataObject.set(FIELD_DEPTOOLTYPE, (Object)pSDepSlnPackBase.getDepToolType());
        }
        if (pSDepSlnPackBase.isMemoDirty() && (bl || pSDepSlnPackBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnPackBase.getMemo());
        }
        if (pSDepSlnPackBase.isPackErrorInfoDirty() && (bl || pSDepSlnPackBase.getPackErrorInfo() != null)) {
            iDataObject.set(FIELD_PACKERRORINFO, (Object)pSDepSlnPackBase.getPackErrorInfo());
        }
        if (pSDepSlnPackBase.isPackStateDirty() && (bl || pSDepSlnPackBase.getPackState() != null)) {
            iDataObject.set(FIELD_PACKSTATE, (Object)pSDepSlnPackBase.getPackState());
        }
        if (pSDepSlnPackBase.isPSDepSlnIdDirty() && (bl || pSDepSlnPackBase.getPSDepSlnId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNID, (Object)pSDepSlnPackBase.getPSDepSlnId());
        }
        if (pSDepSlnPackBase.isPSDepSlnNameDirty() && (bl || pSDepSlnPackBase.getPSDepSlnName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNNAME, (Object)pSDepSlnPackBase.getPSDepSlnName());
        }
        if (pSDepSlnPackBase.isPSDepSlnPackIdDirty() && (bl || pSDepSlnPackBase.getPSDepSlnPackId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPACKID, (Object)pSDepSlnPackBase.getPSDepSlnPackId());
        }
        if (pSDepSlnPackBase.isPSDepSlnPackNameDirty() && (bl || pSDepSlnPackBase.getPSDepSlnPackName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNPACKNAME, (Object)pSDepSlnPackBase.getPSDepSlnPackName());
        }
        if (pSDepSlnPackBase.isPSDevCenterFileIdDirty() && (bl || pSDepSlnPackBase.getPSDevCenterFileId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILEID, (Object)pSDepSlnPackBase.getPSDevCenterFileId());
        }
        if (pSDepSlnPackBase.isPSDevCenterFileNameDirty() && (bl || pSDepSlnPackBase.getPSDevCenterFileName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERFILENAME, (Object)pSDepSlnPackBase.getPSDevCenterFileName());
        }
        if (pSDepSlnPackBase.isUpdateDateDirty() && (bl || pSDepSlnPackBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnPackBase.getUpdateDate());
        }
        if (pSDepSlnPackBase.isUpdateManDirty() && (bl || pSDepSlnPackBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnPackBase.getUpdateMan());
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
        return PSDepSlnPackBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnPackBase pSDepSlnPackBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnPackBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnPackBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnPackBase.resetDepToolType();
                return true;
            }
            case 3: {
                pSDepSlnPackBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnPackBase.resetPackErrorInfo();
                return true;
            }
            case 5: {
                pSDepSlnPackBase.resetPackState();
                return true;
            }
            case 6: {
                pSDepSlnPackBase.resetPSDepSlnId();
                return true;
            }
            case 7: {
                pSDepSlnPackBase.resetPSDepSlnName();
                return true;
            }
            case 8: {
                pSDepSlnPackBase.resetPSDepSlnPackId();
                return true;
            }
            case 9: {
                pSDepSlnPackBase.resetPSDepSlnPackName();
                return true;
            }
            case 10: {
                pSDepSlnPackBase.resetPSDevCenterFileId();
                return true;
            }
            case 11: {
                pSDepSlnPackBase.resetPSDevCenterFileName();
                return true;
            }
            case 12: {
                pSDepSlnPackBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDepSlnPackBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSDepSlnService.autoGet(pSDepSln);
                this.psdepsln = pSDepSln;
            }
            return this.psdepsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterFile getPSDevCenterFile() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterFile();
        }
        if (this.getPSDevCenterFileId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterFileLock;
        synchronized (n) {
            if (this.psdevcenterfile != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterFileId(), (Object)this.psdevcenterfile.getPSDevCenterFileId()) != 0L) {
                this.psdevcenterfile = null;
            }
            if (this.psdevcenterfile == null) {
                PSDevCenterFile pSDevCenterFile = new PSDevCenterFile();
                pSDevCenterFile.setPSDevCenterFileId(this.getPSDevCenterFileId());
                PSDevCenterFileService pSDevCenterFileService = (PSDevCenterFileService)ServiceGlobal.getService(PSDevCenterFileService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterFileService.autoGet(pSDevCenterFile);
                this.psdevcenterfile = pSDevCenterFile;
            }
            return this.psdevcenterfile;
        }
    }

    private PSDepSlnPackBase getProxyEntity() {
        return this.proxyPSDepSlnPackBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnPackBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnPackBase) {
            this.proxyPSDepSlnPackBase = (PSDepSlnPackBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSlnPackService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEPTOOLTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PACKERRORINFO, 4);
        fieldIndexMap.put(FIELD_PACKSTATE, 5);
        fieldIndexMap.put(FIELD_PSDEPSLNID, 6);
        fieldIndexMap.put(FIELD_PSDEPSLNNAME, 7);
        fieldIndexMap.put(FIELD_PSDEPSLNPACKID, 8);
        fieldIndexMap.put(FIELD_PSDEPSLNPACKNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILEID, 10);
        fieldIndexMap.put(FIELD_PSDEVCENTERFILENAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

