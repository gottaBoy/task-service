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
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUIAction;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUIActionService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCss;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysImage;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCssService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysImageService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEUAGroupDetailBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEUAGroupDetailBase.class);
    public static final String FIELD_ACTIONLEVEL = "ACTIONLEVEL";
    public static final String FIELD_ADDSEPARATOR = "ADDSEPARATOR";
    public static final String FIELD_AFTERCONTENT = "AFTERCONTENT";
    public static final String FIELD_AFTERITEMTYPE = "AFTERITEMTYPE";
    public static final String FIELD_AFTERPSSYSCSSID = "AFTERPSSYSCSSID";
    public static final String FIELD_AFTERPSSYSCSSNAME = "AFTERPSSYSCSSNAME";
    public static final String FIELD_AFTERPSSYSRESOURCEID = "AFTERPSSYSRESOURCEID";
    public static final String FIELD_AFTERPSSYSRESOURCENAME = "AFTERPSSYSRESOURCENAME";
    public static final String FIELD_BEFORECONTENT = "BEFORECONTENT";
    public static final String FIELD_BEFOREITEMTYPE = "BEFOREITEMTYPE";
    public static final String FIELD_BEFOREPSSYSCSSID = "BEFOREPSSYSCSSID";
    public static final String FIELD_BEFOREPSSYSCSSNAME = "BEFOREPSSYSCSSNAME";
    public static final String FIELD_BEFOREPSSYSRESOURCEID = "BEFOREPSSYSRESOURCEID";
    public static final String FIELD_BEFOREPSSYSRESOURCENAME = "BEFOREPSSYSRESOURCENAME";
    public static final String FIELD_BUTTONSTYLE = "BUTTONSTYLE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DETAILTAG = "DETAILTAG";
    public static final String FIELD_DETAILTAG2 = "DETAILTAG2";
    public static final String FIELD_DETAILTYPE = "DETAILTYPE";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_ENABLELOGIC = "ENABLELOGIC";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEUAGROUPID = "PSDEUAGROUPID";
    public static final String FIELD_PSDEUAGROUPNAME = "PSDEUAGROUPNAME";
    public static final String FIELD_PSDEUAGRPDETAILID = "PSDEUAGRPDETAILID";
    public static final String FIELD_PSDEUAGRPDETAILNAME = "PSDEUAGRPDETAILNAME";
    public static final String FIELD_PSDEUIACTIONID = "PSDEUIACTIONID";
    public static final String FIELD_PSDEUIACTIONNAME = "PSDEUIACTIONNAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSSYSCSSID = "PSSYSCSSID";
    public static final String FIELD_PSSYSCSSNAME = "PSSYSCSSNAME";
    public static final String FIELD_PSSYSIMAGEID = "PSSYSIMAGEID";
    public static final String FIELD_PSSYSIMAGENAME = "PSSYSIMAGENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_REFPSDEUAGROUPID = "REFPSDEUAGROUPID";
    public static final String FIELD_REFPSDEUAGROUPNAME = "REFPSDEUAGROUPNAME";
    public static final String FIELD_SHOWMODE = "SHOWMODE";
    public static final String FIELD_UACAPTION = "UACAPTION";
    public static final String FIELD_UIACTIONPARAMS = "UIACTIONPARAMS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VISIBLELOGIC = "VISIBLELOGIC";
    private static final int INDEX_ACTIONLEVEL = 0;
    private static final int INDEX_ADDSEPARATOR = 1;
    private static final int INDEX_AFTERCONTENT = 2;
    private static final int INDEX_AFTERITEMTYPE = 3;
    private static final int INDEX_AFTERPSSYSCSSID = 4;
    private static final int INDEX_AFTERPSSYSCSSNAME = 5;
    private static final int INDEX_AFTERPSSYSRESOURCEID = 6;
    private static final int INDEX_AFTERPSSYSRESOURCENAME = 7;
    private static final int INDEX_BEFORECONTENT = 8;
    private static final int INDEX_BEFOREITEMTYPE = 9;
    private static final int INDEX_BEFOREPSSYSCSSID = 10;
    private static final int INDEX_BEFOREPSSYSCSSNAME = 11;
    private static final int INDEX_BEFOREPSSYSRESOURCEID = 12;
    private static final int INDEX_BEFOREPSSYSRESOURCENAME = 13;
    private static final int INDEX_BUTTONSTYLE = 14;
    private static final int INDEX_CODENAME = 15;
    private static final int INDEX_CREATEDATE = 16;
    private static final int INDEX_CREATEMAN = 17;
    private static final int INDEX_DETAILTAG = 18;
    private static final int INDEX_DETAILTAG2 = 19;
    private static final int INDEX_DETAILTYPE = 20;
    private static final int INDEX_DYNAMODELFLAG = 21;
    private static final int INDEX_ENABLELOGIC = 22;
    private static final int INDEX_MEMO = 23;
    private static final int INDEX_ORDERVALUE = 24;
    private static final int INDEX_PSDEID = 25;
    private static final int INDEX_PSDEUAGROUPID = 26;
    private static final int INDEX_PSDEUAGROUPNAME = 27;
    private static final int INDEX_PSDEUAGRPDETAILID = 28;
    private static final int INDEX_PSDEUAGRPDETAILNAME = 29;
    private static final int INDEX_PSDEUIACTIONID = 30;
    private static final int INDEX_PSDEUIACTIONNAME = 31;
    private static final int INDEX_PSDYNAINSTID = 32;
    private static final int INDEX_PSSYSCSSID = 33;
    private static final int INDEX_PSSYSCSSNAME = 34;
    private static final int INDEX_PSSYSIMAGEID = 35;
    private static final int INDEX_PSSYSIMAGENAME = 36;
    private static final int INDEX_PSSYSPFPLUGINID = 37;
    private static final int INDEX_PSSYSPFPLUGINNAME = 38;
    private static final int INDEX_REFPSDEUAGROUPID = 39;
    private static final int INDEX_REFPSDEUAGROUPNAME = 40;
    private static final int INDEX_SHOWMODE = 41;
    private static final int INDEX_UACAPTION = 42;
    private static final int INDEX_UIACTIONPARAMS = 43;
    private static final int INDEX_UPDATEDATE = 44;
    private static final int INDEX_UPDATEMAN = 45;
    private static final int INDEX_USERCAT = 46;
    private static final int INDEX_USERTAG = 47;
    private static final int INDEX_USERTAG2 = 48;
    private static final int INDEX_USERTAG3 = 49;
    private static final int INDEX_USERTAG4 = 50;
    private static final int INDEX_VALIDFLAG = 51;
    private static final int INDEX_VISIBLELOGIC = 52;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEUAGroupDetailBase proxyPSDEUAGroupDetailBase = null;
    private boolean actionlevelDirtyFlag = false;
    private boolean addseparatorDirtyFlag = false;
    private boolean aftercontentDirtyFlag = false;
    private boolean afteritemtypeDirtyFlag = false;
    private boolean afterpssyscssidDirtyFlag = false;
    private boolean afterpssyscssnameDirtyFlag = false;
    private boolean afterpssysresourceidDirtyFlag = false;
    private boolean afterpssysresourcenameDirtyFlag = false;
    private boolean beforecontentDirtyFlag = false;
    private boolean beforeitemtypeDirtyFlag = false;
    private boolean beforepssyscssidDirtyFlag = false;
    private boolean beforepssyscssnameDirtyFlag = false;
    private boolean beforepssysresourceidDirtyFlag = false;
    private boolean beforepssysresourcenameDirtyFlag = false;
    private boolean buttonstyleDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean detailtagDirtyFlag = false;
    private boolean detailtag2DirtyFlag = false;
    private boolean detailtypeDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean enablelogicDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdeuagroupidDirtyFlag = false;
    private boolean psdeuagroupnameDirtyFlag = false;
    private boolean psdeuagrpdetailidDirtyFlag = false;
    private boolean psdeuagrpdetailnameDirtyFlag = false;
    private boolean psdeuiactionidDirtyFlag = false;
    private boolean psdeuiactionnameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean pssyscssidDirtyFlag = false;
    private boolean pssyscssnameDirtyFlag = false;
    private boolean pssysimageidDirtyFlag = false;
    private boolean pssysimagenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean refpsdeuagroupidDirtyFlag = false;
    private boolean refpsdeuagroupnameDirtyFlag = false;
    private boolean showmodeDirtyFlag = false;
    private boolean uacaptionDirtyFlag = false;
    private boolean uiactionparamsDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean visiblelogicDirtyFlag = false;
    @Column(name="actionlevel")
    private Integer actionlevel;
    @Column(name="addseparator")
    private Integer addseparator;
    @Column(name="aftercontent")
    private String aftercontent;
    @Column(name="afteritemtype")
    private String afteritemtype;
    @Column(name="afterpssyscssid")
    private String afterpssyscssid;
    @Column(name="afterpssyscssname")
    private String afterpssyscssname;
    @Column(name="afterpssysresourceid")
    private String afterpssysresourceid;
    @Column(name="afterpssysresourcename")
    private String afterpssysresourcename;
    @Column(name="beforecontent")
    private String beforecontent;
    @Column(name="beforeitemtype")
    private String beforeitemtype;
    @Column(name="beforepssyscssid")
    private String beforepssyscssid;
    @Column(name="beforepssyscssname")
    private String beforepssyscssname;
    @Column(name="beforepssysresourceid")
    private String beforepssysresourceid;
    @Column(name="beforepssysresourcename")
    private String beforepssysresourcename;
    @Column(name="buttonstyle")
    private String buttonstyle;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="detailtag")
    private String detailtag;
    @Column(name="detailtag2")
    private String detailtag2;
    @Column(name="detailtype")
    private String detailtype;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="enablelogic")
    private String enablelogic;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdeuagroupid")
    private String psdeuagroupid;
    @Column(name="psdeuagroupname")
    private String psdeuagroupname;
    @Column(name="psdeuagrpdetailid")
    private String psdeuagrpdetailid;
    @Column(name="psdeuagrpdetailname")
    private String psdeuagrpdetailname;
    @Column(name="psdeuiactionid")
    private String psdeuiactionid;
    @Column(name="psdeuiactionname")
    private String psdeuiactionname;
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
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="refpsdeuagroupid")
    private String refpsdeuagroupid;
    @Column(name="refpsdeuagroupname")
    private String refpsdeuagroupname;
    @Column(name="showmode")
    private String showmode;
    @Column(name="uacaption")
    private String uacaption;
    @Column(name="uiactionparams")
    private String uiactionparams;
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
    @Column(name="visiblelogic")
    private String visiblelogic;
    private Integer objPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup psdeuagroup = null;
    private Integer objRefPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup refpsdeuagroup = null;
    private Integer objPSDEUAActionLock = new Integer(1);
    private PSDEUIAction psdeuaaction = null;
    private Integer objAfterPSSysCssLock = new Integer(1);
    private PSSysCss afterpssyscss = null;
    private Integer objBeforePSSysCssLock = new Integer(1);
    private PSSysCss beforepssyscss = null;
    private Integer objPSSysCssLock = new Integer(1);
    private PSSysCss pssyscss = null;
    private Integer objPSSysImageLock = new Integer(1);
    private PSSysImage pssysimage = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objAfterPSSysResourceLock = new Integer(1);
    private PSSysResource afterpssysresource = null;
    private Integer objBeforePSSysResourceLock = new Integer(1);
    private PSSysResource beforepssysresource = null;

    public void setActionLevel(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setActionLevel(n);
            return;
        }
        this.actionlevel = n;
        this.actionlevelDirtyFlag = true;
    }

    public Integer getActionLevel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getActionLevel();
        }
        return this.actionlevel;
    }

    public boolean isActionLevelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isActionLevelDirty();
        }
        return this.actionlevelDirtyFlag;
    }

    public void resetActionLevel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetActionLevel();
            return;
        }
        this.actionlevelDirtyFlag = false;
        this.actionlevel = null;
    }

    public void setAddSeparator(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAddSeparator(n);
            return;
        }
        this.addseparator = n;
        this.addseparatorDirtyFlag = true;
    }

    public Integer getAddSeparator() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAddSeparator();
        }
        return this.addseparator;
    }

    public boolean isAddSeparatorDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAddSeparatorDirty();
        }
        return this.addseparatorDirtyFlag;
    }

    public void resetAddSeparator() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAddSeparator();
            return;
        }
        this.addseparatorDirtyFlag = false;
        this.addseparator = null;
    }

    public void setAfterContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.aftercontent = string;
        this.aftercontentDirtyFlag = true;
    }

    public String getAfterContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterContent();
        }
        return this.aftercontent;
    }

    public boolean isAfterContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterContentDirty();
        }
        return this.aftercontentDirtyFlag;
    }

    public void resetAfterContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterContent();
            return;
        }
        this.aftercontentDirtyFlag = false;
        this.aftercontent = null;
    }

    public void setAfterItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.afteritemtype = string;
        this.afteritemtypeDirtyFlag = true;
    }

    public String getAfterItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterItemType();
        }
        return this.afteritemtype;
    }

    public boolean isAfterItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterItemTypeDirty();
        }
        return this.afteritemtypeDirtyFlag;
    }

    public void resetAfterItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterItemType();
            return;
        }
        this.afteritemtypeDirtyFlag = false;
        this.afteritemtype = null;
    }

    public void setAfterPSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterPSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.afterpssyscssid = string;
        this.afterpssyscssidDirtyFlag = true;
    }

    public String getAfterPSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysCssId();
        }
        return this.afterpssyscssid;
    }

    public boolean isAfterPSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterPSSysCssIdDirty();
        }
        return this.afterpssyscssidDirtyFlag;
    }

    public void resetAfterPSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterPSSysCssId();
            return;
        }
        this.afterpssyscssidDirtyFlag = false;
        this.afterpssyscssid = null;
    }

    public void setAfterPSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterPSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.afterpssyscssname = string;
        this.afterpssyscssnameDirtyFlag = true;
    }

    public String getAfterPSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysCssName();
        }
        return this.afterpssyscssname;
    }

    public boolean isAfterPSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterPSSysCssNameDirty();
        }
        return this.afterpssyscssnameDirtyFlag;
    }

    public void resetAfterPSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterPSSysCssName();
            return;
        }
        this.afterpssyscssnameDirtyFlag = false;
        this.afterpssyscssname = null;
    }

    public void setAfterPSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterPSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.afterpssysresourceid = string;
        this.afterpssysresourceidDirtyFlag = true;
    }

    public String getAfterPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysResourceId();
        }
        return this.afterpssysresourceid;
    }

    public boolean isAfterPSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterPSSysResourceIdDirty();
        }
        return this.afterpssysresourceidDirtyFlag;
    }

    public void resetAfterPSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterPSSysResourceId();
            return;
        }
        this.afterpssysresourceidDirtyFlag = false;
        this.afterpssysresourceid = null;
    }

    public void setAfterPSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAfterPSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.afterpssysresourcename = string;
        this.afterpssysresourcenameDirtyFlag = true;
    }

    public String getAfterPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysResourceName();
        }
        return this.afterpssysresourcename;
    }

    public boolean isAfterPSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAfterPSSysResourceNameDirty();
        }
        return this.afterpssysresourcenameDirtyFlag;
    }

    public void resetAfterPSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAfterPSSysResourceName();
            return;
        }
        this.afterpssysresourcenameDirtyFlag = false;
        this.afterpssysresourcename = null;
    }

    public void setBeforeContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforeContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforecontent = string;
        this.beforecontentDirtyFlag = true;
    }

    public String getBeforeContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforeContent();
        }
        return this.beforecontent;
    }

    public boolean isBeforeContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforeContentDirty();
        }
        return this.beforecontentDirtyFlag;
    }

    public void resetBeforeContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforeContent();
            return;
        }
        this.beforecontentDirtyFlag = false;
        this.beforecontent = null;
    }

    public void setBeforeItemType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforeItemType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforeitemtype = string;
        this.beforeitemtypeDirtyFlag = true;
    }

    public String getBeforeItemType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforeItemType();
        }
        return this.beforeitemtype;
    }

    public boolean isBeforeItemTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforeItemTypeDirty();
        }
        return this.beforeitemtypeDirtyFlag;
    }

    public void resetBeforeItemType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforeItemType();
            return;
        }
        this.beforeitemtypeDirtyFlag = false;
        this.beforeitemtype = null;
    }

    public void setBeforePSSysCssId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforePSSysCssId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforepssyscssid = string;
        this.beforepssyscssidDirtyFlag = true;
    }

    public String getBeforePSSysCssId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysCssId();
        }
        return this.beforepssyscssid;
    }

    public boolean isBeforePSSysCssIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforePSSysCssIdDirty();
        }
        return this.beforepssyscssidDirtyFlag;
    }

    public void resetBeforePSSysCssId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforePSSysCssId();
            return;
        }
        this.beforepssyscssidDirtyFlag = false;
        this.beforepssyscssid = null;
    }

    public void setBeforePSSysCssName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforePSSysCssName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforepssyscssname = string;
        this.beforepssyscssnameDirtyFlag = true;
    }

    public String getBeforePSSysCssName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysCssName();
        }
        return this.beforepssyscssname;
    }

    public boolean isBeforePSSysCssNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforePSSysCssNameDirty();
        }
        return this.beforepssyscssnameDirtyFlag;
    }

    public void resetBeforePSSysCssName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforePSSysCssName();
            return;
        }
        this.beforepssyscssnameDirtyFlag = false;
        this.beforepssyscssname = null;
    }

    public void setBeforePSSysResourceId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforePSSysResourceId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforepssysresourceid = string;
        this.beforepssysresourceidDirtyFlag = true;
    }

    public String getBeforePSSysResourceId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysResourceId();
        }
        return this.beforepssysresourceid;
    }

    public boolean isBeforePSSysResourceIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforePSSysResourceIdDirty();
        }
        return this.beforepssysresourceidDirtyFlag;
    }

    public void resetBeforePSSysResourceId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforePSSysResourceId();
            return;
        }
        this.beforepssysresourceidDirtyFlag = false;
        this.beforepssysresourceid = null;
    }

    public void setBeforePSSysResourceName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBeforePSSysResourceName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.beforepssysresourcename = string;
        this.beforepssysresourcenameDirtyFlag = true;
    }

    public String getBeforePSSysResourceName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysResourceName();
        }
        return this.beforepssysresourcename;
    }

    public boolean isBeforePSSysResourceNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBeforePSSysResourceNameDirty();
        }
        return this.beforepssysresourcenameDirtyFlag;
    }

    public void resetBeforePSSysResourceName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBeforePSSysResourceName();
            return;
        }
        this.beforepssysresourcenameDirtyFlag = false;
        this.beforepssysresourcename = null;
    }

    public void setButtonStyle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setButtonStyle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.buttonstyle = string;
        this.buttonstyleDirtyFlag = true;
    }

    public String getButtonStyle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getButtonStyle();
        }
        return this.buttonstyle;
    }

    public boolean isButtonStyleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isButtonStyleDirty();
        }
        return this.buttonstyleDirtyFlag;
    }

    public void resetButtonStyle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetButtonStyle();
            return;
        }
        this.buttonstyleDirtyFlag = false;
        this.buttonstyle = null;
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

    public void setDetailTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag = string;
        this.detailtagDirtyFlag = true;
    }

    public String getDetailTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag();
        }
        return this.detailtag;
    }

    public boolean isDetailTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTagDirty();
        }
        return this.detailtagDirtyFlag;
    }

    public void resetDetailTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag();
            return;
        }
        this.detailtagDirtyFlag = false;
        this.detailtag = null;
    }

    public void setDetailTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtag2 = string;
        this.detailtag2DirtyFlag = true;
    }

    public String getDetailTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailTag2();
        }
        return this.detailtag2;
    }

    public boolean isDetailTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTag2Dirty();
        }
        return this.detailtag2DirtyFlag;
    }

    public void resetDetailTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailTag2();
            return;
        }
        this.detailtag2DirtyFlag = false;
        this.detailtag2 = null;
    }

    public void setDetailType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDetailType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.detailtype = string;
        this.detailtypeDirtyFlag = true;
    }

    public String getDetailType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDetailType();
        }
        return this.detailtype;
    }

    public boolean isDetailTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDetailTypeDirty();
        }
        return this.detailtypeDirtyFlag;
    }

    public void resetDetailType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDetailType();
            return;
        }
        this.detailtypeDirtyFlag = false;
        this.detailtype = null;
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

    public void setEnableLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.enablelogic = string;
        this.enablelogicDirtyFlag = true;
    }

    public String getEnableLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableLogic();
        }
        return this.enablelogic;
    }

    public boolean isEnableLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableLogicDirty();
        }
        return this.enablelogicDirtyFlag;
    }

    public void resetEnableLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableLogic();
            return;
        }
        this.enablelogicDirtyFlag = false;
        this.enablelogic = null;
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

    public void setPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeid = string;
        this.psdeidDirtyFlag = true;
    }

    public String getPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEId();
        }
        return this.psdeid;
    }

    public boolean isPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEIdDirty();
        }
        return this.psdeidDirtyFlag;
    }

    public void resetPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEId();
            return;
        }
        this.psdeidDirtyFlag = false;
        this.psdeid = null;
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

    public void setPSDEUAGRPDetailId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGRPDetailId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagrpdetailid = string;
        this.psdeuagrpdetailidDirtyFlag = true;
    }

    public String getPSDEUAGRPDetailId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGRPDetailId();
        }
        return this.psdeuagrpdetailid;
    }

    public boolean isPSDEUAGRPDetailIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGRPDetailIdDirty();
        }
        return this.psdeuagrpdetailidDirtyFlag;
    }

    public void resetPSDEUAGRPDetailId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGRPDetailId();
            return;
        }
        this.psdeuagrpdetailidDirtyFlag = false;
        this.psdeuagrpdetailid = null;
    }

    public void setPSDEUAGRPDetailName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEUAGRPDetailName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeuagrpdetailname = string;
        this.psdeuagrpdetailnameDirtyFlag = true;
    }

    public String getPSDEUAGRPDetailName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAGRPDetailName();
        }
        return this.psdeuagrpdetailname;
    }

    public boolean isPSDEUAGRPDetailNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEUAGRPDetailNameDirty();
        }
        return this.psdeuagrpdetailnameDirtyFlag;
    }

    public void resetPSDEUAGRPDetailName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEUAGRPDetailName();
            return;
        }
        this.psdeuagrpdetailnameDirtyFlag = false;
        this.psdeuagrpdetailname = null;
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

    public void setRefPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeuagroupid = string;
        this.refpsdeuagroupidDirtyFlag = true;
    }

    public String getRefPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEUAGroupId();
        }
        return this.refpsdeuagroupid;
    }

    public boolean isRefPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEUAGroupIdDirty();
        }
        return this.refpsdeuagroupidDirtyFlag;
    }

    public void resetRefPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEUAGroupId();
            return;
        }
        this.refpsdeuagroupidDirtyFlag = false;
        this.refpsdeuagroupid = null;
    }

    public void setRefPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRefPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.refpsdeuagroupname = string;
        this.refpsdeuagroupnameDirtyFlag = true;
    }

    public String getRefPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEUAGroupName();
        }
        return this.refpsdeuagroupname;
    }

    public boolean isRefPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRefPSDEUAGroupNameDirty();
        }
        return this.refpsdeuagroupnameDirtyFlag;
    }

    public void resetRefPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRefPSDEUAGroupName();
            return;
        }
        this.refpsdeuagroupnameDirtyFlag = false;
        this.refpsdeuagroupname = null;
    }

    public void setShowMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setShowMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.showmode = string;
        this.showmodeDirtyFlag = true;
    }

    public String getShowMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getShowMode();
        }
        return this.showmode;
    }

    public boolean isShowModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isShowModeDirty();
        }
        return this.showmodeDirtyFlag;
    }

    public void resetShowMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetShowMode();
            return;
        }
        this.showmodeDirtyFlag = false;
        this.showmode = null;
    }

    public void setUACaption(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUACaption(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uacaption = string;
        this.uacaptionDirtyFlag = true;
    }

    public String getUACaption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUACaption();
        }
        return this.uacaption;
    }

    public boolean isUACaptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUACaptionDirty();
        }
        return this.uacaptionDirtyFlag;
    }

    public void resetUACaption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUACaption();
            return;
        }
        this.uacaptionDirtyFlag = false;
        this.uacaption = null;
    }

    public void setUIActionParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUIActionParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uiactionparams = string;
        this.uiactionparamsDirtyFlag = true;
    }

    public String getUIActionParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUIActionParams();
        }
        return this.uiactionparams;
    }

    public boolean isUIActionParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUIActionParamsDirty();
        }
        return this.uiactionparamsDirtyFlag;
    }

    public void resetUIActionParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUIActionParams();
            return;
        }
        this.uiactionparamsDirtyFlag = false;
        this.uiactionparams = null;
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

    public void setVisibleLogic(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVisibleLogic(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.visiblelogic = string;
        this.visiblelogicDirtyFlag = true;
    }

    public String getVisibleLogic() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVisibleLogic();
        }
        return this.visiblelogic;
    }

    public boolean isVisibleLogicDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVisibleLogicDirty();
        }
        return this.visiblelogicDirtyFlag;
    }

    public void resetVisibleLogic() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVisibleLogic();
            return;
        }
        this.visiblelogicDirtyFlag = false;
        this.visiblelogic = null;
    }

    protected void onReset() {
        PSDEUAGroupDetailBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEUAGroupDetailBase pSDEUAGroupDetailBase) {
        pSDEUAGroupDetailBase.resetActionLevel();
        pSDEUAGroupDetailBase.resetAddSeparator();
        pSDEUAGroupDetailBase.resetAfterContent();
        pSDEUAGroupDetailBase.resetAfterItemType();
        pSDEUAGroupDetailBase.resetAfterPSSysCssId();
        pSDEUAGroupDetailBase.resetAfterPSSysCssName();
        pSDEUAGroupDetailBase.resetAfterPSSysResourceId();
        pSDEUAGroupDetailBase.resetAfterPSSysResourceName();
        pSDEUAGroupDetailBase.resetBeforeContent();
        pSDEUAGroupDetailBase.resetBeforeItemType();
        pSDEUAGroupDetailBase.resetBeforePSSysCssId();
        pSDEUAGroupDetailBase.resetBeforePSSysCssName();
        pSDEUAGroupDetailBase.resetBeforePSSysResourceId();
        pSDEUAGroupDetailBase.resetBeforePSSysResourceName();
        pSDEUAGroupDetailBase.resetButtonStyle();
        pSDEUAGroupDetailBase.resetCodeName();
        pSDEUAGroupDetailBase.resetCreateDate();
        pSDEUAGroupDetailBase.resetCreateMan();
        pSDEUAGroupDetailBase.resetDetailTag();
        pSDEUAGroupDetailBase.resetDetailTag2();
        pSDEUAGroupDetailBase.resetDetailType();
        pSDEUAGroupDetailBase.resetDynaModelFlag();
        pSDEUAGroupDetailBase.resetEnableLogic();
        pSDEUAGroupDetailBase.resetMemo();
        pSDEUAGroupDetailBase.resetOrderValue();
        pSDEUAGroupDetailBase.resetPSDEId();
        pSDEUAGroupDetailBase.resetPSDEUAGroupId();
        pSDEUAGroupDetailBase.resetPSDEUAGroupName();
        pSDEUAGroupDetailBase.resetPSDEUAGRPDetailId();
        pSDEUAGroupDetailBase.resetPSDEUAGRPDetailName();
        pSDEUAGroupDetailBase.resetPSDEUIActionId();
        pSDEUAGroupDetailBase.resetPSDEUIActionName();
        pSDEUAGroupDetailBase.resetPSDynaInstId();
        pSDEUAGroupDetailBase.resetPSSysCssId();
        pSDEUAGroupDetailBase.resetPSSysCssName();
        pSDEUAGroupDetailBase.resetPSSysImageId();
        pSDEUAGroupDetailBase.resetPSSysImageName();
        pSDEUAGroupDetailBase.resetPSSysPFPluginId();
        pSDEUAGroupDetailBase.resetPSSysPFPluginName();
        pSDEUAGroupDetailBase.resetRefPSDEUAGroupId();
        pSDEUAGroupDetailBase.resetRefPSDEUAGroupName();
        pSDEUAGroupDetailBase.resetShowMode();
        pSDEUAGroupDetailBase.resetUACaption();
        pSDEUAGroupDetailBase.resetUIActionParams();
        pSDEUAGroupDetailBase.resetUpdateDate();
        pSDEUAGroupDetailBase.resetUpdateMan();
        pSDEUAGroupDetailBase.resetUserCat();
        pSDEUAGroupDetailBase.resetUserTag();
        pSDEUAGroupDetailBase.resetUserTag2();
        pSDEUAGroupDetailBase.resetUserTag3();
        pSDEUAGroupDetailBase.resetUserTag4();
        pSDEUAGroupDetailBase.resetValidFlag();
        pSDEUAGroupDetailBase.resetVisibleLogic();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isActionLevelDirty()) {
            hashMap.put(FIELD_ACTIONLEVEL, this.getActionLevel());
        }
        if (!bl || this.isAddSeparatorDirty()) {
            hashMap.put(FIELD_ADDSEPARATOR, this.getAddSeparator());
        }
        if (!bl || this.isAfterContentDirty()) {
            hashMap.put(FIELD_AFTERCONTENT, this.getAfterContent());
        }
        if (!bl || this.isAfterItemTypeDirty()) {
            hashMap.put(FIELD_AFTERITEMTYPE, this.getAfterItemType());
        }
        if (!bl || this.isAfterPSSysCssIdDirty()) {
            hashMap.put(FIELD_AFTERPSSYSCSSID, this.getAfterPSSysCssId());
        }
        if (!bl || this.isAfterPSSysCssNameDirty()) {
            hashMap.put(FIELD_AFTERPSSYSCSSNAME, this.getAfterPSSysCssName());
        }
        if (!bl || this.isAfterPSSysResourceIdDirty()) {
            hashMap.put(FIELD_AFTERPSSYSRESOURCEID, this.getAfterPSSysResourceId());
        }
        if (!bl || this.isAfterPSSysResourceNameDirty()) {
            hashMap.put(FIELD_AFTERPSSYSRESOURCENAME, this.getAfterPSSysResourceName());
        }
        if (!bl || this.isBeforeContentDirty()) {
            hashMap.put(FIELD_BEFORECONTENT, this.getBeforeContent());
        }
        if (!bl || this.isBeforeItemTypeDirty()) {
            hashMap.put(FIELD_BEFOREITEMTYPE, this.getBeforeItemType());
        }
        if (!bl || this.isBeforePSSysCssIdDirty()) {
            hashMap.put(FIELD_BEFOREPSSYSCSSID, this.getBeforePSSysCssId());
        }
        if (!bl || this.isBeforePSSysCssNameDirty()) {
            hashMap.put(FIELD_BEFOREPSSYSCSSNAME, this.getBeforePSSysCssName());
        }
        if (!bl || this.isBeforePSSysResourceIdDirty()) {
            hashMap.put(FIELD_BEFOREPSSYSRESOURCEID, this.getBeforePSSysResourceId());
        }
        if (!bl || this.isBeforePSSysResourceNameDirty()) {
            hashMap.put(FIELD_BEFOREPSSYSRESOURCENAME, this.getBeforePSSysResourceName());
        }
        if (!bl || this.isButtonStyleDirty()) {
            hashMap.put(FIELD_BUTTONSTYLE, this.getButtonStyle());
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
        if (!bl || this.isDetailTagDirty()) {
            hashMap.put(FIELD_DETAILTAG, this.getDetailTag());
        }
        if (!bl || this.isDetailTag2Dirty()) {
            hashMap.put(FIELD_DETAILTAG2, this.getDetailTag2());
        }
        if (!bl || this.isDetailTypeDirty()) {
            hashMap.put(FIELD_DETAILTYPE, this.getDetailType());
        }
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isEnableLogicDirty()) {
            hashMap.put(FIELD_ENABLELOGIC, this.getEnableLogic());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPID, this.getPSDEUAGroupId());
        }
        if (!bl || this.isPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PSDEUAGROUPNAME, this.getPSDEUAGroupName());
        }
        if (!bl || this.isPSDEUAGRPDetailIdDirty()) {
            hashMap.put(FIELD_PSDEUAGRPDETAILID, this.getPSDEUAGRPDetailId());
        }
        if (!bl || this.isPSDEUAGRPDetailNameDirty()) {
            hashMap.put(FIELD_PSDEUAGRPDETAILNAME, this.getPSDEUAGRPDetailName());
        }
        if (!bl || this.isPSDEUIActionIdDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONID, this.getPSDEUIActionId());
        }
        if (!bl || this.isPSDEUIActionNameDirty()) {
            hashMap.put(FIELD_PSDEUIACTIONNAME, this.getPSDEUIActionName());
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
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isRefPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_REFPSDEUAGROUPID, this.getRefPSDEUAGroupId());
        }
        if (!bl || this.isRefPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_REFPSDEUAGROUPNAME, this.getRefPSDEUAGroupName());
        }
        if (!bl || this.isShowModeDirty()) {
            hashMap.put(FIELD_SHOWMODE, this.getShowMode());
        }
        if (!bl || this.isUACaptionDirty()) {
            hashMap.put(FIELD_UACAPTION, this.getUACaption());
        }
        if (!bl || this.isUIActionParamsDirty()) {
            hashMap.put(FIELD_UIACTIONPARAMS, this.getUIActionParams());
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
        if (!bl || this.isVisibleLogicDirty()) {
            hashMap.put(FIELD_VISIBLELOGIC, this.getVisibleLogic());
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
        return PSDEUAGroupDetailBase.get(this, n);
    }

    private static Object get(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupDetailBase.getActionLevel();
            }
            case 1: {
                return pSDEUAGroupDetailBase.getAddSeparator();
            }
            case 2: {
                return pSDEUAGroupDetailBase.getAfterContent();
            }
            case 3: {
                return pSDEUAGroupDetailBase.getAfterItemType();
            }
            case 4: {
                return pSDEUAGroupDetailBase.getAfterPSSysCssId();
            }
            case 5: {
                return pSDEUAGroupDetailBase.getAfterPSSysCssName();
            }
            case 6: {
                return pSDEUAGroupDetailBase.getAfterPSSysResourceId();
            }
            case 7: {
                return pSDEUAGroupDetailBase.getAfterPSSysResourceName();
            }
            case 8: {
                return pSDEUAGroupDetailBase.getBeforeContent();
            }
            case 9: {
                return pSDEUAGroupDetailBase.getBeforeItemType();
            }
            case 10: {
                return pSDEUAGroupDetailBase.getBeforePSSysCssId();
            }
            case 11: {
                return pSDEUAGroupDetailBase.getBeforePSSysCssName();
            }
            case 12: {
                return pSDEUAGroupDetailBase.getBeforePSSysResourceId();
            }
            case 13: {
                return pSDEUAGroupDetailBase.getBeforePSSysResourceName();
            }
            case 14: {
                return pSDEUAGroupDetailBase.getButtonStyle();
            }
            case 15: {
                return pSDEUAGroupDetailBase.getCodeName();
            }
            case 16: {
                return pSDEUAGroupDetailBase.getCreateDate();
            }
            case 17: {
                return pSDEUAGroupDetailBase.getCreateMan();
            }
            case 18: {
                return pSDEUAGroupDetailBase.getDetailTag();
            }
            case 19: {
                return pSDEUAGroupDetailBase.getDetailTag2();
            }
            case 20: {
                return pSDEUAGroupDetailBase.getDetailType();
            }
            case 21: {
                return pSDEUAGroupDetailBase.getDynaModelFlag();
            }
            case 22: {
                return pSDEUAGroupDetailBase.getEnableLogic();
            }
            case 23: {
                return pSDEUAGroupDetailBase.getMemo();
            }
            case 24: {
                return pSDEUAGroupDetailBase.getOrderValue();
            }
            case 25: {
                return pSDEUAGroupDetailBase.getPSDEId();
            }
            case 26: {
                return pSDEUAGroupDetailBase.getPSDEUAGroupId();
            }
            case 27: {
                return pSDEUAGroupDetailBase.getPSDEUAGroupName();
            }
            case 28: {
                return pSDEUAGroupDetailBase.getPSDEUAGRPDetailId();
            }
            case 29: {
                return pSDEUAGroupDetailBase.getPSDEUAGRPDetailName();
            }
            case 30: {
                return pSDEUAGroupDetailBase.getPSDEUIActionId();
            }
            case 31: {
                return pSDEUAGroupDetailBase.getPSDEUIActionName();
            }
            case 32: {
                return pSDEUAGroupDetailBase.getPSDynaInstId();
            }
            case 33: {
                return pSDEUAGroupDetailBase.getPSSysCssId();
            }
            case 34: {
                return pSDEUAGroupDetailBase.getPSSysCssName();
            }
            case 35: {
                return pSDEUAGroupDetailBase.getPSSysImageId();
            }
            case 36: {
                return pSDEUAGroupDetailBase.getPSSysImageName();
            }
            case 37: {
                return pSDEUAGroupDetailBase.getPSSysPFPluginId();
            }
            case 38: {
                return pSDEUAGroupDetailBase.getPSSysPFPluginName();
            }
            case 39: {
                return pSDEUAGroupDetailBase.getRefPSDEUAGroupId();
            }
            case 40: {
                return pSDEUAGroupDetailBase.getRefPSDEUAGroupName();
            }
            case 41: {
                return pSDEUAGroupDetailBase.getShowMode();
            }
            case 42: {
                return pSDEUAGroupDetailBase.getUACaption();
            }
            case 43: {
                return pSDEUAGroupDetailBase.getUIActionParams();
            }
            case 44: {
                return pSDEUAGroupDetailBase.getUpdateDate();
            }
            case 45: {
                return pSDEUAGroupDetailBase.getUpdateMan();
            }
            case 46: {
                return pSDEUAGroupDetailBase.getUserCat();
            }
            case 47: {
                return pSDEUAGroupDetailBase.getUserTag();
            }
            case 48: {
                return pSDEUAGroupDetailBase.getUserTag2();
            }
            case 49: {
                return pSDEUAGroupDetailBase.getUserTag3();
            }
            case 50: {
                return pSDEUAGroupDetailBase.getUserTag4();
            }
            case 51: {
                return pSDEUAGroupDetailBase.getValidFlag();
            }
            case 52: {
                return pSDEUAGroupDetailBase.getVisibleLogic();
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
        PSDEUAGroupDetailBase.set(this, n, object);
    }

    private static void set(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAGroupDetailBase.setActionLevel(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEUAGroupDetailBase.setAddSeparator(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEUAGroupDetailBase.setAfterContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEUAGroupDetailBase.setAfterItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEUAGroupDetailBase.setAfterPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEUAGroupDetailBase.setAfterPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEUAGroupDetailBase.setAfterPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEUAGroupDetailBase.setAfterPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEUAGroupDetailBase.setBeforeContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEUAGroupDetailBase.setBeforeItemType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEUAGroupDetailBase.setBeforePSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEUAGroupDetailBase.setBeforePSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEUAGroupDetailBase.setBeforePSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEUAGroupDetailBase.setBeforePSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEUAGroupDetailBase.setButtonStyle(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEUAGroupDetailBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEUAGroupDetailBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEUAGroupDetailBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEUAGroupDetailBase.setDetailTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEUAGroupDetailBase.setDetailTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEUAGroupDetailBase.setDetailType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEUAGroupDetailBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSDEUAGroupDetailBase.setEnableLogic(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEUAGroupDetailBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEUAGroupDetailBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 25: {
                pSDEUAGroupDetailBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEUAGroupDetailBase.setPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEUAGroupDetailBase.setPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEUAGroupDetailBase.setPSDEUAGRPDetailId(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEUAGroupDetailBase.setPSDEUAGRPDetailName(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEUAGroupDetailBase.setPSDEUIActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEUAGroupDetailBase.setPSDEUIActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEUAGroupDetailBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEUAGroupDetailBase.setPSSysCssId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEUAGroupDetailBase.setPSSysCssName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEUAGroupDetailBase.setPSSysImageId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEUAGroupDetailBase.setPSSysImageName(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSDEUAGroupDetailBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEUAGroupDetailBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEUAGroupDetailBase.setRefPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEUAGroupDetailBase.setRefPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEUAGroupDetailBase.setShowMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEUAGroupDetailBase.setUACaption(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEUAGroupDetailBase.setUIActionParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 44: {
                pSDEUAGroupDetailBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 45: {
                pSDEUAGroupDetailBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 46: {
                pSDEUAGroupDetailBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 47: {
                pSDEUAGroupDetailBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 48: {
                pSDEUAGroupDetailBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 49: {
                pSDEUAGroupDetailBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 50: {
                pSDEUAGroupDetailBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 51: {
                pSDEUAGroupDetailBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 52: {
                pSDEUAGroupDetailBase.setVisibleLogic(DataObject.getStringValue((Object)object));
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
        return PSDEUAGroupDetailBase.isNull(this, n);
    }

    private static boolean isNull(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupDetailBase.getActionLevel() == null;
            }
            case 1: {
                return pSDEUAGroupDetailBase.getAddSeparator() == null;
            }
            case 2: {
                return pSDEUAGroupDetailBase.getAfterContent() == null;
            }
            case 3: {
                return pSDEUAGroupDetailBase.getAfterItemType() == null;
            }
            case 4: {
                return pSDEUAGroupDetailBase.getAfterPSSysCssId() == null;
            }
            case 5: {
                return pSDEUAGroupDetailBase.getAfterPSSysCssName() == null;
            }
            case 6: {
                return pSDEUAGroupDetailBase.getAfterPSSysResourceId() == null;
            }
            case 7: {
                return pSDEUAGroupDetailBase.getAfterPSSysResourceName() == null;
            }
            case 8: {
                return pSDEUAGroupDetailBase.getBeforeContent() == null;
            }
            case 9: {
                return pSDEUAGroupDetailBase.getBeforeItemType() == null;
            }
            case 10: {
                return pSDEUAGroupDetailBase.getBeforePSSysCssId() == null;
            }
            case 11: {
                return pSDEUAGroupDetailBase.getBeforePSSysCssName() == null;
            }
            case 12: {
                return pSDEUAGroupDetailBase.getBeforePSSysResourceId() == null;
            }
            case 13: {
                return pSDEUAGroupDetailBase.getBeforePSSysResourceName() == null;
            }
            case 14: {
                return pSDEUAGroupDetailBase.getButtonStyle() == null;
            }
            case 15: {
                return pSDEUAGroupDetailBase.getCodeName() == null;
            }
            case 16: {
                return pSDEUAGroupDetailBase.getCreateDate() == null;
            }
            case 17: {
                return pSDEUAGroupDetailBase.getCreateMan() == null;
            }
            case 18: {
                return pSDEUAGroupDetailBase.getDetailTag() == null;
            }
            case 19: {
                return pSDEUAGroupDetailBase.getDetailTag2() == null;
            }
            case 20: {
                return pSDEUAGroupDetailBase.getDetailType() == null;
            }
            case 21: {
                return pSDEUAGroupDetailBase.getDynaModelFlag() == null;
            }
            case 22: {
                return pSDEUAGroupDetailBase.getEnableLogic() == null;
            }
            case 23: {
                return pSDEUAGroupDetailBase.getMemo() == null;
            }
            case 24: {
                return pSDEUAGroupDetailBase.getOrderValue() == null;
            }
            case 25: {
                return pSDEUAGroupDetailBase.getPSDEId() == null;
            }
            case 26: {
                return pSDEUAGroupDetailBase.getPSDEUAGroupId() == null;
            }
            case 27: {
                return pSDEUAGroupDetailBase.getPSDEUAGroupName() == null;
            }
            case 28: {
                return pSDEUAGroupDetailBase.getPSDEUAGRPDetailId() == null;
            }
            case 29: {
                return pSDEUAGroupDetailBase.getPSDEUAGRPDetailName() == null;
            }
            case 30: {
                return pSDEUAGroupDetailBase.getPSDEUIActionId() == null;
            }
            case 31: {
                return pSDEUAGroupDetailBase.getPSDEUIActionName() == null;
            }
            case 32: {
                return pSDEUAGroupDetailBase.getPSDynaInstId() == null;
            }
            case 33: {
                return pSDEUAGroupDetailBase.getPSSysCssId() == null;
            }
            case 34: {
                return pSDEUAGroupDetailBase.getPSSysCssName() == null;
            }
            case 35: {
                return pSDEUAGroupDetailBase.getPSSysImageId() == null;
            }
            case 36: {
                return pSDEUAGroupDetailBase.getPSSysImageName() == null;
            }
            case 37: {
                return pSDEUAGroupDetailBase.getPSSysPFPluginId() == null;
            }
            case 38: {
                return pSDEUAGroupDetailBase.getPSSysPFPluginName() == null;
            }
            case 39: {
                return pSDEUAGroupDetailBase.getRefPSDEUAGroupId() == null;
            }
            case 40: {
                return pSDEUAGroupDetailBase.getRefPSDEUAGroupName() == null;
            }
            case 41: {
                return pSDEUAGroupDetailBase.getShowMode() == null;
            }
            case 42: {
                return pSDEUAGroupDetailBase.getUACaption() == null;
            }
            case 43: {
                return pSDEUAGroupDetailBase.getUIActionParams() == null;
            }
            case 44: {
                return pSDEUAGroupDetailBase.getUpdateDate() == null;
            }
            case 45: {
                return pSDEUAGroupDetailBase.getUpdateMan() == null;
            }
            case 46: {
                return pSDEUAGroupDetailBase.getUserCat() == null;
            }
            case 47: {
                return pSDEUAGroupDetailBase.getUserTag() == null;
            }
            case 48: {
                return pSDEUAGroupDetailBase.getUserTag2() == null;
            }
            case 49: {
                return pSDEUAGroupDetailBase.getUserTag3() == null;
            }
            case 50: {
                return pSDEUAGroupDetailBase.getUserTag4() == null;
            }
            case 51: {
                return pSDEUAGroupDetailBase.getValidFlag() == null;
            }
            case 52: {
                return pSDEUAGroupDetailBase.getVisibleLogic() == null;
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
        return PSDEUAGroupDetailBase.contains(this, n);
    }

    private static boolean contains(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEUAGroupDetailBase.isActionLevelDirty();
            }
            case 1: {
                return pSDEUAGroupDetailBase.isAddSeparatorDirty();
            }
            case 2: {
                return pSDEUAGroupDetailBase.isAfterContentDirty();
            }
            case 3: {
                return pSDEUAGroupDetailBase.isAfterItemTypeDirty();
            }
            case 4: {
                return pSDEUAGroupDetailBase.isAfterPSSysCssIdDirty();
            }
            case 5: {
                return pSDEUAGroupDetailBase.isAfterPSSysCssNameDirty();
            }
            case 6: {
                return pSDEUAGroupDetailBase.isAfterPSSysResourceIdDirty();
            }
            case 7: {
                return pSDEUAGroupDetailBase.isAfterPSSysResourceNameDirty();
            }
            case 8: {
                return pSDEUAGroupDetailBase.isBeforeContentDirty();
            }
            case 9: {
                return pSDEUAGroupDetailBase.isBeforeItemTypeDirty();
            }
            case 10: {
                return pSDEUAGroupDetailBase.isBeforePSSysCssIdDirty();
            }
            case 11: {
                return pSDEUAGroupDetailBase.isBeforePSSysCssNameDirty();
            }
            case 12: {
                return pSDEUAGroupDetailBase.isBeforePSSysResourceIdDirty();
            }
            case 13: {
                return pSDEUAGroupDetailBase.isBeforePSSysResourceNameDirty();
            }
            case 14: {
                return pSDEUAGroupDetailBase.isButtonStyleDirty();
            }
            case 15: {
                return pSDEUAGroupDetailBase.isCodeNameDirty();
            }
            case 16: {
                return pSDEUAGroupDetailBase.isCreateDateDirty();
            }
            case 17: {
                return pSDEUAGroupDetailBase.isCreateManDirty();
            }
            case 18: {
                return pSDEUAGroupDetailBase.isDetailTagDirty();
            }
            case 19: {
                return pSDEUAGroupDetailBase.isDetailTag2Dirty();
            }
            case 20: {
                return pSDEUAGroupDetailBase.isDetailTypeDirty();
            }
            case 21: {
                return pSDEUAGroupDetailBase.isDynaModelFlagDirty();
            }
            case 22: {
                return pSDEUAGroupDetailBase.isEnableLogicDirty();
            }
            case 23: {
                return pSDEUAGroupDetailBase.isMemoDirty();
            }
            case 24: {
                return pSDEUAGroupDetailBase.isOrderValueDirty();
            }
            case 25: {
                return pSDEUAGroupDetailBase.isPSDEIdDirty();
            }
            case 26: {
                return pSDEUAGroupDetailBase.isPSDEUAGroupIdDirty();
            }
            case 27: {
                return pSDEUAGroupDetailBase.isPSDEUAGroupNameDirty();
            }
            case 28: {
                return pSDEUAGroupDetailBase.isPSDEUAGRPDetailIdDirty();
            }
            case 29: {
                return pSDEUAGroupDetailBase.isPSDEUAGRPDetailNameDirty();
            }
            case 30: {
                return pSDEUAGroupDetailBase.isPSDEUIActionIdDirty();
            }
            case 31: {
                return pSDEUAGroupDetailBase.isPSDEUIActionNameDirty();
            }
            case 32: {
                return pSDEUAGroupDetailBase.isPSDynaInstIdDirty();
            }
            case 33: {
                return pSDEUAGroupDetailBase.isPSSysCssIdDirty();
            }
            case 34: {
                return pSDEUAGroupDetailBase.isPSSysCssNameDirty();
            }
            case 35: {
                return pSDEUAGroupDetailBase.isPSSysImageIdDirty();
            }
            case 36: {
                return pSDEUAGroupDetailBase.isPSSysImageNameDirty();
            }
            case 37: {
                return pSDEUAGroupDetailBase.isPSSysPFPluginIdDirty();
            }
            case 38: {
                return pSDEUAGroupDetailBase.isPSSysPFPluginNameDirty();
            }
            case 39: {
                return pSDEUAGroupDetailBase.isRefPSDEUAGroupIdDirty();
            }
            case 40: {
                return pSDEUAGroupDetailBase.isRefPSDEUAGroupNameDirty();
            }
            case 41: {
                return pSDEUAGroupDetailBase.isShowModeDirty();
            }
            case 42: {
                return pSDEUAGroupDetailBase.isUACaptionDirty();
            }
            case 43: {
                return pSDEUAGroupDetailBase.isUIActionParamsDirty();
            }
            case 44: {
                return pSDEUAGroupDetailBase.isUpdateDateDirty();
            }
            case 45: {
                return pSDEUAGroupDetailBase.isUpdateManDirty();
            }
            case 46: {
                return pSDEUAGroupDetailBase.isUserCatDirty();
            }
            case 47: {
                return pSDEUAGroupDetailBase.isUserTagDirty();
            }
            case 48: {
                return pSDEUAGroupDetailBase.isUserTag2Dirty();
            }
            case 49: {
                return pSDEUAGroupDetailBase.isUserTag3Dirty();
            }
            case 50: {
                return pSDEUAGroupDetailBase.isUserTag4Dirty();
            }
            case 51: {
                return pSDEUAGroupDetailBase.isValidFlagDirty();
            }
            case 52: {
                return pSDEUAGroupDetailBase.isVisibleLogicDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEUAGroupDetailBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEUAGroupDetailBase.getActionLevel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"actionlevel", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getActionLevel()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAddSeparator() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"addseparator", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAddSeparator()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"aftercontent", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterContent()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"afteritemtype", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterItemType()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"afterpssyscssid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"afterpssyscssname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"afterpssysresourceid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterPSSysResourceId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"afterpssysresourcename", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getAfterPSSysResourceName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforeContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforecontent", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforeContent()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforeItemType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforeitemtype", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforeItemType()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforepssyscssid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforePSSysCssId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforepssyscssname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforePSSysCssName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforepssysresourceid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforePSSysResourceId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"beforepssysresourcename", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getBeforePSSysResourceName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getButtonStyle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"buttonstyle", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getButtonStyle()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getDetailTag()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtag2", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getDetailTag2()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"detailtype", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getDetailType()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getEnableLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablelogic", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getEnableLogic()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagroupname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagrpdetailid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUAGRPDetailId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuagrpdetailname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUAGRPDetailName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUIActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUIActionId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUIActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeuiactionname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDEUIActionName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysCssId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysCssId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysCssName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscssname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysCssName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysImageId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimageid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysImageId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysImageName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysimagename", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysImageName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeuagroupid", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getRefPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"refpsdeuagroupname", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getRefPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getShowMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"showmode", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getShowMode()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUACaption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uacaption", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUACaption()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUIActionParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uiactionparams", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUIActionParams()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSDEUAGroupDetailBase.getVisibleLogic() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"visiblelogic", (Object)PSDEUAGroupDetailBase.getJSONValue((Object)pSDEUAGroupDetailBase.getVisibleLogic()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEUAGroupDetailBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEUAGroupDetailBase.getActionLevel() != null) {
            object = pSDEUAGroupDetailBase.getActionLevel();
            xmlNode.setAttribute(FIELD_ACTIONLEVEL, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getAddSeparator() != null) {
            object = pSDEUAGroupDetailBase.getAddSeparator();
            xmlNode.setAttribute(FIELD_ADDSEPARATOR, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getAfterContent() != null) {
            object = pSDEUAGroupDetailBase.getAfterContent();
            xmlNode.setAttribute(FIELD_AFTERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterItemType() != null) {
            object = pSDEUAGroupDetailBase.getAfterItemType();
            xmlNode.setAttribute(FIELD_AFTERITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysCssId() != null) {
            object = pSDEUAGroupDetailBase.getAfterPSSysCssId();
            xmlNode.setAttribute(FIELD_AFTERPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysCssName() != null) {
            object = pSDEUAGroupDetailBase.getAfterPSSysCssName();
            xmlNode.setAttribute(FIELD_AFTERPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceId() != null) {
            object = pSDEUAGroupDetailBase.getAfterPSSysResourceId();
            xmlNode.setAttribute(FIELD_AFTERPSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceName() != null) {
            object = pSDEUAGroupDetailBase.getAfterPSSysResourceName();
            xmlNode.setAttribute(FIELD_AFTERPSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforeContent() != null) {
            object = pSDEUAGroupDetailBase.getBeforeContent();
            xmlNode.setAttribute(FIELD_BEFORECONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforeItemType() != null) {
            object = pSDEUAGroupDetailBase.getBeforeItemType();
            xmlNode.setAttribute(FIELD_BEFOREITEMTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysCssId() != null) {
            object = pSDEUAGroupDetailBase.getBeforePSSysCssId();
            xmlNode.setAttribute(FIELD_BEFOREPSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysCssName() != null) {
            object = pSDEUAGroupDetailBase.getBeforePSSysCssName();
            xmlNode.setAttribute(FIELD_BEFOREPSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceId() != null) {
            object = pSDEUAGroupDetailBase.getBeforePSSysResourceId();
            xmlNode.setAttribute(FIELD_BEFOREPSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceName() != null) {
            object = pSDEUAGroupDetailBase.getBeforePSSysResourceName();
            xmlNode.setAttribute(FIELD_BEFOREPSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getButtonStyle() != null) {
            object = pSDEUAGroupDetailBase.getButtonStyle();
            xmlNode.setAttribute(FIELD_BUTTONSTYLE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getCodeName() != null) {
            object = pSDEUAGroupDetailBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getCreateDate() != null) {
            object = pSDEUAGroupDetailBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getCreateMan() != null) {
            object = pSDEUAGroupDetailBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailTag() != null) {
            object = pSDEUAGroupDetailBase.getDetailTag();
            xmlNode.setAttribute(FIELD_DETAILTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailTag2() != null) {
            object = pSDEUAGroupDetailBase.getDetailTag2();
            xmlNode.setAttribute(FIELD_DETAILTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getDetailType() != null) {
            object = pSDEUAGroupDetailBase.getDetailType();
            xmlNode.setAttribute(FIELD_DETAILTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getDynaModelFlag() != null) {
            object = pSDEUAGroupDetailBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getEnableLogic() != null) {
            object = pSDEUAGroupDetailBase.getEnableLogic();
            xmlNode.setAttribute(FIELD_ENABLELOGIC, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getMemo() != null) {
            object = pSDEUAGroupDetailBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getOrderValue() != null) {
            object = pSDEUAGroupDetailBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEId() != null) {
            object = pSDEUAGroupDetailBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGroupId() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGroupName() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailId() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUAGRPDetailId();
            xmlNode.setAttribute(FIELD_PSDEUAGRPDETAILID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailName() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUAGRPDetailName();
            xmlNode.setAttribute(FIELD_PSDEUAGRPDETAILNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUIActionId() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUIActionId();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDEUIActionName() != null) {
            object = pSDEUAGroupDetailBase.getPSDEUIActionName();
            xmlNode.setAttribute(FIELD_PSDEUIACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSDynaInstId() != null) {
            object = pSDEUAGroupDetailBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysCssId() != null) {
            object = pSDEUAGroupDetailBase.getPSSysCssId();
            xmlNode.setAttribute(FIELD_PSSYSCSSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysCssName() != null) {
            object = pSDEUAGroupDetailBase.getPSSysCssName();
            xmlNode.setAttribute(FIELD_PSSYSCSSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysImageId() != null) {
            object = pSDEUAGroupDetailBase.getPSSysImageId();
            xmlNode.setAttribute(FIELD_PSSYSIMAGEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysImageName() != null) {
            object = pSDEUAGroupDetailBase.getPSSysImageName();
            xmlNode.setAttribute(FIELD_PSSYSIMAGENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysPFPluginId() != null) {
            object = pSDEUAGroupDetailBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getPSSysPFPluginName() != null) {
            object = pSDEUAGroupDetailBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupId() != null) {
            object = pSDEUAGroupDetailBase.getRefPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_REFPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupName() != null) {
            object = pSDEUAGroupDetailBase.getRefPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_REFPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getShowMode() != null) {
            object = pSDEUAGroupDetailBase.getShowMode();
            xmlNode.setAttribute(FIELD_SHOWMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUACaption() != null) {
            object = pSDEUAGroupDetailBase.getUACaption();
            xmlNode.setAttribute(FIELD_UACAPTION, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUIActionParams() != null) {
            object = pSDEUAGroupDetailBase.getUIActionParams();
            xmlNode.setAttribute(FIELD_UIACTIONPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUpdateDate() != null) {
            object = pSDEUAGroupDetailBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getUpdateMan() != null) {
            object = pSDEUAGroupDetailBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUserCat() != null) {
            object = pSDEUAGroupDetailBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag() != null) {
            object = pSDEUAGroupDetailBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag2() != null) {
            object = pSDEUAGroupDetailBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag3() != null) {
            object = pSDEUAGroupDetailBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getUserTag4() != null) {
            object = pSDEUAGroupDetailBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEUAGroupDetailBase.getValidFlag() != null) {
            object = pSDEUAGroupDetailBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEUAGroupDetailBase.getVisibleLogic() != null) {
            object = pSDEUAGroupDetailBase.getVisibleLogic();
            xmlNode.setAttribute(FIELD_VISIBLELOGIC, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEUAGroupDetailBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEUAGroupDetailBase.isActionLevelDirty() && (bl || pSDEUAGroupDetailBase.getActionLevel() != null)) {
            iDataObject.set(FIELD_ACTIONLEVEL, (Object)pSDEUAGroupDetailBase.getActionLevel());
        }
        if (pSDEUAGroupDetailBase.isAddSeparatorDirty() && (bl || pSDEUAGroupDetailBase.getAddSeparator() != null)) {
            iDataObject.set(FIELD_ADDSEPARATOR, (Object)pSDEUAGroupDetailBase.getAddSeparator());
        }
        if (pSDEUAGroupDetailBase.isAfterContentDirty() && (bl || pSDEUAGroupDetailBase.getAfterContent() != null)) {
            iDataObject.set(FIELD_AFTERCONTENT, (Object)pSDEUAGroupDetailBase.getAfterContent());
        }
        if (pSDEUAGroupDetailBase.isAfterItemTypeDirty() && (bl || pSDEUAGroupDetailBase.getAfterItemType() != null)) {
            iDataObject.set(FIELD_AFTERITEMTYPE, (Object)pSDEUAGroupDetailBase.getAfterItemType());
        }
        if (pSDEUAGroupDetailBase.isAfterPSSysCssIdDirty() && (bl || pSDEUAGroupDetailBase.getAfterPSSysCssId() != null)) {
            iDataObject.set(FIELD_AFTERPSSYSCSSID, (Object)pSDEUAGroupDetailBase.getAfterPSSysCssId());
        }
        if (pSDEUAGroupDetailBase.isAfterPSSysCssNameDirty() && (bl || pSDEUAGroupDetailBase.getAfterPSSysCssName() != null)) {
            iDataObject.set(FIELD_AFTERPSSYSCSSNAME, (Object)pSDEUAGroupDetailBase.getAfterPSSysCssName());
        }
        if (pSDEUAGroupDetailBase.isAfterPSSysResourceIdDirty() && (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceId() != null)) {
            iDataObject.set(FIELD_AFTERPSSYSRESOURCEID, (Object)pSDEUAGroupDetailBase.getAfterPSSysResourceId());
        }
        if (pSDEUAGroupDetailBase.isAfterPSSysResourceNameDirty() && (bl || pSDEUAGroupDetailBase.getAfterPSSysResourceName() != null)) {
            iDataObject.set(FIELD_AFTERPSSYSRESOURCENAME, (Object)pSDEUAGroupDetailBase.getAfterPSSysResourceName());
        }
        if (pSDEUAGroupDetailBase.isBeforeContentDirty() && (bl || pSDEUAGroupDetailBase.getBeforeContent() != null)) {
            iDataObject.set(FIELD_BEFORECONTENT, (Object)pSDEUAGroupDetailBase.getBeforeContent());
        }
        if (pSDEUAGroupDetailBase.isBeforeItemTypeDirty() && (bl || pSDEUAGroupDetailBase.getBeforeItemType() != null)) {
            iDataObject.set(FIELD_BEFOREITEMTYPE, (Object)pSDEUAGroupDetailBase.getBeforeItemType());
        }
        if (pSDEUAGroupDetailBase.isBeforePSSysCssIdDirty() && (bl || pSDEUAGroupDetailBase.getBeforePSSysCssId() != null)) {
            iDataObject.set(FIELD_BEFOREPSSYSCSSID, (Object)pSDEUAGroupDetailBase.getBeforePSSysCssId());
        }
        if (pSDEUAGroupDetailBase.isBeforePSSysCssNameDirty() && (bl || pSDEUAGroupDetailBase.getBeforePSSysCssName() != null)) {
            iDataObject.set(FIELD_BEFOREPSSYSCSSNAME, (Object)pSDEUAGroupDetailBase.getBeforePSSysCssName());
        }
        if (pSDEUAGroupDetailBase.isBeforePSSysResourceIdDirty() && (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceId() != null)) {
            iDataObject.set(FIELD_BEFOREPSSYSRESOURCEID, (Object)pSDEUAGroupDetailBase.getBeforePSSysResourceId());
        }
        if (pSDEUAGroupDetailBase.isBeforePSSysResourceNameDirty() && (bl || pSDEUAGroupDetailBase.getBeforePSSysResourceName() != null)) {
            iDataObject.set(FIELD_BEFOREPSSYSRESOURCENAME, (Object)pSDEUAGroupDetailBase.getBeforePSSysResourceName());
        }
        if (pSDEUAGroupDetailBase.isButtonStyleDirty() && (bl || pSDEUAGroupDetailBase.getButtonStyle() != null)) {
            iDataObject.set(FIELD_BUTTONSTYLE, (Object)pSDEUAGroupDetailBase.getButtonStyle());
        }
        if (pSDEUAGroupDetailBase.isCodeNameDirty() && (bl || pSDEUAGroupDetailBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEUAGroupDetailBase.getCodeName());
        }
        if (pSDEUAGroupDetailBase.isCreateDateDirty() && (bl || pSDEUAGroupDetailBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEUAGroupDetailBase.getCreateDate());
        }
        if (pSDEUAGroupDetailBase.isCreateManDirty() && (bl || pSDEUAGroupDetailBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEUAGroupDetailBase.getCreateMan());
        }
        if (pSDEUAGroupDetailBase.isDetailTagDirty() && (bl || pSDEUAGroupDetailBase.getDetailTag() != null)) {
            iDataObject.set(FIELD_DETAILTAG, (Object)pSDEUAGroupDetailBase.getDetailTag());
        }
        if (pSDEUAGroupDetailBase.isDetailTag2Dirty() && (bl || pSDEUAGroupDetailBase.getDetailTag2() != null)) {
            iDataObject.set(FIELD_DETAILTAG2, (Object)pSDEUAGroupDetailBase.getDetailTag2());
        }
        if (pSDEUAGroupDetailBase.isDetailTypeDirty() && (bl || pSDEUAGroupDetailBase.getDetailType() != null)) {
            iDataObject.set(FIELD_DETAILTYPE, (Object)pSDEUAGroupDetailBase.getDetailType());
        }
        if (pSDEUAGroupDetailBase.isDynaModelFlagDirty() && (bl || pSDEUAGroupDetailBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSDEUAGroupDetailBase.getDynaModelFlag());
        }
        if (pSDEUAGroupDetailBase.isEnableLogicDirty() && (bl || pSDEUAGroupDetailBase.getEnableLogic() != null)) {
            iDataObject.set(FIELD_ENABLELOGIC, (Object)pSDEUAGroupDetailBase.getEnableLogic());
        }
        if (pSDEUAGroupDetailBase.isMemoDirty() && (bl || pSDEUAGroupDetailBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEUAGroupDetailBase.getMemo());
        }
        if (pSDEUAGroupDetailBase.isOrderValueDirty() && (bl || pSDEUAGroupDetailBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEUAGroupDetailBase.getOrderValue());
        }
        if (pSDEUAGroupDetailBase.isPSDEIdDirty() && (bl || pSDEUAGroupDetailBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEUAGroupDetailBase.getPSDEId());
        }
        if (pSDEUAGroupDetailBase.isPSDEUAGroupIdDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPID, (Object)pSDEUAGroupDetailBase.getPSDEUAGroupId());
        }
        if (pSDEUAGroupDetailBase.isPSDEUAGroupNameDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PSDEUAGROUPNAME, (Object)pSDEUAGroupDetailBase.getPSDEUAGroupName());
        }
        if (pSDEUAGroupDetailBase.isPSDEUAGRPDetailIdDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailId() != null)) {
            iDataObject.set(FIELD_PSDEUAGRPDETAILID, (Object)pSDEUAGroupDetailBase.getPSDEUAGRPDetailId());
        }
        if (pSDEUAGroupDetailBase.isPSDEUAGRPDetailNameDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUAGRPDetailName() != null)) {
            iDataObject.set(FIELD_PSDEUAGRPDETAILNAME, (Object)pSDEUAGroupDetailBase.getPSDEUAGRPDetailName());
        }
        if (pSDEUAGroupDetailBase.isPSDEUIActionIdDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUIActionId() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONID, (Object)pSDEUAGroupDetailBase.getPSDEUIActionId());
        }
        if (pSDEUAGroupDetailBase.isPSDEUIActionNameDirty() && (bl || pSDEUAGroupDetailBase.getPSDEUIActionName() != null)) {
            iDataObject.set(FIELD_PSDEUIACTIONNAME, (Object)pSDEUAGroupDetailBase.getPSDEUIActionName());
        }
        if (pSDEUAGroupDetailBase.isPSDynaInstIdDirty() && (bl || pSDEUAGroupDetailBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSDEUAGroupDetailBase.getPSDynaInstId());
        }
        if (pSDEUAGroupDetailBase.isPSSysCssIdDirty() && (bl || pSDEUAGroupDetailBase.getPSSysCssId() != null)) {
            iDataObject.set(FIELD_PSSYSCSSID, (Object)pSDEUAGroupDetailBase.getPSSysCssId());
        }
        if (pSDEUAGroupDetailBase.isPSSysCssNameDirty() && (bl || pSDEUAGroupDetailBase.getPSSysCssName() != null)) {
            iDataObject.set(FIELD_PSSYSCSSNAME, (Object)pSDEUAGroupDetailBase.getPSSysCssName());
        }
        if (pSDEUAGroupDetailBase.isPSSysImageIdDirty() && (bl || pSDEUAGroupDetailBase.getPSSysImageId() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGEID, (Object)pSDEUAGroupDetailBase.getPSSysImageId());
        }
        if (pSDEUAGroupDetailBase.isPSSysImageNameDirty() && (bl || pSDEUAGroupDetailBase.getPSSysImageName() != null)) {
            iDataObject.set(FIELD_PSSYSIMAGENAME, (Object)pSDEUAGroupDetailBase.getPSSysImageName());
        }
        if (pSDEUAGroupDetailBase.isPSSysPFPluginIdDirty() && (bl || pSDEUAGroupDetailBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEUAGroupDetailBase.getPSSysPFPluginId());
        }
        if (pSDEUAGroupDetailBase.isPSSysPFPluginNameDirty() && (bl || pSDEUAGroupDetailBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEUAGroupDetailBase.getPSSysPFPluginName());
        }
        if (pSDEUAGroupDetailBase.isRefPSDEUAGroupIdDirty() && (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_REFPSDEUAGROUPID, (Object)pSDEUAGroupDetailBase.getRefPSDEUAGroupId());
        }
        if (pSDEUAGroupDetailBase.isRefPSDEUAGroupNameDirty() && (bl || pSDEUAGroupDetailBase.getRefPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_REFPSDEUAGROUPNAME, (Object)pSDEUAGroupDetailBase.getRefPSDEUAGroupName());
        }
        if (pSDEUAGroupDetailBase.isShowModeDirty() && (bl || pSDEUAGroupDetailBase.getShowMode() != null)) {
            iDataObject.set(FIELD_SHOWMODE, (Object)pSDEUAGroupDetailBase.getShowMode());
        }
        if (pSDEUAGroupDetailBase.isUACaptionDirty() && (bl || pSDEUAGroupDetailBase.getUACaption() != null)) {
            iDataObject.set(FIELD_UACAPTION, (Object)pSDEUAGroupDetailBase.getUACaption());
        }
        if (pSDEUAGroupDetailBase.isUIActionParamsDirty() && (bl || pSDEUAGroupDetailBase.getUIActionParams() != null)) {
            iDataObject.set(FIELD_UIACTIONPARAMS, (Object)pSDEUAGroupDetailBase.getUIActionParams());
        }
        if (pSDEUAGroupDetailBase.isUpdateDateDirty() && (bl || pSDEUAGroupDetailBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEUAGroupDetailBase.getUpdateDate());
        }
        if (pSDEUAGroupDetailBase.isUpdateManDirty() && (bl || pSDEUAGroupDetailBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEUAGroupDetailBase.getUpdateMan());
        }
        if (pSDEUAGroupDetailBase.isUserCatDirty() && (bl || pSDEUAGroupDetailBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEUAGroupDetailBase.getUserCat());
        }
        if (pSDEUAGroupDetailBase.isUserTagDirty() && (bl || pSDEUAGroupDetailBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEUAGroupDetailBase.getUserTag());
        }
        if (pSDEUAGroupDetailBase.isUserTag2Dirty() && (bl || pSDEUAGroupDetailBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEUAGroupDetailBase.getUserTag2());
        }
        if (pSDEUAGroupDetailBase.isUserTag3Dirty() && (bl || pSDEUAGroupDetailBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEUAGroupDetailBase.getUserTag3());
        }
        if (pSDEUAGroupDetailBase.isUserTag4Dirty() && (bl || pSDEUAGroupDetailBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEUAGroupDetailBase.getUserTag4());
        }
        if (pSDEUAGroupDetailBase.isValidFlagDirty() && (bl || pSDEUAGroupDetailBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEUAGroupDetailBase.getValidFlag());
        }
        if (pSDEUAGroupDetailBase.isVisibleLogicDirty() && (bl || pSDEUAGroupDetailBase.getVisibleLogic() != null)) {
            iDataObject.set(FIELD_VISIBLELOGIC, (Object)pSDEUAGroupDetailBase.getVisibleLogic());
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
        return PSDEUAGroupDetailBase.remove(this, n);
    }

    private static boolean remove(PSDEUAGroupDetailBase pSDEUAGroupDetailBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEUAGroupDetailBase.resetActionLevel();
                return true;
            }
            case 1: {
                pSDEUAGroupDetailBase.resetAddSeparator();
                return true;
            }
            case 2: {
                pSDEUAGroupDetailBase.resetAfterContent();
                return true;
            }
            case 3: {
                pSDEUAGroupDetailBase.resetAfterItemType();
                return true;
            }
            case 4: {
                pSDEUAGroupDetailBase.resetAfterPSSysCssId();
                return true;
            }
            case 5: {
                pSDEUAGroupDetailBase.resetAfterPSSysCssName();
                return true;
            }
            case 6: {
                pSDEUAGroupDetailBase.resetAfterPSSysResourceId();
                return true;
            }
            case 7: {
                pSDEUAGroupDetailBase.resetAfterPSSysResourceName();
                return true;
            }
            case 8: {
                pSDEUAGroupDetailBase.resetBeforeContent();
                return true;
            }
            case 9: {
                pSDEUAGroupDetailBase.resetBeforeItemType();
                return true;
            }
            case 10: {
                pSDEUAGroupDetailBase.resetBeforePSSysCssId();
                return true;
            }
            case 11: {
                pSDEUAGroupDetailBase.resetBeforePSSysCssName();
                return true;
            }
            case 12: {
                pSDEUAGroupDetailBase.resetBeforePSSysResourceId();
                return true;
            }
            case 13: {
                pSDEUAGroupDetailBase.resetBeforePSSysResourceName();
                return true;
            }
            case 14: {
                pSDEUAGroupDetailBase.resetButtonStyle();
                return true;
            }
            case 15: {
                pSDEUAGroupDetailBase.resetCodeName();
                return true;
            }
            case 16: {
                pSDEUAGroupDetailBase.resetCreateDate();
                return true;
            }
            case 17: {
                pSDEUAGroupDetailBase.resetCreateMan();
                return true;
            }
            case 18: {
                pSDEUAGroupDetailBase.resetDetailTag();
                return true;
            }
            case 19: {
                pSDEUAGroupDetailBase.resetDetailTag2();
                return true;
            }
            case 20: {
                pSDEUAGroupDetailBase.resetDetailType();
                return true;
            }
            case 21: {
                pSDEUAGroupDetailBase.resetDynaModelFlag();
                return true;
            }
            case 22: {
                pSDEUAGroupDetailBase.resetEnableLogic();
                return true;
            }
            case 23: {
                pSDEUAGroupDetailBase.resetMemo();
                return true;
            }
            case 24: {
                pSDEUAGroupDetailBase.resetOrderValue();
                return true;
            }
            case 25: {
                pSDEUAGroupDetailBase.resetPSDEId();
                return true;
            }
            case 26: {
                pSDEUAGroupDetailBase.resetPSDEUAGroupId();
                return true;
            }
            case 27: {
                pSDEUAGroupDetailBase.resetPSDEUAGroupName();
                return true;
            }
            case 28: {
                pSDEUAGroupDetailBase.resetPSDEUAGRPDetailId();
                return true;
            }
            case 29: {
                pSDEUAGroupDetailBase.resetPSDEUAGRPDetailName();
                return true;
            }
            case 30: {
                pSDEUAGroupDetailBase.resetPSDEUIActionId();
                return true;
            }
            case 31: {
                pSDEUAGroupDetailBase.resetPSDEUIActionName();
                return true;
            }
            case 32: {
                pSDEUAGroupDetailBase.resetPSDynaInstId();
                return true;
            }
            case 33: {
                pSDEUAGroupDetailBase.resetPSSysCssId();
                return true;
            }
            case 34: {
                pSDEUAGroupDetailBase.resetPSSysCssName();
                return true;
            }
            case 35: {
                pSDEUAGroupDetailBase.resetPSSysImageId();
                return true;
            }
            case 36: {
                pSDEUAGroupDetailBase.resetPSSysImageName();
                return true;
            }
            case 37: {
                pSDEUAGroupDetailBase.resetPSSysPFPluginId();
                return true;
            }
            case 38: {
                pSDEUAGroupDetailBase.resetPSSysPFPluginName();
                return true;
            }
            case 39: {
                pSDEUAGroupDetailBase.resetRefPSDEUAGroupId();
                return true;
            }
            case 40: {
                pSDEUAGroupDetailBase.resetRefPSDEUAGroupName();
                return true;
            }
            case 41: {
                pSDEUAGroupDetailBase.resetShowMode();
                return true;
            }
            case 42: {
                pSDEUAGroupDetailBase.resetUACaption();
                return true;
            }
            case 43: {
                pSDEUAGroupDetailBase.resetUIActionParams();
                return true;
            }
            case 44: {
                pSDEUAGroupDetailBase.resetUpdateDate();
                return true;
            }
            case 45: {
                pSDEUAGroupDetailBase.resetUpdateMan();
                return true;
            }
            case 46: {
                pSDEUAGroupDetailBase.resetUserCat();
                return true;
            }
            case 47: {
                pSDEUAGroupDetailBase.resetUserTag();
                return true;
            }
            case 48: {
                pSDEUAGroupDetailBase.resetUserTag2();
                return true;
            }
            case 49: {
                pSDEUAGroupDetailBase.resetUserTag3();
                return true;
            }
            case 50: {
                pSDEUAGroupDetailBase.resetUserTag4();
                return true;
            }
            case 51: {
                pSDEUAGroupDetailBase.resetValidFlag();
                return true;
            }
            case 52: {
                pSDEUAGroupDetailBase.resetVisibleLogic();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public PSDEUAGroup getRefPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRefPSDEUAGroup();
        }
        if (this.getRefPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objRefPSDEUAGroupLock;
        synchronized (n) {
            if (this.refpsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getRefPSDEUAGroupId(), (Object)this.refpsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.refpsdeuagroup = null;
            }
            if (this.refpsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getRefPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet((IEntity)pSDEUAGroup);
                this.refpsdeuagroup = pSDEUAGroup;
            }
            return this.refpsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUIAction getPSDEUAAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEUAAction();
        }
        if (this.getPSDEUIActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEUAActionLock;
        synchronized (n) {
            if (this.psdeuaaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEUIActionId(), (Object)this.psdeuaaction.getPSDEUIActionId()) != 0L) {
                this.psdeuaaction = null;
            }
            if (this.psdeuaaction == null) {
                PSDEUIAction pSDEUIAction = new PSDEUIAction();
                pSDEUIAction.setPSDEUIActionId(this.getPSDEUIActionId());
                PSDEUIActionService pSDEUIActionService = (PSDEUIActionService)ServiceGlobal.getService(PSDEUIActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEUIActionService.autoGet((IEntity)pSDEUIAction);
                this.psdeuaaction = pSDEUIAction;
            }
            return this.psdeuaaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getAfterPSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysCss();
        }
        if (this.getAfterPSSysCssId() == null) {
            return null;
        }
        Integer n = this.objAfterPSSysCssLock;
        synchronized (n) {
            if (this.afterpssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getAfterPSSysCssId(), (Object)this.afterpssyscss.getPSSysCssId()) != 0L) {
                this.afterpssyscss = null;
            }
            if (this.afterpssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getAfterPSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.afterpssyscss = pSSysCss;
            }
            return this.afterpssyscss;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysCss getBeforePSSysCss() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysCss();
        }
        if (this.getBeforePSSysCssId() == null) {
            return null;
        }
        Integer n = this.objBeforePSSysCssLock;
        synchronized (n) {
            if (this.beforepssyscss != null && DataTypeHelper.compare((int)25, (Object)this.getBeforePSSysCssId(), (Object)this.beforepssyscss.getPSSysCssId()) != 0L) {
                this.beforepssyscss = null;
            }
            if (this.beforepssyscss == null) {
                PSSysCss pSSysCss = new PSSysCss();
                pSSysCss.setPSSysCssId(this.getBeforePSSysCssId());
                PSSysCssService pSSysCssService = (PSSysCssService)ServiceGlobal.getService(PSSysCssService.class, (SessionFactory)this.getSessionFactory());
                pSSysCssService.autoGet((IEntity)pSSysCss);
                this.beforepssyscss = pSSysCss;
            }
            return this.beforepssyscss;
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
    public PSSysResource getAfterPSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAfterPSSysResource();
        }
        if (this.getAfterPSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objAfterPSSysResourceLock;
        synchronized (n) {
            if (this.afterpssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getAfterPSSysResourceId(), (Object)this.afterpssysresource.getPSSysResourceId()) != 0L) {
                this.afterpssysresource = null;
            }
            if (this.afterpssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getAfterPSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.afterpssysresource = pSSysResource;
            }
            return this.afterpssysresource;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysResource getBeforePSSysResource() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBeforePSSysResource();
        }
        if (this.getBeforePSSysResourceId() == null) {
            return null;
        }
        Integer n = this.objBeforePSSysResourceLock;
        synchronized (n) {
            if (this.beforepssysresource != null && DataTypeHelper.compare((int)25, (Object)this.getBeforePSSysResourceId(), (Object)this.beforepssysresource.getPSSysResourceId()) != 0L) {
                this.beforepssysresource = null;
            }
            if (this.beforepssysresource == null) {
                PSSysResource pSSysResource = new PSSysResource();
                pSSysResource.setPSSysResourceId(this.getBeforePSSysResourceId());
                PSSysResourceService pSSysResourceService = (PSSysResourceService)ServiceGlobal.getService(PSSysResourceService.class, (SessionFactory)this.getSessionFactory());
                pSSysResourceService.autoGet((IEntity)pSSysResource);
                this.beforepssysresource = pSSysResource;
            }
            return this.beforepssysresource;
        }
    }

    private PSDEUAGroupDetailBase getProxyEntity() {
        return this.proxyPSDEUAGroupDetailBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEUAGroupDetailBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEUAGroupDetailBase) {
            this.proxyPSDEUAGroupDetailBase = (PSDEUAGroupDetailBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupDetailService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ACTIONLEVEL, 0);
        fieldIndexMap.put(FIELD_ADDSEPARATOR, 1);
        fieldIndexMap.put(FIELD_AFTERCONTENT, 2);
        fieldIndexMap.put(FIELD_AFTERITEMTYPE, 3);
        fieldIndexMap.put(FIELD_AFTERPSSYSCSSID, 4);
        fieldIndexMap.put(FIELD_AFTERPSSYSCSSNAME, 5);
        fieldIndexMap.put(FIELD_AFTERPSSYSRESOURCEID, 6);
        fieldIndexMap.put(FIELD_AFTERPSSYSRESOURCENAME, 7);
        fieldIndexMap.put(FIELD_BEFORECONTENT, 8);
        fieldIndexMap.put(FIELD_BEFOREITEMTYPE, 9);
        fieldIndexMap.put(FIELD_BEFOREPSSYSCSSID, 10);
        fieldIndexMap.put(FIELD_BEFOREPSSYSCSSNAME, 11);
        fieldIndexMap.put(FIELD_BEFOREPSSYSRESOURCEID, 12);
        fieldIndexMap.put(FIELD_BEFOREPSSYSRESOURCENAME, 13);
        fieldIndexMap.put(FIELD_BUTTONSTYLE, 14);
        fieldIndexMap.put(FIELD_CODENAME, 15);
        fieldIndexMap.put(FIELD_CREATEDATE, 16);
        fieldIndexMap.put(FIELD_CREATEMAN, 17);
        fieldIndexMap.put(FIELD_DETAILTAG, 18);
        fieldIndexMap.put(FIELD_DETAILTAG2, 19);
        fieldIndexMap.put(FIELD_DETAILTYPE, 20);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 21);
        fieldIndexMap.put(FIELD_ENABLELOGIC, 22);
        fieldIndexMap.put(FIELD_MEMO, 23);
        fieldIndexMap.put(FIELD_ORDERVALUE, 24);
        fieldIndexMap.put(FIELD_PSDEID, 25);
        fieldIndexMap.put(FIELD_PSDEUAGROUPID, 26);
        fieldIndexMap.put(FIELD_PSDEUAGROUPNAME, 27);
        fieldIndexMap.put(FIELD_PSDEUAGRPDETAILID, 28);
        fieldIndexMap.put(FIELD_PSDEUAGRPDETAILNAME, 29);
        fieldIndexMap.put(FIELD_PSDEUIACTIONID, 30);
        fieldIndexMap.put(FIELD_PSDEUIACTIONNAME, 31);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 32);
        fieldIndexMap.put(FIELD_PSSYSCSSID, 33);
        fieldIndexMap.put(FIELD_PSSYSCSSNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSIMAGEID, 35);
        fieldIndexMap.put(FIELD_PSSYSIMAGENAME, 36);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 37);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 38);
        fieldIndexMap.put(FIELD_REFPSDEUAGROUPID, 39);
        fieldIndexMap.put(FIELD_REFPSDEUAGROUPNAME, 40);
        fieldIndexMap.put(FIELD_SHOWMODE, 41);
        fieldIndexMap.put(FIELD_UACAPTION, 42);
        fieldIndexMap.put(FIELD_UIACTIONPARAMS, 43);
        fieldIndexMap.put(FIELD_UPDATEDATE, 44);
        fieldIndexMap.put(FIELD_UPDATEMAN, 45);
        fieldIndexMap.put(FIELD_USERCAT, 46);
        fieldIndexMap.put(FIELD_USERTAG, 47);
        fieldIndexMap.put(FIELD_USERTAG2, 48);
        fieldIndexMap.put(FIELD_USERTAG3, 49);
        fieldIndexMap.put(FIELD_USERTAG4, 50);
        fieldIndexMap.put(FIELD_VALIDFLAG, 51);
        fieldIndexMap.put(FIELD_VISIBLELOGIC, 52);
    }
}

