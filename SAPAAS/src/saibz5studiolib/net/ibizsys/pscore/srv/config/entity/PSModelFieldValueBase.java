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
import net.ibizsys.pscore.srv.config.entity.PSModelField;
import net.ibizsys.pscore.srv.config.entity.PSModelValueGroup;
import net.ibizsys.pscore.srv.config.service.PSModelFieldService;
import net.ibizsys.pscore.srv.config.service.PSModelValueGroupService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelFieldValueBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelFieldValueBase.class);
    public static final String FIELD_CONCEPTCONTENT = "CONCEPTCONTENT";
    public static final String FIELD_CONCEPTFLAG = "CONCEPTFLAG";
    public static final String FIELD_CONCEPTTITLE = "CONCEPTTITLE";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_LINKFLAG = "LINKFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_ORDERVALUE = "ORDERVALUE";
    public static final String FIELD_PSMODELFIELDID = "PSMODELFIELDID";
    public static final String FIELD_PSMODELFIELDNAME = "PSMODELFIELDNAME";
    public static final String FIELD_PSMODELFIELDVALUEID = "PSMODELFIELDVALUEID";
    public static final String FIELD_PSMODELFIELDVALUENAME = "PSMODELFIELDVALUENAME";
    public static final String FIELD_PSMODELVALUEGROUPID = "PSMODELVALUEGROUPID";
    public static final String FIELD_PSMODELVALUEGROUPNAME = "PSMODELVALUEGROUPNAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VALUE = "VALUE";
    public static final String FIELD_VALUEDESC = "VALUEDESC";
    public static final String FIELD_VALUEFLAG = "VALUEFLAG";
    private static final int INDEX_CONCEPTCONTENT = 0;
    private static final int INDEX_CONCEPTFLAG = 1;
    private static final int INDEX_CONCEPTTITLE = 2;
    private static final int INDEX_CREATEDATE = 3;
    private static final int INDEX_CREATEMAN = 4;
    private static final int INDEX_IMAGEFLAG = 5;
    private static final int INDEX_LINKFLAG = 6;
    private static final int INDEX_MEMO = 7;
    private static final int INDEX_ORDERVALUE = 8;
    private static final int INDEX_PSMODELFIELDID = 9;
    private static final int INDEX_PSMODELFIELDNAME = 10;
    private static final int INDEX_PSMODELFIELDVALUEID = 11;
    private static final int INDEX_PSMODELFIELDVALUENAME = 12;
    private static final int INDEX_PSMODELVALUEGROUPID = 13;
    private static final int INDEX_PSMODELVALUEGROUPNAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final int INDEX_VALUE = 18;
    private static final int INDEX_VALUEDESC = 19;
    private static final int INDEX_VALUEFLAG = 20;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelFieldValueBase proxyPSModelFieldValueBase = null;
    private boolean conceptcontentDirtyFlag = false;
    private boolean conceptflagDirtyFlag = false;
    private boolean concepttitleDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean linkflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean ordervalueDirtyFlag = false;
    private boolean psmodelfieldidDirtyFlag = false;
    private boolean psmodelfieldnameDirtyFlag = false;
    private boolean psmodelfieldvalueidDirtyFlag = false;
    private boolean psmodelfieldvaluenameDirtyFlag = false;
    private boolean psmodelvaluegroupidDirtyFlag = false;
    private boolean psmodelvaluegroupnameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean valueDirtyFlag = false;
    private boolean valuedescDirtyFlag = false;
    private boolean valueflagDirtyFlag = false;
    @Column(name="conceptcontent")
    private String conceptcontent;
    @Column(name="conceptflag")
    private Integer conceptflag;
    @Column(name="concepttitle")
    private String concepttitle;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="linkflag")
    private Integer linkflag;
    @Column(name="memo")
    private String memo;
    @Column(name="ordervalue")
    private Integer ordervalue;
    @Column(name="psmodelfieldid")
    private String psmodelfieldid;
    @Column(name="psmodelfieldname")
    private String psmodelfieldname;
    @Column(name="psmodelfieldvalueid")
    private String psmodelfieldvalueid;
    @Column(name="psmodelfieldvaluename")
    private String psmodelfieldvaluename;
    @Column(name="psmodelvaluegroupid")
    private String psmodelvaluegroupid;
    @Column(name="psmodelvaluegroupname")
    private String psmodelvaluegroupname;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="value")
    private String value;
    @Column(name="valuedesc")
    private String valuedesc;
    @Column(name="valueflag")
    private Integer valueflag;
    private Integer objPSModelFieldLock = new Integer(1);
    private PSModelField psmodelfield = null;
    private Integer objPSModelValueGroupLock = new Integer(1);
    private PSModelValueGroup psmodelvaluegroup = null;

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

    public void setPSModelFieldValueId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldValueId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldvalueid = string;
        this.psmodelfieldvalueidDirtyFlag = true;
    }

    public String getPSModelFieldValueId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldValueId();
        }
        return this.psmodelfieldvalueid;
    }

    public boolean isPSModelFieldValueIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldValueIdDirty();
        }
        return this.psmodelfieldvalueidDirtyFlag;
    }

    public void resetPSModelFieldValueId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldValueId();
            return;
        }
        this.psmodelfieldvalueidDirtyFlag = false;
        this.psmodelfieldvalueid = null;
    }

    public void setPSModelFieldValueName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelFieldValueName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelfieldvaluename = string;
        this.psmodelfieldvaluenameDirtyFlag = true;
    }

    public String getPSModelFieldValueName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelFieldValueName();
        }
        return this.psmodelfieldvaluename;
    }

    public boolean isPSModelFieldValueNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelFieldValueNameDirty();
        }
        return this.psmodelfieldvaluenameDirtyFlag;
    }

    public void resetPSModelFieldValueName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelFieldValueName();
            return;
        }
        this.psmodelfieldvaluenameDirtyFlag = false;
        this.psmodelfieldvaluename = null;
    }

    public void setPSModelValueGroupId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelValueGroupId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelvaluegroupid = string;
        this.psmodelvaluegroupidDirtyFlag = true;
    }

    public String getPSModelValueGroupId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelValueGroupId();
        }
        return this.psmodelvaluegroupid;
    }

    public boolean isPSModelValueGroupIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelValueGroupIdDirty();
        }
        return this.psmodelvaluegroupidDirtyFlag;
    }

    public void resetPSModelValueGroupId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelValueGroupId();
            return;
        }
        this.psmodelvaluegroupidDirtyFlag = false;
        this.psmodelvaluegroupid = null;
    }

    public void setPSModelValueGroupName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelValueGroupName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelvaluegroupname = string;
        this.psmodelvaluegroupnameDirtyFlag = true;
    }

    public String getPSModelValueGroupName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelValueGroupName();
        }
        return this.psmodelvaluegroupname;
    }

    public boolean isPSModelValueGroupNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelValueGroupNameDirty();
        }
        return this.psmodelvaluegroupnameDirtyFlag;
    }

    public void resetPSModelValueGroupName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelValueGroupName();
            return;
        }
        this.psmodelvaluegroupnameDirtyFlag = false;
        this.psmodelvaluegroupname = null;
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

    public void setValue(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValue(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.value = string;
        this.valueDirtyFlag = true;
    }

    public String getValue() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValue();
        }
        return this.value;
    }

    public boolean isValueDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDirty();
        }
        return this.valueDirtyFlag;
    }

    public void resetValue() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValue();
            return;
        }
        this.valueDirtyFlag = false;
        this.value = null;
    }

    public void setValueDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.valuedesc = string;
        this.valuedescDirtyFlag = true;
    }

    public String getValueDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueDesc();
        }
        return this.valuedesc;
    }

    public boolean isValueDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueDescDirty();
        }
        return this.valuedescDirtyFlag;
    }

    public void resetValueDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueDesc();
            return;
        }
        this.valuedescDirtyFlag = false;
        this.valuedesc = null;
    }

    public void setValueFlag(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setValueFlag(n);
            return;
        }
        this.valueflag = n;
        this.valueflagDirtyFlag = true;
    }

    public Integer getValueFlag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getValueFlag();
        }
        return this.valueflag;
    }

    public boolean isValueFlagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isValueFlagDirty();
        }
        return this.valueflagDirtyFlag;
    }

    public void resetValueFlag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetValueFlag();
            return;
        }
        this.valueflagDirtyFlag = false;
        this.valueflag = null;
    }

    protected void onReset() {
        PSModelFieldValueBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelFieldValueBase pSModelFieldValueBase) {
        pSModelFieldValueBase.resetConceptContent();
        pSModelFieldValueBase.resetConceptFlag();
        pSModelFieldValueBase.resetConceptTitle();
        pSModelFieldValueBase.resetCreateDate();
        pSModelFieldValueBase.resetCreateMan();
        pSModelFieldValueBase.resetImageFlag();
        pSModelFieldValueBase.resetLinkFlag();
        pSModelFieldValueBase.resetMemo();
        pSModelFieldValueBase.resetOrderValue();
        pSModelFieldValueBase.resetPSModelFieldId();
        pSModelFieldValueBase.resetPSModelFieldName();
        pSModelFieldValueBase.resetPSModelFieldValueId();
        pSModelFieldValueBase.resetPSModelFieldValueName();
        pSModelFieldValueBase.resetPSModelValueGroupId();
        pSModelFieldValueBase.resetPSModelValueGroupName();
        pSModelFieldValueBase.resetUpdateDate();
        pSModelFieldValueBase.resetUpdateMan();
        pSModelFieldValueBase.resetValidFlag();
        pSModelFieldValueBase.resetValue();
        pSModelFieldValueBase.resetValueDesc();
        pSModelFieldValueBase.resetValueFlag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isConceptContentDirty()) {
            hashMap.put(FIELD_CONCEPTCONTENT, this.getConceptContent());
        }
        if (!bl || this.isConceptFlagDirty()) {
            hashMap.put(FIELD_CONCEPTFLAG, this.getConceptFlag());
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
        if (!bl || this.isImageFlagDirty()) {
            hashMap.put(FIELD_IMAGEFLAG, this.getImageFlag());
        }
        if (!bl || this.isLinkFlagDirty()) {
            hashMap.put(FIELD_LINKFLAG, this.getLinkFlag());
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
        if (!bl || this.isPSModelFieldValueIdDirty()) {
            hashMap.put(FIELD_PSMODELFIELDVALUEID, this.getPSModelFieldValueId());
        }
        if (!bl || this.isPSModelFieldValueNameDirty()) {
            hashMap.put(FIELD_PSMODELFIELDVALUENAME, this.getPSModelFieldValueName());
        }
        if (!bl || this.isPSModelValueGroupIdDirty()) {
            hashMap.put(FIELD_PSMODELVALUEGROUPID, this.getPSModelValueGroupId());
        }
        if (!bl || this.isPSModelValueGroupNameDirty()) {
            hashMap.put(FIELD_PSMODELVALUEGROUPNAME, this.getPSModelValueGroupName());
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
        if (!bl || this.isValueDirty()) {
            hashMap.put(FIELD_VALUE, this.getValue());
        }
        if (!bl || this.isValueDescDirty()) {
            hashMap.put(FIELD_VALUEDESC, this.getValueDesc());
        }
        if (!bl || this.isValueFlagDirty()) {
            hashMap.put(FIELD_VALUEFLAG, this.getValueFlag());
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
        return PSModelFieldValueBase.get(this, n);
    }

    private static Object get(PSModelFieldValueBase pSModelFieldValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldValueBase.getConceptContent();
            }
            case 1: {
                return pSModelFieldValueBase.getConceptFlag();
            }
            case 2: {
                return pSModelFieldValueBase.getConceptTitle();
            }
            case 3: {
                return pSModelFieldValueBase.getCreateDate();
            }
            case 4: {
                return pSModelFieldValueBase.getCreateMan();
            }
            case 5: {
                return pSModelFieldValueBase.getImageFlag();
            }
            case 6: {
                return pSModelFieldValueBase.getLinkFlag();
            }
            case 7: {
                return pSModelFieldValueBase.getMemo();
            }
            case 8: {
                return pSModelFieldValueBase.getOrderValue();
            }
            case 9: {
                return pSModelFieldValueBase.getPSModelFieldId();
            }
            case 10: {
                return pSModelFieldValueBase.getPSModelFieldName();
            }
            case 11: {
                return pSModelFieldValueBase.getPSModelFieldValueId();
            }
            case 12: {
                return pSModelFieldValueBase.getPSModelFieldValueName();
            }
            case 13: {
                return pSModelFieldValueBase.getPSModelValueGroupId();
            }
            case 14: {
                return pSModelFieldValueBase.getPSModelValueGroupName();
            }
            case 15: {
                return pSModelFieldValueBase.getUpdateDate();
            }
            case 16: {
                return pSModelFieldValueBase.getUpdateMan();
            }
            case 17: {
                return pSModelFieldValueBase.getValidFlag();
            }
            case 18: {
                return pSModelFieldValueBase.getValue();
            }
            case 19: {
                return pSModelFieldValueBase.getValueDesc();
            }
            case 20: {
                return pSModelFieldValueBase.getValueFlag();
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
        PSModelFieldValueBase.set(this, n, object);
    }

    private static void set(PSModelFieldValueBase pSModelFieldValueBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelFieldValueBase.setConceptContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelFieldValueBase.setConceptFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 2: {
                pSModelFieldValueBase.setConceptTitle(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSModelFieldValueBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 4: {
                pSModelFieldValueBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelFieldValueBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelFieldValueBase.setLinkFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSModelFieldValueBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelFieldValueBase.setOrderValue(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 9: {
                pSModelFieldValueBase.setPSModelFieldId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelFieldValueBase.setPSModelFieldName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelFieldValueBase.setPSModelFieldValueId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelFieldValueBase.setPSModelFieldValueName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelFieldValueBase.setPSModelValueGroupId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelFieldValueBase.setPSModelValueGroupName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelFieldValueBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSModelFieldValueBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelFieldValueBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSModelFieldValueBase.setValue(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelFieldValueBase.setValueDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 20: {
                pSModelFieldValueBase.setValueFlag(DataObject.getIntegerValue((Object)object));
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
        return PSModelFieldValueBase.isNull(this, n);
    }

    private static boolean isNull(PSModelFieldValueBase pSModelFieldValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldValueBase.getConceptContent() == null;
            }
            case 1: {
                return pSModelFieldValueBase.getConceptFlag() == null;
            }
            case 2: {
                return pSModelFieldValueBase.getConceptTitle() == null;
            }
            case 3: {
                return pSModelFieldValueBase.getCreateDate() == null;
            }
            case 4: {
                return pSModelFieldValueBase.getCreateMan() == null;
            }
            case 5: {
                return pSModelFieldValueBase.getImageFlag() == null;
            }
            case 6: {
                return pSModelFieldValueBase.getLinkFlag() == null;
            }
            case 7: {
                return pSModelFieldValueBase.getMemo() == null;
            }
            case 8: {
                return pSModelFieldValueBase.getOrderValue() == null;
            }
            case 9: {
                return pSModelFieldValueBase.getPSModelFieldId() == null;
            }
            case 10: {
                return pSModelFieldValueBase.getPSModelFieldName() == null;
            }
            case 11: {
                return pSModelFieldValueBase.getPSModelFieldValueId() == null;
            }
            case 12: {
                return pSModelFieldValueBase.getPSModelFieldValueName() == null;
            }
            case 13: {
                return pSModelFieldValueBase.getPSModelValueGroupId() == null;
            }
            case 14: {
                return pSModelFieldValueBase.getPSModelValueGroupName() == null;
            }
            case 15: {
                return pSModelFieldValueBase.getUpdateDate() == null;
            }
            case 16: {
                return pSModelFieldValueBase.getUpdateMan() == null;
            }
            case 17: {
                return pSModelFieldValueBase.getValidFlag() == null;
            }
            case 18: {
                return pSModelFieldValueBase.getValue() == null;
            }
            case 19: {
                return pSModelFieldValueBase.getValueDesc() == null;
            }
            case 20: {
                return pSModelFieldValueBase.getValueFlag() == null;
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
        return PSModelFieldValueBase.contains(this, n);
    }

    private static boolean contains(PSModelFieldValueBase pSModelFieldValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelFieldValueBase.isConceptContentDirty();
            }
            case 1: {
                return pSModelFieldValueBase.isConceptFlagDirty();
            }
            case 2: {
                return pSModelFieldValueBase.isConceptTitleDirty();
            }
            case 3: {
                return pSModelFieldValueBase.isCreateDateDirty();
            }
            case 4: {
                return pSModelFieldValueBase.isCreateManDirty();
            }
            case 5: {
                return pSModelFieldValueBase.isImageFlagDirty();
            }
            case 6: {
                return pSModelFieldValueBase.isLinkFlagDirty();
            }
            case 7: {
                return pSModelFieldValueBase.isMemoDirty();
            }
            case 8: {
                return pSModelFieldValueBase.isOrderValueDirty();
            }
            case 9: {
                return pSModelFieldValueBase.isPSModelFieldIdDirty();
            }
            case 10: {
                return pSModelFieldValueBase.isPSModelFieldNameDirty();
            }
            case 11: {
                return pSModelFieldValueBase.isPSModelFieldValueIdDirty();
            }
            case 12: {
                return pSModelFieldValueBase.isPSModelFieldValueNameDirty();
            }
            case 13: {
                return pSModelFieldValueBase.isPSModelValueGroupIdDirty();
            }
            case 14: {
                return pSModelFieldValueBase.isPSModelValueGroupNameDirty();
            }
            case 15: {
                return pSModelFieldValueBase.isUpdateDateDirty();
            }
            case 16: {
                return pSModelFieldValueBase.isUpdateManDirty();
            }
            case 17: {
                return pSModelFieldValueBase.isValidFlagDirty();
            }
            case 18: {
                return pSModelFieldValueBase.isValueDirty();
            }
            case 19: {
                return pSModelFieldValueBase.isValueDescDirty();
            }
            case 20: {
                return pSModelFieldValueBase.isValueFlagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelFieldValueBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelFieldValueBase pSModelFieldValueBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelFieldValueBase.getConceptContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"conceptcontent", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getConceptContent()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getConceptFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"conceptflag", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getConceptFlag()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getConceptTitle() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"concepttitle", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getConceptTitle()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getLinkFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"linkflag", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getLinkFlag()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getOrderValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ordervalue", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getOrderValue()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldid", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelFieldId()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldname", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelFieldName()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldValueId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldvalueid", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelFieldValueId()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldValueName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelfieldvaluename", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelFieldValueName()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelValueGroupId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelvaluegroupid", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelValueGroupId()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getPSModelValueGroupName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelvaluegroupname", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getPSModelValueGroupName()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getValue() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"value", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getValue()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getValueDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valuedesc", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getValueDesc()), (boolean)false);
        }
        if (bl || pSModelFieldValueBase.getValueFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"valueflag", (Object)PSModelFieldValueBase.getJSONValue((Object)pSModelFieldValueBase.getValueFlag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelFieldValueBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelFieldValueBase pSModelFieldValueBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelFieldValueBase.getConceptContent() != null) {
            object = pSModelFieldValueBase.getConceptContent();
            xmlNode.setAttribute(FIELD_CONCEPTCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getConceptFlag() != null) {
            object = pSModelFieldValueBase.getConceptFlag();
            xmlNode.setAttribute(FIELD_CONCEPTFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getConceptTitle() != null) {
            object = pSModelFieldValueBase.getConceptTitle();
            xmlNode.setAttribute(FIELD_CONCEPTTITLE, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getCreateDate() != null) {
            object = pSModelFieldValueBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getCreateMan() != null) {
            object = pSModelFieldValueBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getImageFlag() != null) {
            object = pSModelFieldValueBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getLinkFlag() != null) {
            object = pSModelFieldValueBase.getLinkFlag();
            xmlNode.setAttribute(FIELD_LINKFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getMemo() != null) {
            object = pSModelFieldValueBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getOrderValue() != null) {
            object = pSModelFieldValueBase.getOrderValue();
            xmlNode.setAttribute(FIELD_ORDERVALUE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldId() != null) {
            object = pSModelFieldValueBase.getPSModelFieldId();
            xmlNode.setAttribute(FIELD_PSMODELFIELDID, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldName() != null) {
            object = pSModelFieldValueBase.getPSModelFieldName();
            xmlNode.setAttribute(FIELD_PSMODELFIELDNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldValueId() != null) {
            object = pSModelFieldValueBase.getPSModelFieldValueId();
            xmlNode.setAttribute(FIELD_PSMODELFIELDVALUEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getPSModelFieldValueName() != null) {
            object = pSModelFieldValueBase.getPSModelFieldValueName();
            xmlNode.setAttribute(FIELD_PSMODELFIELDVALUENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getPSModelValueGroupId() != null) {
            object = pSModelFieldValueBase.getPSModelValueGroupId();
            xmlNode.setAttribute(FIELD_PSMODELVALUEGROUPID, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getPSModelValueGroupName() != null) {
            object = pSModelFieldValueBase.getPSModelValueGroupName();
            xmlNode.setAttribute(FIELD_PSMODELVALUEGROUPNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getUpdateDate() != null) {
            object = pSModelFieldValueBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getUpdateMan() != null) {
            object = pSModelFieldValueBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getValidFlag() != null) {
            object = pSModelFieldValueBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelFieldValueBase.getValue() != null) {
            object = pSModelFieldValueBase.getValue();
            xmlNode.setAttribute(FIELD_VALUE, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getValueDesc() != null) {
            object = pSModelFieldValueBase.getValueDesc();
            xmlNode.setAttribute(FIELD_VALUEDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelFieldValueBase.getValueFlag() != null) {
            object = pSModelFieldValueBase.getValueFlag();
            xmlNode.setAttribute(FIELD_VALUEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelFieldValueBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelFieldValueBase pSModelFieldValueBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelFieldValueBase.isConceptContentDirty() && (bl || pSModelFieldValueBase.getConceptContent() != null)) {
            iDataObject.set(FIELD_CONCEPTCONTENT, (Object)pSModelFieldValueBase.getConceptContent());
        }
        if (pSModelFieldValueBase.isConceptFlagDirty() && (bl || pSModelFieldValueBase.getConceptFlag() != null)) {
            iDataObject.set(FIELD_CONCEPTFLAG, (Object)pSModelFieldValueBase.getConceptFlag());
        }
        if (pSModelFieldValueBase.isConceptTitleDirty() && (bl || pSModelFieldValueBase.getConceptTitle() != null)) {
            iDataObject.set(FIELD_CONCEPTTITLE, (Object)pSModelFieldValueBase.getConceptTitle());
        }
        if (pSModelFieldValueBase.isCreateDateDirty() && (bl || pSModelFieldValueBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelFieldValueBase.getCreateDate());
        }
        if (pSModelFieldValueBase.isCreateManDirty() && (bl || pSModelFieldValueBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelFieldValueBase.getCreateMan());
        }
        if (pSModelFieldValueBase.isImageFlagDirty() && (bl || pSModelFieldValueBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelFieldValueBase.getImageFlag());
        }
        if (pSModelFieldValueBase.isLinkFlagDirty() && (bl || pSModelFieldValueBase.getLinkFlag() != null)) {
            iDataObject.set(FIELD_LINKFLAG, (Object)pSModelFieldValueBase.getLinkFlag());
        }
        if (pSModelFieldValueBase.isMemoDirty() && (bl || pSModelFieldValueBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelFieldValueBase.getMemo());
        }
        if (pSModelFieldValueBase.isOrderValueDirty() && (bl || pSModelFieldValueBase.getOrderValue() != null)) {
            iDataObject.set(FIELD_ORDERVALUE, (Object)pSModelFieldValueBase.getOrderValue());
        }
        if (pSModelFieldValueBase.isPSModelFieldIdDirty() && (bl || pSModelFieldValueBase.getPSModelFieldId() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDID, (Object)pSModelFieldValueBase.getPSModelFieldId());
        }
        if (pSModelFieldValueBase.isPSModelFieldNameDirty() && (bl || pSModelFieldValueBase.getPSModelFieldName() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDNAME, (Object)pSModelFieldValueBase.getPSModelFieldName());
        }
        if (pSModelFieldValueBase.isPSModelFieldValueIdDirty() && (bl || pSModelFieldValueBase.getPSModelFieldValueId() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDVALUEID, (Object)pSModelFieldValueBase.getPSModelFieldValueId());
        }
        if (pSModelFieldValueBase.isPSModelFieldValueNameDirty() && (bl || pSModelFieldValueBase.getPSModelFieldValueName() != null)) {
            iDataObject.set(FIELD_PSMODELFIELDVALUENAME, (Object)pSModelFieldValueBase.getPSModelFieldValueName());
        }
        if (pSModelFieldValueBase.isPSModelValueGroupIdDirty() && (bl || pSModelFieldValueBase.getPSModelValueGroupId() != null)) {
            iDataObject.set(FIELD_PSMODELVALUEGROUPID, (Object)pSModelFieldValueBase.getPSModelValueGroupId());
        }
        if (pSModelFieldValueBase.isPSModelValueGroupNameDirty() && (bl || pSModelFieldValueBase.getPSModelValueGroupName() != null)) {
            iDataObject.set(FIELD_PSMODELVALUEGROUPNAME, (Object)pSModelFieldValueBase.getPSModelValueGroupName());
        }
        if (pSModelFieldValueBase.isUpdateDateDirty() && (bl || pSModelFieldValueBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelFieldValueBase.getUpdateDate());
        }
        if (pSModelFieldValueBase.isUpdateManDirty() && (bl || pSModelFieldValueBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelFieldValueBase.getUpdateMan());
        }
        if (pSModelFieldValueBase.isValidFlagDirty() && (bl || pSModelFieldValueBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelFieldValueBase.getValidFlag());
        }
        if (pSModelFieldValueBase.isValueDirty() && (bl || pSModelFieldValueBase.getValue() != null)) {
            iDataObject.set(FIELD_VALUE, (Object)pSModelFieldValueBase.getValue());
        }
        if (pSModelFieldValueBase.isValueDescDirty() && (bl || pSModelFieldValueBase.getValueDesc() != null)) {
            iDataObject.set(FIELD_VALUEDESC, (Object)pSModelFieldValueBase.getValueDesc());
        }
        if (pSModelFieldValueBase.isValueFlagDirty() && (bl || pSModelFieldValueBase.getValueFlag() != null)) {
            iDataObject.set(FIELD_VALUEFLAG, (Object)pSModelFieldValueBase.getValueFlag());
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
        return PSModelFieldValueBase.remove(this, n);
    }

    private static boolean remove(PSModelFieldValueBase pSModelFieldValueBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelFieldValueBase.resetConceptContent();
                return true;
            }
            case 1: {
                pSModelFieldValueBase.resetConceptFlag();
                return true;
            }
            case 2: {
                pSModelFieldValueBase.resetConceptTitle();
                return true;
            }
            case 3: {
                pSModelFieldValueBase.resetCreateDate();
                return true;
            }
            case 4: {
                pSModelFieldValueBase.resetCreateMan();
                return true;
            }
            case 5: {
                pSModelFieldValueBase.resetImageFlag();
                return true;
            }
            case 6: {
                pSModelFieldValueBase.resetLinkFlag();
                return true;
            }
            case 7: {
                pSModelFieldValueBase.resetMemo();
                return true;
            }
            case 8: {
                pSModelFieldValueBase.resetOrderValue();
                return true;
            }
            case 9: {
                pSModelFieldValueBase.resetPSModelFieldId();
                return true;
            }
            case 10: {
                pSModelFieldValueBase.resetPSModelFieldName();
                return true;
            }
            case 11: {
                pSModelFieldValueBase.resetPSModelFieldValueId();
                return true;
            }
            case 12: {
                pSModelFieldValueBase.resetPSModelFieldValueName();
                return true;
            }
            case 13: {
                pSModelFieldValueBase.resetPSModelValueGroupId();
                return true;
            }
            case 14: {
                pSModelFieldValueBase.resetPSModelValueGroupName();
                return true;
            }
            case 15: {
                pSModelFieldValueBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSModelFieldValueBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSModelFieldValueBase.resetValidFlag();
                return true;
            }
            case 18: {
                pSModelFieldValueBase.resetValue();
                return true;
            }
            case 19: {
                pSModelFieldValueBase.resetValueDesc();
                return true;
            }
            case 20: {
                pSModelFieldValueBase.resetValueFlag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelField getPSModelField() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelField();
        }
        if (this.getPSModelFieldId() == null) {
            return null;
        }
        Integer n = this.objPSModelFieldLock;
        synchronized (n) {
            if (this.psmodelfield != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelFieldId(), (Object)this.psmodelfield.getPSModelFieldId()) != 0L) {
                this.psmodelfield = null;
            }
            if (this.psmodelfield == null) {
                PSModelField pSModelField = new PSModelField();
                pSModelField.setPSModelFieldId(this.getPSModelFieldId());
                PSModelFieldService pSModelFieldService = (PSModelFieldService)ServiceGlobal.getService(PSModelFieldService.class, (SessionFactory)this.getSessionFactory());
                pSModelFieldService.autoGet(pSModelField);
                this.psmodelfield = pSModelField;
            }
            return this.psmodelfield;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSModelValueGroup getPSModelValueGroup() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelValueGroup();
        }
        if (this.getPSModelValueGroupId() == null) {
            return null;
        }
        Integer n = this.objPSModelValueGroupLock;
        synchronized (n) {
            if (this.psmodelvaluegroup != null && DataTypeHelper.compare((int)25, (Object)this.getPSModelValueGroupId(), (Object)this.psmodelvaluegroup.getPSModelValueGroupId()) != 0L) {
                this.psmodelvaluegroup = null;
            }
            if (this.psmodelvaluegroup == null) {
                PSModelValueGroup pSModelValueGroup = new PSModelValueGroup();
                pSModelValueGroup.setPSModelValueGroupId(this.getPSModelValueGroupId());
                PSModelValueGroupService pSModelValueGroupService = (PSModelValueGroupService)ServiceGlobal.getService(PSModelValueGroupService.class, (SessionFactory)this.getSessionFactory());
                pSModelValueGroupService.autoGet(pSModelValueGroup);
                this.psmodelvaluegroup = pSModelValueGroup;
            }
            return this.psmodelvaluegroup;
        }
    }

    private PSModelFieldValueBase getProxyEntity() {
        return this.proxyPSModelFieldValueBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelFieldValueBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelFieldValueBase) {
            this.proxyPSModelFieldValueBase = (PSModelFieldValueBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelFieldValueService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_CONCEPTCONTENT, 0);
        fieldIndexMap.put(FIELD_CONCEPTFLAG, 1);
        fieldIndexMap.put(FIELD_CONCEPTTITLE, 2);
        fieldIndexMap.put(FIELD_CREATEDATE, 3);
        fieldIndexMap.put(FIELD_CREATEMAN, 4);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 5);
        fieldIndexMap.put(FIELD_LINKFLAG, 6);
        fieldIndexMap.put(FIELD_MEMO, 7);
        fieldIndexMap.put(FIELD_ORDERVALUE, 8);
        fieldIndexMap.put(FIELD_PSMODELFIELDID, 9);
        fieldIndexMap.put(FIELD_PSMODELFIELDNAME, 10);
        fieldIndexMap.put(FIELD_PSMODELFIELDVALUEID, 11);
        fieldIndexMap.put(FIELD_PSMODELFIELDVALUENAME, 12);
        fieldIndexMap.put(FIELD_PSMODELVALUEGROUPID, 13);
        fieldIndexMap.put(FIELD_PSMODELVALUEGROUPNAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
        fieldIndexMap.put(FIELD_VALUE, 18);
        fieldIndexMap.put(FIELD_VALUEDESC, 19);
        fieldIndexMap.put(FIELD_VALUEFLAG, 20);
    }
}

