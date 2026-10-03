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
package net.ibizsys.pscore.srv.eaidesign.entity;

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
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataType;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIElement;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIElementAttrBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIElementAttrBase.class);
    public static final String FIELD_ALLOWEMPTY = "ALLOWEMPTY";
    public static final String FIELD_ATTRTAG = "ATTRTAG";
    public static final String FIELD_ATTRTAG2 = "ATTRTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_EAIELEMENTATTRTYPE = "EAIELEMENTATTRTYPE";
    public static final String FIELD_FIXEDVALUE = "FIXEDVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String FIELD_PSSYSEAIELEMENTATTRID = "PSSYSEAIELEMENTATTRID";
    public static final String FIELD_PSSYSEAIELEMENTATTRNAME = "PSSYSEAIELEMENTATTRNAME";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_REFPSSYSEAIELEMENTID = "REFPSSYSEAIELEMENTID";
    public static final String FIELD_REFPSSYSEAIELEMENTNAME = "REFPSSYSEAIELEMENTNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLOWEMPTY = 0;
    private static final int INDEX_ATTRTAG = 1;
    private static final int INDEX_ATTRTAG2 = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DEFAULTVALUE = 6;
    private static final int INDEX_EAIELEMENTATTRTYPE = 7;
    private static final int INDEX_FIXEDVALUE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PSSYSEAIDATATYPEID = 11;
    private static final int INDEX_PSSYSEAIDATATYPENAME = 12;
    private static final int INDEX_PSSYSEAIELEMENTATTRID = 13;
    private static final int INDEX_PSSYSEAIELEMENTATTRNAME = 14;
    private static final int INDEX_PSSYSEAIELEMENTID = 15;
    private static final int INDEX_PSSYSEAIELEMENTNAME = 16;
    private static final int INDEX_PSSYSEAISCHEMEID = 17;
    private static final int INDEX_REFPSSYSEAIELEMENTID = 18;
    private static final int INDEX_REFPSSYSEAIELEMENTNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIElementAttrBase proxyPSSysEAIElementAttrBase = null;
    private boolean allowemptyDirtyFlag = false;
    private boolean attrtagDirtyFlag = false;
    private boolean attrtag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean eaielementattrtypeDirtyFlag = false;
    private boolean fixedvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssyseaidatatypeidDirtyFlag = false;
    private boolean pssyseaidatatypenameDirtyFlag = false;
    private boolean pssyseaielementattridDirtyFlag = false;
    private boolean pssyseaielementattrnameDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementnameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean refpssyseaielementidDirtyFlag = false;
    private boolean refpssyseaielementnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allowempty")
    private Integer allowempty;
    @Column(name="attrtag")
    private String attrtag;
    @Column(name="attrtag2")
    private String attrtag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="eaielementattrtype")
    private String eaielementattrtype;
    @Column(name="fixedvalue")
    private String fixedvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssyseaidatatypeid")
    private String pssyseaidatatypeid;
    @Column(name="pssyseaidatatypename")
    private String pssyseaidatatypename;
    @Column(name="pssyseaielementattrid")
    private String pssyseaielementattrid;
    @Column(name="pssyseaielementattrname")
    private String pssyseaielementattrname;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementname")
    private String pssyseaielementname;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="refpssyseaielementid")
    private String refpssyseaielementid;
    @Column(name="refpssyseaielementname")
    private String refpssyseaielementname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="usertag3")
    private String usertag3;
    @Column(name="usertag4")
    private String usertag4;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSSysEAIDataTypeLock = new Integer(1);
    private PSSysEAIDataType pssyseaidatatype = null;
    private Integer objPSSysEAIElementLock = new Integer(1);
    private PSSysEAIElement pssyseaielement = null;
    private Integer objRefPSSysEAIElementLock = new Integer(1);
    private PSSysEAIElement refpssyseaielement = null;

    public void setAllowEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllowEmpty(n);
            return;
        }
        this.allowempty = n;
        this.allowemptyDirtyFlag = true;
    }

    public Integer getAllowEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllowEmpty();
        }
        return this.allowempty;
    }

    public boolean isAllowEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllowEmptyDirty();
        }
        return this.allowemptyDirtyFlag;
    }

    public void resetAllowEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllowEmpty();
            return;
        }
        this.allowemptyDirtyFlag = false;
        this.allowempty = null;
    }

    public void setAttrTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrtag = string;
        this.attrtagDirtyFlag = true;
    }

    public String getAttrTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrTag();
        }
        return this.attrtag;
    }

    public boolean isAttrTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrTagDirty();
        }
        return this.attrtagDirtyFlag;
    }

    public void resetAttrTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrTag();
            return;
        }
        this.attrtagDirtyFlag = false;
        this.attrtag = null;
    }

    public void setAttrTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAttrTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.attrtag2 = string;
        this.attrtag2DirtyFlag = true;
    }

    public String getAttrTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAttrTag2();
        }
        return this.attrtag2;
    }

    public boolean isAttrTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAttrTag2Dirty();
        }
        return this.attrtag2DirtyFlag;
    }

    public void resetAttrTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAttrTag2();
            return;
        }
        this.attrtag2DirtyFlag = false;
        this.attrtag2 = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setEAIElementAttrType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIElementAttrType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaielementattrtype = string;
        this.eaielementattrtypeDirtyFlag = true;
    }

    public String getEAIElementAttrType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIElementAttrType();
        }
        return this.eaielementattrtype;
    }

    public boolean isEAIElementAttrTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIElementAttrTypeDirty();
        }
        return this.eaielementattrtypeDirtyFlag;
    }

    public void resetEAIElementAttrType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIElementAttrType();
            return;
        }
        this.eaielementattrtypeDirtyFlag = false;
        this.eaielementattrtype = null;
    }

    public void setFixedValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFixedValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fixedvalue = string;
        this.fixedvalueDirtyFlag = true;
    }

    public String getFixedValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFixedValue();
        }
        return this.fixedvalue;
    }

    public boolean isFixedValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFixedValueDirty();
        }
        return this.fixedvalueDirtyFlag;
    }

    public void resetFixedValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFixedValue();
            return;
        }
        this.fixedvalueDirtyFlag = false;
        this.fixedvalue = null;
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

    public void setPSSysEAIDataTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypeid = string;
        this.pssyseaidatatypeidDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeId();
        }
        return this.pssyseaidatatypeid;
    }

    public boolean isPSSysEAIDataTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeIdDirty();
        }
        return this.pssyseaidatatypeidDirtyFlag;
    }

    public void resetPSSysEAIDataTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeId();
            return;
        }
        this.pssyseaidatatypeidDirtyFlag = false;
        this.pssyseaidatatypeid = null;
    }

    public void setPSSysEAIDataTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIDataTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaidatatypename = string;
        this.pssyseaidatatypenameDirtyFlag = true;
    }

    public String getPSSysEAIDataTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeName();
        }
        return this.pssyseaidatatypename;
    }

    public boolean isPSSysEAIDataTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIDataTypeNameDirty();
        }
        return this.pssyseaidatatypenameDirtyFlag;
    }

    public void resetPSSysEAIDataTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIDataTypeName();
            return;
        }
        this.pssyseaidatatypenameDirtyFlag = false;
        this.pssyseaidatatypename = null;
    }

    public void setPSSysEAIElementAttrId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementAttrId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementattrid = string;
        this.pssyseaielementattridDirtyFlag = true;
    }

    public String getPSSysEAIElementAttrId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttrId();
        }
        return this.pssyseaielementattrid;
    }

    public boolean isPSSysEAIElementAttrIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementAttrIdDirty();
        }
        return this.pssyseaielementattridDirtyFlag;
    }

    public void resetPSSysEAIElementAttrId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementAttrId();
            return;
        }
        this.pssyseaielementattridDirtyFlag = false;
        this.pssyseaielementattrid = null;
    }

    public void setPSSysEAIElementAttrName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementAttrName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementattrname = string;
        this.pssyseaielementattrnameDirtyFlag = true;
    }

    public String getPSSysEAIElementAttrName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementAttrName();
        }
        return this.pssyseaielementattrname;
    }

    public boolean isPSSysEAIElementAttrNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementAttrNameDirty();
        }
        return this.pssyseaielementattrnameDirtyFlag;
    }

    public void resetPSSysEAIElementAttrName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementAttrName();
            return;
        }
        this.pssyseaielementattrnameDirtyFlag = false;
        this.pssyseaielementattrname = null;
    }

    public void setPSSysEAIElementId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementid = string;
        this.pssyseaielementidDirtyFlag = true;
    }

    public String getPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementId();
        }
        return this.pssyseaielementid;
    }

    public boolean isPSSysEAIElementIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementIdDirty();
        }
        return this.pssyseaielementidDirtyFlag;
    }

    public void resetPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementId();
            return;
        }
        this.pssyseaielementidDirtyFlag = false;
        this.pssyseaielementid = null;
    }

    public void setPSSysEAIElementName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementname = string;
        this.pssyseaielementnameDirtyFlag = true;
    }

    public String getPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementName();
        }
        return this.pssyseaielementname;
    }

    public boolean isPSSysEAIElementNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementNameDirty();
        }
        return this.pssyseaielementnameDirtyFlag;
    }

    public void resetPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementName();
            return;
        }
        this.pssyseaielementnameDirtyFlag = false;
        this.pssyseaielementname = null;
    }

    public void setPSSysEAISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemeid = string;
        this.pssyseaischemeidDirtyFlag = true;
    }

    public String getPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeId();
        }
        return this.pssyseaischemeid;
    }

    public boolean isPSSysEAISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeIdDirty();
        }
        return this.pssyseaischemeidDirtyFlag;
    }

    public void resetPSSysEAISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeId();
            return;
        }
        this.pssyseaischemeidDirtyFlag = false;
        this.pssyseaischemeid = null;
    }

    public void setRefPSSysEAIElementId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysEAIElementId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssyseaielementid = string;
        this.refpssyseaielementidDirtyFlag = true;
    }

    public String getRefPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysEAIElementId();
        }
        return this.refpssyseaielementid;
    }

    public boolean isRefPSSysEAIElementIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysEAIElementIdDirty();
        }
        return this.refpssyseaielementidDirtyFlag;
    }

    public void resetRefPSSysEAIElementId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysEAIElementId();
            return;
        }
        this.refpssyseaielementidDirtyFlag = false;
        this.refpssyseaielementid = null;
    }

    public void setRefPSSysEAIElementName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSSysEAIElementName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpssyseaielementname = string;
        this.refpssyseaielementnameDirtyFlag = true;
    }

    public String getRefPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysEAIElementName();
        }
        return this.refpssyseaielementname;
    }

    public boolean isRefPSSysEAIElementNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSSysEAIElementNameDirty();
        }
        return this.refpssyseaielementnameDirtyFlag;
    }

    public void resetRefPSSysEAIElementName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSSysEAIElementName();
            return;
        }
        this.refpssyseaielementnameDirtyFlag = false;
        this.refpssyseaielementname = null;
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

    public void setUserCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usercat = string;
        this.usercatDirtyFlag = true;
    }

    public String getUserCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserCat();
        }
        return this.usercat;
    }

    public boolean isUserCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserCatDirty();
        }
        return this.usercatDirtyFlag;
    }

    public void resetUserCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserCat();
            return;
        }
        this.usercatDirtyFlag = false;
        this.usercat = null;
    }

    public void setUserTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag = string;
        this.usertagDirtyFlag = true;
    }

    public String getUserTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag();
        }
        return this.usertag;
    }

    public boolean isUserTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTagDirty();
        }
        return this.usertagDirtyFlag;
    }

    public void resetUserTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag();
            return;
        }
        this.usertagDirtyFlag = false;
        this.usertag = null;
    }

    public void setUserTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag2 = string;
        this.usertag2DirtyFlag = true;
    }

    public String getUserTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag2();
        }
        return this.usertag2;
    }

    public boolean isUserTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag2Dirty();
        }
        return this.usertag2DirtyFlag;
    }

    public void resetUserTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag2();
            return;
        }
        this.usertag2DirtyFlag = false;
        this.usertag2 = null;
    }

    public void setUserTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag3 = string;
        this.usertag3DirtyFlag = true;
    }

    public String getUserTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag3();
        }
        return this.usertag3;
    }

    public boolean isUserTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag3Dirty();
        }
        return this.usertag3DirtyFlag;
    }

    public void resetUserTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag3();
            return;
        }
        this.usertag3DirtyFlag = false;
        this.usertag3 = null;
    }

    public void setUserTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.usertag4 = string;
        this.usertag4DirtyFlag = true;
    }

    public String getUserTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserTag4();
        }
        return this.usertag4;
    }

    public boolean isUserTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserTag4Dirty();
        }
        return this.usertag4DirtyFlag;
    }

    public void resetUserTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserTag4();
            return;
        }
        this.usertag4DirtyFlag = false;
        this.usertag4 = null;
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
        PSSysEAIElementAttrBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIElementAttrBase pSSysEAIElementAttrBase) {
        pSSysEAIElementAttrBase.resetAllowEmpty();
        pSSysEAIElementAttrBase.resetAttrTag();
        pSSysEAIElementAttrBase.resetAttrTag2();
        pSSysEAIElementAttrBase.resetCodeName();
        pSSysEAIElementAttrBase.resetCreateDate();
        pSSysEAIElementAttrBase.resetCreateMan();
        pSSysEAIElementAttrBase.resetDefaultValue();
        pSSysEAIElementAttrBase.resetEAIElementAttrType();
        pSSysEAIElementAttrBase.resetFixedValue();
        pSSysEAIElementAttrBase.resetMemo();
        pSSysEAIElementAttrBase.resetOrderValue();
        pSSysEAIElementAttrBase.resetPSSysEAIDataTypeId();
        pSSysEAIElementAttrBase.resetPSSysEAIDataTypeName();
        pSSysEAIElementAttrBase.resetPSSysEAIElementAttrId();
        pSSysEAIElementAttrBase.resetPSSysEAIElementAttrName();
        pSSysEAIElementAttrBase.resetPSSysEAIElementId();
        pSSysEAIElementAttrBase.resetPSSysEAIElementName();
        pSSysEAIElementAttrBase.resetPSSysEAISchemeId();
        pSSysEAIElementAttrBase.resetRefPSSysEAIElementId();
        pSSysEAIElementAttrBase.resetRefPSSysEAIElementName();
        pSSysEAIElementAttrBase.resetUpdateDate();
        pSSysEAIElementAttrBase.resetUpdateMan();
        pSSysEAIElementAttrBase.resetUserCat();
        pSSysEAIElementAttrBase.resetUserTag();
        pSSysEAIElementAttrBase.resetUserTag2();
        pSSysEAIElementAttrBase.resetUserTag3();
        pSSysEAIElementAttrBase.resetUserTag4();
        pSSysEAIElementAttrBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllowEmptyDirty()) {
            hashMap.put(FIELD_ALLOWEMPTY, this.getAllowEmpty());
        }
        if (!bl || this.isAttrTagDirty()) {
            hashMap.put(FIELD_ATTRTAG, this.getAttrTag());
        }
        if (!bl || this.isAttrTag2Dirty()) {
            hashMap.put(FIELD_ATTRTAG2, this.getAttrTag2());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isEAIElementAttrTypeDirty()) {
            hashMap.put(FIELD_EAIELEMENTATTRTYPE, this.getEAIElementAttrType());
        }
        if (!bl || this.isFixedValueDirty()) {
            hashMap.put(FIELD_FIXEDVALUE, this.getFixedValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSSysEAIDataTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPEID, this.getPSSysEAIDataTypeId());
        }
        if (!bl || this.isPSSysEAIDataTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPENAME, this.getPSSysEAIDataTypeName());
        }
        if (!bl || this.isPSSysEAIElementAttrIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTATTRID, this.getPSSysEAIElementAttrId());
        }
        if (!bl || this.isPSSysEAIElementAttrNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTATTRNAME, this.getPSSysEAIElementAttrName());
        }
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTNAME, this.getPSSysEAIElementName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isRefPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_REFPSSYSEAIELEMENTID, this.getRefPSSysEAIElementId());
        }
        if (!bl || this.isRefPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_REFPSSYSEAIELEMENTNAME, this.getRefPSSysEAIElementName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserCatDirty()) {
            hashMap.put(FIELD_USERCAT, this.getUserCat());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isUserTag3Dirty()) {
            hashMap.put(FIELD_USERTAG3, this.getUserTag3());
        }
        if (!bl || this.isUserTag4Dirty()) {
            hashMap.put(FIELD_USERTAG4, this.getUserTag4());
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
        return PSSysEAIElementAttrBase.get(this, n);
    }

    private static Object get(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementAttrBase.getAllowEmpty();
            }
            case 1: {
                return pSSysEAIElementAttrBase.getAttrTag();
            }
            case 2: {
                return pSSysEAIElementAttrBase.getAttrTag2();
            }
            case 3: {
                return pSSysEAIElementAttrBase.getCodeName();
            }
            case 4: {
                return pSSysEAIElementAttrBase.getCreateDate();
            }
            case 5: {
                return pSSysEAIElementAttrBase.getCreateMan();
            }
            case 6: {
                return pSSysEAIElementAttrBase.getDefaultValue();
            }
            case 7: {
                return pSSysEAIElementAttrBase.getEAIElementAttrType();
            }
            case 8: {
                return pSSysEAIElementAttrBase.getFixedValue();
            }
            case 9: {
                return pSSysEAIElementAttrBase.getMemo();
            }
            case 10: {
                return pSSysEAIElementAttrBase.getOrderValue();
            }
            case 11: {
                return pSSysEAIElementAttrBase.getPSSysEAIDataTypeId();
            }
            case 12: {
                return pSSysEAIElementAttrBase.getPSSysEAIDataTypeName();
            }
            case 13: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementAttrId();
            }
            case 14: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementAttrName();
            }
            case 15: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementId();
            }
            case 16: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementName();
            }
            case 17: {
                return pSSysEAIElementAttrBase.getPSSysEAISchemeId();
            }
            case 18: {
                return pSSysEAIElementAttrBase.getRefPSSysEAIElementId();
            }
            case 19: {
                return pSSysEAIElementAttrBase.getRefPSSysEAIElementName();
            }
            case 20: {
                return pSSysEAIElementAttrBase.getUpdateDate();
            }
            case 21: {
                return pSSysEAIElementAttrBase.getUpdateMan();
            }
            case 22: {
                return pSSysEAIElementAttrBase.getUserCat();
            }
            case 23: {
                return pSSysEAIElementAttrBase.getUserTag();
            }
            case 24: {
                return pSSysEAIElementAttrBase.getUserTag2();
            }
            case 25: {
                return pSSysEAIElementAttrBase.getUserTag3();
            }
            case 26: {
                return pSSysEAIElementAttrBase.getUserTag4();
            }
            case 27: {
                return pSSysEAIElementAttrBase.getValidFlag();
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
        PSSysEAIElementAttrBase.set(this, n, object);
    }

    private static void set(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementAttrBase.setAllowEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIElementAttrBase.setAttrTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIElementAttrBase.setAttrTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIElementAttrBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIElementAttrBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIElementAttrBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIElementAttrBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIElementAttrBase.setEAIElementAttrType(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIElementAttrBase.setFixedValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIElementAttrBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIElementAttrBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIElementAttrBase.setPSSysEAIDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIElementAttrBase.setPSSysEAIDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIElementAttrBase.setPSSysEAIElementAttrId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIElementAttrBase.setPSSysEAIElementAttrName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIElementAttrBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIElementAttrBase.setPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIElementAttrBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIElementAttrBase.setRefPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIElementAttrBase.setRefPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIElementAttrBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIElementAttrBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAIElementAttrBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAIElementAttrBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEAIElementAttrBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEAIElementAttrBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEAIElementAttrBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysEAIElementAttrBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIElementAttrBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementAttrBase.getAllowEmpty() == null;
            }
            case 1: {
                return pSSysEAIElementAttrBase.getAttrTag() == null;
            }
            case 2: {
                return pSSysEAIElementAttrBase.getAttrTag2() == null;
            }
            case 3: {
                return pSSysEAIElementAttrBase.getCodeName() == null;
            }
            case 4: {
                return pSSysEAIElementAttrBase.getCreateDate() == null;
            }
            case 5: {
                return pSSysEAIElementAttrBase.getCreateMan() == null;
            }
            case 6: {
                return pSSysEAIElementAttrBase.getDefaultValue() == null;
            }
            case 7: {
                return pSSysEAIElementAttrBase.getEAIElementAttrType() == null;
            }
            case 8: {
                return pSSysEAIElementAttrBase.getFixedValue() == null;
            }
            case 9: {
                return pSSysEAIElementAttrBase.getMemo() == null;
            }
            case 10: {
                return pSSysEAIElementAttrBase.getOrderValue() == null;
            }
            case 11: {
                return pSSysEAIElementAttrBase.getPSSysEAIDataTypeId() == null;
            }
            case 12: {
                return pSSysEAIElementAttrBase.getPSSysEAIDataTypeName() == null;
            }
            case 13: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementAttrId() == null;
            }
            case 14: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementAttrName() == null;
            }
            case 15: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementId() == null;
            }
            case 16: {
                return pSSysEAIElementAttrBase.getPSSysEAIElementName() == null;
            }
            case 17: {
                return pSSysEAIElementAttrBase.getPSSysEAISchemeId() == null;
            }
            case 18: {
                return pSSysEAIElementAttrBase.getRefPSSysEAIElementId() == null;
            }
            case 19: {
                return pSSysEAIElementAttrBase.getRefPSSysEAIElementName() == null;
            }
            case 20: {
                return pSSysEAIElementAttrBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysEAIElementAttrBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysEAIElementAttrBase.getUserCat() == null;
            }
            case 23: {
                return pSSysEAIElementAttrBase.getUserTag() == null;
            }
            case 24: {
                return pSSysEAIElementAttrBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysEAIElementAttrBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysEAIElementAttrBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysEAIElementAttrBase.getValidFlag() == null;
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
        return PSSysEAIElementAttrBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementAttrBase.isAllowEmptyDirty();
            }
            case 1: {
                return pSSysEAIElementAttrBase.isAttrTagDirty();
            }
            case 2: {
                return pSSysEAIElementAttrBase.isAttrTag2Dirty();
            }
            case 3: {
                return pSSysEAIElementAttrBase.isCodeNameDirty();
            }
            case 4: {
                return pSSysEAIElementAttrBase.isCreateDateDirty();
            }
            case 5: {
                return pSSysEAIElementAttrBase.isCreateManDirty();
            }
            case 6: {
                return pSSysEAIElementAttrBase.isDefaultValueDirty();
            }
            case 7: {
                return pSSysEAIElementAttrBase.isEAIElementAttrTypeDirty();
            }
            case 8: {
                return pSSysEAIElementAttrBase.isFixedValueDirty();
            }
            case 9: {
                return pSSysEAIElementAttrBase.isMemoDirty();
            }
            case 10: {
                return pSSysEAIElementAttrBase.isOrderValueDirty();
            }
            case 11: {
                return pSSysEAIElementAttrBase.isPSSysEAIDataTypeIdDirty();
            }
            case 12: {
                return pSSysEAIElementAttrBase.isPSSysEAIDataTypeNameDirty();
            }
            case 13: {
                return pSSysEAIElementAttrBase.isPSSysEAIElementAttrIdDirty();
            }
            case 14: {
                return pSSysEAIElementAttrBase.isPSSysEAIElementAttrNameDirty();
            }
            case 15: {
                return pSSysEAIElementAttrBase.isPSSysEAIElementIdDirty();
            }
            case 16: {
                return pSSysEAIElementAttrBase.isPSSysEAIElementNameDirty();
            }
            case 17: {
                return pSSysEAIElementAttrBase.isPSSysEAISchemeIdDirty();
            }
            case 18: {
                return pSSysEAIElementAttrBase.isRefPSSysEAIElementIdDirty();
            }
            case 19: {
                return pSSysEAIElementAttrBase.isRefPSSysEAIElementNameDirty();
            }
            case 20: {
                return pSSysEAIElementAttrBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysEAIElementAttrBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysEAIElementAttrBase.isUserCatDirty();
            }
            case 23: {
                return pSSysEAIElementAttrBase.isUserTagDirty();
            }
            case 24: {
                return pSSysEAIElementAttrBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysEAIElementAttrBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysEAIElementAttrBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysEAIElementAttrBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIElementAttrBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIElementAttrBase.getAllowEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allowempty", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getAllowEmpty()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getAttrTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrtag", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getAttrTag()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getAttrTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"attrtag2", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getAttrTag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getEAIElementAttrType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaielementattrtype", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getEAIElementAttrType()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getFixedValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixedvalue", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getFixedValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeid", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIDataTypeId()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypename", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIDataTypeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementattrid", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIElementAttrId()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementattrname", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIElementAttrName()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementname", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyseaielementid", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getRefPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyseaielementname", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getRefPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIElementAttrBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIElementAttrBase.getJSONValue((Object)pSSysEAIElementAttrBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIElementAttrBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIElementAttrBase.getAllowEmpty() != null) {
            object = pSSysEAIElementAttrBase.getAllowEmpty();
            xmlNode.setAttribute(FIELD_ALLOWEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIElementAttrBase.getAttrTag() != null) {
            object = pSSysEAIElementAttrBase.getAttrTag();
            xmlNode.setAttribute(FIELD_ATTRTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getAttrTag2() != null) {
            object = pSSysEAIElementAttrBase.getAttrTag2();
            xmlNode.setAttribute(FIELD_ATTRTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getCodeName() != null) {
            object = pSSysEAIElementAttrBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getCreateDate() != null) {
            object = pSSysEAIElementAttrBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementAttrBase.getCreateMan() != null) {
            object = pSSysEAIElementAttrBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getDefaultValue() != null) {
            object = pSSysEAIElementAttrBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getEAIElementAttrType() != null) {
            object = pSSysEAIElementAttrBase.getEAIElementAttrType();
            xmlNode.setAttribute(FIELD_EAIELEMENTATTRTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getFixedValue() != null) {
            object = pSSysEAIElementAttrBase.getFixedValue();
            xmlNode.setAttribute(FIELD_FIXEDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getMemo() != null) {
            object = pSSysEAIElementAttrBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getOrderValue() != null) {
            object = pSSysEAIElementAttrBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeId() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIDataTypeId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeName() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIDataTypeName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrId() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIElementAttrId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTATTRID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrName() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIElementAttrName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTATTRNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAIElementName() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAIElementAttrBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementId() != null) {
            object = pSSysEAIElementAttrBase.getRefPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_REFPSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementName() != null) {
            object = pSSysEAIElementAttrBase.getRefPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_REFPSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUpdateDate() != null) {
            object = pSSysEAIElementAttrBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementAttrBase.getUpdateMan() != null) {
            object = pSSysEAIElementAttrBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUserCat() != null) {
            object = pSSysEAIElementAttrBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag() != null) {
            object = pSSysEAIElementAttrBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag2() != null) {
            object = pSSysEAIElementAttrBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag3() != null) {
            object = pSSysEAIElementAttrBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getUserTag4() != null) {
            object = pSSysEAIElementAttrBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementAttrBase.getValidFlag() != null) {
            object = pSSysEAIElementAttrBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIElementAttrBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIElementAttrBase.isAllowEmptyDirty() && (bl || pSSysEAIElementAttrBase.getAllowEmpty() != null)) {
            iDataObject.set(FIELD_ALLOWEMPTY, (Object)pSSysEAIElementAttrBase.getAllowEmpty());
        }
        if (pSSysEAIElementAttrBase.isAttrTagDirty() && (bl || pSSysEAIElementAttrBase.getAttrTag() != null)) {
            iDataObject.set(FIELD_ATTRTAG, (Object)pSSysEAIElementAttrBase.getAttrTag());
        }
        if (pSSysEAIElementAttrBase.isAttrTag2Dirty() && (bl || pSSysEAIElementAttrBase.getAttrTag2() != null)) {
            iDataObject.set(FIELD_ATTRTAG2, (Object)pSSysEAIElementAttrBase.getAttrTag2());
        }
        if (pSSysEAIElementAttrBase.isCodeNameDirty() && (bl || pSSysEAIElementAttrBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIElementAttrBase.getCodeName());
        }
        if (pSSysEAIElementAttrBase.isCreateDateDirty() && (bl || pSSysEAIElementAttrBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIElementAttrBase.getCreateDate());
        }
        if (pSSysEAIElementAttrBase.isCreateManDirty() && (bl || pSSysEAIElementAttrBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIElementAttrBase.getCreateMan());
        }
        if (pSSysEAIElementAttrBase.isDefaultValueDirty() && (bl || pSSysEAIElementAttrBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysEAIElementAttrBase.getDefaultValue());
        }
        if (pSSysEAIElementAttrBase.isEAIElementAttrTypeDirty() && (bl || pSSysEAIElementAttrBase.getEAIElementAttrType() != null)) {
            iDataObject.set(FIELD_EAIELEMENTATTRTYPE, (Object)pSSysEAIElementAttrBase.getEAIElementAttrType());
        }
        if (pSSysEAIElementAttrBase.isFixedValueDirty() && (bl || pSSysEAIElementAttrBase.getFixedValue() != null)) {
            iDataObject.set(FIELD_FIXEDVALUE, (Object)pSSysEAIElementAttrBase.getFixedValue());
        }
        if (pSSysEAIElementAttrBase.isMemoDirty() && (bl || pSSysEAIElementAttrBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIElementAttrBase.getMemo());
        }
        if (pSSysEAIElementAttrBase.isOrderValueDirty() && (bl || pSSysEAIElementAttrBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysEAIElementAttrBase.getOrderValue());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIDataTypeIdDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEID, (Object)pSSysEAIElementAttrBase.getPSSysEAIDataTypeId());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIDataTypeNameDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIDataTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPENAME, (Object)pSSysEAIElementAttrBase.getPSSysEAIDataTypeName());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIElementAttrIdDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTATTRID, (Object)pSSysEAIElementAttrBase.getPSSysEAIElementAttrId());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIElementAttrNameDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIElementAttrName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTATTRNAME, (Object)pSSysEAIElementAttrBase.getPSSysEAIElementAttrName());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIElementAttrBase.getPSSysEAIElementId());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAIElementNameDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTNAME, (Object)pSSysEAIElementAttrBase.getPSSysEAIElementName());
        }
        if (pSSysEAIElementAttrBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAIElementAttrBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAIElementAttrBase.getPSSysEAISchemeId());
        }
        if (pSSysEAIElementAttrBase.isRefPSSysEAIElementIdDirty() && (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_REFPSSYSEAIELEMENTID, (Object)pSSysEAIElementAttrBase.getRefPSSysEAIElementId());
        }
        if (pSSysEAIElementAttrBase.isRefPSSysEAIElementNameDirty() && (bl || pSSysEAIElementAttrBase.getRefPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_REFPSSYSEAIELEMENTNAME, (Object)pSSysEAIElementAttrBase.getRefPSSysEAIElementName());
        }
        if (pSSysEAIElementAttrBase.isUpdateDateDirty() && (bl || pSSysEAIElementAttrBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIElementAttrBase.getUpdateDate());
        }
        if (pSSysEAIElementAttrBase.isUpdateManDirty() && (bl || pSSysEAIElementAttrBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIElementAttrBase.getUpdateMan());
        }
        if (pSSysEAIElementAttrBase.isUserCatDirty() && (bl || pSSysEAIElementAttrBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIElementAttrBase.getUserCat());
        }
        if (pSSysEAIElementAttrBase.isUserTagDirty() && (bl || pSSysEAIElementAttrBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIElementAttrBase.getUserTag());
        }
        if (pSSysEAIElementAttrBase.isUserTag2Dirty() && (bl || pSSysEAIElementAttrBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIElementAttrBase.getUserTag2());
        }
        if (pSSysEAIElementAttrBase.isUserTag3Dirty() && (bl || pSSysEAIElementAttrBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIElementAttrBase.getUserTag3());
        }
        if (pSSysEAIElementAttrBase.isUserTag4Dirty() && (bl || pSSysEAIElementAttrBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIElementAttrBase.getUserTag4());
        }
        if (pSSysEAIElementAttrBase.isValidFlagDirty() && (bl || pSSysEAIElementAttrBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIElementAttrBase.getValidFlag());
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
        return PSSysEAIElementAttrBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIElementAttrBase pSSysEAIElementAttrBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementAttrBase.resetAllowEmpty();
                return true;
            }
            case 1: {
                pSSysEAIElementAttrBase.resetAttrTag();
                return true;
            }
            case 2: {
                pSSysEAIElementAttrBase.resetAttrTag2();
                return true;
            }
            case 3: {
                pSSysEAIElementAttrBase.resetCodeName();
                return true;
            }
            case 4: {
                pSSysEAIElementAttrBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSSysEAIElementAttrBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSSysEAIElementAttrBase.resetDefaultValue();
                return true;
            }
            case 7: {
                pSSysEAIElementAttrBase.resetEAIElementAttrType();
                return true;
            }
            case 8: {
                pSSysEAIElementAttrBase.resetFixedValue();
                return true;
            }
            case 9: {
                pSSysEAIElementAttrBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysEAIElementAttrBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSSysEAIElementAttrBase.resetPSSysEAIDataTypeId();
                return true;
            }
            case 12: {
                pSSysEAIElementAttrBase.resetPSSysEAIDataTypeName();
                return true;
            }
            case 13: {
                pSSysEAIElementAttrBase.resetPSSysEAIElementAttrId();
                return true;
            }
            case 14: {
                pSSysEAIElementAttrBase.resetPSSysEAIElementAttrName();
                return true;
            }
            case 15: {
                pSSysEAIElementAttrBase.resetPSSysEAIElementId();
                return true;
            }
            case 16: {
                pSSysEAIElementAttrBase.resetPSSysEAIElementName();
                return true;
            }
            case 17: {
                pSSysEAIElementAttrBase.resetPSSysEAISchemeId();
                return true;
            }
            case 18: {
                pSSysEAIElementAttrBase.resetRefPSSysEAIElementId();
                return true;
            }
            case 19: {
                pSSysEAIElementAttrBase.resetRefPSSysEAIElementName();
                return true;
            }
            case 20: {
                pSSysEAIElementAttrBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysEAIElementAttrBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysEAIElementAttrBase.resetUserCat();
                return true;
            }
            case 23: {
                pSSysEAIElementAttrBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysEAIElementAttrBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysEAIElementAttrBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysEAIElementAttrBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysEAIElementAttrBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIDataType getPSSysEAIDataType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataType();
        }
        if (this.getPSSysEAIDataTypeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIDataTypeLock;
        synchronized (n) {
            if (this.pssyseaidatatype != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIDataTypeId(), (Object)this.pssyseaidatatype.getPSSysEAIDataTypeId()) != 0L) {
                this.pssyseaidatatype = null;
            }
            if (this.pssyseaidatatype == null) {
                PSSysEAIDataType pSSysEAIDataType = new PSSysEAIDataType();
                pSSysEAIDataType.setPSSysEAIDataTypeId(this.getPSSysEAIDataTypeId());
                PSSysEAIDataTypeService pSSysEAIDataTypeService = (PSSysEAIDataTypeService)ServiceGlobal.getService(PSSysEAIDataTypeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIDataTypeService.autoGet(pSSysEAIDataType);
                this.pssyseaidatatype = pSSysEAIDataType;
            }
            return this.pssyseaidatatype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElement getPSSysEAIElement() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElement();
        }
        if (this.getPSSysEAIElementId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAIElementLock;
        synchronized (n) {
            if (this.pssyseaielement != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAIElementId(), (Object)this.pssyseaielement.getPSSysEAIElementId()) != 0L) {
                this.pssyseaielement = null;
            }
            if (this.pssyseaielement == null) {
                PSSysEAIElement pSSysEAIElement = new PSSysEAIElement();
                pSSysEAIElement.setPSSysEAIElementId(this.getPSSysEAIElementId());
                PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementService.autoGet(pSSysEAIElement);
                this.pssyseaielement = pSSysEAIElement;
            }
            return this.pssyseaielement;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIElement getRefPSSysEAIElement() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSSysEAIElement();
        }
        if (this.getRefPSSysEAIElementId() == null) {
            return null;
        }
        Integer n = this.objRefPSSysEAIElementLock;
        synchronized (n) {
            if (this.refpssyseaielement != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSSysEAIElementId(), (Object)this.refpssyseaielement.getPSSysEAIElementId()) != 0L) {
                this.refpssyseaielement = null;
            }
            if (this.refpssyseaielement == null) {
                PSSysEAIElement pSSysEAIElement = new PSSysEAIElement();
                pSSysEAIElement.setPSSysEAIElementId(this.getRefPSSysEAIElementId());
                PSSysEAIElementService pSSysEAIElementService = (PSSysEAIElementService)ServiceGlobal.getService(PSSysEAIElementService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAIElementService.autoGet(pSSysEAIElement);
                this.refpssyseaielement = pSSysEAIElement;
            }
            return this.refpssyseaielement;
        }
    }

    private PSSysEAIElementAttrBase getProxyEntity() {
        return this.proxyPSSysEAIElementAttrBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIElementAttrBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIElementAttrBase) {
            this.proxyPSSysEAIElementAttrBase = (PSSysEAIElementAttrBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementAttrService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLOWEMPTY, 0);
        fieldIndexMap.put(FIELD_ATTRTAG, 1);
        fieldIndexMap.put(FIELD_ATTRTAG2, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 6);
        fieldIndexMap.put(FIELD_EAIELEMENTATTRTYPE, 7);
        fieldIndexMap.put(FIELD_FIXEDVALUE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEID, 11);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPENAME, 12);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTATTRID, 13);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTATTRNAME, 14);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 15);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 17);
        fieldIndexMap.put(FIELD_REFPSSYSEAIELEMENTID, 18);
        fieldIndexMap.put(FIELD_REFPSSYSEAIELEMENTNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_VALIDFLAG, 27);
    }
}

