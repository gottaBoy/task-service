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
import net.ibizsys.pscore.srv.dedesign.entity.PSDEField;
import net.ibizsys.pscore.srv.dedesign.entity.PSDER;
import net.ibizsys.pscore.srv.dedesign.entity.PSDataEntity;
import net.ibizsys.pscore.srv.dedesign.service.PSDEFieldService;
import net.ibizsys.pscore.srv.dedesign.service.PSDERService;
import net.ibizsys.pscore.srv.dedesign.service.PSDataEntityService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSDEModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSDEModelBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODEL = "DYNAMODEL";
    public static final String FIELD_DYNAMODEL2 = "DYNAMODEL2";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELTAG = "MODELTAG";
    public static final String FIELD_MODELTAG2 = "MODELTAG2";
    public static final String FIELD_MODELTYPE = "MODELTYPE";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDEMODELID = "PSDEMODELID";
    public static final String FIELD_PSDEMODELNAME = "PSDEMODELNAME";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDERID = "PSDERID";
    public static final String FIELD_PSDERNAME = "PSDERNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERCAT = "USERCAT";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    public static final String FIELD_USERTAG3 = "USERTAG3";
    public static final String FIELD_USERTAG4 = "USERTAG4";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAMODEL = 4;
    private static final int INDEX_DYNAMODEL2 = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELTAG = 7;
    private static final int INDEX_MODELTAG2 = 8;
    private static final int INDEX_MODELTYPE = 9;
    private static final int INDEX_PSDEFID = 10;
    private static final int INDEX_PSDEFNAME = 11;
    private static final int INDEX_PSDEID = 12;
    private static final int INDEX_PSDEMODELID = 13;
    private static final int INDEX_PSDEMODELNAME = 14;
    private static final int INDEX_PSDENAME = 15;
    private static final int INDEX_PSDERID = 16;
    private static final int INDEX_PSDERNAME = 17;
    private static final int INDEX_UPDATEDATE = 18;
    private static final int INDEX_UPDATEMAN = 19;
    private static final int INDEX_USERCAT = 20;
    private static final int INDEX_USERTAG = 21;
    private static final int INDEX_USERTAG2 = 22;
    private static final int INDEX_USERTAG3 = 23;
    private static final int INDEX_USERTAG4 = 24;
    private static final int INDEX_VALIDFLAG = 25;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSDEModelBase proxyPSDEModelBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelDirtyFlag = false;
    private boolean dynamodel2DirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeltagDirtyFlag = false;
    private boolean modeltag2DirtyFlag = false;
    private boolean modeltypeDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdemodelidDirtyFlag = false;
    private boolean psdemodelnameDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psderidDirtyFlag = false;
    private boolean psdernameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usercatDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    private boolean usertag3DirtyFlag = false;
    private boolean usertag4DirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodel")
    private String dynamodel;
    @Column(name="dynamodel2")
    private String dynamodel2;
    @Column(name="memo")
    private String memo;
    @Column(name="modeltag")
    private String modeltag;
    @Column(name="modeltag2")
    private String modeltag2;
    @Column(name="modeltype")
    private String modeltype;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdemodelid")
    private String psdemodelid;
    @Column(name="psdemodelname")
    private String psdemodelname;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psderid")
    private String psderid;
    @Column(name="psdername")
    private String psdername;
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
    private Integer objPSDEFLock = new Integer(1);
    private PSDEField psdef = null;
    private Integer objPSDERLock = new Integer(1);
    private PSDER psder = null;

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

    public void setContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.content = string;
        this.contentDirtyFlag = true;
    }

    public String getContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getContent();
        }
        return this.content;
    }

    public boolean isContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isContentDirty();
        }
        return this.contentDirtyFlag;
    }

    public void resetContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetContent();
            return;
        }
        this.contentDirtyFlag = false;
        this.content = null;
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

    public void setDynaModel(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel = string;
        this.dynamodelDirtyFlag = true;
    }

    public String getDynaModel() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel();
        }
        return this.dynamodel;
    }

    public boolean isDynaModelDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelDirty();
        }
        return this.dynamodelDirtyFlag;
    }

    public void resetDynaModel() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel();
            return;
        }
        this.dynamodelDirtyFlag = false;
        this.dynamodel = null;
    }

    public void setDynaModel2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModel2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.dynamodel2 = string;
        this.dynamodel2DirtyFlag = true;
    }

    public String getDynaModel2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModel2();
        }
        return this.dynamodel2;
    }

    public boolean isDynaModel2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModel2Dirty();
        }
        return this.dynamodel2DirtyFlag;
    }

    public void resetDynaModel2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModel2();
            return;
        }
        this.dynamodel2DirtyFlag = false;
        this.dynamodel2 = null;
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

    public void setModelTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag = string;
        this.modeltagDirtyFlag = true;
    }

    public String getModelTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag();
        }
        return this.modeltag;
    }

    public boolean isModelTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTagDirty();
        }
        return this.modeltagDirtyFlag;
    }

    public void resetModelTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag();
            return;
        }
        this.modeltagDirtyFlag = false;
        this.modeltag = null;
    }

    public void setModelTag2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelTag2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltag2 = string;
        this.modeltag2DirtyFlag = true;
    }

    public String getModelTag2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelTag2();
        }
        return this.modeltag2;
    }

    public boolean isModelTag2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTag2Dirty();
        }
        return this.modeltag2DirtyFlag;
    }

    public void resetModelTag2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelTag2();
            return;
        }
        this.modeltag2DirtyFlag = false;
        this.modeltag2 = null;
    }

    public void setModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeltype = string;
        this.modeltypeDirtyFlag = true;
    }

    public String getModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelType();
        }
        return this.modeltype;
    }

    public boolean isModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelTypeDirty();
        }
        return this.modeltypeDirtyFlag;
    }

    public void resetModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelType();
            return;
        }
        this.modeltypeDirtyFlag = false;
        this.modeltype = null;
    }

    public void setPSDEFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefid = string;
        this.psdefidDirtyFlag = true;
    }

    public String getPSDEFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFId();
        }
        return this.psdefid;
    }

    public boolean isPSDEFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFIdDirty();
        }
        return this.psdefidDirtyFlag;
    }

    public void resetPSDEFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFId();
            return;
        }
        this.psdefidDirtyFlag = false;
        this.psdefid = null;
    }

    public void setPSDEFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdefname = string;
        this.psdefnameDirtyFlag = true;
    }

    public String getPSDEFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEFName();
        }
        return this.psdefname;
    }

    public boolean isPSDEFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEFNameDirty();
        }
        return this.psdefnameDirtyFlag;
    }

    public void resetPSDEFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEFName();
            return;
        }
        this.psdefnameDirtyFlag = false;
        this.psdefname = null;
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

    public void setPSDEModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemodelid = string;
        this.psdemodelidDirtyFlag = true;
    }

    public String getPSDEModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEModelId();
        }
        return this.psdemodelid;
    }

    public boolean isPSDEModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEModelIdDirty();
        }
        return this.psdemodelidDirtyFlag;
    }

    public void resetPSDEModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEModelId();
            return;
        }
        this.psdemodelidDirtyFlag = false;
        this.psdemodelid = null;
    }

    public void setPSDEModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdemodelname = string;
        this.psdemodelnameDirtyFlag = true;
    }

    public String getPSDEModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEModelName();
        }
        return this.psdemodelname;
    }

    public boolean isPSDEModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEModelNameDirty();
        }
        return this.psdemodelnameDirtyFlag;
    }

    public void resetPSDEModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEModelName();
            return;
        }
        this.psdemodelnameDirtyFlag = false;
        this.psdemodelname = null;
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

    public void setPSDERId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psderid = string;
        this.psderidDirtyFlag = true;
    }

    public String getPSDERId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERId();
        }
        return this.psderid;
    }

    public boolean isPSDERIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERIdDirty();
        }
        return this.psderidDirtyFlag;
    }

    public void resetPSDERId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERId();
            return;
        }
        this.psderidDirtyFlag = false;
        this.psderid = null;
    }

    public void setPSDERName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDERName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdername = string;
        this.psdernameDirtyFlag = true;
    }

    public String getPSDERName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDERName();
        }
        return this.psdername;
    }

    public boolean isPSDERNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDERNameDirty();
        }
        return this.psdernameDirtyFlag;
    }

    public void resetPSDERName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDERName();
            return;
        }
        this.psdernameDirtyFlag = false;
        this.psdername = null;
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
        PSDEModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSDEModelBase pSDEModelBase) {
        pSDEModelBase.resetCodeName();
        pSDEModelBase.resetContent();
        pSDEModelBase.resetCreateDate();
        pSDEModelBase.resetCreateMan();
        pSDEModelBase.resetDynaModel();
        pSDEModelBase.resetDynaModel2();
        pSDEModelBase.resetMemo();
        pSDEModelBase.resetModelTag();
        pSDEModelBase.resetModelTag2();
        pSDEModelBase.resetModelType();
        pSDEModelBase.resetPSDEFId();
        pSDEModelBase.resetPSDEFName();
        pSDEModelBase.resetPSDEId();
        pSDEModelBase.resetPSDEModelId();
        pSDEModelBase.resetPSDEModelName();
        pSDEModelBase.resetPSDEName();
        pSDEModelBase.resetPSDERId();
        pSDEModelBase.resetPSDERName();
        pSDEModelBase.resetUpdateDate();
        pSDEModelBase.resetUpdateMan();
        pSDEModelBase.resetUserCat();
        pSDEModelBase.resetUserTag();
        pSDEModelBase.resetUserTag2();
        pSDEModelBase.resetUserTag3();
        pSDEModelBase.resetUserTag4();
        pSDEModelBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isCodeNameDirty()) {
            hashMap.put(FIELD_CODENAME, this.getCodeName());
        }
        if (!bl || this.isContentDirty()) {
            hashMap.put(FIELD_CONTENT, this.getContent());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDynaModelDirty()) {
            hashMap.put(FIELD_DYNAMODEL, this.getDynaModel());
        }
        if (!bl || this.isDynaModel2Dirty()) {
            hashMap.put(FIELD_DYNAMODEL2, this.getDynaModel2());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelTagDirty()) {
            hashMap.put(FIELD_MODELTAG, this.getModelTag());
        }
        if (!bl || this.isModelTag2Dirty()) {
            hashMap.put(FIELD_MODELTAG2, this.getModelTag2());
        }
        if (!bl || this.isModelTypeDirty()) {
            hashMap.put(FIELD_MODELTYPE, this.getModelType());
        }
        if (!bl || this.isPSDEFIdDirty()) {
            hashMap.put(FIELD_PSDEFID, this.getPSDEFId());
        }
        if (!bl || this.isPSDEFNameDirty()) {
            hashMap.put(FIELD_PSDEFNAME, this.getPSDEFName());
        }
        if (!bl || this.isPSDEIdDirty()) {
            hashMap.put(FIELD_PSDEID, this.getPSDEId());
        }
        if (!bl || this.isPSDEModelIdDirty()) {
            hashMap.put(FIELD_PSDEMODELID, this.getPSDEModelId());
        }
        if (!bl || this.isPSDEModelNameDirty()) {
            hashMap.put(FIELD_PSDEMODELNAME, this.getPSDEModelName());
        }
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDERIdDirty()) {
            hashMap.put(FIELD_PSDERID, this.getPSDERId());
        }
        if (!bl || this.isPSDERNameDirty()) {
            hashMap.put(FIELD_PSDERNAME, this.getPSDERName());
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
        return PSDEModelBase.get(this, n);
    }

    private static Object get(PSDEModelBase pSDEModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelBase.getCodeName();
            }
            case 1: {
                return pSDEModelBase.getContent();
            }
            case 2: {
                return pSDEModelBase.getCreateDate();
            }
            case 3: {
                return pSDEModelBase.getCreateMan();
            }
            case 4: {
                return pSDEModelBase.getDynaModel();
            }
            case 5: {
                return pSDEModelBase.getDynaModel2();
            }
            case 6: {
                return pSDEModelBase.getMemo();
            }
            case 7: {
                return pSDEModelBase.getModelTag();
            }
            case 8: {
                return pSDEModelBase.getModelTag2();
            }
            case 9: {
                return pSDEModelBase.getModelType();
            }
            case 10: {
                return pSDEModelBase.getPSDEFId();
            }
            case 11: {
                return pSDEModelBase.getPSDEFName();
            }
            case 12: {
                return pSDEModelBase.getPSDEId();
            }
            case 13: {
                return pSDEModelBase.getPSDEModelId();
            }
            case 14: {
                return pSDEModelBase.getPSDEModelName();
            }
            case 15: {
                return pSDEModelBase.getPSDEName();
            }
            case 16: {
                return pSDEModelBase.getPSDERId();
            }
            case 17: {
                return pSDEModelBase.getPSDERName();
            }
            case 18: {
                return pSDEModelBase.getUpdateDate();
            }
            case 19: {
                return pSDEModelBase.getUpdateMan();
            }
            case 20: {
                return pSDEModelBase.getUserCat();
            }
            case 21: {
                return pSDEModelBase.getUserTag();
            }
            case 22: {
                return pSDEModelBase.getUserTag2();
            }
            case 23: {
                return pSDEModelBase.getUserTag3();
            }
            case 24: {
                return pSDEModelBase.getUserTag4();
            }
            case 25: {
                return pSDEModelBase.getValidFlag();
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
        PSDEModelBase.set(this, n, object);
    }

    private static void set(PSDEModelBase pSDEModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSDEModelBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSDEModelBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSDEModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSDEModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSDEModelBase.setDynaModel(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSDEModelBase.setDynaModel2(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSDEModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSDEModelBase.setModelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSDEModelBase.setModelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSDEModelBase.setModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSDEModelBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSDEModelBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSDEModelBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSDEModelBase.setPSDEModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSDEModelBase.setPSDEModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSDEModelBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSDEModelBase.setPSDERId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSDEModelBase.setPSDERName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSDEModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 19: {
                pSDEModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSDEModelBase.setUserCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSDEModelBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSDEModelBase.setUserTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSDEModelBase.setUserTag3(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSDEModelBase.setUserTag4(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSDEModelBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSDEModelBase.isNull(this, n);
    }

    private static boolean isNull(PSDEModelBase pSDEModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelBase.getCodeName() == null;
            }
            case 1: {
                return pSDEModelBase.getContent() == null;
            }
            case 2: {
                return pSDEModelBase.getCreateDate() == null;
            }
            case 3: {
                return pSDEModelBase.getCreateMan() == null;
            }
            case 4: {
                return pSDEModelBase.getDynaModel() == null;
            }
            case 5: {
                return pSDEModelBase.getDynaModel2() == null;
            }
            case 6: {
                return pSDEModelBase.getMemo() == null;
            }
            case 7: {
                return pSDEModelBase.getModelTag() == null;
            }
            case 8: {
                return pSDEModelBase.getModelTag2() == null;
            }
            case 9: {
                return pSDEModelBase.getModelType() == null;
            }
            case 10: {
                return pSDEModelBase.getPSDEFId() == null;
            }
            case 11: {
                return pSDEModelBase.getPSDEFName() == null;
            }
            case 12: {
                return pSDEModelBase.getPSDEId() == null;
            }
            case 13: {
                return pSDEModelBase.getPSDEModelId() == null;
            }
            case 14: {
                return pSDEModelBase.getPSDEModelName() == null;
            }
            case 15: {
                return pSDEModelBase.getPSDEName() == null;
            }
            case 16: {
                return pSDEModelBase.getPSDERId() == null;
            }
            case 17: {
                return pSDEModelBase.getPSDERName() == null;
            }
            case 18: {
                return pSDEModelBase.getUpdateDate() == null;
            }
            case 19: {
                return pSDEModelBase.getUpdateMan() == null;
            }
            case 20: {
                return pSDEModelBase.getUserCat() == null;
            }
            case 21: {
                return pSDEModelBase.getUserTag() == null;
            }
            case 22: {
                return pSDEModelBase.getUserTag2() == null;
            }
            case 23: {
                return pSDEModelBase.getUserTag3() == null;
            }
            case 24: {
                return pSDEModelBase.getUserTag4() == null;
            }
            case 25: {
                return pSDEModelBase.getValidFlag() == null;
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
        return PSDEModelBase.contains(this, n);
    }

    private static boolean contains(PSDEModelBase pSDEModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSDEModelBase.isCodeNameDirty();
            }
            case 1: {
                return pSDEModelBase.isContentDirty();
            }
            case 2: {
                return pSDEModelBase.isCreateDateDirty();
            }
            case 3: {
                return pSDEModelBase.isCreateManDirty();
            }
            case 4: {
                return pSDEModelBase.isDynaModelDirty();
            }
            case 5: {
                return pSDEModelBase.isDynaModel2Dirty();
            }
            case 6: {
                return pSDEModelBase.isMemoDirty();
            }
            case 7: {
                return pSDEModelBase.isModelTagDirty();
            }
            case 8: {
                return pSDEModelBase.isModelTag2Dirty();
            }
            case 9: {
                return pSDEModelBase.isModelTypeDirty();
            }
            case 10: {
                return pSDEModelBase.isPSDEFIdDirty();
            }
            case 11: {
                return pSDEModelBase.isPSDEFNameDirty();
            }
            case 12: {
                return pSDEModelBase.isPSDEIdDirty();
            }
            case 13: {
                return pSDEModelBase.isPSDEModelIdDirty();
            }
            case 14: {
                return pSDEModelBase.isPSDEModelNameDirty();
            }
            case 15: {
                return pSDEModelBase.isPSDENameDirty();
            }
            case 16: {
                return pSDEModelBase.isPSDERIdDirty();
            }
            case 17: {
                return pSDEModelBase.isPSDERNameDirty();
            }
            case 18: {
                return pSDEModelBase.isUpdateDateDirty();
            }
            case 19: {
                return pSDEModelBase.isUpdateManDirty();
            }
            case 20: {
                return pSDEModelBase.isUserCatDirty();
            }
            case 21: {
                return pSDEModelBase.isUserTagDirty();
            }
            case 22: {
                return pSDEModelBase.isUserTag2Dirty();
            }
            case 23: {
                return pSDEModelBase.isUserTag3Dirty();
            }
            case 24: {
                return pSDEModelBase.isUserTag4Dirty();
            }
            case 25: {
                return pSDEModelBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSDEModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSDEModelBase pSDEModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSDEModelBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getCodeName()), (boolean)false);
        }
        if (bl || pSDEModelBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getContent()), (boolean)false);
        }
        if (bl || pSDEModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSDEModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSDEModelBase.getDynaModel() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getDynaModel()), (boolean)false);
        }
        if (bl || pSDEModelBase.getDynaModel2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodel2", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getDynaModel2()), (boolean)false);
        }
        if (bl || pSDEModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSDEModelBase.getModelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getModelTag()), (boolean)false);
        }
        if (bl || pSDEModelBase.getModelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag2", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getModelTag2()), (boolean)false);
        }
        if (bl || pSDEModelBase.getModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltype", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getModelType()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemodelid", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEModelId()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdemodelname", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEModelName()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDERId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psderid", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDERId()), (boolean)false);
        }
        if (bl || pSDEModelBase.getPSDERName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdername", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getPSDERName()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUserCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usercat", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUserCat()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUserTag()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUserTag2()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUserTag3() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag3", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUserTag3()), (boolean)false);
        }
        if (bl || pSDEModelBase.getUserTag4() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag4", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getUserTag4()), (boolean)false);
        }
        if (bl || pSDEModelBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSDEModelBase.getJSONValue((Object)pSDEModelBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSDEModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSDEModelBase pSDEModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSDEModelBase.getCodeName() != null) {
            object = pSDEModelBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSDEModelBase.getContent() != null) {
            object = pSDEModelBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getCreateDate() != null) {
            object = pSDEModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEModelBase.getCreateMan() != null) {
            object = pSDEModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getDynaModel() != null) {
            object = pSDEModelBase.getDynaModel();
            xmlNode.setAttribute(FIELD_DYNAMODEL, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getDynaModel2() != null) {
            object = pSDEModelBase.getDynaModel2();
            xmlNode.setAttribute(FIELD_DYNAMODEL2, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getMemo() != null) {
            object = pSDEModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getModelTag() != null) {
            object = pSDEModelBase.getModelTag();
            xmlNode.setAttribute(FIELD_MODELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getModelTag2() != null) {
            object = pSDEModelBase.getModelTag2();
            xmlNode.setAttribute(FIELD_MODELTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getModelType() != null) {
            object = pSDEModelBase.getModelType();
            xmlNode.setAttribute(FIELD_MODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEFId() != null) {
            object = pSDEModelBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEFName() != null) {
            object = pSDEModelBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEId() != null) {
            object = pSDEModelBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEModelId() != null) {
            object = pSDEModelBase.getPSDEModelId();
            xmlNode.setAttribute(FIELD_PSDEMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEModelName() != null) {
            object = pSDEModelBase.getPSDEModelName();
            xmlNode.setAttribute(FIELD_PSDEMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDEName() != null) {
            object = pSDEModelBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDERId() != null) {
            object = pSDEModelBase.getPSDERId();
            xmlNode.setAttribute(FIELD_PSDERID, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getPSDERName() != null) {
            object = pSDEModelBase.getPSDERName();
            xmlNode.setAttribute(FIELD_PSDERNAME, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUpdateDate() != null) {
            object = pSDEModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSDEModelBase.getUpdateMan() != null) {
            object = pSDEModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUserCat() != null) {
            object = pSDEModelBase.getUserCat();
            xmlNode.setAttribute(FIELD_USERCAT, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUserTag() != null) {
            object = pSDEModelBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUserTag2() != null) {
            object = pSDEModelBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUserTag3() != null) {
            object = pSDEModelBase.getUserTag3();
            xmlNode.setAttribute(FIELD_USERTAG3, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getUserTag4() != null) {
            object = pSDEModelBase.getUserTag4();
            xmlNode.setAttribute(FIELD_USERTAG4, object == null ? "" : (String)object);
        }
        if (bl || pSDEModelBase.getValidFlag() != null) {
            object = pSDEModelBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSDEModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSDEModelBase pSDEModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSDEModelBase.isCodeNameDirty() && (bl || pSDEModelBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSDEModelBase.getCodeName());
        }
        if (pSDEModelBase.isContentDirty() && (bl || pSDEModelBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSDEModelBase.getContent());
        }
        if (pSDEModelBase.isCreateDateDirty() && (bl || pSDEModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSDEModelBase.getCreateDate());
        }
        if (pSDEModelBase.isCreateManDirty() && (bl || pSDEModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSDEModelBase.getCreateMan());
        }
        if (pSDEModelBase.isDynaModelDirty() && (bl || pSDEModelBase.getDynaModel() != null)) {
            iDataObject.set(FIELD_DYNAMODEL, (Object)pSDEModelBase.getDynaModel());
        }
        if (pSDEModelBase.isDynaModel2Dirty() && (bl || pSDEModelBase.getDynaModel2() != null)) {
            iDataObject.set(FIELD_DYNAMODEL2, (Object)pSDEModelBase.getDynaModel2());
        }
        if (pSDEModelBase.isMemoDirty() && (bl || pSDEModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSDEModelBase.getMemo());
        }
        if (pSDEModelBase.isModelTagDirty() && (bl || pSDEModelBase.getModelTag() != null)) {
            iDataObject.set(FIELD_MODELTAG, (Object)pSDEModelBase.getModelTag());
        }
        if (pSDEModelBase.isModelTag2Dirty() && (bl || pSDEModelBase.getModelTag2() != null)) {
            iDataObject.set(FIELD_MODELTAG2, (Object)pSDEModelBase.getModelTag2());
        }
        if (pSDEModelBase.isModelTypeDirty() && (bl || pSDEModelBase.getModelType() != null)) {
            iDataObject.set(FIELD_MODELTYPE, (Object)pSDEModelBase.getModelType());
        }
        if (pSDEModelBase.isPSDEFIdDirty() && (bl || pSDEModelBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSDEModelBase.getPSDEFId());
        }
        if (pSDEModelBase.isPSDEFNameDirty() && (bl || pSDEModelBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSDEModelBase.getPSDEFName());
        }
        if (pSDEModelBase.isPSDEIdDirty() && (bl || pSDEModelBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSDEModelBase.getPSDEId());
        }
        if (pSDEModelBase.isPSDEModelIdDirty() && (bl || pSDEModelBase.getPSDEModelId() != null)) {
            iDataObject.set(FIELD_PSDEMODELID, (Object)pSDEModelBase.getPSDEModelId());
        }
        if (pSDEModelBase.isPSDEModelNameDirty() && (bl || pSDEModelBase.getPSDEModelName() != null)) {
            iDataObject.set(FIELD_PSDEMODELNAME, (Object)pSDEModelBase.getPSDEModelName());
        }
        if (pSDEModelBase.isPSDENameDirty() && (bl || pSDEModelBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSDEModelBase.getPSDEName());
        }
        if (pSDEModelBase.isPSDERIdDirty() && (bl || pSDEModelBase.getPSDERId() != null)) {
            iDataObject.set(FIELD_PSDERID, (Object)pSDEModelBase.getPSDERId());
        }
        if (pSDEModelBase.isPSDERNameDirty() && (bl || pSDEModelBase.getPSDERName() != null)) {
            iDataObject.set(FIELD_PSDERNAME, (Object)pSDEModelBase.getPSDERName());
        }
        if (pSDEModelBase.isUpdateDateDirty() && (bl || pSDEModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSDEModelBase.getUpdateDate());
        }
        if (pSDEModelBase.isUpdateManDirty() && (bl || pSDEModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSDEModelBase.getUpdateMan());
        }
        if (pSDEModelBase.isUserCatDirty() && (bl || pSDEModelBase.getUserCat() != null)) {
            iDataObject.set(FIELD_USERCAT, (Object)pSDEModelBase.getUserCat());
        }
        if (pSDEModelBase.isUserTagDirty() && (bl || pSDEModelBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSDEModelBase.getUserTag());
        }
        if (pSDEModelBase.isUserTag2Dirty() && (bl || pSDEModelBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSDEModelBase.getUserTag2());
        }
        if (pSDEModelBase.isUserTag3Dirty() && (bl || pSDEModelBase.getUserTag3() != null)) {
            iDataObject.set(FIELD_USERTAG3, (Object)pSDEModelBase.getUserTag3());
        }
        if (pSDEModelBase.isUserTag4Dirty() && (bl || pSDEModelBase.getUserTag4() != null)) {
            iDataObject.set(FIELD_USERTAG4, (Object)pSDEModelBase.getUserTag4());
        }
        if (pSDEModelBase.isValidFlagDirty() && (bl || pSDEModelBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSDEModelBase.getValidFlag());
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
        return PSDEModelBase.remove(this, n);
    }

    private static boolean remove(PSDEModelBase pSDEModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSDEModelBase.resetCodeName();
                return true;
            }
            case 1: {
                pSDEModelBase.resetContent();
                return true;
            }
            case 2: {
                pSDEModelBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSDEModelBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSDEModelBase.resetDynaModel();
                return true;
            }
            case 5: {
                pSDEModelBase.resetDynaModel2();
                return true;
            }
            case 6: {
                pSDEModelBase.resetMemo();
                return true;
            }
            case 7: {
                pSDEModelBase.resetModelTag();
                return true;
            }
            case 8: {
                pSDEModelBase.resetModelTag2();
                return true;
            }
            case 9: {
                pSDEModelBase.resetModelType();
                return true;
            }
            case 10: {
                pSDEModelBase.resetPSDEFId();
                return true;
            }
            case 11: {
                pSDEModelBase.resetPSDEFName();
                return true;
            }
            case 12: {
                pSDEModelBase.resetPSDEId();
                return true;
            }
            case 13: {
                pSDEModelBase.resetPSDEModelId();
                return true;
            }
            case 14: {
                pSDEModelBase.resetPSDEModelName();
                return true;
            }
            case 15: {
                pSDEModelBase.resetPSDEName();
                return true;
            }
            case 16: {
                pSDEModelBase.resetPSDERId();
                return true;
            }
            case 17: {
                pSDEModelBase.resetPSDERName();
                return true;
            }
            case 18: {
                pSDEModelBase.resetUpdateDate();
                return true;
            }
            case 19: {
                pSDEModelBase.resetUpdateMan();
                return true;
            }
            case 20: {
                pSDEModelBase.resetUserCat();
                return true;
            }
            case 21: {
                pSDEModelBase.resetUserTag();
                return true;
            }
            case 22: {
                pSDEModelBase.resetUserTag2();
                return true;
            }
            case 23: {
                pSDEModelBase.resetUserTag3();
                return true;
            }
            case 24: {
                pSDEModelBase.resetUserTag4();
                return true;
            }
            case 25: {
                pSDEModelBase.resetValidFlag();
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
                pSDataEntityService.autoGet((IEntity)pSDataEntity);
                this.psde = pSDataEntity;
            }
            return this.psde;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEField getPSDEF() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEF();
        }
        if (this.getPSDEFId() == null) {
            return null;
        }
        Integer n = this.objPSDEFLock;
        synchronized (n) {
            if (this.psdef != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEFId(), (Object)this.psdef.getPSDEFieldId()) != 0L) {
                this.psdef = null;
            }
            if (this.psdef == null) {
                PSDEField pSDEField = new PSDEField();
                pSDEField.setPSDEFieldId(this.getPSDEFId());
                PSDEFieldService pSDEFieldService = (PSDEFieldService)ServiceGlobal.getService(PSDEFieldService.class, (SessionFactory)this.getSessionFactory());
                pSDEFieldService.autoGet((IEntity)pSDEField);
                this.psdef = pSDEField;
            }
            return this.psdef;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDER getPSDER() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDER();
        }
        if (this.getPSDERId() == null) {
            return null;
        }
        Integer n = this.objPSDERLock;
        synchronized (n) {
            if (this.psder != null && DataTypeHelper.compare((int)25, (Object)this.getPSDERId(), (Object)this.psder.getPSDERId()) != 0L) {
                this.psder = null;
            }
            if (this.psder == null) {
                PSDER pSDER = new PSDER();
                pSDER.setPSDERId(this.getPSDERId());
                PSDERService pSDERService = (PSDERService)ServiceGlobal.getService(PSDERService.class, (SessionFactory)this.getSessionFactory());
                pSDERService.autoGet((IEntity)pSDER);
                this.psder = pSDER;
            }
            return this.psder;
        }
    }

    private PSDEModelBase getProxyEntity() {
        return this.proxyPSDEModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSDEModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSDEModelBase) {
            this.proxyPSDEModelBase = (PSDEModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.dedesign.service.PSDEModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAMODEL, 4);
        fieldIndexMap.put(FIELD_DYNAMODEL2, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELTAG, 7);
        fieldIndexMap.put(FIELD_MODELTAG2, 8);
        fieldIndexMap.put(FIELD_MODELTYPE, 9);
        fieldIndexMap.put(FIELD_PSDEFID, 10);
        fieldIndexMap.put(FIELD_PSDEFNAME, 11);
        fieldIndexMap.put(FIELD_PSDEID, 12);
        fieldIndexMap.put(FIELD_PSDEMODELID, 13);
        fieldIndexMap.put(FIELD_PSDEMODELNAME, 14);
        fieldIndexMap.put(FIELD_PSDENAME, 15);
        fieldIndexMap.put(FIELD_PSDERID, 16);
        fieldIndexMap.put(FIELD_PSDERNAME, 17);
        fieldIndexMap.put(FIELD_UPDATEDATE, 18);
        fieldIndexMap.put(FIELD_UPDATEMAN, 19);
        fieldIndexMap.put(FIELD_USERCAT, 20);
        fieldIndexMap.put(FIELD_USERTAG, 21);
        fieldIndexMap.put(FIELD_USERTAG2, 22);
        fieldIndexMap.put(FIELD_USERTAG3, 23);
        fieldIndexMap.put(FIELD_USERTAG4, 24);
        fieldIndexMap.put(FIELD_VALIDFLAG, 25);
    }
}

