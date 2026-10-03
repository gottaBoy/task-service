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
package net.ibizsys.pscore.srv.dedesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysMsgTempl;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSequence;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysTranslator;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysMsgTemplService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSequenceService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysTranslatorService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELNParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELNParamBase.class);
    public static final String FIELD_AGGMODE = "AGGMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String FIELD_CUSTOMSRCPARAM = "CUSTOMSRCPARAM";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_DIRECTCODE = "DIRECTCODE";
    public static final String FIELD_DSTINDEX = "DSTINDEX";
    public static final String FIELD_DSTPARAMPSDEID = "DSTPARAMPSDEID";
    public static final String FIELD_DSTPSDEFID = "DSTPSDEFID";
    public static final String FIELD_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String FIELD_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String FIELD_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String FIELD_DSTSORTDIR = "DSTSORTDIR";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_INOUTFLAG = "INOUTFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMS = "PARAMS";
    public static final String FIELD_PARAMTAG = "PARAMTAG";
    public static final String FIELD_PARAMTAG2 = "PARAMTAG2";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PARAMTYPETEXT = "PARAMTYPETEXT";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELNPARAMID = "PSDELNPARAMID";
    public static final String FIELD_PSDELNPARAMNAME = "PSDELNPARAMNAME";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICNODEID = "PSDELOGICNODEID";
    public static final String FIELD_PSDELOGICNODENAME = "PSDELOGICNODENAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSOBJDATA = "PSOBJDATA";
    public static final String FIELD_PSOBJDATA2 = "PSOBJDATA2";
    public static final String FIELD_PSOBJID = "PSOBJID";
    public static final String FIELD_PSOBJNAME = "PSOBJNAME";
    public static final String FIELD_PSOBJTYPE = "PSOBJTYPE";
    public static final String FIELD_PSOBJTYPENAME = "PSOBJTYPENAME";
    public static final String FIELD_PSSYSMSGTEMPLID = "PSSYSMSGTEMPLID";
    public static final String FIELD_PSSYSMSGTEMPLNAME = "PSSYSMSGTEMPLNAME";
    public static final String FIELD_PSSYSSEQUENCEID = "PSSYSSEQUENCEID";
    public static final String FIELD_PSSYSSEQUENCENAME = "PSSYSSEQUENCENAME";
    public static final String FIELD_PSSYSTRANSLATORID = "PSSYSTRANSLATORID";
    public static final String FIELD_PSSYSTRANSLATORNAME = "PSSYSTRANSLATORNAME";
    public static final String FIELD_SRCINDEX = "SRCINDEX";
    public static final String FIELD_SRCPARAMPSDEID = "SRCPARAMPSDEID";
    public static final String FIELD_SRCPSDEFID = "SRCPSDEFID";
    public static final String FIELD_SRCPSDEFNAME = "SRCPSDEFNAME";
    public static final String FIELD_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String FIELD_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    public static final String FIELD_SRCSIZE = "SRCSIZE";
    public static final String FIELD_SRCVALUE = "SRCVALUE";
    public static final String FIELD_SRCVALUESTDDATATYPE = "SRCVALUESTDDATATYPE";
    public static final String FIELD_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String FIELD_SRCVALUETYPETEXT = "SRCVALUETYPETEXT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_AGGMODE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMDSTPARAM = 3;
    private static final int INDEX_CUSTOMSRCPARAM = 4;
    private static final int INDEX_DEFAULTVALUE = 5;
    private static final int INDEX_DIRECTCODE = 6;
    private static final int INDEX_DSTINDEX = 7;
    private static final int INDEX_DSTPARAMPSDEID = 8;
    private static final int INDEX_DSTPSDEFID = 9;
    private static final int INDEX_DSTPSDEFNAME = 10;
    private static final int INDEX_DSTPSDLPARAMID = 11;
    private static final int INDEX_DSTPSDLPARAMNAME = 12;
    private static final int INDEX_DSTSORTDIR = 13;
    private static final int INDEX_DYNAMODELFLAG = 14;
    private static final int INDEX_INOUTFLAG = 15;
    private static final int INDEX_MEMO = 16;
    private static final int INDEX_ORDERVALUE = 17;
    private static final int INDEX_PARAMS = 18;
    private static final int INDEX_PARAMTAG = 19;
    private static final int INDEX_PARAMTAG2 = 20;
    private static final int INDEX_PARAMTYPE = 21;
    private static final int INDEX_PARAMTYPETEXT = 22;
    private static final int INDEX_PSDEID = 23;
    private static final int INDEX_PSDELNPARAMID = 24;
    private static final int INDEX_PSDELNPARAMNAME = 25;
    private static final int INDEX_PSDELOGICID = 26;
    private static final int INDEX_PSDELOGICNODEID = 27;
    private static final int INDEX_PSDELOGICNODENAME = 28;
    private static final int INDEX_PSDENAME = 29;
    private static final int INDEX_PSDYNAINSTID = 30;
    private static final int INDEX_PSOBJDATA = 31;
    private static final int INDEX_PSOBJDATA2 = 32;
    private static final int INDEX_PSOBJID = 33;
    private static final int INDEX_PSOBJNAME = 34;
    private static final int INDEX_PSOBJTYPE = 35;
    private static final int INDEX_PSOBJTYPENAME = 36;
    private static final int INDEX_PSSYSMSGTEMPLID = 37;
    private static final int INDEX_PSSYSMSGTEMPLNAME = 38;
    private static final int INDEX_PSSYSSEQUENCEID = 39;
    private static final int INDEX_PSSYSSEQUENCENAME = 40;
    private static final int INDEX_PSSYSTRANSLATORID = 41;
    private static final int INDEX_PSSYSTRANSLATORNAME = 42;
    private static final int INDEX_SRCINDEX = 43;
    private static final int INDEX_SRCPARAMPSDEID = 44;
    private static final int INDEX_SRCPSDEFID = 45;
    private static final int INDEX_SRCPSDEFNAME = 46;
    private static final int INDEX_SRCPSDLPARAMID = 47;
    private static final int INDEX_SRCPSDLPARAMNAME = 48;
    private static final int INDEX_SRCSIZE = 49;
    private static final int INDEX_SRCVALUE = 50;
    private static final int INDEX_SRCVALUESTDDATATYPE = 51;
    private static final int INDEX_SRCVALUETYPE = 52;
    private static final int INDEX_SRCVALUETYPETEXT = 53;
    private static final int INDEX_UPDATEDATE = 54;
    private static final int INDEX_UPDATEMAN = 55;
    private static final int INDEX_USERCAT = 56;
    private static final int INDEX_USERTAG = 57;
    private static final int INDEX_USERTAG2 = 58;
    private static final int INDEX_USERTAG3 = 59;
    private static final int INDEX_USERTAG4 = 60;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELNParamBase proxyPSDELNParamBase = null;
    private boolean aggmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdstparamDirtyFlag = false;
    private boolean customsrcparamDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean directcodeDirtyFlag = false;
    private boolean dstindexDirtyFlag = false;
    private boolean dstparampsdeidDirtyFlag = false;
    private boolean dstpsdefidDirtyFlag = false;
    private boolean dstpsdefnameDirtyFlag = false;
    private boolean dstpsdlparamidDirtyFlag = false;
    private boolean dstpsdlparamnameDirtyFlag = false;
    private boolean dstsortdirDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean inoutflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramsDirtyFlag = false;
    private boolean paramtagDirtyFlag = false;
    private boolean paramtag2DirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean paramtypetextDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelnparamidDirtyFlag = false;
    private boolean psdelnparamnameDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogicnodeidDirtyFlag = false;
    private boolean psdelogicnodenameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psobjdataDirtyFlag = false;
    private boolean psobjdata2DirtyFlag = false;
    private boolean psobjidDirtyFlag = false;
    private boolean psobjnameDirtyFlag = false;
    private boolean psobjtypeDirtyFlag = false;
    private boolean psobjtypenameDirtyFlag = false;
    private boolean pssysmsgtemplidDirtyFlag = false;
    private boolean pssysmsgtemplnameDirtyFlag = false;
    private boolean pssyssequenceidDirtyFlag = false;
    private boolean pssyssequencenameDirtyFlag = false;
    private boolean pssystranslatoridDirtyFlag = false;
    private boolean pssystranslatornameDirtyFlag = false;
    private boolean srcindexDirtyFlag = false;
    private boolean srcparampsdeidDirtyFlag = false;
    private boolean srcpsdefidDirtyFlag = false;
    private boolean srcpsdefnameDirtyFlag = false;
    private boolean srcpsdlparamidDirtyFlag = false;
    private boolean srcpsdlparamnameDirtyFlag = false;
    private boolean srcsizeDirtyFlag = false;
    private boolean srcvalueDirtyFlag = false;
    private boolean srcvaluestddatatypeDirtyFlag = false;
    private boolean srcvaluetypeDirtyFlag = false;
    private boolean srcvaluetypetextDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="aggmode")
    private String aggmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdstparam")
    private String customdstparam;
    @Column(name="customsrcparam")
    private String customsrcparam;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="directcode")
    private String directcode;
    @Column(name="dstindex")
    private Integer dstindex;
    @Column(name="dstparampsdeid")
    private String dstparampsdeid;
    @Column(name="dstpsdefid")
    private String dstpsdefid;
    @Column(name="dstpsdefname")
    private String dstpsdefname;
    @Column(name="dstpsdlparamid")
    private String dstpsdlparamid;
    @Column(name="dstpsdlparamname")
    private String dstpsdlparamname;
    @Column(name="dstsortdir")
    private String dstsortdir;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="inoutflag")
    private Integer inoutflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="params")
    private String params;
    @Column(name="paramtag")
    private String paramtag;
    @Column(name="paramtag2")
    private String paramtag2;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="paramtypetext")
    private String paramtypetext;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelnparamid")
    private String psdelnparamid;
    @Column(name="psdelnparamname")
    private String psdelnparamname;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogicnodeid")
    private String psdelogicnodeid;
    @Column(name="psdelogicnodename")
    private String psdelogicnodename;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psobjdata")
    private String psobjdata;
    @Column(name="psobjdata2")
    private String psobjdata2;
    @Column(name="psobjid")
    private String psobjid;
    @Column(name="psobjname")
    private String psobjname;
    @Column(name="psobjtype")
    private String psobjtype;
    @Column(name="psobjtypename")
    private String psobjtypename;
    @Column(name="pssysmsgtemplid")
    private String pssysmsgtemplid;
    @Column(name="pssysmsgtemplname")
    private String pssysmsgtemplname;
    @Column(name="pssyssequenceid")
    private String pssyssequenceid;
    @Column(name="pssyssequencename")
    private String pssyssequencename;
    @Column(name="pssystranslatorid")
    private String pssystranslatorid;
    @Column(name="pssystranslatorname")
    private String pssystranslatorname;
    @Column(name="srcindex")
    private Integer srcindex;
    @Column(name="srcparampsdeid")
    private String srcparampsdeid;
    @Column(name="srcpsdefid")
    private String srcpsdefid;
    @Column(name="srcpsdefname")
    private String srcpsdefname;
    @Column(name="srcpsdlparamid")
    private String srcpsdlparamid;
    @Column(name="srcpsdlparamname")
    private String srcpsdlparamname;
    @Column(name="srcsize")
    private Integer srcsize;
    @Column(name="srcvalue")
    private String srcvalue;
    @Column(name="srcvaluestddatatype")
    private Integer srcvaluestddatatype;
    @Column(name="srcvaluetype")
    private String srcvaluetype;
    @Column(name="srcvaluetypetext")
    private String srcvaluetypetext;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objDstPSDEFLock = new Integer(1);
    private PSDEField dstpsdef = null;
    private Integer objSrcPSDEFLock = new Integer(1);
    private PSDEField srcpsdef = null;
    private Integer objPSDELogicNodeLock = new Integer(1);
    private PSDELogicNode psdelogicnode = null;
    private Integer objDstPSDLParamLock = new Integer(1);
    private PSDELogicParam dstpsdlparam = null;
    private Integer objSrcPSDLParamLock = new Integer(1);
    private PSDELogicParam srcpsdlparam = null;
    private Integer objPSSysMsgTemplLock = new Integer(1);
    private PSSysMsgTempl pssysmsgtempl = null;
    private Integer objPSSysSequeueLock = new Integer(1);
    private PSSysSequence pssyssequeue = null;
    private Integer objPSSysTranslatorLock = new Integer(1);
    private PSSysTranslator pssystranslator = null;

    public void setAggMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAggMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aggmode = string;
        this.aggmodeDirtyFlag = true;
    }

    public String getAggMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAggMode();
        }
        return this.aggmode;
    }

    public boolean isAggModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAggModeDirty();
        }
        return this.aggmodeDirtyFlag;
    }

    public void resetAggMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAggMode();
            return;
        }
        this.aggmodeDirtyFlag = false;
        this.aggmode = null;
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

    public void setCustomDstParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDstParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdstparam = string;
        this.customdstparamDirtyFlag = true;
    }

    public String getCustomDstParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDstParam();
        }
        return this.customdstparam;
    }

    public boolean isCustomDstParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDstParamDirty();
        }
        return this.customdstparamDirtyFlag;
    }

    public void resetCustomDstParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDstParam();
            return;
        }
        this.customdstparamDirtyFlag = false;
        this.customdstparam = null;
    }

    public void setCustomSrcParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomSrcParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customsrcparam = string;
        this.customsrcparamDirtyFlag = true;
    }

    public String getCustomSrcParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomSrcParam();
        }
        return this.customsrcparam;
    }

    public boolean isCustomSrcParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomSrcParamDirty();
        }
        return this.customsrcparamDirtyFlag;
    }

    public void resetCustomSrcParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomSrcParam();
            return;
        }
        this.customsrcparamDirtyFlag = false;
        this.customsrcparam = null;
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

    public void setDirectCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDirectCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.directcode = string;
        this.directcodeDirtyFlag = true;
    }

    public String getDirectCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDirectCode();
        }
        return this.directcode;
    }

    public boolean isDirectCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDirectCodeDirty();
        }
        return this.directcodeDirtyFlag;
    }

    public void resetDirectCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDirectCode();
            return;
        }
        this.directcodeDirtyFlag = false;
        this.directcode = null;
    }

    public void setDstIndex(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstIndex(n);
            return;
        }
        this.dstindex = n;
        this.dstindexDirtyFlag = true;
    }

    public Integer getDstIndex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstIndex();
        }
        return this.dstindex;
    }

    public boolean isDstIndexDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstIndexDirty();
        }
        return this.dstindexDirtyFlag;
    }

    public void resetDstIndex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstIndex();
            return;
        }
        this.dstindexDirtyFlag = false;
        this.dstindex = null;
    }

    public void setDstParamPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstParamPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstparampsdeid = string;
        this.dstparampsdeidDirtyFlag = true;
    }

    public String getDstParamPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstParamPSDEId();
        }
        return this.dstparampsdeid;
    }

    public boolean isDstParamPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstParamPSDEIdDirty();
        }
        return this.dstparampsdeidDirtyFlag;
    }

    public void resetDstParamPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstParamPSDEId();
            return;
        }
        this.dstparampsdeidDirtyFlag = false;
        this.dstparampsdeid = null;
    }

    public void setDstPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefid = string;
        this.dstpsdefidDirtyFlag = true;
    }

    public String getDstPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFId();
        }
        return this.dstpsdefid;
    }

    public boolean isDstPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFIdDirty();
        }
        return this.dstpsdefidDirtyFlag;
    }

    public void resetDstPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFId();
            return;
        }
        this.dstpsdefidDirtyFlag = false;
        this.dstpsdefid = null;
    }

    public void setDstPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdefname = string;
        this.dstpsdefnameDirtyFlag = true;
    }

    public String getDstPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEFName();
        }
        return this.dstpsdefname;
    }

    public boolean isDstPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEFNameDirty();
        }
        return this.dstpsdefnameDirtyFlag;
    }

    public void resetDstPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEFName();
            return;
        }
        this.dstpsdefnameDirtyFlag = false;
        this.dstpsdefname = null;
    }

    public void setDstPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdlparamid = string;
        this.dstpsdlparamidDirtyFlag = true;
    }

    public String getDstPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParamId();
        }
        return this.dstpsdlparamid;
    }

    public boolean isDstPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDLParamIdDirty();
        }
        return this.dstpsdlparamidDirtyFlag;
    }

    public void resetDstPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDLParamId();
            return;
        }
        this.dstpsdlparamidDirtyFlag = false;
        this.dstpsdlparamid = null;
    }

    public void setDstPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdlparamname = string;
        this.dstpsdlparamnameDirtyFlag = true;
    }

    public String getDstPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParamName();
        }
        return this.dstpsdlparamname;
    }

    public boolean isDstPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDLParamNameDirty();
        }
        return this.dstpsdlparamnameDirtyFlag;
    }

    public void resetDstPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDLParamName();
            return;
        }
        this.dstpsdlparamnameDirtyFlag = false;
        this.dstpsdlparamname = null;
    }

    public void setDstSortDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstSortDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstsortdir = string;
        this.dstsortdirDirtyFlag = true;
    }

    public String getDstSortDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstSortDir();
        }
        return this.dstsortdir;
    }

    public boolean isDstSortDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstSortDirDirty();
        }
        return this.dstsortdirDirtyFlag;
    }

    public void resetDstSortDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstSortDir();
            return;
        }
        this.dstsortdirDirtyFlag = false;
        this.dstsortdir = null;
    }

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
    }

    public void setInOutFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInOutFlag(n);
            return;
        }
        this.inoutflag = n;
        this.inoutflagDirtyFlag = true;
    }

    public Integer getInOutFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInOutFlag();
        }
        return this.inoutflag;
    }

    public boolean isInOutFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInOutFlagDirty();
        }
        return this.inoutflagDirtyFlag;
    }

    public void resetInOutFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInOutFlag();
            return;
        }
        this.inoutflagDirtyFlag = false;
        this.inoutflag = null;
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

    public void setParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.params = string;
        this.paramsDirtyFlag = true;
    }

    public String getParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParams();
        }
        return this.params;
    }

    public boolean isParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamsDirty();
        }
        return this.paramsDirtyFlag;
    }

    public void resetParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParams();
            return;
        }
        this.paramsDirtyFlag = false;
        this.params = null;
    }

    public void setParamTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag = string;
        this.paramtagDirtyFlag = true;
    }

    public String getParamTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag();
        }
        return this.paramtag;
    }

    public boolean isParamTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTagDirty();
        }
        return this.paramtagDirtyFlag;
    }

    public void resetParamTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag();
            return;
        }
        this.paramtagDirtyFlag = false;
        this.paramtag = null;
    }

    public void setParamTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtag2 = string;
        this.paramtag2DirtyFlag = true;
    }

    public String getParamTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTag2();
        }
        return this.paramtag2;
    }

    public boolean isParamTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTag2Dirty();
        }
        return this.paramtag2DirtyFlag;
    }

    public void resetParamTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTag2();
            return;
        }
        this.paramtag2DirtyFlag = false;
        this.paramtag2 = null;
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

    public void setParamTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramtypetext = string;
        this.paramtypetextDirtyFlag = true;
    }

    public String getParamTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamTypeText();
        }
        return this.paramtypetext;
    }

    public boolean isParamTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamTypeTextDirty();
        }
        return this.paramtypetextDirtyFlag;
    }

    public void resetParamTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamTypeText();
            return;
        }
        this.paramtypetextDirtyFlag = false;
        this.paramtypetext = null;
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

    public void setPSDELNParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELNParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelnparamid = string;
        this.psdelnparamidDirtyFlag = true;
    }

    public String getPSDELNParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELNParamId();
        }
        return this.psdelnparamid;
    }

    public boolean isPSDELNParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELNParamIdDirty();
        }
        return this.psdelnparamidDirtyFlag;
    }

    public void resetPSDELNParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELNParamId();
            return;
        }
        this.psdelnparamidDirtyFlag = false;
        this.psdelnparamid = null;
    }

    public void setPSDELNParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELNParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelnparamname = string;
        this.psdelnparamnameDirtyFlag = true;
    }

    public String getPSDELNParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELNParamName();
        }
        return this.psdelnparamname;
    }

    public boolean isPSDELNParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELNParamNameDirty();
        }
        return this.psdelnparamnameDirtyFlag;
    }

    public void resetPSDELNParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELNParamName();
            return;
        }
        this.psdelnparamnameDirtyFlag = false;
        this.psdelnparamname = null;
    }

    public void setPSDELogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDELogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDELogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDELogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodeid = string;
        this.psdelogicnodeidDirtyFlag = true;
    }

    public String getPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeId();
        }
        return this.psdelogicnodeid;
    }

    public boolean isPSDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeIdDirty();
        }
        return this.psdelogicnodeidDirtyFlag;
    }

    public void resetPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeId();
            return;
        }
        this.psdelogicnodeidDirtyFlag = false;
        this.psdelogicnodeid = null;
    }

    public void setPSDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicnodename = string;
        this.psdelogicnodenameDirtyFlag = true;
    }

    public String getPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNodeName();
        }
        return this.psdelogicnodename;
    }

    public boolean isPSDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNodeNameDirty();
        }
        return this.psdelogicnodenameDirtyFlag;
    }

    public void resetPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicNodeName();
            return;
        }
        this.psdelogicnodenameDirtyFlag = false;
        this.psdelogicnodename = null;
    }

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
    }

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSObjData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjdata = string;
        this.psobjdataDirtyFlag = true;
    }

    public String getPSObjData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjData();
        }
        return this.psobjdata;
    }

    public boolean isPSObjDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjDataDirty();
        }
        return this.psobjdataDirtyFlag;
    }

    public void resetPSObjData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjData();
            return;
        }
        this.psobjdataDirtyFlag = false;
        this.psobjdata = null;
    }

    public void setPSObjData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjdata2 = string;
        this.psobjdata2DirtyFlag = true;
    }

    public String getPSObjData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjData2();
        }
        return this.psobjdata2;
    }

    public boolean isPSObjData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjData2Dirty();
        }
        return this.psobjdata2DirtyFlag;
    }

    public void resetPSObjData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjData2();
            return;
        }
        this.psobjdata2DirtyFlag = false;
        this.psobjdata2 = null;
    }

    public void setPSObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjid = string;
        this.psobjidDirtyFlag = true;
    }

    public String getPSObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjId();
        }
        return this.psobjid;
    }

    public boolean isPSObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjIdDirty();
        }
        return this.psobjidDirtyFlag;
    }

    public void resetPSObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjId();
            return;
        }
        this.psobjidDirtyFlag = false;
        this.psobjid = null;
    }

    public void setPSObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjname = string;
        this.psobjnameDirtyFlag = true;
    }

    public String getPSObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjName();
        }
        return this.psobjname;
    }

    public boolean isPSObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjNameDirty();
        }
        return this.psobjnameDirtyFlag;
    }

    public void resetPSObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjName();
            return;
        }
        this.psobjnameDirtyFlag = false;
        this.psobjname = null;
    }

    public void setPSObjType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtype = string;
        this.psobjtypeDirtyFlag = true;
    }

    public String getPSObjType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjType();
        }
        return this.psobjtype;
    }

    public boolean isPSObjTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeDirty();
        }
        return this.psobjtypeDirtyFlag;
    }

    public void resetPSObjType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjType();
            return;
        }
        this.psobjtypeDirtyFlag = false;
        this.psobjtype = null;
    }

    public void setPSObjTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSObjTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psobjtypename = string;
        this.psobjtypenameDirtyFlag = true;
    }

    public String getPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSObjTypeName();
        }
        return this.psobjtypename;
    }

    public boolean isPSObjTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSObjTypeNameDirty();
        }
        return this.psobjtypenameDirtyFlag;
    }

    public void resetPSObjTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSObjTypeName();
            return;
        }
        this.psobjtypenameDirtyFlag = false;
        this.psobjtypename = null;
    }

    public void setPSSysMsgTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplid = string;
        this.pssysmsgtemplidDirtyFlag = true;
    }

    public String getPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplId();
        }
        return this.pssysmsgtemplid;
    }

    public boolean isPSSysMsgTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplIdDirty();
        }
        return this.pssysmsgtemplidDirtyFlag;
    }

    public void resetPSSysMsgTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplId();
            return;
        }
        this.pssysmsgtemplidDirtyFlag = false;
        this.pssysmsgtemplid = null;
    }

    public void setPSSysMsgTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysMsgTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysmsgtemplname = string;
        this.pssysmsgtemplnameDirtyFlag = true;
    }

    public String getPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTemplName();
        }
        return this.pssysmsgtemplname;
    }

    public boolean isPSSysMsgTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysMsgTemplNameDirty();
        }
        return this.pssysmsgtemplnameDirtyFlag;
    }

    public void resetPSSysMsgTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysMsgTemplName();
            return;
        }
        this.pssysmsgtemplnameDirtyFlag = false;
        this.pssysmsgtemplname = null;
    }

    public void setPSSysSequenceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequenceid = string;
        this.pssyssequenceidDirtyFlag = true;
    }

    public String getPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceId();
        }
        return this.pssyssequenceid;
    }

    public boolean isPSSysSequenceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceIdDirty();
        }
        return this.pssyssequenceidDirtyFlag;
    }

    public void resetPSSysSequenceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceId();
            return;
        }
        this.pssyssequenceidDirtyFlag = false;
        this.pssyssequenceid = null;
    }

    public void setPSSysSequenceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSequenceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssequencename = string;
        this.pssyssequencenameDirtyFlag = true;
    }

    public String getPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequenceName();
        }
        return this.pssyssequencename;
    }

    public boolean isPSSysSequenceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSequenceNameDirty();
        }
        return this.pssyssequencenameDirtyFlag;
    }

    public void resetPSSysSequenceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSequenceName();
            return;
        }
        this.pssyssequencenameDirtyFlag = false;
        this.pssyssequencename = null;
    }

    public void setPSSysTranslatorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorid = string;
        this.pssystranslatoridDirtyFlag = true;
    }

    public String getPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorId();
        }
        return this.pssystranslatorid;
    }

    public boolean isPSSysTranslatorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorIdDirty();
        }
        return this.pssystranslatoridDirtyFlag;
    }

    public void resetPSSysTranslatorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorId();
            return;
        }
        this.pssystranslatoridDirtyFlag = false;
        this.pssystranslatorid = null;
    }

    public void setPSSysTranslatorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysTranslatorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystranslatorname = string;
        this.pssystranslatornameDirtyFlag = true;
    }

    public String getPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslatorName();
        }
        return this.pssystranslatorname;
    }

    public boolean isPSSysTranslatorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysTranslatorNameDirty();
        }
        return this.pssystranslatornameDirtyFlag;
    }

    public void resetPSSysTranslatorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysTranslatorName();
            return;
        }
        this.pssystranslatornameDirtyFlag = false;
        this.pssystranslatorname = null;
    }

    public void setSrcIndex(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcIndex(n);
            return;
        }
        this.srcindex = n;
        this.srcindexDirtyFlag = true;
    }

    public Integer getSrcIndex() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcIndex();
        }
        return this.srcindex;
    }

    public boolean isSrcIndexDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcIndexDirty();
        }
        return this.srcindexDirtyFlag;
    }

    public void resetSrcIndex() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcIndex();
            return;
        }
        this.srcindexDirtyFlag = false;
        this.srcindex = null;
    }

    public void setSrcParamPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcParamPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcparampsdeid = string;
        this.srcparampsdeidDirtyFlag = true;
    }

    public String getSrcParamPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcParamPSDEId();
        }
        return this.srcparampsdeid;
    }

    public boolean isSrcParamPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcParamPSDEIdDirty();
        }
        return this.srcparampsdeidDirtyFlag;
    }

    public void resetSrcParamPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcParamPSDEId();
            return;
        }
        this.srcparampsdeidDirtyFlag = false;
        this.srcparampsdeid = null;
    }

    public void setSrcPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdefid = string;
        this.srcpsdefidDirtyFlag = true;
    }

    public String getSrcPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEFId();
        }
        return this.srcpsdefid;
    }

    public boolean isSrcPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEFIdDirty();
        }
        return this.srcpsdefidDirtyFlag;
    }

    public void resetSrcPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEFId();
            return;
        }
        this.srcpsdefidDirtyFlag = false;
        this.srcpsdefid = null;
    }

    public void setSrcPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdefname = string;
        this.srcpsdefnameDirtyFlag = true;
    }

    public String getSrcPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEFName();
        }
        return this.srcpsdefname;
    }

    public boolean isSrcPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDEFNameDirty();
        }
        return this.srcpsdefnameDirtyFlag;
    }

    public void resetSrcPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDEFName();
            return;
        }
        this.srcpsdefnameDirtyFlag = false;
        this.srcpsdefname = null;
    }

    public void setSrcPSDLParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDLParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdlparamid = string;
        this.srcpsdlparamidDirtyFlag = true;
    }

    public String getSrcPSDLParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParamId();
        }
        return this.srcpsdlparamid;
    }

    public boolean isSrcPSDLParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDLParamIdDirty();
        }
        return this.srcpsdlparamidDirtyFlag;
    }

    public void resetSrcPSDLParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDLParamId();
            return;
        }
        this.srcpsdlparamidDirtyFlag = false;
        this.srcpsdlparamid = null;
    }

    public void setSrcPSDLParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDLParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdlparamname = string;
        this.srcpsdlparamnameDirtyFlag = true;
    }

    public String getSrcPSDLParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParamName();
        }
        return this.srcpsdlparamname;
    }

    public boolean isSrcPSDLParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDLParamNameDirty();
        }
        return this.srcpsdlparamnameDirtyFlag;
    }

    public void resetSrcPSDLParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDLParamName();
            return;
        }
        this.srcpsdlparamnameDirtyFlag = false;
        this.srcpsdlparamname = null;
    }

    public void setSrcSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcSize(n);
            return;
        }
        this.srcsize = n;
        this.srcsizeDirtyFlag = true;
    }

    public Integer getSrcSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcSize();
        }
        return this.srcsize;
    }

    public boolean isSrcSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcSizeDirty();
        }
        return this.srcsizeDirtyFlag;
    }

    public void resetSrcSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcSize();
            return;
        }
        this.srcsizeDirtyFlag = false;
        this.srcsize = null;
    }

    public void setSrcValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvalue = string;
        this.srcvalueDirtyFlag = true;
    }

    public String getSrcValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValue();
        }
        return this.srcvalue;
    }

    public boolean isSrcValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueDirty();
        }
        return this.srcvalueDirtyFlag;
    }

    public void resetSrcValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValue();
            return;
        }
        this.srcvalueDirtyFlag = false;
        this.srcvalue = null;
    }

    public void setSrcValueStdDataType(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueStdDataType(n);
            return;
        }
        this.srcvaluestddatatype = n;
        this.srcvaluestddatatypeDirtyFlag = true;
    }

    public Integer getSrcValueStdDataType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueStdDataType();
        }
        return this.srcvaluestddatatype;
    }

    public boolean isSrcValueStdDataTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueStdDataTypeDirty();
        }
        return this.srcvaluestddatatypeDirtyFlag;
    }

    public void resetSrcValueStdDataType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueStdDataType();
            return;
        }
        this.srcvaluestddatatypeDirtyFlag = false;
        this.srcvaluestddatatype = null;
    }

    public void setSrcValueType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvaluetype = string;
        this.srcvaluetypeDirtyFlag = true;
    }

    public String getSrcValueType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueType();
        }
        return this.srcvaluetype;
    }

    public boolean isSrcValueTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueTypeDirty();
        }
        return this.srcvaluetypeDirtyFlag;
    }

    public void resetSrcValueType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueType();
            return;
        }
        this.srcvaluetypeDirtyFlag = false;
        this.srcvaluetype = null;
    }

    public void setSrcValueTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcValueTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcvaluetypetext = string;
        this.srcvaluetypetextDirtyFlag = true;
    }

    public String getSrcValueTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcValueTypeText();
        }
        return this.srcvaluetypetext;
    }

    public boolean isSrcValueTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcValueTypeTextDirty();
        }
        return this.srcvaluetypetextDirtyFlag;
    }

    public void resetSrcValueTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcValueTypeText();
            return;
        }
        this.srcvaluetypetextDirtyFlag = false;
        this.srcvaluetypetext = null;
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

    protected void onReset() {
        PSDELNParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELNParamBase pSDELNParamBase) {
        pSDELNParamBase.resetAggMode();
        pSDELNParamBase.resetCreateDate();
        pSDELNParamBase.resetCreateMan();
        pSDELNParamBase.resetCustomDstParam();
        pSDELNParamBase.resetCustomSrcParam();
        pSDELNParamBase.resetDefaultValue();
        pSDELNParamBase.resetDirectCode();
        pSDELNParamBase.resetDstIndex();
        pSDELNParamBase.resetDstParamPSDEId();
        pSDELNParamBase.resetDstPSDEFId();
        pSDELNParamBase.resetDstPSDEFName();
        pSDELNParamBase.resetDstPSDLParamId();
        pSDELNParamBase.resetDstPSDLParamName();
        pSDELNParamBase.resetDstSortDir();
        pSDELNParamBase.resetDynaModelFlag();
        pSDELNParamBase.resetInOutFlag();
        pSDELNParamBase.resetMemo();
        pSDELNParamBase.resetOrderValue();
        pSDELNParamBase.resetParams();
        pSDELNParamBase.resetParamTag();
        pSDELNParamBase.resetParamTag2();
        pSDELNParamBase.resetParamType();
        pSDELNParamBase.resetParamTypeText();
        pSDELNParamBase.resetPSDEId();
        pSDELNParamBase.resetPSDELNParamId();
        pSDELNParamBase.resetPSDELNParamName();
        pSDELNParamBase.resetPSDELogicId();
        pSDELNParamBase.resetPSDELogicNodeId();
        pSDELNParamBase.resetPSDELogicNodeName();
        pSDELNParamBase.resetPSDEName();
        pSDELNParamBase.resetPSDynaInstId();
        pSDELNParamBase.resetPSObjData();
        pSDELNParamBase.resetPSObjData2();
        pSDELNParamBase.resetPSObjId();
        pSDELNParamBase.resetPSObjName();
        pSDELNParamBase.resetPSObjType();
        pSDELNParamBase.resetPSObjTypeName();
        pSDELNParamBase.resetPSSysMsgTemplId();
        pSDELNParamBase.resetPSSysMsgTemplName();
        pSDELNParamBase.resetPSSysSequenceId();
        pSDELNParamBase.resetPSSysSequenceName();
        pSDELNParamBase.resetPSSysTranslatorId();
        pSDELNParamBase.resetPSSysTranslatorName();
        pSDELNParamBase.resetSrcIndex();
        pSDELNParamBase.resetSrcParamPSDEId();
        pSDELNParamBase.resetSrcPSDEFId();
        pSDELNParamBase.resetSrcPSDEFName();
        pSDELNParamBase.resetSrcPSDLParamId();
        pSDELNParamBase.resetSrcPSDLParamName();
        pSDELNParamBase.resetSrcSize();
        pSDELNParamBase.resetSrcValue();
        pSDELNParamBase.resetSrcValueStdDataType();
        pSDELNParamBase.resetSrcValueType();
        pSDELNParamBase.resetSrcValueTypeText();
        pSDELNParamBase.resetUpdateDate();
        pSDELNParamBase.resetUpdateMan();
        pSDELNParamBase.resetUserCat();
        pSDELNParamBase.resetUserTag();
        pSDELNParamBase.resetUserTag2();
        pSDELNParamBase.resetUserTag3();
        pSDELNParamBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAggModeDirty()) {
            hashMap.put(FIELD_AGGMODE, this.getAggMode());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDstParamDirty()) {
            hashMap.put(FIELD_CUSTOMDSTPARAM, this.getCustomDstParam());
        }
        if (!bl || this.isCustomSrcParamDirty()) {
            hashMap.put(FIELD_CUSTOMSRCPARAM, this.getCustomSrcParam());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isDirectCodeDirty()) {
            hashMap.put(FIELD_DIRECTCODE, this.getDirectCode());
        }
        if (!bl || this.isDstIndexDirty()) {
            hashMap.put(FIELD_DSTINDEX, this.getDstIndex());
        }
        if (!bl || this.isDstParamPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPARAMPSDEID, this.getDstParamPSDEId());
        }
        if (!bl || this.isDstPSDEFIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFID, this.getDstPSDEFId());
        }
        if (!bl || this.isDstPSDEFNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFNAME, this.getDstPSDEFName());
        }
        if (!bl || this.isDstPSDLParamIdDirty()) {
            hashMap.put(FIELD_DSTPSDLPARAMID, this.getDstPSDLParamId());
        }
        if (!bl || this.isDstPSDLParamNameDirty()) {
            hashMap.put(FIELD_DSTPSDLPARAMNAME, this.getDstPSDLParamName());
        }
        if (!bl || this.isDstSortDirDirty()) {
            hashMap.put(FIELD_DSTSORTDIR, this.getDstSortDir());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isInOutFlagDirty()) {
            hashMap.put(FIELD_INOUTFLAG, this.getInOutFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamsDirty()) {
            hashMap.put(FIELD_PARAMS, this.getParams());
        }
        if (!bl || this.isParamTagDirty()) {
            hashMap.put(FIELD_PARAMTAG, this.getParamTag());
        }
        if (!bl || this.isParamTag2Dirty()) {
            hashMap.put(FIELD_PARAMTAG2, this.getParamTag2());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isParamTypeTextDirty()) {
            hashMap.put(FIELD_PARAMTYPETEXT, this.getParamTypeText());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDELNParamIdDirty()) {
            hashMap.put(FIELD_PSDELNPARAMID, this.getPSDELNParamId());
        }
        if (!bl || this.isPSDELNParamNameDirty()) {
            hashMap.put(FIELD_PSDELNPARAMNAME, this.getPSDELNParamName());
        }
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicNodeIdDirty()) {
            hashMap.put(FIELD_PSDELOGICNODEID, this.getPSDELogicNodeId());
        }
        if (!bl || this.isPSDELogicNodeNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNODENAME, this.getPSDELogicNodeName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSObjDataDirty()) {
            hashMap.put(FIELD_PSOBJDATA, this.getPSObjData());
        }
        if (!bl || this.isPSObjData2Dirty()) {
            hashMap.put(FIELD_PSOBJDATA2, this.getPSObjData2());
        }
        if (!bl || this.isPSObjIdDirty()) {
            hashMap.put(FIELD_PSOBJID, this.getPSObjId());
        }
        if (!bl || this.isPSObjNameDirty()) {
            hashMap.put(FIELD_PSOBJNAME, this.getPSObjName());
        }
        if (!bl || this.isPSObjTypeDirty()) {
            hashMap.put(FIELD_PSOBJTYPE, this.getPSObjType());
        }
        if (!bl || this.isPSObjTypeNameDirty()) {
            hashMap.put(FIELD_PSOBJTYPENAME, this.getPSObjTypeName());
        }
        if (!bl || this.isPSSysMsgTemplIdDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLID, this.getPSSysMsgTemplId());
        }
        if (!bl || this.isPSSysMsgTemplNameDirty()) {
            hashMap.put(FIELD_PSSYSMSGTEMPLNAME, this.getPSSysMsgTemplName());
        }
        if (!bl || this.isPSSysSequenceIdDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCEID, this.getPSSysSequenceId());
        }
        if (!bl || this.isPSSysSequenceNameDirty()) {
            hashMap.put(FIELD_PSSYSSEQUENCENAME, this.getPSSysSequenceName());
        }
        if (!bl || this.isPSSysTranslatorIdDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORID, this.getPSSysTranslatorId());
        }
        if (!bl || this.isPSSysTranslatorNameDirty()) {
            hashMap.put(FIELD_PSSYSTRANSLATORNAME, this.getPSSysTranslatorName());
        }
        if (!bl || this.isSrcIndexDirty()) {
            hashMap.put(FIELD_SRCINDEX, this.getSrcIndex());
        }
        if (!bl || this.isSrcParamPSDEIdDirty()) {
            hashMap.put(FIELD_SRCPARAMPSDEID, this.getSrcParamPSDEId());
        }
        if (!bl || this.isSrcPSDEFIdDirty()) {
            hashMap.put(FIELD_SRCPSDEFID, this.getSrcPSDEFId());
        }
        if (!bl || this.isSrcPSDEFNameDirty()) {
            hashMap.put(FIELD_SRCPSDEFNAME, this.getSrcPSDEFName());
        }
        if (!bl || this.isSrcPSDLParamIdDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMID, this.getSrcPSDLParamId());
        }
        if (!bl || this.isSrcPSDLParamNameDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMNAME, this.getSrcPSDLParamName());
        }
        if (!bl || this.isSrcSizeDirty()) {
            hashMap.put(FIELD_SRCSIZE, this.getSrcSize());
        }
        if (!bl || this.isSrcValueDirty()) {
            hashMap.put(FIELD_SRCVALUE, this.getSrcValue());
        }
        if (!bl || this.isSrcValueStdDataTypeDirty()) {
            hashMap.put(FIELD_SRCVALUESTDDATATYPE, this.getSrcValueStdDataType());
        }
        if (!bl || this.isSrcValueTypeDirty()) {
            hashMap.put(FIELD_SRCVALUETYPE, this.getSrcValueType());
        }
        if (!bl || this.isSrcValueTypeTextDirty()) {
            hashMap.put(FIELD_SRCVALUETYPETEXT, this.getSrcValueTypeText());
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
        return PSDELNParamBase.get(this, n);
    }

    private static Object get(PSDELNParamBase pSDELNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNParamBase.getAggMode();
            }
            case 1: {
                return pSDELNParamBase.getCreateDate();
            }
            case 2: {
                return pSDELNParamBase.getCreateMan();
            }
            case 3: {
                return pSDELNParamBase.getCustomDstParam();
            }
            case 4: {
                return pSDELNParamBase.getCustomSrcParam();
            }
            case 5: {
                return pSDELNParamBase.getDefaultValue();
            }
            case 6: {
                return pSDELNParamBase.getDirectCode();
            }
            case 7: {
                return pSDELNParamBase.getDstIndex();
            }
            case 8: {
                return pSDELNParamBase.getDstParamPSDEId();
            }
            case 9: {
                return pSDELNParamBase.getDstPSDEFId();
            }
            case 10: {
                return pSDELNParamBase.getDstPSDEFName();
            }
            case 11: {
                return pSDELNParamBase.getDstPSDLParamId();
            }
            case 12: {
                return pSDELNParamBase.getDstPSDLParamName();
            }
            case 13: {
                return pSDELNParamBase.getDstSortDir();
            }
            case 14: {
                return pSDELNParamBase.getDynaModelFlag();
            }
            case 15: {
                return pSDELNParamBase.getInOutFlag();
            }
            case 16: {
                return pSDELNParamBase.getMemo();
            }
            case 17: {
                return pSDELNParamBase.getOrderValue();
            }
            case 18: {
                return pSDELNParamBase.getParams();
            }
            case 19: {
                return pSDELNParamBase.getParamTag();
            }
            case 20: {
                return pSDELNParamBase.getParamTag2();
            }
            case 21: {
                return pSDELNParamBase.getParamType();
            }
            case 22: {
                return pSDELNParamBase.getParamTypeText();
            }
            case 23: {
                return pSDELNParamBase.getPSDEId();
            }
            case 24: {
                return pSDELNParamBase.getPSDELNParamId();
            }
            case 25: {
                return pSDELNParamBase.getPSDELNParamName();
            }
            case 26: {
                return pSDELNParamBase.getPSDELogicId();
            }
            case 27: {
                return pSDELNParamBase.getPSDELogicNodeId();
            }
            case 28: {
                return pSDELNParamBase.getPSDELogicNodeName();
            }
            case 29: {
                return pSDELNParamBase.getPSDEName();
            }
            case 30: {
                return pSDELNParamBase.getPSDynaInstId();
            }
            case 31: {
                return pSDELNParamBase.getPSObjData();
            }
            case 32: {
                return pSDELNParamBase.getPSObjData2();
            }
            case 33: {
                return pSDELNParamBase.getPSObjId();
            }
            case 34: {
                return pSDELNParamBase.getPSObjName();
            }
            case 35: {
                return pSDELNParamBase.getPSObjType();
            }
            case 36: {
                return pSDELNParamBase.getPSObjTypeName();
            }
            case 37: {
                return pSDELNParamBase.getPSSysMsgTemplId();
            }
            case 38: {
                return pSDELNParamBase.getPSSysMsgTemplName();
            }
            case 39: {
                return pSDELNParamBase.getPSSysSequenceId();
            }
            case 40: {
                return pSDELNParamBase.getPSSysSequenceName();
            }
            case 41: {
                return pSDELNParamBase.getPSSysTranslatorId();
            }
            case 42: {
                return pSDELNParamBase.getPSSysTranslatorName();
            }
            case 43: {
                return pSDELNParamBase.getSrcIndex();
            }
            case 44: {
                return pSDELNParamBase.getSrcParamPSDEId();
            }
            case 45: {
                return pSDELNParamBase.getSrcPSDEFId();
            }
            case 46: {
                return pSDELNParamBase.getSrcPSDEFName();
            }
            case 47: {
                return pSDELNParamBase.getSrcPSDLParamId();
            }
            case 48: {
                return pSDELNParamBase.getSrcPSDLParamName();
            }
            case 49: {
                return pSDELNParamBase.getSrcSize();
            }
            case 50: {
                return pSDELNParamBase.getSrcValue();
            }
            case 51: {
                return pSDELNParamBase.getSrcValueStdDataType();
            }
            case 52: {
                return pSDELNParamBase.getSrcValueType();
            }
            case 53: {
                return pSDELNParamBase.getSrcValueTypeText();
            }
            case 54: {
                return pSDELNParamBase.getUpdateDate();
            }
            case 55: {
                return pSDELNParamBase.getUpdateMan();
            }
            case 56: {
                return pSDELNParamBase.getUserCat();
            }
            case 57: {
                return pSDELNParamBase.getUserTag();
            }
            case 58: {
                return pSDELNParamBase.getUserTag2();
            }
            case 59: {
                return pSDELNParamBase.getUserTag3();
            }
            case 60: {
                return pSDELNParamBase.getUserTag4();
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
        PSDELNParamBase.set(this, n, object);
    }

    private static void set(PSDELNParamBase pSDELNParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELNParamBase.setAggMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELNParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELNParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELNParamBase.setCustomDstParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELNParamBase.setCustomSrcParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELNParamBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELNParamBase.setDirectCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELNParamBase.setDstIndex(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDELNParamBase.setDstParamPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELNParamBase.setDstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELNParamBase.setDstPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDELNParamBase.setDstPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELNParamBase.setDstPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDELNParamBase.setDstSortDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDELNParamBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDELNParamBase.setInOutFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDELNParamBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELNParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDELNParamBase.setParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELNParamBase.setParamTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELNParamBase.setParamTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELNParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELNParamBase.setParamTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELNParamBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELNParamBase.setPSDELNParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELNParamBase.setPSDELNParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDELNParamBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELNParamBase.setPSDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDELNParamBase.setPSDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDELNParamBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELNParamBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELNParamBase.setPSObjData(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELNParamBase.setPSObjData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELNParamBase.setPSObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDELNParamBase.setPSObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDELNParamBase.setPSObjType(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDELNParamBase.setPSObjTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDELNParamBase.setPSSysMsgTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDELNParamBase.setPSSysMsgTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDELNParamBase.setPSSysSequenceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDELNParamBase.setPSSysSequenceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDELNParamBase.setPSSysTranslatorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDELNParamBase.setPSSysTranslatorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDELNParamBase.setSrcIndex(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 44: {
                pSDELNParamBase.setSrcParamPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSDELNParamBase.setSrcPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDELNParamBase.setSrcPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDELNParamBase.setSrcPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDELNParamBase.setSrcPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDELNParamBase.setSrcSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 50: {
                pSDELNParamBase.setSrcValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDELNParamBase.setSrcValueStdDataType(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSDELNParamBase.setSrcValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSDELNParamBase.setSrcValueTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSDELNParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 55: {
                pSDELNParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSDELNParamBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 57: {
                pSDELNParamBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSDELNParamBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 59: {
                pSDELNParamBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSDELNParamBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDELNParamBase.isNull(this, n);
    }

    private static boolean isNull(PSDELNParamBase pSDELNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNParamBase.getAggMode() == null;
            }
            case 1: {
                return pSDELNParamBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELNParamBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELNParamBase.getCustomDstParam() == null;
            }
            case 4: {
                return pSDELNParamBase.getCustomSrcParam() == null;
            }
            case 5: {
                return pSDELNParamBase.getDefaultValue() == null;
            }
            case 6: {
                return pSDELNParamBase.getDirectCode() == null;
            }
            case 7: {
                return pSDELNParamBase.getDstIndex() == null;
            }
            case 8: {
                return pSDELNParamBase.getDstParamPSDEId() == null;
            }
            case 9: {
                return pSDELNParamBase.getDstPSDEFId() == null;
            }
            case 10: {
                return pSDELNParamBase.getDstPSDEFName() == null;
            }
            case 11: {
                return pSDELNParamBase.getDstPSDLParamId() == null;
            }
            case 12: {
                return pSDELNParamBase.getDstPSDLParamName() == null;
            }
            case 13: {
                return pSDELNParamBase.getDstSortDir() == null;
            }
            case 14: {
                return pSDELNParamBase.getDynaModelFlag() == null;
            }
            case 15: {
                return pSDELNParamBase.getInOutFlag() == null;
            }
            case 16: {
                return pSDELNParamBase.getMemo() == null;
            }
            case 17: {
                return pSDELNParamBase.getOrderValue() == null;
            }
            case 18: {
                return pSDELNParamBase.getParams() == null;
            }
            case 19: {
                return pSDELNParamBase.getParamTag() == null;
            }
            case 20: {
                return pSDELNParamBase.getParamTag2() == null;
            }
            case 21: {
                return pSDELNParamBase.getParamType() == null;
            }
            case 22: {
                return pSDELNParamBase.getParamTypeText() == null;
            }
            case 23: {
                return pSDELNParamBase.getPSDEId() == null;
            }
            case 24: {
                return pSDELNParamBase.getPSDELNParamId() == null;
            }
            case 25: {
                return pSDELNParamBase.getPSDELNParamName() == null;
            }
            case 26: {
                return pSDELNParamBase.getPSDELogicId() == null;
            }
            case 27: {
                return pSDELNParamBase.getPSDELogicNodeId() == null;
            }
            case 28: {
                return pSDELNParamBase.getPSDELogicNodeName() == null;
            }
            case 29: {
                return pSDELNParamBase.getPSDEName() == null;
            }
            case 30: {
                return pSDELNParamBase.getPSDynaInstId() == null;
            }
            case 31: {
                return pSDELNParamBase.getPSObjData() == null;
            }
            case 32: {
                return pSDELNParamBase.getPSObjData2() == null;
            }
            case 33: {
                return pSDELNParamBase.getPSObjId() == null;
            }
            case 34: {
                return pSDELNParamBase.getPSObjName() == null;
            }
            case 35: {
                return pSDELNParamBase.getPSObjType() == null;
            }
            case 36: {
                return pSDELNParamBase.getPSObjTypeName() == null;
            }
            case 37: {
                return pSDELNParamBase.getPSSysMsgTemplId() == null;
            }
            case 38: {
                return pSDELNParamBase.getPSSysMsgTemplName() == null;
            }
            case 39: {
                return pSDELNParamBase.getPSSysSequenceId() == null;
            }
            case 40: {
                return pSDELNParamBase.getPSSysSequenceName() == null;
            }
            case 41: {
                return pSDELNParamBase.getPSSysTranslatorId() == null;
            }
            case 42: {
                return pSDELNParamBase.getPSSysTranslatorName() == null;
            }
            case 43: {
                return pSDELNParamBase.getSrcIndex() == null;
            }
            case 44: {
                return pSDELNParamBase.getSrcParamPSDEId() == null;
            }
            case 45: {
                return pSDELNParamBase.getSrcPSDEFId() == null;
            }
            case 46: {
                return pSDELNParamBase.getSrcPSDEFName() == null;
            }
            case 47: {
                return pSDELNParamBase.getSrcPSDLParamId() == null;
            }
            case 48: {
                return pSDELNParamBase.getSrcPSDLParamName() == null;
            }
            case 49: {
                return pSDELNParamBase.getSrcSize() == null;
            }
            case 50: {
                return pSDELNParamBase.getSrcValue() == null;
            }
            case 51: {
                return pSDELNParamBase.getSrcValueStdDataType() == null;
            }
            case 52: {
                return pSDELNParamBase.getSrcValueType() == null;
            }
            case 53: {
                return pSDELNParamBase.getSrcValueTypeText() == null;
            }
            case 54: {
                return pSDELNParamBase.getUpdateDate() == null;
            }
            case 55: {
                return pSDELNParamBase.getUpdateMan() == null;
            }
            case 56: {
                return pSDELNParamBase.getUserCat() == null;
            }
            case 57: {
                return pSDELNParamBase.getUserTag() == null;
            }
            case 58: {
                return pSDELNParamBase.getUserTag2() == null;
            }
            case 59: {
                return pSDELNParamBase.getUserTag3() == null;
            }
            case 60: {
                return pSDELNParamBase.getUserTag4() == null;
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
        return PSDELNParamBase.contains(this, n);
    }

    private static boolean contains(PSDELNParamBase pSDELNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELNParamBase.isAggModeDirty();
            }
            case 1: {
                return pSDELNParamBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELNParamBase.isCreateManDirty();
            }
            case 3: {
                return pSDELNParamBase.isCustomDstParamDirty();
            }
            case 4: {
                return pSDELNParamBase.isCustomSrcParamDirty();
            }
            case 5: {
                return pSDELNParamBase.isDefaultValueDirty();
            }
            case 6: {
                return pSDELNParamBase.isDirectCodeDirty();
            }
            case 7: {
                return pSDELNParamBase.isDstIndexDirty();
            }
            case 8: {
                return pSDELNParamBase.isDstParamPSDEIdDirty();
            }
            case 9: {
                return pSDELNParamBase.isDstPSDEFIdDirty();
            }
            case 10: {
                return pSDELNParamBase.isDstPSDEFNameDirty();
            }
            case 11: {
                return pSDELNParamBase.isDstPSDLParamIdDirty();
            }
            case 12: {
                return pSDELNParamBase.isDstPSDLParamNameDirty();
            }
            case 13: {
                return pSDELNParamBase.isDstSortDirDirty();
            }
            case 14: {
                return pSDELNParamBase.isDynaModelFlagDirty();
            }
            case 15: {
                return pSDELNParamBase.isInOutFlagDirty();
            }
            case 16: {
                return pSDELNParamBase.isMemoDirty();
            }
            case 17: {
                return pSDELNParamBase.isOrderValueDirty();
            }
            case 18: {
                return pSDELNParamBase.isParamsDirty();
            }
            case 19: {
                return pSDELNParamBase.isParamTagDirty();
            }
            case 20: {
                return pSDELNParamBase.isParamTag2Dirty();
            }
            case 21: {
                return pSDELNParamBase.isParamTypeDirty();
            }
            case 22: {
                return pSDELNParamBase.isParamTypeTextDirty();
            }
            case 23: {
                return pSDELNParamBase.isPSDEIdDirty();
            }
            case 24: {
                return pSDELNParamBase.isPSDELNParamIdDirty();
            }
            case 25: {
                return pSDELNParamBase.isPSDELNParamNameDirty();
            }
            case 26: {
                return pSDELNParamBase.isPSDELogicIdDirty();
            }
            case 27: {
                return pSDELNParamBase.isPSDELogicNodeIdDirty();
            }
            case 28: {
                return pSDELNParamBase.isPSDELogicNodeNameDirty();
            }
            case 29: {
                return pSDELNParamBase.isPSDENameDirty();
            }
            case 30: {
                return pSDELNParamBase.isPSDynaInstIdDirty();
            }
            case 31: {
                return pSDELNParamBase.isPSObjDataDirty();
            }
            case 32: {
                return pSDELNParamBase.isPSObjData2Dirty();
            }
            case 33: {
                return pSDELNParamBase.isPSObjIdDirty();
            }
            case 34: {
                return pSDELNParamBase.isPSObjNameDirty();
            }
            case 35: {
                return pSDELNParamBase.isPSObjTypeDirty();
            }
            case 36: {
                return pSDELNParamBase.isPSObjTypeNameDirty();
            }
            case 37: {
                return pSDELNParamBase.isPSSysMsgTemplIdDirty();
            }
            case 38: {
                return pSDELNParamBase.isPSSysMsgTemplNameDirty();
            }
            case 39: {
                return pSDELNParamBase.isPSSysSequenceIdDirty();
            }
            case 40: {
                return pSDELNParamBase.isPSSysSequenceNameDirty();
            }
            case 41: {
                return pSDELNParamBase.isPSSysTranslatorIdDirty();
            }
            case 42: {
                return pSDELNParamBase.isPSSysTranslatorNameDirty();
            }
            case 43: {
                return pSDELNParamBase.isSrcIndexDirty();
            }
            case 44: {
                return pSDELNParamBase.isSrcParamPSDEIdDirty();
            }
            case 45: {
                return pSDELNParamBase.isSrcPSDEFIdDirty();
            }
            case 46: {
                return pSDELNParamBase.isSrcPSDEFNameDirty();
            }
            case 47: {
                return pSDELNParamBase.isSrcPSDLParamIdDirty();
            }
            case 48: {
                return pSDELNParamBase.isSrcPSDLParamNameDirty();
            }
            case 49: {
                return pSDELNParamBase.isSrcSizeDirty();
            }
            case 50: {
                return pSDELNParamBase.isSrcValueDirty();
            }
            case 51: {
                return pSDELNParamBase.isSrcValueStdDataTypeDirty();
            }
            case 52: {
                return pSDELNParamBase.isSrcValueTypeDirty();
            }
            case 53: {
                return pSDELNParamBase.isSrcValueTypeTextDirty();
            }
            case 54: {
                return pSDELNParamBase.isUpdateDateDirty();
            }
            case 55: {
                return pSDELNParamBase.isUpdateManDirty();
            }
            case 56: {
                return pSDELNParamBase.isUserCatDirty();
            }
            case 57: {
                return pSDELNParamBase.isUserTagDirty();
            }
            case 58: {
                return pSDELNParamBase.isUserTag2Dirty();
            }
            case 59: {
                return pSDELNParamBase.isUserTag3Dirty();
            }
            case 60: {
                return pSDELNParamBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELNParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELNParamBase pSDELNParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELNParamBase.getAggMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aggmode", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getAggMode()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getCustomDstParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdstparam", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getCustomDstParam()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getCustomSrcParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customsrcparam", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getCustomSrcParam()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDirectCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"directcode", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDirectCode()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstIndex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstindex", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstIndex()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstParamPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstparampsdeid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstParamPSDEId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstPSDEFId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstPSDEFName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDstSortDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstsortdir", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDstSortDir()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getInOutFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inoutflag", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getInOutFlag()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"params", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getParams()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getParamTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getParamTag()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getParamTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtag2", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getParamTag2()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getParamTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtypetext", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getParamTypeText()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDELNParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelnparamid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDELNParamId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDELNParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelnparamname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDELNParamName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodeid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicnodename", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjdata", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjData()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjdata2", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjData2()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtype", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjType()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSObjTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psobjtypename", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSObjTypeName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysMsgTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysMsgTemplId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysMsgTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysmsgtemplname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysMsgTemplName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysSequenceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequenceid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysSequenceId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysSequenceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssequencename", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysSequenceName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysTranslatorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysTranslatorId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getPSSysTranslatorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystranslatorname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getPSSysTranslatorName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcIndex() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcindex", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcIndex()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcParamPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcparampsdeid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcParamPSDEId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdefid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcPSDEFId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdefname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcPSDEFName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamid", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamname", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcsize", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcSize()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvalue", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcValue()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcValueStdDataType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluestddatatype", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcValueStdDataType()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluetype", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcValueType()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getSrcValueTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluetypetext", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getSrcValueTypeText()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELNParamBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELNParamBase.getJSONValue((Object)pSDELNParamBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELNParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELNParamBase pSDELNParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELNParamBase.getAggMode() != null) {
            object = pSDELNParamBase.getAggMode();
            xmlNode.setAttribute(FIELD_AGGMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getCreateDate() != null) {
            object = pSDELNParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELNParamBase.getCreateMan() != null) {
            object = pSDELNParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getCustomDstParam() != null) {
            object = pSDELNParamBase.getCustomDstParam();
            xmlNode.setAttribute(FIELD_CUSTOMDSTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getCustomSrcParam() != null) {
            object = pSDELNParamBase.getCustomSrcParam();
            xmlNode.setAttribute(FIELD_CUSTOMSRCPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDefaultValue() != null) {
            object = pSDELNParamBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDirectCode() != null) {
            object = pSDELNParamBase.getDirectCode();
            xmlNode.setAttribute(FIELD_DIRECTCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstIndex() != null) {
            object = pSDELNParamBase.getDstIndex();
            xmlNode.setAttribute(FIELD_DSTINDEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getDstParamPSDEId() != null) {
            object = pSDELNParamBase.getDstParamPSDEId();
            xmlNode.setAttribute(FIELD_DSTPARAMPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstPSDEFId() != null) {
            object = pSDELNParamBase.getDstPSDEFId();
            xmlNode.setAttribute(FIELD_DSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstPSDEFName() != null) {
            object = pSDELNParamBase.getDstPSDEFName();
            xmlNode.setAttribute(FIELD_DSTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstPSDLParamId() != null) {
            object = pSDELNParamBase.getDstPSDLParamId();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstPSDLParamName() != null) {
            object = pSDELNParamBase.getDstPSDLParamName();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDstSortDir() != null) {
            object = pSDELNParamBase.getDstSortDir();
            xmlNode.setAttribute(FIELD_DSTSORTDIR, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getDynaModelFlag() != null) {
            object = pSDELNParamBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getInOutFlag() != null) {
            object = pSDELNParamBase.getInOutFlag();
            xmlNode.setAttribute(FIELD_INOUTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getMemo() != null) {
            object = pSDELNParamBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getOrderValue() != null) {
            object = pSDELNParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getParams() != null) {
            object = pSDELNParamBase.getParams();
            xmlNode.setAttribute(FIELD_PARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getParamTag() != null) {
            object = pSDELNParamBase.getParamTag();
            xmlNode.setAttribute(FIELD_PARAMTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getParamTag2() != null) {
            object = pSDELNParamBase.getParamTag2();
            xmlNode.setAttribute(FIELD_PARAMTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getParamType() != null) {
            object = pSDELNParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getParamTypeText() != null) {
            object = pSDELNParamBase.getParamTypeText();
            xmlNode.setAttribute(FIELD_PARAMTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDEId() != null) {
            object = pSDELNParamBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDELNParamId() != null) {
            object = pSDELNParamBase.getPSDELNParamId();
            xmlNode.setAttribute(FIELD_PSDELNPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDELNParamName() != null) {
            object = pSDELNParamBase.getPSDELNParamName();
            xmlNode.setAttribute(FIELD_PSDELNPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDELogicId() != null) {
            object = pSDELNParamBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDELogicNodeId() != null) {
            object = pSDELNParamBase.getPSDELogicNodeId();
            xmlNode.setAttribute(FIELD_PSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDELogicNodeName() != null) {
            object = pSDELNParamBase.getPSDELogicNodeName();
            xmlNode.setAttribute(FIELD_PSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDEName() != null) {
            object = pSDELNParamBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSDynaInstId() != null) {
            object = pSDELNParamBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjData() != null) {
            object = pSDELNParamBase.getPSObjData();
            xmlNode.setAttribute(FIELD_PSOBJDATA, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjData2() != null) {
            object = pSDELNParamBase.getPSObjData2();
            xmlNode.setAttribute(FIELD_PSOBJDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjId() != null) {
            object = pSDELNParamBase.getPSObjId();
            xmlNode.setAttribute(FIELD_PSOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjName() != null) {
            object = pSDELNParamBase.getPSObjName();
            xmlNode.setAttribute(FIELD_PSOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjType() != null) {
            object = pSDELNParamBase.getPSObjType();
            xmlNode.setAttribute(FIELD_PSOBJTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSObjTypeName() != null) {
            object = pSDELNParamBase.getPSObjTypeName();
            xmlNode.setAttribute(FIELD_PSOBJTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysMsgTemplId() != null) {
            object = pSDELNParamBase.getPSSysMsgTemplId();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysMsgTemplName() != null) {
            object = pSDELNParamBase.getPSSysMsgTemplName();
            xmlNode.setAttribute(FIELD_PSSYSMSGTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysSequenceId() != null) {
            object = pSDELNParamBase.getPSSysSequenceId();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysSequenceName() != null) {
            object = pSDELNParamBase.getPSSysSequenceName();
            xmlNode.setAttribute(FIELD_PSSYSSEQUENCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysTranslatorId() != null) {
            object = pSDELNParamBase.getPSSysTranslatorId();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getPSSysTranslatorName() != null) {
            object = pSDELNParamBase.getPSSysTranslatorName();
            xmlNode.setAttribute(FIELD_PSSYSTRANSLATORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcIndex() != null) {
            object = pSDELNParamBase.getSrcIndex();
            xmlNode.setAttribute(FIELD_SRCINDEX, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getSrcParamPSDEId() != null) {
            object = pSDELNParamBase.getSrcParamPSDEId();
            xmlNode.setAttribute(FIELD_SRCPARAMPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcPSDEFId() != null) {
            object = pSDELNParamBase.getSrcPSDEFId();
            xmlNode.setAttribute(FIELD_SRCPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcPSDEFName() != null) {
            object = pSDELNParamBase.getSrcPSDEFName();
            xmlNode.setAttribute(FIELD_SRCPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcPSDLParamId() != null) {
            object = pSDELNParamBase.getSrcPSDLParamId();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcPSDLParamName() != null) {
            object = pSDELNParamBase.getSrcPSDLParamName();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcSize() != null) {
            object = pSDELNParamBase.getSrcSize();
            xmlNode.setAttribute(FIELD_SRCSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getSrcValue() != null) {
            object = pSDELNParamBase.getSrcValue();
            xmlNode.setAttribute(FIELD_SRCVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcValueStdDataType() != null) {
            object = pSDELNParamBase.getSrcValueStdDataType();
            xmlNode.setAttribute(FIELD_SRCVALUESTDDATATYPE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELNParamBase.getSrcValueType() != null) {
            object = pSDELNParamBase.getSrcValueType();
            xmlNode.setAttribute(FIELD_SRCVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getSrcValueTypeText() != null) {
            object = pSDELNParamBase.getSrcValueTypeText();
            xmlNode.setAttribute(FIELD_SRCVALUETYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUpdateDate() != null) {
            object = pSDELNParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELNParamBase.getUpdateMan() != null) {
            object = pSDELNParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUserCat() != null) {
            object = pSDELNParamBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUserTag() != null) {
            object = pSDELNParamBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUserTag2() != null) {
            object = pSDELNParamBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUserTag3() != null) {
            object = pSDELNParamBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELNParamBase.getUserTag4() != null) {
            object = pSDELNParamBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELNParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELNParamBase pSDELNParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELNParamBase.isAggModeDirty() && (bl || pSDELNParamBase.getAggMode() != null)) {
            iDataObject.set(FIELD_AGGMODE, (Object)pSDELNParamBase.getAggMode());
        }
        if (pSDELNParamBase.isCreateDateDirty() && (bl || pSDELNParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELNParamBase.getCreateDate());
        }
        if (pSDELNParamBase.isCreateManDirty() && (bl || pSDELNParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELNParamBase.getCreateMan());
        }
        if (pSDELNParamBase.isCustomDstParamDirty() && (bl || pSDELNParamBase.getCustomDstParam() != null)) {
            iDataObject.set(FIELD_CUSTOMDSTPARAM, (Object)pSDELNParamBase.getCustomDstParam());
        }
        if (pSDELNParamBase.isCustomSrcParamDirty() && (bl || pSDELNParamBase.getCustomSrcParam() != null)) {
            iDataObject.set(FIELD_CUSTOMSRCPARAM, (Object)pSDELNParamBase.getCustomSrcParam());
        }
        if (pSDELNParamBase.isDefaultValueDirty() && (bl || pSDELNParamBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDELNParamBase.getDefaultValue());
        }
        if (pSDELNParamBase.isDirectCodeDirty() && (bl || pSDELNParamBase.getDirectCode() != null)) {
            iDataObject.set(FIELD_DIRECTCODE, (Object)pSDELNParamBase.getDirectCode());
        }
        if (pSDELNParamBase.isDstIndexDirty() && (bl || pSDELNParamBase.getDstIndex() != null)) {
            iDataObject.set(FIELD_DSTINDEX, (Object)pSDELNParamBase.getDstIndex());
        }
        if (pSDELNParamBase.isDstParamPSDEIdDirty() && (bl || pSDELNParamBase.getDstParamPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPARAMPSDEID, (Object)pSDELNParamBase.getDstParamPSDEId());
        }
        if (pSDELNParamBase.isDstPSDEFIdDirty() && (bl || pSDELNParamBase.getDstPSDEFId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFID, (Object)pSDELNParamBase.getDstPSDEFId());
        }
        if (pSDELNParamBase.isDstPSDEFNameDirty() && (bl || pSDELNParamBase.getDstPSDEFName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFNAME, (Object)pSDELNParamBase.getDstPSDEFName());
        }
        if (pSDELNParamBase.isDstPSDLParamIdDirty() && (bl || pSDELNParamBase.getDstPSDLParamId() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMID, (Object)pSDELNParamBase.getDstPSDLParamId());
        }
        if (pSDELNParamBase.isDstPSDLParamNameDirty() && (bl || pSDELNParamBase.getDstPSDLParamName() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMNAME, (Object)pSDELNParamBase.getDstPSDLParamName());
        }
        if (pSDELNParamBase.isDstSortDirDirty() && (bl || pSDELNParamBase.getDstSortDir() != null)) {
            iDataObject.set(FIELD_DSTSORTDIR, (Object)pSDELNParamBase.getDstSortDir());
        }
        if (pSDELNParamBase.isDynaModelFlagDirty() && (bl || pSDELNParamBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELNParamBase.getDynaModelFlag());
        }
        if (pSDELNParamBase.isInOutFlagDirty() && (bl || pSDELNParamBase.getInOutFlag() != null)) {
            iDataObject.set(FIELD_INOUTFLAG, (Object)pSDELNParamBase.getInOutFlag());
        }
        if (pSDELNParamBase.isMemoDirty() && (bl || pSDELNParamBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELNParamBase.getMemo());
        }
        if (pSDELNParamBase.isOrderValueDirty() && (bl || pSDELNParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELNParamBase.getOrderValue());
        }
        if (pSDELNParamBase.isParamsDirty() && (bl || pSDELNParamBase.getParams() != null)) {
            iDataObject.set(FIELD_PARAMS, (Object)pSDELNParamBase.getParams());
        }
        if (pSDELNParamBase.isParamTagDirty() && (bl || pSDELNParamBase.getParamTag() != null)) {
            iDataObject.set(FIELD_PARAMTAG, (Object)pSDELNParamBase.getParamTag());
        }
        if (pSDELNParamBase.isParamTag2Dirty() && (bl || pSDELNParamBase.getParamTag2() != null)) {
            iDataObject.set(FIELD_PARAMTAG2, (Object)pSDELNParamBase.getParamTag2());
        }
        if (pSDELNParamBase.isParamTypeDirty() && (bl || pSDELNParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSDELNParamBase.getParamType());
        }
        if (pSDELNParamBase.isParamTypeTextDirty() && (bl || pSDELNParamBase.getParamTypeText() != null)) {
            iDataObject.set(FIELD_PARAMTYPETEXT, (Object)pSDELNParamBase.getParamTypeText());
        }
        if (pSDELNParamBase.isPSDEIdDirty() && (bl || pSDELNParamBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDELNParamBase.getPSDEId());
        }
        if (pSDELNParamBase.isPSDELNParamIdDirty() && (bl || pSDELNParamBase.getPSDELNParamId() != null)) {
            iDataObject.set(FIELD_PSDELNPARAMID, (Object)pSDELNParamBase.getPSDELNParamId());
        }
        if (pSDELNParamBase.isPSDELNParamNameDirty() && (bl || pSDELNParamBase.getPSDELNParamName() != null)) {
            iDataObject.set(FIELD_PSDELNPARAMNAME, (Object)pSDELNParamBase.getPSDELNParamName());
        }
        if (pSDELNParamBase.isPSDELogicIdDirty() && (bl || pSDELNParamBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELNParamBase.getPSDELogicId());
        }
        if (pSDELNParamBase.isPSDELogicNodeIdDirty() && (bl || pSDELNParamBase.getPSDELogicNodeId() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODEID, (Object)pSDELNParamBase.getPSDELogicNodeId());
        }
        if (pSDELNParamBase.isPSDELogicNodeNameDirty() && (bl || pSDELNParamBase.getPSDELogicNodeName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNODENAME, (Object)pSDELNParamBase.getPSDELogicNodeName());
        }
        if (pSDELNParamBase.isPSDENameDirty() && (bl || pSDELNParamBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDELNParamBase.getPSDEName());
        }
        if (pSDELNParamBase.isPSDynaInstIdDirty() && (bl || pSDELNParamBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELNParamBase.getPSDynaInstId());
        }
        if (pSDELNParamBase.isPSObjDataDirty() && (bl || pSDELNParamBase.getPSObjData() != null)) {
            iDataObject.set(FIELD_PSOBJDATA, (Object)pSDELNParamBase.getPSObjData());
        }
        if (pSDELNParamBase.isPSObjData2Dirty() && (bl || pSDELNParamBase.getPSObjData2() != null)) {
            iDataObject.set(FIELD_PSOBJDATA2, (Object)pSDELNParamBase.getPSObjData2());
        }
        if (pSDELNParamBase.isPSObjIdDirty() && (bl || pSDELNParamBase.getPSObjId() != null)) {
            iDataObject.set(FIELD_PSOBJID, (Object)pSDELNParamBase.getPSObjId());
        }
        if (pSDELNParamBase.isPSObjNameDirty() && (bl || pSDELNParamBase.getPSObjName() != null)) {
            iDataObject.set(FIELD_PSOBJNAME, (Object)pSDELNParamBase.getPSObjName());
        }
        if (pSDELNParamBase.isPSObjTypeDirty() && (bl || pSDELNParamBase.getPSObjType() != null)) {
            iDataObject.set(FIELD_PSOBJTYPE, (Object)pSDELNParamBase.getPSObjType());
        }
        if (pSDELNParamBase.isPSObjTypeNameDirty() && (bl || pSDELNParamBase.getPSObjTypeName() != null)) {
            iDataObject.set(FIELD_PSOBJTYPENAME, (Object)pSDELNParamBase.getPSObjTypeName());
        }
        if (pSDELNParamBase.isPSSysMsgTemplIdDirty() && (bl || pSDELNParamBase.getPSSysMsgTemplId() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLID, (Object)pSDELNParamBase.getPSSysMsgTemplId());
        }
        if (pSDELNParamBase.isPSSysMsgTemplNameDirty() && (bl || pSDELNParamBase.getPSSysMsgTemplName() != null)) {
            iDataObject.set(FIELD_PSSYSMSGTEMPLNAME, (Object)pSDELNParamBase.getPSSysMsgTemplName());
        }
        if (pSDELNParamBase.isPSSysSequenceIdDirty() && (bl || pSDELNParamBase.getPSSysSequenceId() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCEID, (Object)pSDELNParamBase.getPSSysSequenceId());
        }
        if (pSDELNParamBase.isPSSysSequenceNameDirty() && (bl || pSDELNParamBase.getPSSysSequenceName() != null)) {
            iDataObject.set(FIELD_PSSYSSEQUENCENAME, (Object)pSDELNParamBase.getPSSysSequenceName());
        }
        if (pSDELNParamBase.isPSSysTranslatorIdDirty() && (bl || pSDELNParamBase.getPSSysTranslatorId() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORID, (Object)pSDELNParamBase.getPSSysTranslatorId());
        }
        if (pSDELNParamBase.isPSSysTranslatorNameDirty() && (bl || pSDELNParamBase.getPSSysTranslatorName() != null)) {
            iDataObject.set(FIELD_PSSYSTRANSLATORNAME, (Object)pSDELNParamBase.getPSSysTranslatorName());
        }
        if (pSDELNParamBase.isSrcIndexDirty() && (bl || pSDELNParamBase.getSrcIndex() != null)) {
            iDataObject.set(FIELD_SRCINDEX, (Object)pSDELNParamBase.getSrcIndex());
        }
        if (pSDELNParamBase.isSrcParamPSDEIdDirty() && (bl || pSDELNParamBase.getSrcParamPSDEId() != null)) {
            iDataObject.set(FIELD_SRCPARAMPSDEID, (Object)pSDELNParamBase.getSrcParamPSDEId());
        }
        if (pSDELNParamBase.isSrcPSDEFIdDirty() && (bl || pSDELNParamBase.getSrcPSDEFId() != null)) {
            iDataObject.set(FIELD_SRCPSDEFID, (Object)pSDELNParamBase.getSrcPSDEFId());
        }
        if (pSDELNParamBase.isSrcPSDEFNameDirty() && (bl || pSDELNParamBase.getSrcPSDEFName() != null)) {
            iDataObject.set(FIELD_SRCPSDEFNAME, (Object)pSDELNParamBase.getSrcPSDEFName());
        }
        if (pSDELNParamBase.isSrcPSDLParamIdDirty() && (bl || pSDELNParamBase.getSrcPSDLParamId() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMID, (Object)pSDELNParamBase.getSrcPSDLParamId());
        }
        if (pSDELNParamBase.isSrcPSDLParamNameDirty() && (bl || pSDELNParamBase.getSrcPSDLParamName() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMNAME, (Object)pSDELNParamBase.getSrcPSDLParamName());
        }
        if (pSDELNParamBase.isSrcSizeDirty() && (bl || pSDELNParamBase.getSrcSize() != null)) {
            iDataObject.set(FIELD_SRCSIZE, (Object)pSDELNParamBase.getSrcSize());
        }
        if (pSDELNParamBase.isSrcValueDirty() && (bl || pSDELNParamBase.getSrcValue() != null)) {
            iDataObject.set(FIELD_SRCVALUE, (Object)pSDELNParamBase.getSrcValue());
        }
        if (pSDELNParamBase.isSrcValueStdDataTypeDirty() && (bl || pSDELNParamBase.getSrcValueStdDataType() != null)) {
            iDataObject.set(FIELD_SRCVALUESTDDATATYPE, (Object)pSDELNParamBase.getSrcValueStdDataType());
        }
        if (pSDELNParamBase.isSrcValueTypeDirty() && (bl || pSDELNParamBase.getSrcValueType() != null)) {
            iDataObject.set(FIELD_SRCVALUETYPE, (Object)pSDELNParamBase.getSrcValueType());
        }
        if (pSDELNParamBase.isSrcValueTypeTextDirty() && (bl || pSDELNParamBase.getSrcValueTypeText() != null)) {
            iDataObject.set(FIELD_SRCVALUETYPETEXT, (Object)pSDELNParamBase.getSrcValueTypeText());
        }
        if (pSDELNParamBase.isUpdateDateDirty() && (bl || pSDELNParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELNParamBase.getUpdateDate());
        }
        if (pSDELNParamBase.isUpdateManDirty() && (bl || pSDELNParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELNParamBase.getUpdateMan());
        }
        if (pSDELNParamBase.isUserCatDirty() && (bl || pSDELNParamBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELNParamBase.getUserCat());
        }
        if (pSDELNParamBase.isUserTagDirty() && (bl || pSDELNParamBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELNParamBase.getUserTag());
        }
        if (pSDELNParamBase.isUserTag2Dirty() && (bl || pSDELNParamBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELNParamBase.getUserTag2());
        }
        if (pSDELNParamBase.isUserTag3Dirty() && (bl || pSDELNParamBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELNParamBase.getUserTag3());
        }
        if (pSDELNParamBase.isUserTag4Dirty() && (bl || pSDELNParamBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELNParamBase.getUserTag4());
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
        return PSDELNParamBase.remove(this, n);
    }

    private static boolean remove(PSDELNParamBase pSDELNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELNParamBase.resetAggMode();
                return true;
            }
            case 1: {
                pSDELNParamBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELNParamBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELNParamBase.resetCustomDstParam();
                return true;
            }
            case 4: {
                pSDELNParamBase.resetCustomSrcParam();
                return true;
            }
            case 5: {
                pSDELNParamBase.resetDefaultValue();
                return true;
            }
            case 6: {
                pSDELNParamBase.resetDirectCode();
                return true;
            }
            case 7: {
                pSDELNParamBase.resetDstIndex();
                return true;
            }
            case 8: {
                pSDELNParamBase.resetDstParamPSDEId();
                return true;
            }
            case 9: {
                pSDELNParamBase.resetDstPSDEFId();
                return true;
            }
            case 10: {
                pSDELNParamBase.resetDstPSDEFName();
                return true;
            }
            case 11: {
                pSDELNParamBase.resetDstPSDLParamId();
                return true;
            }
            case 12: {
                pSDELNParamBase.resetDstPSDLParamName();
                return true;
            }
            case 13: {
                pSDELNParamBase.resetDstSortDir();
                return true;
            }
            case 14: {
                pSDELNParamBase.resetDynaModelFlag();
                return true;
            }
            case 15: {
                pSDELNParamBase.resetInOutFlag();
                return true;
            }
            case 16: {
                pSDELNParamBase.resetMemo();
                return true;
            }
            case 17: {
                pSDELNParamBase.resetOrderValue();
                return true;
            }
            case 18: {
                pSDELNParamBase.resetParams();
                return true;
            }
            case 19: {
                pSDELNParamBase.resetParamTag();
                return true;
            }
            case 20: {
                pSDELNParamBase.resetParamTag2();
                return true;
            }
            case 21: {
                pSDELNParamBase.resetParamType();
                return true;
            }
            case 22: {
                pSDELNParamBase.resetParamTypeText();
                return true;
            }
            case 23: {
                pSDELNParamBase.resetPSDEId();
                return true;
            }
            case 24: {
                pSDELNParamBase.resetPSDELNParamId();
                return true;
            }
            case 25: {
                pSDELNParamBase.resetPSDELNParamName();
                return true;
            }
            case 26: {
                pSDELNParamBase.resetPSDELogicId();
                return true;
            }
            case 27: {
                pSDELNParamBase.resetPSDELogicNodeId();
                return true;
            }
            case 28: {
                pSDELNParamBase.resetPSDELogicNodeName();
                return true;
            }
            case 29: {
                pSDELNParamBase.resetPSDEName();
                return true;
            }
            case 30: {
                pSDELNParamBase.resetPSDynaInstId();
                return true;
            }
            case 31: {
                pSDELNParamBase.resetPSObjData();
                return true;
            }
            case 32: {
                pSDELNParamBase.resetPSObjData2();
                return true;
            }
            case 33: {
                pSDELNParamBase.resetPSObjId();
                return true;
            }
            case 34: {
                pSDELNParamBase.resetPSObjName();
                return true;
            }
            case 35: {
                pSDELNParamBase.resetPSObjType();
                return true;
            }
            case 36: {
                pSDELNParamBase.resetPSObjTypeName();
                return true;
            }
            case 37: {
                pSDELNParamBase.resetPSSysMsgTemplId();
                return true;
            }
            case 38: {
                pSDELNParamBase.resetPSSysMsgTemplName();
                return true;
            }
            case 39: {
                pSDELNParamBase.resetPSSysSequenceId();
                return true;
            }
            case 40: {
                pSDELNParamBase.resetPSSysSequenceName();
                return true;
            }
            case 41: {
                pSDELNParamBase.resetPSSysTranslatorId();
                return true;
            }
            case 42: {
                pSDELNParamBase.resetPSSysTranslatorName();
                return true;
            }
            case 43: {
                pSDELNParamBase.resetSrcIndex();
                return true;
            }
            case 44: {
                pSDELNParamBase.resetSrcParamPSDEId();
                return true;
            }
            case 45: {
                pSDELNParamBase.resetSrcPSDEFId();
                return true;
            }
            case 46: {
                pSDELNParamBase.resetSrcPSDEFName();
                return true;
            }
            case 47: {
                pSDELNParamBase.resetSrcPSDLParamId();
                return true;
            }
            case 48: {
                pSDELNParamBase.resetSrcPSDLParamName();
                return true;
            }
            case 49: {
                pSDELNParamBase.resetSrcSize();
                return true;
            }
            case 50: {
                pSDELNParamBase.resetSrcValue();
                return true;
            }
            case 51: {
                pSDELNParamBase.resetSrcValueStdDataType();
                return true;
            }
            case 52: {
                pSDELNParamBase.resetSrcValueType();
                return true;
            }
            case 53: {
                pSDELNParamBase.resetSrcValueTypeText();
                return true;
            }
            case 54: {
                pSDELNParamBase.resetUpdateDate();
                return true;
            }
            case 55: {
                pSDELNParamBase.resetUpdateMan();
                return true;
            }
            case 56: {
                pSDELNParamBase.resetUserCat();
                return true;
            }
            case 57: {
                pSDELNParamBase.resetUserTag();
                return true;
            }
            case 58: {
                pSDELNParamBase.resetUserTag2();
                return true;
            }
            case 59: {
                pSDELNParamBase.resetUserTag3();
                return true;
            }
            case 60: {
                pSDELNParamBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getDstPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEF();
        }
        if (this.getDstPSDEFId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEFLock;
        synchronized (n) {
            if (this.dstpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEFId(), (Object)this.dstpsdef.getPSDEFieldId()) != 0L) {
                this.dstpsdef = null;
            }
            if (this.dstpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getDstPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.dstpsdef = pSDEField;
            }
            return this.dstpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getSrcPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDEF();
        }
        if (this.getSrcPSDEFId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDEFLock;
        synchronized (n) {
            if (this.srcpsdef != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDEFId(), (Object)this.srcpsdef.getPSDEFieldId()) != 0L) {
                this.srcpsdef = null;
            }
            if (this.srcpsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getSrcPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.srcpsdef = pSDEField;
            }
            return this.srcpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicNode getPSDELogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicNode();
        }
        if (this.getPSDELogicNodeId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicNodeLock;
        synchronized (n) {
            if (this.psdelogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicNodeId(), (Object)this.psdelogicnode.getPSDELogicNodeId()) != 0L) {
                this.psdelogicnode = null;
            }
            if (this.psdelogicnode == null) {
                PSDELogicNode pSDELogicNode = new PSDELogicNode();
                pSDELogicNode.setPSDELogicNodeId(this.getPSDELogicNodeId());
                PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicNodeService.autoGet(pSDELogicNode);
                this.psdelogicnode = pSDELogicNode;
            }
            return this.psdelogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getDstPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDLParam();
        }
        if (this.getDstPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objDstPSDLParamLock;
        synchronized (n) {
            if (this.dstpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDLParamId(), (Object)this.dstpsdlparam.getPSDELogicParamId()) != 0L) {
                this.dstpsdlparam = null;
            }
            if (this.dstpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getDstPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet(pSDELogicParam);
                this.dstpsdlparam = pSDELogicParam;
            }
            return this.dstpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicParam getSrcPSDLParam() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDLParam();
        }
        if (this.getSrcPSDLParamId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDLParamLock;
        synchronized (n) {
            if (this.srcpsdlparam != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDLParamId(), (Object)this.srcpsdlparam.getPSDELogicParamId()) != 0L) {
                this.srcpsdlparam = null;
            }
            if (this.srcpsdlparam == null) {
                PSDELogicParam pSDELogicParam = new PSDELogicParam();
                pSDELogicParam.setPSDELogicParamId(this.getSrcPSDLParamId());
                PSDELogicParamService pSDELogicParamService = (PSDELogicParamService)ServiceGlobal.getService(PSDELogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicParamService.autoGet(pSDELogicParam);
                this.srcpsdlparam = pSDELogicParam;
            }
            return this.srcpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysMsgTempl getPSSysMsgTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysMsgTempl();
        }
        if (this.getPSSysMsgTemplId() == null) {
            return null;
        }
        Integer n = this.objPSSysMsgTemplLock;
        synchronized (n) {
            if (this.pssysmsgtempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysMsgTemplId(), (Object)this.pssysmsgtempl.getPSSysMsgTemplId()) != 0L) {
                this.pssysmsgtempl = null;
            }
            if (this.pssysmsgtempl == null) {
                PSSysMsgTempl pSSysMsgTempl = new PSSysMsgTempl();
                pSSysMsgTempl.setPSSysMsgTemplId(this.getPSSysMsgTemplId());
                PSSysMsgTemplService pSSysMsgTemplService = (PSSysMsgTemplService)ServiceGlobal.getService(PSSysMsgTemplService.class, (SessionFactory)this.getSessionFactory());
                pSSysMsgTemplService.autoGet(pSSysMsgTempl);
                this.pssysmsgtempl = pSSysMsgTempl;
            }
            return this.pssysmsgtempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysSequence getPSSysSequeue() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSequeue();
        }
        if (this.getPSSysSequenceId() == null) {
            return null;
        }
        Integer n = this.objPSSysSequeueLock;
        synchronized (n) {
            if (this.pssyssequeue != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSequenceId(), (Object)this.pssyssequeue.getPSSysSequenceId()) != 0L) {
                this.pssyssequeue = null;
            }
            if (this.pssyssequeue == null) {
                PSSysSequence pSSysSequence = new PSSysSequence();
                pSSysSequence.setPSSysSequenceId(this.getPSSysSequenceId());
                PSSysSequenceService pSSysSequenceService = (PSSysSequenceService)ServiceGlobal.getService(PSSysSequenceService.class, (SessionFactory)this.getSessionFactory());
                pSSysSequenceService.autoGet(pSSysSequence);
                this.pssyssequeue = pSSysSequence;
            }
            return this.pssyssequeue;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysTranslator getPSSysTranslator() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysTranslator();
        }
        if (this.getPSSysTranslatorId() == null) {
            return null;
        }
        Integer n = this.objPSSysTranslatorLock;
        synchronized (n) {
            if (this.pssystranslator != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysTranslatorId(), (Object)this.pssystranslator.getPSSysTranslatorId()) != 0L) {
                this.pssystranslator = null;
            }
            if (this.pssystranslator == null) {
                PSSysTranslator pSSysTranslator = new PSSysTranslator();
                pSSysTranslator.setPSSysTranslatorId(this.getPSSysTranslatorId());
                PSSysTranslatorService pSSysTranslatorService = (PSSysTranslatorService)ServiceGlobal.getService(PSSysTranslatorService.class, (SessionFactory)this.getSessionFactory());
                pSSysTranslatorService.autoGet(pSSysTranslator);
                this.pssystranslator = pSSysTranslator;
            }
            return this.pssystranslator;
        }
    }

    private PSDELNParamBase getProxyEntity() {
        return this.proxyPSDELNParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELNParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELNParamBase) {
            this.proxyPSDELNParamBase = (PSDELNParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELNParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AGGMODE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMDSTPARAM, 3);
        fieldIndexMap.put(FIELD_CUSTOMSRCPARAM, 4);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 5);
        fieldIndexMap.put(FIELD_DIRECTCODE, 6);
        fieldIndexMap.put(FIELD_DSTINDEX, 7);
        fieldIndexMap.put(FIELD_DSTPARAMPSDEID, 8);
        fieldIndexMap.put(FIELD_DSTPSDEFID, 9);
        fieldIndexMap.put(FIELD_DSTPSDEFNAME, 10);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMID, 11);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMNAME, 12);
        fieldIndexMap.put(FIELD_DSTSORTDIR, 13);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 14);
        fieldIndexMap.put(FIELD_INOUTFLAG, 15);
        fieldIndexMap.put(FIELD_MEMO, 16);
        fieldIndexMap.put(FIELD_ORDERVALUE, 17);
        fieldIndexMap.put(FIELD_PARAMS, 18);
        fieldIndexMap.put(FIELD_PARAMTAG, 19);
        fieldIndexMap.put(FIELD_PARAMTAG2, 20);
        fieldIndexMap.put(FIELD_PARAMTYPE, 21);
        fieldIndexMap.put(FIELD_PARAMTYPETEXT, 22);
        fieldIndexMap.put(FIELD_PSDEID, 23);
        fieldIndexMap.put(FIELD_PSDELNPARAMID, 24);
        fieldIndexMap.put(FIELD_PSDELNPARAMNAME, 25);
        fieldIndexMap.put(FIELD_PSDELOGICID, 26);
        fieldIndexMap.put(FIELD_PSDELOGICNODEID, 27);
        fieldIndexMap.put(FIELD_PSDELOGICNODENAME, 28);
        fieldIndexMap.put(FIELD_PSDENAME, 29);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 30);
        fieldIndexMap.put(FIELD_PSOBJDATA, 31);
        fieldIndexMap.put(FIELD_PSOBJDATA2, 32);
        fieldIndexMap.put(FIELD_PSOBJID, 33);
        fieldIndexMap.put(FIELD_PSOBJNAME, 34);
        fieldIndexMap.put(FIELD_PSOBJTYPE, 35);
        fieldIndexMap.put(FIELD_PSOBJTYPENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLID, 37);
        fieldIndexMap.put(FIELD_PSSYSMSGTEMPLNAME, 38);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCEID, 39);
        fieldIndexMap.put(FIELD_PSSYSSEQUENCENAME, 40);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORID, 41);
        fieldIndexMap.put(FIELD_PSSYSTRANSLATORNAME, 42);
        fieldIndexMap.put(FIELD_SRCINDEX, 43);
        fieldIndexMap.put(FIELD_SRCPARAMPSDEID, 44);
        fieldIndexMap.put(FIELD_SRCPSDEFID, 45);
        fieldIndexMap.put(FIELD_SRCPSDEFNAME, 46);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMID, 47);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMNAME, 48);
        fieldIndexMap.put(FIELD_SRCSIZE, 49);
        fieldIndexMap.put(FIELD_SRCVALUE, 50);
        fieldIndexMap.put(FIELD_SRCVALUESTDDATATYPE, 51);
        fieldIndexMap.put(FIELD_SRCVALUETYPE, 52);
        fieldIndexMap.put(FIELD_SRCVALUETYPETEXT, 53);
        fieldIndexMap.put(FIELD_UPDATEDATE, 54);
        fieldIndexMap.put(FIELD_UPDATEMAN, 55);
        fieldIndexMap.put(FIELD_USERCAT, 56);
        fieldIndexMap.put(FIELD_USERTAG, 57);
        fieldIndexMap.put(FIELD_USERTAG2, 58);
        fieldIndexMap.put(FIELD_USERTAG3, 59);
        fieldIndexMap.put(FIELD_USERTAG4, 60);
    }
}

