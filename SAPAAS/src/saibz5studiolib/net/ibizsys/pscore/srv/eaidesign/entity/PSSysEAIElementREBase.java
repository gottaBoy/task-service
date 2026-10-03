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

public abstract class PSSysEAIElementREBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIElementREBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_EAIELEMENTRETYPE = "EAIELEMENTRETYPE";
    public static final String FIELD_FIXEDVALUE = "FIXEDVALUE";
    public static final String FIELD_MAXOCCURS = "MAXOCCURS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINOCCURS = "MINOCCURS";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String FIELD_PSSYSEAIELEMENTID = "PSSYSEAIELEMENTID";
    public static final String FIELD_PSSYSEAIELEMENTNAME = "PSSYSEAIELEMENTNAME";
    public static final String FIELD_PSSYSEAIELEMENTREID = "PSSYSEAIELEMENTREID";
    public static final String FIELD_PSSYSEAIELEMENTRENAME = "PSSYSEAIELEMENTRENAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_REFPSSYSEAIELEMENTID = "REFPSSYSEAIELEMENTID";
    public static final String FIELD_REFPSSYSEAIELEMENTNAME = "REFPSSYSEAIELEMENTNAME";
    public static final String FIELD_RETAG = "RETAG";
    public static final String FIELD_RETAG2 = "RETAG2";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEFAULTVALUE = 3;
    private static final int INDEX_EAIELEMENTRETYPE = 4;
    private static final int INDEX_FIXEDVALUE = 5;
    private static final int INDEX_MAXOCCURS = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_MINOCCURS = 8;
    private static final int INDEX_ORDERVALUE = 9;
    private static final int INDEX_PSSYSEAIDATATYPEID = 10;
    private static final int INDEX_PSSYSEAIDATATYPENAME = 11;
    private static final int INDEX_PSSYSEAIELEMENTID = 12;
    private static final int INDEX_PSSYSEAIELEMENTNAME = 13;
    private static final int INDEX_PSSYSEAIELEMENTREID = 14;
    private static final int INDEX_PSSYSEAIELEMENTRENAME = 15;
    private static final int INDEX_PSSYSEAISCHEMEID = 16;
    private static final int INDEX_REFPSSYSEAIELEMENTID = 17;
    private static final int INDEX_REFPSSYSEAIELEMENTNAME = 18;
    private static final int INDEX_RETAG = 19;
    private static final int INDEX_RETAG2 = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final int INDEX_USERCAT = 23;
    private static final int INDEX_USERTAG = 24;
    private static final int INDEX_USERTAG2 = 25;
    private static final int INDEX_USERTAG3 = 26;
    private static final int INDEX_USERTAG4 = 27;
    private static final int INDEX_VALIDFLAG = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIElementREBase proxyPSSysEAIElementREBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean eaielementretypeDirtyFlag = false;
    private boolean fixedvalueDirtyFlag = false;
    private boolean maxoccursDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minoccursDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pssyseaidatatypeidDirtyFlag = false;
    private boolean pssyseaidatatypenameDirtyFlag = false;
    private boolean pssyseaielementidDirtyFlag = false;
    private boolean pssyseaielementnameDirtyFlag = false;
    private boolean pssyseaielementreidDirtyFlag = false;
    private boolean pssyseaielementrenameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean refpssyseaielementidDirtyFlag = false;
    private boolean refpssyseaielementnameDirtyFlag = false;
    private boolean retagDirtyFlag = false;
    private boolean retag2DirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="eaielementretype")
    private String eaielementretype;
    @Column(name="fixedvalue")
    private String fixedvalue;
    @Column(name="maxoccurs")
    private Integer maxoccurs;
    @Column(name="memo")
    private String memo;
    @Column(name="minoccurs")
    private Integer minoccurs;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pssyseaidatatypeid")
    private String pssyseaidatatypeid;
    @Column(name="pssyseaidatatypename")
    private String pssyseaidatatypename;
    @Column(name="pssyseaielementid")
    private String pssyseaielementid;
    @Column(name="pssyseaielementname")
    private String pssyseaielementname;
    @Column(name="pssyseaielementreid")
    private String pssyseaielementreid;
    @Column(name="pssyseaielementrename")
    private String pssyseaielementrename;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="refpssyseaielementid")
    private String refpssyseaielementid;
    @Column(name="refpssyseaielementname")
    private String refpssyseaielementname;
    @Column(name="retag")
    private String retag;
    @Column(name="retag2")
    private String retag2;
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

    public void setEAIElementREType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIElementREType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaielementretype = string;
        this.eaielementretypeDirtyFlag = true;
    }

    public String getEAIElementREType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIElementREType();
        }
        return this.eaielementretype;
    }

    public boolean isEAIElementRETypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIElementRETypeDirty();
        }
        return this.eaielementretypeDirtyFlag;
    }

    public void resetEAIElementREType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIElementREType();
            return;
        }
        this.eaielementretypeDirtyFlag = false;
        this.eaielementretype = null;
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

    public void setMaxOccurs(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxOccurs(n);
            return;
        }
        this.maxoccurs = n;
        this.maxoccursDirtyFlag = true;
    }

    public Integer getMaxOccurs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxOccurs();
        }
        return this.maxoccurs;
    }

    public boolean isMaxOccursDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxOccursDirty();
        }
        return this.maxoccursDirtyFlag;
    }

    public void resetMaxOccurs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxOccurs();
            return;
        }
        this.maxoccursDirtyFlag = false;
        this.maxoccurs = null;
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

    public void setMinOccurs(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinOccurs(n);
            return;
        }
        this.minoccurs = n;
        this.minoccursDirtyFlag = true;
    }

    public Integer getMinOccurs() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinOccurs();
        }
        return this.minoccurs;
    }

    public boolean isMinOccursDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinOccursDirty();
        }
        return this.minoccursDirtyFlag;
    }

    public void resetMinOccurs() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinOccurs();
            return;
        }
        this.minoccursDirtyFlag = false;
        this.minoccurs = null;
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

    public void setPSSysEAIElementREId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementREId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementreid = string;
        this.pssyseaielementreidDirtyFlag = true;
    }

    public String getPSSysEAIElementREId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementREId();
        }
        return this.pssyseaielementreid;
    }

    public boolean isPSSysEAIElementREIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementREIdDirty();
        }
        return this.pssyseaielementreidDirtyFlag;
    }

    public void resetPSSysEAIElementREId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementREId();
            return;
        }
        this.pssyseaielementreidDirtyFlag = false;
        this.pssyseaielementreid = null;
    }

    public void setPSSysEAIElementREName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAIElementREName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaielementrename = string;
        this.pssyseaielementrenameDirtyFlag = true;
    }

    public String getPSSysEAIElementREName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIElementREName();
        }
        return this.pssyseaielementrename;
    }

    public boolean isPSSysEAIElementRENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAIElementRENameDirty();
        }
        return this.pssyseaielementrenameDirtyFlag;
    }

    public void resetPSSysEAIElementREName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAIElementREName();
            return;
        }
        this.pssyseaielementrenameDirtyFlag = false;
        this.pssyseaielementrename = null;
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

    public void setRETag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRETag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retag = string;
        this.retagDirtyFlag = true;
    }

    public String getRETag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRETag();
        }
        return this.retag;
    }

    public boolean isRETagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRETagDirty();
        }
        return this.retagDirtyFlag;
    }

    public void resetRETag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRETag();
            return;
        }
        this.retagDirtyFlag = false;
        this.retag = null;
    }

    public void setRETag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRETag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.retag2 = string;
        this.retag2DirtyFlag = true;
    }

    public String getRETag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRETag2();
        }
        return this.retag2;
    }

    public boolean isRETag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRETag2Dirty();
        }
        return this.retag2DirtyFlag;
    }

    public void resetRETag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRETag2();
            return;
        }
        this.retag2DirtyFlag = false;
        this.retag2 = null;
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
        PSSysEAIElementREBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIElementREBase pSSysEAIElementREBase) {
        pSSysEAIElementREBase.resetCodeName();
        pSSysEAIElementREBase.resetCreateDate();
        pSSysEAIElementREBase.resetCreateMan();
        pSSysEAIElementREBase.resetDefaultValue();
        pSSysEAIElementREBase.resetEAIElementREType();
        pSSysEAIElementREBase.resetFixedValue();
        pSSysEAIElementREBase.resetMaxOccurs();
        pSSysEAIElementREBase.resetMemo();
        pSSysEAIElementREBase.resetMinOccurs();
        pSSysEAIElementREBase.resetOrderValue();
        pSSysEAIElementREBase.resetPSSysEAIDataTypeId();
        pSSysEAIElementREBase.resetPSSysEAIDataTypeName();
        pSSysEAIElementREBase.resetPSSysEAIElementId();
        pSSysEAIElementREBase.resetPSSysEAIElementName();
        pSSysEAIElementREBase.resetPSSysEAIElementREId();
        pSSysEAIElementREBase.resetPSSysEAIElementREName();
        pSSysEAIElementREBase.resetPSSysEAISchemeId();
        pSSysEAIElementREBase.resetRefPSSysEAIElementId();
        pSSysEAIElementREBase.resetRefPSSysEAIElementName();
        pSSysEAIElementREBase.resetRETag();
        pSSysEAIElementREBase.resetRETag2();
        pSSysEAIElementREBase.resetUpdateDate();
        pSSysEAIElementREBase.resetUpdateMan();
        pSSysEAIElementREBase.resetUserCat();
        pSSysEAIElementREBase.resetUserTag();
        pSSysEAIElementREBase.resetUserTag2();
        pSSysEAIElementREBase.resetUserTag3();
        pSSysEAIElementREBase.resetUserTag4();
        pSSysEAIElementREBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
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
        if (!bl || this.isEAIElementRETypeDirty()) {
            hashMap.put(FIELD_EAIELEMENTRETYPE, this.getEAIElementREType());
        }
        if (!bl || this.isFixedValueDirty()) {
            hashMap.put(FIELD_FIXEDVALUE, this.getFixedValue());
        }
        if (!bl || this.isMaxOccursDirty()) {
            hashMap.put(FIELD_MAXOCCURS, this.getMaxOccurs());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinOccursDirty()) {
            hashMap.put(FIELD_MINOCCURS, this.getMinOccurs());
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
        if (!bl || this.isPSSysEAIElementIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTID, this.getPSSysEAIElementId());
        }
        if (!bl || this.isPSSysEAIElementNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTNAME, this.getPSSysEAIElementName());
        }
        if (!bl || this.isPSSysEAIElementREIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTREID, this.getPSSysEAIElementREId());
        }
        if (!bl || this.isPSSysEAIElementRENameDirty()) {
            hashMap.put(FIELD_PSSYSEAIELEMENTRENAME, this.getPSSysEAIElementREName());
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
        if (!bl || this.isRETagDirty()) {
            hashMap.put(FIELD_RETAG, this.getRETag());
        }
        if (!bl || this.isRETag2Dirty()) {
            hashMap.put(FIELD_RETAG2, this.getRETag2());
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
        return PSSysEAIElementREBase.get(this, n);
    }

    private static Object get(PSSysEAIElementREBase pSSysEAIElementREBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementREBase.getCodeName();
            }
            case 1: {
                return pSSysEAIElementREBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIElementREBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIElementREBase.getDefaultValue();
            }
            case 4: {
                return pSSysEAIElementREBase.getEAIElementREType();
            }
            case 5: {
                return pSSysEAIElementREBase.getFixedValue();
            }
            case 6: {
                return pSSysEAIElementREBase.getMaxOccurs();
            }
            case 7: {
                return pSSysEAIElementREBase.getMemo();
            }
            case 8: {
                return pSSysEAIElementREBase.getMinOccurs();
            }
            case 9: {
                return pSSysEAIElementREBase.getOrderValue();
            }
            case 10: {
                return pSSysEAIElementREBase.getPSSysEAIDataTypeId();
            }
            case 11: {
                return pSSysEAIElementREBase.getPSSysEAIDataTypeName();
            }
            case 12: {
                return pSSysEAIElementREBase.getPSSysEAIElementId();
            }
            case 13: {
                return pSSysEAIElementREBase.getPSSysEAIElementName();
            }
            case 14: {
                return pSSysEAIElementREBase.getPSSysEAIElementREId();
            }
            case 15: {
                return pSSysEAIElementREBase.getPSSysEAIElementREName();
            }
            case 16: {
                return pSSysEAIElementREBase.getPSSysEAISchemeId();
            }
            case 17: {
                return pSSysEAIElementREBase.getRefPSSysEAIElementId();
            }
            case 18: {
                return pSSysEAIElementREBase.getRefPSSysEAIElementName();
            }
            case 19: {
                return pSSysEAIElementREBase.getRETag();
            }
            case 20: {
                return pSSysEAIElementREBase.getRETag2();
            }
            case 21: {
                return pSSysEAIElementREBase.getUpdateDate();
            }
            case 22: {
                return pSSysEAIElementREBase.getUpdateMan();
            }
            case 23: {
                return pSSysEAIElementREBase.getUserCat();
            }
            case 24: {
                return pSSysEAIElementREBase.getUserTag();
            }
            case 25: {
                return pSSysEAIElementREBase.getUserTag2();
            }
            case 26: {
                return pSSysEAIElementREBase.getUserTag3();
            }
            case 27: {
                return pSSysEAIElementREBase.getUserTag4();
            }
            case 28: {
                return pSSysEAIElementREBase.getValidFlag();
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
        PSSysEAIElementREBase.set(this, n, object);
    }

    private static void set(PSSysEAIElementREBase pSSysEAIElementREBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementREBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIElementREBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIElementREBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIElementREBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIElementREBase.setEAIElementREType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIElementREBase.setFixedValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIElementREBase.setMaxOccurs(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIElementREBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIElementREBase.setMinOccurs(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIElementREBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIElementREBase.setPSSysEAIDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIElementREBase.setPSSysEAIDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIElementREBase.setPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIElementREBase.setPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIElementREBase.setPSSysEAIElementREId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIElementREBase.setPSSysEAIElementREName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIElementREBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIElementREBase.setRefPSSysEAIElementId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIElementREBase.setRefPSSysEAIElementName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIElementREBase.setRETag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIElementREBase.setRETag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIElementREBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAIElementREBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAIElementREBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEAIElementREBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEAIElementREBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEAIElementREBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysEAIElementREBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysEAIElementREBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIElementREBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIElementREBase pSSysEAIElementREBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementREBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIElementREBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIElementREBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIElementREBase.getDefaultValue() == null;
            }
            case 4: {
                return pSSysEAIElementREBase.getEAIElementREType() == null;
            }
            case 5: {
                return pSSysEAIElementREBase.getFixedValue() == null;
            }
            case 6: {
                return pSSysEAIElementREBase.getMaxOccurs() == null;
            }
            case 7: {
                return pSSysEAIElementREBase.getMemo() == null;
            }
            case 8: {
                return pSSysEAIElementREBase.getMinOccurs() == null;
            }
            case 9: {
                return pSSysEAIElementREBase.getOrderValue() == null;
            }
            case 10: {
                return pSSysEAIElementREBase.getPSSysEAIDataTypeId() == null;
            }
            case 11: {
                return pSSysEAIElementREBase.getPSSysEAIDataTypeName() == null;
            }
            case 12: {
                return pSSysEAIElementREBase.getPSSysEAIElementId() == null;
            }
            case 13: {
                return pSSysEAIElementREBase.getPSSysEAIElementName() == null;
            }
            case 14: {
                return pSSysEAIElementREBase.getPSSysEAIElementREId() == null;
            }
            case 15: {
                return pSSysEAIElementREBase.getPSSysEAIElementREName() == null;
            }
            case 16: {
                return pSSysEAIElementREBase.getPSSysEAISchemeId() == null;
            }
            case 17: {
                return pSSysEAIElementREBase.getRefPSSysEAIElementId() == null;
            }
            case 18: {
                return pSSysEAIElementREBase.getRefPSSysEAIElementName() == null;
            }
            case 19: {
                return pSSysEAIElementREBase.getRETag() == null;
            }
            case 20: {
                return pSSysEAIElementREBase.getRETag2() == null;
            }
            case 21: {
                return pSSysEAIElementREBase.getUpdateDate() == null;
            }
            case 22: {
                return pSSysEAIElementREBase.getUpdateMan() == null;
            }
            case 23: {
                return pSSysEAIElementREBase.getUserCat() == null;
            }
            case 24: {
                return pSSysEAIElementREBase.getUserTag() == null;
            }
            case 25: {
                return pSSysEAIElementREBase.getUserTag2() == null;
            }
            case 26: {
                return pSSysEAIElementREBase.getUserTag3() == null;
            }
            case 27: {
                return pSSysEAIElementREBase.getUserTag4() == null;
            }
            case 28: {
                return pSSysEAIElementREBase.getValidFlag() == null;
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
        return PSSysEAIElementREBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIElementREBase pSSysEAIElementREBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIElementREBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIElementREBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIElementREBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIElementREBase.isDefaultValueDirty();
            }
            case 4: {
                return pSSysEAIElementREBase.isEAIElementRETypeDirty();
            }
            case 5: {
                return pSSysEAIElementREBase.isFixedValueDirty();
            }
            case 6: {
                return pSSysEAIElementREBase.isMaxOccursDirty();
            }
            case 7: {
                return pSSysEAIElementREBase.isMemoDirty();
            }
            case 8: {
                return pSSysEAIElementREBase.isMinOccursDirty();
            }
            case 9: {
                return pSSysEAIElementREBase.isOrderValueDirty();
            }
            case 10: {
                return pSSysEAIElementREBase.isPSSysEAIDataTypeIdDirty();
            }
            case 11: {
                return pSSysEAIElementREBase.isPSSysEAIDataTypeNameDirty();
            }
            case 12: {
                return pSSysEAIElementREBase.isPSSysEAIElementIdDirty();
            }
            case 13: {
                return pSSysEAIElementREBase.isPSSysEAIElementNameDirty();
            }
            case 14: {
                return pSSysEAIElementREBase.isPSSysEAIElementREIdDirty();
            }
            case 15: {
                return pSSysEAIElementREBase.isPSSysEAIElementRENameDirty();
            }
            case 16: {
                return pSSysEAIElementREBase.isPSSysEAISchemeIdDirty();
            }
            case 17: {
                return pSSysEAIElementREBase.isRefPSSysEAIElementIdDirty();
            }
            case 18: {
                return pSSysEAIElementREBase.isRefPSSysEAIElementNameDirty();
            }
            case 19: {
                return pSSysEAIElementREBase.isRETagDirty();
            }
            case 20: {
                return pSSysEAIElementREBase.isRETag2Dirty();
            }
            case 21: {
                return pSSysEAIElementREBase.isUpdateDateDirty();
            }
            case 22: {
                return pSSysEAIElementREBase.isUpdateManDirty();
            }
            case 23: {
                return pSSysEAIElementREBase.isUserCatDirty();
            }
            case 24: {
                return pSSysEAIElementREBase.isUserTagDirty();
            }
            case 25: {
                return pSSysEAIElementREBase.isUserTag2Dirty();
            }
            case 26: {
                return pSSysEAIElementREBase.isUserTag3Dirty();
            }
            case 27: {
                return pSSysEAIElementREBase.isUserTag4Dirty();
            }
            case 28: {
                return pSSysEAIElementREBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIElementREBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIElementREBase pSSysEAIElementREBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIElementREBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getEAIElementREType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaielementretype", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getEAIElementREType()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getFixedValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fixedvalue", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getFixedValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getMaxOccurs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxoccurs", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getMaxOccurs()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getMinOccurs() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minoccurs", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getMinOccurs()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeid", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIDataTypeId()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypename", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIDataTypeName()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementid", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementname", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementREId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementreid", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIElementREId()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementREName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaielementrename", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAIElementREName()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getRefPSSysEAIElementId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyseaielementid", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getRefPSSysEAIElementId()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getRefPSSysEAIElementName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpssyseaielementname", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getRefPSSysEAIElementName()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getRETag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retag", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getRETag()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getRETag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"retag2", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getRETag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIElementREBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIElementREBase.getJSONValue((Object)pSSysEAIElementREBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIElementREBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIElementREBase pSSysEAIElementREBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIElementREBase.getCodeName() != null) {
            object = pSSysEAIElementREBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getCreateDate() != null) {
            object = pSSysEAIElementREBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementREBase.getCreateMan() != null) {
            object = pSSysEAIElementREBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getDefaultValue() != null) {
            object = pSSysEAIElementREBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getEAIElementREType() != null) {
            object = pSSysEAIElementREBase.getEAIElementREType();
            xmlNode.setAttribute(FIELD_EAIELEMENTRETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getFixedValue() != null) {
            object = pSSysEAIElementREBase.getFixedValue();
            xmlNode.setAttribute(FIELD_FIXEDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getMaxOccurs() != null) {
            object = pSSysEAIElementREBase.getMaxOccurs();
            xmlNode.setAttribute(FIELD_MAXOCCURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIElementREBase.getMemo() != null) {
            object = pSSysEAIElementREBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getMinOccurs() != null) {
            object = pSSysEAIElementREBase.getMinOccurs();
            xmlNode.setAttribute(FIELD_MINOCCURS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIElementREBase.getOrderValue() != null) {
            object = pSSysEAIElementREBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeId() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIDataTypeId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeName() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIDataTypeName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementId() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementName() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementREId() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIElementREId();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTREID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAIElementREName() != null) {
            object = pSSysEAIElementREBase.getPSSysEAIElementREName();
            xmlNode.setAttribute(FIELD_PSSYSEAIELEMENTRENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAIElementREBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getRefPSSysEAIElementId() != null) {
            object = pSSysEAIElementREBase.getRefPSSysEAIElementId();
            xmlNode.setAttribute(FIELD_REFPSSYSEAIELEMENTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getRefPSSysEAIElementName() != null) {
            object = pSSysEAIElementREBase.getRefPSSysEAIElementName();
            xmlNode.setAttribute(FIELD_REFPSSYSEAIELEMENTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getRETag() != null) {
            object = pSSysEAIElementREBase.getRETag();
            xmlNode.setAttribute(FIELD_RETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getRETag2() != null) {
            object = pSSysEAIElementREBase.getRETag2();
            xmlNode.setAttribute(FIELD_RETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUpdateDate() != null) {
            object = pSSysEAIElementREBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIElementREBase.getUpdateMan() != null) {
            object = pSSysEAIElementREBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUserCat() != null) {
            object = pSSysEAIElementREBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUserTag() != null) {
            object = pSSysEAIElementREBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUserTag2() != null) {
            object = pSSysEAIElementREBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUserTag3() != null) {
            object = pSSysEAIElementREBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getUserTag4() != null) {
            object = pSSysEAIElementREBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIElementREBase.getValidFlag() != null) {
            object = pSSysEAIElementREBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIElementREBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIElementREBase pSSysEAIElementREBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIElementREBase.isCodeNameDirty() && (bl || pSSysEAIElementREBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIElementREBase.getCodeName());
        }
        if (pSSysEAIElementREBase.isCreateDateDirty() && (bl || pSSysEAIElementREBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIElementREBase.getCreateDate());
        }
        if (pSSysEAIElementREBase.isCreateManDirty() && (bl || pSSysEAIElementREBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIElementREBase.getCreateMan());
        }
        if (pSSysEAIElementREBase.isDefaultValueDirty() && (bl || pSSysEAIElementREBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSSysEAIElementREBase.getDefaultValue());
        }
        if (pSSysEAIElementREBase.isEAIElementRETypeDirty() && (bl || pSSysEAIElementREBase.getEAIElementREType() != null)) {
            iDataObject.set(FIELD_EAIELEMENTRETYPE, (Object)pSSysEAIElementREBase.getEAIElementREType());
        }
        if (pSSysEAIElementREBase.isFixedValueDirty() && (bl || pSSysEAIElementREBase.getFixedValue() != null)) {
            iDataObject.set(FIELD_FIXEDVALUE, (Object)pSSysEAIElementREBase.getFixedValue());
        }
        if (pSSysEAIElementREBase.isMaxOccursDirty() && (bl || pSSysEAIElementREBase.getMaxOccurs() != null)) {
            iDataObject.set(FIELD_MAXOCCURS, (Object)pSSysEAIElementREBase.getMaxOccurs());
        }
        if (pSSysEAIElementREBase.isMemoDirty() && (bl || pSSysEAIElementREBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIElementREBase.getMemo());
        }
        if (pSSysEAIElementREBase.isMinOccursDirty() && (bl || pSSysEAIElementREBase.getMinOccurs() != null)) {
            iDataObject.set(FIELD_MINOCCURS, (Object)pSSysEAIElementREBase.getMinOccurs());
        }
        if (pSSysEAIElementREBase.isOrderValueDirty() && (bl || pSSysEAIElementREBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysEAIElementREBase.getOrderValue());
        }
        if (pSSysEAIElementREBase.isPSSysEAIDataTypeIdDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEID, (Object)pSSysEAIElementREBase.getPSSysEAIDataTypeId());
        }
        if (pSSysEAIElementREBase.isPSSysEAIDataTypeNameDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIDataTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPENAME, (Object)pSSysEAIElementREBase.getPSSysEAIDataTypeName());
        }
        if (pSSysEAIElementREBase.isPSSysEAIElementIdDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTID, (Object)pSSysEAIElementREBase.getPSSysEAIElementId());
        }
        if (pSSysEAIElementREBase.isPSSysEAIElementNameDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTNAME, (Object)pSSysEAIElementREBase.getPSSysEAIElementName());
        }
        if (pSSysEAIElementREBase.isPSSysEAIElementREIdDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIElementREId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTREID, (Object)pSSysEAIElementREBase.getPSSysEAIElementREId());
        }
        if (pSSysEAIElementREBase.isPSSysEAIElementRENameDirty() && (bl || pSSysEAIElementREBase.getPSSysEAIElementREName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIELEMENTRENAME, (Object)pSSysEAIElementREBase.getPSSysEAIElementREName());
        }
        if (pSSysEAIElementREBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAIElementREBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAIElementREBase.getPSSysEAISchemeId());
        }
        if (pSSysEAIElementREBase.isRefPSSysEAIElementIdDirty() && (bl || pSSysEAIElementREBase.getRefPSSysEAIElementId() != null)) {
            iDataObject.set(FIELD_REFPSSYSEAIELEMENTID, (Object)pSSysEAIElementREBase.getRefPSSysEAIElementId());
        }
        if (pSSysEAIElementREBase.isRefPSSysEAIElementNameDirty() && (bl || pSSysEAIElementREBase.getRefPSSysEAIElementName() != null)) {
            iDataObject.set(FIELD_REFPSSYSEAIELEMENTNAME, (Object)pSSysEAIElementREBase.getRefPSSysEAIElementName());
        }
        if (pSSysEAIElementREBase.isRETagDirty() && (bl || pSSysEAIElementREBase.getRETag() != null)) {
            iDataObject.set(FIELD_RETAG, (Object)pSSysEAIElementREBase.getRETag());
        }
        if (pSSysEAIElementREBase.isRETag2Dirty() && (bl || pSSysEAIElementREBase.getRETag2() != null)) {
            iDataObject.set(FIELD_RETAG2, (Object)pSSysEAIElementREBase.getRETag2());
        }
        if (pSSysEAIElementREBase.isUpdateDateDirty() && (bl || pSSysEAIElementREBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIElementREBase.getUpdateDate());
        }
        if (pSSysEAIElementREBase.isUpdateManDirty() && (bl || pSSysEAIElementREBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIElementREBase.getUpdateMan());
        }
        if (pSSysEAIElementREBase.isUserCatDirty() && (bl || pSSysEAIElementREBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIElementREBase.getUserCat());
        }
        if (pSSysEAIElementREBase.isUserTagDirty() && (bl || pSSysEAIElementREBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIElementREBase.getUserTag());
        }
        if (pSSysEAIElementREBase.isUserTag2Dirty() && (bl || pSSysEAIElementREBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIElementREBase.getUserTag2());
        }
        if (pSSysEAIElementREBase.isUserTag3Dirty() && (bl || pSSysEAIElementREBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIElementREBase.getUserTag3());
        }
        if (pSSysEAIElementREBase.isUserTag4Dirty() && (bl || pSSysEAIElementREBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIElementREBase.getUserTag4());
        }
        if (pSSysEAIElementREBase.isValidFlagDirty() && (bl || pSSysEAIElementREBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIElementREBase.getValidFlag());
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
        return PSSysEAIElementREBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIElementREBase pSSysEAIElementREBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIElementREBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIElementREBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIElementREBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIElementREBase.resetDefaultValue();
                return true;
            }
            case 4: {
                pSSysEAIElementREBase.resetEAIElementREType();
                return true;
            }
            case 5: {
                pSSysEAIElementREBase.resetFixedValue();
                return true;
            }
            case 6: {
                pSSysEAIElementREBase.resetMaxOccurs();
                return true;
            }
            case 7: {
                pSSysEAIElementREBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysEAIElementREBase.resetMinOccurs();
                return true;
            }
            case 9: {
                pSSysEAIElementREBase.resetOrderValue();
                return true;
            }
            case 10: {
                pSSysEAIElementREBase.resetPSSysEAIDataTypeId();
                return true;
            }
            case 11: {
                pSSysEAIElementREBase.resetPSSysEAIDataTypeName();
                return true;
            }
            case 12: {
                pSSysEAIElementREBase.resetPSSysEAIElementId();
                return true;
            }
            case 13: {
                pSSysEAIElementREBase.resetPSSysEAIElementName();
                return true;
            }
            case 14: {
                pSSysEAIElementREBase.resetPSSysEAIElementREId();
                return true;
            }
            case 15: {
                pSSysEAIElementREBase.resetPSSysEAIElementREName();
                return true;
            }
            case 16: {
                pSSysEAIElementREBase.resetPSSysEAISchemeId();
                return true;
            }
            case 17: {
                pSSysEAIElementREBase.resetRefPSSysEAIElementId();
                return true;
            }
            case 18: {
                pSSysEAIElementREBase.resetRefPSSysEAIElementName();
                return true;
            }
            case 19: {
                pSSysEAIElementREBase.resetRETag();
                return true;
            }
            case 20: {
                pSSysEAIElementREBase.resetRETag2();
                return true;
            }
            case 21: {
                pSSysEAIElementREBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSSysEAIElementREBase.resetUpdateMan();
                return true;
            }
            case 23: {
                pSSysEAIElementREBase.resetUserCat();
                return true;
            }
            case 24: {
                pSSysEAIElementREBase.resetUserTag();
                return true;
            }
            case 25: {
                pSSysEAIElementREBase.resetUserTag2();
                return true;
            }
            case 26: {
                pSSysEAIElementREBase.resetUserTag3();
                return true;
            }
            case 27: {
                pSSysEAIElementREBase.resetUserTag4();
                return true;
            }
            case 28: {
                pSSysEAIElementREBase.resetValidFlag();
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

    private PSSysEAIElementREBase getProxyEntity() {
        return this.proxyPSSysEAIElementREBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIElementREBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIElementREBase) {
            this.proxyPSSysEAIElementREBase = (PSSysEAIElementREBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIElementREService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 3);
        fieldIndexMap.put(FIELD_EAIELEMENTRETYPE, 4);
        fieldIndexMap.put(FIELD_FIXEDVALUE, 5);
        fieldIndexMap.put(FIELD_MAXOCCURS, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_MINOCCURS, 8);
        fieldIndexMap.put(FIELD_ORDERVALUE, 9);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEID, 10);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTID, 12);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTREID, 14);
        fieldIndexMap.put(FIELD_PSSYSEAIELEMENTRENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 16);
        fieldIndexMap.put(FIELD_REFPSSYSEAIELEMENTID, 17);
        fieldIndexMap.put(FIELD_REFPSSYSEAIELEMENTNAME, 18);
        fieldIndexMap.put(FIELD_RETAG, 19);
        fieldIndexMap.put(FIELD_RETAG2, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
        fieldIndexMap.put(FIELD_USERCAT, 23);
        fieldIndexMap.put(FIELD_USERTAG, 24);
        fieldIndexMap.put(FIELD_USERTAG2, 25);
        fieldIndexMap.put(FIELD_USERTAG3, 26);
        fieldIndexMap.put(FIELD_USERTAG4, 27);
        fieldIndexMap.put(FIELD_VALIDFLAG, 28);
    }
}

