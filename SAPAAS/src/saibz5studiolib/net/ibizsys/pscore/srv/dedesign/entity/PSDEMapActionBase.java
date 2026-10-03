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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEAction;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEMap;
import net.ibizsys.pscore.srv.dedesign.service.PSDEActionService;
import net.ibizsys.pscore.srv.dedesign.service.PSDEMapService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEMapActionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEMapActionBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DSTPSDEACTIONID = "DSTPSDEACTIONID";
    public static final String FIELD_DSTPSDEACTIONNAME = "DSTPSDEACTIONNAME";
    public static final String FIELD_DSTPSDEID = "DSTPSDEID";
    public static final String FIELD_MAPMODE = "MAPMODE";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PROPERTYMAP = "PROPERTYMAP";
    public static final String FIELD_PSDEACTIONID = "PSDEACTIONID";
    public static final String FIELD_PSDEACTIONNAME = "PSDEACTIONNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMAPACTIONID = "PSDEMAPACTIONID";
    public static final String FIELD_PSDEMAPACTIONNAME = "PSDEMAPACTIONNAME";
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
    private static final int INDEX_DSTPSDEACTIONID = 2;
    private static final int INDEX_DSTPSDEACTIONNAME = 3;
    private static final int INDEX_DSTPSDEID = 4;
    private static final int INDEX_MAPMODE = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PROPERTYMAP = 7;
    private static final int INDEX_PSDEACTIONID = 8;
    private static final int INDEX_PSDEACTIONNAME = 9;
    private static final int INDEX_PSDEID = 10;
    private static final int INDEX_PSDEMAPACTIONID = 11;
    private static final int INDEX_PSDEMAPACTIONNAME = 12;
    private static final int INDEX_PSDEMAPID = 13;
    private static final int INDEX_PSDEMAPNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_USERCAT = 17;
    private static final int INDEX_USERTAG = 18;
    private static final int INDEX_USERTAG2 = 19;
    private static final int INDEX_USERTAG3 = 20;
    private static final int INDEX_USERTAG4 = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEMapActionBase proxyPSDEMapActionBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dstpsdeactionidDirtyFlag = false;
    private boolean dstpsdeactionnameDirtyFlag = false;
    private boolean dstpsdeidDirtyFlag = false;
    private boolean mapmodeDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean propertymapDirtyFlag = false;
    private boolean psdeactionidDirtyFlag = false;
    private boolean psdeactionnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemapactionidDirtyFlag = false;
    private boolean psdemapactionnameDirtyFlag = false;
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
    @Column(name="dstpsdeactionid")
    private String dstpsdeactionid;
    @Column(name="dstpsdeactionname")
    private String dstpsdeactionname;
    @Column(name="dstpsdeid")
    private String dstpsdeid;
    @Column(name="mapmode")
    private String mapmode;
    @Column(name="memo")
    private String memo;
    @Column(name="propertymap")
    private String propertymap;
    @Column(name="psdeactionid")
    private String psdeactionid;
    @Column(name="psdeactionname")
    private String psdeactionname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemapactionid")
    private String psdemapactionid;
    @Column(name="psdemapactionname")
    private String psdemapactionname;
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
    private Integer objDstPSDEActionLock = new Integer(1);
    private PSDEAction dstpsdeaction = null;
    private Integer objPSDEActionLock = new Integer(1);
    private PSDEAction psdeaction = null;
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

    public void setDstPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionid = string;
        this.dstpsdeactionidDirtyFlag = true;
    }

    public String getDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionId();
        }
        return this.dstpsdeactionid;
    }

    public boolean isDstPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionIdDirty();
        }
        return this.dstpsdeactionidDirtyFlag;
    }

    public void resetDstPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionId();
            return;
        }
        this.dstpsdeactionidDirtyFlag = false;
        this.dstpsdeactionid = null;
    }

    public void setDstPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDstPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dstpsdeactionname = string;
        this.dstpsdeactionnameDirtyFlag = true;
    }

    public String getDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEActionName();
        }
        return this.dstpsdeactionname;
    }

    public boolean isDstPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDstPSDEActionNameDirty();
        }
        return this.dstpsdeactionnameDirtyFlag;
    }

    public void resetDstPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDstPSDEActionName();
            return;
        }
        this.dstpsdeactionnameDirtyFlag = false;
        this.dstpsdeactionname = null;
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

    public void setPSDEActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionid = string;
        this.psdeactionidDirtyFlag = true;
    }

    public String getPSDEActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionId();
        }
        return this.psdeactionid;
    }

    public boolean isPSDEActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionIdDirty();
        }
        return this.psdeactionidDirtyFlag;
    }

    public void resetPSDEActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionId();
            return;
        }
        this.psdeactionidDirtyFlag = false;
        this.psdeactionid = null;
    }

    public void setPSDEActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeactionname = string;
        this.psdeactionnameDirtyFlag = true;
    }

    public String getPSDEActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEActionName();
        }
        return this.psdeactionname;
    }

    public boolean isPSDEActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEActionNameDirty();
        }
        return this.psdeactionnameDirtyFlag;
    }

    public void resetPSDEActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEActionName();
            return;
        }
        this.psdeactionnameDirtyFlag = false;
        this.psdeactionname = null;
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

    public void setPSDEMapActionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapActionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapactionid = string;
        this.psdemapactionidDirtyFlag = true;
    }

    public String getPSDEMapActionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapActionId();
        }
        return this.psdemapactionid;
    }

    public boolean isPSDEMapActionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapActionIdDirty();
        }
        return this.psdemapactionidDirtyFlag;
    }

    public void resetPSDEMapActionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapActionId();
            return;
        }
        this.psdemapactionidDirtyFlag = false;
        this.psdemapactionid = null;
    }

    public void setPSDEMapActionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEMapActionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemapactionname = string;
        this.psdemapactionnameDirtyFlag = true;
    }

    public String getPSDEMapActionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEMapActionName();
        }
        return this.psdemapactionname;
    }

    public boolean isPSDEMapActionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEMapActionNameDirty();
        }
        return this.psdemapactionnameDirtyFlag;
    }

    public void resetPSDEMapActionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEMapActionName();
            return;
        }
        this.psdemapactionnameDirtyFlag = false;
        this.psdemapactionname = null;
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
        PSDEMapActionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEMapActionBase pSDEMapActionBase) {
        pSDEMapActionBase.resetCreateDate();
        pSDEMapActionBase.resetCreateMan();
        pSDEMapActionBase.resetDstPSDEActionId();
        pSDEMapActionBase.resetDstPSDEActionName();
        pSDEMapActionBase.resetDstPSDEId();
        pSDEMapActionBase.resetMapMode();
        pSDEMapActionBase.resetMemo();
        pSDEMapActionBase.resetPropertyMap();
        pSDEMapActionBase.resetPSDEActionId();
        pSDEMapActionBase.resetPSDEActionName();
        pSDEMapActionBase.resetPSDEId();
        pSDEMapActionBase.resetPSDEMapActionId();
        pSDEMapActionBase.resetPSDEMapActionName();
        pSDEMapActionBase.resetPSDEMapId();
        pSDEMapActionBase.resetPSDEMapName();
        pSDEMapActionBase.resetUpdateDate();
        pSDEMapActionBase.resetUpdateMan();
        pSDEMapActionBase.resetUserCat();
        pSDEMapActionBase.resetUserTag();
        pSDEMapActionBase.resetUserTag2();
        pSDEMapActionBase.resetUserTag3();
        pSDEMapActionBase.resetUserTag4();
        pSDEMapActionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDstPSDEActionIdDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONID, this.getDstPSDEActionId());
        }
        if (!bl || this.isDstPSDEActionNameDirty()) {
            hashMap.put(FIELD_DSTPSDEACTIONNAME, this.getDstPSDEActionName());
        }
        if (!bl || this.isDstPSDEIdDirty()) {
            hashMap.put(FIELD_DSTPSDEID, this.getDstPSDEId());
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
        if (!bl || this.isPSDEActionIdDirty()) {
            hashMap.put(FIELD_PSDEACTIONID, this.getPSDEActionId());
        }
        if (!bl || this.isPSDEActionNameDirty()) {
            hashMap.put(FIELD_PSDEACTIONNAME, this.getPSDEActionName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEMapActionIdDirty()) {
            hashMap.put(FIELD_PSDEMAPACTIONID, this.getPSDEMapActionId());
        }
        if (!bl || this.isPSDEMapActionNameDirty()) {
            hashMap.put(FIELD_PSDEMAPACTIONNAME, this.getPSDEMapActionName());
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
        return PSDEMapActionBase.get(this, n);
    }

    private static Object get(PSDEMapActionBase pSDEMapActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapActionBase.getCreateDate();
            }
            case 1: {
                return pSDEMapActionBase.getCreateMan();
            }
            case 2: {
                return pSDEMapActionBase.getDstPSDEActionId();
            }
            case 3: {
                return pSDEMapActionBase.getDstPSDEActionName();
            }
            case 4: {
                return pSDEMapActionBase.getDstPSDEId();
            }
            case 5: {
                return pSDEMapActionBase.getMapMode();
            }
            case 6: {
                return pSDEMapActionBase.getMemo();
            }
            case 7: {
                return pSDEMapActionBase.getPropertyMap();
            }
            case 8: {
                return pSDEMapActionBase.getPSDEActionId();
            }
            case 9: {
                return pSDEMapActionBase.getPSDEActionName();
            }
            case 10: {
                return pSDEMapActionBase.getPSDEId();
            }
            case 11: {
                return pSDEMapActionBase.getPSDEMapActionId();
            }
            case 12: {
                return pSDEMapActionBase.getPSDEMapActionName();
            }
            case 13: {
                return pSDEMapActionBase.getPSDEMapId();
            }
            case 14: {
                return pSDEMapActionBase.getPSDEMapName();
            }
            case 15: {
                return pSDEMapActionBase.getUpdateDate();
            }
            case 16: {
                return pSDEMapActionBase.getUpdateMan();
            }
            case 17: {
                return pSDEMapActionBase.getUserCat();
            }
            case 18: {
                return pSDEMapActionBase.getUserTag();
            }
            case 19: {
                return pSDEMapActionBase.getUserTag2();
            }
            case 20: {
                return pSDEMapActionBase.getUserTag3();
            }
            case 21: {
                return pSDEMapActionBase.getUserTag4();
            }
            case 22: {
                return pSDEMapActionBase.getValidFlag();
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
        PSDEMapActionBase.set(this, n, object);
    }

    private static void set(PSDEMapActionBase pSDEMapActionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapActionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSDEMapActionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEMapActionBase.setDstPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDEMapActionBase.setDstPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEMapActionBase.setDstPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEMapActionBase.setMapMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEMapActionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEMapActionBase.setPropertyMap(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEMapActionBase.setPSDEActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEMapActionBase.setPSDEActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEMapActionBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEMapActionBase.setPSDEMapActionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEMapActionBase.setPSDEMapActionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEMapActionBase.setPSDEMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEMapActionBase.setPSDEMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEMapActionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSDEMapActionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEMapActionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEMapActionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDEMapActionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEMapActionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEMapActionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEMapActionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEMapActionBase.isNull(this, n);
    }

    private static boolean isNull(PSDEMapActionBase pSDEMapActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapActionBase.getCreateDate() == null;
            }
            case 1: {
                return pSDEMapActionBase.getCreateMan() == null;
            }
            case 2: {
                return pSDEMapActionBase.getDstPSDEActionId() == null;
            }
            case 3: {
                return pSDEMapActionBase.getDstPSDEActionName() == null;
            }
            case 4: {
                return pSDEMapActionBase.getDstPSDEId() == null;
            }
            case 5: {
                return pSDEMapActionBase.getMapMode() == null;
            }
            case 6: {
                return pSDEMapActionBase.getMemo() == null;
            }
            case 7: {
                return pSDEMapActionBase.getPropertyMap() == null;
            }
            case 8: {
                return pSDEMapActionBase.getPSDEActionId() == null;
            }
            case 9: {
                return pSDEMapActionBase.getPSDEActionName() == null;
            }
            case 10: {
                return pSDEMapActionBase.getPSDEId() == null;
            }
            case 11: {
                return pSDEMapActionBase.getPSDEMapActionId() == null;
            }
            case 12: {
                return pSDEMapActionBase.getPSDEMapActionName() == null;
            }
            case 13: {
                return pSDEMapActionBase.getPSDEMapId() == null;
            }
            case 14: {
                return pSDEMapActionBase.getPSDEMapName() == null;
            }
            case 15: {
                return pSDEMapActionBase.getUpdateDate() == null;
            }
            case 16: {
                return pSDEMapActionBase.getUpdateMan() == null;
            }
            case 17: {
                return pSDEMapActionBase.getUserCat() == null;
            }
            case 18: {
                return pSDEMapActionBase.getUserTag() == null;
            }
            case 19: {
                return pSDEMapActionBase.getUserTag2() == null;
            }
            case 20: {
                return pSDEMapActionBase.getUserTag3() == null;
            }
            case 21: {
                return pSDEMapActionBase.getUserTag4() == null;
            }
            case 22: {
                return pSDEMapActionBase.getValidFlag() == null;
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
        return PSDEMapActionBase.contains(this, n);
    }

    private static boolean contains(PSDEMapActionBase pSDEMapActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEMapActionBase.isCreateDateDirty();
            }
            case 1: {
                return pSDEMapActionBase.isCreateManDirty();
            }
            case 2: {
                return pSDEMapActionBase.isDstPSDEActionIdDirty();
            }
            case 3: {
                return pSDEMapActionBase.isDstPSDEActionNameDirty();
            }
            case 4: {
                return pSDEMapActionBase.isDstPSDEIdDirty();
            }
            case 5: {
                return pSDEMapActionBase.isMapModeDirty();
            }
            case 6: {
                return pSDEMapActionBase.isMemoDirty();
            }
            case 7: {
                return pSDEMapActionBase.isPropertyMapDirty();
            }
            case 8: {
                return pSDEMapActionBase.isPSDEActionIdDirty();
            }
            case 9: {
                return pSDEMapActionBase.isPSDEActionNameDirty();
            }
            case 10: {
                return pSDEMapActionBase.isPSDEIdDirty();
            }
            case 11: {
                return pSDEMapActionBase.isPSDEMapActionIdDirty();
            }
            case 12: {
                return pSDEMapActionBase.isPSDEMapActionNameDirty();
            }
            case 13: {
                return pSDEMapActionBase.isPSDEMapIdDirty();
            }
            case 14: {
                return pSDEMapActionBase.isPSDEMapNameDirty();
            }
            case 15: {
                return pSDEMapActionBase.isUpdateDateDirty();
            }
            case 16: {
                return pSDEMapActionBase.isUpdateManDirty();
            }
            case 17: {
                return pSDEMapActionBase.isUserCatDirty();
            }
            case 18: {
                return pSDEMapActionBase.isUserTagDirty();
            }
            case 19: {
                return pSDEMapActionBase.isUserTag2Dirty();
            }
            case 20: {
                return pSDEMapActionBase.isUserTag3Dirty();
            }
            case 21: {
                return pSDEMapActionBase.isUserTag4Dirty();
            }
            case 22: {
                return pSDEMapActionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEMapActionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEMapActionBase pSDEMapActionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEMapActionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getDstPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getDstPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getDstPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeactionname", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getDstPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getDstPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dstpsdeid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getDstPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getMapMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"mapmode", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getMapMode()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPropertyMap() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"propertymap", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPropertyMap()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEActionId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeactionname", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEActionName()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEMapActionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapactionid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEMapActionId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEMapActionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapactionname", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEMapActionName()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapid", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEMapId()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getPSDEMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemapname", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getPSDEMapName()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEMapActionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEMapActionBase.getJSONValue((Object)pSDEMapActionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEMapActionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEMapActionBase pSDEMapActionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEMapActionBase.getCreateDate() != null) {
            object = pSDEMapActionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapActionBase.getCreateMan() != null) {
            object = pSDEMapActionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getDstPSDEActionId() != null) {
            object = pSDEMapActionBase.getDstPSDEActionId();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getDstPSDEActionName() != null) {
            object = pSDEMapActionBase.getDstPSDEActionName();
            xmlNode.setAttribute(FIELD_DSTPSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getDstPSDEId() != null) {
            object = pSDEMapActionBase.getDstPSDEId();
            xmlNode.setAttribute(FIELD_DSTPSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getMapMode() != null) {
            object = pSDEMapActionBase.getMapMode();
            xmlNode.setAttribute(FIELD_MAPMODE, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getMemo() != null) {
            object = pSDEMapActionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPropertyMap() != null) {
            object = pSDEMapActionBase.getPropertyMap();
            xmlNode.setAttribute(FIELD_PROPERTYMAP, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEActionId() != null) {
            object = pSDEMapActionBase.getPSDEActionId();
            xmlNode.setAttribute(FIELD_PSDEACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEActionName() != null) {
            object = pSDEMapActionBase.getPSDEActionName();
            xmlNode.setAttribute(FIELD_PSDEACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEId() != null) {
            object = pSDEMapActionBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEMapActionId() != null) {
            object = pSDEMapActionBase.getPSDEMapActionId();
            xmlNode.setAttribute(FIELD_PSDEMAPACTIONID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEMapActionName() != null) {
            object = pSDEMapActionBase.getPSDEMapActionName();
            xmlNode.setAttribute(FIELD_PSDEMAPACTIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEMapId() != null) {
            object = pSDEMapActionBase.getPSDEMapId();
            xmlNode.setAttribute(FIELD_PSDEMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getPSDEMapName() != null) {
            object = pSDEMapActionBase.getPSDEMapName();
            xmlNode.setAttribute(FIELD_PSDEMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUpdateDate() != null) {
            object = pSDEMapActionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEMapActionBase.getUpdateMan() != null) {
            object = pSDEMapActionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUserCat() != null) {
            object = pSDEMapActionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUserTag() != null) {
            object = pSDEMapActionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUserTag2() != null) {
            object = pSDEMapActionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUserTag3() != null) {
            object = pSDEMapActionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getUserTag4() != null) {
            object = pSDEMapActionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEMapActionBase.getValidFlag() != null) {
            object = pSDEMapActionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEMapActionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEMapActionBase pSDEMapActionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEMapActionBase.isCreateDateDirty() && (bl || pSDEMapActionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEMapActionBase.getCreateDate());
        }
        if (pSDEMapActionBase.isCreateManDirty() && (bl || pSDEMapActionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEMapActionBase.getCreateMan());
        }
        if (pSDEMapActionBase.isDstPSDEActionIdDirty() && (bl || pSDEMapActionBase.getDstPSDEActionId() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONID, (Object)pSDEMapActionBase.getDstPSDEActionId());
        }
        if (pSDEMapActionBase.isDstPSDEActionNameDirty() && (bl || pSDEMapActionBase.getDstPSDEActionName() != null)) {
            iDataObject.set(FIELD_DSTPSDEACTIONNAME, (Object)pSDEMapActionBase.getDstPSDEActionName());
        }
        if (pSDEMapActionBase.isDstPSDEIdDirty() && (bl || pSDEMapActionBase.getDstPSDEId() != null)) {
            iDataObject.set(FIELD_DSTPSDEID, (Object)pSDEMapActionBase.getDstPSDEId());
        }
        if (pSDEMapActionBase.isMapModeDirty() && (bl || pSDEMapActionBase.getMapMode() != null)) {
            iDataObject.set(FIELD_MAPMODE, (Object)pSDEMapActionBase.getMapMode());
        }
        if (pSDEMapActionBase.isMemoDirty() && (bl || pSDEMapActionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEMapActionBase.getMemo());
        }
        if (pSDEMapActionBase.isPropertyMapDirty() && (bl || pSDEMapActionBase.getPropertyMap() != null)) {
            iDataObject.set(FIELD_PROPERTYMAP, (Object)pSDEMapActionBase.getPropertyMap());
        }
        if (pSDEMapActionBase.isPSDEActionIdDirty() && (bl || pSDEMapActionBase.getPSDEActionId() != null)) {
            iDataObject.set(FIELD_PSDEACTIONID, (Object)pSDEMapActionBase.getPSDEActionId());
        }
        if (pSDEMapActionBase.isPSDEActionNameDirty() && (bl || pSDEMapActionBase.getPSDEActionName() != null)) {
            iDataObject.set(FIELD_PSDEACTIONNAME, (Object)pSDEMapActionBase.getPSDEActionName());
        }
        if (pSDEMapActionBase.isPSDEIdDirty() && (bl || pSDEMapActionBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEMapActionBase.getPSDEId());
        }
        if (pSDEMapActionBase.isPSDEMapActionIdDirty() && (bl || pSDEMapActionBase.getPSDEMapActionId() != null)) {
            iDataObject.set(FIELD_PSDEMAPACTIONID, (Object)pSDEMapActionBase.getPSDEMapActionId());
        }
        if (pSDEMapActionBase.isPSDEMapActionNameDirty() && (bl || pSDEMapActionBase.getPSDEMapActionName() != null)) {
            iDataObject.set(FIELD_PSDEMAPACTIONNAME, (Object)pSDEMapActionBase.getPSDEMapActionName());
        }
        if (pSDEMapActionBase.isPSDEMapIdDirty() && (bl || pSDEMapActionBase.getPSDEMapId() != null)) {
            iDataObject.set(FIELD_PSDEMAPID, (Object)pSDEMapActionBase.getPSDEMapId());
        }
        if (pSDEMapActionBase.isPSDEMapNameDirty() && (bl || pSDEMapActionBase.getPSDEMapName() != null)) {
            iDataObject.set(FIELD_PSDEMAPNAME, (Object)pSDEMapActionBase.getPSDEMapName());
        }
        if (pSDEMapActionBase.isUpdateDateDirty() && (bl || pSDEMapActionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEMapActionBase.getUpdateDate());
        }
        if (pSDEMapActionBase.isUpdateManDirty() && (bl || pSDEMapActionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEMapActionBase.getUpdateMan());
        }
        if (pSDEMapActionBase.isUserCatDirty() && (bl || pSDEMapActionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEMapActionBase.getUserCat());
        }
        if (pSDEMapActionBase.isUserTagDirty() && (bl || pSDEMapActionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEMapActionBase.getUserTag());
        }
        if (pSDEMapActionBase.isUserTag2Dirty() && (bl || pSDEMapActionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEMapActionBase.getUserTag2());
        }
        if (pSDEMapActionBase.isUserTag3Dirty() && (bl || pSDEMapActionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEMapActionBase.getUserTag3());
        }
        if (pSDEMapActionBase.isUserTag4Dirty() && (bl || pSDEMapActionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEMapActionBase.getUserTag4());
        }
        if (pSDEMapActionBase.isValidFlagDirty() && (bl || pSDEMapActionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEMapActionBase.getValidFlag());
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
        return PSDEMapActionBase.remove(this, n);
    }

    private static boolean remove(PSDEMapActionBase pSDEMapActionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEMapActionBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSDEMapActionBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSDEMapActionBase.resetDstPSDEActionId();
                return true;
            }
            case 3: {
                pSDEMapActionBase.resetDstPSDEActionName();
                return true;
            }
            case 4: {
                pSDEMapActionBase.resetDstPSDEId();
                return true;
            }
            case 5: {
                pSDEMapActionBase.resetMapMode();
                return true;
            }
            case 6: {
                pSDEMapActionBase.resetMemo();
                return true;
            }
            case 7: {
                pSDEMapActionBase.resetPropertyMap();
                return true;
            }
            case 8: {
                pSDEMapActionBase.resetPSDEActionId();
                return true;
            }
            case 9: {
                pSDEMapActionBase.resetPSDEActionName();
                return true;
            }
            case 10: {
                pSDEMapActionBase.resetPSDEId();
                return true;
            }
            case 11: {
                pSDEMapActionBase.resetPSDEMapActionId();
                return true;
            }
            case 12: {
                pSDEMapActionBase.resetPSDEMapActionName();
                return true;
            }
            case 13: {
                pSDEMapActionBase.resetPSDEMapId();
                return true;
            }
            case 14: {
                pSDEMapActionBase.resetPSDEMapName();
                return true;
            }
            case 15: {
                pSDEMapActionBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSDEMapActionBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSDEMapActionBase.resetUserCat();
                return true;
            }
            case 18: {
                pSDEMapActionBase.resetUserTag();
                return true;
            }
            case 19: {
                pSDEMapActionBase.resetUserTag2();
                return true;
            }
            case 20: {
                pSDEMapActionBase.resetUserTag3();
                return true;
            }
            case 21: {
                pSDEMapActionBase.resetUserTag4();
                return true;
            }
            case 22: {
                pSDEMapActionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getDstPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDstPSDEAction();
        }
        if (this.getDstPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objDstPSDEActionLock;
        synchronized (n) {
            if (this.dstpsdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getDstPSDEActionId(), (Object)this.dstpsdeaction.getPSDEActionId()) != 0L) {
                this.dstpsdeaction = null;
            }
            if (this.dstpsdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getDstPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.dstpsdeaction = pSDEAction;
            }
            return this.dstpsdeaction;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEAction getPSDEAction() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEAction();
        }
        if (this.getPSDEActionId() == null) {
            return null;
        }
        Integer n = this.objPSDEActionLock;
        synchronized (n) {
            if (this.psdeaction != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEActionId(), (Object)this.psdeaction.getPSDEActionId()) != 0L) {
                this.psdeaction = null;
            }
            if (this.psdeaction == null) {
                PSDEAction pSDEAction = new PSDEAction();
                pSDEAction.setPSDEActionId(this.getPSDEActionId());
                PSDEActionService pSDEActionService = (PSDEActionService)ServiceGlobal.getService(PSDEActionService.class, (SessionFactory)this.getSessionFactory());
                pSDEActionService.autoGet(pSDEAction);
                this.psdeaction = pSDEAction;
            }
            return this.psdeaction;
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

    private PSDEMapActionBase getProxyEntity() {
        return this.proxyPSDEMapActionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEMapActionBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEMapActionBase) {
            this.proxyPSDEMapActionBase = (PSDEMapActionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEMapActionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONID, 2);
        fieldIndexMap.put(FIELD_DSTPSDEACTIONNAME, 3);
        fieldIndexMap.put(FIELD_DSTPSDEID, 4);
        fieldIndexMap.put(FIELD_MAPMODE, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PROPERTYMAP, 7);
        fieldIndexMap.put(FIELD_PSDEACTIONID, 8);
        fieldIndexMap.put(FIELD_PSDEACTIONNAME, 9);
        fieldIndexMap.put(FIELD_PSDEID, 10);
        fieldIndexMap.put(FIELD_PSDEMAPACTIONID, 11);
        fieldIndexMap.put(FIELD_PSDEMAPACTIONNAME, 12);
        fieldIndexMap.put(FIELD_PSDEMAPID, 13);
        fieldIndexMap.put(FIELD_PSDEMAPNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_USERCAT, 17);
        fieldIndexMap.put(FIELD_USERTAG, 18);
        fieldIndexMap.put(FIELD_USERTAG2, 19);
        fieldIndexMap.put(FIELD_USERTAG3, 20);
        fieldIndexMap.put(FIELD_USERTAG4, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

