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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEDataSet;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEDataSetService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapDSBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMapDSBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSDEDATASETID = "DSTPSDEDATASETID";
    public static final String FIELD_DSTPSDEDATASETNAME = "DSTPSDEDATASETNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_ENABLEDQCOND = "ENABLEDQCOND";
    public static final String FIELD_MAPMODE = "MAPMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEDATASETID = "PSDEDATASETID";
    public static final String FIELD_PSDEDATASETNAME = "PSDEDATASETNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAPDSID = "PSDEMAPDSID";
    public static final String FIELD_PSDEMAPDSNAME = "PSDEMAPDSNAME";
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
    private static final int INDEX_DSTPSDEDATASETID = 2;
    private static final int INDEX_DSTPSDEDATASETNAME = 3;
    private static final int INDEX_DSTPSDEID = 4;
    private static final int INDEX_ENABLEDQCOND = 5;
    private static final int INDEX_MAPMODE = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_PROPERTYMAP = 8;
    private static final int INDEX_PSDEDATASETID = 9;
    private static final int INDEX_PSDEDATASETNAME = 10;
    private static final int INDEX_PSDEID = 11;
    private static final int INDEX_PSDEMAPDSID = 12;
    private static final int INDEX_PSDEMAPDSNAME = 13;
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
    private PSDEMapDSBase proxyPSDEMapDSBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsdedatasetidDirtyFlag = false;
    private boolean dstpsdedatasetnameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean enabledqcondDirtyFlag = false;
    private boolean mapmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdedatasetidDirtyFlag = false;
    private boolean psdedatasetnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemapdsidDirtyFlag = false;
    private boolean psdemapdsnameDirtyFlag = false;
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
    @Column(name="dstpsdedatasetid")
    private String dstpsdedatasetid;
    @Column(name="dstpsdedatasetname")
    private String dstpsdedatasetname;
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
    @Column(name="psdedatasetid")
    private String psdedatasetid;
    @Column(name="psdedatasetname")
    private String psdedatasetname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemapdsid")
    private String psdemapdsid;
    @Column(name="psdemapdsname")
    private String psdemapdsname;
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
    private Integer objDstPSDEDataSetLock = new Integer(1);
    private PSDEDataSet dstpsdedataset = null;
    private Integer objPSDEDataSetLock = new Integer(1);
    private PSDEDataSet psdedataset = null;
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

    public void setDstPSDEDataSetId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetid = string;
        this.dstpsdedatasetidDirtyFlag = true;
    }

    public String getDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetId();
        }
        return this.dstpsdedatasetid;
    }

    public boolean isDstPSDEDataSetIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetIdDirty();
        }
        return this.dstpsdedatasetidDirtyFlag;
    }

    public void resetDstPSDEDataSetId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetId();
            return;
        }
        this.dstpsdedatasetidDirtyFlag = false;
        this.dstpsdedatasetid = null;
    }

    public void setDstPSDEDataSetName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEDataSetName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdedatasetname = string;
        this.dstpsdedatasetnameDirtyFlag = true;
    }

    public String getDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSetName();
        }
        return this.dstpsdedatasetname;
    }

    public boolean isDstPSDEDataSetNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEDataSetNameDirty();
        }
        return this.dstpsdedatasetnameDirtyFlag;
    }

    public void resetDstPSDEDataSetName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEDataSetName();
            return;
        }
        this.dstpsdedatasetnameDirtyFlag = false;
        this.dstpsdedatasetname = null;
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

    public void setPSDEMapDSId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDSId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdsid = string;
        this.psdemapdsidDirtyFlag = true;
    }

    public String getPSDEMapDSId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDSId();
        }
        return this.psdemapdsid;
    }

    public boolean isPSDEMapDSIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDSIdDirty();
        }
        return this.psdemapdsidDirtyFlag;
    }

    public void resetPSDEMapDSId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDSId();
            return;
        }
        this.psdemapdsidDirtyFlag = false;
        this.psdemapdsid = null;
    }

    public void setPSDEMapDSName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapDSName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapdsname = string;
        this.psdemapdsnameDirtyFlag = true;
    }

    public String getPSDEMapDSName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapDSName();
        }
        return this.psdemapdsname;
    }

    public boolean isPSDEMapDSNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapDSNameDirty();
        }
        return this.psdemapdsnameDirtyFlag;
    }

    public void resetPSDEMapDSName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapDSName();
            return;
        }
        this.psdemapdsnameDirtyFlag = false;
        this.psdemapdsname = null;
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
        PSDEMapDSBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMapDSBase pSDEMapDSBase) {
        pSDEMapDSBase.resetCreateDate();
        pSDEMapDSBase.resetCreateMan();
        pSDEMapDSBase.resetDstPSDEDataSetId();
        pSDEMapDSBase.resetDstPSDEDataSetName();
        pSDEMapDSBase.resetDstPSDEId();
        pSDEMapDSBase.resetEnableDQCond();
        pSDEMapDSBase.resetMapMode();
        pSDEMapDSBase.resetMemo();
        pSDEMapDSBase.resetPropertyMap();
        pSDEMapDSBase.resetPSDEDataSetId();
        pSDEMapDSBase.resetPSDEDataSetName();
        pSDEMapDSBase.resetPSDEId();
        pSDEMapDSBase.resetPSDEMapDSId();
        pSDEMapDSBase.resetPSDEMapDSName();
        pSDEMapDSBase.resetPSDEMapId();
        pSDEMapDSBase.resetPSDEMapName();
        pSDEMapDSBase.resetUpdateDate();
        pSDEMapDSBase.resetUpdateMan();
        pSDEMapDSBase.resetUserCat();
        pSDEMapDSBase.resetUserTag();
        pSDEMapDSBase.resetUserTag2();
        pSDEMapDSBase.resetUserTag3();
        pSDEMapDSBase.resetUserTag4();
        pSDEMapDSBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETID, this.getDstPSDEDataSetId());
        }
        if (!bl || this.isDstPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_DSTPSDEDATASETNAME, this.getDstPSDEDataSetName());
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
        if (!bl || this.isPSDEDataSetIdDirty()) {
            hashMap.put(FIELD_PSDEDATASETID, this.getPSDEDataSetId());
        }
        if (!bl || this.isPSDEDataSetNameDirty()) {
            hashMap.put(FIELD_PSDEDATASETNAME, this.getPSDEDataSetName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMapDSIdDirty()) {
            hashMap.put(FIELD_PSDEMAPDSID, this.getPSDEMapDSId());
        }
        if (!bl || this.isPSDEMapDSNameDirty()) {
            hashMap.put(FIELD_PSDEMAPDSNAME, this.getPSDEMapDSName());
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
        return PSDEMapDSBase.get(this, n);
    }

    private static Object get(PSDEMapDSBase pSDEMapDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDSBase.getCreateDate();
            }
            case 1: {
                return pSDEMapDSBase.getCreateMan();
            }
            case 2: {
                return pSDEMapDSBase.getDstPSDEDataSetId();
            }
            case 3: {
                return pSDEMapDSBase.getDstPSDEDataSetName();
            }
            case 4: {
                return pSDEMapDSBase.getDstPSDEId();
            }
            case 5: {
                return pSDEMapDSBase.getEnableDQCond();
            }
            case 6: {
                return pSDEMapDSBase.getMapMode();
            }
            case 7: {
                return pSDEMapDSBase.getMemo();
            }
            case 8: {
                return pSDEMapDSBase.getPropertyMap();
            }
            case 9: {
                return pSDEMapDSBase.getPSDEDataSetId();
            }
            case 10: {
                return pSDEMapDSBase.getPSDEDataSetName();
            }
            case 11: {
                return pSDEMapDSBase.getPSDEId();
            }
            case 12: {
                return pSDEMapDSBase.getPSDEMapDSId();
            }
            case 13: {
                return pSDEMapDSBase.getPSDEMapDSName();
            }
            case 14: {
                return pSDEMapDSBase.getPSDEMapId();
            }
            case 15: {
                return pSDEMapDSBase.getPSDEMapName();
            }
            case 16: {
                return pSDEMapDSBase.getUpdateDate();
            }
            case 17: {
                return pSDEMapDSBase.getUpdateMan();
            }
            case 18: {
                return pSDEMapDSBase.getUserCat();
            }
            case 19: {
                return pSDEMapDSBase.getUserTag();
            }
            case 20: {
                return pSDEMapDSBase.getUserTag2();
            }
            case 21: {
                return pSDEMapDSBase.getUserTag3();
            }
            case 22: {
                return pSDEMapDSBase.getUserTag4();
            }
            case 23: {
                return pSDEMapDSBase.getValidFlag();
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
        PSDEMapDSBase.set(this, n, object);
    }

    private static void set(PSDEMapDSBase pSDEMapDSBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDSBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMapDSBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMapDSBase.setDstPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMapDSBase.setDstPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMapDSBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMapDSBase.setEnableDQCond(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSDEMapDSBase.setMapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMapDSBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMapDSBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMapDSBase.setPSDEDataSetId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMapDSBase.setPSDEDataSetName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMapDSBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMapDSBase.setPSDEMapDSId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMapDSBase.setPSDEMapDSName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMapDSBase.setPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMapDSBase.setPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEMapDSBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSDEMapDSBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMapDSBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMapDSBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEMapDSBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMapDSBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMapDSBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEMapDSBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMapDSBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMapDSBase pSDEMapDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDSBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMapDSBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMapDSBase.getDstPSDEDataSetId() == null;
            }
            case 3: {
                return pSDEMapDSBase.getDstPSDEDataSetName() == null;
            }
            case 4: {
                return pSDEMapDSBase.getDstPSDEId() == null;
            }
            case 5: {
                return pSDEMapDSBase.getEnableDQCond() == null;
            }
            case 6: {
                return pSDEMapDSBase.getMapMode() == null;
            }
            case 7: {
                return pSDEMapDSBase.getMemo() == null;
            }
            case 8: {
                return pSDEMapDSBase.getPropertyMap() == null;
            }
            case 9: {
                return pSDEMapDSBase.getPSDEDataSetId() == null;
            }
            case 10: {
                return pSDEMapDSBase.getPSDEDataSetName() == null;
            }
            case 11: {
                return pSDEMapDSBase.getPSDEId() == null;
            }
            case 12: {
                return pSDEMapDSBase.getPSDEMapDSId() == null;
            }
            case 13: {
                return pSDEMapDSBase.getPSDEMapDSName() == null;
            }
            case 14: {
                return pSDEMapDSBase.getPSDEMapId() == null;
            }
            case 15: {
                return pSDEMapDSBase.getPSDEMapName() == null;
            }
            case 16: {
                return pSDEMapDSBase.getUpdateDate() == null;
            }
            case 17: {
                return pSDEMapDSBase.getUpdateMan() == null;
            }
            case 18: {
                return pSDEMapDSBase.getUserCat() == null;
            }
            case 19: {
                return pSDEMapDSBase.getUserTag() == null;
            }
            case 20: {
                return pSDEMapDSBase.getUserTag2() == null;
            }
            case 21: {
                return pSDEMapDSBase.getUserTag3() == null;
            }
            case 22: {
                return pSDEMapDSBase.getUserTag4() == null;
            }
            case 23: {
                return pSDEMapDSBase.getValidFlag() == null;
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
        return PSDEMapDSBase.contains(this, n);
    }

    private static boolean contains(PSDEMapDSBase pSDEMapDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapDSBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMapDSBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMapDSBase.isDstPSDEDataSetIdDirty();
            }
            case 3: {
                return pSDEMapDSBase.isDstPSDEDataSetNameDirty();
            }
            case 4: {
                return pSDEMapDSBase.isDstPSDEIdDirty();
            }
            case 5: {
                return pSDEMapDSBase.isEnableDQCondDirty();
            }
            case 6: {
                return pSDEMapDSBase.isMapModeDirty();
            }
            case 7: {
                return pSDEMapDSBase.isMemoDirty();
            }
            case 8: {
                return pSDEMapDSBase.isPropertyMapDirty();
            }
            case 9: {
                return pSDEMapDSBase.isPSDEDataSetIdDirty();
            }
            case 10: {
                return pSDEMapDSBase.isPSDEDataSetNameDirty();
            }
            case 11: {
                return pSDEMapDSBase.isPSDEIdDirty();
            }
            case 12: {
                return pSDEMapDSBase.isPSDEMapDSIdDirty();
            }
            case 13: {
                return pSDEMapDSBase.isPSDEMapDSNameDirty();
            }
            case 14: {
                return pSDEMapDSBase.isPSDEMapIdDirty();
            }
            case 15: {
                return pSDEMapDSBase.isPSDEMapNameDirty();
            }
            case 16: {
                return pSDEMapDSBase.isUpdateDateDirty();
            }
            case 17: {
                return pSDEMapDSBase.isUpdateManDirty();
            }
            case 18: {
                return pSDEMapDSBase.isUserCatDirty();
            }
            case 19: {
                return pSDEMapDSBase.isUserTagDirty();
            }
            case 20: {
                return pSDEMapDSBase.isUserTag2Dirty();
            }
            case 21: {
                return pSDEMapDSBase.isUserTag3Dirty();
            }
            case 22: {
                return pSDEMapDSBase.isUserTag4Dirty();
            }
            case 23: {
                return pSDEMapDSBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMapDSBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMapDSBase pSDEMapDSBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMapDSBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getDstPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getDstPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getDstPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdedatasetname", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getDstPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getEnableDQCond() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enabledqcond", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getEnableDQCond()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getMapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapmode", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getMapMode()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEDataSetId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEDataSetId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEDataSetName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdedatasetname", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEDataSetName()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEMapDSId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdsid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEMapDSId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEMapDSName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapdsname", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEMapDSName()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapid", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEMapId()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapname", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getPSDEMapName()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMapDSBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMapDSBase.getJSONValue((Object)pSDEMapDSBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMapDSBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMapDSBase pSDEMapDSBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMapDSBase.getCreateDate() != null) {
            object = pSDEMapDSBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDSBase.getCreateMan() != null) {
            object = pSDEMapDSBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getDstPSDEDataSetId() != null) {
            object = pSDEMapDSBase.getDstPSDEDataSetId();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getDstPSDEDataSetName() != null) {
            object = pSDEMapDSBase.getDstPSDEDataSetName();
            xmlNode.setAttribute(FIELD_DSTPSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getDstPSDEId() != null) {
            object = pSDEMapDSBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getEnableDQCond() != null) {
            object = pSDEMapDSBase.getEnableDQCond();
            xmlNode.setAttribute(FIELD_ENABLEDQCOND, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSDEMapDSBase.getMapMode() != null) {
            object = pSDEMapDSBase.getMapMode();
            xmlNode.setAttribute(FIELD_MAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getMemo() != null) {
            object = pSDEMapDSBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPropertyMap() != null) {
            object = pSDEMapDSBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEDataSetId() != null) {
            object = pSDEMapDSBase.getPSDEDataSetId();
            xmlNode.setAttribute(FIELD_PSDEDATASETID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEDataSetName() != null) {
            object = pSDEMapDSBase.getPSDEDataSetName();
            xmlNode.setAttribute(FIELD_PSDEDATASETNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEId() != null) {
            object = pSDEMapDSBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEMapDSId() != null) {
            object = pSDEMapDSBase.getPSDEMapDSId();
            xmlNode.setAttribute(FIELD_PSDEMAPDSID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEMapDSName() != null) {
            object = pSDEMapDSBase.getPSDEMapDSName();
            xmlNode.setAttribute(FIELD_PSDEMAPDSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEMapId() != null) {
            object = pSDEMapDSBase.getPSDEMapId();
            xmlNode.setAttribute(FIELD_PSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getPSDEMapName() != null) {
            object = pSDEMapDSBase.getPSDEMapName();
            xmlNode.setAttribute(FIELD_PSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUpdateDate() != null) {
            object = pSDEMapDSBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapDSBase.getUpdateMan() != null) {
            object = pSDEMapDSBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUserCat() != null) {
            object = pSDEMapDSBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUserTag() != null) {
            object = pSDEMapDSBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUserTag2() != null) {
            object = pSDEMapDSBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUserTag3() != null) {
            object = pSDEMapDSBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getUserTag4() != null) {
            object = pSDEMapDSBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapDSBase.getValidFlag() != null) {
            object = pSDEMapDSBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMapDSBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMapDSBase pSDEMapDSBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMapDSBase.isCreateDateDirty() && (bl || pSDEMapDSBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMapDSBase.getCreateDate());
        }
        if (pSDEMapDSBase.isCreateManDirty() && (bl || pSDEMapDSBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMapDSBase.getCreateMan());
        }
        if (pSDEMapDSBase.isDstPSDEDataSetIdDirty() && (bl || pSDEMapDSBase.getDstPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETID, (Object)pSDEMapDSBase.getDstPSDEDataSetId());
        }
        if (pSDEMapDSBase.isDstPSDEDataSetNameDirty() && (bl || pSDEMapDSBase.getDstPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_DSTPSDEDATASETNAME, (Object)pSDEMapDSBase.getDstPSDEDataSetName());
        }
        if (pSDEMapDSBase.isDstPSDEIdDirty() && (bl || pSDEMapDSBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEMapDSBase.getDstPSDEId());
        }
        if (pSDEMapDSBase.isEnableDQCondDirty() && (bl || pSDEMapDSBase.getEnableDQCond() != null)) {
            iDataObject.set(FIELD_ENABLEDQCOND, (Object)pSDEMapDSBase.getEnableDQCond());
        }
        if (pSDEMapDSBase.isMapModeDirty() && (bl || pSDEMapDSBase.getMapMode() != null)) {
            iDataObject.set(FIELD_MAPMODE, (Object)pSDEMapDSBase.getMapMode());
        }
        if (pSDEMapDSBase.isMemoDirty() && (bl || pSDEMapDSBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMapDSBase.getMemo());
        }
        if (pSDEMapDSBase.isPropertyMapDirty() && (bl || pSDEMapDSBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDEMapDSBase.getPropertyMap());
        }
        if (pSDEMapDSBase.isPSDEDataSetIdDirty() && (bl || pSDEMapDSBase.getPSDEDataSetId() != null)) {
            iDataObject.set(FIELD_PSDEDATASETID, (Object)pSDEMapDSBase.getPSDEDataSetId());
        }
        if (pSDEMapDSBase.isPSDEDataSetNameDirty() && (bl || pSDEMapDSBase.getPSDEDataSetName() != null)) {
            iDataObject.set(FIELD_PSDEDATASETNAME, (Object)pSDEMapDSBase.getPSDEDataSetName());
        }
        if (pSDEMapDSBase.isPSDEIdDirty() && (bl || pSDEMapDSBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMapDSBase.getPSDEId());
        }
        if (pSDEMapDSBase.isPSDEMapDSIdDirty() && (bl || pSDEMapDSBase.getPSDEMapDSId() != null)) {
            iDataObject.set(FIELD_PSDEMAPDSID, (Object)pSDEMapDSBase.getPSDEMapDSId());
        }
        if (pSDEMapDSBase.isPSDEMapDSNameDirty() && (bl || pSDEMapDSBase.getPSDEMapDSName() != null)) {
            iDataObject.set(FIELD_PSDEMAPDSNAME, (Object)pSDEMapDSBase.getPSDEMapDSName());
        }
        if (pSDEMapDSBase.isPSDEMapIdDirty() && (bl || pSDEMapDSBase.getPSDEMapId() != null)) {
            iDataObject.set(FIELD_PSDEMAPID, (Object)pSDEMapDSBase.getPSDEMapId());
        }
        if (pSDEMapDSBase.isPSDEMapNameDirty() && (bl || pSDEMapDSBase.getPSDEMapName() != null)) {
            iDataObject.set(FIELD_PSDEMAPNAME, (Object)pSDEMapDSBase.getPSDEMapName());
        }
        if (pSDEMapDSBase.isUpdateDateDirty() && (bl || pSDEMapDSBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMapDSBase.getUpdateDate());
        }
        if (pSDEMapDSBase.isUpdateManDirty() && (bl || pSDEMapDSBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMapDSBase.getUpdateMan());
        }
        if (pSDEMapDSBase.isUserCatDirty() && (bl || pSDEMapDSBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMapDSBase.getUserCat());
        }
        if (pSDEMapDSBase.isUserTagDirty() && (bl || pSDEMapDSBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMapDSBase.getUserTag());
        }
        if (pSDEMapDSBase.isUserTag2Dirty() && (bl || pSDEMapDSBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMapDSBase.getUserTag2());
        }
        if (pSDEMapDSBase.isUserTag3Dirty() && (bl || pSDEMapDSBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMapDSBase.getUserTag3());
        }
        if (pSDEMapDSBase.isUserTag4Dirty() && (bl || pSDEMapDSBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMapDSBase.getUserTag4());
        }
        if (pSDEMapDSBase.isValidFlagDirty() && (bl || pSDEMapDSBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMapDSBase.getValidFlag());
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
        return PSDEMapDSBase.remove(this, n);
    }

    private static boolean remove(PSDEMapDSBase pSDEMapDSBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapDSBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMapDSBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMapDSBase.resetDstPSDEDataSetId();
                return true;
            }
            case 3: {
                pSDEMapDSBase.resetDstPSDEDataSetName();
                return true;
            }
            case 4: {
                pSDEMapDSBase.resetDstPSDEId();
                return true;
            }
            case 5: {
                pSDEMapDSBase.resetEnableDQCond();
                return true;
            }
            case 6: {
                pSDEMapDSBase.resetMapMode();
                return true;
            }
            case 7: {
                pSDEMapDSBase.resetMemo();
                return true;
            }
            case 8: {
                pSDEMapDSBase.resetPropertyMap();
                return true;
            }
            case 9: {
                pSDEMapDSBase.resetPSDEDataSetId();
                return true;
            }
            case 10: {
                pSDEMapDSBase.resetPSDEDataSetName();
                return true;
            }
            case 11: {
                pSDEMapDSBase.resetPSDEId();
                return true;
            }
            case 12: {
                pSDEMapDSBase.resetPSDEMapDSId();
                return true;
            }
            case 13: {
                pSDEMapDSBase.resetPSDEMapDSName();
                return true;
            }
            case 14: {
                pSDEMapDSBase.resetPSDEMapId();
                return true;
            }
            case 15: {
                pSDEMapDSBase.resetPSDEMapName();
                return true;
            }
            case 16: {
                pSDEMapDSBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSDEMapDSBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSDEMapDSBase.resetUserCat();
                return true;
            }
            case 19: {
                pSDEMapDSBase.resetUserTag();
                return true;
            }
            case 20: {
                pSDEMapDSBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSDEMapDSBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSDEMapDSBase.resetUserTag4();
                return true;
            }
            case 23: {
                pSDEMapDSBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEDataSet getDstPSDEDataSet() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEDataSet();
        }
        if (this.getDstPSDEDataSetId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEDataSetLock;
        synchronized (n) {
            if (this.dstpsdedataset != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEDataSetId(), (Object)this.dstpsdedataset.getPSDEDataSetId()) != 0L) {
                this.dstpsdedataset = null;
            }
            if (this.dstpsdedataset == null) {
                PSDEDataSet pSDEDataSet = new PSDEDataSet();
                pSDEDataSet.setPSDEDataSetId(this.getDstPSDEDataSetId());
                PSDEDataSetService pSDEDataSetService = (PSDEDataSetService)ServiceGlobal.getService(PSDEDataSetService.class, (SessionFactory)this.getSessionFactory());
                pSDEDataSetService.autoGet(pSDEDataSet);
                this.dstpsdedataset = pSDEDataSet;
            }
            return this.dstpsdedataset;
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
                pSDEMapService.autoGet(pSDEMap);
                this.psdemap = pSDEMap;
            }
            return this.psdemap;
        }
    }

    private PSDEMapDSBase getProxyEntity() {
        return this.proxyPSDEMapDSBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMapDSBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMapDSBase) {
            this.proxyPSDEMapDSBase = (PSDEMapDSBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapDSService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETID, 2);
        fieldIndexMap.put(FIELD_DSTPSDEDATASETNAME, 3);
        fieldIndexMap.put(FIELD_DSTPSDEID, 4);
        fieldIndexMap.put(FIELD_ENABLEDQCOND, 5);
        fieldIndexMap.put(FIELD_MAPMODE, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 8);
        fieldIndexMap.put(FIELD_PSDEDATASETID, 9);
        fieldIndexMap.put(FIELD_PSDEDATASETNAME, 10);
        fieldIndexMap.put(FIELD_PSDEID, 11);
        fieldIndexMap.put(FIELD_PSDEMAPDSID, 12);
        fieldIndexMap.put(FIELD_PSDEMAPDSNAME, 13);
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

