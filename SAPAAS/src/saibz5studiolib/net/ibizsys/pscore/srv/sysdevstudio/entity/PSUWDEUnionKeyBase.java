/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
 *  net.ibizsys.paas.util.JSONObjectHelper
 *  net.ibizsys.paas.util.StringHelper
 *  net.ibizsys.paas.xml.XmlNode
 *  net.sf.json.JSONObject
 *  org.apache.commons.logging.Log
 *  org.apache.commons.logging.LogFactory
 *  org.hibernate.SessionFactory
 */
package net.ibizsys.pscore.srv.sysdevstudio.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.persistence.Column;
import net.ibizsys.paas.data.DataObject;
import net.ibizsys.paas.data.IDataObject;
import net.ibizsys.paas.entity.EntityBase;
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSUWDEUnionKeyBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSUWDEUnionKeyBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_KEY2PSDEFID = "KEY2PSDEFID";
    public static final String FIELD_KEY2PSDEFNAME = "KEY2PSDEFNAME";
    public static final String FIELD_KEY3PSDEFID = "KEY3PSDEFID";
    public static final String FIELD_KEY3PSDEFNAME = "KEY3PSDEFNAME";
    public static final String FIELD_KEY4PSDEFID = "KEY4PSDEFID";
    public static final String FIELD_KEY4PSDEFNAME = "KEY4PSDEFNAME";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSUWDEUNIONKEYID = "PSUWDEUNIONKEYID";
    public static final String FIELD_PSUWDEUNIONKEYNAME = "PSUWDEUNIONKEYNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_KEY2PSDEFID = 2;
    private static final int INDEX_KEY2PSDEFNAME = 3;
    private static final int INDEX_KEY3PSDEFID = 4;
    private static final int INDEX_KEY3PSDEFNAME = 5;
    private static final int INDEX_KEY4PSDEFID = 6;
    private static final int INDEX_KEY4PSDEFNAME = 7;
    private static final int INDEX_KEYPSDEFID = 8;
    private static final int INDEX_KEYPSDEFNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDYNAINSTID = 11;
    private static final int INDEX_PSUWDEUNIONKEYID = 12;
    private static final int INDEX_PSUWDEUNIONKEYNAME = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSUWDEUnionKeyBase proxyPSUWDEUnionKeyBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean key2psdefidDirtyFlag = false;
    private boolean key2psdefnameDirtyFlag = false;
    private boolean key3psdefidDirtyFlag = false;
    private boolean key3psdefnameDirtyFlag = false;
    private boolean key4psdefidDirtyFlag = false;
    private boolean key4psdefnameDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psuwdeunionkeyidDirtyFlag = false;
    private boolean psuwdeunionkeynameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="key2psdefid")
    private String key2psdefid;
    @Column(name="key2psdefname")
    private String key2psdefname;
    @Column(name="key3psdefid")
    private String key3psdefid;
    @Column(name="key3psdefname")
    private String key3psdefname;
    @Column(name="key4psdefid")
    private String key4psdefid;
    @Column(name="key4psdefname")
    private String key4psdefname;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psuwdeunionkeyid")
    private String psuwdeunionkeyid;
    @Column(name="psuwdeunionkeyname")
    private String psuwdeunionkeyname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

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

    public void setKey2PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey2PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key2psdefid = string;
        this.key2psdefidDirtyFlag = true;
    }

    public String getKey2PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey2PSDEFId();
        }
        return this.key2psdefid;
    }

    public boolean isKey2PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey2PSDEFIdDirty();
        }
        return this.key2psdefidDirtyFlag;
    }

    public void resetKey2PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey2PSDEFId();
            return;
        }
        this.key2psdefidDirtyFlag = false;
        this.key2psdefid = null;
    }

    public void setKey2PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey2PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key2psdefname = string;
        this.key2psdefnameDirtyFlag = true;
    }

    public String getKey2PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey2PSDEFName();
        }
        return this.key2psdefname;
    }

    public boolean isKey2PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey2PSDEFNameDirty();
        }
        return this.key2psdefnameDirtyFlag;
    }

    public void resetKey2PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey2PSDEFName();
            return;
        }
        this.key2psdefnameDirtyFlag = false;
        this.key2psdefname = null;
    }

    public void setKey3PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey3PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key3psdefid = string;
        this.key3psdefidDirtyFlag = true;
    }

    public String getKey3PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey3PSDEFId();
        }
        return this.key3psdefid;
    }

    public boolean isKey3PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey3PSDEFIdDirty();
        }
        return this.key3psdefidDirtyFlag;
    }

    public void resetKey3PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey3PSDEFId();
            return;
        }
        this.key3psdefidDirtyFlag = false;
        this.key3psdefid = null;
    }

    public void setKey3PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey3PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key3psdefname = string;
        this.key3psdefnameDirtyFlag = true;
    }

    public String getKey3PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey3PSDEFName();
        }
        return this.key3psdefname;
    }

    public boolean isKey3PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey3PSDEFNameDirty();
        }
        return this.key3psdefnameDirtyFlag;
    }

    public void resetKey3PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey3PSDEFName();
            return;
        }
        this.key3psdefnameDirtyFlag = false;
        this.key3psdefname = null;
    }

    public void setKey4PSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey4PSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key4psdefid = string;
        this.key4psdefidDirtyFlag = true;
    }

    public String getKey4PSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey4PSDEFId();
        }
        return this.key4psdefid;
    }

    public boolean isKey4PSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey4PSDEFIdDirty();
        }
        return this.key4psdefidDirtyFlag;
    }

    public void resetKey4PSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey4PSDEFId();
            return;
        }
        this.key4psdefidDirtyFlag = false;
        this.key4psdefid = null;
    }

    public void setKey4PSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKey4PSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.key4psdefname = string;
        this.key4psdefnameDirtyFlag = true;
    }

    public String getKey4PSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKey4PSDEFName();
        }
        return this.key4psdefname;
    }

    public boolean isKey4PSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKey4PSDEFNameDirty();
        }
        return this.key4psdefnameDirtyFlag;
    }

    public void resetKey4PSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKey4PSDEFName();
            return;
        }
        this.key4psdefnameDirtyFlag = false;
        this.key4psdefname = null;
    }

    public void setKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefid = string;
        this.keypsdefidDirtyFlag = true;
    }

    public String getKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFId();
        }
        return this.keypsdefid;
    }

    public boolean isKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFIdDirty();
        }
        return this.keypsdefidDirtyFlag;
    }

    public void resetKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFId();
            return;
        }
        this.keypsdefidDirtyFlag = false;
        this.keypsdefid = null;
    }

    public void setKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefname = string;
        this.keypsdefnameDirtyFlag = true;
    }

    public String getKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFName();
        }
        return this.keypsdefname;
    }

    public boolean isKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFNameDirty();
        }
        return this.keypsdefnameDirtyFlag;
    }

    public void resetKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFName();
            return;
        }
        this.keypsdefnameDirtyFlag = false;
        this.keypsdefname = null;
    }

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSUWDEUnionKeyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEUnionKeyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdeunionkeyid = string;
        this.psuwdeunionkeyidDirtyFlag = true;
    }

    public String getPSUWDEUnionKeyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEUnionKeyId();
        }
        return this.psuwdeunionkeyid;
    }

    public boolean isPSUWDEUnionKeyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEUnionKeyIdDirty();
        }
        return this.psuwdeunionkeyidDirtyFlag;
    }

    public void resetPSUWDEUnionKeyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEUnionKeyId();
            return;
        }
        this.psuwdeunionkeyidDirtyFlag = false;
        this.psuwdeunionkeyid = null;
    }

    public void setPSUWDEUnionKeyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSUWDEUnionKeyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psuwdeunionkeyname = string;
        this.psuwdeunionkeynameDirtyFlag = true;
    }

    public String getPSUWDEUnionKeyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSUWDEUnionKeyName();
        }
        return this.psuwdeunionkeyname;
    }

    public boolean isPSUWDEUnionKeyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSUWDEUnionKeyNameDirty();
        }
        return this.psuwdeunionkeynameDirtyFlag;
    }

    public void resetPSUWDEUnionKeyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSUWDEUnionKeyName();
            return;
        }
        this.psuwdeunionkeynameDirtyFlag = false;
        this.psuwdeunionkeyname = null;
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
        PSUWDEUnionKeyBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSUWDEUnionKeyBase pSUWDEUnionKeyBase) {
        pSUWDEUnionKeyBase.resetCreateDate();
        pSUWDEUnionKeyBase.resetCreateMan();
        pSUWDEUnionKeyBase.resetKey2PSDEFId();
        pSUWDEUnionKeyBase.resetKey2PSDEFName();
        pSUWDEUnionKeyBase.resetKey3PSDEFId();
        pSUWDEUnionKeyBase.resetKey3PSDEFName();
        pSUWDEUnionKeyBase.resetKey4PSDEFId();
        pSUWDEUnionKeyBase.resetKey4PSDEFName();
        pSUWDEUnionKeyBase.resetKeyPSDEFId();
        pSUWDEUnionKeyBase.resetKeyPSDEFName();
        pSUWDEUnionKeyBase.resetPSDEId();
        pSUWDEUnionKeyBase.resetPSDynaInstId();
        pSUWDEUnionKeyBase.resetPSUWDEUnionKeyId();
        pSUWDEUnionKeyBase.resetPSUWDEUnionKeyName();
        pSUWDEUnionKeyBase.resetUpdateDate();
        pSUWDEUnionKeyBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isKey2PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY2PSDEFID, this.getKey2PSDEFId());
        }
        if (!bl || this.isKey2PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY2PSDEFNAME, this.getKey2PSDEFName());
        }
        if (!bl || this.isKey3PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY3PSDEFID, this.getKey3PSDEFId());
        }
        if (!bl || this.isKey3PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY3PSDEFNAME, this.getKey3PSDEFName());
        }
        if (!bl || this.isKey4PSDEFIdDirty()) {
            hashMap.put(FIELD_KEY4PSDEFID, this.getKey4PSDEFId());
        }
        if (!bl || this.isKey4PSDEFNameDirty()) {
            hashMap.put(FIELD_KEY4PSDEFNAME, this.getKey4PSDEFName());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSUWDEUnionKeyIdDirty()) {
            hashMap.put(FIELD_PSUWDEUNIONKEYID, this.getPSUWDEUnionKeyId());
        }
        if (!bl || this.isPSUWDEUnionKeyNameDirty()) {
            hashMap.put(FIELD_PSUWDEUNIONKEYNAME, this.getPSUWDEUnionKeyName());
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
        return PSUWDEUnionKeyBase.get(this, n);
    }

    private static Object get(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEUnionKeyBase.getCreateDate();
            }
            case 1: {
                return pSUWDEUnionKeyBase.getCreateMan();
            }
            case 2: {
                return pSUWDEUnionKeyBase.getKey2PSDEFId();
            }
            case 3: {
                return pSUWDEUnionKeyBase.getKey2PSDEFName();
            }
            case 4: {
                return pSUWDEUnionKeyBase.getKey3PSDEFId();
            }
            case 5: {
                return pSUWDEUnionKeyBase.getKey3PSDEFName();
            }
            case 6: {
                return pSUWDEUnionKeyBase.getKey4PSDEFId();
            }
            case 7: {
                return pSUWDEUnionKeyBase.getKey4PSDEFName();
            }
            case 8: {
                return pSUWDEUnionKeyBase.getKeyPSDEFId();
            }
            case 9: {
                return pSUWDEUnionKeyBase.getKeyPSDEFName();
            }
            case 10: {
                return pSUWDEUnionKeyBase.getPSDEId();
            }
            case 11: {
                return pSUWDEUnionKeyBase.getPSDynaInstId();
            }
            case 12: {
                return pSUWDEUnionKeyBase.getPSUWDEUnionKeyId();
            }
            case 13: {
                return pSUWDEUnionKeyBase.getPSUWDEUnionKeyName();
            }
            case 14: {
                return pSUWDEUnionKeyBase.getUpdateDate();
            }
            case 15: {
                return pSUWDEUnionKeyBase.getUpdateMan();
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
        PSUWDEUnionKeyBase.set(this, n, object);
    }

    private static void set(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEUnionKeyBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSUWDEUnionKeyBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSUWDEUnionKeyBase.setKey2PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSUWDEUnionKeyBase.setKey2PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSUWDEUnionKeyBase.setKey3PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSUWDEUnionKeyBase.setKey3PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSUWDEUnionKeyBase.setKey4PSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSUWDEUnionKeyBase.setKey4PSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSUWDEUnionKeyBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSUWDEUnionKeyBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSUWDEUnionKeyBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSUWDEUnionKeyBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSUWDEUnionKeyBase.setPSUWDEUnionKeyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSUWDEUnionKeyBase.setPSUWDEUnionKeyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSUWDEUnionKeyBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSUWDEUnionKeyBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSUWDEUnionKeyBase.isNull(this, n);
    }

    private static boolean isNull(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEUnionKeyBase.getCreateDate() == null;
            }
            case 1: {
                return pSUWDEUnionKeyBase.getCreateMan() == null;
            }
            case 2: {
                return pSUWDEUnionKeyBase.getKey2PSDEFId() == null;
            }
            case 3: {
                return pSUWDEUnionKeyBase.getKey2PSDEFName() == null;
            }
            case 4: {
                return pSUWDEUnionKeyBase.getKey3PSDEFId() == null;
            }
            case 5: {
                return pSUWDEUnionKeyBase.getKey3PSDEFName() == null;
            }
            case 6: {
                return pSUWDEUnionKeyBase.getKey4PSDEFId() == null;
            }
            case 7: {
                return pSUWDEUnionKeyBase.getKey4PSDEFName() == null;
            }
            case 8: {
                return pSUWDEUnionKeyBase.getKeyPSDEFId() == null;
            }
            case 9: {
                return pSUWDEUnionKeyBase.getKeyPSDEFName() == null;
            }
            case 10: {
                return pSUWDEUnionKeyBase.getPSDEId() == null;
            }
            case 11: {
                return pSUWDEUnionKeyBase.getPSDynaInstId() == null;
            }
            case 12: {
                return pSUWDEUnionKeyBase.getPSUWDEUnionKeyId() == null;
            }
            case 13: {
                return pSUWDEUnionKeyBase.getPSUWDEUnionKeyName() == null;
            }
            case 14: {
                return pSUWDEUnionKeyBase.getUpdateDate() == null;
            }
            case 15: {
                return pSUWDEUnionKeyBase.getUpdateMan() == null;
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
        return PSUWDEUnionKeyBase.contains(this, n);
    }

    private static boolean contains(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSUWDEUnionKeyBase.isCreateDateDirty();
            }
            case 1: {
                return pSUWDEUnionKeyBase.isCreateManDirty();
            }
            case 2: {
                return pSUWDEUnionKeyBase.isKey2PSDEFIdDirty();
            }
            case 3: {
                return pSUWDEUnionKeyBase.isKey2PSDEFNameDirty();
            }
            case 4: {
                return pSUWDEUnionKeyBase.isKey3PSDEFIdDirty();
            }
            case 5: {
                return pSUWDEUnionKeyBase.isKey3PSDEFNameDirty();
            }
            case 6: {
                return pSUWDEUnionKeyBase.isKey4PSDEFIdDirty();
            }
            case 7: {
                return pSUWDEUnionKeyBase.isKey4PSDEFNameDirty();
            }
            case 8: {
                return pSUWDEUnionKeyBase.isKeyPSDEFIdDirty();
            }
            case 9: {
                return pSUWDEUnionKeyBase.isKeyPSDEFNameDirty();
            }
            case 10: {
                return pSUWDEUnionKeyBase.isPSDEIdDirty();
            }
            case 11: {
                return pSUWDEUnionKeyBase.isPSDynaInstIdDirty();
            }
            case 12: {
                return pSUWDEUnionKeyBase.isPSUWDEUnionKeyIdDirty();
            }
            case 13: {
                return pSUWDEUnionKeyBase.isPSUWDEUnionKeyNameDirty();
            }
            case 14: {
                return pSUWDEUnionKeyBase.isUpdateDateDirty();
            }
            case 15: {
                return pSUWDEUnionKeyBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSUWDEUnionKeyBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSUWDEUnionKeyBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey2PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key2psdefid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey2PSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey2PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key2psdefname", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey2PSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey3PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key3psdefid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey3PSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey3PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key3psdefname", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey3PSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey4PSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key4psdefid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey4PSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKey4PSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"key4psdefname", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKey4PSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdeunionkeyid", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getPSUWDEUnionKeyId()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psuwdeunionkeyname", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getPSUWDEUnionKeyName()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSUWDEUnionKeyBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSUWDEUnionKeyBase.getJSONValue((Object)pSUWDEUnionKeyBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSUWDEUnionKeyBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSUWDEUnionKeyBase.getCreateDate() != null) {
            object = pSUWDEUnionKeyBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEUnionKeyBase.getCreateMan() != null) {
            object = pSUWDEUnionKeyBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey2PSDEFId() != null) {
            object = pSUWDEUnionKeyBase.getKey2PSDEFId();
            xmlNode.setAttribute(FIELD_KEY2PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey2PSDEFName() != null) {
            object = pSUWDEUnionKeyBase.getKey2PSDEFName();
            xmlNode.setAttribute(FIELD_KEY2PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey3PSDEFId() != null) {
            object = pSUWDEUnionKeyBase.getKey3PSDEFId();
            xmlNode.setAttribute(FIELD_KEY3PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey3PSDEFName() != null) {
            object = pSUWDEUnionKeyBase.getKey3PSDEFName();
            xmlNode.setAttribute(FIELD_KEY3PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey4PSDEFId() != null) {
            object = pSUWDEUnionKeyBase.getKey4PSDEFId();
            xmlNode.setAttribute(FIELD_KEY4PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKey4PSDEFName() != null) {
            object = pSUWDEUnionKeyBase.getKey4PSDEFName();
            xmlNode.setAttribute(FIELD_KEY4PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKeyPSDEFId() != null) {
            object = pSUWDEUnionKeyBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getKeyPSDEFName() != null) {
            object = pSUWDEUnionKeyBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getPSDEId() != null) {
            object = pSUWDEUnionKeyBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getPSDynaInstId() != null) {
            object = pSUWDEUnionKeyBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyId() != null) {
            object = pSUWDEUnionKeyBase.getPSUWDEUnionKeyId();
            xmlNode.setAttribute(FIELD_PSUWDEUNIONKEYID, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyName() != null) {
            object = pSUWDEUnionKeyBase.getPSUWDEUnionKeyName();
            xmlNode.setAttribute(FIELD_PSUWDEUNIONKEYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSUWDEUnionKeyBase.getUpdateDate() != null) {
            object = pSUWDEUnionKeyBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSUWDEUnionKeyBase.getUpdateMan() != null) {
            object = pSUWDEUnionKeyBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSUWDEUnionKeyBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSUWDEUnionKeyBase.isCreateDateDirty() && (bl || pSUWDEUnionKeyBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSUWDEUnionKeyBase.getCreateDate());
        }
        if (pSUWDEUnionKeyBase.isCreateManDirty() && (bl || pSUWDEUnionKeyBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSUWDEUnionKeyBase.getCreateMan());
        }
        if (pSUWDEUnionKeyBase.isKey2PSDEFIdDirty() && (bl || pSUWDEUnionKeyBase.getKey2PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY2PSDEFID, (Object)pSUWDEUnionKeyBase.getKey2PSDEFId());
        }
        if (pSUWDEUnionKeyBase.isKey2PSDEFNameDirty() && (bl || pSUWDEUnionKeyBase.getKey2PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY2PSDEFNAME, (Object)pSUWDEUnionKeyBase.getKey2PSDEFName());
        }
        if (pSUWDEUnionKeyBase.isKey3PSDEFIdDirty() && (bl || pSUWDEUnionKeyBase.getKey3PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY3PSDEFID, (Object)pSUWDEUnionKeyBase.getKey3PSDEFId());
        }
        if (pSUWDEUnionKeyBase.isKey3PSDEFNameDirty() && (bl || pSUWDEUnionKeyBase.getKey3PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY3PSDEFNAME, (Object)pSUWDEUnionKeyBase.getKey3PSDEFName());
        }
        if (pSUWDEUnionKeyBase.isKey4PSDEFIdDirty() && (bl || pSUWDEUnionKeyBase.getKey4PSDEFId() != null)) {
            iDataObject.set(FIELD_KEY4PSDEFID, (Object)pSUWDEUnionKeyBase.getKey4PSDEFId());
        }
        if (pSUWDEUnionKeyBase.isKey4PSDEFNameDirty() && (bl || pSUWDEUnionKeyBase.getKey4PSDEFName() != null)) {
            iDataObject.set(FIELD_KEY4PSDEFNAME, (Object)pSUWDEUnionKeyBase.getKey4PSDEFName());
        }
        if (pSUWDEUnionKeyBase.isKeyPSDEFIdDirty() && (bl || pSUWDEUnionKeyBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSUWDEUnionKeyBase.getKeyPSDEFId());
        }
        if (pSUWDEUnionKeyBase.isKeyPSDEFNameDirty() && (bl || pSUWDEUnionKeyBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSUWDEUnionKeyBase.getKeyPSDEFName());
        }
        if (pSUWDEUnionKeyBase.isPSDEIdDirty() && (bl || pSUWDEUnionKeyBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSUWDEUnionKeyBase.getPSDEId());
        }
        if (pSUWDEUnionKeyBase.isPSDynaInstIdDirty() && (bl || pSUWDEUnionKeyBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSUWDEUnionKeyBase.getPSDynaInstId());
        }
        if (pSUWDEUnionKeyBase.isPSUWDEUnionKeyIdDirty() && (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyId() != null)) {
            iDataObject.set(FIELD_PSUWDEUNIONKEYID, (Object)pSUWDEUnionKeyBase.getPSUWDEUnionKeyId());
        }
        if (pSUWDEUnionKeyBase.isPSUWDEUnionKeyNameDirty() && (bl || pSUWDEUnionKeyBase.getPSUWDEUnionKeyName() != null)) {
            iDataObject.set(FIELD_PSUWDEUNIONKEYNAME, (Object)pSUWDEUnionKeyBase.getPSUWDEUnionKeyName());
        }
        if (pSUWDEUnionKeyBase.isUpdateDateDirty() && (bl || pSUWDEUnionKeyBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSUWDEUnionKeyBase.getUpdateDate());
        }
        if (pSUWDEUnionKeyBase.isUpdateManDirty() && (bl || pSUWDEUnionKeyBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSUWDEUnionKeyBase.getUpdateMan());
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
        return PSUWDEUnionKeyBase.remove(this, n);
    }

    private static boolean remove(PSUWDEUnionKeyBase pSUWDEUnionKeyBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSUWDEUnionKeyBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSUWDEUnionKeyBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSUWDEUnionKeyBase.resetKey2PSDEFId();
                return true;
            }
            case 3: {
                pSUWDEUnionKeyBase.resetKey2PSDEFName();
                return true;
            }
            case 4: {
                pSUWDEUnionKeyBase.resetKey3PSDEFId();
                return true;
            }
            case 5: {
                pSUWDEUnionKeyBase.resetKey3PSDEFName();
                return true;
            }
            case 6: {
                pSUWDEUnionKeyBase.resetKey4PSDEFId();
                return true;
            }
            case 7: {
                pSUWDEUnionKeyBase.resetKey4PSDEFName();
                return true;
            }
            case 8: {
                pSUWDEUnionKeyBase.resetKeyPSDEFId();
                return true;
            }
            case 9: {
                pSUWDEUnionKeyBase.resetKeyPSDEFName();
                return true;
            }
            case 10: {
                pSUWDEUnionKeyBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSUWDEUnionKeyBase.resetPSDynaInstId();
                return true;
            }
            case 12: {
                pSUWDEUnionKeyBase.resetPSUWDEUnionKeyId();
                return true;
            }
            case 13: {
                pSUWDEUnionKeyBase.resetPSUWDEUnionKeyName();
                return true;
            }
            case 14: {
                pSUWDEUnionKeyBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSUWDEUnionKeyBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSUWDEUnionKeyBase getProxyEntity() {
        return this.proxyPSUWDEUnionKeyBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSUWDEUnionKeyBase = null;
        if (iDataObject != null && iDataObject instanceof PSUWDEUnionKeyBase) {
            this.proxyPSUWDEUnionKeyBase = (PSUWDEUnionKeyBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdevstudio.service.PSUWDEUnionKeyService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_KEY2PSDEFID, 2);
        fieldIndexMap.put(FIELD_KEY2PSDEFNAME, 3);
        fieldIndexMap.put(FIELD_KEY3PSDEFID, 4);
        fieldIndexMap.put(FIELD_KEY3PSDEFNAME, 5);
        fieldIndexMap.put(FIELD_KEY4PSDEFID, 6);
        fieldIndexMap.put(FIELD_KEY4PSDEFNAME, 7);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 8);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 11);
        fieldIndexMap.put(FIELD_PSUWDEUNIONKEYID, 12);
        fieldIndexMap.put(FIELD_PSUWDEUNIONKEYNAME, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
    }
}

