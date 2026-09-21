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
package net.ibizsys.pscore.srv.config.entity;

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
import net.ibizsys.pscore.srv.config.entity.PSModel;
import net.ibizsys.pscore.srv.config.entity.PSModelUIAction;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.config.service.PSModelUIActionService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelBase.class);
    public static final String FIELD_ARTICLEURL = "ARTICLEURL";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_ENABLEIBIZBAK = "ENABLEIBIZBAK";
    public static final String FIELD_ENABLEIMPORT = "ENABLEIMPORT";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_MODELCAT = "MODELCAT";
    public static final String FIELD_MODELDEID = "MODELDEID";
    public static final String FIELD_MODELDESC = "MODELDESC";
    public static final String FIELD_MODELINSTMODE = "MODELINSTMODE";
    public static final String FIELD_MODELSTATEFLAG = "MODELSTATEFLAG";
    public static final String FIELD_PPSMODELID = "PPSMODELID";
    public static final String FIELD_PPSMODELNAME = "PPSMODELNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_STARTERRORCODE = "STARTERRORCODE";
    public static final String FIELD_TYPEFIELD = "TYPEFIELD";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_TYPEVALUE = "TYPEVALUE";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_ARTICLEURL = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_ENABLEIBIZBAK = 3;
    private static final int INDEX_ENABLEIMPORT = 4;
    private static final int INDEX_MEMO = 5;
    private static final int INDEX_MODELCAT = 6;
    private static final int INDEX_MODELDEID = 7;
    private static final int INDEX_MODELDESC = 8;
    private static final int INDEX_MODELINSTMODE = 9;
    private static final int INDEX_MODELSTATEFLAG = 10;
    private static final int INDEX_PPSMODELID = 11;
    private static final int INDEX_PPSMODELNAME = 12;
    private static final int INDEX_PSMODELID = 13;
    private static final int INDEX_PSMODELNAME = 14;
    private static final int INDEX_STARTERRORCODE = 15;
    private static final int INDEX_TYPEFIELD = 16;
    private static final int INDEX_TYPEOBJ = 17;
    private static final int INDEX_TYPEVALUE = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_VALIDFLAG = 21;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelBase proxyPSModelBase = null;
    private boolean articleurlDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean enableibizbakDirtyFlag = false;
    private boolean enableimportDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean modelcatDirtyFlag = false;
    private boolean modeldeidDirtyFlag = false;
    private boolean modeldescDirtyFlag = false;
    private boolean modelinstmodeDirtyFlag = false;
    private boolean modelstateflagDirtyFlag = false;
    private boolean ppsmodelidDirtyFlag = false;
    private boolean ppsmodelnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean starterrorcodeDirtyFlag = false;
    private boolean typefieldDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean typevalueDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="articleurl")
    private String articleurl;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="enableibizbak")
    private Integer enableibizbak;
    @Column(name="enableimport")
    private Integer enableimport;
    @Column(name="memo")
    private String memo;
    @Column(name="modelcat")
    private String modelcat;
    @Column(name="modeldeid")
    private String modeldeid;
    @Column(name="modeldesc")
    private String modeldesc;
    @Column(name="modelinstmode")
    private Integer modelinstmode;
    @Column(name="modelstateflag")
    private Integer modelstateflag;
    @Column(name="ppsmodelid")
    private String ppsmodelid;
    @Column(name="ppsmodelname")
    private String ppsmodelname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="starterrorcode")
    private Integer starterrorcode;
    @Column(name="typefield")
    private String typefield;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="typevalue")
    private String typevalue;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPpsmodelLock = new Integer(1);
    private PSModel ppsmodel = null;
    private Integer objPSModelUIActionsLock = new Integer(1);
    private ArrayList<PSModelUIAction> psmodeluiactions = null;

    public void setArticleUrl(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setArticleUrl(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.articleurl = string;
        this.articleurlDirtyFlag = true;
    }

    public String getArticleUrl() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getArticleUrl();
        }
        return this.articleurl;
    }

    public boolean isArticleUrlDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isArticleUrlDirty();
        }
        return this.articleurlDirtyFlag;
    }

    public void resetArticleUrl() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetArticleUrl();
            return;
        }
        this.articleurlDirtyFlag = false;
        this.articleurl = null;
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

    public void setEnableIBizBak(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableIBizBak(n);
            return;
        }
        this.enableibizbak = n;
        this.enableibizbakDirtyFlag = true;
    }

    public Integer getEnableIBizBak() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableIBizBak();
        }
        return this.enableibizbak;
    }

    public boolean isEnableIBizBakDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableIBizBakDirty();
        }
        return this.enableibizbakDirtyFlag;
    }

    public void resetEnableIBizBak() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableIBizBak();
            return;
        }
        this.enableibizbakDirtyFlag = false;
        this.enableibizbak = null;
    }

    public void setEnableImport(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableImport(n);
            return;
        }
        this.enableimport = n;
        this.enableimportDirtyFlag = true;
    }

    public Integer getEnableImport() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableImport();
        }
        return this.enableimport;
    }

    public boolean isEnableImportDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableImportDirty();
        }
        return this.enableimportDirtyFlag;
    }

    public void resetEnableImport() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableImport();
            return;
        }
        this.enableimportDirtyFlag = false;
        this.enableimport = null;
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

    public void setModelCat(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelCat(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modelcat = string;
        this.modelcatDirtyFlag = true;
    }

    public String getModelCat() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelCat();
        }
        return this.modelcat;
    }

    public boolean isModelCatDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelCatDirty();
        }
        return this.modelcatDirtyFlag;
    }

    public void resetModelCat() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelCat();
            return;
        }
        this.modelcatDirtyFlag = false;
        this.modelcat = null;
    }

    public void setModelDEId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelDEId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeldeid = string;
        this.modeldeidDirtyFlag = true;
    }

    public String getModelDEId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelDEId();
        }
        return this.modeldeid;
    }

    public boolean isModelDEIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDEIdDirty();
        }
        return this.modeldeidDirtyFlag;
    }

    public void resetModelDEId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelDEId();
            return;
        }
        this.modeldeidDirtyFlag = false;
        this.modeldeid = null;
    }

    public void setModelDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.modeldesc = string;
        this.modeldescDirtyFlag = true;
    }

    public String getModelDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelDesc();
        }
        return this.modeldesc;
    }

    public boolean isModelDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelDescDirty();
        }
        return this.modeldescDirtyFlag;
    }

    public void resetModelDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelDesc();
            return;
        }
        this.modeldescDirtyFlag = false;
        this.modeldesc = null;
    }

    public void setModelInstMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelInstMode(n);
            return;
        }
        this.modelinstmode = n;
        this.modelinstmodeDirtyFlag = true;
    }

    public Integer getModelInstMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelInstMode();
        }
        return this.modelinstmode;
    }

    public boolean isModelInstModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelInstModeDirty();
        }
        return this.modelinstmodeDirtyFlag;
    }

    public void resetModelInstMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelInstMode();
            return;
        }
        this.modelinstmodeDirtyFlag = false;
        this.modelinstmode = null;
    }

    public void setModelStateFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setModelStateFlag(n);
            return;
        }
        this.modelstateflag = n;
        this.modelstateflagDirtyFlag = true;
    }

    public Integer getModelStateFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getModelStateFlag();
        }
        return this.modelstateflag;
    }

    public boolean isModelStateFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isModelStateFlagDirty();
        }
        return this.modelstateflagDirtyFlag;
    }

    public void resetModelStateFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetModelStateFlag();
            return;
        }
        this.modelstateflagDirtyFlag = false;
        this.modelstateflag = null;
    }

    public void setPPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelid = string;
        this.ppsmodelidDirtyFlag = true;
    }

    public String getPPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelId();
        }
        return this.ppsmodelid;
    }

    public boolean isPPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelIdDirty();
        }
        return this.ppsmodelidDirtyFlag;
    }

    public void resetPPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelId();
            return;
        }
        this.ppsmodelidDirtyFlag = false;
        this.ppsmodelid = null;
    }

    public void setPPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ppsmodelname = string;
        this.ppsmodelnameDirtyFlag = true;
    }

    public String getPPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPPSModelName();
        }
        return this.ppsmodelname;
    }

    public boolean isPPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPPSModelNameDirty();
        }
        return this.ppsmodelnameDirtyFlag;
    }

    public void resetPPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPPSModelName();
            return;
        }
        this.ppsmodelnameDirtyFlag = false;
        this.ppsmodelname = null;
    }

    public void setPSModelId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelid = string;
        this.psmodelidDirtyFlag = true;
    }

    public String getPSModelId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelId();
        }
        return this.psmodelid;
    }

    public boolean isPSModelIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelIdDirty();
        }
        return this.psmodelidDirtyFlag;
    }

    public void resetPSModelId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelId();
            return;
        }
        this.psmodelidDirtyFlag = false;
        this.psmodelid = null;
    }

    public void setPSModelName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelname = string;
        this.psmodelnameDirtyFlag = true;
    }

    public String getPSModelName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelName();
        }
        return this.psmodelname;
    }

    public boolean isPSModelNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelNameDirty();
        }
        return this.psmodelnameDirtyFlag;
    }

    public void resetPSModelName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelName();
            return;
        }
        this.psmodelnameDirtyFlag = false;
        this.psmodelname = null;
    }

    public void setStartErrorCode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStartErrorCode(n);
            return;
        }
        this.starterrorcode = n;
        this.starterrorcodeDirtyFlag = true;
    }

    public Integer getStartErrorCode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStartErrorCode();
        }
        return this.starterrorcode;
    }

    public boolean isStartErrorCodeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStartErrorCodeDirty();
        }
        return this.starterrorcodeDirtyFlag;
    }

    public void resetStartErrorCode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStartErrorCode();
            return;
        }
        this.starterrorcodeDirtyFlag = false;
        this.starterrorcode = null;
    }

    public void setTypeField(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeField(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typefield = string;
        this.typefieldDirtyFlag = true;
    }

    public String getTypeField() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeField();
        }
        return this.typefield;
    }

    public boolean isTypeFieldDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeFieldDirty();
        }
        return this.typefieldDirtyFlag;
    }

    public void resetTypeField() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeField();
            return;
        }
        this.typefieldDirtyFlag = false;
        this.typefield = null;
    }

    public void setTypeObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typeobj = string;
        this.typeobjDirtyFlag = true;
    }

    public String getTypeObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeObj();
        }
        return this.typeobj;
    }

    public boolean isTypeObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeObjDirty();
        }
        return this.typeobjDirtyFlag;
    }

    public void resetTypeObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeObj();
            return;
        }
        this.typeobjDirtyFlag = false;
        this.typeobj = null;
    }

    public void setTypeValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setTypeValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.typevalue = string;
        this.typevalueDirtyFlag = true;
    }

    public String getTypeValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getTypeValue();
        }
        return this.typevalue;
    }

    public boolean isTypeValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isTypeValueDirty();
        }
        return this.typevalueDirtyFlag;
    }

    public void resetTypeValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetTypeValue();
            return;
        }
        this.typevalueDirtyFlag = false;
        this.typevalue = null;
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
        PSModelBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelBase pSModelBase) {
        pSModelBase.resetArticleUrl();
        pSModelBase.resetCreateDate();
        pSModelBase.resetCreateMan();
        pSModelBase.resetEnableIBizBak();
        pSModelBase.resetEnableImport();
        pSModelBase.resetMemo();
        pSModelBase.resetModelCat();
        pSModelBase.resetModelDEId();
        pSModelBase.resetModelDesc();
        pSModelBase.resetModelInstMode();
        pSModelBase.resetModelStateFlag();
        pSModelBase.resetPPSModelId();
        pSModelBase.resetPPSModelName();
        pSModelBase.resetPSModelId();
        pSModelBase.resetPSModelName();
        pSModelBase.resetStartErrorCode();
        pSModelBase.resetTypeField();
        pSModelBase.resetTypeObj();
        pSModelBase.resetTypeValue();
        pSModelBase.resetUpdateDate();
        pSModelBase.resetUpdateMan();
        pSModelBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isArticleUrlDirty()) {
            hashMap.put(FIELD_ARTICLEURL, this.getArticleUrl());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isEnableIBizBakDirty()) {
            hashMap.put(FIELD_ENABLEIBIZBAK, this.getEnableIBizBak());
        }
        if (!bl || this.isEnableImportDirty()) {
            hashMap.put(FIELD_ENABLEIMPORT, this.getEnableImport());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isModelCatDirty()) {
            hashMap.put(FIELD_MODELCAT, this.getModelCat());
        }
        if (!bl || this.isModelDEIdDirty()) {
            hashMap.put(FIELD_MODELDEID, this.getModelDEId());
        }
        if (!bl || this.isModelDescDirty()) {
            hashMap.put(FIELD_MODELDESC, this.getModelDesc());
        }
        if (!bl || this.isModelInstModeDirty()) {
            hashMap.put(FIELD_MODELINSTMODE, this.getModelInstMode());
        }
        if (!bl || this.isModelStateFlagDirty()) {
            hashMap.put(FIELD_MODELSTATEFLAG, this.getModelStateFlag());
        }
        if (!bl || this.isPPSModelIdDirty()) {
            hashMap.put(FIELD_PPSMODELID, this.getPPSModelId());
        }
        if (!bl || this.isPPSModelNameDirty()) {
            hashMap.put(FIELD_PPSMODELNAME, this.getPPSModelName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isStartErrorCodeDirty()) {
            hashMap.put(FIELD_STARTERRORCODE, this.getStartErrorCode());
        }
        if (!bl || this.isTypeFieldDirty()) {
            hashMap.put(FIELD_TYPEFIELD, this.getTypeField());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isTypeValueDirty()) {
            hashMap.put(FIELD_TYPEVALUE, this.getTypeValue());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
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
        return PSModelBase.get(this, n);
    }

    private static Object get(PSModelBase pSModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBase.getArticleUrl();
            }
            case 1: {
                return pSModelBase.getCreateDate();
            }
            case 2: {
                return pSModelBase.getCreateMan();
            }
            case 3: {
                return pSModelBase.getEnableIBizBak();
            }
            case 4: {
                return pSModelBase.getEnableImport();
            }
            case 5: {
                return pSModelBase.getMemo();
            }
            case 6: {
                return pSModelBase.getModelCat();
            }
            case 7: {
                return pSModelBase.getModelDEId();
            }
            case 8: {
                return pSModelBase.getModelDesc();
            }
            case 9: {
                return pSModelBase.getModelInstMode();
            }
            case 10: {
                return pSModelBase.getModelStateFlag();
            }
            case 11: {
                return pSModelBase.getPPSModelId();
            }
            case 12: {
                return pSModelBase.getPPSModelName();
            }
            case 13: {
                return pSModelBase.getPSModelId();
            }
            case 14: {
                return pSModelBase.getPSModelName();
            }
            case 15: {
                return pSModelBase.getStartErrorCode();
            }
            case 16: {
                return pSModelBase.getTypeField();
            }
            case 17: {
                return pSModelBase.getTypeObj();
            }
            case 18: {
                return pSModelBase.getTypeValue();
            }
            case 19: {
                return pSModelBase.getUpdateDate();
            }
            case 20: {
                return pSModelBase.getUpdateMan();
            }
            case 21: {
                return pSModelBase.getValidFlag();
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
        PSModelBase.set(this, n, object);
    }

    private static void set(PSModelBase pSModelBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelBase.setArticleUrl(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSModelBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelBase.setEnableIBizBak(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 4: {
                pSModelBase.setEnableImport(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 5: {
                pSModelBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelBase.setModelCat(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelBase.setModelDEId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelBase.setModelDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelBase.setModelInstMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 10: {
                pSModelBase.setModelStateFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSModelBase.setPPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelBase.setPPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelBase.setStartErrorCode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSModelBase.setTypeField(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelBase.setTypeValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSModelBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSModelBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelBase.isNull(this, n);
    }

    private static boolean isNull(PSModelBase pSModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBase.getArticleUrl() == null;
            }
            case 1: {
                return pSModelBase.getCreateDate() == null;
            }
            case 2: {
                return pSModelBase.getCreateMan() == null;
            }
            case 3: {
                return pSModelBase.getEnableIBizBak() == null;
            }
            case 4: {
                return pSModelBase.getEnableImport() == null;
            }
            case 5: {
                return pSModelBase.getMemo() == null;
            }
            case 6: {
                return pSModelBase.getModelCat() == null;
            }
            case 7: {
                return pSModelBase.getModelDEId() == null;
            }
            case 8: {
                return pSModelBase.getModelDesc() == null;
            }
            case 9: {
                return pSModelBase.getModelInstMode() == null;
            }
            case 10: {
                return pSModelBase.getModelStateFlag() == null;
            }
            case 11: {
                return pSModelBase.getPPSModelId() == null;
            }
            case 12: {
                return pSModelBase.getPPSModelName() == null;
            }
            case 13: {
                return pSModelBase.getPSModelId() == null;
            }
            case 14: {
                return pSModelBase.getPSModelName() == null;
            }
            case 15: {
                return pSModelBase.getStartErrorCode() == null;
            }
            case 16: {
                return pSModelBase.getTypeField() == null;
            }
            case 17: {
                return pSModelBase.getTypeObj() == null;
            }
            case 18: {
                return pSModelBase.getTypeValue() == null;
            }
            case 19: {
                return pSModelBase.getUpdateDate() == null;
            }
            case 20: {
                return pSModelBase.getUpdateMan() == null;
            }
            case 21: {
                return pSModelBase.getValidFlag() == null;
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
        return PSModelBase.contains(this, n);
    }

    private static boolean contains(PSModelBase pSModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelBase.isArticleUrlDirty();
            }
            case 1: {
                return pSModelBase.isCreateDateDirty();
            }
            case 2: {
                return pSModelBase.isCreateManDirty();
            }
            case 3: {
                return pSModelBase.isEnableIBizBakDirty();
            }
            case 4: {
                return pSModelBase.isEnableImportDirty();
            }
            case 5: {
                return pSModelBase.isMemoDirty();
            }
            case 6: {
                return pSModelBase.isModelCatDirty();
            }
            case 7: {
                return pSModelBase.isModelDEIdDirty();
            }
            case 8: {
                return pSModelBase.isModelDescDirty();
            }
            case 9: {
                return pSModelBase.isModelInstModeDirty();
            }
            case 10: {
                return pSModelBase.isModelStateFlagDirty();
            }
            case 11: {
                return pSModelBase.isPPSModelIdDirty();
            }
            case 12: {
                return pSModelBase.isPPSModelNameDirty();
            }
            case 13: {
                return pSModelBase.isPSModelIdDirty();
            }
            case 14: {
                return pSModelBase.isPSModelNameDirty();
            }
            case 15: {
                return pSModelBase.isStartErrorCodeDirty();
            }
            case 16: {
                return pSModelBase.isTypeFieldDirty();
            }
            case 17: {
                return pSModelBase.isTypeObjDirty();
            }
            case 18: {
                return pSModelBase.isTypeValueDirty();
            }
            case 19: {
                return pSModelBase.isUpdateDateDirty();
            }
            case 20: {
                return pSModelBase.isUpdateManDirty();
            }
            case 21: {
                return pSModelBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelBase pSModelBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelBase.getArticleUrl() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"articleurl", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getArticleUrl()), (boolean)false);
        }
        if (bl || pSModelBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelBase.getEnableIBizBak() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableibizbak", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getEnableIBizBak()), (boolean)false);
        }
        if (bl || pSModelBase.getEnableImport() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enableimport", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getEnableImport()), (boolean)false);
        }
        if (bl || pSModelBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelBase.getModelCat() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelcat", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getModelCat()), (boolean)false);
        }
        if (bl || pSModelBase.getModelDEId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeldeid", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getModelDEId()), (boolean)false);
        }
        if (bl || pSModelBase.getModelDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modeldesc", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getModelDesc()), (boolean)false);
        }
        if (bl || pSModelBase.getModelInstMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelinstmode", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getModelInstMode()), (boolean)false);
        }
        if (bl || pSModelBase.getModelStateFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"modelstateflag", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getModelStateFlag()), (boolean)false);
        }
        if (bl || pSModelBase.getPPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelid", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getPPSModelId()), (boolean)false);
        }
        if (bl || pSModelBase.getPPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ppsmodelname", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getPPSModelName()), (boolean)false);
        }
        if (bl || pSModelBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelBase.getStartErrorCode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"starterrorcode", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getStartErrorCode()), (boolean)false);
        }
        if (bl || pSModelBase.getTypeField() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typefield", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getTypeField()), (boolean)false);
        }
        if (bl || pSModelBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSModelBase.getTypeValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typevalue", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getTypeValue()), (boolean)false);
        }
        if (bl || pSModelBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelBase.getJSONValue((Object)pSModelBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelBase pSModelBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelBase.getArticleUrl() != null) {
            object = pSModelBase.getArticleUrl();
            xmlNode.setAttribute(FIELD_ARTICLEURL, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getCreateDate() != null) {
            object = pSModelBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelBase.getCreateMan() != null) {
            object = pSModelBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getEnableIBizBak() != null) {
            object = pSModelBase.getEnableIBizBak();
            xmlNode.setAttribute(FIELD_ENABLEIBIZBAK, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBase.getEnableImport() != null) {
            object = pSModelBase.getEnableImport();
            xmlNode.setAttribute(FIELD_ENABLEIMPORT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBase.getMemo() != null) {
            object = pSModelBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getModelCat() != null) {
            object = pSModelBase.getModelCat();
            xmlNode.setAttribute(FIELD_MODELCAT, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getModelDEId() != null) {
            object = pSModelBase.getModelDEId();
            xmlNode.setAttribute(FIELD_MODELDEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getModelDesc() != null) {
            object = pSModelBase.getModelDesc();
            xmlNode.setAttribute(FIELD_MODELDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getModelInstMode() != null) {
            object = pSModelBase.getModelInstMode();
            xmlNode.setAttribute(FIELD_MODELINSTMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBase.getModelStateFlag() != null) {
            object = pSModelBase.getModelStateFlag();
            xmlNode.setAttribute(FIELD_MODELSTATEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBase.getPPSModelId() != null) {
            object = pSModelBase.getPPSModelId();
            xmlNode.setAttribute(FIELD_PPSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getPPSModelName() != null) {
            object = pSModelBase.getPPSModelName();
            xmlNode.setAttribute(FIELD_PPSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getPSModelId() != null) {
            object = pSModelBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getPSModelName() != null) {
            object = pSModelBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getStartErrorCode() != null) {
            object = pSModelBase.getStartErrorCode();
            xmlNode.setAttribute(FIELD_STARTERRORCODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelBase.getTypeField() != null) {
            object = pSModelBase.getTypeField();
            xmlNode.setAttribute(FIELD_TYPEFIELD, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getTypeObj() != null) {
            object = pSModelBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getTypeValue() != null) {
            object = pSModelBase.getTypeValue();
            xmlNode.setAttribute(FIELD_TYPEVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getUpdateDate() != null) {
            object = pSModelBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelBase.getUpdateMan() != null) {
            object = pSModelBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelBase.getValidFlag() != null) {
            object = pSModelBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelBase pSModelBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelBase.isArticleUrlDirty() && (bl || pSModelBase.getArticleUrl() != null)) {
            iDataObject.set(FIELD_ARTICLEURL, (Object)pSModelBase.getArticleUrl());
        }
        if (pSModelBase.isCreateDateDirty() && (bl || pSModelBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelBase.getCreateDate());
        }
        if (pSModelBase.isCreateManDirty() && (bl || pSModelBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelBase.getCreateMan());
        }
        if (pSModelBase.isEnableIBizBakDirty() && (bl || pSModelBase.getEnableIBizBak() != null)) {
            iDataObject.set(FIELD_ENABLEIBIZBAK, (Object)pSModelBase.getEnableIBizBak());
        }
        if (pSModelBase.isEnableImportDirty() && (bl || pSModelBase.getEnableImport() != null)) {
            iDataObject.set(FIELD_ENABLEIMPORT, (Object)pSModelBase.getEnableImport());
        }
        if (pSModelBase.isMemoDirty() && (bl || pSModelBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelBase.getMemo());
        }
        if (pSModelBase.isModelCatDirty() && (bl || pSModelBase.getModelCat() != null)) {
            iDataObject.set(FIELD_MODELCAT, (Object)pSModelBase.getModelCat());
        }
        if (pSModelBase.isModelDEIdDirty() && (bl || pSModelBase.getModelDEId() != null)) {
            iDataObject.set(FIELD_MODELDEID, (Object)pSModelBase.getModelDEId());
        }
        if (pSModelBase.isModelDescDirty() && (bl || pSModelBase.getModelDesc() != null)) {
            iDataObject.set(FIELD_MODELDESC, (Object)pSModelBase.getModelDesc());
        }
        if (pSModelBase.isModelInstModeDirty() && (bl || pSModelBase.getModelInstMode() != null)) {
            iDataObject.set(FIELD_MODELINSTMODE, (Object)pSModelBase.getModelInstMode());
        }
        if (pSModelBase.isModelStateFlagDirty() && (bl || pSModelBase.getModelStateFlag() != null)) {
            iDataObject.set(FIELD_MODELSTATEFLAG, (Object)pSModelBase.getModelStateFlag());
        }
        if (pSModelBase.isPPSModelIdDirty() && (bl || pSModelBase.getPPSModelId() != null)) {
            iDataObject.set(FIELD_PPSMODELID, (Object)pSModelBase.getPPSModelId());
        }
        if (pSModelBase.isPPSModelNameDirty() && (bl || pSModelBase.getPPSModelName() != null)) {
            iDataObject.set(FIELD_PPSMODELNAME, (Object)pSModelBase.getPPSModelName());
        }
        if (pSModelBase.isPSModelIdDirty() && (bl || pSModelBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelBase.getPSModelId());
        }
        if (pSModelBase.isPSModelNameDirty() && (bl || pSModelBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelBase.getPSModelName());
        }
        if (pSModelBase.isStartErrorCodeDirty() && (bl || pSModelBase.getStartErrorCode() != null)) {
            iDataObject.set(FIELD_STARTERRORCODE, (Object)pSModelBase.getStartErrorCode());
        }
        if (pSModelBase.isTypeFieldDirty() && (bl || pSModelBase.getTypeField() != null)) {
            iDataObject.set(FIELD_TYPEFIELD, (Object)pSModelBase.getTypeField());
        }
        if (pSModelBase.isTypeObjDirty() && (bl || pSModelBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSModelBase.getTypeObj());
        }
        if (pSModelBase.isTypeValueDirty() && (bl || pSModelBase.getTypeValue() != null)) {
            iDataObject.set(FIELD_TYPEVALUE, (Object)pSModelBase.getTypeValue());
        }
        if (pSModelBase.isUpdateDateDirty() && (bl || pSModelBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelBase.getUpdateDate());
        }
        if (pSModelBase.isUpdateManDirty() && (bl || pSModelBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelBase.getUpdateMan());
        }
        if (pSModelBase.isValidFlagDirty() && (bl || pSModelBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelBase.getValidFlag());
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
        return PSModelBase.remove(this, n);
    }

    private static boolean remove(PSModelBase pSModelBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelBase.resetArticleUrl();
                return true;
            }
            case 1: {
                pSModelBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSModelBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSModelBase.resetEnableIBizBak();
                return true;
            }
            case 4: {
                pSModelBase.resetEnableImport();
                return true;
            }
            case 5: {
                pSModelBase.resetMemo();
                return true;
            }
            case 6: {
                pSModelBase.resetModelCat();
                return true;
            }
            case 7: {
                pSModelBase.resetModelDEId();
                return true;
            }
            case 8: {
                pSModelBase.resetModelDesc();
                return true;
            }
            case 9: {
                pSModelBase.resetModelInstMode();
                return true;
            }
            case 10: {
                pSModelBase.resetModelStateFlag();
                return true;
            }
            case 11: {
                pSModelBase.resetPPSModelId();
                return true;
            }
            case 12: {
                pSModelBase.resetPPSModelName();
                return true;
            }
            case 13: {
                pSModelBase.resetPSModelId();
                return true;
            }
            case 14: {
                pSModelBase.resetPSModelName();
                return true;
            }
            case 15: {
                pSModelBase.resetStartErrorCode();
                return true;
            }
            case 16: {
                pSModelBase.resetTypeField();
                return true;
            }
            case 17: {
                pSModelBase.resetTypeObj();
                return true;
            }
            case 18: {
                pSModelBase.resetTypeValue();
                return true;
            }
            case 19: {
                pSModelBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSModelBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSModelBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPpsmodel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPpsmodel();
        }
        if (this.getPPSModelId() == null) {
            return null;
        }
        Integer n = this.objPpsmodelLock;
        synchronized (n) {
            if (this.ppsmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPPSModelId(), (Object)this.ppsmodel.getPSModelId()) != 0L) {
                this.ppsmodel = null;
            }
            if (this.ppsmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet((IEntity)pSModel);
                this.ppsmodel = pSModel;
            }
            return this.ppsmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSModelUIAction> getPSModelUIActions() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelUIActions();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        PSModelUIActionService pSModelUIActionService = (PSModelUIActionService)ServiceGlobal.getService(PSModelUIActionService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSModelUIActionsLock;
        synchronized (n) {
            if (this.psmodeluiactions == null) {
                this.psmodeluiactions = pSModelUIActionService.selectByPSModel(this);
            }
            return this.psmodeluiactions;
        }
    }

    private PSModelBase getProxyEntity() {
        return this.proxyPSModelBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelBase) {
            this.proxyPSModelBase = (PSModelBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_ARTICLEURL, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_ENABLEIBIZBAK, 3);
        fieldIndexMap.put(FIELD_ENABLEIMPORT, 4);
        fieldIndexMap.put(FIELD_MEMO, 5);
        fieldIndexMap.put(FIELD_MODELCAT, 6);
        fieldIndexMap.put(FIELD_MODELDEID, 7);
        fieldIndexMap.put(FIELD_MODELDESC, 8);
        fieldIndexMap.put(FIELD_MODELINSTMODE, 9);
        fieldIndexMap.put(FIELD_MODELSTATEFLAG, 10);
        fieldIndexMap.put(FIELD_PPSMODELID, 11);
        fieldIndexMap.put(FIELD_PPSMODELNAME, 12);
        fieldIndexMap.put(FIELD_PSMODELID, 13);
        fieldIndexMap.put(FIELD_PSMODELNAME, 14);
        fieldIndexMap.put(FIELD_STARTERRORCODE, 15);
        fieldIndexMap.put(FIELD_TYPEFIELD, 16);
        fieldIndexMap.put(FIELD_TYPEOBJ, 17);
        fieldIndexMap.put(FIELD_TYPEVALUE, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_VALIDFLAG, 21);
    }
}

