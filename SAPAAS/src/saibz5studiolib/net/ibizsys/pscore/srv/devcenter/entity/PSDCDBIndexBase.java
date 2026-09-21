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

public abstract class PSDCDBIndexBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBIndexBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBINDEXID = "PSDCDBINDEXID";
    public static final String FIELD_PSDCDBINDEXNAME = "PSDCDBINDEXNAME";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBINDEXID = 3;
    private static final int INDEX_PSDCDBINDEXNAME = 4;
    private static final int INDEX_PSDCDBINSTID = 5;
    private static final int INDEX_PSDCDBINSTNAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBIndexBase proxyPSDCDBIndexBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbindexidDirtyFlag = false;
    private boolean psdcdbindexnameDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean sqlDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcdbindexid")
    private String psdcdbindexid;
    @Column(name="psdcdbindexname")
    private String psdcdbindexname;
    @Column(name="psdcdbinstid")
    private String psdcdbinstid;
    @Column(name="psdcdbinstname")
    private String psdcdbinstname;
    @Column(name="sql")
    private String sql;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPsdcdbinstLock = new Integer(1);
    private PSDevCenterDBInst psdcdbinst = null;

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

    public void setPSDCDBIndexId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBIndexId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbindexid = string;
        this.psdcdbindexidDirtyFlag = true;
    }

    public String getPSDCDBIndexId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBIndexId();
        }
        return this.psdcdbindexid;
    }

    public boolean isPSDCDBIndexIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBIndexIdDirty();
        }
        return this.psdcdbindexidDirtyFlag;
    }

    public void resetPSDCDBIndexId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBIndexId();
            return;
        }
        this.psdcdbindexidDirtyFlag = false;
        this.psdcdbindexid = null;
    }

    public void setPSDCDBIndexName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBIndexName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbindexname = string;
        this.psdcdbindexnameDirtyFlag = true;
    }

    public String getPSDCDBIndexName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBIndexName();
        }
        return this.psdcdbindexname;
    }

    public boolean isPSDCDBIndexNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBIndexNameDirty();
        }
        return this.psdcdbindexnameDirtyFlag;
    }

    public void resetPSDCDBIndexName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBIndexName();
            return;
        }
        this.psdcdbindexnameDirtyFlag = false;
        this.psdcdbindexname = null;
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
        PSDCDBIndexBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBIndexBase pSDCDBIndexBase) {
        pSDCDBIndexBase.resetCreateDate();
        pSDCDBIndexBase.resetCreateMan();
        pSDCDBIndexBase.resetMemo();
        pSDCDBIndexBase.resetPSDCDBIndexId();
        pSDCDBIndexBase.resetPSDCDBIndexName();
        pSDCDBIndexBase.resetPSDCDBInstId();
        pSDCDBIndexBase.resetPSDCDBInstName();
        pSDCDBIndexBase.resetSQL();
        pSDCDBIndexBase.resetUpdateDate();
        pSDCDBIndexBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBIndexIdDirty()) {
            hashMap.put(FIELD_PSDCDBINDEXID, this.getPSDCDBIndexId());
        }
        if (!bl || this.isPSDCDBIndexNameDirty()) {
            hashMap.put(FIELD_PSDCDBINDEXNAME, this.getPSDCDBIndexName());
        }
        if (!bl || this.isPSDCDBInstIdDirty()) {
            hashMap.put(FIELD_PSDCDBINSTID, this.getPSDCDBInstId());
        }
        if (!bl || this.isPSDCDBInstNameDirty()) {
            hashMap.put(FIELD_PSDCDBINSTNAME, this.getPSDCDBInstName());
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
        return PSDCDBIndexBase.get(this, n);
    }

    private static Object get(PSDCDBIndexBase pSDCDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBIndexBase.getCreateDate();
            }
            case 1: {
                return pSDCDBIndexBase.getCreateMan();
            }
            case 2: {
                return pSDCDBIndexBase.getMemo();
            }
            case 3: {
                return pSDCDBIndexBase.getPSDCDBIndexId();
            }
            case 4: {
                return pSDCDBIndexBase.getPSDCDBIndexName();
            }
            case 5: {
                return pSDCDBIndexBase.getPSDCDBInstId();
            }
            case 6: {
                return pSDCDBIndexBase.getPSDCDBInstName();
            }
            case 7: {
                return pSDCDBIndexBase.getSQL();
            }
            case 8: {
                return pSDCDBIndexBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBIndexBase.getUpdateMan();
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
        PSDCDBIndexBase.set(this, n, object);
    }

    private static void set(PSDCDBIndexBase pSDCDBIndexBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBIndexBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBIndexBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBIndexBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBIndexBase.setPSDCDBIndexId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBIndexBase.setPSDCDBIndexName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBIndexBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBIndexBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBIndexBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBIndexBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBIndexBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBIndexBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBIndexBase pSDCDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBIndexBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBIndexBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBIndexBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBIndexBase.getPSDCDBIndexId() == null;
            }
            case 4: {
                return pSDCDBIndexBase.getPSDCDBIndexName() == null;
            }
            case 5: {
                return pSDCDBIndexBase.getPSDCDBInstId() == null;
            }
            case 6: {
                return pSDCDBIndexBase.getPSDCDBInstName() == null;
            }
            case 7: {
                return pSDCDBIndexBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBIndexBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBIndexBase.getUpdateMan() == null;
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
        return PSDCDBIndexBase.contains(this, n);
    }

    private static boolean contains(PSDCDBIndexBase pSDCDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBIndexBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBIndexBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBIndexBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBIndexBase.isPSDCDBIndexIdDirty();
            }
            case 4: {
                return pSDCDBIndexBase.isPSDCDBIndexNameDirty();
            }
            case 5: {
                return pSDCDBIndexBase.isPSDCDBInstIdDirty();
            }
            case 6: {
                return pSDCDBIndexBase.isPSDCDBInstNameDirty();
            }
            case 7: {
                return pSDCDBIndexBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBIndexBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBIndexBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBIndexBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBIndexBase pSDCDBIndexBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBIndexBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBIndexId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbindexid", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getPSDCDBIndexId()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBIndexName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbindexname", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getPSDCDBIndexName()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBIndexBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBIndexBase.getJSONValue((Object)pSDCDBIndexBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBIndexBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBIndexBase pSDCDBIndexBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBIndexBase.getCreateDate() != null) {
            object = pSDCDBIndexBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBIndexBase.getCreateMan() != null) {
            object = pSDCDBIndexBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getMemo() != null) {
            object = pSDCDBIndexBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBIndexId() != null) {
            object = pSDCDBIndexBase.getPSDCDBIndexId();
            xmlNode.setAttribute(FIELD_PSDCDBINDEXID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBIndexName() != null) {
            object = pSDCDBIndexBase.getPSDCDBIndexName();
            xmlNode.setAttribute(FIELD_PSDCDBINDEXNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBInstId() != null) {
            object = pSDCDBIndexBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getPSDCDBInstName() != null) {
            object = pSDCDBIndexBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getSQL() != null) {
            object = pSDCDBIndexBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBIndexBase.getUpdateDate() != null) {
            object = pSDCDBIndexBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBIndexBase.getUpdateMan() != null) {
            object = pSDCDBIndexBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBIndexBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBIndexBase pSDCDBIndexBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBIndexBase.isCreateDateDirty() && (bl || pSDCDBIndexBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBIndexBase.getCreateDate());
        }
        if (pSDCDBIndexBase.isCreateManDirty() && (bl || pSDCDBIndexBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBIndexBase.getCreateMan());
        }
        if (pSDCDBIndexBase.isMemoDirty() && (bl || pSDCDBIndexBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBIndexBase.getMemo());
        }
        if (pSDCDBIndexBase.isPSDCDBIndexIdDirty() && (bl || pSDCDBIndexBase.getPSDCDBIndexId() != null)) {
            iDataObject.set(FIELD_PSDCDBINDEXID, (Object)pSDCDBIndexBase.getPSDCDBIndexId());
        }
        if (pSDCDBIndexBase.isPSDCDBIndexNameDirty() && (bl || pSDCDBIndexBase.getPSDCDBIndexName() != null)) {
            iDataObject.set(FIELD_PSDCDBINDEXNAME, (Object)pSDCDBIndexBase.getPSDCDBIndexName());
        }
        if (pSDCDBIndexBase.isPSDCDBInstIdDirty() && (bl || pSDCDBIndexBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBIndexBase.getPSDCDBInstId());
        }
        if (pSDCDBIndexBase.isPSDCDBInstNameDirty() && (bl || pSDCDBIndexBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBIndexBase.getPSDCDBInstName());
        }
        if (pSDCDBIndexBase.isSQLDirty() && (bl || pSDCDBIndexBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBIndexBase.getSQL());
        }
        if (pSDCDBIndexBase.isUpdateDateDirty() && (bl || pSDCDBIndexBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBIndexBase.getUpdateDate());
        }
        if (pSDCDBIndexBase.isUpdateManDirty() && (bl || pSDCDBIndexBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBIndexBase.getUpdateMan());
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
        return PSDCDBIndexBase.remove(this, n);
    }

    private static boolean remove(PSDCDBIndexBase pSDCDBIndexBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBIndexBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBIndexBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBIndexBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBIndexBase.resetPSDCDBIndexId();
                return true;
            }
            case 4: {
                pSDCDBIndexBase.resetPSDCDBIndexName();
                return true;
            }
            case 5: {
                pSDCDBIndexBase.resetPSDCDBInstId();
                return true;
            }
            case 6: {
                pSDCDBIndexBase.resetPSDCDBInstName();
                return true;
            }
            case 7: {
                pSDCDBIndexBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBIndexBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBIndexBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterDBInst getPsdcdbinst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsdcdbinst();
        }
        if (this.getPSDCDBInstId() == null) {
            return null;
        }
        Integer n = this.objPsdcdbinstLock;
        synchronized (n) {
            if (this.psdcdbinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCDBInstId(), (Object)this.psdcdbinst.getPSDevCenterDBInstId()) != 0L) {
                this.psdcdbinst = null;
            }
            if (this.psdcdbinst == null) {
                PSDevCenterDBInst pSDevCenterDBInst = new PSDevCenterDBInst();
                pSDevCenterDBInst.setPSDevCenterDBInstId(this.getPSDCDBInstId());
                PSDevCenterDBInstService pSDevCenterDBInstService = (PSDevCenterDBInstService)ServiceGlobal.getService(PSDevCenterDBInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterDBInstService.autoGet((IEntity)pSDevCenterDBInst);
                this.psdcdbinst = pSDevCenterDBInst;
            }
            return this.psdcdbinst;
        }
    }

    private PSDCDBIndexBase getProxyEntity() {
        return this.proxyPSDCDBIndexBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBIndexBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBIndexBase) {
            this.proxyPSDCDBIndexBase = (PSDCDBIndexBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBIndexService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBINDEXID, 3);
        fieldIndexMap.put(FIELD_PSDCDBINDEXNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 5);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

