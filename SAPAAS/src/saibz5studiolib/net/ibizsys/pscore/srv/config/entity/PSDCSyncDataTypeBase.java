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

public abstract class PSDCSyncDataTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSyncDataTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYNCDATATYPEID = "PSDCSYNCDATATYPEID";
    public static final String FIELD_PSDCSYNCDATATYPENAME = "PSDCSYNCDATATYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCSYNCDATATYPEID = 3;
    private static final int INDEX_PSDCSYNCDATATYPENAME = 4;
    private static final int INDEX_TYPEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSyncDataTypeBase proxyPSDCSyncDataTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsyncdatatypeidDirtyFlag = false;
    private boolean psdcsyncdatatypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsyncdatatypeid")
    private String psdcsyncdatatypeid;
    @Column(name="psdcsyncdatatypename")
    private String psdcsyncdatatypename;
    @Column(name="typeobj")
    private String typeobj;
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

    public void setPSDCSyncDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdatatypeid = string;
        this.psdcsyncdatatypeidDirtyFlag = true;
    }

    public String getPSDCSyncDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncDataTypeId();
        }
        return this.psdcsyncdatatypeid;
    }

    public boolean isPSDCSyncDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncDataTypeIdDirty();
        }
        return this.psdcsyncdatatypeidDirtyFlag;
    }

    public void resetPSDCSyncDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncDataTypeId();
            return;
        }
        this.psdcsyncdatatypeidDirtyFlag = false;
        this.psdcsyncdatatypeid = null;
    }

    public void setPSDCSyncDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncdatatypename = string;
        this.psdcsyncdatatypenameDirtyFlag = true;
    }

    public String getPSDCSyncDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncDataTypeName();
        }
        return this.psdcsyncdatatypename;
    }

    public boolean isPSDCSyncDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncDataTypeNameDirty();
        }
        return this.psdcsyncdatatypenameDirtyFlag;
    }

    public void resetPSDCSyncDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncDataTypeName();
            return;
        }
        this.psdcsyncdatatypenameDirtyFlag = false;
        this.psdcsyncdatatypename = null;
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
        PSDCSyncDataTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSyncDataTypeBase pSDCSyncDataTypeBase) {
        pSDCSyncDataTypeBase.resetCreateDate();
        pSDCSyncDataTypeBase.resetCreateMan();
        pSDCSyncDataTypeBase.resetMemo();
        pSDCSyncDataTypeBase.resetPSDCSyncDataTypeId();
        pSDCSyncDataTypeBase.resetPSDCSyncDataTypeName();
        pSDCSyncDataTypeBase.resetTypeObj();
        pSDCSyncDataTypeBase.resetUpdateDate();
        pSDCSyncDataTypeBase.resetUpdateMan();
        pSDCSyncDataTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSyncDataTypeIdDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATATYPEID, this.getPSDCSyncDataTypeId());
        }
        if (!bl || this.isPSDCSyncDataTypeNameDirty()) {
            hashMap.put(FIELD_PSDCSYNCDATATYPENAME, this.getPSDCSyncDataTypeName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSDCSyncDataTypeBase.get(this, n);
    }

    private static Object get(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataTypeBase.getCreateDate();
            }
            case 1: {
                return pSDCSyncDataTypeBase.getCreateMan();
            }
            case 2: {
                return pSDCSyncDataTypeBase.getMemo();
            }
            case 3: {
                return pSDCSyncDataTypeBase.getPSDCSyncDataTypeId();
            }
            case 4: {
                return pSDCSyncDataTypeBase.getPSDCSyncDataTypeName();
            }
            case 5: {
                return pSDCSyncDataTypeBase.getTypeObj();
            }
            case 6: {
                return pSDCSyncDataTypeBase.getUpdateDate();
            }
            case 7: {
                return pSDCSyncDataTypeBase.getUpdateMan();
            }
            case 8: {
                return pSDCSyncDataTypeBase.getValidFlag();
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
        PSDCSyncDataTypeBase.set(this, n, object);
    }

    private static void set(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncDataTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCSyncDataTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSyncDataTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCSyncDataTypeBase.setPSDCSyncDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSyncDataTypeBase.setPSDCSyncDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSyncDataTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSyncDataTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCSyncDataTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCSyncDataTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCSyncDataTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCSyncDataTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCSyncDataTypeBase.getMemo() == null;
            }
            case 3: {
                return pSDCSyncDataTypeBase.getPSDCSyncDataTypeId() == null;
            }
            case 4: {
                return pSDCSyncDataTypeBase.getPSDCSyncDataTypeName() == null;
            }
            case 5: {
                return pSDCSyncDataTypeBase.getTypeObj() == null;
            }
            case 6: {
                return pSDCSyncDataTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCSyncDataTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSDCSyncDataTypeBase.getValidFlag() == null;
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
        return PSDCSyncDataTypeBase.contains(this, n);
    }

    private static boolean contains(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncDataTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCSyncDataTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDCSyncDataTypeBase.isMemoDirty();
            }
            case 3: {
                return pSDCSyncDataTypeBase.isPSDCSyncDataTypeIdDirty();
            }
            case 4: {
                return pSDCSyncDataTypeBase.isPSDCSyncDataTypeNameDirty();
            }
            case 5: {
                return pSDCSyncDataTypeBase.isTypeObjDirty();
            }
            case 6: {
                return pSDCSyncDataTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCSyncDataTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSDCSyncDataTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSyncDataTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSyncDataTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdatatypeid", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getPSDCSyncDataTypeId()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncdatatypename", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getPSDCSyncDataTypeName()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSyncDataTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCSyncDataTypeBase.getJSONValue((Object)pSDCSyncDataTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSyncDataTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSyncDataTypeBase.getCreateDate() != null) {
            object = pSDCSyncDataTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncDataTypeBase.getCreateMan() != null) {
            object = pSDCSyncDataTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getMemo() != null) {
            object = pSDCSyncDataTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeId() != null) {
            object = pSDCSyncDataTypeBase.getPSDCSyncDataTypeId();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeName() != null) {
            object = pSDCSyncDataTypeBase.getPSDCSyncDataTypeName();
            xmlNode.setAttribute(FIELD_PSDCSYNCDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getTypeObj() != null) {
            object = pSDCSyncDataTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getUpdateDate() != null) {
            object = pSDCSyncDataTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncDataTypeBase.getUpdateMan() != null) {
            object = pSDCSyncDataTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncDataTypeBase.getValidFlag() != null) {
            object = pSDCSyncDataTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSyncDataTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSyncDataTypeBase.isCreateDateDirty() && (bl || pSDCSyncDataTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSyncDataTypeBase.getCreateDate());
        }
        if (pSDCSyncDataTypeBase.isCreateManDirty() && (bl || pSDCSyncDataTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSyncDataTypeBase.getCreateMan());
        }
        if (pSDCSyncDataTypeBase.isMemoDirty() && (bl || pSDCSyncDataTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSyncDataTypeBase.getMemo());
        }
        if (pSDCSyncDataTypeBase.isPSDCSyncDataTypeIdDirty() && (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeId() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATATYPEID, (Object)pSDCSyncDataTypeBase.getPSDCSyncDataTypeId());
        }
        if (pSDCSyncDataTypeBase.isPSDCSyncDataTypeNameDirty() && (bl || pSDCSyncDataTypeBase.getPSDCSyncDataTypeName() != null)) {
            iDataObject.set(FIELD_PSDCSYNCDATATYPENAME, (Object)pSDCSyncDataTypeBase.getPSDCSyncDataTypeName());
        }
        if (pSDCSyncDataTypeBase.isTypeObjDirty() && (bl || pSDCSyncDataTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSDCSyncDataTypeBase.getTypeObj());
        }
        if (pSDCSyncDataTypeBase.isUpdateDateDirty() && (bl || pSDCSyncDataTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSyncDataTypeBase.getUpdateDate());
        }
        if (pSDCSyncDataTypeBase.isUpdateManDirty() && (bl || pSDCSyncDataTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSyncDataTypeBase.getUpdateMan());
        }
        if (pSDCSyncDataTypeBase.isValidFlagDirty() && (bl || pSDCSyncDataTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCSyncDataTypeBase.getValidFlag());
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
        return PSDCSyncDataTypeBase.remove(this, n);
    }

    private static boolean remove(PSDCSyncDataTypeBase pSDCSyncDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncDataTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCSyncDataTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCSyncDataTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCSyncDataTypeBase.resetPSDCSyncDataTypeId();
                return true;
            }
            case 4: {
                pSDCSyncDataTypeBase.resetPSDCSyncDataTypeName();
                return true;
            }
            case 5: {
                pSDCSyncDataTypeBase.resetTypeObj();
                return true;
            }
            case 6: {
                pSDCSyncDataTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCSyncDataTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSDCSyncDataTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCSyncDataTypeBase getProxyEntity() {
        return this.proxyPSDCSyncDataTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSyncDataTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSyncDataTypeBase) {
            this.proxyPSDCSyncDataTypeBase = (PSDCSyncDataTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDCSyncDataTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCSYNCDATATYPEID, 3);
        fieldIndexMap.put(FIELD_PSDCSYNCDATATYPENAME, 4);
        fieldIndexMap.put(FIELD_TYPEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

