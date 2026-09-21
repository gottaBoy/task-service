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

public abstract class PSSysIssueTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysIssueTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSISSUETYPEID = "PSSYSISSUETYPEID";
    public static final String FIELD_PSSYSISSUETYPENAME = "PSSYSISSUETYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSYSISSUETYPEID = 4;
    private static final int INDEX_PSSYSISSUETYPENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysIssueTypeBase proxyPSSysIssueTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysissuetypeidDirtyFlag = false;
    private boolean pssysissuetypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysissuetypeid")
    private String pssysissuetypeid;
    @Column(name="pssysissuetypename")
    private String pssysissuetypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
    }

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

    public void setPSSysIssueTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissuetypeid = string;
        this.pssysissuetypeidDirtyFlag = true;
    }

    public String getPSSysIssueTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueTypeId();
        }
        return this.pssysissuetypeid;
    }

    public boolean isPSSysIssueTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueTypeIdDirty();
        }
        return this.pssysissuetypeidDirtyFlag;
    }

    public void resetPSSysIssueTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueTypeId();
            return;
        }
        this.pssysissuetypeidDirtyFlag = false;
        this.pssysissuetypeid = null;
    }

    public void setPSSysIssueTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysIssueTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysissuetypename = string;
        this.pssysissuetypenameDirtyFlag = true;
    }

    public String getPSSysIssueTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysIssueTypeName();
        }
        return this.pssysissuetypename;
    }

    public boolean isPSSysIssueTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysIssueTypeNameDirty();
        }
        return this.pssysissuetypenameDirtyFlag;
    }

    public void resetPSSysIssueTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysIssueTypeName();
            return;
        }
        this.pssysissuetypenameDirtyFlag = false;
        this.pssysissuetypename = null;
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
        PSSysIssueTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysIssueTypeBase pSSysIssueTypeBase) {
        pSSysIssueTypeBase.resetCodeName();
        pSSysIssueTypeBase.resetCreateDate();
        pSSysIssueTypeBase.resetCreateMan();
        pSSysIssueTypeBase.resetMemo();
        pSSysIssueTypeBase.resetPSSysIssueTypeId();
        pSSysIssueTypeBase.resetPSSysIssueTypeName();
        pSSysIssueTypeBase.resetUpdateDate();
        pSSysIssueTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysIssueTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSISSUETYPEID, this.getPSSysIssueTypeId());
        }
        if (!bl || this.isPSSysIssueTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSISSUETYPENAME, this.getPSSysIssueTypeName());
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
        return PSSysIssueTypeBase.get(this, n);
    }

    private static Object get(PSSysIssueTypeBase pSSysIssueTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueTypeBase.getCodeName();
            }
            case 1: {
                return pSSysIssueTypeBase.getCreateDate();
            }
            case 2: {
                return pSSysIssueTypeBase.getCreateMan();
            }
            case 3: {
                return pSSysIssueTypeBase.getMemo();
            }
            case 4: {
                return pSSysIssueTypeBase.getPSSysIssueTypeId();
            }
            case 5: {
                return pSSysIssueTypeBase.getPSSysIssueTypeName();
            }
            case 6: {
                return pSSysIssueTypeBase.getUpdateDate();
            }
            case 7: {
                return pSSysIssueTypeBase.getUpdateMan();
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
        PSSysIssueTypeBase.set(this, n, object);
    }

    private static void set(PSSysIssueTypeBase pSSysIssueTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysIssueTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysIssueTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysIssueTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysIssueTypeBase.setPSSysIssueTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysIssueTypeBase.setPSSysIssueTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysIssueTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysIssueTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysIssueTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysIssueTypeBase pSSysIssueTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysIssueTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysIssueTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysIssueTypeBase.getMemo() == null;
            }
            case 4: {
                return pSSysIssueTypeBase.getPSSysIssueTypeId() == null;
            }
            case 5: {
                return pSSysIssueTypeBase.getPSSysIssueTypeName() == null;
            }
            case 6: {
                return pSSysIssueTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSysIssueTypeBase.getUpdateMan() == null;
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
        return PSSysIssueTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysIssueTypeBase pSSysIssueTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysIssueTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysIssueTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysIssueTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysIssueTypeBase.isMemoDirty();
            }
            case 4: {
                return pSSysIssueTypeBase.isPSSysIssueTypeIdDirty();
            }
            case 5: {
                return pSSysIssueTypeBase.isPSSysIssueTypeNameDirty();
            }
            case 6: {
                return pSSysIssueTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSysIssueTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysIssueTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysIssueTypeBase pSSysIssueTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysIssueTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getPSSysIssueTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuetypeid", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getPSSysIssueTypeId()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getPSSysIssueTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysissuetypename", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getPSSysIssueTypeName()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysIssueTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysIssueTypeBase.getJSONValue((Object)pSSysIssueTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysIssueTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysIssueTypeBase pSSysIssueTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysIssueTypeBase.getCodeName() != null) {
            object = pSSysIssueTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueTypeBase.getCreateDate() != null) {
            object = pSSysIssueTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueTypeBase.getCreateMan() != null) {
            object = pSSysIssueTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueTypeBase.getMemo() != null) {
            object = pSSysIssueTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueTypeBase.getPSSysIssueTypeId() != null) {
            object = pSSysIssueTypeBase.getPSSysIssueTypeId();
            xmlNode.setAttribute(FIELD_PSSYSISSUETYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueTypeBase.getPSSysIssueTypeName() != null) {
            object = pSSysIssueTypeBase.getPSSysIssueTypeName();
            xmlNode.setAttribute(FIELD_PSSYSISSUETYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysIssueTypeBase.getUpdateDate() != null) {
            object = pSSysIssueTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysIssueTypeBase.getUpdateMan() != null) {
            object = pSSysIssueTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysIssueTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysIssueTypeBase pSSysIssueTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysIssueTypeBase.isCodeNameDirty() && (bl || pSSysIssueTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysIssueTypeBase.getCodeName());
        }
        if (pSSysIssueTypeBase.isCreateDateDirty() && (bl || pSSysIssueTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysIssueTypeBase.getCreateDate());
        }
        if (pSSysIssueTypeBase.isCreateManDirty() && (bl || pSSysIssueTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysIssueTypeBase.getCreateMan());
        }
        if (pSSysIssueTypeBase.isMemoDirty() && (bl || pSSysIssueTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysIssueTypeBase.getMemo());
        }
        if (pSSysIssueTypeBase.isPSSysIssueTypeIdDirty() && (bl || pSSysIssueTypeBase.getPSSysIssueTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSISSUETYPEID, (Object)pSSysIssueTypeBase.getPSSysIssueTypeId());
        }
        if (pSSysIssueTypeBase.isPSSysIssueTypeNameDirty() && (bl || pSSysIssueTypeBase.getPSSysIssueTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSISSUETYPENAME, (Object)pSSysIssueTypeBase.getPSSysIssueTypeName());
        }
        if (pSSysIssueTypeBase.isUpdateDateDirty() && (bl || pSSysIssueTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysIssueTypeBase.getUpdateDate());
        }
        if (pSSysIssueTypeBase.isUpdateManDirty() && (bl || pSSysIssueTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysIssueTypeBase.getUpdateMan());
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
        return PSSysIssueTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysIssueTypeBase pSSysIssueTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysIssueTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysIssueTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysIssueTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysIssueTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysIssueTypeBase.resetPSSysIssueTypeId();
                return true;
            }
            case 5: {
                pSSysIssueTypeBase.resetPSSysIssueTypeName();
                return true;
            }
            case 6: {
                pSSysIssueTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSysIssueTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysIssueTypeBase getProxyEntity() {
        return this.proxyPSSysIssueTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysIssueTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysIssueTypeBase) {
            this.proxyPSSysIssueTypeBase = (PSSysIssueTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysIssueTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSYSISSUETYPEID, 4);
        fieldIndexMap.put(FIELD_PSSYSISSUETYPENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

