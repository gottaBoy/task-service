/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
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
package net.ibizsys.pscore.srv.devcenter.entity;

import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUserObj;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserGroupBase
extends PSDevUserObj {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserGroupBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_GROUPTAG = "GROUPTAG";
    public static final String FIELD_GROUPTAG2 = "GROUPTAG2";
    public static final String FIELD_PSDEVUSERGROUPID = "PSDEVUSERGROUPID";
    public static final String FIELD_PSDEVUSERGROUPNAME = "PSDEVUSERGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLE = 7;
    private static final int INDEX_GROUPTAG = 8;
    private static final int INDEX_GROUPTAG2 = 9;
    private static final int INDEX_PSDEVUSERGROUPID = 13;
    private static final int INDEX_PSDEVUSERGROUPNAME = 14;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserGroupBase proxyPSDevUserGroupBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean grouptagDirtyFlag = false;
    private boolean grouptag2DirtyFlag = false;
    private boolean psdevusergroupidDirtyFlag = false;
    private boolean psdevusergroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="grouptag")
    private String grouptag;
    @Column(name="grouptag2")
    private String grouptag2;
    @Column(name="psdevusergroupid")
    private String psdevusergroupid;
    @Column(name="psdevusergroupname")
    private String psdevusergroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public PSDevUserGroupBase() {
        try {
            this.set("PSDEVUSEROBJTYPE", "USERGROUP");
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    @Override
    public void setCreateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(timestamp);
            return;
        }
        this.createdate = timestamp;
        this.createdateDirtyFlag = true;
    }

    @Override
    public Timestamp getCreateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateDate();
        }
        return this.createdate;
    }

    @Override
    public boolean isCreateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateDateDirty();
        }
        return this.createdateDirtyFlag;
    }

    @Override
    public void resetCreateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateDate();
            return;
        }
        this.createdateDirtyFlag = false;
        this.createdate = null;
    }

    @Override
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

    @Override
    public String getCreateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCreateMan();
        }
        return this.createman;
    }

    @Override
    public boolean isCreateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCreateManDirty();
        }
        return this.createmanDirtyFlag;
    }

    @Override
    public void resetCreateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCreateMan();
            return;
        }
        this.createmanDirtyFlag = false;
        this.createman = null;
    }

    @Override
    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    @Override
    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    @Override
    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    @Override
    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setGroupTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag = string;
        this.grouptagDirtyFlag = true;
    }

    public String getGroupTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag();
        }
        return this.grouptag;
    }

    public boolean isGroupTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTagDirty();
        }
        return this.grouptagDirtyFlag;
    }

    public void resetGroupTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag();
            return;
        }
        this.grouptagDirtyFlag = false;
        this.grouptag = null;
    }

    public void setGroupTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.grouptag2 = string;
        this.grouptag2DirtyFlag = true;
    }

    public String getGroupTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupTag2();
        }
        return this.grouptag2;
    }

    public boolean isGroupTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupTag2Dirty();
        }
        return this.grouptag2DirtyFlag;
    }

    public void resetGroupTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupTag2();
            return;
        }
        this.grouptag2DirtyFlag = false;
        this.grouptag2 = null;
    }

    public void setPSDevUserGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusergroupid = string;
        this.psdevusergroupidDirtyFlag = true;
        super.setPSDevUserObjectId(string);
    }

    public String getPSDevUserGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserGroupId();
        }
        return this.psdevusergroupid;
    }

    public boolean isPSDevUserGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserGroupIdDirty();
        }
        return this.psdevusergroupidDirtyFlag;
    }

    public void resetPSDevUserGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserGroupId();
            return;
        }
        this.psdevusergroupidDirtyFlag = false;
        this.psdevusergroupid = null;
        super.resetPSDevUserObjectId();
    }

    public void setPSDevUserGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusergroupname = string;
        this.psdevusergroupnameDirtyFlag = true;
        super.setPSDevUserObjName(string);
    }

    public String getPSDevUserGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserGroupName();
        }
        return this.psdevusergroupname;
    }

    public boolean isPSDevUserGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserGroupNameDirty();
        }
        return this.psdevusergroupnameDirtyFlag;
    }

    public void resetPSDevUserGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserGroupName();
            return;
        }
        this.psdevusergroupnameDirtyFlag = false;
        this.psdevusergroupname = null;
    }

    @Override
    public void setUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(timestamp);
            return;
        }
        this.updatedate = timestamp;
        this.updatedateDirtyFlag = true;
    }

    @Override
    public Timestamp getUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateDate();
        }
        return this.updatedate;
    }

    @Override
    public boolean isUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateDateDirty();
        }
        return this.updatedateDirtyFlag;
    }

    @Override
    public void resetUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateDate();
            return;
        }
        this.updatedateDirtyFlag = false;
        this.updatedate = null;
    }

    @Override
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

    @Override
    public String getUpdateMan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUpdateMan();
        }
        return this.updateman;
    }

    @Override
    public boolean isUpdateManDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUpdateManDirty();
        }
        return this.updatemanDirtyFlag;
    }

    @Override
    public void resetUpdateMan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUpdateMan();
            return;
        }
        this.updatemanDirtyFlag = false;
        this.updateman = null;
    }

    @Override
    protected void onReset() {
        PSDevUserGroupBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserGroupBase pSDevUserGroupBase) {
        pSDevUserGroupBase.resetCreateDate();
        pSDevUserGroupBase.resetCreateMan();
        pSDevUserGroupBase.resetEnable();
        pSDevUserGroupBase.resetGroupTag();
        pSDevUserGroupBase.resetGroupTag2();
        pSDevUserGroupBase.resetPSDevUserGroupId();
        pSDevUserGroupBase.resetPSDevUserGroupName();
        pSDevUserGroupBase.resetUpdateDate();
        pSDevUserGroupBase.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isGroupTagDirty()) {
            hashMap.put(FIELD_GROUPTAG, this.getGroupTag());
        }
        if (!bl || this.isGroupTag2Dirty()) {
            hashMap.put(FIELD_GROUPTAG2, this.getGroupTag2());
        }
        if (!bl || this.isPSDevUserGroupIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERGROUPID, this.getPSDevUserGroupId());
        }
        if (!bl || this.isPSDevUserGroupNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERGROUPNAME, this.getPSDevUserGroupName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        super.onFillMap(hashMap, bl);
    }

    @Override
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
        return PSDevUserGroupBase.get(this, n);
    }

    private static Object get(PSDevUserGroupBase pSDevUserGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserGroupBase.getCreateDate();
            }
            case 1: {
                return pSDevUserGroupBase.getCreateMan();
            }
            case 7: {
                return pSDevUserGroupBase.getEnable();
            }
            case 8: {
                return pSDevUserGroupBase.getGroupTag();
            }
            case 9: {
                return pSDevUserGroupBase.getGroupTag2();
            }
            case 13: {
                return pSDevUserGroupBase.getPSDevUserGroupId();
            }
            case 14: {
                return pSDevUserGroupBase.getPSDevUserGroupName();
            }
            case 16: {
                return pSDevUserGroupBase.getUpdateDate();
            }
            case 17: {
                return pSDevUserGroupBase.getUpdateMan();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        PSDevUserGroupBase.set(this, n, object);
    }

    private static void set(PSDevUserGroupBase pSDevUserGroupBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserGroupBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserGroupBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserGroupBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevUserGroupBase.setGroupTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevUserGroupBase.setGroupTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevUserGroupBase.setPSDevUserGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevUserGroupBase.setPSDevUserGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevUserGroupBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDevUserGroupBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSDevUserGroupBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserGroupBase pSDevUserGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserGroupBase.getCreateDate() == null;
            }
            case 1: {
                return pSDevUserGroupBase.getCreateMan() == null;
            }
            case 7: {
                return pSDevUserGroupBase.getEnable() == null;
            }
            case 8: {
                return pSDevUserGroupBase.getGroupTag() == null;
            }
            case 9: {
                return pSDevUserGroupBase.getGroupTag2() == null;
            }
            case 13: {
                return pSDevUserGroupBase.getPSDevUserGroupId() == null;
            }
            case 14: {
                return pSDevUserGroupBase.getPSDevUserGroupName() == null;
            }
            case 16: {
                return pSDevUserGroupBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDevUserGroupBase.getUpdateMan() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
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
        return PSDevUserGroupBase.contains(this, n);
    }

    private static boolean contains(PSDevUserGroupBase pSDevUserGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserGroupBase.isCreateDateDirty();
            }
            case 1: {
                return pSDevUserGroupBase.isCreateManDirty();
            }
            case 7: {
                return pSDevUserGroupBase.isEnableDirty();
            }
            case 8: {
                return pSDevUserGroupBase.isGroupTagDirty();
            }
            case 9: {
                return pSDevUserGroupBase.isGroupTag2Dirty();
            }
            case 13: {
                return pSDevUserGroupBase.isPSDevUserGroupIdDirty();
            }
            case 14: {
                return pSDevUserGroupBase.isPSDevUserGroupNameDirty();
            }
            case 16: {
                return pSDevUserGroupBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDevUserGroupBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserGroupBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserGroupBase pSDevUserGroupBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserGroupBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getEnable()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getGroupTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getGroupTag()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getGroupTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"grouptag2", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getGroupTag2()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getPSDevUserGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusergroupid", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getPSDevUserGroupId()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getPSDevUserGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusergroupname", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getPSDevUserGroupName()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserGroupBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserGroupBase.getJSONValue((Object)pSDevUserGroupBase.getUpdateMan()), (boolean)false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserGroupBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserGroupBase pSDevUserGroupBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserGroupBase.getCreateDate() != null) {
            object = pSDevUserGroupBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserGroupBase.getCreateMan() != null) {
            object = pSDevUserGroupBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserGroupBase.getEnable() != null) {
            object = pSDevUserGroupBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevUserGroupBase.getGroupTag() != null) {
            object = pSDevUserGroupBase.getGroupTag();
            xmlNode.setAttribute(FIELD_GROUPTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserGroupBase.getGroupTag2() != null) {
            object = pSDevUserGroupBase.getGroupTag2();
            xmlNode.setAttribute(FIELD_GROUPTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserGroupBase.getPSDevUserGroupId() != null) {
            object = pSDevUserGroupBase.getPSDevUserGroupId();
            xmlNode.setAttribute(FIELD_PSDEVUSERGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserGroupBase.getPSDevUserGroupName() != null) {
            object = pSDevUserGroupBase.getPSDevUserGroupName();
            xmlNode.setAttribute(FIELD_PSDEVUSERGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserGroupBase.getUpdateDate() != null) {
            object = pSDevUserGroupBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserGroupBase.getUpdateMan() != null) {
            object = pSDevUserGroupBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    @Override
    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserGroupBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserGroupBase pSDevUserGroupBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserGroupBase.isCreateDateDirty() && (bl || pSDevUserGroupBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserGroupBase.getCreateDate());
        }
        if (pSDevUserGroupBase.isCreateManDirty() && (bl || pSDevUserGroupBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserGroupBase.getCreateMan());
        }
        if (pSDevUserGroupBase.isEnableDirty() && (bl || pSDevUserGroupBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSDevUserGroupBase.getEnable());
        }
        if (pSDevUserGroupBase.isGroupTagDirty() && (bl || pSDevUserGroupBase.getGroupTag() != null)) {
            iDataObject.set(FIELD_GROUPTAG, (Object)pSDevUserGroupBase.getGroupTag());
        }
        if (pSDevUserGroupBase.isGroupTag2Dirty() && (bl || pSDevUserGroupBase.getGroupTag2() != null)) {
            iDataObject.set(FIELD_GROUPTAG2, (Object)pSDevUserGroupBase.getGroupTag2());
        }
        if (pSDevUserGroupBase.isPSDevUserGroupIdDirty() && (bl || pSDevUserGroupBase.getPSDevUserGroupId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERGROUPID, (Object)pSDevUserGroupBase.getPSDevUserGroupId());
        }
        if (pSDevUserGroupBase.isPSDevUserGroupNameDirty() && (bl || pSDevUserGroupBase.getPSDevUserGroupName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERGROUPNAME, (Object)pSDevUserGroupBase.getPSDevUserGroupName());
        }
        if (pSDevUserGroupBase.isUpdateDateDirty() && (bl || pSDevUserGroupBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserGroupBase.getUpdateDate());
        }
        if (pSDevUserGroupBase.isUpdateManDirty() && (bl || pSDevUserGroupBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserGroupBase.getUpdateMan());
        }
    }

    @Override
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
        return PSDevUserGroupBase.remove(this, n);
    }

    private static boolean remove(PSDevUserGroupBase pSDevUserGroupBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserGroupBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDevUserGroupBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDevUserGroupBase.resetEnable();
                return true;
            }
            case 8: {
                pSDevUserGroupBase.resetGroupTag();
                return true;
            }
            case 9: {
                pSDevUserGroupBase.resetGroupTag2();
                return true;
            }
            case 13: {
                pSDevUserGroupBase.resetPSDevUserGroupId();
                return true;
            }
            case 14: {
                pSDevUserGroupBase.resetPSDevUserGroupName();
                return true;
            }
            case 16: {
                pSDevUserGroupBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDevUserGroupBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSDevUserGroupBase getProxyEntity() {
        return this.proxyPSDevUserGroupBase;
    }

    @Override
    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserGroupBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserGroupBase) {
            this.proxyPSDevUserGroupBase = (PSDevUserGroupBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserGroupService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLE, 7);
        fieldIndexMap.put(FIELD_GROUPTAG, 8);
        fieldIndexMap.put(FIELD_GROUPTAG2, 9);
        fieldIndexMap.put(FIELD_PSDEVUSERGROUPID, 13);
        fieldIndexMap.put(FIELD_PSDEVUSERGROUPNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
    }
}

