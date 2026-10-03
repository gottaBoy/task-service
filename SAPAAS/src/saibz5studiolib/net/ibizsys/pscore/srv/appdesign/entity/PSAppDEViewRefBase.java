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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSAppDEViewRefBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSAppDEViewRefBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPDEVIEWREFID = "PSAPPDEVIEWREFID";
    public static final String FIELD_PSAPPDEVIEWREFNAME = "PSAPPDEVIEWREFNAME";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSAPPDEVIEWREFID = 3;
    private static final int INDEX_PSAPPDEVIEWREFNAME = 4;
    private static final int INDEX_PSDEVIEWBASEID = 5;
    private static final int INDEX_PSDEVIEWBASENAME = 6;
    private static final int INDEX_PSSYSAPPID = 7;
    private static final int INDEX_PSSYSAPPNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSAppDEViewRefBase proxyPSAppDEViewRefBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psappdeviewrefidDirtyFlag = false;
    private boolean psappdeviewrefnameDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="psappdeviewrefid")
    private String psappdeviewrefid;
    @Column(name="psappdeviewrefname")
    private String psappdeviewrefname;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
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

    public void setPSAppDEViewRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewrefid = string;
        this.psappdeviewrefidDirtyFlag = true;
    }

    public String getPSAppDEViewRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewRefId();
        }
        return this.psappdeviewrefid;
    }

    public boolean isPSAppDEViewRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewRefIdDirty();
        }
        return this.psappdeviewrefidDirtyFlag;
    }

    public void resetPSAppDEViewRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewRefId();
            return;
        }
        this.psappdeviewrefidDirtyFlag = false;
        this.psappdeviewrefid = null;
    }

    public void setPSAppDEViewRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppDEViewRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psappdeviewrefname = string;
        this.psappdeviewrefnameDirtyFlag = true;
    }

    public String getPSAppDEViewRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppDEViewRefName();
        }
        return this.psappdeviewrefname;
    }

    public boolean isPSAppDEViewRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppDEViewRefNameDirty();
        }
        return this.psappdeviewrefnameDirtyFlag;
    }

    public void resetPSAppDEViewRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppDEViewRefName();
            return;
        }
        this.psappdeviewrefnameDirtyFlag = false;
        this.psappdeviewrefname = null;
    }

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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
        PSAppDEViewRefBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSAppDEViewRefBase pSAppDEViewRefBase) {
        pSAppDEViewRefBase.resetCreateDate();
        pSAppDEViewRefBase.resetCreateMan();
        pSAppDEViewRefBase.resetMemo();
        pSAppDEViewRefBase.resetPSAppDEViewRefId();
        pSAppDEViewRefBase.resetPSAppDEViewRefName();
        pSAppDEViewRefBase.resetPSDEViewBaseId();
        pSAppDEViewRefBase.resetPSDEViewBaseName();
        pSAppDEViewRefBase.resetPSSysAppId();
        pSAppDEViewRefBase.resetPSSysAppName();
        pSAppDEViewRefBase.resetUpdateDate();
        pSAppDEViewRefBase.resetUpdateMan();
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
        if (!bl || this.isPSAppDEViewRefIdDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWREFID, this.getPSAppDEViewRefId());
        }
        if (!bl || this.isPSAppDEViewRefNameDirty()) {
            hashMap.put(FIELD_PSAPPDEVIEWREFNAME, this.getPSAppDEViewRefName());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
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
        return PSAppDEViewRefBase.get(this, n);
    }

    private static Object get(PSAppDEViewRefBase pSAppDEViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDEViewRefBase.getCreateDate();
            }
            case 1: {
                return pSAppDEViewRefBase.getCreateMan();
            }
            case 2: {
                return pSAppDEViewRefBase.getMemo();
            }
            case 3: {
                return pSAppDEViewRefBase.getPSAppDEViewRefId();
            }
            case 4: {
                return pSAppDEViewRefBase.getPSAppDEViewRefName();
            }
            case 5: {
                return pSAppDEViewRefBase.getPSDEViewBaseId();
            }
            case 6: {
                return pSAppDEViewRefBase.getPSDEViewBaseName();
            }
            case 7: {
                return pSAppDEViewRefBase.getPSSysAppId();
            }
            case 8: {
                return pSAppDEViewRefBase.getPSSysAppName();
            }
            case 9: {
                return pSAppDEViewRefBase.getUpdateDate();
            }
            case 10: {
                return pSAppDEViewRefBase.getUpdateMan();
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
        PSAppDEViewRefBase.set(this, n, object);
    }

    private static void set(PSAppDEViewRefBase pSAppDEViewRefBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSAppDEViewRefBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSAppDEViewRefBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSAppDEViewRefBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSAppDEViewRefBase.setPSAppDEViewRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSAppDEViewRefBase.setPSAppDEViewRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSAppDEViewRefBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSAppDEViewRefBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSAppDEViewRefBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSAppDEViewRefBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSAppDEViewRefBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSAppDEViewRefBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSAppDEViewRefBase.isNull(this, n);
    }

    private static boolean isNull(PSAppDEViewRefBase pSAppDEViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDEViewRefBase.getCreateDate() == null;
            }
            case 1: {
                return pSAppDEViewRefBase.getCreateMan() == null;
            }
            case 2: {
                return pSAppDEViewRefBase.getMemo() == null;
            }
            case 3: {
                return pSAppDEViewRefBase.getPSAppDEViewRefId() == null;
            }
            case 4: {
                return pSAppDEViewRefBase.getPSAppDEViewRefName() == null;
            }
            case 5: {
                return pSAppDEViewRefBase.getPSDEViewBaseId() == null;
            }
            case 6: {
                return pSAppDEViewRefBase.getPSDEViewBaseName() == null;
            }
            case 7: {
                return pSAppDEViewRefBase.getPSSysAppId() == null;
            }
            case 8: {
                return pSAppDEViewRefBase.getPSSysAppName() == null;
            }
            case 9: {
                return pSAppDEViewRefBase.getUpdateDate() == null;
            }
            case 10: {
                return pSAppDEViewRefBase.getUpdateMan() == null;
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
        return PSAppDEViewRefBase.contains(this, n);
    }

    private static boolean contains(PSAppDEViewRefBase pSAppDEViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSAppDEViewRefBase.isCreateDateDirty();
            }
            case 1: {
                return pSAppDEViewRefBase.isCreateManDirty();
            }
            case 2: {
                return pSAppDEViewRefBase.isMemoDirty();
            }
            case 3: {
                return pSAppDEViewRefBase.isPSAppDEViewRefIdDirty();
            }
            case 4: {
                return pSAppDEViewRefBase.isPSAppDEViewRefNameDirty();
            }
            case 5: {
                return pSAppDEViewRefBase.isPSDEViewBaseIdDirty();
            }
            case 6: {
                return pSAppDEViewRefBase.isPSDEViewBaseNameDirty();
            }
            case 7: {
                return pSAppDEViewRefBase.isPSSysAppIdDirty();
            }
            case 8: {
                return pSAppDEViewRefBase.isPSSysAppNameDirty();
            }
            case 9: {
                return pSAppDEViewRefBase.isUpdateDateDirty();
            }
            case 10: {
                return pSAppDEViewRefBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSAppDEViewRefBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSAppDEViewRefBase pSAppDEViewRefBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSAppDEViewRefBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getMemo()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSAppDEViewRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewrefid", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSAppDEViewRefId()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSAppDEViewRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psappdeviewrefname", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSAppDEViewRefName()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSAppDEViewRefBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSAppDEViewRefBase.getJSONValue((Object)pSAppDEViewRefBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSAppDEViewRefBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSAppDEViewRefBase pSAppDEViewRefBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSAppDEViewRefBase.getCreateDate() != null) {
            object = pSAppDEViewRefBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDEViewRefBase.getCreateMan() != null) {
            object = pSAppDEViewRefBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getMemo() != null) {
            object = pSAppDEViewRefBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSAppDEViewRefId() != null) {
            object = pSAppDEViewRefBase.getPSAppDEViewRefId();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWREFID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSAppDEViewRefName() != null) {
            object = pSAppDEViewRefBase.getPSAppDEViewRefName();
            xmlNode.setAttribute(FIELD_PSAPPDEVIEWREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSDEViewBaseId() != null) {
            object = pSAppDEViewRefBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSDEViewBaseName() != null) {
            object = pSAppDEViewRefBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSSysAppId() != null) {
            object = pSAppDEViewRefBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getPSSysAppName() != null) {
            object = pSAppDEViewRefBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSAppDEViewRefBase.getUpdateDate() != null) {
            object = pSAppDEViewRefBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSAppDEViewRefBase.getUpdateMan() != null) {
            object = pSAppDEViewRefBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSAppDEViewRefBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSAppDEViewRefBase pSAppDEViewRefBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSAppDEViewRefBase.isCreateDateDirty() && (bl || pSAppDEViewRefBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSAppDEViewRefBase.getCreateDate());
        }
        if (pSAppDEViewRefBase.isCreateManDirty() && (bl || pSAppDEViewRefBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSAppDEViewRefBase.getCreateMan());
        }
        if (pSAppDEViewRefBase.isMemoDirty() && (bl || pSAppDEViewRefBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSAppDEViewRefBase.getMemo());
        }
        if (pSAppDEViewRefBase.isPSAppDEViewRefIdDirty() && (bl || pSAppDEViewRefBase.getPSAppDEViewRefId() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWREFID, (Object)pSAppDEViewRefBase.getPSAppDEViewRefId());
        }
        if (pSAppDEViewRefBase.isPSAppDEViewRefNameDirty() && (bl || pSAppDEViewRefBase.getPSAppDEViewRefName() != null)) {
            iDataObject.set(FIELD_PSAPPDEVIEWREFNAME, (Object)pSAppDEViewRefBase.getPSAppDEViewRefName());
        }
        if (pSAppDEViewRefBase.isPSDEViewBaseIdDirty() && (bl || pSAppDEViewRefBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSAppDEViewRefBase.getPSDEViewBaseId());
        }
        if (pSAppDEViewRefBase.isPSDEViewBaseNameDirty() && (bl || pSAppDEViewRefBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSAppDEViewRefBase.getPSDEViewBaseName());
        }
        if (pSAppDEViewRefBase.isPSSysAppIdDirty() && (bl || pSAppDEViewRefBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSAppDEViewRefBase.getPSSysAppId());
        }
        if (pSAppDEViewRefBase.isPSSysAppNameDirty() && (bl || pSAppDEViewRefBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSAppDEViewRefBase.getPSSysAppName());
        }
        if (pSAppDEViewRefBase.isUpdateDateDirty() && (bl || pSAppDEViewRefBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSAppDEViewRefBase.getUpdateDate());
        }
        if (pSAppDEViewRefBase.isUpdateManDirty() && (bl || pSAppDEViewRefBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSAppDEViewRefBase.getUpdateMan());
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
        return PSAppDEViewRefBase.remove(this, n);
    }

    private static boolean remove(PSAppDEViewRefBase pSAppDEViewRefBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSAppDEViewRefBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSAppDEViewRefBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSAppDEViewRefBase.resetMemo();
                return true;
            }
            case 3: {
                pSAppDEViewRefBase.resetPSAppDEViewRefId();
                return true;
            }
            case 4: {
                pSAppDEViewRefBase.resetPSAppDEViewRefName();
                return true;
            }
            case 5: {
                pSAppDEViewRefBase.resetPSDEViewBaseId();
                return true;
            }
            case 6: {
                pSAppDEViewRefBase.resetPSDEViewBaseName();
                return true;
            }
            case 7: {
                pSAppDEViewRefBase.resetPSSysAppId();
                return true;
            }
            case 8: {
                pSAppDEViewRefBase.resetPSSysAppName();
                return true;
            }
            case 9: {
                pSAppDEViewRefBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSAppDEViewRefBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
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

    private PSAppDEViewRefBase getProxyEntity() {
        return this.proxyPSAppDEViewRefBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSAppDEViewRefBase = null;
        if (iDataObject != null && iDataObject instanceof PSAppDEViewRefBase) {
            this.proxyPSAppDEViewRefBase = (PSAppDEViewRefBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.appdesign.service.PSAppDEViewRefService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWREFID, 3);
        fieldIndexMap.put(FIELD_PSAPPDEVIEWREFNAME, 4);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 5);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 6);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 7);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

