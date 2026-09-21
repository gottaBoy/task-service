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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.devcenter.entity.PSDCMobAppTDRef;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTDRefService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMobAppTestDeviceBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMobAppTestDeviceBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEVICEID = "DEVICEID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OSTYPE = "OSTYPE";
    public static final String FIELD_OSVER = "OSVER";
    public static final String FIELD_PSDCMOBAPPTESTDEVICEID = "PSDCMOBAPPTESTDEVICEID";
    public static final String FIELD_PSDCMOBAPPTESTDEVICENAME = "PSDCMOBAPPTESTDEVICENAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REFCOUNT = "REFCOUNT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEVICEID = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_OSTYPE = 4;
    private static final int INDEX_OSVER = 5;
    private static final int INDEX_PSDCMOBAPPTESTDEVICEID = 6;
    private static final int INDEX_PSDCMOBAPPTESTDEVICENAME = 7;
    private static final int INDEX_PSDEVCENTERID = 8;
    private static final int INDEX_PSDEVCENTERNAME = 9;
    private static final int INDEX_REFCOUNT = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMobAppTestDeviceBase proxyPSDCMobAppTestDeviceBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean deviceidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ostypeDirtyFlag = false;
    private boolean osverDirtyFlag = false;
    private boolean psdcmobapptestdeviceidDirtyFlag = false;
    private boolean psdcmobapptestdevicenameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean refcountDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="deviceid")
    private String deviceid;
    @Column(name="memo")
    private String memo;
    @Column(name="ostype")
    private String ostype;
    @Column(name="osver")
    private String osver;
    @Column(name="psdcmobapptestdeviceid")
    private String psdcmobapptestdeviceid;
    @Column(name="psdcmobapptestdevicename")
    private String psdcmobapptestdevicename;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="refcount")
    private Integer refcount;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDCMobAppTDRefsLock = new Integer(1);
    private ArrayList<PSDCMobAppTDRef> psdcmobapptdrefs = null;

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

    public void setDeviceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDeviceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviceid = string;
        this.deviceidDirtyFlag = true;
    }

    public String getDeviceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDeviceId();
        }
        return this.deviceid;
    }

    public boolean isDeviceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDeviceIdDirty();
        }
        return this.deviceidDirtyFlag;
    }

    public void resetDeviceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDeviceId();
            return;
        }
        this.deviceidDirtyFlag = false;
        this.deviceid = null;
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

    public void setOSType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ostype = string;
        this.ostypeDirtyFlag = true;
    }

    public String getOSType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSType();
        }
        return this.ostype;
    }

    public boolean isOSTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSTypeDirty();
        }
        return this.ostypeDirtyFlag;
    }

    public void resetOSType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSType();
            return;
        }
        this.ostypeDirtyFlag = false;
        this.ostype = null;
    }

    public void setOSVer(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOSVer(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.osver = string;
        this.osverDirtyFlag = true;
    }

    public String getOSVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOSVer();
        }
        return this.osver;
    }

    public boolean isOSVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOSVerDirty();
        }
        return this.osverDirtyFlag;
    }

    public void resetOSVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOSVer();
            return;
        }
        this.osverDirtyFlag = false;
        this.osver = null;
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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setRefCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefCount(n);
            return;
        }
        this.refcount = n;
        this.refcountDirtyFlag = true;
    }

    public Integer getRefCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefCount();
        }
        return this.refcount;
    }

    public boolean isRefCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefCountDirty();
        }
        return this.refcountDirtyFlag;
    }

    public void resetRefCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefCount();
            return;
        }
        this.refcountDirtyFlag = false;
        this.refcount = null;
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
        PSDCMobAppTestDeviceBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase) {
        pSDCMobAppTestDeviceBase.resetCreateDate();
        pSDCMobAppTestDeviceBase.resetCreateMan();
        pSDCMobAppTestDeviceBase.resetDeviceId();
        pSDCMobAppTestDeviceBase.resetMemo();
        pSDCMobAppTestDeviceBase.resetOSType();
        pSDCMobAppTestDeviceBase.resetOSVer();
        pSDCMobAppTestDeviceBase.resetPSDCMobAppTestDeviceId();
        pSDCMobAppTestDeviceBase.resetPSDCMobAppTestDeviceName();
        pSDCMobAppTestDeviceBase.resetPSDevCenterId();
        pSDCMobAppTestDeviceBase.resetPSDevCenterName();
        pSDCMobAppTestDeviceBase.resetRefCount();
        pSDCMobAppTestDeviceBase.resetUpdateDate();
        pSDCMobAppTestDeviceBase.resetUpdateMan();
        pSDCMobAppTestDeviceBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDeviceIdDirty()) {
            hashMap.put(FIELD_DEVICEID, this.getDeviceId());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOSTypeDirty()) {
            hashMap.put(FIELD_OSTYPE, this.getOSType());
        }
        if (!bl || this.isOSVerDirty()) {
            hashMap.put(FIELD_OSVER, this.getOSVer());
        }
        if (!bl || this.isPSDCMobAppTestDeviceIdDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, this.getPSDCMobAppTestDeviceId());
        }
        if (!bl || this.isPSDCMobAppTestDeviceNameDirty()) {
            hashMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, this.getPSDCMobAppTestDeviceName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isRefCountDirty()) {
            hashMap.put(FIELD_REFCOUNT, this.getRefCount());
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
        return PSDCMobAppTestDeviceBase.get(this, n);
    }

    private static Object get(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTestDeviceBase.getCreateDate();
            }
            case 1: {
                return pSDCMobAppTestDeviceBase.getCreateMan();
            }
            case 2: {
                return pSDCMobAppTestDeviceBase.getDeviceId();
            }
            case 3: {
                return pSDCMobAppTestDeviceBase.getMemo();
            }
            case 4: {
                return pSDCMobAppTestDeviceBase.getOSType();
            }
            case 5: {
                return pSDCMobAppTestDeviceBase.getOSVer();
            }
            case 6: {
                return pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId();
            }
            case 7: {
                return pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName();
            }
            case 8: {
                return pSDCMobAppTestDeviceBase.getPSDevCenterId();
            }
            case 9: {
                return pSDCMobAppTestDeviceBase.getPSDevCenterName();
            }
            case 10: {
                return pSDCMobAppTestDeviceBase.getRefCount();
            }
            case 11: {
                return pSDCMobAppTestDeviceBase.getUpdateDate();
            }
            case 12: {
                return pSDCMobAppTestDeviceBase.getUpdateMan();
            }
            case 13: {
                return pSDCMobAppTestDeviceBase.getValidFlag();
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
        PSDCMobAppTestDeviceBase.set(this, n, object);
    }

    private static void set(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobAppTestDeviceBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCMobAppTestDeviceBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMobAppTestDeviceBase.setDeviceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMobAppTestDeviceBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMobAppTestDeviceBase.setOSType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMobAppTestDeviceBase.setOSVer(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMobAppTestDeviceBase.setPSDCMobAppTestDeviceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCMobAppTestDeviceBase.setPSDCMobAppTestDeviceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMobAppTestDeviceBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCMobAppTestDeviceBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCMobAppTestDeviceBase.setRefCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDCMobAppTestDeviceBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCMobAppTestDeviceBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDCMobAppTestDeviceBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCMobAppTestDeviceBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTestDeviceBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCMobAppTestDeviceBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCMobAppTestDeviceBase.getDeviceId() == null;
            }
            case 3: {
                return pSDCMobAppTestDeviceBase.getMemo() == null;
            }
            case 4: {
                return pSDCMobAppTestDeviceBase.getOSType() == null;
            }
            case 5: {
                return pSDCMobAppTestDeviceBase.getOSVer() == null;
            }
            case 6: {
                return pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId() == null;
            }
            case 7: {
                return pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName() == null;
            }
            case 8: {
                return pSDCMobAppTestDeviceBase.getPSDevCenterId() == null;
            }
            case 9: {
                return pSDCMobAppTestDeviceBase.getPSDevCenterName() == null;
            }
            case 10: {
                return pSDCMobAppTestDeviceBase.getRefCount() == null;
            }
            case 11: {
                return pSDCMobAppTestDeviceBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCMobAppTestDeviceBase.getUpdateMan() == null;
            }
            case 13: {
                return pSDCMobAppTestDeviceBase.getValidFlag() == null;
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
        return PSDCMobAppTestDeviceBase.contains(this, n);
    }

    private static boolean contains(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMobAppTestDeviceBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCMobAppTestDeviceBase.isCreateManDirty();
            }
            case 2: {
                return pSDCMobAppTestDeviceBase.isDeviceIdDirty();
            }
            case 3: {
                return pSDCMobAppTestDeviceBase.isMemoDirty();
            }
            case 4: {
                return pSDCMobAppTestDeviceBase.isOSTypeDirty();
            }
            case 5: {
                return pSDCMobAppTestDeviceBase.isOSVerDirty();
            }
            case 6: {
                return pSDCMobAppTestDeviceBase.isPSDCMobAppTestDeviceIdDirty();
            }
            case 7: {
                return pSDCMobAppTestDeviceBase.isPSDCMobAppTestDeviceNameDirty();
            }
            case 8: {
                return pSDCMobAppTestDeviceBase.isPSDevCenterIdDirty();
            }
            case 9: {
                return pSDCMobAppTestDeviceBase.isPSDevCenterNameDirty();
            }
            case 10: {
                return pSDCMobAppTestDeviceBase.isRefCountDirty();
            }
            case 11: {
                return pSDCMobAppTestDeviceBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCMobAppTestDeviceBase.isUpdateManDirty();
            }
            case 13: {
                return pSDCMobAppTestDeviceBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMobAppTestDeviceBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMobAppTestDeviceBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getDeviceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviceid", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getDeviceId()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getOSType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ostype", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getOSType()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getOSVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"osver", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getOSVer()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdeviceid", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmobapptestdevicename", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getRefCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refcount", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getRefCount()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMobAppTestDeviceBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMobAppTestDeviceBase.getJSONValue((Object)pSDCMobAppTestDeviceBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMobAppTestDeviceBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMobAppTestDeviceBase.getCreateDate() != null) {
            object = pSDCMobAppTestDeviceBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobAppTestDeviceBase.getCreateMan() != null) {
            object = pSDCMobAppTestDeviceBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getDeviceId() != null) {
            object = pSDCMobAppTestDeviceBase.getDeviceId();
            xmlNode.setAttribute(FIELD_DEVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getMemo() != null) {
            object = pSDCMobAppTestDeviceBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getOSType() != null) {
            object = pSDCMobAppTestDeviceBase.getOSType();
            xmlNode.setAttribute(FIELD_OSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getOSVer() != null) {
            object = pSDCMobAppTestDeviceBase.getOSVer();
            xmlNode.setAttribute(FIELD_OSVER, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId() != null) {
            object = pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName() != null) {
            object = pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName();
            xmlNode.setAttribute(FIELD_PSDCMOBAPPTESTDEVICENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDevCenterId() != null) {
            object = pSDCMobAppTestDeviceBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getPSDevCenterName() != null) {
            object = pSDCMobAppTestDeviceBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getRefCount() != null) {
            object = pSDCMobAppTestDeviceBase.getRefCount();
            xmlNode.setAttribute(FIELD_REFCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDCMobAppTestDeviceBase.getUpdateDate() != null) {
            object = pSDCMobAppTestDeviceBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMobAppTestDeviceBase.getUpdateMan() != null) {
            object = pSDCMobAppTestDeviceBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMobAppTestDeviceBase.getValidFlag() != null) {
            object = pSDCMobAppTestDeviceBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMobAppTestDeviceBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMobAppTestDeviceBase.isCreateDateDirty() && (bl || pSDCMobAppTestDeviceBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMobAppTestDeviceBase.getCreateDate());
        }
        if (pSDCMobAppTestDeviceBase.isCreateManDirty() && (bl || pSDCMobAppTestDeviceBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMobAppTestDeviceBase.getCreateMan());
        }
        if (pSDCMobAppTestDeviceBase.isDeviceIdDirty() && (bl || pSDCMobAppTestDeviceBase.getDeviceId() != null)) {
            iDataObject.set(FIELD_DEVICEID, (Object)pSDCMobAppTestDeviceBase.getDeviceId());
        }
        if (pSDCMobAppTestDeviceBase.isMemoDirty() && (bl || pSDCMobAppTestDeviceBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCMobAppTestDeviceBase.getMemo());
        }
        if (pSDCMobAppTestDeviceBase.isOSTypeDirty() && (bl || pSDCMobAppTestDeviceBase.getOSType() != null)) {
            iDataObject.set(FIELD_OSTYPE, (Object)pSDCMobAppTestDeviceBase.getOSType());
        }
        if (pSDCMobAppTestDeviceBase.isOSVerDirty() && (bl || pSDCMobAppTestDeviceBase.getOSVer() != null)) {
            iDataObject.set(FIELD_OSVER, (Object)pSDCMobAppTestDeviceBase.getOSVer());
        }
        if (pSDCMobAppTestDeviceBase.isPSDCMobAppTestDeviceIdDirty() && (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICEID, (Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceId());
        }
        if (pSDCMobAppTestDeviceBase.isPSDCMobAppTestDeviceNameDirty() && (bl || pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName() != null)) {
            iDataObject.set(FIELD_PSDCMOBAPPTESTDEVICENAME, (Object)pSDCMobAppTestDeviceBase.getPSDCMobAppTestDeviceName());
        }
        if (pSDCMobAppTestDeviceBase.isPSDevCenterIdDirty() && (bl || pSDCMobAppTestDeviceBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCMobAppTestDeviceBase.getPSDevCenterId());
        }
        if (pSDCMobAppTestDeviceBase.isPSDevCenterNameDirty() && (bl || pSDCMobAppTestDeviceBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCMobAppTestDeviceBase.getPSDevCenterName());
        }
        if (pSDCMobAppTestDeviceBase.isRefCountDirty() && (bl || pSDCMobAppTestDeviceBase.getRefCount() != null)) {
            iDataObject.set(FIELD_REFCOUNT, (Object)pSDCMobAppTestDeviceBase.getRefCount());
        }
        if (pSDCMobAppTestDeviceBase.isUpdateDateDirty() && (bl || pSDCMobAppTestDeviceBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMobAppTestDeviceBase.getUpdateDate());
        }
        if (pSDCMobAppTestDeviceBase.isUpdateManDirty() && (bl || pSDCMobAppTestDeviceBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMobAppTestDeviceBase.getUpdateMan());
        }
        if (pSDCMobAppTestDeviceBase.isValidFlagDirty() && (bl || pSDCMobAppTestDeviceBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMobAppTestDeviceBase.getValidFlag());
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
        return PSDCMobAppTestDeviceBase.remove(this, n);
    }

    private static boolean remove(PSDCMobAppTestDeviceBase pSDCMobAppTestDeviceBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMobAppTestDeviceBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCMobAppTestDeviceBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCMobAppTestDeviceBase.resetDeviceId();
                return true;
            }
            case 3: {
                pSDCMobAppTestDeviceBase.resetMemo();
                return true;
            }
            case 4: {
                pSDCMobAppTestDeviceBase.resetOSType();
                return true;
            }
            case 5: {
                pSDCMobAppTestDeviceBase.resetOSVer();
                return true;
            }
            case 6: {
                pSDCMobAppTestDeviceBase.resetPSDCMobAppTestDeviceId();
                return true;
            }
            case 7: {
                pSDCMobAppTestDeviceBase.resetPSDCMobAppTestDeviceName();
                return true;
            }
            case 8: {
                pSDCMobAppTestDeviceBase.resetPSDevCenterId();
                return true;
            }
            case 9: {
                pSDCMobAppTestDeviceBase.resetPSDevCenterName();
                return true;
            }
            case 10: {
                pSDCMobAppTestDeviceBase.resetRefCount();
                return true;
            }
            case 11: {
                pSDCMobAppTestDeviceBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCMobAppTestDeviceBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSDCMobAppTestDeviceBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDCMobAppTDRef> getPSDCMobAppTDRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMobAppTDRefs();
        }
        if (this.getPSDCMobAppTestDeviceId() == null) {
            return null;
        }
        PSDCMobAppTDRefService pSDCMobAppTDRefService = (PSDCMobAppTDRefService)ServiceGlobal.getService(PSDCMobAppTDRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDCMobAppTDRefsLock;
        synchronized (n) {
            if (this.psdcmobapptdrefs == null) {
                this.psdcmobapptdrefs = pSDCMobAppTDRefService.selectByPSDCMobAppTestDevice(this);
            }
            return this.psdcmobapptdrefs;
        }
    }

    private PSDCMobAppTestDeviceBase getProxyEntity() {
        return this.proxyPSDCMobAppTestDeviceBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMobAppTestDeviceBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMobAppTestDeviceBase) {
            this.proxyPSDCMobAppTestDeviceBase = (PSDCMobAppTestDeviceBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMobAppTestDeviceService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEVICEID, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_OSTYPE, 4);
        fieldIndexMap.put(FIELD_OSVER, 5);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICEID, 6);
        fieldIndexMap.put(FIELD_PSDCMOBAPPTESTDEVICENAME, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 9);
        fieldIndexMap.put(FIELD_REFCOUNT, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

