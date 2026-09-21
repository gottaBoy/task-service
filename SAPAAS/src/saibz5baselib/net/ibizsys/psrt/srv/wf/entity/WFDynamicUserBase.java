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

public abstract class WFDynamicUserBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(WFDynamicUserBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PARAMS = "PARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEROBJECT = "USEROBJECT";
    public static final String FIELD_USERTYPE = "USERTYPE";
    public static final String FIELD_WFDYNAMICUSERID = "WFDYNAMICUSERID";
    public static final String FIELD_WFDYNAMICUSERNAME = "WFDYNAMICUSERNAME";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PARAMS = 2;
    private static final int INDEX_UPDATEDATE = 3;
    private static final int INDEX_UPDATEMAN = 4;
    private static final int INDEX_USEROBJECT = 5;
    private static final int INDEX_USERTYPE = 6;
    private static final int INDEX_WFDYNAMICUSERID = 7;
    private static final int INDEX_WFDYNAMICUSERNAME = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private WFDynamicUserBase proxyWFDynamicUserBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userobjectDirtyFlag = false;
    private boolean usertypeDirtyFlag = false;
    private boolean wfdynamicuseridDirtyFlag = false;
    private boolean wfdynamicusernameDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="params")
    private String params;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userobject")
    private String userobject;
    @Column(name="usertype")
    private String usertype;
    @Column(name="wfdynamicuserid")
    private String wfdynamicuserid;
    @Column(name="wfdynamicusername")
    private String wfdynamicusername;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PARAMS, 2);
        fieldIndexMap.put(FIELD_UPDATEDATE, 3);
        fieldIndexMap.put(FIELD_UPDATEMAN, 4);
        fieldIndexMap.put(FIELD_USEROBJECT, 5);
        fieldIndexMap.put(FIELD_USERTYPE, 6);
        fieldIndexMap.put(FIELD_WFDYNAMICUSERID, 7);
        fieldIndexMap.put(FIELD_WFDYNAMICUSERNAME, 8);
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

    public void setParams(String params) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParams(params);
            return;
        }
        if (params != null && (params = StringHelper.trimRight(params)).length() == 0) {
            params = null;
        }
        this.params = params;
        this.paramsDirtyFlag = true;
    }

    public String getParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParams();
        }
        return this.params;
    }

    public boolean isParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamsDirty();
        }
        return this.paramsDirtyFlag;
    }

    public void resetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParams();
            return;
        }
        this.paramsDirtyFlag = false;
        this.params = null;
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

    public void setUserObject(String userobject) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserObject(userobject);
            return;
        }
        if (userobject != null && (userobject = StringHelper.trimRight(userobject)).length() == 0) {
            userobject = null;
        }
        this.userobject = userobject;
        this.userobjectDirtyFlag = true;
    }

    public String getUserObject() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserObject();
        }
        return this.userobject;
    }

    public boolean isUserObjectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserObjectDirty();
        }
        return this.userobjectDirtyFlag;
    }

    public void resetUserObject() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserObject();
            return;
        }
        this.userobjectDirtyFlag = false;
        this.userobject = null;
    }

    public void setUserType(String usertype) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserType(usertype);
            return;
        }
        if (usertype != null && (usertype = StringHelper.trimRight(usertype)).length() == 0) {
            usertype = null;
        }
        this.usertype = usertype;
        this.usertypeDirtyFlag = true;
    }

    public String getUserType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserType();
        }
        return this.usertype;
    }

    public boolean isUserTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTypeDirty();
        }
        return this.usertypeDirtyFlag;
    }

    public void resetUserType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserType();
            return;
        }
        this.usertypeDirtyFlag = false;
        this.usertype = null;
    }

    public void setWFDynamicUserId(String wfdynamicuserid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFDynamicUserId(wfdynamicuserid);
            return;
        }
        if (wfdynamicuserid != null && (wfdynamicuserid = StringHelper.trimRight(wfdynamicuserid)).length() == 0) {
            wfdynamicuserid = null;
        }
        this.wfdynamicuserid = wfdynamicuserid;
        this.wfdynamicuseridDirtyFlag = true;
    }

    public String getWFDynamicUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFDynamicUserId();
        }
        return this.wfdynamicuserid;
    }

    public boolean isWFDynamicUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFDynamicUserIdDirty();
        }
        return this.wfdynamicuseridDirtyFlag;
    }

    public void resetWFDynamicUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFDynamicUserId();
            return;
        }
        this.wfdynamicuseridDirtyFlag = false;
        this.wfdynamicuserid = null;
    }

    public void setWFDynamicUserName(String wfdynamicusername) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWFDynamicUserName(wfdynamicusername);
            return;
        }
        if (wfdynamicusername != null && (wfdynamicusername = StringHelper.trimRight(wfdynamicusername)).length() == 0) {
            wfdynamicusername = null;
        }
        this.wfdynamicusername = wfdynamicusername;
        this.wfdynamicusernameDirtyFlag = true;
    }

    public String getWFDynamicUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWFDynamicUserName();
        }
        return this.wfdynamicusername;
    }

    public boolean isWFDynamicUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWFDynamicUserNameDirty();
        }
        return this.wfdynamicusernameDirtyFlag;
    }

    public void resetWFDynamicUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWFDynamicUserName();
            return;
        }
        this.wfdynamicusernameDirtyFlag = false;
        this.wfdynamicusername = null;
    }

    @Override
    protected void onReset() {
        WFDynamicUserBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(WFDynamicUserBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetParams();
        et.resetUpdateDate();
        et.resetUpdateMan();
        et.resetUserObject();
        et.resetUserType();
        et.resetWFDynamicUserId();
        et.resetWFDynamicUserName();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isParamsDirty()) {
            params.put(FIELD_PARAMS, this.getParams());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bDirtyOnly || this.isUserObjectDirty()) {
            params.put(FIELD_USEROBJECT, this.getUserObject());
        }
        if (!bDirtyOnly || this.isUserTypeDirty()) {
            params.put(FIELD_USERTYPE, this.getUserType());
        }
        if (!bDirtyOnly || this.isWFDynamicUserIdDirty()) {
            params.put(FIELD_WFDYNAMICUSERID, this.getWFDynamicUserId());
        }
        if (!bDirtyOnly || this.isWFDynamicUserNameDirty()) {
            params.put(FIELD_WFDYNAMICUSERNAME, this.getWFDynamicUserName());
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
        return WFDynamicUserBase.get(this, index);
    }

    private static Object get(WFDynamicUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getParams();
            }
            case 3: {
                return et.getUpdateDate();
            }
            case 4: {
                return et.getUpdateMan();
            }
            case 5: {
                return et.getUserObject();
            }
            case 6: {
                return et.getUserType();
            }
            case 7: {
                return et.getWFDynamicUserId();
            }
            case 8: {
                return et.getWFDynamicUserName();
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
        WFDynamicUserBase.set(this, index, objValue);
    }

    private static void set(WFDynamicUserBase et, int index, Object obj) throws Exception {
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
                et.setParams(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 4: {
                et.setUpdateMan(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setUserObject(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setUserType(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setWFDynamicUserId(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setWFDynamicUserName(DataObject.getStringValue(obj));
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
        return WFDynamicUserBase.isNull(this, index);
    }

    private static boolean isNull(WFDynamicUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getParams() == null;
            }
            case 3: {
                return et.getUpdateDate() == null;
            }
            case 4: {
                return et.getUpdateMan() == null;
            }
            case 5: {
                return et.getUserObject() == null;
            }
            case 6: {
                return et.getUserType() == null;
            }
            case 7: {
                return et.getWFDynamicUserId() == null;
            }
            case 8: {
                return et.getWFDynamicUserName() == null;
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
        return WFDynamicUserBase.contains(this, index);
    }

    private static boolean contains(WFDynamicUserBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isParamsDirty();
            }
            case 3: {
                return et.isUpdateDateDirty();
            }
            case 4: {
                return et.isUpdateManDirty();
            }
            case 5: {
                return et.isUserObjectDirty();
            }
            case 6: {
                return et.isUserTypeDirty();
            }
            case 7: {
                return et.isWFDynamicUserIdDirty();
            }
            case 8: {
                return et.isWFDynamicUserNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        WFDynamicUserBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(WFDynamicUserBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", WFDynamicUserBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", WFDynamicUserBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getParams() != null) {
            JSONObjectHelper.put(json, "params", WFDynamicUserBase.getJSONValue(et.getParams()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", WFDynamicUserBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", WFDynamicUserBase.getJSONValue(et.getUpdateMan()), false);
        }
        if (bIncEmpty || et.getUserObject() != null) {
            JSONObjectHelper.put(json, "userobject", WFDynamicUserBase.getJSONValue(et.getUserObject()), false);
        }
        if (bIncEmpty || et.getUserType() != null) {
            JSONObjectHelper.put(json, "usertype", WFDynamicUserBase.getJSONValue(et.getUserType()), false);
        }
        if (bIncEmpty || et.getWFDynamicUserId() != null) {
            JSONObjectHelper.put(json, "wfdynamicuserid", WFDynamicUserBase.getJSONValue(et.getWFDynamicUserId()), false);
        }
        if (bIncEmpty || et.getWFDynamicUserName() != null) {
            JSONObjectHelper.put(json, "wfdynamicusername", WFDynamicUserBase.getJSONValue(et.getWFDynamicUserName()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        WFDynamicUserBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(WFDynamicUserBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getParams() != null) {
            obj = et.getParams();
            node.setAttribute(FIELD_PARAMS, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserObject() != null) {
            obj = et.getUserObject();
            node.setAttribute(FIELD_USEROBJECT, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUserType() != null) {
            obj = et.getUserType();
            node.setAttribute(FIELD_USERTYPE, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFDynamicUserId() != null) {
            obj = et.getWFDynamicUserId();
            node.setAttribute(FIELD_WFDYNAMICUSERID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getWFDynamicUserName() != null) {
            obj = et.getWFDynamicUserName();
            node.setAttribute(FIELD_WFDYNAMICUSERNAME, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        WFDynamicUserBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(WFDynamicUserBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isParamsDirty() && (bIncEmpty || et.getParams() != null)) {
            dst.set(FIELD_PARAMS, et.getParams());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
        }
        if (et.isUserObjectDirty() && (bIncEmpty || et.getUserObject() != null)) {
            dst.set(FIELD_USEROBJECT, et.getUserObject());
        }
        if (et.isUserTypeDirty() && (bIncEmpty || et.getUserType() != null)) {
            dst.set(FIELD_USERTYPE, et.getUserType());
        }
        if (et.isWFDynamicUserIdDirty() && (bIncEmpty || et.getWFDynamicUserId() != null)) {
            dst.set(FIELD_WFDYNAMICUSERID, et.getWFDynamicUserId());
        }
        if (et.isWFDynamicUserNameDirty() && (bIncEmpty || et.getWFDynamicUserName() != null)) {
            dst.set(FIELD_WFDYNAMICUSERNAME, et.getWFDynamicUserName());
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
        return WFDynamicUserBase.remove(this, index);
    }

    private static boolean remove(WFDynamicUserBase et, int index) throws Exception {
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
                et.resetParams();
                return true;
            }
            case 3: {
                et.resetUpdateDate();
                return true;
            }
            case 4: {
                et.resetUpdateMan();
                return true;
            }
            case 5: {
                et.resetUserObject();
                return true;
            }
            case 6: {
                et.resetUserType();
                return true;
            }
            case 7: {
                et.resetWFDynamicUserId();
                return true;
            }
            case 8: {
                et.resetWFDynamicUserName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private WFDynamicUserBase getProxyEntity() {
        return this.proxyWFDynamicUserBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyWFDynamicUserBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof WFDynamicUserBase) {
            this.proxyWFDynamicUserBase = (WFDynamicUserBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.wf.service.WFDynamicUserService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

