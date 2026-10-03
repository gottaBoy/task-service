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
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLLCond;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicLink;
import net.ibizsys.pscore.srv.sysdesign.entity.PSPanelLogicParam;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicLinkService;
import net.ibizsys.pscore.srv.sysdesign.service.PSPanelLogicParamService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPanelLLCondBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPanelLLCondBase.class);
    public static final String FIELD_CONDOP = "CONDOP";
    public static final String FIELD_CONDVALUE = "CONDVALUE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTFIELDNAME = "DSTFIELDNAME";
    public static final String FIELD_DSTPSPANELLPID = "DSTPSPANELLPID";
    public static final String FIELD_DSTPSPANELLPNAME = "DSTPSPANELLPNAME";
    public static final String FIELD_GROUPNOTFLAG = "GROUPNOTFLAG";
    public static final String FIELD_GROUPOP = "GROUPOP";
    public static final String FIELD_LOGICTYPE = "LOGICTYPE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMTYPE = "PARAMTYPE";
    public static final String FIELD_PPSPANELLLCONDID = "PPSPANELLLCONDID";
    public static final String FIELD_PPSPANELLLCONDNAME = "PPSPANELLLCONDNAME";
    public static final String FIELD_PSPANELLLCONDID = "PSPANELLLCONDID";
    public static final String FIELD_PSPANELLLCONDNAME = "PSPANELLLCONDNAME";
    public static final String FIELD_PSPANELLOGICLINKID = "PSPANELLOGICLINKID";
    public static final String FIELD_PSPANELLOGICLINKNAME = "PSPANELLOGICLINKNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELLOGICID = "PSSYSVIEWPANELLOGICID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_CONDOP = 0;
    private static final int INDEX_CONDVALUE = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DSTFIELDNAME = 4;
    private static final int INDEX_DSTPSPANELLPID = 5;
    private static final int INDEX_DSTPSPANELLPNAME = 6;
    private static final int INDEX_GROUPNOTFLAG = 7;
    private static final int INDEX_GROUPOP = 8;
    private static final int INDEX_LOGICTYPE = 9;
    private static final int INDEX_MEMO = 10;
    private static final int INDEX_ORDERVALUE = 11;
    private static final int INDEX_PARAMTYPE = 12;
    private static final int INDEX_PPSPANELLLCONDID = 13;
    private static final int INDEX_PPSPANELLLCONDNAME = 14;
    private static final int INDEX_PSPANELLLCONDID = 15;
    private static final int INDEX_PSPANELLLCONDNAME = 16;
    private static final int INDEX_PSPANELLOGICLINKID = 17;
    private static final int INDEX_PSPANELLOGICLINKNAME = 18;
    private static final int INDEX_PSSYSTEMID = 19;
    private static final int INDEX_PSSYSVIEWPANELID = 20;
    private static final int INDEX_PSSYSVIEWPANELLOGICID = 21;
    private static final int INDEX_PSSYSVIEWPANELNAME = 22;
    private static final int INDEX_UPDATEDATE = 23;
    private static final int INDEX_UPDATEMAN = 24;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPanelLLCondBase proxyPSPanelLLCondBase = null;
    private boolean condopDirtyFlag = false;
    private boolean condvalueDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstfieldnameDirtyFlag = false;
    private boolean dstpspanellpidDirtyFlag = false;
    private boolean dstpspanellpnameDirtyFlag = false;
    private boolean groupnotflagDirtyFlag = false;
    private boolean groupopDirtyFlag = false;
    private boolean logictypeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramtypeDirtyFlag = false;
    private boolean ppspanelllcondidDirtyFlag = false;
    private boolean ppspanelllcondnameDirtyFlag = false;
    private boolean pspanelllcondidDirtyFlag = false;
    private boolean pspanelllcondnameDirtyFlag = false;
    private boolean pspanellogiclinkidDirtyFlag = false;
    private boolean pspanellogiclinknameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanellogicidDirtyFlag = false;
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
    @Column(name="dstfieldname")
    private String dstfieldname;
    @Column(name="dstpspanellpid")
    private String dstpspanellpid;
    @Column(name="dstpspanellpname")
    private String dstpspanellpname;
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
    @Column(name="ppspanelllcondid")
    private String ppspanelllcondid;
    @Column(name="ppspanelllcondname")
    private String ppspanelllcondname;
    @Column(name="pspanelllcondid")
    private String pspanelllcondid;
    @Column(name="pspanelllcondname")
    private String pspanelllcondname;
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
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPPSPanelLLCondLock = new Integer(1);
    private PSPanelLLCond ppspanelllcond = null;
    private Integer objPSPanelLogicLinkLock = new Integer(1);
    private PSPanelLogicLink pspanellogiclink = null;
    private Integer objDstPSPanelLPLock = new Integer(1);
    private PSPanelLogicParam dstpspanellp = null;
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

    public void setPPSPanelLLCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPanelLLCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspanelllcondid = string;
        this.ppspanelllcondidDirtyFlag = true;
    }

    public String getPPSPanelLLCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelLLCondId();
        }
        return this.ppspanelllcondid;
    }

    public boolean isPPSPanelLLCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPanelLLCondIdDirty();
        }
        return this.ppspanelllcondidDirtyFlag;
    }

    public void resetPPSPanelLLCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPanelLLCondId();
            return;
        }
        this.ppspanelllcondidDirtyFlag = false;
        this.ppspanelllcondid = null;
    }

    public void setPPSPanelLLCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSPanelLLCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppspanelllcondname = string;
        this.ppspanelllcondnameDirtyFlag = true;
    }

    public String getPPSPanelLLCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelLLCondName();
        }
        return this.ppspanelllcondname;
    }

    public boolean isPPSPanelLLCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSPanelLLCondNameDirty();
        }
        return this.ppspanelllcondnameDirtyFlag;
    }

    public void resetPPSPanelLLCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSPanelLLCondName();
            return;
        }
        this.ppspanelllcondnameDirtyFlag = false;
        this.ppspanelllcondname = null;
    }

    public void setPSPanelLLCondId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLCondId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelllcondid = string;
        this.pspanelllcondidDirtyFlag = true;
    }

    public String getPSPanelLLCondId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLCondId();
        }
        return this.pspanelllcondid;
    }

    public boolean isPSPanelLLCondIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLCondIdDirty();
        }
        return this.pspanelllcondidDirtyFlag;
    }

    public void resetPSPanelLLCondId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLCondId();
            return;
        }
        this.pspanelllcondidDirtyFlag = false;
        this.pspanelllcondid = null;
    }

    public void setPSPanelLLCondName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPanelLLCondName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspanelllcondname = string;
        this.pspanelllcondnameDirtyFlag = true;
    }

    public String getPSPanelLLCondName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLLCondName();
        }
        return this.pspanelllcondname;
    }

    public boolean isPSPanelLLCondNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPanelLLCondNameDirty();
        }
        return this.pspanelllcondnameDirtyFlag;
    }

    public void resetPSPanelLLCondName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPanelLLCondName();
            return;
        }
        this.pspanelllcondnameDirtyFlag = false;
        this.pspanelllcondname = null;
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
        PSPanelLLCondBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPanelLLCondBase pSPanelLLCondBase) {
        pSPanelLLCondBase.resetCondOp();
        pSPanelLLCondBase.resetCondValue();
        pSPanelLLCondBase.resetCreateDate();
        pSPanelLLCondBase.resetCreateMan();
        pSPanelLLCondBase.resetDstFieldName();
        pSPanelLLCondBase.resetDstPSPanelLPId();
        pSPanelLLCondBase.resetDstPSPanelLPName();
        pSPanelLLCondBase.resetGroupNotFlag();
        pSPanelLLCondBase.resetGroupOP();
        pSPanelLLCondBase.resetLogicType();
        pSPanelLLCondBase.resetMemo();
        pSPanelLLCondBase.resetOrderValue();
        pSPanelLLCondBase.resetParamType();
        pSPanelLLCondBase.resetPPSPanelLLCondId();
        pSPanelLLCondBase.resetPPSPanelLLCondName();
        pSPanelLLCondBase.resetPSPanelLLCondId();
        pSPanelLLCondBase.resetPSPanelLLCondName();
        pSPanelLLCondBase.resetPSPanelLogicLinkId();
        pSPanelLLCondBase.resetPSPanelLogicLinkName();
        pSPanelLLCondBase.resetPSSystemId();
        pSPanelLLCondBase.resetPSSysViewPanelId();
        pSPanelLLCondBase.resetPSSysViewPanelLogicId();
        pSPanelLLCondBase.resetPSSysViewPanelName();
        pSPanelLLCondBase.resetUpdateDate();
        pSPanelLLCondBase.resetUpdateMan();
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
        if (!bl || this.isDstFieldNameDirty()) {
            hashMap.put(FIELD_DSTFIELDNAME, this.getDstFieldName());
        }
        if (!bl || this.isDstPSPanelLPIdDirty()) {
            hashMap.put(FIELD_DSTPSPANELLPID, this.getDstPSPanelLPId());
        }
        if (!bl || this.isDstPSPanelLPNameDirty()) {
            hashMap.put(FIELD_DSTPSPANELLPNAME, this.getDstPSPanelLPName());
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
        if (!bl || this.isPPSPanelLLCondIdDirty()) {
            hashMap.put(FIELD_PPSPANELLLCONDID, this.getPPSPanelLLCondId());
        }
        if (!bl || this.isPPSPanelLLCondNameDirty()) {
            hashMap.put(FIELD_PPSPANELLLCONDNAME, this.getPPSPanelLLCondName());
        }
        if (!bl || this.isPSPanelLLCondIdDirty()) {
            hashMap.put(FIELD_PSPANELLLCONDID, this.getPSPanelLLCondId());
        }
        if (!bl || this.isPSPanelLLCondNameDirty()) {
            hashMap.put(FIELD_PSPANELLLCONDNAME, this.getPSPanelLLCondName());
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
        return PSPanelLLCondBase.get(this, n);
    }

    private static Object get(PSPanelLLCondBase pSPanelLLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondBase.getCondOp();
            }
            case 1: {
                return pSPanelLLCondBase.getCondValue();
            }
            case 2: {
                return pSPanelLLCondBase.getCreateDate();
            }
            case 3: {
                return pSPanelLLCondBase.getCreateMan();
            }
            case 4: {
                return pSPanelLLCondBase.getDstFieldName();
            }
            case 5: {
                return pSPanelLLCondBase.getDstPSPanelLPId();
            }
            case 6: {
                return pSPanelLLCondBase.getDstPSPanelLPName();
            }
            case 7: {
                return pSPanelLLCondBase.getGroupNotFlag();
            }
            case 8: {
                return pSPanelLLCondBase.getGroupOP();
            }
            case 9: {
                return pSPanelLLCondBase.getLogicType();
            }
            case 10: {
                return pSPanelLLCondBase.getMemo();
            }
            case 11: {
                return pSPanelLLCondBase.getOrderValue();
            }
            case 12: {
                return pSPanelLLCondBase.getParamType();
            }
            case 13: {
                return pSPanelLLCondBase.getPPSPanelLLCondId();
            }
            case 14: {
                return pSPanelLLCondBase.getPPSPanelLLCondName();
            }
            case 15: {
                return pSPanelLLCondBase.getPSPanelLLCondId();
            }
            case 16: {
                return pSPanelLLCondBase.getPSPanelLLCondName();
            }
            case 17: {
                return pSPanelLLCondBase.getPSPanelLogicLinkId();
            }
            case 18: {
                return pSPanelLLCondBase.getPSPanelLogicLinkName();
            }
            case 19: {
                return pSPanelLLCondBase.getPSSystemId();
            }
            case 20: {
                return pSPanelLLCondBase.getPSSysViewPanelId();
            }
            case 21: {
                return pSPanelLLCondBase.getPSSysViewPanelLogicId();
            }
            case 22: {
                return pSPanelLLCondBase.getPSSysViewPanelName();
            }
            case 23: {
                return pSPanelLLCondBase.getUpdateDate();
            }
            case 24: {
                return pSPanelLLCondBase.getUpdateMan();
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
        PSPanelLLCondBase.set(this, n, object);
    }

    private static void set(PSPanelLLCondBase pSPanelLLCondBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLCondBase.setCondOp(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPanelLLCondBase.setCondValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSPanelLLCondBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSPanelLLCondBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPanelLLCondBase.setDstFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPanelLLCondBase.setDstPSPanelLPId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPanelLLCondBase.setDstPSPanelLPName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSPanelLLCondBase.setGroupNotFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSPanelLLCondBase.setGroupOP(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPanelLLCondBase.setLogicType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPanelLLCondBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPanelLLCondBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSPanelLLCondBase.setParamType(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPanelLLCondBase.setPPSPanelLLCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPanelLLCondBase.setPPSPanelLLCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSPanelLLCondBase.setPSPanelLLCondId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPanelLLCondBase.setPSPanelLLCondName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPanelLLCondBase.setPSPanelLogicLinkId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPanelLLCondBase.setPSPanelLogicLinkName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPanelLLCondBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSPanelLLCondBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPanelLLCondBase.setPSSysViewPanelLogicId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSPanelLLCondBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPanelLLCondBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 24: {
                pSPanelLLCondBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSPanelLLCondBase.isNull(this, n);
    }

    private static boolean isNull(PSPanelLLCondBase pSPanelLLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondBase.getCondOp() == null;
            }
            case 1: {
                return pSPanelLLCondBase.getCondValue() == null;
            }
            case 2: {
                return pSPanelLLCondBase.getCreateDate() == null;
            }
            case 3: {
                return pSPanelLLCondBase.getCreateMan() == null;
            }
            case 4: {
                return pSPanelLLCondBase.getDstFieldName() == null;
            }
            case 5: {
                return pSPanelLLCondBase.getDstPSPanelLPId() == null;
            }
            case 6: {
                return pSPanelLLCondBase.getDstPSPanelLPName() == null;
            }
            case 7: {
                return pSPanelLLCondBase.getGroupNotFlag() == null;
            }
            case 8: {
                return pSPanelLLCondBase.getGroupOP() == null;
            }
            case 9: {
                return pSPanelLLCondBase.getLogicType() == null;
            }
            case 10: {
                return pSPanelLLCondBase.getMemo() == null;
            }
            case 11: {
                return pSPanelLLCondBase.getOrderValue() == null;
            }
            case 12: {
                return pSPanelLLCondBase.getParamType() == null;
            }
            case 13: {
                return pSPanelLLCondBase.getPPSPanelLLCondId() == null;
            }
            case 14: {
                return pSPanelLLCondBase.getPPSPanelLLCondName() == null;
            }
            case 15: {
                return pSPanelLLCondBase.getPSPanelLLCondId() == null;
            }
            case 16: {
                return pSPanelLLCondBase.getPSPanelLLCondName() == null;
            }
            case 17: {
                return pSPanelLLCondBase.getPSPanelLogicLinkId() == null;
            }
            case 18: {
                return pSPanelLLCondBase.getPSPanelLogicLinkName() == null;
            }
            case 19: {
                return pSPanelLLCondBase.getPSSystemId() == null;
            }
            case 20: {
                return pSPanelLLCondBase.getPSSysViewPanelId() == null;
            }
            case 21: {
                return pSPanelLLCondBase.getPSSysViewPanelLogicId() == null;
            }
            case 22: {
                return pSPanelLLCondBase.getPSSysViewPanelName() == null;
            }
            case 23: {
                return pSPanelLLCondBase.getUpdateDate() == null;
            }
            case 24: {
                return pSPanelLLCondBase.getUpdateMan() == null;
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
        return PSPanelLLCondBase.contains(this, n);
    }

    private static boolean contains(PSPanelLLCondBase pSPanelLLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPanelLLCondBase.isCondOpDirty();
            }
            case 1: {
                return pSPanelLLCondBase.isCondValueDirty();
            }
            case 2: {
                return pSPanelLLCondBase.isCreateDateDirty();
            }
            case 3: {
                return pSPanelLLCondBase.isCreateManDirty();
            }
            case 4: {
                return pSPanelLLCondBase.isDstFieldNameDirty();
            }
            case 5: {
                return pSPanelLLCondBase.isDstPSPanelLPIdDirty();
            }
            case 6: {
                return pSPanelLLCondBase.isDstPSPanelLPNameDirty();
            }
            case 7: {
                return pSPanelLLCondBase.isGroupNotFlagDirty();
            }
            case 8: {
                return pSPanelLLCondBase.isGroupOPDirty();
            }
            case 9: {
                return pSPanelLLCondBase.isLogicTypeDirty();
            }
            case 10: {
                return pSPanelLLCondBase.isMemoDirty();
            }
            case 11: {
                return pSPanelLLCondBase.isOrderValueDirty();
            }
            case 12: {
                return pSPanelLLCondBase.isParamTypeDirty();
            }
            case 13: {
                return pSPanelLLCondBase.isPPSPanelLLCondIdDirty();
            }
            case 14: {
                return pSPanelLLCondBase.isPPSPanelLLCondNameDirty();
            }
            case 15: {
                return pSPanelLLCondBase.isPSPanelLLCondIdDirty();
            }
            case 16: {
                return pSPanelLLCondBase.isPSPanelLLCondNameDirty();
            }
            case 17: {
                return pSPanelLLCondBase.isPSPanelLogicLinkIdDirty();
            }
            case 18: {
                return pSPanelLLCondBase.isPSPanelLogicLinkNameDirty();
            }
            case 19: {
                return pSPanelLLCondBase.isPSSystemIdDirty();
            }
            case 20: {
                return pSPanelLLCondBase.isPSSysViewPanelIdDirty();
            }
            case 21: {
                return pSPanelLLCondBase.isPSSysViewPanelLogicIdDirty();
            }
            case 22: {
                return pSPanelLLCondBase.isPSSysViewPanelNameDirty();
            }
            case 23: {
                return pSPanelLLCondBase.isUpdateDateDirty();
            }
            case 24: {
                return pSPanelLLCondBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPanelLLCondBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPanelLLCondBase pSPanelLLCondBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPanelLLCondBase.getCondOp() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condop", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getCondOp()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getCondValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"condvalue", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getCondValue()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getDstFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstfieldname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getDstFieldName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getDstPSPanelLPId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellpid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getDstPSPanelLPId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getDstPSPanelLPName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpspanellpname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getDstPSPanelLPName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getGroupNotFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupnotflag", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getGroupNotFlag()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getGroupOP() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupop", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getGroupOP()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getLogicType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logictype", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getLogicType()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getMemo()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getParamType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramtype", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getParamType()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPPSPanelLLCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspanelllcondid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPPSPanelLLCondId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPPSPanelLLCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppspanelllcondname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPPSPanelLLCondName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLLCondId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelllcondid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSPanelLLCondId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLLCondName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanelllcondname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSPanelLLCondName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLogicLinkId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogiclinkid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSPanelLogicLinkId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLogicLinkName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspanellogiclinkname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSPanelLogicLinkName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelLogicId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanellogicid", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSSysViewPanelLogicId()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPanelLLCondBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPanelLLCondBase.getJSONValue((Object)pSPanelLLCondBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPanelLLCondBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPanelLLCondBase pSPanelLLCondBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPanelLLCondBase.getCondOp() != null) {
            object = pSPanelLLCondBase.getCondOp();
            xmlNode.setAttribute(FIELD_CONDOP, (String)(object == null ? "" : object));
        }
        if (bl || pSPanelLLCondBase.getCondValue() != null) {
            object = pSPanelLLCondBase.getCondValue();
            xmlNode.setAttribute(FIELD_CONDVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getCreateDate() != null) {
            object = pSPanelLLCondBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLCondBase.getCreateMan() != null) {
            object = pSPanelLLCondBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getDstFieldName() != null) {
            object = pSPanelLLCondBase.getDstFieldName();
            xmlNode.setAttribute(FIELD_DSTFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getDstPSPanelLPId() != null) {
            object = pSPanelLLCondBase.getDstPSPanelLPId();
            xmlNode.setAttribute(FIELD_DSTPSPANELLPID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getDstPSPanelLPName() != null) {
            object = pSPanelLLCondBase.getDstPSPanelLPName();
            xmlNode.setAttribute(FIELD_DSTPSPANELLPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getGroupNotFlag() != null) {
            object = pSPanelLLCondBase.getGroupNotFlag();
            xmlNode.setAttribute(FIELD_GROUPNOTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLLCondBase.getGroupOP() != null) {
            object = pSPanelLLCondBase.getGroupOP();
            xmlNode.setAttribute(FIELD_GROUPOP, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getLogicType() != null) {
            object = pSPanelLLCondBase.getLogicType();
            xmlNode.setAttribute(FIELD_LOGICTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getMemo() != null) {
            object = pSPanelLLCondBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getOrderValue() != null) {
            object = pSPanelLLCondBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPanelLLCondBase.getParamType() != null) {
            object = pSPanelLLCondBase.getParamType();
            xmlNode.setAttribute(FIELD_PARAMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPPSPanelLLCondId() != null) {
            object = pSPanelLLCondBase.getPPSPanelLLCondId();
            xmlNode.setAttribute(FIELD_PPSPANELLLCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPPSPanelLLCondName() != null) {
            object = pSPanelLLCondBase.getPPSPanelLLCondName();
            xmlNode.setAttribute(FIELD_PPSPANELLLCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLLCondId() != null) {
            object = pSPanelLLCondBase.getPSPanelLLCondId();
            xmlNode.setAttribute(FIELD_PSPANELLLCONDID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLLCondName() != null) {
            object = pSPanelLLCondBase.getPSPanelLLCondName();
            xmlNode.setAttribute(FIELD_PSPANELLLCONDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLogicLinkId() != null) {
            object = pSPanelLLCondBase.getPSPanelLogicLinkId();
            xmlNode.setAttribute(FIELD_PSPANELLOGICLINKID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSPanelLogicLinkName() != null) {
            object = pSPanelLLCondBase.getPSPanelLogicLinkName();
            xmlNode.setAttribute(FIELD_PSPANELLOGICLINKNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSSystemId() != null) {
            object = pSPanelLLCondBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelId() != null) {
            object = pSPanelLLCondBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelLogicId() != null) {
            object = pSPanelLLCondBase.getPSSysViewPanelLogicId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELLOGICID, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getPSSysViewPanelName() != null) {
            object = pSPanelLLCondBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPanelLLCondBase.getUpdateDate() != null) {
            object = pSPanelLLCondBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPanelLLCondBase.getUpdateMan() != null) {
            object = pSPanelLLCondBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPanelLLCondBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPanelLLCondBase pSPanelLLCondBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPanelLLCondBase.isCondOpDirty() && (bl || pSPanelLLCondBase.getCondOp() != null)) {
            iDataObject.set(FIELD_CONDOP, (Object)pSPanelLLCondBase.getCondOp());
        }
        if (pSPanelLLCondBase.isCondValueDirty() && (bl || pSPanelLLCondBase.getCondValue() != null)) {
            iDataObject.set(FIELD_CONDVALUE, (Object)pSPanelLLCondBase.getCondValue());
        }
        if (pSPanelLLCondBase.isCreateDateDirty() && (bl || pSPanelLLCondBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPanelLLCondBase.getCreateDate());
        }
        if (pSPanelLLCondBase.isCreateManDirty() && (bl || pSPanelLLCondBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPanelLLCondBase.getCreateMan());
        }
        if (pSPanelLLCondBase.isDstFieldNameDirty() && (bl || pSPanelLLCondBase.getDstFieldName() != null)) {
            iDataObject.set(FIELD_DSTFIELDNAME, (Object)pSPanelLLCondBase.getDstFieldName());
        }
        if (pSPanelLLCondBase.isDstPSPanelLPIdDirty() && (bl || pSPanelLLCondBase.getDstPSPanelLPId() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLPID, (Object)pSPanelLLCondBase.getDstPSPanelLPId());
        }
        if (pSPanelLLCondBase.isDstPSPanelLPNameDirty() && (bl || pSPanelLLCondBase.getDstPSPanelLPName() != null)) {
            iDataObject.set(FIELD_DSTPSPANELLPNAME, (Object)pSPanelLLCondBase.getDstPSPanelLPName());
        }
        if (pSPanelLLCondBase.isGroupNotFlagDirty() && (bl || pSPanelLLCondBase.getGroupNotFlag() != null)) {
            iDataObject.set(FIELD_GROUPNOTFLAG, (Object)pSPanelLLCondBase.getGroupNotFlag());
        }
        if (pSPanelLLCondBase.isGroupOPDirty() && (bl || pSPanelLLCondBase.getGroupOP() != null)) {
            iDataObject.set(FIELD_GROUPOP, (Object)pSPanelLLCondBase.getGroupOP());
        }
        if (pSPanelLLCondBase.isLogicTypeDirty() && (bl || pSPanelLLCondBase.getLogicType() != null)) {
            iDataObject.set(FIELD_LOGICTYPE, (Object)pSPanelLLCondBase.getLogicType());
        }
        if (pSPanelLLCondBase.isMemoDirty() && (bl || pSPanelLLCondBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPanelLLCondBase.getMemo());
        }
        if (pSPanelLLCondBase.isOrderValueDirty() && (bl || pSPanelLLCondBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSPanelLLCondBase.getOrderValue());
        }
        if (pSPanelLLCondBase.isParamTypeDirty() && (bl || pSPanelLLCondBase.getParamType() != null)) {
            iDataObject.set(FIELD_PARAMTYPE, (Object)pSPanelLLCondBase.getParamType());
        }
        if (pSPanelLLCondBase.isPPSPanelLLCondIdDirty() && (bl || pSPanelLLCondBase.getPPSPanelLLCondId() != null)) {
            iDataObject.set(FIELD_PPSPANELLLCONDID, (Object)pSPanelLLCondBase.getPPSPanelLLCondId());
        }
        if (pSPanelLLCondBase.isPPSPanelLLCondNameDirty() && (bl || pSPanelLLCondBase.getPPSPanelLLCondName() != null)) {
            iDataObject.set(FIELD_PPSPANELLLCONDNAME, (Object)pSPanelLLCondBase.getPPSPanelLLCondName());
        }
        if (pSPanelLLCondBase.isPSPanelLLCondIdDirty() && (bl || pSPanelLLCondBase.getPSPanelLLCondId() != null)) {
            iDataObject.set(FIELD_PSPANELLLCONDID, (Object)pSPanelLLCondBase.getPSPanelLLCondId());
        }
        if (pSPanelLLCondBase.isPSPanelLLCondNameDirty() && (bl || pSPanelLLCondBase.getPSPanelLLCondName() != null)) {
            iDataObject.set(FIELD_PSPANELLLCONDNAME, (Object)pSPanelLLCondBase.getPSPanelLLCondName());
        }
        if (pSPanelLLCondBase.isPSPanelLogicLinkIdDirty() && (bl || pSPanelLLCondBase.getPSPanelLogicLinkId() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICLINKID, (Object)pSPanelLLCondBase.getPSPanelLogicLinkId());
        }
        if (pSPanelLLCondBase.isPSPanelLogicLinkNameDirty() && (bl || pSPanelLLCondBase.getPSPanelLogicLinkName() != null)) {
            iDataObject.set(FIELD_PSPANELLOGICLINKNAME, (Object)pSPanelLLCondBase.getPSPanelLogicLinkName());
        }
        if (pSPanelLLCondBase.isPSSystemIdDirty() && (bl || pSPanelLLCondBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSPanelLLCondBase.getPSSystemId());
        }
        if (pSPanelLLCondBase.isPSSysViewPanelIdDirty() && (bl || pSPanelLLCondBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSPanelLLCondBase.getPSSysViewPanelId());
        }
        if (pSPanelLLCondBase.isPSSysViewPanelLogicIdDirty() && (bl || pSPanelLLCondBase.getPSSysViewPanelLogicId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELLOGICID, (Object)pSPanelLLCondBase.getPSSysViewPanelLogicId());
        }
        if (pSPanelLLCondBase.isPSSysViewPanelNameDirty() && (bl || pSPanelLLCondBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSPanelLLCondBase.getPSSysViewPanelName());
        }
        if (pSPanelLLCondBase.isUpdateDateDirty() && (bl || pSPanelLLCondBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPanelLLCondBase.getUpdateDate());
        }
        if (pSPanelLLCondBase.isUpdateManDirty() && (bl || pSPanelLLCondBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPanelLLCondBase.getUpdateMan());
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
        return PSPanelLLCondBase.remove(this, n);
    }

    private static boolean remove(PSPanelLLCondBase pSPanelLLCondBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPanelLLCondBase.resetCondOp();
                return true;
            }
            case 1: {
                pSPanelLLCondBase.resetCondValue();
                return true;
            }
            case 2: {
                pSPanelLLCondBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSPanelLLCondBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSPanelLLCondBase.resetDstFieldName();
                return true;
            }
            case 5: {
                pSPanelLLCondBase.resetDstPSPanelLPId();
                return true;
            }
            case 6: {
                pSPanelLLCondBase.resetDstPSPanelLPName();
                return true;
            }
            case 7: {
                pSPanelLLCondBase.resetGroupNotFlag();
                return true;
            }
            case 8: {
                pSPanelLLCondBase.resetGroupOP();
                return true;
            }
            case 9: {
                pSPanelLLCondBase.resetLogicType();
                return true;
            }
            case 10: {
                pSPanelLLCondBase.resetMemo();
                return true;
            }
            case 11: {
                pSPanelLLCondBase.resetOrderValue();
                return true;
            }
            case 12: {
                pSPanelLLCondBase.resetParamType();
                return true;
            }
            case 13: {
                pSPanelLLCondBase.resetPPSPanelLLCondId();
                return true;
            }
            case 14: {
                pSPanelLLCondBase.resetPPSPanelLLCondName();
                return true;
            }
            case 15: {
                pSPanelLLCondBase.resetPSPanelLLCondId();
                return true;
            }
            case 16: {
                pSPanelLLCondBase.resetPSPanelLLCondName();
                return true;
            }
            case 17: {
                pSPanelLLCondBase.resetPSPanelLogicLinkId();
                return true;
            }
            case 18: {
                pSPanelLLCondBase.resetPSPanelLogicLinkName();
                return true;
            }
            case 19: {
                pSPanelLLCondBase.resetPSSystemId();
                return true;
            }
            case 20: {
                pSPanelLLCondBase.resetPSSysViewPanelId();
                return true;
            }
            case 21: {
                pSPanelLLCondBase.resetPSSysViewPanelLogicId();
                return true;
            }
            case 22: {
                pSPanelLLCondBase.resetPSSysViewPanelName();
                return true;
            }
            case 23: {
                pSPanelLLCondBase.resetUpdateDate();
                return true;
            }
            case 24: {
                pSPanelLLCondBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLLCond getPPSPanelLLCond() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSPanelLLCond();
        }
        if (this.getPPSPanelLLCondId() == null) {
            return null;
        }
        Integer n = this.objPPSPanelLLCondLock;
        synchronized (n) {
            if (this.ppspanelllcond != null && DataTypeHelper.compare((int)25, (Object)this.getPPSPanelLLCondId(), (Object)this.ppspanelllcond.getPSPanelLLCondId()) != 0L) {
                this.ppspanelllcond = null;
            }
            if (this.ppspanelllcond == null) {
                PSPanelLLCond pSPanelLLCond = new PSPanelLLCond();
                pSPanelLLCond.setPSPanelLLCondId(this.getPPSPanelLLCondId());
                PSPanelLLCondService pSPanelLLCondService = (PSPanelLLCondService)ServiceGlobal.getService(PSPanelLLCondService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLLCondService.autoGet(pSPanelLLCond);
                this.ppspanelllcond = pSPanelLLCond;
            }
            return this.ppspanelllcond;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSPanelLogicLink getPSPanelLogicLink() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPanelLogicLink();
        }
        if (this.getPSPanelLogicLinkId() == null) {
            return null;
        }
        Integer n = this.objPSPanelLogicLinkLock;
        synchronized (n) {
            if (this.pspanellogiclink != null && DataTypeHelper.compare((int)25, (Object)this.getPSPanelLogicLinkId(), (Object)this.pspanellogiclink.getPSPanelLogicLinkId()) != 0L) {
                this.pspanellogiclink = null;
            }
            if (this.pspanellogiclink == null) {
                PSPanelLogicLink pSPanelLogicLink = new PSPanelLogicLink();
                pSPanelLogicLink.setPSPanelLogicLinkId(this.getPSPanelLogicLinkId());
                PSPanelLogicLinkService pSPanelLogicLinkService = (PSPanelLogicLinkService)ServiceGlobal.getService(PSPanelLogicLinkService.class, (SessionFactory)this.getSessionFactory());
                pSPanelLogicLinkService.autoGet(pSPanelLogicLink);
                this.pspanellogiclink = pSPanelLogicLink;
            }
            return this.pspanellogiclink;
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

    private PSPanelLLCondBase getProxyEntity() {
        return this.proxyPSPanelLLCondBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPanelLLCondBase = null;
        if (iDataObject != null && iDataObject instanceof PSPanelLLCondBase) {
            this.proxyPSPanelLLCondBase = (PSPanelLLCondBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSPanelLLCondService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONDOP, 0);
        fieldIndexMap.put(FIELD_CONDVALUE, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DSTFIELDNAME, 4);
        fieldIndexMap.put(FIELD_DSTPSPANELLPID, 5);
        fieldIndexMap.put(FIELD_DSTPSPANELLPNAME, 6);
        fieldIndexMap.put(FIELD_GROUPNOTFLAG, 7);
        fieldIndexMap.put(FIELD_GROUPOP, 8);
        fieldIndexMap.put(FIELD_LOGICTYPE, 9);
        fieldIndexMap.put(FIELD_MEMO, 10);
        fieldIndexMap.put(FIELD_ORDERVALUE, 11);
        fieldIndexMap.put(FIELD_PARAMTYPE, 12);
        fieldIndexMap.put(FIELD_PPSPANELLLCONDID, 13);
        fieldIndexMap.put(FIELD_PPSPANELLLCONDNAME, 14);
        fieldIndexMap.put(FIELD_PSPANELLLCONDID, 15);
        fieldIndexMap.put(FIELD_PSPANELLLCONDNAME, 16);
        fieldIndexMap.put(FIELD_PSPANELLOGICLINKID, 17);
        fieldIndexMap.put(FIELD_PSPANELLOGICLINKNAME, 18);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 19);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 20);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELLOGICID, 21);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 22);
        fieldIndexMap.put(FIELD_UPDATEDATE, 23);
        fieldIndexMap.put(FIELD_UPDATEMAN, 24);
    }
}

