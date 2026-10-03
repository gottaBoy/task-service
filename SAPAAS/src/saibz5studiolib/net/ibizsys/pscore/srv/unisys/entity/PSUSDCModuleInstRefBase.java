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
package net.ibizsys.pscore.srv.unisys.entity;

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
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleInstRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSDCModuleInstRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSUSDCMODULEINSTID = "PSUSDCMODULEINSTID";
    public static final String FIELD_PSUSDCMODULEINSTNAME = "PSUSDCMODULEINSTNAME";
    public static final String FIELD_PSUSDCMODULEINSTREFID = "PSUSDCMODULEINSTREFID";
    public static final String FIELD_PSUSDCMODULEINSTREFNAME = "PSUSDCMODULEINSTREFNAME";
    public static final String FIELD_REFMODE = "REFMODE";
    public static final String FIELD_REFPSUSDCMODULEINSTID = "REFPSUSDCMODULEINSTID";
    public static final String FIELD_REFPSUSDCMODULEINSTNAME = "REFPSUSDCMODULEINSTNAME";
    public static final String FIELD_SERVICEURL = "SERVICEURL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSUSDCMODULEINSTID = 2;
    private static final int INDEX_PSUSDCMODULEINSTNAME = 3;
    private static final int INDEX_PSUSDCMODULEINSTREFID = 4;
    private static final int INDEX_PSUSDCMODULEINSTREFNAME = 5;
    private static final int INDEX_REFMODE = 6;
    private static final int INDEX_REFPSUSDCMODULEINSTID = 7;
    private static final int INDEX_REFPSUSDCMODULEINSTNAME = 8;
    private static final int INDEX_SERVICEURL = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSDCModuleInstRefBase proxyPSUSDCModuleInstRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psusdcmoduleinstidDirtyFlag = false;
    private boolean psusdcmoduleinstnameDirtyFlag = false;
    private boolean psusdcmoduleinstrefidDirtyFlag = false;
    private boolean psusdcmoduleinstrefnameDirtyFlag = false;
    private boolean refmodeDirtyFlag = false;
    private boolean refpsusdcmoduleinstidDirtyFlag = false;
    private boolean refpsusdcmoduleinstnameDirtyFlag = false;
    private boolean serviceurlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psusdcmoduleinstid")
    private String psusdcmoduleinstid;
    @Column(name="psusdcmoduleinstname")
    private String psusdcmoduleinstname;
    @Column(name="psusdcmoduleinstrefid")
    private String psusdcmoduleinstrefid;
    @Column(name="psusdcmoduleinstrefname")
    private String psusdcmoduleinstrefname;
    @Column(name="refmode")
    private String refmode;
    @Column(name="refpsusdcmoduleinstid")
    private String refpsusdcmoduleinstid;
    @Column(name="refpsusdcmoduleinstname")
    private String refpsusdcmoduleinstname;
    @Column(name="serviceurl")
    private String serviceurl;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSUSDCModuleInstLock = new Integer(1);
    private PSUSDCModuleInst psusdcmoduleinst = null;
    private Integer objRefPSUSDCModuleInstLock = new Integer(1);
    private PSUSDCModuleInst refpsusdcmoduleinst = null;

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

    public void setPSUSDCModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstid = string;
        this.psusdcmoduleinstidDirtyFlag = true;
    }

    public String getPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstId();
        }
        return this.psusdcmoduleinstid;
    }

    public boolean isPSUSDCModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstIdDirty();
        }
        return this.psusdcmoduleinstidDirtyFlag;
    }

    public void resetPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstId();
            return;
        }
        this.psusdcmoduleinstidDirtyFlag = false;
        this.psusdcmoduleinstid = null;
    }

    public void setPSUSDCModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstname = string;
        this.psusdcmoduleinstnameDirtyFlag = true;
    }

    public String getPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstName();
        }
        return this.psusdcmoduleinstname;
    }

    public boolean isPSUSDCModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstNameDirty();
        }
        return this.psusdcmoduleinstnameDirtyFlag;
    }

    public void resetPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstName();
            return;
        }
        this.psusdcmoduleinstnameDirtyFlag = false;
        this.psusdcmoduleinstname = null;
    }

    public void setPSUSDCModuleInstRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstrefid = string;
        this.psusdcmoduleinstrefidDirtyFlag = true;
    }

    public String getPSUSDCModuleInstRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstRefId();
        }
        return this.psusdcmoduleinstrefid;
    }

    public boolean isPSUSDCModuleInstRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstRefIdDirty();
        }
        return this.psusdcmoduleinstrefidDirtyFlag;
    }

    public void resetPSUSDCModuleInstRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstRefId();
            return;
        }
        this.psusdcmoduleinstrefidDirtyFlag = false;
        this.psusdcmoduleinstrefid = null;
    }

    public void setPSUSDCModuleInstRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleInstRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleinstrefname = string;
        this.psusdcmoduleinstrefnameDirtyFlag = true;
    }

    public String getPSUSDCModuleInstRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInstRefName();
        }
        return this.psusdcmoduleinstrefname;
    }

    public boolean isPSUSDCModuleInstRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleInstRefNameDirty();
        }
        return this.psusdcmoduleinstrefnameDirtyFlag;
    }

    public void resetPSUSDCModuleInstRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleInstRefName();
            return;
        }
        this.psusdcmoduleinstrefnameDirtyFlag = false;
        this.psusdcmoduleinstrefname = null;
    }

    public void setRefMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refmode = string;
        this.refmodeDirtyFlag = true;
    }

    public String getRefMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefMode();
        }
        return this.refmode;
    }

    public boolean isRefModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefModeDirty();
        }
        return this.refmodeDirtyFlag;
    }

    public void resetRefMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefMode();
            return;
        }
        this.refmodeDirtyFlag = false;
        this.refmode = null;
    }

    public void setRefPSUSDCModuleInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSUSDCModuleInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsusdcmoduleinstid = string;
        this.refpsusdcmoduleinstidDirtyFlag = true;
    }

    public String getRefPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSDCModuleInstId();
        }
        return this.refpsusdcmoduleinstid;
    }

    public boolean isRefPSUSDCModuleInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSUSDCModuleInstIdDirty();
        }
        return this.refpsusdcmoduleinstidDirtyFlag;
    }

    public void resetRefPSUSDCModuleInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSUSDCModuleInstId();
            return;
        }
        this.refpsusdcmoduleinstidDirtyFlag = false;
        this.refpsusdcmoduleinstid = null;
    }

    public void setRefPSUSDCModuleInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSUSDCModuleInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsusdcmoduleinstname = string;
        this.refpsusdcmoduleinstnameDirtyFlag = true;
    }

    public String getRefPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSDCModuleInstName();
        }
        return this.refpsusdcmoduleinstname;
    }

    public boolean isRefPSUSDCModuleInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSUSDCModuleInstNameDirty();
        }
        return this.refpsusdcmoduleinstnameDirtyFlag;
    }

    public void resetRefPSUSDCModuleInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSUSDCModuleInstName();
            return;
        }
        this.refpsusdcmoduleinstnameDirtyFlag = false;
        this.refpsusdcmoduleinstname = null;
    }

    public void setServiceUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setServiceUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.serviceurl = string;
        this.serviceurlDirtyFlag = true;
    }

    public String getServiceUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getServiceUrl();
        }
        return this.serviceurl;
    }

    public boolean isServiceUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isServiceUrlDirty();
        }
        return this.serviceurlDirtyFlag;
    }

    public void resetServiceUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetServiceUrl();
            return;
        }
        this.serviceurlDirtyFlag = false;
        this.serviceurl = null;
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
        PSUSDCModuleInstRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase) {
        pSUSDCModuleInstRefBase.resetCreateDate();
        pSUSDCModuleInstRefBase.resetCreateMan();
        pSUSDCModuleInstRefBase.resetPSUSDCModuleInstId();
        pSUSDCModuleInstRefBase.resetPSUSDCModuleInstName();
        pSUSDCModuleInstRefBase.resetPSUSDCModuleInstRefId();
        pSUSDCModuleInstRefBase.resetPSUSDCModuleInstRefName();
        pSUSDCModuleInstRefBase.resetRefMode();
        pSUSDCModuleInstRefBase.resetRefPSUSDCModuleInstId();
        pSUSDCModuleInstRefBase.resetRefPSUSDCModuleInstName();
        pSUSDCModuleInstRefBase.resetServiceUrl();
        pSUSDCModuleInstRefBase.resetUpdateDate();
        pSUSDCModuleInstRefBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSUSDCModuleInstIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTID, this.getPSUSDCModuleInstId());
        }
        if (!bl || this.isPSUSDCModuleInstNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTNAME, this.getPSUSDCModuleInstName());
        }
        if (!bl || this.isPSUSDCModuleInstRefIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTREFID, this.getPSUSDCModuleInstRefId());
        }
        if (!bl || this.isPSUSDCModuleInstRefNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEINSTREFNAME, this.getPSUSDCModuleInstRefName());
        }
        if (!bl || this.isRefModeDirty()) {
            hashMap.put(FIELD_REFMODE, this.getRefMode());
        }
        if (!bl || this.isRefPSUSDCModuleInstIdDirty()) {
            hashMap.put(FIELD_REFPSUSDCMODULEINSTID, this.getRefPSUSDCModuleInstId());
        }
        if (!bl || this.isRefPSUSDCModuleInstNameDirty()) {
            hashMap.put(FIELD_REFPSUSDCMODULEINSTNAME, this.getRefPSUSDCModuleInstName());
        }
        if (!bl || this.isServiceUrlDirty()) {
            hashMap.put(FIELD_SERVICEURL, this.getServiceUrl());
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
        return PSUSDCModuleInstRefBase.get(this, n);
    }

    private static Object get(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstRefBase.getCreateDate();
            }
            case 1: {
                return pSUSDCModuleInstRefBase.getCreateMan();
            }
            case 2: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstId();
            }
            case 3: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstName();
            }
            case 4: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId();
            }
            case 5: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName();
            }
            case 6: {
                return pSUSDCModuleInstRefBase.getRefMode();
            }
            case 7: {
                return pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId();
            }
            case 8: {
                return pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName();
            }
            case 9: {
                return pSUSDCModuleInstRefBase.getServiceUrl();
            }
            case 10: {
                return pSUSDCModuleInstRefBase.getUpdateDate();
            }
            case 11: {
                return pSUSDCModuleInstRefBase.getUpdateMan();
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
        PSUSDCModuleInstRefBase.set(this, n, object);
    }

    private static void set(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSDCModuleInstRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSDCModuleInstRefBase.setPSUSDCModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSDCModuleInstRefBase.setPSUSDCModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSDCModuleInstRefBase.setPSUSDCModuleInstRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSDCModuleInstRefBase.setPSUSDCModuleInstRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSDCModuleInstRefBase.setRefMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSDCModuleInstRefBase.setRefPSUSDCModuleInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSDCModuleInstRefBase.setRefPSUSDCModuleInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUSDCModuleInstRefBase.setServiceUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUSDCModuleInstRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSUSDCModuleInstRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUSDCModuleInstRefBase.isNull(this, n);
    }

    private static boolean isNull(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSDCModuleInstRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstId() == null;
            }
            case 3: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstName() == null;
            }
            case 4: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId() == null;
            }
            case 5: {
                return pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName() == null;
            }
            case 6: {
                return pSUSDCModuleInstRefBase.getRefMode() == null;
            }
            case 7: {
                return pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId() == null;
            }
            case 8: {
                return pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName() == null;
            }
            case 9: {
                return pSUSDCModuleInstRefBase.getServiceUrl() == null;
            }
            case 10: {
                return pSUSDCModuleInstRefBase.getUpdateDate() == null;
            }
            case 11: {
                return pSUSDCModuleInstRefBase.getUpdateMan() == null;
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
        return PSUSDCModuleInstRefBase.contains(this, n);
    }

    private static boolean contains(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleInstRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSDCModuleInstRefBase.isCreateManDirty();
            }
            case 2: {
                return pSUSDCModuleInstRefBase.isPSUSDCModuleInstIdDirty();
            }
            case 3: {
                return pSUSDCModuleInstRefBase.isPSUSDCModuleInstNameDirty();
            }
            case 4: {
                return pSUSDCModuleInstRefBase.isPSUSDCModuleInstRefIdDirty();
            }
            case 5: {
                return pSUSDCModuleInstRefBase.isPSUSDCModuleInstRefNameDirty();
            }
            case 6: {
                return pSUSDCModuleInstRefBase.isRefModeDirty();
            }
            case 7: {
                return pSUSDCModuleInstRefBase.isRefPSUSDCModuleInstIdDirty();
            }
            case 8: {
                return pSUSDCModuleInstRefBase.isRefPSUSDCModuleInstNameDirty();
            }
            case 9: {
                return pSUSDCModuleInstRefBase.isServiceUrlDirty();
            }
            case 10: {
                return pSUSDCModuleInstRefBase.isUpdateDateDirty();
            }
            case 11: {
                return pSUSDCModuleInstRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSDCModuleInstRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSDCModuleInstRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstid", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstname", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstrefid", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleinstrefname", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refmode", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getRefMode()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsusdcmoduleinstid", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsusdcmoduleinstname", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getServiceUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"serviceurl", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getServiceUrl()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleInstRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSDCModuleInstRefBase.getJSONValue((Object)pSUSDCModuleInstRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSDCModuleInstRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSDCModuleInstRefBase.getCreateDate() != null) {
            object = pSUSDCModuleInstRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstRefBase.getCreateMan() != null) {
            object = pSUSDCModuleInstRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstId() != null) {
            object = pSUSDCModuleInstRefBase.getPSUSDCModuleInstId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstName() != null) {
            object = pSUSDCModuleInstRefBase.getPSUSDCModuleInstName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId() != null) {
            object = pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTREFID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName() != null) {
            object = pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEINSTREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefMode() != null) {
            object = pSUSDCModuleInstRefBase.getRefMode();
            xmlNode.setAttribute(FIELD_REFMODE, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId() != null) {
            object = pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId();
            xmlNode.setAttribute(FIELD_REFPSUSDCMODULEINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName() != null) {
            object = pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName();
            xmlNode.setAttribute(FIELD_REFPSUSDCMODULEINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getServiceUrl() != null) {
            object = pSUSDCModuleInstRefBase.getServiceUrl();
            xmlNode.setAttribute(FIELD_SERVICEURL, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleInstRefBase.getUpdateDate() != null) {
            object = pSUSDCModuleInstRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleInstRefBase.getUpdateMan() != null) {
            object = pSUSDCModuleInstRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSDCModuleInstRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSDCModuleInstRefBase.isCreateDateDirty() && (bl || pSUSDCModuleInstRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSDCModuleInstRefBase.getCreateDate());
        }
        if (pSUSDCModuleInstRefBase.isCreateManDirty() && (bl || pSUSDCModuleInstRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSDCModuleInstRefBase.getCreateMan());
        }
        if (pSUSDCModuleInstRefBase.isPSUSDCModuleInstIdDirty() && (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTID, (Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstId());
        }
        if (pSUSDCModuleInstRefBase.isPSUSDCModuleInstNameDirty() && (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTNAME, (Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstName());
        }
        if (pSUSDCModuleInstRefBase.isPSUSDCModuleInstRefIdDirty() && (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTREFID, (Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefId());
        }
        if (pSUSDCModuleInstRefBase.isPSUSDCModuleInstRefNameDirty() && (bl || pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEINSTREFNAME, (Object)pSUSDCModuleInstRefBase.getPSUSDCModuleInstRefName());
        }
        if (pSUSDCModuleInstRefBase.isRefModeDirty() && (bl || pSUSDCModuleInstRefBase.getRefMode() != null)) {
            iDataObject.set(FIELD_REFMODE, (Object)pSUSDCModuleInstRefBase.getRefMode());
        }
        if (pSUSDCModuleInstRefBase.isRefPSUSDCModuleInstIdDirty() && (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId() != null)) {
            iDataObject.set(FIELD_REFPSUSDCMODULEINSTID, (Object)pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstId());
        }
        if (pSUSDCModuleInstRefBase.isRefPSUSDCModuleInstNameDirty() && (bl || pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName() != null)) {
            iDataObject.set(FIELD_REFPSUSDCMODULEINSTNAME, (Object)pSUSDCModuleInstRefBase.getRefPSUSDCModuleInstName());
        }
        if (pSUSDCModuleInstRefBase.isServiceUrlDirty() && (bl || pSUSDCModuleInstRefBase.getServiceUrl() != null)) {
            iDataObject.set(FIELD_SERVICEURL, (Object)pSUSDCModuleInstRefBase.getServiceUrl());
        }
        if (pSUSDCModuleInstRefBase.isUpdateDateDirty() && (bl || pSUSDCModuleInstRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSDCModuleInstRefBase.getUpdateDate());
        }
        if (pSUSDCModuleInstRefBase.isUpdateManDirty() && (bl || pSUSDCModuleInstRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSDCModuleInstRefBase.getUpdateMan());
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
        return PSUSDCModuleInstRefBase.remove(this, n);
    }

    private static boolean remove(PSUSDCModuleInstRefBase pSUSDCModuleInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleInstRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSDCModuleInstRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSDCModuleInstRefBase.resetPSUSDCModuleInstId();
                return true;
            }
            case 3: {
                pSUSDCModuleInstRefBase.resetPSUSDCModuleInstName();
                return true;
            }
            case 4: {
                pSUSDCModuleInstRefBase.resetPSUSDCModuleInstRefId();
                return true;
            }
            case 5: {
                pSUSDCModuleInstRefBase.resetPSUSDCModuleInstRefName();
                return true;
            }
            case 6: {
                pSUSDCModuleInstRefBase.resetRefMode();
                return true;
            }
            case 7: {
                pSUSDCModuleInstRefBase.resetRefPSUSDCModuleInstId();
                return true;
            }
            case 8: {
                pSUSDCModuleInstRefBase.resetRefPSUSDCModuleInstName();
                return true;
            }
            case 9: {
                pSUSDCModuleInstRefBase.resetServiceUrl();
                return true;
            }
            case 10: {
                pSUSDCModuleInstRefBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSUSDCModuleInstRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSDCModuleInst getPSUSDCModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInst();
        }
        if (this.getPSUSDCModuleInstId() == null) {
            return null;
        }
        Integer n = this.objPSUSDCModuleInstLock;
        synchronized (n) {
            if (this.psusdcmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSUSDCModuleInstId(), (Object)this.psusdcmoduleinst.getPSUSDCModuleInstId()) != 0L) {
                this.psusdcmoduleinst = null;
            }
            if (this.psusdcmoduleinst == null) {
                PSUSDCModuleInst pSUSDCModuleInst = new PSUSDCModuleInst();
                pSUSDCModuleInst.setPSUSDCModuleInstId(this.getPSUSDCModuleInstId());
                PSUSDCModuleInstService pSUSDCModuleInstService = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSDCModuleInstService.autoGet(pSUSDCModuleInst);
                this.psusdcmoduleinst = pSUSDCModuleInst;
            }
            return this.psusdcmoduleinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUSDCModuleInst getRefPSUSDCModuleInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSUSDCModuleInst();
        }
        if (this.getRefPSUSDCModuleInstId() == null) {
            return null;
        }
        Integer n = this.objRefPSUSDCModuleInstLock;
        synchronized (n) {
            if (this.refpsusdcmoduleinst != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSUSDCModuleInstId(), (Object)this.refpsusdcmoduleinst.getPSUSDCModuleInstId()) != 0L) {
                this.refpsusdcmoduleinst = null;
            }
            if (this.refpsusdcmoduleinst == null) {
                PSUSDCModuleInst pSUSDCModuleInst = new PSUSDCModuleInst();
                pSUSDCModuleInst.setPSUSDCModuleInstId(this.getRefPSUSDCModuleInstId());
                PSUSDCModuleInstService pSUSDCModuleInstService = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
                pSUSDCModuleInstService.autoGet(pSUSDCModuleInst);
                this.refpsusdcmoduleinst = pSUSDCModuleInst;
            }
            return this.refpsusdcmoduleinst;
        }
    }

    private PSUSDCModuleInstRefBase getProxyEntity() {
        return this.proxyPSUSDCModuleInstRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSDCModuleInstRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSDCModuleInstRefBase) {
            this.proxyPSUSDCModuleInstRefBase = (PSUSDCModuleInstRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTID, 2);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTNAME, 3);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTREFID, 4);
        fieldIndexMap.put(FIELD_PSUSDCMODULEINSTREFNAME, 5);
        fieldIndexMap.put(FIELD_REFMODE, 6);
        fieldIndexMap.put(FIELD_REFPSUSDCMODULEINSTID, 7);
        fieldIndexMap.put(FIELD_REFPSUSDCMODULEINSTNAME, 8);
        fieldIndexMap.put(FIELD_SERVICEURL, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

