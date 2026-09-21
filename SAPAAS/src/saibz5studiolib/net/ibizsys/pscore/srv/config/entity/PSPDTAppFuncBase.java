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

public abstract class PSPDTAppFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPDTAppFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPDTAPPFUNCID = "PSPDTAPPFUNCID";
    public static final String FIELD_PSPDTAPPFUNCNAME = "PSPDTAPPFUNCNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSPDTAPPFUNCID = 3;
    private static final int INDEX_PSPDTAPPFUNCNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPDTAppFuncBase proxyPSPDTAppFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspdtappfuncidDirtyFlag = false;
    private boolean pspdtappfuncnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspdtappfuncid")
    private String pspdtappfuncid;
    @Column(name="pspdtappfuncname")
    private String pspdtappfuncname;
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

    public void setPSPDTAppFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTAppFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtappfuncid = string;
        this.pspdtappfuncidDirtyFlag = true;
    }

    public String getPSPDTAppFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTAppFuncId();
        }
        return this.pspdtappfuncid;
    }

    public boolean isPSPDTAppFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTAppFuncIdDirty();
        }
        return this.pspdtappfuncidDirtyFlag;
    }

    public void resetPSPDTAppFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTAppFuncId();
            return;
        }
        this.pspdtappfuncidDirtyFlag = false;
        this.pspdtappfuncid = null;
    }

    public void setPSPDTAppFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPDTAppFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspdtappfuncname = string;
        this.pspdtappfuncnameDirtyFlag = true;
    }

    public String getPSPDTAppFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPDTAppFuncName();
        }
        return this.pspdtappfuncname;
    }

    public boolean isPSPDTAppFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPDTAppFuncNameDirty();
        }
        return this.pspdtappfuncnameDirtyFlag;
    }

    public void resetPSPDTAppFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPDTAppFuncName();
            return;
        }
        this.pspdtappfuncnameDirtyFlag = false;
        this.pspdtappfuncname = null;
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
        PSPDTAppFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPDTAppFuncBase pSPDTAppFuncBase) {
        pSPDTAppFuncBase.resetCreateDate();
        pSPDTAppFuncBase.resetCreateMan();
        pSPDTAppFuncBase.resetMemo();
        pSPDTAppFuncBase.resetPSPDTAppFuncId();
        pSPDTAppFuncBase.resetPSPDTAppFuncName();
        pSPDTAppFuncBase.resetUpdateDate();
        pSPDTAppFuncBase.resetUpdateMan();
        pSPDTAppFuncBase.resetValidFlag();
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
        if (!bl || this.isPSPDTAppFuncIdDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCID, this.getPSPDTAppFuncId());
        }
        if (!bl || this.isPSPDTAppFuncNameDirty()) {
            hashMap.put(FIELD_PSPDTAPPFUNCNAME, this.getPSPDTAppFuncName());
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
        return PSPDTAppFuncBase.get(this, n);
    }

    private static Object get(PSPDTAppFuncBase pSPDTAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTAppFuncBase.getCreateDate();
            }
            case 1: {
                return pSPDTAppFuncBase.getCreateMan();
            }
            case 2: {
                return pSPDTAppFuncBase.getMemo();
            }
            case 3: {
                return pSPDTAppFuncBase.getPSPDTAppFuncId();
            }
            case 4: {
                return pSPDTAppFuncBase.getPSPDTAppFuncName();
            }
            case 5: {
                return pSPDTAppFuncBase.getUpdateDate();
            }
            case 6: {
                return pSPDTAppFuncBase.getUpdateMan();
            }
            case 7: {
                return pSPDTAppFuncBase.getValidFlag();
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
        PSPDTAppFuncBase.set(this, n, object);
    }

    private static void set(PSPDTAppFuncBase pSPDTAppFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPDTAppFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPDTAppFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPDTAppFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPDTAppFuncBase.setPSPDTAppFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPDTAppFuncBase.setPSPDTAppFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPDTAppFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSPDTAppFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPDTAppFuncBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPDTAppFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSPDTAppFuncBase pSPDTAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTAppFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSPDTAppFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSPDTAppFuncBase.getMemo() == null;
            }
            case 3: {
                return pSPDTAppFuncBase.getPSPDTAppFuncId() == null;
            }
            case 4: {
                return pSPDTAppFuncBase.getPSPDTAppFuncName() == null;
            }
            case 5: {
                return pSPDTAppFuncBase.getUpdateDate() == null;
            }
            case 6: {
                return pSPDTAppFuncBase.getUpdateMan() == null;
            }
            case 7: {
                return pSPDTAppFuncBase.getValidFlag() == null;
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
        return PSPDTAppFuncBase.contains(this, n);
    }

    private static boolean contains(PSPDTAppFuncBase pSPDTAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPDTAppFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSPDTAppFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSPDTAppFuncBase.isMemoDirty();
            }
            case 3: {
                return pSPDTAppFuncBase.isPSPDTAppFuncIdDirty();
            }
            case 4: {
                return pSPDTAppFuncBase.isPSPDTAppFuncNameDirty();
            }
            case 5: {
                return pSPDTAppFuncBase.isUpdateDateDirty();
            }
            case 6: {
                return pSPDTAppFuncBase.isUpdateManDirty();
            }
            case 7: {
                return pSPDTAppFuncBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPDTAppFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPDTAppFuncBase pSPDTAppFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPDTAppFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getPSPDTAppFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncid", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getPSPDTAppFuncId()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getPSPDTAppFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspdtappfuncname", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getPSPDTAppFuncName()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPDTAppFuncBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPDTAppFuncBase.getJSONValue((Object)pSPDTAppFuncBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPDTAppFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPDTAppFuncBase pSPDTAppFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPDTAppFuncBase.getCreateDate() != null) {
            object = pSPDTAppFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPDTAppFuncBase.getCreateMan() != null) {
            object = pSPDTAppFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPDTAppFuncBase.getMemo() != null) {
            object = pSPDTAppFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPDTAppFuncBase.getPSPDTAppFuncId() != null) {
            object = pSPDTAppFuncBase.getPSPDTAppFuncId();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSPDTAppFuncBase.getPSPDTAppFuncName() != null) {
            object = pSPDTAppFuncBase.getPSPDTAppFuncName();
            xmlNode.setAttribute(FIELD_PSPDTAPPFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPDTAppFuncBase.getUpdateDate() != null) {
            object = pSPDTAppFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPDTAppFuncBase.getUpdateMan() != null) {
            object = pSPDTAppFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPDTAppFuncBase.getValidFlag() != null) {
            object = pSPDTAppFuncBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPDTAppFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPDTAppFuncBase pSPDTAppFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPDTAppFuncBase.isCreateDateDirty() && (bl || pSPDTAppFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPDTAppFuncBase.getCreateDate());
        }
        if (pSPDTAppFuncBase.isCreateManDirty() && (bl || pSPDTAppFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPDTAppFuncBase.getCreateMan());
        }
        if (pSPDTAppFuncBase.isMemoDirty() && (bl || pSPDTAppFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPDTAppFuncBase.getMemo());
        }
        if (pSPDTAppFuncBase.isPSPDTAppFuncIdDirty() && (bl || pSPDTAppFuncBase.getPSPDTAppFuncId() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCID, (Object)pSPDTAppFuncBase.getPSPDTAppFuncId());
        }
        if (pSPDTAppFuncBase.isPSPDTAppFuncNameDirty() && (bl || pSPDTAppFuncBase.getPSPDTAppFuncName() != null)) {
            iDataObject.set(FIELD_PSPDTAPPFUNCNAME, (Object)pSPDTAppFuncBase.getPSPDTAppFuncName());
        }
        if (pSPDTAppFuncBase.isUpdateDateDirty() && (bl || pSPDTAppFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPDTAppFuncBase.getUpdateDate());
        }
        if (pSPDTAppFuncBase.isUpdateManDirty() && (bl || pSPDTAppFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPDTAppFuncBase.getUpdateMan());
        }
        if (pSPDTAppFuncBase.isValidFlagDirty() && (bl || pSPDTAppFuncBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPDTAppFuncBase.getValidFlag());
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
        return PSPDTAppFuncBase.remove(this, n);
    }

    private static boolean remove(PSPDTAppFuncBase pSPDTAppFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPDTAppFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPDTAppFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPDTAppFuncBase.resetMemo();
                return true;
            }
            case 3: {
                pSPDTAppFuncBase.resetPSPDTAppFuncId();
                return true;
            }
            case 4: {
                pSPDTAppFuncBase.resetPSPDTAppFuncName();
                return true;
            }
            case 5: {
                pSPDTAppFuncBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSPDTAppFuncBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSPDTAppFuncBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPDTAppFuncBase getProxyEntity() {
        return this.proxyPSPDTAppFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPDTAppFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSPDTAppFuncBase) {
            this.proxyPSPDTAppFuncBase = (PSPDTAppFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPDTAppFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCID, 3);
        fieldIndexMap.put(FIELD_PSPDTAPPFUNCNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

