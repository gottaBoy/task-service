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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFUtilUIAction;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFUtilUIActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysWFSettingBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysWFSettingBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PSSYSWFSETTINGID = "PSSYSWFSETTINGID";
    public static final String FIELD_PSSYSWFSETTINGNAME = "PSSYSWFSETTINGNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSSYSMSGTEMPLID = 4;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 5;
    private static final int INDEX_PSSYSTEMID = 6;
    private static final int INDEX_PSSYSTEMNAME = 7;
    private static final int INDEX_PSSYSWFSETTINGID = 8;
    private static final int INDEX_PSSYSWFSETTINGNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_USERPARAMS = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysWFSettingBase proxyPSSysWFSettingBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean pssyswfsettingidDirtyFlag = false;
    private boolean pssyswfsettingnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="pssyswfsettingid")
    private String pssyswfsettingid;
    @Column(name="pssyswfsettingname")
    private String pssyswfsettingname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSWFUtilUIActionsLock = new Integer(1);
    private ArrayList<PSWFUtilUIAction> pswfutiluiactions = null;

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
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

    public void setPSSysWFSettingId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFSettingId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfsettingid = string;
        this.pssyswfsettingidDirtyFlag = true;
    }

    public String getPSSysWFSettingId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFSettingId();
        }
        return this.pssyswfsettingid;
    }

    public boolean isPSSysWFSettingIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFSettingIdDirty();
        }
        return this.pssyswfsettingidDirtyFlag;
    }

    public void resetPSSysWFSettingId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFSettingId();
            return;
        }
        this.pssyswfsettingidDirtyFlag = false;
        this.pssyswfsettingid = null;
    }

    public void setPSSysWFSettingName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysWFSettingName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyswfsettingname = string;
        this.pssyswfsettingnameDirtyFlag = true;
    }

    public String getPSSysWFSettingName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysWFSettingName();
        }
        return this.pssyswfsettingname;
    }

    public boolean isPSSysWFSettingNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysWFSettingNameDirty();
        }
        return this.pssyswfsettingnameDirtyFlag;
    }

    public void resetPSSysWFSettingName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysWFSettingName();
            return;
        }
        this.pssyswfsettingnameDirtyFlag = false;
        this.pssyswfsettingname = null;
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

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
    }

    protected void onReset() {
        PSSysWFSettingBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysWFSettingBase pSSysWFSettingBase) {
        pSSysWFSettingBase.resetCodeName();
        pSSysWFSettingBase.resetCreateDate();
        pSSysWFSettingBase.resetCreateMan();
        pSSysWFSettingBase.resetMemo();
        pSSysWFSettingBase.resetPSSysMsgTemplId();
        pSSysWFSettingBase.resetPSSysMsgTemplName();
        pSSysWFSettingBase.resetPSSystemId();
        pSSysWFSettingBase.resetPSSystemName();
        pSSysWFSettingBase.resetPSSysWFSettingId();
        pSSysWFSettingBase.resetPSSysWFSettingName();
        pSSysWFSettingBase.resetUpdateDate();
        pSSysWFSettingBase.resetUpdateMan();
        pSSysWFSettingBase.resetUserParams();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPSSysWFSettingIdDirty()) {
            hashMap.put(FIELD_PSSYSWFSETTINGID, this.getPSSysWFSettingId());
        }
        if (!bl || this.isPSSysWFSettingNameDirty()) {
            hashMap.put(FIELD_PSSYSWFSETTINGNAME, this.getPSSysWFSettingName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSSysWFSettingBase.get(this, n);
    }

    private static Object get(PSSysWFSettingBase pSSysWFSettingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFSettingBase.getCodeName();
            }
            case 1: {
                return pSSysWFSettingBase.getCreateDate();
            }
            case 2: {
                return pSSysWFSettingBase.getCreateMan();
            }
            case 3: {
                return pSSysWFSettingBase.getMemo();
            }
            case 4: {
                return pSSysWFSettingBase.getPSSysMsgTemplId();
            }
            case 5: {
                return pSSysWFSettingBase.getPSSysMsgTemplName();
            }
            case 6: {
                return pSSysWFSettingBase.getPSSystemId();
            }
            case 7: {
                return pSSysWFSettingBase.getPSSystemName();
            }
            case 8: {
                return pSSysWFSettingBase.getPSSysWFSettingId();
            }
            case 9: {
                return pSSysWFSettingBase.getPSSysWFSettingName();
            }
            case 10: {
                return pSSysWFSettingBase.getUpdateDate();
            }
            case 11: {
                return pSSysWFSettingBase.getUpdateMan();
            }
            case 12: {
                return pSSysWFSettingBase.getUserParams();
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
        PSSysWFSettingBase.set(this, n, object);
    }

    private static void set(PSSysWFSettingBase pSSysWFSettingBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFSettingBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysWFSettingBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysWFSettingBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysWFSettingBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysWFSettingBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysWFSettingBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysWFSettingBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysWFSettingBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysWFSettingBase.setPSSysWFSettingId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysWFSettingBase.setPSSysWFSettingName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysWFSettingBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSSysWFSettingBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysWFSettingBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSSysWFSettingBase.isNull(this, n);
    }

    private static boolean isNull(PSSysWFSettingBase pSSysWFSettingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFSettingBase.getCodeName() == null;
            }
            case 1: {
                return pSSysWFSettingBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysWFSettingBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysWFSettingBase.getMemo() == null;
            }
            case 4: {
                return pSSysWFSettingBase.getPSSysMsgTemplId() == null;
            }
            case 5: {
                return pSSysWFSettingBase.getPSSysMsgTemplName() == null;
            }
            case 6: {
                return pSSysWFSettingBase.getPSSystemId() == null;
            }
            case 7: {
                return pSSysWFSettingBase.getPSSystemName() == null;
            }
            case 8: {
                return pSSysWFSettingBase.getPSSysWFSettingId() == null;
            }
            case 9: {
                return pSSysWFSettingBase.getPSSysWFSettingName() == null;
            }
            case 10: {
                return pSSysWFSettingBase.getUpdateDate() == null;
            }
            case 11: {
                return pSSysWFSettingBase.getUpdateMan() == null;
            }
            case 12: {
                return pSSysWFSettingBase.getUserParams() == null;
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
        return PSSysWFSettingBase.contains(this, n);
    }

    private static boolean contains(PSSysWFSettingBase pSSysWFSettingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysWFSettingBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysWFSettingBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysWFSettingBase.isCreateManDirty();
            }
            case 3: {
                return pSSysWFSettingBase.isMemoDirty();
            }
            case 4: {
                return pSSysWFSettingBase.isPSSysMsgTemplIdDirty();
            }
            case 5: {
                return pSSysWFSettingBase.isPSSysMsgTemplNameDirty();
            }
            case 6: {
                return pSSysWFSettingBase.isPSSystemIdDirty();
            }
            case 7: {
                return pSSysWFSettingBase.isPSSystemNameDirty();
            }
            case 8: {
                return pSSysWFSettingBase.isPSSysWFSettingIdDirty();
            }
            case 9: {
                return pSSysWFSettingBase.isPSSysWFSettingNameDirty();
            }
            case 10: {
                return pSSysWFSettingBase.isUpdateDateDirty();
            }
            case 11: {
                return pSSysWFSettingBase.isUpdateManDirty();
            }
            case 12: {
                return pSSysWFSettingBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysWFSettingBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysWFSettingBase pSSysWFSettingBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysWFSettingBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSysWFSettingId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfsettingid", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSysWFSettingId()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getPSSysWFSettingName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyswfsettingname", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getPSSysWFSettingName()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysWFSettingBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSSysWFSettingBase.getJSONValue((Object)pSSysWFSettingBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysWFSettingBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysWFSettingBase pSSysWFSettingBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysWFSettingBase.getCodeName() != null) {
            object = pSSysWFSettingBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getCreateDate() != null) {
            object = pSSysWFSettingBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFSettingBase.getCreateMan() != null) {
            object = pSSysWFSettingBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getMemo() != null) {
            object = pSSysWFSettingBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSysMsgTemplId() != null) {
            object = pSSysWFSettingBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSysMsgTemplName() != null) {
            object = pSSysWFSettingBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSystemId() != null) {
            object = pSSysWFSettingBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSystemName() != null) {
            object = pSSysWFSettingBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSysWFSettingId() != null) {
            object = pSSysWFSettingBase.getPSSysWFSettingId();
            xmlNode.setAttribute(FIELD_PSSYSWFSETTINGID, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getPSSysWFSettingName() != null) {
            object = pSSysWFSettingBase.getPSSysWFSettingName();
            xmlNode.setAttribute(FIELD_PSSYSWFSETTINGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getUpdateDate() != null) {
            object = pSSysWFSettingBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysWFSettingBase.getUpdateMan() != null) {
            object = pSSysWFSettingBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysWFSettingBase.getUserParams() != null) {
            object = pSSysWFSettingBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysWFSettingBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysWFSettingBase pSSysWFSettingBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysWFSettingBase.isCodeNameDirty() && (bl || pSSysWFSettingBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysWFSettingBase.getCodeName());
        }
        if (pSSysWFSettingBase.isCreateDateDirty() && (bl || pSSysWFSettingBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysWFSettingBase.getCreateDate());
        }
        if (pSSysWFSettingBase.isCreateManDirty() && (bl || pSSysWFSettingBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysWFSettingBase.getCreateMan());
        }
        if (pSSysWFSettingBase.isMemoDirty() && (bl || pSSysWFSettingBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysWFSettingBase.getMemo());
        }
        if (pSSysWFSettingBase.isPSSysMsgTemplIdDirty() && (bl || pSSysWFSettingBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSSysWFSettingBase.getPSSysMsgTemplId());
        }
        if (pSSysWFSettingBase.isPSSysMsgTemplNameDirty() && (bl || pSSysWFSettingBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSSysWFSettingBase.getPSSysMsgTemplName());
        }
        if (pSSysWFSettingBase.isPSSystemIdDirty() && (bl || pSSysWFSettingBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysWFSettingBase.getPSSystemId());
        }
        if (pSSysWFSettingBase.isPSSystemNameDirty() && (bl || pSSysWFSettingBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysWFSettingBase.getPSSystemName());
        }
        if (pSSysWFSettingBase.isPSSysWFSettingIdDirty() && (bl || pSSysWFSettingBase.getPSSysWFSettingId() != null)) {
            iDataObject.set(FIELD_PSSYSWFSETTINGID, (Object)pSSysWFSettingBase.getPSSysWFSettingId());
        }
        if (pSSysWFSettingBase.isPSSysWFSettingNameDirty() && (bl || pSSysWFSettingBase.getPSSysWFSettingName() != null)) {
            iDataObject.set(FIELD_PSSYSWFSETTINGNAME, (Object)pSSysWFSettingBase.getPSSysWFSettingName());
        }
        if (pSSysWFSettingBase.isUpdateDateDirty() && (bl || pSSysWFSettingBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysWFSettingBase.getUpdateDate());
        }
        if (pSSysWFSettingBase.isUpdateManDirty() && (bl || pSSysWFSettingBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysWFSettingBase.getUpdateMan());
        }
        if (pSSysWFSettingBase.isUserParamsDirty() && (bl || pSSysWFSettingBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSSysWFSettingBase.getUserParams());
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
        return PSSysWFSettingBase.remove(this, n);
    }

    private static boolean remove(PSSysWFSettingBase pSSysWFSettingBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysWFSettingBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysWFSettingBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysWFSettingBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysWFSettingBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysWFSettingBase.resetPSSysMsgTemplId();
                return true;
            }
            case 5: {
                pSSysWFSettingBase.resetPSSysMsgTemplName();
                return true;
            }
            case 6: {
                pSSysWFSettingBase.resetPSSystemId();
                return true;
            }
            case 7: {
                pSSysWFSettingBase.resetPSSystemName();
                return true;
            }
            case 8: {
                pSSysWFSettingBase.resetPSSysWFSettingId();
                return true;
            }
            case 9: {
                pSSysWFSettingBase.resetPSSysWFSettingName();
                return true;
            }
            case 10: {
                pSSysWFSettingBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSSysWFSettingBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSSysWFSettingBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
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
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFUtilUIAction> getPSWFUtilUIActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFUtilUIActions();
        }
        if (this.getPSSysWFSettingId() == null) {
            return null;
        }
        PSWFUtilUIActionService pSWFUtilUIActionService = (PSWFUtilUIActionService)ServiceGlobal.getService(PSWFUtilUIActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFUtilUIActionsLock;
        synchronized (n) {
            if (this.pswfutiluiactions == null) {
                this.pswfutiluiactions = pSWFUtilUIActionService.selectByPSSysWFSetting(this);
            }
            return this.pswfutiluiactions;
        }
    }

    private PSSysWFSettingBase getProxyEntity() {
        return this.proxyPSSysWFSettingBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysWFSettingBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysWFSettingBase) {
            this.proxyPSSysWFSettingBase = (PSSysWFSettingBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSSysWFSettingService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 4);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 6);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSWFSETTINGID, 8);
        fieldIndexMap.put(FIELD_PSSYSWFSETTINGNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_USERPARAMS, 12);
    }
}

