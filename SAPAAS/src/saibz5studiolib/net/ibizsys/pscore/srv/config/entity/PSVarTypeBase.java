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

public abstract class PSVarTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVarTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSVARTYPEID = "PSVARTYPEID";
    public static final String FIELD_PSVARTYPENAME = "PSVARTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PSVARTYPEID = 5;
    private static final int INDEX_PSVARTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVarTypeBase proxyPSVarTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psvartypeidDirtyFlag = false;
    private boolean psvartypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psvartypeid")
    private String psvartypeid;
    @Column(name="psvartypename")
    private String psvartypename;
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

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSVarTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypeid = string;
        this.psvartypeidDirtyFlag = true;
    }

    public String getPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarTypeId();
        }
        return this.psvartypeid;
    }

    public boolean isPSVarTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarTypeIdDirty();
        }
        return this.psvartypeidDirtyFlag;
    }

    public void resetPSVarTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarTypeId();
            return;
        }
        this.psvartypeidDirtyFlag = false;
        this.psvartypeid = null;
    }

    public void setPSVarTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVarTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvartypename = string;
        this.psvartypenameDirtyFlag = true;
    }

    public String getPSVarTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVarTypeName();
        }
        return this.psvartypename;
    }

    public boolean isPSVarTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVarTypeNameDirty();
        }
        return this.psvartypenameDirtyFlag;
    }

    public void resetPSVarTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVarTypeName();
            return;
        }
        this.psvartypenameDirtyFlag = false;
        this.psvartypename = null;
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
        PSVarTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVarTypeBase pSVarTypeBase) {
        pSVarTypeBase.resetCreateDate();
        pSVarTypeBase.resetCreateMan();
        pSVarTypeBase.resetIconPath();
        pSVarTypeBase.resetMemo();
        pSVarTypeBase.resetOrderValue();
        pSVarTypeBase.resetPSVarTypeId();
        pSVarTypeBase.resetPSVarTypeName();
        pSVarTypeBase.resetUpdateDate();
        pSVarTypeBase.resetUpdateMan();
        pSVarTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSVarTypeIdDirty()) {
            hashMap.put(FIELD_PSVARTYPEID, this.getPSVarTypeId());
        }
        if (!bl || this.isPSVarTypeNameDirty()) {
            hashMap.put(FIELD_PSVARTYPENAME, this.getPSVarTypeName());
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
        return PSVarTypeBase.get(this, n);
    }

    private static Object get(PSVarTypeBase pSVarTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarTypeBase.getCreateDate();
            }
            case 1: {
                return pSVarTypeBase.getCreateMan();
            }
            case 2: {
                return pSVarTypeBase.getIconPath();
            }
            case 3: {
                return pSVarTypeBase.getMemo();
            }
            case 4: {
                return pSVarTypeBase.getOrderValue();
            }
            case 5: {
                return pSVarTypeBase.getPSVarTypeId();
            }
            case 6: {
                return pSVarTypeBase.getPSVarTypeName();
            }
            case 7: {
                return pSVarTypeBase.getUpdateDate();
            }
            case 8: {
                return pSVarTypeBase.getUpdateMan();
            }
            case 9: {
                return pSVarTypeBase.getValidFlag();
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
        PSVarTypeBase.set(this, n, object);
    }

    private static void set(PSVarTypeBase pSVarTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVarTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVarTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVarTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVarTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVarTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSVarTypeBase.setPSVarTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSVarTypeBase.setPSVarTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVarTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSVarTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSVarTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSVarTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSVarTypeBase pSVarTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSVarTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSVarTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSVarTypeBase.getMemo() == null;
            }
            case 4: {
                return pSVarTypeBase.getOrderValue() == null;
            }
            case 5: {
                return pSVarTypeBase.getPSVarTypeId() == null;
            }
            case 6: {
                return pSVarTypeBase.getPSVarTypeName() == null;
            }
            case 7: {
                return pSVarTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSVarTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSVarTypeBase.getValidFlag() == null;
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
        return PSVarTypeBase.contains(this, n);
    }

    private static boolean contains(PSVarTypeBase pSVarTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVarTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSVarTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSVarTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSVarTypeBase.isMemoDirty();
            }
            case 4: {
                return pSVarTypeBase.isOrderValueDirty();
            }
            case 5: {
                return pSVarTypeBase.isPSVarTypeIdDirty();
            }
            case 6: {
                return pSVarTypeBase.isPSVarTypeNameDirty();
            }
            case 7: {
                return pSVarTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSVarTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSVarTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVarTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVarTypeBase pSVarTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVarTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getPSVarTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypeid", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getPSVarTypeId()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getPSVarTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvartypename", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getPSVarTypeName()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSVarTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSVarTypeBase.getJSONValue((Object)pSVarTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVarTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVarTypeBase pSVarTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVarTypeBase.getCreateDate() != null) {
            object = pSVarTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVarTypeBase.getCreateMan() != null) {
            object = pSVarTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getIconPath() != null) {
            object = pSVarTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getMemo() != null) {
            object = pSVarTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getOrderValue() != null) {
            object = pSVarTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSVarTypeBase.getPSVarTypeId() != null) {
            object = pSVarTypeBase.getPSVarTypeId();
            xmlNode.setAttribute(FIELD_PSVARTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getPSVarTypeName() != null) {
            object = pSVarTypeBase.getPSVarTypeName();
            xmlNode.setAttribute(FIELD_PSVARTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getUpdateDate() != null) {
            object = pSVarTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVarTypeBase.getUpdateMan() != null) {
            object = pSVarTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVarTypeBase.getValidFlag() != null) {
            object = pSVarTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVarTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVarTypeBase pSVarTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVarTypeBase.isCreateDateDirty() && (bl || pSVarTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVarTypeBase.getCreateDate());
        }
        if (pSVarTypeBase.isCreateManDirty() && (bl || pSVarTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVarTypeBase.getCreateMan());
        }
        if (pSVarTypeBase.isIconPathDirty() && (bl || pSVarTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSVarTypeBase.getIconPath());
        }
        if (pSVarTypeBase.isMemoDirty() && (bl || pSVarTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVarTypeBase.getMemo());
        }
        if (pSVarTypeBase.isOrderValueDirty() && (bl || pSVarTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSVarTypeBase.getOrderValue());
        }
        if (pSVarTypeBase.isPSVarTypeIdDirty() && (bl || pSVarTypeBase.getPSVarTypeId() != null)) {
            iDataObject.set(FIELD_PSVARTYPEID, (Object)pSVarTypeBase.getPSVarTypeId());
        }
        if (pSVarTypeBase.isPSVarTypeNameDirty() && (bl || pSVarTypeBase.getPSVarTypeName() != null)) {
            iDataObject.set(FIELD_PSVARTYPENAME, (Object)pSVarTypeBase.getPSVarTypeName());
        }
        if (pSVarTypeBase.isUpdateDateDirty() && (bl || pSVarTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVarTypeBase.getUpdateDate());
        }
        if (pSVarTypeBase.isUpdateManDirty() && (bl || pSVarTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVarTypeBase.getUpdateMan());
        }
        if (pSVarTypeBase.isValidFlagDirty() && (bl || pSVarTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSVarTypeBase.getValidFlag());
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
        return PSVarTypeBase.remove(this, n);
    }

    private static boolean remove(PSVarTypeBase pSVarTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVarTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVarTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVarTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSVarTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSVarTypeBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSVarTypeBase.resetPSVarTypeId();
                return true;
            }
            case 6: {
                pSVarTypeBase.resetPSVarTypeName();
                return true;
            }
            case 7: {
                pSVarTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSVarTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSVarTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSVarTypeBase getProxyEntity() {
        return this.proxyPSVarTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVarTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSVarTypeBase) {
            this.proxyPSVarTypeBase = (PSVarTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVarTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PSVARTYPEID, 5);
        fieldIndexMap.put(FIELD_PSVARTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

