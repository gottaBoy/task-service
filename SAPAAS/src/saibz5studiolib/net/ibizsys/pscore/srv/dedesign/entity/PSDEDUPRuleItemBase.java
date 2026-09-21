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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDUPRule;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEDUPRuleItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEDUPRuleItemBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEDUPRULEID = "PSDEDUPRULEID";
    public static final String FIELD_PSDEDUPRULEITEMID = "PSDEDUPRULEITEMID";
    public static final String FIELD_PSDEDUPRULEITEMNAME = "PSDEDUPRULEITEMNAME";
    public static final String FIELD_PSDEDUPRULENAME = "PSDEDUPRULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEDUPRULEID = 2;
    private static final int INDEX_PSDEDUPRULEITEMID = 3;
    private static final int INDEX_PSDEDUPRULEITEMNAME = 4;
    private static final int INDEX_PSDEDUPRULENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEDUPRuleItemBase proxyPSDEDUPRuleItemBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdedupruleidDirtyFlag = false;
    private boolean psdedupruleitemidDirtyFlag = false;
    private boolean psdedupruleitemnameDirtyFlag = false;
    private boolean psdeduprulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdedupruleid")
    private String psdedupruleid;
    @Column(name="psdedupruleitemid")
    private String psdedupruleitemid;
    @Column(name="psdedupruleitemname")
    private String psdedupruleitemname;
    @Column(name="psdeduprulename")
    private String psdeduprulename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEDupRuleLock = new Integer(1);
    private PSDEDUPRule psdeduprule = null;

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

    public void setPSDEDUPRuleItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDUPRuleItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedupruleitemid = string;
        this.psdedupruleitemidDirtyFlag = true;
    }

    public String getPSDEDUPRuleItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDUPRuleItemId();
        }
        return this.psdedupruleitemid;
    }

    public boolean isPSDEDUPRuleItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDUPRuleItemIdDirty();
        }
        return this.psdedupruleitemidDirtyFlag;
    }

    public void resetPSDEDUPRuleItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDUPRuleItemId();
            return;
        }
        this.psdedupruleitemidDirtyFlag = false;
        this.psdedupruleitemid = null;
    }

    public void setPSDEDUPRuleItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDUPRuleItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedupruleitemname = string;
        this.psdedupruleitemnameDirtyFlag = true;
    }

    public String getPSDEDUPRuleItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDUPRuleItemName();
        }
        return this.psdedupruleitemname;
    }

    public boolean isPSDEDUPRuleItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDUPRuleItemNameDirty();
        }
        return this.psdedupruleitemnameDirtyFlag;
    }

    public void resetPSDEDUPRuleItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDUPRuleItemName();
            return;
        }
        this.psdedupruleitemnameDirtyFlag = false;
        this.psdedupruleitemname = null;
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
        PSDEDUPRuleItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEDUPRuleItemBase pSDEDUPRuleItemBase) {
        pSDEDUPRuleItemBase.resetCreateDate();
        pSDEDUPRuleItemBase.resetCreateMan();
        pSDEDUPRuleItemBase.resetPSDEDUPRuleId();
        pSDEDUPRuleItemBase.resetPSDEDUPRuleItemId();
        pSDEDUPRuleItemBase.resetPSDEDUPRuleItemName();
        pSDEDUPRuleItemBase.resetPSDEDUPRuleName();
        pSDEDUPRuleItemBase.resetUpdateDate();
        pSDEDUPRuleItemBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDEDUPRuleIdDirty()) {
            hashMap.put(FIELD_PSDEDUPRULEID, this.getPSDEDUPRuleId());
        }
        if (!bl || this.isPSDEDUPRuleItemIdDirty()) {
            hashMap.put(FIELD_PSDEDUPRULEITEMID, this.getPSDEDUPRuleItemId());
        }
        if (!bl || this.isPSDEDUPRuleItemNameDirty()) {
            hashMap.put(FIELD_PSDEDUPRULEITEMNAME, this.getPSDEDUPRuleItemName());
        }
        if (!bl || this.isPSDEDUPRuleNameDirty()) {
            hashMap.put(FIELD_PSDEDUPRULENAME, this.getPSDEDUPRuleName());
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
        return PSDEDUPRuleItemBase.get(this, n);
    }

    private static Object get(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleItemBase.getCreateDate();
            }
            case 1: {
                return pSDEDUPRuleItemBase.getCreateMan();
            }
            case 2: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleId();
            }
            case 3: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleItemId();
            }
            case 4: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleItemName();
            }
            case 5: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleName();
            }
            case 6: {
                return pSDEDUPRuleItemBase.getUpdateDate();
            }
            case 7: {
                return pSDEDUPRuleItemBase.getUpdateMan();
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
        PSDEDUPRuleItemBase.set(this, n, object);
    }

    private static void set(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEDUPRuleItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEDUPRuleItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEDUPRuleItemBase.setPSDEDUPRuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEDUPRuleItemBase.setPSDEDUPRuleItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEDUPRuleItemBase.setPSDEDUPRuleItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEDUPRuleItemBase.setPSDEDUPRuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEDUPRuleItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDEDUPRuleItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEDUPRuleItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleItemBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEDUPRuleItemBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleId() == null;
            }
            case 3: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleItemId() == null;
            }
            case 4: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleItemName() == null;
            }
            case 5: {
                return pSDEDUPRuleItemBase.getPSDEDUPRuleName() == null;
            }
            case 6: {
                return pSDEDUPRuleItemBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDEDUPRuleItemBase.getUpdateMan() == null;
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
        return PSDEDUPRuleItemBase.contains(this, n);
    }

    private static boolean contains(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEDUPRuleItemBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEDUPRuleItemBase.isCreateManDirty();
            }
            case 2: {
                return pSDEDUPRuleItemBase.isPSDEDUPRuleIdDirty();
            }
            case 3: {
                return pSDEDUPRuleItemBase.isPSDEDUPRuleItemIdDirty();
            }
            case 4: {
                return pSDEDUPRuleItemBase.isPSDEDUPRuleItemNameDirty();
            }
            case 5: {
                return pSDEDUPRuleItemBase.isPSDEDUPRuleNameDirty();
            }
            case 6: {
                return pSDEDUPRuleItemBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDEDUPRuleItemBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEDUPRuleItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEDUPRuleItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedupruleid", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getPSDEDUPRuleId()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedupruleitemid", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getPSDEDUPRuleItemId()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedupruleitemname", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getPSDEDUPRuleItemName()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeduprulename", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getPSDEDUPRuleName()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEDUPRuleItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEDUPRuleItemBase.getJSONValue((Object)pSDEDUPRuleItemBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEDUPRuleItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEDUPRuleItemBase.getCreateDate() != null) {
            object = pSDEDUPRuleItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDUPRuleItemBase.getCreateMan() != null) {
            object = pSDEDUPRuleItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleId() != null) {
            object = pSDEDUPRuleItemBase.getPSDEDUPRuleId();
            xmlNode.setAttribute(FIELD_PSDEDUPRULEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemId() != null) {
            object = pSDEDUPRuleItemBase.getPSDEDUPRuleItemId();
            xmlNode.setAttribute(FIELD_PSDEDUPRULEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemName() != null) {
            object = pSDEDUPRuleItemBase.getPSDEDUPRuleItemName();
            xmlNode.setAttribute(FIELD_PSDEDUPRULEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleName() != null) {
            object = pSDEDUPRuleItemBase.getPSDEDUPRuleName();
            xmlNode.setAttribute(FIELD_PSDEDUPRULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEDUPRuleItemBase.getUpdateDate() != null) {
            object = pSDEDUPRuleItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEDUPRuleItemBase.getUpdateMan() != null) {
            object = pSDEDUPRuleItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEDUPRuleItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEDUPRuleItemBase.isCreateDateDirty() && (bl || pSDEDUPRuleItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEDUPRuleItemBase.getCreateDate());
        }
        if (pSDEDUPRuleItemBase.isCreateManDirty() && (bl || pSDEDUPRuleItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEDUPRuleItemBase.getCreateMan());
        }
        if (pSDEDUPRuleItemBase.isPSDEDUPRuleIdDirty() && (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleId() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULEID, (Object)pSDEDUPRuleItemBase.getPSDEDUPRuleId());
        }
        if (pSDEDUPRuleItemBase.isPSDEDUPRuleItemIdDirty() && (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemId() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULEITEMID, (Object)pSDEDUPRuleItemBase.getPSDEDUPRuleItemId());
        }
        if (pSDEDUPRuleItemBase.isPSDEDUPRuleItemNameDirty() && (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleItemName() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULEITEMNAME, (Object)pSDEDUPRuleItemBase.getPSDEDUPRuleItemName());
        }
        if (pSDEDUPRuleItemBase.isPSDEDUPRuleNameDirty() && (bl || pSDEDUPRuleItemBase.getPSDEDUPRuleName() != null)) {
            iDataObject.set(FIELD_PSDEDUPRULENAME, (Object)pSDEDUPRuleItemBase.getPSDEDUPRuleName());
        }
        if (pSDEDUPRuleItemBase.isUpdateDateDirty() && (bl || pSDEDUPRuleItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEDUPRuleItemBase.getUpdateDate());
        }
        if (pSDEDUPRuleItemBase.isUpdateManDirty() && (bl || pSDEDUPRuleItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEDUPRuleItemBase.getUpdateMan());
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
        return PSDEDUPRuleItemBase.remove(this, n);
    }

    private static boolean remove(PSDEDUPRuleItemBase pSDEDUPRuleItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEDUPRuleItemBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEDUPRuleItemBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEDUPRuleItemBase.resetPSDEDUPRuleId();
                return true;
            }
            case 3: {
                pSDEDUPRuleItemBase.resetPSDEDUPRuleItemId();
                return true;
            }
            case 4: {
                pSDEDUPRuleItemBase.resetPSDEDUPRuleItemName();
                return true;
            }
            case 5: {
                pSDEDUPRuleItemBase.resetPSDEDUPRuleName();
                return true;
            }
            case 6: {
                pSDEDUPRuleItemBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDEDUPRuleItemBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDUPRule getPSDEDupRule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDupRule();
        }
        if (this.getPSDEDUPRuleId() == null) {
            return null;
        }
        Integer n = this.objPSDEDupRuleLock;
        synchronized (n) {
            if (this.psdeduprule != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDUPRuleId(), (Object)this.psdeduprule.getPSDEDUPRuleId()) != 0L) {
                this.psdeduprule = null;
            }
            if (this.psdeduprule == null) {
                PSDEDUPRule pSDEDUPRule = new PSDEDUPRule();
                pSDEDUPRule.setPSDEDUPRuleId(this.getPSDEDUPRuleId());
                PSDEDUPRuleService pSDEDUPRuleService = (PSDEDUPRuleService)ServiceGlobal.getService(PSDEDUPRuleService.class, (SessionFactory)this.getSessionFactory());
                pSDEDUPRuleService.autoGet((IEntity)pSDEDUPRule);
                this.psdeduprule = pSDEDUPRule;
            }
            return this.psdeduprule;
        }
    }

    private PSDEDUPRuleItemBase getProxyEntity() {
        return this.proxyPSDEDUPRuleItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEDUPRuleItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEDUPRuleItemBase) {
            this.proxyPSDEDUPRuleItemBase = (PSDEDUPRuleItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEDUPRuleItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEDUPRULEID, 2);
        fieldIndexMap.put(FIELD_PSDEDUPRULEITEMID, 3);
        fieldIndexMap.put(FIELD_PSDEDUPRULEITEMNAME, 4);
        fieldIndexMap.put(FIELD_PSDEDUPRULENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

