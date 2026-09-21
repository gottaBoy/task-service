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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSCtrlMsgTag;
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlMsgTagService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeMsgTagBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeMsgTagBase.class);
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSCTRLMSGTAGID = "PSCTRLMSGTAGID";
    public static final String FIELD_PSCTRLMSGTAGNAME = "PSCTRLMSGTAGNAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPEMSGTAGID = "PSCTRLTYPEMSGTAGID";
    public static final String FIELD_PSCTRLTYPEMSGTAGNAME = "PSCTRLTYPEMSGTAGNAME";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONTENT = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSCTRLMSGTAGID = 4;
    private static final int INDEX_PSCTRLMSGTAGNAME = 5;
    private static final int INDEX_PSCTRLTYPEID = 6;
    private static final int INDEX_PSCTRLTYPEMSGTAGID = 7;
    private static final int INDEX_PSCTRLTYPEMSGTAGNAME = 8;
    private static final int INDEX_PSCTRLTYPENAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeMsgTagBase proxyPSCtrlTypeMsgTagBase = null;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psctrlmsgtagidDirtyFlag = false;
    private boolean psctrlmsgtagnameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypemsgtagidDirtyFlag = false;
    private boolean psctrltypemsgtagnameDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psctrlmsgtagid")
    private String psctrlmsgtagid;
    @Column(name="psctrlmsgtagname")
    private String psctrlmsgtagname;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypemsgtagid")
    private String psctrltypemsgtagid;
    @Column(name="psctrltypemsgtagname")
    private String psctrltypemsgtagname;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSCtrlMsgLock = new Integer(1);
    private PSCtrlMsgTag psctrlmsg = null;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;

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

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeMsgTagId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeMsgTagId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypemsgtagid = string;
        this.psctrltypemsgtagidDirtyFlag = true;
    }

    public String getPSCtrlTypeMsgTagId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeMsgTagId();
        }
        return this.psctrltypemsgtagid;
    }

    public boolean isPSCtrlTypeMsgTagIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeMsgTagIdDirty();
        }
        return this.psctrltypemsgtagidDirtyFlag;
    }

    public void resetPSCtrlTypeMsgTagId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeMsgTagId();
            return;
        }
        this.psctrltypemsgtagidDirtyFlag = false;
        this.psctrltypemsgtagid = null;
    }

    public void setPSCtrlTypeMsgTagName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeMsgTagName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypemsgtagname = string;
        this.psctrltypemsgtagnameDirtyFlag = true;
    }

    public String getPSCtrlTypeMsgTagName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeMsgTagName();
        }
        return this.psctrltypemsgtagname;
    }

    public boolean isPSCtrlTypeMsgTagNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeMsgTagNameDirty();
        }
        return this.psctrltypemsgtagnameDirtyFlag;
    }

    public void resetPSCtrlTypeMsgTagName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeMsgTagName();
            return;
        }
        this.psctrltypemsgtagnameDirtyFlag = false;
        this.psctrltypemsgtagname = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
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
        PSCtrlTypeMsgTagBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase) {
        pSCtrlTypeMsgTagBase.resetContent();
        pSCtrlTypeMsgTagBase.resetCreateDate();
        pSCtrlTypeMsgTagBase.resetCreateMan();
        pSCtrlTypeMsgTagBase.resetMemo();
        pSCtrlTypeMsgTagBase.resetPSCtrlMsgTagId();
        pSCtrlTypeMsgTagBase.resetPSCtrlMsgTagName();
        pSCtrlTypeMsgTagBase.resetPSCtrlTypeId();
        pSCtrlTypeMsgTagBase.resetPSCtrlTypeMsgTagId();
        pSCtrlTypeMsgTagBase.resetPSCtrlTypeMsgTagName();
        pSCtrlTypeMsgTagBase.resetPSCtrlTypeName();
        pSCtrlTypeMsgTagBase.resetUpdateDate();
        pSCtrlTypeMsgTagBase.resetUpdateMan();
        pSCtrlTypeMsgTagBase.resetValidFlag();
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSCtrlMsgTagIdDirty()) {
            hashMap.put(FIELD_PSCTRLMSGTAGID, this.getPSCtrlMsgTagId());
        }
        if (!bl || this.isPSCtrlMsgTagNameDirty()) {
            hashMap.put(FIELD_PSCTRLMSGTAGNAME, this.getPSCtrlMsgTagName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeMsgTagIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEMSGTAGID, this.getPSCtrlTypeMsgTagId());
        }
        if (!bl || this.isPSCtrlTypeMsgTagNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEMSGTAGNAME, this.getPSCtrlTypeMsgTagName());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
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
        return PSCtrlTypeMsgTagBase.get(this, n);
    }

    private static Object get(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeMsgTagBase.getContent();
            }
            case 1: {
                return pSCtrlTypeMsgTagBase.getCreateDate();
            }
            case 2: {
                return pSCtrlTypeMsgTagBase.getCreateMan();
            }
            case 3: {
                return pSCtrlTypeMsgTagBase.getMemo();
            }
            case 4: {
                return pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId();
            }
            case 5: {
                return pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName();
            }
            case 6: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeId();
            }
            case 7: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId();
            }
            case 8: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName();
            }
            case 9: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeName();
            }
            case 10: {
                return pSCtrlTypeMsgTagBase.getUpdateDate();
            }
            case 11: {
                return pSCtrlTypeMsgTagBase.getUpdateMan();
            }
            case 12: {
                return pSCtrlTypeMsgTagBase.getValidFlag();
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
        PSCtrlTypeMsgTagBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeMsgTagBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeMsgTagBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeMsgTagBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeMsgTagBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeMsgTagBase.setPSCtrlMsgTagId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeMsgTagBase.setPSCtrlMsgTagName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeMsgTagBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeMsgTagBase.setPSCtrlTypeMsgTagId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeMsgTagBase.setPSCtrlTypeMsgTagName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeMsgTagBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeMsgTagBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlTypeMsgTagBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlTypeMsgTagBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCtrlTypeMsgTagBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeMsgTagBase.getContent() == null;
            }
            case 1: {
                return pSCtrlTypeMsgTagBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlTypeMsgTagBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlTypeMsgTagBase.getMemo() == null;
            }
            case 4: {
                return pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId() == null;
            }
            case 5: {
                return pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName() == null;
            }
            case 6: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeId() == null;
            }
            case 7: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId() == null;
            }
            case 8: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName() == null;
            }
            case 9: {
                return pSCtrlTypeMsgTagBase.getPSCtrlTypeName() == null;
            }
            case 10: {
                return pSCtrlTypeMsgTagBase.getUpdateDate() == null;
            }
            case 11: {
                return pSCtrlTypeMsgTagBase.getUpdateMan() == null;
            }
            case 12: {
                return pSCtrlTypeMsgTagBase.getValidFlag() == null;
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
        return PSCtrlTypeMsgTagBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeMsgTagBase.isContentDirty();
            }
            case 1: {
                return pSCtrlTypeMsgTagBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlTypeMsgTagBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlTypeMsgTagBase.isMemoDirty();
            }
            case 4: {
                return pSCtrlTypeMsgTagBase.isPSCtrlMsgTagIdDirty();
            }
            case 5: {
                return pSCtrlTypeMsgTagBase.isPSCtrlMsgTagNameDirty();
            }
            case 6: {
                return pSCtrlTypeMsgTagBase.isPSCtrlTypeIdDirty();
            }
            case 7: {
                return pSCtrlTypeMsgTagBase.isPSCtrlTypeMsgTagIdDirty();
            }
            case 8: {
                return pSCtrlTypeMsgTagBase.isPSCtrlTypeMsgTagNameDirty();
            }
            case 9: {
                return pSCtrlTypeMsgTagBase.isPSCtrlTypeNameDirty();
            }
            case 10: {
                return pSCtrlTypeMsgTagBase.isUpdateDateDirty();
            }
            case 11: {
                return pSCtrlTypeMsgTagBase.isUpdateManDirty();
            }
            case 12: {
                return pSCtrlTypeMsgTagBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeMsgTagBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeMsgTagBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getContent()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgtagid", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrlmsgtagname", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypemsgtagid", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypemsgtagname", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeMsgTagBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCtrlTypeMsgTagBase.getJSONValue((Object)pSCtrlTypeMsgTagBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeMsgTagBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeMsgTagBase.getContent() != null) {
            object = pSCtrlTypeMsgTagBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getCreateDate() != null) {
            object = pSCtrlTypeMsgTagBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeMsgTagBase.getCreateMan() != null) {
            object = pSCtrlTypeMsgTagBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getMemo() != null) {
            object = pSCtrlTypeMsgTagBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId();
            xmlNode.setAttribute(FIELD_PSCTRLMSGTAGID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName();
            xmlNode.setAttribute(FIELD_PSCTRLMSGTAGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEMSGTAGID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEMSGTAGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeMsgTagBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getUpdateDate() != null) {
            object = pSCtrlTypeMsgTagBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeMsgTagBase.getUpdateMan() != null) {
            object = pSCtrlTypeMsgTagBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeMsgTagBase.getValidFlag() != null) {
            object = pSCtrlTypeMsgTagBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeMsgTagBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeMsgTagBase.isContentDirty() && (bl || pSCtrlTypeMsgTagBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSCtrlTypeMsgTagBase.getContent());
        }
        if (pSCtrlTypeMsgTagBase.isCreateDateDirty() && (bl || pSCtrlTypeMsgTagBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeMsgTagBase.getCreateDate());
        }
        if (pSCtrlTypeMsgTagBase.isCreateManDirty() && (bl || pSCtrlTypeMsgTagBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeMsgTagBase.getCreateMan());
        }
        if (pSCtrlTypeMsgTagBase.isMemoDirty() && (bl || pSCtrlTypeMsgTagBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlTypeMsgTagBase.getMemo());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlMsgTagIdDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGTAGID, (Object)pSCtrlTypeMsgTagBase.getPSCtrlMsgTagId());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlMsgTagNameDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName() != null)) {
            iDataObject.set(FIELD_PSCTRLMSGTAGNAME, (Object)pSCtrlTypeMsgTagBase.getPSCtrlMsgTagName());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlTypeMsgTagIdDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEMSGTAGID, (Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagId());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlTypeMsgTagNameDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEMSGTAGNAME, (Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeMsgTagName());
        }
        if (pSCtrlTypeMsgTagBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeMsgTagBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeMsgTagBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeMsgTagBase.isUpdateDateDirty() && (bl || pSCtrlTypeMsgTagBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeMsgTagBase.getUpdateDate());
        }
        if (pSCtrlTypeMsgTagBase.isUpdateManDirty() && (bl || pSCtrlTypeMsgTagBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeMsgTagBase.getUpdateMan());
        }
        if (pSCtrlTypeMsgTagBase.isValidFlagDirty() && (bl || pSCtrlTypeMsgTagBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCtrlTypeMsgTagBase.getValidFlag());
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
        return PSCtrlTypeMsgTagBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeMsgTagBase pSCtrlTypeMsgTagBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeMsgTagBase.resetContent();
                return true;
            }
            case 1: {
                pSCtrlTypeMsgTagBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlTypeMsgTagBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlTypeMsgTagBase.resetMemo();
                return true;
            }
            case 4: {
                pSCtrlTypeMsgTagBase.resetPSCtrlMsgTagId();
                return true;
            }
            case 5: {
                pSCtrlTypeMsgTagBase.resetPSCtrlMsgTagName();
                return true;
            }
            case 6: {
                pSCtrlTypeMsgTagBase.resetPSCtrlTypeId();
                return true;
            }
            case 7: {
                pSCtrlTypeMsgTagBase.resetPSCtrlTypeMsgTagId();
                return true;
            }
            case 8: {
                pSCtrlTypeMsgTagBase.resetPSCtrlTypeMsgTagName();
                return true;
            }
            case 9: {
                pSCtrlTypeMsgTagBase.resetPSCtrlTypeName();
                return true;
            }
            case 10: {
                pSCtrlTypeMsgTagBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSCtrlTypeMsgTagBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSCtrlTypeMsgTagBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlMsgTag getPSCtrlMsg() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlMsg();
        }
        if (this.getPSCtrlMsgTagId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlMsgLock;
        synchronized (n) {
            if (this.psctrlmsg != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlMsgTagId(), (Object)this.psctrlmsg.getPSCtrlMsgTagId()) != 0L) {
                this.psctrlmsg = null;
            }
            if (this.psctrlmsg == null) {
                PSCtrlMsgTag pSCtrlMsgTag = new PSCtrlMsgTag();
                pSCtrlMsgTag.setPSCtrlMsgTagId(this.getPSCtrlMsgTagId());
                PSCtrlMsgTagService pSCtrlMsgTagService = (PSCtrlMsgTagService)ServiceGlobal.getService(PSCtrlMsgTagService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlMsgTagService.autoGet((IEntity)pSCtrlMsgTag);
                this.psctrlmsg = pSCtrlMsgTag;
            }
            return this.psctrlmsg;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCtrlType getPSCtrlType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlType();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        Integer n = this.objPSCtrlTypeLock;
        synchronized (n) {
            if (this.psctrltype != null && DataTypeHelper.compare((int)25, (Object)this.getPSCtrlTypeId(), (Object)this.psctrltype.getPSCtrlTypeId()) != 0L) {
                this.psctrltype = null;
            }
            if (this.psctrltype == null) {
                PSCtrlType pSCtrlType = new PSCtrlType();
                pSCtrlType.setPSCtrlTypeId(this.getPSCtrlTypeId());
                PSCtrlTypeService pSCtrlTypeService = (PSCtrlTypeService)ServiceGlobal.getService(PSCtrlTypeService.class, (SessionFactory)this.getSessionFactory());
                pSCtrlTypeService.autoGet((IEntity)pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
    }

    private PSCtrlTypeMsgTagBase getProxyEntity() {
        return this.proxyPSCtrlTypeMsgTagBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeMsgTagBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeMsgTagBase) {
            this.proxyPSCtrlTypeMsgTagBase = (PSCtrlTypeMsgTagBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONTENT, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSCTRLMSGTAGID, 4);
        fieldIndexMap.put(FIELD_PSCTRLMSGTAGNAME, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 6);
        fieldIndexMap.put(FIELD_PSCTRLTYPEMSGTAGID, 7);
        fieldIndexMap.put(FIELD_PSCTRLTYPEMSGTAGNAME, 8);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

