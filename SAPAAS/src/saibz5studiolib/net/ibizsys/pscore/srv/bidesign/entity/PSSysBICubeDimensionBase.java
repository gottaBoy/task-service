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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIDimension;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBVF;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBVFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeDimensionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeDimensionBase.class);
    public static final String FIELD_ALLHIERARCHYFLAG = "ALLHIERARCHYFLAG";
    public static final String FIELD_BICUBEDIMENSIONTAG = "BICUBEDIMENSIONTAG";
    public static final String FIELD_BICUBEDIMENSIONTAG2 = "BICUBEDIMENSIONTAG2";
    public static final String FIELD_BIDIMENSIONTYPE = "BIDIMENSIONTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DIMENSIONFORMULA = "DIMENSIONFORMULA";
    public static final String FIELD_EXPANDFLAG = "EXPANDFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMPSDEUIACTIONID = "PARAMPSDEUIACTIONID";
    public static final String FIELD_PARAMPSDEUIACTIONNAME = "PARAMPSDEUIACTIONNAME";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONID = "PSSYSBICUBEDIMENSIONID";
    public static final String FIELD_PSSYSBICUBEDIMENSIONNAME = "PSSYSBICUBEDIMENSIONNAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String FIELD_PSSYSBIDIMENSIONNAME = "PSSYSBIDIMENSIONNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSDBVFID = "PSSYSDBVFID";
    public static final String FIELD_PSSYSDBVFNAME = "PSSYSDBVFNAME";
    public static final String FIELD_STDDATATYPE = "STDDATATYPE";
    public static final String FIELD_TEXTPSDEFID = "TEXTPSDEFID";
    public static final String FIELD_TEXTPSDEFNAME = "TEXTPSDEFNAME";
    public static final String FIELD_TEXTTEMPLATE = "TEXTTEMPLATE";
    public static final String FIELD_TIPTEMPLATE = "TIPTEMPLATE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ALLHIERARCHYFLAG = 0;
    private static final int INDEX_BICUBEDIMENSIONTAG = 1;
    private static final int INDEX_BICUBEDIMENSIONTAG2 = 2;
    private static final int INDEX_BIDIMENSIONTYPE = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DEFAULTFLAG = 7;
    private static final int INDEX_DIMENSIONFORMULA = 8;
    private static final int INDEX_EXPANDFLAG = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PARAMPSDEUIACTIONID = 12;
    private static final int INDEX_PARAMPSDEUIACTIONNAME = 13;
    private static final int INDEX_PSCODELISTID = 14;
    private static final int INDEX_PSCODELISTNAME = 15;
    private static final int INDEX_PSDEFID = 16;
    private static final int INDEX_PSDEFNAME = 17;
    private static final int INDEX_PSDEID = 18;
    private static final int INDEX_PSSYSBICUBEDIMENSIONID = 19;
    private static final int INDEX_PSSYSBICUBEDIMENSIONNAME = 20;
    private static final int INDEX_PSSYSBICUBEID = 21;
    private static final int INDEX_PSSYSBICUBENAME = 22;
    private static final int INDEX_PSSYSBIDIMENSIONID = 23;
    private static final int INDEX_PSSYSBIDIMENSIONNAME = 24;
    private static final int INDEX_PSSYSBISCHEMEID = 25;
    private static final int INDEX_PSSYSDBVFID = 26;
    private static final int INDEX_PSSYSDBVFNAME = 27;
    private static final int INDEX_STDDATATYPE = 28;
    private static final int INDEX_TEXTPSDEFID = 29;
    private static final int INDEX_TEXTPSDEFNAME = 30;
    private static final int INDEX_TEXTTEMPLATE = 31;
    private static final int INDEX_TIPTEMPLATE = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERCAT = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final int INDEX_VALIDFLAG = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeDimensionBase proxyPSSysBICubeDimensionBase = null;
    private boolean allhierarchyflagDirtyFlag = false;
    private boolean bicubedimensiontagDirtyFlag = false;
    private boolean bicubedimensiontag2DirtyFlag = false;
    private boolean bidimensiontypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean dimensionformulaDirtyFlag = false;
    private boolean expandflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean parampsdeuiactionidDirtyFlag = false;
    private boolean parampsdeuiactionnameDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean pssysbicubedimensionidDirtyFlag = false;
    private boolean pssysbicubedimensionnameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbidimensionidDirtyFlag = false;
    private boolean pssysbidimensionnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysdbvfidDirtyFlag = false;
    private boolean pssysdbvfnameDirtyFlag = false;
    private boolean stddatatypeDirtyFlag = false;
    private boolean textpsdefidDirtyFlag = false;
    private boolean textpsdefnameDirtyFlag = false;
    private boolean texttemplateDirtyFlag = false;
    private boolean tiptemplateDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="allhierarchyflag")
    private Integer allhierarchyflag;
    @Column(name="bicubedimensiontag")
    private String bicubedimensiontag;
    @Column(name="bicubedimensiontag2")
    private String bicubedimensiontag2;
    @Column(name="bidimensiontype")
    private String bidimensiontype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="dimensionformula")
    private String dimensionformula;
    @Column(name="expandflag")
    private Integer expandflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="parampsdeuiactionid")
    private String parampsdeuiactionid;
    @Column(name="parampsdeuiactionname")
    private String parampsdeuiactionname;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="pssysbicubedimensionid")
    private String pssysbicubedimensionid;
    @Column(name="pssysbicubedimensionname")
    private String pssysbicubedimensionname;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbidimensionid")
    private String pssysbidimensionid;
    @Column(name="pssysbidimensionname")
    private String pssysbidimensionname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysdbvfid")
    private String pssysdbvfid;
    @Column(name="pssysdbvfname")
    private String pssysdbvfname;
    @Column(name="stddatatype")
    private Integer stddatatype;
    @Column(name="textpsdefid")
    private String textpsdefid;
    @Column(name="textpsdefname")
    private String textpsdefname;
    @Column(name="texttemplate")
    private String texttemplate;
    @Column(name="tiptemplate")
    private String tiptemplate;
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
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objTextPSDEFLock = new Integer(1);
    private PSDEField textpsdef = null;
    private Integer objParamPSDEUIActionLock = new Integer(1);
    private PSDEUIAction parampsdeuiaction = null;
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysBIDimensionLock = new Integer(1);
    private PSSysBIDimension pssysbidimension = null;
    private Integer objPSSysDBVFLock = new Integer(1);
    private PSSysDBVF pssysdbvf = null;

    public void setAllHierarchyFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAllHierarchyFlag(n);
            return;
        }
        this.allhierarchyflag = n;
        this.allhierarchyflagDirtyFlag = true;
    }

    public Integer getAllHierarchyFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAllHierarchyFlag();
        }
        return this.allhierarchyflag;
    }

    public boolean isAllHierarchyFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAllHierarchyFlagDirty();
        }
        return this.allhierarchyflagDirtyFlag;
    }

    public void resetAllHierarchyFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAllHierarchyFlag();
            return;
        }
        this.allhierarchyflagDirtyFlag = false;
        this.allhierarchyflag = null;
    }

    public void setBICubeDimensionTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeDimensionTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubedimensiontag = string;
        this.bicubedimensiontagDirtyFlag = true;
    }

    public String getBICubeDimensionTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeDimensionTag();
        }
        return this.bicubedimensiontag;
    }

    public boolean isBICubeDimensionTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeDimensionTagDirty();
        }
        return this.bicubedimensiontagDirtyFlag;
    }

    public void resetBICubeDimensionTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeDimensionTag();
            return;
        }
        this.bicubedimensiontagDirtyFlag = false;
        this.bicubedimensiontag = null;
    }

    public void setBICubeDimensionTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeDimensionTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubedimensiontag2 = string;
        this.bicubedimensiontag2DirtyFlag = true;
    }

    public String getBICubeDimensionTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeDimensionTag2();
        }
        return this.bicubedimensiontag2;
    }

    public boolean isBICubeDimensionTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeDimensionTag2Dirty();
        }
        return this.bicubedimensiontag2DirtyFlag;
    }

    public void resetBICubeDimensionTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeDimensionTag2();
            return;
        }
        this.bicubedimensiontag2DirtyFlag = false;
        this.bicubedimensiontag2 = null;
    }

    public void setBIDimensionType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIDimensionType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bidimensiontype = string;
        this.bidimensiontypeDirtyFlag = true;
    }

    public String getBIDimensionType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIDimensionType();
        }
        return this.bidimensiontype;
    }

    public boolean isBIDimensionTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIDimensionTypeDirty();
        }
        return this.bidimensiontypeDirtyFlag;
    }

    public void resetBIDimensionType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIDimensionType();
            return;
        }
        this.bidimensiontypeDirtyFlag = false;
        this.bidimensiontype = null;
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

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDimensionFormula(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDimensionFormula(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dimensionformula = string;
        this.dimensionformulaDirtyFlag = true;
    }

    public String getDimensionFormula() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDimensionFormula();
        }
        return this.dimensionformula;
    }

    public boolean isDimensionFormulaDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDimensionFormulaDirty();
        }
        return this.dimensionformulaDirtyFlag;
    }

    public void resetDimensionFormula() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDimensionFormula();
            return;
        }
        this.dimensionformulaDirtyFlag = false;
        this.dimensionformula = null;
    }

    public void setExpandFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpandFlag(n);
            return;
        }
        this.expandflag = n;
        this.expandflagDirtyFlag = true;
    }

    public Integer getExpandFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpandFlag();
        }
        return this.expandflag;
    }

    public boolean isExpandFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpandFlagDirty();
        }
        return this.expandflagDirtyFlag;
    }

    public void resetExpandFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpandFlag();
            return;
        }
        this.expandflagDirtyFlag = false;
        this.expandflag = null;
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

    public void setParamPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeuiactionid = string;
        this.parampsdeuiactionidDirtyFlag = true;
    }

    public String getParamPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIActionId();
        }
        return this.parampsdeuiactionid;
    }

    public boolean isParamPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEUIActionIdDirty();
        }
        return this.parampsdeuiactionidDirtyFlag;
    }

    public void resetParamPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEUIActionId();
            return;
        }
        this.parampsdeuiactionidDirtyFlag = false;
        this.parampsdeuiactionid = null;
    }

    public void setParamPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.parampsdeuiactionname = string;
        this.parampsdeuiactionnameDirtyFlag = true;
    }

    public String getParamPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIActionName();
        }
        return this.parampsdeuiactionname;
    }

    public boolean isParamPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamPSDEUIActionNameDirty();
        }
        return this.parampsdeuiactionnameDirtyFlag;
    }

    public void resetParamPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamPSDEUIActionName();
            return;
        }
        this.parampsdeuiactionnameDirtyFlag = false;
        this.parampsdeuiactionname = null;
    }

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSSysBICubeDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionid = string;
        this.pssysbicubedimensionidDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionId();
        }
        return this.pssysbicubedimensionid;
    }

    public boolean isPSSysBICubeDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionIdDirty();
        }
        return this.pssysbicubedimensionidDirtyFlag;
    }

    public void resetPSSysBICubeDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionId();
            return;
        }
        this.pssysbicubedimensionidDirtyFlag = false;
        this.pssysbicubedimensionid = null;
    }

    public void setPSSysBICubeDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubedimensionname = string;
        this.pssysbicubedimensionnameDirtyFlag = true;
    }

    public String getPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensionName();
        }
        return this.pssysbicubedimensionname;
    }

    public boolean isPSSysBICubeDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeDimensionNameDirty();
        }
        return this.pssysbicubedimensionnameDirtyFlag;
    }

    public void resetPSSysBICubeDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeDimensionName();
            return;
        }
        this.pssysbicubedimensionnameDirtyFlag = false;
        this.pssysbicubedimensionname = null;
    }

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBIDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionid = string;
        this.pssysbidimensionidDirtyFlag = true;
    }

    public String getPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionId();
        }
        return this.pssysbidimensionid;
    }

    public boolean isPSSysBIDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionIdDirty();
        }
        return this.pssysbidimensionidDirtyFlag;
    }

    public void resetPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionId();
            return;
        }
        this.pssysbidimensionidDirtyFlag = false;
        this.pssysbidimensionid = null;
    }

    public void setPSSysBIDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionname = string;
        this.pssysbidimensionnameDirtyFlag = true;
    }

    public String getPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionName();
        }
        return this.pssysbidimensionname;
    }

    public boolean isPSSysBIDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionNameDirty();
        }
        return this.pssysbidimensionnameDirtyFlag;
    }

    public void resetPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionName();
            return;
        }
        this.pssysbidimensionnameDirtyFlag = false;
        this.pssysbidimensionname = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysDBVFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfid = string;
        this.pssysdbvfidDirtyFlag = true;
    }

    public String getPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFId();
        }
        return this.pssysdbvfid;
    }

    public boolean isPSSysDBVFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFIdDirty();
        }
        return this.pssysdbvfidDirtyFlag;
    }

    public void resetPSSysDBVFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFId();
            return;
        }
        this.pssysdbvfidDirtyFlag = false;
        this.pssysdbvfid = null;
    }

    public void setPSSysDBVFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBVFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbvfname = string;
        this.pssysdbvfnameDirtyFlag = true;
    }

    public String getPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVFName();
        }
        return this.pssysdbvfname;
    }

    public boolean isPSSysDBVFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBVFNameDirty();
        }
        return this.pssysdbvfnameDirtyFlag;
    }

    public void resetPSSysDBVFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBVFName();
            return;
        }
        this.pssysdbvfnameDirtyFlag = false;
        this.pssysdbvfname = null;
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

    public void setTextTemplate(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextTemplate(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.texttemplate = string;
        this.texttemplateDirtyFlag = true;
    }

    public String getTextTemplate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextTemplate();
        }
        return this.texttemplate;
    }

    public boolean isTextTemplateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextTemplateDirty();
        }
        return this.texttemplateDirtyFlag;
    }

    public void resetTextTemplate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextTemplate();
            return;
        }
        this.texttemplateDirtyFlag = false;
        this.texttemplate = null;
    }

    public void setTipTemplate(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipTemplate(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tiptemplate = string;
        this.tiptemplateDirtyFlag = true;
    }

    public String getTipTemplate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipTemplate();
        }
        return this.tiptemplate;
    }

    public boolean isTipTemplateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipTemplateDirty();
        }
        return this.tiptemplateDirtyFlag;
    }

    public void resetTipTemplate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipTemplate();
            return;
        }
        this.tiptemplateDirtyFlag = false;
        this.tiptemplate = null;
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
        PSSysBICubeDimensionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeDimensionBase pSSysBICubeDimensionBase) {
        pSSysBICubeDimensionBase.resetAllHierarchyFlag();
        pSSysBICubeDimensionBase.resetBICubeDimensionTag();
        pSSysBICubeDimensionBase.resetBICubeDimensionTag2();
        pSSysBICubeDimensionBase.resetBIDimensionType();
        pSSysBICubeDimensionBase.resetCodeName();
        pSSysBICubeDimensionBase.resetCreateDate();
        pSSysBICubeDimensionBase.resetCreateMan();
        pSSysBICubeDimensionBase.resetDefaultFlag();
        pSSysBICubeDimensionBase.resetDimensionFormula();
        pSSysBICubeDimensionBase.resetExpandFlag();
        pSSysBICubeDimensionBase.resetMemo();
        pSSysBICubeDimensionBase.resetOrderValue();
        pSSysBICubeDimensionBase.resetParamPSDEUIActionId();
        pSSysBICubeDimensionBase.resetParamPSDEUIActionName();
        pSSysBICubeDimensionBase.resetPSCodeListId();
        pSSysBICubeDimensionBase.resetPSCodeListName();
        pSSysBICubeDimensionBase.resetPSDEFId();
        pSSysBICubeDimensionBase.resetPSDEFName();
        pSSysBICubeDimensionBase.resetPSDEId();
        pSSysBICubeDimensionBase.resetPSSysBICubeDimensionId();
        pSSysBICubeDimensionBase.resetPSSysBICubeDimensionName();
        pSSysBICubeDimensionBase.resetPSSysBICubeId();
        pSSysBICubeDimensionBase.resetPSSysBICubeName();
        pSSysBICubeDimensionBase.resetPSSysBIDimensionId();
        pSSysBICubeDimensionBase.resetPSSysBIDimensionName();
        pSSysBICubeDimensionBase.resetPSSysBISchemeId();
        pSSysBICubeDimensionBase.resetPSSysDBVFId();
        pSSysBICubeDimensionBase.resetPSSysDBVFName();
        pSSysBICubeDimensionBase.resetStdDataType();
        pSSysBICubeDimensionBase.resetTextPSDEFId();
        pSSysBICubeDimensionBase.resetTextPSDEFName();
        pSSysBICubeDimensionBase.resetTextTemplate();
        pSSysBICubeDimensionBase.resetTipTemplate();
        pSSysBICubeDimensionBase.resetUpdateDate();
        pSSysBICubeDimensionBase.resetUpdateMan();
        pSSysBICubeDimensionBase.resetUserCat();
        pSSysBICubeDimensionBase.resetUserTag();
        pSSysBICubeDimensionBase.resetUserTag2();
        pSSysBICubeDimensionBase.resetUserTag3();
        pSSysBICubeDimensionBase.resetUserTag4();
        pSSysBICubeDimensionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAllHierarchyFlagDirty()) {
            hashMap.put(FIELD_ALLHIERARCHYFLAG, this.getAllHierarchyFlag());
        }
        if (!bl || this.isBICubeDimensionTagDirty()) {
            hashMap.put(FIELD_BICUBEDIMENSIONTAG, this.getBICubeDimensionTag());
        }
        if (!bl || this.isBICubeDimensionTag2Dirty()) {
            hashMap.put(FIELD_BICUBEDIMENSIONTAG2, this.getBICubeDimensionTag2());
        }
        if (!bl || this.isBIDimensionTypeDirty()) {
            hashMap.put(FIELD_BIDIMENSIONTYPE, this.getBIDimensionType());
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
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDimensionFormulaDirty()) {
            hashMap.put(FIELD_DIMENSIONFORMULA, this.getDimensionFormula());
        }
        if (!bl || this.isExpandFlagDirty()) {
            hashMap.put(FIELD_EXPANDFLAG, this.getExpandFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PARAMPSDEUIACTIONID, this.getParamPSDEUIActionId());
        }
        if (!bl || this.isParamPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PARAMPSDEUIACTIONNAME, this.getParamPSDEUIActionName());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSSysBICubeDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONID, this.getPSSysBICubeDimensionId());
        }
        if (!bl || this.isPSSysBICubeDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, this.getPSSysBICubeDimensionName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBIDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONID, this.getPSSysBIDimensionId());
        }
        if (!bl || this.isPSSysBIDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONNAME, this.getPSSysBIDimensionName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysDBVFIdDirty()) {
            hashMap.put(FIELD_PSSYSDBVFID, this.getPSSysDBVFId());
        }
        if (!bl || this.isPSSysDBVFNameDirty()) {
            hashMap.put(FIELD_PSSYSDBVFNAME, this.getPSSysDBVFName());
        }
        if (!bl || this.isStdDataTypeDirty()) {
            hashMap.put(FIELD_STDDATATYPE, this.getStdDataType());
        }
        if (!bl || this.isTextPSDEFIdDirty()) {
            hashMap.put(FIELD_TEXTPSDEFID, this.getTextPSDEFId());
        }
        if (!bl || this.isTextPSDEFNameDirty()) {
            hashMap.put(FIELD_TEXTPSDEFNAME, this.getTextPSDEFName());
        }
        if (!bl || this.isTextTemplateDirty()) {
            hashMap.put(FIELD_TEXTTEMPLATE, this.getTextTemplate());
        }
        if (!bl || this.isTipTemplateDirty()) {
            hashMap.put(FIELD_TIPTEMPLATE, this.getTipTemplate());
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
        return PSSysBICubeDimensionBase.get(this, n);
    }

    private static Object get(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeDimensionBase.getAllHierarchyFlag();
            }
            case 1: {
                return pSSysBICubeDimensionBase.getBICubeDimensionTag();
            }
            case 2: {
                return pSSysBICubeDimensionBase.getBICubeDimensionTag2();
            }
            case 3: {
                return pSSysBICubeDimensionBase.getBIDimensionType();
            }
            case 4: {
                return pSSysBICubeDimensionBase.getCodeName();
            }
            case 5: {
                return pSSysBICubeDimensionBase.getCreateDate();
            }
            case 6: {
                return pSSysBICubeDimensionBase.getCreateMan();
            }
            case 7: {
                return pSSysBICubeDimensionBase.getDefaultFlag();
            }
            case 8: {
                return pSSysBICubeDimensionBase.getDimensionFormula();
            }
            case 9: {
                return pSSysBICubeDimensionBase.getExpandFlag();
            }
            case 10: {
                return pSSysBICubeDimensionBase.getMemo();
            }
            case 11: {
                return pSSysBICubeDimensionBase.getOrderValue();
            }
            case 12: {
                return pSSysBICubeDimensionBase.getParamPSDEUIActionId();
            }
            case 13: {
                return pSSysBICubeDimensionBase.getParamPSDEUIActionName();
            }
            case 14: {
                return pSSysBICubeDimensionBase.getPSCodeListId();
            }
            case 15: {
                return pSSysBICubeDimensionBase.getPSCodeListName();
            }
            case 16: {
                return pSSysBICubeDimensionBase.getPSDEFId();
            }
            case 17: {
                return pSSysBICubeDimensionBase.getPSDEFName();
            }
            case 18: {
                return pSSysBICubeDimensionBase.getPSDEId();
            }
            case 19: {
                return pSSysBICubeDimensionBase.getPSSysBICubeDimensionId();
            }
            case 20: {
                return pSSysBICubeDimensionBase.getPSSysBICubeDimensionName();
            }
            case 21: {
                return pSSysBICubeDimensionBase.getPSSysBICubeId();
            }
            case 22: {
                return pSSysBICubeDimensionBase.getPSSysBICubeName();
            }
            case 23: {
                return pSSysBICubeDimensionBase.getPSSysBIDimensionId();
            }
            case 24: {
                return pSSysBICubeDimensionBase.getPSSysBIDimensionName();
            }
            case 25: {
                return pSSysBICubeDimensionBase.getPSSysBISchemeId();
            }
            case 26: {
                return pSSysBICubeDimensionBase.getPSSysDBVFId();
            }
            case 27: {
                return pSSysBICubeDimensionBase.getPSSysDBVFName();
            }
            case 28: {
                return pSSysBICubeDimensionBase.getStdDataType();
            }
            case 29: {
                return pSSysBICubeDimensionBase.getTextPSDEFId();
            }
            case 30: {
                return pSSysBICubeDimensionBase.getTextPSDEFName();
            }
            case 31: {
                return pSSysBICubeDimensionBase.getTextTemplate();
            }
            case 32: {
                return pSSysBICubeDimensionBase.getTipTemplate();
            }
            case 33: {
                return pSSysBICubeDimensionBase.getUpdateDate();
            }
            case 34: {
                return pSSysBICubeDimensionBase.getUpdateMan();
            }
            case 35: {
                return pSSysBICubeDimensionBase.getUserCat();
            }
            case 36: {
                return pSSysBICubeDimensionBase.getUserTag();
            }
            case 37: {
                return pSSysBICubeDimensionBase.getUserTag2();
            }
            case 38: {
                return pSSysBICubeDimensionBase.getUserTag3();
            }
            case 39: {
                return pSSysBICubeDimensionBase.getUserTag4();
            }
            case 40: {
                return pSSysBICubeDimensionBase.getValidFlag();
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
        PSSysBICubeDimensionBase.set(this, n, object);
    }

    private static void set(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeDimensionBase.setAllHierarchyFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeDimensionBase.setBICubeDimensionTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeDimensionBase.setBICubeDimensionTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeDimensionBase.setBIDimensionType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeDimensionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeDimensionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeDimensionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeDimensionBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeDimensionBase.setDimensionFormula(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeDimensionBase.setExpandFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeDimensionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeDimensionBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeDimensionBase.setParamPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeDimensionBase.setParamPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeDimensionBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeDimensionBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeDimensionBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeDimensionBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeDimensionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeDimensionBase.setPSSysBICubeDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeDimensionBase.setPSSysBICubeDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeDimensionBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeDimensionBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeDimensionBase.setPSSysBIDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeDimensionBase.setPSSysBIDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeDimensionBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBICubeDimensionBase.setPSSysDBVFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBICubeDimensionBase.setPSSysDBVFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBICubeDimensionBase.setStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysBICubeDimensionBase.setTextPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBICubeDimensionBase.setTextPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBICubeDimensionBase.setTextTemplate(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBICubeDimensionBase.setTipTemplate(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBICubeDimensionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSysBICubeDimensionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBICubeDimensionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBICubeDimensionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBICubeDimensionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysBICubeDimensionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBICubeDimensionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysBICubeDimensionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBICubeDimensionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeDimensionBase.getAllHierarchyFlag() == null;
            }
            case 1: {
                return pSSysBICubeDimensionBase.getBICubeDimensionTag() == null;
            }
            case 2: {
                return pSSysBICubeDimensionBase.getBICubeDimensionTag2() == null;
            }
            case 3: {
                return pSSysBICubeDimensionBase.getBIDimensionType() == null;
            }
            case 4: {
                return pSSysBICubeDimensionBase.getCodeName() == null;
            }
            case 5: {
                return pSSysBICubeDimensionBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysBICubeDimensionBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysBICubeDimensionBase.getDefaultFlag() == null;
            }
            case 8: {
                return pSSysBICubeDimensionBase.getDimensionFormula() == null;
            }
            case 9: {
                return pSSysBICubeDimensionBase.getExpandFlag() == null;
            }
            case 10: {
                return pSSysBICubeDimensionBase.getMemo() == null;
            }
            case 11: {
                return pSSysBICubeDimensionBase.getOrderValue() == null;
            }
            case 12: {
                return pSSysBICubeDimensionBase.getParamPSDEUIActionId() == null;
            }
            case 13: {
                return pSSysBICubeDimensionBase.getParamPSDEUIActionName() == null;
            }
            case 14: {
                return pSSysBICubeDimensionBase.getPSCodeListId() == null;
            }
            case 15: {
                return pSSysBICubeDimensionBase.getPSCodeListName() == null;
            }
            case 16: {
                return pSSysBICubeDimensionBase.getPSDEFId() == null;
            }
            case 17: {
                return pSSysBICubeDimensionBase.getPSDEFName() == null;
            }
            case 18: {
                return pSSysBICubeDimensionBase.getPSDEId() == null;
            }
            case 19: {
                return pSSysBICubeDimensionBase.getPSSysBICubeDimensionId() == null;
            }
            case 20: {
                return pSSysBICubeDimensionBase.getPSSysBICubeDimensionName() == null;
            }
            case 21: {
                return pSSysBICubeDimensionBase.getPSSysBICubeId() == null;
            }
            case 22: {
                return pSSysBICubeDimensionBase.getPSSysBICubeName() == null;
            }
            case 23: {
                return pSSysBICubeDimensionBase.getPSSysBIDimensionId() == null;
            }
            case 24: {
                return pSSysBICubeDimensionBase.getPSSysBIDimensionName() == null;
            }
            case 25: {
                return pSSysBICubeDimensionBase.getPSSysBISchemeId() == null;
            }
            case 26: {
                return pSSysBICubeDimensionBase.getPSSysDBVFId() == null;
            }
            case 27: {
                return pSSysBICubeDimensionBase.getPSSysDBVFName() == null;
            }
            case 28: {
                return pSSysBICubeDimensionBase.getStdDataType() == null;
            }
            case 29: {
                return pSSysBICubeDimensionBase.getTextPSDEFId() == null;
            }
            case 30: {
                return pSSysBICubeDimensionBase.getTextPSDEFName() == null;
            }
            case 31: {
                return pSSysBICubeDimensionBase.getTextTemplate() == null;
            }
            case 32: {
                return pSSysBICubeDimensionBase.getTipTemplate() == null;
            }
            case 33: {
                return pSSysBICubeDimensionBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSysBICubeDimensionBase.getUpdateMan() == null;
            }
            case 35: {
                return pSSysBICubeDimensionBase.getUserCat() == null;
            }
            case 36: {
                return pSSysBICubeDimensionBase.getUserTag() == null;
            }
            case 37: {
                return pSSysBICubeDimensionBase.getUserTag2() == null;
            }
            case 38: {
                return pSSysBICubeDimensionBase.getUserTag3() == null;
            }
            case 39: {
                return pSSysBICubeDimensionBase.getUserTag4() == null;
            }
            case 40: {
                return pSSysBICubeDimensionBase.getValidFlag() == null;
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
        return PSSysBICubeDimensionBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeDimensionBase.isAllHierarchyFlagDirty();
            }
            case 1: {
                return pSSysBICubeDimensionBase.isBICubeDimensionTagDirty();
            }
            case 2: {
                return pSSysBICubeDimensionBase.isBICubeDimensionTag2Dirty();
            }
            case 3: {
                return pSSysBICubeDimensionBase.isBIDimensionTypeDirty();
            }
            case 4: {
                return pSSysBICubeDimensionBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysBICubeDimensionBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysBICubeDimensionBase.isCreateManDirty();
            }
            case 7: {
                return pSSysBICubeDimensionBase.isDefaultFlagDirty();
            }
            case 8: {
                return pSSysBICubeDimensionBase.isDimensionFormulaDirty();
            }
            case 9: {
                return pSSysBICubeDimensionBase.isExpandFlagDirty();
            }
            case 10: {
                return pSSysBICubeDimensionBase.isMemoDirty();
            }
            case 11: {
                return pSSysBICubeDimensionBase.isOrderValueDirty();
            }
            case 12: {
                return pSSysBICubeDimensionBase.isParamPSDEUIActionIdDirty();
            }
            case 13: {
                return pSSysBICubeDimensionBase.isParamPSDEUIActionNameDirty();
            }
            case 14: {
                return pSSysBICubeDimensionBase.isPSCodeListIdDirty();
            }
            case 15: {
                return pSSysBICubeDimensionBase.isPSCodeListNameDirty();
            }
            case 16: {
                return pSSysBICubeDimensionBase.isPSDEFIdDirty();
            }
            case 17: {
                return pSSysBICubeDimensionBase.isPSDEFNameDirty();
            }
            case 18: {
                return pSSysBICubeDimensionBase.isPSDEIdDirty();
            }
            case 19: {
                return pSSysBICubeDimensionBase.isPSSysBICubeDimensionIdDirty();
            }
            case 20: {
                return pSSysBICubeDimensionBase.isPSSysBICubeDimensionNameDirty();
            }
            case 21: {
                return pSSysBICubeDimensionBase.isPSSysBICubeIdDirty();
            }
            case 22: {
                return pSSysBICubeDimensionBase.isPSSysBICubeNameDirty();
            }
            case 23: {
                return pSSysBICubeDimensionBase.isPSSysBIDimensionIdDirty();
            }
            case 24: {
                return pSSysBICubeDimensionBase.isPSSysBIDimensionNameDirty();
            }
            case 25: {
                return pSSysBICubeDimensionBase.isPSSysBISchemeIdDirty();
            }
            case 26: {
                return pSSysBICubeDimensionBase.isPSSysDBVFIdDirty();
            }
            case 27: {
                return pSSysBICubeDimensionBase.isPSSysDBVFNameDirty();
            }
            case 28: {
                return pSSysBICubeDimensionBase.isStdDataTypeDirty();
            }
            case 29: {
                return pSSysBICubeDimensionBase.isTextPSDEFIdDirty();
            }
            case 30: {
                return pSSysBICubeDimensionBase.isTextPSDEFNameDirty();
            }
            case 31: {
                return pSSysBICubeDimensionBase.isTextTemplateDirty();
            }
            case 32: {
                return pSSysBICubeDimensionBase.isTipTemplateDirty();
            }
            case 33: {
                return pSSysBICubeDimensionBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSysBICubeDimensionBase.isUpdateManDirty();
            }
            case 35: {
                return pSSysBICubeDimensionBase.isUserCatDirty();
            }
            case 36: {
                return pSSysBICubeDimensionBase.isUserTagDirty();
            }
            case 37: {
                return pSSysBICubeDimensionBase.isUserTag2Dirty();
            }
            case 38: {
                return pSSysBICubeDimensionBase.isUserTag3Dirty();
            }
            case 39: {
                return pSSysBICubeDimensionBase.isUserTag4Dirty();
            }
            case 40: {
                return pSSysBICubeDimensionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeDimensionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeDimensionBase.getAllHierarchyFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"allhierarchyflag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getAllHierarchyFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubedimensiontag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getBICubeDimensionTag()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubedimensiontag2", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getBICubeDimensionTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getBIDimensionType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bidimensiontype", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getBIDimensionType()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getDimensionFormula() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dimensionformula", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getDimensionFormula()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getExpandFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expandflag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getExpandFlag()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeuiactionid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getParamPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"parampsdeuiactionname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getParamPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubedimensionname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBIDimensionId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBIDimensionName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysDBVFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysDBVFId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysDBVFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbvfname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getPSSysDBVFName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"stddatatype", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getStdDataType()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getTextPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefid", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getTextPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getTextPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpsdefname", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getTextPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getTextTemplate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"texttemplate", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getTextTemplate()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getTipTemplate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tiptemplate", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getTipTemplate()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBICubeDimensionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBICubeDimensionBase.getJSONValue((Object)pSSysBICubeDimensionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeDimensionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeDimensionBase.getAllHierarchyFlag() != null) {
            object = pSSysBICubeDimensionBase.getAllHierarchyFlag();
            xmlNode.setAttribute(FIELD_ALLHIERARCHYFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag() != null) {
            object = pSSysBICubeDimensionBase.getBICubeDimensionTag();
            xmlNode.setAttribute(FIELD_BICUBEDIMENSIONTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag2() != null) {
            object = pSSysBICubeDimensionBase.getBICubeDimensionTag2();
            xmlNode.setAttribute(FIELD_BICUBEDIMENSIONTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getBIDimensionType() != null) {
            object = pSSysBICubeDimensionBase.getBIDimensionType();
            xmlNode.setAttribute(FIELD_BIDIMENSIONTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getCodeName() != null) {
            object = pSSysBICubeDimensionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getCreateDate() != null) {
            object = pSSysBICubeDimensionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getCreateMan() != null) {
            object = pSSysBICubeDimensionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getDefaultFlag() != null) {
            object = pSSysBICubeDimensionBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getDimensionFormula() != null) {
            object = pSSysBICubeDimensionBase.getDimensionFormula();
            xmlNode.setAttribute(FIELD_DIMENSIONFORMULA, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getExpandFlag() != null) {
            object = pSSysBICubeDimensionBase.getExpandFlag();
            xmlNode.setAttribute(FIELD_EXPANDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getMemo() != null) {
            object = pSSysBICubeDimensionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getOrderValue() != null) {
            object = pSSysBICubeDimensionBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionId() != null) {
            object = pSSysBICubeDimensionBase.getParamPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PARAMPSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionName() != null) {
            object = pSSysBICubeDimensionBase.getParamPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PARAMPSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSCodeListId() != null) {
            object = pSSysBICubeDimensionBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSCodeListName() != null) {
            object = pSSysBICubeDimensionBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEFId() != null) {
            object = pSSysBICubeDimensionBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEFName() != null) {
            object = pSSysBICubeDimensionBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSDEId() != null) {
            object = pSSysBICubeDimensionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionId() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBICubeDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionName() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBICubeDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeId() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBICubeName() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionId() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBIDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionName() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBIDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysBISchemeId() != null) {
            object = pSSysBICubeDimensionBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysDBVFId() != null) {
            object = pSSysBICubeDimensionBase.getPSSysDBVFId();
            xmlNode.setAttribute(FIELD_PSSYSDBVFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getPSSysDBVFName() != null) {
            object = pSSysBICubeDimensionBase.getPSSysDBVFName();
            xmlNode.setAttribute(FIELD_PSSYSDBVFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getStdDataType() != null) {
            object = pSSysBICubeDimensionBase.getStdDataType();
            xmlNode.setAttribute(FIELD_STDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getTextPSDEFId() != null) {
            object = pSSysBICubeDimensionBase.getTextPSDEFId();
            xmlNode.setAttribute(FIELD_TEXTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getTextPSDEFName() != null) {
            object = pSSysBICubeDimensionBase.getTextPSDEFName();
            xmlNode.setAttribute(FIELD_TEXTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getTextTemplate() != null) {
            object = pSSysBICubeDimensionBase.getTextTemplate();
            xmlNode.setAttribute(FIELD_TEXTTEMPLATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getTipTemplate() != null) {
            object = pSSysBICubeDimensionBase.getTipTemplate();
            xmlNode.setAttribute(FIELD_TIPTEMPLATE, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUpdateDate() != null) {
            object = pSSysBICubeDimensionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeDimensionBase.getUpdateMan() != null) {
            object = pSSysBICubeDimensionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUserCat() != null) {
            object = pSSysBICubeDimensionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag() != null) {
            object = pSSysBICubeDimensionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag2() != null) {
            object = pSSysBICubeDimensionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag3() != null) {
            object = pSSysBICubeDimensionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getUserTag4() != null) {
            object = pSSysBICubeDimensionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeDimensionBase.getValidFlag() != null) {
            object = pSSysBICubeDimensionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeDimensionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeDimensionBase.isAllHierarchyFlagDirty() && (bl || pSSysBICubeDimensionBase.getAllHierarchyFlag() != null)) {
            iDataObject.set(FIELD_ALLHIERARCHYFLAG, (Object)pSSysBICubeDimensionBase.getAllHierarchyFlag());
        }
        if (pSSysBICubeDimensionBase.isBICubeDimensionTagDirty() && (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag() != null)) {
            iDataObject.set(FIELD_BICUBEDIMENSIONTAG, (Object)pSSysBICubeDimensionBase.getBICubeDimensionTag());
        }
        if (pSSysBICubeDimensionBase.isBICubeDimensionTag2Dirty() && (bl || pSSysBICubeDimensionBase.getBICubeDimensionTag2() != null)) {
            iDataObject.set(FIELD_BICUBEDIMENSIONTAG2, (Object)pSSysBICubeDimensionBase.getBICubeDimensionTag2());
        }
        if (pSSysBICubeDimensionBase.isBIDimensionTypeDirty() && (bl || pSSysBICubeDimensionBase.getBIDimensionType() != null)) {
            iDataObject.set(FIELD_BIDIMENSIONTYPE, (Object)pSSysBICubeDimensionBase.getBIDimensionType());
        }
        if (pSSysBICubeDimensionBase.isCodeNameDirty() && (bl || pSSysBICubeDimensionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBICubeDimensionBase.getCodeName());
        }
        if (pSSysBICubeDimensionBase.isCreateDateDirty() && (bl || pSSysBICubeDimensionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeDimensionBase.getCreateDate());
        }
        if (pSSysBICubeDimensionBase.isCreateManDirty() && (bl || pSSysBICubeDimensionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeDimensionBase.getCreateMan());
        }
        if (pSSysBICubeDimensionBase.isDefaultFlagDirty() && (bl || pSSysBICubeDimensionBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSSysBICubeDimensionBase.getDefaultFlag());
        }
        if (pSSysBICubeDimensionBase.isDimensionFormulaDirty() && (bl || pSSysBICubeDimensionBase.getDimensionFormula() != null)) {
            iDataObject.set(FIELD_DIMENSIONFORMULA, (Object)pSSysBICubeDimensionBase.getDimensionFormula());
        }
        if (pSSysBICubeDimensionBase.isExpandFlagDirty() && (bl || pSSysBICubeDimensionBase.getExpandFlag() != null)) {
            iDataObject.set(FIELD_EXPANDFLAG, (Object)pSSysBICubeDimensionBase.getExpandFlag());
        }
        if (pSSysBICubeDimensionBase.isMemoDirty() && (bl || pSSysBICubeDimensionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeDimensionBase.getMemo());
        }
        if (pSSysBICubeDimensionBase.isOrderValueDirty() && (bl || pSSysBICubeDimensionBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysBICubeDimensionBase.getOrderValue());
        }
        if (pSSysBICubeDimensionBase.isParamPSDEUIActionIdDirty() && (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PARAMPSDEUIACTIONID, (Object)pSSysBICubeDimensionBase.getParamPSDEUIActionId());
        }
        if (pSSysBICubeDimensionBase.isParamPSDEUIActionNameDirty() && (bl || pSSysBICubeDimensionBase.getParamPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PARAMPSDEUIACTIONNAME, (Object)pSSysBICubeDimensionBase.getParamPSDEUIActionName());
        }
        if (pSSysBICubeDimensionBase.isPSCodeListIdDirty() && (bl || pSSysBICubeDimensionBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSSysBICubeDimensionBase.getPSCodeListId());
        }
        if (pSSysBICubeDimensionBase.isPSCodeListNameDirty() && (bl || pSSysBICubeDimensionBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSSysBICubeDimensionBase.getPSCodeListName());
        }
        if (pSSysBICubeDimensionBase.isPSDEFIdDirty() && (bl || pSSysBICubeDimensionBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSSysBICubeDimensionBase.getPSDEFId());
        }
        if (pSSysBICubeDimensionBase.isPSDEFNameDirty() && (bl || pSSysBICubeDimensionBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSSysBICubeDimensionBase.getPSDEFName());
        }
        if (pSSysBICubeDimensionBase.isPSDEIdDirty() && (bl || pSSysBICubeDimensionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBICubeDimensionBase.getPSDEId());
        }
        if (pSSysBICubeDimensionBase.isPSSysBICubeDimensionIdDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONID, (Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionId());
        }
        if (pSSysBICubeDimensionBase.isPSSysBICubeDimensionNameDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBICubeDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEDIMENSIONNAME, (Object)pSSysBICubeDimensionBase.getPSSysBICubeDimensionName());
        }
        if (pSSysBICubeDimensionBase.isPSSysBICubeIdDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBICubeDimensionBase.getPSSysBICubeId());
        }
        if (pSSysBICubeDimensionBase.isPSSysBICubeNameDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBICubeDimensionBase.getPSSysBICubeName());
        }
        if (pSSysBICubeDimensionBase.isPSSysBIDimensionIdDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONID, (Object)pSSysBICubeDimensionBase.getPSSysBIDimensionId());
        }
        if (pSSysBICubeDimensionBase.isPSSysBIDimensionNameDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBIDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONNAME, (Object)pSSysBICubeDimensionBase.getPSSysBIDimensionName());
        }
        if (pSSysBICubeDimensionBase.isPSSysBISchemeIdDirty() && (bl || pSSysBICubeDimensionBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBICubeDimensionBase.getPSSysBISchemeId());
        }
        if (pSSysBICubeDimensionBase.isPSSysDBVFIdDirty() && (bl || pSSysBICubeDimensionBase.getPSSysDBVFId() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFID, (Object)pSSysBICubeDimensionBase.getPSSysDBVFId());
        }
        if (pSSysBICubeDimensionBase.isPSSysDBVFNameDirty() && (bl || pSSysBICubeDimensionBase.getPSSysDBVFName() != null)) {
            iDataObject.set(FIELD_PSSYSDBVFNAME, (Object)pSSysBICubeDimensionBase.getPSSysDBVFName());
        }
        if (pSSysBICubeDimensionBase.isStdDataTypeDirty() && (bl || pSSysBICubeDimensionBase.getStdDataType() != null)) {
            iDataObject.set(FIELD_STDDATATYPE, (Object)pSSysBICubeDimensionBase.getStdDataType());
        }
        if (pSSysBICubeDimensionBase.isTextPSDEFIdDirty() && (bl || pSSysBICubeDimensionBase.getTextPSDEFId() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFID, (Object)pSSysBICubeDimensionBase.getTextPSDEFId());
        }
        if (pSSysBICubeDimensionBase.isTextPSDEFNameDirty() && (bl || pSSysBICubeDimensionBase.getTextPSDEFName() != null)) {
            iDataObject.set(FIELD_TEXTPSDEFNAME, (Object)pSSysBICubeDimensionBase.getTextPSDEFName());
        }
        if (pSSysBICubeDimensionBase.isTextTemplateDirty() && (bl || pSSysBICubeDimensionBase.getTextTemplate() != null)) {
            iDataObject.set(FIELD_TEXTTEMPLATE, (Object)pSSysBICubeDimensionBase.getTextTemplate());
        }
        if (pSSysBICubeDimensionBase.isTipTemplateDirty() && (bl || pSSysBICubeDimensionBase.getTipTemplate() != null)) {
            iDataObject.set(FIELD_TIPTEMPLATE, (Object)pSSysBICubeDimensionBase.getTipTemplate());
        }
        if (pSSysBICubeDimensionBase.isUpdateDateDirty() && (bl || pSSysBICubeDimensionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeDimensionBase.getUpdateDate());
        }
        if (pSSysBICubeDimensionBase.isUpdateManDirty() && (bl || pSSysBICubeDimensionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeDimensionBase.getUpdateMan());
        }
        if (pSSysBICubeDimensionBase.isUserCatDirty() && (bl || pSSysBICubeDimensionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeDimensionBase.getUserCat());
        }
        if (pSSysBICubeDimensionBase.isUserTagDirty() && (bl || pSSysBICubeDimensionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeDimensionBase.getUserTag());
        }
        if (pSSysBICubeDimensionBase.isUserTag2Dirty() && (bl || pSSysBICubeDimensionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeDimensionBase.getUserTag2());
        }
        if (pSSysBICubeDimensionBase.isUserTag3Dirty() && (bl || pSSysBICubeDimensionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeDimensionBase.getUserTag3());
        }
        if (pSSysBICubeDimensionBase.isUserTag4Dirty() && (bl || pSSysBICubeDimensionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeDimensionBase.getUserTag4());
        }
        if (pSSysBICubeDimensionBase.isValidFlagDirty() && (bl || pSSysBICubeDimensionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBICubeDimensionBase.getValidFlag());
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
        return PSSysBICubeDimensionBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeDimensionBase pSSysBICubeDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeDimensionBase.resetAllHierarchyFlag();
                return true;
            }
            case 1: {
                pSSysBICubeDimensionBase.resetBICubeDimensionTag();
                return true;
            }
            case 2: {
                pSSysBICubeDimensionBase.resetBICubeDimensionTag2();
                return true;
            }
            case 3: {
                pSSysBICubeDimensionBase.resetBIDimensionType();
                return true;
            }
            case 4: {
                pSSysBICubeDimensionBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysBICubeDimensionBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysBICubeDimensionBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysBICubeDimensionBase.resetDefaultFlag();
                return true;
            }
            case 8: {
                pSSysBICubeDimensionBase.resetDimensionFormula();
                return true;
            }
            case 9: {
                pSSysBICubeDimensionBase.resetExpandFlag();
                return true;
            }
            case 10: {
                pSSysBICubeDimensionBase.resetMemo();
                return true;
            }
            case 11: {
                pSSysBICubeDimensionBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSSysBICubeDimensionBase.resetParamPSDEUIActionId();
                return true;
            }
            case 13: {
                pSSysBICubeDimensionBase.resetParamPSDEUIActionName();
                return true;
            }
            case 14: {
                pSSysBICubeDimensionBase.resetPSCodeListId();
                return true;
            }
            case 15: {
                pSSysBICubeDimensionBase.resetPSCodeListName();
                return true;
            }
            case 16: {
                pSSysBICubeDimensionBase.resetPSDEFId();
                return true;
            }
            case 17: {
                pSSysBICubeDimensionBase.resetPSDEFName();
                return true;
            }
            case 18: {
                pSSysBICubeDimensionBase.resetPSDEId();
                return true;
            }
            case 19: {
                pSSysBICubeDimensionBase.resetPSSysBICubeDimensionId();
                return true;
            }
            case 20: {
                pSSysBICubeDimensionBase.resetPSSysBICubeDimensionName();
                return true;
            }
            case 21: {
                pSSysBICubeDimensionBase.resetPSSysBICubeId();
                return true;
            }
            case 22: {
                pSSysBICubeDimensionBase.resetPSSysBICubeName();
                return true;
            }
            case 23: {
                pSSysBICubeDimensionBase.resetPSSysBIDimensionId();
                return true;
            }
            case 24: {
                pSSysBICubeDimensionBase.resetPSSysBIDimensionName();
                return true;
            }
            case 25: {
                pSSysBICubeDimensionBase.resetPSSysBISchemeId();
                return true;
            }
            case 26: {
                pSSysBICubeDimensionBase.resetPSSysDBVFId();
                return true;
            }
            case 27: {
                pSSysBICubeDimensionBase.resetPSSysDBVFName();
                return true;
            }
            case 28: {
                pSSysBICubeDimensionBase.resetStdDataType();
                return true;
            }
            case 29: {
                pSSysBICubeDimensionBase.resetTextPSDEFId();
                return true;
            }
            case 30: {
                pSSysBICubeDimensionBase.resetTextPSDEFName();
                return true;
            }
            case 31: {
                pSSysBICubeDimensionBase.resetTextTemplate();
                return true;
            }
            case 32: {
                pSSysBICubeDimensionBase.resetTipTemplate();
                return true;
            }
            case 33: {
                pSSysBICubeDimensionBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSysBICubeDimensionBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSSysBICubeDimensionBase.resetUserCat();
                return true;
            }
            case 36: {
                pSSysBICubeDimensionBase.resetUserTag();
                return true;
            }
            case 37: {
                pSSysBICubeDimensionBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSSysBICubeDimensionBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSSysBICubeDimensionBase.resetUserTag4();
                return true;
            }
            case 40: {
                pSSysBICubeDimensionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
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
    public PSDEUIAction getParamPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamPSDEUIAction();
        }
        if (this.getParamPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objParamPSDEUIActionLock;
        synchronized (n) {
            if (this.parampsdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getParamPSDEUIActionId(), (Object)this.parampsdeuiaction.getPSDEUIActionId()) != 0L) {
                this.parampsdeuiaction = null;
            }
            if (this.parampsdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getParamPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.parampsdeuiaction = pSDEUIAction;
            }
            return this.parampsdeuiaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIDimension getPSSysBIDimension() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimension();
        }
        if (this.getPSSysBIDimensionId() == null) {
            return null;
        }
        Integer n = this.objPSSysBIDimensionLock;
        synchronized (n) {
            if (this.pssysbidimension != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBIDimensionId(), (Object)this.pssysbidimension.getPSSysBIDimensionId()) != 0L) {
                this.pssysbidimension = null;
            }
            if (this.pssysbidimension == null) {
                PSSysBIDimension pSSysBIDimension = new PSSysBIDimension();
                pSSysBIDimension.setPSSysBIDimensionId(this.getPSSysBIDimensionId());
                PSSysBIDimensionService pSSysBIDimensionService = (PSSysBIDimensionService)ServiceGlobal.getService(PSSysBIDimensionService.class, (SessionFactory)this.getSessionFactory());
                pSSysBIDimensionService.autoGet((IEntity)pSSysBIDimension);
                this.pssysbidimension = pSSysBIDimension;
            }
            return this.pssysbidimension;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBVF getPSSysDBVF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBVF();
        }
        if (this.getPSSysDBVFId() == null) {
            return null;
        }
        Integer n = this.objPSSysDBVFLock;
        synchronized (n) {
            if (this.pssysdbvf != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDBVFId(), (Object)this.pssysdbvf.getPSSysDBVFId()) != 0L) {
                this.pssysdbvf = null;
            }
            if (this.pssysdbvf == null) {
                PSSysDBVF pSSysDBVF = new PSSysDBVF();
                pSSysDBVF.setPSSysDBVFId(this.getPSSysDBVFId());
                PSSysDBVFService pSSysDBVFService = (PSSysDBVFService)ServiceGlobal.getService(PSSysDBVFService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBVFService.autoGet((IEntity)pSSysDBVF);
                this.pssysdbvf = pSSysDBVF;
            }
            return this.pssysdbvf;
        }
    }

    private PSSysBICubeDimensionBase getProxyEntity() {
        return this.proxyPSSysBICubeDimensionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeDimensionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeDimensionBase) {
            this.proxyPSSysBICubeDimensionBase = (PSSysBICubeDimensionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALLHIERARCHYFLAG, 0);
        fieldIndexMap.put(FIELD_BICUBEDIMENSIONTAG, 1);
        fieldIndexMap.put(FIELD_BICUBEDIMENSIONTAG2, 2);
        fieldIndexMap.put(FIELD_BIDIMENSIONTYPE, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 7);
        fieldIndexMap.put(FIELD_DIMENSIONFORMULA, 8);
        fieldIndexMap.put(FIELD_EXPANDFLAG, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PARAMPSDEUIACTIONID, 12);
        fieldIndexMap.put(FIELD_PARAMPSDEUIACTIONNAME, 13);
        fieldIndexMap.put(FIELD_PSCODELISTID, 14);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 15);
        fieldIndexMap.put(FIELD_PSDEFID, 16);
        fieldIndexMap.put(FIELD_PSDEFNAME, 17);
        fieldIndexMap.put(FIELD_PSDEID, 18);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONID, 19);
        fieldIndexMap.put(FIELD_PSSYSBICUBEDIMENSIONNAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 21);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONID, 23);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONNAME, 24);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 25);
        fieldIndexMap.put(FIELD_PSSYSDBVFID, 26);
        fieldIndexMap.put(FIELD_PSSYSDBVFNAME, 27);
        fieldIndexMap.put(FIELD_STDDATATYPE, 28);
        fieldIndexMap.put(FIELD_TEXTPSDEFID, 29);
        fieldIndexMap.put(FIELD_TEXTPSDEFNAME, 30);
        fieldIndexMap.put(FIELD_TEXTTEMPLATE, 31);
        fieldIndexMap.put(FIELD_TIPTEMPLATE, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERCAT, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
        fieldIndexMap.put(FIELD_VALIDFLAG, 40);
    }
}

