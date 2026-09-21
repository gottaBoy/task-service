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
import net.ibizsys.pscore.srv.config.entity.PSSysPolicyModel;
import net.ibizsys.pscore.srv.config.service.PSSysPolicyModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysPolicyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysPolicyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSPOLICYID = "PSSYSPOLICYID";
    public static final String FIELD_PSSYSPOLICYNAME = "PSSYSPOLICYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSPOLICYID = 3;
    private static final int INDEX_PSSYSPOLICYNAME = 4;
    private static final int INDEX_UPDATEDATE = 5;
    private static final int INDEX_UPDATEMAN = 6;
    private static final int INDEX_VALIDFLAG = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysPolicyBase proxyPSSysPolicyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssyspolicyidDirtyFlag = false;
    private boolean pssyspolicynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssyspolicyid")
    private String pssyspolicyid;
    @Column(name="pssyspolicyname")
    private String pssyspolicyname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSysPolicyModelsLock = new Integer(1);
    private ArrayList<PSSysPolicyModel> pssyspolicymodels = null;

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

    public void setPSSysPolicyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyid = string;
        this.pssyspolicyidDirtyFlag = true;
    }

    public String getPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyId();
        }
        return this.pssyspolicyid;
    }

    public boolean isPSSysPolicyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyIdDirty();
        }
        return this.pssyspolicyidDirtyFlag;
    }

    public void resetPSSysPolicyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyId();
            return;
        }
        this.pssyspolicyidDirtyFlag = false;
        this.pssyspolicyid = null;
    }

    public void setPSSysPolicyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPolicyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspolicyname = string;
        this.pssyspolicynameDirtyFlag = true;
    }

    public String getPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyName();
        }
        return this.pssyspolicyname;
    }

    public boolean isPSSysPolicyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPolicyNameDirty();
        }
        return this.pssyspolicynameDirtyFlag;
    }

    public void resetPSSysPolicyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPolicyName();
            return;
        }
        this.pssyspolicynameDirtyFlag = false;
        this.pssyspolicyname = null;
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
        PSSysPolicyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysPolicyBase pSSysPolicyBase) {
        pSSysPolicyBase.resetCreateDate();
        pSSysPolicyBase.resetCreateMan();
        pSSysPolicyBase.resetMemo();
        pSSysPolicyBase.resetPSSysPolicyId();
        pSSysPolicyBase.resetPSSysPolicyName();
        pSSysPolicyBase.resetUpdateDate();
        pSSysPolicyBase.resetUpdateMan();
        pSSysPolicyBase.resetValidFlag();
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
        if (!bl || this.isPSSysPolicyIdDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYID, this.getPSSysPolicyId());
        }
        if (!bl || this.isPSSysPolicyNameDirty()) {
            hashMap.put(FIELD_PSSYSPOLICYNAME, this.getPSSysPolicyName());
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
        return PSSysPolicyBase.get(this, n);
    }

    private static Object get(PSSysPolicyBase pSSysPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyBase.getCreateDate();
            }
            case 1: {
                return pSSysPolicyBase.getCreateMan();
            }
            case 2: {
                return pSSysPolicyBase.getMemo();
            }
            case 3: {
                return pSSysPolicyBase.getPSSysPolicyId();
            }
            case 4: {
                return pSSysPolicyBase.getPSSysPolicyName();
            }
            case 5: {
                return pSSysPolicyBase.getUpdateDate();
            }
            case 6: {
                return pSSysPolicyBase.getUpdateMan();
            }
            case 7: {
                return pSSysPolicyBase.getValidFlag();
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
        PSSysPolicyBase.set(this, n, object);
    }

    private static void set(PSSysPolicyBase pSSysPolicyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysPolicyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysPolicyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysPolicyBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysPolicyBase.setPSSysPolicyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysPolicyBase.setPSSysPolicyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysPolicyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysPolicyBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysPolicyBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysPolicyBase.isNull(this, n);
    }

    private static boolean isNull(PSSysPolicyBase pSSysPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysPolicyBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysPolicyBase.getMemo() == null;
            }
            case 3: {
                return pSSysPolicyBase.getPSSysPolicyId() == null;
            }
            case 4: {
                return pSSysPolicyBase.getPSSysPolicyName() == null;
            }
            case 5: {
                return pSSysPolicyBase.getUpdateDate() == null;
            }
            case 6: {
                return pSSysPolicyBase.getUpdateMan() == null;
            }
            case 7: {
                return pSSysPolicyBase.getValidFlag() == null;
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
        return PSSysPolicyBase.contains(this, n);
    }

    private static boolean contains(PSSysPolicyBase pSSysPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysPolicyBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysPolicyBase.isCreateManDirty();
            }
            case 2: {
                return pSSysPolicyBase.isMemoDirty();
            }
            case 3: {
                return pSSysPolicyBase.isPSSysPolicyIdDirty();
            }
            case 4: {
                return pSSysPolicyBase.isPSSysPolicyNameDirty();
            }
            case 5: {
                return pSSysPolicyBase.isUpdateDateDirty();
            }
            case 6: {
                return pSSysPolicyBase.isUpdateManDirty();
            }
            case 7: {
                return pSSysPolicyBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysPolicyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysPolicyBase pSSysPolicyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysPolicyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getPSSysPolicyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyid", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getPSSysPolicyId()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getPSSysPolicyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspolicyname", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getPSSysPolicyName()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysPolicyBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysPolicyBase.getJSONValue((Object)pSSysPolicyBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysPolicyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysPolicyBase pSSysPolicyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysPolicyBase.getCreateDate() != null) {
            object = pSSysPolicyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPolicyBase.getCreateMan() != null) {
            object = pSSysPolicyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyBase.getMemo() != null) {
            object = pSSysPolicyBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyBase.getPSSysPolicyId() != null) {
            object = pSSysPolicyBase.getPSSysPolicyId();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyBase.getPSSysPolicyName() != null) {
            object = pSSysPolicyBase.getPSSysPolicyName();
            xmlNode.setAttribute(FIELD_PSSYSPOLICYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyBase.getUpdateDate() != null) {
            object = pSSysPolicyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysPolicyBase.getUpdateMan() != null) {
            object = pSSysPolicyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysPolicyBase.getValidFlag() != null) {
            object = pSSysPolicyBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysPolicyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysPolicyBase pSSysPolicyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysPolicyBase.isCreateDateDirty() && (bl || pSSysPolicyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysPolicyBase.getCreateDate());
        }
        if (pSSysPolicyBase.isCreateManDirty() && (bl || pSSysPolicyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysPolicyBase.getCreateMan());
        }
        if (pSSysPolicyBase.isMemoDirty() && (bl || pSSysPolicyBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysPolicyBase.getMemo());
        }
        if (pSSysPolicyBase.isPSSysPolicyIdDirty() && (bl || pSSysPolicyBase.getPSSysPolicyId() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYID, (Object)pSSysPolicyBase.getPSSysPolicyId());
        }
        if (pSSysPolicyBase.isPSSysPolicyNameDirty() && (bl || pSSysPolicyBase.getPSSysPolicyName() != null)) {
            iDataObject.set(FIELD_PSSYSPOLICYNAME, (Object)pSSysPolicyBase.getPSSysPolicyName());
        }
        if (pSSysPolicyBase.isUpdateDateDirty() && (bl || pSSysPolicyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysPolicyBase.getUpdateDate());
        }
        if (pSSysPolicyBase.isUpdateManDirty() && (bl || pSSysPolicyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysPolicyBase.getUpdateMan());
        }
        if (pSSysPolicyBase.isValidFlagDirty() && (bl || pSSysPolicyBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysPolicyBase.getValidFlag());
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
        return PSSysPolicyBase.remove(this, n);
    }

    private static boolean remove(PSSysPolicyBase pSSysPolicyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysPolicyBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysPolicyBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysPolicyBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysPolicyBase.resetPSSysPolicyId();
                return true;
            }
            case 4: {
                pSSysPolicyBase.resetPSSysPolicyName();
                return true;
            }
            case 5: {
                pSSysPolicyBase.resetUpdateDate();
                return true;
            }
            case 6: {
                pSSysPolicyBase.resetUpdateMan();
                return true;
            }
            case 7: {
                pSSysPolicyBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysPolicyModel> getPSSysPolicyModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPolicyModels();
        }
        if (this.getPSSysPolicyId() == null) {
            return null;
        }
        PSSysPolicyModelService pSSysPolicyModelService = (PSSysPolicyModelService)ServiceGlobal.getService(PSSysPolicyModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysPolicyModelsLock;
        synchronized (n) {
            if (this.pssyspolicymodels == null) {
                this.pssyspolicymodels = pSSysPolicyModelService.selectByPSSysPolicy(this);
            }
            return this.pssyspolicymodels;
        }
    }

    private PSSysPolicyBase getProxyEntity() {
        return this.proxyPSSysPolicyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysPolicyBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysPolicyBase) {
            this.proxyPSSysPolicyBase = (PSSysPolicyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysPolicyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSPOLICYID, 3);
        fieldIndexMap.put(FIELD_PSSYSPOLICYNAME, 4);
        fieldIndexMap.put(FIELD_UPDATEDATE, 5);
        fieldIndexMap.put(FIELD_UPDATEMAN, 6);
        fieldIndexMap.put(FIELD_VALIDFLAG, 7);
    }
}

