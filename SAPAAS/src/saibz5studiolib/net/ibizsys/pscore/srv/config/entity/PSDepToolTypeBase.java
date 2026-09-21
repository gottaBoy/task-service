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

public abstract class PSDepToolTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepToolTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEPOBJ = "DEPOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PACKOBJ = "PACKOBJ";
    public static final String FIELD_PSDEPTOOLTYPEID = "PSDEPTOOLTYPEID";
    public static final String FIELD_PSDEPTOOLTYPENAME = "PSDEPTOOLTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEPOBJ = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PACKOBJ = 4;
    private static final int INDEX_PSDEPTOOLTYPEID = 5;
    private static final int INDEX_PSDEPTOOLTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepToolTypeBase proxyPSDepToolTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean depobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean packobjDirtyFlag = false;
    private boolean psdeptooltypeidDirtyFlag = false;
    private boolean psdeptooltypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="depobj")
    private String depobj;
    @Column(name="memo")
    private String memo;
    @Column(name="packobj")
    private String packobj;
    @Column(name="psdeptooltypeid")
    private String psdeptooltypeid;
    @Column(name="psdeptooltypename")
    private String psdeptooltypename;
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

    public void setDepObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDepObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.depobj = string;
        this.depobjDirtyFlag = true;
    }

    public String getDepObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDepObj();
        }
        return this.depobj;
    }

    public boolean isDepObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDepObjDirty();
        }
        return this.depobjDirtyFlag;
    }

    public void resetDepObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDepObj();
            return;
        }
        this.depobjDirtyFlag = false;
        this.depobj = null;
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

    public void setPackObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPackObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.packobj = string;
        this.packobjDirtyFlag = true;
    }

    public String getPackObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPackObj();
        }
        return this.packobj;
    }

    public boolean isPackObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPackObjDirty();
        }
        return this.packobjDirtyFlag;
    }

    public void resetPackObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPackObj();
            return;
        }
        this.packobjDirtyFlag = false;
        this.packobj = null;
    }

    public void setPSDepToolTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepToolTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeptooltypeid = string;
        this.psdeptooltypeidDirtyFlag = true;
    }

    public String getPSDepToolTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepToolTypeId();
        }
        return this.psdeptooltypeid;
    }

    public boolean isPSDepToolTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepToolTypeIdDirty();
        }
        return this.psdeptooltypeidDirtyFlag;
    }

    public void resetPSDepToolTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepToolTypeId();
            return;
        }
        this.psdeptooltypeidDirtyFlag = false;
        this.psdeptooltypeid = null;
    }

    public void setPSDepToolTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepToolTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeptooltypename = string;
        this.psdeptooltypenameDirtyFlag = true;
    }

    public String getPSDepToolTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepToolTypeName();
        }
        return this.psdeptooltypename;
    }

    public boolean isPSDepToolTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepToolTypeNameDirty();
        }
        return this.psdeptooltypenameDirtyFlag;
    }

    public void resetPSDepToolTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepToolTypeName();
            return;
        }
        this.psdeptooltypenameDirtyFlag = false;
        this.psdeptooltypename = null;
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
        PSDepToolTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepToolTypeBase pSDepToolTypeBase) {
        pSDepToolTypeBase.resetCreateDate();
        pSDepToolTypeBase.resetCreateMan();
        pSDepToolTypeBase.resetDepObj();
        pSDepToolTypeBase.resetMemo();
        pSDepToolTypeBase.resetPackObj();
        pSDepToolTypeBase.resetPSDepToolTypeId();
        pSDepToolTypeBase.resetPSDepToolTypeName();
        pSDepToolTypeBase.resetUpdateDate();
        pSDepToolTypeBase.resetUpdateMan();
        pSDepToolTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDepObjDirty()) {
            hashMap.put(FIELD_DEPOBJ, this.getDepObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPackObjDirty()) {
            hashMap.put(FIELD_PACKOBJ, this.getPackObj());
        }
        if (!bl || this.isPSDepToolTypeIdDirty()) {
            hashMap.put(FIELD_PSDEPTOOLTYPEID, this.getPSDepToolTypeId());
        }
        if (!bl || this.isPSDepToolTypeNameDirty()) {
            hashMap.put(FIELD_PSDEPTOOLTYPENAME, this.getPSDepToolTypeName());
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
        return PSDepToolTypeBase.get(this, n);
    }

    private static Object get(PSDepToolTypeBase pSDepToolTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepToolTypeBase.getCreateDate();
            }
            case 1: {
                return pSDepToolTypeBase.getCreateMan();
            }
            case 2: {
                return pSDepToolTypeBase.getDepObj();
            }
            case 3: {
                return pSDepToolTypeBase.getMemo();
            }
            case 4: {
                return pSDepToolTypeBase.getPackObj();
            }
            case 5: {
                return pSDepToolTypeBase.getPSDepToolTypeId();
            }
            case 6: {
                return pSDepToolTypeBase.getPSDepToolTypeName();
            }
            case 7: {
                return pSDepToolTypeBase.getUpdateDate();
            }
            case 8: {
                return pSDepToolTypeBase.getUpdateMan();
            }
            case 9: {
                return pSDepToolTypeBase.getValidFlag();
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
        PSDepToolTypeBase.set(this, n, object);
    }

    private static void set(PSDepToolTypeBase pSDepToolTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepToolTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepToolTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepToolTypeBase.setDepObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepToolTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepToolTypeBase.setPackObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepToolTypeBase.setPSDepToolTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepToolTypeBase.setPSDepToolTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepToolTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDepToolTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepToolTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepToolTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDepToolTypeBase pSDepToolTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepToolTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepToolTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepToolTypeBase.getDepObj() == null;
            }
            case 3: {
                return pSDepToolTypeBase.getMemo() == null;
            }
            case 4: {
                return pSDepToolTypeBase.getPackObj() == null;
            }
            case 5: {
                return pSDepToolTypeBase.getPSDepToolTypeId() == null;
            }
            case 6: {
                return pSDepToolTypeBase.getPSDepToolTypeName() == null;
            }
            case 7: {
                return pSDepToolTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDepToolTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSDepToolTypeBase.getValidFlag() == null;
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
        return PSDepToolTypeBase.contains(this, n);
    }

    private static boolean contains(PSDepToolTypeBase pSDepToolTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepToolTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepToolTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDepToolTypeBase.isDepObjDirty();
            }
            case 3: {
                return pSDepToolTypeBase.isMemoDirty();
            }
            case 4: {
                return pSDepToolTypeBase.isPackObjDirty();
            }
            case 5: {
                return pSDepToolTypeBase.isPSDepToolTypeIdDirty();
            }
            case 6: {
                return pSDepToolTypeBase.isPSDepToolTypeNameDirty();
            }
            case 7: {
                return pSDepToolTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDepToolTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSDepToolTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepToolTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepToolTypeBase pSDepToolTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepToolTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getDepObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"depobj", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getDepObj()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getPackObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"packobj", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getPackObj()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getPSDepToolTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeptooltypeid", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getPSDepToolTypeId()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getPSDepToolTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeptooltypename", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getPSDepToolTypeName()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepToolTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepToolTypeBase.getJSONValue((Object)pSDepToolTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepToolTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepToolTypeBase pSDepToolTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepToolTypeBase.getCreateDate() != null) {
            object = pSDepToolTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepToolTypeBase.getCreateMan() != null) {
            object = pSDepToolTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getDepObj() != null) {
            object = pSDepToolTypeBase.getDepObj();
            xmlNode.setAttribute(FIELD_DEPOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getMemo() != null) {
            object = pSDepToolTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getPackObj() != null) {
            object = pSDepToolTypeBase.getPackObj();
            xmlNode.setAttribute(FIELD_PACKOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getPSDepToolTypeId() != null) {
            object = pSDepToolTypeBase.getPSDepToolTypeId();
            xmlNode.setAttribute(FIELD_PSDEPTOOLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getPSDepToolTypeName() != null) {
            object = pSDepToolTypeBase.getPSDepToolTypeName();
            xmlNode.setAttribute(FIELD_PSDEPTOOLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getUpdateDate() != null) {
            object = pSDepToolTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepToolTypeBase.getUpdateMan() != null) {
            object = pSDepToolTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepToolTypeBase.getValidFlag() != null) {
            object = pSDepToolTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepToolTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepToolTypeBase pSDepToolTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepToolTypeBase.isCreateDateDirty() && (bl || pSDepToolTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepToolTypeBase.getCreateDate());
        }
        if (pSDepToolTypeBase.isCreateManDirty() && (bl || pSDepToolTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepToolTypeBase.getCreateMan());
        }
        if (pSDepToolTypeBase.isDepObjDirty() && (bl || pSDepToolTypeBase.getDepObj() != null)) {
            iDataObject.set(FIELD_DEPOBJ, (Object)pSDepToolTypeBase.getDepObj());
        }
        if (pSDepToolTypeBase.isMemoDirty() && (bl || pSDepToolTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepToolTypeBase.getMemo());
        }
        if (pSDepToolTypeBase.isPackObjDirty() && (bl || pSDepToolTypeBase.getPackObj() != null)) {
            iDataObject.set(FIELD_PACKOBJ, (Object)pSDepToolTypeBase.getPackObj());
        }
        if (pSDepToolTypeBase.isPSDepToolTypeIdDirty() && (bl || pSDepToolTypeBase.getPSDepToolTypeId() != null)) {
            iDataObject.set(FIELD_PSDEPTOOLTYPEID, (Object)pSDepToolTypeBase.getPSDepToolTypeId());
        }
        if (pSDepToolTypeBase.isPSDepToolTypeNameDirty() && (bl || pSDepToolTypeBase.getPSDepToolTypeName() != null)) {
            iDataObject.set(FIELD_PSDEPTOOLTYPENAME, (Object)pSDepToolTypeBase.getPSDepToolTypeName());
        }
        if (pSDepToolTypeBase.isUpdateDateDirty() && (bl || pSDepToolTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepToolTypeBase.getUpdateDate());
        }
        if (pSDepToolTypeBase.isUpdateManDirty() && (bl || pSDepToolTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepToolTypeBase.getUpdateMan());
        }
        if (pSDepToolTypeBase.isValidFlagDirty() && (bl || pSDepToolTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepToolTypeBase.getValidFlag());
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
        return PSDepToolTypeBase.remove(this, n);
    }

    private static boolean remove(PSDepToolTypeBase pSDepToolTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepToolTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepToolTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepToolTypeBase.resetDepObj();
                return true;
            }
            case 3: {
                pSDepToolTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDepToolTypeBase.resetPackObj();
                return true;
            }
            case 5: {
                pSDepToolTypeBase.resetPSDepToolTypeId();
                return true;
            }
            case 6: {
                pSDepToolTypeBase.resetPSDepToolTypeName();
                return true;
            }
            case 7: {
                pSDepToolTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDepToolTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSDepToolTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDepToolTypeBase getProxyEntity() {
        return this.proxyPSDepToolTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepToolTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepToolTypeBase) {
            this.proxyPSDepToolTypeBase = (PSDepToolTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDepToolTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEPOBJ, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PACKOBJ, 4);
        fieldIndexMap.put(FIELD_PSDEPTOOLTYPEID, 5);
        fieldIndexMap.put(FIELD_PSDEPTOOLTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

