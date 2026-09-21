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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterDBInst;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterDBInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCDBTableBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBTableBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_PSDCDBTABLEID = "PSDCDBTABLEID";
    public static final String FIELD_PSDCDBTABLENAME = "PSDCDBTABLENAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBINSTID = 3;
    private static final int INDEX_PSDCDBINSTNAME = 4;
    private static final int INDEX_PSDCDBTABLEID = 5;
    private static final int INDEX_PSDCDBTABLENAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBTableBase proxyPSDCDBTableBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean psdcdbtableidDirtyFlag = false;
    private boolean psdcdbtablenameDirtyFlag = false;
    private boolean sqlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcdbinstid")
    private String psdcdbinstid;
    @Column(name="psdcdbinstname")
    private String psdcdbinstname;
    @Column(name="psdcdbtableid")
    private String psdcdbtableid;
    @Column(name="psdcdbtablename")
    private String psdcdbtablename;
    @Column(name="sql")
    private String sql;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDDBInstLock = new Integer(1);
    private PSDevCenterDBInst psddbinst = null;

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

    public void setPSDCDBInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstid = string;
        this.psdcdbinstidDirtyFlag = true;
    }

    public String getPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstId();
        }
        return this.psdcdbinstid;
    }

    public boolean isPSDCDBInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstIdDirty();
        }
        return this.psdcdbinstidDirtyFlag;
    }

    public void resetPSDCDBInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstId();
            return;
        }
        this.psdcdbinstidDirtyFlag = false;
        this.psdcdbinstid = null;
    }

    public void setPSDCDBInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbinstname = string;
        this.psdcdbinstnameDirtyFlag = true;
    }

    public String getPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBInstName();
        }
        return this.psdcdbinstname;
    }

    public boolean isPSDCDBInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBInstNameDirty();
        }
        return this.psdcdbinstnameDirtyFlag;
    }

    public void resetPSDCDBInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBInstName();
            return;
        }
        this.psdcdbinstnameDirtyFlag = false;
        this.psdcdbinstname = null;
    }

    public void setPSDCDBTableId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBTableId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbtableid = string;
        this.psdcdbtableidDirtyFlag = true;
    }

    public String getPSDCDBTableId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBTableId();
        }
        return this.psdcdbtableid;
    }

    public boolean isPSDCDBTableIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBTableIdDirty();
        }
        return this.psdcdbtableidDirtyFlag;
    }

    public void resetPSDCDBTableId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBTableId();
            return;
        }
        this.psdcdbtableidDirtyFlag = false;
        this.psdcdbtableid = null;
    }

    public void setPSDCDBTableName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBTableName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbtablename = string;
        this.psdcdbtablenameDirtyFlag = true;
    }

    public String getPSDCDBTableName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBTableName();
        }
        return this.psdcdbtablename;
    }

    public boolean isPSDCDBTableNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBTableNameDirty();
        }
        return this.psdcdbtablenameDirtyFlag;
    }

    public void resetPSDCDBTableName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBTableName();
            return;
        }
        this.psdcdbtablenameDirtyFlag = false;
        this.psdcdbtablename = null;
    }

    public void setSQL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSQL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sql = string;
        this.sqlDirtyFlag = true;
    }

    public String getSQL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSQL();
        }
        return this.sql;
    }

    public boolean isSQLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSQLDirty();
        }
        return this.sqlDirtyFlag;
    }

    public void resetSQL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSQL();
            return;
        }
        this.sqlDirtyFlag = false;
        this.sql = null;
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
        PSDCDBTableBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBTableBase pSDCDBTableBase) {
        pSDCDBTableBase.resetCreateDate();
        pSDCDBTableBase.resetCreateMan();
        pSDCDBTableBase.resetMemo();
        pSDCDBTableBase.resetPSDCDBInstId();
        pSDCDBTableBase.resetPSDCDBInstName();
        pSDCDBTableBase.resetPSDCDBTableId();
        pSDCDBTableBase.resetPSDCDBTableName();
        pSDCDBTableBase.resetSQL();
        pSDCDBTableBase.resetUpdateDate();
        pSDCDBTableBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PSDCDBINSTID, this.getPSDCDBInstId());
        }
        if (!bl || this.isPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PSDCDBINSTNAME, this.getPSDCDBInstName());
        }
        if (!bl || this.isPSDCDBTableIdDirty()) {
            hashMap.put(FIELD_PSDCDBTABLEID, this.getPSDCDBTableId());
        }
        if (!bl || this.isPSDCDBTableNameDirty()) {
            hashMap.put(FIELD_PSDCDBTABLENAME, this.getPSDCDBTableName());
        }
        if (!bl || this.isSQLDirty()) {
            hashMap.put(FIELD_SQL, this.getSQL());
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
        return PSDCDBTableBase.get(this, n);
    }

    private static Object get(PSDCDBTableBase pSDCDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBTableBase.getCreateDate();
            }
            case 1: {
                return pSDCDBTableBase.getCreateMan();
            }
            case 2: {
                return pSDCDBTableBase.getMemo();
            }
            case 3: {
                return pSDCDBTableBase.getPSDCDBInstId();
            }
            case 4: {
                return pSDCDBTableBase.getPSDCDBInstName();
            }
            case 5: {
                return pSDCDBTableBase.getPSDCDBTableId();
            }
            case 6: {
                return pSDCDBTableBase.getPSDCDBTableName();
            }
            case 7: {
                return pSDCDBTableBase.getSQL();
            }
            case 8: {
                return pSDCDBTableBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBTableBase.getUpdateMan();
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
        PSDCDBTableBase.set(this, n, object);
    }

    private static void set(PSDCDBTableBase pSDCDBTableBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBTableBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBTableBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBTableBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBTableBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBTableBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBTableBase.setPSDCDBTableId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBTableBase.setPSDCDBTableName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBTableBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBTableBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBTableBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBTableBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBTableBase pSDCDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBTableBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBTableBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBTableBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBTableBase.getPSDCDBInstId() == null;
            }
            case 4: {
                return pSDCDBTableBase.getPSDCDBInstName() == null;
            }
            case 5: {
                return pSDCDBTableBase.getPSDCDBTableId() == null;
            }
            case 6: {
                return pSDCDBTableBase.getPSDCDBTableName() == null;
            }
            case 7: {
                return pSDCDBTableBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBTableBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBTableBase.getUpdateMan() == null;
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
        return PSDCDBTableBase.contains(this, n);
    }

    private static boolean contains(PSDCDBTableBase pSDCDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBTableBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBTableBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBTableBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBTableBase.isPSDCDBInstIdDirty();
            }
            case 4: {
                return pSDCDBTableBase.isPSDCDBInstNameDirty();
            }
            case 5: {
                return pSDCDBTableBase.isPSDCDBTableIdDirty();
            }
            case 6: {
                return pSDCDBTableBase.isPSDCDBTableNameDirty();
            }
            case 7: {
                return pSDCDBTableBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBTableBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBTableBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBTableBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBTableBase pSDCDBTableBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBTableBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getPSDCDBTableId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbtableid", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getPSDCDBTableId()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getPSDCDBTableName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbtablename", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getPSDCDBTableName()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBTableBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBTableBase.getJSONValue((Object)pSDCDBTableBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBTableBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBTableBase pSDCDBTableBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBTableBase.getCreateDate() != null) {
            object = pSDCDBTableBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBTableBase.getCreateMan() != null) {
            object = pSDCDBTableBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getMemo() != null) {
            object = pSDCDBTableBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getPSDCDBInstId() != null) {
            object = pSDCDBTableBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getPSDCDBInstName() != null) {
            object = pSDCDBTableBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getPSDCDBTableId() != null) {
            object = pSDCDBTableBase.getPSDCDBTableId();
            xmlNode.setAttribute(FIELD_PSDCDBTABLEID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getPSDCDBTableName() != null) {
            object = pSDCDBTableBase.getPSDCDBTableName();
            xmlNode.setAttribute(FIELD_PSDCDBTABLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getSQL() != null) {
            object = pSDCDBTableBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBTableBase.getUpdateDate() != null) {
            object = pSDCDBTableBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBTableBase.getUpdateMan() != null) {
            object = pSDCDBTableBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBTableBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBTableBase pSDCDBTableBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBTableBase.isCreateDateDirty() && (bl || pSDCDBTableBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBTableBase.getCreateDate());
        }
        if (pSDCDBTableBase.isCreateManDirty() && (bl || pSDCDBTableBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBTableBase.getCreateMan());
        }
        if (pSDCDBTableBase.isMemoDirty() && (bl || pSDCDBTableBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBTableBase.getMemo());
        }
        if (pSDCDBTableBase.isPSDCDBInstIdDirty() && (bl || pSDCDBTableBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBTableBase.getPSDCDBInstId());
        }
        if (pSDCDBTableBase.isPSDCDBInstNameDirty() && (bl || pSDCDBTableBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBTableBase.getPSDCDBInstName());
        }
        if (pSDCDBTableBase.isPSDCDBTableIdDirty() && (bl || pSDCDBTableBase.getPSDCDBTableId() != null)) {
            iDataObject.set(FIELD_PSDCDBTABLEID, (Object)pSDCDBTableBase.getPSDCDBTableId());
        }
        if (pSDCDBTableBase.isPSDCDBTableNameDirty() && (bl || pSDCDBTableBase.getPSDCDBTableName() != null)) {
            iDataObject.set(FIELD_PSDCDBTABLENAME, (Object)pSDCDBTableBase.getPSDCDBTableName());
        }
        if (pSDCDBTableBase.isSQLDirty() && (bl || pSDCDBTableBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBTableBase.getSQL());
        }
        if (pSDCDBTableBase.isUpdateDateDirty() && (bl || pSDCDBTableBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBTableBase.getUpdateDate());
        }
        if (pSDCDBTableBase.isUpdateManDirty() && (bl || pSDCDBTableBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBTableBase.getUpdateMan());
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
        return PSDCDBTableBase.remove(this, n);
    }

    private static boolean remove(PSDCDBTableBase pSDCDBTableBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBTableBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBTableBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBTableBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBTableBase.resetPSDCDBInstId();
                return true;
            }
            case 4: {
                pSDCDBTableBase.resetPSDCDBInstName();
                return true;
            }
            case 5: {
                pSDCDBTableBase.resetPSDCDBTableId();
                return true;
            }
            case 6: {
                pSDCDBTableBase.resetPSDCDBTableName();
                return true;
            }
            case 7: {
                pSDCDBTableBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBTableBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBTableBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPSDDBInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDDBInst();
        }
        if (this.getPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPSDDBInstLock;
        synchronized (n) {
            if (this.psddbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDBInstId(), (Object)this.psddbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psddbinst = null;
            }
            if (this.psddbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psddbinst = pSDevCenterDBInst;
            }
            return this.psddbinst;
        }
    }

    private PSDCDBTableBase getProxyEntity() {
        return this.proxyPSDCDBTableBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBTableBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBTableBase) {
            this.proxyPSDCDBTableBase = (PSDCDBTableBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBTableService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBTABLEID, 5);
        fieldIndexMap.put(FIELD_PSDCDBTABLENAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

