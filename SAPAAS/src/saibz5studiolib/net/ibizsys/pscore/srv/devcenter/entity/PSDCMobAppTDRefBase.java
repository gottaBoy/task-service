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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTestDevice;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMobAppTDRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMobAppTDRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCMOBAPPTDREFID = "PSDCMOBAPPTDREFID";
    public static final String FIELD_PSDCMOBAPPTDREFNAME = "PSDCMOBAPPTDREFNAME";
    public static final String FIELD_PSDCMOBAPPTESTDEVICEID = "PSDCMOBAPPTESTDEVICEID";
    public static final String FIELD_PSDCMOBAPPTESTDEVICENAME = "PSDCMOBAPPTESTDEVICENAME";
    public static final String FIELD_REFPSOBJID = "REFPSOBJID";
    public static final String FIELD_REFPSOBJNAME = "REFPSOBJNAME";
    public static final String FIELD_REFPSOBJTYPE = "REFPSOBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCMOBAPPTDREFID = 3;
    private static final int INDEX_PSDCMOBAPPTDREFNAME = 4;
    private static final int INDEX_PSDCMOBAPPTESTDEVICEID = 5;
    private static final int INDEX_PSDCMOBAPPTESTDEVICENAME = 6;
    private static final int INDEX_REFPSOBJID = 7;
    private static final int INDEX_REFPSOBJNAME = 8;
    private static final int INDEX_REFPSOBJTYPE = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMobAppTDRefBase proxyPSDCMobAppTDRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcmobapptdrefidDirtyFlag = false;
    private boolean psdcmobapptdrefnameDirtyFlag = false;
    private boolean psdcmobapptestdeviceidDirtyFlag = false;
    private boolean psdcmobapptestdevicenameDirtyFlag = false;
    private boolean refpsobjidDirtyFlag = false;
    private boolean refpsobjnameDirtyFlag = false;
    private boolean refpsobjtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcmobapptdrefid")
    private String psdcmobapptdrefid;
    @Column(name="psdcmobapptdrefname")
    private String psdcmobapptdrefname;
    @Column(name="psdcmobapptestdeviceid")
    private String psdcmobapptestdeviceid;
    @Column(name="psdcmobapptestdevicename")
    private String psdcmobapptestdevicename;
    @Column(name="refpsobjid")
    private String refpsobjid;
    @Column(name="refpsobjname")
    private String refpsobjname;
    @Column(name="refpsobjtype")
    private String refpsobjtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDCMobAppTestDeviceLock = new Integer(1);
    private PSDCMobAppTestDevice psdcmobapptestdevice = null;

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

    public void setPSDCMobAppTDRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTDRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptdrefid = string;
        this.psdcmobapptdrefidDirtyFlag = true;
    }

    public String getPSDCMobAppTDRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTDRefId();
        }
        return this.psdcmobapptdrefid;
    }

    public boolean isPSDCMobAppTDRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTDRefIdDirty();
        }
        return this.psdcmobapptdrefidDirtyFlag;
    }

    public void resetPSDCMobAppTDRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTDRefId();
            return;
        }
        this.psdcmobapptdrefidDirtyFlag = false;
        this.psdcmobapptdrefid = null;
    }

    public void setPSDCMobAppTDRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTDRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptdrefname = string;
        this.psdcmobapptdrefnameDirtyFlag = true;
    }

    public String getPSDCMobAppTDRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTDRefName();
        }
        return this.psdcmobapptdrefname;
    }

    public boolean isPSDCMobAppTDRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTDRefNameDirty();
        }
        return this.psdcmobapptdrefnameDirtyFlag;
    }

    public void resetPSDCMobAppTDRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTDRefName();
            return;
        }
        this.psdcmobapptdrefnameDirtyFlag = false;
        this.psdcmobapptdrefname = null;
    }

    public void setPSDCMobAppTestDeviceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTestDeviceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptestdeviceid = string;
        this.psdcmobapptestdeviceidDirtyFlag = true;
    }

    public String getPSDCMobAppTestDeviceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDeviceId();
        }
        return this.psdcmobapptestdeviceid;
    }

    public boolean isPSDCMobAppTestDeviceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTestDeviceIdDirty();
        }
        return this.psdcmobapptestdeviceidDirtyFlag;
    }

    public void resetPSDCMobAppTestDeviceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTestDeviceId();
            return;
        }
        this.psdcmobapptestdeviceidDirtyFlag = false;
        this.psdcmobapptestdeviceid = null;
    }

    public void setPSDCMobAppTestDeviceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMobAppTestDeviceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmobapptestdevicename = string;
        this.psdcmobapptestdevicenameDirtyFlag = true;
    }

    public String getPSDCMobAppTestDeviceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDeviceName();
        }
        return this.psdcmobapptestdevicename;
    }

    public boolean isPSDCMobAppTestDeviceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMobAppTestDeviceNameDirty();
        }
        return this.psdcmobapptestdevicenameDirtyFlag;
    }

    public void resetPSDCMobAppTestDeviceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMobAppTestDeviceName();
            return;
        }
        this.psdcmobapptestdevicenameDirtyFlag = false;
        this.psdcmobapptestdevicename = null;
    }

    public void setRefPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsobjid = string;
        this.refpsobjidDirtyFlag = true;
    }

    public String getRefPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSObjId();
        }
        return this.refpsobjid;
    }

    public boolean isRefPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSObjIdDirty();
        }
        return this.refpsobjidDirtyFlag;
    }

    public void resetRefPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSObjId();
            return;
        }
        this.refpsobjidDirtyFlag = false;
        this.refpsobjid = null;
    }

    public void setRefPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsobjname = string;
        this.refpsobjnameDirtyFlag = true;
    }

    public String getRefPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSObjName();
        }
        return this.refpsobjname;
    }

    public boolean isRefPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSObjNameDirty();
        }
        return this.refpsobjnameDirtyFlag;
    }

    public void resetRefPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSObjName();
            return;
        }
        this.refpsobjnameDirtyFlag = false;
        this.refpsobjname = null;
    }

    public void setRefPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsobjtype = string;
        this.refpsobjtypeDirtyFlag = true;
    }

    public String getRefPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSObjType();
        }
        return this.refpsobjtype;
    }

    public boolean isRefPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSObjTypeDirty();
        }
        return this.refpsobjtypeDirtyFlag;
    }

    public void resetRefPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSObjType();
            return;
        }
        this.refpsobjtypeDirtyFlag = false;
        this.refpsobjtype = null;
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
        PSDCMobAppTDRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMobAppTDRefBase pSDCMobAppTDRefBase) {
        pSDCMobAppTDRefBase.resetCreateDate();
        pSDCMobAppTDRefBase.resetCreateMan();
        pSDCMobAppTDRefBase.resetMemo();
        pSDCMobAppTDRefBase.resetPSDCMobAppTDRefId();
        pSDCMobAppTDRefBase.resetPSDCMobAppTDRefName();
        pSDCMobAppTDRefBase.resetPSDCMobAppTestDeviceId();
        pSDCMobAppTDRefBase.resetPSDCMobAppTestDeviceName();
        pSDCMobAppTDRefBase.resetRefPSObjId();
        pSDCMobAppTDRefBase.resetRefPSObjName();
        pSDCMobAppTDRefBase.resetRefPSObjType();
        pSDCMobAppTDRefBase.resetUpdateDate();
        pSDCMobAppTDRefBase.resetUpdateMan();
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
        if (!bl || this.isPSDCMobAppTDRefIdDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTDREFID, this.getPSDCMobAppTDRefId());
        }
        if (!bl || this.isPSDCMobAppTDRefNameDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTDREFNAME, this.getPSDCMobAppTDRefName());
        }
        if (!bl || this.isPSDCMobAppTestDeviceIdDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, this.getPSDCMobAppTestDeviceId());
        }
        if (!bl || this.isPSDCMobAppTestDeviceNameDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, this.getPSDCMobAppTestDeviceName());
        }
        if (!bl || this.isRefPSObjIdDirty()) {
            hashMap.put(FIELD_REFPSOBJID, this.getRefPSObjId());
        }
        if (!bl || this.isRefPSObjNameDirty()) {
            hashMap.put(FIELD_REFPSOBJNAME, this.getRefPSObjName());
        }
        if (!bl || this.isRefPSObjTypeDirty()) {
            hashMap.put(FIELD_REFPSOBJTYPE, this.getRefPSObjType());
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
        return PSDCMobAppTDRefBase.get(this, n);
    }

    private static Object get(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTDRefBase.getCreateDate();
            }
            case 1: {
                return pSDCMobAppTDRefBase.getCreateMan();
            }
            case 2: {
                return pSDCMobAppTDRefBase.getMemo();
            }
            case 3: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTDRefId();
            }
            case 4: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTDRefName();
            }
            case 5: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId();
            }
            case 6: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName();
            }
            case 7: {
                return pSDCMobAppTDRefBase.getRefPSObjId();
            }
            case 8: {
                return pSDCMobAppTDRefBase.getRefPSObjName();
            }
            case 9: {
                return pSDCMobAppTDRefBase.getRefPSObjType();
            }
            case 10: {
                return pSDCMobAppTDRefBase.getUpdateDate();
            }
            case 11: {
                return pSDCMobAppTDRefBase.getUpdateMan();
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
        PSDCMobAppTDRefBase.set(this, n, object);
    }

    private static void set(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobAppTDRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCMobAppTDRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMobAppTDRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMobAppTDRefBase.setPSDCMobAppTDRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMobAppTDRefBase.setPSDCMobAppTDRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMobAppTDRefBase.setPSDCMobAppTestDeviceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMobAppTDRefBase.setPSDCMobAppTestDeviceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMobAppTDRefBase.setRefPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMobAppTDRefBase.setRefPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMobAppTDRefBase.setRefPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMobAppTDRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDCMobAppTDRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCMobAppTDRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTDRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCMobAppTDRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCMobAppTDRefBase.getMemo() == null;
            }
            case 3: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTDRefId() == null;
            }
            case 4: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTDRefName() == null;
            }
            case 5: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId() == null;
            }
            case 6: {
                return pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName() == null;
            }
            case 7: {
                return pSDCMobAppTDRefBase.getRefPSObjId() == null;
            }
            case 8: {
                return pSDCMobAppTDRefBase.getRefPSObjName() == null;
            }
            case 9: {
                return pSDCMobAppTDRefBase.getRefPSObjType() == null;
            }
            case 10: {
                return pSDCMobAppTDRefBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDCMobAppTDRefBase.getUpdateMan() == null;
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
        return PSDCMobAppTDRefBase.contains(this, n);
    }

    private static boolean contains(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTDRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCMobAppTDRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDCMobAppTDRefBase.isMemoDirty();
            }
            case 3: {
                return pSDCMobAppTDRefBase.isPSDCMobAppTDRefIdDirty();
            }
            case 4: {
                return pSDCMobAppTDRefBase.isPSDCMobAppTDRefNameDirty();
            }
            case 5: {
                return pSDCMobAppTDRefBase.isPSDCMobAppTestDeviceIdDirty();
            }
            case 6: {
                return pSDCMobAppTDRefBase.isPSDCMobAppTestDeviceNameDirty();
            }
            case 7: {
                return pSDCMobAppTDRefBase.isRefPSObjIdDirty();
            }
            case 8: {
                return pSDCMobAppTDRefBase.isRefPSObjNameDirty();
            }
            case 9: {
                return pSDCMobAppTDRefBase.isRefPSObjTypeDirty();
            }
            case 10: {
                return pSDCMobAppTDRefBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDCMobAppTDRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMobAppTDRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMobAppTDRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptdrefid", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getPSDCMobAppTDRefId()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptdrefname", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getPSDCMobAppTDRefName()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdeviceid", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdevicename", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsobjid", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getRefPSObjId()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsobjname", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getRefPSObjName()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsobjtype", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getRefPSObjType()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMobAppTDRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMobAppTDRefBase.getJSONValue((Object)pSDCMobAppTDRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMobAppTDRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMobAppTDRefBase.getCreateDate() != null) {
            object = pSDCMobAppTDRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobAppTDRefBase.getCreateMan() != null) {
            object = pSDCMobAppTDRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getMemo() != null) {
            object = pSDCMobAppTDRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefId() != null) {
            object = pSDCMobAppTDRefBase.getPSDCMobAppTDRefId();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTDREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefName() != null) {
            object = pSDCMobAppTDRefBase.getPSDCMobAppTDRefName();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTDREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId() != null) {
            object = pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName() != null) {
            object = pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjId() != null) {
            object = pSDCMobAppTDRefBase.getRefPSObjId();
            xmlNode.setAttribute(FIELD_REFPSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjName() != null) {
            object = pSDCMobAppTDRefBase.getRefPSObjName();
            xmlNode.setAttribute(FIELD_REFPSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getRefPSObjType() != null) {
            object = pSDCMobAppTDRefBase.getRefPSObjType();
            xmlNode.setAttribute(FIELD_REFPSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTDRefBase.getUpdateDate() != null) {
            object = pSDCMobAppTDRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobAppTDRefBase.getUpdateMan() != null) {
            object = pSDCMobAppTDRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMobAppTDRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMobAppTDRefBase.isCreateDateDirty() && (bl || pSDCMobAppTDRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMobAppTDRefBase.getCreateDate());
        }
        if (pSDCMobAppTDRefBase.isCreateManDirty() && (bl || pSDCMobAppTDRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMobAppTDRefBase.getCreateMan());
        }
        if (pSDCMobAppTDRefBase.isMemoDirty() && (bl || pSDCMobAppTDRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMobAppTDRefBase.getMemo());
        }
        if (pSDCMobAppTDRefBase.isPSDCMobAppTDRefIdDirty() && (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefId() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTDREFID, (Object)pSDCMobAppTDRefBase.getPSDCMobAppTDRefId());
        }
        if (pSDCMobAppTDRefBase.isPSDCMobAppTDRefNameDirty() && (bl || pSDCMobAppTDRefBase.getPSDCMobAppTDRefName() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTDREFNAME, (Object)pSDCMobAppTDRefBase.getPSDCMobAppTDRefName());
        }
        if (pSDCMobAppTDRefBase.isPSDCMobAppTestDeviceIdDirty() && (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICEID, (Object)pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceId());
        }
        if (pSDCMobAppTDRefBase.isPSDCMobAppTestDeviceNameDirty() && (bl || pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICENAME, (Object)pSDCMobAppTDRefBase.getPSDCMobAppTestDeviceName());
        }
        if (pSDCMobAppTDRefBase.isRefPSObjIdDirty() && (bl || pSDCMobAppTDRefBase.getRefPSObjId() != null)) {
            iDataObject.set(FIELD_REFPSOBJID, (Object)pSDCMobAppTDRefBase.getRefPSObjId());
        }
        if (pSDCMobAppTDRefBase.isRefPSObjNameDirty() && (bl || pSDCMobAppTDRefBase.getRefPSObjName() != null)) {
            iDataObject.set(FIELD_REFPSOBJNAME, (Object)pSDCMobAppTDRefBase.getRefPSObjName());
        }
        if (pSDCMobAppTDRefBase.isRefPSObjTypeDirty() && (bl || pSDCMobAppTDRefBase.getRefPSObjType() != null)) {
            iDataObject.set(FIELD_REFPSOBJTYPE, (Object)pSDCMobAppTDRefBase.getRefPSObjType());
        }
        if (pSDCMobAppTDRefBase.isUpdateDateDirty() && (bl || pSDCMobAppTDRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMobAppTDRefBase.getUpdateDate());
        }
        if (pSDCMobAppTDRefBase.isUpdateManDirty() && (bl || pSDCMobAppTDRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMobAppTDRefBase.getUpdateMan());
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
        return PSDCMobAppTDRefBase.remove(this, n);
    }

    private static boolean remove(PSDCMobAppTDRefBase pSDCMobAppTDRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobAppTDRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCMobAppTDRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCMobAppTDRefBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCMobAppTDRefBase.resetPSDCMobAppTDRefId();
                return true;
            }
            case 4: {
                pSDCMobAppTDRefBase.resetPSDCMobAppTDRefName();
                return true;
            }
            case 5: {
                pSDCMobAppTDRefBase.resetPSDCMobAppTestDeviceId();
                return true;
            }
            case 6: {
                pSDCMobAppTDRefBase.resetPSDCMobAppTestDeviceName();
                return true;
            }
            case 7: {
                pSDCMobAppTDRefBase.resetRefPSObjId();
                return true;
            }
            case 8: {
                pSDCMobAppTDRefBase.resetRefPSObjName();
                return true;
            }
            case 9: {
                pSDCMobAppTDRefBase.resetRefPSObjType();
                return true;
            }
            case 10: {
                pSDCMobAppTDRefBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDCMobAppTDRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCMobAppTestDevice getPSDCMobAppTestDevice() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTestDevice();
        }
        if (this.getPSDCMobAppTestDeviceId() == null) {
            return null;
        }
        Integer n = this.objPSDCMobAppTestDeviceLock;
        synchronized (n) {
            if (this.psdcmobapptestdevice != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCMobAppTestDeviceId(), (Object)this.psdcmobapptestdevice.getPSDCMobAppTestDeviceId()) != 0L) {
                this.psdcmobapptestdevice = null;
            }
            if (this.psdcmobapptestdevice == null) {
                PSDCMobAppTestDevice pSDCMobAppTestDevice = new PSDCMobAppTestDevice();
                pSDCMobAppTestDevice.setPSDCMobAppTestDeviceId(this.getPSDCMobAppTestDeviceId());
                PSDCMobAppTestDeviceService pSDCMobAppTestDeviceService = (PSDCMobAppTestDeviceService)ServiceGlobal.getService(PSDCMobAppTestDeviceService.class, (SessionFactory)this.getSessionFactory());
                pSDCMobAppTestDeviceService.autoGet(pSDCMobAppTestDevice);
                this.psdcmobapptestdevice = pSDCMobAppTestDevice;
            }
            return this.psdcmobapptestdevice;
        }
    }

    private PSDCMobAppTDRefBase getProxyEntity() {
        return this.proxyPSDCMobAppTDRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMobAppTDRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMobAppTDRefBase) {
            this.proxyPSDCMobAppTDRefBase = (PSDCMobAppTDRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTDREFID, 3);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTDREFNAME, 4);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, 5);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, 6);
        fieldIndexMap.put(FIELD_REFPSOBJID, 7);
        fieldIndexMap.put(FIELD_REFPSOBJNAME, 8);
        fieldIndexMap.put(FIELD_REFPSOBJTYPE, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

