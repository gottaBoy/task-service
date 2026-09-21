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
package net.ibizsys.pscore.srv.config.entity;

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

public abstract class PSPortletTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPortletTypeBase.class);
    public static final String FIELD_BASECLSPARAMS = "BASECLSPARAMS";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLE = "ENABLE";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_JITMODELOBJ = "JITMODELOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PORTLETOBJ = "PORTLETOBJ";
    public static final String FIELD_PSPORTLETTYPEID = "PSPORTLETTYPEID";
    public static final String FIELD_PSPORTLETTYPENAME = "PSPORTLETTYPENAME";
    public static final String FIELD_SYSPORTLETFLAG = "SYSPORTLETFLAG";
    public static final String FIELD_SYSPORTLETOBJ = "SYSPORTLETOBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_BASECLSPARAMS = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLE = 3;
    private static final int INDEX_JITCTRLOBJ = 4;
    private static final int INDEX_JITMODELOBJ = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PORTLETOBJ = 7;
    private static final int INDEX_PSPORTLETTYPEID = 8;
    private static final int INDEX_PSPORTLETTYPENAME = 9;
    private static final int INDEX_SYSPORTLETFLAG = 10;
    private static final int INDEX_SYSPORTLETOBJ = 11;
    private static final int INDEX_TYPEOBJ = 12;
    private static final int INDEX_UPDATEDATE = 13;
    private static final int INDEX_UPDATEMAN = 14;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPortletTypeBase proxyPSPortletTypeBase = null;
    private boolean baseclsparamsDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableDirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean jitmodelobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portletobjDirtyFlag = false;
    private boolean psportlettypeidDirtyFlag = false;
    private boolean psportlettypenameDirtyFlag = false;
    private boolean sysportletflagDirtyFlag = false;
    private boolean sysportletobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="baseclsparams")
    private String baseclsparams;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enable")
    private Integer enable;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="jitmodelobj")
    private String jitmodelobj;
    @Column(name="memo")
    private String memo;
    @Column(name="portletobj")
    private String portletobj;
    @Column(name="psportlettypeid")
    private String psportlettypeid;
    @Column(name="psportlettypename")
    private String psportlettypename;
    @Column(name="sysportletflag")
    private Integer sysportletflag;
    @Column(name="sysportletobj")
    private String sysportletobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;

    public void setBaseClsParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBaseClsParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.baseclsparams = string;
        this.baseclsparamsDirtyFlag = true;
    }

    public String getBaseClsParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBaseClsParams();
        }
        return this.baseclsparams;
    }

    public boolean isBaseClsParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBaseClsParamsDirty();
        }
        return this.baseclsparamsDirtyFlag;
    }

    public void resetBaseClsParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBaseClsParams();
            return;
        }
        this.baseclsparamsDirtyFlag = false;
        this.baseclsparams = null;
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

    public void setEnable(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnable(n);
            return;
        }
        this.enable = n;
        this.enableDirtyFlag = true;
    }

    public Integer getEnable() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnable();
        }
        return this.enable;
    }

    public boolean isEnableDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDirty();
        }
        return this.enableDirtyFlag;
    }

    public void resetEnable() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnable();
            return;
        }
        this.enableDirtyFlag = false;
        this.enable = null;
    }

    public void setJITCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj = string;
        this.jitctrlobjDirtyFlag = true;
    }

    public String getJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj();
        }
        return this.jitctrlobj;
    }

    public boolean isJITCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObjDirty();
        }
        return this.jitctrlobjDirtyFlag;
    }

    public void resetJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj();
            return;
        }
        this.jitctrlobjDirtyFlag = false;
        this.jitctrlobj = null;
    }

    public void setJITModelObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITModelObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitmodelobj = string;
        this.jitmodelobjDirtyFlag = true;
    }

    public String getJITModelObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITModelObj();
        }
        return this.jitmodelobj;
    }

    public boolean isJITModelObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITModelObjDirty();
        }
        return this.jitmodelobjDirtyFlag;
    }

    public void resetJITModelObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITModelObj();
            return;
        }
        this.jitmodelobjDirtyFlag = false;
        this.jitmodelobj = null;
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

    public void setPortletObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portletobj = string;
        this.portletobjDirtyFlag = true;
    }

    public String getPortletObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletObj();
        }
        return this.portletobj;
    }

    public boolean isPortletObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletObjDirty();
        }
        return this.portletobjDirtyFlag;
    }

    public void resetPortletObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletObj();
            return;
        }
        this.portletobjDirtyFlag = false;
        this.portletobj = null;
    }

    public void setPSPortletTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportlettypeid = string;
        this.psportlettypeidDirtyFlag = true;
    }

    public String getPSPortletTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletTypeId();
        }
        return this.psportlettypeid;
    }

    public boolean isPSPortletTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletTypeIdDirty();
        }
        return this.psportlettypeidDirtyFlag;
    }

    public void resetPSPortletTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletTypeId();
            return;
        }
        this.psportlettypeidDirtyFlag = false;
        this.psportlettypeid = null;
    }

    public void setPSPortletTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPortletTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psportlettypename = string;
        this.psportlettypenameDirtyFlag = true;
    }

    public String getPSPortletTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPortletTypeName();
        }
        return this.psportlettypename;
    }

    public boolean isPSPortletTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPortletTypeNameDirty();
        }
        return this.psportlettypenameDirtyFlag;
    }

    public void resetPSPortletTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPortletTypeName();
            return;
        }
        this.psportlettypenameDirtyFlag = false;
        this.psportlettypename = null;
    }

    public void setSysPortletFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPortletFlag(n);
            return;
        }
        this.sysportletflag = n;
        this.sysportletflagDirtyFlag = true;
    }

    public Integer getSysPortletFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPortletFlag();
        }
        return this.sysportletflag;
    }

    public boolean isSysPortletFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPortletFlagDirty();
        }
        return this.sysportletflagDirtyFlag;
    }

    public void resetSysPortletFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPortletFlag();
            return;
        }
        this.sysportletflagDirtyFlag = false;
        this.sysportletflag = null;
    }

    public void setSysPortletObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysPortletObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysportletobj = string;
        this.sysportletobjDirtyFlag = true;
    }

    public String getSysPortletObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysPortletObj();
        }
        return this.sysportletobj;
    }

    public boolean isSysPortletObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysPortletObjDirty();
        }
        return this.sysportletobjDirtyFlag;
    }

    public void resetSysPortletObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysPortletObj();
            return;
        }
        this.sysportletobjDirtyFlag = false;
        this.sysportletobj = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSPortletTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPortletTypeBase pSPortletTypeBase) {
        pSPortletTypeBase.resetBaseClsParams();
        pSPortletTypeBase.resetCreateDate();
        pSPortletTypeBase.resetCreateMan();
        pSPortletTypeBase.resetEnable();
        pSPortletTypeBase.resetJITCtrlObj();
        pSPortletTypeBase.resetJITModelObj();
        pSPortletTypeBase.resetMemo();
        pSPortletTypeBase.resetPortletObj();
        pSPortletTypeBase.resetPSPortletTypeId();
        pSPortletTypeBase.resetPSPortletTypeName();
        pSPortletTypeBase.resetSysPortletFlag();
        pSPortletTypeBase.resetSysPortletObj();
        pSPortletTypeBase.resetTypeObj();
        pSPortletTypeBase.resetUpdateDate();
        pSPortletTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBaseClsParamsDirty()) {
            hashMap.put(FIELD_BASECLSPARAMS, this.getBaseClsParams());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableDirty()) {
            hashMap.put(FIELD_ENABLE, this.getEnable());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isJITModelObjDirty()) {
            hashMap.put(FIELD_JITMODELOBJ, this.getJITModelObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPortletObjDirty()) {
            hashMap.put(FIELD_PORTLETOBJ, this.getPortletObj());
        }
        if (!bl || this.isPSPortletTypeIdDirty()) {
            hashMap.put(FIELD_PSPORTLETTYPEID, this.getPSPortletTypeId());
        }
        if (!bl || this.isPSPortletTypeNameDirty()) {
            hashMap.put(FIELD_PSPORTLETTYPENAME, this.getPSPortletTypeName());
        }
        if (!bl || this.isSysPortletFlagDirty()) {
            hashMap.put(FIELD_SYSPORTLETFLAG, this.getSysPortletFlag());
        }
        if (!bl || this.isSysPortletObjDirty()) {
            hashMap.put(FIELD_SYSPORTLETOBJ, this.getSysPortletObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSPortletTypeBase.get(this, n);
    }

    private static Object get(PSPortletTypeBase pSPortletTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletTypeBase.getBaseClsParams();
            }
            case 1: {
                return pSPortletTypeBase.getCreateDate();
            }
            case 2: {
                return pSPortletTypeBase.getCreateMan();
            }
            case 3: {
                return pSPortletTypeBase.getEnable();
            }
            case 4: {
                return pSPortletTypeBase.getJITCtrlObj();
            }
            case 5: {
                return pSPortletTypeBase.getJITModelObj();
            }
            case 6: {
                return pSPortletTypeBase.getMemo();
            }
            case 7: {
                return pSPortletTypeBase.getPortletObj();
            }
            case 8: {
                return pSPortletTypeBase.getPSPortletTypeId();
            }
            case 9: {
                return pSPortletTypeBase.getPSPortletTypeName();
            }
            case 10: {
                return pSPortletTypeBase.getSysPortletFlag();
            }
            case 11: {
                return pSPortletTypeBase.getSysPortletObj();
            }
            case 12: {
                return pSPortletTypeBase.getTypeObj();
            }
            case 13: {
                return pSPortletTypeBase.getUpdateDate();
            }
            case 14: {
                return pSPortletTypeBase.getUpdateMan();
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
        PSPortletTypeBase.set(this, n, object);
    }

    private static void set(PSPortletTypeBase pSPortletTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPortletTypeBase.setBaseClsParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPortletTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPortletTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPortletTypeBase.setEnable(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSPortletTypeBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPortletTypeBase.setJITModelObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPortletTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPortletTypeBase.setPortletObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPortletTypeBase.setPSPortletTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPortletTypeBase.setPSPortletTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPortletTypeBase.setSysPortletFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSPortletTypeBase.setSysPortletObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPortletTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPortletTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 14: {
                pSPortletTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPortletTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPortletTypeBase pSPortletTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletTypeBase.getBaseClsParams() == null;
            }
            case 1: {
                return pSPortletTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSPortletTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSPortletTypeBase.getEnable() == null;
            }
            case 4: {
                return pSPortletTypeBase.getJITCtrlObj() == null;
            }
            case 5: {
                return pSPortletTypeBase.getJITModelObj() == null;
            }
            case 6: {
                return pSPortletTypeBase.getMemo() == null;
            }
            case 7: {
                return pSPortletTypeBase.getPortletObj() == null;
            }
            case 8: {
                return pSPortletTypeBase.getPSPortletTypeId() == null;
            }
            case 9: {
                return pSPortletTypeBase.getPSPortletTypeName() == null;
            }
            case 10: {
                return pSPortletTypeBase.getSysPortletFlag() == null;
            }
            case 11: {
                return pSPortletTypeBase.getSysPortletObj() == null;
            }
            case 12: {
                return pSPortletTypeBase.getTypeObj() == null;
            }
            case 13: {
                return pSPortletTypeBase.getUpdateDate() == null;
            }
            case 14: {
                return pSPortletTypeBase.getUpdateMan() == null;
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
        return PSPortletTypeBase.contains(this, n);
    }

    private static boolean contains(PSPortletTypeBase pSPortletTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPortletTypeBase.isBaseClsParamsDirty();
            }
            case 1: {
                return pSPortletTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSPortletTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSPortletTypeBase.isEnableDirty();
            }
            case 4: {
                return pSPortletTypeBase.isJITCtrlObjDirty();
            }
            case 5: {
                return pSPortletTypeBase.isJITModelObjDirty();
            }
            case 6: {
                return pSPortletTypeBase.isMemoDirty();
            }
            case 7: {
                return pSPortletTypeBase.isPortletObjDirty();
            }
            case 8: {
                return pSPortletTypeBase.isPSPortletTypeIdDirty();
            }
            case 9: {
                return pSPortletTypeBase.isPSPortletTypeNameDirty();
            }
            case 10: {
                return pSPortletTypeBase.isSysPortletFlagDirty();
            }
            case 11: {
                return pSPortletTypeBase.isSysPortletObjDirty();
            }
            case 12: {
                return pSPortletTypeBase.isTypeObjDirty();
            }
            case 13: {
                return pSPortletTypeBase.isUpdateDateDirty();
            }
            case 14: {
                return pSPortletTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPortletTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPortletTypeBase pSPortletTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPortletTypeBase.getBaseClsParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"baseclsparams", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getBaseClsParams()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getEnable() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enable", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getEnable()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getJITModelObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitmodelobj", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getJITModelObj()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getPortletObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portletobj", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getPortletObj()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getPSPortletTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportlettypeid", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getPSPortletTypeId()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getPSPortletTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psportlettypename", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getPSPortletTypeName()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getSysPortletFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysportletflag", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getSysPortletFlag()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getSysPortletObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysportletobj", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getSysPortletObj()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPortletTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPortletTypeBase.getJSONValue((Object)pSPortletTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPortletTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPortletTypeBase pSPortletTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPortletTypeBase.getBaseClsParams() != null) {
            object = pSPortletTypeBase.getBaseClsParams();
            xmlNode.setAttribute(FIELD_BASECLSPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getCreateDate() != null) {
            object = pSPortletTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPortletTypeBase.getCreateMan() != null) {
            object = pSPortletTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getEnable() != null) {
            object = pSPortletTypeBase.getEnable();
            xmlNode.setAttribute(FIELD_ENABLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPortletTypeBase.getJITCtrlObj() != null) {
            object = pSPortletTypeBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getJITModelObj() != null) {
            object = pSPortletTypeBase.getJITModelObj();
            xmlNode.setAttribute(FIELD_JITMODELOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getMemo() != null) {
            object = pSPortletTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getPortletObj() != null) {
            object = pSPortletTypeBase.getPortletObj();
            xmlNode.setAttribute(FIELD_PORTLETOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getPSPortletTypeId() != null) {
            object = pSPortletTypeBase.getPSPortletTypeId();
            xmlNode.setAttribute(FIELD_PSPORTLETTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getPSPortletTypeName() != null) {
            object = pSPortletTypeBase.getPSPortletTypeName();
            xmlNode.setAttribute(FIELD_PSPORTLETTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getSysPortletFlag() != null) {
            object = pSPortletTypeBase.getSysPortletFlag();
            xmlNode.setAttribute(FIELD_SYSPORTLETFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPortletTypeBase.getSysPortletObj() != null) {
            object = pSPortletTypeBase.getSysPortletObj();
            xmlNode.setAttribute(FIELD_SYSPORTLETOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getTypeObj() != null) {
            object = pSPortletTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPortletTypeBase.getUpdateDate() != null) {
            object = pSPortletTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPortletTypeBase.getUpdateMan() != null) {
            object = pSPortletTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPortletTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPortletTypeBase pSPortletTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPortletTypeBase.isBaseClsParamsDirty() && (bl || pSPortletTypeBase.getBaseClsParams() != null)) {
            iDataObject.set(FIELD_BASECLSPARAMS, (Object)pSPortletTypeBase.getBaseClsParams());
        }
        if (pSPortletTypeBase.isCreateDateDirty() && (bl || pSPortletTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPortletTypeBase.getCreateDate());
        }
        if (pSPortletTypeBase.isCreateManDirty() && (bl || pSPortletTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPortletTypeBase.getCreateMan());
        }
        if (pSPortletTypeBase.isEnableDirty() && (bl || pSPortletTypeBase.getEnable() != null)) {
            iDataObject.set(FIELD_ENABLE, (Object)pSPortletTypeBase.getEnable());
        }
        if (pSPortletTypeBase.isJITCtrlObjDirty() && (bl || pSPortletTypeBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSPortletTypeBase.getJITCtrlObj());
        }
        if (pSPortletTypeBase.isJITModelObjDirty() && (bl || pSPortletTypeBase.getJITModelObj() != null)) {
            iDataObject.set(FIELD_JITMODELOBJ, (Object)pSPortletTypeBase.getJITModelObj());
        }
        if (pSPortletTypeBase.isMemoDirty() && (bl || pSPortletTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPortletTypeBase.getMemo());
        }
        if (pSPortletTypeBase.isPortletObjDirty() && (bl || pSPortletTypeBase.getPortletObj() != null)) {
            iDataObject.set(FIELD_PORTLETOBJ, (Object)pSPortletTypeBase.getPortletObj());
        }
        if (pSPortletTypeBase.isPSPortletTypeIdDirty() && (bl || pSPortletTypeBase.getPSPortletTypeId() != null)) {
            iDataObject.set(FIELD_PSPORTLETTYPEID, (Object)pSPortletTypeBase.getPSPortletTypeId());
        }
        if (pSPortletTypeBase.isPSPortletTypeNameDirty() && (bl || pSPortletTypeBase.getPSPortletTypeName() != null)) {
            iDataObject.set(FIELD_PSPORTLETTYPENAME, (Object)pSPortletTypeBase.getPSPortletTypeName());
        }
        if (pSPortletTypeBase.isSysPortletFlagDirty() && (bl || pSPortletTypeBase.getSysPortletFlag() != null)) {
            iDataObject.set(FIELD_SYSPORTLETFLAG, (Object)pSPortletTypeBase.getSysPortletFlag());
        }
        if (pSPortletTypeBase.isSysPortletObjDirty() && (bl || pSPortletTypeBase.getSysPortletObj() != null)) {
            iDataObject.set(FIELD_SYSPORTLETOBJ, (Object)pSPortletTypeBase.getSysPortletObj());
        }
        if (pSPortletTypeBase.isTypeObjDirty() && (bl || pSPortletTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSPortletTypeBase.getTypeObj());
        }
        if (pSPortletTypeBase.isUpdateDateDirty() && (bl || pSPortletTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPortletTypeBase.getUpdateDate());
        }
        if (pSPortletTypeBase.isUpdateManDirty() && (bl || pSPortletTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPortletTypeBase.getUpdateMan());
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
        return PSPortletTypeBase.remove(this, n);
    }

    private static boolean remove(PSPortletTypeBase pSPortletTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPortletTypeBase.resetBaseClsParams();
                return true;
            }
            case 1: {
                pSPortletTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPortletTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPortletTypeBase.resetEnable();
                return true;
            }
            case 4: {
                pSPortletTypeBase.resetJITCtrlObj();
                return true;
            }
            case 5: {
                pSPortletTypeBase.resetJITModelObj();
                return true;
            }
            case 6: {
                pSPortletTypeBase.resetMemo();
                return true;
            }
            case 7: {
                pSPortletTypeBase.resetPortletObj();
                return true;
            }
            case 8: {
                pSPortletTypeBase.resetPSPortletTypeId();
                return true;
            }
            case 9: {
                pSPortletTypeBase.resetPSPortletTypeName();
                return true;
            }
            case 10: {
                pSPortletTypeBase.resetSysPortletFlag();
                return true;
            }
            case 11: {
                pSPortletTypeBase.resetSysPortletObj();
                return true;
            }
            case 12: {
                pSPortletTypeBase.resetTypeObj();
                return true;
            }
            case 13: {
                pSPortletTypeBase.resetUpdateDate();
                return true;
            }
            case 14: {
                pSPortletTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPortletTypeBase getProxyEntity() {
        return this.proxyPSPortletTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPortletTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPortletTypeBase) {
            this.proxyPSPortletTypeBase = (PSPortletTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPortletTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BASECLSPARAMS, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLE, 3);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 4);
        fieldIndexMap.put(FIELD_JITMODELOBJ, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PORTLETOBJ, 7);
        fieldIndexMap.put(FIELD_PSPORTLETTYPEID, 8);
        fieldIndexMap.put(FIELD_PSPORTLETTYPENAME, 9);
        fieldIndexMap.put(FIELD_SYSPORTLETFLAG, 10);
        fieldIndexMap.put(FIELD_SYSPORTLETOBJ, 11);
        fieldIndexMap.put(FIELD_TYPEOBJ, 12);
        fieldIndexMap.put(FIELD_UPDATEDATE, 13);
        fieldIndexMap.put(FIELD_UPDATEMAN, 14);
    }
}

