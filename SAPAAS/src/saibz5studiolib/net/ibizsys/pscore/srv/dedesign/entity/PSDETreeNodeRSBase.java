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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeNode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeNodeRSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeNodeRSBase.class);
    public static final String FIELD_CHILDFILTER = "CHILDFILTER";
    public static final String FIELD_CHILDFILTERDESC = "CHILDFILTERDESC";
    public static final String FIELD_CMCREATE = "CMCREATE";
    public static final String FIELD_CPSDETREENODEID = "CPSDETREENODEID";
    public static final String FIELD_CPSDETREENODENAME = "CPSDETREENODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSDETREENODEID = "PPSDETREENODEID";
    public static final String FIELD_PPSDETREENODENAME = "PPSDETREENODENAME";
    public static final String FIELD_PROCESSPARAM = "PROCESSPARAM";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_PSDETREENODERSID = "PSDETREENODERSID";
    public static final String FIELD_PSDETREENODERSNAME = "PSDETREENODERSNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PVALUELEVEL = "PVALUELEVEL";
    public static final String FIELD_SEARCHMODE = "SEARCHMODE";
    public static final String FIELD_TYPEFILTER = "TYPEFILTER";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CHILDFILTER = 0;
    private static final int INDEX_CHILDFILTERDESC = 1;
    private static final int INDEX_CMCREATE = 2;
    private static final int INDEX_CPSDETREENODEID = 3;
    private static final int INDEX_CPSDETREENODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMMODE = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PPSDETREENODEID = 11;
    private static final int INDEX_PPSDETREENODENAME = 12;
    private static final int INDEX_PROCESSPARAM = 13;
    private static final int INDEX_PSDEACTIONID = 14;
    private static final int INDEX_PSDEACTIONNAME = 15;
    private static final int INDEX_PSDERID = 16;
    private static final int INDEX_PSDERNAME = 17;
    private static final int INDEX_PSDETREENODERSID = 18;
    private static final int INDEX_PSDETREENODERSNAME = 19;
    private static final int INDEX_PSDETREEVIEWID = 20;
    private static final int INDEX_PSDETREEVIEWNAME = 21;
    private static final int INDEX_PVALUELEVEL = 22;
    private static final int INDEX_SEARCHMODE = 23;
    private static final int INDEX_TYPEFILTER = 24;
    private static final int INDEX_UPDATEDATE = 25;
    private static final int INDEX_UPDATEMAN = 26;
    private static final int INDEX_USERCAT = 27;
    private static final int INDEX_USERTAG = 28;
    private static final int INDEX_USERTAG2 = 29;
    private static final int INDEX_USERTAG3 = 30;
    private static final int INDEX_USERTAG4 = 31;
    private static final int INDEX_VALIDFLAG = 32;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeNodeRSBase proxyPSDETreeNodeRSBase = null;
    private boolean childfilterDirtyFlag = false;
    private boolean childfilterdescDirtyFlag = false;
    private boolean cmcreateDirtyFlag = false;
    private boolean cpsdetreenodeidDirtyFlag = false;
    private boolean cpsdetreenodenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppsdetreenodeidDirtyFlag = false;
    private boolean ppsdetreenodenameDirtyFlag = false;
    private boolean processparamDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean psdetreenodersidDirtyFlag = false;
    private boolean psdetreenodersnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean pvaluelevelDirtyFlag = false;
    private boolean searchmodeDirtyFlag = false;
    private boolean typefilterDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="childfilter")
    private String childfilter;
    @Column(name="childfilterdesc")
    private String childfilterdesc;
    @Column(name="cmcreate")
    private Integer cmcreate;
    @Column(name="cpsdetreenodeid")
    private String cpsdetreenodeid;
    @Column(name="cpsdetreenodename")
    private String cpsdetreenodename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppsdetreenodeid")
    private String ppsdetreenodeid;
    @Column(name="ppsdetreenodename")
    private String ppsdetreenodename;
    @Column(name="processparam")
    private String processparam;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
    @Column(name="psdetreenodersid")
    private String psdetreenodersid;
    @Column(name="psdetreenodersname")
    private String psdetreenodersname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="pvaluelevel")
    private Integer pvaluelevel;
    @Column(name="searchmode")
    private Integer searchmode;
    @Column(name="typefilter")
    private String typefilter;
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
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;
    private Integer objCPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode cpsdetreenode = null;
    private Integer objPPSDETreeNodeLock = new Integer(1);
    private PSDETreeNode ppsdetreenode = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;

    public void setChildFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childfilter = string;
        this.childfilterDirtyFlag = true;
    }

    public String getChildFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildFilter();
        }
        return this.childfilter;
    }

    public boolean isChildFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildFilterDirty();
        }
        return this.childfilterDirtyFlag;
    }

    public void resetChildFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildFilter();
            return;
        }
        this.childfilterDirtyFlag = false;
        this.childfilter = null;
    }

    public void setChildFilterDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setChildFilterDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.childfilterdesc = string;
        this.childfilterdescDirtyFlag = true;
    }

    public String getChildFilterDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getChildFilterDesc();
        }
        return this.childfilterdesc;
    }

    public boolean isChildFilterDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isChildFilterDescDirty();
        }
        return this.childfilterdescDirtyFlag;
    }

    public void resetChildFilterDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetChildFilterDesc();
            return;
        }
        this.childfilterdescDirtyFlag = false;
        this.childfilterdesc = null;
    }

    public void setCMCreate(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCMCreate(n);
            return;
        }
        this.cmcreate = n;
        this.cmcreateDirtyFlag = true;
    }

    public Integer getCMCreate() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCMCreate();
        }
        return this.cmcreate;
    }

    public boolean isCMCreateDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCMCreateDirty();
        }
        return this.cmcreateDirtyFlag;
    }

    public void resetCMCreate() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCMCreate();
            return;
        }
        this.cmcreateDirtyFlag = false;
        this.cmcreate = null;
    }

    public void setCPSDETreeNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSDETreeNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsdetreenodeid = string;
        this.cpsdetreenodeidDirtyFlag = true;
    }

    public String getCPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDETreeNodeId();
        }
        return this.cpsdetreenodeid;
    }

    public boolean isCPSDETreeNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSDETreeNodeIdDirty();
        }
        return this.cpsdetreenodeidDirtyFlag;
    }

    public void resetCPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSDETreeNodeId();
            return;
        }
        this.cpsdetreenodeidDirtyFlag = false;
        this.cpsdetreenodeid = null;
    }

    public void setCPSDETreeNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCPSDETreeNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cpsdetreenodename = string;
        this.cpsdetreenodenameDirtyFlag = true;
    }

    public String getCPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDETreeNodeName();
        }
        return this.cpsdetreenodename;
    }

    public boolean isCPSDETreeNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCPSDETreeNodeNameDirty();
        }
        return this.cpsdetreenodenameDirtyFlag;
    }

    public void resetCPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCPSDETreeNodeName();
            return;
        }
        this.cpsdetreenodenameDirtyFlag = false;
        this.cpsdetreenodename = null;
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

    public void setCustomMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCustomMode(n);
            return;
        }
        this.custommode = n;
        this.custommodeDirtyFlag = true;
    }

    public Integer getCustomMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCustomMode();
        }
        return this.custommode;
    }

    public boolean isCustomModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCustomModeDirty();
        }
        return this.custommodeDirtyFlag;
    }

    public void resetCustomMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCustomMode();
            return;
        }
        this.custommodeDirtyFlag = false;
        this.custommode = null;
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

    public void setPPSDETreeNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDETreeNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdetreenodeid = string;
        this.ppsdetreenodeidDirtyFlag = true;
    }

    public String getPPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETreeNodeId();
        }
        return this.ppsdetreenodeid;
    }

    public boolean isPPSDETreeNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDETreeNodeIdDirty();
        }
        return this.ppsdetreenodeidDirtyFlag;
    }

    public void resetPPSDETreeNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDETreeNodeId();
            return;
        }
        this.ppsdetreenodeidDirtyFlag = false;
        this.ppsdetreenodeid = null;
    }

    public void setPPSDETreeNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSDETreeNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsdetreenodename = string;
        this.ppsdetreenodenameDirtyFlag = true;
    }

    public String getPPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETreeNodeName();
        }
        return this.ppsdetreenodename;
    }

    public boolean isPPSDETreeNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSDETreeNodeNameDirty();
        }
        return this.ppsdetreenodenameDirtyFlag;
    }

    public void resetPPSDETreeNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSDETreeNodeName();
            return;
        }
        this.ppsdetreenodenameDirtyFlag = false;
        this.ppsdetreenodename = null;
    }

    public void setProcessParam(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setProcessParam(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.processparam = string;
        this.processparamDirtyFlag = true;
    }

    public String getProcessParam() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getProcessParam();
        }
        return this.processparam;
    }

    public boolean isProcessParamDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isProcessParamDirty();
        }
        return this.processparamDirtyFlag;
    }

    public void resetProcessParam() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetProcessParam();
            return;
        }
        this.processparamDirtyFlag = false;
        this.processparam = null;
    }

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
    }

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
    }

    public void setPSDETreeNodeRSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeRSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodersid = string;
        this.psdetreenodersidDirtyFlag = true;
    }

    public String getPSDETreeNodeRSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeRSId();
        }
        return this.psdetreenodersid;
    }

    public boolean isPSDETreeNodeRSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeRSIdDirty();
        }
        return this.psdetreenodersidDirtyFlag;
    }

    public void resetPSDETreeNodeRSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeRSId();
            return;
        }
        this.psdetreenodersidDirtyFlag = false;
        this.psdetreenodersid = null;
    }

    public void setPSDETreeNodeRSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeNodeRSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreenodersname = string;
        this.psdetreenodersnameDirtyFlag = true;
    }

    public String getPSDETreeNodeRSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeNodeRSName();
        }
        return this.psdetreenodersname;
    }

    public boolean isPSDETreeNodeRSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeNodeRSNameDirty();
        }
        return this.psdetreenodersnameDirtyFlag;
    }

    public void resetPSDETreeNodeRSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeNodeRSName();
            return;
        }
        this.psdetreenodersnameDirtyFlag = false;
        this.psdetreenodersname = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
    }

    public void setPValueLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPValueLevel(n);
            return;
        }
        this.pvaluelevel = n;
        this.pvaluelevelDirtyFlag = true;
    }

    public Integer getPValueLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPValueLevel();
        }
        return this.pvaluelevel;
    }

    public boolean isPValueLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPValueLevelDirty();
        }
        return this.pvaluelevelDirtyFlag;
    }

    public void resetPValueLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPValueLevel();
            return;
        }
        this.pvaluelevelDirtyFlag = false;
        this.pvaluelevel = null;
    }

    public void setSearchMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSearchMode(n);
            return;
        }
        this.searchmode = n;
        this.searchmodeDirtyFlag = true;
    }

    public Integer getSearchMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSearchMode();
        }
        return this.searchmode;
    }

    public boolean isSearchModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSearchModeDirty();
        }
        return this.searchmodeDirtyFlag;
    }

    public void resetSearchMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSearchMode();
            return;
        }
        this.searchmodeDirtyFlag = false;
        this.searchmode = null;
    }

    public void setTypeFilter(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeFilter(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typefilter = string;
        this.typefilterDirtyFlag = true;
    }

    public String getTypeFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeFilter();
        }
        return this.typefilter;
    }

    public boolean isTypeFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeFilterDirty();
        }
        return this.typefilterDirtyFlag;
    }

    public void resetTypeFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeFilter();
            return;
        }
        this.typefilterDirtyFlag = false;
        this.typefilter = null;
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
        PSDETreeNodeRSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeNodeRSBase pSDETreeNodeRSBase) {
        pSDETreeNodeRSBase.resetChildFilter();
        pSDETreeNodeRSBase.resetChildFilterDesc();
        pSDETreeNodeRSBase.resetCMCreate();
        pSDETreeNodeRSBase.resetCPSDETreeNodeId();
        pSDETreeNodeRSBase.resetCPSDETreeNodeName();
        pSDETreeNodeRSBase.resetCreateDate();
        pSDETreeNodeRSBase.resetCreateMan();
        pSDETreeNodeRSBase.resetCustomCode();
        pSDETreeNodeRSBase.resetCustomMode();
        pSDETreeNodeRSBase.resetMemo();
        pSDETreeNodeRSBase.resetOrderValue();
        pSDETreeNodeRSBase.resetPPSDETreeNodeId();
        pSDETreeNodeRSBase.resetPPSDETreeNodeName();
        pSDETreeNodeRSBase.resetProcessParam();
        pSDETreeNodeRSBase.resetPSDEActionId();
        pSDETreeNodeRSBase.resetPSDEActionName();
        pSDETreeNodeRSBase.resetPSDERId();
        pSDETreeNodeRSBase.resetPSDERName();
        pSDETreeNodeRSBase.resetPSDETreeNodeRSId();
        pSDETreeNodeRSBase.resetPSDETreeNodeRSName();
        pSDETreeNodeRSBase.resetPSDETreeViewId();
        pSDETreeNodeRSBase.resetPSDETreeViewName();
        pSDETreeNodeRSBase.resetPValueLevel();
        pSDETreeNodeRSBase.resetSearchMode();
        pSDETreeNodeRSBase.resetTypeFilter();
        pSDETreeNodeRSBase.resetUpdateDate();
        pSDETreeNodeRSBase.resetUpdateMan();
        pSDETreeNodeRSBase.resetUserCat();
        pSDETreeNodeRSBase.resetUserTag();
        pSDETreeNodeRSBase.resetUserTag2();
        pSDETreeNodeRSBase.resetUserTag3();
        pSDETreeNodeRSBase.resetUserTag4();
        pSDETreeNodeRSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isChildFilterDirty()) {
            hashMap.put(FIELD_CHILDFILTER, this.getChildFilter());
        }
        if (!bl || this.isChildFilterDescDirty()) {
            hashMap.put(FIELD_CHILDFILTERDESC, this.getChildFilterDesc());
        }
        if (!bl || this.isCMCreateDirty()) {
            hashMap.put(FIELD_CMCREATE, this.getCMCreate());
        }
        if (!bl || this.isCPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_CPSDETREENODEID, this.getCPSDETreeNodeId());
        }
        if (!bl || this.isCPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_CPSDETREENODENAME, this.getCPSDETreeNodeName());
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
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSDETreeNodeIdDirty()) {
            hashMap.put(FIELD_PPSDETREENODEID, this.getPPSDETreeNodeId());
        }
        if (!bl || this.isPPSDETreeNodeNameDirty()) {
            hashMap.put(FIELD_PPSDETREENODENAME, this.getPPSDETreeNodeName());
        }
        if (!bl || this.isProcessParamDirty()) {
            hashMap.put(FIELD_PROCESSPARAM, this.getProcessParam());
        }
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
        }
        if (!bl || this.isPSDETreeNodeRSIdDirty()) {
            hashMap.put(FIELD_PSDETREENODERSID, this.getPSDETreeNodeRSId());
        }
        if (!bl || this.isPSDETreeNodeRSNameDirty()) {
            hashMap.put(FIELD_PSDETREENODERSNAME, this.getPSDETreeNodeRSName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
        }
        if (!bl || this.isPValueLevelDirty()) {
            hashMap.put(FIELD_PVALUELEVEL, this.getPValueLevel());
        }
        if (!bl || this.isSearchModeDirty()) {
            hashMap.put(FIELD_SEARCHMODE, this.getSearchMode());
        }
        if (!bl || this.isTypeFilterDirty()) {
            hashMap.put(FIELD_TYPEFILTER, this.getTypeFilter());
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
        return PSDETreeNodeRSBase.get(this, n);
    }

    private static Object get(PSDETreeNodeRSBase pSDETreeNodeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRSBase.getChildFilter();
            }
            case 1: {
                return pSDETreeNodeRSBase.getChildFilterDesc();
            }
            case 2: {
                return pSDETreeNodeRSBase.getCMCreate();
            }
            case 3: {
                return pSDETreeNodeRSBase.getCPSDETreeNodeId();
            }
            case 4: {
                return pSDETreeNodeRSBase.getCPSDETreeNodeName();
            }
            case 5: {
                return pSDETreeNodeRSBase.getCreateDate();
            }
            case 6: {
                return pSDETreeNodeRSBase.getCreateMan();
            }
            case 7: {
                return pSDETreeNodeRSBase.getCustomCode();
            }
            case 8: {
                return pSDETreeNodeRSBase.getCustomMode();
            }
            case 9: {
                return pSDETreeNodeRSBase.getMemo();
            }
            case 10: {
                return pSDETreeNodeRSBase.getOrderValue();
            }
            case 11: {
                return pSDETreeNodeRSBase.getPPSDETreeNodeId();
            }
            case 12: {
                return pSDETreeNodeRSBase.getPPSDETreeNodeName();
            }
            case 13: {
                return pSDETreeNodeRSBase.getProcessParam();
            }
            case 14: {
                return pSDETreeNodeRSBase.getPSDEActionId();
            }
            case 15: {
                return pSDETreeNodeRSBase.getPSDEActionName();
            }
            case 16: {
                return pSDETreeNodeRSBase.getPSDERId();
            }
            case 17: {
                return pSDETreeNodeRSBase.getPSDERName();
            }
            case 18: {
                return pSDETreeNodeRSBase.getPSDETreeNodeRSId();
            }
            case 19: {
                return pSDETreeNodeRSBase.getPSDETreeNodeRSName();
            }
            case 20: {
                return pSDETreeNodeRSBase.getPSDETreeViewId();
            }
            case 21: {
                return pSDETreeNodeRSBase.getPSDETreeViewName();
            }
            case 22: {
                return pSDETreeNodeRSBase.getPValueLevel();
            }
            case 23: {
                return pSDETreeNodeRSBase.getSearchMode();
            }
            case 24: {
                return pSDETreeNodeRSBase.getTypeFilter();
            }
            case 25: {
                return pSDETreeNodeRSBase.getUpdateDate();
            }
            case 26: {
                return pSDETreeNodeRSBase.getUpdateMan();
            }
            case 27: {
                return pSDETreeNodeRSBase.getUserCat();
            }
            case 28: {
                return pSDETreeNodeRSBase.getUserTag();
            }
            case 29: {
                return pSDETreeNodeRSBase.getUserTag2();
            }
            case 30: {
                return pSDETreeNodeRSBase.getUserTag3();
            }
            case 31: {
                return pSDETreeNodeRSBase.getUserTag4();
            }
            case 32: {
                return pSDETreeNodeRSBase.getValidFlag();
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
        PSDETreeNodeRSBase.set(this, n, object);
    }

    private static void set(PSDETreeNodeRSBase pSDETreeNodeRSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeRSBase.setChildFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeNodeRSBase.setChildFilterDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeNodeRSBase.setCMCreate(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeNodeRSBase.setCPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeNodeRSBase.setCPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeNodeRSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeNodeRSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeNodeRSBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeNodeRSBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeNodeRSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeNodeRSBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeNodeRSBase.setPPSDETreeNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeNodeRSBase.setPPSDETreeNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeNodeRSBase.setProcessParam(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeNodeRSBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeNodeRSBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeNodeRSBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeNodeRSBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeNodeRSBase.setPSDETreeNodeRSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeNodeRSBase.setPSDETreeNodeRSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeNodeRSBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeNodeRSBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeNodeRSBase.setPValueLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeNodeRSBase.setSearchMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeNodeRSBase.setTypeFilter(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeNodeRSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeNodeRSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeNodeRSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeNodeRSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeNodeRSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeNodeRSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeNodeRSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeNodeRSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDETreeNodeRSBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeNodeRSBase pSDETreeNodeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRSBase.getChildFilter() == null;
            }
            case 1: {
                return pSDETreeNodeRSBase.getChildFilterDesc() == null;
            }
            case 2: {
                return pSDETreeNodeRSBase.getCMCreate() == null;
            }
            case 3: {
                return pSDETreeNodeRSBase.getCPSDETreeNodeId() == null;
            }
            case 4: {
                return pSDETreeNodeRSBase.getCPSDETreeNodeName() == null;
            }
            case 5: {
                return pSDETreeNodeRSBase.getCreateDate() == null;
            }
            case 6: {
                return pSDETreeNodeRSBase.getCreateMan() == null;
            }
            case 7: {
                return pSDETreeNodeRSBase.getCustomCode() == null;
            }
            case 8: {
                return pSDETreeNodeRSBase.getCustomMode() == null;
            }
            case 9: {
                return pSDETreeNodeRSBase.getMemo() == null;
            }
            case 10: {
                return pSDETreeNodeRSBase.getOrderValue() == null;
            }
            case 11: {
                return pSDETreeNodeRSBase.getPPSDETreeNodeId() == null;
            }
            case 12: {
                return pSDETreeNodeRSBase.getPPSDETreeNodeName() == null;
            }
            case 13: {
                return pSDETreeNodeRSBase.getProcessParam() == null;
            }
            case 14: {
                return pSDETreeNodeRSBase.getPSDEActionId() == null;
            }
            case 15: {
                return pSDETreeNodeRSBase.getPSDEActionName() == null;
            }
            case 16: {
                return pSDETreeNodeRSBase.getPSDERId() == null;
            }
            case 17: {
                return pSDETreeNodeRSBase.getPSDERName() == null;
            }
            case 18: {
                return pSDETreeNodeRSBase.getPSDETreeNodeRSId() == null;
            }
            case 19: {
                return pSDETreeNodeRSBase.getPSDETreeNodeRSName() == null;
            }
            case 20: {
                return pSDETreeNodeRSBase.getPSDETreeViewId() == null;
            }
            case 21: {
                return pSDETreeNodeRSBase.getPSDETreeViewName() == null;
            }
            case 22: {
                return pSDETreeNodeRSBase.getPValueLevel() == null;
            }
            case 23: {
                return pSDETreeNodeRSBase.getSearchMode() == null;
            }
            case 24: {
                return pSDETreeNodeRSBase.getTypeFilter() == null;
            }
            case 25: {
                return pSDETreeNodeRSBase.getUpdateDate() == null;
            }
            case 26: {
                return pSDETreeNodeRSBase.getUpdateMan() == null;
            }
            case 27: {
                return pSDETreeNodeRSBase.getUserCat() == null;
            }
            case 28: {
                return pSDETreeNodeRSBase.getUserTag() == null;
            }
            case 29: {
                return pSDETreeNodeRSBase.getUserTag2() == null;
            }
            case 30: {
                return pSDETreeNodeRSBase.getUserTag3() == null;
            }
            case 31: {
                return pSDETreeNodeRSBase.getUserTag4() == null;
            }
            case 32: {
                return pSDETreeNodeRSBase.getValidFlag() == null;
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
        return PSDETreeNodeRSBase.contains(this, n);
    }

    private static boolean contains(PSDETreeNodeRSBase pSDETreeNodeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeNodeRSBase.isChildFilterDirty();
            }
            case 1: {
                return pSDETreeNodeRSBase.isChildFilterDescDirty();
            }
            case 2: {
                return pSDETreeNodeRSBase.isCMCreateDirty();
            }
            case 3: {
                return pSDETreeNodeRSBase.isCPSDETreeNodeIdDirty();
            }
            case 4: {
                return pSDETreeNodeRSBase.isCPSDETreeNodeNameDirty();
            }
            case 5: {
                return pSDETreeNodeRSBase.isCreateDateDirty();
            }
            case 6: {
                return pSDETreeNodeRSBase.isCreateManDirty();
            }
            case 7: {
                return pSDETreeNodeRSBase.isCustomCodeDirty();
            }
            case 8: {
                return pSDETreeNodeRSBase.isCustomModeDirty();
            }
            case 9: {
                return pSDETreeNodeRSBase.isMemoDirty();
            }
            case 10: {
                return pSDETreeNodeRSBase.isOrderValueDirty();
            }
            case 11: {
                return pSDETreeNodeRSBase.isPPSDETreeNodeIdDirty();
            }
            case 12: {
                return pSDETreeNodeRSBase.isPPSDETreeNodeNameDirty();
            }
            case 13: {
                return pSDETreeNodeRSBase.isProcessParamDirty();
            }
            case 14: {
                return pSDETreeNodeRSBase.isPSDEActionIdDirty();
            }
            case 15: {
                return pSDETreeNodeRSBase.isPSDEActionNameDirty();
            }
            case 16: {
                return pSDETreeNodeRSBase.isPSDERIdDirty();
            }
            case 17: {
                return pSDETreeNodeRSBase.isPSDERNameDirty();
            }
            case 18: {
                return pSDETreeNodeRSBase.isPSDETreeNodeRSIdDirty();
            }
            case 19: {
                return pSDETreeNodeRSBase.isPSDETreeNodeRSNameDirty();
            }
            case 20: {
                return pSDETreeNodeRSBase.isPSDETreeViewIdDirty();
            }
            case 21: {
                return pSDETreeNodeRSBase.isPSDETreeViewNameDirty();
            }
            case 22: {
                return pSDETreeNodeRSBase.isPValueLevelDirty();
            }
            case 23: {
                return pSDETreeNodeRSBase.isSearchModeDirty();
            }
            case 24: {
                return pSDETreeNodeRSBase.isTypeFilterDirty();
            }
            case 25: {
                return pSDETreeNodeRSBase.isUpdateDateDirty();
            }
            case 26: {
                return pSDETreeNodeRSBase.isUpdateManDirty();
            }
            case 27: {
                return pSDETreeNodeRSBase.isUserCatDirty();
            }
            case 28: {
                return pSDETreeNodeRSBase.isUserTagDirty();
            }
            case 29: {
                return pSDETreeNodeRSBase.isUserTag2Dirty();
            }
            case 30: {
                return pSDETreeNodeRSBase.isUserTag3Dirty();
            }
            case 31: {
                return pSDETreeNodeRSBase.isUserTag4Dirty();
            }
            case 32: {
                return pSDETreeNodeRSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeNodeRSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeNodeRSBase pSDETreeNodeRSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeNodeRSBase.getChildFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childfilter", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getChildFilter()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getChildFilterDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"childfilterdesc", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getChildFilterDesc()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCMCreate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cmcreate", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCMCreate()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsdetreenodeid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cpsdetreenodename", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPPSDETreeNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdetreenodeid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPPSDETreeNodeId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPPSDETreeNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsdetreenodename", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPPSDETreeNodeName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getProcessParam() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"processparam", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getProcessParam()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodersid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDETreeNodeRSId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreenodersname", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDETreeNodeRSName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getPValueLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pvaluelevel", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getPValueLevel()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getSearchMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"searchmode", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getSearchMode()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getTypeFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefilter", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getTypeFilter()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDETreeNodeRSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDETreeNodeRSBase.getJSONValue((Object)pSDETreeNodeRSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeNodeRSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeNodeRSBase pSDETreeNodeRSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeNodeRSBase.getChildFilter() != null) {
            object = pSDETreeNodeRSBase.getChildFilter();
            xmlNode.setAttribute(FIELD_CHILDFILTER, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeNodeRSBase.getChildFilterDesc() != null) {
            object = pSDETreeNodeRSBase.getChildFilterDesc();
            xmlNode.setAttribute(FIELD_CHILDFILTERDESC, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getCMCreate() != null) {
            object = pSDETreeNodeRSBase.getCMCreate();
            xmlNode.setAttribute(FIELD_CMCREATE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getCPSDETreeNodeId() != null) {
            object = pSDETreeNodeRSBase.getCPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_CPSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getCPSDETreeNodeName() != null) {
            object = pSDETreeNodeRSBase.getCPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_CPSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getCreateDate() != null) {
            object = pSDETreeNodeRSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getCreateMan() != null) {
            object = pSDETreeNodeRSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getCustomCode() != null) {
            object = pSDETreeNodeRSBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getCustomMode() != null) {
            object = pSDETreeNodeRSBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getMemo() != null) {
            object = pSDETreeNodeRSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getOrderValue() != null) {
            object = pSDETreeNodeRSBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getPPSDETreeNodeId() != null) {
            object = pSDETreeNodeRSBase.getPPSDETreeNodeId();
            xmlNode.setAttribute(FIELD_PPSDETREENODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPPSDETreeNodeName() != null) {
            object = pSDETreeNodeRSBase.getPPSDETreeNodeName();
            xmlNode.setAttribute(FIELD_PPSDETREENODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getProcessParam() != null) {
            object = pSDETreeNodeRSBase.getProcessParam();
            xmlNode.setAttribute(FIELD_PROCESSPARAM, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDEActionId() != null) {
            object = pSDETreeNodeRSBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDEActionName() != null) {
            object = pSDETreeNodeRSBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDERId() != null) {
            object = pSDETreeNodeRSBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDERName() != null) {
            object = pSDETreeNodeRSBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSId() != null) {
            object = pSDETreeNodeRSBase.getPSDETreeNodeRSId();
            xmlNode.setAttribute(FIELD_PSDETREENODERSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSName() != null) {
            object = pSDETreeNodeRSBase.getPSDETreeNodeRSName();
            xmlNode.setAttribute(FIELD_PSDETREENODERSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeViewId() != null) {
            object = pSDETreeNodeRSBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPSDETreeViewName() != null) {
            object = pSDETreeNodeRSBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getPValueLevel() != null) {
            object = pSDETreeNodeRSBase.getPValueLevel();
            xmlNode.setAttribute(FIELD_PVALUELEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getSearchMode() != null) {
            object = pSDETreeNodeRSBase.getSearchMode();
            xmlNode.setAttribute(FIELD_SEARCHMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getTypeFilter() != null) {
            object = pSDETreeNodeRSBase.getTypeFilter();
            xmlNode.setAttribute(FIELD_TYPEFILTER, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUpdateDate() != null) {
            object = pSDETreeNodeRSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeNodeRSBase.getUpdateMan() != null) {
            object = pSDETreeNodeRSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUserCat() != null) {
            object = pSDETreeNodeRSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag() != null) {
            object = pSDETreeNodeRSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag2() != null) {
            object = pSDETreeNodeRSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag3() != null) {
            object = pSDETreeNodeRSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getUserTag4() != null) {
            object = pSDETreeNodeRSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeNodeRSBase.getValidFlag() != null) {
            object = pSDETreeNodeRSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeNodeRSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeNodeRSBase pSDETreeNodeRSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeNodeRSBase.isChildFilterDirty() && (bl || pSDETreeNodeRSBase.getChildFilter() != null)) {
            iDataObject.set(FIELD_CHILDFILTER, (Object)pSDETreeNodeRSBase.getChildFilter());
        }
        if (pSDETreeNodeRSBase.isChildFilterDescDirty() && (bl || pSDETreeNodeRSBase.getChildFilterDesc() != null)) {
            iDataObject.set(FIELD_CHILDFILTERDESC, (Object)pSDETreeNodeRSBase.getChildFilterDesc());
        }
        if (pSDETreeNodeRSBase.isCMCreateDirty() && (bl || pSDETreeNodeRSBase.getCMCreate() != null)) {
            iDataObject.set(FIELD_CMCREATE, (Object)pSDETreeNodeRSBase.getCMCreate());
        }
        if (pSDETreeNodeRSBase.isCPSDETreeNodeIdDirty() && (bl || pSDETreeNodeRSBase.getCPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_CPSDETREENODEID, (Object)pSDETreeNodeRSBase.getCPSDETreeNodeId());
        }
        if (pSDETreeNodeRSBase.isCPSDETreeNodeNameDirty() && (bl || pSDETreeNodeRSBase.getCPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_CPSDETREENODENAME, (Object)pSDETreeNodeRSBase.getCPSDETreeNodeName());
        }
        if (pSDETreeNodeRSBase.isCreateDateDirty() && (bl || pSDETreeNodeRSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeNodeRSBase.getCreateDate());
        }
        if (pSDETreeNodeRSBase.isCreateManDirty() && (bl || pSDETreeNodeRSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeNodeRSBase.getCreateMan());
        }
        if (pSDETreeNodeRSBase.isCustomCodeDirty() && (bl || pSDETreeNodeRSBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDETreeNodeRSBase.getCustomCode());
        }
        if (pSDETreeNodeRSBase.isCustomModeDirty() && (bl || pSDETreeNodeRSBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDETreeNodeRSBase.getCustomMode());
        }
        if (pSDETreeNodeRSBase.isMemoDirty() && (bl || pSDETreeNodeRSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeNodeRSBase.getMemo());
        }
        if (pSDETreeNodeRSBase.isOrderValueDirty() && (bl || pSDETreeNodeRSBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDETreeNodeRSBase.getOrderValue());
        }
        if (pSDETreeNodeRSBase.isPPSDETreeNodeIdDirty() && (bl || pSDETreeNodeRSBase.getPPSDETreeNodeId() != null)) {
            iDataObject.set(FIELD_PPSDETREENODEID, (Object)pSDETreeNodeRSBase.getPPSDETreeNodeId());
        }
        if (pSDETreeNodeRSBase.isPPSDETreeNodeNameDirty() && (bl || pSDETreeNodeRSBase.getPPSDETreeNodeName() != null)) {
            iDataObject.set(FIELD_PPSDETREENODENAME, (Object)pSDETreeNodeRSBase.getPPSDETreeNodeName());
        }
        if (pSDETreeNodeRSBase.isProcessParamDirty() && (bl || pSDETreeNodeRSBase.getProcessParam() != null)) {
            iDataObject.set(FIELD_PROCESSPARAM, (Object)pSDETreeNodeRSBase.getProcessParam());
        }
        if (pSDETreeNodeRSBase.isPSDEActionIdDirty() && (bl || pSDETreeNodeRSBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDETreeNodeRSBase.getPSDEActionId());
        }
        if (pSDETreeNodeRSBase.isPSDEActionNameDirty() && (bl || pSDETreeNodeRSBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDETreeNodeRSBase.getPSDEActionName());
        }
        if (pSDETreeNodeRSBase.isPSDERIdDirty() && (bl || pSDETreeNodeRSBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDETreeNodeRSBase.getPSDERId());
        }
        if (pSDETreeNodeRSBase.isPSDERNameDirty() && (bl || pSDETreeNodeRSBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDETreeNodeRSBase.getPSDERName());
        }
        if (pSDETreeNodeRSBase.isPSDETreeNodeRSIdDirty() && (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSId() != null)) {
            iDataObject.set(FIELD_PSDETREENODERSID, (Object)pSDETreeNodeRSBase.getPSDETreeNodeRSId());
        }
        if (pSDETreeNodeRSBase.isPSDETreeNodeRSNameDirty() && (bl || pSDETreeNodeRSBase.getPSDETreeNodeRSName() != null)) {
            iDataObject.set(FIELD_PSDETREENODERSNAME, (Object)pSDETreeNodeRSBase.getPSDETreeNodeRSName());
        }
        if (pSDETreeNodeRSBase.isPSDETreeViewIdDirty() && (bl || pSDETreeNodeRSBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeNodeRSBase.getPSDETreeViewId());
        }
        if (pSDETreeNodeRSBase.isPSDETreeViewNameDirty() && (bl || pSDETreeNodeRSBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeNodeRSBase.getPSDETreeViewName());
        }
        if (pSDETreeNodeRSBase.isPValueLevelDirty() && (bl || pSDETreeNodeRSBase.getPValueLevel() != null)) {
            iDataObject.set(FIELD_PVALUELEVEL, (Object)pSDETreeNodeRSBase.getPValueLevel());
        }
        if (pSDETreeNodeRSBase.isSearchModeDirty() && (bl || pSDETreeNodeRSBase.getSearchMode() != null)) {
            iDataObject.set(FIELD_SEARCHMODE, (Object)pSDETreeNodeRSBase.getSearchMode());
        }
        if (pSDETreeNodeRSBase.isTypeFilterDirty() && (bl || pSDETreeNodeRSBase.getTypeFilter() != null)) {
            iDataObject.set(FIELD_TYPEFILTER, (Object)pSDETreeNodeRSBase.getTypeFilter());
        }
        if (pSDETreeNodeRSBase.isUpdateDateDirty() && (bl || pSDETreeNodeRSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeNodeRSBase.getUpdateDate());
        }
        if (pSDETreeNodeRSBase.isUpdateManDirty() && (bl || pSDETreeNodeRSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeNodeRSBase.getUpdateMan());
        }
        if (pSDETreeNodeRSBase.isUserCatDirty() && (bl || pSDETreeNodeRSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeNodeRSBase.getUserCat());
        }
        if (pSDETreeNodeRSBase.isUserTagDirty() && (bl || pSDETreeNodeRSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeNodeRSBase.getUserTag());
        }
        if (pSDETreeNodeRSBase.isUserTag2Dirty() && (bl || pSDETreeNodeRSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeNodeRSBase.getUserTag2());
        }
        if (pSDETreeNodeRSBase.isUserTag3Dirty() && (bl || pSDETreeNodeRSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDETreeNodeRSBase.getUserTag3());
        }
        if (pSDETreeNodeRSBase.isUserTag4Dirty() && (bl || pSDETreeNodeRSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDETreeNodeRSBase.getUserTag4());
        }
        if (pSDETreeNodeRSBase.isValidFlagDirty() && (bl || pSDETreeNodeRSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDETreeNodeRSBase.getValidFlag());
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
        return PSDETreeNodeRSBase.remove(this, n);
    }

    private static boolean remove(PSDETreeNodeRSBase pSDETreeNodeRSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeNodeRSBase.resetChildFilter();
                return true;
            }
            case 1: {
                pSDETreeNodeRSBase.resetChildFilterDesc();
                return true;
            }
            case 2: {
                pSDETreeNodeRSBase.resetCMCreate();
                return true;
            }
            case 3: {
                pSDETreeNodeRSBase.resetCPSDETreeNodeId();
                return true;
            }
            case 4: {
                pSDETreeNodeRSBase.resetCPSDETreeNodeName();
                return true;
            }
            case 5: {
                pSDETreeNodeRSBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDETreeNodeRSBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDETreeNodeRSBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSDETreeNodeRSBase.resetCustomMode();
                return true;
            }
            case 9: {
                pSDETreeNodeRSBase.resetMemo();
                return true;
            }
            case 10: {
                pSDETreeNodeRSBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSDETreeNodeRSBase.resetPPSDETreeNodeId();
                return true;
            }
            case 12: {
                pSDETreeNodeRSBase.resetPPSDETreeNodeName();
                return true;
            }
            case 13: {
                pSDETreeNodeRSBase.resetProcessParam();
                return true;
            }
            case 14: {
                pSDETreeNodeRSBase.resetPSDEActionId();
                return true;
            }
            case 15: {
                pSDETreeNodeRSBase.resetPSDEActionName();
                return true;
            }
            case 16: {
                pSDETreeNodeRSBase.resetPSDERId();
                return true;
            }
            case 17: {
                pSDETreeNodeRSBase.resetPSDERName();
                return true;
            }
            case 18: {
                pSDETreeNodeRSBase.resetPSDETreeNodeRSId();
                return true;
            }
            case 19: {
                pSDETreeNodeRSBase.resetPSDETreeNodeRSName();
                return true;
            }
            case 20: {
                pSDETreeNodeRSBase.resetPSDETreeViewId();
                return true;
            }
            case 21: {
                pSDETreeNodeRSBase.resetPSDETreeViewName();
                return true;
            }
            case 22: {
                pSDETreeNodeRSBase.resetPValueLevel();
                return true;
            }
            case 23: {
                pSDETreeNodeRSBase.resetSearchMode();
                return true;
            }
            case 24: {
                pSDETreeNodeRSBase.resetTypeFilter();
                return true;
            }
            case 25: {
                pSDETreeNodeRSBase.resetUpdateDate();
                return true;
            }
            case 26: {
                pSDETreeNodeRSBase.resetUpdateMan();
                return true;
            }
            case 27: {
                pSDETreeNodeRSBase.resetUserCat();
                return true;
            }
            case 28: {
                pSDETreeNodeRSBase.resetUserTag();
                return true;
            }
            case 29: {
                pSDETreeNodeRSBase.resetUserTag2();
                return true;
            }
            case 30: {
                pSDETreeNodeRSBase.resetUserTag3();
                return true;
            }
            case 31: {
                pSDETreeNodeRSBase.resetUserTag4();
                return true;
            }
            case 32: {
                pSDETreeNodeRSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet((IEntity)pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNode getCPSDETreeNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCPSDETreeNode();
        }
        if (this.getCPSDETreeNodeId() == null) {
            return null;
        }
        Integer n = this.objCPSDETreeNodeLock;
        synchronized (n) {
            if (this.cpsdetreenode != null && DataTypeHelper.compare((int)25, (Object)this.getCPSDETreeNodeId(), (Object)this.cpsdetreenode.getPSDETreeNodeId()) != 0L) {
                this.cpsdetreenode = null;
            }
            if (this.cpsdetreenode == null) {
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNode.setPSDETreeNodeId(this.getCPSDETreeNodeId());
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeService.autoGet((IEntity)pSDETreeNode);
                this.cpsdetreenode = pSDETreeNode;
            }
            return this.cpsdetreenode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeNode getPPSDETreeNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSDETreeNode();
        }
        if (this.getPPSDETreeNodeId() == null) {
            return null;
        }
        Integer n = this.objPPSDETreeNodeLock;
        synchronized (n) {
            if (this.ppsdetreenode != null && DataTypeHelper.compare((int)25, (Object)this.getPPSDETreeNodeId(), (Object)this.ppsdetreenode.getPSDETreeNodeId()) != 0L) {
                this.ppsdetreenode = null;
            }
            if (this.ppsdetreenode == null) {
                PSDETreeNode pSDETreeNode = new PSDETreeNode();
                pSDETreeNode.setPSDETreeNodeId(this.getPPSDETreeNodeId());
                PSDETreeNodeService pSDETreeNodeService = (PSDETreeNodeService)ServiceGlobal.getService(PSDETreeNodeService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeNodeService.autoGet((IEntity)pSDETreeNode);
                this.ppsdetreenode = pSDETreeNode;
            }
            return this.ppsdetreenode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet((IEntity)pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    private PSDETreeNodeRSBase getProxyEntity() {
        return this.proxyPSDETreeNodeRSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeNodeRSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeNodeRSBase) {
            this.proxyPSDETreeNodeRSBase = (PSDETreeNodeRSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeNodeRSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CHILDFILTER, 0);
        fieldIndexMap.put(FIELD_CHILDFILTERDESC, 1);
        fieldIndexMap.put(FIELD_CMCREATE, 2);
        fieldIndexMap.put(FIELD_CPSDETREENODEID, 3);
        fieldIndexMap.put(FIELD_CPSDETREENODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PPSDETREENODEID, 11);
        fieldIndexMap.put(FIELD_PPSDETREENODENAME, 12);
        fieldIndexMap.put(FIELD_PROCESSPARAM, 13);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 14);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 15);
        fieldIndexMap.put(FIELD_PSDERID, 16);
        fieldIndexMap.put(FIELD_PSDERNAME, 17);
        fieldIndexMap.put(FIELD_PSDETREENODERSID, 18);
        fieldIndexMap.put(FIELD_PSDETREENODERSNAME, 19);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 20);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 21);
        fieldIndexMap.put(FIELD_PVALUELEVEL, 22);
        fieldIndexMap.put(FIELD_SEARCHMODE, 23);
        fieldIndexMap.put(FIELD_TYPEFILTER, 24);
        fieldIndexMap.put(FIELD_UPDATEDATE, 25);
        fieldIndexMap.put(FIELD_UPDATEMAN, 26);
        fieldIndexMap.put(FIELD_USERCAT, 27);
        fieldIndexMap.put(FIELD_USERTAG, 28);
        fieldIndexMap.put(FIELD_USERTAG2, 29);
        fieldIndexMap.put(FIELD_USERTAG3, 30);
        fieldIndexMap.put(FIELD_USERTAG4, 31);
        fieldIndexMap.put(FIELD_VALIDFLAG, 32);
    }
}

