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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSysVer;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysPatchBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysPatchBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FROMPSDEVSLNSYSVERID = "FROMPSDEVSLNSYSVERID";
    public static final String FIELD_FROMPSDEVSLNSYSVERNAME = "FROMPSDEVSLNSYSVERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSPATCHID = "PSDEVSLNSYSPATCHID";
    public static final String FIELD_PSDEVSLNSYSPATCHNAME = "PSDEVSLNSYSPATCHNAME";
    public static final String FIELD_PSDEVSLNSYSVERID = "PSDEVSLNSYSVERID";
    public static final String FIELD_PSDEVSLNSYSVERNAME = "PSDEVSLNSYSVERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FROMPSDEVSLNSYSVERID = 2;
    private static final int INDEX_FROMPSDEVSLNSYSVERNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEVSLNSYSID = 5;
    private static final int INDEX_PSDEVSLNSYSPATCHID = 6;
    private static final int INDEX_PSDEVSLNSYSPATCHNAME = 7;
    private static final int INDEX_PSDEVSLNSYSVERID = 8;
    private static final int INDEX_PSDEVSLNSYSVERNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysPatchBase proxyPSDevSlnSysPatchBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean frompsdevslnsysveridDirtyFlag = false;
    private boolean frompsdevslnsysvernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsyspatchidDirtyFlag = false;
    private boolean psdevslnsyspatchnameDirtyFlag = false;
    private boolean psdevslnsysveridDirtyFlag = false;
    private boolean psdevslnsysvernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="frompsdevslnsysverid")
    private String frompsdevslnsysverid;
    @Column(name="frompsdevslnsysvername")
    private String frompsdevslnsysvername;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsyspatchid")
    private String psdevslnsyspatchid;
    @Column(name="psdevslnsyspatchname")
    private String psdevslnsyspatchname;
    @Column(name="psdevslnsysverid")
    private String psdevslnsysverid;
    @Column(name="psdevslnsysvername")
    private String psdevslnsysvername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objFromPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer frompsdevslnsysver = null;
    private Integer objPSDevSlnSysVerLock = new Integer(1);
    private PSDevSlnSysVer psdevslnsysver = null;

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

    public void setFromPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdevslnsysverid = string;
        this.frompsdevslnsysveridDirtyFlag = true;
    }

    public String getFromPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDevSlnSysVerId();
        }
        return this.frompsdevslnsysverid;
    }

    public boolean isFromPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDevSlnSysVerIdDirty();
        }
        return this.frompsdevslnsysveridDirtyFlag;
    }

    public void resetFromPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDevSlnSysVerId();
            return;
        }
        this.frompsdevslnsysveridDirtyFlag = false;
        this.frompsdevslnsysverid = null;
    }

    public void setFromPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.frompsdevslnsysvername = string;
        this.frompsdevslnsysvernameDirtyFlag = true;
    }

    public String getFromPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDevSlnSysVerName();
        }
        return this.frompsdevslnsysvername;
    }

    public boolean isFromPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromPSDevSlnSysVerNameDirty();
        }
        return this.frompsdevslnsysvernameDirtyFlag;
    }

    public void resetFromPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromPSDevSlnSysVerName();
            return;
        }
        this.frompsdevslnsysvernameDirtyFlag = false;
        this.frompsdevslnsysvername = null;
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

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysPatchId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysPatchId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyspatchid = string;
        this.psdevslnsyspatchidDirtyFlag = true;
    }

    public String getPSDevSlnSysPatchId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysPatchId();
        }
        return this.psdevslnsyspatchid;
    }

    public boolean isPSDevSlnSysPatchIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysPatchIdDirty();
        }
        return this.psdevslnsyspatchidDirtyFlag;
    }

    public void resetPSDevSlnSysPatchId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysPatchId();
            return;
        }
        this.psdevslnsyspatchidDirtyFlag = false;
        this.psdevslnsyspatchid = null;
    }

    public void setPSDevSlnSysPatchName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysPatchName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyspatchname = string;
        this.psdevslnsyspatchnameDirtyFlag = true;
    }

    public String getPSDevSlnSysPatchName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysPatchName();
        }
        return this.psdevslnsyspatchname;
    }

    public boolean isPSDevSlnSysPatchNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysPatchNameDirty();
        }
        return this.psdevslnsyspatchnameDirtyFlag;
    }

    public void resetPSDevSlnSysPatchName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysPatchName();
            return;
        }
        this.psdevslnsyspatchnameDirtyFlag = false;
        this.psdevslnsyspatchname = null;
    }

    public void setPSDevSlnSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysverid = string;
        this.psdevslnsysveridDirtyFlag = true;
    }

    public String getPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerId();
        }
        return this.psdevslnsysverid;
    }

    public boolean isPSDevSlnSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerIdDirty();
        }
        return this.psdevslnsysveridDirtyFlag;
    }

    public void resetPSDevSlnSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerId();
            return;
        }
        this.psdevslnsysveridDirtyFlag = false;
        this.psdevslnsysverid = null;
    }

    public void setPSDevSlnSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysvername = string;
        this.psdevslnsysvernameDirtyFlag = true;
    }

    public String getPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVerName();
        }
        return this.psdevslnsysvername;
    }

    public boolean isPSDevSlnSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysVerNameDirty();
        }
        return this.psdevslnsysvernameDirtyFlag;
    }

    public void resetPSDevSlnSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysVerName();
            return;
        }
        this.psdevslnsysvernameDirtyFlag = false;
        this.psdevslnsysvername = null;
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
        PSDevSlnSysPatchBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysPatchBase pSDevSlnSysPatchBase) {
        pSDevSlnSysPatchBase.resetCreateDate();
        pSDevSlnSysPatchBase.resetCreateMan();
        pSDevSlnSysPatchBase.resetFromPSDevSlnSysVerId();
        pSDevSlnSysPatchBase.resetFromPSDevSlnSysVerName();
        pSDevSlnSysPatchBase.resetMemo();
        pSDevSlnSysPatchBase.resetPSDevSlnSysId();
        pSDevSlnSysPatchBase.resetPSDevSlnSysPatchId();
        pSDevSlnSysPatchBase.resetPSDevSlnSysPatchName();
        pSDevSlnSysPatchBase.resetPSDevSlnSysVerId();
        pSDevSlnSysPatchBase.resetPSDevSlnSysVerName();
        pSDevSlnSysPatchBase.resetUpdateDate();
        pSDevSlnSysPatchBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFromPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_FROMPSDEVSLNSYSVERID, this.getFromPSDevSlnSysVerId());
        }
        if (!bl || this.isFromPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_FROMPSDEVSLNSYSVERNAME, this.getFromPSDevSlnSysVerName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysPatchIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSPATCHID, this.getPSDevSlnSysPatchId());
        }
        if (!bl || this.isPSDevSlnSysPatchNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSPATCHNAME, this.getPSDevSlnSysPatchName());
        }
        if (!bl || this.isPSDevSlnSysVerIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERID, this.getPSDevSlnSysVerId());
        }
        if (!bl || this.isPSDevSlnSysVerNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSVERNAME, this.getPSDevSlnSysVerName());
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
        return PSDevSlnSysPatchBase.get(this, n);
    }

    private static Object get(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPatchBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysPatchBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId();
            }
            case 3: {
                return pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName();
            }
            case 4: {
                return pSDevSlnSysPatchBase.getMemo();
            }
            case 5: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysId();
            }
            case 6: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysPatchId();
            }
            case 7: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysPatchName();
            }
            case 8: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysVerId();
            }
            case 9: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysVerName();
            }
            case 10: {
                return pSDevSlnSysPatchBase.getUpdateDate();
            }
            case 11: {
                return pSDevSlnSysPatchBase.getUpdateMan();
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
        PSDevSlnSysPatchBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysPatchBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysPatchBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysPatchBase.setFromPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysPatchBase.setFromPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysPatchBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysPatchBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysPatchBase.setPSDevSlnSysPatchId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysPatchBase.setPSDevSlnSysPatchName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysPatchBase.setPSDevSlnSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysPatchBase.setPSDevSlnSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysPatchBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysPatchBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysPatchBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPatchBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysPatchBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId() == null;
            }
            case 3: {
                return pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName() == null;
            }
            case 4: {
                return pSDevSlnSysPatchBase.getMemo() == null;
            }
            case 5: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysId() == null;
            }
            case 6: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysPatchId() == null;
            }
            case 7: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysPatchName() == null;
            }
            case 8: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysVerId() == null;
            }
            case 9: {
                return pSDevSlnSysPatchBase.getPSDevSlnSysVerName() == null;
            }
            case 10: {
                return pSDevSlnSysPatchBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDevSlnSysPatchBase.getUpdateMan() == null;
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
        return PSDevSlnSysPatchBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysPatchBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysPatchBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysPatchBase.isFromPSDevSlnSysVerIdDirty();
            }
            case 3: {
                return pSDevSlnSysPatchBase.isFromPSDevSlnSysVerNameDirty();
            }
            case 4: {
                return pSDevSlnSysPatchBase.isMemoDirty();
            }
            case 5: {
                return pSDevSlnSysPatchBase.isPSDevSlnSysIdDirty();
            }
            case 6: {
                return pSDevSlnSysPatchBase.isPSDevSlnSysPatchIdDirty();
            }
            case 7: {
                return pSDevSlnSysPatchBase.isPSDevSlnSysPatchNameDirty();
            }
            case 8: {
                return pSDevSlnSysPatchBase.isPSDevSlnSysVerIdDirty();
            }
            case 9: {
                return pSDevSlnSysPatchBase.isPSDevSlnSysVerNameDirty();
            }
            case 10: {
                return pSDevSlnSysPatchBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDevSlnSysPatchBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysPatchBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysPatchBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdevslnsysverid", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"frompsdevslnsysvername", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyspatchid", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getPSDevSlnSysPatchId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyspatchname", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getPSDevSlnSysPatchName()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysverid", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getPSDevSlnSysVerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysvername", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getPSDevSlnSysVerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysPatchBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysPatchBase.getJSONValue((Object)pSDevSlnSysPatchBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysPatchBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysPatchBase.getCreateDate() != null) {
            object = pSDevSlnSysPatchBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysPatchBase.getCreateMan() != null) {
            object = pSDevSlnSysPatchBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId() != null) {
            object = pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_FROMPSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName() != null) {
            object = pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_FROMPSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getMemo() != null) {
            object = pSDevSlnSysPatchBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysPatchBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchId() != null) {
            object = pSDevSlnSysPatchBase.getPSDevSlnSysPatchId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSPATCHID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchName() != null) {
            object = pSDevSlnSysPatchBase.getPSDevSlnSysPatchName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSPATCHNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerId() != null) {
            object = pSDevSlnSysPatchBase.getPSDevSlnSysVerId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerName() != null) {
            object = pSDevSlnSysPatchBase.getPSDevSlnSysVerName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysPatchBase.getUpdateDate() != null) {
            object = pSDevSlnSysPatchBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysPatchBase.getUpdateMan() != null) {
            object = pSDevSlnSysPatchBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysPatchBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysPatchBase.isCreateDateDirty() && (bl || pSDevSlnSysPatchBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysPatchBase.getCreateDate());
        }
        if (pSDevSlnSysPatchBase.isCreateManDirty() && (bl || pSDevSlnSysPatchBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysPatchBase.getCreateMan());
        }
        if (pSDevSlnSysPatchBase.isFromPSDevSlnSysVerIdDirty() && (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_FROMPSDEVSLNSYSVERID, (Object)pSDevSlnSysPatchBase.getFromPSDevSlnSysVerId());
        }
        if (pSDevSlnSysPatchBase.isFromPSDevSlnSysVerNameDirty() && (bl || pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_FROMPSDEVSLNSYSVERNAME, (Object)pSDevSlnSysPatchBase.getFromPSDevSlnSysVerName());
        }
        if (pSDevSlnSysPatchBase.isMemoDirty() && (bl || pSDevSlnSysPatchBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysPatchBase.getMemo());
        }
        if (pSDevSlnSysPatchBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysPatchBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysPatchBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysPatchBase.isPSDevSlnSysPatchIdDirty() && (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSPATCHID, (Object)pSDevSlnSysPatchBase.getPSDevSlnSysPatchId());
        }
        if (pSDevSlnSysPatchBase.isPSDevSlnSysPatchNameDirty() && (bl || pSDevSlnSysPatchBase.getPSDevSlnSysPatchName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSPATCHNAME, (Object)pSDevSlnSysPatchBase.getPSDevSlnSysPatchName());
        }
        if (pSDevSlnSysPatchBase.isPSDevSlnSysVerIdDirty() && (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERID, (Object)pSDevSlnSysPatchBase.getPSDevSlnSysVerId());
        }
        if (pSDevSlnSysPatchBase.isPSDevSlnSysVerNameDirty() && (bl || pSDevSlnSysPatchBase.getPSDevSlnSysVerName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSVERNAME, (Object)pSDevSlnSysPatchBase.getPSDevSlnSysVerName());
        }
        if (pSDevSlnSysPatchBase.isUpdateDateDirty() && (bl || pSDevSlnSysPatchBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysPatchBase.getUpdateDate());
        }
        if (pSDevSlnSysPatchBase.isUpdateManDirty() && (bl || pSDevSlnSysPatchBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysPatchBase.getUpdateMan());
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
        return PSDevSlnSysPatchBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysPatchBase pSDevSlnSysPatchBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysPatchBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysPatchBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysPatchBase.resetFromPSDevSlnSysVerId();
                return true;
            }
            case 3: {
                pSDevSlnSysPatchBase.resetFromPSDevSlnSysVerName();
                return true;
            }
            case 4: {
                pSDevSlnSysPatchBase.resetMemo();
                return true;
            }
            case 5: {
                pSDevSlnSysPatchBase.resetPSDevSlnSysId();
                return true;
            }
            case 6: {
                pSDevSlnSysPatchBase.resetPSDevSlnSysPatchId();
                return true;
            }
            case 7: {
                pSDevSlnSysPatchBase.resetPSDevSlnSysPatchName();
                return true;
            }
            case 8: {
                pSDevSlnSysPatchBase.resetPSDevSlnSysVerId();
                return true;
            }
            case 9: {
                pSDevSlnSysPatchBase.resetPSDevSlnSysVerName();
                return true;
            }
            case 10: {
                pSDevSlnSysPatchBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDevSlnSysPatchBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getFromPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromPSDevSlnSysVer();
        }
        if (this.getFromPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objFromPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.frompsdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getFromPSDevSlnSysVerId(), (Object)this.frompsdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.frompsdevslnsysver = null;
            }
            if (this.frompsdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getFromPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet(pSDevSlnSysVer);
                this.frompsdevslnsysver = pSDevSlnSysVer;
            }
            return this.frompsdevslnsysver;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysVer getPSDevSlnSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysVer();
        }
        if (this.getPSDevSlnSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysVerLock;
        synchronized (n) {
            if (this.psdevslnsysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysVerId(), (Object)this.psdevslnsysver.getPSDevSlnSysVerId()) != 0L) {
                this.psdevslnsysver = null;
            }
            if (this.psdevslnsysver == null) {
                PSDevSlnSysVer pSDevSlnSysVer = new PSDevSlnSysVer();
                pSDevSlnSysVer.setPSDevSlnSysVerId(this.getPSDevSlnSysVerId());
                PSDevSlnSysVerService pSDevSlnSysVerService = (PSDevSlnSysVerService)ServiceGlobal.getService(PSDevSlnSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysVerService.autoGet(pSDevSlnSysVer);
                this.psdevslnsysver = pSDevSlnSysVer;
            }
            return this.psdevslnsysver;
        }
    }

    private PSDevSlnSysPatchBase getProxyEntity() {
        return this.proxyPSDevSlnSysPatchBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysPatchBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysPatchBase) {
            this.proxyPSDevSlnSysPatchBase = (PSDevSlnSysPatchBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysPatchService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FROMPSDEVSLNSYSVERID, 2);
        fieldIndexMap.put(FIELD_FROMPSDEVSLNSYSVERNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSPATCHID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSPATCHNAME, 7);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERID, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSVERNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

