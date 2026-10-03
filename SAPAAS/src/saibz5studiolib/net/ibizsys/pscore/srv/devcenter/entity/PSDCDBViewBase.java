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

public abstract class PSDCDBViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCDBViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCDBINSTID = "PSDCDBINSTID";
    public static final String FIELD_PSDCDBINSTNAME = "PSDCDBINSTNAME";
    public static final String FIELD_PSDCDBVIEWID = "PSDCDBVIEWID";
    public static final String FIELD_PSDCDBVIEWNAME = "PSDCDBVIEWNAME";
    public static final String FIELD_SQL = "SQL";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDCDBINSTID = 3;
    private static final int INDEX_PSDCDBINSTNAME = 4;
    private static final int INDEX_PSDCDBVIEWID = 5;
    private static final int INDEX_PSDCDBVIEWNAME = 6;
    private static final int INDEX_SQL = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCDBViewBase proxyPSDCDBViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcdbinstidDirtyFlag = false;
    private boolean psdcdbinstnameDirtyFlag = false;
    private boolean psdcdbviewidDirtyFlag = false;
    private boolean psdcdbviewnameDirtyFlag = false;
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
    @Column(name="psdcdbviewid")
    private String psdcdbviewid;
    @Column(name="psdcdbviewname")
    private String psdcdbviewname;
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

    public void setPSDCDBViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbviewid = string;
        this.psdcdbviewidDirtyFlag = true;
    }

    public String getPSDCDBViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBViewId();
        }
        return this.psdcdbviewid;
    }

    public boolean isPSDCDBViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBViewIdDirty();
        }
        return this.psdcdbviewidDirtyFlag;
    }

    public void resetPSDCDBViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBViewId();
            return;
        }
        this.psdcdbviewidDirtyFlag = false;
        this.psdcdbviewid = null;
    }

    public void setPSDCDBViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCDBViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcdbviewname = string;
        this.psdcdbviewnameDirtyFlag = true;
    }

    public String getPSDCDBViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCDBViewName();
        }
        return this.psdcdbviewname;
    }

    public boolean isPSDCDBViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCDBViewNameDirty();
        }
        return this.psdcdbviewnameDirtyFlag;
    }

    public void resetPSDCDBViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCDBViewName();
            return;
        }
        this.psdcdbviewnameDirtyFlag = false;
        this.psdcdbviewname = null;
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
        PSDCDBViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCDBViewBase pSDCDBViewBase) {
        pSDCDBViewBase.resetCreateDate();
        pSDCDBViewBase.resetCreateMan();
        pSDCDBViewBase.resetMemo();
        pSDCDBViewBase.resetPSDCDBInstId();
        pSDCDBViewBase.resetPSDCDBInstName();
        pSDCDBViewBase.resetPSDCDBViewId();
        pSDCDBViewBase.resetPSDCDBViewName();
        pSDCDBViewBase.resetSQL();
        pSDCDBViewBase.resetUpdateDate();
        pSDCDBViewBase.resetUpdateMan();
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
        if (!bl || this.isPSDCDBViewIdDirty()) {
            hashMap.put(FIELD_PSDCDBVIEWID, this.getPSDCDBViewId());
        }
        if (!bl || this.isPSDCDBViewNameDirty()) {
            hashMap.put(FIELD_PSDCDBVIEWNAME, this.getPSDCDBViewName());
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
        return PSDCDBViewBase.get(this, n);
    }

    private static Object get(PSDCDBViewBase pSDCDBViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBViewBase.getCreateDate();
            }
            case 1: {
                return pSDCDBViewBase.getCreateMan();
            }
            case 2: {
                return pSDCDBViewBase.getMemo();
            }
            case 3: {
                return pSDCDBViewBase.getPSDCDBInstId();
            }
            case 4: {
                return pSDCDBViewBase.getPSDCDBInstName();
            }
            case 5: {
                return pSDCDBViewBase.getPSDCDBViewId();
            }
            case 6: {
                return pSDCDBViewBase.getPSDCDBViewName();
            }
            case 7: {
                return pSDCDBViewBase.getSQL();
            }
            case 8: {
                return pSDCDBViewBase.getUpdateDate();
            }
            case 9: {
                return pSDCDBViewBase.getUpdateMan();
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
        PSDCDBViewBase.set(this, n, object);
    }

    private static void set(PSDCDBViewBase pSDCDBViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCDBViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCDBViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCDBViewBase.setPSDCDBInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCDBViewBase.setPSDCDBInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCDBViewBase.setPSDCDBViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCDBViewBase.setPSDCDBViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCDBViewBase.setSQL(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCDBViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDCDBViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCDBViewBase.isNull(this, n);
    }

    private static boolean isNull(PSDCDBViewBase pSDCDBViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBViewBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCDBViewBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCDBViewBase.getMemo() == null;
            }
            case 3: {
                return pSDCDBViewBase.getPSDCDBInstId() == null;
            }
            case 4: {
                return pSDCDBViewBase.getPSDCDBInstName() == null;
            }
            case 5: {
                return pSDCDBViewBase.getPSDCDBViewId() == null;
            }
            case 6: {
                return pSDCDBViewBase.getPSDCDBViewName() == null;
            }
            case 7: {
                return pSDCDBViewBase.getSQL() == null;
            }
            case 8: {
                return pSDCDBViewBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDCDBViewBase.getUpdateMan() == null;
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
        return PSDCDBViewBase.contains(this, n);
    }

    private static boolean contains(PSDCDBViewBase pSDCDBViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCDBViewBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCDBViewBase.isCreateManDirty();
            }
            case 2: {
                return pSDCDBViewBase.isMemoDirty();
            }
            case 3: {
                return pSDCDBViewBase.isPSDCDBInstIdDirty();
            }
            case 4: {
                return pSDCDBViewBase.isPSDCDBInstNameDirty();
            }
            case 5: {
                return pSDCDBViewBase.isPSDCDBViewIdDirty();
            }
            case 6: {
                return pSDCDBViewBase.isPSDCDBViewNameDirty();
            }
            case 7: {
                return pSDCDBViewBase.isSQLDirty();
            }
            case 8: {
                return pSDCDBViewBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDCDBViewBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCDBViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCDBViewBase pSDCDBViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCDBViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getPSDCDBInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstid", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getPSDCDBInstId()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getPSDCDBInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbinstname", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getPSDCDBInstName()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getPSDCDBViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbviewid", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getPSDCDBViewId()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getPSDCDBViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcdbviewname", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getPSDCDBViewName()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getSQL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sql", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getSQL()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCDBViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCDBViewBase.getJSONValue((Object)pSDCDBViewBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCDBViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCDBViewBase pSDCDBViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCDBViewBase.getCreateDate() != null) {
            object = pSDCDBViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBViewBase.getCreateMan() != null) {
            object = pSDCDBViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getMemo() != null) {
            object = pSDCDBViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getPSDCDBInstId() != null) {
            object = pSDCDBViewBase.getPSDCDBInstId();
            xmlNode.setAttribute(FIELD_PSDCDBINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getPSDCDBInstName() != null) {
            object = pSDCDBViewBase.getPSDCDBInstName();
            xmlNode.setAttribute(FIELD_PSDCDBINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getPSDCDBViewId() != null) {
            object = pSDCDBViewBase.getPSDCDBViewId();
            xmlNode.setAttribute(FIELD_PSDCDBVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getPSDCDBViewName() != null) {
            object = pSDCDBViewBase.getPSDCDBViewName();
            xmlNode.setAttribute(FIELD_PSDCDBVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getSQL() != null) {
            object = pSDCDBViewBase.getSQL();
            xmlNode.setAttribute(FIELD_SQL, object == null ? "" : (String)object);
        }
        if (bl || pSDCDBViewBase.getUpdateDate() != null) {
            object = pSDCDBViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCDBViewBase.getUpdateMan() != null) {
            object = pSDCDBViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCDBViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCDBViewBase pSDCDBViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCDBViewBase.isCreateDateDirty() && (bl || pSDCDBViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCDBViewBase.getCreateDate());
        }
        if (pSDCDBViewBase.isCreateManDirty() && (bl || pSDCDBViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCDBViewBase.getCreateMan());
        }
        if (pSDCDBViewBase.isMemoDirty() && (bl || pSDCDBViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCDBViewBase.getMemo());
        }
        if (pSDCDBViewBase.isPSDCDBInstIdDirty() && (bl || pSDCDBViewBase.getPSDCDBInstId() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTID, (Object)pSDCDBViewBase.getPSDCDBInstId());
        }
        if (pSDCDBViewBase.isPSDCDBInstNameDirty() && (bl || pSDCDBViewBase.getPSDCDBInstName() != null)) {
            iDataObject.set(FIELD_PSDCDBINSTNAME, (Object)pSDCDBViewBase.getPSDCDBInstName());
        }
        if (pSDCDBViewBase.isPSDCDBViewIdDirty() && (bl || pSDCDBViewBase.getPSDCDBViewId() != null)) {
            iDataObject.set(FIELD_PSDCDBVIEWID, (Object)pSDCDBViewBase.getPSDCDBViewId());
        }
        if (pSDCDBViewBase.isPSDCDBViewNameDirty() && (bl || pSDCDBViewBase.getPSDCDBViewName() != null)) {
            iDataObject.set(FIELD_PSDCDBVIEWNAME, (Object)pSDCDBViewBase.getPSDCDBViewName());
        }
        if (pSDCDBViewBase.isSQLDirty() && (bl || pSDCDBViewBase.getSQL() != null)) {
            iDataObject.set(FIELD_SQL, (Object)pSDCDBViewBase.getSQL());
        }
        if (pSDCDBViewBase.isUpdateDateDirty() && (bl || pSDCDBViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCDBViewBase.getUpdateDate());
        }
        if (pSDCDBViewBase.isUpdateManDirty() && (bl || pSDCDBViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCDBViewBase.getUpdateMan());
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
        return PSDCDBViewBase.remove(this, n);
    }

    private static boolean remove(PSDCDBViewBase pSDCDBViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCDBViewBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCDBViewBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCDBViewBase.resetMemo();
                return true;
            }
            case 3: {
                pSDCDBViewBase.resetPSDCDBInstId();
                return true;
            }
            case 4: {
                pSDCDBViewBase.resetPSDCDBInstName();
                return true;
            }
            case 5: {
                pSDCDBViewBase.resetPSDCDBViewId();
                return true;
            }
            case 6: {
                pSDCDBViewBase.resetPSDCDBViewName();
                return true;
            }
            case 7: {
                pSDCDBViewBase.resetSQL();
                return true;
            }
            case 8: {
                pSDCDBViewBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDCDBViewBase.resetUpdateMan();
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

    private PSDCDBViewBase getProxyEntity() {
        return this.proxyPSDCDBViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCDBViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCDBViewBase) {
            this.proxyPSDCDBViewBase = (PSDCDBViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCDBViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDCDBINSTID, 3);
        fieldIndexMap.put(FIELD_PSDCDBINSTNAME, 4);
        fieldIndexMap.put(FIELD_PSDCDBVIEWID, 5);
        fieldIndexMap.put(FIELD_PSDCDBVIEWNAME, 6);
        fieldIndexMap.put(FIELD_SQL, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

