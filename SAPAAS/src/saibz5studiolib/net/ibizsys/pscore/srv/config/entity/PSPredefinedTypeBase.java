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
import net.ibizsys.pscore.srv.config.entity.PSPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSFPlugin;
import net.ibizsys.pscore.srv.config.service.PSPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPredefinedTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPredefinedTypeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PSPFPLUGINID = "PSPFPLUGINID";
    public static final String FIELD_PSPFPLUGINNAME = "PSPFPLUGINNAME";
    public static final String FIELD_PSPREDEFINEDTYPEID = "PSPREDEFINEDTYPEID";
    public static final String FIELD_PSPREDEFINEDTYPENAME = "PSPREDEFINEDTYPENAME";
    public static final String FIELD_PSSFPLUGINID = "PSSFPLUGINID";
    public static final String FIELD_PSSFPLUGINNAME = "PSSFPLUGINNAME";
    public static final String FIELD_TYPEPARAMS = "TYPEPARAMS";
    public static final String FIELD_TYPETAG = "TYPETAG";
    public static final String FIELD_TYPETAG2 = "TYPETAG2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USAGEMODE = "USAGEMODE";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_MEMO = 2;
    private static final int INDEX_ORDERVALUE = 3;
    private static final int INDEX_PREDEFINEDTYPE = 4;
    private static final int INDEX_PSPFPLUGINID = 5;
    private static final int INDEX_PSPFPLUGINNAME = 6;
    private static final int INDEX_PSPREDEFINEDTYPEID = 7;
    private static final int INDEX_PSPREDEFINEDTYPENAME = 8;
    private static final int INDEX_PSSFPLUGINID = 9;
    private static final int INDEX_PSSFPLUGINNAME = 10;
    private static final int INDEX_TYPEPARAMS = 11;
    private static final int INDEX_TYPETAG = 12;
    private static final int INDEX_TYPETAG2 = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USAGEMODE = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPredefinedTypeBase proxyPSPredefinedTypeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean pspfpluginidDirtyFlag = false;
    private boolean pspfpluginnameDirtyFlag = false;
    private boolean pspredefinedtypeidDirtyFlag = false;
    private boolean pspredefinedtypenameDirtyFlag = false;
    private boolean pssfpluginidDirtyFlag = false;
    private boolean pssfpluginnameDirtyFlag = false;
    private boolean typeparamsDirtyFlag = false;
    private boolean typetagDirtyFlag = false;
    private boolean typetag2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usagemodeDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="pspfpluginid")
    private String pspfpluginid;
    @Column(name="pspfpluginname")
    private String pspfpluginname;
    @Column(name="pspredefinedtypeid")
    private String pspredefinedtypeid;
    @Column(name="pspredefinedtypename")
    private String pspredefinedtypename;
    @Column(name="pssfpluginid")
    private String pssfpluginid;
    @Column(name="pssfpluginname")
    private String pssfpluginname;
    @Column(name="typeparams")
    private String typeparams;
    @Column(name="typetag")
    private String typetag;
    @Column(name="typetag2")
    private String typetag2;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usagemode")
    private String usagemode;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSPFPluginLock = new Integer(1);
    private PSPFPlugin pspfplugin = null;
    private Integer objPSSFPluginLock = new Integer(1);
    private PSSFPlugin pssfplugin = null;

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

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPSPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginid = string;
        this.pspfpluginidDirtyFlag = true;
    }

    public String getPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginId();
        }
        return this.pspfpluginid;
    }

    public boolean isPSPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginIdDirty();
        }
        return this.pspfpluginidDirtyFlag;
    }

    public void resetPSPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginId();
            return;
        }
        this.pspfpluginidDirtyFlag = false;
        this.pspfpluginid = null;
    }

    public void setPSPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfpluginname = string;
        this.pspfpluginnameDirtyFlag = true;
    }

    public String getPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPluginName();
        }
        return this.pspfpluginname;
    }

    public boolean isPSPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFPluginNameDirty();
        }
        return this.pspfpluginnameDirtyFlag;
    }

    public void resetPSPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFPluginName();
            return;
        }
        this.pspfpluginnameDirtyFlag = false;
        this.pspfpluginname = null;
    }

    public void setPSPredefinedTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPredefinedTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspredefinedtypeid = string;
        this.pspredefinedtypeidDirtyFlag = true;
    }

    public String getPSPredefinedTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPredefinedTypeId();
        }
        return this.pspredefinedtypeid;
    }

    public boolean isPSPredefinedTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPredefinedTypeIdDirty();
        }
        return this.pspredefinedtypeidDirtyFlag;
    }

    public void resetPSPredefinedTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPredefinedTypeId();
            return;
        }
        this.pspredefinedtypeidDirtyFlag = false;
        this.pspredefinedtypeid = null;
    }

    public void setPSPredefinedTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPredefinedTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspredefinedtypename = string;
        this.pspredefinedtypenameDirtyFlag = true;
    }

    public String getPSPredefinedTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPredefinedTypeName();
        }
        return this.pspredefinedtypename;
    }

    public boolean isPSPredefinedTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPredefinedTypeNameDirty();
        }
        return this.pspredefinedtypenameDirtyFlag;
    }

    public void resetPSPredefinedTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPredefinedTypeName();
            return;
        }
        this.pspredefinedtypenameDirtyFlag = false;
        this.pspredefinedtypename = null;
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

    public void setTypeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typetag = string;
        this.typetagDirtyFlag = true;
    }

    public String getTypeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeTag();
        }
        return this.typetag;
    }

    public boolean isTypeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeTagDirty();
        }
        return this.typetagDirtyFlag;
    }

    public void resetTypeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeTag();
            return;
        }
        this.typetagDirtyFlag = false;
        this.typetag = null;
    }

    public void setTypeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typetag2 = string;
        this.typetag2DirtyFlag = true;
    }

    public String getTypeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeTag2();
        }
        return this.typetag2;
    }

    public boolean isTypeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeTag2Dirty();
        }
        return this.typetag2DirtyFlag;
    }

    public void resetTypeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeTag2();
            return;
        }
        this.typetag2DirtyFlag = false;
        this.typetag2 = null;
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

    public void setUsageMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUsageMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usagemode = string;
        this.usagemodeDirtyFlag = true;
    }

    public String getUsageMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUsageMode();
        }
        return this.usagemode;
    }

    public boolean isUsageModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUsageModeDirty();
        }
        return this.usagemodeDirtyFlag;
    }

    public void resetUsageMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUsageMode();
            return;
        }
        this.usagemodeDirtyFlag = false;
        this.usagemode = null;
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
        PSPredefinedTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPredefinedTypeBase pSPredefinedTypeBase) {
        pSPredefinedTypeBase.resetCreateDate();
        pSPredefinedTypeBase.resetCreateMan();
        pSPredefinedTypeBase.resetMemo();
        pSPredefinedTypeBase.resetOrderValue();
        pSPredefinedTypeBase.resetPredefinedType();
        pSPredefinedTypeBase.resetPSPFPluginId();
        pSPredefinedTypeBase.resetPSPFPluginName();
        pSPredefinedTypeBase.resetPSPredefinedTypeId();
        pSPredefinedTypeBase.resetPSPredefinedTypeName();
        pSPredefinedTypeBase.resetPSSFPluginId();
        pSPredefinedTypeBase.resetPSSFPluginName();
        pSPredefinedTypeBase.resetTypeParams();
        pSPredefinedTypeBase.resetTypeTag();
        pSPredefinedTypeBase.resetTypeTag2();
        pSPredefinedTypeBase.resetUpdateDate();
        pSPredefinedTypeBase.resetUpdateMan();
        pSPredefinedTypeBase.resetUsageMode();
        pSPredefinedTypeBase.resetValidFlag();
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
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPSPFPluginIdDirty()) {
            hashMap.put(FIELD_PSPFPLUGINID, this.getPSPFPluginId());
        }
        if (!bl || this.isPSPFPluginNameDirty()) {
            hashMap.put(FIELD_PSPFPLUGINNAME, this.getPSPFPluginName());
        }
        if (!bl || this.isPSPredefinedTypeIdDirty()) {
            hashMap.put(FIELD_PSPREDEFINEDTYPEID, this.getPSPredefinedTypeId());
        }
        if (!bl || this.isPSPredefinedTypeNameDirty()) {
            hashMap.put(FIELD_PSPREDEFINEDTYPENAME, this.getPSPredefinedTypeName());
        }
        if (!bl || this.isPSSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSFPLUGINID, this.getPSSFPluginId());
        }
        if (!bl || this.isPSSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSFPLUGINNAME, this.getPSSFPluginName());
        }
        if (!bl || this.isTypeParamsDirty()) {
            hashMap.put(FIELD_TYPEPARAMS, this.getTypeParams());
        }
        if (!bl || this.isTypeTagDirty()) {
            hashMap.put(FIELD_TYPETAG, this.getTypeTag());
        }
        if (!bl || this.isTypeTag2Dirty()) {
            hashMap.put(FIELD_TYPETAG2, this.getTypeTag2());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUsageModeDirty()) {
            hashMap.put(FIELD_USAGEMODE, this.getUsageMode());
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
        return PSPredefinedTypeBase.get(this, n);
    }

    private static Object get(PSPredefinedTypeBase pSPredefinedTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPredefinedTypeBase.getCreateDate();
            }
            case 1: {
                return pSPredefinedTypeBase.getCreateMan();
            }
            case 2: {
                return pSPredefinedTypeBase.getMemo();
            }
            case 3: {
                return pSPredefinedTypeBase.getOrderValue();
            }
            case 4: {
                return pSPredefinedTypeBase.getPredefinedType();
            }
            case 5: {
                return pSPredefinedTypeBase.getPSPFPluginId();
            }
            case 6: {
                return pSPredefinedTypeBase.getPSPFPluginName();
            }
            case 7: {
                return pSPredefinedTypeBase.getPSPredefinedTypeId();
            }
            case 8: {
                return pSPredefinedTypeBase.getPSPredefinedTypeName();
            }
            case 9: {
                return pSPredefinedTypeBase.getPSSFPluginId();
            }
            case 10: {
                return pSPredefinedTypeBase.getPSSFPluginName();
            }
            case 11: {
                return pSPredefinedTypeBase.getTypeParams();
            }
            case 12: {
                return pSPredefinedTypeBase.getTypeTag();
            }
            case 13: {
                return pSPredefinedTypeBase.getTypeTag2();
            }
            case 14: {
                return pSPredefinedTypeBase.getUpdateDate();
            }
            case 15: {
                return pSPredefinedTypeBase.getUpdateMan();
            }
            case 16: {
                return pSPredefinedTypeBase.getUsageMode();
            }
            case 17: {
                return pSPredefinedTypeBase.getValidFlag();
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
        PSPredefinedTypeBase.set(this, n, object);
    }

    private static void set(PSPredefinedTypeBase pSPredefinedTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPredefinedTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPredefinedTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPredefinedTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPredefinedTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSPredefinedTypeBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPredefinedTypeBase.setPSPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPredefinedTypeBase.setPSPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPredefinedTypeBase.setPSPredefinedTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPredefinedTypeBase.setPSPredefinedTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPredefinedTypeBase.setPSSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPredefinedTypeBase.setPSSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPredefinedTypeBase.setTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPredefinedTypeBase.setTypeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPredefinedTypeBase.setTypeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPredefinedTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSPredefinedTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPredefinedTypeBase.setUsageMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPredefinedTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSPredefinedTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSPredefinedTypeBase pSPredefinedTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPredefinedTypeBase.getCreateDate() == null;
            }
            case 1: {
                return pSPredefinedTypeBase.getCreateMan() == null;
            }
            case 2: {
                return pSPredefinedTypeBase.getMemo() == null;
            }
            case 3: {
                return pSPredefinedTypeBase.getOrderValue() == null;
            }
            case 4: {
                return pSPredefinedTypeBase.getPredefinedType() == null;
            }
            case 5: {
                return pSPredefinedTypeBase.getPSPFPluginId() == null;
            }
            case 6: {
                return pSPredefinedTypeBase.getPSPFPluginName() == null;
            }
            case 7: {
                return pSPredefinedTypeBase.getPSPredefinedTypeId() == null;
            }
            case 8: {
                return pSPredefinedTypeBase.getPSPredefinedTypeName() == null;
            }
            case 9: {
                return pSPredefinedTypeBase.getPSSFPluginId() == null;
            }
            case 10: {
                return pSPredefinedTypeBase.getPSSFPluginName() == null;
            }
            case 11: {
                return pSPredefinedTypeBase.getTypeParams() == null;
            }
            case 12: {
                return pSPredefinedTypeBase.getTypeTag() == null;
            }
            case 13: {
                return pSPredefinedTypeBase.getTypeTag2() == null;
            }
            case 14: {
                return pSPredefinedTypeBase.getUpdateDate() == null;
            }
            case 15: {
                return pSPredefinedTypeBase.getUpdateMan() == null;
            }
            case 16: {
                return pSPredefinedTypeBase.getUsageMode() == null;
            }
            case 17: {
                return pSPredefinedTypeBase.getValidFlag() == null;
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
        return PSPredefinedTypeBase.contains(this, n);
    }

    private static boolean contains(PSPredefinedTypeBase pSPredefinedTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPredefinedTypeBase.isCreateDateDirty();
            }
            case 1: {
                return pSPredefinedTypeBase.isCreateManDirty();
            }
            case 2: {
                return pSPredefinedTypeBase.isMemoDirty();
            }
            case 3: {
                return pSPredefinedTypeBase.isOrderValueDirty();
            }
            case 4: {
                return pSPredefinedTypeBase.isPredefinedTypeDirty();
            }
            case 5: {
                return pSPredefinedTypeBase.isPSPFPluginIdDirty();
            }
            case 6: {
                return pSPredefinedTypeBase.isPSPFPluginNameDirty();
            }
            case 7: {
                return pSPredefinedTypeBase.isPSPredefinedTypeIdDirty();
            }
            case 8: {
                return pSPredefinedTypeBase.isPSPredefinedTypeNameDirty();
            }
            case 9: {
                return pSPredefinedTypeBase.isPSSFPluginIdDirty();
            }
            case 10: {
                return pSPredefinedTypeBase.isPSSFPluginNameDirty();
            }
            case 11: {
                return pSPredefinedTypeBase.isTypeParamsDirty();
            }
            case 12: {
                return pSPredefinedTypeBase.isTypeTagDirty();
            }
            case 13: {
                return pSPredefinedTypeBase.isTypeTag2Dirty();
            }
            case 14: {
                return pSPredefinedTypeBase.isUpdateDateDirty();
            }
            case 15: {
                return pSPredefinedTypeBase.isUpdateManDirty();
            }
            case 16: {
                return pSPredefinedTypeBase.isUsageModeDirty();
            }
            case 17: {
                return pSPredefinedTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPredefinedTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPredefinedTypeBase pSPredefinedTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPredefinedTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginid", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSPFPluginId()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfpluginname", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSPFPluginName()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSPredefinedTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspredefinedtypeid", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSPredefinedTypeId()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSPredefinedTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspredefinedtypename", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSPredefinedTypeName()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginid", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSSFPluginId()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getPSSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssfpluginname", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getPSSFPluginName()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeparams", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getTypeParams()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getTypeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typetag", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getTypeTag()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getTypeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typetag2", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getTypeTag2()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getUsageMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usagemode", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getUsageMode()), (boolean)false);
        }
        if (bl || pSPredefinedTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPredefinedTypeBase.getJSONValue((Object)pSPredefinedTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPredefinedTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPredefinedTypeBase pSPredefinedTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPredefinedTypeBase.getCreateDate() != null) {
            object = pSPredefinedTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPredefinedTypeBase.getCreateMan() != null) {
            object = pSPredefinedTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getMemo() != null) {
            object = pSPredefinedTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getOrderValue() != null) {
            object = pSPredefinedTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPredefinedTypeBase.getPredefinedType() != null) {
            object = pSPredefinedTypeBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSPFPluginId() != null) {
            object = pSPredefinedTypeBase.getPSPFPluginId();
            xmlNode.setAttribute(FIELD_PSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSPFPluginName() != null) {
            object = pSPredefinedTypeBase.getPSPFPluginName();
            xmlNode.setAttribute(FIELD_PSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSPredefinedTypeId() != null) {
            object = pSPredefinedTypeBase.getPSPredefinedTypeId();
            xmlNode.setAttribute(FIELD_PSPREDEFINEDTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSPredefinedTypeName() != null) {
            object = pSPredefinedTypeBase.getPSPredefinedTypeName();
            xmlNode.setAttribute(FIELD_PSPREDEFINEDTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSSFPluginId() != null) {
            object = pSPredefinedTypeBase.getPSSFPluginId();
            xmlNode.setAttribute(FIELD_PSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getPSSFPluginName() != null) {
            object = pSPredefinedTypeBase.getPSSFPluginName();
            xmlNode.setAttribute(FIELD_PSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getTypeParams() != null) {
            object = pSPredefinedTypeBase.getTypeParams();
            xmlNode.setAttribute(FIELD_TYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getTypeTag() != null) {
            object = pSPredefinedTypeBase.getTypeTag();
            xmlNode.setAttribute(FIELD_TYPETAG, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getTypeTag2() != null) {
            object = pSPredefinedTypeBase.getTypeTag2();
            xmlNode.setAttribute(FIELD_TYPETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getUpdateDate() != null) {
            object = pSPredefinedTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPredefinedTypeBase.getUpdateMan() != null) {
            object = pSPredefinedTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getUsageMode() != null) {
            object = pSPredefinedTypeBase.getUsageMode();
            xmlNode.setAttribute(FIELD_USAGEMODE, object == null ? "" : (String)object);
        }
        if (bl || pSPredefinedTypeBase.getValidFlag() != null) {
            object = pSPredefinedTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPredefinedTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPredefinedTypeBase pSPredefinedTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPredefinedTypeBase.isCreateDateDirty() && (bl || pSPredefinedTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPredefinedTypeBase.getCreateDate());
        }
        if (pSPredefinedTypeBase.isCreateManDirty() && (bl || pSPredefinedTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPredefinedTypeBase.getCreateMan());
        }
        if (pSPredefinedTypeBase.isMemoDirty() && (bl || pSPredefinedTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPredefinedTypeBase.getMemo());
        }
        if (pSPredefinedTypeBase.isOrderValueDirty() && (bl || pSPredefinedTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPredefinedTypeBase.getOrderValue());
        }
        if (pSPredefinedTypeBase.isPredefinedTypeDirty() && (bl || pSPredefinedTypeBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSPredefinedTypeBase.getPredefinedType());
        }
        if (pSPredefinedTypeBase.isPSPFPluginIdDirty() && (bl || pSPredefinedTypeBase.getPSPFPluginId() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINID, (Object)pSPredefinedTypeBase.getPSPFPluginId());
        }
        if (pSPredefinedTypeBase.isPSPFPluginNameDirty() && (bl || pSPredefinedTypeBase.getPSPFPluginName() != null)) {
            iDataObject.set(FIELD_PSPFPLUGINNAME, (Object)pSPredefinedTypeBase.getPSPFPluginName());
        }
        if (pSPredefinedTypeBase.isPSPredefinedTypeIdDirty() && (bl || pSPredefinedTypeBase.getPSPredefinedTypeId() != null)) {
            iDataObject.set(FIELD_PSPREDEFINEDTYPEID, (Object)pSPredefinedTypeBase.getPSPredefinedTypeId());
        }
        if (pSPredefinedTypeBase.isPSPredefinedTypeNameDirty() && (bl || pSPredefinedTypeBase.getPSPredefinedTypeName() != null)) {
            iDataObject.set(FIELD_PSPREDEFINEDTYPENAME, (Object)pSPredefinedTypeBase.getPSPredefinedTypeName());
        }
        if (pSPredefinedTypeBase.isPSSFPluginIdDirty() && (bl || pSPredefinedTypeBase.getPSSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINID, (Object)pSPredefinedTypeBase.getPSSFPluginId());
        }
        if (pSPredefinedTypeBase.isPSSFPluginNameDirty() && (bl || pSPredefinedTypeBase.getPSSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSFPLUGINNAME, (Object)pSPredefinedTypeBase.getPSSFPluginName());
        }
        if (pSPredefinedTypeBase.isTypeParamsDirty() && (bl || pSPredefinedTypeBase.getTypeParams() != null)) {
            iDataObject.set(FIELD_TYPEPARAMS, (Object)pSPredefinedTypeBase.getTypeParams());
        }
        if (pSPredefinedTypeBase.isTypeTagDirty() && (bl || pSPredefinedTypeBase.getTypeTag() != null)) {
            iDataObject.set(FIELD_TYPETAG, (Object)pSPredefinedTypeBase.getTypeTag());
        }
        if (pSPredefinedTypeBase.isTypeTag2Dirty() && (bl || pSPredefinedTypeBase.getTypeTag2() != null)) {
            iDataObject.set(FIELD_TYPETAG2, (Object)pSPredefinedTypeBase.getTypeTag2());
        }
        if (pSPredefinedTypeBase.isUpdateDateDirty() && (bl || pSPredefinedTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPredefinedTypeBase.getUpdateDate());
        }
        if (pSPredefinedTypeBase.isUpdateManDirty() && (bl || pSPredefinedTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPredefinedTypeBase.getUpdateMan());
        }
        if (pSPredefinedTypeBase.isUsageModeDirty() && (bl || pSPredefinedTypeBase.getUsageMode() != null)) {
            iDataObject.set(FIELD_USAGEMODE, (Object)pSPredefinedTypeBase.getUsageMode());
        }
        if (pSPredefinedTypeBase.isValidFlagDirty() && (bl || pSPredefinedTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPredefinedTypeBase.getValidFlag());
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
        return PSPredefinedTypeBase.remove(this, n);
    }

    private static boolean remove(PSPredefinedTypeBase pSPredefinedTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPredefinedTypeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPredefinedTypeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPredefinedTypeBase.resetMemo();
                return true;
            }
            case 3: {
                pSPredefinedTypeBase.resetOrderValue();
                return true;
            }
            case 4: {
                pSPredefinedTypeBase.resetPredefinedType();
                return true;
            }
            case 5: {
                pSPredefinedTypeBase.resetPSPFPluginId();
                return true;
            }
            case 6: {
                pSPredefinedTypeBase.resetPSPFPluginName();
                return true;
            }
            case 7: {
                pSPredefinedTypeBase.resetPSPredefinedTypeId();
                return true;
            }
            case 8: {
                pSPredefinedTypeBase.resetPSPredefinedTypeName();
                return true;
            }
            case 9: {
                pSPredefinedTypeBase.resetPSSFPluginId();
                return true;
            }
            case 10: {
                pSPredefinedTypeBase.resetPSSFPluginName();
                return true;
            }
            case 11: {
                pSPredefinedTypeBase.resetTypeParams();
                return true;
            }
            case 12: {
                pSPredefinedTypeBase.resetTypeTag();
                return true;
            }
            case 13: {
                pSPredefinedTypeBase.resetTypeTag2();
                return true;
            }
            case 14: {
                pSPredefinedTypeBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSPredefinedTypeBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSPredefinedTypeBase.resetUsageMode();
                return true;
            }
            case 17: {
                pSPredefinedTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPFPlugin getPSPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPlugin();
        }
        if (this.getPSPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSPFPluginLock;
        synchronized (n) {
            if (this.pspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSPFPluginId(), (Object)this.pspfplugin.getPSPFPluginId()) != 0L) {
                this.pspfplugin = null;
            }
            if (this.pspfplugin == null) {
                PSPFPlugin pSPFPlugin = new PSPFPlugin();
                pSPFPlugin.setPSPFPluginId(this.getPSPFPluginId());
                PSPFPluginService pSPFPluginService = (PSPFPluginService)ServiceGlobal.getService(PSPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSPFPluginService.autoGet(pSPFPlugin);
                this.pspfplugin = pSPFPlugin;
            }
            return this.pspfplugin;
        }
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

    private PSPredefinedTypeBase getProxyEntity() {
        return this.proxyPSPredefinedTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPredefinedTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSPredefinedTypeBase) {
            this.proxyPSPredefinedTypeBase = (PSPredefinedTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPredefinedTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_MEMO, 2);
        fieldIndexMap.put(FIELD_ORDERVALUE, 3);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 4);
        fieldIndexMap.put(FIELD_PSPFPLUGINID, 5);
        fieldIndexMap.put(FIELD_PSPFPLUGINNAME, 6);
        fieldIndexMap.put(FIELD_PSPREDEFINEDTYPEID, 7);
        fieldIndexMap.put(FIELD_PSPREDEFINEDTYPENAME, 8);
        fieldIndexMap.put(FIELD_PSSFPLUGINID, 9);
        fieldIndexMap.put(FIELD_PSSFPLUGINNAME, 10);
        fieldIndexMap.put(FIELD_TYPEPARAMS, 11);
        fieldIndexMap.put(FIELD_TYPETAG, 12);
        fieldIndexMap.put(FIELD_TYPETAG2, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USAGEMODE, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
    }
}

