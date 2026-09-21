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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysApp;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDeploy;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysAppService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDeployAppBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDeployAppBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSDEPLOYAPPID = "PSSYSDEPLOYAPPID";
    public static final String FIELD_PSSYSDEPLOYAPPNAME = "PSSYSDEPLOYAPPNAME";
    public static final String FIELD_PSSYSDEPLOYID = "PSSYSDEPLOYID";
    public static final String FIELD_PSSYSDEPLOYNAME = "PSSYSDEPLOYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSYSAPPID = 3;
    private static final int INDEX_PSSYSAPPNAME = 4;
    private static final int INDEX_PSSYSDEPLOYAPPID = 5;
    private static final int INDEX_PSSYSDEPLOYAPPNAME = 6;
    private static final int INDEX_PSSYSDEPLOYID = 7;
    private static final int INDEX_PSSYSDEPLOYNAME = 8;
    private static final int INDEX_UPDATEDATE = 9;
    private static final int INDEX_UPDATEMAN = 10;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDeployAppBase proxyPSSysDeployAppBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssysdeployappidDirtyFlag = false;
    private boolean pssysdeployappnameDirtyFlag = false;
    private boolean pssysdeployidDirtyFlag = false;
    private boolean pssysdeploynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssysdeployappid")
    private String pssysdeployappid;
    @Column(name="pssysdeployappname")
    private String pssysdeployappname;
    @Column(name="pssysdeployid")
    private String pssysdeployid;
    @Column(name="pssysdeployname")
    private String pssysdeployname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSysAppLock = new Integer(1);
    private PSSysApp pssysapp = null;
    private Integer objPssysdeployLock = new Integer(1);
    private PSSysDeploy pssysdeploy = null;

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

    public void setPSSysDeployAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployappid = string;
        this.pssysdeployappidDirtyFlag = true;
    }

    public String getPSSysDeployAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployAppId();
        }
        return this.pssysdeployappid;
    }

    public boolean isPSSysDeployAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployAppIdDirty();
        }
        return this.pssysdeployappidDirtyFlag;
    }

    public void resetPSSysDeployAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployAppId();
            return;
        }
        this.pssysdeployappidDirtyFlag = false;
        this.pssysdeployappid = null;
    }

    public void setPSSysDeployAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployappname = string;
        this.pssysdeployappnameDirtyFlag = true;
    }

    public String getPSSysDeployAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployAppName();
        }
        return this.pssysdeployappname;
    }

    public boolean isPSSysDeployAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployAppNameDirty();
        }
        return this.pssysdeployappnameDirtyFlag;
    }

    public void resetPSSysDeployAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployAppName();
            return;
        }
        this.pssysdeployappnameDirtyFlag = false;
        this.pssysdeployappname = null;
    }

    public void setPSSysDeployId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployid = string;
        this.pssysdeployidDirtyFlag = true;
    }

    public String getPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployId();
        }
        return this.pssysdeployid;
    }

    public boolean isPSSysDeployIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployIdDirty();
        }
        return this.pssysdeployidDirtyFlag;
    }

    public void resetPSSysDeployId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployId();
            return;
        }
        this.pssysdeployidDirtyFlag = false;
        this.pssysdeployid = null;
    }

    public void setPSSysDeployName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDeployName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdeployname = string;
        this.pssysdeploynameDirtyFlag = true;
    }

    public String getPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDeployName();
        }
        return this.pssysdeployname;
    }

    public boolean isPSSysDeployNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDeployNameDirty();
        }
        return this.pssysdeploynameDirtyFlag;
    }

    public void resetPSSysDeployName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDeployName();
            return;
        }
        this.pssysdeploynameDirtyFlag = false;
        this.pssysdeployname = null;
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
        PSSysDeployAppBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDeployAppBase pSSysDeployAppBase) {
        pSSysDeployAppBase.resetCreateDate();
        pSSysDeployAppBase.resetCreateMan();
        pSSysDeployAppBase.resetMemo();
        pSSysDeployAppBase.resetPSSysAppId();
        pSSysDeployAppBase.resetPSSysAppName();
        pSSysDeployAppBase.resetPSSysDeployAppId();
        pSSysDeployAppBase.resetPSSysDeployAppName();
        pSSysDeployAppBase.resetPSSysDeployId();
        pSSysDeployAppBase.resetPSSysDeployName();
        pSSysDeployAppBase.resetUpdateDate();
        pSSysDeployAppBase.resetUpdateMan();
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
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysDeployAppIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYAPPID, this.getPSSysDeployAppId());
        }
        if (!bl || this.isPSSysDeployAppNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYAPPNAME, this.getPSSysDeployAppName());
        }
        if (!bl || this.isPSSysDeployIdDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYID, this.getPSSysDeployId());
        }
        if (!bl || this.isPSSysDeployNameDirty()) {
            hashMap.put(FIELD_PSSYSDEPLOYNAME, this.getPSSysDeployName());
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
        return PSSysDeployAppBase.get(this, n);
    }

    private static Object get(PSSysDeployAppBase pSSysDeployAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployAppBase.getCreateDate();
            }
            case 1: {
                return pSSysDeployAppBase.getCreateMan();
            }
            case 2: {
                return pSSysDeployAppBase.getMemo();
            }
            case 3: {
                return pSSysDeployAppBase.getPSSysAppId();
            }
            case 4: {
                return pSSysDeployAppBase.getPSSysAppName();
            }
            case 5: {
                return pSSysDeployAppBase.getPSSysDeployAppId();
            }
            case 6: {
                return pSSysDeployAppBase.getPSSysDeployAppName();
            }
            case 7: {
                return pSSysDeployAppBase.getPSSysDeployId();
            }
            case 8: {
                return pSSysDeployAppBase.getPSSysDeployName();
            }
            case 9: {
                return pSSysDeployAppBase.getUpdateDate();
            }
            case 10: {
                return pSSysDeployAppBase.getUpdateMan();
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
        PSSysDeployAppBase.set(this, n, object);
    }

    private static void set(PSSysDeployAppBase pSSysDeployAppBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployAppBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysDeployAppBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysDeployAppBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysDeployAppBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysDeployAppBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysDeployAppBase.setPSSysDeployAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysDeployAppBase.setPSSysDeployAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysDeployAppBase.setPSSysDeployId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysDeployAppBase.setPSSysDeployName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysDeployAppBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 10: {
                pSSysDeployAppBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSysDeployAppBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDeployAppBase pSSysDeployAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployAppBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysDeployAppBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysDeployAppBase.getMemo() == null;
            }
            case 3: {
                return pSSysDeployAppBase.getPSSysAppId() == null;
            }
            case 4: {
                return pSSysDeployAppBase.getPSSysAppName() == null;
            }
            case 5: {
                return pSSysDeployAppBase.getPSSysDeployAppId() == null;
            }
            case 6: {
                return pSSysDeployAppBase.getPSSysDeployAppName() == null;
            }
            case 7: {
                return pSSysDeployAppBase.getPSSysDeployId() == null;
            }
            case 8: {
                return pSSysDeployAppBase.getPSSysDeployName() == null;
            }
            case 9: {
                return pSSysDeployAppBase.getUpdateDate() == null;
            }
            case 10: {
                return pSSysDeployAppBase.getUpdateMan() == null;
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
        return PSSysDeployAppBase.contains(this, n);
    }

    private static boolean contains(PSSysDeployAppBase pSSysDeployAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDeployAppBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysDeployAppBase.isCreateManDirty();
            }
            case 2: {
                return pSSysDeployAppBase.isMemoDirty();
            }
            case 3: {
                return pSSysDeployAppBase.isPSSysAppIdDirty();
            }
            case 4: {
                return pSSysDeployAppBase.isPSSysAppNameDirty();
            }
            case 5: {
                return pSSysDeployAppBase.isPSSysDeployAppIdDirty();
            }
            case 6: {
                return pSSysDeployAppBase.isPSSysDeployAppNameDirty();
            }
            case 7: {
                return pSSysDeployAppBase.isPSSysDeployIdDirty();
            }
            case 8: {
                return pSSysDeployAppBase.isPSSysDeployNameDirty();
            }
            case 9: {
                return pSSysDeployAppBase.isUpdateDateDirty();
            }
            case 10: {
                return pSSysDeployAppBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDeployAppBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDeployAppBase pSSysDeployAppBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDeployAppBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployappid", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysDeployAppId()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployappname", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysDeployAppName()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployid", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysDeployId()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdeployname", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getPSSysDeployName()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDeployAppBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDeployAppBase.getJSONValue((Object)pSSysDeployAppBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDeployAppBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDeployAppBase pSSysDeployAppBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDeployAppBase.getCreateDate() != null) {
            object = pSSysDeployAppBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployAppBase.getCreateMan() != null) {
            object = pSSysDeployAppBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getMemo() != null) {
            object = pSSysDeployAppBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysAppId() != null) {
            object = pSSysDeployAppBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysAppName() != null) {
            object = pSSysDeployAppBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployAppId() != null) {
            object = pSSysDeployAppBase.getPSSysDeployAppId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployAppName() != null) {
            object = pSSysDeployAppBase.getPSSysDeployAppName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployId() != null) {
            object = pSSysDeployAppBase.getPSSysDeployId();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getPSSysDeployName() != null) {
            object = pSSysDeployAppBase.getPSSysDeployName();
            xmlNode.setAttribute(FIELD_PSSYSDEPLOYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDeployAppBase.getUpdateDate() != null) {
            object = pSSysDeployAppBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDeployAppBase.getUpdateMan() != null) {
            object = pSSysDeployAppBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDeployAppBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDeployAppBase pSSysDeployAppBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDeployAppBase.isCreateDateDirty() && (bl || pSSysDeployAppBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDeployAppBase.getCreateDate());
        }
        if (pSSysDeployAppBase.isCreateManDirty() && (bl || pSSysDeployAppBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDeployAppBase.getCreateMan());
        }
        if (pSSysDeployAppBase.isMemoDirty() && (bl || pSSysDeployAppBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDeployAppBase.getMemo());
        }
        if (pSSysDeployAppBase.isPSSysAppIdDirty() && (bl || pSSysDeployAppBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSSysDeployAppBase.getPSSysAppId());
        }
        if (pSSysDeployAppBase.isPSSysAppNameDirty() && (bl || pSSysDeployAppBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSSysDeployAppBase.getPSSysAppName());
        }
        if (pSSysDeployAppBase.isPSSysDeployAppIdDirty() && (bl || pSSysDeployAppBase.getPSSysDeployAppId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYAPPID, (Object)pSSysDeployAppBase.getPSSysDeployAppId());
        }
        if (pSSysDeployAppBase.isPSSysDeployAppNameDirty() && (bl || pSSysDeployAppBase.getPSSysDeployAppName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYAPPNAME, (Object)pSSysDeployAppBase.getPSSysDeployAppName());
        }
        if (pSSysDeployAppBase.isPSSysDeployIdDirty() && (bl || pSSysDeployAppBase.getPSSysDeployId() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYID, (Object)pSSysDeployAppBase.getPSSysDeployId());
        }
        if (pSSysDeployAppBase.isPSSysDeployNameDirty() && (bl || pSSysDeployAppBase.getPSSysDeployName() != null)) {
            iDataObject.set(FIELD_PSSYSDEPLOYNAME, (Object)pSSysDeployAppBase.getPSSysDeployName());
        }
        if (pSSysDeployAppBase.isUpdateDateDirty() && (bl || pSSysDeployAppBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDeployAppBase.getUpdateDate());
        }
        if (pSSysDeployAppBase.isUpdateManDirty() && (bl || pSSysDeployAppBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDeployAppBase.getUpdateMan());
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
        return PSSysDeployAppBase.remove(this, n);
    }

    private static boolean remove(PSSysDeployAppBase pSSysDeployAppBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDeployAppBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysDeployAppBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysDeployAppBase.resetMemo();
                return true;
            }
            case 3: {
                pSSysDeployAppBase.resetPSSysAppId();
                return true;
            }
            case 4: {
                pSSysDeployAppBase.resetPSSysAppName();
                return true;
            }
            case 5: {
                pSSysDeployAppBase.resetPSSysDeployAppId();
                return true;
            }
            case 6: {
                pSSysDeployAppBase.resetPSSysDeployAppName();
                return true;
            }
            case 7: {
                pSSysDeployAppBase.resetPSSysDeployId();
                return true;
            }
            case 8: {
                pSSysDeployAppBase.resetPSSysDeployName();
                return true;
            }
            case 9: {
                pSSysDeployAppBase.resetUpdateDate();
                return true;
            }
            case 10: {
                pSSysDeployAppBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
                pSSysAppService.autoGet((IEntity)pSSysApp);
                this.pssysapp = pSSysApp;
            }
            return this.pssysapp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDeploy getPssysdeploy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPssysdeploy();
        }
        if (this.getPSSysDeployId() == null) {
            return null;
        }
        Integer n = this.objPssysdeployLock;
        synchronized (n) {
            if (this.pssysdeploy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDeployId(), (Object)this.pssysdeploy.getPSSysDeployId()) != 0L) {
                this.pssysdeploy = null;
            }
            if (this.pssysdeploy == null) {
                PSSysDeploy pSSysDeploy = new PSSysDeploy();
                pSSysDeploy.setPSSysDeployId(this.getPSSysDeployId());
                PSSysDeployService pSSysDeployService = (PSSysDeployService)ServiceGlobal.getService(PSSysDeployService.class, (SessionFactory)this.getSessionFactory());
                pSSysDeployService.autoGet((IEntity)pSSysDeploy);
                this.pssysdeploy = pSSysDeploy;
            }
            return this.pssysdeploy;
        }
    }

    private PSSysDeployAppBase getProxyEntity() {
        return this.proxyPSSysDeployAppBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDeployAppBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDeployAppBase) {
            this.proxyPSSysDeployAppBase = (PSSysDeployAppBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDeployAppService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 3);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 4);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYAPPID, 5);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYAPPNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYID, 7);
        fieldIndexMap.put(FIELD_PSSYSDEPLOYNAME, 8);
        fieldIndexMap.put(FIELD_UPDATEDATE, 9);
        fieldIndexMap.put(FIELD_UPDATEMAN, 10);
    }
}

