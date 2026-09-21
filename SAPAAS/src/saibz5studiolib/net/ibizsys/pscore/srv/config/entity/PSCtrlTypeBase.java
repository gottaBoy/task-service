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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeCallback;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeModel;
import net.ibizsys.pscore.srv.config.entity.PSCtrlTypeMsgTag;
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeCallbackService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeModelService;
import net.ibizsys.pscore.srv.config.service.PSCtrlTypeMsgTagService;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCtrlTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCtrlTypeBase.class);
    public static final String FIELD_AJAXCTRL = "AJAXCTRL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTFULLSN = "CTFULLSN";
    public static final String FIELD_CTRLOBJ = "CTRLOBJ";
    public static final String FIELD_CTRLOBJINT = "CTRLOBJINT";
    public static final String FIELD_CTRLTYPEPARAMS = "CTRLTYPEPARAMS";
    public static final String FIELD_CTSN = "CTSN";
    public static final String FIELD_HANDLEROBJ = "HANDLEROBJ";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_JITCTRLOBJ = "JITCTRLOBJ";
    public static final String FIELD_JITCTRLOBJ2 = "JITCTRLOBJ2";
    public static final String FIELD_JITMODELOBJ = "JITMODELOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARAMOBJ = "PARAMOBJ";
    public static final String FIELD_PARAMOBJINT = "PARAMOBJINT";
    public static final String FIELD_PSCTRLTYPEID = "PSCTRLTYPEID";
    public static final String FIELD_PSCTRLTYPENAME = "PSCTRLTYPENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    private static final int INDEX_AJAXCTRL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTFULLSN = 3;
    private static final int INDEX_CTRLOBJ = 4;
    private static final int INDEX_CTRLOBJINT = 5;
    private static final int INDEX_CTRLTYPEPARAMS = 6;
    private static final int INDEX_CTSN = 7;
    private static final int INDEX_HANDLEROBJ = 8;
    private static final int INDEX_ICONPATH = 9;
    private static final int INDEX_JITCTRLOBJ = 10;
    private static final int INDEX_JITCTRLOBJ2 = 11;
    private static final int INDEX_JITMODELOBJ = 12;
    private static final int INDEX_MEMO = 13;
    private static final int INDEX_ORDERVALUE = 14;
    private static final int INDEX_PARAMOBJ = 15;
    private static final int INDEX_PARAMOBJINT = 16;
    private static final int INDEX_PSCTRLTYPEID = 17;
    private static final int INDEX_PSCTRLTYPENAME = 18;
    private static final int INDEX_PSMODELID = 19;
    private static final int INDEX_PSMODELNAME = 20;
    private static final int INDEX_TYPEOBJ = 21;
    private static final int INDEX_UPDATEDATE = 22;
    private static final int INDEX_UPDATEMAN = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCtrlTypeBase proxyPSCtrlTypeBase = null;
    private boolean ajaxctrlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctfullsnDirtyFlag = false;
    private boolean ctrlobjDirtyFlag = false;
    private boolean ctrlobjintDirtyFlag = false;
    private boolean ctrltypeparamsDirtyFlag = false;
    private boolean ctsnDirtyFlag = false;
    private boolean handlerobjDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean jitctrlobjDirtyFlag = false;
    private boolean jitctrlobj2DirtyFlag = false;
    private boolean jitmodelobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean paramobjDirtyFlag = false;
    private boolean paramobjintDirtyFlag = false;
    private boolean psctrltypeidDirtyFlag = false;
    private boolean psctrltypenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    @Column(name="ajaxctrl")
    private Integer ajaxctrl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctfullsn")
    private String ctfullsn;
    @Column(name="ctrlobj")
    private String ctrlobj;
    @Column(name="ctrlobjint")
    private String ctrlobjint;
    @Column(name="ctrltypeparams")
    private String ctrltypeparams;
    @Column(name="ctsn")
    private String ctsn;
    @Column(name="handlerobj")
    private String handlerobj;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="jitctrlobj")
    private String jitctrlobj;
    @Column(name="jitctrlobj2")
    private String jitctrlobj2;
    @Column(name="jitmodelobj")
    private String jitmodelobj;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="paramobj")
    private String paramobj;
    @Column(name="paramobjint")
    private String paramobjint;
    @Column(name="psctrltypeid")
    private String psctrltypeid;
    @Column(name="psctrltypename")
    private String psctrltypename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;
    private Integer objPSCtrlTypeCallbacksLock = new Integer(1);
    private ArrayList<PSCtrlTypeCallback> psctrltypecallbacks = null;
    private Integer objPSCtrlTypeModelsLock = new Integer(1);
    private ArrayList<PSCtrlTypeModel> psctrltypemodels = null;
    private Integer objPSCtrlTypeMsgTagsLock = new Integer(1);
    private ArrayList<PSCtrlTypeMsgTag> psctrltypemsgtags = null;

    public void setAjaxCtrl(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAjaxCtrl(n);
            return;
        }
        this.ajaxctrl = n;
        this.ajaxctrlDirtyFlag = true;
    }

    public Integer getAjaxCtrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAjaxCtrl();
        }
        return this.ajaxctrl;
    }

    public boolean isAjaxCtrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAjaxCtrlDirty();
        }
        return this.ajaxctrlDirtyFlag;
    }

    public void resetAjaxCtrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAjaxCtrl();
            return;
        }
        this.ajaxctrlDirtyFlag = false;
        this.ajaxctrl = null;
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

    public void setCTFullSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCTFullSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctfullsn = string;
        this.ctfullsnDirtyFlag = true;
    }

    public String getCTFullSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCTFullSN();
        }
        return this.ctfullsn;
    }

    public boolean isCTFullSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCTFullSNDirty();
        }
        return this.ctfullsnDirtyFlag;
    }

    public void resetCTFullSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCTFullSN();
            return;
        }
        this.ctfullsnDirtyFlag = false;
        this.ctfullsn = null;
    }

    public void setCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlobj = string;
        this.ctrlobjDirtyFlag = true;
    }

    public String getCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlObj();
        }
        return this.ctrlobj;
    }

    public boolean isCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlObjDirty();
        }
        return this.ctrlobjDirtyFlag;
    }

    public void resetCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlObj();
            return;
        }
        this.ctrlobjDirtyFlag = false;
        this.ctrlobj = null;
    }

    public void setCtrlObjInt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlObjInt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlobjint = string;
        this.ctrlobjintDirtyFlag = true;
    }

    public String getCtrlObjInt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlObjInt();
        }
        return this.ctrlobjint;
    }

    public boolean isCtrlObjIntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlObjIntDirty();
        }
        return this.ctrlobjintDirtyFlag;
    }

    public void resetCtrlObjInt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlObjInt();
            return;
        }
        this.ctrlobjintDirtyFlag = false;
        this.ctrlobjint = null;
    }

    public void setCtrlTypeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlTypeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrltypeparams = string;
        this.ctrltypeparamsDirtyFlag = true;
    }

    public String getCtrlTypeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlTypeParams();
        }
        return this.ctrltypeparams;
    }

    public boolean isCtrlTypeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlTypeParamsDirty();
        }
        return this.ctrltypeparamsDirtyFlag;
    }

    public void resetCtrlTypeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlTypeParams();
            return;
        }
        this.ctrltypeparamsDirtyFlag = false;
        this.ctrltypeparams = null;
    }

    public void setCTSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCTSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctsn = string;
        this.ctsnDirtyFlag = true;
    }

    public String getCTSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCTSN();
        }
        return this.ctsn;
    }

    public boolean isCTSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCTSNDirty();
        }
        return this.ctsnDirtyFlag;
    }

    public void resetCTSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCTSN();
            return;
        }
        this.ctsnDirtyFlag = false;
        this.ctsn = null;
    }

    public void setHandlerObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHandlerObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.handlerobj = string;
        this.handlerobjDirtyFlag = true;
    }

    public String getHandlerObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHandlerObj();
        }
        return this.handlerobj;
    }

    public boolean isHandlerObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHandlerObjDirty();
        }
        return this.handlerobjDirtyFlag;
    }

    public void resetHandlerObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHandlerObj();
            return;
        }
        this.handlerobjDirtyFlag = false;
        this.handlerobj = null;
    }

    public void setIconPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconpath = string;
        this.iconpathDirtyFlag = true;
    }

    public String getIconPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconPath();
        }
        return this.iconpath;
    }

    public boolean isIconPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconPathDirty();
        }
        return this.iconpathDirtyFlag;
    }

    public void resetIconPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconPath();
            return;
        }
        this.iconpathDirtyFlag = false;
        this.iconpath = null;
    }

    public void setJITCtrlObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj = string;
        this.jitctrlobjDirtyFlag = true;
    }

    public String getJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj();
        }
        return this.jitctrlobj;
    }

    public boolean isJITCtrlObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObjDirty();
        }
        return this.jitctrlobjDirtyFlag;
    }

    public void resetJITCtrlObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj();
            return;
        }
        this.jitctrlobjDirtyFlag = false;
        this.jitctrlobj = null;
    }

    public void setJITCtrlObj2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITCtrlObj2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitctrlobj2 = string;
        this.jitctrlobj2DirtyFlag = true;
    }

    public String getJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITCtrlObj2();
        }
        return this.jitctrlobj2;
    }

    public boolean isJITCtrlObj2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITCtrlObj2Dirty();
        }
        return this.jitctrlobj2DirtyFlag;
    }

    public void resetJITCtrlObj2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITCtrlObj2();
            return;
        }
        this.jitctrlobj2DirtyFlag = false;
        this.jitctrlobj2 = null;
    }

    public void setJITModelObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITModelObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitmodelobj = string;
        this.jitmodelobjDirtyFlag = true;
    }

    public String getJITModelObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITModelObj();
        }
        return this.jitmodelobj;
    }

    public boolean isJITModelObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITModelObjDirty();
        }
        return this.jitmodelobjDirtyFlag;
    }

    public void resetJITModelObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITModelObj();
            return;
        }
        this.jitmodelobjDirtyFlag = false;
        this.jitmodelobj = null;
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

    public void setParamObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramobj = string;
        this.paramobjDirtyFlag = true;
    }

    public String getParamObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamObj();
        }
        return this.paramobj;
    }

    public boolean isParamObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamObjDirty();
        }
        return this.paramobjDirtyFlag;
    }

    public void resetParamObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamObj();
            return;
        }
        this.paramobjDirtyFlag = false;
        this.paramobj = null;
    }

    public void setParamObjInt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setParamObjInt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.paramobjint = string;
        this.paramobjintDirtyFlag = true;
    }

    public String getParamObjInt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getParamObjInt();
        }
        return this.paramobjint;
    }

    public boolean isParamObjIntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isParamObjIntDirty();
        }
        return this.paramobjintDirtyFlag;
    }

    public void resetParamObjInt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetParamObjInt();
            return;
        }
        this.paramobjintDirtyFlag = false;
        this.paramobjint = null;
    }

    public void setPSCtrlTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypeid = string;
        this.psctrltypeidDirtyFlag = true;
    }

    public String getPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeId();
        }
        return this.psctrltypeid;
    }

    public boolean isPSCtrlTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeIdDirty();
        }
        return this.psctrltypeidDirtyFlag;
    }

    public void resetPSCtrlTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeId();
            return;
        }
        this.psctrltypeidDirtyFlag = false;
        this.psctrltypeid = null;
    }

    public void setPSCtrlTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCtrlTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psctrltypename = string;
        this.psctrltypenameDirtyFlag = true;
    }

    public String getPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeName();
        }
        return this.psctrltypename;
    }

    public boolean isPSCtrlTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCtrlTypeNameDirty();
        }
        return this.psctrltypenameDirtyFlag;
    }

    public void resetPSCtrlTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCtrlTypeName();
            return;
        }
        this.psctrltypenameDirtyFlag = false;
        this.psctrltypename = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
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
        PSCtrlTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCtrlTypeBase pSCtrlTypeBase) {
        pSCtrlTypeBase.resetAjaxCtrl();
        pSCtrlTypeBase.resetCreateDate();
        pSCtrlTypeBase.resetCreateMan();
        pSCtrlTypeBase.resetCTFullSN();
        pSCtrlTypeBase.resetCtrlObj();
        pSCtrlTypeBase.resetCtrlObjInt();
        pSCtrlTypeBase.resetCtrlTypeParams();
        pSCtrlTypeBase.resetCTSN();
        pSCtrlTypeBase.resetHandlerObj();
        pSCtrlTypeBase.resetIconPath();
        pSCtrlTypeBase.resetJITCtrlObj();
        pSCtrlTypeBase.resetJITCtrlObj2();
        pSCtrlTypeBase.resetJITModelObj();
        pSCtrlTypeBase.resetMemo();
        pSCtrlTypeBase.resetOrderValue();
        pSCtrlTypeBase.resetParamObj();
        pSCtrlTypeBase.resetParamObjInt();
        pSCtrlTypeBase.resetPSCtrlTypeId();
        pSCtrlTypeBase.resetPSCtrlTypeName();
        pSCtrlTypeBase.resetPSModelId();
        pSCtrlTypeBase.resetPSModelName();
        pSCtrlTypeBase.resetTypeObj();
        pSCtrlTypeBase.resetUpdateDate();
        pSCtrlTypeBase.resetUpdateMan();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAjaxCtrlDirty()) {
            hashMap.put(FIELD_AJAXCTRL, this.getAjaxCtrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCTFullSNDirty()) {
            hashMap.put(FIELD_CTFULLSN, this.getCTFullSN());
        }
        if (!bl || this.isCtrlObjDirty()) {
            hashMap.put(FIELD_CTRLOBJ, this.getCtrlObj());
        }
        if (!bl || this.isCtrlObjIntDirty()) {
            hashMap.put(FIELD_CTRLOBJINT, this.getCtrlObjInt());
        }
        if (!bl || this.isCtrlTypeParamsDirty()) {
            hashMap.put(FIELD_CTRLTYPEPARAMS, this.getCtrlTypeParams());
        }
        if (!bl || this.isCTSNDirty()) {
            hashMap.put(FIELD_CTSN, this.getCTSN());
        }
        if (!bl || this.isHandlerObjDirty()) {
            hashMap.put(FIELD_HANDLEROBJ, this.getHandlerObj());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isJITCtrlObjDirty()) {
            hashMap.put(FIELD_JITCTRLOBJ, this.getJITCtrlObj());
        }
        if (!bl || this.isJITCtrlObj2Dirty()) {
            hashMap.put(FIELD_JITCTRLOBJ2, this.getJITCtrlObj2());
        }
        if (!bl || this.isJITModelObjDirty()) {
            hashMap.put(FIELD_JITMODELOBJ, this.getJITModelObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isParamObjDirty()) {
            hashMap.put(FIELD_PARAMOBJ, this.getParamObj());
        }
        if (!bl || this.isParamObjIntDirty()) {
            hashMap.put(FIELD_PARAMOBJINT, this.getParamObjInt());
        }
        if (!bl || this.isPSCtrlTypeIdDirty()) {
            hashMap.put(FIELD_PSCTRLTYPEID, this.getPSCtrlTypeId());
        }
        if (!bl || this.isPSCtrlTypeNameDirty()) {
            hashMap.put(FIELD_PSCTRLTYPENAME, this.getPSCtrlTypeName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
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
        return PSCtrlTypeBase.get(this, n);
    }

    private static Object get(PSCtrlTypeBase pSCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeBase.getAjaxCtrl();
            }
            case 1: {
                return pSCtrlTypeBase.getCreateDate();
            }
            case 2: {
                return pSCtrlTypeBase.getCreateMan();
            }
            case 3: {
                return pSCtrlTypeBase.getCTFullSN();
            }
            case 4: {
                return pSCtrlTypeBase.getCtrlObj();
            }
            case 5: {
                return pSCtrlTypeBase.getCtrlObjInt();
            }
            case 6: {
                return pSCtrlTypeBase.getCtrlTypeParams();
            }
            case 7: {
                return pSCtrlTypeBase.getCTSN();
            }
            case 8: {
                return pSCtrlTypeBase.getHandlerObj();
            }
            case 9: {
                return pSCtrlTypeBase.getIconPath();
            }
            case 10: {
                return pSCtrlTypeBase.getJITCtrlObj();
            }
            case 11: {
                return pSCtrlTypeBase.getJITCtrlObj2();
            }
            case 12: {
                return pSCtrlTypeBase.getJITModelObj();
            }
            case 13: {
                return pSCtrlTypeBase.getMemo();
            }
            case 14: {
                return pSCtrlTypeBase.getOrderValue();
            }
            case 15: {
                return pSCtrlTypeBase.getParamObj();
            }
            case 16: {
                return pSCtrlTypeBase.getParamObjInt();
            }
            case 17: {
                return pSCtrlTypeBase.getPSCtrlTypeId();
            }
            case 18: {
                return pSCtrlTypeBase.getPSCtrlTypeName();
            }
            case 19: {
                return pSCtrlTypeBase.getPSModelId();
            }
            case 20: {
                return pSCtrlTypeBase.getPSModelName();
            }
            case 21: {
                return pSCtrlTypeBase.getTypeObj();
            }
            case 22: {
                return pSCtrlTypeBase.getUpdateDate();
            }
            case 23: {
                return pSCtrlTypeBase.getUpdateMan();
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
        PSCtrlTypeBase.set(this, n, object);
    }

    private static void set(PSCtrlTypeBase pSCtrlTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeBase.setAjaxCtrl(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSCtrlTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSCtrlTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCtrlTypeBase.setCTFullSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCtrlTypeBase.setCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCtrlTypeBase.setCtrlObjInt(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSCtrlTypeBase.setCtrlTypeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCtrlTypeBase.setCTSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCtrlTypeBase.setHandlerObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCtrlTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSCtrlTypeBase.setJITCtrlObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSCtrlTypeBase.setJITCtrlObj2(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSCtrlTypeBase.setJITModelObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSCtrlTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCtrlTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSCtrlTypeBase.setParamObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSCtrlTypeBase.setParamObjInt(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCtrlTypeBase.setPSCtrlTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSCtrlTypeBase.setPSCtrlTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCtrlTypeBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSCtrlTypeBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCtrlTypeBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCtrlTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 23: {
                pSCtrlTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
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
        return PSCtrlTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSCtrlTypeBase pSCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeBase.getAjaxCtrl() == null;
            }
            case 1: {
                return pSCtrlTypeBase.getCreateDate() == null;
            }
            case 2: {
                return pSCtrlTypeBase.getCreateMan() == null;
            }
            case 3: {
                return pSCtrlTypeBase.getCTFullSN() == null;
            }
            case 4: {
                return pSCtrlTypeBase.getCtrlObj() == null;
            }
            case 5: {
                return pSCtrlTypeBase.getCtrlObjInt() == null;
            }
            case 6: {
                return pSCtrlTypeBase.getCtrlTypeParams() == null;
            }
            case 7: {
                return pSCtrlTypeBase.getCTSN() == null;
            }
            case 8: {
                return pSCtrlTypeBase.getHandlerObj() == null;
            }
            case 9: {
                return pSCtrlTypeBase.getIconPath() == null;
            }
            case 10: {
                return pSCtrlTypeBase.getJITCtrlObj() == null;
            }
            case 11: {
                return pSCtrlTypeBase.getJITCtrlObj2() == null;
            }
            case 12: {
                return pSCtrlTypeBase.getJITModelObj() == null;
            }
            case 13: {
                return pSCtrlTypeBase.getMemo() == null;
            }
            case 14: {
                return pSCtrlTypeBase.getOrderValue() == null;
            }
            case 15: {
                return pSCtrlTypeBase.getParamObj() == null;
            }
            case 16: {
                return pSCtrlTypeBase.getParamObjInt() == null;
            }
            case 17: {
                return pSCtrlTypeBase.getPSCtrlTypeId() == null;
            }
            case 18: {
                return pSCtrlTypeBase.getPSCtrlTypeName() == null;
            }
            case 19: {
                return pSCtrlTypeBase.getPSModelId() == null;
            }
            case 20: {
                return pSCtrlTypeBase.getPSModelName() == null;
            }
            case 21: {
                return pSCtrlTypeBase.getTypeObj() == null;
            }
            case 22: {
                return pSCtrlTypeBase.getUpdateDate() == null;
            }
            case 23: {
                return pSCtrlTypeBase.getUpdateMan() == null;
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
        return PSCtrlTypeBase.contains(this, n);
    }

    private static boolean contains(PSCtrlTypeBase pSCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCtrlTypeBase.isAjaxCtrlDirty();
            }
            case 1: {
                return pSCtrlTypeBase.isCreateDateDirty();
            }
            case 2: {
                return pSCtrlTypeBase.isCreateManDirty();
            }
            case 3: {
                return pSCtrlTypeBase.isCTFullSNDirty();
            }
            case 4: {
                return pSCtrlTypeBase.isCtrlObjDirty();
            }
            case 5: {
                return pSCtrlTypeBase.isCtrlObjIntDirty();
            }
            case 6: {
                return pSCtrlTypeBase.isCtrlTypeParamsDirty();
            }
            case 7: {
                return pSCtrlTypeBase.isCTSNDirty();
            }
            case 8: {
                return pSCtrlTypeBase.isHandlerObjDirty();
            }
            case 9: {
                return pSCtrlTypeBase.isIconPathDirty();
            }
            case 10: {
                return pSCtrlTypeBase.isJITCtrlObjDirty();
            }
            case 11: {
                return pSCtrlTypeBase.isJITCtrlObj2Dirty();
            }
            case 12: {
                return pSCtrlTypeBase.isJITModelObjDirty();
            }
            case 13: {
                return pSCtrlTypeBase.isMemoDirty();
            }
            case 14: {
                return pSCtrlTypeBase.isOrderValueDirty();
            }
            case 15: {
                return pSCtrlTypeBase.isParamObjDirty();
            }
            case 16: {
                return pSCtrlTypeBase.isParamObjIntDirty();
            }
            case 17: {
                return pSCtrlTypeBase.isPSCtrlTypeIdDirty();
            }
            case 18: {
                return pSCtrlTypeBase.isPSCtrlTypeNameDirty();
            }
            case 19: {
                return pSCtrlTypeBase.isPSModelIdDirty();
            }
            case 20: {
                return pSCtrlTypeBase.isPSModelNameDirty();
            }
            case 21: {
                return pSCtrlTypeBase.isTypeObjDirty();
            }
            case 22: {
                return pSCtrlTypeBase.isUpdateDateDirty();
            }
            case 23: {
                return pSCtrlTypeBase.isUpdateManDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCtrlTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCtrlTypeBase pSCtrlTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCtrlTypeBase.getAjaxCtrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ajaxctrl", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getAjaxCtrl()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCTFullSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctfullsn", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCTFullSN()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCtrlObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCtrlObjInt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlobjint", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCtrlObjInt()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCtrlTypeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrltypeparams", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCtrlTypeParams()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getCTSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctsn", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getCTSN()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getHandlerObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"handlerobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getHandlerObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getJITCtrlObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getJITCtrlObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getJITCtrlObj2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitctrlobj2", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getJITCtrlObj2()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getJITModelObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitmodelobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getJITModelObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getParamObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getParamObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getParamObjInt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"paramobjint", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getParamObjInt()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getPSCtrlTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypeid", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getPSCtrlTypeId()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getPSCtrlTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psctrltypename", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getPSCtrlTypeName()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCtrlTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCtrlTypeBase.getJSONValue((Object)pSCtrlTypeBase.getUpdateMan()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCtrlTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCtrlTypeBase pSCtrlTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCtrlTypeBase.getAjaxCtrl() != null) {
            object = pSCtrlTypeBase.getAjaxCtrl();
            xmlNode.setAttribute(FIELD_AJAXCTRL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeBase.getCreateDate() != null) {
            object = pSCtrlTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeBase.getCreateMan() != null) {
            object = pSCtrlTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getCTFullSN() != null) {
            object = pSCtrlTypeBase.getCTFullSN();
            xmlNode.setAttribute(FIELD_CTFULLSN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getCtrlObj() != null) {
            object = pSCtrlTypeBase.getCtrlObj();
            xmlNode.setAttribute(FIELD_CTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getCtrlObjInt() != null) {
            object = pSCtrlTypeBase.getCtrlObjInt();
            xmlNode.setAttribute(FIELD_CTRLOBJINT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getCtrlTypeParams() != null) {
            object = pSCtrlTypeBase.getCtrlTypeParams();
            xmlNode.setAttribute(FIELD_CTRLTYPEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getCTSN() != null) {
            object = pSCtrlTypeBase.getCTSN();
            xmlNode.setAttribute(FIELD_CTSN, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getHandlerObj() != null) {
            object = pSCtrlTypeBase.getHandlerObj();
            xmlNode.setAttribute(FIELD_HANDLEROBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getIconPath() != null) {
            object = pSCtrlTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getJITCtrlObj() != null) {
            object = pSCtrlTypeBase.getJITCtrlObj();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getJITCtrlObj2() != null) {
            object = pSCtrlTypeBase.getJITCtrlObj2();
            xmlNode.setAttribute(FIELD_JITCTRLOBJ2, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getJITModelObj() != null) {
            object = pSCtrlTypeBase.getJITModelObj();
            xmlNode.setAttribute(FIELD_JITMODELOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getMemo() != null) {
            object = pSCtrlTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getOrderValue() != null) {
            object = pSCtrlTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCtrlTypeBase.getParamObj() != null) {
            object = pSCtrlTypeBase.getParamObj();
            xmlNode.setAttribute(FIELD_PARAMOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getParamObjInt() != null) {
            object = pSCtrlTypeBase.getParamObjInt();
            xmlNode.setAttribute(FIELD_PARAMOBJINT, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getPSCtrlTypeId() != null) {
            object = pSCtrlTypeBase.getPSCtrlTypeId();
            xmlNode.setAttribute(FIELD_PSCTRLTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getPSCtrlTypeName() != null) {
            object = pSCtrlTypeBase.getPSCtrlTypeName();
            xmlNode.setAttribute(FIELD_PSCTRLTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getPSModelId() != null) {
            object = pSCtrlTypeBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getPSModelName() != null) {
            object = pSCtrlTypeBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getTypeObj() != null) {
            object = pSCtrlTypeBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSCtrlTypeBase.getUpdateDate() != null) {
            object = pSCtrlTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCtrlTypeBase.getUpdateMan() != null) {
            object = pSCtrlTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCtrlTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCtrlTypeBase pSCtrlTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCtrlTypeBase.isAjaxCtrlDirty() && (bl || pSCtrlTypeBase.getAjaxCtrl() != null)) {
            iDataObject.set(FIELD_AJAXCTRL, (Object)pSCtrlTypeBase.getAjaxCtrl());
        }
        if (pSCtrlTypeBase.isCreateDateDirty() && (bl || pSCtrlTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCtrlTypeBase.getCreateDate());
        }
        if (pSCtrlTypeBase.isCreateManDirty() && (bl || pSCtrlTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCtrlTypeBase.getCreateMan());
        }
        if (pSCtrlTypeBase.isCTFullSNDirty() && (bl || pSCtrlTypeBase.getCTFullSN() != null)) {
            iDataObject.set(FIELD_CTFULLSN, (Object)pSCtrlTypeBase.getCTFullSN());
        }
        if (pSCtrlTypeBase.isCtrlObjDirty() && (bl || pSCtrlTypeBase.getCtrlObj() != null)) {
            iDataObject.set(FIELD_CTRLOBJ, (Object)pSCtrlTypeBase.getCtrlObj());
        }
        if (pSCtrlTypeBase.isCtrlObjIntDirty() && (bl || pSCtrlTypeBase.getCtrlObjInt() != null)) {
            iDataObject.set(FIELD_CTRLOBJINT, (Object)pSCtrlTypeBase.getCtrlObjInt());
        }
        if (pSCtrlTypeBase.isCtrlTypeParamsDirty() && (bl || pSCtrlTypeBase.getCtrlTypeParams() != null)) {
            iDataObject.set(FIELD_CTRLTYPEPARAMS, (Object)pSCtrlTypeBase.getCtrlTypeParams());
        }
        if (pSCtrlTypeBase.isCTSNDirty() && (bl || pSCtrlTypeBase.getCTSN() != null)) {
            iDataObject.set(FIELD_CTSN, (Object)pSCtrlTypeBase.getCTSN());
        }
        if (pSCtrlTypeBase.isHandlerObjDirty() && (bl || pSCtrlTypeBase.getHandlerObj() != null)) {
            iDataObject.set(FIELD_HANDLEROBJ, (Object)pSCtrlTypeBase.getHandlerObj());
        }
        if (pSCtrlTypeBase.isIconPathDirty() && (bl || pSCtrlTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSCtrlTypeBase.getIconPath());
        }
        if (pSCtrlTypeBase.isJITCtrlObjDirty() && (bl || pSCtrlTypeBase.getJITCtrlObj() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ, (Object)pSCtrlTypeBase.getJITCtrlObj());
        }
        if (pSCtrlTypeBase.isJITCtrlObj2Dirty() && (bl || pSCtrlTypeBase.getJITCtrlObj2() != null)) {
            iDataObject.set(FIELD_JITCTRLOBJ2, (Object)pSCtrlTypeBase.getJITCtrlObj2());
        }
        if (pSCtrlTypeBase.isJITModelObjDirty() && (bl || pSCtrlTypeBase.getJITModelObj() != null)) {
            iDataObject.set(FIELD_JITMODELOBJ, (Object)pSCtrlTypeBase.getJITModelObj());
        }
        if (pSCtrlTypeBase.isMemoDirty() && (bl || pSCtrlTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCtrlTypeBase.getMemo());
        }
        if (pSCtrlTypeBase.isOrderValueDirty() && (bl || pSCtrlTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCtrlTypeBase.getOrderValue());
        }
        if (pSCtrlTypeBase.isParamObjDirty() && (bl || pSCtrlTypeBase.getParamObj() != null)) {
            iDataObject.set(FIELD_PARAMOBJ, (Object)pSCtrlTypeBase.getParamObj());
        }
        if (pSCtrlTypeBase.isParamObjIntDirty() && (bl || pSCtrlTypeBase.getParamObjInt() != null)) {
            iDataObject.set(FIELD_PARAMOBJINT, (Object)pSCtrlTypeBase.getParamObjInt());
        }
        if (pSCtrlTypeBase.isPSCtrlTypeIdDirty() && (bl || pSCtrlTypeBase.getPSCtrlTypeId() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPEID, (Object)pSCtrlTypeBase.getPSCtrlTypeId());
        }
        if (pSCtrlTypeBase.isPSCtrlTypeNameDirty() && (bl || pSCtrlTypeBase.getPSCtrlTypeName() != null)) {
            iDataObject.set(FIELD_PSCTRLTYPENAME, (Object)pSCtrlTypeBase.getPSCtrlTypeName());
        }
        if (pSCtrlTypeBase.isPSModelIdDirty() && (bl || pSCtrlTypeBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSCtrlTypeBase.getPSModelId());
        }
        if (pSCtrlTypeBase.isPSModelNameDirty() && (bl || pSCtrlTypeBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSCtrlTypeBase.getPSModelName());
        }
        if (pSCtrlTypeBase.isTypeObjDirty() && (bl || pSCtrlTypeBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSCtrlTypeBase.getTypeObj());
        }
        if (pSCtrlTypeBase.isUpdateDateDirty() && (bl || pSCtrlTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCtrlTypeBase.getUpdateDate());
        }
        if (pSCtrlTypeBase.isUpdateManDirty() && (bl || pSCtrlTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCtrlTypeBase.getUpdateMan());
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
        return PSCtrlTypeBase.remove(this, n);
    }

    private static boolean remove(PSCtrlTypeBase pSCtrlTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCtrlTypeBase.resetAjaxCtrl();
                return true;
            }
            case 1: {
                pSCtrlTypeBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSCtrlTypeBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSCtrlTypeBase.resetCTFullSN();
                return true;
            }
            case 4: {
                pSCtrlTypeBase.resetCtrlObj();
                return true;
            }
            case 5: {
                pSCtrlTypeBase.resetCtrlObjInt();
                return true;
            }
            case 6: {
                pSCtrlTypeBase.resetCtrlTypeParams();
                return true;
            }
            case 7: {
                pSCtrlTypeBase.resetCTSN();
                return true;
            }
            case 8: {
                pSCtrlTypeBase.resetHandlerObj();
                return true;
            }
            case 9: {
                pSCtrlTypeBase.resetIconPath();
                return true;
            }
            case 10: {
                pSCtrlTypeBase.resetJITCtrlObj();
                return true;
            }
            case 11: {
                pSCtrlTypeBase.resetJITCtrlObj2();
                return true;
            }
            case 12: {
                pSCtrlTypeBase.resetJITModelObj();
                return true;
            }
            case 13: {
                pSCtrlTypeBase.resetMemo();
                return true;
            }
            case 14: {
                pSCtrlTypeBase.resetOrderValue();
                return true;
            }
            case 15: {
                pSCtrlTypeBase.resetParamObj();
                return true;
            }
            case 16: {
                pSCtrlTypeBase.resetParamObjInt();
                return true;
            }
            case 17: {
                pSCtrlTypeBase.resetPSCtrlTypeId();
                return true;
            }
            case 18: {
                pSCtrlTypeBase.resetPSCtrlTypeName();
                return true;
            }
            case 19: {
                pSCtrlTypeBase.resetPSModelId();
                return true;
            }
            case 20: {
                pSCtrlTypeBase.resetPSModelName();
                return true;
            }
            case 21: {
                pSCtrlTypeBase.resetTypeObj();
                return true;
            }
            case 22: {
                pSCtrlTypeBase.resetUpdateDate();
                return true;
            }
            case 23: {
                pSCtrlTypeBase.resetUpdateMan();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlTypeCallback> getPSCtrlTypeCallbacks() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeCallbacks();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        PSCtrlTypeCallbackService pSCtrlTypeCallbackService = (PSCtrlTypeCallbackService)ServiceGlobal.getService(PSCtrlTypeCallbackService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlTypeCallbacksLock;
        synchronized (n) {
            if (this.psctrltypecallbacks == null) {
                this.psctrltypecallbacks = pSCtrlTypeCallbackService.selectByPSCtrlType(this);
            }
            return this.psctrltypecallbacks;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlTypeModel> getPSCtrlTypeModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeModels();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        PSCtrlTypeModelService pSCtrlTypeModelService = (PSCtrlTypeModelService)ServiceGlobal.getService(PSCtrlTypeModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlTypeModelsLock;
        synchronized (n) {
            if (this.psctrltypemodels == null) {
                this.psctrltypemodels = pSCtrlTypeModelService.selectByPSCtrlType(this);
            }
            return this.psctrltypemodels;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCtrlTypeMsgTag> getPSCtrlTypeMsgTags() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCtrlTypeMsgTags();
        }
        if (this.getPSCtrlTypeId() == null) {
            return null;
        }
        PSCtrlTypeMsgTagService pSCtrlTypeMsgTagService = (PSCtrlTypeMsgTagService)ServiceGlobal.getService(PSCtrlTypeMsgTagService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCtrlTypeMsgTagsLock;
        synchronized (n) {
            if (this.psctrltypemsgtags == null) {
                this.psctrltypemsgtags = pSCtrlTypeMsgTagService.selectByPSCtrlType(this);
            }
            return this.psctrltypemsgtags;
        }
    }

    private PSCtrlTypeBase getProxyEntity() {
        return this.proxyPSCtrlTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCtrlTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSCtrlTypeBase) {
            this.proxyPSCtrlTypeBase = (PSCtrlTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSCtrlTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AJAXCTRL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTFULLSN, 3);
        fieldIndexMap.put(FIELD_CTRLOBJ, 4);
        fieldIndexMap.put(FIELD_CTRLOBJINT, 5);
        fieldIndexMap.put(FIELD_CTRLTYPEPARAMS, 6);
        fieldIndexMap.put(FIELD_CTSN, 7);
        fieldIndexMap.put(FIELD_HANDLEROBJ, 8);
        fieldIndexMap.put(FIELD_ICONPATH, 9);
        fieldIndexMap.put(FIELD_JITCTRLOBJ, 10);
        fieldIndexMap.put(FIELD_JITCTRLOBJ2, 11);
        fieldIndexMap.put(FIELD_JITMODELOBJ, 12);
        fieldIndexMap.put(FIELD_MEMO, 13);
        fieldIndexMap.put(FIELD_ORDERVALUE, 14);
        fieldIndexMap.put(FIELD_PARAMOBJ, 15);
        fieldIndexMap.put(FIELD_PARAMOBJINT, 16);
        fieldIndexMap.put(FIELD_PSCTRLTYPEID, 17);
        fieldIndexMap.put(FIELD_PSCTRLTYPENAME, 18);
        fieldIndexMap.put(FIELD_PSMODELID, 19);
        fieldIndexMap.put(FIELD_PSMODELNAME, 20);
        fieldIndexMap.put(FIELD_TYPEOBJ, 21);
        fieldIndexMap.put(FIELD_UPDATEDATE, 22);
        fieldIndexMap.put(FIELD_UPDATEMAN, 23);
    }
}

