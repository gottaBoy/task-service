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
import net.ibizsys.pscore.srv.config.entity.PSSubApp;
import net.ibizsys.pscore.srv.config.entity.PSSubSys;
import net.ibizsys.pscore.srv.config.service.PSSubAppService;
import net.ibizsys.pscore.srv.config.service.PSSubSysService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppSubAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppSubAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_FOLDERNAME = "FOLDERNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPSUBAPPID = "PSAPPSUBAPPID";
    public static final String FIELD_PSAPPSUBAPPNAME = "PSAPPSUBAPPNAME";
    public static final String FIELD_PSSUBAPPID = "PSSUBAPPID";
    public static final String FIELD_PSSUBAPPNAME = "PSSUBAPPNAME";
    public static final String FIELD_PSSUBSYSID = "PSSUBSYSID";
    public static final String FIELD_PSSUBSYSNAME = "PSSUBSYSNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_FOLDERNAME = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_PSAPPSUBAPPID = 4;
    private static final int INDEX_PSAPPSUBAPPNAME = 5;
    private static final int INDEX_PSSUBAPPID = 6;
    private static final int INDEX_PSSUBAPPNAME = 7;
    private static final int INDEX_PSSUBSYSID = 8;
    private static final int INDEX_PSSUBSYSNAME = 9;
    private static final int INDEX_PSSYSAPPID = 10;
    private static final int INDEX_PSSYSAPPNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppSubAppBase proxyPSAppSubAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean foldernameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappsubappidDirtyFlag = false;
    private boolean psappsubappnameDirtyFlag = false;
    private boolean pssubappidDirtyFlag = false;
    private boolean pssubappnameDirtyFlag = false;
    private boolean pssubsysidDirtyFlag = false;
    private boolean pssubsysnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="foldername")
    private String foldername;
    @Column(name="memo")
    private String memo;
    @Column(name="psappsubappid")
    private String psappsubappid;
    @Column(name="psappsubappname")
    private String psappsubappname;
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
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSubAppLock = new Integer(1);
    private PSSubApp pssubapp = null;
    private Integer objPSSubSysLock = new Integer(1);
    private PSSubSys pssubsys = null;
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

    public void setFolderName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFolderName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.foldername = string;
        this.foldernameDirtyFlag = true;
    }

    public String getFolderName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFolderName();
        }
        return this.foldername;
    }

    public boolean isFolderNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFolderNameDirty();
        }
        return this.foldernameDirtyFlag;
    }

    public void resetFolderName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFolderName();
            return;
        }
        this.foldernameDirtyFlag = false;
        this.foldername = null;
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

    public void setPSAppSubAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSubAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsubappid = string;
        this.psappsubappidDirtyFlag = true;
    }

    public String getPSAppSubAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSubAppId();
        }
        return this.psappsubappid;
    }

    public boolean isPSAppSubAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSubAppIdDirty();
        }
        return this.psappsubappidDirtyFlag;
    }

    public void resetPSAppSubAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSubAppId();
            return;
        }
        this.psappsubappidDirtyFlag = false;
        this.psappsubappid = null;
    }

    public void setPSAppSubAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppSubAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappsubappname = string;
        this.psappsubappnameDirtyFlag = true;
    }

    public String getPSAppSubAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppSubAppName();
        }
        return this.psappsubappname;
    }

    public boolean isPSAppSubAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppSubAppNameDirty();
        }
        return this.psappsubappnameDirtyFlag;
    }

    public void resetPSAppSubAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppSubAppName();
            return;
        }
        this.psappsubappnameDirtyFlag = false;
        this.psappsubappname = null;
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

    protected void onReset() {
        PSAppSubAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppSubAppBase pSAppSubAppBase) {
        pSAppSubAppBase.resetCreateDate();
        pSAppSubAppBase.resetCreateMan();
        pSAppSubAppBase.resetFolderName();
        pSAppSubAppBase.resetMemo();
        pSAppSubAppBase.resetPSAppSubAppId();
        pSAppSubAppBase.resetPSAppSubAppName();
        pSAppSubAppBase.resetPSSubAppId();
        pSAppSubAppBase.resetPSSubAppName();
        pSAppSubAppBase.resetPSSubSysId();
        pSAppSubAppBase.resetPSSubSysName();
        pSAppSubAppBase.resetPSSysAppId();
        pSAppSubAppBase.resetPSSysAppName();
        pSAppSubAppBase.resetUpdateDate();
        pSAppSubAppBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isFolderNameDirty()) {
            hashMap.put(FIELD_FOLDERNAME, this.getFolderName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppSubAppIdDirty()) {
            hashMap.put(FIELD_PSAPPSUBAPPID, this.getPSAppSubAppId());
        }
        if (!bl || this.isPSAppSubAppNameDirty()) {
            hashMap.put(FIELD_PSAPPSUBAPPNAME, this.getPSAppSubAppName());
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
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
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
        return PSAppSubAppBase.get(this, n);
    }

    private static Object get(PSAppSubAppBase pSAppSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSubAppBase.getCreateDate();
            }
            case 1: {
                return pSAppSubAppBase.getCreateMan();
            }
            case 2: {
                return pSAppSubAppBase.getFolderName();
            }
            case 3: {
                return pSAppSubAppBase.getMemo();
            }
            case 4: {
                return pSAppSubAppBase.getPSAppSubAppId();
            }
            case 5: {
                return pSAppSubAppBase.getPSAppSubAppName();
            }
            case 6: {
                return pSAppSubAppBase.getPSSubAppId();
            }
            case 7: {
                return pSAppSubAppBase.getPSSubAppName();
            }
            case 8: {
                return pSAppSubAppBase.getPSSubSysId();
            }
            case 9: {
                return pSAppSubAppBase.getPSSubSysName();
            }
            case 10: {
                return pSAppSubAppBase.getPSSysAppId();
            }
            case 11: {
                return pSAppSubAppBase.getPSSysAppName();
            }
            case 12: {
                return pSAppSubAppBase.getUpdateDate();
            }
            case 13: {
                return pSAppSubAppBase.getUpdateMan();
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
        PSAppSubAppBase.set(this, n, object);
    }

    private static void set(PSAppSubAppBase pSAppSubAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppSubAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppSubAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppSubAppBase.setFolderName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppSubAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppSubAppBase.setPSAppSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppSubAppBase.setPSAppSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppSubAppBase.setPSSubAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppSubAppBase.setPSSubAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppSubAppBase.setPSSubSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppSubAppBase.setPSSubSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSAppSubAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSAppSubAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSAppSubAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSAppSubAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppSubAppBase.isNull(this, n);
    }

    private static boolean isNull(PSAppSubAppBase pSAppSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSubAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppSubAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppSubAppBase.getFolderName() == null;
            }
            case 3: {
                return pSAppSubAppBase.getMemo() == null;
            }
            case 4: {
                return pSAppSubAppBase.getPSAppSubAppId() == null;
            }
            case 5: {
                return pSAppSubAppBase.getPSAppSubAppName() == null;
            }
            case 6: {
                return pSAppSubAppBase.getPSSubAppId() == null;
            }
            case 7: {
                return pSAppSubAppBase.getPSSubAppName() == null;
            }
            case 8: {
                return pSAppSubAppBase.getPSSubSysId() == null;
            }
            case 9: {
                return pSAppSubAppBase.getPSSubSysName() == null;
            }
            case 10: {
                return pSAppSubAppBase.getPSSysAppId() == null;
            }
            case 11: {
                return pSAppSubAppBase.getPSSysAppName() == null;
            }
            case 12: {
                return pSAppSubAppBase.getUpdateDate() == null;
            }
            case 13: {
                return pSAppSubAppBase.getUpdateMan() == null;
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
        return PSAppSubAppBase.contains(this, n);
    }

    private static boolean contains(PSAppSubAppBase pSAppSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppSubAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppSubAppBase.isCreateManDirty();
            }
            case 2: {
                return pSAppSubAppBase.isFolderNameDirty();
            }
            case 3: {
                return pSAppSubAppBase.isMemoDirty();
            }
            case 4: {
                return pSAppSubAppBase.isPSAppSubAppIdDirty();
            }
            case 5: {
                return pSAppSubAppBase.isPSAppSubAppNameDirty();
            }
            case 6: {
                return pSAppSubAppBase.isPSSubAppIdDirty();
            }
            case 7: {
                return pSAppSubAppBase.isPSSubAppNameDirty();
            }
            case 8: {
                return pSAppSubAppBase.isPSSubSysIdDirty();
            }
            case 9: {
                return pSAppSubAppBase.isPSSubSysNameDirty();
            }
            case 10: {
                return pSAppSubAppBase.isPSSysAppIdDirty();
            }
            case 11: {
                return pSAppSubAppBase.isPSSysAppNameDirty();
            }
            case 12: {
                return pSAppSubAppBase.isUpdateDateDirty();
            }
            case 13: {
                return pSAppSubAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppSubAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppSubAppBase pSAppSubAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppSubAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getFolderName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"foldername", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getFolderName()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSAppSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsubappid", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSAppSubAppId()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSAppSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappsubappname", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSAppSubAppName()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSubAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappid", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSubAppId()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSubAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubappname", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSubAppName()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSubSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysid", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSubSysId()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSubSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssubsysname", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSubSysName()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppSubAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppSubAppBase.getJSONValue((Object)pSAppSubAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppSubAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppSubAppBase pSAppSubAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppSubAppBase.getCreateDate() != null) {
            object = pSAppSubAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSubAppBase.getCreateMan() != null) {
            object = pSAppSubAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getFolderName() != null) {
            object = pSAppSubAppBase.getFolderName();
            xmlNode.setAttribute(FIELD_FOLDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getMemo() != null) {
            object = pSAppSubAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSAppSubAppId() != null) {
            object = pSAppSubAppBase.getPSAppSubAppId();
            xmlNode.setAttribute(FIELD_PSAPPSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSAppSubAppName() != null) {
            object = pSAppSubAppBase.getPSAppSubAppName();
            xmlNode.setAttribute(FIELD_PSAPPSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSubAppId() != null) {
            object = pSAppSubAppBase.getPSSubAppId();
            xmlNode.setAttribute(FIELD_PSSUBAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSubAppName() != null) {
            object = pSAppSubAppBase.getPSSubAppName();
            xmlNode.setAttribute(FIELD_PSSUBAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSubSysId() != null) {
            object = pSAppSubAppBase.getPSSubSysId();
            xmlNode.setAttribute(FIELD_PSSUBSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSubSysName() != null) {
            object = pSAppSubAppBase.getPSSubSysName();
            xmlNode.setAttribute(FIELD_PSSUBSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSysAppId() != null) {
            object = pSAppSubAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getPSSysAppName() != null) {
            object = pSAppSubAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppSubAppBase.getUpdateDate() != null) {
            object = pSAppSubAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppSubAppBase.getUpdateMan() != null) {
            object = pSAppSubAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppSubAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppSubAppBase pSAppSubAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppSubAppBase.isCreateDateDirty() && (bl || pSAppSubAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppSubAppBase.getCreateDate());
        }
        if (pSAppSubAppBase.isCreateManDirty() && (bl || pSAppSubAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppSubAppBase.getCreateMan());
        }
        if (pSAppSubAppBase.isFolderNameDirty() && (bl || pSAppSubAppBase.getFolderName() != null)) {
            iDataObject.set(FIELD_FOLDERNAME, (Object)pSAppSubAppBase.getFolderName());
        }
        if (pSAppSubAppBase.isMemoDirty() && (bl || pSAppSubAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppSubAppBase.getMemo());
        }
        if (pSAppSubAppBase.isPSAppSubAppIdDirty() && (bl || pSAppSubAppBase.getPSAppSubAppId() != null)) {
            iDataObject.set(FIELD_PSAPPSUBAPPID, (Object)pSAppSubAppBase.getPSAppSubAppId());
        }
        if (pSAppSubAppBase.isPSAppSubAppNameDirty() && (bl || pSAppSubAppBase.getPSAppSubAppName() != null)) {
            iDataObject.set(FIELD_PSAPPSUBAPPNAME, (Object)pSAppSubAppBase.getPSAppSubAppName());
        }
        if (pSAppSubAppBase.isPSSubAppIdDirty() && (bl || pSAppSubAppBase.getPSSubAppId() != null)) {
            iDataObject.set(FIELD_PSSUBAPPID, (Object)pSAppSubAppBase.getPSSubAppId());
        }
        if (pSAppSubAppBase.isPSSubAppNameDirty() && (bl || pSAppSubAppBase.getPSSubAppName() != null)) {
            iDataObject.set(FIELD_PSSUBAPPNAME, (Object)pSAppSubAppBase.getPSSubAppName());
        }
        if (pSAppSubAppBase.isPSSubSysIdDirty() && (bl || pSAppSubAppBase.getPSSubSysId() != null)) {
            iDataObject.set(FIELD_PSSUBSYSID, (Object)pSAppSubAppBase.getPSSubSysId());
        }
        if (pSAppSubAppBase.isPSSubSysNameDirty() && (bl || pSAppSubAppBase.getPSSubSysName() != null)) {
            iDataObject.set(FIELD_PSSUBSYSNAME, (Object)pSAppSubAppBase.getPSSubSysName());
        }
        if (pSAppSubAppBase.isPSSysAppIdDirty() && (bl || pSAppSubAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppSubAppBase.getPSSysAppId());
        }
        if (pSAppSubAppBase.isPSSysAppNameDirty() && (bl || pSAppSubAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppSubAppBase.getPSSysAppName());
        }
        if (pSAppSubAppBase.isUpdateDateDirty() && (bl || pSAppSubAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppSubAppBase.getUpdateDate());
        }
        if (pSAppSubAppBase.isUpdateManDirty() && (bl || pSAppSubAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppSubAppBase.getUpdateMan());
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
        return PSAppSubAppBase.remove(this, n);
    }

    private static boolean remove(PSAppSubAppBase pSAppSubAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppSubAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppSubAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppSubAppBase.resetFolderName();
                return true;
            }
            case 3: {
                pSAppSubAppBase.resetMemo();
                return true;
            }
            case 4: {
                pSAppSubAppBase.resetPSAppSubAppId();
                return true;
            }
            case 5: {
                pSAppSubAppBase.resetPSAppSubAppName();
                return true;
            }
            case 6: {
                pSAppSubAppBase.resetPSSubAppId();
                return true;
            }
            case 7: {
                pSAppSubAppBase.resetPSSubAppName();
                return true;
            }
            case 8: {
                pSAppSubAppBase.resetPSSubSysId();
                return true;
            }
            case 9: {
                pSAppSubAppBase.resetPSSubSysName();
                return true;
            }
            case 10: {
                pSAppSubAppBase.resetPSSysAppId();
                return true;
            }
            case 11: {
                pSAppSubAppBase.resetPSSysAppName();
                return true;
            }
            case 12: {
                pSAppSubAppBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSAppSubAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSubApp getPSSubApp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSubApp();
        }
        if (this.getPSSubAppId() == null) {
            return null;
        }
        Integer n = this.objPSSubAppLock;
        synchronized (n) {
            if (this.pssubapp != null && DataTypeHelper.compare((int)25, (Object)this.getPSSubAppId(), (Object)this.pssubapp.getPSSubAppId()) != 0L) {
                this.pssubapp = null;
            }
            if (this.pssubapp == null) {
                PSSubApp pSSubApp = new PSSubApp();
                pSSubApp.setPSSubAppId(this.getPSSubAppId());
                PSSubAppService pSSubAppService = (PSSubAppService)ServiceGlobal.getService(PSSubAppService.class, (SessionFactory)this.getSessionFactory());
                pSSubAppService.autoGet(pSSubApp);
                this.pssubapp = pSSubApp;
            }
            return this.pssubapp;
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

    private PSAppSubAppBase getProxyEntity() {
        return this.proxyPSAppSubAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppSubAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppSubAppBase) {
            this.proxyPSAppSubAppBase = (PSAppSubAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppSubAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_FOLDERNAME, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_PSAPPSUBAPPID, 4);
        fieldIndexMap.put(FIELD_PSAPPSUBAPPNAME, 5);
        fieldIndexMap.put(FIELD_PSSUBAPPID, 6);
        fieldIndexMap.put(FIELD_PSSUBAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSUBSYSID, 8);
        fieldIndexMap.put(FIELD_PSSUBSYSNAME, 9);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 10);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
    }
}

