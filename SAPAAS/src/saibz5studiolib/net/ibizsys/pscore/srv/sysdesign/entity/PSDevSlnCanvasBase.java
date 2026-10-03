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
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSln;
import net.ibizsys.pscore.srv.sysdesign.entity.PSDevSlnSys;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnService;
import net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnSysService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDevSlnCanvasBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDevSlnCanvasBase.class);
    public static final String FIELD_CANVASMODEL = "CANVASMODEL";
    public static final String FIELD_CANVASTAG = "CANVASTAG";
    public static final String FIELD_CANVASTAG2 = "CANVASTAG2";
    public static final String FIELD_CANVASTAG3 = "CANVASTAG3";
    public static final String FIELD_CANVASTAG4 = "CANVASTAG4";
    public static final String FIELD_CANVASTYPE = "CANVASTYPE";
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODEL = "MODEL";
    public static final String FIELD_PSDEVSLNCANVASID = "PSDEVSLNCANVASID";
    public static final String FIELD_PSDEVSLNCANVASNAME = "PSDEVSLNCANVASNAME";
    public static final String FIELD_PSDEVSLNID = "PSDEVSLNID";
    public static final String FIELD_PSDEVSLNNAME = "PSDEVSLNNAME";
    public static final String FIELD_PSDEVSLNSYSID = "PSDEVSLNSYSID";
    public static final String FIELD_PSDEVSLNSYSNAME = "PSDEVSLNSYSNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    private static final int INDEX_CANVASMODEL = 0;
    private static final int INDEX_CANVASTAG = 1;
    private static final int INDEX_CANVASTAG2 = 2;
    private static final int INDEX_CANVASTAG3 = 3;
    private static final int INDEX_CANVASTAG4 = 4;
    private static final int INDEX_CANVASTYPE = 5;
    private static final int INDEX_CODENAME = 6;
    private static final int INDEX_CREATEDATE = 7;
    private static final int INDEX_CREATEMAN = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_MODEL = 10;
    private static final int INDEX_PSDEVSLNCANVASID = 11;
    private static final int INDEX_PSDEVSLNCANVASNAME = 12;
    private static final int INDEX_PSDEVSLNID = 13;
    private static final int INDEX_PSDEVSLNNAME = 14;
    private static final int INDEX_PSDEVSLNSYSID = 15;
    private static final int INDEX_PSDEVSLNSYSNAME = 16;
    private static final int INDEX_UPDATEDATE = 17;
    private static final int INDEX_UPDATEMAN = 18;
    private static final int INDEX_USERCAT = 19;
    private static final int INDEX_USERTAG = 20;
    private static final int INDEX_USERTAG2 = 21;
    private static final int INDEX_USERTAG3 = 22;
    private static final int INDEX_USERTAG4 = 23;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDevSlnCanvasBase proxyPSDevSlnCanvasBase = null;
    private boolean canvasmodelDirtyFlag = false;
    private boolean canvastagDirtyFlag = false;
    private boolean canvastag2DirtyFlag = false;
    private boolean canvastag3DirtyFlag = false;
    private boolean canvastag4DirtyFlag = false;
    private boolean canvastypeDirtyFlag = false;
    private boolean codenameDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelDirtyFlag = false;
    private boolean psdevslncanvasidDirtyFlag = false;
    private boolean psdevslncanvasnameDirtyFlag = false;
    private boolean psdevslnidDirtyFlag = false;
    private boolean psdevslnnameDirtyFlag = false;
    private boolean psdevslnsysidDirtyFlag = false;
    private boolean psdevslnsysnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    @Column(name="canvasmodel")
    private String canvasmodel;
    @Column(name="canvastag")
    private String canvastag;
    @Column(name="canvastag2")
    private String canvastag2;
    @Column(name="canvastag3")
    private String canvastag3;
    @Column(name="canvastag4")
    private String canvastag4;
    @Column(name="canvastype")
    private String canvastype;
    @Column(name="codename")
    private String codename;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="memo")
    private String memo;
    @Column(name="model")
    private String model;
    @Column(name="psdevslncanvasid")
    private String psdevslncanvasid;
    @Column(name="psdevslncanvasname")
    private String psdevslncanvasname;
    @Column(name="psdevslnid")
    private String psdevslnid;
    @Column(name="psdevslnname")
    private String psdevslnname;
    @Column(name="psdevslnsysid")
    private String psdevslnsysid;
    @Column(name="psdevslnsysname")
    private String psdevslnsysname;
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
    private Integer objPSDevSlnSysLock = new Integer(1);
    private PSDevSlnSys psdevslnsys = null;
    private Integer objPSDevSlnLock = new Integer(1);
    private PSDevSln psdevsln = null;

    public void setCanvasModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvasmodel = string;
        this.canvasmodelDirtyFlag = true;
    }

    public String getCanvasModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasModel();
        }
        return this.canvasmodel;
    }

    public boolean isCanvasModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasModelDirty();
        }
        return this.canvasmodelDirtyFlag;
    }

    public void resetCanvasModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasModel();
            return;
        }
        this.canvasmodelDirtyFlag = false;
        this.canvasmodel = null;
    }

    public void setCanvasTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvastag = string;
        this.canvastagDirtyFlag = true;
    }

    public String getCanvasTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasTag();
        }
        return this.canvastag;
    }

    public boolean isCanvasTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasTagDirty();
        }
        return this.canvastagDirtyFlag;
    }

    public void resetCanvasTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasTag();
            return;
        }
        this.canvastagDirtyFlag = false;
        this.canvastag = null;
    }

    public void setCanvasTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvastag2 = string;
        this.canvastag2DirtyFlag = true;
    }

    public String getCanvasTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasTag2();
        }
        return this.canvastag2;
    }

    public boolean isCanvasTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasTag2Dirty();
        }
        return this.canvastag2DirtyFlag;
    }

    public void resetCanvasTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasTag2();
            return;
        }
        this.canvastag2DirtyFlag = false;
        this.canvastag2 = null;
    }

    public void setCanvasTag3(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasTag3(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvastag3 = string;
        this.canvastag3DirtyFlag = true;
    }

    public String getCanvasTag3() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasTag3();
        }
        return this.canvastag3;
    }

    public boolean isCanvasTag3Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasTag3Dirty();
        }
        return this.canvastag3DirtyFlag;
    }

    public void resetCanvasTag3() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasTag3();
            return;
        }
        this.canvastag3DirtyFlag = false;
        this.canvastag3 = null;
    }

    public void setCanvasTag4(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasTag4(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvastag4 = string;
        this.canvastag4DirtyFlag = true;
    }

    public String getCanvasTag4() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasTag4();
        }
        return this.canvastag4;
    }

    public boolean isCanvasTag4Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasTag4Dirty();
        }
        return this.canvastag4DirtyFlag;
    }

    public void resetCanvasTag4() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasTag4();
            return;
        }
        this.canvastag4DirtyFlag = false;
        this.canvastag4 = null;
    }

    public void setCanvasType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCanvasType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.canvastype = string;
        this.canvastypeDirtyFlag = true;
    }

    public String getCanvasType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCanvasType();
        }
        return this.canvastype;
    }

    public boolean isCanvasTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCanvasTypeDirty();
        }
        return this.canvastypeDirtyFlag;
    }

    public void resetCanvasType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCanvasType();
            return;
        }
        this.canvastypeDirtyFlag = false;
        this.canvastype = null;
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

    public void setModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.model = string;
        this.modelDirtyFlag = true;
    }

    public String getModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModel();
        }
        return this.model;
    }

    public boolean isModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDirty();
        }
        return this.modelDirtyFlag;
    }

    public void resetModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModel();
            return;
        }
        this.modelDirtyFlag = false;
        this.model = null;
    }

    public void setPSDevSlnCanvasId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCanvasId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncanvasid = string;
        this.psdevslncanvasidDirtyFlag = true;
    }

    public String getPSDevSlnCanvasId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCanvasId();
        }
        return this.psdevslncanvasid;
    }

    public boolean isPSDevSlnCanvasIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCanvasIdDirty();
        }
        return this.psdevslncanvasidDirtyFlag;
    }

    public void resetPSDevSlnCanvasId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCanvasId();
            return;
        }
        this.psdevslncanvasidDirtyFlag = false;
        this.psdevslncanvasid = null;
    }

    public void setPSDevSlnCanvasName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnCanvasName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslncanvasname = string;
        this.psdevslncanvasnameDirtyFlag = true;
    }

    public String getPSDevSlnCanvasName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnCanvasName();
        }
        return this.psdevslncanvasname;
    }

    public boolean isPSDevSlnCanvasNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnCanvasNameDirty();
        }
        return this.psdevslncanvasnameDirtyFlag;
    }

    public void resetPSDevSlnCanvasName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnCanvasName();
            return;
        }
        this.psdevslncanvasnameDirtyFlag = false;
        this.psdevslncanvasname = null;
    }

    public void setPSDevSlnId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnid = string;
        this.psdevslnidDirtyFlag = true;
    }

    public String getPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnId();
        }
        return this.psdevslnid;
    }

    public boolean isPSDevSlnIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnIdDirty();
        }
        return this.psdevslnidDirtyFlag;
    }

    public void resetPSDevSlnId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnId();
            return;
        }
        this.psdevslnidDirtyFlag = false;
        this.psdevslnid = null;
    }

    public void setPSDevSlnName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnname = string;
        this.psdevslnnameDirtyFlag = true;
    }

    public String getPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnName();
        }
        return this.psdevslnname;
    }

    public boolean isPSDevSlnNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnNameDirty();
        }
        return this.psdevslnnameDirtyFlag;
    }

    public void resetPSDevSlnName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnName();
            return;
        }
        this.psdevslnnameDirtyFlag = false;
        this.psdevslnname = null;
    }

    public void setPSDevSlnSysId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysid = string;
        this.psdevslnsysidDirtyFlag = true;
    }

    public String getPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysId();
        }
        return this.psdevslnsysid;
    }

    public boolean isPSDevSlnSysIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysIdDirty();
        }
        return this.psdevslnsysidDirtyFlag;
    }

    public void resetPSDevSlnSysId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysId();
            return;
        }
        this.psdevslnsysidDirtyFlag = false;
        this.psdevslnsysid = null;
    }

    public void setPSDevSlnSysName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDevSlnSysName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdevslnsysname = string;
        this.psdevslnsysnameDirtyFlag = true;
    }

    public String getPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSysName();
        }
        return this.psdevslnsysname;
    }

    public boolean isPSDevSlnSysNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDevSlnSysNameDirty();
        }
        return this.psdevslnsysnameDirtyFlag;
    }

    public void resetPSDevSlnSysName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDevSlnSysName();
            return;
        }
        this.psdevslnsysnameDirtyFlag = false;
        this.psdevslnsysname = null;
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
        PSDevSlnCanvasBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDevSlnCanvasBase pSDevSlnCanvasBase) {
        pSDevSlnCanvasBase.resetCanvasModel();
        pSDevSlnCanvasBase.resetCanvasTag();
        pSDevSlnCanvasBase.resetCanvasTag2();
        pSDevSlnCanvasBase.resetCanvasTag3();
        pSDevSlnCanvasBase.resetCanvasTag4();
        pSDevSlnCanvasBase.resetCanvasType();
        pSDevSlnCanvasBase.resetCodeName();
        pSDevSlnCanvasBase.resetCreateDate();
        pSDevSlnCanvasBase.resetCreateMan();
        pSDevSlnCanvasBase.resetMemo();
        pSDevSlnCanvasBase.resetModel();
        pSDevSlnCanvasBase.resetPSDevSlnCanvasId();
        pSDevSlnCanvasBase.resetPSDevSlnCanvasName();
        pSDevSlnCanvasBase.resetPSDevSlnId();
        pSDevSlnCanvasBase.resetPSDevSlnName();
        pSDevSlnCanvasBase.resetPSDevSlnSysId();
        pSDevSlnCanvasBase.resetPSDevSlnSysName();
        pSDevSlnCanvasBase.resetUpdateDate();
        pSDevSlnCanvasBase.resetUpdateMan();
        pSDevSlnCanvasBase.resetUserCat();
        pSDevSlnCanvasBase.resetUserTag();
        pSDevSlnCanvasBase.resetUserTag2();
        pSDevSlnCanvasBase.resetUserTag3();
        pSDevSlnCanvasBase.resetUserTag4();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCanvasModelDirty()) {
            hashMap.put(FIELD_CANVASMODEL, this.getCanvasModel());
        }
        if (!bl || this.isCanvasTagDirty()) {
            hashMap.put(FIELD_CANVASTAG, this.getCanvasTag());
        }
        if (!bl || this.isCanvasTag2Dirty()) {
            hashMap.put(FIELD_CANVASTAG2, this.getCanvasTag2());
        }
        if (!bl || this.isCanvasTag3Dirty()) {
            hashMap.put(FIELD_CANVASTAG3, this.getCanvasTag3());
        }
        if (!bl || this.isCanvasTag4Dirty()) {
            hashMap.put(FIELD_CANVASTAG4, this.getCanvasTag4());
        }
        if (!bl || this.isCanvasTypeDirty()) {
            hashMap.put(FIELD_CANVASTYPE, this.getCanvasType());
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
        if (!bl || this.isModelDirty()) {
            hashMap.put(FIELD_MODEL, this.getModel());
        }
        if (!bl || this.isPSDevSlnCanvasIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNCANVASID, this.getPSDevSlnCanvasId());
        }
        if (!bl || this.isPSDevSlnCanvasNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNCANVASNAME, this.getPSDevSlnCanvasName());
        }
        if (!bl || this.isPSDevSlnIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNID, this.getPSDevSlnId());
        }
        if (!bl || this.isPSDevSlnNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNNAME, this.getPSDevSlnName());
        }
        if (!bl || this.isPSDevSlnSysIdDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSID, this.getPSDevSlnSysId());
        }
        if (!bl || this.isPSDevSlnSysNameDirty()) {
            hashMap.put(FIELD_PSDEVSLNSYSNAME, this.getPSDevSlnSysName());
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
        return PSDevSlnCanvasBase.get(this, n);
    }

    private static Object get(PSDevSlnCanvasBase pSDevSlnCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCanvasBase.getCanvasModel();
            }
            case 1: {
                return pSDevSlnCanvasBase.getCanvasTag();
            }
            case 2: {
                return pSDevSlnCanvasBase.getCanvasTag2();
            }
            case 3: {
                return pSDevSlnCanvasBase.getCanvasTag3();
            }
            case 4: {
                return pSDevSlnCanvasBase.getCanvasTag4();
            }
            case 5: {
                return pSDevSlnCanvasBase.getCanvasType();
            }
            case 6: {
                return pSDevSlnCanvasBase.getCodeName();
            }
            case 7: {
                return pSDevSlnCanvasBase.getCreateDate();
            }
            case 8: {
                return pSDevSlnCanvasBase.getCreateMan();
            }
            case 9: {
                return pSDevSlnCanvasBase.getMemo();
            }
            case 10: {
                return pSDevSlnCanvasBase.getModel();
            }
            case 11: {
                return pSDevSlnCanvasBase.getPSDevSlnCanvasId();
            }
            case 12: {
                return pSDevSlnCanvasBase.getPSDevSlnCanvasName();
            }
            case 13: {
                return pSDevSlnCanvasBase.getPSDevSlnId();
            }
            case 14: {
                return pSDevSlnCanvasBase.getPSDevSlnName();
            }
            case 15: {
                return pSDevSlnCanvasBase.getPSDevSlnSysId();
            }
            case 16: {
                return pSDevSlnCanvasBase.getPSDevSlnSysName();
            }
            case 17: {
                return pSDevSlnCanvasBase.getUpdateDate();
            }
            case 18: {
                return pSDevSlnCanvasBase.getUpdateMan();
            }
            case 19: {
                return pSDevSlnCanvasBase.getUserCat();
            }
            case 20: {
                return pSDevSlnCanvasBase.getUserTag();
            }
            case 21: {
                return pSDevSlnCanvasBase.getUserTag2();
            }
            case 22: {
                return pSDevSlnCanvasBase.getUserTag3();
            }
            case 23: {
                return pSDevSlnCanvasBase.getUserTag4();
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
        PSDevSlnCanvasBase.set(this, n, object);
    }

    private static void set(PSDevSlnCanvasBase pSDevSlnCanvasBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCanvasBase.setCanvasModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDevSlnCanvasBase.setCanvasTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDevSlnCanvasBase.setCanvasTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSDevSlnCanvasBase.setCanvasTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDevSlnCanvasBase.setCanvasTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDevSlnCanvasBase.setCanvasType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDevSlnCanvasBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDevSlnCanvasBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSDevSlnCanvasBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDevSlnCanvasBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDevSlnCanvasBase.setModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDevSlnCanvasBase.setPSDevSlnCanvasId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDevSlnCanvasBase.setPSDevSlnCanvasName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDevSlnCanvasBase.setPSDevSlnId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDevSlnCanvasBase.setPSDevSlnName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDevSlnCanvasBase.setPSDevSlnSysId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDevSlnCanvasBase.setPSDevSlnSysName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDevSlnCanvasBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 18: {
                pSDevSlnCanvasBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSDevSlnCanvasBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDevSlnCanvasBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDevSlnCanvasBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDevSlnCanvasBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDevSlnCanvasBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSDevSlnCanvasBase.isNull(this, n);
    }

    private static boolean isNull(PSDevSlnCanvasBase pSDevSlnCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCanvasBase.getCanvasModel() == null;
            }
            case 1: {
                return pSDevSlnCanvasBase.getCanvasTag() == null;
            }
            case 2: {
                return pSDevSlnCanvasBase.getCanvasTag2() == null;
            }
            case 3: {
                return pSDevSlnCanvasBase.getCanvasTag3() == null;
            }
            case 4: {
                return pSDevSlnCanvasBase.getCanvasTag4() == null;
            }
            case 5: {
                return pSDevSlnCanvasBase.getCanvasType() == null;
            }
            case 6: {
                return pSDevSlnCanvasBase.getCodeName() == null;
            }
            case 7: {
                return pSDevSlnCanvasBase.getCreateDate() == null;
            }
            case 8: {
                return pSDevSlnCanvasBase.getCreateMan() == null;
            }
            case 9: {
                return pSDevSlnCanvasBase.getMemo() == null;
            }
            case 10: {
                return pSDevSlnCanvasBase.getModel() == null;
            }
            case 11: {
                return pSDevSlnCanvasBase.getPSDevSlnCanvasId() == null;
            }
            case 12: {
                return pSDevSlnCanvasBase.getPSDevSlnCanvasName() == null;
            }
            case 13: {
                return pSDevSlnCanvasBase.getPSDevSlnId() == null;
            }
            case 14: {
                return pSDevSlnCanvasBase.getPSDevSlnName() == null;
            }
            case 15: {
                return pSDevSlnCanvasBase.getPSDevSlnSysId() == null;
            }
            case 16: {
                return pSDevSlnCanvasBase.getPSDevSlnSysName() == null;
            }
            case 17: {
                return pSDevSlnCanvasBase.getUpdateDate() == null;
            }
            case 18: {
                return pSDevSlnCanvasBase.getUpdateMan() == null;
            }
            case 19: {
                return pSDevSlnCanvasBase.getUserCat() == null;
            }
            case 20: {
                return pSDevSlnCanvasBase.getUserTag() == null;
            }
            case 21: {
                return pSDevSlnCanvasBase.getUserTag2() == null;
            }
            case 22: {
                return pSDevSlnCanvasBase.getUserTag3() == null;
            }
            case 23: {
                return pSDevSlnCanvasBase.getUserTag4() == null;
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
        return PSDevSlnCanvasBase.contains(this, n);
    }

    private static boolean contains(PSDevSlnCanvasBase pSDevSlnCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDevSlnCanvasBase.isCanvasModelDirty();
            }
            case 1: {
                return pSDevSlnCanvasBase.isCanvasTagDirty();
            }
            case 2: {
                return pSDevSlnCanvasBase.isCanvasTag2Dirty();
            }
            case 3: {
                return pSDevSlnCanvasBase.isCanvasTag3Dirty();
            }
            case 4: {
                return pSDevSlnCanvasBase.isCanvasTag4Dirty();
            }
            case 5: {
                return pSDevSlnCanvasBase.isCanvasTypeDirty();
            }
            case 6: {
                return pSDevSlnCanvasBase.isCodeNameDirty();
            }
            case 7: {
                return pSDevSlnCanvasBase.isCreateDateDirty();
            }
            case 8: {
                return pSDevSlnCanvasBase.isCreateManDirty();
            }
            case 9: {
                return pSDevSlnCanvasBase.isMemoDirty();
            }
            case 10: {
                return pSDevSlnCanvasBase.isModelDirty();
            }
            case 11: {
                return pSDevSlnCanvasBase.isPSDevSlnCanvasIdDirty();
            }
            case 12: {
                return pSDevSlnCanvasBase.isPSDevSlnCanvasNameDirty();
            }
            case 13: {
                return pSDevSlnCanvasBase.isPSDevSlnIdDirty();
            }
            case 14: {
                return pSDevSlnCanvasBase.isPSDevSlnNameDirty();
            }
            case 15: {
                return pSDevSlnCanvasBase.isPSDevSlnSysIdDirty();
            }
            case 16: {
                return pSDevSlnCanvasBase.isPSDevSlnSysNameDirty();
            }
            case 17: {
                return pSDevSlnCanvasBase.isUpdateDateDirty();
            }
            case 18: {
                return pSDevSlnCanvasBase.isUpdateManDirty();
            }
            case 19: {
                return pSDevSlnCanvasBase.isUserCatDirty();
            }
            case 20: {
                return pSDevSlnCanvasBase.isUserTagDirty();
            }
            case 21: {
                return pSDevSlnCanvasBase.isUserTag2Dirty();
            }
            case 22: {
                return pSDevSlnCanvasBase.isUserTag3Dirty();
            }
            case 23: {
                return pSDevSlnCanvasBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDevSlnCanvasBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDevSlnCanvasBase pSDevSlnCanvasBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDevSlnCanvasBase.getCanvasModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvasmodel", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasModel()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasTag()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag2", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasTag2()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag3", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasTag3()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag4", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasTag4()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCanvasType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastype", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCanvasType()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getMemo()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"model", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getModel()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncanvasid", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnCanvasId()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslncanvasname", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnCanvasName()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnid", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnId()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnname", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnName()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnSysId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysid", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnSysId()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnSysName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdevslnsysname", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getPSDevSlnSysName()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDevSlnCanvasBase.getJSONValue((Object)pSDevSlnCanvasBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDevSlnCanvasBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDevSlnCanvasBase pSDevSlnCanvasBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDevSlnCanvasBase.getCanvasModel() != null) {
            object = pSDevSlnCanvasBase.getCanvasModel();
            xmlNode.setAttribute(FIELD_CANVASMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag() != null) {
            object = pSDevSlnCanvasBase.getCanvasTag();
            xmlNode.setAttribute(FIELD_CANVASTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag2() != null) {
            object = pSDevSlnCanvasBase.getCanvasTag2();
            xmlNode.setAttribute(FIELD_CANVASTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag3() != null) {
            object = pSDevSlnCanvasBase.getCanvasTag3();
            xmlNode.setAttribute(FIELD_CANVASTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCanvasTag4() != null) {
            object = pSDevSlnCanvasBase.getCanvasTag4();
            xmlNode.setAttribute(FIELD_CANVASTAG4, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCanvasType() != null) {
            object = pSDevSlnCanvasBase.getCanvasType();
            xmlNode.setAttribute(FIELD_CANVASTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSDevSlnCanvasBase.getCodeName() != null) {
            object = pSDevSlnCanvasBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getCreateDate() != null) {
            object = pSDevSlnCanvasBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCanvasBase.getCreateMan() != null) {
            object = pSDevSlnCanvasBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getMemo() != null) {
            object = pSDevSlnCanvasBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getModel() != null) {
            object = pSDevSlnCanvasBase.getModel();
            xmlNode.setAttribute(FIELD_MODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasId() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnCanvasId();
            xmlNode.setAttribute(FIELD_PSDEVSLNCANVASID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasName() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnCanvasName();
            xmlNode.setAttribute(FIELD_PSDEVSLNCANVASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnId() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnId();
            xmlNode.setAttribute(FIELD_PSDEVSLNID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnName() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnName();
            xmlNode.setAttribute(FIELD_PSDEVSLNNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnSysId() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnSysId();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSID, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getPSDevSlnSysName() != null) {
            object = pSDevSlnCanvasBase.getPSDevSlnSysName();
            xmlNode.setAttribute(FIELD_PSDEVSLNSYSNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUpdateDate() != null) {
            object = pSDevSlnCanvasBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDevSlnCanvasBase.getUpdateMan() != null) {
            object = pSDevSlnCanvasBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUserCat() != null) {
            object = pSDevSlnCanvasBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag() != null) {
            object = pSDevSlnCanvasBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag2() != null) {
            object = pSDevSlnCanvasBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag3() != null) {
            object = pSDevSlnCanvasBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDevSlnCanvasBase.getUserTag4() != null) {
            object = pSDevSlnCanvasBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDevSlnCanvasBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDevSlnCanvasBase pSDevSlnCanvasBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDevSlnCanvasBase.isCanvasModelDirty() && (bl || pSDevSlnCanvasBase.getCanvasModel() != null)) {
            iDataObject.set(FIELD_CANVASMODEL, (Object)pSDevSlnCanvasBase.getCanvasModel());
        }
        if (pSDevSlnCanvasBase.isCanvasTagDirty() && (bl || pSDevSlnCanvasBase.getCanvasTag() != null)) {
            iDataObject.set(FIELD_CANVASTAG, (Object)pSDevSlnCanvasBase.getCanvasTag());
        }
        if (pSDevSlnCanvasBase.isCanvasTag2Dirty() && (bl || pSDevSlnCanvasBase.getCanvasTag2() != null)) {
            iDataObject.set(FIELD_CANVASTAG2, (Object)pSDevSlnCanvasBase.getCanvasTag2());
        }
        if (pSDevSlnCanvasBase.isCanvasTag3Dirty() && (bl || pSDevSlnCanvasBase.getCanvasTag3() != null)) {
            iDataObject.set(FIELD_CANVASTAG3, (Object)pSDevSlnCanvasBase.getCanvasTag3());
        }
        if (pSDevSlnCanvasBase.isCanvasTag4Dirty() && (bl || pSDevSlnCanvasBase.getCanvasTag4() != null)) {
            iDataObject.set(FIELD_CANVASTAG4, (Object)pSDevSlnCanvasBase.getCanvasTag4());
        }
        if (pSDevSlnCanvasBase.isCanvasTypeDirty() && (bl || pSDevSlnCanvasBase.getCanvasType() != null)) {
            iDataObject.set(FIELD_CANVASTYPE, (Object)pSDevSlnCanvasBase.getCanvasType());
        }
        if (pSDevSlnCanvasBase.isCodeNameDirty() && (bl || pSDevSlnCanvasBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDevSlnCanvasBase.getCodeName());
        }
        if (pSDevSlnCanvasBase.isCreateDateDirty() && (bl || pSDevSlnCanvasBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDevSlnCanvasBase.getCreateDate());
        }
        if (pSDevSlnCanvasBase.isCreateManDirty() && (bl || pSDevSlnCanvasBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDevSlnCanvasBase.getCreateMan());
        }
        if (pSDevSlnCanvasBase.isMemoDirty() && (bl || pSDevSlnCanvasBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDevSlnCanvasBase.getMemo());
        }
        if (pSDevSlnCanvasBase.isModelDirty() && (bl || pSDevSlnCanvasBase.getModel() != null)) {
            iDataObject.set(FIELD_MODEL, (Object)pSDevSlnCanvasBase.getModel());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnCanvasIdDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCANVASID, (Object)pSDevSlnCanvasBase.getPSDevSlnCanvasId());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnCanvasNameDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnCanvasName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNCANVASNAME, (Object)pSDevSlnCanvasBase.getPSDevSlnCanvasName());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnIdDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNID, (Object)pSDevSlnCanvasBase.getPSDevSlnId());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnNameDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNNAME, (Object)pSDevSlnCanvasBase.getPSDevSlnName());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnSysIdDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnSysId() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSID, (Object)pSDevSlnCanvasBase.getPSDevSlnSysId());
        }
        if (pSDevSlnCanvasBase.isPSDevSlnSysNameDirty() && (bl || pSDevSlnCanvasBase.getPSDevSlnSysName() != null)) {
            iDataObject.set(FIELD_PSDEVSLNSYSNAME, (Object)pSDevSlnCanvasBase.getPSDevSlnSysName());
        }
        if (pSDevSlnCanvasBase.isUpdateDateDirty() && (bl || pSDevSlnCanvasBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDevSlnCanvasBase.getUpdateDate());
        }
        if (pSDevSlnCanvasBase.isUpdateManDirty() && (bl || pSDevSlnCanvasBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDevSlnCanvasBase.getUpdateMan());
        }
        if (pSDevSlnCanvasBase.isUserCatDirty() && (bl || pSDevSlnCanvasBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDevSlnCanvasBase.getUserCat());
        }
        if (pSDevSlnCanvasBase.isUserTagDirty() && (bl || pSDevSlnCanvasBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDevSlnCanvasBase.getUserTag());
        }
        if (pSDevSlnCanvasBase.isUserTag2Dirty() && (bl || pSDevSlnCanvasBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDevSlnCanvasBase.getUserTag2());
        }
        if (pSDevSlnCanvasBase.isUserTag3Dirty() && (bl || pSDevSlnCanvasBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDevSlnCanvasBase.getUserTag3());
        }
        if (pSDevSlnCanvasBase.isUserTag4Dirty() && (bl || pSDevSlnCanvasBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDevSlnCanvasBase.getUserTag4());
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
        return PSDevSlnCanvasBase.remove(this, n);
    }

    private static boolean remove(PSDevSlnCanvasBase pSDevSlnCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDevSlnCanvasBase.resetCanvasModel();
                return true;
            }
            case 1: {
                pSDevSlnCanvasBase.resetCanvasTag();
                return true;
            }
            case 2: {
                pSDevSlnCanvasBase.resetCanvasTag2();
                return true;
            }
            case 3: {
                pSDevSlnCanvasBase.resetCanvasTag3();
                return true;
            }
            case 4: {
                pSDevSlnCanvasBase.resetCanvasTag4();
                return true;
            }
            case 5: {
                pSDevSlnCanvasBase.resetCanvasType();
                return true;
            }
            case 6: {
                pSDevSlnCanvasBase.resetCodeName();
                return true;
            }
            case 7: {
                pSDevSlnCanvasBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSDevSlnCanvasBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSDevSlnCanvasBase.resetMemo();
                return true;
            }
            case 10: {
                pSDevSlnCanvasBase.resetModel();
                return true;
            }
            case 11: {
                pSDevSlnCanvasBase.resetPSDevSlnCanvasId();
                return true;
            }
            case 12: {
                pSDevSlnCanvasBase.resetPSDevSlnCanvasName();
                return true;
            }
            case 13: {
                pSDevSlnCanvasBase.resetPSDevSlnId();
                return true;
            }
            case 14: {
                pSDevSlnCanvasBase.resetPSDevSlnName();
                return true;
            }
            case 15: {
                pSDevSlnCanvasBase.resetPSDevSlnSysId();
                return true;
            }
            case 16: {
                pSDevSlnCanvasBase.resetPSDevSlnSysName();
                return true;
            }
            case 17: {
                pSDevSlnCanvasBase.resetUpdateDate();
                return true;
            }
            case 18: {
                pSDevSlnCanvasBase.resetUpdateMan();
                return true;
            }
            case 19: {
                pSDevSlnCanvasBase.resetUserCat();
                return true;
            }
            case 20: {
                pSDevSlnCanvasBase.resetUserTag();
                return true;
            }
            case 21: {
                pSDevSlnCanvasBase.resetUserTag2();
                return true;
            }
            case 22: {
                pSDevSlnCanvasBase.resetUserTag3();
                return true;
            }
            case 23: {
                pSDevSlnCanvasBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSlnSys getPSDevSlnSys() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSlnSys();
        }
        if (this.getPSDevSlnSysId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnSysLock;
        synchronized (n) {
            if (this.psdevslnsys != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnSysId(), (Object)this.psdevslnsys.getPSDevSlnSysId()) != 0L) {
                this.psdevslnsys = null;
            }
            if (this.psdevslnsys == null) {
                PSDevSlnSys pSDevSlnSys = new PSDevSlnSys();
                pSDevSlnSys.setPSDevSlnSysId(this.getPSDevSlnSysId());
                PSDevSlnSysService pSDevSlnSysService = (PSDevSlnSysService)ServiceGlobal.getService(PSDevSlnSysService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnSysService.autoGet(pSDevSlnSys);
                this.psdevslnsys = pSDevSlnSys;
            }
            return this.psdevslnsys;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDevSln getPSDevSln() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDevSln();
        }
        if (this.getPSDevSlnId() == null) {
            return null;
        }
        Integer n = this.objPSDevSlnLock;
        synchronized (n) {
            if (this.psdevsln != null && DataTypeHelper.compare((int)25, (Object)this.getPSDevSlnId(), (Object)this.psdevsln.getPSDevSlnId()) != 0L) {
                this.psdevsln = null;
            }
            if (this.psdevsln == null) {
                PSDevSln pSDevSln = new PSDevSln();
                pSDevSln.setPSDevSlnId(this.getPSDevSlnId());
                PSDevSlnService pSDevSlnService = (PSDevSlnService)ServiceGlobal.getService(PSDevSlnService.class, (SessionFactory)this.getSessionFactory());
                pSDevSlnService.autoGet(pSDevSln);
                this.psdevsln = pSDevSln;
            }
            return this.psdevsln;
        }
    }

    private PSDevSlnCanvasBase getProxyEntity() {
        return this.proxyPSDevSlnCanvasBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDevSlnCanvasBase = null;
        if (iDataObject != null && iDataObject instanceof PSDevSlnCanvasBase) {
            this.proxyPSDevSlnCanvasBase = (PSDevSlnCanvasBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSDevSlnCanvasService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CANVASMODEL, 0);
        fieldIndexMap.put(FIELD_CANVASTAG, 1);
        fieldIndexMap.put(FIELD_CANVASTAG2, 2);
        fieldIndexMap.put(FIELD_CANVASTAG3, 3);
        fieldIndexMap.put(FIELD_CANVASTAG4, 4);
        fieldIndexMap.put(FIELD_CANVASTYPE, 5);
        fieldIndexMap.put(FIELD_CODENAME, 6);
        fieldIndexMap.put(FIELD_CREATEDATE, 7);
        fieldIndexMap.put(FIELD_CREATEMAN, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_MODEL, 10);
        fieldIndexMap.put(FIELD_PSDEVSLNCANVASID, 11);
        fieldIndexMap.put(FIELD_PSDEVSLNCANVASNAME, 12);
        fieldIndexMap.put(FIELD_PSDEVSLNID, 13);
        fieldIndexMap.put(FIELD_PSDEVSLNNAME, 14);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSID, 15);
        fieldIndexMap.put(FIELD_PSDEVSLNSYSNAME, 16);
        fieldIndexMap.put(FIELD_UPDATEDATE, 17);
        fieldIndexMap.put(FIELD_UPDATEMAN, 18);
        fieldIndexMap.put(FIELD_USERCAT, 19);
        fieldIndexMap.put(FIELD_USERTAG, 20);
        fieldIndexMap.put(FIELD_USERTAG2, 21);
        fieldIndexMap.put(FIELD_USERTAG3, 22);
        fieldIndexMap.put(FIELD_USERTAG4, 23);
    }
}

