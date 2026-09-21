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
package net.ibizsys.pscore.srv.dynasys.entity;

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
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenter;
import net.ibizsys.pscore.srv.devcenter.entity.PSDevCenterSVN;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterSVNService;
import net.ibizsys.pscore.srv.devcenter.service.PSDevCenterService;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInst;
import net.ibizsys.pscore.srv.dynasys.entity.PSDevSlnSysDynaInstRef;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstRefService;
import net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.ibizsys.pscore.srv.sysdevstudio.entity.PSDevSlnSysDepInst;
import net.ibizsys.pscore.srv.sysdevstudio.service.PSDevSlnSysDepInstService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnSysDynaInstBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnSysDynaInstBase.class);
    public static final String FIELD_CFGPSDEVCENTERSVNID = "CFGPSDEVCENTERSVNID";
    public static final String FIELD_CFGPSDEVCENTERSVNNAME = "CFGPSDEVCENTERSVNNAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_EXPRIEDTIME = "EXPRIEDTIME";
    public static final String FIELD_INSTMODELPATH = "INSTMODELPATH";
    public static final String FIELD_INSTSTATE = "INSTSTATE";
    public static final String FIELD_INSTTAG = "INSTTAG";
    public static final String FIELD_INSTTAG2 = "INSTTAG2";
    public static final String FIELD_INSTTAG3 = "INSTTAG3";
    public static final String FIELD_INSTTAG4 = "INSTTAG4";
    public static final String FIELD_INSTTAG5 = "INSTTAG5";
    public static final String FIELD_INSTTAG6 = "INSTTAG6";
    public static final String FIELD_INSTTAG7 = "INSTTAG7";
    public static final String FIELD_INSTTAG8 = "INSTTAG8";
    public static final String FIELD_INSTTYPE = "INSTTYPE";
    public static final String FIELD_INSTVER = "INSTVER";
    public static final String FIELD_LASTCHECKINTIME = "LASTCHECKINTIME";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELPSDEVCENTERSVNID = "MODELPSDEVCENTERSVNID";
    public static final String FIELD_MODELPSDEVCENTERSVNNAME = "MODELPSDEVCENTERSVNNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PINSTMODELPATH = "PINSTMODELPATH";
    public static final String FIELD_PPSDEVSLNSYSDYNAINSTID = "PPSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_PPSDEVSLNSYSDYNAINSTNAME = "PPSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEVCENTERID = "PSDEVCENTERID";
    public static final String FIELD_PSDEVCENTERNAME = "PSDEVCENTERNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSDEPINSTID = "PSDEVSLNSYSDEPINSTID";
    public static final String FIELD_PSDEVSLNSYSDEPINSTNAME = "PSDEVSLNSYSDEPINSTNAME";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTID = "PSDEVSLNSYSDYNAINSTID";
    public static final String FIELD_PSDEVSLNSYSDYNAINSTNAME = "PSDEVSLNSYSDYNAINSTNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_REFUPDATEDATE = "REFUPDATEDATE";
    public static final String FIELD_ROOTINSTMODELPATH = "ROOTINSTMODELPATH";
    public static final String FIELD_SYSMODELPATH = "SYSMODELPATH";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CFGPSDEVCENTERSVNID = 0;
    private static final int INDEX_CFGPSDEVCENTERSVNNAME = 1;
    private static final int INDEX_COLOR = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_EXPRIEDTIME = 5;
    private static final int INDEX_INSTMODELPATH = 6;
    private static final int INDEX_INSTSTATE = 7;
    private static final int INDEX_INSTTAG = 8;
    private static final int INDEX_INSTTAG2 = 9;
    private static final int INDEX_INSTTAG3 = 10;
    private static final int INDEX_INSTTAG4 = 11;
    private static final int INDEX_INSTTAG5 = 12;
    private static final int INDEX_INSTTAG6 = 13;
    private static final int INDEX_INSTTAG7 = 14;
    private static final int INDEX_INSTTAG8 = 15;
    private static final int INDEX_INSTTYPE = 16;
    private static final int INDEX_INSTVER = 17;
    private static final int INDEX_LASTCHECKINTIME = 18;
    private static final int INDEX_LOGICNAME = 19;
    private static final int INDEX_MEMO = 20;
    private static final int INDEX_MODELPSDEVCENTERSVNID = 21;
    private static final int INDEX_MODELPSDEVCENTERSVNNAME = 22;
    private static final int INDEX_ORDERVALUE = 23;
    private static final int INDEX_PINSTMODELPATH = 24;
    private static final int INDEX_PPSDEVSLNSYSDYNAINSTID = 25;
    private static final int INDEX_PPSDEVSLNSYSDYNAINSTNAME = 26;
    private static final int INDEX_PSDEVCENTERID = 27;
    private static final int INDEX_PSDEVCENTERNAME = 28;
    private static final int INDEX_PSDEVSLNID = 29;
    private static final int INDEX_PSDEVSLNNAME = 30;
    private static final int INDEX_PSDEVSLNSYSDEPINSTID = 31;
    private static final int INDEX_PSDEVSLNSYSDEPINSTNAME = 32;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTID = 33;
    private static final int INDEX_PSDEVSLNSYSDYNAINSTNAME = 34;
    private static final int INDEX_PSDEVSLNSYSID = 35;
    private static final int INDEX_PSDEVSLNSYSNAME = 36;
    private static final int INDEX_REFUPDATEDATE = 37;
    private static final int INDEX_ROOTINSTMODELPATH = 38;
    private static final int INDEX_SYSMODELPATH = 39;
    private static final int INDEX_UPDATEDATE = 40;
    private static final int INDEX_UPDATEMAN = 41;
    private static final int INDEX_USERTAG = 42;
    private static final int INDEX_USERTAG2 = 43;
    private static final int INDEX_VALIDFLAG = 44;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnSysDynaInstBase proxyPSDevSlnSysDynaInstBase = null;
    private boolean cfgpsdevcentersvnidDirtyFlag = false;
    private boolean cfgpsdevcentersvnnameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean expriedtimeDirtyFlag = false;
    private boolean instmodelpathDirtyFlag = false;
    private boolean inststateDirtyFlag = false;
    private boolean insttagDirtyFlag = false;
    private boolean insttag2DirtyFlag = false;
    private boolean insttag3DirtyFlag = false;
    private boolean insttag4DirtyFlag = false;
    private boolean insttag5DirtyFlag = false;
    private boolean insttag6DirtyFlag = false;
    private boolean insttag7DirtyFlag = false;
    private boolean insttag8DirtyFlag = false;
    private boolean insttypeDirtyFlag = false;
    private boolean instverDirtyFlag = false;
    private boolean lastcheckintimeDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelpsdevcentersvnidDirtyFlag = false;
    private boolean modelpsdevcentersvnnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pinstmodelpathDirtyFlag = false;
    private boolean ppsdevslnsysdynainstidDirtyFlag = false;
    private boolean ppsdevslnsysdynainstnameDirtyFlag = false;
    private boolean psdevcenteridDirtyFlag = false;
    private boolean psdevcenternameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysdepinstidDirtyFlag = false;
    private boolean psdevslnsysdepinstnameDirtyFlag = false;
    private boolean psdevslnsysdynainstidDirtyFlag = false;
    private boolean psdevslnsysdynainstnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean refupdatedateDirtyFlag = false;
    private boolean rootinstmodelpathDirtyFlag = false;
    private boolean sysmodelpathDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="cfgpsdevcentersvnid")
    private String cfgpsdevcentersvnid;
    @Column(name="cfgpsdevcentersvnname")
    private String cfgpsdevcentersvnname;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="expriedtime")
    private Timestamp expriedtime;
    @Column(name="instmodelpath")
    private String instmodelpath;
    @Column(name="inststate")
    private Integer inststate;
    @Column(name="insttag")
    private String insttag;
    @Column(name="insttag2")
    private String insttag2;
    @Column(name="insttag3")
    private String insttag3;
    @Column(name="insttag4")
    private String insttag4;
    @Column(name="insttag5")
    private String insttag5;
    @Column(name="insttag6")
    private String insttag6;
    @Column(name="insttag7")
    private String insttag7;
    @Column(name="insttag8")
    private String insttag8;
    @Column(name="insttype")
    private String insttype;
    @Column(name="instver")
    private Integer instver;
    @Column(name="lastcheckintime")
    private Timestamp lastcheckintime;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modelpsdevcentersvnid")
    private String modelpsdevcentersvnid;
    @Column(name="modelpsdevcentersvnname")
    private String modelpsdevcentersvnname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pinstmodelpath")
    private String pinstmodelpath;
    @Column(name="ppsdevslnsysdynainstid")
    private String ppsdevslnsysdynainstid;
    @Column(name="ppsdevslnsysdynainstname")
    private String ppsdevslnsysdynainstname;
    @Column(name="psdevcenterid")
    private String psdevcenterid;
    @Column(name="psdevcentername")
    private String psdevcentername;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysdepinstid")
    private String psdevslnsysdepinstid;
    @Column(name="psdevslnsysdepinstname")
    private String psdevslnsysdepinstname;
    @Column(name="psdevslnsysdynainstid")
    private String psdevslnsysdynainstid;
    @Column(name="psdevslnsysdynainstname")
    private String psdevslnsysdynainstname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
    @Column(name="refupdatedate")
    private Timestamp refupdatedate;
    @Column(name="rootinstmodelpath")
    private String rootinstmodelpath;
    @Column(name="sysmodelpath")
    private String sysmodelpath;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objCfgPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN cfgpsdevcentersvn = null;
    private Integer objModelPSDevCenterSVNLock = new Integer(1);
    private PSDevCenterSVN modelpsdevcentersvn = null;
    private Integer objPSDevCenterLock = new Integer(1);
    private PSDevCenter psdevcenter = null;
    private Integer objPSDevSlnSysDepInstLock = new Integer(1);
    private PSDevSlnSysDepInst psdevslnsysdepinst = null;
    private Integer objPPSDevSlnSysDynaInstLock = new Integer(1);
    private PSDevSlnSysDynaInst ppsdevslnsysdynainst = null;
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;
    private Integer objPSDevSlnSysDynaInstRefsLock = new Integer(1);
    private ArrayList<PSDevSlnSysDynaInstRef> psdevslnsysdynainstrefs = null;

    public void setCfgPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpsdevcentersvnid = string;
        this.cfgpsdevcentersvnidDirtyFlag = true;
    }

    public String getCfgPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVNId();
        }
        return this.cfgpsdevcentersvnid;
    }

    public boolean isCfgPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSDevCenterSVNIdDirty();
        }
        return this.cfgpsdevcentersvnidDirtyFlag;
    }

    public void resetCfgPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSDevCenterSVNId();
            return;
        }
        this.cfgpsdevcentersvnidDirtyFlag = false;
        this.cfgpsdevcentersvnid = null;
    }

    public void setCfgPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCfgPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cfgpsdevcentersvnname = string;
        this.cfgpsdevcentersvnnameDirtyFlag = true;
    }

    public String getCfgPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVNName();
        }
        return this.cfgpsdevcentersvnname;
    }

    public boolean isCfgPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCfgPSDevCenterSVNNameDirty();
        }
        return this.cfgpsdevcentersvnnameDirtyFlag;
    }

    public void resetCfgPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCfgPSDevCenterSVNName();
            return;
        }
        this.cfgpsdevcentersvnnameDirtyFlag = false;
        this.cfgpsdevcentersvnname = null;
    }

    public void setColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.color = string;
        this.colorDirtyFlag = true;
    }

    public String getColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColor();
        }
        return this.color;
    }

    public boolean isColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColorDirty();
        }
        return this.colorDirtyFlag;
    }

    public void resetColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColor();
            return;
        }
        this.colorDirtyFlag = false;
        this.color = null;
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

    public void setExpriedTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setExpriedTime(timestamp);
            return;
        }
        this.expriedtime = timestamp;
        this.expriedtimeDirtyFlag = true;
    }

    public Timestamp getExpriedTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getExpriedTime();
        }
        return this.expriedtime;
    }

    public boolean isExpriedTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isExpriedTimeDirty();
        }
        return this.expriedtimeDirtyFlag;
    }

    public void resetExpriedTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetExpriedTime();
            return;
        }
        this.expriedtimeDirtyFlag = false;
        this.expriedtime = null;
    }

    public void setInstModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.instmodelpath = string;
        this.instmodelpathDirtyFlag = true;
    }

    public String getInstModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstModelPath();
        }
        return this.instmodelpath;
    }

    public boolean isInstModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstModelPathDirty();
        }
        return this.instmodelpathDirtyFlag;
    }

    public void resetInstModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstModelPath();
            return;
        }
        this.instmodelpathDirtyFlag = false;
        this.instmodelpath = null;
    }

    public void setInstState(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstState(n);
            return;
        }
        this.inststate = n;
        this.inststateDirtyFlag = true;
    }

    public Integer getInstState() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstState();
        }
        return this.inststate;
    }

    public boolean isInstStateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstStateDirty();
        }
        return this.inststateDirtyFlag;
    }

    public void resetInstState() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstState();
            return;
        }
        this.inststateDirtyFlag = false;
        this.inststate = null;
    }

    public void setInstTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag = string;
        this.insttagDirtyFlag = true;
    }

    public String getInstTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag();
        }
        return this.insttag;
    }

    public boolean isInstTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTagDirty();
        }
        return this.insttagDirtyFlag;
    }

    public void resetInstTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag();
            return;
        }
        this.insttagDirtyFlag = false;
        this.insttag = null;
    }

    public void setInstTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag2 = string;
        this.insttag2DirtyFlag = true;
    }

    public String getInstTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag2();
        }
        return this.insttag2;
    }

    public boolean isInstTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag2Dirty();
        }
        return this.insttag2DirtyFlag;
    }

    public void resetInstTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag2();
            return;
        }
        this.insttag2DirtyFlag = false;
        this.insttag2 = null;
    }

    public void setInstTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag3 = string;
        this.insttag3DirtyFlag = true;
    }

    public String getInstTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag3();
        }
        return this.insttag3;
    }

    public boolean isInstTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag3Dirty();
        }
        return this.insttag3DirtyFlag;
    }

    public void resetInstTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag3();
            return;
        }
        this.insttag3DirtyFlag = false;
        this.insttag3 = null;
    }

    public void setInstTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag4 = string;
        this.insttag4DirtyFlag = true;
    }

    public String getInstTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag4();
        }
        return this.insttag4;
    }

    public boolean isInstTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag4Dirty();
        }
        return this.insttag4DirtyFlag;
    }

    public void resetInstTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag4();
            return;
        }
        this.insttag4DirtyFlag = false;
        this.insttag4 = null;
    }

    public void setInstTag5(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag5(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag5 = string;
        this.insttag5DirtyFlag = true;
    }

    public String getInstTag5() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag5();
        }
        return this.insttag5;
    }

    public boolean isInstTag5Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag5Dirty();
        }
        return this.insttag5DirtyFlag;
    }

    public void resetInstTag5() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag5();
            return;
        }
        this.insttag5DirtyFlag = false;
        this.insttag5 = null;
    }

    public void setInstTag6(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag6(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag6 = string;
        this.insttag6DirtyFlag = true;
    }

    public String getInstTag6() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag6();
        }
        return this.insttag6;
    }

    public boolean isInstTag6Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag6Dirty();
        }
        return this.insttag6DirtyFlag;
    }

    public void resetInstTag6() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag6();
            return;
        }
        this.insttag6DirtyFlag = false;
        this.insttag6 = null;
    }

    public void setInstTag7(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag7(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag7 = string;
        this.insttag7DirtyFlag = true;
    }

    public String getInstTag7() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag7();
        }
        return this.insttag7;
    }

    public boolean isInstTag7Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag7Dirty();
        }
        return this.insttag7DirtyFlag;
    }

    public void resetInstTag7() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag7();
            return;
        }
        this.insttag7DirtyFlag = false;
        this.insttag7 = null;
    }

    public void setInstTag8(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstTag8(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttag8 = string;
        this.insttag8DirtyFlag = true;
    }

    public String getInstTag8() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstTag8();
        }
        return this.insttag8;
    }

    public boolean isInstTag8Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTag8Dirty();
        }
        return this.insttag8DirtyFlag;
    }

    public void resetInstTag8() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstTag8();
            return;
        }
        this.insttag8DirtyFlag = false;
        this.insttag8 = null;
    }

    public void setInstType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.insttype = string;
        this.insttypeDirtyFlag = true;
    }

    public String getInstType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstType();
        }
        return this.insttype;
    }

    public boolean isInstTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstTypeDirty();
        }
        return this.insttypeDirtyFlag;
    }

    public void resetInstType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstType();
            return;
        }
        this.insttypeDirtyFlag = false;
        this.insttype = null;
    }

    public void setInstVer(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setInstVer(n);
            return;
        }
        this.instver = n;
        this.instverDirtyFlag = true;
    }

    public Integer getInstVer() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getInstVer();
        }
        return this.instver;
    }

    public boolean isInstVerDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isInstVerDirty();
        }
        return this.instverDirtyFlag;
    }

    public void resetInstVer() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetInstVer();
            return;
        }
        this.instverDirtyFlag = false;
        this.instver = null;
    }

    public void setLastCheckinTime(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLastCheckinTime(timestamp);
            return;
        }
        this.lastcheckintime = timestamp;
        this.lastcheckintimeDirtyFlag = true;
    }

    public Timestamp getLastCheckinTime() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLastCheckinTime();
        }
        return this.lastcheckintime;
    }

    public boolean isLastCheckinTimeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLastCheckinTimeDirty();
        }
        return this.lastcheckintimeDirtyFlag;
    }

    public void resetLastCheckinTime() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLastCheckinTime();
            return;
        }
        this.lastcheckintimeDirtyFlag = false;
        this.lastcheckintime = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
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

    public void setModelPSDevCenterSVNId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnid = string;
        this.modelpsdevcentersvnidDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNId();
        }
        return this.modelpsdevcentersvnid;
    }

    public boolean isModelPSDevCenterSVNIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNIdDirty();
        }
        return this.modelpsdevcentersvnidDirtyFlag;
    }

    public void resetModelPSDevCenterSVNId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNId();
            return;
        }
        this.modelpsdevcentersvnidDirtyFlag = false;
        this.modelpsdevcentersvnid = null;
    }

    public void setModelPSDevCenterSVNName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelPSDevCenterSVNName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelpsdevcentersvnname = string;
        this.modelpsdevcentersvnnameDirtyFlag = true;
    }

    public String getModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVNName();
        }
        return this.modelpsdevcentersvnname;
    }

    public boolean isModelPSDevCenterSVNNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelPSDevCenterSVNNameDirty();
        }
        return this.modelpsdevcentersvnnameDirtyFlag;
    }

    public void resetModelPSDevCenterSVNName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelPSDevCenterSVNName();
            return;
        }
        this.modelpsdevcentersvnnameDirtyFlag = false;
        this.modelpsdevcentersvnname = null;
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

    public void setPInstModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPInstModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pinstmodelpath = string;
        this.pinstmodelpathDirtyFlag = true;
    }

    public String getPInstModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPInstModelPath();
        }
        return this.pinstmodelpath;
    }

    public boolean isPInstModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPInstModelPathDirty();
        }
        return this.pinstmodelpathDirtyFlag;
    }

    public void resetPInstModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPInstModelPath();
            return;
        }
        this.pinstmodelpathDirtyFlag = false;
        this.pinstmodelpath = null;
    }

    public void setPPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnsysdynainstid = string;
        this.ppsdevslnsysdynainstidDirtyFlag = true;
    }

    public String getPPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSysDynaInstId();
        }
        return this.ppsdevslnsysdynainstid;
    }

    public boolean isPPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnSysDynaInstIdDirty();
        }
        return this.ppsdevslnsysdynainstidDirtyFlag;
    }

    public void resetPPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnSysDynaInstId();
            return;
        }
        this.ppsdevslnsysdynainstidDirtyFlag = false;
        this.ppsdevslnsysdynainstid = null;
    }

    public void setPPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdevslnsysdynainstname = string;
        this.ppsdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getPPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSysDynaInstName();
        }
        return this.ppsdevslnsysdynainstname;
    }

    public boolean isPPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDevSlnSysDynaInstNameDirty();
        }
        return this.ppsdevslnsysdynainstnameDirtyFlag;
    }

    public void resetPPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDevSlnSysDynaInstName();
            return;
        }
        this.ppsdevslnsysdynainstnameDirtyFlag = false;
        this.ppsdevslnsysdynainstname = null;
    }

    public void setPSDevCenterId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcenterid = string;
        this.psdevcenteridDirtyFlag = true;
    }

    public String getPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterId();
        }
        return this.psdevcenterid;
    }

    public boolean isPSDevCenterIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterIdDirty();
        }
        return this.psdevcenteridDirtyFlag;
    }

    public void resetPSDevCenterId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterId();
            return;
        }
        this.psdevcenteridDirtyFlag = false;
        this.psdevcenterid = null;
    }

    public void setPSDevCenterName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevCenterName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevcentername = string;
        this.psdevcenternameDirtyFlag = true;
    }

    public String getPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenterName();
        }
        return this.psdevcentername;
    }

    public boolean isPSDevCenterNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevCenterNameDirty();
        }
        return this.psdevcenternameDirtyFlag;
    }

    public void resetPSDevCenterName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevCenterName();
            return;
        }
        this.psdevcenternameDirtyFlag = false;
        this.psdevcentername = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysDepInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDepInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdepinstid = string;
        this.psdevslnsysdepinstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInstId();
        }
        return this.psdevslnsysdepinstid;
    }

    public boolean isPSDevSlnSysDepInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDepInstIdDirty();
        }
        return this.psdevslnsysdepinstidDirtyFlag;
    }

    public void resetPSDevSlnSysDepInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDepInstId();
            return;
        }
        this.psdevslnsysdepinstidDirtyFlag = false;
        this.psdevslnsysdepinstid = null;
    }

    public void setPSDevSlnSysDepInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDepInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdepinstname = string;
        this.psdevslnsysdepinstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDepInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInstName();
        }
        return this.psdevslnsysdepinstname;
    }

    public boolean isPSDevSlnSysDepInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDepInstNameDirty();
        }
        return this.psdevslnsysdepinstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDepInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDepInstName();
            return;
        }
        this.psdevslnsysdepinstnameDirtyFlag = false;
        this.psdevslnsysdepinstname = null;
    }

    public void setPSDevSlnSysDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstid = string;
        this.psdevslnsysdynainstidDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstId();
        }
        return this.psdevslnsysdynainstid;
    }

    public boolean isPSDevSlnSysDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstIdDirty();
        }
        return this.psdevslnsysdynainstidDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstId();
            return;
        }
        this.psdevslnsysdynainstidDirtyFlag = false;
        this.psdevslnsysdynainstid = null;
    }

    public void setPSDevSlnSysDynaInstName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysDynaInstName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysdynainstname = string;
        this.psdevslnsysdynainstnameDirtyFlag = true;
    }

    public String getPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstName();
        }
        return this.psdevslnsysdynainstname;
    }

    public boolean isPSDevSlnSysDynaInstNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysDynaInstNameDirty();
        }
        return this.psdevslnsysdynainstnameDirtyFlag;
    }

    public void resetPSDevSlnSysDynaInstName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysDynaInstName();
            return;
        }
        this.psdevslnsysdynainstnameDirtyFlag = false;
        this.psdevslnsysdynainstname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
    }

    public void setRefUpdateDate(Timestamp timestamp) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefUpdateDate(timestamp);
            return;
        }
        this.refupdatedate = timestamp;
        this.refupdatedateDirtyFlag = true;
    }

    public Timestamp getRefUpdateDate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefUpdateDate();
        }
        return this.refupdatedate;
    }

    public boolean isRefUpdateDateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefUpdateDateDirty();
        }
        return this.refupdatedateDirtyFlag;
    }

    public void resetRefUpdateDate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefUpdateDate();
            return;
        }
        this.refupdatedateDirtyFlag = false;
        this.refupdatedate = null;
    }

    public void setRootInstModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRootInstModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rootinstmodelpath = string;
        this.rootinstmodelpathDirtyFlag = true;
    }

    public String getRootInstModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRootInstModelPath();
        }
        return this.rootinstmodelpath;
    }

    public boolean isRootInstModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRootInstModelPathDirty();
        }
        return this.rootinstmodelpathDirtyFlag;
    }

    public void resetRootInstModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRootInstModelPath();
            return;
        }
        this.rootinstmodelpathDirtyFlag = false;
        this.rootinstmodelpath = null;
    }

    public void setSysModelPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSysModelPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.sysmodelpath = string;
        this.sysmodelpathDirtyFlag = true;
    }

    public String getSysModelPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSysModelPath();
        }
        return this.sysmodelpath;
    }

    public boolean isSysModelPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSysModelPathDirty();
        }
        return this.sysmodelpathDirtyFlag;
    }

    public void resetSysModelPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSysModelPath();
            return;
        }
        this.sysmodelpathDirtyFlag = false;
        this.sysmodelpath = null;
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
        PSDevSlnSysDynaInstBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase) {
        pSDevSlnSysDynaInstBase.resetCfgPSDevCenterSVNId();
        pSDevSlnSysDynaInstBase.resetCfgPSDevCenterSVNName();
        pSDevSlnSysDynaInstBase.resetColor();
        pSDevSlnSysDynaInstBase.resetCreateDate();
        pSDevSlnSysDynaInstBase.resetCreateMan();
        pSDevSlnSysDynaInstBase.resetExpriedTime();
        pSDevSlnSysDynaInstBase.resetInstModelPath();
        pSDevSlnSysDynaInstBase.resetInstState();
        pSDevSlnSysDynaInstBase.resetInstTag();
        pSDevSlnSysDynaInstBase.resetInstTag2();
        pSDevSlnSysDynaInstBase.resetInstTag3();
        pSDevSlnSysDynaInstBase.resetInstTag4();
        pSDevSlnSysDynaInstBase.resetInstTag5();
        pSDevSlnSysDynaInstBase.resetInstTag6();
        pSDevSlnSysDynaInstBase.resetInstTag7();
        pSDevSlnSysDynaInstBase.resetInstTag8();
        pSDevSlnSysDynaInstBase.resetInstType();
        pSDevSlnSysDynaInstBase.resetInstVer();
        pSDevSlnSysDynaInstBase.resetLastCheckinTime();
        pSDevSlnSysDynaInstBase.resetLogicName();
        pSDevSlnSysDynaInstBase.resetMemo();
        pSDevSlnSysDynaInstBase.resetModelPSDevCenterSVNId();
        pSDevSlnSysDynaInstBase.resetModelPSDevCenterSVNName();
        pSDevSlnSysDynaInstBase.resetOrderValue();
        pSDevSlnSysDynaInstBase.resetPInstModelPath();
        pSDevSlnSysDynaInstBase.resetPPSDevSlnSysDynaInstId();
        pSDevSlnSysDynaInstBase.resetPPSDevSlnSysDynaInstName();
        pSDevSlnSysDynaInstBase.resetPSDevCenterId();
        pSDevSlnSysDynaInstBase.resetPSDevCenterName();
        pSDevSlnSysDynaInstBase.resetPSDevSlnId();
        pSDevSlnSysDynaInstBase.resetPSDevSlnName();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysDepInstId();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysDepInstName();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysDynaInstId();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysDynaInstName();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysId();
        pSDevSlnSysDynaInstBase.resetPSDevSlnSysName();
        pSDevSlnSysDynaInstBase.resetRefUpdateDate();
        pSDevSlnSysDynaInstBase.resetRootInstModelPath();
        pSDevSlnSysDynaInstBase.resetSysModelPath();
        pSDevSlnSysDynaInstBase.resetUpdateDate();
        pSDevSlnSysDynaInstBase.resetUpdateMan();
        pSDevSlnSysDynaInstBase.resetUserTag();
        pSDevSlnSysDynaInstBase.resetUserTag2();
        pSDevSlnSysDynaInstBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCfgPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_CFGPSDEVCENTERSVNID, this.getCfgPSDevCenterSVNId());
        }
        if (!bl || this.isCfgPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_CFGPSDEVCENTERSVNNAME, this.getCfgPSDevCenterSVNName());
        }
        if (!bl || this.isColorDirty()) {
            hashMap.put(FIELD_COLOR, this.getColor());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isExpriedTimeDirty()) {
            hashMap.put(FIELD_EXPRIEDTIME, this.getExpriedTime());
        }
        if (!bl || this.isInstModelPathDirty()) {
            hashMap.put(FIELD_INSTMODELPATH, this.getInstModelPath());
        }
        if (!bl || this.isInstStateDirty()) {
            hashMap.put(FIELD_INSTSTATE, this.getInstState());
        }
        if (!bl || this.isInstTagDirty()) {
            hashMap.put(FIELD_INSTTAG, this.getInstTag());
        }
        if (!bl || this.isInstTag2Dirty()) {
            hashMap.put(FIELD_INSTTAG2, this.getInstTag2());
        }
        if (!bl || this.isInstTag3Dirty()) {
            hashMap.put(FIELD_INSTTAG3, this.getInstTag3());
        }
        if (!bl || this.isInstTag4Dirty()) {
            hashMap.put(FIELD_INSTTAG4, this.getInstTag4());
        }
        if (!bl || this.isInstTag5Dirty()) {
            hashMap.put(FIELD_INSTTAG5, this.getInstTag5());
        }
        if (!bl || this.isInstTag6Dirty()) {
            hashMap.put(FIELD_INSTTAG6, this.getInstTag6());
        }
        if (!bl || this.isInstTag7Dirty()) {
            hashMap.put(FIELD_INSTTAG7, this.getInstTag7());
        }
        if (!bl || this.isInstTag8Dirty()) {
            hashMap.put(FIELD_INSTTAG8, this.getInstTag8());
        }
        if (!bl || this.isInstTypeDirty()) {
            hashMap.put(FIELD_INSTTYPE, this.getInstType());
        }
        if (!bl || this.isInstVerDirty()) {
            hashMap.put(FIELD_INSTVER, this.getInstVer());
        }
        if (!bl || this.isLastCheckinTimeDirty()) {
            hashMap.put(FIELD_LASTCHECKINTIME, this.getLastCheckinTime());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelPSDevCenterSVNIdDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNID, this.getModelPSDevCenterSVNId());
        }
        if (!bl || this.isModelPSDevCenterSVNNameDirty()) {
            hashMap.put(FIELD_MODELPSDEVCENTERSVNNAME, this.getModelPSDevCenterSVNName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPInstModelPathDirty()) {
            hashMap.put(FIELD_PINSTMODELPATH, this.getPInstModelPath());
        }
        if (!bl || this.isPPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PPSDEVSLNSYSDYNAINSTID, this.getPPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isPPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PPSDEVSLNSYSDYNAINSTNAME, this.getPPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isPSDevCenterIdDirty()) {
            hashMap.put(FIELD_PSDEVCENTERID, this.getPSDevCenterId());
        }
        if (!bl || this.isPSDevCenterNameDirty()) {
            hashMap.put(FIELD_PSDEVCENTERNAME, this.getPSDevCenterName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysDepInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDEPINSTID, this.getPSDevSlnSysDepInstId());
        }
        if (!bl || this.isPSDevSlnSysDepInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDEPINSTNAME, this.getPSDevSlnSysDepInstName());
        }
        if (!bl || this.isPSDevSlnSysDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, this.getPSDevSlnSysDynaInstId());
        }
        if (!bl || this.isPSDevSlnSysDynaInstNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, this.getPSDevSlnSysDynaInstName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
        }
        if (!bl || this.isRefUpdateDateDirty()) {
            hashMap.put(FIELD_REFUPDATEDATE, this.getRefUpdateDate());
        }
        if (!bl || this.isRootInstModelPathDirty()) {
            hashMap.put(FIELD_ROOTINSTMODELPATH, this.getRootInstModelPath());
        }
        if (!bl || this.isSysModelPathDirty()) {
            hashMap.put(FIELD_SYSMODELPATH, this.getSysModelPath());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSDevSlnSysDynaInstBase.get(this, n);
    }

    private static Object get(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId();
            }
            case 1: {
                return pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName();
            }
            case 2: {
                return pSDevSlnSysDynaInstBase.getColor();
            }
            case 3: {
                return pSDevSlnSysDynaInstBase.getCreateDate();
            }
            case 4: {
                return pSDevSlnSysDynaInstBase.getCreateMan();
            }
            case 5: {
                return pSDevSlnSysDynaInstBase.getExpriedTime();
            }
            case 6: {
                return pSDevSlnSysDynaInstBase.getInstModelPath();
            }
            case 7: {
                return pSDevSlnSysDynaInstBase.getInstState();
            }
            case 8: {
                return pSDevSlnSysDynaInstBase.getInstTag();
            }
            case 9: {
                return pSDevSlnSysDynaInstBase.getInstTag2();
            }
            case 10: {
                return pSDevSlnSysDynaInstBase.getInstTag3();
            }
            case 11: {
                return pSDevSlnSysDynaInstBase.getInstTag4();
            }
            case 12: {
                return pSDevSlnSysDynaInstBase.getInstTag5();
            }
            case 13: {
                return pSDevSlnSysDynaInstBase.getInstTag6();
            }
            case 14: {
                return pSDevSlnSysDynaInstBase.getInstTag7();
            }
            case 15: {
                return pSDevSlnSysDynaInstBase.getInstTag8();
            }
            case 16: {
                return pSDevSlnSysDynaInstBase.getInstType();
            }
            case 17: {
                return pSDevSlnSysDynaInstBase.getInstVer();
            }
            case 18: {
                return pSDevSlnSysDynaInstBase.getLastCheckinTime();
            }
            case 19: {
                return pSDevSlnSysDynaInstBase.getLogicName();
            }
            case 20: {
                return pSDevSlnSysDynaInstBase.getMemo();
            }
            case 21: {
                return pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId();
            }
            case 22: {
                return pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName();
            }
            case 23: {
                return pSDevSlnSysDynaInstBase.getOrderValue();
            }
            case 24: {
                return pSDevSlnSysDynaInstBase.getPInstModelPath();
            }
            case 25: {
                return pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId();
            }
            case 26: {
                return pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName();
            }
            case 27: {
                return pSDevSlnSysDynaInstBase.getPSDevCenterId();
            }
            case 28: {
                return pSDevSlnSysDynaInstBase.getPSDevCenterName();
            }
            case 29: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnId();
            }
            case 30: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnName();
            }
            case 31: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId();
            }
            case 32: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName();
            }
            case 33: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId();
            }
            case 34: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName();
            }
            case 35: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysId();
            }
            case 36: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysName();
            }
            case 37: {
                return pSDevSlnSysDynaInstBase.getRefUpdateDate();
            }
            case 38: {
                return pSDevSlnSysDynaInstBase.getRootInstModelPath();
            }
            case 39: {
                return pSDevSlnSysDynaInstBase.getSysModelPath();
            }
            case 40: {
                return pSDevSlnSysDynaInstBase.getUpdateDate();
            }
            case 41: {
                return pSDevSlnSysDynaInstBase.getUpdateMan();
            }
            case 42: {
                return pSDevSlnSysDynaInstBase.getUserTag();
            }
            case 43: {
                return pSDevSlnSysDynaInstBase.getUserTag2();
            }
            case 44: {
                return pSDevSlnSysDynaInstBase.getValidFlag();
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
        PSDevSlnSysDynaInstBase.set(this, n, object);
    }

    private static void set(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstBase.setCfgPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnSysDynaInstBase.setCfgPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnSysDynaInstBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnSysDynaInstBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnSysDynaInstBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnSysDynaInstBase.setExpriedTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnSysDynaInstBase.setInstModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnSysDynaInstBase.setInstState(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnSysDynaInstBase.setInstTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnSysDynaInstBase.setInstTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnSysDynaInstBase.setInstTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnSysDynaInstBase.setInstTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnSysDynaInstBase.setInstTag5(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnSysDynaInstBase.setInstTag6(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnSysDynaInstBase.setInstTag7(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnSysDynaInstBase.setInstTag8(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnSysDynaInstBase.setInstType(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnSysDynaInstBase.setInstVer(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnSysDynaInstBase.setLastCheckinTime(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnSysDynaInstBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnSysDynaInstBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnSysDynaInstBase.setModelPSDevCenterSVNId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnSysDynaInstBase.setModelPSDevCenterSVNName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnSysDynaInstBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDevSlnSysDynaInstBase.setPInstModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDevSlnSysDynaInstBase.setPPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDevSlnSysDynaInstBase.setPPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDevSlnSysDynaInstBase.setPSDevCenterId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDevSlnSysDynaInstBase.setPSDevCenterName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDevSlnSysDynaInstBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDevSlnSysDynaInstBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysDepInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysDepInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysDynaInstName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDevSlnSysDynaInstBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDevSlnSysDynaInstBase.setRefUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDevSlnSysDynaInstBase.setRootInstModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDevSlnSysDynaInstBase.setSysModelPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDevSlnSysDynaInstBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSDevSlnSysDynaInstBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDevSlnSysDynaInstBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDevSlnSysDynaInstBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDevSlnSysDynaInstBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDevSlnSysDynaInstBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId() == null;
            }
            case 1: {
                return pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName() == null;
            }
            case 2: {
                return pSDevSlnSysDynaInstBase.getColor() == null;
            }
            case 3: {
                return pSDevSlnSysDynaInstBase.getCreateDate() == null;
            }
            case 4: {
                return pSDevSlnSysDynaInstBase.getCreateMan() == null;
            }
            case 5: {
                return pSDevSlnSysDynaInstBase.getExpriedTime() == null;
            }
            case 6: {
                return pSDevSlnSysDynaInstBase.getInstModelPath() == null;
            }
            case 7: {
                return pSDevSlnSysDynaInstBase.getInstState() == null;
            }
            case 8: {
                return pSDevSlnSysDynaInstBase.getInstTag() == null;
            }
            case 9: {
                return pSDevSlnSysDynaInstBase.getInstTag2() == null;
            }
            case 10: {
                return pSDevSlnSysDynaInstBase.getInstTag3() == null;
            }
            case 11: {
                return pSDevSlnSysDynaInstBase.getInstTag4() == null;
            }
            case 12: {
                return pSDevSlnSysDynaInstBase.getInstTag5() == null;
            }
            case 13: {
                return pSDevSlnSysDynaInstBase.getInstTag6() == null;
            }
            case 14: {
                return pSDevSlnSysDynaInstBase.getInstTag7() == null;
            }
            case 15: {
                return pSDevSlnSysDynaInstBase.getInstTag8() == null;
            }
            case 16: {
                return pSDevSlnSysDynaInstBase.getInstType() == null;
            }
            case 17: {
                return pSDevSlnSysDynaInstBase.getInstVer() == null;
            }
            case 18: {
                return pSDevSlnSysDynaInstBase.getLastCheckinTime() == null;
            }
            case 19: {
                return pSDevSlnSysDynaInstBase.getLogicName() == null;
            }
            case 20: {
                return pSDevSlnSysDynaInstBase.getMemo() == null;
            }
            case 21: {
                return pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId() == null;
            }
            case 22: {
                return pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName() == null;
            }
            case 23: {
                return pSDevSlnSysDynaInstBase.getOrderValue() == null;
            }
            case 24: {
                return pSDevSlnSysDynaInstBase.getPInstModelPath() == null;
            }
            case 25: {
                return pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId() == null;
            }
            case 26: {
                return pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName() == null;
            }
            case 27: {
                return pSDevSlnSysDynaInstBase.getPSDevCenterId() == null;
            }
            case 28: {
                return pSDevSlnSysDynaInstBase.getPSDevCenterName() == null;
            }
            case 29: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnId() == null;
            }
            case 30: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnName() == null;
            }
            case 31: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId() == null;
            }
            case 32: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName() == null;
            }
            case 33: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId() == null;
            }
            case 34: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName() == null;
            }
            case 35: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysId() == null;
            }
            case 36: {
                return pSDevSlnSysDynaInstBase.getPSDevSlnSysName() == null;
            }
            case 37: {
                return pSDevSlnSysDynaInstBase.getRefUpdateDate() == null;
            }
            case 38: {
                return pSDevSlnSysDynaInstBase.getRootInstModelPath() == null;
            }
            case 39: {
                return pSDevSlnSysDynaInstBase.getSysModelPath() == null;
            }
            case 40: {
                return pSDevSlnSysDynaInstBase.getUpdateDate() == null;
            }
            case 41: {
                return pSDevSlnSysDynaInstBase.getUpdateMan() == null;
            }
            case 42: {
                return pSDevSlnSysDynaInstBase.getUserTag() == null;
            }
            case 43: {
                return pSDevSlnSysDynaInstBase.getUserTag2() == null;
            }
            case 44: {
                return pSDevSlnSysDynaInstBase.getValidFlag() == null;
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
        return PSDevSlnSysDynaInstBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnSysDynaInstBase.isCfgPSDevCenterSVNIdDirty();
            }
            case 1: {
                return pSDevSlnSysDynaInstBase.isCfgPSDevCenterSVNNameDirty();
            }
            case 2: {
                return pSDevSlnSysDynaInstBase.isColorDirty();
            }
            case 3: {
                return pSDevSlnSysDynaInstBase.isCreateDateDirty();
            }
            case 4: {
                return pSDevSlnSysDynaInstBase.isCreateManDirty();
            }
            case 5: {
                return pSDevSlnSysDynaInstBase.isExpriedTimeDirty();
            }
            case 6: {
                return pSDevSlnSysDynaInstBase.isInstModelPathDirty();
            }
            case 7: {
                return pSDevSlnSysDynaInstBase.isInstStateDirty();
            }
            case 8: {
                return pSDevSlnSysDynaInstBase.isInstTagDirty();
            }
            case 9: {
                return pSDevSlnSysDynaInstBase.isInstTag2Dirty();
            }
            case 10: {
                return pSDevSlnSysDynaInstBase.isInstTag3Dirty();
            }
            case 11: {
                return pSDevSlnSysDynaInstBase.isInstTag4Dirty();
            }
            case 12: {
                return pSDevSlnSysDynaInstBase.isInstTag5Dirty();
            }
            case 13: {
                return pSDevSlnSysDynaInstBase.isInstTag6Dirty();
            }
            case 14: {
                return pSDevSlnSysDynaInstBase.isInstTag7Dirty();
            }
            case 15: {
                return pSDevSlnSysDynaInstBase.isInstTag8Dirty();
            }
            case 16: {
                return pSDevSlnSysDynaInstBase.isInstTypeDirty();
            }
            case 17: {
                return pSDevSlnSysDynaInstBase.isInstVerDirty();
            }
            case 18: {
                return pSDevSlnSysDynaInstBase.isLastCheckinTimeDirty();
            }
            case 19: {
                return pSDevSlnSysDynaInstBase.isLogicNameDirty();
            }
            case 20: {
                return pSDevSlnSysDynaInstBase.isMemoDirty();
            }
            case 21: {
                return pSDevSlnSysDynaInstBase.isModelPSDevCenterSVNIdDirty();
            }
            case 22: {
                return pSDevSlnSysDynaInstBase.isModelPSDevCenterSVNNameDirty();
            }
            case 23: {
                return pSDevSlnSysDynaInstBase.isOrderValueDirty();
            }
            case 24: {
                return pSDevSlnSysDynaInstBase.isPInstModelPathDirty();
            }
            case 25: {
                return pSDevSlnSysDynaInstBase.isPPSDevSlnSysDynaInstIdDirty();
            }
            case 26: {
                return pSDevSlnSysDynaInstBase.isPPSDevSlnSysDynaInstNameDirty();
            }
            case 27: {
                return pSDevSlnSysDynaInstBase.isPSDevCenterIdDirty();
            }
            case 28: {
                return pSDevSlnSysDynaInstBase.isPSDevCenterNameDirty();
            }
            case 29: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnIdDirty();
            }
            case 30: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnNameDirty();
            }
            case 31: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysDepInstIdDirty();
            }
            case 32: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysDepInstNameDirty();
            }
            case 33: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysDynaInstIdDirty();
            }
            case 34: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysDynaInstNameDirty();
            }
            case 35: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysIdDirty();
            }
            case 36: {
                return pSDevSlnSysDynaInstBase.isPSDevSlnSysNameDirty();
            }
            case 37: {
                return pSDevSlnSysDynaInstBase.isRefUpdateDateDirty();
            }
            case 38: {
                return pSDevSlnSysDynaInstBase.isRootInstModelPathDirty();
            }
            case 39: {
                return pSDevSlnSysDynaInstBase.isSysModelPathDirty();
            }
            case 40: {
                return pSDevSlnSysDynaInstBase.isUpdateDateDirty();
            }
            case 41: {
                return pSDevSlnSysDynaInstBase.isUpdateManDirty();
            }
            case 42: {
                return pSDevSlnSysDynaInstBase.isUserTagDirty();
            }
            case 43: {
                return pSDevSlnSysDynaInstBase.isUserTag2Dirty();
            }
            case 44: {
                return pSDevSlnSysDynaInstBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsdevcentersvnid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cfgpsdevcentersvnname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getColor()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getExpriedTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"expriedtime", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getExpriedTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instmodelpath", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstModelPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstState() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"inststate", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstState()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag2", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag3", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag3()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag4", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag4()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag5() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag5", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag5()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag6() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag6", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag6()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag7() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag7", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag7()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag8() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttag8", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstTag8()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"insttype", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstType()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstVer() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"instver", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getInstVer()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getLastCheckinTime() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lastcheckintime", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getLastCheckinTime()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelpsdevcentersvnname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPInstModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pinstmodelpath", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPInstModelPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnsysdynainstid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdevslnsysdynainstname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevCenterId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcenterid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevCenterId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevCenterName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevcentername", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevCenterName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdepinstid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdepinstname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysdynainstname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getRefUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refupdatedate", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getRefUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getRootInstModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rootinstmodelpath", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getRootInstModelPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getSysModelPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"sysmodelpath", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getSysModelPath()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnSysDynaInstBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDevSlnSysDynaInstBase.getJSONValue((Object)pSDevSlnSysDynaInstBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnSysDynaInstBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId() != null) {
            object = pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_CFGPSDEVCENTERSVNID, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName() != null) {
            object = pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_CFGPSDEVCENTERSVNNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getColor() != null) {
            object = pSDevSlnSysDynaInstBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getCreateDate() != null) {
            object = pSDevSlnSysDynaInstBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getCreateMan() != null) {
            object = pSDevSlnSysDynaInstBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getExpriedTime() != null) {
            object = pSDevSlnSysDynaInstBase.getExpriedTime();
            xmlNode.setAttribute(FIELD_EXPRIEDTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstModelPath() != null) {
            object = pSDevSlnSysDynaInstBase.getInstModelPath();
            xmlNode.setAttribute(FIELD_INSTMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstState() != null) {
            object = pSDevSlnSysDynaInstBase.getInstState();
            xmlNode.setAttribute(FIELD_INSTSTATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag();
            xmlNode.setAttribute(FIELD_INSTTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag2() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag2();
            xmlNode.setAttribute(FIELD_INSTTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag3() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag3();
            xmlNode.setAttribute(FIELD_INSTTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag4() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag4();
            xmlNode.setAttribute(FIELD_INSTTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag5() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag5();
            xmlNode.setAttribute(FIELD_INSTTAG5, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag6() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag6();
            xmlNode.setAttribute(FIELD_INSTTAG6, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag7() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag7();
            xmlNode.setAttribute(FIELD_INSTTAG7, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstTag8() != null) {
            object = pSDevSlnSysDynaInstBase.getInstTag8();
            xmlNode.setAttribute(FIELD_INSTTAG8, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstType() != null) {
            object = pSDevSlnSysDynaInstBase.getInstType();
            xmlNode.setAttribute(FIELD_INSTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getInstVer() != null) {
            object = pSDevSlnSysDynaInstBase.getInstVer();
            xmlNode.setAttribute(FIELD_INSTVER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getLastCheckinTime() != null) {
            object = pSDevSlnSysDynaInstBase.getLastCheckinTime();
            xmlNode.setAttribute(FIELD_LASTCHECKINTIME, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getLogicName() != null) {
            object = pSDevSlnSysDynaInstBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getMemo() != null) {
            object = pSDevSlnSysDynaInstBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId() != null) {
            object = pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName() != null) {
            object = pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName();
            xmlNode.setAttribute(FIELD_MODELPSDEVCENTERSVNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getOrderValue() != null) {
            object = pSDevSlnSysDynaInstBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getPInstModelPath() != null) {
            object = pSDevSlnSysDynaInstBase.getPInstModelPath();
            xmlNode.setAttribute(FIELD_PINSTMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PPSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PPSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevCenterId() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevCenterId();
            xmlNode.setAttribute(FIELD_PSDEVCENTERID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevCenterName() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevCenterName();
            xmlNode.setAttribute(FIELD_PSDEVCENTERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnId() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnName() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDEPINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDEPINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSDYNAINSTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnSysDynaInstBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getRefUpdateDate() != null) {
            object = pSDevSlnSysDynaInstBase.getRefUpdateDate();
            xmlNode.setAttribute(FIELD_REFUPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getRootInstModelPath() != null) {
            object = pSDevSlnSysDynaInstBase.getRootInstModelPath();
            xmlNode.setAttribute(FIELD_ROOTINSTMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getSysModelPath() != null) {
            object = pSDevSlnSysDynaInstBase.getSysModelPath();
            xmlNode.setAttribute(FIELD_SYSMODELPATH, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUpdateDate() != null) {
            object = pSDevSlnSysDynaInstBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnSysDynaInstBase.getUpdateMan() != null) {
            object = pSDevSlnSysDynaInstBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUserTag() != null) {
            object = pSDevSlnSysDynaInstBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getUserTag2() != null) {
            object = pSDevSlnSysDynaInstBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnSysDynaInstBase.getValidFlag() != null) {
            object = pSDevSlnSysDynaInstBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnSysDynaInstBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnSysDynaInstBase.isCfgPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_CFGPSDEVCENTERSVNID, (Object)pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNId());
        }
        if (pSDevSlnSysDynaInstBase.isCfgPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_CFGPSDEVCENTERSVNNAME, (Object)pSDevSlnSysDynaInstBase.getCfgPSDevCenterSVNName());
        }
        if (pSDevSlnSysDynaInstBase.isColorDirty() && (bl || pSDevSlnSysDynaInstBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSDevSlnSysDynaInstBase.getColor());
        }
        if (pSDevSlnSysDynaInstBase.isCreateDateDirty() && (bl || pSDevSlnSysDynaInstBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnSysDynaInstBase.getCreateDate());
        }
        if (pSDevSlnSysDynaInstBase.isCreateManDirty() && (bl || pSDevSlnSysDynaInstBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnSysDynaInstBase.getCreateMan());
        }
        if (pSDevSlnSysDynaInstBase.isExpriedTimeDirty() && (bl || pSDevSlnSysDynaInstBase.getExpriedTime() != null)) {
            iDataObject.set(FIELD_EXPRIEDTIME, (Object)pSDevSlnSysDynaInstBase.getExpriedTime());
        }
        if (pSDevSlnSysDynaInstBase.isInstModelPathDirty() && (bl || pSDevSlnSysDynaInstBase.getInstModelPath() != null)) {
            iDataObject.set(FIELD_INSTMODELPATH, (Object)pSDevSlnSysDynaInstBase.getInstModelPath());
        }
        if (pSDevSlnSysDynaInstBase.isInstStateDirty() && (bl || pSDevSlnSysDynaInstBase.getInstState() != null)) {
            iDataObject.set(FIELD_INSTSTATE, (Object)pSDevSlnSysDynaInstBase.getInstState());
        }
        if (pSDevSlnSysDynaInstBase.isInstTagDirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag() != null)) {
            iDataObject.set(FIELD_INSTTAG, (Object)pSDevSlnSysDynaInstBase.getInstTag());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag2Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag2() != null)) {
            iDataObject.set(FIELD_INSTTAG2, (Object)pSDevSlnSysDynaInstBase.getInstTag2());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag3Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag3() != null)) {
            iDataObject.set(FIELD_INSTTAG3, (Object)pSDevSlnSysDynaInstBase.getInstTag3());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag4Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag4() != null)) {
            iDataObject.set(FIELD_INSTTAG4, (Object)pSDevSlnSysDynaInstBase.getInstTag4());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag5Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag5() != null)) {
            iDataObject.set(FIELD_INSTTAG5, (Object)pSDevSlnSysDynaInstBase.getInstTag5());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag6Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag6() != null)) {
            iDataObject.set(FIELD_INSTTAG6, (Object)pSDevSlnSysDynaInstBase.getInstTag6());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag7Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag7() != null)) {
            iDataObject.set(FIELD_INSTTAG7, (Object)pSDevSlnSysDynaInstBase.getInstTag7());
        }
        if (pSDevSlnSysDynaInstBase.isInstTag8Dirty() && (bl || pSDevSlnSysDynaInstBase.getInstTag8() != null)) {
            iDataObject.set(FIELD_INSTTAG8, (Object)pSDevSlnSysDynaInstBase.getInstTag8());
        }
        if (pSDevSlnSysDynaInstBase.isInstTypeDirty() && (bl || pSDevSlnSysDynaInstBase.getInstType() != null)) {
            iDataObject.set(FIELD_INSTTYPE, (Object)pSDevSlnSysDynaInstBase.getInstType());
        }
        if (pSDevSlnSysDynaInstBase.isInstVerDirty() && (bl || pSDevSlnSysDynaInstBase.getInstVer() != null)) {
            iDataObject.set(FIELD_INSTVER, (Object)pSDevSlnSysDynaInstBase.getInstVer());
        }
        if (pSDevSlnSysDynaInstBase.isLastCheckinTimeDirty() && (bl || pSDevSlnSysDynaInstBase.getLastCheckinTime() != null)) {
            iDataObject.set(FIELD_LASTCHECKINTIME, (Object)pSDevSlnSysDynaInstBase.getLastCheckinTime());
        }
        if (pSDevSlnSysDynaInstBase.isLogicNameDirty() && (bl || pSDevSlnSysDynaInstBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDevSlnSysDynaInstBase.getLogicName());
        }
        if (pSDevSlnSysDynaInstBase.isMemoDirty() && (bl || pSDevSlnSysDynaInstBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnSysDynaInstBase.getMemo());
        }
        if (pSDevSlnSysDynaInstBase.isModelPSDevCenterSVNIdDirty() && (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNID, (Object)pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNId());
        }
        if (pSDevSlnSysDynaInstBase.isModelPSDevCenterSVNNameDirty() && (bl || pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName() != null)) {
            iDataObject.set(FIELD_MODELPSDEVCENTERSVNNAME, (Object)pSDevSlnSysDynaInstBase.getModelPSDevCenterSVNName());
        }
        if (pSDevSlnSysDynaInstBase.isOrderValueDirty() && (bl || pSDevSlnSysDynaInstBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDevSlnSysDynaInstBase.getOrderValue());
        }
        if (pSDevSlnSysDynaInstBase.isPInstModelPathDirty() && (bl || pSDevSlnSysDynaInstBase.getPInstModelPath() != null)) {
            iDataObject.set(FIELD_PINSTMODELPATH, (Object)pSDevSlnSysDynaInstBase.getPInstModelPath());
        }
        if (pSDevSlnSysDynaInstBase.isPPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnSysDynaInstBase.isPPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PPSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnSysDynaInstBase.getPPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevCenterIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevCenterId() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERID, (Object)pSDevSlnSysDynaInstBase.getPSDevCenterId());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevCenterNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevCenterName() != null)) {
            iDataObject.set(FIELD_PSDEVCENTERNAME, (Object)pSDevSlnSysDynaInstBase.getPSDevCenterName());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnId());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnName());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysDepInstIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDEPINSTID, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstId());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysDepInstNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDEPINSTNAME, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDepInstName());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysDynaInstIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTID, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstId());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysDynaInstNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSDYNAINSTNAME, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysDynaInstName());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysId());
        }
        if (pSDevSlnSysDynaInstBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnSysDynaInstBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnSysDynaInstBase.getPSDevSlnSysName());
        }
        if (pSDevSlnSysDynaInstBase.isRefUpdateDateDirty() && (bl || pSDevSlnSysDynaInstBase.getRefUpdateDate() != null)) {
            iDataObject.set(FIELD_REFUPDATEDATE, (Object)pSDevSlnSysDynaInstBase.getRefUpdateDate());
        }
        if (pSDevSlnSysDynaInstBase.isRootInstModelPathDirty() && (bl || pSDevSlnSysDynaInstBase.getRootInstModelPath() != null)) {
            iDataObject.set(FIELD_ROOTINSTMODELPATH, (Object)pSDevSlnSysDynaInstBase.getRootInstModelPath());
        }
        if (pSDevSlnSysDynaInstBase.isSysModelPathDirty() && (bl || pSDevSlnSysDynaInstBase.getSysModelPath() != null)) {
            iDataObject.set(FIELD_SYSMODELPATH, (Object)pSDevSlnSysDynaInstBase.getSysModelPath());
        }
        if (pSDevSlnSysDynaInstBase.isUpdateDateDirty() && (bl || pSDevSlnSysDynaInstBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnSysDynaInstBase.getUpdateDate());
        }
        if (pSDevSlnSysDynaInstBase.isUpdateManDirty() && (bl || pSDevSlnSysDynaInstBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnSysDynaInstBase.getUpdateMan());
        }
        if (pSDevSlnSysDynaInstBase.isUserTagDirty() && (bl || pSDevSlnSysDynaInstBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnSysDynaInstBase.getUserTag());
        }
        if (pSDevSlnSysDynaInstBase.isUserTag2Dirty() && (bl || pSDevSlnSysDynaInstBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnSysDynaInstBase.getUserTag2());
        }
        if (pSDevSlnSysDynaInstBase.isValidFlagDirty() && (bl || pSDevSlnSysDynaInstBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDevSlnSysDynaInstBase.getValidFlag());
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
        return PSDevSlnSysDynaInstBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnSysDynaInstBase pSDevSlnSysDynaInstBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnSysDynaInstBase.resetCfgPSDevCenterSVNId();
                return true;
            }
            case 1: {
                pSDevSlnSysDynaInstBase.resetCfgPSDevCenterSVNName();
                return true;
            }
            case 2: {
                pSDevSlnSysDynaInstBase.resetColor();
                return true;
            }
            case 3: {
                pSDevSlnSysDynaInstBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSDevSlnSysDynaInstBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSDevSlnSysDynaInstBase.resetExpriedTime();
                return true;
            }
            case 6: {
                pSDevSlnSysDynaInstBase.resetInstModelPath();
                return true;
            }
            case 7: {
                pSDevSlnSysDynaInstBase.resetInstState();
                return true;
            }
            case 8: {
                pSDevSlnSysDynaInstBase.resetInstTag();
                return true;
            }
            case 9: {
                pSDevSlnSysDynaInstBase.resetInstTag2();
                return true;
            }
            case 10: {
                pSDevSlnSysDynaInstBase.resetInstTag3();
                return true;
            }
            case 11: {
                pSDevSlnSysDynaInstBase.resetInstTag4();
                return true;
            }
            case 12: {
                pSDevSlnSysDynaInstBase.resetInstTag5();
                return true;
            }
            case 13: {
                pSDevSlnSysDynaInstBase.resetInstTag6();
                return true;
            }
            case 14: {
                pSDevSlnSysDynaInstBase.resetInstTag7();
                return true;
            }
            case 15: {
                pSDevSlnSysDynaInstBase.resetInstTag8();
                return true;
            }
            case 16: {
                pSDevSlnSysDynaInstBase.resetInstType();
                return true;
            }
            case 17: {
                pSDevSlnSysDynaInstBase.resetInstVer();
                return true;
            }
            case 18: {
                pSDevSlnSysDynaInstBase.resetLastCheckinTime();
                return true;
            }
            case 19: {
                pSDevSlnSysDynaInstBase.resetLogicName();
                return true;
            }
            case 20: {
                pSDevSlnSysDynaInstBase.resetMemo();
                return true;
            }
            case 21: {
                pSDevSlnSysDynaInstBase.resetModelPSDevCenterSVNId();
                return true;
            }
            case 22: {
                pSDevSlnSysDynaInstBase.resetModelPSDevCenterSVNName();
                return true;
            }
            case 23: {
                pSDevSlnSysDynaInstBase.resetOrderValue();
                return true;
            }
            case 24: {
                pSDevSlnSysDynaInstBase.resetPInstModelPath();
                return true;
            }
            case 25: {
                pSDevSlnSysDynaInstBase.resetPPSDevSlnSysDynaInstId();
                return true;
            }
            case 26: {
                pSDevSlnSysDynaInstBase.resetPPSDevSlnSysDynaInstName();
                return true;
            }
            case 27: {
                pSDevSlnSysDynaInstBase.resetPSDevCenterId();
                return true;
            }
            case 28: {
                pSDevSlnSysDynaInstBase.resetPSDevCenterName();
                return true;
            }
            case 29: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnId();
                return true;
            }
            case 30: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnName();
                return true;
            }
            case 31: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysDepInstId();
                return true;
            }
            case 32: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysDepInstName();
                return true;
            }
            case 33: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysDynaInstId();
                return true;
            }
            case 34: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysDynaInstName();
                return true;
            }
            case 35: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysId();
                return true;
            }
            case 36: {
                pSDevSlnSysDynaInstBase.resetPSDevSlnSysName();
                return true;
            }
            case 37: {
                pSDevSlnSysDynaInstBase.resetRefUpdateDate();
                return true;
            }
            case 38: {
                pSDevSlnSysDynaInstBase.resetRootInstModelPath();
                return true;
            }
            case 39: {
                pSDevSlnSysDynaInstBase.resetSysModelPath();
                return true;
            }
            case 40: {
                pSDevSlnSysDynaInstBase.resetUpdateDate();
                return true;
            }
            case 41: {
                pSDevSlnSysDynaInstBase.resetUpdateMan();
                return true;
            }
            case 42: {
                pSDevSlnSysDynaInstBase.resetUserTag();
                return true;
            }
            case 43: {
                pSDevSlnSysDynaInstBase.resetUserTag2();
                return true;
            }
            case 44: {
                pSDevSlnSysDynaInstBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getCfgPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCfgPSDevCenterSVN();
        }
        if (this.getCfgPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objCfgPSDevCenterSVNLock;
        synchronized (n) {
            if (this.cfgpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getCfgPSDevCenterSVNId(), (Object)this.cfgpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.cfgpsdevcentersvn = null;
            }
            if (this.cfgpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getCfgPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.cfgpsdevcentersvn = pSDevCenterSVN;
            }
            return this.cfgpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenterSVN getModelPSDevCenterSVN() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelPSDevCenterSVN();
        }
        if (this.getModelPSDevCenterSVNId() == null) {
            return null;
        }
        Integer n = this.objModelPSDevCenterSVNLock;
        synchronized (n) {
            if (this.modelpsdevcentersvn != null && DataTypeHelper.compare((int)25, (Object)this.getModelPSDevCenterSVNId(), (Object)this.modelpsdevcentersvn.getPSDevCenterSVNId()) != 0L) {
                this.modelpsdevcentersvn = null;
            }
            if (this.modelpsdevcentersvn == null) {
                PSDevCenterSVN pSDevCenterSVN = new PSDevCenterSVN();
                pSDevCenterSVN.setPSDevCenterSVNId(this.getModelPSDevCenterSVNId());
                PSDevCenterSVNService pSDevCenterSVNService = (PSDevCenterSVNService)ServiceGlobal.getService(PSDevCenterSVNService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterSVNService.autoGet((IEntity)pSDevCenterSVN);
                this.modelpsdevcentersvn = pSDevCenterSVN;
            }
            return this.modelpsdevcentersvn;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevCenter getPSDevCenter() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevCenter();
        }
        if (this.getPSDevCenterId() == null) {
            return null;
        }
        Integer n = this.objPSDevCenterLock;
        synchronized (n) {
            if (this.psdevcenter != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevCenterId(), (Object)this.psdevcenter.getPSDevCenterId()) != 0L) {
                this.psdevcenter = null;
            }
            if (this.psdevcenter == null) {
                PSDevCenter pSDevCenter = new PSDevCenter();
                pSDevCenter.setPSDevCenterId(this.getPSDevCenterId());
                PSDevCenterService pSDevCenterService = (PSDevCenterService)ServiceGlobal.getService(PSDevCenterService.class, (SessionFactory)this.getSessionFactory());
                pSDevCenterService.autoGet((IEntity)pSDevCenter);
                this.psdevcenter = pSDevCenter;
            }
            return this.psdevcenter;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDepInst getPSDevSlnSysDepInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDepInst();
        }
        if (this.getPSDevSlnSysDepInstId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysDepInstLock;
        synchronized (n) {
            if (this.psdevslnsysdepinst != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysDepInstId(), (Object)this.psdevslnsysdepinst.getPSDevSlnSysDepInstId()) != 0L) {
                this.psdevslnsysdepinst = null;
            }
            if (this.psdevslnsysdepinst == null) {
                PSDevSlnSysDepInst pSDevSlnSysDepInst = new PSDevSlnSysDepInst();
                pSDevSlnSysDepInst.setPSDevSlnSysDepInstId(this.getPSDevSlnSysDepInstId());
                PSDevSlnSysDepInstService pSDevSlnSysDepInstService = (PSDevSlnSysDepInstService)ServiceGlobal.getService(PSDevSlnSysDepInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDepInstService.autoGet((IEntity)pSDevSlnSysDepInst);
                this.psdevslnsysdepinst = pSDevSlnSysDepInst;
            }
            return this.psdevslnsysdepinst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSysDynaInst getPPSDevSlnSysDynaInst() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDevSlnSysDynaInst();
        }
        if (this.getPPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        Integer n = this.objPPSDevSlnSysDynaInstLock;
        synchronized (n) {
            if (this.ppsdevslnsysdynainst != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDevSlnSysDynaInstId(), (Object)this.ppsdevslnsysdynainst.getPSDevSlnSysDynaInstId()) != 0L) {
                this.ppsdevslnsysdynainst = null;
            }
            if (this.ppsdevslnsysdynainst == null) {
                PSDevSlnSysDynaInst pSDevSlnSysDynaInst = new PSDevSlnSysDynaInst();
                pSDevSlnSysDynaInst.setPSDevSlnSysDynaInstId(this.getPPSDevSlnSysDynaInstId());
                PSDevSlnSysDynaInstService pSDevSlnSysDynaInstService = (PSDevSlnSysDynaInstService)ServiceGlobal.getService(PSDevSlnSysDynaInstService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysDynaInstService.autoGet((IEntity)pSDevSlnSysDynaInst);
                this.ppsdevslnsysdynainst = pSDevSlnSysDynaInst;
            }
            return this.ppsdevslnsysdynainst;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet((IEntity)pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet((IEntity)pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDevSlnSysDynaInstRef> getPSDevSlnSysDynaInstRefs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysDynaInstRefs();
        }
        if (this.getPSDevSlnSysDynaInstId() == null) {
            return null;
        }
        PSDevSlnSysDynaInstRefService pSDevSlnSysDynaInstRefService = (PSDevSlnSysDynaInstRefService)ServiceGlobal.getService(PSDevSlnSysDynaInstRefService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDevSlnSysDynaInstRefsLock;
        synchronized (n) {
            if (this.psdevslnsysdynainstrefs == null) {
                this.psdevslnsysdynainstrefs = pSDevSlnSysDynaInstRefService.selectByPSDevSlnSysDynaInst(this);
            }
            return this.psdevslnsysdynainstrefs;
        }
    }

    private PSDevSlnSysDynaInstBase getProxyEntity() {
        return this.proxyPSDevSlnSysDynaInstBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnSysDynaInstBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnSysDynaInstBase) {
            this.proxyPSDevSlnSysDynaInstBase = (PSDevSlnSysDynaInstBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dynasys.service.PSDevSlnSysDynaInstService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CFGPSDEVCENTERSVNID, 0);
        fieldIndexMap.put(FIELD_CFGPSDEVCENTERSVNNAME, 1);
        fieldIndexMap.put(FIELD_COLOR, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_EXPRIEDTIME, 5);
        fieldIndexMap.put(FIELD_INSTMODELPATH, 6);
        fieldIndexMap.put(FIELD_INSTSTATE, 7);
        fieldIndexMap.put(FIELD_INSTTAG, 8);
        fieldIndexMap.put(FIELD_INSTTAG2, 9);
        fieldIndexMap.put(FIELD_INSTTAG3, 10);
        fieldIndexMap.put(FIELD_INSTTAG4, 11);
        fieldIndexMap.put(FIELD_INSTTAG5, 12);
        fieldIndexMap.put(FIELD_INSTTAG6, 13);
        fieldIndexMap.put(FIELD_INSTTAG7, 14);
        fieldIndexMap.put(FIELD_INSTTAG8, 15);
        fieldIndexMap.put(FIELD_INSTTYPE, 16);
        fieldIndexMap.put(FIELD_INSTVER, 17);
        fieldIndexMap.put(FIELD_LASTCHECKINTIME, 18);
        fieldIndexMap.put(FIELD_LOGICNAME, 19);
        fieldIndexMap.put(FIELD_MEMO, 20);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNID, 21);
        fieldIndexMap.put(FIELD_MODELPSDEVCENTERSVNNAME, 22);
        fieldIndexMap.put(FIELD_ORDERVALUE, 23);
        fieldIndexMap.put(FIELD_PINSTMODELPATH, 24);
        fieldIndexMap.put(FIELD_PPSDEVSLNSYSDYNAINSTID, 25);
        fieldIndexMap.put(FIELD_PPSDEVSLNSYSDYNAINSTNAME, 26);
        fieldIndexMap.put(FIELD_PSDEVCENTERID, 27);
        fieldIndexMap.put(FIELD_PSDEVCENTERNAME, 28);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 29);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 30);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDEPINSTID, 31);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDEPINSTNAME, 32);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTID, 33);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSDYNAINSTNAME, 34);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 35);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 36);
        fieldIndexMap.put(FIELD_REFUPDATEDATE, 37);
        fieldIndexMap.put(FIELD_ROOTINSTMODELPATH, 38);
        fieldIndexMap.put(FIELD_SYSMODELPATH, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 40);
        fieldIndexMap.put(FIELD_UPDATEMAN, 41);
        fieldIndexMap.put(FIELD_USERTAG, 42);
        fieldIndexMap.put(FIELD_USERTAG2, 43);
        fieldIndexMap.put(FIELD_VALIDFLAG, 44);
    }
}

