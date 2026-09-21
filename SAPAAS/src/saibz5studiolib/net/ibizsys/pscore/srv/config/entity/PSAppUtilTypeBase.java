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

public abstract class PSAppUtilTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppUtilTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPUTILTYPEID = "PSAPPUTILTYPEID";
    public static final String FIELD_PSAPPUTILTYPENAME = "PSAPPUTILTYPENAME";
    public static final String FIELD_REGTOAPPFLAG = "REGTOAPPFLAG";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UTILDESC = "UTILDESC";
    public static final String FIELD_UTILMODEL = "UTILMODEL";
    public static final String FIELD_UTILOBJ = "UTILOBJ";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPUTILTYPEID = 3;
    private static final int INDEX_PSAPPUTILTYPENAME = 4;
    private static final int INDEX_REGTOAPPFLAG = 5;
    private static final int INDEX_TYPEOBJ = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_UTILDESC = 9;
    private static final int INDEX_UTILMODEL = 10;
    private static final int INDEX_UTILOBJ = 11;
    private static final int INDEX_UTILPARAMS = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppUtilTypeBase proxyPSAppUtilTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapputiltypeidDirtyFlag = false;
    private boolean psapputiltypenameDirtyFlag = false;
    private boolean regtoappflagDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean utildescDirtyFlag = false;
    private boolean utilmodelDirtyFlag = false;
    private boolean utilobjDirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psapputiltypeid")
    private String psapputiltypeid;
    @Column(name="psapputiltypename")
    private String psapputiltypename;
    @Column(name="regtoappflag")
    private Integer regtoappflag;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="utildesc")
    private String utildesc;
    @Column(name="utilmodel")
    private String utilmodel;
    @Column(name="utilobj")
    private String utilobj;
    @Column(name="utilparams")
    private String utilparams;
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

    public void setPSAppUtilTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputiltypeid = string;
        this.psapputiltypeidDirtyFlag = true;
    }

    public String getPSAppUtilTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilTypeId();
        }
        return this.psapputiltypeid;
    }

    public boolean isPSAppUtilTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilTypeIdDirty();
        }
        return this.psapputiltypeidDirtyFlag;
    }

    public void resetPSAppUtilTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilTypeId();
            return;
        }
        this.psapputiltypeidDirtyFlag = false;
        this.psapputiltypeid = null;
    }

    public void setPSAppUtilTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppUtilTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapputiltypename = string;
        this.psapputiltypenameDirtyFlag = true;
    }

    public String getPSAppUtilTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppUtilTypeName();
        }
        return this.psapputiltypename;
    }

    public boolean isPSAppUtilTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppUtilTypeNameDirty();
        }
        return this.psapputiltypenameDirtyFlag;
    }

    public void resetPSAppUtilTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppUtilTypeName();
            return;
        }
        this.psapputiltypenameDirtyFlag = false;
        this.psapputiltypename = null;
    }

    public void setRegToAppFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegToAppFlag(n);
            return;
        }
        this.regtoappflag = n;
        this.regtoappflagDirtyFlag = true;
    }

    public Integer getRegToAppFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegToAppFlag();
        }
        return this.regtoappflag;
    }

    public boolean isRegToAppFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegToAppFlagDirty();
        }
        return this.regtoappflagDirtyFlag;
    }

    public void resetRegToAppFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegToAppFlag();
            return;
        }
        this.regtoappflagDirtyFlag = false;
        this.regtoappflag = null;
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

    public void setUtilDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utildesc = string;
        this.utildescDirtyFlag = true;
    }

    public String getUtilDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilDesc();
        }
        return this.utildesc;
    }

    public boolean isUtilDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilDescDirty();
        }
        return this.utildescDirtyFlag;
    }

    public void resetUtilDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilDesc();
            return;
        }
        this.utildescDirtyFlag = false;
        this.utildesc = null;
    }

    public void setUtilModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilmodel = string;
        this.utilmodelDirtyFlag = true;
    }

    public String getUtilModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilModel();
        }
        return this.utilmodel;
    }

    public boolean isUtilModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilModelDirty();
        }
        return this.utilmodelDirtyFlag;
    }

    public void resetUtilModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilModel();
            return;
        }
        this.utilmodelDirtyFlag = false;
        this.utilmodel = null;
    }

    public void setUtilObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilobj = string;
        this.utilobjDirtyFlag = true;
    }

    public String getUtilObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilObj();
        }
        return this.utilobj;
    }

    public boolean isUtilObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilObjDirty();
        }
        return this.utilobjDirtyFlag;
    }

    public void resetUtilObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilObj();
            return;
        }
        this.utilobjDirtyFlag = false;
        this.utilobj = null;
    }

    public void setUtilParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilparams = string;
        this.utilparamsDirtyFlag = true;
    }

    public String getUtilParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilParams();
        }
        return this.utilparams;
    }

    public boolean isUtilParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilParamsDirty();
        }
        return this.utilparamsDirtyFlag;
    }

    public void resetUtilParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilParams();
            return;
        }
        this.utilparamsDirtyFlag = false;
        this.utilparams = null;
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
        PSAppUtilTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppUtilTypeBase pSAppUtilTypeBase) {
        pSAppUtilTypeBase.resetCreateDate();
        pSAppUtilTypeBase.resetCreateMan();
        pSAppUtilTypeBase.resetMemo();
        pSAppUtilTypeBase.resetPSAppUtilTypeId();
        pSAppUtilTypeBase.resetPSAppUtilTypeName();
        pSAppUtilTypeBase.resetRegToAppFlag();
        pSAppUtilTypeBase.resetTypeObj();
        pSAppUtilTypeBase.resetUpdateDate();
        pSAppUtilTypeBase.resetUpdateMan();
        pSAppUtilTypeBase.resetUtilDesc();
        pSAppUtilTypeBase.resetUtilModel();
        pSAppUtilTypeBase.resetUtilObj();
        pSAppUtilTypeBase.resetUtilParams();
        pSAppUtilTypeBase.resetValidFlag();
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
        if (!bl || this.isPSAppUtilTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPUTILTYPEID, this.getPSAppUtilTypeId());
        }
        if (!bl || this.isPSAppUtilTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPUTILTYPENAME, this.getPSAppUtilTypeName());
        }
        if (!bl || this.isRegToAppFlagDirty()) {
            hashMap.put(FIELD_REGTOAPPFLAG, this.getRegToAppFlag());
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
        if (!bl || this.isUtilDescDirty()) {
            hashMap.put(FIELD_UTILDESC, this.getUtilDesc());
        }
        if (!bl || this.isUtilModelDirty()) {
            hashMap.put(FIELD_UTILMODEL, this.getUtilModel());
        }
        if (!bl || this.isUtilObjDirty()) {
            hashMap.put(FIELD_UTILOBJ, this.getUtilObj());
        }
        if (!bl || this.isUtilParamsDirty()) {
            hashMap.put(FIELD_UTILPARAMS, this.getUtilParams());
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
        return PSAppUtilTypeBase.get(this, n);
    }

    private static Object get(PSAppUtilTypeBase pSAppUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilTypeBase.getCreateDate();
            }
            case 1: {
                return pSAppUtilTypeBase.getCreateMan();
            }
            case 2: {
                return pSAppUtilTypeBase.getMemo();
            }
            case 3: {
                return pSAppUtilTypeBase.getPSAppUtilTypeId();
            }
            case 4: {
                return pSAppUtilTypeBase.getPSAppUtilTypeName();
            }
            case 5: {
                return pSAppUtilTypeBase.getRegToAppFlag();
            }
            case 6: {
                return pSAppUtilTypeBase.getTypeObj();
            }
            case 7: {
                return pSAppUtilTypeBase.getUpdateDate();
            }
            case 8: {
                return pSAppUtilTypeBase.getUpdateMan();
            }
            case 9: {
                return pSAppUtilTypeBase.getUtilDesc();
            }
            case 10: {
                return pSAppUtilTypeBase.getUtilModel();
            }
            case 11: {
                return pSAppUtilTypeBase.getUtilObj();
            }
            case 12: {
                return pSAppUtilTypeBase.getUtilParams();
            }
            case 13: {
                return pSAppUtilTypeBase.getValidFlag();
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
        PSAppUtilTypeBase.set(this, n, object);
    }

    private static void set(PSAppUtilTypeBase pSAppUtilTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppUtilTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppUtilTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppUtilTypeBase.setPSAppUtilTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppUtilTypeBase.setPSAppUtilTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppUtilTypeBase.setRegToAppFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSAppUtilTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppUtilTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSAppUtilTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppUtilTypeBase.setUtilDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppUtilTypeBase.setUtilModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppUtilTypeBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppUtilTypeBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSAppUtilTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppUtilTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSAppUtilTypeBase pSAppUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppUtilTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppUtilTypeBase.getMemo() == null;
            }
            case 3: {
                return pSAppUtilTypeBase.getPSAppUtilTypeId() == null;
            }
            case 4: {
                return pSAppUtilTypeBase.getPSAppUtilTypeName() == null;
            }
            case 5: {
                return pSAppUtilTypeBase.getRegToAppFlag() == null;
            }
            case 6: {
                return pSAppUtilTypeBase.getTypeObj() == null;
            }
            case 7: {
                return pSAppUtilTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSAppUtilTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSAppUtilTypeBase.getUtilDesc() == null;
            }
            case 10: {
                return pSAppUtilTypeBase.getUtilModel() == null;
            }
            case 11: {
                return pSAppUtilTypeBase.getUtilObj() == null;
            }
            case 12: {
                return pSAppUtilTypeBase.getUtilParams() == null;
            }
            case 13: {
                return pSAppUtilTypeBase.getValidFlag() == null;
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
        return PSAppUtilTypeBase.contains(this, n);
    }

    private static boolean contains(PSAppUtilTypeBase pSAppUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppUtilTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppUtilTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSAppUtilTypeBase.isMemoDirty();
            }
            case 3: {
                return pSAppUtilTypeBase.isPSAppUtilTypeIdDirty();
            }
            case 4: {
                return pSAppUtilTypeBase.isPSAppUtilTypeNameDirty();
            }
            case 5: {
                return pSAppUtilTypeBase.isRegToAppFlagDirty();
            }
            case 6: {
                return pSAppUtilTypeBase.isTypeObjDirty();
            }
            case 7: {
                return pSAppUtilTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSAppUtilTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSAppUtilTypeBase.isUtilDescDirty();
            }
            case 10: {
                return pSAppUtilTypeBase.isUtilModelDirty();
            }
            case 11: {
                return pSAppUtilTypeBase.isUtilObjDirty();
            }
            case 12: {
                return pSAppUtilTypeBase.isUtilParamsDirty();
            }
            case 13: {
                return pSAppUtilTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppUtilTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppUtilTypeBase pSAppUtilTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppUtilTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getPSAppUtilTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputiltypeid", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getPSAppUtilTypeId()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getPSAppUtilTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapputiltypename", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getPSAppUtilTypeName()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getRegToAppFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regtoappflag", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getRegToAppFlag()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUtilDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utildesc", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUtilDesc()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUtilModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilmodel", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUtilModel()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSAppUtilTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppUtilTypeBase.getJSONValue((Object)pSAppUtilTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppUtilTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppUtilTypeBase pSAppUtilTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppUtilTypeBase.getCreateDate() != null) {
            object = pSAppUtilTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilTypeBase.getCreateMan() != null) {
            object = pSAppUtilTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getMemo() != null) {
            object = pSAppUtilTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getPSAppUtilTypeId() != null) {
            object = pSAppUtilTypeBase.getPSAppUtilTypeId();
            xmlNode.setAttribute(FIELD_PSAPPUTILTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getPSAppUtilTypeName() != null) {
            object = pSAppUtilTypeBase.getPSAppUtilTypeName();
            xmlNode.setAttribute(FIELD_PSAPPUTILTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getRegToAppFlag() != null) {
            object = pSAppUtilTypeBase.getRegToAppFlag();
            xmlNode.setAttribute(FIELD_REGTOAPPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSAppUtilTypeBase.getTypeObj() != null) {
            object = pSAppUtilTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getUpdateDate() != null) {
            object = pSAppUtilTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppUtilTypeBase.getUpdateMan() != null) {
            object = pSAppUtilTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getUtilDesc() != null) {
            object = pSAppUtilTypeBase.getUtilDesc();
            xmlNode.setAttribute(FIELD_UTILDESC, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getUtilModel() != null) {
            object = pSAppUtilTypeBase.getUtilModel();
            xmlNode.setAttribute(FIELD_UTILMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getUtilObj() != null) {
            object = pSAppUtilTypeBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getUtilParams() != null) {
            object = pSAppUtilTypeBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSAppUtilTypeBase.getValidFlag() != null) {
            object = pSAppUtilTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppUtilTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppUtilTypeBase pSAppUtilTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppUtilTypeBase.isCreateDateDirty() && (bl || pSAppUtilTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppUtilTypeBase.getCreateDate());
        }
        if (pSAppUtilTypeBase.isCreateManDirty() && (bl || pSAppUtilTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppUtilTypeBase.getCreateMan());
        }
        if (pSAppUtilTypeBase.isMemoDirty() && (bl || pSAppUtilTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppUtilTypeBase.getMemo());
        }
        if (pSAppUtilTypeBase.isPSAppUtilTypeIdDirty() && (bl || pSAppUtilTypeBase.getPSAppUtilTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPUTILTYPEID, (Object)pSAppUtilTypeBase.getPSAppUtilTypeId());
        }
        if (pSAppUtilTypeBase.isPSAppUtilTypeNameDirty() && (bl || pSAppUtilTypeBase.getPSAppUtilTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPUTILTYPENAME, (Object)pSAppUtilTypeBase.getPSAppUtilTypeName());
        }
        if (pSAppUtilTypeBase.isRegToAppFlagDirty() && (bl || pSAppUtilTypeBase.getRegToAppFlag() != null)) {
            iDataObject.set(FIELD_REGTOAPPFLAG, (Object)pSAppUtilTypeBase.getRegToAppFlag());
        }
        if (pSAppUtilTypeBase.isTypeObjDirty() && (bl || pSAppUtilTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSAppUtilTypeBase.getTypeObj());
        }
        if (pSAppUtilTypeBase.isUpdateDateDirty() && (bl || pSAppUtilTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppUtilTypeBase.getUpdateDate());
        }
        if (pSAppUtilTypeBase.isUpdateManDirty() && (bl || pSAppUtilTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppUtilTypeBase.getUpdateMan());
        }
        if (pSAppUtilTypeBase.isUtilDescDirty() && (bl || pSAppUtilTypeBase.getUtilDesc() != null)) {
            iDataObject.set(FIELD_UTILDESC, (Object)pSAppUtilTypeBase.getUtilDesc());
        }
        if (pSAppUtilTypeBase.isUtilModelDirty() && (bl || pSAppUtilTypeBase.getUtilModel() != null)) {
            iDataObject.set(FIELD_UTILMODEL, (Object)pSAppUtilTypeBase.getUtilModel());
        }
        if (pSAppUtilTypeBase.isUtilObjDirty() && (bl || pSAppUtilTypeBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSAppUtilTypeBase.getUtilObj());
        }
        if (pSAppUtilTypeBase.isUtilParamsDirty() && (bl || pSAppUtilTypeBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSAppUtilTypeBase.getUtilParams());
        }
        if (pSAppUtilTypeBase.isValidFlagDirty() && (bl || pSAppUtilTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppUtilTypeBase.getValidFlag());
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
        return PSAppUtilTypeBase.remove(this, n);
    }

    private static boolean remove(PSAppUtilTypeBase pSAppUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppUtilTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppUtilTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppUtilTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppUtilTypeBase.resetPSAppUtilTypeId();
                return true;
            }
            case 4: {
                pSAppUtilTypeBase.resetPSAppUtilTypeName();
                return true;
            }
            case 5: {
                pSAppUtilTypeBase.resetRegToAppFlag();
                return true;
            }
            case 6: {
                pSAppUtilTypeBase.resetTypeObj();
                return true;
            }
            case 7: {
                pSAppUtilTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSAppUtilTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSAppUtilTypeBase.resetUtilDesc();
                return true;
            }
            case 10: {
                pSAppUtilTypeBase.resetUtilModel();
                return true;
            }
            case 11: {
                pSAppUtilTypeBase.resetUtilObj();
                return true;
            }
            case 12: {
                pSAppUtilTypeBase.resetUtilParams();
                return true;
            }
            case 13: {
                pSAppUtilTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSAppUtilTypeBase getProxyEntity() {
        return this.proxyPSAppUtilTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppUtilTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppUtilTypeBase) {
            this.proxyPSAppUtilTypeBase = (PSAppUtilTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSAppUtilTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPUTILTYPEID, 3);
        fieldIndexMap.put(FIELD_PSAPPUTILTYPENAME, 4);
        fieldIndexMap.put(FIELD_REGTOAPPFLAG, 5);
        fieldIndexMap.put(FIELD_TYPEOBJ, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_UTILDESC, 9);
        fieldIndexMap.put(FIELD_UTILMODEL, 10);
        fieldIndexMap.put(FIELD_UTILOBJ, 11);
        fieldIndexMap.put(FIELD_UTILPARAMS, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

