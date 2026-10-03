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
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSCodeItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSCodeItemBase.class);
    public static final String FIELD_BEGINVALUE = "BEGINVALUE";
    public static final String FIELD_BKCOLOR = "BKCOLOR";
    public static final String FIELD_CODEITEMVALUE = "CODEITEMVALUE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_COLOR = "COLOR";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSCLASS = "CSSCLASS";
    public static final String FIELD_DATA = "DATA";
    public static final String FIELD_DEFAULTFLAG = "DEFAULTFLAG";
    public static final String FIELD_DISABLESELECT = "DISABLESELECT";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENDVALUE = "ENDVALUE";
    public static final String FIELD_ICONCLS = "ICONCLS";
    public static final String FIELD_INCBEGINVALUE = "INCBEGINVALUE";
    public static final String FIELD_INCENDVALUE = "INCENDVALUE";
    public static final String FIELD_LEVELTAG = "LEVELTAG";
    public static final String FIELD_LEVELVALUE = "LEVELVALUE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PPSCODEITEMID = "PPSCODEITEMID";
    public static final String FIELD_PPSCODEITEMNAME = "PPSCODEITEMNAME";
    public static final String FIELD_PSCODEITEMID = "PSCODEITEMID";
    public static final String FIELD_PSCODEITEMNAME = "PSCODEITEMNAME";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_SHORTKEY = "SHORTKEY";
    public static final String FIELD_SHOWASALL = "SHOWASALL";
    public static final String FIELD_SHOWASEMPTY = "SHOWASEMPTY";
    public static final String FIELD_TEXTPSLANRESID = "TEXTPSLANRESID";
    public static final String FIELD_TEXTPSLANRESNAME = "TEXTPSLANRESNAME";
    public static final String FIELD_THRESHOLDGROUPFLAG = "THRESHOLDGROUPFLAG";
    public static final String FIELD_TIPPSLANRESID = "TIPPSLANRESID";
    public static final String FIELD_TIPPSLANRESNAME = "TIPPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERDATA = "USERDATA";
    public static final String FIELD_USERDATA2 = "USERDATA2";
    public static final String FIELD_USERPARAMS = "USERPARAMS";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BEGINVALUE = 0;
    private static final int INDEX_BKCOLOR = 1;
    private static final int INDEX_CODEITEMVALUE = 2;
    private static final int INDEX_CODENAME = 3;
    private static final int INDEX_COLOR = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CSSCLASS = 7;
    private static final int INDEX_DATA = 8;
    private static final int INDEX_DEFAULTFLAG = 9;
    private static final int INDEX_DISABLESELECT = 10;
    private static final int INDEX_DYNAMODELFLAG = 11;
    private static final int INDEX_ENDVALUE = 12;
    private static final int INDEX_ICONCLS = 13;
    private static final int INDEX_INCBEGINVALUE = 14;
    private static final int INDEX_INCENDVALUE = 15;
    private static final int INDEX_LEVELTAG = 16;
    private static final int INDEX_LEVELVALUE = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_ORDERVALUE = 19;
    private static final int INDEX_PPSCODEITEMID = 20;
    private static final int INDEX_PPSCODEITEMNAME = 21;
    private static final int INDEX_PSCODEITEMID = 22;
    private static final int INDEX_PSCODEITEMNAME = 23;
    private static final int INDEX_PSCODELISTID = 24;
    private static final int INDEX_PSCODELISTNAME = 25;
    private static final int INDEX_PSDYNAINSTID = 26;
    private static final int INDEX_PSSYSCSSID = 27;
    private static final int INDEX_PSSYSCSSNAME = 28;
    private static final int INDEX_PSSYSIMAGEID = 29;
    private static final int INDEX_PSSYSIMAGENAME = 30;
    private static final int INDEX_SHORTKEY = 31;
    private static final int INDEX_SHOWASALL = 32;
    private static final int INDEX_SHOWASEMPTY = 33;
    private static final int INDEX_TEXTPSLANRESID = 34;
    private static final int INDEX_TEXTPSLANRESNAME = 35;
    private static final int INDEX_THRESHOLDGROUPFLAG = 36;
    private static final int INDEX_TIPPSLANRESID = 37;
    private static final int INDEX_TIPPSLANRESNAME = 38;
    private static final int INDEX_TOOLTIPINFO = 39;
    private static final int INDEX_UPDATEDATE = 40;
    private static final int INDEX_UPDATEMAN = 41;
    private static final int INDEX_USERCAT = 42;
    private static final int INDEX_USERDATA = 43;
    private static final int INDEX_USERDATA2 = 44;
    private static final int INDEX_USERPARAMS = 45;
    private static final int INDEX_USERTAG = 46;
    private static final int INDEX_USERTAG2 = 47;
    private static final int INDEX_USERTAG3 = 48;
    private static final int INDEX_USERTAG4 = 49;
    private static final int INDEX_VALIDFLAG = 50;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSCodeItemBase proxyPSCodeItemBase = null;
    private boolean beginvalueDirtyFlag = false;
    private boolean bkcolorDirtyFlag = false;
    private boolean codeitemvalueDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean colorDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean cssclassDirtyFlag = false;
    private boolean dataDirtyFlag = false;
    private boolean defaultflagDirtyFlag = false;
    private boolean disableselectDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean endvalueDirtyFlag = false;
    private boolean iconclsDirtyFlag = false;
    private boolean incbeginvalueDirtyFlag = false;
    private boolean incendvalueDirtyFlag = false;
    private boolean leveltagDirtyFlag = false;
    private boolean levelvalueDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean ppscodeitemidDirtyFlag = false;
    private boolean ppscodeitemnameDirtyFlag = false;
    private boolean pscodeitemidDirtyFlag = false;
    private boolean pscodeitemnameDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean shortkeyDirtyFlag = false;
    private boolean showasallDirtyFlag = false;
    private boolean showasemptyDirtyFlag = false;
    private boolean textpslanresidDirtyFlag = false;
    private boolean textpslanresnameDirtyFlag = false;
    private boolean thresholdgroupflagDirtyFlag = false;
    private boolean tippslanresidDirtyFlag = false;
    private boolean tippslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean userdataDirtyFlag = false;
    private boolean userdata2DirtyFlag = false;
    private boolean userparamsDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="beginvalue")
    private Double beginvalue;
    @Column(name="bkcolor")
    private String bkcolor;
    @Column(name="codeitemvalue")
    private String codeitemvalue;
    @Column(name="codename")
    private String codename;
    @Column(name="color")
    private String color;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="cssclass")
    private String cssclass;
    @Column(name="data")
    private String data;
    @Column(name="defaultflag")
    private Integer defaultflag;
    @Column(name="disableselect")
    private Integer disableselect;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="endvalue")
    private Double endvalue;
    @Column(name="iconcls")
    private String iconcls;
    @Column(name="incbeginvalue")
    private Integer incbeginvalue;
    @Column(name="incendvalue")
    private Integer incendvalue;
    @Column(name="leveltag")
    private String leveltag;
    @Column(name="levelvalue")
    private Integer levelvalue;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="ppscodeitemid")
    private String ppscodeitemid;
    @Column(name="ppscodeitemname")
    private String ppscodeitemname;
    @Column(name="pscodeitemid")
    private String pscodeitemid;
    @Column(name="pscodeitemname")
    private String pscodeitemname;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="shortkey")
    private String shortkey;
    @Column(name="showasall")
    private Integer showasall;
    @Column(name="showasempty")
    private Integer showasempty;
    @Column(name="textpslanresid")
    private String textpslanresid;
    @Column(name="textpslanresname")
    private String textpslanresname;
    @Column(name="thresholdgroupflag")
    private Integer thresholdgroupflag;
    @Column(name="tippslanresid")
    private String tippslanresid;
    @Column(name="tippslanresname")
    private String tippslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usercat")
    private String usercat;
    @Column(name="userdata")
    private String userdata;
    @Column(name="userdata2")
    private String userdata2;
    @Column(name="userparams")
    private String userparams;
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
    private Integer objPPSCodeItemLock = new Integer(1);
    private PSCodeItem ppscodeitem = null;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objTextPSLanResLock = new Integer(1);
    private PSLanguageRes textpslanres = null;
    private Integer objTipPSLanResLock = new Integer(1);
    private PSLanguageRes tippslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSCodeItemsLock = new Integer(1);
    private ArrayList<PSCodeItem> pscodeitems = null;

    public void setBeginValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeginValue(d);
            return;
        }
        this.beginvalue = d;
        this.beginvalueDirtyFlag = true;
    }

    public Double getBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeginValue();
        }
        return this.beginvalue;
    }

    public boolean isBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeginValueDirty();
        }
        return this.beginvalueDirtyFlag;
    }

    public void resetBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeginValue();
            return;
        }
        this.beginvalueDirtyFlag = false;
        this.beginvalue = null;
    }

    public void setBKColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBKColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bkcolor = string;
        this.bkcolorDirtyFlag = true;
    }

    public String getBKColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBKColor();
        }
        return this.bkcolor;
    }

    public boolean isBKColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBKColorDirty();
        }
        return this.bkcolorDirtyFlag;
    }

    public void resetBKColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBKColor();
            return;
        }
        this.bkcolorDirtyFlag = false;
        this.bkcolor = null;
    }

    public void setCodeItemValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCodeItemValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.codeitemvalue = string;
        this.codeitemvalueDirtyFlag = true;
    }

    public String getCodeItemValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCodeItemValue();
        }
        return this.codeitemvalue;
    }

    public boolean isCodeItemValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCodeItemValueDirty();
        }
        return this.codeitemvalueDirtyFlag;
    }

    public void resetCodeItemValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCodeItemValue();
            return;
        }
        this.codeitemvalueDirtyFlag = false;
        this.codeitemvalue = null;
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

    public void setCssClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssclass = string;
        this.cssclassDirtyFlag = true;
    }

    public String getCssClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssClass();
        }
        return this.cssclass;
    }

    public boolean isCssClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssClassDirty();
        }
        return this.cssclassDirtyFlag;
    }

    public void resetCssClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssClass();
            return;
        }
        this.cssclassDirtyFlag = false;
        this.cssclass = null;
    }

    public void setData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.data = string;
        this.dataDirtyFlag = true;
    }

    public String getData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getData();
        }
        return this.data;
    }

    public boolean isDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataDirty();
        }
        return this.dataDirtyFlag;
    }

    public void resetData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetData();
            return;
        }
        this.dataDirtyFlag = false;
        this.data = null;
    }

    public void setDefaultFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultFlag(n);
            return;
        }
        this.defaultflag = n;
        this.defaultflagDirtyFlag = true;
    }

    public Integer getDefaultFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultFlag();
        }
        return this.defaultflag;
    }

    public boolean isDefaultFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultFlagDirty();
        }
        return this.defaultflagDirtyFlag;
    }

    public void resetDefaultFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultFlag();
            return;
        }
        this.defaultflagDirtyFlag = false;
        this.defaultflag = null;
    }

    public void setDisableSelect(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDisableSelect(n);
            return;
        }
        this.disableselect = n;
        this.disableselectDirtyFlag = true;
    }

    public Integer getDisableSelect() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDisableSelect();
        }
        return this.disableselect;
    }

    public boolean isDisableSelectDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDisableSelectDirty();
        }
        return this.disableselectDirtyFlag;
    }

    public void resetDisableSelect() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDisableSelect();
            return;
        }
        this.disableselectDirtyFlag = false;
        this.disableselect = null;
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

    public void setEndValue(Double d) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEndValue(d);
            return;
        }
        this.endvalue = d;
        this.endvalueDirtyFlag = true;
    }

    public Double getEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEndValue();
        }
        return this.endvalue;
    }

    public boolean isEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEndValueDirty();
        }
        return this.endvalueDirtyFlag;
    }

    public void resetEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEndValue();
            return;
        }
        this.endvalueDirtyFlag = false;
        this.endvalue = null;
    }

    public void setIconCls(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIconCls(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.iconcls = string;
        this.iconclsDirtyFlag = true;
    }

    public String getIconCls() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIconCls();
        }
        return this.iconcls;
    }

    public boolean isIconClsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIconClsDirty();
        }
        return this.iconclsDirtyFlag;
    }

    public void resetIconCls() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIconCls();
            return;
        }
        this.iconclsDirtyFlag = false;
        this.iconcls = null;
    }

    public void setIncBeginValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncBeginValue(n);
            return;
        }
        this.incbeginvalue = n;
        this.incbeginvalueDirtyFlag = true;
    }

    public Integer getIncBeginValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncBeginValue();
        }
        return this.incbeginvalue;
    }

    public boolean isIncBeginValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncBeginValueDirty();
        }
        return this.incbeginvalueDirtyFlag;
    }

    public void resetIncBeginValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncBeginValue();
            return;
        }
        this.incbeginvalueDirtyFlag = false;
        this.incbeginvalue = null;
    }

    public void setIncEndValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setIncEndValue(n);
            return;
        }
        this.incendvalue = n;
        this.incendvalueDirtyFlag = true;
    }

    public Integer getIncEndValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getIncEndValue();
        }
        return this.incendvalue;
    }

    public boolean isIncEndValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isIncEndValueDirty();
        }
        return this.incendvalueDirtyFlag;
    }

    public void resetIncEndValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetIncEndValue();
            return;
        }
        this.incendvalueDirtyFlag = false;
        this.incendvalue = null;
    }

    public void setLevelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.leveltag = string;
        this.leveltagDirtyFlag = true;
    }

    public String getLevelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelTag();
        }
        return this.leveltag;
    }

    public boolean isLevelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelTagDirty();
        }
        return this.leveltagDirtyFlag;
    }

    public void resetLevelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelTag();
            return;
        }
        this.leveltagDirtyFlag = false;
        this.leveltag = null;
    }

    public void setLevelValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLevelValue(n);
            return;
        }
        this.levelvalue = n;
        this.levelvalueDirtyFlag = true;
    }

    public Integer getLevelValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLevelValue();
        }
        return this.levelvalue;
    }

    public boolean isLevelValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLevelValueDirty();
        }
        return this.levelvalueDirtyFlag;
    }

    public void resetLevelValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLevelValue();
            return;
        }
        this.levelvalueDirtyFlag = false;
        this.levelvalue = null;
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

    public void setPPSCodeItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCodeItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppscodeitemid = string;
        this.ppscodeitemidDirtyFlag = true;
    }

    public String getPPSCodeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCodeItemId();
        }
        return this.ppscodeitemid;
    }

    public boolean isPPSCodeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCodeItemIdDirty();
        }
        return this.ppscodeitemidDirtyFlag;
    }

    public void resetPPSCodeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCodeItemId();
            return;
        }
        this.ppscodeitemidDirtyFlag = false;
        this.ppscodeitemid = null;
    }

    public void setPPSCodeItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSCodeItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppscodeitemname = string;
        this.ppscodeitemnameDirtyFlag = true;
    }

    public String getPPSCodeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCodeItemName();
        }
        return this.ppscodeitemname;
    }

    public boolean isPPSCodeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSCodeItemNameDirty();
        }
        return this.ppscodeitemnameDirtyFlag;
    }

    public void resetPPSCodeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSCodeItemName();
            return;
        }
        this.ppscodeitemnameDirtyFlag = false;
        this.ppscodeitemname = null;
    }

    public void setPSCodeItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodeitemid = string;
        this.pscodeitemidDirtyFlag = true;
    }

    public String getPSCodeItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeItemId();
        }
        return this.pscodeitemid;
    }

    public boolean isPSCodeItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeItemIdDirty();
        }
        return this.pscodeitemidDirtyFlag;
    }

    public void resetPSCodeItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeItemId();
            return;
        }
        this.pscodeitemidDirtyFlag = false;
        this.pscodeitemid = null;
    }

    public void setPSCodeItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCodeItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscodeitemname = string;
        this.pscodeitemnameDirtyFlag = true;
    }

    public String getPSCodeItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeItemName();
        }
        return this.pscodeitemname;
    }

    public boolean isPSCodeItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCodeItemNameDirty();
        }
        return this.pscodeitemnameDirtyFlag;
    }

    public void resetPSCodeItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCodeItemName();
            return;
        }
        this.pscodeitemnameDirtyFlag = false;
        this.pscodeitemname = null;
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

    public void setPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssid = string;
        this.pssyscssidDirtyFlag = true;
    }

    public String getPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssId();
        }
        return this.pssyscssid;
    }

    public boolean isPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssIdDirty();
        }
        return this.pssyscssidDirtyFlag;
    }

    public void resetPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssId();
            return;
        }
        this.pssyscssidDirtyFlag = false;
        this.pssyscssid = null;
    }

    public void setPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscssname = string;
        this.pssyscssnameDirtyFlag = true;
    }

    public String getPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssName();
        }
        return this.pssyscssname;
    }

    public boolean isPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssNameDirty();
        }
        return this.pssyscssnameDirtyFlag;
    }

    public void resetPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssName();
            return;
        }
        this.pssyscssnameDirtyFlag = false;
        this.pssyscssname = null;
    }

    public void setPSSysImageId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimageid = string;
        this.pssysimageidDirtyFlag = true;
    }

    public String getPSSysImageId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageId();
        }
        return this.pssysimageid;
    }

    public boolean isPSSysImageIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageIdDirty();
        }
        return this.pssysimageidDirtyFlag;
    }

    public void resetPSSysImageId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageId();
            return;
        }
        this.pssysimageidDirtyFlag = false;
        this.pssysimageid = null;
    }

    public void setPSSysImageName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysImageName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysimagename = string;
        this.pssysimagenameDirtyFlag = true;
    }

    public String getPSSysImageName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImageName();
        }
        return this.pssysimagename;
    }

    public boolean isPSSysImageNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysImageNameDirty();
        }
        return this.pssysimagenameDirtyFlag;
    }

    public void resetPSSysImageName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysImageName();
            return;
        }
        this.pssysimagenameDirtyFlag = false;
        this.pssysimagename = null;
    }

    public void setShortKey(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShortKey(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.shortkey = string;
        this.shortkeyDirtyFlag = true;
    }

    public String getShortKey() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShortKey();
        }
        return this.shortkey;
    }

    public boolean isShortKeyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShortKeyDirty();
        }
        return this.shortkeyDirtyFlag;
    }

    public void resetShortKey() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShortKey();
            return;
        }
        this.shortkeyDirtyFlag = false;
        this.shortkey = null;
    }

    public void setShowAsAll(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowAsAll(n);
            return;
        }
        this.showasall = n;
        this.showasallDirtyFlag = true;
    }

    public Integer getShowAsAll() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowAsAll();
        }
        return this.showasall;
    }

    public boolean isShowAsAllDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowAsAllDirty();
        }
        return this.showasallDirtyFlag;
    }

    public void resetShowAsAll() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowAsAll();
            return;
        }
        this.showasallDirtyFlag = false;
        this.showasall = null;
    }

    public void setShowAsEmpty(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowAsEmpty(n);
            return;
        }
        this.showasempty = n;
        this.showasemptyDirtyFlag = true;
    }

    public Integer getShowAsEmpty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowAsEmpty();
        }
        return this.showasempty;
    }

    public boolean isShowAsEmptyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowAsEmptyDirty();
        }
        return this.showasemptyDirtyFlag;
    }

    public void resetShowAsEmpty() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowAsEmpty();
            return;
        }
        this.showasemptyDirtyFlag = false;
        this.showasempty = null;
    }

    public void setTextPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresid = string;
        this.textpslanresidDirtyFlag = true;
    }

    public String getTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResId();
        }
        return this.textpslanresid;
    }

    public boolean isTextPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResIdDirty();
        }
        return this.textpslanresidDirtyFlag;
    }

    public void resetTextPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResId();
            return;
        }
        this.textpslanresidDirtyFlag = false;
        this.textpslanresid = null;
    }

    public void setTextPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTextPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.textpslanresname = string;
        this.textpslanresnameDirtyFlag = true;
    }

    public String getTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanResName();
        }
        return this.textpslanresname;
    }

    public boolean isTextPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTextPSLanResNameDirty();
        }
        return this.textpslanresnameDirtyFlag;
    }

    public void resetTextPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTextPSLanResName();
            return;
        }
        this.textpslanresnameDirtyFlag = false;
        this.textpslanresname = null;
    }

    public void setThresholdGroupFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setThresholdGroupFlag(n);
            return;
        }
        this.thresholdgroupflag = n;
        this.thresholdgroupflagDirtyFlag = true;
    }

    public Integer getThresholdGroupFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getThresholdGroupFlag();
        }
        return this.thresholdgroupflag;
    }

    public boolean isThresholdGroupFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isThresholdGroupFlagDirty();
        }
        return this.thresholdgroupflagDirtyFlag;
    }

    public void resetThresholdGroupFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetThresholdGroupFlag();
            return;
        }
        this.thresholdgroupflagDirtyFlag = false;
        this.thresholdgroupflag = null;
    }

    public void setTipPSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresid = string;
        this.tippslanresidDirtyFlag = true;
    }

    public String getTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResId();
        }
        return this.tippslanresid;
    }

    public boolean isTipPSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResIdDirty();
        }
        return this.tippslanresidDirtyFlag;
    }

    public void resetTipPSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResId();
            return;
        }
        this.tippslanresidDirtyFlag = false;
        this.tippslanresid = null;
    }

    public void setTipPSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTipPSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tippslanresname = string;
        this.tippslanresnameDirtyFlag = true;
    }

    public String getTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanResName();
        }
        return this.tippslanresname;
    }

    public boolean isTipPSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTipPSLanResNameDirty();
        }
        return this.tippslanresnameDirtyFlag;
    }

    public void resetTipPSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTipPSLanResName();
            return;
        }
        this.tippslanresnameDirtyFlag = false;
        this.tippslanresname = null;
    }

    public void setTooltipInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTooltipInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.tooltipinfo = string;
        this.tooltipinfoDirtyFlag = true;
    }

    public String getTooltipInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTooltipInfo();
        }
        return this.tooltipinfo;
    }

    public boolean isTooltipInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTooltipInfoDirty();
        }
        return this.tooltipinfoDirtyFlag;
    }

    public void resetTooltipInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTooltipInfo();
            return;
        }
        this.tooltipinfoDirtyFlag = false;
        this.tooltipinfo = null;
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

    public void setUserData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata = string;
        this.userdataDirtyFlag = true;
    }

    public String getUserData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData();
        }
        return this.userdata;
    }

    public boolean isUserDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserDataDirty();
        }
        return this.userdataDirtyFlag;
    }

    public void resetUserData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData();
            return;
        }
        this.userdataDirtyFlag = false;
        this.userdata = null;
    }

    public void setUserData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userdata2 = string;
        this.userdata2DirtyFlag = true;
    }

    public String getUserData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserData2();
        }
        return this.userdata2;
    }

    public boolean isUserData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserData2Dirty();
        }
        return this.userdata2DirtyFlag;
    }

    public void resetUserData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserData2();
            return;
        }
        this.userdata2DirtyFlag = false;
        this.userdata2 = null;
    }

    public void setUserParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUserParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.userparams = string;
        this.userparamsDirtyFlag = true;
    }

    public String getUserParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUserParams();
        }
        return this.userparams;
    }

    public boolean isUserParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUserParamsDirty();
        }
        return this.userparamsDirtyFlag;
    }

    public void resetUserParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUserParams();
            return;
        }
        this.userparamsDirtyFlag = false;
        this.userparams = null;
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
        PSCodeItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSCodeItemBase pSCodeItemBase) {
        pSCodeItemBase.resetBeginValue();
        pSCodeItemBase.resetBKColor();
        pSCodeItemBase.resetCodeItemValue();
        pSCodeItemBase.resetCodeName();
        pSCodeItemBase.resetColor();
        pSCodeItemBase.resetCreateDate();
        pSCodeItemBase.resetCreateMan();
        pSCodeItemBase.resetCssClass();
        pSCodeItemBase.resetData();
        pSCodeItemBase.resetDefaultFlag();
        pSCodeItemBase.resetDisableSelect();
        pSCodeItemBase.resetDynaModelFlag();
        pSCodeItemBase.resetEndValue();
        pSCodeItemBase.resetIconCls();
        pSCodeItemBase.resetIncBeginValue();
        pSCodeItemBase.resetIncEndValue();
        pSCodeItemBase.resetLevelTag();
        pSCodeItemBase.resetLevelValue();
        pSCodeItemBase.resetMemo();
        pSCodeItemBase.resetOrderValue();
        pSCodeItemBase.resetPPSCodeItemId();
        pSCodeItemBase.resetPPSCodeItemName();
        pSCodeItemBase.resetPSCodeItemId();
        pSCodeItemBase.resetPSCodeItemName();
        pSCodeItemBase.resetPSCodeListId();
        pSCodeItemBase.resetPSCodeListName();
        pSCodeItemBase.resetPSDynaInstId();
        pSCodeItemBase.resetPSSysCssId();
        pSCodeItemBase.resetPSSysCssName();
        pSCodeItemBase.resetPSSysImageId();
        pSCodeItemBase.resetPSSysImageName();
        pSCodeItemBase.resetShortKey();
        pSCodeItemBase.resetShowAsAll();
        pSCodeItemBase.resetShowAsEmpty();
        pSCodeItemBase.resetTextPSLanResId();
        pSCodeItemBase.resetTextPSLanResName();
        pSCodeItemBase.resetThresholdGroupFlag();
        pSCodeItemBase.resetTipPSLanResId();
        pSCodeItemBase.resetTipPSLanResName();
        pSCodeItemBase.resetTooltipInfo();
        pSCodeItemBase.resetUpdateDate();
        pSCodeItemBase.resetUpdateMan();
        pSCodeItemBase.resetUserCat();
        pSCodeItemBase.resetUserData();
        pSCodeItemBase.resetUserData2();
        pSCodeItemBase.resetUserParams();
        pSCodeItemBase.resetUserTag();
        pSCodeItemBase.resetUserTag2();
        pSCodeItemBase.resetUserTag3();
        pSCodeItemBase.resetUserTag4();
        pSCodeItemBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBeginValueDirty()) {
            hashMap.put(FIELD_BEGINVALUE, this.getBeginValue());
        }
        if (!bl || this.isBKColorDirty()) {
            hashMap.put(FIELD_BKCOLOR, this.getBKColor());
        }
        if (!bl || this.isCodeItemValueDirty()) {
            hashMap.put(FIELD_CODEITEMVALUE, this.getCodeItemValue());
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
        if (!bl || this.isCssClassDirty()) {
            hashMap.put(FIELD_CSSCLASS, this.getCssClass());
        }
        if (!bl || this.isDataDirty()) {
            hashMap.put(FIELD_DATA, this.getData());
        }
        if (!bl || this.isDefaultFlagDirty()) {
            hashMap.put(FIELD_DEFAULTFLAG, this.getDefaultFlag());
        }
        if (!bl || this.isDisableSelectDirty()) {
            hashMap.put(FIELD_DISABLESELECT, this.getDisableSelect());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEndValueDirty()) {
            hashMap.put(FIELD_ENDVALUE, this.getEndValue());
        }
        if (!bl || this.isIconClsDirty()) {
            hashMap.put(FIELD_ICONCLS, this.getIconCls());
        }
        if (!bl || this.isIncBeginValueDirty()) {
            hashMap.put(FIELD_INCBEGINVALUE, this.getIncBeginValue());
        }
        if (!bl || this.isIncEndValueDirty()) {
            hashMap.put(FIELD_INCENDVALUE, this.getIncEndValue());
        }
        if (!bl || this.isLevelTagDirty()) {
            hashMap.put(FIELD_LEVELTAG, this.getLevelTag());
        }
        if (!bl || this.isLevelValueDirty()) {
            hashMap.put(FIELD_LEVELVALUE, this.getLevelValue());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPPSCodeItemIdDirty()) {
            hashMap.put(FIELD_PPSCODEITEMID, this.getPPSCodeItemId());
        }
        if (!bl || this.isPPSCodeItemNameDirty()) {
            hashMap.put(FIELD_PPSCODEITEMNAME, this.getPPSCodeItemName());
        }
        if (!bl || this.isPSCodeItemIdDirty()) {
            hashMap.put(FIELD_PSCODEITEMID, this.getPSCodeItemId());
        }
        if (!bl || this.isPSCodeItemNameDirty()) {
            hashMap.put(FIELD_PSCODEITEMNAME, this.getPSCodeItemName());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isShortKeyDirty()) {
            hashMap.put(FIELD_SHORTKEY, this.getShortKey());
        }
        if (!bl || this.isShowAsAllDirty()) {
            hashMap.put(FIELD_SHOWASALL, this.getShowAsAll());
        }
        if (!bl || this.isShowAsEmptyDirty()) {
            hashMap.put(FIELD_SHOWASEMPTY, this.getShowAsEmpty());
        }
        if (!bl || this.isTextPSLanResIdDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESID, this.getTextPSLanResId());
        }
        if (!bl || this.isTextPSLanResNameDirty()) {
            hashMap.put(FIELD_TEXTPSLANRESNAME, this.getTextPSLanResName());
        }
        if (!bl || this.isThresholdGroupFlagDirty()) {
            hashMap.put(FIELD_THRESHOLDGROUPFLAG, this.getThresholdGroupFlag());
        }
        if (!bl || this.isTipPSLanResIdDirty()) {
            hashMap.put(FIELD_TIPPSLANRESID, this.getTipPSLanResId());
        }
        if (!bl || this.isTipPSLanResNameDirty()) {
            hashMap.put(FIELD_TIPPSLANRESNAME, this.getTipPSLanResName());
        }
        if (!bl || this.isTooltipInfoDirty()) {
            hashMap.put(FIELD_TOOLTIPINFO, this.getTooltipInfo());
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
        if (!bl || this.isUserDataDirty()) {
            hashMap.put(FIELD_USERDATA, this.getUserData());
        }
        if (!bl || this.isUserData2Dirty()) {
            hashMap.put(FIELD_USERDATA2, this.getUserData2());
        }
        if (!bl || this.isUserParamsDirty()) {
            hashMap.put(FIELD_USERPARAMS, this.getUserParams());
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
        return PSCodeItemBase.get(this, n);
    }

    private static Object get(PSCodeItemBase pSCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeItemBase.getBeginValue();
            }
            case 1: {
                return pSCodeItemBase.getBKColor();
            }
            case 2: {
                return pSCodeItemBase.getCodeItemValue();
            }
            case 3: {
                return pSCodeItemBase.getCodeName();
            }
            case 4: {
                return pSCodeItemBase.getColor();
            }
            case 5: {
                return pSCodeItemBase.getCreateDate();
            }
            case 6: {
                return pSCodeItemBase.getCreateMan();
            }
            case 7: {
                return pSCodeItemBase.getCssClass();
            }
            case 8: {
                return pSCodeItemBase.getData();
            }
            case 9: {
                return pSCodeItemBase.getDefaultFlag();
            }
            case 10: {
                return pSCodeItemBase.getDisableSelect();
            }
            case 11: {
                return pSCodeItemBase.getDynaModelFlag();
            }
            case 12: {
                return pSCodeItemBase.getEndValue();
            }
            case 13: {
                return pSCodeItemBase.getIconCls();
            }
            case 14: {
                return pSCodeItemBase.getIncBeginValue();
            }
            case 15: {
                return pSCodeItemBase.getIncEndValue();
            }
            case 16: {
                return pSCodeItemBase.getLevelTag();
            }
            case 17: {
                return pSCodeItemBase.getLevelValue();
            }
            case 18: {
                return pSCodeItemBase.getMemo();
            }
            case 19: {
                return pSCodeItemBase.getOrderValue();
            }
            case 20: {
                return pSCodeItemBase.getPPSCodeItemId();
            }
            case 21: {
                return pSCodeItemBase.getPPSCodeItemName();
            }
            case 22: {
                return pSCodeItemBase.getPSCodeItemId();
            }
            case 23: {
                return pSCodeItemBase.getPSCodeItemName();
            }
            case 24: {
                return pSCodeItemBase.getPSCodeListId();
            }
            case 25: {
                return pSCodeItemBase.getPSCodeListName();
            }
            case 26: {
                return pSCodeItemBase.getPSDynaInstId();
            }
            case 27: {
                return pSCodeItemBase.getPSSysCssId();
            }
            case 28: {
                return pSCodeItemBase.getPSSysCssName();
            }
            case 29: {
                return pSCodeItemBase.getPSSysImageId();
            }
            case 30: {
                return pSCodeItemBase.getPSSysImageName();
            }
            case 31: {
                return pSCodeItemBase.getShortKey();
            }
            case 32: {
                return pSCodeItemBase.getShowAsAll();
            }
            case 33: {
                return pSCodeItemBase.getShowAsEmpty();
            }
            case 34: {
                return pSCodeItemBase.getTextPSLanResId();
            }
            case 35: {
                return pSCodeItemBase.getTextPSLanResName();
            }
            case 36: {
                return pSCodeItemBase.getThresholdGroupFlag();
            }
            case 37: {
                return pSCodeItemBase.getTipPSLanResId();
            }
            case 38: {
                return pSCodeItemBase.getTipPSLanResName();
            }
            case 39: {
                return pSCodeItemBase.getTooltipInfo();
            }
            case 40: {
                return pSCodeItemBase.getUpdateDate();
            }
            case 41: {
                return pSCodeItemBase.getUpdateMan();
            }
            case 42: {
                return pSCodeItemBase.getUserCat();
            }
            case 43: {
                return pSCodeItemBase.getUserData();
            }
            case 44: {
                return pSCodeItemBase.getUserData2();
            }
            case 45: {
                return pSCodeItemBase.getUserParams();
            }
            case 46: {
                return pSCodeItemBase.getUserTag();
            }
            case 47: {
                return pSCodeItemBase.getUserTag2();
            }
            case 48: {
                return pSCodeItemBase.getUserTag3();
            }
            case 49: {
                return pSCodeItemBase.getUserTag4();
            }
            case 50: {
                return pSCodeItemBase.getValidFlag();
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
        PSCodeItemBase.set(this, n, object);
    }

    private static void set(PSCodeItemBase pSCodeItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSCodeItemBase.setBeginValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 1: {
                pSCodeItemBase.setBKColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSCodeItemBase.setCodeItemValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSCodeItemBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSCodeItemBase.setColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSCodeItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSCodeItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSCodeItemBase.setCssClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSCodeItemBase.setData(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSCodeItemBase.setDefaultFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSCodeItemBase.setDisableSelect(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSCodeItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSCodeItemBase.setEndValue(DataObject.getDoubleValue((Object)object));
                return;
            }
            case 13: {
                pSCodeItemBase.setIconCls(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSCodeItemBase.setIncBeginValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSCodeItemBase.setIncEndValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSCodeItemBase.setLevelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSCodeItemBase.setLevelValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSCodeItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSCodeItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSCodeItemBase.setPPSCodeItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSCodeItemBase.setPPSCodeItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSCodeItemBase.setPSCodeItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSCodeItemBase.setPSCodeItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSCodeItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSCodeItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSCodeItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSCodeItemBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSCodeItemBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSCodeItemBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSCodeItemBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSCodeItemBase.setShortKey(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSCodeItemBase.setShowAsAll(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 33: {
                pSCodeItemBase.setShowAsEmpty(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 34: {
                pSCodeItemBase.setTextPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSCodeItemBase.setTextPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSCodeItemBase.setThresholdGroupFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 37: {
                pSCodeItemBase.setTipPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSCodeItemBase.setTipPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSCodeItemBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSCodeItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 41: {
                pSCodeItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSCodeItemBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSCodeItemBase.setUserData(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSCodeItemBase.setUserData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSCodeItemBase.setUserParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSCodeItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSCodeItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSCodeItemBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSCodeItemBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSCodeItemBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSCodeItemBase.isNull(this, n);
    }

    private static boolean isNull(PSCodeItemBase pSCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeItemBase.getBeginValue() == null;
            }
            case 1: {
                return pSCodeItemBase.getBKColor() == null;
            }
            case 2: {
                return pSCodeItemBase.getCodeItemValue() == null;
            }
            case 3: {
                return pSCodeItemBase.getCodeName() == null;
            }
            case 4: {
                return pSCodeItemBase.getColor() == null;
            }
            case 5: {
                return pSCodeItemBase.getCreateDate() == null;
            }
            case 6: {
                return pSCodeItemBase.getCreateMan() == null;
            }
            case 7: {
                return pSCodeItemBase.getCssClass() == null;
            }
            case 8: {
                return pSCodeItemBase.getData() == null;
            }
            case 9: {
                return pSCodeItemBase.getDefaultFlag() == null;
            }
            case 10: {
                return pSCodeItemBase.getDisableSelect() == null;
            }
            case 11: {
                return pSCodeItemBase.getDynaModelFlag() == null;
            }
            case 12: {
                return pSCodeItemBase.getEndValue() == null;
            }
            case 13: {
                return pSCodeItemBase.getIconCls() == null;
            }
            case 14: {
                return pSCodeItemBase.getIncBeginValue() == null;
            }
            case 15: {
                return pSCodeItemBase.getIncEndValue() == null;
            }
            case 16: {
                return pSCodeItemBase.getLevelTag() == null;
            }
            case 17: {
                return pSCodeItemBase.getLevelValue() == null;
            }
            case 18: {
                return pSCodeItemBase.getMemo() == null;
            }
            case 19: {
                return pSCodeItemBase.getOrderValue() == null;
            }
            case 20: {
                return pSCodeItemBase.getPPSCodeItemId() == null;
            }
            case 21: {
                return pSCodeItemBase.getPPSCodeItemName() == null;
            }
            case 22: {
                return pSCodeItemBase.getPSCodeItemId() == null;
            }
            case 23: {
                return pSCodeItemBase.getPSCodeItemName() == null;
            }
            case 24: {
                return pSCodeItemBase.getPSCodeListId() == null;
            }
            case 25: {
                return pSCodeItemBase.getPSCodeListName() == null;
            }
            case 26: {
                return pSCodeItemBase.getPSDynaInstId() == null;
            }
            case 27: {
                return pSCodeItemBase.getPSSysCssId() == null;
            }
            case 28: {
                return pSCodeItemBase.getPSSysCssName() == null;
            }
            case 29: {
                return pSCodeItemBase.getPSSysImageId() == null;
            }
            case 30: {
                return pSCodeItemBase.getPSSysImageName() == null;
            }
            case 31: {
                return pSCodeItemBase.getShortKey() == null;
            }
            case 32: {
                return pSCodeItemBase.getShowAsAll() == null;
            }
            case 33: {
                return pSCodeItemBase.getShowAsEmpty() == null;
            }
            case 34: {
                return pSCodeItemBase.getTextPSLanResId() == null;
            }
            case 35: {
                return pSCodeItemBase.getTextPSLanResName() == null;
            }
            case 36: {
                return pSCodeItemBase.getThresholdGroupFlag() == null;
            }
            case 37: {
                return pSCodeItemBase.getTipPSLanResId() == null;
            }
            case 38: {
                return pSCodeItemBase.getTipPSLanResName() == null;
            }
            case 39: {
                return pSCodeItemBase.getTooltipInfo() == null;
            }
            case 40: {
                return pSCodeItemBase.getUpdateDate() == null;
            }
            case 41: {
                return pSCodeItemBase.getUpdateMan() == null;
            }
            case 42: {
                return pSCodeItemBase.getUserCat() == null;
            }
            case 43: {
                return pSCodeItemBase.getUserData() == null;
            }
            case 44: {
                return pSCodeItemBase.getUserData2() == null;
            }
            case 45: {
                return pSCodeItemBase.getUserParams() == null;
            }
            case 46: {
                return pSCodeItemBase.getUserTag() == null;
            }
            case 47: {
                return pSCodeItemBase.getUserTag2() == null;
            }
            case 48: {
                return pSCodeItemBase.getUserTag3() == null;
            }
            case 49: {
                return pSCodeItemBase.getUserTag4() == null;
            }
            case 50: {
                return pSCodeItemBase.getValidFlag() == null;
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
        return PSCodeItemBase.contains(this, n);
    }

    private static boolean contains(PSCodeItemBase pSCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSCodeItemBase.isBeginValueDirty();
            }
            case 1: {
                return pSCodeItemBase.isBKColorDirty();
            }
            case 2: {
                return pSCodeItemBase.isCodeItemValueDirty();
            }
            case 3: {
                return pSCodeItemBase.isCodeNameDirty();
            }
            case 4: {
                return pSCodeItemBase.isColorDirty();
            }
            case 5: {
                return pSCodeItemBase.isCreateDateDirty();
            }
            case 6: {
                return pSCodeItemBase.isCreateManDirty();
            }
            case 7: {
                return pSCodeItemBase.isCssClassDirty();
            }
            case 8: {
                return pSCodeItemBase.isDataDirty();
            }
            case 9: {
                return pSCodeItemBase.isDefaultFlagDirty();
            }
            case 10: {
                return pSCodeItemBase.isDisableSelectDirty();
            }
            case 11: {
                return pSCodeItemBase.isDynaModelFlagDirty();
            }
            case 12: {
                return pSCodeItemBase.isEndValueDirty();
            }
            case 13: {
                return pSCodeItemBase.isIconClsDirty();
            }
            case 14: {
                return pSCodeItemBase.isIncBeginValueDirty();
            }
            case 15: {
                return pSCodeItemBase.isIncEndValueDirty();
            }
            case 16: {
                return pSCodeItemBase.isLevelTagDirty();
            }
            case 17: {
                return pSCodeItemBase.isLevelValueDirty();
            }
            case 18: {
                return pSCodeItemBase.isMemoDirty();
            }
            case 19: {
                return pSCodeItemBase.isOrderValueDirty();
            }
            case 20: {
                return pSCodeItemBase.isPPSCodeItemIdDirty();
            }
            case 21: {
                return pSCodeItemBase.isPPSCodeItemNameDirty();
            }
            case 22: {
                return pSCodeItemBase.isPSCodeItemIdDirty();
            }
            case 23: {
                return pSCodeItemBase.isPSCodeItemNameDirty();
            }
            case 24: {
                return pSCodeItemBase.isPSCodeListIdDirty();
            }
            case 25: {
                return pSCodeItemBase.isPSCodeListNameDirty();
            }
            case 26: {
                return pSCodeItemBase.isPSDynaInstIdDirty();
            }
            case 27: {
                return pSCodeItemBase.isPSSysCssIdDirty();
            }
            case 28: {
                return pSCodeItemBase.isPSSysCssNameDirty();
            }
            case 29: {
                return pSCodeItemBase.isPSSysImageIdDirty();
            }
            case 30: {
                return pSCodeItemBase.isPSSysImageNameDirty();
            }
            case 31: {
                return pSCodeItemBase.isShortKeyDirty();
            }
            case 32: {
                return pSCodeItemBase.isShowAsAllDirty();
            }
            case 33: {
                return pSCodeItemBase.isShowAsEmptyDirty();
            }
            case 34: {
                return pSCodeItemBase.isTextPSLanResIdDirty();
            }
            case 35: {
                return pSCodeItemBase.isTextPSLanResNameDirty();
            }
            case 36: {
                return pSCodeItemBase.isThresholdGroupFlagDirty();
            }
            case 37: {
                return pSCodeItemBase.isTipPSLanResIdDirty();
            }
            case 38: {
                return pSCodeItemBase.isTipPSLanResNameDirty();
            }
            case 39: {
                return pSCodeItemBase.isTooltipInfoDirty();
            }
            case 40: {
                return pSCodeItemBase.isUpdateDateDirty();
            }
            case 41: {
                return pSCodeItemBase.isUpdateManDirty();
            }
            case 42: {
                return pSCodeItemBase.isUserCatDirty();
            }
            case 43: {
                return pSCodeItemBase.isUserDataDirty();
            }
            case 44: {
                return pSCodeItemBase.isUserData2Dirty();
            }
            case 45: {
                return pSCodeItemBase.isUserParamsDirty();
            }
            case 46: {
                return pSCodeItemBase.isUserTagDirty();
            }
            case 47: {
                return pSCodeItemBase.isUserTag2Dirty();
            }
            case 48: {
                return pSCodeItemBase.isUserTag3Dirty();
            }
            case 49: {
                return pSCodeItemBase.isUserTag4Dirty();
            }
            case 50: {
                return pSCodeItemBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSCodeItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSCodeItemBase pSCodeItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSCodeItemBase.getBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beginvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getBeginValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getBKColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolor", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getBKColor()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getCodeItemValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codeitemvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getCodeItemValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getCodeName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"color", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getColor()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getCssClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssclass", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getCssClass()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"data", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getData()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getDefaultFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultflag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getDefaultFlag()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getDisableSelect() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"disableselect", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getDisableSelect()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"endvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getEndValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getIconCls() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"iconcls", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getIconCls()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getIncBeginValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incbeginvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getIncBeginValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getIncEndValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"incendvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getIncEndValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getLevelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leveltag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getLevelTag()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getLevelValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"levelvalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getLevelValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPPSCodeItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppscodeitemid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPPSCodeItemId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPPSCodeItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppscodeitemname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPPSCodeItemName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSCodeItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodeitemid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSCodeItemId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSCodeItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodeitemname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSCodeItemName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getShortKey() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"shortkey", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getShortKey()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getShowAsAll() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showasall", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getShowAsAll()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getShowAsEmpty() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showasempty", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getShowAsEmpty()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getTextPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getTextPSLanResId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getTextPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"textpslanresname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getTextPSLanResName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getThresholdGroupFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"thresholdgroupflag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getThresholdGroupFlag()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getTipPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresid", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getTipPSLanResId()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getTipPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tippslanresname", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getTipPSLanResName()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserCat()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserData()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userdata2", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserData2()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"userparams", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserParams()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSCodeItemBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSCodeItemBase.getJSONValue((Object)pSCodeItemBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSCodeItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSCodeItemBase pSCodeItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSCodeItemBase.getBeginValue() != null) {
            object = pSCodeItemBase.getBeginValue();
            xmlNode.setAttribute(FIELD_BEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getBKColor() != null) {
            object = pSCodeItemBase.getBKColor();
            xmlNode.setAttribute(FIELD_BKCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getCodeItemValue() != null) {
            object = pSCodeItemBase.getCodeItemValue();
            xmlNode.setAttribute(FIELD_CODEITEMVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getCodeName() != null) {
            object = pSCodeItemBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getColor() != null) {
            object = pSCodeItemBase.getColor();
            xmlNode.setAttribute(FIELD_COLOR, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getCreateDate() != null) {
            object = pSCodeItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeItemBase.getCreateMan() != null) {
            object = pSCodeItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getCssClass() != null) {
            object = pSCodeItemBase.getCssClass();
            xmlNode.setAttribute(FIELD_CSSCLASS, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getData() != null) {
            object = pSCodeItemBase.getData();
            xmlNode.setAttribute(FIELD_DATA, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getDefaultFlag() != null) {
            object = pSCodeItemBase.getDefaultFlag();
            xmlNode.setAttribute(FIELD_DEFAULTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getDisableSelect() != null) {
            object = pSCodeItemBase.getDisableSelect();
            xmlNode.setAttribute(FIELD_DISABLESELECT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getDynaModelFlag() != null) {
            object = pSCodeItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getEndValue() != null) {
            object = pSCodeItemBase.getEndValue();
            xmlNode.setAttribute(FIELD_ENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getIconCls() != null) {
            object = pSCodeItemBase.getIconCls();
            xmlNode.setAttribute(FIELD_ICONCLS, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getIncBeginValue() != null) {
            object = pSCodeItemBase.getIncBeginValue();
            xmlNode.setAttribute(FIELD_INCBEGINVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getIncEndValue() != null) {
            object = pSCodeItemBase.getIncEndValue();
            xmlNode.setAttribute(FIELD_INCENDVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getLevelTag() != null) {
            object = pSCodeItemBase.getLevelTag();
            xmlNode.setAttribute(FIELD_LEVELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getLevelValue() != null) {
            object = pSCodeItemBase.getLevelValue();
            xmlNode.setAttribute(FIELD_LEVELVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getMemo() != null) {
            object = pSCodeItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getOrderValue() != null) {
            object = pSCodeItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getPPSCodeItemId() != null) {
            object = pSCodeItemBase.getPPSCodeItemId();
            xmlNode.setAttribute(FIELD_PPSCODEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPPSCodeItemName() != null) {
            object = pSCodeItemBase.getPPSCodeItemName();
            xmlNode.setAttribute(FIELD_PPSCODEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSCodeItemId() != null) {
            object = pSCodeItemBase.getPSCodeItemId();
            xmlNode.setAttribute(FIELD_PSCODEITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSCodeItemName() != null) {
            object = pSCodeItemBase.getPSCodeItemName();
            xmlNode.setAttribute(FIELD_PSCODEITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSCodeListId() != null) {
            object = pSCodeItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSCodeListName() != null) {
            object = pSCodeItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSDynaInstId() != null) {
            object = pSCodeItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSSysCssId() != null) {
            object = pSCodeItemBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSSysCssName() != null) {
            object = pSCodeItemBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSSysImageId() != null) {
            object = pSCodeItemBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getPSSysImageName() != null) {
            object = pSCodeItemBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getShortKey() != null) {
            object = pSCodeItemBase.getShortKey();
            xmlNode.setAttribute(FIELD_SHORTKEY, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getShowAsAll() != null) {
            object = pSCodeItemBase.getShowAsAll();
            xmlNode.setAttribute(FIELD_SHOWASALL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getShowAsEmpty() != null) {
            object = pSCodeItemBase.getShowAsEmpty();
            xmlNode.setAttribute(FIELD_SHOWASEMPTY, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getTextPSLanResId() != null) {
            object = pSCodeItemBase.getTextPSLanResId();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getTextPSLanResName() != null) {
            object = pSCodeItemBase.getTextPSLanResName();
            xmlNode.setAttribute(FIELD_TEXTPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getThresholdGroupFlag() != null) {
            object = pSCodeItemBase.getThresholdGroupFlag();
            xmlNode.setAttribute(FIELD_THRESHOLDGROUPFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSCodeItemBase.getTipPSLanResId() != null) {
            object = pSCodeItemBase.getTipPSLanResId();
            xmlNode.setAttribute(FIELD_TIPPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getTipPSLanResName() != null) {
            object = pSCodeItemBase.getTipPSLanResName();
            xmlNode.setAttribute(FIELD_TIPPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getTooltipInfo() != null) {
            object = pSCodeItemBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUpdateDate() != null) {
            object = pSCodeItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSCodeItemBase.getUpdateMan() != null) {
            object = pSCodeItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserCat() != null) {
            object = pSCodeItemBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserData() != null) {
            object = pSCodeItemBase.getUserData();
            xmlNode.setAttribute(FIELD_USERDATA, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserData2() != null) {
            object = pSCodeItemBase.getUserData2();
            xmlNode.setAttribute(FIELD_USERDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserParams() != null) {
            object = pSCodeItemBase.getUserParams();
            xmlNode.setAttribute(FIELD_USERPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserTag() != null) {
            object = pSCodeItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserTag2() != null) {
            object = pSCodeItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserTag3() != null) {
            object = pSCodeItemBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getUserTag4() != null) {
            object = pSCodeItemBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSCodeItemBase.getValidFlag() != null) {
            object = pSCodeItemBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSCodeItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSCodeItemBase pSCodeItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSCodeItemBase.isBeginValueDirty() && (bl || pSCodeItemBase.getBeginValue() != null)) {
            iDataObject.set(FIELD_BEGINVALUE, (Object)pSCodeItemBase.getBeginValue());
        }
        if (pSCodeItemBase.isBKColorDirty() && (bl || pSCodeItemBase.getBKColor() != null)) {
            iDataObject.set(FIELD_BKCOLOR, (Object)pSCodeItemBase.getBKColor());
        }
        if (pSCodeItemBase.isCodeItemValueDirty() && (bl || pSCodeItemBase.getCodeItemValue() != null)) {
            iDataObject.set(FIELD_CODEITEMVALUE, (Object)pSCodeItemBase.getCodeItemValue());
        }
        if (pSCodeItemBase.isCodeNameDirty() && (bl || pSCodeItemBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSCodeItemBase.getCodeName());
        }
        if (pSCodeItemBase.isColorDirty() && (bl || pSCodeItemBase.getColor() != null)) {
            iDataObject.set(FIELD_COLOR, (Object)pSCodeItemBase.getColor());
        }
        if (pSCodeItemBase.isCreateDateDirty() && (bl || pSCodeItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSCodeItemBase.getCreateDate());
        }
        if (pSCodeItemBase.isCreateManDirty() && (bl || pSCodeItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSCodeItemBase.getCreateMan());
        }
        if (pSCodeItemBase.isCssClassDirty() && (bl || pSCodeItemBase.getCssClass() != null)) {
            iDataObject.set(FIELD_CSSCLASS, (Object)pSCodeItemBase.getCssClass());
        }
        if (pSCodeItemBase.isDataDirty() && (bl || pSCodeItemBase.getData() != null)) {
            iDataObject.set(FIELD_DATA, (Object)pSCodeItemBase.getData());
        }
        if (pSCodeItemBase.isDefaultFlagDirty() && (bl || pSCodeItemBase.getDefaultFlag() != null)) {
            iDataObject.set(FIELD_DEFAULTFLAG, (Object)pSCodeItemBase.getDefaultFlag());
        }
        if (pSCodeItemBase.isDisableSelectDirty() && (bl || pSCodeItemBase.getDisableSelect() != null)) {
            iDataObject.set(FIELD_DISABLESELECT, (Object)pSCodeItemBase.getDisableSelect());
        }
        if (pSCodeItemBase.isDynaModelFlagDirty() && (bl || pSCodeItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSCodeItemBase.getDynaModelFlag());
        }
        if (pSCodeItemBase.isEndValueDirty() && (bl || pSCodeItemBase.getEndValue() != null)) {
            iDataObject.set(FIELD_ENDVALUE, (Object)pSCodeItemBase.getEndValue());
        }
        if (pSCodeItemBase.isIconClsDirty() && (bl || pSCodeItemBase.getIconCls() != null)) {
            iDataObject.set(FIELD_ICONCLS, (Object)pSCodeItemBase.getIconCls());
        }
        if (pSCodeItemBase.isIncBeginValueDirty() && (bl || pSCodeItemBase.getIncBeginValue() != null)) {
            iDataObject.set(FIELD_INCBEGINVALUE, (Object)pSCodeItemBase.getIncBeginValue());
        }
        if (pSCodeItemBase.isIncEndValueDirty() && (bl || pSCodeItemBase.getIncEndValue() != null)) {
            iDataObject.set(FIELD_INCENDVALUE, (Object)pSCodeItemBase.getIncEndValue());
        }
        if (pSCodeItemBase.isLevelTagDirty() && (bl || pSCodeItemBase.getLevelTag() != null)) {
            iDataObject.set(FIELD_LEVELTAG, (Object)pSCodeItemBase.getLevelTag());
        }
        if (pSCodeItemBase.isLevelValueDirty() && (bl || pSCodeItemBase.getLevelValue() != null)) {
            iDataObject.set(FIELD_LEVELVALUE, (Object)pSCodeItemBase.getLevelValue());
        }
        if (pSCodeItemBase.isMemoDirty() && (bl || pSCodeItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSCodeItemBase.getMemo());
        }
        if (pSCodeItemBase.isOrderValueDirty() && (bl || pSCodeItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSCodeItemBase.getOrderValue());
        }
        if (pSCodeItemBase.isPPSCodeItemIdDirty() && (bl || pSCodeItemBase.getPPSCodeItemId() != null)) {
            iDataObject.set(FIELD_PPSCODEITEMID, (Object)pSCodeItemBase.getPPSCodeItemId());
        }
        if (pSCodeItemBase.isPPSCodeItemNameDirty() && (bl || pSCodeItemBase.getPPSCodeItemName() != null)) {
            iDataObject.set(FIELD_PPSCODEITEMNAME, (Object)pSCodeItemBase.getPPSCodeItemName());
        }
        if (pSCodeItemBase.isPSCodeItemIdDirty() && (bl || pSCodeItemBase.getPSCodeItemId() != null)) {
            iDataObject.set(FIELD_PSCODEITEMID, (Object)pSCodeItemBase.getPSCodeItemId());
        }
        if (pSCodeItemBase.isPSCodeItemNameDirty() && (bl || pSCodeItemBase.getPSCodeItemName() != null)) {
            iDataObject.set(FIELD_PSCODEITEMNAME, (Object)pSCodeItemBase.getPSCodeItemName());
        }
        if (pSCodeItemBase.isPSCodeListIdDirty() && (bl || pSCodeItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSCodeItemBase.getPSCodeListId());
        }
        if (pSCodeItemBase.isPSCodeListNameDirty() && (bl || pSCodeItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSCodeItemBase.getPSCodeListName());
        }
        if (pSCodeItemBase.isPSDynaInstIdDirty() && (bl || pSCodeItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSCodeItemBase.getPSDynaInstId());
        }
        if (pSCodeItemBase.isPSSysCssIdDirty() && (bl || pSCodeItemBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSCodeItemBase.getPSSysCssId());
        }
        if (pSCodeItemBase.isPSSysCssNameDirty() && (bl || pSCodeItemBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSCodeItemBase.getPSSysCssName());
        }
        if (pSCodeItemBase.isPSSysImageIdDirty() && (bl || pSCodeItemBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSCodeItemBase.getPSSysImageId());
        }
        if (pSCodeItemBase.isPSSysImageNameDirty() && (bl || pSCodeItemBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSCodeItemBase.getPSSysImageName());
        }
        if (pSCodeItemBase.isShortKeyDirty() && (bl || pSCodeItemBase.getShortKey() != null)) {
            iDataObject.set(FIELD_SHORTKEY, (Object)pSCodeItemBase.getShortKey());
        }
        if (pSCodeItemBase.isShowAsAllDirty() && (bl || pSCodeItemBase.getShowAsAll() != null)) {
            iDataObject.set(FIELD_SHOWASALL, (Object)pSCodeItemBase.getShowAsAll());
        }
        if (pSCodeItemBase.isShowAsEmptyDirty() && (bl || pSCodeItemBase.getShowAsEmpty() != null)) {
            iDataObject.set(FIELD_SHOWASEMPTY, (Object)pSCodeItemBase.getShowAsEmpty());
        }
        if (pSCodeItemBase.isTextPSLanResIdDirty() && (bl || pSCodeItemBase.getTextPSLanResId() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESID, (Object)pSCodeItemBase.getTextPSLanResId());
        }
        if (pSCodeItemBase.isTextPSLanResNameDirty() && (bl || pSCodeItemBase.getTextPSLanResName() != null)) {
            iDataObject.set(FIELD_TEXTPSLANRESNAME, (Object)pSCodeItemBase.getTextPSLanResName());
        }
        if (pSCodeItemBase.isThresholdGroupFlagDirty() && (bl || pSCodeItemBase.getThresholdGroupFlag() != null)) {
            iDataObject.set(FIELD_THRESHOLDGROUPFLAG, (Object)pSCodeItemBase.getThresholdGroupFlag());
        }
        if (pSCodeItemBase.isTipPSLanResIdDirty() && (bl || pSCodeItemBase.getTipPSLanResId() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESID, (Object)pSCodeItemBase.getTipPSLanResId());
        }
        if (pSCodeItemBase.isTipPSLanResNameDirty() && (bl || pSCodeItemBase.getTipPSLanResName() != null)) {
            iDataObject.set(FIELD_TIPPSLANRESNAME, (Object)pSCodeItemBase.getTipPSLanResName());
        }
        if (pSCodeItemBase.isTooltipInfoDirty() && (bl || pSCodeItemBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSCodeItemBase.getTooltipInfo());
        }
        if (pSCodeItemBase.isUpdateDateDirty() && (bl || pSCodeItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSCodeItemBase.getUpdateDate());
        }
        if (pSCodeItemBase.isUpdateManDirty() && (bl || pSCodeItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSCodeItemBase.getUpdateMan());
        }
        if (pSCodeItemBase.isUserCatDirty() && (bl || pSCodeItemBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSCodeItemBase.getUserCat());
        }
        if (pSCodeItemBase.isUserDataDirty() && (bl || pSCodeItemBase.getUserData() != null)) {
            iDataObject.set(FIELD_USERDATA, (Object)pSCodeItemBase.getUserData());
        }
        if (pSCodeItemBase.isUserData2Dirty() && (bl || pSCodeItemBase.getUserData2() != null)) {
            iDataObject.set(FIELD_USERDATA2, (Object)pSCodeItemBase.getUserData2());
        }
        if (pSCodeItemBase.isUserParamsDirty() && (bl || pSCodeItemBase.getUserParams() != null)) {
            iDataObject.set(FIELD_USERPARAMS, (Object)pSCodeItemBase.getUserParams());
        }
        if (pSCodeItemBase.isUserTagDirty() && (bl || pSCodeItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSCodeItemBase.getUserTag());
        }
        if (pSCodeItemBase.isUserTag2Dirty() && (bl || pSCodeItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSCodeItemBase.getUserTag2());
        }
        if (pSCodeItemBase.isUserTag3Dirty() && (bl || pSCodeItemBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSCodeItemBase.getUserTag3());
        }
        if (pSCodeItemBase.isUserTag4Dirty() && (bl || pSCodeItemBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSCodeItemBase.getUserTag4());
        }
        if (pSCodeItemBase.isValidFlagDirty() && (bl || pSCodeItemBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSCodeItemBase.getValidFlag());
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
        return PSCodeItemBase.remove(this, n);
    }

    private static boolean remove(PSCodeItemBase pSCodeItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSCodeItemBase.resetBeginValue();
                return true;
            }
            case 1: {
                pSCodeItemBase.resetBKColor();
                return true;
            }
            case 2: {
                pSCodeItemBase.resetCodeItemValue();
                return true;
            }
            case 3: {
                pSCodeItemBase.resetCodeName();
                return true;
            }
            case 4: {
                pSCodeItemBase.resetColor();
                return true;
            }
            case 5: {
                pSCodeItemBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSCodeItemBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSCodeItemBase.resetCssClass();
                return true;
            }
            case 8: {
                pSCodeItemBase.resetData();
                return true;
            }
            case 9: {
                pSCodeItemBase.resetDefaultFlag();
                return true;
            }
            case 10: {
                pSCodeItemBase.resetDisableSelect();
                return true;
            }
            case 11: {
                pSCodeItemBase.resetDynaModelFlag();
                return true;
            }
            case 12: {
                pSCodeItemBase.resetEndValue();
                return true;
            }
            case 13: {
                pSCodeItemBase.resetIconCls();
                return true;
            }
            case 14: {
                pSCodeItemBase.resetIncBeginValue();
                return true;
            }
            case 15: {
                pSCodeItemBase.resetIncEndValue();
                return true;
            }
            case 16: {
                pSCodeItemBase.resetLevelTag();
                return true;
            }
            case 17: {
                pSCodeItemBase.resetLevelValue();
                return true;
            }
            case 18: {
                pSCodeItemBase.resetMemo();
                return true;
            }
            case 19: {
                pSCodeItemBase.resetOrderValue();
                return true;
            }
            case 20: {
                pSCodeItemBase.resetPPSCodeItemId();
                return true;
            }
            case 21: {
                pSCodeItemBase.resetPPSCodeItemName();
                return true;
            }
            case 22: {
                pSCodeItemBase.resetPSCodeItemId();
                return true;
            }
            case 23: {
                pSCodeItemBase.resetPSCodeItemName();
                return true;
            }
            case 24: {
                pSCodeItemBase.resetPSCodeListId();
                return true;
            }
            case 25: {
                pSCodeItemBase.resetPSCodeListName();
                return true;
            }
            case 26: {
                pSCodeItemBase.resetPSDynaInstId();
                return true;
            }
            case 27: {
                pSCodeItemBase.resetPSSysCssId();
                return true;
            }
            case 28: {
                pSCodeItemBase.resetPSSysCssName();
                return true;
            }
            case 29: {
                pSCodeItemBase.resetPSSysImageId();
                return true;
            }
            case 30: {
                pSCodeItemBase.resetPSSysImageName();
                return true;
            }
            case 31: {
                pSCodeItemBase.resetShortKey();
                return true;
            }
            case 32: {
                pSCodeItemBase.resetShowAsAll();
                return true;
            }
            case 33: {
                pSCodeItemBase.resetShowAsEmpty();
                return true;
            }
            case 34: {
                pSCodeItemBase.resetTextPSLanResId();
                return true;
            }
            case 35: {
                pSCodeItemBase.resetTextPSLanResName();
                return true;
            }
            case 36: {
                pSCodeItemBase.resetThresholdGroupFlag();
                return true;
            }
            case 37: {
                pSCodeItemBase.resetTipPSLanResId();
                return true;
            }
            case 38: {
                pSCodeItemBase.resetTipPSLanResName();
                return true;
            }
            case 39: {
                pSCodeItemBase.resetTooltipInfo();
                return true;
            }
            case 40: {
                pSCodeItemBase.resetUpdateDate();
                return true;
            }
            case 41: {
                pSCodeItemBase.resetUpdateMan();
                return true;
            }
            case 42: {
                pSCodeItemBase.resetUserCat();
                return true;
            }
            case 43: {
                pSCodeItemBase.resetUserData();
                return true;
            }
            case 44: {
                pSCodeItemBase.resetUserData2();
                return true;
            }
            case 45: {
                pSCodeItemBase.resetUserParams();
                return true;
            }
            case 46: {
                pSCodeItemBase.resetUserTag();
                return true;
            }
            case 47: {
                pSCodeItemBase.resetUserTag2();
                return true;
            }
            case 48: {
                pSCodeItemBase.resetUserTag3();
                return true;
            }
            case 49: {
                pSCodeItemBase.resetUserTag4();
                return true;
            }
            case 50: {
                pSCodeItemBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCodeItem getPPSCodeItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSCodeItem();
        }
        if (this.getPPSCodeItemId() == null) {
            return null;
        }
        Integer n = this.objPPSCodeItemLock;
        synchronized (n) {
            if (this.ppscodeitem != null && DataTypeHelper.compare((int)25, (Object)this.getPPSCodeItemId(), (Object)this.ppscodeitem.getPSCodeItemId()) != 0L) {
                this.ppscodeitem = null;
            }
            if (this.ppscodeitem == null) {
                PSCodeItem pSCodeItem = new PSCodeItem();
                pSCodeItem.setPSCodeItemId(this.getPPSCodeItemId());
                PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
                pSCodeItemService.autoGet(pSCodeItem);
                this.ppscodeitem = pSCodeItem;
            }
            return this.ppscodeitem;
        }
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
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTextPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTextPSLanRes();
        }
        if (this.getTextPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTextPSLanResLock;
        synchronized (n) {
            if (this.textpslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTextPSLanResId(), (Object)this.textpslanres.getPSLanguageResId()) != 0L) {
                this.textpslanres = null;
            }
            if (this.textpslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTextPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.textpslanres = pSLanguageRes;
            }
            return this.textpslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTipPSLanRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTipPSLanRes();
        }
        if (this.getTipPSLanResId() == null) {
            return null;
        }
        Integer n = this.objTipPSLanResLock;
        synchronized (n) {
            if (this.tippslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTipPSLanResId(), (Object)this.tippslanres.getPSLanguageResId()) != 0L) {
                this.tippslanres = null;
            }
            if (this.tippslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTipPSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet(pSLanguageRes);
                this.tippslanres = pSLanguageRes;
            }
            return this.tippslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCss();
        }
        if (this.getPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssLock;
        synchronized (n) {
            if (this.pssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssId(), (Object)this.pssyscss.getPSSysCssId()) != 0L) {
                this.pssyscss = null;
            }
            if (this.pssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysImage getPSSysImage() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysImage();
        }
        if (this.getPSSysImageId() == null) {
            return null;
        }
        Integer n = this.objPSSysImageLock;
        synchronized (n) {
            if (this.pssysimage != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysImageId(), (Object)this.pssysimage.getPSSysImageId()) != 0L) {
                this.pssysimage = null;
            }
            if (this.pssysimage == null) {
                PSSysImage pSSysImage = new PSSysImage();
                pSSysImage.setPSSysImageId(this.getPSSysImageId());
                PSSysImageService pSSysImageService = (PSSysImageService)ServiceGlobal.getService(PSSysImageService.class, (SessionFactory)this.getSessionFactory());
                pSSysImageService.autoGet(pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSCodeItem> getPSCodeItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCodeItems();
        }
        if (this.getPSCodeItemId() == null) {
            return null;
        }
        PSCodeItemService pSCodeItemService = (PSCodeItemService)ServiceGlobal.getService(PSCodeItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSCodeItemsLock;
        synchronized (n) {
            if (this.pscodeitems == null) {
                this.pscodeitems = pSCodeItemService.selectByPPSCodeItem(this);
            }
            return this.pscodeitems;
        }
    }

    private PSCodeItemBase getProxyEntity() {
        return this.proxyPSCodeItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSCodeItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSCodeItemBase) {
            this.proxyPSCodeItemBase = (PSCodeItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSCodeItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BEGINVALUE, 0);
        fieldIndexMap.put(FIELD_BKCOLOR, 1);
        fieldIndexMap.put(FIELD_CODEITEMVALUE, 2);
        fieldIndexMap.put(FIELD_CODENAME, 3);
        fieldIndexMap.put(FIELD_COLOR, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CSSCLASS, 7);
        fieldIndexMap.put(FIELD_DATA, 8);
        fieldIndexMap.put(FIELD_DEFAULTFLAG, 9);
        fieldIndexMap.put(FIELD_DISABLESELECT, 10);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 11);
        fieldIndexMap.put(FIELD_ENDVALUE, 12);
        fieldIndexMap.put(FIELD_ICONCLS, 13);
        fieldIndexMap.put(FIELD_INCBEGINVALUE, 14);
        fieldIndexMap.put(FIELD_INCENDVALUE, 15);
        fieldIndexMap.put(FIELD_LEVELTAG, 16);
        fieldIndexMap.put(FIELD_LEVELVALUE, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_ORDERVALUE, 19);
        fieldIndexMap.put(FIELD_PPSCODEITEMID, 20);
        fieldIndexMap.put(FIELD_PPSCODEITEMNAME, 21);
        fieldIndexMap.put(FIELD_PSCODEITEMID, 22);
        fieldIndexMap.put(FIELD_PSCODEITEMNAME, 23);
        fieldIndexMap.put(FIELD_PSCODELISTID, 24);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 25);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 26);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 27);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 29);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 30);
        fieldIndexMap.put(FIELD_SHORTKEY, 31);
        fieldIndexMap.put(FIELD_SHOWASALL, 32);
        fieldIndexMap.put(FIELD_SHOWASEMPTY, 33);
        fieldIndexMap.put(FIELD_TEXTPSLANRESID, 34);
        fieldIndexMap.put(FIELD_TEXTPSLANRESNAME, 35);
        fieldIndexMap.put(FIELD_THRESHOLDGROUPFLAG, 36);
        fieldIndexMap.put(FIELD_TIPPSLANRESID, 37);
        fieldIndexMap.put(FIELD_TIPPSLANRESNAME, 38);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 39);
        fieldIndexMap.put(FIELD_UPDATEDATE, 40);
        fieldIndexMap.put(FIELD_UPDATEMAN, 41);
        fieldIndexMap.put(FIELD_USERCAT, 42);
        fieldIndexMap.put(FIELD_USERDATA, 43);
        fieldIndexMap.put(FIELD_USERDATA2, 44);
        fieldIndexMap.put(FIELD_USERPARAMS, 45);
        fieldIndexMap.put(FIELD_USERTAG, 46);
        fieldIndexMap.put(FIELD_USERTAG2, 47);
        fieldIndexMap.put(FIELD_USERTAG3, 48);
        fieldIndexMap.put(FIELD_USERTAG4, 49);
        fieldIndexMap.put(FIELD_VALIDFLAG, 50);
    }
}

