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
import net.ibizsys.pscore.srv.config.entity.PSSF;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSFPluginTemplBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSFPluginTemplBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSFID = "PSSFID";
    public static final String FIELD_PSSFNAME = "PSSFNAME";
    public static final String FIELD_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String FIELD_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String FIELD_PSSFPLUGINTEMPLID = "PSSFPLUGINTEMPLID";
    public static final String FIELD_PSSFPLUGINTEMPLNAME = "PSSFPLUGINTEMPLNAME";
    public static final String FIELD_TEMPLCODE = "TEMPLCODE";
    public static final String FIELD_TEMPLCODE2 = "TEMPLCODE2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_PSSFID = 3;
    private static final int INDEX_PSSFNAME = 4;
    private static final int INDEX_PSSFPLUGINID = 5;
    private static final int INDEX_PSSFPLUGINNAME = 6;
    private static final int INDEX_PSSFPLUGINTEMPLID = 7;
    private static final int INDEX_PSSFPLUGINTEMPLNAME = 8;
    private static final int INDEX_TEMPLCODE = 9;
    private static final int INDEX_TEMPLCODE2 = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSFPluginTemplBase proxyPSSFPluginTemplBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssfidDirtyFlag = false;
    private boolean pssfnameDirtyFlag = false;
    private boolean pssfpluginidDirtyFlag = false;
    private boolean pssfpluginnameDirtyFlag = false;
    private boolean pssfplugintemplidDirtyFlag = false;
    private boolean pssfplugintemplnameDirtyFlag = false;
    private boolean templcodeDirtyFlag = false;
    private boolean templcode2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssfid")
    private String pssfid;
    @Column(name="pssfname")
    private String pssfname;
    @Column(name="pssfpluginid")
    private String pssfpluginid;
    @Column(name="pssfpluginname")
    private String pssfpluginname;
    @Column(name="pssfplugintemplid")
    private String pssfplugintemplid;
    @Column(name="pssfplugintemplname")
    private String pssfplugintemplname;
    @Column(name="templcode")
    private String templcode;
    @Column(name="templcode2")
    private String templcode2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSSFPluginLock = new Integer(1);
    private PSSFPlugin pssfplugin = null;
    private Integer objPSSFLock = new Integer(1);
    private PSSF pssf = null;

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

    public void setPSSFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfid = string;
        this.pssfidDirtyFlag = true;
    }

    public String getPSSFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFId();
        }
        return this.pssfid;
    }

    public boolean isPSSFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFIdDirty();
        }
        return this.pssfidDirtyFlag;
    }

    public void resetPSSFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFId();
            return;
        }
        this.pssfidDirtyFlag = false;
        this.pssfid = null;
    }

    public void setPSSFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfname = string;
        this.pssfnameDirtyFlag = true;
    }

    public String getPSSFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFName();
        }
        return this.pssfname;
    }

    public boolean isPSSFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFNameDirty();
        }
        return this.pssfnameDirtyFlag;
    }

    public void resetPSSFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFName();
            return;
        }
        this.pssfnameDirtyFlag = false;
        this.pssfname = null;
    }

    public void setPSSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpluginid = string;
        this.pssfpluginidDirtyFlag = true;
    }

    public String getPSSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginId();
        }
        return this.pssfpluginid;
    }

    public boolean isPSSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginIdDirty();
        }
        return this.pssfpluginidDirtyFlag;
    }

    public void resetPSSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginId();
            return;
        }
        this.pssfpluginidDirtyFlag = false;
        this.pssfpluginid = null;
    }

    public void setPSSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfpluginname = string;
        this.pssfpluginnameDirtyFlag = true;
    }

    public String getPSSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginName();
        }
        return this.pssfpluginname;
    }

    public boolean isPSSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginNameDirty();
        }
        return this.pssfpluginnameDirtyFlag;
    }

    public void resetPSSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginName();
            return;
        }
        this.pssfpluginnameDirtyFlag = false;
        this.pssfpluginname = null;
    }

    public void setPSSFPluginTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfplugintemplid = string;
        this.pssfplugintemplidDirtyFlag = true;
    }

    public String getPSSFPluginTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginTemplId();
        }
        return this.pssfplugintemplid;
    }

    public boolean isPSSFPluginTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginTemplIdDirty();
        }
        return this.pssfplugintemplidDirtyFlag;
    }

    public void resetPSSFPluginTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginTemplId();
            return;
        }
        this.pssfplugintemplidDirtyFlag = false;
        this.pssfplugintemplid = null;
    }

    public void setPSSFPluginTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSFPluginTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssfplugintemplname = string;
        this.pssfplugintemplnameDirtyFlag = true;
    }

    public String getPSSFPluginTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPluginTemplName();
        }
        return this.pssfplugintemplname;
    }

    public boolean isPSSFPluginTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSFPluginTemplNameDirty();
        }
        return this.pssfplugintemplnameDirtyFlag;
    }

    public void resetPSSFPluginTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSFPluginTemplName();
            return;
        }
        this.pssfplugintemplnameDirtyFlag = false;
        this.pssfplugintemplname = null;
    }

    public void setTemplCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode = string;
        this.templcodeDirtyFlag = true;
    }

    public String getTemplCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode();
        }
        return this.templcode;
    }

    public boolean isTemplCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCodeDirty();
        }
        return this.templcodeDirtyFlag;
    }

    public void resetTemplCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode();
            return;
        }
        this.templcodeDirtyFlag = false;
        this.templcode = null;
    }

    public void setTemplCode2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplCode2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.templcode2 = string;
        this.templcode2DirtyFlag = true;
    }

    public String getTemplCode2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplCode2();
        }
        return this.templcode2;
    }

    public boolean isTemplCode2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplCode2Dirty();
        }
        return this.templcode2DirtyFlag;
    }

    public void resetTemplCode2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplCode2();
            return;
        }
        this.templcode2DirtyFlag = false;
        this.templcode2 = null;
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
        PSSFPluginTemplBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSFPluginTemplBase pSSFPluginTemplBase) {
        pSSFPluginTemplBase.resetCreateDate();
        pSSFPluginTemplBase.resetCreateMan();
        pSSFPluginTemplBase.resetMemo();
        pSSFPluginTemplBase.resetPSSFId();
        pSSFPluginTemplBase.resetPSSFName();
        pSSFPluginTemplBase.resetPSSFPluginId();
        pSSFPluginTemplBase.resetPSSFPluginName();
        pSSFPluginTemplBase.resetPSSFPluginTemplId();
        pSSFPluginTemplBase.resetPSSFPluginTemplName();
        pSSFPluginTemplBase.resetTemplCode();
        pSSFPluginTemplBase.resetTemplCode2();
        pSSFPluginTemplBase.resetUpdateDate();
        pSSFPluginTemplBase.resetUpdateMan();
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
        if (!bl || this.isPSSFIdDirty()) {
            hashMap.put(FIELD_PSSFID, this.getPSSFId());
        }
        if (!bl || this.isPSSFNameDirty()) {
            hashMap.put(FIELD_PSSFNAME, this.getPSSFName());
        }
        if (!bl || this.isPSSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSFPLUGINID, this.getPSSFPluginId());
        }
        if (!bl || this.isPSSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSFPLUGINNAME, this.getPSSFPluginName());
        }
        if (!bl || this.isPSSFPluginTemplIdDirty()) {
            hashMap.put(FIELD_PSSFPLUGINTEMPLID, this.getPSSFPluginTemplId());
        }
        if (!bl || this.isPSSFPluginTemplNameDirty()) {
            hashMap.put(FIELD_PSSFPLUGINTEMPLNAME, this.getPSSFPluginTemplName());
        }
        if (!bl || this.isTemplCodeDirty()) {
            hashMap.put(FIELD_TEMPLCODE, this.getTemplCode());
        }
        if (!bl || this.isTemplCode2Dirty()) {
            hashMap.put(FIELD_TEMPLCODE2, this.getTemplCode2());
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
        return PSSFPluginTemplBase.get(this, n);
    }

    private static Object get(PSSFPluginTemplBase pSSFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginTemplBase.getCreateDate();
            }
            case 1: {
                return pSSFPluginTemplBase.getCreateMan();
            }
            case 2: {
                return pSSFPluginTemplBase.getMemo();
            }
            case 3: {
                return pSSFPluginTemplBase.getPSSFId();
            }
            case 4: {
                return pSSFPluginTemplBase.getPSSFName();
            }
            case 5: {
                return pSSFPluginTemplBase.getPSSFPluginId();
            }
            case 6: {
                return pSSFPluginTemplBase.getPSSFPluginName();
            }
            case 7: {
                return pSSFPluginTemplBase.getPSSFPluginTemplId();
            }
            case 8: {
                return pSSFPluginTemplBase.getPSSFPluginTemplName();
            }
            case 9: {
                return pSSFPluginTemplBase.getTemplCode();
            }
            case 10: {
                return pSSFPluginTemplBase.getTemplCode2();
            }
            case 11: {
                return pSSFPluginTemplBase.getUpdateDate();
            }
            case 12: {
                return pSSFPluginTemplBase.getUpdateMan();
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
        PSSFPluginTemplBase.set(this, n, object);
    }

    private static void set(PSSFPluginTemplBase pSSFPluginTemplBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSFPluginTemplBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSFPluginTemplBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSFPluginTemplBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSFPluginTemplBase.setPSSFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSFPluginTemplBase.setPSSFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSFPluginTemplBase.setPSSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSFPluginTemplBase.setPSSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSFPluginTemplBase.setPSSFPluginTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSFPluginTemplBase.setPSSFPluginTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSFPluginTemplBase.setTemplCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSFPluginTemplBase.setTemplCode2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSFPluginTemplBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSSFPluginTemplBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSSFPluginTemplBase.isNull(this, n);
    }

    private static boolean isNull(PSSFPluginTemplBase pSSFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginTemplBase.getCreateDate() == null;
            }
            case 1: {
                return pSSFPluginTemplBase.getCreateMan() == null;
            }
            case 2: {
                return pSSFPluginTemplBase.getMemo() == null;
            }
            case 3: {
                return pSSFPluginTemplBase.getPSSFId() == null;
            }
            case 4: {
                return pSSFPluginTemplBase.getPSSFName() == null;
            }
            case 5: {
                return pSSFPluginTemplBase.getPSSFPluginId() == null;
            }
            case 6: {
                return pSSFPluginTemplBase.getPSSFPluginName() == null;
            }
            case 7: {
                return pSSFPluginTemplBase.getPSSFPluginTemplId() == null;
            }
            case 8: {
                return pSSFPluginTemplBase.getPSSFPluginTemplName() == null;
            }
            case 9: {
                return pSSFPluginTemplBase.getTemplCode() == null;
            }
            case 10: {
                return pSSFPluginTemplBase.getTemplCode2() == null;
            }
            case 11: {
                return pSSFPluginTemplBase.getUpdateDate() == null;
            }
            case 12: {
                return pSSFPluginTemplBase.getUpdateMan() == null;
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
        return PSSFPluginTemplBase.contains(this, n);
    }

    private static boolean contains(PSSFPluginTemplBase pSSFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSFPluginTemplBase.isCreateDateDirty();
            }
            case 1: {
                return pSSFPluginTemplBase.isCreateManDirty();
            }
            case 2: {
                return pSSFPluginTemplBase.isMemoDirty();
            }
            case 3: {
                return pSSFPluginTemplBase.isPSSFIdDirty();
            }
            case 4: {
                return pSSFPluginTemplBase.isPSSFNameDirty();
            }
            case 5: {
                return pSSFPluginTemplBase.isPSSFPluginIdDirty();
            }
            case 6: {
                return pSSFPluginTemplBase.isPSSFPluginNameDirty();
            }
            case 7: {
                return pSSFPluginTemplBase.isPSSFPluginTemplIdDirty();
            }
            case 8: {
                return pSSFPluginTemplBase.isPSSFPluginTemplNameDirty();
            }
            case 9: {
                return pSSFPluginTemplBase.isTemplCodeDirty();
            }
            case 10: {
                return pSSFPluginTemplBase.isTemplCode2Dirty();
            }
            case 11: {
                return pSSFPluginTemplBase.isUpdateDateDirty();
            }
            case 12: {
                return pSSFPluginTemplBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSFPluginTemplBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSFPluginTemplBase pSSFPluginTemplBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSFPluginTemplBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getMemo()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfid", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFId()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfname", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFName()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginid", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFPluginId()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginname", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFPluginName()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfplugintemplid", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFPluginTemplId()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfplugintemplname", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getPSSFPluginTemplName()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getTemplCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getTemplCode()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getTemplCode2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templcode2", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getTemplCode2()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSFPluginTemplBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSFPluginTemplBase.getJSONValue((Object)pSSFPluginTemplBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSFPluginTemplBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSFPluginTemplBase pSSFPluginTemplBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSFPluginTemplBase.getCreateDate() != null) {
            object = pSSFPluginTemplBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPluginTemplBase.getCreateMan() != null) {
            object = pSSFPluginTemplBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getMemo() != null) {
            object = pSSFPluginTemplBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFId() != null) {
            object = pSSFPluginTemplBase.getPSSFId();
            xmlNode.setAttribute(FIELD_PSSFID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFName() != null) {
            object = pSSFPluginTemplBase.getPSSFName();
            xmlNode.setAttribute(FIELD_PSSFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginId() != null) {
            object = pSSFPluginTemplBase.getPSSFPluginId();
            xmlNode.setAttribute(FIELD_PSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginName() != null) {
            object = pSSFPluginTemplBase.getPSSFPluginName();
            xmlNode.setAttribute(FIELD_PSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginTemplId() != null) {
            object = pSSFPluginTemplBase.getPSSFPluginTemplId();
            xmlNode.setAttribute(FIELD_PSSFPLUGINTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getPSSFPluginTemplName() != null) {
            object = pSSFPluginTemplBase.getPSSFPluginTemplName();
            xmlNode.setAttribute(FIELD_PSSFPLUGINTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getTemplCode() != null) {
            object = pSSFPluginTemplBase.getTemplCode();
            xmlNode.setAttribute(FIELD_TEMPLCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getTemplCode2() != null) {
            object = pSSFPluginTemplBase.getTemplCode2();
            xmlNode.setAttribute(FIELD_TEMPLCODE2, object == null ? "" : (String)object);
        }
        if (bl || pSSFPluginTemplBase.getUpdateDate() != null) {
            object = pSSFPluginTemplBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSFPluginTemplBase.getUpdateMan() != null) {
            object = pSSFPluginTemplBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSFPluginTemplBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSFPluginTemplBase pSSFPluginTemplBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSFPluginTemplBase.isCreateDateDirty() && (bl || pSSFPluginTemplBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSFPluginTemplBase.getCreateDate());
        }
        if (pSSFPluginTemplBase.isCreateManDirty() && (bl || pSSFPluginTemplBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSFPluginTemplBase.getCreateMan());
        }
        if (pSSFPluginTemplBase.isMemoDirty() && (bl || pSSFPluginTemplBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSFPluginTemplBase.getMemo());
        }
        if (pSSFPluginTemplBase.isPSSFIdDirty() && (bl || pSSFPluginTemplBase.getPSSFId() != null)) {
            iDataObject.set(FIELD_PSSFID, (Object)pSSFPluginTemplBase.getPSSFId());
        }
        if (pSSFPluginTemplBase.isPSSFNameDirty() && (bl || pSSFPluginTemplBase.getPSSFName() != null)) {
            iDataObject.set(FIELD_PSSFNAME, (Object)pSSFPluginTemplBase.getPSSFName());
        }
        if (pSSFPluginTemplBase.isPSSFPluginIdDirty() && (bl || pSSFPluginTemplBase.getPSSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINID, (Object)pSSFPluginTemplBase.getPSSFPluginId());
        }
        if (pSSFPluginTemplBase.isPSSFPluginNameDirty() && (bl || pSSFPluginTemplBase.getPSSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINNAME, (Object)pSSFPluginTemplBase.getPSSFPluginName());
        }
        if (pSSFPluginTemplBase.isPSSFPluginTemplIdDirty() && (bl || pSSFPluginTemplBase.getPSSFPluginTemplId() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINTEMPLID, (Object)pSSFPluginTemplBase.getPSSFPluginTemplId());
        }
        if (pSSFPluginTemplBase.isPSSFPluginTemplNameDirty() && (bl || pSSFPluginTemplBase.getPSSFPluginTemplName() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINTEMPLNAME, (Object)pSSFPluginTemplBase.getPSSFPluginTemplName());
        }
        if (pSSFPluginTemplBase.isTemplCodeDirty() && (bl || pSSFPluginTemplBase.getTemplCode() != null)) {
            iDataObject.set(FIELD_TEMPLCODE, (Object)pSSFPluginTemplBase.getTemplCode());
        }
        if (pSSFPluginTemplBase.isTemplCode2Dirty() && (bl || pSSFPluginTemplBase.getTemplCode2() != null)) {
            iDataObject.set(FIELD_TEMPLCODE2, (Object)pSSFPluginTemplBase.getTemplCode2());
        }
        if (pSSFPluginTemplBase.isUpdateDateDirty() && (bl || pSSFPluginTemplBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSFPluginTemplBase.getUpdateDate());
        }
        if (pSSFPluginTemplBase.isUpdateManDirty() && (bl || pSSFPluginTemplBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSFPluginTemplBase.getUpdateMan());
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
        return PSSFPluginTemplBase.remove(this, n);
    }

    private static boolean remove(PSSFPluginTemplBase pSSFPluginTemplBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSFPluginTemplBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSFPluginTemplBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSFPluginTemplBase.resetMemo();
                return true;
            }
            case 3: {
                pSSFPluginTemplBase.resetPSSFId();
                return true;
            }
            case 4: {
                pSSFPluginTemplBase.resetPSSFName();
                return true;
            }
            case 5: {
                pSSFPluginTemplBase.resetPSSFPluginId();
                return true;
            }
            case 6: {
                pSSFPluginTemplBase.resetPSSFPluginName();
                return true;
            }
            case 7: {
                pSSFPluginTemplBase.resetPSSFPluginTemplId();
                return true;
            }
            case 8: {
                pSSFPluginTemplBase.resetPSSFPluginTemplName();
                return true;
            }
            case 9: {
                pSSFPluginTemplBase.resetTemplCode();
                return true;
            }
            case 10: {
                pSSFPluginTemplBase.resetTemplCode2();
                return true;
            }
            case 11: {
                pSSFPluginTemplBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSSFPluginTemplBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSFPlugin getPSSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPlugin();
        }
        if (this.getPSSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSFPluginLock;
        synchronized (n) {
            if (this.pssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFPluginId(), (Object)this.pssfplugin.getPSSFPluginId()) != 0L) {
                this.pssfplugin = null;
            }
            if (this.pssfplugin == null) {
                PSSFPlugin pSSFPlugin = new PSSFPlugin();
                pSSFPlugin.setPSSFPluginId(this.getPSSFPluginId());
                PSSFPluginService pSSFPluginService = (PSSFPluginService)ServiceGlobal.getService(PSSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSFPluginService.autoGet(pSSFPlugin);
                this.pssfplugin = pSSFPlugin;
            }
            return this.pssfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSF getPSSF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSF();
        }
        if (this.getPSSFId() == null) {
            return null;
        }
        Integer n = this.objPSSFLock;
        synchronized (n) {
            if (this.pssf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSFId(), (Object)this.pssf.getPSSFId()) != 0L) {
                this.pssf = null;
            }
            if (this.pssf == null) {
                PSSF pSSF = new PSSF();
                pSSF.setPSSFId(this.getPSSFId());
                PSSFService pSSFService = (PSSFService)ServiceGlobal.getService(PSSFService.class, (SessionFactory)this.getSessionFactory());
                pSSFService.autoGet(pSSF);
                this.pssf = pSSF;
            }
            return this.pssf;
        }
    }

    private PSSFPluginTemplBase getProxyEntity() {
        return this.proxyPSSFPluginTemplBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSFPluginTemplBase = null;
        if (iDataObject != null && iDataObject instanceof PSSFPluginTemplBase) {
            this.proxyPSSFPluginTemplBase = (PSSFPluginTemplBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSSFPluginTemplService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_PSSFID, 3);
        fieldIndexMap.put(FIELD_PSSFNAME, 4);
        fieldIndexMap.put(FIELD_PSSFPLUGINID, 5);
        fieldIndexMap.put(FIELD_PSSFPLUGINNAME, 6);
        fieldIndexMap.put(FIELD_PSSFPLUGINTEMPLID, 7);
        fieldIndexMap.put(FIELD_PSSFPLUGINTEMPLNAME, 8);
        fieldIndexMap.put(FIELD_TEMPLCODE, 9);
        fieldIndexMap.put(FIELD_TEMPLCODE2, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
    }
}

