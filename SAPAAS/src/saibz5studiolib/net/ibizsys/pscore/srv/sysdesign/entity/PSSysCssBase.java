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
import net.ibizsys.pscore.srv.config.entity.PSCssTempl;
import net.ibizsys.pscore.srv.config.service.PSCssTemplService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCssCat;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssCatService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCssBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCssBase.class);
    public static final String FIELD_BKCOLOR = "BKCOLOR";
    public static final String FIELD_BORDER = "BORDER";
    public static final String FIELD_BORDERCOLOR = "BORDERCOLOR";
    public static final String FIELD_BORDERSTYLE = "BORDERSTYLE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CSSCATNAME = "CSSCATNAME";
    public static final String FIELD_CSSNAME = "CSSNAME";
    public static final String FIELD_CSSSTYLE = "CSSSTYLE";
    public static final String FIELD_CSSSTYLE2 = "CSSSTYLE2";
    public static final String FIELD_FONTCOLOR = "FONTCOLOR";
    public static final String FIELD_FONTFAMILY = "FONTFAMILY";
    public static final String FIELD_FONTSIZE = "FONTSIZE";
    public static final String FIELD_FONTSTYLE = "FONTSTYLE";
    public static final String FIELD_FULLCSSNAME = "FULLCSSNAME";
    public static final String FIELD_HALIGN = "HALIGN";
    public static final String FIELD_LOCKFLAG = "LOCKFLAG";
    public static final String FIELD_MARGIN = "MARGIN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_OWNERID = "OWNERID";
    public static final String FIELD_OWNERTAG = "OWNERTAG";
    public static final String FIELD_OWNERTYPE = "OWNERTYPE";
    public static final String FIELD_PADDING = "PADDING";
    public static final String FIELD_PSCSSTEMPLID = "PSCSSTEMPLID";
    public static final String FIELD_PSCSSTEMPLNAME = "PSCSSTEMPLNAME";
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCSSCATID = "PSSYSCSSCATID";
    public static final String FIELD_PSSYSCSSCATNAME = "PSSYSCSSCATNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
    public static final String FIELD_PUBLICFLAG = "PUBLICFLAG";
    public static final String FIELD_SAMPLECONTENT = "SAMPLECONTENT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIGN = "VALIGN";
    private static final int INDEX_BKCOLOR = 0;
    private static final int INDEX_BORDER = 1;
    private static final int INDEX_BORDERCOLOR = 2;
    private static final int INDEX_BORDERSTYLE = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CSSCATNAME = 7;
    private static final int INDEX_CSSNAME = 8;
    private static final int INDEX_CSSSTYLE = 9;
    private static final int INDEX_CSSSTYLE2 = 10;
    private static final int INDEX_FONTCOLOR = 11;
    private static final int INDEX_FONTFAMILY = 12;
    private static final int INDEX_FONTSIZE = 13;
    private static final int INDEX_FONTSTYLE = 14;
    private static final int INDEX_FULLCSSNAME = 15;
    private static final int INDEX_HALIGN = 16;
    private static final int INDEX_LOCKFLAG = 17;
    private static final int INDEX_MARGIN = 18;
    private static final int INDEX_MEMO = 19;
    private static final int INDEX_OWNERID = 20;
    private static final int INDEX_OWNERTAG = 21;
    private static final int INDEX_OWNERTYPE = 22;
    private static final int INDEX_PADDING = 23;
    private static final int INDEX_PSCSSTEMPLID = 24;
    private static final int INDEX_PSCSSTEMPLNAME = 25;
    private static final int INDEX_PSMODULEID = 26;
    private static final int INDEX_PSMODULENAME = 27;
    private static final int INDEX_PSSYSCSSCATID = 28;
    private static final int INDEX_PSSYSCSSCATNAME = 29;
    private static final int INDEX_PSSYSCSSID = 30;
    private static final int INDEX_PSSYSCSSNAME = 31;
    private static final int INDEX_PSSYSTEMID = 32;
    private static final int INDEX_PSSYSTEMNAME = 33;
    private static final int INDEX_PUBLICFLAG = 34;
    private static final int INDEX_SAMPLECONTENT = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIGN = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCssBase proxyPSSysCssBase = null;
    private boolean bkcolorDirtyFlag = false;
    private boolean borderDirtyFlag = false;
    private boolean bordercolorDirtyFlag = false;
    private boolean borderstyleDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean csscatnameDirtyFlag = false;
    private boolean cssnameDirtyFlag = false;
    private boolean cssstyleDirtyFlag = false;
    private boolean cssstyle2DirtyFlag = false;
    private boolean fontcolorDirtyFlag = false;
    private boolean fontfamilyDirtyFlag = false;
    private boolean fontsizeDirtyFlag = false;
    private boolean fontstyleDirtyFlag = false;
    private boolean fullcssnameDirtyFlag = false;
    private boolean halignDirtyFlag = false;
    private boolean lockflagDirtyFlag = false;
    private boolean marginDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean owneridDirtyFlag = false;
    private boolean ownertagDirtyFlag = false;
    private boolean ownertypeDirtyFlag = false;
    private boolean paddingDirtyFlag = false;
    private boolean pscsstemplidDirtyFlag = false;
    private boolean pscsstemplnameDirtyFlag = false;
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscsscatidDirtyFlag = false;
    private boolean pssyscsscatnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
    private boolean publicflagDirtyFlag = false;
    private boolean samplecontentDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean valignDirtyFlag = false;
    @Column(name="bkcolor")
    private String bkcolor;
    @Column(name="border")
    private String border;
    @Column(name="bordercolor")
    private String bordercolor;
    @Column(name="borderstyle")
    private String borderstyle;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="csscatname")
    private String csscatname;
    @Column(name="cssname")
    private String cssname;
    @Column(name="cssstyle")
    private String cssstyle;
    @Column(name="cssstyle2")
    private String cssstyle2;
    @Column(name="fontcolor")
    private String fontcolor;
    @Column(name="fontfamily")
    private String fontfamily;
    @Column(name="fontsize")
    private Integer fontsize;
    @Column(name="fontstyle")
    private Integer fontstyle;
    @Column(name="fullcssname")
    private String fullcssname;
    @Column(name="halign")
    private String halign;
    @Column(name="lockflag")
    private Integer lockflag;
    @Column(name="margin")
    private String margin;
    @Column(name="memo")
    private String memo;
    @Column(name="ownerid")
    private String ownerid;
    @Column(name="ownertag")
    private String ownertag;
    @Column(name="ownertype")
    private String ownertype;
    @Column(name="padding")
    private String padding;
    @Column(name="pscsstemplid")
    private String pscsstemplid;
    @Column(name="pscsstemplname")
    private String pscsstemplname;
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscsscatid")
    private String pssyscsscatid;
    @Column(name="pssyscsscatname")
    private String pssyscsscatname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
    @Column(name="publicflag")
    private Integer publicflag;
    @Column(name="samplecontent")
    private String samplecontent;
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
    @Column(name="valign")
    private String valign;
    private Integer objPSCssTemplLock = new Integer(1);
    private PSCssTempl pscsstempl = null;
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSysCssCatLock = new Integer(1);
    private PSSysCssCat pssyscsscat = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;

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

    public void setBorder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.border = string;
        this.borderDirtyFlag = true;
    }

    public String getBorder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorder();
        }
        return this.border;
    }

    public boolean isBorderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderDirty();
        }
        return this.borderDirtyFlag;
    }

    public void resetBorder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorder();
            return;
        }
        this.borderDirtyFlag = false;
        this.border = null;
    }

    public void setBorderColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bordercolor = string;
        this.bordercolorDirtyFlag = true;
    }

    public String getBorderColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderColor();
        }
        return this.bordercolor;
    }

    public boolean isBorderColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderColorDirty();
        }
        return this.bordercolorDirtyFlag;
    }

    public void resetBorderColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderColor();
            return;
        }
        this.bordercolorDirtyFlag = false;
        this.bordercolor = null;
    }

    public void setBorderStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBorderStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.borderstyle = string;
        this.borderstyleDirtyFlag = true;
    }

    public String getBorderStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBorderStyle();
        }
        return this.borderstyle;
    }

    public boolean isBorderStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBorderStyleDirty();
        }
        return this.borderstyleDirtyFlag;
    }

    public void resetBorderStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBorderStyle();
            return;
        }
        this.borderstyleDirtyFlag = false;
        this.borderstyle = null;
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

    public void setCssCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.csscatname = string;
        this.csscatnameDirtyFlag = true;
    }

    public String getCssCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssCatName();
        }
        return this.csscatname;
    }

    public boolean isCssCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssCatNameDirty();
        }
        return this.csscatnameDirtyFlag;
    }

    public void resetCssCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssCatName();
            return;
        }
        this.csscatnameDirtyFlag = false;
        this.csscatname = null;
    }

    public void setCSSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssname = string;
        this.cssnameDirtyFlag = true;
    }

    public String getCSSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSSName();
        }
        return this.cssname;
    }

    public boolean isCSSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSSNameDirty();
        }
        return this.cssnameDirtyFlag;
    }

    public void resetCSSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSSName();
            return;
        }
        this.cssnameDirtyFlag = false;
        this.cssname = null;
    }

    public void setCSSStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCSSStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssstyle = string;
        this.cssstyleDirtyFlag = true;
    }

    public String getCSSStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCSSStyle();
        }
        return this.cssstyle;
    }

    public boolean isCSSStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCSSStyleDirty();
        }
        return this.cssstyleDirtyFlag;
    }

    public void resetCSSStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCSSStyle();
            return;
        }
        this.cssstyleDirtyFlag = false;
        this.cssstyle = null;
    }

    public void setCssStyle2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCssStyle2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cssstyle2 = string;
        this.cssstyle2DirtyFlag = true;
    }

    public String getCssStyle2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCssStyle2();
        }
        return this.cssstyle2;
    }

    public boolean isCssStyle2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCssStyle2Dirty();
        }
        return this.cssstyle2DirtyFlag;
    }

    public void resetCssStyle2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCssStyle2();
            return;
        }
        this.cssstyle2DirtyFlag = false;
        this.cssstyle2 = null;
    }

    public void setFontColor(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFontColor(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fontcolor = string;
        this.fontcolorDirtyFlag = true;
    }

    public String getFontColor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFontColor();
        }
        return this.fontcolor;
    }

    public boolean isFontColorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFontColorDirty();
        }
        return this.fontcolorDirtyFlag;
    }

    public void resetFontColor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFontColor();
            return;
        }
        this.fontcolorDirtyFlag = false;
        this.fontcolor = null;
    }

    public void setFontFamily(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFontFamily(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fontfamily = string;
        this.fontfamilyDirtyFlag = true;
    }

    public String getFontFamily() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFontFamily();
        }
        return this.fontfamily;
    }

    public boolean isFontFamilyDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFontFamilyDirty();
        }
        return this.fontfamilyDirtyFlag;
    }

    public void resetFontFamily() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFontFamily();
            return;
        }
        this.fontfamilyDirtyFlag = false;
        this.fontfamily = null;
    }

    public void setFontSize(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFontSize(n);
            return;
        }
        this.fontsize = n;
        this.fontsizeDirtyFlag = true;
    }

    public Integer getFontSize() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFontSize();
        }
        return this.fontsize;
    }

    public boolean isFontSizeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFontSizeDirty();
        }
        return this.fontsizeDirtyFlag;
    }

    public void resetFontSize() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFontSize();
            return;
        }
        this.fontsizeDirtyFlag = false;
        this.fontsize = null;
    }

    public void setFontStyle(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFontStyle(n);
            return;
        }
        this.fontstyle = n;
        this.fontstyleDirtyFlag = true;
    }

    public Integer getFontStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFontStyle();
        }
        return this.fontstyle;
    }

    public boolean isFontStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFontStyleDirty();
        }
        return this.fontstyleDirtyFlag;
    }

    public void resetFontStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFontStyle();
            return;
        }
        this.fontstyleDirtyFlag = false;
        this.fontstyle = null;
    }

    public void setFullCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFullCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fullcssname = string;
        this.fullcssnameDirtyFlag = true;
    }

    public String getFullCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFullCssName();
        }
        return this.fullcssname;
    }

    public boolean isFullCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFullCssNameDirty();
        }
        return this.fullcssnameDirtyFlag;
    }

    public void resetFullCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFullCssName();
            return;
        }
        this.fullcssnameDirtyFlag = false;
        this.fullcssname = null;
    }

    public void setHAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halign = string;
        this.halignDirtyFlag = true;
    }

    public String getHAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlign();
        }
        return this.halign;
    }

    public boolean isHAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignDirty();
        }
        return this.halignDirtyFlag;
    }

    public void resetHAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlign();
            return;
        }
        this.halignDirtyFlag = false;
        this.halign = null;
    }

    public void setLockFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLockFlag(n);
            return;
        }
        this.lockflag = n;
        this.lockflagDirtyFlag = true;
    }

    public Integer getLockFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLockFlag();
        }
        return this.lockflag;
    }

    public boolean isLockFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLockFlagDirty();
        }
        return this.lockflagDirtyFlag;
    }

    public void resetLockFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLockFlag();
            return;
        }
        this.lockflagDirtyFlag = false;
        this.lockflag = null;
    }

    public void setMargin(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMargin(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.margin = string;
        this.marginDirtyFlag = true;
    }

    public String getMargin() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMargin();
        }
        return this.margin;
    }

    public boolean isMarginDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarginDirty();
        }
        return this.marginDirtyFlag;
    }

    public void resetMargin() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMargin();
            return;
        }
        this.marginDirtyFlag = false;
        this.margin = null;
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

    public void setOwnerId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownerid = string;
        this.owneridDirtyFlag = true;
    }

    public String getOwnerId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerId();
        }
        return this.ownerid;
    }

    public boolean isOwnerIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerIdDirty();
        }
        return this.owneridDirtyFlag;
    }

    public void resetOwnerId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerId();
            return;
        }
        this.owneridDirtyFlag = false;
        this.ownerid = null;
    }

    public void setOwnerTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertag = string;
        this.ownertagDirtyFlag = true;
    }

    public String getOwnerTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerTag();
        }
        return this.ownertag;
    }

    public boolean isOwnerTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTagDirty();
        }
        return this.ownertagDirtyFlag;
    }

    public void resetOwnerTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerTag();
            return;
        }
        this.ownertagDirtyFlag = false;
        this.ownertag = null;
    }

    public void setOwnerType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOwnerType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ownertype = string;
        this.ownertypeDirtyFlag = true;
    }

    public String getOwnerType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOwnerType();
        }
        return this.ownertype;
    }

    public boolean isOwnerTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOwnerTypeDirty();
        }
        return this.ownertypeDirtyFlag;
    }

    public void resetOwnerType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOwnerType();
            return;
        }
        this.ownertypeDirtyFlag = false;
        this.ownertype = null;
    }

    public void setPadding(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPadding(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.padding = string;
        this.paddingDirtyFlag = true;
    }

    public String getPadding() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPadding();
        }
        return this.padding;
    }

    public boolean isPaddingDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPaddingDirty();
        }
        return this.paddingDirtyFlag;
    }

    public void resetPadding() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPadding();
            return;
        }
        this.paddingDirtyFlag = false;
        this.padding = null;
    }

    public void setPSCssTemplId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplid = string;
        this.pscsstemplidDirtyFlag = true;
    }

    public String getPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplId();
        }
        return this.pscsstemplid;
    }

    public boolean isPSCssTemplIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplIdDirty();
        }
        return this.pscsstemplidDirtyFlag;
    }

    public void resetPSCssTemplId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplId();
            return;
        }
        this.pscsstemplidDirtyFlag = false;
        this.pscsstemplid = null;
    }

    public void setPSCssTemplName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSCssTemplName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pscsstemplname = string;
        this.pscsstemplnameDirtyFlag = true;
    }

    public String getPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTemplName();
        }
        return this.pscsstemplname;
    }

    public boolean isPSCssTemplNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSCssTemplNameDirty();
        }
        return this.pscsstemplnameDirtyFlag;
    }

    public void resetPSCssTemplName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSCssTemplName();
            return;
        }
        this.pscsstemplnameDirtyFlag = false;
        this.pscsstemplname = null;
    }

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysCssCatId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssCatId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscsscatid = string;
        this.pssyscsscatidDirtyFlag = true;
    }

    public String getPSSysCssCatId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCatId();
        }
        return this.pssyscsscatid;
    }

    public boolean isPSSysCssCatIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssCatIdDirty();
        }
        return this.pssyscsscatidDirtyFlag;
    }

    public void resetPSSysCssCatId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssCatId();
            return;
        }
        this.pssyscsscatidDirtyFlag = false;
        this.pssyscsscatid = null;
    }

    public void setPSSysCssCatName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCssCatName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscsscatname = string;
        this.pssyscsscatnameDirtyFlag = true;
    }

    public String getPSSysCssCatName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCatName();
        }
        return this.pssyscsscatname;
    }

    public boolean isPSSysCssCatNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCssCatNameDirty();
        }
        return this.pssyscsscatnameDirtyFlag;
    }

    public void resetPSSysCssCatName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCssCatName();
            return;
        }
        this.pssyscsscatnameDirtyFlag = false;
        this.pssyscsscatname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
    }

    public void setPublicFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPublicFlag(n);
            return;
        }
        this.publicflag = n;
        this.publicflagDirtyFlag = true;
    }

    public Integer getPublicFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPublicFlag();
        }
        return this.publicflag;
    }

    public boolean isPublicFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPublicFlagDirty();
        }
        return this.publicflagDirtyFlag;
    }

    public void resetPublicFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPublicFlag();
            return;
        }
        this.publicflagDirtyFlag = false;
        this.publicflag = null;
    }

    public void setSampleContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSampleContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.samplecontent = string;
        this.samplecontentDirtyFlag = true;
    }

    public String getSampleContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSampleContent();
        }
        return this.samplecontent;
    }

    public boolean isSampleContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSampleContentDirty();
        }
        return this.samplecontentDirtyFlag;
    }

    public void resetSampleContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSampleContent();
            return;
        }
        this.samplecontentDirtyFlag = false;
        this.samplecontent = null;
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

    public void setVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valign = string;
        this.valignDirtyFlag = true;
    }

    public String getVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlign();
        }
        return this.valign;
    }

    public boolean isVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignDirty();
        }
        return this.valignDirtyFlag;
    }

    public void resetVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlign();
            return;
        }
        this.valignDirtyFlag = false;
        this.valign = null;
    }

    protected void onReset() {
        PSSysCssBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCssBase pSSysCssBase) {
        pSSysCssBase.resetBKColor();
        pSSysCssBase.resetBorder();
        pSSysCssBase.resetBorderColor();
        pSSysCssBase.resetBorderStyle();
        pSSysCssBase.resetCodeName();
        pSSysCssBase.resetCreateDate();
        pSSysCssBase.resetCreateMan();
        pSSysCssBase.resetCssCatName();
        pSSysCssBase.resetCSSName();
        pSSysCssBase.resetCSSStyle();
        pSSysCssBase.resetCssStyle2();
        pSSysCssBase.resetFontColor();
        pSSysCssBase.resetFontFamily();
        pSSysCssBase.resetFontSize();
        pSSysCssBase.resetFontStyle();
        pSSysCssBase.resetFullCssName();
        pSSysCssBase.resetHAlign();
        pSSysCssBase.resetLockFlag();
        pSSysCssBase.resetMargin();
        pSSysCssBase.resetMemo();
        pSSysCssBase.resetOwnerId();
        pSSysCssBase.resetOwnerTag();
        pSSysCssBase.resetOwnerType();
        pSSysCssBase.resetPadding();
        pSSysCssBase.resetPSCssTemplId();
        pSSysCssBase.resetPSCssTemplName();
        pSSysCssBase.resetPSModuleId();
        pSSysCssBase.resetPSModuleName();
        pSSysCssBase.resetPSSysCssCatId();
        pSSysCssBase.resetPSSysCssCatName();
        pSSysCssBase.resetPSSysCssId();
        pSSysCssBase.resetPSSysCssName();
        pSSysCssBase.resetPSSystemId();
        pSSysCssBase.resetPSSystemName();
        pSSysCssBase.resetPublicFlag();
        pSSysCssBase.resetSampleContent();
        pSSysCssBase.resetUpdateDate();
        pSSysCssBase.resetUpdateMan();
        pSSysCssBase.resetUserCat();
        pSSysCssBase.resetUserTag();
        pSSysCssBase.resetUserTag2();
        pSSysCssBase.resetUserTag3();
        pSSysCssBase.resetUserTag4();
        pSSysCssBase.resetVAlign();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBKColorDirty()) {
            hashMap.put(FIELD_BKCOLOR, this.getBKColor());
        }
        if (!bl || this.isBorderDirty()) {
            hashMap.put(FIELD_BORDER, this.getBorder());
        }
        if (!bl || this.isBorderColorDirty()) {
            hashMap.put(FIELD_BORDERCOLOR, this.getBorderColor());
        }
        if (!bl || this.isBorderStyleDirty()) {
            hashMap.put(FIELD_BORDERSTYLE, this.getBorderStyle());
        }
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCssCatNameDirty()) {
            hashMap.put(FIELD_CSSCATNAME, this.getCssCatName());
        }
        if (!bl || this.isCSSNameDirty()) {
            hashMap.put(FIELD_CSSNAME, this.getCSSName());
        }
        if (!bl || this.isCSSStyleDirty()) {
            hashMap.put(FIELD_CSSSTYLE, this.getCSSStyle());
        }
        if (!bl || this.isCssStyle2Dirty()) {
            hashMap.put(FIELD_CSSSTYLE2, this.getCssStyle2());
        }
        if (!bl || this.isFontColorDirty()) {
            hashMap.put(FIELD_FONTCOLOR, this.getFontColor());
        }
        if (!bl || this.isFontFamilyDirty()) {
            hashMap.put(FIELD_FONTFAMILY, this.getFontFamily());
        }
        if (!bl || this.isFontSizeDirty()) {
            hashMap.put(FIELD_FONTSIZE, this.getFontSize());
        }
        if (!bl || this.isFontStyleDirty()) {
            hashMap.put(FIELD_FONTSTYLE, this.getFontStyle());
        }
        if (!bl || this.isFullCssNameDirty()) {
            hashMap.put(FIELD_FULLCSSNAME, this.getFullCssName());
        }
        if (!bl || this.isHAlignDirty()) {
            hashMap.put(FIELD_HALIGN, this.getHAlign());
        }
        if (!bl || this.isLockFlagDirty()) {
            hashMap.put(FIELD_LOCKFLAG, this.getLockFlag());
        }
        if (!bl || this.isMarginDirty()) {
            hashMap.put(FIELD_MARGIN, this.getMargin());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOwnerIdDirty()) {
            hashMap.put(FIELD_OWNERID, this.getOwnerId());
        }
        if (!bl || this.isOwnerTagDirty()) {
            hashMap.put(FIELD_OWNERTAG, this.getOwnerTag());
        }
        if (!bl || this.isOwnerTypeDirty()) {
            hashMap.put(FIELD_OWNERTYPE, this.getOwnerType());
        }
        if (!bl || this.isPaddingDirty()) {
            hashMap.put(FIELD_PADDING, this.getPadding());
        }
        if (!bl || this.isPSCssTemplIdDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLID, this.getPSCssTemplId());
        }
        if (!bl || this.isPSCssTemplNameDirty()) {
            hashMap.put(FIELD_PSCSSTEMPLNAME, this.getPSCssTemplName());
        }
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCssCatIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSCATID, this.getPSSysCssCatId());
        }
        if (!bl || this.isPSSysCssCatNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSCATNAME, this.getPSSysCssCatName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
        }
        if (!bl || this.isPublicFlagDirty()) {
            hashMap.put(FIELD_PUBLICFLAG, this.getPublicFlag());
        }
        if (!bl || this.isSampleContentDirty()) {
            hashMap.put(FIELD_SAMPLECONTENT, this.getSampleContent());
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
        if (!bl || this.isVAlignDirty()) {
            hashMap.put(FIELD_VALIGN, this.getVAlign());
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
        return PSSysCssBase.get(this, n);
    }

    private static Object get(PSSysCssBase pSSysCssBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssBase.getBKColor();
            }
            case 1: {
                return pSSysCssBase.getBorder();
            }
            case 2: {
                return pSSysCssBase.getBorderColor();
            }
            case 3: {
                return pSSysCssBase.getBorderStyle();
            }
            case 4: {
                return pSSysCssBase.getCodeName();
            }
            case 5: {
                return pSSysCssBase.getCreateDate();
            }
            case 6: {
                return pSSysCssBase.getCreateMan();
            }
            case 7: {
                return pSSysCssBase.getCssCatName();
            }
            case 8: {
                return pSSysCssBase.getCSSName();
            }
            case 9: {
                return pSSysCssBase.getCSSStyle();
            }
            case 10: {
                return pSSysCssBase.getCssStyle2();
            }
            case 11: {
                return pSSysCssBase.getFontColor();
            }
            case 12: {
                return pSSysCssBase.getFontFamily();
            }
            case 13: {
                return pSSysCssBase.getFontSize();
            }
            case 14: {
                return pSSysCssBase.getFontStyle();
            }
            case 15: {
                return pSSysCssBase.getFullCssName();
            }
            case 16: {
                return pSSysCssBase.getHAlign();
            }
            case 17: {
                return pSSysCssBase.getLockFlag();
            }
            case 18: {
                return pSSysCssBase.getMargin();
            }
            case 19: {
                return pSSysCssBase.getMemo();
            }
            case 20: {
                return pSSysCssBase.getOwnerId();
            }
            case 21: {
                return pSSysCssBase.getOwnerTag();
            }
            case 22: {
                return pSSysCssBase.getOwnerType();
            }
            case 23: {
                return pSSysCssBase.getPadding();
            }
            case 24: {
                return pSSysCssBase.getPSCssTemplId();
            }
            case 25: {
                return pSSysCssBase.getPSCssTemplName();
            }
            case 26: {
                return pSSysCssBase.getPSModuleId();
            }
            case 27: {
                return pSSysCssBase.getPSModuleName();
            }
            case 28: {
                return pSSysCssBase.getPSSysCssCatId();
            }
            case 29: {
                return pSSysCssBase.getPSSysCssCatName();
            }
            case 30: {
                return pSSysCssBase.getPSSysCssId();
            }
            case 31: {
                return pSSysCssBase.getPSSysCssName();
            }
            case 32: {
                return pSSysCssBase.getPSSystemId();
            }
            case 33: {
                return pSSysCssBase.getPSSystemName();
            }
            case 34: {
                return pSSysCssBase.getPublicFlag();
            }
            case 35: {
                return pSSysCssBase.getSampleContent();
            }
            case 36: {
                return pSSysCssBase.getUpdateDate();
            }
            case 37: {
                return pSSysCssBase.getUpdateMan();
            }
            case 38: {
                return pSSysCssBase.getUserCat();
            }
            case 39: {
                return pSSysCssBase.getUserTag();
            }
            case 40: {
                return pSSysCssBase.getUserTag2();
            }
            case 41: {
                return pSSysCssBase.getUserTag3();
            }
            case 42: {
                return pSSysCssBase.getUserTag4();
            }
            case 43: {
                return pSSysCssBase.getVAlign();
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
        PSSysCssBase.set(this, n, object);
    }

    private static void set(PSSysCssBase pSSysCssBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCssBase.setBKColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCssBase.setBorder(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCssBase.setBorderColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCssBase.setBorderStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCssBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCssBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysCssBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCssBase.setCssCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysCssBase.setCSSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCssBase.setCSSStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCssBase.setCssStyle2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCssBase.setFontColor(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCssBase.setFontFamily(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCssBase.setFontSize(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysCssBase.setFontStyle(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSSysCssBase.setFullCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCssBase.setHAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysCssBase.setLockFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSSysCssBase.setMargin(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCssBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCssBase.setOwnerId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCssBase.setOwnerTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCssBase.setOwnerType(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysCssBase.setPadding(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysCssBase.setPSCssTemplId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysCssBase.setPSCssTemplName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysCssBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysCssBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysCssBase.setPSSysCssCatId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysCssBase.setPSSysCssCatName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysCssBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysCssBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysCssBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysCssBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysCssBase.setPublicFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 35: {
                pSSysCssBase.setSampleContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysCssBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSSysCssBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysCssBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysCssBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysCssBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysCssBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysCssBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysCssBase.setVAlign(DataObject.getStringValue((Object)object));
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
        return PSSysCssBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCssBase pSSysCssBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssBase.getBKColor() == null;
            }
            case 1: {
                return pSSysCssBase.getBorder() == null;
            }
            case 2: {
                return pSSysCssBase.getBorderColor() == null;
            }
            case 3: {
                return pSSysCssBase.getBorderStyle() == null;
            }
            case 4: {
                return pSSysCssBase.getCodeName() == null;
            }
            case 5: {
                return pSSysCssBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysCssBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysCssBase.getCssCatName() == null;
            }
            case 8: {
                return pSSysCssBase.getCSSName() == null;
            }
            case 9: {
                return pSSysCssBase.getCSSStyle() == null;
            }
            case 10: {
                return pSSysCssBase.getCssStyle2() == null;
            }
            case 11: {
                return pSSysCssBase.getFontColor() == null;
            }
            case 12: {
                return pSSysCssBase.getFontFamily() == null;
            }
            case 13: {
                return pSSysCssBase.getFontSize() == null;
            }
            case 14: {
                return pSSysCssBase.getFontStyle() == null;
            }
            case 15: {
                return pSSysCssBase.getFullCssName() == null;
            }
            case 16: {
                return pSSysCssBase.getHAlign() == null;
            }
            case 17: {
                return pSSysCssBase.getLockFlag() == null;
            }
            case 18: {
                return pSSysCssBase.getMargin() == null;
            }
            case 19: {
                return pSSysCssBase.getMemo() == null;
            }
            case 20: {
                return pSSysCssBase.getOwnerId() == null;
            }
            case 21: {
                return pSSysCssBase.getOwnerTag() == null;
            }
            case 22: {
                return pSSysCssBase.getOwnerType() == null;
            }
            case 23: {
                return pSSysCssBase.getPadding() == null;
            }
            case 24: {
                return pSSysCssBase.getPSCssTemplId() == null;
            }
            case 25: {
                return pSSysCssBase.getPSCssTemplName() == null;
            }
            case 26: {
                return pSSysCssBase.getPSModuleId() == null;
            }
            case 27: {
                return pSSysCssBase.getPSModuleName() == null;
            }
            case 28: {
                return pSSysCssBase.getPSSysCssCatId() == null;
            }
            case 29: {
                return pSSysCssBase.getPSSysCssCatName() == null;
            }
            case 30: {
                return pSSysCssBase.getPSSysCssId() == null;
            }
            case 31: {
                return pSSysCssBase.getPSSysCssName() == null;
            }
            case 32: {
                return pSSysCssBase.getPSSystemId() == null;
            }
            case 33: {
                return pSSysCssBase.getPSSystemName() == null;
            }
            case 34: {
                return pSSysCssBase.getPublicFlag() == null;
            }
            case 35: {
                return pSSysCssBase.getSampleContent() == null;
            }
            case 36: {
                return pSSysCssBase.getUpdateDate() == null;
            }
            case 37: {
                return pSSysCssBase.getUpdateMan() == null;
            }
            case 38: {
                return pSSysCssBase.getUserCat() == null;
            }
            case 39: {
                return pSSysCssBase.getUserTag() == null;
            }
            case 40: {
                return pSSysCssBase.getUserTag2() == null;
            }
            case 41: {
                return pSSysCssBase.getUserTag3() == null;
            }
            case 42: {
                return pSSysCssBase.getUserTag4() == null;
            }
            case 43: {
                return pSSysCssBase.getVAlign() == null;
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
        return PSSysCssBase.contains(this, n);
    }

    private static boolean contains(PSSysCssBase pSSysCssBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCssBase.isBKColorDirty();
            }
            case 1: {
                return pSSysCssBase.isBorderDirty();
            }
            case 2: {
                return pSSysCssBase.isBorderColorDirty();
            }
            case 3: {
                return pSSysCssBase.isBorderStyleDirty();
            }
            case 4: {
                return pSSysCssBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysCssBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysCssBase.isCreateManDirty();
            }
            case 7: {
                return pSSysCssBase.isCssCatNameDirty();
            }
            case 8: {
                return pSSysCssBase.isCSSNameDirty();
            }
            case 9: {
                return pSSysCssBase.isCSSStyleDirty();
            }
            case 10: {
                return pSSysCssBase.isCssStyle2Dirty();
            }
            case 11: {
                return pSSysCssBase.isFontColorDirty();
            }
            case 12: {
                return pSSysCssBase.isFontFamilyDirty();
            }
            case 13: {
                return pSSysCssBase.isFontSizeDirty();
            }
            case 14: {
                return pSSysCssBase.isFontStyleDirty();
            }
            case 15: {
                return pSSysCssBase.isFullCssNameDirty();
            }
            case 16: {
                return pSSysCssBase.isHAlignDirty();
            }
            case 17: {
                return pSSysCssBase.isLockFlagDirty();
            }
            case 18: {
                return pSSysCssBase.isMarginDirty();
            }
            case 19: {
                return pSSysCssBase.isMemoDirty();
            }
            case 20: {
                return pSSysCssBase.isOwnerIdDirty();
            }
            case 21: {
                return pSSysCssBase.isOwnerTagDirty();
            }
            case 22: {
                return pSSysCssBase.isOwnerTypeDirty();
            }
            case 23: {
                return pSSysCssBase.isPaddingDirty();
            }
            case 24: {
                return pSSysCssBase.isPSCssTemplIdDirty();
            }
            case 25: {
                return pSSysCssBase.isPSCssTemplNameDirty();
            }
            case 26: {
                return pSSysCssBase.isPSModuleIdDirty();
            }
            case 27: {
                return pSSysCssBase.isPSModuleNameDirty();
            }
            case 28: {
                return pSSysCssBase.isPSSysCssCatIdDirty();
            }
            case 29: {
                return pSSysCssBase.isPSSysCssCatNameDirty();
            }
            case 30: {
                return pSSysCssBase.isPSSysCssIdDirty();
            }
            case 31: {
                return pSSysCssBase.isPSSysCssNameDirty();
            }
            case 32: {
                return pSSysCssBase.isPSSystemIdDirty();
            }
            case 33: {
                return pSSysCssBase.isPSSystemNameDirty();
            }
            case 34: {
                return pSSysCssBase.isPublicFlagDirty();
            }
            case 35: {
                return pSSysCssBase.isSampleContentDirty();
            }
            case 36: {
                return pSSysCssBase.isUpdateDateDirty();
            }
            case 37: {
                return pSSysCssBase.isUpdateManDirty();
            }
            case 38: {
                return pSSysCssBase.isUserCatDirty();
            }
            case 39: {
                return pSSysCssBase.isUserTagDirty();
            }
            case 40: {
                return pSSysCssBase.isUserTag2Dirty();
            }
            case 41: {
                return pSSysCssBase.isUserTag3Dirty();
            }
            case 42: {
                return pSSysCssBase.isUserTag4Dirty();
            }
            case 43: {
                return pSSysCssBase.isVAlignDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCssBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCssBase pSSysCssBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCssBase.getBKColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bkcolor", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getBKColor()), (boolean)false);
        }
        if (bl || pSSysCssBase.getBorder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"border", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getBorder()), (boolean)false);
        }
        if (bl || pSSysCssBase.getBorderColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bordercolor", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getBorderColor()), (boolean)false);
        }
        if (bl || pSSysCssBase.getBorderStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"borderstyle", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getBorderStyle()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCssCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"csscatname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCssCatName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCSSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCSSName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCSSStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssstyle", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCSSStyle()), (boolean)false);
        }
        if (bl || pSSysCssBase.getCssStyle2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cssstyle2", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getCssStyle2()), (boolean)false);
        }
        if (bl || pSSysCssBase.getFontColor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fontcolor", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getFontColor()), (boolean)false);
        }
        if (bl || pSSysCssBase.getFontFamily() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fontfamily", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getFontFamily()), (boolean)false);
        }
        if (bl || pSSysCssBase.getFontSize() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fontsize", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getFontSize()), (boolean)false);
        }
        if (bl || pSSysCssBase.getFontStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fontstyle", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getFontStyle()), (boolean)false);
        }
        if (bl || pSSysCssBase.getFullCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fullcssname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getFullCssName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getHAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halign", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getHAlign()), (boolean)false);
        }
        if (bl || pSSysCssBase.getLockFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lockflag", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getLockFlag()), (boolean)false);
        }
        if (bl || pSSysCssBase.getMargin() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"margin", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getMargin()), (boolean)false);
        }
        if (bl || pSSysCssBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCssBase.getOwnerId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownerid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getOwnerId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getOwnerTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertag", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getOwnerTag()), (boolean)false);
        }
        if (bl || pSSysCssBase.getOwnerType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ownertype", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getOwnerType()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPadding() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"padding", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPadding()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSCssTemplId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSCssTemplId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSCssTemplName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscsstemplname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSCssTemplName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSysCssCatId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscsscatid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSysCssCatId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSysCssCatName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscsscatname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSysCssCatName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCssBase.getPublicFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"publicflag", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getPublicFlag()), (boolean)false);
        }
        if (bl || pSSysCssBase.getSampleContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"samplecontent", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getSampleContent()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCssBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysCssBase.getVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valign", (Object)PSSysCssBase.getJSONValue((Object)pSSysCssBase.getVAlign()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCssBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCssBase pSSysCssBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCssBase.getBKColor() != null) {
            object = pSSysCssBase.getBKColor();
            xmlNode.setAttribute(FIELD_BKCOLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCssBase.getBorder() != null) {
            object = pSSysCssBase.getBorder();
            xmlNode.setAttribute(FIELD_BORDER, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCssBase.getBorderColor() != null) {
            object = pSSysCssBase.getBorderColor();
            xmlNode.setAttribute(FIELD_BORDERCOLOR, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCssBase.getBorderStyle() != null) {
            object = pSSysCssBase.getBorderStyle();
            xmlNode.setAttribute(FIELD_BORDERSTYLE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCssBase.getCodeName() != null) {
            object = pSSysCssBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getCreateDate() != null) {
            object = pSSysCssBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCssBase.getCreateMan() != null) {
            object = pSSysCssBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getCssCatName() != null) {
            object = pSSysCssBase.getCssCatName();
            xmlNode.setAttribute(FIELD_CSSCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getCSSName() != null) {
            object = pSSysCssBase.getCSSName();
            xmlNode.setAttribute(FIELD_CSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getCSSStyle() != null) {
            object = pSSysCssBase.getCSSStyle();
            xmlNode.setAttribute(FIELD_CSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getCssStyle2() != null) {
            object = pSSysCssBase.getCssStyle2();
            xmlNode.setAttribute(FIELD_CSSSTYLE2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getFontColor() != null) {
            object = pSSysCssBase.getFontColor();
            xmlNode.setAttribute(FIELD_FONTCOLOR, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getFontFamily() != null) {
            object = pSSysCssBase.getFontFamily();
            xmlNode.setAttribute(FIELD_FONTFAMILY, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getFontSize() != null) {
            object = pSSysCssBase.getFontSize();
            xmlNode.setAttribute(FIELD_FONTSIZE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCssBase.getFontStyle() != null) {
            object = pSSysCssBase.getFontStyle();
            xmlNode.setAttribute(FIELD_FONTSTYLE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCssBase.getFullCssName() != null) {
            object = pSSysCssBase.getFullCssName();
            xmlNode.setAttribute(FIELD_FULLCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getHAlign() != null) {
            object = pSSysCssBase.getHAlign();
            xmlNode.setAttribute(FIELD_HALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getLockFlag() != null) {
            object = pSSysCssBase.getLockFlag();
            xmlNode.setAttribute(FIELD_LOCKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCssBase.getMargin() != null) {
            object = pSSysCssBase.getMargin();
            xmlNode.setAttribute(FIELD_MARGIN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getMemo() != null) {
            object = pSSysCssBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getOwnerId() != null) {
            object = pSSysCssBase.getOwnerId();
            xmlNode.setAttribute(FIELD_OWNERID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getOwnerTag() != null) {
            object = pSSysCssBase.getOwnerTag();
            xmlNode.setAttribute(FIELD_OWNERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getOwnerType() != null) {
            object = pSSysCssBase.getOwnerType();
            xmlNode.setAttribute(FIELD_OWNERTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPadding() != null) {
            object = pSSysCssBase.getPadding();
            xmlNode.setAttribute(FIELD_PADDING, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSCssTemplId() != null) {
            object = pSSysCssBase.getPSCssTemplId();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSCssTemplName() != null) {
            object = pSSysCssBase.getPSCssTemplName();
            xmlNode.setAttribute(FIELD_PSCSSTEMPLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSModuleId() != null) {
            object = pSSysCssBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSModuleName() != null) {
            object = pSSysCssBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSysCssCatId() != null) {
            object = pSSysCssBase.getPSSysCssCatId();
            xmlNode.setAttribute(FIELD_PSSYSCSSCATID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSysCssCatName() != null) {
            object = pSSysCssBase.getPSSysCssCatName();
            xmlNode.setAttribute(FIELD_PSSYSCSSCATNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSysCssId() != null) {
            object = pSSysCssBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSysCssName() != null) {
            object = pSSysCssBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSystemId() != null) {
            object = pSSysCssBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPSSystemName() != null) {
            object = pSSysCssBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getPublicFlag() != null) {
            object = pSSysCssBase.getPublicFlag();
            xmlNode.setAttribute(FIELD_PUBLICFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysCssBase.getSampleContent() != null) {
            object = pSSysCssBase.getSampleContent();
            xmlNode.setAttribute(FIELD_SAMPLECONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUpdateDate() != null) {
            object = pSSysCssBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCssBase.getUpdateMan() != null) {
            object = pSSysCssBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUserCat() != null) {
            object = pSSysCssBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUserTag() != null) {
            object = pSSysCssBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUserTag2() != null) {
            object = pSSysCssBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUserTag3() != null) {
            object = pSSysCssBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getUserTag4() != null) {
            object = pSSysCssBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysCssBase.getVAlign() != null) {
            object = pSSysCssBase.getVAlign();
            xmlNode.setAttribute(FIELD_VALIGN, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCssBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCssBase pSSysCssBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCssBase.isBKColorDirty() && (bl || pSSysCssBase.getBKColor() != null)) {
            iDataObject.set(FIELD_BKCOLOR, (Object)pSSysCssBase.getBKColor());
        }
        if (pSSysCssBase.isBorderDirty() && (bl || pSSysCssBase.getBorder() != null)) {
            iDataObject.set(FIELD_BORDER, (Object)pSSysCssBase.getBorder());
        }
        if (pSSysCssBase.isBorderColorDirty() && (bl || pSSysCssBase.getBorderColor() != null)) {
            iDataObject.set(FIELD_BORDERCOLOR, (Object)pSSysCssBase.getBorderColor());
        }
        if (pSSysCssBase.isBorderStyleDirty() && (bl || pSSysCssBase.getBorderStyle() != null)) {
            iDataObject.set(FIELD_BORDERSTYLE, (Object)pSSysCssBase.getBorderStyle());
        }
        if (pSSysCssBase.isCodeNameDirty() && (bl || pSSysCssBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCssBase.getCodeName());
        }
        if (pSSysCssBase.isCreateDateDirty() && (bl || pSSysCssBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCssBase.getCreateDate());
        }
        if (pSSysCssBase.isCreateManDirty() && (bl || pSSysCssBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCssBase.getCreateMan());
        }
        if (pSSysCssBase.isCssCatNameDirty() && (bl || pSSysCssBase.getCssCatName() != null)) {
            iDataObject.set(FIELD_CSSCATNAME, (Object)pSSysCssBase.getCssCatName());
        }
        if (pSSysCssBase.isCSSNameDirty() && (bl || pSSysCssBase.getCSSName() != null)) {
            iDataObject.set(FIELD_CSSNAME, (Object)pSSysCssBase.getCSSName());
        }
        if (pSSysCssBase.isCSSStyleDirty() && (bl || pSSysCssBase.getCSSStyle() != null)) {
            iDataObject.set(FIELD_CSSSTYLE, (Object)pSSysCssBase.getCSSStyle());
        }
        if (pSSysCssBase.isCssStyle2Dirty() && (bl || pSSysCssBase.getCssStyle2() != null)) {
            iDataObject.set(FIELD_CSSSTYLE2, (Object)pSSysCssBase.getCssStyle2());
        }
        if (pSSysCssBase.isFontColorDirty() && (bl || pSSysCssBase.getFontColor() != null)) {
            iDataObject.set(FIELD_FONTCOLOR, (Object)pSSysCssBase.getFontColor());
        }
        if (pSSysCssBase.isFontFamilyDirty() && (bl || pSSysCssBase.getFontFamily() != null)) {
            iDataObject.set(FIELD_FONTFAMILY, (Object)pSSysCssBase.getFontFamily());
        }
        if (pSSysCssBase.isFontSizeDirty() && (bl || pSSysCssBase.getFontSize() != null)) {
            iDataObject.set(FIELD_FONTSIZE, (Object)pSSysCssBase.getFontSize());
        }
        if (pSSysCssBase.isFontStyleDirty() && (bl || pSSysCssBase.getFontStyle() != null)) {
            iDataObject.set(FIELD_FONTSTYLE, (Object)pSSysCssBase.getFontStyle());
        }
        if (pSSysCssBase.isFullCssNameDirty() && (bl || pSSysCssBase.getFullCssName() != null)) {
            iDataObject.set(FIELD_FULLCSSNAME, (Object)pSSysCssBase.getFullCssName());
        }
        if (pSSysCssBase.isHAlignDirty() && (bl || pSSysCssBase.getHAlign() != null)) {
            iDataObject.set(FIELD_HALIGN, (Object)pSSysCssBase.getHAlign());
        }
        if (pSSysCssBase.isLockFlagDirty() && (bl || pSSysCssBase.getLockFlag() != null)) {
            iDataObject.set(FIELD_LOCKFLAG, (Object)pSSysCssBase.getLockFlag());
        }
        if (pSSysCssBase.isMarginDirty() && (bl || pSSysCssBase.getMargin() != null)) {
            iDataObject.set(FIELD_MARGIN, (Object)pSSysCssBase.getMargin());
        }
        if (pSSysCssBase.isMemoDirty() && (bl || pSSysCssBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCssBase.getMemo());
        }
        if (pSSysCssBase.isOwnerIdDirty() && (bl || pSSysCssBase.getOwnerId() != null)) {
            iDataObject.set(FIELD_OWNERID, (Object)pSSysCssBase.getOwnerId());
        }
        if (pSSysCssBase.isOwnerTagDirty() && (bl || pSSysCssBase.getOwnerTag() != null)) {
            iDataObject.set(FIELD_OWNERTAG, (Object)pSSysCssBase.getOwnerTag());
        }
        if (pSSysCssBase.isOwnerTypeDirty() && (bl || pSSysCssBase.getOwnerType() != null)) {
            iDataObject.set(FIELD_OWNERTYPE, (Object)pSSysCssBase.getOwnerType());
        }
        if (pSSysCssBase.isPaddingDirty() && (bl || pSSysCssBase.getPadding() != null)) {
            iDataObject.set(FIELD_PADDING, (Object)pSSysCssBase.getPadding());
        }
        if (pSSysCssBase.isPSCssTemplIdDirty() && (bl || pSSysCssBase.getPSCssTemplId() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLID, (Object)pSSysCssBase.getPSCssTemplId());
        }
        if (pSSysCssBase.isPSCssTemplNameDirty() && (bl || pSSysCssBase.getPSCssTemplName() != null)) {
            iDataObject.set(FIELD_PSCSSTEMPLNAME, (Object)pSSysCssBase.getPSCssTemplName());
        }
        if (pSSysCssBase.isPSModuleIdDirty() && (bl || pSSysCssBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysCssBase.getPSModuleId());
        }
        if (pSSysCssBase.isPSModuleNameDirty() && (bl || pSSysCssBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysCssBase.getPSModuleName());
        }
        if (pSSysCssBase.isPSSysCssCatIdDirty() && (bl || pSSysCssBase.getPSSysCssCatId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSCATID, (Object)pSSysCssBase.getPSSysCssCatId());
        }
        if (pSSysCssBase.isPSSysCssCatNameDirty() && (bl || pSSysCssBase.getPSSysCssCatName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSCATNAME, (Object)pSSysCssBase.getPSSysCssCatName());
        }
        if (pSSysCssBase.isPSSysCssIdDirty() && (bl || pSSysCssBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysCssBase.getPSSysCssId());
        }
        if (pSSysCssBase.isPSSysCssNameDirty() && (bl || pSSysCssBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysCssBase.getPSSysCssName());
        }
        if (pSSysCssBase.isPSSystemIdDirty() && (bl || pSSysCssBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCssBase.getPSSystemId());
        }
        if (pSSysCssBase.isPSSystemNameDirty() && (bl || pSSysCssBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCssBase.getPSSystemName());
        }
        if (pSSysCssBase.isPublicFlagDirty() && (bl || pSSysCssBase.getPublicFlag() != null)) {
            iDataObject.set(FIELD_PUBLICFLAG, (Object)pSSysCssBase.getPublicFlag());
        }
        if (pSSysCssBase.isSampleContentDirty() && (bl || pSSysCssBase.getSampleContent() != null)) {
            iDataObject.set(FIELD_SAMPLECONTENT, (Object)pSSysCssBase.getSampleContent());
        }
        if (pSSysCssBase.isUpdateDateDirty() && (bl || pSSysCssBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCssBase.getUpdateDate());
        }
        if (pSSysCssBase.isUpdateManDirty() && (bl || pSSysCssBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCssBase.getUpdateMan());
        }
        if (pSSysCssBase.isUserCatDirty() && (bl || pSSysCssBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCssBase.getUserCat());
        }
        if (pSSysCssBase.isUserTagDirty() && (bl || pSSysCssBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCssBase.getUserTag());
        }
        if (pSSysCssBase.isUserTag2Dirty() && (bl || pSSysCssBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCssBase.getUserTag2());
        }
        if (pSSysCssBase.isUserTag3Dirty() && (bl || pSSysCssBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCssBase.getUserTag3());
        }
        if (pSSysCssBase.isUserTag4Dirty() && (bl || pSSysCssBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCssBase.getUserTag4());
        }
        if (pSSysCssBase.isVAlignDirty() && (bl || pSSysCssBase.getVAlign() != null)) {
            iDataObject.set(FIELD_VALIGN, (Object)pSSysCssBase.getVAlign());
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
        return PSSysCssBase.remove(this, n);
    }

    private static boolean remove(PSSysCssBase pSSysCssBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCssBase.resetBKColor();
                return true;
            }
            case 1: {
                pSSysCssBase.resetBorder();
                return true;
            }
            case 2: {
                pSSysCssBase.resetBorderColor();
                return true;
            }
            case 3: {
                pSSysCssBase.resetBorderStyle();
                return true;
            }
            case 4: {
                pSSysCssBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysCssBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysCssBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysCssBase.resetCssCatName();
                return true;
            }
            case 8: {
                pSSysCssBase.resetCSSName();
                return true;
            }
            case 9: {
                pSSysCssBase.resetCSSStyle();
                return true;
            }
            case 10: {
                pSSysCssBase.resetCssStyle2();
                return true;
            }
            case 11: {
                pSSysCssBase.resetFontColor();
                return true;
            }
            case 12: {
                pSSysCssBase.resetFontFamily();
                return true;
            }
            case 13: {
                pSSysCssBase.resetFontSize();
                return true;
            }
            case 14: {
                pSSysCssBase.resetFontStyle();
                return true;
            }
            case 15: {
                pSSysCssBase.resetFullCssName();
                return true;
            }
            case 16: {
                pSSysCssBase.resetHAlign();
                return true;
            }
            case 17: {
                pSSysCssBase.resetLockFlag();
                return true;
            }
            case 18: {
                pSSysCssBase.resetMargin();
                return true;
            }
            case 19: {
                pSSysCssBase.resetMemo();
                return true;
            }
            case 20: {
                pSSysCssBase.resetOwnerId();
                return true;
            }
            case 21: {
                pSSysCssBase.resetOwnerTag();
                return true;
            }
            case 22: {
                pSSysCssBase.resetOwnerType();
                return true;
            }
            case 23: {
                pSSysCssBase.resetPadding();
                return true;
            }
            case 24: {
                pSSysCssBase.resetPSCssTemplId();
                return true;
            }
            case 25: {
                pSSysCssBase.resetPSCssTemplName();
                return true;
            }
            case 26: {
                pSSysCssBase.resetPSModuleId();
                return true;
            }
            case 27: {
                pSSysCssBase.resetPSModuleName();
                return true;
            }
            case 28: {
                pSSysCssBase.resetPSSysCssCatId();
                return true;
            }
            case 29: {
                pSSysCssBase.resetPSSysCssCatName();
                return true;
            }
            case 30: {
                pSSysCssBase.resetPSSysCssId();
                return true;
            }
            case 31: {
                pSSysCssBase.resetPSSysCssName();
                return true;
            }
            case 32: {
                pSSysCssBase.resetPSSystemId();
                return true;
            }
            case 33: {
                pSSysCssBase.resetPSSystemName();
                return true;
            }
            case 34: {
                pSSysCssBase.resetPublicFlag();
                return true;
            }
            case 35: {
                pSSysCssBase.resetSampleContent();
                return true;
            }
            case 36: {
                pSSysCssBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSSysCssBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSSysCssBase.resetUserCat();
                return true;
            }
            case 39: {
                pSSysCssBase.resetUserTag();
                return true;
            }
            case 40: {
                pSSysCssBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSSysCssBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSSysCssBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSSysCssBase.resetVAlign();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSCssTempl getPSCssTempl() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSCssTempl();
        }
        if (this.getPSCssTemplId() == null) {
            return null;
        }
        Integer n = this.objPSCssTemplLock;
        synchronized (n) {
            if (this.pscsstempl != null && DataTypeHelper.compare((int)25, (Object)this.getPSCssTemplId(), (Object)this.pscsstempl.getPSCssTemplId()) != 0L) {
                this.pscsstempl = null;
            }
            if (this.pscsstempl == null) {
                PSCssTempl pSCssTempl = new PSCssTempl();
                pSCssTempl.setPSCssTemplId(this.getPSCssTemplId());
                PSCssTemplService pSCssTemplService = (PSCssTemplService)ServiceGlobal.getService(PSCssTemplService.class, (SessionFactory)this.getSessionFactory());
                pSCssTemplService.autoGet((IEntity)pSCssTempl);
                this.pscsstempl = pSCssTempl;
            }
            return this.pscsstempl;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet((IEntity)pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCssCat getPSSysCssCat() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCssCat();
        }
        if (this.getPSSysCssCatId() == null) {
            return null;
        }
        Integer n = this.objPSSysCssCatLock;
        synchronized (n) {
            if (this.pssyscsscat != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysCssCatId(), (Object)this.pssyscsscat.getPSSysCssCatId()) != 0L) {
                this.pssyscsscat = null;
            }
            if (this.pssyscsscat == null) {
                PSSysCssCat pSSysCssCat = new PSSysCssCat();
                pSSysCssCat.setPSSysCssCatId(this.getPSSysCssCatId());
                PSSysCssCatService pSSysCssCatService = (PSSysCssCatService)ServiceGlobal.getService(PSSysCssCatService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssCatService.autoGet((IEntity)pSSysCssCat);
                this.pssyscsscat = pSSysCssCat;
            }
            return this.pssyscsscat;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet((IEntity)pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    private PSSysCssBase getProxyEntity() {
        return this.proxyPSSysCssBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCssBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCssBase) {
            this.proxyPSSysCssBase = (PSSysCssBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BKCOLOR, 0);
        fieldIndexMap.put(FIELD_BORDER, 1);
        fieldIndexMap.put(FIELD_BORDERCOLOR, 2);
        fieldIndexMap.put(FIELD_BORDERSTYLE, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CSSCATNAME, 7);
        fieldIndexMap.put(FIELD_CSSNAME, 8);
        fieldIndexMap.put(FIELD_CSSSTYLE, 9);
        fieldIndexMap.put(FIELD_CSSSTYLE2, 10);
        fieldIndexMap.put(FIELD_FONTCOLOR, 11);
        fieldIndexMap.put(FIELD_FONTFAMILY, 12);
        fieldIndexMap.put(FIELD_FONTSIZE, 13);
        fieldIndexMap.put(FIELD_FONTSTYLE, 14);
        fieldIndexMap.put(FIELD_FULLCSSNAME, 15);
        fieldIndexMap.put(FIELD_HALIGN, 16);
        fieldIndexMap.put(FIELD_LOCKFLAG, 17);
        fieldIndexMap.put(FIELD_MARGIN, 18);
        fieldIndexMap.put(FIELD_MEMO, 19);
        fieldIndexMap.put(FIELD_OWNERID, 20);
        fieldIndexMap.put(FIELD_OWNERTAG, 21);
        fieldIndexMap.put(FIELD_OWNERTYPE, 22);
        fieldIndexMap.put(FIELD_PADDING, 23);
        fieldIndexMap.put(FIELD_PSCSSTEMPLID, 24);
        fieldIndexMap.put(FIELD_PSCSSTEMPLNAME, 25);
        fieldIndexMap.put(FIELD_PSMODULEID, 26);
        fieldIndexMap.put(FIELD_PSMODULENAME, 27);
        fieldIndexMap.put(FIELD_PSSYSCSSCATID, 28);
        fieldIndexMap.put(FIELD_PSSYSCSSCATNAME, 29);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 30);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 32);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 33);
        fieldIndexMap.put(FIELD_PUBLICFLAG, 34);
        fieldIndexMap.put(FIELD_SAMPLECONTENT, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
        fieldIndexMap.put(FIELD_VALIGN, 43);
    }
}

