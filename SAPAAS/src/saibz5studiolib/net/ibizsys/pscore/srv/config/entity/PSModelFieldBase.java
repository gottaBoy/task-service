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
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelFieldBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelFieldBase.class);
    public static final String FIELD_CONCEPTCONTENT = "CONCEPTCONTENT";
    public static final String FIELD_CONCEPTFLAG = "CONCEPTFLAG";
    public static final String FIELD_CONCEPTORDERVALUE = "CONCEPTORDERVALUE";
    public static final String FIELD_CONCEPTTITLE = "CONCEPTTITLE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_DATATYPEDESC = "DATATYPEDESC";
    public static final String FIELD_DEFAULTVALUE = "DEFAULTVALUE";
    public static final String FIELD_FIELDDESC = "FIELDDESC";
    public static final String FIELD_FIELDDESC2 = "FIELDDESC2";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_LOGICNAME = "LOGICNAME";
    public static final String FIELD_MARKFLAG = "MARKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELFIELDID = "PSMODELFIELDID";
    public static final String FIELD_PSMODELFIELDNAME = "PSMODELFIELDNAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    private static final int INDEX_CONCEPTCONTENT = 0;
    private static final int INDEX_CONCEPTFLAG = 1;
    private static final int INDEX_CONCEPTORDERVALUE = 2;
    private static final int INDEX_CONCEPTTITLE = 3;
    private static final int INDEX_CREATEDATE = 4;
    private static final int INDEX_CREATEMAN = 5;
    private static final int INDEX_DATATYPEDESC = 6;
    private static final int INDEX_DEFAULTVALUE = 7;
    private static final int INDEX_FIELDDESC = 8;
    private static final int INDEX_FIELDDESC2 = 9;
    private static final int INDEX_IMAGEFLAG = 10;
    private static final int INDEX_LINKFLAG = 11;
    private static final int INDEX_LOGICNAME = 12;
    private static final int INDEX_MARKFLAG = 13;
    private static final int INDEX_MEMO = 14;
    private static final int INDEX_ORDERVALUE = 15;
    private static final int INDEX_PSMODELFIELDID = 16;
    private static final int INDEX_PSMODELFIELDNAME = 17;
    private static final int INDEX_PSMODELID = 18;
    private static final int INDEX_PSMODELNAME = 19;
    private static final int INDEX_UPDATEDATE = 20;
    private static final int INDEX_UPDATEMAN = 21;
    private static final int INDEX_VALIDFLAG = 22;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelFieldBase proxyPSModelFieldBase = null;
    private boolean conceptcontentDirtyFlag = false;
    private boolean conceptflagDirtyFlag = false;
    private boolean conceptordervalueDirtyFlag = false;
    private boolean concepttitleDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean datatypedescDirtyFlag = false;
    private boolean defaultvalueDirtyFlag = false;
    private boolean fielddescDirtyFlag = false;
    private boolean fielddesc2DirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean logicnameDirtyFlag = false;
    private boolean markflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelfieldidDirtyFlag = false;
    private boolean psmodelfieldnameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    @Column(name="conceptcontent")
    private String conceptcontent;
    @Column(name="conceptflag")
    private Integer conceptflag;
    @Column(name="conceptordervalue")
    private Integer conceptordervalue;
    @Column(name="concepttitle")
    private String concepttitle;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="datatypedesc")
    private String datatypedesc;
    @Column(name="defaultvalue")
    private String defaultvalue;
    @Column(name="fielddesc")
    private String fielddesc;
    @Column(name="fielddesc2")
    private String fielddesc2;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="logicname")
    private String logicname;
    @Column(name="markflag")
    private Integer markflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelfieldid")
    private String psmodelfieldid;
    @Column(name="psmodelfieldname")
    private String psmodelfieldname;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;

    public void setConceptContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConceptContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.conceptcontent = string;
        this.conceptcontentDirtyFlag = true;
    }

    public String getConceptContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConceptContent();
        }
        return this.conceptcontent;
    }

    public boolean isConceptContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConceptContentDirty();
        }
        return this.conceptcontentDirtyFlag;
    }

    public void resetConceptContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConceptContent();
            return;
        }
        this.conceptcontentDirtyFlag = false;
        this.conceptcontent = null;
    }

    public void setConceptFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConceptFlag(n);
            return;
        }
        this.conceptflag = n;
        this.conceptflagDirtyFlag = true;
    }

    public Integer getConceptFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConceptFlag();
        }
        return this.conceptflag;
    }

    public boolean isConceptFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConceptFlagDirty();
        }
        return this.conceptflagDirtyFlag;
    }

    public void resetConceptFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConceptFlag();
            return;
        }
        this.conceptflagDirtyFlag = false;
        this.conceptflag = null;
    }

    public void setConceptOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConceptOrderValue(n);
            return;
        }
        this.conceptordervalue = n;
        this.conceptordervalueDirtyFlag = true;
    }

    public Integer getConceptOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConceptOrderValue();
        }
        return this.conceptordervalue;
    }

    public boolean isConceptOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConceptOrderValueDirty();
        }
        return this.conceptordervalueDirtyFlag;
    }

    public void resetConceptOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConceptOrderValue();
            return;
        }
        this.conceptordervalueDirtyFlag = false;
        this.conceptordervalue = null;
    }

    public void setConceptTitle(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setConceptTitle(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.concepttitle = string;
        this.concepttitleDirtyFlag = true;
    }

    public String getConceptTitle() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getConceptTitle();
        }
        return this.concepttitle;
    }

    public boolean isConceptTitleDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isConceptTitleDirty();
        }
        return this.concepttitleDirtyFlag;
    }

    public void resetConceptTitle() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetConceptTitle();
            return;
        }
        this.concepttitleDirtyFlag = false;
        this.concepttitle = null;
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

    public void setDataTypeDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDataTypeDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.datatypedesc = string;
        this.datatypedescDirtyFlag = true;
    }

    public String getDataTypeDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDataTypeDesc();
        }
        return this.datatypedesc;
    }

    public boolean isDataTypeDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDataTypeDescDirty();
        }
        return this.datatypedescDirtyFlag;
    }

    public void resetDataTypeDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDataTypeDesc();
            return;
        }
        this.datatypedescDirtyFlag = false;
        this.datatypedesc = null;
    }

    public void setDefaultValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setDefaultValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.defaultvalue = string;
        this.defaultvalueDirtyFlag = true;
    }

    public String getDefaultValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getDefaultValue();
        }
        return this.defaultvalue;
    }

    public boolean isDefaultValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isDefaultValueDirty();
        }
        return this.defaultvalueDirtyFlag;
    }

    public void resetDefaultValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetDefaultValue();
            return;
        }
        this.defaultvalueDirtyFlag = false;
        this.defaultvalue = null;
    }

    public void setFieldDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fielddesc = string;
        this.fielddescDirtyFlag = true;
    }

    public String getFieldDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldDesc();
        }
        return this.fielddesc;
    }

    public boolean isFieldDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldDescDirty();
        }
        return this.fielddescDirtyFlag;
    }

    public void resetFieldDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldDesc();
            return;
        }
        this.fielddescDirtyFlag = false;
        this.fielddesc = null;
    }

    public void setFieldDesc2(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFieldDesc2(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.fielddesc2 = string;
        this.fielddesc2DirtyFlag = true;
    }

    public String getFieldDesc2() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFieldDesc2();
        }
        return this.fielddesc2;
    }

    public boolean isFieldDesc2Dirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFieldDesc2Dirty();
        }
        return this.fielddesc2DirtyFlag;
    }

    public void resetFieldDesc2() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFieldDesc2();
            return;
        }
        this.fielddesc2DirtyFlag = false;
        this.fielddesc2 = null;
    }

    public void setImageFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setImageFlag(n);
            return;
        }
        this.imageflag = n;
        this.imageflagDirtyFlag = true;
    }

    public Integer getImageFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getImageFlag();
        }
        return this.imageflag;
    }

    public boolean isImageFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isImageFlagDirty();
        }
        return this.imageflagDirtyFlag;
    }

    public void resetImageFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetImageFlag();
            return;
        }
        this.imageflagDirtyFlag = false;
        this.imageflag = null;
    }

    public void setLinkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setLinkFlag(n);
            return;
        }
        this.linkflag = n;
        this.linkflagDirtyFlag = true;
    }

    public Integer getLinkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getLinkFlag();
        }
        return this.linkflag;
    }

    public boolean isLinkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isLinkFlagDirty();
        }
        return this.linkflagDirtyFlag;
    }

    public void resetLinkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetLinkFlag();
            return;
        }
        this.linkflagDirtyFlag = false;
        this.linkflag = null;
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

    public void setMarkFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setMarkFlag(n);
            return;
        }
        this.markflag = n;
        this.markflagDirtyFlag = true;
    }

    public Integer getMarkFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getMarkFlag();
        }
        return this.markflag;
    }

    public boolean isMarkFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isMarkFlagDirty();
        }
        return this.markflagDirtyFlag;
    }

    public void resetMarkFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetMarkFlag();
            return;
        }
        this.markflagDirtyFlag = false;
        this.markflag = null;
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

    public void setOrderValue(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setOrderValue(n);
            return;
        }
        this.ordervalue = n;
        this.ordervalueDirtyFlag = true;
    }

    public Integer getOrderValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getOrderValue();
        }
        return this.ordervalue;
    }

    public boolean isOrderValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isOrderValueDirty();
        }
        return this.ordervalueDirtyFlag;
    }

    public void resetOrderValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetOrderValue();
            return;
        }
        this.ordervalueDirtyFlag = false;
        this.ordervalue = null;
    }

    public void setPSModelFieldId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldid = string;
        this.psmodelfieldidDirtyFlag = true;
    }

    public String getPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldId();
        }
        return this.psmodelfieldid;
    }

    public boolean isPSModelFieldIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldIdDirty();
        }
        return this.psmodelfieldidDirtyFlag;
    }

    public void resetPSModelFieldId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldId();
            return;
        }
        this.psmodelfieldidDirtyFlag = false;
        this.psmodelfieldid = null;
    }

    public void setPSModelFieldName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldname = string;
        this.psmodelfieldnameDirtyFlag = true;
    }

    public String getPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldName();
        }
        return this.psmodelfieldname;
    }

    public boolean isPSModelFieldNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldNameDirty();
        }
        return this.psmodelfieldnameDirtyFlag;
    }

    public void resetPSModelFieldName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldName();
            return;
        }
        this.psmodelfieldnameDirtyFlag = false;
        this.psmodelfieldname = null;
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
        PSModelFieldBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelFieldBase pSModelFieldBase) {
        pSModelFieldBase.resetConceptContent();
        pSModelFieldBase.resetConceptFlag();
        pSModelFieldBase.resetConceptOrderValue();
        pSModelFieldBase.resetConceptTitle();
        pSModelFieldBase.resetCreateDate();
        pSModelFieldBase.resetCreateMan();
        pSModelFieldBase.resetDataTypeDesc();
        pSModelFieldBase.resetDefaultValue();
        pSModelFieldBase.resetFieldDesc();
        pSModelFieldBase.resetFieldDesc2();
        pSModelFieldBase.resetImageFlag();
        pSModelFieldBase.resetLinkFlag();
        pSModelFieldBase.resetLogicName();
        pSModelFieldBase.resetMarkFlag();
        pSModelFieldBase.resetMemo();
        pSModelFieldBase.resetOrderValue();
        pSModelFieldBase.resetPSModelFieldId();
        pSModelFieldBase.resetPSModelFieldName();
        pSModelFieldBase.resetPSModelId();
        pSModelFieldBase.resetPSModelName();
        pSModelFieldBase.resetUpdateDate();
        pSModelFieldBase.resetUpdateMan();
        pSModelFieldBase.resetValidFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConceptContentDirty()) {
            hashMap.put(FIELD_CONCEPTCONTENT, this.getConceptContent());
        }
        if (!bl || this.isConceptFlagDirty()) {
            hashMap.put(FIELD_CONCEPTFLAG, this.getConceptFlag());
        }
        if (!bl || this.isConceptOrderValueDirty()) {
            hashMap.put(FIELD_CONCEPTORDERVALUE, this.getConceptOrderValue());
        }
        if (!bl || this.isConceptTitleDirty()) {
            hashMap.put(FIELD_CONCEPTTITLE, this.getConceptTitle());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isDataTypeDescDirty()) {
            hashMap.put(FIELD_DATATYPEDESC, this.getDataTypeDesc());
        }
        if (!bl || this.isDefaultValueDirty()) {
            hashMap.put(FIELD_DEFAULTVALUE, this.getDefaultValue());
        }
        if (!bl || this.isFieldDescDirty()) {
            hashMap.put(FIELD_FIELDDESC, this.getFieldDesc());
        }
        if (!bl || this.isFieldDesc2Dirty()) {
            hashMap.put(FIELD_FIELDDESC2, this.getFieldDesc2());
        }
        if (!bl || this.isImageFlagDirty()) {
            hashMap.put(FIELD_IMAGEFLAG, this.getImageFlag());
        }
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
        }
        if (!bl || this.isLogicNameDirty()) {
            hashMap.put(FIELD_LOGICNAME, this.getLogicName());
        }
        if (!bl || this.isMarkFlagDirty()) {
            hashMap.put(FIELD_MARKFLAG, this.getMarkFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isOrderValueDirty()) {
            hashMap.put(FIELD_ORDERVALUE, this.getOrderValue());
        }
        if (!bl || this.isPSModelFieldIdDirty()) {
            hashMap.put(FIELD_PSMODELFIELDID, this.getPSModelFieldId());
        }
        if (!bl || this.isPSModelFieldNameDirty()) {
            hashMap.put(FIELD_PSMODELFIELDNAME, this.getPSModelFieldName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
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
        return PSModelFieldBase.get(this, n);
    }

    private static Object get(PSModelFieldBase pSModelFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldBase.getConceptContent();
            }
            case 1: {
                return pSModelFieldBase.getConceptFlag();
            }
            case 2: {
                return pSModelFieldBase.getConceptOrderValue();
            }
            case 3: {
                return pSModelFieldBase.getConceptTitle();
            }
            case 4: {
                return pSModelFieldBase.getCreateDate();
            }
            case 5: {
                return pSModelFieldBase.getCreateMan();
            }
            case 6: {
                return pSModelFieldBase.getDataTypeDesc();
            }
            case 7: {
                return pSModelFieldBase.getDefaultValue();
            }
            case 8: {
                return pSModelFieldBase.getFieldDesc();
            }
            case 9: {
                return pSModelFieldBase.getFieldDesc2();
            }
            case 10: {
                return pSModelFieldBase.getImageFlag();
            }
            case 11: {
                return pSModelFieldBase.getLinkFlag();
            }
            case 12: {
                return pSModelFieldBase.getLogicName();
            }
            case 13: {
                return pSModelFieldBase.getMarkFlag();
            }
            case 14: {
                return pSModelFieldBase.getMemo();
            }
            case 15: {
                return pSModelFieldBase.getOrderValue();
            }
            case 16: {
                return pSModelFieldBase.getPSModelFieldId();
            }
            case 17: {
                return pSModelFieldBase.getPSModelFieldName();
            }
            case 18: {
                return pSModelFieldBase.getPSModelId();
            }
            case 19: {
                return pSModelFieldBase.getPSModelName();
            }
            case 20: {
                return pSModelFieldBase.getUpdateDate();
            }
            case 21: {
                return pSModelFieldBase.getUpdateMan();
            }
            case 22: {
                return pSModelFieldBase.getValidFlag();
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
        PSModelFieldBase.set(this, n, object);
    }

    private static void set(PSModelFieldBase pSModelFieldBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelFieldBase.setConceptContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelFieldBase.setConceptFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSModelFieldBase.setConceptOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 3: {
                pSModelFieldBase.setConceptTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelFieldBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 5: {
                pSModelFieldBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSModelFieldBase.setDataTypeDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelFieldBase.setDefaultValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelFieldBase.setFieldDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelFieldBase.setFieldDesc2(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelFieldBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 11: {
                pSModelFieldBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 12: {
                pSModelFieldBase.setLogicName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelFieldBase.setMarkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 14: {
                pSModelFieldBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelFieldBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 16: {
                pSModelFieldBase.setPSModelFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelFieldBase.setPSModelFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSModelFieldBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelFieldBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSModelFieldBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 21: {
                pSModelFieldBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 22: {
                pSModelFieldBase.setValidFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelFieldBase.isNull(this, n);
    }

    private static boolean isNull(PSModelFieldBase pSModelFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldBase.getConceptContent() == null;
            }
            case 1: {
                return pSModelFieldBase.getConceptFlag() == null;
            }
            case 2: {
                return pSModelFieldBase.getConceptOrderValue() == null;
            }
            case 3: {
                return pSModelFieldBase.getConceptTitle() == null;
            }
            case 4: {
                return pSModelFieldBase.getCreateDate() == null;
            }
            case 5: {
                return pSModelFieldBase.getCreateMan() == null;
            }
            case 6: {
                return pSModelFieldBase.getDataTypeDesc() == null;
            }
            case 7: {
                return pSModelFieldBase.getDefaultValue() == null;
            }
            case 8: {
                return pSModelFieldBase.getFieldDesc() == null;
            }
            case 9: {
                return pSModelFieldBase.getFieldDesc2() == null;
            }
            case 10: {
                return pSModelFieldBase.getImageFlag() == null;
            }
            case 11: {
                return pSModelFieldBase.getLinkFlag() == null;
            }
            case 12: {
                return pSModelFieldBase.getLogicName() == null;
            }
            case 13: {
                return pSModelFieldBase.getMarkFlag() == null;
            }
            case 14: {
                return pSModelFieldBase.getMemo() == null;
            }
            case 15: {
                return pSModelFieldBase.getOrderValue() == null;
            }
            case 16: {
                return pSModelFieldBase.getPSModelFieldId() == null;
            }
            case 17: {
                return pSModelFieldBase.getPSModelFieldName() == null;
            }
            case 18: {
                return pSModelFieldBase.getPSModelId() == null;
            }
            case 19: {
                return pSModelFieldBase.getPSModelName() == null;
            }
            case 20: {
                return pSModelFieldBase.getUpdateDate() == null;
            }
            case 21: {
                return pSModelFieldBase.getUpdateMan() == null;
            }
            case 22: {
                return pSModelFieldBase.getValidFlag() == null;
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
        return PSModelFieldBase.contains(this, n);
    }

    private static boolean contains(PSModelFieldBase pSModelFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldBase.isConceptContentDirty();
            }
            case 1: {
                return pSModelFieldBase.isConceptFlagDirty();
            }
            case 2: {
                return pSModelFieldBase.isConceptOrderValueDirty();
            }
            case 3: {
                return pSModelFieldBase.isConceptTitleDirty();
            }
            case 4: {
                return pSModelFieldBase.isCreateDateDirty();
            }
            case 5: {
                return pSModelFieldBase.isCreateManDirty();
            }
            case 6: {
                return pSModelFieldBase.isDataTypeDescDirty();
            }
            case 7: {
                return pSModelFieldBase.isDefaultValueDirty();
            }
            case 8: {
                return pSModelFieldBase.isFieldDescDirty();
            }
            case 9: {
                return pSModelFieldBase.isFieldDesc2Dirty();
            }
            case 10: {
                return pSModelFieldBase.isImageFlagDirty();
            }
            case 11: {
                return pSModelFieldBase.isLinkFlagDirty();
            }
            case 12: {
                return pSModelFieldBase.isLogicNameDirty();
            }
            case 13: {
                return pSModelFieldBase.isMarkFlagDirty();
            }
            case 14: {
                return pSModelFieldBase.isMemoDirty();
            }
            case 15: {
                return pSModelFieldBase.isOrderValueDirty();
            }
            case 16: {
                return pSModelFieldBase.isPSModelFieldIdDirty();
            }
            case 17: {
                return pSModelFieldBase.isPSModelFieldNameDirty();
            }
            case 18: {
                return pSModelFieldBase.isPSModelIdDirty();
            }
            case 19: {
                return pSModelFieldBase.isPSModelNameDirty();
            }
            case 20: {
                return pSModelFieldBase.isUpdateDateDirty();
            }
            case 21: {
                return pSModelFieldBase.isUpdateManDirty();
            }
            case 22: {
                return pSModelFieldBase.isValidFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelFieldBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelFieldBase pSModelFieldBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelFieldBase.getConceptContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"conceptcontent", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getConceptContent()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getConceptFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"conceptflag", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getConceptFlag()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getConceptOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"conceptordervalue", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getConceptOrderValue()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getConceptTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"concepttitle", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getConceptTitle()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getDataTypeDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"datatypedesc", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getDataTypeDesc()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getDefaultValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"defaultvalue", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getDefaultValue()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getFieldDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fielddesc", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getFieldDesc()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getFieldDesc2() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"fielddesc2", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getFieldDesc2()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getLogicName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"logicname", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getLogicName()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getMarkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"markflag", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getMarkFlag()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getPSModelFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldid", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getPSModelFieldId()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getPSModelFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldname", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getPSModelFieldName()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelFieldBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelFieldBase.getJSONValue((Object)pSModelFieldBase.getValidFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelFieldBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelFieldBase pSModelFieldBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelFieldBase.getConceptContent() != null) {
            object = pSModelFieldBase.getConceptContent();
            xmlNode.setAttribute(FIELD_CONCEPTCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getConceptFlag() != null) {
            object = pSModelFieldBase.getConceptFlag();
            xmlNode.setAttribute(FIELD_CONCEPTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getConceptOrderValue() != null) {
            object = pSModelFieldBase.getConceptOrderValue();
            xmlNode.setAttribute(FIELD_CONCEPTORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getConceptTitle() != null) {
            object = pSModelFieldBase.getConceptTitle();
            xmlNode.setAttribute(FIELD_CONCEPTTITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getCreateDate() != null) {
            object = pSModelFieldBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelFieldBase.getCreateMan() != null) {
            object = pSModelFieldBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getDataTypeDesc() != null) {
            object = pSModelFieldBase.getDataTypeDesc();
            xmlNode.setAttribute(FIELD_DATATYPEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getDefaultValue() != null) {
            object = pSModelFieldBase.getDefaultValue();
            xmlNode.setAttribute(FIELD_DEFAULTVALUE, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getFieldDesc() != null) {
            object = pSModelFieldBase.getFieldDesc();
            xmlNode.setAttribute(FIELD_FIELDDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getFieldDesc2() != null) {
            object = pSModelFieldBase.getFieldDesc2();
            xmlNode.setAttribute(FIELD_FIELDDESC2, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getImageFlag() != null) {
            object = pSModelFieldBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getLinkFlag() != null) {
            object = pSModelFieldBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getLogicName() != null) {
            object = pSModelFieldBase.getLogicName();
            xmlNode.setAttribute(FIELD_LOGICNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getMarkFlag() != null) {
            object = pSModelFieldBase.getMarkFlag();
            xmlNode.setAttribute(FIELD_MARKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getMemo() != null) {
            object = pSModelFieldBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getOrderValue() != null) {
            object = pSModelFieldBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldBase.getPSModelFieldId() != null) {
            object = pSModelFieldBase.getPSModelFieldId();
            xmlNode.setAttribute(FIELD_PSMODELFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getPSModelFieldName() != null) {
            object = pSModelFieldBase.getPSModelFieldName();
            xmlNode.setAttribute(FIELD_PSMODELFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getPSModelId() != null) {
            object = pSModelFieldBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getPSModelName() != null) {
            object = pSModelFieldBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getUpdateDate() != null) {
            object = pSModelFieldBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelFieldBase.getUpdateMan() != null) {
            object = pSModelFieldBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldBase.getValidFlag() != null) {
            object = pSModelFieldBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelFieldBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelFieldBase pSModelFieldBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelFieldBase.isConceptContentDirty() && (bl || pSModelFieldBase.getConceptContent() != null)) {
            iDataObject.set(FIELD_CONCEPTCONTENT, (Object)pSModelFieldBase.getConceptContent());
        }
        if (pSModelFieldBase.isConceptFlagDirty() && (bl || pSModelFieldBase.getConceptFlag() != null)) {
            iDataObject.set(FIELD_CONCEPTFLAG, (Object)pSModelFieldBase.getConceptFlag());
        }
        if (pSModelFieldBase.isConceptOrderValueDirty() && (bl || pSModelFieldBase.getConceptOrderValue() != null)) {
            iDataObject.set(FIELD_CONCEPTORDERVALUE, (Object)pSModelFieldBase.getConceptOrderValue());
        }
        if (pSModelFieldBase.isConceptTitleDirty() && (bl || pSModelFieldBase.getConceptTitle() != null)) {
            iDataObject.set(FIELD_CONCEPTTITLE, (Object)pSModelFieldBase.getConceptTitle());
        }
        if (pSModelFieldBase.isCreateDateDirty() && (bl || pSModelFieldBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelFieldBase.getCreateDate());
        }
        if (pSModelFieldBase.isCreateManDirty() && (bl || pSModelFieldBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelFieldBase.getCreateMan());
        }
        if (pSModelFieldBase.isDataTypeDescDirty() && (bl || pSModelFieldBase.getDataTypeDesc() != null)) {
            iDataObject.set(FIELD_DATATYPEDESC, (Object)pSModelFieldBase.getDataTypeDesc());
        }
        if (pSModelFieldBase.isDefaultValueDirty() && (bl || pSModelFieldBase.getDefaultValue() != null)) {
            iDataObject.set(FIELD_DEFAULTVALUE, (Object)pSModelFieldBase.getDefaultValue());
        }
        if (pSModelFieldBase.isFieldDescDirty() && (bl || pSModelFieldBase.getFieldDesc() != null)) {
            iDataObject.set(FIELD_FIELDDESC, (Object)pSModelFieldBase.getFieldDesc());
        }
        if (pSModelFieldBase.isFieldDesc2Dirty() && (bl || pSModelFieldBase.getFieldDesc2() != null)) {
            iDataObject.set(FIELD_FIELDDESC2, (Object)pSModelFieldBase.getFieldDesc2());
        }
        if (pSModelFieldBase.isImageFlagDirty() && (bl || pSModelFieldBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelFieldBase.getImageFlag());
        }
        if (pSModelFieldBase.isLinkFlagDirty() && (bl || pSModelFieldBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSModelFieldBase.getLinkFlag());
        }
        if (pSModelFieldBase.isLogicNameDirty() && (bl || pSModelFieldBase.getLogicName() != null)) {
            iDataObject.set(FIELD_LOGICNAME, (Object)pSModelFieldBase.getLogicName());
        }
        if (pSModelFieldBase.isMarkFlagDirty() && (bl || pSModelFieldBase.getMarkFlag() != null)) {
            iDataObject.set(FIELD_MARKFLAG, (Object)pSModelFieldBase.getMarkFlag());
        }
        if (pSModelFieldBase.isMemoDirty() && (bl || pSModelFieldBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelFieldBase.getMemo());
        }
        if (pSModelFieldBase.isOrderValueDirty() && (bl || pSModelFieldBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelFieldBase.getOrderValue());
        }
        if (pSModelFieldBase.isPSModelFieldIdDirty() && (bl || pSModelFieldBase.getPSModelFieldId() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDID, (Object)pSModelFieldBase.getPSModelFieldId());
        }
        if (pSModelFieldBase.isPSModelFieldNameDirty() && (bl || pSModelFieldBase.getPSModelFieldName() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDNAME, (Object)pSModelFieldBase.getPSModelFieldName());
        }
        if (pSModelFieldBase.isPSModelIdDirty() && (bl || pSModelFieldBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelFieldBase.getPSModelId());
        }
        if (pSModelFieldBase.isPSModelNameDirty() && (bl || pSModelFieldBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelFieldBase.getPSModelName());
        }
        if (pSModelFieldBase.isUpdateDateDirty() && (bl || pSModelFieldBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelFieldBase.getUpdateDate());
        }
        if (pSModelFieldBase.isUpdateManDirty() && (bl || pSModelFieldBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelFieldBase.getUpdateMan());
        }
        if (pSModelFieldBase.isValidFlagDirty() && (bl || pSModelFieldBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelFieldBase.getValidFlag());
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
        return PSModelFieldBase.remove(this, n);
    }

    private static boolean remove(PSModelFieldBase pSModelFieldBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelFieldBase.resetConceptContent();
                return true;
            }
            case 1: {
                pSModelFieldBase.resetConceptFlag();
                return true;
            }
            case 2: {
                pSModelFieldBase.resetConceptOrderValue();
                return true;
            }
            case 3: {
                pSModelFieldBase.resetConceptTitle();
                return true;
            }
            case 4: {
                pSModelFieldBase.resetCreateDate();
                return true;
            }
            case 5: {
                pSModelFieldBase.resetCreateMan();
                return true;
            }
            case 6: {
                pSModelFieldBase.resetDataTypeDesc();
                return true;
            }
            case 7: {
                pSModelFieldBase.resetDefaultValue();
                return true;
            }
            case 8: {
                pSModelFieldBase.resetFieldDesc();
                return true;
            }
            case 9: {
                pSModelFieldBase.resetFieldDesc2();
                return true;
            }
            case 10: {
                pSModelFieldBase.resetImageFlag();
                return true;
            }
            case 11: {
                pSModelFieldBase.resetLinkFlag();
                return true;
            }
            case 12: {
                pSModelFieldBase.resetLogicName();
                return true;
            }
            case 13: {
                pSModelFieldBase.resetMarkFlag();
                return true;
            }
            case 14: {
                pSModelFieldBase.resetMemo();
                return true;
            }
            case 15: {
                pSModelFieldBase.resetOrderValue();
                return true;
            }
            case 16: {
                pSModelFieldBase.resetPSModelFieldId();
                return true;
            }
            case 17: {
                pSModelFieldBase.resetPSModelFieldName();
                return true;
            }
            case 18: {
                pSModelFieldBase.resetPSModelId();
                return true;
            }
            case 19: {
                pSModelFieldBase.resetPSModelName();
                return true;
            }
            case 20: {
                pSModelFieldBase.resetUpdateDate();
                return true;
            }
            case 21: {
                pSModelFieldBase.resetUpdateMan();
                return true;
            }
            case 22: {
                pSModelFieldBase.resetValidFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModel getPSModel() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModel();
        }
        if (this.getPSModelId() == null) {
            return null;
        }
        Integer n = this.objPSModelLock;
        synchronized (n) {
            if (this.psmodel != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelId(), (Object)this.psmodel.getPSModelId()) != 0L) {
                this.psmodel = null;
            }
            if (this.psmodel == null) {
                PSModel pSModel = new PSModel();
                pSModel.setPSModelId(this.getPSModelId());
                PSModelService pSModelService = (PSModelService)ServiceGlobal.getService(PSModelService.class, (SessionFactory)this.getSessionFactory());
                pSModelService.autoGet(pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    private PSModelFieldBase getProxyEntity() {
        return this.proxyPSModelFieldBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelFieldBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelFieldBase) {
            this.proxyPSModelFieldBase = (PSModelFieldBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelFieldService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONCEPTCONTENT, 0);
        fieldIndexMap.put(FIELD_CONCEPTFLAG, 1);
        fieldIndexMap.put(FIELD_CONCEPTORDERVALUE, 2);
        fieldIndexMap.put(FIELD_CONCEPTTITLE, 3);
        fieldIndexMap.put(FIELD_CREATEDATE, 4);
        fieldIndexMap.put(FIELD_CREATEMAN, 5);
        fieldIndexMap.put(FIELD_DATATYPEDESC, 6);
        fieldIndexMap.put(FIELD_DEFAULTVALUE, 7);
        fieldIndexMap.put(FIELD_FIELDDESC, 8);
        fieldIndexMap.put(FIELD_FIELDDESC2, 9);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 10);
        fieldIndexMap.put(FIELD_LINKFLAG, 11);
        fieldIndexMap.put(FIELD_LOGICNAME, 12);
        fieldIndexMap.put(FIELD_MARKFLAG, 13);
        fieldIndexMap.put(FIELD_MEMO, 14);
        fieldIndexMap.put(FIELD_ORDERVALUE, 15);
        fieldIndexMap.put(FIELD_PSMODELFIELDID, 16);
        fieldIndexMap.put(FIELD_PSMODELFIELDNAME, 17);
        fieldIndexMap.put(FIELD_PSMODELID, 18);
        fieldIndexMap.put(FIELD_PSMODELNAME, 19);
        fieldIndexMap.put(FIELD_UPDATEDATE, 20);
        fieldIndexMap.put(FIELD_UPDATEMAN, 21);
        fieldIndexMap.put(FIELD_VALIDFLAG, 22);
    }
}

