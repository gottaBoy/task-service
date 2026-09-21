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

public abstract class PSSearchEngineTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSearchEngineTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSEARCHENGINETYPEID = "PSSEARCHENGINETYPEID";
    public static final String FIELD_PSSEARCHENGINETYPENAME = "PSSEARCHENGINETYPENAME";
    public static final String FIELD_TYPETAG = "TYPETAG";
    public static final String FIELD_TYPETAG2 = "TYPETAG2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSEARCHENGINETYPEID = 3;
    private static final int INDEX_PSSEARCHENGINETYPENAME = 4;
    private static final int INDEX_TYPETAG = 5;
    private static final int INDEX_TYPETAG2 = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSearchEngineTypeBase proxyPSSearchEngineTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssearchenginetypeidDirtyFlag = false;
    private boolean pssearchenginetypenameDirtyFlag = false;
    private boolean typetagDirtyFlag = false;
    private boolean typetag2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssearchenginetypeid")
    private String pssearchenginetypeid;
    @Column(name="pssearchenginetypename")
    private String pssearchenginetypename;
    @Column(name="typetag")
    private String typetag;
    @Column(name="typetag2")
    private String typetag2;
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

    public void setPSSearchEngineTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchenginetypeid = string;
        this.pssearchenginetypeidDirtyFlag = true;
    }

    public String getPSSearchEngineTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineTypeId();
        }
        return this.pssearchenginetypeid;
    }

    public boolean isPSSearchEngineTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineTypeIdDirty();
        }
        return this.pssearchenginetypeidDirtyFlag;
    }

    public void resetPSSearchEngineTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineTypeId();
            return;
        }
        this.pssearchenginetypeidDirtyFlag = false;
        this.pssearchenginetypeid = null;
    }

    public void setPSSearchEngineTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSearchEngineTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssearchenginetypename = string;
        this.pssearchenginetypenameDirtyFlag = true;
    }

    public String getPSSearchEngineTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSearchEngineTypeName();
        }
        return this.pssearchenginetypename;
    }

    public boolean isPSSearchEngineTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSearchEngineTypeNameDirty();
        }
        return this.pssearchenginetypenameDirtyFlag;
    }

    public void resetPSSearchEngineTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSearchEngineTypeName();
            return;
        }
        this.pssearchenginetypenameDirtyFlag = false;
        this.pssearchenginetypename = null;
    }

    public void setTypeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typetag = string;
        this.typetagDirtyFlag = true;
    }

    public String getTypeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeTag();
        }
        return this.typetag;
    }

    public boolean isTypeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeTagDirty();
        }
        return this.typetagDirtyFlag;
    }

    public void resetTypeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeTag();
            return;
        }
        this.typetagDirtyFlag = false;
        this.typetag = null;
    }

    public void setTypeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typetag2 = string;
        this.typetag2DirtyFlag = true;
    }

    public String getTypeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeTag2();
        }
        return this.typetag2;
    }

    public boolean isTypeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeTag2Dirty();
        }
        return this.typetag2DirtyFlag;
    }

    public void resetTypeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeTag2();
            return;
        }
        this.typetag2DirtyFlag = false;
        this.typetag2 = null;
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
        PSSearchEngineTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSearchEngineTypeBase pSSearchEngineTypeBase) {
        pSSearchEngineTypeBase.resetCreateDate();
        pSSearchEngineTypeBase.resetCreateMan();
        pSSearchEngineTypeBase.resetMemo();
        pSSearchEngineTypeBase.resetPSSearchEngineTypeId();
        pSSearchEngineTypeBase.resetPSSearchEngineTypeName();
        pSSearchEngineTypeBase.resetTypeTag();
        pSSearchEngineTypeBase.resetTypeTag2();
        pSSearchEngineTypeBase.resetUpdateDate();
        pSSearchEngineTypeBase.resetUpdateMan();
        pSSearchEngineTypeBase.resetValidFlag();
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
        if (!bl || this.isPSSearchEngineTypeIdDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINETYPEID, this.getPSSearchEngineTypeId());
        }
        if (!bl || this.isPSSearchEngineTypeNameDirty()) {
            hashMap.put(FIELD_PSSEARCHENGINETYPENAME, this.getPSSearchEngineTypeName());
        }
        if (!bl || this.isTypeTagDirty()) {
            hashMap.put(FIELD_TYPETAG, this.getTypeTag());
        }
        if (!bl || this.isTypeTag2Dirty()) {
            hashMap.put(FIELD_TYPETAG2, this.getTypeTag2());
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
        return PSSearchEngineTypeBase.get(this, n);
    }

    private static Object get(PSSearchEngineTypeBase pSSearchEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineTypeBase.getCreateDate();
            }
            case 1: {
                return pSSearchEngineTypeBase.getCreateMan();
            }
            case 2: {
                return pSSearchEngineTypeBase.getMemo();
            }
            case 3: {
                return pSSearchEngineTypeBase.getPSSearchEngineTypeId();
            }
            case 4: {
                return pSSearchEngineTypeBase.getPSSearchEngineTypeName();
            }
            case 5: {
                return pSSearchEngineTypeBase.getTypeTag();
            }
            case 6: {
                return pSSearchEngineTypeBase.getTypeTag2();
            }
            case 7: {
                return pSSearchEngineTypeBase.getUpdateDate();
            }
            case 8: {
                return pSSearchEngineTypeBase.getUpdateMan();
            }
            case 9: {
                return pSSearchEngineTypeBase.getValidFlag();
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
        PSSearchEngineTypeBase.set(this, n, object);
    }

    private static void set(PSSearchEngineTypeBase pSSearchEngineTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSearchEngineTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSearchEngineTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSearchEngineTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSearchEngineTypeBase.setPSSearchEngineTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSearchEngineTypeBase.setPSSearchEngineTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSearchEngineTypeBase.setTypeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSearchEngineTypeBase.setTypeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSearchEngineTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSearchEngineTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSearchEngineTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSearchEngineTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSearchEngineTypeBase pSSearchEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSearchEngineTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSearchEngineTypeBase.getMemo() == null;
            }
            case 3: {
                return pSSearchEngineTypeBase.getPSSearchEngineTypeId() == null;
            }
            case 4: {
                return pSSearchEngineTypeBase.getPSSearchEngineTypeName() == null;
            }
            case 5: {
                return pSSearchEngineTypeBase.getTypeTag() == null;
            }
            case 6: {
                return pSSearchEngineTypeBase.getTypeTag2() == null;
            }
            case 7: {
                return pSSearchEngineTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSearchEngineTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSSearchEngineTypeBase.getValidFlag() == null;
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
        return PSSearchEngineTypeBase.contains(this, n);
    }

    private static boolean contains(PSSearchEngineTypeBase pSSearchEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSearchEngineTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSearchEngineTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSearchEngineTypeBase.isMemoDirty();
            }
            case 3: {
                return pSSearchEngineTypeBase.isPSSearchEngineTypeIdDirty();
            }
            case 4: {
                return pSSearchEngineTypeBase.isPSSearchEngineTypeNameDirty();
            }
            case 5: {
                return pSSearchEngineTypeBase.isTypeTagDirty();
            }
            case 6: {
                return pSSearchEngineTypeBase.isTypeTag2Dirty();
            }
            case 7: {
                return pSSearchEngineTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSearchEngineTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSSearchEngineTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSearchEngineTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSearchEngineTypeBase pSSearchEngineTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSearchEngineTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchenginetypeid", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getPSSearchEngineTypeId()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssearchenginetypename", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getPSSearchEngineTypeName()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getTypeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typetag", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getTypeTag()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getTypeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typetag2", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getTypeTag2()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSearchEngineTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSearchEngineTypeBase.getJSONValue((Object)pSSearchEngineTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSearchEngineTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSearchEngineTypeBase pSSearchEngineTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSearchEngineTypeBase.getCreateDate() != null) {
            object = pSSearchEngineTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSearchEngineTypeBase.getCreateMan() != null) {
            object = pSSearchEngineTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getMemo() != null) {
            object = pSSearchEngineTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeId() != null) {
            object = pSSearchEngineTypeBase.getPSSearchEngineTypeId();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeName() != null) {
            object = pSSearchEngineTypeBase.getPSSearchEngineTypeName();
            xmlNode.setAttribute(FIELD_PSSEARCHENGINETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getTypeTag() != null) {
            object = pSSearchEngineTypeBase.getTypeTag();
            xmlNode.setAttribute(FIELD_TYPETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getTypeTag2() != null) {
            object = pSSearchEngineTypeBase.getTypeTag2();
            xmlNode.setAttribute(FIELD_TYPETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getUpdateDate() != null) {
            object = pSSearchEngineTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSearchEngineTypeBase.getUpdateMan() != null) {
            object = pSSearchEngineTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSearchEngineTypeBase.getValidFlag() != null) {
            object = pSSearchEngineTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSearchEngineTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSearchEngineTypeBase pSSearchEngineTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSearchEngineTypeBase.isCreateDateDirty() && (bl || pSSearchEngineTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSearchEngineTypeBase.getCreateDate());
        }
        if (pSSearchEngineTypeBase.isCreateManDirty() && (bl || pSSearchEngineTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSearchEngineTypeBase.getCreateMan());
        }
        if (pSSearchEngineTypeBase.isMemoDirty() && (bl || pSSearchEngineTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSearchEngineTypeBase.getMemo());
        }
        if (pSSearchEngineTypeBase.isPSSearchEngineTypeIdDirty() && (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeId() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINETYPEID, (Object)pSSearchEngineTypeBase.getPSSearchEngineTypeId());
        }
        if (pSSearchEngineTypeBase.isPSSearchEngineTypeNameDirty() && (bl || pSSearchEngineTypeBase.getPSSearchEngineTypeName() != null)) {
            iDataObject.set(FIELD_PSSEARCHENGINETYPENAME, (Object)pSSearchEngineTypeBase.getPSSearchEngineTypeName());
        }
        if (pSSearchEngineTypeBase.isTypeTagDirty() && (bl || pSSearchEngineTypeBase.getTypeTag() != null)) {
            iDataObject.set(FIELD_TYPETAG, (Object)pSSearchEngineTypeBase.getTypeTag());
        }
        if (pSSearchEngineTypeBase.isTypeTag2Dirty() && (bl || pSSearchEngineTypeBase.getTypeTag2() != null)) {
            iDataObject.set(FIELD_TYPETAG2, (Object)pSSearchEngineTypeBase.getTypeTag2());
        }
        if (pSSearchEngineTypeBase.isUpdateDateDirty() && (bl || pSSearchEngineTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSearchEngineTypeBase.getUpdateDate());
        }
        if (pSSearchEngineTypeBase.isUpdateManDirty() && (bl || pSSearchEngineTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSearchEngineTypeBase.getUpdateMan());
        }
        if (pSSearchEngineTypeBase.isValidFlagDirty() && (bl || pSSearchEngineTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSearchEngineTypeBase.getValidFlag());
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
        return PSSearchEngineTypeBase.remove(this, n);
    }

    private static boolean remove(PSSearchEngineTypeBase pSSearchEngineTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSearchEngineTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSearchEngineTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSearchEngineTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSearchEngineTypeBase.resetPSSearchEngineTypeId();
                return true;
            }
            case 4: {
                pSSearchEngineTypeBase.resetPSSearchEngineTypeName();
                return true;
            }
            case 5: {
                pSSearchEngineTypeBase.resetTypeTag();
                return true;
            }
            case 6: {
                pSSearchEngineTypeBase.resetTypeTag2();
                return true;
            }
            case 7: {
                pSSearchEngineTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSearchEngineTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSSearchEngineTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSearchEngineTypeBase getProxyEntity() {
        return this.proxyPSSearchEngineTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSearchEngineTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSearchEngineTypeBase) {
            this.proxyPSSearchEngineTypeBase = (PSSearchEngineTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSearchEngineTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSEARCHENGINETYPEID, 3);
        fieldIndexMap.put(FIELD_PSSEARCHENGINETYPENAME, 4);
        fieldIndexMap.put(FIELD_TYPETAG, 5);
        fieldIndexMap.put(FIELD_TYPETAG2, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

