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
package net.ibizsys.pscore.srv.sysdeploy.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSys;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSaaSSysBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSaaSSysBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FROMDCID = "FROMDCID";
    public static final String FIELD_FROMDCNAME = "FROMDCNAME";
    public static final String FIELD_PSDEPSAASSYSID = "PSDEPSAASSYSID";
    public static final String FIELD_PSDEPSAASSYSNAME = "PSDEPSAASSYSNAME";
    public static final String FIELD_PSSAASSYSID = "PSSAASSYSID";
    public static final String FIELD_PSSAASSYSNAME = "PSSAASSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FROMDCID = 2;
    private static final int INDEX_FROMDCNAME = 3;
    private static final int INDEX_PSDEPSAASSYSID = 4;
    private static final int INDEX_PSDEPSAASSYSNAME = 5;
    private static final int INDEX_PSSAASSYSID = 6;
    private static final int INDEX_PSSAASSYSNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSaaSSysBase proxyPSDepSaaSSysBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean fromdcidDirtyFlag = false;
    private boolean fromdcnameDirtyFlag = false;
    private boolean psdepsaassysidDirtyFlag = false;
    private boolean psdepsaassysnameDirtyFlag = false;
    private boolean pssaassysidDirtyFlag = false;
    private boolean pssaassysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="fromdcid")
    private String fromdcid;
    @Column(name="fromdcname")
    private String fromdcname;
    @Column(name="psdepsaassysid")
    private String psdepsaassysid;
    @Column(name="psdepsaassysname")
    private String psdepsaassysname;
    @Column(name="pssaassysid")
    private String pssaassysid;
    @Column(name="pssaassysname")
    private String pssaassysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objFromDCLock = new Integer(1);
    private PSDevCenter fromdc = null;
    private Integer objPSSaaSSysLock = new Integer(1);
    private PSSaaSSys pssaassys = null;

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

    public void setFromDCId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromDCId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromdcid = string;
        this.fromdcidDirtyFlag = true;
    }

    public String getFromDCId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromDCId();
        }
        return this.fromdcid;
    }

    public boolean isFromDCIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromDCIdDirty();
        }
        return this.fromdcidDirtyFlag;
    }

    public void resetFromDCId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromDCId();
            return;
        }
        this.fromdcidDirtyFlag = false;
        this.fromdcid = null;
    }

    public void setFromDCName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFromDCName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fromdcname = string;
        this.fromdcnameDirtyFlag = true;
    }

    public String getFromDCName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromDCName();
        }
        return this.fromdcname;
    }

    public boolean isFromDCNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFromDCNameDirty();
        }
        return this.fromdcnameDirtyFlag;
    }

    public void resetFromDCName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFromDCName();
            return;
        }
        this.fromdcnameDirtyFlag = false;
        this.fromdcname = null;
    }

    public void setPSDepSaaSSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysid = string;
        this.psdepsaassysidDirtyFlag = true;
    }

    public String getPSDepSaaSSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysId();
        }
        return this.psdepsaassysid;
    }

    public boolean isPSDepSaaSSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysIdDirty();
        }
        return this.psdepsaassysidDirtyFlag;
    }

    public void resetPSDepSaaSSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysId();
            return;
        }
        this.psdepsaassysidDirtyFlag = false;
        this.psdepsaassysid = null;
    }

    public void setPSDepSaaSSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSaaSSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsaassysname = string;
        this.psdepsaassysnameDirtyFlag = true;
    }

    public String getPSDepSaaSSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSaaSSysName();
        }
        return this.psdepsaassysname;
    }

    public boolean isPSDepSaaSSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSaaSSysNameDirty();
        }
        return this.psdepsaassysnameDirtyFlag;
    }

    public void resetPSDepSaaSSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSaaSSysName();
            return;
        }
        this.psdepsaassysnameDirtyFlag = false;
        this.psdepsaassysname = null;
    }

    public void setPSSaaSSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysid = string;
        this.pssaassysidDirtyFlag = true;
    }

    public String getPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysId();
        }
        return this.pssaassysid;
    }

    public boolean isPSSaaSSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysIdDirty();
        }
        return this.pssaassysidDirtyFlag;
    }

    public void resetPSSaaSSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysId();
            return;
        }
        this.pssaassysidDirtyFlag = false;
        this.pssaassysid = null;
    }

    public void setPSSaaSSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysname = string;
        this.pssaassysnameDirtyFlag = true;
    }

    public String getPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysName();
        }
        return this.pssaassysname;
    }

    public boolean isPSSaaSSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysNameDirty();
        }
        return this.pssaassysnameDirtyFlag;
    }

    public void resetPSSaaSSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysName();
            return;
        }
        this.pssaassysnameDirtyFlag = false;
        this.pssaassysname = null;
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
        PSDepSaaSSysBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSaaSSysBase pSDepSaaSSysBase) {
        pSDepSaaSSysBase.resetCreateDate();
        pSDepSaaSSysBase.resetCreateMan();
        pSDepSaaSSysBase.resetFromDCId();
        pSDepSaaSSysBase.resetFromDCName();
        pSDepSaaSSysBase.resetPSDepSaaSSysId();
        pSDepSaaSSysBase.resetPSDepSaaSSysName();
        pSDepSaaSSysBase.resetPSSaaSSysId();
        pSDepSaaSSysBase.resetPSSaaSSysName();
        pSDepSaaSSysBase.resetUpdateDate();
        pSDepSaaSSysBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFromDCIdDirty()) {
            hashMap.put(FIELD_FROMDCID, this.getFromDCId());
        }
        if (!bl || this.isFromDCNameDirty()) {
            hashMap.put(FIELD_FROMDCNAME, this.getFromDCName());
        }
        if (!bl || this.isPSDepSaaSSysIdDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSID, this.getPSDepSaaSSysId());
        }
        if (!bl || this.isPSDepSaaSSysNameDirty()) {
            hashMap.put(FIELD_PSDEPSAASSYSNAME, this.getPSDepSaaSSysName());
        }
        if (!bl || this.isPSSaaSSysIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSID, this.getPSSaaSSysId());
        }
        if (!bl || this.isPSSaaSSysNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSNAME, this.getPSSaaSSysName());
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
        return PSDepSaaSSysBase.get(this, n);
    }

    private static Object get(PSDepSaaSSysBase pSDepSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysBase.getCreateDate();
            }
            case 1: {
                return pSDepSaaSSysBase.getCreateMan();
            }
            case 2: {
                return pSDepSaaSSysBase.getFromDCId();
            }
            case 3: {
                return pSDepSaaSSysBase.getFromDCName();
            }
            case 4: {
                return pSDepSaaSSysBase.getPSDepSaaSSysId();
            }
            case 5: {
                return pSDepSaaSSysBase.getPSDepSaaSSysName();
            }
            case 6: {
                return pSDepSaaSSysBase.getPSSaaSSysId();
            }
            case 7: {
                return pSDepSaaSSysBase.getPSSaaSSysName();
            }
            case 8: {
                return pSDepSaaSSysBase.getUpdateDate();
            }
            case 9: {
                return pSDepSaaSSysBase.getUpdateMan();
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
        PSDepSaaSSysBase.set(this, n, object);
    }

    private static void set(PSDepSaaSSysBase pSDepSaaSSysBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSaaSSysBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSaaSSysBase.setFromDCId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSaaSSysBase.setFromDCName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSaaSSysBase.setPSDepSaaSSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSaaSSysBase.setPSDepSaaSSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSaaSSysBase.setPSSaaSSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSaaSSysBase.setPSSaaSSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSaaSSysBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDepSaaSSysBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDepSaaSSysBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSaaSSysBase pSDepSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSaaSSysBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSaaSSysBase.getFromDCId() == null;
            }
            case 3: {
                return pSDepSaaSSysBase.getFromDCName() == null;
            }
            case 4: {
                return pSDepSaaSSysBase.getPSDepSaaSSysId() == null;
            }
            case 5: {
                return pSDepSaaSSysBase.getPSDepSaaSSysName() == null;
            }
            case 6: {
                return pSDepSaaSSysBase.getPSSaaSSysId() == null;
            }
            case 7: {
                return pSDepSaaSSysBase.getPSSaaSSysName() == null;
            }
            case 8: {
                return pSDepSaaSSysBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDepSaaSSysBase.getUpdateMan() == null;
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
        return PSDepSaaSSysBase.contains(this, n);
    }

    private static boolean contains(PSDepSaaSSysBase pSDepSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSaaSSysBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSaaSSysBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSaaSSysBase.isFromDCIdDirty();
            }
            case 3: {
                return pSDepSaaSSysBase.isFromDCNameDirty();
            }
            case 4: {
                return pSDepSaaSSysBase.isPSDepSaaSSysIdDirty();
            }
            case 5: {
                return pSDepSaaSSysBase.isPSDepSaaSSysNameDirty();
            }
            case 6: {
                return pSDepSaaSSysBase.isPSSaaSSysIdDirty();
            }
            case 7: {
                return pSDepSaaSSysBase.isPSSaaSSysNameDirty();
            }
            case 8: {
                return pSDepSaaSSysBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDepSaaSSysBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSaaSSysBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSaaSSysBase pSDepSaaSSysBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSaaSSysBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getFromDCId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromdcid", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getFromDCId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getFromDCName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fromdcname", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getFromDCName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getPSDepSaaSSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysid", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getPSDepSaaSSysId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getPSDepSaaSSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsaassysname", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getPSDepSaaSSysName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getPSSaaSSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysid", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getPSSaaSSysId()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getPSSaaSSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysname", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getPSSaaSSysName()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSaaSSysBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSaaSSysBase.getJSONValue((Object)pSDepSaaSSysBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSaaSSysBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSaaSSysBase pSDepSaaSSysBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSaaSSysBase.getCreateDate() != null) {
            object = pSDepSaaSSysBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysBase.getCreateMan() != null) {
            object = pSDepSaaSSysBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getFromDCId() != null) {
            object = pSDepSaaSSysBase.getFromDCId();
            xmlNode.setAttribute(FIELD_FROMDCID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getFromDCName() != null) {
            object = pSDepSaaSSysBase.getFromDCName();
            xmlNode.setAttribute(FIELD_FROMDCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getPSDepSaaSSysId() != null) {
            object = pSDepSaaSSysBase.getPSDepSaaSSysId();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getPSDepSaaSSysName() != null) {
            object = pSDepSaaSSysBase.getPSDepSaaSSysName();
            xmlNode.setAttribute(FIELD_PSDEPSAASSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getPSSaaSSysId() != null) {
            object = pSDepSaaSSysBase.getPSSaaSSysId();
            xmlNode.setAttribute(FIELD_PSSAASSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getPSSaaSSysName() != null) {
            object = pSDepSaaSSysBase.getPSSaaSSysName();
            xmlNode.setAttribute(FIELD_PSSAASSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSaaSSysBase.getUpdateDate() != null) {
            object = pSDepSaaSSysBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSaaSSysBase.getUpdateMan() != null) {
            object = pSDepSaaSSysBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSaaSSysBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSaaSSysBase pSDepSaaSSysBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSaaSSysBase.isCreateDateDirty() && (bl || pSDepSaaSSysBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSaaSSysBase.getCreateDate());
        }
        if (pSDepSaaSSysBase.isCreateManDirty() && (bl || pSDepSaaSSysBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSaaSSysBase.getCreateMan());
        }
        if (pSDepSaaSSysBase.isFromDCIdDirty() && (bl || pSDepSaaSSysBase.getFromDCId() != null)) {
            iDataObject.set(FIELD_FROMDCID, (Object)pSDepSaaSSysBase.getFromDCId());
        }
        if (pSDepSaaSSysBase.isFromDCNameDirty() && (bl || pSDepSaaSSysBase.getFromDCName() != null)) {
            iDataObject.set(FIELD_FROMDCNAME, (Object)pSDepSaaSSysBase.getFromDCName());
        }
        if (pSDepSaaSSysBase.isPSDepSaaSSysIdDirty() && (bl || pSDepSaaSSysBase.getPSDepSaaSSysId() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSID, (Object)pSDepSaaSSysBase.getPSDepSaaSSysId());
        }
        if (pSDepSaaSSysBase.isPSDepSaaSSysNameDirty() && (bl || pSDepSaaSSysBase.getPSDepSaaSSysName() != null)) {
            iDataObject.set(FIELD_PSDEPSAASSYSNAME, (Object)pSDepSaaSSysBase.getPSDepSaaSSysName());
        }
        if (pSDepSaaSSysBase.isPSSaaSSysIdDirty() && (bl || pSDepSaaSSysBase.getPSSaaSSysId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSID, (Object)pSDepSaaSSysBase.getPSSaaSSysId());
        }
        if (pSDepSaaSSysBase.isPSSaaSSysNameDirty() && (bl || pSDepSaaSSysBase.getPSSaaSSysName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSNAME, (Object)pSDepSaaSSysBase.getPSSaaSSysName());
        }
        if (pSDepSaaSSysBase.isUpdateDateDirty() && (bl || pSDepSaaSSysBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSaaSSysBase.getUpdateDate());
        }
        if (pSDepSaaSSysBase.isUpdateManDirty() && (bl || pSDepSaaSSysBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSaaSSysBase.getUpdateMan());
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
        return PSDepSaaSSysBase.remove(this, n);
    }

    private static boolean remove(PSDepSaaSSysBase pSDepSaaSSysBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSaaSSysBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSaaSSysBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSaaSSysBase.resetFromDCId();
                return true;
            }
            case 3: {
                pSDepSaaSSysBase.resetFromDCName();
                return true;
            }
            case 4: {
                pSDepSaaSSysBase.resetPSDepSaaSSysId();
                return true;
            }
            case 5: {
                pSDepSaaSSysBase.resetPSDepSaaSSysName();
                return true;
            }
            case 6: {
                pSDepSaaSSysBase.resetPSSaaSSysId();
                return true;
            }
            case 7: {
                pSDepSaaSSysBase.resetPSSaaSSysName();
                return true;
            }
            case 8: {
                pSDepSaaSSysBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDepSaaSSysBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getFromDC() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFromDC();
        }
        if (this.getFromDCId() == null) {
            return null;
        }
        Integer n = this.objFromDCLock;
        synchronized (n) {
            if (this.fromdc != null && DataTypeHelper.compare((int)25, (Object)this.getFromDCId(), (Object)this.fromdc.getPSDevCenterId()) != 0L) {
                this.fromdc = null;
            }
            if (this.fromdc == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getFromDCId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.fromdc = pSDevCenter;
            }
            return this.fromdc;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSys getPSSaaSSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSys();
        }
        if (this.getPSSaaSSysId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysLock;
        synchronized (n) {
            if (this.pssaassys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysId(), (Object)this.pssaassys.getPSSaaSSysId()) != 0L) {
                this.pssaassys = null;
            }
            if (this.pssaassys == null) {
                PSSaaSSys pSSaaSSys = new PSSaaSSys();
                pSSaaSSys.setPSSaaSSysId(this.getPSSaaSSysId());
                PSSaaSSysService pSSaaSSysService = (PSSaaSSysService)ServiceGlobal.getService(PSSaaSSysService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysService.autoGet(pSSaaSSys);
                this.pssaassys = pSSaaSSys;
            }
            return this.pssaassys;
        }
    }

    private PSDepSaaSSysBase getProxyEntity() {
        return this.proxyPSDepSaaSSysBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSaaSSysBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSaaSSysBase) {
            this.proxyPSDepSaaSSysBase = (PSDepSaaSSysBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdeploy.service.PSDepSaaSSysService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FROMDCID, 2);
        fieldIndexMap.put(FIELD_FROMDCNAME, 3);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSID, 4);
        fieldIndexMap.put(FIELD_PSDEPSAASSYSNAME, 5);
        fieldIndexMap.put(FIELD_PSSAASSYSID, 6);
        fieldIndexMap.put(FIELD_PSSAASSYSNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

