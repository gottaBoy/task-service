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

public abstract class PSWPDCWorkflowBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWPDCWorkflowBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSWPDCWORKFLOWID = "PSWPDCWORKFLOWID";
    public static final String FIELD_PSWPDCWORKFLOWNAME = "PSWPDCWORKFLOWNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFSN = "WFSN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSWPDCWORKFLOWID = 4;
    private static final int INDEX_PSWPDCWORKFLOWNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_WFSN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWPDCWorkflowBase proxyPSWPDCWorkflowBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean pswpdcworkflowidDirtyFlag = false;
    private boolean pswpdcworkflownameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfsnDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="pswpdcworkflowid")
    private String pswpdcworkflowid;
    @Column(name="pswpdcworkflowname")
    private String pswpdcworkflowname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfsn")
    private String wfsn;
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

    public void setPSWPDCWorkflowId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWorkflowId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcworkflowid = string;
        this.pswpdcworkflowidDirtyFlag = true;
    }

    public String getPSWPDCWorkflowId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWorkflowId();
        }
        return this.pswpdcworkflowid;
    }

    public boolean isPSWPDCWorkflowIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWorkflowIdDirty();
        }
        return this.pswpdcworkflowidDirtyFlag;
    }

    public void resetPSWPDCWorkflowId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWorkflowId();
            return;
        }
        this.pswpdcworkflowidDirtyFlag = false;
        this.pswpdcworkflowid = null;
    }

    public void setPSWPDCWorkflowName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWPDCWorkflowName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswpdcworkflowname = string;
        this.pswpdcworkflownameDirtyFlag = true;
    }

    public String getPSWPDCWorkflowName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWPDCWorkflowName();
        }
        return this.pswpdcworkflowname;
    }

    public boolean isPSWPDCWorkflowNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWPDCWorkflowNameDirty();
        }
        return this.pswpdcworkflownameDirtyFlag;
    }

    public void resetPSWPDCWorkflowName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWPDCWorkflowName();
            return;
        }
        this.pswpdcworkflownameDirtyFlag = false;
        this.pswpdcworkflowname = null;
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

    public void setWFSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.wfsn = string;
        this.wfsnDirtyFlag = true;
    }

    public String getWFSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFSN();
        }
        return this.wfsn;
    }

    public boolean isWFSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFSNDirty();
        }
        return this.wfsnDirtyFlag;
    }

    public void resetWFSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFSN();
            return;
        }
        this.wfsnDirtyFlag = false;
        this.wfsn = null;
    }

    protected void onReset() {
        PSWPDCWorkflowBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWPDCWorkflowBase pSWPDCWorkflowBase) {
        pSWPDCWorkflowBase.resetCreateDate();
        pSWPDCWorkflowBase.resetCreateMan();
        pSWPDCWorkflowBase.resetPSDevCenterId();
        pSWPDCWorkflowBase.resetPSDevCenterName();
        pSWPDCWorkflowBase.resetPSWPDCWorkflowId();
        pSWPDCWorkflowBase.resetPSWPDCWorkflowName();
        pSWPDCWorkflowBase.resetUpdateDate();
        pSWPDCWorkflowBase.resetUpdateMan();
        pSWPDCWorkflowBase.resetWFSN();
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
        if (!bl || this.isPSWPDCWorkflowIdDirty()) {
            hashMap.put(FIELD_PSWPDCWORKFLOWID, this.getPSWPDCWorkflowId());
        }
        if (!bl || this.isPSWPDCWorkflowNameDirty()) {
            hashMap.put(FIELD_PSWPDCWORKFLOWNAME, this.getPSWPDCWorkflowName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isWFSNDirty()) {
            hashMap.put(FIELD_WFSN, this.getWFSN());
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
        return PSWPDCWorkflowBase.get(this, n);
    }

    private static Object get(PSWPDCWorkflowBase pSWPDCWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWorkflowBase.getCreateDate();
            }
            case 1: {
                return pSWPDCWorkflowBase.getCreateMan();
            }
            case 2: {
                return pSWPDCWorkflowBase.getPSDevCenterId();
            }
            case 3: {
                return pSWPDCWorkflowBase.getPSDevCenterName();
            }
            case 4: {
                return pSWPDCWorkflowBase.getPSWPDCWorkflowId();
            }
            case 5: {
                return pSWPDCWorkflowBase.getPSWPDCWorkflowName();
            }
            case 6: {
                return pSWPDCWorkflowBase.getUpdateDate();
            }
            case 7: {
                return pSWPDCWorkflowBase.getUpdateMan();
            }
            case 8: {
                return pSWPDCWorkflowBase.getWFSN();
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
        PSWPDCWorkflowBase.set(this, n, object);
    }

    private static void set(PSWPDCWorkflowBase pSWPDCWorkflowBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWorkflowBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSWPDCWorkflowBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSWPDCWorkflowBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWPDCWorkflowBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWPDCWorkflowBase.setPSWPDCWorkflowId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWPDCWorkflowBase.setPSWPDCWorkflowName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWPDCWorkflowBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSWPDCWorkflowBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSWPDCWorkflowBase.setWFSN(DataObject.getStringValue((Object)object));
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
        return PSWPDCWorkflowBase.isNull(this, n);
    }

    private static boolean isNull(PSWPDCWorkflowBase pSWPDCWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWorkflowBase.getCreateDate() == null;
            }
            case 1: {
                return pSWPDCWorkflowBase.getCreateMan() == null;
            }
            case 2: {
                return pSWPDCWorkflowBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSWPDCWorkflowBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSWPDCWorkflowBase.getPSWPDCWorkflowId() == null;
            }
            case 5: {
                return pSWPDCWorkflowBase.getPSWPDCWorkflowName() == null;
            }
            case 6: {
                return pSWPDCWorkflowBase.getUpdateDate() == null;
            }
            case 7: {
                return pSWPDCWorkflowBase.getUpdateMan() == null;
            }
            case 8: {
                return pSWPDCWorkflowBase.getWFSN() == null;
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
        return PSWPDCWorkflowBase.contains(this, n);
    }

    private static boolean contains(PSWPDCWorkflowBase pSWPDCWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWPDCWorkflowBase.isCreateDateDirty();
            }
            case 1: {
                return pSWPDCWorkflowBase.isCreateManDirty();
            }
            case 2: {
                return pSWPDCWorkflowBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSWPDCWorkflowBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSWPDCWorkflowBase.isPSWPDCWorkflowIdDirty();
            }
            case 5: {
                return pSWPDCWorkflowBase.isPSWPDCWorkflowNameDirty();
            }
            case 6: {
                return pSWPDCWorkflowBase.isUpdateDateDirty();
            }
            case 7: {
                return pSWPDCWorkflowBase.isUpdateManDirty();
            }
            case 8: {
                return pSWPDCWorkflowBase.isWFSNDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWPDCWorkflowBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWPDCWorkflowBase pSWPDCWorkflowBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWPDCWorkflowBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcworkflowid", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getPSWPDCWorkflowId()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswpdcworkflowname", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getPSWPDCWorkflowName()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSWPDCWorkflowBase.getWFSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"wfsn", (Object)PSWPDCWorkflowBase.getJSONValue((Object)pSWPDCWorkflowBase.getWFSN()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWPDCWorkflowBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWPDCWorkflowBase pSWPDCWorkflowBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWPDCWorkflowBase.getCreateDate() != null) {
            object = pSWPDCWorkflowBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWorkflowBase.getCreateMan() != null) {
            object = pSWPDCWorkflowBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getPSDevCenterId() != null) {
            object = pSWPDCWorkflowBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getPSDevCenterName() != null) {
            object = pSWPDCWorkflowBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowId() != null) {
            object = pSWPDCWorkflowBase.getPSWPDCWorkflowId();
            xmlNode.setAttribute(FIELD_PSWPDCWORKFLOWID, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowName() != null) {
            object = pSWPDCWorkflowBase.getPSWPDCWorkflowName();
            xmlNode.setAttribute(FIELD_PSWPDCWORKFLOWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getUpdateDate() != null) {
            object = pSWPDCWorkflowBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWPDCWorkflowBase.getUpdateMan() != null) {
            object = pSWPDCWorkflowBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWPDCWorkflowBase.getWFSN() != null) {
            object = pSWPDCWorkflowBase.getWFSN();
            xmlNode.setAttribute(FIELD_WFSN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWPDCWorkflowBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWPDCWorkflowBase pSWPDCWorkflowBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWPDCWorkflowBase.isCreateDateDirty() && (bl || pSWPDCWorkflowBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWPDCWorkflowBase.getCreateDate());
        }
        if (pSWPDCWorkflowBase.isCreateManDirty() && (bl || pSWPDCWorkflowBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWPDCWorkflowBase.getCreateMan());
        }
        if (pSWPDCWorkflowBase.isPSDevCenterIdDirty() && (bl || pSWPDCWorkflowBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSWPDCWorkflowBase.getPSDevCenterId());
        }
        if (pSWPDCWorkflowBase.isPSDevCenterNameDirty() && (bl || pSWPDCWorkflowBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSWPDCWorkflowBase.getPSDevCenterName());
        }
        if (pSWPDCWorkflowBase.isPSWPDCWorkflowIdDirty() && (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowId() != null)) {
            iDataObject.set(FIELD_PSWPDCWORKFLOWID, (Object)pSWPDCWorkflowBase.getPSWPDCWorkflowId());
        }
        if (pSWPDCWorkflowBase.isPSWPDCWorkflowNameDirty() && (bl || pSWPDCWorkflowBase.getPSWPDCWorkflowName() != null)) {
            iDataObject.set(FIELD_PSWPDCWORKFLOWNAME, (Object)pSWPDCWorkflowBase.getPSWPDCWorkflowName());
        }
        if (pSWPDCWorkflowBase.isUpdateDateDirty() && (bl || pSWPDCWorkflowBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWPDCWorkflowBase.getUpdateDate());
        }
        if (pSWPDCWorkflowBase.isUpdateManDirty() && (bl || pSWPDCWorkflowBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWPDCWorkflowBase.getUpdateMan());
        }
        if (pSWPDCWorkflowBase.isWFSNDirty() && (bl || pSWPDCWorkflowBase.getWFSN() != null)) {
            iDataObject.set(FIELD_WFSN, (Object)pSWPDCWorkflowBase.getWFSN());
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
        return PSWPDCWorkflowBase.remove(this, n);
    }

    private static boolean remove(PSWPDCWorkflowBase pSWPDCWorkflowBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWPDCWorkflowBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSWPDCWorkflowBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSWPDCWorkflowBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSWPDCWorkflowBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSWPDCWorkflowBase.resetPSWPDCWorkflowId();
                return true;
            }
            case 5: {
                pSWPDCWorkflowBase.resetPSWPDCWorkflowName();
                return true;
            }
            case 6: {
                pSWPDCWorkflowBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSWPDCWorkflowBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSWPDCWorkflowBase.resetWFSN();
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

    private PSWPDCWorkflowBase getProxyEntity() {
        return this.proxyPSWPDCWorkflowBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWPDCWorkflowBase = null;
        if (iDataObject != null && iDataObject instanceof PSWPDCWorkflowBase) {
            this.proxyPSWPDCWorkflowBase = (PSWPDCWorkflowBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfplatform.service.PSWPDCWorkflowService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSWPDCWORKFLOWID, 4);
        fieldIndexMap.put(FIELD_PSWPDCWORKFLOWNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_WFSN, 8);
    }
}

