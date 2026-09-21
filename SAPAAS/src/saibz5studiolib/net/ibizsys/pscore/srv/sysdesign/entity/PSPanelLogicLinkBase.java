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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelLogic;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLogicLinkBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLogicLinkBase.class);
    public static final String FIELD_CALLBACKNAME = "CALLBACKNAME";
    public static final String FIELD_CONDMODEL = "CONDMODEL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTLINK = "DEFAULTLINK";
    public static final String FIELD_DSTENDPOINT = "DSTENDPOINT";
    public static final String FIELD_DSTPSPANELLOGICNODEID = "DSTPSPANELLOGICNODEID";
    public static final String FIELD_DSTPSPANELLOGICNODENAME = "DSTPSPANELLOGICNODENAME";
    public static final String FIELD_LINKINFO = "LINKINFO";
    public static final String FIELD_LINKTYPE = "LINKTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSPANELLOGICLINKID = "PSPANELLOGICLINKID";
    public static final String FIELD_PSPANELLOGICLINKNAME = "PSPANELLOGICLINKNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELLOGICNAME = "PSSYSVIEWPANELLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_SRCENDPOINT = "SRCENDPOINT";
    public static final String FIELD_SRCPSPANELLOGICNODEID = "SRCPSPANELLOGICNODEID";
    public static final String FIELD_SRCPSPANELLOGICNODENAME = "SRCPSPANELLOGICNODENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CALLBACKNAME = 0;
    private static final int INDEX_CONDMODEL = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DEFAULTLINK = 4;
    private static final int INDEX_DSTENDPOINT = 5;
    private static final int INDEX_DSTPSPANELLOGICNODEID = 6;
    private static final int INDEX_DSTPSPANELLOGICNODENAME = 7;
    private static final int INDEX_LINKINFO = 8;
    private static final int INDEX_LINKTYPE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PSPANELLOGICLINKID = 12;
    private static final int INDEX_PSPANELLOGICLINKNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSVIEWPANELID = 15;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 16;
    private static final int INDEX_PSSYSVIEWPANELLOGICNAME = 17;
    private static final int INDEX_PSSYSVIEWPANELNAME = 18;
    private static final int INDEX_SRCENDPOINT = 19;
    private static final int INDEX_SRCPSPANELLOGICNODEID = 20;
    private static final int INDEX_SRCPSPANELLOGICNODENAME = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLogicLinkBase proxyPSPanelLogicLinkBase = null;
    private boolean callbacknameDirtyFlag = false;
    private boolean condmodelDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultlinkDirtyFlag = false;
    private boolean dstendpointDirtyFlag = false;
    private boolean dstpspanellogicnodeidDirtyFlag = false;
    private boolean dstpspanellogicnodenameDirtyFlag = false;
    private boolean linkinfoDirtyFlag = false;
    private boolean linktypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pspanellogiclinkidDirtyFlag = false;
    private boolean pspanellogiclinknameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
    private boolean pssysviewpanellogicnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean srcendpointDirtyFlag = false;
    private boolean srcpspanellogicnodeidDirtyFlag = false;
    private boolean srcpspanellogicnodenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="callbackname")
    private String callbackname;
    @Column(name="condmodel")
    private String condmodel;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultlink")
    private Integer defaultlink;
    @Column(name="dstendpoint")
    private String dstendpoint;
    @Column(name="dstpspanellogicnodeid")
    private String dstpspanellogicnodeid;
    @Column(name="dstpspanellogicnodename")
    private String dstpspanellogicnodename;
    @Column(name="linkinfo")
    private String linkinfo;
    @Column(name="linktype")
    private String linktype;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pspanellogiclinkid")
    private String pspanellogiclinkid;
    @Column(name="pspanellogiclinkname")
    private String pspanellogiclinkname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanellogicid")
    private String pssysviewpanellogicid;
    @Column(name="pssysviewpanellogicname")
    private String pssysviewpanellogicname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="srcendpoint")
    private String srcendpoint;
    @Column(name="srcpspanellogicnodeid")
    private String srcpspanellogicnodeid;
    @Column(name="srcpspanellogicnodename")
    private String srcpspanellogicnodename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objDstPSPanelLogicNodeLock = new Integer(1);
    private PSPanelLogicNode dstpspanellogicnode = null;
    private Integer objSrcPSPanelLogicNodeLock = new Integer(1);
    private PSPanelLogicNode srcpspanellogicnode = null;
    private Integer objPSSysViewPanelLogicLock = new Integer(1);
    private PSSysViewPanelLogic pssysviewpanellogic = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSPanelLLCondsLock = new Integer(1);
    private ArrayList<PSPanelLLCond> pspanelllconds = null;

    public void setCallbackName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCallbackName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.callbackname = string;
        this.callbacknameDirtyFlag = true;
    }

    public String getCallbackName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCallbackName();
        }
        return this.callbackname;
    }

    public boolean isCallbackNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCallbackNameDirty();
        }
        return this.callbacknameDirtyFlag;
    }

    public void resetCallbackName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCallbackName();
            return;
        }
        this.callbacknameDirtyFlag = false;
        this.callbackname = null;
    }

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

    public void setDstPSPanelLogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelLogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanellogicnodeid = string;
        this.dstpspanellogicnodeidDirtyFlag = true;
    }

    public String getDstPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLogicNodeId();
        }
        return this.dstpspanellogicnodeid;
    }

    public boolean isDstPSPanelLogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelLogicNodeIdDirty();
        }
        return this.dstpspanellogicnodeidDirtyFlag;
    }

    public void resetDstPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelLogicNodeId();
            return;
        }
        this.dstpspanellogicnodeidDirtyFlag = false;
        this.dstpspanellogicnodeid = null;
    }

    public void setDstPSPanelLogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelLogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanellogicnodename = string;
        this.dstpspanellogicnodenameDirtyFlag = true;
    }

    public String getDstPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLogicNodeName();
        }
        return this.dstpspanellogicnodename;
    }

    public boolean isDstPSPanelLogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelLogicNodeNameDirty();
        }
        return this.dstpspanellogicnodenameDirtyFlag;
    }

    public void resetDstPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelLogicNodeName();
            return;
        }
        this.dstpspanellogicnodenameDirtyFlag = false;
        this.dstpspanellogicnodename = null;
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

    public void setLinkType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.linktype = string;
        this.linktypeDirtyFlag = true;
    }

    public String getLinkType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkType();
        }
        return this.linktype;
    }

    public boolean isLinkTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkTypeDirty();
        }
        return this.linktypeDirtyFlag;
    }

    public void resetLinkType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkType();
            return;
        }
        this.linktypeDirtyFlag = false;
        this.linktype = null;
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

    public void setPSPanelLogicLinkId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicLinkId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogiclinkid = string;
        this.pspanellogiclinkidDirtyFlag = true;
    }

    public String getPSPanelLogicLinkId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicLinkId();
        }
        return this.pspanellogiclinkid;
    }

    public boolean isPSPanelLogicLinkIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicLinkIdDirty();
        }
        return this.pspanellogiclinkidDirtyFlag;
    }

    public void resetPSPanelLogicLinkId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicLinkId();
            return;
        }
        this.pspanellogiclinkidDirtyFlag = false;
        this.pspanellogiclinkid = null;
    }

    public void setPSPanelLogicLinkName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicLinkName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogiclinkname = string;
        this.pspanellogiclinknameDirtyFlag = true;
    }

    public String getPSPanelLogicLinkName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicLinkName();
        }
        return this.pspanellogiclinkname;
    }

    public boolean isPSPanelLogicLinkNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicLinkNameDirty();
        }
        return this.pspanellogiclinknameDirtyFlag;
    }

    public void resetPSPanelLogicLinkName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicLinkName();
            return;
        }
        this.pspanellogiclinknameDirtyFlag = false;
        this.pspanellogiclinkname = null;
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

    public void setPSSysViewPanelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelid = string;
        this.pssysviewpanelidDirtyFlag = true;
    }

    public String getPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelId();
        }
        return this.pssysviewpanelid;
    }

    public boolean isPSSysViewPanelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelIdDirty();
        }
        return this.pssysviewpanelidDirtyFlag;
    }

    public void resetPSSysViewPanelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelId();
            return;
        }
        this.pssysviewpanelidDirtyFlag = false;
        this.pssysviewpanelid = null;
    }

    public void setPSSysViewPanelLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicid = string;
        this.pssysviewpanellogicidDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicId();
        }
        return this.pssysviewpanellogicid;
    }

    public boolean isPSSysViewPanelLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicIdDirty();
        }
        return this.pssysviewpanellogicidDirtyFlag;
    }

    public void resetPSSysViewPanelLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicId();
            return;
        }
        this.pssysviewpanellogicidDirtyFlag = false;
        this.pssysviewpanellogicid = null;
    }

    public void setPSSysViewPanelLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanellogicname = string;
        this.pssysviewpanellogicnameDirtyFlag = true;
    }

    public String getPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogicName();
        }
        return this.pssysviewpanellogicname;
    }

    public boolean isPSSysViewPanelLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelLogicNameDirty();
        }
        return this.pssysviewpanellogicnameDirtyFlag;
    }

    public void resetPSSysViewPanelLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelLogicName();
            return;
        }
        this.pssysviewpanellogicnameDirtyFlag = false;
        this.pssysviewpanellogicname = null;
    }

    public void setPSSysViewPanelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelname = string;
        this.pssysviewpanelnameDirtyFlag = true;
    }

    public String getPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelName();
        }
        return this.pssysviewpanelname;
    }

    public boolean isPSSysViewPanelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelNameDirty();
        }
        return this.pssysviewpanelnameDirtyFlag;
    }

    public void resetPSSysViewPanelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelName();
            return;
        }
        this.pssysviewpanelnameDirtyFlag = false;
        this.pssysviewpanelname = null;
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

    public void setSrcPSPanelLogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSPanelLogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpspanellogicnodeid = string;
        this.srcpspanellogicnodeidDirtyFlag = true;
    }

    public String getSrcPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLogicNodeId();
        }
        return this.srcpspanellogicnodeid;
    }

    public boolean isSrcPSPanelLogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSPanelLogicNodeIdDirty();
        }
        return this.srcpspanellogicnodeidDirtyFlag;
    }

    public void resetSrcPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSPanelLogicNodeId();
            return;
        }
        this.srcpspanellogicnodeidDirtyFlag = false;
        this.srcpspanellogicnodeid = null;
    }

    public void setSrcPSPanelLogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSPanelLogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpspanellogicnodename = string;
        this.srcpspanellogicnodenameDirtyFlag = true;
    }

    public String getSrcPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLogicNodeName();
        }
        return this.srcpspanellogicnodename;
    }

    public boolean isSrcPSPanelLogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSPanelLogicNodeNameDirty();
        }
        return this.srcpspanellogicnodenameDirtyFlag;
    }

    public void resetSrcPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSPanelLogicNodeName();
            return;
        }
        this.srcpspanellogicnodenameDirtyFlag = false;
        this.srcpspanellogicnodename = null;
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
        PSPanelLogicLinkBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLogicLinkBase pSPanelLogicLinkBase) {
        pSPanelLogicLinkBase.resetCallbackName();
        pSPanelLogicLinkBase.resetCondModel();
        pSPanelLogicLinkBase.resetCreateDate();
        pSPanelLogicLinkBase.resetCreateMan();
        pSPanelLogicLinkBase.resetDefaultLink();
        pSPanelLogicLinkBase.resetDstEndPoint();
        pSPanelLogicLinkBase.resetDstPSPanelLogicNodeId();
        pSPanelLogicLinkBase.resetDstPSPanelLogicNodeName();
        pSPanelLogicLinkBase.resetLinkInfo();
        pSPanelLogicLinkBase.resetLinkType();
        pSPanelLogicLinkBase.resetMemo();
        pSPanelLogicLinkBase.resetOrderValue();
        pSPanelLogicLinkBase.resetPSPanelLogicLinkId();
        pSPanelLogicLinkBase.resetPSPanelLogicLinkName();
        pSPanelLogicLinkBase.resetPSSystemId();
        pSPanelLogicLinkBase.resetPSSysViewPanelId();
        pSPanelLogicLinkBase.resetPSSysViewPanelLogicId();
        pSPanelLogicLinkBase.resetPSSysViewPanelLogicName();
        pSPanelLogicLinkBase.resetPSSysViewPanelName();
        pSPanelLogicLinkBase.resetSrcEndPoint();
        pSPanelLogicLinkBase.resetSrcPSPanelLogicNodeId();
        pSPanelLogicLinkBase.resetSrcPSPanelLogicNodeName();
        pSPanelLogicLinkBase.resetUpdateDate();
        pSPanelLogicLinkBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCallbackNameDirty()) {
            hashMap.put(FIELD_CALLBACKNAME, this.getCallbackName());
        }
        if (!bl || this.isCondModelDirty()) {
            hashMap.put(FIELD_CONDMODEL, this.getCondModel());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultLinkDirty()) {
            hashMap.put(FIELD_DEFAULTLINK, this.getDefaultLink());
        }
        if (!bl || this.isDstEndPointDirty()) {
            hashMap.put(FIELD_DSTENDPOINT, this.getDstEndPoint());
        }
        if (!bl || this.isDstPSPanelLogicNodeIdDirty()) {
            hashMap.put(FIELD_DSTPSPANELLOGICNODEID, this.getDstPSPanelLogicNodeId());
        }
        if (!bl || this.isDstPSPanelLogicNodeNameDirty()) {
            hashMap.put(FIELD_DSTPSPANELLOGICNODENAME, this.getDstPSPanelLogicNodeName());
        }
        if (!bl || this.isLinkInfoDirty()) {
            hashMap.put(FIELD_LINKINFO, this.getLinkInfo());
        }
        if (!bl || this.isLinkTypeDirty()) {
            hashMap.put(FIELD_LINKTYPE, this.getLinkType());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSPanelLogicLinkIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICLINKID, this.getPSPanelLogicLinkId());
        }
        if (!bl || this.isPSPanelLogicLinkNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICLINKNAME, this.getPSPanelLogicLinkName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelLogicIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICID, this.getPSSysViewPanelLogicId());
        }
        if (!bl || this.isPSSysViewPanelLogicNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, this.getPSSysViewPanelLogicName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isSrcEndPointDirty()) {
            hashMap.put(FIELD_SRCENDPOINT, this.getSrcEndPoint());
        }
        if (!bl || this.isSrcPSPanelLogicNodeIdDirty()) {
            hashMap.put(FIELD_SRCPSPANELLOGICNODEID, this.getSrcPSPanelLogicNodeId());
        }
        if (!bl || this.isSrcPSPanelLogicNodeNameDirty()) {
            hashMap.put(FIELD_SRCPSPANELLOGICNODENAME, this.getSrcPSPanelLogicNodeName());
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
        return PSPanelLogicLinkBase.get(this, n);
    }

    private static Object get(PSPanelLogicLinkBase pSPanelLogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicLinkBase.getCallbackName();
            }
            case 1: {
                return pSPanelLogicLinkBase.getCondModel();
            }
            case 2: {
                return pSPanelLogicLinkBase.getCreateDate();
            }
            case 3: {
                return pSPanelLogicLinkBase.getCreateMan();
            }
            case 4: {
                return pSPanelLogicLinkBase.getDefaultLink();
            }
            case 5: {
                return pSPanelLogicLinkBase.getDstEndPoint();
            }
            case 6: {
                return pSPanelLogicLinkBase.getDstPSPanelLogicNodeId();
            }
            case 7: {
                return pSPanelLogicLinkBase.getDstPSPanelLogicNodeName();
            }
            case 8: {
                return pSPanelLogicLinkBase.getLinkInfo();
            }
            case 9: {
                return pSPanelLogicLinkBase.getLinkType();
            }
            case 10: {
                return pSPanelLogicLinkBase.getMemo();
            }
            case 11: {
                return pSPanelLogicLinkBase.getOrderValue();
            }
            case 12: {
                return pSPanelLogicLinkBase.getPSPanelLogicLinkId();
            }
            case 13: {
                return pSPanelLogicLinkBase.getPSPanelLogicLinkName();
            }
            case 14: {
                return pSPanelLogicLinkBase.getPSSystemId();
            }
            case 15: {
                return pSPanelLogicLinkBase.getPSSysViewPanelId();
            }
            case 16: {
                return pSPanelLogicLinkBase.getPSSysViewPanelLogicId();
            }
            case 17: {
                return pSPanelLogicLinkBase.getPSSysViewPanelLogicName();
            }
            case 18: {
                return pSPanelLogicLinkBase.getPSSysViewPanelName();
            }
            case 19: {
                return pSPanelLogicLinkBase.getSrcEndPoint();
            }
            case 20: {
                return pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId();
            }
            case 21: {
                return pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName();
            }
            case 22: {
                return pSPanelLogicLinkBase.getUpdateDate();
            }
            case 23: {
                return pSPanelLogicLinkBase.getUpdateMan();
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
        PSPanelLogicLinkBase.set(this, n, object);
    }

    private static void set(PSPanelLogicLinkBase pSPanelLogicLinkBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicLinkBase.setCallbackName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLogicLinkBase.setCondModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLogicLinkBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLogicLinkBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLogicLinkBase.setDefaultLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLogicLinkBase.setDstEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLogicLinkBase.setDstPSPanelLogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLogicLinkBase.setDstPSPanelLogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLogicLinkBase.setLinkInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLogicLinkBase.setLinkType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLogicLinkBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelLogicLinkBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSPanelLogicLinkBase.setPSPanelLogicLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelLogicLinkBase.setPSPanelLogicLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelLogicLinkBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelLogicLinkBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelLogicLinkBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelLogicLinkBase.setPSSysViewPanelLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPanelLogicLinkBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPanelLogicLinkBase.setSrcEndPoint(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPanelLogicLinkBase.setSrcPSPanelLogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPanelLogicLinkBase.setSrcPSPanelLogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPanelLogicLinkBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSPanelLogicLinkBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLogicLinkBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLogicLinkBase pSPanelLogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicLinkBase.getCallbackName() == null;
            }
            case 1: {
                return pSPanelLogicLinkBase.getCondModel() == null;
            }
            case 2: {
                return pSPanelLogicLinkBase.getCreateDate() == null;
            }
            case 3: {
                return pSPanelLogicLinkBase.getCreateMan() == null;
            }
            case 4: {
                return pSPanelLogicLinkBase.getDefaultLink() == null;
            }
            case 5: {
                return pSPanelLogicLinkBase.getDstEndPoint() == null;
            }
            case 6: {
                return pSPanelLogicLinkBase.getDstPSPanelLogicNodeId() == null;
            }
            case 7: {
                return pSPanelLogicLinkBase.getDstPSPanelLogicNodeName() == null;
            }
            case 8: {
                return pSPanelLogicLinkBase.getLinkInfo() == null;
            }
            case 9: {
                return pSPanelLogicLinkBase.getLinkType() == null;
            }
            case 10: {
                return pSPanelLogicLinkBase.getMemo() == null;
            }
            case 11: {
                return pSPanelLogicLinkBase.getOrderValue() == null;
            }
            case 12: {
                return pSPanelLogicLinkBase.getPSPanelLogicLinkId() == null;
            }
            case 13: {
                return pSPanelLogicLinkBase.getPSPanelLogicLinkName() == null;
            }
            case 14: {
                return pSPanelLogicLinkBase.getPSSystemId() == null;
            }
            case 15: {
                return pSPanelLogicLinkBase.getPSSysViewPanelId() == null;
            }
            case 16: {
                return pSPanelLogicLinkBase.getPSSysViewPanelLogicId() == null;
            }
            case 17: {
                return pSPanelLogicLinkBase.getPSSysViewPanelLogicName() == null;
            }
            case 18: {
                return pSPanelLogicLinkBase.getPSSysViewPanelName() == null;
            }
            case 19: {
                return pSPanelLogicLinkBase.getSrcEndPoint() == null;
            }
            case 20: {
                return pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId() == null;
            }
            case 21: {
                return pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName() == null;
            }
            case 22: {
                return pSPanelLogicLinkBase.getUpdateDate() == null;
            }
            case 23: {
                return pSPanelLogicLinkBase.getUpdateMan() == null;
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
        return PSPanelLogicLinkBase.contains(this, n);
    }

    private static boolean contains(PSPanelLogicLinkBase pSPanelLogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLogicLinkBase.isCallbackNameDirty();
            }
            case 1: {
                return pSPanelLogicLinkBase.isCondModelDirty();
            }
            case 2: {
                return pSPanelLogicLinkBase.isCreateDateDirty();
            }
            case 3: {
                return pSPanelLogicLinkBase.isCreateManDirty();
            }
            case 4: {
                return pSPanelLogicLinkBase.isDefaultLinkDirty();
            }
            case 5: {
                return pSPanelLogicLinkBase.isDstEndPointDirty();
            }
            case 6: {
                return pSPanelLogicLinkBase.isDstPSPanelLogicNodeIdDirty();
            }
            case 7: {
                return pSPanelLogicLinkBase.isDstPSPanelLogicNodeNameDirty();
            }
            case 8: {
                return pSPanelLogicLinkBase.isLinkInfoDirty();
            }
            case 9: {
                return pSPanelLogicLinkBase.isLinkTypeDirty();
            }
            case 10: {
                return pSPanelLogicLinkBase.isMemoDirty();
            }
            case 11: {
                return pSPanelLogicLinkBase.isOrderValueDirty();
            }
            case 12: {
                return pSPanelLogicLinkBase.isPSPanelLogicLinkIdDirty();
            }
            case 13: {
                return pSPanelLogicLinkBase.isPSPanelLogicLinkNameDirty();
            }
            case 14: {
                return pSPanelLogicLinkBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSPanelLogicLinkBase.isPSSysViewPanelIdDirty();
            }
            case 16: {
                return pSPanelLogicLinkBase.isPSSysViewPanelLogicIdDirty();
            }
            case 17: {
                return pSPanelLogicLinkBase.isPSSysViewPanelLogicNameDirty();
            }
            case 18: {
                return pSPanelLogicLinkBase.isPSSysViewPanelNameDirty();
            }
            case 19: {
                return pSPanelLogicLinkBase.isSrcEndPointDirty();
            }
            case 20: {
                return pSPanelLogicLinkBase.isSrcPSPanelLogicNodeIdDirty();
            }
            case 21: {
                return pSPanelLogicLinkBase.isSrcPSPanelLogicNodeNameDirty();
            }
            case 22: {
                return pSPanelLogicLinkBase.isUpdateDateDirty();
            }
            case 23: {
                return pSPanelLogicLinkBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLogicLinkBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLogicLinkBase pSPanelLogicLinkBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLogicLinkBase.getCallbackName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"callbackname", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getCallbackName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getCondModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condmodel", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getCondModel()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getDefaultLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultlink", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getDefaultLink()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getDstEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstendpoint", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getDstEndPoint()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellogicnodeid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getDstPSPanelLogicNodeId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellogicnodename", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getDstPSPanelLogicNodeName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getLinkInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkinfo", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getLinkInfo()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getLinkType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linktype", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getLinkType()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogiclinkid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSPanelLogicLinkId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogiclinkname", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSPanelLogicLinkName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicname", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSSysViewPanelLogicName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getSrcEndPoint() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcendpoint", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getSrcEndPoint()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpspanellogicnodeid", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpspanellogicnodename", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLogicLinkBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLogicLinkBase.getJSONValue((Object)pSPanelLogicLinkBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLogicLinkBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLogicLinkBase pSPanelLogicLinkBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLogicLinkBase.getCallbackName() != null) {
            object = pSPanelLogicLinkBase.getCallbackName();
            xmlNode.setAttribute(FIELD_CALLBACKNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSPanelLogicLinkBase.getCondModel() != null) {
            object = pSPanelLogicLinkBase.getCondModel();
            xmlNode.setAttribute(FIELD_CONDMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getCreateDate() != null) {
            object = pSPanelLogicLinkBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicLinkBase.getCreateMan() != null) {
            object = pSPanelLogicLinkBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getDefaultLink() != null) {
            object = pSPanelLogicLinkBase.getDefaultLink();
            xmlNode.setAttribute(FIELD_DEFAULTLINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicLinkBase.getDstEndPoint() != null) {
            object = pSPanelLogicLinkBase.getDstEndPoint();
            xmlNode.setAttribute(FIELD_DSTENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeId() != null) {
            object = pSPanelLogicLinkBase.getDstPSPanelLogicNodeId();
            xmlNode.setAttribute(FIELD_DSTPSPANELLOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeName() != null) {
            object = pSPanelLogicLinkBase.getDstPSPanelLogicNodeName();
            xmlNode.setAttribute(FIELD_DSTPSPANELLOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getLinkInfo() != null) {
            object = pSPanelLogicLinkBase.getLinkInfo();
            xmlNode.setAttribute(FIELD_LINKINFO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getLinkType() != null) {
            object = pSPanelLogicLinkBase.getLinkType();
            xmlNode.setAttribute(FIELD_LINKTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getMemo() != null) {
            object = pSPanelLogicLinkBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getOrderValue() != null) {
            object = pSPanelLogicLinkBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkId() != null) {
            object = pSPanelLogicLinkBase.getPSPanelLogicLinkId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkName() != null) {
            object = pSPanelLogicLinkBase.getPSPanelLogicLinkName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSSystemId() != null) {
            object = pSPanelLogicLinkBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelId() != null) {
            object = pSPanelLogicLinkBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicId() != null) {
            object = pSPanelLogicLinkBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicName() != null) {
            object = pSPanelLogicLinkBase.getPSSysViewPanelLogicName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getPSSysViewPanelName() != null) {
            object = pSPanelLogicLinkBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getSrcEndPoint() != null) {
            object = pSPanelLogicLinkBase.getSrcEndPoint();
            xmlNode.setAttribute(FIELD_SRCENDPOINT, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId() != null) {
            object = pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId();
            xmlNode.setAttribute(FIELD_SRCPSPANELLOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName() != null) {
            object = pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName();
            xmlNode.setAttribute(FIELD_SRCPSPANELLOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLogicLinkBase.getUpdateDate() != null) {
            object = pSPanelLogicLinkBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLogicLinkBase.getUpdateMan() != null) {
            object = pSPanelLogicLinkBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLogicLinkBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLogicLinkBase pSPanelLogicLinkBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLogicLinkBase.isCallbackNameDirty() && (bl || pSPanelLogicLinkBase.getCallbackName() != null)) {
            iDataObject.set(FIELD_CALLBACKNAME, (Object)pSPanelLogicLinkBase.getCallbackName());
        }
        if (pSPanelLogicLinkBase.isCondModelDirty() && (bl || pSPanelLogicLinkBase.getCondModel() != null)) {
            iDataObject.set(FIELD_CONDMODEL, (Object)pSPanelLogicLinkBase.getCondModel());
        }
        if (pSPanelLogicLinkBase.isCreateDateDirty() && (bl || pSPanelLogicLinkBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLogicLinkBase.getCreateDate());
        }
        if (pSPanelLogicLinkBase.isCreateManDirty() && (bl || pSPanelLogicLinkBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLogicLinkBase.getCreateMan());
        }
        if (pSPanelLogicLinkBase.isDefaultLinkDirty() && (bl || pSPanelLogicLinkBase.getDefaultLink() != null)) {
            iDataObject.set(FIELD_DEFAULTLINK, (Object)pSPanelLogicLinkBase.getDefaultLink());
        }
        if (pSPanelLogicLinkBase.isDstEndPointDirty() && (bl || pSPanelLogicLinkBase.getDstEndPoint() != null)) {
            iDataObject.set(FIELD_DSTENDPOINT, (Object)pSPanelLogicLinkBase.getDstEndPoint());
        }
        if (pSPanelLogicLinkBase.isDstPSPanelLogicNodeIdDirty() && (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeId() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLOGICNODEID, (Object)pSPanelLogicLinkBase.getDstPSPanelLogicNodeId());
        }
        if (pSPanelLogicLinkBase.isDstPSPanelLogicNodeNameDirty() && (bl || pSPanelLogicLinkBase.getDstPSPanelLogicNodeName() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLOGICNODENAME, (Object)pSPanelLogicLinkBase.getDstPSPanelLogicNodeName());
        }
        if (pSPanelLogicLinkBase.isLinkInfoDirty() && (bl || pSPanelLogicLinkBase.getLinkInfo() != null)) {
            iDataObject.set(FIELD_LINKINFO, (Object)pSPanelLogicLinkBase.getLinkInfo());
        }
        if (pSPanelLogicLinkBase.isLinkTypeDirty() && (bl || pSPanelLogicLinkBase.getLinkType() != null)) {
            iDataObject.set(FIELD_LINKTYPE, (Object)pSPanelLogicLinkBase.getLinkType());
        }
        if (pSPanelLogicLinkBase.isMemoDirty() && (bl || pSPanelLogicLinkBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLogicLinkBase.getMemo());
        }
        if (pSPanelLogicLinkBase.isOrderValueDirty() && (bl || pSPanelLogicLinkBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelLogicLinkBase.getOrderValue());
        }
        if (pSPanelLogicLinkBase.isPSPanelLogicLinkIdDirty() && (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICLINKID, (Object)pSPanelLogicLinkBase.getPSPanelLogicLinkId());
        }
        if (pSPanelLogicLinkBase.isPSPanelLogicLinkNameDirty() && (bl || pSPanelLogicLinkBase.getPSPanelLogicLinkName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICLINKNAME, (Object)pSPanelLogicLinkBase.getPSPanelLogicLinkName());
        }
        if (pSPanelLogicLinkBase.isPSSystemIdDirty() && (bl || pSPanelLogicLinkBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSPanelLogicLinkBase.getPSSystemId());
        }
        if (pSPanelLogicLinkBase.isPSSysViewPanelIdDirty() && (bl || pSPanelLogicLinkBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelLogicLinkBase.getPSSysViewPanelId());
        }
        if (pSPanelLogicLinkBase.isPSSysViewPanelLogicIdDirty() && (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSPanelLogicLinkBase.getPSSysViewPanelLogicId());
        }
        if (pSPanelLogicLinkBase.isPSSysViewPanelLogicNameDirty() && (bl || pSPanelLogicLinkBase.getPSSysViewPanelLogicName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICNAME, (Object)pSPanelLogicLinkBase.getPSSysViewPanelLogicName());
        }
        if (pSPanelLogicLinkBase.isPSSysViewPanelNameDirty() && (bl || pSPanelLogicLinkBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelLogicLinkBase.getPSSysViewPanelName());
        }
        if (pSPanelLogicLinkBase.isSrcEndPointDirty() && (bl || pSPanelLogicLinkBase.getSrcEndPoint() != null)) {
            iDataObject.set(FIELD_SRCENDPOINT, (Object)pSPanelLogicLinkBase.getSrcEndPoint());
        }
        if (pSPanelLogicLinkBase.isSrcPSPanelLogicNodeIdDirty() && (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId() != null)) {
            iDataObject.set(FIELD_SRCPSPANELLOGICNODEID, (Object)pSPanelLogicLinkBase.getSrcPSPanelLogicNodeId());
        }
        if (pSPanelLogicLinkBase.isSrcPSPanelLogicNodeNameDirty() && (bl || pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName() != null)) {
            iDataObject.set(FIELD_SRCPSPANELLOGICNODENAME, (Object)pSPanelLogicLinkBase.getSrcPSPanelLogicNodeName());
        }
        if (pSPanelLogicLinkBase.isUpdateDateDirty() && (bl || pSPanelLogicLinkBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLogicLinkBase.getUpdateDate());
        }
        if (pSPanelLogicLinkBase.isUpdateManDirty() && (bl || pSPanelLogicLinkBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLogicLinkBase.getUpdateMan());
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
        return PSPanelLogicLinkBase.remove(this, n);
    }

    private static boolean remove(PSPanelLogicLinkBase pSPanelLogicLinkBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLogicLinkBase.resetCallbackName();
                return true;
            }
            case 1: {
                pSPanelLogicLinkBase.resetCondModel();
                return true;
            }
            case 2: {
                pSPanelLogicLinkBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPanelLogicLinkBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPanelLogicLinkBase.resetDefaultLink();
                return true;
            }
            case 5: {
                pSPanelLogicLinkBase.resetDstEndPoint();
                return true;
            }
            case 6: {
                pSPanelLogicLinkBase.resetDstPSPanelLogicNodeId();
                return true;
            }
            case 7: {
                pSPanelLogicLinkBase.resetDstPSPanelLogicNodeName();
                return true;
            }
            case 8: {
                pSPanelLogicLinkBase.resetLinkInfo();
                return true;
            }
            case 9: {
                pSPanelLogicLinkBase.resetLinkType();
                return true;
            }
            case 10: {
                pSPanelLogicLinkBase.resetMemo();
                return true;
            }
            case 11: {
                pSPanelLogicLinkBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSPanelLogicLinkBase.resetPSPanelLogicLinkId();
                return true;
            }
            case 13: {
                pSPanelLogicLinkBase.resetPSPanelLogicLinkName();
                return true;
            }
            case 14: {
                pSPanelLogicLinkBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSPanelLogicLinkBase.resetPSSysViewPanelId();
                return true;
            }
            case 16: {
                pSPanelLogicLinkBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 17: {
                pSPanelLogicLinkBase.resetPSSysViewPanelLogicName();
                return true;
            }
            case 18: {
                pSPanelLogicLinkBase.resetPSSysViewPanelName();
                return true;
            }
            case 19: {
                pSPanelLogicLinkBase.resetSrcEndPoint();
                return true;
            }
            case 20: {
                pSPanelLogicLinkBase.resetSrcPSPanelLogicNodeId();
                return true;
            }
            case 21: {
                pSPanelLogicLinkBase.resetSrcPSPanelLogicNodeName();
                return true;
            }
            case 22: {
                pSPanelLogicLinkBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSPanelLogicLinkBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicNode getDstPSPanelLogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLogicNode();
        }
        if (this.getDstPSPanelLogicNodeId() == null) {
            return null;
        }
        Integer n = this.objDstPSPanelLogicNodeLock;
        synchronized (n) {
            if (this.dstpspanellogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSPanelLogicNodeId(), (Object)this.dstpspanellogicnode.getPSPanelLogicNodeId()) != 0L) {
                this.dstpspanellogicnode = null;
            }
            if (this.dstpspanellogicnode == null) {
                PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
                pSPanelLogicNode.setPSPanelLogicNodeId(this.getDstPSPanelLogicNodeId());
                PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicNodeService.autoGet((IEntity)pSPanelLogicNode);
                this.dstpspanellogicnode = pSPanelLogicNode;
            }
            return this.dstpspanellogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicNode getSrcPSPanelLogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLogicNode();
        }
        if (this.getSrcPSPanelLogicNodeId() == null) {
            return null;
        }
        Integer n = this.objSrcPSPanelLogicNodeLock;
        synchronized (n) {
            if (this.srcpspanellogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSPanelLogicNodeId(), (Object)this.srcpspanellogicnode.getPSPanelLogicNodeId()) != 0L) {
                this.srcpspanellogicnode = null;
            }
            if (this.srcpspanellogicnode == null) {
                PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
                pSPanelLogicNode.setPSPanelLogicNodeId(this.getSrcPSPanelLogicNodeId());
                PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicNodeService.autoGet((IEntity)pSPanelLogicNode);
                this.srcpspanellogicnode = pSPanelLogicNode;
            }
            return this.srcpspanellogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelLogic getPSSysViewPanelLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelLogic();
        }
        if (this.getPSSysViewPanelLogicId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLogicLock;
        synchronized (n) {
            if (this.pssysviewpanellogic != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelLogicId(), (Object)this.pssysviewpanellogic.getPSSysViewPanelLogicId()) != 0L) {
                this.pssysviewpanellogic = null;
            }
            if (this.pssysviewpanellogic == null) {
                PSSysViewPanelLogic pSSysViewPanelLogic = new PSSysViewPanelLogic();
                pSSysViewPanelLogic.setPSSysViewPanelLogicId(this.getPSSysViewPanelLogicId());
                PSSysViewPanelLogicService pSSysViewPanelLogicService = (PSSysViewPanelLogicService)ServiceGlobal.getService(PSSysViewPanelLogicService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelLogicService.autoGet((IEntity)pSSysViewPanelLogic);
                this.pssysviewpanellogic = pSSysViewPanelLogic;
            }
            return this.pssysviewpanellogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanel getPSSysViewPanel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanel();
        }
        if (this.getPSSysViewPanelId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelLock;
        synchronized (n) {
            if (this.pssysviewpanel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelId(), (Object)this.pssysviewpanel.getPSSysViewPanelId()) != 0L) {
                this.pssysviewpanel = null;
            }
            if (this.pssysviewpanel == null) {
                PSSysViewPanel pSSysViewPanel = new PSSysViewPanel();
                pSSysViewPanel.setPSSysViewPanelId(this.getPSSysViewPanelId());
                PSSysViewPanelService pSSysViewPanelService = (PSSysViewPanelService)ServiceGlobal.getService(PSSysViewPanelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPanelLLCond> getPSPanelLLConds() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLConds();
        }
        if (this.getPSPanelLogicLinkId() == null) {
            return null;
        }
        PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
        PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPanelLLCondsLock;
        synchronized (n) {
            if (this.pspanelllconds == null) {
                this.pspanelllconds = pSPanelLogicLinkService.isTempData((IEntity)this) ? pSPanelLLCondService.selectTempByPSPanelLogicLink(this) : pSPanelLLCondService.selectByPSPanelLogicLink(this);
            }
            return this.pspanelllconds;
        }
    }

    private PSPanelLogicLinkBase getProxyEntity() {
        return this.proxyPSPanelLogicLinkBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLogicLinkBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLogicLinkBase) {
            this.proxyPSPanelLogicLinkBase = (PSPanelLogicLinkBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CALLBACKNAME, 0);
        fieldIndexMap.put(FIELD_CONDMODEL, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DEFAULTLINK, 4);
        fieldIndexMap.put(FIELD_DSTENDPOINT, 5);
        fieldIndexMap.put(FIELD_DSTPSPANELLOGICNODEID, 6);
        fieldIndexMap.put(FIELD_DSTPSPANELLOGICNODENAME, 7);
        fieldIndexMap.put(FIELD_LINKINFO, 8);
        fieldIndexMap.put(FIELD_LINKTYPE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PSPANELLOGICLINKID, 12);
        fieldIndexMap.put(FIELD_PSPANELLOGICLINKNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 15);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 16);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 18);
        fieldIndexMap.put(FIELD_SRCENDPOINT, 19);
        fieldIndexMap.put(FIELD_SRCPSPANELLOGICNODEID, 20);
        fieldIndexMap.put(FIELD_SRCPSPANELLOGICNODENAME, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

