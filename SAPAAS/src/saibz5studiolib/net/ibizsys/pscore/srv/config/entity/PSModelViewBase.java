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
import net.ibizsys.pscore.srv.config.entity.PSViewType;
import net.ibizsys.pscore.srv.config.service.PSModelService;
import net.ibizsys.pscore.srv.config.service.PSViewTypeService;
import net.ibizsys.pscore.srv.dedesign.entity.PSDEViewBase;
import net.ibizsys.pscore.srv.dedesign.service.PSDEViewBaseService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSModelViewBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSModelViewBase.class);
    public static final String FIELD_BOTTOMCONTENT = "BOTTOMCONTENT";
    public static final String FIELD_CONTENT = "CONTENT";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_HEADERCONTENT = "HEADERCONTENT";
    public static final String FIELD_IMAGEFLAG = "IMAGEFLAG";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSDEVIEWBASEID = "PSDEVIEWBASEID";
    public static final String FIELD_PSDEVIEWBASENAME = "PSDEVIEWBASENAME";
    public static final String FIELD_PSMODELID = "PSMODELID";
    public static final String FIELD_PSMODELNAME = "PSMODELNAME";
    public static final String FIELD_PSMODELVIEWID = "PSMODELVIEWID";
    public static final String FIELD_PSMODELVIEWNAME = "PSMODELVIEWNAME";
    public static final String FIELD_PSVIEWTYPEID = "PSVIEWTYPEID";
    public static final String FIELD_PSVIEWTYPENAME = "PSVIEWTYPENAME";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWDESC = "VIEWDESC";
    public static final String FIELD_VIEWTAG = "VIEWTAG";
    private static final int INDEX_BOTTOMCONTENT = 0;
    private static final int INDEX_CONTENT = 1;
    private static final int INDEX_CREATEDATE = 2;
    private static final int INDEX_CREATEMAN = 3;
    private static final int INDEX_HEADERCONTENT = 4;
    private static final int INDEX_IMAGEFLAG = 5;
    private static final int INDEX_MEMO = 6;
    private static final int INDEX_PSDEVIEWBASEID = 7;
    private static final int INDEX_PSDEVIEWBASENAME = 8;
    private static final int INDEX_PSMODELID = 9;
    private static final int INDEX_PSMODELNAME = 10;
    private static final int INDEX_PSMODELVIEWID = 11;
    private static final int INDEX_PSMODELVIEWNAME = 12;
    private static final int INDEX_PSVIEWTYPEID = 13;
    private static final int INDEX_PSVIEWTYPENAME = 14;
    private static final int INDEX_UPDATEDATE = 15;
    private static final int INDEX_UPDATEMAN = 16;
    private static final int INDEX_VALIDFLAG = 17;
    private static final int INDEX_VIEWDESC = 18;
    private static final int INDEX_VIEWTAG = 19;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSModelViewBase proxyPSModelViewBase = null;
    private boolean bottomcontentDirtyFlag = false;
    private boolean contentDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean headercontentDirtyFlag = false;
    private boolean imageflagDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psdeviewbaseidDirtyFlag = false;
    private boolean psdeviewbasenameDirtyFlag = false;
    private boolean psmodelidDirtyFlag = false;
    private boolean psmodelnameDirtyFlag = false;
    private boolean psmodelviewidDirtyFlag = false;
    private boolean psmodelviewnameDirtyFlag = false;
    private boolean psviewtypeidDirtyFlag = false;
    private boolean psviewtypenameDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewdescDirtyFlag = false;
    private boolean viewtagDirtyFlag = false;
    @Column(name="bottomcontent")
    private String bottomcontent;
    @Column(name="content")
    private String content;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="headercontent")
    private String headercontent;
    @Column(name="imageflag")
    private Integer imageflag;
    @Column(name="memo")
    private String memo;
    @Column(name="psdeviewbaseid")
    private String psdeviewbaseid;
    @Column(name="psdeviewbasename")
    private String psdeviewbasename;
    @Column(name="psmodelid")
    private String psmodelid;
    @Column(name="psmodelname")
    private String psmodelname;
    @Column(name="psmodelviewid")
    private String psmodelviewid;
    @Column(name="psmodelviewname")
    private String psmodelviewname;
    @Column(name="psviewtypeid")
    private String psviewtypeid;
    @Column(name="psviewtypename")
    private String psviewtypename;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewdesc")
    private String viewdesc;
    @Column(name="viewtag")
    private String viewtag;
    private Integer objPSDEViewBaseLock = new Integer(1);
    private PSDEViewBase psdeviewbase = null;
    private Integer objPSModelLock = new Integer(1);
    private PSModel psmodel = null;
    private Integer objPSViewTypeLock = new Integer(1);
    private PSViewType psviewtype = null;

    public void setBottomContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setBottomContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.bottomcontent = string;
        this.bottomcontentDirtyFlag = true;
    }

    public String getBottomContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getBottomContent();
        }
        return this.bottomcontent;
    }

    public boolean isBottomContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isBottomContentDirty();
        }
        return this.bottomcontentDirtyFlag;
    }

    public void resetBottomContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetBottomContent();
            return;
        }
        this.bottomcontentDirtyFlag = false;
        this.bottomcontent = null;
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

    public void setHeaderContent(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setHeaderContent(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.headercontent = string;
        this.headercontentDirtyFlag = true;
    }

    public String getHeaderContent() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getHeaderContent();
        }
        return this.headercontent;
    }

    public boolean isHeaderContentDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isHeaderContentDirty();
        }
        return this.headercontentDirtyFlag;
    }

    public void resetHeaderContent() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetHeaderContent();
            return;
        }
        this.headercontentDirtyFlag = false;
        this.headercontent = null;
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

    public void setPSDEViewBaseId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbaseid = string;
        this.psdeviewbaseidDirtyFlag = true;
    }

    public String getPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseId();
        }
        return this.psdeviewbaseid;
    }

    public boolean isPSDEViewBaseIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseIdDirty();
        }
        return this.psdeviewbaseidDirtyFlag;
    }

    public void resetPSDEViewBaseId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseId();
            return;
        }
        this.psdeviewbaseidDirtyFlag = false;
        this.psdeviewbaseid = null;
    }

    public void setPSDEViewBaseName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSDEViewBaseName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psdeviewbasename = string;
        this.psdeviewbasenameDirtyFlag = true;
    }

    public String getPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBaseName();
        }
        return this.psdeviewbasename;
    }

    public boolean isPSDEViewBaseNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSDEViewBaseNameDirty();
        }
        return this.psdeviewbasenameDirtyFlag;
    }

    public void resetPSDEViewBaseName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSDEViewBaseName();
            return;
        }
        this.psdeviewbasenameDirtyFlag = false;
        this.psdeviewbasename = null;
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

    public void setPSModelViewId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewid = string;
        this.psmodelviewidDirtyFlag = true;
    }

    public String getPSModelViewId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewId();
        }
        return this.psmodelviewid;
    }

    public boolean isPSModelViewIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewIdDirty();
        }
        return this.psmodelviewidDirtyFlag;
    }

    public void resetPSModelViewId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewId();
            return;
        }
        this.psmodelviewidDirtyFlag = false;
        this.psmodelviewid = null;
    }

    public void setPSModelViewName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSModelViewName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psmodelviewname = string;
        this.psmodelviewnameDirtyFlag = true;
    }

    public String getPSModelViewName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSModelViewName();
        }
        return this.psmodelviewname;
    }

    public boolean isPSModelViewNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSModelViewNameDirty();
        }
        return this.psmodelviewnameDirtyFlag;
    }

    public void resetPSModelViewName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSModelViewName();
            return;
        }
        this.psmodelviewnameDirtyFlag = false;
        this.psmodelviewname = null;
    }

    public void setPSViewTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypeid = string;
        this.psviewtypeidDirtyFlag = true;
    }

    public String getPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeId();
        }
        return this.psviewtypeid;
    }

    public boolean isPSViewTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeIdDirty();
        }
        return this.psviewtypeidDirtyFlag;
    }

    public void resetPSViewTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeId();
            return;
        }
        this.psviewtypeidDirtyFlag = false;
        this.psviewtypeid = null;
    }

    public void setPSViewTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSViewTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psviewtypename = string;
        this.psviewtypenameDirtyFlag = true;
    }

    public String getPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewTypeName();
        }
        return this.psviewtypename;
    }

    public boolean isPSViewTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSViewTypeNameDirty();
        }
        return this.psviewtypenameDirtyFlag;
    }

    public void resetPSViewTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSViewTypeName();
            return;
        }
        this.psviewtypenameDirtyFlag = false;
        this.psviewtypename = null;
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

    public void setViewDesc(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewDesc(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewdesc = string;
        this.viewdescDirtyFlag = true;
    }

    public String getViewDesc() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewDesc();
        }
        return this.viewdesc;
    }

    public boolean isViewDescDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewDescDirty();
        }
        return this.viewdescDirtyFlag;
    }

    public void resetViewDesc() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewDesc();
            return;
        }
        this.viewdescDirtyFlag = false;
        this.viewdesc = null;
    }

    public void setViewTag(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewTag(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewtag = string;
        this.viewtagDirtyFlag = true;
    }

    public String getViewTag() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewTag();
        }
        return this.viewtag;
    }

    public boolean isViewTagDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewTagDirty();
        }
        return this.viewtagDirtyFlag;
    }

    public void resetViewTag() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewTag();
            return;
        }
        this.viewtagDirtyFlag = false;
        this.viewtag = null;
    }

    protected void onReset() {
        PSModelViewBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSModelViewBase pSModelViewBase) {
        pSModelViewBase.resetBottomContent();
        pSModelViewBase.resetContent();
        pSModelViewBase.resetCreateDate();
        pSModelViewBase.resetCreateMan();
        pSModelViewBase.resetHeaderContent();
        pSModelViewBase.resetImageFlag();
        pSModelViewBase.resetMemo();
        pSModelViewBase.resetPSDEViewBaseId();
        pSModelViewBase.resetPSDEViewBaseName();
        pSModelViewBase.resetPSModelId();
        pSModelViewBase.resetPSModelName();
        pSModelViewBase.resetPSModelViewId();
        pSModelViewBase.resetPSModelViewName();
        pSModelViewBase.resetPSViewTypeId();
        pSModelViewBase.resetPSViewTypeName();
        pSModelViewBase.resetUpdateDate();
        pSModelViewBase.resetUpdateMan();
        pSModelViewBase.resetValidFlag();
        pSModelViewBase.resetViewDesc();
        pSModelViewBase.resetViewTag();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isBottomContentDirty()) {
            hashMap.put(FIELD_BOTTOMCONTENT, this.getBottomContent());
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
        if (!bl || this.isHeaderContentDirty()) {
            hashMap.put(FIELD_HEADERCONTENT, this.getHeaderContent());
        }
        if (!bl || this.isImageFlagDirty()) {
            hashMap.put(FIELD_IMAGEFLAG, this.getImageFlag());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSDEViewBaseIdDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASEID, this.getPSDEViewBaseId());
        }
        if (!bl || this.isPSDEViewBaseNameDirty()) {
            hashMap.put(FIELD_PSDEVIEWBASENAME, this.getPSDEViewBaseName());
        }
        if (!bl || this.isPSModelIdDirty()) {
            hashMap.put(FIELD_PSMODELID, this.getPSModelId());
        }
        if (!bl || this.isPSModelNameDirty()) {
            hashMap.put(FIELD_PSMODELNAME, this.getPSModelName());
        }
        if (!bl || this.isPSModelViewIdDirty()) {
            hashMap.put(FIELD_PSMODELVIEWID, this.getPSModelViewId());
        }
        if (!bl || this.isPSModelViewNameDirty()) {
            hashMap.put(FIELD_PSMODELVIEWNAME, this.getPSModelViewName());
        }
        if (!bl || this.isPSViewTypeIdDirty()) {
            hashMap.put(FIELD_PSVIEWTYPEID, this.getPSViewTypeId());
        }
        if (!bl || this.isPSViewTypeNameDirty()) {
            hashMap.put(FIELD_PSVIEWTYPENAME, this.getPSViewTypeName());
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
        if (!bl || this.isViewDescDirty()) {
            hashMap.put(FIELD_VIEWDESC, this.getViewDesc());
        }
        if (!bl || this.isViewTagDirty()) {
            hashMap.put(FIELD_VIEWTAG, this.getViewTag());
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
        return PSModelViewBase.get(this, n);
    }

    private static Object get(PSModelViewBase pSModelViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewBase.getBottomContent();
            }
            case 1: {
                return pSModelViewBase.getContent();
            }
            case 2: {
                return pSModelViewBase.getCreateDate();
            }
            case 3: {
                return pSModelViewBase.getCreateMan();
            }
            case 4: {
                return pSModelViewBase.getHeaderContent();
            }
            case 5: {
                return pSModelViewBase.getImageFlag();
            }
            case 6: {
                return pSModelViewBase.getMemo();
            }
            case 7: {
                return pSModelViewBase.getPSDEViewBaseId();
            }
            case 8: {
                return pSModelViewBase.getPSDEViewBaseName();
            }
            case 9: {
                return pSModelViewBase.getPSModelId();
            }
            case 10: {
                return pSModelViewBase.getPSModelName();
            }
            case 11: {
                return pSModelViewBase.getPSModelViewId();
            }
            case 12: {
                return pSModelViewBase.getPSModelViewName();
            }
            case 13: {
                return pSModelViewBase.getPSViewTypeId();
            }
            case 14: {
                return pSModelViewBase.getPSViewTypeName();
            }
            case 15: {
                return pSModelViewBase.getUpdateDate();
            }
            case 16: {
                return pSModelViewBase.getUpdateMan();
            }
            case 17: {
                return pSModelViewBase.getValidFlag();
            }
            case 18: {
                return pSModelViewBase.getViewDesc();
            }
            case 19: {
                return pSModelViewBase.getViewTag();
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
        PSModelViewBase.set(this, n, object);
    }

    private static void set(PSModelViewBase pSModelViewBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSModelViewBase.setBottomContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSModelViewBase.setContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 2: {
                pSModelViewBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 3: {
                pSModelViewBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSModelViewBase.setHeaderContent(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSModelViewBase.setImageFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 6: {
                pSModelViewBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 7: {
                pSModelViewBase.setPSDEViewBaseId(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSModelViewBase.setPSDEViewBaseName(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSModelViewBase.setPSModelId(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSModelViewBase.setPSModelName(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSModelViewBase.setPSModelViewId(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSModelViewBase.setPSModelViewName(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSModelViewBase.setPSViewTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSModelViewBase.setPSViewTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 15: {
                pSModelViewBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 16: {
                pSModelViewBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSModelViewBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 18: {
                pSModelViewBase.setViewDesc(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSModelViewBase.setViewTag(DataObject.getStringValue((Object)object));
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
        return PSModelViewBase.isNull(this, n);
    }

    private static boolean isNull(PSModelViewBase pSModelViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewBase.getBottomContent() == null;
            }
            case 1: {
                return pSModelViewBase.getContent() == null;
            }
            case 2: {
                return pSModelViewBase.getCreateDate() == null;
            }
            case 3: {
                return pSModelViewBase.getCreateMan() == null;
            }
            case 4: {
                return pSModelViewBase.getHeaderContent() == null;
            }
            case 5: {
                return pSModelViewBase.getImageFlag() == null;
            }
            case 6: {
                return pSModelViewBase.getMemo() == null;
            }
            case 7: {
                return pSModelViewBase.getPSDEViewBaseId() == null;
            }
            case 8: {
                return pSModelViewBase.getPSDEViewBaseName() == null;
            }
            case 9: {
                return pSModelViewBase.getPSModelId() == null;
            }
            case 10: {
                return pSModelViewBase.getPSModelName() == null;
            }
            case 11: {
                return pSModelViewBase.getPSModelViewId() == null;
            }
            case 12: {
                return pSModelViewBase.getPSModelViewName() == null;
            }
            case 13: {
                return pSModelViewBase.getPSViewTypeId() == null;
            }
            case 14: {
                return pSModelViewBase.getPSViewTypeName() == null;
            }
            case 15: {
                return pSModelViewBase.getUpdateDate() == null;
            }
            case 16: {
                return pSModelViewBase.getUpdateMan() == null;
            }
            case 17: {
                return pSModelViewBase.getValidFlag() == null;
            }
            case 18: {
                return pSModelViewBase.getViewDesc() == null;
            }
            case 19: {
                return pSModelViewBase.getViewTag() == null;
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
        return PSModelViewBase.contains(this, n);
    }

    private static boolean contains(PSModelViewBase pSModelViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSModelViewBase.isBottomContentDirty();
            }
            case 1: {
                return pSModelViewBase.isContentDirty();
            }
            case 2: {
                return pSModelViewBase.isCreateDateDirty();
            }
            case 3: {
                return pSModelViewBase.isCreateManDirty();
            }
            case 4: {
                return pSModelViewBase.isHeaderContentDirty();
            }
            case 5: {
                return pSModelViewBase.isImageFlagDirty();
            }
            case 6: {
                return pSModelViewBase.isMemoDirty();
            }
            case 7: {
                return pSModelViewBase.isPSDEViewBaseIdDirty();
            }
            case 8: {
                return pSModelViewBase.isPSDEViewBaseNameDirty();
            }
            case 9: {
                return pSModelViewBase.isPSModelIdDirty();
            }
            case 10: {
                return pSModelViewBase.isPSModelNameDirty();
            }
            case 11: {
                return pSModelViewBase.isPSModelViewIdDirty();
            }
            case 12: {
                return pSModelViewBase.isPSModelViewNameDirty();
            }
            case 13: {
                return pSModelViewBase.isPSViewTypeIdDirty();
            }
            case 14: {
                return pSModelViewBase.isPSViewTypeNameDirty();
            }
            case 15: {
                return pSModelViewBase.isUpdateDateDirty();
            }
            case 16: {
                return pSModelViewBase.isUpdateManDirty();
            }
            case 17: {
                return pSModelViewBase.isValidFlagDirty();
            }
            case 18: {
                return pSModelViewBase.isViewDescDirty();
            }
            case 19: {
                return pSModelViewBase.isViewTagDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSModelViewBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSModelViewBase pSModelViewBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSModelViewBase.getBottomContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"bottomcontent", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getBottomContent()), (boolean)false);
        }
        if (bl || pSModelViewBase.getContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"content", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getContent()), (boolean)false);
        }
        if (bl || pSModelViewBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSModelViewBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSModelViewBase.getHeaderContent() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"headercontent", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getHeaderContent()), (boolean)false);
        }
        if (bl || pSModelViewBase.getImageFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"imageflag", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getImageFlag()), (boolean)false);
        }
        if (bl || pSModelViewBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getMemo()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSDEViewBaseId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbaseid", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSDEViewBaseId()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSDEViewBaseName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psdeviewbasename", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSDEViewBaseName()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSModelId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelid", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSModelId()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSModelName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelname", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSModelName()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSModelViewId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewid", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSModelViewId()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSModelViewName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psmodelviewname", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSModelViewName()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSViewTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypeid", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSViewTypeId()), (boolean)false);
        }
        if (bl || pSModelViewBase.getPSViewTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psviewtypename", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getPSViewTypeName()), (boolean)false);
        }
        if (bl || pSModelViewBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSModelViewBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSModelViewBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSModelViewBase.getViewDesc() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewdesc", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getViewDesc()), (boolean)false);
        }
        if (bl || pSModelViewBase.getViewTag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewtag", (Object)PSModelViewBase.getJSONValue((Object)pSModelViewBase.getViewTag()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSModelViewBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSModelViewBase pSModelViewBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSModelViewBase.getBottomContent() != null) {
            object = pSModelViewBase.getBottomContent();
            xmlNode.setAttribute(FIELD_BOTTOMCONTENT, (String)(object == null ? "" : object));
        }
        if (bl || pSModelViewBase.getContent() != null) {
            object = pSModelViewBase.getContent();
            xmlNode.setAttribute(FIELD_CONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getCreateDate() != null) {
            object = pSModelViewBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelViewBase.getCreateMan() != null) {
            object = pSModelViewBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getHeaderContent() != null) {
            object = pSModelViewBase.getHeaderContent();
            xmlNode.setAttribute(FIELD_HEADERCONTENT, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getImageFlag() != null) {
            object = pSModelViewBase.getImageFlag();
            xmlNode.setAttribute(FIELD_IMAGEFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelViewBase.getMemo() != null) {
            object = pSModelViewBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSDEViewBaseId() != null) {
            object = pSModelViewBase.getPSDEViewBaseId();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSDEViewBaseName() != null) {
            object = pSModelViewBase.getPSDEViewBaseName();
            xmlNode.setAttribute(FIELD_PSDEVIEWBASENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSModelId() != null) {
            object = pSModelViewBase.getPSModelId();
            xmlNode.setAttribute(FIELD_PSMODELID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSModelName() != null) {
            object = pSModelViewBase.getPSModelName();
            xmlNode.setAttribute(FIELD_PSMODELNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSModelViewId() != null) {
            object = pSModelViewBase.getPSModelViewId();
            xmlNode.setAttribute(FIELD_PSMODELVIEWID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSModelViewName() != null) {
            object = pSModelViewBase.getPSModelViewName();
            xmlNode.setAttribute(FIELD_PSMODELVIEWNAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSViewTypeId() != null) {
            object = pSModelViewBase.getPSViewTypeId();
            xmlNode.setAttribute(FIELD_PSVIEWTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getPSViewTypeName() != null) {
            object = pSModelViewBase.getPSViewTypeName();
            xmlNode.setAttribute(FIELD_PSVIEWTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getUpdateDate() != null) {
            object = pSModelViewBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSModelViewBase.getUpdateMan() != null) {
            object = pSModelViewBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getValidFlag() != null) {
            object = pSModelViewBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSModelViewBase.getViewDesc() != null) {
            object = pSModelViewBase.getViewDesc();
            xmlNode.setAttribute(FIELD_VIEWDESC, object == null ? "" : (String)object);
        }
        if (bl || pSModelViewBase.getViewTag() != null) {
            object = pSModelViewBase.getViewTag();
            xmlNode.setAttribute(FIELD_VIEWTAG, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSModelViewBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSModelViewBase pSModelViewBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSModelViewBase.isBottomContentDirty() && (bl || pSModelViewBase.getBottomContent() != null)) {
            iDataObject.set(FIELD_BOTTOMCONTENT, (Object)pSModelViewBase.getBottomContent());
        }
        if (pSModelViewBase.isContentDirty() && (bl || pSModelViewBase.getContent() != null)) {
            iDataObject.set(FIELD_CONTENT, (Object)pSModelViewBase.getContent());
        }
        if (pSModelViewBase.isCreateDateDirty() && (bl || pSModelViewBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSModelViewBase.getCreateDate());
        }
        if (pSModelViewBase.isCreateManDirty() && (bl || pSModelViewBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSModelViewBase.getCreateMan());
        }
        if (pSModelViewBase.isHeaderContentDirty() && (bl || pSModelViewBase.getHeaderContent() != null)) {
            iDataObject.set(FIELD_HEADERCONTENT, (Object)pSModelViewBase.getHeaderContent());
        }
        if (pSModelViewBase.isImageFlagDirty() && (bl || pSModelViewBase.getImageFlag() != null)) {
            iDataObject.set(FIELD_IMAGEFLAG, (Object)pSModelViewBase.getImageFlag());
        }
        if (pSModelViewBase.isMemoDirty() && (bl || pSModelViewBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSModelViewBase.getMemo());
        }
        if (pSModelViewBase.isPSDEViewBaseIdDirty() && (bl || pSModelViewBase.getPSDEViewBaseId() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASEID, (Object)pSModelViewBase.getPSDEViewBaseId());
        }
        if (pSModelViewBase.isPSDEViewBaseNameDirty() && (bl || pSModelViewBase.getPSDEViewBaseName() != null)) {
            iDataObject.set(FIELD_PSDEVIEWBASENAME, (Object)pSModelViewBase.getPSDEViewBaseName());
        }
        if (pSModelViewBase.isPSModelIdDirty() && (bl || pSModelViewBase.getPSModelId() != null)) {
            iDataObject.set(FIELD_PSMODELID, (Object)pSModelViewBase.getPSModelId());
        }
        if (pSModelViewBase.isPSModelNameDirty() && (bl || pSModelViewBase.getPSModelName() != null)) {
            iDataObject.set(FIELD_PSMODELNAME, (Object)pSModelViewBase.getPSModelName());
        }
        if (pSModelViewBase.isPSModelViewIdDirty() && (bl || pSModelViewBase.getPSModelViewId() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWID, (Object)pSModelViewBase.getPSModelViewId());
        }
        if (pSModelViewBase.isPSModelViewNameDirty() && (bl || pSModelViewBase.getPSModelViewName() != null)) {
            iDataObject.set(FIELD_PSMODELVIEWNAME, (Object)pSModelViewBase.getPSModelViewName());
        }
        if (pSModelViewBase.isPSViewTypeIdDirty() && (bl || pSModelViewBase.getPSViewTypeId() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPEID, (Object)pSModelViewBase.getPSViewTypeId());
        }
        if (pSModelViewBase.isPSViewTypeNameDirty() && (bl || pSModelViewBase.getPSViewTypeName() != null)) {
            iDataObject.set(FIELD_PSVIEWTYPENAME, (Object)pSModelViewBase.getPSViewTypeName());
        }
        if (pSModelViewBase.isUpdateDateDirty() && (bl || pSModelViewBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSModelViewBase.getUpdateDate());
        }
        if (pSModelViewBase.isUpdateManDirty() && (bl || pSModelViewBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSModelViewBase.getUpdateMan());
        }
        if (pSModelViewBase.isValidFlagDirty() && (bl || pSModelViewBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSModelViewBase.getValidFlag());
        }
        if (pSModelViewBase.isViewDescDirty() && (bl || pSModelViewBase.getViewDesc() != null)) {
            iDataObject.set(FIELD_VIEWDESC, (Object)pSModelViewBase.getViewDesc());
        }
        if (pSModelViewBase.isViewTagDirty() && (bl || pSModelViewBase.getViewTag() != null)) {
            iDataObject.set(FIELD_VIEWTAG, (Object)pSModelViewBase.getViewTag());
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
        return PSModelViewBase.remove(this, n);
    }

    private static boolean remove(PSModelViewBase pSModelViewBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSModelViewBase.resetBottomContent();
                return true;
            }
            case 1: {
                pSModelViewBase.resetContent();
                return true;
            }
            case 2: {
                pSModelViewBase.resetCreateDate();
                return true;
            }
            case 3: {
                pSModelViewBase.resetCreateMan();
                return true;
            }
            case 4: {
                pSModelViewBase.resetHeaderContent();
                return true;
            }
            case 5: {
                pSModelViewBase.resetImageFlag();
                return true;
            }
            case 6: {
                pSModelViewBase.resetMemo();
                return true;
            }
            case 7: {
                pSModelViewBase.resetPSDEViewBaseId();
                return true;
            }
            case 8: {
                pSModelViewBase.resetPSDEViewBaseName();
                return true;
            }
            case 9: {
                pSModelViewBase.resetPSModelId();
                return true;
            }
            case 10: {
                pSModelViewBase.resetPSModelName();
                return true;
            }
            case 11: {
                pSModelViewBase.resetPSModelViewId();
                return true;
            }
            case 12: {
                pSModelViewBase.resetPSModelViewName();
                return true;
            }
            case 13: {
                pSModelViewBase.resetPSViewTypeId();
                return true;
            }
            case 14: {
                pSModelViewBase.resetPSViewTypeName();
                return true;
            }
            case 15: {
                pSModelViewBase.resetUpdateDate();
                return true;
            }
            case 16: {
                pSModelViewBase.resetUpdateMan();
                return true;
            }
            case 17: {
                pSModelViewBase.resetValidFlag();
                return true;
            }
            case 18: {
                pSModelViewBase.resetViewDesc();
                return true;
            }
            case 19: {
                pSModelViewBase.resetViewTag();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSDEViewBase getPSDEViewBase() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSDEViewBase();
        }
        if (this.getPSDEViewBaseId() == null) {
            return null;
        }
        Integer n = this.objPSDEViewBaseLock;
        synchronized (n) {
            if (this.psdeviewbase != null && DataTypeHelper.compare((int)25, (Object)this.getPSDEViewBaseId(), (Object)this.psdeviewbase.getPSDEViewBaseId()) != 0L) {
                this.psdeviewbase = null;
            }
            if (this.psdeviewbase == null) {
                PSDEViewBase pSDEViewBase = new PSDEViewBase();
                pSDEViewBase.setPSDEViewBaseId(this.getPSDEViewBaseId());
                PSDEViewBaseService pSDEViewBaseService = (PSDEViewBaseService)ServiceGlobal.getService(PSDEViewBaseService.class, (SessionFactory)this.getSessionFactory());
                pSDEViewBaseService.autoGet((IEntity)pSDEViewBase);
                this.psdeviewbase = pSDEViewBase;
            }
            return this.psdeviewbase;
        }
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
                pSModelService.autoGet((IEntity)pSModel);
                this.psmodel = pSModel;
            }
            return this.psmodel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSViewType getPSViewType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSViewType();
        }
        if (this.getPSViewTypeId() == null) {
            return null;
        }
        Integer n = this.objPSViewTypeLock;
        synchronized (n) {
            if (this.psviewtype != null && DataTypeHelper.compare((int)25, (Object)this.getPSViewTypeId(), (Object)this.psviewtype.getPSViewTypeId()) != 0L) {
                this.psviewtype = null;
            }
            if (this.psviewtype == null) {
                PSViewType pSViewType = new PSViewType();
                pSViewType.setPSViewTypeId(this.getPSViewTypeId());
                PSViewTypeService pSViewTypeService = (PSViewTypeService)ServiceGlobal.getService(PSViewTypeService.class, (SessionFactory)this.getSessionFactory());
                pSViewTypeService.autoGet((IEntity)pSViewType);
                this.psviewtype = pSViewType;
            }
            return this.psviewtype;
        }
    }

    private PSModelViewBase getProxyEntity() {
        return this.proxyPSModelViewBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSModelViewBase = null;
        if (iDataObject != null && iDataObject instanceof PSModelViewBase) {
            this.proxyPSModelViewBase = (PSModelViewBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSModelViewService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_BOTTOMCONTENT, 0);
        fieldIndexMap.put(FIELD_CONTENT, 1);
        fieldIndexMap.put(FIELD_CREATEDATE, 2);
        fieldIndexMap.put(FIELD_CREATEMAN, 3);
        fieldIndexMap.put(FIELD_HEADERCONTENT, 4);
        fieldIndexMap.put(FIELD_IMAGEFLAG, 5);
        fieldIndexMap.put(FIELD_MEMO, 6);
        fieldIndexMap.put(FIELD_PSDEVIEWBASEID, 7);
        fieldIndexMap.put(FIELD_PSDEVIEWBASENAME, 8);
        fieldIndexMap.put(FIELD_PSMODELID, 9);
        fieldIndexMap.put(FIELD_PSMODELNAME, 10);
        fieldIndexMap.put(FIELD_PSMODELVIEWID, 11);
        fieldIndexMap.put(FIELD_PSMODELVIEWNAME, 12);
        fieldIndexMap.put(FIELD_PSVIEWTYPEID, 13);
        fieldIndexMap.put(FIELD_PSVIEWTYPENAME, 14);
        fieldIndexMap.put(FIELD_UPDATEDATE, 15);
        fieldIndexMap.put(FIELD_UPDATEMAN, 16);
        fieldIndexMap.put(FIELD_VALIDFLAG, 17);
        fieldIndexMap.put(FIELD_VIEWDESC, 18);
        fieldIndexMap.put(FIELD_VIEWTAG, 19);
    }
}

