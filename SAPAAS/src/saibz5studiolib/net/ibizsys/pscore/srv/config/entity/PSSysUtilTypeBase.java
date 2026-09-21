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

public abstract class PSSysUtilTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUtilTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSUTILTYPEID = "PSSYSUTILTYPEID";
    public static final String FIELD_PSSYSUTILTYPENAME = "PSSYSUTILTYPENAME";
    public static final String FIELD_REGTOSYSFLAG = "REGTOSYSFLAG";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_UTILDESC = "UTILDESC";
    public static final String FIELD_UTILMODEL = "UTILMODEL";
    public static final String FIELD_UTILOBJ = "UTILOBJ";
    public static final String FIELD_UTILPARAMS = "UTILPARAMS";
    public static final String FIELD_UTILRTPARAMS = "UTILRTOBJS";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSUTILTYPEID = 3;
    private static final int INDEX_PSSYSUTILTYPENAME = 4;
    private static final int INDEX_REGTOSYSFLAG = 5;
    private static final int INDEX_TYPEOBJ = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_UTILDESC = 9;
    private static final int INDEX_UTILMODEL = 10;
    private static final int INDEX_UTILOBJ = 11;
    private static final int INDEX_UTILPARAMS = 12;
    private static final int INDEX_UTILRTPARAMS = 13;
    private static final int INDEX_VALIDFLAG = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUtilTypeBase proxyPSSysUtilTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysutiltypeidDirtyFlag = false;
    private boolean pssysutiltypenameDirtyFlag = false;
    private boolean regtosysflagDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean utildescDirtyFlag = false;
    private boolean utilmodelDirtyFlag = false;
    private boolean utilobjDirtyFlag = false;
    private boolean utilparamsDirtyFlag = false;
    private boolean utilrtparamsDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysutiltypeid")
    private String pssysutiltypeid;
    @Column(name="pssysutiltypename")
    private String pssysutiltypename;
    @Column(name="regtosysflag")
    private Integer regtosysflag;
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
    @Column(name="utilrtparams")
    private String utilrtparams;
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

    public void setPSSysUtilTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutiltypeid = string;
        this.pssysutiltypeidDirtyFlag = true;
    }

    public String getPSSysUtilTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilTypeId();
        }
        return this.pssysutiltypeid;
    }

    public boolean isPSSysUtilTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilTypeIdDirty();
        }
        return this.pssysutiltypeidDirtyFlag;
    }

    public void resetPSSysUtilTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilTypeId();
            return;
        }
        this.pssysutiltypeidDirtyFlag = false;
        this.pssysutiltypeid = null;
    }

    public void setPSSysUtilTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUtilTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysutiltypename = string;
        this.pssysutiltypenameDirtyFlag = true;
    }

    public String getPSSysUtilTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUtilTypeName();
        }
        return this.pssysutiltypename;
    }

    public boolean isPSSysUtilTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUtilTypeNameDirty();
        }
        return this.pssysutiltypenameDirtyFlag;
    }

    public void resetPSSysUtilTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUtilTypeName();
            return;
        }
        this.pssysutiltypenameDirtyFlag = false;
        this.pssysutiltypename = null;
    }

    public void setRegToSysFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegToSysFlag(n);
            return;
        }
        this.regtosysflag = n;
        this.regtosysflagDirtyFlag = true;
    }

    public Integer getRegToSysFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegToSysFlag();
        }
        return this.regtosysflag;
    }

    public boolean isRegToSysFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegToSysFlagDirty();
        }
        return this.regtosysflagDirtyFlag;
    }

    public void resetRegToSysFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegToSysFlag();
            return;
        }
        this.regtosysflagDirtyFlag = false;
        this.regtosysflag = null;
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

    public void setUtilRTParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUtilRTParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.utilrtparams = string;
        this.utilrtparamsDirtyFlag = true;
    }

    public String getUtilRTParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUtilRTParams();
        }
        return this.utilrtparams;
    }

    public boolean isUtilRTParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUtilRTParamsDirty();
        }
        return this.utilrtparamsDirtyFlag;
    }

    public void resetUtilRTParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUtilRTParams();
            return;
        }
        this.utilrtparamsDirtyFlag = false;
        this.utilrtparams = null;
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
        PSSysUtilTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUtilTypeBase pSSysUtilTypeBase) {
        pSSysUtilTypeBase.resetCreateDate();
        pSSysUtilTypeBase.resetCreateMan();
        pSSysUtilTypeBase.resetMemo();
        pSSysUtilTypeBase.resetPSSysUtilTypeId();
        pSSysUtilTypeBase.resetPSSysUtilTypeName();
        pSSysUtilTypeBase.resetRegToSysFlag();
        pSSysUtilTypeBase.resetTypeObj();
        pSSysUtilTypeBase.resetUpdateDate();
        pSSysUtilTypeBase.resetUpdateMan();
        pSSysUtilTypeBase.resetUtilDesc();
        pSSysUtilTypeBase.resetUtilModel();
        pSSysUtilTypeBase.resetUtilObj();
        pSSysUtilTypeBase.resetUtilParams();
        pSSysUtilTypeBase.resetUtilRTParams();
        pSSysUtilTypeBase.resetValidFlag();
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
        if (!bl || this.isPSSysUtilTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSUTILTYPEID, this.getPSSysUtilTypeId());
        }
        if (!bl || this.isPSSysUtilTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSUTILTYPENAME, this.getPSSysUtilTypeName());
        }
        if (!bl || this.isRegToSysFlagDirty()) {
            hashMap.put(FIELD_REGTOSYSFLAG, this.getRegToSysFlag());
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
        if (!bl || this.isUtilRTParamsDirty()) {
            hashMap.put(FIELD_UTILRTPARAMS, this.getUtilRTParams());
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
        return PSSysUtilTypeBase.get(this, n);
    }

    private static Object get(PSSysUtilTypeBase pSSysUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilTypeBase.getCreateDate();
            }
            case 1: {
                return pSSysUtilTypeBase.getCreateMan();
            }
            case 2: {
                return pSSysUtilTypeBase.getMemo();
            }
            case 3: {
                return pSSysUtilTypeBase.getPSSysUtilTypeId();
            }
            case 4: {
                return pSSysUtilTypeBase.getPSSysUtilTypeName();
            }
            case 5: {
                return pSSysUtilTypeBase.getRegToSysFlag();
            }
            case 6: {
                return pSSysUtilTypeBase.getTypeObj();
            }
            case 7: {
                return pSSysUtilTypeBase.getUpdateDate();
            }
            case 8: {
                return pSSysUtilTypeBase.getUpdateMan();
            }
            case 9: {
                return pSSysUtilTypeBase.getUtilDesc();
            }
            case 10: {
                return pSSysUtilTypeBase.getUtilModel();
            }
            case 11: {
                return pSSysUtilTypeBase.getUtilObj();
            }
            case 12: {
                return pSSysUtilTypeBase.getUtilParams();
            }
            case 13: {
                return pSSysUtilTypeBase.getUtilRTParams();
            }
            case 14: {
                return pSSysUtilTypeBase.getValidFlag();
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
        PSSysUtilTypeBase.set(this, n, object);
    }

    private static void set(PSSysUtilTypeBase pSSysUtilTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUtilTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUtilTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUtilTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysUtilTypeBase.setPSSysUtilTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUtilTypeBase.setPSSysUtilTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUtilTypeBase.setRegToSysFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysUtilTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUtilTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysUtilTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUtilTypeBase.setUtilDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUtilTypeBase.setUtilModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUtilTypeBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUtilTypeBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUtilTypeBase.setUtilRTParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysUtilTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysUtilTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUtilTypeBase pSSysUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUtilTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUtilTypeBase.getMemo() == null;
            }
            case 3: {
                return pSSysUtilTypeBase.getPSSysUtilTypeId() == null;
            }
            case 4: {
                return pSSysUtilTypeBase.getPSSysUtilTypeName() == null;
            }
            case 5: {
                return pSSysUtilTypeBase.getRegToSysFlag() == null;
            }
            case 6: {
                return pSSysUtilTypeBase.getTypeObj() == null;
            }
            case 7: {
                return pSSysUtilTypeBase.getUpdateDate() == null;
            }
            case 8: {
                return pSSysUtilTypeBase.getUpdateMan() == null;
            }
            case 9: {
                return pSSysUtilTypeBase.getUtilDesc() == null;
            }
            case 10: {
                return pSSysUtilTypeBase.getUtilModel() == null;
            }
            case 11: {
                return pSSysUtilTypeBase.getUtilObj() == null;
            }
            case 12: {
                return pSSysUtilTypeBase.getUtilParams() == null;
            }
            case 13: {
                return pSSysUtilTypeBase.getUtilRTParams() == null;
            }
            case 14: {
                return pSSysUtilTypeBase.getValidFlag() == null;
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
        return PSSysUtilTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysUtilTypeBase pSSysUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUtilTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUtilTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUtilTypeBase.isMemoDirty();
            }
            case 3: {
                return pSSysUtilTypeBase.isPSSysUtilTypeIdDirty();
            }
            case 4: {
                return pSSysUtilTypeBase.isPSSysUtilTypeNameDirty();
            }
            case 5: {
                return pSSysUtilTypeBase.isRegToSysFlagDirty();
            }
            case 6: {
                return pSSysUtilTypeBase.isTypeObjDirty();
            }
            case 7: {
                return pSSysUtilTypeBase.isUpdateDateDirty();
            }
            case 8: {
                return pSSysUtilTypeBase.isUpdateManDirty();
            }
            case 9: {
                return pSSysUtilTypeBase.isUtilDescDirty();
            }
            case 10: {
                return pSSysUtilTypeBase.isUtilModelDirty();
            }
            case 11: {
                return pSSysUtilTypeBase.isUtilObjDirty();
            }
            case 12: {
                return pSSysUtilTypeBase.isUtilParamsDirty();
            }
            case 13: {
                return pSSysUtilTypeBase.isUtilRTParamsDirty();
            }
            case 14: {
                return pSSysUtilTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUtilTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUtilTypeBase pSSysUtilTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUtilTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getPSSysUtilTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutiltypeid", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getPSSysUtilTypeId()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getPSSysUtilTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysutiltypename", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getPSSysUtilTypeName()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getRegToSysFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regtosysflag", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getRegToSysFlag()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUtilDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utildesc", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUtilDesc()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUtilModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilmodel", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUtilModel()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getUtilRTParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilrtobjs", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getUtilRTParams()), (boolean)false);
        }
        if (bl || pSSysUtilTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysUtilTypeBase.getJSONValue((Object)pSSysUtilTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUtilTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUtilTypeBase pSSysUtilTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUtilTypeBase.getCreateDate() != null) {
            object = pSSysUtilTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUtilTypeBase.getCreateMan() != null) {
            object = pSSysUtilTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getMemo() != null) {
            object = pSSysUtilTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getPSSysUtilTypeId() != null) {
            object = pSSysUtilTypeBase.getPSSysUtilTypeId();
            xmlNode.setAttribute(FIELD_PSSYSUTILTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getPSSysUtilTypeName() != null) {
            object = pSSysUtilTypeBase.getPSSysUtilTypeName();
            xmlNode.setAttribute(FIELD_PSSYSUTILTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getRegToSysFlag() != null) {
            object = pSSysUtilTypeBase.getRegToSysFlag();
            xmlNode.setAttribute(FIELD_REGTOSYSFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUtilTypeBase.getTypeObj() != null) {
            object = pSSysUtilTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUpdateDate() != null) {
            object = pSSysUtilTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUtilTypeBase.getUpdateMan() != null) {
            object = pSSysUtilTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUtilDesc() != null) {
            object = pSSysUtilTypeBase.getUtilDesc();
            xmlNode.setAttribute(FIELD_UTILDESC, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUtilModel() != null) {
            object = pSSysUtilTypeBase.getUtilModel();
            xmlNode.setAttribute(FIELD_UTILMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUtilObj() != null) {
            object = pSSysUtilTypeBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUtilParams() != null) {
            object = pSSysUtilTypeBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getUtilRTParams() != null) {
            object = pSSysUtilTypeBase.getUtilRTParams();
            xmlNode.setAttribute("UTILRTPARAMS", object == null ? "" : (String)object);
        }
        if (bl || pSSysUtilTypeBase.getValidFlag() != null) {
            object = pSSysUtilTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUtilTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUtilTypeBase pSSysUtilTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUtilTypeBase.isCreateDateDirty() && (bl || pSSysUtilTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUtilTypeBase.getCreateDate());
        }
        if (pSSysUtilTypeBase.isCreateManDirty() && (bl || pSSysUtilTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUtilTypeBase.getCreateMan());
        }
        if (pSSysUtilTypeBase.isMemoDirty() && (bl || pSSysUtilTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUtilTypeBase.getMemo());
        }
        if (pSSysUtilTypeBase.isPSSysUtilTypeIdDirty() && (bl || pSSysUtilTypeBase.getPSSysUtilTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSUTILTYPEID, (Object)pSSysUtilTypeBase.getPSSysUtilTypeId());
        }
        if (pSSysUtilTypeBase.isPSSysUtilTypeNameDirty() && (bl || pSSysUtilTypeBase.getPSSysUtilTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSUTILTYPENAME, (Object)pSSysUtilTypeBase.getPSSysUtilTypeName());
        }
        if (pSSysUtilTypeBase.isRegToSysFlagDirty() && (bl || pSSysUtilTypeBase.getRegToSysFlag() != null)) {
            iDataObject.set(FIELD_REGTOSYSFLAG, (Object)pSSysUtilTypeBase.getRegToSysFlag());
        }
        if (pSSysUtilTypeBase.isTypeObjDirty() && (bl || pSSysUtilTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSSysUtilTypeBase.getTypeObj());
        }
        if (pSSysUtilTypeBase.isUpdateDateDirty() && (bl || pSSysUtilTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUtilTypeBase.getUpdateDate());
        }
        if (pSSysUtilTypeBase.isUpdateManDirty() && (bl || pSSysUtilTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUtilTypeBase.getUpdateMan());
        }
        if (pSSysUtilTypeBase.isUtilDescDirty() && (bl || pSSysUtilTypeBase.getUtilDesc() != null)) {
            iDataObject.set(FIELD_UTILDESC, (Object)pSSysUtilTypeBase.getUtilDesc());
        }
        if (pSSysUtilTypeBase.isUtilModelDirty() && (bl || pSSysUtilTypeBase.getUtilModel() != null)) {
            iDataObject.set(FIELD_UTILMODEL, (Object)pSSysUtilTypeBase.getUtilModel());
        }
        if (pSSysUtilTypeBase.isUtilObjDirty() && (bl || pSSysUtilTypeBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSSysUtilTypeBase.getUtilObj());
        }
        if (pSSysUtilTypeBase.isUtilParamsDirty() && (bl || pSSysUtilTypeBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSSysUtilTypeBase.getUtilParams());
        }
        if (pSSysUtilTypeBase.isUtilRTParamsDirty() && (bl || pSSysUtilTypeBase.getUtilRTParams() != null)) {
            iDataObject.set(FIELD_UTILRTPARAMS, (Object)pSSysUtilTypeBase.getUtilRTParams());
        }
        if (pSSysUtilTypeBase.isValidFlagDirty() && (bl || pSSysUtilTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysUtilTypeBase.getValidFlag());
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
        return PSSysUtilTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysUtilTypeBase pSSysUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUtilTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUtilTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUtilTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysUtilTypeBase.resetPSSysUtilTypeId();
                return true;
            }
            case 4: {
                pSSysUtilTypeBase.resetPSSysUtilTypeName();
                return true;
            }
            case 5: {
                pSSysUtilTypeBase.resetRegToSysFlag();
                return true;
            }
            case 6: {
                pSSysUtilTypeBase.resetTypeObj();
                return true;
            }
            case 7: {
                pSSysUtilTypeBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSSysUtilTypeBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSSysUtilTypeBase.resetUtilDesc();
                return true;
            }
            case 10: {
                pSSysUtilTypeBase.resetUtilModel();
                return true;
            }
            case 11: {
                pSSysUtilTypeBase.resetUtilObj();
                return true;
            }
            case 12: {
                pSSysUtilTypeBase.resetUtilParams();
                return true;
            }
            case 13: {
                pSSysUtilTypeBase.resetUtilRTParams();
                return true;
            }
            case 14: {
                pSSysUtilTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysUtilTypeBase getProxyEntity() {
        return this.proxyPSSysUtilTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUtilTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUtilTypeBase) {
            this.proxyPSSysUtilTypeBase = (PSSysUtilTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysUtilTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSUTILTYPEID, 3);
        fieldIndexMap.put(FIELD_PSSYSUTILTYPENAME, 4);
        fieldIndexMap.put(FIELD_REGTOSYSFLAG, 5);
        fieldIndexMap.put(FIELD_TYPEOBJ, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_UTILDESC, 9);
        fieldIndexMap.put(FIELD_UTILMODEL, 10);
        fieldIndexMap.put(FIELD_UTILOBJ, 11);
        fieldIndexMap.put(FIELD_UTILPARAMS, 12);
        fieldIndexMap.put(FIELD_UTILRTPARAMS, 13);
        fieldIndexMap.put(FIELD_VALIDFLAG, 14);
    }
}

