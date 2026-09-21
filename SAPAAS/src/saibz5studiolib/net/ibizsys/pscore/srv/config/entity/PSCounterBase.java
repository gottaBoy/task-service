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

public abstract class PSCounterBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCounterBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COUNTERTYPE = "COUNTERTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCOUNTERID = "PSCOUNTERID";
    public static final String FIELD_PSCOUNTERNAME = "PSCOUNTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COUNTERTYPE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_JITCTRLOBJ = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSCOUNTERID = 7;
    private static final int INDEX_PSCOUNTERNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCounterBase proxyPSCounterBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean countertypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pscounteridDirtyFlag = false;
    private boolean pscounternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="codename")
    private String codename;
    @Column(name="countertype")
    private String countertype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="memo")
    private String memo;
    @Column(name="pscounterid")
    private String pscounterid;
    @Column(name="pscountername")
    private String pscountername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
    }

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

    public void setCounterType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCounterType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.countertype = string;
        this.countertypeDirtyFlag = true;
    }

    public String getCounterType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCounterType();
        }
        return this.countertype;
    }

    public boolean isCounterTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCounterTypeDirty();
        }
        return this.countertypeDirtyFlag;
    }

    public void resetCounterType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCounterType();
            return;
        }
        this.countertypeDirtyFlag = false;
        this.countertype = null;
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

    public void setJITCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj = string;
        this.jitctrlobjDirtyFlag = true;
    }

    public String getJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj();
        }
        return this.jitctrlobj;
    }

    public boolean isJITCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObjDirty();
        }
        return this.jitctrlobjDirtyFlag;
    }

    public void resetJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj();
            return;
        }
        this.jitctrlobjDirtyFlag = false;
        this.jitctrlobj = null;
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

    public void setPSCounterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscounterid = string;
        this.pscounteridDirtyFlag = true;
    }

    public String getPSCounterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterId();
        }
        return this.pscounterid;
    }

    public boolean isPSCounterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterIdDirty();
        }
        return this.pscounteridDirtyFlag;
    }

    public void resetPSCounterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterId();
            return;
        }
        this.pscounteridDirtyFlag = false;
        this.pscounterid = null;
    }

    public void setPSCounterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCounterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscountername = string;
        this.pscounternameDirtyFlag = true;
    }

    public String getPSCounterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCounterName();
        }
        return this.pscountername;
    }

    public boolean isPSCounterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCounterNameDirty();
        }
        return this.pscounternameDirtyFlag;
    }

    public void resetPSCounterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCounterName();
            return;
        }
        this.pscounternameDirtyFlag = false;
        this.pscountername = null;
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
        PSCounterBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCounterBase pSCounterBase) {
        pSCounterBase.resetBaseClsParams();
        pSCounterBase.resetCodeName();
        pSCounterBase.resetCounterType();
        pSCounterBase.resetCreateDate();
        pSCounterBase.resetCreateMan();
        pSCounterBase.resetJITCtrlObj();
        pSCounterBase.resetMemo();
        pSCounterBase.resetPSCounterId();
        pSCounterBase.resetPSCounterName();
        pSCounterBase.resetUpdateDate();
        pSCounterBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCounterTypeDirty()) {
            hashMap.put(FIELD_COUNTERTYPE, this.getCounterType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCounterIdDirty()) {
            hashMap.put(FIELD_PSCOUNTERID, this.getPSCounterId());
        }
        if (!bl || this.isPSCounterNameDirty()) {
            hashMap.put(FIELD_PSCOUNTERNAME, this.getPSCounterName());
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
        return PSCounterBase.get(this, n);
    }

    private static Object get(PSCounterBase pSCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterBase.getBaseClsParams();
            }
            case 1: {
                return pSCounterBase.getCodeName();
            }
            case 2: {
                return pSCounterBase.getCounterType();
            }
            case 3: {
                return pSCounterBase.getCreateDate();
            }
            case 4: {
                return pSCounterBase.getCreateMan();
            }
            case 5: {
                return pSCounterBase.getJITCtrlObj();
            }
            case 6: {
                return pSCounterBase.getMemo();
            }
            case 7: {
                return pSCounterBase.getPSCounterId();
            }
            case 8: {
                return pSCounterBase.getPSCounterName();
            }
            case 9: {
                return pSCounterBase.getUpdateDate();
            }
            case 10: {
                return pSCounterBase.getUpdateMan();
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
        PSCounterBase.set(this, n, object);
    }

    private static void set(PSCounterBase pSCounterBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCounterBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCounterBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCounterBase.setCounterType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCounterBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSCounterBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCounterBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCounterBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCounterBase.setPSCounterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCounterBase.setPSCounterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCounterBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSCounterBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCounterBase.isNull(this, n);
    }

    private static boolean isNull(PSCounterBase pSCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSCounterBase.getCodeName() == null;
            }
            case 2: {
                return pSCounterBase.getCounterType() == null;
            }
            case 3: {
                return pSCounterBase.getCreateDate() == null;
            }
            case 4: {
                return pSCounterBase.getCreateMan() == null;
            }
            case 5: {
                return pSCounterBase.getJITCtrlObj() == null;
            }
            case 6: {
                return pSCounterBase.getMemo() == null;
            }
            case 7: {
                return pSCounterBase.getPSCounterId() == null;
            }
            case 8: {
                return pSCounterBase.getPSCounterName() == null;
            }
            case 9: {
                return pSCounterBase.getUpdateDate() == null;
            }
            case 10: {
                return pSCounterBase.getUpdateMan() == null;
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
        return PSCounterBase.contains(this, n);
    }

    private static boolean contains(PSCounterBase pSCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCounterBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSCounterBase.isCodeNameDirty();
            }
            case 2: {
                return pSCounterBase.isCounterTypeDirty();
            }
            case 3: {
                return pSCounterBase.isCreateDateDirty();
            }
            case 4: {
                return pSCounterBase.isCreateManDirty();
            }
            case 5: {
                return pSCounterBase.isJITCtrlObjDirty();
            }
            case 6: {
                return pSCounterBase.isMemoDirty();
            }
            case 7: {
                return pSCounterBase.isPSCounterIdDirty();
            }
            case 8: {
                return pSCounterBase.isPSCounterNameDirty();
            }
            case 9: {
                return pSCounterBase.isUpdateDateDirty();
            }
            case 10: {
                return pSCounterBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCounterBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCounterBase pSCounterBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCounterBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSCounterBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCounterBase.getCounterType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"countertype", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getCounterType()), (boolean)false);
        }
        if (bl || pSCounterBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCounterBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCounterBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSCounterBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getMemo()), (boolean)false);
        }
        if (bl || pSCounterBase.getPSCounterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscounterid", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getPSCounterId()), (boolean)false);
        }
        if (bl || pSCounterBase.getPSCounterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscountername", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getPSCounterName()), (boolean)false);
        }
        if (bl || pSCounterBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCounterBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCounterBase.getJSONValue((Object)pSCounterBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCounterBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCounterBase pSCounterBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCounterBase.getBaseClsParams() != null) {
            object = pSCounterBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSCounterBase.getCodeName() != null) {
            object = pSCounterBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSCounterBase.getCounterType() != null) {
            object = pSCounterBase.getCounterType();
            xmlNode.setAttribute(FIELD_COUNTERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getCreateDate() != null) {
            object = pSCounterBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterBase.getCreateMan() != null) {
            object = pSCounterBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getJITCtrlObj() != null) {
            object = pSCounterBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getMemo() != null) {
            object = pSCounterBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getPSCounterId() != null) {
            object = pSCounterBase.getPSCounterId();
            xmlNode.setAttribute(FIELD_PSCOUNTERID, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getPSCounterName() != null) {
            object = pSCounterBase.getPSCounterName();
            xmlNode.setAttribute(FIELD_PSCOUNTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCounterBase.getUpdateDate() != null) {
            object = pSCounterBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCounterBase.getUpdateMan() != null) {
            object = pSCounterBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCounterBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCounterBase pSCounterBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCounterBase.isBaseClsParamsDirty() && (bl || pSCounterBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSCounterBase.getBaseClsParams());
        }
        if (pSCounterBase.isCodeNameDirty() && (bl || pSCounterBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCounterBase.getCodeName());
        }
        if (pSCounterBase.isCounterTypeDirty() && (bl || pSCounterBase.getCounterType() != null)) {
            iDataObject.set(FIELD_COUNTERTYPE, (Object)pSCounterBase.getCounterType());
        }
        if (pSCounterBase.isCreateDateDirty() && (bl || pSCounterBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCounterBase.getCreateDate());
        }
        if (pSCounterBase.isCreateManDirty() && (bl || pSCounterBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCounterBase.getCreateMan());
        }
        if (pSCounterBase.isJITCtrlObjDirty() && (bl || pSCounterBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSCounterBase.getJITCtrlObj());
        }
        if (pSCounterBase.isMemoDirty() && (bl || pSCounterBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCounterBase.getMemo());
        }
        if (pSCounterBase.isPSCounterIdDirty() && (bl || pSCounterBase.getPSCounterId() != null)) {
            iDataObject.set(FIELD_PSCOUNTERID, (Object)pSCounterBase.getPSCounterId());
        }
        if (pSCounterBase.isPSCounterNameDirty() && (bl || pSCounterBase.getPSCounterName() != null)) {
            iDataObject.set(FIELD_PSCOUNTERNAME, (Object)pSCounterBase.getPSCounterName());
        }
        if (pSCounterBase.isUpdateDateDirty() && (bl || pSCounterBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCounterBase.getUpdateDate());
        }
        if (pSCounterBase.isUpdateManDirty() && (bl || pSCounterBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCounterBase.getUpdateMan());
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
        return PSCounterBase.remove(this, n);
    }

    private static boolean remove(PSCounterBase pSCounterBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCounterBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSCounterBase.resetCodeName();
                return true;
            }
            case 2: {
                pSCounterBase.resetCounterType();
                return true;
            }
            case 3: {
                pSCounterBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSCounterBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSCounterBase.resetJITCtrlObj();
                return true;
            }
            case 6: {
                pSCounterBase.resetMemo();
                return true;
            }
            case 7: {
                pSCounterBase.resetPSCounterId();
                return true;
            }
            case 8: {
                pSCounterBase.resetPSCounterName();
                return true;
            }
            case 9: {
                pSCounterBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSCounterBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSCounterBase getProxyEntity() {
        return this.proxyPSCounterBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCounterBase = null;
        if (iDataObject != null && iDataObject instanceof PSCounterBase) {
            this.proxyPSCounterBase = (PSCounterBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCounterService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COUNTERTYPE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSCOUNTERID, 7);
        fieldIndexMap.put(FIELD_PSCOUNTERNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

