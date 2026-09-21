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
import net.ibizsys.pscore.srv.config.entity.PSAppType;
import net.ibizsys.pscore.srv.config.entity.PSPFPreviewNode;
import net.ibizsys.pscore.srv.config.entity.PSPFPubCode;
import net.ibizsys.pscore.srv.config.entity.PSPFQuickTempl;
import net.ibizsys.pscore.srv.config.entity.PSPFResource;
import net.ibizsys.pscore.srv.config.entity.PSPFUATempl;
import net.ibizsys.pscore.srv.config.entity.PSSFPF;
import net.ibizsys.pscore.srv.config.service.PSAppTypeService;
import net.ibizsys.pscore.srv.config.service.PSPFPreviewNodeService;
import net.ibizsys.pscore.srv.config.service.PSPFPubCodeService;
import net.ibizsys.pscore.srv.config.service.PSPFQuickTemplService;
import net.ibizsys.pscore.srv.config.service.PSPFResourceService;
import net.ibizsys.pscore.srv.config.service.PSPFUATemplService;
import net.ibizsys.pscore.srv.config.service.PSSFPFService;
import net.sf.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;

public abstract class PSPFBase
extends EntityBase
implements Serializable {
    private static final long serialVersionUID = -1L;
    private static final Log log = LogFactory.getLog(PSPFBase.class);
    public static final String FIELD_APPPUBOBJ = "APPPUBOBJ";
    public static final String FIELD_CREATEDATE = "CREATEDATE";
    public static final String FIELD_CREATEMAN = "CREATEMAN";
    public static final String FIELD_CTRLPARTPUBOBJ = "CTRLPARTPUBOBJ";
    public static final String FIELD_CTRLPUBOBJ = "CTRLPUBOBJ";
    public static final String FIELD_EDITORPUBOBJ = "EDITORPUBOBJ";
    public static final String FIELD_ENABLEJIT = "ENABLEJIT";
    public static final String FIELD_FORMLAYOUTMODE = "FORMLAYOUTMODE";
    public static final String FIELD_JITAPPOBJ = "JITAPPOBJ";
    public static final String FIELD_MEMO = "MEMO";
    public static final String FIELD_PSAPPTYPEID = "PSAPPTYPEID";
    public static final String FIELD_PSAPPTYPENAME = "PSAPPTYPENAME";
    public static final String FIELD_PSPFID = "PSPFID";
    public static final String FIELD_PSPFNAME = "PSPFNAME";
    public static final String FIELD_PUBMODE = "PUBMODE";
    public static final String FIELD_STYLE2OBJ = "STYLE2OBJ";
    public static final String FIELD_STYLEOBJ = "STYLEOBJ";
    public static final String FIELD_TYPEOBJ = "TYPEOBJ";
    public static final String FIELD_UAPUBOBJ = "UAPUBOBJ";
    public static final String FIELD_UPDATEDATE = "UPDATEDATE";
    public static final String FIELD_UPDATEMAN = "UPDATEMAN";
    public static final String FIELD_USEJITPREVIEW = "USEJITPREVIEW";
    public static final String FIELD_V2FOLDER = "V2FOLDER";
    public static final String FIELD_V2GITPATH = "V2GITPATH";
    public static final String FIELD_V2VIEWMACROPARAMS = "V2VIEWMACROPARAMS";
    public static final String FIELD_V2VIEWPUBOBJ = "V2VIEWPUBOBJ";
    public static final String FIELD_VALIDFLAG = "VALIDFLAG";
    public static final String FIELD_VIEWPUBOBJ = "VIEWPUBOBJ";
    public static final String FIELD_VLPUBOBJ = "VLPUBOBJ";
    private static final int INDEX_APPPUBOBJ = 0;
    private static final int INDEX_CREATEDATE = 1;
    private static final int INDEX_CREATEMAN = 2;
    private static final int INDEX_CTRLPARTPUBOBJ = 3;
    private static final int INDEX_CTRLPUBOBJ = 4;
    private static final int INDEX_EDITORPUBOBJ = 5;
    private static final int INDEX_ENABLEJIT = 6;
    private static final int INDEX_FORMLAYOUTMODE = 7;
    private static final int INDEX_JITAPPOBJ = 8;
    private static final int INDEX_MEMO = 9;
    private static final int INDEX_PSAPPTYPEID = 10;
    private static final int INDEX_PSAPPTYPENAME = 11;
    private static final int INDEX_PSPFID = 12;
    private static final int INDEX_PSPFNAME = 13;
    private static final int INDEX_PUBMODE = 14;
    private static final int INDEX_STYLE2OBJ = 15;
    private static final int INDEX_STYLEOBJ = 16;
    private static final int INDEX_TYPEOBJ = 17;
    private static final int INDEX_UAPUBOBJ = 18;
    private static final int INDEX_UPDATEDATE = 19;
    private static final int INDEX_UPDATEMAN = 20;
    private static final int INDEX_USEJITPREVIEW = 21;
    private static final int INDEX_V2FOLDER = 22;
    private static final int INDEX_V2GITPATH = 23;
    private static final int INDEX_V2VIEWMACROPARAMS = 24;
    private static final int INDEX_V2VIEWPUBOBJ = 25;
    private static final int INDEX_VALIDFLAG = 26;
    private static final int INDEX_VIEWPUBOBJ = 27;
    private static final int INDEX_VLPUBOBJ = 28;
    private static final HashMap<String, Integer> fieldIndexMap = new HashMap();
    private PSPFBase proxyPSPFBase = null;
    private boolean apppubobjDirtyFlag = false;
    private boolean createdateDirtyFlag = false;
    private boolean createmanDirtyFlag = false;
    private boolean ctrlpartpubobjDirtyFlag = false;
    private boolean ctrlpubobjDirtyFlag = false;
    private boolean editorpubobjDirtyFlag = false;
    private boolean enablejitDirtyFlag = false;
    private boolean formlayoutmodeDirtyFlag = false;
    private boolean jitappobjDirtyFlag = false;
    private boolean memoDirtyFlag = false;
    private boolean psapptypeidDirtyFlag = false;
    private boolean psapptypenameDirtyFlag = false;
    private boolean pspfidDirtyFlag = false;
    private boolean pspfnameDirtyFlag = false;
    private boolean pubmodeDirtyFlag = false;
    private boolean style2objDirtyFlag = false;
    private boolean styleobjDirtyFlag = false;
    private boolean typeobjDirtyFlag = false;
    private boolean uapubobjDirtyFlag = false;
    private boolean updatedateDirtyFlag = false;
    private boolean updatemanDirtyFlag = false;
    private boolean usejitpreviewDirtyFlag = false;
    private boolean v2folderDirtyFlag = false;
    private boolean v2gitpathDirtyFlag = false;
    private boolean v2viewmacroparamsDirtyFlag = false;
    private boolean v2viewpubobjDirtyFlag = false;
    private boolean validflagDirtyFlag = false;
    private boolean viewpubobjDirtyFlag = false;
    private boolean vlpubobjDirtyFlag = false;
    @Column(name="apppubobj")
    private String apppubobj;
    @Column(name="createdate")
    private Timestamp createdate;
    @Column(name="createman")
    private String createman;
    @Column(name="ctrlpartpubobj")
    private String ctrlpartpubobj;
    @Column(name="ctrlpubobj")
    private String ctrlpubobj;
    @Column(name="editorpubobj")
    private String editorpubobj;
    @Column(name="enablejit")
    private Integer enablejit;
    @Column(name="formlayoutmode")
    private String formlayoutmode;
    @Column(name="jitappobj")
    private String jitappobj;
    @Column(name="memo")
    private String memo;
    @Column(name="psapptypeid")
    private String psapptypeid;
    @Column(name="psapptypename")
    private String psapptypename;
    @Column(name="pspfid")
    private String pspfid;
    @Column(name="pspfname")
    private String pspfname;
    @Column(name="pubmode")
    private Integer pubmode;
    @Column(name="style2obj")
    private String style2obj;
    @Column(name="styleobj")
    private String styleobj;
    @Column(name="typeobj")
    private String typeobj;
    @Column(name="uapubobj")
    private String uapubobj;
    @Column(name="updatedate")
    private Timestamp updatedate;
    @Column(name="updateman")
    private String updateman;
    @Column(name="usejitpreview")
    private Integer usejitpreview;
    @Column(name="v2folder")
    private String v2folder;
    @Column(name="v2gitpath")
    private String v2gitpath;
    @Column(name="v2viewmacroparams")
    private String v2viewmacroparams;
    @Column(name="v2viewpubobj")
    private String v2viewpubobj;
    @Column(name="validflag")
    private Integer validflag;
    @Column(name="viewpubobj")
    private String viewpubobj;
    @Column(name="vlpubobj")
    private String vlpubobj;
    private Integer objPSAppTypeLock = new Integer(1);
    private PSAppType psapptype = null;
    private Integer objPSPFPreviewNodesLock = new Integer(1);
    private ArrayList<PSPFPreviewNode> pspfpreviewnodes = null;
    private Integer objPSPFPubCodesLock = new Integer(1);
    private ArrayList<PSPFPubCode> pspfpubcodes = null;
    private Integer objPSPFQuickTemplsLock = new Integer(1);
    private ArrayList<PSPFQuickTempl> pspfquicktempls = null;
    private Integer objPSPFResourcesLock = new Integer(1);
    private ArrayList<PSPFResource> pspfresources = null;
    private Integer objPSPFUATemplsLock = new Integer(1);
    private ArrayList<PSPFUATempl> pspfuatempls = null;
    private Integer objPSSFPFsLock = new Integer(1);
    private ArrayList<PSSFPF> pssfpfs = null;

    public void setAppPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setAppPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.apppubobj = string;
        this.apppubobjDirtyFlag = true;
    }

    public String getAppPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getAppPubObj();
        }
        return this.apppubobj;
    }

    public boolean isAppPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isAppPubObjDirty();
        }
        return this.apppubobjDirtyFlag;
    }

    public void resetAppPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetAppPubObj();
            return;
        }
        this.apppubobjDirtyFlag = false;
        this.apppubobj = null;
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

    public void setCtrlPartPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPartPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpartpubobj = string;
        this.ctrlpartpubobjDirtyFlag = true;
    }

    public String getCtrlPartPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPartPubObj();
        }
        return this.ctrlpartpubobj;
    }

    public boolean isCtrlPartPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPartPubObjDirty();
        }
        return this.ctrlpartpubobjDirtyFlag;
    }

    public void resetCtrlPartPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPartPubObj();
            return;
        }
        this.ctrlpartpubobjDirtyFlag = false;
        this.ctrlpartpubobj = null;
    }

    public void setCtrlPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setCtrlPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.ctrlpubobj = string;
        this.ctrlpubobjDirtyFlag = true;
    }

    public String getCtrlPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getCtrlPubObj();
        }
        return this.ctrlpubobj;
    }

    public boolean isCtrlPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isCtrlPubObjDirty();
        }
        return this.ctrlpubobjDirtyFlag;
    }

    public void resetCtrlPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetCtrlPubObj();
            return;
        }
        this.ctrlpubobjDirtyFlag = false;
        this.ctrlpubobj = null;
    }

    public void setEditorPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEditorPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.editorpubobj = string;
        this.editorpubobjDirtyFlag = true;
    }

    public String getEditorPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEditorPubObj();
        }
        return this.editorpubobj;
    }

    public boolean isEditorPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEditorPubObjDirty();
        }
        return this.editorpubobjDirtyFlag;
    }

    public void resetEditorPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEditorPubObj();
            return;
        }
        this.editorpubobjDirtyFlag = false;
        this.editorpubobj = null;
    }

    public void setEnableJIT(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setEnableJIT(n);
            return;
        }
        this.enablejit = n;
        this.enablejitDirtyFlag = true;
    }

    public Integer getEnableJIT() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getEnableJIT();
        }
        return this.enablejit;
    }

    public boolean isEnableJITDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isEnableJITDirty();
        }
        return this.enablejitDirtyFlag;
    }

    public void resetEnableJIT() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetEnableJIT();
            return;
        }
        this.enablejitDirtyFlag = false;
        this.enablejit = null;
    }

    public void setFormLayoutMode(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setFormLayoutMode(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.formlayoutmode = string;
        this.formlayoutmodeDirtyFlag = true;
    }

    public String getFormLayoutMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getFormLayoutMode();
        }
        return this.formlayoutmode;
    }

    public boolean isFormLayoutModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isFormLayoutModeDirty();
        }
        return this.formlayoutmodeDirtyFlag;
    }

    public void resetFormLayoutMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetFormLayoutMode();
            return;
        }
        this.formlayoutmodeDirtyFlag = false;
        this.formlayoutmode = null;
    }

    public void setJITAppObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setJITAppObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.jitappobj = string;
        this.jitappobjDirtyFlag = true;
    }

    public String getJITAppObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getJITAppObj();
        }
        return this.jitappobj;
    }

    public boolean isJITAppObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isJITAppObjDirty();
        }
        return this.jitappobjDirtyFlag;
    }

    public void resetJITAppObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetJITAppObj();
            return;
        }
        this.jitappobjDirtyFlag = false;
        this.jitappobj = null;
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

    public void setPSAppTypeId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypeid = string;
        this.psapptypeidDirtyFlag = true;
    }

    public String getPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeId();
        }
        return this.psapptypeid;
    }

    public boolean isPSAppTypeIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeIdDirty();
        }
        return this.psapptypeidDirtyFlag;
    }

    public void resetPSAppTypeId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeId();
            return;
        }
        this.psapptypeidDirtyFlag = false;
        this.psapptypeid = null;
    }

    public void setPSAppTypeName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSAppTypeName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.psapptypename = string;
        this.psapptypenameDirtyFlag = true;
    }

    public String getPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppTypeName();
        }
        return this.psapptypename;
    }

    public boolean isPSAppTypeNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSAppTypeNameDirty();
        }
        return this.psapptypenameDirtyFlag;
    }

    public void resetPSAppTypeName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSAppTypeName();
            return;
        }
        this.psapptypenameDirtyFlag = false;
        this.psapptypename = null;
    }

    public void setPSPFId(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFId(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfid = string;
        this.pspfidDirtyFlag = true;
    }

    public String getPSPFId() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFId();
        }
        return this.pspfid;
    }

    public boolean isPSPFIdDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFIdDirty();
        }
        return this.pspfidDirtyFlag;
    }

    public void resetPSPFId() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFId();
            return;
        }
        this.pspfidDirtyFlag = false;
        this.pspfid = null;
    }

    public void setPSPFName(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPSPFName(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.pspfname = string;
        this.pspfnameDirtyFlag = true;
    }

    public String getPSPFName() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFName();
        }
        return this.pspfname;
    }

    public boolean isPSPFNameDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPSPFNameDirty();
        }
        return this.pspfnameDirtyFlag;
    }

    public void resetPSPFName() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPSPFName();
            return;
        }
        this.pspfnameDirtyFlag = false;
        this.pspfname = null;
    }

    public void setPubMode(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setPubMode(n);
            return;
        }
        this.pubmode = n;
        this.pubmodeDirtyFlag = true;
    }

    public Integer getPubMode() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPubMode();
        }
        return this.pubmode;
    }

    public boolean isPubModeDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isPubModeDirty();
        }
        return this.pubmodeDirtyFlag;
    }

    public void resetPubMode() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetPubMode();
            return;
        }
        this.pubmodeDirtyFlag = false;
        this.pubmode = null;
    }

    public void setStyle2Obj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyle2Obj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.style2obj = string;
        this.style2objDirtyFlag = true;
    }

    public String getStyle2Obj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyle2Obj();
        }
        return this.style2obj;
    }

    public boolean isStyle2ObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyle2ObjDirty();
        }
        return this.style2objDirtyFlag;
    }

    public void resetStyle2Obj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyle2Obj();
            return;
        }
        this.style2objDirtyFlag = false;
        this.style2obj = null;
    }

    public void setStyleObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setStyleObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.styleobj = string;
        this.styleobjDirtyFlag = true;
    }

    public String getStyleObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getStyleObj();
        }
        return this.styleobj;
    }

    public boolean isStyleObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isStyleObjDirty();
        }
        return this.styleobjDirtyFlag;
    }

    public void resetStyleObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetStyleObj();
            return;
        }
        this.styleobjDirtyFlag = false;
        this.styleobj = null;
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

    public void setUAPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUAPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.uapubobj = string;
        this.uapubobjDirtyFlag = true;
    }

    public String getUAPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUAPubObj();
        }
        return this.uapubobj;
    }

    public boolean isUAPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUAPubObjDirty();
        }
        return this.uapubobjDirtyFlag;
    }

    public void resetUAPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUAPubObj();
            return;
        }
        this.uapubobjDirtyFlag = false;
        this.uapubobj = null;
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

    public void setUseJITPreview(Integer n) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setUseJITPreview(n);
            return;
        }
        this.usejitpreview = n;
        this.usejitpreviewDirtyFlag = true;
    }

    public Integer getUseJITPreview() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getUseJITPreview();
        }
        return this.usejitpreview;
    }

    public boolean isUseJITPreviewDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isUseJITPreviewDirty();
        }
        return this.usejitpreviewDirtyFlag;
    }

    public void resetUseJITPreview() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetUseJITPreview();
            return;
        }
        this.usejitpreviewDirtyFlag = false;
        this.usejitpreview = null;
    }

    public void setV2Folder(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2Folder(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2folder = string;
        this.v2folderDirtyFlag = true;
    }

    public String getV2Folder() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2Folder();
        }
        return this.v2folder;
    }

    public boolean isV2FolderDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2FolderDirty();
        }
        return this.v2folderDirtyFlag;
    }

    public void resetV2Folder() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2Folder();
            return;
        }
        this.v2folderDirtyFlag = false;
        this.v2folder = null;
    }

    public void setV2GitPath(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2GitPath(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2gitpath = string;
        this.v2gitpathDirtyFlag = true;
    }

    public String getV2GitPath() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2GitPath();
        }
        return this.v2gitpath;
    }

    public boolean isV2GitPathDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2GitPathDirty();
        }
        return this.v2gitpathDirtyFlag;
    }

    public void resetV2GitPath() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2GitPath();
            return;
        }
        this.v2gitpathDirtyFlag = false;
        this.v2gitpath = null;
    }

    public void setV2ViewMacroParams(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2ViewMacroParams(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2viewmacroparams = string;
        this.v2viewmacroparamsDirtyFlag = true;
    }

    public String getV2ViewMacroParams() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2ViewMacroParams();
        }
        return this.v2viewmacroparams;
    }

    public boolean isV2ViewMacroParamsDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2ViewMacroParamsDirty();
        }
        return this.v2viewmacroparamsDirtyFlag;
    }

    public void resetV2ViewMacroParams() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2ViewMacroParams();
            return;
        }
        this.v2viewmacroparamsDirtyFlag = false;
        this.v2viewmacroparams = null;
    }

    public void setV2ViewPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setV2ViewPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.v2viewpubobj = string;
        this.v2viewpubobjDirtyFlag = true;
    }

    public String getV2ViewPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getV2ViewPubObj();
        }
        return this.v2viewpubobj;
    }

    public boolean isV2ViewPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isV2ViewPubObjDirty();
        }
        return this.v2viewpubobjDirtyFlag;
    }

    public void resetV2ViewPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetV2ViewPubObj();
            return;
        }
        this.v2viewpubobjDirtyFlag = false;
        this.v2viewpubobj = null;
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

    public void setViewPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setViewPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.viewpubobj = string;
        this.viewpubobjDirtyFlag = true;
    }

    public String getViewPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getViewPubObj();
        }
        return this.viewpubobj;
    }

    public boolean isViewPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isViewPubObjDirty();
        }
        return this.viewpubobjDirtyFlag;
    }

    public void resetViewPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetViewPubObj();
            return;
        }
        this.viewpubobjDirtyFlag = false;
        this.viewpubobj = null;
    }

    public void setVLPubObj(String string) {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().setVLPubObj(string);
            return;
        }
        if (string != null && (string = StringHelper.trimRight((String)string)).length() == 0) {
            string = null;
        }
        this.vlpubobj = string;
        this.vlpubobjDirtyFlag = true;
    }

    public String getVLPubObj() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getVLPubObj();
        }
        return this.vlpubobj;
    }

    public boolean isVLPubObjDirty() {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().isVLPubObjDirty();
        }
        return this.vlpubobjDirtyFlag;
    }

    public void resetVLPubObj() {
        if (this.getProxyEntity() != null) {
            this.getProxyEntity().resetVLPubObj();
            return;
        }
        this.vlpubobjDirtyFlag = false;
        this.vlpubobj = null;
    }

    protected void onReset() {
        PSPFBase.resetAll(this);
        super.onReset();
    }

    private static void resetAll(PSPFBase pSPFBase) {
        pSPFBase.resetAppPubObj();
        pSPFBase.resetCreateDate();
        pSPFBase.resetCreateMan();
        pSPFBase.resetCtrlPartPubObj();
        pSPFBase.resetCtrlPubObj();
        pSPFBase.resetEditorPubObj();
        pSPFBase.resetEnableJIT();
        pSPFBase.resetFormLayoutMode();
        pSPFBase.resetJITAppObj();
        pSPFBase.resetMemo();
        pSPFBase.resetPSAppTypeId();
        pSPFBase.resetPSAppTypeName();
        pSPFBase.resetPSPFId();
        pSPFBase.resetPSPFName();
        pSPFBase.resetPubMode();
        pSPFBase.resetStyle2Obj();
        pSPFBase.resetStyleObj();
        pSPFBase.resetTypeObj();
        pSPFBase.resetUAPubObj();
        pSPFBase.resetUpdateDate();
        pSPFBase.resetUpdateMan();
        pSPFBase.resetUseJITPreview();
        pSPFBase.resetV2Folder();
        pSPFBase.resetV2GitPath();
        pSPFBase.resetV2ViewMacroParams();
        pSPFBase.resetV2ViewPubObj();
        pSPFBase.resetValidFlag();
        pSPFBase.resetViewPubObj();
        pSPFBase.resetVLPubObj();
    }

    protected void onFillMap(HashMap<String, Object> hashMap, boolean bl) {
        if (!bl || this.isAppPubObjDirty()) {
            hashMap.put(FIELD_APPPUBOBJ, this.getAppPubObj());
        }
        if (!bl || this.isCreateDateDirty()) {
            hashMap.put(FIELD_CREATEDATE, this.getCreateDate());
        }
        if (!bl || this.isCreateManDirty()) {
            hashMap.put(FIELD_CREATEMAN, this.getCreateMan());
        }
        if (!bl || this.isCtrlPartPubObjDirty()) {
            hashMap.put(FIELD_CTRLPARTPUBOBJ, this.getCtrlPartPubObj());
        }
        if (!bl || this.isCtrlPubObjDirty()) {
            hashMap.put(FIELD_CTRLPUBOBJ, this.getCtrlPubObj());
        }
        if (!bl || this.isEditorPubObjDirty()) {
            hashMap.put(FIELD_EDITORPUBOBJ, this.getEditorPubObj());
        }
        if (!bl || this.isEnableJITDirty()) {
            hashMap.put(FIELD_ENABLEJIT, this.getEnableJIT());
        }
        if (!bl || this.isFormLayoutModeDirty()) {
            hashMap.put(FIELD_FORMLAYOUTMODE, this.getFormLayoutMode());
        }
        if (!bl || this.isJITAppObjDirty()) {
            hashMap.put(FIELD_JITAPPOBJ, this.getJITAppObj());
        }
        if (!bl || this.isMemoDirty()) {
            hashMap.put(FIELD_MEMO, this.getMemo());
        }
        if (!bl || this.isPSAppTypeIdDirty()) {
            hashMap.put(FIELD_PSAPPTYPEID, this.getPSAppTypeId());
        }
        if (!bl || this.isPSAppTypeNameDirty()) {
            hashMap.put(FIELD_PSAPPTYPENAME, this.getPSAppTypeName());
        }
        if (!bl || this.isPSPFIdDirty()) {
            hashMap.put(FIELD_PSPFID, this.getPSPFId());
        }
        if (!bl || this.isPSPFNameDirty()) {
            hashMap.put(FIELD_PSPFNAME, this.getPSPFName());
        }
        if (!bl || this.isPubModeDirty()) {
            hashMap.put(FIELD_PUBMODE, this.getPubMode());
        }
        if (!bl || this.isStyle2ObjDirty()) {
            hashMap.put(FIELD_STYLE2OBJ, this.getStyle2Obj());
        }
        if (!bl || this.isStyleObjDirty()) {
            hashMap.put(FIELD_STYLEOBJ, this.getStyleObj());
        }
        if (!bl || this.isTypeObjDirty()) {
            hashMap.put(FIELD_TYPEOBJ, this.getTypeObj());
        }
        if (!bl || this.isUAPubObjDirty()) {
            hashMap.put(FIELD_UAPUBOBJ, this.getUAPubObj());
        }
        if (!bl || this.isUpdateDateDirty()) {
            hashMap.put(FIELD_UPDATEDATE, this.getUpdateDate());
        }
        if (!bl || this.isUpdateManDirty()) {
            hashMap.put(FIELD_UPDATEMAN, this.getUpdateMan());
        }
        if (!bl || this.isUseJITPreviewDirty()) {
            hashMap.put(FIELD_USEJITPREVIEW, this.getUseJITPreview());
        }
        if (!bl || this.isV2FolderDirty()) {
            hashMap.put(FIELD_V2FOLDER, this.getV2Folder());
        }
        if (!bl || this.isV2GitPathDirty()) {
            hashMap.put(FIELD_V2GITPATH, this.getV2GitPath());
        }
        if (!bl || this.isV2ViewMacroParamsDirty()) {
            hashMap.put(FIELD_V2VIEWMACROPARAMS, this.getV2ViewMacroParams());
        }
        if (!bl || this.isV2ViewPubObjDirty()) {
            hashMap.put(FIELD_V2VIEWPUBOBJ, this.getV2ViewPubObj());
        }
        if (!bl || this.isValidFlagDirty()) {
            hashMap.put(FIELD_VALIDFLAG, this.getValidFlag());
        }
        if (!bl || this.isViewPubObjDirty()) {
            hashMap.put(FIELD_VIEWPUBOBJ, this.getViewPubObj());
        }
        if (!bl || this.isVLPubObjDirty()) {
            hashMap.put(FIELD_VLPUBOBJ, this.getVLPubObj());
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
        return PSPFBase.get(this, n);
    }

    private static Object get(PSPFBase pSPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFBase.getAppPubObj();
            }
            case 1: {
                return pSPFBase.getCreateDate();
            }
            case 2: {
                return pSPFBase.getCreateMan();
            }
            case 3: {
                return pSPFBase.getCtrlPartPubObj();
            }
            case 4: {
                return pSPFBase.getCtrlPubObj();
            }
            case 5: {
                return pSPFBase.getEditorPubObj();
            }
            case 6: {
                return pSPFBase.getEnableJIT();
            }
            case 7: {
                return pSPFBase.getFormLayoutMode();
            }
            case 8: {
                return pSPFBase.getJITAppObj();
            }
            case 9: {
                return pSPFBase.getMemo();
            }
            case 10: {
                return pSPFBase.getPSAppTypeId();
            }
            case 11: {
                return pSPFBase.getPSAppTypeName();
            }
            case 12: {
                return pSPFBase.getPSPFId();
            }
            case 13: {
                return pSPFBase.getPSPFName();
            }
            case 14: {
                return pSPFBase.getPubMode();
            }
            case 15: {
                return pSPFBase.getStyle2Obj();
            }
            case 16: {
                return pSPFBase.getStyleObj();
            }
            case 17: {
                return pSPFBase.getTypeObj();
            }
            case 18: {
                return pSPFBase.getUAPubObj();
            }
            case 19: {
                return pSPFBase.getUpdateDate();
            }
            case 20: {
                return pSPFBase.getUpdateMan();
            }
            case 21: {
                return pSPFBase.getUseJITPreview();
            }
            case 22: {
                return pSPFBase.getV2Folder();
            }
            case 23: {
                return pSPFBase.getV2GitPath();
            }
            case 24: {
                return pSPFBase.getV2ViewMacroParams();
            }
            case 25: {
                return pSPFBase.getV2ViewPubObj();
            }
            case 26: {
                return pSPFBase.getValidFlag();
            }
            case 27: {
                return pSPFBase.getViewPubObj();
            }
            case 28: {
                return pSPFBase.getVLPubObj();
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
        PSPFBase.set(this, n, object);
    }

    private static void set(PSPFBase pSPFBase, int n, Object object) throws Exception {
        switch (n) {
            case 0: {
                pSPFBase.setAppPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 1: {
                pSPFBase.setCreateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 2: {
                pSPFBase.setCreateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 3: {
                pSPFBase.setCtrlPartPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 4: {
                pSPFBase.setCtrlPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 5: {
                pSPFBase.setEditorPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 6: {
                pSPFBase.setEnableJIT(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 7: {
                pSPFBase.setFormLayoutMode(DataObject.getStringValue((Object)object));
                return;
            }
            case 8: {
                pSPFBase.setJITAppObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 9: {
                pSPFBase.setMemo(DataObject.getStringValue((Object)object));
                return;
            }
            case 10: {
                pSPFBase.setPSAppTypeId(DataObject.getStringValue((Object)object));
                return;
            }
            case 11: {
                pSPFBase.setPSAppTypeName(DataObject.getStringValue((Object)object));
                return;
            }
            case 12: {
                pSPFBase.setPSPFId(DataObject.getStringValue((Object)object));
                return;
            }
            case 13: {
                pSPFBase.setPSPFName(DataObject.getStringValue((Object)object));
                return;
            }
            case 14: {
                pSPFBase.setPubMode(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 15: {
                pSPFBase.setStyle2Obj(DataObject.getStringValue((Object)object));
                return;
            }
            case 16: {
                pSPFBase.setStyleObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 17: {
                pSPFBase.setTypeObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 18: {
                pSPFBase.setUAPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 19: {
                pSPFBase.setUpdateDate(DataObject.getTimestampValue((Object)object));
                return;
            }
            case 20: {
                pSPFBase.setUpdateMan(DataObject.getStringValue((Object)object));
                return;
            }
            case 21: {
                pSPFBase.setUseJITPreview(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 22: {
                pSPFBase.setV2Folder(DataObject.getStringValue((Object)object));
                return;
            }
            case 23: {
                pSPFBase.setV2GitPath(DataObject.getStringValue((Object)object));
                return;
            }
            case 24: {
                pSPFBase.setV2ViewMacroParams(DataObject.getStringValue((Object)object));
                return;
            }
            case 25: {
                pSPFBase.setV2ViewPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 26: {
                pSPFBase.setValidFlag(DataObject.getIntegerValue((Object)object));
                return;
            }
            case 27: {
                pSPFBase.setViewPubObj(DataObject.getStringValue((Object)object));
                return;
            }
            case 28: {
                pSPFBase.setVLPubObj(DataObject.getStringValue((Object)object));
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
        return PSPFBase.isNull(this, n);
    }

    private static boolean isNull(PSPFBase pSPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFBase.getAppPubObj() == null;
            }
            case 1: {
                return pSPFBase.getCreateDate() == null;
            }
            case 2: {
                return pSPFBase.getCreateMan() == null;
            }
            case 3: {
                return pSPFBase.getCtrlPartPubObj() == null;
            }
            case 4: {
                return pSPFBase.getCtrlPubObj() == null;
            }
            case 5: {
                return pSPFBase.getEditorPubObj() == null;
            }
            case 6: {
                return pSPFBase.getEnableJIT() == null;
            }
            case 7: {
                return pSPFBase.getFormLayoutMode() == null;
            }
            case 8: {
                return pSPFBase.getJITAppObj() == null;
            }
            case 9: {
                return pSPFBase.getMemo() == null;
            }
            case 10: {
                return pSPFBase.getPSAppTypeId() == null;
            }
            case 11: {
                return pSPFBase.getPSAppTypeName() == null;
            }
            case 12: {
                return pSPFBase.getPSPFId() == null;
            }
            case 13: {
                return pSPFBase.getPSPFName() == null;
            }
            case 14: {
                return pSPFBase.getPubMode() == null;
            }
            case 15: {
                return pSPFBase.getStyle2Obj() == null;
            }
            case 16: {
                return pSPFBase.getStyleObj() == null;
            }
            case 17: {
                return pSPFBase.getTypeObj() == null;
            }
            case 18: {
                return pSPFBase.getUAPubObj() == null;
            }
            case 19: {
                return pSPFBase.getUpdateDate() == null;
            }
            case 20: {
                return pSPFBase.getUpdateMan() == null;
            }
            case 21: {
                return pSPFBase.getUseJITPreview() == null;
            }
            case 22: {
                return pSPFBase.getV2Folder() == null;
            }
            case 23: {
                return pSPFBase.getV2GitPath() == null;
            }
            case 24: {
                return pSPFBase.getV2ViewMacroParams() == null;
            }
            case 25: {
                return pSPFBase.getV2ViewPubObj() == null;
            }
            case 26: {
                return pSPFBase.getValidFlag() == null;
            }
            case 27: {
                return pSPFBase.getViewPubObj() == null;
            }
            case 28: {
                return pSPFBase.getVLPubObj() == null;
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
        return PSPFBase.contains(this, n);
    }

    private static boolean contains(PSPFBase pSPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                return pSPFBase.isAppPubObjDirty();
            }
            case 1: {
                return pSPFBase.isCreateDateDirty();
            }
            case 2: {
                return pSPFBase.isCreateManDirty();
            }
            case 3: {
                return pSPFBase.isCtrlPartPubObjDirty();
            }
            case 4: {
                return pSPFBase.isCtrlPubObjDirty();
            }
            case 5: {
                return pSPFBase.isEditorPubObjDirty();
            }
            case 6: {
                return pSPFBase.isEnableJITDirty();
            }
            case 7: {
                return pSPFBase.isFormLayoutModeDirty();
            }
            case 8: {
                return pSPFBase.isJITAppObjDirty();
            }
            case 9: {
                return pSPFBase.isMemoDirty();
            }
            case 10: {
                return pSPFBase.isPSAppTypeIdDirty();
            }
            case 11: {
                return pSPFBase.isPSAppTypeNameDirty();
            }
            case 12: {
                return pSPFBase.isPSPFIdDirty();
            }
            case 13: {
                return pSPFBase.isPSPFNameDirty();
            }
            case 14: {
                return pSPFBase.isPubModeDirty();
            }
            case 15: {
                return pSPFBase.isStyle2ObjDirty();
            }
            case 16: {
                return pSPFBase.isStyleObjDirty();
            }
            case 17: {
                return pSPFBase.isTypeObjDirty();
            }
            case 18: {
                return pSPFBase.isUAPubObjDirty();
            }
            case 19: {
                return pSPFBase.isUpdateDateDirty();
            }
            case 20: {
                return pSPFBase.isUpdateManDirty();
            }
            case 21: {
                return pSPFBase.isUseJITPreviewDirty();
            }
            case 22: {
                return pSPFBase.isV2FolderDirty();
            }
            case 23: {
                return pSPFBase.isV2GitPathDirty();
            }
            case 24: {
                return pSPFBase.isV2ViewMacroParamsDirty();
            }
            case 25: {
                return pSPFBase.isV2ViewPubObjDirty();
            }
            case 26: {
                return pSPFBase.isValidFlagDirty();
            }
            case 27: {
                return pSPFBase.isViewPubObjDirty();
            }
            case 28: {
                return pSPFBase.isVLPubObjDirty();
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    protected void onFillJSONObject(JSONObject jSONObject, boolean bl) throws Exception {
        PSPFBase.fillJSONObject(this, jSONObject, bl);
        super.onFillJSONObject(jSONObject, bl);
    }

    private static void fillJSONObject(PSPFBase pSPFBase, JSONObject jSONObject, boolean bl) throws Exception {
        if (bl || pSPFBase.getAppPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"apppubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getAppPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getCreateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createdate", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getCreateDate()), (boolean)false);
        }
        if (bl || pSPFBase.getCreateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"createman", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getCreateMan()), (boolean)false);
        }
        if (bl || pSPFBase.getCtrlPartPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpartpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getCtrlPartPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getCtrlPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"ctrlpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getCtrlPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getEditorPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"editorpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getEditorPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getEnableJIT() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"enablejit", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getEnableJIT()), (boolean)false);
        }
        if (bl || pSPFBase.getFormLayoutMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"formlayoutmode", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getFormLayoutMode()), (boolean)false);
        }
        if (bl || pSPFBase.getJITAppObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"jitappobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getJITAppObj()), (boolean)false);
        }
        if (bl || pSPFBase.getMemo() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"memo", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getMemo()), (boolean)false);
        }
        if (bl || pSPFBase.getPSAppTypeId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypeid", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getPSAppTypeId()), (boolean)false);
        }
        if (bl || pSPFBase.getPSAppTypeName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"psapptypename", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getPSAppTypeName()), (boolean)false);
        }
        if (bl || pSPFBase.getPSPFId() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfid", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getPSPFId()), (boolean)false);
        }
        if (bl || pSPFBase.getPSPFName() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pspfname", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getPSPFName()), (boolean)false);
        }
        if (bl || pSPFBase.getPubMode() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"pubmode", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getPubMode()), (boolean)false);
        }
        if (bl || pSPFBase.getStyle2Obj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"style2obj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getStyle2Obj()), (boolean)false);
        }
        if (bl || pSPFBase.getStyleObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"styleobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getStyleObj()), (boolean)false);
        }
        if (bl || pSPFBase.getTypeObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"typeobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getTypeObj()), (boolean)false);
        }
        if (bl || pSPFBase.getUAPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"uapubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getUAPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getUpdateDate() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updatedate", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getUpdateDate()), (boolean)false);
        }
        if (bl || pSPFBase.getUpdateMan() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"updateman", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getUpdateMan()), (boolean)false);
        }
        if (bl || pSPFBase.getUseJITPreview() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"usejitpreview", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getUseJITPreview()), (boolean)false);
        }
        if (bl || pSPFBase.getV2Folder() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2folder", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getV2Folder()), (boolean)false);
        }
        if (bl || pSPFBase.getV2GitPath() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2gitpath", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getV2GitPath()), (boolean)false);
        }
        if (bl || pSPFBase.getV2ViewMacroParams() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2viewmacroparams", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getV2ViewMacroParams()), (boolean)false);
        }
        if (bl || pSPFBase.getV2ViewPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"v2viewpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getV2ViewPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getValidFlag() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"validflag", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getValidFlag()), (boolean)false);
        }
        if (bl || pSPFBase.getViewPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"viewpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getViewPubObj()), (boolean)false);
        }
        if (bl || pSPFBase.getVLPubObj() != null) {
            JSONObjectHelper.put((JSONObject)jSONObject, (String)"vlpubobj", (Object)PSPFBase.getJSONValue((Object)pSPFBase.getVLPubObj()), (boolean)false);
        }
    }

    protected void onFillXmlNode(XmlNode xmlNode, boolean bl) throws Exception {
        PSPFBase.fillXmlNode(this, xmlNode, bl);
        super.onFillXmlNode(xmlNode, bl);
    }

    private static void fillXmlNode(PSPFBase pSPFBase, XmlNode xmlNode, boolean bl) throws Exception {
        Object object;
        if (bl || pSPFBase.getAppPubObj() != null) {
            object = pSPFBase.getAppPubObj();
            xmlNode.setAttribute(FIELD_APPPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getCreateDate() != null) {
            object = pSPFBase.getCreateDate();
            xmlNode.setAttribute(FIELD_CREATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFBase.getCreateMan() != null) {
            object = pSPFBase.getCreateMan();
            xmlNode.setAttribute(FIELD_CREATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getCtrlPartPubObj() != null) {
            object = pSPFBase.getCtrlPartPubObj();
            xmlNode.setAttribute(FIELD_CTRLPARTPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getCtrlPubObj() != null) {
            object = pSPFBase.getCtrlPubObj();
            xmlNode.setAttribute(FIELD_CTRLPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getEditorPubObj() != null) {
            object = pSPFBase.getEditorPubObj();
            xmlNode.setAttribute(FIELD_EDITORPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getEnableJIT() != null) {
            object = pSPFBase.getEnableJIT();
            xmlNode.setAttribute(FIELD_ENABLEJIT, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFBase.getFormLayoutMode() != null) {
            object = pSPFBase.getFormLayoutMode();
            xmlNode.setAttribute(FIELD_FORMLAYOUTMODE, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getJITAppObj() != null) {
            object = pSPFBase.getJITAppObj();
            xmlNode.setAttribute(FIELD_JITAPPOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getMemo() != null) {
            object = pSPFBase.getMemo();
            xmlNode.setAttribute(FIELD_MEMO, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getPSAppTypeId() != null) {
            object = pSPFBase.getPSAppTypeId();
            xmlNode.setAttribute(FIELD_PSAPPTYPEID, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getPSAppTypeName() != null) {
            object = pSPFBase.getPSAppTypeName();
            xmlNode.setAttribute(FIELD_PSAPPTYPENAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getPSPFId() != null) {
            object = pSPFBase.getPSPFId();
            xmlNode.setAttribute(FIELD_PSPFID, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getPSPFName() != null) {
            object = pSPFBase.getPSPFName();
            xmlNode.setAttribute(FIELD_PSPFNAME, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getPubMode() != null) {
            object = pSPFBase.getPubMode();
            xmlNode.setAttribute(FIELD_PUBMODE, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFBase.getStyle2Obj() != null) {
            object = pSPFBase.getStyle2Obj();
            xmlNode.setAttribute(FIELD_STYLE2OBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getStyleObj() != null) {
            object = pSPFBase.getStyleObj();
            xmlNode.setAttribute(FIELD_STYLEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getTypeObj() != null) {
            object = pSPFBase.getTypeObj();
            xmlNode.setAttribute(FIELD_TYPEOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getUAPubObj() != null) {
            object = pSPFBase.getUAPubObj();
            xmlNode.setAttribute(FIELD_UAPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getUpdateDate() != null) {
            object = pSPFBase.getUpdateDate();
            xmlNode.setAttribute(FIELD_UPDATEDATE, object == null ? "" : StringHelper.format((String)"%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", (Object)object));
        }
        if (bl || pSPFBase.getUpdateMan() != null) {
            object = pSPFBase.getUpdateMan();
            xmlNode.setAttribute(FIELD_UPDATEMAN, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getUseJITPreview() != null) {
            object = pSPFBase.getUseJITPreview();
            xmlNode.setAttribute(FIELD_USEJITPREVIEW, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFBase.getV2Folder() != null) {
            object = pSPFBase.getV2Folder();
            xmlNode.setAttribute(FIELD_V2FOLDER, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getV2GitPath() != null) {
            object = pSPFBase.getV2GitPath();
            xmlNode.setAttribute(FIELD_V2GITPATH, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getV2ViewMacroParams() != null) {
            object = pSPFBase.getV2ViewMacroParams();
            xmlNode.setAttribute(FIELD_V2VIEWMACROPARAMS, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getV2ViewPubObj() != null) {
            object = pSPFBase.getV2ViewPubObj();
            xmlNode.setAttribute(FIELD_V2VIEWPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getValidFlag() != null) {
            object = pSPFBase.getValidFlag();
            xmlNode.setAttribute(FIELD_VALIDFLAG, object == null ? "" : StringHelper.format((String)"%1$s", (Object)object));
        }
        if (bl || pSPFBase.getViewPubObj() != null) {
            object = pSPFBase.getViewPubObj();
            xmlNode.setAttribute(FIELD_VIEWPUBOBJ, object == null ? "" : (String)object);
        }
        if (bl || pSPFBase.getVLPubObj() != null) {
            object = pSPFBase.getVLPubObj();
            xmlNode.setAttribute(FIELD_VLPUBOBJ, object == null ? "" : (String)object);
        }
    }

    protected void onCopyTo(IDataObject iDataObject, boolean bl) throws Exception {
        PSPFBase.copyTo(this, iDataObject, bl);
        super.onCopyTo(iDataObject, bl);
    }

    private static void copyTo(PSPFBase pSPFBase, IDataObject iDataObject, boolean bl) throws Exception {
        if (pSPFBase.isAppPubObjDirty() && (bl || pSPFBase.getAppPubObj() != null)) {
            iDataObject.set(FIELD_APPPUBOBJ, (Object)pSPFBase.getAppPubObj());
        }
        if (pSPFBase.isCreateDateDirty() && (bl || pSPFBase.getCreateDate() != null)) {
            iDataObject.set(FIELD_CREATEDATE, (Object)pSPFBase.getCreateDate());
        }
        if (pSPFBase.isCreateManDirty() && (bl || pSPFBase.getCreateMan() != null)) {
            iDataObject.set(FIELD_CREATEMAN, (Object)pSPFBase.getCreateMan());
        }
        if (pSPFBase.isCtrlPartPubObjDirty() && (bl || pSPFBase.getCtrlPartPubObj() != null)) {
            iDataObject.set(FIELD_CTRLPARTPUBOBJ, (Object)pSPFBase.getCtrlPartPubObj());
        }
        if (pSPFBase.isCtrlPubObjDirty() && (bl || pSPFBase.getCtrlPubObj() != null)) {
            iDataObject.set(FIELD_CTRLPUBOBJ, (Object)pSPFBase.getCtrlPubObj());
        }
        if (pSPFBase.isEditorPubObjDirty() && (bl || pSPFBase.getEditorPubObj() != null)) {
            iDataObject.set(FIELD_EDITORPUBOBJ, (Object)pSPFBase.getEditorPubObj());
        }
        if (pSPFBase.isEnableJITDirty() && (bl || pSPFBase.getEnableJIT() != null)) {
            iDataObject.set(FIELD_ENABLEJIT, (Object)pSPFBase.getEnableJIT());
        }
        if (pSPFBase.isFormLayoutModeDirty() && (bl || pSPFBase.getFormLayoutMode() != null)) {
            iDataObject.set(FIELD_FORMLAYOUTMODE, (Object)pSPFBase.getFormLayoutMode());
        }
        if (pSPFBase.isJITAppObjDirty() && (bl || pSPFBase.getJITAppObj() != null)) {
            iDataObject.set(FIELD_JITAPPOBJ, (Object)pSPFBase.getJITAppObj());
        }
        if (pSPFBase.isMemoDirty() && (bl || pSPFBase.getMemo() != null)) {
            iDataObject.set(FIELD_MEMO, (Object)pSPFBase.getMemo());
        }
        if (pSPFBase.isPSAppTypeIdDirty() && (bl || pSPFBase.getPSAppTypeId() != null)) {
            iDataObject.set(FIELD_PSAPPTYPEID, (Object)pSPFBase.getPSAppTypeId());
        }
        if (pSPFBase.isPSAppTypeNameDirty() && (bl || pSPFBase.getPSAppTypeName() != null)) {
            iDataObject.set(FIELD_PSAPPTYPENAME, (Object)pSPFBase.getPSAppTypeName());
        }
        if (pSPFBase.isPSPFIdDirty() && (bl || pSPFBase.getPSPFId() != null)) {
            iDataObject.set(FIELD_PSPFID, (Object)pSPFBase.getPSPFId());
        }
        if (pSPFBase.isPSPFNameDirty() && (bl || pSPFBase.getPSPFName() != null)) {
            iDataObject.set(FIELD_PSPFNAME, (Object)pSPFBase.getPSPFName());
        }
        if (pSPFBase.isPubModeDirty() && (bl || pSPFBase.getPubMode() != null)) {
            iDataObject.set(FIELD_PUBMODE, (Object)pSPFBase.getPubMode());
        }
        if (pSPFBase.isStyle2ObjDirty() && (bl || pSPFBase.getStyle2Obj() != null)) {
            iDataObject.set(FIELD_STYLE2OBJ, (Object)pSPFBase.getStyle2Obj());
        }
        if (pSPFBase.isStyleObjDirty() && (bl || pSPFBase.getStyleObj() != null)) {
            iDataObject.set(FIELD_STYLEOBJ, (Object)pSPFBase.getStyleObj());
        }
        if (pSPFBase.isTypeObjDirty() && (bl || pSPFBase.getTypeObj() != null)) {
            iDataObject.set(FIELD_TYPEOBJ, (Object)pSPFBase.getTypeObj());
        }
        if (pSPFBase.isUAPubObjDirty() && (bl || pSPFBase.getUAPubObj() != null)) {
            iDataObject.set(FIELD_UAPUBOBJ, (Object)pSPFBase.getUAPubObj());
        }
        if (pSPFBase.isUpdateDateDirty() && (bl || pSPFBase.getUpdateDate() != null)) {
            iDataObject.set(FIELD_UPDATEDATE, (Object)pSPFBase.getUpdateDate());
        }
        if (pSPFBase.isUpdateManDirty() && (bl || pSPFBase.getUpdateMan() != null)) {
            iDataObject.set(FIELD_UPDATEMAN, (Object)pSPFBase.getUpdateMan());
        }
        if (pSPFBase.isUseJITPreviewDirty() && (bl || pSPFBase.getUseJITPreview() != null)) {
            iDataObject.set(FIELD_USEJITPREVIEW, (Object)pSPFBase.getUseJITPreview());
        }
        if (pSPFBase.isV2FolderDirty() && (bl || pSPFBase.getV2Folder() != null)) {
            iDataObject.set(FIELD_V2FOLDER, (Object)pSPFBase.getV2Folder());
        }
        if (pSPFBase.isV2GitPathDirty() && (bl || pSPFBase.getV2GitPath() != null)) {
            iDataObject.set(FIELD_V2GITPATH, (Object)pSPFBase.getV2GitPath());
        }
        if (pSPFBase.isV2ViewMacroParamsDirty() && (bl || pSPFBase.getV2ViewMacroParams() != null)) {
            iDataObject.set(FIELD_V2VIEWMACROPARAMS, (Object)pSPFBase.getV2ViewMacroParams());
        }
        if (pSPFBase.isV2ViewPubObjDirty() && (bl || pSPFBase.getV2ViewPubObj() != null)) {
            iDataObject.set(FIELD_V2VIEWPUBOBJ, (Object)pSPFBase.getV2ViewPubObj());
        }
        if (pSPFBase.isValidFlagDirty() && (bl || pSPFBase.getValidFlag() != null)) {
            iDataObject.set(FIELD_VALIDFLAG, (Object)pSPFBase.getValidFlag());
        }
        if (pSPFBase.isViewPubObjDirty() && (bl || pSPFBase.getViewPubObj() != null)) {
            iDataObject.set(FIELD_VIEWPUBOBJ, (Object)pSPFBase.getViewPubObj());
        }
        if (pSPFBase.isVLPubObjDirty() && (bl || pSPFBase.getVLPubObj() != null)) {
            iDataObject.set(FIELD_VLPUBOBJ, (Object)pSPFBase.getVLPubObj());
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
        return PSPFBase.remove(this, n);
    }

    private static boolean remove(PSPFBase pSPFBase, int n) throws Exception {
        switch (n) {
            case 0: {
                pSPFBase.resetAppPubObj();
                return true;
            }
            case 1: {
                pSPFBase.resetCreateDate();
                return true;
            }
            case 2: {
                pSPFBase.resetCreateMan();
                return true;
            }
            case 3: {
                pSPFBase.resetCtrlPartPubObj();
                return true;
            }
            case 4: {
                pSPFBase.resetCtrlPubObj();
                return true;
            }
            case 5: {
                pSPFBase.resetEditorPubObj();
                return true;
            }
            case 6: {
                pSPFBase.resetEnableJIT();
                return true;
            }
            case 7: {
                pSPFBase.resetFormLayoutMode();
                return true;
            }
            case 8: {
                pSPFBase.resetJITAppObj();
                return true;
            }
            case 9: {
                pSPFBase.resetMemo();
                return true;
            }
            case 10: {
                pSPFBase.resetPSAppTypeId();
                return true;
            }
            case 11: {
                pSPFBase.resetPSAppTypeName();
                return true;
            }
            case 12: {
                pSPFBase.resetPSPFId();
                return true;
            }
            case 13: {
                pSPFBase.resetPSPFName();
                return true;
            }
            case 14: {
                pSPFBase.resetPubMode();
                return true;
            }
            case 15: {
                pSPFBase.resetStyle2Obj();
                return true;
            }
            case 16: {
                pSPFBase.resetStyleObj();
                return true;
            }
            case 17: {
                pSPFBase.resetTypeObj();
                return true;
            }
            case 18: {
                pSPFBase.resetUAPubObj();
                return true;
            }
            case 19: {
                pSPFBase.resetUpdateDate();
                return true;
            }
            case 20: {
                pSPFBase.resetUpdateMan();
                return true;
            }
            case 21: {
                pSPFBase.resetUseJITPreview();
                return true;
            }
            case 22: {
                pSPFBase.resetV2Folder();
                return true;
            }
            case 23: {
                pSPFBase.resetV2GitPath();
                return true;
            }
            case 24: {
                pSPFBase.resetV2ViewMacroParams();
                return true;
            }
            case 25: {
                pSPFBase.resetV2ViewPubObj();
                return true;
            }
            case 26: {
                pSPFBase.resetValidFlag();
                return true;
            }
            case 27: {
                pSPFBase.resetViewPubObj();
                return true;
            }
            case 28: {
                pSPFBase.resetVLPubObj();
                return true;
            }
        }
        throw new Exception("\u4e0d\u660e\u5c5e\u6027\u6807\u8bc6");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public PSAppType getPSAppType() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSAppType();
        }
        if (this.getPSAppTypeId() == null) {
            return null;
        }
        Integer n = this.objPSAppTypeLock;
        synchronized (n) {
            if (this.psapptype != null && DataTypeHelper.compare((int)25, (Object)this.getPSAppTypeId(), (Object)this.psapptype.getPSAppTypeId()) != 0L) {
                this.psapptype = null;
            }
            if (this.psapptype == null) {
                PSAppType pSAppType = new PSAppType();
                pSAppType.setPSAppTypeId(this.getPSAppTypeId());
                PSAppTypeService pSAppTypeService = (PSAppTypeService)ServiceGlobal.getService(PSAppTypeService.class, (SessionFactory)this.getSessionFactory());
                pSAppTypeService.autoGet((IEntity)pSAppType);
                this.psapptype = pSAppType;
            }
            return this.psapptype;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFPreviewNode> getPSPFPreviewNodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPreviewNodes();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSPFPreviewNodeService pSPFPreviewNodeService = (PSPFPreviewNodeService)ServiceGlobal.getService(PSPFPreviewNodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFPreviewNodesLock;
        synchronized (n) {
            if (this.pspfpreviewnodes == null) {
                this.pspfpreviewnodes = pSPFPreviewNodeService.selectByPSPF(this);
            }
            return this.pspfpreviewnodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFPubCode> getPSPFPubCodes() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFPubCodes();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSPFPubCodeService pSPFPubCodeService = (PSPFPubCodeService)ServiceGlobal.getService(PSPFPubCodeService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFPubCodesLock;
        synchronized (n) {
            if (this.pspfpubcodes == null) {
                this.pspfpubcodes = pSPFPubCodeService.selectByPSPF(this);
            }
            return this.pspfpubcodes;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFQuickTempl> getPSPFQuickTempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFQuickTempls();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSPFQuickTemplService pSPFQuickTemplService = (PSPFQuickTemplService)ServiceGlobal.getService(PSPFQuickTemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFQuickTemplsLock;
        synchronized (n) {
            if (this.pspfquicktempls == null) {
                this.pspfquicktempls = pSPFQuickTemplService.selectByPSPF(this);
            }
            return this.pspfquicktempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFResource> getPSPFResources() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFResources();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSPFResourceService pSPFResourceService = (PSPFResourceService)ServiceGlobal.getService(PSPFResourceService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFResourcesLock;
        synchronized (n) {
            if (this.pspfresources == null) {
                this.pspfresources = pSPFResourceService.selectByPSPF(this);
            }
            return this.pspfresources;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSPFUATempl> getPSPFUATempls() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSPFUATempls();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSPFUATemplService pSPFUATemplService = (PSPFUATemplService)ServiceGlobal.getService(PSPFUATemplService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSPFUATemplsLock;
        synchronized (n) {
            if (this.pspfuatempls == null) {
                this.pspfuatempls = pSPFUATemplService.selectByPSPF(this);
            }
            return this.pspfuatempls;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ArrayList<PSSFPF> getPSSFPFs() throws Exception {
        if (this.getProxyEntity() != null) {
            return this.getProxyEntity().getPSSFPFs();
        }
        if (this.getPSPFId() == null) {
            return null;
        }
        PSSFPFService pSSFPFService = (PSSFPFService)ServiceGlobal.getService(PSSFPFService.class, (SessionFactory)this.getSessionFactory());
        Integer n = this.objPSSFPFsLock;
        synchronized (n) {
            if (this.pssfpfs == null) {
                this.pssfpfs = pSSFPFService.selectByPSPF(this);
            }
            return this.pssfpfs;
        }
    }

    private PSPFBase getProxyEntity() {
        return this.proxyPSPFBase;
    }

    protected void onProxy(IDataObject iDataObject) {
        this.proxyPSPFBase = null;
        if (iDataObject != null && iDataObject instanceof PSPFBase) {
            this.proxyPSPFBase = (PSPFBase)iDataObject;
        }
        super.onProxy(iDataObject);
    }

    protected IEntityActionHelper getActionHelper(boolean bl) throws Exception {
        IEntityActionHelper iEntityActionHelper = super.getActionHelper(false);
        if (!bl || iEntityActionHelper != null) {
            return iEntityActionHelper;
        }
        iEntityActionHelper = ServiceGlobal.getService((String)"net.ibizsys.pscore.srv.config.service.PSPFService", (SessionFactory)this.getSessionFactory()).getServiceActionHelper();
        this.setActionHelper(iEntityActionHelper);
        return iEntityActionHelper;
    }

    static {
        fieldIndexMap.put(FIELD_APPPUBOBJ, 0);
        fieldIndexMap.put(FIELD_CREATEDATE, 1);
        fieldIndexMap.put(FIELD_CREATEMAN, 2);
        fieldIndexMap.put(FIELD_CTRLPARTPUBOBJ, 3);
        fieldIndexMap.put(FIELD_CTRLPUBOBJ, 4);
        fieldIndexMap.put(FIELD_EDITORPUBOBJ, 5);
        fieldIndexMap.put(FIELD_ENABLEJIT, 6);
        fieldIndexMap.put(FIELD_FORMLAYOUTMODE, 7);
        fieldIndexMap.put(FIELD_JITAPPOBJ, 8);
        fieldIndexMap.put(FIELD_MEMO, 9);
        fieldIndexMap.put(FIELD_PSAPPTYPEID, 10);
        fieldIndexMap.put(FIELD_PSAPPTYPENAME, 11);
        fieldIndexMap.put(FIELD_PSPFID, 12);
        fieldIndexMap.put(FIELD_PSPFNAME, 13);
        fieldIndexMap.put(FIELD_PUBMODE, 14);
        fieldIndexMap.put(FIELD_STYLE2OBJ, 15);
        fieldIndexMap.put(FIELD_STYLEOBJ, 16);
        fieldIndexMap.put(FIELD_TYPEOBJ, 17);
        fieldIndexMap.put(FIELD_UAPUBOBJ, 18);
        fieldIndexMap.put(FIELD_UPDATEDATE, 19);
        fieldIndexMap.put(FIELD_UPDATEMAN, 20);
        fieldIndexMap.put(FIELD_USEJITPREVIEW, 21);
        fieldIndexMap.put(FIELD_V2FOLDER, 22);
        fieldIndexMap.put(FIELD_V2GITPATH, 23);
        fieldIndexMap.put(FIELD_V2VIEWMACROPARAMS, 24);
        fieldIndexMap.put(FIELD_V2VIEWPUBOBJ, 25);
        fieldIndexMap.put(FIELD_VALIDFLAG, 26);
        fieldIndexMap.put(FIELD_VIEWPUBOBJ, 27);
        fieldIndexMap.put(FIELD_VLPUBOBJ, 28);
    }
}

