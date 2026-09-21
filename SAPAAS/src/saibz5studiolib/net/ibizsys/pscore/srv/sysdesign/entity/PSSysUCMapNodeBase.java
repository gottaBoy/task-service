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
package net.ibizsys.pscore.srv.sysdesign.entity;

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
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysActor;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUCMap;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysUserCase;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysActorService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysUserCaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysUCMapNodeBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysUCMapNodeBase.class);
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_LEFTPOS = "LEFTPOS";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_NODETYPE = "NODETYPE";
    public static final String FIELD_PSSYSACTORID = "PSSYSACTORID";
    public static final String FIELD_PSSYSACTORNAME = "PSSYSACTORNAME";
    public static final String FIELD_PSSYSUCMAPID = "PSSYSUCMAPID";
    public static final String FIELD_PSSYSUCMAPNAME = "PSSYSUCMAPNAME";
    public static final String FIELD_PSSYSUCMAPNODEID = "PSSYSUCMAPNODEID";
    public static final String FIELD_PSSYSUCMAPNODENAME = "PSSYSUCMAPNODENAME";
    public static final String FIELD_PSSYSUSERCASEID = "PSSYSUSERCASEID";
    public static final String FIELD_PSSYSUSERCASENAME = "PSSYSUSERCASENAME";
    public static final String FIELD_TOPPOS = "TOPPOS";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CREATEDATE = 0;
    private static final int INDEX_CREATEMAN = 1;
    private static final int INDEX_LEFTPOS = 2;
    private static final int INDEX_MEMO = 3;
    private static final int INDEX_NODETYPE = 4;
    private static final int INDEX_PSSYSACTORID = 5;
    private static final int INDEX_PSSYSACTORNAME = 6;
    private static final int INDEX_PSSYSUCMAPID = 7;
    private static final int INDEX_PSSYSUCMAPNAME = 8;
    private static final int INDEX_PSSYSUCMAPNODEID = 9;
    private static final int INDEX_PSSYSUCMAPNODENAME = 10;
    private static final int INDEX_PSSYSUSERCASEID = 11;
    private static final int INDEX_PSSYSUSERCASENAME = 12;
    private static final int INDEX_TOPPOS = 13;
    private static final int INDEX_UPDATEDATE = 14;
    private static final int INDEX_UPDATEMAN = 15;
    private static final int INDEX_USERCAT = 16;
    private static final int INDEX_USERTAG = 17;
    private static final int INDEX_USERTAG2 = 18;
    private static final int INDEX_USERTAG3 = 19;
    private static final int INDEX_USERTAG4 = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysUCMapNodeBase proxyPSSysUCMapNodeBase = null;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean leftposDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean nodetypeDirtyFlag = false;
    private boolean pssysactoridDirtyFlag = false;
    private boolean pssysactornameDirtyFlag = false;
    private boolean pssysucmapidDirtyFlag = false;
    private boolean pssysucmapnameDirtyFlag = false;
    private boolean pssysucmapnodeidDirtyFlag = false;
    private boolean pssysucmapnodenameDirtyFlag = false;
    private boolean pssysusercaseidDirtyFlag = false;
    private boolean pssysusercasenameDirtyFlag = false;
    private boolean topposDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="leftpos")
    private Integer leftpos;
    @Column(name="memo")
    private String memo;
    @Column(name="nodetype")
    private String nodetype;
    @Column(name="pssysactorid")
    private String pssysactorid;
    @Column(name="pssysactorname")
    private String pssysactorname;
    @Column(name="pssysucmapid")
    private String pssysucmapid;
    @Column(name="pssysucmapname")
    private String pssysucmapname;
    @Column(name="pssysucmapnodeid")
    private String pssysucmapnodeid;
    @Column(name="pssysucmapnodename")
    private String pssysucmapnodename;
    @Column(name="pssysusercaseid")
    private String pssysusercaseid;
    @Column(name="pssysusercasename")
    private String pssysusercasename;
    @Column(name="toppos")
    private Integer toppos;
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
    private Integer objPSSysActorLock = new Integer(1);
    private PSSysActor pssysactor = null;
    private Integer objPSSysUCMapLock = new Integer(1);
    private PSSysUCMap pssysucmap = null;
    private Integer objPSSysUserCaseLock = new Integer(1);
    private PSSysUserCase pssysusercase = null;

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

    public void setLeftPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLeftPos(n);
            return;
        }
        this.leftpos = n;
        this.leftposDirtyFlag = true;
    }

    public Integer getLeftPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLeftPos();
        }
        return this.leftpos;
    }

    public boolean isLeftPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLeftPosDirty();
        }
        return this.leftposDirtyFlag;
    }

    public void resetLeftPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLeftPos();
            return;
        }
        this.leftposDirtyFlag = false;
        this.leftpos = null;
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

    public void setNodeType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setNodeType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.nodetype = string;
        this.nodetypeDirtyFlag = true;
    }

    public String getNodeType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getNodeType();
        }
        return this.nodetype;
    }

    public boolean isNodeTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isNodeTypeDirty();
        }
        return this.nodetypeDirtyFlag;
    }

    public void resetNodeType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetNodeType();
            return;
        }
        this.nodetypeDirtyFlag = false;
        this.nodetype = null;
    }

    public void setPSSysActorId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorid = string;
        this.pssysactoridDirtyFlag = true;
    }

    public String getPSSysActorId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorId();
        }
        return this.pssysactorid;
    }

    public boolean isPSSysActorIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorIdDirty();
        }
        return this.pssysactoridDirtyFlag;
    }

    public void resetPSSysActorId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorId();
            return;
        }
        this.pssysactoridDirtyFlag = false;
        this.pssysactorid = null;
    }

    public void setPSSysActorName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysActorName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysactorname = string;
        this.pssysactornameDirtyFlag = true;
    }

    public String getPSSysActorName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActorName();
        }
        return this.pssysactorname;
    }

    public boolean isPSSysActorNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysActorNameDirty();
        }
        return this.pssysactornameDirtyFlag;
    }

    public void resetPSSysActorName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysActorName();
            return;
        }
        this.pssysactornameDirtyFlag = false;
        this.pssysactorname = null;
    }

    public void setPSSysUCMapId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapid = string;
        this.pssysucmapidDirtyFlag = true;
    }

    public String getPSSysUCMapId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapId();
        }
        return this.pssysucmapid;
    }

    public boolean isPSSysUCMapIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapIdDirty();
        }
        return this.pssysucmapidDirtyFlag;
    }

    public void resetPSSysUCMapId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapId();
            return;
        }
        this.pssysucmapidDirtyFlag = false;
        this.pssysucmapid = null;
    }

    public void setPSSysUCMapName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapname = string;
        this.pssysucmapnameDirtyFlag = true;
    }

    public String getPSSysUCMapName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapName();
        }
        return this.pssysucmapname;
    }

    public boolean isPSSysUCMapNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapNameDirty();
        }
        return this.pssysucmapnameDirtyFlag;
    }

    public void resetPSSysUCMapName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapName();
            return;
        }
        this.pssysucmapnameDirtyFlag = false;
        this.pssysucmapname = null;
    }

    public void setPSSysUCMapNodeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapNodeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapnodeid = string;
        this.pssysucmapnodeidDirtyFlag = true;
    }

    public String getPSSysUCMapNodeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapNodeId();
        }
        return this.pssysucmapnodeid;
    }

    public boolean isPSSysUCMapNodeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapNodeIdDirty();
        }
        return this.pssysucmapnodeidDirtyFlag;
    }

    public void resetPSSysUCMapNodeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapNodeId();
            return;
        }
        this.pssysucmapnodeidDirtyFlag = false;
        this.pssysucmapnodeid = null;
    }

    public void setPSSysUCMapNodeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUCMapNodeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysucmapnodename = string;
        this.pssysucmapnodenameDirtyFlag = true;
    }

    public String getPSSysUCMapNodeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMapNodeName();
        }
        return this.pssysucmapnodename;
    }

    public boolean isPSSysUCMapNodeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUCMapNodeNameDirty();
        }
        return this.pssysucmapnodenameDirtyFlag;
    }

    public void resetPSSysUCMapNodeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUCMapNodeName();
            return;
        }
        this.pssysucmapnodenameDirtyFlag = false;
        this.pssysucmapnodename = null;
    }

    public void setPSSysUserCaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercaseid = string;
        this.pssysusercaseidDirtyFlag = true;
    }

    public String getPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseId();
        }
        return this.pssysusercaseid;
    }

    public boolean isPSSysUserCaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseIdDirty();
        }
        return this.pssysusercaseidDirtyFlag;
    }

    public void resetPSSysUserCaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseId();
            return;
        }
        this.pssysusercaseidDirtyFlag = false;
        this.pssysusercaseid = null;
    }

    public void setPSSysUserCaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysUserCaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysusercasename = string;
        this.pssysusercasenameDirtyFlag = true;
    }

    public String getPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCaseName();
        }
        return this.pssysusercasename;
    }

    public boolean isPSSysUserCaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysUserCaseNameDirty();
        }
        return this.pssysusercasenameDirtyFlag;
    }

    public void resetPSSysUserCaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysUserCaseName();
            return;
        }
        this.pssysusercasenameDirtyFlag = false;
        this.pssysusercasename = null;
    }

    public void setTopPos(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTopPos(n);
            return;
        }
        this.toppos = n;
        this.topposDirtyFlag = true;
    }

    public Integer getTopPos() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTopPos();
        }
        return this.toppos;
    }

    public boolean isTopPosDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTopPosDirty();
        }
        return this.topposDirtyFlag;
    }

    public void resetTopPos() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTopPos();
            return;
        }
        this.topposDirtyFlag = false;
        this.toppos = null;
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

    protected void onReset() {
        PSSysUCMapNodeBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysUCMapNodeBase pSSysUCMapNodeBase) {
        pSSysUCMapNodeBase.resetCreateDate();
        pSSysUCMapNodeBase.resetCreateMan();
        pSSysUCMapNodeBase.resetLeftPos();
        pSSysUCMapNodeBase.resetMemo();
        pSSysUCMapNodeBase.resetNodeType();
        pSSysUCMapNodeBase.resetPSSysActorId();
        pSSysUCMapNodeBase.resetPSSysActorName();
        pSSysUCMapNodeBase.resetPSSysUCMapId();
        pSSysUCMapNodeBase.resetPSSysUCMapName();
        pSSysUCMapNodeBase.resetPSSysUCMapNodeId();
        pSSysUCMapNodeBase.resetPSSysUCMapNodeName();
        pSSysUCMapNodeBase.resetPSSysUserCaseId();
        pSSysUCMapNodeBase.resetPSSysUserCaseName();
        pSSysUCMapNodeBase.resetTopPos();
        pSSysUCMapNodeBase.resetUpdateDate();
        pSSysUCMapNodeBase.resetUpdateMan();
        pSSysUCMapNodeBase.resetUserCat();
        pSSysUCMapNodeBase.resetUserTag();
        pSSysUCMapNodeBase.resetUserTag2();
        pSSysUCMapNodeBase.resetUserTag3();
        pSSysUCMapNodeBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isLeftPosDirty()) {
            hashMap.put(FIELD_LEFTPOS, this.getLeftPos());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isNodeTypeDirty()) {
            hashMap.put(FIELD_NODETYPE, this.getNodeType());
        }
        if (!bl || this.isPSSysActorIdDirty()) {
            hashMap.put(FIELD_PSSYSACTORID, this.getPSSysActorId());
        }
        if (!bl || this.isPSSysActorNameDirty()) {
            hashMap.put(FIELD_PSSYSACTORNAME, this.getPSSysActorName());
        }
        if (!bl || this.isPSSysUCMapIdDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPID, this.getPSSysUCMapId());
        }
        if (!bl || this.isPSSysUCMapNameDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPNAME, this.getPSSysUCMapName());
        }
        if (!bl || this.isPSSysUCMapNodeIdDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPNODEID, this.getPSSysUCMapNodeId());
        }
        if (!bl || this.isPSSysUCMapNodeNameDirty()) {
            hashMap.put(FIELD_PSSYSUCMAPNODENAME, this.getPSSysUCMapNodeName());
        }
        if (!bl || this.isPSSysUserCaseIdDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASEID, this.getPSSysUserCaseId());
        }
        if (!bl || this.isPSSysUserCaseNameDirty()) {
            hashMap.put(FIELD_PSSYSUSERCASENAME, this.getPSSysUserCaseName());
        }
        if (!bl || this.isTopPosDirty()) {
            hashMap.put(FIELD_TOPPOS, this.getTopPos());
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
        return PSSysUCMapNodeBase.get(this, n);
    }

    private static Object get(PSSysUCMapNodeBase pSSysUCMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapNodeBase.getCreateDate();
            }
            case 1: {
                return pSSysUCMapNodeBase.getCreateMan();
            }
            case 2: {
                return pSSysUCMapNodeBase.getLeftPos();
            }
            case 3: {
                return pSSysUCMapNodeBase.getMemo();
            }
            case 4: {
                return pSSysUCMapNodeBase.getNodeType();
            }
            case 5: {
                return pSSysUCMapNodeBase.getPSSysActorId();
            }
            case 6: {
                return pSSysUCMapNodeBase.getPSSysActorName();
            }
            case 7: {
                return pSSysUCMapNodeBase.getPSSysUCMapId();
            }
            case 8: {
                return pSSysUCMapNodeBase.getPSSysUCMapName();
            }
            case 9: {
                return pSSysUCMapNodeBase.getPSSysUCMapNodeId();
            }
            case 10: {
                return pSSysUCMapNodeBase.getPSSysUCMapNodeName();
            }
            case 11: {
                return pSSysUCMapNodeBase.getPSSysUserCaseId();
            }
            case 12: {
                return pSSysUCMapNodeBase.getPSSysUserCaseName();
            }
            case 13: {
                return pSSysUCMapNodeBase.getTopPos();
            }
            case 14: {
                return pSSysUCMapNodeBase.getUpdateDate();
            }
            case 15: {
                return pSSysUCMapNodeBase.getUpdateMan();
            }
            case 16: {
                return pSSysUCMapNodeBase.getUserCat();
            }
            case 17: {
                return pSSysUCMapNodeBase.getUserTag();
            }
            case 18: {
                return pSSysUCMapNodeBase.getUserTag2();
            }
            case 19: {
                return pSSysUCMapNodeBase.getUserTag3();
            }
            case 20: {
                return pSSysUCMapNodeBase.getUserTag4();
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
        PSSysUCMapNodeBase.set(this, n, object);
    }

    private static void set(PSSysUCMapNodeBase pSSysUCMapNodeBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysUCMapNodeBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 1: {
                pSSysUCMapNodeBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysUCMapNodeBase.setLeftPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSSysUCMapNodeBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysUCMapNodeBase.setNodeType(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysUCMapNodeBase.setPSSysActorId(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysUCMapNodeBase.setPSSysActorName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysUCMapNodeBase.setPSSysUCMapId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSSysUCMapNodeBase.setPSSysUCMapName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysUCMapNodeBase.setPSSysUCMapNodeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysUCMapNodeBase.setPSSysUCMapNodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysUCMapNodeBase.setPSSysUserCaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysUCMapNodeBase.setPSSysUserCaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysUCMapNodeBase.setTopPos(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSSysUCMapNodeBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 15: {
                pSSysUCMapNodeBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysUCMapNodeBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSSysUCMapNodeBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysUCMapNodeBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysUCMapNodeBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysUCMapNodeBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysUCMapNodeBase.isNull(this, n);
    }

    private static boolean isNull(PSSysUCMapNodeBase pSSysUCMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapNodeBase.getCreateDate() == null;
            }
            case 1: {
                return pSSysUCMapNodeBase.getCreateMan() == null;
            }
            case 2: {
                return pSSysUCMapNodeBase.getLeftPos() == null;
            }
            case 3: {
                return pSSysUCMapNodeBase.getMemo() == null;
            }
            case 4: {
                return pSSysUCMapNodeBase.getNodeType() == null;
            }
            case 5: {
                return pSSysUCMapNodeBase.getPSSysActorId() == null;
            }
            case 6: {
                return pSSysUCMapNodeBase.getPSSysActorName() == null;
            }
            case 7: {
                return pSSysUCMapNodeBase.getPSSysUCMapId() == null;
            }
            case 8: {
                return pSSysUCMapNodeBase.getPSSysUCMapName() == null;
            }
            case 9: {
                return pSSysUCMapNodeBase.getPSSysUCMapNodeId() == null;
            }
            case 10: {
                return pSSysUCMapNodeBase.getPSSysUCMapNodeName() == null;
            }
            case 11: {
                return pSSysUCMapNodeBase.getPSSysUserCaseId() == null;
            }
            case 12: {
                return pSSysUCMapNodeBase.getPSSysUserCaseName() == null;
            }
            case 13: {
                return pSSysUCMapNodeBase.getTopPos() == null;
            }
            case 14: {
                return pSSysUCMapNodeBase.getUpdateDate() == null;
            }
            case 15: {
                return pSSysUCMapNodeBase.getUpdateMan() == null;
            }
            case 16: {
                return pSSysUCMapNodeBase.getUserCat() == null;
            }
            case 17: {
                return pSSysUCMapNodeBase.getUserTag() == null;
            }
            case 18: {
                return pSSysUCMapNodeBase.getUserTag2() == null;
            }
            case 19: {
                return pSSysUCMapNodeBase.getUserTag3() == null;
            }
            case 20: {
                return pSSysUCMapNodeBase.getUserTag4() == null;
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
        return PSSysUCMapNodeBase.contains(this, n);
    }

    private static boolean contains(PSSysUCMapNodeBase pSSysUCMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysUCMapNodeBase.isCreateDateDirty();
            }
            case 1: {
                return pSSysUCMapNodeBase.isCreateManDirty();
            }
            case 2: {
                return pSSysUCMapNodeBase.isLeftPosDirty();
            }
            case 3: {
                return pSSysUCMapNodeBase.isMemoDirty();
            }
            case 4: {
                return pSSysUCMapNodeBase.isNodeTypeDirty();
            }
            case 5: {
                return pSSysUCMapNodeBase.isPSSysActorIdDirty();
            }
            case 6: {
                return pSSysUCMapNodeBase.isPSSysActorNameDirty();
            }
            case 7: {
                return pSSysUCMapNodeBase.isPSSysUCMapIdDirty();
            }
            case 8: {
                return pSSysUCMapNodeBase.isPSSysUCMapNameDirty();
            }
            case 9: {
                return pSSysUCMapNodeBase.isPSSysUCMapNodeIdDirty();
            }
            case 10: {
                return pSSysUCMapNodeBase.isPSSysUCMapNodeNameDirty();
            }
            case 11: {
                return pSSysUCMapNodeBase.isPSSysUserCaseIdDirty();
            }
            case 12: {
                return pSSysUCMapNodeBase.isPSSysUserCaseNameDirty();
            }
            case 13: {
                return pSSysUCMapNodeBase.isTopPosDirty();
            }
            case 14: {
                return pSSysUCMapNodeBase.isUpdateDateDirty();
            }
            case 15: {
                return pSSysUCMapNodeBase.isUpdateManDirty();
            }
            case 16: {
                return pSSysUCMapNodeBase.isUserCatDirty();
            }
            case 17: {
                return pSSysUCMapNodeBase.isUserTagDirty();
            }
            case 18: {
                return pSSysUCMapNodeBase.isUserTag2Dirty();
            }
            case 19: {
                return pSSysUCMapNodeBase.isUserTag3Dirty();
            }
            case 20: {
                return pSSysUCMapNodeBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysUCMapNodeBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysUCMapNodeBase pSSysUCMapNodeBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysUCMapNodeBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getLeftPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"leftpos", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getLeftPos()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getNodeType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"nodetype", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getNodeType()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysActorId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorid", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysActorId()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysActorName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysactorname", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysActorName()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapid", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUCMapId()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapname", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUCMapName()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapnodeid", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUCMapNodeId()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysucmapnodename", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUCMapNodeName()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUserCaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercaseid", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUserCaseId()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUserCaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysusercasename", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getPSSysUserCaseName()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getTopPos() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"toppos", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getTopPos()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysUCMapNodeBase.getJSONValue((Object)pSSysUCMapNodeBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysUCMapNodeBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysUCMapNodeBase pSSysUCMapNodeBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysUCMapNodeBase.getCreateDate() != null) {
            object = pSSysUCMapNodeBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUCMapNodeBase.getCreateMan() != null) {
            object = pSSysUCMapNodeBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getLeftPos() != null) {
            object = pSSysUCMapNodeBase.getLeftPos();
            xmlNode.setAttribute(FIELD_LEFTPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUCMapNodeBase.getMemo() != null) {
            object = pSSysUCMapNodeBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getNodeType() != null) {
            object = pSSysUCMapNodeBase.getNodeType();
            xmlNode.setAttribute(FIELD_NODETYPE, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysActorId() != null) {
            object = pSSysUCMapNodeBase.getPSSysActorId();
            xmlNode.setAttribute(FIELD_PSSYSACTORID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysActorName() != null) {
            object = pSSysUCMapNodeBase.getPSSysActorName();
            xmlNode.setAttribute(FIELD_PSSYSACTORNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapId() != null) {
            object = pSSysUCMapNodeBase.getPSSysUCMapId();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapName() != null) {
            object = pSSysUCMapNodeBase.getPSSysUCMapName();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeId() != null) {
            object = pSSysUCMapNodeBase.getPSSysUCMapNodeId();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPNODEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeName() != null) {
            object = pSSysUCMapNodeBase.getPSSysUCMapNodeName();
            xmlNode.setAttribute(FIELD_PSSYSUCMAPNODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUserCaseId() != null) {
            object = pSSysUCMapNodeBase.getPSSysUserCaseId();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getPSSysUserCaseName() != null) {
            object = pSSysUCMapNodeBase.getPSSysUserCaseName();
            xmlNode.setAttribute(FIELD_PSSYSUSERCASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getTopPos() != null) {
            object = pSSysUCMapNodeBase.getTopPos();
            xmlNode.setAttribute(FIELD_TOPPOS, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSSysUCMapNodeBase.getUpdateDate() != null) {
            object = pSSysUCMapNodeBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysUCMapNodeBase.getUpdateMan() != null) {
            object = pSSysUCMapNodeBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getUserCat() != null) {
            object = pSSysUCMapNodeBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag() != null) {
            object = pSSysUCMapNodeBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag2() != null) {
            object = pSSysUCMapNodeBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag3() != null) {
            object = pSSysUCMapNodeBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysUCMapNodeBase.getUserTag4() != null) {
            object = pSSysUCMapNodeBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysUCMapNodeBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysUCMapNodeBase pSSysUCMapNodeBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysUCMapNodeBase.isCreateDateDirty() && (bl || pSSysUCMapNodeBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysUCMapNodeBase.getCreateDate());
        }
        if (pSSysUCMapNodeBase.isCreateManDirty() && (bl || pSSysUCMapNodeBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysUCMapNodeBase.getCreateMan());
        }
        if (pSSysUCMapNodeBase.isLeftPosDirty() && (bl || pSSysUCMapNodeBase.getLeftPos() != null)) {
            iDataObject.set(FIELD_LEFTPOS, (Object)pSSysUCMapNodeBase.getLeftPos());
        }
        if (pSSysUCMapNodeBase.isMemoDirty() && (bl || pSSysUCMapNodeBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysUCMapNodeBase.getMemo());
        }
        if (pSSysUCMapNodeBase.isNodeTypeDirty() && (bl || pSSysUCMapNodeBase.getNodeType() != null)) {
            iDataObject.set(FIELD_NODETYPE, (Object)pSSysUCMapNodeBase.getNodeType());
        }
        if (pSSysUCMapNodeBase.isPSSysActorIdDirty() && (bl || pSSysUCMapNodeBase.getPSSysActorId() != null)) {
            iDataObject.set(FIELD_PSSYSACTORID, (Object)pSSysUCMapNodeBase.getPSSysActorId());
        }
        if (pSSysUCMapNodeBase.isPSSysActorNameDirty() && (bl || pSSysUCMapNodeBase.getPSSysActorName() != null)) {
            iDataObject.set(FIELD_PSSYSACTORNAME, (Object)pSSysUCMapNodeBase.getPSSysActorName());
        }
        if (pSSysUCMapNodeBase.isPSSysUCMapIdDirty() && (bl || pSSysUCMapNodeBase.getPSSysUCMapId() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPID, (Object)pSSysUCMapNodeBase.getPSSysUCMapId());
        }
        if (pSSysUCMapNodeBase.isPSSysUCMapNameDirty() && (bl || pSSysUCMapNodeBase.getPSSysUCMapName() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPNAME, (Object)pSSysUCMapNodeBase.getPSSysUCMapName());
        }
        if (pSSysUCMapNodeBase.isPSSysUCMapNodeIdDirty() && (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeId() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPNODEID, (Object)pSSysUCMapNodeBase.getPSSysUCMapNodeId());
        }
        if (pSSysUCMapNodeBase.isPSSysUCMapNodeNameDirty() && (bl || pSSysUCMapNodeBase.getPSSysUCMapNodeName() != null)) {
            iDataObject.set(FIELD_PSSYSUCMAPNODENAME, (Object)pSSysUCMapNodeBase.getPSSysUCMapNodeName());
        }
        if (pSSysUCMapNodeBase.isPSSysUserCaseIdDirty() && (bl || pSSysUCMapNodeBase.getPSSysUserCaseId() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASEID, (Object)pSSysUCMapNodeBase.getPSSysUserCaseId());
        }
        if (pSSysUCMapNodeBase.isPSSysUserCaseNameDirty() && (bl || pSSysUCMapNodeBase.getPSSysUserCaseName() != null)) {
            iDataObject.set(FIELD_PSSYSUSERCASENAME, (Object)pSSysUCMapNodeBase.getPSSysUserCaseName());
        }
        if (pSSysUCMapNodeBase.isTopPosDirty() && (bl || pSSysUCMapNodeBase.getTopPos() != null)) {
            iDataObject.set(FIELD_TOPPOS, (Object)pSSysUCMapNodeBase.getTopPos());
        }
        if (pSSysUCMapNodeBase.isUpdateDateDirty() && (bl || pSSysUCMapNodeBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysUCMapNodeBase.getUpdateDate());
        }
        if (pSSysUCMapNodeBase.isUpdateManDirty() && (bl || pSSysUCMapNodeBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysUCMapNodeBase.getUpdateMan());
        }
        if (pSSysUCMapNodeBase.isUserCatDirty() && (bl || pSSysUCMapNodeBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysUCMapNodeBase.getUserCat());
        }
        if (pSSysUCMapNodeBase.isUserTagDirty() && (bl || pSSysUCMapNodeBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysUCMapNodeBase.getUserTag());
        }
        if (pSSysUCMapNodeBase.isUserTag2Dirty() && (bl || pSSysUCMapNodeBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysUCMapNodeBase.getUserTag2());
        }
        if (pSSysUCMapNodeBase.isUserTag3Dirty() && (bl || pSSysUCMapNodeBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysUCMapNodeBase.getUserTag3());
        }
        if (pSSysUCMapNodeBase.isUserTag4Dirty() && (bl || pSSysUCMapNodeBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysUCMapNodeBase.getUserTag4());
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
        return PSSysUCMapNodeBase.remove(this, n);
    }

    private static boolean remove(PSSysUCMapNodeBase pSSysUCMapNodeBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysUCMapNodeBase.resetCreateDate();
                return true;
            }
            case 1: {
                pSSysUCMapNodeBase.resetCreateMan();
                return true;
            }
            case 2: {
                pSSysUCMapNodeBase.resetLeftPos();
                return true;
            }
            case 3: {
                pSSysUCMapNodeBase.resetMemo();
                return true;
            }
            case 4: {
                pSSysUCMapNodeBase.resetNodeType();
                return true;
            }
            case 5: {
                pSSysUCMapNodeBase.resetPSSysActorId();
                return true;
            }
            case 6: {
                pSSysUCMapNodeBase.resetPSSysActorName();
                return true;
            }
            case 7: {
                pSSysUCMapNodeBase.resetPSSysUCMapId();
                return true;
            }
            case 8: {
                pSSysUCMapNodeBase.resetPSSysUCMapName();
                return true;
            }
            case 9: {
                pSSysUCMapNodeBase.resetPSSysUCMapNodeId();
                return true;
            }
            case 10: {
                pSSysUCMapNodeBase.resetPSSysUCMapNodeName();
                return true;
            }
            case 11: {
                pSSysUCMapNodeBase.resetPSSysUserCaseId();
                return true;
            }
            case 12: {
                pSSysUCMapNodeBase.resetPSSysUserCaseName();
                return true;
            }
            case 13: {
                pSSysUCMapNodeBase.resetTopPos();
                return true;
            }
            case 14: {
                pSSysUCMapNodeBase.resetUpdateDate();
                return true;
            }
            case 15: {
                pSSysUCMapNodeBase.resetUpdateMan();
                return true;
            }
            case 16: {
                pSSysUCMapNodeBase.resetUserCat();
                return true;
            }
            case 17: {
                pSSysUCMapNodeBase.resetUserTag();
                return true;
            }
            case 18: {
                pSSysUCMapNodeBase.resetUserTag2();
                return true;
            }
            case 19: {
                pSSysUCMapNodeBase.resetUserTag3();
                return true;
            }
            case 20: {
                pSSysUCMapNodeBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysActor getPSSysActor() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysActor();
        }
        if (this.getPSSysActorId() == null) {
            return null;
        }
        Integer n = this.objPSSysActorLock;
        synchronized (n) {
            if (this.pssysactor != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysActorId(), (Object)this.pssysactor.getPSSysActorId()) != 0L) {
                this.pssysactor = null;
            }
            if (this.pssysactor == null) {
                PSSysActor pSSysActor = new PSSysActor();
                pSSysActor.setPSSysActorId(this.getPSSysActorId());
                PSSysActorService pSSysActorService = (PSSysActorService)ServiceGlobal.getService(PSSysActorService.class, (SessionFactory)this.getSessionFactory());
                pSSysActorService.autoGet((IEntity)pSSysActor);
                this.pssysactor = pSSysActor;
            }
            return this.pssysactor;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUCMap getPSSysUCMap() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUCMap();
        }
        if (this.getPSSysUCMapId() == null) {
            return null;
        }
        Integer n = this.objPSSysUCMapLock;
        synchronized (n) {
            if (this.pssysucmap != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUCMapId(), (Object)this.pssysucmap.getPSSysUCMapId()) != 0L) {
                this.pssysucmap = null;
            }
            if (this.pssysucmap == null) {
                PSSysUCMap pSSysUCMap = new PSSysUCMap();
                pSSysUCMap.setPSSysUCMapId(this.getPSSysUCMapId());
                PSSysUCMapService pSSysUCMapService = (PSSysUCMapService)ServiceGlobal.getService(PSSysUCMapService.class, (SessionFactory)this.getSessionFactory());
                pSSysUCMapService.autoGet((IEntity)pSSysUCMap);
                this.pssysucmap = pSSysUCMap;
            }
            return this.pssysucmap;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSysUserCase getPSSysUserCase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysUserCase();
        }
        if (this.getPSSysUserCaseId() == null) {
            return null;
        }
        Integer n = this.objPSSysUserCaseLock;
        synchronized (n) {
            if (this.pssysusercase != null && DataTypeHelper.compare((int)25, (Object)this.getPSSysUserCaseId(), (Object)this.pssysusercase.getPSSysUserCaseId()) != 0L) {
                this.pssysusercase = null;
            }
            if (this.pssysusercase == null) {
                PSSysUserCase pSSysUserCase = new PSSysUserCase();
                pSSysUserCase.setPSSysUserCaseId(this.getPSSysUserCaseId());
                PSSysUserCaseService pSSysUserCaseService = (PSSysUserCaseService)ServiceGlobal.getService(PSSysUserCaseService.class, (SessionFactory)this.getSessionFactory());
                pSSysUserCaseService.autoGet((IEntity)pSSysUserCase);
                this.pssysusercase = pSSysUserCase;
            }
            return this.pssysusercase;
        }
    }

    private PSSysUCMapNodeBase getProxyEntity() {
        return this.proxyPSSysUCMapNodeBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysUCMapNodeBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysUCMapNodeBase) {
            this.proxyPSSysUCMapNodeBase = (PSSysUCMapNodeBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysUCMapNodeService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CREATEDATE, 0);
        fieldIndexMap.put(FIELD_CREATEMAN, 1);
        fieldIndexMap.put(FIELD_LEFTPOS, 2);
        fieldIndexMap.put(FIELD_MEMO, 3);
        fieldIndexMap.put(FIELD_NODETYPE, 4);
        fieldIndexMap.put(FIELD_PSSYSACTORID, 5);
        fieldIndexMap.put(FIELD_PSSYSACTORNAME, 6);
        fieldIndexMap.put(FIELD_PSSYSUCMAPID, 7);
        fieldIndexMap.put(FIELD_PSSYSUCMAPNAME, 8);
        fieldIndexMap.put(FIELD_PSSYSUCMAPNODEID, 9);
        fieldIndexMap.put(FIELD_PSSYSUCMAPNODENAME, 10);
        fieldIndexMap.put(FIELD_PSSYSUSERCASEID, 11);
        fieldIndexMap.put(FIELD_PSSYSUSERCASENAME, 12);
        fieldIndexMap.put(FIELD_TOPPOS, 13);
        fieldIndexMap.put(FIELD_UPDATEDATE, 14);
        fieldIndexMap.put(FIELD_UPDATEMAN, 15);
        fieldIndexMap.put(FIELD_USERCAT, 16);
        fieldIndexMap.put(FIELD_USERTAG, 17);
        fieldIndexMap.put(FIELD_USERTAG2, 18);
        fieldIndexMap.put(FIELD_USERTAG3, 19);
        fieldIndexMap.put(FIELD_USERTAG4, 20);
    }
}

