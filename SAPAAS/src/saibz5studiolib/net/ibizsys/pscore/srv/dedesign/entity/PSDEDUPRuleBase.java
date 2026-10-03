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
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDUPRuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDUPRuleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEDUPRULEID = "PSDEDUPRULEID";
    public static final String FIELD_PSDEDUPRULENAME = "PSDEDUPRULENAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEDUPRULEID = 3;
    private static final int INDEX_PSDEDUPRULENAME = 4;
    private static final int INDEX_PSDEID = 5;
    private static final int INDEX_PSDENAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDUPRuleBase proxyPSDEDUPRuleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdedupruleidDirtyFlag = false;
    private boolean psdeduprulenameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdedupruleid")
    private String psdedupruleid;
    @Column(name="psdeduprulename")
    private String psdeduprulename;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;

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

    public void setPSDEDUPRuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDUPRuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedupruleid = string;
        this.psdedupruleidDirtyFlag = true;
    }

    public String getPSDEDUPRuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDUPRuleId();
        }
        return this.psdedupruleid;
    }

    public boolean isPSDEDUPRuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDUPRuleIdDirty();
        }
        return this.psdedupruleidDirtyFlag;
    }

    public void resetPSDEDUPRuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDUPRuleId();
            return;
        }
        this.psdedupruleidDirtyFlag = false;
        this.psdedupruleid = null;
    }

    public void setPSDEDUPRuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDUPRuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeduprulename = string;
        this.psdeduprulenameDirtyFlag = true;
    }

    public String getPSDEDUPRuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDUPRuleName();
        }
        return this.psdeduprulename;
    }

    public boolean isPSDEDUPRuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDUPRuleNameDirty();
        }
        return this.psdeduprulenameDirtyFlag;
    }

    public void resetPSDEDUPRuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDUPRuleName();
            return;
        }
        this.psdeduprulenameDirtyFlag = false;
        this.psdeduprulename = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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
        PSDEDUPRuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDUPRuleBase pSDEDUPRuleBase) {
        pSDEDUPRuleBase.resetCreateDate();
        pSDEDUPRuleBase.resetCreateMan();
        pSDEDUPRuleBase.resetMemo();
        pSDEDUPRuleBase.resetPSDEDUPRuleId();
        pSDEDUPRuleBase.resetPSDEDUPRuleName();
        pSDEDUPRuleBase.resetPSDEId();
        pSDEDUPRuleBase.resetPSDEName();
        pSDEDUPRuleBase.resetUpdateDate();
        pSDEDUPRuleBase.resetUpdateMan();
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
        if (!bl || this.isPSDEDUPRuleIdDirty()) {
            hashMap.put(FIELD_PSDEDUPRULEID, this.getPSDEDUPRuleId());
        }
        if (!bl || this.isPSDEDUPRuleNameDirty()) {
            hashMap.put(FIELD_PSDEDUPRULENAME, this.getPSDEDUPRuleName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
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
        return PSDEDUPRuleBase.get(this, n);
    }

    private static Object get(PSDEDUPRuleBase pSDEDUPRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleBase.getCreateDate();
            }
            case 1: {
                return pSDEDUPRuleBase.getCreateMan();
            }
            case 2: {
                return pSDEDUPRuleBase.getMemo();
            }
            case 3: {
                return pSDEDUPRuleBase.getPSDEDUPRuleId();
            }
            case 4: {
                return pSDEDUPRuleBase.getPSDEDUPRuleName();
            }
            case 5: {
                return pSDEDUPRuleBase.getPSDEId();
            }
            case 6: {
                return pSDEDUPRuleBase.getPSDEName();
            }
            case 7: {
                return pSDEDUPRuleBase.getUpdateDate();
            }
            case 8: {
                return pSDEDUPRuleBase.getUpdateMan();
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
        PSDEDUPRuleBase.set(this, n, object);
    }

    private static void set(PSDEDUPRuleBase pSDEDUPRuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDUPRuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDUPRuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDUPRuleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDUPRuleBase.setPSDEDUPRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDUPRuleBase.setPSDEDUPRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDUPRuleBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDUPRuleBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEDUPRuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEDUPRuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDUPRuleBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDUPRuleBase pSDEDUPRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDUPRuleBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDUPRuleBase.getMemo() == null;
            }
            case 3: {
                return pSDEDUPRuleBase.getPSDEDUPRuleId() == null;
            }
            case 4: {
                return pSDEDUPRuleBase.getPSDEDUPRuleName() == null;
            }
            case 5: {
                return pSDEDUPRuleBase.getPSDEId() == null;
            }
            case 6: {
                return pSDEDUPRuleBase.getPSDEName() == null;
            }
            case 7: {
                return pSDEDUPRuleBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDEDUPRuleBase.getUpdateMan() == null;
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
        return PSDEDUPRuleBase.contains(this, n);
    }

    private static boolean contains(PSDEDUPRuleBase pSDEDUPRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDUPRuleBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDUPRuleBase.isMemoDirty();
            }
            case 3: {
                return pSDEDUPRuleBase.isPSDEDUPRuleIdDirty();
            }
            case 4: {
                return pSDEDUPRuleBase.isPSDEDUPRuleNameDirty();
            }
            case 5: {
                return pSDEDUPRuleBase.isPSDEIdDirty();
            }
            case 6: {
                return pSDEDUPRuleBase.isPSDENameDirty();
            }
            case 7: {
                return pSDEDUPRuleBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDEDUPRuleBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDUPRuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDUPRuleBase pSDEDUPRuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDUPRuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getPSDEDUPRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedupruleid", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getPSDEDUPRuleId()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getPSDEDUPRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeduprulename", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getPSDEDUPRuleName()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDUPRuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDUPRuleBase.getJSONValue((Object)pSDEDUPRuleBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDUPRuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDUPRuleBase pSDEDUPRuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDUPRuleBase.getCreateDate() != null) {
            object = pSDEDUPRuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDUPRuleBase.getCreateMan() != null) {
            object = pSDEDUPRuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getMemo() != null) {
            object = pSDEDUPRuleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getPSDEDUPRuleId() != null) {
            object = pSDEDUPRuleBase.getPSDEDUPRuleId();
            xmlNode.setAttribute(FIELD_PSDEDUPRULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getPSDEDUPRuleName() != null) {
            object = pSDEDUPRuleBase.getPSDEDUPRuleName();
            xmlNode.setAttribute(FIELD_PSDEDUPRULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getPSDEId() != null) {
            object = pSDEDUPRuleBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getPSDEName() != null) {
            object = pSDEDUPRuleBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleBase.getUpdateDate() != null) {
            object = pSDEDUPRuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDUPRuleBase.getUpdateMan() != null) {
            object = pSDEDUPRuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDUPRuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDUPRuleBase pSDEDUPRuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDUPRuleBase.isCreateDateDirty() && (bl || pSDEDUPRuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDUPRuleBase.getCreateDate());
        }
        if (pSDEDUPRuleBase.isCreateManDirty() && (bl || pSDEDUPRuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDUPRuleBase.getCreateMan());
        }
        if (pSDEDUPRuleBase.isMemoDirty() && (bl || pSDEDUPRuleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEDUPRuleBase.getMemo());
        }
        if (pSDEDUPRuleBase.isPSDEDUPRuleIdDirty() && (bl || pSDEDUPRuleBase.getPSDEDUPRuleId() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULEID, (Object)pSDEDUPRuleBase.getPSDEDUPRuleId());
        }
        if (pSDEDUPRuleBase.isPSDEDUPRuleNameDirty() && (bl || pSDEDUPRuleBase.getPSDEDUPRuleName() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULENAME, (Object)pSDEDUPRuleBase.getPSDEDUPRuleName());
        }
        if (pSDEDUPRuleBase.isPSDEIdDirty() && (bl || pSDEDUPRuleBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEDUPRuleBase.getPSDEId());
        }
        if (pSDEDUPRuleBase.isPSDENameDirty() && (bl || pSDEDUPRuleBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEDUPRuleBase.getPSDEName());
        }
        if (pSDEDUPRuleBase.isUpdateDateDirty() && (bl || pSDEDUPRuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDUPRuleBase.getUpdateDate());
        }
        if (pSDEDUPRuleBase.isUpdateManDirty() && (bl || pSDEDUPRuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDUPRuleBase.getUpdateMan());
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
        return PSDEDUPRuleBase.remove(this, n);
    }

    private static boolean remove(PSDEDUPRuleBase pSDEDUPRuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDUPRuleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDUPRuleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDUPRuleBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEDUPRuleBase.resetPSDEDUPRuleId();
                return true;
            }
            case 4: {
                pSDEDUPRuleBase.resetPSDEDUPRuleName();
                return true;
            }
            case 5: {
                pSDEDUPRuleBase.resetPSDEId();
                return true;
            }
            case 6: {
                pSDEDUPRuleBase.resetPSDEName();
                return true;
            }
            case 7: {
                pSDEDUPRuleBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDEDUPRuleBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    private PSDEDUPRuleBase getProxyEntity() {
        return this.proxyPSDEDUPRuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDUPRuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDUPRuleBase) {
            this.proxyPSDEDUPRuleBase = (PSDEDUPRuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEDUPRULEID, 3);
        fieldIndexMap.put(FIELD_PSDEDUPRULENAME, 4);
        fieldIndexMap.put(FIELD_PSDEID, 5);
        fieldIndexMap.put(FIELD_PSDENAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

