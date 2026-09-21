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
package net.ibizsys.pscore.srv.def.entity;

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

public abstract class PSFormDetailTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSFormDetailTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILOBJ = "DETAILOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PFDTYPE = "PFDTYPE";
    public static final String FIELD_PSFORMDETAILTYPEID = "PSFORMDETAILTYPEID";
    public static final String FIELD_PSFORMDETAILTYPENAME = "PSFORMDETAILTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DETAILOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PFDTYPE = 4;
    private static final int INDEX_PSFORMDETAILTYPEID = 5;
    private static final int INDEX_PSFORMDETAILTYPENAME = 6;
    private static final int INDEX_TYPEOBJ = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSFormDetailTypeBase proxyPSFormDetailTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pfdtypeDirtyFlag = false;
    private boolean psformdetailtypeidDirtyFlag = false;
    private boolean psformdetailtypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailobj")
    private String detailobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pfdtype")
    private String pfdtype;
    @Column(name="psformdetailtypeid")
    private String psformdetailtypeid;
    @Column(name="psformdetailtypename")
    private String psformdetailtypename;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setDetailOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailobj = string;
        this.detailobjDirtyFlag = true;
    }

    public String getDetailOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailOBJ();
        }
        return this.detailobj;
    }

    public boolean isDetailOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailOBJDirty();
        }
        return this.detailobjDirtyFlag;
    }

    public void resetDetailOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailOBJ();
            return;
        }
        this.detailobjDirtyFlag = false;
        this.detailobj = null;
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

    public void setPFDType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPFDType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pfdtype = string;
        this.pfdtypeDirtyFlag = true;
    }

    public String getPFDType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPFDType();
        }
        return this.pfdtype;
    }

    public boolean isPFDTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPFDTypeDirty();
        }
        return this.pfdtypeDirtyFlag;
    }

    public void resetPFDType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPFDType();
            return;
        }
        this.pfdtypeDirtyFlag = false;
        this.pfdtype = null;
    }

    public void setPSFormDetailTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFormDetailTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psformdetailtypeid = string;
        this.psformdetailtypeidDirtyFlag = true;
    }

    public String getPSFormDetailTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFormDetailTypeId();
        }
        return this.psformdetailtypeid;
    }

    public boolean isPSFormDetailTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFormDetailTypeIdDirty();
        }
        return this.psformdetailtypeidDirtyFlag;
    }

    public void resetPSFormDetailTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFormDetailTypeId();
            return;
        }
        this.psformdetailtypeidDirtyFlag = false;
        this.psformdetailtypeid = null;
    }

    public void setPSFormDetailTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSFormDetailTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psformdetailtypename = string;
        this.psformdetailtypenameDirtyFlag = true;
    }

    public String getPSFormDetailTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSFormDetailTypeName();
        }
        return this.psformdetailtypename;
    }

    public boolean isPSFormDetailTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSFormDetailTypeNameDirty();
        }
        return this.psformdetailtypenameDirtyFlag;
    }

    public void resetPSFormDetailTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSFormDetailTypeName();
            return;
        }
        this.psformdetailtypenameDirtyFlag = false;
        this.psformdetailtypename = null;
    }

    public void setTypeOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeOBJ();
        }
        return this.typeobj;
    }

    public boolean isTypeOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeOBJDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeOBJ();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSFormDetailTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSFormDetailTypeBase pSFormDetailTypeBase) {
        pSFormDetailTypeBase.resetCreateDate();
        pSFormDetailTypeBase.resetCreateMan();
        pSFormDetailTypeBase.resetDetailOBJ();
        pSFormDetailTypeBase.resetMemo();
        pSFormDetailTypeBase.resetPFDType();
        pSFormDetailTypeBase.resetPSFormDetailTypeId();
        pSFormDetailTypeBase.resetPSFormDetailTypeName();
        pSFormDetailTypeBase.resetTypeOBJ();
        pSFormDetailTypeBase.resetUpdateDate();
        pSFormDetailTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDetailOBJDirty()) {
            hashMap.put(FIELD_DETAILOBJ, this.getDetailOBJ());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPFDTypeDirty()) {
            hashMap.put(FIELD_PFDTYPE, this.getPFDType());
        }
        if (!bl || this.isPSFormDetailTypeIdDirty()) {
            hashMap.put(FIELD_PSFORMDETAILTYPEID, this.getPSFormDetailTypeId());
        }
        if (!bl || this.isPSFormDetailTypeNameDirty()) {
            hashMap.put(FIELD_PSFORMDETAILTYPENAME, this.getPSFormDetailTypeName());
        }
        if (!bl || this.isTypeOBJDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeOBJ());
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
        return PSFormDetailTypeBase.get(this, n);
    }

    private static Object get(PSFormDetailTypeBase pSFormDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormDetailTypeBase.getCreateDate();
            }
            case 1: {
                return pSFormDetailTypeBase.getCreateMan();
            }
            case 2: {
                return pSFormDetailTypeBase.getDetailOBJ();
            }
            case 3: {
                return pSFormDetailTypeBase.getMemo();
            }
            case 4: {
                return pSFormDetailTypeBase.getPFDType();
            }
            case 5: {
                return pSFormDetailTypeBase.getPSFormDetailTypeId();
            }
            case 6: {
                return pSFormDetailTypeBase.getPSFormDetailTypeName();
            }
            case 7: {
                return pSFormDetailTypeBase.getTypeOBJ();
            }
            case 8: {
                return pSFormDetailTypeBase.getUpdateDate();
            }
            case 9: {
                return pSFormDetailTypeBase.getUpdateMan();
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
        PSFormDetailTypeBase.set(this, n, object);
    }

    private static void set(PSFormDetailTypeBase pSFormDetailTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSFormDetailTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSFormDetailTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSFormDetailTypeBase.setDetailOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSFormDetailTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSFormDetailTypeBase.setPFDType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSFormDetailTypeBase.setPSFormDetailTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSFormDetailTypeBase.setPSFormDetailTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSFormDetailTypeBase.setTypeOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSFormDetailTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSFormDetailTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSFormDetailTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSFormDetailTypeBase pSFormDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormDetailTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSFormDetailTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSFormDetailTypeBase.getDetailOBJ() == null;
            }
            case 3: {
                return pSFormDetailTypeBase.getMemo() == null;
            }
            case 4: {
                return pSFormDetailTypeBase.getPFDType() == null;
            }
            case 5: {
                return pSFormDetailTypeBase.getPSFormDetailTypeId() == null;
            }
            case 6: {
                return pSFormDetailTypeBase.getPSFormDetailTypeName() == null;
            }
            case 7: {
                return pSFormDetailTypeBase.getTypeOBJ() == null;
            }
            case 8: {
                return pSFormDetailTypeBase.getUpdateDate() == null;
            }
            case 9: {
                return pSFormDetailTypeBase.getUpdateMan() == null;
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
        return PSFormDetailTypeBase.contains(this, n);
    }

    private static boolean contains(PSFormDetailTypeBase pSFormDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSFormDetailTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSFormDetailTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSFormDetailTypeBase.isDetailOBJDirty();
            }
            case 3: {
                return pSFormDetailTypeBase.isMemoDirty();
            }
            case 4: {
                return pSFormDetailTypeBase.isPFDTypeDirty();
            }
            case 5: {
                return pSFormDetailTypeBase.isPSFormDetailTypeIdDirty();
            }
            case 6: {
                return pSFormDetailTypeBase.isPSFormDetailTypeNameDirty();
            }
            case 7: {
                return pSFormDetailTypeBase.isTypeOBJDirty();
            }
            case 8: {
                return pSFormDetailTypeBase.isUpdateDateDirty();
            }
            case 9: {
                return pSFormDetailTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSFormDetailTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSFormDetailTypeBase pSFormDetailTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSFormDetailTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getDetailOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailobj", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getDetailOBJ()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getPFDType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pfdtype", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getPFDType()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getPSFormDetailTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psformdetailtypeid", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getPSFormDetailTypeId()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getPSFormDetailTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psformdetailtypename", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getPSFormDetailTypeName()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getTypeOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getTypeOBJ()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSFormDetailTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSFormDetailTypeBase.getJSONValue((Object)pSFormDetailTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSFormDetailTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSFormDetailTypeBase pSFormDetailTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSFormDetailTypeBase.getCreateDate() != null) {
            object = pSFormDetailTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFormDetailTypeBase.getCreateMan() != null) {
            object = pSFormDetailTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getDetailOBJ() != null) {
            object = pSFormDetailTypeBase.getDetailOBJ();
            xmlNode.setAttribute(FIELD_DETAILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getMemo() != null) {
            object = pSFormDetailTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getPFDType() != null) {
            object = pSFormDetailTypeBase.getPFDType();
            xmlNode.setAttribute(FIELD_PFDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getPSFormDetailTypeId() != null) {
            object = pSFormDetailTypeBase.getPSFormDetailTypeId();
            xmlNode.setAttribute(FIELD_PSFORMDETAILTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getPSFormDetailTypeName() != null) {
            object = pSFormDetailTypeBase.getPSFormDetailTypeName();
            xmlNode.setAttribute(FIELD_PSFORMDETAILTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getTypeOBJ() != null) {
            object = pSFormDetailTypeBase.getTypeOBJ();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSFormDetailTypeBase.getUpdateDate() != null) {
            object = pSFormDetailTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSFormDetailTypeBase.getUpdateMan() != null) {
            object = pSFormDetailTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSFormDetailTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSFormDetailTypeBase pSFormDetailTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSFormDetailTypeBase.isCreateDateDirty() && (bl || pSFormDetailTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSFormDetailTypeBase.getCreateDate());
        }
        if (pSFormDetailTypeBase.isCreateManDirty() && (bl || pSFormDetailTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSFormDetailTypeBase.getCreateMan());
        }
        if (pSFormDetailTypeBase.isDetailOBJDirty() && (bl || pSFormDetailTypeBase.getDetailOBJ() != null)) {
            iDataObject.set(FIELD_DETAILOBJ, (Object)pSFormDetailTypeBase.getDetailOBJ());
        }
        if (pSFormDetailTypeBase.isMemoDirty() && (bl || pSFormDetailTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSFormDetailTypeBase.getMemo());
        }
        if (pSFormDetailTypeBase.isPFDTypeDirty() && (bl || pSFormDetailTypeBase.getPFDType() != null)) {
            iDataObject.set(FIELD_PFDTYPE, (Object)pSFormDetailTypeBase.getPFDType());
        }
        if (pSFormDetailTypeBase.isPSFormDetailTypeIdDirty() && (bl || pSFormDetailTypeBase.getPSFormDetailTypeId() != null)) {
            iDataObject.set(FIELD_PSFORMDETAILTYPEID, (Object)pSFormDetailTypeBase.getPSFormDetailTypeId());
        }
        if (pSFormDetailTypeBase.isPSFormDetailTypeNameDirty() && (bl || pSFormDetailTypeBase.getPSFormDetailTypeName() != null)) {
            iDataObject.set(FIELD_PSFORMDETAILTYPENAME, (Object)pSFormDetailTypeBase.getPSFormDetailTypeName());
        }
        if (pSFormDetailTypeBase.isTypeOBJDirty() && (bl || pSFormDetailTypeBase.getTypeOBJ() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSFormDetailTypeBase.getTypeOBJ());
        }
        if (pSFormDetailTypeBase.isUpdateDateDirty() && (bl || pSFormDetailTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSFormDetailTypeBase.getUpdateDate());
        }
        if (pSFormDetailTypeBase.isUpdateManDirty() && (bl || pSFormDetailTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSFormDetailTypeBase.getUpdateMan());
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
        return PSFormDetailTypeBase.remove(this, n);
    }

    private static boolean remove(PSFormDetailTypeBase pSFormDetailTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSFormDetailTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSFormDetailTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSFormDetailTypeBase.resetDetailOBJ();
                return true;
            }
            case 3: {
                pSFormDetailTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSFormDetailTypeBase.resetPFDType();
                return true;
            }
            case 5: {
                pSFormDetailTypeBase.resetPSFormDetailTypeId();
                return true;
            }
            case 6: {
                pSFormDetailTypeBase.resetPSFormDetailTypeName();
                return true;
            }
            case 7: {
                pSFormDetailTypeBase.resetTypeOBJ();
                return true;
            }
            case 8: {
                pSFormDetailTypeBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSFormDetailTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSFormDetailTypeBase getProxyEntity() {
        return this.proxyPSFormDetailTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSFormDetailTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSFormDetailTypeBase) {
            this.proxyPSFormDetailTypeBase = (PSFormDetailTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.def.service.PSFormDetailTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DETAILOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PFDTYPE, 4);
        fieldIndexMap.put(FIELD_PSFORMDETAILTYPEID, 5);
        fieldIndexMap.put(FIELD_PSFORMDETAILTYPENAME, 6);
        fieldIndexMap.put(FIELD_TYPEOBJ, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

