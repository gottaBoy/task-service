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
import net.ibizsys.pscore.srv.config.entity.PSViewLogicTypeParam;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeParamService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewLogicTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewLogicTypeBase.class);
    public static final String FIELD_APPVIEWLOGICOBJ = "APPVIEWLOGICOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROCESSNAME = "PROCESSNAME";
    public static final String FIELD_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String FIELD_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_APPVIEWLOGICOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PROCESSNAME = 4;
    private static final int INDEX_PSVIEWLOGICTYPEID = 5;
    private static final int INDEX_PSVIEWLOGICTYPENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewLogicTypeBase proxyPSViewLogicTypeBase = null;
    private boolean appviewlogicobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean processnameDirtyFlag = false;
    private boolean psviewlogictypeidDirtyFlag = false;
    private boolean psviewlogictypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="appviewlogicobj")
    private String appviewlogicobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="processname")
    private String processname;
    @Column(name="psviewlogictypeid")
    private String psviewlogictypeid;
    @Column(name="psviewlogictypename")
    private String psviewlogictypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSViewLogicTypeParamsLock = new Integer(1);
    private ArrayList<PSViewLogicTypeParam> psviewlogictypeparams = null;

    public void setAPPViewLogicOBJ(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAPPViewLogicOBJ(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appviewlogicobj = string;
        this.appviewlogicobjDirtyFlag = true;
    }

    public String getAPPViewLogicOBJ() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAPPViewLogicOBJ();
        }
        return this.appviewlogicobj;
    }

    public boolean isAPPViewLogicOBJDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAPPViewLogicOBJDirty();
        }
        return this.appviewlogicobjDirtyFlag;
    }

    public void resetAPPViewLogicOBJ() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAPPViewLogicOBJ();
            return;
        }
        this.appviewlogicobjDirtyFlag = false;
        this.appviewlogicobj = null;
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

    public void setProcessName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processname = string;
        this.processnameDirtyFlag = true;
    }

    public String getProcessName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessName();
        }
        return this.processname;
    }

    public boolean isProcessNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessNameDirty();
        }
        return this.processnameDirtyFlag;
    }

    public void resetProcessName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessName();
            return;
        }
        this.processnameDirtyFlag = false;
        this.processname = null;
    }

    public void setPSViewLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeid = string;
        this.psviewlogictypeidDirtyFlag = true;
    }

    public String getPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeId();
        }
        return this.psviewlogictypeid;
    }

    public boolean isPSViewLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeIdDirty();
        }
        return this.psviewlogictypeidDirtyFlag;
    }

    public void resetPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeId();
            return;
        }
        this.psviewlogictypeidDirtyFlag = false;
        this.psviewlogictypeid = null;
    }

    public void setPSViewLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypename = string;
        this.psviewlogictypenameDirtyFlag = true;
    }

    public String getPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeName();
        }
        return this.psviewlogictypename;
    }

    public boolean isPSViewLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeNameDirty();
        }
        return this.psviewlogictypenameDirtyFlag;
    }

    public void resetPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeName();
            return;
        }
        this.psviewlogictypenameDirtyFlag = false;
        this.psviewlogictypename = null;
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
        PSViewLogicTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewLogicTypeBase pSViewLogicTypeBase) {
        pSViewLogicTypeBase.resetAPPViewLogicOBJ();
        pSViewLogicTypeBase.resetCreateDate();
        pSViewLogicTypeBase.resetCreateMan();
        pSViewLogicTypeBase.resetMemo();
        pSViewLogicTypeBase.resetProcessName();
        pSViewLogicTypeBase.resetPSViewLogicTypeId();
        pSViewLogicTypeBase.resetPSViewLogicTypeName();
        pSViewLogicTypeBase.resetUpdateDate();
        pSViewLogicTypeBase.resetUpdateMan();
        pSViewLogicTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAPPViewLogicOBJDirty()) {
            hashMap.put(FIELD_APPVIEWLOGICOBJ, this.getAPPViewLogicOBJ());
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
        if (!bl || this.isProcessNameDirty()) {
            hashMap.put(FIELD_PROCESSNAME, this.getProcessName());
        }
        if (!bl || this.isPSViewLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEID, this.getPSViewLogicTypeId());
        }
        if (!bl || this.isPSViewLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPENAME, this.getPSViewLogicTypeName());
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
        return PSViewLogicTypeBase.get(this, n);
    }

    private static Object get(PSViewLogicTypeBase pSViewLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeBase.getAPPViewLogicOBJ();
            }
            case 1: {
                return pSViewLogicTypeBase.getCreateDate();
            }
            case 2: {
                return pSViewLogicTypeBase.getCreateMan();
            }
            case 3: {
                return pSViewLogicTypeBase.getMemo();
            }
            case 4: {
                return pSViewLogicTypeBase.getProcessName();
            }
            case 5: {
                return pSViewLogicTypeBase.getPSViewLogicTypeId();
            }
            case 6: {
                return pSViewLogicTypeBase.getPSViewLogicTypeName();
            }
            case 7: {
                return pSViewLogicTypeBase.getUpdateDate();
            }
            case 8: {
                return pSViewLogicTypeBase.getUpdateMan();
            }
            case 9: {
                return pSViewLogicTypeBase.getValidFlag();
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
        PSViewLogicTypeBase.set(this, n, object);
    }

    private static void set(PSViewLogicTypeBase pSViewLogicTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewLogicTypeBase.setAPPViewLogicOBJ(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewLogicTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSViewLogicTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewLogicTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSViewLogicTypeBase.setProcessName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewLogicTypeBase.setPSViewLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewLogicTypeBase.setPSViewLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewLogicTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSViewLogicTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewLogicTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSViewLogicTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSViewLogicTypeBase pSViewLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeBase.getAPPViewLogicOBJ() == null;
            }
            case 1: {
                return pSViewLogicTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSViewLogicTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSViewLogicTypeBase.getMemo() == null;
            }
            case 4: {
                return pSViewLogicTypeBase.getProcessName() == null;
            }
            case 5: {
                return pSViewLogicTypeBase.getPSViewLogicTypeId() == null;
            }
            case 6: {
                return pSViewLogicTypeBase.getPSViewLogicTypeName() == null;
            }
            case 7: {
                return pSViewLogicTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSViewLogicTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSViewLogicTypeBase.getValidFlag() == null;
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
        return PSViewLogicTypeBase.contains(this, n);
    }

    private static boolean contains(PSViewLogicTypeBase pSViewLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeBase.isAPPViewLogicOBJDirty();
            }
            case 1: {
                return pSViewLogicTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSViewLogicTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSViewLogicTypeBase.isMemoDirty();
            }
            case 4: {
                return pSViewLogicTypeBase.isProcessNameDirty();
            }
            case 5: {
                return pSViewLogicTypeBase.isPSViewLogicTypeIdDirty();
            }
            case 6: {
                return pSViewLogicTypeBase.isPSViewLogicTypeNameDirty();
            }
            case 7: {
                return pSViewLogicTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSViewLogicTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSViewLogicTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewLogicTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewLogicTypeBase pSViewLogicTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewLogicTypeBase.getAPPViewLogicOBJ() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewlogicobj", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getAPPViewLogicOBJ()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getProcessName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processname", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getProcessName()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getPSViewLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeid", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getPSViewLogicTypeId()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getPSViewLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypename", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getPSViewLogicTypeName()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewLogicTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewLogicTypeBase.getJSONValue((Object)pSViewLogicTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewLogicTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewLogicTypeBase pSViewLogicTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewLogicTypeBase.getAPPViewLogicOBJ() != null) {
            object = pSViewLogicTypeBase.getAPPViewLogicOBJ();
            xmlNode.setAttribute(FIELD_APPVIEWLOGICOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getCreateDate() != null) {
            object = pSViewLogicTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewLogicTypeBase.getCreateMan() != null) {
            object = pSViewLogicTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getMemo() != null) {
            object = pSViewLogicTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getProcessName() != null) {
            object = pSViewLogicTypeBase.getProcessName();
            xmlNode.setAttribute(FIELD_PROCESSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getPSViewLogicTypeId() != null) {
            object = pSViewLogicTypeBase.getPSViewLogicTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getPSViewLogicTypeName() != null) {
            object = pSViewLogicTypeBase.getPSViewLogicTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getUpdateDate() != null) {
            object = pSViewLogicTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewLogicTypeBase.getUpdateMan() != null) {
            object = pSViewLogicTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeBase.getValidFlag() != null) {
            object = pSViewLogicTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewLogicTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewLogicTypeBase pSViewLogicTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewLogicTypeBase.isAPPViewLogicOBJDirty() && (bl || pSViewLogicTypeBase.getAPPViewLogicOBJ() != null)) {
            iDataObject.set(FIELD_APPVIEWLOGICOBJ, (Object)pSViewLogicTypeBase.getAPPViewLogicOBJ());
        }
        if (pSViewLogicTypeBase.isCreateDateDirty() && (bl || pSViewLogicTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewLogicTypeBase.getCreateDate());
        }
        if (pSViewLogicTypeBase.isCreateManDirty() && (bl || pSViewLogicTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewLogicTypeBase.getCreateMan());
        }
        if (pSViewLogicTypeBase.isMemoDirty() && (bl || pSViewLogicTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewLogicTypeBase.getMemo());
        }
        if (pSViewLogicTypeBase.isProcessNameDirty() && (bl || pSViewLogicTypeBase.getProcessName() != null)) {
            iDataObject.set(FIELD_PROCESSNAME, (Object)pSViewLogicTypeBase.getProcessName());
        }
        if (pSViewLogicTypeBase.isPSViewLogicTypeIdDirty() && (bl || pSViewLogicTypeBase.getPSViewLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEID, (Object)pSViewLogicTypeBase.getPSViewLogicTypeId());
        }
        if (pSViewLogicTypeBase.isPSViewLogicTypeNameDirty() && (bl || pSViewLogicTypeBase.getPSViewLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPENAME, (Object)pSViewLogicTypeBase.getPSViewLogicTypeName());
        }
        if (pSViewLogicTypeBase.isUpdateDateDirty() && (bl || pSViewLogicTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewLogicTypeBase.getUpdateDate());
        }
        if (pSViewLogicTypeBase.isUpdateManDirty() && (bl || pSViewLogicTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewLogicTypeBase.getUpdateMan());
        }
        if (pSViewLogicTypeBase.isValidFlagDirty() && (bl || pSViewLogicTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewLogicTypeBase.getValidFlag());
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
        return PSViewLogicTypeBase.remove(this, n);
    }

    private static boolean remove(PSViewLogicTypeBase pSViewLogicTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewLogicTypeBase.resetAPPViewLogicOBJ();
                return true;
            }
            case 1: {
                pSViewLogicTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSViewLogicTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSViewLogicTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSViewLogicTypeBase.resetProcessName();
                return true;
            }
            case 5: {
                pSViewLogicTypeBase.resetPSViewLogicTypeId();
                return true;
            }
            case 6: {
                pSViewLogicTypeBase.resetPSViewLogicTypeName();
                return true;
            }
            case 7: {
                pSViewLogicTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSViewLogicTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSViewLogicTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewLogicTypeParam> getPSViewLogicTypeParams() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeParams();
        }
        if (this.getPSViewLogicTypeId() == null) {
            return null;
        }
        PSViewLogicTypeParamService pSViewLogicTypeParamService = (PSViewLogicTypeParamService)ServiceGlobal.getService(PSViewLogicTypeParamService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewLogicTypeParamsLock;
        synchronized (n) {
            if (this.psviewlogictypeparams == null) {
                this.psviewlogictypeparams = pSViewLogicTypeParamService.selectByPSViewLogicType(this);
            }
            return this.psviewlogictypeparams;
        }
    }

    private PSViewLogicTypeBase getProxyEntity() {
        return this.proxyPSViewLogicTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewLogicTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewLogicTypeBase) {
            this.proxyPSViewLogicTypeBase = (PSViewLogicTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPVIEWLOGICOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PROCESSNAME, 4);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEID, 5);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

