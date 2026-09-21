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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEACMode;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.service.PSDEACModeService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEACModeItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEACModeItemBase.class);
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CLCONVERTFLAG = "CLCONVERTFLAG";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEACMODEID = "PSDEACMODEID";
    public static final String FIELD_PSDEACMODEITEMID = "PSDEACMODEITEMID";
    public static final String FIELD_PSDEACMODEITEMNAME = "PSDEACMODEITEMNAME";
    public static final String FIELD_PSDEACMODENAME = "PSDEACMODENAME";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHUNIT = "WIDTHUNIT";
    private static final int INDEX_CAPPSLANRESID = 0;
    private static final int INDEX_CAPPSLANRESNAME = 1;
    private static final int INDEX_CAPTION = 2;
    private static final int INDEX_CLCONVERTFLAG = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_CUSTOMCODE = 6;
    private static final int INDEX_CUSTOMMODE = 7;
    private static final int INDEX_DYNAMODELFLAG = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_ORDERVALUE = 10;
    private static final int INDEX_PSCODELISTID = 11;
    private static final int INDEX_PSCODELISTNAME = 12;
    private static final int INDEX_PSDEACMODEID = 13;
    private static final int INDEX_PSDEACMODEITEMID = 14;
    private static final int INDEX_PSDEACMODEITEMNAME = 15;
    private static final int INDEX_PSDEACMODENAME = 16;
    private static final int INDEX_PSDEFID = 17;
    private static final int INDEX_PSDEFNAME = 18;
    private static final int INDEX_PSDYNAINSTID = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_USERCAT = 22;
    private static final int INDEX_USERTAG = 23;
    private static final int INDEX_USERTAG2 = 24;
    private static final int INDEX_USERTAG3 = 25;
    private static final int INDEX_USERTAG4 = 26;
    private static final int INDEX_VALUEFORMAT = 27;
    private static final int INDEX_WIDTH = 28;
    private static final int INDEX_WIDTHUNIT = 29;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEACModeItemBase proxyPSDEACModeItemBase = null;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean clconvertflagDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdeacmodeidDirtyFlag = false;
    private boolean psdeacmodeitemidDirtyFlag = false;
    private boolean psdeacmodeitemnameDirtyFlag = false;
    private boolean psdeacmodenameDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthunitDirtyFlag = false;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="clconvertflag")
    private Integer clconvertflag;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdeacmodeid")
    private String psdeacmodeid;
    @Column(name="psdeacmodeitemid")
    private String psdeacmodeitemid;
    @Column(name="psdeacmodeitemname")
    private String psdeacmodeitemname;
    @Column(name="psdeacmodename")
    private String psdeacmodename;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdynainstid")
    private String psdynainstid;
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
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="width")
    private Integer width;
    @Column(name="widthunit")
    private String widthunit;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEACModeLock = new Integer(1);
    private PSDEACMode psdeacmode = null;
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;

    public void setCapPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresid = string;
        this.cappslanresidDirtyFlag = true;
    }

    public String getCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResId();
        }
        return this.cappslanresid;
    }

    public boolean isCapPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResIdDirty();
        }
        return this.cappslanresidDirtyFlag;
    }

    public void resetCapPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResId();
            return;
        }
        this.cappslanresidDirtyFlag = false;
        this.cappslanresid = null;
    }

    public void setCapPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCapPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cappslanresname = string;
        this.cappslanresnameDirtyFlag = true;
    }

    public String getCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanResName();
        }
        return this.cappslanresname;
    }

    public boolean isCapPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCapPSLanResNameDirty();
        }
        return this.cappslanresnameDirtyFlag;
    }

    public void resetCapPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCapPSLanResName();
            return;
        }
        this.cappslanresnameDirtyFlag = false;
        this.cappslanresname = null;
    }

    public void setCaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.caption = string;
        this.captionDirtyFlag = true;
    }

    public String getCaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCaption();
        }
        return this.caption;
    }

    public boolean isCaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCaptionDirty();
        }
        return this.captionDirtyFlag;
    }

    public void resetCaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCaption();
            return;
        }
        this.captionDirtyFlag = false;
        this.caption = null;
    }

    public void setCLConvertFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLConvertFlag(n);
            return;
        }
        this.clconvertflag = n;
        this.clconvertflagDirtyFlag = true;
    }

    public Integer getCLConvertFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLConvertFlag();
        }
        return this.clconvertflag;
    }

    public boolean isCLConvertFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLConvertFlagDirty();
        }
        return this.clconvertflagDirtyFlag;
    }

    public void resetCLConvertFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLConvertFlag();
            return;
        }
        this.clconvertflagDirtyFlag = false;
        this.clconvertflag = null;
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

    public void setPSCodeListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistid = string;
        this.pscodelistidDirtyFlag = true;
    }

    public String getPSCodeListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListId();
        }
        return this.pscodelistid;
    }

    public boolean isPSCodeListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListIdDirty();
        }
        return this.pscodelistidDirtyFlag;
    }

    public void resetPSCodeListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListId();
            return;
        }
        this.pscodelistidDirtyFlag = false;
        this.pscodelistid = null;
    }

    public void setPSCodeListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodelistname = string;
        this.pscodelistnameDirtyFlag = true;
    }

    public String getPSCodeListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeListName();
        }
        return this.pscodelistname;
    }

    public boolean isPSCodeListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeListNameDirty();
        }
        return this.pscodelistnameDirtyFlag;
    }

    public void resetPSCodeListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeListName();
            return;
        }
        this.pscodelistnameDirtyFlag = false;
        this.pscodelistname = null;
    }

    public void setPSDEACModeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeid = string;
        this.psdeacmodeidDirtyFlag = true;
    }

    public String getPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeId();
        }
        return this.psdeacmodeid;
    }

    public boolean isPSDEACModeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeIdDirty();
        }
        return this.psdeacmodeidDirtyFlag;
    }

    public void resetPSDEACModeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeId();
            return;
        }
        this.psdeacmodeidDirtyFlag = false;
        this.psdeacmodeid = null;
    }

    public void setPSDEACModeItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeitemid = string;
        this.psdeacmodeitemidDirtyFlag = true;
    }

    public String getPSDEACModeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeItemId();
        }
        return this.psdeacmodeitemid;
    }

    public boolean isPSDEACModeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeItemIdDirty();
        }
        return this.psdeacmodeitemidDirtyFlag;
    }

    public void resetPSDEACModeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeItemId();
            return;
        }
        this.psdeacmodeitemidDirtyFlag = false;
        this.psdeacmodeitemid = null;
    }

    public void setPSDEACModeItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodeitemname = string;
        this.psdeacmodeitemnameDirtyFlag = true;
    }

    public String getPSDEACModeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeItemName();
        }
        return this.psdeacmodeitemname;
    }

    public boolean isPSDEACModeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeItemNameDirty();
        }
        return this.psdeacmodeitemnameDirtyFlag;
    }

    public void resetPSDEACModeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeItemName();
            return;
        }
        this.psdeacmodeitemnameDirtyFlag = false;
        this.psdeacmodeitemname = null;
    }

    public void setPSDEACModeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEACModeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeacmodename = string;
        this.psdeacmodenameDirtyFlag = true;
    }

    public String getPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACModeName();
        }
        return this.psdeacmodename;
    }

    public boolean isPSDEACModeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEACModeNameDirty();
        }
        return this.psdeacmodenameDirtyFlag;
    }

    public void resetPSDEACModeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEACModeName();
            return;
        }
        this.psdeacmodenameDirtyFlag = false;
        this.psdeacmodename = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setValueFormat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFormat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valueformat = string;
        this.valueformatDirtyFlag = true;
    }

    public String getValueFormat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFormat();
        }
        return this.valueformat;
    }

    public boolean isValueFormatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFormatDirty();
        }
        return this.valueformatDirtyFlag;
    }

    public void resetValueFormat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFormat();
            return;
        }
        this.valueformatDirtyFlag = false;
        this.valueformat = null;
    }

    public void setWidth(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidth(n);
            return;
        }
        this.width = n;
        this.widthDirtyFlag = true;
    }

    public Integer getWidth() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidth();
        }
        return this.width;
    }

    public boolean isWidthDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthDirty();
        }
        return this.widthDirtyFlag;
    }

    public void resetWidth() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidth();
            return;
        }
        this.widthDirtyFlag = false;
        this.width = null;
    }

    public void setWidthUnit(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setWidthUnit(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.widthunit = string;
        this.widthunitDirtyFlag = true;
    }

    public String getWidthUnit() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getWidthUnit();
        }
        return this.widthunit;
    }

    public boolean isWidthUnitDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isWidthUnitDirty();
        }
        return this.widthunitDirtyFlag;
    }

    public void resetWidthUnit() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetWidthUnit();
            return;
        }
        this.widthunitDirtyFlag = false;
        this.widthunit = null;
    }

    protected void onReset() {
        PSDEACModeItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEACModeItemBase pSDEACModeItemBase) {
        pSDEACModeItemBase.resetCapPSLanResId();
        pSDEACModeItemBase.resetCapPSLanResName();
        pSDEACModeItemBase.resetCaption();
        pSDEACModeItemBase.resetCLConvertFlag();
        pSDEACModeItemBase.resetCreateDate();
        pSDEACModeItemBase.resetCreateMan();
        pSDEACModeItemBase.resetCustomCode();
        pSDEACModeItemBase.resetCustomMode();
        pSDEACModeItemBase.resetDynaModelFlag();
        pSDEACModeItemBase.resetMemo();
        pSDEACModeItemBase.resetOrderValue();
        pSDEACModeItemBase.resetPSCodeListId();
        pSDEACModeItemBase.resetPSCodeListName();
        pSDEACModeItemBase.resetPSDEACModeId();
        pSDEACModeItemBase.resetPSDEACModeItemId();
        pSDEACModeItemBase.resetPSDEACModeItemName();
        pSDEACModeItemBase.resetPSDEACModeName();
        pSDEACModeItemBase.resetPSDEFId();
        pSDEACModeItemBase.resetPSDEFName();
        pSDEACModeItemBase.resetPSDynaInstId();
        pSDEACModeItemBase.resetUpdateDate();
        pSDEACModeItemBase.resetUpdateMan();
        pSDEACModeItemBase.resetUserCat();
        pSDEACModeItemBase.resetUserTag();
        pSDEACModeItemBase.resetUserTag2();
        pSDEACModeItemBase.resetUserTag3();
        pSDEACModeItemBase.resetUserTag4();
        pSDEACModeItemBase.resetValueFormat();
        pSDEACModeItemBase.resetWidth();
        pSDEACModeItemBase.resetWidthUnit();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCLConvertFlagDirty()) {
            hashMap.put(FIELD_CLCONVERTFLAG, this.getCLConvertFlag());
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEACModeIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEID, this.getPSDEACModeId());
        }
        if (!bl || this.isPSDEACModeItemIdDirty()) {
            hashMap.put(FIELD_PSDEACMODEITEMID, this.getPSDEACModeItemId());
        }
        if (!bl || this.isPSDEACModeItemNameDirty()) {
            hashMap.put(FIELD_PSDEACMODEITEMNAME, this.getPSDEACModeItemName());
        }
        if (!bl || this.isPSDEACModeNameDirty()) {
            hashMap.put(FIELD_PSDEACMODENAME, this.getPSDEACModeName());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
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
        if (!bl || this.isValueFormatDirty()) {
            hashMap.put(FIELD_VALUEFORMAT, this.getValueFormat());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
        }
        if (!bl || this.isWidthUnitDirty()) {
            hashMap.put(FIELD_WIDTHUNIT, this.getWidthUnit());
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
        return PSDEACModeItemBase.get(this, n);
    }

    private static Object get(PSDEACModeItemBase pSDEACModeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeItemBase.getCapPSLanResId();
            }
            case 1: {
                return pSDEACModeItemBase.getCapPSLanResName();
            }
            case 2: {
                return pSDEACModeItemBase.getCaption();
            }
            case 3: {
                return pSDEACModeItemBase.getCLConvertFlag();
            }
            case 4: {
                return pSDEACModeItemBase.getCreateDate();
            }
            case 5: {
                return pSDEACModeItemBase.getCreateMan();
            }
            case 6: {
                return pSDEACModeItemBase.getCustomCode();
            }
            case 7: {
                return pSDEACModeItemBase.getCustomMode();
            }
            case 8: {
                return pSDEACModeItemBase.getDynaModelFlag();
            }
            case 9: {
                return pSDEACModeItemBase.getMemo();
            }
            case 10: {
                return pSDEACModeItemBase.getOrderValue();
            }
            case 11: {
                return pSDEACModeItemBase.getPSCodeListId();
            }
            case 12: {
                return pSDEACModeItemBase.getPSCodeListName();
            }
            case 13: {
                return pSDEACModeItemBase.getPSDEACModeId();
            }
            case 14: {
                return pSDEACModeItemBase.getPSDEACModeItemId();
            }
            case 15: {
                return pSDEACModeItemBase.getPSDEACModeItemName();
            }
            case 16: {
                return pSDEACModeItemBase.getPSDEACModeName();
            }
            case 17: {
                return pSDEACModeItemBase.getPSDEFId();
            }
            case 18: {
                return pSDEACModeItemBase.getPSDEFName();
            }
            case 19: {
                return pSDEACModeItemBase.getPSDynaInstId();
            }
            case 20: {
                return pSDEACModeItemBase.getUpdateDate();
            }
            case 21: {
                return pSDEACModeItemBase.getUpdateMan();
            }
            case 22: {
                return pSDEACModeItemBase.getUserCat();
            }
            case 23: {
                return pSDEACModeItemBase.getUserTag();
            }
            case 24: {
                return pSDEACModeItemBase.getUserTag2();
            }
            case 25: {
                return pSDEACModeItemBase.getUserTag3();
            }
            case 26: {
                return pSDEACModeItemBase.getUserTag4();
            }
            case 27: {
                return pSDEACModeItemBase.getValueFormat();
            }
            case 28: {
                return pSDEACModeItemBase.getWidth();
            }
            case 29: {
                return pSDEACModeItemBase.getWidthUnit();
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
        PSDEACModeItemBase.set(this, n, object);
    }

    private static void set(PSDEACModeItemBase pSDEACModeItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEACModeItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEACModeItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEACModeItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEACModeItemBase.setCLConvertFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEACModeItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSDEACModeItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEACModeItemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEACModeItemBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSDEACModeItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEACModeItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEACModeItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDEACModeItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEACModeItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEACModeItemBase.setPSDEACModeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEACModeItemBase.setPSDEACModeItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEACModeItemBase.setPSDEACModeItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEACModeItemBase.setPSDEACModeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEACModeItemBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEACModeItemBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEACModeItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEACModeItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSDEACModeItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEACModeItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEACModeItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEACModeItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEACModeItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEACModeItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEACModeItemBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEACModeItemBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSDEACModeItemBase.setWidthUnit(DataObject.getStringValue((Object)object));
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
        return PSDEACModeItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEACModeItemBase pSDEACModeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeItemBase.getCapPSLanResId() == null;
            }
            case 1: {
                return pSDEACModeItemBase.getCapPSLanResName() == null;
            }
            case 2: {
                return pSDEACModeItemBase.getCaption() == null;
            }
            case 3: {
                return pSDEACModeItemBase.getCLConvertFlag() == null;
            }
            case 4: {
                return pSDEACModeItemBase.getCreateDate() == null;
            }
            case 5: {
                return pSDEACModeItemBase.getCreateMan() == null;
            }
            case 6: {
                return pSDEACModeItemBase.getCustomCode() == null;
            }
            case 7: {
                return pSDEACModeItemBase.getCustomMode() == null;
            }
            case 8: {
                return pSDEACModeItemBase.getDynaModelFlag() == null;
            }
            case 9: {
                return pSDEACModeItemBase.getMemo() == null;
            }
            case 10: {
                return pSDEACModeItemBase.getOrderValue() == null;
            }
            case 11: {
                return pSDEACModeItemBase.getPSCodeListId() == null;
            }
            case 12: {
                return pSDEACModeItemBase.getPSCodeListName() == null;
            }
            case 13: {
                return pSDEACModeItemBase.getPSDEACModeId() == null;
            }
            case 14: {
                return pSDEACModeItemBase.getPSDEACModeItemId() == null;
            }
            case 15: {
                return pSDEACModeItemBase.getPSDEACModeItemName() == null;
            }
            case 16: {
                return pSDEACModeItemBase.getPSDEACModeName() == null;
            }
            case 17: {
                return pSDEACModeItemBase.getPSDEFId() == null;
            }
            case 18: {
                return pSDEACModeItemBase.getPSDEFName() == null;
            }
            case 19: {
                return pSDEACModeItemBase.getPSDynaInstId() == null;
            }
            case 20: {
                return pSDEACModeItemBase.getUpdateDate() == null;
            }
            case 21: {
                return pSDEACModeItemBase.getUpdateMan() == null;
            }
            case 22: {
                return pSDEACModeItemBase.getUserCat() == null;
            }
            case 23: {
                return pSDEACModeItemBase.getUserTag() == null;
            }
            case 24: {
                return pSDEACModeItemBase.getUserTag2() == null;
            }
            case 25: {
                return pSDEACModeItemBase.getUserTag3() == null;
            }
            case 26: {
                return pSDEACModeItemBase.getUserTag4() == null;
            }
            case 27: {
                return pSDEACModeItemBase.getValueFormat() == null;
            }
            case 28: {
                return pSDEACModeItemBase.getWidth() == null;
            }
            case 29: {
                return pSDEACModeItemBase.getWidthUnit() == null;
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
        return PSDEACModeItemBase.contains(this, n);
    }

    private static boolean contains(PSDEACModeItemBase pSDEACModeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEACModeItemBase.isCapPSLanResIdDirty();
            }
            case 1: {
                return pSDEACModeItemBase.isCapPSLanResNameDirty();
            }
            case 2: {
                return pSDEACModeItemBase.isCaptionDirty();
            }
            case 3: {
                return pSDEACModeItemBase.isCLConvertFlagDirty();
            }
            case 4: {
                return pSDEACModeItemBase.isCreateDateDirty();
            }
            case 5: {
                return pSDEACModeItemBase.isCreateManDirty();
            }
            case 6: {
                return pSDEACModeItemBase.isCustomCodeDirty();
            }
            case 7: {
                return pSDEACModeItemBase.isCustomModeDirty();
            }
            case 8: {
                return pSDEACModeItemBase.isDynaModelFlagDirty();
            }
            case 9: {
                return pSDEACModeItemBase.isMemoDirty();
            }
            case 10: {
                return pSDEACModeItemBase.isOrderValueDirty();
            }
            case 11: {
                return pSDEACModeItemBase.isPSCodeListIdDirty();
            }
            case 12: {
                return pSDEACModeItemBase.isPSCodeListNameDirty();
            }
            case 13: {
                return pSDEACModeItemBase.isPSDEACModeIdDirty();
            }
            case 14: {
                return pSDEACModeItemBase.isPSDEACModeItemIdDirty();
            }
            case 15: {
                return pSDEACModeItemBase.isPSDEACModeItemNameDirty();
            }
            case 16: {
                return pSDEACModeItemBase.isPSDEACModeNameDirty();
            }
            case 17: {
                return pSDEACModeItemBase.isPSDEFIdDirty();
            }
            case 18: {
                return pSDEACModeItemBase.isPSDEFNameDirty();
            }
            case 19: {
                return pSDEACModeItemBase.isPSDynaInstIdDirty();
            }
            case 20: {
                return pSDEACModeItemBase.isUpdateDateDirty();
            }
            case 21: {
                return pSDEACModeItemBase.isUpdateManDirty();
            }
            case 22: {
                return pSDEACModeItemBase.isUserCatDirty();
            }
            case 23: {
                return pSDEACModeItemBase.isUserTagDirty();
            }
            case 24: {
                return pSDEACModeItemBase.isUserTag2Dirty();
            }
            case 25: {
                return pSDEACModeItemBase.isUserTag3Dirty();
            }
            case 26: {
                return pSDEACModeItemBase.isUserTag4Dirty();
            }
            case 27: {
                return pSDEACModeItemBase.isValueFormatDirty();
            }
            case 28: {
                return pSDEACModeItemBase.isWidthDirty();
            }
            case 29: {
                return pSDEACModeItemBase.isWidthUnitDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEACModeItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEACModeItemBase pSDEACModeItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEACModeItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCLConvertFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clconvertflag", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCLConvertFlag()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEACModeId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeitemid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEACModeItemId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodeitemname", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEACModeItemName()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeacmodename", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEACModeName()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getWidth()), (boolean)false);
        }
        if (bl || pSDEACModeItemBase.getWidthUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthunit", (Object)PSDEACModeItemBase.getJSONValue((Object)pSDEACModeItemBase.getWidthUnit()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEACModeItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEACModeItemBase pSDEACModeItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEACModeItemBase.getCapPSLanResId() != null) {
            object = pSDEACModeItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeItemBase.getCapPSLanResName() != null) {
            object = pSDEACModeItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEACModeItemBase.getCaption() != null) {
            object = pSDEACModeItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getCLConvertFlag() != null) {
            object = pSDEACModeItemBase.getCLConvertFlag();
            xmlNode.setAttribute(FIELD_CLCONVERTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getCreateDate() != null) {
            object = pSDEACModeItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getCreateMan() != null) {
            object = pSDEACModeItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getCustomCode() != null) {
            object = pSDEACModeItemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getCustomMode() != null) {
            object = pSDEACModeItemBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getDynaModelFlag() != null) {
            object = pSDEACModeItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getMemo() != null) {
            object = pSDEACModeItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getOrderValue() != null) {
            object = pSDEACModeItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getPSCodeListId() != null) {
            object = pSDEACModeItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSCodeListName() != null) {
            object = pSDEACModeItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeId() != null) {
            object = pSDEACModeItemBase.getPSDEACModeId();
            xmlNode.setAttribute(FIELD_PSDEACMODEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeItemId() != null) {
            object = pSDEACModeItemBase.getPSDEACModeItemId();
            xmlNode.setAttribute(FIELD_PSDEACMODEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeItemName() != null) {
            object = pSDEACModeItemBase.getPSDEACModeItemName();
            xmlNode.setAttribute(FIELD_PSDEACMODEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEACModeName() != null) {
            object = pSDEACModeItemBase.getPSDEACModeName();
            xmlNode.setAttribute(FIELD_PSDEACMODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEFId() != null) {
            object = pSDEACModeItemBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDEFName() != null) {
            object = pSDEACModeItemBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getPSDynaInstId() != null) {
            object = pSDEACModeItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUpdateDate() != null) {
            object = pSDEACModeItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getUpdateMan() != null) {
            object = pSDEACModeItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUserCat() != null) {
            object = pSDEACModeItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUserTag() != null) {
            object = pSDEACModeItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUserTag2() != null) {
            object = pSDEACModeItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUserTag3() != null) {
            object = pSDEACModeItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getUserTag4() != null) {
            object = pSDEACModeItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getValueFormat() != null) {
            object = pSDEACModeItemBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEACModeItemBase.getWidth() != null) {
            object = pSDEACModeItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEACModeItemBase.getWidthUnit() != null) {
            object = pSDEACModeItemBase.getWidthUnit();
            xmlNode.setAttribute(FIELD_WIDTHUNIT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEACModeItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEACModeItemBase pSDEACModeItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEACModeItemBase.isCapPSLanResIdDirty() && (bl || pSDEACModeItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEACModeItemBase.getCapPSLanResId());
        }
        if (pSDEACModeItemBase.isCapPSLanResNameDirty() && (bl || pSDEACModeItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEACModeItemBase.getCapPSLanResName());
        }
        if (pSDEACModeItemBase.isCaptionDirty() && (bl || pSDEACModeItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEACModeItemBase.getCaption());
        }
        if (pSDEACModeItemBase.isCLConvertFlagDirty() && (bl || pSDEACModeItemBase.getCLConvertFlag() != null)) {
            iDataObject.set(FIELD_CLCONVERTFLAG, (Object)pSDEACModeItemBase.getCLConvertFlag());
        }
        if (pSDEACModeItemBase.isCreateDateDirty() && (bl || pSDEACModeItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEACModeItemBase.getCreateDate());
        }
        if (pSDEACModeItemBase.isCreateManDirty() && (bl || pSDEACModeItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEACModeItemBase.getCreateMan());
        }
        if (pSDEACModeItemBase.isCustomCodeDirty() && (bl || pSDEACModeItemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEACModeItemBase.getCustomCode());
        }
        if (pSDEACModeItemBase.isCustomModeDirty() && (bl || pSDEACModeItemBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEACModeItemBase.getCustomMode());
        }
        if (pSDEACModeItemBase.isDynaModelFlagDirty() && (bl || pSDEACModeItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEACModeItemBase.getDynaModelFlag());
        }
        if (pSDEACModeItemBase.isMemoDirty() && (bl || pSDEACModeItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEACModeItemBase.getMemo());
        }
        if (pSDEACModeItemBase.isOrderValueDirty() && (bl || pSDEACModeItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEACModeItemBase.getOrderValue());
        }
        if (pSDEACModeItemBase.isPSCodeListIdDirty() && (bl || pSDEACModeItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEACModeItemBase.getPSCodeListId());
        }
        if (pSDEACModeItemBase.isPSCodeListNameDirty() && (bl || pSDEACModeItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEACModeItemBase.getPSCodeListName());
        }
        if (pSDEACModeItemBase.isPSDEACModeIdDirty() && (bl || pSDEACModeItemBase.getPSDEACModeId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEID, (Object)pSDEACModeItemBase.getPSDEACModeId());
        }
        if (pSDEACModeItemBase.isPSDEACModeItemIdDirty() && (bl || pSDEACModeItemBase.getPSDEACModeItemId() != null)) {
            iDataObject.set(FIELD_PSDEACMODEITEMID, (Object)pSDEACModeItemBase.getPSDEACModeItemId());
        }
        if (pSDEACModeItemBase.isPSDEACModeItemNameDirty() && (bl || pSDEACModeItemBase.getPSDEACModeItemName() != null)) {
            iDataObject.set(FIELD_PSDEACMODEITEMNAME, (Object)pSDEACModeItemBase.getPSDEACModeItemName());
        }
        if (pSDEACModeItemBase.isPSDEACModeNameDirty() && (bl || pSDEACModeItemBase.getPSDEACModeName() != null)) {
            iDataObject.set(FIELD_PSDEACMODENAME, (Object)pSDEACModeItemBase.getPSDEACModeName());
        }
        if (pSDEACModeItemBase.isPSDEFIdDirty() && (bl || pSDEACModeItemBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEACModeItemBase.getPSDEFId());
        }
        if (pSDEACModeItemBase.isPSDEFNameDirty() && (bl || pSDEACModeItemBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEACModeItemBase.getPSDEFName());
        }
        if (pSDEACModeItemBase.isPSDynaInstIdDirty() && (bl || pSDEACModeItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEACModeItemBase.getPSDynaInstId());
        }
        if (pSDEACModeItemBase.isUpdateDateDirty() && (bl || pSDEACModeItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEACModeItemBase.getUpdateDate());
        }
        if (pSDEACModeItemBase.isUpdateManDirty() && (bl || pSDEACModeItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEACModeItemBase.getUpdateMan());
        }
        if (pSDEACModeItemBase.isUserCatDirty() && (bl || pSDEACModeItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEACModeItemBase.getUserCat());
        }
        if (pSDEACModeItemBase.isUserTagDirty() && (bl || pSDEACModeItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEACModeItemBase.getUserTag());
        }
        if (pSDEACModeItemBase.isUserTag2Dirty() && (bl || pSDEACModeItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEACModeItemBase.getUserTag2());
        }
        if (pSDEACModeItemBase.isUserTag3Dirty() && (bl || pSDEACModeItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEACModeItemBase.getUserTag3());
        }
        if (pSDEACModeItemBase.isUserTag4Dirty() && (bl || pSDEACModeItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEACModeItemBase.getUserTag4());
        }
        if (pSDEACModeItemBase.isValueFormatDirty() && (bl || pSDEACModeItemBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEACModeItemBase.getValueFormat());
        }
        if (pSDEACModeItemBase.isWidthDirty() && (bl || pSDEACModeItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEACModeItemBase.getWidth());
        }
        if (pSDEACModeItemBase.isWidthUnitDirty() && (bl || pSDEACModeItemBase.getWidthUnit() != null)) {
            iDataObject.set(FIELD_WIDTHUNIT, (Object)pSDEACModeItemBase.getWidthUnit());
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
        return PSDEACModeItemBase.remove(this, n);
    }

    private static boolean remove(PSDEACModeItemBase pSDEACModeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEACModeItemBase.resetCapPSLanResId();
                return true;
            }
            case 1: {
                pSDEACModeItemBase.resetCapPSLanResName();
                return true;
            }
            case 2: {
                pSDEACModeItemBase.resetCaption();
                return true;
            }
            case 3: {
                pSDEACModeItemBase.resetCLConvertFlag();
                return true;
            }
            case 4: {
                pSDEACModeItemBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSDEACModeItemBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSDEACModeItemBase.resetCustomCode();
                return true;
            }
            case 7: {
                pSDEACModeItemBase.resetCustomMode();
                return true;
            }
            case 8: {
                pSDEACModeItemBase.resetDynaModelFlag();
                return true;
            }
            case 9: {
                pSDEACModeItemBase.resetMemo();
                return true;
            }
            case 10: {
                pSDEACModeItemBase.resetOrderValue();
                return true;
            }
            case 11: {
                pSDEACModeItemBase.resetPSCodeListId();
                return true;
            }
            case 12: {
                pSDEACModeItemBase.resetPSCodeListName();
                return true;
            }
            case 13: {
                pSDEACModeItemBase.resetPSDEACModeId();
                return true;
            }
            case 14: {
                pSDEACModeItemBase.resetPSDEACModeItemId();
                return true;
            }
            case 15: {
                pSDEACModeItemBase.resetPSDEACModeItemName();
                return true;
            }
            case 16: {
                pSDEACModeItemBase.resetPSDEACModeName();
                return true;
            }
            case 17: {
                pSDEACModeItemBase.resetPSDEFId();
                return true;
            }
            case 18: {
                pSDEACModeItemBase.resetPSDEFName();
                return true;
            }
            case 19: {
                pSDEACModeItemBase.resetPSDynaInstId();
                return true;
            }
            case 20: {
                pSDEACModeItemBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSDEACModeItemBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSDEACModeItemBase.resetUserCat();
                return true;
            }
            case 23: {
                pSDEACModeItemBase.resetUserTag();
                return true;
            }
            case 24: {
                pSDEACModeItemBase.resetUserTag2();
                return true;
            }
            case 25: {
                pSDEACModeItemBase.resetUserTag3();
                return true;
            }
            case 26: {
                pSDEACModeItemBase.resetUserTag4();
                return true;
            }
            case 27: {
                pSDEACModeItemBase.resetValueFormat();
                return true;
            }
            case 28: {
                pSDEACModeItemBase.resetWidth();
                return true;
            }
            case 29: {
                pSDEACModeItemBase.resetWidthUnit();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeList getPSCodeList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeList();
        }
        if (this.getPSCodeListId() == null) {
            return null;
        }
        Integer n = this.objPSCodeListLock;
        synchronized (n) {
            if (this.pscodelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSCodeListId(), (Object)this.pscodelist.getPSCodeListId()) != 0L) {
                this.pscodelist = null;
            }
            if (this.pscodelist == null) {
                PSCodeList pSCodeList = new PSCodeList();
                pSCodeList.setPSCodeListId(this.getPSCodeListId());
                PSCodeListService pSCodeListService = (PSCodeListService)ServiceGlobal.getService(PSCodeListService.class, (SessionFactory)this.getSessionFactory());
                pSCodeListService.autoGet((IEntity)pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEACMode getPSDEACMode() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEACMode();
        }
        if (this.getPSDEACModeId() == null) {
            return null;
        }
        Integer n = this.objPSDEACModeLock;
        synchronized (n) {
            if (this.psdeacmode != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEACModeId(), (Object)this.psdeacmode.getPSDEACModeId()) != 0L) {
                this.psdeacmode = null;
            }
            if (this.psdeacmode == null) {
                PSDEACMode pSDEACMode = new PSDEACMode();
                pSDEACMode.setPSDEACModeId(this.getPSDEACModeId());
                PSDEACModeService pSDEACModeService = (PSDEACModeService)ServiceGlobal.getService(PSDEACModeService.class, (SessionFactory)this.getSessionFactory());
                pSDEACModeService.autoGet((IEntity)pSDEACMode);
                this.psdeacmode = pSDEACMode;
            }
            return this.psdeacmode;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getCapPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCapPSLanRes();
        }
        if (this.getCapPSLanResId() == null) {
            return null;
        }
        Integer n = this.objCapPSLanResLock;
        synchronized (n) {
            if (this.cappslanres != null && DataTypeHelper.compare((int)25, (Object)this.getCapPSLanResId(), (Object)this.cappslanres.getPSLanguageResId()) != 0L) {
                this.cappslanres = null;
            }
            if (this.cappslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getCapPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    private PSDEACModeItemBase getProxyEntity() {
        return this.proxyPSDEACModeItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEACModeItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEACModeItemBase) {
            this.proxyPSDEACModeItemBase = (PSDEACModeItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEACModeItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 1);
        fieldIndexMap.put(FIELD_CAPTION, 2);
        fieldIndexMap.put(FIELD_CLCONVERTFLAG, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 6);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 7);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_ORDERVALUE, 10);
        fieldIndexMap.put(FIELD_PSCODELISTID, 11);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 12);
        fieldIndexMap.put(FIELD_PSDEACMODEID, 13);
        fieldIndexMap.put(FIELD_PSDEACMODEITEMID, 14);
        fieldIndexMap.put(FIELD_PSDEACMODEITEMNAME, 15);
        fieldIndexMap.put(FIELD_PSDEACMODENAME, 16);
        fieldIndexMap.put(FIELD_PSDEFID, 17);
        fieldIndexMap.put(FIELD_PSDEFNAME, 18);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_USERCAT, 22);
        fieldIndexMap.put(FIELD_USERTAG, 23);
        fieldIndexMap.put(FIELD_USERTAG2, 24);
        fieldIndexMap.put(FIELD_USERTAG3, 25);
        fieldIndexMap.put(FIELD_USERTAG4, 26);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 27);
        fieldIndexMap.put(FIELD_WIDTH, 28);
        fieldIndexMap.put(FIELD_WIDTHUNIT, 29);
    }
}

