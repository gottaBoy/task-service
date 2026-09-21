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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysKeyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysKeyBase.class);
    public static final String FIELD_ADMINMODE = "ADMINMODE";
    public static final String FIELD_BEGINTIME = "BEGINTIME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENDTIME = "ENDTIME";
    public static final String FIELD_KEYCOUNT = "KEYCOUNT";
    public static final String FIELD_KEYSTATE = "KEYSTATE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSKEYID = "PSDEVSLNSYSKEYID";
    public static final String FIELD_PSDEVSLNSYSKEYNAME = "PSDEVSLNSYSKEYNAME";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ADMINMODE = 0;
    private static final int INDEX_BEGINTIME = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_ENDTIME = 4;
    private static final int INDEX_KEYCOUNT = 5;
    private static final int INDEX_KEYSTATE = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERNAME = 8;
    private static final int INDEX_PSDEVSLNSYSID = 9;
    private static final int INDEX_PSDEVSLNSYSKEYID = 10;
    private static final int INDEX_PSDEVSLNSYSKEYNAME = 11;
    private static final int INDEX_PSDEVSLNSYSNAME = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysKeyBase proxyPSDevSlnSysKeyBase = null;
    private boolean adminmodeDirtyFlag = false;
    private boolean begintimeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean endtimeDirtyFlag = false;
    private boolean keycountDirtyFlag = false;
    private boolean keystateDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsyskeyidDirtyFlag = false;
    private boolean psdevslnsyskeynameDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="adminmode")
    private Integer adminmode;
    @Column(name="begintime")
    private Timestamp begintime;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="endtime")
    private Timestamp endtime;
    @Column(name="keycount")
    private Integer keycount;
    @Column(name="keystate")
    private Integer keystate;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsyskeyid")
    private String psdevslnsyskeyid;
    @Column(name="psdevslnsyskeyname")
    private String psdevslnsyskeyname;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;

    public void setAdminMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAdminMode(n);
            return;
        }
        this.adminmode = n;
        this.adminmodeDirtyFlag = true;
    }

    public Integer getAdminMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAdminMode();
        }
        return this.adminmode;
    }

    public boolean isAdminModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAdminModeDirty();
        }
        return this.adminmodeDirtyFlag;
    }

    public void resetAdminMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAdminMode();
            return;
        }
        this.adminmodeDirtyFlag = false;
        this.adminmode = null;
    }

    public void setBeginTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginTime(timestamp);
            return;
        }
        this.begintime = timestamp;
        this.begintimeDirtyFlag = true;
    }

    public Timestamp getBeginTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginTime();
        }
        return this.begintime;
    }

    public boolean isBeginTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginTimeDirty();
        }
        return this.begintimeDirtyFlag;
    }

    public void resetBeginTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginTime();
            return;
        }
        this.begintimeDirtyFlag = false;
        this.begintime = null;
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

    public void setEndTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndTime(timestamp);
            return;
        }
        this.endtime = timestamp;
        this.endtimeDirtyFlag = true;
    }

    public Timestamp getEndTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndTime();
        }
        return this.endtime;
    }

    public boolean isEndTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndTimeDirty();
        }
        return this.endtimeDirtyFlag;
    }

    public void resetEndTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndTime();
            return;
        }
        this.endtimeDirtyFlag = false;
        this.endtime = null;
    }

    public void setKeyCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyCount(n);
            return;
        }
        this.keycount = n;
        this.keycountDirtyFlag = true;
    }

    public Integer getKeyCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyCount();
        }
        return this.keycount;
    }

    public boolean isKeyCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyCountDirty();
        }
        return this.keycountDirtyFlag;
    }

    public void resetKeyCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyCount();
            return;
        }
        this.keycountDirtyFlag = false;
        this.keycount = null;
    }

    public void setKeyState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyState(n);
            return;
        }
        this.keystate = n;
        this.keystateDirtyFlag = true;
    }

    public Integer getKeyState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyState();
        }
        return this.keystate;
    }

    public boolean isKeyStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyStateDirty();
        }
        return this.keystateDirtyFlag;
    }

    public void resetKeyState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyState();
            return;
        }
        this.keystateDirtyFlag = false;
        this.keystate = null;
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

    public void setPSDevSlnSysKeyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysKeyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyskeyid = string;
        this.psdevslnsyskeyidDirtyFlag = true;
    }

    public String getPSDevSlnSysKeyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysKeyId();
        }
        return this.psdevslnsyskeyid;
    }

    public boolean isPSDevSlnSysKeyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysKeyIdDirty();
        }
        return this.psdevslnsyskeyidDirtyFlag;
    }

    public void resetPSDevSlnSysKeyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysKeyId();
            return;
        }
        this.psdevslnsyskeyidDirtyFlag = false;
        this.psdevslnsyskeyid = null;
    }

    public void setPSDevSlnSysKeyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysKeyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsyskeyname = string;
        this.psdevslnsyskeynameDirtyFlag = true;
    }

    public String getPSDevSlnSysKeyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysKeyName();
        }
        return this.psdevslnsyskeyname;
    }

    public boolean isPSDevSlnSysKeyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysKeyNameDirty();
        }
        return this.psdevslnsyskeynameDirtyFlag;
    }

    public void resetPSDevSlnSysKeyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysKeyName();
            return;
        }
        this.psdevslnsyskeynameDirtyFlag = false;
        this.psdevslnsyskeyname = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
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
        PSDevSlnSysKeyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysKeyBase pSDevSlnSysKeyBase) {
        pSDevSlnSysKeyBase.resetAdminMode();
        pSDevSlnSysKeyBase.resetBeginTime();
        pSDevSlnSysKeyBase.resetCreateDate();
        pSDevSlnSysKeyBase.resetCreateMan();
        pSDevSlnSysKeyBase.resetEndTime();
        pSDevSlnSysKeyBase.resetKeyCount();
        pSDevSlnSysKeyBase.resetKeyState();
        pSDevSlnSysKeyBase.resetPSDevCenterId();
        pSDevSlnSysKeyBase.resetPSDevCenterName();
        pSDevSlnSysKeyBase.resetPSDevSlnSysId();
        pSDevSlnSysKeyBase.resetPSDevSlnSysKeyId();
        pSDevSlnSysKeyBase.resetPSDevSlnSysKeyName();
        pSDevSlnSysKeyBase.resetPSDevSlnSysName();
        pSDevSlnSysKeyBase.resetUpdateDate();
        pSDevSlnSysKeyBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAdminModeDirty()) {
            hashMap.put(FIELD_ADMINMODE, this.getAdminMode());
        }
        if (!bl || this.isBeginTimeDirty()) {
            hashMap.put(FIELD_BEGINTIME, this.getBeginTime());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEndTimeDirty()) {
            hashMap.put(FIELD_ENDTIME, this.getEndTime());
        }
        if (!bl || this.isKeyCountDirty()) {
            hashMap.put(FIELD_KEYCOUNT, this.getKeyCount());
        }
        if (!bl || this.isKeyStateDirty()) {
            hashMap.put(FIELD_KEYSTATE, this.getKeyState());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysKeyIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSKEYID, this.getPSDevSlnSysKeyId());
        }
        if (!bl || this.isPSDevSlnSysKeyNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSKEYNAME, this.getPSDevSlnSysKeyName());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
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
        return PSDevSlnSysKeyBase.get(this, n);
    }

    private static Object get(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysKeyBase.getAdminMode();
            }
            case 1: {
                return pSDevSlnSysKeyBase.getBeginTime();
            }
            case 2: {
                return pSDevSlnSysKeyBase.getCreateDate();
            }
            case 3: {
                return pSDevSlnSysKeyBase.getCreateMan();
            }
            case 4: {
                return pSDevSlnSysKeyBase.getEndTime();
            }
            case 5: {
                return pSDevSlnSysKeyBase.getKeyCount();
            }
            case 6: {
                return pSDevSlnSysKeyBase.getKeyState();
            }
            case 7: {
                return pSDevSlnSysKeyBase.getPSDevCenterId();
            }
            case 8: {
                return pSDevSlnSysKeyBase.getPSDevCenterName();
            }
            case 9: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysId();
            }
            case 10: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysKeyId();
            }
            case 11: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysKeyName();
            }
            case 12: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysName();
            }
            case 13: {
                return pSDevSlnSysKeyBase.getUpdateDate();
            }
            case 14: {
                return pSDevSlnSysKeyBase.getUpdateMan();
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
        PSDevSlnSysKeyBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysKeyBase.setAdminMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysKeyBase.setBeginTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysKeyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysKeyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysKeyBase.setEndTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysKeyBase.setKeyCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysKeyBase.setKeyState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysKeyBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysKeyBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysKeyBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysKeyBase.setPSDevSlnSysKeyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysKeyBase.setPSDevSlnSysKeyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysKeyBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysKeyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysKeyBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysKeyBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysKeyBase.getAdminMode() == null;
            }
            case 1: {
                return pSDevSlnSysKeyBase.getBeginTime() == null;
            }
            case 2: {
                return pSDevSlnSysKeyBase.getCreateDate() == null;
            }
            case 3: {
                return pSDevSlnSysKeyBase.getCreateMan() == null;
            }
            case 4: {
                return pSDevSlnSysKeyBase.getEndTime() == null;
            }
            case 5: {
                return pSDevSlnSysKeyBase.getKeyCount() == null;
            }
            case 6: {
                return pSDevSlnSysKeyBase.getKeyState() == null;
            }
            case 7: {
                return pSDevSlnSysKeyBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDevSlnSysKeyBase.getPSDevCenterName() == null;
            }
            case 9: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysId() == null;
            }
            case 10: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysKeyId() == null;
            }
            case 11: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysKeyName() == null;
            }
            case 12: {
                return pSDevSlnSysKeyBase.getPSDevSlnSysName() == null;
            }
            case 13: {
                return pSDevSlnSysKeyBase.getUpdateDate() == null;
            }
            case 14: {
                return pSDevSlnSysKeyBase.getUpdateMan() == null;
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
        return PSDevSlnSysKeyBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysKeyBase.isAdminModeDirty();
            }
            case 1: {
                return pSDevSlnSysKeyBase.isBeginTimeDirty();
            }
            case 2: {
                return pSDevSlnSysKeyBase.isCreateDateDirty();
            }
            case 3: {
                return pSDevSlnSysKeyBase.isCreateManDirty();
            }
            case 4: {
                return pSDevSlnSysKeyBase.isEndTimeDirty();
            }
            case 5: {
                return pSDevSlnSysKeyBase.isKeyCountDirty();
            }
            case 6: {
                return pSDevSlnSysKeyBase.isKeyStateDirty();
            }
            case 7: {
                return pSDevSlnSysKeyBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDevSlnSysKeyBase.isPSDevCenterNameDirty();
            }
            case 9: {
                return pSDevSlnSysKeyBase.isPSDevSlnSysIdDirty();
            }
            case 10: {
                return pSDevSlnSysKeyBase.isPSDevSlnSysKeyIdDirty();
            }
            case 11: {
                return pSDevSlnSysKeyBase.isPSDevSlnSysKeyNameDirty();
            }
            case 12: {
                return pSDevSlnSysKeyBase.isPSDevSlnSysNameDirty();
            }
            case 13: {
                return pSDevSlnSysKeyBase.isUpdateDateDirty();
            }
            case 14: {
                return pSDevSlnSysKeyBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysKeyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysKeyBase.getAdminMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"adminmode", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getAdminMode()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getBeginTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"begintime", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getBeginTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getEndTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endtime", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getEndTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getKeyCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keycount", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getKeyCount()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getKeyState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keystate", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getKeyState()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyskeyid", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevSlnSysKeyId()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsyskeyname", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevSlnSysKeyName()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysKeyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysKeyBase.getJSONValue((Object)pSDevSlnSysKeyBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysKeyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysKeyBase.getAdminMode() != null) {
            object = pSDevSlnSysKeyBase.getAdminMode();
            xmlNode.setAttribute(FIELD_ADMINMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getBeginTime() != null) {
            object = pSDevSlnSysKeyBase.getBeginTime();
            xmlNode.setAttribute(FIELD_BEGINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getCreateDate() != null) {
            object = pSDevSlnSysKeyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getCreateMan() != null) {
            object = pSDevSlnSysKeyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getEndTime() != null) {
            object = pSDevSlnSysKeyBase.getEndTime();
            xmlNode.setAttribute(FIELD_ENDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getKeyCount() != null) {
            object = pSDevSlnSysKeyBase.getKeyCount();
            xmlNode.setAttribute(FIELD_KEYCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getKeyState() != null) {
            object = pSDevSlnSysKeyBase.getKeyState();
            xmlNode.setAttribute(FIELD_KEYSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysKeyBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysKeyBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysKeyBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyId() != null) {
            object = pSDevSlnSysKeyBase.getPSDevSlnSysKeyId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSKEYID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyName() != null) {
            object = pSDevSlnSysKeyBase.getPSDevSlnSysKeyName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSKEYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysKeyBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysKeyBase.getUpdateDate() != null) {
            object = pSDevSlnSysKeyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysKeyBase.getUpdateMan() != null) {
            object = pSDevSlnSysKeyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysKeyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysKeyBase.isAdminModeDirty() && (bl || pSDevSlnSysKeyBase.getAdminMode() != null)) {
            iDataObject.set(FIELD_ADMINMODE, (Object)pSDevSlnSysKeyBase.getAdminMode());
        }
        if (pSDevSlnSysKeyBase.isBeginTimeDirty() && (bl || pSDevSlnSysKeyBase.getBeginTime() != null)) {
            iDataObject.set(FIELD_BEGINTIME, (Object)pSDevSlnSysKeyBase.getBeginTime());
        }
        if (pSDevSlnSysKeyBase.isCreateDateDirty() && (bl || pSDevSlnSysKeyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysKeyBase.getCreateDate());
        }
        if (pSDevSlnSysKeyBase.isCreateManDirty() && (bl || pSDevSlnSysKeyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysKeyBase.getCreateMan());
        }
        if (pSDevSlnSysKeyBase.isEndTimeDirty() && (bl || pSDevSlnSysKeyBase.getEndTime() != null)) {
            iDataObject.set(FIELD_ENDTIME, (Object)pSDevSlnSysKeyBase.getEndTime());
        }
        if (pSDevSlnSysKeyBase.isKeyCountDirty() && (bl || pSDevSlnSysKeyBase.getKeyCount() != null)) {
            iDataObject.set(FIELD_KEYCOUNT, (Object)pSDevSlnSysKeyBase.getKeyCount());
        }
        if (pSDevSlnSysKeyBase.isKeyStateDirty() && (bl || pSDevSlnSysKeyBase.getKeyState() != null)) {
            iDataObject.set(FIELD_KEYSTATE, (Object)pSDevSlnSysKeyBase.getKeyState());
        }
        if (pSDevSlnSysKeyBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysKeyBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysKeyBase.getPSDevCenterId());
        }
        if (pSDevSlnSysKeyBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysKeyBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysKeyBase.getPSDevCenterName());
        }
        if (pSDevSlnSysKeyBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysKeyBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysKeyBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysKeyBase.isPSDevSlnSysKeyIdDirty() && (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSKEYID, (Object)pSDevSlnSysKeyBase.getPSDevSlnSysKeyId());
        }
        if (pSDevSlnSysKeyBase.isPSDevSlnSysKeyNameDirty() && (bl || pSDevSlnSysKeyBase.getPSDevSlnSysKeyName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSKEYNAME, (Object)pSDevSlnSysKeyBase.getPSDevSlnSysKeyName());
        }
        if (pSDevSlnSysKeyBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysKeyBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysKeyBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysKeyBase.isUpdateDateDirty() && (bl || pSDevSlnSysKeyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysKeyBase.getUpdateDate());
        }
        if (pSDevSlnSysKeyBase.isUpdateManDirty() && (bl || pSDevSlnSysKeyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysKeyBase.getUpdateMan());
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
        return PSDevSlnSysKeyBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysKeyBase pSDevSlnSysKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysKeyBase.resetAdminMode();
                return true;
            }
            case 1: {
                pSDevSlnSysKeyBase.resetBeginTime();
                return true;
            }
            case 2: {
                pSDevSlnSysKeyBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDevSlnSysKeyBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDevSlnSysKeyBase.resetEndTime();
                return true;
            }
            case 5: {
                pSDevSlnSysKeyBase.resetKeyCount();
                return true;
            }
            case 6: {
                pSDevSlnSysKeyBase.resetKeyState();
                return true;
            }
            case 7: {
                pSDevSlnSysKeyBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDevSlnSysKeyBase.resetPSDevCenterName();
                return true;
            }
            case 9: {
                pSDevSlnSysKeyBase.resetPSDevSlnSysId();
                return true;
            }
            case 10: {
                pSDevSlnSysKeyBase.resetPSDevSlnSysKeyId();
                return true;
            }
            case 11: {
                pSDevSlnSysKeyBase.resetPSDevSlnSysKeyName();
                return true;
            }
            case 12: {
                pSDevSlnSysKeyBase.resetPSDevSlnSysName();
                return true;
            }
            case 13: {
                pSDevSlnSysKeyBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSDevSlnSysKeyBase.resetUpdateMan();
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
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    private PSDevSlnSysKeyBase getProxyEntity() {
        return this.proxyPSDevSlnSysKeyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysKeyBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysKeyBase) {
            this.proxyPSDevSlnSysKeyBase = (PSDevSlnSysKeyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevSlnSysKeyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ADMINMODE, 0);
        fieldIndexMap.put(FIELD_BEGINTIME, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_ENDTIME, 4);
        fieldIndexMap.put(FIELD_KEYCOUNT, 5);
        fieldIndexMap.put(FIELD_KEYSTATE, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 8);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 9);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSKEYID, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSKEYNAME, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

