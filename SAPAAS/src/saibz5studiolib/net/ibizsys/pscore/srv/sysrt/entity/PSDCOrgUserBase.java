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

public abstract class PSDCOrgUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCOrgUserBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCORGUSERID = "PSDCORGUSERID";
    public static final String FIELD_PSDCORGUSERNAME = "PSDCORGUSERNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCORGUSERID = 2;
    private static final int INDEX_PSDCORGUSERNAME = 3;
    private static final int INDEX_PSDEVCENTERID = 4;
    private static final int INDEX_PSDEVCENTERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCOrgUserBase proxyPSDCOrgUserBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcorguseridDirtyFlag = false;
    private boolean psdcorgusernameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcorguserid")
    private String psdcorguserid;
    @Column(name="psdcorgusername")
    private String psdcorgusername;
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

    public void setPSDCOrgUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorguserid = string;
        this.psdcorguseridDirtyFlag = true;
    }

    public String getPSDCOrgUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgUserId();
        }
        return this.psdcorguserid;
    }

    public boolean isPSDCOrgUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgUserIdDirty();
        }
        return this.psdcorguseridDirtyFlag;
    }

    public void resetPSDCOrgUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgUserId();
            return;
        }
        this.psdcorguseridDirtyFlag = false;
        this.psdcorguserid = null;
    }

    public void setPSDCOrgUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCOrgUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcorgusername = string;
        this.psdcorgusernameDirtyFlag = true;
    }

    public String getPSDCOrgUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgUserName();
        }
        return this.psdcorgusername;
    }

    public boolean isPSDCOrgUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCOrgUserNameDirty();
        }
        return this.psdcorgusernameDirtyFlag;
    }

    public void resetPSDCOrgUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCOrgUserName();
            return;
        }
        this.psdcorgusernameDirtyFlag = false;
        this.psdcorgusername = null;
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
        PSDCOrgUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCOrgUserBase pSDCOrgUserBase) {
        pSDCOrgUserBase.resetCreateDate();
        pSDCOrgUserBase.resetCreateMan();
        pSDCOrgUserBase.resetPSDCOrgUserId();
        pSDCOrgUserBase.resetPSDCOrgUserName();
        pSDCOrgUserBase.resetPSDevCenterId();
        pSDCOrgUserBase.resetPSDevCenterName();
        pSDCOrgUserBase.resetUpdateDate();
        pSDCOrgUserBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCOrgUserIdDirty()) {
            hashMap.put(FIELD_PSDCORGUSERID, this.getPSDCOrgUserId());
        }
        if (!bl || this.isPSDCOrgUserNameDirty()) {
            hashMap.put(FIELD_PSDCORGUSERNAME, this.getPSDCOrgUserName());
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
        return PSDCOrgUserBase.get(this, n);
    }

    private static Object get(PSDCOrgUserBase pSDCOrgUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgUserBase.getCreateDate();
            }
            case 1: {
                return pSDCOrgUserBase.getCreateMan();
            }
            case 2: {
                return pSDCOrgUserBase.getPSDCOrgUserId();
            }
            case 3: {
                return pSDCOrgUserBase.getPSDCOrgUserName();
            }
            case 4: {
                return pSDCOrgUserBase.getPSDevCenterId();
            }
            case 5: {
                return pSDCOrgUserBase.getPSDevCenterName();
            }
            case 6: {
                return pSDCOrgUserBase.getUpdateDate();
            }
            case 7: {
                return pSDCOrgUserBase.getUpdateMan();
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
        PSDCOrgUserBase.set(this, n, object);
    }

    private static void set(PSDCOrgUserBase pSDCOrgUserBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgUserBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCOrgUserBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCOrgUserBase.setPSDCOrgUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCOrgUserBase.setPSDCOrgUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCOrgUserBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCOrgUserBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCOrgUserBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCOrgUserBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDCOrgUserBase.isNull(this, n);
    }

    private static boolean isNull(PSDCOrgUserBase pSDCOrgUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgUserBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCOrgUserBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCOrgUserBase.getPSDCOrgUserId() == null;
            }
            case 3: {
                return pSDCOrgUserBase.getPSDCOrgUserName() == null;
            }
            case 4: {
                return pSDCOrgUserBase.getPSDevCenterId() == null;
            }
            case 5: {
                return pSDCOrgUserBase.getPSDevCenterName() == null;
            }
            case 6: {
                return pSDCOrgUserBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCOrgUserBase.getUpdateMan() == null;
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
        return PSDCOrgUserBase.contains(this, n);
    }

    private static boolean contains(PSDCOrgUserBase pSDCOrgUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCOrgUserBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCOrgUserBase.isCreateManDirty();
            }
            case 2: {
                return pSDCOrgUserBase.isPSDCOrgUserIdDirty();
            }
            case 3: {
                return pSDCOrgUserBase.isPSDCOrgUserNameDirty();
            }
            case 4: {
                return pSDCOrgUserBase.isPSDevCenterIdDirty();
            }
            case 5: {
                return pSDCOrgUserBase.isPSDevCenterNameDirty();
            }
            case 6: {
                return pSDCOrgUserBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCOrgUserBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCOrgUserBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCOrgUserBase pSDCOrgUserBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCOrgUserBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getPSDCOrgUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorguserid", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getPSDCOrgUserId()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getPSDCOrgUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgusername", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getPSDCOrgUserName()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCOrgUserBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCOrgUserBase.getJSONValue((Object)pSDCOrgUserBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCOrgUserBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCOrgUserBase pSDCOrgUserBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCOrgUserBase.getCreateDate() != null) {
            object = pSDCOrgUserBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgUserBase.getCreateMan() != null) {
            object = pSDCOrgUserBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgUserBase.getPSDCOrgUserId() != null) {
            object = pSDCOrgUserBase.getPSDCOrgUserId();
            xmlNode.setAttribute(FIELD_PSDCORGUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgUserBase.getPSDCOrgUserName() != null) {
            object = pSDCOrgUserBase.getPSDCOrgUserName();
            xmlNode.setAttribute(FIELD_PSDCORGUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgUserBase.getPSDevCenterId() != null) {
            object = pSDCOrgUserBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgUserBase.getPSDevCenterName() != null) {
            object = pSDCOrgUserBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCOrgUserBase.getUpdateDate() != null) {
            object = pSDCOrgUserBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCOrgUserBase.getUpdateMan() != null) {
            object = pSDCOrgUserBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCOrgUserBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCOrgUserBase pSDCOrgUserBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCOrgUserBase.isCreateDateDirty() && (bl || pSDCOrgUserBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCOrgUserBase.getCreateDate());
        }
        if (pSDCOrgUserBase.isCreateManDirty() && (bl || pSDCOrgUserBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCOrgUserBase.getCreateMan());
        }
        if (pSDCOrgUserBase.isPSDCOrgUserIdDirty() && (bl || pSDCOrgUserBase.getPSDCOrgUserId() != null)) {
            iDataObject.set(FIELD_PSDCORGUSERID, (Object)pSDCOrgUserBase.getPSDCOrgUserId());
        }
        if (pSDCOrgUserBase.isPSDCOrgUserNameDirty() && (bl || pSDCOrgUserBase.getPSDCOrgUserName() != null)) {
            iDataObject.set(FIELD_PSDCORGUSERNAME, (Object)pSDCOrgUserBase.getPSDCOrgUserName());
        }
        if (pSDCOrgUserBase.isPSDevCenterIdDirty() && (bl || pSDCOrgUserBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDCOrgUserBase.getPSDevCenterId());
        }
        if (pSDCOrgUserBase.isPSDevCenterNameDirty() && (bl || pSDCOrgUserBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDCOrgUserBase.getPSDevCenterName());
        }
        if (pSDCOrgUserBase.isUpdateDateDirty() && (bl || pSDCOrgUserBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCOrgUserBase.getUpdateDate());
        }
        if (pSDCOrgUserBase.isUpdateManDirty() && (bl || pSDCOrgUserBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCOrgUserBase.getUpdateMan());
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
        return PSDCOrgUserBase.remove(this, n);
    }

    private static boolean remove(PSDCOrgUserBase pSDCOrgUserBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCOrgUserBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCOrgUserBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCOrgUserBase.resetPSDCOrgUserId();
                return true;
            }
            case 3: {
                pSDCOrgUserBase.resetPSDCOrgUserName();
                return true;
            }
            case 4: {
                pSDCOrgUserBase.resetPSDevCenterId();
                return true;
            }
            case 5: {
                pSDCOrgUserBase.resetPSDevCenterName();
                return true;
            }
            case 6: {
                pSDCOrgUserBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCOrgUserBase.resetUpdateMan();
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

    private PSDCOrgUserBase getProxyEntity() {
        return this.proxyPSDCOrgUserBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCOrgUserBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCOrgUserBase) {
            this.proxyPSDCOrgUserBase = (PSDCOrgUserBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysrt.service.PSDCOrgUserService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCORGUSERID, 2);
        fieldIndexMap.put(FIELD_PSDCORGUSERNAME, 3);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 4);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
    }
}

