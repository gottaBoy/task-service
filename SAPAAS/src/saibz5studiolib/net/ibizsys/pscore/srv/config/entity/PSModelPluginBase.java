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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelPluginBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelPluginBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DIFFOBJ = "DIFFOBJ";
    public static final String FIELD_JSCODE = "JSCODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PLUGINPARAMS = "PLUGINPARAMS";
    public static final String FIELD_PLUGINTYPE = "PLUGINTYPE";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELPLUGINID = "PSMODELPLUGINID";
    public static final String FIELD_PSMODELPLUGINNAME = "PSMODELPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DIFFOBJ = 2;
    private static final int INDEX_JSCODE = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_PLUGINPARAMS = 5;
    private static final int INDEX_PLUGINTYPE = 6;
    private static final int INDEX_PSMODELID = 7;
    private static final int INDEX_PSMODELNAME = 8;
    private static final int INDEX_PSMODELPLUGINID = 9;
    private static final int INDEX_PSMODELPLUGINNAME = 10;
    private static final int INDEX_UPDATEDATE = 11;
    private static final int INDEX_UPDATEMAN = 12;
    private static final int INDEX_VALIDFLAG = 13;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelPluginBase proxyPSModelPluginBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean diffobjDirtyFlag = false;
    private boolean jscodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pluginparamsDirtyFlag = false;
    private boolean plugintypeDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelpluginidDirtyFlag = false;
    private boolean psmodelpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="diffobj")
    private String diffobj;
    @Column(name="jscode")
    private String jscode;
    @Column(name="memo")
    private String memo;
    @Column(name="pluginparams")
    private String pluginparams;
    @Column(name="plugintype")
    private String plugintype;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelpluginid")
    private String psmodelpluginid;
    @Column(name="psmodelpluginname")
    private String psmodelpluginname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPsmodelLock = new Integer(1);
    private PSModel psmodel = null;

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

    public void setDiffObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDiffObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.diffobj = string;
        this.diffobjDirtyFlag = true;
    }

    public String getDiffObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDiffObj();
        }
        return this.diffobj;
    }

    public boolean isDiffObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDiffObjDirty();
        }
        return this.diffobjDirtyFlag;
    }

    public void resetDiffObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDiffObj();
            return;
        }
        this.diffobjDirtyFlag = false;
        this.diffobj = null;
    }

    public void setJSCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJSCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jscode = string;
        this.jscodeDirtyFlag = true;
    }

    public String getJSCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJSCode();
        }
        return this.jscode;
    }

    public boolean isJSCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJSCodeDirty();
        }
        return this.jscodeDirtyFlag;
    }

    public void resetJSCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJSCode();
            return;
        }
        this.jscodeDirtyFlag = false;
        this.jscode = null;
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

    public void setPluginParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginparams = string;
        this.pluginparamsDirtyFlag = true;
    }

    public String getPluginParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginParams();
        }
        return this.pluginparams;
    }

    public boolean isPluginParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginParamsDirty();
        }
        return this.pluginparamsDirtyFlag;
    }

    public void resetPluginParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginParams();
            return;
        }
        this.pluginparamsDirtyFlag = false;
        this.pluginparams = null;
    }

    public void setPluginType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.plugintype = string;
        this.plugintypeDirtyFlag = true;
    }

    public String getPluginType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginType();
        }
        return this.plugintype;
    }

    public boolean isPluginTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginTypeDirty();
        }
        return this.plugintypeDirtyFlag;
    }

    public void resetPluginType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginType();
            return;
        }
        this.plugintypeDirtyFlag = false;
        this.plugintype = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setPSModelPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelpluginid = string;
        this.psmodelpluginidDirtyFlag = true;
    }

    public String getPSModelPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelPluginId();
        }
        return this.psmodelpluginid;
    }

    public boolean isPSModelPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelPluginIdDirty();
        }
        return this.psmodelpluginidDirtyFlag;
    }

    public void resetPSModelPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelPluginId();
            return;
        }
        this.psmodelpluginidDirtyFlag = false;
        this.psmodelpluginid = null;
    }

    public void setPSModelPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelpluginname = string;
        this.psmodelpluginnameDirtyFlag = true;
    }

    public String getPSModelPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelPluginName();
        }
        return this.psmodelpluginname;
    }

    public boolean isPSModelPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelPluginNameDirty();
        }
        return this.psmodelpluginnameDirtyFlag;
    }

    public void resetPSModelPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelPluginName();
            return;
        }
        this.psmodelpluginnameDirtyFlag = false;
        this.psmodelpluginname = null;
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
        PSModelPluginBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelPluginBase pSModelPluginBase) {
        pSModelPluginBase.resetCreateDate();
        pSModelPluginBase.resetCreateMan();
        pSModelPluginBase.resetDiffObj();
        pSModelPluginBase.resetJSCode();
        pSModelPluginBase.resetMemo();
        pSModelPluginBase.resetPluginParams();
        pSModelPluginBase.resetPluginType();
        pSModelPluginBase.resetPSModelId();
        pSModelPluginBase.resetPSModelName();
        pSModelPluginBase.resetPSModelPluginId();
        pSModelPluginBase.resetPSModelPluginName();
        pSModelPluginBase.resetUpdateDate();
        pSModelPluginBase.resetUpdateMan();
        pSModelPluginBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDiffObjDirty()) {
            hashMap.put(FIELD_DIFFOBJ, this.getDiffObj());
        }
        if (!bl || this.isJSCodeDirty()) {
            hashMap.put(FIELD_JSCODE, this.getJSCode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPluginParamsDirty()) {
            hashMap.put(FIELD_PLUGINPARAMS, this.getPluginParams());
        }
        if (!bl || this.isPluginTypeDirty()) {
            hashMap.put(FIELD_PLUGINTYPE, this.getPluginType());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelPluginIdDirty()) {
            hashMap.put(FIELD_PSMODELPLUGINID, this.getPSModelPluginId());
        }
        if (!bl || this.isPSModelPluginNameDirty()) {
            hashMap.put(FIELD_PSMODELPLUGINNAME, this.getPSModelPluginName());
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
        return PSModelPluginBase.get(this, n);
    }

    private static Object get(PSModelPluginBase pSModelPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPluginBase.getCreateDate();
            }
            case 1: {
                return pSModelPluginBase.getCreateMan();
            }
            case 2: {
                return pSModelPluginBase.getDiffObj();
            }
            case 3: {
                return pSModelPluginBase.getJSCode();
            }
            case 4: {
                return pSModelPluginBase.getMemo();
            }
            case 5: {
                return pSModelPluginBase.getPluginParams();
            }
            case 6: {
                return pSModelPluginBase.getPluginType();
            }
            case 7: {
                return pSModelPluginBase.getPSModelId();
            }
            case 8: {
                return pSModelPluginBase.getPSModelName();
            }
            case 9: {
                return pSModelPluginBase.getPSModelPluginId();
            }
            case 10: {
                return pSModelPluginBase.getPSModelPluginName();
            }
            case 11: {
                return pSModelPluginBase.getUpdateDate();
            }
            case 12: {
                return pSModelPluginBase.getUpdateMan();
            }
            case 13: {
                return pSModelPluginBase.getValidFlag();
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
        PSModelPluginBase.set(this, n, object);
    }

    private static void set(PSModelPluginBase pSModelPluginBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelPluginBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSModelPluginBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelPluginBase.setDiffObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelPluginBase.setJSCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelPluginBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelPluginBase.setPluginParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelPluginBase.setPluginType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelPluginBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelPluginBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelPluginBase.setPSModelPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelPluginBase.setPSModelPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelPluginBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 12: {
                pSModelPluginBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelPluginBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelPluginBase.isNull(this, n);
    }

    private static boolean isNull(PSModelPluginBase pSModelPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPluginBase.getCreateDate() == null;
            }
            case 1: {
                return pSModelPluginBase.getCreateMan() == null;
            }
            case 2: {
                return pSModelPluginBase.getDiffObj() == null;
            }
            case 3: {
                return pSModelPluginBase.getJSCode() == null;
            }
            case 4: {
                return pSModelPluginBase.getMemo() == null;
            }
            case 5: {
                return pSModelPluginBase.getPluginParams() == null;
            }
            case 6: {
                return pSModelPluginBase.getPluginType() == null;
            }
            case 7: {
                return pSModelPluginBase.getPSModelId() == null;
            }
            case 8: {
                return pSModelPluginBase.getPSModelName() == null;
            }
            case 9: {
                return pSModelPluginBase.getPSModelPluginId() == null;
            }
            case 10: {
                return pSModelPluginBase.getPSModelPluginName() == null;
            }
            case 11: {
                return pSModelPluginBase.getUpdateDate() == null;
            }
            case 12: {
                return pSModelPluginBase.getUpdateMan() == null;
            }
            case 13: {
                return pSModelPluginBase.getValidFlag() == null;
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
        return PSModelPluginBase.contains(this, n);
    }

    private static boolean contains(PSModelPluginBase pSModelPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelPluginBase.isCreateDateDirty();
            }
            case 1: {
                return pSModelPluginBase.isCreateManDirty();
            }
            case 2: {
                return pSModelPluginBase.isDiffObjDirty();
            }
            case 3: {
                return pSModelPluginBase.isJSCodeDirty();
            }
            case 4: {
                return pSModelPluginBase.isMemoDirty();
            }
            case 5: {
                return pSModelPluginBase.isPluginParamsDirty();
            }
            case 6: {
                return pSModelPluginBase.isPluginTypeDirty();
            }
            case 7: {
                return pSModelPluginBase.isPSModelIdDirty();
            }
            case 8: {
                return pSModelPluginBase.isPSModelNameDirty();
            }
            case 9: {
                return pSModelPluginBase.isPSModelPluginIdDirty();
            }
            case 10: {
                return pSModelPluginBase.isPSModelPluginNameDirty();
            }
            case 11: {
                return pSModelPluginBase.isUpdateDateDirty();
            }
            case 12: {
                return pSModelPluginBase.isUpdateManDirty();
            }
            case 13: {
                return pSModelPluginBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelPluginBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelPluginBase pSModelPluginBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelPluginBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getDiffObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"diffobj", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getDiffObj()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getJSCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jscode", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getJSCode()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPluginParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginparams", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPluginParams()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPluginType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"plugintype", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPluginType()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPSModelPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelpluginid", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPSModelPluginId()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getPSModelPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelpluginname", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getPSModelPluginName()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelPluginBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelPluginBase.getJSONValue((Object)pSModelPluginBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelPluginBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelPluginBase pSModelPluginBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelPluginBase.getCreateDate() != null) {
            object = pSModelPluginBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelPluginBase.getCreateMan() != null) {
            object = pSModelPluginBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getDiffObj() != null) {
            object = pSModelPluginBase.getDiffObj();
            xmlNode.setAttribute(FIELD_DIFFOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getJSCode() != null) {
            object = pSModelPluginBase.getJSCode();
            xmlNode.setAttribute(FIELD_JSCODE, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getMemo() != null) {
            object = pSModelPluginBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPluginParams() != null) {
            object = pSModelPluginBase.getPluginParams();
            xmlNode.setAttribute(FIELD_PLUGINPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPluginType() != null) {
            object = pSModelPluginBase.getPluginType();
            xmlNode.setAttribute(FIELD_PLUGINTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPSModelId() != null) {
            object = pSModelPluginBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPSModelName() != null) {
            object = pSModelPluginBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPSModelPluginId() != null) {
            object = pSModelPluginBase.getPSModelPluginId();
            xmlNode.setAttribute(FIELD_PSMODELPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getPSModelPluginName() != null) {
            object = pSModelPluginBase.getPSModelPluginName();
            xmlNode.setAttribute(FIELD_PSMODELPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getUpdateDate() != null) {
            object = pSModelPluginBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelPluginBase.getUpdateMan() != null) {
            object = pSModelPluginBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelPluginBase.getValidFlag() != null) {
            object = pSModelPluginBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelPluginBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelPluginBase pSModelPluginBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelPluginBase.isCreateDateDirty() && (bl || pSModelPluginBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelPluginBase.getCreateDate());
        }
        if (pSModelPluginBase.isCreateManDirty() && (bl || pSModelPluginBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelPluginBase.getCreateMan());
        }
        if (pSModelPluginBase.isDiffObjDirty() && (bl || pSModelPluginBase.getDiffObj() != null)) {
            iDataObject.set(FIELD_DIFFOBJ, (Object)pSModelPluginBase.getDiffObj());
        }
        if (pSModelPluginBase.isJSCodeDirty() && (bl || pSModelPluginBase.getJSCode() != null)) {
            iDataObject.set(FIELD_JSCODE, (Object)pSModelPluginBase.getJSCode());
        }
        if (pSModelPluginBase.isMemoDirty() && (bl || pSModelPluginBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelPluginBase.getMemo());
        }
        if (pSModelPluginBase.isPluginParamsDirty() && (bl || pSModelPluginBase.getPluginParams() != null)) {
            iDataObject.set(FIELD_PLUGINPARAMS, (Object)pSModelPluginBase.getPluginParams());
        }
        if (pSModelPluginBase.isPluginTypeDirty() && (bl || pSModelPluginBase.getPluginType() != null)) {
            iDataObject.set(FIELD_PLUGINTYPE, (Object)pSModelPluginBase.getPluginType());
        }
        if (pSModelPluginBase.isPSModelIdDirty() && (bl || pSModelPluginBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelPluginBase.getPSModelId());
        }
        if (pSModelPluginBase.isPSModelNameDirty() && (bl || pSModelPluginBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelPluginBase.getPSModelName());
        }
        if (pSModelPluginBase.isPSModelPluginIdDirty() && (bl || pSModelPluginBase.getPSModelPluginId() != null)) {
            iDataObject.set(FIELD_PSMODELPLUGINID, (Object)pSModelPluginBase.getPSModelPluginId());
        }
        if (pSModelPluginBase.isPSModelPluginNameDirty() && (bl || pSModelPluginBase.getPSModelPluginName() != null)) {
            iDataObject.set(FIELD_PSMODELPLUGINNAME, (Object)pSModelPluginBase.getPSModelPluginName());
        }
        if (pSModelPluginBase.isUpdateDateDirty() && (bl || pSModelPluginBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelPluginBase.getUpdateDate());
        }
        if (pSModelPluginBase.isUpdateManDirty() && (bl || pSModelPluginBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelPluginBase.getUpdateMan());
        }
        if (pSModelPluginBase.isValidFlagDirty() && (bl || pSModelPluginBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelPluginBase.getValidFlag());
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
        return PSModelPluginBase.remove(this, n);
    }

    private static boolean remove(PSModelPluginBase pSModelPluginBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelPluginBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSModelPluginBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSModelPluginBase.resetDiffObj();
                return true;
            }
            case 3: {
                pSModelPluginBase.resetJSCode();
                return true;
            }
            case 4: {
                pSModelPluginBase.resetMemo();
                return true;
            }
            case 5: {
                pSModelPluginBase.resetPluginParams();
                return true;
            }
            case 6: {
                pSModelPluginBase.resetPluginType();
                return true;
            }
            case 7: {
                pSModelPluginBase.resetPSModelId();
                return true;
            }
            case 8: {
                pSModelPluginBase.resetPSModelName();
                return true;
            }
            case 9: {
                pSModelPluginBase.resetPSModelPluginId();
                return true;
            }
            case 10: {
                pSModelPluginBase.resetPSModelPluginName();
                return true;
            }
            case 11: {
                pSModelPluginBase.resetUpdateDate();
                return true;
            }
            case 12: {
                pSModelPluginBase.resetUpdateMan();
                return true;
            }
            case 13: {
                pSModelPluginBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPsmodel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPsmodel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPsmodelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelPluginBase getProxyEntity() {
        return this.proxyPSModelPluginBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelPluginBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelPluginBase) {
            this.proxyPSModelPluginBase = (PSModelPluginBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelPluginService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DIFFOBJ, 2);
        fieldIndexMap.put(FIELD_JSCODE, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_PLUGINPARAMS, 5);
        fieldIndexMap.put(FIELD_PLUGINTYPE, 6);
        fieldIndexMap.put(FIELD_PSMODELID, 7);
        fieldIndexMap.put(FIELD_PSMODELNAME, 8);
        fieldIndexMap.put(FIELD_PSMODELPLUGINID, 9);
        fieldIndexMap.put(FIELD_PSMODELPLUGINNAME, 10);
        fieldIndexMap.put(FIELD_UPDATEDATE, 11);
        fieldIndexMap.put(FIELD_UPDATEMAN, 12);
        fieldIndexMap.put(FIELD_VALIDFLAG, 13);
    }
}

