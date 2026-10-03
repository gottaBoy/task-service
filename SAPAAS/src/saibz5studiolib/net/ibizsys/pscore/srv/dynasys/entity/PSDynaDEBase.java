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
package net.ibizsys.pscore.srv.dynasys.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaDEForm;
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaDEFormService;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaDEBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaDEBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNADEID = "PSDYNADEID";
    public static final String FIELD_PSDYNADENAME = "PSDYNADENAME";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNADEID = 4;
    private static final int INDEX_PSDYNADENAME = 5;
    private static final int INDEX_PSDYNASYSID = 6;
    private static final int INDEX_PSDYNASYSNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaDEBase proxyPSDynaDEBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynadeidDirtyFlag = false;
    private boolean psdynadenameDirtyFlag = false;
    private boolean psdynasysidDirtyFlag = false;
    private boolean psdynasysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psdynadeid")
    private String psdynadeid;
    @Column(name="psdynadename")
    private String psdynadename;
    @Column(name="psdynasysid")
    private String psdynasysid;
    @Column(name="psdynasysname")
    private String psdynasysname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDynaSysLock = new Integer(1);
    private PSDynaSys psdynasys = null;
    private Integer objPSDynaDEFormsLock = new Integer(1);
    private ArrayList<PSDynaDEForm> psdynadeforms = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSDynaDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadeid = string;
        this.psdynadeidDirtyFlag = true;
    }

    public String getPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEId();
        }
        return this.psdynadeid;
    }

    public boolean isPSDynaDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDEIdDirty();
        }
        return this.psdynadeidDirtyFlag;
    }

    public void resetPSDynaDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEId();
            return;
        }
        this.psdynadeidDirtyFlag = false;
        this.psdynadeid = null;
    }

    public void setPSDynaDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynadename = string;
        this.psdynadenameDirtyFlag = true;
    }

    public String getPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEName();
        }
        return this.psdynadename;
    }

    public boolean isPSDynaDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaDENameDirty();
        }
        return this.psdynadenameDirtyFlag;
    }

    public void resetPSDynaDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaDEName();
            return;
        }
        this.psdynadenameDirtyFlag = false;
        this.psdynadename = null;
    }

    public void setPSDynaSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysid = string;
        this.psdynasysidDirtyFlag = true;
    }

    public String getPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysId();
        }
        return this.psdynasysid;
    }

    public boolean isPSDynaSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysIdDirty();
        }
        return this.psdynasysidDirtyFlag;
    }

    public void resetPSDynaSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysId();
            return;
        }
        this.psdynasysidDirtyFlag = false;
        this.psdynasysid = null;
    }

    public void setPSDynaSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynasysname = string;
        this.psdynasysnameDirtyFlag = true;
    }

    public String getPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSysName();
        }
        return this.psdynasysname;
    }

    public boolean isPSDynaSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaSysNameDirty();
        }
        return this.psdynasysnameDirtyFlag;
    }

    public void resetPSDynaSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaSysName();
            return;
        }
        this.psdynasysnameDirtyFlag = false;
        this.psdynasysname = null;
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
        PSDynaDEBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaDEBase pSDynaDEBase) {
        pSDynaDEBase.resetCreateDate();
        pSDynaDEBase.resetCreateMan();
        pSDynaDEBase.resetLogicName();
        pSDynaDEBase.resetMemo();
        pSDynaDEBase.resetPSDynaDEId();
        pSDynaDEBase.resetPSDynaDEName();
        pSDynaDEBase.resetPSDynaSysId();
        pSDynaDEBase.resetPSDynaSysName();
        pSDynaDEBase.resetUpdateDate();
        pSDynaDEBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDynaDEIdDirty()) {
            hashMap.put(FIELD_PSDYNADEID, this.getPSDynaDEId());
        }
        if (!bl || this.isPSDynaDENameDirty()) {
            hashMap.put(FIELD_PSDYNADENAME, this.getPSDynaDEName());
        }
        if (!bl || this.isPSDynaSysIdDirty()) {
            hashMap.put(FIELD_PSDYNASYSID, this.getPSDynaSysId());
        }
        if (!bl || this.isPSDynaSysNameDirty()) {
            hashMap.put(FIELD_PSDYNASYSNAME, this.getPSDynaSysName());
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
        return PSDynaDEBase.get(this, n);
    }

    private static Object get(PSDynaDEBase pSDynaDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEBase.getCreateDate();
            }
            case 1: {
                return pSDynaDEBase.getCreateMan();
            }
            case 2: {
                return pSDynaDEBase.getLogicName();
            }
            case 3: {
                return pSDynaDEBase.getMemo();
            }
            case 4: {
                return pSDynaDEBase.getPSDynaDEId();
            }
            case 5: {
                return pSDynaDEBase.getPSDynaDEName();
            }
            case 6: {
                return pSDynaDEBase.getPSDynaSysId();
            }
            case 7: {
                return pSDynaDEBase.getPSDynaSysName();
            }
            case 8: {
                return pSDynaDEBase.getUpdateDate();
            }
            case 9: {
                return pSDynaDEBase.getUpdateMan();
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
        PSDynaDEBase.set(this, n, object);
    }

    private static void set(PSDynaDEBase pSDynaDEBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaDEBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaDEBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaDEBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaDEBase.setPSDynaDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaDEBase.setPSDynaDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaDEBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaDEBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaDEBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDynaDEBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaDEBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaDEBase pSDynaDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaDEBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaDEBase.getLogicName() == null;
            }
            case 3: {
                return pSDynaDEBase.getMemo() == null;
            }
            case 4: {
                return pSDynaDEBase.getPSDynaDEId() == null;
            }
            case 5: {
                return pSDynaDEBase.getPSDynaDEName() == null;
            }
            case 6: {
                return pSDynaDEBase.getPSDynaSysId() == null;
            }
            case 7: {
                return pSDynaDEBase.getPSDynaSysName() == null;
            }
            case 8: {
                return pSDynaDEBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDynaDEBase.getUpdateMan() == null;
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
        return PSDynaDEBase.contains(this, n);
    }

    private static boolean contains(PSDynaDEBase pSDynaDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaDEBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaDEBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaDEBase.isLogicNameDirty();
            }
            case 3: {
                return pSDynaDEBase.isMemoDirty();
            }
            case 4: {
                return pSDynaDEBase.isPSDynaDEIdDirty();
            }
            case 5: {
                return pSDynaDEBase.isPSDynaDENameDirty();
            }
            case 6: {
                return pSDynaDEBase.isPSDynaSysIdDirty();
            }
            case 7: {
                return pSDynaDEBase.isPSDynaSysNameDirty();
            }
            case 8: {
                return pSDynaDEBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDynaDEBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaDEBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaDEBase pSDynaDEBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaDEBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getPSDynaDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadeid", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getPSDynaDEId()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getPSDynaDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynadename", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getPSDynaDEName()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaDEBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaDEBase.getJSONValue((Object)pSDynaDEBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaDEBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaDEBase pSDynaDEBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaDEBase.getCreateDate() != null) {
            object = pSDynaDEBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEBase.getCreateMan() != null) {
            object = pSDynaDEBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getLogicName() != null) {
            object = pSDynaDEBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getMemo() != null) {
            object = pSDynaDEBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getPSDynaDEId() != null) {
            object = pSDynaDEBase.getPSDynaDEId();
            xmlNode.setAttribute(FIELD_PSDYNADEID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getPSDynaDEName() != null) {
            object = pSDynaDEBase.getPSDynaDEName();
            xmlNode.setAttribute(FIELD_PSDYNADENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getPSDynaSysId() != null) {
            object = pSDynaDEBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getPSDynaSysName() != null) {
            object = pSDynaDEBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaDEBase.getUpdateDate() != null) {
            object = pSDynaDEBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaDEBase.getUpdateMan() != null) {
            object = pSDynaDEBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaDEBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaDEBase pSDynaDEBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaDEBase.isCreateDateDirty() && (bl || pSDynaDEBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaDEBase.getCreateDate());
        }
        if (pSDynaDEBase.isCreateManDirty() && (bl || pSDynaDEBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaDEBase.getCreateMan());
        }
        if (pSDynaDEBase.isLogicNameDirty() && (bl || pSDynaDEBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDynaDEBase.getLogicName());
        }
        if (pSDynaDEBase.isMemoDirty() && (bl || pSDynaDEBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaDEBase.getMemo());
        }
        if (pSDynaDEBase.isPSDynaDEIdDirty() && (bl || pSDynaDEBase.getPSDynaDEId() != null)) {
            iDataObject.set(FIELD_PSDYNADEID, (Object)pSDynaDEBase.getPSDynaDEId());
        }
        if (pSDynaDEBase.isPSDynaDENameDirty() && (bl || pSDynaDEBase.getPSDynaDEName() != null)) {
            iDataObject.set(FIELD_PSDYNADENAME, (Object)pSDynaDEBase.getPSDynaDEName());
        }
        if (pSDynaDEBase.isPSDynaSysIdDirty() && (bl || pSDynaDEBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaDEBase.getPSDynaSysId());
        }
        if (pSDynaDEBase.isPSDynaSysNameDirty() && (bl || pSDynaDEBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaDEBase.getPSDynaSysName());
        }
        if (pSDynaDEBase.isUpdateDateDirty() && (bl || pSDynaDEBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaDEBase.getUpdateDate());
        }
        if (pSDynaDEBase.isUpdateManDirty() && (bl || pSDynaDEBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaDEBase.getUpdateMan());
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
        return PSDynaDEBase.remove(this, n);
    }

    private static boolean remove(PSDynaDEBase pSDynaDEBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaDEBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaDEBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaDEBase.resetLogicName();
                return true;
            }
            case 3: {
                pSDynaDEBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaDEBase.resetPSDynaDEId();
                return true;
            }
            case 5: {
                pSDynaDEBase.resetPSDynaDEName();
                return true;
            }
            case 6: {
                pSDynaDEBase.resetPSDynaSysId();
                return true;
            }
            case 7: {
                pSDynaDEBase.resetPSDynaSysName();
                return true;
            }
            case 8: {
                pSDynaDEBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDynaDEBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDynaSys getPSDynaSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaSys();
        }
        if (this.getPSDynaSysId() == null) {
            return null;
        }
        Integer n = this.objPSDynaSysLock;
        synchronized (n) {
            if (this.psdynasys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDynaSysId(), (Object)this.psdynasys.getPSDynaSysId()) != 0L) {
                this.psdynasys = null;
            }
            if (this.psdynasys == null) {
                PSDynaSys pSDynaSys = new PSDynaSys();
                pSDynaSys.setPSDynaSysId(this.getPSDynaSysId());
                PSDynaSysService pSDynaSysService = (PSDynaSysService)ServiceGlobal.getService(PSDynaSysService.class, (SessionFactory)this.getSessionFactory());
                pSDynaSysService.autoGet(pSDynaSys);
                this.psdynasys = pSDynaSys;
            }
            return this.psdynasys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDynaDEForm> getPSDynaDEForms() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaDEForms();
        }
        if (this.getPSDynaDEId() == null) {
            return null;
        }
        PSDynaDEFormService pSDynaDEFormService = (PSDynaDEFormService)ServiceGlobal.getService(PSDynaDEFormService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDynaDEFormsLock;
        synchronized (n) {
            if (this.psdynadeforms == null) {
                this.psdynadeforms = pSDynaDEFormService.selectByPSDynaDE(this);
            }
            return this.psdynadeforms;
        }
    }

    private PSDynaDEBase getProxyEntity() {
        return this.proxyPSDynaDEBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaDEBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaDEBase) {
            this.proxyPSDynaDEBase = (PSDynaDEBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaDEService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNADEID, 4);
        fieldIndexMap.put(FIELD_PSDYNADENAME, 5);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 6);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

