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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFDLogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEForm;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEFormDetail;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFormService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEFDLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEFDLogicBase.class);
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_FDNAME = "FDNAME";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_LOGICCAT = "LOGICCAT";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDEFDLOGICID = "PPSDEFDLOGICID";
    public static final String FIELD_PPSDEFDLOGICNAME = "PPSDEFDLOGICNAME";
    public static final String FIELD_PSDBVALUEOPID = "PSDBVALUEOPID";
    public static final String FIELD_PSDBVALUEOPNAME = "PSDBVALUEOPNAME";
    public static final String FIELD_PSDEFDLOGICID = "PSDEFDLOGICID";
    public static final String FIELD_PSDEFDLOGICNAME = "PSDEFDLOGICNAME";
    public static final String FIELD_PSDEFORMDETAILID = "PSDEFORMDETAILID";
    public static final String FIELD_PSDEFORMDETAILNAME = "PSDEFORMDETAILNAME";
    public static final String FIELD_PSDEFORMID = "PSDEFORMID";
    public static final String FIELD_PSDEFORMNAME = "PSDEFORMNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDVALUE = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CUSTOMCODE = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_FDNAME = 5;
    private static final int INDEX_GROUPNOTFLAG = 6;
    private static final int INDEX_GROUPOP = 7;
    private static final int INDEX_LOGICCAT = 8;
    private static final int INDEX_LOGICTYPE = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PPSDEFDLOGICID = 11;
    private static final int INDEX_PPSDEFDLOGICNAME = 12;
    private static final int INDEX_PSDBVALUEOPID = 13;
    private static final int INDEX_PSDBVALUEOPNAME = 14;
    private static final int INDEX_PSDEFDLOGICID = 15;
    private static final int INDEX_PSDEFDLOGICNAME = 16;
    private static final int INDEX_PSDEFORMDETAILID = 17;
    private static final int INDEX_PSDEFORMDETAILNAME = 18;
    private static final int INDEX_PSDEFORMID = 19;
    private static final int INDEX_PSDEFORMNAME = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEFDLogicBase proxyPSDEFDLogicBase = null;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean fdnameDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean logiccatDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdefdlogicidDirtyFlag = false;
    private boolean ppsdefdlogicnameDirtyFlag = false;
    private boolean psdbvalueopidDirtyFlag = false;
    private boolean psdbvalueopnameDirtyFlag = false;
    private boolean psdefdlogicidDirtyFlag = false;
    private boolean psdefdlogicnameDirtyFlag = false;
    private boolean psdeformdetailidDirtyFlag = false;
    private boolean psdeformdetailnameDirtyFlag = false;
    private boolean psdeformidDirtyFlag = false;
    private boolean psdeformnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="fdname")
    private String fdname;
    @Column(name="groupnotflag")
    private Integer groupnotflag;
    @Column(name="groupop")
    private String groupop;
    @Column(name="logiccat")
    private String logiccat;
    @Column(name="logictype")
    private String logictype;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdefdlogicid")
    private String ppsdefdlogicid;
    @Column(name="ppsdefdlogicname")
    private String ppsdefdlogicname;
    @Column(name="psdbvalueopid")
    private String psdbvalueopid;
    @Column(name="psdbvalueopname")
    private String psdbvalueopname;
    @Column(name="psdefdlogicid")
    private String psdefdlogicid;
    @Column(name="psdefdlogicname")
    private String psdefdlogicname;
    @Column(name="psdeformdetailid")
    private String psdeformdetailid;
    @Column(name="psdeformdetailname")
    private String psdeformdetailname;
    @Column(name="psdeformid")
    private String psdeformid;
    @Column(name="psdeformname")
    private String psdeformname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSDBValueOpLock = new Integer(1);
    private PSDBValueOP psdbvalueop = null;
    private Integer objPPSDEFDLogicLock = new Integer(1);
    private PSDEFDLogic ppsdefdlogic = null;
    private Integer objPSDEFormDetailLock = new Integer(1);
    private PSDEFormDetail psdeformdetail = null;
    private Integer objPSDEFormLock = new Integer(1);
    private PSDEForm psdeform = null;
    private Integer objPSDEFDLogicsLock = new Integer(1);
    private ArrayList<PSDEFDLogic> psdefdlogics = null;

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

    public void setCustomCode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomCode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.customcode = string;
        this.customcodeDirtyFlag = true;
    }

    public String getCustomCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomCode();
        }
        return this.customcode;
    }

    public boolean isCustomCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomCodeDirty();
        }
        return this.customcodeDirtyFlag;
    }

    public void resetCustomCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomCode();
            return;
        }
        this.customcodeDirtyFlag = false;
        this.customcode = null;
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

    public void setFDName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFDName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fdname = string;
        this.fdnameDirtyFlag = true;
    }

    public String getFDName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFDName();
        }
        return this.fdname;
    }

    public boolean isFDNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFDNameDirty();
        }
        return this.fdnameDirtyFlag;
    }

    public void resetFDName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFDName();
            return;
        }
        this.fdnameDirtyFlag = false;
        this.fdname = null;
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

    public void setLogicCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logiccat = string;
        this.logiccatDirtyFlag = true;
    }

    public String getLogicCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicCat();
        }
        return this.logiccat;
    }

    public boolean isLogicCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicCatDirty();
        }
        return this.logiccatDirtyFlag;
    }

    public void resetLogicCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicCat();
            return;
        }
        this.logiccatDirtyFlag = false;
        this.logiccat = null;
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

    public void setPPSDEFDLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFDLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdefdlogicid = string;
        this.ppsdefdlogicidDirtyFlag = true;
    }

    public String getPPSDEFDLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFDLogicId();
        }
        return this.ppsdefdlogicid;
    }

    public boolean isPPSDEFDLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFDLogicIdDirty();
        }
        return this.ppsdefdlogicidDirtyFlag;
    }

    public void resetPPSDEFDLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFDLogicId();
            return;
        }
        this.ppsdefdlogicidDirtyFlag = false;
        this.ppsdefdlogicid = null;
    }

    public void setPPSDEFDLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDEFDLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdefdlogicname = string;
        this.ppsdefdlogicnameDirtyFlag = true;
    }

    public String getPPSDEFDLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFDLogicName();
        }
        return this.ppsdefdlogicname;
    }

    public boolean isPPSDEFDLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDEFDLogicNameDirty();
        }
        return this.ppsdefdlogicnameDirtyFlag;
    }

    public void resetPPSDEFDLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDEFDLogicName();
            return;
        }
        this.ppsdefdlogicnameDirtyFlag = false;
        this.ppsdefdlogicname = null;
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

    public void setPSDEFDLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefdlogicid = string;
        this.psdefdlogicidDirtyFlag = true;
    }

    public String getPSDEFDLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDLogicId();
        }
        return this.psdefdlogicid;
    }

    public boolean isPSDEFDLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDLogicIdDirty();
        }
        return this.psdefdlogicidDirtyFlag;
    }

    public void resetPSDEFDLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDLogicId();
            return;
        }
        this.psdefdlogicidDirtyFlag = false;
        this.psdefdlogicid = null;
    }

    public void setPSDEFDLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFDLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefdlogicname = string;
        this.psdefdlogicnameDirtyFlag = true;
    }

    public String getPSDEFDLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDLogicName();
        }
        return this.psdefdlogicname;
    }

    public boolean isPSDEFDLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFDLogicNameDirty();
        }
        return this.psdefdlogicnameDirtyFlag;
    }

    public void resetPSDEFDLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFDLogicName();
            return;
        }
        this.psdefdlogicnameDirtyFlag = false;
        this.psdefdlogicname = null;
    }

    public void setPSDEFormDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailid = string;
        this.psdeformdetailidDirtyFlag = true;
    }

    public String getPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailId();
        }
        return this.psdeformdetailid;
    }

    public boolean isPSDEFormDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailIdDirty();
        }
        return this.psdeformdetailidDirtyFlag;
    }

    public void resetPSDEFormDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailId();
            return;
        }
        this.psdeformdetailidDirtyFlag = false;
        this.psdeformdetailid = null;
    }

    public void setPSDEFormDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformdetailname = string;
        this.psdeformdetailnameDirtyFlag = true;
    }

    public String getPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetailName();
        }
        return this.psdeformdetailname;
    }

    public boolean isPSDEFormDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormDetailNameDirty();
        }
        return this.psdeformdetailnameDirtyFlag;
    }

    public void resetPSDEFormDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormDetailName();
            return;
        }
        this.psdeformdetailnameDirtyFlag = false;
        this.psdeformdetailname = null;
    }

    public void setPSDEFormId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformid = string;
        this.psdeformidDirtyFlag = true;
    }

    public String getPSDEFormId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormId();
        }
        return this.psdeformid;
    }

    public boolean isPSDEFormIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormIdDirty();
        }
        return this.psdeformidDirtyFlag;
    }

    public void resetPSDEFormId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormId();
            return;
        }
        this.psdeformidDirtyFlag = false;
        this.psdeformid = null;
    }

    public void setPSDEFormName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFormName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeformname = string;
        this.psdeformnameDirtyFlag = true;
    }

    public String getPSDEFormName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormName();
        }
        return this.psdeformname;
    }

    public boolean isPSDEFormNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFormNameDirty();
        }
        return this.psdeformnameDirtyFlag;
    }

    public void resetPSDEFormName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFormName();
            return;
        }
        this.psdeformnameDirtyFlag = false;
        this.psdeformname = null;
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
        PSDEFDLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEFDLogicBase pSDEFDLogicBase) {
        pSDEFDLogicBase.resetCondValue();
        pSDEFDLogicBase.resetCreateDate();
        pSDEFDLogicBase.resetCreateMan();
        pSDEFDLogicBase.resetCustomCode();
        pSDEFDLogicBase.resetDynaModelFlag();
        pSDEFDLogicBase.resetFDName();
        pSDEFDLogicBase.resetGroupNotFlag();
        pSDEFDLogicBase.resetGroupOP();
        pSDEFDLogicBase.resetLogicCat();
        pSDEFDLogicBase.resetLogicType();
        pSDEFDLogicBase.resetOrderValue();
        pSDEFDLogicBase.resetPPSDEFDLogicId();
        pSDEFDLogicBase.resetPPSDEFDLogicName();
        pSDEFDLogicBase.resetPSDBValueOPId();
        pSDEFDLogicBase.resetPSDBValueOPName();
        pSDEFDLogicBase.resetPSDEFDLogicId();
        pSDEFDLogicBase.resetPSDEFDLogicName();
        pSDEFDLogicBase.resetPSDEFormDetailId();
        pSDEFDLogicBase.resetPSDEFormDetailName();
        pSDEFDLogicBase.resetPSDEFormId();
        pSDEFDLogicBase.resetPSDEFormName();
        pSDEFDLogicBase.resetPSDynaInstId();
        pSDEFDLogicBase.resetUpdateDate();
        pSDEFDLogicBase.resetUpdateMan();
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isFDNameDirty()) {
            hashMap.put(FIELD_FDNAME, this.getFDName());
        }
        if (!bl || this.isGroupNotFlagDirty()) {
            hashMap.put(FIELD_GROUPNOTFLAG, this.getGroupNotFlag());
        }
        if (!bl || this.isGroupOPDirty()) {
            hashMap.put(FIELD_GROUPOP, this.getGroupOP());
        }
        if (!bl || this.isLogicCatDirty()) {
            hashMap.put(FIELD_LOGICCAT, this.getLogicCat());
        }
        if (!bl || this.isLogicTypeDirty()) {
            hashMap.put(FIELD_LOGICTYPE, this.getLogicType());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDEFDLogicIdDirty()) {
            hashMap.put(FIELD_PPSDEFDLOGICID, this.getPPSDEFDLogicId());
        }
        if (!bl || this.isPPSDEFDLogicNameDirty()) {
            hashMap.put(FIELD_PPSDEFDLOGICNAME, this.getPPSDEFDLogicName());
        }
        if (!bl || this.isPSDBValueOPIdDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPID, this.getPSDBValueOPId());
        }
        if (!bl || this.isPSDBValueOPNameDirty()) {
            hashMap.put(FIELD_PSDBVALUEOPNAME, this.getPSDBValueOPName());
        }
        if (!bl || this.isPSDEFDLogicIdDirty()) {
            hashMap.put(FIELD_PSDEFDLOGICID, this.getPSDEFDLogicId());
        }
        if (!bl || this.isPSDEFDLogicNameDirty()) {
            hashMap.put(FIELD_PSDEFDLOGICNAME, this.getPSDEFDLogicName());
        }
        if (!bl || this.isPSDEFormDetailIdDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILID, this.getPSDEFormDetailId());
        }
        if (!bl || this.isPSDEFormDetailNameDirty()) {
            hashMap.put(FIELD_PSDEFORMDETAILNAME, this.getPSDEFormDetailName());
        }
        if (!bl || this.isPSDEFormIdDirty()) {
            hashMap.put(FIELD_PSDEFORMID, this.getPSDEFormId());
        }
        if (!bl || this.isPSDEFormNameDirty()) {
            hashMap.put(FIELD_PSDEFORMNAME, this.getPSDEFormName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
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
        return PSDEFDLogicBase.get(this, n);
    }

    private static Object get(PSDEFDLogicBase pSDEFDLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDLogicBase.getCondValue();
            }
            case 1: {
                return pSDEFDLogicBase.getCreateDate();
            }
            case 2: {
                return pSDEFDLogicBase.getCreateMan();
            }
            case 3: {
                return pSDEFDLogicBase.getCustomCode();
            }
            case 4: {
                return pSDEFDLogicBase.getDynaModelFlag();
            }
            case 5: {
                return pSDEFDLogicBase.getFDName();
            }
            case 6: {
                return pSDEFDLogicBase.getGroupNotFlag();
            }
            case 7: {
                return pSDEFDLogicBase.getGroupOP();
            }
            case 8: {
                return pSDEFDLogicBase.getLogicCat();
            }
            case 9: {
                return pSDEFDLogicBase.getLogicType();
            }
            case 10: {
                return pSDEFDLogicBase.getOrderValue();
            }
            case 11: {
                return pSDEFDLogicBase.getPPSDEFDLogicId();
            }
            case 12: {
                return pSDEFDLogicBase.getPPSDEFDLogicName();
            }
            case 13: {
                return pSDEFDLogicBase.getPSDBValueOPId();
            }
            case 14: {
                return pSDEFDLogicBase.getPSDBValueOPName();
            }
            case 15: {
                return pSDEFDLogicBase.getPSDEFDLogicId();
            }
            case 16: {
                return pSDEFDLogicBase.getPSDEFDLogicName();
            }
            case 17: {
                return pSDEFDLogicBase.getPSDEFormDetailId();
            }
            case 18: {
                return pSDEFDLogicBase.getPSDEFormDetailName();
            }
            case 19: {
                return pSDEFDLogicBase.getPSDEFormId();
            }
            case 20: {
                return pSDEFDLogicBase.getPSDEFormName();
            }
            case 21: {
                return pSDEFDLogicBase.getPSDynaInstId();
            }
            case 22: {
                return pSDEFDLogicBase.getUpdateDate();
            }
            case 23: {
                return pSDEFDLogicBase.getUpdateMan();
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
        PSDEFDLogicBase.set(this, n, object);
    }

    private static void set(PSDEFDLogicBase pSDEFDLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDLogicBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEFDLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDEFDLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEFDLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEFDLogicBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDEFDLogicBase.setFDName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEFDLogicBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDEFDLogicBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEFDLogicBase.setLogicCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEFDLogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEFDLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEFDLogicBase.setPPSDEFDLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEFDLogicBase.setPPSDEFDLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEFDLogicBase.setPSDBValueOPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEFDLogicBase.setPSDBValueOPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEFDLogicBase.setPSDEFDLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEFDLogicBase.setPSDEFDLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEFDLogicBase.setPSDEFormDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEFDLogicBase.setPSDEFormDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEFDLogicBase.setPSDEFormId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEFDLogicBase.setPSDEFormName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEFDLogicBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEFDLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSDEFDLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSDEFDLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSDEFDLogicBase pSDEFDLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDLogicBase.getCondValue() == null;
            }
            case 1: {
                return pSDEFDLogicBase.getCreateDate() == null;
            }
            case 2: {
                return pSDEFDLogicBase.getCreateMan() == null;
            }
            case 3: {
                return pSDEFDLogicBase.getCustomCode() == null;
            }
            case 4: {
                return pSDEFDLogicBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSDEFDLogicBase.getFDName() == null;
            }
            case 6: {
                return pSDEFDLogicBase.getGroupNotFlag() == null;
            }
            case 7: {
                return pSDEFDLogicBase.getGroupOP() == null;
            }
            case 8: {
                return pSDEFDLogicBase.getLogicCat() == null;
            }
            case 9: {
                return pSDEFDLogicBase.getLogicType() == null;
            }
            case 10: {
                return pSDEFDLogicBase.getOrderValue() == null;
            }
            case 11: {
                return pSDEFDLogicBase.getPPSDEFDLogicId() == null;
            }
            case 12: {
                return pSDEFDLogicBase.getPPSDEFDLogicName() == null;
            }
            case 13: {
                return pSDEFDLogicBase.getPSDBValueOPId() == null;
            }
            case 14: {
                return pSDEFDLogicBase.getPSDBValueOPName() == null;
            }
            case 15: {
                return pSDEFDLogicBase.getPSDEFDLogicId() == null;
            }
            case 16: {
                return pSDEFDLogicBase.getPSDEFDLogicName() == null;
            }
            case 17: {
                return pSDEFDLogicBase.getPSDEFormDetailId() == null;
            }
            case 18: {
                return pSDEFDLogicBase.getPSDEFormDetailName() == null;
            }
            case 19: {
                return pSDEFDLogicBase.getPSDEFormId() == null;
            }
            case 20: {
                return pSDEFDLogicBase.getPSDEFormName() == null;
            }
            case 21: {
                return pSDEFDLogicBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSDEFDLogicBase.getUpdateDate() == null;
            }
            case 23: {
                return pSDEFDLogicBase.getUpdateMan() == null;
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
        return PSDEFDLogicBase.contains(this, n);
    }

    private static boolean contains(PSDEFDLogicBase pSDEFDLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEFDLogicBase.isCondValueDirty();
            }
            case 1: {
                return pSDEFDLogicBase.isCreateDateDirty();
            }
            case 2: {
                return pSDEFDLogicBase.isCreateManDirty();
            }
            case 3: {
                return pSDEFDLogicBase.isCustomCodeDirty();
            }
            case 4: {
                return pSDEFDLogicBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSDEFDLogicBase.isFDNameDirty();
            }
            case 6: {
                return pSDEFDLogicBase.isGroupNotFlagDirty();
            }
            case 7: {
                return pSDEFDLogicBase.isGroupOPDirty();
            }
            case 8: {
                return pSDEFDLogicBase.isLogicCatDirty();
            }
            case 9: {
                return pSDEFDLogicBase.isLogicTypeDirty();
            }
            case 10: {
                return pSDEFDLogicBase.isOrderValueDirty();
            }
            case 11: {
                return pSDEFDLogicBase.isPPSDEFDLogicIdDirty();
            }
            case 12: {
                return pSDEFDLogicBase.isPPSDEFDLogicNameDirty();
            }
            case 13: {
                return pSDEFDLogicBase.isPSDBValueOPIdDirty();
            }
            case 14: {
                return pSDEFDLogicBase.isPSDBValueOPNameDirty();
            }
            case 15: {
                return pSDEFDLogicBase.isPSDEFDLogicIdDirty();
            }
            case 16: {
                return pSDEFDLogicBase.isPSDEFDLogicNameDirty();
            }
            case 17: {
                return pSDEFDLogicBase.isPSDEFormDetailIdDirty();
            }
            case 18: {
                return pSDEFDLogicBase.isPSDEFormDetailNameDirty();
            }
            case 19: {
                return pSDEFDLogicBase.isPSDEFormIdDirty();
            }
            case 20: {
                return pSDEFDLogicBase.isPSDEFormNameDirty();
            }
            case 21: {
                return pSDEFDLogicBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSDEFDLogicBase.isUpdateDateDirty();
            }
            case 23: {
                return pSDEFDLogicBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEFDLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEFDLogicBase pSDEFDLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEFDLogicBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getCondValue()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getFDName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fdname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getFDName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getLogicCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logiccat", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getLogicCat()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPPSDEFDLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdefdlogicid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPPSDEFDLogicId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPPSDEFDLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdefdlogicname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPPSDEFDLogicName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDBValueOPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDBValueOPId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDBValueOPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdbvalueopname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDBValueOPName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFDLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdlogicid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFDLogicId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFDLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefdlogicname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFDLogicName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFormDetailId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformdetailname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFormDetailName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFormId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeformname", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDEFormName()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEFDLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEFDLogicBase.getJSONValue((Object)pSDEFDLogicBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEFDLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEFDLogicBase pSDEFDLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEFDLogicBase.getCondValue() != null) {
            object = pSDEFDLogicBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getCreateDate() != null) {
            object = pSDEFDLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDLogicBase.getCreateMan() != null) {
            object = pSDEFDLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getCustomCode() != null) {
            object = pSDEFDLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getDynaModelFlag() != null) {
            object = pSDEFDLogicBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDLogicBase.getFDName() != null) {
            object = pSDEFDLogicBase.getFDName();
            xmlNode.setAttribute(FIELD_FDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getGroupNotFlag() != null) {
            object = pSDEFDLogicBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDLogicBase.getGroupOP() != null) {
            object = pSDEFDLogicBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getLogicCat() != null) {
            object = pSDEFDLogicBase.getLogicCat();
            xmlNode.setAttribute(FIELD_LOGICCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getLogicType() != null) {
            object = pSDEFDLogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getOrderValue() != null) {
            object = pSDEFDLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEFDLogicBase.getPPSDEFDLogicId() != null) {
            object = pSDEFDLogicBase.getPPSDEFDLogicId();
            xmlNode.setAttribute(FIELD_PPSDEFDLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPPSDEFDLogicName() != null) {
            object = pSDEFDLogicBase.getPPSDEFDLogicName();
            xmlNode.setAttribute(FIELD_PPSDEFDLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDBValueOPId() != null) {
            object = pSDEFDLogicBase.getPSDBValueOPId();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDBValueOPName() != null) {
            object = pSDEFDLogicBase.getPSDBValueOPName();
            xmlNode.setAttribute(FIELD_PSDBVALUEOPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFDLogicId() != null) {
            object = pSDEFDLogicBase.getPSDEFDLogicId();
            xmlNode.setAttribute(FIELD_PSDEFDLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFDLogicName() != null) {
            object = pSDEFDLogicBase.getPSDEFDLogicName();
            xmlNode.setAttribute(FIELD_PSDEFDLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormDetailId() != null) {
            object = pSDEFDLogicBase.getPSDEFormDetailId();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormDetailName() != null) {
            object = pSDEFDLogicBase.getPSDEFormDetailName();
            xmlNode.setAttribute(FIELD_PSDEFORMDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormId() != null) {
            object = pSDEFDLogicBase.getPSDEFormId();
            xmlNode.setAttribute(FIELD_PSDEFORMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDEFormName() != null) {
            object = pSDEFDLogicBase.getPSDEFormName();
            xmlNode.setAttribute(FIELD_PSDEFORMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getPSDynaInstId() != null) {
            object = pSDEFDLogicBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEFDLogicBase.getUpdateDate() != null) {
            object = pSDEFDLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEFDLogicBase.getUpdateMan() != null) {
            object = pSDEFDLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEFDLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEFDLogicBase pSDEFDLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEFDLogicBase.isCondValueDirty() && (bl || pSDEFDLogicBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSDEFDLogicBase.getCondValue());
        }
        if (pSDEFDLogicBase.isCreateDateDirty() && (bl || pSDEFDLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEFDLogicBase.getCreateDate());
        }
        if (pSDEFDLogicBase.isCreateManDirty() && (bl || pSDEFDLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEFDLogicBase.getCreateMan());
        }
        if (pSDEFDLogicBase.isCustomCodeDirty() && (bl || pSDEFDLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEFDLogicBase.getCustomCode());
        }
        if (pSDEFDLogicBase.isDynaModelFlagDirty() && (bl || pSDEFDLogicBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEFDLogicBase.getDynaModelFlag());
        }
        if (pSDEFDLogicBase.isFDNameDirty() && (bl || pSDEFDLogicBase.getFDName() != null)) {
            iDataObject.set(FIELD_FDNAME, (Object)pSDEFDLogicBase.getFDName());
        }
        if (pSDEFDLogicBase.isGroupNotFlagDirty() && (bl || pSDEFDLogicBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSDEFDLogicBase.getGroupNotFlag());
        }
        if (pSDEFDLogicBase.isGroupOPDirty() && (bl || pSDEFDLogicBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSDEFDLogicBase.getGroupOP());
        }
        if (pSDEFDLogicBase.isLogicCatDirty() && (bl || pSDEFDLogicBase.getLogicCat() != null)) {
            iDataObject.set(FIELD_LOGICCAT, (Object)pSDEFDLogicBase.getLogicCat());
        }
        if (pSDEFDLogicBase.isLogicTypeDirty() && (bl || pSDEFDLogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSDEFDLogicBase.getLogicType());
        }
        if (pSDEFDLogicBase.isOrderValueDirty() && (bl || pSDEFDLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEFDLogicBase.getOrderValue());
        }
        if (pSDEFDLogicBase.isPPSDEFDLogicIdDirty() && (bl || pSDEFDLogicBase.getPPSDEFDLogicId() != null)) {
            iDataObject.set(FIELD_PPSDEFDLOGICID, (Object)pSDEFDLogicBase.getPPSDEFDLogicId());
        }
        if (pSDEFDLogicBase.isPPSDEFDLogicNameDirty() && (bl || pSDEFDLogicBase.getPPSDEFDLogicName() != null)) {
            iDataObject.set(FIELD_PPSDEFDLOGICNAME, (Object)pSDEFDLogicBase.getPPSDEFDLogicName());
        }
        if (pSDEFDLogicBase.isPSDBValueOPIdDirty() && (bl || pSDEFDLogicBase.getPSDBValueOPId() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPID, (Object)pSDEFDLogicBase.getPSDBValueOPId());
        }
        if (pSDEFDLogicBase.isPSDBValueOPNameDirty() && (bl || pSDEFDLogicBase.getPSDBValueOPName() != null)) {
            iDataObject.set(FIELD_PSDBVALUEOPNAME, (Object)pSDEFDLogicBase.getPSDBValueOPName());
        }
        if (pSDEFDLogicBase.isPSDEFDLogicIdDirty() && (bl || pSDEFDLogicBase.getPSDEFDLogicId() != null)) {
            iDataObject.set(FIELD_PSDEFDLOGICID, (Object)pSDEFDLogicBase.getPSDEFDLogicId());
        }
        if (pSDEFDLogicBase.isPSDEFDLogicNameDirty() && (bl || pSDEFDLogicBase.getPSDEFDLogicName() != null)) {
            iDataObject.set(FIELD_PSDEFDLOGICNAME, (Object)pSDEFDLogicBase.getPSDEFDLogicName());
        }
        if (pSDEFDLogicBase.isPSDEFormDetailIdDirty() && (bl || pSDEFDLogicBase.getPSDEFormDetailId() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILID, (Object)pSDEFDLogicBase.getPSDEFormDetailId());
        }
        if (pSDEFDLogicBase.isPSDEFormDetailNameDirty() && (bl || pSDEFDLogicBase.getPSDEFormDetailName() != null)) {
            iDataObject.set(FIELD_PSDEFORMDETAILNAME, (Object)pSDEFDLogicBase.getPSDEFormDetailName());
        }
        if (pSDEFDLogicBase.isPSDEFormIdDirty() && (bl || pSDEFDLogicBase.getPSDEFormId() != null)) {
            iDataObject.set(FIELD_PSDEFORMID, (Object)pSDEFDLogicBase.getPSDEFormId());
        }
        if (pSDEFDLogicBase.isPSDEFormNameDirty() && (bl || pSDEFDLogicBase.getPSDEFormName() != null)) {
            iDataObject.set(FIELD_PSDEFORMNAME, (Object)pSDEFDLogicBase.getPSDEFormName());
        }
        if (pSDEFDLogicBase.isPSDynaInstIdDirty() && (bl || pSDEFDLogicBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEFDLogicBase.getPSDynaInstId());
        }
        if (pSDEFDLogicBase.isUpdateDateDirty() && (bl || pSDEFDLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEFDLogicBase.getUpdateDate());
        }
        if (pSDEFDLogicBase.isUpdateManDirty() && (bl || pSDEFDLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEFDLogicBase.getUpdateMan());
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
        return PSDEFDLogicBase.remove(this, n);
    }

    private static boolean remove(PSDEFDLogicBase pSDEFDLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEFDLogicBase.resetCondValue();
                return true;
            }
            case 1: {
                pSDEFDLogicBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDEFDLogicBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDEFDLogicBase.resetCustomCode();
                return true;
            }
            case 4: {
                pSDEFDLogicBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSDEFDLogicBase.resetFDName();
                return true;
            }
            case 6: {
                pSDEFDLogicBase.resetGroupNotFlag();
                return true;
            }
            case 7: {
                pSDEFDLogicBase.resetGroupOP();
                return true;
            }
            case 8: {
                pSDEFDLogicBase.resetLogicCat();
                return true;
            }
            case 9: {
                pSDEFDLogicBase.resetLogicType();
                return true;
            }
            case 10: {
                pSDEFDLogicBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSDEFDLogicBase.resetPPSDEFDLogicId();
                return true;
            }
            case 12: {
                pSDEFDLogicBase.resetPPSDEFDLogicName();
                return true;
            }
            case 13: {
                pSDEFDLogicBase.resetPSDBValueOPId();
                return true;
            }
            case 14: {
                pSDEFDLogicBase.resetPSDBValueOPName();
                return true;
            }
            case 15: {
                pSDEFDLogicBase.resetPSDEFDLogicId();
                return true;
            }
            case 16: {
                pSDEFDLogicBase.resetPSDEFDLogicName();
                return true;
            }
            case 17: {
                pSDEFDLogicBase.resetPSDEFormDetailId();
                return true;
            }
            case 18: {
                pSDEFDLogicBase.resetPSDEFormDetailName();
                return true;
            }
            case 19: {
                pSDEFDLogicBase.resetPSDEFormId();
                return true;
            }
            case 20: {
                pSDEFDLogicBase.resetPSDEFormName();
                return true;
            }
            case 21: {
                pSDEFDLogicBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSDEFDLogicBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSDEFDLogicBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDBValueOP getPSDBValueOp() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDBValueOp();
        }
        if (this.getPSDBValueOPId() == null) {
            return null;
        }
        Integer n = this.objPSDBValueOpLock;
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
    public PSDEFDLogic getPPSDEFDLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDEFDLogic();
        }
        if (this.getPPSDEFDLogicId() == null) {
            return null;
        }
        Integer n = this.objPPSDEFDLogicLock;
        synchronized (n) {
            if (this.ppsdefdlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDEFDLogicId(), (Object)this.ppsdefdlogic.getPSDEFDLogicId()) != 0L) {
                this.ppsdefdlogic = null;
            }
            if (this.ppsdefdlogic == null) {
                PSDEFDLogic pSDEFDLogic = new PSDEFDLogic();
                pSDEFDLogic.setPSDEFDLogicId(this.getPPSDEFDLogicId());
                PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
                pSDEFDLogicService.autoGet(pSDEFDLogic);
                this.ppsdefdlogic = pSDEFDLogic;
            }
            return this.ppsdefdlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEFormDetail getPSDEFormDetail() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFormDetail();
        }
        if (this.getPSDEFormDetailId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormDetailLock;
        synchronized (n) {
            if (this.psdeformdetail != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormDetailId(), (Object)this.psdeformdetail.getPSDEFormDetailId()) != 0L) {
                this.psdeformdetail = null;
            }
            if (this.psdeformdetail == null) {
                PSDEFormDetail pSDEFormDetail = new PSDEFormDetail();
                pSDEFormDetail.setPSDEFormDetailId(this.getPSDEFormDetailId());
                PSDEFormDetailService pSDEFormDetailService = (PSDEFormDetailService)ServiceGlobal.getService(PSDEFormDetailService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormDetailService.autoGet(pSDEFormDetail);
                this.psdeformdetail = pSDEFormDetail;
            }
            return this.psdeformdetail;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEForm getPSDEForm() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEForm();
        }
        if (this.getPSDEFormId() == null) {
            return null;
        }
        Integer n = this.objPSDEFormLock;
        synchronized (n) {
            if (this.psdeform != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFormId(), (Object)this.psdeform.getPSDEFormId()) != 0L) {
                this.psdeform = null;
            }
            if (this.psdeform == null) {
                PSDEForm pSDEForm = new PSDEForm();
                pSDEForm.setPSDEFormId(this.getPSDEFormId());
                PSDEFormService pSDEFormService = (PSDEFormService)ServiceGlobal.getService(PSDEFormService.class, (SessionFactory)this.getSessionFactory());
                pSDEFormService.autoGet(pSDEForm);
                this.psdeform = pSDEForm;
            }
            return this.psdeform;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEFDLogic> getPSDEFDLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFDLogics();
        }
        if (this.getPSDEFDLogicId() == null) {
            return null;
        }
        PSDEFDLogicService pSDEFDLogicService = (PSDEFDLogicService)ServiceGlobal.getService(PSDEFDLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEFDLogicsLock;
        synchronized (n) {
            if (this.psdefdlogics == null) {
                this.psdefdlogics = pSDEFDLogicService.selectByPPSDEFDLogic(this);
            }
            return this.psdefdlogics;
        }
    }

    private PSDEFDLogicBase getProxyEntity() {
        return this.proxyPSDEFDLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEFDLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEFDLogicBase) {
            this.proxyPSDEFDLogicBase = (PSDEFDLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEFDLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDVALUE, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_FDNAME, 5);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 6);
        fieldIndexMap.put(FIELD_GROUPOP, 7);
        fieldIndexMap.put(FIELD_LOGICCAT, 8);
        fieldIndexMap.put(FIELD_LOGICTYPE, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PPSDEFDLOGICID, 11);
        fieldIndexMap.put(FIELD_PPSDEFDLOGICNAME, 12);
        fieldIndexMap.put(FIELD_PSDBVALUEOPID, 13);
        fieldIndexMap.put(FIELD_PSDBVALUEOPNAME, 14);
        fieldIndexMap.put(FIELD_PSDEFDLOGICID, 15);
        fieldIndexMap.put(FIELD_PSDEFDLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILID, 17);
        fieldIndexMap.put(FIELD_PSDEFORMDETAILNAME, 18);
        fieldIndexMap.put(FIELD_PSDEFORMID, 19);
        fieldIndexMap.put(FIELD_PSDEFORMNAME, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

