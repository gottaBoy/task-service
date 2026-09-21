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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDBPart;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDashboard;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysPortlet;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDashboardService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysPortletService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysDBPartBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysDBPartBase.class);
    public static final String FIELD_BL_POS = "BL_POS";
    public static final String FIELD_COLID = "COLID";
    public static final String FIELD_COLSPAN = "COLSPAN";
    public static final String FIELD_COL_LG = "COL_LG";
    public static final String FIELD_COL_LG_OS = "COL_LG_OS";
    public static final String FIELD_COL_MD = "COL_MD";
    public static final String FIELD_COL_MD_OS = "COL_MD_OS";
    public static final String FIELD_COL_SM = "COL_SM";
    public static final String FIELD_COL_SM_OS = "COL_SM_OS";
    public static final String FIELD_COL_XS = "COL_XS";
    public static final String FIELD_COL_XS_OS = "COL_XS_OS";
    public static final String FIELD_CONTENTTYPE = "CONTENTTYPE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DBPARTTYPE = "DBPARTTYPE";
    public static final String FIELD_DYNACLASS = "DYNACLASS";
    public static final String FIELD_ENABLEANCHOR = "ENABLEANCHOR";
    public static final String FIELD_FLEXALIGN = "FLEXALIGN";
    public static final String FIELD_FLEXBASIS = "FLEXBASIS";
    public static final String FIELD_FLEXDIR = "FLEXDIR";
    public static final String FIELD_FLEXGROW = "FLEXGROW";
    public static final String FIELD_FLEXSHRINK = "FLEXSHRINK";
    public static final String FIELD_FLEXVALIGN = "FLEXVALIGN";
    public static final String FIELD_HALIGNSELF = "HALIGNSELF";
    public static final String FIELD_HEIGHT = "HEIGHT";
    public static final String FIELD_HTMLCONTENT = "HTMLCONTENT";
    public static final String FIELD_LAYOUTMODE = "LAYOUTMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NEWROWMODE = "NEWROWMODE";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PARTPARAMS = "PARTPARAMS";
    public static final String FIELD_PARTSTYLE = "PARTSTYLE";
    public static final String FIELD_PORTLETTYPE = "PORTLETTYPE";
    public static final String FIELD_POSINFO = "POSINFO";
    public static final String FIELD_PPSSYSDBPARTID = "PPSSYSDBPARTID";
    public static final String FIELD_PPSSYSDBPARTNAME = "PPSSYSDBPARTNAME";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSDASHBOARDID = "PSSYSDASHBOARDID";
    public static final String FIELD_PSSYSDASHBOARDNAME = "PSSYSDASHBOARDNAME";
    public static final String FIELD_PSSYSDBPARTID = "PSSYSDBPARTID";
    public static final String FIELD_PSSYSDBPARTNAME = "PSSYSDBPARTNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSPORTLETID = "PSSYSPORTLETID";
    public static final String FIELD_PSSYSPORTLETNAME = "PSSYSPORTLETNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_RAWCONTENT = "RAWCONTENT";
    public static final String FIELD_RAWCSSSTYLE = "RAWCSSSTYLE";
    public static final String FIELD_SHOWTITLEBAR = "SHOWTITLEBAR";
    public static final String FIELD_SWAPMODE = "SWAPMODE";
    public static final String FIELD_TEMPLATEMODE = "TEMPLATEMODE";
    public static final String FIELD_TITLE = "TITLE";
    public static final String FIELD_TITLEBARCLOSEMODE = "TITLEBARCLOSEMODE";
    public static final String FIELD_TITLEPSLANRESID = "TITLEPSLANRESID";
    public static final String FIELD_TITLEPSLANRESNAME = "TITLEPSLANRESNAME";
    public static final String FIELD_TOOLTIPINFO = "TOOLTIPINFO";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALIGNSELF = "VALIGNSELF";
    public static final String FIELD_WIDTH = "WIDTH";
    private static final int INDEX_BL_POS = 0;
    private static final int INDEX_COLID = 1;
    private static final int INDEX_COLSPAN = 2;
    private static final int INDEX_COL_LG = 3;
    private static final int INDEX_COL_LG_OS = 4;
    private static final int INDEX_COL_MD = 5;
    private static final int INDEX_COL_MD_OS = 6;
    private static final int INDEX_COL_SM = 7;
    private static final int INDEX_COL_SM_OS = 8;
    private static final int INDEX_COL_XS = 9;
    private static final int INDEX_COL_XS_OS = 10;
    private static final int INDEX_CONTENTTYPE = 11;
    private static final int INDEX_CREATEDATE = 12;
    private static final int INDEX_CREATEMAN = 13;
    private static final int INDEX_DBPARTTYPE = 14;
    private static final int INDEX_DYNACLASS = 15;
    private static final int INDEX_ENABLEANCHOR = 16;
    private static final int INDEX_FLEXALIGN = 17;
    private static final int INDEX_FLEXBASIS = 18;
    private static final int INDEX_FLEXDIR = 19;
    private static final int INDEX_FLEXGROW = 20;
    private static final int INDEX_FLEXSHRINK = 21;
    private static final int INDEX_FLEXVALIGN = 22;
    private static final int INDEX_HALIGNSELF = 23;
    private static final int INDEX_HEIGHT = 24;
    private static final int INDEX_HTMLCONTENT = 25;
    private static final int INDEX_LAYOUTMODE = 26;
    private static final int INDEX_MEMO = 27;
    private static final int INDEX_NEWROWMODE = 28;
    private static final int INDEX_ORDERVALUE = 29;
    private static final int INDEX_PARTPARAMS = 30;
    private static final int INDEX_PARTSTYLE = 31;
    private static final int INDEX_PORTLETTYPE = 32;
    private static final int INDEX_POSINFO = 33;
    private static final int INDEX_PPSSYSDBPARTID = 34;
    private static final int INDEX_PPSSYSDBPARTNAME = 35;
    private static final int INDEX_PSSYSCSSID = 36;
    private static final int INDEX_PSSYSCSSNAME = 37;
    private static final int INDEX_PSSYSDASHBOARDID = 38;
    private static final int INDEX_PSSYSDASHBOARDNAME = 39;
    private static final int INDEX_PSSYSDBPARTID = 40;
    private static final int INDEX_PSSYSDBPARTNAME = 41;
    private static final int INDEX_PSSYSIMAGEID = 42;
    private static final int INDEX_PSSYSIMAGENAME = 43;
    private static final int INDEX_PSSYSPFPLUGINID = 44;
    private static final int INDEX_PSSYSPFPLUGINNAME = 45;
    private static final int INDEX_PSSYSPORTLETID = 46;
    private static final int INDEX_PSSYSPORTLETNAME = 47;
    private static final int INDEX_PSSYSRESOURCEID = 48;
    private static final int INDEX_PSSYSRESOURCENAME = 49;
    private static final int INDEX_PSSYSUNIRESID = 50;
    private static final int INDEX_PSSYSUNIRESNAME = 51;
    private static final int INDEX_RAWCONTENT = 52;
    private static final int INDEX_RAWCSSSTYLE = 53;
    private static final int INDEX_SHOWTITLEBAR = 54;
    private static final int INDEX_SWAPMODE = 55;
    private static final int INDEX_TEMPLATEMODE = 56;
    private static final int INDEX_TITLE = 57;
    private static final int INDEX_TITLEBARCLOSEMODE = 58;
    private static final int INDEX_TITLEPSLANRESID = 59;
    private static final int INDEX_TITLEPSLANRESNAME = 60;
    private static final int INDEX_TOOLTIPINFO = 61;
    private static final int INDEX_UPDATEDATE = 62;
    private static final int INDEX_UPDATEMAN = 63;
    private static final int INDEX_USERTAG = 64;
    private static final int INDEX_USERTAG2 = 65;
    private static final int INDEX_VALIDFLAG = 66;
    private static final int INDEX_VALIGNSELF = 67;
    private static final int INDEX_WIDTH = 68;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysDBPartBase proxyPSSysDBPartBase = null;
    private boolean bl_posDirtyFlag = false;
    private boolean colidDirtyFlag = false;
    private boolean colspanDirtyFlag = false;
    private boolean col_lgDirtyFlag = false;
    private boolean col_lg_osDirtyFlag = false;
    private boolean col_mdDirtyFlag = false;
    private boolean col_md_osDirtyFlag = false;
    private boolean col_smDirtyFlag = false;
    private boolean col_sm_osDirtyFlag = false;
    private boolean col_xsDirtyFlag = false;
    private boolean col_xs_osDirtyFlag = false;
    private boolean contenttypeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dbparttypeDirtyFlag = false;
    private boolean dynaclassDirtyFlag = false;
    private boolean enableanchorDirtyFlag = false;
    private boolean flexalignDirtyFlag = false;
    private boolean flexbasisDirtyFlag = false;
    private boolean flexdirDirtyFlag = false;
    private boolean flexgrowDirtyFlag = false;
    private boolean flexshrinkDirtyFlag = false;
    private boolean flexvalignDirtyFlag = false;
    private boolean halignselfDirtyFlag = false;
    private boolean heightDirtyFlag = false;
    private boolean htmlcontentDirtyFlag = false;
    private boolean layoutmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean newrowmodeDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean partparamsDirtyFlag = false;
    private boolean partstyleDirtyFlag = false;
    private boolean portlettypeDirtyFlag = false;
    private boolean posinfoDirtyFlag = false;
    private boolean ppssysdbpartidDirtyFlag = false;
    private boolean ppssysdbpartnameDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysdashboardidDirtyFlag = false;
    private boolean pssysdashboardnameDirtyFlag = false;
    private boolean pssysdbpartidDirtyFlag = false;
    private boolean pssysdbpartnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysportletidDirtyFlag = false;
    private boolean pssysportletnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean rawcontentDirtyFlag = false;
    private boolean rawcssstyleDirtyFlag = false;
    private boolean showtitlebarDirtyFlag = false;
    private boolean swapmodeDirtyFlag = false;
    private boolean templatemodeDirtyFlag = false;
    private boolean titleDirtyFlag = false;
    private boolean titlebarclosemodeDirtyFlag = false;
    private boolean titlepslanresidDirtyFlag = false;
    private boolean titlepslanresnameDirtyFlag = false;
    private boolean tooltipinfoDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valignselfDirtyFlag = false;
    private boolean widthDirtyFlag = false;
    @Column(name="bl_pos")
    private String bl_pos;
    @Column(name="colid")
    private Integer colid;
    @Column(name="colspan")
    private Integer colspan;
    @Column(name="col_lg")
    private Integer col_lg;
    @Column(name="col_lg_os")
    private Integer col_lg_os;
    @Column(name="col_md")
    private Integer col_md;
    @Column(name="col_md_os")
    private Integer col_md_os;
    @Column(name="col_sm")
    private Integer col_sm;
    @Column(name="col_sm_os")
    private Integer col_sm_os;
    @Column(name="col_xs")
    private Integer col_xs;
    @Column(name="col_xs_os")
    private Integer col_xs_os;
    @Column(name="contenttype")
    private String contenttype;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dbparttype")
    private String dbparttype;
    @Column(name="dynaclass")
    private String dynaclass;
    @Column(name="enableanchor")
    private Integer enableanchor;
    @Column(name="flexalign")
    private String flexalign;
    @Column(name="flexbasis")
    private Integer flexbasis;
    @Column(name="flexdir")
    private String flexdir;
    @Column(name="flexgrow")
    private Integer flexgrow;
    @Column(name="flexshrink")
    private Integer flexshrink;
    @Column(name="flexvalign")
    private String flexvalign;
    @Column(name="halignself")
    private String halignself;
    @Column(name="height")
    private Integer height;
    @Column(name="htmlcontent")
    private String htmlcontent;
    @Column(name="layoutmode")
    private String layoutmode;
    @Column(name="memo")
    private String memo;
    @Column(name="newrowmode")
    private Integer newrowmode;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="partparams")
    private String partparams;
    @Column(name="partstyle")
    private String partstyle;
    @Column(name="portlettype")
    private String portlettype;
    @Column(name="posinfo")
    private String posinfo;
    @Column(name="ppssysdbpartid")
    private String ppssysdbpartid;
    @Column(name="ppssysdbpartname")
    private String ppssysdbpartname;
    @Column(name="pssyscssid")
    private String pssyscssid;
    @Column(name="pssyscssname")
    private String pssyscssname;
    @Column(name="pssysdashboardid")
    private String pssysdashboardid;
    @Column(name="pssysdashboardname")
    private String pssysdashboardname;
    @Column(name="pssysdbpartid")
    private String pssysdbpartid;
    @Column(name="pssysdbpartname")
    private String pssysdbpartname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysportletid")
    private String pssysportletid;
    @Column(name="pssysportletname")
    private String pssysportletname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="rawcontent")
    private String rawcontent;
    @Column(name="rawcssstyle")
    private String rawcssstyle;
    @Column(name="showtitlebar")
    private Integer showtitlebar;
    @Column(name="swapmode")
    private String swapmode;
    @Column(name="templatemode")
    private Integer templatemode;
    @Column(name="title")
    private String title;
    @Column(name="titlebarclosemode")
    private Integer titlebarclosemode;
    @Column(name="titlepslanresid")
    private String titlepslanresid;
    @Column(name="titlepslanresname")
    private String titlepslanresname;
    @Column(name="tooltipinfo")
    private String tooltipinfo;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="valignself")
    private String valignself;
    @Column(name="width")
    private Integer width;
    private Integer objTitlePSLanREsLock = new Integer(1);
    private PSLanguageRes titlepslanres = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysDashboardLock = new Integer(1);
    private PSSysDashboard pssysdashboard = null;
    private Integer objPPSSysDBPartLock = new Integer(1);
    private PSSysDBPart ppssysdbpart = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysPortletLock = new Integer(1);
    private PSSysPortlet pssysportlet = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;

    public void setBL_Pos(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBL_Pos(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bl_pos = string;
        this.bl_posDirtyFlag = true;
    }

    public String getBL_Pos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBL_Pos();
        }
        return this.bl_pos;
    }

    public boolean isBL_PosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBL_PosDirty();
        }
        return this.bl_posDirtyFlag;
    }

    public void resetBL_Pos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBL_Pos();
            return;
        }
        this.bl_posDirtyFlag = false;
        this.bl_pos = null;
    }

    public void setColId(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColId(n);
            return;
        }
        this.colid = n;
        this.colidDirtyFlag = true;
    }

    public Integer getColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColId();
        }
        return this.colid;
    }

    public boolean isColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColIdDirty();
        }
        return this.colidDirtyFlag;
    }

    public void resetColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColId();
            return;
        }
        this.colidDirtyFlag = false;
        this.colid = null;
    }

    public void setColSpan(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColSpan(n);
            return;
        }
        this.colspan = n;
        this.colspanDirtyFlag = true;
    }

    public Integer getColSpan() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColSpan();
        }
        return this.colspan;
    }

    public boolean isColSpanDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColSpanDirty();
        }
        return this.colspanDirtyFlag;
    }

    public void resetColSpan() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColSpan();
            return;
        }
        this.colspanDirtyFlag = false;
        this.colspan = null;
    }

    public void setCol_LG(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG(n);
            return;
        }
        this.col_lg = n;
        this.col_lgDirtyFlag = true;
    }

    public Integer getCol_LG() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG();
        }
        return this.col_lg;
    }

    public boolean isCol_LGDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LGDirty();
        }
        return this.col_lgDirtyFlag;
    }

    public void resetCol_LG() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG();
            return;
        }
        this.col_lgDirtyFlag = false;
        this.col_lg = null;
    }

    public void setCol_LG_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_LG_OS(n);
            return;
        }
        this.col_lg_os = n;
        this.col_lg_osDirtyFlag = true;
    }

    public Integer getCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_LG_OS();
        }
        return this.col_lg_os;
    }

    public boolean isCol_LG_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_LG_OSDirty();
        }
        return this.col_lg_osDirtyFlag;
    }

    public void resetCol_LG_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_LG_OS();
            return;
        }
        this.col_lg_osDirtyFlag = false;
        this.col_lg_os = null;
    }

    public void setCol_MD(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD(n);
            return;
        }
        this.col_md = n;
        this.col_mdDirtyFlag = true;
    }

    public Integer getCol_MD() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD();
        }
        return this.col_md;
    }

    public boolean isCol_MDDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MDDirty();
        }
        return this.col_mdDirtyFlag;
    }

    public void resetCol_MD() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD();
            return;
        }
        this.col_mdDirtyFlag = false;
        this.col_md = null;
    }

    public void setCol_MD_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_MD_OS(n);
            return;
        }
        this.col_md_os = n;
        this.col_md_osDirtyFlag = true;
    }

    public Integer getCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_MD_OS();
        }
        return this.col_md_os;
    }

    public boolean isCol_MD_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_MD_OSDirty();
        }
        return this.col_md_osDirtyFlag;
    }

    public void resetCol_MD_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_MD_OS();
            return;
        }
        this.col_md_osDirtyFlag = false;
        this.col_md_os = null;
    }

    public void setCol_SM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM(n);
            return;
        }
        this.col_sm = n;
        this.col_smDirtyFlag = true;
    }

    public Integer getCol_SM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM();
        }
        return this.col_sm;
    }

    public boolean isCol_SMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SMDirty();
        }
        return this.col_smDirtyFlag;
    }

    public void resetCol_SM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM();
            return;
        }
        this.col_smDirtyFlag = false;
        this.col_sm = null;
    }

    public void setCol_SM_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_SM_OS(n);
            return;
        }
        this.col_sm_os = n;
        this.col_sm_osDirtyFlag = true;
    }

    public Integer getCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_SM_OS();
        }
        return this.col_sm_os;
    }

    public boolean isCol_SM_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_SM_OSDirty();
        }
        return this.col_sm_osDirtyFlag;
    }

    public void resetCol_SM_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_SM_OS();
            return;
        }
        this.col_sm_osDirtyFlag = false;
        this.col_sm_os = null;
    }

    public void setCol_XS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS(n);
            return;
        }
        this.col_xs = n;
        this.col_xsDirtyFlag = true;
    }

    public Integer getCol_XS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS();
        }
        return this.col_xs;
    }

    public boolean isCol_XSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XSDirty();
        }
        return this.col_xsDirtyFlag;
    }

    public void resetCol_XS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS();
            return;
        }
        this.col_xsDirtyFlag = false;
        this.col_xs = null;
    }

    public void setCol_XS_OS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCol_XS_OS(n);
            return;
        }
        this.col_xs_os = n;
        this.col_xs_osDirtyFlag = true;
    }

    public Integer getCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCol_XS_OS();
        }
        return this.col_xs_os;
    }

    public boolean isCol_XS_OSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCol_XS_OSDirty();
        }
        return this.col_xs_osDirtyFlag;
    }

    public void resetCol_XS_OS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCol_XS_OS();
            return;
        }
        this.col_xs_osDirtyFlag = false;
        this.col_xs_os = null;
    }

    public void setContentType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContentType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.contenttype = string;
        this.contenttypeDirtyFlag = true;
    }

    public String getContentType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContentType();
        }
        return this.contenttype;
    }

    public boolean isContentTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentTypeDirty();
        }
        return this.contenttypeDirtyFlag;
    }

    public void resetContentType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContentType();
            return;
        }
        this.contenttypeDirtyFlag = false;
        this.contenttype = null;
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

    public void setDBPartType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDBPartType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dbparttype = string;
        this.dbparttypeDirtyFlag = true;
    }

    public String getDBPartType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDBPartType();
        }
        return this.dbparttype;
    }

    public boolean isDBPartTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDBPartTypeDirty();
        }
        return this.dbparttypeDirtyFlag;
    }

    public void resetDBPartType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDBPartType();
            return;
        }
        this.dbparttypeDirtyFlag = false;
        this.dbparttype = null;
    }

    public void setDynaClass(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaClass(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynaclass = string;
        this.dynaclassDirtyFlag = true;
    }

    public String getDynaClass() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaClass();
        }
        return this.dynaclass;
    }

    public boolean isDynaClassDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaClassDirty();
        }
        return this.dynaclassDirtyFlag;
    }

    public void resetDynaClass() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaClass();
            return;
        }
        this.dynaclassDirtyFlag = false;
        this.dynaclass = null;
    }

    public void setEnableAnchor(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableAnchor(n);
            return;
        }
        this.enableanchor = n;
        this.enableanchorDirtyFlag = true;
    }

    public Integer getEnableAnchor() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableAnchor();
        }
        return this.enableanchor;
    }

    public boolean isEnableAnchorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableAnchorDirty();
        }
        return this.enableanchorDirtyFlag;
    }

    public void resetEnableAnchor() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableAnchor();
            return;
        }
        this.enableanchorDirtyFlag = false;
        this.enableanchor = null;
    }

    public void setFlexAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexalign = string;
        this.flexalignDirtyFlag = true;
    }

    public String getFlexAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexAlign();
        }
        return this.flexalign;
    }

    public boolean isFlexAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexAlignDirty();
        }
        return this.flexalignDirtyFlag;
    }

    public void resetFlexAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexAlign();
            return;
        }
        this.flexalignDirtyFlag = false;
        this.flexalign = null;
    }

    public void setFlexBasis(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexBasis(n);
            return;
        }
        this.flexbasis = n;
        this.flexbasisDirtyFlag = true;
    }

    public Integer getFlexBasis() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexBasis();
        }
        return this.flexbasis;
    }

    public boolean isFlexBasisDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexBasisDirty();
        }
        return this.flexbasisDirtyFlag;
    }

    public void resetFlexBasis() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexBasis();
            return;
        }
        this.flexbasisDirtyFlag = false;
        this.flexbasis = null;
    }

    public void setFlexDir(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexDir(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexdir = string;
        this.flexdirDirtyFlag = true;
    }

    public String getFlexDir() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexDir();
        }
        return this.flexdir;
    }

    public boolean isFlexDirDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexDirDirty();
        }
        return this.flexdirDirtyFlag;
    }

    public void resetFlexDir() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexDir();
            return;
        }
        this.flexdirDirtyFlag = false;
        this.flexdir = null;
    }

    public void setFlexGrow(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexGrow(n);
            return;
        }
        this.flexgrow = n;
        this.flexgrowDirtyFlag = true;
    }

    public Integer getFlexGrow() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexGrow();
        }
        return this.flexgrow;
    }

    public boolean isFlexGrowDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexGrowDirty();
        }
        return this.flexgrowDirtyFlag;
    }

    public void resetFlexGrow() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexGrow();
            return;
        }
        this.flexgrowDirtyFlag = false;
        this.flexgrow = null;
    }

    public void setFlexShrink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexShrink(n);
            return;
        }
        this.flexshrink = n;
        this.flexshrinkDirtyFlag = true;
    }

    public Integer getFlexShrink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexShrink();
        }
        return this.flexshrink;
    }

    public boolean isFlexShrinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexShrinkDirty();
        }
        return this.flexshrinkDirtyFlag;
    }

    public void resetFlexShrink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexShrink();
            return;
        }
        this.flexshrinkDirtyFlag = false;
        this.flexshrink = null;
    }

    public void setFlexVAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFlexVAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.flexvalign = string;
        this.flexvalignDirtyFlag = true;
    }

    public String getFlexVAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFlexVAlign();
        }
        return this.flexvalign;
    }

    public boolean isFlexVAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFlexVAlignDirty();
        }
        return this.flexvalignDirtyFlag;
    }

    public void resetFlexVAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFlexVAlign();
            return;
        }
        this.flexvalignDirtyFlag = false;
        this.flexvalign = null;
    }

    public void setHAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.halignself = string;
        this.halignselfDirtyFlag = true;
    }

    public String getHAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHAlignSelf();
        }
        return this.halignself;
    }

    public boolean isHAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHAlignSelfDirty();
        }
        return this.halignselfDirtyFlag;
    }

    public void resetHAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHAlignSelf();
            return;
        }
        this.halignselfDirtyFlag = false;
        this.halignself = null;
    }

    public void setHeight(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeight(n);
            return;
        }
        this.height = n;
        this.heightDirtyFlag = true;
    }

    public Integer getHeight() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeight();
        }
        return this.height;
    }

    public boolean isHeightDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeightDirty();
        }
        return this.heightDirtyFlag;
    }

    public void resetHeight() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeight();
            return;
        }
        this.heightDirtyFlag = false;
        this.height = null;
    }

    public void setHtmlContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHtmlContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.htmlcontent = string;
        this.htmlcontentDirtyFlag = true;
    }

    public String getHtmlContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHtmlContent();
        }
        return this.htmlcontent;
    }

    public boolean isHtmlContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHtmlContentDirty();
        }
        return this.htmlcontentDirtyFlag;
    }

    public void resetHtmlContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHtmlContent();
            return;
        }
        this.htmlcontentDirtyFlag = false;
        this.htmlcontent = null;
    }

    public void setLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.layoutmode = string;
        this.layoutmodeDirtyFlag = true;
    }

    public String getLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLayoutMode();
        }
        return this.layoutmode;
    }

    public boolean isLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLayoutModeDirty();
        }
        return this.layoutmodeDirtyFlag;
    }

    public void resetLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLayoutMode();
            return;
        }
        this.layoutmodeDirtyFlag = false;
        this.layoutmode = null;
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

    public void setNewRowMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNewRowMode(n);
            return;
        }
        this.newrowmode = n;
        this.newrowmodeDirtyFlag = true;
    }

    public Integer getNewRowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNewRowMode();
        }
        return this.newrowmode;
    }

    public boolean isNewRowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNewRowModeDirty();
        }
        return this.newrowmodeDirtyFlag;
    }

    public void resetNewRowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNewRowMode();
            return;
        }
        this.newrowmodeDirtyFlag = false;
        this.newrowmode = null;
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

    public void setPartParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPartParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.partparams = string;
        this.partparamsDirtyFlag = true;
    }

    public String getPartParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPartParams();
        }
        return this.partparams;
    }

    public boolean isPartParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPartParamsDirty();
        }
        return this.partparamsDirtyFlag;
    }

    public void resetPartParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPartParams();
            return;
        }
        this.partparamsDirtyFlag = false;
        this.partparams = null;
    }

    public void setPartStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPartStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.partstyle = string;
        this.partstyleDirtyFlag = true;
    }

    public String getPartStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPartStyle();
        }
        return this.partstyle;
    }

    public boolean isPartStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPartStyleDirty();
        }
        return this.partstyleDirtyFlag;
    }

    public void resetPartStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPartStyle();
            return;
        }
        this.partstyleDirtyFlag = false;
        this.partstyle = null;
    }

    public void setPortletType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portlettype = string;
        this.portlettypeDirtyFlag = true;
    }

    public String getPortletType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletType();
        }
        return this.portlettype;
    }

    public boolean isPortletTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletTypeDirty();
        }
        return this.portlettypeDirtyFlag;
    }

    public void resetPortletType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletType();
            return;
        }
        this.portlettypeDirtyFlag = false;
        this.portlettype = null;
    }

    public void setPosInfo(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPosInfo(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.posinfo = string;
        this.posinfoDirtyFlag = true;
    }

    public String getPosInfo() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPosInfo();
        }
        return this.posinfo;
    }

    public boolean isPosInfoDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPosInfoDirty();
        }
        return this.posinfoDirtyFlag;
    }

    public void resetPosInfo() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPosInfo();
            return;
        }
        this.posinfoDirtyFlag = false;
        this.posinfo = null;
    }

    public void setPPSSysDBPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDBPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdbpartid = string;
        this.ppssysdbpartidDirtyFlag = true;
    }

    public String getPPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDBPartId();
        }
        return this.ppssysdbpartid;
    }

    public boolean isPPSSysDBPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDBPartIdDirty();
        }
        return this.ppssysdbpartidDirtyFlag;
    }

    public void resetPPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDBPartId();
            return;
        }
        this.ppssysdbpartidDirtyFlag = false;
        this.ppssysdbpartid = null;
    }

    public void setPPSSysDBPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSSysDBPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppssysdbpartname = string;
        this.ppssysdbpartnameDirtyFlag = true;
    }

    public String getPPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDBPartName();
        }
        return this.ppssysdbpartname;
    }

    public boolean isPPSSysDBPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSSysDBPartNameDirty();
        }
        return this.ppssysdbpartnameDirtyFlag;
    }

    public void resetPPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSSysDBPartName();
            return;
        }
        this.ppssysdbpartnameDirtyFlag = false;
        this.ppssysdbpartname = null;
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

    public void setPSSysDashboardId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardid = string;
        this.pssysdashboardidDirtyFlag = true;
    }

    public String getPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardId();
        }
        return this.pssysdashboardid;
    }

    public boolean isPSSysDashboardIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardIdDirty();
        }
        return this.pssysdashboardidDirtyFlag;
    }

    public void resetPSSysDashboardId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardId();
            return;
        }
        this.pssysdashboardidDirtyFlag = false;
        this.pssysdashboardid = null;
    }

    public void setPSSysDashboardName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDashboardName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdashboardname = string;
        this.pssysdashboardnameDirtyFlag = true;
    }

    public String getPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboardName();
        }
        return this.pssysdashboardname;
    }

    public boolean isPSSysDashboardNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDashboardNameDirty();
        }
        return this.pssysdashboardnameDirtyFlag;
    }

    public void resetPSSysDashboardName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDashboardName();
            return;
        }
        this.pssysdashboardnameDirtyFlag = false;
        this.pssysdashboardname = null;
    }

    public void setPSSysDBPartId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBPartId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbpartid = string;
        this.pssysdbpartidDirtyFlag = true;
    }

    public String getPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBPartId();
        }
        return this.pssysdbpartid;
    }

    public boolean isPSSysDBPartIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBPartIdDirty();
        }
        return this.pssysdbpartidDirtyFlag;
    }

    public void resetPSSysDBPartId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBPartId();
            return;
        }
        this.pssysdbpartidDirtyFlag = false;
        this.pssysdbpartid = null;
    }

    public void setPSSysDBPartName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDBPartName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdbpartname = string;
        this.pssysdbpartnameDirtyFlag = true;
    }

    public String getPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDBPartName();
        }
        return this.pssysdbpartname;
    }

    public boolean isPSSysDBPartNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDBPartNameDirty();
        }
        return this.pssysdbpartnameDirtyFlag;
    }

    public void resetPSSysDBPartName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDBPartName();
            return;
        }
        this.pssysdbpartnameDirtyFlag = false;
        this.pssysdbpartname = null;
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

    public void setPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginid = string;
        this.pssyspfpluginidDirtyFlag = true;
    }

    public String getPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginId();
        }
        return this.pssyspfpluginid;
    }

    public boolean isPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginIdDirty();
        }
        return this.pssyspfpluginidDirtyFlag;
    }

    public void resetPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginId();
            return;
        }
        this.pssyspfpluginidDirtyFlag = false;
        this.pssyspfpluginid = null;
    }

    public void setPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyspfpluginname = string;
        this.pssyspfpluginnameDirtyFlag = true;
    }

    public String getPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPluginName();
        }
        return this.pssyspfpluginname;
    }

    public boolean isPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPFPluginNameDirty();
        }
        return this.pssyspfpluginnameDirtyFlag;
    }

    public void resetPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPFPluginName();
            return;
        }
        this.pssyspfpluginnameDirtyFlag = false;
        this.pssyspfpluginname = null;
    }

    public void setPSSysPortletId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletid = string;
        this.pssysportletidDirtyFlag = true;
    }

    public String getPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletId();
        }
        return this.pssysportletid;
    }

    public boolean isPSSysPortletIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletIdDirty();
        }
        return this.pssysportletidDirtyFlag;
    }

    public void resetPSSysPortletId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletId();
            return;
        }
        this.pssysportletidDirtyFlag = false;
        this.pssysportletid = null;
    }

    public void setPSSysPortletName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysPortletName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysportletname = string;
        this.pssysportletnameDirtyFlag = true;
    }

    public String getPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortletName();
        }
        return this.pssysportletname;
    }

    public boolean isPSSysPortletNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysPortletNameDirty();
        }
        return this.pssysportletnameDirtyFlag;
    }

    public void resetPSSysPortletName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysPortletName();
            return;
        }
        this.pssysportletnameDirtyFlag = false;
        this.pssysportletname = null;
    }

    public void setPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourceid = string;
        this.pssysresourceidDirtyFlag = true;
    }

    public String getPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceId();
        }
        return this.pssysresourceid;
    }

    public boolean isPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceIdDirty();
        }
        return this.pssysresourceidDirtyFlag;
    }

    public void resetPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceId();
            return;
        }
        this.pssysresourceidDirtyFlag = false;
        this.pssysresourceid = null;
    }

    public void setPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysresourcename = string;
        this.pssysresourcenameDirtyFlag = true;
    }

    public String getPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResourceName();
        }
        return this.pssysresourcename;
    }

    public boolean isPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysResourceNameDirty();
        }
        return this.pssysresourcenameDirtyFlag;
    }

    public void resetPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysResourceName();
            return;
        }
        this.pssysresourcenameDirtyFlag = false;
        this.pssysresourcename = null;
    }

    public void setPSSysUniResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresid = string;
        this.pssysuniresidDirtyFlag = true;
    }

    public String getPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResId();
        }
        return this.pssysuniresid;
    }

    public boolean isPSSysUniResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResIdDirty();
        }
        return this.pssysuniresidDirtyFlag;
    }

    public void resetPSSysUniResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResId();
            return;
        }
        this.pssysuniresidDirtyFlag = false;
        this.pssysuniresid = null;
    }

    public void setPSSysUniResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUniResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysuniresname = string;
        this.pssysuniresnameDirtyFlag = true;
    }

    public String getPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniResName();
        }
        return this.pssysuniresname;
    }

    public boolean isPSSysUniResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUniResNameDirty();
        }
        return this.pssysuniresnameDirtyFlag;
    }

    public void resetPSSysUniResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUniResName();
            return;
        }
        this.pssysuniresnameDirtyFlag = false;
        this.pssysuniresname = null;
    }

    public void setRawContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcontent = string;
        this.rawcontentDirtyFlag = true;
    }

    public String getRawContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawContent();
        }
        return this.rawcontent;
    }

    public boolean isRawContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawContentDirty();
        }
        return this.rawcontentDirtyFlag;
    }

    public void resetRawContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawContent();
            return;
        }
        this.rawcontentDirtyFlag = false;
        this.rawcontent = null;
    }

    public void setRawCssStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRawCssStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rawcssstyle = string;
        this.rawcssstyleDirtyFlag = true;
    }

    public String getRawCssStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRawCssStyle();
        }
        return this.rawcssstyle;
    }

    public boolean isRawCssStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRawCssStyleDirty();
        }
        return this.rawcssstyleDirtyFlag;
    }

    public void resetRawCssStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRawCssStyle();
            return;
        }
        this.rawcssstyleDirtyFlag = false;
        this.rawcssstyle = null;
    }

    public void setShowTitleBar(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowTitleBar(n);
            return;
        }
        this.showtitlebar = n;
        this.showtitlebarDirtyFlag = true;
    }

    public Integer getShowTitleBar() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowTitleBar();
        }
        return this.showtitlebar;
    }

    public boolean isShowTitleBarDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowTitleBarDirty();
        }
        return this.showtitlebarDirtyFlag;
    }

    public void resetShowTitleBar() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowTitleBar();
            return;
        }
        this.showtitlebarDirtyFlag = false;
        this.showtitlebar = null;
    }

    public void setSwapMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setSwapMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.swapmode = string;
        this.swapmodeDirtyFlag = true;
    }

    public String getSwapMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getSwapMode();
        }
        return this.swapmode;
    }

    public boolean isSwapModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isSwapModeDirty();
        }
        return this.swapmodeDirtyFlag;
    }

    public void resetSwapMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetSwapMode();
            return;
        }
        this.swapmodeDirtyFlag = false;
        this.swapmode = null;
    }

    public void setTemplateMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTemplateMode(n);
            return;
        }
        this.templatemode = n;
        this.templatemodeDirtyFlag = true;
    }

    public Integer getTemplateMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTemplateMode();
        }
        return this.templatemode;
    }

    public boolean isTemplateModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTemplateModeDirty();
        }
        return this.templatemodeDirtyFlag;
    }

    public void resetTemplateMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTemplateMode();
            return;
        }
        this.templatemodeDirtyFlag = false;
        this.templatemode = null;
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

    public void setTitleBarCloseMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitleBarCloseMode(n);
            return;
        }
        this.titlebarclosemode = n;
        this.titlebarclosemodeDirtyFlag = true;
    }

    public Integer getTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitleBarCloseMode();
        }
        return this.titlebarclosemode;
    }

    public boolean isTitleBarCloseModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitleBarCloseModeDirty();
        }
        return this.titlebarclosemodeDirtyFlag;
    }

    public void resetTitleBarCloseMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitleBarCloseMode();
            return;
        }
        this.titlebarclosemodeDirtyFlag = false;
        this.titlebarclosemode = null;
    }

    public void setTitlePSLanResId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresid = string;
        this.titlepslanresidDirtyFlag = true;
    }

    public String getTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResId();
        }
        return this.titlepslanresid;
    }

    public boolean isTitlePSLanResIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResIdDirty();
        }
        return this.titlepslanresidDirtyFlag;
    }

    public void resetTitlePSLanResId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResId();
            return;
        }
        this.titlepslanresidDirtyFlag = false;
        this.titlepslanresid = null;
    }

    public void setTitlePSLanResName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTitlePSLanResName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.titlepslanresname = string;
        this.titlepslanresnameDirtyFlag = true;
    }

    public String getTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanResName();
        }
        return this.titlepslanresname;
    }

    public boolean isTitlePSLanResNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTitlePSLanResNameDirty();
        }
        return this.titlepslanresnameDirtyFlag;
    }

    public void resetTitlePSLanResName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTitlePSLanResName();
            return;
        }
        this.titlepslanresnameDirtyFlag = false;
        this.titlepslanresname = null;
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

    public void setVAlignSelf(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVAlignSelf(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valignself = string;
        this.valignselfDirtyFlag = true;
    }

    public String getVAlignSelf() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVAlignSelf();
        }
        return this.valignself;
    }

    public boolean isVAlignSelfDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVAlignSelfDirty();
        }
        return this.valignselfDirtyFlag;
    }

    public void resetVAlignSelf() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVAlignSelf();
            return;
        }
        this.valignselfDirtyFlag = false;
        this.valignself = null;
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

    protected void onReset() {
        PSSysDBPartBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysDBPartBase pSSysDBPartBase) {
        pSSysDBPartBase.resetBL_Pos();
        pSSysDBPartBase.resetColId();
        pSSysDBPartBase.resetColSpan();
        pSSysDBPartBase.resetCol_LG();
        pSSysDBPartBase.resetCol_LG_OS();
        pSSysDBPartBase.resetCol_MD();
        pSSysDBPartBase.resetCol_MD_OS();
        pSSysDBPartBase.resetCol_SM();
        pSSysDBPartBase.resetCol_SM_OS();
        pSSysDBPartBase.resetCol_XS();
        pSSysDBPartBase.resetCol_XS_OS();
        pSSysDBPartBase.resetContentType();
        pSSysDBPartBase.resetCreateDate();
        pSSysDBPartBase.resetCreateMan();
        pSSysDBPartBase.resetDBPartType();
        pSSysDBPartBase.resetDynaClass();
        pSSysDBPartBase.resetEnableAnchor();
        pSSysDBPartBase.resetFlexAlign();
        pSSysDBPartBase.resetFlexBasis();
        pSSysDBPartBase.resetFlexDir();
        pSSysDBPartBase.resetFlexGrow();
        pSSysDBPartBase.resetFlexShrink();
        pSSysDBPartBase.resetFlexVAlign();
        pSSysDBPartBase.resetHAlignSelf();
        pSSysDBPartBase.resetHeight();
        pSSysDBPartBase.resetHtmlContent();
        pSSysDBPartBase.resetLayoutMode();
        pSSysDBPartBase.resetMemo();
        pSSysDBPartBase.resetNewRowMode();
        pSSysDBPartBase.resetOrderValue();
        pSSysDBPartBase.resetPartParams();
        pSSysDBPartBase.resetPartStyle();
        pSSysDBPartBase.resetPortletType();
        pSSysDBPartBase.resetPosInfo();
        pSSysDBPartBase.resetPPSSysDBPartId();
        pSSysDBPartBase.resetPPSSysDBPartName();
        pSSysDBPartBase.resetPSSysCssId();
        pSSysDBPartBase.resetPSSysCssName();
        pSSysDBPartBase.resetPSSysDashboardId();
        pSSysDBPartBase.resetPSSysDashboardName();
        pSSysDBPartBase.resetPSSysDBPartId();
        pSSysDBPartBase.resetPSSysDBPartName();
        pSSysDBPartBase.resetPSSysImageId();
        pSSysDBPartBase.resetPSSysImageName();
        pSSysDBPartBase.resetPSSysPFPluginId();
        pSSysDBPartBase.resetPSSysPFPluginName();
        pSSysDBPartBase.resetPSSysPortletId();
        pSSysDBPartBase.resetPSSysPortletName();
        pSSysDBPartBase.resetPSSysResourceId();
        pSSysDBPartBase.resetPSSysResourceName();
        pSSysDBPartBase.resetPSSysUniResId();
        pSSysDBPartBase.resetPSSysUniResName();
        pSSysDBPartBase.resetRawContent();
        pSSysDBPartBase.resetRawCssStyle();
        pSSysDBPartBase.resetShowTitleBar();
        pSSysDBPartBase.resetSwapMode();
        pSSysDBPartBase.resetTemplateMode();
        pSSysDBPartBase.resetTitle();
        pSSysDBPartBase.resetTitleBarCloseMode();
        pSSysDBPartBase.resetTitlePSLanResId();
        pSSysDBPartBase.resetTitlePSLanResName();
        pSSysDBPartBase.resetTooltipInfo();
        pSSysDBPartBase.resetUpdateDate();
        pSSysDBPartBase.resetUpdateMan();
        pSSysDBPartBase.resetUserTag();
        pSSysDBPartBase.resetUserTag2();
        pSSysDBPartBase.resetValidFlag();
        pSSysDBPartBase.resetVAlignSelf();
        pSSysDBPartBase.resetWidth();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBL_PosDirty()) {
            hashMap.put(FIELD_BL_POS, this.getBL_Pos());
        }
        if (!bl || this.isColIdDirty()) {
            hashMap.put(FIELD_COLID, this.getColId());
        }
        if (!bl || this.isColSpanDirty()) {
            hashMap.put(FIELD_COLSPAN, this.getColSpan());
        }
        if (!bl || this.isCol_LGDirty()) {
            hashMap.put(FIELD_COL_LG, this.getCol_LG());
        }
        if (!bl || this.isCol_LG_OSDirty()) {
            hashMap.put(FIELD_COL_LG_OS, this.getCol_LG_OS());
        }
        if (!bl || this.isCol_MDDirty()) {
            hashMap.put(FIELD_COL_MD, this.getCol_MD());
        }
        if (!bl || this.isCol_MD_OSDirty()) {
            hashMap.put(FIELD_COL_MD_OS, this.getCol_MD_OS());
        }
        if (!bl || this.isCol_SMDirty()) {
            hashMap.put(FIELD_COL_SM, this.getCol_SM());
        }
        if (!bl || this.isCol_SM_OSDirty()) {
            hashMap.put(FIELD_COL_SM_OS, this.getCol_SM_OS());
        }
        if (!bl || this.isCol_XSDirty()) {
            hashMap.put(FIELD_COL_XS, this.getCol_XS());
        }
        if (!bl || this.isCol_XS_OSDirty()) {
            hashMap.put(FIELD_COL_XS_OS, this.getCol_XS_OS());
        }
        if (!bl || this.isContentTypeDirty()) {
            hashMap.put(FIELD_CONTENTTYPE, this.getContentType());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDBPartTypeDirty()) {
            hashMap.put(FIELD_DBPARTTYPE, this.getDBPartType());
        }
        if (!bl || this.isDynaClassDirty()) {
            hashMap.put(FIELD_DYNACLASS, this.getDynaClass());
        }
        if (!bl || this.isEnableAnchorDirty()) {
            hashMap.put(FIELD_ENABLEANCHOR, this.getEnableAnchor());
        }
        if (!bl || this.isFlexAlignDirty()) {
            hashMap.put(FIELD_FLEXALIGN, this.getFlexAlign());
        }
        if (!bl || this.isFlexBasisDirty()) {
            hashMap.put(FIELD_FLEXBASIS, this.getFlexBasis());
        }
        if (!bl || this.isFlexDirDirty()) {
            hashMap.put(FIELD_FLEXDIR, this.getFlexDir());
        }
        if (!bl || this.isFlexGrowDirty()) {
            hashMap.put(FIELD_FLEXGROW, this.getFlexGrow());
        }
        if (!bl || this.isFlexShrinkDirty()) {
            hashMap.put(FIELD_FLEXSHRINK, this.getFlexShrink());
        }
        if (!bl || this.isFlexVAlignDirty()) {
            hashMap.put(FIELD_FLEXVALIGN, this.getFlexVAlign());
        }
        if (!bl || this.isHAlignSelfDirty()) {
            hashMap.put(FIELD_HALIGNSELF, this.getHAlignSelf());
        }
        if (!bl || this.isHeightDirty()) {
            hashMap.put(FIELD_HEIGHT, this.getHeight());
        }
        if (!bl || this.isHtmlContentDirty()) {
            hashMap.put(FIELD_HTMLCONTENT, this.getHtmlContent());
        }
        if (!bl || this.isLayoutModeDirty()) {
            hashMap.put(FIELD_LAYOUTMODE, this.getLayoutMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNewRowModeDirty()) {
            hashMap.put(FIELD_NEWROWMODE, this.getNewRowMode());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPartParamsDirty()) {
            hashMap.put(FIELD_PARTPARAMS, this.getPartParams());
        }
        if (!bl || this.isPartStyleDirty()) {
            hashMap.put(FIELD_PARTSTYLE, this.getPartStyle());
        }
        if (!bl || this.isPortletTypeDirty()) {
            hashMap.put(FIELD_PORTLETTYPE, this.getPortletType());
        }
        if (!bl || this.isPosInfoDirty()) {
            hashMap.put(FIELD_POSINFO, this.getPosInfo());
        }
        if (!bl || this.isPPSSysDBPartIdDirty()) {
            hashMap.put(FIELD_PPSSYSDBPARTID, this.getPPSSysDBPartId());
        }
        if (!bl || this.isPPSSysDBPartNameDirty()) {
            hashMap.put(FIELD_PPSSYSDBPARTNAME, this.getPPSSysDBPartName());
        }
        if (!bl || this.isPSSysCssIdDirty()) {
            hashMap.put(FIELD_PSSYSCSSID, this.getPSSysCssId());
        }
        if (!bl || this.isPSSysCssNameDirty()) {
            hashMap.put(FIELD_PSSYSCSSNAME, this.getPSSysCssName());
        }
        if (!bl || this.isPSSysDashboardIdDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDID, this.getPSSysDashboardId());
        }
        if (!bl || this.isPSSysDashboardNameDirty()) {
            hashMap.put(FIELD_PSSYSDASHBOARDNAME, this.getPSSysDashboardName());
        }
        if (!bl || this.isPSSysDBPartIdDirty()) {
            hashMap.put(FIELD_PSSYSDBPARTID, this.getPSSysDBPartId());
        }
        if (!bl || this.isPSSysDBPartNameDirty()) {
            hashMap.put(FIELD_PSSYSDBPARTNAME, this.getPSSysDBPartName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysPortletIdDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETID, this.getPSSysPortletId());
        }
        if (!bl || this.isPSSysPortletNameDirty()) {
            hashMap.put(FIELD_PSSYSPORTLETNAME, this.getPSSysPortletName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isRawContentDirty()) {
            hashMap.put(FIELD_RAWCONTENT, this.getRawContent());
        }
        if (!bl || this.isRawCssStyleDirty()) {
            hashMap.put(FIELD_RAWCSSSTYLE, this.getRawCssStyle());
        }
        if (!bl || this.isShowTitleBarDirty()) {
            hashMap.put(FIELD_SHOWTITLEBAR, this.getShowTitleBar());
        }
        if (!bl || this.isSwapModeDirty()) {
            hashMap.put(FIELD_SWAPMODE, this.getSwapMode());
        }
        if (!bl || this.isTemplateModeDirty()) {
            hashMap.put(FIELD_TEMPLATEMODE, this.getTemplateMode());
        }
        if (!bl || this.isTitleDirty()) {
            hashMap.put(FIELD_TITLE, this.getTitle());
        }
        if (!bl || this.isTitleBarCloseModeDirty()) {
            hashMap.put(FIELD_TITLEBARCLOSEMODE, this.getTitleBarCloseMode());
        }
        if (!bl || this.isTitlePSLanResIdDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESID, this.getTitlePSLanResId());
        }
        if (!bl || this.isTitlePSLanResNameDirty()) {
            hashMap.put(FIELD_TITLEPSLANRESNAME, this.getTitlePSLanResName());
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
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isVAlignSelfDirty()) {
            hashMap.put(FIELD_VALIGNSELF, this.getVAlignSelf());
        }
        if (!bl || this.isWidthDirty()) {
            hashMap.put(FIELD_WIDTH, this.getWidth());
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
        return PSSysDBPartBase.get(this, n);
    }

    private static Object get(PSSysDBPartBase pSSysDBPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBPartBase.getBL_Pos();
            }
            case 1: {
                return pSSysDBPartBase.getColId();
            }
            case 2: {
                return pSSysDBPartBase.getColSpan();
            }
            case 3: {
                return pSSysDBPartBase.getCol_LG();
            }
            case 4: {
                return pSSysDBPartBase.getCol_LG_OS();
            }
            case 5: {
                return pSSysDBPartBase.getCol_MD();
            }
            case 6: {
                return pSSysDBPartBase.getCol_MD_OS();
            }
            case 7: {
                return pSSysDBPartBase.getCol_SM();
            }
            case 8: {
                return pSSysDBPartBase.getCol_SM_OS();
            }
            case 9: {
                return pSSysDBPartBase.getCol_XS();
            }
            case 10: {
                return pSSysDBPartBase.getCol_XS_OS();
            }
            case 11: {
                return pSSysDBPartBase.getContentType();
            }
            case 12: {
                return pSSysDBPartBase.getCreateDate();
            }
            case 13: {
                return pSSysDBPartBase.getCreateMan();
            }
            case 14: {
                return pSSysDBPartBase.getDBPartType();
            }
            case 15: {
                return pSSysDBPartBase.getDynaClass();
            }
            case 16: {
                return pSSysDBPartBase.getEnableAnchor();
            }
            case 17: {
                return pSSysDBPartBase.getFlexAlign();
            }
            case 18: {
                return pSSysDBPartBase.getFlexBasis();
            }
            case 19: {
                return pSSysDBPartBase.getFlexDir();
            }
            case 20: {
                return pSSysDBPartBase.getFlexGrow();
            }
            case 21: {
                return pSSysDBPartBase.getFlexShrink();
            }
            case 22: {
                return pSSysDBPartBase.getFlexVAlign();
            }
            case 23: {
                return pSSysDBPartBase.getHAlignSelf();
            }
            case 24: {
                return pSSysDBPartBase.getHeight();
            }
            case 25: {
                return pSSysDBPartBase.getHtmlContent();
            }
            case 26: {
                return pSSysDBPartBase.getLayoutMode();
            }
            case 27: {
                return pSSysDBPartBase.getMemo();
            }
            case 28: {
                return pSSysDBPartBase.getNewRowMode();
            }
            case 29: {
                return pSSysDBPartBase.getOrderValue();
            }
            case 30: {
                return pSSysDBPartBase.getPartParams();
            }
            case 31: {
                return pSSysDBPartBase.getPartStyle();
            }
            case 32: {
                return pSSysDBPartBase.getPortletType();
            }
            case 33: {
                return pSSysDBPartBase.getPosInfo();
            }
            case 34: {
                return pSSysDBPartBase.getPPSSysDBPartId();
            }
            case 35: {
                return pSSysDBPartBase.getPPSSysDBPartName();
            }
            case 36: {
                return pSSysDBPartBase.getPSSysCssId();
            }
            case 37: {
                return pSSysDBPartBase.getPSSysCssName();
            }
            case 38: {
                return pSSysDBPartBase.getPSSysDashboardId();
            }
            case 39: {
                return pSSysDBPartBase.getPSSysDashboardName();
            }
            case 40: {
                return pSSysDBPartBase.getPSSysDBPartId();
            }
            case 41: {
                return pSSysDBPartBase.getPSSysDBPartName();
            }
            case 42: {
                return pSSysDBPartBase.getPSSysImageId();
            }
            case 43: {
                return pSSysDBPartBase.getPSSysImageName();
            }
            case 44: {
                return pSSysDBPartBase.getPSSysPFPluginId();
            }
            case 45: {
                return pSSysDBPartBase.getPSSysPFPluginName();
            }
            case 46: {
                return pSSysDBPartBase.getPSSysPortletId();
            }
            case 47: {
                return pSSysDBPartBase.getPSSysPortletName();
            }
            case 48: {
                return pSSysDBPartBase.getPSSysResourceId();
            }
            case 49: {
                return pSSysDBPartBase.getPSSysResourceName();
            }
            case 50: {
                return pSSysDBPartBase.getPSSysUniResId();
            }
            case 51: {
                return pSSysDBPartBase.getPSSysUniResName();
            }
            case 52: {
                return pSSysDBPartBase.getRawContent();
            }
            case 53: {
                return pSSysDBPartBase.getRawCssStyle();
            }
            case 54: {
                return pSSysDBPartBase.getShowTitleBar();
            }
            case 55: {
                return pSSysDBPartBase.getSwapMode();
            }
            case 56: {
                return pSSysDBPartBase.getTemplateMode();
            }
            case 57: {
                return pSSysDBPartBase.getTitle();
            }
            case 58: {
                return pSSysDBPartBase.getTitleBarCloseMode();
            }
            case 59: {
                return pSSysDBPartBase.getTitlePSLanResId();
            }
            case 60: {
                return pSSysDBPartBase.getTitlePSLanResName();
            }
            case 61: {
                return pSSysDBPartBase.getTooltipInfo();
            }
            case 62: {
                return pSSysDBPartBase.getUpdateDate();
            }
            case 63: {
                return pSSysDBPartBase.getUpdateMan();
            }
            case 64: {
                return pSSysDBPartBase.getUserTag();
            }
            case 65: {
                return pSSysDBPartBase.getUserTag2();
            }
            case 66: {
                return pSSysDBPartBase.getValidFlag();
            }
            case 67: {
                return pSSysDBPartBase.getVAlignSelf();
            }
            case 68: {
                return pSSysDBPartBase.getWidth();
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
        PSSysDBPartBase.set(this, n, object);
    }

    private static void set(PSSysDBPartBase pSSysDBPartBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBPartBase.setBL_Pos(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysDBPartBase.setColId(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSSysDBPartBase.setColSpan(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysDBPartBase.setCol_LG(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSSysDBPartBase.setCol_LG_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSSysDBPartBase.setCol_MD(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSSysDBPartBase.setCol_MD_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSSysDBPartBase.setCol_SM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 8: {
                pSSysDBPartBase.setCol_SM_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysDBPartBase.setCol_XS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSSysDBPartBase.setCol_XS_OS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSSysDBPartBase.setContentType(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysDBPartBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysDBPartBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysDBPartBase.setDBPartType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysDBPartBase.setDynaClass(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysDBPartBase.setEnableAnchor(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 17: {
                pSSysDBPartBase.setFlexAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysDBPartBase.setFlexBasis(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 19: {
                pSSysDBPartBase.setFlexDir(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysDBPartBase.setFlexGrow(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSSysDBPartBase.setFlexShrink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSSysDBPartBase.setFlexVAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysDBPartBase.setHAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysDBPartBase.setHeight(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSSysDBPartBase.setHtmlContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysDBPartBase.setLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysDBPartBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysDBPartBase.setNewRowMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 29: {
                pSSysDBPartBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 30: {
                pSSysDBPartBase.setPartParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysDBPartBase.setPartStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysDBPartBase.setPortletType(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysDBPartBase.setPosInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysDBPartBase.setPPSSysDBPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysDBPartBase.setPPSSysDBPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysDBPartBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysDBPartBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysDBPartBase.setPSSysDashboardId(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysDBPartBase.setPSSysDashboardName(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysDBPartBase.setPSSysDBPartId(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSSysDBPartBase.setPSSysDBPartName(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSSysDBPartBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSSysDBPartBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSSysDBPartBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 45: {
                pSSysDBPartBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSSysDBPartBase.setPSSysPortletId(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSSysDBPartBase.setPSSysPortletName(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSSysDBPartBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSSysDBPartBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSSysDBPartBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSSysDBPartBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 52: {
                pSSysDBPartBase.setRawContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 53: {
                pSSysDBPartBase.setRawCssStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 54: {
                pSSysDBPartBase.setShowTitleBar(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 55: {
                pSSysDBPartBase.setSwapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 56: {
                pSSysDBPartBase.setTemplateMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 57: {
                pSSysDBPartBase.setTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 58: {
                pSSysDBPartBase.setTitleBarCloseMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 59: {
                pSSysDBPartBase.setTitlePSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 60: {
                pSSysDBPartBase.setTitlePSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 61: {
                pSSysDBPartBase.setTooltipInfo(DataObject.getStringValue((Object)object));
                return;
            }
            case 62: {
                pSSysDBPartBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 63: {
                pSSysDBPartBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 64: {
                pSSysDBPartBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 65: {
                pSSysDBPartBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 66: {
                pSSysDBPartBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 67: {
                pSSysDBPartBase.setVAlignSelf(DataObject.getStringValue((Object)object));
                return;
            }
            case 68: {
                pSSysDBPartBase.setWidth(DataObject.getIntegerValue((Object)object));
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
        return PSSysDBPartBase.isNull(this, n);
    }

    private static boolean isNull(PSSysDBPartBase pSSysDBPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBPartBase.getBL_Pos() == null;
            }
            case 1: {
                return pSSysDBPartBase.getColId() == null;
            }
            case 2: {
                return pSSysDBPartBase.getColSpan() == null;
            }
            case 3: {
                return pSSysDBPartBase.getCol_LG() == null;
            }
            case 4: {
                return pSSysDBPartBase.getCol_LG_OS() == null;
            }
            case 5: {
                return pSSysDBPartBase.getCol_MD() == null;
            }
            case 6: {
                return pSSysDBPartBase.getCol_MD_OS() == null;
            }
            case 7: {
                return pSSysDBPartBase.getCol_SM() == null;
            }
            case 8: {
                return pSSysDBPartBase.getCol_SM_OS() == null;
            }
            case 9: {
                return pSSysDBPartBase.getCol_XS() == null;
            }
            case 10: {
                return pSSysDBPartBase.getCol_XS_OS() == null;
            }
            case 11: {
                return pSSysDBPartBase.getContentType() == null;
            }
            case 12: {
                return pSSysDBPartBase.getCreateDate() == null;
            }
            case 13: {
                return pSSysDBPartBase.getCreateMan() == null;
            }
            case 14: {
                return pSSysDBPartBase.getDBPartType() == null;
            }
            case 15: {
                return pSSysDBPartBase.getDynaClass() == null;
            }
            case 16: {
                return pSSysDBPartBase.getEnableAnchor() == null;
            }
            case 17: {
                return pSSysDBPartBase.getFlexAlign() == null;
            }
            case 18: {
                return pSSysDBPartBase.getFlexBasis() == null;
            }
            case 19: {
                return pSSysDBPartBase.getFlexDir() == null;
            }
            case 20: {
                return pSSysDBPartBase.getFlexGrow() == null;
            }
            case 21: {
                return pSSysDBPartBase.getFlexShrink() == null;
            }
            case 22: {
                return pSSysDBPartBase.getFlexVAlign() == null;
            }
            case 23: {
                return pSSysDBPartBase.getHAlignSelf() == null;
            }
            case 24: {
                return pSSysDBPartBase.getHeight() == null;
            }
            case 25: {
                return pSSysDBPartBase.getHtmlContent() == null;
            }
            case 26: {
                return pSSysDBPartBase.getLayoutMode() == null;
            }
            case 27: {
                return pSSysDBPartBase.getMemo() == null;
            }
            case 28: {
                return pSSysDBPartBase.getNewRowMode() == null;
            }
            case 29: {
                return pSSysDBPartBase.getOrderValue() == null;
            }
            case 30: {
                return pSSysDBPartBase.getPartParams() == null;
            }
            case 31: {
                return pSSysDBPartBase.getPartStyle() == null;
            }
            case 32: {
                return pSSysDBPartBase.getPortletType() == null;
            }
            case 33: {
                return pSSysDBPartBase.getPosInfo() == null;
            }
            case 34: {
                return pSSysDBPartBase.getPPSSysDBPartId() == null;
            }
            case 35: {
                return pSSysDBPartBase.getPPSSysDBPartName() == null;
            }
            case 36: {
                return pSSysDBPartBase.getPSSysCssId() == null;
            }
            case 37: {
                return pSSysDBPartBase.getPSSysCssName() == null;
            }
            case 38: {
                return pSSysDBPartBase.getPSSysDashboardId() == null;
            }
            case 39: {
                return pSSysDBPartBase.getPSSysDashboardName() == null;
            }
            case 40: {
                return pSSysDBPartBase.getPSSysDBPartId() == null;
            }
            case 41: {
                return pSSysDBPartBase.getPSSysDBPartName() == null;
            }
            case 42: {
                return pSSysDBPartBase.getPSSysImageId() == null;
            }
            case 43: {
                return pSSysDBPartBase.getPSSysImageName() == null;
            }
            case 44: {
                return pSSysDBPartBase.getPSSysPFPluginId() == null;
            }
            case 45: {
                return pSSysDBPartBase.getPSSysPFPluginName() == null;
            }
            case 46: {
                return pSSysDBPartBase.getPSSysPortletId() == null;
            }
            case 47: {
                return pSSysDBPartBase.getPSSysPortletName() == null;
            }
            case 48: {
                return pSSysDBPartBase.getPSSysResourceId() == null;
            }
            case 49: {
                return pSSysDBPartBase.getPSSysResourceName() == null;
            }
            case 50: {
                return pSSysDBPartBase.getPSSysUniResId() == null;
            }
            case 51: {
                return pSSysDBPartBase.getPSSysUniResName() == null;
            }
            case 52: {
                return pSSysDBPartBase.getRawContent() == null;
            }
            case 53: {
                return pSSysDBPartBase.getRawCssStyle() == null;
            }
            case 54: {
                return pSSysDBPartBase.getShowTitleBar() == null;
            }
            case 55: {
                return pSSysDBPartBase.getSwapMode() == null;
            }
            case 56: {
                return pSSysDBPartBase.getTemplateMode() == null;
            }
            case 57: {
                return pSSysDBPartBase.getTitle() == null;
            }
            case 58: {
                return pSSysDBPartBase.getTitleBarCloseMode() == null;
            }
            case 59: {
                return pSSysDBPartBase.getTitlePSLanResId() == null;
            }
            case 60: {
                return pSSysDBPartBase.getTitlePSLanResName() == null;
            }
            case 61: {
                return pSSysDBPartBase.getTooltipInfo() == null;
            }
            case 62: {
                return pSSysDBPartBase.getUpdateDate() == null;
            }
            case 63: {
                return pSSysDBPartBase.getUpdateMan() == null;
            }
            case 64: {
                return pSSysDBPartBase.getUserTag() == null;
            }
            case 65: {
                return pSSysDBPartBase.getUserTag2() == null;
            }
            case 66: {
                return pSSysDBPartBase.getValidFlag() == null;
            }
            case 67: {
                return pSSysDBPartBase.getVAlignSelf() == null;
            }
            case 68: {
                return pSSysDBPartBase.getWidth() == null;
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
        return PSSysDBPartBase.contains(this, n);
    }

    private static boolean contains(PSSysDBPartBase pSSysDBPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysDBPartBase.isBL_PosDirty();
            }
            case 1: {
                return pSSysDBPartBase.isColIdDirty();
            }
            case 2: {
                return pSSysDBPartBase.isColSpanDirty();
            }
            case 3: {
                return pSSysDBPartBase.isCol_LGDirty();
            }
            case 4: {
                return pSSysDBPartBase.isCol_LG_OSDirty();
            }
            case 5: {
                return pSSysDBPartBase.isCol_MDDirty();
            }
            case 6: {
                return pSSysDBPartBase.isCol_MD_OSDirty();
            }
            case 7: {
                return pSSysDBPartBase.isCol_SMDirty();
            }
            case 8: {
                return pSSysDBPartBase.isCol_SM_OSDirty();
            }
            case 9: {
                return pSSysDBPartBase.isCol_XSDirty();
            }
            case 10: {
                return pSSysDBPartBase.isCol_XS_OSDirty();
            }
            case 11: {
                return pSSysDBPartBase.isContentTypeDirty();
            }
            case 12: {
                return pSSysDBPartBase.isCreateDateDirty();
            }
            case 13: {
                return pSSysDBPartBase.isCreateManDirty();
            }
            case 14: {
                return pSSysDBPartBase.isDBPartTypeDirty();
            }
            case 15: {
                return pSSysDBPartBase.isDynaClassDirty();
            }
            case 16: {
                return pSSysDBPartBase.isEnableAnchorDirty();
            }
            case 17: {
                return pSSysDBPartBase.isFlexAlignDirty();
            }
            case 18: {
                return pSSysDBPartBase.isFlexBasisDirty();
            }
            case 19: {
                return pSSysDBPartBase.isFlexDirDirty();
            }
            case 20: {
                return pSSysDBPartBase.isFlexGrowDirty();
            }
            case 21: {
                return pSSysDBPartBase.isFlexShrinkDirty();
            }
            case 22: {
                return pSSysDBPartBase.isFlexVAlignDirty();
            }
            case 23: {
                return pSSysDBPartBase.isHAlignSelfDirty();
            }
            case 24: {
                return pSSysDBPartBase.isHeightDirty();
            }
            case 25: {
                return pSSysDBPartBase.isHtmlContentDirty();
            }
            case 26: {
                return pSSysDBPartBase.isLayoutModeDirty();
            }
            case 27: {
                return pSSysDBPartBase.isMemoDirty();
            }
            case 28: {
                return pSSysDBPartBase.isNewRowModeDirty();
            }
            case 29: {
                return pSSysDBPartBase.isOrderValueDirty();
            }
            case 30: {
                return pSSysDBPartBase.isPartParamsDirty();
            }
            case 31: {
                return pSSysDBPartBase.isPartStyleDirty();
            }
            case 32: {
                return pSSysDBPartBase.isPortletTypeDirty();
            }
            case 33: {
                return pSSysDBPartBase.isPosInfoDirty();
            }
            case 34: {
                return pSSysDBPartBase.isPPSSysDBPartIdDirty();
            }
            case 35: {
                return pSSysDBPartBase.isPPSSysDBPartNameDirty();
            }
            case 36: {
                return pSSysDBPartBase.isPSSysCssIdDirty();
            }
            case 37: {
                return pSSysDBPartBase.isPSSysCssNameDirty();
            }
            case 38: {
                return pSSysDBPartBase.isPSSysDashboardIdDirty();
            }
            case 39: {
                return pSSysDBPartBase.isPSSysDashboardNameDirty();
            }
            case 40: {
                return pSSysDBPartBase.isPSSysDBPartIdDirty();
            }
            case 41: {
                return pSSysDBPartBase.isPSSysDBPartNameDirty();
            }
            case 42: {
                return pSSysDBPartBase.isPSSysImageIdDirty();
            }
            case 43: {
                return pSSysDBPartBase.isPSSysImageNameDirty();
            }
            case 44: {
                return pSSysDBPartBase.isPSSysPFPluginIdDirty();
            }
            case 45: {
                return pSSysDBPartBase.isPSSysPFPluginNameDirty();
            }
            case 46: {
                return pSSysDBPartBase.isPSSysPortletIdDirty();
            }
            case 47: {
                return pSSysDBPartBase.isPSSysPortletNameDirty();
            }
            case 48: {
                return pSSysDBPartBase.isPSSysResourceIdDirty();
            }
            case 49: {
                return pSSysDBPartBase.isPSSysResourceNameDirty();
            }
            case 50: {
                return pSSysDBPartBase.isPSSysUniResIdDirty();
            }
            case 51: {
                return pSSysDBPartBase.isPSSysUniResNameDirty();
            }
            case 52: {
                return pSSysDBPartBase.isRawContentDirty();
            }
            case 53: {
                return pSSysDBPartBase.isRawCssStyleDirty();
            }
            case 54: {
                return pSSysDBPartBase.isShowTitleBarDirty();
            }
            case 55: {
                return pSSysDBPartBase.isSwapModeDirty();
            }
            case 56: {
                return pSSysDBPartBase.isTemplateModeDirty();
            }
            case 57: {
                return pSSysDBPartBase.isTitleDirty();
            }
            case 58: {
                return pSSysDBPartBase.isTitleBarCloseModeDirty();
            }
            case 59: {
                return pSSysDBPartBase.isTitlePSLanResIdDirty();
            }
            case 60: {
                return pSSysDBPartBase.isTitlePSLanResNameDirty();
            }
            case 61: {
                return pSSysDBPartBase.isTooltipInfoDirty();
            }
            case 62: {
                return pSSysDBPartBase.isUpdateDateDirty();
            }
            case 63: {
                return pSSysDBPartBase.isUpdateManDirty();
            }
            case 64: {
                return pSSysDBPartBase.isUserTagDirty();
            }
            case 65: {
                return pSSysDBPartBase.isUserTag2Dirty();
            }
            case 66: {
                return pSSysDBPartBase.isValidFlagDirty();
            }
            case 67: {
                return pSSysDBPartBase.isVAlignSelfDirty();
            }
            case 68: {
                return pSSysDBPartBase.isWidthDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysDBPartBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysDBPartBase pSSysDBPartBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysDBPartBase.getBL_Pos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bl_pos", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getBL_Pos()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getColId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getColSpan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colspan", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getColSpan()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_LG() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_LG()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_LG_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_lg_os", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_LG_OS()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_MD() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_MD()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_MD_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_md_os", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_MD_OS()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_SM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_SM()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_SM_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_sm_os", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_SM_OS()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_XS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_XS()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCol_XS_OS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"col_xs_os", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCol_XS_OS()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getContentType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"contenttype", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getContentType()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getDBPartType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dbparttype", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getDBPartType()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getDynaClass() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynaclass", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getDynaClass()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getEnableAnchor() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableanchor", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getEnableAnchor()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexalign", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexAlign()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexBasis() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexbasis", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexBasis()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexDir() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexdir", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexDir()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexGrow() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexgrow", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexGrow()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexShrink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexshrink", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexShrink()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getFlexVAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"flexvalign", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getFlexVAlign()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getHAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"halignself", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getHAlignSelf()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getHeight() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"height", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getHeight()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getHtmlContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"htmlcontent", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getHtmlContent()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"layoutmode", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getLayoutMode()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getNewRowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"newrowmode", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getNewRowMode()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPartParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"partparams", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPartParams()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPartStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"partstyle", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPartStyle()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPortletType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portlettype", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPortletType()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPosInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"posinfo", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPosInfo()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPPSSysDBPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdbpartid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPPSSysDBPartId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPPSSysDBPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppssysdbpartname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPPSSysDBPartName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysDashboardId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysDashboardId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysDashboardName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdashboardname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysDashboardName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysDBPartId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbpartid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysDBPartId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysDBPartName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdbpartname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysDBPartName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysPortletId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysPortletId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysPortletName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysportletname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysPortletName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getRawContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcontent", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getRawContent()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getRawCssStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rawcssstyle", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getRawCssStyle()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getShowTitleBar() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showtitlebar", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getShowTitleBar()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getSwapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"swapmode", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getSwapMode()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTemplateMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"templatemode", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTemplateMode()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"title", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTitle()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTitleBarCloseMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlebarclosemode", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTitleBarCloseMode()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTitlePSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresid", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTitlePSLanResId()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTitlePSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"titlepslanresname", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTitlePSLanResName()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getTooltipInfo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"tooltipinfo", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getTooltipInfo()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getVAlignSelf() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valignself", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getVAlignSelf()), (boolean)false);
        }
        if (bl || pSSysDBPartBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSSysDBPartBase.getJSONValue((Object)pSSysDBPartBase.getWidth()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysDBPartBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysDBPartBase pSSysDBPartBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysDBPartBase.getBL_Pos() != null) {
            object = pSSysDBPartBase.getBL_Pos();
            xmlNode.setAttribute(FIELD_BL_POS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getColId() != null) {
            object = pSSysDBPartBase.getColId();
            xmlNode.setAttribute(FIELD_COLID, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getColSpan() != null) {
            object = pSSysDBPartBase.getColSpan();
            xmlNode.setAttribute(FIELD_COLSPAN, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_LG() != null) {
            object = pSSysDBPartBase.getCol_LG();
            xmlNode.setAttribute(FIELD_COL_LG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_LG_OS() != null) {
            object = pSSysDBPartBase.getCol_LG_OS();
            xmlNode.setAttribute(FIELD_COL_LG_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_MD() != null) {
            object = pSSysDBPartBase.getCol_MD();
            xmlNode.setAttribute(FIELD_COL_MD, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_MD_OS() != null) {
            object = pSSysDBPartBase.getCol_MD_OS();
            xmlNode.setAttribute(FIELD_COL_MD_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_SM() != null) {
            object = pSSysDBPartBase.getCol_SM();
            xmlNode.setAttribute(FIELD_COL_SM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_SM_OS() != null) {
            object = pSSysDBPartBase.getCol_SM_OS();
            xmlNode.setAttribute(FIELD_COL_SM_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_XS() != null) {
            object = pSSysDBPartBase.getCol_XS();
            xmlNode.setAttribute(FIELD_COL_XS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCol_XS_OS() != null) {
            object = pSSysDBPartBase.getCol_XS_OS();
            xmlNode.setAttribute(FIELD_COL_XS_OS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getContentType() != null) {
            object = pSSysDBPartBase.getContentType();
            xmlNode.setAttribute(FIELD_CONTENTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getCreateDate() != null) {
            object = pSSysDBPartBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBPartBase.getCreateMan() != null) {
            object = pSSysDBPartBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getDBPartType() != null) {
            object = pSSysDBPartBase.getDBPartType();
            xmlNode.setAttribute(FIELD_DBPARTTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getDynaClass() != null) {
            object = pSSysDBPartBase.getDynaClass();
            xmlNode.setAttribute(FIELD_DYNACLASS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getEnableAnchor() != null) {
            object = pSSysDBPartBase.getEnableAnchor();
            xmlNode.setAttribute(FIELD_ENABLEANCHOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getFlexAlign() != null) {
            object = pSSysDBPartBase.getFlexAlign();
            xmlNode.setAttribute(FIELD_FLEXALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getFlexBasis() != null) {
            object = pSSysDBPartBase.getFlexBasis();
            xmlNode.setAttribute(FIELD_FLEXBASIS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getFlexDir() != null) {
            object = pSSysDBPartBase.getFlexDir();
            xmlNode.setAttribute(FIELD_FLEXDIR, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getFlexGrow() != null) {
            object = pSSysDBPartBase.getFlexGrow();
            xmlNode.setAttribute(FIELD_FLEXGROW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getFlexShrink() != null) {
            object = pSSysDBPartBase.getFlexShrink();
            xmlNode.setAttribute(FIELD_FLEXSHRINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getFlexVAlign() != null) {
            object = pSSysDBPartBase.getFlexVAlign();
            xmlNode.setAttribute(FIELD_FLEXVALIGN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getHAlignSelf() != null) {
            object = pSSysDBPartBase.getHAlignSelf();
            xmlNode.setAttribute(FIELD_HALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getHeight() != null) {
            object = pSSysDBPartBase.getHeight();
            xmlNode.setAttribute(FIELD_HEIGHT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getHtmlContent() != null) {
            object = pSSysDBPartBase.getHtmlContent();
            xmlNode.setAttribute(FIELD_HTMLCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getLayoutMode() != null) {
            object = pSSysDBPartBase.getLayoutMode();
            xmlNode.setAttribute(FIELD_LAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getMemo() != null) {
            object = pSSysDBPartBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getNewRowMode() != null) {
            object = pSSysDBPartBase.getNewRowMode();
            xmlNode.setAttribute(FIELD_NEWROWMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getOrderValue() != null) {
            object = pSSysDBPartBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getPartParams() != null) {
            object = pSSysDBPartBase.getPartParams();
            xmlNode.setAttribute(FIELD_PARTPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPartStyle() != null) {
            object = pSSysDBPartBase.getPartStyle();
            xmlNode.setAttribute(FIELD_PARTSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPortletType() != null) {
            object = pSSysDBPartBase.getPortletType();
            xmlNode.setAttribute(FIELD_PORTLETTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPosInfo() != null) {
            object = pSSysDBPartBase.getPosInfo();
            xmlNode.setAttribute(FIELD_POSINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPPSSysDBPartId() != null) {
            object = pSSysDBPartBase.getPPSSysDBPartId();
            xmlNode.setAttribute(FIELD_PPSSYSDBPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPPSSysDBPartName() != null) {
            object = pSSysDBPartBase.getPPSSysDBPartName();
            xmlNode.setAttribute(FIELD_PPSSYSDBPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysCssId() != null) {
            object = pSSysDBPartBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysCssName() != null) {
            object = pSSysDBPartBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysDashboardId() != null) {
            object = pSSysDBPartBase.getPSSysDashboardId();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysDashboardName() != null) {
            object = pSSysDBPartBase.getPSSysDashboardName();
            xmlNode.setAttribute(FIELD_PSSYSDASHBOARDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysDBPartId() != null) {
            object = pSSysDBPartBase.getPSSysDBPartId();
            xmlNode.setAttribute(FIELD_PSSYSDBPARTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysDBPartName() != null) {
            object = pSSysDBPartBase.getPSSysDBPartName();
            xmlNode.setAttribute(FIELD_PSSYSDBPARTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysImageId() != null) {
            object = pSSysDBPartBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysImageName() != null) {
            object = pSSysDBPartBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysPFPluginId() != null) {
            object = pSSysDBPartBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysPFPluginName() != null) {
            object = pSSysDBPartBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysPortletId() != null) {
            object = pSSysDBPartBase.getPSSysPortletId();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysPortletName() != null) {
            object = pSSysDBPartBase.getPSSysPortletName();
            xmlNode.setAttribute(FIELD_PSSYSPORTLETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysResourceId() != null) {
            object = pSSysDBPartBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysResourceName() != null) {
            object = pSSysDBPartBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysUniResId() != null) {
            object = pSSysDBPartBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getPSSysUniResName() != null) {
            object = pSSysDBPartBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getRawContent() != null) {
            object = pSSysDBPartBase.getRawContent();
            xmlNode.setAttribute(FIELD_RAWCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getRawCssStyle() != null) {
            object = pSSysDBPartBase.getRawCssStyle();
            xmlNode.setAttribute(FIELD_RAWCSSSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getShowTitleBar() != null) {
            object = pSSysDBPartBase.getShowTitleBar();
            xmlNode.setAttribute(FIELD_SHOWTITLEBAR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getSwapMode() != null) {
            object = pSSysDBPartBase.getSwapMode();
            xmlNode.setAttribute(FIELD_SWAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getTemplateMode() != null) {
            object = pSSysDBPartBase.getTemplateMode();
            xmlNode.setAttribute(FIELD_TEMPLATEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getTitle() != null) {
            object = pSSysDBPartBase.getTitle();
            xmlNode.setAttribute(FIELD_TITLE, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getTitleBarCloseMode() != null) {
            object = pSSysDBPartBase.getTitleBarCloseMode();
            xmlNode.setAttribute(FIELD_TITLEBARCLOSEMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getTitlePSLanResId() != null) {
            object = pSSysDBPartBase.getTitlePSLanResId();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getTitlePSLanResName() != null) {
            object = pSSysDBPartBase.getTitlePSLanResName();
            xmlNode.setAttribute(FIELD_TITLEPSLANRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getTooltipInfo() != null) {
            object = pSSysDBPartBase.getTooltipInfo();
            xmlNode.setAttribute(FIELD_TOOLTIPINFO, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getUpdateDate() != null) {
            object = pSSysDBPartBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysDBPartBase.getUpdateMan() != null) {
            object = pSSysDBPartBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getUserTag() != null) {
            object = pSSysDBPartBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getUserTag2() != null) {
            object = pSSysDBPartBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getValidFlag() != null) {
            object = pSSysDBPartBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysDBPartBase.getVAlignSelf() != null) {
            object = pSSysDBPartBase.getVAlignSelf();
            xmlNode.setAttribute(FIELD_VALIGNSELF, object == null ? "" : (String)object);
        }
        if (bl || pSSysDBPartBase.getWidth() != null) {
            object = pSSysDBPartBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysDBPartBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysDBPartBase pSSysDBPartBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysDBPartBase.isBL_PosDirty() && (bl || pSSysDBPartBase.getBL_Pos() != null)) {
            iDataObject.set(FIELD_BL_POS, (Object)pSSysDBPartBase.getBL_Pos());
        }
        if (pSSysDBPartBase.isColIdDirty() && (bl || pSSysDBPartBase.getColId() != null)) {
            iDataObject.set(FIELD_COLID, (Object)pSSysDBPartBase.getColId());
        }
        if (pSSysDBPartBase.isColSpanDirty() && (bl || pSSysDBPartBase.getColSpan() != null)) {
            iDataObject.set(FIELD_COLSPAN, (Object)pSSysDBPartBase.getColSpan());
        }
        if (pSSysDBPartBase.isCol_LGDirty() && (bl || pSSysDBPartBase.getCol_LG() != null)) {
            iDataObject.set(FIELD_COL_LG, (Object)pSSysDBPartBase.getCol_LG());
        }
        if (pSSysDBPartBase.isCol_LG_OSDirty() && (bl || pSSysDBPartBase.getCol_LG_OS() != null)) {
            iDataObject.set(FIELD_COL_LG_OS, (Object)pSSysDBPartBase.getCol_LG_OS());
        }
        if (pSSysDBPartBase.isCol_MDDirty() && (bl || pSSysDBPartBase.getCol_MD() != null)) {
            iDataObject.set(FIELD_COL_MD, (Object)pSSysDBPartBase.getCol_MD());
        }
        if (pSSysDBPartBase.isCol_MD_OSDirty() && (bl || pSSysDBPartBase.getCol_MD_OS() != null)) {
            iDataObject.set(FIELD_COL_MD_OS, (Object)pSSysDBPartBase.getCol_MD_OS());
        }
        if (pSSysDBPartBase.isCol_SMDirty() && (bl || pSSysDBPartBase.getCol_SM() != null)) {
            iDataObject.set(FIELD_COL_SM, (Object)pSSysDBPartBase.getCol_SM());
        }
        if (pSSysDBPartBase.isCol_SM_OSDirty() && (bl || pSSysDBPartBase.getCol_SM_OS() != null)) {
            iDataObject.set(FIELD_COL_SM_OS, (Object)pSSysDBPartBase.getCol_SM_OS());
        }
        if (pSSysDBPartBase.isCol_XSDirty() && (bl || pSSysDBPartBase.getCol_XS() != null)) {
            iDataObject.set(FIELD_COL_XS, (Object)pSSysDBPartBase.getCol_XS());
        }
        if (pSSysDBPartBase.isCol_XS_OSDirty() && (bl || pSSysDBPartBase.getCol_XS_OS() != null)) {
            iDataObject.set(FIELD_COL_XS_OS, (Object)pSSysDBPartBase.getCol_XS_OS());
        }
        if (pSSysDBPartBase.isContentTypeDirty() && (bl || pSSysDBPartBase.getContentType() != null)) {
            iDataObject.set(FIELD_CONTENTTYPE, (Object)pSSysDBPartBase.getContentType());
        }
        if (pSSysDBPartBase.isCreateDateDirty() && (bl || pSSysDBPartBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysDBPartBase.getCreateDate());
        }
        if (pSSysDBPartBase.isCreateManDirty() && (bl || pSSysDBPartBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysDBPartBase.getCreateMan());
        }
        if (pSSysDBPartBase.isDBPartTypeDirty() && (bl || pSSysDBPartBase.getDBPartType() != null)) {
            iDataObject.set(FIELD_DBPARTTYPE, (Object)pSSysDBPartBase.getDBPartType());
        }
        if (pSSysDBPartBase.isDynaClassDirty() && (bl || pSSysDBPartBase.getDynaClass() != null)) {
            iDataObject.set(FIELD_DYNACLASS, (Object)pSSysDBPartBase.getDynaClass());
        }
        if (pSSysDBPartBase.isEnableAnchorDirty() && (bl || pSSysDBPartBase.getEnableAnchor() != null)) {
            iDataObject.set(FIELD_ENABLEANCHOR, (Object)pSSysDBPartBase.getEnableAnchor());
        }
        if (pSSysDBPartBase.isFlexAlignDirty() && (bl || pSSysDBPartBase.getFlexAlign() != null)) {
            iDataObject.set(FIELD_FLEXALIGN, (Object)pSSysDBPartBase.getFlexAlign());
        }
        if (pSSysDBPartBase.isFlexBasisDirty() && (bl || pSSysDBPartBase.getFlexBasis() != null)) {
            iDataObject.set(FIELD_FLEXBASIS, (Object)pSSysDBPartBase.getFlexBasis());
        }
        if (pSSysDBPartBase.isFlexDirDirty() && (bl || pSSysDBPartBase.getFlexDir() != null)) {
            iDataObject.set(FIELD_FLEXDIR, (Object)pSSysDBPartBase.getFlexDir());
        }
        if (pSSysDBPartBase.isFlexGrowDirty() && (bl || pSSysDBPartBase.getFlexGrow() != null)) {
            iDataObject.set(FIELD_FLEXGROW, (Object)pSSysDBPartBase.getFlexGrow());
        }
        if (pSSysDBPartBase.isFlexShrinkDirty() && (bl || pSSysDBPartBase.getFlexShrink() != null)) {
            iDataObject.set(FIELD_FLEXSHRINK, (Object)pSSysDBPartBase.getFlexShrink());
        }
        if (pSSysDBPartBase.isFlexVAlignDirty() && (bl || pSSysDBPartBase.getFlexVAlign() != null)) {
            iDataObject.set(FIELD_FLEXVALIGN, (Object)pSSysDBPartBase.getFlexVAlign());
        }
        if (pSSysDBPartBase.isHAlignSelfDirty() && (bl || pSSysDBPartBase.getHAlignSelf() != null)) {
            iDataObject.set(FIELD_HALIGNSELF, (Object)pSSysDBPartBase.getHAlignSelf());
        }
        if (pSSysDBPartBase.isHeightDirty() && (bl || pSSysDBPartBase.getHeight() != null)) {
            iDataObject.set(FIELD_HEIGHT, (Object)pSSysDBPartBase.getHeight());
        }
        if (pSSysDBPartBase.isHtmlContentDirty() && (bl || pSSysDBPartBase.getHtmlContent() != null)) {
            iDataObject.set(FIELD_HTMLCONTENT, (Object)pSSysDBPartBase.getHtmlContent());
        }
        if (pSSysDBPartBase.isLayoutModeDirty() && (bl || pSSysDBPartBase.getLayoutMode() != null)) {
            iDataObject.set(FIELD_LAYOUTMODE, (Object)pSSysDBPartBase.getLayoutMode());
        }
        if (pSSysDBPartBase.isMemoDirty() && (bl || pSSysDBPartBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysDBPartBase.getMemo());
        }
        if (pSSysDBPartBase.isNewRowModeDirty() && (bl || pSSysDBPartBase.getNewRowMode() != null)) {
            iDataObject.set(FIELD_NEWROWMODE, (Object)pSSysDBPartBase.getNewRowMode());
        }
        if (pSSysDBPartBase.isOrderValueDirty() && (bl || pSSysDBPartBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSSysDBPartBase.getOrderValue());
        }
        if (pSSysDBPartBase.isPartParamsDirty() && (bl || pSSysDBPartBase.getPartParams() != null)) {
            iDataObject.set(FIELD_PARTPARAMS, (Object)pSSysDBPartBase.getPartParams());
        }
        if (pSSysDBPartBase.isPartStyleDirty() && (bl || pSSysDBPartBase.getPartStyle() != null)) {
            iDataObject.set(FIELD_PARTSTYLE, (Object)pSSysDBPartBase.getPartStyle());
        }
        if (pSSysDBPartBase.isPortletTypeDirty() && (bl || pSSysDBPartBase.getPortletType() != null)) {
            iDataObject.set(FIELD_PORTLETTYPE, (Object)pSSysDBPartBase.getPortletType());
        }
        if (pSSysDBPartBase.isPosInfoDirty() && (bl || pSSysDBPartBase.getPosInfo() != null)) {
            iDataObject.set(FIELD_POSINFO, (Object)pSSysDBPartBase.getPosInfo());
        }
        if (pSSysDBPartBase.isPPSSysDBPartIdDirty() && (bl || pSSysDBPartBase.getPPSSysDBPartId() != null)) {
            iDataObject.set(FIELD_PPSSYSDBPARTID, (Object)pSSysDBPartBase.getPPSSysDBPartId());
        }
        if (pSSysDBPartBase.isPPSSysDBPartNameDirty() && (bl || pSSysDBPartBase.getPPSSysDBPartName() != null)) {
            iDataObject.set(FIELD_PPSSYSDBPARTNAME, (Object)pSSysDBPartBase.getPPSSysDBPartName());
        }
        if (pSSysDBPartBase.isPSSysCssIdDirty() && (bl || pSSysDBPartBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSSysDBPartBase.getPSSysCssId());
        }
        if (pSSysDBPartBase.isPSSysCssNameDirty() && (bl || pSSysDBPartBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSSysDBPartBase.getPSSysCssName());
        }
        if (pSSysDBPartBase.isPSSysDashboardIdDirty() && (bl || pSSysDBPartBase.getPSSysDashboardId() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDID, (Object)pSSysDBPartBase.getPSSysDashboardId());
        }
        if (pSSysDBPartBase.isPSSysDashboardNameDirty() && (bl || pSSysDBPartBase.getPSSysDashboardName() != null)) {
            iDataObject.set(FIELD_PSSYSDASHBOARDNAME, (Object)pSSysDBPartBase.getPSSysDashboardName());
        }
        if (pSSysDBPartBase.isPSSysDBPartIdDirty() && (bl || pSSysDBPartBase.getPSSysDBPartId() != null)) {
            iDataObject.set(FIELD_PSSYSDBPARTID, (Object)pSSysDBPartBase.getPSSysDBPartId());
        }
        if (pSSysDBPartBase.isPSSysDBPartNameDirty() && (bl || pSSysDBPartBase.getPSSysDBPartName() != null)) {
            iDataObject.set(FIELD_PSSYSDBPARTNAME, (Object)pSSysDBPartBase.getPSSysDBPartName());
        }
        if (pSSysDBPartBase.isPSSysImageIdDirty() && (bl || pSSysDBPartBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSSysDBPartBase.getPSSysImageId());
        }
        if (pSSysDBPartBase.isPSSysImageNameDirty() && (bl || pSSysDBPartBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSSysDBPartBase.getPSSysImageName());
        }
        if (pSSysDBPartBase.isPSSysPFPluginIdDirty() && (bl || pSSysDBPartBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysDBPartBase.getPSSysPFPluginId());
        }
        if (pSSysDBPartBase.isPSSysPFPluginNameDirty() && (bl || pSSysDBPartBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysDBPartBase.getPSSysPFPluginName());
        }
        if (pSSysDBPartBase.isPSSysPortletIdDirty() && (bl || pSSysDBPartBase.getPSSysPortletId() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETID, (Object)pSSysDBPartBase.getPSSysPortletId());
        }
        if (pSSysDBPartBase.isPSSysPortletNameDirty() && (bl || pSSysDBPartBase.getPSSysPortletName() != null)) {
            iDataObject.set(FIELD_PSSYSPORTLETNAME, (Object)pSSysDBPartBase.getPSSysPortletName());
        }
        if (pSSysDBPartBase.isPSSysResourceIdDirty() && (bl || pSSysDBPartBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysDBPartBase.getPSSysResourceId());
        }
        if (pSSysDBPartBase.isPSSysResourceNameDirty() && (bl || pSSysDBPartBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysDBPartBase.getPSSysResourceName());
        }
        if (pSSysDBPartBase.isPSSysUniResIdDirty() && (bl || pSSysDBPartBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysDBPartBase.getPSSysUniResId());
        }
        if (pSSysDBPartBase.isPSSysUniResNameDirty() && (bl || pSSysDBPartBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysDBPartBase.getPSSysUniResName());
        }
        if (pSSysDBPartBase.isRawContentDirty() && (bl || pSSysDBPartBase.getRawContent() != null)) {
            iDataObject.set(FIELD_RAWCONTENT, (Object)pSSysDBPartBase.getRawContent());
        }
        if (pSSysDBPartBase.isRawCssStyleDirty() && (bl || pSSysDBPartBase.getRawCssStyle() != null)) {
            iDataObject.set(FIELD_RAWCSSSTYLE, (Object)pSSysDBPartBase.getRawCssStyle());
        }
        if (pSSysDBPartBase.isShowTitleBarDirty() && (bl || pSSysDBPartBase.getShowTitleBar() != null)) {
            iDataObject.set(FIELD_SHOWTITLEBAR, (Object)pSSysDBPartBase.getShowTitleBar());
        }
        if (pSSysDBPartBase.isSwapModeDirty() && (bl || pSSysDBPartBase.getSwapMode() != null)) {
            iDataObject.set(FIELD_SWAPMODE, (Object)pSSysDBPartBase.getSwapMode());
        }
        if (pSSysDBPartBase.isTemplateModeDirty() && (bl || pSSysDBPartBase.getTemplateMode() != null)) {
            iDataObject.set(FIELD_TEMPLATEMODE, (Object)pSSysDBPartBase.getTemplateMode());
        }
        if (pSSysDBPartBase.isTitleDirty() && (bl || pSSysDBPartBase.getTitle() != null)) {
            iDataObject.set(FIELD_TITLE, (Object)pSSysDBPartBase.getTitle());
        }
        if (pSSysDBPartBase.isTitleBarCloseModeDirty() && (bl || pSSysDBPartBase.getTitleBarCloseMode() != null)) {
            iDataObject.set(FIELD_TITLEBARCLOSEMODE, (Object)pSSysDBPartBase.getTitleBarCloseMode());
        }
        if (pSSysDBPartBase.isTitlePSLanResIdDirty() && (bl || pSSysDBPartBase.getTitlePSLanResId() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESID, (Object)pSSysDBPartBase.getTitlePSLanResId());
        }
        if (pSSysDBPartBase.isTitlePSLanResNameDirty() && (bl || pSSysDBPartBase.getTitlePSLanResName() != null)) {
            iDataObject.set(FIELD_TITLEPSLANRESNAME, (Object)pSSysDBPartBase.getTitlePSLanResName());
        }
        if (pSSysDBPartBase.isTooltipInfoDirty() && (bl || pSSysDBPartBase.getTooltipInfo() != null)) {
            iDataObject.set(FIELD_TOOLTIPINFO, (Object)pSSysDBPartBase.getTooltipInfo());
        }
        if (pSSysDBPartBase.isUpdateDateDirty() && (bl || pSSysDBPartBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysDBPartBase.getUpdateDate());
        }
        if (pSSysDBPartBase.isUpdateManDirty() && (bl || pSSysDBPartBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysDBPartBase.getUpdateMan());
        }
        if (pSSysDBPartBase.isUserTagDirty() && (bl || pSSysDBPartBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysDBPartBase.getUserTag());
        }
        if (pSSysDBPartBase.isUserTag2Dirty() && (bl || pSSysDBPartBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysDBPartBase.getUserTag2());
        }
        if (pSSysDBPartBase.isValidFlagDirty() && (bl || pSSysDBPartBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysDBPartBase.getValidFlag());
        }
        if (pSSysDBPartBase.isVAlignSelfDirty() && (bl || pSSysDBPartBase.getVAlignSelf() != null)) {
            iDataObject.set(FIELD_VALIGNSELF, (Object)pSSysDBPartBase.getVAlignSelf());
        }
        if (pSSysDBPartBase.isWidthDirty() && (bl || pSSysDBPartBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSSysDBPartBase.getWidth());
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
        return PSSysDBPartBase.remove(this, n);
    }

    private static boolean remove(PSSysDBPartBase pSSysDBPartBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysDBPartBase.resetBL_Pos();
                return true;
            }
            case 1: {
                pSSysDBPartBase.resetColId();
                return true;
            }
            case 2: {
                pSSysDBPartBase.resetColSpan();
                return true;
            }
            case 3: {
                pSSysDBPartBase.resetCol_LG();
                return true;
            }
            case 4: {
                pSSysDBPartBase.resetCol_LG_OS();
                return true;
            }
            case 5: {
                pSSysDBPartBase.resetCol_MD();
                return true;
            }
            case 6: {
                pSSysDBPartBase.resetCol_MD_OS();
                return true;
            }
            case 7: {
                pSSysDBPartBase.resetCol_SM();
                return true;
            }
            case 8: {
                pSSysDBPartBase.resetCol_SM_OS();
                return true;
            }
            case 9: {
                pSSysDBPartBase.resetCol_XS();
                return true;
            }
            case 10: {
                pSSysDBPartBase.resetCol_XS_OS();
                return true;
            }
            case 11: {
                pSSysDBPartBase.resetContentType();
                return true;
            }
            case 12: {
                pSSysDBPartBase.resetCreateDate();
                return true;
            }
            case 13: {
                pSSysDBPartBase.resetCreateMan();
                return true;
            }
            case 14: {
                pSSysDBPartBase.resetDBPartType();
                return true;
            }
            case 15: {
                pSSysDBPartBase.resetDynaClass();
                return true;
            }
            case 16: {
                pSSysDBPartBase.resetEnableAnchor();
                return true;
            }
            case 17: {
                pSSysDBPartBase.resetFlexAlign();
                return true;
            }
            case 18: {
                pSSysDBPartBase.resetFlexBasis();
                return true;
            }
            case 19: {
                pSSysDBPartBase.resetFlexDir();
                return true;
            }
            case 20: {
                pSSysDBPartBase.resetFlexGrow();
                return true;
            }
            case 21: {
                pSSysDBPartBase.resetFlexShrink();
                return true;
            }
            case 22: {
                pSSysDBPartBase.resetFlexVAlign();
                return true;
            }
            case 23: {
                pSSysDBPartBase.resetHAlignSelf();
                return true;
            }
            case 24: {
                pSSysDBPartBase.resetHeight();
                return true;
            }
            case 25: {
                pSSysDBPartBase.resetHtmlContent();
                return true;
            }
            case 26: {
                pSSysDBPartBase.resetLayoutMode();
                return true;
            }
            case 27: {
                pSSysDBPartBase.resetMemo();
                return true;
            }
            case 28: {
                pSSysDBPartBase.resetNewRowMode();
                return true;
            }
            case 29: {
                pSSysDBPartBase.resetOrderValue();
                return true;
            }
            case 30: {
                pSSysDBPartBase.resetPartParams();
                return true;
            }
            case 31: {
                pSSysDBPartBase.resetPartStyle();
                return true;
            }
            case 32: {
                pSSysDBPartBase.resetPortletType();
                return true;
            }
            case 33: {
                pSSysDBPartBase.resetPosInfo();
                return true;
            }
            case 34: {
                pSSysDBPartBase.resetPPSSysDBPartId();
                return true;
            }
            case 35: {
                pSSysDBPartBase.resetPPSSysDBPartName();
                return true;
            }
            case 36: {
                pSSysDBPartBase.resetPSSysCssId();
                return true;
            }
            case 37: {
                pSSysDBPartBase.resetPSSysCssName();
                return true;
            }
            case 38: {
                pSSysDBPartBase.resetPSSysDashboardId();
                return true;
            }
            case 39: {
                pSSysDBPartBase.resetPSSysDashboardName();
                return true;
            }
            case 40: {
                pSSysDBPartBase.resetPSSysDBPartId();
                return true;
            }
            case 41: {
                pSSysDBPartBase.resetPSSysDBPartName();
                return true;
            }
            case 42: {
                pSSysDBPartBase.resetPSSysImageId();
                return true;
            }
            case 43: {
                pSSysDBPartBase.resetPSSysImageName();
                return true;
            }
            case 44: {
                pSSysDBPartBase.resetPSSysPFPluginId();
                return true;
            }
            case 45: {
                pSSysDBPartBase.resetPSSysPFPluginName();
                return true;
            }
            case 46: {
                pSSysDBPartBase.resetPSSysPortletId();
                return true;
            }
            case 47: {
                pSSysDBPartBase.resetPSSysPortletName();
                return true;
            }
            case 48: {
                pSSysDBPartBase.resetPSSysResourceId();
                return true;
            }
            case 49: {
                pSSysDBPartBase.resetPSSysResourceName();
                return true;
            }
            case 50: {
                pSSysDBPartBase.resetPSSysUniResId();
                return true;
            }
            case 51: {
                pSSysDBPartBase.resetPSSysUniResName();
                return true;
            }
            case 52: {
                pSSysDBPartBase.resetRawContent();
                return true;
            }
            case 53: {
                pSSysDBPartBase.resetRawCssStyle();
                return true;
            }
            case 54: {
                pSSysDBPartBase.resetShowTitleBar();
                return true;
            }
            case 55: {
                pSSysDBPartBase.resetSwapMode();
                return true;
            }
            case 56: {
                pSSysDBPartBase.resetTemplateMode();
                return true;
            }
            case 57: {
                pSSysDBPartBase.resetTitle();
                return true;
            }
            case 58: {
                pSSysDBPartBase.resetTitleBarCloseMode();
                return true;
            }
            case 59: {
                pSSysDBPartBase.resetTitlePSLanResId();
                return true;
            }
            case 60: {
                pSSysDBPartBase.resetTitlePSLanResName();
                return true;
            }
            case 61: {
                pSSysDBPartBase.resetTooltipInfo();
                return true;
            }
            case 62: {
                pSSysDBPartBase.resetUpdateDate();
                return true;
            }
            case 63: {
                pSSysDBPartBase.resetUpdateMan();
                return true;
            }
            case 64: {
                pSSysDBPartBase.resetUserTag();
                return true;
            }
            case 65: {
                pSSysDBPartBase.resetUserTag2();
                return true;
            }
            case 66: {
                pSSysDBPartBase.resetValidFlag();
                return true;
            }
            case 67: {
                pSSysDBPartBase.resetVAlignSelf();
                return true;
            }
            case 68: {
                pSSysDBPartBase.resetWidth();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSLanguageRes getTitlePSLanREs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTitlePSLanREs();
        }
        if (this.getTitlePSLanResId() == null) {
            return null;
        }
        Integer n = this.objTitlePSLanREsLock;
        synchronized (n) {
            if (this.titlepslanres != null && DataTypeHelper.compare((int)25, (Object)this.getTitlePSLanResId(), (Object)this.titlepslanres.getPSLanguageResId()) != 0L) {
                this.titlepslanres = null;
            }
            if (this.titlepslanres == null) {
                PSLanguageRes pSLanguageRes = new PSLanguageRes();
                pSLanguageRes.setPSLanguageResId(this.getTitlePSLanResId());
                PSLanguageResService pSLanguageResService = (PSLanguageResService)ServiceGlobal.getService(PSLanguageResService.class, (SessionFactory)this.getSessionFactory());
                pSLanguageResService.autoGet((IEntity)pSLanguageRes);
                this.titlepslanres = pSLanguageRes;
            }
            return this.titlepslanres;
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
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.pssyscss = pSSysCss;
            }
            return this.pssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDashboard getPSSysDashboard() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDashboard();
        }
        if (this.getPSSysDashboardId() == null) {
            return null;
        }
        Integer n = this.objPSSysDashboardLock;
        synchronized (n) {
            if (this.pssysdashboard != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDashboardId(), (Object)this.pssysdashboard.getPSSysDashboardId()) != 0L) {
                this.pssysdashboard = null;
            }
            if (this.pssysdashboard == null) {
                PSSysDashboard pSSysDashboard = new PSSysDashboard();
                pSSysDashboard.setPSSysDashboardId(this.getPSSysDashboardId());
                PSSysDashboardService pSSysDashboardService = (PSSysDashboardService)ServiceGlobal.getService(PSSysDashboardService.class, (SessionFactory)this.getSessionFactory());
                pSSysDashboardService.autoGet((IEntity)pSSysDashboard);
                this.pssysdashboard = pSSysDashboard;
            }
            return this.pssysdashboard;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDBPart getPPSSysDBPart() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSSysDBPart();
        }
        if (this.getPPSSysDBPartId() == null) {
            return null;
        }
        Integer n = this.objPPSSysDBPartLock;
        synchronized (n) {
            if (this.ppssysdbpart != null && DataTypeHelper.compare((int)25, (Object)this.getPPSSysDBPartId(), (Object)this.ppssysdbpart.getPSSysDBPartId()) != 0L) {
                this.ppssysdbpart = null;
            }
            if (this.ppssysdbpart == null) {
                PSSysDBPart pSSysDBPart = new PSSysDBPart();
                pSSysDBPart.setPSSysDBPartId(this.getPPSSysDBPartId());
                PSSysDBPartService pSSysDBPartService = (PSSysDBPartService)ServiceGlobal.getService(PSSysDBPartService.class, (SessionFactory)this.getSessionFactory());
                pSSysDBPartService.autoGet((IEntity)pSSysDBPart);
                this.ppssysdbpart = pSSysDBPart;
            }
            return this.ppssysdbpart;
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
                pSSysImageService.autoGet((IEntity)pSSysImage);
                this.pssysimage = pSSysImage;
            }
            return this.pssysimage;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPFPlugin();
        }
        if (this.getPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysPFPluginLock;
        synchronized (n) {
            if (this.pssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPFPluginId(), (Object)this.pssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.pssyspfplugin = null;
            }
            if (this.pssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPortlet getPSSysPortlet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysPortlet();
        }
        if (this.getPSSysPortletId() == null) {
            return null;
        }
        Integer n = this.objPSSysPortletLock;
        synchronized (n) {
            if (this.pssysportlet != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysPortletId(), (Object)this.pssysportlet.getPSSysPortletId()) != 0L) {
                this.pssysportlet = null;
            }
            if (this.pssysportlet == null) {
                PSSysPortlet pSSysPortlet = new PSSysPortlet();
                pSSysPortlet.setPSSysPortletId(this.getPSSysPortletId());
                PSSysPortletService pSSysPortletService = (PSSysPortletService)ServiceGlobal.getService(PSSysPortletService.class, (SessionFactory)this.getSessionFactory());
                pSSysPortletService.autoGet((IEntity)pSSysPortlet);
                this.pssysportlet = pSSysPortlet;
            }
            return this.pssysportlet;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysResource();
        }
        if (this.getPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objPSSysResourceLock;
        synchronized (n) {
            if (this.pssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysResourceId(), (Object)this.pssysresource.getPSSysResourceId()) != 0L) {
                this.pssysresource = null;
            }
            if (this.pssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.pssysresource = pSSysResource;
            }
            return this.pssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUniRes getPSSysUniRes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUniRes();
        }
        if (this.getPSSysUniResId() == null) {
            return null;
        }
        Integer n = this.objPSSysUniResLock;
        synchronized (n) {
            if (this.pssysunires != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUniResId(), (Object)this.pssysunires.getPSSysUniResId()) != 0L) {
                this.pssysunires = null;
            }
            if (this.pssysunires == null) {
                PSSysUniRes pSSysUniRes = new PSSysUniRes();
                pSSysUniRes.setPSSysUniResId(this.getPSSysUniResId());
                PSSysUniResService pSSysUniResService = (PSSysUniResService)ServiceGlobal.getService(PSSysUniResService.class, (SessionFactory)this.getSessionFactory());
                pSSysUniResService.autoGet((IEntity)pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    private PSSysDBPartBase getProxyEntity() {
        return this.proxyPSSysDBPartBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysDBPartBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysDBPartBase) {
            this.proxyPSSysDBPartBase = (PSSysDBPartBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysDBPartService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BL_POS, 0);
        fieldIndexMap.put(FIELD_COLID, 1);
        fieldIndexMap.put(FIELD_COLSPAN, 2);
        fieldIndexMap.put(FIELD_COL_LG, 3);
        fieldIndexMap.put(FIELD_COL_LG_OS, 4);
        fieldIndexMap.put(FIELD_COL_MD, 5);
        fieldIndexMap.put(FIELD_COL_MD_OS, 6);
        fieldIndexMap.put(FIELD_COL_SM, 7);
        fieldIndexMap.put(FIELD_COL_SM_OS, 8);
        fieldIndexMap.put(FIELD_COL_XS, 9);
        fieldIndexMap.put(FIELD_COL_XS_OS, 10);
        fieldIndexMap.put(FIELD_CONTENTTYPE, 11);
        fieldIndexMap.put(FIELD_CREATEDATE, 12);
        fieldIndexMap.put(FIELD_CREATEMAN, 13);
        fieldIndexMap.put(FIELD_DBPARTTYPE, 14);
        fieldIndexMap.put(FIELD_DYNACLASS, 15);
        fieldIndexMap.put(FIELD_ENABLEANCHOR, 16);
        fieldIndexMap.put(FIELD_FLEXALIGN, 17);
        fieldIndexMap.put(FIELD_FLEXBASIS, 18);
        fieldIndexMap.put(FIELD_FLEXDIR, 19);
        fieldIndexMap.put(FIELD_FLEXGROW, 20);
        fieldIndexMap.put(FIELD_FLEXSHRINK, 21);
        fieldIndexMap.put(FIELD_FLEXVALIGN, 22);
        fieldIndexMap.put(FIELD_HALIGNSELF, 23);
        fieldIndexMap.put(FIELD_HEIGHT, 24);
        fieldIndexMap.put(FIELD_HTMLCONTENT, 25);
        fieldIndexMap.put(FIELD_LAYOUTMODE, 26);
        fieldIndexMap.put(FIELD_MEMO, 27);
        fieldIndexMap.put(FIELD_NEWROWMODE, 28);
        fieldIndexMap.put(FIELD_ORDERVALUE, 29);
        fieldIndexMap.put(FIELD_PARTPARAMS, 30);
        fieldIndexMap.put(FIELD_PARTSTYLE, 31);
        fieldIndexMap.put(FIELD_PORTLETTYPE, 32);
        fieldIndexMap.put(FIELD_POSINFO, 33);
        fieldIndexMap.put(FIELD_PPSSYSDBPARTID, 34);
        fieldIndexMap.put(FIELD_PPSSYSDBPARTNAME, 35);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 36);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 37);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDID, 38);
        fieldIndexMap.put(FIELD_PSSYSDASHBOARDNAME, 39);
        fieldIndexMap.put(FIELD_PSSYSDBPARTID, 40);
        fieldIndexMap.put(FIELD_PSSYSDBPARTNAME, 41);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 42);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 43);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 44);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 45);
        fieldIndexMap.put(FIELD_PSSYSPORTLETID, 46);
        fieldIndexMap.put(FIELD_PSSYSPORTLETNAME, 47);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 48);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 49);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 50);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 51);
        fieldIndexMap.put(FIELD_RAWCONTENT, 52);
        fieldIndexMap.put(FIELD_RAWCSSSTYLE, 53);
        fieldIndexMap.put(FIELD_SHOWTITLEBAR, 54);
        fieldIndexMap.put(FIELD_SWAPMODE, 55);
        fieldIndexMap.put(FIELD_TEMPLATEMODE, 56);
        fieldIndexMap.put(FIELD_TITLE, 57);
        fieldIndexMap.put(FIELD_TITLEBARCLOSEMODE, 58);
        fieldIndexMap.put(FIELD_TITLEPSLANRESID, 59);
        fieldIndexMap.put(FIELD_TITLEPSLANRESNAME, 60);
        fieldIndexMap.put(FIELD_TOOLTIPINFO, 61);
        fieldIndexMap.put(FIELD_UPDATEDATE, 62);
        fieldIndexMap.put(FIELD_UPDATEMAN, 63);
        fieldIndexMap.put(FIELD_USERTAG, 64);
        fieldIndexMap.put(FIELD_USERTAG2, 65);
        fieldIndexMap.put(FIELD_VALIDFLAG, 66);
        fieldIndexMap.put(FIELD_VALIGNSELF, 67);
        fieldIndexMap.put(FIELD_WIDTH, 68);
    }
}

