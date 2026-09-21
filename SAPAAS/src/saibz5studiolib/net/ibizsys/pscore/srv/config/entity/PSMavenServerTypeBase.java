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

public abstract class PSMavenServerTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMavenServerTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMAVENSERVERTYPEID = "PSMAVENSERVERTYPEID";
    public static final String FIELD_PSMAVENSERVERTYPENAME = "PSMAVENSERVERTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSMAVENSERVERTYPEID = 3;
    private static final int INDEX_PSMAVENSERVERTYPENAME = 4;
    private static final int INDEX_TYPEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMavenServerTypeBase proxyPSMavenServerTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmavenservertypeidDirtyFlag = false;
    private boolean psmavenservertypenameDirtyFlag = false;
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
    @Column(name="psmavenservertypeid")
    private String psmavenservertypeid;
    @Column(name="psmavenservertypename")
    private String psmavenservertypename;
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

    public void setPSMavenServerTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenservertypeid = string;
        this.psmavenservertypeidDirtyFlag = true;
    }

    public String getPSMavenServerTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerTypeId();
        }
        return this.psmavenservertypeid;
    }

    public boolean isPSMavenServerTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerTypeIdDirty();
        }
        return this.psmavenservertypeidDirtyFlag;
    }

    public void resetPSMavenServerTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerTypeId();
            return;
        }
        this.psmavenservertypeidDirtyFlag = false;
        this.psmavenservertypeid = null;
    }

    public void setPSMavenServerTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMavenServerTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmavenservertypename = string;
        this.psmavenservertypenameDirtyFlag = true;
    }

    public String getPSMavenServerTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMavenServerTypeName();
        }
        return this.psmavenservertypename;
    }

    public boolean isPSMavenServerTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMavenServerTypeNameDirty();
        }
        return this.psmavenservertypenameDirtyFlag;
    }

    public void resetPSMavenServerTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMavenServerTypeName();
            return;
        }
        this.psmavenservertypenameDirtyFlag = false;
        this.psmavenservertypename = null;
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
        PSMavenServerTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMavenServerTypeBase pSMavenServerTypeBase) {
        pSMavenServerTypeBase.resetCreateDate();
        pSMavenServerTypeBase.resetCreateMan();
        pSMavenServerTypeBase.resetMemo();
        pSMavenServerTypeBase.resetPSMavenServerTypeId();
        pSMavenServerTypeBase.resetPSMavenServerTypeName();
        pSMavenServerTypeBase.resetTypeObj();
        pSMavenServerTypeBase.resetUpdateDate();
        pSMavenServerTypeBase.resetUpdateMan();
        pSMavenServerTypeBase.resetValidFlag();
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
        if (!bl || this.isPSMavenServerTypeIdDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERTYPEID, this.getPSMavenServerTypeId());
        }
        if (!bl || this.isPSMavenServerTypeNameDirty()) {
            hashMap.put(FIELD_PSMAVENSERVERTYPENAME, this.getPSMavenServerTypeName());
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
        return PSMavenServerTypeBase.get(this, n);
    }

    private static Object get(PSMavenServerTypeBase pSMavenServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerTypeBase.getCreateDate();
            }
            case 1: {
                return pSMavenServerTypeBase.getCreateMan();
            }
            case 2: {
                return pSMavenServerTypeBase.getMemo();
            }
            case 3: {
                return pSMavenServerTypeBase.getPSMavenServerTypeId();
            }
            case 4: {
                return pSMavenServerTypeBase.getPSMavenServerTypeName();
            }
            case 5: {
                return pSMavenServerTypeBase.getTypeObj();
            }
            case 6: {
                return pSMavenServerTypeBase.getUpdateDate();
            }
            case 7: {
                return pSMavenServerTypeBase.getUpdateMan();
            }
            case 8: {
                return pSMavenServerTypeBase.getValidFlag();
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
        PSMavenServerTypeBase.set(this, n, object);
    }

    private static void set(PSMavenServerTypeBase pSMavenServerTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMavenServerTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMavenServerTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMavenServerTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMavenServerTypeBase.setPSMavenServerTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMavenServerTypeBase.setPSMavenServerTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMavenServerTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMavenServerTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSMavenServerTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMavenServerTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMavenServerTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSMavenServerTypeBase pSMavenServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSMavenServerTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSMavenServerTypeBase.getMemo() == null;
            }
            case 3: {
                return pSMavenServerTypeBase.getPSMavenServerTypeId() == null;
            }
            case 4: {
                return pSMavenServerTypeBase.getPSMavenServerTypeName() == null;
            }
            case 5: {
                return pSMavenServerTypeBase.getTypeObj() == null;
            }
            case 6: {
                return pSMavenServerTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSMavenServerTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSMavenServerTypeBase.getValidFlag() == null;
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
        return PSMavenServerTypeBase.contains(this, n);
    }

    private static boolean contains(PSMavenServerTypeBase pSMavenServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMavenServerTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSMavenServerTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSMavenServerTypeBase.isMemoDirty();
            }
            case 3: {
                return pSMavenServerTypeBase.isPSMavenServerTypeIdDirty();
            }
            case 4: {
                return pSMavenServerTypeBase.isPSMavenServerTypeNameDirty();
            }
            case 5: {
                return pSMavenServerTypeBase.isTypeObjDirty();
            }
            case 6: {
                return pSMavenServerTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSMavenServerTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSMavenServerTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMavenServerTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMavenServerTypeBase pSMavenServerTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMavenServerTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getPSMavenServerTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenservertypeid", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getPSMavenServerTypeId()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getPSMavenServerTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmavenservertypename", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getPSMavenServerTypeName()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMavenServerTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMavenServerTypeBase.getJSONValue((Object)pSMavenServerTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMavenServerTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMavenServerTypeBase pSMavenServerTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMavenServerTypeBase.getCreateDate() != null) {
            object = pSMavenServerTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenServerTypeBase.getCreateMan() != null) {
            object = pSMavenServerTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getMemo() != null) {
            object = pSMavenServerTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getPSMavenServerTypeId() != null) {
            object = pSMavenServerTypeBase.getPSMavenServerTypeId();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getPSMavenServerTypeName() != null) {
            object = pSMavenServerTypeBase.getPSMavenServerTypeName();
            xmlNode.setAttribute(FIELD_PSMAVENSERVERTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getTypeObj() != null) {
            object = pSMavenServerTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getUpdateDate() != null) {
            object = pSMavenServerTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMavenServerTypeBase.getUpdateMan() != null) {
            object = pSMavenServerTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMavenServerTypeBase.getValidFlag() != null) {
            object = pSMavenServerTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMavenServerTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMavenServerTypeBase pSMavenServerTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMavenServerTypeBase.isCreateDateDirty() && (bl || pSMavenServerTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMavenServerTypeBase.getCreateDate());
        }
        if (pSMavenServerTypeBase.isCreateManDirty() && (bl || pSMavenServerTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMavenServerTypeBase.getCreateMan());
        }
        if (pSMavenServerTypeBase.isMemoDirty() && (bl || pSMavenServerTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMavenServerTypeBase.getMemo());
        }
        if (pSMavenServerTypeBase.isPSMavenServerTypeIdDirty() && (bl || pSMavenServerTypeBase.getPSMavenServerTypeId() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERTYPEID, (Object)pSMavenServerTypeBase.getPSMavenServerTypeId());
        }
        if (pSMavenServerTypeBase.isPSMavenServerTypeNameDirty() && (bl || pSMavenServerTypeBase.getPSMavenServerTypeName() != null)) {
            iDataObject.set(FIELD_PSMAVENSERVERTYPENAME, (Object)pSMavenServerTypeBase.getPSMavenServerTypeName());
        }
        if (pSMavenServerTypeBase.isTypeObjDirty() && (bl || pSMavenServerTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSMavenServerTypeBase.getTypeObj());
        }
        if (pSMavenServerTypeBase.isUpdateDateDirty() && (bl || pSMavenServerTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMavenServerTypeBase.getUpdateDate());
        }
        if (pSMavenServerTypeBase.isUpdateManDirty() && (bl || pSMavenServerTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMavenServerTypeBase.getUpdateMan());
        }
        if (pSMavenServerTypeBase.isValidFlagDirty() && (bl || pSMavenServerTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMavenServerTypeBase.getValidFlag());
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
        return PSMavenServerTypeBase.remove(this, n);
    }

    private static boolean remove(PSMavenServerTypeBase pSMavenServerTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMavenServerTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMavenServerTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMavenServerTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSMavenServerTypeBase.resetPSMavenServerTypeId();
                return true;
            }
            case 4: {
                pSMavenServerTypeBase.resetPSMavenServerTypeName();
                return true;
            }
            case 5: {
                pSMavenServerTypeBase.resetTypeObj();
                return true;
            }
            case 6: {
                pSMavenServerTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSMavenServerTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSMavenServerTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSMavenServerTypeBase getProxyEntity() {
        return this.proxyPSMavenServerTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMavenServerTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSMavenServerTypeBase) {
            this.proxyPSMavenServerTypeBase = (PSMavenServerTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSMavenServerTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSMAVENSERVERTYPEID, 3);
        fieldIndexMap.put(FIELD_PSMAVENSERVERTYPENAME, 4);
        fieldIndexMap.put(FIELD_TYPEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

