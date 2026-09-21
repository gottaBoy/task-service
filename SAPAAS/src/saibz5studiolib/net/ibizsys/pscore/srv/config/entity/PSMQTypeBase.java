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

public abstract class PSMQTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMQTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_INSTALLPATH = "INSTALLPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSMQTYPEID = "PSMQTYPEID";
    public static final String FIELD_PSMQTYPENAME = "PSMQTYPENAME";
    public static final String FIELD_TYPEHELPER = "TYPEHELPER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_INSTALLPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSMQTYPEID = 4;
    private static final int INDEX_PSMQTYPENAME = 5;
    private static final int INDEX_TYPEHELPER = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMQTypeBase proxyPSMQTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean installpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psmqtypeidDirtyFlag = false;
    private boolean psmqtypenameDirtyFlag = false;
    private boolean typehelperDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="installpath")
    private String installpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psmqtypeid")
    private String psmqtypeid;
    @Column(name="psmqtypename")
    private String psmqtypename;
    @Column(name="typehelper")
    private String typehelper;
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

    public void setInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.installpath = string;
        this.installpathDirtyFlag = true;
    }

    public String getInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstallPath();
        }
        return this.installpath;
    }

    public boolean isInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstallPathDirty();
        }
        return this.installpathDirtyFlag;
    }

    public void resetInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstallPath();
            return;
        }
        this.installpathDirtyFlag = false;
        this.installpath = null;
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

    public void setPSMQTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqtypeid = string;
        this.psmqtypeidDirtyFlag = true;
    }

    public String getPSMQTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQTypeId();
        }
        return this.psmqtypeid;
    }

    public boolean isPSMQTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQTypeIdDirty();
        }
        return this.psmqtypeidDirtyFlag;
    }

    public void resetPSMQTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQTypeId();
            return;
        }
        this.psmqtypeidDirtyFlag = false;
        this.psmqtypeid = null;
    }

    public void setPSMQTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMQTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmqtypename = string;
        this.psmqtypenameDirtyFlag = true;
    }

    public String getPSMQTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMQTypeName();
        }
        return this.psmqtypename;
    }

    public boolean isPSMQTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMQTypeNameDirty();
        }
        return this.psmqtypenameDirtyFlag;
    }

    public void resetPSMQTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMQTypeName();
            return;
        }
        this.psmqtypenameDirtyFlag = false;
        this.psmqtypename = null;
    }

    public void setTypeHelper(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeHelper(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typehelper = string;
        this.typehelperDirtyFlag = true;
    }

    public String getTypeHelper() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeHelper();
        }
        return this.typehelper;
    }

    public boolean isTypeHelperDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeHelperDirty();
        }
        return this.typehelperDirtyFlag;
    }

    public void resetTypeHelper() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeHelper();
            return;
        }
        this.typehelperDirtyFlag = false;
        this.typehelper = null;
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
        PSMQTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMQTypeBase pSMQTypeBase) {
        pSMQTypeBase.resetCreateDate();
        pSMQTypeBase.resetCreateMan();
        pSMQTypeBase.resetInstallPath();
        pSMQTypeBase.resetMemo();
        pSMQTypeBase.resetPSMQTypeId();
        pSMQTypeBase.resetPSMQTypeName();
        pSMQTypeBase.resetTypeHelper();
        pSMQTypeBase.resetUpdateDate();
        pSMQTypeBase.resetUpdateMan();
        pSMQTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isInstallPathDirty()) {
            hashMap.put(FIELD_INSTALLPATH, this.getInstallPath());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSMQTypeIdDirty()) {
            hashMap.put(FIELD_PSMQTYPEID, this.getPSMQTypeId());
        }
        if (!bl || this.isPSMQTypeNameDirty()) {
            hashMap.put(FIELD_PSMQTYPENAME, this.getPSMQTypeName());
        }
        if (!bl || this.isTypeHelperDirty()) {
            hashMap.put(FIELD_TYPEHELPER, this.getTypeHelper());
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
        return PSMQTypeBase.get(this, n);
    }

    private static Object get(PSMQTypeBase pSMQTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQTypeBase.getCreateDate();
            }
            case 1: {
                return pSMQTypeBase.getCreateMan();
            }
            case 2: {
                return pSMQTypeBase.getInstallPath();
            }
            case 3: {
                return pSMQTypeBase.getMemo();
            }
            case 4: {
                return pSMQTypeBase.getPSMQTypeId();
            }
            case 5: {
                return pSMQTypeBase.getPSMQTypeName();
            }
            case 6: {
                return pSMQTypeBase.getTypeHelper();
            }
            case 7: {
                return pSMQTypeBase.getUpdateDate();
            }
            case 8: {
                return pSMQTypeBase.getUpdateMan();
            }
            case 9: {
                return pSMQTypeBase.getValidFlag();
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
        PSMQTypeBase.set(this, n, object);
    }

    private static void set(PSMQTypeBase pSMQTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMQTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMQTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMQTypeBase.setInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMQTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMQTypeBase.setPSMQTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMQTypeBase.setPSMQTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMQTypeBase.setTypeHelper(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMQTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSMQTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMQTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSMQTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSMQTypeBase pSMQTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSMQTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSMQTypeBase.getInstallPath() == null;
            }
            case 3: {
                return pSMQTypeBase.getMemo() == null;
            }
            case 4: {
                return pSMQTypeBase.getPSMQTypeId() == null;
            }
            case 5: {
                return pSMQTypeBase.getPSMQTypeName() == null;
            }
            case 6: {
                return pSMQTypeBase.getTypeHelper() == null;
            }
            case 7: {
                return pSMQTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSMQTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSMQTypeBase.getValidFlag() == null;
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
        return PSMQTypeBase.contains(this, n);
    }

    private static boolean contains(PSMQTypeBase pSMQTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMQTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSMQTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSMQTypeBase.isInstallPathDirty();
            }
            case 3: {
                return pSMQTypeBase.isMemoDirty();
            }
            case 4: {
                return pSMQTypeBase.isPSMQTypeIdDirty();
            }
            case 5: {
                return pSMQTypeBase.isPSMQTypeNameDirty();
            }
            case 6: {
                return pSMQTypeBase.isTypeHelperDirty();
            }
            case 7: {
                return pSMQTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSMQTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSMQTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMQTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMQTypeBase pSMQTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMQTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"installpath", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getInstallPath()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getPSMQTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqtypeid", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getPSMQTypeId()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getPSMQTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmqtypename", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getPSMQTypeName()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getTypeHelper() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typehelper", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getTypeHelper()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSMQTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSMQTypeBase.getJSONValue((Object)pSMQTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMQTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMQTypeBase pSMQTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMQTypeBase.getCreateDate() != null) {
            object = pSMQTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMQTypeBase.getCreateMan() != null) {
            object = pSMQTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getInstallPath() != null) {
            object = pSMQTypeBase.getInstallPath();
            xmlNode.setAttribute(FIELD_INSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getMemo() != null) {
            object = pSMQTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getPSMQTypeId() != null) {
            object = pSMQTypeBase.getPSMQTypeId();
            xmlNode.setAttribute(FIELD_PSMQTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getPSMQTypeName() != null) {
            object = pSMQTypeBase.getPSMQTypeName();
            xmlNode.setAttribute(FIELD_PSMQTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getTypeHelper() != null) {
            object = pSMQTypeBase.getTypeHelper();
            xmlNode.setAttribute(FIELD_TYPEHELPER, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getUpdateDate() != null) {
            object = pSMQTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMQTypeBase.getUpdateMan() != null) {
            object = pSMQTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMQTypeBase.getValidFlag() != null) {
            object = pSMQTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMQTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMQTypeBase pSMQTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMQTypeBase.isCreateDateDirty() && (bl || pSMQTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMQTypeBase.getCreateDate());
        }
        if (pSMQTypeBase.isCreateManDirty() && (bl || pSMQTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMQTypeBase.getCreateMan());
        }
        if (pSMQTypeBase.isInstallPathDirty() && (bl || pSMQTypeBase.getInstallPath() != null)) {
            iDataObject.set(FIELD_INSTALLPATH, (Object)pSMQTypeBase.getInstallPath());
        }
        if (pSMQTypeBase.isMemoDirty() && (bl || pSMQTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSMQTypeBase.getMemo());
        }
        if (pSMQTypeBase.isPSMQTypeIdDirty() && (bl || pSMQTypeBase.getPSMQTypeId() != null)) {
            iDataObject.set(FIELD_PSMQTYPEID, (Object)pSMQTypeBase.getPSMQTypeId());
        }
        if (pSMQTypeBase.isPSMQTypeNameDirty() && (bl || pSMQTypeBase.getPSMQTypeName() != null)) {
            iDataObject.set(FIELD_PSMQTYPENAME, (Object)pSMQTypeBase.getPSMQTypeName());
        }
        if (pSMQTypeBase.isTypeHelperDirty() && (bl || pSMQTypeBase.getTypeHelper() != null)) {
            iDataObject.set(FIELD_TYPEHELPER, (Object)pSMQTypeBase.getTypeHelper());
        }
        if (pSMQTypeBase.isUpdateDateDirty() && (bl || pSMQTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMQTypeBase.getUpdateDate());
        }
        if (pSMQTypeBase.isUpdateManDirty() && (bl || pSMQTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMQTypeBase.getUpdateMan());
        }
        if (pSMQTypeBase.isValidFlagDirty() && (bl || pSMQTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSMQTypeBase.getValidFlag());
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
        return PSMQTypeBase.remove(this, n);
    }

    private static boolean remove(PSMQTypeBase pSMQTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMQTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMQTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMQTypeBase.resetInstallPath();
                return true;
            }
            case 3: {
                pSMQTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSMQTypeBase.resetPSMQTypeId();
                return true;
            }
            case 5: {
                pSMQTypeBase.resetPSMQTypeName();
                return true;
            }
            case 6: {
                pSMQTypeBase.resetTypeHelper();
                return true;
            }
            case 7: {
                pSMQTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSMQTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSMQTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSMQTypeBase getProxyEntity() {
        return this.proxyPSMQTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMQTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSMQTypeBase) {
            this.proxyPSMQTypeBase = (PSMQTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSMQTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_INSTALLPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSMQTYPEID, 4);
        fieldIndexMap.put(FIELD_PSMQTYPENAME, 5);
        fieldIndexMap.put(FIELD_TYPEHELPER, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

