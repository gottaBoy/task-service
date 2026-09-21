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

public abstract class PSDepSysTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDepSysTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEPSYSTYPEID = "PSDEPSYSTYPEID";
    public static final String FIELD_PSDEPSYSTYPENAME = "PSDEPSYSTYPENAME";
    public static final String FIELD_SYSAPPOBJ = "SYSAPPOBJ";
    public static final String FIELD_SYSVEROBJ = "SYSVEROBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEPSYSTYPEID = 3;
    private static final int INDEX_PSDEPSYSTYPENAME = 4;
    private static final int INDEX_SYSAPPOBJ = 5;
    private static final int INDEX_SYSVEROBJ = 6;
    private static final int INDEX_TYPEOBJ = 7;
    private static final int INDEX_TYPEPARAMS = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_VALIDFLAG = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDepSysTypeBase proxyPSDepSysTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdepsystypeidDirtyFlag = false;
    private boolean psdepsystypenameDirtyFlag = false;
    private boolean sysappobjDirtyFlag = false;
    private boolean sysverobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdepsystypeid")
    private String psdepsystypeid;
    @Column(name="psdepsystypename")
    private String psdepsystypename;
    @Column(name="sysappobj")
    private String sysappobj;
    @Column(name="sysverobj")
    private String sysverobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typeparams")
    private String typeparams;
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

    public void setPSDepSysTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsystypeid = string;
        this.psdepsystypeidDirtyFlag = true;
    }

    public String getPSDepSysTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysTypeId();
        }
        return this.psdepsystypeid;
    }

    public boolean isPSDepSysTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysTypeIdDirty();
        }
        return this.psdepsystypeidDirtyFlag;
    }

    public void resetPSDepSysTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysTypeId();
            return;
        }
        this.psdepsystypeidDirtyFlag = false;
        this.psdepsystypeid = null;
    }

    public void setPSDepSysTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDepSysTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdepsystypename = string;
        this.psdepsystypenameDirtyFlag = true;
    }

    public String getPSDepSysTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDepSysTypeName();
        }
        return this.psdepsystypename;
    }

    public boolean isPSDepSysTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDepSysTypeNameDirty();
        }
        return this.psdepsystypenameDirtyFlag;
    }

    public void resetPSDepSysTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDepSysTypeName();
            return;
        }
        this.psdepsystypenameDirtyFlag = false;
        this.psdepsystypename = null;
    }

    public void setSysAppObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysAppObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysappobj = string;
        this.sysappobjDirtyFlag = true;
    }

    public String getSysAppObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysAppObj();
        }
        return this.sysappobj;
    }

    public boolean isSysAppObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysAppObjDirty();
        }
        return this.sysappobjDirtyFlag;
    }

    public void resetSysAppObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysAppObj();
            return;
        }
        this.sysappobjDirtyFlag = false;
        this.sysappobj = null;
    }

    public void setSysVerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysVerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysverobj = string;
        this.sysverobjDirtyFlag = true;
    }

    public String getSysVerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysVerObj();
        }
        return this.sysverobj;
    }

    public boolean isSysVerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysVerObjDirty();
        }
        return this.sysverobjDirtyFlag;
    }

    public void resetSysVerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysVerObj();
            return;
        }
        this.sysverobjDirtyFlag = false;
        this.sysverobj = null;
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

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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
        PSDepSysTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDepSysTypeBase pSDepSysTypeBase) {
        pSDepSysTypeBase.resetCreateDate();
        pSDepSysTypeBase.resetCreateMan();
        pSDepSysTypeBase.resetMemo();
        pSDepSysTypeBase.resetPSDepSysTypeId();
        pSDepSysTypeBase.resetPSDepSysTypeName();
        pSDepSysTypeBase.resetSysAppObj();
        pSDepSysTypeBase.resetSysVerObj();
        pSDepSysTypeBase.resetTypeObj();
        pSDepSysTypeBase.resetTypeParams();
        pSDepSysTypeBase.resetUpdateDate();
        pSDepSysTypeBase.resetUpdateMan();
        pSDepSysTypeBase.resetValidFlag();
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
        if (!bl || this.isPSDepSysTypeIdDirty()) {
            hashMap.put(FIELD_PSDEPSYSTYPEID, this.getPSDepSysTypeId());
        }
        if (!bl || this.isPSDepSysTypeNameDirty()) {
            hashMap.put(FIELD_PSDEPSYSTYPENAME, this.getPSDepSysTypeName());
        }
        if (!bl || this.isSysAppObjDirty()) {
            hashMap.put(FIELD_SYSAPPOBJ, this.getSysAppObj());
        }
        if (!bl || this.isSysVerObjDirty()) {
            hashMap.put(FIELD_SYSVEROBJ, this.getSysVerObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
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
        return PSDepSysTypeBase.get(this, n);
    }

    private static Object get(PSDepSysTypeBase pSDepSysTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysTypeBase.getCreateDate();
            }
            case 1: {
                return pSDepSysTypeBase.getCreateMan();
            }
            case 2: {
                return pSDepSysTypeBase.getMemo();
            }
            case 3: {
                return pSDepSysTypeBase.getPSDepSysTypeId();
            }
            case 4: {
                return pSDepSysTypeBase.getPSDepSysTypeName();
            }
            case 5: {
                return pSDepSysTypeBase.getSysAppObj();
            }
            case 6: {
                return pSDepSysTypeBase.getSysVerObj();
            }
            case 7: {
                return pSDepSysTypeBase.getTypeObj();
            }
            case 8: {
                return pSDepSysTypeBase.getTypeParams();
            }
            case 9: {
                return pSDepSysTypeBase.getUpdateDate();
            }
            case 10: {
                return pSDepSysTypeBase.getUpdateMan();
            }
            case 11: {
                return pSDepSysTypeBase.getValidFlag();
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
        PSDepSysTypeBase.set(this, n, object);
    }

    private static void set(PSDepSysTypeBase pSDepSysTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDepSysTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDepSysTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDepSysTypeBase.setPSDepSysTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDepSysTypeBase.setPSDepSysTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDepSysTypeBase.setSysAppObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDepSysTypeBase.setSysVerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDepSysTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDepSysTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDepSysTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDepSysTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDepSysTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDepSysTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSDepSysTypeBase pSDepSysTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDepSysTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDepSysTypeBase.getMemo() == null;
            }
            case 3: {
                return pSDepSysTypeBase.getPSDepSysTypeId() == null;
            }
            case 4: {
                return pSDepSysTypeBase.getPSDepSysTypeName() == null;
            }
            case 5: {
                return pSDepSysTypeBase.getSysAppObj() == null;
            }
            case 6: {
                return pSDepSysTypeBase.getSysVerObj() == null;
            }
            case 7: {
                return pSDepSysTypeBase.getTypeObj() == null;
            }
            case 8: {
                return pSDepSysTypeBase.getTypeParams() == null;
            }
            case 9: {
                return pSDepSysTypeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDepSysTypeBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDepSysTypeBase.getValidFlag() == null;
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
        return PSDepSysTypeBase.contains(this, n);
    }

    private static boolean contains(PSDepSysTypeBase pSDepSysTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDepSysTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDepSysTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSDepSysTypeBase.isMemoDirty();
            }
            case 3: {
                return pSDepSysTypeBase.isPSDepSysTypeIdDirty();
            }
            case 4: {
                return pSDepSysTypeBase.isPSDepSysTypeNameDirty();
            }
            case 5: {
                return pSDepSysTypeBase.isSysAppObjDirty();
            }
            case 6: {
                return pSDepSysTypeBase.isSysVerObjDirty();
            }
            case 7: {
                return pSDepSysTypeBase.isTypeObjDirty();
            }
            case 8: {
                return pSDepSysTypeBase.isTypeParamsDirty();
            }
            case 9: {
                return pSDepSysTypeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDepSysTypeBase.isUpdateManDirty();
            }
            case 11: {
                return pSDepSysTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDepSysTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDepSysTypeBase pSDepSysTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDepSysTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getPSDepSysTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsystypeid", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getPSDepSysTypeId()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getPSDepSysTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdepsystypename", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getPSDepSysTypeName()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getSysAppObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysappobj", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getSysAppObj()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getSysVerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysverobj", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getSysVerObj()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDepSysTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDepSysTypeBase.getJSONValue((Object)pSDepSysTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDepSysTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDepSysTypeBase pSDepSysTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDepSysTypeBase.getCreateDate() != null) {
            object = pSDepSysTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysTypeBase.getCreateMan() != null) {
            object = pSDepSysTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getMemo() != null) {
            object = pSDepSysTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getPSDepSysTypeId() != null) {
            object = pSDepSysTypeBase.getPSDepSysTypeId();
            xmlNode.setAttribute(FIELD_PSDEPSYSTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getPSDepSysTypeName() != null) {
            object = pSDepSysTypeBase.getPSDepSysTypeName();
            xmlNode.setAttribute(FIELD_PSDEPSYSTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getSysAppObj() != null) {
            object = pSDepSysTypeBase.getSysAppObj();
            xmlNode.setAttribute(FIELD_SYSAPPOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getSysVerObj() != null) {
            object = pSDepSysTypeBase.getSysVerObj();
            xmlNode.setAttribute(FIELD_SYSVEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getTypeObj() != null) {
            object = pSDepSysTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getTypeParams() != null) {
            object = pSDepSysTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getUpdateDate() != null) {
            object = pSDepSysTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDepSysTypeBase.getUpdateMan() != null) {
            object = pSDepSysTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDepSysTypeBase.getValidFlag() != null) {
            object = pSDepSysTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDepSysTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDepSysTypeBase pSDepSysTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDepSysTypeBase.isCreateDateDirty() && (bl || pSDepSysTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDepSysTypeBase.getCreateDate());
        }
        if (pSDepSysTypeBase.isCreateManDirty() && (bl || pSDepSysTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDepSysTypeBase.getCreateMan());
        }
        if (pSDepSysTypeBase.isMemoDirty() && (bl || pSDepSysTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDepSysTypeBase.getMemo());
        }
        if (pSDepSysTypeBase.isPSDepSysTypeIdDirty() && (bl || pSDepSysTypeBase.getPSDepSysTypeId() != null)) {
            iDataObject.set(FIELD_PSDEPSYSTYPEID, (Object)pSDepSysTypeBase.getPSDepSysTypeId());
        }
        if (pSDepSysTypeBase.isPSDepSysTypeNameDirty() && (bl || pSDepSysTypeBase.getPSDepSysTypeName() != null)) {
            iDataObject.set(FIELD_PSDEPSYSTYPENAME, (Object)pSDepSysTypeBase.getPSDepSysTypeName());
        }
        if (pSDepSysTypeBase.isSysAppObjDirty() && (bl || pSDepSysTypeBase.getSysAppObj() != null)) {
            iDataObject.set(FIELD_SYSAPPOBJ, (Object)pSDepSysTypeBase.getSysAppObj());
        }
        if (pSDepSysTypeBase.isSysVerObjDirty() && (bl || pSDepSysTypeBase.getSysVerObj() != null)) {
            iDataObject.set(FIELD_SYSVEROBJ, (Object)pSDepSysTypeBase.getSysVerObj());
        }
        if (pSDepSysTypeBase.isTypeObjDirty() && (bl || pSDepSysTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSDepSysTypeBase.getTypeObj());
        }
        if (pSDepSysTypeBase.isTypeParamsDirty() && (bl || pSDepSysTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSDepSysTypeBase.getTypeParams());
        }
        if (pSDepSysTypeBase.isUpdateDateDirty() && (bl || pSDepSysTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDepSysTypeBase.getUpdateDate());
        }
        if (pSDepSysTypeBase.isUpdateManDirty() && (bl || pSDepSysTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDepSysTypeBase.getUpdateMan());
        }
        if (pSDepSysTypeBase.isValidFlagDirty() && (bl || pSDepSysTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDepSysTypeBase.getValidFlag());
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
        return PSDepSysTypeBase.remove(this, n);
    }

    private static boolean remove(PSDepSysTypeBase pSDepSysTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDepSysTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDepSysTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDepSysTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSDepSysTypeBase.resetPSDepSysTypeId();
                return true;
            }
            case 4: {
                pSDepSysTypeBase.resetPSDepSysTypeName();
                return true;
            }
            case 5: {
                pSDepSysTypeBase.resetSysAppObj();
                return true;
            }
            case 6: {
                pSDepSysTypeBase.resetSysVerObj();
                return true;
            }
            case 7: {
                pSDepSysTypeBase.resetTypeObj();
                return true;
            }
            case 8: {
                pSDepSysTypeBase.resetTypeParams();
                return true;
            }
            case 9: {
                pSDepSysTypeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDepSysTypeBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDepSysTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDepSysTypeBase getProxyEntity() {
        return this.proxyPSDepSysTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDepSysTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDepSysTypeBase) {
            this.proxyPSDepSysTypeBase = (PSDepSysTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSDepSysTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEPSYSTYPEID, 3);
        fieldIndexMap.put(FIELD_PSDEPSYSTYPENAME, 4);
        fieldIndexMap.put(FIELD_SYSAPPOBJ, 5);
        fieldIndexMap.put(FIELD_SYSVEROBJ, 6);
        fieldIndexMap.put(FIELD_TYPEOBJ, 7);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_VALIDFLAG, 11);
    }
}

