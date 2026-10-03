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
import net.ibizsys.pscore.srv.config.entity.PSCtrlType;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppCtrlStyleBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppCtrlStyleBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPCTRLSTYLEID = "PSAPPCTRLSTYLEID";
    public static final String FIELD_PSAPPCTRLSTYLENAME = "PSAPPCTRLSTYLENAME";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPCTRLSTYLEID = 3;
    private static final int INDEX_PSAPPCTRLSTYLENAME = 4;
    private static final int INDEX_PSCTRLTYPEID = 5;
    private static final int INDEX_PSCTRLTYPENAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final int INDEX_USERPARAMS = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppCtrlStyleBase proxyPSAppCtrlStyleBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappctrlstyleidDirtyFlag = false;
    private boolean psappctrlstylenameDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappctrlstyleid")
    private String psappctrlstyleid;
    @Column(name="psappctrlstylename")
    private String psappctrlstylename;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="userparams")
    private String userparams;
    private Integer objPSCtrlTypeLock = new Integer(1);
    private PSCtrlType psctrltype = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;

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

    public void setPSAppCtrlStyleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppCtrlStyleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappctrlstyleid = string;
        this.psappctrlstyleidDirtyFlag = true;
    }

    public String getPSAppCtrlStyleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppCtrlStyleId();
        }
        return this.psappctrlstyleid;
    }

    public boolean isPSAppCtrlStyleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppCtrlStyleIdDirty();
        }
        return this.psappctrlstyleidDirtyFlag;
    }

    public void resetPSAppCtrlStyleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppCtrlStyleId();
            return;
        }
        this.psappctrlstyleidDirtyFlag = false;
        this.psappctrlstyleid = null;
    }

    public void setPSAppCtrlStyleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppCtrlStyleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappctrlstylename = string;
        this.psappctrlstylenameDirtyFlag = true;
    }

    public String getPSAppCtrlStyleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppCtrlStyleName();
        }
        return this.psappctrlstylename;
    }

    public boolean isPSAppCtrlStyleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppCtrlStyleNameDirty();
        }
        return this.psappctrlstylenameDirtyFlag;
    }

    public void resetPSAppCtrlStyleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppCtrlStyleName();
            return;
        }
        this.psappctrlstylenameDirtyFlag = false;
        this.psappctrlstylename = null;
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

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
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
        PSAppCtrlStyleBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppCtrlStyleBase pSAppCtrlStyleBase) {
        pSAppCtrlStyleBase.resetCreateDate();
        pSAppCtrlStyleBase.resetCreateMan();
        pSAppCtrlStyleBase.resetMemo();
        pSAppCtrlStyleBase.resetPSAppCtrlStyleId();
        pSAppCtrlStyleBase.resetPSAppCtrlStyleName();
        pSAppCtrlStyleBase.resetPSCtrlTypeId();
        pSAppCtrlStyleBase.resetPSCtrlTypeName();
        pSAppCtrlStyleBase.resetPSSysAppId();
        pSAppCtrlStyleBase.resetPSSysAppName();
        pSAppCtrlStyleBase.resetUpdateDate();
        pSAppCtrlStyleBase.resetUpdateMan();
        pSAppCtrlStyleBase.resetUserParams();
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
        if (!bl || this.isPSAppCtrlStyleIdDirty()) {
            hashMap.put(FIELD_PSAPPCTRLSTYLEID, this.getPSAppCtrlStyleId());
        }
        if (!bl || this.isPSAppCtrlStyleNameDirty()) {
            hashMap.put(FIELD_PSAPPCTRLSTYLENAME, this.getPSAppCtrlStyleName());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSAppCtrlStyleBase.get(this, n);
    }

    private static Object get(PSAppCtrlStyleBase pSAppCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppCtrlStyleBase.getCreateDate();
            }
            case 1: {
                return pSAppCtrlStyleBase.getCreateMan();
            }
            case 2: {
                return pSAppCtrlStyleBase.getMemo();
            }
            case 3: {
                return pSAppCtrlStyleBase.getPSAppCtrlStyleId();
            }
            case 4: {
                return pSAppCtrlStyleBase.getPSAppCtrlStyleName();
            }
            case 5: {
                return pSAppCtrlStyleBase.getPSCtrlTypeId();
            }
            case 6: {
                return pSAppCtrlStyleBase.getPSCtrlTypeName();
            }
            case 7: {
                return pSAppCtrlStyleBase.getPSSysAppId();
            }
            case 8: {
                return pSAppCtrlStyleBase.getPSSysAppName();
            }
            case 9: {
                return pSAppCtrlStyleBase.getUpdateDate();
            }
            case 10: {
                return pSAppCtrlStyleBase.getUpdateMan();
            }
            case 11: {
                return pSAppCtrlStyleBase.getUserParams();
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
        PSAppCtrlStyleBase.set(this, n, object);
    }

    private static void set(PSAppCtrlStyleBase pSAppCtrlStyleBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppCtrlStyleBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppCtrlStyleBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppCtrlStyleBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppCtrlStyleBase.setPSAppCtrlStyleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppCtrlStyleBase.setPSAppCtrlStyleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppCtrlStyleBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppCtrlStyleBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppCtrlStyleBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppCtrlStyleBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppCtrlStyleBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSAppCtrlStyleBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppCtrlStyleBase.setUserParams(DataObject.getStringValue((Object)object));
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
        return PSAppCtrlStyleBase.isNull(this, n);
    }

    private static boolean isNull(PSAppCtrlStyleBase pSAppCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppCtrlStyleBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppCtrlStyleBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppCtrlStyleBase.getMemo() == null;
            }
            case 3: {
                return pSAppCtrlStyleBase.getPSAppCtrlStyleId() == null;
            }
            case 4: {
                return pSAppCtrlStyleBase.getPSAppCtrlStyleName() == null;
            }
            case 5: {
                return pSAppCtrlStyleBase.getPSCtrlTypeId() == null;
            }
            case 6: {
                return pSAppCtrlStyleBase.getPSCtrlTypeName() == null;
            }
            case 7: {
                return pSAppCtrlStyleBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppCtrlStyleBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppCtrlStyleBase.getUpdateDate() == null;
            }
            case 10: {
                return pSAppCtrlStyleBase.getUpdateMan() == null;
            }
            case 11: {
                return pSAppCtrlStyleBase.getUserParams() == null;
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
        return PSAppCtrlStyleBase.contains(this, n);
    }

    private static boolean contains(PSAppCtrlStyleBase pSAppCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppCtrlStyleBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppCtrlStyleBase.isCreateManDirty();
            }
            case 2: {
                return pSAppCtrlStyleBase.isMemoDirty();
            }
            case 3: {
                return pSAppCtrlStyleBase.isPSAppCtrlStyleIdDirty();
            }
            case 4: {
                return pSAppCtrlStyleBase.isPSAppCtrlStyleNameDirty();
            }
            case 5: {
                return pSAppCtrlStyleBase.isPSCtrlTypeIdDirty();
            }
            case 6: {
                return pSAppCtrlStyleBase.isPSCtrlTypeNameDirty();
            }
            case 7: {
                return pSAppCtrlStyleBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppCtrlStyleBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppCtrlStyleBase.isUpdateDateDirty();
            }
            case 10: {
                return pSAppCtrlStyleBase.isUpdateManDirty();
            }
            case 11: {
                return pSAppCtrlStyleBase.isUserParamsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppCtrlStyleBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppCtrlStyleBase pSAppCtrlStyleBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppCtrlStyleBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappctrlstyleid", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSAppCtrlStyleId()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappctrlstylename", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSAppCtrlStyleName()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSAppCtrlStyleBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSAppCtrlStyleBase.getJSONValue((Object)pSAppCtrlStyleBase.getUserParams()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppCtrlStyleBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppCtrlStyleBase pSAppCtrlStyleBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppCtrlStyleBase.getCreateDate() != null) {
            object = pSAppCtrlStyleBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppCtrlStyleBase.getCreateMan() != null) {
            object = pSAppCtrlStyleBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getMemo() != null) {
            object = pSAppCtrlStyleBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleId() != null) {
            object = pSAppCtrlStyleBase.getPSAppCtrlStyleId();
            xmlNode.setAttribute(FIELD_PSAPPCTRLSTYLEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleName() != null) {
            object = pSAppCtrlStyleBase.getPSAppCtrlStyleName();
            xmlNode.setAttribute(FIELD_PSAPPCTRLSTYLENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSCtrlTypeId() != null) {
            object = pSAppCtrlStyleBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSCtrlTypeName() != null) {
            object = pSAppCtrlStyleBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSSysAppId() != null) {
            object = pSAppCtrlStyleBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getPSSysAppName() != null) {
            object = pSAppCtrlStyleBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getUpdateDate() != null) {
            object = pSAppCtrlStyleBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppCtrlStyleBase.getUpdateMan() != null) {
            object = pSAppCtrlStyleBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppCtrlStyleBase.getUserParams() != null) {
            object = pSAppCtrlStyleBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppCtrlStyleBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppCtrlStyleBase pSAppCtrlStyleBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppCtrlStyleBase.isCreateDateDirty() && (bl || pSAppCtrlStyleBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppCtrlStyleBase.getCreateDate());
        }
        if (pSAppCtrlStyleBase.isCreateManDirty() && (bl || pSAppCtrlStyleBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppCtrlStyleBase.getCreateMan());
        }
        if (pSAppCtrlStyleBase.isMemoDirty() && (bl || pSAppCtrlStyleBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppCtrlStyleBase.getMemo());
        }
        if (pSAppCtrlStyleBase.isPSAppCtrlStyleIdDirty() && (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleId() != null)) {
            iDataObject.set(FIELD_PSAPPCTRLSTYLEID, (Object)pSAppCtrlStyleBase.getPSAppCtrlStyleId());
        }
        if (pSAppCtrlStyleBase.isPSAppCtrlStyleNameDirty() && (bl || pSAppCtrlStyleBase.getPSAppCtrlStyleName() != null)) {
            iDataObject.set(FIELD_PSAPPCTRLSTYLENAME, (Object)pSAppCtrlStyleBase.getPSAppCtrlStyleName());
        }
        if (pSAppCtrlStyleBase.isPSCtrlTypeIdDirty() && (bl || pSAppCtrlStyleBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSAppCtrlStyleBase.getPSCtrlTypeId());
        }
        if (pSAppCtrlStyleBase.isPSCtrlTypeNameDirty() && (bl || pSAppCtrlStyleBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSAppCtrlStyleBase.getPSCtrlTypeName());
        }
        if (pSAppCtrlStyleBase.isPSSysAppIdDirty() && (bl || pSAppCtrlStyleBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppCtrlStyleBase.getPSSysAppId());
        }
        if (pSAppCtrlStyleBase.isPSSysAppNameDirty() && (bl || pSAppCtrlStyleBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppCtrlStyleBase.getPSSysAppName());
        }
        if (pSAppCtrlStyleBase.isUpdateDateDirty() && (bl || pSAppCtrlStyleBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppCtrlStyleBase.getUpdateDate());
        }
        if (pSAppCtrlStyleBase.isUpdateManDirty() && (bl || pSAppCtrlStyleBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppCtrlStyleBase.getUpdateMan());
        }
        if (pSAppCtrlStyleBase.isUserParamsDirty() && (bl || pSAppCtrlStyleBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSAppCtrlStyleBase.getUserParams());
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
        return PSAppCtrlStyleBase.remove(this, n);
    }

    private static boolean remove(PSAppCtrlStyleBase pSAppCtrlStyleBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppCtrlStyleBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppCtrlStyleBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppCtrlStyleBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppCtrlStyleBase.resetPSAppCtrlStyleId();
                return true;
            }
            case 4: {
                pSAppCtrlStyleBase.resetPSAppCtrlStyleName();
                return true;
            }
            case 5: {
                pSAppCtrlStyleBase.resetPSCtrlTypeId();
                return true;
            }
            case 6: {
                pSAppCtrlStyleBase.resetPSCtrlTypeName();
                return true;
            }
            case 7: {
                pSAppCtrlStyleBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppCtrlStyleBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppCtrlStyleBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSAppCtrlStyleBase.resetUpdateMan();
                return true;
            }
            case 11: {
                pSAppCtrlStyleBase.resetUserParams();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSCtrlTypeService.autoGet(pSCtrlType);
                this.psctrltype = pSCtrlType;
            }
            return this.psctrltype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysApp getPSSysApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysApp();
        }
        if (this.getPSSysAppId() == null) {
            return null;
        }
        Integer n = this.objPSSysAppLock;
        synchronized (n) {
            if (this.pssysapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysAppId(), (Object)this.pssysapp.getPSSysAppId()) != 0L) {
                this.pssysapp = null;
            }
            if (this.pssysapp == null) {
                PSSysApp pSSysApp = new PSSysApp();
                pSSysApp.setPSSysAppId(this.getPSSysAppId());
                PSSysAppService pSSysAppService = (PSSysAppService)ServiceGlobal.getService(PSSysAppService.class, (SessionFactory)this.getSessionFactory());
                pSSysAppService.autoGet(pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    private PSAppCtrlStyleBase getProxyEntity() {
        return this.proxyPSAppCtrlStyleBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppCtrlStyleBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppCtrlStyleBase) {
            this.proxyPSAppCtrlStyleBase = (PSAppCtrlStyleBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppCtrlStyleService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPCTRLSTYLEID, 3);
        fieldIndexMap.put(FIELD_PSAPPCTRLSTYLENAME, 4);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 5);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
        fieldIndexMap.put(FIELD_USERPARAMS, 11);
    }
}

