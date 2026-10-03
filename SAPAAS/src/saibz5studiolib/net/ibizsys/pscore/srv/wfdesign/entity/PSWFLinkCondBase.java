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
package net.ibizsys.pscore.srv.wfdesign.entity;

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
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLink;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFLinkCond;
import net.ibizsys.pscore.srv.wfdesign.entity.PSWFVersion;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkService;
import net.ibizsys.pscore.srv.wfdesign.service.PSWFVersionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSWFLinkCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSWFLinkCondBase.class);
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMDSTPARAM = "CUSTOMDSTPARAM";
    public static final String FIELD_DSTPSDEFID = "DSTPSDEFID";
    public static final String FIELD_DSTPSDEFNAME = "DSTPSDEFNAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PPSWFLINKCONDID = "PPSWFLINKCONDID";
    public static final String FIELD_PPSWFLINKCONDNAME = "PPSWFLINKCONDNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSWFLINKCONDID = "PSWFLINKCONDID";
    public static final String FIELD_PSWFLINKCONDNAME = "PSWFLINKCONDNAME";
    public static final String FIELD_PSWFLINKID = "PSWFLINKID";
    public static final String FIELD_PSWFLINKNAME = "PSWFLINKNAME";
    public static final String FIELD_PSWFVERSIONID = "PSWFVERSIONID";
    public static final String FIELD_PSWFVERSIONNAME = "PSWFVERSIONNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDVALUE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMDSTPARAM = 3;
    private static final int INDEX_DSTPSDEFID = 4;
    private static final int INDEX_DSTPSDEFNAME = 5;
    private static final int INDEX_DYNAMODELFLAG = 6;
    private static final int INDEX_GROUPNOTFLAG = 7;
    private static final int INDEX_GROUPOP = 8;
    private static final int INDEX_LOGICTYPE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PARAMTYPE = 12;
    private static final int INDEX_PPSWFLINKCONDID = 13;
    private static final int INDEX_PPSWFLINKCONDNAME = 14;
    private static final int INDEX_PSDBVALUEOPID = 15;
    private static final int INDEX_PSDBVALUEOPNAME = 16;
    private static final int INDEX_PSDYNAINSTID = 17;
    private static final int INDEX_PSWFLINKCONDID = 18;
    private static final int INDEX_PSWFLINKCONDNAME = 19;
    private static final int INDEX_PSWFLINKID = 20;
    private static final int INDEX_PSWFLINKNAME = 21;
    private static final int INDEX_PSWFVERSIONID = 22;
    private static final int INDEX_PSWFVERSIONNAME = 23;
    private static final int INDEX_UPDATEDATE = 24;
    private static final int INDEX_UPDATEMAN = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSWFLinkCondBase proxyPSWFLinkCondBase = null;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customdstparamDirtyFlag = false;
    private boolean dstpsdefidDirtyFlag = false;
    private boolean dstpsdefnameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean ppswflinkcondidDirtyFlag = false;
    private boolean ppswflinkcondnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pswflinkcondidDirtyFlag = false;
    private boolean pswflinkcondnameDirtyFlag = false;
    private boolean pswflinkidDirtyFlag = false;
    private boolean pswflinknameDirtyFlag = false;
    private boolean pswfversionidDirtyFlag = false;
    private boolean pswfversionnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customdstparam")
    private String customdstparam;
    @Column(name="dstpsdefid")
    private String dstpsdefid;
    @Column(name="dstpsdefname")
    private String dstpsdefname;
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
    @Column(name="ppswflinkcondid")
    private String ppswflinkcondid;
    @Column(name="ppswflinkcondname")
    private String ppswflinkcondname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pswflinkcondid")
    private String pswflinkcondid;
    @Column(name="pswflinkcondname")
    private String pswflinkcondname;
    @Column(name="pswflinkid")
    private String pswflinkid;
    @Column(name="pswflinkname")
    private String pswflinkname;
    @Column(name="pswfversionid")
    private String pswfversionid;
    @Column(name="pswfversionname")
    private String pswfversionname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBValueOPLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objDstPSDEFLock = new Integer(1);
    private PSDEField dstpsdef = null;
    private Integer objPPWFLinkCondLock = new Integer(1);
    private PSWFLinkCond ppwflinkcond = null;
    private Integer objPSWFLinkLock = new Integer(1);
    private PSWFLink pswflink = null;
    private Integer objPSWFVersionLock = new Integer(1);
    private PSWFVersion pswfversion = null;
    private Integer objPSWFLinkCondsLock = new Integer(1);
    private ArrayList<PSWFLinkCond> pswflinkconds = null;

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

    public void setPPSWFLinkCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSWFLinkCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppswflinkcondid = string;
        this.ppswflinkcondidDirtyFlag = true;
    }

    public String getPPSWFLinkCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSWFLinkCondId();
        }
        return this.ppswflinkcondid;
    }

    public boolean isPPSWFLinkCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSWFLinkCondIdDirty();
        }
        return this.ppswflinkcondidDirtyFlag;
    }

    public void resetPPSWFLinkCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSWFLinkCondId();
            return;
        }
        this.ppswflinkcondidDirtyFlag = false;
        this.ppswflinkcondid = null;
    }

    public void setPPSWFLinkCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSWFLinkCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppswflinkcondname = string;
        this.ppswflinkcondnameDirtyFlag = true;
    }

    public String getPPSWFLinkCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSWFLinkCondName();
        }
        return this.ppswflinkcondname;
    }

    public boolean isPPSWFLinkCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSWFLinkCondNameDirty();
        }
        return this.ppswflinkcondnameDirtyFlag;
    }

    public void resetPPSWFLinkCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSWFLinkCondName();
            return;
        }
        this.ppswflinkcondnameDirtyFlag = false;
        this.ppswflinkcondname = null;
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

    public void setPSWFLinkCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkcondid = string;
        this.pswflinkcondidDirtyFlag = true;
    }

    public String getPSWFLinkCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkCondId();
        }
        return this.pswflinkcondid;
    }

    public boolean isPSWFLinkCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkCondIdDirty();
        }
        return this.pswflinkcondidDirtyFlag;
    }

    public void resetPSWFLinkCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkCondId();
            return;
        }
        this.pswflinkcondidDirtyFlag = false;
        this.pswflinkcondid = null;
    }

    public void setPSWFLinkCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkcondname = string;
        this.pswflinkcondnameDirtyFlag = true;
    }

    public String getPSWFLinkCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkCondName();
        }
        return this.pswflinkcondname;
    }

    public boolean isPSWFLinkCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkCondNameDirty();
        }
        return this.pswflinkcondnameDirtyFlag;
    }

    public void resetPSWFLinkCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkCondName();
            return;
        }
        this.pswflinkcondnameDirtyFlag = false;
        this.pswflinkcondname = null;
    }

    public void setPSWFLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkid = string;
        this.pswflinkidDirtyFlag = true;
    }

    public String getPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkId();
        }
        return this.pswflinkid;
    }

    public boolean isPSWFLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkIdDirty();
        }
        return this.pswflinkidDirtyFlag;
    }

    public void resetPSWFLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkId();
            return;
        }
        this.pswflinkidDirtyFlag = false;
        this.pswflinkid = null;
    }

    public void setPSWFLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswflinkname = string;
        this.pswflinknameDirtyFlag = true;
    }

    public String getPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkName();
        }
        return this.pswflinkname;
    }

    public boolean isPSWFLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFLinkNameDirty();
        }
        return this.pswflinknameDirtyFlag;
    }

    public void resetPSWFLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFLinkName();
            return;
        }
        this.pswflinknameDirtyFlag = false;
        this.pswflinkname = null;
    }

    public void setPSWFVersionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionid = string;
        this.pswfversionidDirtyFlag = true;
    }

    public String getPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionId();
        }
        return this.pswfversionid;
    }

    public boolean isPSWFVersionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionIdDirty();
        }
        return this.pswfversionidDirtyFlag;
    }

    public void resetPSWFVersionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionId();
            return;
        }
        this.pswfversionidDirtyFlag = false;
        this.pswfversionid = null;
    }

    public void setPSWFVersionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSWFVersionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pswfversionname = string;
        this.pswfversionnameDirtyFlag = true;
    }

    public String getPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersionName();
        }
        return this.pswfversionname;
    }

    public boolean isPSWFVersionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSWFVersionNameDirty();
        }
        return this.pswfversionnameDirtyFlag;
    }

    public void resetPSWFVersionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSWFVersionName();
            return;
        }
        this.pswfversionnameDirtyFlag = false;
        this.pswfversionname = null;
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

    protected void onReset() {
        PSWFLinkCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSWFLinkCondBase pSWFLinkCondBase) {
        pSWFLinkCondBase.resetCondValue();
        pSWFLinkCondBase.resetCreateDate();
        pSWFLinkCondBase.resetCreateMan();
        pSWFLinkCondBase.resetCustomDSTParam();
        pSWFLinkCondBase.resetDstPSDEFId();
        pSWFLinkCondBase.resetDstPSDEFName();
        pSWFLinkCondBase.resetDynaModelFlag();
        pSWFLinkCondBase.resetGroupNotFlag();
        pSWFLinkCondBase.resetGroupOP();
        pSWFLinkCondBase.resetLogicType();
        pSWFLinkCondBase.resetMemo();
        pSWFLinkCondBase.resetOrderValue();
        pSWFLinkCondBase.resetParamType();
        pSWFLinkCondBase.resetPPSWFLinkCondId();
        pSWFLinkCondBase.resetPPSWFLinkCondName();
        pSWFLinkCondBase.resetPSDBValueOPId();
        pSWFLinkCondBase.resetPSDBValueOPName();
        pSWFLinkCondBase.resetPSDynaInstId();
        pSWFLinkCondBase.resetPSWFLinkCondId();
        pSWFLinkCondBase.resetPSWFLinkCondName();
        pSWFLinkCondBase.resetPSWFLinkId();
        pSWFLinkCondBase.resetPSWFLinkName();
        pSWFLinkCondBase.resetPSWFVersionId();
        pSWFLinkCondBase.resetPSWFVersionName();
        pSWFLinkCondBase.resetUpdateDate();
        pSWFLinkCondBase.resetUpdateMan();
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
        if (!bl || this.isDstPSDEFIdDirty()) {
            hashMap.put(FIELD_DSTPSDEFID, this.getDstPSDEFId());
        }
        if (!bl || this.isDstPSDEFNameDirty()) {
            hashMap.put(FIELD_DSTPSDEFNAME, this.getDstPSDEFName());
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
        if (!bl || this.isPPSWFLinkCondIdDirty()) {
            hashMap.put(FIELD_PPSWFLINKCONDID, this.getPPSWFLinkCondId());
        }
        if (!bl || this.isPPSWFLinkCondNameDirty()) {
            hashMap.put(FIELD_PPSWFLINKCONDNAME, this.getPPSWFLinkCondName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSWFLinkCondIdDirty()) {
            hashMap.put(FIELD_PSWFLINKCONDID, this.getPSWFLinkCondId());
        }
        if (!bl || this.isPSWFLinkCondNameDirty()) {
            hashMap.put(FIELD_PSWFLINKCONDNAME, this.getPSWFLinkCondName());
        }
        if (!bl || this.isPSWFLinkIdDirty()) {
            hashMap.put(FIELD_PSWFLINKID, this.getPSWFLinkId());
        }
        if (!bl || this.isPSWFLinkNameDirty()) {
            hashMap.put(FIELD_PSWFLINKNAME, this.getPSWFLinkName());
        }
        if (!bl || this.isPSWFVersionIdDirty()) {
            hashMap.put(FIELD_PSWFVERSIONID, this.getPSWFVersionId());
        }
        if (!bl || this.isPSWFVersionNameDirty()) {
            hashMap.put(FIELD_PSWFVERSIONNAME, this.getPSWFVersionName());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSWFLinkCondBase.get(this, n);
    }

    private static Object get(PSWFLinkCondBase pSWFLinkCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondBase.getCondValue();
            }
            case 1: {
                return pSWFLinkCondBase.getCreateDate();
            }
            case 2: {
                return pSWFLinkCondBase.getCreateMan();
            }
            case 3: {
                return pSWFLinkCondBase.getCustomDSTParam();
            }
            case 4: {
                return pSWFLinkCondBase.getDstPSDEFId();
            }
            case 5: {
                return pSWFLinkCondBase.getDstPSDEFName();
            }
            case 6: {
                return pSWFLinkCondBase.getDynaModelFlag();
            }
            case 7: {
                return pSWFLinkCondBase.getGroupNotFlag();
            }
            case 8: {
                return pSWFLinkCondBase.getGroupOP();
            }
            case 9: {
                return pSWFLinkCondBase.getLogicType();
            }
            case 10: {
                return pSWFLinkCondBase.getMemo();
            }
            case 11: {
                return pSWFLinkCondBase.getOrderValue();
            }
            case 12: {
                return pSWFLinkCondBase.getParamType();
            }
            case 13: {
                return pSWFLinkCondBase.getPPSWFLinkCondId();
            }
            case 14: {
                return pSWFLinkCondBase.getPPSWFLinkCondName();
            }
            case 15: {
                return pSWFLinkCondBase.getPSDBValueOPId();
            }
            case 16: {
                return pSWFLinkCondBase.getPSDBValueOPName();
            }
            case 17: {
                return pSWFLinkCondBase.getPSDynaInstId();
            }
            case 18: {
                return pSWFLinkCondBase.getPSWFLinkCondId();
            }
            case 19: {
                return pSWFLinkCondBase.getPSWFLinkCondName();
            }
            case 20: {
                return pSWFLinkCondBase.getPSWFLinkId();
            }
            case 21: {
                return pSWFLinkCondBase.getPSWFLinkName();
            }
            case 22: {
                return pSWFLinkCondBase.getPSWFVersionId();
            }
            case 23: {
                return pSWFLinkCondBase.getPSWFVersionName();
            }
            case 24: {
                return pSWFLinkCondBase.getUpdateDate();
            }
            case 25: {
                return pSWFLinkCondBase.getUpdateMan();
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
        PSWFLinkCondBase.set(this, n, object);
    }

    private static void set(PSWFLinkCondBase pSWFLinkCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSWFLinkCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSWFLinkCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSWFLinkCondBase.setCustomDSTParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSWFLinkCondBase.setDstPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSWFLinkCondBase.setDstPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSWFLinkCondBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSWFLinkCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSWFLinkCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSWFLinkCondBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSWFLinkCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSWFLinkCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSWFLinkCondBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSWFLinkCondBase.setPPSWFLinkCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSWFLinkCondBase.setPPSWFLinkCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSWFLinkCondBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSWFLinkCondBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSWFLinkCondBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSWFLinkCondBase.setPSWFLinkCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSWFLinkCondBase.setPSWFLinkCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSWFLinkCondBase.setPSWFLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSWFLinkCondBase.setPSWFLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSWFLinkCondBase.setPSWFVersionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSWFLinkCondBase.setPSWFVersionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSWFLinkCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 25: {
                pSWFLinkCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSWFLinkCondBase.isNull(this, n);
    }

    private static boolean isNull(PSWFLinkCondBase pSWFLinkCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondBase.getCondValue() == null;
            }
            case 1: {
                return pSWFLinkCondBase.getCreateDate() == null;
            }
            case 2: {
                return pSWFLinkCondBase.getCreateMan() == null;
            }
            case 3: {
                return pSWFLinkCondBase.getCustomDSTParam() == null;
            }
            case 4: {
                return pSWFLinkCondBase.getDstPSDEFId() == null;
            }
            case 5: {
                return pSWFLinkCondBase.getDstPSDEFName() == null;
            }
            case 6: {
                return pSWFLinkCondBase.getDynaModelFlag() == null;
            }
            case 7: {
                return pSWFLinkCondBase.getGroupNotFlag() == null;
            }
            case 8: {
                return pSWFLinkCondBase.getGroupOP() == null;
            }
            case 9: {
                return pSWFLinkCondBase.getLogicType() == null;
            }
            case 10: {
                return pSWFLinkCondBase.getMemo() == null;
            }
            case 11: {
                return pSWFLinkCondBase.getOrderValue() == null;
            }
            case 12: {
                return pSWFLinkCondBase.getParamType() == null;
            }
            case 13: {
                return pSWFLinkCondBase.getPPSWFLinkCondId() == null;
            }
            case 14: {
                return pSWFLinkCondBase.getPPSWFLinkCondName() == null;
            }
            case 15: {
                return pSWFLinkCondBase.getPSDBValueOPId() == null;
            }
            case 16: {
                return pSWFLinkCondBase.getPSDBValueOPName() == null;
            }
            case 17: {
                return pSWFLinkCondBase.getPSDynaInstId() == null;
            }
            case 18: {
                return pSWFLinkCondBase.getPSWFLinkCondId() == null;
            }
            case 19: {
                return pSWFLinkCondBase.getPSWFLinkCondName() == null;
            }
            case 20: {
                return pSWFLinkCondBase.getPSWFLinkId() == null;
            }
            case 21: {
                return pSWFLinkCondBase.getPSWFLinkName() == null;
            }
            case 22: {
                return pSWFLinkCondBase.getPSWFVersionId() == null;
            }
            case 23: {
                return pSWFLinkCondBase.getPSWFVersionName() == null;
            }
            case 24: {
                return pSWFLinkCondBase.getUpdateDate() == null;
            }
            case 25: {
                return pSWFLinkCondBase.getUpdateMan() == null;
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
        return PSWFLinkCondBase.contains(this, n);
    }

    private static boolean contains(PSWFLinkCondBase pSWFLinkCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSWFLinkCondBase.isCondValueDirty();
            }
            case 1: {
                return pSWFLinkCondBase.isCreateDateDirty();
            }
            case 2: {
                return pSWFLinkCondBase.isCreateManDirty();
            }
            case 3: {
                return pSWFLinkCondBase.isCustomDSTParamDirty();
            }
            case 4: {
                return pSWFLinkCondBase.isDstPSDEFIdDirty();
            }
            case 5: {
                return pSWFLinkCondBase.isDstPSDEFNameDirty();
            }
            case 6: {
                return pSWFLinkCondBase.isDynaModelFlagDirty();
            }
            case 7: {
                return pSWFLinkCondBase.isGroupNotFlagDirty();
            }
            case 8: {
                return pSWFLinkCondBase.isGroupOPDirty();
            }
            case 9: {
                return pSWFLinkCondBase.isLogicTypeDirty();
            }
            case 10: {
                return pSWFLinkCondBase.isMemoDirty();
            }
            case 11: {
                return pSWFLinkCondBase.isOrderValueDirty();
            }
            case 12: {
                return pSWFLinkCondBase.isParamTypeDirty();
            }
            case 13: {
                return pSWFLinkCondBase.isPPSWFLinkCondIdDirty();
            }
            case 14: {
                return pSWFLinkCondBase.isPPSWFLinkCondNameDirty();
            }
            case 15: {
                return pSWFLinkCondBase.isPSDBValueOPIdDirty();
            }
            case 16: {
                return pSWFLinkCondBase.isPSDBValueOPNameDirty();
            }
            case 17: {
                return pSWFLinkCondBase.isPSDynaInstIdDirty();
            }
            case 18: {
                return pSWFLinkCondBase.isPSWFLinkCondIdDirty();
            }
            case 19: {
                return pSWFLinkCondBase.isPSWFLinkCondNameDirty();
            }
            case 20: {
                return pSWFLinkCondBase.isPSWFLinkIdDirty();
            }
            case 21: {
                return pSWFLinkCondBase.isPSWFLinkNameDirty();
            }
            case 22: {
                return pSWFLinkCondBase.isPSWFVersionIdDirty();
            }
            case 23: {
                return pSWFLinkCondBase.isPSWFVersionNameDirty();
            }
            case 24: {
                return pSWFLinkCondBase.isUpdateDateDirty();
            }
            case 25: {
                return pSWFLinkCondBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSWFLinkCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSWFLinkCondBase pSWFLinkCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSWFLinkCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getCustomDSTParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customdstparam", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getCustomDSTParam()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getDstPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getDstPSDEFId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getDstPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdefname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getDstPSDEFName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getLogicType()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getParamType()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPPSWFLinkCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppswflinkcondid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPPSWFLinkCondId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPPSWFLinkCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppswflinkcondname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPPSWFLinkCondName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkcondid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFLinkCondId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkcondname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFLinkCondName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFLinkId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswflinkname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFLinkName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFVersionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionid", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFVersionId()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getPSWFVersionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pswfversionname", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getPSWFVersionName()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSWFLinkCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSWFLinkCondBase.getJSONValue((Object)pSWFLinkCondBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSWFLinkCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSWFLinkCondBase pSWFLinkCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSWFLinkCondBase.getCondValue() != null) {
            object = pSWFLinkCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getCreateDate() != null) {
            object = pSWFLinkCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkCondBase.getCreateMan() != null) {
            object = pSWFLinkCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getCustomDSTParam() != null) {
            object = pSWFLinkCondBase.getCustomDSTParam();
            xmlNode.setAttribute(FIELD_CUSTOMDSTPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getDstPSDEFId() != null) {
            object = pSWFLinkCondBase.getDstPSDEFId();
            xmlNode.setAttribute(FIELD_DSTPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getDstPSDEFName() != null) {
            object = pSWFLinkCondBase.getDstPSDEFName();
            xmlNode.setAttribute(FIELD_DSTPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getDynaModelFlag() != null) {
            object = pSWFLinkCondBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkCondBase.getGroupNotFlag() != null) {
            object = pSWFLinkCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkCondBase.getGroupOP() != null) {
            object = pSWFLinkCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getLogicType() != null) {
            object = pSWFLinkCondBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getMemo() != null) {
            object = pSWFLinkCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getOrderValue() != null) {
            object = pSWFLinkCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSWFLinkCondBase.getParamType() != null) {
            object = pSWFLinkCondBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPPSWFLinkCondId() != null) {
            object = pSWFLinkCondBase.getPPSWFLinkCondId();
            xmlNode.setAttribute(FIELD_PPSWFLINKCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPPSWFLinkCondName() != null) {
            object = pSWFLinkCondBase.getPPSWFLinkCondName();
            xmlNode.setAttribute(FIELD_PPSWFLINKCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSDBValueOPId() != null) {
            object = pSWFLinkCondBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSDBValueOPName() != null) {
            object = pSWFLinkCondBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSDynaInstId() != null) {
            object = pSWFLinkCondBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkCondId() != null) {
            object = pSWFLinkCondBase.getPSWFLinkCondId();
            xmlNode.setAttribute(FIELD_PSWFLINKCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkCondName() != null) {
            object = pSWFLinkCondBase.getPSWFLinkCondName();
            xmlNode.setAttribute(FIELD_PSWFLINKCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkId() != null) {
            object = pSWFLinkCondBase.getPSWFLinkId();
            xmlNode.setAttribute(FIELD_PSWFLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFLinkName() != null) {
            object = pSWFLinkCondBase.getPSWFLinkName();
            xmlNode.setAttribute(FIELD_PSWFLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFVersionId() != null) {
            object = pSWFLinkCondBase.getPSWFVersionId();
            xmlNode.setAttribute(FIELD_PSWFVERSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getPSWFVersionName() != null) {
            object = pSWFLinkCondBase.getPSWFVersionName();
            xmlNode.setAttribute(FIELD_PSWFVERSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSWFLinkCondBase.getUpdateDate() != null) {
            object = pSWFLinkCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSWFLinkCondBase.getUpdateMan() != null) {
            object = pSWFLinkCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSWFLinkCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSWFLinkCondBase pSWFLinkCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSWFLinkCondBase.isCondValueDirty() && (bl || pSWFLinkCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSWFLinkCondBase.getCondValue());
        }
        if (pSWFLinkCondBase.isCreateDateDirty() && (bl || pSWFLinkCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSWFLinkCondBase.getCreateDate());
        }
        if (pSWFLinkCondBase.isCreateManDirty() && (bl || pSWFLinkCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSWFLinkCondBase.getCreateMan());
        }
        if (pSWFLinkCondBase.isCustomDSTParamDirty() && (bl || pSWFLinkCondBase.getCustomDSTParam() != null)) {
            iDataObject.set(FIELD_CUSTOMDSTPARAM, (Object)pSWFLinkCondBase.getCustomDSTParam());
        }
        if (pSWFLinkCondBase.isDstPSDEFIdDirty() && (bl || pSWFLinkCondBase.getDstPSDEFId() != null)) {
            iDataObject.set(FIELD_DSTPSDEFID, (Object)pSWFLinkCondBase.getDstPSDEFId());
        }
        if (pSWFLinkCondBase.isDstPSDEFNameDirty() && (bl || pSWFLinkCondBase.getDstPSDEFName() != null)) {
            iDataObject.set(FIELD_DSTPSDEFNAME, (Object)pSWFLinkCondBase.getDstPSDEFName());
        }
        if (pSWFLinkCondBase.isDynaModelFlagDirty() && (bl || pSWFLinkCondBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSWFLinkCondBase.getDynaModelFlag());
        }
        if (pSWFLinkCondBase.isGroupNotFlagDirty() && (bl || pSWFLinkCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSWFLinkCondBase.getGroupNotFlag());
        }
        if (pSWFLinkCondBase.isGroupOPDirty() && (bl || pSWFLinkCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSWFLinkCondBase.getGroupOP());
        }
        if (pSWFLinkCondBase.isLogicTypeDirty() && (bl || pSWFLinkCondBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSWFLinkCondBase.getLogicType());
        }
        if (pSWFLinkCondBase.isMemoDirty() && (bl || pSWFLinkCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSWFLinkCondBase.getMemo());
        }
        if (pSWFLinkCondBase.isOrderValueDirty() && (bl || pSWFLinkCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSWFLinkCondBase.getOrderValue());
        }
        if (pSWFLinkCondBase.isParamTypeDirty() && (bl || pSWFLinkCondBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSWFLinkCondBase.getParamType());
        }
        if (pSWFLinkCondBase.isPPSWFLinkCondIdDirty() && (bl || pSWFLinkCondBase.getPPSWFLinkCondId() != null)) {
            iDataObject.set(FIELD_PPSWFLINKCONDID, (Object)pSWFLinkCondBase.getPPSWFLinkCondId());
        }
        if (pSWFLinkCondBase.isPPSWFLinkCondNameDirty() && (bl || pSWFLinkCondBase.getPPSWFLinkCondName() != null)) {
            iDataObject.set(FIELD_PPSWFLINKCONDNAME, (Object)pSWFLinkCondBase.getPPSWFLinkCondName());
        }
        if (pSWFLinkCondBase.isPSDBValueOPIdDirty() && (bl || pSWFLinkCondBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSWFLinkCondBase.getPSDBValueOPId());
        }
        if (pSWFLinkCondBase.isPSDBValueOPNameDirty() && (bl || pSWFLinkCondBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSWFLinkCondBase.getPSDBValueOPName());
        }
        if (pSWFLinkCondBase.isPSDynaInstIdDirty() && (bl || pSWFLinkCondBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSWFLinkCondBase.getPSDynaInstId());
        }
        if (pSWFLinkCondBase.isPSWFLinkCondIdDirty() && (bl || pSWFLinkCondBase.getPSWFLinkCondId() != null)) {
            iDataObject.set(FIELD_PSWFLINKCONDID, (Object)pSWFLinkCondBase.getPSWFLinkCondId());
        }
        if (pSWFLinkCondBase.isPSWFLinkCondNameDirty() && (bl || pSWFLinkCondBase.getPSWFLinkCondName() != null)) {
            iDataObject.set(FIELD_PSWFLINKCONDNAME, (Object)pSWFLinkCondBase.getPSWFLinkCondName());
        }
        if (pSWFLinkCondBase.isPSWFLinkIdDirty() && (bl || pSWFLinkCondBase.getPSWFLinkId() != null)) {
            iDataObject.set(FIELD_PSWFLINKID, (Object)pSWFLinkCondBase.getPSWFLinkId());
        }
        if (pSWFLinkCondBase.isPSWFLinkNameDirty() && (bl || pSWFLinkCondBase.getPSWFLinkName() != null)) {
            iDataObject.set(FIELD_PSWFLINKNAME, (Object)pSWFLinkCondBase.getPSWFLinkName());
        }
        if (pSWFLinkCondBase.isPSWFVersionIdDirty() && (bl || pSWFLinkCondBase.getPSWFVersionId() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONID, (Object)pSWFLinkCondBase.getPSWFVersionId());
        }
        if (pSWFLinkCondBase.isPSWFVersionNameDirty() && (bl || pSWFLinkCondBase.getPSWFVersionName() != null)) {
            iDataObject.set(FIELD_PSWFVERSIONNAME, (Object)pSWFLinkCondBase.getPSWFVersionName());
        }
        if (pSWFLinkCondBase.isUpdateDateDirty() && (bl || pSWFLinkCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSWFLinkCondBase.getUpdateDate());
        }
        if (pSWFLinkCondBase.isUpdateManDirty() && (bl || pSWFLinkCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSWFLinkCondBase.getUpdateMan());
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
        return PSWFLinkCondBase.remove(this, n);
    }

    private static boolean remove(PSWFLinkCondBase pSWFLinkCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSWFLinkCondBase.resetCondValue();
                return true;
            }
            case 1: {
                pSWFLinkCondBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSWFLinkCondBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSWFLinkCondBase.resetCustomDSTParam();
                return true;
            }
            case 4: {
                pSWFLinkCondBase.resetDstPSDEFId();
                return true;
            }
            case 5: {
                pSWFLinkCondBase.resetDstPSDEFName();
                return true;
            }
            case 6: {
                pSWFLinkCondBase.resetDynaModelFlag();
                return true;
            }
            case 7: {
                pSWFLinkCondBase.resetGroupNotFlag();
                return true;
            }
            case 8: {
                pSWFLinkCondBase.resetGroupOP();
                return true;
            }
            case 9: {
                pSWFLinkCondBase.resetLogicType();
                return true;
            }
            case 10: {
                pSWFLinkCondBase.resetMemo();
                return true;
            }
            case 11: {
                pSWFLinkCondBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSWFLinkCondBase.resetParamType();
                return true;
            }
            case 13: {
                pSWFLinkCondBase.resetPPSWFLinkCondId();
                return true;
            }
            case 14: {
                pSWFLinkCondBase.resetPPSWFLinkCondName();
                return true;
            }
            case 15: {
                pSWFLinkCondBase.resetPSDBValueOPId();
                return true;
            }
            case 16: {
                pSWFLinkCondBase.resetPSDBValueOPName();
                return true;
            }
            case 17: {
                pSWFLinkCondBase.resetPSDynaInstId();
                return true;
            }
            case 18: {
                pSWFLinkCondBase.resetPSWFLinkCondId();
                return true;
            }
            case 19: {
                pSWFLinkCondBase.resetPSWFLinkCondName();
                return true;
            }
            case 20: {
                pSWFLinkCondBase.resetPSWFLinkId();
                return true;
            }
            case 21: {
                pSWFLinkCondBase.resetPSWFLinkName();
                return true;
            }
            case 22: {
                pSWFLinkCondBase.resetPSWFVersionId();
                return true;
            }
            case 23: {
                pSWFLinkCondBase.resetPSWFVersionName();
                return true;
            }
            case 24: {
                pSWFLinkCondBase.resetUpdateDate();
                return true;
            }
            case 25: {
                pSWFLinkCondBase.resetUpdateMan();
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
                pSDBValueOPService.autoGet(pSDBValueOP);
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
                pSDEFieldService.autoGet(pSDEField);
                this.dstpsdef = pSDEField;
            }
            return this.dstpsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFLinkCond getPPWFLinkCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPWFLinkCond();
        }
        if (this.getPPSWFLinkCondId() == null) {
            return null;
        }
        Integer n = this.objPPWFLinkCondLock;
        synchronized (n) {
            if (this.ppwflinkcond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSWFLinkCondId(), (Object)this.ppwflinkcond.getPSWFLinkCondId()) != 0L) {
                this.ppwflinkcond = null;
            }
            if (this.ppwflinkcond == null) {
                PSWFLinkCond pSWFLinkCond = new PSWFLinkCond();
                pSWFLinkCond.setPSWFLinkCondId(this.getPPSWFLinkCondId());
                PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
                pSWFLinkCondService.autoGet(pSWFLinkCond);
                this.ppwflinkcond = pSWFLinkCond;
            }
            return this.ppwflinkcond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFLink getPSWFLink() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLink();
        }
        if (this.getPSWFLinkId() == null) {
            return null;
        }
        Integer n = this.objPSWFLinkLock;
        synchronized (n) {
            if (this.pswflink != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFLinkId(), (Object)this.pswflink.getPSWFLinkId()) != 0L) {
                this.pswflink = null;
            }
            if (this.pswflink == null) {
                PSWFLink pSWFLink = new PSWFLink();
                pSWFLink.setPSWFLinkId(this.getPSWFLinkId());
                PSWFLinkService pSWFLinkService = (PSWFLinkService)ServiceGlobal.getService(PSWFLinkService.class, (SessionFactory)this.getSessionFactory());
                pSWFLinkService.autoGet(pSWFLink);
                this.pswflink = pSWFLink;
            }
            return this.pswflink;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSWFVersion getPSWFVersion() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFVersion();
        }
        if (this.getPSWFVersionId() == null) {
            return null;
        }
        Integer n = this.objPSWFVersionLock;
        synchronized (n) {
            if (this.pswfversion != null && DataTypeHelper.compare((int)25, (Object)this.getPSWFVersionId(), (Object)this.pswfversion.getPSWFVersionId()) != 0L) {
                this.pswfversion = null;
            }
            if (this.pswfversion == null) {
                PSWFVersion pSWFVersion = new PSWFVersion();
                pSWFVersion.setPSWFVersionId(this.getPSWFVersionId());
                PSWFVersionService pSWFVersionService = (PSWFVersionService)ServiceGlobal.getService(PSWFVersionService.class, (SessionFactory)this.getSessionFactory());
                pSWFVersionService.autoGet(pSWFVersion);
                this.pswfversion = pSWFVersion;
            }
            return this.pswfversion;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSWFLinkCond> getPSWFLinkConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSWFLinkConds();
        }
        if (this.getPSWFLinkCondId() == null) {
            return null;
        }
        PSWFLinkCondService pSWFLinkCondService = (PSWFLinkCondService)ServiceGlobal.getService(PSWFLinkCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSWFLinkCondsLock;
        synchronized (n) {
            if (this.pswflinkconds == null) {
                this.pswflinkconds = pSWFLinkCondService.selectByPPWFLinkCond(this);
            }
            return this.pswflinkconds;
        }
    }

    private PSWFLinkCondBase getProxyEntity() {
        return this.proxyPSWFLinkCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSWFLinkCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSWFLinkCondBase) {
            this.proxyPSWFLinkCondBase = (PSWFLinkCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.wfdesign.service.PSWFLinkCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDVALUE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMDSTPARAM, 3);
        fieldIndexMap.put(FIELD_DSTPSDEFID, 4);
        fieldIndexMap.put(FIELD_DSTPSDEFNAME, 5);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 6);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 7);
        fieldIndexMap.put(FIELD_GROUPOP, 8);
        fieldIndexMap.put(FIELD_LOGICTYPE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PARAMTYPE, 12);
        fieldIndexMap.put(FIELD_PPSWFLINKCONDID, 13);
        fieldIndexMap.put(FIELD_PPSWFLINKCONDNAME, 14);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 15);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 16);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 17);
        fieldIndexMap.put(FIELD_PSWFLINKCONDID, 18);
        fieldIndexMap.put(FIELD_PSWFLINKCONDNAME, 19);
        fieldIndexMap.put(FIELD_PSWFLINKID, 20);
        fieldIndexMap.put(FIELD_PSWFLINKNAME, 21);
        fieldIndexMap.put(FIELD_PSWFVERSIONID, 22);
        fieldIndexMap.put(FIELD_PSWFVERSIONNAME, 23);
        fieldIndexMap.put(FIELD_UPDATEDATE, 24);
        fieldIndexMap.put(FIELD_UPDATEMAN, 25);
    }
}

