/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
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
package net.ibizsys.pscore.srv.config.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeMsgTag;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlMsgTagBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlMsgTagBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLMSGTAGID = "PSCTRLMSGTAGID";
    public static final String FIELD_PSCTRLMSGTAGNAME = "PSCTRLMSGTAGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_LOGICNAME = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PSCTRLMSGTAGID = 5;
    private static final int INDEX_PSCTRLMSGTAGNAME = 6;
    private static final int INDEX_UPDATEDATE = 7;
    private static final int INDEX_UPDATEMAN = 8;
    private static final int INDEX_VALIDFLAG = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlMsgTagBase proxyPSCtrlMsgTagBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrlmsgtagidDirtyFlag = false;
    private boolean psctrlmsgtagnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrlmsgtagid")
    private String psctrlmsgtagid;
    @Column(name="psctrlmsgtagname")
    private String psctrlmsgtagname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCtrlTypeMsgTagsLock = new Integer(1);
    private ArrayList<PSCtrlTypeMsgTag> psctrltypemsgtags = null;

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

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setPSCtrlMsgTagId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgTagId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgtagid = string;
        this.psctrlmsgtagidDirtyFlag = true;
    }

    public String getPSCtrlMsgTagId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgTagId();
        }
        return this.psctrlmsgtagid;
    }

    public boolean isPSCtrlMsgTagIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgTagIdDirty();
        }
        return this.psctrlmsgtagidDirtyFlag;
    }

    public void resetPSCtrlMsgTagId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgTagId();
            return;
        }
        this.psctrlmsgtagidDirtyFlag = false;
        this.psctrlmsgtagid = null;
    }

    public void setPSCtrlMsgTagName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlMsgTagName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrlmsgtagname = string;
        this.psctrlmsgtagnameDirtyFlag = true;
    }

    public String getPSCtrlMsgTagName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsgTagName();
        }
        return this.psctrlmsgtagname;
    }

    public boolean isPSCtrlMsgTagNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlMsgTagNameDirty();
        }
        return this.psctrlmsgtagnameDirtyFlag;
    }

    public void resetPSCtrlMsgTagName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlMsgTagName();
            return;
        }
        this.psctrlmsgtagnameDirtyFlag = false;
        this.psctrlmsgtagname = null;
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
        PSCtrlMsgTagBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlMsgTagBase pSCtrlMsgTagBase) {
        pSCtrlMsgTagBase.resetContent();
        pSCtrlMsgTagBase.resetCreateDate();
        pSCtrlMsgTagBase.resetCreateMan();
        pSCtrlMsgTagBase.resetLogicName();
        pSCtrlMsgTagBase.resetMemo();
        pSCtrlMsgTagBase.resetPSCtrlMsgTagId();
        pSCtrlMsgTagBase.resetPSCtrlMsgTagName();
        pSCtrlMsgTagBase.resetUpdateDate();
        pSCtrlMsgTagBase.resetUpdateMan();
        pSCtrlMsgTagBase.resetValidFlag();
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
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlMsgTagIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGTAGID, this.getPSCtrlMsgTagId());
        }
        if (!bl || this.isPSCtrlMsgTagNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGTAGNAME, this.getPSCtrlMsgTagName());
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
        return PSCtrlMsgTagBase.get(this, n);
    }

    private static Object get(PSCtrlMsgTagBase pSCtrlMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgTagBase.getContent();
            }
            case 1: {
                return pSCtrlMsgTagBase.getCreateDate();
            }
            case 2: {
                return pSCtrlMsgTagBase.getCreateMan();
            }
            case 3: {
                return pSCtrlMsgTagBase.getLogicName();
            }
            case 4: {
                return pSCtrlMsgTagBase.getMemo();
            }
            case 5: {
                return pSCtrlMsgTagBase.getPSCtrlMsgTagId();
            }
            case 6: {
                return pSCtrlMsgTagBase.getPSCtrlMsgTagName();
            }
            case 7: {
                return pSCtrlMsgTagBase.getUpdateDate();
            }
            case 8: {
                return pSCtrlMsgTagBase.getUpdateMan();
            }
            case 9: {
                return pSCtrlMsgTagBase.getValidFlag();
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
        PSCtrlMsgTagBase.set(this, n, object);
    }

    private static void set(PSCtrlMsgTagBase pSCtrlMsgTagBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgTagBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlMsgTagBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlMsgTagBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlMsgTagBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlMsgTagBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlMsgTagBase.setPSCtrlMsgTagId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlMsgTagBase.setPSCtrlMsgTagName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlMsgTagBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlMsgTagBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlMsgTagBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlMsgTagBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlMsgTagBase pSCtrlMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgTagBase.getContent() == null;
            }
            case 1: {
                return pSCtrlMsgTagBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlMsgTagBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlMsgTagBase.getLogicName() == null;
            }
            case 4: {
                return pSCtrlMsgTagBase.getMemo() == null;
            }
            case 5: {
                return pSCtrlMsgTagBase.getPSCtrlMsgTagId() == null;
            }
            case 6: {
                return pSCtrlMsgTagBase.getPSCtrlMsgTagName() == null;
            }
            case 7: {
                return pSCtrlMsgTagBase.getUpdateDate() == null;
            }
            case 8: {
                return pSCtrlMsgTagBase.getUpdateMan() == null;
            }
            case 9: {
                return pSCtrlMsgTagBase.getValidFlag() == null;
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
        return PSCtrlMsgTagBase.contains(this, n);
    }

    private static boolean contains(PSCtrlMsgTagBase pSCtrlMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlMsgTagBase.isContentDirty();
            }
            case 1: {
                return pSCtrlMsgTagBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlMsgTagBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlMsgTagBase.isLogicNameDirty();
            }
            case 4: {
                return pSCtrlMsgTagBase.isMemoDirty();
            }
            case 5: {
                return pSCtrlMsgTagBase.isPSCtrlMsgTagIdDirty();
            }
            case 6: {
                return pSCtrlMsgTagBase.isPSCtrlMsgTagNameDirty();
            }
            case 7: {
                return pSCtrlMsgTagBase.isUpdateDateDirty();
            }
            case 8: {
                return pSCtrlMsgTagBase.isUpdateManDirty();
            }
            case 9: {
                return pSCtrlMsgTagBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlMsgTagBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlMsgTagBase pSCtrlMsgTagBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlMsgTagBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getContent()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getLogicName()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgtagid", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getPSCtrlMsgTagId()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgtagname", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getPSCtrlMsgTagName()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlMsgTagBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlMsgTagBase.getJSONValue((Object)pSCtrlMsgTagBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlMsgTagBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlMsgTagBase pSCtrlMsgTagBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlMsgTagBase.getContent() != null) {
            object = pSCtrlMsgTagBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getCreateDate() != null) {
            object = pSCtrlMsgTagBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgTagBase.getCreateMan() != null) {
            object = pSCtrlMsgTagBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getLogicName() != null) {
            object = pSCtrlMsgTagBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getMemo() != null) {
            object = pSCtrlMsgTagBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagId() != null) {
            object = pSCtrlMsgTagBase.getPSCtrlMsgTagId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGTAGID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagName() != null) {
            object = pSCtrlMsgTagBase.getPSCtrlMsgTagName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGTAGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getUpdateDate() != null) {
            object = pSCtrlMsgTagBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlMsgTagBase.getUpdateMan() != null) {
            object = pSCtrlMsgTagBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlMsgTagBase.getValidFlag() != null) {
            object = pSCtrlMsgTagBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlMsgTagBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlMsgTagBase pSCtrlMsgTagBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlMsgTagBase.isContentDirty() && (bl || pSCtrlMsgTagBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSCtrlMsgTagBase.getContent());
        }
        if (pSCtrlMsgTagBase.isCreateDateDirty() && (bl || pSCtrlMsgTagBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlMsgTagBase.getCreateDate());
        }
        if (pSCtrlMsgTagBase.isCreateManDirty() && (bl || pSCtrlMsgTagBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlMsgTagBase.getCreateMan());
        }
        if (pSCtrlMsgTagBase.isLogicNameDirty() && (bl || pSCtrlMsgTagBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSCtrlMsgTagBase.getLogicName());
        }
        if (pSCtrlMsgTagBase.isMemoDirty() && (bl || pSCtrlMsgTagBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlMsgTagBase.getMemo());
        }
        if (pSCtrlMsgTagBase.isPSCtrlMsgTagIdDirty() && (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGTAGID, (Object)pSCtrlMsgTagBase.getPSCtrlMsgTagId());
        }
        if (pSCtrlMsgTagBase.isPSCtrlMsgTagNameDirty() && (bl || pSCtrlMsgTagBase.getPSCtrlMsgTagName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGTAGNAME, (Object)pSCtrlMsgTagBase.getPSCtrlMsgTagName());
        }
        if (pSCtrlMsgTagBase.isUpdateDateDirty() && (bl || pSCtrlMsgTagBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlMsgTagBase.getUpdateDate());
        }
        if (pSCtrlMsgTagBase.isUpdateManDirty() && (bl || pSCtrlMsgTagBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlMsgTagBase.getUpdateMan());
        }
        if (pSCtrlMsgTagBase.isValidFlagDirty() && (bl || pSCtrlMsgTagBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlMsgTagBase.getValidFlag());
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
        return PSCtrlMsgTagBase.remove(this, n);
    }

    private static boolean remove(PSCtrlMsgTagBase pSCtrlMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlMsgTagBase.resetContent();
                return true;
            }
            case 1: {
                pSCtrlMsgTagBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlMsgTagBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlMsgTagBase.resetLogicName();
                return true;
            }
            case 4: {
                pSCtrlMsgTagBase.resetMemo();
                return true;
            }
            case 5: {
                pSCtrlMsgTagBase.resetPSCtrlMsgTagId();
                return true;
            }
            case 6: {
                pSCtrlMsgTagBase.resetPSCtrlMsgTagName();
                return true;
            }
            case 7: {
                pSCtrlMsgTagBase.resetUpdateDate();
                return true;
            }
            case 8: {
                pSCtrlMsgTagBase.resetUpdateMan();
                return true;
            }
            case 9: {
                pSCtrlMsgTagBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlTypeMsgTag> getPSCtrlTypeMsgTags() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeMsgTags();
        }
        if (this.getPSCtrlMsgTagId() == null) {
            return null;
        }
        PSCtrlTypeMsgTagService pSCtrlTypeMsgTagService = (PSCtrlTypeMsgTagService)ServiceGlobal.getService(PSCtrlTypeMsgTagService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlTypeMsgTagsLock;
        synchronized (n) {
            if (this.psctrltypemsgtags == null) {
                this.psctrltypemsgtags = pSCtrlTypeMsgTagService.selectByPSCtrlMsg(this);
            }
            return this.psctrltypemsgtags;
        }
    }

    private PSCtrlMsgTagBase getProxyEntity() {
        return this.proxyPSCtrlMsgTagBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlMsgTagBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlMsgTagBase) {
            this.proxyPSCtrlMsgTagBase = (PSCtrlMsgTagBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlMsgTagService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_LOGICNAME, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PSCTRLMSGTAGID, 5);
        fieldIndexMap.put(FIELD_PSCTRLMSGTAGNAME, 6);
        fieldIndexMap.put(FIELD_UPDATEDATE, 7);
        fieldIndexMap.put(FIELD_UPDATEMAN, 8);
        fieldIndexMap.put(FIELD_VALIDFLAG, 9);
    }
}

