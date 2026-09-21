/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.paasmgr.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCSyncAgentBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCSyncAgentBase.class);
    public static final String FIELD_AGENTOBJ = "AGENTOBJ";
    public static final String FIELD_AGENTPARAMS = "AGENTPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDCSYNCAGENTID = "PSDCSYNCAGENTID";
    public static final String FIELD_PSDCSYNCAGENTNAME = "PSDCSYNCAGENTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AGENTOBJ = 0;
    private static final int INDEX_AGENTPARAMS = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSDCSYNCAGENTID = 5;
    private static final int INDEX_PSDCSYNCAGENTNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCSyncAgentBase proxyPSDCSyncAgentBase = null;
    private boolean agentobjDirtyFlag = false;
    private boolean agentparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdcsyncagentidDirtyFlag = false;
    private boolean psdcsyncagentnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="agentobj")
    private String agentobj;
    @Column(name="agentparams")
    private String agentparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdcsyncagentid")
    private String psdcsyncagentid;
    @Column(name="psdcsyncagentname")
    private String psdcsyncagentname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

    public void setAgentObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentobj = string;
        this.agentobjDirtyFlag = true;
    }

    public String getAgentObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentObj();
        }
        return this.agentobj;
    }

    public boolean isAgentObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentObjDirty();
        }
        return this.agentobjDirtyFlag;
    }

    public void resetAgentObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentObj();
            return;
        }
        this.agentobjDirtyFlag = false;
        this.agentobj = null;
    }

    public void setAgentParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAgentParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.agentparams = string;
        this.agentparamsDirtyFlag = true;
    }

    public String getAgentParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAgentParams();
        }
        return this.agentparams;
    }

    public boolean isAgentParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAgentParamsDirty();
        }
        return this.agentparamsDirtyFlag;
    }

    public void resetAgentParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAgentParams();
            return;
        }
        this.agentparamsDirtyFlag = false;
        this.agentparams = null;
    }

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

    public void setPSDCSyncAgentId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncAgentId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncagentid = string;
        this.psdcsyncagentidDirtyFlag = true;
    }

    public String getPSDCSyncAgentId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncAgentId();
        }
        return this.psdcsyncagentid;
    }

    public boolean isPSDCSyncAgentIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncAgentIdDirty();
        }
        return this.psdcsyncagentidDirtyFlag;
    }

    public void resetPSDCSyncAgentId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncAgentId();
            return;
        }
        this.psdcsyncagentidDirtyFlag = false;
        this.psdcsyncagentid = null;
    }

    public void setPSDCSyncAgentName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCSyncAgentName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcsyncagentname = string;
        this.psdcsyncagentnameDirtyFlag = true;
    }

    public String getPSDCSyncAgentName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCSyncAgentName();
        }
        return this.psdcsyncagentname;
    }

    public boolean isPSDCSyncAgentNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCSyncAgentNameDirty();
        }
        return this.psdcsyncagentnameDirtyFlag;
    }

    public void resetPSDCSyncAgentName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCSyncAgentName();
            return;
        }
        this.psdcsyncagentnameDirtyFlag = false;
        this.psdcsyncagentname = null;
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

    public void setValidFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValidFlag(n);
            return;
        }
        this.validflag = n;
        this.validflagDirtyFlag = true;
    }

    public Integer getValidFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValidFlag();
        }
        return this.validflag;
    }

    public boolean isValidFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValidFlagDirty();
        }
        return this.validflagDirtyFlag;
    }

    public void resetValidFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValidFlag();
            return;
        }
        this.validflagDirtyFlag = false;
        this.validflag = null;
    }

    protected void onReset() {
        PSDCSyncAgentBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCSyncAgentBase pSDCSyncAgentBase) {
        pSDCSyncAgentBase.resetAgentObj();
        pSDCSyncAgentBase.resetAgentParams();
        pSDCSyncAgentBase.resetCreateDate();
        pSDCSyncAgentBase.resetCreateMan();
        pSDCSyncAgentBase.resetMemo();
        pSDCSyncAgentBase.resetPSDCSyncAgentId();
        pSDCSyncAgentBase.resetPSDCSyncAgentName();
        pSDCSyncAgentBase.resetUpdateDate();
        pSDCSyncAgentBase.resetUpdateMan();
        pSDCSyncAgentBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAgentObjDirty()) {
            hashMap.put(FIELD_AGENTOBJ, this.getAgentObj());
        }
        if (!bl || this.isAgentParamsDirty()) {
            hashMap.put(FIELD_AGENTPARAMS, this.getAgentParams());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDCSyncAgentIdDirty()) {
            hashMap.put(FIELD_PSDCSYNCAGENTID, this.getPSDCSyncAgentId());
        }
        if (!bl || this.isPSDCSyncAgentNameDirty()) {
            hashMap.put(FIELD_PSDCSYNCAGENTNAME, this.getPSDCSyncAgentName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
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
        return PSDCSyncAgentBase.get(this, n);
    }

    private static Object get(PSDCSyncAgentBase pSDCSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncAgentBase.getAgentObj();
            }
            case 1: {
                return pSDCSyncAgentBase.getAgentParams();
            }
            case 2: {
                return pSDCSyncAgentBase.getCreateDate();
            }
            case 3: {
                return pSDCSyncAgentBase.getCreateMan();
            }
            case 4: {
                return pSDCSyncAgentBase.getMemo();
            }
            case 5: {
                return pSDCSyncAgentBase.getPSDCSyncAgentId();
            }
            case 6: {
                return pSDCSyncAgentBase.getPSDCSyncAgentName();
            }
            case 7: {
                return pSDCSyncAgentBase.getUpdateDate();
            }
            case 8: {
                return pSDCSyncAgentBase.getUpdateMan();
            }
            case 9: {
                return pSDCSyncAgentBase.getValidFlag();
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
        PSDCSyncAgentBase.set(this, n, object);
    }

    private static void set(PSDCSyncAgentBase pSDCSyncAgentBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncAgentBase.setAgentObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDCSyncAgentBase.setAgentParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCSyncAgentBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDCSyncAgentBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCSyncAgentBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCSyncAgentBase.setPSDCSyncAgentId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCSyncAgentBase.setPSDCSyncAgentName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDCSyncAgentBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDCSyncAgentBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDCSyncAgentBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCSyncAgentBase.isNull(this, n);
    }

    private static boolean isNull(PSDCSyncAgentBase pSDCSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncAgentBase.getAgentObj() == null;
            }
            case 1: {
                return pSDCSyncAgentBase.getAgentParams() == null;
            }
            case 2: {
                return pSDCSyncAgentBase.getCreateDate() == null;
            }
            case 3: {
                return pSDCSyncAgentBase.getCreateMan() == null;
            }
            case 4: {
                return pSDCSyncAgentBase.getMemo() == null;
            }
            case 5: {
                return pSDCSyncAgentBase.getPSDCSyncAgentId() == null;
            }
            case 6: {
                return pSDCSyncAgentBase.getPSDCSyncAgentName() == null;
            }
            case 7: {
                return pSDCSyncAgentBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDCSyncAgentBase.getUpdateMan() == null;
            }
            case 9: {
                return pSDCSyncAgentBase.getValidFlag() == null;
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
        return PSDCSyncAgentBase.contains(this, n);
    }

    private static boolean contains(PSDCSyncAgentBase pSDCSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCSyncAgentBase.isAgentObjDirty();
            }
            case 1: {
                return pSDCSyncAgentBase.isAgentParamsDirty();
            }
            case 2: {
                return pSDCSyncAgentBase.isCreateDateDirty();
            }
            case 3: {
                return pSDCSyncAgentBase.isCreateManDirty();
            }
            case 4: {
                return pSDCSyncAgentBase.isMemoDirty();
            }
            case 5: {
                return pSDCSyncAgentBase.isPSDCSyncAgentIdDirty();
            }
            case 6: {
                return pSDCSyncAgentBase.isPSDCSyncAgentNameDirty();
            }
            case 7: {
                return pSDCSyncAgentBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDCSyncAgentBase.isUpdateManDirty();
            }
            case 9: {
                return pSDCSyncAgentBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCSyncAgentBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCSyncAgentBase pSDCSyncAgentBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCSyncAgentBase.getAgentObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentobj", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getAgentObj()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getAgentParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"agentparams", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getAgentParams()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getMemo()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getPSDCSyncAgentId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncagentid", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getPSDCSyncAgentId()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getPSDCSyncAgentName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcsyncagentname", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getPSDCSyncAgentName()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCSyncAgentBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCSyncAgentBase.getJSONValue((Object)pSDCSyncAgentBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCSyncAgentBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCSyncAgentBase pSDCSyncAgentBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCSyncAgentBase.getAgentObj() != null) {
            object = pSDCSyncAgentBase.getAgentObj();
            xmlNode.setAttribute(FIELD_AGENTOBJ, (String)(object == null ? "" : object));
        }
        if (bl || pSDCSyncAgentBase.getAgentParams() != null) {
            object = pSDCSyncAgentBase.getAgentParams();
            xmlNode.setAttribute(FIELD_AGENTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getCreateDate() != null) {
            object = pSDCSyncAgentBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncAgentBase.getCreateMan() != null) {
            object = pSDCSyncAgentBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getMemo() != null) {
            object = pSDCSyncAgentBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getPSDCSyncAgentId() != null) {
            object = pSDCSyncAgentBase.getPSDCSyncAgentId();
            xmlNode.setAttribute(FIELD_PSDCSYNCAGENTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getPSDCSyncAgentName() != null) {
            object = pSDCSyncAgentBase.getPSDCSyncAgentName();
            xmlNode.setAttribute(FIELD_PSDCSYNCAGENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getUpdateDate() != null) {
            object = pSDCSyncAgentBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCSyncAgentBase.getUpdateMan() != null) {
            object = pSDCSyncAgentBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCSyncAgentBase.getValidFlag() != null) {
            object = pSDCSyncAgentBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCSyncAgentBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCSyncAgentBase pSDCSyncAgentBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCSyncAgentBase.isAgentObjDirty() && (bl || pSDCSyncAgentBase.getAgentObj() != null)) {
            iDataObject.set(FIELD_AGENTOBJ, (Object)pSDCSyncAgentBase.getAgentObj());
        }
        if (pSDCSyncAgentBase.isAgentParamsDirty() && (bl || pSDCSyncAgentBase.getAgentParams() != null)) {
            iDataObject.set(FIELD_AGENTPARAMS, (Object)pSDCSyncAgentBase.getAgentParams());
        }
        if (pSDCSyncAgentBase.isCreateDateDirty() && (bl || pSDCSyncAgentBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCSyncAgentBase.getCreateDate());
        }
        if (pSDCSyncAgentBase.isCreateManDirty() && (bl || pSDCSyncAgentBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCSyncAgentBase.getCreateMan());
        }
        if (pSDCSyncAgentBase.isMemoDirty() && (bl || pSDCSyncAgentBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDCSyncAgentBase.getMemo());
        }
        if (pSDCSyncAgentBase.isPSDCSyncAgentIdDirty() && (bl || pSDCSyncAgentBase.getPSDCSyncAgentId() != null)) {
            iDataObject.set(FIELD_PSDCSYNCAGENTID, (Object)pSDCSyncAgentBase.getPSDCSyncAgentId());
        }
        if (pSDCSyncAgentBase.isPSDCSyncAgentNameDirty() && (bl || pSDCSyncAgentBase.getPSDCSyncAgentName() != null)) {
            iDataObject.set(FIELD_PSDCSYNCAGENTNAME, (Object)pSDCSyncAgentBase.getPSDCSyncAgentName());
        }
        if (pSDCSyncAgentBase.isUpdateDateDirty() && (bl || pSDCSyncAgentBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCSyncAgentBase.getUpdateDate());
        }
        if (pSDCSyncAgentBase.isUpdateManDirty() && (bl || pSDCSyncAgentBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCSyncAgentBase.getUpdateMan());
        }
        if (pSDCSyncAgentBase.isValidFlagDirty() && (bl || pSDCSyncAgentBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCSyncAgentBase.getValidFlag());
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
        return PSDCSyncAgentBase.remove(this, n);
    }

    private static boolean remove(PSDCSyncAgentBase pSDCSyncAgentBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCSyncAgentBase.resetAgentObj();
                return true;
            }
            case 1: {
                pSDCSyncAgentBase.resetAgentParams();
                return true;
            }
            case 2: {
                pSDCSyncAgentBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDCSyncAgentBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDCSyncAgentBase.resetMemo();
                return true;
            }
            case 5: {
                pSDCSyncAgentBase.resetPSDCSyncAgentId();
                return true;
            }
            case 6: {
                pSDCSyncAgentBase.resetPSDCSyncAgentName();
                return true;
            }
            case 7: {
                pSDCSyncAgentBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDCSyncAgentBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSDCSyncAgentBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDCSyncAgentBase getProxyEntity() {
        return this.proxyPSDCSyncAgentBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCSyncAgentBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCSyncAgentBase) {
            this.proxyPSDCSyncAgentBase = (PSDCSyncAgentBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.paasmgr.service.PSDCSyncAgentService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGENTOBJ, 0);
        fieldIndexMap.put(FIELD_AGENTPARAMS, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSDCSYNCAGENTID, 5);
        fieldIndexMap.put(FIELD_PSDCSYNCAGENTNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

