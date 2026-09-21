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
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubSysDMBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubSysDMBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATASQL = "DATASQL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELSQL = "MODELSQL";
    public static final String FIELD_MODELSQL2 = "MODELSQL2";
    public static final String FIELD_MODELSQL3 = "MODELSQL3";
    public static final String FIELD_MODELSQL4 = "MODELSQL4";
    public static final String FIELD_PSSUBSYSDMID = "PSSUBSYSDMID";
    public static final String FIELD_PSSUBSYSDMNAME = "PSSUBSYSDMNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DATASQL = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_MODELSQL = 4;
    private static final int INDEX_MODELSQL2 = 5;
    private static final int INDEX_MODELSQL3 = 6;
    private static final int INDEX_MODELSQL4 = 7;
    private static final int INDEX_PSSUBSYSDMID = 8;
    private static final int INDEX_PSSUBSYSDMNAME = 9;
    private static final int INDEX_PSSUBSYSID = 10;
    private static final int INDEX_PSSUBSYSNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubSysDMBase proxyPSSubSysDMBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datasqlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelsqlDirtyFlag = false;
    private boolean modelsql2DirtyFlag = false;
    private boolean modelsql3DirtyFlag = false;
    private boolean modelsql4DirtyFlag = false;
    private boolean pssubsysdmidDirtyFlag = false;
    private boolean pssubsysdmnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datasql")
    private String datasql;
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
    @Column(name="pssubsysdmid")
    private String pssubsysdmid;
    @Column(name="pssubsysdmname")
    private String pssubsysdmname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

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

    public void setDataSQL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataSQL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datasql = string;
        this.datasqlDirtyFlag = true;
    }

    public String getDataSQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataSQL();
        }
        return this.datasql;
    }

    public boolean isDataSQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataSQLDirty();
        }
        return this.datasqlDirtyFlag;
    }

    public void resetDataSQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataSQL();
            return;
        }
        this.datasqlDirtyFlag = false;
        this.datasql = null;
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

    public void setModelSQL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSQL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql = string;
        this.modelsqlDirtyFlag = true;
    }

    public String getModelSQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSQL();
        }
        return this.modelsql;
    }

    public boolean isModelSQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSQLDirty();
        }
        return this.modelsqlDirtyFlag;
    }

    public void resetModelSQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSQL();
            return;
        }
        this.modelsqlDirtyFlag = false;
        this.modelsql = null;
    }

    public void setModelSQL2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSQL2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql2 = string;
        this.modelsql2DirtyFlag = true;
    }

    public String getModelSQL2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSQL2();
        }
        return this.modelsql2;
    }

    public boolean isModelSQL2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSQL2Dirty();
        }
        return this.modelsql2DirtyFlag;
    }

    public void resetModelSQL2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSQL2();
            return;
        }
        this.modelsql2DirtyFlag = false;
        this.modelsql2 = null;
    }

    public void setModelSQL3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSQL3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql3 = string;
        this.modelsql3DirtyFlag = true;
    }

    public String getModelSQL3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSQL3();
        }
        return this.modelsql3;
    }

    public boolean isModelSQL3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSQL3Dirty();
        }
        return this.modelsql3DirtyFlag;
    }

    public void resetModelSQL3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSQL3();
            return;
        }
        this.modelsql3DirtyFlag = false;
        this.modelsql3 = null;
    }

    public void setModelSQL4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelSQL4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelsql4 = string;
        this.modelsql4DirtyFlag = true;
    }

    public String getModelSQL4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelSQL4();
        }
        return this.modelsql4;
    }

    public boolean isModelSQL4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelSQL4Dirty();
        }
        return this.modelsql4DirtyFlag;
    }

    public void resetModelSQL4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelSQL4();
            return;
        }
        this.modelsql4DirtyFlag = false;
        this.modelsql4 = null;
    }

    public void setPSSubSysDMId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysDMId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysdmid = string;
        this.pssubsysdmidDirtyFlag = true;
    }

    public String getPSSubSysDMId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysDMId();
        }
        return this.pssubsysdmid;
    }

    public boolean isPSSubSysDMIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysDMIdDirty();
        }
        return this.pssubsysdmidDirtyFlag;
    }

    public void resetPSSubSysDMId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysDMId();
            return;
        }
        this.pssubsysdmidDirtyFlag = false;
        this.pssubsysdmid = null;
    }

    public void setPSSubSysDMName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysDMName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysdmname = string;
        this.pssubsysdmnameDirtyFlag = true;
    }

    public String getPSSubSysDMName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysDMName();
        }
        return this.pssubsysdmname;
    }

    public boolean isPSSubSysDMNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysDMNameDirty();
        }
        return this.pssubsysdmnameDirtyFlag;
    }

    public void resetPSSubSysDMName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysDMName();
            return;
        }
        this.pssubsysdmnameDirtyFlag = false;
        this.pssubsysdmname = null;
    }

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
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
        PSSubSysDMBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubSysDMBase pSSubSysDMBase) {
        pSSubSysDMBase.resetCreateDate();
        pSSubSysDMBase.resetCreateMan();
        pSSubSysDMBase.resetDataSQL();
        pSSubSysDMBase.resetMemo();
        pSSubSysDMBase.resetModelSQL();
        pSSubSysDMBase.resetModelSQL2();
        pSSubSysDMBase.resetModelSQL3();
        pSSubSysDMBase.resetModelSQL4();
        pSSubSysDMBase.resetPSSubSysDMId();
        pSSubSysDMBase.resetPSSubSysDMName();
        pSSubSysDMBase.resetPSSubSysId();
        pSSubSysDMBase.resetPSSubSysName();
        pSSubSysDMBase.resetUpdateDate();
        pSSubSysDMBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataSQLDirty()) {
            hashMap.put(FIELD_DATASQL, this.getDataSQL());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelSQLDirty()) {
            hashMap.put(FIELD_MODELSQL, this.getModelSQL());
        }
        if (!bl || this.isModelSQL2Dirty()) {
            hashMap.put(FIELD_MODELSQL2, this.getModelSQL2());
        }
        if (!bl || this.isModelSQL3Dirty()) {
            hashMap.put(FIELD_MODELSQL3, this.getModelSQL3());
        }
        if (!bl || this.isModelSQL4Dirty()) {
            hashMap.put(FIELD_MODELSQL4, this.getModelSQL4());
        }
        if (!bl || this.isPSSubSysDMIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSDMID, this.getPSSubSysDMId());
        }
        if (!bl || this.isPSSubSysDMNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSDMNAME, this.getPSSubSysDMName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
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
        return PSSubSysDMBase.get(this, n);
    }

    private static Object get(PSSubSysDMBase pSSubSysDMBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysDMBase.getCreateDate();
            }
            case 1: {
                return pSSubSysDMBase.getCreateMan();
            }
            case 2: {
                return pSSubSysDMBase.getDataSQL();
            }
            case 3: {
                return pSSubSysDMBase.getMemo();
            }
            case 4: {
                return pSSubSysDMBase.getModelSQL();
            }
            case 5: {
                return pSSubSysDMBase.getModelSQL2();
            }
            case 6: {
                return pSSubSysDMBase.getModelSQL3();
            }
            case 7: {
                return pSSubSysDMBase.getModelSQL4();
            }
            case 8: {
                return pSSubSysDMBase.getPSSubSysDMId();
            }
            case 9: {
                return pSSubSysDMBase.getPSSubSysDMName();
            }
            case 10: {
                return pSSubSysDMBase.getPSSubSysId();
            }
            case 11: {
                return pSSubSysDMBase.getPSSubSysName();
            }
            case 12: {
                return pSSubSysDMBase.getUpdateDate();
            }
            case 13: {
                return pSSubSysDMBase.getUpdateMan();
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
        PSSubSysDMBase.set(this, n, object);
    }

    private static void set(PSSubSysDMBase pSSubSysDMBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysDMBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSubSysDMBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSubSysDMBase.setDataSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubSysDMBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubSysDMBase.setModelSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubSysDMBase.setModelSQL2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubSysDMBase.setModelSQL3(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubSysDMBase.setModelSQL4(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubSysDMBase.setPSSubSysDMId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubSysDMBase.setPSSubSysDMName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubSysDMBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubSysDMBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSubSysDMBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSubSysDMBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSubSysDMBase.isNull(this, n);
    }

    private static boolean isNull(PSSubSysDMBase pSSubSysDMBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysDMBase.getCreateDate() == null;
            }
            case 1: {
                return pSSubSysDMBase.getCreateMan() == null;
            }
            case 2: {
                return pSSubSysDMBase.getDataSQL() == null;
            }
            case 3: {
                return pSSubSysDMBase.getMemo() == null;
            }
            case 4: {
                return pSSubSysDMBase.getModelSQL() == null;
            }
            case 5: {
                return pSSubSysDMBase.getModelSQL2() == null;
            }
            case 6: {
                return pSSubSysDMBase.getModelSQL3() == null;
            }
            case 7: {
                return pSSubSysDMBase.getModelSQL4() == null;
            }
            case 8: {
                return pSSubSysDMBase.getPSSubSysDMId() == null;
            }
            case 9: {
                return pSSubSysDMBase.getPSSubSysDMName() == null;
            }
            case 10: {
                return pSSubSysDMBase.getPSSubSysId() == null;
            }
            case 11: {
                return pSSubSysDMBase.getPSSubSysName() == null;
            }
            case 12: {
                return pSSubSysDMBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSubSysDMBase.getUpdateMan() == null;
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
        return PSSubSysDMBase.contains(this, n);
    }

    private static boolean contains(PSSubSysDMBase pSSubSysDMBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubSysDMBase.isCreateDateDirty();
            }
            case 1: {
                return pSSubSysDMBase.isCreateManDirty();
            }
            case 2: {
                return pSSubSysDMBase.isDataSQLDirty();
            }
            case 3: {
                return pSSubSysDMBase.isMemoDirty();
            }
            case 4: {
                return pSSubSysDMBase.isModelSQLDirty();
            }
            case 5: {
                return pSSubSysDMBase.isModelSQL2Dirty();
            }
            case 6: {
                return pSSubSysDMBase.isModelSQL3Dirty();
            }
            case 7: {
                return pSSubSysDMBase.isModelSQL4Dirty();
            }
            case 8: {
                return pSSubSysDMBase.isPSSubSysDMIdDirty();
            }
            case 9: {
                return pSSubSysDMBase.isPSSubSysDMNameDirty();
            }
            case 10: {
                return pSSubSysDMBase.isPSSubSysIdDirty();
            }
            case 11: {
                return pSSubSysDMBase.isPSSubSysNameDirty();
            }
            case 12: {
                return pSSubSysDMBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSubSysDMBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubSysDMBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubSysDMBase pSSubSysDMBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubSysDMBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getDataSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datasql", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getDataSQL()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getModelSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getModelSQL()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getModelSQL2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql2", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getModelSQL2()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getModelSQL3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql3", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getModelSQL3()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getModelSQL4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelsql4", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getModelSQL4()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getPSSubSysDMId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysdmid", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getPSSubSysDMId()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getPSSubSysDMName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysdmname", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getPSSubSysDMName()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubSysDMBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubSysDMBase.getJSONValue((Object)pSSubSysDMBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubSysDMBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubSysDMBase pSSubSysDMBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubSysDMBase.getCreateDate() != null) {
            object = pSSubSysDMBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysDMBase.getCreateMan() != null) {
            object = pSSubSysDMBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getDataSQL() != null) {
            object = pSSubSysDMBase.getDataSQL();
            xmlNode.setAttribute(FIELD_DATASQL, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getMemo() != null) {
            object = pSSubSysDMBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getModelSQL() != null) {
            object = pSSubSysDMBase.getModelSQL();
            xmlNode.setAttribute(FIELD_MODELSQL, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getModelSQL2() != null) {
            object = pSSubSysDMBase.getModelSQL2();
            xmlNode.setAttribute(FIELD_MODELSQL2, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getModelSQL3() != null) {
            object = pSSubSysDMBase.getModelSQL3();
            xmlNode.setAttribute(FIELD_MODELSQL3, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getModelSQL4() != null) {
            object = pSSubSysDMBase.getModelSQL4();
            xmlNode.setAttribute(FIELD_MODELSQL4, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getPSSubSysDMId() != null) {
            object = pSSubSysDMBase.getPSSubSysDMId();
            xmlNode.setAttribute(FIELD_PSSUBSYSDMID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getPSSubSysDMName() != null) {
            object = pSSubSysDMBase.getPSSubSysDMName();
            xmlNode.setAttribute(FIELD_PSSUBSYSDMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getPSSubSysId() != null) {
            object = pSSubSysDMBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getPSSubSysName() != null) {
            object = pSSubSysDMBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubSysDMBase.getUpdateDate() != null) {
            object = pSSubSysDMBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubSysDMBase.getUpdateMan() != null) {
            object = pSSubSysDMBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubSysDMBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubSysDMBase pSSubSysDMBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubSysDMBase.isCreateDateDirty() && (bl || pSSubSysDMBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubSysDMBase.getCreateDate());
        }
        if (pSSubSysDMBase.isCreateManDirty() && (bl || pSSubSysDMBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubSysDMBase.getCreateMan());
        }
        if (pSSubSysDMBase.isDataSQLDirty() && (bl || pSSubSysDMBase.getDataSQL() != null)) {
            iDataObject.set(FIELD_DATASQL, (Object)pSSubSysDMBase.getDataSQL());
        }
        if (pSSubSysDMBase.isMemoDirty() && (bl || pSSubSysDMBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubSysDMBase.getMemo());
        }
        if (pSSubSysDMBase.isModelSQLDirty() && (bl || pSSubSysDMBase.getModelSQL() != null)) {
            iDataObject.set(FIELD_MODELSQL, (Object)pSSubSysDMBase.getModelSQL());
        }
        if (pSSubSysDMBase.isModelSQL2Dirty() && (bl || pSSubSysDMBase.getModelSQL2() != null)) {
            iDataObject.set(FIELD_MODELSQL2, (Object)pSSubSysDMBase.getModelSQL2());
        }
        if (pSSubSysDMBase.isModelSQL3Dirty() && (bl || pSSubSysDMBase.getModelSQL3() != null)) {
            iDataObject.set(FIELD_MODELSQL3, (Object)pSSubSysDMBase.getModelSQL3());
        }
        if (pSSubSysDMBase.isModelSQL4Dirty() && (bl || pSSubSysDMBase.getModelSQL4() != null)) {
            iDataObject.set(FIELD_MODELSQL4, (Object)pSSubSysDMBase.getModelSQL4());
        }
        if (pSSubSysDMBase.isPSSubSysDMIdDirty() && (bl || pSSubSysDMBase.getPSSubSysDMId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSDMID, (Object)pSSubSysDMBase.getPSSubSysDMId());
        }
        if (pSSubSysDMBase.isPSSubSysDMNameDirty() && (bl || pSSubSysDMBase.getPSSubSysDMName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSDMNAME, (Object)pSSubSysDMBase.getPSSubSysDMName());
        }
        if (pSSubSysDMBase.isPSSubSysIdDirty() && (bl || pSSubSysDMBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubSysDMBase.getPSSubSysId());
        }
        if (pSSubSysDMBase.isPSSubSysNameDirty() && (bl || pSSubSysDMBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubSysDMBase.getPSSubSysName());
        }
        if (pSSubSysDMBase.isUpdateDateDirty() && (bl || pSSubSysDMBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubSysDMBase.getUpdateDate());
        }
        if (pSSubSysDMBase.isUpdateManDirty() && (bl || pSSubSysDMBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubSysDMBase.getUpdateMan());
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
        return PSSubSysDMBase.remove(this, n);
    }

    private static boolean remove(PSSubSysDMBase pSSubSysDMBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubSysDMBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSubSysDMBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSubSysDMBase.resetDataSQL();
                return true;
            }
            case 3: {
                pSSubSysDMBase.resetMemo();
                return true;
            }
            case 4: {
                pSSubSysDMBase.resetModelSQL();
                return true;
            }
            case 5: {
                pSSubSysDMBase.resetModelSQL2();
                return true;
            }
            case 6: {
                pSSubSysDMBase.resetModelSQL3();
                return true;
            }
            case 7: {
                pSSubSysDMBase.resetModelSQL4();
                return true;
            }
            case 8: {
                pSSubSysDMBase.resetPSSubSysDMId();
                return true;
            }
            case 9: {
                pSSubSysDMBase.resetPSSubSysDMName();
                return true;
            }
            case 10: {
                pSSubSysDMBase.resetPSSubSysId();
                return true;
            }
            case 11: {
                pSSubSysDMBase.resetPSSubSysName();
                return true;
            }
            case 12: {
                pSSubSysDMBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSubSysDMBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet((IEntity)pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSubSysDMBase getProxyEntity() {
        return this.proxyPSSubSysDMBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubSysDMBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubSysDMBase) {
            this.proxyPSSubSysDMBase = (PSSubSysDMBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubSysDMService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DATASQL, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_MODELSQL, 4);
        fieldIndexMap.put(FIELD_MODELSQL2, 5);
        fieldIndexMap.put(FIELD_MODELSQL3, 6);
        fieldIndexMap.put(FIELD_MODELSQL4, 7);
        fieldIndexMap.put(FIELD_PSSUBSYSDMID, 8);
        fieldIndexMap.put(FIELD_PSSUBSYSDMNAME, 9);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 10);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

