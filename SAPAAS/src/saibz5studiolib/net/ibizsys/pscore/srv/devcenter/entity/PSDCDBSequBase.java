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

public abstract class PSDCDBSequBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBSequBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_PSDCDBSEQUID = "PSDCDBSEQUID";
    public static final String FIELD_PSDCDBSEQUNAME = "PSDCDBSEQUNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBINSTID = 3;
    private static final int INDEX_PSDCDBINSTNAME = 4;
    private static final int INDEX_PSDCDBSEQUID = 5;
    private static final int INDEX_PSDCDBSEQUNAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBSequBase proxyPSDCDBSequBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean psdcdbsequidDirtyFlag = false;
    private boolean psdcdbsequnameDirtyFlag = false;
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
    @Column(name="psdcdbsequid")
    private String psdcdbsequid;
    @Column(name="psdcdbsequname")
    private String psdcdbsequname;
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

    public void setPSDCDBSequId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBSequId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbsequid = string;
        this.psdcdbsequidDirtyFlag = true;
    }

    public String getPSDCDBSequId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBSequId();
        }
        return this.psdcdbsequid;
    }

    public boolean isPSDCDBSequIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBSequIdDirty();
        }
        return this.psdcdbsequidDirtyFlag;
    }

    public void resetPSDCDBSequId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBSequId();
            return;
        }
        this.psdcdbsequidDirtyFlag = false;
        this.psdcdbsequid = null;
    }

    public void setPSDCDBSequName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBSequName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbsequname = string;
        this.psdcdbsequnameDirtyFlag = true;
    }

    public String getPSDCDBSequName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBSequName();
        }
        return this.psdcdbsequname;
    }

    public boolean isPSDCDBSequNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBSequNameDirty();
        }
        return this.psdcdbsequnameDirtyFlag;
    }

    public void resetPSDCDBSequName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBSequName();
            return;
        }
        this.psdcdbsequnameDirtyFlag = false;
        this.psdcdbsequname = null;
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
        PSDCDBSequBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBSequBase pSDCDBSequBase) {
        pSDCDBSequBase.resetCreateDate();
        pSDCDBSequBase.resetCreateMan();
        pSDCDBSequBase.resetMemo();
        pSDCDBSequBase.resetPSDCDBInstId();
        pSDCDBSequBase.resetPSDCDBInstName();
        pSDCDBSequBase.resetPSDCDBSequId();
        pSDCDBSequBase.resetPSDCDBSequName();
        pSDCDBSequBase.resetSQL();
        pSDCDBSequBase.resetUpdateDate();
        pSDCDBSequBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBSequIdDirty()) {
            hashMap.put(FIELD_PSDCDBSEQUID, this.getPSDCDBSequId());
        }
        if (!bl || this.isPSDCDBSequNameDirty()) {
            hashMap.put(FIELD_PSDCDBSEQUNAME, this.getPSDCDBSequName());
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
        return PSDCDBSequBase.get(this, n);
    }

    private static Object get(PSDCDBSequBase pSDCDBSequBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBSequBase.getCreateDate();
            }
            case 1: {
                return pSDCDBSequBase.getCreateMan();
            }
            case 2: {
                return pSDCDBSequBase.getMemo();
            }
            case 3: {
                return pSDCDBSequBase.getPSDCDBInstId();
            }
            case 4: {
                return pSDCDBSequBase.getPSDCDBInstName();
            }
            case 5: {
                return pSDCDBSequBase.getPSDCDBSequId();
            }
            case 6: {
                return pSDCDBSequBase.getPSDCDBSequName();
            }
            case 7: {
                return pSDCDBSequBase.getSQL();
            }
            case 8: {
                return pSDCDBSequBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBSequBase.getUpdateMan();
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
        PSDCDBSequBase.set(this, n, object);
    }

    private static void set(PSDCDBSequBase pSDCDBSequBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBSequBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBSequBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBSequBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBSequBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBSequBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBSequBase.setPSDCDBSequId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBSequBase.setPSDCDBSequName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBSequBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBSequBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBSequBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBSequBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBSequBase pSDCDBSequBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBSequBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBSequBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBSequBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBSequBase.getPSDCDBInstId() == null;
            }
            case 4: {
                return pSDCDBSequBase.getPSDCDBInstName() == null;
            }
            case 5: {
                return pSDCDBSequBase.getPSDCDBSequId() == null;
            }
            case 6: {
                return pSDCDBSequBase.getPSDCDBSequName() == null;
            }
            case 7: {
                return pSDCDBSequBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBSequBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBSequBase.getUpdateMan() == null;
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
        return PSDCDBSequBase.contains(this, n);
    }

    private static boolean contains(PSDCDBSequBase pSDCDBSequBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBSequBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBSequBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBSequBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBSequBase.isPSDCDBInstIdDirty();
            }
            case 4: {
                return pSDCDBSequBase.isPSDCDBInstNameDirty();
            }
            case 5: {
                return pSDCDBSequBase.isPSDCDBSequIdDirty();
            }
            case 6: {
                return pSDCDBSequBase.isPSDCDBSequNameDirty();
            }
            case 7: {
                return pSDCDBSequBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBSequBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBSequBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBSequBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBSequBase pSDCDBSequBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBSequBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getPSDCDBSequId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbsequid", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getPSDCDBSequId()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getPSDCDBSequName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbsequname", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getPSDCDBSequName()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBSequBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBSequBase.getJSONValue((Object)pSDCDBSequBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBSequBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBSequBase pSDCDBSequBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBSequBase.getCreateDate() != null) {
            object = pSDCDBSequBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBSequBase.getCreateMan() != null) {
            object = pSDCDBSequBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getMemo() != null) {
            object = pSDCDBSequBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getPSDCDBInstId() != null) {
            object = pSDCDBSequBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getPSDCDBInstName() != null) {
            object = pSDCDBSequBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getPSDCDBSequId() != null) {
            object = pSDCDBSequBase.getPSDCDBSequId();
            xmlNode.setAttribute(FIELD_PSDCDBSEQUID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getPSDCDBSequName() != null) {
            object = pSDCDBSequBase.getPSDCDBSequName();
            xmlNode.setAttribute(FIELD_PSDCDBSEQUNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getSQL() != null) {
            object = pSDCDBSequBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBSequBase.getUpdateDate() != null) {
            object = pSDCDBSequBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBSequBase.getUpdateMan() != null) {
            object = pSDCDBSequBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBSequBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBSequBase pSDCDBSequBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBSequBase.isCreateDateDirty() && (bl || pSDCDBSequBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBSequBase.getCreateDate());
        }
        if (pSDCDBSequBase.isCreateManDirty() && (bl || pSDCDBSequBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBSequBase.getCreateMan());
        }
        if (pSDCDBSequBase.isMemoDirty() && (bl || pSDCDBSequBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBSequBase.getMemo());
        }
        if (pSDCDBSequBase.isPSDCDBInstIdDirty() && (bl || pSDCDBSequBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBSequBase.getPSDCDBInstId());
        }
        if (pSDCDBSequBase.isPSDCDBInstNameDirty() && (bl || pSDCDBSequBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBSequBase.getPSDCDBInstName());
        }
        if (pSDCDBSequBase.isPSDCDBSequIdDirty() && (bl || pSDCDBSequBase.getPSDCDBSequId() != null)) {
            iDataObject.set(FIELD_PSDCDBSEQUID, (Object)pSDCDBSequBase.getPSDCDBSequId());
        }
        if (pSDCDBSequBase.isPSDCDBSequNameDirty() && (bl || pSDCDBSequBase.getPSDCDBSequName() != null)) {
            iDataObject.set(FIELD_PSDCDBSEQUNAME, (Object)pSDCDBSequBase.getPSDCDBSequName());
        }
        if (pSDCDBSequBase.isSQLDirty() && (bl || pSDCDBSequBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBSequBase.getSQL());
        }
        if (pSDCDBSequBase.isUpdateDateDirty() && (bl || pSDCDBSequBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBSequBase.getUpdateDate());
        }
        if (pSDCDBSequBase.isUpdateManDirty() && (bl || pSDCDBSequBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBSequBase.getUpdateMan());
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
        return PSDCDBSequBase.remove(this, n);
    }

    private static boolean remove(PSDCDBSequBase pSDCDBSequBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBSequBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBSequBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBSequBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBSequBase.resetPSDCDBInstId();
                return true;
            }
            case 4: {
                pSDCDBSequBase.resetPSDCDBInstName();
                return true;
            }
            case 5: {
                pSDCDBSequBase.resetPSDCDBSequId();
                return true;
            }
            case 6: {
                pSDCDBSequBase.resetPSDCDBSequName();
                return true;
            }
            case 7: {
                pSDCDBSequBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBSequBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBSequBase.resetUpdateMan();
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

    private PSDCDBSequBase getProxyEntity() {
        return this.proxyPSDCDBSequBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBSequBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBSequBase) {
            this.proxyPSDCDBSequBase = (PSDCDBSequBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBSequService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBSEQUID, 5);
        fieldIndexMap.put(FIELD_PSDCDBSEQUNAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

