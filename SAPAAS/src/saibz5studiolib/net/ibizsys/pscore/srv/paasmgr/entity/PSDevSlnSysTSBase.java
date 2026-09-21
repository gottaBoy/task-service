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
package net.ibizsys.pscore.srv.paasmgr.entity;

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
import net.ibizsys.pscore.srv.paasmgr.entity.PSTaskServer;
import net.ibizsys.pscore.srv.paasmgr.service.PSTaskServerService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysTSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysTSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOADTIME = "LOADTIME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_PSDEVSLNSYSTSID = "PSDEVSLNSYSTSID";
    public static final String FIELD_PSDEVSLNSYSTSNAME = "PSDEVSLNSYSTSNAME";
    public static final String FIELD_PSTASKSERVERID = "PSTASKSERVERID";
    public static final String FIELD_PSTASKSERVERNAME = "PSTASKSERVERNAME";
    public static final String FIELD_UNLOADTIME = "UNLOADTIME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOADTIME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVSLNSYSID = 4;
    private static final int INDEX_PSDEVSLNSYSNAME = 5;
    private static final int INDEX_PSDEVSLNSYSTSID = 6;
    private static final int INDEX_PSDEVSLNSYSTSNAME = 7;
    private static final int INDEX_PSTASKSERVERID = 8;
    private static final int INDEX_PSTASKSERVERNAME = 9;
    private static final int INDEX_UNLOADTIME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysTSBase proxyPSDevSlnSysTSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean loadtimeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean psdevslnsystsidDirtyFlag = false;
    private boolean psdevslnsystsnameDirtyFlag = false;
    private boolean pstaskserveridDirtyFlag = false;
    private boolean pstaskservernameDirtyFlag = false;
    private boolean unloadtimeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="loadtime")
    private Timestamp loadtime;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="psdevslnsystsid")
    private String psdevslnsystsid;
    @Column(name="psdevslnsystsname")
    private String psdevslnsystsname;
    @Column(name="pstaskserverid")
    private String pstaskserverid;
    @Column(name="pstaskservername")
    private String pstaskservername;
    @Column(name="unloadtime")
    private Timestamp unloadtime;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSTaskServerLock = new Integer(1);
    private PSTaskServer pstaskserver = null;

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

    public void setLoadTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLoadTime(timestamp);
            return;
        }
        this.loadtime = timestamp;
        this.loadtimeDirtyFlag = true;
    }

    public Timestamp getLoadTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLoadTime();
        }
        return this.loadtime;
    }

    public boolean isLoadTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLoadTimeDirty();
        }
        return this.loadtimeDirtyFlag;
    }

    public void resetLoadTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLoadTime();
            return;
        }
        this.loadtimeDirtyFlag = false;
        this.loadtime = null;
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

    public void setPSDevSlnSysTSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysTSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsystsid = string;
        this.psdevslnsystsidDirtyFlag = true;
    }

    public String getPSDevSlnSysTSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysTSId();
        }
        return this.psdevslnsystsid;
    }

    public boolean isPSDevSlnSysTSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysTSIdDirty();
        }
        return this.psdevslnsystsidDirtyFlag;
    }

    public void resetPSDevSlnSysTSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysTSId();
            return;
        }
        this.psdevslnsystsidDirtyFlag = false;
        this.psdevslnsystsid = null;
    }

    public void setPSDevSlnSysTSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysTSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsystsname = string;
        this.psdevslnsystsnameDirtyFlag = true;
    }

    public String getPSDevSlnSysTSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysTSName();
        }
        return this.psdevslnsystsname;
    }

    public boolean isPSDevSlnSysTSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysTSNameDirty();
        }
        return this.psdevslnsystsnameDirtyFlag;
    }

    public void resetPSDevSlnSysTSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysTSName();
            return;
        }
        this.psdevslnsystsnameDirtyFlag = false;
        this.psdevslnsystsname = null;
    }

    public void setPSTaskServerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskserverid = string;
        this.pstaskserveridDirtyFlag = true;
    }

    public String getPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerId();
        }
        return this.pstaskserverid;
    }

    public boolean isPSTaskServerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerIdDirty();
        }
        return this.pstaskserveridDirtyFlag;
    }

    public void resetPSTaskServerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerId();
            return;
        }
        this.pstaskserveridDirtyFlag = false;
        this.pstaskserverid = null;
    }

    public void setPSTaskServerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSTaskServerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pstaskservername = string;
        this.pstaskservernameDirtyFlag = true;
    }

    public String getPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServerName();
        }
        return this.pstaskservername;
    }

    public boolean isPSTaskServerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSTaskServerNameDirty();
        }
        return this.pstaskservernameDirtyFlag;
    }

    public void resetPSTaskServerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSTaskServerName();
            return;
        }
        this.pstaskservernameDirtyFlag = false;
        this.pstaskservername = null;
    }

    public void setUnloadTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUnloadTime(timestamp);
            return;
        }
        this.unloadtime = timestamp;
        this.unloadtimeDirtyFlag = true;
    }

    public Timestamp getUnloadTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUnloadTime();
        }
        return this.unloadtime;
    }

    public boolean isUnloadTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUnloadTimeDirty();
        }
        return this.unloadtimeDirtyFlag;
    }

    public void resetUnloadTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUnloadTime();
            return;
        }
        this.unloadtimeDirtyFlag = false;
        this.unloadtime = null;
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
        PSDevSlnSysTSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysTSBase pSDevSlnSysTSBase) {
        pSDevSlnSysTSBase.resetCreateDate();
        pSDevSlnSysTSBase.resetCreateMan();
        pSDevSlnSysTSBase.resetLoadTime();
        pSDevSlnSysTSBase.resetMemo();
        pSDevSlnSysTSBase.resetPSDevSlnSysId();
        pSDevSlnSysTSBase.resetPSDevSlnSysName();
        pSDevSlnSysTSBase.resetPSDevSlnSysTSId();
        pSDevSlnSysTSBase.resetPSDevSlnSysTSName();
        pSDevSlnSysTSBase.resetPSTaskServerId();
        pSDevSlnSysTSBase.resetPSTaskServerName();
        pSDevSlnSysTSBase.resetUnloadTime();
        pSDevSlnSysTSBase.resetUpdateDate();
        pSDevSlnSysTSBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLoadTimeDirty()) {
            hashMap.put(FIELD_LOADTIME, this.getLoadTime());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isPSDevSlnSysTSIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSTSID, this.getPSDevSlnSysTSId());
        }
        if (!bl || this.isPSDevSlnSysTSNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSTSNAME, this.getPSDevSlnSysTSName());
        }
        if (!bl || this.isPSTaskServerIdDirty()) {
            hashMap.put(FIELD_PSTASKSERVERID, this.getPSTaskServerId());
        }
        if (!bl || this.isPSTaskServerNameDirty()) {
            hashMap.put(FIELD_PSTASKSERVERNAME, this.getPSTaskServerName());
        }
        if (!bl || this.isUnloadTimeDirty()) {
            hashMap.put(FIELD_UNLOADTIME, this.getUnloadTime());
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
        return PSDevSlnSysTSBase.get(this, n);
    }

    private static Object get(PSDevSlnSysTSBase pSDevSlnSysTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysTSBase.getCreateDate();
            }
            case 1: {
                return pSDevSlnSysTSBase.getCreateMan();
            }
            case 2: {
                return pSDevSlnSysTSBase.getLoadTime();
            }
            case 3: {
                return pSDevSlnSysTSBase.getMemo();
            }
            case 4: {
                return pSDevSlnSysTSBase.getPSDevSlnSysId();
            }
            case 5: {
                return pSDevSlnSysTSBase.getPSDevSlnSysName();
            }
            case 6: {
                return pSDevSlnSysTSBase.getPSDevSlnSysTSId();
            }
            case 7: {
                return pSDevSlnSysTSBase.getPSDevSlnSysTSName();
            }
            case 8: {
                return pSDevSlnSysTSBase.getPSTaskServerId();
            }
            case 9: {
                return pSDevSlnSysTSBase.getPSTaskServerName();
            }
            case 10: {
                return pSDevSlnSysTSBase.getUnloadTime();
            }
            case 11: {
                return pSDevSlnSysTSBase.getUpdateDate();
            }
            case 12: {
                return pSDevSlnSysTSBase.getUpdateMan();
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
        PSDevSlnSysTSBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysTSBase pSDevSlnSysTSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysTSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysTSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysTSBase.setLoadTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysTSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysTSBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysTSBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysTSBase.setPSDevSlnSysTSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysTSBase.setPSDevSlnSysTSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysTSBase.setPSTaskServerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysTSBase.setPSTaskServerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysTSBase.setUnloadTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysTSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysTSBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevSlnSysTSBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysTSBase pSDevSlnSysTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysTSBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevSlnSysTSBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevSlnSysTSBase.getLoadTime() == null;
            }
            case 3: {
                return pSDevSlnSysTSBase.getMemo() == null;
            }
            case 4: {
                return pSDevSlnSysTSBase.getPSDevSlnSysId() == null;
            }
            case 5: {
                return pSDevSlnSysTSBase.getPSDevSlnSysName() == null;
            }
            case 6: {
                return pSDevSlnSysTSBase.getPSDevSlnSysTSId() == null;
            }
            case 7: {
                return pSDevSlnSysTSBase.getPSDevSlnSysTSName() == null;
            }
            case 8: {
                return pSDevSlnSysTSBase.getPSTaskServerId() == null;
            }
            case 9: {
                return pSDevSlnSysTSBase.getPSTaskServerName() == null;
            }
            case 10: {
                return pSDevSlnSysTSBase.getUnloadTime() == null;
            }
            case 11: {
                return pSDevSlnSysTSBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDevSlnSysTSBase.getUpdateMan() == null;
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
        return PSDevSlnSysTSBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysTSBase pSDevSlnSysTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysTSBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevSlnSysTSBase.isCreateManDirty();
            }
            case 2: {
                return pSDevSlnSysTSBase.isLoadTimeDirty();
            }
            case 3: {
                return pSDevSlnSysTSBase.isMemoDirty();
            }
            case 4: {
                return pSDevSlnSysTSBase.isPSDevSlnSysIdDirty();
            }
            case 5: {
                return pSDevSlnSysTSBase.isPSDevSlnSysNameDirty();
            }
            case 6: {
                return pSDevSlnSysTSBase.isPSDevSlnSysTSIdDirty();
            }
            case 7: {
                return pSDevSlnSysTSBase.isPSDevSlnSysTSNameDirty();
            }
            case 8: {
                return pSDevSlnSysTSBase.isPSTaskServerIdDirty();
            }
            case 9: {
                return pSDevSlnSysTSBase.isPSTaskServerNameDirty();
            }
            case 10: {
                return pSDevSlnSysTSBase.isUnloadTimeDirty();
            }
            case 11: {
                return pSDevSlnSysTSBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDevSlnSysTSBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysTSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysTSBase pSDevSlnSysTSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysTSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getLoadTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loadtime", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getLoadTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsystsid", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSDevSlnSysTSId()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsystsname", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSDevSlnSysTSName()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSTaskServerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskserverid", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSTaskServerId()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getPSTaskServerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pstaskservername", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getPSTaskServerName()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getUnloadTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"unloadtime", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getUnloadTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysTSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysTSBase.getJSONValue((Object)pSDevSlnSysTSBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysTSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysTSBase pSDevSlnSysTSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysTSBase.getCreateDate() != null) {
            object = pSDevSlnSysTSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysTSBase.getCreateMan() != null) {
            object = pSDevSlnSysTSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getLoadTime() != null) {
            object = pSDevSlnSysTSBase.getLoadTime();
            xmlNode.setAttribute(FIELD_LOADTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysTSBase.getMemo() != null) {
            object = pSDevSlnSysTSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysTSBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysTSBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSId() != null) {
            object = pSDevSlnSysTSBase.getPSDevSlnSysTSId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSTSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSName() != null) {
            object = pSDevSlnSysTSBase.getPSDevSlnSysTSName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSTSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSTaskServerId() != null) {
            object = pSDevSlnSysTSBase.getPSTaskServerId();
            xmlNode.setAttribute(FIELD_PSTASKSERVERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getPSTaskServerName() != null) {
            object = pSDevSlnSysTSBase.getPSTaskServerName();
            xmlNode.setAttribute(FIELD_PSTASKSERVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysTSBase.getUnloadTime() != null) {
            object = pSDevSlnSysTSBase.getUnloadTime();
            xmlNode.setAttribute(FIELD_UNLOADTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysTSBase.getUpdateDate() != null) {
            object = pSDevSlnSysTSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysTSBase.getUpdateMan() != null) {
            object = pSDevSlnSysTSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysTSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysTSBase pSDevSlnSysTSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysTSBase.isCreateDateDirty() && (bl || pSDevSlnSysTSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysTSBase.getCreateDate());
        }
        if (pSDevSlnSysTSBase.isCreateManDirty() && (bl || pSDevSlnSysTSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysTSBase.getCreateMan());
        }
        if (pSDevSlnSysTSBase.isLoadTimeDirty() && (bl || pSDevSlnSysTSBase.getLoadTime() != null)) {
            iDataObject.set(FIELD_LOADTIME, (Object)pSDevSlnSysTSBase.getLoadTime());
        }
        if (pSDevSlnSysTSBase.isMemoDirty() && (bl || pSDevSlnSysTSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysTSBase.getMemo());
        }
        if (pSDevSlnSysTSBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysTSBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysTSBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysTSBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysTSBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysTSBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysTSBase.isPSDevSlnSysTSIdDirty() && (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSTSID, (Object)pSDevSlnSysTSBase.getPSDevSlnSysTSId());
        }
        if (pSDevSlnSysTSBase.isPSDevSlnSysTSNameDirty() && (bl || pSDevSlnSysTSBase.getPSDevSlnSysTSName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSTSNAME, (Object)pSDevSlnSysTSBase.getPSDevSlnSysTSName());
        }
        if (pSDevSlnSysTSBase.isPSTaskServerIdDirty() && (bl || pSDevSlnSysTSBase.getPSTaskServerId() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERID, (Object)pSDevSlnSysTSBase.getPSTaskServerId());
        }
        if (pSDevSlnSysTSBase.isPSTaskServerNameDirty() && (bl || pSDevSlnSysTSBase.getPSTaskServerName() != null)) {
            iDataObject.set(FIELD_PSTASKSERVERNAME, (Object)pSDevSlnSysTSBase.getPSTaskServerName());
        }
        if (pSDevSlnSysTSBase.isUnloadTimeDirty() && (bl || pSDevSlnSysTSBase.getUnloadTime() != null)) {
            iDataObject.set(FIELD_UNLOADTIME, (Object)pSDevSlnSysTSBase.getUnloadTime());
        }
        if (pSDevSlnSysTSBase.isUpdateDateDirty() && (bl || pSDevSlnSysTSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysTSBase.getUpdateDate());
        }
        if (pSDevSlnSysTSBase.isUpdateManDirty() && (bl || pSDevSlnSysTSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysTSBase.getUpdateMan());
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
        return PSDevSlnSysTSBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysTSBase pSDevSlnSysTSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysTSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevSlnSysTSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevSlnSysTSBase.resetLoadTime();
                return true;
            }
            case 3: {
                pSDevSlnSysTSBase.resetMemo();
                return true;
            }
            case 4: {
                pSDevSlnSysTSBase.resetPSDevSlnSysId();
                return true;
            }
            case 5: {
                pSDevSlnSysTSBase.resetPSDevSlnSysName();
                return true;
            }
            case 6: {
                pSDevSlnSysTSBase.resetPSDevSlnSysTSId();
                return true;
            }
            case 7: {
                pSDevSlnSysTSBase.resetPSDevSlnSysTSName();
                return true;
            }
            case 8: {
                pSDevSlnSysTSBase.resetPSTaskServerId();
                return true;
            }
            case 9: {
                pSDevSlnSysTSBase.resetPSTaskServerName();
                return true;
            }
            case 10: {
                pSDevSlnSysTSBase.resetUnloadTime();
                return true;
            }
            case 11: {
                pSDevSlnSysTSBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDevSlnSysTSBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSTaskServer getPSTaskServer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSTaskServer();
        }
        if (this.getPSTaskServerId() == null) {
            return null;
        }
        Integer n = this.objPSTaskServerLock;
        synchronized (n) {
            if (this.pstaskserver != null && DataTypeHelper.compare((int)25, (Object)this.getPSTaskServerId(), (Object)this.pstaskserver.getPSTaskServerId()) != 0L) {
                this.pstaskserver = null;
            }
            if (this.pstaskserver == null) {
                PSTaskServer pSTaskServer = new PSTaskServer();
                pSTaskServer.setPSTaskServerId(this.getPSTaskServerId());
                PSTaskServerService pSTaskServerService = (PSTaskServerService)ServiceGlobal.getService(PSTaskServerService.class, (SessionFactory)this.getSessionFactory());
                pSTaskServerService.autoGet((IEntity)pSTaskServer);
                this.pstaskserver = pSTaskServer;
            }
            return this.pstaskserver;
        }
    }

    private PSDevSlnSysTSBase getProxyEntity() {
        return this.proxyPSDevSlnSysTSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysTSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysTSBase) {
            this.proxyPSDevSlnSysTSBase = (PSDevSlnSysTSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDevSlnSysTSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOADTIME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSTSID, 6);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSTSNAME, 7);
        fieldIndexMap.put(FIELD_PSTASKSERVERID, 8);
        fieldIndexMap.put(FIELD_PSTASKSERVERNAME, 9);
        fieldIndexMap.put(FIELD_UNLOADTIME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

