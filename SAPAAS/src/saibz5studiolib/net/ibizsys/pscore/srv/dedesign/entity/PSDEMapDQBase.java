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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataQuery;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataQueryService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDQBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMapDQBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSDEDATAQUERYID = "DSTPSDEDATAQUERYID";
    public static final String FIELD_DSTPSDEDATAQUERYNAME = "DSTPSDEDATAQUERYNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_ENABLEDQCOND = "ENABLEDQCOND";
    public static final String FIELD_MAPMODE = "MAPMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEDATAQUERYID = "PSDEDATAQUERYID";
    public static final String FIELD_PSDEDATAQUERYNAME = "PSDEDATAQUERYNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAPDQID = "PSDEMAPDQID";
    public static final String FIELD_PSDEMAPDQNAME = "PSDEMAPDQNAME";
    public static final String FIELD_PSDEMAPID = "PSDEMAPID";
    public static final String FIELD_PSDEMAPNAME = "PSDEMAPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_DSTPSDEDATAQUERYID = 2;
    private static final int INDEX_DSTPSDEDATAQUERYNAME = 3;
    private static final int INDEX_DSTPSDEID = 4;
    private static final int INDEX_ENABLEDQCOND = 5;
    private static final int INDEX_MAPMODE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PROPERTYMAP = 8;
    private static final int INDEX_PSDEDATAQUERYID = 9;
    private static final int INDEX_PSDEDATAQUERYNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDEMAPDQID = 12;
    private static final int INDEX_PSDEMAPDQNAME = 13;
    private static final int INDEX_PSDEMAPID = 14;
    private static final int INDEX_PSDEMAPNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final int INDEX_VALIDFLAG = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMapDQBase proxyPSDEMapDQBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsdedataqueryidDirtyFlag = false;
    private boolean dstpsdedataquerynameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean enabledqcondDirtyFlag = false;
    private boolean mapmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdedataqueryidDirtyFlag = false;
    private boolean psdedataquerynameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemapdqidDirtyFlag = false;
    private boolean psdemapdqnameDirtyFlag = false;
    private boolean psdemapidDirtyFlag = false;
    private boolean psdemapnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dstpsdedataqueryid")
    private String dstpsdedataqueryid;
    @Column(name="dstpsdedataqueryname")
    private String dstpsdedataqueryname;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="enabledqcond")
    private Integer enabledqcond;
    @Column(name="mapmode")
    private String mapmode;
    @Column(name="memo")
    private String memo;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdedataqueryid")
    private String psdedataqueryid;
    @Column(name="psdedataqueryname")
    private String psdedataqueryname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemapdqid")
    private String psdemapdqid;
    @Column(name="psdemapdqname")
    private String psdemapdqname;
    @Column(name="psdemapid")
    private String psdemapid;
    @Column(name="psdemapname")
    private String psdemapname;
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
    private Integer objDstPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery dstpsdedataquery = null;
    private Integer objPSDEDataQueryLock = new Integer(1);
    private PSDEDataQuery psdedataquery = null;
    private Integer objPSDEMapLock = new Integer(1);
    private PSDEMap psdemap = null;

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

    public void setDstPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryid = string;
        this.dstpsdedataqueryidDirtyFlag = true;
    }

    public String getDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryId();
        }
        return this.dstpsdedataqueryid;
    }

    public boolean isDstPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryIdDirty();
        }
        return this.dstpsdedataqueryidDirtyFlag;
    }

    public void resetDstPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryId();
            return;
        }
        this.dstpsdedataqueryidDirtyFlag = false;
        this.dstpsdedataqueryid = null;
    }

    public void setDstPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedataqueryname = string;
        this.dstpsdedataquerynameDirtyFlag = true;
    }

    public String getDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQueryName();
        }
        return this.dstpsdedataqueryname;
    }

    public boolean isDstPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataQueryNameDirty();
        }
        return this.dstpsdedataquerynameDirtyFlag;
    }

    public void resetDstPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataQueryName();
            return;
        }
        this.dstpsdedataquerynameDirtyFlag = false;
        this.dstpsdedataqueryname = null;
    }

    public void setDstPSDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeid = string;
        this.dstpsdeidDirtyFlag = true;
    }

    public String getDstPSDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEId();
        }
        return this.dstpsdeid;
    }

    public boolean isDstPSDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEIdDirty();
        }
        return this.dstpsdeidDirtyFlag;
    }

    public void resetDstPSDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEId();
            return;
        }
        this.dstpsdeidDirtyFlag = false;
        this.dstpsdeid = null;
    }

    public void setEnableDQCond(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableDQCond(n);
            return;
        }
        this.enabledqcond = n;
        this.enabledqcondDirtyFlag = true;
    }

    public Integer getEnableDQCond() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableDQCond();
        }
        return this.enabledqcond;
    }

    public boolean isEnableDQCondDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableDQCondDirty();
        }
        return this.enabledqcondDirtyFlag;
    }

    public void resetEnableDQCond() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableDQCond();
            return;
        }
        this.enabledqcondDirtyFlag = false;
        this.enabledqcond = null;
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

    public void setPSDEDataQueryId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryid = string;
        this.psdedataqueryidDirtyFlag = true;
    }

    public String getPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryId();
        }
        return this.psdedataqueryid;
    }

    public boolean isPSDEDataQueryIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryIdDirty();
        }
        return this.psdedataqueryidDirtyFlag;
    }

    public void resetPSDEDataQueryId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryId();
            return;
        }
        this.psdedataqueryidDirtyFlag = false;
        this.psdedataqueryid = null;
    }

    public void setPSDEDataQueryName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEDataQueryName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdedataqueryname = string;
        this.psdedataquerynameDirtyFlag = true;
    }

    public String getPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQueryName();
        }
        return this.psdedataqueryname;
    }

    public boolean isPSDEDataQueryNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEDataQueryNameDirty();
        }
        return this.psdedataquerynameDirtyFlag;
    }

    public void resetPSDEDataQueryName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEDataQueryName();
            return;
        }
        this.psdedataquerynameDirtyFlag = false;
        this.psdedataqueryname = null;
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

    public void setPSDEMapDQId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDQId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdqid = string;
        this.psdemapdqidDirtyFlag = true;
    }

    public String getPSDEMapDQId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDQId();
        }
        return this.psdemapdqid;
    }

    public boolean isPSDEMapDQIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDQIdDirty();
        }
        return this.psdemapdqidDirtyFlag;
    }

    public void resetPSDEMapDQId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDQId();
            return;
        }
        this.psdemapdqidDirtyFlag = false;
        this.psdemapdqid = null;
    }

    public void setPSDEMapDQName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDQName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdqname = string;
        this.psdemapdqnameDirtyFlag = true;
    }

    public String getPSDEMapDQName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDQName();
        }
        return this.psdemapdqname;
    }

    public boolean isPSDEMapDQNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDQNameDirty();
        }
        return this.psdemapdqnameDirtyFlag;
    }

    public void resetPSDEMapDQName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDQName();
            return;
        }
        this.psdemapdqnameDirtyFlag = false;
        this.psdemapdqname = null;
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
        PSDEMapDQBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMapDQBase pSDEMapDQBase) {
        pSDEMapDQBase.resetCreateDate();
        pSDEMapDQBase.resetCreateMan();
        pSDEMapDQBase.resetDstPSDEDataQueryId();
        pSDEMapDQBase.resetDstPSDEDataQueryName();
        pSDEMapDQBase.resetDstPSDEId();
        pSDEMapDQBase.resetEnableDQCond();
        pSDEMapDQBase.resetMapMode();
        pSDEMapDQBase.resetMemo();
        pSDEMapDQBase.resetPropertyMap();
        pSDEMapDQBase.resetPSDEDataQueryId();
        pSDEMapDQBase.resetPSDEDataQueryName();
        pSDEMapDQBase.resetPSDEId();
        pSDEMapDQBase.resetPSDEMapDQId();
        pSDEMapDQBase.resetPSDEMapDQName();
        pSDEMapDQBase.resetPSDEMapId();
        pSDEMapDQBase.resetPSDEMapName();
        pSDEMapDQBase.resetUpdateDate();
        pSDEMapDQBase.resetUpdateMan();
        pSDEMapDQBase.resetUserCat();
        pSDEMapDQBase.resetUserTag();
        pSDEMapDQBase.resetUserTag2();
        pSDEMapDQBase.resetUserTag3();
        pSDEMapDQBase.resetUserTag4();
        pSDEMapDQBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYID, this.getDstPSDEDataQueryId());
        }
        if (!bl || this.isDstPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATAQUERYNAME, this.getDstPSDEDataQueryName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
        }
        if (!bl || this.isEnableDQCondDirty()) {
            hashMap.put(FIELD_ENABLEDQCOND, this.getEnableDQCond());
        }
        if (!bl || this.isMapModeDirty()) {
            hashMap.put(FIELD_MAPMODE, this.getMapMode());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPropertyMapDirty()) {
            hashMap.put(FIELD_PROPERTYMAP, this.getPropertyMap());
        }
        if (!bl || this.isPSDEDataQueryIdDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYID, this.getPSDEDataQueryId());
        }
        if (!bl || this.isPSDEDataQueryNameDirty()) {
            hashMap.put(FIELD_PSDEDATAQUERYNAME, this.getPSDEDataQueryName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMapDQIdDirty()) {
            hashMap.put(FIELD_PSDEMAPDQID, this.getPSDEMapDQId());
        }
        if (!bl || this.isPSDEMapDQNameDirty()) {
            hashMap.put(FIELD_PSDEMAPDQNAME, this.getPSDEMapDQName());
        }
        if (!bl || this.isPSDEMapIdDirty()) {
            hashMap.put(FIELD_PSDEMAPID, this.getPSDEMapId());
        }
        if (!bl || this.isPSDEMapNameDirty()) {
            hashMap.put(FIELD_PSDEMAPNAME, this.getPSDEMapName());
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
        return PSDEMapDQBase.get(this, n);
    }

    private static Object get(PSDEMapDQBase pSDEMapDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDQBase.getCreateDate();
            }
            case 1: {
                return pSDEMapDQBase.getCreateMan();
            }
            case 2: {
                return pSDEMapDQBase.getDstPSDEDataQueryId();
            }
            case 3: {
                return pSDEMapDQBase.getDstPSDEDataQueryName();
            }
            case 4: {
                return pSDEMapDQBase.getDstPSDEId();
            }
            case 5: {
                return pSDEMapDQBase.getEnableDQCond();
            }
            case 6: {
                return pSDEMapDQBase.getMapMode();
            }
            case 7: {
                return pSDEMapDQBase.getMemo();
            }
            case 8: {
                return pSDEMapDQBase.getPropertyMap();
            }
            case 9: {
                return pSDEMapDQBase.getPSDEDataQueryId();
            }
            case 10: {
                return pSDEMapDQBase.getPSDEDataQueryName();
            }
            case 11: {
                return pSDEMapDQBase.getPSDEId();
            }
            case 12: {
                return pSDEMapDQBase.getPSDEMapDQId();
            }
            case 13: {
                return pSDEMapDQBase.getPSDEMapDQName();
            }
            case 14: {
                return pSDEMapDQBase.getPSDEMapId();
            }
            case 15: {
                return pSDEMapDQBase.getPSDEMapName();
            }
            case 16: {
                return pSDEMapDQBase.getUpdateDate();
            }
            case 17: {
                return pSDEMapDQBase.getUpdateMan();
            }
            case 18: {
                return pSDEMapDQBase.getUserCat();
            }
            case 19: {
                return pSDEMapDQBase.getUserTag();
            }
            case 20: {
                return pSDEMapDQBase.getUserTag2();
            }
            case 21: {
                return pSDEMapDQBase.getUserTag3();
            }
            case 22: {
                return pSDEMapDQBase.getUserTag4();
            }
            case 23: {
                return pSDEMapDQBase.getValidFlag();
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
        PSDEMapDQBase.set(this, n, object);
    }

    private static void set(PSDEMapDQBase pSDEMapDQBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDQBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMapDQBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMapDQBase.setDstPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMapDQBase.setDstPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMapDQBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMapDQBase.setEnableDQCond(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEMapDQBase.setMapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMapDQBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMapDQBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMapDQBase.setPSDEDataQueryId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMapDQBase.setPSDEDataQueryName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMapDQBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMapDQBase.setPSDEMapDQId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMapDQBase.setPSDEMapDQName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMapDQBase.setPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMapDQBase.setPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMapDQBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEMapDQBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMapDQBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMapDQBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEMapDQBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMapDQBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMapDQBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEMapDQBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMapDQBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMapDQBase pSDEMapDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDQBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMapDQBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMapDQBase.getDstPSDEDataQueryId() == null;
            }
            case 3: {
                return pSDEMapDQBase.getDstPSDEDataQueryName() == null;
            }
            case 4: {
                return pSDEMapDQBase.getDstPSDEId() == null;
            }
            case 5: {
                return pSDEMapDQBase.getEnableDQCond() == null;
            }
            case 6: {
                return pSDEMapDQBase.getMapMode() == null;
            }
            case 7: {
                return pSDEMapDQBase.getMemo() == null;
            }
            case 8: {
                return pSDEMapDQBase.getPropertyMap() == null;
            }
            case 9: {
                return pSDEMapDQBase.getPSDEDataQueryId() == null;
            }
            case 10: {
                return pSDEMapDQBase.getPSDEDataQueryName() == null;
            }
            case 11: {
                return pSDEMapDQBase.getPSDEId() == null;
            }
            case 12: {
                return pSDEMapDQBase.getPSDEMapDQId() == null;
            }
            case 13: {
                return pSDEMapDQBase.getPSDEMapDQName() == null;
            }
            case 14: {
                return pSDEMapDQBase.getPSDEMapId() == null;
            }
            case 15: {
                return pSDEMapDQBase.getPSDEMapName() == null;
            }
            case 16: {
                return pSDEMapDQBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDEMapDQBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDEMapDQBase.getUserCat() == null;
            }
            case 19: {
                return pSDEMapDQBase.getUserTag() == null;
            }
            case 20: {
                return pSDEMapDQBase.getUserTag2() == null;
            }
            case 21: {
                return pSDEMapDQBase.getUserTag3() == null;
            }
            case 22: {
                return pSDEMapDQBase.getUserTag4() == null;
            }
            case 23: {
                return pSDEMapDQBase.getValidFlag() == null;
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
        return PSDEMapDQBase.contains(this, n);
    }

    private static boolean contains(PSDEMapDQBase pSDEMapDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDQBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMapDQBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMapDQBase.isDstPSDEDataQueryIdDirty();
            }
            case 3: {
                return pSDEMapDQBase.isDstPSDEDataQueryNameDirty();
            }
            case 4: {
                return pSDEMapDQBase.isDstPSDEIdDirty();
            }
            case 5: {
                return pSDEMapDQBase.isEnableDQCondDirty();
            }
            case 6: {
                return pSDEMapDQBase.isMapModeDirty();
            }
            case 7: {
                return pSDEMapDQBase.isMemoDirty();
            }
            case 8: {
                return pSDEMapDQBase.isPropertyMapDirty();
            }
            case 9: {
                return pSDEMapDQBase.isPSDEDataQueryIdDirty();
            }
            case 10: {
                return pSDEMapDQBase.isPSDEDataQueryNameDirty();
            }
            case 11: {
                return pSDEMapDQBase.isPSDEIdDirty();
            }
            case 12: {
                return pSDEMapDQBase.isPSDEMapDQIdDirty();
            }
            case 13: {
                return pSDEMapDQBase.isPSDEMapDQNameDirty();
            }
            case 14: {
                return pSDEMapDQBase.isPSDEMapIdDirty();
            }
            case 15: {
                return pSDEMapDQBase.isPSDEMapNameDirty();
            }
            case 16: {
                return pSDEMapDQBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDEMapDQBase.isUpdateManDirty();
            }
            case 18: {
                return pSDEMapDQBase.isUserCatDirty();
            }
            case 19: {
                return pSDEMapDQBase.isUserTagDirty();
            }
            case 20: {
                return pSDEMapDQBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDEMapDQBase.isUserTag3Dirty();
            }
            case 22: {
                return pSDEMapDQBase.isUserTag4Dirty();
            }
            case 23: {
                return pSDEMapDQBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMapDQBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMapDQBase pSDEMapDQBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMapDQBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getDstPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getDstPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getDstPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedataqueryname", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getDstPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getEnableDQCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledqcond", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getEnableDQCond()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getMapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapmode", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getMapMode()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEDataQueryId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEDataQueryId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEDataQueryName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedataqueryname", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEDataQueryName()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEMapDQId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdqid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEMapDQId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEMapDQName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdqname", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEMapDQName()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapid", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEMapId()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapname", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getPSDEMapName()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMapDQBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMapDQBase.getJSONValue((Object)pSDEMapDQBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMapDQBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMapDQBase pSDEMapDQBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMapDQBase.getCreateDate() != null) {
            object = pSDEMapDQBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDQBase.getCreateMan() != null) {
            object = pSDEMapDQBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getDstPSDEDataQueryId() != null) {
            object = pSDEMapDQBase.getDstPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getDstPSDEDataQueryName() != null) {
            object = pSDEMapDQBase.getDstPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getDstPSDEId() != null) {
            object = pSDEMapDQBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getEnableDQCond() != null) {
            object = pSDEMapDQBase.getEnableDQCond();
            xmlNode.setAttribute(FIELD_ENABLEDQCOND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapDQBase.getMapMode() != null) {
            object = pSDEMapDQBase.getMapMode();
            xmlNode.setAttribute(FIELD_MAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getMemo() != null) {
            object = pSDEMapDQBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPropertyMap() != null) {
            object = pSDEMapDQBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEDataQueryId() != null) {
            object = pSDEMapDQBase.getPSDEDataQueryId();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEDataQueryName() != null) {
            object = pSDEMapDQBase.getPSDEDataQueryName();
            xmlNode.setAttribute(FIELD_PSDEDATAQUERYNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEId() != null) {
            object = pSDEMapDQBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEMapDQId() != null) {
            object = pSDEMapDQBase.getPSDEMapDQId();
            xmlNode.setAttribute(FIELD_PSDEMAPDQID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEMapDQName() != null) {
            object = pSDEMapDQBase.getPSDEMapDQName();
            xmlNode.setAttribute(FIELD_PSDEMAPDQNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEMapId() != null) {
            object = pSDEMapDQBase.getPSDEMapId();
            xmlNode.setAttribute(FIELD_PSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getPSDEMapName() != null) {
            object = pSDEMapDQBase.getPSDEMapName();
            xmlNode.setAttribute(FIELD_PSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUpdateDate() != null) {
            object = pSDEMapDQBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDQBase.getUpdateMan() != null) {
            object = pSDEMapDQBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUserCat() != null) {
            object = pSDEMapDQBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUserTag() != null) {
            object = pSDEMapDQBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUserTag2() != null) {
            object = pSDEMapDQBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUserTag3() != null) {
            object = pSDEMapDQBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getUserTag4() != null) {
            object = pSDEMapDQBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDQBase.getValidFlag() != null) {
            object = pSDEMapDQBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMapDQBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMapDQBase pSDEMapDQBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMapDQBase.isCreateDateDirty() && (bl || pSDEMapDQBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMapDQBase.getCreateDate());
        }
        if (pSDEMapDQBase.isCreateManDirty() && (bl || pSDEMapDQBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMapDQBase.getCreateMan());
        }
        if (pSDEMapDQBase.isDstPSDEDataQueryIdDirty() && (bl || pSDEMapDQBase.getDstPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYID, (Object)pSDEMapDQBase.getDstPSDEDataQueryId());
        }
        if (pSDEMapDQBase.isDstPSDEDataQueryNameDirty() && (bl || pSDEMapDQBase.getDstPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATAQUERYNAME, (Object)pSDEMapDQBase.getDstPSDEDataQueryName());
        }
        if (pSDEMapDQBase.isDstPSDEIdDirty() && (bl || pSDEMapDQBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEMapDQBase.getDstPSDEId());
        }
        if (pSDEMapDQBase.isEnableDQCondDirty() && (bl || pSDEMapDQBase.getEnableDQCond() != null)) {
            iDataObject.set(FIELD_ENABLEDQCOND, (Object)pSDEMapDQBase.getEnableDQCond());
        }
        if (pSDEMapDQBase.isMapModeDirty() && (bl || pSDEMapDQBase.getMapMode() != null)) {
            iDataObject.set(FIELD_MAPMODE, (Object)pSDEMapDQBase.getMapMode());
        }
        if (pSDEMapDQBase.isMemoDirty() && (bl || pSDEMapDQBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMapDQBase.getMemo());
        }
        if (pSDEMapDQBase.isPropertyMapDirty() && (bl || pSDEMapDQBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDEMapDQBase.getPropertyMap());
        }
        if (pSDEMapDQBase.isPSDEDataQueryIdDirty() && (bl || pSDEMapDQBase.getPSDEDataQueryId() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYID, (Object)pSDEMapDQBase.getPSDEDataQueryId());
        }
        if (pSDEMapDQBase.isPSDEDataQueryNameDirty() && (bl || pSDEMapDQBase.getPSDEDataQueryName() != null)) {
            iDataObject.set(FIELD_PSDEDATAQUERYNAME, (Object)pSDEMapDQBase.getPSDEDataQueryName());
        }
        if (pSDEMapDQBase.isPSDEIdDirty() && (bl || pSDEMapDQBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMapDQBase.getPSDEId());
        }
        if (pSDEMapDQBase.isPSDEMapDQIdDirty() && (bl || pSDEMapDQBase.getPSDEMapDQId() != null)) {
            iDataObject.set(FIELD_PSDEMAPDQID, (Object)pSDEMapDQBase.getPSDEMapDQId());
        }
        if (pSDEMapDQBase.isPSDEMapDQNameDirty() && (bl || pSDEMapDQBase.getPSDEMapDQName() != null)) {
            iDataObject.set(FIELD_PSDEMAPDQNAME, (Object)pSDEMapDQBase.getPSDEMapDQName());
        }
        if (pSDEMapDQBase.isPSDEMapIdDirty() && (bl || pSDEMapDQBase.getPSDEMapId() != null)) {
            iDataObject.set(FIELD_PSDEMAPID, (Object)pSDEMapDQBase.getPSDEMapId());
        }
        if (pSDEMapDQBase.isPSDEMapNameDirty() && (bl || pSDEMapDQBase.getPSDEMapName() != null)) {
            iDataObject.set(FIELD_PSDEMAPNAME, (Object)pSDEMapDQBase.getPSDEMapName());
        }
        if (pSDEMapDQBase.isUpdateDateDirty() && (bl || pSDEMapDQBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMapDQBase.getUpdateDate());
        }
        if (pSDEMapDQBase.isUpdateManDirty() && (bl || pSDEMapDQBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMapDQBase.getUpdateMan());
        }
        if (pSDEMapDQBase.isUserCatDirty() && (bl || pSDEMapDQBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMapDQBase.getUserCat());
        }
        if (pSDEMapDQBase.isUserTagDirty() && (bl || pSDEMapDQBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMapDQBase.getUserTag());
        }
        if (pSDEMapDQBase.isUserTag2Dirty() && (bl || pSDEMapDQBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMapDQBase.getUserTag2());
        }
        if (pSDEMapDQBase.isUserTag3Dirty() && (bl || pSDEMapDQBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMapDQBase.getUserTag3());
        }
        if (pSDEMapDQBase.isUserTag4Dirty() && (bl || pSDEMapDQBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMapDQBase.getUserTag4());
        }
        if (pSDEMapDQBase.isValidFlagDirty() && (bl || pSDEMapDQBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMapDQBase.getValidFlag());
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
        return PSDEMapDQBase.remove(this, n);
    }

    private static boolean remove(PSDEMapDQBase pSDEMapDQBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDQBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMapDQBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMapDQBase.resetDstPSDEDataQueryId();
                return true;
            }
            case 3: {
                pSDEMapDQBase.resetDstPSDEDataQueryName();
                return true;
            }
            case 4: {
                pSDEMapDQBase.resetDstPSDEId();
                return true;
            }
            case 5: {
                pSDEMapDQBase.resetEnableDQCond();
                return true;
            }
            case 6: {
                pSDEMapDQBase.resetMapMode();
                return true;
            }
            case 7: {
                pSDEMapDQBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEMapDQBase.resetPropertyMap();
                return true;
            }
            case 9: {
                pSDEMapDQBase.resetPSDEDataQueryId();
                return true;
            }
            case 10: {
                pSDEMapDQBase.resetPSDEDataQueryName();
                return true;
            }
            case 11: {
                pSDEMapDQBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSDEMapDQBase.resetPSDEMapDQId();
                return true;
            }
            case 13: {
                pSDEMapDQBase.resetPSDEMapDQName();
                return true;
            }
            case 14: {
                pSDEMapDQBase.resetPSDEMapId();
                return true;
            }
            case 15: {
                pSDEMapDQBase.resetPSDEMapName();
                return true;
            }
            case 16: {
                pSDEMapDQBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDEMapDQBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDEMapDQBase.resetUserCat();
                return true;
            }
            case 19: {
                pSDEMapDQBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDEMapDQBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDEMapDQBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSDEMapDQBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSDEMapDQBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getDstPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataQuery();
        }
        if (this.getDstPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataQueryLock;
        synchronized (n) {
            if (this.dstpsdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataQueryId(), (Object)this.dstpsdedataquery.getPSDEDataQueryId()) != 0L) {
                this.dstpsdedataquery = null;
            }
            if (this.dstpsdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getDstPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.dstpsdedataquery = pSDEDataQuery;
            }
            return this.dstpsdedataquery;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataQuery getPSDEDataQuery() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEDataQuery();
        }
        if (this.getPSDEDataQueryId() == null) {
            return null;
        }
        Integer n = this.objPSDEDataQueryLock;
        synchronized (n) {
            if (this.psdedataquery != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEDataQueryId(), (Object)this.psdedataquery.getPSDEDataQueryId()) != 0L) {
                this.psdedataquery = null;
            }
            if (this.psdedataquery == null) {
                PSDEDataQuery pSDEDataQuery = new PSDEDataQuery();
                pSDEDataQuery.setPSDEDataQueryId(this.getPSDEDataQueryId());
                PSDEDataQueryService pSDEDataQueryService = (PSDEDataQueryService)ServiceGlobal.getService(PSDEDataQueryService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataQueryService.autoGet((IEntity)pSDEDataQuery);
                this.psdedataquery = pSDEDataQuery;
            }
            return this.psdedataquery;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEMap getPSDEMap() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMap();
        }
        if (this.getPSDEMapId() == null) {
            return null;
        }
        Integer n = this.objPSDEMapLock;
        synchronized (n) {
            if (this.psdemap != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEMapId(), (Object)this.psdemap.getPSDEMapId()) != 0L) {
                this.psdemap = null;
            }
            if (this.psdemap == null) {
                PSDEMap pSDEMap = new PSDEMap();
                pSDEMap.setPSDEMapId(this.getPSDEMapId());
                PSDEMapService pSDEMapService = (PSDEMapService)ServiceGlobal.getService(PSDEMapService.class, (SessionFactory)this.getSessionFactory());
                pSDEMapService.autoGet((IEntity)pSDEMap);
                this.psdemap = pSDEMap;
            }
            return this.psdemap;
        }
    }

    private PSDEMapDQBase getProxyEntity() {
        return this.proxyPSDEMapDQBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMapDQBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMapDQBase) {
            this.proxyPSDEMapDQBase = (PSDEMapDQBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapDQService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYID, 2);
        fieldIndexMap.put(FIELD_DSTPSDEDATAQUERYNAME, 3);
        fieldIndexMap.put(FIELD_DSTPSDEID, 4);
        fieldIndexMap.put(FIELD_ENABLEDQCOND, 5);
        fieldIndexMap.put(FIELD_MAPMODE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 8);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYID, 9);
        fieldIndexMap.put(FIELD_PSDEDATAQUERYNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEMAPDQID, 12);
        fieldIndexMap.put(FIELD_PSDEMAPDQNAME, 13);
        fieldIndexMap.put(FIELD_PSDEMAPID, 14);
        fieldIndexMap.put(FIELD_PSDEMAPNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
        fieldIndexMap.put(FIELD_VALIDFLAG, 23);
    }
}

