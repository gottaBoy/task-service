/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDepSlnTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSlnTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPSLNOBJ = "DEPSLNOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSLNTYPEID = "PSDEPSLNTYPEID";
    public static final String FIELD_PSDEPSLNTYPENAME = "PSDEPSLNTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEPSLNOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEPSLNTYPEID = 4;
    private static final int INDEX_PSDEPSLNTYPENAME = 5;
    private static final int INDEX_TYPEOBJ = 6;
    private static final int INDEX_TYPEPARAMS = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSlnTypeBase proxyPSDepSlnTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean depslnobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepslntypeidDirtyFlag = false;
    private boolean psdepslntypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="depslnobj")
    private String depslnobj;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepslntypeid")
    private String psdepslntypeid;
    @Column(name="psdepslntypename")
    private String psdepslntypename;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setDepSlnObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepSlnObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depslnobj = string;
        this.depslnobjDirtyFlag = true;
    }

    public String getDepSlnObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepSlnObj();
        }
        return this.depslnobj;
    }

    public boolean isDepSlnObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepSlnObjDirty();
        }
        return this.depslnobjDirtyFlag;
    }

    public void resetDepSlnObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepSlnObj();
            return;
        }
        this.depslnobjDirtyFlag = false;
        this.depslnobj = null;
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

    public void setPSDepSlnTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslntypeid = string;
        this.psdepslntypeidDirtyFlag = true;
    }

    public String getPSDepSlnTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnTypeId();
        }
        return this.psdepslntypeid;
    }

    public boolean isPSDepSlnTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnTypeIdDirty();
        }
        return this.psdepslntypeidDirtyFlag;
    }

    public void resetPSDepSlnTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnTypeId();
            return;
        }
        this.psdepslntypeidDirtyFlag = false;
        this.psdepslntypeid = null;
    }

    public void setPSDepSlnTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSlnTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepslntypename = string;
        this.psdepslntypenameDirtyFlag = true;
    }

    public String getPSDepSlnTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSlnTypeName();
        }
        return this.psdepslntypename;
    }

    public boolean isPSDepSlnTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSlnTypeNameDirty();
        }
        return this.psdepslntypenameDirtyFlag;
    }

    public void resetPSDepSlnTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSlnTypeName();
            return;
        }
        this.psdepslntypenameDirtyFlag = false;
        this.psdepslntypename = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
    }

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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
        PSDepSlnTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSlnTypeBase pSDepSlnTypeBase) {
        pSDepSlnTypeBase.resetCreateDate();
        pSDepSlnTypeBase.resetCreateMan();
        pSDepSlnTypeBase.resetDepSlnObj();
        pSDepSlnTypeBase.resetMemo();
        pSDepSlnTypeBase.resetPSDepSlnTypeId();
        pSDepSlnTypeBase.resetPSDepSlnTypeName();
        pSDepSlnTypeBase.resetTypeObj();
        pSDepSlnTypeBase.resetTypeParams();
        pSDepSlnTypeBase.resetUpdateDate();
        pSDepSlnTypeBase.resetUpdateMan();
        pSDepSlnTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDepSlnObjDirty()) {
            hashMap.put(FIELD_DEPSLNOBJ, this.getDepSlnObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDepSlnTypeIdDirty()) {
            hashMap.put(FIELD_PSDEPSLNTYPEID, this.getPSDepSlnTypeId());
        }
        if (!bl || this.isPSDepSlnTypeNameDirty()) {
            hashMap.put(FIELD_PSDEPSLNTYPENAME, this.getPSDepSlnTypeName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
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
        return PSDepSlnTypeBase.get(this, n);
    }

    private static Object get(PSDepSlnTypeBase pSDepSlnTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnTypeBase.getCreateDate();
            }
            case 1: {
                return pSDepSlnTypeBase.getCreateMan();
            }
            case 2: {
                return pSDepSlnTypeBase.getDepSlnObj();
            }
            case 3: {
                return pSDepSlnTypeBase.getMemo();
            }
            case 4: {
                return pSDepSlnTypeBase.getPSDepSlnTypeId();
            }
            case 5: {
                return pSDepSlnTypeBase.getPSDepSlnTypeName();
            }
            case 6: {
                return pSDepSlnTypeBase.getTypeObj();
            }
            case 7: {
                return pSDepSlnTypeBase.getTypeParams();
            }
            case 8: {
                return pSDepSlnTypeBase.getUpdateDate();
            }
            case 9: {
                return pSDepSlnTypeBase.getUpdateMan();
            }
            case 10: {
                return pSDepSlnTypeBase.getValidFlag();
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
        PSDepSlnTypeBase.set(this, n, object);
    }

    private static void set(PSDepSlnTypeBase pSDepSlnTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSlnTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSlnTypeBase.setDepSlnObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSlnTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSlnTypeBase.setPSDepSlnTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSlnTypeBase.setPSDepSlnTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSlnTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSlnTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSlnTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDepSlnTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDepSlnTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSlnTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSlnTypeBase pSDepSlnTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSlnTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSlnTypeBase.getDepSlnObj() == null;
            }
            case 3: {
                return pSDepSlnTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDepSlnTypeBase.getPSDepSlnTypeId() == null;
            }
            case 5: {
                return pSDepSlnTypeBase.getPSDepSlnTypeName() == null;
            }
            case 6: {
                return pSDepSlnTypeBase.getTypeObj() == null;
            }
            case 7: {
                return pSDepSlnTypeBase.getTypeParams() == null;
            }
            case 8: {
                return pSDepSlnTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDepSlnTypeBase.getUpdateMan() == null;
            }
            case 10: {
                return pSDepSlnTypeBase.getValidFlag() == null;
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
        return PSDepSlnTypeBase.contains(this, n);
    }

    private static boolean contains(PSDepSlnTypeBase pSDepSlnTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSlnTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSlnTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSlnTypeBase.isDepSlnObjDirty();
            }
            case 3: {
                return pSDepSlnTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDepSlnTypeBase.isPSDepSlnTypeIdDirty();
            }
            case 5: {
                return pSDepSlnTypeBase.isPSDepSlnTypeNameDirty();
            }
            case 6: {
                return pSDepSlnTypeBase.isTypeObjDirty();
            }
            case 7: {
                return pSDepSlnTypeBase.isTypeParamsDirty();
            }
            case 8: {
                return pSDepSlnTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDepSlnTypeBase.isUpdateManDirty();
            }
            case 10: {
                return pSDepSlnTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSlnTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSlnTypeBase pSDepSlnTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSlnTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getDepSlnObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depslnobj", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getDepSlnObj()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getPSDepSlnTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslntypeid", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getPSDepSlnTypeId()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getPSDepSlnTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepslntypename", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getPSDepSlnTypeName()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSlnTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSlnTypeBase.getJSONValue((Object)pSDepSlnTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSlnTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSlnTypeBase pSDepSlnTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSlnTypeBase.getCreateDate() != null) {
            object = pSDepSlnTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnTypeBase.getCreateMan() != null) {
            object = pSDepSlnTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getDepSlnObj() != null) {
            object = pSDepSlnTypeBase.getDepSlnObj();
            xmlNode.setAttribute(FIELD_DEPSLNOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getMemo() != null) {
            object = pSDepSlnTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getPSDepSlnTypeId() != null) {
            object = pSDepSlnTypeBase.getPSDepSlnTypeId();
            xmlNode.setAttribute(FIELD_PSDEPSLNTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getPSDepSlnTypeName() != null) {
            object = pSDepSlnTypeBase.getPSDepSlnTypeName();
            xmlNode.setAttribute(FIELD_PSDEPSLNTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getTypeObj() != null) {
            object = pSDepSlnTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getTypeParams() != null) {
            object = pSDepSlnTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getUpdateDate() != null) {
            object = pSDepSlnTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSlnTypeBase.getUpdateMan() != null) {
            object = pSDepSlnTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSlnTypeBase.getValidFlag() != null) {
            object = pSDepSlnTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSlnTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSlnTypeBase pSDepSlnTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSlnTypeBase.isCreateDateDirty() && (bl || pSDepSlnTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSlnTypeBase.getCreateDate());
        }
        if (pSDepSlnTypeBase.isCreateManDirty() && (bl || pSDepSlnTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSlnTypeBase.getCreateMan());
        }
        if (pSDepSlnTypeBase.isDepSlnObjDirty() && (bl || pSDepSlnTypeBase.getDepSlnObj() != null)) {
            iDataObject.set(FIELD_DEPSLNOBJ, (Object)pSDepSlnTypeBase.getDepSlnObj());
        }
        if (pSDepSlnTypeBase.isMemoDirty() && (bl || pSDepSlnTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSlnTypeBase.getMemo());
        }
        if (pSDepSlnTypeBase.isPSDepSlnTypeIdDirty() && (bl || pSDepSlnTypeBase.getPSDepSlnTypeId() != null)) {
            iDataObject.set(FIELD_PSDEPSLNTYPEID, (Object)pSDepSlnTypeBase.getPSDepSlnTypeId());
        }
        if (pSDepSlnTypeBase.isPSDepSlnTypeNameDirty() && (bl || pSDepSlnTypeBase.getPSDepSlnTypeName() != null)) {
            iDataObject.set(FIELD_PSDEPSLNTYPENAME, (Object)pSDepSlnTypeBase.getPSDepSlnTypeName());
        }
        if (pSDepSlnTypeBase.isTypeObjDirty() && (bl || pSDepSlnTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSDepSlnTypeBase.getTypeObj());
        }
        if (pSDepSlnTypeBase.isTypeParamsDirty() && (bl || pSDepSlnTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSDepSlnTypeBase.getTypeParams());
        }
        if (pSDepSlnTypeBase.isUpdateDateDirty() && (bl || pSDepSlnTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSlnTypeBase.getUpdateDate());
        }
        if (pSDepSlnTypeBase.isUpdateManDirty() && (bl || pSDepSlnTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSlnTypeBase.getUpdateMan());
        }
        if (pSDepSlnTypeBase.isValidFlagDirty() && (bl || pSDepSlnTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSlnTypeBase.getValidFlag());
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
        return PSDepSlnTypeBase.remove(this, n);
    }

    private static boolean remove(PSDepSlnTypeBase pSDepSlnTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSlnTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSlnTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSlnTypeBase.resetDepSlnObj();
                return true;
            }
            case 3: {
                pSDepSlnTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepSlnTypeBase.resetPSDepSlnTypeId();
                return true;
            }
            case 5: {
                pSDepSlnTypeBase.resetPSDepSlnTypeName();
                return true;
            }
            case 6: {
                pSDepSlnTypeBase.resetTypeObj();
                return true;
            }
            case 7: {
                pSDepSlnTypeBase.resetTypeParams();
                return true;
            }
            case 8: {
                pSDepSlnTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDepSlnTypeBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSDepSlnTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDepSlnTypeBase getProxyEntity() {
        return this.proxyPSDepSlnTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSlnTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSlnTypeBase) {
            this.proxyPSDepSlnTypeBase = (PSDepSlnTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDepSlnTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEPSLNOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEPSLNTYPEID, 4);
        fieldIndexMap.put(FIELD_PSDEPSLNTYPENAME, 5);
        fieldIndexMap.put(FIELD_TYPEOBJ, 6);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

