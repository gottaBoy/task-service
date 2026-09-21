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
import net.ibizsys.pscore.srv.dedesign.entity.PSDELLCond;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogic;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDELogicParam;
import net.ibizsys.pscore.srv.dedesign.service.PSDELLCondService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicParamService;
import net.ibizsys.pscore.srv.dedesign.service.PSDELogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDELogicLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDELogicLinkBase.class);
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEBUGMODE = "DEBUGMODE";
    public static final String FIELD_DEFAULTLINK = "DEFAULTLINK";
    public static final String FIELD_DSTENDPOINT = "DSTENDPOINT";
    public static final String FIELD_DSTPSDELOGICNODEID = "DSTPSDELOGICNODEID";
    public static final String FIELD_DSTPSDELOGICNODENAME = "DSTPSDELOGICNODENAME";
    public static final String FIELD_DSTPSDLPARAMID = "DSTPSDLPARAMID";
    public static final String FIELD_DSTPSDLPARAMNAME = "DSTPSDLPARAMNAME";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_LINKCOND = "LINKCOND";
    public static final String FIELD_LINKCOND2 = "LINKCOND2";
    public static final String FIELD_LINKINFO = "LINKINFO";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDELOGICID = "PSDELOGICID";
    public static final String FIELD_PSDELOGICLINKID = "PSDELOGICLINKID";
    public static final String FIELD_PSDELOGICLINKNAME = "PSDELOGICLINKNAME";
    public static final String FIELD_PSDELOGICNAME = "PSDELOGICNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_SHAPEPARAMS = "SHAPEPARAMS";
    public static final String FIELD_SRCENDPOINT = "SRCENDPOINT";
    public static final String FIELD_SRCPSDELOGICNODEID = "SRCPSDELOGICNODEID";
    public static final String FIELD_SRCPSDELOGICNODENAME = "SRCPSDELOGICNODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CONDMODEL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_DEBUGMODE = 3;
    private static final int INDEX_DEFAULTLINK = 4;
    private static final int INDEX_DSTENDPOINT = 5;
    private static final int INDEX_DSTPSDELOGICNODEID = 6;
    private static final int INDEX_DSTPSDELOGICNODENAME = 7;
    private static final int INDEX_DSTPSDLPARAMID = 8;
    private static final int INDEX_DSTPSDLPARAMNAME = 9;
    private static final int INDEX_DYNAMODELFLAG = 10;
    private static final int INDEX_LINKCOND = 11;
    private static final int INDEX_LINKCOND2 = 12;
    private static final int INDEX_LINKINFO = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PSDEID = 16;
    private static final int INDEX_PSDELOGICID = 17;
    private static final int INDEX_PSDELOGICLINKID = 18;
    private static final int INDEX_PSDELOGICLINKNAME = 19;
    private static final int INDEX_PSDELOGICNAME = 20;
    private static final int INDEX_PSDYNAINSTID = 21;
    private static final int INDEX_PSSYSTEMID = 22;
    private static final int INDEX_SHAPEPARAMS = 23;
    private static final int INDEX_SRCENDPOINT = 24;
    private static final int INDEX_SRCPSDELOGICNODEID = 25;
    private static final int INDEX_SRCPSDELOGICNODENAME = 26;
    private static final int INDEX_UPDATEDATE = 27;
    private static final int INDEX_UPDATEMAN = 28;
    private static final int INDEX_USERCAT = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final int INDEX_USERTAG3 = 32;
    private static final int INDEX_USERTAG4 = 33;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDELogicLinkBase proxyPSDELogicLinkBase = null;
    private boolean condmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean debugmodeDirtyFlag = false;
    private boolean defaultlinkDirtyFlag = false;
    private boolean dstendpointDirtyFlag = false;
    private boolean dstpsdelogicnodeidDirtyFlag = false;
    private boolean dstpsdelogicnodenameDirtyFlag = false;
    private boolean dstpsdlparamidDirtyFlag = false;
    private boolean dstpsdlparamnameDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean linkcondDirtyFlag = false;
    private boolean linkcond2DirtyFlag = false;
    private boolean linkinfoDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdelogicidDirtyFlag = false;
    private boolean psdelogiclinkidDirtyFlag = false;
    private boolean psdelogiclinknameDirtyFlag = false;
    private boolean psdelogicnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean shapeparamsDirtyFlag = false;
    private boolean srcendpointDirtyFlag = false;
    private boolean srcpsdelogicnodeidDirtyFlag = false;
    private boolean srcpsdelogicnodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="debugmode")
    private Integer debugmode;
    @Column(name="defaultlink")
    private Integer defaultlink;
    @Column(name="dstendpoint")
    private String dstendpoint;
    @Column(name="dstpsdelogicnodeid")
    private String dstpsdelogicnodeid;
    @Column(name="dstpsdelogicnodename")
    private String dstpsdelogicnodename;
    @Column(name="dstpsdlparamid")
    private String dstpsdlparamid;
    @Column(name="dstpsdlparamname")
    private String dstpsdlparamname;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="linkcond")
    private String linkcond;
    @Column(name="linkcond2")
    private String linkcond2;
    @Column(name="linkinfo")
    private String linkinfo;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdelogicid")
    private String psdelogicid;
    @Column(name="psdelogiclinkid")
    private String psdelogiclinkid;
    @Column(name="psdelogiclinkname")
    private String psdelogiclinkname;
    @Column(name="psdelogicname")
    private String psdelogicname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="shapeparams")
    private String shapeparams;
    @Column(name="srcendpoint")
    private String srcendpoint;
    @Column(name="srcpsdelogicnodeid")
    private String srcpsdelogicnodeid;
    @Column(name="srcpsdelogicnodename")
    private String srcpsdelogicnodename;
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
    private Integer objDstPSDELogicNodeLock = new Integer(1);
    private PSDELogicNode dstpsdelogicnode = null;
    private Integer objSrcPSDELogicNodeLock = new Integer(1);
    private PSDELogicNode srcpsdelogicnode = null;
    private Integer objDstPSDLParamLock = new Integer(1);
    private PSDELogicParam dstpsdlparam = null;
    private Integer objPSDELogicLock = new Integer(1);
    private PSDELogic psdelogic = null;
    private Integer objPSDELLCondsLock = new Integer(1);
    private ArrayList<PSDELLCond> psdellconds = null;

    public void setCondModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condmodel = string;
        this.condmodelDirtyFlag = true;
    }

    public String getCondModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondModel();
        }
        return this.condmodel;
    }

    public boolean isCondModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondModelDirty();
        }
        return this.condmodelDirtyFlag;
    }

    public void resetCondModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondModel();
            return;
        }
        this.condmodelDirtyFlag = false;
        this.condmodel = null;
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

    public void setDebugMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDebugMode(n);
            return;
        }
        this.debugmode = n;
        this.debugmodeDirtyFlag = true;
    }

    public Integer getDebugMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDebugMode();
        }
        return this.debugmode;
    }

    public boolean isDebugModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDebugModeDirty();
        }
        return this.debugmodeDirtyFlag;
    }

    public void resetDebugMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDebugMode();
            return;
        }
        this.debugmodeDirtyFlag = false;
        this.debugmode = null;
    }

    public void setDefaultLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultLink(n);
            return;
        }
        this.defaultlink = n;
        this.defaultlinkDirtyFlag = true;
    }

    public Integer getDefaultLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultLink();
        }
        return this.defaultlink;
    }

    public boolean isDefaultLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultLinkDirty();
        }
        return this.defaultlinkDirtyFlag;
    }

    public void resetDefaultLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultLink();
            return;
        }
        this.defaultlinkDirtyFlag = false;
        this.defaultlink = null;
    }

    public void setDstEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstendpoint = string;
        this.dstendpointDirtyFlag = true;
    }

    public String getDstEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstEndPoint();
        }
        return this.dstendpoint;
    }

    public boolean isDstEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstEndPointDirty();
        }
        return this.dstendpointDirtyFlag;
    }

    public void resetDstEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstEndPoint();
            return;
        }
        this.dstendpointDirtyFlag = false;
        this.dstendpoint = null;
    }

    public void setDstPSDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicnodeid = string;
        this.dstpsdelogicnodeidDirtyFlag = true;
    }

    public String getDstPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicNodeId();
        }
        return this.dstpsdelogicnodeid;
    }

    public boolean isDstPSDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicNodeIdDirty();
        }
        return this.dstpsdelogicnodeidDirtyFlag;
    }

    public void resetDstPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicNodeId();
            return;
        }
        this.dstpsdelogicnodeidDirtyFlag = false;
        this.dstpsdelogicnodeid = null;
    }

    public void setDstPSDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdelogicnodename = string;
        this.dstpsdelogicnodenameDirtyFlag = true;
    }

    public String getDstPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicNodeName();
        }
        return this.dstpsdelogicnodename;
    }

    public boolean isDstPSDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDELogicNodeNameDirty();
        }
        return this.dstpsdelogicnodenameDirtyFlag;
    }

    public void resetDstPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDELogicNodeName();
            return;
        }
        this.dstpsdelogicnodenameDirtyFlag = false;
        this.dstpsdelogicnodename = null;
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

    public void setLinkCond(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkCond(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkcond = string;
        this.linkcondDirtyFlag = true;
    }

    public String getLinkCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkCond();
        }
        return this.linkcond;
    }

    public boolean isLinkCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkCondDirty();
        }
        return this.linkcondDirtyFlag;
    }

    public void resetLinkCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkCond();
            return;
        }
        this.linkcondDirtyFlag = false;
        this.linkcond = null;
    }

    public void setLinkCond2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkCond2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkcond2 = string;
        this.linkcond2DirtyFlag = true;
    }

    public String getLinkCond2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkCond2();
        }
        return this.linkcond2;
    }

    public boolean isLinkCond2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkCond2Dirty();
        }
        return this.linkcond2DirtyFlag;
    }

    public void resetLinkCond2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkCond2();
            return;
        }
        this.linkcond2DirtyFlag = false;
        this.linkcond2 = null;
    }

    public void setLinkInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linkinfo = string;
        this.linkinfoDirtyFlag = true;
    }

    public String getLinkInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkInfo();
        }
        return this.linkinfo;
    }

    public boolean isLinkInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkInfoDirty();
        }
        return this.linkinfoDirtyFlag;
    }

    public void resetLinkInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkInfo();
            return;
        }
        this.linkinfoDirtyFlag = false;
        this.linkinfo = null;
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

    public void setPSDELogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDELogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelogicname = string;
        this.psdelogicnameDirtyFlag = true;
    }

    public String getPSDELogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogicName();
        }
        return this.psdelogicname;
    }

    public boolean isPSDELogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDELogicNameDirty();
        }
        return this.psdelogicnameDirtyFlag;
    }

    public void resetPSDELogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDELogicName();
            return;
        }
        this.psdelogicnameDirtyFlag = false;
        this.psdelogicname = null;
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

    public void setPSSystemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemid = string;
        this.pssystemidDirtyFlag = true;
    }

    public String getPSSystemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemId();
        }
        return this.pssystemid;
    }

    public boolean isPSSystemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemIdDirty();
        }
        return this.pssystemidDirtyFlag;
    }

    public void resetPSSystemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemId();
            return;
        }
        this.pssystemidDirtyFlag = false;
        this.pssystemid = null;
    }

    public void setShapeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShapeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shapeparams = string;
        this.shapeparamsDirtyFlag = true;
    }

    public String getShapeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShapeParams();
        }
        return this.shapeparams;
    }

    public boolean isShapeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShapeParamsDirty();
        }
        return this.shapeparamsDirtyFlag;
    }

    public void resetShapeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShapeParams();
            return;
        }
        this.shapeparamsDirtyFlag = false;
        this.shapeparams = null;
    }

    public void setSrcEndPoint(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcEndPoint(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcendpoint = string;
        this.srcendpointDirtyFlag = true;
    }

    public String getSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcEndPoint();
        }
        return this.srcendpoint;
    }

    public boolean isSrcEndPointDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcEndPointDirty();
        }
        return this.srcendpointDirtyFlag;
    }

    public void resetSrcEndPoint() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcEndPoint();
            return;
        }
        this.srcendpointDirtyFlag = false;
        this.srcendpoint = null;
    }

    public void setSrcPSDELogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDELogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdelogicnodeid = string;
        this.srcpsdelogicnodeidDirtyFlag = true;
    }

    public String getSrcPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDELogicNodeId();
        }
        return this.srcpsdelogicnodeid;
    }

    public boolean isSrcPSDELogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDELogicNodeIdDirty();
        }
        return this.srcpsdelogicnodeidDirtyFlag;
    }

    public void resetSrcPSDELogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDELogicNodeId();
            return;
        }
        this.srcpsdelogicnodeidDirtyFlag = false;
        this.srcpsdelogicnodeid = null;
    }

    public void setSrcPSDELogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSDELogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpsdelogicnodename = string;
        this.srcpsdelogicnodenameDirtyFlag = true;
    }

    public String getSrcPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDELogicNodeName();
        }
        return this.srcpsdelogicnodename;
    }

    public boolean isSrcPSDELogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSDELogicNodeNameDirty();
        }
        return this.srcpsdelogicnodenameDirtyFlag;
    }

    public void resetSrcPSDELogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSDELogicNodeName();
            return;
        }
        this.srcpsdelogicnodenameDirtyFlag = false;
        this.srcpsdelogicnodename = null;
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
        PSDELogicLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDELogicLinkBase pSDELogicLinkBase) {
        pSDELogicLinkBase.resetCondModel();
        pSDELogicLinkBase.resetCreateDate();
        pSDELogicLinkBase.resetCreateMan();
        pSDELogicLinkBase.resetDebugMode();
        pSDELogicLinkBase.resetDefaultLink();
        pSDELogicLinkBase.resetDstEndPoint();
        pSDELogicLinkBase.resetDstPSDELogicNodeId();
        pSDELogicLinkBase.resetDstPSDELogicNodeName();
        pSDELogicLinkBase.resetDstPSDLParamId();
        pSDELogicLinkBase.resetDstPSDLParamName();
        pSDELogicLinkBase.resetDynaModelFlag();
        pSDELogicLinkBase.resetLinkCond();
        pSDELogicLinkBase.resetLinkCond2();
        pSDELogicLinkBase.resetLinkInfo();
        pSDELogicLinkBase.resetMemo();
        pSDELogicLinkBase.resetOrderValue();
        pSDELogicLinkBase.resetPSDEId();
        pSDELogicLinkBase.resetPSDELogicId();
        pSDELogicLinkBase.resetPSDELogicLinkId();
        pSDELogicLinkBase.resetPSDELogicLinkName();
        pSDELogicLinkBase.resetPSDELogicName();
        pSDELogicLinkBase.resetPSDynaInstId();
        pSDELogicLinkBase.resetPSSystemId();
        pSDELogicLinkBase.resetShapeParams();
        pSDELogicLinkBase.resetSrcEndPoint();
        pSDELogicLinkBase.resetSrcPSDELogicNodeId();
        pSDELogicLinkBase.resetSrcPSDELogicNodeName();
        pSDELogicLinkBase.resetUpdateDate();
        pSDELogicLinkBase.resetUpdateMan();
        pSDELogicLinkBase.resetUserCat();
        pSDELogicLinkBase.resetUserTag();
        pSDELogicLinkBase.resetUserTag2();
        pSDELogicLinkBase.resetUserTag3();
        pSDELogicLinkBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDebugModeDirty()) {
            hashMap.put(FIELD_DEBUGMODE, this.getDebugMode());
        }
        if (!bl || this.isDefaultLinkDirty()) {
            hashMap.put(FIELD_DEFAULTLINK, this.getDefaultLink());
        }
        if (!bl || this.isDstEndPointDirty()) {
            hashMap.put(FIELD_DSTENDPOINT, this.getDstEndPoint());
        }
        if (!bl || this.isDstPSDELogicNodeIdDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICNODEID, this.getDstPSDELogicNodeId());
        }
        if (!bl || this.isDstPSDELogicNodeNameDirty()) {
            hashMap.put(FIELD_DSTPSDELOGICNODENAME, this.getDstPSDELogicNodeName());
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
        if (!bl || this.isLinkCondDirty()) {
            hashMap.put(FIELD_LINKCOND, this.getLinkCond());
        }
        if (!bl || this.isLinkCond2Dirty()) {
            hashMap.put(FIELD_LINKCOND2, this.getLinkCond2());
        }
        if (!bl || this.isLinkInfoDirty()) {
            hashMap.put(FIELD_LINKINFO, this.getLinkInfo());
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
        if (!bl || this.isPSDELogicIdDirty()) {
            hashMap.put(FIELD_PSDELOGICID, this.getPSDELogicId());
        }
        if (!bl || this.isPSDELogicLinkIdDirty()) {
            hashMap.put(FIELD_PSDELOGICLINKID, this.getPSDELogicLinkId());
        }
        if (!bl || this.isPSDELogicLinkNameDirty()) {
            hashMap.put(FIELD_PSDELOGICLINKNAME, this.getPSDELogicLinkName());
        }
        if (!bl || this.isPSDELogicNameDirty()) {
            hashMap.put(FIELD_PSDELOGICNAME, this.getPSDELogicName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isShapeParamsDirty()) {
            hashMap.put(FIELD_SHAPEPARAMS, this.getShapeParams());
        }
        if (!bl || this.isSrcEndPointDirty()) {
            hashMap.put(FIELD_SRCENDPOINT, this.getSrcEndPoint());
        }
        if (!bl || this.isSrcPSDELogicNodeIdDirty()) {
            hashMap.put(FIELD_SRCPSDELOGICNODEID, this.getSrcPSDELogicNodeId());
        }
        if (!bl || this.isSrcPSDELogicNodeNameDirty()) {
            hashMap.put(FIELD_SRCPSDELOGICNODENAME, this.getSrcPSDELogicNodeName());
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
        return PSDELogicLinkBase.get(this, n);
    }

    private static Object get(PSDELogicLinkBase pSDELogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicLinkBase.getCondModel();
            }
            case 1: {
                return pSDELogicLinkBase.getCreateDate();
            }
            case 2: {
                return pSDELogicLinkBase.getCreateMan();
            }
            case 3: {
                return pSDELogicLinkBase.getDebugMode();
            }
            case 4: {
                return pSDELogicLinkBase.getDefaultLink();
            }
            case 5: {
                return pSDELogicLinkBase.getDstEndPoint();
            }
            case 6: {
                return pSDELogicLinkBase.getDstPSDELogicNodeId();
            }
            case 7: {
                return pSDELogicLinkBase.getDstPSDELogicNodeName();
            }
            case 8: {
                return pSDELogicLinkBase.getDstPSDLParamId();
            }
            case 9: {
                return pSDELogicLinkBase.getDstPSDLParamName();
            }
            case 10: {
                return pSDELogicLinkBase.getDynaModelFlag();
            }
            case 11: {
                return pSDELogicLinkBase.getLinkCond();
            }
            case 12: {
                return pSDELogicLinkBase.getLinkCond2();
            }
            case 13: {
                return pSDELogicLinkBase.getLinkInfo();
            }
            case 14: {
                return pSDELogicLinkBase.getMemo();
            }
            case 15: {
                return pSDELogicLinkBase.getOrderValue();
            }
            case 16: {
                return pSDELogicLinkBase.getPSDEId();
            }
            case 17: {
                return pSDELogicLinkBase.getPSDELogicId();
            }
            case 18: {
                return pSDELogicLinkBase.getPSDELogicLinkId();
            }
            case 19: {
                return pSDELogicLinkBase.getPSDELogicLinkName();
            }
            case 20: {
                return pSDELogicLinkBase.getPSDELogicName();
            }
            case 21: {
                return pSDELogicLinkBase.getPSDynaInstId();
            }
            case 22: {
                return pSDELogicLinkBase.getPSSystemId();
            }
            case 23: {
                return pSDELogicLinkBase.getShapeParams();
            }
            case 24: {
                return pSDELogicLinkBase.getSrcEndPoint();
            }
            case 25: {
                return pSDELogicLinkBase.getSrcPSDELogicNodeId();
            }
            case 26: {
                return pSDELogicLinkBase.getSrcPSDELogicNodeName();
            }
            case 27: {
                return pSDELogicLinkBase.getUpdateDate();
            }
            case 28: {
                return pSDELogicLinkBase.getUpdateMan();
            }
            case 29: {
                return pSDELogicLinkBase.getUserCat();
            }
            case 30: {
                return pSDELogicLinkBase.getUserTag();
            }
            case 31: {
                return pSDELogicLinkBase.getUserTag2();
            }
            case 32: {
                return pSDELogicLinkBase.getUserTag3();
            }
            case 33: {
                return pSDELogicLinkBase.getUserTag4();
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
        PSDELogicLinkBase.set(this, n, object);
    }

    private static void set(PSDELogicLinkBase pSDELogicLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicLinkBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDELogicLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSDELogicLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDELogicLinkBase.setDebugMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDELogicLinkBase.setDefaultLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSDELogicLinkBase.setDstEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDELogicLinkBase.setDstPSDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDELogicLinkBase.setDstPSDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDELogicLinkBase.setDstPSDLParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDELogicLinkBase.setDstPSDLParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDELogicLinkBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDELogicLinkBase.setLinkCond(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDELogicLinkBase.setLinkCond2(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDELogicLinkBase.setLinkInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDELogicLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDELogicLinkBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSDELogicLinkBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDELogicLinkBase.setPSDELogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDELogicLinkBase.setPSDELogicLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDELogicLinkBase.setPSDELogicLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDELogicLinkBase.setPSDELogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDELogicLinkBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDELogicLinkBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDELogicLinkBase.setShapeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDELogicLinkBase.setSrcEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDELogicLinkBase.setSrcPSDELogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDELogicLinkBase.setSrcPSDELogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDELogicLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 28: {
                pSDELogicLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDELogicLinkBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDELogicLinkBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDELogicLinkBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDELogicLinkBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDELogicLinkBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDELogicLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSDELogicLinkBase pSDELogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicLinkBase.getCondModel() == null;
            }
            case 1: {
                return pSDELogicLinkBase.getCreateDate() == null;
            }
            case 2: {
                return pSDELogicLinkBase.getCreateMan() == null;
            }
            case 3: {
                return pSDELogicLinkBase.getDebugMode() == null;
            }
            case 4: {
                return pSDELogicLinkBase.getDefaultLink() == null;
            }
            case 5: {
                return pSDELogicLinkBase.getDstEndPoint() == null;
            }
            case 6: {
                return pSDELogicLinkBase.getDstPSDELogicNodeId() == null;
            }
            case 7: {
                return pSDELogicLinkBase.getDstPSDELogicNodeName() == null;
            }
            case 8: {
                return pSDELogicLinkBase.getDstPSDLParamId() == null;
            }
            case 9: {
                return pSDELogicLinkBase.getDstPSDLParamName() == null;
            }
            case 10: {
                return pSDELogicLinkBase.getDynaModelFlag() == null;
            }
            case 11: {
                return pSDELogicLinkBase.getLinkCond() == null;
            }
            case 12: {
                return pSDELogicLinkBase.getLinkCond2() == null;
            }
            case 13: {
                return pSDELogicLinkBase.getLinkInfo() == null;
            }
            case 14: {
                return pSDELogicLinkBase.getMemo() == null;
            }
            case 15: {
                return pSDELogicLinkBase.getOrderValue() == null;
            }
            case 16: {
                return pSDELogicLinkBase.getPSDEId() == null;
            }
            case 17: {
                return pSDELogicLinkBase.getPSDELogicId() == null;
            }
            case 18: {
                return pSDELogicLinkBase.getPSDELogicLinkId() == null;
            }
            case 19: {
                return pSDELogicLinkBase.getPSDELogicLinkName() == null;
            }
            case 20: {
                return pSDELogicLinkBase.getPSDELogicName() == null;
            }
            case 21: {
                return pSDELogicLinkBase.getPSDynaInstId() == null;
            }
            case 22: {
                return pSDELogicLinkBase.getPSSystemId() == null;
            }
            case 23: {
                return pSDELogicLinkBase.getShapeParams() == null;
            }
            case 24: {
                return pSDELogicLinkBase.getSrcEndPoint() == null;
            }
            case 25: {
                return pSDELogicLinkBase.getSrcPSDELogicNodeId() == null;
            }
            case 26: {
                return pSDELogicLinkBase.getSrcPSDELogicNodeName() == null;
            }
            case 27: {
                return pSDELogicLinkBase.getUpdateDate() == null;
            }
            case 28: {
                return pSDELogicLinkBase.getUpdateMan() == null;
            }
            case 29: {
                return pSDELogicLinkBase.getUserCat() == null;
            }
            case 30: {
                return pSDELogicLinkBase.getUserTag() == null;
            }
            case 31: {
                return pSDELogicLinkBase.getUserTag2() == null;
            }
            case 32: {
                return pSDELogicLinkBase.getUserTag3() == null;
            }
            case 33: {
                return pSDELogicLinkBase.getUserTag4() == null;
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
        return PSDELogicLinkBase.contains(this, n);
    }

    private static boolean contains(PSDELogicLinkBase pSDELogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDELogicLinkBase.isCondModelDirty();
            }
            case 1: {
                return pSDELogicLinkBase.isCreateDateDirty();
            }
            case 2: {
                return pSDELogicLinkBase.isCreateManDirty();
            }
            case 3: {
                return pSDELogicLinkBase.isDebugModeDirty();
            }
            case 4: {
                return pSDELogicLinkBase.isDefaultLinkDirty();
            }
            case 5: {
                return pSDELogicLinkBase.isDstEndPointDirty();
            }
            case 6: {
                return pSDELogicLinkBase.isDstPSDELogicNodeIdDirty();
            }
            case 7: {
                return pSDELogicLinkBase.isDstPSDELogicNodeNameDirty();
            }
            case 8: {
                return pSDELogicLinkBase.isDstPSDLParamIdDirty();
            }
            case 9: {
                return pSDELogicLinkBase.isDstPSDLParamNameDirty();
            }
            case 10: {
                return pSDELogicLinkBase.isDynaModelFlagDirty();
            }
            case 11: {
                return pSDELogicLinkBase.isLinkCondDirty();
            }
            case 12: {
                return pSDELogicLinkBase.isLinkCond2Dirty();
            }
            case 13: {
                return pSDELogicLinkBase.isLinkInfoDirty();
            }
            case 14: {
                return pSDELogicLinkBase.isMemoDirty();
            }
            case 15: {
                return pSDELogicLinkBase.isOrderValueDirty();
            }
            case 16: {
                return pSDELogicLinkBase.isPSDEIdDirty();
            }
            case 17: {
                return pSDELogicLinkBase.isPSDELogicIdDirty();
            }
            case 18: {
                return pSDELogicLinkBase.isPSDELogicLinkIdDirty();
            }
            case 19: {
                return pSDELogicLinkBase.isPSDELogicLinkNameDirty();
            }
            case 20: {
                return pSDELogicLinkBase.isPSDELogicNameDirty();
            }
            case 21: {
                return pSDELogicLinkBase.isPSDynaInstIdDirty();
            }
            case 22: {
                return pSDELogicLinkBase.isPSSystemIdDirty();
            }
            case 23: {
                return pSDELogicLinkBase.isShapeParamsDirty();
            }
            case 24: {
                return pSDELogicLinkBase.isSrcEndPointDirty();
            }
            case 25: {
                return pSDELogicLinkBase.isSrcPSDELogicNodeIdDirty();
            }
            case 26: {
                return pSDELogicLinkBase.isSrcPSDELogicNodeNameDirty();
            }
            case 27: {
                return pSDELogicLinkBase.isUpdateDateDirty();
            }
            case 28: {
                return pSDELogicLinkBase.isUpdateManDirty();
            }
            case 29: {
                return pSDELogicLinkBase.isUserCatDirty();
            }
            case 30: {
                return pSDELogicLinkBase.isUserTagDirty();
            }
            case 31: {
                return pSDELogicLinkBase.isUserTag2Dirty();
            }
            case 32: {
                return pSDELogicLinkBase.isUserTag3Dirty();
            }
            case 33: {
                return pSDELogicLinkBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDELogicLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDELogicLinkBase pSDELogicLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDELogicLinkBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getCondModel()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDebugMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"debugmode", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDebugMode()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDefaultLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultlink", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDefaultLink()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDstEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstendpoint", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDstEndPoint()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDstPSDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicnodeid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDstPSDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDstPSDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdelogicnodename", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDstPSDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDstPSDLParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDstPSDLParamId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDstPSDLParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdlparamname", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDstPSDLParamName()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getLinkCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkcond", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getLinkCond()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getLinkCond2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkcond2", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getLinkCond2()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getLinkInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getLinkInfo()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDELogicId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogiclinkid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDELogicLinkId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogiclinkname", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDELogicLinkName()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelogicname", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDELogicName()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getShapeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shapeparams", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getShapeParams()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getSrcEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcendpoint", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getSrcEndPoint()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getSrcPSDELogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdelogicnodeid", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getSrcPSDELogicNodeId()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getSrcPSDELogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpsdelogicnodename", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getSrcPSDELogicNodeName()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDELogicLinkBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDELogicLinkBase.getJSONValue((Object)pSDELogicLinkBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDELogicLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDELogicLinkBase pSDELogicLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDELogicLinkBase.getCondModel() != null) {
            object = pSDELogicLinkBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getCreateDate() != null) {
            object = pSDELogicLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getCreateMan() != null) {
            object = pSDELogicLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDebugMode() != null) {
            object = pSDELogicLinkBase.getDebugMode();
            xmlNode.setAttribute(FIELD_DEBUGMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getDefaultLink() != null) {
            object = pSDELogicLinkBase.getDefaultLink();
            xmlNode.setAttribute(FIELD_DEFAULTLINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getDstEndPoint() != null) {
            object = pSDELogicLinkBase.getDstEndPoint();
            xmlNode.setAttribute(FIELD_DSTENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDstPSDELogicNodeId() != null) {
            object = pSDELogicLinkBase.getDstPSDELogicNodeId();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDstPSDELogicNodeName() != null) {
            object = pSDELogicLinkBase.getDstPSDELogicNodeName();
            xmlNode.setAttribute(FIELD_DSTPSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDstPSDLParamId() != null) {
            object = pSDELogicLinkBase.getDstPSDLParamId();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDstPSDLParamName() != null) {
            object = pSDELogicLinkBase.getDstPSDLParamName();
            xmlNode.setAttribute(FIELD_DSTPSDLPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getDynaModelFlag() != null) {
            object = pSDELogicLinkBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getLinkCond() != null) {
            object = pSDELogicLinkBase.getLinkCond();
            xmlNode.setAttribute(FIELD_LINKCOND, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getLinkCond2() != null) {
            object = pSDELogicLinkBase.getLinkCond2();
            xmlNode.setAttribute(FIELD_LINKCOND2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getLinkInfo() != null) {
            object = pSDELogicLinkBase.getLinkInfo();
            xmlNode.setAttribute(FIELD_LINKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getMemo() != null) {
            object = pSDELogicLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getOrderValue() != null) {
            object = pSDELogicLinkBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getPSDEId() != null) {
            object = pSDELogicLinkBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicId() != null) {
            object = pSDELogicLinkBase.getPSDELogicId();
            xmlNode.setAttribute(FIELD_PSDELOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicLinkId() != null) {
            object = pSDELogicLinkBase.getPSDELogicLinkId();
            xmlNode.setAttribute(FIELD_PSDELOGICLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicLinkName() != null) {
            object = pSDELogicLinkBase.getPSDELogicLinkName();
            xmlNode.setAttribute(FIELD_PSDELOGICLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSDELogicName() != null) {
            object = pSDELogicLinkBase.getPSDELogicName();
            xmlNode.setAttribute(FIELD_PSDELOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSDynaInstId() != null) {
            object = pSDELogicLinkBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getPSSystemId() != null) {
            object = pSDELogicLinkBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getShapeParams() != null) {
            object = pSDELogicLinkBase.getShapeParams();
            xmlNode.setAttribute(FIELD_SHAPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getSrcEndPoint() != null) {
            object = pSDELogicLinkBase.getSrcEndPoint();
            xmlNode.setAttribute(FIELD_SRCENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getSrcPSDELogicNodeId() != null) {
            object = pSDELogicLinkBase.getSrcPSDELogicNodeId();
            xmlNode.setAttribute(FIELD_SRCPSDELOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getSrcPSDELogicNodeName() != null) {
            object = pSDELogicLinkBase.getSrcPSDELogicNodeName();
            xmlNode.setAttribute(FIELD_SRCPSDELOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUpdateDate() != null) {
            object = pSDELogicLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDELogicLinkBase.getUpdateMan() != null) {
            object = pSDELogicLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUserCat() != null) {
            object = pSDELogicLinkBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUserTag() != null) {
            object = pSDELogicLinkBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUserTag2() != null) {
            object = pSDELogicLinkBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUserTag3() != null) {
            object = pSDELogicLinkBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDELogicLinkBase.getUserTag4() != null) {
            object = pSDELogicLinkBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDELogicLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDELogicLinkBase pSDELogicLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDELogicLinkBase.isCondModelDirty() && (bl || pSDELogicLinkBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSDELogicLinkBase.getCondModel());
        }
        if (pSDELogicLinkBase.isCreateDateDirty() && (bl || pSDELogicLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDELogicLinkBase.getCreateDate());
        }
        if (pSDELogicLinkBase.isCreateManDirty() && (bl || pSDELogicLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDELogicLinkBase.getCreateMan());
        }
        if (pSDELogicLinkBase.isDebugModeDirty() && (bl || pSDELogicLinkBase.getDebugMode() != null)) {
            iDataObject.set(FIELD_DEBUGMODE, (Object)pSDELogicLinkBase.getDebugMode());
        }
        if (pSDELogicLinkBase.isDefaultLinkDirty() && (bl || pSDELogicLinkBase.getDefaultLink() != null)) {
            iDataObject.set(FIELD_DEFAULTLINK, (Object)pSDELogicLinkBase.getDefaultLink());
        }
        if (pSDELogicLinkBase.isDstEndPointDirty() && (bl || pSDELogicLinkBase.getDstEndPoint() != null)) {
            iDataObject.set(FIELD_DSTENDPOINT, (Object)pSDELogicLinkBase.getDstEndPoint());
        }
        if (pSDELogicLinkBase.isDstPSDELogicNodeIdDirty() && (bl || pSDELogicLinkBase.getDstPSDELogicNodeId() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICNODEID, (Object)pSDELogicLinkBase.getDstPSDELogicNodeId());
        }
        if (pSDELogicLinkBase.isDstPSDELogicNodeNameDirty() && (bl || pSDELogicLinkBase.getDstPSDELogicNodeName() != null)) {
            iDataObject.set(FIELD_DSTPSDELOGICNODENAME, (Object)pSDELogicLinkBase.getDstPSDELogicNodeName());
        }
        if (pSDELogicLinkBase.isDstPSDLParamIdDirty() && (bl || pSDELogicLinkBase.getDstPSDLParamId() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMID, (Object)pSDELogicLinkBase.getDstPSDLParamId());
        }
        if (pSDELogicLinkBase.isDstPSDLParamNameDirty() && (bl || pSDELogicLinkBase.getDstPSDLParamName() != null)) {
            iDataObject.set(FIELD_DSTPSDLPARAMNAME, (Object)pSDELogicLinkBase.getDstPSDLParamName());
        }
        if (pSDELogicLinkBase.isDynaModelFlagDirty() && (bl || pSDELogicLinkBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDELogicLinkBase.getDynaModelFlag());
        }
        if (pSDELogicLinkBase.isLinkCondDirty() && (bl || pSDELogicLinkBase.getLinkCond() != null)) {
            iDataObject.set(FIELD_LINKCOND, (Object)pSDELogicLinkBase.getLinkCond());
        }
        if (pSDELogicLinkBase.isLinkCond2Dirty() && (bl || pSDELogicLinkBase.getLinkCond2() != null)) {
            iDataObject.set(FIELD_LINKCOND2, (Object)pSDELogicLinkBase.getLinkCond2());
        }
        if (pSDELogicLinkBase.isLinkInfoDirty() && (bl || pSDELogicLinkBase.getLinkInfo() != null)) {
            iDataObject.set(FIELD_LINKINFO, (Object)pSDELogicLinkBase.getLinkInfo());
        }
        if (pSDELogicLinkBase.isMemoDirty() && (bl || pSDELogicLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDELogicLinkBase.getMemo());
        }
        if (pSDELogicLinkBase.isOrderValueDirty() && (bl || pSDELogicLinkBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDELogicLinkBase.getOrderValue());
        }
        if (pSDELogicLinkBase.isPSDEIdDirty() && (bl || pSDELogicLinkBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDELogicLinkBase.getPSDEId());
        }
        if (pSDELogicLinkBase.isPSDELogicIdDirty() && (bl || pSDELogicLinkBase.getPSDELogicId() != null)) {
            iDataObject.set(FIELD_PSDELOGICID, (Object)pSDELogicLinkBase.getPSDELogicId());
        }
        if (pSDELogicLinkBase.isPSDELogicLinkIdDirty() && (bl || pSDELogicLinkBase.getPSDELogicLinkId() != null)) {
            iDataObject.set(FIELD_PSDELOGICLINKID, (Object)pSDELogicLinkBase.getPSDELogicLinkId());
        }
        if (pSDELogicLinkBase.isPSDELogicLinkNameDirty() && (bl || pSDELogicLinkBase.getPSDELogicLinkName() != null)) {
            iDataObject.set(FIELD_PSDELOGICLINKNAME, (Object)pSDELogicLinkBase.getPSDELogicLinkName());
        }
        if (pSDELogicLinkBase.isPSDELogicNameDirty() && (bl || pSDELogicLinkBase.getPSDELogicName() != null)) {
            iDataObject.set(FIELD_PSDELOGICNAME, (Object)pSDELogicLinkBase.getPSDELogicName());
        }
        if (pSDELogicLinkBase.isPSDynaInstIdDirty() && (bl || pSDELogicLinkBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDELogicLinkBase.getPSDynaInstId());
        }
        if (pSDELogicLinkBase.isPSSystemIdDirty() && (bl || pSDELogicLinkBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDELogicLinkBase.getPSSystemId());
        }
        if (pSDELogicLinkBase.isShapeParamsDirty() && (bl || pSDELogicLinkBase.getShapeParams() != null)) {
            iDataObject.set(FIELD_SHAPEPARAMS, (Object)pSDELogicLinkBase.getShapeParams());
        }
        if (pSDELogicLinkBase.isSrcEndPointDirty() && (bl || pSDELogicLinkBase.getSrcEndPoint() != null)) {
            iDataObject.set(FIELD_SRCENDPOINT, (Object)pSDELogicLinkBase.getSrcEndPoint());
        }
        if (pSDELogicLinkBase.isSrcPSDELogicNodeIdDirty() && (bl || pSDELogicLinkBase.getSrcPSDELogicNodeId() != null)) {
            iDataObject.set(FIELD_SRCPSDELOGICNODEID, (Object)pSDELogicLinkBase.getSrcPSDELogicNodeId());
        }
        if (pSDELogicLinkBase.isSrcPSDELogicNodeNameDirty() && (bl || pSDELogicLinkBase.getSrcPSDELogicNodeName() != null)) {
            iDataObject.set(FIELD_SRCPSDELOGICNODENAME, (Object)pSDELogicLinkBase.getSrcPSDELogicNodeName());
        }
        if (pSDELogicLinkBase.isUpdateDateDirty() && (bl || pSDELogicLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDELogicLinkBase.getUpdateDate());
        }
        if (pSDELogicLinkBase.isUpdateManDirty() && (bl || pSDELogicLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDELogicLinkBase.getUpdateMan());
        }
        if (pSDELogicLinkBase.isUserCatDirty() && (bl || pSDELogicLinkBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDELogicLinkBase.getUserCat());
        }
        if (pSDELogicLinkBase.isUserTagDirty() && (bl || pSDELogicLinkBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDELogicLinkBase.getUserTag());
        }
        if (pSDELogicLinkBase.isUserTag2Dirty() && (bl || pSDELogicLinkBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDELogicLinkBase.getUserTag2());
        }
        if (pSDELogicLinkBase.isUserTag3Dirty() && (bl || pSDELogicLinkBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDELogicLinkBase.getUserTag3());
        }
        if (pSDELogicLinkBase.isUserTag4Dirty() && (bl || pSDELogicLinkBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDELogicLinkBase.getUserTag4());
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
        return PSDELogicLinkBase.remove(this, n);
    }

    private static boolean remove(PSDELogicLinkBase pSDELogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDELogicLinkBase.resetCondModel();
                return true;
            }
            case 1: {
                pSDELogicLinkBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSDELogicLinkBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSDELogicLinkBase.resetDebugMode();
                return true;
            }
            case 4: {
                pSDELogicLinkBase.resetDefaultLink();
                return true;
            }
            case 5: {
                pSDELogicLinkBase.resetDstEndPoint();
                return true;
            }
            case 6: {
                pSDELogicLinkBase.resetDstPSDELogicNodeId();
                return true;
            }
            case 7: {
                pSDELogicLinkBase.resetDstPSDELogicNodeName();
                return true;
            }
            case 8: {
                pSDELogicLinkBase.resetDstPSDLParamId();
                return true;
            }
            case 9: {
                pSDELogicLinkBase.resetDstPSDLParamName();
                return true;
            }
            case 10: {
                pSDELogicLinkBase.resetDynaModelFlag();
                return true;
            }
            case 11: {
                pSDELogicLinkBase.resetLinkCond();
                return true;
            }
            case 12: {
                pSDELogicLinkBase.resetLinkCond2();
                return true;
            }
            case 13: {
                pSDELogicLinkBase.resetLinkInfo();
                return true;
            }
            case 14: {
                pSDELogicLinkBase.resetMemo();
                return true;
            }
            case 15: {
                pSDELogicLinkBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSDELogicLinkBase.resetPSDEId();
                return true;
            }
            case 17: {
                pSDELogicLinkBase.resetPSDELogicId();
                return true;
            }
            case 18: {
                pSDELogicLinkBase.resetPSDELogicLinkId();
                return true;
            }
            case 19: {
                pSDELogicLinkBase.resetPSDELogicLinkName();
                return true;
            }
            case 20: {
                pSDELogicLinkBase.resetPSDELogicName();
                return true;
            }
            case 21: {
                pSDELogicLinkBase.resetPSDynaInstId();
                return true;
            }
            case 22: {
                pSDELogicLinkBase.resetPSSystemId();
                return true;
            }
            case 23: {
                pSDELogicLinkBase.resetShapeParams();
                return true;
            }
            case 24: {
                pSDELogicLinkBase.resetSrcEndPoint();
                return true;
            }
            case 25: {
                pSDELogicLinkBase.resetSrcPSDELogicNodeId();
                return true;
            }
            case 26: {
                pSDELogicLinkBase.resetSrcPSDELogicNodeName();
                return true;
            }
            case 27: {
                pSDELogicLinkBase.resetUpdateDate();
                return true;
            }
            case 28: {
                pSDELogicLinkBase.resetUpdateMan();
                return true;
            }
            case 29: {
                pSDELogicLinkBase.resetUserCat();
                return true;
            }
            case 30: {
                pSDELogicLinkBase.resetUserTag();
                return true;
            }
            case 31: {
                pSDELogicLinkBase.resetUserTag2();
                return true;
            }
            case 32: {
                pSDELogicLinkBase.resetUserTag3();
                return true;
            }
            case 33: {
                pSDELogicLinkBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicNode getDstPSDELogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDELogicNode();
        }
        if (this.getDstPSDELogicNodeId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELogicNodeLock;
        synchronized (n) {
            if (this.dstpsdelogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDELogicNodeId(), (Object)this.dstpsdelogicnode.getPSDELogicNodeId()) != 0L) {
                this.dstpsdelogicnode = null;
            }
            if (this.dstpsdelogicnode == null) {
                PSDELogicNode pSDELogicNode = new PSDELogicNode();
                pSDELogicNode.setPSDELogicNodeId(this.getDstPSDELogicNodeId());
                PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicNodeService.autoGet((IEntity)pSDELogicNode);
                this.dstpsdelogicnode = pSDELogicNode;
            }
            return this.dstpsdelogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDELogicNode getSrcPSDELogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSDELogicNode();
        }
        if (this.getSrcPSDELogicNodeId() == null) {
            return null;
        }
        Integer n = this.objSrcPSDELogicNodeLock;
        synchronized (n) {
            if (this.srcpsdelogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSDELogicNodeId(), (Object)this.srcpsdelogicnode.getPSDELogicNodeId()) != 0L) {
                this.srcpsdelogicnode = null;
            }
            if (this.srcpsdelogicnode == null) {
                PSDELogicNode pSDELogicNode = new PSDELogicNode();
                pSDELogicNode.setPSDELogicNodeId(this.getSrcPSDELogicNodeId());
                PSDELogicNodeService pSDELogicNodeService = (PSDELogicNodeService)ServiceGlobal.getService(PSDELogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicNodeService.autoGet((IEntity)pSDELogicNode);
                this.srcpsdelogicnode = pSDELogicNode;
            }
            return this.srcpsdelogicnode;
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
    public PSDELogic getPSDELogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELogic();
        }
        if (this.getPSDELogicId() == null) {
            return null;
        }
        Integer n = this.objPSDELogicLock;
        synchronized (n) {
            if (this.psdelogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSDELogicId(), (Object)this.psdelogic.getPSDELogicId()) != 0L) {
                this.psdelogic = null;
            }
            if (this.psdelogic == null) {
                PSDELogic pSDELogic = new PSDELogic();
                pSDELogic.setPSDELogicId(this.getPSDELogicId());
                PSDELogicService pSDELogicService = (PSDELogicService)ServiceGlobal.getService(PSDELogicService.class, (SessionFactory)this.getSessionFactory());
                pSDELogicService.autoGet((IEntity)pSDELogic);
                this.psdelogic = pSDELogic;
            }
            return this.psdelogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDELLCond> getPSDELLConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDELLConds();
        }
        if (this.getPSDELogicLinkId() == null) {
            return null;
        }
        PSDELogicLinkService pSDELogicLinkService = (PSDELogicLinkService)ServiceGlobal.getService(PSDELogicLinkService.class, (SessionFactory)this.getSessionFactory());
        PSDELLCondService pSDELLCondService = (PSDELLCondService)ServiceGlobal.getService(PSDELLCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDELLCondsLock;
        synchronized (n) {
            if (this.psdellconds == null) {
                this.psdellconds = pSDELogicLinkService.isTempData((IEntity)this) ? pSDELLCondService.selectTempByPSDELogicLink(this) : pSDELLCondService.selectByPSDELogicLink(this);
            }
            return this.psdellconds;
        }
    }

    private PSDELogicLinkBase getProxyEntity() {
        return this.proxyPSDELogicLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDELogicLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSDELogicLinkBase) {
            this.proxyPSDELogicLinkBase = (PSDELogicLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDELogicLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDMODEL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_DEBUGMODE, 3);
        fieldIndexMap.put(FIELD_DEFAULTLINK, 4);
        fieldIndexMap.put(FIELD_DSTENDPOINT, 5);
        fieldIndexMap.put(FIELD_DSTPSDELOGICNODEID, 6);
        fieldIndexMap.put(FIELD_DSTPSDELOGICNODENAME, 7);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMID, 8);
        fieldIndexMap.put(FIELD_DSTPSDLPARAMNAME, 9);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 10);
        fieldIndexMap.put(FIELD_LINKCOND, 11);
        fieldIndexMap.put(FIELD_LINKCOND2, 12);
        fieldIndexMap.put(FIELD_LINKINFO, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PSDEID, 16);
        fieldIndexMap.put(FIELD_PSDELOGICID, 17);
        fieldIndexMap.put(FIELD_PSDELOGICLINKID, 18);
        fieldIndexMap.put(FIELD_PSDELOGICLINKNAME, 19);
        fieldIndexMap.put(FIELD_PSDELOGICNAME, 20);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 21);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 22);
        fieldIndexMap.put(FIELD_SHAPEPARAMS, 23);
        fieldIndexMap.put(FIELD_SRCENDPOINT, 24);
        fieldIndexMap.put(FIELD_SRCPSDELOGICNODEID, 25);
        fieldIndexMap.put(FIELD_SRCPSDELOGICNODENAME, 26);
        fieldIndexMap.put(FIELD_UPDATEDATE, 27);
        fieldIndexMap.put(FIELD_UPDATEMAN, 28);
        fieldIndexMap.put(FIELD_USERCAT, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
        fieldIndexMap.put(FIELD_USERTAG3, 32);
        fieldIndexMap.put(FIELD_USERTAG4, 33);
    }
}

