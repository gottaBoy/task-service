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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDSCodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDSCodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBTYPE = "DBTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEDSCODEID = "PSDEDSCODEID";
    public static final String FIELD_PSDEDSCODENAME = "PSDEDSCODENAME";
    public static final String FIELD_QUERYCODE = "QUERYCODE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERQUERYCODE = "USERQUERYCODE";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DBTYPE = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDEDATASETID = 4;
    private static final int INDEX_PSDEDATASETNAME = 5;
    private static final int INDEX_PSDEDSCODEID = 6;
    private static final int INDEX_PSDEDSCODENAME = 7;
    private static final int INDEX_QUERYCODE = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERQUERYCODE = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDSCodeBase proxyPSDEDSCodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbtypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdedscodeidDirtyFlag = false;
    private boolean psdedscodenameDirtyFlag = false;
    private boolean querycodeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userquerycodeDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbtype")
    private String dbtype;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdedscodeid")
    private String psdedscodeid;
    @Column(name="psdedscodename")
    private String psdedscodename;
    @Column(name="querycode")
    private String querycode;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userquerycode")
    private String userquerycode;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;

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

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
    }

    public void setPSDEDSCodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSCodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedscodeid = string;
        this.psdedscodeidDirtyFlag = true;
    }

    public String getPSDEDSCodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSCodeId();
        }
        return this.psdedscodeid;
    }

    public boolean isPSDEDSCodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSCodeIdDirty();
        }
        return this.psdedscodeidDirtyFlag;
    }

    public void resetPSDEDSCodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSCodeId();
            return;
        }
        this.psdedscodeidDirtyFlag = false;
        this.psdedscodeid = null;
    }

    public void setPSDEDSCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDSCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedscodename = string;
        this.psdedscodenameDirtyFlag = true;
    }

    public String getPSDEDSCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDSCodeName();
        }
        return this.psdedscodename;
    }

    public boolean isPSDEDSCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDSCodeNameDirty();
        }
        return this.psdedscodenameDirtyFlag;
    }

    public void resetPSDEDSCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDSCodeName();
            return;
        }
        this.psdedscodenameDirtyFlag = false;
        this.psdedscodename = null;
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

    protected void onReset() {
        PSDEDSCodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDSCodeBase pSDEDSCodeBase) {
        pSDEDSCodeBase.resetCreateDate();
        pSDEDSCodeBase.resetCreateMan();
        pSDEDSCodeBase.resetDBType();
        pSDEDSCodeBase.resetMemo();
        pSDEDSCodeBase.resetPSDEDataSetId();
        pSDEDSCodeBase.resetPSDEDataSetName();
        pSDEDSCodeBase.resetPSDEDSCodeId();
        pSDEDSCodeBase.resetPSDEDSCodeName();
        pSDEDSCodeBase.resetQueryCode();
        pSDEDSCodeBase.resetUpdateDate();
        pSDEDSCodeBase.resetUpdateMan();
        pSDEDSCodeBase.resetUserQueryCode();
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
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEDSCodeIdDirty()) {
            hashMap.put(FIELD_PSDEDSCODEID, this.getPSDEDSCodeId());
        }
        if (!bl || this.isPSDEDSCodeNameDirty()) {
            hashMap.put(FIELD_PSDEDSCODENAME, this.getPSDEDSCodeName());
        }
        if (!bl || this.isQueryCodeDirty()) {
            hashMap.put(FIELD_QUERYCODE, this.getQueryCode());
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
        return PSDEDSCodeBase.get(this, n);
    }

    private static Object get(PSDEDSCodeBase pSDEDSCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSCodeBase.getCreateDate();
            }
            case 1: {
                return pSDEDSCodeBase.getCreateMan();
            }
            case 2: {
                return pSDEDSCodeBase.getDBType();
            }
            case 3: {
                return pSDEDSCodeBase.getMemo();
            }
            case 4: {
                return pSDEDSCodeBase.getPSDEDataSetId();
            }
            case 5: {
                return pSDEDSCodeBase.getPSDEDataSetName();
            }
            case 6: {
                return pSDEDSCodeBase.getPSDEDSCodeId();
            }
            case 7: {
                return pSDEDSCodeBase.getPSDEDSCodeName();
            }
            case 8: {
                return pSDEDSCodeBase.getQueryCode();
            }
            case 9: {
                return pSDEDSCodeBase.getUpdateDate();
            }
            case 10: {
                return pSDEDSCodeBase.getUpdateMan();
            }
            case 11: {
                return pSDEDSCodeBase.getUserQueryCode();
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
        PSDEDSCodeBase.set(this, n, object);
    }

    private static void set(PSDEDSCodeBase pSDEDSCodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSCodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDSCodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDSCodeBase.setDBType(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDSCodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDSCodeBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDSCodeBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDSCodeBase.setPSDEDSCodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDSCodeBase.setPSDEDSCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEDSCodeBase.setQueryCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEDSCodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSDEDSCodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEDSCodeBase.setUserQueryCode(DataObject.getStringValue((Object)object));
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
        return PSDEDSCodeBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDSCodeBase pSDEDSCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSCodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDSCodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDSCodeBase.getDBType() == null;
            }
            case 3: {
                return pSDEDSCodeBase.getMemo() == null;
            }
            case 4: {
                return pSDEDSCodeBase.getPSDEDataSetId() == null;
            }
            case 5: {
                return pSDEDSCodeBase.getPSDEDataSetName() == null;
            }
            case 6: {
                return pSDEDSCodeBase.getPSDEDSCodeId() == null;
            }
            case 7: {
                return pSDEDSCodeBase.getPSDEDSCodeName() == null;
            }
            case 8: {
                return pSDEDSCodeBase.getQueryCode() == null;
            }
            case 9: {
                return pSDEDSCodeBase.getUpdateDate() == null;
            }
            case 10: {
                return pSDEDSCodeBase.getUpdateMan() == null;
            }
            case 11: {
                return pSDEDSCodeBase.getUserQueryCode() == null;
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
        return PSDEDSCodeBase.contains(this, n);
    }

    private static boolean contains(PSDEDSCodeBase pSDEDSCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDSCodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDSCodeBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDSCodeBase.isDBTypeDirty();
            }
            case 3: {
                return pSDEDSCodeBase.isMemoDirty();
            }
            case 4: {
                return pSDEDSCodeBase.isPSDEDataSetIdDirty();
            }
            case 5: {
                return pSDEDSCodeBase.isPSDEDataSetNameDirty();
            }
            case 6: {
                return pSDEDSCodeBase.isPSDEDSCodeIdDirty();
            }
            case 7: {
                return pSDEDSCodeBase.isPSDEDSCodeNameDirty();
            }
            case 8: {
                return pSDEDSCodeBase.isQueryCodeDirty();
            }
            case 9: {
                return pSDEDSCodeBase.isUpdateDateDirty();
            }
            case 10: {
                return pSDEDSCodeBase.isUpdateManDirty();
            }
            case 11: {
                return pSDEDSCodeBase.isUserQueryCodeDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDSCodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDSCodeBase pSDEDSCodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDSCodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getDBType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbtype", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getDBType()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getPSDEDSCodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedscodeid", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getPSDEDSCodeId()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getPSDEDSCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedscodename", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getPSDEDSCodeName()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getQueryCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"querycode", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getQueryCode()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEDSCodeBase.getUserQueryCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userquerycode", (Object)PSDEDSCodeBase.getJSONValue((Object)pSDEDSCodeBase.getUserQueryCode()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDSCodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDSCodeBase pSDEDSCodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDSCodeBase.getCreateDate() != null) {
            object = pSDEDSCodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSCodeBase.getCreateMan() != null) {
            object = pSDEDSCodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getDBType() != null) {
            object = pSDEDSCodeBase.getDBType();
            xmlNode.setAttribute(FIELD_DBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getMemo() != null) {
            object = pSDEDSCodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getPSDEDataSetId() != null) {
            object = pSDEDSCodeBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getPSDEDataSetName() != null) {
            object = pSDEDSCodeBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getPSDEDSCodeId() != null) {
            object = pSDEDSCodeBase.getPSDEDSCodeId();
            xmlNode.setAttribute(FIELD_PSDEDSCODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getPSDEDSCodeName() != null) {
            object = pSDEDSCodeBase.getPSDEDSCodeName();
            xmlNode.setAttribute(FIELD_PSDEDSCODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getQueryCode() != null) {
            object = pSDEDSCodeBase.getQueryCode();
            xmlNode.setAttribute(FIELD_QUERYCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getUpdateDate() != null) {
            object = pSDEDSCodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDSCodeBase.getUpdateMan() != null) {
            object = pSDEDSCodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDSCodeBase.getUserQueryCode() != null) {
            object = pSDEDSCodeBase.getUserQueryCode();
            xmlNode.setAttribute(FIELD_USERQUERYCODE, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDSCodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDSCodeBase pSDEDSCodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDSCodeBase.isCreateDateDirty() && (bl || pSDEDSCodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDSCodeBase.getCreateDate());
        }
        if (pSDEDSCodeBase.isCreateManDirty() && (bl || pSDEDSCodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDSCodeBase.getCreateMan());
        }
        if (pSDEDSCodeBase.isDBTypeDirty() && (bl || pSDEDSCodeBase.getDBType() != null)) {
            iDataObject.set(FIELD_DBTYPE, (Object)pSDEDSCodeBase.getDBType());
        }
        if (pSDEDSCodeBase.isMemoDirty() && (bl || pSDEDSCodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDSCodeBase.getMemo());
        }
        if (pSDEDSCodeBase.isPSDEDataSetIdDirty() && (bl || pSDEDSCodeBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEDSCodeBase.getPSDEDataSetId());
        }
        if (pSDEDSCodeBase.isPSDEDataSetNameDirty() && (bl || pSDEDSCodeBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEDSCodeBase.getPSDEDataSetName());
        }
        if (pSDEDSCodeBase.isPSDEDSCodeIdDirty() && (bl || pSDEDSCodeBase.getPSDEDSCodeId() != null)) {
            iDataObject.set(FIELD_PSDEDSCODEID, (Object)pSDEDSCodeBase.getPSDEDSCodeId());
        }
        if (pSDEDSCodeBase.isPSDEDSCodeNameDirty() && (bl || pSDEDSCodeBase.getPSDEDSCodeName() != null)) {
            iDataObject.set(FIELD_PSDEDSCODENAME, (Object)pSDEDSCodeBase.getPSDEDSCodeName());
        }
        if (pSDEDSCodeBase.isQueryCodeDirty() && (bl || pSDEDSCodeBase.getQueryCode() != null)) {
            iDataObject.set(FIELD_QUERYCODE, (Object)pSDEDSCodeBase.getQueryCode());
        }
        if (pSDEDSCodeBase.isUpdateDateDirty() && (bl || pSDEDSCodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDSCodeBase.getUpdateDate());
        }
        if (pSDEDSCodeBase.isUpdateManDirty() && (bl || pSDEDSCodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDSCodeBase.getUpdateMan());
        }
        if (pSDEDSCodeBase.isUserQueryCodeDirty() && (bl || pSDEDSCodeBase.getUserQueryCode() != null)) {
            iDataObject.set(FIELD_USERQUERYCODE, (Object)pSDEDSCodeBase.getUserQueryCode());
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
        return PSDEDSCodeBase.remove(this, n);
    }

    private static boolean remove(PSDEDSCodeBase pSDEDSCodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDSCodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDSCodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDSCodeBase.resetDBType();
                return true;
            }
            case 3: {
                pSDEDSCodeBase.resetMemo();
                return true;
            }
            case 4: {
                pSDEDSCodeBase.resetPSDEDataSetId();
                return true;
            }
            case 5: {
                pSDEDSCodeBase.resetPSDEDataSetName();
                return true;
            }
            case 6: {
                pSDEDSCodeBase.resetPSDEDSCodeId();
                return true;
            }
            case 7: {
                pSDEDSCodeBase.resetPSDEDSCodeName();
                return true;
            }
            case 8: {
                pSDEDSCodeBase.resetQueryCode();
                return true;
            }
            case 9: {
                pSDEDSCodeBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSDEDSCodeBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSDEDSCodeBase.resetUserQueryCode();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    private PSDEDSCodeBase getProxyEntity() {
        return this.proxyPSDEDSCodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDSCodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDSCodeBase) {
            this.proxyPSDEDSCodeBase = (PSDEDSCodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDSCodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DBTYPE, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 4);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 5);
        fieldIndexMap.put(FIELD_PSDEDSCODEID, 6);
        fieldIndexMap.put(FIELD_PSDEDSCODENAME, 7);
        fieldIndexMap.put(FIELD_QUERYCODE, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERQUERYCODE, 11);
    }
}

