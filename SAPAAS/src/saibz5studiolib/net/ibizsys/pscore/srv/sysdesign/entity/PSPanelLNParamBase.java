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
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicNode;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicNodeService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLNParamBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLNParamBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String FIELD_DSTPSPANELLPID = "DSTPSPANELLPID";
    public static final String FIELD_DSTPSPANELLPNAME = "DSTPSPANELLPNAME";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PSPANELLNPARAMID = "PSPANELLNPARAMID";
    public static final String FIELD_PSPANELLNPARAMNAME = "PSPANELLNPARAMNAME";
    public static final String FIELD_PSPANELLOGICNODEID = "PSPANELLOGICNODEID";
    public static final String FIELD_PSPANELLOGICNODENAME = "PSPANELLOGICNODENAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_SRCFIELDNAME = "SRCFIELDNAME";
    public static final String FIELD_SRCPSPANELLPID = "SRCPSPANELLPID";
    public static final String FIELD_SRCPSPANELLPNAME = "SRCPSPANELLPNAME";
    public static final String FIELD_SRCVALUE = "SRCVALUE";
    public static final String FIELD_SRCVALUETYPE = "SRCVALUETYPE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSTFIELDNAME = 2;
    private static final int INDEX_DSTPSPANELLPID = 3;
    private static final int INDEX_DSTPSPANELLPNAME = 4;
    private static final int INDEX_ORDERVALUE = 5;
    private static final int INDEX_PARAMTYPE = 6;
    private static final int INDEX_PSPANELLNPARAMID = 7;
    private static final int INDEX_PSPANELLNPARAMNAME = 8;
    private static final int INDEX_PSPANELLOGICNODEID = 9;
    private static final int INDEX_PSPANELLOGICNODENAME = 10;
    private static final int INDEX_PSSYSTEMID = 11;
    private static final int INDEX_PSSYSVIEWPANELID = 12;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 13;
    private static final int INDEX_PSSYSVIEWPANELNAME = 14;
    private static final int INDEX_SRCFIELDNAME = 15;
    private static final int INDEX_SRCPSPANELLPID = 16;
    private static final int INDEX_SRCPSPANELLPNAME = 17;
    private static final int INDEX_SRCVALUE = 18;
    private static final int INDEX_SRCVALUETYPE = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLNParamBase proxyPSPanelLNParamBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstfieldnameDirtyFlag = false;
    private boolean dstpspanellpidDirtyFlag = false;
    private boolean dstpspanellpnameDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean pspanellnparamidDirtyFlag = false;
    private boolean pspanellnparamnameDirtyFlag = false;
    private boolean pspanellogicnodeidDirtyFlag = false;
    private boolean pspanellogicnodenameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean srcfieldnameDirtyFlag = false;
    private boolean srcpspanellpidDirtyFlag = false;
    private boolean srcpspanellpnameDirtyFlag = false;
    private boolean srcvalueDirtyFlag = false;
    private boolean srcvaluetypeDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstfieldname")
    private String dstfieldname;
    @Column(name="dstpspanellpid")
    private String dstpspanellpid;
    @Column(name="dstpspanellpname")
    private String dstpspanellpname;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramtype")
    private String paramtype;
    @Column(name="pspanellnparamid")
    private String pspanellnparamid;
    @Column(name="pspanellnparamname")
    private String pspanellnparamname;
    @Column(name="pspanellogicnodeid")
    private String pspanellogicnodeid;
    @Column(name="pspanellogicnodename")
    private String pspanellogicnodename;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanellogicid")
    private String pssysviewpanellogicid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="srcfieldname")
    private String srcfieldname;
    @Column(name="srcpspanellpid")
    private String srcpspanellpid;
    @Column(name="srcpspanellpname")
    private String srcpspanellpname;
    @Column(name="srcvalue")
    private String srcvalue;
    @Column(name="srcvaluetype")
    private String srcvaluetype;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSPanelLogicNodeLock = new Integer(1);
    private PSPanelLogicNode pspanellogicnode = null;
    private Integer objDstPSPanelLPLock = new Integer(1);
    private PSPanelLogicParam dstpspanellp = null;
    private Integer objSrcPSPanelLPLock = new Integer(1);
    private PSPanelLogicParam srcpspanellp = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

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

    public void setDstFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstfieldname = string;
        this.dstfieldnameDirtyFlag = true;
    }

    public String getDstFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstFieldName();
        }
        return this.dstfieldname;
    }

    public boolean isDstFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstFieldNameDirty();
        }
        return this.dstfieldnameDirtyFlag;
    }

    public void resetDstFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstFieldName();
            return;
        }
        this.dstfieldnameDirtyFlag = false;
        this.dstfieldname = null;
    }

    public void setDstPSPanelLPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelLPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanellpid = string;
        this.dstpspanellpidDirtyFlag = true;
    }

    public String getDstPSPanelLPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLPId();
        }
        return this.dstpspanellpid;
    }

    public boolean isDstPSPanelLPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelLPIdDirty();
        }
        return this.dstpspanellpidDirtyFlag;
    }

    public void resetDstPSPanelLPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelLPId();
            return;
        }
        this.dstpspanellpidDirtyFlag = false;
        this.dstpspanellpid = null;
    }

    public void setDstPSPanelLPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelLPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanellpname = string;
        this.dstpspanellpnameDirtyFlag = true;
    }

    public String getDstPSPanelLPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLPName();
        }
        return this.dstpspanellpname;
    }

    public boolean isDstPSPanelLPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelLPNameDirty();
        }
        return this.dstpspanellpnameDirtyFlag;
    }

    public void resetDstPSPanelLPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelLPName();
            return;
        }
        this.dstpspanellpnameDirtyFlag = false;
        this.dstpspanellpname = null;
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

    public void setPSPanelLNParamId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLNParamId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellnparamid = string;
        this.pspanellnparamidDirtyFlag = true;
    }

    public String getPSPanelLNParamId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNParamId();
        }
        return this.pspanellnparamid;
    }

    public boolean isPSPanelLNParamIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLNParamIdDirty();
        }
        return this.pspanellnparamidDirtyFlag;
    }

    public void resetPSPanelLNParamId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLNParamId();
            return;
        }
        this.pspanellnparamidDirtyFlag = false;
        this.pspanellnparamid = null;
    }

    public void setPSPanelLNParamName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLNParamName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellnparamname = string;
        this.pspanellnparamnameDirtyFlag = true;
    }

    public String getPSPanelLNParamName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLNParamName();
        }
        return this.pspanellnparamname;
    }

    public boolean isPSPanelLNParamNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLNParamNameDirty();
        }
        return this.pspanellnparamnameDirtyFlag;
    }

    public void resetPSPanelLNParamName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLNParamName();
            return;
        }
        this.pspanellnparamnameDirtyFlag = false;
        this.pspanellnparamname = null;
    }

    public void setPSPanelLogicNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicnodeid = string;
        this.pspanellogicnodeidDirtyFlag = true;
    }

    public String getPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodeId();
        }
        return this.pspanellogicnodeid;
    }

    public boolean isPSPanelLogicNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicNodeIdDirty();
        }
        return this.pspanellogicnodeidDirtyFlag;
    }

    public void resetPSPanelLogicNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicNodeId();
            return;
        }
        this.pspanellogicnodeidDirtyFlag = false;
        this.pspanellogicnodeid = null;
    }

    public void setPSPanelLogicNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLogicNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanellogicnodename = string;
        this.pspanellogicnodenameDirtyFlag = true;
    }

    public String getPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNodeName();
        }
        return this.pspanellogicnodename;
    }

    public boolean isPSPanelLogicNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLogicNodeNameDirty();
        }
        return this.pspanellogicnodenameDirtyFlag;
    }

    public void resetPSPanelLogicNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLogicNodeName();
            return;
        }
        this.pspanellogicnodenameDirtyFlag = false;
        this.pspanellogicnodename = null;
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

    public void setSrcFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcfieldname = string;
        this.srcfieldnameDirtyFlag = true;
    }

    public String getSrcFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcFieldName();
        }
        return this.srcfieldname;
    }

    public boolean isSrcFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcFieldNameDirty();
        }
        return this.srcfieldnameDirtyFlag;
    }

    public void resetSrcFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcFieldName();
            return;
        }
        this.srcfieldnameDirtyFlag = false;
        this.srcfieldname = null;
    }

    public void setSrcPSPanelLPId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSPanelLPId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpspanellpid = string;
        this.srcpspanellpidDirtyFlag = true;
    }

    public String getSrcPSPanelLPId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLPId();
        }
        return this.srcpspanellpid;
    }

    public boolean isSrcPSPanelLPIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSPanelLPIdDirty();
        }
        return this.srcpspanellpidDirtyFlag;
    }

    public void resetSrcPSPanelLPId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSPanelLPId();
            return;
        }
        this.srcpspanellpidDirtyFlag = false;
        this.srcpspanellpid = null;
    }

    public void setSrcPSPanelLPName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSrcPSPanelLPName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.srcpspanellpname = string;
        this.srcpspanellpnameDirtyFlag = true;
    }

    public String getSrcPSPanelLPName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLPName();
        }
        return this.srcpspanellpname;
    }

    public boolean isSrcPSPanelLPNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSrcPSPanelLPNameDirty();
        }
        return this.srcpspanellpnameDirtyFlag;
    }

    public void resetSrcPSPanelLPName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSrcPSPanelLPName();
            return;
        }
        this.srcpspanellpnameDirtyFlag = false;
        this.srcpspanellpname = null;
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
        PSPanelLNParamBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLNParamBase pSPanelLNParamBase) {
        pSPanelLNParamBase.resetCreateDate();
        pSPanelLNParamBase.resetCreateMan();
        pSPanelLNParamBase.resetDstFieldName();
        pSPanelLNParamBase.resetDstPSPanelLPId();
        pSPanelLNParamBase.resetDstPSPanelLPName();
        pSPanelLNParamBase.resetOrderValue();
        pSPanelLNParamBase.resetParamType();
        pSPanelLNParamBase.resetPSPanelLNParamId();
        pSPanelLNParamBase.resetPSPanelLNParamName();
        pSPanelLNParamBase.resetPSPanelLogicNodeId();
        pSPanelLNParamBase.resetPSPanelLogicNodeName();
        pSPanelLNParamBase.resetPSSystemId();
        pSPanelLNParamBase.resetPSSysViewPanelId();
        pSPanelLNParamBase.resetPSSysViewPanelLogicId();
        pSPanelLNParamBase.resetPSSysViewPanelName();
        pSPanelLNParamBase.resetSrcFieldName();
        pSPanelLNParamBase.resetSrcPSPanelLPId();
        pSPanelLNParamBase.resetSrcPSPanelLPName();
        pSPanelLNParamBase.resetSrcValue();
        pSPanelLNParamBase.resetSrcValueType();
        pSPanelLNParamBase.resetUpdateDate();
        pSPanelLNParamBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstFieldNameDirty()) {
            hashMap.put(FIELD_DSTFIELDNAME, this.getDstFieldName());
        }
        if (!bl || this.isDstPSPanelLPIdDirty()) {
            hashMap.put(FIELD_DSTPSPANELLPID, this.getDstPSPanelLPId());
        }
        if (!bl || this.isDstPSPanelLPNameDirty()) {
            hashMap.put(FIELD_DSTPSPANELLPNAME, this.getDstPSPanelLPName());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamTypeDirty()) {
            hashMap.put(FIELD_PARAMTYPE, this.getParamType());
        }
        if (!bl || this.isPSPanelLNParamIdDirty()) {
            hashMap.put(FIELD_PSPANELLNPARAMID, this.getPSPanelLNParamId());
        }
        if (!bl || this.isPSPanelLNParamNameDirty()) {
            hashMap.put(FIELD_PSPANELLNPARAMNAME, this.getPSPanelLNParamName());
        }
        if (!bl || this.isPSPanelLogicNodeIdDirty()) {
            hashMap.put(FIELD_PSPANELLOGICNODEID, this.getPSPanelLogicNodeId());
        }
        if (!bl || this.isPSPanelLogicNodeNameDirty()) {
            hashMap.put(FIELD_PSPANELLOGICNODENAME, this.getPSPanelLogicNodeName());
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
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isSrcFieldNameDirty()) {
            hashMap.put(FIELD_SRCFIELDNAME, this.getSrcFieldName());
        }
        if (!bl || this.isSrcPSPanelLPIdDirty()) {
            hashMap.put(FIELD_SRCPSPANELLPID, this.getSrcPSPanelLPId());
        }
        if (!bl || this.isSrcPSPanelLPNameDirty()) {
            hashMap.put(FIELD_SRCPSPANELLPNAME, this.getSrcPSPanelLPName());
        }
        if (!bl || this.isSrcValueDirty()) {
            hashMap.put(FIELD_SRCVALUE, this.getSrcValue());
        }
        if (!bl || this.isSrcValueTypeDirty()) {
            hashMap.put(FIELD_SRCVALUETYPE, this.getSrcValueType());
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
        return PSPanelLNParamBase.get(this, n);
    }

    private static Object get(PSPanelLNParamBase pSPanelLNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNParamBase.getCreateDate();
            }
            case 1: {
                return pSPanelLNParamBase.getCreateMan();
            }
            case 2: {
                return pSPanelLNParamBase.getDstFieldName();
            }
            case 3: {
                return pSPanelLNParamBase.getDstPSPanelLPId();
            }
            case 4: {
                return pSPanelLNParamBase.getDstPSPanelLPName();
            }
            case 5: {
                return pSPanelLNParamBase.getOrderValue();
            }
            case 6: {
                return pSPanelLNParamBase.getParamType();
            }
            case 7: {
                return pSPanelLNParamBase.getPSPanelLNParamId();
            }
            case 8: {
                return pSPanelLNParamBase.getPSPanelLNParamName();
            }
            case 9: {
                return pSPanelLNParamBase.getPSPanelLogicNodeId();
            }
            case 10: {
                return pSPanelLNParamBase.getPSPanelLogicNodeName();
            }
            case 11: {
                return pSPanelLNParamBase.getPSSystemId();
            }
            case 12: {
                return pSPanelLNParamBase.getPSSysViewPanelId();
            }
            case 13: {
                return pSPanelLNParamBase.getPSSysViewPanelLogicId();
            }
            case 14: {
                return pSPanelLNParamBase.getPSSysViewPanelName();
            }
            case 15: {
                return pSPanelLNParamBase.getSrcFieldName();
            }
            case 16: {
                return pSPanelLNParamBase.getSrcPSPanelLPId();
            }
            case 17: {
                return pSPanelLNParamBase.getSrcPSPanelLPName();
            }
            case 18: {
                return pSPanelLNParamBase.getSrcValue();
            }
            case 19: {
                return pSPanelLNParamBase.getSrcValueType();
            }
            case 20: {
                return pSPanelLNParamBase.getUpdateDate();
            }
            case 21: {
                return pSPanelLNParamBase.getUpdateMan();
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
        PSPanelLNParamBase.set(this, n, object);
    }

    private static void set(PSPanelLNParamBase pSPanelLNParamBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLNParamBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLNParamBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLNParamBase.setDstFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLNParamBase.setDstPSPanelLPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLNParamBase.setDstPSPanelLPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLNParamBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLNParamBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLNParamBase.setPSPanelLNParamId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLNParamBase.setPSPanelLNParamName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLNParamBase.setPSPanelLogicNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLNParamBase.setPSPanelLogicNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelLNParamBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPanelLNParamBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelLNParamBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelLNParamBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelLNParamBase.setSrcFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelLNParamBase.setSrcPSPanelLPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelLNParamBase.setSrcPSPanelLPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPanelLNParamBase.setSrcValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPanelLNParamBase.setSrcValueType(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPanelLNParamBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSPanelLNParamBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLNParamBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLNParamBase pSPanelLNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNParamBase.getCreateDate() == null;
            }
            case 1: {
                return pSPanelLNParamBase.getCreateMan() == null;
            }
            case 2: {
                return pSPanelLNParamBase.getDstFieldName() == null;
            }
            case 3: {
                return pSPanelLNParamBase.getDstPSPanelLPId() == null;
            }
            case 4: {
                return pSPanelLNParamBase.getDstPSPanelLPName() == null;
            }
            case 5: {
                return pSPanelLNParamBase.getOrderValue() == null;
            }
            case 6: {
                return pSPanelLNParamBase.getParamType() == null;
            }
            case 7: {
                return pSPanelLNParamBase.getPSPanelLNParamId() == null;
            }
            case 8: {
                return pSPanelLNParamBase.getPSPanelLNParamName() == null;
            }
            case 9: {
                return pSPanelLNParamBase.getPSPanelLogicNodeId() == null;
            }
            case 10: {
                return pSPanelLNParamBase.getPSPanelLogicNodeName() == null;
            }
            case 11: {
                return pSPanelLNParamBase.getPSSystemId() == null;
            }
            case 12: {
                return pSPanelLNParamBase.getPSSysViewPanelId() == null;
            }
            case 13: {
                return pSPanelLNParamBase.getPSSysViewPanelLogicId() == null;
            }
            case 14: {
                return pSPanelLNParamBase.getPSSysViewPanelName() == null;
            }
            case 15: {
                return pSPanelLNParamBase.getSrcFieldName() == null;
            }
            case 16: {
                return pSPanelLNParamBase.getSrcPSPanelLPId() == null;
            }
            case 17: {
                return pSPanelLNParamBase.getSrcPSPanelLPName() == null;
            }
            case 18: {
                return pSPanelLNParamBase.getSrcValue() == null;
            }
            case 19: {
                return pSPanelLNParamBase.getSrcValueType() == null;
            }
            case 20: {
                return pSPanelLNParamBase.getUpdateDate() == null;
            }
            case 21: {
                return pSPanelLNParamBase.getUpdateMan() == null;
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
        return PSPanelLNParamBase.contains(this, n);
    }

    private static boolean contains(PSPanelLNParamBase pSPanelLNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLNParamBase.isCreateDateDirty();
            }
            case 1: {
                return pSPanelLNParamBase.isCreateManDirty();
            }
            case 2: {
                return pSPanelLNParamBase.isDstFieldNameDirty();
            }
            case 3: {
                return pSPanelLNParamBase.isDstPSPanelLPIdDirty();
            }
            case 4: {
                return pSPanelLNParamBase.isDstPSPanelLPNameDirty();
            }
            case 5: {
                return pSPanelLNParamBase.isOrderValueDirty();
            }
            case 6: {
                return pSPanelLNParamBase.isParamTypeDirty();
            }
            case 7: {
                return pSPanelLNParamBase.isPSPanelLNParamIdDirty();
            }
            case 8: {
                return pSPanelLNParamBase.isPSPanelLNParamNameDirty();
            }
            case 9: {
                return pSPanelLNParamBase.isPSPanelLogicNodeIdDirty();
            }
            case 10: {
                return pSPanelLNParamBase.isPSPanelLogicNodeNameDirty();
            }
            case 11: {
                return pSPanelLNParamBase.isPSSystemIdDirty();
            }
            case 12: {
                return pSPanelLNParamBase.isPSSysViewPanelIdDirty();
            }
            case 13: {
                return pSPanelLNParamBase.isPSSysViewPanelLogicIdDirty();
            }
            case 14: {
                return pSPanelLNParamBase.isPSSysViewPanelNameDirty();
            }
            case 15: {
                return pSPanelLNParamBase.isSrcFieldNameDirty();
            }
            case 16: {
                return pSPanelLNParamBase.isSrcPSPanelLPIdDirty();
            }
            case 17: {
                return pSPanelLNParamBase.isSrcPSPanelLPNameDirty();
            }
            case 18: {
                return pSPanelLNParamBase.isSrcValueDirty();
            }
            case 19: {
                return pSPanelLNParamBase.isSrcValueTypeDirty();
            }
            case 20: {
                return pSPanelLNParamBase.isUpdateDateDirty();
            }
            case 21: {
                return pSPanelLNParamBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLNParamBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLNParamBase pSPanelLNParamBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLNParamBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getDstFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstfieldname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getDstFieldName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getDstPSPanelLPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellpid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getDstPSPanelLPId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getDstPSPanelLPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellpname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getDstPSPanelLPName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getParamType()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLNParamId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellnparamid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSPanelLNParamId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLNParamName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellnparamname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSPanelLNParamName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLogicNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicnodeid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSPanelLogicNodeId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLogicNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogicnodename", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSPanelLogicNodeName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getSrcFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcfieldname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getSrcFieldName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getSrcPSPanelLPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpspanellpid", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getSrcPSPanelLPId()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getSrcPSPanelLPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcpspanellpname", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getSrcPSPanelLPName()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getSrcValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvalue", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getSrcValue()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getSrcValueType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"srcvaluetype", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getSrcValueType()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLNParamBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLNParamBase.getJSONValue((Object)pSPanelLNParamBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLNParamBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLNParamBase pSPanelLNParamBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLNParamBase.getCreateDate() != null) {
            object = pSPanelLNParamBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLNParamBase.getCreateMan() != null) {
            object = pSPanelLNParamBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getDstFieldName() != null) {
            object = pSPanelLNParamBase.getDstFieldName();
            xmlNode.setAttribute(FIELD_DSTFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getDstPSPanelLPId() != null) {
            object = pSPanelLNParamBase.getDstPSPanelLPId();
            xmlNode.setAttribute(FIELD_DSTPSPANELLPID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getDstPSPanelLPName() != null) {
            object = pSPanelLNParamBase.getDstPSPanelLPName();
            xmlNode.setAttribute(FIELD_DSTPSPANELLPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getOrderValue() != null) {
            object = pSPanelLNParamBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLNParamBase.getParamType() != null) {
            object = pSPanelLNParamBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLNParamId() != null) {
            object = pSPanelLNParamBase.getPSPanelLNParamId();
            xmlNode.setAttribute(FIELD_PSPANELLNPARAMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLNParamName() != null) {
            object = pSPanelLNParamBase.getPSPanelLNParamName();
            xmlNode.setAttribute(FIELD_PSPANELLNPARAMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLogicNodeId() != null) {
            object = pSPanelLNParamBase.getPSPanelLogicNodeId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSPanelLogicNodeName() != null) {
            object = pSPanelLNParamBase.getPSPanelLogicNodeName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSSystemId() != null) {
            object = pSPanelLNParamBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelId() != null) {
            object = pSPanelLNParamBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelLogicId() != null) {
            object = pSPanelLNParamBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getPSSysViewPanelName() != null) {
            object = pSPanelLNParamBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getSrcFieldName() != null) {
            object = pSPanelLNParamBase.getSrcFieldName();
            xmlNode.setAttribute(FIELD_SRCFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getSrcPSPanelLPId() != null) {
            object = pSPanelLNParamBase.getSrcPSPanelLPId();
            xmlNode.setAttribute(FIELD_SRCPSPANELLPID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getSrcPSPanelLPName() != null) {
            object = pSPanelLNParamBase.getSrcPSPanelLPName();
            xmlNode.setAttribute(FIELD_SRCPSPANELLPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getSrcValue() != null) {
            object = pSPanelLNParamBase.getSrcValue();
            xmlNode.setAttribute(FIELD_SRCVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getSrcValueType() != null) {
            object = pSPanelLNParamBase.getSrcValueType();
            xmlNode.setAttribute(FIELD_SRCVALUETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLNParamBase.getUpdateDate() != null) {
            object = pSPanelLNParamBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLNParamBase.getUpdateMan() != null) {
            object = pSPanelLNParamBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLNParamBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLNParamBase pSPanelLNParamBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLNParamBase.isCreateDateDirty() && (bl || pSPanelLNParamBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLNParamBase.getCreateDate());
        }
        if (pSPanelLNParamBase.isCreateManDirty() && (bl || pSPanelLNParamBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLNParamBase.getCreateMan());
        }
        if (pSPanelLNParamBase.isDstFieldNameDirty() && (bl || pSPanelLNParamBase.getDstFieldName() != null)) {
            iDataObject.set(FIELD_DSTFIELDNAME, (Object)pSPanelLNParamBase.getDstFieldName());
        }
        if (pSPanelLNParamBase.isDstPSPanelLPIdDirty() && (bl || pSPanelLNParamBase.getDstPSPanelLPId() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLPID, (Object)pSPanelLNParamBase.getDstPSPanelLPId());
        }
        if (pSPanelLNParamBase.isDstPSPanelLPNameDirty() && (bl || pSPanelLNParamBase.getDstPSPanelLPName() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLPNAME, (Object)pSPanelLNParamBase.getDstPSPanelLPName());
        }
        if (pSPanelLNParamBase.isOrderValueDirty() && (bl || pSPanelLNParamBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelLNParamBase.getOrderValue());
        }
        if (pSPanelLNParamBase.isParamTypeDirty() && (bl || pSPanelLNParamBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSPanelLNParamBase.getParamType());
        }
        if (pSPanelLNParamBase.isPSPanelLNParamIdDirty() && (bl || pSPanelLNParamBase.getPSPanelLNParamId() != null)) {
            iDataObject.set(FIELD_PSPANELLNPARAMID, (Object)pSPanelLNParamBase.getPSPanelLNParamId());
        }
        if (pSPanelLNParamBase.isPSPanelLNParamNameDirty() && (bl || pSPanelLNParamBase.getPSPanelLNParamName() != null)) {
            iDataObject.set(FIELD_PSPANELLNPARAMNAME, (Object)pSPanelLNParamBase.getPSPanelLNParamName());
        }
        if (pSPanelLNParamBase.isPSPanelLogicNodeIdDirty() && (bl || pSPanelLNParamBase.getPSPanelLogicNodeId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICNODEID, (Object)pSPanelLNParamBase.getPSPanelLogicNodeId());
        }
        if (pSPanelLNParamBase.isPSPanelLogicNodeNameDirty() && (bl || pSPanelLNParamBase.getPSPanelLogicNodeName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICNODENAME, (Object)pSPanelLNParamBase.getPSPanelLogicNodeName());
        }
        if (pSPanelLNParamBase.isPSSystemIdDirty() && (bl || pSPanelLNParamBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSPanelLNParamBase.getPSSystemId());
        }
        if (pSPanelLNParamBase.isPSSysViewPanelIdDirty() && (bl || pSPanelLNParamBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelLNParamBase.getPSSysViewPanelId());
        }
        if (pSPanelLNParamBase.isPSSysViewPanelLogicIdDirty() && (bl || pSPanelLNParamBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSPanelLNParamBase.getPSSysViewPanelLogicId());
        }
        if (pSPanelLNParamBase.isPSSysViewPanelNameDirty() && (bl || pSPanelLNParamBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelLNParamBase.getPSSysViewPanelName());
        }
        if (pSPanelLNParamBase.isSrcFieldNameDirty() && (bl || pSPanelLNParamBase.getSrcFieldName() != null)) {
            iDataObject.set(FIELD_SRCFIELDNAME, (Object)pSPanelLNParamBase.getSrcFieldName());
        }
        if (pSPanelLNParamBase.isSrcPSPanelLPIdDirty() && (bl || pSPanelLNParamBase.getSrcPSPanelLPId() != null)) {
            iDataObject.set(FIELD_SRCPSPANELLPID, (Object)pSPanelLNParamBase.getSrcPSPanelLPId());
        }
        if (pSPanelLNParamBase.isSrcPSPanelLPNameDirty() && (bl || pSPanelLNParamBase.getSrcPSPanelLPName() != null)) {
            iDataObject.set(FIELD_SRCPSPANELLPNAME, (Object)pSPanelLNParamBase.getSrcPSPanelLPName());
        }
        if (pSPanelLNParamBase.isSrcValueDirty() && (bl || pSPanelLNParamBase.getSrcValue() != null)) {
            iDataObject.set(FIELD_SRCVALUE, (Object)pSPanelLNParamBase.getSrcValue());
        }
        if (pSPanelLNParamBase.isSrcValueTypeDirty() && (bl || pSPanelLNParamBase.getSrcValueType() != null)) {
            iDataObject.set(FIELD_SRCVALUETYPE, (Object)pSPanelLNParamBase.getSrcValueType());
        }
        if (pSPanelLNParamBase.isUpdateDateDirty() && (bl || pSPanelLNParamBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLNParamBase.getUpdateDate());
        }
        if (pSPanelLNParamBase.isUpdateManDirty() && (bl || pSPanelLNParamBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLNParamBase.getUpdateMan());
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
        return PSPanelLNParamBase.remove(this, n);
    }

    private static boolean remove(PSPanelLNParamBase pSPanelLNParamBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLNParamBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSPanelLNParamBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSPanelLNParamBase.resetDstFieldName();
                return true;
            }
            case 3: {
                pSPanelLNParamBase.resetDstPSPanelLPId();
                return true;
            }
            case 4: {
                pSPanelLNParamBase.resetDstPSPanelLPName();
                return true;
            }
            case 5: {
                pSPanelLNParamBase.resetOrderValue();
                return true;
            }
            case 6: {
                pSPanelLNParamBase.resetParamType();
                return true;
            }
            case 7: {
                pSPanelLNParamBase.resetPSPanelLNParamId();
                return true;
            }
            case 8: {
                pSPanelLNParamBase.resetPSPanelLNParamName();
                return true;
            }
            case 9: {
                pSPanelLNParamBase.resetPSPanelLogicNodeId();
                return true;
            }
            case 10: {
                pSPanelLNParamBase.resetPSPanelLogicNodeName();
                return true;
            }
            case 11: {
                pSPanelLNParamBase.resetPSSystemId();
                return true;
            }
            case 12: {
                pSPanelLNParamBase.resetPSSysViewPanelId();
                return true;
            }
            case 13: {
                pSPanelLNParamBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 14: {
                pSPanelLNParamBase.resetPSSysViewPanelName();
                return true;
            }
            case 15: {
                pSPanelLNParamBase.resetSrcFieldName();
                return true;
            }
            case 16: {
                pSPanelLNParamBase.resetSrcPSPanelLPId();
                return true;
            }
            case 17: {
                pSPanelLNParamBase.resetSrcPSPanelLPName();
                return true;
            }
            case 18: {
                pSPanelLNParamBase.resetSrcValue();
                return true;
            }
            case 19: {
                pSPanelLNParamBase.resetSrcValueType();
                return true;
            }
            case 20: {
                pSPanelLNParamBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSPanelLNParamBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicNode getPSPanelLogicNode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicNode();
        }
        if (this.getPSPanelLogicNodeId() == null) {
            return null;
        }
        Integer n = this.objPSPanelLogicNodeLock;
        synchronized (n) {
            if (this.pspanellogicnode != null && DataTypeHelper.compare((int)25, (Object)this.getPSPanelLogicNodeId(), (Object)this.pspanellogicnode.getPSPanelLogicNodeId()) != 0L) {
                this.pspanellogicnode = null;
            }
            if (this.pspanellogicnode == null) {
                PSPanelLogicNode pSPanelLogicNode = new PSPanelLogicNode();
                pSPanelLogicNode.setPSPanelLogicNodeId(this.getPSPanelLogicNodeId());
                PSPanelLogicNodeService pSPanelLogicNodeService = (PSPanelLogicNodeService)ServiceGlobal.getService(PSPanelLogicNodeService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicNodeService.autoGet(pSPanelLogicNode);
                this.pspanellogicnode = pSPanelLogicNode;
            }
            return this.pspanellogicnode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicParam getDstPSPanelLP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelLP();
        }
        if (this.getDstPSPanelLPId() == null) {
            return null;
        }
        Integer n = this.objDstPSPanelLPLock;
        synchronized (n) {
            if (this.dstpspanellp != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSPanelLPId(), (Object)this.dstpspanellp.getPSPanelLogicParamId()) != 0L) {
                this.dstpspanellp = null;
            }
            if (this.dstpspanellp == null) {
                PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
                pSPanelLogicParam.setPSPanelLogicParamId(this.getDstPSPanelLPId());
                PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicParamService.autoGet(pSPanelLogicParam);
                this.dstpspanellp = pSPanelLogicParam;
            }
            return this.dstpspanellp;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicParam getSrcPSPanelLP() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSrcPSPanelLP();
        }
        if (this.getSrcPSPanelLPId() == null) {
            return null;
        }
        Integer n = this.objSrcPSPanelLPLock;
        synchronized (n) {
            if (this.srcpspanellp != null && DataTypeHelper.compare((int)25, (Object)this.getSrcPSPanelLPId(), (Object)this.srcpspanellp.getPSPanelLogicParamId()) != 0L) {
                this.srcpspanellp = null;
            }
            if (this.srcpspanellp == null) {
                PSPanelLogicParam pSPanelLogicParam = new PSPanelLogicParam();
                pSPanelLogicParam.setPSPanelLogicParamId(this.getSrcPSPanelLPId());
                PSPanelLogicParamService pSPanelLogicParamService = (PSPanelLogicParamService)ServiceGlobal.getService(PSPanelLogicParamService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicParamService.autoGet(pSPanelLogicParam);
                this.srcpspanellp = pSPanelLogicParam;
            }
            return this.srcpspanellp;
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
                pSSysViewPanelService.autoGet(pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    private PSPanelLNParamBase getProxyEntity() {
        return this.proxyPSPanelLNParamBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLNParamBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLNParamBase) {
            this.proxyPSPanelLNParamBase = (PSPanelLNParamBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLNParamService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTFIELDNAME, 2);
        fieldIndexMap.put(FIELD_DSTPSPANELLPID, 3);
        fieldIndexMap.put(FIELD_DSTPSPANELLPNAME, 4);
        fieldIndexMap.put(FIELD_ORDERVALUE, 5);
        fieldIndexMap.put(FIELD_PARAMTYPE, 6);
        fieldIndexMap.put(FIELD_PSPANELLNPARAMID, 7);
        fieldIndexMap.put(FIELD_PSPANELLNPARAMNAME, 8);
        fieldIndexMap.put(FIELD_PSPANELLOGICNODEID, 9);
        fieldIndexMap.put(FIELD_PSPANELLOGICNODENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 11);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 12);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 13);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 14);
        fieldIndexMap.put(FIELD_SRCFIELDNAME, 15);
        fieldIndexMap.put(FIELD_SRCPSPANELLPID, 16);
        fieldIndexMap.put(FIELD_SRCPSPANELLPNAME, 17);
        fieldIndexMap.put(FIELD_SRCVALUE, 18);
        fieldIndexMap.put(FIELD_SRCVALUETYPE, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
    }
}

