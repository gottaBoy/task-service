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

public abstract class PSDCDBProcBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBProcBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_PSDCDBPROCID = "PSDCDBPROCID";
    public static final String FIELD_PSDCDBPROCNAME = "PSDCDBPROCNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBINSTID = 3;
    private static final int INDEX_PSDCDBINSTNAME = 4;
    private static final int INDEX_PSDCDBPROCID = 5;
    private static final int INDEX_PSDCDBPROCNAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBProcBase proxyPSDCDBProcBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean psdcdbprocidDirtyFlag = false;
    private boolean psdcdbprocnameDirtyFlag = false;
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
    @Column(name="psdcdbprocid")
    private String psdcdbprocid;
    @Column(name="psdcdbprocname")
    private String psdcdbprocname;
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

    public void setPSDCDBProcId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBProcId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbprocid = string;
        this.psdcdbprocidDirtyFlag = true;
    }

    public String getPSDCDBProcId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBProcId();
        }
        return this.psdcdbprocid;
    }

    public boolean isPSDCDBProcIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBProcIdDirty();
        }
        return this.psdcdbprocidDirtyFlag;
    }

    public void resetPSDCDBProcId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBProcId();
            return;
        }
        this.psdcdbprocidDirtyFlag = false;
        this.psdcdbprocid = null;
    }

    public void setPSDCDBProcName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBProcName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbprocname = string;
        this.psdcdbprocnameDirtyFlag = true;
    }

    public String getPSDCDBProcName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBProcName();
        }
        return this.psdcdbprocname;
    }

    public boolean isPSDCDBProcNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBProcNameDirty();
        }
        return this.psdcdbprocnameDirtyFlag;
    }

    public void resetPSDCDBProcName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBProcName();
            return;
        }
        this.psdcdbprocnameDirtyFlag = false;
        this.psdcdbprocname = null;
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
        PSDCDBProcBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBProcBase pSDCDBProcBase) {
        pSDCDBProcBase.resetCreateDate();
        pSDCDBProcBase.resetCreateMan();
        pSDCDBProcBase.resetMemo();
        pSDCDBProcBase.resetPSDCDBInstId();
        pSDCDBProcBase.resetPSDCDBInstName();
        pSDCDBProcBase.resetPSDCDBProcId();
        pSDCDBProcBase.resetPSDCDBProcName();
        pSDCDBProcBase.resetSQL();
        pSDCDBProcBase.resetUpdateDate();
        pSDCDBProcBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBProcIdDirty()) {
            hashMap.put(FIELD_PSDCDBPROCID, this.getPSDCDBProcId());
        }
        if (!bl || this.isPSDCDBProcNameDirty()) {
            hashMap.put(FIELD_PSDCDBPROCNAME, this.getPSDCDBProcName());
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
        return PSDCDBProcBase.get(this, n);
    }

    private static Object get(PSDCDBProcBase pSDCDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBProcBase.getCreateDate();
            }
            case 1: {
                return pSDCDBProcBase.getCreateMan();
            }
            case 2: {
                return pSDCDBProcBase.getMemo();
            }
            case 3: {
                return pSDCDBProcBase.getPSDCDBInstId();
            }
            case 4: {
                return pSDCDBProcBase.getPSDCDBInstName();
            }
            case 5: {
                return pSDCDBProcBase.getPSDCDBProcId();
            }
            case 6: {
                return pSDCDBProcBase.getPSDCDBProcName();
            }
            case 7: {
                return pSDCDBProcBase.getSQL();
            }
            case 8: {
                return pSDCDBProcBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBProcBase.getUpdateMan();
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
        PSDCDBProcBase.set(this, n, object);
    }

    private static void set(PSDCDBProcBase pSDCDBProcBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBProcBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBProcBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBProcBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBProcBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBProcBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBProcBase.setPSDCDBProcId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBProcBase.setPSDCDBProcName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBProcBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBProcBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBProcBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBProcBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBProcBase pSDCDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBProcBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBProcBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBProcBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBProcBase.getPSDCDBInstId() == null;
            }
            case 4: {
                return pSDCDBProcBase.getPSDCDBInstName() == null;
            }
            case 5: {
                return pSDCDBProcBase.getPSDCDBProcId() == null;
            }
            case 6: {
                return pSDCDBProcBase.getPSDCDBProcName() == null;
            }
            case 7: {
                return pSDCDBProcBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBProcBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBProcBase.getUpdateMan() == null;
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
        return PSDCDBProcBase.contains(this, n);
    }

    private static boolean contains(PSDCDBProcBase pSDCDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBProcBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBProcBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBProcBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBProcBase.isPSDCDBInstIdDirty();
            }
            case 4: {
                return pSDCDBProcBase.isPSDCDBInstNameDirty();
            }
            case 5: {
                return pSDCDBProcBase.isPSDCDBProcIdDirty();
            }
            case 6: {
                return pSDCDBProcBase.isPSDCDBProcNameDirty();
            }
            case 7: {
                return pSDCDBProcBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBProcBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBProcBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBProcBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBProcBase pSDCDBProcBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBProcBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getPSDCDBProcId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbprocid", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getPSDCDBProcId()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getPSDCDBProcName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbprocname", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getPSDCDBProcName()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBProcBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBProcBase.getJSONValue((Object)pSDCDBProcBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBProcBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBProcBase pSDCDBProcBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBProcBase.getCreateDate() != null) {
            object = pSDCDBProcBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBProcBase.getCreateMan() != null) {
            object = pSDCDBProcBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getMemo() != null) {
            object = pSDCDBProcBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getPSDCDBInstId() != null) {
            object = pSDCDBProcBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getPSDCDBInstName() != null) {
            object = pSDCDBProcBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getPSDCDBProcId() != null) {
            object = pSDCDBProcBase.getPSDCDBProcId();
            xmlNode.setAttribute(FIELD_PSDCDBPROCID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getPSDCDBProcName() != null) {
            object = pSDCDBProcBase.getPSDCDBProcName();
            xmlNode.setAttribute(FIELD_PSDCDBPROCNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getSQL() != null) {
            object = pSDCDBProcBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBProcBase.getUpdateDate() != null) {
            object = pSDCDBProcBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBProcBase.getUpdateMan() != null) {
            object = pSDCDBProcBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBProcBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBProcBase pSDCDBProcBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBProcBase.isCreateDateDirty() && (bl || pSDCDBProcBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBProcBase.getCreateDate());
        }
        if (pSDCDBProcBase.isCreateManDirty() && (bl || pSDCDBProcBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBProcBase.getCreateMan());
        }
        if (pSDCDBProcBase.isMemoDirty() && (bl || pSDCDBProcBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBProcBase.getMemo());
        }
        if (pSDCDBProcBase.isPSDCDBInstIdDirty() && (bl || pSDCDBProcBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBProcBase.getPSDCDBInstId());
        }
        if (pSDCDBProcBase.isPSDCDBInstNameDirty() && (bl || pSDCDBProcBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBProcBase.getPSDCDBInstName());
        }
        if (pSDCDBProcBase.isPSDCDBProcIdDirty() && (bl || pSDCDBProcBase.getPSDCDBProcId() != null)) {
            iDataObject.set(FIELD_PSDCDBPROCID, (Object)pSDCDBProcBase.getPSDCDBProcId());
        }
        if (pSDCDBProcBase.isPSDCDBProcNameDirty() && (bl || pSDCDBProcBase.getPSDCDBProcName() != null)) {
            iDataObject.set(FIELD_PSDCDBPROCNAME, (Object)pSDCDBProcBase.getPSDCDBProcName());
        }
        if (pSDCDBProcBase.isSQLDirty() && (bl || pSDCDBProcBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBProcBase.getSQL());
        }
        if (pSDCDBProcBase.isUpdateDateDirty() && (bl || pSDCDBProcBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBProcBase.getUpdateDate());
        }
        if (pSDCDBProcBase.isUpdateManDirty() && (bl || pSDCDBProcBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBProcBase.getUpdateMan());
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
        return PSDCDBProcBase.remove(this, n);
    }

    private static boolean remove(PSDCDBProcBase pSDCDBProcBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBProcBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBProcBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBProcBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBProcBase.resetPSDCDBInstId();
                return true;
            }
            case 4: {
                pSDCDBProcBase.resetPSDCDBInstName();
                return true;
            }
            case 5: {
                pSDCDBProcBase.resetPSDCDBProcId();
                return true;
            }
            case 6: {
                pSDCDBProcBase.resetPSDCDBProcName();
                return true;
            }
            case 7: {
                pSDCDBProcBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBProcBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBProcBase.resetUpdateMan();
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

    private PSDCDBProcBase getProxyEntity() {
        return this.proxyPSDCDBProcBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBProcBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBProcBase) {
            this.proxyPSDCDBProcBase = (PSDCDBProcBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBProcService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBPROCID, 5);
        fieldIndexMap.put(FIELD_PSDCDBPROCNAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

