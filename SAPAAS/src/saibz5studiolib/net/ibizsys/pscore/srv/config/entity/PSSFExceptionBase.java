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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFExceptionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFExceptionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFEXCEPTIONID = "PSSFEXCEPTIONID";
    public static final String FIELD_PSSFEXCEPTIONNAME = "PSSFEXCEPTIONNAME";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSFEXCEPTIONID = 4;
    private static final int INDEX_PSSFEXCEPTIONNAME = 5;
    private static final int INDEX_PSSFID = 6;
    private static final int INDEX_PSSFNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final int INDEX_VALIDFLAG = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFExceptionBase proxyPSSFExceptionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfexceptionidDirtyFlag = false;
    private boolean pssfexceptionnameDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfexceptionid")
    private String pssfexceptionid;
    @Column(name="pssfexceptionname")
    private String pssfexceptionname;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSSFExceptionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFExceptionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfexceptionid = string;
        this.pssfexceptionidDirtyFlag = true;
    }

    public String getPSSFExceptionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFExceptionId();
        }
        return this.pssfexceptionid;
    }

    public boolean isPSSFExceptionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFExceptionIdDirty();
        }
        return this.pssfexceptionidDirtyFlag;
    }

    public void resetPSSFExceptionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFExceptionId();
            return;
        }
        this.pssfexceptionidDirtyFlag = false;
        this.pssfexceptionid = null;
    }

    public void setPSSFExceptionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFExceptionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfexceptionname = string;
        this.pssfexceptionnameDirtyFlag = true;
    }

    public String getPSSFExceptionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFExceptionName();
        }
        return this.pssfexceptionname;
    }

    public boolean isPSSFExceptionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFExceptionNameDirty();
        }
        return this.pssfexceptionnameDirtyFlag;
    }

    public void resetPSSFExceptionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFExceptionName();
            return;
        }
        this.pssfexceptionnameDirtyFlag = false;
        this.pssfexceptionname = null;
    }

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
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
        PSSFExceptionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFExceptionBase pSSFExceptionBase) {
        pSSFExceptionBase.resetCreateDate();
        pSSFExceptionBase.resetCreateMan();
        pSSFExceptionBase.resetLogicName();
        pSSFExceptionBase.resetMemo();
        pSSFExceptionBase.resetPSSFExceptionId();
        pSSFExceptionBase.resetPSSFExceptionName();
        pSSFExceptionBase.resetPSSFId();
        pSSFExceptionBase.resetPSSFName();
        pSSFExceptionBase.resetUpdateDate();
        pSSFExceptionBase.resetUpdateMan();
        pSSFExceptionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSFExceptionIdDirty()) {
            hashMap.put(FIELD_PSSFEXCEPTIONID, this.getPSSFExceptionId());
        }
        if (!bl || this.isPSSFExceptionNameDirty()) {
            hashMap.put(FIELD_PSSFEXCEPTIONNAME, this.getPSSFExceptionName());
        }
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
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
        return PSSFExceptionBase.get(this, n);
    }

    private static Object get(PSSFExceptionBase pSSFExceptionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFExceptionBase.getCreateDate();
            }
            case 1: {
                return pSSFExceptionBase.getCreateMan();
            }
            case 2: {
                return pSSFExceptionBase.getLogicName();
            }
            case 3: {
                return pSSFExceptionBase.getMemo();
            }
            case 4: {
                return pSSFExceptionBase.getPSSFExceptionId();
            }
            case 5: {
                return pSSFExceptionBase.getPSSFExceptionName();
            }
            case 6: {
                return pSSFExceptionBase.getPSSFId();
            }
            case 7: {
                return pSSFExceptionBase.getPSSFName();
            }
            case 8: {
                return pSSFExceptionBase.getUpdateDate();
            }
            case 9: {
                return pSSFExceptionBase.getUpdateMan();
            }
            case 10: {
                return pSSFExceptionBase.getValidFlag();
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
        PSSFExceptionBase.set(this, n, object);
    }

    private static void set(PSSFExceptionBase pSSFExceptionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFExceptionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFExceptionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFExceptionBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFExceptionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFExceptionBase.setPSSFExceptionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFExceptionBase.setPSSFExceptionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFExceptionBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFExceptionBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFExceptionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSSFExceptionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFExceptionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSFExceptionBase.isNull(this, n);
    }

    private static boolean isNull(PSSFExceptionBase pSSFExceptionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFExceptionBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFExceptionBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFExceptionBase.getLogicName() == null;
            }
            case 3: {
                return pSSFExceptionBase.getMemo() == null;
            }
            case 4: {
                return pSSFExceptionBase.getPSSFExceptionId() == null;
            }
            case 5: {
                return pSSFExceptionBase.getPSSFExceptionName() == null;
            }
            case 6: {
                return pSSFExceptionBase.getPSSFId() == null;
            }
            case 7: {
                return pSSFExceptionBase.getPSSFName() == null;
            }
            case 8: {
                return pSSFExceptionBase.getUpdateDate() == null;
            }
            case 9: {
                return pSSFExceptionBase.getUpdateMan() == null;
            }
            case 10: {
                return pSSFExceptionBase.getValidFlag() == null;
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
        return PSSFExceptionBase.contains(this, n);
    }

    private static boolean contains(PSSFExceptionBase pSSFExceptionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFExceptionBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFExceptionBase.isCreateManDirty();
            }
            case 2: {
                return pSSFExceptionBase.isLogicNameDirty();
            }
            case 3: {
                return pSSFExceptionBase.isMemoDirty();
            }
            case 4: {
                return pSSFExceptionBase.isPSSFExceptionIdDirty();
            }
            case 5: {
                return pSSFExceptionBase.isPSSFExceptionNameDirty();
            }
            case 6: {
                return pSSFExceptionBase.isPSSFIdDirty();
            }
            case 7: {
                return pSSFExceptionBase.isPSSFNameDirty();
            }
            case 8: {
                return pSSFExceptionBase.isUpdateDateDirty();
            }
            case 9: {
                return pSSFExceptionBase.isUpdateManDirty();
            }
            case 10: {
                return pSSFExceptionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFExceptionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFExceptionBase pSSFExceptionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFExceptionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getLogicName()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getPSSFExceptionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfexceptionid", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getPSSFExceptionId()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getPSSFExceptionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfexceptionname", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getPSSFExceptionName()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSFExceptionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSFExceptionBase.getJSONValue((Object)pSSFExceptionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFExceptionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFExceptionBase pSSFExceptionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFExceptionBase.getCreateDate() != null) {
            object = pSSFExceptionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFExceptionBase.getCreateMan() != null) {
            object = pSSFExceptionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getLogicName() != null) {
            object = pSSFExceptionBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getMemo() != null) {
            object = pSSFExceptionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getPSSFExceptionId() != null) {
            object = pSSFExceptionBase.getPSSFExceptionId();
            xmlNode.setAttribute(FIELD_PSSFEXCEPTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getPSSFExceptionName() != null) {
            object = pSSFExceptionBase.getPSSFExceptionName();
            xmlNode.setAttribute(FIELD_PSSFEXCEPTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getPSSFId() != null) {
            object = pSSFExceptionBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getPSSFName() != null) {
            object = pSSFExceptionBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getUpdateDate() != null) {
            object = pSSFExceptionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFExceptionBase.getUpdateMan() != null) {
            object = pSSFExceptionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFExceptionBase.getValidFlag() != null) {
            object = pSSFExceptionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFExceptionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFExceptionBase pSSFExceptionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFExceptionBase.isCreateDateDirty() && (bl || pSSFExceptionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFExceptionBase.getCreateDate());
        }
        if (pSSFExceptionBase.isCreateManDirty() && (bl || pSSFExceptionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFExceptionBase.getCreateMan());
        }
        if (pSSFExceptionBase.isLogicNameDirty() && (bl || pSSFExceptionBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSSFExceptionBase.getLogicName());
        }
        if (pSSFExceptionBase.isMemoDirty() && (bl || pSSFExceptionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFExceptionBase.getMemo());
        }
        if (pSSFExceptionBase.isPSSFExceptionIdDirty() && (bl || pSSFExceptionBase.getPSSFExceptionId() != null)) {
            iDataObject.set(FIELD_PSSFEXCEPTIONID, (Object)pSSFExceptionBase.getPSSFExceptionId());
        }
        if (pSSFExceptionBase.isPSSFExceptionNameDirty() && (bl || pSSFExceptionBase.getPSSFExceptionName() != null)) {
            iDataObject.set(FIELD_PSSFEXCEPTIONNAME, (Object)pSSFExceptionBase.getPSSFExceptionName());
        }
        if (pSSFExceptionBase.isPSSFIdDirty() && (bl || pSSFExceptionBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFExceptionBase.getPSSFId());
        }
        if (pSSFExceptionBase.isPSSFNameDirty() && (bl || pSSFExceptionBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFExceptionBase.getPSSFName());
        }
        if (pSSFExceptionBase.isUpdateDateDirty() && (bl || pSSFExceptionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFExceptionBase.getUpdateDate());
        }
        if (pSSFExceptionBase.isUpdateManDirty() && (bl || pSSFExceptionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFExceptionBase.getUpdateMan());
        }
        if (pSSFExceptionBase.isValidFlagDirty() && (bl || pSSFExceptionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSFExceptionBase.getValidFlag());
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
        return PSSFExceptionBase.remove(this, n);
    }

    private static boolean remove(PSSFExceptionBase pSSFExceptionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFExceptionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFExceptionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFExceptionBase.resetLogicName();
                return true;
            }
            case 3: {
                pSSFExceptionBase.resetMemo();
                return true;
            }
            case 4: {
                pSSFExceptionBase.resetPSSFExceptionId();
                return true;
            }
            case 5: {
                pSSFExceptionBase.resetPSSFExceptionName();
                return true;
            }
            case 6: {
                pSSFExceptionBase.resetPSSFId();
                return true;
            }
            case 7: {
                pSSFExceptionBase.resetPSSFName();
                return true;
            }
            case 8: {
                pSSFExceptionBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSSFExceptionBase.resetUpdateMan();
                return true;
            }
            case 10: {
                pSSFExceptionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFExceptionBase getProxyEntity() {
        return this.proxyPSSFExceptionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFExceptionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFExceptionBase) {
            this.proxyPSSFExceptionBase = (PSSFExceptionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFExceptionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSFEXCEPTIONID, 4);
        fieldIndexMap.put(FIELD_PSSFEXCEPTIONNAME, 5);
        fieldIndexMap.put(FIELD_PSSFID, 6);
        fieldIndexMap.put(FIELD_PSSFNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
        fieldIndexMap.put(FIELD_VALIDFLAG, 10);
    }
}

