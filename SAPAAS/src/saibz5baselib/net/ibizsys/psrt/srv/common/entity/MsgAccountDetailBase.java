/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 */
package net.ibizsys.psrt.srv.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.DataTypeHelper;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.ibizsys.psrt.srv.common.entity.MsgAccount;
import net.ibizsys.psrt.srv.common.service.MsgAccountService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class MsgAccountDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(MsgAccountDetailBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MAJORMSGACCOUNTID = "MAJORMSGACCOUNTID";
    public static final String FIELD_MAJORMSGACCOUNTNAME = "MAJORMSGACCOUNTNAME";
    public static final String FIELD_MINORMSGACCOUNTID = "MINORMSGACCOUNTID";
    public static final String FIELD_MINORMSGACCOUNTNAME = "MINORMSGACCOUNTNAME";
    public static final String FIELD_MSGACCOUNTDETAILID = "MSGACCOUNTDETAILID";
    public static final String FIELD_MSGACCOUNTDETAILNAME = "MSGACCOUNTDETAILNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MAJORMSGACCOUNTID = 2;
    private static final int INDEX_MAJORMSGACCOUNTNAME = 3;
    private static final int INDEX_MINORMSGACCOUNTID = 4;
    private static final int INDEX_MINORMSGACCOUNTNAME = 5;
    private static final int INDEX_MSGACCOUNTDETAILID = 6;
    private static final int INDEX_MSGACCOUNTDETAILNAME = 7;
    private static final int INDEX_UPDATEDATE = 8;
    private static final int INDEX_UPDATEMAN = 9;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private MsgAccountDetailBase proxyMsgAccountDetailBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean majormsgaccountidDirtyFlag = false;
    private boolean majormsgaccountnameDirtyFlag = false;
    private boolean minormsgaccountidDirtyFlag = false;
    private boolean minormsgaccountnameDirtyFlag = false;
    private boolean msgaccountdetailidDirtyFlag = false;
    private boolean msgaccountdetailnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="majormsgaccountid")
    private String majormsgaccountid;
    @Column(name="majormsgaccountname")
    private String majormsgaccountname;
    @Column(name="minormsgaccountid")
    private String minormsgaccountid;
    @Column(name="minormsgaccountname")
    private String minormsgaccountname;
    @Column(name="msgaccountdetailid")
    private String msgaccountdetailid;
    @Column(name="msgaccountdetailname")
    private String msgaccountdetailname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objMajorMsgAccountLock = new Integer(1);
    private MsgAccount majormsgaccount = null;
    private Integer objMinorMsgAccountLock = new Integer(1);
    private MsgAccount minormsgaccount = null;

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MAJORMSGACCOUNTID, 2);
        fieldIndexMap.put(FIELD_MAJORMSGACCOUNTNAME, 3);
        fieldIndexMap.put(FIELD_MINORMSGACCOUNTID, 4);
        fieldIndexMap.put(FIELD_MINORMSGACCOUNTNAME, 5);
        fieldIndexMap.put(FIELD_MSGACCOUNTDETAILID, 6);
        fieldIndexMap.put(FIELD_MSGACCOUNTDETAILNAME, 7);
        fieldIndexMap.put(FIELD_UPDATEDATE, 8);
        fieldIndexMap.put(FIELD_UPDATEMAN, 9);
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

    public void setMajorMsgAccountId(String majormsgaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorMsgAccountId(majormsgaccountid);
            return;
        }
        if (majormsgaccountid != null && (majormsgaccountid = StringHelper.trimRight(majormsgaccountid)).length() == 0) {
            majormsgaccountid = null;
        }
        this.majormsgaccountid = majormsgaccountid;
        this.majormsgaccountidDirtyFlag = true;
    }

    public String getMajorMsgAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorMsgAccountId();
        }
        return this.majormsgaccountid;
    }

    public boolean isMajorMsgAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorMsgAccountIdDirty();
        }
        return this.majormsgaccountidDirtyFlag;
    }

    public void resetMajorMsgAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorMsgAccountId();
            return;
        }
        this.majormsgaccountidDirtyFlag = false;
        this.majormsgaccountid = null;
    }

    public void setMajorMsgAccountName(String majormsgaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMajorMsgAccountName(majormsgaccountname);
            return;
        }
        if (majormsgaccountname != null && (majormsgaccountname = StringHelper.trimRight(majormsgaccountname)).length() == 0) {
            majormsgaccountname = null;
        }
        this.majormsgaccountname = majormsgaccountname;
        this.majormsgaccountnameDirtyFlag = true;
    }

    public String getMajorMsgAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorMsgAccountName();
        }
        return this.majormsgaccountname;
    }

    public boolean isMajorMsgAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMajorMsgAccountNameDirty();
        }
        return this.majormsgaccountnameDirtyFlag;
    }

    public void resetMajorMsgAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMajorMsgAccountName();
            return;
        }
        this.majormsgaccountnameDirtyFlag = false;
        this.majormsgaccountname = null;
    }

    public void setMinorMsgAccountId(String minormsgaccountid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorMsgAccountId(minormsgaccountid);
            return;
        }
        if (minormsgaccountid != null && (minormsgaccountid = StringHelper.trimRight(minormsgaccountid)).length() == 0) {
            minormsgaccountid = null;
        }
        this.minormsgaccountid = minormsgaccountid;
        this.minormsgaccountidDirtyFlag = true;
    }

    public String getMinorMsgAccountId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorMsgAccountId();
        }
        return this.minormsgaccountid;
    }

    public boolean isMinorMsgAccountIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorMsgAccountIdDirty();
        }
        return this.minormsgaccountidDirtyFlag;
    }

    public void resetMinorMsgAccountId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorMsgAccountId();
            return;
        }
        this.minormsgaccountidDirtyFlag = false;
        this.minormsgaccountid = null;
    }

    public void setMinorMsgAccountName(String minormsgaccountname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinorMsgAccountName(minormsgaccountname);
            return;
        }
        if (minormsgaccountname != null && (minormsgaccountname = StringHelper.trimRight(minormsgaccountname)).length() == 0) {
            minormsgaccountname = null;
        }
        this.minormsgaccountname = minormsgaccountname;
        this.minormsgaccountnameDirtyFlag = true;
    }

    public String getMinorMsgAccountName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorMsgAccountName();
        }
        return this.minormsgaccountname;
    }

    public boolean isMinorMsgAccountNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinorMsgAccountNameDirty();
        }
        return this.minormsgaccountnameDirtyFlag;
    }

    public void resetMinorMsgAccountName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinorMsgAccountName();
            return;
        }
        this.minormsgaccountnameDirtyFlag = false;
        this.minormsgaccountname = null;
    }

    public void setMsgAccountDetailId(String msgaccountdetailid) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgAccountDetailId(msgaccountdetailid);
            return;
        }
        if (msgaccountdetailid != null && (msgaccountdetailid = StringHelper.trimRight(msgaccountdetailid)).length() == 0) {
            msgaccountdetailid = null;
        }
        this.msgaccountdetailid = msgaccountdetailid;
        this.msgaccountdetailidDirtyFlag = true;
    }

    public String getMsgAccountDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgAccountDetailId();
        }
        return this.msgaccountdetailid;
    }

    public boolean isMsgAccountDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgAccountDetailIdDirty();
        }
        return this.msgaccountdetailidDirtyFlag;
    }

    public void resetMsgAccountDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgAccountDetailId();
            return;
        }
        this.msgaccountdetailidDirtyFlag = false;
        this.msgaccountdetailid = null;
    }

    public void setMsgAccountDetailName(String msgaccountdetailname) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMsgAccountDetailName(msgaccountdetailname);
            return;
        }
        if (msgaccountdetailname != null && (msgaccountdetailname = StringHelper.trimRight(msgaccountdetailname)).length() == 0) {
            msgaccountdetailname = null;
        }
        this.msgaccountdetailname = msgaccountdetailname;
        this.msgaccountdetailnameDirtyFlag = true;
    }

    public String getMsgAccountDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMsgAccountDetailName();
        }
        return this.msgaccountdetailname;
    }

    public boolean isMsgAccountDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMsgAccountDetailNameDirty();
        }
        return this.msgaccountdetailnameDirtyFlag;
    }

    public void resetMsgAccountDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMsgAccountDetailName();
            return;
        }
        this.msgaccountdetailnameDirtyFlag = false;
        this.msgaccountdetailname = null;
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

    @Override
    protected void onReset() {
        MsgAccountDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(MsgAccountDetailBase et) {
        et.resetCreateDate();
        et.resetCreateMan();
        et.resetMajorMsgAccountId();
        et.resetMajorMsgAccountName();
        et.resetMinorMsgAccountId();
        et.resetMinorMsgAccountName();
        et.resetMsgAccountDetailId();
        et.resetMsgAccountDetailName();
        et.resetUpdateDate();
        et.resetUpdateMan();
    }

    @Override
    protected void onFillMap(HashMap<String, Object> params, boolean bDirtyOnly) {
        if (!bDirtyOnly || this.isCreateDateDirty()) {
            params.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bDirtyOnly || this.isCreateManDirty()) {
            params.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bDirtyOnly || this.isMajorMsgAccountIdDirty()) {
            params.put(FIELD_MAJORMSGACCOUNTID, this.getMajorMsgAccountId());
        }
        if (!bDirtyOnly || this.isMajorMsgAccountNameDirty()) {
            params.put(FIELD_MAJORMSGACCOUNTNAME, this.getMajorMsgAccountName());
        }
        if (!bDirtyOnly || this.isMinorMsgAccountIdDirty()) {
            params.put(FIELD_MINORMSGACCOUNTID, this.getMinorMsgAccountId());
        }
        if (!bDirtyOnly || this.isMinorMsgAccountNameDirty()) {
            params.put(FIELD_MINORMSGACCOUNTNAME, this.getMinorMsgAccountName());
        }
        if (!bDirtyOnly || this.isMsgAccountDetailIdDirty()) {
            params.put(FIELD_MSGACCOUNTDETAILID, this.getMsgAccountDetailId());
        }
        if (!bDirtyOnly || this.isMsgAccountDetailNameDirty()) {
            params.put(FIELD_MSGACCOUNTDETAILNAME, this.getMsgAccountDetailName());
        }
        if (!bDirtyOnly || this.isUpdateDateDirty()) {
            params.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bDirtyOnly || this.isUpdateManDirty()) {
            params.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return MsgAccountDetailBase.get(this, index);
    }

    private static Object get(MsgAccountDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate();
            }
            case 1: {
                return et.getCreateMan();
            }
            case 2: {
                return et.getMajorMsgAccountId();
            }
            case 3: {
                return et.getMajorMsgAccountName();
            }
            case 4: {
                return et.getMinorMsgAccountId();
            }
            case 5: {
                return et.getMinorMsgAccountName();
            }
            case 6: {
                return et.getMsgAccountDetailId();
            }
            case 7: {
                return et.getMsgAccountDetailName();
            }
            case 8: {
                return et.getUpdateDate();
            }
            case 9: {
                return et.getUpdateMan();
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
        MsgAccountDetailBase.set(this, index, objValue);
    }

    private static void set(MsgAccountDetailBase et, int index, Object obj) throws Exception {
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
                et.setMajorMsgAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 3: {
                et.setMajorMsgAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 4: {
                et.setMinorMsgAccountId(DataObject.getStringValue(obj));
                return;
            }
            case 5: {
                et.setMinorMsgAccountName(DataObject.getStringValue(obj));
                return;
            }
            case 6: {
                et.setMsgAccountDetailId(DataObject.getStringValue(obj));
                return;
            }
            case 7: {
                et.setMsgAccountDetailName(DataObject.getStringValue(obj));
                return;
            }
            case 8: {
                et.setUpdateDate(DataObject.getTimestampValue(obj));
                return;
            }
            case 9: {
                et.setUpdateMan(DataObject.getStringValue(obj));
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
        return MsgAccountDetailBase.isNull(this, index);
    }

    private static boolean isNull(MsgAccountDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.getCreateDate() == null;
            }
            case 1: {
                return et.getCreateMan() == null;
            }
            case 2: {
                return et.getMajorMsgAccountId() == null;
            }
            case 3: {
                return et.getMajorMsgAccountName() == null;
            }
            case 4: {
                return et.getMinorMsgAccountId() == null;
            }
            case 5: {
                return et.getMinorMsgAccountName() == null;
            }
            case 6: {
                return et.getMsgAccountDetailId() == null;
            }
            case 7: {
                return et.getMsgAccountDetailName() == null;
            }
            case 8: {
                return et.getUpdateDate() == null;
            }
            case 9: {
                return et.getUpdateMan() == null;
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
        return MsgAccountDetailBase.contains(this, index);
    }

    private static boolean contains(MsgAccountDetailBase et, int index) throws Exception {
        switch (index) {
            case 0: {
                return et.isCreateDateDirty();
            }
            case 1: {
                return et.isCreateManDirty();
            }
            case 2: {
                return et.isMajorMsgAccountIdDirty();
            }
            case 3: {
                return et.isMajorMsgAccountNameDirty();
            }
            case 4: {
                return et.isMinorMsgAccountIdDirty();
            }
            case 5: {
                return et.isMinorMsgAccountNameDirty();
            }
            case 6: {
                return et.isMsgAccountDetailIdDirty();
            }
            case 7: {
                return et.isMsgAccountDetailNameDirty();
            }
            case 8: {
                return et.isUpdateDateDirty();
            }
            case 9: {
                return et.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    @Override
    protected void onFillJSONObject(JSONObject objJSON, boolean bIncludeEmpty) throws Exception {
        MsgAccountDetailBase.fillJSONObject(this, objJSON, bIncludeEmpty);
        super.onFillJSONObject(objJSON, bIncludeEmpty);
    }

    private static void fillJSONObject(MsgAccountDetailBase et, JSONObject json, boolean bIncEmpty) throws Exception {
        if (bIncEmpty || et.getCreateDate() != null) {
            JSONObjectHelper.put(json, "createdate", MsgAccountDetailBase.getJSONValue(et.getCreateDate()), false);
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            JSONObjectHelper.put(json, "createman", MsgAccountDetailBase.getJSONValue(et.getCreateMan()), false);
        }
        if (bIncEmpty || et.getMajorMsgAccountId() != null) {
            JSONObjectHelper.put(json, "majormsgaccountid", MsgAccountDetailBase.getJSONValue(et.getMajorMsgAccountId()), false);
        }
        if (bIncEmpty || et.getMajorMsgAccountName() != null) {
            JSONObjectHelper.put(json, "majormsgaccountname", MsgAccountDetailBase.getJSONValue(et.getMajorMsgAccountName()), false);
        }
        if (bIncEmpty || et.getMinorMsgAccountId() != null) {
            JSONObjectHelper.put(json, "minormsgaccountid", MsgAccountDetailBase.getJSONValue(et.getMinorMsgAccountId()), false);
        }
        if (bIncEmpty || et.getMinorMsgAccountName() != null) {
            JSONObjectHelper.put(json, "minormsgaccountname", MsgAccountDetailBase.getJSONValue(et.getMinorMsgAccountName()), false);
        }
        if (bIncEmpty || et.getMsgAccountDetailId() != null) {
            JSONObjectHelper.put(json, "msgaccountdetailid", MsgAccountDetailBase.getJSONValue(et.getMsgAccountDetailId()), false);
        }
        if (bIncEmpty || et.getMsgAccountDetailName() != null) {
            JSONObjectHelper.put(json, "msgaccountdetailname", MsgAccountDetailBase.getJSONValue(et.getMsgAccountDetailName()), false);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            JSONObjectHelper.put(json, "updatedate", MsgAccountDetailBase.getJSONValue(et.getUpdateDate()), false);
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            JSONObjectHelper.put(json, "updateman", MsgAccountDetailBase.getJSONValue(et.getUpdateMan()), false);
        }
    }

    @Override
    protected void onFillXmlNode(XmlNode xmlNode, boolean bIncludeEmpty) throws Exception {
        MsgAccountDetailBase.fillXmlNode(this, xmlNode, bIncludeEmpty);
        super.onFillXmlNode(xmlNode, bIncludeEmpty);
    }

    private static void fillXmlNode(MsgAccountDetailBase et, XmlNode node, boolean bIncEmpty) throws Exception {
        Object obj;
        if (bIncEmpty || et.getCreateDate() != null) {
            obj = et.getCreateDate();
            node.setAttribute(FIELD_CREATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getCreateMan() != null) {
            obj = et.getCreateMan();
            node.setAttribute(FIELD_CREATEMAN, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMajorMsgAccountId() != null) {
            obj = et.getMajorMsgAccountId();
            node.setAttribute(FIELD_MAJORMSGACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMajorMsgAccountName() != null) {
            obj = et.getMajorMsgAccountName();
            node.setAttribute(FIELD_MAJORMSGACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorMsgAccountId() != null) {
            obj = et.getMinorMsgAccountId();
            node.setAttribute(FIELD_MINORMSGACCOUNTID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMinorMsgAccountName() != null) {
            obj = et.getMinorMsgAccountName();
            node.setAttribute(FIELD_MINORMSGACCOUNTNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgAccountDetailId() != null) {
            obj = et.getMsgAccountDetailId();
            node.setAttribute(FIELD_MSGACCOUNTDETAILID, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getMsgAccountDetailName() != null) {
            obj = et.getMsgAccountDetailName();
            node.setAttribute(FIELD_MSGACCOUNTDETAILNAME, obj == null ? "" : (String)obj);
        }
        if (bIncEmpty || et.getUpdateDate() != null) {
            obj = et.getUpdateDate();
            node.setAttribute(FIELD_UPDATEDATE, obj == null ? "" : StringHelper.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", obj));
        }
        if (bIncEmpty || et.getUpdateMan() != null) {
            obj = et.getUpdateMan();
            node.setAttribute(FIELD_UPDATEMAN, obj == null ? "" : (String)obj);
        }
    }

    @Override
    protected void onCopyTo(IDataObject dataEntity, boolean bIncludeEmtpy) throws Exception {
        MsgAccountDetailBase.copyTo(this, dataEntity, bIncludeEmtpy);
        super.onCopyTo(dataEntity, bIncludeEmtpy);
    }

    private static void copyTo(MsgAccountDetailBase et, IDataObject dst, boolean bIncEmpty) throws Exception {
        if (et.isCreateDateDirty() && (bIncEmpty || et.getCreateDate() != null)) {
            dst.set(FIELD_CREATEDATE, et.getCreateDate());
        }
        if (et.isCreateManDirty() && (bIncEmpty || et.getCreateMan() != null)) {
            dst.set(FIELD_CREATEMAN, et.getCreateMan());
        }
        if (et.isMajorMsgAccountIdDirty() && (bIncEmpty || et.getMajorMsgAccountId() != null)) {
            dst.set(FIELD_MAJORMSGACCOUNTID, et.getMajorMsgAccountId());
        }
        if (et.isMajorMsgAccountNameDirty() && (bIncEmpty || et.getMajorMsgAccountName() != null)) {
            dst.set(FIELD_MAJORMSGACCOUNTNAME, et.getMajorMsgAccountName());
        }
        if (et.isMinorMsgAccountIdDirty() && (bIncEmpty || et.getMinorMsgAccountId() != null)) {
            dst.set(FIELD_MINORMSGACCOUNTID, et.getMinorMsgAccountId());
        }
        if (et.isMinorMsgAccountNameDirty() && (bIncEmpty || et.getMinorMsgAccountName() != null)) {
            dst.set(FIELD_MINORMSGACCOUNTNAME, et.getMinorMsgAccountName());
        }
        if (et.isMsgAccountDetailIdDirty() && (bIncEmpty || et.getMsgAccountDetailId() != null)) {
            dst.set(FIELD_MSGACCOUNTDETAILID, et.getMsgAccountDetailId());
        }
        if (et.isMsgAccountDetailNameDirty() && (bIncEmpty || et.getMsgAccountDetailName() != null)) {
            dst.set(FIELD_MSGACCOUNTDETAILNAME, et.getMsgAccountDetailName());
        }
        if (et.isUpdateDateDirty() && (bIncEmpty || et.getUpdateDate() != null)) {
            dst.set(FIELD_UPDATEDATE, et.getUpdateDate());
        }
        if (et.isUpdateManDirty() && (bIncEmpty || et.getUpdateMan() != null)) {
            dst.set(FIELD_UPDATEMAN, et.getUpdateMan());
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
        return MsgAccountDetailBase.remove(this, index);
    }

    private static boolean remove(MsgAccountDetailBase et, int index) throws Exception {
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
                et.resetMajorMsgAccountId();
                return true;
            }
            case 3: {
                et.resetMajorMsgAccountName();
                return true;
            }
            case 4: {
                et.resetMinorMsgAccountId();
                return true;
            }
            case 5: {
                et.resetMinorMsgAccountName();
                return true;
            }
            case 6: {
                et.resetMsgAccountDetailId();
                return true;
            }
            case 7: {
                et.resetMsgAccountDetailName();
                return true;
            }
            case 8: {
                et.resetUpdateDate();
                return true;
            }
            case 9: {
                et.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MsgAccount getMajorMsgAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMajorMsgAccount();
        }
        if (this.getMajorMsgAccountId() == null) {
            return null;
        }
        Integer n = this.objMajorMsgAccountLock;
        synchronized (n) {
            if (this.majormsgaccount != null && DataTypeHelper.compare(25, (Object)this.getMajorMsgAccountId(), (Object)this.majormsgaccount.getMsgAccountId()) != 0L) {
                this.majormsgaccount = null;
            }
            if (this.majormsgaccount == null) {
                MsgAccount majormsgaccount = new MsgAccount();
                majormsgaccount.setMsgAccountId(this.getMajorMsgAccountId());
                MsgAccountService service = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class, this.getSessionFactory());
                service.autoGet(majormsgaccount);
                this.majormsgaccount = majormsgaccount;
            }
            return this.majormsgaccount;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public MsgAccount getMinorMsgAccount() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinorMsgAccount();
        }
        if (this.getMinorMsgAccountId() == null) {
            return null;
        }
        Integer n = this.objMinorMsgAccountLock;
        synchronized (n) {
            if (this.minormsgaccount != null && DataTypeHelper.compare(25, (Object)this.getMinorMsgAccountId(), (Object)this.minormsgaccount.getMsgAccountId()) != 0L) {
                this.minormsgaccount = null;
            }
            if (this.minormsgaccount == null) {
                MsgAccount minormsgaccount = new MsgAccount();
                minormsgaccount.setMsgAccountId(this.getMinorMsgAccountId());
                MsgAccountService service = (MsgAccountService)ServiceGlobal.getService(MsgAccountService.class, this.getSessionFactory());
                service.autoGet(minormsgaccount);
                this.minormsgaccount = minormsgaccount;
            }
            return this.minormsgaccount;
        }
    }

    private MsgAccountDetailBase getProxyEntity() {
        return this.proxyMsgAccountDetailBase;
    }

    @Override
    protected void onProxy(IDataObject proxyDataObject) {
        this.proxyMsgAccountDetailBase = null;
        if (proxyDataObject != null && proxyDataObject instanceof MsgAccountDetailBase) {
            this.proxyMsgAccountDetailBase = (MsgAccountDetailBase)proxyDataObject;
        }
        super.onProxy(proxyDataObject);
    }

    @Override
    protected IEntityActionHelper getActionHelper(boolean bMust) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bMust || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService("net.ibizsys.psrt.srv.common.service.MsgAccountDetailService", this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }
}

