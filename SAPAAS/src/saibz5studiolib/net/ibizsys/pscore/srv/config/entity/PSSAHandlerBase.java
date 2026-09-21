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

public abstract class PSSAHandlerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSAHandlerBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSAHANDLERID = "PSSAHANDLERID";
    public static final String FIELD_PSSAHANDLERNAME = "PSSAHANDLERNAME";
    public static final String FIELD_SATYPE = "SATYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSAHANDLERID = 3;
    private static final int INDEX_PSSAHANDLERNAME = 4;
    private static final int INDEX_SATYPE = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSAHandlerBase proxyPSSAHandlerBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssahandleridDirtyFlag = false;
    private boolean pssahandlernameDirtyFlag = false;
    private boolean satypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssahandlerid")
    private String pssahandlerid;
    @Column(name="pssahandlername")
    private String pssahandlername;
    @Column(name="satype")
    private String satype;
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

    public void setPSSAHandlerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSAHandlerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssahandlerid = string;
        this.pssahandleridDirtyFlag = true;
    }

    public String getPSSAHandlerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSAHandlerId();
        }
        return this.pssahandlerid;
    }

    public boolean isPSSAHandlerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSAHandlerIdDirty();
        }
        return this.pssahandleridDirtyFlag;
    }

    public void resetPSSAHandlerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSAHandlerId();
            return;
        }
        this.pssahandleridDirtyFlag = false;
        this.pssahandlerid = null;
    }

    public void setPSSAHandlerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSAHandlerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssahandlername = string;
        this.pssahandlernameDirtyFlag = true;
    }

    public String getPSSAHandlerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSAHandlerName();
        }
        return this.pssahandlername;
    }

    public boolean isPSSAHandlerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSAHandlerNameDirty();
        }
        return this.pssahandlernameDirtyFlag;
    }

    public void resetPSSAHandlerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSAHandlerName();
            return;
        }
        this.pssahandlernameDirtyFlag = false;
        this.pssahandlername = null;
    }

    public void setSAType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSAType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.satype = string;
        this.satypeDirtyFlag = true;
    }

    public String getSAType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSAType();
        }
        return this.satype;
    }

    public boolean isSATypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSATypeDirty();
        }
        return this.satypeDirtyFlag;
    }

    public void resetSAType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSAType();
            return;
        }
        this.satypeDirtyFlag = false;
        this.satype = null;
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
        PSSAHandlerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSAHandlerBase pSSAHandlerBase) {
        pSSAHandlerBase.resetCreateDate();
        pSSAHandlerBase.resetCreateMan();
        pSSAHandlerBase.resetMemo();
        pSSAHandlerBase.resetPSSAHandlerId();
        pSSAHandlerBase.resetPSSAHandlerName();
        pSSAHandlerBase.resetSAType();
        pSSAHandlerBase.resetUpdateDate();
        pSSAHandlerBase.resetUpdateMan();
        pSSAHandlerBase.resetValidFlag();
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
        if (!bl || this.isPSSAHandlerIdDirty()) {
            hashMap.put(FIELD_PSSAHANDLERID, this.getPSSAHandlerId());
        }
        if (!bl || this.isPSSAHandlerNameDirty()) {
            hashMap.put(FIELD_PSSAHANDLERNAME, this.getPSSAHandlerName());
        }
        if (!bl || this.isSATypeDirty()) {
            hashMap.put(FIELD_SATYPE, this.getSAType());
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
        return PSSAHandlerBase.get(this, n);
    }

    private static Object get(PSSAHandlerBase pSSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSAHandlerBase.getCreateDate();
            }
            case 1: {
                return pSSAHandlerBase.getCreateMan();
            }
            case 2: {
                return pSSAHandlerBase.getMemo();
            }
            case 3: {
                return pSSAHandlerBase.getPSSAHandlerId();
            }
            case 4: {
                return pSSAHandlerBase.getPSSAHandlerName();
            }
            case 5: {
                return pSSAHandlerBase.getSAType();
            }
            case 6: {
                return pSSAHandlerBase.getUpdateDate();
            }
            case 7: {
                return pSSAHandlerBase.getUpdateMan();
            }
            case 8: {
                return pSSAHandlerBase.getValidFlag();
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
        PSSAHandlerBase.set(this, n, object);
    }

    private static void set(PSSAHandlerBase pSSAHandlerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSAHandlerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSAHandlerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSAHandlerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSAHandlerBase.setPSSAHandlerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSAHandlerBase.setPSSAHandlerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSAHandlerBase.setSAType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSAHandlerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSAHandlerBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSAHandlerBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSAHandlerBase.isNull(this, n);
    }

    private static boolean isNull(PSSAHandlerBase pSSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSAHandlerBase.getCreateDate() == null;
            }
            case 1: {
                return pSSAHandlerBase.getCreateMan() == null;
            }
            case 2: {
                return pSSAHandlerBase.getMemo() == null;
            }
            case 3: {
                return pSSAHandlerBase.getPSSAHandlerId() == null;
            }
            case 4: {
                return pSSAHandlerBase.getPSSAHandlerName() == null;
            }
            case 5: {
                return pSSAHandlerBase.getSAType() == null;
            }
            case 6: {
                return pSSAHandlerBase.getUpdateDate() == null;
            }
            case 7: {
                return pSSAHandlerBase.getUpdateMan() == null;
            }
            case 8: {
                return pSSAHandlerBase.getValidFlag() == null;
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
        return PSSAHandlerBase.contains(this, n);
    }

    private static boolean contains(PSSAHandlerBase pSSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSAHandlerBase.isCreateDateDirty();
            }
            case 1: {
                return pSSAHandlerBase.isCreateManDirty();
            }
            case 2: {
                return pSSAHandlerBase.isMemoDirty();
            }
            case 3: {
                return pSSAHandlerBase.isPSSAHandlerIdDirty();
            }
            case 4: {
                return pSSAHandlerBase.isPSSAHandlerNameDirty();
            }
            case 5: {
                return pSSAHandlerBase.isSATypeDirty();
            }
            case 6: {
                return pSSAHandlerBase.isUpdateDateDirty();
            }
            case 7: {
                return pSSAHandlerBase.isUpdateManDirty();
            }
            case 8: {
                return pSSAHandlerBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSAHandlerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSAHandlerBase pSSAHandlerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSAHandlerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getPSSAHandlerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssahandlerid", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getPSSAHandlerId()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getPSSAHandlerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssahandlername", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getPSSAHandlerName()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getSAType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"satype", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getSAType()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSAHandlerBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSAHandlerBase.getJSONValue((Object)pSSAHandlerBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSAHandlerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSAHandlerBase pSSAHandlerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSAHandlerBase.getCreateDate() != null) {
            object = pSSAHandlerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSAHandlerBase.getCreateMan() != null) {
            object = pSSAHandlerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getMemo() != null) {
            object = pSSAHandlerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getPSSAHandlerId() != null) {
            object = pSSAHandlerBase.getPSSAHandlerId();
            xmlNode.setAttribute(FIELD_PSSAHANDLERID, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getPSSAHandlerName() != null) {
            object = pSSAHandlerBase.getPSSAHandlerName();
            xmlNode.setAttribute(FIELD_PSSAHANDLERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getSAType() != null) {
            object = pSSAHandlerBase.getSAType();
            xmlNode.setAttribute(FIELD_SATYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getUpdateDate() != null) {
            object = pSSAHandlerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSAHandlerBase.getUpdateMan() != null) {
            object = pSSAHandlerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSAHandlerBase.getValidFlag() != null) {
            object = pSSAHandlerBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSAHandlerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSAHandlerBase pSSAHandlerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSAHandlerBase.isCreateDateDirty() && (bl || pSSAHandlerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSAHandlerBase.getCreateDate());
        }
        if (pSSAHandlerBase.isCreateManDirty() && (bl || pSSAHandlerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSAHandlerBase.getCreateMan());
        }
        if (pSSAHandlerBase.isMemoDirty() && (bl || pSSAHandlerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSAHandlerBase.getMemo());
        }
        if (pSSAHandlerBase.isPSSAHandlerIdDirty() && (bl || pSSAHandlerBase.getPSSAHandlerId() != null)) {
            iDataObject.set(FIELD_PSSAHANDLERID, (Object)pSSAHandlerBase.getPSSAHandlerId());
        }
        if (pSSAHandlerBase.isPSSAHandlerNameDirty() && (bl || pSSAHandlerBase.getPSSAHandlerName() != null)) {
            iDataObject.set(FIELD_PSSAHANDLERNAME, (Object)pSSAHandlerBase.getPSSAHandlerName());
        }
        if (pSSAHandlerBase.isSATypeDirty() && (bl || pSSAHandlerBase.getSAType() != null)) {
            iDataObject.set(FIELD_SATYPE, (Object)pSSAHandlerBase.getSAType());
        }
        if (pSSAHandlerBase.isUpdateDateDirty() && (bl || pSSAHandlerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSAHandlerBase.getUpdateDate());
        }
        if (pSSAHandlerBase.isUpdateManDirty() && (bl || pSSAHandlerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSAHandlerBase.getUpdateMan());
        }
        if (pSSAHandlerBase.isValidFlagDirty() && (bl || pSSAHandlerBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSAHandlerBase.getValidFlag());
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
        return PSSAHandlerBase.remove(this, n);
    }

    private static boolean remove(PSSAHandlerBase pSSAHandlerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSAHandlerBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSAHandlerBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSAHandlerBase.resetMemo();
                return true;
            }
            case 3: {
                pSSAHandlerBase.resetPSSAHandlerId();
                return true;
            }
            case 4: {
                pSSAHandlerBase.resetPSSAHandlerName();
                return true;
            }
            case 5: {
                pSSAHandlerBase.resetSAType();
                return true;
            }
            case 6: {
                pSSAHandlerBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSSAHandlerBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSSAHandlerBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSAHandlerBase getProxyEntity() {
        return this.proxyPSSAHandlerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSAHandlerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSAHandlerBase) {
            this.proxyPSSAHandlerBase = (PSSAHandlerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSAHandlerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSAHANDLERID, 3);
        fieldIndexMap.put(FIELD_PSSAHANDLERNAME, 4);
        fieldIndexMap.put(FIELD_SATYPE, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

