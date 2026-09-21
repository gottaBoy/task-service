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

public abstract class PSProductTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSProductTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPRODUCTTYPEID = "PSPRODUCTTYPEID";
    public static final String FIELD_PSPRODUCTTYPENAME = "PSPRODUCTTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPRODUCTTYPEID = 4;
    private static final int INDEX_PSPRODUCTTYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSProductTypeBase proxyPSProductTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psproducttypeidDirtyFlag = false;
    private boolean psproducttypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="memo")
    private String memo;
    @Column(name="psproducttypeid")
    private String psproducttypeid;
    @Column(name="psproducttypename")
    private String psproducttypename;
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

    public void setPSProductTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSProductTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psproducttypeid = string;
        this.psproducttypeidDirtyFlag = true;
    }

    public String getPSProductTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSProductTypeId();
        }
        return this.psproducttypeid;
    }

    public boolean isPSProductTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSProductTypeIdDirty();
        }
        return this.psproducttypeidDirtyFlag;
    }

    public void resetPSProductTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSProductTypeId();
            return;
        }
        this.psproducttypeidDirtyFlag = false;
        this.psproducttypeid = null;
    }

    public void setPSProductTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSProductTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psproducttypename = string;
        this.psproducttypenameDirtyFlag = true;
    }

    public String getPSProductTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSProductTypeName();
        }
        return this.psproducttypename;
    }

    public boolean isPSProductTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSProductTypeNameDirty();
        }
        return this.psproducttypenameDirtyFlag;
    }

    public void resetPSProductTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSProductTypeName();
            return;
        }
        this.psproducttypenameDirtyFlag = false;
        this.psproducttypename = null;
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
        PSProductTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSProductTypeBase pSProductTypeBase) {
        pSProductTypeBase.resetCreateDate();
        pSProductTypeBase.resetCreateMan();
        pSProductTypeBase.resetIconPath();
        pSProductTypeBase.resetMemo();
        pSProductTypeBase.resetPSProductTypeId();
        pSProductTypeBase.resetPSProductTypeName();
        pSProductTypeBase.resetUpdateDate();
        pSProductTypeBase.resetUpdateMan();
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
        if (!bl || this.isPSProductTypeIdDirty()) {
            hashMap.put(FIELD_PSPRODUCTTYPEID, this.getPSProductTypeId());
        }
        if (!bl || this.isPSProductTypeNameDirty()) {
            hashMap.put(FIELD_PSPRODUCTTYPENAME, this.getPSProductTypeName());
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
        return PSProductTypeBase.get(this, n);
    }

    private static Object get(PSProductTypeBase pSProductTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductTypeBase.getCreateDate();
            }
            case 1: {
                return pSProductTypeBase.getCreateMan();
            }
            case 2: {
                return pSProductTypeBase.getIconPath();
            }
            case 3: {
                return pSProductTypeBase.getMemo();
            }
            case 4: {
                return pSProductTypeBase.getPSProductTypeId();
            }
            case 5: {
                return pSProductTypeBase.getPSProductTypeName();
            }
            case 6: {
                return pSProductTypeBase.getUpdateDate();
            }
            case 7: {
                return pSProductTypeBase.getUpdateMan();
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
        PSProductTypeBase.set(this, n, object);
    }

    private static void set(PSProductTypeBase pSProductTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSProductTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSProductTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSProductTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSProductTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSProductTypeBase.setPSProductTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSProductTypeBase.setPSProductTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSProductTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSProductTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSProductTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSProductTypeBase pSProductTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSProductTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSProductTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSProductTypeBase.getMemo() == null;
            }
            case 4: {
                return pSProductTypeBase.getPSProductTypeId() == null;
            }
            case 5: {
                return pSProductTypeBase.getPSProductTypeName() == null;
            }
            case 6: {
                return pSProductTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSProductTypeBase.getUpdateMan() == null;
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
        return PSProductTypeBase.contains(this, n);
    }

    private static boolean contains(PSProductTypeBase pSProductTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSProductTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSProductTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSProductTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSProductTypeBase.isMemoDirty();
            }
            case 4: {
                return pSProductTypeBase.isPSProductTypeIdDirty();
            }
            case 5: {
                return pSProductTypeBase.isPSProductTypeNameDirty();
            }
            case 6: {
                return pSProductTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSProductTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSProductTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSProductTypeBase pSProductTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSProductTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getPSProductTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psproducttypeid", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getPSProductTypeId()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getPSProductTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psproducttypename", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getPSProductTypeName()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSProductTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSProductTypeBase.getJSONValue((Object)pSProductTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSProductTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSProductTypeBase pSProductTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSProductTypeBase.getCreateDate() != null) {
            object = pSProductTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSProductTypeBase.getCreateMan() != null) {
            object = pSProductTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSProductTypeBase.getIconPath() != null) {
            object = pSProductTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSProductTypeBase.getMemo() != null) {
            object = pSProductTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSProductTypeBase.getPSProductTypeId() != null) {
            object = pSProductTypeBase.getPSProductTypeId();
            xmlNode.setAttribute(FIELD_PSPRODUCTTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSProductTypeBase.getPSProductTypeName() != null) {
            object = pSProductTypeBase.getPSProductTypeName();
            xmlNode.setAttribute(FIELD_PSPRODUCTTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSProductTypeBase.getUpdateDate() != null) {
            object = pSProductTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSProductTypeBase.getUpdateMan() != null) {
            object = pSProductTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSProductTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSProductTypeBase pSProductTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSProductTypeBase.isCreateDateDirty() && (bl || pSProductTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSProductTypeBase.getCreateDate());
        }
        if (pSProductTypeBase.isCreateManDirty() && (bl || pSProductTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSProductTypeBase.getCreateMan());
        }
        if (pSProductTypeBase.isIconPathDirty() && (bl || pSProductTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSProductTypeBase.getIconPath());
        }
        if (pSProductTypeBase.isMemoDirty() && (bl || pSProductTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSProductTypeBase.getMemo());
        }
        if (pSProductTypeBase.isPSProductTypeIdDirty() && (bl || pSProductTypeBase.getPSProductTypeId() != null)) {
            iDataObject.set(FIELD_PSPRODUCTTYPEID, (Object)pSProductTypeBase.getPSProductTypeId());
        }
        if (pSProductTypeBase.isPSProductTypeNameDirty() && (bl || pSProductTypeBase.getPSProductTypeName() != null)) {
            iDataObject.set(FIELD_PSPRODUCTTYPENAME, (Object)pSProductTypeBase.getPSProductTypeName());
        }
        if (pSProductTypeBase.isUpdateDateDirty() && (bl || pSProductTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSProductTypeBase.getUpdateDate());
        }
        if (pSProductTypeBase.isUpdateManDirty() && (bl || pSProductTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSProductTypeBase.getUpdateMan());
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
        return PSProductTypeBase.remove(this, n);
    }

    private static boolean remove(PSProductTypeBase pSProductTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSProductTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSProductTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSProductTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSProductTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSProductTypeBase.resetPSProductTypeId();
                return true;
            }
            case 5: {
                pSProductTypeBase.resetPSProductTypeName();
                return true;
            }
            case 6: {
                pSProductTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSProductTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSProductTypeBase getProxyEntity() {
        return this.proxyPSProductTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSProductTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSProductTypeBase) {
            this.proxyPSProductTypeBase = (PSProductTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSProductTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPRODUCTTYPEID, 4);
        fieldIndexMap.put(FIELD_PSPRODUCTTYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

