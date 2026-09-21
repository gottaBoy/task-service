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
package net.ibizsys.pscore.srv.sysrt.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCOrgBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCOrgBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCORGID = "PSDCORGID";
    public static final String FIELD_PSDCORGNAME = "PSDCORGNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCORGID = 2;
    private static final int INDEX_PSDCORGNAME = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCOrgBase proxyPSDCOrgBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcorgidDirtyFlag = false;
    private boolean psdcorgnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcorgid")
    private String psdcorgid;
    @Column(name="psdcorgname")
    private String psdcorgname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;

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

    public void setPSDCOrgId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgid = string;
        this.psdcorgidDirtyFlag = true;
    }

    public String getPSDCOrgId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgId();
        }
        return this.psdcorgid;
    }

    public boolean isPSDCOrgIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgIdDirty();
        }
        return this.psdcorgidDirtyFlag;
    }

    public void resetPSDCOrgId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgId();
            return;
        }
        this.psdcorgidDirtyFlag = false;
        this.psdcorgid = null;
    }

    public void setPSDCOrgName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgname = string;
        this.psdcorgnameDirtyFlag = true;
    }

    public String getPSDCOrgName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgName();
        }
        return this.psdcorgname;
    }

    public boolean isPSDCOrgNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgNameDirty();
        }
        return this.psdcorgnameDirtyFlag;
    }

    public void resetPSDCOrgName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgName();
            return;
        }
        this.psdcorgnameDirtyFlag = false;
        this.psdcorgname = null;
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
        PSDCOrgBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCOrgBase pSDCOrgBase) {
        pSDCOrgBase.resetCreateDate();
        pSDCOrgBase.resetCreateMan();
        pSDCOrgBase.resetPSDCOrgId();
        pSDCOrgBase.resetPSDCOrgName();
        pSDCOrgBase.resetPSDevCenterId();
        pSDCOrgBase.resetPSDevCenterName();
        pSDCOrgBase.resetUpdateDate();
        pSDCOrgBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCOrgIdDirty()) {
            hashMap.put(FIELD_PSDCORGID, this.getPSDCOrgId());
        }
        if (!bl || this.isPSDCOrgNameDirty()) {
            hashMap.put(FIELD_PSDCORGNAME, this.getPSDCOrgName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
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
        return PSDCOrgBase.get(this, n);
    }

    private static Object get(PSDCOrgBase pSDCOrgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgBase.getCreateDate();
            }
            case 1: {
                return pSDCOrgBase.getCreateMan();
            }
            case 2: {
                return pSDCOrgBase.getPSDCOrgId();
            }
            case 3: {
                return pSDCOrgBase.getPSDCOrgName();
            }
            case 4: {
                return pSDCOrgBase.getPSDevCenterId();
            }
            case 5: {
                return pSDCOrgBase.getPSDevCenterName();
            }
            case 6: {
                return pSDCOrgBase.getUpdateDate();
            }
            case 7: {
                return pSDCOrgBase.getUpdateMan();
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
        PSDCOrgBase.set(this, n, object);
    }

    private static void set(PSDCOrgBase pSDCOrgBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCOrgBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCOrgBase.setPSDCOrgId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCOrgBase.setPSDCOrgName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCOrgBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCOrgBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCOrgBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCOrgBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCOrgBase.isNull(this, n);
    }

    private static boolean isNull(PSDCOrgBase pSDCOrgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCOrgBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCOrgBase.getPSDCOrgId() == null;
            }
            case 3: {
                return pSDCOrgBase.getPSDCOrgName() == null;
            }
            case 4: {
                return pSDCOrgBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSDCOrgBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSDCOrgBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCOrgBase.getUpdateMan() == null;
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
        return PSDCOrgBase.contains(this, n);
    }

    private static boolean contains(PSDCOrgBase pSDCOrgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCOrgBase.isCreateManDirty();
            }
            case 2: {
                return pSDCOrgBase.isPSDCOrgIdDirty();
            }
            case 3: {
                return pSDCOrgBase.isPSDCOrgNameDirty();
            }
            case 4: {
                return pSDCOrgBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSDCOrgBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSDCOrgBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCOrgBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCOrgBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCOrgBase pSDCOrgBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCOrgBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getPSDCOrgId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgid", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getPSDCOrgId()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getPSDCOrgName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgname", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getPSDCOrgName()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCOrgBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCOrgBase.getJSONValue((Object)pSDCOrgBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCOrgBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCOrgBase pSDCOrgBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCOrgBase.getCreateDate() != null) {
            object = pSDCOrgBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgBase.getCreateMan() != null) {
            object = pSDCOrgBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgBase.getPSDCOrgId() != null) {
            object = pSDCOrgBase.getPSDCOrgId();
            xmlNode.setAttribute(FIELD_PSDCORGID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgBase.getPSDCOrgName() != null) {
            object = pSDCOrgBase.getPSDCOrgName();
            xmlNode.setAttribute(FIELD_PSDCORGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgBase.getPSDevCenterId() != null) {
            object = pSDCOrgBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgBase.getPSDevCenterName() != null) {
            object = pSDCOrgBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgBase.getUpdateDate() != null) {
            object = pSDCOrgBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgBase.getUpdateMan() != null) {
            object = pSDCOrgBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCOrgBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCOrgBase pSDCOrgBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCOrgBase.isCreateDateDirty() && (bl || pSDCOrgBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCOrgBase.getCreateDate());
        }
        if (pSDCOrgBase.isCreateManDirty() && (bl || pSDCOrgBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCOrgBase.getCreateMan());
        }
        if (pSDCOrgBase.isPSDCOrgIdDirty() && (bl || pSDCOrgBase.getPSDCOrgId() != null)) {
            iDataObject.set(FIELD_PSDCORGID, (Object)pSDCOrgBase.getPSDCOrgId());
        }
        if (pSDCOrgBase.isPSDCOrgNameDirty() && (bl || pSDCOrgBase.getPSDCOrgName() != null)) {
            iDataObject.set(FIELD_PSDCORGNAME, (Object)pSDCOrgBase.getPSDCOrgName());
        }
        if (pSDCOrgBase.isPSDevCenterIdDirty() && (bl || pSDCOrgBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCOrgBase.getPSDevCenterId());
        }
        if (pSDCOrgBase.isPSDevCenterNameDirty() && (bl || pSDCOrgBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCOrgBase.getPSDevCenterName());
        }
        if (pSDCOrgBase.isUpdateDateDirty() && (bl || pSDCOrgBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCOrgBase.getUpdateDate());
        }
        if (pSDCOrgBase.isUpdateManDirty() && (bl || pSDCOrgBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCOrgBase.getUpdateMan());
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
        return PSDCOrgBase.remove(this, n);
    }

    private static boolean remove(PSDCOrgBase pSDCOrgBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCOrgBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCOrgBase.resetPSDCOrgId();
                return true;
            }
            case 3: {
                pSDCOrgBase.resetPSDCOrgName();
                return true;
            }
            case 4: {
                pSDCOrgBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSDCOrgBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSDCOrgBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCOrgBase.resetUpdateMan();
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
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    private PSDCOrgBase getProxyEntity() {
        return this.proxyPSDCOrgBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCOrgBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCOrgBase) {
            this.proxyPSDCOrgBase = (PSDCOrgBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysrt.service.PSDCOrgService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCORGID, 2);
        fieldIndexMap.put(FIELD_PSDCORGNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

