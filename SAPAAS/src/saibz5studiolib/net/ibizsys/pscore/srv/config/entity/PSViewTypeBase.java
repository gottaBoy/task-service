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
import net.ibizsys.pscore.srv.config.entity.PSVTCtrl;
import net.ibizsys.pscore.srv.config.entity.PSVTRV;
import net.ibizsys.pscore.srv.config.entity.PSVTSample;
import net.ibizsys.pscore.srv.config.entity.PSViewEngine;
import net.ibizsys.pscore.srv.config.entity.PSViewTypeLogic;
import net.ibizsys.pscore.srv.config.service.PSVTCtrlService;
import net.ibizsys.pscore.srv.config.service.PSVTRVService;
import net.ibizsys.pscore.srv.config.service.PSVTSampleService;
import net.ibizsys.pscore.srv.config.service.PSViewEngineService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeLogicService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSViewTypeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSViewTypeBase.class);
    public static final String FIELD_APPVIEWOBJ = "APPVIEWOBJ";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DESCURL = "DESCURL";
    public static final String FIELD_DEVIEWMODE = "DEVIEWMODE";
    public static final String FIELD_DEVIEWOBJ = "DEVIEWOBJ";
    public static final String FIELD_EMBEDVIEWFLAG = "EMBEDVIEWFLAG";
    public static final String FIELD_ENABLEDYNATOOL = "ENABLEDYNATOOL";
    public static final String FIELD_ICONPATH = "ICONPATH";
    public static final String FIELD_LAYOUTMODEL = "LAYOUTMODEL";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSVIEWENGINEID = "PSVIEWENGINEID";
    public static final String FIELD_PSVIEWENGINENAME = "PSVIEWENGINENAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWOBJINT = "VIEWOBJINT";
    public static final String FIELD_VTFULLSN = "VTFULLSN";
    public static final String FIELD_VTSN = "VTSN";
    private static final int INDEX_APPVIEWOBJ = 0;
    private static final int INDEX_CODENAME = 1;
    private static final int INDEX_COLOR = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_DESCURL = 5;
    private static final int INDEX_DEVIEWMODE = 6;
    private static final int INDEX_DEVIEWOBJ = 7;
    private static final int INDEX_EMBEDVIEWFLAG = 8;
    private static final int INDEX_ENABLEDYNATOOL = 9;
    private static final int INDEX_ICONPATH = 10;
    private static final int INDEX_LAYOUTMODEL = 11;
    private static final int INDEX_MEMO = 12;
    private static final int INDEX_ORDERVALUE = 13;
    private static final int INDEX_PSVIEWENGINEID = 14;
    private static final int INDEX_PSVIEWENGINENAME = 15;
    private static final int INDEX_PSVIEWTYPEID = 16;
    private static final int INDEX_PSVIEWTYPENAME = 17;
    private static final int INDEX_TITLE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USERCAT = 21;
    private static final int INDEX_USERTAG = 22;
    private static final int INDEX_USERTAG2 = 23;
    private static final int INDEX_USERTAG3 = 24;
    private static final int INDEX_USERTAG4 = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final int INDEX_VIEWOBJINT = 27;
    private static final int INDEX_VTFULLSN = 28;
    private static final int INDEX_VTSN = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSViewTypeBase proxyPSViewTypeBase = null;
    private boolean appviewobjDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean descurlDirtyFlag = false;
    private boolean deviewmodeDirtyFlag = false;
    private boolean deviewobjDirtyFlag = false;
    private boolean embedviewflagDirtyFlag = false;
    private boolean enabledynatoolDirtyFlag = false;
    private boolean iconpathDirtyFlag = false;
    private boolean layoutmodelDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psviewengineidDirtyFlag = false;
    private boolean psviewenginenameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewobjintDirtyFlag = false;
    private boolean vtfullsnDirtyFlag = false;
    private boolean vtsnDirtyFlag = false;
    @Column(name="appviewobj")
    private String appviewobj;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="descurl")
    private String descurl;
    @Column(name="deviewmode")
    private Integer deviewmode;
    @Column(name="deviewobj")
    private String deviewobj;
    @Column(name="embedviewflag")
    private Integer embedviewflag;
    @Column(name="enabledynatool")
    private Integer enabledynatool;
    @Column(name="iconpath")
    private String iconpath;
    @Column(name="layoutmodel")
    private String layoutmodel;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psviewengineid")
    private String psviewengineid;
    @Column(name="psviewenginename")
    private String psviewenginename;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="title")
    private String title;
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
    @Column(name="viewobjint")
    private String viewobjint;
    @Column(name="vtfullsn")
    private String vtfullsn;
    @Column(name="vtsn")
    private String vtsn;
    private Integer objPSViewEngineLock = new Integer(1);
    private PSViewEngine psviewengine = null;
    private Integer objPSViewTypeLogicsLock = new Integer(1);
    private ArrayList<PSViewTypeLogic> psviewtypelogics = null;
    private Integer objPSVTCtrlsLock = new Integer(1);
    private ArrayList<PSVTCtrl> psvtctrls = null;
    private Integer objPSVTRVsLock = new Integer(1);
    private ArrayList<PSVTRV> psvtrvs = null;
    private Integer objPSVTSamplesLock = new Integer(1);
    private ArrayList<PSVTSample> psvtsamples = null;

    public void setAppViewObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppViewObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.appviewobj = string;
        this.appviewobjDirtyFlag = true;
    }

    public String getAppViewObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppViewObj();
        }
        return this.appviewobj;
    }

    public boolean isAppViewObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppViewObjDirty();
        }
        return this.appviewobjDirtyFlag;
    }

    public void resetAppViewObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppViewObj();
            return;
        }
        this.appviewobjDirtyFlag = false;
        this.appviewobj = null;
    }

    public void setCodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codename = string;
        this.codenameDirtyFlag = true;
    }

    public String getCodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeName();
        }
        return this.codename;
    }

    public boolean isCodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeNameDirty();
        }
        return this.codenameDirtyFlag;
    }

    public void resetCodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeName();
            return;
        }
        this.codenameDirtyFlag = false;
        this.codename = null;
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

    public void setDescURL(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDescURL(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.descurl = string;
        this.descurlDirtyFlag = true;
    }

    public String getDescURL() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDescURL();
        }
        return this.descurl;
    }

    public boolean isDescURLDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDescURLDirty();
        }
        return this.descurlDirtyFlag;
    }

    public void resetDescURL() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDescURL();
            return;
        }
        this.descurlDirtyFlag = false;
        this.descurl = null;
    }

    public void setDEViewMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewMode(n);
            return;
        }
        this.deviewmode = n;
        this.deviewmodeDirtyFlag = true;
    }

    public Integer getDEViewMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewMode();
        }
        return this.deviewmode;
    }

    public boolean isDEViewModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewModeDirty();
        }
        return this.deviewmodeDirtyFlag;
    }

    public void resetDEViewMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewMode();
            return;
        }
        this.deviewmodeDirtyFlag = false;
        this.deviewmode = null;
    }

    public void setDEViewObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDEViewObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.deviewobj = string;
        this.deviewobjDirtyFlag = true;
    }

    public String getDEViewObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDEViewObj();
        }
        return this.deviewobj;
    }

    public boolean isDEViewObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDEViewObjDirty();
        }
        return this.deviewobjDirtyFlag;
    }

    public void resetDEViewObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDEViewObj();
            return;
        }
        this.deviewobjDirtyFlag = false;
        this.deviewobj = null;
    }

    public void setEmbedViewFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEmbedViewFlag(n);
            return;
        }
        this.embedviewflag = n;
        this.embedviewflagDirtyFlag = true;
    }

    public Integer getEmbedViewFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEmbedViewFlag();
        }
        return this.embedviewflag;
    }

    public boolean isEmbedViewFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEmbedViewFlagDirty();
        }
        return this.embedviewflagDirtyFlag;
    }

    public void resetEmbedViewFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEmbedViewFlag();
            return;
        }
        this.embedviewflagDirtyFlag = false;
        this.embedviewflag = null;
    }

    public void setEnableDynaTool(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDynaTool(n);
            return;
        }
        this.enabledynatool = n;
        this.enabledynatoolDirtyFlag = true;
    }

    public Integer getEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDynaTool();
        }
        return this.enabledynatool;
    }

    public boolean isEnableDynaToolDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDynaToolDirty();
        }
        return this.enabledynatoolDirtyFlag;
    }

    public void resetEnableDynaTool() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDynaTool();
            return;
        }
        this.enabledynatoolDirtyFlag = false;
        this.enabledynatool = null;
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

    public void setLayoutModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmodel = string;
        this.layoutmodelDirtyFlag = true;
    }

    public String getLayoutModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutModel();
        }
        return this.layoutmodel;
    }

    public boolean isLayoutModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModelDirty();
        }
        return this.layoutmodelDirtyFlag;
    }

    public void resetLayoutModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutModel();
            return;
        }
        this.layoutmodelDirtyFlag = false;
        this.layoutmodel = null;
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

    public void setPSViewEngineId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewengineid = string;
        this.psviewengineidDirtyFlag = true;
    }

    public String getPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineId();
        }
        return this.psviewengineid;
    }

    public boolean isPSViewEngineIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineIdDirty();
        }
        return this.psviewengineidDirtyFlag;
    }

    public void resetPSViewEngineId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineId();
            return;
        }
        this.psviewengineidDirtyFlag = false;
        this.psviewengineid = null;
    }

    public void setPSViewEngineName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewEngineName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewenginename = string;
        this.psviewenginenameDirtyFlag = true;
    }

    public String getPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngineName();
        }
        return this.psviewenginename;
    }

    public boolean isPSViewEngineNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewEngineNameDirty();
        }
        return this.psviewenginenameDirtyFlag;
    }

    public void resetPSViewEngineName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewEngineName();
            return;
        }
        this.psviewenginenameDirtyFlag = false;
        this.psviewenginename = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
    }

    public void setTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.title = string;
        this.titleDirtyFlag = true;
    }

    public String getTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitle();
        }
        return this.title;
    }

    public boolean isTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleDirty();
        }
        return this.titleDirtyFlag;
    }

    public void resetTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitle();
            return;
        }
        this.titleDirtyFlag = false;
        this.title = null;
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

    public void setViewObjInt(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewObjInt(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewobjint = string;
        this.viewobjintDirtyFlag = true;
    }

    public String getViewObjInt() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewObjInt();
        }
        return this.viewobjint;
    }

    public boolean isViewObjIntDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewObjIntDirty();
        }
        return this.viewobjintDirtyFlag;
    }

    public void resetViewObjInt() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewObjInt();
            return;
        }
        this.viewobjintDirtyFlag = false;
        this.viewobjint = null;
    }

    public void setVTFullSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVTFullSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vtfullsn = string;
        this.vtfullsnDirtyFlag = true;
    }

    public String getVTFullSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVTFullSN();
        }
        return this.vtfullsn;
    }

    public boolean isVTFullSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVTFullSNDirty();
        }
        return this.vtfullsnDirtyFlag;
    }

    public void resetVTFullSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVTFullSN();
            return;
        }
        this.vtfullsnDirtyFlag = false;
        this.vtfullsn = null;
    }

    public void setVTSN(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVTSN(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vtsn = string;
        this.vtsnDirtyFlag = true;
    }

    public String getVTSN() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVTSN();
        }
        return this.vtsn;
    }

    public boolean isVTSNDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVTSNDirty();
        }
        return this.vtsnDirtyFlag;
    }

    public void resetVTSN() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVTSN();
            return;
        }
        this.vtsnDirtyFlag = false;
        this.vtsn = null;
    }

    protected void onReset() {
        PSViewTypeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSViewTypeBase pSViewTypeBase) {
        pSViewTypeBase.resetAppViewObj();
        pSViewTypeBase.resetCodeName();
        pSViewTypeBase.resetColor();
        pSViewTypeBase.resetCreateDate();
        pSViewTypeBase.resetCreateMan();
        pSViewTypeBase.resetDescURL();
        pSViewTypeBase.resetDEViewMode();
        pSViewTypeBase.resetDEViewObj();
        pSViewTypeBase.resetEmbedViewFlag();
        pSViewTypeBase.resetEnableDynaTool();
        pSViewTypeBase.resetIconPath();
        pSViewTypeBase.resetLayoutModel();
        pSViewTypeBase.resetMemo();
        pSViewTypeBase.resetOrderValue();
        pSViewTypeBase.resetPSViewEngineId();
        pSViewTypeBase.resetPSViewEngineName();
        pSViewTypeBase.resetPSViewTypeId();
        pSViewTypeBase.resetPSViewTypeName();
        pSViewTypeBase.resetTitle();
        pSViewTypeBase.resetUpdateDate();
        pSViewTypeBase.resetUpdateMan();
        pSViewTypeBase.resetUserCat();
        pSViewTypeBase.resetUserTag();
        pSViewTypeBase.resetUserTag2();
        pSViewTypeBase.resetUserTag3();
        pSViewTypeBase.resetUserTag4();
        pSViewTypeBase.resetValidFlag();
        pSViewTypeBase.resetViewObjInt();
        pSViewTypeBase.resetVTFullSN();
        pSViewTypeBase.resetVTSN();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppViewObjDirty()) {
            hashMap.put(FIELD_APPVIEWOBJ, this.getAppViewObj());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
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
        if (!bl || this.isDescURLDirty()) {
            hashMap.put(FIELD_DESCURL, this.getDescURL());
        }
        if (!bl || this.isDEViewModeDirty()) {
            hashMap.put(FIELD_DEVIEWMODE, this.getDEViewMode());
        }
        if (!bl || this.isDEViewObjDirty()) {
            hashMap.put(FIELD_DEVIEWOBJ, this.getDEViewObj());
        }
        if (!bl || this.isEmbedViewFlagDirty()) {
            hashMap.put(FIELD_EMBEDVIEWFLAG, this.getEmbedViewFlag());
        }
        if (!bl || this.isEnableDynaToolDirty()) {
            hashMap.put(FIELD_ENABLEDYNATOOL, this.getEnableDynaTool());
        }
        if (!bl || this.isIconPathDirty()) {
            hashMap.put(FIELD_ICONPATH, this.getIconPath());
        }
        if (!bl || this.isLayoutModelDirty()) {
            hashMap.put(FIELD_LAYOUTMODEL, this.getLayoutModel());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSViewEngineIdDirty()) {
            hashMap.put(FIELD_PSVIEWENGINEID, this.getPSViewEngineId());
        }
        if (!bl || this.isPSViewEngineNameDirty()) {
            hashMap.put(FIELD_PSVIEWENGINENAME, this.getPSViewEngineName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
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
        if (!bl || this.isViewObjIntDirty()) {
            hashMap.put(FIELD_VIEWOBJINT, this.getViewObjInt());
        }
        if (!bl || this.isVTFullSNDirty()) {
            hashMap.put(FIELD_VTFULLSN, this.getVTFullSN());
        }
        if (!bl || this.isVTSNDirty()) {
            hashMap.put(FIELD_VTSN, this.getVTSN());
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
        return PSViewTypeBase.get(this, n);
    }

    private static Object get(PSViewTypeBase pSViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeBase.getAppViewObj();
            }
            case 1: {
                return pSViewTypeBase.getCodeName();
            }
            case 2: {
                return pSViewTypeBase.getColor();
            }
            case 3: {
                return pSViewTypeBase.getCreateDate();
            }
            case 4: {
                return pSViewTypeBase.getCreateMan();
            }
            case 5: {
                return pSViewTypeBase.getDescURL();
            }
            case 6: {
                return pSViewTypeBase.getDEViewMode();
            }
            case 7: {
                return pSViewTypeBase.getDEViewObj();
            }
            case 8: {
                return pSViewTypeBase.getEmbedViewFlag();
            }
            case 9: {
                return pSViewTypeBase.getEnableDynaTool();
            }
            case 10: {
                return pSViewTypeBase.getIconPath();
            }
            case 11: {
                return pSViewTypeBase.getLayoutModel();
            }
            case 12: {
                return pSViewTypeBase.getMemo();
            }
            case 13: {
                return pSViewTypeBase.getOrderValue();
            }
            case 14: {
                return pSViewTypeBase.getPSViewEngineId();
            }
            case 15: {
                return pSViewTypeBase.getPSViewEngineName();
            }
            case 16: {
                return pSViewTypeBase.getPSViewTypeId();
            }
            case 17: {
                return pSViewTypeBase.getPSViewTypeName();
            }
            case 18: {
                return pSViewTypeBase.getTitle();
            }
            case 19: {
                return pSViewTypeBase.getUpdateDate();
            }
            case 20: {
                return pSViewTypeBase.getUpdateMan();
            }
            case 21: {
                return pSViewTypeBase.getUserCat();
            }
            case 22: {
                return pSViewTypeBase.getUserTag();
            }
            case 23: {
                return pSViewTypeBase.getUserTag2();
            }
            case 24: {
                return pSViewTypeBase.getUserTag3();
            }
            case 25: {
                return pSViewTypeBase.getUserTag4();
            }
            case 26: {
                return pSViewTypeBase.getValidFlag();
            }
            case 27: {
                return pSViewTypeBase.getViewObjInt();
            }
            case 28: {
                return pSViewTypeBase.getVTFullSN();
            }
            case 29: {
                return pSViewTypeBase.getVTSN();
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
        PSViewTypeBase.set(this, n, object);
    }

    private static void set(PSViewTypeBase pSViewTypeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeBase.setAppViewObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSViewTypeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSViewTypeBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSViewTypeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSViewTypeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSViewTypeBase.setDescURL(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSViewTypeBase.setDEViewMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSViewTypeBase.setDEViewObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSViewTypeBase.setEmbedViewFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSViewTypeBase.setEnableDynaTool(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSViewTypeBase.setIconPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSViewTypeBase.setLayoutModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSViewTypeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSViewTypeBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSViewTypeBase.setPSViewEngineId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSViewTypeBase.setPSViewEngineName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSViewTypeBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSViewTypeBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSViewTypeBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSViewTypeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSViewTypeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSViewTypeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSViewTypeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSViewTypeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSViewTypeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSViewTypeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSViewTypeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSViewTypeBase.setViewObjInt(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSViewTypeBase.setVTFullSN(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSViewTypeBase.setVTSN(DataObject.getStringValue((Object)object));
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
        return PSViewTypeBase.isNull(this, n);
    }

    private static boolean isNull(PSViewTypeBase pSViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeBase.getAppViewObj() == null;
            }
            case 1: {
                return pSViewTypeBase.getCodeName() == null;
            }
            case 2: {
                return pSViewTypeBase.getColor() == null;
            }
            case 3: {
                return pSViewTypeBase.getCreateDate() == null;
            }
            case 4: {
                return pSViewTypeBase.getCreateMan() == null;
            }
            case 5: {
                return pSViewTypeBase.getDescURL() == null;
            }
            case 6: {
                return pSViewTypeBase.getDEViewMode() == null;
            }
            case 7: {
                return pSViewTypeBase.getDEViewObj() == null;
            }
            case 8: {
                return pSViewTypeBase.getEmbedViewFlag() == null;
            }
            case 9: {
                return pSViewTypeBase.getEnableDynaTool() == null;
            }
            case 10: {
                return pSViewTypeBase.getIconPath() == null;
            }
            case 11: {
                return pSViewTypeBase.getLayoutModel() == null;
            }
            case 12: {
                return pSViewTypeBase.getMemo() == null;
            }
            case 13: {
                return pSViewTypeBase.getOrderValue() == null;
            }
            case 14: {
                return pSViewTypeBase.getPSViewEngineId() == null;
            }
            case 15: {
                return pSViewTypeBase.getPSViewEngineName() == null;
            }
            case 16: {
                return pSViewTypeBase.getPSViewTypeId() == null;
            }
            case 17: {
                return pSViewTypeBase.getPSViewTypeName() == null;
            }
            case 18: {
                return pSViewTypeBase.getTitle() == null;
            }
            case 19: {
                return pSViewTypeBase.getUpdateDate() == null;
            }
            case 20: {
                return pSViewTypeBase.getUpdateMan() == null;
            }
            case 21: {
                return pSViewTypeBase.getUserCat() == null;
            }
            case 22: {
                return pSViewTypeBase.getUserTag() == null;
            }
            case 23: {
                return pSViewTypeBase.getUserTag2() == null;
            }
            case 24: {
                return pSViewTypeBase.getUserTag3() == null;
            }
            case 25: {
                return pSViewTypeBase.getUserTag4() == null;
            }
            case 26: {
                return pSViewTypeBase.getValidFlag() == null;
            }
            case 27: {
                return pSViewTypeBase.getViewObjInt() == null;
            }
            case 28: {
                return pSViewTypeBase.getVTFullSN() == null;
            }
            case 29: {
                return pSViewTypeBase.getVTSN() == null;
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
        return PSViewTypeBase.contains(this, n);
    }

    private static boolean contains(PSViewTypeBase pSViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSViewTypeBase.isAppViewObjDirty();
            }
            case 1: {
                return pSViewTypeBase.isCodeNameDirty();
            }
            case 2: {
                return pSViewTypeBase.isColorDirty();
            }
            case 3: {
                return pSViewTypeBase.isCreateDateDirty();
            }
            case 4: {
                return pSViewTypeBase.isCreateManDirty();
            }
            case 5: {
                return pSViewTypeBase.isDescURLDirty();
            }
            case 6: {
                return pSViewTypeBase.isDEViewModeDirty();
            }
            case 7: {
                return pSViewTypeBase.isDEViewObjDirty();
            }
            case 8: {
                return pSViewTypeBase.isEmbedViewFlagDirty();
            }
            case 9: {
                return pSViewTypeBase.isEnableDynaToolDirty();
            }
            case 10: {
                return pSViewTypeBase.isIconPathDirty();
            }
            case 11: {
                return pSViewTypeBase.isLayoutModelDirty();
            }
            case 12: {
                return pSViewTypeBase.isMemoDirty();
            }
            case 13: {
                return pSViewTypeBase.isOrderValueDirty();
            }
            case 14: {
                return pSViewTypeBase.isPSViewEngineIdDirty();
            }
            case 15: {
                return pSViewTypeBase.isPSViewEngineNameDirty();
            }
            case 16: {
                return pSViewTypeBase.isPSViewTypeIdDirty();
            }
            case 17: {
                return pSViewTypeBase.isPSViewTypeNameDirty();
            }
            case 18: {
                return pSViewTypeBase.isTitleDirty();
            }
            case 19: {
                return pSViewTypeBase.isUpdateDateDirty();
            }
            case 20: {
                return pSViewTypeBase.isUpdateManDirty();
            }
            case 21: {
                return pSViewTypeBase.isUserCatDirty();
            }
            case 22: {
                return pSViewTypeBase.isUserTagDirty();
            }
            case 23: {
                return pSViewTypeBase.isUserTag2Dirty();
            }
            case 24: {
                return pSViewTypeBase.isUserTag3Dirty();
            }
            case 25: {
                return pSViewTypeBase.isUserTag4Dirty();
            }
            case 26: {
                return pSViewTypeBase.isValidFlagDirty();
            }
            case 27: {
                return pSViewTypeBase.isViewObjIntDirty();
            }
            case 28: {
                return pSViewTypeBase.isVTFullSNDirty();
            }
            case 29: {
                return pSViewTypeBase.isVTSNDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSViewTypeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSViewTypeBase pSViewTypeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSViewTypeBase.getAppViewObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"appviewobj", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getAppViewObj()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getColor()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getDescURL() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"descurl", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getDescURL()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getDEViewMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewmode", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getDEViewMode()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getDEViewObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"deviewobj", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getDEViewObj()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getEmbedViewFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"embedviewflag", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getEmbedViewFlag()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getEnableDynaTool() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledynatool", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getEnableDynaTool()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getIconPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconpath", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getIconPath()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getLayoutModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmodel", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getLayoutModel()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getMemo()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getPSViewEngineId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewengineid", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getPSViewEngineId()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getPSViewEngineName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewenginename", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getPSViewEngineName()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getTitle()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getViewObjInt() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewobjint", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getViewObjInt()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getVTFullSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vtfullsn", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getVTFullSN()), (boolean)false);
        }
        if (bl || pSViewTypeBase.getVTSN() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vtsn", (Object)PSViewTypeBase.getJSONValue((Object)pSViewTypeBase.getVTSN()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSViewTypeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSViewTypeBase pSViewTypeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSViewTypeBase.getAppViewObj() != null) {
            object = pSViewTypeBase.getAppViewObj();
            xmlNode.setAttribute(FIELD_APPVIEWOBJ, (String)(object == null ? "" : object));
        }
        if (bl || pSViewTypeBase.getCodeName() != null) {
            object = pSViewTypeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSViewTypeBase.getColor() != null) {
            object = pSViewTypeBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getCreateDate() != null) {
            object = pSViewTypeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeBase.getCreateMan() != null) {
            object = pSViewTypeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getDescURL() != null) {
            object = pSViewTypeBase.getDescURL();
            xmlNode.setAttribute(FIELD_DESCURL, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getDEViewMode() != null) {
            object = pSViewTypeBase.getDEViewMode();
            xmlNode.setAttribute(FIELD_DEVIEWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeBase.getDEViewObj() != null) {
            object = pSViewTypeBase.getDEViewObj();
            xmlNode.setAttribute(FIELD_DEVIEWOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getEmbedViewFlag() != null) {
            object = pSViewTypeBase.getEmbedViewFlag();
            xmlNode.setAttribute(FIELD_EMBEDVIEWFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeBase.getEnableDynaTool() != null) {
            object = pSViewTypeBase.getEnableDynaTool();
            xmlNode.setAttribute(FIELD_ENABLEDYNATOOL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeBase.getIconPath() != null) {
            object = pSViewTypeBase.getIconPath();
            xmlNode.setAttribute(FIELD_ICONPATH, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getLayoutModel() != null) {
            object = pSViewTypeBase.getLayoutModel();
            xmlNode.setAttribute(FIELD_LAYOUTMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getMemo() != null) {
            object = pSViewTypeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getOrderValue() != null) {
            object = pSViewTypeBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeBase.getPSViewEngineId() != null) {
            object = pSViewTypeBase.getPSViewEngineId();
            xmlNode.setAttribute(FIELD_PSVIEWENGINEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getPSViewEngineName() != null) {
            object = pSViewTypeBase.getPSViewEngineName();
            xmlNode.setAttribute(FIELD_PSVIEWENGINENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getPSViewTypeId() != null) {
            object = pSViewTypeBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getPSViewTypeName() != null) {
            object = pSViewTypeBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getTitle() != null) {
            object = pSViewTypeBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUpdateDate() != null) {
            object = pSViewTypeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSViewTypeBase.getUpdateMan() != null) {
            object = pSViewTypeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUserCat() != null) {
            object = pSViewTypeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUserTag() != null) {
            object = pSViewTypeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUserTag2() != null) {
            object = pSViewTypeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUserTag3() != null) {
            object = pSViewTypeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getUserTag4() != null) {
            object = pSViewTypeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getValidFlag() != null) {
            object = pSViewTypeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSViewTypeBase.getViewObjInt() != null) {
            object = pSViewTypeBase.getViewObjInt();
            xmlNode.setAttribute(FIELD_VIEWOBJINT, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getVTFullSN() != null) {
            object = pSViewTypeBase.getVTFullSN();
            xmlNode.setAttribute(FIELD_VTFULLSN, object == null ? "" : (String)object);
        }
        if (bl || pSViewTypeBase.getVTSN() != null) {
            object = pSViewTypeBase.getVTSN();
            xmlNode.setAttribute(FIELD_VTSN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSViewTypeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSViewTypeBase pSViewTypeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSViewTypeBase.isAppViewObjDirty() && (bl || pSViewTypeBase.getAppViewObj() != null)) {
            iDataObject.set(FIELD_APPVIEWOBJ, (Object)pSViewTypeBase.getAppViewObj());
        }
        if (pSViewTypeBase.isCodeNameDirty() && (bl || pSViewTypeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSViewTypeBase.getCodeName());
        }
        if (pSViewTypeBase.isColorDirty() && (bl || pSViewTypeBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSViewTypeBase.getColor());
        }
        if (pSViewTypeBase.isCreateDateDirty() && (bl || pSViewTypeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSViewTypeBase.getCreateDate());
        }
        if (pSViewTypeBase.isCreateManDirty() && (bl || pSViewTypeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSViewTypeBase.getCreateMan());
        }
        if (pSViewTypeBase.isDescURLDirty() && (bl || pSViewTypeBase.getDescURL() != null)) {
            iDataObject.set(FIELD_DESCURL, (Object)pSViewTypeBase.getDescURL());
        }
        if (pSViewTypeBase.isDEViewModeDirty() && (bl || pSViewTypeBase.getDEViewMode() != null)) {
            iDataObject.set(FIELD_DEVIEWMODE, (Object)pSViewTypeBase.getDEViewMode());
        }
        if (pSViewTypeBase.isDEViewObjDirty() && (bl || pSViewTypeBase.getDEViewObj() != null)) {
            iDataObject.set(FIELD_DEVIEWOBJ, (Object)pSViewTypeBase.getDEViewObj());
        }
        if (pSViewTypeBase.isEmbedViewFlagDirty() && (bl || pSViewTypeBase.getEmbedViewFlag() != null)) {
            iDataObject.set(FIELD_EMBEDVIEWFLAG, (Object)pSViewTypeBase.getEmbedViewFlag());
        }
        if (pSViewTypeBase.isEnableDynaToolDirty() && (bl || pSViewTypeBase.getEnableDynaTool() != null)) {
            iDataObject.set(FIELD_ENABLEDYNATOOL, (Object)pSViewTypeBase.getEnableDynaTool());
        }
        if (pSViewTypeBase.isIconPathDirty() && (bl || pSViewTypeBase.getIconPath() != null)) {
            iDataObject.set(FIELD_ICONPATH, (Object)pSViewTypeBase.getIconPath());
        }
        if (pSViewTypeBase.isLayoutModelDirty() && (bl || pSViewTypeBase.getLayoutModel() != null)) {
            iDataObject.set(FIELD_LAYOUTMODEL, (Object)pSViewTypeBase.getLayoutModel());
        }
        if (pSViewTypeBase.isMemoDirty() && (bl || pSViewTypeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSViewTypeBase.getMemo());
        }
        if (pSViewTypeBase.isOrderValueDirty() && (bl || pSViewTypeBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSViewTypeBase.getOrderValue());
        }
        if (pSViewTypeBase.isPSViewEngineIdDirty() && (bl || pSViewTypeBase.getPSViewEngineId() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINEID, (Object)pSViewTypeBase.getPSViewEngineId());
        }
        if (pSViewTypeBase.isPSViewEngineNameDirty() && (bl || pSViewTypeBase.getPSViewEngineName() != null)) {
            iDataObject.set(FIELD_PSVIEWENGINENAME, (Object)pSViewTypeBase.getPSViewEngineName());
        }
        if (pSViewTypeBase.isPSViewTypeIdDirty() && (bl || pSViewTypeBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSViewTypeBase.getPSViewTypeId());
        }
        if (pSViewTypeBase.isPSViewTypeNameDirty() && (bl || pSViewTypeBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSViewTypeBase.getPSViewTypeName());
        }
        if (pSViewTypeBase.isTitleDirty() && (bl || pSViewTypeBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSViewTypeBase.getTitle());
        }
        if (pSViewTypeBase.isUpdateDateDirty() && (bl || pSViewTypeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSViewTypeBase.getUpdateDate());
        }
        if (pSViewTypeBase.isUpdateManDirty() && (bl || pSViewTypeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSViewTypeBase.getUpdateMan());
        }
        if (pSViewTypeBase.isUserCatDirty() && (bl || pSViewTypeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSViewTypeBase.getUserCat());
        }
        if (pSViewTypeBase.isUserTagDirty() && (bl || pSViewTypeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSViewTypeBase.getUserTag());
        }
        if (pSViewTypeBase.isUserTag2Dirty() && (bl || pSViewTypeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSViewTypeBase.getUserTag2());
        }
        if (pSViewTypeBase.isUserTag3Dirty() && (bl || pSViewTypeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSViewTypeBase.getUserTag3());
        }
        if (pSViewTypeBase.isUserTag4Dirty() && (bl || pSViewTypeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSViewTypeBase.getUserTag4());
        }
        if (pSViewTypeBase.isValidFlagDirty() && (bl || pSViewTypeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSViewTypeBase.getValidFlag());
        }
        if (pSViewTypeBase.isViewObjIntDirty() && (bl || pSViewTypeBase.getViewObjInt() != null)) {
            iDataObject.set(FIELD_VIEWOBJINT, (Object)pSViewTypeBase.getViewObjInt());
        }
        if (pSViewTypeBase.isVTFullSNDirty() && (bl || pSViewTypeBase.getVTFullSN() != null)) {
            iDataObject.set(FIELD_VTFULLSN, (Object)pSViewTypeBase.getVTFullSN());
        }
        if (pSViewTypeBase.isVTSNDirty() && (bl || pSViewTypeBase.getVTSN() != null)) {
            iDataObject.set(FIELD_VTSN, (Object)pSViewTypeBase.getVTSN());
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
        return PSViewTypeBase.remove(this, n);
    }

    private static boolean remove(PSViewTypeBase pSViewTypeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSViewTypeBase.resetAppViewObj();
                return true;
            }
            case 1: {
                pSViewTypeBase.resetCodeName();
                return true;
            }
            case 2: {
                pSViewTypeBase.resetColor();
                return true;
            }
            case 3: {
                pSViewTypeBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSViewTypeBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSViewTypeBase.resetDescURL();
                return true;
            }
            case 6: {
                pSViewTypeBase.resetDEViewMode();
                return true;
            }
            case 7: {
                pSViewTypeBase.resetDEViewObj();
                return true;
            }
            case 8: {
                pSViewTypeBase.resetEmbedViewFlag();
                return true;
            }
            case 9: {
                pSViewTypeBase.resetEnableDynaTool();
                return true;
            }
            case 10: {
                pSViewTypeBase.resetIconPath();
                return true;
            }
            case 11: {
                pSViewTypeBase.resetLayoutModel();
                return true;
            }
            case 12: {
                pSViewTypeBase.resetMemo();
                return true;
            }
            case 13: {
                pSViewTypeBase.resetOrderValue();
                return true;
            }
            case 14: {
                pSViewTypeBase.resetPSViewEngineId();
                return true;
            }
            case 15: {
                pSViewTypeBase.resetPSViewEngineName();
                return true;
            }
            case 16: {
                pSViewTypeBase.resetPSViewTypeId();
                return true;
            }
            case 17: {
                pSViewTypeBase.resetPSViewTypeName();
                return true;
            }
            case 18: {
                pSViewTypeBase.resetTitle();
                return true;
            }
            case 19: {
                pSViewTypeBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSViewTypeBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSViewTypeBase.resetUserCat();
                return true;
            }
            case 22: {
                pSViewTypeBase.resetUserTag();
                return true;
            }
            case 23: {
                pSViewTypeBase.resetUserTag2();
                return true;
            }
            case 24: {
                pSViewTypeBase.resetUserTag3();
                return true;
            }
            case 25: {
                pSViewTypeBase.resetUserTag4();
                return true;
            }
            case 26: {
                pSViewTypeBase.resetValidFlag();
                return true;
            }
            case 27: {
                pSViewTypeBase.resetViewObjInt();
                return true;
            }
            case 28: {
                pSViewTypeBase.resetVTFullSN();
                return true;
            }
            case 29: {
                pSViewTypeBase.resetVTSN();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewEngine getPSViewEngine() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewEngine();
        }
        if (this.getPSViewEngineId() == null) {
            return null;
        }
        Integer n = this.objPSViewEngineLock;
        synchronized (n) {
            if (this.psviewengine != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewEngineId(), (Object)this.psviewengine.getPSViewEngineId()) != 0L) {
                this.psviewengine = null;
            }
            if (this.psviewengine == null) {
                PSViewEngine pSViewEngine = new PSViewEngine();
                pSViewEngine.setPSViewEngineId(this.getPSViewEngineId());
                PSViewEngineService pSViewEngineService = (PSViewEngineService)ServiceGlobal.getService(PSViewEngineService.class, (SessionFactory)this.getSessionFactory());
                pSViewEngineService.autoGet(pSViewEngine);
                this.psviewengine = pSViewEngine;
            }
            return this.psviewengine;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSViewTypeLogic> getPSViewTypeLogics() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeLogics();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSViewTypeLogicService pSViewTypeLogicService = (PSViewTypeLogicService)ServiceGlobal.getService(PSViewTypeLogicService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSViewTypeLogicsLock;
        synchronized (n) {
            if (this.psviewtypelogics == null) {
                this.psviewtypelogics = pSViewTypeLogicService.selectByPSViewType(this);
            }
            return this.psviewtypelogics;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSVTCtrl> getPSVTCtrls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTCtrls();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSVTCtrlService pSVTCtrlService = (PSVTCtrlService)ServiceGlobal.getService(PSVTCtrlService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSVTCtrlsLock;
        synchronized (n) {
            if (this.psvtctrls == null) {
                this.psvtctrls = pSVTCtrlService.selectByPSViewType(this);
            }
            return this.psvtctrls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSVTRV> getPSVTRVs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTRVs();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSVTRVService pSVTRVService = (PSVTRVService)ServiceGlobal.getService(PSVTRVService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSVTRVsLock;
        synchronized (n) {
            if (this.psvtrvs == null) {
                this.psvtrvs = pSVTRVService.selectByPSViewType(this);
            }
            return this.psvtrvs;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSVTSample> getPSVTSamples() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSVTSamples();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        PSVTSampleService pSVTSampleService = (PSVTSampleService)ServiceGlobal.getService(PSVTSampleService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSVTSamplesLock;
        synchronized (n) {
            if (this.psvtsamples == null) {
                this.psvtsamples = pSVTSampleService.selectByPSViewTYpe(this);
            }
            return this.psvtsamples;
        }
    }

    private PSViewTypeBase getProxyEntity() {
        return this.proxyPSViewTypeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSViewTypeBase = null;
        if (iDataObject != null && iDataObject instanceof PSViewTypeBase) {
            this.proxyPSViewTypeBase = (PSViewTypeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSViewTypeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPVIEWOBJ, 0);
        fieldIndexMap.put(FIELD_CODENAME, 1);
        fieldIndexMap.put(FIELD_COLOR, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_DESCURL, 5);
        fieldIndexMap.put(FIELD_DEVIEWMODE, 6);
        fieldIndexMap.put(FIELD_DEVIEWOBJ, 7);
        fieldIndexMap.put(FIELD_EMBEDVIEWFLAG, 8);
        fieldIndexMap.put(FIELD_ENABLEDYNATOOL, 9);
        fieldIndexMap.put(FIELD_ICONPATH, 10);
        fieldIndexMap.put(FIELD_LAYOUTMODEL, 11);
        fieldIndexMap.put(FIELD_MEMO, 12);
        fieldIndexMap.put(FIELD_ORDERVALUE, 13);
        fieldIndexMap.put(FIELD_PSVIEWENGINEID, 14);
        fieldIndexMap.put(FIELD_PSVIEWENGINENAME, 15);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 16);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 17);
        fieldIndexMap.put(FIELD_TITLE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USERCAT, 21);
        fieldIndexMap.put(FIELD_USERTAG, 22);
        fieldIndexMap.put(FIELD_USERTAG2, 23);
        fieldIndexMap.put(FIELD_USERTAG3, 24);
        fieldIndexMap.put(FIELD_USERTAG4, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
        fieldIndexMap.put(FIELD_VIEWOBJINT, 27);
        fieldIndexMap.put(FIELD_VTFULLSN, 28);
        fieldIndexMap.put(FIELD_VTSN, 29);
    }
}

