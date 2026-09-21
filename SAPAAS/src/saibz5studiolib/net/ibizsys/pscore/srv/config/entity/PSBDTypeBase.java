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

public abstract class PSBDTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSBDTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEDQENGOBJ = "DEDQENGOBJ";
    public static final String FIELD_DEDQPUBOBJ = "DEDQPUBOBJ";
    public static final String FIELD_DEDSPUBOBJ = "DEDSPUBOBJ";
    public static final String FIELD_HIBDIALECT = "HIBDIALECT";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_INSTALLPATH = "INSTALLPATH";
    public static final String FIELD_JDBCDIALECT = "JDBCDIALECT";
    public static final String FIELD_JDBCDRIVERNAME = "JDBCDRIVERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSBDTYPEID = "PSBDTYPEID";
    public static final String FIELD_PSBDTYPENAME = "PSBDTYPENAME";
    public static final String FIELD_SQLQUERY = "SQLQUERY";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEDQENGOBJ = 2;
    private static final int INDEX_DEDQPUBOBJ = 3;
    private static final int INDEX_DEDSPUBOBJ = 4;
    private static final int INDEX_HIBDIALECT = 5;
    private static final int INDEX_ICONPATH = 6;
    private static final int INDEX_INSTALLPATH = 7;
    private static final int INDEX_JDBCDIALECT = 8;
    private static final int INDEX_JDBCDRIVERNAME = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_PSBDTYPEID = 11;
    private static final int INDEX_PSBDTYPENAME = 12;
    private static final int INDEX_SQLQUERY = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSBDTypeBase proxyPSBDTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dedqengobjDirtyFlag = false;
    private boolean dedqpubobjDirtyFlag = false;
    private boolean dedspubobjDirtyFlag = false;
    private boolean hibdialectDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean installpathDirtyFlag = false;
    private boolean jdbcdialectDirtyFlag = false;
    private boolean jdbcdrivernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psbdtypeidDirtyFlag = false;
    private boolean psbdtypenameDirtyFlag = false;
    private boolean sqlqueryDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dedqengobj")
    private String dedqengobj;
    @Column(name="dedqpubobj")
    private String dedqpubobj;
    @Column(name="dedspubobj")
    private String dedspubobj;
    @Column(name="hibdialect")
    private String hibdialect;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="installpath")
    private String installpath;
    @Column(name="jdbcdialect")
    private String jdbcdialect;
    @Column(name="jdbcdrivername")
    private String jdbcdrivername;
    @Column(name="memo")
    private String memo;
    @Column(name="psbdtypeid")
    private String psbdtypeid;
    @Column(name="psbdtypename")
    private String psbdtypename;
    @Column(name="sqlquery")
    private Integer sqlquery;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setDEDQEngObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDQEngObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedqengobj = string;
        this.dedqengobjDirtyFlag = true;
    }

    public String getDEDQEngObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDQEngObj();
        }
        return this.dedqengobj;
    }

    public boolean isDEDQEngObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDQEngObjDirty();
        }
        return this.dedqengobjDirtyFlag;
    }

    public void resetDEDQEngObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDQEngObj();
            return;
        }
        this.dedqengobjDirtyFlag = false;
        this.dedqengobj = null;
    }

    public void setDEDQPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDQPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedqpubobj = string;
        this.dedqpubobjDirtyFlag = true;
    }

    public String getDEDQPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDQPubObj();
        }
        return this.dedqpubobj;
    }

    public boolean isDEDQPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDQPubObjDirty();
        }
        return this.dedqpubobjDirtyFlag;
    }

    public void resetDEDQPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDQPubObj();
            return;
        }
        this.dedqpubobjDirtyFlag = false;
        this.dedqpubobj = null;
    }

    public void setDEDSPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEDSPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dedspubobj = string;
        this.dedspubobjDirtyFlag = true;
    }

    public String getDEDSPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEDSPubObj();
        }
        return this.dedspubobj;
    }

    public boolean isDEDSPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEDSPubObjDirty();
        }
        return this.dedspubobjDirtyFlag;
    }

    public void resetDEDSPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEDSPubObj();
            return;
        }
        this.dedspubobjDirtyFlag = false;
        this.dedspubobj = null;
    }

    public void setHibDialect(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHibDialect(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.hibdialect = string;
        this.hibdialectDirtyFlag = true;
    }

    public String getHibDialect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHibDialect();
        }
        return this.hibdialect;
    }

    public boolean isHibDialectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHibDialectDirty();
        }
        return this.hibdialectDirtyFlag;
    }

    public void resetHibDialect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHibDialect();
            return;
        }
        this.hibdialectDirtyFlag = false;
        this.hibdialect = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setInstallPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstallPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.installpath = string;
        this.installpathDirtyFlag = true;
    }

    public String getInstallPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstallPath();
        }
        return this.installpath;
    }

    public boolean isInstallPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstallPathDirty();
        }
        return this.installpathDirtyFlag;
    }

    public void resetInstallPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstallPath();
            return;
        }
        this.installpathDirtyFlag = false;
        this.installpath = null;
    }

    public void setJdbcDialect(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJdbcDialect(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jdbcdialect = string;
        this.jdbcdialectDirtyFlag = true;
    }

    public String getJdbcDialect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJdbcDialect();
        }
        return this.jdbcdialect;
    }

    public boolean isJdbcDialectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJdbcDialectDirty();
        }
        return this.jdbcdialectDirtyFlag;
    }

    public void resetJdbcDialect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJdbcDialect();
            return;
        }
        this.jdbcdialectDirtyFlag = false;
        this.jdbcdialect = null;
    }

    public void setJdbcDriverName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJdbcDriverName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jdbcdrivername = string;
        this.jdbcdrivernameDirtyFlag = true;
    }

    public String getJdbcDriverName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJdbcDriverName();
        }
        return this.jdbcdrivername;
    }

    public boolean isJdbcDriverNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJdbcDriverNameDirty();
        }
        return this.jdbcdrivernameDirtyFlag;
    }

    public void resetJdbcDriverName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJdbcDriverName();
            return;
        }
        this.jdbcdrivernameDirtyFlag = false;
        this.jdbcdrivername = null;
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

    public void setPSBDTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdtypeid = string;
        this.psbdtypeidDirtyFlag = true;
    }

    public String getPSBDTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDTypeId();
        }
        return this.psbdtypeid;
    }

    public boolean isPSBDTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDTypeIdDirty();
        }
        return this.psbdtypeidDirtyFlag;
    }

    public void resetPSBDTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDTypeId();
            return;
        }
        this.psbdtypeidDirtyFlag = false;
        this.psbdtypeid = null;
    }

    public void setPSBDTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSBDTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psbdtypename = string;
        this.psbdtypenameDirtyFlag = true;
    }

    public String getPSBDTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSBDTypeName();
        }
        return this.psbdtypename;
    }

    public boolean isPSBDTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSBDTypeNameDirty();
        }
        return this.psbdtypenameDirtyFlag;
    }

    public void resetPSBDTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSBDTypeName();
            return;
        }
        this.psbdtypenameDirtyFlag = false;
        this.psbdtypename = null;
    }

    public void setSQLQuery(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSQLQuery(n);
            return;
        }
        this.sqlquery = n;
        this.sqlqueryDirtyFlag = true;
    }

    public Integer getSQLQuery() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSQLQuery();
        }
        return this.sqlquery;
    }

    public boolean isSQLQueryDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSQLQueryDirty();
        }
        return this.sqlqueryDirtyFlag;
    }

    public void resetSQLQuery() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSQLQuery();
            return;
        }
        this.sqlqueryDirtyFlag = false;
        this.sqlquery = null;
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
        PSBDTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSBDTypeBase pSBDTypeBase) {
        pSBDTypeBase.resetCreateDate();
        pSBDTypeBase.resetCreateMan();
        pSBDTypeBase.resetDEDQEngObj();
        pSBDTypeBase.resetDEDQPubObj();
        pSBDTypeBase.resetDEDSPubObj();
        pSBDTypeBase.resetHibDialect();
        pSBDTypeBase.resetIconPath();
        pSBDTypeBase.resetInstallPath();
        pSBDTypeBase.resetJdbcDialect();
        pSBDTypeBase.resetJdbcDriverName();
        pSBDTypeBase.resetMemo();
        pSBDTypeBase.resetPSBDTypeId();
        pSBDTypeBase.resetPSBDTypeName();
        pSBDTypeBase.resetSQLQuery();
        pSBDTypeBase.resetUpdateDate();
        pSBDTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDEDQEngObjDirty()) {
            hashMap.put(FIELD_DEDQENGOBJ, this.getDEDQEngObj());
        }
        if (!bl || this.isDEDQPubObjDirty()) {
            hashMap.put(FIELD_DEDQPUBOBJ, this.getDEDQPubObj());
        }
        if (!bl || this.isDEDSPubObjDirty()) {
            hashMap.put(FIELD_DEDSPUBOBJ, this.getDEDSPubObj());
        }
        if (!bl || this.isHibDialectDirty()) {
            hashMap.put(FIELD_HIBDIALECT, this.getHibDialect());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isInstallPathDirty()) {
            hashMap.put(FIELD_INSTALLPATH, this.getInstallPath());
        }
        if (!bl || this.isJdbcDialectDirty()) {
            hashMap.put(FIELD_JDBCDIALECT, this.getJdbcDialect());
        }
        if (!bl || this.isJdbcDriverNameDirty()) {
            hashMap.put(FIELD_JDBCDRIVERNAME, this.getJdbcDriverName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSBDTypeIdDirty()) {
            hashMap.put(FIELD_PSBDTYPEID, this.getPSBDTypeId());
        }
        if (!bl || this.isPSBDTypeNameDirty()) {
            hashMap.put(FIELD_PSBDTYPENAME, this.getPSBDTypeName());
        }
        if (!bl || this.isSQLQueryDirty()) {
            hashMap.put(FIELD_SQLQUERY, this.getSQLQuery());
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
        return PSBDTypeBase.get(this, n);
    }

    private static Object get(PSBDTypeBase pSBDTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDTypeBase.getCreateDate();
            }
            case 1: {
                return pSBDTypeBase.getCreateMan();
            }
            case 2: {
                return pSBDTypeBase.getDEDQEngObj();
            }
            case 3: {
                return pSBDTypeBase.getDEDQPubObj();
            }
            case 4: {
                return pSBDTypeBase.getDEDSPubObj();
            }
            case 5: {
                return pSBDTypeBase.getHibDialect();
            }
            case 6: {
                return pSBDTypeBase.getIconPath();
            }
            case 7: {
                return pSBDTypeBase.getInstallPath();
            }
            case 8: {
                return pSBDTypeBase.getJdbcDialect();
            }
            case 9: {
                return pSBDTypeBase.getJdbcDriverName();
            }
            case 10: {
                return pSBDTypeBase.getMemo();
            }
            case 11: {
                return pSBDTypeBase.getPSBDTypeId();
            }
            case 12: {
                return pSBDTypeBase.getPSBDTypeName();
            }
            case 13: {
                return pSBDTypeBase.getSQLQuery();
            }
            case 14: {
                return pSBDTypeBase.getUpdateDate();
            }
            case 15: {
                return pSBDTypeBase.getUpdateMan();
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
        PSBDTypeBase.set(this, n, object);
    }

    private static void set(PSBDTypeBase pSBDTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSBDTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSBDTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSBDTypeBase.setDEDQEngObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSBDTypeBase.setDEDQPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSBDTypeBase.setDEDSPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSBDTypeBase.setHibDialect(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSBDTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSBDTypeBase.setInstallPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSBDTypeBase.setJdbcDialect(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSBDTypeBase.setJdbcDriverName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSBDTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSBDTypeBase.setPSBDTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSBDTypeBase.setPSBDTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSBDTypeBase.setSQLQuery(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSBDTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSBDTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSBDTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSBDTypeBase pSBDTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSBDTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSBDTypeBase.getDEDQEngObj() == null;
            }
            case 3: {
                return pSBDTypeBase.getDEDQPubObj() == null;
            }
            case 4: {
                return pSBDTypeBase.getDEDSPubObj() == null;
            }
            case 5: {
                return pSBDTypeBase.getHibDialect() == null;
            }
            case 6: {
                return pSBDTypeBase.getIconPath() == null;
            }
            case 7: {
                return pSBDTypeBase.getInstallPath() == null;
            }
            case 8: {
                return pSBDTypeBase.getJdbcDialect() == null;
            }
            case 9: {
                return pSBDTypeBase.getJdbcDriverName() == null;
            }
            case 10: {
                return pSBDTypeBase.getMemo() == null;
            }
            case 11: {
                return pSBDTypeBase.getPSBDTypeId() == null;
            }
            case 12: {
                return pSBDTypeBase.getPSBDTypeName() == null;
            }
            case 13: {
                return pSBDTypeBase.getSQLQuery() == null;
            }
            case 14: {
                return pSBDTypeBase.getUpdateDate() == null;
            }
            case 15: {
                return pSBDTypeBase.getUpdateMan() == null;
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
        return PSBDTypeBase.contains(this, n);
    }

    private static boolean contains(PSBDTypeBase pSBDTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSBDTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSBDTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSBDTypeBase.isDEDQEngObjDirty();
            }
            case 3: {
                return pSBDTypeBase.isDEDQPubObjDirty();
            }
            case 4: {
                return pSBDTypeBase.isDEDSPubObjDirty();
            }
            case 5: {
                return pSBDTypeBase.isHibDialectDirty();
            }
            case 6: {
                return pSBDTypeBase.isIconPathDirty();
            }
            case 7: {
                return pSBDTypeBase.isInstallPathDirty();
            }
            case 8: {
                return pSBDTypeBase.isJdbcDialectDirty();
            }
            case 9: {
                return pSBDTypeBase.isJdbcDriverNameDirty();
            }
            case 10: {
                return pSBDTypeBase.isMemoDirty();
            }
            case 11: {
                return pSBDTypeBase.isPSBDTypeIdDirty();
            }
            case 12: {
                return pSBDTypeBase.isPSBDTypeNameDirty();
            }
            case 13: {
                return pSBDTypeBase.isSQLQueryDirty();
            }
            case 14: {
                return pSBDTypeBase.isUpdateDateDirty();
            }
            case 15: {
                return pSBDTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSBDTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSBDTypeBase pSBDTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSBDTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getDEDQEngObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedqengobj", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getDEDQEngObj()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getDEDQPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedqpubobj", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getDEDQPubObj()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getDEDSPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dedspubobj", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getDEDSPubObj()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getHibDialect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hibdialect", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getHibDialect()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getInstallPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"installpath", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getInstallPath()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getJdbcDialect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jdbcdialect", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getJdbcDialect()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getJdbcDriverName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jdbcdrivername", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getJdbcDriverName()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getPSBDTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdtypeid", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getPSBDTypeId()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getPSBDTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psbdtypename", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getPSBDTypeName()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getSQLQuery() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sqlquery", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getSQLQuery()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSBDTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSBDTypeBase.getJSONValue((Object)pSBDTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSBDTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSBDTypeBase pSBDTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSBDTypeBase.getCreateDate() != null) {
            object = pSBDTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDTypeBase.getCreateMan() != null) {
            object = pSBDTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getDEDQEngObj() != null) {
            object = pSBDTypeBase.getDEDQEngObj();
            xmlNode.setAttribute(FIELD_DEDQENGOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getDEDQPubObj() != null) {
            object = pSBDTypeBase.getDEDQPubObj();
            xmlNode.setAttribute(FIELD_DEDQPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getDEDSPubObj() != null) {
            object = pSBDTypeBase.getDEDSPubObj();
            xmlNode.setAttribute(FIELD_DEDSPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getHibDialect() != null) {
            object = pSBDTypeBase.getHibDialect();
            xmlNode.setAttribute(FIELD_HIBDIALECT, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getIconPath() != null) {
            object = pSBDTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getInstallPath() != null) {
            object = pSBDTypeBase.getInstallPath();
            xmlNode.setAttribute(FIELD_INSTALLPATH, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getJdbcDialect() != null) {
            object = pSBDTypeBase.getJdbcDialect();
            xmlNode.setAttribute(FIELD_JDBCDIALECT, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getJdbcDriverName() != null) {
            object = pSBDTypeBase.getJdbcDriverName();
            xmlNode.setAttribute(FIELD_JDBCDRIVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getMemo() != null) {
            object = pSBDTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getPSBDTypeId() != null) {
            object = pSBDTypeBase.getPSBDTypeId();
            xmlNode.setAttribute(FIELD_PSBDTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getPSBDTypeName() != null) {
            object = pSBDTypeBase.getPSBDTypeName();
            xmlNode.setAttribute(FIELD_PSBDTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSBDTypeBase.getSQLQuery() != null) {
            object = pSBDTypeBase.getSQLQuery();
            xmlNode.setAttribute(FIELD_SQLQUERY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSBDTypeBase.getUpdateDate() != null) {
            object = pSBDTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSBDTypeBase.getUpdateMan() != null) {
            object = pSBDTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSBDTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSBDTypeBase pSBDTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSBDTypeBase.isCreateDateDirty() && (bl || pSBDTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSBDTypeBase.getCreateDate());
        }
        if (pSBDTypeBase.isCreateManDirty() && (bl || pSBDTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSBDTypeBase.getCreateMan());
        }
        if (pSBDTypeBase.isDEDQEngObjDirty() && (bl || pSBDTypeBase.getDEDQEngObj() != null)) {
            iDataObject.set(FIELD_DEDQENGOBJ, (Object)pSBDTypeBase.getDEDQEngObj());
        }
        if (pSBDTypeBase.isDEDQPubObjDirty() && (bl || pSBDTypeBase.getDEDQPubObj() != null)) {
            iDataObject.set(FIELD_DEDQPUBOBJ, (Object)pSBDTypeBase.getDEDQPubObj());
        }
        if (pSBDTypeBase.isDEDSPubObjDirty() && (bl || pSBDTypeBase.getDEDSPubObj() != null)) {
            iDataObject.set(FIELD_DEDSPUBOBJ, (Object)pSBDTypeBase.getDEDSPubObj());
        }
        if (pSBDTypeBase.isHibDialectDirty() && (bl || pSBDTypeBase.getHibDialect() != null)) {
            iDataObject.set(FIELD_HIBDIALECT, (Object)pSBDTypeBase.getHibDialect());
        }
        if (pSBDTypeBase.isIconPathDirty() && (bl || pSBDTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSBDTypeBase.getIconPath());
        }
        if (pSBDTypeBase.isInstallPathDirty() && (bl || pSBDTypeBase.getInstallPath() != null)) {
            iDataObject.set(FIELD_INSTALLPATH, (Object)pSBDTypeBase.getInstallPath());
        }
        if (pSBDTypeBase.isJdbcDialectDirty() && (bl || pSBDTypeBase.getJdbcDialect() != null)) {
            iDataObject.set(FIELD_JDBCDIALECT, (Object)pSBDTypeBase.getJdbcDialect());
        }
        if (pSBDTypeBase.isJdbcDriverNameDirty() && (bl || pSBDTypeBase.getJdbcDriverName() != null)) {
            iDataObject.set(FIELD_JDBCDRIVERNAME, (Object)pSBDTypeBase.getJdbcDriverName());
        }
        if (pSBDTypeBase.isMemoDirty() && (bl || pSBDTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSBDTypeBase.getMemo());
        }
        if (pSBDTypeBase.isPSBDTypeIdDirty() && (bl || pSBDTypeBase.getPSBDTypeId() != null)) {
            iDataObject.set(FIELD_PSBDTYPEID, (Object)pSBDTypeBase.getPSBDTypeId());
        }
        if (pSBDTypeBase.isPSBDTypeNameDirty() && (bl || pSBDTypeBase.getPSBDTypeName() != null)) {
            iDataObject.set(FIELD_PSBDTYPENAME, (Object)pSBDTypeBase.getPSBDTypeName());
        }
        if (pSBDTypeBase.isSQLQueryDirty() && (bl || pSBDTypeBase.getSQLQuery() != null)) {
            iDataObject.set(FIELD_SQLQUERY, (Object)pSBDTypeBase.getSQLQuery());
        }
        if (pSBDTypeBase.isUpdateDateDirty() && (bl || pSBDTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSBDTypeBase.getUpdateDate());
        }
        if (pSBDTypeBase.isUpdateManDirty() && (bl || pSBDTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSBDTypeBase.getUpdateMan());
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
        return PSBDTypeBase.remove(this, n);
    }

    private static boolean remove(PSBDTypeBase pSBDTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSBDTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSBDTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSBDTypeBase.resetDEDQEngObj();
                return true;
            }
            case 3: {
                pSBDTypeBase.resetDEDQPubObj();
                return true;
            }
            case 4: {
                pSBDTypeBase.resetDEDSPubObj();
                return true;
            }
            case 5: {
                pSBDTypeBase.resetHibDialect();
                return true;
            }
            case 6: {
                pSBDTypeBase.resetIconPath();
                return true;
            }
            case 7: {
                pSBDTypeBase.resetInstallPath();
                return true;
            }
            case 8: {
                pSBDTypeBase.resetJdbcDialect();
                return true;
            }
            case 9: {
                pSBDTypeBase.resetJdbcDriverName();
                return true;
            }
            case 10: {
                pSBDTypeBase.resetMemo();
                return true;
            }
            case 11: {
                pSBDTypeBase.resetPSBDTypeId();
                return true;
            }
            case 12: {
                pSBDTypeBase.resetPSBDTypeName();
                return true;
            }
            case 13: {
                pSBDTypeBase.resetSQLQuery();
                return true;
            }
            case 14: {
                pSBDTypeBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSBDTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSBDTypeBase getProxyEntity() {
        return this.proxyPSBDTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSBDTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSBDTypeBase) {
            this.proxyPSBDTypeBase = (PSBDTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSBDTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEDQENGOBJ, 2);
        fieldIndexMap.put(FIELD_DEDQPUBOBJ, 3);
        fieldIndexMap.put(FIELD_DEDSPUBOBJ, 4);
        fieldIndexMap.put(FIELD_HIBDIALECT, 5);
        fieldIndexMap.put(FIELD_ICONPATH, 6);
        fieldIndexMap.put(FIELD_INSTALLPATH, 7);
        fieldIndexMap.put(FIELD_JDBCDIALECT, 8);
        fieldIndexMap.put(FIELD_JDBCDRIVERNAME, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_PSBDTYPEID, 11);
        fieldIndexMap.put(FIELD_PSBDTYPENAME, 12);
        fieldIndexMap.put(FIELD_SQLQUERY, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

