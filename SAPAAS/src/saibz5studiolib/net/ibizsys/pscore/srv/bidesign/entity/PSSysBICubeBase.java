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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeDimension;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBICubeMeasure;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeDimensionService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeMeasureService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEUAGroup;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEUAGroupService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUniRes;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUniResService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBICubeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBICubeBase.class);
    public static final String FIELD_BICUBEOPTION = "BICUBEOPTION";
    public static final String FIELD_BICUBEPARAMS = "BICUBEPARAMS";
    public static final String FIELD_BICUBETAG = "BICUBETAG";
    public static final String FIELD_BICUBETAG2 = "BICUBETAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DRILLDETAILPSDEVIEWID = "DRILLDETAILPSDEVIEWID";
    public static final String FIELD_DRILLDETAILPSDEVIEWNAME = "DRILLDETAILPSDEVIEWNAME";
    public static final String FIELD_DRILLDOWNPSDEVIEWID = "DRILLDOWNPSDEVIEWID";
    public static final String FIELD_DRILLDOWNPSDEVIEWNAME = "DRILLDOWNPSDEVIEWNAME";
    public static final String FIELD_ENABLECUSTOMIZED = "ENABLECUSTOMIZED";
    public static final String FIELD_KEYPSDEFID = "KEYPSDEFID";
    public static final String FIELD_KEYPSDEFNAME = "KEYPSDEFNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PORTLETPSDEUAGROUPID = "PORTLETPSDEUAGROUPID";
    public static final String FIELD_PORTLETPSDEUAGROUPNAME = "PORTLETPSDEUAGROUPNAME";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSBICUBEID = "PSSYSBICUBEID";
    public static final String FIELD_PSSYSBICUBENAME = "PSSYSBICUBENAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSUNIRESID = "PSSYSUNIRESID";
    public static final String FIELD_PSSYSUNIRESNAME = "PSSYSUNIRESNAME";
    public static final String FIELD_TYPEPSDEFID = "TYPEPSDEFID";
    public static final String FIELD_TYPEPSDEFNAME = "TYPEPSDEFNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BICUBEOPTION = 0;
    private static final int INDEX_BICUBEPARAMS = 1;
    private static final int INDEX_BICUBETAG = 2;
    private static final int INDEX_BICUBETAG2 = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_DRILLDETAILPSDEVIEWID = 7;
    private static final int INDEX_DRILLDETAILPSDEVIEWNAME = 8;
    private static final int INDEX_DRILLDOWNPSDEVIEWID = 9;
    private static final int INDEX_DRILLDOWNPSDEVIEWNAME = 10;
    private static final int INDEX_ENABLECUSTOMIZED = 11;
    private static final int INDEX_KEYPSDEFID = 12;
    private static final int INDEX_KEYPSDEFNAME = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_PORTLETPSDEUAGROUPID = 15;
    private static final int INDEX_PORTLETPSDEUAGROUPNAME = 16;
    private static final int INDEX_PSDEDATASETID = 17;
    private static final int INDEX_PSDEDATASETNAME = 18;
    private static final int INDEX_PSDEID = 19;
    private static final int INDEX_PSDENAME = 20;
    private static final int INDEX_PSSYSBICUBEID = 21;
    private static final int INDEX_PSSYSBICUBENAME = 22;
    private static final int INDEX_PSSYSBISCHEMEID = 23;
    private static final int INDEX_PSSYSBISCHEMENAME = 24;
    private static final int INDEX_PSSYSDYNAMODELID = 25;
    private static final int INDEX_PSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSSYSSFPLUGINID = 27;
    private static final int INDEX_PSSYSSFPLUGINNAME = 28;
    private static final int INDEX_PSSYSUNIRESID = 29;
    private static final int INDEX_PSSYSUNIRESNAME = 30;
    private static final int INDEX_TYPEPSDEFID = 31;
    private static final int INDEX_TYPEPSDEFNAME = 32;
    private static final int INDEX_UPDATEDATE = 33;
    private static final int INDEX_UPDATEMAN = 34;
    private static final int INDEX_USERCAT = 35;
    private static final int INDEX_USERTAG = 36;
    private static final int INDEX_USERTAG2 = 37;
    private static final int INDEX_USERTAG3 = 38;
    private static final int INDEX_USERTAG4 = 39;
    private static final int INDEX_VALIDFLAG = 40;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBICubeBase proxyPSSysBICubeBase = null;
    private boolean bicubeoptionDirtyFlag = false;
    private boolean bicubeparamsDirtyFlag = false;
    private boolean bicubetagDirtyFlag = false;
    private boolean bicubetag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean drilldetailpsdeviewidDirtyFlag = false;
    private boolean drilldetailpsdeviewnameDirtyFlag = false;
    private boolean drilldownpsdeviewidDirtyFlag = false;
    private boolean drilldownpsdeviewnameDirtyFlag = false;
    private boolean enablecustomizedDirtyFlag = false;
    private boolean keypsdefidDirtyFlag = false;
    private boolean keypsdefnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean portletpsdeuagroupidDirtyFlag = false;
    private boolean portletpsdeuagroupnameDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysbicubeidDirtyFlag = false;
    private boolean pssysbicubenameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssysuniresidDirtyFlag = false;
    private boolean pssysuniresnameDirtyFlag = false;
    private boolean typepsdefidDirtyFlag = false;
    private boolean typepsdefnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bicubeoption")
    private Integer bicubeoption;
    @Column(name="bicubeparams")
    private String bicubeparams;
    @Column(name="bicubetag")
    private String bicubetag;
    @Column(name="bicubetag2")
    private String bicubetag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="drilldetailpsdeviewid")
    private String drilldetailpsdeviewid;
    @Column(name="drilldetailpsdeviewname")
    private String drilldetailpsdeviewname;
    @Column(name="drilldownpsdeviewid")
    private String drilldownpsdeviewid;
    @Column(name="drilldownpsdeviewname")
    private String drilldownpsdeviewname;
    @Column(name="enablecustomized")
    private Integer enablecustomized;
    @Column(name="keypsdefid")
    private String keypsdefid;
    @Column(name="keypsdefname")
    private String keypsdefname;
    @Column(name="memo")
    private String memo;
    @Column(name="portletpsdeuagroupid")
    private String portletpsdeuagroupid;
    @Column(name="portletpsdeuagroupname")
    private String portletpsdeuagroupname;
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysbicubeid")
    private String pssysbicubeid;
    @Column(name="pssysbicubename")
    private String pssysbicubename;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssysuniresid")
    private String pssysuniresid;
    @Column(name="pssysuniresname")
    private String pssysuniresname;
    @Column(name="typepsdefid")
    private String typepsdefid;
    @Column(name="typepsdefname")
    private String typepsdefname;
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
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
    private Integer objKeyPSDEFLock = new Integer(1);
    private PSDEField keypsdef = null;
    private Integer objTypePSDEFLock = new Integer(1);
    private PSDEField typepsdef = null;
    private Integer objPortletPSDEUAGroupLock = new Integer(1);
    private PSDEUAGroup portletpsdeuagroup = null;
    private Integer objDrillDetailPSDEViewLock = new Integer(1);
    private PSDEViewBase drilldetailpsdeview = null;
    private Integer objDrillDownPSDEViewLock = new Integer(1);
    private PSDEViewBase drilldownpsdeview = null;
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysUniResLock = new Integer(1);
    private PSSysUniRes pssysunires = null;
    private Integer objPSSysBICubeDimensionsLock = new Integer(1);
    private ArrayList<PSSysBICubeDimension> pssysbicubedimensions = null;
    private Integer objPSSysBICubeMeasuresLock = new Integer(1);
    private ArrayList<PSSysBICubeMeasure> pssysbicubemeasures = null;

    public void setBICubeOption(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeOption(n);
            return;
        }
        this.bicubeoption = n;
        this.bicubeoptionDirtyFlag = true;
    }

    public Integer getBICubeOption() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeOption();
        }
        return this.bicubeoption;
    }

    public boolean isBICubeOptionDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeOptionDirty();
        }
        return this.bicubeoptionDirtyFlag;
    }

    public void resetBICubeOption() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeOption();
            return;
        }
        this.bicubeoptionDirtyFlag = false;
        this.bicubeoption = null;
    }

    public void setBICubeParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubeparams = string;
        this.bicubeparamsDirtyFlag = true;
    }

    public String getBICubeParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeParams();
        }
        return this.bicubeparams;
    }

    public boolean isBICubeParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeParamsDirty();
        }
        return this.bicubeparamsDirtyFlag;
    }

    public void resetBICubeParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeParams();
            return;
        }
        this.bicubeparamsDirtyFlag = false;
        this.bicubeparams = null;
    }

    public void setBICubeTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubetag = string;
        this.bicubetagDirtyFlag = true;
    }

    public String getBICubeTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeTag();
        }
        return this.bicubetag;
    }

    public boolean isBICubeTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeTagDirty();
        }
        return this.bicubetagDirtyFlag;
    }

    public void resetBICubeTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeTag();
            return;
        }
        this.bicubetagDirtyFlag = false;
        this.bicubetag = null;
    }

    public void setBICubeTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBICubeTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bicubetag2 = string;
        this.bicubetag2DirtyFlag = true;
    }

    public String getBICubeTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBICubeTag2();
        }
        return this.bicubetag2;
    }

    public boolean isBICubeTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBICubeTag2Dirty();
        }
        return this.bicubetag2DirtyFlag;
    }

    public void resetBICubeTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBICubeTag2();
            return;
        }
        this.bicubetag2DirtyFlag = false;
        this.bicubetag2 = null;
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

    public void setDrillDetailPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailpsdeviewid = string;
        this.drilldetailpsdeviewidDirtyFlag = true;
    }

    public String getDrillDetailPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEViewId();
        }
        return this.drilldetailpsdeviewid;
    }

    public boolean isDrillDetailPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailPSDEViewIdDirty();
        }
        return this.drilldetailpsdeviewidDirtyFlag;
    }

    public void resetDrillDetailPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailPSDEViewId();
            return;
        }
        this.drilldetailpsdeviewidDirtyFlag = false;
        this.drilldetailpsdeviewid = null;
    }

    public void setDrillDetailPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDetailPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldetailpsdeviewname = string;
        this.drilldetailpsdeviewnameDirtyFlag = true;
    }

    public String getDrillDetailPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEViewName();
        }
        return this.drilldetailpsdeviewname;
    }

    public boolean isDrillDetailPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDetailPSDEViewNameDirty();
        }
        return this.drilldetailpsdeviewnameDirtyFlag;
    }

    public void resetDrillDetailPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDetailPSDEViewName();
            return;
        }
        this.drilldetailpsdeviewnameDirtyFlag = false;
        this.drilldetailpsdeviewname = null;
    }

    public void setDrillDownPSDEViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownPSDEViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldownpsdeviewid = string;
        this.drilldownpsdeviewidDirtyFlag = true;
    }

    public String getDrillDownPSDEViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEViewId();
        }
        return this.drilldownpsdeviewid;
    }

    public boolean isDrillDownPSDEViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownPSDEViewIdDirty();
        }
        return this.drilldownpsdeviewidDirtyFlag;
    }

    public void resetDrillDownPSDEViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownPSDEViewId();
            return;
        }
        this.drilldownpsdeviewidDirtyFlag = false;
        this.drilldownpsdeviewid = null;
    }

    public void setDrillDownPSDEViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDrillDownPSDEViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.drilldownpsdeviewname = string;
        this.drilldownpsdeviewnameDirtyFlag = true;
    }

    public String getDrillDownPSDEViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEViewName();
        }
        return this.drilldownpsdeviewname;
    }

    public boolean isDrillDownPSDEViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDrillDownPSDEViewNameDirty();
        }
        return this.drilldownpsdeviewnameDirtyFlag;
    }

    public void resetDrillDownPSDEViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDrillDownPSDEViewName();
            return;
        }
        this.drilldownpsdeviewnameDirtyFlag = false;
        this.drilldownpsdeviewname = null;
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

    public void setKeyPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefid = string;
        this.keypsdefidDirtyFlag = true;
    }

    public String getKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFId();
        }
        return this.keypsdefid;
    }

    public boolean isKeyPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFIdDirty();
        }
        return this.keypsdefidDirtyFlag;
    }

    public void resetKeyPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFId();
            return;
        }
        this.keypsdefidDirtyFlag = false;
        this.keypsdefid = null;
    }

    public void setKeyPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setKeyPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.keypsdefname = string;
        this.keypsdefnameDirtyFlag = true;
    }

    public String getKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEFName();
        }
        return this.keypsdefname;
    }

    public boolean isKeyPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isKeyPSDEFNameDirty();
        }
        return this.keypsdefnameDirtyFlag;
    }

    public void resetKeyPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetKeyPSDEFName();
            return;
        }
        this.keypsdefnameDirtyFlag = false;
        this.keypsdefname = null;
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

    public void setPortletPSDEUAGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletPSDEUAGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portletpsdeuagroupid = string;
        this.portletpsdeuagroupidDirtyFlag = true;
    }

    public String getPortletPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletPSDEUAGroupId();
        }
        return this.portletpsdeuagroupid;
    }

    public boolean isPortletPSDEUAGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletPSDEUAGroupIdDirty();
        }
        return this.portletpsdeuagroupidDirtyFlag;
    }

    public void resetPortletPSDEUAGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletPSDEUAGroupId();
            return;
        }
        this.portletpsdeuagroupidDirtyFlag = false;
        this.portletpsdeuagroupid = null;
    }

    public void setPortletPSDEUAGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPortletPSDEUAGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.portletpsdeuagroupname = string;
        this.portletpsdeuagroupnameDirtyFlag = true;
    }

    public String getPortletPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletPSDEUAGroupName();
        }
        return this.portletpsdeuagroupname;
    }

    public boolean isPortletPSDEUAGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPortletPSDEUAGroupNameDirty();
        }
        return this.portletpsdeuagroupnameDirtyFlag;
    }

    public void resetPortletPSDEUAGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPortletPSDEUAGroupName();
            return;
        }
        this.portletpsdeuagroupnameDirtyFlag = false;
        this.portletpsdeuagroupname = null;
    }

    public void setPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetid = string;
        this.psdedatasetidDirtyFlag = true;
    }

    public String getPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetId();
        }
        return this.psdedatasetid;
    }

    public boolean isPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetIdDirty();
        }
        return this.psdedatasetidDirtyFlag;
    }

    public void resetPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetId();
            return;
        }
        this.psdedatasetidDirtyFlag = false;
        this.psdedatasetid = null;
    }

    public void setPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedatasetname = string;
        this.psdedatasetnameDirtyFlag = true;
    }

    public String getPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSetName();
        }
        return this.psdedatasetname;
    }

    public boolean isPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataSetNameDirty();
        }
        return this.psdedatasetnameDirtyFlag;
    }

    public void resetPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataSetName();
            return;
        }
        this.psdedatasetnameDirtyFlag = false;
        this.psdedatasetname = null;
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

    public void setPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdename = string;
        this.psdenameDirtyFlag = true;
    }

    public String getPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEName();
        }
        return this.psdename;
    }

    public boolean isPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDENameDirty();
        }
        return this.psdenameDirtyFlag;
    }

    public void resetPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEName();
            return;
        }
        this.psdenameDirtyFlag = false;
        this.psdename = null;
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

    public void setTypePSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefid = string;
        this.typepsdefidDirtyFlag = true;
    }

    public String getTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFId();
        }
        return this.typepsdefid;
    }

    public boolean isTypePSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFIdDirty();
        }
        return this.typepsdefidDirtyFlag;
    }

    public void resetTypePSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFId();
            return;
        }
        this.typepsdefidDirtyFlag = false;
        this.typepsdefid = null;
    }

    public void setTypePSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypePSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typepsdefname = string;
        this.typepsdefnameDirtyFlag = true;
    }

    public String getTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEFName();
        }
        return this.typepsdefname;
    }

    public boolean isTypePSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypePSDEFNameDirty();
        }
        return this.typepsdefnameDirtyFlag;
    }

    public void resetTypePSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypePSDEFName();
            return;
        }
        this.typepsdefnameDirtyFlag = false;
        this.typepsdefname = null;
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
        PSSysBICubeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBICubeBase pSSysBICubeBase) {
        pSSysBICubeBase.resetBICubeOption();
        pSSysBICubeBase.resetBICubeParams();
        pSSysBICubeBase.resetBICubeTag();
        pSSysBICubeBase.resetBICubeTag2();
        pSSysBICubeBase.resetCodeName();
        pSSysBICubeBase.resetCreateDate();
        pSSysBICubeBase.resetCreateMan();
        pSSysBICubeBase.resetDrillDetailPSDEViewId();
        pSSysBICubeBase.resetDrillDetailPSDEViewName();
        pSSysBICubeBase.resetDrillDownPSDEViewId();
        pSSysBICubeBase.resetDrillDownPSDEViewName();
        pSSysBICubeBase.resetEnableCustomized();
        pSSysBICubeBase.resetKeyPSDEFId();
        pSSysBICubeBase.resetKeyPSDEFName();
        pSSysBICubeBase.resetMemo();
        pSSysBICubeBase.resetPortletPSDEUAGroupId();
        pSSysBICubeBase.resetPortletPSDEUAGroupName();
        pSSysBICubeBase.resetPSDEDataSetId();
        pSSysBICubeBase.resetPSDEDataSetName();
        pSSysBICubeBase.resetPSDEId();
        pSSysBICubeBase.resetPSDEName();
        pSSysBICubeBase.resetPSSysBICubeId();
        pSSysBICubeBase.resetPSSysBICubeName();
        pSSysBICubeBase.resetPSSysBISchemeId();
        pSSysBICubeBase.resetPSSysBISchemeName();
        pSSysBICubeBase.resetPSSysDynaModelId();
        pSSysBICubeBase.resetPSSysDynaModelName();
        pSSysBICubeBase.resetPSSysSFPluginId();
        pSSysBICubeBase.resetPSSysSFPluginName();
        pSSysBICubeBase.resetPSSysUniResId();
        pSSysBICubeBase.resetPSSysUniResName();
        pSSysBICubeBase.resetTypePSDEFId();
        pSSysBICubeBase.resetTypePSDEFName();
        pSSysBICubeBase.resetUpdateDate();
        pSSysBICubeBase.resetUpdateMan();
        pSSysBICubeBase.resetUserCat();
        pSSysBICubeBase.resetUserTag();
        pSSysBICubeBase.resetUserTag2();
        pSSysBICubeBase.resetUserTag3();
        pSSysBICubeBase.resetUserTag4();
        pSSysBICubeBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBICubeOptionDirty()) {
            hashMap.put(FIELD_BICUBEOPTION, this.getBICubeOption());
        }
        if (!bl || this.isBICubeParamsDirty()) {
            hashMap.put(FIELD_BICUBEPARAMS, this.getBICubeParams());
        }
        if (!bl || this.isBICubeTagDirty()) {
            hashMap.put(FIELD_BICUBETAG, this.getBICubeTag());
        }
        if (!bl || this.isBICubeTag2Dirty()) {
            hashMap.put(FIELD_BICUBETAG2, this.getBICubeTag2());
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
        if (!bl || this.isDrillDetailPSDEViewIdDirty()) {
            hashMap.put(FIELD_DRILLDETAILPSDEVIEWID, this.getDrillDetailPSDEViewId());
        }
        if (!bl || this.isDrillDetailPSDEViewNameDirty()) {
            hashMap.put(FIELD_DRILLDETAILPSDEVIEWNAME, this.getDrillDetailPSDEViewName());
        }
        if (!bl || this.isDrillDownPSDEViewIdDirty()) {
            hashMap.put(FIELD_DRILLDOWNPSDEVIEWID, this.getDrillDownPSDEViewId());
        }
        if (!bl || this.isDrillDownPSDEViewNameDirty()) {
            hashMap.put(FIELD_DRILLDOWNPSDEVIEWNAME, this.getDrillDownPSDEViewName());
        }
        if (!bl || this.isEnableCustomizedDirty()) {
            hashMap.put(FIELD_ENABLECUSTOMIZED, this.getEnableCustomized());
        }
        if (!bl || this.isKeyPSDEFIdDirty()) {
            hashMap.put(FIELD_KEYPSDEFID, this.getKeyPSDEFId());
        }
        if (!bl || this.isKeyPSDEFNameDirty()) {
            hashMap.put(FIELD_KEYPSDEFNAME, this.getKeyPSDEFName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPortletPSDEUAGroupIdDirty()) {
            hashMap.put(FIELD_PORTLETPSDEUAGROUPID, this.getPortletPSDEUAGroupId());
        }
        if (!bl || this.isPortletPSDEUAGroupNameDirty()) {
            hashMap.put(FIELD_PORTLETPSDEUAGROUPNAME, this.getPortletPSDEUAGroupName());
        }
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysBICubeIdDirty()) {
            hashMap.put(FIELD_PSSYSBICUBEID, this.getPSSysBICubeId());
        }
        if (!bl || this.isPSSysBICubeNameDirty()) {
            hashMap.put(FIELD_PSSYSBICUBENAME, this.getPSSysBICubeName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
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
        if (!bl || this.isTypePSDEFIdDirty()) {
            hashMap.put(FIELD_TYPEPSDEFID, this.getTypePSDEFId());
        }
        if (!bl || this.isTypePSDEFNameDirty()) {
            hashMap.put(FIELD_TYPEPSDEFNAME, this.getTypePSDEFName());
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
        return PSSysBICubeBase.get(this, n);
    }

    private static Object get(PSSysBICubeBase pSSysBICubeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeBase.getBICubeOption();
            }
            case 1: {
                return pSSysBICubeBase.getBICubeParams();
            }
            case 2: {
                return pSSysBICubeBase.getBICubeTag();
            }
            case 3: {
                return pSSysBICubeBase.getBICubeTag2();
            }
            case 4: {
                return pSSysBICubeBase.getCodeName();
            }
            case 5: {
                return pSSysBICubeBase.getCreateDate();
            }
            case 6: {
                return pSSysBICubeBase.getCreateMan();
            }
            case 7: {
                return pSSysBICubeBase.getDrillDetailPSDEViewId();
            }
            case 8: {
                return pSSysBICubeBase.getDrillDetailPSDEViewName();
            }
            case 9: {
                return pSSysBICubeBase.getDrillDownPSDEViewId();
            }
            case 10: {
                return pSSysBICubeBase.getDrillDownPSDEViewName();
            }
            case 11: {
                return pSSysBICubeBase.getEnableCustomized();
            }
            case 12: {
                return pSSysBICubeBase.getKeyPSDEFId();
            }
            case 13: {
                return pSSysBICubeBase.getKeyPSDEFName();
            }
            case 14: {
                return pSSysBICubeBase.getMemo();
            }
            case 15: {
                return pSSysBICubeBase.getPortletPSDEUAGroupId();
            }
            case 16: {
                return pSSysBICubeBase.getPortletPSDEUAGroupName();
            }
            case 17: {
                return pSSysBICubeBase.getPSDEDataSetId();
            }
            case 18: {
                return pSSysBICubeBase.getPSDEDataSetName();
            }
            case 19: {
                return pSSysBICubeBase.getPSDEId();
            }
            case 20: {
                return pSSysBICubeBase.getPSDEName();
            }
            case 21: {
                return pSSysBICubeBase.getPSSysBICubeId();
            }
            case 22: {
                return pSSysBICubeBase.getPSSysBICubeName();
            }
            case 23: {
                return pSSysBICubeBase.getPSSysBISchemeId();
            }
            case 24: {
                return pSSysBICubeBase.getPSSysBISchemeName();
            }
            case 25: {
                return pSSysBICubeBase.getPSSysDynaModelId();
            }
            case 26: {
                return pSSysBICubeBase.getPSSysDynaModelName();
            }
            case 27: {
                return pSSysBICubeBase.getPSSysSFPluginId();
            }
            case 28: {
                return pSSysBICubeBase.getPSSysSFPluginName();
            }
            case 29: {
                return pSSysBICubeBase.getPSSysUniResId();
            }
            case 30: {
                return pSSysBICubeBase.getPSSysUniResName();
            }
            case 31: {
                return pSSysBICubeBase.getTypePSDEFId();
            }
            case 32: {
                return pSSysBICubeBase.getTypePSDEFName();
            }
            case 33: {
                return pSSysBICubeBase.getUpdateDate();
            }
            case 34: {
                return pSSysBICubeBase.getUpdateMan();
            }
            case 35: {
                return pSSysBICubeBase.getUserCat();
            }
            case 36: {
                return pSSysBICubeBase.getUserTag();
            }
            case 37: {
                return pSSysBICubeBase.getUserTag2();
            }
            case 38: {
                return pSSysBICubeBase.getUserTag3();
            }
            case 39: {
                return pSSysBICubeBase.getUserTag4();
            }
            case 40: {
                return pSSysBICubeBase.getValidFlag();
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
        PSSysBICubeBase.set(this, n, object);
    }

    private static void set(PSSysBICubeBase pSSysBICubeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeBase.setBICubeOption(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSSysBICubeBase.setBICubeParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBICubeBase.setBICubeTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBICubeBase.setBICubeTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysBICubeBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBICubeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSSysBICubeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBICubeBase.setDrillDetailPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBICubeBase.setDrillDetailPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBICubeBase.setDrillDownPSDEViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBICubeBase.setDrillDownPSDEViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBICubeBase.setEnableCustomized(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSSysBICubeBase.setKeyPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysBICubeBase.setKeyPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBICubeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBICubeBase.setPortletPSDEUAGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBICubeBase.setPortletPSDEUAGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBICubeBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBICubeBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBICubeBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysBICubeBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysBICubeBase.setPSSysBICubeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysBICubeBase.setPSSysBICubeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSSysBICubeBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSSysBICubeBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSSysBICubeBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSSysBICubeBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSSysBICubeBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSSysBICubeBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSSysBICubeBase.setPSSysUniResId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSSysBICubeBase.setPSSysUniResName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSSysBICubeBase.setTypePSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSSysBICubeBase.setTypePSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSSysBICubeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 34: {
                pSSysBICubeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSSysBICubeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSSysBICubeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 37: {
                pSSysBICubeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSSysBICubeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSSysBICubeBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSSysBICubeBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBICubeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBICubeBase pSSysBICubeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeBase.getBICubeOption() == null;
            }
            case 1: {
                return pSSysBICubeBase.getBICubeParams() == null;
            }
            case 2: {
                return pSSysBICubeBase.getBICubeTag() == null;
            }
            case 3: {
                return pSSysBICubeBase.getBICubeTag2() == null;
            }
            case 4: {
                return pSSysBICubeBase.getCodeName() == null;
            }
            case 5: {
                return pSSysBICubeBase.getCreateDate() == null;
            }
            case 6: {
                return pSSysBICubeBase.getCreateMan() == null;
            }
            case 7: {
                return pSSysBICubeBase.getDrillDetailPSDEViewId() == null;
            }
            case 8: {
                return pSSysBICubeBase.getDrillDetailPSDEViewName() == null;
            }
            case 9: {
                return pSSysBICubeBase.getDrillDownPSDEViewId() == null;
            }
            case 10: {
                return pSSysBICubeBase.getDrillDownPSDEViewName() == null;
            }
            case 11: {
                return pSSysBICubeBase.getEnableCustomized() == null;
            }
            case 12: {
                return pSSysBICubeBase.getKeyPSDEFId() == null;
            }
            case 13: {
                return pSSysBICubeBase.getKeyPSDEFName() == null;
            }
            case 14: {
                return pSSysBICubeBase.getMemo() == null;
            }
            case 15: {
                return pSSysBICubeBase.getPortletPSDEUAGroupId() == null;
            }
            case 16: {
                return pSSysBICubeBase.getPortletPSDEUAGroupName() == null;
            }
            case 17: {
                return pSSysBICubeBase.getPSDEDataSetId() == null;
            }
            case 18: {
                return pSSysBICubeBase.getPSDEDataSetName() == null;
            }
            case 19: {
                return pSSysBICubeBase.getPSDEId() == null;
            }
            case 20: {
                return pSSysBICubeBase.getPSDEName() == null;
            }
            case 21: {
                return pSSysBICubeBase.getPSSysBICubeId() == null;
            }
            case 22: {
                return pSSysBICubeBase.getPSSysBICubeName() == null;
            }
            case 23: {
                return pSSysBICubeBase.getPSSysBISchemeId() == null;
            }
            case 24: {
                return pSSysBICubeBase.getPSSysBISchemeName() == null;
            }
            case 25: {
                return pSSysBICubeBase.getPSSysDynaModelId() == null;
            }
            case 26: {
                return pSSysBICubeBase.getPSSysDynaModelName() == null;
            }
            case 27: {
                return pSSysBICubeBase.getPSSysSFPluginId() == null;
            }
            case 28: {
                return pSSysBICubeBase.getPSSysSFPluginName() == null;
            }
            case 29: {
                return pSSysBICubeBase.getPSSysUniResId() == null;
            }
            case 30: {
                return pSSysBICubeBase.getPSSysUniResName() == null;
            }
            case 31: {
                return pSSysBICubeBase.getTypePSDEFId() == null;
            }
            case 32: {
                return pSSysBICubeBase.getTypePSDEFName() == null;
            }
            case 33: {
                return pSSysBICubeBase.getUpdateDate() == null;
            }
            case 34: {
                return pSSysBICubeBase.getUpdateMan() == null;
            }
            case 35: {
                return pSSysBICubeBase.getUserCat() == null;
            }
            case 36: {
                return pSSysBICubeBase.getUserTag() == null;
            }
            case 37: {
                return pSSysBICubeBase.getUserTag2() == null;
            }
            case 38: {
                return pSSysBICubeBase.getUserTag3() == null;
            }
            case 39: {
                return pSSysBICubeBase.getUserTag4() == null;
            }
            case 40: {
                return pSSysBICubeBase.getValidFlag() == null;
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
        return PSSysBICubeBase.contains(this, n);
    }

    private static boolean contains(PSSysBICubeBase pSSysBICubeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBICubeBase.isBICubeOptionDirty();
            }
            case 1: {
                return pSSysBICubeBase.isBICubeParamsDirty();
            }
            case 2: {
                return pSSysBICubeBase.isBICubeTagDirty();
            }
            case 3: {
                return pSSysBICubeBase.isBICubeTag2Dirty();
            }
            case 4: {
                return pSSysBICubeBase.isCodeNameDirty();
            }
            case 5: {
                return pSSysBICubeBase.isCreateDateDirty();
            }
            case 6: {
                return pSSysBICubeBase.isCreateManDirty();
            }
            case 7: {
                return pSSysBICubeBase.isDrillDetailPSDEViewIdDirty();
            }
            case 8: {
                return pSSysBICubeBase.isDrillDetailPSDEViewNameDirty();
            }
            case 9: {
                return pSSysBICubeBase.isDrillDownPSDEViewIdDirty();
            }
            case 10: {
                return pSSysBICubeBase.isDrillDownPSDEViewNameDirty();
            }
            case 11: {
                return pSSysBICubeBase.isEnableCustomizedDirty();
            }
            case 12: {
                return pSSysBICubeBase.isKeyPSDEFIdDirty();
            }
            case 13: {
                return pSSysBICubeBase.isKeyPSDEFNameDirty();
            }
            case 14: {
                return pSSysBICubeBase.isMemoDirty();
            }
            case 15: {
                return pSSysBICubeBase.isPortletPSDEUAGroupIdDirty();
            }
            case 16: {
                return pSSysBICubeBase.isPortletPSDEUAGroupNameDirty();
            }
            case 17: {
                return pSSysBICubeBase.isPSDEDataSetIdDirty();
            }
            case 18: {
                return pSSysBICubeBase.isPSDEDataSetNameDirty();
            }
            case 19: {
                return pSSysBICubeBase.isPSDEIdDirty();
            }
            case 20: {
                return pSSysBICubeBase.isPSDENameDirty();
            }
            case 21: {
                return pSSysBICubeBase.isPSSysBICubeIdDirty();
            }
            case 22: {
                return pSSysBICubeBase.isPSSysBICubeNameDirty();
            }
            case 23: {
                return pSSysBICubeBase.isPSSysBISchemeIdDirty();
            }
            case 24: {
                return pSSysBICubeBase.isPSSysBISchemeNameDirty();
            }
            case 25: {
                return pSSysBICubeBase.isPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSSysBICubeBase.isPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSSysBICubeBase.isPSSysSFPluginIdDirty();
            }
            case 28: {
                return pSSysBICubeBase.isPSSysSFPluginNameDirty();
            }
            case 29: {
                return pSSysBICubeBase.isPSSysUniResIdDirty();
            }
            case 30: {
                return pSSysBICubeBase.isPSSysUniResNameDirty();
            }
            case 31: {
                return pSSysBICubeBase.isTypePSDEFIdDirty();
            }
            case 32: {
                return pSSysBICubeBase.isTypePSDEFNameDirty();
            }
            case 33: {
                return pSSysBICubeBase.isUpdateDateDirty();
            }
            case 34: {
                return pSSysBICubeBase.isUpdateManDirty();
            }
            case 35: {
                return pSSysBICubeBase.isUserCatDirty();
            }
            case 36: {
                return pSSysBICubeBase.isUserTagDirty();
            }
            case 37: {
                return pSSysBICubeBase.isUserTag2Dirty();
            }
            case 38: {
                return pSSysBICubeBase.isUserTag3Dirty();
            }
            case 39: {
                return pSSysBICubeBase.isUserTag4Dirty();
            }
            case 40: {
                return pSSysBICubeBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBICubeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBICubeBase pSSysBICubeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBICubeBase.getBICubeOption() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubeoption", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getBICubeOption()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getBICubeParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubeparams", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getBICubeParams()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getBICubeTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubetag", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getBICubeTag()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getBICubeTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bicubetag2", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getBICubeTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getDrillDetailPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailpsdeviewid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getDrillDetailPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getDrillDetailPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldetailpsdeviewname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getDrillDetailPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getDrillDownPSDEViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldownpsdeviewid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getDrillDownPSDEViewId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getDrillDownPSDEViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"drilldownpsdeviewname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getDrillDownPSDEViewName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getEnableCustomized() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablecustomized", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getEnableCustomized()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getKeyPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getKeyPSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getKeyPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"keypsdefname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getKeyPSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPortletPSDEUAGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portletpsdeuagroupid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPortletPSDEUAGroupId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPortletPSDEUAGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"portletpsdeuagroupname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPortletPSDEUAGroupName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysBICubeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubeid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysBICubeId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysBICubeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbicubename", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysBICubeName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysUniResId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysUniResId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getPSSysUniResName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysuniresname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getPSSysUniResName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getTypePSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefid", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getTypePSDEFId()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getTypePSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typepsdefname", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getTypePSDEFName()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBICubeBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBICubeBase.getJSONValue((Object)pSSysBICubeBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBICubeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBICubeBase pSSysBICubeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBICubeBase.getBICubeOption() != null) {
            object = pSSysBICubeBase.getBICubeOption();
            xmlNode.setAttribute(FIELD_BICUBEOPTION, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeBase.getBICubeParams() != null) {
            object = pSSysBICubeBase.getBICubeParams();
            xmlNode.setAttribute(FIELD_BICUBEPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getBICubeTag() != null) {
            object = pSSysBICubeBase.getBICubeTag();
            xmlNode.setAttribute(FIELD_BICUBETAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getBICubeTag2() != null) {
            object = pSSysBICubeBase.getBICubeTag2();
            xmlNode.setAttribute(FIELD_BICUBETAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getCodeName() != null) {
            object = pSSysBICubeBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getCreateDate() != null) {
            object = pSSysBICubeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeBase.getCreateMan() != null) {
            object = pSSysBICubeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getDrillDetailPSDEViewId() != null) {
            object = pSSysBICubeBase.getDrillDetailPSDEViewId();
            xmlNode.setAttribute(FIELD_DRILLDETAILPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getDrillDetailPSDEViewName() != null) {
            object = pSSysBICubeBase.getDrillDetailPSDEViewName();
            xmlNode.setAttribute(FIELD_DRILLDETAILPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getDrillDownPSDEViewId() != null) {
            object = pSSysBICubeBase.getDrillDownPSDEViewId();
            xmlNode.setAttribute(FIELD_DRILLDOWNPSDEVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getDrillDownPSDEViewName() != null) {
            object = pSSysBICubeBase.getDrillDownPSDEViewName();
            xmlNode.setAttribute(FIELD_DRILLDOWNPSDEVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getEnableCustomized() != null) {
            object = pSSysBICubeBase.getEnableCustomized();
            xmlNode.setAttribute(FIELD_ENABLECUSTOMIZED, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysBICubeBase.getKeyPSDEFId() != null) {
            object = pSSysBICubeBase.getKeyPSDEFId();
            xmlNode.setAttribute(FIELD_KEYPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getKeyPSDEFName() != null) {
            object = pSSysBICubeBase.getKeyPSDEFName();
            xmlNode.setAttribute(FIELD_KEYPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getMemo() != null) {
            object = pSSysBICubeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPortletPSDEUAGroupId() != null) {
            object = pSSysBICubeBase.getPortletPSDEUAGroupId();
            xmlNode.setAttribute(FIELD_PORTLETPSDEUAGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPortletPSDEUAGroupName() != null) {
            object = pSSysBICubeBase.getPortletPSDEUAGroupName();
            xmlNode.setAttribute(FIELD_PORTLETPSDEUAGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSDEDataSetId() != null) {
            object = pSSysBICubeBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSDEDataSetName() != null) {
            object = pSSysBICubeBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSDEId() != null) {
            object = pSSysBICubeBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSDEName() != null) {
            object = pSSysBICubeBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysBICubeId() != null) {
            object = pSSysBICubeBase.getPSSysBICubeId();
            xmlNode.setAttribute(FIELD_PSSYSBICUBEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysBICubeName() != null) {
            object = pSSysBICubeBase.getPSSysBICubeName();
            xmlNode.setAttribute(FIELD_PSSYSBICUBENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysBISchemeId() != null) {
            object = pSSysBICubeBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysBISchemeName() != null) {
            object = pSSysBICubeBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysDynaModelId() != null) {
            object = pSSysBICubeBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysDynaModelName() != null) {
            object = pSSysBICubeBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysSFPluginId() != null) {
            object = pSSysBICubeBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysSFPluginName() != null) {
            object = pSSysBICubeBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysUniResId() != null) {
            object = pSSysBICubeBase.getPSSysUniResId();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getPSSysUniResName() != null) {
            object = pSSysBICubeBase.getPSSysUniResName();
            xmlNode.setAttribute(FIELD_PSSYSUNIRESNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getTypePSDEFId() != null) {
            object = pSSysBICubeBase.getTypePSDEFId();
            xmlNode.setAttribute(FIELD_TYPEPSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getTypePSDEFName() != null) {
            object = pSSysBICubeBase.getTypePSDEFName();
            xmlNode.setAttribute(FIELD_TYPEPSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUpdateDate() != null) {
            object = pSSysBICubeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBICubeBase.getUpdateMan() != null) {
            object = pSSysBICubeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUserCat() != null) {
            object = pSSysBICubeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUserTag() != null) {
            object = pSSysBICubeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUserTag2() != null) {
            object = pSSysBICubeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUserTag3() != null) {
            object = pSSysBICubeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getUserTag4() != null) {
            object = pSSysBICubeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBICubeBase.getValidFlag() != null) {
            object = pSSysBICubeBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBICubeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBICubeBase pSSysBICubeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBICubeBase.isBICubeOptionDirty() && (bl || pSSysBICubeBase.getBICubeOption() != null)) {
            iDataObject.set(FIELD_BICUBEOPTION, (Object)pSSysBICubeBase.getBICubeOption());
        }
        if (pSSysBICubeBase.isBICubeParamsDirty() && (bl || pSSysBICubeBase.getBICubeParams() != null)) {
            iDataObject.set(FIELD_BICUBEPARAMS, (Object)pSSysBICubeBase.getBICubeParams());
        }
        if (pSSysBICubeBase.isBICubeTagDirty() && (bl || pSSysBICubeBase.getBICubeTag() != null)) {
            iDataObject.set(FIELD_BICUBETAG, (Object)pSSysBICubeBase.getBICubeTag());
        }
        if (pSSysBICubeBase.isBICubeTag2Dirty() && (bl || pSSysBICubeBase.getBICubeTag2() != null)) {
            iDataObject.set(FIELD_BICUBETAG2, (Object)pSSysBICubeBase.getBICubeTag2());
        }
        if (pSSysBICubeBase.isCodeNameDirty() && (bl || pSSysBICubeBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBICubeBase.getCodeName());
        }
        if (pSSysBICubeBase.isCreateDateDirty() && (bl || pSSysBICubeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBICubeBase.getCreateDate());
        }
        if (pSSysBICubeBase.isCreateManDirty() && (bl || pSSysBICubeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBICubeBase.getCreateMan());
        }
        if (pSSysBICubeBase.isDrillDetailPSDEViewIdDirty() && (bl || pSSysBICubeBase.getDrillDetailPSDEViewId() != null)) {
            iDataObject.set(FIELD_DRILLDETAILPSDEVIEWID, (Object)pSSysBICubeBase.getDrillDetailPSDEViewId());
        }
        if (pSSysBICubeBase.isDrillDetailPSDEViewNameDirty() && (bl || pSSysBICubeBase.getDrillDetailPSDEViewName() != null)) {
            iDataObject.set(FIELD_DRILLDETAILPSDEVIEWNAME, (Object)pSSysBICubeBase.getDrillDetailPSDEViewName());
        }
        if (pSSysBICubeBase.isDrillDownPSDEViewIdDirty() && (bl || pSSysBICubeBase.getDrillDownPSDEViewId() != null)) {
            iDataObject.set(FIELD_DRILLDOWNPSDEVIEWID, (Object)pSSysBICubeBase.getDrillDownPSDEViewId());
        }
        if (pSSysBICubeBase.isDrillDownPSDEViewNameDirty() && (bl || pSSysBICubeBase.getDrillDownPSDEViewName() != null)) {
            iDataObject.set(FIELD_DRILLDOWNPSDEVIEWNAME, (Object)pSSysBICubeBase.getDrillDownPSDEViewName());
        }
        if (pSSysBICubeBase.isEnableCustomizedDirty() && (bl || pSSysBICubeBase.getEnableCustomized() != null)) {
            iDataObject.set(FIELD_ENABLECUSTOMIZED, (Object)pSSysBICubeBase.getEnableCustomized());
        }
        if (pSSysBICubeBase.isKeyPSDEFIdDirty() && (bl || pSSysBICubeBase.getKeyPSDEFId() != null)) {
            iDataObject.set(FIELD_KEYPSDEFID, (Object)pSSysBICubeBase.getKeyPSDEFId());
        }
        if (pSSysBICubeBase.isKeyPSDEFNameDirty() && (bl || pSSysBICubeBase.getKeyPSDEFName() != null)) {
            iDataObject.set(FIELD_KEYPSDEFNAME, (Object)pSSysBICubeBase.getKeyPSDEFName());
        }
        if (pSSysBICubeBase.isMemoDirty() && (bl || pSSysBICubeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBICubeBase.getMemo());
        }
        if (pSSysBICubeBase.isPortletPSDEUAGroupIdDirty() && (bl || pSSysBICubeBase.getPortletPSDEUAGroupId() != null)) {
            iDataObject.set(FIELD_PORTLETPSDEUAGROUPID, (Object)pSSysBICubeBase.getPortletPSDEUAGroupId());
        }
        if (pSSysBICubeBase.isPortletPSDEUAGroupNameDirty() && (bl || pSSysBICubeBase.getPortletPSDEUAGroupName() != null)) {
            iDataObject.set(FIELD_PORTLETPSDEUAGROUPNAME, (Object)pSSysBICubeBase.getPortletPSDEUAGroupName());
        }
        if (pSSysBICubeBase.isPSDEDataSetIdDirty() && (bl || pSSysBICubeBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSSysBICubeBase.getPSDEDataSetId());
        }
        if (pSSysBICubeBase.isPSDEDataSetNameDirty() && (bl || pSSysBICubeBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSSysBICubeBase.getPSDEDataSetName());
        }
        if (pSSysBICubeBase.isPSDEIdDirty() && (bl || pSSysBICubeBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSSysBICubeBase.getPSDEId());
        }
        if (pSSysBICubeBase.isPSDENameDirty() && (bl || pSSysBICubeBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSSysBICubeBase.getPSDEName());
        }
        if (pSSysBICubeBase.isPSSysBICubeIdDirty() && (bl || pSSysBICubeBase.getPSSysBICubeId() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBEID, (Object)pSSysBICubeBase.getPSSysBICubeId());
        }
        if (pSSysBICubeBase.isPSSysBICubeNameDirty() && (bl || pSSysBICubeBase.getPSSysBICubeName() != null)) {
            iDataObject.set(FIELD_PSSYSBICUBENAME, (Object)pSSysBICubeBase.getPSSysBICubeName());
        }
        if (pSSysBICubeBase.isPSSysBISchemeIdDirty() && (bl || pSSysBICubeBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBICubeBase.getPSSysBISchemeId());
        }
        if (pSSysBICubeBase.isPSSysBISchemeNameDirty() && (bl || pSSysBICubeBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSSysBICubeBase.getPSSysBISchemeName());
        }
        if (pSSysBICubeBase.isPSSysDynaModelIdDirty() && (bl || pSSysBICubeBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSSysBICubeBase.getPSSysDynaModelId());
        }
        if (pSSysBICubeBase.isPSSysDynaModelNameDirty() && (bl || pSSysBICubeBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSSysBICubeBase.getPSSysDynaModelName());
        }
        if (pSSysBICubeBase.isPSSysSFPluginIdDirty() && (bl || pSSysBICubeBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBICubeBase.getPSSysSFPluginId());
        }
        if (pSSysBICubeBase.isPSSysSFPluginNameDirty() && (bl || pSSysBICubeBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBICubeBase.getPSSysSFPluginName());
        }
        if (pSSysBICubeBase.isPSSysUniResIdDirty() && (bl || pSSysBICubeBase.getPSSysUniResId() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESID, (Object)pSSysBICubeBase.getPSSysUniResId());
        }
        if (pSSysBICubeBase.isPSSysUniResNameDirty() && (bl || pSSysBICubeBase.getPSSysUniResName() != null)) {
            iDataObject.set(FIELD_PSSYSUNIRESNAME, (Object)pSSysBICubeBase.getPSSysUniResName());
        }
        if (pSSysBICubeBase.isTypePSDEFIdDirty() && (bl || pSSysBICubeBase.getTypePSDEFId() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFID, (Object)pSSysBICubeBase.getTypePSDEFId());
        }
        if (pSSysBICubeBase.isTypePSDEFNameDirty() && (bl || pSSysBICubeBase.getTypePSDEFName() != null)) {
            iDataObject.set(FIELD_TYPEPSDEFNAME, (Object)pSSysBICubeBase.getTypePSDEFName());
        }
        if (pSSysBICubeBase.isUpdateDateDirty() && (bl || pSSysBICubeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBICubeBase.getUpdateDate());
        }
        if (pSSysBICubeBase.isUpdateManDirty() && (bl || pSSysBICubeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBICubeBase.getUpdateMan());
        }
        if (pSSysBICubeBase.isUserCatDirty() && (bl || pSSysBICubeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBICubeBase.getUserCat());
        }
        if (pSSysBICubeBase.isUserTagDirty() && (bl || pSSysBICubeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBICubeBase.getUserTag());
        }
        if (pSSysBICubeBase.isUserTag2Dirty() && (bl || pSSysBICubeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBICubeBase.getUserTag2());
        }
        if (pSSysBICubeBase.isUserTag3Dirty() && (bl || pSSysBICubeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBICubeBase.getUserTag3());
        }
        if (pSSysBICubeBase.isUserTag4Dirty() && (bl || pSSysBICubeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBICubeBase.getUserTag4());
        }
        if (pSSysBICubeBase.isValidFlagDirty() && (bl || pSSysBICubeBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBICubeBase.getValidFlag());
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
        return PSSysBICubeBase.remove(this, n);
    }

    private static boolean remove(PSSysBICubeBase pSSysBICubeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBICubeBase.resetBICubeOption();
                return true;
            }
            case 1: {
                pSSysBICubeBase.resetBICubeParams();
                return true;
            }
            case 2: {
                pSSysBICubeBase.resetBICubeTag();
                return true;
            }
            case 3: {
                pSSysBICubeBase.resetBICubeTag2();
                return true;
            }
            case 4: {
                pSSysBICubeBase.resetCodeName();
                return true;
            }
            case 5: {
                pSSysBICubeBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSSysBICubeBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSSysBICubeBase.resetDrillDetailPSDEViewId();
                return true;
            }
            case 8: {
                pSSysBICubeBase.resetDrillDetailPSDEViewName();
                return true;
            }
            case 9: {
                pSSysBICubeBase.resetDrillDownPSDEViewId();
                return true;
            }
            case 10: {
                pSSysBICubeBase.resetDrillDownPSDEViewName();
                return true;
            }
            case 11: {
                pSSysBICubeBase.resetEnableCustomized();
                return true;
            }
            case 12: {
                pSSysBICubeBase.resetKeyPSDEFId();
                return true;
            }
            case 13: {
                pSSysBICubeBase.resetKeyPSDEFName();
                return true;
            }
            case 14: {
                pSSysBICubeBase.resetMemo();
                return true;
            }
            case 15: {
                pSSysBICubeBase.resetPortletPSDEUAGroupId();
                return true;
            }
            case 16: {
                pSSysBICubeBase.resetPortletPSDEUAGroupName();
                return true;
            }
            case 17: {
                pSSysBICubeBase.resetPSDEDataSetId();
                return true;
            }
            case 18: {
                pSSysBICubeBase.resetPSDEDataSetName();
                return true;
            }
            case 19: {
                pSSysBICubeBase.resetPSDEId();
                return true;
            }
            case 20: {
                pSSysBICubeBase.resetPSDEName();
                return true;
            }
            case 21: {
                pSSysBICubeBase.resetPSSysBICubeId();
                return true;
            }
            case 22: {
                pSSysBICubeBase.resetPSSysBICubeName();
                return true;
            }
            case 23: {
                pSSysBICubeBase.resetPSSysBISchemeId();
                return true;
            }
            case 24: {
                pSSysBICubeBase.resetPSSysBISchemeName();
                return true;
            }
            case 25: {
                pSSysBICubeBase.resetPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSSysBICubeBase.resetPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSSysBICubeBase.resetPSSysSFPluginId();
                return true;
            }
            case 28: {
                pSSysBICubeBase.resetPSSysSFPluginName();
                return true;
            }
            case 29: {
                pSSysBICubeBase.resetPSSysUniResId();
                return true;
            }
            case 30: {
                pSSysBICubeBase.resetPSSysUniResName();
                return true;
            }
            case 31: {
                pSSysBICubeBase.resetTypePSDEFId();
                return true;
            }
            case 32: {
                pSSysBICubeBase.resetTypePSDEFName();
                return true;
            }
            case 33: {
                pSSysBICubeBase.resetUpdateDate();
                return true;
            }
            case 34: {
                pSSysBICubeBase.resetUpdateMan();
                return true;
            }
            case 35: {
                pSSysBICubeBase.resetUserCat();
                return true;
            }
            case 36: {
                pSSysBICubeBase.resetUserTag();
                return true;
            }
            case 37: {
                pSSysBICubeBase.resetUserTag2();
                return true;
            }
            case 38: {
                pSSysBICubeBase.resetUserTag3();
                return true;
            }
            case 39: {
                pSSysBICubeBase.resetUserTag4();
                return true;
            }
            case 40: {
                pSSysBICubeBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDE();
        }
        if (this.getPSDEId() == null) {
            return null;
        }
        Integer n = this.objPSDELock;
        synchronized (n) {
            if (this.psde != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEId(), (Object)this.psde.getPSDataEntityId()) != 0L) {
                this.psde = null;
            }
            if (this.psde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataSet();
        }
        if (this.getPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataSetLock;
        synchronized (n) {
            if (this.psdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataSetId(), (Object)this.psdedataset.getPSDEDataSetId()) != 0L) {
                this.psdedataset = null;
            }
            if (this.psdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.psdedataset = pSDEDataSet;
            }
            return this.psdedataset;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getKeyPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getKeyPSDEF();
        }
        if (this.getKeyPSDEFId() == null) {
            return null;
        }
        Integer n = this.objKeyPSDEFLock;
        synchronized (n) {
            if (this.keypsdef != null && DataTypeHelper.compare((int)25, (Object)this.getKeyPSDEFId(), (Object)this.keypsdef.getPSDEFieldId()) != 0L) {
                this.keypsdef = null;
            }
            if (this.keypsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getKeyPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.keypsdef = pSDEField;
            }
            return this.keypsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getTypePSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypePSDEF();
        }
        if (this.getTypePSDEFId() == null) {
            return null;
        }
        Integer n = this.objTypePSDEFLock;
        synchronized (n) {
            if (this.typepsdef != null && DataTypeHelper.compare((int)25, (Object)this.getTypePSDEFId(), (Object)this.typepsdef.getPSDEFieldId()) != 0L) {
                this.typepsdef = null;
            }
            if (this.typepsdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getTypePSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet(pSDEField);
                this.typepsdef = pSDEField;
            }
            return this.typepsdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEUAGroup getPortletPSDEUAGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPortletPSDEUAGroup();
        }
        if (this.getPortletPSDEUAGroupId() == null) {
            return null;
        }
        Integer n = this.objPortletPSDEUAGroupLock;
        synchronized (n) {
            if (this.portletpsdeuagroup != null && DataTypeHelper.compare((int)25, (Object)this.getPortletPSDEUAGroupId(), (Object)this.portletpsdeuagroup.getPSDEUAGroupId()) != 0L) {
                this.portletpsdeuagroup = null;
            }
            if (this.portletpsdeuagroup == null) {
                PSDEUAGroup pSDEUAGroup = new PSDEUAGroup();
                pSDEUAGroup.setPSDEUAGroupId(this.getPortletPSDEUAGroupId());
                PSDEUAGroupService pSDEUAGroupService = (PSDEUAGroupService)ServiceGlobal.getService(PSDEUAGroupService.class, (SessionFactory)this.getSessionFactory());
                pSDEUAGroupService.autoGet(pSDEUAGroup);
                this.portletpsdeuagroup = pSDEUAGroup;
            }
            return this.portletpsdeuagroup;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getDrillDetailPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDetailPSDEView();
        }
        if (this.getDrillDetailPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objDrillDetailPSDEViewLock;
        synchronized (n) {
            if (this.drilldetailpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getDrillDetailPSDEViewId(), (Object)this.drilldetailpsdeview.getPSDEViewBaseId()) != 0L) {
                this.drilldetailpsdeview = null;
            }
            if (this.drilldetailpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getDrillDetailPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.drilldetailpsdeview = pSDEViewBase;
            }
            return this.drilldetailpsdeview;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getDrillDownPSDEView() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDrillDownPSDEView();
        }
        if (this.getDrillDownPSDEViewId() == null) {
            return null;
        }
        Integer n = this.objDrillDownPSDEViewLock;
        synchronized (n) {
            if (this.drilldownpsdeview != null && DataTypeHelper.compare((int)25, (Object)this.getDrillDownPSDEViewId(), (Object)this.drilldownpsdeview.getPSDEViewBaseId()) != 0L) {
                this.drilldownpsdeview = null;
            }
            if (this.drilldownpsdeview == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getDrillDownPSDEViewId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet(pSDEViewBase);
                this.drilldownpsdeview = pSDEViewBase;
            }
            return this.drilldownpsdeview;
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
                pSSysBISchemeService.autoGet(pSSysBIScheme);
                this.pssysbischeme = pSSysBIScheme;
            }
            return this.pssysbischeme;
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
                pSSysSFPluginService.autoGet(pSSysSFPlugin);
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
                pSSysUniResService.autoGet(pSSysUniRes);
                this.pssysunires = pSSysUniRes;
            }
            return this.pssysunires;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBICubeDimension> getPSSysBICubeDimensions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeDimensions();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        PSSysBICubeDimensionService pSSysBICubeDimensionService = (PSSysBICubeDimensionService)ServiceGlobal.getService(PSSysBICubeDimensionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBICubeDimensionsLock;
        synchronized (n) {
            if (this.pssysbicubedimensions == null) {
                this.pssysbicubedimensions = pSSysBICubeDimensionService.selectByPSSysBICube(this);
            }
            return this.pssysbicubedimensions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysBICubeMeasure> getPSSysBICubeMeasures() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBICubeMeasures();
        }
        if (this.getPSSysBICubeId() == null) {
            return null;
        }
        PSSysBICubeMeasureService pSSysBICubeMeasureService = (PSSysBICubeMeasureService)ServiceGlobal.getService(PSSysBICubeMeasureService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBICubeMeasuresLock;
        synchronized (n) {
            if (this.pssysbicubemeasures == null) {
                this.pssysbicubemeasures = pSSysBICubeMeasureService.selectByPSSysBICube(this);
            }
            return this.pssysbicubemeasures;
        }
    }

    private PSSysBICubeBase getProxyEntity() {
        return this.proxyPSSysBICubeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBICubeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBICubeBase) {
            this.proxyPSSysBICubeBase = (PSSysBICubeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBICubeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BICUBEOPTION, 0);
        fieldIndexMap.put(FIELD_BICUBEPARAMS, 1);
        fieldIndexMap.put(FIELD_BICUBETAG, 2);
        fieldIndexMap.put(FIELD_BICUBETAG2, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_DRILLDETAILPSDEVIEWID, 7);
        fieldIndexMap.put(FIELD_DRILLDETAILPSDEVIEWNAME, 8);
        fieldIndexMap.put(FIELD_DRILLDOWNPSDEVIEWID, 9);
        fieldIndexMap.put(FIELD_DRILLDOWNPSDEVIEWNAME, 10);
        fieldIndexMap.put(FIELD_ENABLECUSTOMIZED, 11);
        fieldIndexMap.put(FIELD_KEYPSDEFID, 12);
        fieldIndexMap.put(FIELD_KEYPSDEFNAME, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_PORTLETPSDEUAGROUPID, 15);
        fieldIndexMap.put(FIELD_PORTLETPSDEUAGROUPNAME, 16);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 17);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 18);
        fieldIndexMap.put(FIELD_PSDEID, 19);
        fieldIndexMap.put(FIELD_PSDENAME, 20);
        fieldIndexMap.put(FIELD_PSSYSBICUBEID, 21);
        fieldIndexMap.put(FIELD_PSSYSBICUBENAME, 22);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 23);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 27);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSUNIRESID, 29);
        fieldIndexMap.put(FIELD_PSSYSUNIRESNAME, 30);
        fieldIndexMap.put(FIELD_TYPEPSDEFID, 31);
        fieldIndexMap.put(FIELD_TYPEPSDEFNAME, 32);
        fieldIndexMap.put(FIELD_UPDATEDATE, 33);
        fieldIndexMap.put(FIELD_UPDATEMAN, 34);
        fieldIndexMap.put(FIELD_USERCAT, 35);
        fieldIndexMap.put(FIELD_USERTAG, 36);
        fieldIndexMap.put(FIELD_USERTAG2, 37);
        fieldIndexMap.put(FIELD_USERTAG3, 38);
        fieldIndexMap.put(FIELD_USERTAG4, 39);
        fieldIndexMap.put(FIELD_VALIDFLAG, 40);
    }
}

