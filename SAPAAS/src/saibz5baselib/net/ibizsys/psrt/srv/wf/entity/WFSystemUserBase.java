/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.wf.entity;

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

public abstract class WFSystemUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFSystemUserBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_WFSYSTEMUSERID = "WFSYSTEMUSERID";
    public static final String FIELD_WFSYSTEMUSERNAME = "WFSYSTEMUSERNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_UPDATEDATE = 2;
    private static final int INDEX_UPDATEMAN = 3;
    private static final int INDEX_WFSYSTEMUSERID = 4;
    private static final int INDEX_WFSYSTEMUSERNAME = 5;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFSystemUserBase proxyWFSystemUserBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean wfsystemuseridDirtyFlag = false;
    private boolean wfsystemusernameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="wfsystemuserid")
    private String wfsystemuserid;
    @Column(name="wfsystemusername")
    private String wfsystemusername;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_UPDATEDATE, 2);
        fieldIndexMap.put(FIELD_UPDATEMAN, 3);
        fieldIndexMap.put(FIELD_WFSYSTEMUSERID, 4);
        fieldIndexMap.put(FIELD_WFSYSTEMUSERNAME, 5);
    }

    public void setCreateDate(Timestamp createdate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateDate(createdate);
            return;
        }
        this.createdate = createdate;
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

    public void setCreateMan(String createman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCreateMan(createman);
            return;
        }
        if (createman != null && (createman = StringHelper.trimRight(createman)).length() == 0) {
            createman = null;
        }
        this.createman = createman;
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

    public void setUpdateDate(Timestamp updatedate) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateDate(updatedate);
            return;
        }
        this.updatedate = updatedate;
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

    public void setUpdateMan(String updateman) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUpdateMan(updateman);
            return;
        }
        if (updateman != null && (updateman = StringHelper.trimRight(updateman)).length() == 0) {
            updateman = null;
        }
        this.updateman = updateman;
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

    public void setWFSystemUserId(String wfsystemuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFSystemUserId(wfsystemuserid);
            return;
        }
        if (wfsystemuserid != null && (wfsystemuserid = StringHelper.trimRight(wfsystemuserid)).length() == 0) {
            wfsystemuserid = null;
        }
        this.wfsystemuserid = wfsystemuserid;
        this.wfsystemuseridDirtyFlag = true;
    }

    public String getWFSystemUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFSystemUserId();
        }
        return this.wfsystemuserid;
    }

    public boolean isWFSystemUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFSystemUserIdDirty();
        }
        return this.wfsystemuseridDirtyFlag;
    }

    public void resetWFSystemUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFSystemUserId();
            return;
        }
        this.wfsystemuseridDirtyFlag = false;
        this.wfsystemuserid = null;
    }

    public void setWFSystemUserName(String wfsystemusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFSystemUserName(wfsystemusername);
            return;
        }
        if (wfsystemusername != null && (wfsystemusername = StringHelper.trimRight(wfsystemusername)).length() == 0) {
            wfsystemusername = null;
        }
        this.wfsystemusername = wfsystemusername;
        this.wfsystemusernameDirtyFlag = true;
    }

    public String getWFSystemUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFSystemUserName();
        }
        return this.wfsystemusername;
    }

    public boolean isWFSystemUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFSystemUserNameDirty();
        }
        return this.wfsystemusernameDirtyFlag;
    }

    public void resetWFSystemUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFSystemUserName();
            return;
        }
        this.wfsystemusernameDirtyFlag = false;
        this.wfsystemusername = null;
    }

    @Override
    protected void onReset() {
        WFSystemUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFSystemUserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetWFSystemUserId();
        et.resetWFSystemUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isWFSystemUserIdDirty()) {
            params.put(FIELD_WFSYSTEMUSERID, this.getWFSystemUserId());
        }
        if (!bDirtyOnly || this.isWFSystemUserNameDirty()) {
            params.put(FIELD_WFSYSTEMUSERNAME, this.getWFSystemUserName());
        }
        super.onFillMap(params, bDirtyOnly);
    }

    @Override
    public Object get(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().get(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.get(strParamName);
        }
        return WFSystemUserBase.get(this, index);
    }

    private static Object get(WFSystemUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getUpdateDate();
            }
            case 3: {
                return et.getUpdateMan();
            }
            case 4: {
                return et.getWFSystemUserId();
            }
            case 5: {
                return et.getWFSystemUserName();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public void set(String strParamName, Object objValue) throws Exception {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().set(strParamName, objValue);
            return;
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            super.set(strParamName, objValue);
            return;
        }
        WFSystemUserBase.set(this, index, objValue);
    }

    private static void set(WFSystemUserBase et, int index, Object obj) throws Exception {
        switch (index) {
            case 0: {
                et.setCreateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 1: {
                et.setCreateMan(DataObject.getStringValue(obj));
                return;
            }
            case 2: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 3: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setWFSystemUserId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setWFSystemUserName(DataObject.getStringValue(obj));
                return;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean isNull(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNull(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.isNull(strParamName);
        }
        return WFSystemUserBase.isNull(this, index);
    }

    private static boolean isNull(WFSystemUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getUpdateDate() == null;
            }
            case 3: {
                return et.getUpdateMan() == null;
            }
            case 4: {
                return et.getWFSystemUserId() == null;
            }
            case 5: {
                return et.getWFSystemUserName() == null;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    public boolean contains(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().contains(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.contains(strParamName);
        }
        return WFSystemUserBase.contains(this, index);
    }

    private static boolean contains(WFSystemUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isUpdateDateDirty();
            }
            case 3: {
                return et.isUpdateManDirty();
            }
            case 4: {
                return et.isWFSystemUserIdDirty();
            }
            case 5: {
                return et.isWFSystemUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFSystemUserBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFSystemUserBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFSystemUserBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFSystemUserBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFSystemUserBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFSystemUserBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getWFSystemUserId() != null) {
            JSONObjectHelper.put(json, "wfsystemuserid", WFSystemUserBase.getJSONValue(et.getWFSystemUserId()), false);
        }
        if (bIncEmpty || et.getWFSystemUserName() != null) {
            JSONObjectHelper.put(json, "wfsystemusername", WFSystemUserBase.getJSONValue(et.getWFSystemUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFSystemUserBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFSystemUserBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFSystemUserId() != null) {
            obj = et.getWFSystemUserId();
            node.setAttribute(FIELD_WFSYSTEMUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFSystemUserName() != null) {
            obj = et.getWFSystemUserName();
            node.setAttribute(FIELD_WFSYSTEMUSERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFSystemUserBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFSystemUserBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isWFSystemUserIdDirty() && (bIncEmpty || et.getWFSystemUserId() != null)) {
            dst.set(FIELD_WFSYSTEMUSERID, et.getWFSystemUserId());
        }
        if (et.isWFSystemUserNameDirty() && (bIncEmpty || et.getWFSystemUserName() != null)) {
            dst.set(FIELD_WFSYSTEMUSERNAME, et.getWFSystemUserName());
        }
    }

    @Override
    public boolean remove(String strParamName) throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().remove(strParamName);
        }
        if (StringHelper.isNullOrEmpty(strParamName)) {
            throw new Exception("\u6ca1\u6709\u6307\u5b9a\u5c5e\u6027");
        }
        Integer index = fieldIndexMap.get(strParamName.toUpperCase());
        if (index == null) {
            return super.remove(strParamName);
        }
        return WFSystemUserBase.remove(this, index);
    }

    private static boolean remove(WFSystemUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                et.resetCreateDate();
                return true;
            }
            case 1: {
                et.resetCreateMan();
                return true;
            }
            case 2: {
                et.resetUpdateDate();
                return true;
            }
            case 3: {
                et.resetUpdateMan();
                return true;
            }
            case 4: {
                et.resetWFSystemUserId();
                return true;
            }
            case 5: {
                et.resetWFSystemUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFSystemUserBase getProxyEntity() {
        return this.proxyWFSystemUserBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFSystemUserBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFSystemUserBase) {
            this.proxyWFSystemUserBase = (WFSystemUserBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFSystemUserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

