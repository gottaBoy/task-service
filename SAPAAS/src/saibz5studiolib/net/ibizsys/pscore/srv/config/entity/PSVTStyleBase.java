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
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSVTStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSVTStyleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_PSVTSTYLEID = "PSVTSTYLEID";
    public static final String FIELD_PSVTSTYLENAME = "PSVTSTYLENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSVIEWTYPEID = 4;
    private static final int INDEX_PSVIEWTYPENAME = 5;
    private static final int INDEX_PSVTSTYLEID = 6;
    private static final int INDEX_PSVTSTYLENAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSVTStyleBase proxyPSVTStyleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean psvtstyleidDirtyFlag = false;
    private boolean psvtstylenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="psvtstyleid")
    private String psvtstyleid;
    @Column(name="psvtstylename")
    private String psvtstylename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

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

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setPSVTStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtstyleid = string;
        this.psvtstyleidDirtyFlag = true;
    }

    public String getPSVTStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTStyleId();
        }
        return this.psvtstyleid;
    }

    public boolean isPSVTStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTStyleIdDirty();
        }
        return this.psvtstyleidDirtyFlag;
    }

    public void resetPSVTStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTStyleId();
            return;
        }
        this.psvtstyleidDirtyFlag = false;
        this.psvtstyleid = null;
    }

    public void setPSVTStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSVTStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psvtstylename = string;
        this.psvtstylenameDirtyFlag = true;
    }

    public String getPSVTStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTStyleName();
        }
        return this.psvtstylename;
    }

    public boolean isPSVTStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSVTStyleNameDirty();
        }
        return this.psvtstylenameDirtyFlag;
    }

    public void resetPSVTStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSVTStyleName();
            return;
        }
        this.psvtstylenameDirtyFlag = false;
        this.psvtstylename = null;
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
        PSVTStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSVTStyleBase pSVTStyleBase) {
        pSVTStyleBase.resetCreateDate();
        pSVTStyleBase.resetCreateMan();
        pSVTStyleBase.resetLogicName();
        pSVTStyleBase.resetMemo();
        pSVTStyleBase.resetPSViewTypeId();
        pSVTStyleBase.resetPSViewTypeName();
        pSVTStyleBase.resetPSVTStyleId();
        pSVTStyleBase.resetPSVTStyleName();
        pSVTStyleBase.resetUpdateDate();
        pSVTStyleBase.resetUpdateMan();
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
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isPSVTStyleIdDirty()) {
            hashMap.put(FIELD_PSVTSTYLEID, this.getPSVTStyleId());
        }
        if (!bl || this.isPSVTStyleNameDirty()) {
            hashMap.put(FIELD_PSVTSTYLENAME, this.getPSVTStyleName());
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
        return PSVTStyleBase.get(this, n);
    }

    private static Object get(PSVTStyleBase pSVTStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTStyleBase.getCreateDate();
            }
            case 1: {
                return pSVTStyleBase.getCreateMan();
            }
            case 2: {
                return pSVTStyleBase.getLogicName();
            }
            case 3: {
                return pSVTStyleBase.getMemo();
            }
            case 4: {
                return pSVTStyleBase.getPSViewTypeId();
            }
            case 5: {
                return pSVTStyleBase.getPSViewTypeName();
            }
            case 6: {
                return pSVTStyleBase.getPSVTStyleId();
            }
            case 7: {
                return pSVTStyleBase.getPSVTStyleName();
            }
            case 8: {
                return pSVTStyleBase.getUpdateDate();
            }
            case 9: {
                return pSVTStyleBase.getUpdateMan();
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
        PSVTStyleBase.set(this, n, object);
    }

    private static void set(PSVTStyleBase pSVTStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSVTStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSVTStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSVTStyleBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSVTStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSVTStyleBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSVTStyleBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSVTStyleBase.setPSVTStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSVTStyleBase.setPSVTStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSVTStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSVTStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSVTStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSVTStyleBase pSVTStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTStyleBase.getCreateDate() == null;
            }
            case 1: {
                return pSVTStyleBase.getCreateMan() == null;
            }
            case 2: {
                return pSVTStyleBase.getLogicName() == null;
            }
            case 3: {
                return pSVTStyleBase.getMemo() == null;
            }
            case 4: {
                return pSVTStyleBase.getPSViewTypeId() == null;
            }
            case 5: {
                return pSVTStyleBase.getPSViewTypeName() == null;
            }
            case 6: {
                return pSVTStyleBase.getPSVTStyleId() == null;
            }
            case 7: {
                return pSVTStyleBase.getPSVTStyleName() == null;
            }
            case 8: {
                return pSVTStyleBase.getUpdateDate() == null;
            }
            case 9: {
                return pSVTStyleBase.getUpdateMan() == null;
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
        return PSVTStyleBase.contains(this, n);
    }

    private static boolean contains(PSVTStyleBase pSVTStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSVTStyleBase.isCreateDateDirty();
            }
            case 1: {
                return pSVTStyleBase.isCreateManDirty();
            }
            case 2: {
                return pSVTStyleBase.isLogicNameDirty();
            }
            case 3: {
                return pSVTStyleBase.isMemoDirty();
            }
            case 4: {
                return pSVTStyleBase.isPSViewTypeIdDirty();
            }
            case 5: {
                return pSVTStyleBase.isPSViewTypeNameDirty();
            }
            case 6: {
                return pSVTStyleBase.isPSVTStyleIdDirty();
            }
            case 7: {
                return pSVTStyleBase.isPSVTStyleNameDirty();
            }
            case 8: {
                return pSVTStyleBase.isUpdateDateDirty();
            }
            case 9: {
                return pSVTStyleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSVTStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSVTStyleBase pSVTStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSVTStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getLogicName()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getPSVTStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtstyleid", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getPSVTStyleId()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getPSVTStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psvtstylename", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getPSVTStyleName()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSVTStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSVTStyleBase.getJSONValue((Object)pSVTStyleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSVTStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSVTStyleBase pSVTStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSVTStyleBase.getCreateDate() != null) {
            object = pSVTStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTStyleBase.getCreateMan() != null) {
            object = pSVTStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getLogicName() != null) {
            object = pSVTStyleBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getMemo() != null) {
            object = pSVTStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getPSViewTypeId() != null) {
            object = pSVTStyleBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getPSViewTypeName() != null) {
            object = pSVTStyleBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getPSVTStyleId() != null) {
            object = pSVTStyleBase.getPSVTStyleId();
            xmlNode.setAttribute(FIELD_PSVTSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getPSVTStyleName() != null) {
            object = pSVTStyleBase.getPSVTStyleName();
            xmlNode.setAttribute(FIELD_PSVTSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSVTStyleBase.getUpdateDate() != null) {
            object = pSVTStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSVTStyleBase.getUpdateMan() != null) {
            object = pSVTStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSVTStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSVTStyleBase pSVTStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSVTStyleBase.isCreateDateDirty() && (bl || pSVTStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSVTStyleBase.getCreateDate());
        }
        if (pSVTStyleBase.isCreateManDirty() && (bl || pSVTStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSVTStyleBase.getCreateMan());
        }
        if (pSVTStyleBase.isLogicNameDirty() && (bl || pSVTStyleBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSVTStyleBase.getLogicName());
        }
        if (pSVTStyleBase.isMemoDirty() && (bl || pSVTStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSVTStyleBase.getMemo());
        }
        if (pSVTStyleBase.isPSViewTypeIdDirty() && (bl || pSVTStyleBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSVTStyleBase.getPSViewTypeId());
        }
        if (pSVTStyleBase.isPSViewTypeNameDirty() && (bl || pSVTStyleBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSVTStyleBase.getPSViewTypeName());
        }
        if (pSVTStyleBase.isPSVTStyleIdDirty() && (bl || pSVTStyleBase.getPSVTStyleId() != null)) {
            iDataObject.set(FIELD_PSVTSTYLEID, (Object)pSVTStyleBase.getPSVTStyleId());
        }
        if (pSVTStyleBase.isPSVTStyleNameDirty() && (bl || pSVTStyleBase.getPSVTStyleName() != null)) {
            iDataObject.set(FIELD_PSVTSTYLENAME, (Object)pSVTStyleBase.getPSVTStyleName());
        }
        if (pSVTStyleBase.isUpdateDateDirty() && (bl || pSVTStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSVTStyleBase.getUpdateDate());
        }
        if (pSVTStyleBase.isUpdateManDirty() && (bl || pSVTStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSVTStyleBase.getUpdateMan());
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
        return PSVTStyleBase.remove(this, n);
    }

    private static boolean remove(PSVTStyleBase pSVTStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSVTStyleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSVTStyleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSVTStyleBase.resetLogicName();
                return true;
            }
            case 3: {
                pSVTStyleBase.resetMemo();
                return true;
            }
            case 4: {
                pSVTStyleBase.resetPSViewTypeId();
                return true;
            }
            case 5: {
                pSVTStyleBase.resetPSViewTypeName();
                return true;
            }
            case 6: {
                pSVTStyleBase.resetPSVTStyleId();
                return true;
            }
            case 7: {
                pSVTStyleBase.resetPSVTStyleName();
                return true;
            }
            case 8: {
                pSVTStyleBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSVTStyleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet((IEntity)pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSVTStyleBase getProxyEntity() {
        return this.proxyPSVTStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSVTStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSVTStyleBase) {
            this.proxyPSVTStyleBase = (PSVTStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSVTStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 4);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSVTSTYLEID, 6);
        fieldIndexMap.put(FIELD_PSVTSTYLENAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

