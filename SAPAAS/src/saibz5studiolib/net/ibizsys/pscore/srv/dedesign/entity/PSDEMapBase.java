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
import net.ibizsys.pscore.srv.config.entity.PSSysPFPlugin;
import net.ibizsys.pscore.srv.config.service.PSSysPFPluginService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDQ;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMapDetail;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapDetailService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysDynaModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRef;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysRefDE;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysReqItem;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysDynaModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefDEService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysRefService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysReqItemService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMapBase.class);
    public static final String FIELD_AUTODEACTIONMAP = "AUTODEACTIONMAP";
    public static final String FIELD_AUTODEDQMAP = "AUTODEDQMAP";
    public static final String FIELD_AUTODEDSMAP = "AUTODEDSMAP";
    public static final String FIELD_AUTODEFIELDMAP = "AUTODEFIELDMAP";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CUSTOMCODE = "CUSTOMCODE";
    public static final String FIELD_CUSTOMMODE = "CUSTOMMODE";
    public static final String FIELD_DEFAULTMODE = "DEFAULTMODE";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_DSTPSDENAME = "DSTPSDENAME";
    public static final String FIELD_DSTPSSYSREFDEID = "DSTPSSYSREFDEID";
    public static final String FIELD_DSTPSSYSREFDENAME = "DSTPSSYSREFDENAME";
    public static final String FIELD_LOGICHOLDER = "LOGICHOLDER";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MAPMODE = "MAPMODE";
    public static final String FIELD_MAPTARGET = "MAPTARGET";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAPID = "PSDEMAPID";
    public static final String FIELD_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSSYSDYNAMODELID = "PSSYSDYNAMODELID";
    public static final String FIELD_PSSYSDYNAMODELNAME = "PSSYSDYNAMODELNAME";
    public static final String FIELD_PSSYSPFPLUGINID = "PSSYSPFPLUGINID";
    public static final String FIELD_PSSYSPFPLUGINNAME = "PSSYSPFPLUGINNAME";
    public static final String FIELD_PSSYSREFID = "PSSYSREFID";
    public static final String FIELD_PSSYSREFNAME = "PSSYSREFNAME";
    public static final String FIELD_PSSYSREQITEMID = "PSSYSREQITEMID";
    public static final String FIELD_PSSYSREQITEMNAME = "PSSYSREQITEMNAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_AUTODEACTIONMAP = 0;
    private static final int INDEX_AUTODEDQMAP = 1;
    private static final int INDEX_AUTODEDSMAP = 2;
    private static final int INDEX_AUTODEFIELDMAP = 3;
    private static final int INDEX_CODENAME = 4;
    private static final int INDEX_CREATEDATE = 5;
    private static final int INDEX_CREATEMAN = 6;
    private static final int INDEX_CUSTOMCODE = 7;
    private static final int INDEX_CUSTOMMODE = 8;
    private static final int INDEX_DEFAULTMODE = 9;
    private static final int INDEX_DSTPSDEID = 10;
    private static final int INDEX_DSTPSDENAME = 11;
    private static final int INDEX_DSTPSSYSREFDEID = 12;
    private static final int INDEX_DSTPSSYSREFDENAME = 13;
    private static final int INDEX_LOGICHOLDER = 14;
    private static final int INDEX_LOGICNAME = 15;
    private static final int INDEX_MAPMODE = 16;
    private static final int INDEX_MAPTARGET = 17;
    private static final int INDEX_MEMO = 18;
    private static final int INDEX_ORDERVALUE = 19;
    private static final int INDEX_PROPERTYMAP = 20;
    private static final int INDEX_PSDEID = 21;
    private static final int INDEX_PSDEMAPID = 22;
    private static final int INDEX_PSDEMAPNAME = 23;
    private static final int INDEX_PSDENAME = 24;
    private static final int INDEX_PSSYSDYNAMODELID = 25;
    private static final int INDEX_PSSYSDYNAMODELNAME = 26;
    private static final int INDEX_PSSYSPFPLUGINID = 27;
    private static final int INDEX_PSSYSPFPLUGINNAME = 28;
    private static final int INDEX_PSSYSREFID = 29;
    private static final int INDEX_PSSYSREFNAME = 30;
    private static final int INDEX_PSSYSREQITEMID = 31;
    private static final int INDEX_PSSYSREQITEMNAME = 32;
    private static final int INDEX_PSSYSSFPLUGINID = 33;
    private static final int INDEX_PSSYSSFPLUGINNAME = 34;
    private static final int INDEX_PSSYSTEMID = 35;
    private static final int INDEX_UPDATEDATE = 36;
    private static final int INDEX_UPDATEMAN = 37;
    private static final int INDEX_USERCAT = 38;
    private static final int INDEX_USERTAG = 39;
    private static final int INDEX_USERTAG2 = 40;
    private static final int INDEX_USERTAG3 = 41;
    private static final int INDEX_USERTAG4 = 42;
    private static final int INDEX_VALIDFLAG = 43;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMapBase proxyPSDEMapBase = null;
    private boolean autodeactionmapDirtyFlag = false;
    private boolean autodedqmapDirtyFlag = false;
    private boolean autodedsmapDirtyFlag = false;
    private boolean autodefieldmapDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean customcodeDirtyFlag = false;
    private boolean custommodeDirtyFlag = false;
    private boolean defaultmodeDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean dstpsdenameDirtyFlag = false;
    private boolean dstpssysrefdeidDirtyFlag = false;
    private boolean dstpssysrefdenameDirtyFlag = false;
    private boolean logicholderDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean mapmodeDirtyFlag = false;
    private boolean maptargetDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemapidDirtyFlag = false;
    private boolean psdemapnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean pssysdynamodelidDirtyFlag = false;
    private boolean pssysdynamodelnameDirtyFlag = false;
    private boolean pssyspfpluginidDirtyFlag = false;
    private boolean pssyspfpluginnameDirtyFlag = false;
    private boolean pssysrefidDirtyFlag = false;
    private boolean pssysrefnameDirtyFlag = false;
    private boolean pssysreqitemidDirtyFlag = false;
    private boolean pssysreqitemnameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="autodeactionmap")
    private Integer autodeactionmap;
    @Column(name="autodedqmap")
    private Integer autodedqmap;
    @Column(name="autodedsmap")
    private Integer autodedsmap;
    @Column(name="autodefieldmap")
    private Integer autodefieldmap;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="customcode")
    private String customcode;
    @Column(name="custommode")
    private Integer custommode;
    @Column(name="defaultmode")
    private Integer defaultmode;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="dstpsdename")
    private String dstpsdename;
    @Column(name="dstpssysrefdeid")
    private String dstpssysrefdeid;
    @Column(name="dstpssysrefdename")
    private String dstpssysrefdename;
    @Column(name="logicholder")
    private Integer logicholder;
    @Column(name="logicname")
    private String logicname;
    @Column(name="mapmode")
    private String mapmode;
    @Column(name="maptarget")
    private String maptarget;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemapid")
    private String psdemapid;
    @Column(name="psdemapname")
    private String psdemapname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="pssysdynamodelid")
    private String pssysdynamodelid;
    @Column(name="pssysdynamodelname")
    private String pssysdynamodelname;
    @Column(name="pssyspfpluginid")
    private String pssyspfpluginid;
    @Column(name="pssyspfpluginname")
    private String pssyspfpluginname;
    @Column(name="pssysrefid")
    private String pssysrefid;
    @Column(name="pssysrefname")
    private String pssysrefname;
    @Column(name="pssysreqitemid")
    private String pssysreqitemid;
    @Column(name="pssysreqitemname")
    private String pssysreqitemname;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
    @Column(name="pssystemid")
    private String pssystemid;
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
    private Integer objDstPSDELock = new Integer(1);
    private PSDataEntity dstpsde = null;
    private Integer objPSDELock = new Integer(1);
    private PSDataEntity psde = null;
    private Integer objPSSysDynaModelLock = new Integer(1);
    private PSSysDynaModel pssysdynamodel = null;
    private Integer objPSSysPFPluginLock = new Integer(1);
    private PSSysPFPlugin pssyspfplugin = null;
    private Integer objDstPSSysRefDELock = new Integer(1);
    private PSSysRefDE dstpssysrefde = null;
    private Integer objPSSysRefLock = new Integer(1);
    private PSSysRef pssysref = null;
    private Integer objPSSysReqItemLock = new Integer(1);
    private PSSysReqItem pssysreqitem = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSDEMapActionsLock = new Integer(1);
    private ArrayList<PSDEMapAction> psdemapactions = null;
    private Integer objPSDEMapDetailsLock = new Integer(1);
    private ArrayList<PSDEMapDetail> psdemapdetails = null;
    private Integer objPSDEMapDQsLock = new Integer(1);
    private ArrayList<PSDEMapDQ> psdemapdqs = null;

    public void setAutoDEActionMap(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoDEActionMap(n);
            return;
        }
        this.autodeactionmap = n;
        this.autodeactionmapDirtyFlag = true;
    }

    public Integer getAutoDEActionMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoDEActionMap();
        }
        return this.autodeactionmap;
    }

    public boolean isAutoDEActionMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoDEActionMapDirty();
        }
        return this.autodeactionmapDirtyFlag;
    }

    public void resetAutoDEActionMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoDEActionMap();
            return;
        }
        this.autodeactionmapDirtyFlag = false;
        this.autodeactionmap = null;
    }

    public void setAutoDEDQMap(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoDEDQMap(n);
            return;
        }
        this.autodedqmap = n;
        this.autodedqmapDirtyFlag = true;
    }

    public Integer getAutoDEDQMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoDEDQMap();
        }
        return this.autodedqmap;
    }

    public boolean isAutoDEDQMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoDEDQMapDirty();
        }
        return this.autodedqmapDirtyFlag;
    }

    public void resetAutoDEDQMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoDEDQMap();
            return;
        }
        this.autodedqmapDirtyFlag = false;
        this.autodedqmap = null;
    }

    public void setAutoDEDSMap(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoDEDSMap(n);
            return;
        }
        this.autodedsmap = n;
        this.autodedsmapDirtyFlag = true;
    }

    public Integer getAutoDEDSMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoDEDSMap();
        }
        return this.autodedsmap;
    }

    public boolean isAutoDEDSMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoDEDSMapDirty();
        }
        return this.autodedsmapDirtyFlag;
    }

    public void resetAutoDEDSMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoDEDSMap();
            return;
        }
        this.autodedsmapDirtyFlag = false;
        this.autodedsmap = null;
    }

    public void setAutoDEFieldMap(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAutoDEFieldMap(n);
            return;
        }
        this.autodefieldmap = n;
        this.autodefieldmapDirtyFlag = true;
    }

    public Integer getAutoDEFieldMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAutoDEFieldMap();
        }
        return this.autodefieldmap;
    }

    public boolean isAutoDEFieldMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAutoDEFieldMapDirty();
        }
        return this.autodefieldmapDirtyFlag;
    }

    public void resetAutoDEFieldMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAutoDEFieldMap();
            return;
        }
        this.autodefieldmapDirtyFlag = false;
        this.autodefieldmap = null;
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

    public void setDefaultMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultMode(n);
            return;
        }
        this.defaultmode = n;
        this.defaultmodeDirtyFlag = true;
    }

    public Integer getDefaultMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultMode();
        }
        return this.defaultmode;
    }

    public boolean isDefaultModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultModeDirty();
        }
        return this.defaultmodeDirtyFlag;
    }

    public void resetDefaultMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultMode();
            return;
        }
        this.defaultmodeDirtyFlag = false;
        this.defaultmode = null;
    }

    public void setDSTPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDSTPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDSTPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDSTPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setDSTPSDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDSTPSDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdename = string;
        this.dstpsdenameDirtyFlag = true;
    }

    public String getDSTPSDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDSTPSDEName();
        }
        return this.dstpsdename;
    }

    public boolean isDSTPSDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDSTPSDENameDirty();
        }
        return this.dstpsdenameDirtyFlag;
    }

    public void resetDSTPSDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDSTPSDEName();
            return;
        }
        this.dstpsdenameDirtyFlag = false;
        this.dstpsdename = null;
    }

    public void setDstPSSysRefDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSSysRefDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpssysrefdeid = string;
        this.dstpssysrefdeidDirtyFlag = true;
    }

    public String getDstPSSysRefDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSSysRefDEId();
        }
        return this.dstpssysrefdeid;
    }

    public boolean isDstPSSysRefDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSSysRefDEIdDirty();
        }
        return this.dstpssysrefdeidDirtyFlag;
    }

    public void resetDstPSSysRefDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSSysRefDEId();
            return;
        }
        this.dstpssysrefdeidDirtyFlag = false;
        this.dstpssysrefdeid = null;
    }

    public void setDstPSSysRefDEName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSSysRefDEName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpssysrefdename = string;
        this.dstpssysrefdenameDirtyFlag = true;
    }

    public String getDstPSSysRefDEName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSSysRefDEName();
        }
        return this.dstpssysrefdename;
    }

    public boolean isDstPSSysRefDENameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSSysRefDENameDirty();
        }
        return this.dstpssysrefdenameDirtyFlag;
    }

    public void resetDstPSSysRefDEName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSSysRefDEName();
            return;
        }
        this.dstpssysrefdenameDirtyFlag = false;
        this.dstpssysrefdename = null;
    }

    public void setLogicHolder(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicHolder(n);
            return;
        }
        this.logicholder = n;
        this.logicholderDirtyFlag = true;
    }

    public Integer getLogicHolder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicHolder();
        }
        return this.logicholder;
    }

    public boolean isLogicHolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicHolderDirty();
        }
        return this.logicholderDirtyFlag;
    }

    public void resetLogicHolder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicHolder();
            return;
        }
        this.logicholderDirtyFlag = false;
        this.logicholder = null;
    }

    public void setLogicName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLogicName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.logicname = string;
        this.logicnameDirtyFlag = true;
    }

    public String getLogicName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLogicName();
        }
        return this.logicname;
    }

    public boolean isLogicNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLogicNameDirty();
        }
        return this.logicnameDirtyFlag;
    }

    public void resetLogicName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLogicName();
            return;
        }
        this.logicnameDirtyFlag = false;
        this.logicname = null;
    }

    public void setMapMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.mapmode = string;
        this.mapmodeDirtyFlag = true;
    }

    public String getMapMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapMode();
        }
        return this.mapmode;
    }

    public boolean isMapModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapModeDirty();
        }
        return this.mapmodeDirtyFlag;
    }

    public void resetMapMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapMode();
            return;
        }
        this.mapmodeDirtyFlag = false;
        this.mapmode = null;
    }

    public void setMapTarget(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMapTarget(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.maptarget = string;
        this.maptargetDirtyFlag = true;
    }

    public String getMapTarget() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMapTarget();
        }
        return this.maptarget;
    }

    public boolean isMapTargetDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMapTargetDirty();
        }
        return this.maptargetDirtyFlag;
    }

    public void resetMapTarget() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMapTarget();
            return;
        }
        this.maptargetDirtyFlag = false;
        this.maptarget = null;
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

    public void setPropertyMap(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPropertyMap(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.propertymap = string;
        this.propertymapDirtyFlag = true;
    }

    public String getPropertyMap() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPropertyMap();
        }
        return this.propertymap;
    }

    public boolean isPropertyMapDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPropertyMapDirty();
        }
        return this.propertymapDirtyFlag;
    }

    public void resetPropertyMap() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPropertyMap();
            return;
        }
        this.propertymapDirtyFlag = false;
        this.propertymap = null;
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

    public void setPSDEMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapid = string;
        this.psdemapidDirtyFlag = true;
    }

    public String getPSDEMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapId();
        }
        return this.psdemapid;
    }

    public boolean isPSDEMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapIdDirty();
        }
        return this.psdemapidDirtyFlag;
    }

    public void resetPSDEMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapId();
            return;
        }
        this.psdemapidDirtyFlag = false;
        this.psdemapid = null;
    }

    public void setPSDEMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapname = string;
        this.psdemapnameDirtyFlag = true;
    }

    public String getPSDEMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapName();
        }
        return this.psdemapname;
    }

    public boolean isPSDEMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapNameDirty();
        }
        return this.psdemapnameDirtyFlag;
    }

    public void resetPSDEMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapName();
            return;
        }
        this.psdemapnameDirtyFlag = false;
        this.psdemapname = null;
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

    public void setPSSysRefId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefid = string;
        this.pssysrefidDirtyFlag = true;
    }

    public String getPSSysRefId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefId();
        }
        return this.pssysrefid;
    }

    public boolean isPSSysRefIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefIdDirty();
        }
        return this.pssysrefidDirtyFlag;
    }

    public void resetPSSysRefId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefId();
            return;
        }
        this.pssysrefidDirtyFlag = false;
        this.pssysrefid = null;
    }

    public void setPSSysRefName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysRefName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysrefname = string;
        this.pssysrefnameDirtyFlag = true;
    }

    public String getPSSysRefName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRefName();
        }
        return this.pssysrefname;
    }

    public boolean isPSSysRefNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysRefNameDirty();
        }
        return this.pssysrefnameDirtyFlag;
    }

    public void resetPSSysRefName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysRefName();
            return;
        }
        this.pssysrefnameDirtyFlag = false;
        this.pssysrefname = null;
    }

    public void setPSSysReqItemId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemid = string;
        this.pssysreqitemidDirtyFlag = true;
    }

    public String getPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemId();
        }
        return this.pssysreqitemid;
    }

    public boolean isPSSysReqItemIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemIdDirty();
        }
        return this.pssysreqitemidDirtyFlag;
    }

    public void resetPSSysReqItemId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemId();
            return;
        }
        this.pssysreqitemidDirtyFlag = false;
        this.pssysreqitemid = null;
    }

    public void setPSSysReqItemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysReqItemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysreqitemname = string;
        this.pssysreqitemnameDirtyFlag = true;
    }

    public String getPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItemName();
        }
        return this.pssysreqitemname;
    }

    public boolean isPSSysReqItemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysReqItemNameDirty();
        }
        return this.pssysreqitemnameDirtyFlag;
    }

    public void resetPSSysReqItemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysReqItemName();
            return;
        }
        this.pssysreqitemnameDirtyFlag = false;
        this.pssysreqitemname = null;
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
        PSDEMapBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMapBase pSDEMapBase) {
        pSDEMapBase.resetAutoDEActionMap();
        pSDEMapBase.resetAutoDEDQMap();
        pSDEMapBase.resetAutoDEDSMap();
        pSDEMapBase.resetAutoDEFieldMap();
        pSDEMapBase.resetCodeName();
        pSDEMapBase.resetCreateDate();
        pSDEMapBase.resetCreateMan();
        pSDEMapBase.resetCustomCode();
        pSDEMapBase.resetCustomMode();
        pSDEMapBase.resetDefaultMode();
        pSDEMapBase.resetDSTPSDEId();
        pSDEMapBase.resetDSTPSDEName();
        pSDEMapBase.resetDstPSSysRefDEId();
        pSDEMapBase.resetDstPSSysRefDEName();
        pSDEMapBase.resetLogicHolder();
        pSDEMapBase.resetLogicName();
        pSDEMapBase.resetMapMode();
        pSDEMapBase.resetMapTarget();
        pSDEMapBase.resetMemo();
        pSDEMapBase.resetOrderValue();
        pSDEMapBase.resetPropertyMap();
        pSDEMapBase.resetPSDEId();
        pSDEMapBase.resetPSDEMapId();
        pSDEMapBase.resetPSDEMapName();
        pSDEMapBase.resetPSDEName();
        pSDEMapBase.resetPSSysDynaModelId();
        pSDEMapBase.resetPSSysDynaModelName();
        pSDEMapBase.resetPSSysPFPluginId();
        pSDEMapBase.resetPSSysPFPluginName();
        pSDEMapBase.resetPSSysRefId();
        pSDEMapBase.resetPSSysRefName();
        pSDEMapBase.resetPSSysReqItemId();
        pSDEMapBase.resetPSSysReqItemName();
        pSDEMapBase.resetPSSysSFPluginId();
        pSDEMapBase.resetPSSysSFPluginName();
        pSDEMapBase.resetPSSystemId();
        pSDEMapBase.resetUpdateDate();
        pSDEMapBase.resetUpdateMan();
        pSDEMapBase.resetUserCat();
        pSDEMapBase.resetUserTag();
        pSDEMapBase.resetUserTag2();
        pSDEMapBase.resetUserTag3();
        pSDEMapBase.resetUserTag4();
        pSDEMapBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAutoDEActionMapDirty()) {
            hashMap.put(FIELD_AUTODEACTIONMAP, this.getAutoDEActionMap());
        }
        if (!bl || this.isAutoDEDQMapDirty()) {
            hashMap.put(FIELD_AUTODEDQMAP, this.getAutoDEDQMap());
        }
        if (!bl || this.isAutoDEDSMapDirty()) {
            hashMap.put(FIELD_AUTODEDSMAP, this.getAutoDEDSMap());
        }
        if (!bl || this.isAutoDEFieldMapDirty()) {
            hashMap.put(FIELD_AUTODEFIELDMAP, this.getAutoDEFieldMap());
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
        if (!bl || this.isCustomCodeDirty()) {
            hashMap.put(FIELD_CUSTOMCODE, this.getCustomCode());
        }
        if (!bl || this.isCustomModeDirty()) {
            hashMap.put(FIELD_CUSTOMMODE, this.getCustomMode());
        }
        if (!bl || this.isDefaultModeDirty()) {
            hashMap.put(FIELD_DEFAULTMODE, this.getDefaultMode());
        }
        if (!bl || this.isDSTPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDSTPSDEId());
        }
        if (!bl || this.isDSTPSDENameDirty()) {
            hashMap.put(FIELD_DSTPSDENAME, this.getDSTPSDEName());
        }
        if (!bl || this.isDstPSSysRefDEIdDirty()) {
            hashMap.put(FIELD_DSTPSSYSREFDEID, this.getDstPSSysRefDEId());
        }
        if (!bl || this.isDstPSSysRefDENameDirty()) {
            hashMap.put(FIELD_DSTPSSYSREFDENAME, this.getDstPSSysRefDEName());
        }
        if (!bl || this.isLogicHolderDirty()) {
            hashMap.put(FIELD_LOGICHOLDER, this.getLogicHolder());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMapModeDirty()) {
            hashMap.put(FIELD_MAPMODE, this.getMapMode());
        }
        if (!bl || this.isMapTargetDirty()) {
            hashMap.put(FIELD_MAPTARGET, this.getMapTarget());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPropertyMapDirty()) {
            hashMap.put(FIELD_PROPERTYMAP, this.getPropertyMap());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMapIdDirty()) {
            hashMap.put(FIELD_PSDEMAPID, this.getPSDEMapId());
        }
        if (!bl || this.isPSDEMapNameDirty()) {
            hashMap.put(FIELD_PSDEMAPNAME, this.getPSDEMapName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSSysDynaModelIdDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELID, this.getPSSysDynaModelId());
        }
        if (!bl || this.isPSSysDynaModelNameDirty()) {
            hashMap.put(FIELD_PSSYSDYNAMODELNAME, this.getPSSysDynaModelName());
        }
        if (!bl || this.isPSSysPFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINID, this.getPSSysPFPluginId());
        }
        if (!bl || this.isPSSysPFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSPFPLUGINNAME, this.getPSSysPFPluginName());
        }
        if (!bl || this.isPSSysRefIdDirty()) {
            hashMap.put(FIELD_PSSYSREFID, this.getPSSysRefId());
        }
        if (!bl || this.isPSSysRefNameDirty()) {
            hashMap.put(FIELD_PSSYSREFNAME, this.getPSSysRefName());
        }
        if (!bl || this.isPSSysReqItemIdDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMID, this.getPSSysReqItemId());
        }
        if (!bl || this.isPSSysReqItemNameDirty()) {
            hashMap.put(FIELD_PSSYSREQITEMNAME, this.getPSSysReqItemName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
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
        return PSDEMapBase.get(this, n);
    }

    private static Object get(PSDEMapBase pSDEMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapBase.getAutoDEActionMap();
            }
            case 1: {
                return pSDEMapBase.getAutoDEDQMap();
            }
            case 2: {
                return pSDEMapBase.getAutoDEDSMap();
            }
            case 3: {
                return pSDEMapBase.getAutoDEFieldMap();
            }
            case 4: {
                return pSDEMapBase.getCodeName();
            }
            case 5: {
                return pSDEMapBase.getCreateDate();
            }
            case 6: {
                return pSDEMapBase.getCreateMan();
            }
            case 7: {
                return pSDEMapBase.getCustomCode();
            }
            case 8: {
                return pSDEMapBase.getCustomMode();
            }
            case 9: {
                return pSDEMapBase.getDefaultMode();
            }
            case 10: {
                return pSDEMapBase.getDSTPSDEId();
            }
            case 11: {
                return pSDEMapBase.getDSTPSDEName();
            }
            case 12: {
                return pSDEMapBase.getDstPSSysRefDEId();
            }
            case 13: {
                return pSDEMapBase.getDstPSSysRefDEName();
            }
            case 14: {
                return pSDEMapBase.getLogicHolder();
            }
            case 15: {
                return pSDEMapBase.getLogicName();
            }
            case 16: {
                return pSDEMapBase.getMapMode();
            }
            case 17: {
                return pSDEMapBase.getMapTarget();
            }
            case 18: {
                return pSDEMapBase.getMemo();
            }
            case 19: {
                return pSDEMapBase.getOrderValue();
            }
            case 20: {
                return pSDEMapBase.getPropertyMap();
            }
            case 21: {
                return pSDEMapBase.getPSDEId();
            }
            case 22: {
                return pSDEMapBase.getPSDEMapId();
            }
            case 23: {
                return pSDEMapBase.getPSDEMapName();
            }
            case 24: {
                return pSDEMapBase.getPSDEName();
            }
            case 25: {
                return pSDEMapBase.getPSSysDynaModelId();
            }
            case 26: {
                return pSDEMapBase.getPSSysDynaModelName();
            }
            case 27: {
                return pSDEMapBase.getPSSysPFPluginId();
            }
            case 28: {
                return pSDEMapBase.getPSSysPFPluginName();
            }
            case 29: {
                return pSDEMapBase.getPSSysRefId();
            }
            case 30: {
                return pSDEMapBase.getPSSysRefName();
            }
            case 31: {
                return pSDEMapBase.getPSSysReqItemId();
            }
            case 32: {
                return pSDEMapBase.getPSSysReqItemName();
            }
            case 33: {
                return pSDEMapBase.getPSSysSFPluginId();
            }
            case 34: {
                return pSDEMapBase.getPSSysSFPluginName();
            }
            case 35: {
                return pSDEMapBase.getPSSystemId();
            }
            case 36: {
                return pSDEMapBase.getUpdateDate();
            }
            case 37: {
                return pSDEMapBase.getUpdateMan();
            }
            case 38: {
                return pSDEMapBase.getUserCat();
            }
            case 39: {
                return pSDEMapBase.getUserTag();
            }
            case 40: {
                return pSDEMapBase.getUserTag2();
            }
            case 41: {
                return pSDEMapBase.getUserTag3();
            }
            case 42: {
                return pSDEMapBase.getUserTag4();
            }
            case 43: {
                return pSDEMapBase.getValidFlag();
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
        PSDEMapBase.set(this, n, object);
    }

    private static void set(PSDEMapBase pSDEMapBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapBase.setAutoDEActionMap(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 1: {
                pSDEMapBase.setAutoDEDQMap(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSDEMapBase.setAutoDEDSMap(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSDEMapBase.setAutoDEFieldMap(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSDEMapBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMapBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 6: {
                pSDEMapBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMapBase.setCustomCode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMapBase.setCustomMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSDEMapBase.setDefaultMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSDEMapBase.setDSTPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMapBase.setDSTPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMapBase.setDstPSSysRefDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMapBase.setDstPSSysRefDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMapBase.setLogicHolder(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSDEMapBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMapBase.setMapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMapBase.setMapTarget(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMapBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMapBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 20: {
                pSDEMapBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMapBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMapBase.setPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEMapBase.setPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEMapBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEMapBase.setPSSysDynaModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSDEMapBase.setPSSysDynaModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSDEMapBase.setPSSysPFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSDEMapBase.setPSSysPFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 29: {
                pSDEMapBase.setPSSysRefId(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSDEMapBase.setPSSysRefName(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSDEMapBase.setPSSysReqItemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 32: {
                pSDEMapBase.setPSSysReqItemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 33: {
                pSDEMapBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 34: {
                pSDEMapBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 35: {
                pSDEMapBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 36: {
                pSDEMapBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 37: {
                pSDEMapBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 38: {
                pSDEMapBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 39: {
                pSDEMapBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 40: {
                pSDEMapBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 41: {
                pSDEMapBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 42: {
                pSDEMapBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 43: {
                pSDEMapBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMapBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMapBase pSDEMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapBase.getAutoDEActionMap() == null;
            }
            case 1: {
                return pSDEMapBase.getAutoDEDQMap() == null;
            }
            case 2: {
                return pSDEMapBase.getAutoDEDSMap() == null;
            }
            case 3: {
                return pSDEMapBase.getAutoDEFieldMap() == null;
            }
            case 4: {
                return pSDEMapBase.getCodeName() == null;
            }
            case 5: {
                return pSDEMapBase.getCreateDate() == null;
            }
            case 6: {
                return pSDEMapBase.getCreateMan() == null;
            }
            case 7: {
                return pSDEMapBase.getCustomCode() == null;
            }
            case 8: {
                return pSDEMapBase.getCustomMode() == null;
            }
            case 9: {
                return pSDEMapBase.getDefaultMode() == null;
            }
            case 10: {
                return pSDEMapBase.getDSTPSDEId() == null;
            }
            case 11: {
                return pSDEMapBase.getDSTPSDEName() == null;
            }
            case 12: {
                return pSDEMapBase.getDstPSSysRefDEId() == null;
            }
            case 13: {
                return pSDEMapBase.getDstPSSysRefDEName() == null;
            }
            case 14: {
                return pSDEMapBase.getLogicHolder() == null;
            }
            case 15: {
                return pSDEMapBase.getLogicName() == null;
            }
            case 16: {
                return pSDEMapBase.getMapMode() == null;
            }
            case 17: {
                return pSDEMapBase.getMapTarget() == null;
            }
            case 18: {
                return pSDEMapBase.getMemo() == null;
            }
            case 19: {
                return pSDEMapBase.getOrderValue() == null;
            }
            case 20: {
                return pSDEMapBase.getPropertyMap() == null;
            }
            case 21: {
                return pSDEMapBase.getPSDEId() == null;
            }
            case 22: {
                return pSDEMapBase.getPSDEMapId() == null;
            }
            case 23: {
                return pSDEMapBase.getPSDEMapName() == null;
            }
            case 24: {
                return pSDEMapBase.getPSDEName() == null;
            }
            case 25: {
                return pSDEMapBase.getPSSysDynaModelId() == null;
            }
            case 26: {
                return pSDEMapBase.getPSSysDynaModelName() == null;
            }
            case 27: {
                return pSDEMapBase.getPSSysPFPluginId() == null;
            }
            case 28: {
                return pSDEMapBase.getPSSysPFPluginName() == null;
            }
            case 29: {
                return pSDEMapBase.getPSSysRefId() == null;
            }
            case 30: {
                return pSDEMapBase.getPSSysRefName() == null;
            }
            case 31: {
                return pSDEMapBase.getPSSysReqItemId() == null;
            }
            case 32: {
                return pSDEMapBase.getPSSysReqItemName() == null;
            }
            case 33: {
                return pSDEMapBase.getPSSysSFPluginId() == null;
            }
            case 34: {
                return pSDEMapBase.getPSSysSFPluginName() == null;
            }
            case 35: {
                return pSDEMapBase.getPSSystemId() == null;
            }
            case 36: {
                return pSDEMapBase.getUpdateDate() == null;
            }
            case 37: {
                return pSDEMapBase.getUpdateMan() == null;
            }
            case 38: {
                return pSDEMapBase.getUserCat() == null;
            }
            case 39: {
                return pSDEMapBase.getUserTag() == null;
            }
            case 40: {
                return pSDEMapBase.getUserTag2() == null;
            }
            case 41: {
                return pSDEMapBase.getUserTag3() == null;
            }
            case 42: {
                return pSDEMapBase.getUserTag4() == null;
            }
            case 43: {
                return pSDEMapBase.getValidFlag() == null;
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
        return PSDEMapBase.contains(this, n);
    }

    private static boolean contains(PSDEMapBase pSDEMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapBase.isAutoDEActionMapDirty();
            }
            case 1: {
                return pSDEMapBase.isAutoDEDQMapDirty();
            }
            case 2: {
                return pSDEMapBase.isAutoDEDSMapDirty();
            }
            case 3: {
                return pSDEMapBase.isAutoDEFieldMapDirty();
            }
            case 4: {
                return pSDEMapBase.isCodeNameDirty();
            }
            case 5: {
                return pSDEMapBase.isCreateDateDirty();
            }
            case 6: {
                return pSDEMapBase.isCreateManDirty();
            }
            case 7: {
                return pSDEMapBase.isCustomCodeDirty();
            }
            case 8: {
                return pSDEMapBase.isCustomModeDirty();
            }
            case 9: {
                return pSDEMapBase.isDefaultModeDirty();
            }
            case 10: {
                return pSDEMapBase.isDSTPSDEIdDirty();
            }
            case 11: {
                return pSDEMapBase.isDSTPSDENameDirty();
            }
            case 12: {
                return pSDEMapBase.isDstPSSysRefDEIdDirty();
            }
            case 13: {
                return pSDEMapBase.isDstPSSysRefDENameDirty();
            }
            case 14: {
                return pSDEMapBase.isLogicHolderDirty();
            }
            case 15: {
                return pSDEMapBase.isLogicNameDirty();
            }
            case 16: {
                return pSDEMapBase.isMapModeDirty();
            }
            case 17: {
                return pSDEMapBase.isMapTargetDirty();
            }
            case 18: {
                return pSDEMapBase.isMemoDirty();
            }
            case 19: {
                return pSDEMapBase.isOrderValueDirty();
            }
            case 20: {
                return pSDEMapBase.isPropertyMapDirty();
            }
            case 21: {
                return pSDEMapBase.isPSDEIdDirty();
            }
            case 22: {
                return pSDEMapBase.isPSDEMapIdDirty();
            }
            case 23: {
                return pSDEMapBase.isPSDEMapNameDirty();
            }
            case 24: {
                return pSDEMapBase.isPSDENameDirty();
            }
            case 25: {
                return pSDEMapBase.isPSSysDynaModelIdDirty();
            }
            case 26: {
                return pSDEMapBase.isPSSysDynaModelNameDirty();
            }
            case 27: {
                return pSDEMapBase.isPSSysPFPluginIdDirty();
            }
            case 28: {
                return pSDEMapBase.isPSSysPFPluginNameDirty();
            }
            case 29: {
                return pSDEMapBase.isPSSysRefIdDirty();
            }
            case 30: {
                return pSDEMapBase.isPSSysRefNameDirty();
            }
            case 31: {
                return pSDEMapBase.isPSSysReqItemIdDirty();
            }
            case 32: {
                return pSDEMapBase.isPSSysReqItemNameDirty();
            }
            case 33: {
                return pSDEMapBase.isPSSysSFPluginIdDirty();
            }
            case 34: {
                return pSDEMapBase.isPSSysSFPluginNameDirty();
            }
            case 35: {
                return pSDEMapBase.isPSSystemIdDirty();
            }
            case 36: {
                return pSDEMapBase.isUpdateDateDirty();
            }
            case 37: {
                return pSDEMapBase.isUpdateManDirty();
            }
            case 38: {
                return pSDEMapBase.isUserCatDirty();
            }
            case 39: {
                return pSDEMapBase.isUserTagDirty();
            }
            case 40: {
                return pSDEMapBase.isUserTag2Dirty();
            }
            case 41: {
                return pSDEMapBase.isUserTag3Dirty();
            }
            case 42: {
                return pSDEMapBase.isUserTag4Dirty();
            }
            case 43: {
                return pSDEMapBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMapBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMapBase pSDEMapBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMapBase.getAutoDEActionMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autodeactionmap", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getAutoDEActionMap()), (boolean)false);
        }
        if (bl || pSDEMapBase.getAutoDEDQMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autodedqmap", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getAutoDEDQMap()), (boolean)false);
        }
        if (bl || pSDEMapBase.getAutoDEDSMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autodedsmap", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getAutoDEDSMap()), (boolean)false);
        }
        if (bl || pSDEMapBase.getAutoDEFieldMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"autodefieldmap", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getAutoDEFieldMap()), (boolean)false);
        }
        if (bl || pSDEMapBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMapBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMapBase.getCustomCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"customcode", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getCustomCode()), (boolean)false);
        }
        if (bl || pSDEMapBase.getCustomMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"custommode", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getCustomMode()), (boolean)false);
        }
        if (bl || pSDEMapBase.getDefaultMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultmode", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getDefaultMode()), (boolean)false);
        }
        if (bl || pSDEMapBase.getDSTPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getDSTPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getDSTPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdename", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getDSTPSDEName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getDstPSSysRefDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpssysrefdeid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getDstPSSysRefDEId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getDstPSSysRefDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpssysrefdename", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getDstPSSysRefDEName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getLogicHolder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicholder", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getLogicHolder()), (boolean)false);
        }
        if (bl || pSDEMapBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getLogicName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getMapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapmode", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getMapMode()), (boolean)false);
        }
        if (bl || pSDEMapBase.getMapTarget() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"maptarget", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getMapTarget()), (boolean)false);
        }
        if (bl || pSDEMapBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMapBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSDEMapId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSDEMapName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysDynaModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysDynaModelId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysDynaModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysdynamodelname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysDynaModelName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysPFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysPFPluginId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysPFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyspfpluginname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysPFPluginName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysRefId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysRefId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysRefName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysrefname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysRefName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysReqItemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysReqItemId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysReqItemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysreqitemname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysReqItemName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSDEMapBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMapBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMapBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMapBase.getJSONValue((Object)pSDEMapBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMapBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMapBase pSDEMapBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMapBase.getAutoDEActionMap() != null) {
            object = pSDEMapBase.getAutoDEActionMap();
            xmlNode.setAttribute(FIELD_AUTODEACTIONMAP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getAutoDEDQMap() != null) {
            object = pSDEMapBase.getAutoDEDQMap();
            xmlNode.setAttribute(FIELD_AUTODEDQMAP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getAutoDEDSMap() != null) {
            object = pSDEMapBase.getAutoDEDSMap();
            xmlNode.setAttribute(FIELD_AUTODEDSMAP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getAutoDEFieldMap() != null) {
            object = pSDEMapBase.getAutoDEFieldMap();
            xmlNode.setAttribute(FIELD_AUTODEFIELDMAP, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getCodeName() != null) {
            object = pSDEMapBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getCreateDate() != null) {
            object = pSDEMapBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapBase.getCreateMan() != null) {
            object = pSDEMapBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getCustomCode() != null) {
            object = pSDEMapBase.getCustomCode();
            xmlNode.setAttribute(FIELD_CUSTOMCODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getCustomMode() != null) {
            object = pSDEMapBase.getCustomMode();
            xmlNode.setAttribute(FIELD_CUSTOMMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getDefaultMode() != null) {
            object = pSDEMapBase.getDefaultMode();
            xmlNode.setAttribute(FIELD_DEFAULTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getDSTPSDEId() != null) {
            object = pSDEMapBase.getDSTPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getDSTPSDEName() != null) {
            object = pSDEMapBase.getDSTPSDEName();
            xmlNode.setAttribute(FIELD_DSTPSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getDstPSSysRefDEId() != null) {
            object = pSDEMapBase.getDstPSSysRefDEId();
            xmlNode.setAttribute(FIELD_DSTPSSYSREFDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getDstPSSysRefDEName() != null) {
            object = pSDEMapBase.getDstPSSysRefDEName();
            xmlNode.setAttribute(FIELD_DSTPSSYSREFDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getLogicHolder() != null) {
            object = pSDEMapBase.getLogicHolder();
            xmlNode.setAttribute(FIELD_LOGICHOLDER, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getLogicName() != null) {
            object = pSDEMapBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getMapMode() != null) {
            object = pSDEMapBase.getMapMode();
            xmlNode.setAttribute(FIELD_MAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getMapTarget() != null) {
            object = pSDEMapBase.getMapTarget();
            xmlNode.setAttribute(FIELD_MAPTARGET, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getMemo() != null) {
            object = pSDEMapBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getOrderValue() != null) {
            object = pSDEMapBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapBase.getPropertyMap() != null) {
            object = pSDEMapBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSDEId() != null) {
            object = pSDEMapBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSDEMapId() != null) {
            object = pSDEMapBase.getPSDEMapId();
            xmlNode.setAttribute(FIELD_PSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSDEMapName() != null) {
            object = pSDEMapBase.getPSDEMapName();
            xmlNode.setAttribute(FIELD_PSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSDEName() != null) {
            object = pSDEMapBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysDynaModelId() != null) {
            object = pSDEMapBase.getPSSysDynaModelId();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysDynaModelName() != null) {
            object = pSDEMapBase.getPSSysDynaModelName();
            xmlNode.setAttribute(FIELD_PSSYSDYNAMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysPFPluginId() != null) {
            object = pSDEMapBase.getPSSysPFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysPFPluginName() != null) {
            object = pSDEMapBase.getPSSysPFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSPFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysRefId() != null) {
            object = pSDEMapBase.getPSSysRefId();
            xmlNode.setAttribute(FIELD_PSSYSREFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysRefName() != null) {
            object = pSDEMapBase.getPSSysRefName();
            xmlNode.setAttribute(FIELD_PSSYSREFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysReqItemId() != null) {
            object = pSDEMapBase.getPSSysReqItemId();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysReqItemName() != null) {
            object = pSDEMapBase.getPSSysReqItemName();
            xmlNode.setAttribute(FIELD_PSSYSREQITEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysSFPluginId() != null) {
            object = pSDEMapBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSysSFPluginName() != null) {
            object = pSDEMapBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getPSSystemId() != null) {
            object = pSDEMapBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUpdateDate() != null) {
            object = pSDEMapBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapBase.getUpdateMan() != null) {
            object = pSDEMapBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUserCat() != null) {
            object = pSDEMapBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUserTag() != null) {
            object = pSDEMapBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUserTag2() != null) {
            object = pSDEMapBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUserTag3() != null) {
            object = pSDEMapBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getUserTag4() != null) {
            object = pSDEMapBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapBase.getValidFlag() != null) {
            object = pSDEMapBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMapBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMapBase pSDEMapBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMapBase.isAutoDEActionMapDirty() && (bl || pSDEMapBase.getAutoDEActionMap() != null)) {
            iDataObject.set(FIELD_AUTODEACTIONMAP, (Object)pSDEMapBase.getAutoDEActionMap());
        }
        if (pSDEMapBase.isAutoDEDQMapDirty() && (bl || pSDEMapBase.getAutoDEDQMap() != null)) {
            iDataObject.set(FIELD_AUTODEDQMAP, (Object)pSDEMapBase.getAutoDEDQMap());
        }
        if (pSDEMapBase.isAutoDEDSMapDirty() && (bl || pSDEMapBase.getAutoDEDSMap() != null)) {
            iDataObject.set(FIELD_AUTODEDSMAP, (Object)pSDEMapBase.getAutoDEDSMap());
        }
        if (pSDEMapBase.isAutoDEFieldMapDirty() && (bl || pSDEMapBase.getAutoDEFieldMap() != null)) {
            iDataObject.set(FIELD_AUTODEFIELDMAP, (Object)pSDEMapBase.getAutoDEFieldMap());
        }
        if (pSDEMapBase.isCodeNameDirty() && (bl || pSDEMapBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEMapBase.getCodeName());
        }
        if (pSDEMapBase.isCreateDateDirty() && (bl || pSDEMapBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMapBase.getCreateDate());
        }
        if (pSDEMapBase.isCreateManDirty() && (bl || pSDEMapBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMapBase.getCreateMan());
        }
        if (pSDEMapBase.isCustomCodeDirty() && (bl || pSDEMapBase.getCustomCode() != null)) {
            iDataObject.set(FIELD_CUSTOMCODE, (Object)pSDEMapBase.getCustomCode());
        }
        if (pSDEMapBase.isCustomModeDirty() && (bl || pSDEMapBase.getCustomMode() != null)) {
            iDataObject.set(FIELD_CUSTOMMODE, (Object)pSDEMapBase.getCustomMode());
        }
        if (pSDEMapBase.isDefaultModeDirty() && (bl || pSDEMapBase.getDefaultMode() != null)) {
            iDataObject.set(FIELD_DEFAULTMODE, (Object)pSDEMapBase.getDefaultMode());
        }
        if (pSDEMapBase.isDSTPSDEIdDirty() && (bl || pSDEMapBase.getDSTPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEMapBase.getDSTPSDEId());
        }
        if (pSDEMapBase.isDSTPSDENameDirty() && (bl || pSDEMapBase.getDSTPSDEName() != null)) {
            iDataObject.set(FIELD_DSTPSDENAME, (Object)pSDEMapBase.getDSTPSDEName());
        }
        if (pSDEMapBase.isDstPSSysRefDEIdDirty() && (bl || pSDEMapBase.getDstPSSysRefDEId() != null)) {
            iDataObject.set(FIELD_DSTPSSYSREFDEID, (Object)pSDEMapBase.getDstPSSysRefDEId());
        }
        if (pSDEMapBase.isDstPSSysRefDENameDirty() && (bl || pSDEMapBase.getDstPSSysRefDEName() != null)) {
            iDataObject.set(FIELD_DSTPSSYSREFDENAME, (Object)pSDEMapBase.getDstPSSysRefDEName());
        }
        if (pSDEMapBase.isLogicHolderDirty() && (bl || pSDEMapBase.getLogicHolder() != null)) {
            iDataObject.set(FIELD_LOGICHOLDER, (Object)pSDEMapBase.getLogicHolder());
        }
        if (pSDEMapBase.isLogicNameDirty() && (bl || pSDEMapBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSDEMapBase.getLogicName());
        }
        if (pSDEMapBase.isMapModeDirty() && (bl || pSDEMapBase.getMapMode() != null)) {
            iDataObject.set(FIELD_MAPMODE, (Object)pSDEMapBase.getMapMode());
        }
        if (pSDEMapBase.isMapTargetDirty() && (bl || pSDEMapBase.getMapTarget() != null)) {
            iDataObject.set(FIELD_MAPTARGET, (Object)pSDEMapBase.getMapTarget());
        }
        if (pSDEMapBase.isMemoDirty() && (bl || pSDEMapBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMapBase.getMemo());
        }
        if (pSDEMapBase.isOrderValueDirty() && (bl || pSDEMapBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSDEMapBase.getOrderValue());
        }
        if (pSDEMapBase.isPropertyMapDirty() && (bl || pSDEMapBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDEMapBase.getPropertyMap());
        }
        if (pSDEMapBase.isPSDEIdDirty() && (bl || pSDEMapBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMapBase.getPSDEId());
        }
        if (pSDEMapBase.isPSDEMapIdDirty() && (bl || pSDEMapBase.getPSDEMapId() != null)) {
            iDataObject.set(FIELD_PSDEMAPID, (Object)pSDEMapBase.getPSDEMapId());
        }
        if (pSDEMapBase.isPSDEMapNameDirty() && (bl || pSDEMapBase.getPSDEMapName() != null)) {
            iDataObject.set(FIELD_PSDEMAPNAME, (Object)pSDEMapBase.getPSDEMapName());
        }
        if (pSDEMapBase.isPSDENameDirty() && (bl || pSDEMapBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEMapBase.getPSDEName());
        }
        if (pSDEMapBase.isPSSysDynaModelIdDirty() && (bl || pSDEMapBase.getPSSysDynaModelId() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELID, (Object)pSDEMapBase.getPSSysDynaModelId());
        }
        if (pSDEMapBase.isPSSysDynaModelNameDirty() && (bl || pSDEMapBase.getPSSysDynaModelName() != null)) {
            iDataObject.set(FIELD_PSSYSDYNAMODELNAME, (Object)pSDEMapBase.getPSSysDynaModelName());
        }
        if (pSDEMapBase.isPSSysPFPluginIdDirty() && (bl || pSDEMapBase.getPSSysPFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINID, (Object)pSDEMapBase.getPSSysPFPluginId());
        }
        if (pSDEMapBase.isPSSysPFPluginNameDirty() && (bl || pSDEMapBase.getPSSysPFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSPFPLUGINNAME, (Object)pSDEMapBase.getPSSysPFPluginName());
        }
        if (pSDEMapBase.isPSSysRefIdDirty() && (bl || pSDEMapBase.getPSSysRefId() != null)) {
            iDataObject.set(FIELD_PSSYSREFID, (Object)pSDEMapBase.getPSSysRefId());
        }
        if (pSDEMapBase.isPSSysRefNameDirty() && (bl || pSDEMapBase.getPSSysRefName() != null)) {
            iDataObject.set(FIELD_PSSYSREFNAME, (Object)pSDEMapBase.getPSSysRefName());
        }
        if (pSDEMapBase.isPSSysReqItemIdDirty() && (bl || pSDEMapBase.getPSSysReqItemId() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMID, (Object)pSDEMapBase.getPSSysReqItemId());
        }
        if (pSDEMapBase.isPSSysReqItemNameDirty() && (bl || pSDEMapBase.getPSSysReqItemName() != null)) {
            iDataObject.set(FIELD_PSSYSREQITEMNAME, (Object)pSDEMapBase.getPSSysReqItemName());
        }
        if (pSDEMapBase.isPSSysSFPluginIdDirty() && (bl || pSDEMapBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSDEMapBase.getPSSysSFPluginId());
        }
        if (pSDEMapBase.isPSSysSFPluginNameDirty() && (bl || pSDEMapBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSDEMapBase.getPSSysSFPluginName());
        }
        if (pSDEMapBase.isPSSystemIdDirty() && (bl || pSDEMapBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSDEMapBase.getPSSystemId());
        }
        if (pSDEMapBase.isUpdateDateDirty() && (bl || pSDEMapBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMapBase.getUpdateDate());
        }
        if (pSDEMapBase.isUpdateManDirty() && (bl || pSDEMapBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMapBase.getUpdateMan());
        }
        if (pSDEMapBase.isUserCatDirty() && (bl || pSDEMapBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMapBase.getUserCat());
        }
        if (pSDEMapBase.isUserTagDirty() && (bl || pSDEMapBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMapBase.getUserTag());
        }
        if (pSDEMapBase.isUserTag2Dirty() && (bl || pSDEMapBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMapBase.getUserTag2());
        }
        if (pSDEMapBase.isUserTag3Dirty() && (bl || pSDEMapBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMapBase.getUserTag3());
        }
        if (pSDEMapBase.isUserTag4Dirty() && (bl || pSDEMapBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMapBase.getUserTag4());
        }
        if (pSDEMapBase.isValidFlagDirty() && (bl || pSDEMapBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMapBase.getValidFlag());
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
        return PSDEMapBase.remove(this, n);
    }

    private static boolean remove(PSDEMapBase pSDEMapBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapBase.resetAutoDEActionMap();
                return true;
            }
            case 1: {
                pSDEMapBase.resetAutoDEDQMap();
                return true;
            }
            case 2: {
                pSDEMapBase.resetAutoDEDSMap();
                return true;
            }
            case 3: {
                pSDEMapBase.resetAutoDEFieldMap();
                return true;
            }
            case 4: {
                pSDEMapBase.resetCodeName();
                return true;
            }
            case 5: {
                pSDEMapBase.resetCreateDate();
                return true;
            }
            case 6: {
                pSDEMapBase.resetCreateMan();
                return true;
            }
            case 7: {
                pSDEMapBase.resetCustomCode();
                return true;
            }
            case 8: {
                pSDEMapBase.resetCustomMode();
                return true;
            }
            case 9: {
                pSDEMapBase.resetDefaultMode();
                return true;
            }
            case 10: {
                pSDEMapBase.resetDSTPSDEId();
                return true;
            }
            case 11: {
                pSDEMapBase.resetDSTPSDEName();
                return true;
            }
            case 12: {
                pSDEMapBase.resetDstPSSysRefDEId();
                return true;
            }
            case 13: {
                pSDEMapBase.resetDstPSSysRefDEName();
                return true;
            }
            case 14: {
                pSDEMapBase.resetLogicHolder();
                return true;
            }
            case 15: {
                pSDEMapBase.resetLogicName();
                return true;
            }
            case 16: {
                pSDEMapBase.resetMapMode();
                return true;
            }
            case 17: {
                pSDEMapBase.resetMapTarget();
                return true;
            }
            case 18: {
                pSDEMapBase.resetMemo();
                return true;
            }
            case 19: {
                pSDEMapBase.resetOrderValue();
                return true;
            }
            case 20: {
                pSDEMapBase.resetPropertyMap();
                return true;
            }
            case 21: {
                pSDEMapBase.resetPSDEId();
                return true;
            }
            case 22: {
                pSDEMapBase.resetPSDEMapId();
                return true;
            }
            case 23: {
                pSDEMapBase.resetPSDEMapName();
                return true;
            }
            case 24: {
                pSDEMapBase.resetPSDEName();
                return true;
            }
            case 25: {
                pSDEMapBase.resetPSSysDynaModelId();
                return true;
            }
            case 26: {
                pSDEMapBase.resetPSSysDynaModelName();
                return true;
            }
            case 27: {
                pSDEMapBase.resetPSSysPFPluginId();
                return true;
            }
            case 28: {
                pSDEMapBase.resetPSSysPFPluginName();
                return true;
            }
            case 29: {
                pSDEMapBase.resetPSSysRefId();
                return true;
            }
            case 30: {
                pSDEMapBase.resetPSSysRefName();
                return true;
            }
            case 31: {
                pSDEMapBase.resetPSSysReqItemId();
                return true;
            }
            case 32: {
                pSDEMapBase.resetPSSysReqItemName();
                return true;
            }
            case 33: {
                pSDEMapBase.resetPSSysSFPluginId();
                return true;
            }
            case 34: {
                pSDEMapBase.resetPSSysSFPluginName();
                return true;
            }
            case 35: {
                pSDEMapBase.resetPSSystemId();
                return true;
            }
            case 36: {
                pSDEMapBase.resetUpdateDate();
                return true;
            }
            case 37: {
                pSDEMapBase.resetUpdateMan();
                return true;
            }
            case 38: {
                pSDEMapBase.resetUserCat();
                return true;
            }
            case 39: {
                pSDEMapBase.resetUserTag();
                return true;
            }
            case 40: {
                pSDEMapBase.resetUserTag2();
                return true;
            }
            case 41: {
                pSDEMapBase.resetUserTag3();
                return true;
            }
            case 42: {
                pSDEMapBase.resetUserTag4();
                return true;
            }
            case 43: {
                pSDEMapBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDataEntity getDstPSDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDE();
        }
        if (this.getDSTPSDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSDELock;
        synchronized (n) {
            if (this.dstpsde != null && DataTypeHelper.compare((int)25, (Object)this.getDSTPSDEId(), (Object)this.dstpsde.getPSDataEntityId()) != 0L) {
                this.dstpsde = null;
            }
            if (this.dstpsde == null) {
                PSDataEntity pSDataEntity = new PSDataEntity();
                pSDataEntity.setPSDataEntityId(this.getDSTPSDEId());
                PSDataEntityService pSDataEntityService = (PSDataEntityService)ServiceGlobal.getService(PSDataEntityService.class, (SessionFactory)this.getSessionFactory());
                pSDataEntityService.autoGet(pSDataEntity);
                this.dstpsde = pSDataEntity;
            }
            return this.dstpsde;
        }
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
                pSSysPFPluginService.autoGet(pSSysPFPlugin);
                this.pssyspfplugin = pSSysPFPlugin;
            }
            return this.pssyspfplugin;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysRefDE getDstPSSysRefDE() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSSysRefDE();
        }
        if (this.getDstPSSysRefDEId() == null) {
            return null;
        }
        Integer n = this.objDstPSSysRefDELock;
        synchronized (n) {
            if (this.dstpssysrefde != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSSysRefDEId(), (Object)this.dstpssysrefde.getPSSysRefDEId()) != 0L) {
                this.dstpssysrefde = null;
            }
            if (this.dstpssysrefde == null) {
                PSSysRefDE pSSysRefDE = new PSSysRefDE();
                pSSysRefDE.setPSSysRefDEId(this.getDstPSSysRefDEId());
                PSSysRefDEService pSSysRefDEService = (PSSysRefDEService)ServiceGlobal.getService(PSSysRefDEService.class, (SessionFactory)this.getSessionFactory());
                pSSysRefDEService.autoGet(pSSysRefDE);
                this.dstpssysrefde = pSSysRefDE;
            }
            return this.dstpssysrefde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysRef getPSSysRef() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysRef();
        }
        if (this.getPSSysRefId() == null) {
            return null;
        }
        Integer n = this.objPSSysRefLock;
        synchronized (n) {
            if (this.pssysref != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysRefId(), (Object)this.pssysref.getPSSysRefId()) != 0L) {
                this.pssysref = null;
            }
            if (this.pssysref == null) {
                PSSysRef pSSysRef = new PSSysRef();
                pSSysRef.setPSSysRefId(this.getPSSysRefId());
                PSSysRefService pSSysRefService = (PSSysRefService)ServiceGlobal.getService(PSSysRefService.class, (SessionFactory)this.getSessionFactory());
                pSSysRefService.autoGet(pSSysRef);
                this.pssysref = pSSysRef;
            }
            return this.pssysref;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysReqItem getPSSysReqItem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysReqItem();
        }
        if (this.getPSSysReqItemId() == null) {
            return null;
        }
        Integer n = this.objPSSysReqItemLock;
        synchronized (n) {
            if (this.pssysreqitem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysReqItemId(), (Object)this.pssysreqitem.getPSSysReqItemId()) != 0L) {
                this.pssysreqitem = null;
            }
            if (this.pssysreqitem == null) {
                PSSysReqItem pSSysReqItem = new PSSysReqItem();
                pSSysReqItem.setPSSysReqItemId(this.getPSSysReqItemId());
                PSSysReqItemService pSSysReqItemService = (PSSysReqItemService)ServiceGlobal.getService(PSSysReqItemService.class, (SessionFactory)this.getSessionFactory());
                pSSysReqItemService.autoGet(pSSysReqItem);
                this.pssysreqitem = pSSysReqItem;
            }
            return this.pssysreqitem;
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
    public ArrayList<PSDEMapAction> getPSDEMapActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapActions();
        }
        if (this.getPSDEMapId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        PSDEMapActionService pSDEMapActionService = (PSDEMapActionService)ServiceGlobal.getService(PSDEMapActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapActionsLock;
        synchronized (n) {
            if (this.psdemapactions == null) {
                this.psdemapactions = pSDEMapService.isTempData(this) ? pSDEMapActionService.selectTempByPSDEMap(this) : pSDEMapActionService.selectByPSDEMap(this);
            }
            return this.psdemapactions;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMapDetail> getPSDEMapDetails() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDetails();
        }
        if (this.getPSDEMapId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        PSDEMapDetailService pSDEMapDetailService = (PSDEMapDetailService)ServiceGlobal.getService(PSDEMapDetailService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapDetailsLock;
        synchronized (n) {
            if (this.psdemapdetails == null) {
                this.psdemapdetails = pSDEMapService.isTempData(this) ? pSDEMapDetailService.selectTempByPSDEMap(this) : pSDEMapDetailService.selectByPSDEMap(this);
            }
            return this.psdemapdetails;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSDEMapDQ> getPSDEMapDQs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDQs();
        }
        if (this.getPSDEMapId() == null) {
            return null;
        }
        PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
        PSDEMapDQService pSDEMapDQService = (PSDEMapDQService)ServiceGlobal.getService(PSDEMapDQService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSDEMapDQsLock;
        synchronized (n) {
            if (this.psdemapdqs == null) {
                this.psdemapdqs = pSDEMapService.isTempData(this) ? pSDEMapDQService.selectTempByPSDEMap(this) : pSDEMapDQService.selectByPSDEMap(this);
            }
            return this.psdemapdqs;
        }
    }

    private PSDEMapBase getProxyEntity() {
        return this.proxyPSDEMapBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMapBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMapBase) {
            this.proxyPSDEMapBase = (PSDEMapBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_AUTODEACTIONMAP, 0);
        fieldIndexMap.put(FIELD_AUTODEDQMAP, 1);
        fieldIndexMap.put(FIELD_AUTODEDSMAP, 2);
        fieldIndexMap.put(FIELD_AUTODEFIELDMAP, 3);
        fieldIndexMap.put(FIELD_CODENAME, 4);
        fieldIndexMap.put(FIELD_CREATEDATE, 5);
        fieldIndexMap.put(FIELD_CREATEMAN, 6);
        fieldIndexMap.put(FIELD_CUSTOMCODE, 7);
        fieldIndexMap.put(FIELD_CUSTOMMODE, 8);
        fieldIndexMap.put(FIELD_DEFAULTMODE, 9);
        fieldIndexMap.put(FIELD_DSTPSDEID, 10);
        fieldIndexMap.put(FIELD_DSTPSDENAME, 11);
        fieldIndexMap.put(FIELD_DSTPSSYSREFDEID, 12);
        fieldIndexMap.put(FIELD_DSTPSSYSREFDENAME, 13);
        fieldIndexMap.put(FIELD_LOGICHOLDER, 14);
        fieldIndexMap.put(FIELD_LOGICNAME, 15);
        fieldIndexMap.put(FIELD_MAPMODE, 16);
        fieldIndexMap.put(FIELD_MAPTARGET, 17);
        fieldIndexMap.put(FIELD_MEMO, 18);
        fieldIndexMap.put(FIELD_ORDERVALUE, 19);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 20);
        fieldIndexMap.put(FIELD_PSDEID, 21);
        fieldIndexMap.put(FIELD_PSDEMAPID, 22);
        fieldIndexMap.put(FIELD_PSDEMAPNAME, 23);
        fieldIndexMap.put(FIELD_PSDENAME, 24);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELID, 25);
        fieldIndexMap.put(FIELD_PSSYSDYNAMODELNAME, 26);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINID, 27);
        fieldIndexMap.put(FIELD_PSSYSPFPLUGINNAME, 28);
        fieldIndexMap.put(FIELD_PSSYSREFID, 29);
        fieldIndexMap.put(FIELD_PSSYSREFNAME, 30);
        fieldIndexMap.put(FIELD_PSSYSREQITEMID, 31);
        fieldIndexMap.put(FIELD_PSSYSREQITEMNAME, 32);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 33);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 34);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 35);
        fieldIndexMap.put(FIELD_UPDATEDATE, 36);
        fieldIndexMap.put(FIELD_UPDATEMAN, 37);
        fieldIndexMap.put(FIELD_USERCAT, 38);
        fieldIndexMap.put(FIELD_USERTAG, 39);
        fieldIndexMap.put(FIELD_USERTAG2, 40);
        fieldIndexMap.put(FIELD_USERTAG3, 41);
        fieldIndexMap.put(FIELD_USERTAG4, 42);
        fieldIndexMap.put(FIELD_VALIDFLAG, 43);
    }
}

