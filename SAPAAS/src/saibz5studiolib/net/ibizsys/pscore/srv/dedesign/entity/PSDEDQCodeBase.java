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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDQCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDQCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDQCODEID = "PSDEDQCODEID";
    public static final String FIELD_PSDEDQCODENAME = "PSDEDQCODENAME";
    public static final String FIELD_PSDEDQID = "PSDEDQID";
    public static final String FIELD_PSDEDQNAME = "PSDEDQNAME";
    public static final String FIELD_QUERYCODE = "QUERYCODE";
    public static final String FIELD_QUERYCODETEMP = "QUERYCODETEMP";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERQUERYCODE = "USERQUERYCODE";
    public static final String FIELD_USERQUERYCODE2 = "USERQUERYCODE2";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEDQCODEID = 4;
    private static final int INDEX_PSDEDQCODENAME = 5;
    private static final int INDEX_PSDEDQID = 6;
    private static final int INDEX_PSDEDQNAME = 7;
    private static final int INDEX_QUERYCODE = 8;
    private static final int INDEX_QUERYCODETEMP = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERQUERYCODE = 12;
    private static final int INDEX_USERQUERYCODE2 = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDQCodeBase proxyPSDEDQCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedqcodeidDirtyFlag = false;
    private boolean psdedqcodenameDirtyFlag = false;
    private boolean psdedqidDirtyFlag = false;
    private boolean psdedqnameDirtyFlag = false;
    private boolean querycodeDirtyFlag = false;
    private boolean querycodetempDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userquerycodeDirtyFlag = false;
    private boolean userquerycode2DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedqcodeid")
    private String psdedqcodeid;
    @Column(name="psdedqcodename")
    private String psdedqcodename;
    @Column(name="psdedqid")
    private String psdedqid;
    @Column(name="psdedqname")
    private String psdedqname;
    @Column(name="querycode")
    private String querycode;
    @Column(name="querycodetemp")
    private String querycodetemp;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userquerycode")
    private String userquerycode;
    @Column(name="userquerycode2")
    private String userquerycode2;
    private Integer objPSDEDQLock = new Integer(1);
    private PSDEDataQuery psdedq = null;

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

    public void setPSDEDQCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodeid = string;
        this.psdedqcodeidDirtyFlag = true;
    }

    public String getPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeId();
        }
        return this.psdedqcodeid;
    }

    public boolean isPSDEDQCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeIdDirty();
        }
        return this.psdedqcodeidDirtyFlag;
    }

    public void resetPSDEDQCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeId();
            return;
        }
        this.psdedqcodeidDirtyFlag = false;
        this.psdedqcodeid = null;
    }

    public void setPSDEDQCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqcodename = string;
        this.psdedqcodenameDirtyFlag = true;
    }

    public String getPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQCodeName();
        }
        return this.psdedqcodename;
    }

    public boolean isPSDEDQCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQCodeNameDirty();
        }
        return this.psdedqcodenameDirtyFlag;
    }

    public void resetPSDEDQCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQCodeName();
            return;
        }
        this.psdedqcodenameDirtyFlag = false;
        this.psdedqcodename = null;
    }

    public void setPSDEDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqid = string;
        this.psdedqidDirtyFlag = true;
    }

    public String getPSDEDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQId();
        }
        return this.psdedqid;
    }

    public boolean isPSDEDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQIdDirty();
        }
        return this.psdedqidDirtyFlag;
    }

    public void resetPSDEDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQId();
            return;
        }
        this.psdedqidDirtyFlag = false;
        this.psdedqid = null;
    }

    public void setPSDEDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedqname = string;
        this.psdedqnameDirtyFlag = true;
    }

    public String getPSDEDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQName();
        }
        return this.psdedqname;
    }

    public boolean isPSDEDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDQNameDirty();
        }
        return this.psdedqnameDirtyFlag;
    }

    public void resetPSDEDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDQName();
            return;
        }
        this.psdedqnameDirtyFlag = false;
        this.psdedqname = null;
    }

    public void setQueryCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.querycode = string;
        this.querycodeDirtyFlag = true;
    }

    public String getQueryCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryCode();
        }
        return this.querycode;
    }

    public boolean isQueryCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryCodeDirty();
        }
        return this.querycodeDirtyFlag;
    }

    public void resetQueryCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryCode();
            return;
        }
        this.querycodeDirtyFlag = false;
        this.querycode = null;
    }

    public void setQueryCodeTemp(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setQueryCodeTemp(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.querycodetemp = string;
        this.querycodetempDirtyFlag = true;
    }

    public String getQueryCodeTemp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getQueryCodeTemp();
        }
        return this.querycodetemp;
    }

    public boolean isQueryCodeTempDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isQueryCodeTempDirty();
        }
        return this.querycodetempDirtyFlag;
    }

    public void resetQueryCodeTemp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetQueryCodeTemp();
            return;
        }
        this.querycodetempDirtyFlag = false;
        this.querycodetemp = null;
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

    public void setUserQueryCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserQueryCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userquerycode = string;
        this.userquerycodeDirtyFlag = true;
    }

    public String getUserQueryCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserQueryCode();
        }
        return this.userquerycode;
    }

    public boolean isUserQueryCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserQueryCodeDirty();
        }
        return this.userquerycodeDirtyFlag;
    }

    public void resetUserQueryCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserQueryCode();
            return;
        }
        this.userquerycodeDirtyFlag = false;
        this.userquerycode = null;
    }

    public void setUserQueryCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserQueryCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userquerycode2 = string;
        this.userquerycode2DirtyFlag = true;
    }

    public String getUserQueryCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserQueryCode2();
        }
        return this.userquerycode2;
    }

    public boolean isUserQueryCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserQueryCode2Dirty();
        }
        return this.userquerycode2DirtyFlag;
    }

    public void resetUserQueryCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserQueryCode2();
            return;
        }
        this.userquerycode2DirtyFlag = false;
        this.userquerycode2 = null;
    }

    protected void onReset() {
        PSDEDQCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDQCodeBase pSDEDQCodeBase) {
        pSDEDQCodeBase.resetCreateDate();
        pSDEDQCodeBase.resetCreateMan();
        pSDEDQCodeBase.resetDBType();
        pSDEDQCodeBase.resetMemo();
        pSDEDQCodeBase.resetPSDEDQCodeId();
        pSDEDQCodeBase.resetPSDEDQCodeName();
        pSDEDQCodeBase.resetPSDEDQId();
        pSDEDQCodeBase.resetPSDEDQName();
        pSDEDQCodeBase.resetQueryCode();
        pSDEDQCodeBase.resetQueryCodeTemp();
        pSDEDQCodeBase.resetUpdateDate();
        pSDEDQCodeBase.resetUpdateMan();
        pSDEDQCodeBase.resetUserQueryCode();
        pSDEDQCodeBase.resetUserQueryCode2();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBTypeDirty()) {
            hashMap.put(FIELD_DBTYPE, this.getDBType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEDQCodeIdDirty()) {
            hashMap.put(FIELD_PSDEDQCODEID, this.getPSDEDQCodeId());
        }
        if (!bl || this.isPSDEDQCodeNameDirty()) {
            hashMap.put(FIELD_PSDEDQCODENAME, this.getPSDEDQCodeName());
        }
        if (!bl || this.isPSDEDQIdDirty()) {
            hashMap.put(FIELD_PSDEDQID, this.getPSDEDQId());
        }
        if (!bl || this.isPSDEDQNameDirty()) {
            hashMap.put(FIELD_PSDEDQNAME, this.getPSDEDQName());
        }
        if (!bl || this.isQueryCodeDirty()) {
            hashMap.put(FIELD_QUERYCODE, this.getQueryCode());
        }
        if (!bl || this.isQueryCodeTempDirty()) {
            hashMap.put(FIELD_QUERYCODETEMP, this.getQueryCodeTemp());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserQueryCodeDirty()) {
            hashMap.put(FIELD_USERQUERYCODE, this.getUserQueryCode());
        }
        if (!bl || this.isUserQueryCode2Dirty()) {
            hashMap.put(FIELD_USERQUERYCODE2, this.getUserQueryCode2());
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
        return PSDEDQCodeBase.get(this, n);
    }

    private static Object get(PSDEDQCodeBase pSDEDQCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeBase.getCreateDate();
            }
            case 1: {
                return pSDEDQCodeBase.getCreateMan();
            }
            case 2: {
                return pSDEDQCodeBase.getDBType();
            }
            case 3: {
                return pSDEDQCodeBase.getMemo();
            }
            case 4: {
                return pSDEDQCodeBase.getPSDEDQCodeId();
            }
            case 5: {
                return pSDEDQCodeBase.getPSDEDQCodeName();
            }
            case 6: {
                return pSDEDQCodeBase.getPSDEDQId();
            }
            case 7: {
                return pSDEDQCodeBase.getPSDEDQName();
            }
            case 8: {
                return pSDEDQCodeBase.getQueryCode();
            }
            case 9: {
                return pSDEDQCodeBase.getQueryCodeTemp();
            }
            case 10: {
                return pSDEDQCodeBase.getUpdateDate();
            }
            case 11: {
                return pSDEDQCodeBase.getUpdateMan();
            }
            case 12: {
                return pSDEDQCodeBase.getUserQueryCode();
            }
            case 13: {
                return pSDEDQCodeBase.getUserQueryCode2();
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
        PSDEDQCodeBase.set(this, n, object);
    }

    private static void set(PSDEDQCodeBase pSDEDQCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDQCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDQCodeBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDQCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDQCodeBase.setPSDEDQCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDQCodeBase.setPSDEDQCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDQCodeBase.setPSDEDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDQCodeBase.setPSDEDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDQCodeBase.setQueryCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDQCodeBase.setQueryCodeTemp(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEDQCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSDEDQCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEDQCodeBase.setUserQueryCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEDQCodeBase.setUserQueryCode2(DataObject.getStringValue((Object)object));
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
        return PSDEDQCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDQCodeBase pSDEDQCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDQCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDQCodeBase.getDBType() == null;
            }
            case 3: {
                return pSDEDQCodeBase.getMemo() == null;
            }
            case 4: {
                return pSDEDQCodeBase.getPSDEDQCodeId() == null;
            }
            case 5: {
                return pSDEDQCodeBase.getPSDEDQCodeName() == null;
            }
            case 6: {
                return pSDEDQCodeBase.getPSDEDQId() == null;
            }
            case 7: {
                return pSDEDQCodeBase.getPSDEDQName() == null;
            }
            case 8: {
                return pSDEDQCodeBase.getQueryCode() == null;
            }
            case 9: {
                return pSDEDQCodeBase.getQueryCodeTemp() == null;
            }
            case 10: {
                return pSDEDQCodeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSDEDQCodeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSDEDQCodeBase.getUserQueryCode() == null;
            }
            case 13: {
                return pSDEDQCodeBase.getUserQueryCode2() == null;
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
        return PSDEDQCodeBase.contains(this, n);
    }

    private static boolean contains(PSDEDQCodeBase pSDEDQCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDQCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDQCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDQCodeBase.isDBTypeDirty();
            }
            case 3: {
                return pSDEDQCodeBase.isMemoDirty();
            }
            case 4: {
                return pSDEDQCodeBase.isPSDEDQCodeIdDirty();
            }
            case 5: {
                return pSDEDQCodeBase.isPSDEDQCodeNameDirty();
            }
            case 6: {
                return pSDEDQCodeBase.isPSDEDQIdDirty();
            }
            case 7: {
                return pSDEDQCodeBase.isPSDEDQNameDirty();
            }
            case 8: {
                return pSDEDQCodeBase.isQueryCodeDirty();
            }
            case 9: {
                return pSDEDQCodeBase.isQueryCodeTempDirty();
            }
            case 10: {
                return pSDEDQCodeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSDEDQCodeBase.isUpdateManDirty();
            }
            case 12: {
                return pSDEDQCodeBase.isUserQueryCodeDirty();
            }
            case 13: {
                return pSDEDQCodeBase.isUserQueryCode2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDQCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDQCodeBase pSDEDQCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDQCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getDBType()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodeid", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getPSDEDQCodeId()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqcodename", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getPSDEDQCodeName()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqid", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getPSDEDQId()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedqname", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getPSDEDQName()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getQueryCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"querycode", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getQueryCode()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getQueryCodeTemp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"querycodetemp", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getQueryCodeTemp()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getUserQueryCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userquerycode", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getUserQueryCode()), (boolean)false);
        }
        if (bl || pSDEDQCodeBase.getUserQueryCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userquerycode2", (Object)PSDEDQCodeBase.getJSONValue((Object)pSDEDQCodeBase.getUserQueryCode2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDQCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDQCodeBase pSDEDQCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDQCodeBase.getCreateDate() != null) {
            object = pSDEDQCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeBase.getCreateMan() != null) {
            object = pSDEDQCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getDBType() != null) {
            object = pSDEDQCodeBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getMemo() != null) {
            object = pSDEDQCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQCodeId() != null) {
            object = pSDEDQCodeBase.getPSDEDQCodeId();
            xmlNode.setAttribute(FIELD_PSDEDQCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQCodeName() != null) {
            object = pSDEDQCodeBase.getPSDEDQCodeName();
            xmlNode.setAttribute(FIELD_PSDEDQCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQId() != null) {
            object = pSDEDQCodeBase.getPSDEDQId();
            xmlNode.setAttribute(FIELD_PSDEDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getPSDEDQName() != null) {
            object = pSDEDQCodeBase.getPSDEDQName();
            xmlNode.setAttribute(FIELD_PSDEDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getQueryCode() != null) {
            object = pSDEDQCodeBase.getQueryCode();
            xmlNode.setAttribute(FIELD_QUERYCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getQueryCodeTemp() != null) {
            object = pSDEDQCodeBase.getQueryCodeTemp();
            xmlNode.setAttribute(FIELD_QUERYCODETEMP, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getUpdateDate() != null) {
            object = pSDEDQCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDQCodeBase.getUpdateMan() != null) {
            object = pSDEDQCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getUserQueryCode() != null) {
            object = pSDEDQCodeBase.getUserQueryCode();
            xmlNode.setAttribute(FIELD_USERQUERYCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDQCodeBase.getUserQueryCode2() != null) {
            object = pSDEDQCodeBase.getUserQueryCode2();
            xmlNode.setAttribute(FIELD_USERQUERYCODE2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDQCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDQCodeBase pSDEDQCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDQCodeBase.isCreateDateDirty() && (bl || pSDEDQCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDQCodeBase.getCreateDate());
        }
        if (pSDEDQCodeBase.isCreateManDirty() && (bl || pSDEDQCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDQCodeBase.getCreateMan());
        }
        if (pSDEDQCodeBase.isDBTypeDirty() && (bl || pSDEDQCodeBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDEDQCodeBase.getDBType());
        }
        if (pSDEDQCodeBase.isMemoDirty() && (bl || pSDEDQCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDQCodeBase.getMemo());
        }
        if (pSDEDQCodeBase.isPSDEDQCodeIdDirty() && (bl || pSDEDQCodeBase.getPSDEDQCodeId() != null)) {
            iDataObject.set(FIELD_PSDEDQCODEID, (Object)pSDEDQCodeBase.getPSDEDQCodeId());
        }
        if (pSDEDQCodeBase.isPSDEDQCodeNameDirty() && (bl || pSDEDQCodeBase.getPSDEDQCodeName() != null)) {
            iDataObject.set(FIELD_PSDEDQCODENAME, (Object)pSDEDQCodeBase.getPSDEDQCodeName());
        }
        if (pSDEDQCodeBase.isPSDEDQIdDirty() && (bl || pSDEDQCodeBase.getPSDEDQId() != null)) {
            iDataObject.set(FIELD_PSDEDQID, (Object)pSDEDQCodeBase.getPSDEDQId());
        }
        if (pSDEDQCodeBase.isPSDEDQNameDirty() && (bl || pSDEDQCodeBase.getPSDEDQName() != null)) {
            iDataObject.set(FIELD_PSDEDQNAME, (Object)pSDEDQCodeBase.getPSDEDQName());
        }
        if (pSDEDQCodeBase.isQueryCodeDirty() && (bl || pSDEDQCodeBase.getQueryCode() != null)) {
            iDataObject.set(FIELD_QUERYCODE, (Object)pSDEDQCodeBase.getQueryCode());
        }
        if (pSDEDQCodeBase.isQueryCodeTempDirty() && (bl || pSDEDQCodeBase.getQueryCodeTemp() != null)) {
            iDataObject.set(FIELD_QUERYCODETEMP, (Object)pSDEDQCodeBase.getQueryCodeTemp());
        }
        if (pSDEDQCodeBase.isUpdateDateDirty() && (bl || pSDEDQCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDQCodeBase.getUpdateDate());
        }
        if (pSDEDQCodeBase.isUpdateManDirty() && (bl || pSDEDQCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDQCodeBase.getUpdateMan());
        }
        if (pSDEDQCodeBase.isUserQueryCodeDirty() && (bl || pSDEDQCodeBase.getUserQueryCode() != null)) {
            iDataObject.set(FIELD_USERQUERYCODE, (Object)pSDEDQCodeBase.getUserQueryCode());
        }
        if (pSDEDQCodeBase.isUserQueryCode2Dirty() && (bl || pSDEDQCodeBase.getUserQueryCode2() != null)) {
            iDataObject.set(FIELD_USERQUERYCODE2, (Object)pSDEDQCodeBase.getUserQueryCode2());
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
        return PSDEDQCodeBase.remove(this, n);
    }

    private static boolean remove(PSDEDQCodeBase pSDEDQCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDQCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDQCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDQCodeBase.resetDBType();
                return true;
            }
            case 3: {
                pSDEDQCodeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDQCodeBase.resetPSDEDQCodeId();
                return true;
            }
            case 5: {
                pSDEDQCodeBase.resetPSDEDQCodeName();
                return true;
            }
            case 6: {
                pSDEDQCodeBase.resetPSDEDQId();
                return true;
            }
            case 7: {
                pSDEDQCodeBase.resetPSDEDQName();
                return true;
            }
            case 8: {
                pSDEDQCodeBase.resetQueryCode();
                return true;
            }
            case 9: {
                pSDEDQCodeBase.resetQueryCodeTemp();
                return true;
            }
            case 10: {
                pSDEDQCodeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSDEDQCodeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSDEDQCodeBase.resetUserQueryCode();
                return true;
            }
            case 13: {
                pSDEDQCodeBase.resetUserQueryCode2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDQ() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDQ();
        }
        if (this.getPSDEDQId() == null) {
            return null;
        }
        Integer n = this.objPSDEDQLock;
        synchronized (n) {
            if (this.psdedq != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDQId(), (Object)this.psdedq.getPSDEDataQueryId()) != 0L) {
                this.psdedq = null;
            }
            if (this.psdedq == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDQId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet(pSDEDataQuery);
                this.psdedq = pSDEDataQuery;
            }
            return this.psdedq;
        }
    }

    private PSDEDQCodeBase getProxyEntity() {
        return this.proxyPSDEDQCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDQCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDQCodeBase) {
            this.proxyPSDEDQCodeBase = (PSDEDQCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDQCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEDQCODEID, 4);
        fieldIndexMap.put(FIELD_PSDEDQCODENAME, 5);
        fieldIndexMap.put(FIELD_PSDEDQID, 6);
        fieldIndexMap.put(FIELD_PSDEDQNAME, 7);
        fieldIndexMap.put(FIELD_QUERYCODE, 8);
        fieldIndexMap.put(FIELD_QUERYCODETEMP, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERQUERYCODE, 12);
        fieldIndexMap.put(FIELD_USERQUERYCODE2, 13);
    }
}

