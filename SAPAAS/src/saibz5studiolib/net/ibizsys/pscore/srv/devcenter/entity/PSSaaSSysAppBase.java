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
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.devcenter.entity.PSSaaSSysVer;
import net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysVerService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSaaSSysAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSaaSSysAppBase.class);
    public static final String FIELD_APPPKGNAME = "APPPKGNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSSAASSYSAPPID = "PSSAASSYSAPPID";
    public static final String FIELD_PSSAASSYSAPPNAME = "PSSAASSYSAPPNAME";
    public static final String FIELD_PSSAASSYSVERID = "PSSAASSYSVERID";
    public static final String FIELD_PSSAASSYSVERNAME = "PSSAASSYSVERNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_APPPKGNAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPTYPEID = 4;
    private static final int INDEX_PSAPPTYPENAME = 5;
    private static final int INDEX_PSSAASSYSAPPID = 6;
    private static final int INDEX_PSSAASSYSAPPNAME = 7;
    private static final int INDEX_PSSAASSYSVERID = 8;
    private static final int INDEX_PSSAASSYSVERNAME = 9;
    private static final int INDEX_PSSYSAPPID = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSaaSSysAppBase proxyPSSaaSSysAppBase = null;
    private boolean apppkgnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean pssaassysappidDirtyFlag = false;
    private boolean pssaassysappnameDirtyFlag = false;
    private boolean pssaassysveridDirtyFlag = false;
    private boolean pssaassysvernameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="apppkgname")
    private String apppkgname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
    @Column(name="pssaassysappid")
    private String pssaassysappid;
    @Column(name="pssaassysappname")
    private String pssaassysappname;
    @Column(name="pssaassysverid")
    private String pssaassysverid;
    @Column(name="pssaassysvername")
    private String pssaassysvername;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSSaaSSysVerLock = new Integer(1);
    private PSSaaSSysVer pssaassysver = null;

    public void setAppPKGName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppPKGName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apppkgname = string;
        this.apppkgnameDirtyFlag = true;
    }

    public String getAppPKGName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppPKGName();
        }
        return this.apppkgname;
    }

    public boolean isAppPKGNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppPKGNameDirty();
        }
        return this.apppkgnameDirtyFlag;
    }

    public void resetAppPKGName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppPKGName();
            return;
        }
        this.apppkgnameDirtyFlag = false;
        this.apppkgname = null;
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

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
    }

    public void setPSSaaSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappid = string;
        this.pssaassysappidDirtyFlag = true;
    }

    public String getPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppId();
        }
        return this.pssaassysappid;
    }

    public boolean isPSSaaSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppIdDirty();
        }
        return this.pssaassysappidDirtyFlag;
    }

    public void resetPSSaaSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppId();
            return;
        }
        this.pssaassysappidDirtyFlag = false;
        this.pssaassysappid = null;
    }

    public void setPSSaaSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysappname = string;
        this.pssaassysappnameDirtyFlag = true;
    }

    public String getPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysAppName();
        }
        return this.pssaassysappname;
    }

    public boolean isPSSaaSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysAppNameDirty();
        }
        return this.pssaassysappnameDirtyFlag;
    }

    public void resetPSSaaSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysAppName();
            return;
        }
        this.pssaassysappnameDirtyFlag = false;
        this.pssaassysappname = null;
    }

    public void setPSSaaSSysVerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysverid = string;
        this.pssaassysveridDirtyFlag = true;
    }

    public String getPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerId();
        }
        return this.pssaassysverid;
    }

    public boolean isPSSaaSSysVerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerIdDirty();
        }
        return this.pssaassysveridDirtyFlag;
    }

    public void resetPSSaaSSysVerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerId();
            return;
        }
        this.pssaassysveridDirtyFlag = false;
        this.pssaassysverid = null;
    }

    public void setPSSaaSSysVerName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSaaSSysVerName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssaassysvername = string;
        this.pssaassysvernameDirtyFlag = true;
    }

    public String getPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVerName();
        }
        return this.pssaassysvername;
    }

    public boolean isPSSaaSSysVerNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSaaSSysVerNameDirty();
        }
        return this.pssaassysvernameDirtyFlag;
    }

    public void resetPSSaaSSysVerName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSaaSSysVerName();
            return;
        }
        this.pssaassysvernameDirtyFlag = false;
        this.pssaassysvername = null;
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

    protected void onReset() {
        PSSaaSSysAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSaaSSysAppBase pSSaaSSysAppBase) {
        pSSaaSSysAppBase.resetAppPKGName();
        pSSaaSSysAppBase.resetCreateDate();
        pSSaaSSysAppBase.resetCreateMan();
        pSSaaSSysAppBase.resetMemo();
        pSSaaSSysAppBase.resetPSAppTypeId();
        pSSaaSSysAppBase.resetPSAppTypeName();
        pSSaaSSysAppBase.resetPSSaaSSysAppId();
        pSSaaSSysAppBase.resetPSSaaSSysAppName();
        pSSaaSSysAppBase.resetPSSaaSSysVerId();
        pSSaaSSysAppBase.resetPSSaaSSysVerName();
        pSSaaSSysAppBase.resetPSSysAppId();
        pSSaaSSysAppBase.resetUpdateDate();
        pSSaaSSysAppBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppPKGNameDirty()) {
            hashMap.put(FIELD_APPPKGNAME, this.getAppPKGName());
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
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
        }
        if (!bl || this.isPSSaaSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPID, this.getPSSaaSSysAppId());
        }
        if (!bl || this.isPSSaaSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSAPPNAME, this.getPSSaaSSysAppName());
        }
        if (!bl || this.isPSSaaSSysVerIdDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERID, this.getPSSaaSSysVerId());
        }
        if (!bl || this.isPSSaaSSysVerNameDirty()) {
            hashMap.put(FIELD_PSSAASSYSVERNAME, this.getPSSaaSSysVerName());
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
        return PSSaaSSysAppBase.get(this, n);
    }

    private static Object get(PSSaaSSysAppBase pSSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAppBase.getAppPKGName();
            }
            case 1: {
                return pSSaaSSysAppBase.getCreateDate();
            }
            case 2: {
                return pSSaaSSysAppBase.getCreateMan();
            }
            case 3: {
                return pSSaaSSysAppBase.getMemo();
            }
            case 4: {
                return pSSaaSSysAppBase.getPSAppTypeId();
            }
            case 5: {
                return pSSaaSSysAppBase.getPSAppTypeName();
            }
            case 6: {
                return pSSaaSSysAppBase.getPSSaaSSysAppId();
            }
            case 7: {
                return pSSaaSSysAppBase.getPSSaaSSysAppName();
            }
            case 8: {
                return pSSaaSSysAppBase.getPSSaaSSysVerId();
            }
            case 9: {
                return pSSaaSSysAppBase.getPSSaaSSysVerName();
            }
            case 10: {
                return pSSaaSSysAppBase.getPSSysAppId();
            }
            case 11: {
                return pSSaaSSysAppBase.getUpdateDate();
            }
            case 12: {
                return pSSaaSSysAppBase.getUpdateMan();
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
        PSSaaSSysAppBase.set(this, n, object);
    }

    private static void set(PSSaaSSysAppBase pSSaaSSysAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysAppBase.setAppPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSaaSSysAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSaaSSysAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSaaSSysAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSaaSSysAppBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSaaSSysAppBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSaaSSysAppBase.setPSSaaSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSaaSSysAppBase.setPSSaaSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSaaSSysAppBase.setPSSaaSSysVerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSaaSSysAppBase.setPSSaaSSysVerName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSaaSSysAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSaaSSysAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSaaSSysAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSaaSSysAppBase.isNull(this, n);
    }

    private static boolean isNull(PSSaaSSysAppBase pSSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAppBase.getAppPKGName() == null;
            }
            case 1: {
                return pSSaaSSysAppBase.getCreateDate() == null;
            }
            case 2: {
                return pSSaaSSysAppBase.getCreateMan() == null;
            }
            case 3: {
                return pSSaaSSysAppBase.getMemo() == null;
            }
            case 4: {
                return pSSaaSSysAppBase.getPSAppTypeId() == null;
            }
            case 5: {
                return pSSaaSSysAppBase.getPSAppTypeName() == null;
            }
            case 6: {
                return pSSaaSSysAppBase.getPSSaaSSysAppId() == null;
            }
            case 7: {
                return pSSaaSSysAppBase.getPSSaaSSysAppName() == null;
            }
            case 8: {
                return pSSaaSSysAppBase.getPSSaaSSysVerId() == null;
            }
            case 9: {
                return pSSaaSSysAppBase.getPSSaaSSysVerName() == null;
            }
            case 10: {
                return pSSaaSSysAppBase.getPSSysAppId() == null;
            }
            case 11: {
                return pSSaaSSysAppBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSaaSSysAppBase.getUpdateMan() == null;
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
        return PSSaaSSysAppBase.contains(this, n);
    }

    private static boolean contains(PSSaaSSysAppBase pSSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSaaSSysAppBase.isAppPKGNameDirty();
            }
            case 1: {
                return pSSaaSSysAppBase.isCreateDateDirty();
            }
            case 2: {
                return pSSaaSSysAppBase.isCreateManDirty();
            }
            case 3: {
                return pSSaaSSysAppBase.isMemoDirty();
            }
            case 4: {
                return pSSaaSSysAppBase.isPSAppTypeIdDirty();
            }
            case 5: {
                return pSSaaSSysAppBase.isPSAppTypeNameDirty();
            }
            case 6: {
                return pSSaaSSysAppBase.isPSSaaSSysAppIdDirty();
            }
            case 7: {
                return pSSaaSSysAppBase.isPSSaaSSysAppNameDirty();
            }
            case 8: {
                return pSSaaSSysAppBase.isPSSaaSSysVerIdDirty();
            }
            case 9: {
                return pSSaaSSysAppBase.isPSSaaSSysVerNameDirty();
            }
            case 10: {
                return pSSaaSSysAppBase.isPSSysAppIdDirty();
            }
            case 11: {
                return pSSaaSSysAppBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSaaSSysAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSaaSSysAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSaaSSysAppBase pSSaaSSysAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSaaSSysAppBase.getAppPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppkgname", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getAppPKGName()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappid", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSSaaSSysAppId()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysappname", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSSaaSSysAppName()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysVerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysverid", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSSaaSSysVerId()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysVerName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssaassysvername", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSSaaSSysVerName()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSaaSSysAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSaaSSysAppBase.getJSONValue((Object)pSSaaSSysAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSaaSSysAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSaaSSysAppBase pSSaaSSysAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSaaSSysAppBase.getAppPKGName() != null) {
            object = pSSaaSSysAppBase.getAppPKGName();
            xmlNode.setAttribute(FIELD_APPPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getCreateDate() != null) {
            object = pSSaaSSysAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysAppBase.getCreateMan() != null) {
            object = pSSaaSSysAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getMemo() != null) {
            object = pSSaaSSysAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSAppTypeId() != null) {
            object = pSSaaSSysAppBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSAppTypeName() != null) {
            object = pSSaaSSysAppBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysAppId() != null) {
            object = pSSaaSSysAppBase.getPSSaaSSysAppId();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysAppName() != null) {
            object = pSSaaSSysAppBase.getPSSaaSSysAppName();
            xmlNode.setAttribute(FIELD_PSSAASSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysVerId() != null) {
            object = pSSaaSSysAppBase.getPSSaaSSysVerId();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSSaaSSysVerName() != null) {
            object = pSSaaSSysAppBase.getPSSaaSSysVerName();
            xmlNode.setAttribute(FIELD_PSSAASSYSVERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getPSSysAppId() != null) {
            object = pSSaaSSysAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSaaSSysAppBase.getUpdateDate() != null) {
            object = pSSaaSSysAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSaaSSysAppBase.getUpdateMan() != null) {
            object = pSSaaSSysAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSaaSSysAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSaaSSysAppBase pSSaaSSysAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSaaSSysAppBase.isAppPKGNameDirty() && (bl || pSSaaSSysAppBase.getAppPKGName() != null)) {
            iDataObject.set(FIELD_APPPKGNAME, (Object)pSSaaSSysAppBase.getAppPKGName());
        }
        if (pSSaaSSysAppBase.isCreateDateDirty() && (bl || pSSaaSSysAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSaaSSysAppBase.getCreateDate());
        }
        if (pSSaaSSysAppBase.isCreateManDirty() && (bl || pSSaaSSysAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSaaSSysAppBase.getCreateMan());
        }
        if (pSSaaSSysAppBase.isMemoDirty() && (bl || pSSaaSSysAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSaaSSysAppBase.getMemo());
        }
        if (pSSaaSSysAppBase.isPSAppTypeIdDirty() && (bl || pSSaaSSysAppBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSSaaSSysAppBase.getPSAppTypeId());
        }
        if (pSSaaSSysAppBase.isPSAppTypeNameDirty() && (bl || pSSaaSSysAppBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSSaaSSysAppBase.getPSAppTypeName());
        }
        if (pSSaaSSysAppBase.isPSSaaSSysAppIdDirty() && (bl || pSSaaSSysAppBase.getPSSaaSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPID, (Object)pSSaaSSysAppBase.getPSSaaSSysAppId());
        }
        if (pSSaaSSysAppBase.isPSSaaSSysAppNameDirty() && (bl || pSSaaSSysAppBase.getPSSaaSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSAPPNAME, (Object)pSSaaSSysAppBase.getPSSaaSSysAppName());
        }
        if (pSSaaSSysAppBase.isPSSaaSSysVerIdDirty() && (bl || pSSaaSSysAppBase.getPSSaaSSysVerId() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERID, (Object)pSSaaSSysAppBase.getPSSaaSSysVerId());
        }
        if (pSSaaSSysAppBase.isPSSaaSSysVerNameDirty() && (bl || pSSaaSSysAppBase.getPSSaaSSysVerName() != null)) {
            iDataObject.set(FIELD_PSSAASSYSVERNAME, (Object)pSSaaSSysAppBase.getPSSaaSSysVerName());
        }
        if (pSSaaSSysAppBase.isPSSysAppIdDirty() && (bl || pSSaaSSysAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSaaSSysAppBase.getPSSysAppId());
        }
        if (pSSaaSSysAppBase.isUpdateDateDirty() && (bl || pSSaaSSysAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSaaSSysAppBase.getUpdateDate());
        }
        if (pSSaaSSysAppBase.isUpdateManDirty() && (bl || pSSaaSSysAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSaaSSysAppBase.getUpdateMan());
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
        return PSSaaSSysAppBase.remove(this, n);
    }

    private static boolean remove(PSSaaSSysAppBase pSSaaSSysAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSaaSSysAppBase.resetAppPKGName();
                return true;
            }
            case 1: {
                pSSaaSSysAppBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSaaSSysAppBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSaaSSysAppBase.resetMemo();
                return true;
            }
            case 4: {
                pSSaaSSysAppBase.resetPSAppTypeId();
                return true;
            }
            case 5: {
                pSSaaSSysAppBase.resetPSAppTypeName();
                return true;
            }
            case 6: {
                pSSaaSSysAppBase.resetPSSaaSSysAppId();
                return true;
            }
            case 7: {
                pSSaaSSysAppBase.resetPSSaaSSysAppName();
                return true;
            }
            case 8: {
                pSSaaSSysAppBase.resetPSSaaSSysVerId();
                return true;
            }
            case 9: {
                pSSaaSSysAppBase.resetPSSaaSSysVerName();
                return true;
            }
            case 10: {
                pSSaaSSysAppBase.resetPSSysAppId();
                return true;
            }
            case 11: {
                pSSaaSSysAppBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSaaSSysAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppType getPSAppType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppType();
        }
        if (this.getPSAppTypeId() == null) {
            return null;
        }
        Integer n = this.objPSAppTypeLock;
        synchronized (n) {
            if (this.psapptype != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTypeId(), (Object)this.psapptype.getPSAppTypeId()) != 0L) {
                this.psapptype = null;
            }
            if (this.psapptype == null) {
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(this.getPSAppTypeId());
                PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
                pSAppTypeService.autoGet((IEntity)pSAppType);
                this.psapptype = pSAppType;
            }
            return this.psapptype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSaaSSysVer getPSSaaSSysVer() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSaaSSysVer();
        }
        if (this.getPSSaaSSysVerId() == null) {
            return null;
        }
        Integer n = this.objPSSaaSSysVerLock;
        synchronized (n) {
            if (this.pssaassysver != null && DataTypeHelper.compare((int)25, (Object)this.getPSSaaSSysVerId(), (Object)this.pssaassysver.getPSSaaSSysVerId()) != 0L) {
                this.pssaassysver = null;
            }
            if (this.pssaassysver == null) {
                PSSaaSSysVer pSSaaSSysVer = new PSSaaSSysVer();
                pSSaaSSysVer.setPSSaaSSysVerId(this.getPSSaaSSysVerId());
                PSSaaSSysVerService pSSaaSSysVerService = (PSSaaSSysVerService)ServiceGlobal.getService(PSSaaSSysVerService.class, (SessionFactory)this.getSessionFactory());
                pSSaaSSysVerService.autoGet((IEntity)pSSaaSSysVer);
                this.pssaassysver = pSSaaSSysVer;
            }
            return this.pssaassysver;
        }
    }

    private PSSaaSSysAppBase getProxyEntity() {
        return this.proxyPSSaaSSysAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSaaSSysAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSSaaSSysAppBase) {
            this.proxyPSSaaSSysAppBase = (PSSaaSSysAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.devcenter.service.PSSaaSSysAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPPKGNAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 4);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 5);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPID, 6);
        fieldIndexMap.put(FIELD_PSSAASSYSAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSAASSYSVERID, 8);
        fieldIndexMap.put(FIELD_PSSAASSYSVERNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

