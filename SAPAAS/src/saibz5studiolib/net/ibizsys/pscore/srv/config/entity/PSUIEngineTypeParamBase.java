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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSUIEngineType;
import net.ibizsys.pscore.srv.config.service.PSUIEngineTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUIEngineTypeParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUIEngineTypeParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSUIENGINETYPEID = "PSUIENGINETYPEID";
    public static final String FIELD_PSUIENGINETYPENAME = "PSUIENGINETYPENAME";
    public static final String FIELD_PSUIENGINETYPEPARAMID = "PSUIENGINETYPEPARAMID";
    public static final String FIELD_PSUIENGINETYPEPARAMNAME = "PSUIENGINETYPEPARAMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSUIENGINETYPEID = 2;
    private static final int INDEX_PSUIENGINETYPENAME = 3;
    private static final int INDEX_PSUIENGINETYPEPARAMID = 4;
    private static final int INDEX_PSUIENGINETYPEPARAMNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUIEngineTypeParamBase proxyPSUIEngineTypeParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psuienginetypeidDirtyFlag = false;
    private boolean psuienginetypenameDirtyFlag = false;
    private boolean psuienginetypeparamidDirtyFlag = false;
    private boolean psuienginetypeparamnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psuienginetypeid")
    private String psuienginetypeid;
    @Column(name="psuienginetypename")
    private String psuienginetypename;
    @Column(name="psuienginetypeparamid")
    private String psuienginetypeparamid;
    @Column(name="psuienginetypeparamname")
    private String psuienginetypeparamname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSUIEngineTypeLock = new Integer(1);
    private PSUIEngineType psuienginetype = null;

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

    public void setPSUIEngineTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypeid = string;
        this.psuienginetypeidDirtyFlag = true;
    }

    public String getPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeId();
        }
        return this.psuienginetypeid;
    }

    public boolean isPSUIEngineTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeIdDirty();
        }
        return this.psuienginetypeidDirtyFlag;
    }

    public void resetPSUIEngineTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeId();
            return;
        }
        this.psuienginetypeidDirtyFlag = false;
        this.psuienginetypeid = null;
    }

    public void setPSUIEngineTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypename = string;
        this.psuienginetypenameDirtyFlag = true;
    }

    public String getPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeName();
        }
        return this.psuienginetypename;
    }

    public boolean isPSUIEngineTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeNameDirty();
        }
        return this.psuienginetypenameDirtyFlag;
    }

    public void resetPSUIEngineTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeName();
            return;
        }
        this.psuienginetypenameDirtyFlag = false;
        this.psuienginetypename = null;
    }

    public void setPSUIEngineTypeParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypeparamid = string;
        this.psuienginetypeparamidDirtyFlag = true;
    }

    public String getPSUIEngineTypeParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeParamId();
        }
        return this.psuienginetypeparamid;
    }

    public boolean isPSUIEngineTypeParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeParamIdDirty();
        }
        return this.psuienginetypeparamidDirtyFlag;
    }

    public void resetPSUIEngineTypeParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeParamId();
            return;
        }
        this.psuienginetypeparamidDirtyFlag = false;
        this.psuienginetypeparamid = null;
    }

    public void setPSUIEngineTypeParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUIEngineTypeParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuienginetypeparamname = string;
        this.psuienginetypeparamnameDirtyFlag = true;
    }

    public String getPSUIEngineTypeParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineTypeParamName();
        }
        return this.psuienginetypeparamname;
    }

    public boolean isPSUIEngineTypeParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUIEngineTypeParamNameDirty();
        }
        return this.psuienginetypeparamnameDirtyFlag;
    }

    public void resetPSUIEngineTypeParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUIEngineTypeParamName();
            return;
        }
        this.psuienginetypeparamnameDirtyFlag = false;
        this.psuienginetypeparamname = null;
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
        PSUIEngineTypeParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUIEngineTypeParamBase pSUIEngineTypeParamBase) {
        pSUIEngineTypeParamBase.resetCreateDate();
        pSUIEngineTypeParamBase.resetCreateMan();
        pSUIEngineTypeParamBase.resetPSUIEngineTypeId();
        pSUIEngineTypeParamBase.resetPSUIEngineTypeName();
        pSUIEngineTypeParamBase.resetPSUIEngineTypeParamId();
        pSUIEngineTypeParamBase.resetPSUIEngineTypeParamName();
        pSUIEngineTypeParamBase.resetUpdateDate();
        pSUIEngineTypeParamBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSUIEngineTypeIdDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPEID, this.getPSUIEngineTypeId());
        }
        if (!bl || this.isPSUIEngineTypeNameDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPENAME, this.getPSUIEngineTypeName());
        }
        if (!bl || this.isPSUIEngineTypeParamIdDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPEPARAMID, this.getPSUIEngineTypeParamId());
        }
        if (!bl || this.isPSUIEngineTypeParamNameDirty()) {
            hashMap.put(FIELD_PSUIENGINETYPEPARAMNAME, this.getPSUIEngineTypeParamName());
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
        return PSUIEngineTypeParamBase.get(this, n);
    }

    private static Object get(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeParamBase.getCreateDate();
            }
            case 1: {
                return pSUIEngineTypeParamBase.getCreateMan();
            }
            case 2: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeId();
            }
            case 3: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeName();
            }
            case 4: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeParamId();
            }
            case 5: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeParamName();
            }
            case 6: {
                return pSUIEngineTypeParamBase.getUpdateDate();
            }
            case 7: {
                return pSUIEngineTypeParamBase.getUpdateMan();
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
        PSUIEngineTypeParamBase.set(this, n, object);
    }

    private static void set(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUIEngineTypeParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUIEngineTypeParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUIEngineTypeParamBase.setPSUIEngineTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUIEngineTypeParamBase.setPSUIEngineTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUIEngineTypeParamBase.setPSUIEngineTypeParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUIEngineTypeParamBase.setPSUIEngineTypeParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUIEngineTypeParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSUIEngineTypeParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUIEngineTypeParamBase.isNull(this, n);
    }

    private static boolean isNull(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSUIEngineTypeParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeId() == null;
            }
            case 3: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeName() == null;
            }
            case 4: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeParamId() == null;
            }
            case 5: {
                return pSUIEngineTypeParamBase.getPSUIEngineTypeParamName() == null;
            }
            case 6: {
                return pSUIEngineTypeParamBase.getUpdateDate() == null;
            }
            case 7: {
                return pSUIEngineTypeParamBase.getUpdateMan() == null;
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
        return PSUIEngineTypeParamBase.contains(this, n);
    }

    private static boolean contains(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUIEngineTypeParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSUIEngineTypeParamBase.isCreateManDirty();
            }
            case 2: {
                return pSUIEngineTypeParamBase.isPSUIEngineTypeIdDirty();
            }
            case 3: {
                return pSUIEngineTypeParamBase.isPSUIEngineTypeNameDirty();
            }
            case 4: {
                return pSUIEngineTypeParamBase.isPSUIEngineTypeParamIdDirty();
            }
            case 5: {
                return pSUIEngineTypeParamBase.isPSUIEngineTypeParamNameDirty();
            }
            case 6: {
                return pSUIEngineTypeParamBase.isUpdateDateDirty();
            }
            case 7: {
                return pSUIEngineTypeParamBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUIEngineTypeParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUIEngineTypeParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeid", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getPSUIEngineTypeId()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypename", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getPSUIEngineTypeName()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeparamid", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getPSUIEngineTypeParamId()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuienginetypeparamname", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getPSUIEngineTypeParamName()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUIEngineTypeParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUIEngineTypeParamBase.getJSONValue((Object)pSUIEngineTypeParamBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUIEngineTypeParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUIEngineTypeParamBase.getCreateDate() != null) {
            object = pSUIEngineTypeParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUIEngineTypeParamBase.getCreateMan() != null) {
            object = pSUIEngineTypeParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeId() != null) {
            object = pSUIEngineTypeParamBase.getPSUIEngineTypeId();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeName() != null) {
            object = pSUIEngineTypeParamBase.getPSUIEngineTypeName();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamId() != null) {
            object = pSUIEngineTypeParamBase.getPSUIEngineTypeParamId();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamName() != null) {
            object = pSUIEngineTypeParamBase.getPSUIEngineTypeParamName();
            xmlNode.setAttribute(FIELD_PSUIENGINETYPEPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUIEngineTypeParamBase.getUpdateDate() != null) {
            object = pSUIEngineTypeParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUIEngineTypeParamBase.getUpdateMan() != null) {
            object = pSUIEngineTypeParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUIEngineTypeParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUIEngineTypeParamBase.isCreateDateDirty() && (bl || pSUIEngineTypeParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUIEngineTypeParamBase.getCreateDate());
        }
        if (pSUIEngineTypeParamBase.isCreateManDirty() && (bl || pSUIEngineTypeParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUIEngineTypeParamBase.getCreateMan());
        }
        if (pSUIEngineTypeParamBase.isPSUIEngineTypeIdDirty() && (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeId() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEID, (Object)pSUIEngineTypeParamBase.getPSUIEngineTypeId());
        }
        if (pSUIEngineTypeParamBase.isPSUIEngineTypeNameDirty() && (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeName() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPENAME, (Object)pSUIEngineTypeParamBase.getPSUIEngineTypeName());
        }
        if (pSUIEngineTypeParamBase.isPSUIEngineTypeParamIdDirty() && (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamId() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEPARAMID, (Object)pSUIEngineTypeParamBase.getPSUIEngineTypeParamId());
        }
        if (pSUIEngineTypeParamBase.isPSUIEngineTypeParamNameDirty() && (bl || pSUIEngineTypeParamBase.getPSUIEngineTypeParamName() != null)) {
            iDataObject.set(FIELD_PSUIENGINETYPEPARAMNAME, (Object)pSUIEngineTypeParamBase.getPSUIEngineTypeParamName());
        }
        if (pSUIEngineTypeParamBase.isUpdateDateDirty() && (bl || pSUIEngineTypeParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUIEngineTypeParamBase.getUpdateDate());
        }
        if (pSUIEngineTypeParamBase.isUpdateManDirty() && (bl || pSUIEngineTypeParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUIEngineTypeParamBase.getUpdateMan());
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
        return PSUIEngineTypeParamBase.remove(this, n);
    }

    private static boolean remove(PSUIEngineTypeParamBase pSUIEngineTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUIEngineTypeParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUIEngineTypeParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUIEngineTypeParamBase.resetPSUIEngineTypeId();
                return true;
            }
            case 3: {
                pSUIEngineTypeParamBase.resetPSUIEngineTypeName();
                return true;
            }
            case 4: {
                pSUIEngineTypeParamBase.resetPSUIEngineTypeParamId();
                return true;
            }
            case 5: {
                pSUIEngineTypeParamBase.resetPSUIEngineTypeParamName();
                return true;
            }
            case 6: {
                pSUIEngineTypeParamBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSUIEngineTypeParamBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSUIEngineType getPSUIEngineType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUIEngineType();
        }
        if (this.getPSUIEngineTypeId() == null) {
            return null;
        }
        Integer n = this.objPSUIEngineTypeLock;
        synchronized (n) {
            if (this.psuienginetype != null && DataTypeHelper.compare((int)25, (Object)this.getPSUIEngineTypeId(), (Object)this.psuienginetype.getPSUIEngineTypeId()) != 0L) {
                this.psuienginetype = null;
            }
            if (this.psuienginetype == null) {
                PSUIEngineType pSUIEngineType = new PSUIEngineType();
                pSUIEngineType.setPSUIEngineTypeId(this.getPSUIEngineTypeId());
                PSUIEngineTypeService pSUIEngineTypeService = (PSUIEngineTypeService)ServiceGlobal.getService(PSUIEngineTypeService.class, (SessionFactory)this.getSessionFactory());
                pSUIEngineTypeService.autoGet((IEntity)pSUIEngineType);
                this.psuienginetype = pSUIEngineType;
            }
            return this.psuienginetype;
        }
    }

    private PSUIEngineTypeParamBase getProxyEntity() {
        return this.proxyPSUIEngineTypeParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUIEngineTypeParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSUIEngineTypeParamBase) {
            this.proxyPSUIEngineTypeParamBase = (PSUIEngineTypeParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSUIEngineTypeParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSUIENGINETYPEID, 2);
        fieldIndexMap.put(FIELD_PSUIENGINETYPENAME, 3);
        fieldIndexMap.put(FIELD_PSUIENGINETYPEPARAMID, 4);
        fieldIndexMap.put(FIELD_PSUIENGINETYPEPARAMNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

