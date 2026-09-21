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

public abstract class PSDCOrgSectorBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCOrgSectorBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCORGSECTORID = "PSDCORGSECTORID";
    public static final String FIELD_PSDCORGSECTORNAME = "PSDCORGSECTORNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCORGSECTORID = 2;
    private static final int INDEX_PSDCORGSECTORNAME = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCOrgSectorBase proxyPSDCOrgSectorBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcorgsectoridDirtyFlag = false;
    private boolean psdcorgsectornameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcorgsectorid")
    private String psdcorgsectorid;
    @Column(name="psdcorgsectorname")
    private String psdcorgsectorname;
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

    public void setPSDCOrgSectorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgSectorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgsectorid = string;
        this.psdcorgsectoridDirtyFlag = true;
    }

    public String getPSDCOrgSectorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgSectorId();
        }
        return this.psdcorgsectorid;
    }

    public boolean isPSDCOrgSectorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgSectorIdDirty();
        }
        return this.psdcorgsectoridDirtyFlag;
    }

    public void resetPSDCOrgSectorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgSectorId();
            return;
        }
        this.psdcorgsectoridDirtyFlag = false;
        this.psdcorgsectorid = null;
    }

    public void setPSDCOrgSectorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgSectorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgsectorname = string;
        this.psdcorgsectornameDirtyFlag = true;
    }

    public String getPSDCOrgSectorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgSectorName();
        }
        return this.psdcorgsectorname;
    }

    public boolean isPSDCOrgSectorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgSectorNameDirty();
        }
        return this.psdcorgsectornameDirtyFlag;
    }

    public void resetPSDCOrgSectorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgSectorName();
            return;
        }
        this.psdcorgsectornameDirtyFlag = false;
        this.psdcorgsectorname = null;
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
        PSDCOrgSectorBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCOrgSectorBase pSDCOrgSectorBase) {
        pSDCOrgSectorBase.resetCreateDate();
        pSDCOrgSectorBase.resetCreateMan();
        pSDCOrgSectorBase.resetPSDCOrgSectorId();
        pSDCOrgSectorBase.resetPSDCOrgSectorName();
        pSDCOrgSectorBase.resetPSDevCenterId();
        pSDCOrgSectorBase.resetPSDevCenterName();
        pSDCOrgSectorBase.resetUpdateDate();
        pSDCOrgSectorBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCOrgSectorIdDirty()) {
            hashMap.put(FIELD_PSDCORGSECTORID, this.getPSDCOrgSectorId());
        }
        if (!bl || this.isPSDCOrgSectorNameDirty()) {
            hashMap.put(FIELD_PSDCORGSECTORNAME, this.getPSDCOrgSectorName());
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
        return PSDCOrgSectorBase.get(this, n);
    }

    private static Object get(PSDCOrgSectorBase pSDCOrgSectorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSectorBase.getCreateDate();
            }
            case 1: {
                return pSDCOrgSectorBase.getCreateMan();
            }
            case 2: {
                return pSDCOrgSectorBase.getPSDCOrgSectorId();
            }
            case 3: {
                return pSDCOrgSectorBase.getPSDCOrgSectorName();
            }
            case 4: {
                return pSDCOrgSectorBase.getPSDevCenterId();
            }
            case 5: {
                return pSDCOrgSectorBase.getPSDevCenterName();
            }
            case 6: {
                return pSDCOrgSectorBase.getUpdateDate();
            }
            case 7: {
                return pSDCOrgSectorBase.getUpdateMan();
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
        PSDCOrgSectorBase.set(this, n, object);
    }

    private static void set(PSDCOrgSectorBase pSDCOrgSectorBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgSectorBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCOrgSectorBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCOrgSectorBase.setPSDCOrgSectorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCOrgSectorBase.setPSDCOrgSectorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCOrgSectorBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCOrgSectorBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCOrgSectorBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCOrgSectorBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCOrgSectorBase.isNull(this, n);
    }

    private static boolean isNull(PSDCOrgSectorBase pSDCOrgSectorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSectorBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCOrgSectorBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCOrgSectorBase.getPSDCOrgSectorId() == null;
            }
            case 3: {
                return pSDCOrgSectorBase.getPSDCOrgSectorName() == null;
            }
            case 4: {
                return pSDCOrgSectorBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSDCOrgSectorBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSDCOrgSectorBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCOrgSectorBase.getUpdateMan() == null;
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
        return PSDCOrgSectorBase.contains(this, n);
    }

    private static boolean contains(PSDCOrgSectorBase pSDCOrgSectorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgSectorBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCOrgSectorBase.isCreateManDirty();
            }
            case 2: {
                return pSDCOrgSectorBase.isPSDCOrgSectorIdDirty();
            }
            case 3: {
                return pSDCOrgSectorBase.isPSDCOrgSectorNameDirty();
            }
            case 4: {
                return pSDCOrgSectorBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSDCOrgSectorBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSDCOrgSectorBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCOrgSectorBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCOrgSectorBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCOrgSectorBase pSDCOrgSectorBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCOrgSectorBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getPSDCOrgSectorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgsectorid", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getPSDCOrgSectorId()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getPSDCOrgSectorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgsectorname", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getPSDCOrgSectorName()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCOrgSectorBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCOrgSectorBase.getJSONValue((Object)pSDCOrgSectorBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCOrgSectorBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCOrgSectorBase pSDCOrgSectorBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCOrgSectorBase.getCreateDate() != null) {
            object = pSDCOrgSectorBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgSectorBase.getCreateMan() != null) {
            object = pSDCOrgSectorBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSectorBase.getPSDCOrgSectorId() != null) {
            object = pSDCOrgSectorBase.getPSDCOrgSectorId();
            xmlNode.setAttribute(FIELD_PSDCORGSECTORID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSectorBase.getPSDCOrgSectorName() != null) {
            object = pSDCOrgSectorBase.getPSDCOrgSectorName();
            xmlNode.setAttribute(FIELD_PSDCORGSECTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSectorBase.getPSDevCenterId() != null) {
            object = pSDCOrgSectorBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSectorBase.getPSDevCenterName() != null) {
            object = pSDCOrgSectorBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgSectorBase.getUpdateDate() != null) {
            object = pSDCOrgSectorBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgSectorBase.getUpdateMan() != null) {
            object = pSDCOrgSectorBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCOrgSectorBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCOrgSectorBase pSDCOrgSectorBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCOrgSectorBase.isCreateDateDirty() && (bl || pSDCOrgSectorBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCOrgSectorBase.getCreateDate());
        }
        if (pSDCOrgSectorBase.isCreateManDirty() && (bl || pSDCOrgSectorBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCOrgSectorBase.getCreateMan());
        }
        if (pSDCOrgSectorBase.isPSDCOrgSectorIdDirty() && (bl || pSDCOrgSectorBase.getPSDCOrgSectorId() != null)) {
            iDataObject.set(FIELD_PSDCORGSECTORID, (Object)pSDCOrgSectorBase.getPSDCOrgSectorId());
        }
        if (pSDCOrgSectorBase.isPSDCOrgSectorNameDirty() && (bl || pSDCOrgSectorBase.getPSDCOrgSectorName() != null)) {
            iDataObject.set(FIELD_PSDCORGSECTORNAME, (Object)pSDCOrgSectorBase.getPSDCOrgSectorName());
        }
        if (pSDCOrgSectorBase.isPSDevCenterIdDirty() && (bl || pSDCOrgSectorBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCOrgSectorBase.getPSDevCenterId());
        }
        if (pSDCOrgSectorBase.isPSDevCenterNameDirty() && (bl || pSDCOrgSectorBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCOrgSectorBase.getPSDevCenterName());
        }
        if (pSDCOrgSectorBase.isUpdateDateDirty() && (bl || pSDCOrgSectorBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCOrgSectorBase.getUpdateDate());
        }
        if (pSDCOrgSectorBase.isUpdateManDirty() && (bl || pSDCOrgSectorBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCOrgSectorBase.getUpdateMan());
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
        return PSDCOrgSectorBase.remove(this, n);
    }

    private static boolean remove(PSDCOrgSectorBase pSDCOrgSectorBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgSectorBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCOrgSectorBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCOrgSectorBase.resetPSDCOrgSectorId();
                return true;
            }
            case 3: {
                pSDCOrgSectorBase.resetPSDCOrgSectorName();
                return true;
            }
            case 4: {
                pSDCOrgSectorBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSDCOrgSectorBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSDCOrgSectorBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCOrgSectorBase.resetUpdateMan();
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

    private PSDCOrgSectorBase getProxyEntity() {
        return this.proxyPSDCOrgSectorBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCOrgSectorBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCOrgSectorBase) {
            this.proxyPSDCOrgSectorBase = (PSDCOrgSectorBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysrt.service.PSDCOrgSectorService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCORGSECTORID, 2);
        fieldIndexMap.put(FIELD_PSDCORGSECTORNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

