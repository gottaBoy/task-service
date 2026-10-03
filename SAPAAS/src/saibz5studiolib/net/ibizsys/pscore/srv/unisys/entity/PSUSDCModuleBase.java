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
package net.ibizsys.pscore.srv.unisys.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.unisys.entity.PSUSDCModuleInst;
import net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUSDCModuleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUSDCModuleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSUSDCMODULEID = "PSUSDCMODULEID";
    public static final String FIELD_PSUSDCMODULENAME = "PSUSDCMODULENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDEVCENTERID = 2;
    private static final int INDEX_PSDEVCENTERNAME = 3;
    private static final int INDEX_PSUSDCMODULEID = 4;
    private static final int INDEX_PSUSDCMODULENAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUSDCModuleBase proxyPSUSDCModuleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psusdcmoduleidDirtyFlag = false;
    private boolean psusdcmodulenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psusdcmoduleid")
    private String psusdcmoduleid;
    @Column(name="psusdcmodulename")
    private String psusdcmodulename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSUSDCModuleInstsLock = new Integer(1);
    private ArrayList<PSUSDCModuleInst> psusdcmoduleinsts = null;

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

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSUSDCModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmoduleid = string;
        this.psusdcmoduleidDirtyFlag = true;
    }

    public String getPSUSDCModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleId();
        }
        return this.psusdcmoduleid;
    }

    public boolean isPSUSDCModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleIdDirty();
        }
        return this.psusdcmoduleidDirtyFlag;
    }

    public void resetPSUSDCModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleId();
            return;
        }
        this.psusdcmoduleidDirtyFlag = false;
        this.psusdcmoduleid = null;
    }

    public void setPSUSDCModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUSDCModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psusdcmodulename = string;
        this.psusdcmodulenameDirtyFlag = true;
    }

    public String getPSUSDCModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleName();
        }
        return this.psusdcmodulename;
    }

    public boolean isPSUSDCModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUSDCModuleNameDirty();
        }
        return this.psusdcmodulenameDirtyFlag;
    }

    public void resetPSUSDCModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUSDCModuleName();
            return;
        }
        this.psusdcmodulenameDirtyFlag = false;
        this.psusdcmodulename = null;
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
        PSUSDCModuleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUSDCModuleBase pSUSDCModuleBase) {
        pSUSDCModuleBase.resetCreateDate();
        pSUSDCModuleBase.resetCreateMan();
        pSUSDCModuleBase.resetPSDevCenterId();
        pSUSDCModuleBase.resetPSDevCenterName();
        pSUSDCModuleBase.resetPSUSDCModuleId();
        pSUSDCModuleBase.resetPSUSDCModuleName();
        pSUSDCModuleBase.resetUpdateDate();
        pSUSDCModuleBase.resetUpdateMan();
        pSUSDCModuleBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSUSDCModuleIdDirty()) {
            hashMap.put(FIELD_PSUSDCMODULEID, this.getPSUSDCModuleId());
        }
        if (!bl || this.isPSUSDCModuleNameDirty()) {
            hashMap.put(FIELD_PSUSDCMODULENAME, this.getPSUSDCModuleName());
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
        return PSUSDCModuleBase.get(this, n);
    }

    private static Object get(PSUSDCModuleBase pSUSDCModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleBase.getCreateDate();
            }
            case 1: {
                return pSUSDCModuleBase.getCreateMan();
            }
            case 2: {
                return pSUSDCModuleBase.getPSDevCenterId();
            }
            case 3: {
                return pSUSDCModuleBase.getPSDevCenterName();
            }
            case 4: {
                return pSUSDCModuleBase.getPSUSDCModuleId();
            }
            case 5: {
                return pSUSDCModuleBase.getPSUSDCModuleName();
            }
            case 6: {
                return pSUSDCModuleBase.getUpdateDate();
            }
            case 7: {
                return pSUSDCModuleBase.getUpdateMan();
            }
            case 8: {
                return pSUSDCModuleBase.getValidFlag();
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
        PSUSDCModuleBase.set(this, n, object);
    }

    private static void set(PSUSDCModuleBase pSUSDCModuleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUSDCModuleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUSDCModuleBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUSDCModuleBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUSDCModuleBase.setPSUSDCModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUSDCModuleBase.setPSUSDCModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUSDCModuleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSUSDCModuleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUSDCModuleBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSUSDCModuleBase.isNull(this, n);
    }

    private static boolean isNull(PSUSDCModuleBase pSUSDCModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleBase.getCreateDate() == null;
            }
            case 1: {
                return pSUSDCModuleBase.getCreateMan() == null;
            }
            case 2: {
                return pSUSDCModuleBase.getPSDevCenterId() == null;
            }
            case 3: {
                return pSUSDCModuleBase.getPSDevCenterName() == null;
            }
            case 4: {
                return pSUSDCModuleBase.getPSUSDCModuleId() == null;
            }
            case 5: {
                return pSUSDCModuleBase.getPSUSDCModuleName() == null;
            }
            case 6: {
                return pSUSDCModuleBase.getUpdateDate() == null;
            }
            case 7: {
                return pSUSDCModuleBase.getUpdateMan() == null;
            }
            case 8: {
                return pSUSDCModuleBase.getValidFlag() == null;
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
        return PSUSDCModuleBase.contains(this, n);
    }

    private static boolean contains(PSUSDCModuleBase pSUSDCModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUSDCModuleBase.isCreateDateDirty();
            }
            case 1: {
                return pSUSDCModuleBase.isCreateManDirty();
            }
            case 2: {
                return pSUSDCModuleBase.isPSDevCenterIdDirty();
            }
            case 3: {
                return pSUSDCModuleBase.isPSDevCenterNameDirty();
            }
            case 4: {
                return pSUSDCModuleBase.isPSUSDCModuleIdDirty();
            }
            case 5: {
                return pSUSDCModuleBase.isPSUSDCModuleNameDirty();
            }
            case 6: {
                return pSUSDCModuleBase.isUpdateDateDirty();
            }
            case 7: {
                return pSUSDCModuleBase.isUpdateManDirty();
            }
            case 8: {
                return pSUSDCModuleBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUSDCModuleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUSDCModuleBase pSUSDCModuleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUSDCModuleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getPSUSDCModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmoduleid", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getPSUSDCModuleId()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getPSUSDCModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psusdcmodulename", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getPSUSDCModuleName()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSUSDCModuleBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSUSDCModuleBase.getJSONValue((Object)pSUSDCModuleBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUSDCModuleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUSDCModuleBase pSUSDCModuleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUSDCModuleBase.getCreateDate() != null) {
            object = pSUSDCModuleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleBase.getCreateMan() != null) {
            object = pSUSDCModuleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getPSDevCenterId() != null) {
            object = pSUSDCModuleBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getPSDevCenterName() != null) {
            object = pSUSDCModuleBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getPSUSDCModuleId() != null) {
            object = pSUSDCModuleBase.getPSUSDCModuleId();
            xmlNode.setAttribute(FIELD_PSUSDCMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getPSUSDCModuleName() != null) {
            object = pSUSDCModuleBase.getPSUSDCModuleName();
            xmlNode.setAttribute(FIELD_PSUSDCMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getUpdateDate() != null) {
            object = pSUSDCModuleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUSDCModuleBase.getUpdateMan() != null) {
            object = pSUSDCModuleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUSDCModuleBase.getValidFlag() != null) {
            object = pSUSDCModuleBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUSDCModuleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUSDCModuleBase pSUSDCModuleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUSDCModuleBase.isCreateDateDirty() && (bl || pSUSDCModuleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUSDCModuleBase.getCreateDate());
        }
        if (pSUSDCModuleBase.isCreateManDirty() && (bl || pSUSDCModuleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUSDCModuleBase.getCreateMan());
        }
        if (pSUSDCModuleBase.isPSDevCenterIdDirty() && (bl || pSUSDCModuleBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSUSDCModuleBase.getPSDevCenterId());
        }
        if (pSUSDCModuleBase.isPSDevCenterNameDirty() && (bl || pSUSDCModuleBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSUSDCModuleBase.getPSDevCenterName());
        }
        if (pSUSDCModuleBase.isPSUSDCModuleIdDirty() && (bl || pSUSDCModuleBase.getPSUSDCModuleId() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULEID, (Object)pSUSDCModuleBase.getPSUSDCModuleId());
        }
        if (pSUSDCModuleBase.isPSUSDCModuleNameDirty() && (bl || pSUSDCModuleBase.getPSUSDCModuleName() != null)) {
            iDataObject.set(FIELD_PSUSDCMODULENAME, (Object)pSUSDCModuleBase.getPSUSDCModuleName());
        }
        if (pSUSDCModuleBase.isUpdateDateDirty() && (bl || pSUSDCModuleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUSDCModuleBase.getUpdateDate());
        }
        if (pSUSDCModuleBase.isUpdateManDirty() && (bl || pSUSDCModuleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUSDCModuleBase.getUpdateMan());
        }
        if (pSUSDCModuleBase.isValidFlagDirty() && (bl || pSUSDCModuleBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSUSDCModuleBase.getValidFlag());
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
        return PSUSDCModuleBase.remove(this, n);
    }

    private static boolean remove(PSUSDCModuleBase pSUSDCModuleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUSDCModuleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUSDCModuleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUSDCModuleBase.resetPSDevCenterId();
                return true;
            }
            case 3: {
                pSUSDCModuleBase.resetPSDevCenterName();
                return true;
            }
            case 4: {
                pSUSDCModuleBase.resetPSUSDCModuleId();
                return true;
            }
            case 5: {
                pSUSDCModuleBase.resetPSUSDCModuleName();
                return true;
            }
            case 6: {
                pSUSDCModuleBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSUSDCModuleBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSUSDCModuleBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet(pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSUSDCModuleInst> getPSUSDCModuleInsts() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUSDCModuleInsts();
        }
        if (this.getPSUSDCModuleId() == null) {
            return null;
        }
        PSUSDCModuleInstService pSUSDCModuleInstService = (PSUSDCModuleInstService)ServiceGlobal.getService(PSUSDCModuleInstService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSUSDCModuleInstsLock;
        synchronized (n) {
            if (this.psusdcmoduleinsts == null) {
                this.psusdcmoduleinsts = pSUSDCModuleInstService.selectByPSUSDCModule(this);
            }
            return this.psusdcmoduleinsts;
        }
    }

    private PSUSDCModuleBase getProxyEntity() {
        return this.proxyPSUSDCModuleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUSDCModuleBase = null;
        if (iDataObject != null && iDataObject instanceof PSUSDCModuleBase) {
            this.proxyPSUSDCModuleBase = (PSUSDCModuleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.unisys.service.PSUSDCModuleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 2);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 3);
        fieldIndexMap.put(FIELD_PSUSDCMODULEID, 4);
        fieldIndexMap.put(FIELD_PSUSDCMODULENAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

