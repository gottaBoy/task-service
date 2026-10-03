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
package net.ibizsys.pscore.srv.wfplatform.entity;

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
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPAppEntity;
import net.ibizsys.pscore.srv.wfplatform.entity.PSWPDCAppInst;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPAppEntityService;
import net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCAppEntityBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCAppEntityBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWPAPPENTITYID = "PSWPAPPENTITYID";
    public static final String FIELD_PSWPAPPENTITYNAME = "PSWPAPPENTITYNAME";
    public static final String FIELD_PSWPDCAPPENTITYID = "PSWPDCAPPENTITYID";
    public static final String FIELD_PSWPDCAPPENTITYNAME = "PSWPDCAPPENTITYNAME";
    public static final String FIELD_PSWPDCAPPINSTID = "PSWPDCAPPINSTID";
    public static final String FIELD_PSWPDCAPPINSTNAME = "PSWPDCAPPINSTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSWPAPPENTITYID = 4;
    private static final int INDEX_PSWPAPPENTITYNAME = 5;
    private static final int INDEX_PSWPDCAPPENTITYID = 6;
    private static final int INDEX_PSWPDCAPPENTITYNAME = 7;
    private static final int INDEX_PSWPDCAPPINSTID = 8;
    private static final int INDEX_PSWPDCAPPINSTNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCAppEntityBase proxyPSWPDCAppEntityBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pswpappentityidDirtyFlag = false;
    private boolean pswpappentitynameDirtyFlag = false;
    private boolean pswpdcappentityidDirtyFlag = false;
    private boolean pswpdcappentitynameDirtyFlag = false;
    private boolean pswpdcappinstidDirtyFlag = false;
    private boolean pswpdcappinstnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pswpappentityid")
    private String pswpappentityid;
    @Column(name="pswpappentityname")
    private String pswpappentityname;
    @Column(name="pswpdcappentityid")
    private String pswpdcappentityid;
    @Column(name="pswpdcappentityname")
    private String pswpdcappentityname;
    @Column(name="pswpdcappinstid")
    private String pswpdcappinstid;
    @Column(name="pswpdcappinstname")
    private String pswpdcappinstname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSWPAppEntityLock = new Integer(1);
    private PSWPAppEntity pswpappentity = null;
    private Integer objPSWPDCAppInstLock = new Integer(1);
    private PSWPDCAppInst pswpdcappinst = null;

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

    public void setPSWPAppEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappentityid = string;
        this.pswpappentityidDirtyFlag = true;
    }

    public String getPSWPAppEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntityId();
        }
        return this.pswpappentityid;
    }

    public boolean isPSWPAppEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppEntityIdDirty();
        }
        return this.pswpappentityidDirtyFlag;
    }

    public void resetPSWPAppEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppEntityId();
            return;
        }
        this.pswpappentityidDirtyFlag = false;
        this.pswpappentityid = null;
    }

    public void setPSWPAppEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPAppEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpappentityname = string;
        this.pswpappentitynameDirtyFlag = true;
    }

    public String getPSWPAppEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntityName();
        }
        return this.pswpappentityname;
    }

    public boolean isPSWPAppEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPAppEntityNameDirty();
        }
        return this.pswpappentitynameDirtyFlag;
    }

    public void resetPSWPAppEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPAppEntityName();
            return;
        }
        this.pswpappentitynameDirtyFlag = false;
        this.pswpappentityname = null;
    }

    public void setPSWPDCAppEntityId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppEntityId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappentityid = string;
        this.pswpdcappentityidDirtyFlag = true;
    }

    public String getPSWPDCAppEntityId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppEntityId();
        }
        return this.pswpdcappentityid;
    }

    public boolean isPSWPDCAppEntityIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppEntityIdDirty();
        }
        return this.pswpdcappentityidDirtyFlag;
    }

    public void resetPSWPDCAppEntityId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppEntityId();
            return;
        }
        this.pswpdcappentityidDirtyFlag = false;
        this.pswpdcappentityid = null;
    }

    public void setPSWPDCAppEntityName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppEntityName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappentityname = string;
        this.pswpdcappentitynameDirtyFlag = true;
    }

    public String getPSWPDCAppEntityName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppEntityName();
        }
        return this.pswpdcappentityname;
    }

    public boolean isPSWPDCAppEntityNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppEntityNameDirty();
        }
        return this.pswpdcappentitynameDirtyFlag;
    }

    public void resetPSWPDCAppEntityName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppEntityName();
            return;
        }
        this.pswpdcappentitynameDirtyFlag = false;
        this.pswpdcappentityname = null;
    }

    public void setPSWPDCAppInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappinstid = string;
        this.pswpdcappinstidDirtyFlag = true;
    }

    public String getPSWPDCAppInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppInstId();
        }
        return this.pswpdcappinstid;
    }

    public boolean isPSWPDCAppInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppInstIdDirty();
        }
        return this.pswpdcappinstidDirtyFlag;
    }

    public void resetPSWPDCAppInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppInstId();
            return;
        }
        this.pswpdcappinstidDirtyFlag = false;
        this.pswpdcappinstid = null;
    }

    public void setPSWPDCAppInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCAppInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcappinstname = string;
        this.pswpdcappinstnameDirtyFlag = true;
    }

    public String getPSWPDCAppInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppInstName();
        }
        return this.pswpdcappinstname;
    }

    public boolean isPSWPDCAppInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCAppInstNameDirty();
        }
        return this.pswpdcappinstnameDirtyFlag;
    }

    public void resetPSWPDCAppInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCAppInstName();
            return;
        }
        this.pswpdcappinstnameDirtyFlag = false;
        this.pswpdcappinstname = null;
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
        PSWPDCAppEntityBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCAppEntityBase pSWPDCAppEntityBase) {
        pSWPDCAppEntityBase.resetCreateDate();
        pSWPDCAppEntityBase.resetCreateMan();
        pSWPDCAppEntityBase.resetPSDevCenterId();
        pSWPDCAppEntityBase.resetPSDevCenterName();
        pSWPDCAppEntityBase.resetPSWPAppEntityId();
        pSWPDCAppEntityBase.resetPSWPAppEntityName();
        pSWPDCAppEntityBase.resetPSWPDCAppEntityId();
        pSWPDCAppEntityBase.resetPSWPDCAppEntityName();
        pSWPDCAppEntityBase.resetPSWPDCAppInstId();
        pSWPDCAppEntityBase.resetPSWPDCAppInstName();
        pSWPDCAppEntityBase.resetUpdateDate();
        pSWPDCAppEntityBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSWPAppEntityIdDirty()) {
            hashMap.put(FIELD_PSWPAPPENTITYID, this.getPSWPAppEntityId());
        }
        if (!bl || this.isPSWPAppEntityNameDirty()) {
            hashMap.put(FIELD_PSWPAPPENTITYNAME, this.getPSWPAppEntityName());
        }
        if (!bl || this.isPSWPDCAppEntityIdDirty()) {
            hashMap.put(FIELD_PSWPDCAPPENTITYID, this.getPSWPDCAppEntityId());
        }
        if (!bl || this.isPSWPDCAppEntityNameDirty()) {
            hashMap.put(FIELD_PSWPDCAPPENTITYNAME, this.getPSWPDCAppEntityName());
        }
        if (!bl || this.isPSWPDCAppInstIdDirty()) {
            hashMap.put(FIELD_PSWPDCAPPINSTID, this.getPSWPDCAppInstId());
        }
        if (!bl || this.isPSWPDCAppInstNameDirty()) {
            hashMap.put(FIELD_PSWPDCAPPINSTNAME, this.getPSWPDCAppInstName());
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
        return PSWPDCAppEntityBase.get(this, n);
    }

    private static Object get(PSWPDCAppEntityBase pSWPDCAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppEntityBase.getCreateDate();
            }
            case 1: {
                return pSWPDCAppEntityBase.getCreateMan();
            }
            case 2: {
                return pSWPDCAppEntityBase.getPSDevCenterId();
            }
            case 3: {
                return pSWPDCAppEntityBase.getPSDevCenterName();
            }
            case 4: {
                return pSWPDCAppEntityBase.getPSWPAppEntityId();
            }
            case 5: {
                return pSWPDCAppEntityBase.getPSWPAppEntityName();
            }
            case 6: {
                return pSWPDCAppEntityBase.getPSWPDCAppEntityId();
            }
            case 7: {
                return pSWPDCAppEntityBase.getPSWPDCAppEntityName();
            }
            case 8: {
                return pSWPDCAppEntityBase.getPSWPDCAppInstId();
            }
            case 9: {
                return pSWPDCAppEntityBase.getPSWPDCAppInstName();
            }
            case 10: {
                return pSWPDCAppEntityBase.getUpdateDate();
            }
            case 11: {
                return pSWPDCAppEntityBase.getUpdateMan();
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
        PSWPDCAppEntityBase.set(this, n, object);
    }

    private static void set(PSWPDCAppEntityBase pSWPDCAppEntityBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCAppEntityBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCAppEntityBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCAppEntityBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCAppEntityBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCAppEntityBase.setPSWPAppEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCAppEntityBase.setPSWPAppEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCAppEntityBase.setPSWPDCAppEntityId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCAppEntityBase.setPSWPDCAppEntityName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWPDCAppEntityBase.setPSWPDCAppInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWPDCAppEntityBase.setPSWPDCAppInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWPDCAppEntityBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSWPDCAppEntityBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPDCAppEntityBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCAppEntityBase pSWPDCAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppEntityBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCAppEntityBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCAppEntityBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSWPDCAppEntityBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSWPDCAppEntityBase.getPSWPAppEntityId() == null;
            }
            case 5: {
                return pSWPDCAppEntityBase.getPSWPAppEntityName() == null;
            }
            case 6: {
                return pSWPDCAppEntityBase.getPSWPDCAppEntityId() == null;
            }
            case 7: {
                return pSWPDCAppEntityBase.getPSWPDCAppEntityName() == null;
            }
            case 8: {
                return pSWPDCAppEntityBase.getPSWPDCAppInstId() == null;
            }
            case 9: {
                return pSWPDCAppEntityBase.getPSWPDCAppInstName() == null;
            }
            case 10: {
                return pSWPDCAppEntityBase.getUpdateDate() == null;
            }
            case 11: {
                return pSWPDCAppEntityBase.getUpdateMan() == null;
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
        return PSWPDCAppEntityBase.contains(this, n);
    }

    private static boolean contains(PSWPDCAppEntityBase pSWPDCAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCAppEntityBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCAppEntityBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCAppEntityBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSWPDCAppEntityBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSWPDCAppEntityBase.isPSWPAppEntityIdDirty();
            }
            case 5: {
                return pSWPDCAppEntityBase.isPSWPAppEntityNameDirty();
            }
            case 6: {
                return pSWPDCAppEntityBase.isPSWPDCAppEntityIdDirty();
            }
            case 7: {
                return pSWPDCAppEntityBase.isPSWPDCAppEntityNameDirty();
            }
            case 8: {
                return pSWPDCAppEntityBase.isPSWPDCAppInstIdDirty();
            }
            case 9: {
                return pSWPDCAppEntityBase.isPSWPDCAppInstNameDirty();
            }
            case 10: {
                return pSWPDCAppEntityBase.isUpdateDateDirty();
            }
            case 11: {
                return pSWPDCAppEntityBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCAppEntityBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCAppEntityBase pSWPDCAppEntityBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCAppEntityBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPAppEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappentityid", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPAppEntityId()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPAppEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpappentityname", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPAppEntityName()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappentityid", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPDCAppEntityId()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappentityname", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPDCAppEntityName()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappinstid", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPDCAppInstId()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcappinstname", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getPSWPDCAppInstName()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCAppEntityBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCAppEntityBase.getJSONValue((Object)pSWPDCAppEntityBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCAppEntityBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCAppEntityBase pSWPDCAppEntityBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCAppEntityBase.getCreateDate() != null) {
            object = pSWPDCAppEntityBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCAppEntityBase.getCreateMan() != null) {
            object = pSWPDCAppEntityBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSDevCenterId() != null) {
            object = pSWPDCAppEntityBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSDevCenterName() != null) {
            object = pSWPDCAppEntityBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPAppEntityId() != null) {
            object = pSWPDCAppEntityBase.getPSWPAppEntityId();
            xmlNode.setAttribute(FIELD_PSWPAPPENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPAppEntityName() != null) {
            object = pSWPDCAppEntityBase.getPSWPAppEntityName();
            xmlNode.setAttribute(FIELD_PSWPAPPENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityId() != null) {
            object = pSWPDCAppEntityBase.getPSWPDCAppEntityId();
            xmlNode.setAttribute(FIELD_PSWPDCAPPENTITYID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityName() != null) {
            object = pSWPDCAppEntityBase.getPSWPDCAppEntityName();
            xmlNode.setAttribute(FIELD_PSWPDCAPPENTITYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppInstId() != null) {
            object = pSWPDCAppEntityBase.getPSWPDCAppInstId();
            xmlNode.setAttribute(FIELD_PSWPDCAPPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getPSWPDCAppInstName() != null) {
            object = pSWPDCAppEntityBase.getPSWPDCAppInstName();
            xmlNode.setAttribute(FIELD_PSWPDCAPPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCAppEntityBase.getUpdateDate() != null) {
            object = pSWPDCAppEntityBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCAppEntityBase.getUpdateMan() != null) {
            object = pSWPDCAppEntityBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCAppEntityBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCAppEntityBase pSWPDCAppEntityBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCAppEntityBase.isCreateDateDirty() && (bl || pSWPDCAppEntityBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCAppEntityBase.getCreateDate());
        }
        if (pSWPDCAppEntityBase.isCreateManDirty() && (bl || pSWPDCAppEntityBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCAppEntityBase.getCreateMan());
        }
        if (pSWPDCAppEntityBase.isPSDevCenterIdDirty() && (bl || pSWPDCAppEntityBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWPDCAppEntityBase.getPSDevCenterId());
        }
        if (pSWPDCAppEntityBase.isPSDevCenterNameDirty() && (bl || pSWPDCAppEntityBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWPDCAppEntityBase.getPSDevCenterName());
        }
        if (pSWPDCAppEntityBase.isPSWPAppEntityIdDirty() && (bl || pSWPDCAppEntityBase.getPSWPAppEntityId() != null)) {
            iDataObject.set(FIELD_PSWPAPPENTITYID, (Object)pSWPDCAppEntityBase.getPSWPAppEntityId());
        }
        if (pSWPDCAppEntityBase.isPSWPAppEntityNameDirty() && (bl || pSWPDCAppEntityBase.getPSWPAppEntityName() != null)) {
            iDataObject.set(FIELD_PSWPAPPENTITYNAME, (Object)pSWPDCAppEntityBase.getPSWPAppEntityName());
        }
        if (pSWPDCAppEntityBase.isPSWPDCAppEntityIdDirty() && (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityId() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPENTITYID, (Object)pSWPDCAppEntityBase.getPSWPDCAppEntityId());
        }
        if (pSWPDCAppEntityBase.isPSWPDCAppEntityNameDirty() && (bl || pSWPDCAppEntityBase.getPSWPDCAppEntityName() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPENTITYNAME, (Object)pSWPDCAppEntityBase.getPSWPDCAppEntityName());
        }
        if (pSWPDCAppEntityBase.isPSWPDCAppInstIdDirty() && (bl || pSWPDCAppEntityBase.getPSWPDCAppInstId() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPINSTID, (Object)pSWPDCAppEntityBase.getPSWPDCAppInstId());
        }
        if (pSWPDCAppEntityBase.isPSWPDCAppInstNameDirty() && (bl || pSWPDCAppEntityBase.getPSWPDCAppInstName() != null)) {
            iDataObject.set(FIELD_PSWPDCAPPINSTNAME, (Object)pSWPDCAppEntityBase.getPSWPDCAppInstName());
        }
        if (pSWPDCAppEntityBase.isUpdateDateDirty() && (bl || pSWPDCAppEntityBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCAppEntityBase.getUpdateDate());
        }
        if (pSWPDCAppEntityBase.isUpdateManDirty() && (bl || pSWPDCAppEntityBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCAppEntityBase.getUpdateMan());
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
        return PSWPDCAppEntityBase.remove(this, n);
    }

    private static boolean remove(PSWPDCAppEntityBase pSWPDCAppEntityBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCAppEntityBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCAppEntityBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCAppEntityBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSWPDCAppEntityBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSWPDCAppEntityBase.resetPSWPAppEntityId();
                return true;
            }
            case 5: {
                pSWPDCAppEntityBase.resetPSWPAppEntityName();
                return true;
            }
            case 6: {
                pSWPDCAppEntityBase.resetPSWPDCAppEntityId();
                return true;
            }
            case 7: {
                pSWPDCAppEntityBase.resetPSWPDCAppEntityName();
                return true;
            }
            case 8: {
                pSWPDCAppEntityBase.resetPSWPDCAppInstId();
                return true;
            }
            case 9: {
                pSWPDCAppEntityBase.resetPSWPDCAppInstName();
                return true;
            }
            case 10: {
                pSWPDCAppEntityBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSWPDCAppEntityBase.resetUpdateMan();
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPAppEntity getPSWPAppEntity() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPAppEntity();
        }
        if (this.getPSWPAppEntityId() == null) {
            return null;
        }
        Integer n = this.objPSWPAppEntityLock;
        synchronized (n) {
            if (this.pswpappentity != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPAppEntityId(), (Object)this.pswpappentity.getPSWPAppEntityId()) != 0L) {
                this.pswpappentity = null;
            }
            if (this.pswpappentity == null) {
                PSWPAppEntity pSWPAppEntity = new PSWPAppEntity();
                pSWPAppEntity.setPSWPAppEntityId(this.getPSWPAppEntityId());
                PSWPAppEntityService pSWPAppEntityService = (PSWPAppEntityService)ServiceGlobal.getService(PSWPAppEntityService.class, (SessionFactory)this.getSessionFactory());
                pSWPAppEntityService.autoGet(pSWPAppEntity);
                this.pswpappentity = pSWPAppEntity;
            }
            return this.pswpappentity;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWPDCAppInst getPSWPDCAppInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCAppInst();
        }
        if (this.getPSWPDCAppInstId() == null) {
            return null;
        }
        Integer n = this.objPSWPDCAppInstLock;
        synchronized (n) {
            if (this.pswpdcappinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSWPDCAppInstId(), (Object)this.pswpdcappinst.getPSWPDCAppInstId()) != 0L) {
                this.pswpdcappinst = null;
            }
            if (this.pswpdcappinst == null) {
                PSWPDCAppInst pSWPDCAppInst = new PSWPDCAppInst();
                pSWPDCAppInst.setPSWPDCAppInstId(this.getPSWPDCAppInstId());
                PSWPDCAppInstService pSWPDCAppInstService = (PSWPDCAppInstService)ServiceGlobal.getService(PSWPDCAppInstService.class, (SessionFactory)this.getSessionFactory());
                pSWPDCAppInstService.autoGet(pSWPDCAppInst);
                this.pswpdcappinst = pSWPDCAppInst;
            }
            return this.pswpdcappinst;
        }
    }

    private PSWPDCAppEntityBase getProxyEntity() {
        return this.proxyPSWPDCAppEntityBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCAppEntityBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCAppEntityBase) {
            this.proxyPSWPDCAppEntityBase = (PSWPDCAppEntityBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCAppEntityService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSWPAPPENTITYID, 4);
        fieldIndexMap.put(FIELD_PSWPAPPENTITYNAME, 5);
        fieldIndexMap.put(FIELD_PSWPDCAPPENTITYID, 6);
        fieldIndexMap.put(FIELD_PSWPDCAPPENTITYNAME, 7);
        fieldIndexMap.put(FIELD_PSWPDCAPPINSTID, 8);
        fieldIndexMap.put(FIELD_PSWPDCAPPINSTNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

