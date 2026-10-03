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

public abstract class PSDCDBFuncBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBFuncBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBFUNCID = "PSDCDBFUNCID";
    public static final String FIELD_PSDCDBFUNCNAME = "PSDCDBFUNCNAME";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBFUNCID = 3;
    private static final int INDEX_PSDCDBFUNCNAME = 4;
    private static final int INDEX_PSDCDBINSTID = 5;
    private static final int INDEX_PSDCDBINSTNAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBFuncBase proxyPSDCDBFuncBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbfuncidDirtyFlag = false;
    private boolean psdcdbfuncnameDirtyFlag = false;
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
    @Column(name="psdcdbfuncid")
    private String psdcdbfuncid;
    @Column(name="psdcdbfuncname")
    private String psdcdbfuncname;
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

    public void setPSDCDBFuncId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBFuncId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbfuncid = string;
        this.psdcdbfuncidDirtyFlag = true;
    }

    public String getPSDCDBFuncId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBFuncId();
        }
        return this.psdcdbfuncid;
    }

    public boolean isPSDCDBFuncIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBFuncIdDirty();
        }
        return this.psdcdbfuncidDirtyFlag;
    }

    public void resetPSDCDBFuncId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBFuncId();
            return;
        }
        this.psdcdbfuncidDirtyFlag = false;
        this.psdcdbfuncid = null;
    }

    public void setPSDCDBFuncName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBFuncName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbfuncname = string;
        this.psdcdbfuncnameDirtyFlag = true;
    }

    public String getPSDCDBFuncName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBFuncName();
        }
        return this.psdcdbfuncname;
    }

    public boolean isPSDCDBFuncNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBFuncNameDirty();
        }
        return this.psdcdbfuncnameDirtyFlag;
    }

    public void resetPSDCDBFuncName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBFuncName();
            return;
        }
        this.psdcdbfuncnameDirtyFlag = false;
        this.psdcdbfuncname = null;
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
        PSDCDBFuncBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBFuncBase pSDCDBFuncBase) {
        pSDCDBFuncBase.resetCreateDate();
        pSDCDBFuncBase.resetCreateMan();
        pSDCDBFuncBase.resetMemo();
        pSDCDBFuncBase.resetPSDCDBFuncId();
        pSDCDBFuncBase.resetPSDCDBFuncName();
        pSDCDBFuncBase.resetPSDCDBInstId();
        pSDCDBFuncBase.resetPSDCDBInstName();
        pSDCDBFuncBase.resetSQL();
        pSDCDBFuncBase.resetUpdateDate();
        pSDCDBFuncBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBFuncIdDirty()) {
            hashMap.put(FIELD_PSDCDBFUNCID, this.getPSDCDBFuncId());
        }
        if (!bl || this.isPSDCDBFuncNameDirty()) {
            hashMap.put(FIELD_PSDCDBFUNCNAME, this.getPSDCDBFuncName());
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
        return PSDCDBFuncBase.get(this, n);
    }

    private static Object get(PSDCDBFuncBase pSDCDBFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBFuncBase.getCreateDate();
            }
            case 1: {
                return pSDCDBFuncBase.getCreateMan();
            }
            case 2: {
                return pSDCDBFuncBase.getMemo();
            }
            case 3: {
                return pSDCDBFuncBase.getPSDCDBFuncId();
            }
            case 4: {
                return pSDCDBFuncBase.getPSDCDBFuncName();
            }
            case 5: {
                return pSDCDBFuncBase.getPSDCDBInstId();
            }
            case 6: {
                return pSDCDBFuncBase.getPSDCDBInstName();
            }
            case 7: {
                return pSDCDBFuncBase.getSQL();
            }
            case 8: {
                return pSDCDBFuncBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBFuncBase.getUpdateMan();
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
        PSDCDBFuncBase.set(this, n, object);
    }

    private static void set(PSDCDBFuncBase pSDCDBFuncBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBFuncBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBFuncBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBFuncBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBFuncBase.setPSDCDBFuncId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBFuncBase.setPSDCDBFuncName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBFuncBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBFuncBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBFuncBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBFuncBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBFuncBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBFuncBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBFuncBase pSDCDBFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBFuncBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBFuncBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBFuncBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBFuncBase.getPSDCDBFuncId() == null;
            }
            case 4: {
                return pSDCDBFuncBase.getPSDCDBFuncName() == null;
            }
            case 5: {
                return pSDCDBFuncBase.getPSDCDBInstId() == null;
            }
            case 6: {
                return pSDCDBFuncBase.getPSDCDBInstName() == null;
            }
            case 7: {
                return pSDCDBFuncBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBFuncBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBFuncBase.getUpdateMan() == null;
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
        return PSDCDBFuncBase.contains(this, n);
    }

    private static boolean contains(PSDCDBFuncBase pSDCDBFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBFuncBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBFuncBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBFuncBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBFuncBase.isPSDCDBFuncIdDirty();
            }
            case 4: {
                return pSDCDBFuncBase.isPSDCDBFuncNameDirty();
            }
            case 5: {
                return pSDCDBFuncBase.isPSDCDBInstIdDirty();
            }
            case 6: {
                return pSDCDBFuncBase.isPSDCDBInstNameDirty();
            }
            case 7: {
                return pSDCDBFuncBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBFuncBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBFuncBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBFuncBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBFuncBase pSDCDBFuncBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBFuncBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBFuncId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbfuncid", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getPSDCDBFuncId()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBFuncName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbfuncname", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getPSDCDBFuncName()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBFuncBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBFuncBase.getJSONValue((Object)pSDCDBFuncBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBFuncBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBFuncBase pSDCDBFuncBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBFuncBase.getCreateDate() != null) {
            object = pSDCDBFuncBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBFuncBase.getCreateMan() != null) {
            object = pSDCDBFuncBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getMemo() != null) {
            object = pSDCDBFuncBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBFuncId() != null) {
            object = pSDCDBFuncBase.getPSDCDBFuncId();
            xmlNode.setAttribute(FIELD_PSDCDBFUNCID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBFuncName() != null) {
            object = pSDCDBFuncBase.getPSDCDBFuncName();
            xmlNode.setAttribute(FIELD_PSDCDBFUNCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBInstId() != null) {
            object = pSDCDBFuncBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getPSDCDBInstName() != null) {
            object = pSDCDBFuncBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getSQL() != null) {
            object = pSDCDBFuncBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBFuncBase.getUpdateDate() != null) {
            object = pSDCDBFuncBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBFuncBase.getUpdateMan() != null) {
            object = pSDCDBFuncBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBFuncBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBFuncBase pSDCDBFuncBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBFuncBase.isCreateDateDirty() && (bl || pSDCDBFuncBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBFuncBase.getCreateDate());
        }
        if (pSDCDBFuncBase.isCreateManDirty() && (bl || pSDCDBFuncBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBFuncBase.getCreateMan());
        }
        if (pSDCDBFuncBase.isMemoDirty() && (bl || pSDCDBFuncBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBFuncBase.getMemo());
        }
        if (pSDCDBFuncBase.isPSDCDBFuncIdDirty() && (bl || pSDCDBFuncBase.getPSDCDBFuncId() != null)) {
            iDataObject.set(FIELD_PSDCDBFUNCID, (Object)pSDCDBFuncBase.getPSDCDBFuncId());
        }
        if (pSDCDBFuncBase.isPSDCDBFuncNameDirty() && (bl || pSDCDBFuncBase.getPSDCDBFuncName() != null)) {
            iDataObject.set(FIELD_PSDCDBFUNCNAME, (Object)pSDCDBFuncBase.getPSDCDBFuncName());
        }
        if (pSDCDBFuncBase.isPSDCDBInstIdDirty() && (bl || pSDCDBFuncBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBFuncBase.getPSDCDBInstId());
        }
        if (pSDCDBFuncBase.isPSDCDBInstNameDirty() && (bl || pSDCDBFuncBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBFuncBase.getPSDCDBInstName());
        }
        if (pSDCDBFuncBase.isSQLDirty() && (bl || pSDCDBFuncBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBFuncBase.getSQL());
        }
        if (pSDCDBFuncBase.isUpdateDateDirty() && (bl || pSDCDBFuncBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBFuncBase.getUpdateDate());
        }
        if (pSDCDBFuncBase.isUpdateManDirty() && (bl || pSDCDBFuncBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBFuncBase.getUpdateMan());
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
        return PSDCDBFuncBase.remove(this, n);
    }

    private static boolean remove(PSDCDBFuncBase pSDCDBFuncBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBFuncBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBFuncBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBFuncBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBFuncBase.resetPSDCDBFuncId();
                return true;
            }
            case 4: {
                pSDCDBFuncBase.resetPSDCDBFuncName();
                return true;
            }
            case 5: {
                pSDCDBFuncBase.resetPSDCDBInstId();
                return true;
            }
            case 6: {
                pSDCDBFuncBase.resetPSDCDBInstName();
                return true;
            }
            case 7: {
                pSDCDBFuncBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBFuncBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBFuncBase.resetUpdateMan();
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
                pSDevCenterDBInstService.autoGet(pSDevCenterDBInst);
                this.psdcdbinst = pSDevCenterDBInst;
            }
            return this.psdcdbinst;
        }
    }

    private PSDCDBFuncBase getProxyEntity() {
        return this.proxyPSDCDBFuncBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBFuncBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBFuncBase) {
            this.proxyPSDCDBFuncBase = (PSDCDBFuncBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBFuncService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBFUNCID, 3);
        fieldIndexMap.put(FIELD_PSDCDBFUNCNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 5);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

