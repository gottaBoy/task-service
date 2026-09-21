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

public abstract class PSDEUtilTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUtilTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEUTILTYPEID = "PSDEUTILTYPEID";
    public static final String FIELD_PSDEUTILTYPENAME = "PSDEUTILTYPENAME";
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
    private static final int INDEX_PSDEUTILTYPEID = 3;
    private static final int INDEX_PSDEUTILTYPENAME = 4;
    private static final int INDEX_TYPEOBJ = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_UTILDESC = 8;
    private static final int INDEX_UTILMODEL = 9;
    private static final int INDEX_UTILOBJ = 10;
    private static final int INDEX_UTILPARAMS = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUtilTypeBase proxyPSDEUtilTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeutiltypeidDirtyFlag = false;
    private boolean psdeutiltypenameDirtyFlag = false;
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
    @Column(name="psdeutiltypeid")
    private String psdeutiltypeid;
    @Column(name="psdeutiltypename")
    private String psdeutiltypename;
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

    public void setPSDEUtilTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUtilTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeutiltypeid = string;
        this.psdeutiltypeidDirtyFlag = true;
    }

    public String getPSDEUtilTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUtilTypeId();
        }
        return this.psdeutiltypeid;
    }

    public boolean isPSDEUtilTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUtilTypeIdDirty();
        }
        return this.psdeutiltypeidDirtyFlag;
    }

    public void resetPSDEUtilTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUtilTypeId();
            return;
        }
        this.psdeutiltypeidDirtyFlag = false;
        this.psdeutiltypeid = null;
    }

    public void setPSDEUtilTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUtilTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeutiltypename = string;
        this.psdeutiltypenameDirtyFlag = true;
    }

    public String getPSDEUtilTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUtilTypeName();
        }
        return this.psdeutiltypename;
    }

    public boolean isPSDEUtilTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUtilTypeNameDirty();
        }
        return this.psdeutiltypenameDirtyFlag;
    }

    public void resetPSDEUtilTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUtilTypeName();
            return;
        }
        this.psdeutiltypenameDirtyFlag = false;
        this.psdeutiltypename = null;
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
        PSDEUtilTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUtilTypeBase pSDEUtilTypeBase) {
        pSDEUtilTypeBase.resetCreateDate();
        pSDEUtilTypeBase.resetCreateMan();
        pSDEUtilTypeBase.resetMemo();
        pSDEUtilTypeBase.resetPSDEUtilTypeId();
        pSDEUtilTypeBase.resetPSDEUtilTypeName();
        pSDEUtilTypeBase.resetTypeObj();
        pSDEUtilTypeBase.resetUpdateDate();
        pSDEUtilTypeBase.resetUpdateMan();
        pSDEUtilTypeBase.resetUtilDesc();
        pSDEUtilTypeBase.resetUtilModel();
        pSDEUtilTypeBase.resetUtilObj();
        pSDEUtilTypeBase.resetUtilParams();
        pSDEUtilTypeBase.resetValidFlag();
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
        if (!bl || this.isPSDEUtilTypeIdDirty()) {
            hashMap.put(FIELD_PSDEUTILTYPEID, this.getPSDEUtilTypeId());
        }
        if (!bl || this.isPSDEUtilTypeNameDirty()) {
            hashMap.put(FIELD_PSDEUTILTYPENAME, this.getPSDEUtilTypeName());
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
        return PSDEUtilTypeBase.get(this, n);
    }

    private static Object get(PSDEUtilTypeBase pSDEUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilTypeBase.getCreateDate();
            }
            case 1: {
                return pSDEUtilTypeBase.getCreateMan();
            }
            case 2: {
                return pSDEUtilTypeBase.getMemo();
            }
            case 3: {
                return pSDEUtilTypeBase.getPSDEUtilTypeId();
            }
            case 4: {
                return pSDEUtilTypeBase.getPSDEUtilTypeName();
            }
            case 5: {
                return pSDEUtilTypeBase.getTypeObj();
            }
            case 6: {
                return pSDEUtilTypeBase.getUpdateDate();
            }
            case 7: {
                return pSDEUtilTypeBase.getUpdateMan();
            }
            case 8: {
                return pSDEUtilTypeBase.getUtilDesc();
            }
            case 9: {
                return pSDEUtilTypeBase.getUtilModel();
            }
            case 10: {
                return pSDEUtilTypeBase.getUtilObj();
            }
            case 11: {
                return pSDEUtilTypeBase.getUtilParams();
            }
            case 12: {
                return pSDEUtilTypeBase.getValidFlag();
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
        PSDEUtilTypeBase.set(this, n, object);
    }

    private static void set(PSDEUtilTypeBase pSDEUtilTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUtilTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEUtilTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEUtilTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUtilTypeBase.setPSDEUtilTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUtilTypeBase.setPSDEUtilTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUtilTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUtilTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEUtilTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUtilTypeBase.setUtilDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUtilTypeBase.setUtilModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUtilTypeBase.setUtilObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUtilTypeBase.setUtilParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUtilTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEUtilTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUtilTypeBase pSDEUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEUtilTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEUtilTypeBase.getMemo() == null;
            }
            case 3: {
                return pSDEUtilTypeBase.getPSDEUtilTypeId() == null;
            }
            case 4: {
                return pSDEUtilTypeBase.getPSDEUtilTypeName() == null;
            }
            case 5: {
                return pSDEUtilTypeBase.getTypeObj() == null;
            }
            case 6: {
                return pSDEUtilTypeBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDEUtilTypeBase.getUpdateMan() == null;
            }
            case 8: {
                return pSDEUtilTypeBase.getUtilDesc() == null;
            }
            case 9: {
                return pSDEUtilTypeBase.getUtilModel() == null;
            }
            case 10: {
                return pSDEUtilTypeBase.getUtilObj() == null;
            }
            case 11: {
                return pSDEUtilTypeBase.getUtilParams() == null;
            }
            case 12: {
                return pSDEUtilTypeBase.getValidFlag() == null;
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
        return PSDEUtilTypeBase.contains(this, n);
    }

    private static boolean contains(PSDEUtilTypeBase pSDEUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUtilTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEUtilTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEUtilTypeBase.isMemoDirty();
            }
            case 3: {
                return pSDEUtilTypeBase.isPSDEUtilTypeIdDirty();
            }
            case 4: {
                return pSDEUtilTypeBase.isPSDEUtilTypeNameDirty();
            }
            case 5: {
                return pSDEUtilTypeBase.isTypeObjDirty();
            }
            case 6: {
                return pSDEUtilTypeBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDEUtilTypeBase.isUpdateManDirty();
            }
            case 8: {
                return pSDEUtilTypeBase.isUtilDescDirty();
            }
            case 9: {
                return pSDEUtilTypeBase.isUtilModelDirty();
            }
            case 10: {
                return pSDEUtilTypeBase.isUtilObjDirty();
            }
            case 11: {
                return pSDEUtilTypeBase.isUtilParamsDirty();
            }
            case 12: {
                return pSDEUtilTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUtilTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUtilTypeBase pSDEUtilTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUtilTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getPSDEUtilTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeutiltypeid", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getPSDEUtilTypeId()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getPSDEUtilTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeutiltypename", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getPSDEUtilTypeName()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUtilDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utildesc", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUtilDesc()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUtilModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilmodel", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUtilModel()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUtilObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilobj", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUtilObj()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getUtilParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"utilparams", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getUtilParams()), (boolean)false);
        }
        if (bl || pSDEUtilTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEUtilTypeBase.getJSONValue((Object)pSDEUtilTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUtilTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUtilTypeBase pSDEUtilTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUtilTypeBase.getCreateDate() != null) {
            object = pSDEUtilTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUtilTypeBase.getCreateMan() != null) {
            object = pSDEUtilTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getMemo() != null) {
            object = pSDEUtilTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getPSDEUtilTypeId() != null) {
            object = pSDEUtilTypeBase.getPSDEUtilTypeId();
            xmlNode.setAttribute(FIELD_PSDEUTILTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getPSDEUtilTypeName() != null) {
            object = pSDEUtilTypeBase.getPSDEUtilTypeName();
            xmlNode.setAttribute(FIELD_PSDEUTILTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getTypeObj() != null) {
            object = pSDEUtilTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getUpdateDate() != null) {
            object = pSDEUtilTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUtilTypeBase.getUpdateMan() != null) {
            object = pSDEUtilTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getUtilDesc() != null) {
            object = pSDEUtilTypeBase.getUtilDesc();
            xmlNode.setAttribute(FIELD_UTILDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getUtilModel() != null) {
            object = pSDEUtilTypeBase.getUtilModel();
            xmlNode.setAttribute(FIELD_UTILMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getUtilObj() != null) {
            object = pSDEUtilTypeBase.getUtilObj();
            xmlNode.setAttribute(FIELD_UTILOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getUtilParams() != null) {
            object = pSDEUtilTypeBase.getUtilParams();
            xmlNode.setAttribute(FIELD_UTILPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEUtilTypeBase.getValidFlag() != null) {
            object = pSDEUtilTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUtilTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUtilTypeBase pSDEUtilTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUtilTypeBase.isCreateDateDirty() && (bl || pSDEUtilTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUtilTypeBase.getCreateDate());
        }
        if (pSDEUtilTypeBase.isCreateManDirty() && (bl || pSDEUtilTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUtilTypeBase.getCreateMan());
        }
        if (pSDEUtilTypeBase.isMemoDirty() && (bl || pSDEUtilTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUtilTypeBase.getMemo());
        }
        if (pSDEUtilTypeBase.isPSDEUtilTypeIdDirty() && (bl || pSDEUtilTypeBase.getPSDEUtilTypeId() != null)) {
            iDataObject.set(FIELD_PSDEUTILTYPEID, (Object)pSDEUtilTypeBase.getPSDEUtilTypeId());
        }
        if (pSDEUtilTypeBase.isPSDEUtilTypeNameDirty() && (bl || pSDEUtilTypeBase.getPSDEUtilTypeName() != null)) {
            iDataObject.set(FIELD_PSDEUTILTYPENAME, (Object)pSDEUtilTypeBase.getPSDEUtilTypeName());
        }
        if (pSDEUtilTypeBase.isTypeObjDirty() && (bl || pSDEUtilTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSDEUtilTypeBase.getTypeObj());
        }
        if (pSDEUtilTypeBase.isUpdateDateDirty() && (bl || pSDEUtilTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUtilTypeBase.getUpdateDate());
        }
        if (pSDEUtilTypeBase.isUpdateManDirty() && (bl || pSDEUtilTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUtilTypeBase.getUpdateMan());
        }
        if (pSDEUtilTypeBase.isUtilDescDirty() && (bl || pSDEUtilTypeBase.getUtilDesc() != null)) {
            iDataObject.set(FIELD_UTILDESC, (Object)pSDEUtilTypeBase.getUtilDesc());
        }
        if (pSDEUtilTypeBase.isUtilModelDirty() && (bl || pSDEUtilTypeBase.getUtilModel() != null)) {
            iDataObject.set(FIELD_UTILMODEL, (Object)pSDEUtilTypeBase.getUtilModel());
        }
        if (pSDEUtilTypeBase.isUtilObjDirty() && (bl || pSDEUtilTypeBase.getUtilObj() != null)) {
            iDataObject.set(FIELD_UTILOBJ, (Object)pSDEUtilTypeBase.getUtilObj());
        }
        if (pSDEUtilTypeBase.isUtilParamsDirty() && (bl || pSDEUtilTypeBase.getUtilParams() != null)) {
            iDataObject.set(FIELD_UTILPARAMS, (Object)pSDEUtilTypeBase.getUtilParams());
        }
        if (pSDEUtilTypeBase.isValidFlagDirty() && (bl || pSDEUtilTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEUtilTypeBase.getValidFlag());
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
        return PSDEUtilTypeBase.remove(this, n);
    }

    private static boolean remove(PSDEUtilTypeBase pSDEUtilTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUtilTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEUtilTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEUtilTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEUtilTypeBase.resetPSDEUtilTypeId();
                return true;
            }
            case 4: {
                pSDEUtilTypeBase.resetPSDEUtilTypeName();
                return true;
            }
            case 5: {
                pSDEUtilTypeBase.resetTypeObj();
                return true;
            }
            case 6: {
                pSDEUtilTypeBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDEUtilTypeBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSDEUtilTypeBase.resetUtilDesc();
                return true;
            }
            case 9: {
                pSDEUtilTypeBase.resetUtilModel();
                return true;
            }
            case 10: {
                pSDEUtilTypeBase.resetUtilObj();
                return true;
            }
            case 11: {
                pSDEUtilTypeBase.resetUtilParams();
                return true;
            }
            case 12: {
                pSDEUtilTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDEUtilTypeBase getProxyEntity() {
        return this.proxyPSDEUtilTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUtilTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUtilTypeBase) {
            this.proxyPSDEUtilTypeBase = (PSDEUtilTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDEUtilTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEUTILTYPEID, 3);
        fieldIndexMap.put(FIELD_PSDEUTILTYPENAME, 4);
        fieldIndexMap.put(FIELD_TYPEOBJ, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_UTILDESC, 8);
        fieldIndexMap.put(FIELD_UTILMODEL, 9);
        fieldIndexMap.put(FIELD_UTILOBJ, 10);
        fieldIndexMap.put(FIELD_UTILPARAMS, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

