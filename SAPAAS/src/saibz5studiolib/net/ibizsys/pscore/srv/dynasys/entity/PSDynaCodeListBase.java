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
import net.ibizsys.pscore.srv.dynasys.entity.PSDynaSys;
import net.ibizsys.pscore.srv.dynasys.service.PSDynaSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDynaCodeListBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDynaCodeListBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDYNACODELISTID = "PSDYNACODELISTID";
    public static final String FIELD_PSDYNACODELISTNAME = "PSDYNACODELISTNAME";
    public static final String FIELD_PSDYNASYSID = "PSDYNASYSID";
    public static final String FIELD_PSDYNASYSNAME = "PSDYNASYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LOGICNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSDYNACODELISTID = 4;
    private static final int INDEX_PSDYNACODELISTNAME = 5;
    private static final int INDEX_PSDYNASYSID = 6;
    private static final int INDEX_PSDYNASYSNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDynaCodeListBase proxyPSDynaCodeListBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdynacodelistidDirtyFlag = false;
    private boolean psdynacodelistnameDirtyFlag = false;
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
    @Column(name="psdynacodelistid")
    private String psdynacodelistid;
    @Column(name="psdynacodelistname")
    private String psdynacodelistname;
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

    public void setPSDynaCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistid = string;
        this.psdynacodelistidDirtyFlag = true;
    }

    public String getPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListId();
        }
        return this.psdynacodelistid;
    }

    public boolean isPSDynaCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListIdDirty();
        }
        return this.psdynacodelistidDirtyFlag;
    }

    public void resetPSDynaCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListId();
            return;
        }
        this.psdynacodelistidDirtyFlag = false;
        this.psdynacodelistid = null;
    }

    public void setPSDynaCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynacodelistname = string;
        this.psdynacodelistnameDirtyFlag = true;
    }

    public String getPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaCodeListName();
        }
        return this.psdynacodelistname;
    }

    public boolean isPSDynaCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaCodeListNameDirty();
        }
        return this.psdynacodelistnameDirtyFlag;
    }

    public void resetPSDynaCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaCodeListName();
            return;
        }
        this.psdynacodelistnameDirtyFlag = false;
        this.psdynacodelistname = null;
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
        PSDynaCodeListBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDynaCodeListBase pSDynaCodeListBase) {
        pSDynaCodeListBase.resetCreateDate();
        pSDynaCodeListBase.resetCreateMan();
        pSDynaCodeListBase.resetLogicName();
        pSDynaCodeListBase.resetMemo();
        pSDynaCodeListBase.resetPSDynaCodeListId();
        pSDynaCodeListBase.resetPSDynaCodeListName();
        pSDynaCodeListBase.resetPSDynaSysId();
        pSDynaCodeListBase.resetPSDynaSysName();
        pSDynaCodeListBase.resetUpdateDate();
        pSDynaCodeListBase.resetUpdateMan();
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
        if (!bl || this.isPSDynaCodeListIdDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTID, this.getPSDynaCodeListId());
        }
        if (!bl || this.isPSDynaCodeListNameDirty()) {
            hashMap.put(FIELD_PSDYNACODELISTNAME, this.getPSDynaCodeListName());
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
        return PSDynaCodeListBase.get(this, n);
    }

    private static Object get(PSDynaCodeListBase pSDynaCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListBase.getCreateDate();
            }
            case 1: {
                return pSDynaCodeListBase.getCreateMan();
            }
            case 2: {
                return pSDynaCodeListBase.getLogicName();
            }
            case 3: {
                return pSDynaCodeListBase.getMemo();
            }
            case 4: {
                return pSDynaCodeListBase.getPSDynaCodeListId();
            }
            case 5: {
                return pSDynaCodeListBase.getPSDynaCodeListName();
            }
            case 6: {
                return pSDynaCodeListBase.getPSDynaSysId();
            }
            case 7: {
                return pSDynaCodeListBase.getPSDynaSysName();
            }
            case 8: {
                return pSDynaCodeListBase.getUpdateDate();
            }
            case 9: {
                return pSDynaCodeListBase.getUpdateMan();
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
        PSDynaCodeListBase.set(this, n, object);
    }

    private static void set(PSDynaCodeListBase pSDynaCodeListBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDynaCodeListBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDynaCodeListBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDynaCodeListBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDynaCodeListBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDynaCodeListBase.setPSDynaCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDynaCodeListBase.setPSDynaCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDynaCodeListBase.setPSDynaSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDynaCodeListBase.setPSDynaSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDynaCodeListBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDynaCodeListBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDynaCodeListBase.isNull(this, n);
    }

    private static boolean isNull(PSDynaCodeListBase pSDynaCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListBase.getCreateDate() == null;
            }
            case 1: {
                return pSDynaCodeListBase.getCreateMan() == null;
            }
            case 2: {
                return pSDynaCodeListBase.getLogicName() == null;
            }
            case 3: {
                return pSDynaCodeListBase.getMemo() == null;
            }
            case 4: {
                return pSDynaCodeListBase.getPSDynaCodeListId() == null;
            }
            case 5: {
                return pSDynaCodeListBase.getPSDynaCodeListName() == null;
            }
            case 6: {
                return pSDynaCodeListBase.getPSDynaSysId() == null;
            }
            case 7: {
                return pSDynaCodeListBase.getPSDynaSysName() == null;
            }
            case 8: {
                return pSDynaCodeListBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDynaCodeListBase.getUpdateMan() == null;
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
        return PSDynaCodeListBase.contains(this, n);
    }

    private static boolean contains(PSDynaCodeListBase pSDynaCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDynaCodeListBase.isCreateDateDirty();
            }
            case 1: {
                return pSDynaCodeListBase.isCreateManDirty();
            }
            case 2: {
                return pSDynaCodeListBase.isLogicNameDirty();
            }
            case 3: {
                return pSDynaCodeListBase.isMemoDirty();
            }
            case 4: {
                return pSDynaCodeListBase.isPSDynaCodeListIdDirty();
            }
            case 5: {
                return pSDynaCodeListBase.isPSDynaCodeListNameDirty();
            }
            case 6: {
                return pSDynaCodeListBase.isPSDynaSysIdDirty();
            }
            case 7: {
                return pSDynaCodeListBase.isPSDynaSysNameDirty();
            }
            case 8: {
                return pSDynaCodeListBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDynaCodeListBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDynaCodeListBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDynaCodeListBase pSDynaCodeListBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDynaCodeListBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getMemo()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getPSDynaCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistid", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getPSDynaCodeListId()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getPSDynaCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynacodelistname", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getPSDynaCodeListName()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getPSDynaSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysid", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getPSDynaSysId()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getPSDynaSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynasysname", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getPSDynaSysName()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDynaCodeListBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDynaCodeListBase.getJSONValue((Object)pSDynaCodeListBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDynaCodeListBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDynaCodeListBase pSDynaCodeListBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDynaCodeListBase.getCreateDate() != null) {
            object = pSDynaCodeListBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaCodeListBase.getCreateMan() != null) {
            object = pSDynaCodeListBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getLogicName() != null) {
            object = pSDynaCodeListBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getMemo() != null) {
            object = pSDynaCodeListBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getPSDynaCodeListId() != null) {
            object = pSDynaCodeListBase.getPSDynaCodeListId();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getPSDynaCodeListName() != null) {
            object = pSDynaCodeListBase.getPSDynaCodeListName();
            xmlNode.setAttribute(FIELD_PSDYNACODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getPSDynaSysId() != null) {
            object = pSDynaCodeListBase.getPSDynaSysId();
            xmlNode.setAttribute(FIELD_PSDYNASYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getPSDynaSysName() != null) {
            object = pSDynaCodeListBase.getPSDynaSysName();
            xmlNode.setAttribute(FIELD_PSDYNASYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDynaCodeListBase.getUpdateDate() != null) {
            object = pSDynaCodeListBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDynaCodeListBase.getUpdateMan() != null) {
            object = pSDynaCodeListBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDynaCodeListBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDynaCodeListBase pSDynaCodeListBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDynaCodeListBase.isCreateDateDirty() && (bl || pSDynaCodeListBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDynaCodeListBase.getCreateDate());
        }
        if (pSDynaCodeListBase.isCreateManDirty() && (bl || pSDynaCodeListBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDynaCodeListBase.getCreateMan());
        }
        if (pSDynaCodeListBase.isLogicNameDirty() && (bl || pSDynaCodeListBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDynaCodeListBase.getLogicName());
        }
        if (pSDynaCodeListBase.isMemoDirty() && (bl || pSDynaCodeListBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDynaCodeListBase.getMemo());
        }
        if (pSDynaCodeListBase.isPSDynaCodeListIdDirty() && (bl || pSDynaCodeListBase.getPSDynaCodeListId() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTID, (Object)pSDynaCodeListBase.getPSDynaCodeListId());
        }
        if (pSDynaCodeListBase.isPSDynaCodeListNameDirty() && (bl || pSDynaCodeListBase.getPSDynaCodeListName() != null)) {
            iDataObject.set(FIELD_PSDYNACODELISTNAME, (Object)pSDynaCodeListBase.getPSDynaCodeListName());
        }
        if (pSDynaCodeListBase.isPSDynaSysIdDirty() && (bl || pSDynaCodeListBase.getPSDynaSysId() != null)) {
            iDataObject.set(FIELD_PSDYNASYSID, (Object)pSDynaCodeListBase.getPSDynaSysId());
        }
        if (pSDynaCodeListBase.isPSDynaSysNameDirty() && (bl || pSDynaCodeListBase.getPSDynaSysName() != null)) {
            iDataObject.set(FIELD_PSDYNASYSNAME, (Object)pSDynaCodeListBase.getPSDynaSysName());
        }
        if (pSDynaCodeListBase.isUpdateDateDirty() && (bl || pSDynaCodeListBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDynaCodeListBase.getUpdateDate());
        }
        if (pSDynaCodeListBase.isUpdateManDirty() && (bl || pSDynaCodeListBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDynaCodeListBase.getUpdateMan());
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
        return PSDynaCodeListBase.remove(this, n);
    }

    private static boolean remove(PSDynaCodeListBase pSDynaCodeListBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDynaCodeListBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDynaCodeListBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDynaCodeListBase.resetLogicName();
                return true;
            }
            case 3: {
                pSDynaCodeListBase.resetMemo();
                return true;
            }
            case 4: {
                pSDynaCodeListBase.resetPSDynaCodeListId();
                return true;
            }
            case 5: {
                pSDynaCodeListBase.resetPSDynaCodeListName();
                return true;
            }
            case 6: {
                pSDynaCodeListBase.resetPSDynaSysId();
                return true;
            }
            case 7: {
                pSDynaCodeListBase.resetPSDynaSysName();
                return true;
            }
            case 8: {
                pSDynaCodeListBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDynaCodeListBase.resetUpdateMan();
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

    private PSDynaCodeListBase getProxyEntity() {
        return this.proxyPSDynaCodeListBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDynaCodeListBase = null;
        if (iDataObject != null && iDataObject instanceof PSDynaCodeListBase) {
            this.proxyPSDynaCodeListBase = (PSDynaCodeListBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDynaCodeListService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LOGICNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSDYNACODELISTID, 4);
        fieldIndexMap.put(FIELD_PSDYNACODELISTNAME, 5);
        fieldIndexMap.put(FIELD_PSDYNASYSID, 6);
        fieldIndexMap.put(FIELD_PSDYNASYSNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

