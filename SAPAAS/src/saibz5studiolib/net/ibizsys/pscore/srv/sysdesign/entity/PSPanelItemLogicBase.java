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
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelItemLogic;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanelModel;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelItemLogicBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelItemLogicBase.class);
    public static final String FIELD_CONDOP = "CONDOP";
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String FIELD_DSTPSPANELMODELID = "DSTPSPANELMODELID";
    public static final String FIELD_DSTPSPANELMODELNAME = "DSTPSPANELMODELNAME";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_LOGICCAT = "LOGICCAT";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSPANELITEMLOGICID = "PPSPANELITEMLOGICID";
    public static final String FIELD_PPSPANELITEMLOGICNAME = "PPSPANELITEMLOGICNAME";
    public static final String FIELD_PSPANELITEMLOGICID = "PSPANELITEMLOGICID";
    public static final String FIELD_PSPANELITEMLOGICNAME = "PSPANELITEMLOGICNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELITEMID = "PSSYSVIEWPANELITEMID";
    public static final String FIELD_PSSYSVIEWPANELITEMNAME = "PSSYSVIEWPANELITEMNAME";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDOP = 0;
    private static final int INDEX_CONDVALUE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_CUSTOMCODE = 4;
    private static final int INDEX_DSTFIELDNAME = 5;
    private static final int INDEX_DSTPSPANELMODELID = 6;
    private static final int INDEX_DSTPSPANELMODELNAME = 7;
    private static final int INDEX_GROUPNOTFLAG = 8;
    private static final int INDEX_GROUPOP = 9;
    private static final int INDEX_LOGICCAT = 10;
    private static final int INDEX_LOGICTYPE = 11;
    private static final int INDEX_ORDERVALUE = 12;
    private static final int INDEX_PPSPANELITEMLOGICID = 13;
    private static final int INDEX_PPSPANELITEMLOGICNAME = 14;
    private static final int INDEX_PSPANELITEMLOGICID = 15;
    private static final int INDEX_PSPANELITEMLOGICNAME = 16;
    private static final int INDEX_PSSYSVIEWPANELID = 17;
    private static final int INDEX_PSSYSVIEWPANELITEMID = 18;
    private static final int INDEX_PSSYSVIEWPANELITEMNAME = 19;
    private static final int INDEX_PSSYSVIEWPANELNAME = 20;
    private static final int INDEX_UPDATEDATE = 21;
    private static final int INDEX_UPDATEMAN = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelItemLogicBase proxyPSPanelItemLogicBase = null;
    private boolean condopDirtyFlag = false;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean dstfieldnameDirtyFlag = false;
    private boolean dstpspanelmodelidDirtyFlag = false;
    private boolean dstpspanelmodelnameDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean logiccatDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppspanelitemlogicidDirtyFlag = false;
    private boolean ppspanelitemlogicnameDirtyFlag = false;
    private boolean pspanelitemlogicidDirtyFlag = false;
    private boolean pspanelitemlogicnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelitemidDirtyFlag = false;
    private boolean pssysviewpanelitemnameDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="condop")
    private String condop;
    @Column(name="condvalue")
    private String condvalue;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="dstfieldname")
    private String dstfieldname;
    @Column(name="dstpspanelmodelid")
    private String dstpspanelmodelid;
    @Column(name="dstpspanelmodelname")
    private String dstpspanelmodelname;
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
    @Column(name="ppspanelitemlogicid")
    private String ppspanelitemlogicid;
    @Column(name="ppspanelitemlogicname")
    private String ppspanelitemlogicname;
    @Column(name="pspanelitemlogicid")
    private String pspanelitemlogicid;
    @Column(name="pspanelitemlogicname")
    private String pspanelitemlogicname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelitemid")
    private String pssysviewpanelitemid;
    @Column(name="pssysviewpanelitemname")
    private String pssysviewpanelitemname;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSPanelItemLogicLock = new Integer(1);
    private PSPanelItemLogic ppspanelitemlogic = null;
    private Integer objPSSysViewPanelItemLock = new Integer(1);
    private PSSysViewPanelItem pssysviewpanelitem = null;
    private Integer objDstPSPanelModelLock = new Integer(1);
    private PSSysViewPanelModel dstpspanelmodel = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;

    public void setCondOp(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCondOp(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.condop = string;
        this.condopDirtyFlag = true;
    }

    public String getCondOp() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCondOp();
        }
        return this.condop;
    }

    public boolean isCondOpDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCondOpDirty();
        }
        return this.condopDirtyFlag;
    }

    public void resetCondOp() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCondOp();
            return;
        }
        this.condopDirtyFlag = false;
        this.condop = null;
    }

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

    public void setDstPSPanelModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanelmodelid = string;
        this.dstpspanelmodelidDirtyFlag = true;
    }

    public String getDstPSPanelModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelModelId();
        }
        return this.dstpspanelmodelid;
    }

    public boolean isDstPSPanelModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelModelIdDirty();
        }
        return this.dstpspanelmodelidDirtyFlag;
    }

    public void resetDstPSPanelModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelModelId();
            return;
        }
        this.dstpspanelmodelidDirtyFlag = false;
        this.dstpspanelmodelid = null;
    }

    public void setDstPSPanelModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSPanelModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpspanelmodelname = string;
        this.dstpspanelmodelnameDirtyFlag = true;
    }

    public String getDstPSPanelModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelModelName();
        }
        return this.dstpspanelmodelname;
    }

    public boolean isDstPSPanelModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSPanelModelNameDirty();
        }
        return this.dstpspanelmodelnameDirtyFlag;
    }

    public void resetDstPSPanelModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSPanelModelName();
            return;
        }
        this.dstpspanelmodelnameDirtyFlag = false;
        this.dstpspanelmodelname = null;
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

    public void setPPSPanelItemLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPanelItemLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspanelitemlogicid = string;
        this.ppspanelitemlogicidDirtyFlag = true;
    }

    public String getPPSPanelItemLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelItemLogicId();
        }
        return this.ppspanelitemlogicid;
    }

    public boolean isPPSPanelItemLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPanelItemLogicIdDirty();
        }
        return this.ppspanelitemlogicidDirtyFlag;
    }

    public void resetPPSPanelItemLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPanelItemLogicId();
            return;
        }
        this.ppspanelitemlogicidDirtyFlag = false;
        this.ppspanelitemlogicid = null;
    }

    public void setPPSPanelItemLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPanelItemLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspanelitemlogicname = string;
        this.ppspanelitemlogicnameDirtyFlag = true;
    }

    public String getPPSPanelItemLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelItemLogicName();
        }
        return this.ppspanelitemlogicname;
    }

    public boolean isPPSPanelItemLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPanelItemLogicNameDirty();
        }
        return this.ppspanelitemlogicnameDirtyFlag;
    }

    public void resetPPSPanelItemLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPanelItemLogicName();
            return;
        }
        this.ppspanelitemlogicnameDirtyFlag = false;
        this.ppspanelitemlogicname = null;
    }

    public void setPSPanelItemLogicId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelItemLogicId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelitemlogicid = string;
        this.pspanelitemlogicidDirtyFlag = true;
    }

    public String getPSPanelItemLogicId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemLogicId();
        }
        return this.pspanelitemlogicid;
    }

    public boolean isPSPanelItemLogicIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelItemLogicIdDirty();
        }
        return this.pspanelitemlogicidDirtyFlag;
    }

    public void resetPSPanelItemLogicId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelItemLogicId();
            return;
        }
        this.pspanelitemlogicidDirtyFlag = false;
        this.pspanelitemlogicid = null;
    }

    public void setPSPanelItemLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelItemLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelitemlogicname = string;
        this.pspanelitemlogicnameDirtyFlag = true;
    }

    public String getPSPanelItemLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelItemLogicName();
        }
        return this.pspanelitemlogicname;
    }

    public boolean isPSPanelItemLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelItemLogicNameDirty();
        }
        return this.pspanelitemlogicnameDirtyFlag;
    }

    public void resetPSPanelItemLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelItemLogicName();
            return;
        }
        this.pspanelitemlogicnameDirtyFlag = false;
        this.pspanelitemlogicname = null;
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

    public void setPSSysViewPanelItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemid = string;
        this.pssysviewpanelitemidDirtyFlag = true;
    }

    public String getPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemId();
        }
        return this.pssysviewpanelitemid;
    }

    public boolean isPSSysViewPanelItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemIdDirty();
        }
        return this.pssysviewpanelitemidDirtyFlag;
    }

    public void resetPSSysViewPanelItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemId();
            return;
        }
        this.pssysviewpanelitemidDirtyFlag = false;
        this.pssysviewpanelitemid = null;
    }

    public void setPSSysViewPanelItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysViewPanelItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysviewpanelitemname = string;
        this.pssysviewpanelitemnameDirtyFlag = true;
    }

    public String getPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItemName();
        }
        return this.pssysviewpanelitemname;
    }

    public boolean isPSSysViewPanelItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysViewPanelItemNameDirty();
        }
        return this.pssysviewpanelitemnameDirtyFlag;
    }

    public void resetPSSysViewPanelItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysViewPanelItemName();
            return;
        }
        this.pssysviewpanelitemnameDirtyFlag = false;
        this.pssysviewpanelitemname = null;
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
        PSPanelItemLogicBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelItemLogicBase pSPanelItemLogicBase) {
        pSPanelItemLogicBase.resetCondOp();
        pSPanelItemLogicBase.resetCondValue();
        pSPanelItemLogicBase.resetCreateDate();
        pSPanelItemLogicBase.resetCreateMan();
        pSPanelItemLogicBase.resetCustomCode();
        pSPanelItemLogicBase.resetDstFieldName();
        pSPanelItemLogicBase.resetDstPSPanelModelId();
        pSPanelItemLogicBase.resetDstPSPanelModelName();
        pSPanelItemLogicBase.resetGroupNotFlag();
        pSPanelItemLogicBase.resetGroupOP();
        pSPanelItemLogicBase.resetLogicCat();
        pSPanelItemLogicBase.resetLogicType();
        pSPanelItemLogicBase.resetOrderValue();
        pSPanelItemLogicBase.resetPPSPanelItemLogicId();
        pSPanelItemLogicBase.resetPPSPanelItemLogicName();
        pSPanelItemLogicBase.resetPSPanelItemLogicId();
        pSPanelItemLogicBase.resetPSPanelItemLogicName();
        pSPanelItemLogicBase.resetPSSysViewPanelId();
        pSPanelItemLogicBase.resetPSSysViewPanelItemId();
        pSPanelItemLogicBase.resetPSSysViewPanelItemName();
        pSPanelItemLogicBase.resetPSSysViewPanelName();
        pSPanelItemLogicBase.resetUpdateDate();
        pSPanelItemLogicBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCondOpDirty()) {
            hashMap.put(FIELD_CONDOP, this.getCondOp());
        }
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
        if (!bl || this.isDstFieldNameDirty()) {
            hashMap.put(FIELD_DSTFIELDNAME, this.getDstFieldName());
        }
        if (!bl || this.isDstPSPanelModelIdDirty()) {
            hashMap.put(FIELD_DSTPSPANELMODELID, this.getDstPSPanelModelId());
        }
        if (!bl || this.isDstPSPanelModelNameDirty()) {
            hashMap.put(FIELD_DSTPSPANELMODELNAME, this.getDstPSPanelModelName());
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
        if (!bl || this.isPPSPanelItemLogicIdDirty()) {
            hashMap.put(FIELD_PPSPANELITEMLOGICID, this.getPPSPanelItemLogicId());
        }
        if (!bl || this.isPPSPanelItemLogicNameDirty()) {
            hashMap.put(FIELD_PPSPANELITEMLOGICNAME, this.getPPSPanelItemLogicName());
        }
        if (!bl || this.isPSPanelItemLogicIdDirty()) {
            hashMap.put(FIELD_PSPANELITEMLOGICID, this.getPSPanelItemLogicId());
        }
        if (!bl || this.isPSPanelItemLogicNameDirty()) {
            hashMap.put(FIELD_PSPANELITEMLOGICNAME, this.getPSPanelItemLogicName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelItemIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMID, this.getPSSysViewPanelItemId());
        }
        if (!bl || this.isPSSysViewPanelItemNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELITEMNAME, this.getPSSysViewPanelItemName());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
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
        return PSPanelItemLogicBase.get(this, n);
    }

    private static Object get(PSPanelItemLogicBase pSPanelItemLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelItemLogicBase.getCondOp();
            }
            case 1: {
                return pSPanelItemLogicBase.getCondValue();
            }
            case 2: {
                return pSPanelItemLogicBase.getCreateDate();
            }
            case 3: {
                return pSPanelItemLogicBase.getCreateMan();
            }
            case 4: {
                return pSPanelItemLogicBase.getCustomCode();
            }
            case 5: {
                return pSPanelItemLogicBase.getDstFieldName();
            }
            case 6: {
                return pSPanelItemLogicBase.getDstPSPanelModelId();
            }
            case 7: {
                return pSPanelItemLogicBase.getDstPSPanelModelName();
            }
            case 8: {
                return pSPanelItemLogicBase.getGroupNotFlag();
            }
            case 9: {
                return pSPanelItemLogicBase.getGroupOP();
            }
            case 10: {
                return pSPanelItemLogicBase.getLogicCat();
            }
            case 11: {
                return pSPanelItemLogicBase.getLogicType();
            }
            case 12: {
                return pSPanelItemLogicBase.getOrderValue();
            }
            case 13: {
                return pSPanelItemLogicBase.getPPSPanelItemLogicId();
            }
            case 14: {
                return pSPanelItemLogicBase.getPPSPanelItemLogicName();
            }
            case 15: {
                return pSPanelItemLogicBase.getPSPanelItemLogicId();
            }
            case 16: {
                return pSPanelItemLogicBase.getPSPanelItemLogicName();
            }
            case 17: {
                return pSPanelItemLogicBase.getPSSysViewPanelId();
            }
            case 18: {
                return pSPanelItemLogicBase.getPSSysViewPanelItemId();
            }
            case 19: {
                return pSPanelItemLogicBase.getPSSysViewPanelItemName();
            }
            case 20: {
                return pSPanelItemLogicBase.getPSSysViewPanelName();
            }
            case 21: {
                return pSPanelItemLogicBase.getUpdateDate();
            }
            case 22: {
                return pSPanelItemLogicBase.getUpdateMan();
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
        PSPanelItemLogicBase.set(this, n, object);
    }

    private static void set(PSPanelItemLogicBase pSPanelItemLogicBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelItemLogicBase.setCondOp(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPanelItemLogicBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelItemLogicBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPanelItemLogicBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelItemLogicBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelItemLogicBase.setDstFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelItemLogicBase.setDstPSPanelModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelItemLogicBase.setDstPSPanelModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPanelItemLogicBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSPanelItemLogicBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelItemLogicBase.setLogicCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelItemLogicBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPanelItemLogicBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSPanelItemLogicBase.setPPSPanelItemLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelItemLogicBase.setPPSPanelItemLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelItemLogicBase.setPSPanelItemLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelItemLogicBase.setPSPanelItemLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelItemLogicBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPanelItemLogicBase.setPSSysViewPanelItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPanelItemLogicBase.setPSSysViewPanelItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPanelItemLogicBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPanelItemLogicBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 22: {
                pSPanelItemLogicBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelItemLogicBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelItemLogicBase pSPanelItemLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelItemLogicBase.getCondOp() == null;
            }
            case 1: {
                return pSPanelItemLogicBase.getCondValue() == null;
            }
            case 2: {
                return pSPanelItemLogicBase.getCreateDate() == null;
            }
            case 3: {
                return pSPanelItemLogicBase.getCreateMan() == null;
            }
            case 4: {
                return pSPanelItemLogicBase.getCustomCode() == null;
            }
            case 5: {
                return pSPanelItemLogicBase.getDstFieldName() == null;
            }
            case 6: {
                return pSPanelItemLogicBase.getDstPSPanelModelId() == null;
            }
            case 7: {
                return pSPanelItemLogicBase.getDstPSPanelModelName() == null;
            }
            case 8: {
                return pSPanelItemLogicBase.getGroupNotFlag() == null;
            }
            case 9: {
                return pSPanelItemLogicBase.getGroupOP() == null;
            }
            case 10: {
                return pSPanelItemLogicBase.getLogicCat() == null;
            }
            case 11: {
                return pSPanelItemLogicBase.getLogicType() == null;
            }
            case 12: {
                return pSPanelItemLogicBase.getOrderValue() == null;
            }
            case 13: {
                return pSPanelItemLogicBase.getPPSPanelItemLogicId() == null;
            }
            case 14: {
                return pSPanelItemLogicBase.getPPSPanelItemLogicName() == null;
            }
            case 15: {
                return pSPanelItemLogicBase.getPSPanelItemLogicId() == null;
            }
            case 16: {
                return pSPanelItemLogicBase.getPSPanelItemLogicName() == null;
            }
            case 17: {
                return pSPanelItemLogicBase.getPSSysViewPanelId() == null;
            }
            case 18: {
                return pSPanelItemLogicBase.getPSSysViewPanelItemId() == null;
            }
            case 19: {
                return pSPanelItemLogicBase.getPSSysViewPanelItemName() == null;
            }
            case 20: {
                return pSPanelItemLogicBase.getPSSysViewPanelName() == null;
            }
            case 21: {
                return pSPanelItemLogicBase.getUpdateDate() == null;
            }
            case 22: {
                return pSPanelItemLogicBase.getUpdateMan() == null;
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
        return PSPanelItemLogicBase.contains(this, n);
    }

    private static boolean contains(PSPanelItemLogicBase pSPanelItemLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelItemLogicBase.isCondOpDirty();
            }
            case 1: {
                return pSPanelItemLogicBase.isCondValueDirty();
            }
            case 2: {
                return pSPanelItemLogicBase.isCreateDateDirty();
            }
            case 3: {
                return pSPanelItemLogicBase.isCreateManDirty();
            }
            case 4: {
                return pSPanelItemLogicBase.isCustomCodeDirty();
            }
            case 5: {
                return pSPanelItemLogicBase.isDstFieldNameDirty();
            }
            case 6: {
                return pSPanelItemLogicBase.isDstPSPanelModelIdDirty();
            }
            case 7: {
                return pSPanelItemLogicBase.isDstPSPanelModelNameDirty();
            }
            case 8: {
                return pSPanelItemLogicBase.isGroupNotFlagDirty();
            }
            case 9: {
                return pSPanelItemLogicBase.isGroupOPDirty();
            }
            case 10: {
                return pSPanelItemLogicBase.isLogicCatDirty();
            }
            case 11: {
                return pSPanelItemLogicBase.isLogicTypeDirty();
            }
            case 12: {
                return pSPanelItemLogicBase.isOrderValueDirty();
            }
            case 13: {
                return pSPanelItemLogicBase.isPPSPanelItemLogicIdDirty();
            }
            case 14: {
                return pSPanelItemLogicBase.isPPSPanelItemLogicNameDirty();
            }
            case 15: {
                return pSPanelItemLogicBase.isPSPanelItemLogicIdDirty();
            }
            case 16: {
                return pSPanelItemLogicBase.isPSPanelItemLogicNameDirty();
            }
            case 17: {
                return pSPanelItemLogicBase.isPSSysViewPanelIdDirty();
            }
            case 18: {
                return pSPanelItemLogicBase.isPSSysViewPanelItemIdDirty();
            }
            case 19: {
                return pSPanelItemLogicBase.isPSSysViewPanelItemNameDirty();
            }
            case 20: {
                return pSPanelItemLogicBase.isPSSysViewPanelNameDirty();
            }
            case 21: {
                return pSPanelItemLogicBase.isUpdateDateDirty();
            }
            case 22: {
                return pSPanelItemLogicBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelItemLogicBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelItemLogicBase pSPanelItemLogicBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelItemLogicBase.getCondOp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condop", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getCondOp()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getCondValue()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getDstFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstfieldname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getDstFieldName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getDstPSPanelModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanelmodelid", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getDstPSPanelModelId()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getDstPSPanelModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanelmodelname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getDstPSPanelModelName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getLogicCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logiccat", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getLogicCat()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getLogicType()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPPSPanelItemLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspanelitemlogicid", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPPSPanelItemLogicId()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPPSPanelItemLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspanelitemlogicname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPPSPanelItemLogicName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSPanelItemLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelitemlogicid", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSPanelItemLogicId()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSPanelItemLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelitemlogicname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSPanelItemLogicName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemid", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSSysViewPanelItemId()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelitemname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSSysViewPanelItemName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelItemLogicBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelItemLogicBase.getJSONValue((Object)pSPanelItemLogicBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelItemLogicBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelItemLogicBase pSPanelItemLogicBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelItemLogicBase.getCondOp() != null) {
            object = pSPanelItemLogicBase.getCondOp();
            xmlNode.setAttribute(FIELD_CONDOP, (String)(object == null ? "" : object));
        }
        if (bl || pSPanelItemLogicBase.getCondValue() != null) {
            object = pSPanelItemLogicBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getCreateDate() != null) {
            object = pSPanelItemLogicBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelItemLogicBase.getCreateMan() != null) {
            object = pSPanelItemLogicBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getCustomCode() != null) {
            object = pSPanelItemLogicBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getDstFieldName() != null) {
            object = pSPanelItemLogicBase.getDstFieldName();
            xmlNode.setAttribute(FIELD_DSTFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getDstPSPanelModelId() != null) {
            object = pSPanelItemLogicBase.getDstPSPanelModelId();
            xmlNode.setAttribute(FIELD_DSTPSPANELMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getDstPSPanelModelName() != null) {
            object = pSPanelItemLogicBase.getDstPSPanelModelName();
            xmlNode.setAttribute(FIELD_DSTPSPANELMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getGroupNotFlag() != null) {
            object = pSPanelItemLogicBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelItemLogicBase.getGroupOP() != null) {
            object = pSPanelItemLogicBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getLogicCat() != null) {
            object = pSPanelItemLogicBase.getLogicCat();
            xmlNode.setAttribute(FIELD_LOGICCAT, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getLogicType() != null) {
            object = pSPanelItemLogicBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getOrderValue() != null) {
            object = pSPanelItemLogicBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelItemLogicBase.getPPSPanelItemLogicId() != null) {
            object = pSPanelItemLogicBase.getPPSPanelItemLogicId();
            xmlNode.setAttribute(FIELD_PPSPANELITEMLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPPSPanelItemLogicName() != null) {
            object = pSPanelItemLogicBase.getPPSPanelItemLogicName();
            xmlNode.setAttribute(FIELD_PPSPANELITEMLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSPanelItemLogicId() != null) {
            object = pSPanelItemLogicBase.getPSPanelItemLogicId();
            xmlNode.setAttribute(FIELD_PSPANELITEMLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSPanelItemLogicName() != null) {
            object = pSPanelItemLogicBase.getPSPanelItemLogicName();
            xmlNode.setAttribute(FIELD_PSPANELITEMLOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelId() != null) {
            object = pSPanelItemLogicBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelItemId() != null) {
            object = pSPanelItemLogicBase.getPSSysViewPanelItemId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelItemName() != null) {
            object = pSPanelItemLogicBase.getPSSysViewPanelItemName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getPSSysViewPanelName() != null) {
            object = pSPanelItemLogicBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelItemLogicBase.getUpdateDate() != null) {
            object = pSPanelItemLogicBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelItemLogicBase.getUpdateMan() != null) {
            object = pSPanelItemLogicBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelItemLogicBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelItemLogicBase pSPanelItemLogicBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelItemLogicBase.isCondOpDirty() && (bl || pSPanelItemLogicBase.getCondOp() != null)) {
            iDataObject.set(FIELD_CONDOP, (Object)pSPanelItemLogicBase.getCondOp());
        }
        if (pSPanelItemLogicBase.isCondValueDirty() && (bl || pSPanelItemLogicBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSPanelItemLogicBase.getCondValue());
        }
        if (pSPanelItemLogicBase.isCreateDateDirty() && (bl || pSPanelItemLogicBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelItemLogicBase.getCreateDate());
        }
        if (pSPanelItemLogicBase.isCreateManDirty() && (bl || pSPanelItemLogicBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelItemLogicBase.getCreateMan());
        }
        if (pSPanelItemLogicBase.isCustomCodeDirty() && (bl || pSPanelItemLogicBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSPanelItemLogicBase.getCustomCode());
        }
        if (pSPanelItemLogicBase.isDstFieldNameDirty() && (bl || pSPanelItemLogicBase.getDstFieldName() != null)) {
            iDataObject.set(FIELD_DSTFIELDNAME, (Object)pSPanelItemLogicBase.getDstFieldName());
        }
        if (pSPanelItemLogicBase.isDstPSPanelModelIdDirty() && (bl || pSPanelItemLogicBase.getDstPSPanelModelId() != null)) {
            iDataObject.set(FIELD_DSTPSPANELMODELID, (Object)pSPanelItemLogicBase.getDstPSPanelModelId());
        }
        if (pSPanelItemLogicBase.isDstPSPanelModelNameDirty() && (bl || pSPanelItemLogicBase.getDstPSPanelModelName() != null)) {
            iDataObject.set(FIELD_DSTPSPANELMODELNAME, (Object)pSPanelItemLogicBase.getDstPSPanelModelName());
        }
        if (pSPanelItemLogicBase.isGroupNotFlagDirty() && (bl || pSPanelItemLogicBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSPanelItemLogicBase.getGroupNotFlag());
        }
        if (pSPanelItemLogicBase.isGroupOPDirty() && (bl || pSPanelItemLogicBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSPanelItemLogicBase.getGroupOP());
        }
        if (pSPanelItemLogicBase.isLogicCatDirty() && (bl || pSPanelItemLogicBase.getLogicCat() != null)) {
            iDataObject.set(FIELD_LOGICCAT, (Object)pSPanelItemLogicBase.getLogicCat());
        }
        if (pSPanelItemLogicBase.isLogicTypeDirty() && (bl || pSPanelItemLogicBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSPanelItemLogicBase.getLogicType());
        }
        if (pSPanelItemLogicBase.isOrderValueDirty() && (bl || pSPanelItemLogicBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelItemLogicBase.getOrderValue());
        }
        if (pSPanelItemLogicBase.isPPSPanelItemLogicIdDirty() && (bl || pSPanelItemLogicBase.getPPSPanelItemLogicId() != null)) {
            iDataObject.set(FIELD_PPSPANELITEMLOGICID, (Object)pSPanelItemLogicBase.getPPSPanelItemLogicId());
        }
        if (pSPanelItemLogicBase.isPPSPanelItemLogicNameDirty() && (bl || pSPanelItemLogicBase.getPPSPanelItemLogicName() != null)) {
            iDataObject.set(FIELD_PPSPANELITEMLOGICNAME, (Object)pSPanelItemLogicBase.getPPSPanelItemLogicName());
        }
        if (pSPanelItemLogicBase.isPSPanelItemLogicIdDirty() && (bl || pSPanelItemLogicBase.getPSPanelItemLogicId() != null)) {
            iDataObject.set(FIELD_PSPANELITEMLOGICID, (Object)pSPanelItemLogicBase.getPSPanelItemLogicId());
        }
        if (pSPanelItemLogicBase.isPSPanelItemLogicNameDirty() && (bl || pSPanelItemLogicBase.getPSPanelItemLogicName() != null)) {
            iDataObject.set(FIELD_PSPANELITEMLOGICNAME, (Object)pSPanelItemLogicBase.getPSPanelItemLogicName());
        }
        if (pSPanelItemLogicBase.isPSSysViewPanelIdDirty() && (bl || pSPanelItemLogicBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelItemLogicBase.getPSSysViewPanelId());
        }
        if (pSPanelItemLogicBase.isPSSysViewPanelItemIdDirty() && (bl || pSPanelItemLogicBase.getPSSysViewPanelItemId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMID, (Object)pSPanelItemLogicBase.getPSSysViewPanelItemId());
        }
        if (pSPanelItemLogicBase.isPSSysViewPanelItemNameDirty() && (bl || pSPanelItemLogicBase.getPSSysViewPanelItemName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELITEMNAME, (Object)pSPanelItemLogicBase.getPSSysViewPanelItemName());
        }
        if (pSPanelItemLogicBase.isPSSysViewPanelNameDirty() && (bl || pSPanelItemLogicBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelItemLogicBase.getPSSysViewPanelName());
        }
        if (pSPanelItemLogicBase.isUpdateDateDirty() && (bl || pSPanelItemLogicBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelItemLogicBase.getUpdateDate());
        }
        if (pSPanelItemLogicBase.isUpdateManDirty() && (bl || pSPanelItemLogicBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelItemLogicBase.getUpdateMan());
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
        return PSPanelItemLogicBase.remove(this, n);
    }

    private static boolean remove(PSPanelItemLogicBase pSPanelItemLogicBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelItemLogicBase.resetCondOp();
                return true;
            }
            case 1: {
                pSPanelItemLogicBase.resetCondValue();
                return true;
            }
            case 2: {
                pSPanelItemLogicBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPanelItemLogicBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPanelItemLogicBase.resetCustomCode();
                return true;
            }
            case 5: {
                pSPanelItemLogicBase.resetDstFieldName();
                return true;
            }
            case 6: {
                pSPanelItemLogicBase.resetDstPSPanelModelId();
                return true;
            }
            case 7: {
                pSPanelItemLogicBase.resetDstPSPanelModelName();
                return true;
            }
            case 8: {
                pSPanelItemLogicBase.resetGroupNotFlag();
                return true;
            }
            case 9: {
                pSPanelItemLogicBase.resetGroupOP();
                return true;
            }
            case 10: {
                pSPanelItemLogicBase.resetLogicCat();
                return true;
            }
            case 11: {
                pSPanelItemLogicBase.resetLogicType();
                return true;
            }
            case 12: {
                pSPanelItemLogicBase.resetOrderValue();
                return true;
            }
            case 13: {
                pSPanelItemLogicBase.resetPPSPanelItemLogicId();
                return true;
            }
            case 14: {
                pSPanelItemLogicBase.resetPPSPanelItemLogicName();
                return true;
            }
            case 15: {
                pSPanelItemLogicBase.resetPSPanelItemLogicId();
                return true;
            }
            case 16: {
                pSPanelItemLogicBase.resetPSPanelItemLogicName();
                return true;
            }
            case 17: {
                pSPanelItemLogicBase.resetPSSysViewPanelId();
                return true;
            }
            case 18: {
                pSPanelItemLogicBase.resetPSSysViewPanelItemId();
                return true;
            }
            case 19: {
                pSPanelItemLogicBase.resetPSSysViewPanelItemName();
                return true;
            }
            case 20: {
                pSPanelItemLogicBase.resetPSSysViewPanelName();
                return true;
            }
            case 21: {
                pSPanelItemLogicBase.resetUpdateDate();
                return true;
            }
            case 22: {
                pSPanelItemLogicBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelItemLogic getPPSPanelItemLogic() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelItemLogic();
        }
        if (this.getPPSPanelItemLogicId() == null) {
            return null;
        }
        Integer n = this.objPPSPanelItemLogicLock;
        synchronized (n) {
            if (this.ppspanelitemlogic != null && DataTypeHelper.compare((int)25, (Object)this.getPPSPanelItemLogicId(), (Object)this.ppspanelitemlogic.getPSPanelItemLogicId()) != 0L) {
                this.ppspanelitemlogic = null;
            }
            if (this.ppspanelitemlogic == null) {
                PSPanelItemLogic pSPanelItemLogic = new PSPanelItemLogic();
                pSPanelItemLogic.setPSPanelItemLogicId(this.getPPSPanelItemLogicId());
                PSPanelItemLogicService pSPanelItemLogicService = (PSPanelItemLogicService)ServiceGlobal.getService(PSPanelItemLogicService.class, (SessionFactory)this.getSessionFactory());
                pSPanelItemLogicService.autoGet((IEntity)pSPanelItemLogic);
                this.ppspanelitemlogic = pSPanelItemLogic;
            }
            return this.ppspanelitemlogic;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelItem getPSSysViewPanelItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysViewPanelItem();
        }
        if (this.getPSSysViewPanelItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysViewPanelItemLock;
        synchronized (n) {
            if (this.pssysviewpanelitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysViewPanelItemId(), (Object)this.pssysviewpanelitem.getPSSysViewPanelItemId()) != 0L) {
                this.pssysviewpanelitem = null;
            }
            if (this.pssysviewpanelitem == null) {
                PSSysViewPanelItem pSSysViewPanelItem = new PSSysViewPanelItem();
                pSSysViewPanelItem.setPSSysViewPanelItemId(this.getPSSysViewPanelItemId());
                PSSysViewPanelItemService pSSysViewPanelItemService = (PSSysViewPanelItemService)ServiceGlobal.getService(PSSysViewPanelItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelItemService.autoGet((IEntity)pSSysViewPanelItem);
                this.pssysviewpanelitem = pSSysViewPanelItem;
            }
            return this.pssysviewpanelitem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysViewPanelModel getDstPSPanelModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSPanelModel();
        }
        if (this.getDstPSPanelModelId() == null) {
            return null;
        }
        Integer n = this.objDstPSPanelModelLock;
        synchronized (n) {
            if (this.dstpspanelmodel != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSPanelModelId(), (Object)this.dstpspanelmodel.getPSSysViewPanelModelId()) != 0L) {
                this.dstpspanelmodel = null;
            }
            if (this.dstpspanelmodel == null) {
                PSSysViewPanelModel pSSysViewPanelModel = new PSSysViewPanelModel();
                pSSysViewPanelModel.setPSSysViewPanelModelId(this.getDstPSPanelModelId());
                PSSysViewPanelModelService pSSysViewPanelModelService = (PSSysViewPanelModelService)ServiceGlobal.getService(PSSysViewPanelModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysViewPanelModelService.autoGet((IEntity)pSSysViewPanelModel);
                this.dstpspanelmodel = pSSysViewPanelModel;
            }
            return this.dstpspanelmodel;
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

    private PSPanelItemLogicBase getProxyEntity() {
        return this.proxyPSPanelItemLogicBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelItemLogicBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelItemLogicBase) {
            this.proxyPSPanelItemLogicBase = (PSPanelItemLogicBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelItemLogicService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDOP, 0);
        fieldIndexMap.put(FIELD_CONDVALUE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 4);
        fieldIndexMap.put(FIELD_DSTFIELDNAME, 5);
        fieldIndexMap.put(FIELD_DSTPSPANELMODELID, 6);
        fieldIndexMap.put(FIELD_DSTPSPANELMODELNAME, 7);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 8);
        fieldIndexMap.put(FIELD_GROUPOP, 9);
        fieldIndexMap.put(FIELD_LOGICCAT, 10);
        fieldIndexMap.put(FIELD_LOGICTYPE, 11);
        fieldIndexMap.put(FIELD_ORDERVALUE, 12);
        fieldIndexMap.put(FIELD_PPSPANELITEMLOGICID, 13);
        fieldIndexMap.put(FIELD_PPSPANELITEMLOGICNAME, 14);
        fieldIndexMap.put(FIELD_PSPANELITEMLOGICID, 15);
        fieldIndexMap.put(FIELD_PSPANELITEMLOGICNAME, 16);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 17);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMID, 18);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELITEMNAME, 19);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 20);
        fieldIndexMap.put(FIELD_UPDATEDATE, 21);
        fieldIndexMap.put(FIELD_UPDATEMAN, 22);
    }
}

