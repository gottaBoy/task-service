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
import java.util.ArrayList;
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
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIDataTypeItem;
import net.ibizsys.pscore.srv.eaidesign.entity.PSSysEAIScheme;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeItemService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService;
import net.ibizsys.pscore.srv.eaidesign.service.PSSysEAISchemeService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysEAIDataTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysEAIDataTypeBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EAIDATATYPETAG = "EAIDATATYPETAG";
    public static final String FIELD_EAIDATATYPETAG2 = "EAIDATATYPETAG2";
    public static final String FIELD_ENABLEENUM = "ENABLEENUM";
    public static final String FIELD_INCMAXVALUE = "INCMAXVALUE";
    public static final String FIELD_INCMINVALUE = "INCMINVALUE";
    public static final String FIELD_MAXSTRLENGTH = "MAXSTRLENGTH";
    public static final String FIELD_MAXVALUE = "MAXVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MINSTRLENGTH = "MINSTRLENGTH";
    public static final String FIELD_MINVALUE = "MINVALUE";
    public static final String FIELD_PRECISION2 = "PRECISION2";
    public static final String FIELD_PSSYSEAIDATATYPEID = "PSSYSEAIDATATYPEID";
    public static final String FIELD_PSSYSEAIDATATYPENAME = "PSSYSEAIDATATYPENAME";
    public static final String FIELD_PSSYSEAISCHEMEID = "PSSYSEAISCHEMEID";
    public static final String FIELD_PSSYSEAISCHEMENAME = "PSSYSEAISCHEMENAME";
    public static final String FIELD_REGEXPCODE = "REGEXPCODE";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
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
    private static final int INDEX_EAIDATATYPETAG = 3;
    private static final int INDEX_EAIDATATYPETAG2 = 4;
    private static final int INDEX_ENABLEENUM = 5;
    private static final int INDEX_INCMAXVALUE = 6;
    private static final int INDEX_INCMINVALUE = 7;
    private static final int INDEX_MAXSTRLENGTH = 8;
    private static final int INDEX_MAXVALUE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_MINSTRLENGTH = 11;
    private static final int INDEX_MINVALUE = 12;
    private static final int INDEX_PRECISION2 = 13;
    private static final int INDEX_PSSYSEAIDATATYPEID = 14;
    private static final int INDEX_PSSYSEAIDATATYPENAME = 15;
    private static final int INDEX_PSSYSEAISCHEMEID = 16;
    private static final int INDEX_PSSYSEAISCHEMENAME = 17;
    private static final int INDEX_REGEXPCODE = 18;
    private static final int INDEX_STDDATATYPE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALIDFLAG = 27;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysEAIDataTypeBase proxyPSSysEAIDataTypeBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean eaidatatypetagDirtyFlag = false;
    private boolean eaidatatypetag2DirtyFlag = false;
    private boolean enableenumDirtyFlag = false;
    private boolean incmaxvalueDirtyFlag = false;
    private boolean incminvalueDirtyFlag = false;
    private boolean maxstrlengthDirtyFlag = false;
    private boolean maxvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean minstrlengthDirtyFlag = false;
    private boolean minvalueDirtyFlag = false;
    private boolean precision2DirtyFlag = false;
    private boolean pssyseaidatatypeidDirtyFlag = false;
    private boolean pssyseaidatatypenameDirtyFlag = false;
    private boolean pssyseaischemeidDirtyFlag = false;
    private boolean pssyseaischemenameDirtyFlag = false;
    private boolean regexpcodeDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
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
    @Column(name="eaidatatypetag")
    private String eaidatatypetag;
    @Column(name="eaidatatypetag2")
    private String eaidatatypetag2;
    @Column(name="enableenum")
    private Integer enableenum;
    @Column(name="incmaxvalue")
    private Integer incmaxvalue;
    @Column(name="incminvalue")
    private Integer incminvalue;
    @Column(name="maxstrlength")
    private Integer maxstrlength;
    @Column(name="maxvalue")
    private String maxvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="minstrlength")
    private Integer minstrlength;
    @Column(name="minvalue")
    private String minvalue;
    @Column(name="precision2")
    private Integer precision2;
    @Column(name="pssyseaidatatypeid")
    private String pssyseaidatatypeid;
    @Column(name="pssyseaidatatypename")
    private String pssyseaidatatypename;
    @Column(name="pssyseaischemeid")
    private String pssyseaischemeid;
    @Column(name="pssyseaischemename")
    private String pssyseaischemename;
    @Column(name="regexpcode")
    private String regexpcode;
    @Column(name="stddatatype")
    private Integer stddatatype;
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
    private Integer objPSSysEAISchemeLock = new Integer(1);
    private PSSysEAIScheme pssyseaischeme = null;
    private Integer objPSSysEAIDataTypeItemsLock = new Integer(1);
    private ArrayList<PSSysEAIDataTypeItem> pssyseaidatatypeitems = null;

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

    public void setEAIDataTypeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDataTypeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidatatypetag = string;
        this.eaidatatypetagDirtyFlag = true;
    }

    public String getEAIDataTypeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDataTypeTag();
        }
        return this.eaidatatypetag;
    }

    public boolean isEAIDataTypeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDataTypeTagDirty();
        }
        return this.eaidatatypetagDirtyFlag;
    }

    public void resetEAIDataTypeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDataTypeTag();
            return;
        }
        this.eaidatatypetagDirtyFlag = false;
        this.eaidatatypetag = null;
    }

    public void setEAIDataTypeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEAIDataTypeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.eaidatatypetag2 = string;
        this.eaidatatypetag2DirtyFlag = true;
    }

    public String getEAIDataTypeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEAIDataTypeTag2();
        }
        return this.eaidatatypetag2;
    }

    public boolean isEAIDataTypeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEAIDataTypeTag2Dirty();
        }
        return this.eaidatatypetag2DirtyFlag;
    }

    public void resetEAIDataTypeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEAIDataTypeTag2();
            return;
        }
        this.eaidatatypetag2DirtyFlag = false;
        this.eaidatatypetag2 = null;
    }

    public void setEnableEnum(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableEnum(n);
            return;
        }
        this.enableenum = n;
        this.enableenumDirtyFlag = true;
    }

    public Integer getEnableEnum() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableEnum();
        }
        return this.enableenum;
    }

    public boolean isEnableEnumDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableEnumDirty();
        }
        return this.enableenumDirtyFlag;
    }

    public void resetEnableEnum() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableEnum();
            return;
        }
        this.enableenumDirtyFlag = false;
        this.enableenum = null;
    }

    public void setIncMaxValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncMaxValue(n);
            return;
        }
        this.incmaxvalue = n;
        this.incmaxvalueDirtyFlag = true;
    }

    public Integer getIncMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncMaxValue();
        }
        return this.incmaxvalue;
    }

    public boolean isIncMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncMaxValueDirty();
        }
        return this.incmaxvalueDirtyFlag;
    }

    public void resetIncMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncMaxValue();
            return;
        }
        this.incmaxvalueDirtyFlag = false;
        this.incmaxvalue = null;
    }

    public void setIncMinValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncMinValue(n);
            return;
        }
        this.incminvalue = n;
        this.incminvalueDirtyFlag = true;
    }

    public Integer getIncMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncMinValue();
        }
        return this.incminvalue;
    }

    public boolean isIncMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncMinValueDirty();
        }
        return this.incminvalueDirtyFlag;
    }

    public void resetIncMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncMinValue();
            return;
        }
        this.incminvalueDirtyFlag = false;
        this.incminvalue = null;
    }

    public void setMaxStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxStrLength(n);
            return;
        }
        this.maxstrlength = n;
        this.maxstrlengthDirtyFlag = true;
    }

    public Integer getMaxStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxStrLength();
        }
        return this.maxstrlength;
    }

    public boolean isMaxStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxStrLengthDirty();
        }
        return this.maxstrlengthDirtyFlag;
    }

    public void resetMaxStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxStrLength();
            return;
        }
        this.maxstrlengthDirtyFlag = false;
        this.maxstrlength = null;
    }

    public void setMaxValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMaxValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maxvalue = string;
        this.maxvalueDirtyFlag = true;
    }

    public String getMaxValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMaxValue();
        }
        return this.maxvalue;
    }

    public boolean isMaxValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMaxValueDirty();
        }
        return this.maxvalueDirtyFlag;
    }

    public void resetMaxValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMaxValue();
            return;
        }
        this.maxvalueDirtyFlag = false;
        this.maxvalue = null;
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

    public void setMinStrLength(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinStrLength(n);
            return;
        }
        this.minstrlength = n;
        this.minstrlengthDirtyFlag = true;
    }

    public Integer getMinStrLength() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinStrLength();
        }
        return this.minstrlength;
    }

    public boolean isMinStrLengthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinStrLengthDirty();
        }
        return this.minstrlengthDirtyFlag;
    }

    public void resetMinStrLength() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinStrLength();
            return;
        }
        this.minstrlengthDirtyFlag = false;
        this.minstrlength = null;
    }

    public void setMinValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMinValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.minvalue = string;
        this.minvalueDirtyFlag = true;
    }

    public String getMinValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMinValue();
        }
        return this.minvalue;
    }

    public boolean isMinValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMinValueDirty();
        }
        return this.minvalueDirtyFlag;
    }

    public void resetMinValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMinValue();
            return;
        }
        this.minvalueDirtyFlag = false;
        this.minvalue = null;
    }

    public void setPrecision2(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPrecision2(n);
            return;
        }
        this.precision2 = n;
        this.precision2DirtyFlag = true;
    }

    public Integer getPrecision2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPrecision2();
        }
        return this.precision2;
    }

    public boolean isPrecision2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPrecision2Dirty();
        }
        return this.precision2DirtyFlag;
    }

    public void resetPrecision2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPrecision2();
            return;
        }
        this.precision2DirtyFlag = false;
        this.precision2 = null;
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

    public void setPSSysEAISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysEAISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyseaischemename = string;
        this.pssyseaischemenameDirtyFlag = true;
    }

    public String getPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAISchemeName();
        }
        return this.pssyseaischemename;
    }

    public boolean isPSSysEAISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysEAISchemeNameDirty();
        }
        return this.pssyseaischemenameDirtyFlag;
    }

    public void resetPSSysEAISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysEAISchemeName();
            return;
        }
        this.pssyseaischemenameDirtyFlag = false;
        this.pssyseaischemename = null;
    }

    public void setRegExpCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRegExpCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.regexpcode = string;
        this.regexpcodeDirtyFlag = true;
    }

    public String getRegExpCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRegExpCode();
        }
        return this.regexpcode;
    }

    public boolean isRegExpCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRegExpCodeDirty();
        }
        return this.regexpcodeDirtyFlag;
    }

    public void resetRegExpCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRegExpCode();
            return;
        }
        this.regexpcodeDirtyFlag = false;
        this.regexpcode = null;
    }

    public void setStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStdDataType(n);
            return;
        }
        this.stddatatype = n;
        this.stddatatypeDirtyFlag = true;
    }

    public Integer getStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStdDataType();
        }
        return this.stddatatype;
    }

    public boolean isStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStdDataTypeDirty();
        }
        return this.stddatatypeDirtyFlag;
    }

    public void resetStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStdDataType();
            return;
        }
        this.stddatatypeDirtyFlag = false;
        this.stddatatype = null;
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
        PSSysEAIDataTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysEAIDataTypeBase pSSysEAIDataTypeBase) {
        pSSysEAIDataTypeBase.resetCodeName();
        pSSysEAIDataTypeBase.resetCreateDate();
        pSSysEAIDataTypeBase.resetCreateMan();
        pSSysEAIDataTypeBase.resetEAIDataTypeTag();
        pSSysEAIDataTypeBase.resetEAIDataTypeTag2();
        pSSysEAIDataTypeBase.resetEnableEnum();
        pSSysEAIDataTypeBase.resetIncMaxValue();
        pSSysEAIDataTypeBase.resetIncMinValue();
        pSSysEAIDataTypeBase.resetMaxStrLength();
        pSSysEAIDataTypeBase.resetMaxValue();
        pSSysEAIDataTypeBase.resetMemo();
        pSSysEAIDataTypeBase.resetMinStrLength();
        pSSysEAIDataTypeBase.resetMinValue();
        pSSysEAIDataTypeBase.resetPrecision2();
        pSSysEAIDataTypeBase.resetPSSysEAIDataTypeId();
        pSSysEAIDataTypeBase.resetPSSysEAIDataTypeName();
        pSSysEAIDataTypeBase.resetPSSysEAISchemeId();
        pSSysEAIDataTypeBase.resetPSSysEAISchemeName();
        pSSysEAIDataTypeBase.resetRegExpCode();
        pSSysEAIDataTypeBase.resetStdDataType();
        pSSysEAIDataTypeBase.resetUpdateDate();
        pSSysEAIDataTypeBase.resetUpdateMan();
        pSSysEAIDataTypeBase.resetUserCat();
        pSSysEAIDataTypeBase.resetUserTag();
        pSSysEAIDataTypeBase.resetUserTag2();
        pSSysEAIDataTypeBase.resetUserTag3();
        pSSysEAIDataTypeBase.resetUserTag4();
        pSSysEAIDataTypeBase.resetValidFlag();
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
        if (!bl || this.isEAIDataTypeTagDirty()) {
            hashMap.put(FIELD_EAIDATATYPETAG, this.getEAIDataTypeTag());
        }
        if (!bl || this.isEAIDataTypeTag2Dirty()) {
            hashMap.put(FIELD_EAIDATATYPETAG2, this.getEAIDataTypeTag2());
        }
        if (!bl || this.isEnableEnumDirty()) {
            hashMap.put(FIELD_ENABLEENUM, this.getEnableEnum());
        }
        if (!bl || this.isIncMaxValueDirty()) {
            hashMap.put(FIELD_INCMAXVALUE, this.getIncMaxValue());
        }
        if (!bl || this.isIncMinValueDirty()) {
            hashMap.put(FIELD_INCMINVALUE, this.getIncMinValue());
        }
        if (!bl || this.isMaxStrLengthDirty()) {
            hashMap.put(FIELD_MAXSTRLENGTH, this.getMaxStrLength());
        }
        if (!bl || this.isMaxValueDirty()) {
            hashMap.put(FIELD_MAXVALUE, this.getMaxValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isMinStrLengthDirty()) {
            hashMap.put(FIELD_MINSTRLENGTH, this.getMinStrLength());
        }
        if (!bl || this.isMinValueDirty()) {
            hashMap.put(FIELD_MINVALUE, this.getMinValue());
        }
        if (!bl || this.isPrecision2Dirty()) {
            hashMap.put(FIELD_PRECISION2, this.getPrecision2());
        }
        if (!bl || this.isPSSysEAIDataTypeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPEID, this.getPSSysEAIDataTypeId());
        }
        if (!bl || this.isPSSysEAIDataTypeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAIDATATYPENAME, this.getPSSysEAIDataTypeName());
        }
        if (!bl || this.isPSSysEAISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMEID, this.getPSSysEAISchemeId());
        }
        if (!bl || this.isPSSysEAISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSEAISCHEMENAME, this.getPSSysEAISchemeName());
        }
        if (!bl || this.isRegExpCodeDirty()) {
            hashMap.put(FIELD_REGEXPCODE, this.getRegExpCode());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
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
        return PSSysEAIDataTypeBase.get(this, n);
    }

    private static Object get(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeBase.getCodeName();
            }
            case 1: {
                return pSSysEAIDataTypeBase.getCreateDate();
            }
            case 2: {
                return pSSysEAIDataTypeBase.getCreateMan();
            }
            case 3: {
                return pSSysEAIDataTypeBase.getEAIDataTypeTag();
            }
            case 4: {
                return pSSysEAIDataTypeBase.getEAIDataTypeTag2();
            }
            case 5: {
                return pSSysEAIDataTypeBase.getEnableEnum();
            }
            case 6: {
                return pSSysEAIDataTypeBase.getIncMaxValue();
            }
            case 7: {
                return pSSysEAIDataTypeBase.getIncMinValue();
            }
            case 8: {
                return pSSysEAIDataTypeBase.getMaxStrLength();
            }
            case 9: {
                return pSSysEAIDataTypeBase.getMaxValue();
            }
            case 10: {
                return pSSysEAIDataTypeBase.getMemo();
            }
            case 11: {
                return pSSysEAIDataTypeBase.getMinStrLength();
            }
            case 12: {
                return pSSysEAIDataTypeBase.getMinValue();
            }
            case 13: {
                return pSSysEAIDataTypeBase.getPrecision2();
            }
            case 14: {
                return pSSysEAIDataTypeBase.getPSSysEAIDataTypeId();
            }
            case 15: {
                return pSSysEAIDataTypeBase.getPSSysEAIDataTypeName();
            }
            case 16: {
                return pSSysEAIDataTypeBase.getPSSysEAISchemeId();
            }
            case 17: {
                return pSSysEAIDataTypeBase.getPSSysEAISchemeName();
            }
            case 18: {
                return pSSysEAIDataTypeBase.getRegExpCode();
            }
            case 19: {
                return pSSysEAIDataTypeBase.getStdDataType();
            }
            case 20: {
                return pSSysEAIDataTypeBase.getUpdateDate();
            }
            case 21: {
                return pSSysEAIDataTypeBase.getUpdateMan();
            }
            case 22: {
                return pSSysEAIDataTypeBase.getUserCat();
            }
            case 23: {
                return pSSysEAIDataTypeBase.getUserTag();
            }
            case 24: {
                return pSSysEAIDataTypeBase.getUserTag2();
            }
            case 25: {
                return pSSysEAIDataTypeBase.getUserTag3();
            }
            case 26: {
                return pSSysEAIDataTypeBase.getUserTag4();
            }
            case 27: {
                return pSSysEAIDataTypeBase.getValidFlag();
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
        PSSysEAIDataTypeBase.set(this, n, object);
    }

    private static void set(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDataTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysEAIDataTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSSysEAIDataTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysEAIDataTypeBase.setEAIDataTypeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysEAIDataTypeBase.setEAIDataTypeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysEAIDataTypeBase.setEnableEnum(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysEAIDataTypeBase.setIncMaxValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysEAIDataTypeBase.setIncMinValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysEAIDataTypeBase.setMaxStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysEAIDataTypeBase.setMaxValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysEAIDataTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysEAIDataTypeBase.setMinStrLength(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysEAIDataTypeBase.setMinValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysEAIDataTypeBase.setPrecision2(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysEAIDataTypeBase.setPSSysEAIDataTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysEAIDataTypeBase.setPSSysEAIDataTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysEAIDataTypeBase.setPSSysEAISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysEAIDataTypeBase.setPSSysEAISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysEAIDataTypeBase.setRegExpCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysEAIDataTypeBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSSysEAIDataTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSSysEAIDataTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysEAIDataTypeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysEAIDataTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysEAIDataTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysEAIDataTypeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysEAIDataTypeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysEAIDataTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysEAIDataTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeBase.getCodeName() == null;
            }
            case 1: {
                return pSSysEAIDataTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSSysEAIDataTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSSysEAIDataTypeBase.getEAIDataTypeTag() == null;
            }
            case 4: {
                return pSSysEAIDataTypeBase.getEAIDataTypeTag2() == null;
            }
            case 5: {
                return pSSysEAIDataTypeBase.getEnableEnum() == null;
            }
            case 6: {
                return pSSysEAIDataTypeBase.getIncMaxValue() == null;
            }
            case 7: {
                return pSSysEAIDataTypeBase.getIncMinValue() == null;
            }
            case 8: {
                return pSSysEAIDataTypeBase.getMaxStrLength() == null;
            }
            case 9: {
                return pSSysEAIDataTypeBase.getMaxValue() == null;
            }
            case 10: {
                return pSSysEAIDataTypeBase.getMemo() == null;
            }
            case 11: {
                return pSSysEAIDataTypeBase.getMinStrLength() == null;
            }
            case 12: {
                return pSSysEAIDataTypeBase.getMinValue() == null;
            }
            case 13: {
                return pSSysEAIDataTypeBase.getPrecision2() == null;
            }
            case 14: {
                return pSSysEAIDataTypeBase.getPSSysEAIDataTypeId() == null;
            }
            case 15: {
                return pSSysEAIDataTypeBase.getPSSysEAIDataTypeName() == null;
            }
            case 16: {
                return pSSysEAIDataTypeBase.getPSSysEAISchemeId() == null;
            }
            case 17: {
                return pSSysEAIDataTypeBase.getPSSysEAISchemeName() == null;
            }
            case 18: {
                return pSSysEAIDataTypeBase.getRegExpCode() == null;
            }
            case 19: {
                return pSSysEAIDataTypeBase.getStdDataType() == null;
            }
            case 20: {
                return pSSysEAIDataTypeBase.getUpdateDate() == null;
            }
            case 21: {
                return pSSysEAIDataTypeBase.getUpdateMan() == null;
            }
            case 22: {
                return pSSysEAIDataTypeBase.getUserCat() == null;
            }
            case 23: {
                return pSSysEAIDataTypeBase.getUserTag() == null;
            }
            case 24: {
                return pSSysEAIDataTypeBase.getUserTag2() == null;
            }
            case 25: {
                return pSSysEAIDataTypeBase.getUserTag3() == null;
            }
            case 26: {
                return pSSysEAIDataTypeBase.getUserTag4() == null;
            }
            case 27: {
                return pSSysEAIDataTypeBase.getValidFlag() == null;
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
        return PSSysEAIDataTypeBase.contains(this, n);
    }

    private static boolean contains(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysEAIDataTypeBase.isCodeNameDirty();
            }
            case 1: {
                return pSSysEAIDataTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSSysEAIDataTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSSysEAIDataTypeBase.isEAIDataTypeTagDirty();
            }
            case 4: {
                return pSSysEAIDataTypeBase.isEAIDataTypeTag2Dirty();
            }
            case 5: {
                return pSSysEAIDataTypeBase.isEnableEnumDirty();
            }
            case 6: {
                return pSSysEAIDataTypeBase.isIncMaxValueDirty();
            }
            case 7: {
                return pSSysEAIDataTypeBase.isIncMinValueDirty();
            }
            case 8: {
                return pSSysEAIDataTypeBase.isMaxStrLengthDirty();
            }
            case 9: {
                return pSSysEAIDataTypeBase.isMaxValueDirty();
            }
            case 10: {
                return pSSysEAIDataTypeBase.isMemoDirty();
            }
            case 11: {
                return pSSysEAIDataTypeBase.isMinStrLengthDirty();
            }
            case 12: {
                return pSSysEAIDataTypeBase.isMinValueDirty();
            }
            case 13: {
                return pSSysEAIDataTypeBase.isPrecision2Dirty();
            }
            case 14: {
                return pSSysEAIDataTypeBase.isPSSysEAIDataTypeIdDirty();
            }
            case 15: {
                return pSSysEAIDataTypeBase.isPSSysEAIDataTypeNameDirty();
            }
            case 16: {
                return pSSysEAIDataTypeBase.isPSSysEAISchemeIdDirty();
            }
            case 17: {
                return pSSysEAIDataTypeBase.isPSSysEAISchemeNameDirty();
            }
            case 18: {
                return pSSysEAIDataTypeBase.isRegExpCodeDirty();
            }
            case 19: {
                return pSSysEAIDataTypeBase.isStdDataTypeDirty();
            }
            case 20: {
                return pSSysEAIDataTypeBase.isUpdateDateDirty();
            }
            case 21: {
                return pSSysEAIDataTypeBase.isUpdateManDirty();
            }
            case 22: {
                return pSSysEAIDataTypeBase.isUserCatDirty();
            }
            case 23: {
                return pSSysEAIDataTypeBase.isUserTagDirty();
            }
            case 24: {
                return pSSysEAIDataTypeBase.isUserTag2Dirty();
            }
            case 25: {
                return pSSysEAIDataTypeBase.isUserTag3Dirty();
            }
            case 26: {
                return pSSysEAIDataTypeBase.isUserTag4Dirty();
            }
            case 27: {
                return pSSysEAIDataTypeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysEAIDataTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysEAIDataTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidatatypetag", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getEAIDataTypeTag()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"eaidatatypetag2", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getEAIDataTypeTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getEnableEnum() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableenum", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getEnableEnum()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getIncMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incmaxvalue", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getIncMaxValue()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getIncMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incminvalue", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getIncMinValue()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getMaxStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxstrlength", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getMaxStrLength()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getMaxValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maxvalue", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getMaxValue()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getMinStrLength() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minstrlength", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getMinStrLength()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getMinValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"minvalue", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getMinValue()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getPrecision2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"precision2", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getPrecision2()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypeid", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeId()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaidatatypename", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemeid", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getPSSysEAISchemeId()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyseaischemename", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getPSSysEAISchemeName()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getRegExpCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"regexpcode", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getRegExpCode()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysEAIDataTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysEAIDataTypeBase.getJSONValue((Object)pSSysEAIDataTypeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysEAIDataTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysEAIDataTypeBase.getCodeName() != null) {
            object = pSSysEAIDataTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getCreateDate() != null) {
            object = pSSysEAIDataTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getCreateMan() != null) {
            object = pSSysEAIDataTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag() != null) {
            object = pSSysEAIDataTypeBase.getEAIDataTypeTag();
            xmlNode.setAttribute(FIELD_EAIDATATYPETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag2() != null) {
            object = pSSysEAIDataTypeBase.getEAIDataTypeTag2();
            xmlNode.setAttribute(FIELD_EAIDATATYPETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getEnableEnum() != null) {
            object = pSSysEAIDataTypeBase.getEnableEnum();
            xmlNode.setAttribute(FIELD_ENABLEENUM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getIncMaxValue() != null) {
            object = pSSysEAIDataTypeBase.getIncMaxValue();
            xmlNode.setAttribute(FIELD_INCMAXVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getIncMinValue() != null) {
            object = pSSysEAIDataTypeBase.getIncMinValue();
            xmlNode.setAttribute(FIELD_INCMINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getMaxStrLength() != null) {
            object = pSSysEAIDataTypeBase.getMaxStrLength();
            xmlNode.setAttribute(FIELD_MAXSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getMaxValue() != null) {
            object = pSSysEAIDataTypeBase.getMaxValue();
            xmlNode.setAttribute(FIELD_MAXVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getMemo() != null) {
            object = pSSysEAIDataTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getMinStrLength() != null) {
            object = pSSysEAIDataTypeBase.getMinStrLength();
            xmlNode.setAttribute(FIELD_MINSTRLENGTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getMinValue() != null) {
            object = pSSysEAIDataTypeBase.getMinValue();
            xmlNode.setAttribute(FIELD_MINVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getPrecision2() != null) {
            object = pSSysEAIDataTypeBase.getPrecision2();
            xmlNode.setAttribute(FIELD_PRECISION2, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeId() != null) {
            object = pSSysEAIDataTypeBase.getPSSysEAIDataTypeId();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeName() != null) {
            object = pSSysEAIDataTypeBase.getPSSysEAIDataTypeName();
            xmlNode.setAttribute(FIELD_PSSYSEAIDATATYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeId() != null) {
            object = pSSysEAIDataTypeBase.getPSSysEAISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeName() != null) {
            object = pSSysEAIDataTypeBase.getPSSysEAISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSEAISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getRegExpCode() != null) {
            object = pSSysEAIDataTypeBase.getRegExpCode();
            xmlNode.setAttribute(FIELD_REGEXPCODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getStdDataType() != null) {
            object = pSSysEAIDataTypeBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getUpdateDate() != null) {
            object = pSSysEAIDataTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysEAIDataTypeBase.getUpdateMan() != null) {
            object = pSSysEAIDataTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getUserCat() != null) {
            object = pSSysEAIDataTypeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag() != null) {
            object = pSSysEAIDataTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag2() != null) {
            object = pSSysEAIDataTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag3() != null) {
            object = pSSysEAIDataTypeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getUserTag4() != null) {
            object = pSSysEAIDataTypeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysEAIDataTypeBase.getValidFlag() != null) {
            object = pSSysEAIDataTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysEAIDataTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysEAIDataTypeBase.isCodeNameDirty() && (bl || pSSysEAIDataTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysEAIDataTypeBase.getCodeName());
        }
        if (pSSysEAIDataTypeBase.isCreateDateDirty() && (bl || pSSysEAIDataTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysEAIDataTypeBase.getCreateDate());
        }
        if (pSSysEAIDataTypeBase.isCreateManDirty() && (bl || pSSysEAIDataTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysEAIDataTypeBase.getCreateMan());
        }
        if (pSSysEAIDataTypeBase.isEAIDataTypeTagDirty() && (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag() != null)) {
            iDataObject.set(FIELD_EAIDATATYPETAG, (Object)pSSysEAIDataTypeBase.getEAIDataTypeTag());
        }
        if (pSSysEAIDataTypeBase.isEAIDataTypeTag2Dirty() && (bl || pSSysEAIDataTypeBase.getEAIDataTypeTag2() != null)) {
            iDataObject.set(FIELD_EAIDATATYPETAG2, (Object)pSSysEAIDataTypeBase.getEAIDataTypeTag2());
        }
        if (pSSysEAIDataTypeBase.isEnableEnumDirty() && (bl || pSSysEAIDataTypeBase.getEnableEnum() != null)) {
            iDataObject.set(FIELD_ENABLEENUM, (Object)pSSysEAIDataTypeBase.getEnableEnum());
        }
        if (pSSysEAIDataTypeBase.isIncMaxValueDirty() && (bl || pSSysEAIDataTypeBase.getIncMaxValue() != null)) {
            iDataObject.set(FIELD_INCMAXVALUE, (Object)pSSysEAIDataTypeBase.getIncMaxValue());
        }
        if (pSSysEAIDataTypeBase.isIncMinValueDirty() && (bl || pSSysEAIDataTypeBase.getIncMinValue() != null)) {
            iDataObject.set(FIELD_INCMINVALUE, (Object)pSSysEAIDataTypeBase.getIncMinValue());
        }
        if (pSSysEAIDataTypeBase.isMaxStrLengthDirty() && (bl || pSSysEAIDataTypeBase.getMaxStrLength() != null)) {
            iDataObject.set(FIELD_MAXSTRLENGTH, (Object)pSSysEAIDataTypeBase.getMaxStrLength());
        }
        if (pSSysEAIDataTypeBase.isMaxValueDirty() && (bl || pSSysEAIDataTypeBase.getMaxValue() != null)) {
            iDataObject.set(FIELD_MAXVALUE, (Object)pSSysEAIDataTypeBase.getMaxValue());
        }
        if (pSSysEAIDataTypeBase.isMemoDirty() && (bl || pSSysEAIDataTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysEAIDataTypeBase.getMemo());
        }
        if (pSSysEAIDataTypeBase.isMinStrLengthDirty() && (bl || pSSysEAIDataTypeBase.getMinStrLength() != null)) {
            iDataObject.set(FIELD_MINSTRLENGTH, (Object)pSSysEAIDataTypeBase.getMinStrLength());
        }
        if (pSSysEAIDataTypeBase.isMinValueDirty() && (bl || pSSysEAIDataTypeBase.getMinValue() != null)) {
            iDataObject.set(FIELD_MINVALUE, (Object)pSSysEAIDataTypeBase.getMinValue());
        }
        if (pSSysEAIDataTypeBase.isPrecision2Dirty() && (bl || pSSysEAIDataTypeBase.getPrecision2() != null)) {
            iDataObject.set(FIELD_PRECISION2, (Object)pSSysEAIDataTypeBase.getPrecision2());
        }
        if (pSSysEAIDataTypeBase.isPSSysEAIDataTypeIdDirty() && (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPEID, (Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeId());
        }
        if (pSSysEAIDataTypeBase.isPSSysEAIDataTypeNameDirty() && (bl || pSSysEAIDataTypeBase.getPSSysEAIDataTypeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAIDATATYPENAME, (Object)pSSysEAIDataTypeBase.getPSSysEAIDataTypeName());
        }
        if (pSSysEAIDataTypeBase.isPSSysEAISchemeIdDirty() && (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMEID, (Object)pSSysEAIDataTypeBase.getPSSysEAISchemeId());
        }
        if (pSSysEAIDataTypeBase.isPSSysEAISchemeNameDirty() && (bl || pSSysEAIDataTypeBase.getPSSysEAISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSEAISCHEMENAME, (Object)pSSysEAIDataTypeBase.getPSSysEAISchemeName());
        }
        if (pSSysEAIDataTypeBase.isRegExpCodeDirty() && (bl || pSSysEAIDataTypeBase.getRegExpCode() != null)) {
            iDataObject.set(FIELD_REGEXPCODE, (Object)pSSysEAIDataTypeBase.getRegExpCode());
        }
        if (pSSysEAIDataTypeBase.isStdDataTypeDirty() && (bl || pSSysEAIDataTypeBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysEAIDataTypeBase.getStdDataType());
        }
        if (pSSysEAIDataTypeBase.isUpdateDateDirty() && (bl || pSSysEAIDataTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysEAIDataTypeBase.getUpdateDate());
        }
        if (pSSysEAIDataTypeBase.isUpdateManDirty() && (bl || pSSysEAIDataTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysEAIDataTypeBase.getUpdateMan());
        }
        if (pSSysEAIDataTypeBase.isUserCatDirty() && (bl || pSSysEAIDataTypeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysEAIDataTypeBase.getUserCat());
        }
        if (pSSysEAIDataTypeBase.isUserTagDirty() && (bl || pSSysEAIDataTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysEAIDataTypeBase.getUserTag());
        }
        if (pSSysEAIDataTypeBase.isUserTag2Dirty() && (bl || pSSysEAIDataTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysEAIDataTypeBase.getUserTag2());
        }
        if (pSSysEAIDataTypeBase.isUserTag3Dirty() && (bl || pSSysEAIDataTypeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysEAIDataTypeBase.getUserTag3());
        }
        if (pSSysEAIDataTypeBase.isUserTag4Dirty() && (bl || pSSysEAIDataTypeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysEAIDataTypeBase.getUserTag4());
        }
        if (pSSysEAIDataTypeBase.isValidFlagDirty() && (bl || pSSysEAIDataTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysEAIDataTypeBase.getValidFlag());
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
        return PSSysEAIDataTypeBase.remove(this, n);
    }

    private static boolean remove(PSSysEAIDataTypeBase pSSysEAIDataTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysEAIDataTypeBase.resetCodeName();
                return true;
            }
            case 1: {
                pSSysEAIDataTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSSysEAIDataTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSSysEAIDataTypeBase.resetEAIDataTypeTag();
                return true;
            }
            case 4: {
                pSSysEAIDataTypeBase.resetEAIDataTypeTag2();
                return true;
            }
            case 5: {
                pSSysEAIDataTypeBase.resetEnableEnum();
                return true;
            }
            case 6: {
                pSSysEAIDataTypeBase.resetIncMaxValue();
                return true;
            }
            case 7: {
                pSSysEAIDataTypeBase.resetIncMinValue();
                return true;
            }
            case 8: {
                pSSysEAIDataTypeBase.resetMaxStrLength();
                return true;
            }
            case 9: {
                pSSysEAIDataTypeBase.resetMaxValue();
                return true;
            }
            case 10: {
                pSSysEAIDataTypeBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysEAIDataTypeBase.resetMinStrLength();
                return true;
            }
            case 12: {
                pSSysEAIDataTypeBase.resetMinValue();
                return true;
            }
            case 13: {
                pSSysEAIDataTypeBase.resetPrecision2();
                return true;
            }
            case 14: {
                pSSysEAIDataTypeBase.resetPSSysEAIDataTypeId();
                return true;
            }
            case 15: {
                pSSysEAIDataTypeBase.resetPSSysEAIDataTypeName();
                return true;
            }
            case 16: {
                pSSysEAIDataTypeBase.resetPSSysEAISchemeId();
                return true;
            }
            case 17: {
                pSSysEAIDataTypeBase.resetPSSysEAISchemeName();
                return true;
            }
            case 18: {
                pSSysEAIDataTypeBase.resetRegExpCode();
                return true;
            }
            case 19: {
                pSSysEAIDataTypeBase.resetStdDataType();
                return true;
            }
            case 20: {
                pSSysEAIDataTypeBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSSysEAIDataTypeBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSSysEAIDataTypeBase.resetUserCat();
                return true;
            }
            case 23: {
                pSSysEAIDataTypeBase.resetUserTag();
                return true;
            }
            case 24: {
                pSSysEAIDataTypeBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSSysEAIDataTypeBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSSysEAIDataTypeBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSSysEAIDataTypeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysEAIScheme getPSSysEAIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIScheme();
        }
        if (this.getPSSysEAISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysEAISchemeLock;
        synchronized (n) {
            if (this.pssyseaischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysEAISchemeId(), (Object)this.pssyseaischeme.getPSSysEAISchemeId()) != 0L) {
                this.pssyseaischeme = null;
            }
            if (this.pssyseaischeme == null) {
                PSSysEAIScheme pSSysEAIScheme = new PSSysEAIScheme();
                pSSysEAIScheme.setPSSysEAISchemeId(this.getPSSysEAISchemeId());
                PSSysEAISchemeService pSSysEAISchemeService = (PSSysEAISchemeService)ServiceGlobal.getService(PSSysEAISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysEAISchemeService.autoGet(pSSysEAIScheme);
                this.pssyseaischeme = pSSysEAIScheme;
            }
            return this.pssyseaischeme;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysEAIDataTypeItem> getPSSysEAIDataTypeItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysEAIDataTypeItems();
        }
        if (this.getPSSysEAIDataTypeId() == null) {
            return null;
        }
        PSSysEAIDataTypeService pSSysEAIDataTypeService = (PSSysEAIDataTypeService)ServiceGlobal.getService(PSSysEAIDataTypeService.class, (SessionFactory)this.getSessionFactory());
        PSSysEAIDataTypeItemService pSSysEAIDataTypeItemService = (PSSysEAIDataTypeItemService)ServiceGlobal.getService(PSSysEAIDataTypeItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysEAIDataTypeItemsLock;
        synchronized (n) {
            if (this.pssyseaidatatypeitems == null) {
                this.pssyseaidatatypeitems = pSSysEAIDataTypeService.isTempData(this) ? pSSysEAIDataTypeItemService.selectTempByPSSysEAIDataType(this) : pSSysEAIDataTypeItemService.selectByPSSysEAIDataType(this);
            }
            return this.pssyseaidatatypeitems;
        }
    }

    private PSSysEAIDataTypeBase getProxyEntity() {
        return this.proxyPSSysEAIDataTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysEAIDataTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysEAIDataTypeBase) {
            this.proxyPSSysEAIDataTypeBase = (PSSysEAIDataTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.eaidesign.service.PSSysEAIDataTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_EAIDATATYPETAG, 3);
        fieldIndexMap.put(FIELD_EAIDATATYPETAG2, 4);
        fieldIndexMap.put(FIELD_ENABLEENUM, 5);
        fieldIndexMap.put(FIELD_INCMAXVALUE, 6);
        fieldIndexMap.put(FIELD_INCMINVALUE, 7);
        fieldIndexMap.put(FIELD_MAXSTRLENGTH, 8);
        fieldIndexMap.put(FIELD_MAXVALUE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_MINSTRLENGTH, 11);
        fieldIndexMap.put(FIELD_MINVALUE, 12);
        fieldIndexMap.put(FIELD_PRECISION2, 13);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPEID, 14);
        fieldIndexMap.put(FIELD_PSSYSEAIDATATYPENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMEID, 16);
        fieldIndexMap.put(FIELD_PSSYSEAISCHEMENAME, 17);
        fieldIndexMap.put(FIELD_REGEXPCODE, 18);
        fieldIndexMap.put(FIELD_STDDATATYPE, 19);
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

