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
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIHierarchy;
import net.ibizsys.pscore.srv.bidesign.entity.PSSysBIScheme;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBIHierarchyService;
import net.ibizsys.pscore.srv.bidesign.service.PSSysBISchemeService;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysSFPlugin;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysSFPluginService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysBIDimensionBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysBIDimensionBase.class);
    public static final String FIELD_BIDIMENSIONTAG = "BIDIMENSIONTAG";
    public static final String FIELD_BIDIMENSIONTAG2 = "BIDIMENSIONTAG2";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSSYSBIDIMENSIONID = "PSSYSBIDIMENSIONID";
    public static final String FIELD_PSSYSBIDIMENSIONNAME = "PSSYSBIDIMENSIONNAME";
    public static final String FIELD_PSSYSBISCHEMEID = "PSSYSBISCHEMEID";
    public static final String FIELD_PSSYSBISCHEMENAME = "PSSYSBISCHEMENAME";
    public static final String FIELD_PSSYSSFPLUGINID = "PSSYSSFPLUGINID";
    public static final String FIELD_PSSYSSFPLUGINNAME = "PSSYSSFPLUGINNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_BIDIMENSIONTAG = 0;
    private static final int INDEX_BIDIMENSIONTAG2 = 1;
    private static final int INDEX_CODENAME = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_PSSYSBIDIMENSIONID = 6;
    private static final int INDEX_PSSYSBIDIMENSIONNAME = 7;
    private static final int INDEX_PSSYSBISCHEMEID = 8;
    private static final int INDEX_PSSYSBISCHEMENAME = 9;
    private static final int INDEX_PSSYSSFPLUGINID = 10;
    private static final int INDEX_PSSYSSFPLUGINNAME = 11;
    private static final int INDEX_UPDATEDATE = 12;
    private static final int INDEX_UPDATEMAN = 13;
    private static final int INDEX_USERCAT = 14;
    private static final int INDEX_USERTAG = 15;
    private static final int INDEX_USERTAG2 = 16;
    private static final int INDEX_USERTAG3 = 17;
    private static final int INDEX_USERTAG4 = 18;
    private static final int INDEX_VALIDFLAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysBIDimensionBase proxyPSSysBIDimensionBase = null;
    private boolean bidimensiontagDirtyFlag = false;
    private boolean bidimensiontag2DirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean pssysbidimensionidDirtyFlag = false;
    private boolean pssysbidimensionnameDirtyFlag = false;
    private boolean pssysbischemeidDirtyFlag = false;
    private boolean pssysbischemenameDirtyFlag = false;
    private boolean pssyssfpluginidDirtyFlag = false;
    private boolean pssyssfpluginnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="bidimensiontag")
    private String bidimensiontag;
    @Column(name="bidimensiontag2")
    private String bidimensiontag2;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="pssysbidimensionid")
    private String pssysbidimensionid;
    @Column(name="pssysbidimensionname")
    private String pssysbidimensionname;
    @Column(name="pssysbischemeid")
    private String pssysbischemeid;
    @Column(name="pssysbischemename")
    private String pssysbischemename;
    @Column(name="pssyssfpluginid")
    private String pssyssfpluginid;
    @Column(name="pssyssfpluginname")
    private String pssyssfpluginname;
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
    private Integer objPSSysBISchemeLock = new Integer(1);
    private PSSysBIScheme pssysbischeme = null;
    private Integer objPSSysSFPluginLock = new Integer(1);
    private PSSysSFPlugin pssyssfplugin = null;
    private Integer objPSSysBIHierarchiesLock = new Integer(1);
    private ArrayList<PSSysBIHierarchy> pssysbihierarchies = null;

    public void setBIDimensionTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIDimensionTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bidimensiontag = string;
        this.bidimensiontagDirtyFlag = true;
    }

    public String getBIDimensionTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIDimensionTag();
        }
        return this.bidimensiontag;
    }

    public boolean isBIDimensionTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIDimensionTagDirty();
        }
        return this.bidimensiontagDirtyFlag;
    }

    public void resetBIDimensionTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIDimensionTag();
            return;
        }
        this.bidimensiontagDirtyFlag = false;
        this.bidimensiontag = null;
    }

    public void setBIDimensionTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBIDimensionTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bidimensiontag2 = string;
        this.bidimensiontag2DirtyFlag = true;
    }

    public String getBIDimensionTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBIDimensionTag2();
        }
        return this.bidimensiontag2;
    }

    public boolean isBIDimensionTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBIDimensionTag2Dirty();
        }
        return this.bidimensiontag2DirtyFlag;
    }

    public void resetBIDimensionTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBIDimensionTag2();
            return;
        }
        this.bidimensiontag2DirtyFlag = false;
        this.bidimensiontag2 = null;
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

    public void setPSSysBIDimensionId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionid = string;
        this.pssysbidimensionidDirtyFlag = true;
    }

    public String getPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionId();
        }
        return this.pssysbidimensionid;
    }

    public boolean isPSSysBIDimensionIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionIdDirty();
        }
        return this.pssysbidimensionidDirtyFlag;
    }

    public void resetPSSysBIDimensionId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionId();
            return;
        }
        this.pssysbidimensionidDirtyFlag = false;
        this.pssysbidimensionid = null;
    }

    public void setPSSysBIDimensionName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysBIDimensionName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysbidimensionname = string;
        this.pssysbidimensionnameDirtyFlag = true;
    }

    public String getPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIDimensionName();
        }
        return this.pssysbidimensionname;
    }

    public boolean isPSSysBIDimensionNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysBIDimensionNameDirty();
        }
        return this.pssysbidimensionnameDirtyFlag;
    }

    public void resetPSSysBIDimensionName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysBIDimensionName();
            return;
        }
        this.pssysbidimensionnameDirtyFlag = false;
        this.pssysbidimensionname = null;
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
        PSSysBIDimensionBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysBIDimensionBase pSSysBIDimensionBase) {
        pSSysBIDimensionBase.resetBIDimensionTag();
        pSSysBIDimensionBase.resetBIDimensionTag2();
        pSSysBIDimensionBase.resetCodeName();
        pSSysBIDimensionBase.resetCreateDate();
        pSSysBIDimensionBase.resetCreateMan();
        pSSysBIDimensionBase.resetMemo();
        pSSysBIDimensionBase.resetPSSysBIDimensionId();
        pSSysBIDimensionBase.resetPSSysBIDimensionName();
        pSSysBIDimensionBase.resetPSSysBISchemeId();
        pSSysBIDimensionBase.resetPSSysBISchemeName();
        pSSysBIDimensionBase.resetPSSysSFPluginId();
        pSSysBIDimensionBase.resetPSSysSFPluginName();
        pSSysBIDimensionBase.resetUpdateDate();
        pSSysBIDimensionBase.resetUpdateMan();
        pSSysBIDimensionBase.resetUserCat();
        pSSysBIDimensionBase.resetUserTag();
        pSSysBIDimensionBase.resetUserTag2();
        pSSysBIDimensionBase.resetUserTag3();
        pSSysBIDimensionBase.resetUserTag4();
        pSSysBIDimensionBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBIDimensionTagDirty()) {
            hashMap.put(FIELD_BIDIMENSIONTAG, this.getBIDimensionTag());
        }
        if (!bl || this.isBIDimensionTag2Dirty()) {
            hashMap.put(FIELD_BIDIMENSIONTAG2, this.getBIDimensionTag2());
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
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSSysBIDimensionIdDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONID, this.getPSSysBIDimensionId());
        }
        if (!bl || this.isPSSysBIDimensionNameDirty()) {
            hashMap.put(FIELD_PSSYSBIDIMENSIONNAME, this.getPSSysBIDimensionName());
        }
        if (!bl || this.isPSSysBISchemeIdDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMEID, this.getPSSysBISchemeId());
        }
        if (!bl || this.isPSSysBISchemeNameDirty()) {
            hashMap.put(FIELD_PSSYSBISCHEMENAME, this.getPSSysBISchemeName());
        }
        if (!bl || this.isPSSysSFPluginIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINID, this.getPSSysSFPluginId());
        }
        if (!bl || this.isPSSysSFPluginNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPLUGINNAME, this.getPSSysSFPluginName());
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
        return PSSysBIDimensionBase.get(this, n);
    }

    private static Object get(PSSysBIDimensionBase pSSysBIDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIDimensionBase.getBIDimensionTag();
            }
            case 1: {
                return pSSysBIDimensionBase.getBIDimensionTag2();
            }
            case 2: {
                return pSSysBIDimensionBase.getCodeName();
            }
            case 3: {
                return pSSysBIDimensionBase.getCreateDate();
            }
            case 4: {
                return pSSysBIDimensionBase.getCreateMan();
            }
            case 5: {
                return pSSysBIDimensionBase.getMemo();
            }
            case 6: {
                return pSSysBIDimensionBase.getPSSysBIDimensionId();
            }
            case 7: {
                return pSSysBIDimensionBase.getPSSysBIDimensionName();
            }
            case 8: {
                return pSSysBIDimensionBase.getPSSysBISchemeId();
            }
            case 9: {
                return pSSysBIDimensionBase.getPSSysBISchemeName();
            }
            case 10: {
                return pSSysBIDimensionBase.getPSSysSFPluginId();
            }
            case 11: {
                return pSSysBIDimensionBase.getPSSysSFPluginName();
            }
            case 12: {
                return pSSysBIDimensionBase.getUpdateDate();
            }
            case 13: {
                return pSSysBIDimensionBase.getUpdateMan();
            }
            case 14: {
                return pSSysBIDimensionBase.getUserCat();
            }
            case 15: {
                return pSSysBIDimensionBase.getUserTag();
            }
            case 16: {
                return pSSysBIDimensionBase.getUserTag2();
            }
            case 17: {
                return pSSysBIDimensionBase.getUserTag3();
            }
            case 18: {
                return pSSysBIDimensionBase.getUserTag4();
            }
            case 19: {
                return pSSysBIDimensionBase.getValidFlag();
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
        PSSysBIDimensionBase.set(this, n, object);
    }

    private static void set(PSSysBIDimensionBase pSSysBIDimensionBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIDimensionBase.setBIDimensionTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysBIDimensionBase.setBIDimensionTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysBIDimensionBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysBIDimensionBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSSysBIDimensionBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysBIDimensionBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysBIDimensionBase.setPSSysBIDimensionId(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysBIDimensionBase.setPSSysBIDimensionName(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysBIDimensionBase.setPSSysBISchemeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysBIDimensionBase.setPSSysBISchemeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysBIDimensionBase.setPSSysSFPluginId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysBIDimensionBase.setPSSysSFPluginName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysBIDimensionBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 13: {
                pSSysBIDimensionBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysBIDimensionBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysBIDimensionBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysBIDimensionBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysBIDimensionBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysBIDimensionBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysBIDimensionBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSSysBIDimensionBase.isNull(this, n);
    }

    private static boolean isNull(PSSysBIDimensionBase pSSysBIDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIDimensionBase.getBIDimensionTag() == null;
            }
            case 1: {
                return pSSysBIDimensionBase.getBIDimensionTag2() == null;
            }
            case 2: {
                return pSSysBIDimensionBase.getCodeName() == null;
            }
            case 3: {
                return pSSysBIDimensionBase.getCreateDate() == null;
            }
            case 4: {
                return pSSysBIDimensionBase.getCreateMan() == null;
            }
            case 5: {
                return pSSysBIDimensionBase.getMemo() == null;
            }
            case 6: {
                return pSSysBIDimensionBase.getPSSysBIDimensionId() == null;
            }
            case 7: {
                return pSSysBIDimensionBase.getPSSysBIDimensionName() == null;
            }
            case 8: {
                return pSSysBIDimensionBase.getPSSysBISchemeId() == null;
            }
            case 9: {
                return pSSysBIDimensionBase.getPSSysBISchemeName() == null;
            }
            case 10: {
                return pSSysBIDimensionBase.getPSSysSFPluginId() == null;
            }
            case 11: {
                return pSSysBIDimensionBase.getPSSysSFPluginName() == null;
            }
            case 12: {
                return pSSysBIDimensionBase.getUpdateDate() == null;
            }
            case 13: {
                return pSSysBIDimensionBase.getUpdateMan() == null;
            }
            case 14: {
                return pSSysBIDimensionBase.getUserCat() == null;
            }
            case 15: {
                return pSSysBIDimensionBase.getUserTag() == null;
            }
            case 16: {
                return pSSysBIDimensionBase.getUserTag2() == null;
            }
            case 17: {
                return pSSysBIDimensionBase.getUserTag3() == null;
            }
            case 18: {
                return pSSysBIDimensionBase.getUserTag4() == null;
            }
            case 19: {
                return pSSysBIDimensionBase.getValidFlag() == null;
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
        return PSSysBIDimensionBase.contains(this, n);
    }

    private static boolean contains(PSSysBIDimensionBase pSSysBIDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysBIDimensionBase.isBIDimensionTagDirty();
            }
            case 1: {
                return pSSysBIDimensionBase.isBIDimensionTag2Dirty();
            }
            case 2: {
                return pSSysBIDimensionBase.isCodeNameDirty();
            }
            case 3: {
                return pSSysBIDimensionBase.isCreateDateDirty();
            }
            case 4: {
                return pSSysBIDimensionBase.isCreateManDirty();
            }
            case 5: {
                return pSSysBIDimensionBase.isMemoDirty();
            }
            case 6: {
                return pSSysBIDimensionBase.isPSSysBIDimensionIdDirty();
            }
            case 7: {
                return pSSysBIDimensionBase.isPSSysBIDimensionNameDirty();
            }
            case 8: {
                return pSSysBIDimensionBase.isPSSysBISchemeIdDirty();
            }
            case 9: {
                return pSSysBIDimensionBase.isPSSysBISchemeNameDirty();
            }
            case 10: {
                return pSSysBIDimensionBase.isPSSysSFPluginIdDirty();
            }
            case 11: {
                return pSSysBIDimensionBase.isPSSysSFPluginNameDirty();
            }
            case 12: {
                return pSSysBIDimensionBase.isUpdateDateDirty();
            }
            case 13: {
                return pSSysBIDimensionBase.isUpdateManDirty();
            }
            case 14: {
                return pSSysBIDimensionBase.isUserCatDirty();
            }
            case 15: {
                return pSSysBIDimensionBase.isUserTagDirty();
            }
            case 16: {
                return pSSysBIDimensionBase.isUserTag2Dirty();
            }
            case 17: {
                return pSSysBIDimensionBase.isUserTag3Dirty();
            }
            case 18: {
                return pSSysBIDimensionBase.isUserTag4Dirty();
            }
            case 19: {
                return pSSysBIDimensionBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysBIDimensionBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysBIDimensionBase pSSysBIDimensionBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysBIDimensionBase.getBIDimensionTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bidimensiontag", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getBIDimensionTag()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getBIDimensionTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bidimensiontag2", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getBIDimensionTag2()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBIDimensionId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionid", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysBIDimensionId()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBIDimensionName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbidimensionname", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysBIDimensionName()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBISchemeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemeid", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysBISchemeId()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBISchemeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysbischemename", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysBISchemeName()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysSFPluginId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginid", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysSFPluginId()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getPSSysSFPluginName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpluginname", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getPSSysSFPluginName()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSSysBIDimensionBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSSysBIDimensionBase.getJSONValue((Object)pSSysBIDimensionBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysBIDimensionBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysBIDimensionBase pSSysBIDimensionBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysBIDimensionBase.getBIDimensionTag() != null) {
            object = pSSysBIDimensionBase.getBIDimensionTag();
            xmlNode.setAttribute(FIELD_BIDIMENSIONTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIDimensionBase.getBIDimensionTag2() != null) {
            object = pSSysBIDimensionBase.getBIDimensionTag2();
            xmlNode.setAttribute(FIELD_BIDIMENSIONTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysBIDimensionBase.getCodeName() != null) {
            object = pSSysBIDimensionBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getCreateDate() != null) {
            object = pSSysBIDimensionBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIDimensionBase.getCreateMan() != null) {
            object = pSSysBIDimensionBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getMemo() != null) {
            object = pSSysBIDimensionBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBIDimensionId() != null) {
            object = pSSysBIDimensionBase.getPSSysBIDimensionId();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBIDimensionName() != null) {
            object = pSSysBIDimensionBase.getPSSysBIDimensionName();
            xmlNode.setAttribute(FIELD_PSSYSBIDIMENSIONNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBISchemeId() != null) {
            object = pSSysBIDimensionBase.getPSSysBISchemeId();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysBISchemeName() != null) {
            object = pSSysBIDimensionBase.getPSSysBISchemeName();
            xmlNode.setAttribute(FIELD_PSSYSBISCHEMENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysSFPluginId() != null) {
            object = pSSysBIDimensionBase.getPSSysSFPluginId();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINID, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getPSSysSFPluginName() != null) {
            object = pSSysBIDimensionBase.getPSSysSFPluginName();
            xmlNode.setAttribute(FIELD_PSSYSSFPLUGINNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUpdateDate() != null) {
            object = pSSysBIDimensionBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysBIDimensionBase.getUpdateMan() != null) {
            object = pSSysBIDimensionBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUserCat() != null) {
            object = pSSysBIDimensionBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUserTag() != null) {
            object = pSSysBIDimensionBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUserTag2() != null) {
            object = pSSysBIDimensionBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUserTag3() != null) {
            object = pSSysBIDimensionBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getUserTag4() != null) {
            object = pSSysBIDimensionBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSSysBIDimensionBase.getValidFlag() != null) {
            object = pSSysBIDimensionBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysBIDimensionBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysBIDimensionBase pSSysBIDimensionBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysBIDimensionBase.isBIDimensionTagDirty() && (bl || pSSysBIDimensionBase.getBIDimensionTag() != null)) {
            iDataObject.set(FIELD_BIDIMENSIONTAG, (Object)pSSysBIDimensionBase.getBIDimensionTag());
        }
        if (pSSysBIDimensionBase.isBIDimensionTag2Dirty() && (bl || pSSysBIDimensionBase.getBIDimensionTag2() != null)) {
            iDataObject.set(FIELD_BIDIMENSIONTAG2, (Object)pSSysBIDimensionBase.getBIDimensionTag2());
        }
        if (pSSysBIDimensionBase.isCodeNameDirty() && (bl || pSSysBIDimensionBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysBIDimensionBase.getCodeName());
        }
        if (pSSysBIDimensionBase.isCreateDateDirty() && (bl || pSSysBIDimensionBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysBIDimensionBase.getCreateDate());
        }
        if (pSSysBIDimensionBase.isCreateManDirty() && (bl || pSSysBIDimensionBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysBIDimensionBase.getCreateMan());
        }
        if (pSSysBIDimensionBase.isMemoDirty() && (bl || pSSysBIDimensionBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysBIDimensionBase.getMemo());
        }
        if (pSSysBIDimensionBase.isPSSysBIDimensionIdDirty() && (bl || pSSysBIDimensionBase.getPSSysBIDimensionId() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONID, (Object)pSSysBIDimensionBase.getPSSysBIDimensionId());
        }
        if (pSSysBIDimensionBase.isPSSysBIDimensionNameDirty() && (bl || pSSysBIDimensionBase.getPSSysBIDimensionName() != null)) {
            iDataObject.set(FIELD_PSSYSBIDIMENSIONNAME, (Object)pSSysBIDimensionBase.getPSSysBIDimensionName());
        }
        if (pSSysBIDimensionBase.isPSSysBISchemeIdDirty() && (bl || pSSysBIDimensionBase.getPSSysBISchemeId() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMEID, (Object)pSSysBIDimensionBase.getPSSysBISchemeId());
        }
        if (pSSysBIDimensionBase.isPSSysBISchemeNameDirty() && (bl || pSSysBIDimensionBase.getPSSysBISchemeName() != null)) {
            iDataObject.set(FIELD_PSSYSBISCHEMENAME, (Object)pSSysBIDimensionBase.getPSSysBISchemeName());
        }
        if (pSSysBIDimensionBase.isPSSysSFPluginIdDirty() && (bl || pSSysBIDimensionBase.getPSSysSFPluginId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINID, (Object)pSSysBIDimensionBase.getPSSysSFPluginId());
        }
        if (pSSysBIDimensionBase.isPSSysSFPluginNameDirty() && (bl || pSSysBIDimensionBase.getPSSysSFPluginName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPLUGINNAME, (Object)pSSysBIDimensionBase.getPSSysSFPluginName());
        }
        if (pSSysBIDimensionBase.isUpdateDateDirty() && (bl || pSSysBIDimensionBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysBIDimensionBase.getUpdateDate());
        }
        if (pSSysBIDimensionBase.isUpdateManDirty() && (bl || pSSysBIDimensionBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysBIDimensionBase.getUpdateMan());
        }
        if (pSSysBIDimensionBase.isUserCatDirty() && (bl || pSSysBIDimensionBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysBIDimensionBase.getUserCat());
        }
        if (pSSysBIDimensionBase.isUserTagDirty() && (bl || pSSysBIDimensionBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysBIDimensionBase.getUserTag());
        }
        if (pSSysBIDimensionBase.isUserTag2Dirty() && (bl || pSSysBIDimensionBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysBIDimensionBase.getUserTag2());
        }
        if (pSSysBIDimensionBase.isUserTag3Dirty() && (bl || pSSysBIDimensionBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysBIDimensionBase.getUserTag3());
        }
        if (pSSysBIDimensionBase.isUserTag4Dirty() && (bl || pSSysBIDimensionBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysBIDimensionBase.getUserTag4());
        }
        if (pSSysBIDimensionBase.isValidFlagDirty() && (bl || pSSysBIDimensionBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSSysBIDimensionBase.getValidFlag());
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
        return PSSysBIDimensionBase.remove(this, n);
    }

    private static boolean remove(PSSysBIDimensionBase pSSysBIDimensionBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysBIDimensionBase.resetBIDimensionTag();
                return true;
            }
            case 1: {
                pSSysBIDimensionBase.resetBIDimensionTag2();
                return true;
            }
            case 2: {
                pSSysBIDimensionBase.resetCodeName();
                return true;
            }
            case 3: {
                pSSysBIDimensionBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSSysBIDimensionBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSSysBIDimensionBase.resetMemo();
                return true;
            }
            case 6: {
                pSSysBIDimensionBase.resetPSSysBIDimensionId();
                return true;
            }
            case 7: {
                pSSysBIDimensionBase.resetPSSysBIDimensionName();
                return true;
            }
            case 8: {
                pSSysBIDimensionBase.resetPSSysBISchemeId();
                return true;
            }
            case 9: {
                pSSysBIDimensionBase.resetPSSysBISchemeName();
                return true;
            }
            case 10: {
                pSSysBIDimensionBase.resetPSSysSFPluginId();
                return true;
            }
            case 11: {
                pSSysBIDimensionBase.resetPSSysSFPluginName();
                return true;
            }
            case 12: {
                pSSysBIDimensionBase.resetUpdateDate();
                return true;
            }
            case 13: {
                pSSysBIDimensionBase.resetUpdateMan();
                return true;
            }
            case 14: {
                pSSysBIDimensionBase.resetUserCat();
                return true;
            }
            case 15: {
                pSSysBIDimensionBase.resetUserTag();
                return true;
            }
            case 16: {
                pSSysBIDimensionBase.resetUserTag2();
                return true;
            }
            case 17: {
                pSSysBIDimensionBase.resetUserTag3();
                return true;
            }
            case 18: {
                pSSysBIDimensionBase.resetUserTag4();
                return true;
            }
            case 19: {
                pSSysBIDimensionBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
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
    public ArrayList<PSSysBIHierarchy> getPSSysBIHierarchies() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysBIHierarchies();
        }
        if (this.getPSSysBIDimensionId() == null) {
            return null;
        }
        PSSysBIHierarchyService pSSysBIHierarchyService = (PSSysBIHierarchyService)ServiceGlobal.getService(PSSysBIHierarchyService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysBIHierarchiesLock;
        synchronized (n) {
            if (this.pssysbihierarchies == null) {
                this.pssysbihierarchies = pSSysBIHierarchyService.selectByPSSysBIDimension(this);
            }
            return this.pssysbihierarchies;
        }
    }

    private PSSysBIDimensionBase getProxyEntity() {
        return this.proxyPSSysBIDimensionBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysBIDimensionBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysBIDimensionBase) {
            this.proxyPSSysBIDimensionBase = (PSSysBIDimensionBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.bidesign.service.PSSysBIDimensionService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BIDIMENSIONTAG, 0);
        fieldIndexMap.put(FIELD_BIDIMENSIONTAG2, 1);
        fieldIndexMap.put(FIELD_CODENAME, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONID, 6);
        fieldIndexMap.put(FIELD_PSSYSBIDIMENSIONNAME, 7);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMEID, 8);
        fieldIndexMap.put(FIELD_PSSYSBISCHEMENAME, 9);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINID, 10);
        fieldIndexMap.put(FIELD_PSSYSSFPLUGINNAME, 11);
        fieldIndexMap.put(FIELD_UPDATEDATE, 12);
        fieldIndexMap.put(FIELD_UPDATEMAN, 13);
        fieldIndexMap.put(FIELD_USERCAT, 14);
        fieldIndexMap.put(FIELD_USERTAG, 15);
        fieldIndexMap.put(FIELD_USERTAG2, 16);
        fieldIndexMap.put(FIELD_USERTAG3, 17);
        fieldIndexMap.put(FIELD_USERTAG4, 18);
        fieldIndexMap.put(FIELD_VALIDFLAG, 19);
    }
}

