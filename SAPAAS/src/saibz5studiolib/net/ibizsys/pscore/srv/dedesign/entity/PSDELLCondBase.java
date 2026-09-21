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
import net.ibizsys.pscore.srv.config.entity.PSDBValueOP;
import net.ibizsys.pscore.srv.config.service.PSDBValueOPService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicLink;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELLCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELLCondBase.class);
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String FIELD_DSTPARAMPSDEID = "DSTPARAMPSDEID";
    public static final String FIELD_DSTPSDEFID = "DSTPSDEFID";
    public static final String FIELD_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String FIELD_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String FIELD_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PPSDELLCONDID = "PPSDELLCONDID";
    public static final String FIELD_PPSDELLCONDNAME = "PPSDELLCONDNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDELLCONDID = "PSDELLCONDID";
    public static final String FIELD_PSDELLCONDNAME = "PSDELLCONDNAME";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICLINKID = "PSDELOGICLINKID";
    public static final String FIELD_PSDELOGICLINKNAME = "PSDELOGICLINKNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_SRCPSDLPARAMID = "SRCPSDLPARAMID";
    public static final String FIELD_SRCPSDLPARAMNAME = "SRCPSDLPARAMNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONDVALUE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMDSTPARAM = 3;
    private static final int INDEX_DSTPARAMPSDEID = 4;
    private static final int INDEX_DSTPSDEFID = 5;
    private static final int INDEX_DSTPSDEFNAME = 6;
    private static final int INDEX_DSTPSDLPARAMID = 7;
    private static final int INDEX_DSTPSDLPARAMNAME = 8;
    private static final int INDEX_DYNAMODELFLAG = 9;
    private static final int INDEX_GROUPNOTFLAG = 10;
    private static final int INDEX_GROUPOP = 11;
    private static final int INDEX_LOGICTYPE = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PARAMTYPE = 15;
    private static final int INDEX_PPSDELLCONDID = 16;
    private static final int INDEX_PPSDELLCONDNAME = 17;
    private static final int INDEX_PSDBVALUEOPID = 18;
    private static final int INDEX_PSDBVALUEOPNAME = 19;
    private static final int INDEX_PSDELLCONDID = 20;
    private static final int INDEX_PSDELLCONDNAME = 21;
    private static final int INDEX_PSDELOGICID = 22;
    private static final int INDEX_PSDELOGICLINKID = 23;
    private static final int INDEX_PSDELOGICLINKNAME = 24;
    private static final int INDEX_PSDYNAINSTID = 25;
    private static final int INDEX_SRCPSDLPARAMID = 26;
    private static final int INDEX_SRCPSDLPARAMNAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELLCondBase proxyPSDELLCondBase = null;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdstparamDirtyFlag = false;
    private boolean dstparampsdeidDirtyFlag = false;
    private boolean dstpsdefidDirtyFlag = false;
    private boolean dstpsdefnameDirtyFlag = false;
    private boolean dstpsdlparamidDirtyFlag = false;
    private boolean dstpsdlparamnameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean ppsdellcondidDirtyFlag = false;
    private boolean ppsdellcondnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdellcondidDirtyFlag = false;
    private boolean psdellcondnameDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogiclinkidDirtyFlag = false;
    private boolean psdelogiclinknameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean srcpsdlparamidDirtyFlag = false;
    private boolean srcpsdlparamnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdstparam")
    private String customdstparam;
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
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="groupnotflag")
    private Integer groupnotflag;
    @Column(name="groupop")
    private String groupop;
    @Column(name="logictype")
    private String logictype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="ppsdellcondid")
    private String ppsdellcondid;
    @Column(name="ppsdellcondname")
    private String ppsdellcondname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdellcondid")
    private String psdellcondid;
    @Column(name="psdellcondname")
    private String psdellcondname;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogiclinkid")
    private String psdelogiclinkid;
    @Column(name="psdelogiclinkname")
    private String psdelogiclinkname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="srcpsdlparamid")
    private String srcpsdlparamid;
    @Column(name="srcpsdlparamname")
    private String srcpsdlparamname;
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
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objDstPSDEFLock = new Integer(1);
    private PSDEField dstpsdef = null;
    private Integer objPPSDELLCondLock = new Integer(1);
    private PSDELLCond ppsdellcond = null;
    private Integer objPSDELogicLinkLock = new Integer(1);
    private PSDELogicLink psdelogiclink = null;
    private Integer objDstPSDLParamLock = new Integer(1);
    private PSDELogicParam dstpsdlparam = null;
    private Integer objSrcPSDLParamLock = new Integer(1);
    private PSDELogicParam srcpsdlparam = null;
    private Integer objPSDELLCondsLock = new Integer(1);
    private ArrayList<PSDELLCond> psdellconds = null;

    public void setCondValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condvalue = string;
        this.condvalueDirtyFlag = true;
    }

    public String getCondValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondValue();
        }
        return this.condvalue;
    }

    public boolean isCondValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondValueDirty();
        }
        return this.condvalueDirtyFlag;
    }

    public void resetCondValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondValue();
            return;
        }
        this.condvalueDirtyFlag = false;
        this.condvalue = null;
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

    public void setCustomDSTParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomDSTParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customdstparam = string;
        this.customdstparamDirtyFlag = true;
    }

    public String getCustomDSTParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomDSTParam();
        }
        return this.customdstparam;
    }

    public boolean isCustomDSTParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomDSTParamDirty();
        }
        return this.customdstparamDirtyFlag;
    }

    public void resetCustomDSTParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomDSTParam();
            return;
        }
        this.customdstparamDirtyFlag = false;
        this.customdstparam = null;
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

    public void setGroupNotFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupNotFlag(n);
            return;
        }
        this.groupnotflag = n;
        this.groupnotflagDirtyFlag = true;
    }

    public Integer getGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupNotFlag();
        }
        return this.groupnotflag;
    }

    public boolean isGroupNotFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupNotFlagDirty();
        }
        return this.groupnotflagDirtyFlag;
    }

    public void resetGroupNotFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupNotFlag();
            return;
        }
        this.groupnotflagDirtyFlag = false;
        this.groupnotflag = null;
    }

    public void setGroupOP(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupOP(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupop = string;
        this.groupopDirtyFlag = true;
    }

    public String getGroupOP() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupOP();
        }
        return this.groupop;
    }

    public boolean isGroupOPDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupOPDirty();
        }
        return this.groupopDirtyFlag;
    }

    public void resetGroupOP() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupOP();
            return;
        }
        this.groupopDirtyFlag = false;
        this.groupop = null;
    }

    public void setLogicType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logictype = string;
        this.logictypeDirtyFlag = true;
    }

    public String getLogicType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicType();
        }
        return this.logictype;
    }

    public boolean isLogicTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicTypeDirty();
        }
        return this.logictypeDirtyFlag;
    }

    public void resetLogicType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicType();
            return;
        }
        this.logictypeDirtyFlag = false;
        this.logictype = null;
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

    public void setPPSDELLCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDELLCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdellcondid = string;
        this.ppsdellcondidDirtyFlag = true;
    }

    public String getPPSDELLCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDELLCondId();
        }
        return this.ppsdellcondid;
    }

    public boolean isPPSDELLCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDELLCondIdDirty();
        }
        return this.ppsdellcondidDirtyFlag;
    }

    public void resetPPSDELLCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDELLCondId();
            return;
        }
        this.ppsdellcondidDirtyFlag = false;
        this.ppsdellcondid = null;
    }

    public void setPPSDELLCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDELLCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdellcondname = string;
        this.ppsdellcondnameDirtyFlag = true;
    }

    public String getPPSDELLCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDELLCondName();
        }
        return this.ppsdellcondname;
    }

    public boolean isPPSDELLCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDELLCondNameDirty();
        }
        return this.ppsdellcondnameDirtyFlag;
    }

    public void resetPPSDELLCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDELLCondName();
            return;
        }
        this.ppsdellcondnameDirtyFlag = false;
        this.ppsdellcondname = null;
    }

    public void setPSDBValueOPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopid = string;
        this.psdbvalueopidDirtyFlag = true;
    }

    public String getPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPId();
        }
        return this.psdbvalueopid;
    }

    public boolean isPSDBValueOPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPIdDirty();
        }
        return this.psdbvalueopidDirtyFlag;
    }

    public void resetPSDBValueOPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPId();
            return;
        }
        this.psdbvalueopidDirtyFlag = false;
        this.psdbvalueopid = null;
    }

    public void setPSDBValueOPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDBValueOPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdbvalueopname = string;
        this.psdbvalueopnameDirtyFlag = true;
    }

    public String getPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOPName();
        }
        return this.psdbvalueopname;
    }

    public boolean isPSDBValueOPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDBValueOPNameDirty();
        }
        return this.psdbvalueopnameDirtyFlag;
    }

    public void resetPSDBValueOPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDBValueOPName();
            return;
        }
        this.psdbvalueopnameDirtyFlag = false;
        this.psdbvalueopname = null;
    }

    public void setPSDELLCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdellcondid = string;
        this.psdellcondidDirtyFlag = true;
    }

    public String getPSDELLCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLCondId();
        }
        return this.psdellcondid;
    }

    public boolean isPSDELLCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLCondIdDirty();
        }
        return this.psdellcondidDirtyFlag;
    }

    public void resetPSDELLCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLCondId();
            return;
        }
        this.psdellcondidDirtyFlag = false;
        this.psdellcondid = null;
    }

    public void setPSDELLCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELLCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdellcondname = string;
        this.psdellcondnameDirtyFlag = true;
    }

    public String getPSDELLCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLCondName();
        }
        return this.psdellcondname;
    }

    public boolean isPSDELLCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELLCondNameDirty();
        }
        return this.psdellcondnameDirtyFlag;
    }

    public void resetPSDELLCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELLCondName();
            return;
        }
        this.psdellcondnameDirtyFlag = false;
        this.psdellcondname = null;
    }

    public void setPSDElogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDElogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicid = string;
        this.psdelogicidDirtyFlag = true;
    }

    public String getPSDElogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDElogicId();
        }
        return this.psdelogicid;
    }

    public boolean isPSDElogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDElogicIdDirty();
        }
        return this.psdelogicidDirtyFlag;
    }

    public void resetPSDElogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDElogicId();
            return;
        }
        this.psdelogicidDirtyFlag = false;
        this.psdelogicid = null;
    }

    public void setPSDELogicLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogiclinkid = string;
        this.psdelogiclinkidDirtyFlag = true;
    }

    public String getPSDELogicLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicLinkId();
        }
        return this.psdelogiclinkid;
    }

    public boolean isPSDELogicLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicLinkIdDirty();
        }
        return this.psdelogiclinkidDirtyFlag;
    }

    public void resetPSDELogicLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicLinkId();
            return;
        }
        this.psdelogiclinkidDirtyFlag = false;
        this.psdelogiclinkid = null;
    }

    public void setPSDELogicLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogiclinkname = string;
        this.psdelogiclinknameDirtyFlag = true;
    }

    public String getPSDELogicLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicLinkName();
        }
        return this.psdelogiclinkname;
    }

    public boolean isPSDELogicLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicLinkNameDirty();
        }
        return this.psdelogiclinknameDirtyFlag;
    }

    public void resetPSDELogicLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicLinkName();
            return;
        }
        this.psdelogiclinknameDirtyFlag = false;
        this.psdelogiclinkname = null;
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
        PSDELLCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELLCondBase pSDELLCondBase) {
        pSDELLCondBase.resetCondValue();
        pSDELLCondBase.resetCreateDate();
        pSDELLCondBase.resetCreateMan();
        pSDELLCondBase.resetCustomDSTParam();
        pSDELLCondBase.resetDstParamPSDEId();
        pSDELLCondBase.resetDstPSDEFId();
        pSDELLCondBase.resetDstPSDEFName();
        pSDELLCondBase.resetDstPSDLParamId();
        pSDELLCondBase.resetDstPSDLParamName();
        pSDELLCondBase.resetDynaModelFlag();
        pSDELLCondBase.resetGroupNotFlag();
        pSDELLCondBase.resetGroupOP();
        pSDELLCondBase.resetLogicType();
        pSDELLCondBase.resetMemo();
        pSDELLCondBase.resetOrderValue();
        pSDELLCondBase.resetParamType();
        pSDELLCondBase.resetPPSDELLCondId();
        pSDELLCondBase.resetPPSDELLCondName();
        pSDELLCondBase.resetPSDBValueOPId();
        pSDELLCondBase.resetPSDBValueOPName();
        pSDELLCondBase.resetPSDELLCondId();
        pSDELLCondBase.resetPSDELLCondName();
        pSDELLCondBase.resetPSDElogicId();
        pSDELLCondBase.resetPSDELogicLinkId();
        pSDELLCondBase.resetPSDELogicLinkName();
        pSDELLCondBase.resetPSDynaInstId();
        pSDELLCondBase.resetSrcPSDLParamId();
        pSDELLCondBase.resetSrcPSDLParamName();
        pSDELLCondBase.resetUpdateDate();
        pSDELLCondBase.resetUpdateMan();
        pSDELLCondBase.resetUserCat();
        pSDELLCondBase.resetUserTag();
        pSDELLCondBase.resetUserTag2();
        pSDELLCondBase.resetUserTag3();
        pSDELLCondBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondValueDirty()) {
            hashMap.put(FIELD_CONDVALUE, this.getCondValue());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCustomDSTParamDirty()) {
            hashMap.put(FIELD_CUSTOMDSTPARAM, this.getCustomDSTParam());
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isGroupNotFlagDirty()) {
            hashMap.put(FIELD_GROUPNOTFLAG, this.getGroupNotFlag());
        }
        if (!bl || this.isGroupOPDirty()) {
            hashMap.put(FIELD_GROUPOP, this.getGroupOP());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPPSDELLCondIdDirty()) {
            hashMap.put(FIELD_PPSDELLCONDID, this.getPPSDELLCondId());
        }
        if (!bl || this.isPPSDELLCondNameDirty()) {
            hashMap.put(FIELD_PPSDELLCONDNAME, this.getPPSDELLCondName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDELLCondIdDirty()) {
            hashMap.put(FIELD_PSDELLCONDID, this.getPSDELLCondId());
        }
        if (!bl || this.isPSDELLCondNameDirty()) {
            hashMap.put(FIELD_PSDELLCONDNAME, this.getPSDELLCondName());
        }
        if (!bl || this.isPSDElogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDElogicId());
        }
        if (!bl || this.isPSDELogicLinkIdDirty()) {
            hashMap.put(FIELD_PSDELOGICLINKID, this.getPSDELogicLinkId());
        }
        if (!bl || this.isPSDELogicLinkNameDirty()) {
            hashMap.put(FIELD_PSDELOGICLINKNAME, this.getPSDELogicLinkName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isSrcPSDLParamIdDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMID, this.getSrcPSDLParamId());
        }
        if (!bl || this.isSrcPSDLParamNameDirty()) {
            hashMap.put(FIELD_SRCPSDLPARAMNAME, this.getSrcPSDLParamName());
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
        return PSDELLCondBase.get(this, n);
    }

    private static Object get(PSDELLCondBase pSDELLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondBase.getCondValue();
            }
            case 1: {
                return pSDELLCondBase.getCreateDate();
            }
            case 2: {
                return pSDELLCondBase.getCreateMan();
            }
            case 3: {
                return pSDELLCondBase.getCustomDSTParam();
            }
            case 4: {
                return pSDELLCondBase.getDstParamPSDEId();
            }
            case 5: {
                return pSDELLCondBase.getDstPSDEFId();
            }
            case 6: {
                return pSDELLCondBase.getDstPSDEFName();
            }
            case 7: {
                return pSDELLCondBase.getDstPSDLParamId();
            }
            case 8: {
                return pSDELLCondBase.getDstPSDLParamName();
            }
            case 9: {
                return pSDELLCondBase.getDynaModelFlag();
            }
            case 10: {
                return pSDELLCondBase.getGroupNotFlag();
            }
            case 11: {
                return pSDELLCondBase.getGroupOP();
            }
            case 12: {
                return pSDELLCondBase.getLogicType();
            }
            case 13: {
                return pSDELLCondBase.getMemo();
            }
            case 14: {
                return pSDELLCondBase.getOrderValue();
            }
            case 15: {
                return pSDELLCondBase.getParamType();
            }
            case 16: {
                return pSDELLCondBase.getPPSDELLCondId();
            }
            case 17: {
                return pSDELLCondBase.getPPSDELLCondName();
            }
            case 18: {
                return pSDELLCondBase.getPSDBValueOPId();
            }
            case 19: {
                return pSDELLCondBase.getPSDBValueOPName();
            }
            case 20: {
                return pSDELLCondBase.getPSDELLCondId();
            }
            case 21: {
                return pSDELLCondBase.getPSDELLCondName();
            }
            case 22: {
                return pSDELLCondBase.getPSDElogicId();
            }
            case 23: {
                return pSDELLCondBase.getPSDELogicLinkId();
            }
            case 24: {
                return pSDELLCondBase.getPSDELogicLinkName();
            }
            case 25: {
                return pSDELLCondBase.getPSDynaInstId();
            }
            case 26: {
                return pSDELLCondBase.getSrcPSDLParamId();
            }
            case 27: {
                return pSDELLCondBase.getSrcPSDLParamName();
            }
            case 28: {
                return pSDELLCondBase.getUpdateDate();
            }
            case 29: {
                return pSDELLCondBase.getUpdateMan();
            }
            case 30: {
                return pSDELLCondBase.getUserCat();
            }
            case 31: {
                return pSDELLCondBase.getUserTag();
            }
            case 32: {
                return pSDELLCondBase.getUserTag2();
            }
            case 33: {
                return pSDELLCondBase.getUserTag3();
            }
            case 34: {
                return pSDELLCondBase.getUserTag4();
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
        PSDELLCondBase.set(this, n, object);
    }

    private static void set(PSDELLCondBase pSDELLCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELLCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELLCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELLCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELLCondBase.setCustomDSTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDELLCondBase.setDstParamPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDELLCondBase.setDstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELLCondBase.setDstPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELLCondBase.setDstPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELLCondBase.setDstPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELLCondBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDELLCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDELLCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELLCondBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDELLCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDELLCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDELLCondBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDELLCondBase.setPPSDELLCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELLCondBase.setPPSDELLCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELLCondBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELLCondBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELLCondBase.setPSDELLCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELLCondBase.setPSDELLCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELLCondBase.setPSDElogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELLCondBase.setPSDELogicLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELLCondBase.setPSDELogicLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELLCondBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDELLCondBase.setSrcPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELLCondBase.setSrcPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDELLCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSDELLCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELLCondBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELLCondBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELLCondBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELLCondBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDELLCondBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDELLCondBase.isNull(this, n);
    }

    private static boolean isNull(PSDELLCondBase pSDELLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondBase.getCondValue() == null;
            }
            case 1: {
                return pSDELLCondBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELLCondBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELLCondBase.getCustomDSTParam() == null;
            }
            case 4: {
                return pSDELLCondBase.getDstParamPSDEId() == null;
            }
            case 5: {
                return pSDELLCondBase.getDstPSDEFId() == null;
            }
            case 6: {
                return pSDELLCondBase.getDstPSDEFName() == null;
            }
            case 7: {
                return pSDELLCondBase.getDstPSDLParamId() == null;
            }
            case 8: {
                return pSDELLCondBase.getDstPSDLParamName() == null;
            }
            case 9: {
                return pSDELLCondBase.getDynaModelFlag() == null;
            }
            case 10: {
                return pSDELLCondBase.getGroupNotFlag() == null;
            }
            case 11: {
                return pSDELLCondBase.getGroupOP() == null;
            }
            case 12: {
                return pSDELLCondBase.getLogicType() == null;
            }
            case 13: {
                return pSDELLCondBase.getMemo() == null;
            }
            case 14: {
                return pSDELLCondBase.getOrderValue() == null;
            }
            case 15: {
                return pSDELLCondBase.getParamType() == null;
            }
            case 16: {
                return pSDELLCondBase.getPPSDELLCondId() == null;
            }
            case 17: {
                return pSDELLCondBase.getPPSDELLCondName() == null;
            }
            case 18: {
                return pSDELLCondBase.getPSDBValueOPId() == null;
            }
            case 19: {
                return pSDELLCondBase.getPSDBValueOPName() == null;
            }
            case 20: {
                return pSDELLCondBase.getPSDELLCondId() == null;
            }
            case 21: {
                return pSDELLCondBase.getPSDELLCondName() == null;
            }
            case 22: {
                return pSDELLCondBase.getPSDElogicId() == null;
            }
            case 23: {
                return pSDELLCondBase.getPSDELogicLinkId() == null;
            }
            case 24: {
                return pSDELLCondBase.getPSDELogicLinkName() == null;
            }
            case 25: {
                return pSDELLCondBase.getPSDynaInstId() == null;
            }
            case 26: {
                return pSDELLCondBase.getSrcPSDLParamId() == null;
            }
            case 27: {
                return pSDELLCondBase.getSrcPSDLParamName() == null;
            }
            case 28: {
                return pSDELLCondBase.getUpdateDate() == null;
            }
            case 29: {
                return pSDELLCondBase.getUpdateMan() == null;
            }
            case 30: {
                return pSDELLCondBase.getUserCat() == null;
            }
            case 31: {
                return pSDELLCondBase.getUserTag() == null;
            }
            case 32: {
                return pSDELLCondBase.getUserTag2() == null;
            }
            case 33: {
                return pSDELLCondBase.getUserTag3() == null;
            }
            case 34: {
                return pSDELLCondBase.getUserTag4() == null;
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
        return PSDELLCondBase.contains(this, n);
    }

    private static boolean contains(PSDELLCondBase pSDELLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELLCondBase.isCondValueDirty();
            }
            case 1: {
                return pSDELLCondBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELLCondBase.isCreateManDirty();
            }
            case 3: {
                return pSDELLCondBase.isCustomDSTParamDirty();
            }
            case 4: {
                return pSDELLCondBase.isDstParamPSDEIdDirty();
            }
            case 5: {
                return pSDELLCondBase.isDstPSDEFIdDirty();
            }
            case 6: {
                return pSDELLCondBase.isDstPSDEFNameDirty();
            }
            case 7: {
                return pSDELLCondBase.isDstPSDLParamIdDirty();
            }
            case 8: {
                return pSDELLCondBase.isDstPSDLParamNameDirty();
            }
            case 9: {
                return pSDELLCondBase.isDynaModelFlagDirty();
            }
            case 10: {
                return pSDELLCondBase.isGroupNotFlagDirty();
            }
            case 11: {
                return pSDELLCondBase.isGroupOPDirty();
            }
            case 12: {
                return pSDELLCondBase.isLogicTypeDirty();
            }
            case 13: {
                return pSDELLCondBase.isMemoDirty();
            }
            case 14: {
                return pSDELLCondBase.isOrderValueDirty();
            }
            case 15: {
                return pSDELLCondBase.isParamTypeDirty();
            }
            case 16: {
                return pSDELLCondBase.isPPSDELLCondIdDirty();
            }
            case 17: {
                return pSDELLCondBase.isPPSDELLCondNameDirty();
            }
            case 18: {
                return pSDELLCondBase.isPSDBValueOPIdDirty();
            }
            case 19: {
                return pSDELLCondBase.isPSDBValueOPNameDirty();
            }
            case 20: {
                return pSDELLCondBase.isPSDELLCondIdDirty();
            }
            case 21: {
                return pSDELLCondBase.isPSDELLCondNameDirty();
            }
            case 22: {
                return pSDELLCondBase.isPSDElogicIdDirty();
            }
            case 23: {
                return pSDELLCondBase.isPSDELogicLinkIdDirty();
            }
            case 24: {
                return pSDELLCondBase.isPSDELogicLinkNameDirty();
            }
            case 25: {
                return pSDELLCondBase.isPSDynaInstIdDirty();
            }
            case 26: {
                return pSDELLCondBase.isSrcPSDLParamIdDirty();
            }
            case 27: {
                return pSDELLCondBase.isSrcPSDLParamNameDirty();
            }
            case 28: {
                return pSDELLCondBase.isUpdateDateDirty();
            }
            case 29: {
                return pSDELLCondBase.isUpdateManDirty();
            }
            case 30: {
                return pSDELLCondBase.isUserCatDirty();
            }
            case 31: {
                return pSDELLCondBase.isUserTagDirty();
            }
            case 32: {
                return pSDELLCondBase.isUserTag2Dirty();
            }
            case 33: {
                return pSDELLCondBase.isUserTag3Dirty();
            }
            case 34: {
                return pSDELLCondBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELLCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELLCondBase pSDELLCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELLCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getCustomDSTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdstparam", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getCustomDSTParam()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDstParamPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstparampsdeid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDstParamPSDEId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDstPSDEFId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDstPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDstPSDEFName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDstPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDstPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDstPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDstPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getLogicType()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getParamType()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPPSDELLCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdellcondid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPPSDELLCondId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPPSDELLCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdellcondname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPPSDELLCondName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDELLCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdellcondid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDELLCondId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDELLCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdellcondname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDELLCondName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDElogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDElogicId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDELogicLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogiclinkid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDELogicLinkId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDELogicLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogiclinkname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDELogicLinkName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getSrcPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamid", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getSrcPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getSrcPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdlparamname", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getSrcPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELLCondBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELLCondBase.getJSONValue((Object)pSDELLCondBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELLCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELLCondBase pSDELLCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELLCondBase.getCondValue() != null) {
            object = pSDELLCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getCreateDate() != null) {
            object = pSDELLCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLCondBase.getCreateMan() != null) {
            object = pSDELLCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getCustomDSTParam() != null) {
            object = pSDELLCondBase.getCustomDSTParam();
            xmlNode.setAttribute(FIELD_CUSTOMDSTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDstParamPSDEId() != null) {
            object = pSDELLCondBase.getDstParamPSDEId();
            xmlNode.setAttribute(FIELD_DSTPARAMPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDstPSDEFId() != null) {
            object = pSDELLCondBase.getDstPSDEFId();
            xmlNode.setAttribute(FIELD_DSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDstPSDEFName() != null) {
            object = pSDELLCondBase.getDstPSDEFName();
            xmlNode.setAttribute(FIELD_DSTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDstPSDLParamId() != null) {
            object = pSDELLCondBase.getDstPSDLParamId();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDstPSDLParamName() != null) {
            object = pSDELLCondBase.getDstPSDLParamName();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getDynaModelFlag() != null) {
            object = pSDELLCondBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELLCondBase.getGroupNotFlag() != null) {
            object = pSDELLCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELLCondBase.getGroupOP() != null) {
            object = pSDELLCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getLogicType() != null) {
            object = pSDELLCondBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getMemo() != null) {
            object = pSDELLCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getOrderValue() != null) {
            object = pSDELLCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELLCondBase.getParamType() != null) {
            object = pSDELLCondBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPPSDELLCondId() != null) {
            object = pSDELLCondBase.getPPSDELLCondId();
            xmlNode.setAttribute(FIELD_PPSDELLCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPPSDELLCondName() != null) {
            object = pSDELLCondBase.getPPSDELLCondName();
            xmlNode.setAttribute(FIELD_PPSDELLCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDBValueOPId() != null) {
            object = pSDELLCondBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDBValueOPName() != null) {
            object = pSDELLCondBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDELLCondId() != null) {
            object = pSDELLCondBase.getPSDELLCondId();
            xmlNode.setAttribute(FIELD_PSDELLCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDELLCondName() != null) {
            object = pSDELLCondBase.getPSDELLCondName();
            xmlNode.setAttribute(FIELD_PSDELLCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDElogicId() != null) {
            object = pSDELLCondBase.getPSDElogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDELogicLinkId() != null) {
            object = pSDELLCondBase.getPSDELogicLinkId();
            xmlNode.setAttribute(FIELD_PSDELOGICLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDELogicLinkName() != null) {
            object = pSDELLCondBase.getPSDELogicLinkName();
            xmlNode.setAttribute(FIELD_PSDELOGICLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getPSDynaInstId() != null) {
            object = pSDELLCondBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getSrcPSDLParamId() != null) {
            object = pSDELLCondBase.getSrcPSDLParamId();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getSrcPSDLParamName() != null) {
            object = pSDELLCondBase.getSrcPSDLParamName();
            xmlNode.setAttribute(FIELD_SRCPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUpdateDate() != null) {
            object = pSDELLCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELLCondBase.getUpdateMan() != null) {
            object = pSDELLCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUserCat() != null) {
            object = pSDELLCondBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUserTag() != null) {
            object = pSDELLCondBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUserTag2() != null) {
            object = pSDELLCondBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUserTag3() != null) {
            object = pSDELLCondBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELLCondBase.getUserTag4() != null) {
            object = pSDELLCondBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELLCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELLCondBase pSDELLCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELLCondBase.isCondValueDirty() && (bl || pSDELLCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSDELLCondBase.getCondValue());
        }
        if (pSDELLCondBase.isCreateDateDirty() && (bl || pSDELLCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELLCondBase.getCreateDate());
        }
        if (pSDELLCondBase.isCreateManDirty() && (bl || pSDELLCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELLCondBase.getCreateMan());
        }
        if (pSDELLCondBase.isCustomDSTParamDirty() && (bl || pSDELLCondBase.getCustomDSTParam() != null)) {
            iDataObject.set(FIELD_CUSTOMDSTPARAM, (Object)pSDELLCondBase.getCustomDSTParam());
        }
        if (pSDELLCondBase.isDstParamPSDEIdDirty() && (bl || pSDELLCondBase.getDstParamPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPARAMPSDEID, (Object)pSDELLCondBase.getDstParamPSDEId());
        }
        if (pSDELLCondBase.isDstPSDEFIdDirty() && (bl || pSDELLCondBase.getDstPSDEFId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFID, (Object)pSDELLCondBase.getDstPSDEFId());
        }
        if (pSDELLCondBase.isDstPSDEFNameDirty() && (bl || pSDELLCondBase.getDstPSDEFName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFNAME, (Object)pSDELLCondBase.getDstPSDEFName());
        }
        if (pSDELLCondBase.isDstPSDLParamIdDirty() && (bl || pSDELLCondBase.getDstPSDLParamId() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMID, (Object)pSDELLCondBase.getDstPSDLParamId());
        }
        if (pSDELLCondBase.isDstPSDLParamNameDirty() && (bl || pSDELLCondBase.getDstPSDLParamName() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMNAME, (Object)pSDELLCondBase.getDstPSDLParamName());
        }
        if (pSDELLCondBase.isDynaModelFlagDirty() && (bl || pSDELLCondBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELLCondBase.getDynaModelFlag());
        }
        if (pSDELLCondBase.isGroupNotFlagDirty() && (bl || pSDELLCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSDELLCondBase.getGroupNotFlag());
        }
        if (pSDELLCondBase.isGroupOPDirty() && (bl || pSDELLCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSDELLCondBase.getGroupOP());
        }
        if (pSDELLCondBase.isLogicTypeDirty() && (bl || pSDELLCondBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSDELLCondBase.getLogicType());
        }
        if (pSDELLCondBase.isMemoDirty() && (bl || pSDELLCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELLCondBase.getMemo());
        }
        if (pSDELLCondBase.isOrderValueDirty() && (bl || pSDELLCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELLCondBase.getOrderValue());
        }
        if (pSDELLCondBase.isParamTypeDirty() && (bl || pSDELLCondBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSDELLCondBase.getParamType());
        }
        if (pSDELLCondBase.isPPSDELLCondIdDirty() && (bl || pSDELLCondBase.getPPSDELLCondId() != null)) {
            iDataObject.set(FIELD_PPSDELLCONDID, (Object)pSDELLCondBase.getPPSDELLCondId());
        }
        if (pSDELLCondBase.isPPSDELLCondNameDirty() && (bl || pSDELLCondBase.getPPSDELLCondName() != null)) {
            iDataObject.set(FIELD_PPSDELLCONDNAME, (Object)pSDELLCondBase.getPPSDELLCondName());
        }
        if (pSDELLCondBase.isPSDBValueOPIdDirty() && (bl || pSDELLCondBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDELLCondBase.getPSDBValueOPId());
        }
        if (pSDELLCondBase.isPSDBValueOPNameDirty() && (bl || pSDELLCondBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDELLCondBase.getPSDBValueOPName());
        }
        if (pSDELLCondBase.isPSDELLCondIdDirty() && (bl || pSDELLCondBase.getPSDELLCondId() != null)) {
            iDataObject.set(FIELD_PSDELLCONDID, (Object)pSDELLCondBase.getPSDELLCondId());
        }
        if (pSDELLCondBase.isPSDELLCondNameDirty() && (bl || pSDELLCondBase.getPSDELLCondName() != null)) {
            iDataObject.set(FIELD_PSDELLCONDNAME, (Object)pSDELLCondBase.getPSDELLCondName());
        }
        if (pSDELLCondBase.isPSDElogicIdDirty() && (bl || pSDELLCondBase.getPSDElogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELLCondBase.getPSDElogicId());
        }
        if (pSDELLCondBase.isPSDELogicLinkIdDirty() && (bl || pSDELLCondBase.getPSDELogicLinkId() != null)) {
            iDataObject.set(FIELD_PSDELOGICLINKID, (Object)pSDELLCondBase.getPSDELogicLinkId());
        }
        if (pSDELLCondBase.isPSDELogicLinkNameDirty() && (bl || pSDELLCondBase.getPSDELogicLinkName() != null)) {
            iDataObject.set(FIELD_PSDELOGICLINKNAME, (Object)pSDELLCondBase.getPSDELogicLinkName());
        }
        if (pSDELLCondBase.isPSDynaInstIdDirty() && (bl || pSDELLCondBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELLCondBase.getPSDynaInstId());
        }
        if (pSDELLCondBase.isSrcPSDLParamIdDirty() && (bl || pSDELLCondBase.getSrcPSDLParamId() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMID, (Object)pSDELLCondBase.getSrcPSDLParamId());
        }
        if (pSDELLCondBase.isSrcPSDLParamNameDirty() && (bl || pSDELLCondBase.getSrcPSDLParamName() != null)) {
            iDataObject.set(FIELD_SRCPSDLPARAMNAME, (Object)pSDELLCondBase.getSrcPSDLParamName());
        }
        if (pSDELLCondBase.isUpdateDateDirty() && (bl || pSDELLCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELLCondBase.getUpdateDate());
        }
        if (pSDELLCondBase.isUpdateManDirty() && (bl || pSDELLCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELLCondBase.getUpdateMan());
        }
        if (pSDELLCondBase.isUserCatDirty() && (bl || pSDELLCondBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELLCondBase.getUserCat());
        }
        if (pSDELLCondBase.isUserTagDirty() && (bl || pSDELLCondBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELLCondBase.getUserTag());
        }
        if (pSDELLCondBase.isUserTag2Dirty() && (bl || pSDELLCondBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELLCondBase.getUserTag2());
        }
        if (pSDELLCondBase.isUserTag3Dirty() && (bl || pSDELLCondBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELLCondBase.getUserTag3());
        }
        if (pSDELLCondBase.isUserTag4Dirty() && (bl || pSDELLCondBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELLCondBase.getUserTag4());
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
        return PSDELLCondBase.remove(this, n);
    }

    private static boolean remove(PSDELLCondBase pSDELLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELLCondBase.resetCondValue();
                return true;
            }
            case 1: {
                pSDELLCondBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELLCondBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELLCondBase.resetCustomDSTParam();
                return true;
            }
            case 4: {
                pSDELLCondBase.resetDstParamPSDEId();
                return true;
            }
            case 5: {
                pSDELLCondBase.resetDstPSDEFId();
                return true;
            }
            case 6: {
                pSDELLCondBase.resetDstPSDEFName();
                return true;
            }
            case 7: {
                pSDELLCondBase.resetDstPSDLParamId();
                return true;
            }
            case 8: {
                pSDELLCondBase.resetDstPSDLParamName();
                return true;
            }
            case 9: {
                pSDELLCondBase.resetDynaModelFlag();
                return true;
            }
            case 10: {
                pSDELLCondBase.resetGroupNotFlag();
                return true;
            }
            case 11: {
                pSDELLCondBase.resetGroupOP();
                return true;
            }
            case 12: {
                pSDELLCondBase.resetLogicType();
                return true;
            }
            case 13: {
                pSDELLCondBase.resetMemo();
                return true;
            }
            case 14: {
                pSDELLCondBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSDELLCondBase.resetParamType();
                return true;
            }
            case 16: {
                pSDELLCondBase.resetPPSDELLCondId();
                return true;
            }
            case 17: {
                pSDELLCondBase.resetPPSDELLCondName();
                return true;
            }
            case 18: {
                pSDELLCondBase.resetPSDBValueOPId();
                return true;
            }
            case 19: {
                pSDELLCondBase.resetPSDBValueOPName();
                return true;
            }
            case 20: {
                pSDELLCondBase.resetPSDELLCondId();
                return true;
            }
            case 21: {
                pSDELLCondBase.resetPSDELLCondName();
                return true;
            }
            case 22: {
                pSDELLCondBase.resetPSDElogicId();
                return true;
            }
            case 23: {
                pSDELLCondBase.resetPSDELogicLinkId();
                return true;
            }
            case 24: {
                pSDELLCondBase.resetPSDELogicLinkName();
                return true;
            }
            case 25: {
                pSDELLCondBase.resetPSDynaInstId();
                return true;
            }
            case 26: {
                pSDELLCondBase.resetSrcPSDLParamId();
                return true;
            }
            case 27: {
                pSDELLCondBase.resetSrcPSDLParamName();
                return true;
            }
            case 28: {
                pSDELLCondBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSDELLCondBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSDELLCondBase.resetUserCat();
                return true;
            }
            case 31: {
                pSDELLCondBase.resetUserTag();
                return true;
            }
            case 32: {
                pSDELLCondBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSDELLCondBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSDELLCondBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOP();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOPLock;
        synchronized (n) {
            if (this.psdbvalueop != null && DataTypeHelper.compare((int)25, (Object)this.getPSDBValueOPId(), (Object)this.psdbvalueop.getPSDBValueOPId()) != 0L) {
                this.psdbvalueop = null;
            }
            if (this.psdbvalueop == null) {
                PSDBValueOP pSDBValueOP = new PSDBValueOP();
                pSDBValueOP.setPSDBValueOPId(this.getPSDBValueOPId());
                PSDBValueOPService pSDBValueOPService = (PSDBValueOPService)ServiceGlobal.getService(PSDBValueOPService.class, (SessionFactory)this.getSessionFactory());
                pSDBValueOPService.autoGet((IEntity)pSDBValueOP);
                this.psdbvalueop = pSDBValueOP;
            }
            return this.psdbvalueop;
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
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.dstpsdef = pSDEField;
            }
            return this.dstpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELLCond getPPSDELLCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDELLCond();
        }
        if (this.getPPSDELLCondId() == null) {
            return null;
        }
        Integer n = this.objPPSDELLCondLock;
        synchronized (n) {
            if (this.ppsdellcond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDELLCondId(), (Object)this.ppsdellcond.getPSDELLCondId()) != 0L) {
                this.ppsdellcond = null;
            }
            if (this.ppsdellcond == null) {
                PSDELLCond pSDELLCond = new PSDELLCond();
                pSDELLCond.setPSDELLCondId(this.getPPSDELLCondId());
                PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
                pSDELLCondService.autoGet((IEntity)pSDELLCond);
                this.ppsdellcond = pSDELLCond;
            }
            return this.ppsdellcond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicLink getPSDELogicLink() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicLink();
        }
        if (this.getPSDELogicLinkId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLinkLock;
        synchronized (n) {
            if (this.psdelogiclink != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicLinkId(), (Object)this.psdelogiclink.getPSDELogicLinkId()) != 0L) {
                this.psdelogiclink = null;
            }
            if (this.psdelogiclink == null) {
                PSDELogicLink pSDELogicLink = new PSDELogicLink();
                pSDELogicLink.setPSDELogicLinkId(this.getPSDELogicLinkId());
                PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicLinkService.autoGet((IEntity)pSDELogicLink);
                this.psdelogiclink = pSDELogicLink;
            }
            return this.psdelogiclink;
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
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
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
                pSDELogicParamService.autoGet((IEntity)pSDELogicParam);
                this.srcpsdlparam = pSDELogicParam;
            }
            return this.srcpsdlparam;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELLCond> getPSDELLConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLConds();
        }
        if (this.getPSDELLCondId() == null) {
            return null;
        }
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELLCondsLock;
        synchronized (n) {
            if (this.psdellconds == null) {
                this.psdellconds = pSDELLCondService.selectByPPSDELLCond(this);
            }
            return this.psdellconds;
        }
    }

    private PSDELLCondBase getProxyEntity() {
        return this.proxyPSDELLCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELLCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELLCondBase) {
            this.proxyPSDELLCondBase = (PSDELLCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDVALUE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMDSTPARAM, 3);
        fieldIndexMap.put(FIELD_DSTPARAMPSDEID, 4);
        fieldIndexMap.put(FIELD_DSTPSDEFID, 5);
        fieldIndexMap.put(FIELD_DSTPSDEFNAME, 6);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMID, 7);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMNAME, 8);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 9);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 10);
        fieldIndexMap.put(FIELD_GROUPOP, 11);
        fieldIndexMap.put(FIELD_LOGICTYPE, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PARAMTYPE, 15);
        fieldIndexMap.put(FIELD_PPSDELLCONDID, 16);
        fieldIndexMap.put(FIELD_PPSDELLCONDNAME, 17);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 18);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 19);
        fieldIndexMap.put(FIELD_PSDELLCONDID, 20);
        fieldIndexMap.put(FIELD_PSDELLCONDNAME, 21);
        fieldIndexMap.put(FIELD_PSDELOGICID, 22);
        fieldIndexMap.put(FIELD_PSDELOGICLINKID, 23);
        fieldIndexMap.put(FIELD_PSDELOGICLINKNAME, 24);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 25);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMID, 26);
        fieldIndexMap.put(FIELD_SRCPSDLPARAMNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
    }
}

