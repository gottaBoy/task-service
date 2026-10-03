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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystemDBCfg;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemDBCfgService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBVER = "DBVER";
    public static final String FIELD_MATCHFLAG = "MATCHFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSDBDETAILID = "PSSYSDBDETAILID";
    public static final String FIELD_PSSYSDBDETAILNAME = "PSSYSDBDETAILNAME";
    public static final String FIELD_PSSYSTEMDBCFGID = "PSSYSTEMDBCFGID";
    public static final String FIELD_PSSYSTEMDBCFGNAME = "PSSYSTEMDBCFGNAME";
    public static final String FIELD_PUBDBVER = "PUBDBVER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBVER = 2;
    private static final int INDEX_MATCHFLAG = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDENAME = 6;
    private static final int INDEX_PSSYSDBDETAILID = 7;
    private static final int INDEX_PSSYSDBDETAILNAME = 8;
    private static final int INDEX_PSSYSTEMDBCFGID = 9;
    private static final int INDEX_PSSYSTEMDBCFGNAME = 10;
    private static final int INDEX_PUBDBVER = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBDetailBase proxyPSSysDBDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbverDirtyFlag = false;
    private boolean matchflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysdbdetailidDirtyFlag = false;
    private boolean pssysdbdetailnameDirtyFlag = false;
    private boolean pssystemdbcfgidDirtyFlag = false;
    private boolean pssystemdbcfgnameDirtyFlag = false;
    private boolean pubdbverDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbver")
    private Integer dbver;
    @Column(name="matchflag")
    private Integer matchflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysdbdetailid")
    private String pssysdbdetailid;
    @Column(name="pssysdbdetailname")
    private String pssysdbdetailname;
    @Column(name="pssystemdbcfgid")
    private String pssystemdbcfgid;
    @Column(name="pssystemdbcfgname")
    private String pssystemdbcfgname;
    @Column(name="pubdbver")
    private Integer pubdbver;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSystemDBCfgLock = new Integer(1);
    private PSSystemDBCfg pssystemdbcfg = null;

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

    public void setDBVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBVer(n);
            return;
        }
        this.dbver = n;
        this.dbverDirtyFlag = true;
    }

    public Integer getDBVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBVer();
        }
        return this.dbver;
    }

    public boolean isDBVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBVerDirty();
        }
        return this.dbverDirtyFlag;
    }

    public void resetDBVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBVer();
            return;
        }
        this.dbverDirtyFlag = false;
        this.dbver = null;
    }

    public void setMatchFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMatchFlag(n);
            return;
        }
        this.matchflag = n;
        this.matchflagDirtyFlag = true;
    }

    public Integer getMatchFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMatchFlag();
        }
        return this.matchflag;
    }

    public boolean isMatchFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMatchFlagDirty();
        }
        return this.matchflagDirtyFlag;
    }

    public void resetMatchFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMatchFlag();
            return;
        }
        this.matchflagDirtyFlag = false;
        this.matchflag = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSSysDBDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbdetailid = string;
        this.pssysdbdetailidDirtyFlag = true;
    }

    public String getPSSysDBDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBDetailId();
        }
        return this.pssysdbdetailid;
    }

    public boolean isPSSysDBDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBDetailIdDirty();
        }
        return this.pssysdbdetailidDirtyFlag;
    }

    public void resetPSSysDBDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBDetailId();
            return;
        }
        this.pssysdbdetailidDirtyFlag = false;
        this.pssysdbdetailid = null;
    }

    public void setPSSysDBDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbdetailname = string;
        this.pssysdbdetailnameDirtyFlag = true;
    }

    public String getPSSysDBDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBDetailName();
        }
        return this.pssysdbdetailname;
    }

    public boolean isPSSysDBDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBDetailNameDirty();
        }
        return this.pssysdbdetailnameDirtyFlag;
    }

    public void resetPSSysDBDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBDetailName();
            return;
        }
        this.pssysdbdetailnameDirtyFlag = false;
        this.pssysdbdetailname = null;
    }

    public void setPSSystemDBCfgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgid = string;
        this.pssystemdbcfgidDirtyFlag = true;
    }

    public String getPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgId();
        }
        return this.pssystemdbcfgid;
    }

    public boolean isPSSystemDBCfgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgIdDirty();
        }
        return this.pssystemdbcfgidDirtyFlag;
    }

    public void resetPSSystemDBCfgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgId();
            return;
        }
        this.pssystemdbcfgidDirtyFlag = false;
        this.pssystemdbcfgid = null;
    }

    public void setPSSystemDBCfgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemDBCfgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemdbcfgname = string;
        this.pssystemdbcfgnameDirtyFlag = true;
    }

    public String getPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfgName();
        }
        return this.pssystemdbcfgname;
    }

    public boolean isPSSystemDBCfgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemDBCfgNameDirty();
        }
        return this.pssystemdbcfgnameDirtyFlag;
    }

    public void resetPSSystemDBCfgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemDBCfgName();
            return;
        }
        this.pssystemdbcfgnameDirtyFlag = false;
        this.pssystemdbcfgname = null;
    }

    public void setPubDBVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubDBVer(n);
            return;
        }
        this.pubdbver = n;
        this.pubdbverDirtyFlag = true;
    }

    public Integer getPubDBVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubDBVer();
        }
        return this.pubdbver;
    }

    public boolean isPubDBVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubDBVerDirty();
        }
        return this.pubdbverDirtyFlag;
    }

    public void resetPubDBVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubDBVer();
            return;
        }
        this.pubdbverDirtyFlag = false;
        this.pubdbver = null;
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
        PSSysDBDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBDetailBase pSSysDBDetailBase) {
        pSSysDBDetailBase.resetCreateDate();
        pSSysDBDetailBase.resetCreateMan();
        pSSysDBDetailBase.resetDBVer();
        pSSysDBDetailBase.resetMatchFlag();
        pSSysDBDetailBase.resetMemo();
        pSSysDBDetailBase.resetPSDEId();
        pSSysDBDetailBase.resetPSDEName();
        pSSysDBDetailBase.resetPSSysDBDetailId();
        pSSysDBDetailBase.resetPSSysDBDetailName();
        pSSysDBDetailBase.resetPSSystemDBCfgId();
        pSSysDBDetailBase.resetPSSystemDBCfgName();
        pSSysDBDetailBase.resetPubDBVer();
        pSSysDBDetailBase.resetUpdateDate();
        pSSysDBDetailBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBVerDirty()) {
            hashMap.put(FIELD_DBVER, this.getDBVer());
        }
        if (!bl || this.isMatchFlagDirty()) {
            hashMap.put(FIELD_MATCHFLAG, this.getMatchFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysDBDetailIdDirty()) {
            hashMap.put(FIELD_PSSYSDBDETAILID, this.getPSSysDBDetailId());
        }
        if (!bl || this.isPSSysDBDetailNameDirty()) {
            hashMap.put(FIELD_PSSYSDBDETAILNAME, this.getPSSysDBDetailName());
        }
        if (!bl || this.isPSSystemDBCfgIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGID, this.getPSSystemDBCfgId());
        }
        if (!bl || this.isPSSystemDBCfgNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMDBCFGNAME, this.getPSSystemDBCfgName());
        }
        if (!bl || this.isPubDBVerDirty()) {
            hashMap.put(FIELD_PUBDBVER, this.getPubDBVer());
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
        return PSSysDBDetailBase.get(this, n);
    }

    private static Object get(PSSysDBDetailBase pSSysDBDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBDetailBase.getCreateDate();
            }
            case 1: {
                return pSSysDBDetailBase.getCreateMan();
            }
            case 2: {
                return pSSysDBDetailBase.getDBVer();
            }
            case 3: {
                return pSSysDBDetailBase.getMatchFlag();
            }
            case 4: {
                return pSSysDBDetailBase.getMemo();
            }
            case 5: {
                return pSSysDBDetailBase.getPSDEId();
            }
            case 6: {
                return pSSysDBDetailBase.getPSDEName();
            }
            case 7: {
                return pSSysDBDetailBase.getPSSysDBDetailId();
            }
            case 8: {
                return pSSysDBDetailBase.getPSSysDBDetailName();
            }
            case 9: {
                return pSSysDBDetailBase.getPSSystemDBCfgId();
            }
            case 10: {
                return pSSysDBDetailBase.getPSSystemDBCfgName();
            }
            case 11: {
                return pSSysDBDetailBase.getPubDBVer();
            }
            case 12: {
                return pSSysDBDetailBase.getUpdateDate();
            }
            case 13: {
                return pSSysDBDetailBase.getUpdateMan();
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
        PSSysDBDetailBase.set(this, n, object);
    }

    private static void set(PSSysDBDetailBase pSSysDBDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBDetailBase.setDBVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBDetailBase.setMatchFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBDetailBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBDetailBase.setPSSysDBDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBDetailBase.setPSSysDBDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBDetailBase.setPSSystemDBCfgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBDetailBase.setPSSystemDBCfgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBDetailBase.setPubDBVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDBDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBDetailBase pSSysDBDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBDetailBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDBDetailBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDBDetailBase.getDBVer() == null;
            }
            case 3: {
                return pSSysDBDetailBase.getMatchFlag() == null;
            }
            case 4: {
                return pSSysDBDetailBase.getMemo() == null;
            }
            case 5: {
                return pSSysDBDetailBase.getPSDEId() == null;
            }
            case 6: {
                return pSSysDBDetailBase.getPSDEName() == null;
            }
            case 7: {
                return pSSysDBDetailBase.getPSSysDBDetailId() == null;
            }
            case 8: {
                return pSSysDBDetailBase.getPSSysDBDetailName() == null;
            }
            case 9: {
                return pSSysDBDetailBase.getPSSystemDBCfgId() == null;
            }
            case 10: {
                return pSSysDBDetailBase.getPSSystemDBCfgName() == null;
            }
            case 11: {
                return pSSysDBDetailBase.getPubDBVer() == null;
            }
            case 12: {
                return pSSysDBDetailBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysDBDetailBase.getUpdateMan() == null;
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
        return PSSysDBDetailBase.contains(this, n);
    }

    private static boolean contains(PSSysDBDetailBase pSSysDBDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBDetailBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDBDetailBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDBDetailBase.isDBVerDirty();
            }
            case 3: {
                return pSSysDBDetailBase.isMatchFlagDirty();
            }
            case 4: {
                return pSSysDBDetailBase.isMemoDirty();
            }
            case 5: {
                return pSSysDBDetailBase.isPSDEIdDirty();
            }
            case 6: {
                return pSSysDBDetailBase.isPSDENameDirty();
            }
            case 7: {
                return pSSysDBDetailBase.isPSSysDBDetailIdDirty();
            }
            case 8: {
                return pSSysDBDetailBase.isPSSysDBDetailNameDirty();
            }
            case 9: {
                return pSSysDBDetailBase.isPSSystemDBCfgIdDirty();
            }
            case 10: {
                return pSSysDBDetailBase.isPSSystemDBCfgNameDirty();
            }
            case 11: {
                return pSSysDBDetailBase.isPubDBVerDirty();
            }
            case 12: {
                return pSSysDBDetailBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysDBDetailBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBDetailBase pSSysDBDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getDBVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbver", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getDBVer()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getMatchFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"matchflag", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getMatchFlag()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSSysDBDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbdetailid", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSSysDBDetailId()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSSysDBDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbdetailname", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSSysDBDetailName()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSSystemDBCfgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgid", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSSystemDBCfgId()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPSSystemDBCfgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemdbcfgname", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPSSystemDBCfgName()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getPubDBVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubdbver", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getPubDBVer()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBDetailBase.getJSONValue((Object)pSSysDBDetailBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBDetailBase pSSysDBDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBDetailBase.getCreateDate() != null) {
            object = pSSysDBDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBDetailBase.getCreateMan() != null) {
            object = pSSysDBDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getDBVer() != null) {
            object = pSSysDBDetailBase.getDBVer();
            xmlNode.setAttribute(FIELD_DBVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBDetailBase.getMatchFlag() != null) {
            object = pSSysDBDetailBase.getMatchFlag();
            xmlNode.setAttribute(FIELD_MATCHFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBDetailBase.getMemo() != null) {
            object = pSSysDBDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSDEId() != null) {
            object = pSSysDBDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSDEName() != null) {
            object = pSSysDBDetailBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSSysDBDetailId() != null) {
            object = pSSysDBDetailBase.getPSSysDBDetailId();
            xmlNode.setAttribute(FIELD_PSSYSDBDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSSysDBDetailName() != null) {
            object = pSSysDBDetailBase.getPSSysDBDetailName();
            xmlNode.setAttribute(FIELD_PSSYSDBDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSSystemDBCfgId() != null) {
            object = pSSysDBDetailBase.getPSSystemDBCfgId();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPSSystemDBCfgName() != null) {
            object = pSSysDBDetailBase.getPSSystemDBCfgName();
            xmlNode.setAttribute(FIELD_PSSYSTEMDBCFGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBDetailBase.getPubDBVer() != null) {
            object = pSSysDBDetailBase.getPubDBVer();
            xmlNode.setAttribute(FIELD_PUBDBVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBDetailBase.getUpdateDate() != null) {
            object = pSSysDBDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBDetailBase.getUpdateMan() != null) {
            object = pSSysDBDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBDetailBase pSSysDBDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBDetailBase.isCreateDateDirty() && (bl || pSSysDBDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBDetailBase.getCreateDate());
        }
        if (pSSysDBDetailBase.isCreateManDirty() && (bl || pSSysDBDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBDetailBase.getCreateMan());
        }
        if (pSSysDBDetailBase.isDBVerDirty() && (bl || pSSysDBDetailBase.getDBVer() != null)) {
            iDataObject.set(FIELD_DBVER, (Object)pSSysDBDetailBase.getDBVer());
        }
        if (pSSysDBDetailBase.isMatchFlagDirty() && (bl || pSSysDBDetailBase.getMatchFlag() != null)) {
            iDataObject.set(FIELD_MATCHFLAG, (Object)pSSysDBDetailBase.getMatchFlag());
        }
        if (pSSysDBDetailBase.isMemoDirty() && (bl || pSSysDBDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBDetailBase.getMemo());
        }
        if (pSSysDBDetailBase.isPSDEIdDirty() && (bl || pSSysDBDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysDBDetailBase.getPSDEId());
        }
        if (pSSysDBDetailBase.isPSDENameDirty() && (bl || pSSysDBDetailBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysDBDetailBase.getPSDEName());
        }
        if (pSSysDBDetailBase.isPSSysDBDetailIdDirty() && (bl || pSSysDBDetailBase.getPSSysDBDetailId() != null)) {
            iDataObject.set(FIELD_PSSYSDBDETAILID, (Object)pSSysDBDetailBase.getPSSysDBDetailId());
        }
        if (pSSysDBDetailBase.isPSSysDBDetailNameDirty() && (bl || pSSysDBDetailBase.getPSSysDBDetailName() != null)) {
            iDataObject.set(FIELD_PSSYSDBDETAILNAME, (Object)pSSysDBDetailBase.getPSSysDBDetailName());
        }
        if (pSSysDBDetailBase.isPSSystemDBCfgIdDirty() && (bl || pSSysDBDetailBase.getPSSystemDBCfgId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGID, (Object)pSSysDBDetailBase.getPSSystemDBCfgId());
        }
        if (pSSysDBDetailBase.isPSSystemDBCfgNameDirty() && (bl || pSSysDBDetailBase.getPSSystemDBCfgName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMDBCFGNAME, (Object)pSSysDBDetailBase.getPSSystemDBCfgName());
        }
        if (pSSysDBDetailBase.isPubDBVerDirty() && (bl || pSSysDBDetailBase.getPubDBVer() != null)) {
            iDataObject.set(FIELD_PUBDBVER, (Object)pSSysDBDetailBase.getPubDBVer());
        }
        if (pSSysDBDetailBase.isUpdateDateDirty() && (bl || pSSysDBDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBDetailBase.getUpdateDate());
        }
        if (pSSysDBDetailBase.isUpdateManDirty() && (bl || pSSysDBDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBDetailBase.getUpdateMan());
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
        return PSSysDBDetailBase.remove(this, n);
    }

    private static boolean remove(PSSysDBDetailBase pSSysDBDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBDetailBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDBDetailBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDBDetailBase.resetDBVer();
                return true;
            }
            case 3: {
                pSSysDBDetailBase.resetMatchFlag();
                return true;
            }
            case 4: {
                pSSysDBDetailBase.resetMemo();
                return true;
            }
            case 5: {
                pSSysDBDetailBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSSysDBDetailBase.resetPSDEName();
                return true;
            }
            case 7: {
                pSSysDBDetailBase.resetPSSysDBDetailId();
                return true;
            }
            case 8: {
                pSSysDBDetailBase.resetPSSysDBDetailName();
                return true;
            }
            case 9: {
                pSSysDBDetailBase.resetPSSystemDBCfgId();
                return true;
            }
            case 10: {
                pSSysDBDetailBase.resetPSSystemDBCfgName();
                return true;
            }
            case 11: {
                pSSysDBDetailBase.resetPubDBVer();
                return true;
            }
            case 12: {
                pSSysDBDetailBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysDBDetailBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystemDBCfg getPSSystemDBCfg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemDBCfg();
        }
        if (this.getPSSystemDBCfgId() == null) {
            return null;
        }
        Integer n = this.objPSSystemDBCfgLock;
        synchronized (n) {
            if (this.pssystemdbcfg != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemDBCfgId(), (Object)this.pssystemdbcfg.getPSSystemDBCfgId()) != 0L) {
                this.pssystemdbcfg = null;
            }
            if (this.pssystemdbcfg == null) {
                PSSystemDBCfg pSSystemDBCfg = new PSSystemDBCfg();
                pSSystemDBCfg.setPSSystemDBCfgId(this.getPSSystemDBCfgId());
                PSSystemDBCfgService pSSystemDBCfgService = (PSSystemDBCfgService)ServiceGlobal.getService(PSSystemDBCfgService.class, (SessionFactory)this.getSessionFactory());
                pSSystemDBCfgService.autoGet(pSSystemDBCfg);
                this.pssystemdbcfg = pSSystemDBCfg;
            }
            return this.pssystemdbcfg;
        }
    }

    private PSSysDBDetailBase getProxyEntity() {
        return this.proxyPSSysDBDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBDetailBase) {
            this.proxyPSSysDBDetailBase = (PSSysDBDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBVER, 2);
        fieldIndexMap.put(FIELD_MATCHFLAG, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSDBDETAILID, 7);
        fieldIndexMap.put(FIELD_PSSYSDBDETAILNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGID, 9);
        fieldIndexMap.put(FIELD_PSSYSTEMDBCFGNAME, 10);
        fieldIndexMap.put(FIELD_PUBDBVER, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

