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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBInstRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBInstRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCDBINSTREFID = "PSDCDBINSTREFID";
    public static final String FIELD_PSDCDBINSTREFNAME = "PSDCDBINSTREFNAME";
    public static final String FIELD_PSDEVCENTERDBINSTID = "PSDEVCENTERDBINSTID";
    public static final String FIELD_PSDEVCENTERDBINSTNAME = "PSDEVCENTERDBINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_REFOBJID = "REFOBJID";
    public static final String FIELD_REFOBJNAME = "REFOBJNAME";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCDBINSTREFID = 2;
    private static final int INDEX_PSDCDBINSTREFNAME = 3;
    private static final int INDEX_PSDEVCENTERDBINSTID = 4;
    private static final int INDEX_PSDEVCENTERDBINSTNAME = 5;
    private static final int INDEX_PSDEVCENTERID = 6;
    private static final int INDEX_PSDEVCENTERNAME = 7;
    private static final int INDEX_REFOBJID = 8;
    private static final int INDEX_REFOBJNAME = 9;
    private static final int INDEX_REFOBJTYPE = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBInstRefBase proxyPSDCDBInstRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcdbinstrefidDirtyFlag = false;
    private boolean psdcdbinstrefnameDirtyFlag = false;
    private boolean psdevcenterdbinstidDirtyFlag = false;
    private boolean psdevcenterdbinstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean refobjidDirtyFlag = false;
    private boolean refobjnameDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcdbinstrefid")
    private String psdcdbinstrefid;
    @Column(name="psdcdbinstrefname")
    private String psdcdbinstrefname;
    @Column(name="psdevcenterdbinstid")
    private String psdevcenterdbinstid;
    @Column(name="psdevcenterdbinstname")
    private String psdevcenterdbinstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="refobjid")
    private String refobjid;
    @Column(name="refobjname")
    private String refobjname;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterDBInstLock = new Integer(1);
    private PSDevCenterDBInst psdevcenterdbinst = null;
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

    public void setPSDCDBInstRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstrefid = string;
        this.psdcdbinstrefidDirtyFlag = true;
    }

    public String getPSDCDBInstRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstRefId();
        }
        return this.psdcdbinstrefid;
    }

    public boolean isPSDCDBInstRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstRefIdDirty();
        }
        return this.psdcdbinstrefidDirtyFlag;
    }

    public void resetPSDCDBInstRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstRefId();
            return;
        }
        this.psdcdbinstrefidDirtyFlag = false;
        this.psdcdbinstrefid = null;
    }

    public void setPSDCDBInstRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstrefname = string;
        this.psdcdbinstrefnameDirtyFlag = true;
    }

    public String getPSDCDBInstRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstRefName();
        }
        return this.psdcdbinstrefname;
    }

    public boolean isPSDCDBInstRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstRefNameDirty();
        }
        return this.psdcdbinstrefnameDirtyFlag;
    }

    public void resetPSDCDBInstRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstRefName();
            return;
        }
        this.psdcdbinstrefnameDirtyFlag = false;
        this.psdcdbinstrefname = null;
    }

    public void setPSDevCenterDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstid = string;
        this.psdevcenterdbinstidDirtyFlag = true;
    }

    public String getPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstId();
        }
        return this.psdevcenterdbinstid;
    }

    public boolean isPSDevCenterDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstIdDirty();
        }
        return this.psdevcenterdbinstidDirtyFlag;
    }

    public void resetPSDevCenterDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstId();
            return;
        }
        this.psdevcenterdbinstidDirtyFlag = false;
        this.psdevcenterdbinstid = null;
    }

    public void setPSDevCenterDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterdbinstname = string;
        this.psdevcenterdbinstnameDirtyFlag = true;
    }

    public String getPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInstName();
        }
        return this.psdevcenterdbinstname;
    }

    public boolean isPSDevCenterDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterDBInstNameDirty();
        }
        return this.psdevcenterdbinstnameDirtyFlag;
    }

    public void resetPSDevCenterDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterDBInstName();
            return;
        }
        this.psdevcenterdbinstnameDirtyFlag = false;
        this.psdevcenterdbinstname = null;
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

    public void setRefObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjid = string;
        this.refobjidDirtyFlag = true;
    }

    public String getRefObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjId();
        }
        return this.refobjid;
    }

    public boolean isRefObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjIdDirty();
        }
        return this.refobjidDirtyFlag;
    }

    public void resetRefObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjId();
            return;
        }
        this.refobjidDirtyFlag = false;
        this.refobjid = null;
    }

    public void setRefObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjname = string;
        this.refobjnameDirtyFlag = true;
    }

    public String getRefObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjName();
        }
        return this.refobjname;
    }

    public boolean isRefObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjNameDirty();
        }
        return this.refobjnameDirtyFlag;
    }

    public void resetRefObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjName();
            return;
        }
        this.refobjnameDirtyFlag = false;
        this.refobjname = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
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
        PSDCDBInstRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBInstRefBase pSDCDBInstRefBase) {
        pSDCDBInstRefBase.resetCreateDate();
        pSDCDBInstRefBase.resetCreateMan();
        pSDCDBInstRefBase.resetPSDCDBInstRefId();
        pSDCDBInstRefBase.resetPSDCDBInstRefName();
        pSDCDBInstRefBase.resetPSDevCenterDBInstId();
        pSDCDBInstRefBase.resetPSDevCenterDBInstName();
        pSDCDBInstRefBase.resetPSDevCenterId();
        pSDCDBInstRefBase.resetPSDevCenterName();
        pSDCDBInstRefBase.resetRefObjId();
        pSDCDBInstRefBase.resetRefObjName();
        pSDCDBInstRefBase.resetRefObjType();
        pSDCDBInstRefBase.resetUpdateDate();
        pSDCDBInstRefBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCDBInstRefIdDirty()) {
            hashMap.put(FIELD_PSDCDBINSTREFID, this.getPSDCDBInstRefId());
        }
        if (!bl || this.isPSDCDBInstRefNameDirty()) {
            hashMap.put(FIELD_PSDCDBINSTREFNAME, this.getPSDCDBInstRefName());
        }
        if (!bl || this.isPSDevCenterDBInstIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTID, this.getPSDevCenterDBInstId());
        }
        if (!bl || this.isPSDevCenterDBInstNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERDBINSTNAME, this.getPSDevCenterDBInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isRefObjIdDirty()) {
            hashMap.put(FIELD_REFOBJID, this.getRefObjId());
        }
        if (!bl || this.isRefObjNameDirty()) {
            hashMap.put(FIELD_REFOBJNAME, this.getRefObjName());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
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
        return PSDCDBInstRefBase.get(this, n);
    }

    private static Object get(PSDCDBInstRefBase pSDCDBInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstRefBase.getCreateDate();
            }
            case 1: {
                return pSDCDBInstRefBase.getCreateMan();
            }
            case 2: {
                return pSDCDBInstRefBase.getPSDCDBInstRefId();
            }
            case 3: {
                return pSDCDBInstRefBase.getPSDCDBInstRefName();
            }
            case 4: {
                return pSDCDBInstRefBase.getPSDevCenterDBInstId();
            }
            case 5: {
                return pSDCDBInstRefBase.getPSDevCenterDBInstName();
            }
            case 6: {
                return pSDCDBInstRefBase.getPSDevCenterId();
            }
            case 7: {
                return pSDCDBInstRefBase.getPSDevCenterName();
            }
            case 8: {
                return pSDCDBInstRefBase.getRefObjId();
            }
            case 9: {
                return pSDCDBInstRefBase.getRefObjName();
            }
            case 10: {
                return pSDCDBInstRefBase.getRefObjType();
            }
            case 11: {
                return pSDCDBInstRefBase.getUpdateDate();
            }
            case 12: {
                return pSDCDBInstRefBase.getUpdateMan();
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
        PSDCDBInstRefBase.set(this, n, object);
    }

    private static void set(PSDCDBInstRefBase pSDCDBInstRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBInstRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBInstRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBInstRefBase.setPSDCDBInstRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBInstRefBase.setPSDCDBInstRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBInstRefBase.setPSDevCenterDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBInstRefBase.setPSDevCenterDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBInstRefBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBInstRefBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBInstRefBase.setRefObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBInstRefBase.setRefObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDCDBInstRefBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDCDBInstRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSDCDBInstRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBInstRefBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBInstRefBase pSDCDBInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBInstRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBInstRefBase.getPSDCDBInstRefId() == null;
            }
            case 3: {
                return pSDCDBInstRefBase.getPSDCDBInstRefName() == null;
            }
            case 4: {
                return pSDCDBInstRefBase.getPSDevCenterDBInstId() == null;
            }
            case 5: {
                return pSDCDBInstRefBase.getPSDevCenterDBInstName() == null;
            }
            case 6: {
                return pSDCDBInstRefBase.getPSDevCenterId() == null;
            }
            case 7: {
                return pSDCDBInstRefBase.getPSDevCenterName() == null;
            }
            case 8: {
                return pSDCDBInstRefBase.getRefObjId() == null;
            }
            case 9: {
                return pSDCDBInstRefBase.getRefObjName() == null;
            }
            case 10: {
                return pSDCDBInstRefBase.getRefObjType() == null;
            }
            case 11: {
                return pSDCDBInstRefBase.getUpdateDate() == null;
            }
            case 12: {
                return pSDCDBInstRefBase.getUpdateMan() == null;
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
        return PSDCDBInstRefBase.contains(this, n);
    }

    private static boolean contains(PSDCDBInstRefBase pSDCDBInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBInstRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBInstRefBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBInstRefBase.isPSDCDBInstRefIdDirty();
            }
            case 3: {
                return pSDCDBInstRefBase.isPSDCDBInstRefNameDirty();
            }
            case 4: {
                return pSDCDBInstRefBase.isPSDevCenterDBInstIdDirty();
            }
            case 5: {
                return pSDCDBInstRefBase.isPSDevCenterDBInstNameDirty();
            }
            case 6: {
                return pSDCDBInstRefBase.isPSDevCenterIdDirty();
            }
            case 7: {
                return pSDCDBInstRefBase.isPSDevCenterNameDirty();
            }
            case 8: {
                return pSDCDBInstRefBase.isRefObjIdDirty();
            }
            case 9: {
                return pSDCDBInstRefBase.isRefObjNameDirty();
            }
            case 10: {
                return pSDCDBInstRefBase.isRefObjTypeDirty();
            }
            case 11: {
                return pSDCDBInstRefBase.isUpdateDateDirty();
            }
            case 12: {
                return pSDCDBInstRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBInstRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBInstRefBase pSDCDBInstRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBInstRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDCDBInstRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstrefid", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDCDBInstRefId()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDCDBInstRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstrefname", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDCDBInstRefName()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstid", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDevCenterDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterdbinstname", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDevCenterDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getRefObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjid", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getRefObjId()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getRefObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjname", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getRefObjName()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBInstRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBInstRefBase.getJSONValue((Object)pSDCDBInstRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBInstRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBInstRefBase pSDCDBInstRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBInstRefBase.getCreateDate() != null) {
            object = pSDCDBInstRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBInstRefBase.getCreateMan() != null) {
            object = pSDCDBInstRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDCDBInstRefId() != null) {
            object = pSDCDBInstRefBase.getPSDCDBInstRefId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDCDBInstRefName() != null) {
            object = pSDCDBInstRefBase.getPSDCDBInstRefName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterDBInstId() != null) {
            object = pSDCDBInstRefBase.getPSDevCenterDBInstId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterDBInstName() != null) {
            object = pSDCDBInstRefBase.getPSDevCenterDBInstName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterId() != null) {
            object = pSDCDBInstRefBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getPSDevCenterName() != null) {
            object = pSDCDBInstRefBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getRefObjId() != null) {
            object = pSDCDBInstRefBase.getRefObjId();
            xmlNode.setAttribute(FIELD_REFOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getRefObjName() != null) {
            object = pSDCDBInstRefBase.getRefObjName();
            xmlNode.setAttribute(FIELD_REFOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getRefObjType() != null) {
            object = pSDCDBInstRefBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBInstRefBase.getUpdateDate() != null) {
            object = pSDCDBInstRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBInstRefBase.getUpdateMan() != null) {
            object = pSDCDBInstRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBInstRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBInstRefBase pSDCDBInstRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBInstRefBase.isCreateDateDirty() && (bl || pSDCDBInstRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBInstRefBase.getCreateDate());
        }
        if (pSDCDBInstRefBase.isCreateManDirty() && (bl || pSDCDBInstRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBInstRefBase.getCreateMan());
        }
        if (pSDCDBInstRefBase.isPSDCDBInstRefIdDirty() && (bl || pSDCDBInstRefBase.getPSDCDBInstRefId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTREFID, (Object)pSDCDBInstRefBase.getPSDCDBInstRefId());
        }
        if (pSDCDBInstRefBase.isPSDCDBInstRefNameDirty() && (bl || pSDCDBInstRefBase.getPSDCDBInstRefName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTREFNAME, (Object)pSDCDBInstRefBase.getPSDCDBInstRefName());
        }
        if (pSDCDBInstRefBase.isPSDevCenterDBInstIdDirty() && (bl || pSDCDBInstRefBase.getPSDevCenterDBInstId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTID, (Object)pSDCDBInstRefBase.getPSDevCenterDBInstId());
        }
        if (pSDCDBInstRefBase.isPSDevCenterDBInstNameDirty() && (bl || pSDCDBInstRefBase.getPSDevCenterDBInstName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERDBINSTNAME, (Object)pSDCDBInstRefBase.getPSDevCenterDBInstName());
        }
        if (pSDCDBInstRefBase.isPSDevCenterIdDirty() && (bl || pSDCDBInstRefBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCDBInstRefBase.getPSDevCenterId());
        }
        if (pSDCDBInstRefBase.isPSDevCenterNameDirty() && (bl || pSDCDBInstRefBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCDBInstRefBase.getPSDevCenterName());
        }
        if (pSDCDBInstRefBase.isRefObjIdDirty() && (bl || pSDCDBInstRefBase.getRefObjId() != null)) {
            iDataObject.set(FIELD_REFOBJID, (Object)pSDCDBInstRefBase.getRefObjId());
        }
        if (pSDCDBInstRefBase.isRefObjNameDirty() && (bl || pSDCDBInstRefBase.getRefObjName() != null)) {
            iDataObject.set(FIELD_REFOBJNAME, (Object)pSDCDBInstRefBase.getRefObjName());
        }
        if (pSDCDBInstRefBase.isRefObjTypeDirty() && (bl || pSDCDBInstRefBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSDCDBInstRefBase.getRefObjType());
        }
        if (pSDCDBInstRefBase.isUpdateDateDirty() && (bl || pSDCDBInstRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBInstRefBase.getUpdateDate());
        }
        if (pSDCDBInstRefBase.isUpdateManDirty() && (bl || pSDCDBInstRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBInstRefBase.getUpdateMan());
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
        return PSDCDBInstRefBase.remove(this, n);
    }

    private static boolean remove(PSDCDBInstRefBase pSDCDBInstRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBInstRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBInstRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBInstRefBase.resetPSDCDBInstRefId();
                return true;
            }
            case 3: {
                pSDCDBInstRefBase.resetPSDCDBInstRefName();
                return true;
            }
            case 4: {
                pSDCDBInstRefBase.resetPSDevCenterDBInstId();
                return true;
            }
            case 5: {
                pSDCDBInstRefBase.resetPSDevCenterDBInstName();
                return true;
            }
            case 6: {
                pSDCDBInstRefBase.resetPSDevCenterId();
                return true;
            }
            case 7: {
                pSDCDBInstRefBase.resetPSDevCenterName();
                return true;
            }
            case 8: {
                pSDCDBInstRefBase.resetRefObjId();
                return true;
            }
            case 9: {
                pSDCDBInstRefBase.resetRefObjName();
                return true;
            }
            case 10: {
                pSDCDBInstRefBase.resetRefObjType();
                return true;
            }
            case 11: {
                pSDCDBInstRefBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSDCDBInstRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDevCenterDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterDBInst();
        }
        if (this.getPSDevCenterDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterDBInstLock;
        synchronized (n) {
            if (this.psdevcenterdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterDBInstId(), (Object)this.psdevcenterdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdevcenterdbinst = null;
            }
            if (this.psdevcenterdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDevCenterDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdevcenterdbinst = pSDevCenterDBInst;
            }
            return this.psdevcenterdbinst;
        }
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

    private PSDCDBInstRefBase getProxyEntity() {
        return this.proxyPSDCDBInstRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBInstRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBInstRefBase) {
            this.proxyPSDCDBInstRefBase = (PSDCDBInstRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBInstRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCDBINSTREFID, 2);
        fieldIndexMap.put(FIELD_PSDCDBINSTREFNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERDBINSTNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 6);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 7);
        fieldIndexMap.put(FIELD_REFOBJID, 8);
        fieldIndexMap.put(FIELD_REFOBJNAME, 9);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

