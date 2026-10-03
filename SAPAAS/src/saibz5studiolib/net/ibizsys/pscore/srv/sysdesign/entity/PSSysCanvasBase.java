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
import net.ibizsys.pscore.srv.sysdesign.entity.PSModule;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSysCanvasModel;
import net.ibizsys.pscore.srv.sysdesign.entity.PSSystem;
import net.ibizsys.pscore.srv.sysdesign.service.PSModuleService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasModelService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService;
import net.ibizsys.pscore.srv.sysdesign.service.PSSystemService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSSysCanvasBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSSysCanvasBase.class);
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
    public static final String FIELD_PSMODULEID = "PSMODULEID";
    public static final String FIELD_PSMODULENAME = "PSMODULENAME";
    public static final String FIELD_PSSYSCANVASID = "PSSYSCANVASID";
    public static final String FIELD_PSSYSCANVASNAME = "PSSYSCANVASNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_PSSYSTEMNAME = "PSSYSTEMNAME";
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
    private static final int INDEX_PSMODULEID = 10;
    private static final int INDEX_PSMODULENAME = 11;
    private static final int INDEX_PSSYSCANVASID = 12;
    private static final int INDEX_PSSYSCANVASNAME = 13;
    private static final int INDEX_PSSYSTEMID = 14;
    private static final int INDEX_PSSYSTEMNAME = 15;
    private static final int INDEX_UPDATEDATE = 16;
    private static final int INDEX_UPDATEMAN = 17;
    private static final int INDEX_USERCAT = 18;
    private static final int INDEX_USERTAG = 19;
    private static final int INDEX_USERTAG2 = 20;
    private static final int INDEX_USERTAG3 = 21;
    private static final int INDEX_USERTAG4 = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSSysCanvasBase proxyPSSysCanvasBase = null;
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
    private boolean psmoduleidDirtyFlag = false;
    private boolean psmodulenameDirtyFlag = false;
    private boolean pssyscanvasidDirtyFlag = false;
    private boolean pssyscanvasnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean pssystemnameDirtyFlag = false;
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
    @Column(name="psmoduleid")
    private String psmoduleid;
    @Column(name="psmodulename")
    private String psmodulename;
    @Column(name="pssyscanvasid")
    private String pssyscanvasid;
    @Column(name="pssyscanvasname")
    private String pssyscanvasname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="pssystemname")
    private String pssystemname;
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
    private Integer objPSModuleLock = new Integer(1);
    private PSModule psmodule = null;
    private Integer objPSSystemLock = new Integer(1);
    private PSSystem pssystem = null;
    private Integer objPSSysCanvasModelsLock = new Integer(1);
    private ArrayList<PSSysCanvasModel> pssyscanvasmodels = null;

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

    public void setPSModuleId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmoduleid = string;
        this.psmoduleidDirtyFlag = true;
    }

    public String getPSModuleId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleId();
        }
        return this.psmoduleid;
    }

    public boolean isPSModuleIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleIdDirty();
        }
        return this.psmoduleidDirtyFlag;
    }

    public void resetPSModuleId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleId();
            return;
        }
        this.psmoduleidDirtyFlag = false;
        this.psmoduleid = null;
    }

    public void setPSModuleName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModuleName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodulename = string;
        this.psmodulenameDirtyFlag = true;
    }

    public String getPSModuleName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModuleName();
        }
        return this.psmodulename;
    }

    public boolean isPSModuleNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModuleNameDirty();
        }
        return this.psmodulenameDirtyFlag;
    }

    public void resetPSModuleName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModuleName();
            return;
        }
        this.psmodulenameDirtyFlag = false;
        this.psmodulename = null;
    }

    public void setPSSysCanvasId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasid = string;
        this.pssyscanvasidDirtyFlag = true;
    }

    public String getPSSysCanvasId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasId();
        }
        return this.pssyscanvasid;
    }

    public boolean isPSSysCanvasIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasIdDirty();
        }
        return this.pssyscanvasidDirtyFlag;
    }

    public void resetPSSysCanvasId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasId();
            return;
        }
        this.pssyscanvasidDirtyFlag = false;
        this.pssyscanvasid = null;
    }

    public void setPSSysCanvasName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysCanvasName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyscanvasname = string;
        this.pssyscanvasnameDirtyFlag = true;
    }

    public String getPSSysCanvasName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasName();
        }
        return this.pssyscanvasname;
    }

    public boolean isPSSysCanvasNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysCanvasNameDirty();
        }
        return this.pssyscanvasnameDirtyFlag;
    }

    public void resetPSSysCanvasName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysCanvasName();
            return;
        }
        this.pssyscanvasnameDirtyFlag = false;
        this.pssyscanvasname = null;
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

    public void setPSSystemName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSystemName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssystemname = string;
        this.pssystemnameDirtyFlag = true;
    }

    public String getPSSystemName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystemName();
        }
        return this.pssystemname;
    }

    public boolean isPSSystemNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSystemNameDirty();
        }
        return this.pssystemnameDirtyFlag;
    }

    public void resetPSSystemName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSystemName();
            return;
        }
        this.pssystemnameDirtyFlag = false;
        this.pssystemname = null;
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
        PSSysCanvasBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSSysCanvasBase pSSysCanvasBase) {
        pSSysCanvasBase.resetCanvasModel();
        pSSysCanvasBase.resetCanvasTag();
        pSSysCanvasBase.resetCanvasTag2();
        pSSysCanvasBase.resetCanvasTag3();
        pSSysCanvasBase.resetCanvasTag4();
        pSSysCanvasBase.resetCanvasType();
        pSSysCanvasBase.resetCodeName();
        pSSysCanvasBase.resetCreateDate();
        pSSysCanvasBase.resetCreateMan();
        pSSysCanvasBase.resetMemo();
        pSSysCanvasBase.resetPSModuleId();
        pSSysCanvasBase.resetPSModuleName();
        pSSysCanvasBase.resetPSSysCanvasId();
        pSSysCanvasBase.resetPSSysCanvasName();
        pSSysCanvasBase.resetPSSystemId();
        pSSysCanvasBase.resetPSSystemName();
        pSSysCanvasBase.resetUpdateDate();
        pSSysCanvasBase.resetUpdateMan();
        pSSysCanvasBase.resetUserCat();
        pSSysCanvasBase.resetUserTag();
        pSSysCanvasBase.resetUserTag2();
        pSSysCanvasBase.resetUserTag3();
        pSSysCanvasBase.resetUserTag4();
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
        if (!bl || this.isPSModuleIdDirty()) {
            hashMap.put(FIELD_PSMODULEID, this.getPSModuleId());
        }
        if (!bl || this.isPSModuleNameDirty()) {
            hashMap.put(FIELD_PSMODULENAME, this.getPSModuleName());
        }
        if (!bl || this.isPSSysCanvasIdDirty()) {
            hashMap.put(FIELD_PSSYSCANVASID, this.getPSSysCanvasId());
        }
        if (!bl || this.isPSSysCanvasNameDirty()) {
            hashMap.put(FIELD_PSSYSCANVASNAME, this.getPSSysCanvasName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isPSSystemNameDirty()) {
            hashMap.put(FIELD_PSSYSTEMNAME, this.getPSSystemName());
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
        return PSSysCanvasBase.get(this, n);
    }

    private static Object get(PSSysCanvasBase pSSysCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasBase.getCanvasModel();
            }
            case 1: {
                return pSSysCanvasBase.getCanvasTag();
            }
            case 2: {
                return pSSysCanvasBase.getCanvasTag2();
            }
            case 3: {
                return pSSysCanvasBase.getCanvasTag3();
            }
            case 4: {
                return pSSysCanvasBase.getCanvasTag4();
            }
            case 5: {
                return pSSysCanvasBase.getCanvasType();
            }
            case 6: {
                return pSSysCanvasBase.getCodeName();
            }
            case 7: {
                return pSSysCanvasBase.getCreateDate();
            }
            case 8: {
                return pSSysCanvasBase.getCreateMan();
            }
            case 9: {
                return pSSysCanvasBase.getMemo();
            }
            case 10: {
                return pSSysCanvasBase.getPSModuleId();
            }
            case 11: {
                return pSSysCanvasBase.getPSModuleName();
            }
            case 12: {
                return pSSysCanvasBase.getPSSysCanvasId();
            }
            case 13: {
                return pSSysCanvasBase.getPSSysCanvasName();
            }
            case 14: {
                return pSSysCanvasBase.getPSSystemId();
            }
            case 15: {
                return pSSysCanvasBase.getPSSystemName();
            }
            case 16: {
                return pSSysCanvasBase.getUpdateDate();
            }
            case 17: {
                return pSSysCanvasBase.getUpdateMan();
            }
            case 18: {
                return pSSysCanvasBase.getUserCat();
            }
            case 19: {
                return pSSysCanvasBase.getUserTag();
            }
            case 20: {
                return pSSysCanvasBase.getUserTag2();
            }
            case 21: {
                return pSSysCanvasBase.getUserTag3();
            }
            case 22: {
                return pSSysCanvasBase.getUserTag4();
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
        PSSysCanvasBase.set(this, n, object);
    }

    private static void set(PSSysCanvasBase pSSysCanvasBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSSysCanvasBase.setCanvasModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSSysCanvasBase.setCanvasTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSSysCanvasBase.setCanvasTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSSysCanvasBase.setCanvasTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSSysCanvasBase.setCanvasTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSSysCanvasBase.setCanvasType(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSSysCanvasBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSSysCanvasBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 8: {
                pSSysCanvasBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSSysCanvasBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSSysCanvasBase.setPSModuleId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSSysCanvasBase.setPSModuleName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSSysCanvasBase.setPSSysCanvasId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSSysCanvasBase.setPSSysCanvasName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSSysCanvasBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSSysCanvasBase.setPSSystemName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSSysCanvasBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 17: {
                pSSysCanvasBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSSysCanvasBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSSysCanvasBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSSysCanvasBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSSysCanvasBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSSysCanvasBase.setUserTag4(DataObject.getStringValue((Object)object));
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
        return PSSysCanvasBase.isNull(this, n);
    }

    private static boolean isNull(PSSysCanvasBase pSSysCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasBase.getCanvasModel() == null;
            }
            case 1: {
                return pSSysCanvasBase.getCanvasTag() == null;
            }
            case 2: {
                return pSSysCanvasBase.getCanvasTag2() == null;
            }
            case 3: {
                return pSSysCanvasBase.getCanvasTag3() == null;
            }
            case 4: {
                return pSSysCanvasBase.getCanvasTag4() == null;
            }
            case 5: {
                return pSSysCanvasBase.getCanvasType() == null;
            }
            case 6: {
                return pSSysCanvasBase.getCodeName() == null;
            }
            case 7: {
                return pSSysCanvasBase.getCreateDate() == null;
            }
            case 8: {
                return pSSysCanvasBase.getCreateMan() == null;
            }
            case 9: {
                return pSSysCanvasBase.getMemo() == null;
            }
            case 10: {
                return pSSysCanvasBase.getPSModuleId() == null;
            }
            case 11: {
                return pSSysCanvasBase.getPSModuleName() == null;
            }
            case 12: {
                return pSSysCanvasBase.getPSSysCanvasId() == null;
            }
            case 13: {
                return pSSysCanvasBase.getPSSysCanvasName() == null;
            }
            case 14: {
                return pSSysCanvasBase.getPSSystemId() == null;
            }
            case 15: {
                return pSSysCanvasBase.getPSSystemName() == null;
            }
            case 16: {
                return pSSysCanvasBase.getUpdateDate() == null;
            }
            case 17: {
                return pSSysCanvasBase.getUpdateMan() == null;
            }
            case 18: {
                return pSSysCanvasBase.getUserCat() == null;
            }
            case 19: {
                return pSSysCanvasBase.getUserTag() == null;
            }
            case 20: {
                return pSSysCanvasBase.getUserTag2() == null;
            }
            case 21: {
                return pSSysCanvasBase.getUserTag3() == null;
            }
            case 22: {
                return pSSysCanvasBase.getUserTag4() == null;
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
        return PSSysCanvasBase.contains(this, n);
    }

    private static boolean contains(PSSysCanvasBase pSSysCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSSysCanvasBase.isCanvasModelDirty();
            }
            case 1: {
                return pSSysCanvasBase.isCanvasTagDirty();
            }
            case 2: {
                return pSSysCanvasBase.isCanvasTag2Dirty();
            }
            case 3: {
                return pSSysCanvasBase.isCanvasTag3Dirty();
            }
            case 4: {
                return pSSysCanvasBase.isCanvasTag4Dirty();
            }
            case 5: {
                return pSSysCanvasBase.isCanvasTypeDirty();
            }
            case 6: {
                return pSSysCanvasBase.isCodeNameDirty();
            }
            case 7: {
                return pSSysCanvasBase.isCreateDateDirty();
            }
            case 8: {
                return pSSysCanvasBase.isCreateManDirty();
            }
            case 9: {
                return pSSysCanvasBase.isMemoDirty();
            }
            case 10: {
                return pSSysCanvasBase.isPSModuleIdDirty();
            }
            case 11: {
                return pSSysCanvasBase.isPSModuleNameDirty();
            }
            case 12: {
                return pSSysCanvasBase.isPSSysCanvasIdDirty();
            }
            case 13: {
                return pSSysCanvasBase.isPSSysCanvasNameDirty();
            }
            case 14: {
                return pSSysCanvasBase.isPSSystemIdDirty();
            }
            case 15: {
                return pSSysCanvasBase.isPSSystemNameDirty();
            }
            case 16: {
                return pSSysCanvasBase.isUpdateDateDirty();
            }
            case 17: {
                return pSSysCanvasBase.isUpdateManDirty();
            }
            case 18: {
                return pSSysCanvasBase.isUserCatDirty();
            }
            case 19: {
                return pSSysCanvasBase.isUserTagDirty();
            }
            case 20: {
                return pSSysCanvasBase.isUserTag2Dirty();
            }
            case 21: {
                return pSSysCanvasBase.isUserTag3Dirty();
            }
            case 22: {
                return pSSysCanvasBase.isUserTag4Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSSysCanvasBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSSysCanvasBase pSSysCanvasBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSSysCanvasBase.getCanvasModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvasmodel", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasModel()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCanvasTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasTag()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCanvasTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag2", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasTag2()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCanvasTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag3", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasTag3()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCanvasTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastag4", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasTag4()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCanvasType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"canvastype", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCanvasType()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCodeName()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getMemo()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSModuleId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmoduleid", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSModuleId()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSModuleName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodulename", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSModuleName()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSSysCanvasId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasid", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSSysCanvasId()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSSysCanvasName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyscanvasname", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSSysCanvasName()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getPSSystemName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemname", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getPSSystemName()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUserCat()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUserTag()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSSysCanvasBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSSysCanvasBase.getJSONValue((Object)pSSysCanvasBase.getUserTag4()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSSysCanvasBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSSysCanvasBase pSSysCanvasBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSSysCanvasBase.getCanvasModel() != null) {
            object = pSSysCanvasBase.getCanvasModel();
            xmlNode.setAttribute(FIELD_CANVASMODEL, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCanvasTag() != null) {
            object = pSSysCanvasBase.getCanvasTag();
            xmlNode.setAttribute(FIELD_CANVASTAG, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCanvasTag2() != null) {
            object = pSSysCanvasBase.getCanvasTag2();
            xmlNode.setAttribute(FIELD_CANVASTAG2, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCanvasTag3() != null) {
            object = pSSysCanvasBase.getCanvasTag3();
            xmlNode.setAttribute(FIELD_CANVASTAG3, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCanvasTag4() != null) {
            object = pSSysCanvasBase.getCanvasTag4();
            xmlNode.setAttribute(FIELD_CANVASTAG4, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCanvasType() != null) {
            object = pSSysCanvasBase.getCanvasType();
            xmlNode.setAttribute(FIELD_CANVASTYPE, (String)(object == null ? "" : object));
        }
        if (bl || pSSysCanvasBase.getCodeName() != null) {
            object = pSSysCanvasBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getCreateDate() != null) {
            object = pSSysCanvasBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCanvasBase.getCreateMan() != null) {
            object = pSSysCanvasBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getMemo() != null) {
            object = pSSysCanvasBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSModuleId() != null) {
            object = pSSysCanvasBase.getPSModuleId();
            xmlNode.setAttribute(FIELD_PSMODULEID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSModuleName() != null) {
            object = pSSysCanvasBase.getPSModuleName();
            xmlNode.setAttribute(FIELD_PSMODULENAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSSysCanvasId() != null) {
            object = pSSysCanvasBase.getPSSysCanvasId();
            xmlNode.setAttribute(FIELD_PSSYSCANVASID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSSysCanvasName() != null) {
            object = pSSysCanvasBase.getPSSysCanvasName();
            xmlNode.setAttribute(FIELD_PSSYSCANVASNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSSystemId() != null) {
            object = pSSysCanvasBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getPSSystemName() != null) {
            object = pSSysCanvasBase.getPSSystemName();
            xmlNode.setAttribute(FIELD_PSSYSTEMNAME, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUpdateDate() != null) {
            object = pSSysCanvasBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSSysCanvasBase.getUpdateMan() != null) {
            object = pSSysCanvasBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUserCat() != null) {
            object = pSSysCanvasBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUserTag() != null) {
            object = pSSysCanvasBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUserTag2() != null) {
            object = pSSysCanvasBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUserTag3() != null) {
            object = pSSysCanvasBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSSysCanvasBase.getUserTag4() != null) {
            object = pSSysCanvasBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSSysCanvasBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSSysCanvasBase pSSysCanvasBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSSysCanvasBase.isCanvasModelDirty() && (bl || pSSysCanvasBase.getCanvasModel() != null)) {
            iDataObject.set(FIELD_CANVASMODEL, (Object)pSSysCanvasBase.getCanvasModel());
        }
        if (pSSysCanvasBase.isCanvasTagDirty() && (bl || pSSysCanvasBase.getCanvasTag() != null)) {
            iDataObject.set(FIELD_CANVASTAG, (Object)pSSysCanvasBase.getCanvasTag());
        }
        if (pSSysCanvasBase.isCanvasTag2Dirty() && (bl || pSSysCanvasBase.getCanvasTag2() != null)) {
            iDataObject.set(FIELD_CANVASTAG2, (Object)pSSysCanvasBase.getCanvasTag2());
        }
        if (pSSysCanvasBase.isCanvasTag3Dirty() && (bl || pSSysCanvasBase.getCanvasTag3() != null)) {
            iDataObject.set(FIELD_CANVASTAG3, (Object)pSSysCanvasBase.getCanvasTag3());
        }
        if (pSSysCanvasBase.isCanvasTag4Dirty() && (bl || pSSysCanvasBase.getCanvasTag4() != null)) {
            iDataObject.set(FIELD_CANVASTAG4, (Object)pSSysCanvasBase.getCanvasTag4());
        }
        if (pSSysCanvasBase.isCanvasTypeDirty() && (bl || pSSysCanvasBase.getCanvasType() != null)) {
            iDataObject.set(FIELD_CANVASTYPE, (Object)pSSysCanvasBase.getCanvasType());
        }
        if (pSSysCanvasBase.isCodeNameDirty() && (bl || pSSysCanvasBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSSysCanvasBase.getCodeName());
        }
        if (pSSysCanvasBase.isCreateDateDirty() && (bl || pSSysCanvasBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSSysCanvasBase.getCreateDate());
        }
        if (pSSysCanvasBase.isCreateManDirty() && (bl || pSSysCanvasBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSSysCanvasBase.getCreateMan());
        }
        if (pSSysCanvasBase.isMemoDirty() && (bl || pSSysCanvasBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSSysCanvasBase.getMemo());
        }
        if (pSSysCanvasBase.isPSModuleIdDirty() && (bl || pSSysCanvasBase.getPSModuleId() != null)) {
            iDataObject.set(FIELD_PSMODULEID, (Object)pSSysCanvasBase.getPSModuleId());
        }
        if (pSSysCanvasBase.isPSModuleNameDirty() && (bl || pSSysCanvasBase.getPSModuleName() != null)) {
            iDataObject.set(FIELD_PSMODULENAME, (Object)pSSysCanvasBase.getPSModuleName());
        }
        if (pSSysCanvasBase.isPSSysCanvasIdDirty() && (bl || pSSysCanvasBase.getPSSysCanvasId() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASID, (Object)pSSysCanvasBase.getPSSysCanvasId());
        }
        if (pSSysCanvasBase.isPSSysCanvasNameDirty() && (bl || pSSysCanvasBase.getPSSysCanvasName() != null)) {
            iDataObject.set(FIELD_PSSYSCANVASNAME, (Object)pSSysCanvasBase.getPSSysCanvasName());
        }
        if (pSSysCanvasBase.isPSSystemIdDirty() && (bl || pSSysCanvasBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSSysCanvasBase.getPSSystemId());
        }
        if (pSSysCanvasBase.isPSSystemNameDirty() && (bl || pSSysCanvasBase.getPSSystemName() != null)) {
            iDataObject.set(FIELD_PSSYSTEMNAME, (Object)pSSysCanvasBase.getPSSystemName());
        }
        if (pSSysCanvasBase.isUpdateDateDirty() && (bl || pSSysCanvasBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSSysCanvasBase.getUpdateDate());
        }
        if (pSSysCanvasBase.isUpdateManDirty() && (bl || pSSysCanvasBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSSysCanvasBase.getUpdateMan());
        }
        if (pSSysCanvasBase.isUserCatDirty() && (bl || pSSysCanvasBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSSysCanvasBase.getUserCat());
        }
        if (pSSysCanvasBase.isUserTagDirty() && (bl || pSSysCanvasBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSSysCanvasBase.getUserTag());
        }
        if (pSSysCanvasBase.isUserTag2Dirty() && (bl || pSSysCanvasBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSSysCanvasBase.getUserTag2());
        }
        if (pSSysCanvasBase.isUserTag3Dirty() && (bl || pSSysCanvasBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSSysCanvasBase.getUserTag3());
        }
        if (pSSysCanvasBase.isUserTag4Dirty() && (bl || pSSysCanvasBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSSysCanvasBase.getUserTag4());
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
        return PSSysCanvasBase.remove(this, n);
    }

    private static boolean remove(PSSysCanvasBase pSSysCanvasBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSSysCanvasBase.resetCanvasModel();
                return true;
            }
            case 1: {
                pSSysCanvasBase.resetCanvasTag();
                return true;
            }
            case 2: {
                pSSysCanvasBase.resetCanvasTag2();
                return true;
            }
            case 3: {
                pSSysCanvasBase.resetCanvasTag3();
                return true;
            }
            case 4: {
                pSSysCanvasBase.resetCanvasTag4();
                return true;
            }
            case 5: {
                pSSysCanvasBase.resetCanvasType();
                return true;
            }
            case 6: {
                pSSysCanvasBase.resetCodeName();
                return true;
            }
            case 7: {
                pSSysCanvasBase.resetCreateDate();
                return true;
            }
            case 8: {
                pSSysCanvasBase.resetCreateMan();
                return true;
            }
            case 9: {
                pSSysCanvasBase.resetMemo();
                return true;
            }
            case 10: {
                pSSysCanvasBase.resetPSModuleId();
                return true;
            }
            case 11: {
                pSSysCanvasBase.resetPSModuleName();
                return true;
            }
            case 12: {
                pSSysCanvasBase.resetPSSysCanvasId();
                return true;
            }
            case 13: {
                pSSysCanvasBase.resetPSSysCanvasName();
                return true;
            }
            case 14: {
                pSSysCanvasBase.resetPSSystemId();
                return true;
            }
            case 15: {
                pSSysCanvasBase.resetPSSystemName();
                return true;
            }
            case 16: {
                pSSysCanvasBase.resetUpdateDate();
                return true;
            }
            case 17: {
                pSSysCanvasBase.resetUpdateMan();
                return true;
            }
            case 18: {
                pSSysCanvasBase.resetUserCat();
                return true;
            }
            case 19: {
                pSSysCanvasBase.resetUserTag();
                return true;
            }
            case 20: {
                pSSysCanvasBase.resetUserTag2();
                return true;
            }
            case 21: {
                pSSysCanvasBase.resetUserTag3();
                return true;
            }
            case 22: {
                pSSysCanvasBase.resetUserTag4();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModule getPSModule() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModule();
        }
        if (this.getPSModuleId() == null) {
            return null;
        }
        Integer n = this.objPSModuleLock;
        synchronized (n) {
            if (this.psmodule != null && DataTypeHelper.compare((int)25, (Object)this.getPSModuleId(), (Object)this.psmodule.getPSModuleId()) != 0L) {
                this.psmodule = null;
            }
            if (this.psmodule == null) {
                PSModule pSModule = new PSModule();
                pSModule.setPSModuleId(this.getPSModuleId());
                PSModuleService pSModuleService = (PSModuleService)ServiceGlobal.getService(PSModuleService.class, (SessionFactory)this.getSessionFactory());
                pSModuleService.autoGet(pSModule);
                this.psmodule = pSModule;
            }
            return this.psmodule;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSSystem getPSSystem() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSystem();
        }
        if (this.getPSSystemId() == null) {
            return null;
        }
        Integer n = this.objPSSystemLock;
        synchronized (n) {
            if (this.pssystem != null && DataTypeHelper.compare((int)25, (Object)this.getPSSystemId(), (Object)this.pssystem.getPSSystemId()) != 0L) {
                this.pssystem = null;
            }
            if (this.pssystem == null) {
                PSSystem pSSystem = new PSSystem();
                pSSystem.setPSSystemId(this.getPSSystemId());
                PSSystemService pSSystemService = (PSSystemService)ServiceGlobal.getService(PSSystemService.class, (SessionFactory)this.getSessionFactory());
                pSSystemService.autoGet(pSSystem);
                this.pssystem = pSSystem;
            }
            return this.pssystem;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSysCanvasModel> getPSSysCanvasModels() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysCanvasModels();
        }
        if (this.getPSSysCanvasId() == null) {
            return null;
        }
        PSSysCanvasService pSSysCanvasService = (PSSysCanvasService)ServiceGlobal.getService(PSSysCanvasService.class, (SessionFactory)this.getSessionFactory());
        PSSysCanvasModelService pSSysCanvasModelService = (PSSysCanvasModelService)ServiceGlobal.getService(PSSysCanvasModelService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSysCanvasModelsLock;
        synchronized (n) {
            if (this.pssyscanvasmodels == null) {
                this.pssyscanvasmodels = pSSysCanvasService.isTempData(this) ? pSSysCanvasModelService.selectTempByPSSysCanvas(this) : pSSysCanvasModelService.selectByPSSysCanvas(this);
            }
            return this.pssyscanvasmodels;
        }
    }

    private PSSysCanvasBase getProxyEntity() {
        return this.proxyPSSysCanvasBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSSysCanvasBase = null;
        if (iDataObject != null && iDataObject instanceof PSSysCanvasBase) {
            this.proxyPSSysCanvasBase = (PSSysCanvasBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSSysCanvasService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
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
        fieldIndexMap.put(FIELD_PSMODULEID, 10);
        fieldIndexMap.put(FIELD_PSMODULENAME, 11);
        fieldIndexMap.put(FIELD_PSSYSCANVASID, 12);
        fieldIndexMap.put(FIELD_PSSYSCANVASNAME, 13);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 14);
        fieldIndexMap.put(FIELD_PSSYSTEMNAME, 15);
        fieldIndexMap.put(FIELD_UPDATEDATE, 16);
        fieldIndexMap.put(FIELD_UPDATEMAN, 17);
        fieldIndexMap.put(FIELD_USERCAT, 18);
        fieldIndexMap.put(FIELD_USERTAG, 19);
        fieldIndexMap.put(FIELD_USERTAG2, 20);
        fieldIndexMap.put(FIELD_USERTAG3, 21);
        fieldIndexMap.put(FIELD_USERTAG4, 22);
    }
}

