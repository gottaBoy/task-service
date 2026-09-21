/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.persistence.Column
 *  net.ibizsys.paas.data.DataObject
 *  net.ibizsys.paas.data.IDataObject
 *  net.ibizsys.paas.entity.EntityBase
 *  net.ibizsys.paas.entity.IEntityActionHelper
 *  net.ibizsys.paas.service.ServiceGlobal
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
import net.ibizsys.paas.entity.IEntityActionHelper;
import net.ibizsys.paas.service.ServiceGlobal;
import net.ibizsys.paas.util.JSONObjectHelper;
import net.ibizsys.paas.util.StringHelper;
import net.ibizsys.paas.xml.XmlNode;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelObjBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelObjBase.class);
    public static final String FIELD_CODENAME = "CODENAME";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DYNAMODELFLAG = "DYNAMODELFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELDATA = "MODELDATA";
    public static final String FIELD_MODELDATA2 = "MODELDATA2";
    public static final String FIELD_MODELTAG = "MODELTAG";
    public static final String FIELD_MODELTAG2 = "MODELTAG2";
    public static final String FIELD_PATHNAME = "PATHNAME";
    public static final String FIELD_PPSMODELOBJID = "PPSMODELOBJID";
    public static final String FIELD_PSDEFID = "PSDEFID";
    public static final String FIELD_PSDEFNAME = "PSDEFNAME";
    public static final String FIELD_PSDEID = "PSDEID";
    public static final String FIELD_PSDENAME = "PSDENAME";
    public static final String FIELD_PSDYNAINSTID = "PSDYNAINSTID";
    public static final String FIELD_PSMODELOBJID = "PSMODELOBJID";
    public static final String FIELD_PSMODELOBJNAME = "PSMODELOBJNAME";
    public static final String FIELD_PSMODELSUBTYPE = "PSMODELSUBTYPE";
    public static final String FIELD_PSMODELTYPE = "PSMODELTYPE";
    public static final String FIELD_PSSYSAPPID = "PSSYSAPPID";
    public static final String FIELD_PSSYSAPPNAME = "PSSYSAPPNAME";
    public static final String FIELD_PSSYSSFPUBID = "PSSYSSFPUBID";
    public static final String FIELD_PSSYSSFPUBNAME = "PSSYSSFPUBNAME";
    public static final String FIELD_PSSYSTEMID = "PSSYSTEMID";
    public static final String FIELD_REALMODELOBJID = "REALMODELOBJID";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USERTAG = "USERTAG";
    public static final String FIELD_USERTAG2 = "USERTAG2";
    private static final int INDEX_CODENAME = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_DYNAMODELFLAG = 4;
    private static final int INDEX_LOGICNAME = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_MODELDATA = 7;
    private static final int INDEX_MODELDATA2 = 8;
    private static final int INDEX_MODELTAG = 9;
    private static final int INDEX_MODELTAG2 = 10;
    private static final int INDEX_PATHNAME = 11;
    private static final int INDEX_PPSMODELOBJID = 12;
    private static final int INDEX_PSDEFID = 13;
    private static final int INDEX_PSDEFNAME = 14;
    private static final int INDEX_PSDEID = 15;
    private static final int INDEX_PSDENAME = 16;
    private static final int INDEX_PSDYNAINSTID = 17;
    private static final int INDEX_PSMODELOBJID = 18;
    private static final int INDEX_PSMODELOBJNAME = 19;
    private static final int INDEX_PSMODELSUBTYPE = 20;
    private static final int INDEX_PSMODELTYPE = 21;
    private static final int INDEX_PSSYSAPPID = 22;
    private static final int INDEX_PSSYSAPPNAME = 23;
    private static final int INDEX_PSSYSSFPUBID = 24;
    private static final int INDEX_PSSYSSFPUBNAME = 25;
    private static final int INDEX_PSSYSTEMID = 26;
    private static final int INDEX_REALMODELOBJID = 27;
    private static final int INDEX_UPDATEDATE = 28;
    private static final int INDEX_UPDATEMAN = 29;
    private static final int INDEX_USERTAG = 30;
    private static final int INDEX_USERTAG2 = 31;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelObjBase proxyPSModelObjBase = null;
    private boolean codenameDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean dynamodelflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modeldataDirtyFlag = false;
    private boolean modeldata2DirtyFlag = false;
    private boolean modeltagDirtyFlag = false;
    private boolean modeltag2DirtyFlag = false;
    private boolean pathnameDirtyFlag = false;
    private boolean ppsmodelobjidDirtyFlag = false;
    private boolean psdefidDirtyFlag = false;
    private boolean psdefnameDirtyFlag = false;
    private boolean psdeidDirtyFlag = false;
    private boolean psdenameDirtyFlag = false;
    private boolean psdynainstidDirtyFlag = false;
    private boolean psmodelobjidDirtyFlag = false;
    private boolean psmodelobjnameDirtyFlag = false;
    private boolean psmodelsubtypeDirtyFlag = false;
    private boolean psmodeltypeDirtyFlag = false;
    private boolean pssysappidDirtyFlag = false;
    private boolean pssysappnameDirtyFlag = false;
    private boolean pssyssfpubidDirtyFlag = false;
    private boolean pssyssfpubnameDirtyFlag = false;
    private boolean pssystemidDirtyFlag = false;
    private boolean realmodelobjidDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usertagDirtyFlag = false;
    private boolean usertag2DirtyFlag = false;
    @Column(name="codename")
    private String codename;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="dynamodelflag")
    private Integer dynamodelflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="memo")
    private String memo;
    @Column(name="modeldata")
    private String modeldata;
    @Column(name="modeldata2")
    private String modeldata2;
    @Column(name="modeltag")
    private String modeltag;
    @Column(name="modeltag2")
    private String modeltag2;
    @Column(name="pathname")
    private String pathname;
    @Column(name="ppsmodelobjid")
    private String ppsmodelobjid;
    @Column(name="psdefid")
    private String psdefid;
    @Column(name="psdefname")
    private String psdefname;
    @Column(name="psdeid")
    private String psdeid;
    @Column(name="psdename")
    private String psdename;
    @Column(name="psdynainstid")
    private String psdynainstid;
    @Column(name="psmodelobjid")
    private String psmodelobjid;
    @Column(name="psmodelobjname")
    private String psmodelobjname;
    @Column(name="psmodelsubtype")
    private String psmodelsubtype;
    @Column(name="psmodeltype")
    private String psmodeltype;
    @Column(name="pssysappid")
    private String pssysappid;
    @Column(name="pssysappname")
    private String pssysappname;
    @Column(name="pssyssfpubid")
    private String pssyssfpubid;
    @Column(name="pssyssfpubname")
    private String pssyssfpubname;
    @Column(name="pssystemid")
    private String pssystemid;
    @Column(name="realmodelobjid")
    private String realmodelobjid;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usertag")
    private String usertag;
    @Column(name="usertag2")
    private String usertag2;

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

    public void setDynaModelFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDynaModelFlag(n);
            return;
        }
        this.dynamodelflag = n;
        this.dynamodelflagDirtyFlag = true;
    }

    public Integer getDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDynaModelFlag();
        }
        return this.dynamodelflag;
    }

    public boolean isDynaModelFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDynaModelFlagDirty();
        }
        return this.dynamodelflagDirtyFlag;
    }

    public void resetDynaModelFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDynaModelFlag();
            return;
        }
        this.dynamodelflagDirtyFlag = false;
        this.dynamodelflag = null;
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

    public void setModelData(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelData(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeldata = string;
        this.modeldataDirtyFlag = true;
    }

    public String getModelData() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelData();
        }
        return this.modeldata;
    }

    public boolean isModelDataDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDataDirty();
        }
        return this.modeldataDirtyFlag;
    }

    public void resetModelData() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelData();
            return;
        }
        this.modeldataDirtyFlag = false;
        this.modeldata = null;
    }

    public void setModelData2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelData2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeldata2 = string;
        this.modeldata2DirtyFlag = true;
    }

    public String getModelData2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelData2();
        }
        return this.modeldata2;
    }

    public boolean isModelData2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelData2Dirty();
        }
        return this.modeldata2DirtyFlag;
    }

    public void resetModelData2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelData2();
            return;
        }
        this.modeldata2DirtyFlag = false;
        this.modeldata2 = null;
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

    public void setPathName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPathName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pathname = string;
        this.pathnameDirtyFlag = true;
    }

    public String getPathName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPathName();
        }
        return this.pathname;
    }

    public boolean isPathNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPathNameDirty();
        }
        return this.pathnameDirtyFlag;
    }

    public void resetPathName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPathName();
            return;
        }
        this.pathnameDirtyFlag = false;
        this.pathname = null;
    }

    public void setPPSModelObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelobjid = string;
        this.ppsmodelobjidDirtyFlag = true;
    }

    public String getPPSModelObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelObjId();
        }
        return this.ppsmodelobjid;
    }

    public boolean isPPSModelObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelObjIdDirty();
        }
        return this.ppsmodelobjidDirtyFlag;
    }

    public void resetPPSModelObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelObjId();
            return;
        }
        this.ppsmodelobjidDirtyFlag = false;
        this.ppsmodelobjid = null;
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

    public void setPSDynaInstId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDynaInstId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdynainstid = string;
        this.psdynainstidDirtyFlag = true;
    }

    public String getPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDynaInstId();
        }
        return this.psdynainstid;
    }

    public boolean isPSDynaInstIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDynaInstIdDirty();
        }
        return this.psdynainstidDirtyFlag;
    }

    public void resetPSDynaInstId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDynaInstId();
            return;
        }
        this.psdynainstidDirtyFlag = false;
        this.psdynainstid = null;
    }

    public void setPSModelObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelobjid = string;
        this.psmodelobjidDirtyFlag = true;
    }

    public String getPSModelObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelObjId();
        }
        return this.psmodelobjid;
    }

    public boolean isPSModelObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelObjIdDirty();
        }
        return this.psmodelobjidDirtyFlag;
    }

    public void resetPSModelObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelObjId();
            return;
        }
        this.psmodelobjidDirtyFlag = false;
        this.psmodelobjid = null;
    }

    public void setPSModelObjName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelObjName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelobjname = string;
        this.psmodelobjnameDirtyFlag = true;
    }

    public String getPSModelObjName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelObjName();
        }
        return this.psmodelobjname;
    }

    public boolean isPSModelObjNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelObjNameDirty();
        }
        return this.psmodelobjnameDirtyFlag;
    }

    public void resetPSModelObjName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelObjName();
            return;
        }
        this.psmodelobjnameDirtyFlag = false;
        this.psmodelobjname = null;
    }

    public void setPSModelSubType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelSubType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelsubtype = string;
        this.psmodelsubtypeDirtyFlag = true;
    }

    public String getPSModelSubType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelSubType();
        }
        return this.psmodelsubtype;
    }

    public boolean isPSModelSubTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelSubTypeDirty();
        }
        return this.psmodelsubtypeDirtyFlag;
    }

    public void resetPSModelSubType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelSubType();
            return;
        }
        this.psmodelsubtypeDirtyFlag = false;
        this.psmodelsubtype = null;
    }

    public void setPSModelType(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelType(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodeltype = string;
        this.psmodeltypeDirtyFlag = true;
    }

    public String getPSModelType() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelType();
        }
        return this.psmodeltype;
    }

    public boolean isPSModelTypeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelTypeDirty();
        }
        return this.psmodeltypeDirtyFlag;
    }

    public void resetPSModelType() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelType();
            return;
        }
        this.psmodeltypeDirtyFlag = false;
        this.psmodeltype = null;
    }

    public void setPSSysAppId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappid = string;
        this.pssysappidDirtyFlag = true;
    }

    public String getPSSysAppId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppId();
        }
        return this.pssysappid;
    }

    public boolean isPSSysAppIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppIdDirty();
        }
        return this.pssysappidDirtyFlag;
    }

    public void resetPSSysAppId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppId();
            return;
        }
        this.pssysappidDirtyFlag = false;
        this.pssysappid = null;
    }

    public void setPSSysAppName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysAppName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssysappname = string;
        this.pssysappnameDirtyFlag = true;
    }

    public String getPSSysAppName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysAppName();
        }
        return this.pssysappname;
    }

    public boolean isPSSysAppNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysAppNameDirty();
        }
        return this.pssysappnameDirtyFlag;
    }

    public void resetPSSysAppName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysAppName();
            return;
        }
        this.pssysappnameDirtyFlag = false;
        this.pssysappname = null;
    }

    public void setPSSysSFPubId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubid = string;
        this.pssyssfpubidDirtyFlag = true;
    }

    public String getPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubId();
        }
        return this.pssyssfpubid;
    }

    public boolean isPSSysSFPubIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubIdDirty();
        }
        return this.pssyssfpubidDirtyFlag;
    }

    public void resetPSSysSFPubId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubId();
            return;
        }
        this.pssyssfpubidDirtyFlag = false;
        this.pssyssfpubid = null;
    }

    public void setPSSysSFPubName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSSysSFPubName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pssyssfpubname = string;
        this.pssyssfpubnameDirtyFlag = true;
    }

    public String getPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSysSFPubName();
        }
        return this.pssyssfpubname;
    }

    public boolean isPSSysSFPubNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSSysSFPubNameDirty();
        }
        return this.pssyssfpubnameDirtyFlag;
    }

    public void resetPSSysSFPubName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSSysSFPubName();
            return;
        }
        this.pssyssfpubnameDirtyFlag = false;
        this.pssyssfpubname = null;
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

    public void setRealModelObjId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setRealModelObjId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.realmodelobjid = string;
        this.realmodelobjidDirtyFlag = true;
    }

    public String getRealModelObjId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getRealModelObjId();
        }
        return this.realmodelobjid;
    }

    public boolean isRealModelObjIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isRealModelObjIdDirty();
        }
        return this.realmodelobjidDirtyFlag;
    }

    public void resetRealModelObjId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetRealModelObjId();
            return;
        }
        this.realmodelobjidDirtyFlag = false;
        this.realmodelobjid = null;
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

    protected void onReset() {
        PSModelObjBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelObjBase pSModelObjBase) {
        pSModelObjBase.resetCodeName();
        pSModelObjBase.resetContent();
        pSModelObjBase.resetCreateDate();
        pSModelObjBase.resetCreateMan();
        pSModelObjBase.resetDynaModelFlag();
        pSModelObjBase.resetLogicName();
        pSModelObjBase.resetMemo();
        pSModelObjBase.resetModelData();
        pSModelObjBase.resetModelData2();
        pSModelObjBase.resetModelTag();
        pSModelObjBase.resetModelTag2();
        pSModelObjBase.resetPathName();
        pSModelObjBase.resetPPSModelObjId();
        pSModelObjBase.resetPSDEFId();
        pSModelObjBase.resetPSDEFName();
        pSModelObjBase.resetPSDEId();
        pSModelObjBase.resetPSDEName();
        pSModelObjBase.resetPSDynaInstId();
        pSModelObjBase.resetPSModelObjId();
        pSModelObjBase.resetPSModelObjName();
        pSModelObjBase.resetPSModelSubType();
        pSModelObjBase.resetPSModelType();
        pSModelObjBase.resetPSSysAppId();
        pSModelObjBase.resetPSSysAppName();
        pSModelObjBase.resetPSSysSFPubId();
        pSModelObjBase.resetPSSysSFPubName();
        pSModelObjBase.resetPSSystemId();
        pSModelObjBase.resetRealModelObjId();
        pSModelObjBase.resetUpdateDate();
        pSModelObjBase.resetUpdateMan();
        pSModelObjBase.resetUserTag();
        pSModelObjBase.resetUserTag2();
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
        if (!bl || this.isDynaModelFlagDirty()) {
            hashMap.put(FIELD_DYNAMODELFLAG, this.getDynaModelFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelDataDirty()) {
            hashMap.put(FIELD_MODELDATA, this.getModelData());
        }
        if (!bl || this.isModelData2Dirty()) {
            hashMap.put(FIELD_MODELDATA2, this.getModelData2());
        }
        if (!bl || this.isModelTagDirty()) {
            hashMap.put(FIELD_MODELTAG, this.getModelTag());
        }
        if (!bl || this.isModelTag2Dirty()) {
            hashMap.put(FIELD_MODELTAG2, this.getModelTag2());
        }
        if (!bl || this.isPathNameDirty()) {
            hashMap.put(FIELD_PATHNAME, this.getPathName());
        }
        if (!bl || this.isPPSModelObjIdDirty()) {
            hashMap.put(FIELD_PPSMODELOBJID, this.getPPSModelObjId());
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
        if (!bl || this.isPSDENameDirty()) {
            hashMap.put(FIELD_PSDENAME, this.getPSDEName());
        }
        if (!bl || this.isPSDynaInstIdDirty()) {
            hashMap.put(FIELD_PSDYNAINSTID, this.getPSDynaInstId());
        }
        if (!bl || this.isPSModelObjIdDirty()) {
            hashMap.put(FIELD_PSMODELOBJID, this.getPSModelObjId());
        }
        if (!bl || this.isPSModelObjNameDirty()) {
            hashMap.put(FIELD_PSMODELOBJNAME, this.getPSModelObjName());
        }
        if (!bl || this.isPSModelSubTypeDirty()) {
            hashMap.put(FIELD_PSMODELSUBTYPE, this.getPSModelSubType());
        }
        if (!bl || this.isPSModelTypeDirty()) {
            hashMap.put(FIELD_PSMODELTYPE, this.getPSModelType());
        }
        if (!bl || this.isPSSysAppIdDirty()) {
            hashMap.put(FIELD_PSSYSAPPID, this.getPSSysAppId());
        }
        if (!bl || this.isPSSysAppNameDirty()) {
            hashMap.put(FIELD_PSSYSAPPNAME, this.getPSSysAppName());
        }
        if (!bl || this.isPSSysSFPubIdDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBID, this.getPSSysSFPubId());
        }
        if (!bl || this.isPSSysSFPubNameDirty()) {
            hashMap.put(FIELD_PSSYSSFPUBNAME, this.getPSSysSFPubName());
        }
        if (!bl || this.isPSSystemIdDirty()) {
            hashMap.put(FIELD_PSSYSTEMID, this.getPSSystemId());
        }
        if (!bl || this.isRealModelObjIdDirty()) {
            hashMap.put(FIELD_REALMODELOBJID, this.getRealModelObjId());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUserTagDirty()) {
            hashMap.put(FIELD_USERTAG, this.getUserTag());
        }
        if (!bl || this.isUserTag2Dirty()) {
            hashMap.put(FIELD_USERTAG2, this.getUserTag2());
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
        return PSModelObjBase.get(this, n);
    }

    private static Object get(PSModelObjBase pSModelObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjBase.getCodeName();
            }
            case 1: {
                return pSModelObjBase.getContent();
            }
            case 2: {
                return pSModelObjBase.getCreateDate();
            }
            case 3: {
                return pSModelObjBase.getCreateMan();
            }
            case 4: {
                return pSModelObjBase.getDynaModelFlag();
            }
            case 5: {
                return pSModelObjBase.getLogicName();
            }
            case 6: {
                return pSModelObjBase.getMemo();
            }
            case 7: {
                return pSModelObjBase.getModelData();
            }
            case 8: {
                return pSModelObjBase.getModelData2();
            }
            case 9: {
                return pSModelObjBase.getModelTag();
            }
            case 10: {
                return pSModelObjBase.getModelTag2();
            }
            case 11: {
                return pSModelObjBase.getPathName();
            }
            case 12: {
                return pSModelObjBase.getPPSModelObjId();
            }
            case 13: {
                return pSModelObjBase.getPSDEFId();
            }
            case 14: {
                return pSModelObjBase.getPSDEFName();
            }
            case 15: {
                return pSModelObjBase.getPSDEId();
            }
            case 16: {
                return pSModelObjBase.getPSDEName();
            }
            case 17: {
                return pSModelObjBase.getPSDynaInstId();
            }
            case 18: {
                return pSModelObjBase.getPSModelObjId();
            }
            case 19: {
                return pSModelObjBase.getPSModelObjName();
            }
            case 20: {
                return pSModelObjBase.getPSModelSubType();
            }
            case 21: {
                return pSModelObjBase.getPSModelType();
            }
            case 22: {
                return pSModelObjBase.getPSSysAppId();
            }
            case 23: {
                return pSModelObjBase.getPSSysAppName();
            }
            case 24: {
                return pSModelObjBase.getPSSysSFPubId();
            }
            case 25: {
                return pSModelObjBase.getPSSysSFPubName();
            }
            case 26: {
                return pSModelObjBase.getPSSystemId();
            }
            case 27: {
                return pSModelObjBase.getRealModelObjId();
            }
            case 28: {
                return pSModelObjBase.getUpdateDate();
            }
            case 29: {
                return pSModelObjBase.getUpdateMan();
            }
            case 30: {
                return pSModelObjBase.getUserTag();
            }
            case 31: {
                return pSModelObjBase.getUserTag2();
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
        PSModelObjBase.set(this, n, object);
    }

    private static void set(PSModelObjBase pSModelObjBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelObjBase.setCodeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelObjBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelObjBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSModelObjBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelObjBase.setDynaModelFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelObjBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelObjBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelObjBase.setModelData(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelObjBase.setModelData2(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelObjBase.setModelTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelObjBase.setModelTag2(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelObjBase.setPathName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelObjBase.setPPSModelObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelObjBase.setPSDEFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelObjBase.setPSDEFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelObjBase.setPSDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSModelObjBase.setPSDEName(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelObjBase.setPSDynaInstId(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelObjBase.setPSModelObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelObjBase.setPSModelObjName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSModelObjBase.setPSModelSubType(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModelObjBase.setPSModelType(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSModelObjBase.setPSSysAppId(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSModelObjBase.setPSSysAppName(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSModelObjBase.setPSSysSFPubId(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSModelObjBase.setPSSysSFPubName(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSModelObjBase.setPSSystemId(DataObject.getStringValue((Object)object));
                return;
            }
            case 27: {
                pSModelObjBase.setRealModelObjId(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSModelObjBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 29: {
                pSModelObjBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 30: {
                pSModelObjBase.setUserTag(DataObject.getStringValue((Object)object));
                return;
            }
            case 31: {
                pSModelObjBase.setUserTag2(DataObject.getStringValue((Object)object));
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
        return PSModelObjBase.isNull(this, n);
    }

    private static boolean isNull(PSModelObjBase pSModelObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjBase.getCodeName() == null;
            }
            case 1: {
                return pSModelObjBase.getContent() == null;
            }
            case 2: {
                return pSModelObjBase.getCreateDate() == null;
            }
            case 3: {
                return pSModelObjBase.getCreateMan() == null;
            }
            case 4: {
                return pSModelObjBase.getDynaModelFlag() == null;
            }
            case 5: {
                return pSModelObjBase.getLogicName() == null;
            }
            case 6: {
                return pSModelObjBase.getMemo() == null;
            }
            case 7: {
                return pSModelObjBase.getModelData() == null;
            }
            case 8: {
                return pSModelObjBase.getModelData2() == null;
            }
            case 9: {
                return pSModelObjBase.getModelTag() == null;
            }
            case 10: {
                return pSModelObjBase.getModelTag2() == null;
            }
            case 11: {
                return pSModelObjBase.getPathName() == null;
            }
            case 12: {
                return pSModelObjBase.getPPSModelObjId() == null;
            }
            case 13: {
                return pSModelObjBase.getPSDEFId() == null;
            }
            case 14: {
                return pSModelObjBase.getPSDEFName() == null;
            }
            case 15: {
                return pSModelObjBase.getPSDEId() == null;
            }
            case 16: {
                return pSModelObjBase.getPSDEName() == null;
            }
            case 17: {
                return pSModelObjBase.getPSDynaInstId() == null;
            }
            case 18: {
                return pSModelObjBase.getPSModelObjId() == null;
            }
            case 19: {
                return pSModelObjBase.getPSModelObjName() == null;
            }
            case 20: {
                return pSModelObjBase.getPSModelSubType() == null;
            }
            case 21: {
                return pSModelObjBase.getPSModelType() == null;
            }
            case 22: {
                return pSModelObjBase.getPSSysAppId() == null;
            }
            case 23: {
                return pSModelObjBase.getPSSysAppName() == null;
            }
            case 24: {
                return pSModelObjBase.getPSSysSFPubId() == null;
            }
            case 25: {
                return pSModelObjBase.getPSSysSFPubName() == null;
            }
            case 26: {
                return pSModelObjBase.getPSSystemId() == null;
            }
            case 27: {
                return pSModelObjBase.getRealModelObjId() == null;
            }
            case 28: {
                return pSModelObjBase.getUpdateDate() == null;
            }
            case 29: {
                return pSModelObjBase.getUpdateMan() == null;
            }
            case 30: {
                return pSModelObjBase.getUserTag() == null;
            }
            case 31: {
                return pSModelObjBase.getUserTag2() == null;
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
        return PSModelObjBase.contains(this, n);
    }

    private static boolean contains(PSModelObjBase pSModelObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelObjBase.isCodeNameDirty();
            }
            case 1: {
                return pSModelObjBase.isContentDirty();
            }
            case 2: {
                return pSModelObjBase.isCreateDateDirty();
            }
            case 3: {
                return pSModelObjBase.isCreateManDirty();
            }
            case 4: {
                return pSModelObjBase.isDynaModelFlagDirty();
            }
            case 5: {
                return pSModelObjBase.isLogicNameDirty();
            }
            case 6: {
                return pSModelObjBase.isMemoDirty();
            }
            case 7: {
                return pSModelObjBase.isModelDataDirty();
            }
            case 8: {
                return pSModelObjBase.isModelData2Dirty();
            }
            case 9: {
                return pSModelObjBase.isModelTagDirty();
            }
            case 10: {
                return pSModelObjBase.isModelTag2Dirty();
            }
            case 11: {
                return pSModelObjBase.isPathNameDirty();
            }
            case 12: {
                return pSModelObjBase.isPPSModelObjIdDirty();
            }
            case 13: {
                return pSModelObjBase.isPSDEFIdDirty();
            }
            case 14: {
                return pSModelObjBase.isPSDEFNameDirty();
            }
            case 15: {
                return pSModelObjBase.isPSDEIdDirty();
            }
            case 16: {
                return pSModelObjBase.isPSDENameDirty();
            }
            case 17: {
                return pSModelObjBase.isPSDynaInstIdDirty();
            }
            case 18: {
                return pSModelObjBase.isPSModelObjIdDirty();
            }
            case 19: {
                return pSModelObjBase.isPSModelObjNameDirty();
            }
            case 20: {
                return pSModelObjBase.isPSModelSubTypeDirty();
            }
            case 21: {
                return pSModelObjBase.isPSModelTypeDirty();
            }
            case 22: {
                return pSModelObjBase.isPSSysAppIdDirty();
            }
            case 23: {
                return pSModelObjBase.isPSSysAppNameDirty();
            }
            case 24: {
                return pSModelObjBase.isPSSysSFPubIdDirty();
            }
            case 25: {
                return pSModelObjBase.isPSSysSFPubNameDirty();
            }
            case 26: {
                return pSModelObjBase.isPSSystemIdDirty();
            }
            case 27: {
                return pSModelObjBase.isRealModelObjIdDirty();
            }
            case 28: {
                return pSModelObjBase.isUpdateDateDirty();
            }
            case 29: {
                return pSModelObjBase.isUpdateManDirty();
            }
            case 30: {
                return pSModelObjBase.isUserTagDirty();
            }
            case 31: {
                return pSModelObjBase.isUserTag2Dirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelObjBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelObjBase pSModelObjBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelObjBase.getCodeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"codename", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getCodeName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getContent()), (boolean)false);
        }
        if (bl || pSModelObjBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelObjBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelObjBase.getDynaModelFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"dynamodelflag", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getDynaModelFlag()), (boolean)false);
        }
        if (bl || pSModelObjBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getLogicName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelObjBase.getModelData() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeldata", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getModelData()), (boolean)false);
        }
        if (bl || pSModelObjBase.getModelData2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeldata2", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getModelData2()), (boolean)false);
        }
        if (bl || pSModelObjBase.getModelTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getModelTag()), (boolean)false);
        }
        if (bl || pSModelObjBase.getModelTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeltag2", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getModelTag2()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPathName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pathname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPathName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPPSModelObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelobjid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPPSModelObjId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSDEFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSDEFId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSDEFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdefname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSDEFName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSDEId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSDEName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdename", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSDEName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSDynaInstId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdynainstid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSDynaInstId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSModelObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelobjid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSModelObjId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSModelObjName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelobjname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSModelObjName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSModelSubType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelsubtype", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSModelSubType()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSModelType() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodeltype", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSModelType()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSSysAppId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSSysAppId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSSysAppName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssysappname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSSysAppName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSSysSFPubId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSSysSFPubId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSSysSFPubName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssyssfpubname", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSSysSFPubName()), (boolean)false);
        }
        if (bl || pSModelObjBase.getPSSystemId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pssystemid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getPSSystemId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getRealModelObjId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"realmodelobjid", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getRealModelObjId()), (boolean)false);
        }
        if (bl || pSModelObjBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelObjBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelObjBase.getUserTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getUserTag()), (boolean)false);
        }
        if (bl || pSModelObjBase.getUserTag2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usertag2", (Object)PSModelObjBase.getJSONValue((Object)pSModelObjBase.getUserTag2()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelObjBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelObjBase pSModelObjBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelObjBase.getCodeName() != null) {
            object = pSModelObjBase.getCodeName();
            xmlNode.setAttribute(FIELD_CODENAME, (String)(object == null ? "" : object));
        }
        if (bl || pSModelObjBase.getContent() != null) {
            object = pSModelObjBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getCreateDate() != null) {
            object = pSModelObjBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelObjBase.getCreateMan() != null) {
            object = pSModelObjBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getDynaModelFlag() != null) {
            object = pSModelObjBase.getDynaModelFlag();
            xmlNode.setAttribute(FIELD_DYNAMODELFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelObjBase.getLogicName() != null) {
            object = pSModelObjBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getMemo() != null) {
            object = pSModelObjBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getModelData() != null) {
            object = pSModelObjBase.getModelData();
            xmlNode.setAttribute(FIELD_MODELDATA, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getModelData2() != null) {
            object = pSModelObjBase.getModelData2();
            xmlNode.setAttribute(FIELD_MODELDATA2, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getModelTag() != null) {
            object = pSModelObjBase.getModelTag();
            xmlNode.setAttribute(FIELD_MODELTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getModelTag2() != null) {
            object = pSModelObjBase.getModelTag2();
            xmlNode.setAttribute(FIELD_MODELTAG2, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPathName() != null) {
            object = pSModelObjBase.getPathName();
            xmlNode.setAttribute(FIELD_PATHNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPPSModelObjId() != null) {
            object = pSModelObjBase.getPPSModelObjId();
            xmlNode.setAttribute(FIELD_PPSMODELOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSDEFId() != null) {
            object = pSModelObjBase.getPSDEFId();
            xmlNode.setAttribute(FIELD_PSDEFID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSDEFName() != null) {
            object = pSModelObjBase.getPSDEFName();
            xmlNode.setAttribute(FIELD_PSDEFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSDEId() != null) {
            object = pSModelObjBase.getPSDEId();
            xmlNode.setAttribute(FIELD_PSDEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSDEName() != null) {
            object = pSModelObjBase.getPSDEName();
            xmlNode.setAttribute(FIELD_PSDENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSDynaInstId() != null) {
            object = pSModelObjBase.getPSDynaInstId();
            xmlNode.setAttribute(FIELD_PSDYNAINSTID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSModelObjId() != null) {
            object = pSModelObjBase.getPSModelObjId();
            xmlNode.setAttribute(FIELD_PSMODELOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSModelObjName() != null) {
            object = pSModelObjBase.getPSModelObjName();
            xmlNode.setAttribute(FIELD_PSMODELOBJNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSModelSubType() != null) {
            object = pSModelObjBase.getPSModelSubType();
            xmlNode.setAttribute(FIELD_PSMODELSUBTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSModelType() != null) {
            object = pSModelObjBase.getPSModelType();
            xmlNode.setAttribute(FIELD_PSMODELTYPE, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSSysAppId() != null) {
            object = pSModelObjBase.getPSSysAppId();
            xmlNode.setAttribute(FIELD_PSSYSAPPID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSSysAppName() != null) {
            object = pSModelObjBase.getPSSysAppName();
            xmlNode.setAttribute(FIELD_PSSYSAPPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSSysSFPubId() != null) {
            object = pSModelObjBase.getPSSysSFPubId();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSSysSFPubName() != null) {
            object = pSModelObjBase.getPSSysSFPubName();
            xmlNode.setAttribute(FIELD_PSSYSSFPUBNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getPSSystemId() != null) {
            object = pSModelObjBase.getPSSystemId();
            xmlNode.setAttribute(FIELD_PSSYSTEMID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getRealModelObjId() != null) {
            object = pSModelObjBase.getRealModelObjId();
            xmlNode.setAttribute(FIELD_REALMODELOBJID, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getUpdateDate() != null) {
            object = pSModelObjBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelObjBase.getUpdateMan() != null) {
            object = pSModelObjBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getUserTag() != null) {
            object = pSModelObjBase.getUserTag();
            xmlNode.setAttribute(FIELD_USERTAG, object == null ? "" : (String)object);
        }
        if (bl || pSModelObjBase.getUserTag2() != null) {
            object = pSModelObjBase.getUserTag2();
            xmlNode.setAttribute(FIELD_USERTAG2, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelObjBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelObjBase pSModelObjBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelObjBase.isCodeNameDirty() && (bl || pSModelObjBase.getCodeName() != null)) {
            iDataObject.set(FIELD_CODENAME, (Object)pSModelObjBase.getCodeName());
        }
        if (pSModelObjBase.isContentDirty() && (bl || pSModelObjBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelObjBase.getContent());
        }
        if (pSModelObjBase.isCreateDateDirty() && (bl || pSModelObjBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelObjBase.getCreateDate());
        }
        if (pSModelObjBase.isCreateManDirty() && (bl || pSModelObjBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelObjBase.getCreateMan());
        }
        if (pSModelObjBase.isDynaModelFlagDirty() && (bl || pSModelObjBase.getDynaModelFlag() != null)) {
            iDataObject.set(FIELD_DYNAMODELFLAG, (Object)pSModelObjBase.getDynaModelFlag());
        }
        if (pSModelObjBase.isLogicNameDirty() && (bl || pSModelObjBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSModelObjBase.getLogicName());
        }
        if (pSModelObjBase.isMemoDirty() && (bl || pSModelObjBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelObjBase.getMemo());
        }
        if (pSModelObjBase.isModelDataDirty() && (bl || pSModelObjBase.getModelData() != null)) {
            iDataObject.set(FIELD_MODELDATA, (Object)pSModelObjBase.getModelData());
        }
        if (pSModelObjBase.isModelData2Dirty() && (bl || pSModelObjBase.getModelData2() != null)) {
            iDataObject.set(FIELD_MODELDATA2, (Object)pSModelObjBase.getModelData2());
        }
        if (pSModelObjBase.isModelTagDirty() && (bl || pSModelObjBase.getModelTag() != null)) {
            iDataObject.set(FIELD_MODELTAG, (Object)pSModelObjBase.getModelTag());
        }
        if (pSModelObjBase.isModelTag2Dirty() && (bl || pSModelObjBase.getModelTag2() != null)) {
            iDataObject.set(FIELD_MODELTAG2, (Object)pSModelObjBase.getModelTag2());
        }
        if (pSModelObjBase.isPathNameDirty() && (bl || pSModelObjBase.getPathName() != null)) {
            iDataObject.set(FIELD_PATHNAME, (Object)pSModelObjBase.getPathName());
        }
        if (pSModelObjBase.isPPSModelObjIdDirty() && (bl || pSModelObjBase.getPPSModelObjId() != null)) {
            iDataObject.set(FIELD_PPSMODELOBJID, (Object)pSModelObjBase.getPPSModelObjId());
        }
        if (pSModelObjBase.isPSDEFIdDirty() && (bl || pSModelObjBase.getPSDEFId() != null)) {
            iDataObject.set(FIELD_PSDEFID, (Object)pSModelObjBase.getPSDEFId());
        }
        if (pSModelObjBase.isPSDEFNameDirty() && (bl || pSModelObjBase.getPSDEFName() != null)) {
            iDataObject.set(FIELD_PSDEFNAME, (Object)pSModelObjBase.getPSDEFName());
        }
        if (pSModelObjBase.isPSDEIdDirty() && (bl || pSModelObjBase.getPSDEId() != null)) {
            iDataObject.set(FIELD_PSDEID, (Object)pSModelObjBase.getPSDEId());
        }
        if (pSModelObjBase.isPSDENameDirty() && (bl || pSModelObjBase.getPSDEName() != null)) {
            iDataObject.set(FIELD_PSDENAME, (Object)pSModelObjBase.getPSDEName());
        }
        if (pSModelObjBase.isPSDynaInstIdDirty() && (bl || pSModelObjBase.getPSDynaInstId() != null)) {
            iDataObject.set(FIELD_PSDYNAINSTID, (Object)pSModelObjBase.getPSDynaInstId());
        }
        if (pSModelObjBase.isPSModelObjIdDirty() && (bl || pSModelObjBase.getPSModelObjId() != null)) {
            iDataObject.set(FIELD_PSMODELOBJID, (Object)pSModelObjBase.getPSModelObjId());
        }
        if (pSModelObjBase.isPSModelObjNameDirty() && (bl || pSModelObjBase.getPSModelObjName() != null)) {
            iDataObject.set(FIELD_PSMODELOBJNAME, (Object)pSModelObjBase.getPSModelObjName());
        }
        if (pSModelObjBase.isPSModelSubTypeDirty() && (bl || pSModelObjBase.getPSModelSubType() != null)) {
            iDataObject.set(FIELD_PSMODELSUBTYPE, (Object)pSModelObjBase.getPSModelSubType());
        }
        if (pSModelObjBase.isPSModelTypeDirty() && (bl || pSModelObjBase.getPSModelType() != null)) {
            iDataObject.set(FIELD_PSMODELTYPE, (Object)pSModelObjBase.getPSModelType());
        }
        if (pSModelObjBase.isPSSysAppIdDirty() && (bl || pSModelObjBase.getPSSysAppId() != null)) {
            iDataObject.set(FIELD_PSSYSAPPID, (Object)pSModelObjBase.getPSSysAppId());
        }
        if (pSModelObjBase.isPSSysAppNameDirty() && (bl || pSModelObjBase.getPSSysAppName() != null)) {
            iDataObject.set(FIELD_PSSYSAPPNAME, (Object)pSModelObjBase.getPSSysAppName());
        }
        if (pSModelObjBase.isPSSysSFPubIdDirty() && (bl || pSModelObjBase.getPSSysSFPubId() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBID, (Object)pSModelObjBase.getPSSysSFPubId());
        }
        if (pSModelObjBase.isPSSysSFPubNameDirty() && (bl || pSModelObjBase.getPSSysSFPubName() != null)) {
            iDataObject.set(FIELD_PSSYSSFPUBNAME, (Object)pSModelObjBase.getPSSysSFPubName());
        }
        if (pSModelObjBase.isPSSystemIdDirty() && (bl || pSModelObjBase.getPSSystemId() != null)) {
            iDataObject.set(FIELD_PSSYSTEMID, (Object)pSModelObjBase.getPSSystemId());
        }
        if (pSModelObjBase.isRealModelObjIdDirty() && (bl || pSModelObjBase.getRealModelObjId() != null)) {
            iDataObject.set(FIELD_REALMODELOBJID, (Object)pSModelObjBase.getRealModelObjId());
        }
        if (pSModelObjBase.isUpdateDateDirty() && (bl || pSModelObjBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelObjBase.getUpdateDate());
        }
        if (pSModelObjBase.isUpdateManDirty() && (bl || pSModelObjBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelObjBase.getUpdateMan());
        }
        if (pSModelObjBase.isUserTagDirty() && (bl || pSModelObjBase.getUserTag() != null)) {
            iDataObject.set(FIELD_USERTAG, (Object)pSModelObjBase.getUserTag());
        }
        if (pSModelObjBase.isUserTag2Dirty() && (bl || pSModelObjBase.getUserTag2() != null)) {
            iDataObject.set(FIELD_USERTAG2, (Object)pSModelObjBase.getUserTag2());
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
        return PSModelObjBase.remove(this, n);
    }

    private static boolean remove(PSModelObjBase pSModelObjBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelObjBase.resetCodeName();
                return true;
            }
            case 1: {
                pSModelObjBase.resetContent();
                return true;
            }
            case 2: {
                pSModelObjBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSModelObjBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSModelObjBase.resetDynaModelFlag();
                return true;
            }
            case 5: {
                pSModelObjBase.resetLogicName();
                return true;
            }
            case 6: {
                pSModelObjBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelObjBase.resetModelData();
                return true;
            }
            case 8: {
                pSModelObjBase.resetModelData2();
                return true;
            }
            case 9: {
                pSModelObjBase.resetModelTag();
                return true;
            }
            case 10: {
                pSModelObjBase.resetModelTag2();
                return true;
            }
            case 11: {
                pSModelObjBase.resetPathName();
                return true;
            }
            case 12: {
                pSModelObjBase.resetPPSModelObjId();
                return true;
            }
            case 13: {
                pSModelObjBase.resetPSDEFId();
                return true;
            }
            case 14: {
                pSModelObjBase.resetPSDEFName();
                return true;
            }
            case 15: {
                pSModelObjBase.resetPSDEId();
                return true;
            }
            case 16: {
                pSModelObjBase.resetPSDEName();
                return true;
            }
            case 17: {
                pSModelObjBase.resetPSDynaInstId();
                return true;
            }
            case 18: {
                pSModelObjBase.resetPSModelObjId();
                return true;
            }
            case 19: {
                pSModelObjBase.resetPSModelObjName();
                return true;
            }
            case 20: {
                pSModelObjBase.resetPSModelSubType();
                return true;
            }
            case 21: {
                pSModelObjBase.resetPSModelType();
                return true;
            }
            case 22: {
                pSModelObjBase.resetPSSysAppId();
                return true;
            }
            case 23: {
                pSModelObjBase.resetPSSysAppName();
                return true;
            }
            case 24: {
                pSModelObjBase.resetPSSysSFPubId();
                return true;
            }
            case 25: {
                pSModelObjBase.resetPSSysSFPubName();
                return true;
            }
            case 26: {
                pSModelObjBase.resetPSSystemId();
                return true;
            }
            case 27: {
                pSModelObjBase.resetRealModelObjId();
                return true;
            }
            case 28: {
                pSModelObjBase.resetUpdateDate();
                return true;
            }
            case 29: {
                pSModelObjBase.resetUpdateMan();
                return true;
            }
            case 30: {
                pSModelObjBase.resetUserTag();
                return true;
            }
            case 31: {
                pSModelObjBase.resetUserTag2();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    private PSModelObjBase getProxyEntity() {
        return this.proxyPSModelObjBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelObjBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelObjBase) {
            this.proxyPSModelObjBase = (PSModelObjBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.sysdesign.service.PSModelObjService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CODENAME, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_DYNAMODELFLAG, 4);
        fieldIndexMap.put(FIELD_LOGICNAME, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_MODELDATA, 7);
        fieldIndexMap.put(FIELD_MODELDATA2, 8);
        fieldIndexMap.put(FIELD_MODELTAG, 9);
        fieldIndexMap.put(FIELD_MODELTAG2, 10);
        fieldIndexMap.put(FIELD_PATHNAME, 11);
        fieldIndexMap.put(FIELD_PPSMODELOBJID, 12);
        fieldIndexMap.put(FIELD_PSDEFID, 13);
        fieldIndexMap.put(FIELD_PSDEFNAME, 14);
        fieldIndexMap.put(FIELD_PSDEID, 15);
        fieldIndexMap.put(FIELD_PSDENAME, 16);
        fieldIndexMap.put(FIELD_PSDYNAINSTID, 17);
        fieldIndexMap.put(FIELD_PSMODELOBJID, 18);
        fieldIndexMap.put(FIELD_PSMODELOBJNAME, 19);
        fieldIndexMap.put(FIELD_PSMODELSUBTYPE, 20);
        fieldIndexMap.put(FIELD_PSMODELTYPE, 21);
        fieldIndexMap.put(FIELD_PSSYSAPPID, 22);
        fieldIndexMap.put(FIELD_PSSYSAPPNAME, 23);
        fieldIndexMap.put(FIELD_PSSYSSFPUBID, 24);
        fieldIndexMap.put(FIELD_PSSYSSFPUBNAME, 25);
        fieldIndexMap.put(FIELD_PSSYSTEMID, 26);
        fieldIndexMap.put(FIELD_REALMODELOBJID, 27);
        fieldIndexMap.put(FIELD_UPDATEDATE, 28);
        fieldIndexMap.put(FIELD_UPDATEMAN, 29);
        fieldIndexMap.put(FIELD_USERTAG, 30);
        fieldIndexMap.put(FIELD_USERTAG2, 31);
    }
}

