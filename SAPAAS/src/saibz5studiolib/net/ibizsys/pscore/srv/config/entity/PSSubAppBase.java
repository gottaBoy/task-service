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
import net.ibizsys.pscore.srv.config.entity.PSPF;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSPFService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSubAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSubAppBase.class);
    public static final String FIELD_APPPKGNAME = "APPPKGNAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PSSUBAPPID = "PSSUBAPPID";
    public static final String FIELD_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VIEWMODELS = "VIEWMODELS";
    private static final int INDEX_APPPKGNAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSPFID = 4;
    private static final int INDEX_PSPFNAME = 5;
    private static final int INDEX_PSSUBAPPID = 6;
    private static final int INDEX_PSSUBAPPNAME = 7;
    private static final int INDEX_PSSUBSYSID = 8;
    private static final int INDEX_PSSUBSYSNAME = 9;
    private static final int INDEX_PSSYSAPPID = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VIEWMODELS = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSubAppBase proxyPSSubAppBase = null;
    private boolean apppkgnameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pssubappidDirtyFlag = false;
    private boolean pssubappnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean viewmodelsDirtyFlag = false;
    @Column(name="apppkgname")
    private String apppkgname;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pssubappid")
    private String pssubappid;
    @Column(name="pssubappname")
    private String pssubappname;
    @Column(name="pssubsysid")
    private String pssubsysid;
    @Column(name="pssubsysname")
    private String pssubsysname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="viewmodels")
    private String viewmodels;
    private Integer objPSPFLock = new Integer(1);
    private PSPF pspf = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;

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

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPSSubAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappid = string;
        this.pssubappidDirtyFlag = true;
    }

    public String getPSSubAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppId();
        }
        return this.pssubappid;
    }

    public boolean isPSSubAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppIdDirty();
        }
        return this.pssubappidDirtyFlag;
    }

    public void resetPSSubAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppId();
            return;
        }
        this.pssubappidDirtyFlag = false;
        this.pssubappid = null;
    }

    public void setPSSubAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubappname = string;
        this.pssubappnameDirtyFlag = true;
    }

    public String getPSSubAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubAppName();
        }
        return this.pssubappname;
    }

    public boolean isPSSubAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubAppNameDirty();
        }
        return this.pssubappnameDirtyFlag;
    }

    public void resetPSSubAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubAppName();
            return;
        }
        this.pssubappnameDirtyFlag = false;
        this.pssubappname = null;
    }

    public void setPSSubSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysid = string;
        this.pssubsysidDirtyFlag = true;
    }

    public String getPSSubSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysId();
        }
        return this.pssubsysid;
    }

    public boolean isPSSubSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysIdDirty();
        }
        return this.pssubsysidDirtyFlag;
    }

    public void resetPSSubSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysId();
            return;
        }
        this.pssubsysidDirtyFlag = false;
        this.pssubsysid = null;
    }

    public void setPSSubSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSubSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssubsysname = string;
        this.pssubsysnameDirtyFlag = true;
    }

    public String getPSSubSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSysName();
        }
        return this.pssubsysname;
    }

    public boolean isPSSubSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSubSysNameDirty();
        }
        return this.pssubsysnameDirtyFlag;
    }

    public void resetPSSubSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSubSysName();
            return;
        }
        this.pssubsysnameDirtyFlag = false;
        this.pssubsysname = null;
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

    public void setViewModels(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewModels(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewmodels = string;
        this.viewmodelsDirtyFlag = true;
    }

    public String getViewModels() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewModels();
        }
        return this.viewmodels;
    }

    public boolean isViewModelsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewModelsDirty();
        }
        return this.viewmodelsDirtyFlag;
    }

    public void resetViewModels() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewModels();
            return;
        }
        this.viewmodelsDirtyFlag = false;
        this.viewmodels = null;
    }

    protected void onReset() {
        PSSubAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSubAppBase pSSubAppBase) {
        pSSubAppBase.resetAppPKGName();
        pSSubAppBase.resetCreateDate();
        pSSubAppBase.resetCreateMan();
        pSSubAppBase.resetMemo();
        pSSubAppBase.resetPSPFId();
        pSSubAppBase.resetPSPFName();
        pSSubAppBase.resetPSSubAppId();
        pSSubAppBase.resetPSSubAppName();
        pSSubAppBase.resetPSSubSysId();
        pSSubAppBase.resetPSSubSysName();
        pSSubAppBase.resetPSSysAppId();
        pSSubAppBase.resetUpdateDate();
        pSSubAppBase.resetUpdateMan();
        pSSubAppBase.resetViewModels();
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
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPSSubAppIdDirty()) {
            hashMap.put(FIELD_PSSUBAPPID, this.getPSSubAppId());
        }
        if (!bl || this.isPSSubAppNameDirty()) {
            hashMap.put(FIELD_PSSUBAPPNAME, this.getPSSubAppName());
        }
        if (!bl || this.isPSSubSysIdDirty()) {
            hashMap.put(FIELD_PSSUBSYSID, this.getPSSubSysId());
        }
        if (!bl || this.isPSSubSysNameDirty()) {
            hashMap.put(FIELD_PSSUBSYSNAME, this.getPSSubSysName());
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
        if (!bl || this.isViewModelsDirty()) {
            hashMap.put(FIELD_VIEWMODELS, this.getViewModels());
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
        return PSSubAppBase.get(this, n);
    }

    private static Object get(PSSubAppBase pSSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppBase.getAppPKGName();
            }
            case 1: {
                return pSSubAppBase.getCreateDate();
            }
            case 2: {
                return pSSubAppBase.getCreateMan();
            }
            case 3: {
                return pSSubAppBase.getMemo();
            }
            case 4: {
                return pSSubAppBase.getPSPFId();
            }
            case 5: {
                return pSSubAppBase.getPSPFName();
            }
            case 6: {
                return pSSubAppBase.getPSSubAppId();
            }
            case 7: {
                return pSSubAppBase.getPSSubAppName();
            }
            case 8: {
                return pSSubAppBase.getPSSubSysId();
            }
            case 9: {
                return pSSubAppBase.getPSSubSysName();
            }
            case 10: {
                return pSSubAppBase.getPSSysAppId();
            }
            case 11: {
                return pSSubAppBase.getUpdateDate();
            }
            case 12: {
                return pSSubAppBase.getUpdateMan();
            }
            case 13: {
                return pSSubAppBase.getViewModels();
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
        PSSubAppBase.set(this, n, object);
    }

    private static void set(PSSubAppBase pSSubAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSubAppBase.setAppPKGName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSubAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSubAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSubAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSubAppBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSubAppBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSubAppBase.setPSSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSubAppBase.setPSSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSubAppBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSubAppBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSubAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSubAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSubAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSubAppBase.setViewModels(DataObject.getStringValue((Object)object));
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
        return PSSubAppBase.isNull(this, n);
    }

    private static boolean isNull(PSSubAppBase pSSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppBase.getAppPKGName() == null;
            }
            case 1: {
                return pSSubAppBase.getCreateDate() == null;
            }
            case 2: {
                return pSSubAppBase.getCreateMan() == null;
            }
            case 3: {
                return pSSubAppBase.getMemo() == null;
            }
            case 4: {
                return pSSubAppBase.getPSPFId() == null;
            }
            case 5: {
                return pSSubAppBase.getPSPFName() == null;
            }
            case 6: {
                return pSSubAppBase.getPSSubAppId() == null;
            }
            case 7: {
                return pSSubAppBase.getPSSubAppName() == null;
            }
            case 8: {
                return pSSubAppBase.getPSSubSysId() == null;
            }
            case 9: {
                return pSSubAppBase.getPSSubSysName() == null;
            }
            case 10: {
                return pSSubAppBase.getPSSysAppId() == null;
            }
            case 11: {
                return pSSubAppBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSubAppBase.getUpdateMan() == null;
            }
            case 13: {
                return pSSubAppBase.getViewModels() == null;
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
        return PSSubAppBase.contains(this, n);
    }

    private static boolean contains(PSSubAppBase pSSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSubAppBase.isAppPKGNameDirty();
            }
            case 1: {
                return pSSubAppBase.isCreateDateDirty();
            }
            case 2: {
                return pSSubAppBase.isCreateManDirty();
            }
            case 3: {
                return pSSubAppBase.isMemoDirty();
            }
            case 4: {
                return pSSubAppBase.isPSPFIdDirty();
            }
            case 5: {
                return pSSubAppBase.isPSPFNameDirty();
            }
            case 6: {
                return pSSubAppBase.isPSSubAppIdDirty();
            }
            case 7: {
                return pSSubAppBase.isPSSubAppNameDirty();
            }
            case 8: {
                return pSSubAppBase.isPSSubSysIdDirty();
            }
            case 9: {
                return pSSubAppBase.isPSSubSysNameDirty();
            }
            case 10: {
                return pSSubAppBase.isPSSysAppIdDirty();
            }
            case 11: {
                return pSSubAppBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSubAppBase.isUpdateManDirty();
            }
            case 13: {
                return pSSubAppBase.isViewModelsDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSubAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSubAppBase pSSubAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSubAppBase.getAppPKGName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppkgname", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getAppPKGName()), (boolean)false);
        }
        if (bl || pSSubAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSubAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSubAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappid", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSSubAppId()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappname", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSSubAppName()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSSubAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSubAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSubAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSubAppBase.getViewModels() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewmodels", (Object)PSSubAppBase.getJSONValue((Object)pSSubAppBase.getViewModels()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSubAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSubAppBase pSSubAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSubAppBase.getAppPKGName() != null) {
            object = pSSubAppBase.getAppPKGName();
            xmlNode.setAttribute(FIELD_APPPKGNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getCreateDate() != null) {
            object = pSSubAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubAppBase.getCreateMan() != null) {
            object = pSSubAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getMemo() != null) {
            object = pSSubAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSPFId() != null) {
            object = pSSubAppBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSPFName() != null) {
            object = pSSubAppBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSSubAppId() != null) {
            object = pSSubAppBase.getPSSubAppId();
            xmlNode.setAttribute(FIELD_PSSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSSubAppName() != null) {
            object = pSSubAppBase.getPSSubAppName();
            xmlNode.setAttribute(FIELD_PSSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSSubSysId() != null) {
            object = pSSubAppBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSSubSysName() != null) {
            object = pSSubAppBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getPSSysAppId() != null) {
            object = pSSubAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getUpdateDate() != null) {
            object = pSSubAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSubAppBase.getUpdateMan() != null) {
            object = pSSubAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSubAppBase.getViewModels() != null) {
            object = pSSubAppBase.getViewModels();
            xmlNode.setAttribute(FIELD_VIEWMODELS, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSubAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSubAppBase pSSubAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSubAppBase.isAppPKGNameDirty() && (bl || pSSubAppBase.getAppPKGName() != null)) {
            iDataObject.set(FIELD_APPPKGNAME, (Object)pSSubAppBase.getAppPKGName());
        }
        if (pSSubAppBase.isCreateDateDirty() && (bl || pSSubAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSubAppBase.getCreateDate());
        }
        if (pSSubAppBase.isCreateManDirty() && (bl || pSSubAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSubAppBase.getCreateMan());
        }
        if (pSSubAppBase.isMemoDirty() && (bl || pSSubAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSubAppBase.getMemo());
        }
        if (pSSubAppBase.isPSPFIdDirty() && (bl || pSSubAppBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSSubAppBase.getPSPFId());
        }
        if (pSSubAppBase.isPSPFNameDirty() && (bl || pSSubAppBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSSubAppBase.getPSPFName());
        }
        if (pSSubAppBase.isPSSubAppIdDirty() && (bl || pSSubAppBase.getPSSubAppId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPID, (Object)pSSubAppBase.getPSSubAppId());
        }
        if (pSSubAppBase.isPSSubAppNameDirty() && (bl || pSSubAppBase.getPSSubAppName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPNAME, (Object)pSSubAppBase.getPSSubAppName());
        }
        if (pSSubAppBase.isPSSubSysIdDirty() && (bl || pSSubAppBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSSubAppBase.getPSSubSysId());
        }
        if (pSSubAppBase.isPSSubSysNameDirty() && (bl || pSSubAppBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSSubAppBase.getPSSubSysName());
        }
        if (pSSubAppBase.isPSSysAppIdDirty() && (bl || pSSubAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSubAppBase.getPSSysAppId());
        }
        if (pSSubAppBase.isUpdateDateDirty() && (bl || pSSubAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSubAppBase.getUpdateDate());
        }
        if (pSSubAppBase.isUpdateManDirty() && (bl || pSSubAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSubAppBase.getUpdateMan());
        }
        if (pSSubAppBase.isViewModelsDirty() && (bl || pSSubAppBase.getViewModels() != null)) {
            iDataObject.set(FIELD_VIEWMODELS, (Object)pSSubAppBase.getViewModels());
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
        return PSSubAppBase.remove(this, n);
    }

    private static boolean remove(PSSubAppBase pSSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSubAppBase.resetAppPKGName();
                return true;
            }
            case 1: {
                pSSubAppBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSubAppBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSubAppBase.resetMemo();
                return true;
            }
            case 4: {
                pSSubAppBase.resetPSPFId();
                return true;
            }
            case 5: {
                pSSubAppBase.resetPSPFName();
                return true;
            }
            case 6: {
                pSSubAppBase.resetPSSubAppId();
                return true;
            }
            case 7: {
                pSSubAppBase.resetPSSubAppName();
                return true;
            }
            case 8: {
                pSSubAppBase.resetPSSubSysId();
                return true;
            }
            case 9: {
                pSSubAppBase.resetPSSubSysName();
                return true;
            }
            case 10: {
                pSSubAppBase.resetPSSysAppId();
                return true;
            }
            case 11: {
                pSSubAppBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSubAppBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSSubAppBase.resetViewModels();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPF getPSPF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPF();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        Integer n = this.objPSPFLock;
        synchronized (n) {
            if (this.pspf != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFId(), (Object)this.pspf.getPSPFId()) != 0L) {
                this.pspf = null;
            }
            if (this.pspf == null) {
                PSPF pSPF = new PSPF();
                pSPF.setPSPFId(this.getPSPFId());
                PSPFService pSPFService = (PSPFService)ServiceGlobal.getService(PSPFService.class, (SessionFactory)this.getSessionFactory());
                pSPFService.autoGet(pSPF);
                this.pspf = pSPF;
            }
            return this.pspf;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubSys getPSSubSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubSys();
        }
        if (this.getPSSubSysId() == null) {
            return null;
        }
        Integer n = this.objPSSubSysLock;
        synchronized (n) {
            if (this.pssubsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubSysId(), (Object)this.pssubsys.getPSSubSysId()) != 0L) {
                this.pssubsys = null;
            }
            if (this.pssubsys == null) {
                PSSubSys pSSubSys = new PSSubSys();
                pSSubSys.setPSSubSysId(this.getPSSubSysId());
                PSSubSysService pSSubSysService = (PSSubSysService)ServiceGlobal.getService(PSSubSysService.class, (SessionFactory)this.getSessionFactory());
                pSSubSysService.autoGet(pSSubSys);
                this.pssubsys = pSSubSys;
            }
            return this.pssubsys;
        }
    }

    private PSSubAppBase getProxyEntity() {
        return this.proxyPSSubAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSubAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSSubAppBase) {
            this.proxyPSSubAppBase = (PSSubAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSubAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPPKGNAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSPFID, 4);
        fieldIndexMap.put(FIELD_PSPFNAME, 5);
        fieldIndexMap.put(FIELD_PSSUBAPPID, 6);
        fieldIndexMap.put(FIELD_PSSUBAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 8);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VIEWMODELS, 13);
    }
}

