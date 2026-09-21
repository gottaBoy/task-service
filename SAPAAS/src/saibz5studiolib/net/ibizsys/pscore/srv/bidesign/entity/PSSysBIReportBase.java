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
package net.ibizsys.pscore.srv.bidesign.entity;

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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICube;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIReportItem;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportItemService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.entity.PSSysResource;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.config.service.PSSysResourceService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysViewPanel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSViewMsgGroup;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysViewPanelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSViewMsgGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIReportBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIReportBase.class);
    public static final String FIELD_BIREPORTMODEL = "BIREPORTMODEL";
    public static final String FIELD_BIREPORTPARAMS = "BIREPORTPARAMS";
    public static final String FIELD_BIREPORTTAG = "BIREPORTTAG";
    public static final String FIELD_BIREPORTTAG2 = "BIREPORTTAG2";
    public static final String FIELD_BIREPORTUIMODEL = "BIREPORTUIMODEL";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBIREPORTID = "PSSYSBIREPORTID";
    public static final String FIELD_PSSYSBIREPORTNAME = "PSSYSBIREPORTNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSRESOURCEID = "PSSYSRESOURCEID";
    public static final String FIELD_PSSYSRESOURCENAME = "PSSYSRESOURCENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_PSSYSVIEWPANELID = "PSSYSVIEWPANELID";
    public static final String FIELD_PSSYSVIEWPANELNAME = "PSSYSVIEWPANELNAME";
    public static final String FIELD_PSVIEWMSGGROUPID = "PSVIEWMSGGROUPID";
    public static final String FIELD_PSVIEWMSGGROUPNAME = "PSVIEWMSGGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BIREPORTMODEL = 0;
    private static final int INDEX_BIREPORTPARAMS = 1;
    private static final int INDEX_BIREPORTTAG = 2;
    private static final int INDEX_BIREPORTTAG2 = 3;
    private static final int INDEX_BIREPORTUIMODEL = 4;
    private static final int INDEX_CODENAME = 5;
    private static final int INDEX_CREATEDATE = 6;
    private static final int INDEX_CREATEMAN = 7;
    private static final int INDEX_ENABLECUSTOMIZED = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSSYSBICUBEID = 10;
    private static final int INDEX_PSSYSBICUBENAME = 11;
    private static final int INDEX_PSSYSBIREPORTID = 12;
    private static final int INDEX_PSSYSBIREPORTNAME = 13;
    private static final int INDEX_PSSYSBISCHEMEID = 14;
    private static final int INDEX_PSSYSBISCHEMENAME = 15;
    private static final int INDEX_PSSYSPFPLUGINID = 16;
    private static final int INDEX_PSSYSPFPLUGINNAME = 17;
    private static final int INDEX_PSSYSRESOURCEID = 18;
    private static final int INDEX_PSSYSRESOURCENAME = 19;
    private static final int INDEX_PSSYSSFPLUGINID = 20;
    private static final int INDEX_PSSYSSFPLUGINNAME = 21;
    private static final int INDEX_PSSYSUNIRESID = 22;
    private static final int INDEX_PSSYSUNIRESNAME = 23;
    private static final int INDEX_PSSYSVIEWPANELID = 24;
    private static final int INDEX_PSSYSVIEWPANELNAME = 25;
    private static final int INDEX_PSVIEWMSGGROUPID = 26;
    private static final int INDEX_PSVIEWMSGGROUPNAME = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERCAT = 30;
    private static final int INDEX_USERTAG = 31;
    private static final int INDEX_USERTAG2 = 32;
    private static final int INDEX_USERTAG3 = 33;
    private static final int INDEX_USERTAG4 = 34;
    private static final int INDEX_VALIDFLAG = 35;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIReportBase proxyPSSysBIReportBase = null;
    private boolean bireportmodelDirtyFlag = false;
    private boolean bireportparamsDirtyFlag = false;
    private boolean bireporttagDirtyFlag = false;
    private boolean bireporttag2DirtyFlag = false;
    private boolean bireportuimodelDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbireportidDirtyFlag = false;
    private boolean pssysbireportnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysresourceidDirtyFlag = false;
    private boolean pssysresourcenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean pssysviewpanelidDirtyFlag = false;
    private boolean pssysviewpanelnameDirtyFlag = false;
    private boolean psviewmsggroupidDirtyFlag = false;
    private boolean psviewmsggroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bireportmodel")
    private String bireportmodel;
    @Column(name="bireportparams")
    private String bireportparams;
    @Column(name="bireporttag")
    private String bireporttag;
    @Column(name="bireporttag2")
    private String bireporttag2;
    @Column(name="bireportuimodel")
    private String bireportuimodel;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbireportid")
    private String pssysbireportid;
    @Column(name="pssysbireportname")
    private String pssysbireportname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysresourceid")
    private String pssysresourceid;
    @Column(name="pssysresourcename")
    private String pssysresourcename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="pssysviewpanelid")
    private String pssysviewpanelid;
    @Column(name="pssysviewpanelname")
    private String pssysviewpanelname;
    @Column(name="psviewmsggroupid")
    private String psviewmsggroupid;
    @Column(name="psviewmsggroupname")
    private String psviewmsggroupname;
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
    private Integer objPSSysBICubeLock = new Integer(1);
    private PSSysBICube pssysbicube = null;
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objPSSysResourceLock = new Integer(1);
    private PSSysResource pssysresource = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysViewPanelLock = new Integer(1);
    private PSSysViewPanel pssysviewpanel = null;
    private Integer objPSViewMsgGroupLock = new Integer(1);
    private PSViewMsgGroup psviewmsggroup = null;
    private Integer objPSSysBIReportItemsLock = new Integer(1);
    private ArrayList<PSSysBIReportItem> pssysbireportitems = null;

    public void setBIReportModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIReportModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bireportmodel = string;
        this.bireportmodelDirtyFlag = true;
    }

    public String getBIReportModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIReportModel();
        }
        return this.bireportmodel;
    }

    public boolean isBIReportModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIReportModelDirty();
        }
        return this.bireportmodelDirtyFlag;
    }

    public void resetBIReportModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIReportModel();
            return;
        }
        this.bireportmodelDirtyFlag = false;
        this.bireportmodel = null;
    }

    public void setBIReportParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIReportParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bireportparams = string;
        this.bireportparamsDirtyFlag = true;
    }

    public String getBIReportParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIReportParams();
        }
        return this.bireportparams;
    }

    public boolean isBIReportParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIReportParamsDirty();
        }
        return this.bireportparamsDirtyFlag;
    }

    public void resetBIReportParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIReportParams();
            return;
        }
        this.bireportparamsDirtyFlag = false;
        this.bireportparams = null;
    }

    public void setBIReportTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIReportTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bireporttag = string;
        this.bireporttagDirtyFlag = true;
    }

    public String getBIReportTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIReportTag();
        }
        return this.bireporttag;
    }

    public boolean isBIReportTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIReportTagDirty();
        }
        return this.bireporttagDirtyFlag;
    }

    public void resetBIReportTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIReportTag();
            return;
        }
        this.bireporttagDirtyFlag = false;
        this.bireporttag = null;
    }

    public void setBIReportTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIReportTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bireporttag2 = string;
        this.bireporttag2DirtyFlag = true;
    }

    public String getBIReportTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIReportTag2();
        }
        return this.bireporttag2;
    }

    public boolean isBIReportTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIReportTag2Dirty();
        }
        return this.bireporttag2DirtyFlag;
    }

    public void resetBIReportTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIReportTag2();
            return;
        }
        this.bireporttag2DirtyFlag = false;
        this.bireporttag2 = null;
    }

    public void setBIReportUIModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIReportUIModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bireportuimodel = string;
        this.bireportuimodelDirtyFlag = true;
    }

    public String getBIReportUIModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIReportUIModel();
        }
        return this.bireportuimodel;
    }

    public boolean isBIReportUIModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIReportUIModelDirty();
        }
        return this.bireportuimodelDirtyFlag;
    }

    public void resetBIReportUIModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIReportUIModel();
            return;
        }
        this.bireportuimodelDirtyFlag = false;
        this.bireportuimodel = null;
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

    public void setEnableCustomized(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableCustomized(n);
            return;
        }
        this.enablecustomized = n;
        this.enablecustomizedDirtyFlag = true;
    }

    public Integer getEnableCustomized() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableCustomized();
        }
        return this.enablecustomized;
    }

    public boolean isEnableCustomizedDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableCustomizedDirty();
        }
        return this.enablecustomizedDirtyFlag;
    }

    public void resetEnableCustomized() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableCustomized();
            return;
        }
        this.enablecustomizedDirtyFlag = false;
        this.enablecustomized = null;
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

    public void setPSSysBICubeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubeid = string;
        this.pssysbicubeidDirtyFlag = true;
    }

    public String getPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeId();
        }
        return this.pssysbicubeid;
    }

    public boolean isPSSysBICubeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeIdDirty();
        }
        return this.pssysbicubeidDirtyFlag;
    }

    public void resetPSSysBICubeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeId();
            return;
        }
        this.pssysbicubeidDirtyFlag = false;
        this.pssysbicubeid = null;
    }

    public void setPSSysBICubeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBICubeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbicubename = string;
        this.pssysbicubenameDirtyFlag = true;
    }

    public String getPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeName();
        }
        return this.pssysbicubename;
    }

    public boolean isPSSysBICubeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBICubeNameDirty();
        }
        return this.pssysbicubenameDirtyFlag;
    }

    public void resetPSSysBICubeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBICubeName();
            return;
        }
        this.pssysbicubenameDirtyFlag = false;
        this.pssysbicubename = null;
    }

    public void setPSSysBIReportId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportid = string;
        this.pssysbireportidDirtyFlag = true;
    }

    public String getPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportId();
        }
        return this.pssysbireportid;
    }

    public boolean isPSSysBIReportIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportIdDirty();
        }
        return this.pssysbireportidDirtyFlag;
    }

    public void resetPSSysBIReportId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportId();
            return;
        }
        this.pssysbireportidDirtyFlag = false;
        this.pssysbireportid = null;
    }

    public void setPSSysBIReportName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIReportName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbireportname = string;
        this.pssysbireportnameDirtyFlag = true;
    }

    public String getPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportName();
        }
        return this.pssysbireportname;
    }

    public boolean isPSSysBIReportNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIReportNameDirty();
        }
        return this.pssysbireportnameDirtyFlag;
    }

    public void resetPSSysBIReportName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIReportName();
            return;
        }
        this.pssysbireportnameDirtyFlag = false;
        this.pssysbireportname = null;
    }

    public void setPSSysBISchemeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemeid = string;
        this.pssysbischemeidDirtyFlag = true;
    }

    public String getPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeId();
        }
        return this.pssysbischemeid;
    }

    public boolean isPSSysBISchemeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeIdDirty();
        }
        return this.pssysbischemeidDirtyFlag;
    }

    public void resetPSSysBISchemeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeId();
            return;
        }
        this.pssysbischemeidDirtyFlag = false;
        this.pssysbischemeid = null;
    }

    public void setPSSysBISchemeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBISchemeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbischemename = string;
        this.pssysbischemenameDirtyFlag = true;
    }

    public String getPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBISchemeName();
        }
        return this.pssysbischemename;
    }

    public boolean isPSSysBISchemeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBISchemeNameDirty();
        }
        return this.pssysbischemenameDirtyFlag;
    }

    public void resetPSSysBISchemeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBISchemeName();
            return;
        }
        this.pssysbischemenameDirtyFlag = false;
        this.pssysbischemename = null;
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

    public void setPSSysSFPluginId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginid = string;
        this.pssyssfpluginidDirtyFlag = true;
    }

    public String getPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginId();
        }
        return this.pssyssfpluginid;
    }

    public boolean isPSSysSFPluginIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginIdDirty();
        }
        return this.pssyssfpluginidDirtyFlag;
    }

    public void resetPSSysSFPluginId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginId();
            return;
        }
        this.pssyssfpluginidDirtyFlag = false;
        this.pssyssfpluginid = null;
    }

    public void setPSSysSFPluginName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPluginName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpluginname = string;
        this.pssyssfpluginnameDirtyFlag = true;
    }

    public String getPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPluginName();
        }
        return this.pssyssfpluginname;
    }

    public boolean isPSSysSFPluginNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPluginNameDirty();
        }
        return this.pssyssfpluginnameDirtyFlag;
    }

    public void resetPSSysSFPluginName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPluginName();
            return;
        }
        this.pssyssfpluginnameDirtyFlag = false;
        this.pssyssfpluginname = null;
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

    public void setPSViewMsgGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupid = string;
        this.psviewmsggroupidDirtyFlag = true;
    }

    public String getPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupId();
        }
        return this.psviewmsggroupid;
    }

    public boolean isPSViewMsgGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupIdDirty();
        }
        return this.psviewmsggroupidDirtyFlag;
    }

    public void resetPSViewMsgGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupId();
            return;
        }
        this.psviewmsggroupidDirtyFlag = false;
        this.psviewmsggroupid = null;
    }

    public void setPSViewMsgGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewMsgGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewmsggroupname = string;
        this.psviewmsggroupnameDirtyFlag = true;
    }

    public String getPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroupName();
        }
        return this.psviewmsggroupname;
    }

    public boolean isPSViewMsgGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewMsgGroupNameDirty();
        }
        return this.psviewmsggroupnameDirtyFlag;
    }

    public void resetPSViewMsgGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewMsgGroupName();
            return;
        }
        this.psviewmsggroupnameDirtyFlag = false;
        this.psviewmsggroupname = null;
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

    protected void onReset() {
        PSSysBIReportBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIReportBase pSSysBIReportBase) {
        pSSysBIReportBase.resetBIReportModel();
        pSSysBIReportBase.resetBIReportParams();
        pSSysBIReportBase.resetBIReportTag();
        pSSysBIReportBase.resetBIReportTag2();
        pSSysBIReportBase.resetBIReportUIModel();
        pSSysBIReportBase.resetCodeName();
        pSSysBIReportBase.resetCreateDate();
        pSSysBIReportBase.resetCreateMan();
        pSSysBIReportBase.resetEnableCustomized();
        pSSysBIReportBase.resetMemo();
        pSSysBIReportBase.resetPSSysBICubeId();
        pSSysBIReportBase.resetPSSysBICubeName();
        pSSysBIReportBase.resetPSSysBIReportId();
        pSSysBIReportBase.resetPSSysBIReportName();
        pSSysBIReportBase.resetPSSysBISchemeId();
        pSSysBIReportBase.resetPSSysBISchemeName();
        pSSysBIReportBase.resetPSSysPFPluginId();
        pSSysBIReportBase.resetPSSysPFPluginName();
        pSSysBIReportBase.resetPSSysResourceId();
        pSSysBIReportBase.resetPSSysResourceName();
        pSSysBIReportBase.resetPSSysSFPluginId();
        pSSysBIReportBase.resetPSSysSFPluginName();
        pSSysBIReportBase.resetPSSysUniResId();
        pSSysBIReportBase.resetPSSysUniResName();
        pSSysBIReportBase.resetPSSysViewPanelId();
        pSSysBIReportBase.resetPSSysViewPanelName();
        pSSysBIReportBase.resetPSViewMsgGroupId();
        pSSysBIReportBase.resetPSViewMsgGroupName();
        pSSysBIReportBase.resetUpdateDate();
        pSSysBIReportBase.resetUpdateMan();
        pSSysBIReportBase.resetUserCat();
        pSSysBIReportBase.resetUserTag();
        pSSysBIReportBase.resetUserTag2();
        pSSysBIReportBase.resetUserTag3();
        pSSysBIReportBase.resetUserTag4();
        pSSysBIReportBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBIReportModelDirty()) {
            hashMap.put(FIELD_BIREPORTMODEL, this.getBIReportModel());
        }
        if (!bl || this.isBIReportParamsDirty()) {
            hashMap.put(FIELD_BIREPORTPARAMS, this.getBIReportParams());
        }
        if (!bl || this.isBIReportTagDirty()) {
            hashMap.put(FIELD_BIREPORTTAG, this.getBIReportTag());
        }
        if (!bl || this.isBIReportTag2Dirty()) {
            hashMap.put(FIELD_BIREPORTTAG2, this.getBIReportTag2());
        }
        if (!bl || this.isBIReportUIModelDirty()) {
            hashMap.put(FIELD_BIREPORTUIMODEL, this.getBIReportUIModel());
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
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBIReportIdDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTID, this.getPSSysBIReportId());
        }
        if (!bl || this.isPSSysBIReportNameDirty()) {
            hashMap.put(FIELD_PSSYSBIREPORTNAME, this.getPSSysBIReportName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysResourceIdDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCEID, this.getPSSysResourceId());
        }
        if (!bl || this.isPSSysResourceNameDirty()) {
            hashMap.put(FIELD_PSSYSRESOURCENAME, this.getPSSysResourceName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSysUniResIdDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESID, this.getPSSysUniResId());
        }
        if (!bl || this.isPSSysUniResNameDirty()) {
            hashMap.put(FIELD_PSSYSUNIRESNAME, this.getPSSysUniResName());
        }
        if (!bl || this.isPSSysViewPanelIdDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELID, this.getPSSysViewPanelId());
        }
        if (!bl || this.isPSSysViewPanelNameDirty()) {
            hashMap.put(FIELD_PSSYSVIEWPANELNAME, this.getPSSysViewPanelName());
        }
        if (!bl || this.isPSViewMsgGroupIdDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPID, this.getPSViewMsgGroupId());
        }
        if (!bl || this.isPSViewMsgGroupNameDirty()) {
            hashMap.put(FIELD_PSVIEWMSGGROUPNAME, this.getPSViewMsgGroupName());
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
        return PSSysBIReportBase.get(this, n);
    }

    private static Object get(PSSysBIReportBase pSSysBIReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportBase.getBIReportModel();
            }
            case 1: {
                return pSSysBIReportBase.getBIReportParams();
            }
            case 2: {
                return pSSysBIReportBase.getBIReportTag();
            }
            case 3: {
                return pSSysBIReportBase.getBIReportTag2();
            }
            case 4: {
                return pSSysBIReportBase.getBIReportUIModel();
            }
            case 5: {
                return pSSysBIReportBase.getCodeName();
            }
            case 6: {
                return pSSysBIReportBase.getCreateDate();
            }
            case 7: {
                return pSSysBIReportBase.getCreateMan();
            }
            case 8: {
                return pSSysBIReportBase.getEnableCustomized();
            }
            case 9: {
                return pSSysBIReportBase.getMemo();
            }
            case 10: {
                return pSSysBIReportBase.getPSSysBICubeId();
            }
            case 11: {
                return pSSysBIReportBase.getPSSysBICubeName();
            }
            case 12: {
                return pSSysBIReportBase.getPSSysBIReportId();
            }
            case 13: {
                return pSSysBIReportBase.getPSSysBIReportName();
            }
            case 14: {
                return pSSysBIReportBase.getPSSysBISchemeId();
            }
            case 15: {
                return pSSysBIReportBase.getPSSysBISchemeName();
            }
            case 16: {
                return pSSysBIReportBase.getPSSysPFPluginId();
            }
            case 17: {
                return pSSysBIReportBase.getPSSysPFPluginName();
            }
            case 18: {
                return pSSysBIReportBase.getPSSysResourceId();
            }
            case 19: {
                return pSSysBIReportBase.getPSSysResourceName();
            }
            case 20: {
                return pSSysBIReportBase.getPSSysSFPluginId();
            }
            case 21: {
                return pSSysBIReportBase.getPSSysSFPluginName();
            }
            case 22: {
                return pSSysBIReportBase.getPSSysUniResId();
            }
            case 23: {
                return pSSysBIReportBase.getPSSysUniResName();
            }
            case 24: {
                return pSSysBIReportBase.getPSSysViewPanelId();
            }
            case 25: {
                return pSSysBIReportBase.getPSSysViewPanelName();
            }
            case 26: {
                return pSSysBIReportBase.getPSViewMsgGroupId();
            }
            case 27: {
                return pSSysBIReportBase.getPSViewMsgGroupName();
            }
            case 28: {
                return pSSysBIReportBase.getUpdateDate();
            }
            case 29: {
                return pSSysBIReportBase.getUpdateMan();
            }
            case 30: {
                return pSSysBIReportBase.getUserCat();
            }
            case 31: {
                return pSSysBIReportBase.getUserTag();
            }
            case 32: {
                return pSSysBIReportBase.getUserTag2();
            }
            case 33: {
                return pSSysBIReportBase.getUserTag3();
            }
            case 34: {
                return pSSysBIReportBase.getUserTag4();
            }
            case 35: {
                return pSSysBIReportBase.getValidFlag();
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
        PSSysBIReportBase.set(this, n, object);
    }

    private static void set(PSSysBIReportBase pSSysBIReportBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIReportBase.setBIReportModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIReportBase.setBIReportParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIReportBase.setBIReportTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIReportBase.setBIReportTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIReportBase.setBIReportUIModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIReportBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIReportBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIReportBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIReportBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIReportBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIReportBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIReportBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIReportBase.setPSSysBIReportId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIReportBase.setPSSysBIReportName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIReportBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIReportBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIReportBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIReportBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIReportBase.setPSSysResourceId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIReportBase.setPSSysResourceName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBIReportBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBIReportBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBIReportBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBIReportBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBIReportBase.setPSSysViewPanelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBIReportBase.setPSSysViewPanelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBIReportBase.setPSViewMsgGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBIReportBase.setPSViewMsgGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBIReportBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSSysBIReportBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBIReportBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBIReportBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBIReportBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBIReportBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSSysBIReportBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBIReportBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBIReportBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIReportBase pSSysBIReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportBase.getBIReportModel() == null;
            }
            case 1: {
                return pSSysBIReportBase.getBIReportParams() == null;
            }
            case 2: {
                return pSSysBIReportBase.getBIReportTag() == null;
            }
            case 3: {
                return pSSysBIReportBase.getBIReportTag2() == null;
            }
            case 4: {
                return pSSysBIReportBase.getBIReportUIModel() == null;
            }
            case 5: {
                return pSSysBIReportBase.getCodeName() == null;
            }
            case 6: {
                return pSSysBIReportBase.getCreateDate() == null;
            }
            case 7: {
                return pSSysBIReportBase.getCreateMan() == null;
            }
            case 8: {
                return pSSysBIReportBase.getEnableCustomized() == null;
            }
            case 9: {
                return pSSysBIReportBase.getMemo() == null;
            }
            case 10: {
                return pSSysBIReportBase.getPSSysBICubeId() == null;
            }
            case 11: {
                return pSSysBIReportBase.getPSSysBICubeName() == null;
            }
            case 12: {
                return pSSysBIReportBase.getPSSysBIReportId() == null;
            }
            case 13: {
                return pSSysBIReportBase.getPSSysBIReportName() == null;
            }
            case 14: {
                return pSSysBIReportBase.getPSSysBISchemeId() == null;
            }
            case 15: {
                return pSSysBIReportBase.getPSSysBISchemeName() == null;
            }
            case 16: {
                return pSSysBIReportBase.getPSSysPFPluginId() == null;
            }
            case 17: {
                return pSSysBIReportBase.getPSSysPFPluginName() == null;
            }
            case 18: {
                return pSSysBIReportBase.getPSSysResourceId() == null;
            }
            case 19: {
                return pSSysBIReportBase.getPSSysResourceName() == null;
            }
            case 20: {
                return pSSysBIReportBase.getPSSysSFPluginId() == null;
            }
            case 21: {
                return pSSysBIReportBase.getPSSysSFPluginName() == null;
            }
            case 22: {
                return pSSysBIReportBase.getPSSysUniResId() == null;
            }
            case 23: {
                return pSSysBIReportBase.getPSSysUniResName() == null;
            }
            case 24: {
                return pSSysBIReportBase.getPSSysViewPanelId() == null;
            }
            case 25: {
                return pSSysBIReportBase.getPSSysViewPanelName() == null;
            }
            case 26: {
                return pSSysBIReportBase.getPSViewMsgGroupId() == null;
            }
            case 27: {
                return pSSysBIReportBase.getPSViewMsgGroupName() == null;
            }
            case 28: {
                return pSSysBIReportBase.getUpdateDate() == null;
            }
            case 29: {
                return pSSysBIReportBase.getUpdateMan() == null;
            }
            case 30: {
                return pSSysBIReportBase.getUserCat() == null;
            }
            case 31: {
                return pSSysBIReportBase.getUserTag() == null;
            }
            case 32: {
                return pSSysBIReportBase.getUserTag2() == null;
            }
            case 33: {
                return pSSysBIReportBase.getUserTag3() == null;
            }
            case 34: {
                return pSSysBIReportBase.getUserTag4() == null;
            }
            case 35: {
                return pSSysBIReportBase.getValidFlag() == null;
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
        return PSSysBIReportBase.contains(this, n);
    }

    private static boolean contains(PSSysBIReportBase pSSysBIReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIReportBase.isBIReportModelDirty();
            }
            case 1: {
                return pSSysBIReportBase.isBIReportParamsDirty();
            }
            case 2: {
                return pSSysBIReportBase.isBIReportTagDirty();
            }
            case 3: {
                return pSSysBIReportBase.isBIReportTag2Dirty();
            }
            case 4: {
                return pSSysBIReportBase.isBIReportUIModelDirty();
            }
            case 5: {
                return pSSysBIReportBase.isCodeNameDirty();
            }
            case 6: {
                return pSSysBIReportBase.isCreateDateDirty();
            }
            case 7: {
                return pSSysBIReportBase.isCreateManDirty();
            }
            case 8: {
                return pSSysBIReportBase.isEnableCustomizedDirty();
            }
            case 9: {
                return pSSysBIReportBase.isMemoDirty();
            }
            case 10: {
                return pSSysBIReportBase.isPSSysBICubeIdDirty();
            }
            case 11: {
                return pSSysBIReportBase.isPSSysBICubeNameDirty();
            }
            case 12: {
                return pSSysBIReportBase.isPSSysBIReportIdDirty();
            }
            case 13: {
                return pSSysBIReportBase.isPSSysBIReportNameDirty();
            }
            case 14: {
                return pSSysBIReportBase.isPSSysBISchemeIdDirty();
            }
            case 15: {
                return pSSysBIReportBase.isPSSysBISchemeNameDirty();
            }
            case 16: {
                return pSSysBIReportBase.isPSSysPFPluginIdDirty();
            }
            case 17: {
                return pSSysBIReportBase.isPSSysPFPluginNameDirty();
            }
            case 18: {
                return pSSysBIReportBase.isPSSysResourceIdDirty();
            }
            case 19: {
                return pSSysBIReportBase.isPSSysResourceNameDirty();
            }
            case 20: {
                return pSSysBIReportBase.isPSSysSFPluginIdDirty();
            }
            case 21: {
                return pSSysBIReportBase.isPSSysSFPluginNameDirty();
            }
            case 22: {
                return pSSysBIReportBase.isPSSysUniResIdDirty();
            }
            case 23: {
                return pSSysBIReportBase.isPSSysUniResNameDirty();
            }
            case 24: {
                return pSSysBIReportBase.isPSSysViewPanelIdDirty();
            }
            case 25: {
                return pSSysBIReportBase.isPSSysViewPanelNameDirty();
            }
            case 26: {
                return pSSysBIReportBase.isPSViewMsgGroupIdDirty();
            }
            case 27: {
                return pSSysBIReportBase.isPSViewMsgGroupNameDirty();
            }
            case 28: {
                return pSSysBIReportBase.isUpdateDateDirty();
            }
            case 29: {
                return pSSysBIReportBase.isUpdateManDirty();
            }
            case 30: {
                return pSSysBIReportBase.isUserCatDirty();
            }
            case 31: {
                return pSSysBIReportBase.isUserTagDirty();
            }
            case 32: {
                return pSSysBIReportBase.isUserTag2Dirty();
            }
            case 33: {
                return pSSysBIReportBase.isUserTag3Dirty();
            }
            case 34: {
                return pSSysBIReportBase.isUserTag4Dirty();
            }
            case 35: {
                return pSSysBIReportBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIReportBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIReportBase pSSysBIReportBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIReportBase.getBIReportModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bireportmodel", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getBIReportModel()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getBIReportParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bireportparams", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getBIReportParams()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getBIReportTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bireporttag", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getBIReportTag()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getBIReportTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bireporttag2", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getBIReportTag2()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getBIReportUIModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bireportuimodel", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getBIReportUIModel()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBIReportId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBIReportId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBIReportName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbireportname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBIReportName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysResourceId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourceid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysResourceId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysResourceName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysresourcename", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysResourceName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysViewPanelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysViewPanelId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSSysViewPanelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysviewpanelname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSSysViewPanelName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSViewMsgGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupid", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSViewMsgGroupId()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getPSViewMsgGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewmsggroupname", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getPSViewMsgGroupName()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIReportBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIReportBase.getJSONValue((Object)pSSysBIReportBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIReportBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIReportBase pSSysBIReportBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIReportBase.getBIReportModel() != null) {
            object = pSSysBIReportBase.getBIReportModel();
            xmlNode.setAttribute(FIELD_BIREPORTMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportBase.getBIReportParams() != null) {
            object = pSSysBIReportBase.getBIReportParams();
            xmlNode.setAttribute(FIELD_BIREPORTPARAMS, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportBase.getBIReportTag() != null) {
            object = pSSysBIReportBase.getBIReportTag();
            xmlNode.setAttribute(FIELD_BIREPORTTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportBase.getBIReportTag2() != null) {
            object = pSSysBIReportBase.getBIReportTag2();
            xmlNode.setAttribute(FIELD_BIREPORTTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportBase.getBIReportUIModel() != null) {
            object = pSSysBIReportBase.getBIReportUIModel();
            xmlNode.setAttribute(FIELD_BIREPORTUIMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIReportBase.getCodeName() != null) {
            object = pSSysBIReportBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getCreateDate() != null) {
            object = pSSysBIReportBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIReportBase.getCreateMan() != null) {
            object = pSSysBIReportBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getEnableCustomized() != null) {
            object = pSSysBIReportBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBIReportBase.getMemo() != null) {
            object = pSSysBIReportBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBICubeId() != null) {
            object = pSSysBIReportBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBICubeName() != null) {
            object = pSSysBIReportBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBIReportId() != null) {
            object = pSSysBIReportBase.getPSSysBIReportId();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBIReportName() != null) {
            object = pSSysBIReportBase.getPSSysBIReportName();
            xmlNode.setAttribute(FIELD_PSSYSBIREPORTNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBISchemeId() != null) {
            object = pSSysBIReportBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysBISchemeName() != null) {
            object = pSSysBIReportBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysPFPluginId() != null) {
            object = pSSysBIReportBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysPFPluginName() != null) {
            object = pSSysBIReportBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysResourceId() != null) {
            object = pSSysBIReportBase.getPSSysResourceId();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysResourceName() != null) {
            object = pSSysBIReportBase.getPSSysResourceName();
            xmlNode.setAttribute(FIELD_PSSYSRESOURCENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysSFPluginId() != null) {
            object = pSSysBIReportBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysSFPluginName() != null) {
            object = pSSysBIReportBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysUniResId() != null) {
            object = pSSysBIReportBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysUniResName() != null) {
            object = pSSysBIReportBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysViewPanelId() != null) {
            object = pSSysBIReportBase.getPSSysViewPanelId();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSSysViewPanelName() != null) {
            object = pSSysBIReportBase.getPSSysViewPanelName();
            xmlNode.setAttribute(FIELD_PSSYSVIEWPANELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSViewMsgGroupId() != null) {
            object = pSSysBIReportBase.getPSViewMsgGroupId();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getPSViewMsgGroupName() != null) {
            object = pSSysBIReportBase.getPSViewMsgGroupName();
            xmlNode.setAttribute(FIELD_PSVIEWMSGGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUpdateDate() != null) {
            object = pSSysBIReportBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIReportBase.getUpdateMan() != null) {
            object = pSSysBIReportBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUserCat() != null) {
            object = pSSysBIReportBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUserTag() != null) {
            object = pSSysBIReportBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUserTag2() != null) {
            object = pSSysBIReportBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUserTag3() != null) {
            object = pSSysBIReportBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getUserTag4() != null) {
            object = pSSysBIReportBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIReportBase.getValidFlag() != null) {
            object = pSSysBIReportBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIReportBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIReportBase pSSysBIReportBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIReportBase.isBIReportModelDirty() && (bl || pSSysBIReportBase.getBIReportModel() != null)) {
            iDataObject.set(FIELD_BIREPORTMODEL, (Object)pSSysBIReportBase.getBIReportModel());
        }
        if (pSSysBIReportBase.isBIReportParamsDirty() && (bl || pSSysBIReportBase.getBIReportParams() != null)) {
            iDataObject.set(FIELD_BIREPORTPARAMS, (Object)pSSysBIReportBase.getBIReportParams());
        }
        if (pSSysBIReportBase.isBIReportTagDirty() && (bl || pSSysBIReportBase.getBIReportTag() != null)) {
            iDataObject.set(FIELD_BIREPORTTAG, (Object)pSSysBIReportBase.getBIReportTag());
        }
        if (pSSysBIReportBase.isBIReportTag2Dirty() && (bl || pSSysBIReportBase.getBIReportTag2() != null)) {
            iDataObject.set(FIELD_BIREPORTTAG2, (Object)pSSysBIReportBase.getBIReportTag2());
        }
        if (pSSysBIReportBase.isBIReportUIModelDirty() && (bl || pSSysBIReportBase.getBIReportUIModel() != null)) {
            iDataObject.set(FIELD_BIREPORTUIMODEL, (Object)pSSysBIReportBase.getBIReportUIModel());
        }
        if (pSSysBIReportBase.isCodeNameDirty() && (bl || pSSysBIReportBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIReportBase.getCodeName());
        }
        if (pSSysBIReportBase.isCreateDateDirty() && (bl || pSSysBIReportBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIReportBase.getCreateDate());
        }
        if (pSSysBIReportBase.isCreateManDirty() && (bl || pSSysBIReportBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIReportBase.getCreateMan());
        }
        if (pSSysBIReportBase.isEnableCustomizedDirty() && (bl || pSSysBIReportBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSSysBIReportBase.getEnableCustomized());
        }
        if (pSSysBIReportBase.isMemoDirty() && (bl || pSSysBIReportBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIReportBase.getMemo());
        }
        if (pSSysBIReportBase.isPSSysBICubeIdDirty() && (bl || pSSysBIReportBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBIReportBase.getPSSysBICubeId());
        }
        if (pSSysBIReportBase.isPSSysBICubeNameDirty() && (bl || pSSysBIReportBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBIReportBase.getPSSysBICubeName());
        }
        if (pSSysBIReportBase.isPSSysBIReportIdDirty() && (bl || pSSysBIReportBase.getPSSysBIReportId() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTID, (Object)pSSysBIReportBase.getPSSysBIReportId());
        }
        if (pSSysBIReportBase.isPSSysBIReportNameDirty() && (bl || pSSysBIReportBase.getPSSysBIReportName() != null)) {
            iDataObject.set(FIELD_PSSYSBIREPORTNAME, (Object)pSSysBIReportBase.getPSSysBIReportName());
        }
        if (pSSysBIReportBase.isPSSysBISchemeIdDirty() && (bl || pSSysBIReportBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBIReportBase.getPSSysBISchemeId());
        }
        if (pSSysBIReportBase.isPSSysBISchemeNameDirty() && (bl || pSSysBIReportBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSSysBIReportBase.getPSSysBISchemeName());
        }
        if (pSSysBIReportBase.isPSSysPFPluginIdDirty() && (bl || pSSysBIReportBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSSysBIReportBase.getPSSysPFPluginId());
        }
        if (pSSysBIReportBase.isPSSysPFPluginNameDirty() && (bl || pSSysBIReportBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSSysBIReportBase.getPSSysPFPluginName());
        }
        if (pSSysBIReportBase.isPSSysResourceIdDirty() && (bl || pSSysBIReportBase.getPSSysResourceId() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCEID, (Object)pSSysBIReportBase.getPSSysResourceId());
        }
        if (pSSysBIReportBase.isPSSysResourceNameDirty() && (bl || pSSysBIReportBase.getPSSysResourceName() != null)) {
            iDataObject.set(FIELD_PSSYSRESOURCENAME, (Object)pSSysBIReportBase.getPSSysResourceName());
        }
        if (pSSysBIReportBase.isPSSysSFPluginIdDirty() && (bl || pSSysBIReportBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBIReportBase.getPSSysSFPluginId());
        }
        if (pSSysBIReportBase.isPSSysSFPluginNameDirty() && (bl || pSSysBIReportBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBIReportBase.getPSSysSFPluginName());
        }
        if (pSSysBIReportBase.isPSSysUniResIdDirty() && (bl || pSSysBIReportBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysBIReportBase.getPSSysUniResId());
        }
        if (pSSysBIReportBase.isPSSysUniResNameDirty() && (bl || pSSysBIReportBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysBIReportBase.getPSSysUniResName());
        }
        if (pSSysBIReportBase.isPSSysViewPanelIdDirty() && (bl || pSSysBIReportBase.getPSSysViewPanelId() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELID, (Object)pSSysBIReportBase.getPSSysViewPanelId());
        }
        if (pSSysBIReportBase.isPSSysViewPanelNameDirty() && (bl || pSSysBIReportBase.getPSSysViewPanelName() != null)) {
            iDataObject.set(FIELD_PSSYSVIEWPANELNAME, (Object)pSSysBIReportBase.getPSSysViewPanelName());
        }
        if (pSSysBIReportBase.isPSViewMsgGroupIdDirty() && (bl || pSSysBIReportBase.getPSViewMsgGroupId() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPID, (Object)pSSysBIReportBase.getPSViewMsgGroupId());
        }
        if (pSSysBIReportBase.isPSViewMsgGroupNameDirty() && (bl || pSSysBIReportBase.getPSViewMsgGroupName() != null)) {
            iDataObject.set(FIELD_PSVIEWMSGGROUPNAME, (Object)pSSysBIReportBase.getPSViewMsgGroupName());
        }
        if (pSSysBIReportBase.isUpdateDateDirty() && (bl || pSSysBIReportBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIReportBase.getUpdateDate());
        }
        if (pSSysBIReportBase.isUpdateManDirty() && (bl || pSSysBIReportBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIReportBase.getUpdateMan());
        }
        if (pSSysBIReportBase.isUserCatDirty() && (bl || pSSysBIReportBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIReportBase.getUserCat());
        }
        if (pSSysBIReportBase.isUserTagDirty() && (bl || pSSysBIReportBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIReportBase.getUserTag());
        }
        if (pSSysBIReportBase.isUserTag2Dirty() && (bl || pSSysBIReportBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIReportBase.getUserTag2());
        }
        if (pSSysBIReportBase.isUserTag3Dirty() && (bl || pSSysBIReportBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIReportBase.getUserTag3());
        }
        if (pSSysBIReportBase.isUserTag4Dirty() && (bl || pSSysBIReportBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIReportBase.getUserTag4());
        }
        if (pSSysBIReportBase.isValidFlagDirty() && (bl || pSSysBIReportBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIReportBase.getValidFlag());
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
        return PSSysBIReportBase.remove(this, n);
    }

    private static boolean remove(PSSysBIReportBase pSSysBIReportBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIReportBase.resetBIReportModel();
                return true;
            }
            case 1: {
                pSSysBIReportBase.resetBIReportParams();
                return true;
            }
            case 2: {
                pSSysBIReportBase.resetBIReportTag();
                return true;
            }
            case 3: {
                pSSysBIReportBase.resetBIReportTag2();
                return true;
            }
            case 4: {
                pSSysBIReportBase.resetBIReportUIModel();
                return true;
            }
            case 5: {
                pSSysBIReportBase.resetCodeName();
                return true;
            }
            case 6: {
                pSSysBIReportBase.resetCreateDate();
                return true;
            }
            case 7: {
                pSSysBIReportBase.resetCreateMan();
                return true;
            }
            case 8: {
                pSSysBIReportBase.resetEnableCustomized();
                return true;
            }
            case 9: {
                pSSysBIReportBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysBIReportBase.resetPSSysBICubeId();
                return true;
            }
            case 11: {
                pSSysBIReportBase.resetPSSysBICubeName();
                return true;
            }
            case 12: {
                pSSysBIReportBase.resetPSSysBIReportId();
                return true;
            }
            case 13: {
                pSSysBIReportBase.resetPSSysBIReportName();
                return true;
            }
            case 14: {
                pSSysBIReportBase.resetPSSysBISchemeId();
                return true;
            }
            case 15: {
                pSSysBIReportBase.resetPSSysBISchemeName();
                return true;
            }
            case 16: {
                pSSysBIReportBase.resetPSSysPFPluginId();
                return true;
            }
            case 17: {
                pSSysBIReportBase.resetPSSysPFPluginName();
                return true;
            }
            case 18: {
                pSSysBIReportBase.resetPSSysResourceId();
                return true;
            }
            case 19: {
                pSSysBIReportBase.resetPSSysResourceName();
                return true;
            }
            case 20: {
                pSSysBIReportBase.resetPSSysSFPluginId();
                return true;
            }
            case 21: {
                pSSysBIReportBase.resetPSSysSFPluginName();
                return true;
            }
            case 22: {
                pSSysBIReportBase.resetPSSysUniResId();
                return true;
            }
            case 23: {
                pSSysBIReportBase.resetPSSysUniResName();
                return true;
            }
            case 24: {
                pSSysBIReportBase.resetPSSysViewPanelId();
                return true;
            }
            case 25: {
                pSSysBIReportBase.resetPSSysViewPanelName();
                return true;
            }
            case 26: {
                pSSysBIReportBase.resetPSViewMsgGroupId();
                return true;
            }
            case 27: {
                pSSysBIReportBase.resetPSViewMsgGroupName();
                return true;
            }
            case 28: {
                pSSysBIReportBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSSysBIReportBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSSysBIReportBase.resetUserCat();
                return true;
            }
            case 31: {
                pSSysBIReportBase.resetUserTag();
                return true;
            }
            case 32: {
                pSSysBIReportBase.resetUserTag2();
                return true;
            }
            case 33: {
                pSSysBIReportBase.resetUserTag3();
                return true;
            }
            case 34: {
                pSSysBIReportBase.resetUserTag4();
                return true;
            }
            case 35: {
                pSSysBIReportBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBICube getPSSysBICube() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICube();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBICubeLock;
        synchronized (n) {
            if (this.pssysbicube != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBICubeId(), (Object)this.pssysbicube.getPSSysBICubeId()) != 0L) {
                this.pssysbicube = null;
            }
            if (this.pssysbicube == null) {
                PSSysBICube pSSysBICube = new PSSysBICube();
                pSSysBICube.setPSSysBICubeId(this.getPSSysBICubeId());
                PSSysBICubeService pSSysBICubeService = (PSSysBICubeService)ServiceGlobal.getService(PSSysBICubeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBICubeService.autoGet((IEntity)pSSysBICube);
                this.pssysbicube = pSSysBICube;
            }
            return this.pssysbicube;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysBIScheme getPSSysBIScheme() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIScheme();
        }
        if (this.getPSSysBISchemeId() == null) {
            return null;
        }
        Integer n = this.objPSSysBISchemeLock;
        synchronized (n) {
            if (this.pssysbischeme != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysBISchemeId(), (Object)this.pssysbischeme.getPSSysBISchemeId()) != 0L) {
                this.pssysbischeme = null;
            }
            if (this.pssysbischeme == null) {
                PSSysBIScheme pSSysBIScheme = new PSSysBIScheme();
                pSSysBIScheme.setPSSysBISchemeId(this.getPSSysBISchemeId());
                PSSysBISchemeService pSSysBISchemeService = (PSSysBISchemeService)ServiceGlobal.getService(PSSysBISchemeService.class, (SessionFactory)this.getSessionFactory());
                pSSysBISchemeService.autoGet((IEntity)pSSysBIScheme);
                this.pssysbischeme = pSSysBIScheme;
            }
            return this.pssysbischeme;
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
    public PSSysSFPlugin getPSSysSFPlugin() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPlugin();
        }
        if (this.getPSSysSFPluginId() == null) {
            return null;
        }
        Integer n = this.objPSSysSFPluginLock;
        synchronized (n) {
            if (this.pssyssfplugin != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysSFPluginId(), (Object)this.pssyssfplugin.getPSSysSFPluginId()) != 0L) {
                this.pssyssfplugin = null;
            }
            if (this.pssyssfplugin == null) {
                PSSysSFPlugin pSSysSFPlugin = new PSSysSFPlugin();
                pSSysSFPlugin.setPSSysSFPluginId(this.getPSSysSFPluginId());
                PSSysSFPluginService pSSysSFPluginService = (PSSysSFPluginService)ServiceGlobal.getService(PSSysSFPluginService.class, (SessionFactory)this.getSessionFactory());
                pSSysSFPluginService.autoGet((IEntity)pSSysSFPlugin);
                this.pssyssfplugin = pSSysSFPlugin;
            }
            return this.pssyssfplugin;
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
                pSSysViewPanelService.autoGet((IEntity)pSSysViewPanel);
                this.pssysviewpanel = pSSysViewPanel;
            }
            return this.pssysviewpanel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewMsgGroup getPSViewMsgGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewMsgGroup();
        }
        if (this.getPSViewMsgGroupId() == null) {
            return null;
        }
        Integer n = this.objPSViewMsgGroupLock;
        synchronized (n) {
            if (this.psviewmsggroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewMsgGroupId(), (Object)this.psviewmsggroup.getPSViewMsgGroupId()) != 0L) {
                this.psviewmsggroup = null;
            }
            if (this.psviewmsggroup == null) {
                PSViewMsgGroup pSViewMsgGroup = new PSViewMsgGroup();
                pSViewMsgGroup.setPSViewMsgGroupId(this.getPSViewMsgGroupId());
                PSViewMsgGroupService pSViewMsgGroupService = (PSViewMsgGroupService)ServiceGlobal.getService(PSViewMsgGroupService.class, (SessionFactory)this.getSessionFactory());
                pSViewMsgGroupService.autoGet((IEntity)pSViewMsgGroup);
                this.psviewmsggroup = pSViewMsgGroup;
            }
            return this.psviewmsggroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBIReportItem> getPSSysBIReportItems() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIReportItems();
        }
        if (this.getPSSysBIReportId() == null) {
            return null;
        }
        PSSysBIReportService pSSysBIReportService = (PSSysBIReportService)ServiceGlobal.getService(PSSysBIReportService.class, (SessionFactory)this.getSessionFactory());
        PSSysBIReportItemService pSSysBIReportItemService = (PSSysBIReportItemService)ServiceGlobal.getService(PSSysBIReportItemService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBIReportItemsLock;
        synchronized (n) {
            if (this.pssysbireportitems == null) {
                this.pssysbireportitems = pSSysBIReportService.isTempData((IEntity)this) ? pSSysBIReportItemService.selectTempByPSSysBIReport(this) : pSSysBIReportItemService.selectByPSSysBIReport(this);
            }
            return this.pssysbireportitems;
        }
    }

    private PSSysBIReportBase getProxyEntity() {
        return this.proxyPSSysBIReportBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIReportBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIReportBase) {
            this.proxyPSSysBIReportBase = (PSSysBIReportBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIReportService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BIREPORTMODEL, 0);
        fieldIndexMap.put(FIELD_BIREPORTPARAMS, 1);
        fieldIndexMap.put(FIELD_BIREPORTTAG, 2);
        fieldIndexMap.put(FIELD_BIREPORTTAG2, 3);
        fieldIndexMap.put(FIELD_BIREPORTUIMODEL, 4);
        fieldIndexMap.put(FIELD_CODENAME, 5);
        fieldIndexMap.put(FIELD_CREATEDATE, 6);
        fieldIndexMap.put(FIELD_CREATEMAN, 7);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 10);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTID, 12);
        fieldIndexMap.put(FIELD_PSSYSBIREPORTNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 14);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 15);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 16);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 17);
        fieldIndexMap.put(FIELD_PSSYSRESOURCEID, 18);
        fieldIndexMap.put(FIELD_PSSYSRESOURCENAME, 19);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 20);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 21);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 22);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELID, 24);
        fieldIndexMap.put(FIELD_PSSYSVIEWPANELNAME, 25);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPID, 26);
        fieldIndexMap.put(FIELD_PSVIEWMSGGROUPNAME, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERCAT, 30);
        fieldIndexMap.put(FIELD_USERTAG, 31);
        fieldIndexMap.put(FIELD_USERTAG2, 32);
        fieldIndexMap.put(FIELD_USERTAG3, 33);
        fieldIndexMap.put(FIELD_USERTAG4, 34);
        fieldIndexMap.put(FIELD_VALIDFLAG, 35);
    }
}

