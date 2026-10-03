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
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWPDCWFCatBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCWFCatBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWPDCWFCATID = "PSWPDCWFCATID";
    public static final String FIELD_PSWPDCWFCATNAME = "PSWPDCWFCATNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSWPDCWFCATID = 4;
    private static final int INDEX_PSWPDCWFCATNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCWFCatBase proxyPSWPDCWFCatBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pswpdcwfcatidDirtyFlag = false;
    private boolean pswpdcwfcatnameDirtyFlag = false;
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
    @Column(name="pswpdcwfcatid")
    private String pswpdcwfcatid;
    @Column(name="pswpdcwfcatname")
    private String pswpdcwfcatname;
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

    public void setPSWPDCWFCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWFCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcwfcatid = string;
        this.pswpdcwfcatidDirtyFlag = true;
    }

    public String getPSWPDCWFCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWFCatId();
        }
        return this.pswpdcwfcatid;
    }

    public boolean isPSWPDCWFCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWFCatIdDirty();
        }
        return this.pswpdcwfcatidDirtyFlag;
    }

    public void resetPSWPDCWFCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWFCatId();
            return;
        }
        this.pswpdcwfcatidDirtyFlag = false;
        this.pswpdcwfcatid = null;
    }

    public void setPSWPDCWFCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWFCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcwfcatname = string;
        this.pswpdcwfcatnameDirtyFlag = true;
    }

    public String getPSWPDCWFCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWFCatName();
        }
        return this.pswpdcwfcatname;
    }

    public boolean isPSWPDCWFCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWFCatNameDirty();
        }
        return this.pswpdcwfcatnameDirtyFlag;
    }

    public void resetPSWPDCWFCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWFCatName();
            return;
        }
        this.pswpdcwfcatnameDirtyFlag = false;
        this.pswpdcwfcatname = null;
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
        PSWPDCWFCatBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCWFCatBase pSWPDCWFCatBase) {
        pSWPDCWFCatBase.resetCreateDate();
        pSWPDCWFCatBase.resetCreateMan();
        pSWPDCWFCatBase.resetPSDevCenterId();
        pSWPDCWFCatBase.resetPSDevCenterName();
        pSWPDCWFCatBase.resetPSWPDCWFCatId();
        pSWPDCWFCatBase.resetPSWPDCWFCatName();
        pSWPDCWFCatBase.resetUpdateDate();
        pSWPDCWFCatBase.resetUpdateMan();
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
        if (!bl || this.isPSWPDCWFCatIdDirty()) {
            hashMap.put(FIELD_PSWPDCWFCATID, this.getPSWPDCWFCatId());
        }
        if (!bl || this.isPSWPDCWFCatNameDirty()) {
            hashMap.put(FIELD_PSWPDCWFCATNAME, this.getPSWPDCWFCatName());
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
        return PSWPDCWFCatBase.get(this, n);
    }

    private static Object get(PSWPDCWFCatBase pSWPDCWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFCatBase.getCreateDate();
            }
            case 1: {
                return pSWPDCWFCatBase.getCreateMan();
            }
            case 2: {
                return pSWPDCWFCatBase.getPSDevCenterId();
            }
            case 3: {
                return pSWPDCWFCatBase.getPSDevCenterName();
            }
            case 4: {
                return pSWPDCWFCatBase.getPSWPDCWFCatId();
            }
            case 5: {
                return pSWPDCWFCatBase.getPSWPDCWFCatName();
            }
            case 6: {
                return pSWPDCWFCatBase.getUpdateDate();
            }
            case 7: {
                return pSWPDCWFCatBase.getUpdateMan();
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
        PSWPDCWFCatBase.set(this, n, object);
    }

    private static void set(PSWPDCWFCatBase pSWPDCWFCatBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWFCatBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCWFCatBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCWFCatBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCWFCatBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCWFCatBase.setPSWPDCWFCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCWFCatBase.setPSWPDCWFCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCWFCatBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCWFCatBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWPDCWFCatBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCWFCatBase pSWPDCWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFCatBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCWFCatBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCWFCatBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSWPDCWFCatBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSWPDCWFCatBase.getPSWPDCWFCatId() == null;
            }
            case 5: {
                return pSWPDCWFCatBase.getPSWPDCWFCatName() == null;
            }
            case 6: {
                return pSWPDCWFCatBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWPDCWFCatBase.getUpdateMan() == null;
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
        return PSWPDCWFCatBase.contains(this, n);
    }

    private static boolean contains(PSWPDCWFCatBase pSWPDCWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWFCatBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCWFCatBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCWFCatBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSWPDCWFCatBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSWPDCWFCatBase.isPSWPDCWFCatIdDirty();
            }
            case 5: {
                return pSWPDCWFCatBase.isPSWPDCWFCatNameDirty();
            }
            case 6: {
                return pSWPDCWFCatBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWPDCWFCatBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCWFCatBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCWFCatBase pSWPDCWFCatBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCWFCatBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getPSWPDCWFCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcwfcatid", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getPSWPDCWFCatId()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getPSWPDCWFCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcwfcatname", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getPSWPDCWFCatName()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCWFCatBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCWFCatBase.getJSONValue((Object)pSWPDCWFCatBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCWFCatBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCWFCatBase pSWPDCWFCatBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCWFCatBase.getCreateDate() != null) {
            object = pSWPDCWFCatBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWFCatBase.getCreateMan() != null) {
            object = pSWPDCWFCatBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFCatBase.getPSDevCenterId() != null) {
            object = pSWPDCWFCatBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFCatBase.getPSDevCenterName() != null) {
            object = pSWPDCWFCatBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFCatBase.getPSWPDCWFCatId() != null) {
            object = pSWPDCWFCatBase.getPSWPDCWFCatId();
            xmlNode.setAttribute(FIELD_PSWPDCWFCATID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFCatBase.getPSWPDCWFCatName() != null) {
            object = pSWPDCWFCatBase.getPSWPDCWFCatName();
            xmlNode.setAttribute(FIELD_PSWPDCWFCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWFCatBase.getUpdateDate() != null) {
            object = pSWPDCWFCatBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWFCatBase.getUpdateMan() != null) {
            object = pSWPDCWFCatBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCWFCatBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCWFCatBase pSWPDCWFCatBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCWFCatBase.isCreateDateDirty() && (bl || pSWPDCWFCatBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCWFCatBase.getCreateDate());
        }
        if (pSWPDCWFCatBase.isCreateManDirty() && (bl || pSWPDCWFCatBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCWFCatBase.getCreateMan());
        }
        if (pSWPDCWFCatBase.isPSDevCenterIdDirty() && (bl || pSWPDCWFCatBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWPDCWFCatBase.getPSDevCenterId());
        }
        if (pSWPDCWFCatBase.isPSDevCenterNameDirty() && (bl || pSWPDCWFCatBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWPDCWFCatBase.getPSDevCenterName());
        }
        if (pSWPDCWFCatBase.isPSWPDCWFCatIdDirty() && (bl || pSWPDCWFCatBase.getPSWPDCWFCatId() != null)) {
            iDataObject.set(FIELD_PSWPDCWFCATID, (Object)pSWPDCWFCatBase.getPSWPDCWFCatId());
        }
        if (pSWPDCWFCatBase.isPSWPDCWFCatNameDirty() && (bl || pSWPDCWFCatBase.getPSWPDCWFCatName() != null)) {
            iDataObject.set(FIELD_PSWPDCWFCATNAME, (Object)pSWPDCWFCatBase.getPSWPDCWFCatName());
        }
        if (pSWPDCWFCatBase.isUpdateDateDirty() && (bl || pSWPDCWFCatBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCWFCatBase.getUpdateDate());
        }
        if (pSWPDCWFCatBase.isUpdateManDirty() && (bl || pSWPDCWFCatBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCWFCatBase.getUpdateMan());
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
        return PSWPDCWFCatBase.remove(this, n);
    }

    private static boolean remove(PSWPDCWFCatBase pSWPDCWFCatBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWFCatBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCWFCatBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCWFCatBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSWPDCWFCatBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSWPDCWFCatBase.resetPSWPDCWFCatId();
                return true;
            }
            case 5: {
                pSWPDCWFCatBase.resetPSWPDCWFCatName();
                return true;
            }
            case 6: {
                pSWPDCWFCatBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWPDCWFCatBase.resetUpdateMan();
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

    private PSWPDCWFCatBase getProxyEntity() {
        return this.proxyPSWPDCWFCatBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCWFCatBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCWFCatBase) {
            this.proxyPSWPDCWFCatBase = (PSWPDCWFCatBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWFCatService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSWPDCWFCATID, 4);
        fieldIndexMap.put(FIELD_PSWPDCWFCATNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

