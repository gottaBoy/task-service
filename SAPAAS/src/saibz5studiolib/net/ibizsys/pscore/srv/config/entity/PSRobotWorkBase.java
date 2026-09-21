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

public abstract class PSRobotWorkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSRobotWorkBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSROBOTWORKID = "PSROBOTWORKID";
    public static final String FIELD_PSROBOTWORKNAME = "PSROBOTWORKNAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSROBOTWORKID = 3;
    private static final int INDEX_PSROBOTWORKNAME = 4;
    private static final int INDEX_TYPEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSRobotWorkBase proxyPSRobotWorkBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psrobotworkidDirtyFlag = false;
    private boolean psrobotworknameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psrobotworkid")
    private String psrobotworkid;
    @Column(name="psrobotworkname")
    private String psrobotworkname;
    @Column(name="typeobj")
    private String typeobj;
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

    public void setPSRobotWorkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworkid = string;
        this.psrobotworkidDirtyFlag = true;
    }

    public String getPSRobotWorkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkId();
        }
        return this.psrobotworkid;
    }

    public boolean isPSRobotWorkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkIdDirty();
        }
        return this.psrobotworkidDirtyFlag;
    }

    public void resetPSRobotWorkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkId();
            return;
        }
        this.psrobotworkidDirtyFlag = false;
        this.psrobotworkid = null;
    }

    public void setPSRobotWorkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSRobotWorkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psrobotworkname = string;
        this.psrobotworknameDirtyFlag = true;
    }

    public String getPSRobotWorkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSRobotWorkName();
        }
        return this.psrobotworkname;
    }

    public boolean isPSRobotWorkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSRobotWorkNameDirty();
        }
        return this.psrobotworknameDirtyFlag;
    }

    public void resetPSRobotWorkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSRobotWorkName();
            return;
        }
        this.psrobotworknameDirtyFlag = false;
        this.psrobotworkname = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSRobotWorkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSRobotWorkBase pSRobotWorkBase) {
        pSRobotWorkBase.resetCreateDate();
        pSRobotWorkBase.resetCreateMan();
        pSRobotWorkBase.resetMemo();
        pSRobotWorkBase.resetPSRobotWorkId();
        pSRobotWorkBase.resetPSRobotWorkName();
        pSRobotWorkBase.resetTypeObj();
        pSRobotWorkBase.resetUpdateDate();
        pSRobotWorkBase.resetUpdateMan();
        pSRobotWorkBase.resetValidFlag();
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
        if (!bl || this.isPSRobotWorkIdDirty()) {
            hashMap.put(FIELD_PSROBOTWORKID, this.getPSRobotWorkId());
        }
        if (!bl || this.isPSRobotWorkNameDirty()) {
            hashMap.put(FIELD_PSROBOTWORKNAME, this.getPSRobotWorkName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSRobotWorkBase.get(this, n);
    }

    private static Object get(PSRobotWorkBase pSRobotWorkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkBase.getCreateDate();
            }
            case 1: {
                return pSRobotWorkBase.getCreateMan();
            }
            case 2: {
                return pSRobotWorkBase.getMemo();
            }
            case 3: {
                return pSRobotWorkBase.getPSRobotWorkId();
            }
            case 4: {
                return pSRobotWorkBase.getPSRobotWorkName();
            }
            case 5: {
                return pSRobotWorkBase.getTypeObj();
            }
            case 6: {
                return pSRobotWorkBase.getUpdateDate();
            }
            case 7: {
                return pSRobotWorkBase.getUpdateMan();
            }
            case 8: {
                return pSRobotWorkBase.getValidFlag();
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
        PSRobotWorkBase.set(this, n, object);
    }

    private static void set(PSRobotWorkBase pSRobotWorkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSRobotWorkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSRobotWorkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSRobotWorkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSRobotWorkBase.setPSRobotWorkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSRobotWorkBase.setPSRobotWorkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSRobotWorkBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSRobotWorkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSRobotWorkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSRobotWorkBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSRobotWorkBase.isNull(this, n);
    }

    private static boolean isNull(PSRobotWorkBase pSRobotWorkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkBase.getCreateDate() == null;
            }
            case 1: {
                return pSRobotWorkBase.getCreateMan() == null;
            }
            case 2: {
                return pSRobotWorkBase.getMemo() == null;
            }
            case 3: {
                return pSRobotWorkBase.getPSRobotWorkId() == null;
            }
            case 4: {
                return pSRobotWorkBase.getPSRobotWorkName() == null;
            }
            case 5: {
                return pSRobotWorkBase.getTypeObj() == null;
            }
            case 6: {
                return pSRobotWorkBase.getUpdateDate() == null;
            }
            case 7: {
                return pSRobotWorkBase.getUpdateMan() == null;
            }
            case 8: {
                return pSRobotWorkBase.getValidFlag() == null;
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
        return PSRobotWorkBase.contains(this, n);
    }

    private static boolean contains(PSRobotWorkBase pSRobotWorkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSRobotWorkBase.isCreateDateDirty();
            }
            case 1: {
                return pSRobotWorkBase.isCreateManDirty();
            }
            case 2: {
                return pSRobotWorkBase.isMemoDirty();
            }
            case 3: {
                return pSRobotWorkBase.isPSRobotWorkIdDirty();
            }
            case 4: {
                return pSRobotWorkBase.isPSRobotWorkNameDirty();
            }
            case 5: {
                return pSRobotWorkBase.isTypeObjDirty();
            }
            case 6: {
                return pSRobotWorkBase.isUpdateDateDirty();
            }
            case 7: {
                return pSRobotWorkBase.isUpdateManDirty();
            }
            case 8: {
                return pSRobotWorkBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSRobotWorkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSRobotWorkBase pSRobotWorkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSRobotWorkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getMemo()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getPSRobotWorkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworkid", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getPSRobotWorkId()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getPSRobotWorkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psrobotworkname", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getPSRobotWorkName()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSRobotWorkBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSRobotWorkBase.getJSONValue((Object)pSRobotWorkBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSRobotWorkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSRobotWorkBase pSRobotWorkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSRobotWorkBase.getCreateDate() != null) {
            object = pSRobotWorkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotWorkBase.getCreateMan() != null) {
            object = pSRobotWorkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getMemo() != null) {
            object = pSRobotWorkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getPSRobotWorkId() != null) {
            object = pSRobotWorkBase.getPSRobotWorkId();
            xmlNode.setAttribute(FIELD_PSROBOTWORKID, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getPSRobotWorkName() != null) {
            object = pSRobotWorkBase.getPSRobotWorkName();
            xmlNode.setAttribute(FIELD_PSROBOTWORKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getTypeObj() != null) {
            object = pSRobotWorkBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getUpdateDate() != null) {
            object = pSRobotWorkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSRobotWorkBase.getUpdateMan() != null) {
            object = pSRobotWorkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSRobotWorkBase.getValidFlag() != null) {
            object = pSRobotWorkBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSRobotWorkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSRobotWorkBase pSRobotWorkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSRobotWorkBase.isCreateDateDirty() && (bl || pSRobotWorkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSRobotWorkBase.getCreateDate());
        }
        if (pSRobotWorkBase.isCreateManDirty() && (bl || pSRobotWorkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSRobotWorkBase.getCreateMan());
        }
        if (pSRobotWorkBase.isMemoDirty() && (bl || pSRobotWorkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSRobotWorkBase.getMemo());
        }
        if (pSRobotWorkBase.isPSRobotWorkIdDirty() && (bl || pSRobotWorkBase.getPSRobotWorkId() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKID, (Object)pSRobotWorkBase.getPSRobotWorkId());
        }
        if (pSRobotWorkBase.isPSRobotWorkNameDirty() && (bl || pSRobotWorkBase.getPSRobotWorkName() != null)) {
            iDataObject.set(FIELD_PSROBOTWORKNAME, (Object)pSRobotWorkBase.getPSRobotWorkName());
        }
        if (pSRobotWorkBase.isTypeObjDirty() && (bl || pSRobotWorkBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSRobotWorkBase.getTypeObj());
        }
        if (pSRobotWorkBase.isUpdateDateDirty() && (bl || pSRobotWorkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSRobotWorkBase.getUpdateDate());
        }
        if (pSRobotWorkBase.isUpdateManDirty() && (bl || pSRobotWorkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSRobotWorkBase.getUpdateMan());
        }
        if (pSRobotWorkBase.isValidFlagDirty() && (bl || pSRobotWorkBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSRobotWorkBase.getValidFlag());
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
        return PSRobotWorkBase.remove(this, n);
    }

    private static boolean remove(PSRobotWorkBase pSRobotWorkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSRobotWorkBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSRobotWorkBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSRobotWorkBase.resetMemo();
                return true;
            }
            case 3: {
                pSRobotWorkBase.resetPSRobotWorkId();
                return true;
            }
            case 4: {
                pSRobotWorkBase.resetPSRobotWorkName();
                return true;
            }
            case 5: {
                pSRobotWorkBase.resetTypeObj();
                return true;
            }
            case 6: {
                pSRobotWorkBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSRobotWorkBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSRobotWorkBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSRobotWorkBase getProxyEntity() {
        return this.proxyPSRobotWorkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSRobotWorkBase = null;
        if (iDataObject != null && iDataObject instanceof PSRobotWorkBase) {
            this.proxyPSRobotWorkBase = (PSRobotWorkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSRobotWorkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSROBOTWORKID, 3);
        fieldIndexMap.put(FIELD_PSROBOTWORKNAME, 4);
        fieldIndexMap.put(FIELD_TYPEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

