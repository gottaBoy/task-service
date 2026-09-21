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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataView;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEList;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataViewService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEListService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSCodeList;
import net.ibizsys.pscore.srv.sysdesign.entity.PSLanguageRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSCodeListService;
import net.ibizsys.pscore.srv.sysdesign.service.PSLanguageResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEListItemBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEListItemBase.class);
    public static final String FIELD_ALIGN = "ALIGN";
    public static final String FIELD_CAPPSLANRESID = "CAPPSLANRESID";
    public static final String FIELD_CAPPSLANRESNAME = "CAPPSLANRESNAME";
    public static final String FIELD_CAPTION = "CAPTION";
    public static final String FIELD_CLCONVERTMODE = "CLCONVERTMODE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DATAITEMS = "DATAITEMS";
    public static final String FIELD_DATAVIEWPSDEID = "DATAVIEWPSDEID";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLEITEMPRIV = "ENABLEITEMPRIV";
    public static final String FIELD_GROUPITEM = "GROUPITEM";
    public static final String FIELD_ITEMTYPE = "ITEMTYPE";
    public static final String FIELD_LCRPSSYSPFPLUGINID = "LCRPSSYSPFPLUGINID";
    public static final String FIELD_LCRPSSYSPFPLUGINNAME = "LCRPSSYSPFPLUGINNAME";
    public static final String FIELD_LISTPSDEID = "LISTPSDEID";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NOSORT = "NOSORT";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PREDEFINEDTYPE = "PREDEFINEDTYPE";
    public static final String FIELD_PREDEFINEDTYPETEXT = "PREDEFINEDTYPETEXT";
    public static final String FIELD_PREVENTXSS = "PREVENTXSS";
    public static final String FIELD_PSCODELISTID = "PSCODELISTID";
    public static final String FIELD_PSCODELISTNAME = "PSCODELISTNAME";
    public static final String FIELD_PSDEDATAVIEWID = "PSDEDATAVIEWID";
    public static final String FIELD_PSDEDATAVIEWNAME = "PSDEDATAVIEWNAME";
    public static final String FIELD_PSDELISTID = "PSDELISTID";
    public static final String FIELD_PSDELISTITEMID = "PSDELISTITEMID";
    public static final String FIELD_PSDELISTITEMNAME = "PSDELISTITEMNAME";
    public static final String FIELD_PSDELISTNAME = "PSDELISTNAME";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_RENDERMODE = "RENDERMODE";
    public static final String FIELD_RENDERMODETEXT = "RENDERMODETEXT";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_VALUEFORMAT = "VALUEFORMAT";
    public static final String FIELD_WIDTH = "WIDTH";
    public static final String FIELD_WIDTHUNIT = "WIDTHUNIT";
    private static final int INDEX_ALIGN = 0;
    private static final int INDEX_CAPPSLANRESID = 1;
    private static final int INDEX_CAPPSLANRESNAME = 2;
    private static final int INDEX_CAPTION = 3;
    private static final int INDEX_CLCONVERTMODE = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMMODE = 8;
    private static final int INDEX_DATAITEMS = 9;
    private static final int INDEX_DATAVIEWPSDEID = 10;
    private static final int INDEX_DYNAMODELFLAG = 11;
    private static final int INDEX_ENABLEITEMPRIV = 12;
    private static final int INDEX_GROUPITEM = 13;
    private static final int INDEX_ITEMTYPE = 14;
    private static final int INDEX_LCRPSSYSPFPLUGINID = 15;
    private static final int INDEX_LCRPSSYSPFPLUGINNAME = 16;
    private static final int INDEX_LISTPSDEID = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_NOSORT = 19;
    private static final int INDEX_ORDERVALUE = 20;
    private static final int INDEX_PREDEFINEDTYPE = 21;
    private static final int INDEX_PREDEFINEDTYPETEXT = 22;
    private static final int INDEX_PREVENTXSS = 23;
    private static final int INDEX_PSCODELISTID = 24;
    private static final int INDEX_PSCODELISTNAME = 25;
    private static final int INDEX_PSDEDATAVIEWID = 26;
    private static final int INDEX_PSDEDATAVIEWNAME = 27;
    private static final int INDEX_PSDELISTID = 28;
    private static final int INDEX_PSDELISTITEMID = 29;
    private static final int INDEX_PSDELISTITEMNAME = 30;
    private static final int INDEX_PSDELISTNAME = 31;
    private static final int INDEX_PSDEUAGROUPID = 32;
    private static final int INDEX_PSDEUAGROUPNAME = 33;
    private static final int INDEX_PSDYNAINSTID = 34;
    private static final int INDEX_RENDERMODE = 35;
    private static final int INDEX_RENDERMODETEXT = 36;
    private static final int INDEX_UPDATEDATE = 37;
    private static final int INDEX_UPDATEMAN = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_VALUEFORMAT = 41;
    private static final int INDEX_WIDTH = 42;
    private static final int INDEX_WIDTHUNIT = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEListItemBase proxyPSDEListItemBase = null;
    private boolean alignDirtyFlag = false;
    private boolean cappslanresidDirtyFlag = false;
    private boolean cappslanresnameDirtyFlag = false;
    private boolean captionDirtyFlag = false;
    private boolean clconvertmodeDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean dataitemsDirtyFlag = false;
    private boolean dataviewpsdeidDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enableitemprivDirtyFlag = false;
    private boolean groupitemDirtyFlag = false;
    private boolean itemtypeDirtyFlag = false;
    private boolean lcrpssyspfpluginidDirtyFlag = false;
    private boolean lcrpssyspfpluginnameDirtyFlag = false;
    private boolean listpsdeidDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nosortDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean predefinedtypeDirtyFlag = false;
    private boolean predefinedtypetextDirtyFlag = false;
    private boolean preventxssDirtyFlag = false;
    private boolean pscodelistidDirtyFlag = false;
    private boolean pscodelistnameDirtyFlag = false;
    private boolean psdedataviewidDirtyFlag = false;
    private boolean psdedataviewnameDirtyFlag = false;
    private boolean psdelistidDirtyFlag = false;
    private boolean psdelistitemidDirtyFlag = false;
    private boolean psdelistitemnameDirtyFlag = false;
    private boolean psdelistnameDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean rendermodeDirtyFlag = false;
    private boolean rendermodetextDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean valueformatDirtyFlag = false;
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
    @Column(name="clconvertmode")
    private String clconvertmode;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="dataitems")
    private String dataitems;
    @Column(name="dataviewpsdeid")
    private String dataviewpsdeid;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enableitempriv")
    private Integer enableitempriv;
    @Column(name="groupitem")
    private String groupitem;
    @Column(name="itemtype")
    private String itemtype;
    @Column(name="lcrpssyspfpluginid")
    private String lcrpssyspfpluginid;
    @Column(name="lcrpssyspfpluginname")
    private String lcrpssyspfpluginname;
    @Column(name="listpsdeid")
    private String listpsdeid;
    @Column(name="memo")
    private String memo;
    @Column(name="nosort")
    private Integer nosort;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="predefinedtype")
    private String predefinedtype;
    @Column(name="predefinedtypetext")
    private String predefinedtypetext;
    @Column(name="preventxss")
    private Integer preventxss;
    @Column(name="pscodelistid")
    private String pscodelistid;
    @Column(name="pscodelistname")
    private String pscodelistname;
    @Column(name="psdedataviewid")
    private String psdedataviewid;
    @Column(name="psdedataviewname")
    private String psdedataviewname;
    @Column(name="psdelistid")
    private String psdelistid;
    @Column(name="psdelistitemid")
    private String psdelistitemid;
    @Column(name="psdelistitemname")
    private String psdelistitemname;
    @Column(name="psdelistname")
    private String psdelistname;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="rendermode")
    private String rendermode;
    @Column(name="rendermodetext")
    private String rendermodetext;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;
    @Column(name="valueformat")
    private String valueformat;
    @Column(name="width")
    private Integer width;
    @Column(name="widthunit")
    private String widthunit;
    private Integer objPSCodeListLock = new Integer(1);
    private PSCodeList pscodelist = null;
    private Integer objPSDEDataViewLock = new Integer(1);
    private PSDEDataView psdedataview = null;
    private Integer objPSDEListLock = new Integer(1);
    private PSDEList psdelist = null;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objCapPSLanResLock = new Integer(1);
    private PSLanguageRes cappslanres = null;
    private Integer objLCRPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin lcrpssyspfplugin = null;

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

    public void setCLConvertMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCLConvertMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.clconvertmode = string;
        this.clconvertmodeDirtyFlag = true;
    }

    public String getCLConvertMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCLConvertMode();
        }
        return this.clconvertmode;
    }

    public boolean isCLConvertModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCLConvertModeDirty();
        }
        return this.clconvertmodeDirtyFlag;
    }

    public void resetCLConvertMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCLConvertMode();
            return;
        }
        this.clconvertmodeDirtyFlag = false;
        this.clconvertmode = null;
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

    public void setDataItems(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataItems(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataitems = string;
        this.dataitemsDirtyFlag = true;
    }

    public String getDataItems() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataItems();
        }
        return this.dataitems;
    }

    public boolean isDataItemsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataItemsDirty();
        }
        return this.dataitemsDirtyFlag;
    }

    public void resetDataItems() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataItems();
            return;
        }
        this.dataitemsDirtyFlag = false;
        this.dataitems = null;
    }

    public void setDataViewPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataViewPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dataviewpsdeid = string;
        this.dataviewpsdeidDirtyFlag = true;
    }

    public String getDataViewPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataViewPSDEId();
        }
        return this.dataviewpsdeid;
    }

    public boolean isDataViewPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataViewPSDEIdDirty();
        }
        return this.dataviewpsdeidDirtyFlag;
    }

    public void resetDataViewPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataViewPSDEId();
            return;
        }
        this.dataviewpsdeidDirtyFlag = false;
        this.dataviewpsdeid = null;
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

    public void setEnableItemPriv(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableItemPriv(n);
            return;
        }
        this.enableitempriv = n;
        this.enableitemprivDirtyFlag = true;
    }

    public Integer getEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableItemPriv();
        }
        return this.enableitempriv;
    }

    public boolean isEnableItemPrivDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableItemPrivDirty();
        }
        return this.enableitemprivDirtyFlag;
    }

    public void resetEnableItemPriv() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableItemPriv();
            return;
        }
        this.enableitemprivDirtyFlag = false;
        this.enableitempriv = null;
    }

    public void setGroupItem(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setGroupItem(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.groupitem = string;
        this.groupitemDirtyFlag = true;
    }

    public String getGroupItem() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getGroupItem();
        }
        return this.groupitem;
    }

    public boolean isGroupItemDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isGroupItemDirty();
        }
        return this.groupitemDirtyFlag;
    }

    public void resetGroupItem() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetGroupItem();
            return;
        }
        this.groupitemDirtyFlag = false;
        this.groupitem = null;
    }

    public void setItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.itemtype = string;
        this.itemtypeDirtyFlag = true;
    }

    public String getItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getItemType();
        }
        return this.itemtype;
    }

    public boolean isItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isItemTypeDirty();
        }
        return this.itemtypeDirtyFlag;
    }

    public void resetItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetItemType();
            return;
        }
        this.itemtypeDirtyFlag = false;
        this.itemtype = null;
    }

    public void setLCRPSSysPFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLCRPSSysPFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lcrpssyspfpluginid = string;
        this.lcrpssyspfpluginidDirtyFlag = true;
    }

    public String getLCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLCRPSSysPFPluginId();
        }
        return this.lcrpssyspfpluginid;
    }

    public boolean isLCRPSSysPFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLCRPSSysPFPluginIdDirty();
        }
        return this.lcrpssyspfpluginidDirtyFlag;
    }

    public void resetLCRPSSysPFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLCRPSSysPFPluginId();
            return;
        }
        this.lcrpssyspfpluginidDirtyFlag = false;
        this.lcrpssyspfpluginid = null;
    }

    public void setLCRPSSysPFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLCRPSSysPFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.lcrpssyspfpluginname = string;
        this.lcrpssyspfpluginnameDirtyFlag = true;
    }

    public String getLCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLCRPSSysPFPluginName();
        }
        return this.lcrpssyspfpluginname;
    }

    public boolean isLCRPSSysPFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLCRPSSysPFPluginNameDirty();
        }
        return this.lcrpssyspfpluginnameDirtyFlag;
    }

    public void resetLCRPSSysPFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLCRPSSysPFPluginName();
            return;
        }
        this.lcrpssyspfpluginnameDirtyFlag = false;
        this.lcrpssyspfpluginname = null;
    }

    public void setListPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setListPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.listpsdeid = string;
        this.listpsdeidDirtyFlag = true;
    }

    public String getListPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getListPSDEId();
        }
        return this.listpsdeid;
    }

    public boolean isListPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isListPSDEIdDirty();
        }
        return this.listpsdeidDirtyFlag;
    }

    public void resetListPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetListPSDEId();
            return;
        }
        this.listpsdeidDirtyFlag = false;
        this.listpsdeid = null;
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

    public void setPredefinedType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtype = string;
        this.predefinedtypeDirtyFlag = true;
    }

    public String getPredefinedType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedType();
        }
        return this.predefinedtype;
    }

    public boolean isPredefinedTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeDirty();
        }
        return this.predefinedtypeDirtyFlag;
    }

    public void resetPredefinedType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedType();
            return;
        }
        this.predefinedtypeDirtyFlag = false;
        this.predefinedtype = null;
    }

    public void setPredefinedTypeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPredefinedTypeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.predefinedtypetext = string;
        this.predefinedtypetextDirtyFlag = true;
    }

    public String getPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPredefinedTypeText();
        }
        return this.predefinedtypetext;
    }

    public boolean isPredefinedTypeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPredefinedTypeTextDirty();
        }
        return this.predefinedtypetextDirtyFlag;
    }

    public void resetPredefinedTypeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPredefinedTypeText();
            return;
        }
        this.predefinedtypetextDirtyFlag = false;
        this.predefinedtypetext = null;
    }

    public void setPreventXSS(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPreventXSS(n);
            return;
        }
        this.preventxss = n;
        this.preventxssDirtyFlag = true;
    }

    public Integer getPreventXSS() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPreventXSS();
        }
        return this.preventxss;
    }

    public boolean isPreventXSSDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPreventXSSDirty();
        }
        return this.preventxssDirtyFlag;
    }

    public void resetPreventXSS() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPreventXSS();
            return;
        }
        this.preventxssDirtyFlag = false;
        this.preventxss = null;
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

    public void setPSDEDataViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewid = string;
        this.psdedataviewidDirtyFlag = true;
    }

    public String getPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewId();
        }
        return this.psdedataviewid;
    }

    public boolean isPSDEDataViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewIdDirty();
        }
        return this.psdedataviewidDirtyFlag;
    }

    public void resetPSDEDataViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewId();
            return;
        }
        this.psdedataviewidDirtyFlag = false;
        this.psdedataviewid = null;
    }

    public void setPSDEDataViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataviewname = string;
        this.psdedataviewnameDirtyFlag = true;
    }

    public String getPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataViewName();
        }
        return this.psdedataviewname;
    }

    public boolean isPSDEDataViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataViewNameDirty();
        }
        return this.psdedataviewnameDirtyFlag;
    }

    public void resetPSDEDataViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataViewName();
            return;
        }
        this.psdedataviewnameDirtyFlag = false;
        this.psdedataviewname = null;
    }

    public void setPSDEListId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistid = string;
        this.psdelistidDirtyFlag = true;
    }

    public String getPSDEListId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListId();
        }
        return this.psdelistid;
    }

    public boolean isPSDEListIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListIdDirty();
        }
        return this.psdelistidDirtyFlag;
    }

    public void resetPSDEListId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListId();
            return;
        }
        this.psdelistidDirtyFlag = false;
        this.psdelistid = null;
    }

    public void setPSDEListItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistitemid = string;
        this.psdelistitemidDirtyFlag = true;
    }

    public String getPSDEListItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItemId();
        }
        return this.psdelistitemid;
    }

    public boolean isPSDEListItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListItemIdDirty();
        }
        return this.psdelistitemidDirtyFlag;
    }

    public void resetPSDEListItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListItemId();
            return;
        }
        this.psdelistitemidDirtyFlag = false;
        this.psdelistitemid = null;
    }

    public void setPSDEListItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistitemname = string;
        this.psdelistitemnameDirtyFlag = true;
    }

    public String getPSDEListItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListItemName();
        }
        return this.psdelistitemname;
    }

    public boolean isPSDEListItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListItemNameDirty();
        }
        return this.psdelistitemnameDirtyFlag;
    }

    public void resetPSDEListItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListItemName();
            return;
        }
        this.psdelistitemnameDirtyFlag = false;
        this.psdelistitemname = null;
    }

    public void setPSDEListName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEListName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdelistname = string;
        this.psdelistnameDirtyFlag = true;
    }

    public String getPSDEListName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEListName();
        }
        return this.psdelistname;
    }

    public boolean isPSDEListNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEListNameDirty();
        }
        return this.psdelistnameDirtyFlag;
    }

    public void resetPSDEListName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEListName();
            return;
        }
        this.psdelistnameDirtyFlag = false;
        this.psdelistname = null;
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

    public void setRenderMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermode = string;
        this.rendermodeDirtyFlag = true;
    }

    public String getRenderMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderMode();
        }
        return this.rendermode;
    }

    public boolean isRenderModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeDirty();
        }
        return this.rendermodeDirtyFlag;
    }

    public void resetRenderMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderMode();
            return;
        }
        this.rendermodeDirtyFlag = false;
        this.rendermode = null;
    }

    public void setRenderModeText(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRenderModeText(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.rendermodetext = string;
        this.rendermodetextDirtyFlag = true;
    }

    public String getRenderModeText() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRenderModeText();
        }
        return this.rendermodetext;
    }

    public boolean isRenderModeTextDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRenderModeTextDirty();
        }
        return this.rendermodetextDirtyFlag;
    }

    public void resetRenderModeText() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRenderModeText();
            return;
        }
        this.rendermodetextDirtyFlag = false;
        this.rendermodetext = null;
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
        PSDEListItemBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEListItemBase pSDEListItemBase) {
        pSDEListItemBase.resetAlign();
        pSDEListItemBase.resetCapPSLanResId();
        pSDEListItemBase.resetCapPSLanResName();
        pSDEListItemBase.resetCaption();
        pSDEListItemBase.resetCLConvertMode();
        pSDEListItemBase.resetCreateDate();
        pSDEListItemBase.resetCreateMan();
        pSDEListItemBase.resetCustomCode();
        pSDEListItemBase.resetCustomMode();
        pSDEListItemBase.resetDataItems();
        pSDEListItemBase.resetDataViewPSDEId();
        pSDEListItemBase.resetDynaModelFlag();
        pSDEListItemBase.resetEnableItemPriv();
        pSDEListItemBase.resetGroupItem();
        pSDEListItemBase.resetItemType();
        pSDEListItemBase.resetLCRPSSysPFPluginId();
        pSDEListItemBase.resetLCRPSSysPFPluginName();
        pSDEListItemBase.resetListPSDEId();
        pSDEListItemBase.resetMemo();
        pSDEListItemBase.resetNoSort();
        pSDEListItemBase.resetOrderValue();
        pSDEListItemBase.resetPredefinedType();
        pSDEListItemBase.resetPredefinedTypeText();
        pSDEListItemBase.resetPreventXSS();
        pSDEListItemBase.resetPSCodeListId();
        pSDEListItemBase.resetPSCodeListName();
        pSDEListItemBase.resetPSDEDataViewId();
        pSDEListItemBase.resetPSDEDataViewName();
        pSDEListItemBase.resetPSDEListId();
        pSDEListItemBase.resetPSDEListItemId();
        pSDEListItemBase.resetPSDEListItemName();
        pSDEListItemBase.resetPSDEListName();
        pSDEListItemBase.resetPSDEUAGroupId();
        pSDEListItemBase.resetPSDEUAGroupName();
        pSDEListItemBase.resetPSDynaInstId();
        pSDEListItemBase.resetRenderMode();
        pSDEListItemBase.resetRenderModeText();
        pSDEListItemBase.resetUpdateDate();
        pSDEListItemBase.resetUpdateMan();
        pSDEListItemBase.resetUserTag();
        pSDEListItemBase.resetUserTag2();
        pSDEListItemBase.resetValueFormat();
        pSDEListItemBase.resetWidth();
        pSDEListItemBase.resetWidthUnit();
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
        if (!bl || this.isCLConvertModeDirty()) {
            hashMap.put(FIELD_CLCONVERTMODE, this.getCLConvertMode());
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
        if (!bl || this.isDataItemsDirty()) {
            hashMap.put(FIELD_DATAITEMS, this.getDataItems());
        }
        if (!bl || this.isDataViewPSDEIdDirty()) {
            hashMap.put(FIELD_DATAVIEWPSDEID, this.getDataViewPSDEId());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableItemPrivDirty()) {
            hashMap.put(FIELD_ENABLEITEMPRIV, this.getEnableItemPriv());
        }
        if (!bl || this.isGroupItemDirty()) {
            hashMap.put(FIELD_GROUPITEM, this.getGroupItem());
        }
        if (!bl || this.isItemTypeDirty()) {
            hashMap.put(FIELD_ITEMTYPE, this.getItemType());
        }
        if (!bl || this.isLCRPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_LCRPSSYSPFPLUGINID, this.getLCRPSSysPFPluginId());
        }
        if (!bl || this.isLCRPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_LCRPSSYSPFPLUGINNAME, this.getLCRPSSysPFPluginName());
        }
        if (!bl || this.isListPSDEIdDirty()) {
            hashMap.put(FIELD_LISTPSDEID, this.getListPSDEId());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNoSortDirty()) {
            hashMap.put(FIELD_NOSORT, this.getNoSort());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPredefinedTypeDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPE, this.getPredefinedType());
        }
        if (!bl || this.isPredefinedTypeTextDirty()) {
            hashMap.put(FIELD_PREDEFINEDTYPETEXT, this.getPredefinedTypeText());
        }
        if (!bl || this.isPreventXSSDirty()) {
            hashMap.put(FIELD_PREVENTXSS, this.getPreventXSS());
        }
        if (!bl || this.isPSCodeListIdDirty()) {
            hashMap.put(FIELD_PSCODELISTID, this.getPSCodeListId());
        }
        if (!bl || this.isPSCodeListNameDirty()) {
            hashMap.put(FIELD_PSCODELISTNAME, this.getPSCodeListName());
        }
        if (!bl || this.isPSDEDataViewIdDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWID, this.getPSDEDataViewId());
        }
        if (!bl || this.isPSDEDataViewNameDirty()) {
            hashMap.put(FIELD_PSDEDATAVIEWNAME, this.getPSDEDataViewName());
        }
        if (!bl || this.isPSDEListIdDirty()) {
            hashMap.put(FIELD_PSDELISTID, this.getPSDEListId());
        }
        if (!bl || this.isPSDEListItemIdDirty()) {
            hashMap.put(FIELD_PSDELISTITEMID, this.getPSDEListItemId());
        }
        if (!bl || this.isPSDEListItemNameDirty()) {
            hashMap.put(FIELD_PSDELISTITEMNAME, this.getPSDEListItemName());
        }
        if (!bl || this.isPSDEListNameDirty()) {
            hashMap.put(FIELD_PSDELISTNAME, this.getPSDEListName());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isRenderModeDirty()) {
            hashMap.put(FIELD_RENDERMODE, this.getRenderMode());
        }
        if (!bl || this.isRenderModeTextDirty()) {
            hashMap.put(FIELD_RENDERMODETEXT, this.getRenderModeText());
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
        return PSDEListItemBase.get(this, n);
    }

    private static Object get(PSDEListItemBase pSDEListItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListItemBase.getAlign();
            }
            case 1: {
                return pSDEListItemBase.getCapPSLanResId();
            }
            case 2: {
                return pSDEListItemBase.getCapPSLanResName();
            }
            case 3: {
                return pSDEListItemBase.getCaption();
            }
            case 4: {
                return pSDEListItemBase.getCLConvertMode();
            }
            case 5: {
                return pSDEListItemBase.getCreateDate();
            }
            case 6: {
                return pSDEListItemBase.getCreateMan();
            }
            case 7: {
                return pSDEListItemBase.getCustomCode();
            }
            case 8: {
                return pSDEListItemBase.getCustomMode();
            }
            case 9: {
                return pSDEListItemBase.getDataItems();
            }
            case 10: {
                return pSDEListItemBase.getDataViewPSDEId();
            }
            case 11: {
                return pSDEListItemBase.getDynaModelFlag();
            }
            case 12: {
                return pSDEListItemBase.getEnableItemPriv();
            }
            case 13: {
                return pSDEListItemBase.getGroupItem();
            }
            case 14: {
                return pSDEListItemBase.getItemType();
            }
            case 15: {
                return pSDEListItemBase.getLCRPSSysPFPluginId();
            }
            case 16: {
                return pSDEListItemBase.getLCRPSSysPFPluginName();
            }
            case 17: {
                return pSDEListItemBase.getListPSDEId();
            }
            case 18: {
                return pSDEListItemBase.getMemo();
            }
            case 19: {
                return pSDEListItemBase.getNoSort();
            }
            case 20: {
                return pSDEListItemBase.getOrderValue();
            }
            case 21: {
                return pSDEListItemBase.getPredefinedType();
            }
            case 22: {
                return pSDEListItemBase.getPredefinedTypeText();
            }
            case 23: {
                return pSDEListItemBase.getPreventXSS();
            }
            case 24: {
                return pSDEListItemBase.getPSCodeListId();
            }
            case 25: {
                return pSDEListItemBase.getPSCodeListName();
            }
            case 26: {
                return pSDEListItemBase.getPSDEDataViewId();
            }
            case 27: {
                return pSDEListItemBase.getPSDEDataViewName();
            }
            case 28: {
                return pSDEListItemBase.getPSDEListId();
            }
            case 29: {
                return pSDEListItemBase.getPSDEListItemId();
            }
            case 30: {
                return pSDEListItemBase.getPSDEListItemName();
            }
            case 31: {
                return pSDEListItemBase.getPSDEListName();
            }
            case 32: {
                return pSDEListItemBase.getPSDEUAGroupId();
            }
            case 33: {
                return pSDEListItemBase.getPSDEUAGroupName();
            }
            case 34: {
                return pSDEListItemBase.getPSDynaInstId();
            }
            case 35: {
                return pSDEListItemBase.getRenderMode();
            }
            case 36: {
                return pSDEListItemBase.getRenderModeText();
            }
            case 37: {
                return pSDEListItemBase.getUpdateDate();
            }
            case 38: {
                return pSDEListItemBase.getUpdateMan();
            }
            case 39: {
                return pSDEListItemBase.getUserTag();
            }
            case 40: {
                return pSDEListItemBase.getUserTag2();
            }
            case 41: {
                return pSDEListItemBase.getValueFormat();
            }
            case 42: {
                return pSDEListItemBase.getWidth();
            }
            case 43: {
                return pSDEListItemBase.getWidthUnit();
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
        PSDEListItemBase.set(this, n, object);
    }

    private static void set(PSDEListItemBase pSDEListItemBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEListItemBase.setAlign(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEListItemBase.setCapPSLanResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEListItemBase.setCapPSLanResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEListItemBase.setCaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEListItemBase.setCLConvertMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEListItemBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEListItemBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEListItemBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEListItemBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEListItemBase.setDataItems(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEListItemBase.setDataViewPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEListItemBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSDEListItemBase.setEnableItemPriv(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 13: {
                pSDEListItemBase.setGroupItem(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEListItemBase.setItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEListItemBase.setLCRPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEListItemBase.setLCRPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEListItemBase.setListPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEListItemBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEListItemBase.setNoSort(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEListItemBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 21: {
                pSDEListItemBase.setPredefinedType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEListItemBase.setPredefinedTypeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEListItemBase.setPreventXSS(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 24: {
                pSDEListItemBase.setPSCodeListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEListItemBase.setPSCodeListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEListItemBase.setPSDEDataViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEListItemBase.setPSDEDataViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEListItemBase.setPSDEListId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEListItemBase.setPSDEListItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEListItemBase.setPSDEListItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEListItemBase.setPSDEListName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEListItemBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEListItemBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEListItemBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEListItemBase.setRenderMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEListItemBase.setRenderModeText(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEListItemBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 38: {
                pSDEListItemBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEListItemBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEListItemBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEListItemBase.setValueFormat(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEListItemBase.setWidth(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 43: {
                pSDEListItemBase.setWidthUnit(DataObject.getStringValue((Object)object));
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
        return PSDEListItemBase.isNull(this, n);
    }

    private static boolean isNull(PSDEListItemBase pSDEListItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListItemBase.getAlign() == null;
            }
            case 1: {
                return pSDEListItemBase.getCapPSLanResId() == null;
            }
            case 2: {
                return pSDEListItemBase.getCapPSLanResName() == null;
            }
            case 3: {
                return pSDEListItemBase.getCaption() == null;
            }
            case 4: {
                return pSDEListItemBase.getCLConvertMode() == null;
            }
            case 5: {
                return pSDEListItemBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEListItemBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEListItemBase.getCustomCode() == null;
            }
            case 8: {
                return pSDEListItemBase.getCustomMode() == null;
            }
            case 9: {
                return pSDEListItemBase.getDataItems() == null;
            }
            case 10: {
                return pSDEListItemBase.getDataViewPSDEId() == null;
            }
            case 11: {
                return pSDEListItemBase.getDynaModelFlag() == null;
            }
            case 12: {
                return pSDEListItemBase.getEnableItemPriv() == null;
            }
            case 13: {
                return pSDEListItemBase.getGroupItem() == null;
            }
            case 14: {
                return pSDEListItemBase.getItemType() == null;
            }
            case 15: {
                return pSDEListItemBase.getLCRPSSysPFPluginId() == null;
            }
            case 16: {
                return pSDEListItemBase.getLCRPSSysPFPluginName() == null;
            }
            case 17: {
                return pSDEListItemBase.getListPSDEId() == null;
            }
            case 18: {
                return pSDEListItemBase.getMemo() == null;
            }
            case 19: {
                return pSDEListItemBase.getNoSort() == null;
            }
            case 20: {
                return pSDEListItemBase.getOrderValue() == null;
            }
            case 21: {
                return pSDEListItemBase.getPredefinedType() == null;
            }
            case 22: {
                return pSDEListItemBase.getPredefinedTypeText() == null;
            }
            case 23: {
                return pSDEListItemBase.getPreventXSS() == null;
            }
            case 24: {
                return pSDEListItemBase.getPSCodeListId() == null;
            }
            case 25: {
                return pSDEListItemBase.getPSCodeListName() == null;
            }
            case 26: {
                return pSDEListItemBase.getPSDEDataViewId() == null;
            }
            case 27: {
                return pSDEListItemBase.getPSDEDataViewName() == null;
            }
            case 28: {
                return pSDEListItemBase.getPSDEListId() == null;
            }
            case 29: {
                return pSDEListItemBase.getPSDEListItemId() == null;
            }
            case 30: {
                return pSDEListItemBase.getPSDEListItemName() == null;
            }
            case 31: {
                return pSDEListItemBase.getPSDEListName() == null;
            }
            case 32: {
                return pSDEListItemBase.getPSDEUAGroupId() == null;
            }
            case 33: {
                return pSDEListItemBase.getPSDEUAGroupName() == null;
            }
            case 34: {
                return pSDEListItemBase.getPSDynaInstId() == null;
            }
            case 35: {
                return pSDEListItemBase.getRenderMode() == null;
            }
            case 36: {
                return pSDEListItemBase.getRenderModeText() == null;
            }
            case 37: {
                return pSDEListItemBase.getUpdateDate() == null;
            }
            case 38: {
                return pSDEListItemBase.getUpdateMan() == null;
            }
            case 39: {
                return pSDEListItemBase.getUserTag() == null;
            }
            case 40: {
                return pSDEListItemBase.getUserTag2() == null;
            }
            case 41: {
                return pSDEListItemBase.getValueFormat() == null;
            }
            case 42: {
                return pSDEListItemBase.getWidth() == null;
            }
            case 43: {
                return pSDEListItemBase.getWidthUnit() == null;
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
        return PSDEListItemBase.contains(this, n);
    }

    private static boolean contains(PSDEListItemBase pSDEListItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEListItemBase.isAlignDirty();
            }
            case 1: {
                return pSDEListItemBase.isCapPSLanResIdDirty();
            }
            case 2: {
                return pSDEListItemBase.isCapPSLanResNameDirty();
            }
            case 3: {
                return pSDEListItemBase.isCaptionDirty();
            }
            case 4: {
                return pSDEListItemBase.isCLConvertModeDirty();
            }
            case 5: {
                return pSDEListItemBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEListItemBase.isCreateManDirty();
            }
            case 7: {
                return pSDEListItemBase.isCustomCodeDirty();
            }
            case 8: {
                return pSDEListItemBase.isCustomModeDirty();
            }
            case 9: {
                return pSDEListItemBase.isDataItemsDirty();
            }
            case 10: {
                return pSDEListItemBase.isDataViewPSDEIdDirty();
            }
            case 11: {
                return pSDEListItemBase.isDynaModelFlagDirty();
            }
            case 12: {
                return pSDEListItemBase.isEnableItemPrivDirty();
            }
            case 13: {
                return pSDEListItemBase.isGroupItemDirty();
            }
            case 14: {
                return pSDEListItemBase.isItemTypeDirty();
            }
            case 15: {
                return pSDEListItemBase.isLCRPSSysPFPluginIdDirty();
            }
            case 16: {
                return pSDEListItemBase.isLCRPSSysPFPluginNameDirty();
            }
            case 17: {
                return pSDEListItemBase.isListPSDEIdDirty();
            }
            case 18: {
                return pSDEListItemBase.isMemoDirty();
            }
            case 19: {
                return pSDEListItemBase.isNoSortDirty();
            }
            case 20: {
                return pSDEListItemBase.isOrderValueDirty();
            }
            case 21: {
                return pSDEListItemBase.isPredefinedTypeDirty();
            }
            case 22: {
                return pSDEListItemBase.isPredefinedTypeTextDirty();
            }
            case 23: {
                return pSDEListItemBase.isPreventXSSDirty();
            }
            case 24: {
                return pSDEListItemBase.isPSCodeListIdDirty();
            }
            case 25: {
                return pSDEListItemBase.isPSCodeListNameDirty();
            }
            case 26: {
                return pSDEListItemBase.isPSDEDataViewIdDirty();
            }
            case 27: {
                return pSDEListItemBase.isPSDEDataViewNameDirty();
            }
            case 28: {
                return pSDEListItemBase.isPSDEListIdDirty();
            }
            case 29: {
                return pSDEListItemBase.isPSDEListItemIdDirty();
            }
            case 30: {
                return pSDEListItemBase.isPSDEListItemNameDirty();
            }
            case 31: {
                return pSDEListItemBase.isPSDEListNameDirty();
            }
            case 32: {
                return pSDEListItemBase.isPSDEUAGroupIdDirty();
            }
            case 33: {
                return pSDEListItemBase.isPSDEUAGroupNameDirty();
            }
            case 34: {
                return pSDEListItemBase.isPSDynaInstIdDirty();
            }
            case 35: {
                return pSDEListItemBase.isRenderModeDirty();
            }
            case 36: {
                return pSDEListItemBase.isRenderModeTextDirty();
            }
            case 37: {
                return pSDEListItemBase.isUpdateDateDirty();
            }
            case 38: {
                return pSDEListItemBase.isUpdateManDirty();
            }
            case 39: {
                return pSDEListItemBase.isUserTagDirty();
            }
            case 40: {
                return pSDEListItemBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDEListItemBase.isValueFormatDirty();
            }
            case 42: {
                return pSDEListItemBase.isWidthDirty();
            }
            case 43: {
                return pSDEListItemBase.isWidthUnitDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEListItemBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEListItemBase pSDEListItemBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEListItemBase.getAlign() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"align", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getAlign()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCapPSLanResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCapPSLanResId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCapPSLanResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"cappslanresname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCapPSLanResName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"caption", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCaption()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCLConvertMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"clconvertmode", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCLConvertMode()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getDataItems() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataitems", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getDataItems()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getDataViewPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dataviewpsdeid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getDataViewPSDEId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getEnableItemPriv() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableitempriv", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getEnableItemPriv()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getGroupItem() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"groupitem", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getGroupItem()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"itemtype", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getItemType()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getLCRPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lcrpssyspfpluginid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getLCRPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getLCRPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"lcrpssyspfpluginname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getLCRPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getListPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"listpsdeid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getListPSDEId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getNoSort() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nosort", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getNoSort()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPredefinedType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtype", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPredefinedType()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPredefinedTypeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"predefinedtypetext", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPredefinedTypeText()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPreventXSS() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"preventxss", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPreventXSS()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSCodeListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSCodeListId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSCodeListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pscodelistname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSCodeListName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEDataViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEDataViewId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEDataViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataviewname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEDataViewName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEListId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEListId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEListItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistitemid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEListItemId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEListItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistitemname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEListItemName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEListName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdelistname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEListName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getRenderMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermode", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getRenderMode()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getRenderModeText() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"rendermodetext", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getRenderModeText()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getValueFormat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueformat", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getValueFormat()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getWidth() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"width", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getWidth()), (boolean)false);
        }
        if (bl || pSDEListItemBase.getWidthUnit() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"widthunit", (Object)PSDEListItemBase.getJSONValue((Object)pSDEListItemBase.getWidthUnit()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEListItemBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEListItemBase pSDEListItemBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEListItemBase.getAlign() != null) {
            object = pSDEListItemBase.getAlign();
            xmlNode.setAttribute(FIELD_ALIGN, (String)(object == null ? "" : object));
        }
        if (bl || pSDEListItemBase.getCapPSLanResId() != null) {
            object = pSDEListItemBase.getCapPSLanResId();
            xmlNode.setAttribute(FIELD_CAPPSLANRESID, (String)(object == null ? "" : object));
        }
        if (bl || pSDEListItemBase.getCapPSLanResName() != null) {
            object = pSDEListItemBase.getCapPSLanResName();
            xmlNode.setAttribute(FIELD_CAPPSLANRESNAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEListItemBase.getCaption() != null) {
            object = pSDEListItemBase.getCaption();
            xmlNode.setAttribute(FIELD_CAPTION, (String)(object == null ? "" : object));
        }
        if (bl || pSDEListItemBase.getCLConvertMode() != null) {
            object = pSDEListItemBase.getCLConvertMode();
            xmlNode.setAttribute(FIELD_CLCONVERTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getCreateDate() != null) {
            object = pSDEListItemBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListItemBase.getCreateMan() != null) {
            object = pSDEListItemBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getCustomCode() != null) {
            object = pSDEListItemBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getCustomMode() != null) {
            object = pSDEListItemBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getDataItems() != null) {
            object = pSDEListItemBase.getDataItems();
            xmlNode.setAttribute(FIELD_DATAITEMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getDataViewPSDEId() != null) {
            object = pSDEListItemBase.getDataViewPSDEId();
            xmlNode.setAttribute(FIELD_DATAVIEWPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getDynaModelFlag() != null) {
            object = pSDEListItemBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getEnableItemPriv() != null) {
            object = pSDEListItemBase.getEnableItemPriv();
            xmlNode.setAttribute(FIELD_ENABLEITEMPRIV, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getGroupItem() != null) {
            object = pSDEListItemBase.getGroupItem();
            xmlNode.setAttribute(FIELD_GROUPITEM, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getItemType() != null) {
            object = pSDEListItemBase.getItemType();
            xmlNode.setAttribute(FIELD_ITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getLCRPSSysPFPluginId() != null) {
            object = pSDEListItemBase.getLCRPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_LCRPSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getLCRPSSysPFPluginName() != null) {
            object = pSDEListItemBase.getLCRPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_LCRPSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getListPSDEId() != null) {
            object = pSDEListItemBase.getListPSDEId();
            xmlNode.setAttribute(FIELD_LISTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getMemo() != null) {
            object = pSDEListItemBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getNoSort() != null) {
            object = pSDEListItemBase.getNoSort();
            xmlNode.setAttribute(FIELD_NOSORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getOrderValue() != null) {
            object = pSDEListItemBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getPredefinedType() != null) {
            object = pSDEListItemBase.getPredefinedType();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPredefinedTypeText() != null) {
            object = pSDEListItemBase.getPredefinedTypeText();
            xmlNode.setAttribute(FIELD_PREDEFINEDTYPETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPreventXSS() != null) {
            object = pSDEListItemBase.getPreventXSS();
            xmlNode.setAttribute(FIELD_PREVENTXSS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getPSCodeListId() != null) {
            object = pSDEListItemBase.getPSCodeListId();
            xmlNode.setAttribute(FIELD_PSCODELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSCodeListName() != null) {
            object = pSDEListItemBase.getPSCodeListName();
            xmlNode.setAttribute(FIELD_PSCODELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEDataViewId() != null) {
            object = pSDEListItemBase.getPSDEDataViewId();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEDataViewName() != null) {
            object = pSDEListItemBase.getPSDEDataViewName();
            xmlNode.setAttribute(FIELD_PSDEDATAVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEListId() != null) {
            object = pSDEListItemBase.getPSDEListId();
            xmlNode.setAttribute(FIELD_PSDELISTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEListItemId() != null) {
            object = pSDEListItemBase.getPSDEListItemId();
            xmlNode.setAttribute(FIELD_PSDELISTITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEListItemName() != null) {
            object = pSDEListItemBase.getPSDEListItemName();
            xmlNode.setAttribute(FIELD_PSDELISTITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEListName() != null) {
            object = pSDEListItemBase.getPSDEListName();
            xmlNode.setAttribute(FIELD_PSDELISTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEUAGroupId() != null) {
            object = pSDEListItemBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDEUAGroupName() != null) {
            object = pSDEListItemBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getPSDynaInstId() != null) {
            object = pSDEListItemBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getRenderMode() != null) {
            object = pSDEListItemBase.getRenderMode();
            xmlNode.setAttribute(FIELD_RENDERMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getRenderModeText() != null) {
            object = pSDEListItemBase.getRenderModeText();
            xmlNode.setAttribute(FIELD_RENDERMODETEXT, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getUpdateDate() != null) {
            object = pSDEListItemBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEListItemBase.getUpdateMan() != null) {
            object = pSDEListItemBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getUserTag() != null) {
            object = pSDEListItemBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getUserTag2() != null) {
            object = pSDEListItemBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getValueFormat() != null) {
            object = pSDEListItemBase.getValueFormat();
            xmlNode.setAttribute(FIELD_VALUEFORMAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEListItemBase.getWidth() != null) {
            object = pSDEListItemBase.getWidth();
            xmlNode.setAttribute(FIELD_WIDTH, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEListItemBase.getWidthUnit() != null) {
            object = pSDEListItemBase.getWidthUnit();
            xmlNode.setAttribute(FIELD_WIDTHUNIT, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEListItemBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEListItemBase pSDEListItemBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEListItemBase.isAlignDirty() && (bl || pSDEListItemBase.getAlign() != null)) {
            iDataObject.set(FIELD_ALIGN, (Object)pSDEListItemBase.getAlign());
        }
        if (pSDEListItemBase.isCapPSLanResIdDirty() && (bl || pSDEListItemBase.getCapPSLanResId() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESID, (Object)pSDEListItemBase.getCapPSLanResId());
        }
        if (pSDEListItemBase.isCapPSLanResNameDirty() && (bl || pSDEListItemBase.getCapPSLanResName() != null)) {
            iDataObject.set(FIELD_CAPPSLANRESNAME, (Object)pSDEListItemBase.getCapPSLanResName());
        }
        if (pSDEListItemBase.isCaptionDirty() && (bl || pSDEListItemBase.getCaption() != null)) {
            iDataObject.set(FIELD_CAPTION, (Object)pSDEListItemBase.getCaption());
        }
        if (pSDEListItemBase.isCLConvertModeDirty() && (bl || pSDEListItemBase.getCLConvertMode() != null)) {
            iDataObject.set(FIELD_CLCONVERTMODE, (Object)pSDEListItemBase.getCLConvertMode());
        }
        if (pSDEListItemBase.isCreateDateDirty() && (bl || pSDEListItemBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEListItemBase.getCreateDate());
        }
        if (pSDEListItemBase.isCreateManDirty() && (bl || pSDEListItemBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEListItemBase.getCreateMan());
        }
        if (pSDEListItemBase.isCustomCodeDirty() && (bl || pSDEListItemBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEListItemBase.getCustomCode());
        }
        if (pSDEListItemBase.isCustomModeDirty() && (bl || pSDEListItemBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEListItemBase.getCustomMode());
        }
        if (pSDEListItemBase.isDataItemsDirty() && (bl || pSDEListItemBase.getDataItems() != null)) {
            iDataObject.set(FIELD_DATAITEMS, (Object)pSDEListItemBase.getDataItems());
        }
        if (pSDEListItemBase.isDataViewPSDEIdDirty() && (bl || pSDEListItemBase.getDataViewPSDEId() != null)) {
            iDataObject.set(FIELD_DATAVIEWPSDEID, (Object)pSDEListItemBase.getDataViewPSDEId());
        }
        if (pSDEListItemBase.isDynaModelFlagDirty() && (bl || pSDEListItemBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEListItemBase.getDynaModelFlag());
        }
        if (pSDEListItemBase.isEnableItemPrivDirty() && (bl || pSDEListItemBase.getEnableItemPriv() != null)) {
            iDataObject.set(FIELD_ENABLEITEMPRIV, (Object)pSDEListItemBase.getEnableItemPriv());
        }
        if (pSDEListItemBase.isGroupItemDirty() && (bl || pSDEListItemBase.getGroupItem() != null)) {
            iDataObject.set(FIELD_GROUPITEM, (Object)pSDEListItemBase.getGroupItem());
        }
        if (pSDEListItemBase.isItemTypeDirty() && (bl || pSDEListItemBase.getItemType() != null)) {
            iDataObject.set(FIELD_ITEMTYPE, (Object)pSDEListItemBase.getItemType());
        }
        if (pSDEListItemBase.isLCRPSSysPFPluginIdDirty() && (bl || pSDEListItemBase.getLCRPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_LCRPSSYSPFPLUGINID, (Object)pSDEListItemBase.getLCRPSSysPFPluginId());
        }
        if (pSDEListItemBase.isLCRPSSysPFPluginNameDirty() && (bl || pSDEListItemBase.getLCRPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_LCRPSSYSPFPLUGINNAME, (Object)pSDEListItemBase.getLCRPSSysPFPluginName());
        }
        if (pSDEListItemBase.isListPSDEIdDirty() && (bl || pSDEListItemBase.getListPSDEId() != null)) {
            iDataObject.set(FIELD_LISTPSDEID, (Object)pSDEListItemBase.getListPSDEId());
        }
        if (pSDEListItemBase.isMemoDirty() && (bl || pSDEListItemBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEListItemBase.getMemo());
        }
        if (pSDEListItemBase.isNoSortDirty() && (bl || pSDEListItemBase.getNoSort() != null)) {
            iDataObject.set(FIELD_NOSORT, (Object)pSDEListItemBase.getNoSort());
        }
        if (pSDEListItemBase.isOrderValueDirty() && (bl || pSDEListItemBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEListItemBase.getOrderValue());
        }
        if (pSDEListItemBase.isPredefinedTypeDirty() && (bl || pSDEListItemBase.getPredefinedType() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPE, (Object)pSDEListItemBase.getPredefinedType());
        }
        if (pSDEListItemBase.isPredefinedTypeTextDirty() && (bl || pSDEListItemBase.getPredefinedTypeText() != null)) {
            iDataObject.set(FIELD_PREDEFINEDTYPETEXT, (Object)pSDEListItemBase.getPredefinedTypeText());
        }
        if (pSDEListItemBase.isPreventXSSDirty() && (bl || pSDEListItemBase.getPreventXSS() != null)) {
            iDataObject.set(FIELD_PREVENTXSS, (Object)pSDEListItemBase.getPreventXSS());
        }
        if (pSDEListItemBase.isPSCodeListIdDirty() && (bl || pSDEListItemBase.getPSCodeListId() != null)) {
            iDataObject.set(FIELD_PSCODELISTID, (Object)pSDEListItemBase.getPSCodeListId());
        }
        if (pSDEListItemBase.isPSCodeListNameDirty() && (bl || pSDEListItemBase.getPSCodeListName() != null)) {
            iDataObject.set(FIELD_PSCODELISTNAME, (Object)pSDEListItemBase.getPSCodeListName());
        }
        if (pSDEListItemBase.isPSDEDataViewIdDirty() && (bl || pSDEListItemBase.getPSDEDataViewId() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWID, (Object)pSDEListItemBase.getPSDEDataViewId());
        }
        if (pSDEListItemBase.isPSDEDataViewNameDirty() && (bl || pSDEListItemBase.getPSDEDataViewName() != null)) {
            iDataObject.set(FIELD_PSDEDATAVIEWNAME, (Object)pSDEListItemBase.getPSDEDataViewName());
        }
        if (pSDEListItemBase.isPSDEListIdDirty() && (bl || pSDEListItemBase.getPSDEListId() != null)) {
            iDataObject.set(FIELD_PSDELISTID, (Object)pSDEListItemBase.getPSDEListId());
        }
        if (pSDEListItemBase.isPSDEListItemIdDirty() && (bl || pSDEListItemBase.getPSDEListItemId() != null)) {
            iDataObject.set(FIELD_PSDELISTITEMID, (Object)pSDEListItemBase.getPSDEListItemId());
        }
        if (pSDEListItemBase.isPSDEListItemNameDirty() && (bl || pSDEListItemBase.getPSDEListItemName() != null)) {
            iDataObject.set(FIELD_PSDELISTITEMNAME, (Object)pSDEListItemBase.getPSDEListItemName());
        }
        if (pSDEListItemBase.isPSDEListNameDirty() && (bl || pSDEListItemBase.getPSDEListName() != null)) {
            iDataObject.set(FIELD_PSDELISTNAME, (Object)pSDEListItemBase.getPSDEListName());
        }
        if (pSDEListItemBase.isPSDEUAGroupIdDirty() && (bl || pSDEListItemBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEListItemBase.getPSDEUAGroupId());
        }
        if (pSDEListItemBase.isPSDEUAGroupNameDirty() && (bl || pSDEListItemBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEListItemBase.getPSDEUAGroupName());
        }
        if (pSDEListItemBase.isPSDynaInstIdDirty() && (bl || pSDEListItemBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEListItemBase.getPSDynaInstId());
        }
        if (pSDEListItemBase.isRenderModeDirty() && (bl || pSDEListItemBase.getRenderMode() != null)) {
            iDataObject.set(FIELD_RENDERMODE, (Object)pSDEListItemBase.getRenderMode());
        }
        if (pSDEListItemBase.isRenderModeTextDirty() && (bl || pSDEListItemBase.getRenderModeText() != null)) {
            iDataObject.set(FIELD_RENDERMODETEXT, (Object)pSDEListItemBase.getRenderModeText());
        }
        if (pSDEListItemBase.isUpdateDateDirty() && (bl || pSDEListItemBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEListItemBase.getUpdateDate());
        }
        if (pSDEListItemBase.isUpdateManDirty() && (bl || pSDEListItemBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEListItemBase.getUpdateMan());
        }
        if (pSDEListItemBase.isUserTagDirty() && (bl || pSDEListItemBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEListItemBase.getUserTag());
        }
        if (pSDEListItemBase.isUserTag2Dirty() && (bl || pSDEListItemBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEListItemBase.getUserTag2());
        }
        if (pSDEListItemBase.isValueFormatDirty() && (bl || pSDEListItemBase.getValueFormat() != null)) {
            iDataObject.set(FIELD_VALUEFORMAT, (Object)pSDEListItemBase.getValueFormat());
        }
        if (pSDEListItemBase.isWidthDirty() && (bl || pSDEListItemBase.getWidth() != null)) {
            iDataObject.set(FIELD_WIDTH, (Object)pSDEListItemBase.getWidth());
        }
        if (pSDEListItemBase.isWidthUnitDirty() && (bl || pSDEListItemBase.getWidthUnit() != null)) {
            iDataObject.set(FIELD_WIDTHUNIT, (Object)pSDEListItemBase.getWidthUnit());
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
        return PSDEListItemBase.remove(this, n);
    }

    private static boolean remove(PSDEListItemBase pSDEListItemBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEListItemBase.resetAlign();
                return true;
            }
            case 1: {
                pSDEListItemBase.resetCapPSLanResId();
                return true;
            }
            case 2: {
                pSDEListItemBase.resetCapPSLanResName();
                return true;
            }
            case 3: {
                pSDEListItemBase.resetCaption();
                return true;
            }
            case 4: {
                pSDEListItemBase.resetCLConvertMode();
                return true;
            }
            case 5: {
                pSDEListItemBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEListItemBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEListItemBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSDEListItemBase.resetCustomMode();
                return true;
            }
            case 9: {
                pSDEListItemBase.resetDataItems();
                return true;
            }
            case 10: {
                pSDEListItemBase.resetDataViewPSDEId();
                return true;
            }
            case 11: {
                pSDEListItemBase.resetDynaModelFlag();
                return true;
            }
            case 12: {
                pSDEListItemBase.resetEnableItemPriv();
                return true;
            }
            case 13: {
                pSDEListItemBase.resetGroupItem();
                return true;
            }
            case 14: {
                pSDEListItemBase.resetItemType();
                return true;
            }
            case 15: {
                pSDEListItemBase.resetLCRPSSysPFPluginId();
                return true;
            }
            case 16: {
                pSDEListItemBase.resetLCRPSSysPFPluginName();
                return true;
            }
            case 17: {
                pSDEListItemBase.resetListPSDEId();
                return true;
            }
            case 18: {
                pSDEListItemBase.resetMemo();
                return true;
            }
            case 19: {
                pSDEListItemBase.resetNoSort();
                return true;
            }
            case 20: {
                pSDEListItemBase.resetOrderValue();
                return true;
            }
            case 21: {
                pSDEListItemBase.resetPredefinedType();
                return true;
            }
            case 22: {
                pSDEListItemBase.resetPredefinedTypeText();
                return true;
            }
            case 23: {
                pSDEListItemBase.resetPreventXSS();
                return true;
            }
            case 24: {
                pSDEListItemBase.resetPSCodeListId();
                return true;
            }
            case 25: {
                pSDEListItemBase.resetPSCodeListName();
                return true;
            }
            case 26: {
                pSDEListItemBase.resetPSDEDataViewId();
                return true;
            }
            case 27: {
                pSDEListItemBase.resetPSDEDataViewName();
                return true;
            }
            case 28: {
                pSDEListItemBase.resetPSDEListId();
                return true;
            }
            case 29: {
                pSDEListItemBase.resetPSDEListItemId();
                return true;
            }
            case 30: {
                pSDEListItemBase.resetPSDEListItemName();
                return true;
            }
            case 31: {
                pSDEListItemBase.resetPSDEListName();
                return true;
            }
            case 32: {
                pSDEListItemBase.resetPSDEUAGroupId();
                return true;
            }
            case 33: {
                pSDEListItemBase.resetPSDEUAGroupName();
                return true;
            }
            case 34: {
                pSDEListItemBase.resetPSDynaInstId();
                return true;
            }
            case 35: {
                pSDEListItemBase.resetRenderMode();
                return true;
            }
            case 36: {
                pSDEListItemBase.resetRenderModeText();
                return true;
            }
            case 37: {
                pSDEListItemBase.resetUpdateDate();
                return true;
            }
            case 38: {
                pSDEListItemBase.resetUpdateMan();
                return true;
            }
            case 39: {
                pSDEListItemBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDEListItemBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDEListItemBase.resetValueFormat();
                return true;
            }
            case 42: {
                pSDEListItemBase.resetWidth();
                return true;
            }
            case 43: {
                pSDEListItemBase.resetWidthUnit();
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
    public PSDEDataView getPSDEDataView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataView();
        }
        if (this.getPSDEDataViewId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataViewLock;
        synchronized (n) {
            if (this.psdedataview != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataViewId(), (Object)this.psdedataview.getPSDEDataViewId()) != 0L) {
                this.psdedataview = null;
            }
            if (this.psdedataview == null) {
                PSDEDataView pSDEDataView = new PSDEDataView();
                pSDEDataView.setPSDEDataViewId(this.getPSDEDataViewId());
                PSDEDataViewService pSDEDataViewService = (PSDEDataViewService)ServiceGlobal.getService(PSDEDataViewService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataViewService.autoGet((IEntity)pSDEDataView);
                this.psdedataview = pSDEDataView;
            }
            return this.psdedataview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEList getPSDEList() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEList();
        }
        if (this.getPSDEListId() == null) {
            return null;
        }
        Integer n = this.objPSDEListLock;
        synchronized (n) {
            if (this.psdelist != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEListId(), (Object)this.psdelist.getPSDEListId()) != 0L) {
                this.psdelist = null;
            }
            if (this.psdelist == null) {
                PSDEList pSDEList = new PSDEList();
                pSDEList.setPSDEListId(this.getPSDEListId());
                PSDEListService pSDEListService = (PSDEListService)ServiceGlobal.getService(PSDEListService.class, (SessionFactory)this.getSessionFactory());
                pSDEListService.autoGet((IEntity)pSDEList);
                this.psdelist = pSDEList;
            }
            return this.psdelist;
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
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.psdeuagroup = pSDEUAGroup;
            }
            return this.psdeuagroup;
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

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysPFPlugin getLCRPSSysPFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLCRPSSysPFPlugin();
        }
        if (this.getLCRPSSysPFPluginId() == null) {
            return null;
        }
        Integer n = this.objLCRPSSysPFPluginLock;
        synchronized (n) {
            if (this.lcrpssyspfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getLCRPSSysPFPluginId(), (Object)this.lcrpssyspfplugin.getPSSysPFPluginId()) != 0L) {
                this.lcrpssyspfplugin = null;
            }
            if (this.lcrpssyspfplugin == null) {
                PSSysPFPlugin pSSysPFPlugin = new PSSysPFPlugin();
                pSSysPFPlugin.setPSSysPFPluginId(this.getLCRPSSysPFPluginId());
                PSSysPFPluginService pSSysPFPluginService = (PSSysPFPluginService)ServiceGlobal.getService(PSSysPFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysPFPluginService.autoGet((IEntity)pSSysPFPlugin);
                this.lcrpssyspfplugin = pSSysPFPlugin;
            }
            return this.lcrpssyspfplugin;
        }
    }

    private PSDEListItemBase getProxyEntity() {
        return this.proxyPSDEListItemBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEListItemBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEListItemBase) {
            this.proxyPSDEListItemBase = (PSDEListItemBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEListItemService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ALIGN, 0);
        fieldIndexMap.put(FIELD_CAPPSLANRESID, 1);
        fieldIndexMap.put(FIELD_CAPPSLANRESNAME, 2);
        fieldIndexMap.put(FIELD_CAPTION, 3);
        fieldIndexMap.put(FIELD_CLCONVERTMODE, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 8);
        fieldIndexMap.put(FIELD_DATAITEMS, 9);
        fieldIndexMap.put(FIELD_DATAVIEWPSDEID, 10);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 11);
        fieldIndexMap.put(FIELD_ENABLEITEMPRIV, 12);
        fieldIndexMap.put(FIELD_GROUPITEM, 13);
        fieldIndexMap.put(FIELD_ITEMTYPE, 14);
        fieldIndexMap.put(FIELD_LCRPSSYSPFPLUGINID, 15);
        fieldIndexMap.put(FIELD_LCRPSSYSPFPLUGINNAME, 16);
        fieldIndexMap.put(FIELD_LISTPSDEID, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_NOSORT, 19);
        fieldIndexMap.put(FIELD_ORDERVALUE, 20);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPE, 21);
        fieldIndexMap.put(FIELD_PREDEFINEDTYPETEXT, 22);
        fieldIndexMap.put(FIELD_PREVENTXSS, 23);
        fieldIndexMap.put(FIELD_PSCODELISTID, 24);
        fieldIndexMap.put(FIELD_PSCODELISTNAME, 25);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWID, 26);
        fieldIndexMap.put(FIELD_PSDEDATAVIEWNAME, 27);
        fieldIndexMap.put(FIELD_PSDELISTID, 28);
        fieldIndexMap.put(FIELD_PSDELISTITEMID, 29);
        fieldIndexMap.put(FIELD_PSDELISTITEMNAME, 30);
        fieldIndexMap.put(FIELD_PSDELISTNAME, 31);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 32);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 33);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 34);
        fieldIndexMap.put(FIELD_RENDERMODE, 35);
        fieldIndexMap.put(FIELD_RENDERMODETEXT, 36);
        fieldIndexMap.put(FIELD_UPDATEDATE, 37);
        fieldIndexMap.put(FIELD_UPDATEMAN, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_VALUEFORMAT, 41);
        fieldIndexMap.put(FIELD_WIDTH, 42);
        fieldIndexMap.put(FIELD_WIDTHUNIT, 43);
    }
}

