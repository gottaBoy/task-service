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

public abstract class PSSysModelVerBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysModelVerBase.class);
    public static final String FIELD_ACTIVEFLAG = "ACTIVEFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATASQL = "DATASQL";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSQL = "MODELSQL";
    public static final String FIELD_MODELSQL2 = "MODELSQL2";
    public static final String FIELD_MODELSQL3 = "MODELSQL3";
    public static final String FIELD_MODELSQL4 = "MODELSQL4";
    public static final String FIELD_MODELVER = "MODELVER";
    public static final String FIELD_PSSYSMODELVERID = "PSSYSMODELVERID";
    public static final String FIELD_PSSYSMODELVERNAME = "PSSYSMODELVERNAME";
    public static final String FIELD_SYSTYPE = "SYSTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_ACTIVEFLAG = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DATASQL = 3;
    private static final int INDEX_DBTYPE = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MODELSQL = 6;
    private static final int INDEX_MODELSQL2 = 7;
    private static final int INDEX_MODELSQL3 = 8;
    private static final int INDEX_MODELSQL4 = 9;
    private static final int INDEX_MODELVER = 10;
    private static final int INDEX_PSSYSMODELVERID = 11;
    private static final int INDEX_PSSYSMODELVERNAME = 12;
    private static final int INDEX_SYSTYPE = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysModelVerBase proxyPSSysModelVerBase = null;
    private boolean activeflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datasqlDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelsqlDirtyFlag = false;
    private boolean modelsql2DirtyFlag = false;
    private boolean modelsql3DirtyFlag = false;
    private boolean modelsql4DirtyFlag = false;
    private boolean modelverDirtyFlag = false;
    private boolean pssysmodelveridDirtyFlag = false;
    private boolean pssysmodelvernameDirtyFlag = false;
    private boolean systypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="activeflag")
    private Integer activeflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datasql")
    private String datasql;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="memo")
    private String memo;
    @Column(name="modelsql")
    private String modelsql;
    @Column(name="modelsql2")
    private String modelsql2;
    @Column(name="modelsql3")
    private String modelsql3;
    @Column(name="modelsql4")
    private String modelsql4;
    @Column(name="modelver")
    private Integer modelver;
    @Column(name="pssysmodelverid")
    private String pssysmodelverid;
    @Column(name="pssysmodelvername")
    private String pssysmodelvername;
    @Column(name="systype")
    private String systype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setActiveFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActiveFlag(n);
            return;
        }
        this.activeflag = n;
        this.activeflagDirtyFlag = true;
    }

    public Integer getActiveFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActiveFlag();
        }
        return this.activeflag;
    }

    public boolean isActiveFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActiveFlagDirty();
        }
        return this.activeflagDirtyFlag;
    }

    public void resetActiveFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActiveFlag();
            return;
        }
        this.activeflagDirtyFlag = false;
        this.activeflag = null;
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

    public void setDataSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasql = string;
        this.datasqlDirtyFlag = true;
    }

    public String getDataSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSql();
        }
        return this.datasql;
    }

    public boolean isDataSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSqlDirty();
        }
        return this.datasqlDirtyFlag;
    }

    public void resetDataSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSql();
            return;
        }
        this.datasqlDirtyFlag = false;
        this.datasql = null;
    }

    public void setDBType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbtype = string;
        this.dbtypeDirtyFlag = true;
    }

    public String getDBType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBType();
        }
        return this.dbtype;
    }

    public boolean isDBTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBTypeDirty();
        }
        return this.dbtypeDirtyFlag;
    }

    public void resetDBType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBType();
            return;
        }
        this.dbtypeDirtyFlag = false;
        this.dbtype = null;
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

    public void setModelSql(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSql(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql = string;
        this.modelsqlDirtyFlag = true;
    }

    public String getModelSql() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSql();
        }
        return this.modelsql;
    }

    public boolean isModelSqlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSqlDirty();
        }
        return this.modelsqlDirtyFlag;
    }

    public void resetModelSql() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSql();
            return;
        }
        this.modelsqlDirtyFlag = false;
        this.modelsql = null;
    }

    public void setModelSql2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSql2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql2 = string;
        this.modelsql2DirtyFlag = true;
    }

    public String getModelSql2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSql2();
        }
        return this.modelsql2;
    }

    public boolean isModelSql2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSql2Dirty();
        }
        return this.modelsql2DirtyFlag;
    }

    public void resetModelSql2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSql2();
            return;
        }
        this.modelsql2DirtyFlag = false;
        this.modelsql2 = null;
    }

    public void setModelSql3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSql3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql3 = string;
        this.modelsql3DirtyFlag = true;
    }

    public String getModelSql3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSql3();
        }
        return this.modelsql3;
    }

    public boolean isModelSql3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSql3Dirty();
        }
        return this.modelsql3DirtyFlag;
    }

    public void resetModelSql3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSql3();
            return;
        }
        this.modelsql3DirtyFlag = false;
        this.modelsql3 = null;
    }

    public void setModelSql4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSql4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql4 = string;
        this.modelsql4DirtyFlag = true;
    }

    public String getModelSql4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSql4();
        }
        return this.modelsql4;
    }

    public boolean isModelSql4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSql4Dirty();
        }
        return this.modelsql4DirtyFlag;
    }

    public void resetModelSql4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSql4();
            return;
        }
        this.modelsql4DirtyFlag = false;
        this.modelsql4 = null;
    }

    public void setModelVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelVer(n);
            return;
        }
        this.modelver = n;
        this.modelverDirtyFlag = true;
    }

    public Integer getModelVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelVer();
        }
        return this.modelver;
    }

    public boolean isModelVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelVerDirty();
        }
        return this.modelverDirtyFlag;
    }

    public void resetModelVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelVer();
            return;
        }
        this.modelverDirtyFlag = false;
        this.modelver = null;
    }

    public void setPSSysModelVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelverid = string;
        this.pssysmodelveridDirtyFlag = true;
    }

    public String getPSSysModelVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelVerId();
        }
        return this.pssysmodelverid;
    }

    public boolean isPSSysModelVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelVerIdDirty();
        }
        return this.pssysmodelveridDirtyFlag;
    }

    public void resetPSSysModelVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelVerId();
            return;
        }
        this.pssysmodelveridDirtyFlag = false;
        this.pssysmodelverid = null;
    }

    public void setPSSysModelVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysModelVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmodelvername = string;
        this.pssysmodelvernameDirtyFlag = true;
    }

    public String getPSSysModelVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysModelVerName();
        }
        return this.pssysmodelvername;
    }

    public boolean isPSSysModelVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysModelVerNameDirty();
        }
        return this.pssysmodelvernameDirtyFlag;
    }

    public void resetPSSysModelVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysModelVerName();
            return;
        }
        this.pssysmodelvernameDirtyFlag = false;
        this.pssysmodelvername = null;
    }

    public void setSysType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.systype = string;
        this.systypeDirtyFlag = true;
    }

    public String getSysType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysType();
        }
        return this.systype;
    }

    public boolean isSysTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysTypeDirty();
        }
        return this.systypeDirtyFlag;
    }

    public void resetSysType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysType();
            return;
        }
        this.systypeDirtyFlag = false;
        this.systype = null;
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
        PSSysModelVerBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysModelVerBase pSSysModelVerBase) {
        pSSysModelVerBase.resetActiveFlag();
        pSSysModelVerBase.resetCreateDate();
        pSSysModelVerBase.resetCreateMan();
        pSSysModelVerBase.resetDataSql();
        pSSysModelVerBase.resetDBType();
        pSSysModelVerBase.resetMemo();
        pSSysModelVerBase.resetModelSql();
        pSSysModelVerBase.resetModelSql2();
        pSSysModelVerBase.resetModelSql3();
        pSSysModelVerBase.resetModelSql4();
        pSSysModelVerBase.resetModelVer();
        pSSysModelVerBase.resetPSSysModelVerId();
        pSSysModelVerBase.resetPSSysModelVerName();
        pSSysModelVerBase.resetSysType();
        pSSysModelVerBase.resetUpdateDate();
        pSSysModelVerBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActiveFlagDirty()) {
            hashMap.put(FIELD_ACTIVEFLAG, this.getActiveFlag());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataSqlDirty()) {
            hashMap.put(FIELD_DATASQL, this.getDataSql());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelSqlDirty()) {
            hashMap.put(FIELD_MODELSQL, this.getModelSql());
        }
        if (!bl || this.isModelSql2Dirty()) {
            hashMap.put(FIELD_MODELSQL2, this.getModelSql2());
        }
        if (!bl || this.isModelSql3Dirty()) {
            hashMap.put(FIELD_MODELSQL3, this.getModelSql3());
        }
        if (!bl || this.isModelSql4Dirty()) {
            hashMap.put(FIELD_MODELSQL4, this.getModelSql4());
        }
        if (!bl || this.isModelVerDirty()) {
            hashMap.put(FIELD_MODELVER, this.getModelVer());
        }
        if (!bl || this.isPSSysModelVerIdDirty()) {
            hashMap.put(FIELD_PSSYSMODELVERID, this.getPSSysModelVerId());
        }
        if (!bl || this.isPSSysModelVerNameDirty()) {
            hashMap.put(FIELD_PSSYSMODELVERNAME, this.getPSSysModelVerName());
        }
        if (!bl || this.isSysTypeDirty()) {
            hashMap.put(FIELD_SYSTYPE, this.getSysType());
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
        return PSSysModelVerBase.get(this, n);
    }

    private static Object get(PSSysModelVerBase pSSysModelVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelVerBase.getActiveFlag();
            }
            case 1: {
                return pSSysModelVerBase.getCreateDate();
            }
            case 2: {
                return pSSysModelVerBase.getCreateMan();
            }
            case 3: {
                return pSSysModelVerBase.getDataSql();
            }
            case 4: {
                return pSSysModelVerBase.getDBType();
            }
            case 5: {
                return pSSysModelVerBase.getMemo();
            }
            case 6: {
                return pSSysModelVerBase.getModelSql();
            }
            case 7: {
                return pSSysModelVerBase.getModelSql2();
            }
            case 8: {
                return pSSysModelVerBase.getModelSql3();
            }
            case 9: {
                return pSSysModelVerBase.getModelSql4();
            }
            case 10: {
                return pSSysModelVerBase.getModelVer();
            }
            case 11: {
                return pSSysModelVerBase.getPSSysModelVerId();
            }
            case 12: {
                return pSSysModelVerBase.getPSSysModelVerName();
            }
            case 13: {
                return pSSysModelVerBase.getSysType();
            }
            case 14: {
                return pSSysModelVerBase.getUpdateDate();
            }
            case 15: {
                return pSSysModelVerBase.getUpdateMan();
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
        PSSysModelVerBase.set(this, n, object);
    }

    private static void set(PSSysModelVerBase pSSysModelVerBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelVerBase.setActiveFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysModelVerBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysModelVerBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysModelVerBase.setDataSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysModelVerBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysModelVerBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysModelVerBase.setModelSql(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysModelVerBase.setModelSql2(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysModelVerBase.setModelSql3(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysModelVerBase.setModelSql4(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysModelVerBase.setModelVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysModelVerBase.setPSSysModelVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysModelVerBase.setPSSysModelVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysModelVerBase.setSysType(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysModelVerBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysModelVerBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysModelVerBase.isNull(this, n);
    }

    private static boolean isNull(PSSysModelVerBase pSSysModelVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelVerBase.getActiveFlag() == null;
            }
            case 1: {
                return pSSysModelVerBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysModelVerBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysModelVerBase.getDataSql() == null;
            }
            case 4: {
                return pSSysModelVerBase.getDBType() == null;
            }
            case 5: {
                return pSSysModelVerBase.getMemo() == null;
            }
            case 6: {
                return pSSysModelVerBase.getModelSql() == null;
            }
            case 7: {
                return pSSysModelVerBase.getModelSql2() == null;
            }
            case 8: {
                return pSSysModelVerBase.getModelSql3() == null;
            }
            case 9: {
                return pSSysModelVerBase.getModelSql4() == null;
            }
            case 10: {
                return pSSysModelVerBase.getModelVer() == null;
            }
            case 11: {
                return pSSysModelVerBase.getPSSysModelVerId() == null;
            }
            case 12: {
                return pSSysModelVerBase.getPSSysModelVerName() == null;
            }
            case 13: {
                return pSSysModelVerBase.getSysType() == null;
            }
            case 14: {
                return pSSysModelVerBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysModelVerBase.getUpdateMan() == null;
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
        return PSSysModelVerBase.contains(this, n);
    }

    private static boolean contains(PSSysModelVerBase pSSysModelVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysModelVerBase.isActiveFlagDirty();
            }
            case 1: {
                return pSSysModelVerBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysModelVerBase.isCreateManDirty();
            }
            case 3: {
                return pSSysModelVerBase.isDataSqlDirty();
            }
            case 4: {
                return pSSysModelVerBase.isDBTypeDirty();
            }
            case 5: {
                return pSSysModelVerBase.isMemoDirty();
            }
            case 6: {
                return pSSysModelVerBase.isModelSqlDirty();
            }
            case 7: {
                return pSSysModelVerBase.isModelSql2Dirty();
            }
            case 8: {
                return pSSysModelVerBase.isModelSql3Dirty();
            }
            case 9: {
                return pSSysModelVerBase.isModelSql4Dirty();
            }
            case 10: {
                return pSSysModelVerBase.isModelVerDirty();
            }
            case 11: {
                return pSSysModelVerBase.isPSSysModelVerIdDirty();
            }
            case 12: {
                return pSSysModelVerBase.isPSSysModelVerNameDirty();
            }
            case 13: {
                return pSSysModelVerBase.isSysTypeDirty();
            }
            case 14: {
                return pSSysModelVerBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysModelVerBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysModelVerBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysModelVerBase pSSysModelVerBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysModelVerBase.getActiveFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"activeflag", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getActiveFlag()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getDataSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasql", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getDataSql()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getDBType()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getModelSql() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getModelSql()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getModelSql2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql2", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getModelSql2()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getModelSql3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql3", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getModelSql3()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getModelSql4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql4", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getModelSql4()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getModelVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelver", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getModelVer()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getPSSysModelVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelverid", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getPSSysModelVerId()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getPSSysModelVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmodelvername", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getPSSysModelVerName()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getSysType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"systype", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getSysType()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysModelVerBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysModelVerBase.getJSONValue((Object)pSSysModelVerBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysModelVerBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysModelVerBase pSSysModelVerBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysModelVerBase.getActiveFlag() != null) {
            object = pSSysModelVerBase.getActiveFlag();
            xmlNode.setAttribute(FIELD_ACTIVEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelVerBase.getCreateDate() != null) {
            object = pSSysModelVerBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelVerBase.getCreateMan() != null) {
            object = pSSysModelVerBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getDataSql() != null) {
            object = pSSysModelVerBase.getDataSql();
            xmlNode.setAttribute(FIELD_DATASQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getDBType() != null) {
            object = pSSysModelVerBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getMemo() != null) {
            object = pSSysModelVerBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getModelSql() != null) {
            object = pSSysModelVerBase.getModelSql();
            xmlNode.setAttribute(FIELD_MODELSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getModelSql2() != null) {
            object = pSSysModelVerBase.getModelSql2();
            xmlNode.setAttribute(FIELD_MODELSQL2, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getModelSql3() != null) {
            object = pSSysModelVerBase.getModelSql3();
            xmlNode.setAttribute(FIELD_MODELSQL3, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getModelSql4() != null) {
            object = pSSysModelVerBase.getModelSql4();
            xmlNode.setAttribute(FIELD_MODELSQL4, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getModelVer() != null) {
            object = pSSysModelVerBase.getModelVer();
            xmlNode.setAttribute(FIELD_MODELVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysModelVerBase.getPSSysModelVerId() != null) {
            object = pSSysModelVerBase.getPSSysModelVerId();
            xmlNode.setAttribute(FIELD_PSSYSMODELVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getPSSysModelVerName() != null) {
            object = pSSysModelVerBase.getPSSysModelVerName();
            xmlNode.setAttribute(FIELD_PSSYSMODELVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getSysType() != null) {
            object = pSSysModelVerBase.getSysType();
            xmlNode.setAttribute(FIELD_SYSTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysModelVerBase.getUpdateDate() != null) {
            object = pSSysModelVerBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysModelVerBase.getUpdateMan() != null) {
            object = pSSysModelVerBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysModelVerBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysModelVerBase pSSysModelVerBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysModelVerBase.isActiveFlagDirty() && (bl || pSSysModelVerBase.getActiveFlag() != null)) {
            iDataObject.set(FIELD_ACTIVEFLAG, (Object)pSSysModelVerBase.getActiveFlag());
        }
        if (pSSysModelVerBase.isCreateDateDirty() && (bl || pSSysModelVerBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysModelVerBase.getCreateDate());
        }
        if (pSSysModelVerBase.isCreateManDirty() && (bl || pSSysModelVerBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysModelVerBase.getCreateMan());
        }
        if (pSSysModelVerBase.isDataSqlDirty() && (bl || pSSysModelVerBase.getDataSql() != null)) {
            iDataObject.set(FIELD_DATASQL, (Object)pSSysModelVerBase.getDataSql());
        }
        if (pSSysModelVerBase.isDBTypeDirty() && (bl || pSSysModelVerBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSSysModelVerBase.getDBType());
        }
        if (pSSysModelVerBase.isMemoDirty() && (bl || pSSysModelVerBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysModelVerBase.getMemo());
        }
        if (pSSysModelVerBase.isModelSqlDirty() && (bl || pSSysModelVerBase.getModelSql() != null)) {
            iDataObject.set(FIELD_MODELSQL, (Object)pSSysModelVerBase.getModelSql());
        }
        if (pSSysModelVerBase.isModelSql2Dirty() && (bl || pSSysModelVerBase.getModelSql2() != null)) {
            iDataObject.set(FIELD_MODELSQL2, (Object)pSSysModelVerBase.getModelSql2());
        }
        if (pSSysModelVerBase.isModelSql3Dirty() && (bl || pSSysModelVerBase.getModelSql3() != null)) {
            iDataObject.set(FIELD_MODELSQL3, (Object)pSSysModelVerBase.getModelSql3());
        }
        if (pSSysModelVerBase.isModelSql4Dirty() && (bl || pSSysModelVerBase.getModelSql4() != null)) {
            iDataObject.set(FIELD_MODELSQL4, (Object)pSSysModelVerBase.getModelSql4());
        }
        if (pSSysModelVerBase.isModelVerDirty() && (bl || pSSysModelVerBase.getModelVer() != null)) {
            iDataObject.set(FIELD_MODELVER, (Object)pSSysModelVerBase.getModelVer());
        }
        if (pSSysModelVerBase.isPSSysModelVerIdDirty() && (bl || pSSysModelVerBase.getPSSysModelVerId() != null)) {
            iDataObject.set(FIELD_PSSYSMODELVERID, (Object)pSSysModelVerBase.getPSSysModelVerId());
        }
        if (pSSysModelVerBase.isPSSysModelVerNameDirty() && (bl || pSSysModelVerBase.getPSSysModelVerName() != null)) {
            iDataObject.set(FIELD_PSSYSMODELVERNAME, (Object)pSSysModelVerBase.getPSSysModelVerName());
        }
        if (pSSysModelVerBase.isSysTypeDirty() && (bl || pSSysModelVerBase.getSysType() != null)) {
            iDataObject.set(FIELD_SYSTYPE, (Object)pSSysModelVerBase.getSysType());
        }
        if (pSSysModelVerBase.isUpdateDateDirty() && (bl || pSSysModelVerBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysModelVerBase.getUpdateDate());
        }
        if (pSSysModelVerBase.isUpdateManDirty() && (bl || pSSysModelVerBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysModelVerBase.getUpdateMan());
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
        return PSSysModelVerBase.remove(this, n);
    }

    private static boolean remove(PSSysModelVerBase pSSysModelVerBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysModelVerBase.resetActiveFlag();
                return true;
            }
            case 1: {
                pSSysModelVerBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysModelVerBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysModelVerBase.resetDataSql();
                return true;
            }
            case 4: {
                pSSysModelVerBase.resetDBType();
                return true;
            }
            case 5: {
                pSSysModelVerBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysModelVerBase.resetModelSql();
                return true;
            }
            case 7: {
                pSSysModelVerBase.resetModelSql2();
                return true;
            }
            case 8: {
                pSSysModelVerBase.resetModelSql3();
                return true;
            }
            case 9: {
                pSSysModelVerBase.resetModelSql4();
                return true;
            }
            case 10: {
                pSSysModelVerBase.resetModelVer();
                return true;
            }
            case 11: {
                pSSysModelVerBase.resetPSSysModelVerId();
                return true;
            }
            case 12: {
                pSSysModelVerBase.resetPSSysModelVerName();
                return true;
            }
            case 13: {
                pSSysModelVerBase.resetSysType();
                return true;
            }
            case 14: {
                pSSysModelVerBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysModelVerBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSSysModelVerBase getProxyEntity() {
        return this.proxyPSSysModelVerBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysModelVerBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysModelVerBase) {
            this.proxyPSSysModelVerBase = (PSSysModelVerBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSysModelVerService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIVEFLAG, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DATASQL, 3);
        fieldIndexMap.put(FIELD_DBTYPE, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MODELSQL, 6);
        fieldIndexMap.put(FIELD_MODELSQL2, 7);
        fieldIndexMap.put(FIELD_MODELSQL3, 8);
        fieldIndexMap.put(FIELD_MODELSQL4, 9);
        fieldIndexMap.put(FIELD_MODELVER, 10);
        fieldIndexMap.put(FIELD_PSSYSMODELVERID, 11);
        fieldIndexMap.put(FIELD_PSSYSMODELVERNAME, 12);
        fieldIndexMap.put(FIELD_SYSTYPE, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

