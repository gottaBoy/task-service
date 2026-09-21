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
import net.ibizsys.pscore.srv.config.entity.PSViewLogicType;
import net.ibizsys.pscore.srv.config.service.PSViewLogicTypeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewLogicTypeParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewLogicTypeParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLESUBKEY = "ENABLESUBKEY";
    public static final String FIELD_MAXCOUNT = "MAXCOUNT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMCAT = "PARAMCAT";
    public static final String FIELD_PARAMDESC = "PARAMDESC";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PARAMVALUE = "PARAMVALUE";
    public static final String FIELD_PARAMVALUE2 = "PARAMVALUE2";
    public static final String FIELD_PSVIEWLOGICTYPEID = "PSVIEWLOGICTYPEID";
    public static final String FIELD_PSVIEWLOGICTYPENAME = "PSVIEWLOGICTYPENAME";
    public static final String FIELD_PSVIEWLOGICTYPEPARAMID = "PSVIEWLOGICTYPEPARAMID";
    public static final String FIELD_PSVIEWLOGICTYPEPARAMNAME = "PSVIEWLOGICTYPEPARAMNAME";
    public static final String FIELD_REFOBJSCOPE = "REFOBJSCOPE";
    public static final String FIELD_REFOBJTYPE = "REFOBJTYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_ENABLESUBKEY = 2;
    private static final int INDEX_MAXCOUNT = 3;
    private static final int INDEX_MEMO = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PARAMCAT = 6;
    private static final int INDEX_PARAMDESC = 7;
    private static final int INDEX_PARAMTYPE = 8;
    private static final int INDEX_PARAMVALUE = 9;
    private static final int INDEX_PARAMVALUE2 = 10;
    private static final int INDEX_PSVIEWLOGICTYPEID = 11;
    private static final int INDEX_PSVIEWLOGICTYPENAME = 12;
    private static final int INDEX_PSVIEWLOGICTYPEPARAMID = 13;
    private static final int INDEX_PSVIEWLOGICTYPEPARAMNAME = 14;
    private static final int INDEX_REFOBJSCOPE = 15;
    private static final int INDEX_REFOBJTYPE = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewLogicTypeParamBase proxyPSViewLogicTypeParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablesubkeyDirtyFlag = false;
    private boolean maxcountDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramcatDirtyFlag = false;
    private boolean paramdescDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean paramvalueDirtyFlag = false;
    private boolean paramvalue2DirtyFlag = false;
    private boolean psviewlogictypeidDirtyFlag = false;
    private boolean psviewlogictypenameDirtyFlag = false;
    private boolean psviewlogictypeparamidDirtyFlag = false;
    private boolean psviewlogictypeparamnameDirtyFlag = false;
    private boolean refobjscopeDirtyFlag = false;
    private boolean refobjtypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablesubkey")
    private Integer enablesubkey;
    @Column(name="maxcount")
    private Integer maxcount;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramcat")
    private String paramcat;
    @Column(name="paramdesc")
    private String paramdesc;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="paramvalue")
    private String paramvalue;
    @Column(name="paramvalue2")
    private String paramvalue2;
    @Column(name="psviewlogictypeid")
    private String psviewlogictypeid;
    @Column(name="psviewlogictypename")
    private String psviewlogictypename;
    @Column(name="psviewlogictypeparamid")
    private String psviewlogictypeparamid;
    @Column(name="psviewlogictypeparamname")
    private String psviewlogictypeparamname;
    @Column(name="refobjscope")
    private String refobjscope;
    @Column(name="refobjtype")
    private String refobjtype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSViewLogicTypeLock = new Integer(1);
    private PSViewLogicType psviewlogictype = null;

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

    public void setEnableSubKey(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableSubKey(n);
            return;
        }
        this.enablesubkey = n;
        this.enablesubkeyDirtyFlag = true;
    }

    public Integer getEnableSubKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableSubKey();
        }
        return this.enablesubkey;
    }

    public boolean isEnableSubKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableSubKeyDirty();
        }
        return this.enablesubkeyDirtyFlag;
    }

    public void resetEnableSubKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableSubKey();
            return;
        }
        this.enablesubkeyDirtyFlag = false;
        this.enablesubkey = null;
    }

    public void setMaxCount(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxCount(n);
            return;
        }
        this.maxcount = n;
        this.maxcountDirtyFlag = true;
    }

    public Integer getMaxCount() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxCount();
        }
        return this.maxcount;
    }

    public boolean isMaxCountDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxCountDirty();
        }
        return this.maxcountDirtyFlag;
    }

    public void resetMaxCount() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxCount();
            return;
        }
        this.maxcountDirtyFlag = false;
        this.maxcount = null;
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

    public void setParamCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramcat = string;
        this.paramcatDirtyFlag = true;
    }

    public String getParamCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamCat();
        }
        return this.paramcat;
    }

    public boolean isParamCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamCatDirty();
        }
        return this.paramcatDirtyFlag;
    }

    public void resetParamCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamCat();
            return;
        }
        this.paramcatDirtyFlag = false;
        this.paramcat = null;
    }

    public void setParamDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramdesc = string;
        this.paramdescDirtyFlag = true;
    }

    public String getParamDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamDesc();
        }
        return this.paramdesc;
    }

    public boolean isParamDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamDescDirty();
        }
        return this.paramdescDirtyFlag;
    }

    public void resetParamDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamDesc();
            return;
        }
        this.paramdescDirtyFlag = false;
        this.paramdesc = null;
    }

    public void setParamType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtype = string;
        this.paramtypeDirtyFlag = true;
    }

    public String getParamType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamType();
        }
        return this.paramtype;
    }

    public boolean isParamTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeDirty();
        }
        return this.paramtypeDirtyFlag;
    }

    public void resetParamType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamType();
            return;
        }
        this.paramtypeDirtyFlag = false;
        this.paramtype = null;
    }

    public void setParamValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue = string;
        this.paramvalueDirtyFlag = true;
    }

    public String getParamValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue();
        }
        return this.paramvalue;
    }

    public boolean isParamValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValueDirty();
        }
        return this.paramvalueDirtyFlag;
    }

    public void resetParamValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue();
            return;
        }
        this.paramvalueDirtyFlag = false;
        this.paramvalue = null;
    }

    public void setParamValue2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamValue2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramvalue2 = string;
        this.paramvalue2DirtyFlag = true;
    }

    public String getParamValue2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamValue2();
        }
        return this.paramvalue2;
    }

    public boolean isParamValue2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamValue2Dirty();
        }
        return this.paramvalue2DirtyFlag;
    }

    public void resetParamValue2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamValue2();
            return;
        }
        this.paramvalue2DirtyFlag = false;
        this.paramvalue2 = null;
    }

    public void setPSViewLogicTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeid = string;
        this.psviewlogictypeidDirtyFlag = true;
    }

    public String getPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeId();
        }
        return this.psviewlogictypeid;
    }

    public boolean isPSViewLogicTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeIdDirty();
        }
        return this.psviewlogictypeidDirtyFlag;
    }

    public void resetPSViewLogicTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeId();
            return;
        }
        this.psviewlogictypeidDirtyFlag = false;
        this.psviewlogictypeid = null;
    }

    public void setPSViewLogicTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypename = string;
        this.psviewlogictypenameDirtyFlag = true;
    }

    public String getPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeName();
        }
        return this.psviewlogictypename;
    }

    public boolean isPSViewLogicTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeNameDirty();
        }
        return this.psviewlogictypenameDirtyFlag;
    }

    public void resetPSViewLogicTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeName();
            return;
        }
        this.psviewlogictypenameDirtyFlag = false;
        this.psviewlogictypename = null;
    }

    public void setPSViewLogicTypeParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeparamid = string;
        this.psviewlogictypeparamidDirtyFlag = true;
    }

    public String getPSViewLogicTypeParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeParamId();
        }
        return this.psviewlogictypeparamid;
    }

    public boolean isPSViewLogicTypeParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeParamIdDirty();
        }
        return this.psviewlogictypeparamidDirtyFlag;
    }

    public void resetPSViewLogicTypeParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeParamId();
            return;
        }
        this.psviewlogictypeparamidDirtyFlag = false;
        this.psviewlogictypeparamid = null;
    }

    public void setPSViewLogicTypeParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewLogicTypeParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewlogictypeparamname = string;
        this.psviewlogictypeparamnameDirtyFlag = true;
    }

    public String getPSViewLogicTypeParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicTypeParamName();
        }
        return this.psviewlogictypeparamname;
    }

    public boolean isPSViewLogicTypeParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewLogicTypeParamNameDirty();
        }
        return this.psviewlogictypeparamnameDirtyFlag;
    }

    public void resetPSViewLogicTypeParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewLogicTypeParamName();
            return;
        }
        this.psviewlogictypeparamnameDirtyFlag = false;
        this.psviewlogictypeparamname = null;
    }

    public void setRefObjScope(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjScope(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjscope = string;
        this.refobjscopeDirtyFlag = true;
    }

    public String getRefObjScope() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjScope();
        }
        return this.refobjscope;
    }

    public boolean isRefObjScopeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjScopeDirty();
        }
        return this.refobjscopeDirtyFlag;
    }

    public void resetRefObjScope() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjScope();
            return;
        }
        this.refobjscopeDirtyFlag = false;
        this.refobjscope = null;
    }

    public void setRefObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refobjtype = string;
        this.refobjtypeDirtyFlag = true;
    }

    public String getRefObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefObjType();
        }
        return this.refobjtype;
    }

    public boolean isRefObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefObjTypeDirty();
        }
        return this.refobjtypeDirtyFlag;
    }

    public void resetRefObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefObjType();
            return;
        }
        this.refobjtypeDirtyFlag = false;
        this.refobjtype = null;
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
        PSViewLogicTypeParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewLogicTypeParamBase pSViewLogicTypeParamBase) {
        pSViewLogicTypeParamBase.resetCreateDate();
        pSViewLogicTypeParamBase.resetCreateMan();
        pSViewLogicTypeParamBase.resetEnableSubKey();
        pSViewLogicTypeParamBase.resetMaxCount();
        pSViewLogicTypeParamBase.resetMemo();
        pSViewLogicTypeParamBase.resetOrderValue();
        pSViewLogicTypeParamBase.resetParamCat();
        pSViewLogicTypeParamBase.resetParamDesc();
        pSViewLogicTypeParamBase.resetParamType();
        pSViewLogicTypeParamBase.resetParamValue();
        pSViewLogicTypeParamBase.resetParamValue2();
        pSViewLogicTypeParamBase.resetPSViewLogicTypeId();
        pSViewLogicTypeParamBase.resetPSViewLogicTypeName();
        pSViewLogicTypeParamBase.resetPSViewLogicTypeParamId();
        pSViewLogicTypeParamBase.resetPSViewLogicTypeParamName();
        pSViewLogicTypeParamBase.resetRefObjScope();
        pSViewLogicTypeParamBase.resetRefObjType();
        pSViewLogicTypeParamBase.resetUpdateDate();
        pSViewLogicTypeParamBase.resetUpdateMan();
        pSViewLogicTypeParamBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableSubKeyDirty()) {
            hashMap.put(FIELD_ENABLESUBKEY, this.getEnableSubKey());
        }
        if (!bl || this.isMaxCountDirty()) {
            hashMap.put(FIELD_MAXCOUNT, this.getMaxCount());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamCatDirty()) {
            hashMap.put(FIELD_PARAMCAT, this.getParamCat());
        }
        if (!bl || this.isParamDescDirty()) {
            hashMap.put(FIELD_PARAMDESC, this.getParamDesc());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isParamValueDirty()) {
            hashMap.put(FIELD_PARAMVALUE, this.getParamValue());
        }
        if (!bl || this.isParamValue2Dirty()) {
            hashMap.put(FIELD_PARAMVALUE2, this.getParamValue2());
        }
        if (!bl || this.isPSViewLogicTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEID, this.getPSViewLogicTypeId());
        }
        if (!bl || this.isPSViewLogicTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPENAME, this.getPSViewLogicTypeName());
        }
        if (!bl || this.isPSViewLogicTypeParamIdDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEPARAMID, this.getPSViewLogicTypeParamId());
        }
        if (!bl || this.isPSViewLogicTypeParamNameDirty()) {
            hashMap.put(FIELD_PSVIEWLOGICTYPEPARAMNAME, this.getPSViewLogicTypeParamName());
        }
        if (!bl || this.isRefObjScopeDirty()) {
            hashMap.put(FIELD_REFOBJSCOPE, this.getRefObjScope());
        }
        if (!bl || this.isRefObjTypeDirty()) {
            hashMap.put(FIELD_REFOBJTYPE, this.getRefObjType());
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
        return PSViewLogicTypeParamBase.get(this, n);
    }

    private static Object get(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeParamBase.getCreateDate();
            }
            case 1: {
                return pSViewLogicTypeParamBase.getCreateMan();
            }
            case 2: {
                return pSViewLogicTypeParamBase.getEnableSubKey();
            }
            case 3: {
                return pSViewLogicTypeParamBase.getMaxCount();
            }
            case 4: {
                return pSViewLogicTypeParamBase.getMemo();
            }
            case 5: {
                return pSViewLogicTypeParamBase.getOrderValue();
            }
            case 6: {
                return pSViewLogicTypeParamBase.getParamCat();
            }
            case 7: {
                return pSViewLogicTypeParamBase.getParamDesc();
            }
            case 8: {
                return pSViewLogicTypeParamBase.getParamType();
            }
            case 9: {
                return pSViewLogicTypeParamBase.getParamValue();
            }
            case 10: {
                return pSViewLogicTypeParamBase.getParamValue2();
            }
            case 11: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeId();
            }
            case 12: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeName();
            }
            case 13: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeParamId();
            }
            case 14: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeParamName();
            }
            case 15: {
                return pSViewLogicTypeParamBase.getRefObjScope();
            }
            case 16: {
                return pSViewLogicTypeParamBase.getRefObjType();
            }
            case 17: {
                return pSViewLogicTypeParamBase.getUpdateDate();
            }
            case 18: {
                return pSViewLogicTypeParamBase.getUpdateMan();
            }
            case 19: {
                return pSViewLogicTypeParamBase.getValidFlag();
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
        PSViewLogicTypeParamBase.set(this, n, object);
    }

    private static void set(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewLogicTypeParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSViewLogicTypeParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewLogicTypeParamBase.setEnableSubKey(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSViewLogicTypeParamBase.setMaxCount(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSViewLogicTypeParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewLogicTypeParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSViewLogicTypeParamBase.setParamCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSViewLogicTypeParamBase.setParamDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewLogicTypeParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSViewLogicTypeParamBase.setParamValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSViewLogicTypeParamBase.setParamValue2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewLogicTypeParamBase.setPSViewLogicTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewLogicTypeParamBase.setPSViewLogicTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewLogicTypeParamBase.setPSViewLogicTypeParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSViewLogicTypeParamBase.setPSViewLogicTypeParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewLogicTypeParamBase.setRefObjScope(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewLogicTypeParamBase.setRefObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewLogicTypeParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSViewLogicTypeParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewLogicTypeParamBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSViewLogicTypeParamBase.isNull(this, n);
    }

    private static boolean isNull(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSViewLogicTypeParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSViewLogicTypeParamBase.getEnableSubKey() == null;
            }
            case 3: {
                return pSViewLogicTypeParamBase.getMaxCount() == null;
            }
            case 4: {
                return pSViewLogicTypeParamBase.getMemo() == null;
            }
            case 5: {
                return pSViewLogicTypeParamBase.getOrderValue() == null;
            }
            case 6: {
                return pSViewLogicTypeParamBase.getParamCat() == null;
            }
            case 7: {
                return pSViewLogicTypeParamBase.getParamDesc() == null;
            }
            case 8: {
                return pSViewLogicTypeParamBase.getParamType() == null;
            }
            case 9: {
                return pSViewLogicTypeParamBase.getParamValue() == null;
            }
            case 10: {
                return pSViewLogicTypeParamBase.getParamValue2() == null;
            }
            case 11: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeId() == null;
            }
            case 12: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeName() == null;
            }
            case 13: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeParamId() == null;
            }
            case 14: {
                return pSViewLogicTypeParamBase.getPSViewLogicTypeParamName() == null;
            }
            case 15: {
                return pSViewLogicTypeParamBase.getRefObjScope() == null;
            }
            case 16: {
                return pSViewLogicTypeParamBase.getRefObjType() == null;
            }
            case 17: {
                return pSViewLogicTypeParamBase.getUpdateDate() == null;
            }
            case 18: {
                return pSViewLogicTypeParamBase.getUpdateMan() == null;
            }
            case 19: {
                return pSViewLogicTypeParamBase.getValidFlag() == null;
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
        return PSViewLogicTypeParamBase.contains(this, n);
    }

    private static boolean contains(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewLogicTypeParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSViewLogicTypeParamBase.isCreateManDirty();
            }
            case 2: {
                return pSViewLogicTypeParamBase.isEnableSubKeyDirty();
            }
            case 3: {
                return pSViewLogicTypeParamBase.isMaxCountDirty();
            }
            case 4: {
                return pSViewLogicTypeParamBase.isMemoDirty();
            }
            case 5: {
                return pSViewLogicTypeParamBase.isOrderValueDirty();
            }
            case 6: {
                return pSViewLogicTypeParamBase.isParamCatDirty();
            }
            case 7: {
                return pSViewLogicTypeParamBase.isParamDescDirty();
            }
            case 8: {
                return pSViewLogicTypeParamBase.isParamTypeDirty();
            }
            case 9: {
                return pSViewLogicTypeParamBase.isParamValueDirty();
            }
            case 10: {
                return pSViewLogicTypeParamBase.isParamValue2Dirty();
            }
            case 11: {
                return pSViewLogicTypeParamBase.isPSViewLogicTypeIdDirty();
            }
            case 12: {
                return pSViewLogicTypeParamBase.isPSViewLogicTypeNameDirty();
            }
            case 13: {
                return pSViewLogicTypeParamBase.isPSViewLogicTypeParamIdDirty();
            }
            case 14: {
                return pSViewLogicTypeParamBase.isPSViewLogicTypeParamNameDirty();
            }
            case 15: {
                return pSViewLogicTypeParamBase.isRefObjScopeDirty();
            }
            case 16: {
                return pSViewLogicTypeParamBase.isRefObjTypeDirty();
            }
            case 17: {
                return pSViewLogicTypeParamBase.isUpdateDateDirty();
            }
            case 18: {
                return pSViewLogicTypeParamBase.isUpdateManDirty();
            }
            case 19: {
                return pSViewLogicTypeParamBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewLogicTypeParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewLogicTypeParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getEnableSubKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablesubkey", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getEnableSubKey()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getMaxCount() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxcount", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getMaxCount()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getParamCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramcat", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getParamCat()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getParamDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramdesc", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getParamDesc()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getParamValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getParamValue()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getParamValue2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramvalue2", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getParamValue2()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeid", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getPSViewLogicTypeId()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypename", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getPSViewLogicTypeName()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeparamid", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getPSViewLogicTypeParamId()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewlogictypeparamname", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getPSViewLogicTypeParamName()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getRefObjScope() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjscope", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getRefObjScope()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getRefObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refobjtype", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getRefObjType()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewLogicTypeParamBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewLogicTypeParamBase.getJSONValue((Object)pSViewLogicTypeParamBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewLogicTypeParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewLogicTypeParamBase.getCreateDate() != null) {
            object = pSViewLogicTypeParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewLogicTypeParamBase.getCreateMan() != null) {
            object = pSViewLogicTypeParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getEnableSubKey() != null) {
            object = pSViewLogicTypeParamBase.getEnableSubKey();
            xmlNode.setAttribute(FIELD_ENABLESUBKEY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewLogicTypeParamBase.getMaxCount() != null) {
            object = pSViewLogicTypeParamBase.getMaxCount();
            xmlNode.setAttribute(FIELD_MAXCOUNT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewLogicTypeParamBase.getMemo() != null) {
            object = pSViewLogicTypeParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getOrderValue() != null) {
            object = pSViewLogicTypeParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewLogicTypeParamBase.getParamCat() != null) {
            object = pSViewLogicTypeParamBase.getParamCat();
            xmlNode.setAttribute(FIELD_PARAMCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getParamDesc() != null) {
            object = pSViewLogicTypeParamBase.getParamDesc();
            xmlNode.setAttribute(FIELD_PARAMDESC, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getParamType() != null) {
            object = pSViewLogicTypeParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getParamValue() != null) {
            object = pSViewLogicTypeParamBase.getParamValue();
            xmlNode.setAttribute(FIELD_PARAMVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getParamValue2() != null) {
            object = pSViewLogicTypeParamBase.getParamValue2();
            xmlNode.setAttribute(FIELD_PARAMVALUE2, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeId() != null) {
            object = pSViewLogicTypeParamBase.getPSViewLogicTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeName() != null) {
            object = pSViewLogicTypeParamBase.getPSViewLogicTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamId() != null) {
            object = pSViewLogicTypeParamBase.getPSViewLogicTypeParamId();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamName() != null) {
            object = pSViewLogicTypeParamBase.getPSViewLogicTypeParamName();
            xmlNode.setAttribute(FIELD_PSVIEWLOGICTYPEPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getRefObjScope() != null) {
            object = pSViewLogicTypeParamBase.getRefObjScope();
            xmlNode.setAttribute(FIELD_REFOBJSCOPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getRefObjType() != null) {
            object = pSViewLogicTypeParamBase.getRefObjType();
            xmlNode.setAttribute(FIELD_REFOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getUpdateDate() != null) {
            object = pSViewLogicTypeParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewLogicTypeParamBase.getUpdateMan() != null) {
            object = pSViewLogicTypeParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewLogicTypeParamBase.getValidFlag() != null) {
            object = pSViewLogicTypeParamBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewLogicTypeParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewLogicTypeParamBase.isCreateDateDirty() && (bl || pSViewLogicTypeParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewLogicTypeParamBase.getCreateDate());
        }
        if (pSViewLogicTypeParamBase.isCreateManDirty() && (bl || pSViewLogicTypeParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewLogicTypeParamBase.getCreateMan());
        }
        if (pSViewLogicTypeParamBase.isEnableSubKeyDirty() && (bl || pSViewLogicTypeParamBase.getEnableSubKey() != null)) {
            iDataObject.set(FIELD_ENABLESUBKEY, (Object)pSViewLogicTypeParamBase.getEnableSubKey());
        }
        if (pSViewLogicTypeParamBase.isMaxCountDirty() && (bl || pSViewLogicTypeParamBase.getMaxCount() != null)) {
            iDataObject.set(FIELD_MAXCOUNT, (Object)pSViewLogicTypeParamBase.getMaxCount());
        }
        if (pSViewLogicTypeParamBase.isMemoDirty() && (bl || pSViewLogicTypeParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewLogicTypeParamBase.getMemo());
        }
        if (pSViewLogicTypeParamBase.isOrderValueDirty() && (bl || pSViewLogicTypeParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSViewLogicTypeParamBase.getOrderValue());
        }
        if (pSViewLogicTypeParamBase.isParamCatDirty() && (bl || pSViewLogicTypeParamBase.getParamCat() != null)) {
            iDataObject.set(FIELD_PARAMCAT, (Object)pSViewLogicTypeParamBase.getParamCat());
        }
        if (pSViewLogicTypeParamBase.isParamDescDirty() && (bl || pSViewLogicTypeParamBase.getParamDesc() != null)) {
            iDataObject.set(FIELD_PARAMDESC, (Object)pSViewLogicTypeParamBase.getParamDesc());
        }
        if (pSViewLogicTypeParamBase.isParamTypeDirty() && (bl || pSViewLogicTypeParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSViewLogicTypeParamBase.getParamType());
        }
        if (pSViewLogicTypeParamBase.isParamValueDirty() && (bl || pSViewLogicTypeParamBase.getParamValue() != null)) {
            iDataObject.set(FIELD_PARAMVALUE, (Object)pSViewLogicTypeParamBase.getParamValue());
        }
        if (pSViewLogicTypeParamBase.isParamValue2Dirty() && (bl || pSViewLogicTypeParamBase.getParamValue2() != null)) {
            iDataObject.set(FIELD_PARAMVALUE2, (Object)pSViewLogicTypeParamBase.getParamValue2());
        }
        if (pSViewLogicTypeParamBase.isPSViewLogicTypeIdDirty() && (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEID, (Object)pSViewLogicTypeParamBase.getPSViewLogicTypeId());
        }
        if (pSViewLogicTypeParamBase.isPSViewLogicTypeNameDirty() && (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPENAME, (Object)pSViewLogicTypeParamBase.getPSViewLogicTypeName());
        }
        if (pSViewLogicTypeParamBase.isPSViewLogicTypeParamIdDirty() && (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamId() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEPARAMID, (Object)pSViewLogicTypeParamBase.getPSViewLogicTypeParamId());
        }
        if (pSViewLogicTypeParamBase.isPSViewLogicTypeParamNameDirty() && (bl || pSViewLogicTypeParamBase.getPSViewLogicTypeParamName() != null)) {
            iDataObject.set(FIELD_PSVIEWLOGICTYPEPARAMNAME, (Object)pSViewLogicTypeParamBase.getPSViewLogicTypeParamName());
        }
        if (pSViewLogicTypeParamBase.isRefObjScopeDirty() && (bl || pSViewLogicTypeParamBase.getRefObjScope() != null)) {
            iDataObject.set(FIELD_REFOBJSCOPE, (Object)pSViewLogicTypeParamBase.getRefObjScope());
        }
        if (pSViewLogicTypeParamBase.isRefObjTypeDirty() && (bl || pSViewLogicTypeParamBase.getRefObjType() != null)) {
            iDataObject.set(FIELD_REFOBJTYPE, (Object)pSViewLogicTypeParamBase.getRefObjType());
        }
        if (pSViewLogicTypeParamBase.isUpdateDateDirty() && (bl || pSViewLogicTypeParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewLogicTypeParamBase.getUpdateDate());
        }
        if (pSViewLogicTypeParamBase.isUpdateManDirty() && (bl || pSViewLogicTypeParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewLogicTypeParamBase.getUpdateMan());
        }
        if (pSViewLogicTypeParamBase.isValidFlagDirty() && (bl || pSViewLogicTypeParamBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewLogicTypeParamBase.getValidFlag());
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
        return PSViewLogicTypeParamBase.remove(this, n);
    }

    private static boolean remove(PSViewLogicTypeParamBase pSViewLogicTypeParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewLogicTypeParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSViewLogicTypeParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSViewLogicTypeParamBase.resetEnableSubKey();
                return true;
            }
            case 3: {
                pSViewLogicTypeParamBase.resetMaxCount();
                return true;
            }
            case 4: {
                pSViewLogicTypeParamBase.resetMemo();
                return true;
            }
            case 5: {
                pSViewLogicTypeParamBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSViewLogicTypeParamBase.resetParamCat();
                return true;
            }
            case 7: {
                pSViewLogicTypeParamBase.resetParamDesc();
                return true;
            }
            case 8: {
                pSViewLogicTypeParamBase.resetParamType();
                return true;
            }
            case 9: {
                pSViewLogicTypeParamBase.resetParamValue();
                return true;
            }
            case 10: {
                pSViewLogicTypeParamBase.resetParamValue2();
                return true;
            }
            case 11: {
                pSViewLogicTypeParamBase.resetPSViewLogicTypeId();
                return true;
            }
            case 12: {
                pSViewLogicTypeParamBase.resetPSViewLogicTypeName();
                return true;
            }
            case 13: {
                pSViewLogicTypeParamBase.resetPSViewLogicTypeParamId();
                return true;
            }
            case 14: {
                pSViewLogicTypeParamBase.resetPSViewLogicTypeParamName();
                return true;
            }
            case 15: {
                pSViewLogicTypeParamBase.resetRefObjScope();
                return true;
            }
            case 16: {
                pSViewLogicTypeParamBase.resetRefObjType();
                return true;
            }
            case 17: {
                pSViewLogicTypeParamBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSViewLogicTypeParamBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSViewLogicTypeParamBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewLogicType getPSViewLogicType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewLogicType();
        }
        if (this.getPSViewLogicTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewLogicTypeLock;
        synchronized (n) {
            if (this.psviewlogictype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewLogicTypeId(), (Object)this.psviewlogictype.getPSViewLogicTypeId()) != 0L) {
                this.psviewlogictype = null;
            }
            if (this.psviewlogictype == null) {
                PSViewLogicType pSViewLogicType = new PSViewLogicType();
                pSViewLogicType.setPSViewLogicTypeId(this.getPSViewLogicTypeId());
                PSViewLogicTypeService pSViewLogicTypeService = (PSViewLogicTypeService)ServiceGlobal.getService(PSViewLogicTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewLogicTypeService.autoGet((IEntity)pSViewLogicType);
                this.psviewlogictype = pSViewLogicType;
            }
            return this.psviewlogictype;
        }
    }

    private PSViewLogicTypeParamBase getProxyEntity() {
        return this.proxyPSViewLogicTypeParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewLogicTypeParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewLogicTypeParamBase) {
            this.proxyPSViewLogicTypeParamBase = (PSViewLogicTypeParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewLogicTypeParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_ENABLESUBKEY, 2);
        fieldIndexMap.put(FIELD_MAXCOUNT, 3);
        fieldIndexMap.put(FIELD_MEMO, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PARAMCAT, 6);
        fieldIndexMap.put(FIELD_PARAMDESC, 7);
        fieldIndexMap.put(FIELD_PARAMTYPE, 8);
        fieldIndexMap.put(FIELD_PARAMVALUE, 9);
        fieldIndexMap.put(FIELD_PARAMVALUE2, 10);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEID, 11);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPENAME, 12);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEPARAMID, 13);
        fieldIndexMap.put(FIELD_PSVIEWLOGICTYPEPARAMNAME, 14);
        fieldIndexMap.put(FIELD_REFOBJSCOPE, 15);
        fieldIndexMap.put(FIELD_REFOBJTYPE, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

