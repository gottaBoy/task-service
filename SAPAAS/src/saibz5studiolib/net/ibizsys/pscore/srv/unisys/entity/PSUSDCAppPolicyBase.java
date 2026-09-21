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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCAppPolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSDCAppPolicyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSUSDCAPPPOLICYID = "PSUSDCAPPPOLICYID";
    public static final String FIELD_PSUSDCAPPPOLICYNAME = "PSUSDCAPPPOLICYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSUSDCAPPPOLICYID = 4;
    private static final int INDEX_PSUSDCAPPPOLICYNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSDCAppPolicyBase proxyPSUSDCAppPolicyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psusdcapppolicyidDirtyFlag = false;
    private boolean psusdcapppolicynameDirtyFlag = false;
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
    @Column(name="psusdcapppolicyid")
    private String psusdcapppolicyid;
    @Column(name="psusdcapppolicyname")
    private String psusdcapppolicyname;
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

    public void setPSUSDCAppPolicyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCAppPolicyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcapppolicyid = string;
        this.psusdcapppolicyidDirtyFlag = true;
    }

    public String getPSUSDCAppPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCAppPolicyId();
        }
        return this.psusdcapppolicyid;
    }

    public boolean isPSUSDCAppPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCAppPolicyIdDirty();
        }
        return this.psusdcapppolicyidDirtyFlag;
    }

    public void resetPSUSDCAppPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCAppPolicyId();
            return;
        }
        this.psusdcapppolicyidDirtyFlag = false;
        this.psusdcapppolicyid = null;
    }

    public void setPSUSDCAppPolicyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCAppPolicyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcapppolicyname = string;
        this.psusdcapppolicynameDirtyFlag = true;
    }

    public String getPSUSDCAppPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCAppPolicyName();
        }
        return this.psusdcapppolicyname;
    }

    public boolean isPSUSDCAppPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCAppPolicyNameDirty();
        }
        return this.psusdcapppolicynameDirtyFlag;
    }

    public void resetPSUSDCAppPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCAppPolicyName();
            return;
        }
        this.psusdcapppolicynameDirtyFlag = false;
        this.psusdcapppolicyname = null;
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
        PSUSDCAppPolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSDCAppPolicyBase pSUSDCAppPolicyBase) {
        pSUSDCAppPolicyBase.resetCreateDate();
        pSUSDCAppPolicyBase.resetCreateMan();
        pSUSDCAppPolicyBase.resetPSDevCenterId();
        pSUSDCAppPolicyBase.resetPSDevCenterName();
        pSUSDCAppPolicyBase.resetPSUSDCAppPolicyId();
        pSUSDCAppPolicyBase.resetPSUSDCAppPolicyName();
        pSUSDCAppPolicyBase.resetUpdateDate();
        pSUSDCAppPolicyBase.resetUpdateMan();
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
        if (!bl || this.isPSUSDCAppPolicyIdDirty()) {
            hashMap.put(FIELD_PSUSDCAPPPOLICYID, this.getPSUSDCAppPolicyId());
        }
        if (!bl || this.isPSUSDCAppPolicyNameDirty()) {
            hashMap.put(FIELD_PSUSDCAPPPOLICYNAME, this.getPSUSDCAppPolicyName());
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
        return PSUSDCAppPolicyBase.get(this, n);
    }

    private static Object get(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCAppPolicyBase.getCreateDate();
            }
            case 1: {
                return pSUSDCAppPolicyBase.getCreateMan();
            }
            case 2: {
                return pSUSDCAppPolicyBase.getPSDevCenterId();
            }
            case 3: {
                return pSUSDCAppPolicyBase.getPSDevCenterName();
            }
            case 4: {
                return pSUSDCAppPolicyBase.getPSUSDCAppPolicyId();
            }
            case 5: {
                return pSUSDCAppPolicyBase.getPSUSDCAppPolicyName();
            }
            case 6: {
                return pSUSDCAppPolicyBase.getUpdateDate();
            }
            case 7: {
                return pSUSDCAppPolicyBase.getUpdateMan();
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
        PSUSDCAppPolicyBase.set(this, n, object);
    }

    private static void set(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCAppPolicyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSDCAppPolicyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSDCAppPolicyBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSDCAppPolicyBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSDCAppPolicyBase.setPSUSDCAppPolicyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSDCAppPolicyBase.setPSUSDCAppPolicyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSDCAppPolicyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSUSDCAppPolicyBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUSDCAppPolicyBase.isNull(this, n);
    }

    private static boolean isNull(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCAppPolicyBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSDCAppPolicyBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSDCAppPolicyBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSUSDCAppPolicyBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSUSDCAppPolicyBase.getPSUSDCAppPolicyId() == null;
            }
            case 5: {
                return pSUSDCAppPolicyBase.getPSUSDCAppPolicyName() == null;
            }
            case 6: {
                return pSUSDCAppPolicyBase.getUpdateDate() == null;
            }
            case 7: {
                return pSUSDCAppPolicyBase.getUpdateMan() == null;
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
        return PSUSDCAppPolicyBase.contains(this, n);
    }

    private static boolean contains(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCAppPolicyBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSDCAppPolicyBase.isCreateManDirty();
            }
            case 2: {
                return pSUSDCAppPolicyBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSUSDCAppPolicyBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSUSDCAppPolicyBase.isPSUSDCAppPolicyIdDirty();
            }
            case 5: {
                return pSUSDCAppPolicyBase.isPSUSDCAppPolicyNameDirty();
            }
            case 6: {
                return pSUSDCAppPolicyBase.isUpdateDateDirty();
            }
            case 7: {
                return pSUSDCAppPolicyBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSDCAppPolicyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSDCAppPolicyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcapppolicyid", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getPSUSDCAppPolicyId()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcapppolicyname", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getPSUSDCAppPolicyName()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSDCAppPolicyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSDCAppPolicyBase.getJSONValue((Object)pSUSDCAppPolicyBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSDCAppPolicyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSDCAppPolicyBase.getCreateDate() != null) {
            object = pSUSDCAppPolicyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCAppPolicyBase.getCreateMan() != null) {
            object = pSUSDCAppPolicyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCAppPolicyBase.getPSDevCenterId() != null) {
            object = pSUSDCAppPolicyBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCAppPolicyBase.getPSDevCenterName() != null) {
            object = pSUSDCAppPolicyBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyId() != null) {
            object = pSUSDCAppPolicyBase.getPSUSDCAppPolicyId();
            xmlNode.setAttribute(FIELD_PSUSDCAPPPOLICYID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyName() != null) {
            object = pSUSDCAppPolicyBase.getPSUSDCAppPolicyName();
            xmlNode.setAttribute(FIELD_PSUSDCAPPPOLICYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCAppPolicyBase.getUpdateDate() != null) {
            object = pSUSDCAppPolicyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCAppPolicyBase.getUpdateMan() != null) {
            object = pSUSDCAppPolicyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSDCAppPolicyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSDCAppPolicyBase.isCreateDateDirty() && (bl || pSUSDCAppPolicyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSDCAppPolicyBase.getCreateDate());
        }
        if (pSUSDCAppPolicyBase.isCreateManDirty() && (bl || pSUSDCAppPolicyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSDCAppPolicyBase.getCreateMan());
        }
        if (pSUSDCAppPolicyBase.isPSDevCenterIdDirty() && (bl || pSUSDCAppPolicyBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSUSDCAppPolicyBase.getPSDevCenterId());
        }
        if (pSUSDCAppPolicyBase.isPSDevCenterNameDirty() && (bl || pSUSDCAppPolicyBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSUSDCAppPolicyBase.getPSDevCenterName());
        }
        if (pSUSDCAppPolicyBase.isPSUSDCAppPolicyIdDirty() && (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyId() != null)) {
            iDataObject.set(FIELD_PSUSDCAPPPOLICYID, (Object)pSUSDCAppPolicyBase.getPSUSDCAppPolicyId());
        }
        if (pSUSDCAppPolicyBase.isPSUSDCAppPolicyNameDirty() && (bl || pSUSDCAppPolicyBase.getPSUSDCAppPolicyName() != null)) {
            iDataObject.set(FIELD_PSUSDCAPPPOLICYNAME, (Object)pSUSDCAppPolicyBase.getPSUSDCAppPolicyName());
        }
        if (pSUSDCAppPolicyBase.isUpdateDateDirty() && (bl || pSUSDCAppPolicyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSDCAppPolicyBase.getUpdateDate());
        }
        if (pSUSDCAppPolicyBase.isUpdateManDirty() && (bl || pSUSDCAppPolicyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSDCAppPolicyBase.getUpdateMan());
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
        return PSUSDCAppPolicyBase.remove(this, n);
    }

    private static boolean remove(PSUSDCAppPolicyBase pSUSDCAppPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCAppPolicyBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSDCAppPolicyBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSDCAppPolicyBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSUSDCAppPolicyBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSUSDCAppPolicyBase.resetPSUSDCAppPolicyId();
                return true;
            }
            case 5: {
                pSUSDCAppPolicyBase.resetPSUSDCAppPolicyName();
                return true;
            }
            case 6: {
                pSUSDCAppPolicyBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSUSDCAppPolicyBase.resetUpdateMan();
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

    private PSUSDCAppPolicyBase getProxyEntity() {
        return this.proxyPSUSDCAppPolicyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSDCAppPolicyBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSDCAppPolicyBase) {
            this.proxyPSUSDCAppPolicyBase = (PSUSDCAppPolicyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCAppPolicyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSUSDCAPPPOLICYID, 4);
        fieldIndexMap.put(FIELD_PSUSDCAPPPOLICYNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

