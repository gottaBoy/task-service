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

public abstract class PSAppTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MOBILEMODE = "MOBILEMODE";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ICONPATH = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MOBILEMODE = 4;
    private static final int INDEX_PSAPPTYPEID = 5;
    private static final int INDEX_PSAPPTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppTypeBase proxyPSAppTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean mobilemodeDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
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
    @Column(name="mobilemode")
    private Integer mobilemode;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
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

    public void setMobileMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMobileMode(n);
            return;
        }
        this.mobilemode = n;
        this.mobilemodeDirtyFlag = true;
    }

    public Integer getMobileMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMobileMode();
        }
        return this.mobilemode;
    }

    public boolean isMobileModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMobileModeDirty();
        }
        return this.mobilemodeDirtyFlag;
    }

    public void resetMobileMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMobileMode();
            return;
        }
        this.mobilemodeDirtyFlag = false;
        this.mobilemode = null;
    }

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
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
        PSAppTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppTypeBase pSAppTypeBase) {
        pSAppTypeBase.resetCreateDate();
        pSAppTypeBase.resetCreateMan();
        pSAppTypeBase.resetIconPath();
        pSAppTypeBase.resetMemo();
        pSAppTypeBase.resetMobileMode();
        pSAppTypeBase.resetPSAppTypeId();
        pSAppTypeBase.resetPSAppTypeName();
        pSAppTypeBase.resetUpdateDate();
        pSAppTypeBase.resetUpdateMan();
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
        if (!bl || this.isMobileModeDirty()) {
            hashMap.put(FIELD_MOBILEMODE, this.getMobileMode());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
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
        return PSAppTypeBase.get(this, n);
    }

    private static Object get(PSAppTypeBase pSAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTypeBase.getCreateDate();
            }
            case 1: {
                return pSAppTypeBase.getCreateMan();
            }
            case 2: {
                return pSAppTypeBase.getIconPath();
            }
            case 3: {
                return pSAppTypeBase.getMemo();
            }
            case 4: {
                return pSAppTypeBase.getMobileMode();
            }
            case 5: {
                return pSAppTypeBase.getPSAppTypeId();
            }
            case 6: {
                return pSAppTypeBase.getPSAppTypeName();
            }
            case 7: {
                return pSAppTypeBase.getUpdateDate();
            }
            case 8: {
                return pSAppTypeBase.getUpdateMan();
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
        PSAppTypeBase.set(this, n, object);
    }

    private static void set(PSAppTypeBase pSAppTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppTypeBase.setMobileMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSAppTypeBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppTypeBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppTypeBase pSAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppTypeBase.getIconPath() == null;
            }
            case 3: {
                return pSAppTypeBase.getMemo() == null;
            }
            case 4: {
                return pSAppTypeBase.getMobileMode() == null;
            }
            case 5: {
                return pSAppTypeBase.getPSAppTypeId() == null;
            }
            case 6: {
                return pSAppTypeBase.getPSAppTypeName() == null;
            }
            case 7: {
                return pSAppTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSAppTypeBase.getUpdateMan() == null;
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
        return PSAppTypeBase.contains(this, n);
    }

    private static boolean contains(PSAppTypeBase pSAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSAppTypeBase.isIconPathDirty();
            }
            case 3: {
                return pSAppTypeBase.isMemoDirty();
            }
            case 4: {
                return pSAppTypeBase.isMobileModeDirty();
            }
            case 5: {
                return pSAppTypeBase.isPSAppTypeIdDirty();
            }
            case 6: {
                return pSAppTypeBase.isPSAppTypeNameDirty();
            }
            case 7: {
                return pSAppTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSAppTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppTypeBase pSAppTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getMobileMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mobilemode", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getMobileMode()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppTypeBase.getJSONValue((Object)pSAppTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppTypeBase pSAppTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppTypeBase.getCreateDate() != null) {
            object = pSAppTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppTypeBase.getCreateMan() != null) {
            object = pSAppTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppTypeBase.getIconPath() != null) {
            object = pSAppTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSAppTypeBase.getMemo() != null) {
            object = pSAppTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppTypeBase.getMobileMode() != null) {
            object = pSAppTypeBase.getMobileMode();
            xmlNode.setAttribute(FIELD_MOBILEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppTypeBase.getPSAppTypeId() != null) {
            object = pSAppTypeBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppTypeBase.getPSAppTypeName() != null) {
            object = pSAppTypeBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppTypeBase.getUpdateDate() != null) {
            object = pSAppTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppTypeBase.getUpdateMan() != null) {
            object = pSAppTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppTypeBase pSAppTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppTypeBase.isCreateDateDirty() && (bl || pSAppTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppTypeBase.getCreateDate());
        }
        if (pSAppTypeBase.isCreateManDirty() && (bl || pSAppTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppTypeBase.getCreateMan());
        }
        if (pSAppTypeBase.isIconPathDirty() && (bl || pSAppTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSAppTypeBase.getIconPath());
        }
        if (pSAppTypeBase.isMemoDirty() && (bl || pSAppTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppTypeBase.getMemo());
        }
        if (pSAppTypeBase.isMobileModeDirty() && (bl || pSAppTypeBase.getMobileMode() != null)) {
            iDataObject.set(FIELD_MOBILEMODE, (Object)pSAppTypeBase.getMobileMode());
        }
        if (pSAppTypeBase.isPSAppTypeIdDirty() && (bl || pSAppTypeBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSAppTypeBase.getPSAppTypeId());
        }
        if (pSAppTypeBase.isPSAppTypeNameDirty() && (bl || pSAppTypeBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSAppTypeBase.getPSAppTypeName());
        }
        if (pSAppTypeBase.isUpdateDateDirty() && (bl || pSAppTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppTypeBase.getUpdateDate());
        }
        if (pSAppTypeBase.isUpdateManDirty() && (bl || pSAppTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppTypeBase.getUpdateMan());
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
        return PSAppTypeBase.remove(this, n);
    }

    private static boolean remove(PSAppTypeBase pSAppTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppTypeBase.resetIconPath();
                return true;
            }
            case 3: {
                pSAppTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppTypeBase.resetMobileMode();
                return true;
            }
            case 5: {
                pSAppTypeBase.resetPSAppTypeId();
                return true;
            }
            case 6: {
                pSAppTypeBase.resetPSAppTypeName();
                return true;
            }
            case 7: {
                pSAppTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSAppTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppTypeBase getProxyEntity() {
        return this.proxyPSAppTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppTypeBase) {
            this.proxyPSAppTypeBase = (PSAppTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ICONPATH, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MOBILEMODE, 4);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 5);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

