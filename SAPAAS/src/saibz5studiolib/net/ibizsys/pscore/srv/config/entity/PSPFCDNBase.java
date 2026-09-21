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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSPFCDNBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFCDNBase.class);
    public static final String FIELD_CDNURL = "CDNURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSPFCDNID = "PSPFCDNID";
    public static final String FIELD_PSPFCDNNAME = "PSPFCDNNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CDNURL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_PSPFCDNID = 6;
    private static final int INDEX_PSPFCDNNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFCDNBase proxyPSPFCDNBase = null;
    private boolean cdnurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pspfcdnidDirtyFlag = false;
    private boolean pspfcdnnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cdnurl")
    private String cdnurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pspfcdnid")
    private String pspfcdnid;
    @Column(name="pspfcdnname")
    private String pspfcdnname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

    public void setCDNURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCDNURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cdnurl = string;
        this.cdnurlDirtyFlag = true;
    }

    public String getCDNURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCDNURL();
        }
        return this.cdnurl;
    }

    public boolean isCDNURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCDNURLDirty();
        }
        return this.cdnurlDirtyFlag;
    }

    public void resetCDNURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCDNURL();
            return;
        }
        this.cdnurlDirtyFlag = false;
        this.cdnurl = null;
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

    public void setPSPFCDNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnid = string;
        this.pspfcdnidDirtyFlag = true;
    }

    public String getPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNId();
        }
        return this.pspfcdnid;
    }

    public boolean isPSPFCDNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNIdDirty();
        }
        return this.pspfcdnidDirtyFlag;
    }

    public void resetPSPFCDNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNId();
            return;
        }
        this.pspfcdnidDirtyFlag = false;
        this.pspfcdnid = null;
    }

    public void setPSPFCDNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFCDNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfcdnname = string;
        this.pspfcdnnameDirtyFlag = true;
    }

    public String getPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFCDNName();
        }
        return this.pspfcdnname;
    }

    public boolean isPSPFCDNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFCDNNameDirty();
        }
        return this.pspfcdnnameDirtyFlag;
    }

    public void resetPSPFCDNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFCDNName();
            return;
        }
        this.pspfcdnnameDirtyFlag = false;
        this.pspfcdnname = null;
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
        PSPFCDNBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFCDNBase pSPFCDNBase) {
        pSPFCDNBase.resetCDNURL();
        pSPFCDNBase.resetCreateDate();
        pSPFCDNBase.resetCreateMan();
        pSPFCDNBase.resetMemo();
        pSPFCDNBase.resetPSDevCenterId();
        pSPFCDNBase.resetPSDevCenterName();
        pSPFCDNBase.resetPSPFCDNId();
        pSPFCDNBase.resetPSPFCDNName();
        pSPFCDNBase.resetUpdateDate();
        pSPFCDNBase.resetUpdateMan();
        pSPFCDNBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCDNURLDirty()) {
            hashMap.put(FIELD_CDNURL, this.getCDNURL());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSPFCDNIdDirty()) {
            hashMap.put(FIELD_PSPFCDNID, this.getPSPFCDNId());
        }
        if (!bl || this.isPSPFCDNNameDirty()) {
            hashMap.put(FIELD_PSPFCDNNAME, this.getPSPFCDNName());
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
        return PSPFCDNBase.get(this, n);
    }

    private static Object get(PSPFCDNBase pSPFCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCDNBase.getCDNURL();
            }
            case 1: {
                return pSPFCDNBase.getCreateDate();
            }
            case 2: {
                return pSPFCDNBase.getCreateMan();
            }
            case 3: {
                return pSPFCDNBase.getMemo();
            }
            case 4: {
                return pSPFCDNBase.getPSDevCenterId();
            }
            case 5: {
                return pSPFCDNBase.getPSDevCenterName();
            }
            case 6: {
                return pSPFCDNBase.getPSPFCDNId();
            }
            case 7: {
                return pSPFCDNBase.getPSPFCDNName();
            }
            case 8: {
                return pSPFCDNBase.getUpdateDate();
            }
            case 9: {
                return pSPFCDNBase.getUpdateMan();
            }
            case 10: {
                return pSPFCDNBase.getValidFlag();
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
        PSPFCDNBase.set(this, n, object);
    }

    private static void set(PSPFCDNBase pSPFCDNBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFCDNBase.setCDNURL(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFCDNBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFCDNBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFCDNBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFCDNBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFCDNBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFCDNBase.setPSPFCDNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFCDNBase.setPSPFCDNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFCDNBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSPFCDNBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFCDNBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFCDNBase.isNull(this, n);
    }

    private static boolean isNull(PSPFCDNBase pSPFCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCDNBase.getCDNURL() == null;
            }
            case 1: {
                return pSPFCDNBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFCDNBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFCDNBase.getMemo() == null;
            }
            case 4: {
                return pSPFCDNBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSPFCDNBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSPFCDNBase.getPSPFCDNId() == null;
            }
            case 7: {
                return pSPFCDNBase.getPSPFCDNName() == null;
            }
            case 8: {
                return pSPFCDNBase.getUpdateDate() == null;
            }
            case 9: {
                return pSPFCDNBase.getUpdateMan() == null;
            }
            case 10: {
                return pSPFCDNBase.getValidFlag() == null;
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
        return PSPFCDNBase.contains(this, n);
    }

    private static boolean contains(PSPFCDNBase pSPFCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFCDNBase.isCDNURLDirty();
            }
            case 1: {
                return pSPFCDNBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFCDNBase.isCreateManDirty();
            }
            case 3: {
                return pSPFCDNBase.isMemoDirty();
            }
            case 4: {
                return pSPFCDNBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSPFCDNBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSPFCDNBase.isPSPFCDNIdDirty();
            }
            case 7: {
                return pSPFCDNBase.isPSPFCDNNameDirty();
            }
            case 8: {
                return pSPFCDNBase.isUpdateDateDirty();
            }
            case 9: {
                return pSPFCDNBase.isUpdateManDirty();
            }
            case 10: {
                return pSPFCDNBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFCDNBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFCDNBase pSPFCDNBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFCDNBase.getCDNURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cdnurl", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getCDNURL()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getPSPFCDNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnid", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getPSPFCDNId()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getPSPFCDNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfcdnname", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getPSPFCDNName()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFCDNBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFCDNBase.getJSONValue((Object)pSPFCDNBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFCDNBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFCDNBase pSPFCDNBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFCDNBase.getCDNURL() != null) {
            object = pSPFCDNBase.getCDNURL();
            xmlNode.setAttribute(FIELD_CDNURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getCreateDate() != null) {
            object = pSPFCDNBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCDNBase.getCreateMan() != null) {
            object = pSPFCDNBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getMemo() != null) {
            object = pSPFCDNBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getPSDevCenterId() != null) {
            object = pSPFCDNBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getPSDevCenterName() != null) {
            object = pSPFCDNBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getPSPFCDNId() != null) {
            object = pSPFCDNBase.getPSPFCDNId();
            xmlNode.setAttribute(FIELD_PSPFCDNID, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getPSPFCDNName() != null) {
            object = pSPFCDNBase.getPSPFCDNName();
            xmlNode.setAttribute(FIELD_PSPFCDNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getUpdateDate() != null) {
            object = pSPFCDNBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFCDNBase.getUpdateMan() != null) {
            object = pSPFCDNBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFCDNBase.getValidFlag() != null) {
            object = pSPFCDNBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFCDNBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFCDNBase pSPFCDNBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFCDNBase.isCDNURLDirty() && (bl || pSPFCDNBase.getCDNURL() != null)) {
            iDataObject.set(FIELD_CDNURL, (Object)pSPFCDNBase.getCDNURL());
        }
        if (pSPFCDNBase.isCreateDateDirty() && (bl || pSPFCDNBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFCDNBase.getCreateDate());
        }
        if (pSPFCDNBase.isCreateManDirty() && (bl || pSPFCDNBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFCDNBase.getCreateMan());
        }
        if (pSPFCDNBase.isMemoDirty() && (bl || pSPFCDNBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFCDNBase.getMemo());
        }
        if (pSPFCDNBase.isPSDevCenterIdDirty() && (bl || pSPFCDNBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSPFCDNBase.getPSDevCenterId());
        }
        if (pSPFCDNBase.isPSDevCenterNameDirty() && (bl || pSPFCDNBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSPFCDNBase.getPSDevCenterName());
        }
        if (pSPFCDNBase.isPSPFCDNIdDirty() && (bl || pSPFCDNBase.getPSPFCDNId() != null)) {
            iDataObject.set(FIELD_PSPFCDNID, (Object)pSPFCDNBase.getPSPFCDNId());
        }
        if (pSPFCDNBase.isPSPFCDNNameDirty() && (bl || pSPFCDNBase.getPSPFCDNName() != null)) {
            iDataObject.set(FIELD_PSPFCDNNAME, (Object)pSPFCDNBase.getPSPFCDNName());
        }
        if (pSPFCDNBase.isUpdateDateDirty() && (bl || pSPFCDNBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFCDNBase.getUpdateDate());
        }
        if (pSPFCDNBase.isUpdateManDirty() && (bl || pSPFCDNBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFCDNBase.getUpdateMan());
        }
        if (pSPFCDNBase.isValidFlagDirty() && (bl || pSPFCDNBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFCDNBase.getValidFlag());
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
        return PSPFCDNBase.remove(this, n);
    }

    private static boolean remove(PSPFCDNBase pSPFCDNBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFCDNBase.resetCDNURL();
                return true;
            }
            case 1: {
                pSPFCDNBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFCDNBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFCDNBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFCDNBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSPFCDNBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSPFCDNBase.resetPSPFCDNId();
                return true;
            }
            case 7: {
                pSPFCDNBase.resetPSPFCDNName();
                return true;
            }
            case 8: {
                pSPFCDNBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSPFCDNBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSPFCDNBase.resetValidFlag();
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

    private PSPFCDNBase getProxyEntity() {
        return this.proxyPSPFCDNBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFCDNBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFCDNBase) {
            this.proxyPSPFCDNBase = (PSPFCDNBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFCDNService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CDNURL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_PSPFCDNID, 6);
        fieldIndexMap.put(FIELD_PSPFCDNNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

