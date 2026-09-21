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
package net.ibizsys.pscore.srv.appdesign.entity;

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
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDERS;
import net.ibizsys.pscore.srv.appdesign.entity.PSAppDEView;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDERSService;
import net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDERSViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppDERSViewBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPDERSID = "PSAPPDERSID";
    public static final String FIELD_PSAPPDERSNAME = "PSAPPDERSNAME";
    public static final String FIELD_PSAPPDERSVIEWID = "PSAPPDERSVIEWID";
    public static final String FIELD_PSAPPDERSVIEWNAME = "PSAPPDERSVIEWNAME";
    public static final String FIELD_PSAPPDEVIEWID = "PSAPPDEVIEWID";
    public static final String FIELD_PSAPPDEVIEWNAME = "PSAPPDEVIEWNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPDERSID = 3;
    private static final int INDEX_PSAPPDERSNAME = 4;
    private static final int INDEX_PSAPPDERSVIEWID = 5;
    private static final int INDEX_PSAPPDERSVIEWNAME = 6;
    private static final int INDEX_PSAPPDEVIEWID = 7;
    private static final int INDEX_PSAPPDEVIEWNAME = 8;
    private static final int INDEX_PSSYSAPPID = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppDERSViewBase proxyPSAppDERSViewBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappdersidDirtyFlag = false;
    private boolean psappdersnameDirtyFlag = false;
    private boolean psappdersviewidDirtyFlag = false;
    private boolean psappdersviewnameDirtyFlag = false;
    private boolean psappdeviewidDirtyFlag = false;
    private boolean psappdeviewnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappdersid")
    private String psappdersid;
    @Column(name="psappdersname")
    private String psappdersname;
    @Column(name="psappdersviewid")
    private String psappdersviewid;
    @Column(name="psappdersviewname")
    private String psappdersviewname;
    @Column(name="psappdeviewid")
    private String psappdeviewid;
    @Column(name="psappdeviewname")
    private String psappdeviewname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSAppDERSLock = new Integer(1);
    private PSAppDERS psappders = null;
    private Integer objPSAppDEViewLock = new Integer(1);
    private PSAppDEView psappdeview = null;

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

    public void setPSAppDERSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersid = string;
        this.psappdersidDirtyFlag = true;
    }

    public String getPSAppDERSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSId();
        }
        return this.psappdersid;
    }

    public boolean isPSAppDERSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSIdDirty();
        }
        return this.psappdersidDirtyFlag;
    }

    public void resetPSAppDERSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSId();
            return;
        }
        this.psappdersidDirtyFlag = false;
        this.psappdersid = null;
    }

    public void setPSAppDERSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersname = string;
        this.psappdersnameDirtyFlag = true;
    }

    public String getPSAppDERSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSName();
        }
        return this.psappdersname;
    }

    public boolean isPSAppDERSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSNameDirty();
        }
        return this.psappdersnameDirtyFlag;
    }

    public void resetPSAppDERSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSName();
            return;
        }
        this.psappdersnameDirtyFlag = false;
        this.psappdersname = null;
    }

    public void setPSAppDERSViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersviewid = string;
        this.psappdersviewidDirtyFlag = true;
    }

    public String getPSAppDERSViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSViewId();
        }
        return this.psappdersviewid;
    }

    public boolean isPSAppDERSViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSViewIdDirty();
        }
        return this.psappdersviewidDirtyFlag;
    }

    public void resetPSAppDERSViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSViewId();
            return;
        }
        this.psappdersviewidDirtyFlag = false;
        this.psappdersviewid = null;
    }

    public void setPSAppDERSViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDERSViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdersviewname = string;
        this.psappdersviewnameDirtyFlag = true;
    }

    public String getPSAppDERSViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERSViewName();
        }
        return this.psappdersviewname;
    }

    public boolean isPSAppDERSViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDERSViewNameDirty();
        }
        return this.psappdersviewnameDirtyFlag;
    }

    public void resetPSAppDERSViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDERSViewName();
            return;
        }
        this.psappdersviewnameDirtyFlag = false;
        this.psappdersviewname = null;
    }

    public void setPSAppDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewid = string;
        this.psappdeviewidDirtyFlag = true;
    }

    public String getPSAppDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewId();
        }
        return this.psappdeviewid;
    }

    public boolean isPSAppDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewIdDirty();
        }
        return this.psappdeviewidDirtyFlag;
    }

    public void resetPSAppDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewId();
            return;
        }
        this.psappdeviewidDirtyFlag = false;
        this.psappdeviewid = null;
    }

    public void setPSAppDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewname = string;
        this.psappdeviewnameDirtyFlag = true;
    }

    public String getPSAppDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewName();
        }
        return this.psappdeviewname;
    }

    public boolean isPSAppDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewNameDirty();
        }
        return this.psappdeviewnameDirtyFlag;
    }

    public void resetPSAppDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewName();
            return;
        }
        this.psappdeviewnameDirtyFlag = false;
        this.psappdeviewname = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
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
        PSAppDERSViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppDERSViewBase pSAppDERSViewBase) {
        pSAppDERSViewBase.resetCreateDate();
        pSAppDERSViewBase.resetCreateMan();
        pSAppDERSViewBase.resetMemo();
        pSAppDERSViewBase.resetPSAppDERSId();
        pSAppDERSViewBase.resetPSAppDERSName();
        pSAppDERSViewBase.resetPSAppDERSViewId();
        pSAppDERSViewBase.resetPSAppDERSViewName();
        pSAppDERSViewBase.resetPSAppDEViewId();
        pSAppDERSViewBase.resetPSAppDEViewName();
        pSAppDERSViewBase.resetPSSysAppId();
        pSAppDERSViewBase.resetUpdateDate();
        pSAppDERSViewBase.resetUpdateMan();
        pSAppDERSViewBase.resetValidFlag();
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
        if (!bl || this.isPSAppDERSIdDirty()) {
            hashMap.put(FIELD_PSAPPDERSID, this.getPSAppDERSId());
        }
        if (!bl || this.isPSAppDERSNameDirty()) {
            hashMap.put(FIELD_PSAPPDERSNAME, this.getPSAppDERSName());
        }
        if (!bl || this.isPSAppDERSViewIdDirty()) {
            hashMap.put(FIELD_PSAPPDERSVIEWID, this.getPSAppDERSViewId());
        }
        if (!bl || this.isPSAppDERSViewNameDirty()) {
            hashMap.put(FIELD_PSAPPDERSVIEWNAME, this.getPSAppDERSViewName());
        }
        if (!bl || this.isPSAppDEViewIdDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWID, this.getPSAppDEViewId());
        }
        if (!bl || this.isPSAppDEViewNameDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWNAME, this.getPSAppDEViewName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
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
        return PSAppDERSViewBase.get(this, n);
    }

    private static Object get(PSAppDERSViewBase pSAppDERSViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSViewBase.getCreateDate();
            }
            case 1: {
                return pSAppDERSViewBase.getCreateMan();
            }
            case 2: {
                return pSAppDERSViewBase.getMemo();
            }
            case 3: {
                return pSAppDERSViewBase.getPSAppDERSId();
            }
            case 4: {
                return pSAppDERSViewBase.getPSAppDERSName();
            }
            case 5: {
                return pSAppDERSViewBase.getPSAppDERSViewId();
            }
            case 6: {
                return pSAppDERSViewBase.getPSAppDERSViewName();
            }
            case 7: {
                return pSAppDERSViewBase.getPSAppDEViewId();
            }
            case 8: {
                return pSAppDERSViewBase.getPSAppDEViewName();
            }
            case 9: {
                return pSAppDERSViewBase.getPSSysAppId();
            }
            case 10: {
                return pSAppDERSViewBase.getUpdateDate();
            }
            case 11: {
                return pSAppDERSViewBase.getUpdateMan();
            }
            case 12: {
                return pSAppDERSViewBase.getValidFlag();
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
        PSAppDERSViewBase.set(this, n, object);
    }

    private static void set(PSAppDERSViewBase pSAppDERSViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppDERSViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppDERSViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppDERSViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppDERSViewBase.setPSAppDERSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppDERSViewBase.setPSAppDERSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppDERSViewBase.setPSAppDERSViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppDERSViewBase.setPSAppDERSViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppDERSViewBase.setPSAppDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppDERSViewBase.setPSAppDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppDERSViewBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppDERSViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSAppDERSViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppDERSViewBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSAppDERSViewBase.isNull(this, n);
    }

    private static boolean isNull(PSAppDERSViewBase pSAppDERSViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSViewBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppDERSViewBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppDERSViewBase.getMemo() == null;
            }
            case 3: {
                return pSAppDERSViewBase.getPSAppDERSId() == null;
            }
            case 4: {
                return pSAppDERSViewBase.getPSAppDERSName() == null;
            }
            case 5: {
                return pSAppDERSViewBase.getPSAppDERSViewId() == null;
            }
            case 6: {
                return pSAppDERSViewBase.getPSAppDERSViewName() == null;
            }
            case 7: {
                return pSAppDERSViewBase.getPSAppDEViewId() == null;
            }
            case 8: {
                return pSAppDERSViewBase.getPSAppDEViewName() == null;
            }
            case 9: {
                return pSAppDERSViewBase.getPSSysAppId() == null;
            }
            case 10: {
                return pSAppDERSViewBase.getUpdateDate() == null;
            }
            case 11: {
                return pSAppDERSViewBase.getUpdateMan() == null;
            }
            case 12: {
                return pSAppDERSViewBase.getValidFlag() == null;
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
        return PSAppDERSViewBase.contains(this, n);
    }

    private static boolean contains(PSAppDERSViewBase pSAppDERSViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDERSViewBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppDERSViewBase.isCreateManDirty();
            }
            case 2: {
                return pSAppDERSViewBase.isMemoDirty();
            }
            case 3: {
                return pSAppDERSViewBase.isPSAppDERSIdDirty();
            }
            case 4: {
                return pSAppDERSViewBase.isPSAppDERSNameDirty();
            }
            case 5: {
                return pSAppDERSViewBase.isPSAppDERSViewIdDirty();
            }
            case 6: {
                return pSAppDERSViewBase.isPSAppDERSViewNameDirty();
            }
            case 7: {
                return pSAppDERSViewBase.isPSAppDEViewIdDirty();
            }
            case 8: {
                return pSAppDERSViewBase.isPSAppDEViewNameDirty();
            }
            case 9: {
                return pSAppDERSViewBase.isPSSysAppIdDirty();
            }
            case 10: {
                return pSAppDERSViewBase.isUpdateDateDirty();
            }
            case 11: {
                return pSAppDERSViewBase.isUpdateManDirty();
            }
            case 12: {
                return pSAppDERSViewBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppDERSViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppDERSViewBase pSAppDERSViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppDERSViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersid", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDERSId()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersname", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDERSName()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersviewid", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDERSViewId()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdersviewname", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDERSViewName()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewid", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDEViewId()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSAppDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewname", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSAppDEViewName()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppDERSViewBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSAppDERSViewBase.getJSONValue((Object)pSAppDERSViewBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppDERSViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppDERSViewBase pSAppDERSViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppDERSViewBase.getCreateDate() != null) {
            object = pSAppDERSViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDERSViewBase.getCreateMan() != null) {
            object = pSAppDERSViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getMemo() != null) {
            object = pSAppDERSViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSId() != null) {
            object = pSAppDERSViewBase.getPSAppDERSId();
            xmlNode.setAttribute(FIELD_PSAPPDERSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSName() != null) {
            object = pSAppDERSViewBase.getPSAppDERSName();
            xmlNode.setAttribute(FIELD_PSAPPDERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSViewId() != null) {
            object = pSAppDERSViewBase.getPSAppDERSViewId();
            xmlNode.setAttribute(FIELD_PSAPPDERSVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDERSViewName() != null) {
            object = pSAppDERSViewBase.getPSAppDERSViewName();
            xmlNode.setAttribute(FIELD_PSAPPDERSVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDEViewId() != null) {
            object = pSAppDERSViewBase.getPSAppDEViewId();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSAppDEViewName() != null) {
            object = pSAppDERSViewBase.getPSAppDEViewName();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getPSSysAppId() != null) {
            object = pSAppDERSViewBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getUpdateDate() != null) {
            object = pSAppDERSViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDERSViewBase.getUpdateMan() != null) {
            object = pSAppDERSViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDERSViewBase.getValidFlag() != null) {
            object = pSAppDERSViewBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppDERSViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppDERSViewBase pSAppDERSViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppDERSViewBase.isCreateDateDirty() && (bl || pSAppDERSViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppDERSViewBase.getCreateDate());
        }
        if (pSAppDERSViewBase.isCreateManDirty() && (bl || pSAppDERSViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppDERSViewBase.getCreateMan());
        }
        if (pSAppDERSViewBase.isMemoDirty() && (bl || pSAppDERSViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppDERSViewBase.getMemo());
        }
        if (pSAppDERSViewBase.isPSAppDERSIdDirty() && (bl || pSAppDERSViewBase.getPSAppDERSId() != null)) {
            iDataObject.set(FIELD_PSAPPDERSID, (Object)pSAppDERSViewBase.getPSAppDERSId());
        }
        if (pSAppDERSViewBase.isPSAppDERSNameDirty() && (bl || pSAppDERSViewBase.getPSAppDERSName() != null)) {
            iDataObject.set(FIELD_PSAPPDERSNAME, (Object)pSAppDERSViewBase.getPSAppDERSName());
        }
        if (pSAppDERSViewBase.isPSAppDERSViewIdDirty() && (bl || pSAppDERSViewBase.getPSAppDERSViewId() != null)) {
            iDataObject.set(FIELD_PSAPPDERSVIEWID, (Object)pSAppDERSViewBase.getPSAppDERSViewId());
        }
        if (pSAppDERSViewBase.isPSAppDERSViewNameDirty() && (bl || pSAppDERSViewBase.getPSAppDERSViewName() != null)) {
            iDataObject.set(FIELD_PSAPPDERSVIEWNAME, (Object)pSAppDERSViewBase.getPSAppDERSViewName());
        }
        if (pSAppDERSViewBase.isPSAppDEViewIdDirty() && (bl || pSAppDERSViewBase.getPSAppDEViewId() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWID, (Object)pSAppDERSViewBase.getPSAppDEViewId());
        }
        if (pSAppDERSViewBase.isPSAppDEViewNameDirty() && (bl || pSAppDERSViewBase.getPSAppDEViewName() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWNAME, (Object)pSAppDERSViewBase.getPSAppDEViewName());
        }
        if (pSAppDERSViewBase.isPSSysAppIdDirty() && (bl || pSAppDERSViewBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppDERSViewBase.getPSSysAppId());
        }
        if (pSAppDERSViewBase.isUpdateDateDirty() && (bl || pSAppDERSViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppDERSViewBase.getUpdateDate());
        }
        if (pSAppDERSViewBase.isUpdateManDirty() && (bl || pSAppDERSViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppDERSViewBase.getUpdateMan());
        }
        if (pSAppDERSViewBase.isValidFlagDirty() && (bl || pSAppDERSViewBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSAppDERSViewBase.getValidFlag());
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
        return PSAppDERSViewBase.remove(this, n);
    }

    private static boolean remove(PSAppDERSViewBase pSAppDERSViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppDERSViewBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppDERSViewBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppDERSViewBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppDERSViewBase.resetPSAppDERSId();
                return true;
            }
            case 4: {
                pSAppDERSViewBase.resetPSAppDERSName();
                return true;
            }
            case 5: {
                pSAppDERSViewBase.resetPSAppDERSViewId();
                return true;
            }
            case 6: {
                pSAppDERSViewBase.resetPSAppDERSViewName();
                return true;
            }
            case 7: {
                pSAppDERSViewBase.resetPSAppDEViewId();
                return true;
            }
            case 8: {
                pSAppDERSViewBase.resetPSAppDEViewName();
                return true;
            }
            case 9: {
                pSAppDERSViewBase.resetPSSysAppId();
                return true;
            }
            case 10: {
                pSAppDERSViewBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSAppDERSViewBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSAppDERSViewBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppDERS getPSAppDERS() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDERS();
        }
        if (this.getPSAppDERSId() == null) {
            return null;
        }
        Integer n = this.objPSAppDERSLock;
        synchronized (n) {
            if (this.psappders != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppDERSId(), (Object)this.psappders.getPSAppDERSId()) != 0L) {
                this.psappders = null;
            }
            if (this.psappders == null) {
                PSAppDERS pSAppDERS = new PSAppDERS();
                pSAppDERS.setPSAppDERSId(this.getPSAppDERSId());
                PSAppDERSService pSAppDERSService = (PSAppDERSService)ServiceGlobal.getService(PSAppDERSService.class, (SessionFactory)this.getSessionFactory());
                pSAppDERSService.autoGet((IEntity)pSAppDERS);
                this.psappders = pSAppDERS;
            }
            return this.psappders;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppDEView getPSAppDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEView();
        }
        if (this.getPSAppDEViewId() == null) {
            return null;
        }
        Integer n = this.objPSAppDEViewLock;
        synchronized (n) {
            if (this.psappdeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppDEViewId(), (Object)this.psappdeview.getPSAppDEViewId()) != 0L) {
                this.psappdeview = null;
            }
            if (this.psappdeview == null) {
                PSAppDEView pSAppDEView = new PSAppDEView();
                pSAppDEView.setPSAppDEViewId(this.getPSAppDEViewId());
                PSAppDEViewService pSAppDEViewService = (PSAppDEViewService)ServiceGlobal.getService(PSAppDEViewService.class, (SessionFactory)this.getSessionFactory());
                pSAppDEViewService.autoGet((IEntity)pSAppDEView);
                this.psappdeview = pSAppDEView;
            }
            return this.psappdeview;
        }
    }

    private PSAppDERSViewBase getProxyEntity() {
        return this.proxyPSAppDERSViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppDERSViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppDERSViewBase) {
            this.proxyPSAppDERSViewBase = (PSAppDERSViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDERSViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPDERSID, 3);
        fieldIndexMap.put(FIELD_PSAPPDERSNAME, 4);
        fieldIndexMap.put(FIELD_PSAPPDERSVIEWID, 5);
        fieldIndexMap.put(FIELD_PSAPPDERSVIEWNAME, 6);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWID, 7);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

