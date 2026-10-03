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
import net.ibizsys.pscore.srv.sysrt.entity.PSDCOrgUser;
import net.ibizsys.pscore.srv.sysrt.service.PSDCOrgUserService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDCMsgAccountBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDCMsgAccountBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSDCMSGACCOUNTID = "PSDCMSGACCOUNTID";
    public static final String FIELD_PSDCMSGACCOUNTNAME = "PSDCMSGACCOUNTNAME";
    public static final String FIELD_PSDCORGUSERID = "PSDCORGUSERID";
    public static final String FIELD_PSDCORGUSERNAME = "PSDCORGUSERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSDCMSGACCOUNTID = 2;
    private static final int INDEX_PSDCMSGACCOUNTNAME = 3;
    private static final int INDEX_PSDCORGUSERID = 4;
    private static final int INDEX_PSDCORGUSERNAME = 5;
    private static final int INDEX_UPDATEDATE = 6;
    private static final int INDEX_UPDATEMAN = 7;
    private static final int INDEX_VALIDFLAG = 8;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDCMsgAccountBase proxyPSDCMsgAccountBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psdcmsgaccountidDirtyFlag = false;
    private boolean psdcmsgaccountnameDirtyFlag = false;
    private boolean psdcorguseridDirtyFlag = false;
    private boolean psdcorgusernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psdcmsgaccountid")
    private String psdcmsgaccountid;
    @Column(name="psdcmsgaccountname")
    private String psdcmsgaccountname;
    @Column(name="psdcorguserid")
    private String psdcorguserid;
    @Column(name="psdcorgusername")
    private String psdcorgusername;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSDCOrgUserLock = new Integer(1);
    private PSDCOrgUser psdcorguser = null;

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

    public void setPSDCMsgAccountId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMsgAccountId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsgaccountid = string;
        this.psdcmsgaccountidDirtyFlag = true;
    }

    public String getPSDCMsgAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMsgAccountId();
        }
        return this.psdcmsgaccountid;
    }

    public boolean isPSDCMsgAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMsgAccountIdDirty();
        }
        return this.psdcmsgaccountidDirtyFlag;
    }

    public void resetPSDCMsgAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMsgAccountId();
            return;
        }
        this.psdcmsgaccountidDirtyFlag = false;
        this.psdcmsgaccountid = null;
    }

    public void setPSDCMsgAccountName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDCMsgAccountName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdcmsgaccountname = string;
        this.psdcmsgaccountnameDirtyFlag = true;
    }

    public String getPSDCMsgAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCMsgAccountName();
        }
        return this.psdcmsgaccountname;
    }

    public boolean isPSDCMsgAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDCMsgAccountNameDirty();
        }
        return this.psdcmsgaccountnameDirtyFlag;
    }

    public void resetPSDCMsgAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDCMsgAccountName();
            return;
        }
        this.psdcmsgaccountnameDirtyFlag = false;
        this.psdcmsgaccountname = null;
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
        PSDCMsgAccountBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDCMsgAccountBase pSDCMsgAccountBase) {
        pSDCMsgAccountBase.resetCreateDate();
        pSDCMsgAccountBase.resetCreateMan();
        pSDCMsgAccountBase.resetPSDCMsgAccountId();
        pSDCMsgAccountBase.resetPSDCMsgAccountName();
        pSDCMsgAccountBase.resetPSDCOrgUserId();
        pSDCMsgAccountBase.resetPSDCOrgUserName();
        pSDCMsgAccountBase.resetUpdateDate();
        pSDCMsgAccountBase.resetUpdateMan();
        pSDCMsgAccountBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSDCMsgAccountIdDirty()) {
            hashMap.put(FIELD_PSDCMSGACCOUNTID, this.getPSDCMsgAccountId());
        }
        if (!bl || this.isPSDCMsgAccountNameDirty()) {
            hashMap.put(FIELD_PSDCMSGACCOUNTNAME, this.getPSDCMsgAccountName());
        }
        if (!bl || this.isPSDCOrgUserIdDirty()) {
            hashMap.put(FIELD_PSDCORGUSERID, this.getPSDCOrgUserId());
        }
        if (!bl || this.isPSDCOrgUserNameDirty()) {
            hashMap.put(FIELD_PSDCORGUSERNAME, this.getPSDCOrgUserName());
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
        return PSDCMsgAccountBase.get(this, n);
    }

    private static Object get(PSDCMsgAccountBase pSDCMsgAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMsgAccountBase.getCreateDate();
            }
            case 1: {
                return pSDCMsgAccountBase.getCreateMan();
            }
            case 2: {
                return pSDCMsgAccountBase.getPSDCMsgAccountId();
            }
            case 3: {
                return pSDCMsgAccountBase.getPSDCMsgAccountName();
            }
            case 4: {
                return pSDCMsgAccountBase.getPSDCOrgUserId();
            }
            case 5: {
                return pSDCMsgAccountBase.getPSDCOrgUserName();
            }
            case 6: {
                return pSDCMsgAccountBase.getUpdateDate();
            }
            case 7: {
                return pSDCMsgAccountBase.getUpdateMan();
            }
            case 8: {
                return pSDCMsgAccountBase.getValidFlag();
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
        PSDCMsgAccountBase.set(this, n, object);
    }

    private static void set(PSDCMsgAccountBase pSDCMsgAccountBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDCMsgAccountBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDCMsgAccountBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDCMsgAccountBase.setPSDCMsgAccountId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDCMsgAccountBase.setPSDCMsgAccountName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDCMsgAccountBase.setPSDCOrgUserId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDCMsgAccountBase.setPSDCOrgUserName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDCMsgAccountBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSDCMsgAccountBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDCMsgAccountBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDCMsgAccountBase.isNull(this, n);
    }

    private static boolean isNull(PSDCMsgAccountBase pSDCMsgAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMsgAccountBase.getCreateDate() == null;
            }
            case 1: {
                return pSDCMsgAccountBase.getCreateMan() == null;
            }
            case 2: {
                return pSDCMsgAccountBase.getPSDCMsgAccountId() == null;
            }
            case 3: {
                return pSDCMsgAccountBase.getPSDCMsgAccountName() == null;
            }
            case 4: {
                return pSDCMsgAccountBase.getPSDCOrgUserId() == null;
            }
            case 5: {
                return pSDCMsgAccountBase.getPSDCOrgUserName() == null;
            }
            case 6: {
                return pSDCMsgAccountBase.getUpdateDate() == null;
            }
            case 7: {
                return pSDCMsgAccountBase.getUpdateMan() == null;
            }
            case 8: {
                return pSDCMsgAccountBase.getValidFlag() == null;
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
        return PSDCMsgAccountBase.contains(this, n);
    }

    private static boolean contains(PSDCMsgAccountBase pSDCMsgAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDCMsgAccountBase.isCreateDateDirty();
            }
            case 1: {
                return pSDCMsgAccountBase.isCreateManDirty();
            }
            case 2: {
                return pSDCMsgAccountBase.isPSDCMsgAccountIdDirty();
            }
            case 3: {
                return pSDCMsgAccountBase.isPSDCMsgAccountNameDirty();
            }
            case 4: {
                return pSDCMsgAccountBase.isPSDCOrgUserIdDirty();
            }
            case 5: {
                return pSDCMsgAccountBase.isPSDCOrgUserNameDirty();
            }
            case 6: {
                return pSDCMsgAccountBase.isUpdateDateDirty();
            }
            case 7: {
                return pSDCMsgAccountBase.isUpdateManDirty();
            }
            case 8: {
                return pSDCMsgAccountBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDCMsgAccountBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDCMsgAccountBase pSDCMsgAccountBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDCMsgAccountBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getPSDCMsgAccountId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsgaccountid", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getPSDCMsgAccountId()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getPSDCMsgAccountName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcmsgaccountname", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getPSDCMsgAccountName()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getPSDCOrgUserId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorguserid", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getPSDCOrgUserId()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getPSDCOrgUserName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdcorgusername", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getPSDCOrgUserName()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDCMsgAccountBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDCMsgAccountBase.getJSONValue((Object)pSDCMsgAccountBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDCMsgAccountBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDCMsgAccountBase pSDCMsgAccountBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDCMsgAccountBase.getCreateDate() != null) {
            object = pSDCMsgAccountBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMsgAccountBase.getCreateMan() != null) {
            object = pSDCMsgAccountBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getPSDCMsgAccountId() != null) {
            object = pSDCMsgAccountBase.getPSDCMsgAccountId();
            xmlNode.setAttribute(FIELD_PSDCMSGACCOUNTID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getPSDCMsgAccountName() != null) {
            object = pSDCMsgAccountBase.getPSDCMsgAccountName();
            xmlNode.setAttribute(FIELD_PSDCMSGACCOUNTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getPSDCOrgUserId() != null) {
            object = pSDCMsgAccountBase.getPSDCOrgUserId();
            xmlNode.setAttribute(FIELD_PSDCORGUSERID, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getPSDCOrgUserName() != null) {
            object = pSDCMsgAccountBase.getPSDCOrgUserName();
            xmlNode.setAttribute(FIELD_PSDCORGUSERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getUpdateDate() != null) {
            object = pSDCMsgAccountBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDCMsgAccountBase.getUpdateMan() != null) {
            object = pSDCMsgAccountBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDCMsgAccountBase.getValidFlag() != null) {
            object = pSDCMsgAccountBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDCMsgAccountBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDCMsgAccountBase pSDCMsgAccountBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDCMsgAccountBase.isCreateDateDirty() && (bl || pSDCMsgAccountBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDCMsgAccountBase.getCreateDate());
        }
        if (pSDCMsgAccountBase.isCreateManDirty() && (bl || pSDCMsgAccountBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDCMsgAccountBase.getCreateMan());
        }
        if (pSDCMsgAccountBase.isPSDCMsgAccountIdDirty() && (bl || pSDCMsgAccountBase.getPSDCMsgAccountId() != null)) {
            iDataObject.set(FIELD_PSDCMSGACCOUNTID, (Object)pSDCMsgAccountBase.getPSDCMsgAccountId());
        }
        if (pSDCMsgAccountBase.isPSDCMsgAccountNameDirty() && (bl || pSDCMsgAccountBase.getPSDCMsgAccountName() != null)) {
            iDataObject.set(FIELD_PSDCMSGACCOUNTNAME, (Object)pSDCMsgAccountBase.getPSDCMsgAccountName());
        }
        if (pSDCMsgAccountBase.isPSDCOrgUserIdDirty() && (bl || pSDCMsgAccountBase.getPSDCOrgUserId() != null)) {
            iDataObject.set(FIELD_PSDCORGUSERID, (Object)pSDCMsgAccountBase.getPSDCOrgUserId());
        }
        if (pSDCMsgAccountBase.isPSDCOrgUserNameDirty() && (bl || pSDCMsgAccountBase.getPSDCOrgUserName() != null)) {
            iDataObject.set(FIELD_PSDCORGUSERNAME, (Object)pSDCMsgAccountBase.getPSDCOrgUserName());
        }
        if (pSDCMsgAccountBase.isUpdateDateDirty() && (bl || pSDCMsgAccountBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDCMsgAccountBase.getUpdateDate());
        }
        if (pSDCMsgAccountBase.isUpdateManDirty() && (bl || pSDCMsgAccountBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDCMsgAccountBase.getUpdateMan());
        }
        if (pSDCMsgAccountBase.isValidFlagDirty() && (bl || pSDCMsgAccountBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDCMsgAccountBase.getValidFlag());
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
        return PSDCMsgAccountBase.remove(this, n);
    }

    private static boolean remove(PSDCMsgAccountBase pSDCMsgAccountBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDCMsgAccountBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDCMsgAccountBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDCMsgAccountBase.resetPSDCMsgAccountId();
                return true;
            }
            case 3: {
                pSDCMsgAccountBase.resetPSDCMsgAccountName();
                return true;
            }
            case 4: {
                pSDCMsgAccountBase.resetPSDCOrgUserId();
                return true;
            }
            case 5: {
                pSDCMsgAccountBase.resetPSDCOrgUserName();
                return true;
            }
            case 6: {
                pSDCMsgAccountBase.resetUpdateDate();
                return true;
            }
            case 7: {
                pSDCMsgAccountBase.resetUpdateMan();
                return true;
            }
            case 8: {
                pSDCMsgAccountBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDCOrgUser getPSDCOrgUser() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDCOrgUser();
        }
        if (this.getPSDCOrgUserId() == null) {
            return null;
        }
        Integer n = this.objPSDCOrgUserLock;
        synchronized (n) {
            if (this.psdcorguser != null && DataTypeHelper.compare((int)25, (Object)this.getPSDCOrgUserId(), (Object)this.psdcorguser.getPSDCOrgUserId()) != 0L) {
                this.psdcorguser = null;
            }
            if (this.psdcorguser == null) {
                PSDCOrgUser pSDCOrgUser = new PSDCOrgUser();
                pSDCOrgUser.setPSDCOrgUserId(this.getPSDCOrgUserId());
                PSDCOrgUserService pSDCOrgUserService = (PSDCOrgUserService)ServiceGlobal.getService(PSDCOrgUserService.class, (SessionFactory)this.getSessionFactory());
                pSDCOrgUserService.autoGet(pSDCOrgUser);
                this.psdcorguser = pSDCOrgUser;
            }
            return this.psdcorguser;
        }
    }

    private PSDCMsgAccountBase getProxyEntity() {
        return this.proxyPSDCMsgAccountBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDCMsgAccountBase = null;
        if (iDataObject != null && iDataObject instanceof PSDCMsgAccountBase) {
            this.proxyPSDCMsgAccountBase = (PSDCMsgAccountBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSDCMsgAccountService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSDCMSGACCOUNTID, 2);
        fieldIndexMap.put(FIELD_PSDCMSGACCOUNTNAME, 3);
        fieldIndexMap.put(FIELD_PSDCORGUSERID, 4);
        fieldIndexMap.put(FIELD_PSDCORGUSERNAME, 5);
        fieldIndexMap.put(FIELD_UPDATEDATE, 6);
        fieldIndexMap.put(FIELD_UPDATEMAN, 7);
        fieldIndexMap.put(FIELD_VALIDFLAG, 8);
    }
}

