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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewGrpDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewGrpDetailService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEViewGroupBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEViewGroupBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVIEWGROUPID = "PSDEVIEWGROUPID";
    public static final String FIELD_PSDEVIEWGROUPNAME = "PSDEVIEWGROUPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSDEVIEWGROUPID = 3;
    private static final int INDEX_PSDEVIEWGROUPNAME = 4;
    private static final int INDEX_PSSYSTEMID = 5;
    private static final int INDEX_PSSYSTEMNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEViewGroupBase proxyPSDEViewGroupBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeviewgroupidDirtyFlag = false;
    private boolean psdeviewgroupnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeviewgroupid")
    private String psdeviewgroupid;
    @Column(name="psdeviewgroupname")
    private String psdeviewgroupname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSDEViewGrpDetailsLock = new Integer(1);
    private ArrayList<PSDEViewGrpDetail> psdeviewgrpdetails = null;

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

    public void setPSDEViewGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgroupid = string;
        this.psdeviewgroupidDirtyFlag = true;
    }

    public String getPSDEViewGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroupId();
        }
        return this.psdeviewgroupid;
    }

    public boolean isPSDEViewGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGroupIdDirty();
        }
        return this.psdeviewgroupidDirtyFlag;
    }

    public void resetPSDEViewGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGroupId();
            return;
        }
        this.psdeviewgroupidDirtyFlag = false;
        this.psdeviewgroupid = null;
    }

    public void setPSDEViewGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewgroupname = string;
        this.psdeviewgroupnameDirtyFlag = true;
    }

    public String getPSDEViewGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGroupName();
        }
        return this.psdeviewgroupname;
    }

    public boolean isPSDEViewGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewGroupNameDirty();
        }
        return this.psdeviewgroupnameDirtyFlag;
    }

    public void resetPSDEViewGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewGroupName();
            return;
        }
        this.psdeviewgroupnameDirtyFlag = false;
        this.psdeviewgroupname = null;
    }

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSDEViewGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEViewGroupBase pSDEViewGroupBase) {
        pSDEViewGroupBase.resetCreateDate();
        pSDEViewGroupBase.resetCreateMan();
        pSDEViewGroupBase.resetMemo();
        pSDEViewGroupBase.resetPSDEViewGroupId();
        pSDEViewGroupBase.resetPSDEViewGroupName();
        pSDEViewGroupBase.resetPSSystemId();
        pSDEViewGroupBase.resetPSSystemName();
        pSDEViewGroupBase.resetUpdateDate();
        pSDEViewGroupBase.resetUpdateMan();
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
        if (!bl || this.isPSDEViewGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWGROUPID, this.getPSDEViewGroupId());
        }
        if (!bl || this.isPSDEViewGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWGROUPNAME, this.getPSDEViewGroupName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSDEViewGroupBase.get(this, n);
    }

    private static Object get(PSDEViewGroupBase pSDEViewGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGroupBase.getCreateDate();
            }
            case 1: {
                return pSDEViewGroupBase.getCreateMan();
            }
            case 2: {
                return pSDEViewGroupBase.getMemo();
            }
            case 3: {
                return pSDEViewGroupBase.getPSDEViewGroupId();
            }
            case 4: {
                return pSDEViewGroupBase.getPSDEViewGroupName();
            }
            case 5: {
                return pSDEViewGroupBase.getPSSystemId();
            }
            case 6: {
                return pSDEViewGroupBase.getPSSystemName();
            }
            case 7: {
                return pSDEViewGroupBase.getUpdateDate();
            }
            case 8: {
                return pSDEViewGroupBase.getUpdateMan();
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
        PSDEViewGroupBase.set(this, n, object);
    }

    private static void set(PSDEViewGroupBase pSDEViewGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEViewGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEViewGroupBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEViewGroupBase.setPSDEViewGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEViewGroupBase.setPSDEViewGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEViewGroupBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEViewGroupBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEViewGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDEViewGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEViewGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDEViewGroupBase pSDEViewGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGroupBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEViewGroupBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEViewGroupBase.getMemo() == null;
            }
            case 3: {
                return pSDEViewGroupBase.getPSDEViewGroupId() == null;
            }
            case 4: {
                return pSDEViewGroupBase.getPSDEViewGroupName() == null;
            }
            case 5: {
                return pSDEViewGroupBase.getPSSystemId() == null;
            }
            case 6: {
                return pSDEViewGroupBase.getPSSystemName() == null;
            }
            case 7: {
                return pSDEViewGroupBase.getUpdateDate() == null;
            }
            case 8: {
                return pSDEViewGroupBase.getUpdateMan() == null;
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
        return PSDEViewGroupBase.contains(this, n);
    }

    private static boolean contains(PSDEViewGroupBase pSDEViewGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEViewGroupBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEViewGroupBase.isCreateManDirty();
            }
            case 2: {
                return pSDEViewGroupBase.isMemoDirty();
            }
            case 3: {
                return pSDEViewGroupBase.isPSDEViewGroupIdDirty();
            }
            case 4: {
                return pSDEViewGroupBase.isPSDEViewGroupNameDirty();
            }
            case 5: {
                return pSDEViewGroupBase.isPSSystemIdDirty();
            }
            case 6: {
                return pSDEViewGroupBase.isPSSystemNameDirty();
            }
            case 7: {
                return pSDEViewGroupBase.isUpdateDateDirty();
            }
            case 8: {
                return pSDEViewGroupBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEViewGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEViewGroupBase pSDEViewGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEViewGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getPSDEViewGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgroupid", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getPSDEViewGroupId()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getPSDEViewGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewgroupname", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getPSDEViewGroupName()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEViewGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEViewGroupBase.getJSONValue((Object)pSDEViewGroupBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEViewGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEViewGroupBase pSDEViewGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEViewGroupBase.getCreateDate() != null) {
            object = pSDEViewGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewGroupBase.getCreateMan() != null) {
            object = pSDEViewGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getMemo() != null) {
            object = pSDEViewGroupBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getPSDEViewGroupId() != null) {
            object = pSDEViewGroupBase.getPSDEViewGroupId();
            xmlNode.setAttribute(FIELD_PSDEVIEWGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getPSDEViewGroupName() != null) {
            object = pSDEViewGroupBase.getPSDEViewGroupName();
            xmlNode.setAttribute(FIELD_PSDEVIEWGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getPSSystemId() != null) {
            object = pSDEViewGroupBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getPSSystemName() != null) {
            object = pSDEViewGroupBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEViewGroupBase.getUpdateDate() != null) {
            object = pSDEViewGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEViewGroupBase.getUpdateMan() != null) {
            object = pSDEViewGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEViewGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEViewGroupBase pSDEViewGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEViewGroupBase.isCreateDateDirty() && (bl || pSDEViewGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEViewGroupBase.getCreateDate());
        }
        if (pSDEViewGroupBase.isCreateManDirty() && (bl || pSDEViewGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEViewGroupBase.getCreateMan());
        }
        if (pSDEViewGroupBase.isMemoDirty() && (bl || pSDEViewGroupBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEViewGroupBase.getMemo());
        }
        if (pSDEViewGroupBase.isPSDEViewGroupIdDirty() && (bl || pSDEViewGroupBase.getPSDEViewGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGROUPID, (Object)pSDEViewGroupBase.getPSDEViewGroupId());
        }
        if (pSDEViewGroupBase.isPSDEViewGroupNameDirty() && (bl || pSDEViewGroupBase.getPSDEViewGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWGROUPNAME, (Object)pSDEViewGroupBase.getPSDEViewGroupName());
        }
        if (pSDEViewGroupBase.isPSSystemIdDirty() && (bl || pSDEViewGroupBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEViewGroupBase.getPSSystemId());
        }
        if (pSDEViewGroupBase.isPSSystemNameDirty() && (bl || pSDEViewGroupBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSDEViewGroupBase.getPSSystemName());
        }
        if (pSDEViewGroupBase.isUpdateDateDirty() && (bl || pSDEViewGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEViewGroupBase.getUpdateDate());
        }
        if (pSDEViewGroupBase.isUpdateManDirty() && (bl || pSDEViewGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEViewGroupBase.getUpdateMan());
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
        return PSDEViewGroupBase.remove(this, n);
    }

    private static boolean remove(PSDEViewGroupBase pSDEViewGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEViewGroupBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEViewGroupBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEViewGroupBase.resetMemo();
                return true;
            }
            case 3: {
                pSDEViewGroupBase.resetPSDEViewGroupId();
                return true;
            }
            case 4: {
                pSDEViewGroupBase.resetPSDEViewGroupName();
                return true;
            }
            case 5: {
                pSDEViewGroupBase.resetPSSystemId();
                return true;
            }
            case 6: {
                pSDEViewGroupBase.resetPSSystemName();
                return true;
            }
            case 7: {
                pSDEViewGroupBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSDEViewGroupBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEViewGrpDetail> getPSDEViewGrpDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewGrpDetails();
        }
        if (this.getPSDEViewGroupId() == null) {
            return null;
        }
        PSDEViewGrpDetailService pSDEViewGrpDetailService = (PSDEViewGrpDetailService)ServiceGlobal.getService(PSDEViewGrpDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEViewGrpDetailsLock;
        synchronized (n) {
            if (this.psdeviewgrpdetails == null) {
                this.psdeviewgrpdetails = pSDEViewGrpDetailService.selectByPSDEViewGroup(this);
            }
            return this.psdeviewgrpdetails;
        }
    }

    private PSDEViewGroupBase getProxyEntity() {
        return this.proxyPSDEViewGroupBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEViewGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEViewGroupBase) {
            this.proxyPSDEViewGroupBase = (PSDEViewGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEViewGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSDEVIEWGROUPID, 3);
        fieldIndexMap.put(FIELD_PSDEVIEWGROUPNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
    }
}

