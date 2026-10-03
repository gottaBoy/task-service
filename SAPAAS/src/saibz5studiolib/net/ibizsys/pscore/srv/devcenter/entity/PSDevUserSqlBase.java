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
package net.ibizsys.pscore.srv.devcenter.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevUser;
import net.ibizsys.pscore.srv.devcenter.service.PSDevUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevUserSqlBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevUserSqlBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FILETYPE = "FILETYPE";
    public static final String FIELD_PSDEVUSERID = "PSDEVUSERID";
    public static final String FIELD_PSDEVUSERNAME = "PSDEVUSERNAME";
    public static final String FIELD_PSDEVUSERSQLID = "PSDEVUSERSQLID";
    public static final String FIELD_PSDEVUSERSQLNAME = "PSDEVUSERSQLNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_FILETYPE = 3;
    private static final int INDEX_PSDEVUSERID = 4;
    private static final int INDEX_PSDEVUSERNAME = 5;
    private static final int INDEX_PSDEVUSERSQLID = 6;
    private static final int INDEX_PSDEVUSERSQLNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevUserSqlBase proxyPSDevUserSqlBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean filetypeDirtyFlag = false;
    private boolean psdevuseridDirtyFlag = false;
    private boolean psdevusernameDirtyFlag = false;
    private boolean psdevusersqlidDirtyFlag = false;
    private boolean psdevusersqlnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="filetype")
    private String filetype;
    @Column(name="psdevuserid")
    private String psdevuserid;
    @Column(name="psdevusername")
    private String psdevusername;
    @Column(name="psdevusersqlid")
    private String psdevusersqlid;
    @Column(name="psdevusersqlname")
    private String psdevusersqlname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDevUserLock = new Integer(1);
    private PSDevUser psdevuser = null;

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setFileType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFileType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.filetype = string;
        this.filetypeDirtyFlag = true;
    }

    public String getFileType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFileType();
        }
        return this.filetype;
    }

    public boolean isFileTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFileTypeDirty();
        }
        return this.filetypeDirtyFlag;
    }

    public void resetFileType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFileType();
            return;
        }
        this.filetypeDirtyFlag = false;
        this.filetype = null;
    }

    public void setPSDevUserId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevuserid = string;
        this.psdevuseridDirtyFlag = true;
    }

    public String getPSDevUserId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserId();
        }
        return this.psdevuserid;
    }

    public boolean isPSDevUserIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserIdDirty();
        }
        return this.psdevuseridDirtyFlag;
    }

    public void resetPSDevUserId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserId();
            return;
        }
        this.psdevuseridDirtyFlag = false;
        this.psdevuserid = null;
    }

    public void setPSDevUserName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusername = string;
        this.psdevusernameDirtyFlag = true;
    }

    public String getPSDevUserName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserName();
        }
        return this.psdevusername;
    }

    public boolean isPSDevUserNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserNameDirty();
        }
        return this.psdevusernameDirtyFlag;
    }

    public void resetPSDevUserName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserName();
            return;
        }
        this.psdevusernameDirtyFlag = false;
        this.psdevusername = null;
    }

    public void setPSDevUserSqlId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserSqlId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusersqlid = string;
        this.psdevusersqlidDirtyFlag = true;
    }

    public String getPSDevUserSqlId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserSqlId();
        }
        return this.psdevusersqlid;
    }

    public boolean isPSDevUserSqlIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserSqlIdDirty();
        }
        return this.psdevusersqlidDirtyFlag;
    }

    public void resetPSDevUserSqlId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserSqlId();
            return;
        }
        this.psdevusersqlidDirtyFlag = false;
        this.psdevusersqlid = null;
    }

    public void setPSDevUserSqlName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevUserSqlName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevusersqlname = string;
        this.psdevusersqlnameDirtyFlag = true;
    }

    public String getPSDevUserSqlName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUserSqlName();
        }
        return this.psdevusersqlname;
    }

    public boolean isPSDevUserSqlNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevUserSqlNameDirty();
        }
        return this.psdevusersqlnameDirtyFlag;
    }

    public void resetPSDevUserSqlName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevUserSqlName();
            return;
        }
        this.psdevusersqlnameDirtyFlag = false;
        this.psdevusersqlname = null;
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
        PSDevUserSqlBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevUserSqlBase pSDevUserSqlBase) {
        pSDevUserSqlBase.resetContent();
        pSDevUserSqlBase.resetCreateDate();
        pSDevUserSqlBase.resetCreateMan();
        pSDevUserSqlBase.resetFileType();
        pSDevUserSqlBase.resetPSDevUserId();
        pSDevUserSqlBase.resetPSDevUserName();
        pSDevUserSqlBase.resetPSDevUserSqlId();
        pSDevUserSqlBase.resetPSDevUserSqlName();
        pSDevUserSqlBase.resetUpdateDate();
        pSDevUserSqlBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFileTypeDirty()) {
            hashMap.put(FIELD_FILETYPE, this.getFileType());
        }
        if (!bl || this.isPSDevUserIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERID, this.getPSDevUserId());
        }
        if (!bl || this.isPSDevUserNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERNAME, this.getPSDevUserName());
        }
        if (!bl || this.isPSDevUserSqlIdDirty()) {
            hashMap.put(FIELD_PSDEVUSERSQLID, this.getPSDevUserSqlId());
        }
        if (!bl || this.isPSDevUserSqlNameDirty()) {
            hashMap.put(FIELD_PSDEVUSERSQLNAME, this.getPSDevUserSqlName());
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
        return PSDevUserSqlBase.get(this, n);
    }

    private static Object get(PSDevUserSqlBase pSDevUserSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserSqlBase.getContent();
            }
            case 1: {
                return pSDevUserSqlBase.getCreateDate();
            }
            case 2: {
                return pSDevUserSqlBase.getCreateMan();
            }
            case 3: {
                return pSDevUserSqlBase.getFileType();
            }
            case 4: {
                return pSDevUserSqlBase.getPSDevUserId();
            }
            case 5: {
                return pSDevUserSqlBase.getPSDevUserName();
            }
            case 6: {
                return pSDevUserSqlBase.getPSDevUserSqlId();
            }
            case 7: {
                return pSDevUserSqlBase.getPSDevUserSqlName();
            }
            case 8: {
                return pSDevUserSqlBase.getUpdateDate();
            }
            case 9: {
                return pSDevUserSqlBase.getUpdateMan();
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
        PSDevUserSqlBase.set(this, n, object);
    }

    private static void set(PSDevUserSqlBase pSDevUserSqlBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserSqlBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevUserSqlBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDevUserSqlBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevUserSqlBase.setFileType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevUserSqlBase.setPSDevUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevUserSqlBase.setPSDevUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevUserSqlBase.setPSDevUserSqlId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevUserSqlBase.setPSDevUserSqlName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDevUserSqlBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 9: {
                pSDevUserSqlBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDevUserSqlBase.isNull(this, n);
    }

    private static boolean isNull(PSDevUserSqlBase pSDevUserSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserSqlBase.getContent() == null;
            }
            case 1: {
                return pSDevUserSqlBase.getCreateDate() == null;
            }
            case 2: {
                return pSDevUserSqlBase.getCreateMan() == null;
            }
            case 3: {
                return pSDevUserSqlBase.getFileType() == null;
            }
            case 4: {
                return pSDevUserSqlBase.getPSDevUserId() == null;
            }
            case 5: {
                return pSDevUserSqlBase.getPSDevUserName() == null;
            }
            case 6: {
                return pSDevUserSqlBase.getPSDevUserSqlId() == null;
            }
            case 7: {
                return pSDevUserSqlBase.getPSDevUserSqlName() == null;
            }
            case 8: {
                return pSDevUserSqlBase.getUpdateDate() == null;
            }
            case 9: {
                return pSDevUserSqlBase.getUpdateMan() == null;
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
        return PSDevUserSqlBase.contains(this, n);
    }

    private static boolean contains(PSDevUserSqlBase pSDevUserSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevUserSqlBase.isContentDirty();
            }
            case 1: {
                return pSDevUserSqlBase.isCreateDateDirty();
            }
            case 2: {
                return pSDevUserSqlBase.isCreateManDirty();
            }
            case 3: {
                return pSDevUserSqlBase.isFileTypeDirty();
            }
            case 4: {
                return pSDevUserSqlBase.isPSDevUserIdDirty();
            }
            case 5: {
                return pSDevUserSqlBase.isPSDevUserNameDirty();
            }
            case 6: {
                return pSDevUserSqlBase.isPSDevUserSqlIdDirty();
            }
            case 7: {
                return pSDevUserSqlBase.isPSDevUserSqlNameDirty();
            }
            case 8: {
                return pSDevUserSqlBase.isUpdateDateDirty();
            }
            case 9: {
                return pSDevUserSqlBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevUserSqlBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevUserSqlBase pSDevUserSqlBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevUserSqlBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getContent()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getFileType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"filetype", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getFileType()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevuserid", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getPSDevUserId()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusername", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getPSDevUserName()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserSqlId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusersqlid", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getPSDevUserSqlId()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserSqlName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevusersqlname", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getPSDevUserSqlName()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevUserSqlBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevUserSqlBase.getJSONValue((Object)pSDevUserSqlBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevUserSqlBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevUserSqlBase pSDevUserSqlBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevUserSqlBase.getContent() != null) {
            object = pSDevUserSqlBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getCreateDate() != null) {
            object = pSDevUserSqlBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserSqlBase.getCreateMan() != null) {
            object = pSDevUserSqlBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getFileType() != null) {
            object = pSDevUserSqlBase.getFileType();
            xmlNode.setAttribute(FIELD_FILETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserId() != null) {
            object = pSDevUserSqlBase.getPSDevUserId();
            xmlNode.setAttribute(FIELD_PSDEVUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserName() != null) {
            object = pSDevUserSqlBase.getPSDevUserName();
            xmlNode.setAttribute(FIELD_PSDEVUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserSqlId() != null) {
            object = pSDevUserSqlBase.getPSDevUserSqlId();
            xmlNode.setAttribute(FIELD_PSDEVUSERSQLID, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getPSDevUserSqlName() != null) {
            object = pSDevUserSqlBase.getPSDevUserSqlName();
            xmlNode.setAttribute(FIELD_PSDEVUSERSQLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevUserSqlBase.getUpdateDate() != null) {
            object = pSDevUserSqlBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevUserSqlBase.getUpdateMan() != null) {
            object = pSDevUserSqlBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevUserSqlBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevUserSqlBase pSDevUserSqlBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevUserSqlBase.isContentDirty() && (bl || pSDevUserSqlBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDevUserSqlBase.getContent());
        }
        if (pSDevUserSqlBase.isCreateDateDirty() && (bl || pSDevUserSqlBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevUserSqlBase.getCreateDate());
        }
        if (pSDevUserSqlBase.isCreateManDirty() && (bl || pSDevUserSqlBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevUserSqlBase.getCreateMan());
        }
        if (pSDevUserSqlBase.isFileTypeDirty() && (bl || pSDevUserSqlBase.getFileType() != null)) {
            iDataObject.set(FIELD_FILETYPE, (Object)pSDevUserSqlBase.getFileType());
        }
        if (pSDevUserSqlBase.isPSDevUserIdDirty() && (bl || pSDevUserSqlBase.getPSDevUserId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERID, (Object)pSDevUserSqlBase.getPSDevUserId());
        }
        if (pSDevUserSqlBase.isPSDevUserNameDirty() && (bl || pSDevUserSqlBase.getPSDevUserName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERNAME, (Object)pSDevUserSqlBase.getPSDevUserName());
        }
        if (pSDevUserSqlBase.isPSDevUserSqlIdDirty() && (bl || pSDevUserSqlBase.getPSDevUserSqlId() != null)) {
            iDataObject.set(FIELD_PSDEVUSERSQLID, (Object)pSDevUserSqlBase.getPSDevUserSqlId());
        }
        if (pSDevUserSqlBase.isPSDevUserSqlNameDirty() && (bl || pSDevUserSqlBase.getPSDevUserSqlName() != null)) {
            iDataObject.set(FIELD_PSDEVUSERSQLNAME, (Object)pSDevUserSqlBase.getPSDevUserSqlName());
        }
        if (pSDevUserSqlBase.isUpdateDateDirty() && (bl || pSDevUserSqlBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevUserSqlBase.getUpdateDate());
        }
        if (pSDevUserSqlBase.isUpdateManDirty() && (bl || pSDevUserSqlBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevUserSqlBase.getUpdateMan());
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
        return PSDevUserSqlBase.remove(this, n);
    }

    private static boolean remove(PSDevUserSqlBase pSDevUserSqlBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevUserSqlBase.resetContent();
                return true;
            }
            case 1: {
                pSDevUserSqlBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDevUserSqlBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDevUserSqlBase.resetFileType();
                return true;
            }
            case 4: {
                pSDevUserSqlBase.resetPSDevUserId();
                return true;
            }
            case 5: {
                pSDevUserSqlBase.resetPSDevUserName();
                return true;
            }
            case 6: {
                pSDevUserSqlBase.resetPSDevUserSqlId();
                return true;
            }
            case 7: {
                pSDevUserSqlBase.resetPSDevUserSqlName();
                return true;
            }
            case 8: {
                pSDevUserSqlBase.resetUpdateDate();
                return true;
            }
            case 9: {
                pSDevUserSqlBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevUser getPSDevUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevUser();
        }
        if (this.getPSDevUserId() == null) {
            return null;
        }
        Integer n = this.objPSDevUserLock;
        synchronized (n) {
            if (this.psdevuser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevUserId(), (Object)this.psdevuser.getPSDevUserId()) != 0L) {
                this.psdevuser = null;
            }
            if (this.psdevuser == null) {
                PSDevUser pSDevUser = new PSDevUser();
                pSDevUser.setPSDevUserId(this.getPSDevUserId());
                PSDevUserService pSDevUserService = (PSDevUserService)ServiceGlobal.getService(PSDevUserService.class, (SessionFactory)this.getSessionFactory());
                pSDevUserService.autoGet(pSDevUser);
                this.psdevuser = pSDevUser;
            }
            return this.psdevuser;
        }
    }

    private PSDevUserSqlBase getProxyEntity() {
        return this.proxyPSDevUserSqlBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevUserSqlBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevUserSqlBase) {
            this.proxyPSDevUserSqlBase = (PSDevUserSqlBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDevUserSqlService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_FILETYPE, 3);
        fieldIndexMap.put(FIELD_PSDEVUSERID, 4);
        fieldIndexMap.put(FIELD_PSDEVUSERNAME, 5);
        fieldIndexMap.put(FIELD_PSDEVUSERSQLID, 6);
        fieldIndexMap.put(FIELD_PSDEVUSERSQLNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
    }
}

