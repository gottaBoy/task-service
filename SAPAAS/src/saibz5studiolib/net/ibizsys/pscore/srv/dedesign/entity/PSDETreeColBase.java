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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDETreeView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDETreeViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDETreeColBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDETreeColBase.class);
    public static final String FIELD_ALIGN = "ALIGN";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CELLPSSYSCSSID = "CELLPSSYSCSSID";
    public static final String FIELD_CELLPSSYSCSSNAME = "CELLPSSYSCSSNAME";
    public static final String FIELD_COLENABLEFILTER = "COLENABLEFILTER";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_ENABLELINK = "ENABLELINK";
    public static final String FIELD_GCRPSSYSPFPLUGINID = "GCRPSSYSPFPLUGINID";
    public static final String FIELD_GCRPSSYSPFPLUGINNAME = "GCRPSSYSPFPLUGINNAME";
    public static final String FIELD_GRIDCOLSTYLE = "GRIDCOLSTYLE";
    public static final String FIELD_GRIDCOLTYPE = "GRIDCOLTYPE";
    public static final String FIELD_HEADERPSSYSCSSID = "HEADERPSSYSCSSID";
    public static final String FIELD_HEADERPSSYSCSSNAME = "HEADERPSSYSCSSNAME";
    public static final String FIELD_HIDEDEFAULT = "HIDEDEFAULT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOPRIVDM = "NOPRIVDM";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDETREECOLID = "PSDETREECOLID";
    public static final String FIELD_PSDETREECOLNAME = "PSDETREECOLNAME";
    public static final String FIELD_PSDETREEVIEWID = "PSDETREEVIEWID";
    public static final String FIELD_PSDETREEVIEWNAME = "PSDETREEVIEWNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHUNIT = "WIDTHUNIT";
    private static final int INDEX_ALIGN = 0;
    private static final int INDEX_CAPPSLANRESID = 1;
    private static final int INDEX_CAPPSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CELLPSSYSCSSID = 4;
    private static final int INDEX_CELLPSSYSCSSNAME = 5;
    private static final int INDEX_COLENABLEFILTER = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_DEFAULTVALUE = 9;
    private static final int INDEX_ENABLELINK = 10;
    private static final int INDEX_GCRPSSYSPFPLUGINID = 11;
    private static final int INDEX_GCRPSSYSPFPLUGINNAME = 12;
    private static final int INDEX_GRIDCOLSTYLE = 13;
    private static final int INDEX_GRIDCOLTYPE = 14;
    private static final int INDEX_HEADERPSSYSCSSID = 15;
    private static final int INDEX_HEADERPSSYSCSSNAME = 16;
    private static final int INDEX_HIDEDEFAULT = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_NOPRIVDM = 19;
    private static final int INDEX_NOSORT = 20;
    private static final int INDEX_ORDERVALUE = 21;
    private static final int INDEX_PSCODELISTID = 22;
    private static final int INDEX_PSCODELISTNAME = 23;
    private static final int INDEX_PSDETREECOLID = 24;
    private static final int INDEX_PSDETREECOLNAME = 25;
    private static final int INDEX_PSDETREEVIEWID = 26;
    private static final int INDEX_PSDETREEVIEWNAME = 27;
    private static final int INDEX_PSDEUAGROUPID = 28;
    private static final int INDEX_PSDEUAGROUPNAME = 29;
    private static final int INDEX_PSDEUIACTIONID = 30;
    private static final int INDEX_PSDEUIACTIONNAME = 31;
    private static final int INDEX_PSSYSDYNAMODELID = 32;
    private static final int INDEX_PSSYSDYNAMODELNAME = 33;
    private static final int INDEX_PSSYSIMAGEID = 34;
    private static final int INDEX_PSSYSIMAGENAME = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_WIDTH = 41;
    private static final int INDEX_WIDTHUNIT = 42;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDETreeColBase proxyPSDETreeColBase = null;
    private boolean alignDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean cellpssyscssidDirtyFlag = false;
    private boolean cellpssyscssnameDirtyFlag = false;
    private boolean colenablefilterDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean enablelinkDirtyFlag = false;
    private boolean gcrpssyspfpluginidDirtyFlag = false;
    private boolean gcrpssyspfpluginnameDirtyFlag = false;
    private boolean gridcolstyleDirtyFlag = false;
    private boolean gridcoltypeDirtyFlag = false;
    private boolean headerpssyscssidDirtyFlag = false;
    private boolean headerpssyscssnameDirtyFlag = false;
    private boolean hidedefaultDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean noprivdmDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdetreecolidDirtyFlag = false;
    private boolean psdetreecolnameDirtyFlag = false;
    private boolean psdetreeviewidDirtyFlag = false;
    private boolean psdetreeviewnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean widthDirtyFlag = false;
    private boolean widthunitDirtyFlag = false;
    @Column(name="align")
    private String align;
    @Column(name="cappslanresid")
    private String cappslanresid;
    @Column(name="cappslanresname")
    private String cappslanresname;
    @Column(name="caption")
    private String caption;
    @Column(name="cellpssyscssid")
    private String cellpssyscssid;
    @Column(name="cellpssyscssname")
    private String cellpssyscssname;
    @Column(name="colenablefilter")
    private Integer colenablefilter;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="enablelink")
    private Integer enablelink;
    @Column(name="gcrpssyspfpluginid")
    private String gcrpssyspfpluginid;
    @Column(name="gcrpssyspfpluginname")
    private String gcrpssyspfpluginname;
    @Column(name="gridcolstyle")
    private String gridcolstyle;
    @Column(name="gridcoltype")
    private String gridcoltype;
    @Column(name="headerpssyscssid")
    private String headerpssyscssid;
    @Column(name="headerpssyscssname")
    private String headerpssyscssname;
    @Column(name="hidedefault")
    private Integer hidedefault;
    @Column(name="memo")
    private String memo;
    @Column(name="noprivdm")
    private Integer noprivdm;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdetreecolid")
    private String psdetreecolid;
    @Column(name="psdetreecolname")
    private String psdetreecolname;
    @Column(name="psdetreeviewid")
    private String psdetreeviewid;
    @Column(name="psdetreeviewname")
    private String psdetreeviewname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssysimageid")
    private String pssysimageid;
    @Column(name="pssysimagename")
    private String pssysimagename;
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
    @Column(name="width")
    private Integer width;
    @Column(name="widthunit")
    private String widthunit;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDETreeViewLock = new Integer(1);
    private PSDETreeView psdetreeview = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objPSDEUIActionLock = new Integer(1);
    private PSDEUIAction psdeuiaction = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objCellPSSysCssLock = new Integer(1);
    private PSSysCss cellpssyscss = null;
    private Integer objHeaderPSSysCssLock = new Integer(1);
    private PSSysCss headerpssyscss = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objGCRPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin gcrpssyspfplugin = null;

    public void setAlign(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAlign(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.align = string;
        this.alignDirtyFlag = true;
    }

    public String getAlign() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAlign();
        }
        return this.align;
    }

    public boolean isAlignDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAlignDirty();
        }
        return this.alignDirtyFlag;
    }

    public void resetAlign() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAlign();
            return;
        }
        this.alignDirtyFlag = false;
        this.align = null;
    }

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

    public void setCellPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCellPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cellpssyscssid = string;
        this.cellpssyscssidDirtyFlag = true;
    }

    public String getCellPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCssId();
        }
        return this.cellpssyscssid;
    }

    public boolean isCellPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCellPSSysCssIdDirty();
        }
        return this.cellpssyscssidDirtyFlag;
    }

    public void resetCellPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCellPSSysCssId();
            return;
        }
        this.cellpssyscssidDirtyFlag = false;
        this.cellpssyscssid = null;
    }

    public void setCellPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCellPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.cellpssyscssname = string;
        this.cellpssyscssnameDirtyFlag = true;
    }

    public String getCellPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCssName();
        }
        return this.cellpssyscssname;
    }

    public boolean isCellPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCellPSSysCssNameDirty();
        }
        return this.cellpssyscssnameDirtyFlag;
    }

    public void resetCellPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCellPSSysCssName();
            return;
        }
        this.cellpssyscssnameDirtyFlag = false;
        this.cellpssyscssname = null;
    }

    public void setColEnableFilter(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setColEnableFilter(n);
            return;
        }
        this.colenablefilter = n;
        this.colenablefilterDirtyFlag = true;
    }

    public Integer getColEnableFilter() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getColEnableFilter();
        }
        return this.colenablefilter;
    }

    public boolean isColEnableFilterDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isColEnableFilterDirty();
        }
        return this.colenablefilterDirtyFlag;
    }

    public void resetColEnableFilter() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetColEnableFilter();
            return;
        }
        this.colenablefilterDirtyFlag = false;
        this.colenablefilter = null;
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

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setEnableLink(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLink(n);
            return;
        }
        this.enablelink = n;
        this.enablelinkDirtyFlag = true;
    }

    public Integer getEnableLink() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLink();
        }
        return this.enablelink;
    }

    public boolean isEnableLinkDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLinkDirty();
        }
        return this.enablelinkDirtyFlag;
    }

    public void resetEnableLink() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLink();
            return;
        }
        this.enablelinkDirtyFlag = false;
        this.enablelink = null;
    }

    public void setGCRPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCRPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gcrpssyspfpluginid = string;
        this.gcrpssyspfpluginidDirtyFlag = true;
    }

    public String getGCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPluginId();
        }
        return this.gcrpssyspfpluginid;
    }

    public boolean isGCRPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCRPSSysPFPluginIdDirty();
        }
        return this.gcrpssyspfpluginidDirtyFlag;
    }

    public void resetGCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCRPSSysPFPluginId();
            return;
        }
        this.gcrpssyspfpluginidDirtyFlag = false;
        this.gcrpssyspfpluginid = null;
    }

    public void setGCRPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGCRPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gcrpssyspfpluginname = string;
        this.gcrpssyspfpluginnameDirtyFlag = true;
    }

    public String getGCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPluginName();
        }
        return this.gcrpssyspfpluginname;
    }

    public boolean isGCRPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGCRPSSysPFPluginNameDirty();
        }
        return this.gcrpssyspfpluginnameDirtyFlag;
    }

    public void resetGCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGCRPSSysPFPluginName();
            return;
        }
        this.gcrpssyspfpluginnameDirtyFlag = false;
        this.gcrpssyspfpluginname = null;
    }

    public void setGridColStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcolstyle = string;
        this.gridcolstyleDirtyFlag = true;
    }

    public String getGridColStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColStyle();
        }
        return this.gridcolstyle;
    }

    public boolean isGridColStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColStyleDirty();
        }
        return this.gridcolstyleDirtyFlag;
    }

    public void resetGridColStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColStyle();
            return;
        }
        this.gridcolstyleDirtyFlag = false;
        this.gridcolstyle = null;
    }

    public void setGridColType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGridColType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.gridcoltype = string;
        this.gridcoltypeDirtyFlag = true;
    }

    public String getGridColType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGridColType();
        }
        return this.gridcoltype;
    }

    public boolean isGridColTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGridColTypeDirty();
        }
        return this.gridcoltypeDirtyFlag;
    }

    public void resetGridColType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGridColType();
            return;
        }
        this.gridcoltypeDirtyFlag = false;
        this.gridcoltype = null;
    }

    public void setHeaderPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyscssid = string;
        this.headerpssyscssidDirtyFlag = true;
    }

    public String getHeaderPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCssId();
        }
        return this.headerpssyscssid;
    }

    public boolean isHeaderPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysCssIdDirty();
        }
        return this.headerpssyscssidDirtyFlag;
    }

    public void resetHeaderPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysCssId();
            return;
        }
        this.headerpssyscssidDirtyFlag = false;
        this.headerpssyscssid = null;
    }

    public void setHeaderPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headerpssyscssname = string;
        this.headerpssyscssnameDirtyFlag = true;
    }

    public String getHeaderPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCssName();
        }
        return this.headerpssyscssname;
    }

    public boolean isHeaderPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderPSSysCssNameDirty();
        }
        return this.headerpssyscssnameDirtyFlag;
    }

    public void resetHeaderPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderPSSysCssName();
            return;
        }
        this.headerpssyscssnameDirtyFlag = false;
        this.headerpssyscssname = null;
    }

    public void setHideDefault(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHideDefault(n);
            return;
        }
        this.hidedefault = n;
        this.hidedefaultDirtyFlag = true;
    }

    public Integer getHideDefault() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHideDefault();
        }
        return this.hidedefault;
    }

    public boolean isHideDefaultDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHideDefaultDirty();
        }
        return this.hidedefaultDirtyFlag;
    }

    public void resetHideDefault() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHideDefault();
            return;
        }
        this.hidedefaultDirtyFlag = false;
        this.hidedefault = null;
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

    public void setNoPrivDM(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoPrivDM(n);
            return;
        }
        this.noprivdm = n;
        this.noprivdmDirtyFlag = true;
    }

    public Integer getNoPrivDM() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoPrivDM();
        }
        return this.noprivdm;
    }

    public boolean isNoPrivDMDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoPrivDMDirty();
        }
        return this.noprivdmDirtyFlag;
    }

    public void resetNoPrivDM() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoPrivDM();
            return;
        }
        this.noprivdmDirtyFlag = false;
        this.noprivdm = null;
    }

    public void setNoSort(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNoSort(n);
            return;
        }
        this.nosort = n;
        this.nosortDirtyFlag = true;
    }

    public Integer getNoSort() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNoSort();
        }
        return this.nosort;
    }

    public boolean isNoSortDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNoSortDirty();
        }
        return this.nosortDirtyFlag;
    }

    public void resetNoSort() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNoSort();
            return;
        }
        this.nosortDirtyFlag = false;
        this.nosort = null;
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

    public void setPSDETreeColId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolid = string;
        this.psdetreecolidDirtyFlag = true;
    }

    public String getPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColId();
        }
        return this.psdetreecolid;
    }

    public boolean isPSDETreeColIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColIdDirty();
        }
        return this.psdetreecolidDirtyFlag;
    }

    public void resetPSDETreeColId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColId();
            return;
        }
        this.psdetreecolidDirtyFlag = false;
        this.psdetreecolid = null;
    }

    public void setPSDETreeColName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeColName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreecolname = string;
        this.psdetreecolnameDirtyFlag = true;
    }

    public String getPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeColName();
        }
        return this.psdetreecolname;
    }

    public boolean isPSDETreeColNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeColNameDirty();
        }
        return this.psdetreecolnameDirtyFlag;
    }

    public void resetPSDETreeColName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeColName();
            return;
        }
        this.psdetreecolnameDirtyFlag = false;
        this.psdetreecolname = null;
    }

    public void setPSDETreeViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewid = string;
        this.psdetreeviewidDirtyFlag = true;
    }

    public String getPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewId();
        }
        return this.psdetreeviewid;
    }

    public boolean isPSDETreeViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewIdDirty();
        }
        return this.psdetreeviewidDirtyFlag;
    }

    public void resetPSDETreeViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewId();
            return;
        }
        this.psdetreeviewidDirtyFlag = false;
        this.psdetreeviewid = null;
    }

    public void setPSDETreeViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDETreeViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdetreeviewname = string;
        this.psdetreeviewnameDirtyFlag = true;
    }

    public String getPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeViewName();
        }
        return this.psdetreeviewname;
    }

    public boolean isPSDETreeViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDETreeViewNameDirty();
        }
        return this.psdetreeviewnameDirtyFlag;
    }

    public void resetPSDETreeViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDETreeViewName();
            return;
        }
        this.psdetreeviewnameDirtyFlag = false;
        this.psdetreeviewname = null;
    }

    public void setPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupid = string;
        this.psdeuagroupidDirtyFlag = true;
    }

    public String getPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupId();
        }
        return this.psdeuagroupid;
    }

    public boolean isPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupIdDirty();
        }
        return this.psdeuagroupidDirtyFlag;
    }

    public void resetPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupId();
            return;
        }
        this.psdeuagroupidDirtyFlag = false;
        this.psdeuagroupid = null;
    }

    public void setPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagroupname = string;
        this.psdeuagroupnameDirtyFlag = true;
    }

    public String getPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroupName();
        }
        return this.psdeuagroupname;
    }

    public boolean isPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGroupNameDirty();
        }
        return this.psdeuagroupnameDirtyFlag;
    }

    public void resetPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGroupName();
            return;
        }
        this.psdeuagroupnameDirtyFlag = false;
        this.psdeuagroupname = null;
    }

    public void setPSDEUIActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionid = string;
        this.psdeuiactionidDirtyFlag = true;
    }

    public String getPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionId();
        }
        return this.psdeuiactionid;
    }

    public boolean isPSDEUIActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionIdDirty();
        }
        return this.psdeuiactionidDirtyFlag;
    }

    public void resetPSDEUIActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionId();
            return;
        }
        this.psdeuiactionidDirtyFlag = false;
        this.psdeuiactionid = null;
    }

    public void setPSDEUIActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUIActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuiactionname = string;
        this.psdeuiactionnameDirtyFlag = true;
    }

    public String getPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIActionName();
        }
        return this.psdeuiactionname;
    }

    public boolean isPSDEUIActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUIActionNameDirty();
        }
        return this.psdeuiactionnameDirtyFlag;
    }

    public void resetPSDEUIActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUIActionName();
            return;
        }
        this.psdeuiactionnameDirtyFlag = false;
        this.psdeuiactionname = null;
    }

    public void setPSSysDynaModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelid = string;
        this.pssysdynamodelidDirtyFlag = true;
    }

    public String getPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelId();
        }
        return this.pssysdynamodelid;
    }

    public boolean isPSSysDynaModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelIdDirty();
        }
        return this.pssysdynamodelidDirtyFlag;
    }

    public void resetPSSysDynaModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelId();
            return;
        }
        this.pssysdynamodelidDirtyFlag = false;
        this.pssysdynamodelid = null;
    }

    public void setPSSysDynaModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysDynaModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysdynamodelname = string;
        this.pssysdynamodelnameDirtyFlag = true;
    }

    public String getPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModelName();
        }
        return this.pssysdynamodelname;
    }

    public boolean isPSSysDynaModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysDynaModelNameDirty();
        }
        return this.pssysdynamodelnameDirtyFlag;
    }

    public void resetPSSysDynaModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysDynaModelName();
            return;
        }
        this.pssysdynamodelnameDirtyFlag = false;
        this.pssysdynamodelname = null;
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
        PSDETreeColBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDETreeColBase pSDETreeColBase) {
        pSDETreeColBase.resetAlign();
        pSDETreeColBase.resetCapPSLanResId();
        pSDETreeColBase.resetCapPSLanResName();
        pSDETreeColBase.resetCaption();
        pSDETreeColBase.resetCellPSSysCssId();
        pSDETreeColBase.resetCellPSSysCssName();
        pSDETreeColBase.resetColEnableFilter();
        pSDETreeColBase.resetCreateDate();
        pSDETreeColBase.resetCreateMan();
        pSDETreeColBase.resetDefaultValue();
        pSDETreeColBase.resetEnableLink();
        pSDETreeColBase.resetGCRPSSysPFPluginId();
        pSDETreeColBase.resetGCRPSSysPFPluginName();
        pSDETreeColBase.resetGridColStyle();
        pSDETreeColBase.resetGridColType();
        pSDETreeColBase.resetHeaderPSSysCssId();
        pSDETreeColBase.resetHeaderPSSysCssName();
        pSDETreeColBase.resetHideDefault();
        pSDETreeColBase.resetMemo();
        pSDETreeColBase.resetNoPrivDM();
        pSDETreeColBase.resetNoSort();
        pSDETreeColBase.resetOrderValue();
        pSDETreeColBase.resetPSCodeListId();
        pSDETreeColBase.resetPSCodeListName();
        pSDETreeColBase.resetPSDETreeColId();
        pSDETreeColBase.resetPSDETreeColName();
        pSDETreeColBase.resetPSDETreeViewId();
        pSDETreeColBase.resetPSDETreeViewName();
        pSDETreeColBase.resetPSDEUAGroupId();
        pSDETreeColBase.resetPSDEUAGroupName();
        pSDETreeColBase.resetPSDEUIActionId();
        pSDETreeColBase.resetPSDEUIActionName();
        pSDETreeColBase.resetPSSysDynaModelId();
        pSDETreeColBase.resetPSSysDynaModelName();
        pSDETreeColBase.resetPSSysImageId();
        pSDETreeColBase.resetPSSysImageName();
        pSDETreeColBase.resetUpdateDate();
        pSDETreeColBase.resetUpdateMan();
        pSDETreeColBase.resetUserCat();
        pSDETreeColBase.resetUserTag();
        pSDETreeColBase.resetUserTag2();
        pSDETreeColBase.resetWidth();
        pSDETreeColBase.resetWidthUnit();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAlignDirty()) {
            hashMap.put(FIELD_ALIGN, this.getAlign());
        }
        if (!bl || this.isCapPSLanResIdDirty()) {
            hashMap.put(FIELD_CAPPSLANRESID, this.getCapPSLanResId());
        }
        if (!bl || this.isCapPSLanResNameDirty()) {
            hashMap.put(FIELD_CAPPSLANRESNAME, this.getCapPSLanResName());
        }
        if (!bl || this.isCaptionDirty()) {
            hashMap.put(FIELD_CAPTION, this.getCaption());
        }
        if (!bl || this.isCellPSSysCssIdDirty()) {
            hashMap.put(FIELD_CELLPSSYSCSSID, this.getCellPSSysCssId());
        }
        if (!bl || this.isCellPSSysCssNameDirty()) {
            hashMap.put(FIELD_CELLPSSYSCSSNAME, this.getCellPSSysCssName());
        }
        if (!bl || this.isColEnableFilterDirty()) {
            hashMap.put(FIELD_COLENABLEFILTER, this.getColEnableFilter());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isEnableLinkDirty()) {
            hashMap.put(FIELD_ENABLELINK, this.getEnableLink());
        }
        if (!bl || this.isGCRPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINID, this.getGCRPSSysPFPluginId());
        }
        if (!bl || this.isGCRPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_GCRPSSYSPFPLUGINNAME, this.getGCRPSSysPFPluginName());
        }
        if (!bl || this.isGridColStyleDirty()) {
            hashMap.put(FIELD_GRIDCOLSTYLE, this.getGridColStyle());
        }
        if (!bl || this.isGridColTypeDirty()) {
            hashMap.put(FIELD_GRIDCOLTYPE, this.getGridColType());
        }
        if (!bl || this.isHeaderPSSysCssIdDirty()) {
            hashMap.put(FIELD_HEADERPSSYSCSSID, this.getHeaderPSSysCssId());
        }
        if (!bl || this.isHeaderPSSysCssNameDirty()) {
            hashMap.put(FIELD_HEADERPSSYSCSSNAME, this.getHeaderPSSysCssName());
        }
        if (!bl || this.isHideDefaultDirty()) {
            hashMap.put(FIELD_HIDEDEFAULT, this.getHideDefault());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNoPrivDMDirty()) {
            hashMap.put(FIELD_NOPRIVDM, this.getNoPrivDM());
        }
        if (!bl || this.isNoSortDirty()) {
            hashMap.put(FIELD_NOSORT, this.getNoSort());
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
        if (!bl || this.isPSDETreeColIdDirty()) {
            hashMap.put(FIELD_PSDETREECOLID, this.getPSDETreeColId());
        }
        if (!bl || this.isPSDETreeColNameDirty()) {
            hashMap.put(FIELD_PSDETREECOLNAME, this.getPSDETreeColName());
        }
        if (!bl || this.isPSDETreeViewIdDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWID, this.getPSDETreeViewId());
        }
        if (!bl || this.isPSDETreeViewNameDirty()) {
            hashMap.put(FIELD_PSDETREEVIEWNAME, this.getPSDETreeViewName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysImageIdDirty()) {
            hashMap.put(FIELD_PSSYSIMAGEID, this.getPSSysImageId());
        }
        if (!bl || this.isPSSysImageNameDirty()) {
            hashMap.put(FIELD_PSSYSIMAGENAME, this.getPSSysImageName());
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
        return PSDETreeColBase.get(this, n);
    }

    private static Object get(PSDETreeColBase pSDETreeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeColBase.getAlign();
            }
            case 1: {
                return pSDETreeColBase.getCapPSLanResId();
            }
            case 2: {
                return pSDETreeColBase.getCapPSLanResName();
            }
            case 3: {
                return pSDETreeColBase.getCaption();
            }
            case 4: {
                return pSDETreeColBase.getCellPSSysCssId();
            }
            case 5: {
                return pSDETreeColBase.getCellPSSysCssName();
            }
            case 6: {
                return pSDETreeColBase.getColEnableFilter();
            }
            case 7: {
                return pSDETreeColBase.getCreateDate();
            }
            case 8: {
                return pSDETreeColBase.getCreateMan();
            }
            case 9: {
                return pSDETreeColBase.getDefaultValue();
            }
            case 10: {
                return pSDETreeColBase.getEnableLink();
            }
            case 11: {
                return pSDETreeColBase.getGCRPSSysPFPluginId();
            }
            case 12: {
                return pSDETreeColBase.getGCRPSSysPFPluginName();
            }
            case 13: {
                return pSDETreeColBase.getGridColStyle();
            }
            case 14: {
                return pSDETreeColBase.getGridColType();
            }
            case 15: {
                return pSDETreeColBase.getHeaderPSSysCssId();
            }
            case 16: {
                return pSDETreeColBase.getHeaderPSSysCssName();
            }
            case 17: {
                return pSDETreeColBase.getHideDefault();
            }
            case 18: {
                return pSDETreeColBase.getMemo();
            }
            case 19: {
                return pSDETreeColBase.getNoPrivDM();
            }
            case 20: {
                return pSDETreeColBase.getNoSort();
            }
            case 21: {
                return pSDETreeColBase.getOrderValue();
            }
            case 22: {
                return pSDETreeColBase.getPSCodeListId();
            }
            case 23: {
                return pSDETreeColBase.getPSCodeListName();
            }
            case 24: {
                return pSDETreeColBase.getPSDETreeColId();
            }
            case 25: {
                return pSDETreeColBase.getPSDETreeColName();
            }
            case 26: {
                return pSDETreeColBase.getPSDETreeViewId();
            }
            case 27: {
                return pSDETreeColBase.getPSDETreeViewName();
            }
            case 28: {
                return pSDETreeColBase.getPSDEUAGroupId();
            }
            case 29: {
                return pSDETreeColBase.getPSDEUAGroupName();
            }
            case 30: {
                return pSDETreeColBase.getPSDEUIActionId();
            }
            case 31: {
                return pSDETreeColBase.getPSDEUIActionName();
            }
            case 32: {
                return pSDETreeColBase.getPSSysDynaModelId();
            }
            case 33: {
                return pSDETreeColBase.getPSSysDynaModelName();
            }
            case 34: {
                return pSDETreeColBase.getPSSysImageId();
            }
            case 35: {
                return pSDETreeColBase.getPSSysImageName();
            }
            case 36: {
                return pSDETreeColBase.getUpdateDate();
            }
            case 37: {
                return pSDETreeColBase.getUpdateMan();
            }
            case 38: {
                return pSDETreeColBase.getUserCat();
            }
            case 39: {
                return pSDETreeColBase.getUserTag();
            }
            case 40: {
                return pSDETreeColBase.getUserTag2();
            }
            case 41: {
                return pSDETreeColBase.getWidth();
            }
            case 42: {
                return pSDETreeColBase.getWidthUnit();
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
        PSDETreeColBase.set(this, n, object);
    }

    private static void set(PSDETreeColBase pSDETreeColBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeColBase.setAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDETreeColBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDETreeColBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDETreeColBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDETreeColBase.setCellPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDETreeColBase.setCellPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDETreeColBase.setColEnableFilter(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSDETreeColBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDETreeColBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDETreeColBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDETreeColBase.setEnableLink(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSDETreeColBase.setGCRPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDETreeColBase.setGCRPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDETreeColBase.setGridColStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDETreeColBase.setGridColType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDETreeColBase.setHeaderPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDETreeColBase.setHeaderPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDETreeColBase.setHideDefault(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSDETreeColBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDETreeColBase.setNoPrivDM(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDETreeColBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDETreeColBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDETreeColBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDETreeColBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDETreeColBase.setPSDETreeColId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDETreeColBase.setPSDETreeColName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDETreeColBase.setPSDETreeViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDETreeColBase.setPSDETreeViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDETreeColBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDETreeColBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDETreeColBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDETreeColBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDETreeColBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDETreeColBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDETreeColBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDETreeColBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDETreeColBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDETreeColBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDETreeColBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDETreeColBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDETreeColBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDETreeColBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 42: {
                pSDETreeColBase.setWidthUnit(DataObject.getStringValue((Object)object));
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
        return PSDETreeColBase.isNull(this, n);
    }

    private static boolean isNull(PSDETreeColBase pSDETreeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeColBase.getAlign() == null;
            }
            case 1: {
                return pSDETreeColBase.getCapPSLanResId() == null;
            }
            case 2: {
                return pSDETreeColBase.getCapPSLanResName() == null;
            }
            case 3: {
                return pSDETreeColBase.getCaption() == null;
            }
            case 4: {
                return pSDETreeColBase.getCellPSSysCssId() == null;
            }
            case 5: {
                return pSDETreeColBase.getCellPSSysCssName() == null;
            }
            case 6: {
                return pSDETreeColBase.getColEnableFilter() == null;
            }
            case 7: {
                return pSDETreeColBase.getCreateDate() == null;
            }
            case 8: {
                return pSDETreeColBase.getCreateMan() == null;
            }
            case 9: {
                return pSDETreeColBase.getDefaultValue() == null;
            }
            case 10: {
                return pSDETreeColBase.getEnableLink() == null;
            }
            case 11: {
                return pSDETreeColBase.getGCRPSSysPFPluginId() == null;
            }
            case 12: {
                return pSDETreeColBase.getGCRPSSysPFPluginName() == null;
            }
            case 13: {
                return pSDETreeColBase.getGridColStyle() == null;
            }
            case 14: {
                return pSDETreeColBase.getGridColType() == null;
            }
            case 15: {
                return pSDETreeColBase.getHeaderPSSysCssId() == null;
            }
            case 16: {
                return pSDETreeColBase.getHeaderPSSysCssName() == null;
            }
            case 17: {
                return pSDETreeColBase.getHideDefault() == null;
            }
            case 18: {
                return pSDETreeColBase.getMemo() == null;
            }
            case 19: {
                return pSDETreeColBase.getNoPrivDM() == null;
            }
            case 20: {
                return pSDETreeColBase.getNoSort() == null;
            }
            case 21: {
                return pSDETreeColBase.getOrderValue() == null;
            }
            case 22: {
                return pSDETreeColBase.getPSCodeListId() == null;
            }
            case 23: {
                return pSDETreeColBase.getPSCodeListName() == null;
            }
            case 24: {
                return pSDETreeColBase.getPSDETreeColId() == null;
            }
            case 25: {
                return pSDETreeColBase.getPSDETreeColName() == null;
            }
            case 26: {
                return pSDETreeColBase.getPSDETreeViewId() == null;
            }
            case 27: {
                return pSDETreeColBase.getPSDETreeViewName() == null;
            }
            case 28: {
                return pSDETreeColBase.getPSDEUAGroupId() == null;
            }
            case 29: {
                return pSDETreeColBase.getPSDEUAGroupName() == null;
            }
            case 30: {
                return pSDETreeColBase.getPSDEUIActionId() == null;
            }
            case 31: {
                return pSDETreeColBase.getPSDEUIActionName() == null;
            }
            case 32: {
                return pSDETreeColBase.getPSSysDynaModelId() == null;
            }
            case 33: {
                return pSDETreeColBase.getPSSysDynaModelName() == null;
            }
            case 34: {
                return pSDETreeColBase.getPSSysImageId() == null;
            }
            case 35: {
                return pSDETreeColBase.getPSSysImageName() == null;
            }
            case 36: {
                return pSDETreeColBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDETreeColBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDETreeColBase.getUserCat() == null;
            }
            case 39: {
                return pSDETreeColBase.getUserTag() == null;
            }
            case 40: {
                return pSDETreeColBase.getUserTag2() == null;
            }
            case 41: {
                return pSDETreeColBase.getWidth() == null;
            }
            case 42: {
                return pSDETreeColBase.getWidthUnit() == null;
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
        return PSDETreeColBase.contains(this, n);
    }

    private static boolean contains(PSDETreeColBase pSDETreeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDETreeColBase.isAlignDirty();
            }
            case 1: {
                return pSDETreeColBase.isCapPSLanResIdDirty();
            }
            case 2: {
                return pSDETreeColBase.isCapPSLanResNameDirty();
            }
            case 3: {
                return pSDETreeColBase.isCaptionDirty();
            }
            case 4: {
                return pSDETreeColBase.isCellPSSysCssIdDirty();
            }
            case 5: {
                return pSDETreeColBase.isCellPSSysCssNameDirty();
            }
            case 6: {
                return pSDETreeColBase.isColEnableFilterDirty();
            }
            case 7: {
                return pSDETreeColBase.isCreateDateDirty();
            }
            case 8: {
                return pSDETreeColBase.isCreateManDirty();
            }
            case 9: {
                return pSDETreeColBase.isDefaultValueDirty();
            }
            case 10: {
                return pSDETreeColBase.isEnableLinkDirty();
            }
            case 11: {
                return pSDETreeColBase.isGCRPSSysPFPluginIdDirty();
            }
            case 12: {
                return pSDETreeColBase.isGCRPSSysPFPluginNameDirty();
            }
            case 13: {
                return pSDETreeColBase.isGridColStyleDirty();
            }
            case 14: {
                return pSDETreeColBase.isGridColTypeDirty();
            }
            case 15: {
                return pSDETreeColBase.isHeaderPSSysCssIdDirty();
            }
            case 16: {
                return pSDETreeColBase.isHeaderPSSysCssNameDirty();
            }
            case 17: {
                return pSDETreeColBase.isHideDefaultDirty();
            }
            case 18: {
                return pSDETreeColBase.isMemoDirty();
            }
            case 19: {
                return pSDETreeColBase.isNoPrivDMDirty();
            }
            case 20: {
                return pSDETreeColBase.isNoSortDirty();
            }
            case 21: {
                return pSDETreeColBase.isOrderValueDirty();
            }
            case 22: {
                return pSDETreeColBase.isPSCodeListIdDirty();
            }
            case 23: {
                return pSDETreeColBase.isPSCodeListNameDirty();
            }
            case 24: {
                return pSDETreeColBase.isPSDETreeColIdDirty();
            }
            case 25: {
                return pSDETreeColBase.isPSDETreeColNameDirty();
            }
            case 26: {
                return pSDETreeColBase.isPSDETreeViewIdDirty();
            }
            case 27: {
                return pSDETreeColBase.isPSDETreeViewNameDirty();
            }
            case 28: {
                return pSDETreeColBase.isPSDEUAGroupIdDirty();
            }
            case 29: {
                return pSDETreeColBase.isPSDEUAGroupNameDirty();
            }
            case 30: {
                return pSDETreeColBase.isPSDEUIActionIdDirty();
            }
            case 31: {
                return pSDETreeColBase.isPSDEUIActionNameDirty();
            }
            case 32: {
                return pSDETreeColBase.isPSSysDynaModelIdDirty();
            }
            case 33: {
                return pSDETreeColBase.isPSSysDynaModelNameDirty();
            }
            case 34: {
                return pSDETreeColBase.isPSSysImageIdDirty();
            }
            case 35: {
                return pSDETreeColBase.isPSSysImageNameDirty();
            }
            case 36: {
                return pSDETreeColBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDETreeColBase.isUpdateManDirty();
            }
            case 38: {
                return pSDETreeColBase.isUserCatDirty();
            }
            case 39: {
                return pSDETreeColBase.isUserTagDirty();
            }
            case 40: {
                return pSDETreeColBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDETreeColBase.isWidthDirty();
            }
            case 42: {
                return pSDETreeColBase.isWidthUnitDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDETreeColBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDETreeColBase pSDETreeColBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDETreeColBase.getAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"align", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getAlign()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCaption()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCellPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCellPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCellPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cellpssyscssname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCellPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getColEnableFilter() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"colenablefilter", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getColEnableFilter()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getEnableLink() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelink", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getEnableLink()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getGCRPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getGCRPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getGCRPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gcrpssyspfpluginname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getGCRPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getGridColStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcolstyle", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getGridColStyle()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getGridColType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"gridcoltype", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getGridColType()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getHeaderPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyscssid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getHeaderPSSysCssId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getHeaderPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headerpssyscssname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getHeaderPSSysCssName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getHideDefault() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"hidedefault", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getHideDefault()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getMemo()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getNoPrivDM() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"noprivdm", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getNoPrivDM()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDETreeColId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDETreeColId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDETreeColName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreecolname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDETreeColName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDETreeViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDETreeViewId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDETreeViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdetreeviewname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDETreeViewName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getWidth()), (boolean)false);
        }
        if (bl || pSDETreeColBase.getWidthUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthunit", (Object)PSDETreeColBase.getJSONValue((Object)pSDETreeColBase.getWidthUnit()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDETreeColBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDETreeColBase pSDETreeColBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDETreeColBase.getAlign() != null) {
            object = pSDETreeColBase.getAlign();
            xmlNode.setAttribute(FIELD_ALIGN, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeColBase.getCapPSLanResId() != null) {
            object = pSDETreeColBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeColBase.getCapPSLanResName() != null) {
            object = pSDETreeColBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeColBase.getCaption() != null) {
            object = pSDETreeColBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeColBase.getCellPSSysCssId() != null) {
            object = pSDETreeColBase.getCellPSSysCssId();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSID, (String)(object == null ? "" : object));
        }
        if (bl || pSDETreeColBase.getCellPSSysCssName() != null) {
            object = pSDETreeColBase.getCellPSSysCssName();
            xmlNode.setAttribute(FIELD_CELLPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getColEnableFilter() != null) {
            object = pSDETreeColBase.getColEnableFilter();
            xmlNode.setAttribute(FIELD_COLENABLEFILTER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getCreateDate() != null) {
            object = pSDETreeColBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeColBase.getCreateMan() != null) {
            object = pSDETreeColBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getDefaultValue() != null) {
            object = pSDETreeColBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getEnableLink() != null) {
            object = pSDETreeColBase.getEnableLink();
            xmlNode.setAttribute(FIELD_ENABLELINK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getGCRPSSysPFPluginId() != null) {
            object = pSDETreeColBase.getGCRPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getGCRPSSysPFPluginName() != null) {
            object = pSDETreeColBase.getGCRPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_GCRPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getGridColStyle() != null) {
            object = pSDETreeColBase.getGridColStyle();
            xmlNode.setAttribute(FIELD_GRIDCOLSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getGridColType() != null) {
            object = pSDETreeColBase.getGridColType();
            xmlNode.setAttribute(FIELD_GRIDCOLTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getHeaderPSSysCssId() != null) {
            object = pSDETreeColBase.getHeaderPSSysCssId();
            xmlNode.setAttribute(FIELD_HEADERPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getHeaderPSSysCssName() != null) {
            object = pSDETreeColBase.getHeaderPSSysCssName();
            xmlNode.setAttribute(FIELD_HEADERPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getHideDefault() != null) {
            object = pSDETreeColBase.getHideDefault();
            xmlNode.setAttribute(FIELD_HIDEDEFAULT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getMemo() != null) {
            object = pSDETreeColBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getNoPrivDM() != null) {
            object = pSDETreeColBase.getNoPrivDM();
            xmlNode.setAttribute(FIELD_NOPRIVDM, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getNoSort() != null) {
            object = pSDETreeColBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getOrderValue() != null) {
            object = pSDETreeColBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getPSCodeListId() != null) {
            object = pSDETreeColBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSCodeListName() != null) {
            object = pSDETreeColBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDETreeColId() != null) {
            object = pSDETreeColBase.getPSDETreeColId();
            xmlNode.setAttribute(FIELD_PSDETREECOLID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDETreeColName() != null) {
            object = pSDETreeColBase.getPSDETreeColName();
            xmlNode.setAttribute(FIELD_PSDETREECOLNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDETreeViewId() != null) {
            object = pSDETreeColBase.getPSDETreeViewId();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDETreeViewName() != null) {
            object = pSDETreeColBase.getPSDETreeViewName();
            xmlNode.setAttribute(FIELD_PSDETREEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDEUAGroupId() != null) {
            object = pSDETreeColBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDEUAGroupName() != null) {
            object = pSDETreeColBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDEUIActionId() != null) {
            object = pSDETreeColBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSDEUIActionName() != null) {
            object = pSDETreeColBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSSysDynaModelId() != null) {
            object = pSDETreeColBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSSysDynaModelName() != null) {
            object = pSDETreeColBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSSysImageId() != null) {
            object = pSDETreeColBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getPSSysImageName() != null) {
            object = pSDETreeColBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getUpdateDate() != null) {
            object = pSDETreeColBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDETreeColBase.getUpdateMan() != null) {
            object = pSDETreeColBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getUserCat() != null) {
            object = pSDETreeColBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getUserTag() != null) {
            object = pSDETreeColBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getUserTag2() != null) {
            object = pSDETreeColBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDETreeColBase.getWidth() != null) {
            object = pSDETreeColBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDETreeColBase.getWidthUnit() != null) {
            object = pSDETreeColBase.getWidthUnit();
            xmlNode.setAttribute(FIELD_WIDTHUNIT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDETreeColBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDETreeColBase pSDETreeColBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDETreeColBase.isAlignDirty() && (bl || pSDETreeColBase.getAlign() != null)) {
            iDataObject.set(FIELD_ALIGN, (Object)pSDETreeColBase.getAlign());
        }
        if (pSDETreeColBase.isCapPSLanResIdDirty() && (bl || pSDETreeColBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDETreeColBase.getCapPSLanResId());
        }
        if (pSDETreeColBase.isCapPSLanResNameDirty() && (bl || pSDETreeColBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDETreeColBase.getCapPSLanResName());
        }
        if (pSDETreeColBase.isCaptionDirty() && (bl || pSDETreeColBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDETreeColBase.getCaption());
        }
        if (pSDETreeColBase.isCellPSSysCssIdDirty() && (bl || pSDETreeColBase.getCellPSSysCssId() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSID, (Object)pSDETreeColBase.getCellPSSysCssId());
        }
        if (pSDETreeColBase.isCellPSSysCssNameDirty() && (bl || pSDETreeColBase.getCellPSSysCssName() != null)) {
            iDataObject.set(FIELD_CELLPSSYSCSSNAME, (Object)pSDETreeColBase.getCellPSSysCssName());
        }
        if (pSDETreeColBase.isColEnableFilterDirty() && (bl || pSDETreeColBase.getColEnableFilter() != null)) {
            iDataObject.set(FIELD_COLENABLEFILTER, (Object)pSDETreeColBase.getColEnableFilter());
        }
        if (pSDETreeColBase.isCreateDateDirty() && (bl || pSDETreeColBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDETreeColBase.getCreateDate());
        }
        if (pSDETreeColBase.isCreateManDirty() && (bl || pSDETreeColBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDETreeColBase.getCreateMan());
        }
        if (pSDETreeColBase.isDefaultValueDirty() && (bl || pSDETreeColBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSDETreeColBase.getDefaultValue());
        }
        if (pSDETreeColBase.isEnableLinkDirty() && (bl || pSDETreeColBase.getEnableLink() != null)) {
            iDataObject.set(FIELD_ENABLELINK, (Object)pSDETreeColBase.getEnableLink());
        }
        if (pSDETreeColBase.isGCRPSSysPFPluginIdDirty() && (bl || pSDETreeColBase.getGCRPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINID, (Object)pSDETreeColBase.getGCRPSSysPFPluginId());
        }
        if (pSDETreeColBase.isGCRPSSysPFPluginNameDirty() && (bl || pSDETreeColBase.getGCRPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_GCRPSSYSPFPLUGINNAME, (Object)pSDETreeColBase.getGCRPSSysPFPluginName());
        }
        if (pSDETreeColBase.isGridColStyleDirty() && (bl || pSDETreeColBase.getGridColStyle() != null)) {
            iDataObject.set(FIELD_GRIDCOLSTYLE, (Object)pSDETreeColBase.getGridColStyle());
        }
        if (pSDETreeColBase.isGridColTypeDirty() && (bl || pSDETreeColBase.getGridColType() != null)) {
            iDataObject.set(FIELD_GRIDCOLTYPE, (Object)pSDETreeColBase.getGridColType());
        }
        if (pSDETreeColBase.isHeaderPSSysCssIdDirty() && (bl || pSDETreeColBase.getHeaderPSSysCssId() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSCSSID, (Object)pSDETreeColBase.getHeaderPSSysCssId());
        }
        if (pSDETreeColBase.isHeaderPSSysCssNameDirty() && (bl || pSDETreeColBase.getHeaderPSSysCssName() != null)) {
            iDataObject.set(FIELD_HEADERPSSYSCSSNAME, (Object)pSDETreeColBase.getHeaderPSSysCssName());
        }
        if (pSDETreeColBase.isHideDefaultDirty() && (bl || pSDETreeColBase.getHideDefault() != null)) {
            iDataObject.set(FIELD_HIDEDEFAULT, (Object)pSDETreeColBase.getHideDefault());
        }
        if (pSDETreeColBase.isMemoDirty() && (bl || pSDETreeColBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDETreeColBase.getMemo());
        }
        if (pSDETreeColBase.isNoPrivDMDirty() && (bl || pSDETreeColBase.getNoPrivDM() != null)) {
            iDataObject.set(FIELD_NOPRIVDM, (Object)pSDETreeColBase.getNoPrivDM());
        }
        if (pSDETreeColBase.isNoSortDirty() && (bl || pSDETreeColBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDETreeColBase.getNoSort());
        }
        if (pSDETreeColBase.isOrderValueDirty() && (bl || pSDETreeColBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDETreeColBase.getOrderValue());
        }
        if (pSDETreeColBase.isPSCodeListIdDirty() && (bl || pSDETreeColBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDETreeColBase.getPSCodeListId());
        }
        if (pSDETreeColBase.isPSCodeListNameDirty() && (bl || pSDETreeColBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDETreeColBase.getPSCodeListName());
        }
        if (pSDETreeColBase.isPSDETreeColIdDirty() && (bl || pSDETreeColBase.getPSDETreeColId() != null)) {
            iDataObject.set(FIELD_PSDETREECOLID, (Object)pSDETreeColBase.getPSDETreeColId());
        }
        if (pSDETreeColBase.isPSDETreeColNameDirty() && (bl || pSDETreeColBase.getPSDETreeColName() != null)) {
            iDataObject.set(FIELD_PSDETREECOLNAME, (Object)pSDETreeColBase.getPSDETreeColName());
        }
        if (pSDETreeColBase.isPSDETreeViewIdDirty() && (bl || pSDETreeColBase.getPSDETreeViewId() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWID, (Object)pSDETreeColBase.getPSDETreeViewId());
        }
        if (pSDETreeColBase.isPSDETreeViewNameDirty() && (bl || pSDETreeColBase.getPSDETreeViewName() != null)) {
            iDataObject.set(FIELD_PSDETREEVIEWNAME, (Object)pSDETreeColBase.getPSDETreeViewName());
        }
        if (pSDETreeColBase.isPSDEUAGroupIdDirty() && (bl || pSDETreeColBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDETreeColBase.getPSDEUAGroupId());
        }
        if (pSDETreeColBase.isPSDEUAGroupNameDirty() && (bl || pSDETreeColBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDETreeColBase.getPSDEUAGroupName());
        }
        if (pSDETreeColBase.isPSDEUIActionIdDirty() && (bl || pSDETreeColBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDETreeColBase.getPSDEUIActionId());
        }
        if (pSDETreeColBase.isPSDEUIActionNameDirty() && (bl || pSDETreeColBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDETreeColBase.getPSDEUIActionName());
        }
        if (pSDETreeColBase.isPSSysDynaModelIdDirty() && (bl || pSDETreeColBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDETreeColBase.getPSSysDynaModelId());
        }
        if (pSDETreeColBase.isPSSysDynaModelNameDirty() && (bl || pSDETreeColBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDETreeColBase.getPSSysDynaModelName());
        }
        if (pSDETreeColBase.isPSSysImageIdDirty() && (bl || pSDETreeColBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDETreeColBase.getPSSysImageId());
        }
        if (pSDETreeColBase.isPSSysImageNameDirty() && (bl || pSDETreeColBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDETreeColBase.getPSSysImageName());
        }
        if (pSDETreeColBase.isUpdateDateDirty() && (bl || pSDETreeColBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDETreeColBase.getUpdateDate());
        }
        if (pSDETreeColBase.isUpdateManDirty() && (bl || pSDETreeColBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDETreeColBase.getUpdateMan());
        }
        if (pSDETreeColBase.isUserCatDirty() && (bl || pSDETreeColBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDETreeColBase.getUserCat());
        }
        if (pSDETreeColBase.isUserTagDirty() && (bl || pSDETreeColBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDETreeColBase.getUserTag());
        }
        if (pSDETreeColBase.isUserTag2Dirty() && (bl || pSDETreeColBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDETreeColBase.getUserTag2());
        }
        if (pSDETreeColBase.isWidthDirty() && (bl || pSDETreeColBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDETreeColBase.getWidth());
        }
        if (pSDETreeColBase.isWidthUnitDirty() && (bl || pSDETreeColBase.getWidthUnit() != null)) {
            iDataObject.set(FIELD_WIDTHUNIT, (Object)pSDETreeColBase.getWidthUnit());
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
        return PSDETreeColBase.remove(this, n);
    }

    private static boolean remove(PSDETreeColBase pSDETreeColBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDETreeColBase.resetAlign();
                return true;
            }
            case 1: {
                pSDETreeColBase.resetCapPSLanResId();
                return true;
            }
            case 2: {
                pSDETreeColBase.resetCapPSLanResName();
                return true;
            }
            case 3: {
                pSDETreeColBase.resetCaption();
                return true;
            }
            case 4: {
                pSDETreeColBase.resetCellPSSysCssId();
                return true;
            }
            case 5: {
                pSDETreeColBase.resetCellPSSysCssName();
                return true;
            }
            case 6: {
                pSDETreeColBase.resetColEnableFilter();
                return true;
            }
            case 7: {
                pSDETreeColBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDETreeColBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDETreeColBase.resetDefaultValue();
                return true;
            }
            case 10: {
                pSDETreeColBase.resetEnableLink();
                return true;
            }
            case 11: {
                pSDETreeColBase.resetGCRPSSysPFPluginId();
                return true;
            }
            case 12: {
                pSDETreeColBase.resetGCRPSSysPFPluginName();
                return true;
            }
            case 13: {
                pSDETreeColBase.resetGridColStyle();
                return true;
            }
            case 14: {
                pSDETreeColBase.resetGridColType();
                return true;
            }
            case 15: {
                pSDETreeColBase.resetHeaderPSSysCssId();
                return true;
            }
            case 16: {
                pSDETreeColBase.resetHeaderPSSysCssName();
                return true;
            }
            case 17: {
                pSDETreeColBase.resetHideDefault();
                return true;
            }
            case 18: {
                pSDETreeColBase.resetMemo();
                return true;
            }
            case 19: {
                pSDETreeColBase.resetNoPrivDM();
                return true;
            }
            case 20: {
                pSDETreeColBase.resetNoSort();
                return true;
            }
            case 21: {
                pSDETreeColBase.resetOrderValue();
                return true;
            }
            case 22: {
                pSDETreeColBase.resetPSCodeListId();
                return true;
            }
            case 23: {
                pSDETreeColBase.resetPSCodeListName();
                return true;
            }
            case 24: {
                pSDETreeColBase.resetPSDETreeColId();
                return true;
            }
            case 25: {
                pSDETreeColBase.resetPSDETreeColName();
                return true;
            }
            case 26: {
                pSDETreeColBase.resetPSDETreeViewId();
                return true;
            }
            case 27: {
                pSDETreeColBase.resetPSDETreeViewName();
                return true;
            }
            case 28: {
                pSDETreeColBase.resetPSDEUAGroupId();
                return true;
            }
            case 29: {
                pSDETreeColBase.resetPSDEUAGroupName();
                return true;
            }
            case 30: {
                pSDETreeColBase.resetPSDEUIActionId();
                return true;
            }
            case 31: {
                pSDETreeColBase.resetPSDEUIActionName();
                return true;
            }
            case 32: {
                pSDETreeColBase.resetPSSysDynaModelId();
                return true;
            }
            case 33: {
                pSDETreeColBase.resetPSSysDynaModelName();
                return true;
            }
            case 34: {
                pSDETreeColBase.resetPSSysImageId();
                return true;
            }
            case 35: {
                pSDETreeColBase.resetPSSysImageName();
                return true;
            }
            case 36: {
                pSDETreeColBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDETreeColBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDETreeColBase.resetUserCat();
                return true;
            }
            case 39: {
                pSDETreeColBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDETreeColBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDETreeColBase.resetWidth();
                return true;
            }
            case 42: {
                pSDETreeColBase.resetWidthUnit();
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
                pSCodeListService.autoGet(pSCodeList);
                this.pscodelist = pSCodeList;
            }
            return this.pscodelist;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDETreeView getPSDETreeView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDETreeView();
        }
        if (this.getPSDETreeViewId() == null) {
            return null;
        }
        Integer n = this.objPSDETreeViewLock;
        synchronized (n) {
            if (this.psdetreeview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDETreeViewId(), (Object)this.psdetreeview.getPSDETreeViewId()) != 0L) {
                this.psdetreeview = null;
            }
            if (this.psdetreeview == null) {
                PSDETreeView pSDETreeView = new PSDETreeView();
                pSDETreeView.setPSDETreeViewId(this.getPSDETreeViewId());
                PSDETreeViewService pSDETreeViewService = (PSDETreeViewService)ServiceGlobal.getService(PSDETreeViewService.class, (SessionFactory)this.getSessionFactory());
                pSDETreeViewService.autoGet(pSDETreeView);
                this.psdetreeview = pSDETreeView;
            }
            return this.psdetreeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGroup();
        }
        if (this.getPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAGroupLock;
        synchronized (n) {
            if (this.psdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUAGroupId(), (Object)this.psdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.psdeuagroup = null;
            }
            if (this.psdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUIAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUIAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUIActionLock;
        synchronized (n) {
            if (this.psdeuiaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuiaction.getPSDEUIActionId()) != 0L) {
                this.psdeuiaction = null;
            }
            if (this.psdeuiaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet(pSDEUIAction);
                this.psdeuiaction = pSDEUIAction;
            }
            return this.psdeuiaction;
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
                pSLanguageResService.autoGet(pSLanguageRes);
                this.cappslanres = pSLanguageRes;
            }
            return this.cappslanres;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getCellPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCellPSSysCss();
        }
        if (this.getCellPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objCellPSSysCssLock;
        synchronized (n) {
            if (this.cellpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getCellPSSysCssId(), (Object)this.cellpssyscss.getPSSysCssId()) != 0L) {
                this.cellpssyscss = null;
            }
            if (this.cellpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getCellPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.cellpssyscss = pSSysCss;
            }
            return this.cellpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getHeaderPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderPSSysCss();
        }
        if (this.getHeaderPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objHeaderPSSysCssLock;
        synchronized (n) {
            if (this.headerpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getHeaderPSSysCssId(), (Object)this.headerpssyscss.getPSSysCssId()) != 0L) {
                this.headerpssyscss = null;
            }
            if (this.headerpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getHeaderPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet(pSSysCss);
                this.headerpssyscss = pSSysCss;
            }
            return this.headerpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysDynaModel getPSSysDynaModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysDynaModel();
        }
        if (this.getPSSysDynaModelId() == null) {
            return null;
        }
        Integer n = this.objPSSysDynaModelLock;
        synchronized (n) {
            if (this.pssysdynamodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysDynaModelId(), (Object)this.pssysdynamodel.getPSSysDynaModelId()) != 0L) {
                this.pssysdynamodel = null;
            }
            if (this.pssysdynamodel == null) {
                PSSysDynaModel pSSysDynaModel = new PSSysDynaModel();
                pSSysDynaModel.setPSSysDynaModelId(this.getPSSysDynaModelId());
                PSSysDynaModelService pSSysDynaModelService = (PSSysDynaModelService)ServiceGlobal.getService(PSSysDynaModelService.class, (SessionFactory)this.getSessionFactory());
                pSSysDynaModelService.autoGet(pSSysDynaModel);
                this.pssysdynamodel = pSSysDynaModel;
            }
            return this.pssysdynamodel;
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
    public PSSysPFPlugin getGCRPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGCRPSSysPFPlugin();
        }
        if (this.getGCRPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objGCRPSSysPFPluginLock;
        synchronized (n) {
            if (this.gcrpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getGCRPSSysPFPluginId(), (Object)this.gcrpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.gcrpssyspfplugin = null;
            }
            if (this.gcrpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getGCRPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.gcrpssyspfplugin = pSSysPFPlugin;
            }
            return this.gcrpssyspfplugin;
        }
    }

    private PSDETreeColBase getProxyEntity() {
        return this.proxyPSDETreeColBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDETreeColBase = null;
        if (iDataObject != null && iDataObject instanceof PSDETreeColBase) {
            this.proxyPSDETreeColBase = (PSDETreeColBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDETreeColService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALIGN, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSID, 4);
        fieldIndexMap.put(FIELD_CELLPSSYSCSSNAME, 5);
        fieldIndexMap.put(FIELD_COLENABLEFILTER, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 9);
        fieldIndexMap.put(FIELD_ENABLELINK, 10);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINID, 11);
        fieldIndexMap.put(FIELD_GCRPSSYSPFPLUGINNAME, 12);
        fieldIndexMap.put(FIELD_GRIDCOLSTYLE, 13);
        fieldIndexMap.put(FIELD_GRIDCOLTYPE, 14);
        fieldIndexMap.put(FIELD_HEADERPSSYSCSSID, 15);
        fieldIndexMap.put(FIELD_HEADERPSSYSCSSNAME, 16);
        fieldIndexMap.put(FIELD_HIDEDEFAULT, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_NOPRIVDM, 19);
        fieldIndexMap.put(FIELD_NOSORT, 20);
        fieldIndexMap.put(FIELD_ORDERVALUE, 21);
        fieldIndexMap.put(FIELD_PSCODELISTID, 22);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 23);
        fieldIndexMap.put(FIELD_PSDETREECOLID, 24);
        fieldIndexMap.put(FIELD_PSDETREECOLNAME, 25);
        fieldIndexMap.put(FIELD_PSDETREEVIEWID, 26);
        fieldIndexMap.put(FIELD_PSDETREEVIEWNAME, 27);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 28);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 29);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 30);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 31);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 32);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 33);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 34);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_WIDTH, 41);
        fieldIndexMap.put(FIELD_WIDTHUNIT, 42);
    }
}

