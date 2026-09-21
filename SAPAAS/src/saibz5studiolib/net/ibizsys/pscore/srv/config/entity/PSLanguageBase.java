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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSLanguageBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSLanguageBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSLANGUAGEID = "PSLANGUAGEID";
    public static final String FIELD_PSLANGUAGENAME = "PSLANGUAGENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSLANGUAGEID = 3;
    private static final int INDEX_PSLANGUAGENAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_PSSYSTEMNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSLanguageBase proxyPSLanguageBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pslanguageidDirtyFlag = false;
    private boolean pslanguagenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pslanguageid")
    private String pslanguageid;
    @Column(name="pslanguagename")
    private String pslanguagename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSLanguageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguageid = string;
        this.pslanguageidDirtyFlag = true;
    }

    public String getPSLanguageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageId();
        }
        return this.pslanguageid;
    }

    public boolean isPSLanguageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageIdDirty();
        }
        return this.pslanguageidDirtyFlag;
    }

    public void resetPSLanguageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageId();
            return;
        }
        this.pslanguageidDirtyFlag = false;
        this.pslanguageid = null;
    }

    public void setPSLanguageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSLanguageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pslanguagename = string;
        this.pslanguagenameDirtyFlag = true;
    }

    public String getPSLanguageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSLanguageName();
        }
        return this.pslanguagename;
    }

    public boolean isPSLanguageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSLanguageNameDirty();
        }
        return this.pslanguagenameDirtyFlag;
    }

    public void resetPSLanguageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSLanguageName();
            return;
        }
        this.pslanguagenameDirtyFlag = false;
        this.pslanguagename = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSLanguageBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSLanguageBase pSLanguageBase) {
        pSLanguageBase.resetCreateDate();
        pSLanguageBase.resetCreateMan();
        pSLanguageBase.resetMemo();
        pSLanguageBase.resetPSLanguageId();
        pSLanguageBase.resetPSLanguageName();
        pSLanguageBase.resetPSSystemId();
        pSLanguageBase.resetPSSystemName();
        pSLanguageBase.resetUpdateDate();
        pSLanguageBase.resetUpdateMan();
        pSLanguageBase.resetValidFlag();
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
        if (!bl || this.isPSLanguageIdDirty()) {
            hashMap.put(FIELD_PSLANGUAGEID, this.getPSLanguageId());
        }
        if (!bl || this.isPSLanguageNameDirty()) {
            hashMap.put(FIELD_PSLANGUAGENAME, this.getPSLanguageName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSLanguageBase.get(this, n);
    }

    private static Object get(PSLanguageBase pSLanguageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageBase.getCreateDate();
            }
            case 1: {
                return pSLanguageBase.getCreateMan();
            }
            case 2: {
                return pSLanguageBase.getMemo();
            }
            case 3: {
                return pSLanguageBase.getPSLanguageId();
            }
            case 4: {
                return pSLanguageBase.getPSLanguageName();
            }
            case 5: {
                return pSLanguageBase.getPSSystemId();
            }
            case 6: {
                return pSLanguageBase.getPSSystemName();
            }
            case 7: {
                return pSLanguageBase.getUpdateDate();
            }
            case 8: {
                return pSLanguageBase.getUpdateMan();
            }
            case 9: {
                return pSLanguageBase.getValidFlag();
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
        PSLanguageBase.set(this, n, object);
    }

    private static void set(PSLanguageBase pSLanguageBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSLanguageBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSLanguageBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSLanguageBase.setPSLanguageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSLanguageBase.setPSLanguageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSLanguageBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSLanguageBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSLanguageBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSLanguageBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSLanguageBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSLanguageBase.isNull(this, n);
    }

    private static boolean isNull(PSLanguageBase pSLanguageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageBase.getCreateDate() == null;
            }
            case 1: {
                return pSLanguageBase.getCreateMan() == null;
            }
            case 2: {
                return pSLanguageBase.getMemo() == null;
            }
            case 3: {
                return pSLanguageBase.getPSLanguageId() == null;
            }
            case 4: {
                return pSLanguageBase.getPSLanguageName() == null;
            }
            case 5: {
                return pSLanguageBase.getPSSystemId() == null;
            }
            case 6: {
                return pSLanguageBase.getPSSystemName() == null;
            }
            case 7: {
                return pSLanguageBase.getUpdateDate() == null;
            }
            case 8: {
                return pSLanguageBase.getUpdateMan() == null;
            }
            case 9: {
                return pSLanguageBase.getValidFlag() == null;
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
        return PSLanguageBase.contains(this, n);
    }

    private static boolean contains(PSLanguageBase pSLanguageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSLanguageBase.isCreateDateDirty();
            }
            case 1: {
                return pSLanguageBase.isCreateManDirty();
            }
            case 2: {
                return pSLanguageBase.isMemoDirty();
            }
            case 3: {
                return pSLanguageBase.isPSLanguageIdDirty();
            }
            case 4: {
                return pSLanguageBase.isPSLanguageNameDirty();
            }
            case 5: {
                return pSLanguageBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSLanguageBase.isPSSystemNameDirty();
            }
            case 7: {
                return pSLanguageBase.isUpdateDateDirty();
            }
            case 8: {
                return pSLanguageBase.isUpdateManDirty();
            }
            case 9: {
                return pSLanguageBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSLanguageBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSLanguageBase pSLanguageBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSLanguageBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSLanguageBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSLanguageBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getMemo()), (boolean)false);
        }
        if (bl || pSLanguageBase.getPSLanguageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguageid", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getPSLanguageId()), (boolean)false);
        }
        if (bl || pSLanguageBase.getPSLanguageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pslanguagename", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getPSLanguageName()), (boolean)false);
        }
        if (bl || pSLanguageBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSLanguageBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSLanguageBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSLanguageBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSLanguageBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSLanguageBase.getJSONValue((Object)pSLanguageBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSLanguageBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSLanguageBase pSLanguageBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSLanguageBase.getCreateDate() != null) {
            object = pSLanguageBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageBase.getCreateMan() != null) {
            object = pSLanguageBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getMemo() != null) {
            object = pSLanguageBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getPSLanguageId() != null) {
            object = pSLanguageBase.getPSLanguageId();
            xmlNode.setAttribute(FIELD_PSLANGUAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getPSLanguageName() != null) {
            object = pSLanguageBase.getPSLanguageName();
            xmlNode.setAttribute(FIELD_PSLANGUAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getPSSystemId() != null) {
            object = pSLanguageBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getPSSystemName() != null) {
            object = pSLanguageBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getUpdateDate() != null) {
            object = pSLanguageBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSLanguageBase.getUpdateMan() != null) {
            object = pSLanguageBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSLanguageBase.getValidFlag() != null) {
            object = pSLanguageBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSLanguageBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSLanguageBase pSLanguageBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSLanguageBase.isCreateDateDirty() && (bl || pSLanguageBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSLanguageBase.getCreateDate());
        }
        if (pSLanguageBase.isCreateManDirty() && (bl || pSLanguageBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSLanguageBase.getCreateMan());
        }
        if (pSLanguageBase.isMemoDirty() && (bl || pSLanguageBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSLanguageBase.getMemo());
        }
        if (pSLanguageBase.isPSLanguageIdDirty() && (bl || pSLanguageBase.getPSLanguageId() != null)) {
            iDataObject.set(FIELD_PSLANGUAGEID, (Object)pSLanguageBase.getPSLanguageId());
        }
        if (pSLanguageBase.isPSLanguageNameDirty() && (bl || pSLanguageBase.getPSLanguageName() != null)) {
            iDataObject.set(FIELD_PSLANGUAGENAME, (Object)pSLanguageBase.getPSLanguageName());
        }
        if (pSLanguageBase.isPSSystemIdDirty() && (bl || pSLanguageBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSLanguageBase.getPSSystemId());
        }
        if (pSLanguageBase.isPSSystemNameDirty() && (bl || pSLanguageBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSLanguageBase.getPSSystemName());
        }
        if (pSLanguageBase.isUpdateDateDirty() && (bl || pSLanguageBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSLanguageBase.getUpdateDate());
        }
        if (pSLanguageBase.isUpdateManDirty() && (bl || pSLanguageBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSLanguageBase.getUpdateMan());
        }
        if (pSLanguageBase.isValidFlagDirty() && (bl || pSLanguageBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSLanguageBase.getValidFlag());
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
        return PSLanguageBase.remove(this, n);
    }

    private static boolean remove(PSLanguageBase pSLanguageBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSLanguageBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSLanguageBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSLanguageBase.resetMemo();
                return true;
            }
            case 3: {
                pSLanguageBase.resetPSLanguageId();
                return true;
            }
            case 4: {
                pSLanguageBase.resetPSLanguageName();
                return true;
            }
            case 5: {
                pSLanguageBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSLanguageBase.resetPSSystemName();
                return true;
            }
            case 7: {
                pSLanguageBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSLanguageBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSLanguageBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSLanguageBase getProxyEntity() {
        return this.proxyPSLanguageBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSLanguageBase = null;
        if (iDataObject != null && iDataObject instanceof PSLanguageBase) {
            this.proxyPSLanguageBase = (PSLanguageBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSLanguageService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSLANGUAGEID, 3);
        fieldIndexMap.put(FIELD_PSLANGUAGENAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

