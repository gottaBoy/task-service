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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevCenterPFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevCenterPFBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVCENTERPFID = "PSDEVCENTERPFID";
    public static final String FIELD_PSDEVCENTERPFNAME = "PSDEVCENTERPFNAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSDEVCENTERPFID = 4;
    private static final int INDEX_PSDEVCENTERPFNAME = 5;
    private static final int INDEX_PSPFID = 6;
    private static final int INDEX_PSPFNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevCenterPFBase proxyPSDevCenterPFBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevcenterpfidDirtyFlag = false;
    private boolean psdevcenterpfnameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevcenterpfid")
    private String psdevcenterpfid;
    @Column(name="psdevcenterpfname")
    private String psdevcenterpfname;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;

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

    public void setPSDevCenterPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterpfid = string;
        this.psdevcenterpfidDirtyFlag = true;
    }

    public String getPSDevCenterPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterPFId();
        }
        return this.psdevcenterpfid;
    }

    public boolean isPSDevCenterPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterPFIdDirty();
        }
        return this.psdevcenterpfidDirtyFlag;
    }

    public void resetPSDevCenterPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterPFId();
            return;
        }
        this.psdevcenterpfidDirtyFlag = false;
        this.psdevcenterpfid = null;
    }

    public void setPSDevCenterPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterpfname = string;
        this.psdevcenterpfnameDirtyFlag = true;
    }

    public String getPSDevCenterPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterPFName();
        }
        return this.psdevcenterpfname;
    }

    public boolean isPSDevCenterPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterPFNameDirty();
        }
        return this.psdevcenterpfnameDirtyFlag;
    }

    public void resetPSDevCenterPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterPFName();
            return;
        }
        this.psdevcenterpfnameDirtyFlag = false;
        this.psdevcenterpfname = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
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
        PSDevCenterPFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevCenterPFBase pSDevCenterPFBase) {
        pSDevCenterPFBase.resetCreateDate();
        pSDevCenterPFBase.resetCreateMan();
        pSDevCenterPFBase.resetPSDevCenterId();
        pSDevCenterPFBase.resetPSDevCenterName();
        pSDevCenterPFBase.resetPSDevCenterPFId();
        pSDevCenterPFBase.resetPSDevCenterPFName();
        pSDevCenterPFBase.resetPSPFId();
        pSDevCenterPFBase.resetPSPFName();
        pSDevCenterPFBase.resetUpdateDate();
        pSDevCenterPFBase.resetUpdateMan();
        pSDevCenterPFBase.resetValidFlag();
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
        if (!bl || this.isPSDevCenterPFIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERPFID, this.getPSDevCenterPFId());
        }
        if (!bl || this.isPSDevCenterPFNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERPFNAME, this.getPSDevCenterPFName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
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
        return PSDevCenterPFBase.get(this, n);
    }

    private static Object get(PSDevCenterPFBase pSDevCenterPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterPFBase.getCreateDate();
            }
            case 1: {
                return pSDevCenterPFBase.getCreateMan();
            }
            case 2: {
                return pSDevCenterPFBase.getPSDevCenterId();
            }
            case 3: {
                return pSDevCenterPFBase.getPSDevCenterName();
            }
            case 4: {
                return pSDevCenterPFBase.getPSDevCenterPFId();
            }
            case 5: {
                return pSDevCenterPFBase.getPSDevCenterPFName();
            }
            case 6: {
                return pSDevCenterPFBase.getPSPFId();
            }
            case 7: {
                return pSDevCenterPFBase.getPSPFName();
            }
            case 8: {
                return pSDevCenterPFBase.getUpdateDate();
            }
            case 9: {
                return pSDevCenterPFBase.getUpdateMan();
            }
            case 10: {
                return pSDevCenterPFBase.getValidFlag();
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
        PSDevCenterPFBase.set(this, n, object);
    }

    private static void set(PSDevCenterPFBase pSDevCenterPFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterPFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevCenterPFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevCenterPFBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevCenterPFBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevCenterPFBase.setPSDevCenterPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevCenterPFBase.setPSDevCenterPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevCenterPFBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevCenterPFBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevCenterPFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevCenterPFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevCenterPFBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevCenterPFBase.isNull(this, n);
    }

    private static boolean isNull(PSDevCenterPFBase pSDevCenterPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterPFBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevCenterPFBase.getCreateMan() == null;
            }
            case 2: {
                return pSDevCenterPFBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSDevCenterPFBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSDevCenterPFBase.getPSDevCenterPFId() == null;
            }
            case 5: {
                return pSDevCenterPFBase.getPSDevCenterPFName() == null;
            }
            case 6: {
                return pSDevCenterPFBase.getPSPFId() == null;
            }
            case 7: {
                return pSDevCenterPFBase.getPSPFName() == null;
            }
            case 8: {
                return pSDevCenterPFBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDevCenterPFBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDevCenterPFBase.getValidFlag() == null;
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
        return PSDevCenterPFBase.contains(this, n);
    }

    private static boolean contains(PSDevCenterPFBase pSDevCenterPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevCenterPFBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevCenterPFBase.isCreateManDirty();
            }
            case 2: {
                return pSDevCenterPFBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSDevCenterPFBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSDevCenterPFBase.isPSDevCenterPFIdDirty();
            }
            case 5: {
                return pSDevCenterPFBase.isPSDevCenterPFNameDirty();
            }
            case 6: {
                return pSDevCenterPFBase.isPSPFIdDirty();
            }
            case 7: {
                return pSDevCenterPFBase.isPSPFNameDirty();
            }
            case 8: {
                return pSDevCenterPFBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDevCenterPFBase.isUpdateManDirty();
            }
            case 10: {
                return pSDevCenterPFBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevCenterPFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevCenterPFBase pSDevCenterPFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevCenterPFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterpfid", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSDevCenterPFId()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterpfname", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSDevCenterPFName()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevCenterPFBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevCenterPFBase.getJSONValue((Object)pSDevCenterPFBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevCenterPFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevCenterPFBase pSDevCenterPFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevCenterPFBase.getCreateDate() != null) {
            object = pSDevCenterPFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterPFBase.getCreateMan() != null) {
            object = pSDevCenterPFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterId() != null) {
            object = pSDevCenterPFBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterName() != null) {
            object = pSDevCenterPFBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterPFId() != null) {
            object = pSDevCenterPFBase.getPSDevCenterPFId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSDevCenterPFName() != null) {
            object = pSDevCenterPFBase.getPSDevCenterPFName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSPFId() != null) {
            object = pSDevCenterPFBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getPSPFName() != null) {
            object = pSDevCenterPFBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getUpdateDate() != null) {
            object = pSDevCenterPFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevCenterPFBase.getUpdateMan() != null) {
            object = pSDevCenterPFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevCenterPFBase.getValidFlag() != null) {
            object = pSDevCenterPFBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevCenterPFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevCenterPFBase pSDevCenterPFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevCenterPFBase.isCreateDateDirty() && (bl || pSDevCenterPFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevCenterPFBase.getCreateDate());
        }
        if (pSDevCenterPFBase.isCreateManDirty() && (bl || pSDevCenterPFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevCenterPFBase.getCreateMan());
        }
        if (pSDevCenterPFBase.isPSDevCenterIdDirty() && (bl || pSDevCenterPFBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevCenterPFBase.getPSDevCenterId());
        }
        if (pSDevCenterPFBase.isPSDevCenterNameDirty() && (bl || pSDevCenterPFBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevCenterPFBase.getPSDevCenterName());
        }
        if (pSDevCenterPFBase.isPSDevCenterPFIdDirty() && (bl || pSDevCenterPFBase.getPSDevCenterPFId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERPFID, (Object)pSDevCenterPFBase.getPSDevCenterPFId());
        }
        if (pSDevCenterPFBase.isPSDevCenterPFNameDirty() && (bl || pSDevCenterPFBase.getPSDevCenterPFName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERPFNAME, (Object)pSDevCenterPFBase.getPSDevCenterPFName());
        }
        if (pSDevCenterPFBase.isPSPFIdDirty() && (bl || pSDevCenterPFBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSDevCenterPFBase.getPSPFId());
        }
        if (pSDevCenterPFBase.isPSPFNameDirty() && (bl || pSDevCenterPFBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSDevCenterPFBase.getPSPFName());
        }
        if (pSDevCenterPFBase.isUpdateDateDirty() && (bl || pSDevCenterPFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevCenterPFBase.getUpdateDate());
        }
        if (pSDevCenterPFBase.isUpdateManDirty() && (bl || pSDevCenterPFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevCenterPFBase.getUpdateMan());
        }
        if (pSDevCenterPFBase.isValidFlagDirty() && (bl || pSDevCenterPFBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevCenterPFBase.getValidFlag());
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
        return PSDevCenterPFBase.remove(this, n);
    }

    private static boolean remove(PSDevCenterPFBase pSDevCenterPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevCenterPFBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevCenterPFBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDevCenterPFBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSDevCenterPFBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSDevCenterPFBase.resetPSDevCenterPFId();
                return true;
            }
            case 5: {
                pSDevCenterPFBase.resetPSDevCenterPFName();
                return true;
            }
            case 6: {
                pSDevCenterPFBase.resetPSPFId();
                return true;
            }
            case 7: {
                pSDevCenterPFBase.resetPSPFName();
                return true;
            }
            case 8: {
                pSDevCenterPFBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDevCenterPFBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDevCenterPFBase.resetValidFlag();
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
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    private PSDevCenterPFBase getProxyEntity() {
        return this.proxyPSDevCenterPFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevCenterPFBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevCenterPFBase) {
            this.proxyPSDevCenterPFBase = (PSDevCenterPFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevCenterPFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERPFID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERPFNAME, 5);
        fieldIndexMap.put(FIELD_PSPFID, 6);
        fieldIndexMap.put(FIELD_PSPFNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

