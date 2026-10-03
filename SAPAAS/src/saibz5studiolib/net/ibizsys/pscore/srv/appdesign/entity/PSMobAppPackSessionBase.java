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
import net.ibizsys.pscore.srv.appdesign.entity.PSMobAppPack;
import net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSMobAppPackSessionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSMobAppPackSessionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_PSMOBAPPPACKID = "PSMOBAPPPACKID";
    public static final String FIELD_PSMOBAPPPACKNAME = "PSMOBAPPPACKNAME";
    public static final String FIELD_PSMOBAPPPACKSESSIONID = "PSMOBAPPPACKSESSIONID";
    public static final String FIELD_PSMOBAPPPACKSESSIONNAME = "PSMOBAPPPACKSESSIONNAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_PSMOBAPPPACKID = 2;
    private static final int INDEX_PSMOBAPPPACKNAME = 3;
    private static final int INDEX_PSMOBAPPPACKSESSIONID = 4;
    private static final int INDEX_PSMOBAPPPACKSESSIONNAME = 5;
    private static final int INDEX_PSSYSAPPID = 6;
    private static final int INDEX_PSSYSAPPNAME = 7;
    private static final int INDEX_PSSYSTEMID = 8;
    private static final int INDEX_PSSYSTEMNAME = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSMobAppPackSessionBase proxyPSMobAppPackSessionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean psmobapppackidDirtyFlag = false;
    private boolean psmobapppacknameDirtyFlag = false;
    private boolean psmobapppacksessionidDirtyFlag = false;
    private boolean psmobapppacksessionnameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="psmobapppackid")
    private String psmobapppackid;
    @Column(name="psmobapppackname")
    private String psmobapppackname;
    @Column(name="psmobapppacksessionid")
    private String psmobapppacksessionid;
    @Column(name="psmobapppacksessionname")
    private String psmobapppacksessionname;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSMobAppPackLock = new Integer(1);
    private PSMobAppPack psmobapppack = null;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setPSMobAppPackId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackid = string;
        this.psmobapppackidDirtyFlag = true;
    }

    public String getPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackId();
        }
        return this.psmobapppackid;
    }

    public boolean isPSMobAppPackIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackIdDirty();
        }
        return this.psmobapppackidDirtyFlag;
    }

    public void resetPSMobAppPackId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackId();
            return;
        }
        this.psmobapppackidDirtyFlag = false;
        this.psmobapppackid = null;
    }

    public void setPSMobAppPackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppackname = string;
        this.psmobapppacknameDirtyFlag = true;
    }

    public String getPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackName();
        }
        return this.psmobapppackname;
    }

    public boolean isPSMobAppPackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackNameDirty();
        }
        return this.psmobapppacknameDirtyFlag;
    }

    public void resetPSMobAppPackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackName();
            return;
        }
        this.psmobapppacknameDirtyFlag = false;
        this.psmobapppackname = null;
    }

    public void setPSMobAppPackSessionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackSessionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppacksessionid = string;
        this.psmobapppacksessionidDirtyFlag = true;
    }

    public String getPSMobAppPackSessionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackSessionId();
        }
        return this.psmobapppacksessionid;
    }

    public boolean isPSMobAppPackSessionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackSessionIdDirty();
        }
        return this.psmobapppacksessionidDirtyFlag;
    }

    public void resetPSMobAppPackSessionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackSessionId();
            return;
        }
        this.psmobapppacksessionidDirtyFlag = false;
        this.psmobapppacksessionid = null;
    }

    public void setPSMobAppPackSessionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSMobAppPackSessionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmobapppacksessionname = string;
        this.psmobapppacksessionnameDirtyFlag = true;
    }

    public String getPSMobAppPackSessionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPackSessionName();
        }
        return this.psmobapppacksessionname;
    }

    public boolean isPSMobAppPackSessionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSMobAppPackSessionNameDirty();
        }
        return this.psmobapppacksessionnameDirtyFlag;
    }

    public void resetPSMobAppPackSessionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSMobAppPackSessionName();
            return;
        }
        this.psmobapppacksessionnameDirtyFlag = false;
        this.psmobapppacksessionname = null;
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
        PSMobAppPackSessionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSMobAppPackSessionBase pSMobAppPackSessionBase) {
        pSMobAppPackSessionBase.resetCreateDate();
        pSMobAppPackSessionBase.resetCreateMan();
        pSMobAppPackSessionBase.resetPSMobAppPackId();
        pSMobAppPackSessionBase.resetPSMobAppPackName();
        pSMobAppPackSessionBase.resetPSMobAppPackSessionId();
        pSMobAppPackSessionBase.resetPSMobAppPackSessionName();
        pSMobAppPackSessionBase.resetPSSysAppId();
        pSMobAppPackSessionBase.resetPSSysAppName();
        pSMobAppPackSessionBase.resetPSSystemId();
        pSMobAppPackSessionBase.resetPSSystemName();
        pSMobAppPackSessionBase.resetUpdateDate();
        pSMobAppPackSessionBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isPSMobAppPackIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKID, this.getPSMobAppPackId());
        }
        if (!bl || this.isPSMobAppPackNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKNAME, this.getPSMobAppPackName());
        }
        if (!bl || this.isPSMobAppPackSessionIdDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSESSIONID, this.getPSMobAppPackSessionId());
        }
        if (!bl || this.isPSMobAppPackSessionNameDirty()) {
            hashMap.put(FIELD_PSMOBAPPPACKSESSIONNAME, this.getPSMobAppPackSessionName());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSMobAppPackSessionBase.get(this, n);
    }

    private static Object get(PSMobAppPackSessionBase pSMobAppPackSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackSessionBase.getCreateDate();
            }
            case 1: {
                return pSMobAppPackSessionBase.getCreateMan();
            }
            case 2: {
                return pSMobAppPackSessionBase.getPSMobAppPackId();
            }
            case 3: {
                return pSMobAppPackSessionBase.getPSMobAppPackName();
            }
            case 4: {
                return pSMobAppPackSessionBase.getPSMobAppPackSessionId();
            }
            case 5: {
                return pSMobAppPackSessionBase.getPSMobAppPackSessionName();
            }
            case 6: {
                return pSMobAppPackSessionBase.getPSSysAppId();
            }
            case 7: {
                return pSMobAppPackSessionBase.getPSSysAppName();
            }
            case 8: {
                return pSMobAppPackSessionBase.getPSSystemId();
            }
            case 9: {
                return pSMobAppPackSessionBase.getPSSystemName();
            }
            case 10: {
                return pSMobAppPackSessionBase.getUpdateDate();
            }
            case 11: {
                return pSMobAppPackSessionBase.getUpdateMan();
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
        PSMobAppPackSessionBase.set(this, n, object);
    }

    private static void set(PSMobAppPackSessionBase pSMobAppPackSessionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackSessionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSMobAppPackSessionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSMobAppPackSessionBase.setPSMobAppPackId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSMobAppPackSessionBase.setPSMobAppPackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSMobAppPackSessionBase.setPSMobAppPackSessionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSMobAppPackSessionBase.setPSMobAppPackSessionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSMobAppPackSessionBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSMobAppPackSessionBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSMobAppPackSessionBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSMobAppPackSessionBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSMobAppPackSessionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSMobAppPackSessionBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSMobAppPackSessionBase.isNull(this, n);
    }

    private static boolean isNull(PSMobAppPackSessionBase pSMobAppPackSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackSessionBase.getCreateDate() == null;
            }
            case 1: {
                return pSMobAppPackSessionBase.getCreateMan() == null;
            }
            case 2: {
                return pSMobAppPackSessionBase.getPSMobAppPackId() == null;
            }
            case 3: {
                return pSMobAppPackSessionBase.getPSMobAppPackName() == null;
            }
            case 4: {
                return pSMobAppPackSessionBase.getPSMobAppPackSessionId() == null;
            }
            case 5: {
                return pSMobAppPackSessionBase.getPSMobAppPackSessionName() == null;
            }
            case 6: {
                return pSMobAppPackSessionBase.getPSSysAppId() == null;
            }
            case 7: {
                return pSMobAppPackSessionBase.getPSSysAppName() == null;
            }
            case 8: {
                return pSMobAppPackSessionBase.getPSSystemId() == null;
            }
            case 9: {
                return pSMobAppPackSessionBase.getPSSystemName() == null;
            }
            case 10: {
                return pSMobAppPackSessionBase.getUpdateDate() == null;
            }
            case 11: {
                return pSMobAppPackSessionBase.getUpdateMan() == null;
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
        return PSMobAppPackSessionBase.contains(this, n);
    }

    private static boolean contains(PSMobAppPackSessionBase pSMobAppPackSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSMobAppPackSessionBase.isCreateDateDirty();
            }
            case 1: {
                return pSMobAppPackSessionBase.isCreateManDirty();
            }
            case 2: {
                return pSMobAppPackSessionBase.isPSMobAppPackIdDirty();
            }
            case 3: {
                return pSMobAppPackSessionBase.isPSMobAppPackNameDirty();
            }
            case 4: {
                return pSMobAppPackSessionBase.isPSMobAppPackSessionIdDirty();
            }
            case 5: {
                return pSMobAppPackSessionBase.isPSMobAppPackSessionNameDirty();
            }
            case 6: {
                return pSMobAppPackSessionBase.isPSSysAppIdDirty();
            }
            case 7: {
                return pSMobAppPackSessionBase.isPSSysAppNameDirty();
            }
            case 8: {
                return pSMobAppPackSessionBase.isPSSystemIdDirty();
            }
            case 9: {
                return pSMobAppPackSessionBase.isPSSystemNameDirty();
            }
            case 10: {
                return pSMobAppPackSessionBase.isUpdateDateDirty();
            }
            case 11: {
                return pSMobAppPackSessionBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSMobAppPackSessionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSMobAppPackSessionBase pSMobAppPackSessionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSMobAppPackSessionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackid", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSMobAppPackId()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppackname", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSMobAppPackName()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppacksessionid", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSMobAppPackSessionId()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmobapppacksessionname", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSMobAppPackSessionName()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSMobAppPackSessionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSMobAppPackSessionBase.getJSONValue((Object)pSMobAppPackSessionBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSMobAppPackSessionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSMobAppPackSessionBase pSMobAppPackSessionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSMobAppPackSessionBase.getCreateDate() != null) {
            object = pSMobAppPackSessionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackSessionBase.getCreateMan() != null) {
            object = pSMobAppPackSessionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackId() != null) {
            object = pSMobAppPackSessionBase.getPSMobAppPackId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackName() != null) {
            object = pSMobAppPackSessionBase.getPSMobAppPackName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionId() != null) {
            object = pSMobAppPackSessionBase.getPSMobAppPackSessionId();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSESSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionName() != null) {
            object = pSMobAppPackSessionBase.getPSMobAppPackSessionName();
            xmlNode.setAttribute(FIELD_PSMOBAPPPACKSESSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSSysAppId() != null) {
            object = pSMobAppPackSessionBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSSysAppName() != null) {
            object = pSMobAppPackSessionBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSSystemId() != null) {
            object = pSMobAppPackSessionBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getPSSystemName() != null) {
            object = pSMobAppPackSessionBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSMobAppPackSessionBase.getUpdateDate() != null) {
            object = pSMobAppPackSessionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSMobAppPackSessionBase.getUpdateMan() != null) {
            object = pSMobAppPackSessionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSMobAppPackSessionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSMobAppPackSessionBase pSMobAppPackSessionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSMobAppPackSessionBase.isCreateDateDirty() && (bl || pSMobAppPackSessionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSMobAppPackSessionBase.getCreateDate());
        }
        if (pSMobAppPackSessionBase.isCreateManDirty() && (bl || pSMobAppPackSessionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSMobAppPackSessionBase.getCreateMan());
        }
        if (pSMobAppPackSessionBase.isPSMobAppPackIdDirty() && (bl || pSMobAppPackSessionBase.getPSMobAppPackId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKID, (Object)pSMobAppPackSessionBase.getPSMobAppPackId());
        }
        if (pSMobAppPackSessionBase.isPSMobAppPackNameDirty() && (bl || pSMobAppPackSessionBase.getPSMobAppPackName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKNAME, (Object)pSMobAppPackSessionBase.getPSMobAppPackName());
        }
        if (pSMobAppPackSessionBase.isPSMobAppPackSessionIdDirty() && (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionId() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSESSIONID, (Object)pSMobAppPackSessionBase.getPSMobAppPackSessionId());
        }
        if (pSMobAppPackSessionBase.isPSMobAppPackSessionNameDirty() && (bl || pSMobAppPackSessionBase.getPSMobAppPackSessionName() != null)) {
            iDataObject.set(FIELD_PSMOBAPPPACKSESSIONNAME, (Object)pSMobAppPackSessionBase.getPSMobAppPackSessionName());
        }
        if (pSMobAppPackSessionBase.isPSSysAppIdDirty() && (bl || pSMobAppPackSessionBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSMobAppPackSessionBase.getPSSysAppId());
        }
        if (pSMobAppPackSessionBase.isPSSysAppNameDirty() && (bl || pSMobAppPackSessionBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSMobAppPackSessionBase.getPSSysAppName());
        }
        if (pSMobAppPackSessionBase.isPSSystemIdDirty() && (bl || pSMobAppPackSessionBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSMobAppPackSessionBase.getPSSystemId());
        }
        if (pSMobAppPackSessionBase.isPSSystemNameDirty() && (bl || pSMobAppPackSessionBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSMobAppPackSessionBase.getPSSystemName());
        }
        if (pSMobAppPackSessionBase.isUpdateDateDirty() && (bl || pSMobAppPackSessionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSMobAppPackSessionBase.getUpdateDate());
        }
        if (pSMobAppPackSessionBase.isUpdateManDirty() && (bl || pSMobAppPackSessionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSMobAppPackSessionBase.getUpdateMan());
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
        return PSMobAppPackSessionBase.remove(this, n);
    }

    private static boolean remove(PSMobAppPackSessionBase pSMobAppPackSessionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSMobAppPackSessionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSMobAppPackSessionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSMobAppPackSessionBase.resetPSMobAppPackId();
                return true;
            }
            case 3: {
                pSMobAppPackSessionBase.resetPSMobAppPackName();
                return true;
            }
            case 4: {
                pSMobAppPackSessionBase.resetPSMobAppPackSessionId();
                return true;
            }
            case 5: {
                pSMobAppPackSessionBase.resetPSMobAppPackSessionName();
                return true;
            }
            case 6: {
                pSMobAppPackSessionBase.resetPSSysAppId();
                return true;
            }
            case 7: {
                pSMobAppPackSessionBase.resetPSSysAppName();
                return true;
            }
            case 8: {
                pSMobAppPackSessionBase.resetPSSystemId();
                return true;
            }
            case 9: {
                pSMobAppPackSessionBase.resetPSSystemName();
                return true;
            }
            case 10: {
                pSMobAppPackSessionBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSMobAppPackSessionBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSMobAppPack getPSMobAppPack() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSMobAppPack();
        }
        if (this.getPSMobAppPackId() == null) {
            return null;
        }
        Integer n = this.objPSMobAppPackLock;
        synchronized (n) {
            if (this.psmobapppack != null && DataTypeHelper.compare((int)25, (Object)this.getPSMobAppPackId(), (Object)this.psmobapppack.getPSMobAppPackId()) != 0L) {
                this.psmobapppack = null;
            }
            if (this.psmobapppack == null) {
                PSMobAppPack pSMobAppPack = new PSMobAppPack();
                pSMobAppPack.setPSMobAppPackId(this.getPSMobAppPackId());
                PSMobAppPackService pSMobAppPackService = (PSMobAppPackService)ServiceGlobal.getService(PSMobAppPackService.class, (SessionFactory)this.getSessionFactory());
                pSMobAppPackService.autoGet(pSMobAppPack);
                this.psmobapppack = pSMobAppPack;
            }
            return this.psmobapppack;
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

    private PSMobAppPackSessionBase getProxyEntity() {
        return this.proxyPSMobAppPackSessionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSMobAppPackSessionBase = null;
        if (iDataObject != null && iDataObject instanceof PSMobAppPackSessionBase) {
            this.proxyPSMobAppPackSessionBase = (PSMobAppPackSessionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSMobAppPackSessionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKID, 2);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKNAME, 3);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSESSIONID, 4);
        fieldIndexMap.put(FIELD_PSMOBAPPPACKSESSIONNAME, 5);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 8);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
    }
}

