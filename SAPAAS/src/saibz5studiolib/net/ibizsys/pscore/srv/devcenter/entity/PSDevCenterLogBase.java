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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterLogBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterLogBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGINFO = "LOGINFO";
    public static final String FIELD_LOGINFO2 = "LOGINFO2";
    public static final String FIELD_LOGLEVEL = "LOGLEVEL";
    public static final String FIELD_LOGLEVEL2 = "LOGLEVEL2";
    public static final String FIELD_LOGTYPE = "LOGTYPE";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERLOGID = "PSDEVCENTERLOGID";
    public static final String FIELD_PSDEVCENTERLOGNAME = "PSDEVCENTERLOGNAME";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REMOTEADDR = "REMOTEADDR";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGINFO = 2;
    private static final int INDEX_LOGINFO2 = 3;
    private static final int INDEX_LOGLEVEL = 4;
    private static final int INDEX_LOGLEVEL2 = 5;
    private static final int INDEX_LOGTYPE = 6;
    private static final int INDEX_PSDEVCENTERID = 7;
    private static final int INDEX_PSDEVCENTERLOGID = 8;
    private static final int INDEX_PSDEVCENTERLOGNAME = 9;
    private static final int INDEX_PSDEVCENTERNAME = 10;
    private static final int INDEX_REMOTEADDR = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterLogBase proxyPSDevCenterLogBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean loginfoDirtyFlag = false;
    private boolean loginfo2DirtyFlag = false;
    private boolean loglevelDirtyFlag = false;
    private boolean loglevel2DirtyFlag = false;
    private boolean logtypeDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenterlogidDirtyFlag = false;
    private boolean psdevcenterlognameDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean remoteaddrDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="loginfo")
    private String loginfo;
    @Column(name="loginfo2")
    private String loginfo2;
    @Column(name="loglevel")
    private String loglevel;
    @Column(name="loglevel2")
    private Integer loglevel2;
    @Column(name="logtype")
    private String logtype;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcenterlogid")
    private String psdevcenterlogid;
    @Column(name="psdevcenterlogname")
    private String psdevcenterlogname;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="remoteaddr")
    private String remoteaddr;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setLogInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginfo = string;
        this.loginfoDirtyFlag = true;
    }

    public String getLogInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo();
        }
        return this.loginfo;
    }

    public boolean isLogInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfoDirty();
        }
        return this.loginfoDirtyFlag;
    }

    public void resetLogInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo();
            return;
        }
        this.loginfoDirtyFlag = false;
        this.loginfo = null;
    }

    public void setLogInfo2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogInfo2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loginfo2 = string;
        this.loginfo2DirtyFlag = true;
    }

    public String getLogInfo2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogInfo2();
        }
        return this.loginfo2;
    }

    public boolean isLogInfo2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogInfo2Dirty();
        }
        return this.loginfo2DirtyFlag;
    }

    public void resetLogInfo2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogInfo2();
            return;
        }
        this.loginfo2DirtyFlag = false;
        this.loginfo2 = null;
    }

    public void setLogLevel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.loglevel = string;
        this.loglevelDirtyFlag = true;
    }

    public String getLogLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel();
        }
        return this.loglevel;
    }

    public boolean isLogLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevelDirty();
        }
        return this.loglevelDirtyFlag;
    }

    public void resetLogLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel();
            return;
        }
        this.loglevelDirtyFlag = false;
        this.loglevel = null;
    }

    public void setLogLevel2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogLevel2(n);
            return;
        }
        this.loglevel2 = n;
        this.loglevel2DirtyFlag = true;
    }

    public Integer getLogLevel2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogLevel2();
        }
        return this.loglevel2;
    }

    public boolean isLogLevel2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogLevel2Dirty();
        }
        return this.loglevel2DirtyFlag;
    }

    public void resetLogLevel2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogLevel2();
            return;
        }
        this.loglevel2DirtyFlag = false;
        this.loglevel2 = null;
    }

    public void setLogType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logtype = string;
        this.logtypeDirtyFlag = true;
    }

    public String getLogType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogType();
        }
        return this.logtype;
    }

    public boolean isLogTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogTypeDirty();
        }
        return this.logtypeDirtyFlag;
    }

    public void resetLogType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogType();
            return;
        }
        this.logtypeDirtyFlag = false;
        this.logtype = null;
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

    public void setPSDevCenterLogId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterLogId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterlogid = string;
        this.psdevcenterlogidDirtyFlag = true;
    }

    public String getPSDevCenterLogId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterLogId();
        }
        return this.psdevcenterlogid;
    }

    public boolean isPSDevCenterLogIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterLogIdDirty();
        }
        return this.psdevcenterlogidDirtyFlag;
    }

    public void resetPSDevCenterLogId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterLogId();
            return;
        }
        this.psdevcenterlogidDirtyFlag = false;
        this.psdevcenterlogid = null;
    }

    public void setPSDevCenterLogName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterLogName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterlogname = string;
        this.psdevcenterlognameDirtyFlag = true;
    }

    public String getPSDevCenterLogName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterLogName();
        }
        return this.psdevcenterlogname;
    }

    public boolean isPSDevCenterLogNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterLogNameDirty();
        }
        return this.psdevcenterlognameDirtyFlag;
    }

    public void resetPSDevCenterLogName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterLogName();
            return;
        }
        this.psdevcenterlognameDirtyFlag = false;
        this.psdevcenterlogname = null;
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

    public void setRemoteAddr(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRemoteAddr(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.remoteaddr = string;
        this.remoteaddrDirtyFlag = true;
    }

    public String getRemoteAddr() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRemoteAddr();
        }
        return this.remoteaddr;
    }

    public boolean isRemoteAddrDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRemoteAddrDirty();
        }
        return this.remoteaddrDirtyFlag;
    }

    public void resetRemoteAddr() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRemoteAddr();
            return;
        }
        this.remoteaddrDirtyFlag = false;
        this.remoteaddr = null;
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
        PSDevCenterLogBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterLogBase pSDevCenterLogBase) {
        pSDevCenterLogBase.resetCreateDate();
        pSDevCenterLogBase.resetCreateMan();
        pSDevCenterLogBase.resetLogInfo();
        pSDevCenterLogBase.resetLogInfo2();
        pSDevCenterLogBase.resetLogLevel();
        pSDevCenterLogBase.resetLogLevel2();
        pSDevCenterLogBase.resetLogType();
        pSDevCenterLogBase.resetPSDevCenterId();
        pSDevCenterLogBase.resetPSDevCenterLogId();
        pSDevCenterLogBase.resetPSDevCenterLogName();
        pSDevCenterLogBase.resetPSDevCenterName();
        pSDevCenterLogBase.resetRemoteAddr();
        pSDevCenterLogBase.resetUpdateDate();
        pSDevCenterLogBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogInfoDirty()) {
            hashMap.put(FIELD_LOGINFO, this.getLogInfo());
        }
        if (!bl || this.isLogInfo2Dirty()) {
            hashMap.put(FIELD_LOGINFO2, this.getLogInfo2());
        }
        if (!bl || this.isLogLevelDirty()) {
            hashMap.put(FIELD_LOGLEVEL, this.getLogLevel());
        }
        if (!bl || this.isLogLevel2Dirty()) {
            hashMap.put(FIELD_LOGLEVEL2, this.getLogLevel2());
        }
        if (!bl || this.isLogTypeDirty()) {
            hashMap.put(FIELD_LOGTYPE, this.getLogType());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterLogIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERLOGID, this.getPSDevCenterLogId());
        }
        if (!bl || this.isPSDevCenterLogNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERLOGNAME, this.getPSDevCenterLogName());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isRemoteAddrDirty()) {
            hashMap.put(FIELD_REMOTEADDR, this.getRemoteAddr());
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
        return PSDevCenterLogBase.get(this, n);
    }

    private static Object get(PSDevCenterLogBase pSDevCenterLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterLogBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterLogBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterLogBase.getLogInfo();
            }
            case 3: {
                return pSDevCenterLogBase.getLogInfo2();
            }
            case 4: {
                return pSDevCenterLogBase.getLogLevel();
            }
            case 5: {
                return pSDevCenterLogBase.getLogLevel2();
            }
            case 6: {
                return pSDevCenterLogBase.getLogType();
            }
            case 7: {
                return pSDevCenterLogBase.getPSDevCenterId();
            }
            case 8: {
                return pSDevCenterLogBase.getPSDevCenterLogId();
            }
            case 9: {
                return pSDevCenterLogBase.getPSDevCenterLogName();
            }
            case 10: {
                return pSDevCenterLogBase.getPSDevCenterName();
            }
            case 11: {
                return pSDevCenterLogBase.getRemoteAddr();
            }
            case 12: {
                return pSDevCenterLogBase.getUpdateDate();
            }
            case 13: {
                return pSDevCenterLogBase.getUpdateMan();
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
        PSDevCenterLogBase.set(this, n, object);
    }

    private static void set(PSDevCenterLogBase pSDevCenterLogBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterLogBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterLogBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterLogBase.setLogInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterLogBase.setLogInfo2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterLogBase.setLogLevel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterLogBase.setLogLevel2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterLogBase.setLogType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterLogBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterLogBase.setPSDevCenterLogId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterLogBase.setPSDevCenterLogName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterLogBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevCenterLogBase.setRemoteAddr(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevCenterLogBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSDevCenterLogBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevCenterLogBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterLogBase pSDevCenterLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterLogBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterLogBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterLogBase.getLogInfo() == null;
            }
            case 3: {
                return pSDevCenterLogBase.getLogInfo2() == null;
            }
            case 4: {
                return pSDevCenterLogBase.getLogLevel() == null;
            }
            case 5: {
                return pSDevCenterLogBase.getLogLevel2() == null;
            }
            case 6: {
                return pSDevCenterLogBase.getLogType() == null;
            }
            case 7: {
                return pSDevCenterLogBase.getPSDevCenterId() == null;
            }
            case 8: {
                return pSDevCenterLogBase.getPSDevCenterLogId() == null;
            }
            case 9: {
                return pSDevCenterLogBase.getPSDevCenterLogName() == null;
            }
            case 10: {
                return pSDevCenterLogBase.getPSDevCenterName() == null;
            }
            case 11: {
                return pSDevCenterLogBase.getRemoteAddr() == null;
            }
            case 12: {
                return pSDevCenterLogBase.getUpdateDate() == null;
            }
            case 13: {
                return pSDevCenterLogBase.getUpdateMan() == null;
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
        return PSDevCenterLogBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterLogBase pSDevCenterLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterLogBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterLogBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterLogBase.isLogInfoDirty();
            }
            case 3: {
                return pSDevCenterLogBase.isLogInfo2Dirty();
            }
            case 4: {
                return pSDevCenterLogBase.isLogLevelDirty();
            }
            case 5: {
                return pSDevCenterLogBase.isLogLevel2Dirty();
            }
            case 6: {
                return pSDevCenterLogBase.isLogTypeDirty();
            }
            case 7: {
                return pSDevCenterLogBase.isPSDevCenterIdDirty();
            }
            case 8: {
                return pSDevCenterLogBase.isPSDevCenterLogIdDirty();
            }
            case 9: {
                return pSDevCenterLogBase.isPSDevCenterLogNameDirty();
            }
            case 10: {
                return pSDevCenterLogBase.isPSDevCenterNameDirty();
            }
            case 11: {
                return pSDevCenterLogBase.isRemoteAddrDirty();
            }
            case 12: {
                return pSDevCenterLogBase.isUpdateDateDirty();
            }
            case 13: {
                return pSDevCenterLogBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterLogBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterLogBase pSDevCenterLogBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterLogBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getLogInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getLogInfo()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getLogInfo2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loginfo2", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getLogInfo2()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getLogLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getLogLevel()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getLogLevel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"loglevel2", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getLogLevel2()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getLogType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logtype", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getLogType()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterLogId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterlogid", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getPSDevCenterLogId()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterLogName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterlogname", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getPSDevCenterLogName()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getRemoteAddr() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"remoteaddr", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getRemoteAddr()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterLogBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterLogBase.getJSONValue((Object)pSDevCenterLogBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterLogBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterLogBase pSDevCenterLogBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterLogBase.getCreateDate() != null) {
            object = pSDevCenterLogBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterLogBase.getCreateMan() != null) {
            object = pSDevCenterLogBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getLogInfo() != null) {
            object = pSDevCenterLogBase.getLogInfo();
            xmlNode.setAttribute(FIELD_LOGINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getLogInfo2() != null) {
            object = pSDevCenterLogBase.getLogInfo2();
            xmlNode.setAttribute(FIELD_LOGINFO2, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getLogLevel() != null) {
            object = pSDevCenterLogBase.getLogLevel();
            xmlNode.setAttribute(FIELD_LOGLEVEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getLogLevel2() != null) {
            object = pSDevCenterLogBase.getLogLevel2();
            xmlNode.setAttribute(FIELD_LOGLEVEL2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevCenterLogBase.getLogType() != null) {
            object = pSDevCenterLogBase.getLogType();
            xmlNode.setAttribute(FIELD_LOGTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterId() != null) {
            object = pSDevCenterLogBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterLogId() != null) {
            object = pSDevCenterLogBase.getPSDevCenterLogId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERLOGID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterLogName() != null) {
            object = pSDevCenterLogBase.getPSDevCenterLogName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERLOGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getPSDevCenterName() != null) {
            object = pSDevCenterLogBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getRemoteAddr() != null) {
            object = pSDevCenterLogBase.getRemoteAddr();
            xmlNode.setAttribute(FIELD_REMOTEADDR, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterLogBase.getUpdateDate() != null) {
            object = pSDevCenterLogBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterLogBase.getUpdateMan() != null) {
            object = pSDevCenterLogBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterLogBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterLogBase pSDevCenterLogBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterLogBase.isCreateDateDirty() && (bl || pSDevCenterLogBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterLogBase.getCreateDate());
        }
        if (pSDevCenterLogBase.isCreateManDirty() && (bl || pSDevCenterLogBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterLogBase.getCreateMan());
        }
        if (pSDevCenterLogBase.isLogInfoDirty() && (bl || pSDevCenterLogBase.getLogInfo() != null)) {
            iDataObject.set(FIELD_LOGINFO, (Object)pSDevCenterLogBase.getLogInfo());
        }
        if (pSDevCenterLogBase.isLogInfo2Dirty() && (bl || pSDevCenterLogBase.getLogInfo2() != null)) {
            iDataObject.set(FIELD_LOGINFO2, (Object)pSDevCenterLogBase.getLogInfo2());
        }
        if (pSDevCenterLogBase.isLogLevelDirty() && (bl || pSDevCenterLogBase.getLogLevel() != null)) {
            iDataObject.set(FIELD_LOGLEVEL, (Object)pSDevCenterLogBase.getLogLevel());
        }
        if (pSDevCenterLogBase.isLogLevel2Dirty() && (bl || pSDevCenterLogBase.getLogLevel2() != null)) {
            iDataObject.set(FIELD_LOGLEVEL2, (Object)pSDevCenterLogBase.getLogLevel2());
        }
        if (pSDevCenterLogBase.isLogTypeDirty() && (bl || pSDevCenterLogBase.getLogType() != null)) {
            iDataObject.set(FIELD_LOGTYPE, (Object)pSDevCenterLogBase.getLogType());
        }
        if (pSDevCenterLogBase.isPSDevCenterIdDirty() && (bl || pSDevCenterLogBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterLogBase.getPSDevCenterId());
        }
        if (pSDevCenterLogBase.isPSDevCenterLogIdDirty() && (bl || pSDevCenterLogBase.getPSDevCenterLogId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERLOGID, (Object)pSDevCenterLogBase.getPSDevCenterLogId());
        }
        if (pSDevCenterLogBase.isPSDevCenterLogNameDirty() && (bl || pSDevCenterLogBase.getPSDevCenterLogName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERLOGNAME, (Object)pSDevCenterLogBase.getPSDevCenterLogName());
        }
        if (pSDevCenterLogBase.isPSDevCenterNameDirty() && (bl || pSDevCenterLogBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterLogBase.getPSDevCenterName());
        }
        if (pSDevCenterLogBase.isRemoteAddrDirty() && (bl || pSDevCenterLogBase.getRemoteAddr() != null)) {
            iDataObject.set(FIELD_REMOTEADDR, (Object)pSDevCenterLogBase.getRemoteAddr());
        }
        if (pSDevCenterLogBase.isUpdateDateDirty() && (bl || pSDevCenterLogBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterLogBase.getUpdateDate());
        }
        if (pSDevCenterLogBase.isUpdateManDirty() && (bl || pSDevCenterLogBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterLogBase.getUpdateMan());
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
        return PSDevCenterLogBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterLogBase pSDevCenterLogBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterLogBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterLogBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterLogBase.resetLogInfo();
                return true;
            }
            case 3: {
                pSDevCenterLogBase.resetLogInfo2();
                return true;
            }
            case 4: {
                pSDevCenterLogBase.resetLogLevel();
                return true;
            }
            case 5: {
                pSDevCenterLogBase.resetLogLevel2();
                return true;
            }
            case 6: {
                pSDevCenterLogBase.resetLogType();
                return true;
            }
            case 7: {
                pSDevCenterLogBase.resetPSDevCenterId();
                return true;
            }
            case 8: {
                pSDevCenterLogBase.resetPSDevCenterLogId();
                return true;
            }
            case 9: {
                pSDevCenterLogBase.resetPSDevCenterLogName();
                return true;
            }
            case 10: {
                pSDevCenterLogBase.resetPSDevCenterName();
                return true;
            }
            case 11: {
                pSDevCenterLogBase.resetRemoteAddr();
                return true;
            }
            case 12: {
                pSDevCenterLogBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSDevCenterLogBase.resetUpdateMan();
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
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDevCenterLogBase getProxyEntity() {
        return this.proxyPSDevCenterLogBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterLogBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterLogBase) {
            this.proxyPSDevCenterLogBase = (PSDevCenterLogBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterLogService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGINFO, 2);
        fieldIndexMap.put(FIELD_LOGINFO2, 3);
        fieldIndexMap.put(FIELD_LOGLEVEL, 4);
        fieldIndexMap.put(FIELD_LOGLEVEL2, 5);
        fieldIndexMap.put(FIELD_LOGTYPE, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 7);
        fieldIndexMap.put(FIELD_PSDEVCENTERLOGID, 8);
        fieldIndexMap.put(FIELD_PSDEVCENTERLOGNAME, 9);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 10);
        fieldIndexMap.put(FIELD_REMOTEADDR, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

