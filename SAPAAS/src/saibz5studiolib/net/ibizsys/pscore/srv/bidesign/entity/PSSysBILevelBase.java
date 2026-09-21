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
package net.ibizsys.pscore.srv.bidesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBILevelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBILevelBase.class);
    public static final String FIELD_AGGCAPTION = "AGGCAPTION";
    public static final String FIELD_BILEVELTAG = "BILEVELTAG";
    public static final String FIELD_BILEVELTAG2 = "BILEVELTAG2";
    public static final String FIELD_BILEVELTYPE = "BILEVELTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBIHIERARCHYID = "PSSYSBIHIERARCHYID";
    public static final String FIELD_PSSYSBIHIERARCHYNAME = "PSSYSBIHIERARCHYNAME";
    public static final String FIELD_PSSYSBILEVELID = "PSSYSBILEVELID";
    public static final String FIELD_PSSYSBILEVELNAME = "PSSYSBILEVELNAME";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_UNIQUEMEMBERS = "UNIQUEMEMBERS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUEPSDEFID = "VALUEPSDEFID";
    public static final String FIELD_VALUEPSDEFNAME = "VALUEPSDEFNAME";
    private static final int INDEX_AGGCAPTION = 0;
    private static final int INDEX_BILEVELTAG = 1;
    private static final int INDEX_BILEVELTAG2 = 2;
    private static final int INDEX_BILEVELTYPE = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSDEID = 9;
    private static final int INDEX_PSSYSBIHIERARCHYID = 10;
    private static final int INDEX_PSSYSBIHIERARCHYNAME = 11;
    private static final int INDEX_PSSYSBILEVELID = 12;
    private static final int INDEX_PSSYSBILEVELNAME = 13;
    private static final int INDEX_TEXTPSDEFID = 14;
    private static final int INDEX_TEXTPSDEFNAME = 15;
    private static final int INDEX_UNIQUEMEMBERS = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final int INDEX_VALIDFLAG = 24;
    private static final int INDEX_VALUEPSDEFID = 25;
    private static final int INDEX_VALUEPSDEFNAME = 26;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBILevelBase proxyPSSysBILevelBase = null;
    private boolean aggcaptionDirtyFlag = false;
    private boolean bileveltagDirtyFlag = false;
    private boolean bileveltag2DirtyFlag = false;
    private boolean bileveltypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbihierarchyidDirtyFlag = false;
    private boolean pssysbihierarchynameDirtyFlag = false;
    private boolean pssysbilevelidDirtyFlag = false;
    private boolean pssysbilevelnameDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean uniquemembersDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valuepsdefidDirtyFlag = false;
    private boolean valuepsdefnameDirtyFlag = false;
    @Column(name="aggcaption")
    private String aggcaption;
    @Column(name="bileveltag")
    private String bileveltag;
    @Column(name="bileveltag2")
    private String bileveltag2;
    @Column(name="bileveltype")
    private String bileveltype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysbihierarchyid")
    private String pssysbihierarchyid;
    @Column(name="pssysbihierarchyname")
    private String pssysbihierarchyname;
    @Column(name="pssysbilevelid")
    private String pssysbilevelid;
    @Column(name="pssysbilevelname")
    private String pssysbilevelname;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="uniquemembers")
    private Integer uniquemembers;
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
    @Column(name="valuepsdefid")
    private String valuepsdefid;
    @Column(name="valuepsdefname")
    private String valuepsdefname;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objValuePSDEFLock = new Integer(1);
    private PSDEField valuepsdef = null;
    private Integer objPSSysBIHierarchyLock = new Integer(1);
    private PSSysBIHierarchy pssysbihierarchy = null;

    public void setAggCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggcaption = string;
        this.aggcaptionDirtyFlag = true;
    }

    public String getAggCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggCaption();
        }
        return this.aggcaption;
    }

    public boolean isAggCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggCaptionDirty();
        }
        return this.aggcaptionDirtyFlag;
    }

    public void resetAggCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggCaption();
            return;
        }
        this.aggcaptionDirtyFlag = false;
        this.aggcaption = null;
    }

    public void setBILevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBILevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bileveltag = string;
        this.bileveltagDirtyFlag = true;
    }

    public String getBILevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBILevelTag();
        }
        return this.bileveltag;
    }

    public boolean isBILevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBILevelTagDirty();
        }
        return this.bileveltagDirtyFlag;
    }

    public void resetBILevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBILevelTag();
            return;
        }
        this.bileveltagDirtyFlag = false;
        this.bileveltag = null;
    }

    public void setBILevelTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBILevelTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bileveltag2 = string;
        this.bileveltag2DirtyFlag = true;
    }

    public String getBILevelTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBILevelTag2();
        }
        return this.bileveltag2;
    }

    public boolean isBILevelTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBILevelTag2Dirty();
        }
        return this.bileveltag2DirtyFlag;
    }

    public void resetBILevelTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBILevelTag2();
            return;
        }
        this.bileveltag2DirtyFlag = false;
        this.bileveltag2 = null;
    }

    public void setBILevelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBILevelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bileveltype = string;
        this.bileveltypeDirtyFlag = true;
    }

    public String getBILevelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBILevelType();
        }
        return this.bileveltype;
    }

    public boolean isBILevelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBILevelTypeDirty();
        }
        return this.bileveltypeDirtyFlag;
    }

    public void resetBILevelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBILevelType();
            return;
        }
        this.bileveltypeDirtyFlag = false;
        this.bileveltype = null;
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

    public void setPSSysBIHierarchyId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIHierarchyId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbihierarchyid = string;
        this.pssysbihierarchyidDirtyFlag = true;
    }

    public String getPSSysBIHierarchyId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchyId();
        }
        return this.pssysbihierarchyid;
    }

    public boolean isPSSysBIHierarchyIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIHierarchyIdDirty();
        }
        return this.pssysbihierarchyidDirtyFlag;
    }

    public void resetPSSysBIHierarchyId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIHierarchyId();
            return;
        }
        this.pssysbihierarchyidDirtyFlag = false;
        this.pssysbihierarchyid = null;
    }

    public void setPSSysBIHierarchyName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIHierarchyName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbihierarchyname = string;
        this.pssysbihierarchynameDirtyFlag = true;
    }

    public String getPSSysBIHierarchyName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchyName();
        }
        return this.pssysbihierarchyname;
    }

    public boolean isPSSysBIHierarchyNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIHierarchyNameDirty();
        }
        return this.pssysbihierarchynameDirtyFlag;
    }

    public void resetPSSysBIHierarchyName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIHierarchyName();
            return;
        }
        this.pssysbihierarchynameDirtyFlag = false;
        this.pssysbihierarchyname = null;
    }

    public void setPSSysBILevelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBILevelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbilevelid = string;
        this.pssysbilevelidDirtyFlag = true;
    }

    public String getPSSysBILevelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevelId();
        }
        return this.pssysbilevelid;
    }

    public boolean isPSSysBILevelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBILevelIdDirty();
        }
        return this.pssysbilevelidDirtyFlag;
    }

    public void resetPSSysBILevelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBILevelId();
            return;
        }
        this.pssysbilevelidDirtyFlag = false;
        this.pssysbilevelid = null;
    }

    public void setPSSysBILevelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBILevelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbilevelname = string;
        this.pssysbilevelnameDirtyFlag = true;
    }

    public String getPSSysBILevelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBILevelName();
        }
        return this.pssysbilevelname;
    }

    public boolean isPSSysBILevelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBILevelNameDirty();
        }
        return this.pssysbilevelnameDirtyFlag;
    }

    public void resetPSSysBILevelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBILevelName();
            return;
        }
        this.pssysbilevelnameDirtyFlag = false;
        this.pssysbilevelname = null;
    }

    public void setTextPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefid = string;
        this.textpsdefidDirtyFlag = true;
    }

    public String getTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFId();
        }
        return this.textpsdefid;
    }

    public boolean isTextPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFIdDirty();
        }
        return this.textpsdefidDirtyFlag;
    }

    public void resetTextPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFId();
            return;
        }
        this.textpsdefidDirtyFlag = false;
        this.textpsdefid = null;
    }

    public void setTextPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpsdefname = string;
        this.textpsdefnameDirtyFlag = true;
    }

    public String getTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEFName();
        }
        return this.textpsdefname;
    }

    public boolean isTextPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSDEFNameDirty();
        }
        return this.textpsdefnameDirtyFlag;
    }

    public void resetTextPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSDEFName();
            return;
        }
        this.textpsdefnameDirtyFlag = false;
        this.textpsdefname = null;
    }

    public void setUniqueMembers(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUniqueMembers(n);
            return;
        }
        this.uniquemembers = n;
        this.uniquemembersDirtyFlag = true;
    }

    public Integer getUniqueMembers() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUniqueMembers();
        }
        return this.uniquemembers;
    }

    public boolean isUniqueMembersDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUniqueMembersDirty();
        }
        return this.uniquemembersDirtyFlag;
    }

    public void resetUniqueMembers() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUniqueMembers();
            return;
        }
        this.uniquemembersDirtyFlag = false;
        this.uniquemembers = null;
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

    public void setValuePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefid = string;
        this.valuepsdefidDirtyFlag = true;
    }

    public String getValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFId();
        }
        return this.valuepsdefid;
    }

    public boolean isValuePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFIdDirty();
        }
        return this.valuepsdefidDirtyFlag;
    }

    public void resetValuePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFId();
            return;
        }
        this.valuepsdefidDirtyFlag = false;
        this.valuepsdefid = null;
    }

    public void setValuePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValuePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuepsdefname = string;
        this.valuepsdefnameDirtyFlag = true;
    }

    public String getValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEFName();
        }
        return this.valuepsdefname;
    }

    public boolean isValuePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValuePSDEFNameDirty();
        }
        return this.valuepsdefnameDirtyFlag;
    }

    public void resetValuePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValuePSDEFName();
            return;
        }
        this.valuepsdefnameDirtyFlag = false;
        this.valuepsdefname = null;
    }

    protected void onReset() {
        PSSysBILevelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBILevelBase pSSysBILevelBase) {
        pSSysBILevelBase.resetAggCaption();
        pSSysBILevelBase.resetBILevelTag();
        pSSysBILevelBase.resetBILevelTag2();
        pSSysBILevelBase.resetBILevelType();
        pSSysBILevelBase.resetCodeName();
        pSSysBILevelBase.resetCreateDate();
        pSSysBILevelBase.resetCreateMan();
        pSSysBILevelBase.resetMemo();
        pSSysBILevelBase.resetOrderValue();
        pSSysBILevelBase.resetPSDEId();
        pSSysBILevelBase.resetPSSysBIHierarchyId();
        pSSysBILevelBase.resetPSSysBIHierarchyName();
        pSSysBILevelBase.resetPSSysBILevelId();
        pSSysBILevelBase.resetPSSysBILevelName();
        pSSysBILevelBase.resetTextPSDEFId();
        pSSysBILevelBase.resetTextPSDEFName();
        pSSysBILevelBase.resetUniqueMembers();
        pSSysBILevelBase.resetUpdateDate();
        pSSysBILevelBase.resetUpdateMan();
        pSSysBILevelBase.resetUserCat();
        pSSysBILevelBase.resetUserTag();
        pSSysBILevelBase.resetUserTag2();
        pSSysBILevelBase.resetUserTag3();
        pSSysBILevelBase.resetUserTag4();
        pSSysBILevelBase.resetValidFlag();
        pSSysBILevelBase.resetValuePSDEFId();
        pSSysBILevelBase.resetValuePSDEFName();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggCaptionDirty()) {
            hashMap.put(FIELD_AGGCAPTION, this.getAggCaption());
        }
        if (!bl || this.isBILevelTagDirty()) {
            hashMap.put(FIELD_BILEVELTAG, this.getBILevelTag());
        }
        if (!bl || this.isBILevelTag2Dirty()) {
            hashMap.put(FIELD_BILEVELTAG2, this.getBILevelTag2());
        }
        if (!bl || this.isBILevelTypeDirty()) {
            hashMap.put(FIELD_BILEVELTYPE, this.getBILevelType());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysBIHierarchyIdDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYID, this.getPSSysBIHierarchyId());
        }
        if (!bl || this.isPSSysBIHierarchyNameDirty()) {
            hashMap.put(FIELD_PSSYSBIHIERARCHYNAME, this.getPSSysBIHierarchyName());
        }
        if (!bl || this.isPSSysBILevelIdDirty()) {
            hashMap.put(FIELD_PSSYSBILEVELID, this.getPSSysBILevelId());
        }
        if (!bl || this.isPSSysBILevelNameDirty()) {
            hashMap.put(FIELD_PSSYSBILEVELNAME, this.getPSSysBILevelName());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isUniqueMembersDirty()) {
            hashMap.put(FIELD_UNIQUEMEMBERS, this.getUniqueMembers());
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
        if (!bl || this.isValuePSDEFIdDirty()) {
            hashMap.put(FIELD_VALUEPSDEFID, this.getValuePSDEFId());
        }
        if (!bl || this.isValuePSDEFNameDirty()) {
            hashMap.put(FIELD_VALUEPSDEFNAME, this.getValuePSDEFName());
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
        return PSSysBILevelBase.get(this, n);
    }

    private static Object get(PSSysBILevelBase pSSysBILevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBILevelBase.getAggCaption();
            }
            case 1: {
                return pSSysBILevelBase.getBILevelTag();
            }
            case 2: {
                return pSSysBILevelBase.getBILevelTag2();
            }
            case 3: {
                return pSSysBILevelBase.getBILevelType();
            }
            case 4: {
                return pSSysBILevelBase.getCodeName();
            }
            case 5: {
                return pSSysBILevelBase.getCreateDate();
            }
            case 6: {
                return pSSysBILevelBase.getCreateMan();
            }
            case 7: {
                return pSSysBILevelBase.getMemo();
            }
            case 8: {
                return pSSysBILevelBase.getOrderValue();
            }
            case 9: {
                return pSSysBILevelBase.getPSDEId();
            }
            case 10: {
                return pSSysBILevelBase.getPSSysBIHierarchyId();
            }
            case 11: {
                return pSSysBILevelBase.getPSSysBIHierarchyName();
            }
            case 12: {
                return pSSysBILevelBase.getPSSysBILevelId();
            }
            case 13: {
                return pSSysBILevelBase.getPSSysBILevelName();
            }
            case 14: {
                return pSSysBILevelBase.getTextPSDEFId();
            }
            case 15: {
                return pSSysBILevelBase.getTextPSDEFName();
            }
            case 16: {
                return pSSysBILevelBase.getUniqueMembers();
            }
            case 17: {
                return pSSysBILevelBase.getUpdateDate();
            }
            case 18: {
                return pSSysBILevelBase.getUpdateMan();
            }
            case 19: {
                return pSSysBILevelBase.getUserCat();
            }
            case 20: {
                return pSSysBILevelBase.getUserTag();
            }
            case 21: {
                return pSSysBILevelBase.getUserTag2();
            }
            case 22: {
                return pSSysBILevelBase.getUserTag3();
            }
            case 23: {
                return pSSysBILevelBase.getUserTag4();
            }
            case 24: {
                return pSSysBILevelBase.getValidFlag();
            }
            case 25: {
                return pSSysBILevelBase.getValuePSDEFId();
            }
            case 26: {
                return pSSysBILevelBase.getValuePSDEFName();
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
        PSSysBILevelBase.set(this, n, object);
    }

    private static void set(PSSysBILevelBase pSSysBILevelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBILevelBase.setAggCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBILevelBase.setBILevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBILevelBase.setBILevelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBILevelBase.setBILevelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBILevelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBILevelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysBILevelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBILevelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBILevelBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysBILevelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBILevelBase.setPSSysBIHierarchyId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBILevelBase.setPSSysBIHierarchyName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBILevelBase.setPSSysBILevelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBILevelBase.setPSSysBILevelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBILevelBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBILevelBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBILevelBase.setUniqueMembers(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysBILevelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSSysBILevelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBILevelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBILevelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBILevelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBILevelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBILevelBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBILevelBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysBILevelBase.setValuePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBILevelBase.setValuePSDEFName(DataObject.getStringValue((Object)object));
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
        return PSSysBILevelBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBILevelBase pSSysBILevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBILevelBase.getAggCaption() == null;
            }
            case 1: {
                return pSSysBILevelBase.getBILevelTag() == null;
            }
            case 2: {
                return pSSysBILevelBase.getBILevelTag2() == null;
            }
            case 3: {
                return pSSysBILevelBase.getBILevelType() == null;
            }
            case 4: {
                return pSSysBILevelBase.getCodeName() == null;
            }
            case 5: {
                return pSSysBILevelBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysBILevelBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysBILevelBase.getMemo() == null;
            }
            case 8: {
                return pSSysBILevelBase.getOrderValue() == null;
            }
            case 9: {
                return pSSysBILevelBase.getPSDEId() == null;
            }
            case 10: {
                return pSSysBILevelBase.getPSSysBIHierarchyId() == null;
            }
            case 11: {
                return pSSysBILevelBase.getPSSysBIHierarchyName() == null;
            }
            case 12: {
                return pSSysBILevelBase.getPSSysBILevelId() == null;
            }
            case 13: {
                return pSSysBILevelBase.getPSSysBILevelName() == null;
            }
            case 14: {
                return pSSysBILevelBase.getTextPSDEFId() == null;
            }
            case 15: {
                return pSSysBILevelBase.getTextPSDEFName() == null;
            }
            case 16: {
                return pSSysBILevelBase.getUniqueMembers() == null;
            }
            case 17: {
                return pSSysBILevelBase.getUpdateDate() == null;
            }
            case 18: {
                return pSSysBILevelBase.getUpdateMan() == null;
            }
            case 19: {
                return pSSysBILevelBase.getUserCat() == null;
            }
            case 20: {
                return pSSysBILevelBase.getUserTag() == null;
            }
            case 21: {
                return pSSysBILevelBase.getUserTag2() == null;
            }
            case 22: {
                return pSSysBILevelBase.getUserTag3() == null;
            }
            case 23: {
                return pSSysBILevelBase.getUserTag4() == null;
            }
            case 24: {
                return pSSysBILevelBase.getValidFlag() == null;
            }
            case 25: {
                return pSSysBILevelBase.getValuePSDEFId() == null;
            }
            case 26: {
                return pSSysBILevelBase.getValuePSDEFName() == null;
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
        return PSSysBILevelBase.contains(this, n);
    }

    private static boolean contains(PSSysBILevelBase pSSysBILevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBILevelBase.isAggCaptionDirty();
            }
            case 1: {
                return pSSysBILevelBase.isBILevelTagDirty();
            }
            case 2: {
                return pSSysBILevelBase.isBILevelTag2Dirty();
            }
            case 3: {
                return pSSysBILevelBase.isBILevelTypeDirty();
            }
            case 4: {
                return pSSysBILevelBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysBILevelBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysBILevelBase.isCreateManDirty();
            }
            case 7: {
                return pSSysBILevelBase.isMemoDirty();
            }
            case 8: {
                return pSSysBILevelBase.isOrderValueDirty();
            }
            case 9: {
                return pSSysBILevelBase.isPSDEIdDirty();
            }
            case 10: {
                return pSSysBILevelBase.isPSSysBIHierarchyIdDirty();
            }
            case 11: {
                return pSSysBILevelBase.isPSSysBIHierarchyNameDirty();
            }
            case 12: {
                return pSSysBILevelBase.isPSSysBILevelIdDirty();
            }
            case 13: {
                return pSSysBILevelBase.isPSSysBILevelNameDirty();
            }
            case 14: {
                return pSSysBILevelBase.isTextPSDEFIdDirty();
            }
            case 15: {
                return pSSysBILevelBase.isTextPSDEFNameDirty();
            }
            case 16: {
                return pSSysBILevelBase.isUniqueMembersDirty();
            }
            case 17: {
                return pSSysBILevelBase.isUpdateDateDirty();
            }
            case 18: {
                return pSSysBILevelBase.isUpdateManDirty();
            }
            case 19: {
                return pSSysBILevelBase.isUserCatDirty();
            }
            case 20: {
                return pSSysBILevelBase.isUserTagDirty();
            }
            case 21: {
                return pSSysBILevelBase.isUserTag2Dirty();
            }
            case 22: {
                return pSSysBILevelBase.isUserTag3Dirty();
            }
            case 23: {
                return pSSysBILevelBase.isUserTag4Dirty();
            }
            case 24: {
                return pSSysBILevelBase.isValidFlagDirty();
            }
            case 25: {
                return pSSysBILevelBase.isValuePSDEFIdDirty();
            }
            case 26: {
                return pSSysBILevelBase.isValuePSDEFNameDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBILevelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBILevelBase pSSysBILevelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBILevelBase.getAggCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggcaption", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getAggCaption()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getBILevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bileveltag", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getBILevelTag()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getBILevelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bileveltag2", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getBILevelTag2()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getBILevelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bileveltype", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getBILevelType()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getPSSysBIHierarchyId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyid", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getPSSysBIHierarchyId()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getPSSysBIHierarchyName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbihierarchyname", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getPSSysBIHierarchyName()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getPSSysBILevelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbilevelid", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getPSSysBILevelId()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getPSSysBILevelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbilevelname", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getPSSysBILevelName()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUniqueMembers() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uniquemembers", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUniqueMembers()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getValuePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefid", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getValuePSDEFId()), (boolean)false);
        }
        if (bl || pSSysBILevelBase.getValuePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuepsdefname", (Object)PSSysBILevelBase.getJSONValue((Object)pSSysBILevelBase.getValuePSDEFName()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBILevelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBILevelBase pSSysBILevelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBILevelBase.getAggCaption() != null) {
            object = pSSysBILevelBase.getAggCaption();
            xmlNode.setAttribute(FIELD_AGGCAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBILevelBase.getBILevelTag() != null) {
            object = pSSysBILevelBase.getBILevelTag();
            xmlNode.setAttribute(FIELD_BILEVELTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBILevelBase.getBILevelTag2() != null) {
            object = pSSysBILevelBase.getBILevelTag2();
            xmlNode.setAttribute(FIELD_BILEVELTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBILevelBase.getBILevelType() != null) {
            object = pSSysBILevelBase.getBILevelType();
            xmlNode.setAttribute(FIELD_BILEVELTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBILevelBase.getCodeName() != null) {
            object = pSSysBILevelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getCreateDate() != null) {
            object = pSSysBILevelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBILevelBase.getCreateMan() != null) {
            object = pSSysBILevelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getMemo() != null) {
            object = pSSysBILevelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getOrderValue() != null) {
            object = pSSysBILevelBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBILevelBase.getPSDEId() != null) {
            object = pSSysBILevelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getPSSysBIHierarchyId() != null) {
            object = pSSysBILevelBase.getPSSysBIHierarchyId();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getPSSysBIHierarchyName() != null) {
            object = pSSysBILevelBase.getPSSysBIHierarchyName();
            xmlNode.setAttribute(FIELD_PSSYSBIHIERARCHYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getPSSysBILevelId() != null) {
            object = pSSysBILevelBase.getPSSysBILevelId();
            xmlNode.setAttribute(FIELD_PSSYSBILEVELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getPSSysBILevelName() != null) {
            object = pSSysBILevelBase.getPSSysBILevelName();
            xmlNode.setAttribute(FIELD_PSSYSBILEVELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getTextPSDEFId() != null) {
            object = pSSysBILevelBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getTextPSDEFName() != null) {
            object = pSSysBILevelBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUniqueMembers() != null) {
            object = pSSysBILevelBase.getUniqueMembers();
            xmlNode.setAttribute(FIELD_UNIQUEMEMBERS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBILevelBase.getUpdateDate() != null) {
            object = pSSysBILevelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBILevelBase.getUpdateMan() != null) {
            object = pSSysBILevelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUserCat() != null) {
            object = pSSysBILevelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUserTag() != null) {
            object = pSSysBILevelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUserTag2() != null) {
            object = pSSysBILevelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUserTag3() != null) {
            object = pSSysBILevelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getUserTag4() != null) {
            object = pSSysBILevelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getValidFlag() != null) {
            object = pSSysBILevelBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBILevelBase.getValuePSDEFId() != null) {
            object = pSSysBILevelBase.getValuePSDEFId();
            xmlNode.setAttribute(FIELD_VALUEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBILevelBase.getValuePSDEFName() != null) {
            object = pSSysBILevelBase.getValuePSDEFName();
            xmlNode.setAttribute(FIELD_VALUEPSDEFNAME, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBILevelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBILevelBase pSSysBILevelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBILevelBase.isAggCaptionDirty() && (bl || pSSysBILevelBase.getAggCaption() != null)) {
            iDataObject.set(FIELD_AGGCAPTION, (Object)pSSysBILevelBase.getAggCaption());
        }
        if (pSSysBILevelBase.isBILevelTagDirty() && (bl || pSSysBILevelBase.getBILevelTag() != null)) {
            iDataObject.set(FIELD_BILEVELTAG, (Object)pSSysBILevelBase.getBILevelTag());
        }
        if (pSSysBILevelBase.isBILevelTag2Dirty() && (bl || pSSysBILevelBase.getBILevelTag2() != null)) {
            iDataObject.set(FIELD_BILEVELTAG2, (Object)pSSysBILevelBase.getBILevelTag2());
        }
        if (pSSysBILevelBase.isBILevelTypeDirty() && (bl || pSSysBILevelBase.getBILevelType() != null)) {
            iDataObject.set(FIELD_BILEVELTYPE, (Object)pSSysBILevelBase.getBILevelType());
        }
        if (pSSysBILevelBase.isCodeNameDirty() && (bl || pSSysBILevelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBILevelBase.getCodeName());
        }
        if (pSSysBILevelBase.isCreateDateDirty() && (bl || pSSysBILevelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBILevelBase.getCreateDate());
        }
        if (pSSysBILevelBase.isCreateManDirty() && (bl || pSSysBILevelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBILevelBase.getCreateMan());
        }
        if (pSSysBILevelBase.isMemoDirty() && (bl || pSSysBILevelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBILevelBase.getMemo());
        }
        if (pSSysBILevelBase.isOrderValueDirty() && (bl || pSSysBILevelBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBILevelBase.getOrderValue());
        }
        if (pSSysBILevelBase.isPSDEIdDirty() && (bl || pSSysBILevelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBILevelBase.getPSDEId());
        }
        if (pSSysBILevelBase.isPSSysBIHierarchyIdDirty() && (bl || pSSysBILevelBase.getPSSysBIHierarchyId() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYID, (Object)pSSysBILevelBase.getPSSysBIHierarchyId());
        }
        if (pSSysBILevelBase.isPSSysBIHierarchyNameDirty() && (bl || pSSysBILevelBase.getPSSysBIHierarchyName() != null)) {
            iDataObject.set(FIELD_PSSYSBIHIERARCHYNAME, (Object)pSSysBILevelBase.getPSSysBIHierarchyName());
        }
        if (pSSysBILevelBase.isPSSysBILevelIdDirty() && (bl || pSSysBILevelBase.getPSSysBILevelId() != null)) {
            iDataObject.set(FIELD_PSSYSBILEVELID, (Object)pSSysBILevelBase.getPSSysBILevelId());
        }
        if (pSSysBILevelBase.isPSSysBILevelNameDirty() && (bl || pSSysBILevelBase.getPSSysBILevelName() != null)) {
            iDataObject.set(FIELD_PSSYSBILEVELNAME, (Object)pSSysBILevelBase.getPSSysBILevelName());
        }
        if (pSSysBILevelBase.isTextPSDEFIdDirty() && (bl || pSSysBILevelBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSSysBILevelBase.getTextPSDEFId());
        }
        if (pSSysBILevelBase.isTextPSDEFNameDirty() && (bl || pSSysBILevelBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSSysBILevelBase.getTextPSDEFName());
        }
        if (pSSysBILevelBase.isUniqueMembersDirty() && (bl || pSSysBILevelBase.getUniqueMembers() != null)) {
            iDataObject.set(FIELD_UNIQUEMEMBERS, (Object)pSSysBILevelBase.getUniqueMembers());
        }
        if (pSSysBILevelBase.isUpdateDateDirty() && (bl || pSSysBILevelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBILevelBase.getUpdateDate());
        }
        if (pSSysBILevelBase.isUpdateManDirty() && (bl || pSSysBILevelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBILevelBase.getUpdateMan());
        }
        if (pSSysBILevelBase.isUserCatDirty() && (bl || pSSysBILevelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBILevelBase.getUserCat());
        }
        if (pSSysBILevelBase.isUserTagDirty() && (bl || pSSysBILevelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBILevelBase.getUserTag());
        }
        if (pSSysBILevelBase.isUserTag2Dirty() && (bl || pSSysBILevelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBILevelBase.getUserTag2());
        }
        if (pSSysBILevelBase.isUserTag3Dirty() && (bl || pSSysBILevelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBILevelBase.getUserTag3());
        }
        if (pSSysBILevelBase.isUserTag4Dirty() && (bl || pSSysBILevelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBILevelBase.getUserTag4());
        }
        if (pSSysBILevelBase.isValidFlagDirty() && (bl || pSSysBILevelBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBILevelBase.getValidFlag());
        }
        if (pSSysBILevelBase.isValuePSDEFIdDirty() && (bl || pSSysBILevelBase.getValuePSDEFId() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFID, (Object)pSSysBILevelBase.getValuePSDEFId());
        }
        if (pSSysBILevelBase.isValuePSDEFNameDirty() && (bl || pSSysBILevelBase.getValuePSDEFName() != null)) {
            iDataObject.set(FIELD_VALUEPSDEFNAME, (Object)pSSysBILevelBase.getValuePSDEFName());
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
        return PSSysBILevelBase.remove(this, n);
    }

    private static boolean remove(PSSysBILevelBase pSSysBILevelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBILevelBase.resetAggCaption();
                return true;
            }
            case 1: {
                pSSysBILevelBase.resetBILevelTag();
                return true;
            }
            case 2: {
                pSSysBILevelBase.resetBILevelTag2();
                return true;
            }
            case 3: {
                pSSysBILevelBase.resetBILevelType();
                return true;
            }
            case 4: {
                pSSysBILevelBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysBILevelBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysBILevelBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysBILevelBase.resetMemo();
                return true;
            }
            case 8: {
                pSSysBILevelBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSSysBILevelBase.resetPSDEId();
                return true;
            }
            case 10: {
                pSSysBILevelBase.resetPSSysBIHierarchyId();
                return true;
            }
            case 11: {
                pSSysBILevelBase.resetPSSysBIHierarchyName();
                return true;
            }
            case 12: {
                pSSysBILevelBase.resetPSSysBILevelId();
                return true;
            }
            case 13: {
                pSSysBILevelBase.resetPSSysBILevelName();
                return true;
            }
            case 14: {
                pSSysBILevelBase.resetTextPSDEFId();
                return true;
            }
            case 15: {
                pSSysBILevelBase.resetTextPSDEFName();
                return true;
            }
            case 16: {
                pSSysBILevelBase.resetUniqueMembers();
                return true;
            }
            case 17: {
                pSSysBILevelBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSSysBILevelBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSSysBILevelBase.resetUserCat();
                return true;
            }
            case 20: {
                pSSysBILevelBase.resetUserTag();
                return true;
            }
            case 21: {
                pSSysBILevelBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSSysBILevelBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSSysBILevelBase.resetUserTag4();
                return true;
            }
            case 24: {
                pSSysBILevelBase.resetValidFlag();
                return true;
            }
            case 25: {
                pSSysBILevelBase.resetValuePSDEFId();
                return true;
            }
            case 26: {
                pSSysBILevelBase.resetValuePSDEFName();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTextPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSDEF();
        }
        if (this.getTextPSDEFId() == null) {
            return null;
        }
        Integer n = this.objTextPSDEFLock;
        synchronized (n) {
            if (this.textpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSDEFId(), (Object)this.textpsdef.getPSDEFieldId()) != 0L) {
                this.textpsdef = null;
            }
            if (this.textpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTextPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.textpsdef = pSDEField;
            }
            return this.textpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getValuePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValuePSDEF();
        }
        if (this.getValuePSDEFId() == null) {
            return null;
        }
        Integer n = this.objValuePSDEFLock;
        synchronized (n) {
            if (this.valuepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getValuePSDEFId(), (Object)this.valuepsdef.getPSDEFieldId()) != 0L) {
                this.valuepsdef = null;
            }
            if (this.valuepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getValuePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.valuepsdef = pSDEField;
            }
            return this.valuepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIHierarchy getPSSysBIHierarchy() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchy();
        }
        if (this.getPSSysBIHierarchyId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIHierarchyLock;
        synchronized (n) {
            if (this.pssysbihierarchy != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIHierarchyId(), (Object)this.pssysbihierarchy.getPSSysBIHierarchyId()) != 0L) {
                this.pssysbihierarchy = null;
            }
            if (this.pssysbihierarchy == null) {
                PSSysBIHierarchy pSSysBIHierarchy = new PSSysBIHierarchy();
                pSSysBIHierarchy.setPSSysBIHierarchyId(this.getPSSysBIHierarchyId());
                PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIHierarchyService.autoGet((IEntity)pSSysBIHierarchy);
                this.pssysbihierarchy = pSSysBIHierarchy;
            }
            return this.pssysbihierarchy;
        }
    }

    private PSSysBILevelBase getProxyEntity() {
        return this.proxyPSSysBILevelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBILevelBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBILevelBase) {
            this.proxyPSSysBILevelBase = (PSSysBILevelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBILevelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGCAPTION, 0);
        fieldIndexMap.put(FIELD_BILEVELTAG, 1);
        fieldIndexMap.put(FIELD_BILEVELTAG2, 2);
        fieldIndexMap.put(FIELD_BILEVELTYPE, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSDEID, 9);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYID, 10);
        fieldIndexMap.put(FIELD_PSSYSBIHIERARCHYNAME, 11);
        fieldIndexMap.put(FIELD_PSSYSBILEVELID, 12);
        fieldIndexMap.put(FIELD_PSSYSBILEVELNAME, 13);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 14);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 15);
        fieldIndexMap.put(FIELD_UNIQUEMEMBERS, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
        fieldIndexMap.put(FIELD_VALIDFLAG, 24);
        fieldIndexMap.put(FIELD_VALUEPSDEFID, 25);
        fieldIndexMap.put(FIELD_VALUEPSDEFNAME, 26);
    }
}

