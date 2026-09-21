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

public abstract class PSPFPluginTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFPluginTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEMOURL = "DEMOURL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PLUGINOBJ = "PLUGINOBJ";
    public static final String FIELD_PSPFPLUGINTYPEID = "PSPFPLUGINTYPEID";
    public static final String FIELD_PSPFPLUGINTYPENAME = "PSPFPLUGINTYPENAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DEMOURL = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_ORDERVALUE = 4;
    private static final int INDEX_PLUGINOBJ = 5;
    private static final int INDEX_PSPFPLUGINTYPEID = 6;
    private static final int INDEX_PSPFPLUGINTYPENAME = 7;
    private static final int INDEX_TYPEOBJ = 8;
    private static final int INDEX_TYPEPARAMS = 9;
    private static final int INDEX_UPDATEDATE = 10;
    private static final int INDEX_UPDATEMAN = 11;
    private static final int INDEX_VALIDFLAG = 12;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFPluginTypeBase proxyPSPFPluginTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean demourlDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pluginobjDirtyFlag = false;
    private boolean pspfplugintypeidDirtyFlag = false;
    private boolean pspfplugintypenameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="demourl")
    private String demourl;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pluginobj")
    private String pluginobj;
    @Column(name="pspfplugintypeid")
    private String pspfplugintypeid;
    @Column(name="pspfplugintypename")
    private String pspfplugintypename;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;

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

    public void setDemoURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDemoURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.demourl = string;
        this.demourlDirtyFlag = true;
    }

    public String getDemoURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDemoURL();
        }
        return this.demourl;
    }

    public boolean isDemoURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDemoURLDirty();
        }
        return this.demourlDirtyFlag;
    }

    public void resetDemoURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDemoURL();
            return;
        }
        this.demourlDirtyFlag = false;
        this.demourl = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPluginObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPluginObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pluginobj = string;
        this.pluginobjDirtyFlag = true;
    }

    public String getPluginObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPluginObj();
        }
        return this.pluginobj;
    }

    public boolean isPluginObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPluginObjDirty();
        }
        return this.pluginobjDirtyFlag;
    }

    public void resetPluginObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPluginObj();
            return;
        }
        this.pluginobjDirtyFlag = false;
        this.pluginobj = null;
    }

    public void setPSPFPluginTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfplugintypeid = string;
        this.pspfplugintypeidDirtyFlag = true;
    }

    public String getPSPFPluginTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginTypeId();
        }
        return this.pspfplugintypeid;
    }

    public boolean isPSPFPluginTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginTypeIdDirty();
        }
        return this.pspfplugintypeidDirtyFlag;
    }

    public void resetPSPFPluginTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginTypeId();
            return;
        }
        this.pspfplugintypeidDirtyFlag = false;
        this.pspfplugintypeid = null;
    }

    public void setPSPFPluginTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfplugintypename = string;
        this.pspfplugintypenameDirtyFlag = true;
    }

    public String getPSPFPluginTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginTypeName();
        }
        return this.pspfplugintypename;
    }

    public boolean isPSPFPluginTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginTypeNameDirty();
        }
        return this.pspfplugintypenameDirtyFlag;
    }

    public void resetPSPFPluginTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginTypeName();
            return;
        }
        this.pspfplugintypenameDirtyFlag = false;
        this.pspfplugintypename = null;
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

    public void setTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeparams = string;
        this.typeparamsDirtyFlag = true;
    }

    public String getTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeParams();
        }
        return this.typeparams;
    }

    public boolean isTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeParamsDirty();
        }
        return this.typeparamsDirtyFlag;
    }

    public void resetTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeParams();
            return;
        }
        this.typeparamsDirtyFlag = false;
        this.typeparams = null;
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
        PSPFPluginTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFPluginTypeBase pSPFPluginTypeBase) {
        pSPFPluginTypeBase.resetCreateDate();
        pSPFPluginTypeBase.resetCreateMan();
        pSPFPluginTypeBase.resetDemoURL();
        pSPFPluginTypeBase.resetMemo();
        pSPFPluginTypeBase.resetOrderValue();
        pSPFPluginTypeBase.resetPluginObj();
        pSPFPluginTypeBase.resetPSPFPluginTypeId();
        pSPFPluginTypeBase.resetPSPFPluginTypeName();
        pSPFPluginTypeBase.resetTypeObj();
        pSPFPluginTypeBase.resetTypeParams();
        pSPFPluginTypeBase.resetUpdateDate();
        pSPFPluginTypeBase.resetUpdateMan();
        pSPFPluginTypeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDemoURLDirty()) {
            hashMap.put(FIELD_DEMOURL, this.getDemoURL());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPluginObjDirty()) {
            hashMap.put(FIELD_PLUGINOBJ, this.getPluginObj());
        }
        if (!bl || this.isPSPFPluginTypeIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINTYPEID, this.getPSPFPluginTypeId());
        }
        if (!bl || this.isPSPFPluginTypeNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINTYPENAME, this.getPSPFPluginTypeName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
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
        return PSPFPluginTypeBase.get(this, n);
    }

    private static Object get(PSPFPluginTypeBase pSPFPluginTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTypeBase.getCreateDate();
            }
            case 1: {
                return pSPFPluginTypeBase.getCreateMan();
            }
            case 2: {
                return pSPFPluginTypeBase.getDemoURL();
            }
            case 3: {
                return pSPFPluginTypeBase.getMemo();
            }
            case 4: {
                return pSPFPluginTypeBase.getOrderValue();
            }
            case 5: {
                return pSPFPluginTypeBase.getPluginObj();
            }
            case 6: {
                return pSPFPluginTypeBase.getPSPFPluginTypeId();
            }
            case 7: {
                return pSPFPluginTypeBase.getPSPFPluginTypeName();
            }
            case 8: {
                return pSPFPluginTypeBase.getTypeObj();
            }
            case 9: {
                return pSPFPluginTypeBase.getTypeParams();
            }
            case 10: {
                return pSPFPluginTypeBase.getUpdateDate();
            }
            case 11: {
                return pSPFPluginTypeBase.getUpdateMan();
            }
            case 12: {
                return pSPFPluginTypeBase.getValidFlag();
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
        PSPFPluginTypeBase.set(this, n, object);
    }

    private static void set(PSPFPluginTypeBase pSPFPluginTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPFPluginTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPFPluginTypeBase.setDemoURL(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFPluginTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFPluginTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSPFPluginTypeBase.setPluginObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFPluginTypeBase.setPSPFPluginTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPFPluginTypeBase.setPSPFPluginTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFPluginTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFPluginTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFPluginTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 11: {
                pSPFPluginTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFPluginTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPFPluginTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPFPluginTypeBase pSPFPluginTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPFPluginTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPFPluginTypeBase.getDemoURL() == null;
            }
            case 3: {
                return pSPFPluginTypeBase.getMemo() == null;
            }
            case 4: {
                return pSPFPluginTypeBase.getOrderValue() == null;
            }
            case 5: {
                return pSPFPluginTypeBase.getPluginObj() == null;
            }
            case 6: {
                return pSPFPluginTypeBase.getPSPFPluginTypeId() == null;
            }
            case 7: {
                return pSPFPluginTypeBase.getPSPFPluginTypeName() == null;
            }
            case 8: {
                return pSPFPluginTypeBase.getTypeObj() == null;
            }
            case 9: {
                return pSPFPluginTypeBase.getTypeParams() == null;
            }
            case 10: {
                return pSPFPluginTypeBase.getUpdateDate() == null;
            }
            case 11: {
                return pSPFPluginTypeBase.getUpdateMan() == null;
            }
            case 12: {
                return pSPFPluginTypeBase.getValidFlag() == null;
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
        return PSPFPluginTypeBase.contains(this, n);
    }

    private static boolean contains(PSPFPluginTypeBase pSPFPluginTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFPluginTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPFPluginTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPFPluginTypeBase.isDemoURLDirty();
            }
            case 3: {
                return pSPFPluginTypeBase.isMemoDirty();
            }
            case 4: {
                return pSPFPluginTypeBase.isOrderValueDirty();
            }
            case 5: {
                return pSPFPluginTypeBase.isPluginObjDirty();
            }
            case 6: {
                return pSPFPluginTypeBase.isPSPFPluginTypeIdDirty();
            }
            case 7: {
                return pSPFPluginTypeBase.isPSPFPluginTypeNameDirty();
            }
            case 8: {
                return pSPFPluginTypeBase.isTypeObjDirty();
            }
            case 9: {
                return pSPFPluginTypeBase.isTypeParamsDirty();
            }
            case 10: {
                return pSPFPluginTypeBase.isUpdateDateDirty();
            }
            case 11: {
                return pSPFPluginTypeBase.isUpdateManDirty();
            }
            case 12: {
                return pSPFPluginTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFPluginTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFPluginTypeBase pSPFPluginTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFPluginTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getDemoURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"demourl", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getDemoURL()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getPluginObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pluginobj", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getPluginObj()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getPSPFPluginTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfplugintypeid", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getPSPFPluginTypeId()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getPSPFPluginTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfplugintypename", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getPSPFPluginTypeName()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFPluginTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFPluginTypeBase.getJSONValue((Object)pSPFPluginTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFPluginTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFPluginTypeBase pSPFPluginTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFPluginTypeBase.getCreateDate() != null) {
            object = pSPFPluginTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginTypeBase.getCreateMan() != null) {
            object = pSPFPluginTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getDemoURL() != null) {
            object = pSPFPluginTypeBase.getDemoURL();
            xmlNode.setAttribute(FIELD_DEMOURL, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getMemo() != null) {
            object = pSPFPluginTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getOrderValue() != null) {
            object = pSPFPluginTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFPluginTypeBase.getPluginObj() != null) {
            object = pSPFPluginTypeBase.getPluginObj();
            xmlNode.setAttribute(FIELD_PLUGINOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getPSPFPluginTypeId() != null) {
            object = pSPFPluginTypeBase.getPSPFPluginTypeId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getPSPFPluginTypeName() != null) {
            object = pSPFPluginTypeBase.getPSPFPluginTypeName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getTypeObj() != null) {
            object = pSPFPluginTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getTypeParams() != null) {
            object = pSPFPluginTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getUpdateDate() != null) {
            object = pSPFPluginTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFPluginTypeBase.getUpdateMan() != null) {
            object = pSPFPluginTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFPluginTypeBase.getValidFlag() != null) {
            object = pSPFPluginTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFPluginTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFPluginTypeBase pSPFPluginTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFPluginTypeBase.isCreateDateDirty() && (bl || pSPFPluginTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFPluginTypeBase.getCreateDate());
        }
        if (pSPFPluginTypeBase.isCreateManDirty() && (bl || pSPFPluginTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFPluginTypeBase.getCreateMan());
        }
        if (pSPFPluginTypeBase.isDemoURLDirty() && (bl || pSPFPluginTypeBase.getDemoURL() != null)) {
            iDataObject.set(FIELD_DEMOURL, (Object)pSPFPluginTypeBase.getDemoURL());
        }
        if (pSPFPluginTypeBase.isMemoDirty() && (bl || pSPFPluginTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFPluginTypeBase.getMemo());
        }
        if (pSPFPluginTypeBase.isOrderValueDirty() && (bl || pSPFPluginTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPFPluginTypeBase.getOrderValue());
        }
        if (pSPFPluginTypeBase.isPluginObjDirty() && (bl || pSPFPluginTypeBase.getPluginObj() != null)) {
            iDataObject.set(FIELD_PLUGINOBJ, (Object)pSPFPluginTypeBase.getPluginObj());
        }
        if (pSPFPluginTypeBase.isPSPFPluginTypeIdDirty() && (bl || pSPFPluginTypeBase.getPSPFPluginTypeId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINTYPEID, (Object)pSPFPluginTypeBase.getPSPFPluginTypeId());
        }
        if (pSPFPluginTypeBase.isPSPFPluginTypeNameDirty() && (bl || pSPFPluginTypeBase.getPSPFPluginTypeName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINTYPENAME, (Object)pSPFPluginTypeBase.getPSPFPluginTypeName());
        }
        if (pSPFPluginTypeBase.isTypeObjDirty() && (bl || pSPFPluginTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSPFPluginTypeBase.getTypeObj());
        }
        if (pSPFPluginTypeBase.isTypeParamsDirty() && (bl || pSPFPluginTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSPFPluginTypeBase.getTypeParams());
        }
        if (pSPFPluginTypeBase.isUpdateDateDirty() && (bl || pSPFPluginTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFPluginTypeBase.getUpdateDate());
        }
        if (pSPFPluginTypeBase.isUpdateManDirty() && (bl || pSPFPluginTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFPluginTypeBase.getUpdateMan());
        }
        if (pSPFPluginTypeBase.isValidFlagDirty() && (bl || pSPFPluginTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFPluginTypeBase.getValidFlag());
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
        return PSPFPluginTypeBase.remove(this, n);
    }

    private static boolean remove(PSPFPluginTypeBase pSPFPluginTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFPluginTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPFPluginTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPFPluginTypeBase.resetDemoURL();
                return true;
            }
            case 3: {
                pSPFPluginTypeBase.resetMemo();
                return true;
            }
            case 4: {
                pSPFPluginTypeBase.resetOrderValue();
                return true;
            }
            case 5: {
                pSPFPluginTypeBase.resetPluginObj();
                return true;
            }
            case 6: {
                pSPFPluginTypeBase.resetPSPFPluginTypeId();
                return true;
            }
            case 7: {
                pSPFPluginTypeBase.resetPSPFPluginTypeName();
                return true;
            }
            case 8: {
                pSPFPluginTypeBase.resetTypeObj();
                return true;
            }
            case 9: {
                pSPFPluginTypeBase.resetTypeParams();
                return true;
            }
            case 10: {
                pSPFPluginTypeBase.resetUpdateDate();
                return true;
            }
            case 11: {
                pSPFPluginTypeBase.resetUpdateMan();
                return true;
            }
            case 12: {
                pSPFPluginTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSPFPluginTypeBase getProxyEntity() {
        return this.proxyPSPFPluginTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFPluginTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFPluginTypeBase) {
            this.proxyPSPFPluginTypeBase = (PSPFPluginTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFPluginTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DEMOURL, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_ORDERVALUE, 4);
        fieldIndexMap.put(FIELD_PLUGINOBJ, 5);
        fieldIndexMap.put(FIELD_PSPFPLUGINTYPEID, 6);
        fieldIndexMap.put(FIELD_PSPFPLUGINTYPENAME, 7);
        fieldIndexMap.put(FIELD_TYPEOBJ, 8);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 9);
        fieldIndexMap.put(FIELD_UPDATEDATE, 10);
        fieldIndexMap.put(FIELD_UPDATEMAN, 11);
        fieldIndexMap.put(FIELD_VALIDFLAG, 12);
    }
}

