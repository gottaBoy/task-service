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
package net.ibizsys.pscore.srv.unisys.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.unisys.entity.PSUSModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSModuleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSUSMODULEID = "PSUSMODULEID";
    public static final String FIELD_PSUSMODULENAME = "PSUSMODULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSUSMODULEID = 3;
    private static final int INDEX_PSUSMODULENAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSModuleBase proxyPSUSModuleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psusmoduleidDirtyFlag = false;
    private boolean psusmodulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psusmoduleid")
    private String psusmoduleid;
    @Column(name="psusmodulename")
    private String psusmodulename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSUSModuleInstsLock = new Integer(1);
    private ArrayList<PSUSModuleInst> psusmoduleinsts = null;

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

    public void setPSUSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmoduleid = string;
        this.psusmoduleidDirtyFlag = true;
    }

    public String getPSUSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleId();
        }
        return this.psusmoduleid;
    }

    public boolean isPSUSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleIdDirty();
        }
        return this.psusmoduleidDirtyFlag;
    }

    public void resetPSUSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleId();
            return;
        }
        this.psusmoduleidDirtyFlag = false;
        this.psusmoduleid = null;
    }

    public void setPSUSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusmodulename = string;
        this.psusmodulenameDirtyFlag = true;
    }

    public String getPSUSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleName();
        }
        return this.psusmodulename;
    }

    public boolean isPSUSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSModuleNameDirty();
        }
        return this.psusmodulenameDirtyFlag;
    }

    public void resetPSUSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSModuleName();
            return;
        }
        this.psusmodulenameDirtyFlag = false;
        this.psusmodulename = null;
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
        PSUSModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSModuleBase pSUSModuleBase) {
        pSUSModuleBase.resetCreateDate();
        pSUSModuleBase.resetCreateMan();
        pSUSModuleBase.resetMemo();
        pSUSModuleBase.resetPSUSModuleId();
        pSUSModuleBase.resetPSUSModuleName();
        pSUSModuleBase.resetUpdateDate();
        pSUSModuleBase.resetUpdateMan();
        pSUSModuleBase.resetValidFlag();
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
        if (!bl || this.isPSUSModuleIdDirty()) {
            hashMap.put(FIELD_PSUSMODULEID, this.getPSUSModuleId());
        }
        if (!bl || this.isPSUSModuleNameDirty()) {
            hashMap.put(FIELD_PSUSMODULENAME, this.getPSUSModuleName());
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
        return PSUSModuleBase.get(this, n);
    }

    private static Object get(PSUSModuleBase pSUSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleBase.getCreateDate();
            }
            case 1: {
                return pSUSModuleBase.getCreateMan();
            }
            case 2: {
                return pSUSModuleBase.getMemo();
            }
            case 3: {
                return pSUSModuleBase.getPSUSModuleId();
            }
            case 4: {
                return pSUSModuleBase.getPSUSModuleName();
            }
            case 5: {
                return pSUSModuleBase.getUpdateDate();
            }
            case 6: {
                return pSUSModuleBase.getUpdateMan();
            }
            case 7: {
                return pSUSModuleBase.getValidFlag();
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
        PSUSModuleBase.set(this, n, object);
    }

    private static void set(PSUSModuleBase pSUSModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSModuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSModuleBase.setPSUSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSModuleBase.setPSUSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSUSModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUSModuleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUSModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSUSModuleBase pSUSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSModuleBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSModuleBase.getMemo() == null;
            }
            case 3: {
                return pSUSModuleBase.getPSUSModuleId() == null;
            }
            case 4: {
                return pSUSModuleBase.getPSUSModuleName() == null;
            }
            case 5: {
                return pSUSModuleBase.getUpdateDate() == null;
            }
            case 6: {
                return pSUSModuleBase.getUpdateMan() == null;
            }
            case 7: {
                return pSUSModuleBase.getValidFlag() == null;
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
        return PSUSModuleBase.contains(this, n);
    }

    private static boolean contains(PSUSModuleBase pSUSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSModuleBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSModuleBase.isCreateManDirty();
            }
            case 2: {
                return pSUSModuleBase.isMemoDirty();
            }
            case 3: {
                return pSUSModuleBase.isPSUSModuleIdDirty();
            }
            case 4: {
                return pSUSModuleBase.isPSUSModuleNameDirty();
            }
            case 5: {
                return pSUSModuleBase.isUpdateDateDirty();
            }
            case 6: {
                return pSUSModuleBase.isUpdateManDirty();
            }
            case 7: {
                return pSUSModuleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSModuleBase pSUSModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getPSUSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmoduleid", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getPSUSModuleId()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getPSUSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusmodulename", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getPSUSModuleName()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSModuleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUSModuleBase.getJSONValue((Object)pSUSModuleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSModuleBase pSUSModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSModuleBase.getCreateDate() != null) {
            object = pSUSModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleBase.getCreateMan() != null) {
            object = pSUSModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleBase.getMemo() != null) {
            object = pSUSModuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleBase.getPSUSModuleId() != null) {
            object = pSUSModuleBase.getPSUSModuleId();
            xmlNode.setAttribute(FIELD_PSUSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleBase.getPSUSModuleName() != null) {
            object = pSUSModuleBase.getPSUSModuleName();
            xmlNode.setAttribute(FIELD_PSUSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleBase.getUpdateDate() != null) {
            object = pSUSModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSModuleBase.getUpdateMan() != null) {
            object = pSUSModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSModuleBase.getValidFlag() != null) {
            object = pSUSModuleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSModuleBase pSUSModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSModuleBase.isCreateDateDirty() && (bl || pSUSModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSModuleBase.getCreateDate());
        }
        if (pSUSModuleBase.isCreateManDirty() && (bl || pSUSModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSModuleBase.getCreateMan());
        }
        if (pSUSModuleBase.isMemoDirty() && (bl || pSUSModuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSUSModuleBase.getMemo());
        }
        if (pSUSModuleBase.isPSUSModuleIdDirty() && (bl || pSUSModuleBase.getPSUSModuleId() != null)) {
            iDataObject.set(FIELD_PSUSMODULEID, (Object)pSUSModuleBase.getPSUSModuleId());
        }
        if (pSUSModuleBase.isPSUSModuleNameDirty() && (bl || pSUSModuleBase.getPSUSModuleName() != null)) {
            iDataObject.set(FIELD_PSUSMODULENAME, (Object)pSUSModuleBase.getPSUSModuleName());
        }
        if (pSUSModuleBase.isUpdateDateDirty() && (bl || pSUSModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSModuleBase.getUpdateDate());
        }
        if (pSUSModuleBase.isUpdateManDirty() && (bl || pSUSModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSModuleBase.getUpdateMan());
        }
        if (pSUSModuleBase.isValidFlagDirty() && (bl || pSUSModuleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUSModuleBase.getValidFlag());
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
        return PSUSModuleBase.remove(this, n);
    }

    private static boolean remove(PSUSModuleBase pSUSModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSModuleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSModuleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSModuleBase.resetMemo();
                return true;
            }
            case 3: {
                pSUSModuleBase.resetPSUSModuleId();
                return true;
            }
            case 4: {
                pSUSModuleBase.resetPSUSModuleName();
                return true;
            }
            case 5: {
                pSUSModuleBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSUSModuleBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSUSModuleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSModuleInst> getPSUSModuleInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSModuleInsts();
        }
        if (this.getPSUSModuleId() == null) {
            return null;
        }
        PSUSModuleInstService pSUSModuleInstService = (PSUSModuleInstService)ServiceGlobal.getService(PSUSModuleInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSModuleInstsLock;
        synchronized (n) {
            if (this.psusmoduleinsts == null) {
                this.psusmoduleinsts = pSUSModuleInstService.selectByPSUSModule(this);
            }
            return this.psusmoduleinsts;
        }
    }

    private PSUSModuleBase getProxyEntity() {
        return this.proxyPSUSModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSModuleBase) {
            this.proxyPSUSModuleBase = (PSUSModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSUSMODULEID, 3);
        fieldIndexMap.put(FIELD_PSUSMODULENAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

